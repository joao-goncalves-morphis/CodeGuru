package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0540 ;
import cgd.gh.structures.messages.Bghm0541 ;
import cgd.gh.routines.Mghs015a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : LISTA PEDIDOS CARREGADOS ASSOCIADOS A SUBCONTA*
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho054a extends CgdGhBaseOnline<Pgho054a.EnvelopeIn, Pgho054a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0540
     */
    public abstract Bghm0540 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0541
     */
    public abstract Bghm0541 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0540.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0541.Msg msgOut() ;
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
    
    protected static final String WS_FIM_CONSULTA = "FC" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    @Data(size=2, value="0")
    protected IInt wsQItens ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH01801")
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
    
    
    @Data(size=4)
    protected IInt wsCrtOeDai ;
    
    /**
     * @return instancia da classe local WsCrtOeDaiMask
     */
    @Data
    @Mask
    protected abstract WsCrtOeDaiMask wsCrtOeDaiMask() ;
    
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
        msgOut().msg().ade().grPed().resetIndex() ;
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            wsCrtOeDai.set(message.mensagem().headerR().nrElectronico().cOeEgcOpex());
        }
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
        hrMghs015a().bghl015a().listarSubconta().setTrue() ;
        hrMghs015a().bghl015a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs015a().bghl015a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs015a().bghl015a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs015a().bghl015a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs015a().bghl015a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs015a().bghl015a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs015a().bghl015a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs015a().bghl015a().detalhe().tsPedido().set(msgIn().msg().ade().tsPedido());
        if (wsCrtOeDaiMask().oeDai().isTrue()) {
            hrMghs015a().bghl015a().detalhe().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
            hrMghs015a().bghl015a().detalhe().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
            hrMghs015a().bghl015a().detalhe().cOeEgcOpex().set(message.mensagem().headerR().nrElectronico().cOeEgcOpex());
        }
        hrMghs015a().run() ;
        if (!hrMghs015a().bghl015a().ok().isTrue()) {
            progStatus.set(hrMghs015a().bghl015a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs015a().bghl015a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00015");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs015a().bghl015a().qItens().isLessOrEqual(wsLimite)) {
                wsQItens.set(hrMghs015a().bghl015a().qItens());
            } else {
                wsQItens.set(wsLimite);
                haMais.setTrue() ;
            }
            for (hrMghs015a().bghl015a().tabela().lista().setIndex(1); hrMghs015a().bghl015a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs015a().bghl015a().tabela().lista().incIndex()) {
                hrMghs015a().bghl015a().argumento().set(hrMghs015a().bghl015a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs015a().bghl015a().detalhe().set(hrMghs015a().bghl015a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grPed().getCurrent().tsPedido().set(hrMghs015a().bghl015a().detalhe().tsPedido());
                msgOut().msg().ade().grPed().getCurrent().zInicMov().set(hrMghs015a().bghl015a().argumento().zInicMov());
                msgOut().msg().ade().grPed().getCurrent().zFimMov().set(hrMghs015a().bghl015a().argumento().zFimMov());
                msgOut().msg().ade().grPed().getCurrent().cPedInfOpps().set(hrMghs015a().bghl015a().argumento().cPedInfOpps());
                msgOut().msg().ade().grPed().incIndex() ;
            }
        }
        if (progOk.isTrue()) {
            if (haMais.isTrue()) {
                msgOut().msg().ade().iMsgCtnd().set("S");
                msgOut().msg().ade().tsPedidoK().set(hrMghs015a().bghl015a().detalhe().tsPedido());
            } else {
                msgOut().msg().ade().iMsgCtnd().set("N");
                envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
            }
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
        if (!envOut.errosGraves().semErros().isTrue() && !envOut.errosGraves().fimConsulta().isTrue()) {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(progStatus);
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
    /**
     * Inner Classes
     */
    public interface WsCrtOeDaiMask extends IDataMask {
        
        @Data(size=3)
        IInt wsOeOpex() ;
        @Data
        @Condition("920")
        ICondition oeDai() ;
        
        
        @Data(size=1)
        IInt wsOeResto() ;
        
    }
    
}
