package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0560 ;
import cgd.gh.structures.messages.Bghm0561 ;
import cgd.gh.routines.Mghs015a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA DADOS DO PEDIDO CARREGADO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho056a extends CgdGhBaseOnline<Pgho056a.EnvelopeIn, Pgho056a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0560
     */
    public abstract Bghm0560 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0561
     */
    public abstract Bghm0561 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0560.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0561.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs015a
     */
    @Data
    protected abstract Mghs015a hrMghs015a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREAS DE TRABALHO COMUM    ***
     */
    @Data(size=3, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("097")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("080")
    protected ICondition progNaoExisteConta ;
    @Data
    @Condition("091")
    protected ICondition progDataMinInv ;
    @Data
    @Condition("092")
    protected ICondition progDataMaxInv ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    @Data
    @Condition("211")
    protected ICondition progAcesso ;
    
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    @Data(size=2, value="0")
    protected IInt wsQItens ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH01501")
    protected IString wsNmRecurso ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsCEibresp ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtMais ;
    @Data
    @Condition("1")
    protected ICondition naoHaMais ;
    @Data
    @Condition("2")
    protected ICondition haMais ;
    
    
    @Data(size=2, value="10")
    protected IInt wsLimite ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        /**
         * *----------------------------------------------------------------*
         */
        msgIn().msg().initialize() ;
        msgOut().msg().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        progOk.setTrue() ;
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs015a().bghl015a().initialize() ;
        hrMghs015a().bghl015a().consultar().setTrue() ;
        hrMghs015a().bghl015a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs015a().bghl015a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs015a().bghl015a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        if (msgIn().msg().ade().cPedInfOpps().isEqual("GH00105") || 
            msgIn().msg().ade().cPedInfOpps().isEqual("GH00106")) {
            hrMghs015a().bghl015a().argumento().nsRdclCont().set(9);
            hrMghs015a().bghl015a().argumento().vChkdCont().set(9);
            hrMghs015a().bghl015a().argumento().cTipoCont().set(9);
            hrMghs015a().bghl015a().argumento().nsDeposito().set(9);
            hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(" ");
        } else {
            hrMghs015a().bghl015a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
            hrMghs015a().bghl015a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
            hrMghs015a().bghl015a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
            hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
            hrMghs015a().bghl015a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        }
        hrMghs015a().bghl015a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
        hrMghs015a().bghl015a().argumento().zInicMov().set(msgIn().msg().ade().cZInicMov());
        hrMghs015a().bghl015a().argumento().zFimMov().set(msgIn().msg().ade().cZFimMov());
        hrMghs015a().run() ;
        if (!hrMghs015a().bghl015a().ok().isTrue()) {
            progStatus.set(hrMghs015a().bghl015a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs015a().bghl015a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00015");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().zPedido().set(hrMghs015a().bghl015a().detalhe().zPedido());
            msgOut().msg().ade().cEstPed().set(hrMghs015a().bghl015a().detalhe().cEstPedHist());
            msgOut().msg().ade().cCanlTrmzInf().set(hrMghs015a().bghl015a().detalhe().cCanlTrmzInf());
            msgOut().msg().ade().cEndcFtpDest().set(hrMghs015a().bghl015a().detalhe().cEndcFtpDest());
            msgOut().msg().ade().aAplDst().set(hrMghs015a().bghl015a().detalhe().aAplDest());
            msgOut().msg().ade().zCluzPed().set(hrMghs015a().bghl015a().detalhe().zCluzPed());
            msgOut().msg().ade().qDiasDpnzInf().set(hrMghs015a().bghl015a().detalhe().qDiaDpnzInf());
            msgOut().msg().ade().mParmPedHstMax().set(hrMghs015a().bghl015a().detalhe().mParmPedHstMax());
            msgOut().msg().ade().mParmPedHstMin().set(hrMghs015a().bghl015a().detalhe().mParmPedHstMin());
            msgOut().msg().ade().cParmPedHstMax().set(hrMghs015a().bghl015a().detalhe().cParmPedHstMax());
            msgOut().msg().ade().cParmPedHstMin().set(hrMghs015a().bghl015a().detalhe().cParmPedHstMin());
            msgOut().msg().ade().nmFichOutpRtno().set(hrMghs015a().bghl015a().detalhe().nmFichOutpRtno());
            msgOut().msg().ade().xMtvoDvlzPed().set(hrMghs015a().bghl015a().detalhe().xMtvoDvlzPed());
            msgOut().msg().ade().zEliminacaoPed().set(hrMghs015a().bghl015a().detalhe().zEliminacao());
            msgOut().msg().ade().cUsidCrix().set(hrMghs015a().bghl015a().detalhe().cUsidCrix());
            msgOut().msg().ade().cPaisIsoaOpex().set(hrMghs015a().bghl015a().detalhe().cPaisIsoaOeOpx());
            msgOut().msg().ade().cMnemEgcOpex().set(hrMghs015a().bghl015a().detalhe().cMnemEgcOpex());
            msgOut().msg().ade().cOeEgcOpex().set(hrMghs015a().bghl015a().detalhe().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
        if (!envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ase().cPaisIsoaCont().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaCont().cPaisIsoaContM().set(progStatus);
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        message.mensagem().headerR().transaccao().vizualizacao().setTrue() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
}
