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
import cgd.gh.structures.messages.Bghm0510 ;
import cgd.gh.structures.messages.Bghm0511 ;
import cgd.gh.routines.Mghs001a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA DADOS DA SUBCONTA EM HISTORICO DE
 * MOVIMENTTOS
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho051a extends CgdGhBaseOnline<Pgho051a.EnvelopeIn, Pgho051a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0510
     */
    public abstract Bghm0510 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0511
     */
    public abstract Bghm0511 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0510.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0511.Msg msgOut() ;
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
     * @return instancia da classe Mghs001a
     */
    @Data
    protected abstract Mghs001a hrMghs001a() ;
    
    
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
    
    @Data(size=8, value="VGH00101")
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
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty()) {
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
        hrMghs001a().bghl001a().initialize() ;
        hrMghs001a().bghl001a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs001a().bghl001a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs001a().bghl001a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs001a().bghl001a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs001a().bghl001a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs001a().bghl001a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs001a().bghl001a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs001a().bghl001a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs001a().run() ;
        if (!hrMghs001a().bghl001a().ok().isTrue()) {
            progStatus.set(hrMghs001a().bghl001a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs001a().bghl001a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00001");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().iActivo().set(hrMghs001a().bghl001a().detalhe().iActivo());
            msgOut().msg().ade().cMoedIsoAntEur().set(hrMghs001a().bghl001a().detalhe().cMoedIsoAntEur());
            msgOut().msg().ade().zAbraCont().set(hrMghs001a().bghl001a().detalhe().zAbraCont());
            msgOut().msg().ade().zCcltCont().set(hrMghs001a().bghl001a().detalhe().zCcltCont());
            msgOut().msg().ade().zRabtCont().set(hrMghs001a().bghl001a().detalhe().zRabtCont());
            msgOut().msg().ade().zRabtContCcld().set(hrMghs001a().bghl001a().detalhe().zRabtContCcld());
            msgOut().msg().ade().zMovHistUlt().set(hrMghs001a().bghl001a().detalhe().zMovHistUlt());
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
            s30000Validar() ;
        }
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
}
