package cgd.gh.online;

import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
import cgd.gh.structures.messages.Bghm1070 ;
import cgd.gh.structures.messages.Bghm1071 ;
import cgd.gh.routines.Mghs310a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA DOS TIPO DE HISTORICOS ASSOCIADOS
 * A CONTA
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho107a extends CgdGhBaseOnline<Pgho107a.EnvelopeIn, Pgho107a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1070
     */
    public abstract Bghm1070 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1071
     */
    public abstract Bghm1071 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1070.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1071.Msg msgOut() ;
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
     * @return instancia da classe Mghs310a
     */
    @Data
    protected abstract Mghs310a hrMghs310a() ;
    
    
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
    @Condition("067")
    protected ICondition progNaoExisteInfAdic ;
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
    protected IInt wsIndice ;
    
    @Data(size=2, value="0")
    protected IInt wsIndex ;
    
    /**
     * @return instancia da classe local WsDataToday
     */
    @Data
    protected abstract WsDataToday wsDataToday() ;
    
    /**
     * @return instancia da classe local WsDataDia
     */
    @Data
    protected abstract WsDataDia wsDataDia() ;
    
    
    
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
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            wsDataToday().set(getTimeAsLong());
            wsDataDia().wAnoData().set(wsDataToday().wsAnoToday());
            wsDataDia().wMesData().set(wsDataToday().wsMesToday());
            wsDataDia().wDiaData().set(wsDataToday().wsDiaToday());
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
        hrMghs310a().bghl310a().initialize() ;
        hrMghs310a().bghl310a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs310a().bghl310a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs310a().bghl310a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs310a().bghl310a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs310a().bghl310a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs310a().bghl310a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs310a().bghl310a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs310a().bghl310a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs310a().bghl310a().argumento().zaInicio().set(msgIn().msg().ade().zaInicio());
        hrMghs310a().run() ;
        if (!hrMghs310a().bghl310a().ok().isTrue()) {
            progStatus.set(hrMghs310a().bghl310a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs310a().bghl310a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00010");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().grHst().resetIndex() ;
            for (hrMghs310a().bghl310a().tabela().lista().setIndex(1); hrMghs310a().bghl310a().tabela().lista().index().isLessOrEqual(hrMghs310a().bghl310a().qItens()) && progStatus.isLessOrEqual(0); hrMghs310a().bghl310a().tabela().lista().incIndex()) {
                hrMghs310a().bghl310a().argumento().set(hrMghs310a().bghl310a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs310a().bghl310a().detalhe().set(hrMghs310a().bghl310a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grHst().getCurrent().cMoedIsoScta().set(hrMghs310a().bghl310a().argumento().cMoedIsoScta());
                msgOut().msg().ade().grHst().getCurrent().nsDeposito().set(hrMghs310a().bghl310a().argumento().nsDeposito());
                if (hrMghs310a().bghl310a().argumento().nmRecurso().isEqual("VGH00201")) {
                    msgOut().msg().ade().grHst().getCurrent().xNmRecurso().set("ACTIVO");
                } else if (hrMghs310a().bghl310a().argumento().nmRecurso().get(1, 3).isEqual("VGH")) {
                    msgOut().msg().ade().grHst().getCurrent().xNmRecurso().set("NORMAL");
                } else {
                    msgOut().msg().ade().grHst().getCurrent().xNmRecurso().set("INACTIVO");
                }
                msgOut().msg().ade().grHst().getCurrent().zaInicio().set(hrMghs310a().bghl310a().argumento().zaInicio());
                msgOut().msg().ade().grHst().getCurrent().zaFim().set(hrMghs310a().bghl310a().detalhe().zaFim());
                msgOut().msg().ade().grHst().incIndex() ;
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
        if (envOut.errosGraves().semErros().isTrue()) {
            if (hrMghs310a().bghl310a().qItens().isLess(11)) {
                envOut.errosGraves().fimConsulta().setTrue() ;
            }
        } else {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(progStatus);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
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
    /**
     * Inner Classes
     */
    public interface WsDataToday extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoToday() ;
        
        @Data(size=2)
        IInt wsMesToday() ;
        
        @Data(size=2)
        IInt wsDiaToday() ;
        
    }
    public interface WsDataDia extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesData() ;
        
        @Data(size=2, lpadding=1, rpadding=1, lpaddingValue="-", rpaddingValue="-")
        IInt wDiaData() ;
        
    }
    
}
