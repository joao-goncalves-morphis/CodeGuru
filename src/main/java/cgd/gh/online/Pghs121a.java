package cgd.gh.online;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
import cgd.gh.structures.work.* ;
import cgd.gh.persistence.database.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm1120 ;
import cgd.gh.structures.messages.Bghm1121 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hy.structures.work.Bhyw0001 ;
import cgd.hj.structures.link.Bhjl027a ;
import cgd.gh.structures.link.Bghl122a ;
import cgd.hj.routines.Mhjj027a ;
import cgd.gh.routines.Mghs122a ;
import cgd.gh.routines.Mghs003a ;
import cgd.ho.routines.Mhoj356a ;
import cgd.dr.routines.Mdrj402a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS121A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1488 - TERC - 1ª FASE - TRANSACOES ON-LINE
 * FUNCAO     : CONSULTA DE DADOS COMPLEMENTARES DO MOVIMENTO
 * (DADOS DO INTERVENIENTE NA OPERACAO)
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES: LOCAL - MVPHIG - ENCADEADO SEMPRE DA MVPHI0/MVPHIE*
 * LOG DE ALTERACOES
 * PROCESSO!   DATA   ! UTILZ ! OBSERVACOES
 * GH1488  !2014-07-21!ACT0701! TERC - FASE 1 -  CRIACAO
 * GH1516  !2014-08-27!ACT0701! CARREGAMENTO DE DADOS COMPLETOS
 * DE JOURNAL
 * GH1629  !2015-01-16!DACT649! TERC - FASE 3 - IDENTIFICACAO DO
 * INTERVENIENTE NOS LEVANTAMENTOS / PAGAMENTOS DE CHEQUE*
 * *PASS4497 !2019-10-15!ACCENTU! UCO 2.7 - LEI N.º 83  OSI3656
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs121a extends CgdGhBaseOnline<Pghs121a.EnvelopeIn, Pghs121a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1120
     */
    public abstract Bghm1120 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1121
     */
    public abstract Bghm1121 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1120.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1121.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps13001Movdep
     */
    @Data
    protected abstract Vwsdghps13001Movdep hv13001Movdep() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhjj027a
     */
    @Data
    protected abstract Mhjj027a hrMhjj027a() ;
    
    /**
     * @return instancia da classe Mghs122a
     */
    @Data
    protected abstract Mghs122a hrMghs122a() ;
    
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
    /**
     * @return instancia da classe Mhoj356a
     */
    @Data
    protected abstract Mhoj356a hrMhoj356a() ;
    
    /**
     * @return instancia da classe Mdrj402a
     */
    @Data
    protected abstract Mdrj402a hrMdrj402a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhyw0001
     */
    @Data
    protected abstract Bhyw0001 bhyw0001() ;
    
    /**
     * @return instancia da classe Bhjl027a
     */
    @Data
    protected abstract Bhjl027a bhjl027a() ;
    
    /**
     * @return instancia da classe Bghl122a
     */
    @Data
    protected abstract Bghl122a bghl122a() ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     * ----- DB2
     */
    protected static final String CON_SELECT = "SE" ;
    
    protected static final String CON_INSERT = "IN" ;
    
    protected static final String CON_UPDATE = "UP" ;
    
    protected static final String CON_DELETE = "DL" ;
    
    protected static final String CON_VISUALIZACAO = "V" ;
    
    protected static final String CON_MODIFICACAO = "M" ;
    
    protected static final String CON_INSERCAO = "I" ;
    
    protected static final String CON_ELIMINACAO = "E" ;
    
    protected static final String CON_ANULACAO = "A" ;
    
    protected static final String CON_VGH13001 = "VGH13001" ;
    
    protected static final String CON_A_APL_GH = "GH" ;
    
    protected static final String CON_SIM = "S" ;
    
    protected static final String CON_NAO = "N" ;
    
    protected static final String CON_1 = "1" ;
    
    protected static final String CON_TGH00022 = "TGH00022" ;
    
    protected static final String CON_TGH00102 = "TGH00102" ;
    
    protected static final String CON_TGH00003 = "TGH00003" ;
    
    protected static final String CON_I = "I" ;
    
    protected static final String CON_EXPRESSO_24H = "E" ;
    
    protected static final String CON_ATM_CGD = "- ATM CGD " ;
    
    protected static final String CON_MDRJ402A = "MDRJ402A" ;
    
    protected static final String CON_VARIOS_CLI_CGD = "V" ;
    
    /**
     * ****                CONSTANTES NUMERICAS                  ****
     */
    protected static final int CON_1N = 1 ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * BHJP5027-ACESSO AO MODULO QUE OBTEM E VALIDA CLIENTE
     * POR DOCUMENTO DE IDENTIFICACAO (MHJJ027A)
     * 
     */
    protected void bhjp5027AcedeMhjj027a() {
        hrMhjj027a().run() ;
    }
    
    /**
     * 
     * COPY PROCEDURE BGHP0122
     * 
     */
    protected void bghp0122AcedeMghs122a() {
        hrMghs122a().run() ;
    }
    
    /**
     * 
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "***** INICIO * GHIG * MVPHIG * INICIO ********");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2000ProcessoPrograma() ;
        }
        m3000FinalPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, " 1000-INICIO-PROGRAMA");
        hv13001Movdep().movdep().initialize() ;
        msgOut().msg().ade().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().indice().set(0);
        if (envOut.errosGraves().semErros().isTrue()) {
            m1100ValidaInput() ;
        }
    }
    
    /**
     * 
     * 1100-VALIDA-INPUT
     * 
     */
    protected void m1100ValidaInput() {
        log(TraceLevel.Debug, "1100-VALIDA-INPUT");
        log(TraceLevel.Debug, "**********************************");
        log(TraceLevel.Debug, "***      DADOS DE ENTRADA      ***");
        log(TraceLevel.Debug, "**********************************");
        log(TraceLevel.Debug, "   BGHM1120-C-PAIS-ISOA-CONT  : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BGHM1120-C-BANC-CONT       : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "   BGHM1120-C-OE-EGC-CONT     : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "   BGHM1120-NS-RDCL-CONT      : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "   BGHM1120-V-CHKD-CONT       : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "   BGHM1120-C-TIPO-CONT       : ", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "   BGHM1120-C-MOED-ISO-SCTA   : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "   BGHM1120-NS-DEPOSITO       : ", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "   BGHM1120-TS-MOVIMENTO      : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "   BGHM1120-NS-MOVIMENTO      : ", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "   BGHM1120-C-TIP-REL-DEP     : ", msgIn().msg().ade().cTipRelDep());
        log(TraceLevel.Debug, "   BGHM1120-X-INF-JSTZ-DEP    : ", msgIn().msg().ade().xInfJstzDep());
        if (envOut.errosGraves().semErros().isTrue() && 
            (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            !msgIn().msg().ade().cBancCont().isNumeric() || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            !msgIn().msg().ade().cOeEgcCont().isNumeric() || 
            !msgIn().msg().ade().nsRdclCont().isNumeric() || 
            !msgIn().msg().ade().vChkdCont().isNumeric() || 
            !msgIn().msg().ade().cTipoCont().isNumeric() || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            !msgIn().msg().ade().nsDeposito().isNumeric() || 
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            !msgIn().msg().ade().nsMovimento().isNumeric())) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().inputInvalido());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, "ERRO-01");
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        m2100TratarHstActivo() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2200ValidaMovDep() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (msgOut().msg().ade().iCliCgd().isEqual(CON_SIM) && 
                !msgOut().msg().ade().cTipoItvtDep().isEqual(CON_EXPRESSO_24H)) {
                m2300ObtemNCliente() ;
            } else {
                msgOut().msg().ade().nCliente().set(0);
                msgOut().msg().ade().nsAbraCli().set(0);
            }
            log(TraceLevel.Debug, "   BGHM1121-N-CLIENTE        : ", msgOut().msg().ade().nCliente());
            log(TraceLevel.Debug, "   BGHM1121-NS-ABRA-CLI      : ", msgOut().msg().ade().nsAbraCli());
            log(TraceLevel.Debug, "   BGHM1121-C-TIPO-CANL-ACES : ", msgOut().msg().ade().cTipoCanlAces());
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (msgOut().msg().ade().cTipoCanlAces().isEqual("ATS")) {
                m2400ObtemXInfAts() ;
            } else {
                msgOut().msg().ade().xInfAts().set(" ");
            }
        }
    }
    
    /**
     * 
     * 2100-TRATAR-HST-ACTIVO
     * 
     */
    protected void m2100TratarHstActivo() {
        log(TraceLevel.Debug, "  2100-TRATAR-HST-ACTIVO");
        m2110ConsultaGatcnsmov() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (hrMghs003a().bghl003a().zHoje().isEqual(msgIn().msg().ade().tsMovimento().get(1, 10))) {
                m2120ObtemDadosHo() ;
            } else {
                bghl122a().commarea().initialize() ;
                bghl122a().commarea().criterioConsulta().movHstS().setTrue() ;
                m2130ObtemDadosHst() ;
                if (bghl122a().commarea().erros().naoExiste().isTrue()) {
                    /**
                     * --- MOVIMENTO NAO ESTA EM HST (TGH02)
                     */
                    switch (hrMghs003a().bghl003a().detalhe().iEstRcrs().get()) {
                        case "I":
                            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().naoExistMovCrit());
                            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                            envOut.errosGraves().errosFuncao().setTrue() ;
                            log(TraceLevel.Error, "ERRO-02");
                            break;
                        case "A":
                            bghl122a().commarea().initialize() ;
                            bghl122a().commarea().criterioConsulta().movHstN().setTrue() ;
                            m2130ObtemDadosHst() ;
                            if (bghl122a().commarea().erros().naoExiste().isTrue()) {
                                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().naoExistMovCrit());
                                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                                envOut.errosGraves().errosFuncao().setTrue() ;
                                log(TraceLevel.Error, "ERRO-03");
                            }
                            break;
                        case "H":
                            /**
                             * --- MOVIMENTOS DO DIA D -1 ESTAO NA APLICACAO HO
                             */
                            m2140ObtemDadosHoOntem() ;
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
     * 2110-CONSULTA-GATCNSMOV
     * 
     */
    protected void m2110ConsultaGatcnsmov() {
        log(TraceLevel.Debug, "   2110-CONSULTA-GATCNSMOV");
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set(CON_TGH00022);
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set(CON_I);
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            hrMghs003a().bghl003a().db2().setTrue() ;
            envOut.errosGraves().abend().setTrue() ;
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set(CON_TGH00003);
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            envOut.errosGraves().cRtnoEvenSwal().set(hrMghs003a().bghl003a().cRetorno());
            log(TraceLevel.Error, "ERRO-04");
        }
        log(TraceLevel.Debug, "   MGH003A-I-EST-RCRS : ", hrMghs003a().bghl003a().detalhe().iEstRcrs());
    }
    
    /**
     * 
     * 2120-OBTEM-DADOS-HO
     * 
     */
    protected void m2120ObtemDadosHo() {
        log(TraceLevel.Debug, "   2120-OBTEM-DADOS-HO");
        hrMhoj356a().bhol356a().commarea().initialize() ;
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj356a().bhol356a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMhoj356a().bhol356a().commarea().dadosInput().iMovDia().set(CON_SIM);
        log(TraceLevel.Debug, "   BHOL356A-I-MOV-DIA : ", hrMhoj356a().bhol356a().commarea().dadosInput().iMovDia());
        hrMhoj356a().run() ;
        if (hrMhoj356a().bhol356a().commarea().dadosErro().semErros().isTrue()) {
            hv13001Movdep().movdep().cPaisIsoaOeOpx().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cPaisIsoaOeOpx());
            hv13001Movdep().movdep().cMnemEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cMnemEgcOpex());
            hv13001Movdep().movdep().cOeEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cOeEgcOpex());
            hv13001Movdep().movdep().cUserid().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cUserid());
            hv13001Movdep().movdep().nJourBbn().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nJourBbn());
            hv13001Movdep().movdep().zProcessamento().set(hrMhoj356a().bhol356a().commarea().dadosOutput().zProcessamento());
        } else {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().naoExistMovCrit());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, "ERRO-05");
        }
    }
    
    /**
     * 
     * 2130-OBTEM-DADOS-HST
     * 
     */
    protected void m2130ObtemDadosHst() {
        log(TraceLevel.Debug, "   2130-OBTEM-DADOS-HST");
        log(TraceLevel.Debug, "   BGHL122A-CRTL-MOV-HST (D/N): ");
        bghl122a().commarea().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bghl122a().commarea().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        bghl122a().commarea().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bghl122a().commarea().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bghl122a().commarea().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bghl122a().commarea().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bghl122a().commarea().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        bghl122a().commarea().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        bghl122a().commarea().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        bghl122a().commarea().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        bghp0122AcedeMghs122a() ;
        if (!bghl122a().commarea().erros().semErros().isTrue()) {
            if (!bghl122a().commarea().erros().naoExiste().isTrue()) {
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghl122a().commarea().erros().cRtnoEvenSwal());
                envOut.errosGraves().cRtnoEvenSwal().set(bghl122a().commarea().erros().cRtnoEvenSwal());
                envOut.errosGraves().cTipoErroBbn().set(bghl122a().commarea().erros().cTipoErroBbn());
                envOut.db2Log().sqlca().cSqlcode().set(bghl122a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bghl122a().commarea().erros().nmTabela());
                envOut.errosGraves().aAplErr().set(bghl122a().commarea().erros().aAplErr());
                log(TraceLevel.Error, "ERRO-06");
            }
        }
        if (bghl122a().commarea().erros().semErros().isTrue()) {
            hv13001Movdep().movdep().cPaisIsoaOeOpx().set(bghl122a().commarea().detalhe().cPaisIsoaOeOpx());
            hv13001Movdep().movdep().cMnemEgcOpex().set(bghl122a().commarea().detalhe().cMnemEgcOpex());
            hv13001Movdep().movdep().cOeEgcOpex().set(bghl122a().commarea().detalhe().cOeEgcOpex());
            hv13001Movdep().movdep().cUserid().set(bghl122a().commarea().detalhe().cUserid());
            hv13001Movdep().movdep().nJourBbn().set(bghl122a().commarea().detalhe().nJourBbn());
            hv13001Movdep().movdep().zProcessamento().set(bghl122a().commarea().detalhe().zProcessamento());
        }
    }
    
    /**
     * 
     * 2140-OBTEM-DADOS-HO-ONTEM
     * 
     */
    protected void m2140ObtemDadosHoOntem() {
        log(TraceLevel.Debug, "   2140-OBTEM-DADOS-HO-ONTEM");
        hrMhoj356a().bhol356a().commarea().initialize() ;
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj356a().bhol356a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMhoj356a().bhol356a().commarea().dadosInput().iMovDia().set(CON_NAO);
        log(TraceLevel.Debug, "   BHOL356A-I-MOV-DIA : ", hrMhoj356a().bhol356a().commarea().dadosInput().iMovDia());
        /**
         * --> ACESSO AO MHOJ356A
         */
        hrMhoj356a().run() ;
        if (hrMhoj356a().bhol356a().commarea().dadosErro().semErros().isTrue()) {
            hv13001Movdep().movdep().cPaisIsoaOeOpx().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cPaisIsoaOeOpx());
            hv13001Movdep().movdep().cMnemEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cMnemEgcOpex());
            hv13001Movdep().movdep().cOeEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cOeEgcOpex());
            hv13001Movdep().movdep().cUserid().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cUserid());
            hv13001Movdep().movdep().nJourBbn().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nJourBbn());
            hv13001Movdep().movdep().zProcessamento().set(hrMhoj356a().bhol356a().commarea().dadosOutput().zProcessamento());
        } else {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().naoExistMovCrit());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-07");
        }
    }
    
    /**
     * 
     * 2200-VALIDA-MOV-DEP
     * 
     */
    protected void m2200ValidaMovDep() {
        log(TraceLevel.Debug, "  2200-VALIDA-MOV-DEP");
        hv13001Movdep().movdep().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv13001Movdep().movdep().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv13001Movdep().movdep().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv13001Movdep().movdep().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv13001Movdep().movdep().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv13001Movdep().movdep().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv13001Movdep().movdep().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv13001Movdep().movdep().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "   **** DADOS DE PESQUISA ****");
        log(TraceLevel.Debug, "   VGH13001-Z-PROCESSAMENTO   : ", hv13001Movdep().movdep().zProcessamento());
        log(TraceLevel.Debug, "   VGH13001-C-MNEM-EGC-OPEX   : ", hv13001Movdep().movdep().cMnemEgcOpex());
        log(TraceLevel.Debug, "   VGH13001-C-PAIS-ISOA-OE-OPX: ", hv13001Movdep().movdep().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   VGH13001-C-OE-EGC-OPEX     : ", hv13001Movdep().movdep().cOeEgcOpex());
        log(TraceLevel.Debug, "   VGH13001-C-USERID          : ", hv13001Movdep().movdep().cUserid());
        log(TraceLevel.Debug, "   VGH13001-N-JOUR-BBN        : ", hv13001Movdep().movdep().nJourBbn());
        log(TraceLevel.Debug, "   VGH13001-C-PAIS-ISOA-CONT  : ", hv13001Movdep().movdep().cPaisIsoaCont());
        log(TraceLevel.Debug, "   VGH13001-C-BANC-CONT       : ", hv13001Movdep().movdep().cBancCont());
        log(TraceLevel.Debug, "   VGH13001-C-OE-EGC-CONT     : ", hv13001Movdep().movdep().cOeEgcCont());
        log(TraceLevel.Debug, "   VGH13001-NS-RDCL-CONT      : ", hv13001Movdep().movdep().nsRdclCont());
        log(TraceLevel.Debug, "   VGH13001-V-CHKD-CONT       : ", hv13001Movdep().movdep().vChkdCont());
        log(TraceLevel.Debug, "   VGH13001-C-TIPO-CONT       : ", hv13001Movdep().movdep().cTipoCont());
        log(TraceLevel.Debug, "   VGH13001-C-MOED-ISO-SCTA   : ", hv13001Movdep().movdep().cMoedIsoScta());
        log(TraceLevel.Debug, "   VGH13001-NS-DEPOSITO       : ", hv13001Movdep().movdep().nsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH13001_MOVDEP
         */
        hv13001Movdep().selectPghs121a689() ;
        swSwitches().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        log(TraceLevel.Debug, "   SW-SQLCODE-VGH13001        : ", swSwitches().swSqlcodeVgh13001());
        if (!swSwitches().swVgh13001Ok().isTrue()) {
            if (swSwitches().swVgh13001Notfnd().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().nExistDthlItvtOpe());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, "ERRO-08");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
                log(TraceLevel.Error, "ERRO-09");
            }
            envOut.db2Log().nmTabela().set(CON_VGH13001);
        } else {
            m2210FormataSaida() ;
        }
    }
    
    /**
     * 
     * 2210-FORMATA-SAIDA
     * 
     */
    protected void m2210FormataSaida() {
        log(TraceLevel.Debug, "   2210-FORMATA-SAIDA");
        msgOut().msg().ade().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisIsaEmsDoc());
        msgOut().msg().ade().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocId());
        msgOut().msg().ade().nDocId().set(hv13001Movdep().movdep().nDocId());
        msgOut().msg().ade().zVldeDocId().set(hv13001Movdep().movdep().zVldeDocId());
        msgOut().msg().ade().cEntEmixDocId().set(hv13001Movdep().movdep().cEntEmixDocId());
        msgOut().msg().ade().nmCliente().set(hv13001Movdep().movdep().nmCliente());
        msgOut().msg().ade().iCliCgd().set(hv13001Movdep().movdep().iCliCgd());
        msgOut().msg().ade().cTipoItvtDep().set(hv13001Movdep().movdep().cTipoItvtDep());
        msgOut().msg().ade().cTipoMdti().set(hv13001Movdep().movdep().cTipoMdti());
        msgOut().msg().ade().cTipoCanlAces().set(hv13001Movdep().movdep().cTipoCanlAces());
        if (hv13001Movdep().movdep().iTrnzEfcdOnln().isEqual(CON_1)) {
            msgOut().msg().ade().iTrnzEfcdOnln().set(CON_SIM);
        } else {
            msgOut().msg().ade().iTrnzEfcdOnln().set(CON_NAO);
        }
        msgOut().msg().ade().iPedJstzOrmFnd().set(hv13001Movdep().movdep().iPedJstzOrmFnd());
        msgOut().msg().ade().cMtvoPedJstz().set(hv13001Movdep().movdep().cMtvoPedJstz());
        msgOut().msg().ade().iRcsJstzOrmFnd().set(hv13001Movdep().movdep().iRcsJstzOrmFnd());
        msgOut().msg().ade().iEstorno().set(hv13001Movdep().movdep().iEstorno());
        msgOut().msg().ade().tsActzUlt().set(hv13001Movdep().movdep().tsActzUlt());
        msgOut().msg().ade().cUsidActzUlt().set(hv13001Movdep().movdep().cUsidActzUlt());
        msgOut().msg().ade().cMnemEgcOpex().set(hv13001Movdep().movdep().cMnemEgcOpex());
        msgOut().msg().ade().cPaisIsoaOeOpx().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        msgOut().msg().ade().cOeEgcOpex().set(hv13001Movdep().movdep().cOeEgcOpex());
        msgOut().msg().ade().nCheque().set(hv13001Movdep().movdep().nCheque());
        msgOut().msg().ade().cPaisEmsDocApt().set(hv13001Movdep().movdep().cPaisEmsDocApt());
        msgOut().msg().ade().cTipoDocIdAptd().set(hv13001Movdep().movdep().cTipoDocIdAptd());
        msgOut().msg().ade().nDocIdAptd().set(hv13001Movdep().movdep().nDocIdAptd());
        msgOut().msg().ade().zVldeDocIdAptd().set(hv13001Movdep().movdep().zVldeDocIdAptd());
        msgOut().msg().ade().cEntEmiDidAptd().set(hv13001Movdep().movdep().cEntEmiDidAptd());
        msgOut().msg().ade().mMovEuro().set(hv13001Movdep().movdep().mMovEuro());
        msgOut().msg().ade().cTipoOpeCont().set(hv13001Movdep().movdep().cTipoOpeCont());
        /**
         * PASSIVAS 4497 (INICIO)
         */
        msgOut().msg().ade().cTipRelDep().set(hv13001Movdep().movdep().cTipoRelDpst());
        msgOut().msg().ade().xInfJstzDep().set(hv13001Movdep().movdep().xInfJstzDep());
    }
    
    /**
     * 
     * 2300-OBTEM-N-CLIENTE
     * 
     */
    protected void m2300ObtemNCliente() {
        log(TraceLevel.Debug, "  2300-OBTEM-N-CLIENTE");
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(hv13001Movdep().movdep().cMnemEgcOpex());
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisIsaEmsDoc());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocId());
        bhjl027a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocId());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISOA-OE-OPX: ", bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BHJL027A-C-MNEM-EGC-OPEX   : ", bhjl027a().commarea().dadosEntrada().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISA-EMS-DOC: ", bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BHJL027A-C-TIPO-DOC-ID     : ", bhjl027a().commarea().dadosEntrada().cTipoDocId());
        log(TraceLevel.Debug, "   BHJL027A-N-DOC-ID          : ", bhjl027a().commarea().dadosEntrada().nDocId());
        bhjp5027AcedeMhjj027a() ;
        if (bhjl027a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().nCliente().set(bhjl027a().commarea().dadosSaida().nCliente());
            msgOut().msg().ade().nsAbraCli().set(bhjl027a().commarea().dadosSaida().nsAbraCli());
        } else if (bhjl027a().commarea().erros().erroFuncao().isTrue() && bhjl027a().commarea().erros().docRepetido().isTrue()) {
            msgOut().msg().ade().nCliente().set(0);
            msgOut().msg().ade().nsAbraCli().set(0);
            msgOut().msg().ade().iCliCgd().set(CON_VARIOS_CLI_CGD);
        } else {
            envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
            envOut.errosGraves().cTipoErroBbn().set(bhjl027a().commarea().erros().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
            if (bhjl027a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
                log(TraceLevel.Error, "ERRO-10");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, "ERRO-11");
            }
        }
    }
    
    /**
     * 
     * 2400-OBTEM-X-INF-ATS
     * 
     */
    protected void m2400ObtemXInfAts() {
        log(TraceLevel.Debug, " 2400-OBTEM-X-INF-ATS");
        hrMdrj402a().bdrl402a().commarea().initialize() ;
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akZProcessamento().set(hv13001Movdep().movdep().zProcessamento());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCPaisIsoaOeRpl().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCMnemEgcRspl().set(hv13001Movdep().movdep().cMnemEgcOpex());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCOeEgcRspl().set(hv13001Movdep().movdep().cOeEgcOpex());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCUserid().set(hv13001Movdep().movdep().cUserid());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akNJourBbn().set(hv13001Movdep().movdep().nJourBbn());
        hrMdrj402a().run() ;
        if (hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().semErros().isTrue()) {
            msgOut().msg().ade().xInfAts().set(concat(CON_ATM_CGD, hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofNmLocalidade()));
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCSqlcode());
            envOut.db2Log().nmTabela().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeNmTabela());
            if (hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().errosFuncao().isTrue()) {
                envOut.errosGraves().aAplErr().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeAAplErr());
                envOut.errosGraves().cTipoErroBbn().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCTipoErroBbn());
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCRtnoEvenSwal());
                log(TraceLevel.Error, "ERRO-12");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, "ERRO-13");
            }
            log(TraceLevel.Error, "   ERRO AO OBTER X-INF-ATS DA ROTINA MDRJ402A");
            log(TraceLevel.Error, "   BDRL402A-OE-C-TIPO-ERRO-BBN : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCTipoErroBbn());
            log(TraceLevel.Error, "   BDRL402A-OE-A-APL-ERR       : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeAAplErr());
            log(TraceLevel.Error, "   BDRL402A-OE-C-RTNO-EVEN-SWAL: ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCRtnoEvenSwal());
            log(TraceLevel.Error, "   BDRL402A-OE-C-SQLCODE       : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCSqlcode());
            log(TraceLevel.Error, "   BDRL402A-OE-NM-TABELA       : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeNmTabela());
        }
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, " 3000-FINAL-PROGRAMA");
        message.mensagem().headerR().transaccao().anulNotrunc().setTrue() ;
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        log(TraceLevel.Debug, "   BGHM1121-ASE ", msgOut().msg().ase());
        m3100MensagemOutput() ;
        exit() ;
    }
    
    /**
     * 
     * 3100-MENSAGEM-OUTPUT
     * 
     */
    protected void m3100MensagemOutput() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, " 3000-FINAL-PROGRAMA");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "  -----------------  ", envOut.errosGraves().aAplErr(), "/", envOut.errosGraves().cRtnoEvenSwal());
        log(TraceLevel.Debug, "  -----------------  ");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "   BGHM1121-C-PAIS-ISOA-OE-OPX   : ", msgOut().msg().ade().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1121-C-MNEM-EGC-OPEX      : ", msgOut().msg().ade().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1121-C-OE-EGC-OPEX        : ", msgOut().msg().ade().cOeEgcOpex());
        log(TraceLevel.Debug, "   BGHM1121-C-PAIS-ISA-EMS-DOC   : ", msgOut().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BGHM1121-C-TIPO-DOC-ID        : ", msgOut().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "   BGHM1121-N-DOC-ID             : ", msgOut().msg().ade().nDocId());
        log(TraceLevel.Debug, "   BGHM1121-Z-VLDE-DOC-ID        : ", msgOut().msg().ade().zVldeDocId());
        log(TraceLevel.Debug, "   BGHM1121-C-ENT-EMIX-DOC-ID    : ", msgOut().msg().ade().cEntEmixDocId());
        log(TraceLevel.Debug, "   BGHM1121-C-PAIS-EMS-DOC-APT   : ", msgOut().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "   BGHM1121-C-TIPO-DOC-ID-APTD   : ", msgOut().msg().ade().cTipoDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1121-N-DOC-ID-APTD        : ", msgOut().msg().ade().nDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1121-Z-VLDE-DOC-ID-APTD   : ", msgOut().msg().ade().zVldeDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1121-C-ENT-EMI-DID-APTD   : ", msgOut().msg().ade().cEntEmiDidAptd());
        log(TraceLevel.Debug, "   BGHM1121-N-CHEQUE             : ", msgOut().msg().ade().nCheque());
        log(TraceLevel.Debug, "   BGHM1121-N-CLIENTE            : ", msgOut().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1121-NS-ABRA-CLI          : ", msgOut().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "   BGHM1121-NM-CLIENTE           : ", msgOut().msg().ade().nmCliente());
        log(TraceLevel.Debug, "   BGHM1121-I-CLI-CGD            : ", msgOut().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1121-C-TIPO-ITVT-DEP      : ", msgOut().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "   BGHM1121-C-TIPO-MDTI          : ", msgOut().msg().ade().cTipoMdti());
        log(TraceLevel.Debug, "   BGHM1121-M-MOV-EURO           : ", msgOut().msg().ade().mMovEuro());
        log(TraceLevel.Debug, "   BGHM1121-C-TIPO-CANL-ACES     : ", msgOut().msg().ade().cTipoCanlAces());
        log(TraceLevel.Debug, "   BGHM1121-X-INF-ATS            : ", msgOut().msg().ade().xInfAts());
        log(TraceLevel.Debug, "   BGHM1121-C-TIPO-OPE-CONT      : ", msgOut().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "   BGHM1121-I-TRNZ-EFCD-ONLN     : ", msgOut().msg().ade().iTrnzEfcdOnln());
        log(TraceLevel.Debug, "   BGHM1121-I-PED-JSTZ-ORM-FND   : ", msgOut().msg().ade().iPedJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1121-C-MTVO-PED-JSTZ      : ", msgOut().msg().ade().cMtvoPedJstz());
        log(TraceLevel.Debug, "   BGHM1121-I-RCS-JSTZ-ORM-FND   : ", msgOut().msg().ade().iRcsJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1121-I-ESTORNO            : ", msgOut().msg().ade().iEstorno());
        log(TraceLevel.Debug, "   BGHM1121-C-TIP-REL-DEP        : ", msgOut().msg().ade().cTipRelDep());
        log(TraceLevel.Debug, "   BGHM1121-X-INF-JSTZ-DEP       : ", msgOut().msg().ade().xInfJstzDep());
        log(TraceLevel.Debug, "   BGHM1121-TS-ACTZ-ULT          : ", msgOut().msg().ade().tsActzUlt());
        log(TraceLevel.Debug, "   BGHM1121-C-USID-ACTZ-ULT      : ", msgOut().msg().ade().cUsidActzUlt());
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "******** FIM * GHIG * MVPHIG * FIM ***********");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, " ");
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        m0000Mainline() ;
    }
    /**
     * Inner Classes
     */
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitches extends IDataStruct {
        
        /**
         * ----- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh13001() ;
        @Data
        @Condition("0")
        ICondition swVgh13001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh13001Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh13001Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh13001Null() ;
        
        
    }
    
}
