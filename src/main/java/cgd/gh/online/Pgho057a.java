package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
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
import cgd.gh.structures.messages.Bghm0570 ;
import cgd.gh.structures.messages.Bghm0571 ;
import cgd.gh.routines.Mghs018a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA DADOS DO CODIGO DO PEDIDO INFORMACAO
 * (TGH00018_PEDINF)
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho057a extends CgdGhBaseOnline<Pgho057a.EnvelopeIn, Pgho057a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0570
     */
    public abstract Bghm0570 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0571
     */
    public abstract Bghm0571 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0570.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0571.Msg msgOut() ;
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
     * @return instancia da classe Mghs018a
     */
    @Data
    protected abstract Mghs018a hrMghs018a() ;
    
    
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
    
    @Data(size=8, value="VGH01801")
    protected IString wsNmRecurso ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsCEibresp ;
    
    
    
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
    protected void s30000Validar() {
        /**
         * *----------------------------------------------------------------*
         */
        if (msgIn().msg().ade().cPedInfOpps().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
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
        hrMghs018a().bghl018a().initialize() ;
        hrMghs018a().bghl018a().consultar().setTrue() ;
        hrMghs018a().bghl018a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
        hrMghs018a().run() ;
        if (!hrMghs018a().bghl018a().ok().isTrue()) {
            progStatus.set(hrMghs018a().bghl018a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs018a().bghl018a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00018");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().dPedInfOpps().set(hrMghs018a().bghl018a().detalhe().dPedInfOpps());
            msgOut().msg().ade().cFrmtInf().set(hrMghs018a().bghl018a().detalhe().cFrmtInf());
            msgOut().msg().ade().cTipoRpte().set(hrMghs018a().bghl018a().detalhe().cTipoRpte());
            msgOut().msg().ade().nmFichOutpRtno().set(hrMghs018a().bghl018a().detalhe().nmFichOutpRtno());
            msgOut().msg().ade().qDiaDpnzInf().set(hrMghs018a().bghl018a().detalhe().qDiaDpnzInf());
            msgOut().msg().ade().cUsidActzUlt().set(hrMghs018a().bghl018a().detalhe().cUsidActzUlt());
            msgOut().msg().ade().tsActzUlt().set(hrMghs018a().bghl018a().detalhe().tsActzUlt());
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
            msgOut().msg().ase().cPedInfOpps().cPedInfOpps1().setTrue() ;
            msgOut().msg().ase().cPedInfOpps().cPedInfOppsM().set(progStatus);
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
            s30000Validar() ;
        }
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
}
