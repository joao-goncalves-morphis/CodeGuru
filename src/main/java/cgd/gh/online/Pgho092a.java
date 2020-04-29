package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
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
import cgd.gh.structures.messages.Bghm0920 ;
import cgd.gh.structures.messages.Bghm0921 ;
import cgd.ho.routines.Mhoj352a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghs501a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA O LOCAL DA OPERACAO DE DETERMINADO
 * MOVIMENTO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho092a extends CgdGhBaseOnline<Pgho092a.EnvelopeIn, Pgho092a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0920
     */
    public abstract Bghm0920 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0921
     */
    public abstract Bghm0921 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0920.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0921.Msg msgOut() ;
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
     * @return instancia da classe Mhoj352a
     */
    @Data
    protected abstract Mhoj352a hrMhoj352a() ;
    
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mghs501a
     */
    @Data
    protected abstract Mghs501a hrMghs501a() ;
    
    
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
        log(TraceLevel.Trace, " **PGHO092A** ");
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
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().cTrnzIput().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().cTrnzIput().isEqual("GHIB")) {
                msgIn().msg().ade().hstActivo().setTrue() ;
            }
            if (!msgIn().msg().ade().hstActivo().isTrue() && !msgIn().msg().ade().hstNaoActivo().isTrue()) {
                progDadosInvalidos.setTrue() ;
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            }
        }
        log(TraceLevel.Trace, " BGHM0920-C-PAIS-ISOA-CONT = ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Trace, " BGHM0920-C-BANC-CONT = ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Trace, " BGHM0920-C-OE-EGC-CONT = ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Trace, " BGHM0920-NS-RDCL-CONT = ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Trace, " BGHM0920-C-MOED-ISO-SCTA = ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Trace, " BGHM0920-TS-MOVIMENTO = ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Trace, " BGHM0920-C-TRNZ-IPUT  = ", msgIn().msg().ade().cTrnzIput());
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        if (msgIn().msg().ade().hstActivo().isTrue()) {
            log(TraceLevel.Error, "A50000-TRATAR-HST-ACTIVO");
            a50000TratarHstActivo() ;
        } else {
            log(TraceLevel.Error, "A60000-TRATAR-HST-NAO-ACTIVO");
            a60000TratarHstNaoActivo() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a50000TratarHstActivo() {
        /**
         * *----------------------------------------------------------------*
         */
        a51000ConsultaGatcnsmov() ;
        if (progOk.isTrue()) {
            if (hrMghs003a().bghl003a().zHoje().isEqual(msgIn().msg().ade().tsMovimento().get(1, 10))) {
                log(TraceLevel.Error, " A52000-OBTEM-DADOS-HO");
                a52000ObtemDadosHo() ;
            } else {
                log(TraceLevel.Error, " A53000-OBTEM-DADOS-HST 1 ");
                hrMghs102a().bghl102a().initialize() ;
                hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
                a53000ObtemDadosHst() ;
                if (hrMghs102a().bghl102a().naoExiste().isTrue()) {
                    switch (hrMghs003a().bghl003a().detalhe().iEstRcrs().get()) {
                        case "I":
                            progNaoExisteMov.setTrue() ;
                            envOut.errosGraves().aAplErr().set(WS_APL_HST);
                            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                            break;
                        case "A":
                            log(TraceLevel.Error, " A53000-OBTEM-DADOS-HST 2 ");
                            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
                            a53000ObtemDadosHst() ;
                            break;
                        case "H":
                            log(TraceLevel.Error, " A55000-OBTEM-DADOS-HO-ONTEM ");
                            a55000ObtemDadosHoOntem() ;
                            break;
                        default :
                            break ;
                    }
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ConsultaGatcnsmov() {
        /**
         * *----------------------------------------------------------------*
         */
        log(TraceLevel.Trace, " A51000-CONSULTA-GATCNSMOV ");
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set("TGH00022");
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set("I");
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00003");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000ObtemDadosHo() {
        /**
         * *----------------------------------------------------------------*
         */
        a52500PreencheA352() ;
        hrMhoj352a().bhol352a().commarea().dadosInput().iMovDia().set("S");
        log(TraceLevel.Trace, "BHOL352A-I-MOV-DIA-", hrMhoj352a().bhol352a().commarea().dadosInput().iMovDia());
        hrMhoj352a().run() ;
        if (!hrMhoj352a().bhol352a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj352a().bhol352a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj352a().bhol352a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj352a().bhol352a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj352a().bhol352a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj352a().bhol352a().commarea().dadosErro().aAplErr());
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().cTipoCanlAces().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cTipoCanlAces());
            msgOut().msg().ade().cPaisIsoaOeOpx().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cPaisIsoaOeOpx());
            msgOut().msg().ade().cMnemEgcOpex().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cMnemEgcOpex());
            msgOut().msg().ade().cOeEgcOpex().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52500PreencheA352() {
        /**
         * *----------------------------------------------------------------*
         */
        log(TraceLevel.Trace, "A52500-PREENCHE-A352 ");
        hrMhoj352a().bhol352a().commarea().initialize() ;
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj352a().bhol352a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a53000ObtemDadosHst() {
        hrMghs102a().bghl102a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs102a().run() ;
        log(TraceLevel.Trace, "MGH102A-C-RETORNO-", hrMghs102a().bghl102a().cRetorno());
        if (!hrMghs102a().bghl102a().ok().isTrue() && !hrMghs102a().bghl102a().naoExiste().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().cTipoCanlAces().set(hrMghs102a().bghl102a().detalhe().cTipoCanlAces());
            msgOut().msg().ade().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            msgOut().msg().ade().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            msgOut().msg().ade().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000ObtemDadosHoOntem() {
        /**
         * *----------------------------------------------------------------*
         */
        a52500PreencheA352() ;
        hrMhoj352a().bhol352a().commarea().dadosInput().iMovDia().set("N");
        hrMhoj352a().run() ;
        if (!hrMhoj352a().bhol352a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj352a().bhol352a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj352a().bhol352a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj352a().bhol352a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj352a().bhol352a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj352a().bhol352a().commarea().dadosErro().aAplErr());
        }
        /**
         * --> ACESSO AO MHOJ352A
         */
        if (progOk.isTrue()) {
            msgOut().msg().ade().cTipoCanlAces().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cTipoCanlAces());
            msgOut().msg().ade().cPaisIsoaOeOpx().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cPaisIsoaOeOpx());
            msgOut().msg().ade().cMnemEgcOpex().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cMnemEgcOpex());
            msgOut().msg().ade().cOeEgcOpex().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a60000TratarHstNaoActivo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs501a().bghl501a().initialize() ;
        hrMghs501a().bghl501a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs501a().bghl501a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs501a().bghl501a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs501a().bghl501a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs501a().bghl501a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs501a().bghl501a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs501a().bghl501a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs501a().bghl501a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs501a().bghl501a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs501a().bghl501a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs501a().bghl501a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs501a().run() ;
        if (!hrMghs501a().bghl501a().ok().isTrue() && !hrMghs501a().bghl501a().naoExiste().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs501a().bghl501a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().cTipoCanlAces().set(hrMghs501a().bghl501a().detalhe().cTipoCanlAces());
            msgOut().msg().ade().cPaisIsoaOeOpx().set(hrMghs501a().bghl501a().detalhe().cPaisIsoaOeOpx());
            msgOut().msg().ade().cMnemEgcOpex().set(hrMghs501a().bghl501a().detalhe().cMnemEgcOpex());
            msgOut().msg().ade().cOeEgcOpex().set(hrMghs501a().bghl501a().detalhe().cOeEgcOpex());
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
        log(TraceLevel.Trace, " S70000-RESPONDER ");
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
