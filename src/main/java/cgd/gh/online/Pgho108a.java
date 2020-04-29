package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
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
import cgd.gh.structures.messages.Bghm1080 ;
import cgd.gh.structures.messages.Bghm1081 ;
import cgd.na.online.Pnas541a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO ADICIONAL ASSOCIADA AO
 * MOVIMENTO QUANDO A APLICACAO ORIGEM E NA
 * CREDITO- ACESSO A PNAS541A
 * GH1446: 2014-07-14: ASTERISCADA A VALIDACAO DO NS-MOVIMENTO-C
 * NO INPUT PORQUE ESTE CAMPO E DE PAGINACAO,
 * POR ISSO NAO DEVE ESTAR PREENCHIDO NO
 * PRIMEIRO ACESSO A TRANSACAO.
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho108a extends CgdGhBaseOnline<Pgho108a.EnvelopeIn, Pgho108a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1080
     */
    public abstract Bghm1080 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1081
     */
    public abstract Bghm1081 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1080.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1081.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Services
     */
    /**
     * @return instancia da classe Pnas541a
     */
    protected abstract Pnas541a hoPnas541a() ;
    
    
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
    protected IInt wIndice ;
    
    
    
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
            msgIn().msg().ade().zMovimentoC().isEmpty() || 
            msgIn().msg().ade().nDocOpps().isEqual(0)) {
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
        hoPnas541a().msgIn().msg().ade().initialize() ;
        hoPnas541a().msgIn().msg().ade().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hoPnas541a().msgIn().msg().ade().cBancCont().set(msgIn().msg().ade().cBancCont());
        hoPnas541a().msgIn().msg().ade().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hoPnas541a().msgIn().msg().ade().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hoPnas541a().msgIn().msg().ade().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hoPnas541a().msgIn().msg().ade().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hoPnas541a().msgIn().msg().ade().zMovimentoC().set(msgIn().msg().ade().zMovimentoC());
        hoPnas541a().msgIn().msg().ade().nsMovimentoC().set(msgIn().msg().ade().nsMovimentoC());
        /**
         * MOVE ZEROS                    TO BNAM0540-NS-MOVIMENTO-C
         */
        hoPnas541a().msgIn().msg().ade().nReferencia().set(msgIn().msg().ade().nDocOpps());
        log(TraceLevel.Trace, "BNAM0540-ADE:", hoPnas541a().msgIn().msg().ade());
        hoPnas541a().run() ;
        log(TraceLevel.Trace, "BHTL001A-C-TIPO-ERRO-BBN-", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Trace, "BHTL001A-C-RTNO-EVEN-SWAL-", envOut.errosGraves().cRtnoEvenSwal());
        log(TraceLevel.Trace, "BHTL001A-C-SQLCODE-", envOut.db2Log().sqlca().cSqlcode());
        log(TraceLevel.Trace, "BHTL001A-NM-TABELA-", envOut.db2Log().nmTabela());
        log(TraceLevel.Trace, "BHTL001A-A-APL-ERR-", envOut.errosGraves().aAplErr());
        log(TraceLevel.Trace, "BNAM0541-ADE:", hoPnas541a().msgOut().msg().ade());
        if (envOut.errosGraves().semErros().isTrue() || envOut.errosGraves().fimConsulta().isTrue()) {
            msgOut().msg().ade().cPaisIsoaOpcr().set(hoPnas541a().msgOut().msg().ade().cPaisIsoaOpcr());
            msgOut().msg().ade().cBancOpcr().set(hoPnas541a().msgOut().msg().ade().cBancOpcr());
            msgOut().msg().ade().cOeEgcOpcr().set(hoPnas541a().msgOut().msg().ade().cOeEgcOpcr());
            msgOut().msg().ade().nsRdclOpcr().set(hoPnas541a().msgOut().msg().ade().nsRdclOpcr());
            log(TraceLevel.Error, "BGHM1081-NS-RDCL-OPCR-", msgOut().msg().ade().nsRdclOpcr());
            msgOut().msg().ade().vChkdOpcr().set(hoPnas541a().msgOut().msg().ade().vChkdOpcr());
            msgOut().msg().ade().cTipoContOpcr().set(hoPnas541a().msgOut().msg().ade().cTipoContOpcr());
            msgOut().msg().ade().cSitOpcr().set(hoPnas541a().msgOut().msg().ade().cSitOpcr());
            msgOut().msg().ade().cFamiProd().set(hoPnas541a().msgOut().msg().ade().cFamiProd());
            msgOut().msg().ade().cProduto().set(hoPnas541a().msgOut().msg().ade().cProduto());
            msgOut().msg().ade().cMoedIso().set(hoPnas541a().msgOut().msg().ade().cMoedIso());
            msgOut().msg().ade().linha().resetIndex() ;
            for (wIndice.set(1); wIndice.isLessOrEqual(22); wIndice.add(1)) {
                msgOut().msg().ade().linha().getCurrent().zMovimentoL().set(hoPnas541a().msgOut().msg().ade().linha().get(wIndice).zMovimentoL());
                msgOut().msg().ade().linha().getCurrent().nsMovimentoL().set(hoPnas541a().msgOut().msg().ade().linha().get(wIndice).nsMovimentoL());
                msgOut().msg().ade().linha().getCurrent().zValMovL().set(hoPnas541a().msgOut().msg().ade().linha().get(wIndice).zValMovL());
                msgOut().msg().ade().linha().getCurrent().cOpeBbnL().set(hoPnas541a().msgOut().msg().ade().linha().get(wIndice).cOpeBbnL());
                msgOut().msg().ade().linha().getCurrent().iDbcrL().set(hoPnas541a().msgOut().msg().ade().linha().get(wIndice).iDbcrL());
                msgOut().msg().ade().linha().getCurrent().mMovimentoL().set(hoPnas541a().msgOut().msg().ade().linha().get(wIndice).mMovimentoL());
                msgOut().msg().ade().linha().getCurrent().nsPrszOpcrL().set(hoPnas541a().msgOut().msg().ade().linha().get(wIndice).nsPrszOpcrL());
                msgOut().msg().ade().linha().incIndex() ;
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
        if (!envOut.errosGraves().semErros().isTrue() && !envOut.errosGraves().fimConsulta().isTrue()) {
            progNaoExisteInfAdic.setTrue() ;
            msgOut().msg().ase().cPaisIsoaOpcrSt().cPaisIsoaOpcr1().setTrue() ;
            envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
            msgOut().msg().ase().cPaisIsoaOpcrSt().cPaisIsoaOpcrM().set(progStatus);
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
}
