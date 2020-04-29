package cgd.gh.online;

import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
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
import cgd.gh.structures.messages.Bghm1030 ;
import cgd.gh.structures.messages.Bghm1031 ;
import cgd.ho.routines.Mhoj356a ;
import cgd.gh.routines.Mghs102a ;
import cgd.hr.routines.Mhrj500a ;
import cgd.ho.routines.Mhoj022a ;
import cgd.gh.routines.Mghs902a ;
import cgd.pp.routines.Mppj500a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO ADICIONAL ASSOCIADA AO
 * MOVIMENTO DE TRANSFERENCIAS-HR
 * PROCESSO : GH1951 (GH1927)                DATA: 2016-05-27
 * DESCRICAO: CRIACAO DE DOIS NOVOS CAMPOS PARA USO EXCLUSIVO
 * : PELA APLICACAO PP (SOBRE OS QUAIS NAO SERA
 * : APLICADA DESENCRIPTACAO)
 * ALTERACAO: ALTERACAO DA OBTENCAO DA CHAVE JOURNAL, DE ACORDO
 * COM O DIA DO MOVIMENTO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho103a extends CgdGhBaseOnline<Pgho103a.EnvelopeIn, Pgho103a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1030
     */
    public abstract Bghm1030 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1031
     */
    public abstract Bghm1031 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1030.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1031.Msg msgOut() ;
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
     * @return instancia da classe Mhoj356a
     */
    @Data
    protected abstract Mhoj356a hrMhoj356a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mhrj500a
     */
    @Data
    protected abstract Mhrj500a hrMhrj500a() ;
    
    /**
     * @return instancia da classe Mhoj022a
     */
    @Data
    protected abstract Mhoj022a hrMhoj022a() ;
    
    /**
     * @return instancia da classe Mghs902a
     */
    @Data
    protected abstract Mghs902a hrMghs902a() ;
    
    /**
     * @return instancia da classe Mppj500a
     */
    @Data
    protected abstract Mppj500a hrMppj500a() ;
    
    
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
    
    protected static final String CON_BALC = "BALC" ;
    
    @Data(size=2, value="0")
    protected IInt wIndice ;
    
    /**
     * @return instancia da classe local WsDataToday
     */
    @Data
    protected abstract WsDataToday wsDataToday() ;
    
    /**
     * @return instancia da classe local WsVariavel
     */
    @Data
    protected abstract WsVariavel wsVariavel() ;
    
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
        log(TraceLevel.Debug, "S10000-INICIAR");
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
        log(TraceLevel.Debug, "S30000-VALIDAR");
        log(TraceLevel.Debug, "BGHM1030-C-PAIS-ISOA-CONT:", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "BGHM1030-C-BANC-CONT:", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "BGHM1030-C-OE-EGC-CONT:", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "BGHM1030-NS-RDCL-CONT:", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "BGHM1030-TS-MOVIMENTO :", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "BGHM1030-NS-MOVIMENTO:", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "BGHM1030-C-TRNZ-IPUT :", msgIn().msg().ade().cTrnzIput());
        log(TraceLevel.Debug, "BGHM1030-I-DBCR:", msgIn().msg().ade().iDbcr());
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().nsMovimento().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            log(TraceLevel.Debug, "PROG-DADOS-INVALIDOS");
        }
        /**
         * *..........
         */
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
        log(TraceLevel.Debug, "S50000-PROCESSAR");
        log(TraceLevel.Debug, "DATA:", msgIn().msg().ade().tsMovimento().get(1, 10));
        log(TraceLevel.Debug, "BHTL001A-C-TIPO-CANL-ACES:", message.mensagem().headerR().transaccao().cTipoCanlAces());
        if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsDataDia()) && 
            !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALC)) {
            a52110ObtemJournHo() ;
        } else {
            a51000ObtemChaveJourn() ;
        }
        /**
         * *.........
         */
        if (progOk.isTrue()) {
            switch (msgIn().msg().ade().aAplOrig().get()) {
                case "HR":
                    log(TraceLevel.Debug, "MOVIMENTO  HR");
                    a52000AcedeHr() ;
                    if (progOk.isTrue() && 
                        hrMhrj500a().bhrl500a().commarea().dadosOutput().qTrfcDstn().isEqual(0)) {
                        if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsDataDia())) {
                            a53000AcedeMhoj022a() ;
                        } else {
                            a54000AcedeMghs902a() ;
                        }
                        /**
                         * .....
                         */
                        if (progOk.isTrue()) {
                            /**
                             * ...ACEDE A PP EM MODO HR
                             */
                            a55000AcedeMppj500aHr() ;
                        }
                    }
                    break;
                case "PP":
                    log(TraceLevel.Debug, "MOVIMENTO  PP");
                    if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsDataDia())) {
                        a53000AcedeMhoj022a() ;
                    } else {
                        a54000AcedeMghs902a() ;
                    }
                    /**
                     * ...........
                     */
                    if (progOk.isTrue()) {
                        /**
                         * ...ACEDE A PP EM MODO PP
                         */
                        a55001AcedeMppj500aPp() ;
                    }
                    break;
                default :
                    progDadosInvalidos.setTrue() ;
                    envOut.errosGraves().aAplErr().set(WS_APL_HST);
                    envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                    log(TraceLevel.Debug, "APLICACAO INVALIDA");
                    break;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ObtemChaveJourn() {
        log(TraceLevel.Debug, "A51000-OBTEM-CHAVE-JOURN");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        hrMghs102a().bghl102a().criterioConsulta().crtJour().setTrue() ;
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
        log(TraceLevel.Debug, "BGHM1030-C-PAIS-ISOA-CONT:", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "BGHM1030-C-BANC-CONT     :", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "BGHM1030-C-OE-EGC-CONT   :", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "BGHM1030-NS-RDCL-CONT    :", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "BGHM1030-V-CHKD-CONT     :", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "BGHM1030-C-TIPO-CONT     :", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "BGHM1030-C-MOED-ISO-SCTA :", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "BGHM1030-NS-DEPOSITO     :", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "BGHM1030-TS-MOVIMENTO    :", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "BGHM1030-NS-MOVIMENTO    :", msgIn().msg().ade().nsMovimento());
        hrMghs102a().run() ;
        if (hrMghs102a().bghl102a().naoExiste().isTrue()) {
            log(TraceLevel.Debug, "NAO EXISTE REG NA MGHS102A VOU VER JOURN HO");
            if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsDataDia())) {
                a52110ObtemJournHo() ;
            } else {
                log(TraceLevel.Debug, "NAO EXISTE REG NA JOURNAL");
                progNaoExisteMov.setTrue() ;
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
                envOut.db2Log().nmTabela().set("TGH00102");
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
            }
        }
        if (!hrMghs102a().bghl102a().naoExiste().isTrue() && !hrMghs102a().bghl102a().ok().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            log(TraceLevel.Debug, "ERRODB2");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52110ObtemJournHo() {
        log(TraceLevel.Debug, "A52110-OBTEM-JOURN-HO");
        hrMhoj356a().bhol356a().commarea().initialize() ;
        hrMhoj356a().bhol356a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj356a().bhol356a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "BGHM1030-C-PAIS-ISOA-CONT:", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "BGHM1030-C-BANC-CONT     :", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "BGHM1030-C-OE-EGC-CONT   :", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "BGHM1030-NS-RDCL-CONT    :", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "BGHM1030-V-CHKD-CONT     :", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "BGHM1030-C-TIPO-CONT     :", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "BGHM1030-C-MOED-ISO-SCTA :", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "BGHM1030-NS-DEPOSITO     :", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "BGHM1030-NS-MOVIMENTO    :", msgIn().msg().ade().nsMovimento());
        hrMhoj356a().run() ;
        if (!hrMhoj356a().bhol356a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj356a().bhol356a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj356a().bhol356a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj356a().bhol356a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj356a().bhol356a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj356a().bhol356a().commarea().dadosErro().aAplErr());
        }
        if (progOk.isTrue()) {
            hrMghs102a().bghl102a().initialize() ;
            hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cPaisIsoaOeOpx());
            hrMghs102a().bghl102a().detalhe().cMnemEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cMnemEgcOpex());
            hrMghs102a().bghl102a().detalhe().cOeEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cOeEgcOpex());
            hrMghs102a().bghl102a().detalhe().cUserid().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cUserid());
            hrMghs102a().bghl102a().detalhe().nJourBbn().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nJourBbn());
            hrMghs102a().bghl102a().detalhe().nsJourBbn().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nsJourBbn());
            hrMghs102a().bghl102a().detalhe().nsJourBbnDtlh().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nsJourBbnDtlh());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000AcedeHr() {
        log(TraceLevel.Debug, "A52000-ACEDE-HR");
        hrMhrj500a().bhrl500a().commarea().initialize() ;
        hrMhrj500a().bhrl500a().commarea().dadosInput().iDbcr().set(msgIn().msg().ade().iDbcr());
        hrMhrj500a().bhrl500a().commarea().dadosInput().zProcessamento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        hrMhrj500a().bhrl500a().commarea().dadosInput().cPaisIsoaOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
        hrMhrj500a().bhrl500a().commarea().dadosInput().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
        hrMhrj500a().bhrl500a().commarea().dadosInput().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        hrMhrj500a().bhrl500a().commarea().dadosInput().cUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
        hrMhrj500a().bhrl500a().commarea().dadosInput().nJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
        hrMhrj500a().bhrl500a().commarea().dadosInput().tipoOperacao().set(" ");
        hrMhrj500a().bhrl500a().commarea().dadosInput().qOccursIn().set(3);
        hrMhrj500a().bhrl500a().commarea().dadosInput().chaveCont().set(msgIn().msg().ade().chaveCont());
        log(TraceLevel.Debug, "BHRL500A-Z-PROCESSAMENTO:", hrMhrj500a().bhrl500a().commarea().dadosInput().zProcessamento());
        log(TraceLevel.Debug, "BHRL500A-C-PAIS-ISOA-OPX:", hrMhrj500a().bhrl500a().commarea().dadosInput().cPaisIsoaOpx());
        log(TraceLevel.Debug, "BHRL500A-C-MNEM-EGC-OPEX:", hrMhrj500a().bhrl500a().commarea().dadosInput().cMnemEgcOpex());
        log(TraceLevel.Debug, "BHRL500A-C-OE-EGC-OPEX  :", hrMhrj500a().bhrl500a().commarea().dadosInput().cOeEgcOpex());
        log(TraceLevel.Debug, "BHRL500A-C-USERID       :", hrMhrj500a().bhrl500a().commarea().dadosInput().cUserid());
        log(TraceLevel.Debug, "BHRL500A-N-JOUR-BBN     :", hrMhrj500a().bhrl500a().commarea().dadosInput().nJourBbn());
        log(TraceLevel.Debug, "BHRL500A-TIPO-OPERACAO  :", hrMhrj500a().bhrl500a().commarea().dadosInput().tipoOperacao());
        log(TraceLevel.Debug, "BHRL500A-Q-OCCURS-IN    :", hrMhrj500a().bhrl500a().commarea().dadosInput().qOccursIn());
        log(TraceLevel.Debug, "BHRL500A-CHAVE-CONT     :", hrMhrj500a().bhrl500a().commarea().dadosInput().chaveCont());
        hrMhrj500a().run() ;
        /**
         * *..........
         */
        if (hrMhrj500a().bhrl500a().commarea().dadosErro().semErros().isTrue() || hrMhrj500a().bhrl500a().commarea().dadosErro().fimConsulta().isTrue()) {
            log(TraceLevel.Debug, "LI MHRJ500A MODO HR");
        } else {
            progStatus.set(hrMhrj500a().bhrl500a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhrj500a().bhrl500a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhrj500a().bhrl500a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhrj500a().bhrl500a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhrj500a().bhrl500a().commarea().dadosErro().aAplErr());
            log(TraceLevel.Debug, "BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
            log(TraceLevel.Debug, "BHTL001A-C-RTNO-EVEN-SWAL:", envOut.errosGraves().cRtnoEvenSwal());
        }
        /**
         * *............
         */
        if (progOk.isTrue()) {
            if (hrMhrj500a().bhrl500a().commarea().dadosErro().fimConsulta().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(hrMhrj500a().bhrl500a().commarea().dadosErro().cTipoErroBbn());
            }
            log(TraceLevel.Debug, "LI MHRJ500A");
            msgOut().msg().ade().iFchoCpszUrgt().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().iFchoCpszUrgt());
            msgOut().msg().ade().cServSibsTei().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().cServSibsTei());
            msgOut().msg().ade().dServSibsTei().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().dServSibsTei());
            msgOut().msg().ade().cOpeSibs().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().cOpeSibs());
            msgOut().msg().ade().dOpeSibs().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().dOpeSibs());
            msgOut().msg().ade().cEndcSwifOrdn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().cEndcSwifOrdn());
            msgOut().msg().ade().cIbanOrdn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().cIbanOrdn());
            msgOut().msg().ade().nmOrdn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().nmOrdn());
            msgOut().msg().ade().nmOrdnPp().set(" ");
            log(TraceLevel.Debug, "BGHM1031-NM-ORDN   : ", msgOut().msg().ade().nmOrdn());
            log(TraceLevel.Debug, "BGHM1031-NM-ORDN-PP: ", msgOut().msg().ade().nmOrdnPp());
            msgOut().msg().ade().qTrfcDstn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().qTrfcDstn());
            msgOut().msg().ade().iTrfcDstnExced().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().iTrfcDstnExced());
            msgOut().msg().ade().chaveContOut().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().chaveContOut());
        }
        msgOut().msg().ade().tabDstnTrfc().resetIndex() ;
        for (hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().setIndex(1); hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().index().isLessOrEqual(3); hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().incIndex()) {
            msgOut().msg().ade().tabDstnTrfc().getCurrent().cEndcSwifDstn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().cEndcSwifDstn());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().cIbanDstn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().cIbanDstn());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().cMoedContDstn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().cMoedContDstn());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().nmDstn());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstnPp().set(" ");
            log(TraceLevel.Debug, "BGHM1031-NM-DSTN(BGHM1031-I-DSTN)   : ", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn());
            log(TraceLevel.Debug, "BGHM1031-NM-DSTN-PP(BGHM1031-I-DSTN): ", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstnPp());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().mMovOrdDstn().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().mMovOrdDstn());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().xRefMovOrnSibs().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().xRefMovOrnSibs());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().cMtvoDvlzSepa().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().cMtvoDvlzSepa());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().xMtvoTrnzSepa().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().xMtvoTrnzSepa());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().cCatgMtvTrfIso().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().cCatgMtvTrfIso());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().dCatgMtvTrfIso().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().dCatgMtvTrfIso());
            msgOut().msg().ade().tabDstnTrfc().getCurrent().xInfAdiSepa().set(hrMhrj500a().bhrl500a().commarea().dadosOutput().tabDstnTrfc().getCurrent().xInfAdiSepa());
            msgOut().msg().ade().tabDstnTrfc().incIndex() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53000AcedeMhoj022a() {
        log(TraceLevel.Debug, "A53000-ACEDE-MHOJ022A");
        hrMhoj022a().bhol022a().commarea().initialize() ;
        hrMhoj022a().bhol022a().commarea().dadosInput().modoMov().setTrue() ;
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cPaisIsoaContI().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cBancContI().set(msgIn().msg().ade().cBancCont());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cOeEgcContI().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().nsRdclContI().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().vChkdContI().set(msgIn().msg().ade().vChkdCont());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cTipoContI().set(msgIn().msg().ade().cTipoCont());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cMoedIsoSctaI().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().nsDepositoI().set(msgIn().msg().ade().nsDeposito());
        hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().nsMovimentoI().set(msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "  BHOL022A-C-PAIS-ISOA-CONT-I:", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cPaisIsoaContI());
        log(TraceLevel.Debug, "  BHOL022A-C-BANC-CONT-I     :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cBancContI());
        log(TraceLevel.Debug, "  BHOL022A-C-OE-EGC-CONT-I   :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cOeEgcContI());
        log(TraceLevel.Debug, "  BHOL022A-NS-RDCL-CONT-I    :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().nsRdclContI());
        log(TraceLevel.Debug, "  BHOL022A-V-CHKD-CONT-I     :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().vChkdContI());
        log(TraceLevel.Debug, "  BHOL022A-C-TIPO-CONT-I     :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cTipoContI());
        log(TraceLevel.Debug, "  BHOL022A-C-MOED-ISO-SCTA-I :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().cMoedIsoSctaI());
        log(TraceLevel.Debug, "  BHOL022A-NS-DEPOSITO-I     :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().nsDepositoI());
        log(TraceLevel.Debug, "  BHOL022A-NS-MOVIMENTO-I    :", hrMhoj022a().bhol022a().commarea().dadosInput().chaveMovimento().nsMovimentoI());
        hrMhoj022a().run() ;
        if (hrMhoj022a().bhol022a().commarea().dadosErro().semErros().isTrue() || hrMhoj022a().bhol022a().commarea().dadosErro().fimConsulta().isTrue()) {
            log(TraceLevel.Debug, "LI MHOJ022A");
        } else {
            log(TraceLevel.Debug, "  BHOL022A-A-APL-ERR   :", hrMhoj022a().bhol022a().commarea().dadosErro().aAplErr());
            log(TraceLevel.Debug, "  BHOL022A-C-RTNO-EVEN-SWAL:", hrMhoj022a().bhol022a().commarea().dadosErro().cRtnoEvenSwal());
            progStatus.set(hrMhoj022a().bhol022a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj022a().bhol022a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj022a().bhol022a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj022a().bhol022a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj022a().bhol022a().commarea().dadosErro().aAplErr());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a54000AcedeMghs902a() {
        log(TraceLevel.Debug, "A54000-ACEDE-MGHS902A");
        hrMghs902a().bghl902a().initialize() ;
        hrMghs902a().bghl902a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs902a().bghl902a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs902a().bghl902a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs902a().bghl902a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs902a().bghl902a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs902a().bghl902a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs902a().bghl902a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs902a().bghl902a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs902a().bghl902a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs902a().bghl902a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs902a().bghl902a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "  MGH902A-C-PAIS-ISOA-CONT:", hrMghs902a().bghl902a().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, "  MGH902A-C-BANC-CONT     :", hrMghs902a().bghl902a().argumento().cBancCont());
        log(TraceLevel.Debug, "  MGH902A-C-OE-EGC-CONT   :", hrMghs902a().bghl902a().argumento().cOeEgcCont());
        log(TraceLevel.Debug, "  MGH902A-NS-RDCL-CONT    :", hrMghs902a().bghl902a().argumento().nsRdclCont());
        log(TraceLevel.Debug, "  MGH902A-V-CHKD-CONT     :", hrMghs902a().bghl902a().argumento().vChkdCont());
        log(TraceLevel.Debug, "  MGH902A-C-TIPO-CONT     :", hrMghs902a().bghl902a().argumento().cTipoCont());
        log(TraceLevel.Debug, "  MGH902A-C-MOED-ISO-SCTA :", hrMghs902a().bghl902a().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, "  MGH902A-NS-DEPOSITO     :", hrMghs902a().bghl902a().argumento().nsDeposito());
        log(TraceLevel.Debug, "  MGH902A-TS-MOVIMENTO    :", hrMghs902a().bghl902a().argumento().tsMovimento());
        log(TraceLevel.Debug, "  MGH902A-NS-MOVIMENTO    :", hrMghs902a().bghl902a().argumento().nsMovimento());
        hrMghs902a().run() ;
        if (!hrMghs902a().bghl902a().ok().isTrue()) {
            log(TraceLevel.Debug, "ERRO NA MGHS902A");
            log(TraceLevel.Debug, "  MGH902A-C-SQLCODE:", hrMghs902a().bghl902a().cSqlcode());
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs902a().bghl902a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00002");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000AcedeMppj500aHr() {
        log(TraceLevel.Debug, "A55000-ACEDE-MPPJ500A-HR");
        hrMppj500a().bppl500a().commarea().initialize() ;
        wsVariavel().initialize() ;
        /**
         * MOVE BGHM1030-I-DBCR          TO BPPL500A-I-DBCR
         * MOVE SPACES                   TO BPPL500A-TIPO-OPERACAO
         * MOVE 3                        TO BPPL500A-Q-OCCURS-IN
         */
        hrMppj500a().bppl500a().commarea().dadosInput().aplicacao().set("HR");
        hrMppj500a().bppl500a().commarea().dadosInput().zProcessamento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        hrMppj500a().bppl500a().commarea().dadosInput().cPaisIsoaOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
        hrMppj500a().bppl500a().commarea().dadosInput().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
        hrMppj500a().bppl500a().commarea().dadosInput().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        hrMppj500a().bppl500a().commarea().dadosInput().cUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
        hrMppj500a().bppl500a().commarea().dadosInput().nJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
        hrMppj500a().bppl500a().commarea().dadosInput().cIdioIso().set(message.mensagem().headerR().seguranca().cIdioIso());
        /**
         * MOVE BGHM1030-CHAVE-CONT      TO BPPL500A-CHAVE-CONT
         * .........CHAVE DE CONTINUACAO -LOCAL-HR
         */
        hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().cPaisIsoAlfnC().set(msgIn().msg().ade().chaveCont().cPaisIsoaTrfcCh());
        /**
         * **   MOVE BGHM1030-Z-PROCESSAMENTO-CH(1:3)
         * **                                 TO BPPL500A-C-MNEM-EMP-GCX-C
         */
        wsVariavel().wsChaveGhAuxC().wsCBancTrfcCh().set(msgIn().msg().ade().chaveCont().cBancTrfcCh());
        wsVariavel().wsChaveGhAuxC().wsZaOrdTrfcCh().set(msgIn().msg().ade().chaveCont().zaOrdTrfcCh());
        wsVariavel().wsChaveGhAuxC().wsNsOrdTrfcCh().set(msgIn().msg().ade().chaveCont().nsOrdTrfcCh());
        wsVariavel().wsChaveGhAuxC().wsNsIstzDstnTrfcCh().set(msgIn().msg().ade().chaveCont().nsIstzDstnTrfcCh());
        wsVariavel().wsChavePpAuxC().wsNsLotePsepC().set(wsVariavel().wsChavePpAux().wsNsLotePsep());
        wsVariavel().wsChavePpAuxC().wsNsRegLotePsepC().set(wsVariavel().wsChavePpAux().wsNsRegLotePsep());
        hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsLotePsepC().set(wsVariavel().wsChavePpAuxC().wsNsLotePsepC());
        hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsRegLotePsepC().set(wsVariavel().wsChavePpAuxC().wsNsRegLotePsepC());
        log(TraceLevel.Debug, ".........CHAVE DE CONTINUACAO -LOCAL-HR");
        log(TraceLevel.Debug, "  BGHM1030-C-PAIS-ISOA-TRFC-CH:", msgIn().msg().ade().chaveCont().cPaisIsoaTrfcCh());
        log(TraceLevel.Debug, "  BGHM1030-Z-PROCESSAMENTO-CH: ", msgIn().msg().ade().chaveCont().zProcessamentoCh());
        log(TraceLevel.Debug, "  BPPL500A-NS-LOTE-PSEP-C    : ", hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsLotePsepC());
        log(TraceLevel.Debug, "  BPPL500A-NS-REG-LOTE-PSEP-C: ", hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsRegLotePsepC());
        /**
         * MOVE A CONTA DA MENSAGEM PARA BPPL500A
         * IF BGHM1030-TS-MOVIMENTO(1:10) = WS-DATA-DIA
         * MOVE BHOL022A-C-EVEN-OPEL       TO
         * BPPL500A-X-CHAV-ACS-INF-ADI(1:4)
         * MOVE BHOL022A-C-OPE-BBN         TO
         * BPPL500A-X-CHAV-ACS-INF-ADI(5:5)
         * MOVE BHOL022A-X-REF-MOV         TO
         * BPPL500A-X-CHAV-ACS-INF-ADI(10:21)
         * ELSE
         * MOVE MGH902A-X-CHAV-ACS-INF-ADI TO
         * BPPL500A-X-CHAV-ACS-INF-ADI
         * END-IF
         */
        if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsDataDia())) {
            hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno().get(1, 4).set(hrMhoj022a().bhol022a().commarea().dadosOutput().cEvenOpel()) ;
            hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno().get(5, 5).set(hrMhoj022a().bhol022a().commarea().dadosOutput().cOpeBbn()) ;
            hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno().get(10, 21).set(hrMhoj022a().bhol022a().commarea().dadosOutput().xRefMov()) ;
        } else {
            hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno().set(hrMghs902a().bghl902a().detalhe().xChavAcsInfAdi());
        }
        log(TraceLevel.Debug, "  BGHM1030-TS-MOVIMENTO      : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "  WS-DATA-DIA                : ", wsDataDia());
        log(TraceLevel.Debug, "  BHOL022A-C-EVEN-OPEL       : ", hrMhoj022a().bhol022a().commarea().dadosOutput().cEvenOpel());
        log(TraceLevel.Debug, "  BHOL022A-C-OPE-BBN         : ", hrMhoj022a().bhol022a().commarea().dadosOutput().cOpeBbn());
        log(TraceLevel.Debug, "  BHOL022A-X-REF-MOV         : ", hrMhoj022a().bhol022a().commarea().dadosOutput().xRefMov());
        log(TraceLevel.Debug, "  MGH902A-X-CHAV-ACS-INF-ADI : ", hrMghs902a().bghl902a().detalhe().xChavAcsInfAdi());
        log(TraceLevel.Debug, "                         ");
        log(TraceLevel.Debug, "  BPPL500A-APLICACAO      :", hrMppj500a().bppl500a().commarea().dadosInput().aplicacao());
        log(TraceLevel.Debug, "  BPPL500A-Z-PROCESSAMENTO:", hrMppj500a().bppl500a().commarea().dadosInput().zProcessamento());
        log(TraceLevel.Debug, "  BPPL500A-C-PAIS-ISOA-OPX:", hrMppj500a().bppl500a().commarea().dadosInput().cPaisIsoaOpx());
        log(TraceLevel.Debug, "  BPPL500A-C-MNEM-EGC-OPEX:", hrMppj500a().bppl500a().commarea().dadosInput().cMnemEgcOpex());
        log(TraceLevel.Debug, "  BPPL500A-C-OE-EGC-OPEX  :", hrMppj500a().bppl500a().commarea().dadosInput().cOeEgcOpex());
        log(TraceLevel.Debug, "  BPPL500A-C-USERID       :", hrMppj500a().bppl500a().commarea().dadosInput().cUserid());
        log(TraceLevel.Debug, "  BPPL500A-N-JOUR-BBN     :", hrMppj500a().bppl500a().commarea().dadosInput().nJourBbn());
        log(TraceLevel.Debug, "  BPPL500A-C-IDIO-ISO     :", hrMppj500a().bppl500a().commarea().dadosInput().cIdioIso());
        log(TraceLevel.Debug, "  BPPL500A-X-INF-RTNO     :", hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno());
        log(TraceLevel.Debug, "  BPPL500A-CHAVE-CONT     :", hrMppj500a().bppl500a().commarea().dadosInput().chaveCont());
        log(TraceLevel.Debug, "......CALL MPPJ500A        ");
        hrMppj500a().run() ;
        log(TraceLevel.Debug, "......RETORNO DA MPPJ500A        ");
        if (!hrMppj500a().bppl500a().commarea().dadosErro().semErros().isTrue() && !hrMppj500a().bppl500a().commarea().dadosErro().fimConsulta().isTrue()) {
            progStatus.set(hrMppj500a().bppl500a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMppj500a().bppl500a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMppj500a().bppl500a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMppj500a().bppl500a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMppj500a().bppl500a().commarea().dadosErro().aAplErr());
            log(TraceLevel.Debug, "ERRO NA MPPJ500A");
            log(TraceLevel.Debug, "   BHTL001A-C-TIPO-ERRO-BBN : ", envOut.errosGraves().cTipoErroBbn());
            log(TraceLevel.Debug, "   BPPL500A-A-APL-ERR       : ", hrMppj500a().bppl500a().commarea().dadosErro().aAplErr());
            log(TraceLevel.Debug, "   BPPL500A-C-RTNO-EVEN-SWAL: ", hrMppj500a().bppl500a().commarea().dadosErro().cRtnoEvenSwal());
        }
        /**
         * *............
         */
        if (progOk.isTrue()) {
            if (hrMppj500a().bppl500a().commarea().dadosErro().fimConsulta().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(hrMppj500a().bppl500a().commarea().dadosErro().cTipoErroBbn());
            }
            wsVariavel().initialize() ;
            /**
             * GH1320 INI
             */
            msgOut().msg().ade().cOpeSibs().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cOpeSibs());
            /**
             * GH1320 FIM
             */
            msgOut().msg().ade().iFchoCpszUrgt().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().iFchoCpszUrgt());
            msgOut().msg().ade().cServSibsTei().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cServSibsTei());
            msgOut().msg().ade().dServSibsTei().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().dServSibsTei());
            msgOut().msg().ade().dOpeSibs().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().dOpeSibs());
            msgOut().msg().ade().cEndcSwifOrdn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cEndcSwifOrdn());
            msgOut().msg().ade().cIbanOrdn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cIbanOrdn());
            msgOut().msg().ade().nmOrdn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().nmOrdn());
            msgOut().msg().ade().nmOrdnPp().set(" ");
            log(TraceLevel.Debug, "BGHM1031-NM-ORDN   : ", msgOut().msg().ade().nmOrdn());
            log(TraceLevel.Debug, "BGHM1031-NM-ORDN-PP: ", msgOut().msg().ade().nmOrdnPp());
            msgOut().msg().ade().qTrfcDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().qTrfcDstn());
            msgOut().msg().ade().iTrfcDstnExced().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().iTrfcDstnExced());
            /**
             * MOVE BPPL500A-CHAVE-CONT-OUT
             * TO BGHM1031-CHAVE-CONT-OUT
             * .........CHAVE DE CONTINUACAO -HR-LOCAL
             */
            msgOut().msg().ade().chaveContOut().cPaisIsoaTrfc().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().cPaisIsoAlfn());
            /**
             * **      MOVE BPPL500A-C-MNEM-EMP-GCX
             * **                               TO BGHM1031-Z-PROCESSAMENTO(1:3)
             */
            wsVariavel().wsChavePpAux().wsNsLotePsep().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsLotePsep());
            wsVariavel().wsChavePpAux().wsNsRegLotePsep().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsRegLotePsep());
            wsVariavel().wsChaveGhAuxC02().wsCBancTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsCBancTrfcCh());
            wsVariavel().wsChaveGhAuxC02().wsZaOrdTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsZaOrdTrfcCh());
            wsVariavel().wsChaveGhAuxC02().wsNsOrdTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsNsOrdTrfcCh());
            wsVariavel().wsChaveGhAuxC02().wsNsIstzDstnTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsNsIstzDstnTrfcCh());
            msgOut().msg().ade().chaveContOut().cBancTrfc().set(wsVariavel().wsChaveGhAuxC02().wsCBancTrfcChC());
            msgOut().msg().ade().chaveContOut().zaOrdTrfc().set(wsVariavel().wsChaveGhAuxC02().wsZaOrdTrfcChC());
            msgOut().msg().ade().chaveContOut().nsOrdTrfc().set(wsVariavel().wsChaveGhAuxC02().wsNsOrdTrfcChC());
            msgOut().msg().ade().chaveContOut().nsIstzDstnTrfc().set(wsVariavel().wsChaveGhAuxC02().wsNsIstzDstnTrfcChC());
            log(TraceLevel.Debug, ".........CHAVE DE CONTINUACAO -HR-LOCAL");
            log(TraceLevel.Debug, "  BPPL500A-C-PAIS-ISO-ALFN   : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().cPaisIsoAlfn());
            log(TraceLevel.Debug, "  BPPL500A-C-MNEM-EMP-GCX    : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().cMnemEmpGcx());
            log(TraceLevel.Debug, "  BPPL500A-NS-LOTE-PSEP      : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsLotePsep());
            log(TraceLevel.Debug, "  BPPL500A-NS-REG-LOTE-PSEP  : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsRegLotePsep());
            /**
             * .........
             */
            msgOut().msg().ade().tabDstnTrfc().resetIndex() ;
            for (hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().setIndex(1); hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().index().isLessOrEqual(3); hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().incIndex()) {
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cEndcSwifDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cEndcSwifDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cIbanDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cIbanDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cMoedContDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cMoedContDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().nmDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstnPp().set(" ");
                log(TraceLevel.Debug, "BGHM1031-NM-DSTN(BGHM1031-I-DSTN)   : ", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn());
                log(TraceLevel.Debug, "BGHM1031-NM-DSTN-PP(BGHM1031-I-DSTN): ", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstnPp());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().mMovOrdDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().mMovOrdDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().xRefMovOrnSibs().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().xRefMovOrnSibs());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cMtvoDvlzSepa().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cMtvoDvlzSepa());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().xMtvoTrnzSepa().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().xMtvoTrnzSepa());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cCatgMtvTrfIso().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cCatgMtvTrfIso());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().dCatgMtvTrfIso().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().dCatgMtvTrfIso());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().xInfAdiSepa().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().xInfAdiSepa());
                log(TraceLevel.Debug, ".........BPPL500A-INDICE             ");
                log(TraceLevel.Debug, "  BGHM1031-C-IBAN-DSTN      :", msgOut().msg().ade().tabDstnTrfc().getCurrent().cIbanDstn());
                log(TraceLevel.Debug, "  BGHM1031-NM-DSTN          :", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn());
                log(TraceLevel.Debug, "  BGHM1031-X-MTVO-TRNZ-SEPA :", msgOut().msg().ade().tabDstnTrfc().getCurrent().xMtvoTrnzSepa());
                msgOut().msg().ade().tabDstnTrfc().incIndex() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55001AcedeMppj500aPp() {
        log(TraceLevel.Debug, "A55001-ACEDE-MPPJ500A-PP");
        hrMppj500a().bppl500a().commarea().initialize() ;
        wsVariavel().initialize() ;
        hrMppj500a().bppl500a().commarea().dadosInput().aplicacao().set("PP");
        hrMppj500a().bppl500a().commarea().dadosInput().cIdioIso().set(message.mensagem().headerR().seguranca().cIdioIso());
        /**
         * MOVE BGHM1030-CHAVE-CONT      TO BPPL500A-CHAVE-CONT
         * .........CHAVE DE CONTINUACAO -LOCAL-PP
         */
        hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().cPaisIsoAlfnC().set(msgIn().msg().ade().chaveCont().cPaisIsoaTrfcCh());
        /**
         * **   MOVE BGHM1030-Z-PROCESSAMENTO-CH(1:3)
         * **                                 TO BPPL500A-C-MNEM-EMP-GCX-C
         */
        wsVariavel().wsChaveGhAuxC().wsCBancTrfcCh().set(msgIn().msg().ade().chaveCont().cBancTrfcCh());
        wsVariavel().wsChaveGhAuxC().wsZaOrdTrfcCh().set(msgIn().msg().ade().chaveCont().zaOrdTrfcCh());
        wsVariavel().wsChaveGhAuxC().wsNsOrdTrfcCh().set(msgIn().msg().ade().chaveCont().nsOrdTrfcCh());
        wsVariavel().wsChaveGhAuxC().wsNsIstzDstnTrfcCh().set(msgIn().msg().ade().chaveCont().nsIstzDstnTrfcCh());
        wsVariavel().wsChavePpAuxC().wsNsLotePsepC().set(wsVariavel().wsChavePpAux().wsNsLotePsep());
        wsVariavel().wsChavePpAuxC().wsNsRegLotePsepC().set(wsVariavel().wsChavePpAux().wsNsRegLotePsep());
        hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsLotePsepC().set(wsVariavel().wsChavePpAuxC().wsNsLotePsepC());
        hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsRegLotePsepC().set(wsVariavel().wsChavePpAuxC().wsNsRegLotePsepC());
        log(TraceLevel.Debug, ".........CHAVE DE CONTINUACAO -LOCAL-PP");
        log(TraceLevel.Debug, "  BGHM1030-C-PAIS-ISOA-TRFC-CH:", msgIn().msg().ade().chaveCont().cPaisIsoaTrfcCh());
        log(TraceLevel.Debug, "  BGHM1030-Z-PROCESSAMENTO-CH: ", msgIn().msg().ade().chaveCont().zProcessamentoCh());
        log(TraceLevel.Debug, "  BPPL500A-NS-LOTE-PSEP-C    : ", hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsLotePsepC());
        log(TraceLevel.Debug, "  BPPL500A-NS-REG-LOTE-PSEP-C: ", hrMppj500a().bppl500a().commarea().dadosInput().chaveCont().nsRegLotePsepC());
        /**
         * MOVE BGHM1030-I-DBCR          TO BPPL500A-I-DBCR
         * MOVE BGHM1030-TS-MOVIMENTO(1:10)
         * TO BPPL500A-Z-PROCESSAMENTO
         * MOVE MGH102A-C-PAIS-ISOA-OE-OPX
         * TO BPPL500A-C-PAIS-ISOA-OPX
         * MOVE MGH102A-C-MNEM-EGC-OPEX  TO BPPL500A-C-MNEM-EGC-OPEX
         * MOVE MGH102A-C-OE-EGC-OPEX    TO BPPL500A-C-OE-EGC-OPEX
         * MOVE MGH102A-C-USERID         TO BPPL500A-C-USERID
         * MOVE MGH102A-N-JOUR-BBN       TO BPPL500A-N-JOUR-BBN
         * MOVE SPACES                   TO BPPL500A-TIPO-OPERACAO
         * MOVE 3                        TO BPPL500A-Q-OCCURS-IN
         * --------
         * MOVE A CONTA DA MENSAGEM PARA BPPL500A
         */
        if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsDataDia())) {
            /**
             * MOVE BHOL022A-C-EVEN-OPEL       TO
             * BPPL500A-X-INF-RTNO(1:4)
             * MOVE BHOL022A-C-OPE-BBN         TO
             * BPPL500A-X-INF-RTNO(5:5)
             * MOVE BHOL022A-X-REF-MOV         TO
             * BPPL500A-X-INF-RTNO(10:21)
             */
            hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno().get(1, 21).set(hrMhoj022a().bhol022a().commarea().dadosOutput().xRefMov()) ;
            hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno().get(22, 4).set(hrMhoj022a().bhol022a().commarea().dadosOutput().cEvenOpel()) ;
        } else {
            hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno().set(hrMghs902a().bghl902a().detalhe().xChavAcsInfAdi());
        }
        log(TraceLevel.Debug, "  BGHM1030-TS-MOVIMENTO      : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "  WS-DATA-DIA                : ", wsDataDia());
        log(TraceLevel.Debug, "  BHOL022A-C-EVEN-OPEL       : ", hrMhoj022a().bhol022a().commarea().dadosOutput().cEvenOpel());
        log(TraceLevel.Debug, "  BHOL022A-C-OPE-BBN         : ", hrMhoj022a().bhol022a().commarea().dadosOutput().cOpeBbn());
        log(TraceLevel.Debug, "  BHOL022A-X-REF-MOV         : ", hrMhoj022a().bhol022a().commarea().dadosOutput().xRefMov());
        log(TraceLevel.Debug, "  MGH902A-X-CHAV-ACS-INF-ADI : ", hrMghs902a().bghl902a().detalhe().xChavAcsInfAdi());
        log(TraceLevel.Debug, "                          ");
        log(TraceLevel.Debug, "  BPPL500A-APLICACAO      :", hrMppj500a().bppl500a().commarea().dadosInput().aplicacao());
        log(TraceLevel.Debug, "  BPPL500A-Z-PROCESSAMENTO:", hrMppj500a().bppl500a().commarea().dadosInput().zProcessamento());
        log(TraceLevel.Debug, "  BPPL500A-C-PAIS-ISOA-OPX:", hrMppj500a().bppl500a().commarea().dadosInput().cPaisIsoaOpx());
        log(TraceLevel.Debug, "  BPPL500A-C-MNEM-EGC-OPEX:", hrMppj500a().bppl500a().commarea().dadosInput().cMnemEgcOpex());
        log(TraceLevel.Debug, "  BPPL500A-C-OE-EGC-OPEX  :", hrMppj500a().bppl500a().commarea().dadosInput().cOeEgcOpex());
        log(TraceLevel.Debug, "  BPPL500A-C-USERID       :", hrMppj500a().bppl500a().commarea().dadosInput().cUserid());
        log(TraceLevel.Debug, "  BPPL500A-N-JOUR-BBN     :", hrMppj500a().bppl500a().commarea().dadosInput().nJourBbn());
        log(TraceLevel.Debug, "  BPPL500A-C-IDIO-ISO     :", hrMppj500a().bppl500a().commarea().dadosInput().cIdioIso());
        log(TraceLevel.Debug, "  BPPL500A-X-INF-RTNO     :", hrMppj500a().bppl500a().commarea().dadosInput().xInfRtno());
        log(TraceLevel.Debug, "  BPPL500A-CHAVE-CONT     :", hrMppj500a().bppl500a().commarea().dadosInput().chaveCont());
        log(TraceLevel.Debug, "......CALL MPPJ500A        ");
        hrMppj500a().run() ;
        log(TraceLevel.Debug, "......RETORNO DA MPPJ500A        ");
        if (!hrMppj500a().bppl500a().commarea().dadosErro().semErros().isTrue() && !hrMppj500a().bppl500a().commarea().dadosErro().fimConsulta().isTrue()) {
            progStatus.set(hrMppj500a().bppl500a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMppj500a().bppl500a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMppj500a().bppl500a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMppj500a().bppl500a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMppj500a().bppl500a().commarea().dadosErro().aAplErr());
            log(TraceLevel.Debug, "ERRO NA MPPJ500A");
            log(TraceLevel.Debug, "  BHTL001A-C-TIPO-ERRO-BBN : ", envOut.errosGraves().cTipoErroBbn());
            log(TraceLevel.Debug, "  BPPL500A-A-APL-ERR       : ", hrMppj500a().bppl500a().commarea().dadosErro().aAplErr());
            log(TraceLevel.Debug, "  BPPL500A-C-RTNO-EVEN-SWAL: ", hrMppj500a().bppl500a().commarea().dadosErro().cRtnoEvenSwal());
        }
        /**
         * *............
         */
        if (progOk.isTrue()) {
            if (hrMppj500a().bppl500a().commarea().dadosErro().fimConsulta().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(hrMppj500a().bppl500a().commarea().dadosErro().cTipoErroBbn());
            }
            wsVariavel().initialize() ;
            /**
             * GH1320 INI
             */
            msgOut().msg().ade().cOpeSibs().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cOpeSibs());
            /**
             * GH1320 FIM
             */
            msgOut().msg().ade().iFchoCpszUrgt().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().iFchoCpszUrgt());
            msgOut().msg().ade().cServSibsTei().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cServSibsTei());
            msgOut().msg().ade().dServSibsTei().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().dServSibsTei());
            msgOut().msg().ade().dOpeSibs().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().dOpeSibs());
            msgOut().msg().ade().cEndcSwifOrdn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cEndcSwifOrdn());
            msgOut().msg().ade().cIbanOrdn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().cIbanOrdn());
            /**
             * MOVE BPPL500A-NM-ORDN    TO BGHM1031-NM-ORDN
             */
            msgOut().msg().ade().nmOrdn().set(" ");
            msgOut().msg().ade().nmOrdnPp().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().nmOrdn());
            log(TraceLevel.Debug, "BGHM1031-NM-ORDN   : ", msgOut().msg().ade().nmOrdn());
            log(TraceLevel.Debug, "BGHM1031-NM-ORDN-PP: ", msgOut().msg().ade().nmOrdnPp());
            msgOut().msg().ade().qTrfcDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().qTrfcDstn());
            msgOut().msg().ade().iTrfcDstnExced().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().iTrfcDstnExced());
            /**
             * MOVE BPPL500A-CHAVE-CONT-OUT
             * TO BGHM1031-CHAVE-CONT-OUT
             * .........CHAVE DE CONTINUACAO -PP-LOCAL
             */
            msgOut().msg().ade().chaveContOut().cPaisIsoaTrfc().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().cPaisIsoAlfn());
            /**
             * **      MOVE BPPL500A-C-MNEM-EMP-GCX
             * **                               TO BGHM1031-Z-PROCESSAMENTO(1:3)
             */
            wsVariavel().wsChavePpAux().wsNsLotePsep().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsLotePsep());
            wsVariavel().wsChavePpAux().wsNsRegLotePsep().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsRegLotePsep());
            wsVariavel().wsChaveGhAuxC02().wsCBancTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsCBancTrfcCh());
            wsVariavel().wsChaveGhAuxC02().wsZaOrdTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsZaOrdTrfcCh());
            wsVariavel().wsChaveGhAuxC02().wsNsOrdTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsNsOrdTrfcCh());
            wsVariavel().wsChaveGhAuxC02().wsNsIstzDstnTrfcChC().set(wsVariavel().wsChaveGhAuxC().wsNsIstzDstnTrfcCh());
            msgOut().msg().ade().chaveContOut().cBancTrfc().set(wsVariavel().wsChaveGhAuxC02().wsCBancTrfcChC());
            msgOut().msg().ade().chaveContOut().zaOrdTrfc().set(wsVariavel().wsChaveGhAuxC02().wsZaOrdTrfcChC());
            msgOut().msg().ade().chaveContOut().nsOrdTrfc().set(wsVariavel().wsChaveGhAuxC02().wsNsOrdTrfcChC());
            msgOut().msg().ade().chaveContOut().nsIstzDstnTrfc().set(wsVariavel().wsChaveGhAuxC02().wsNsIstzDstnTrfcChC());
            log(TraceLevel.Debug, ".........CHAVE DE CONTINUACAO -PP-LOCAL");
            log(TraceLevel.Debug, "  BPPL500A-C-PAIS-ISO-ALFN   : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().cPaisIsoAlfn());
            log(TraceLevel.Debug, "  BPPL500A-C-MNEM-EMP-GCX    : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().cMnemEmpGcx());
            log(TraceLevel.Debug, "  BPPL500A-NS-LOTE-PSEP      : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsLotePsep());
            log(TraceLevel.Debug, "  BPPL500A-NS-REG-LOTE-PSEP  : ", hrMppj500a().bppl500a().commarea().dadosOutputPpHr().chaveContOut().nsRegLotePsep());
            /**
             * .........
             */
            msgOut().msg().ade().tabDstnTrfc().resetIndex() ;
            for (hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().setIndex(1); hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().index().isLessOrEqual(3); hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().incIndex()) {
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cEndcSwifDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cEndcSwifDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cIbanDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cIbanDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cMoedContDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cMoedContDstn());
                /**
                 * MOVE BPPL500A-NM-DSTN(BPPL500A-INDICE)
                 * TO BGHM1031-NM-DSTN(BGHM1031-I-DSTN)
                 */
                msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn().set(" ");
                msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstnPp().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().nmDstn());
                log(TraceLevel.Debug, "BGHM1031-NM-DSTN(BGHM1031-I-DSTN)   : ", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn());
                log(TraceLevel.Debug, "BGHM1031-NM-DSTN-PP(BGHM1031-I-DSTN): ", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstnPp());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().mMovOrdDstn().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().mMovOrdDstn());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().xRefMovOrnSibs().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().xRefMovOrnSibs());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cMtvoDvlzSepa().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cMtvoDvlzSepa());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().xMtvoTrnzSepa().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().xMtvoTrnzSepa());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().cCatgMtvTrfIso().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().cCatgMtvTrfIso());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().dCatgMtvTrfIso().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().dCatgMtvTrfIso());
                msgOut().msg().ade().tabDstnTrfc().getCurrent().xInfAdiSepa().set(hrMppj500a().bppl500a().commarea().dadosOutputPpHr().tabDstnTrfc().getCurrent().xInfAdiSepa());
                log(TraceLevel.Debug, ".........BPPL500A-INDICE     ");
                log(TraceLevel.Debug, "  BGHM1031-C-IBAN-DSTN      :", msgOut().msg().ade().tabDstnTrfc().getCurrent().cIbanDstn());
                log(TraceLevel.Debug, "  BGHM1031-NM-DSTN          :", msgOut().msg().ade().tabDstnTrfc().getCurrent().nmDstn());
                log(TraceLevel.Debug, "  BGHM1031-X-MTVO-TRNZ-SEPA :", msgOut().msg().ade().tabDstnTrfc().getCurrent().xMtvoTrnzSepa());
                msgOut().msg().ade().tabDstnTrfc().incIndex() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Responder() {
        log(TraceLevel.Debug, "S70000-RESPONDER");
        /**
         * MOVE WS-ERR-FUNC         TO BHTL001A-C-TIPO-ERRO-BBN
         * MOVE WS-APL-HST          TO BHTL001A-A-APL-ERR
         */
        if (!envOut.errosGraves().semErros().isTrue() && !envOut.errosGraves().fimConsulta().isTrue()) {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(progStatus);
        }
        /**
         * *..........
         */
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        message.mensagem().headerR().transaccao().vizualizacao().setTrue() ;
        log(TraceLevel.Debug, "****** MENSAGEM OUTPUT ******");
        log(TraceLevel.Debug, "BGHM1031-I-FCHO-CPSZ-URGT : ", msgOut().msg().ade().iFchoCpszUrgt());
        log(TraceLevel.Debug, "BGHM1031-C-SERV-SIBS-TEI  : ", msgOut().msg().ade().cServSibsTei());
        log(TraceLevel.Debug, "BGHM1031-D-SERV-SIBS-TEI  : ", msgOut().msg().ade().dServSibsTei());
        log(TraceLevel.Debug, "BGHM1031-C-OPE-SIBS       : ", msgOut().msg().ade().cOpeSibs());
        log(TraceLevel.Debug, "BGHM1031-D-OPE-SIBS       : ", msgOut().msg().ade().dOpeSibs());
        log(TraceLevel.Debug, "BGHM1031-D-OPE-SIBS       : ", msgOut().msg().ade().dOpeSibs());
        log(TraceLevel.Debug, "BGHM1031-C-ENDC-SWIF-ORDN : ", msgOut().msg().ade().cEndcSwifOrdn());
        log(TraceLevel.Debug, "BGHM1031-C-IBAN-ORDN      : ", msgOut().msg().ade().cIbanOrdn());
        log(TraceLevel.Debug, "BGHM1031-NM-ORDN          : ", msgOut().msg().ade().nmOrdn());
        log(TraceLevel.Debug, "BGHM1031-NM-ORDN-PP       : ", msgOut().msg().ade().nmOrdnPp());
        log(TraceLevel.Debug, "BGHM1031-Q-TRFC-DSTN      : ", msgOut().msg().ade().qTrfcDstn());
        log(TraceLevel.Debug, "BGHM1031-I-TRFC-DSTN-EXCED: ", msgOut().msg().ade().iTrfcDstnExced());
        log(TraceLevel.Debug, "BGHM1031-C-PAIS-ISOA-TRFC : ", msgOut().msg().ade().chaveContOut().cPaisIsoaTrfc());
        log(TraceLevel.Debug, "BGHM1031-C-BANC-TRFC      : ", msgOut().msg().ade().chaveContOut().cBancTrfc());
        log(TraceLevel.Debug, "BGHM1031-ZA-ORD-TRFC      : ", msgOut().msg().ade().chaveContOut().zaOrdTrfc());
        log(TraceLevel.Debug, "BGHM1031-NS-ORD-TRFC      : ", msgOut().msg().ade().chaveContOut().nsOrdTrfc());
        log(TraceLevel.Debug, "BGHM1031-Z-PROCESSAMENTO  : ", msgOut().msg().ade().chaveContOut().zProcessamento());
        log(TraceLevel.Debug, "BGHM1031-NS-ISTZ-DSTN-TRFC: ", msgOut().msg().ade().chaveContOut().nsIstzDstnTrfc());
        log(TraceLevel.Debug, "BGHM1031-C-ENDC-SWIF-DSTN(1): ", msgOut().msg().ade().tabDstnTrfc().get(1).cEndcSwifDstn());
        log(TraceLevel.Debug, "BGHM1031-C-IBAN-DSTN(1)     : ", msgOut().msg().ade().tabDstnTrfc().get(1).cIbanDstn());
        log(TraceLevel.Debug, "BGHM1031-C-MOED-CONT-DSTN(1): ", msgOut().msg().ade().tabDstnTrfc().get(1).cMoedContDstn());
        log(TraceLevel.Debug, "BGHM1031-NM-DSTN(1)         : ", msgOut().msg().ade().tabDstnTrfc().get(1).nmDstn());
        log(TraceLevel.Debug, "BGHM1031-NM-DSTN-PP(1)      : ", msgOut().msg().ade().tabDstnTrfc().get(1).nmDstnPp());
        log(TraceLevel.Debug, "BGHM1031-M-MOV-ORD-DSTN(1)  : ", msgOut().msg().ade().tabDstnTrfc().get(1).mMovOrdDstn());
        log(TraceLevel.Debug, "BGHM1031-X-REF-MOV-ORN-SIBS(1): ", msgOut().msg().ade().tabDstnTrfc().get(1).xRefMovOrnSibs());
        log(TraceLevel.Debug, "BGHM1031-C-MTVO-DVLZ-SEPA(1)  : ", msgOut().msg().ade().tabDstnTrfc().get(1).cMtvoDvlzSepa());
        log(TraceLevel.Debug, "BGHM1031-X-MTVO-TRNZ-SEPA(1)  : ", msgOut().msg().ade().tabDstnTrfc().get(1).xMtvoTrnzSepa());
        log(TraceLevel.Debug, "BGHM1031-C-CATG-MTV-TRF-ISO(1): ", msgOut().msg().ade().tabDstnTrfc().get(1).cCatgMtvTrfIso());
        log(TraceLevel.Debug, "BGHM1031-D-CATG-MTV-TRF-ISO(1): ", msgOut().msg().ade().tabDstnTrfc().get(1).dCatgMtvTrfIso());
        log(TraceLevel.Debug, "BGHM1031-X-INF-ADI-SEPA(1): ", msgOut().msg().ade().tabDstnTrfc().get(1).xInfAdiSepa());
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        log(TraceLevel.Debug, "INICIO DO PROGRAMA PGHO103A");
        s10000Iniciar() ;
        /**
         * *........
         */
        if (progOk.isTrue()) {
            s30000Validar() ;
        }
        /**
         * *........
         */
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        /**
         * *........
         */
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
    public interface WsVariavel extends IDataStruct {
        
        @Data(size=24)
        IString wsChaveGhAux() ;
        
        /**
         * @return instancia da classe local WsChaveGhAuxC
         */
        @Data
        @Mask
        WsChaveGhAuxC wsChaveGhAuxC() ;
        
        /**
         * @return instancia da classe local WsChavePpAux
         */
        @Data
        @Mask
        WsChavePpAux wsChavePpAux() ;
        
        /**
         * @return instancia da classe local WsChavePpAuxC
         */
        @Data
        WsChavePpAuxC wsChavePpAuxC() ;
        
        /**
         * @return instancia da classe local WsChaveGhAuxC02
         */
        @Data
        WsChaveGhAuxC02 wsChaveGhAuxC02() ;
        
        
        public interface WsChaveGhAuxC extends IDataMask {
            
            @Data(size=4)
            IInt wsCBancTrfcCh() ;
            
            @Data(size=4)
            IInt wsZaOrdTrfcCh() ;
            
            @Data(size=10)
            ILong wsNsOrdTrfcCh() ;
            
            @Data(size=6)
            IInt wsNsIstzDstnTrfcCh() ;
            
        }
        
        public interface WsChavePpAux extends IDataMask {
            
            @Data(size=12)
            ILong wsNsLotePsep() ;
            
            @Data(size=7)
            IInt wsNsRegLotePsep() ;
            
        }
        
        public interface WsChavePpAuxC extends IDataStruct {
            
            @Data(size=12, signed=true, compression=COMP3)
            ILong wsNsLotePsepC() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsNsRegLotePsepC() ;
            
        }
        
        public interface WsChaveGhAuxC02 extends IDataStruct {
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsCBancTrfcChC() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsZaOrdTrfcChC() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong wsNsOrdTrfcChC() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt wsNsIstzDstnTrfcChC() ;
            
        }
    }
    public interface WsDataDia extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaData() ;
        
    }
    
}
