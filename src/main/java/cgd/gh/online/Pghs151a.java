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
import cgd.gh.structures.messages.Bghm1150 ;
import cgd.gh.structures.messages.Bghm1151 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.hj.structures.link.Bhjl027a ;
import cgd.he.structures.link.Bhel100a ;
import cgd.hj.structures.link.Bhjl042a ;
import cgd.hj.structures.link.Bhjl628a ;
import cgd.hj.structures.link.Bhjl014a ;
import cgd.gh.structures.link.Bghl300a ;
import cgd.hj.structures.link.Bhjl006a ;
import cgd.hj.routines.Mhjj027a ;
import cgd.he.routines.Mhej100a ;
import cgd.hj.routines.Mhjj042a ;
import cgd.hj.routines.Mhjj628a ;
import cgd.hj.routines.Mhjj014a ;
import cgd.gh.routines.Mghj300a ;
import cgd.hj.routines.Mhjs006a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS151A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1692 - TERC - 3ª FASE - TRANSACOES OCASIONIAS
 * FUNCAO     : CONSULTA DE DADOS COMPLEMENTARES DE MOVIMENTOS
 * OCASIONAIS (DADOS DO INTERVENIENTE NA OPERACAO)
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES: LOCAL - MVPHIJ - TRANSACAO SEMPRE ENCADEADA
 * LOG DE ALTERACOES
 * PROCESSO!   DATA   ! UTILZ ! OBSERVACOES
 * GH1692  !2015-03-04!ACT0649! TERC - FASE 3 -  CRIACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs151a extends CgdGhBaseOnline<Pghs151a.EnvelopeIn, Pghs151a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1150
     */
    public abstract Bghm1150 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1151
     */
    public abstract Bghm1151 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1150.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1151.Msg msgOut() ;
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
     * @return instancia da classe Mhej100a
     */
    @Data
    protected abstract Mhej100a hrMhej100a() ;
    
    /**
     * @return instancia da classe Mhjj042a
     */
    @Data
    protected abstract Mhjj042a hrMhjj042a() ;
    
    /**
     * @return instancia da classe Mhjj628a
     */
    @Data
    protected abstract Mhjj628a hrMhjj628a() ;
    
    /**
     * @return instancia da classe Mhjj014a
     */
    @Data
    protected abstract Mhjj014a hrMhjj014a() ;
    
    /**
     * @return instancia da classe Mghj300a
     */
    @Data
    protected abstract Mghj300a hrMghj300a() ;
    
    /**
     * @return instancia da classe Mhjs006a
     */
    @Data
    protected abstract Mhjs006a hrMhjs006a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * @return instancia da classe Bhjl027a
     */
    @Data
    protected abstract Bhjl027a bhjl027a() ;
    
    /**
     * @return instancia da classe Bhel100a
     */
    @Data
    protected abstract Bhel100a bhel100a() ;
    
    /**
     * @return instancia da classe Bhjl042a
     */
    @Data
    protected abstract Bhjl042a bhjl042a() ;
    
    /**
     * @return instancia da classe Bhjl628a
     */
    @Data
    protected abstract Bhjl628a bhjl628a() ;
    
    /**
     * @return instancia da classe Bhjl014a
     */
    @Data
    protected abstract Bhjl014a bhjl014a() ;
    
    /**
     * @return instancia da classe Bghl300a
     */
    @Data
    protected abstract Bghl300a bghl300a() ;
    
    /**
     * @return instancia da classe Bhjl006a
     */
    @Data
    protected abstract Bhjl006a bhjl006a() ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     * ----- DB2
     */
    protected static final String CON_SELECT = "SE" ;
    
    protected static final String CON_INSERT = "IN" ;
    
    protected static final String CON_UPDATE = "UP" ;
    
    protected static final String CON_DELETE = "DL" ;
    
    protected static final String CON_VGH13001 = "VGH13001" ;
    
    protected static final String CON_A_APL_GH = "GH" ;
    
    protected static final String CON_SIM = "S" ;
    
    protected static final String CON_NAO = "N" ;
    
    protected static final String CON_1 = "1" ;
    
    protected static final String CON_VARIOS_CLI_CGD = "V" ;
    
    protected static final String CON_PARTICULAR = "P" ;
    
    protected static final String CON_EMPRESA = "E" ;
    
    protected static final String CON_PT = "PT" ;
    
    /**
     * *---TIPO DE OPERACAO
     */
    protected static final String CON_CAMBIO = "C" ;
    
    protected static final String CON_TROCO_DESTROCO = "D" ;
    
    protected static final String CON_OCASIONAIS = "O" ;
    
    protected static final String CON_TRANSFERENCIAS = "T" ;
    
    protected static final String CON_ORDENS_EMITIDAS = "S" ;
    
    protected static final String CON_ORDENS_RECEBIDAS = "R" ;
    
    /**
     * *---DOCUMENTOS FISCAIS VALIDOS - SINGULAR
     * @return instancia da classe local ConDocNif
     */
    @Data
    protected abstract ConDocNif conDocNif() ;
    
    /**
     * @return instancia da classe local ConDocNfePs
     */
    @Data
    protected abstract ConDocNfePs conDocNfePs() ;
    
    /**
     * ****                CONSTANTES NUMERICAS                  ****
     */
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_3N = 3 ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
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
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MHEJ100A - MANUTENCAO DA TABELA DE DADOS DE NAO CLIENTES
     * 
     */
    protected void bhep5100TabNaoClientes() {
    }
    
    /**
     * 
     * BHJP5042-ACESSO AO MODULO QUE DEVOLVE AS ACTIVIDADES
     * DO CLIENTE (MHJJ042A)
     * 
     */
    protected void bhjp5042AcedeMhjj042a() {
        hrMhjj042a().run() ;
    }
    
    /**
     * 
     * ROTINA DE MANUTENCAO DA TABELA DE DOCUMENTOS
     * DE IDENTIFICACAO (THJ00023)
     * 
     */
    protected void bhjp0628Mhjj628a() {
    }
    
    /**
     * 
     * BHJP5014-ACESSO AO MODULO DE OBTENCAO DOS DADOS
     * COMPLEMENTARES DO CLIENTE (MHJJ014A)
     * 
     */
    protected void bhjp5014AcedeMhjj014a() {
        hrMhjj014a().run() ;
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MGHJ300A - VERIFICA ESTADO ORDENS EMITIDAS OU RECEBIDAS
     * 
     */
    protected void bghp1300VerifEstadOrd() {
    }
    
    /**
     * 
     * BHJP6006-ACESSO AO MODULO QUE VALIDA A EXISTENCIA DO CLIENTE
     * E DEVOLVE ALGUNS INDICADORES BASICOS (MHJS006A)
     * 
     */
    protected void bhjp6006AcedeMhjs006a() {
    }
    
    /**
     * 
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "***** INICIO * GHIJ * MVPHIJ * INICIO ********");
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
        wsVariaveis().initialize() ;
        bhjl027a().commarea().initialize() ;
        bhjl014a().commarea().initialize() ;
        bhjl628a().commarea().initialize() ;
        bhjl042a().commarea().initialize() ;
        bhel100a().commarea().initialize() ;
        bghl300a().commarea().initialize() ;
        bhjl006a().commarea().initialize() ;
        msgOut().msg().ade().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().indice().set(0);
        swSwitches().swCTipoOpeCont().set(msgIn().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "   SW-C-TIPO-OPE-CONT : ", swSwitches().swCTipoOpeCont());
        log(TraceLevel.Debug, "    1 - CAMBIO .................. C  J K");
        log(TraceLevel.Debug, "          SGOCVN-HE34 ........... J");
        log(TraceLevel.Debug, "          SGOCVN-HE35 ........... K");
        log(TraceLevel.Debug, "    2 - TROCO-DESTROCO .......... D");
        log(TraceLevel.Debug, "    3 - TRANSFERENCIAS .......... T  S R");
        log(TraceLevel.Debug, "          ORDENS-EMITIDAS ....... S");
        log(TraceLevel.Debug, "          ORDENS-RECEBIDAS ...... R");
        log(TraceLevel.Debug, "    4 - OCASIONAIS .............. O  X H Y V");
        log(TraceLevel.Debug, "          SGIX02 ................ X");
        log(TraceLevel.Debug, "          SGOVTC-HE37 ........... H");
        log(TraceLevel.Debug, "          PI3501-EMISS-CHQ....... Y");
        log(TraceLevel.Debug, "          CHQHB0-CHQ-BANCARIO.... V");
        log(TraceLevel.Debug, "  ");
        log(TraceLevel.Debug, "    ANULACOES / ESTORNOS ");
        log(TraceLevel.Debug, "          PI3105-ESTORNO-ORDENS.. U");
        log(TraceLevel.Debug, "          PI3102-CAN-ANUL-EMITD.. W");
        log(TraceLevel.Debug, "          PI3503-ANUL-ESTOR-CHQ.. Z");
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
        log(TraceLevel.Debug, "   BGHM1150-C-PAIS-ISO-ALFN   : ", msgIn().msg().ade().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   BGHM1150-C-MNEM-EMP-GCX    : ", msgIn().msg().ade().cMnemEmpGcx());
        log(TraceLevel.Debug, "   BGHM1150-C-REF-MSG-SWIF    : ", msgIn().msg().ade().cRefMsgSwif());
        log(TraceLevel.Debug, "   BGHM1150-C-TIPO-OPE-CONT   : ", msgIn().msg().ade().cTipoOpeCont());
        if (envOut.errosGraves().semErros().isTrue() && 
            (msgIn().msg().ade().cPaisIsoAlfn().isEmpty() || 
            msgIn().msg().ade().cMnemEmpGcx().isEmpty() || 
            msgIn().msg().ade().cRefMsgSwif().isEmpty() || 
            msgIn().msg().ade().cTipoOpeCont().isEmpty())) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
            log(TraceLevel.Error, " ERRO-01");
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        if (envOut.errosGraves().semErros().isTrue()) {
            m2100ValidaMovDep() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * ----- TRATA CLIENTE INTERVENIENTE NA OPERACAO
             */
            if (msgOut().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                m2200ObtemCliCgd() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (!msgOut().msg().ade().nCliente().isEqual(0)) {
                        m2300ObtemDadosCli() ;
                        if (envOut.errosGraves().semErros().isTrue()) {
                            if (!msgOut().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                                swSwitches().swBuscaDocSim().setTrue() ;
                                swSwitches().swDoc().set(" ");
                                while (!swSwitches().swBuscaDocNao().isTrue() && envOut.errosGraves().semErros().isTrue()) {
                                    m2400ObtemNif() ;
                                }
                            } else {
                                msgOut().msg().ade().nIpc().set(msgOut().msg().ade().nDocId());
                            }
                        }
                        if (envOut.errosGraves().semErros().isTrue() && 
                            !msgOut().msg().ade().cTipoCli().isEqual(CON_PARTICULAR)) {
                            m2500ObtemCae() ;
                        }
                    }
                }
            } else if (msgOut().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                m2600ObtemNCliCgd() ;
            }
            /**
             * OBTENCAO DOS DADOS DO REPRESENTANTE DA EMPRESA
             */
            if (envOut.errosGraves().semErros().isTrue()) {
                if (msgOut().msg().ade().iRprtCliCgd().isEqual(CON_SIM)) {
                    m2700ObtemCliCgdRprt() ;
                    if (envOut.errosGraves().semErros().isTrue()) {
                        if (!msgOut().msg().ade().nClienteRprt().isEqual(0)) {
                            m2800ObtemDadosCliRprt() ;
                        }
                    }
                }
                if (msgOut().msg().ade().iRprtCliCgd().isEqual(CON_NAO)) {
                    m2900ObtemNCliCgdRprt() ;
                }
            }
        }
    }
    
    /**
     * 
     * 2100-VALIDA-MOV-DEP
     * 
     */
    protected void m2100ValidaMovDep() {
        log(TraceLevel.Debug, "  2100-VALIDA-MOV-DEP");
        hv13001Movdep().movdep().cPaisIsoAlfn().set(msgIn().msg().ade().cPaisIsoAlfn());
        hv13001Movdep().movdep().cMnemEmpGcx().set(msgIn().msg().ade().cMnemEmpGcx());
        hv13001Movdep().movdep().cRefMsgSwif().set(msgIn().msg().ade().cRefMsgSwif());
        swSwitches().swCTipoOpeCont().set(msgIn().msg().ade().cTipoOpeCont());
        /**
         * -- DESCODIFICA TIPO DE OPERACAO DE ENTRADA
         */
        if (swSwitches().swCambio().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_CAMBIO);
        } else if (swSwitches().swTrocoDestroco().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_TROCO_DESTROCO);
        } else if (swSwitches().swOrdensEmitidas().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_ORDENS_EMITIDAS);
        } else if (swSwitches().swOrdensRecebidas().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_ORDENS_RECEBIDAS);
        } else if (swSwitches().swOcasionais().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_OCASIONAIS);
        }
        log(TraceLevel.Debug, "   VGH13001-C-PAIS-ISO-ALFN   : ", hv13001Movdep().movdep().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   VGH13001-C-MNEM-EMP-GCX    : ", hv13001Movdep().movdep().cMnemEmpGcx());
        log(TraceLevel.Debug, "   VGH13001-C-REF-MSG-SWIF    : ", hv13001Movdep().movdep().cRefMsgSwif());
        log(TraceLevel.Debug, "   VGH13001-C-TIPO-OPE-CONT   : ", hv13001Movdep().movdep().cTipoOpeCont());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH13001_MOVDEP
         */
        hv13001Movdep().selectPghs151a470() ;
        swSwitches().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv13001Movdep().getPersistenceCode());
        log(TraceLevel.Debug, "   WS-SQLCODE-ERRO            : ", wsVariaveis().wsSqlcodeErro());
        if (swSwitches().swVgh13001Ok().isTrue()) {
            m2110FormataSaida() ;
        } else {
            if (swSwitches().swVgh13001Notfnd().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nExistDthlItvtOpe());
                envOut.errosGraves().aAplErr().set(CON_A_APL_GH);
                log(TraceLevel.Error, " ERRO-02");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
                log(TraceLevel.Error, " ERRO-03");
            }
            envOut.db2Log().nmTabela().set(CON_VGH13001);
        }
    }
    
    /**
     * 
     * 2110-FORMATA-SAIDA
     * 
     */
    protected void m2110FormataSaida() {
        log(TraceLevel.Debug, "   2110-FORMATA-SAIDA");
        /**
         * -- REFERENCIA DA ORDEM
         */
        msgOut().msg().ade().cPaisIsoAlfn().set(hv13001Movdep().movdep().cPaisIsoAlfn());
        msgOut().msg().ade().cMnemEmpGcx().set(hv13001Movdep().movdep().cMnemEmpGcx());
        msgOut().msg().ade().cRefMsgSwif().set(hv13001Movdep().movdep().cRefMsgSwif());
        /**
         * -- VALIDAR SE O ESTADO DA ORDEM E FINAL
         */
        swSwitches().swCEstMsgSwif().set(hv13001Movdep().movdep().cEstMsgSwif());
        log(TraceLevel.Debug, "   SW-C-EST-MSG-SWIF 1: ", swSwitches().swCEstMsgSwif());
        if (hv13001Movdep().movdep().cPaisIsoAlfn().isEmpty() || 
            (!hv13001Movdep().movdep().cTipoOpeCont().isEqual(CON_ORDENS_EMITIDAS) && 
            !hv13001Movdep().movdep().cTipoOpeCont().isEqual(CON_ORDENS_RECEBIDAS))) {
            /**
             * NAO SE TRATA DE REGISTO SGOE
             */
            msgOut().msg().ade().cEstMsgSwif().set(" ");
        } else if (swSwitches().swEstFinalValidos().isTrue()) {
            /**
             * TRATA DE REGISTO COM ESTADO VALIDO
             */
            msgOut().msg().ade().cEstMsgSwif().set(hv13001Movdep().movdep().cEstMsgSwif());
        } else {
            m2111ValEstMsgSwif() ;
        }
        /**
         * -- DOCUMENTO APRESENTADO DO ITVT OU DO RPRT
         */
        msgOut().msg().ade().cPaisEmsDocApt().set(hv13001Movdep().movdep().cPaisEmsDocApt());
        msgOut().msg().ade().cTipoDocIdAptd().set(hv13001Movdep().movdep().cTipoDocIdAptd());
        msgOut().msg().ade().nDocIdAptd().set(hv13001Movdep().movdep().nDocIdAptd());
        msgOut().msg().ade().zVldeDocIdAptd().set(hv13001Movdep().movdep().zVldeDocIdAptd());
        msgOut().msg().ade().cEntEmiDidAptd().set(hv13001Movdep().movdep().cEntEmiDidAptd());
        /**
         * -- DOCUMENTO PRINCIPAL DO ITVT E DA EMPRESA
         */
        msgOut().msg().ade().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisIsaEmsDoc());
        msgOut().msg().ade().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocId());
        msgOut().msg().ade().nDocId().set(hv13001Movdep().movdep().nDocId());
        msgOut().msg().ade().zVldeDocId().set(hv13001Movdep().movdep().zVldeDocId());
        msgOut().msg().ade().cEntEmixDocId().set(hv13001Movdep().movdep().cEntEmixDocId());
        /**
         * -- DADOS DA OPERACAO (JOURNAL)
         */
        msgOut().msg().ade().cPaisIsoaOeOpx().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        msgOut().msg().ade().cMnemEgcOpex().set(hv13001Movdep().movdep().cMnemEgcOpex());
        msgOut().msg().ade().cOeEgcOpex().set(hv13001Movdep().movdep().cOeEgcOpex());
        swSwitches().swCTipoOpeCont().set(hv13001Movdep().movdep().cTipoOpeCont());
        /**
         * -- DESCODIFICA TIPO DE OPERACAO DE SAIDA
         */
        if (swSwitches().swCambio().isTrue()) {
            msgOut().msg().ade().cTipoOpeCont().set(CON_CAMBIO);
        } else if (swSwitches().swTrocoDestroco().isTrue()) {
            msgOut().msg().ade().cTipoOpeCont().set(CON_TROCO_DESTROCO);
        } else if (swSwitches().swOrdensEmitidas().isTrue() || swSwitches().swOrdensRecebidas().isTrue()) {
            msgOut().msg().ade().cTipoOpeCont().set(CON_TRANSFERENCIAS);
        } else if (swSwitches().swOcasionais().isTrue()) {
            msgOut().msg().ade().cTipoOpeCont().set(CON_OCASIONAIS);
        }
        msgOut().msg().ade().cTipoCanlAces().set(hv13001Movdep().movdep().cTipoCanlAces());
        if (hv13001Movdep().movdep().iTrnzEfcdOnln().isEqual(CON_1)) {
            msgOut().msg().ade().iTrnzEfcdOnln().set(CON_SIM);
        } else {
            msgOut().msg().ade().iTrnzEfcdOnln().set(CON_NAO);
        }
        msgOut().msg().ade().iEstorno().set(hv13001Movdep().movdep().iEstorno());
        msgOut().msg().ade().cTipoItvtDep().set(hv13001Movdep().movdep().cTipoItvtDep());
        msgOut().msg().ade().mMovEuro().set(hv13001Movdep().movdep().mMovEuro());
        msgOut().msg().ade().iPedJstzOrmFnd().set(hv13001Movdep().movdep().iPedJstzOrmFnd());
        msgOut().msg().ade().iRcsJstzOrmFnd().set(hv13001Movdep().movdep().iRcsJstzOrmFnd());
        msgOut().msg().ade().cMtvoPedJstz().set(hv13001Movdep().movdep().cMtvoPedJstz());
        msgOut().msg().ade().nCheque().set(hv13001Movdep().movdep().nCheque());
        msgOut().msg().ade().iCliCgd().set(hv13001Movdep().movdep().iCliCgd());
        wsVariaveis().wsNmClienteTemp().set(hv13001Movdep().movdep().nmCliente());
        /**
         * DOC PRINCIPAL DO REPRESENTANTE DA EMPRESA (DOCUMENTOS)
         */
        msgOut().msg().ade().cPaisEmsDocRpt().set(hv13001Movdep().movdep().cPaisEmsDocRpt());
        msgOut().msg().ade().cTipoDocIdRprt().set(hv13001Movdep().movdep().cTipoDocIdRprt());
        msgOut().msg().ade().nDocIdRprt().set(hv13001Movdep().movdep().nDocIdRprt());
        msgOut().msg().ade().zVldeDocIdRprt().set(hv13001Movdep().movdep().zVldeDocIdRprt());
        msgOut().msg().ade().cEntEmixDidRpt().set(hv13001Movdep().movdep().cEntEmixDidRpt());
        msgOut().msg().ade().iRprtCliCgd().set(hv13001Movdep().movdep().iRprtCliCgd());
    }
    
    /**
     * 
     * 2111-VAL-EST-MSG-SWIF
     * 
     */
    protected void m2111ValEstMsgSwif() {
        log(TraceLevel.Debug, "    2111-VAL-EST-MSG-SWIF");
        bghl300a().commarea().initialize() ;
        bghl300a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bghl300a().commarea().dadosEntrada().cPaisIsoAlfn().set(hv13001Movdep().movdep().cPaisIsoAlfn());
        bghl300a().commarea().dadosEntrada().cMnemEmpGcx().set(hv13001Movdep().movdep().cMnemEmpGcx());
        bghl300a().commarea().dadosEntrada().cRefMsgSwif().set(hv13001Movdep().movdep().cRefMsgSwif());
        bghl300a().commarea().dadosEntrada().cTipoOpeCont().set(hv13001Movdep().movdep().cTipoOpeCont());
        bghl300a().commarea().dadosEntrada().cEstMsgSwifI().set(hv13001Movdep().movdep().cEstMsgSwif());
        bghp1300VerifEstadOrd() ;
        if (bghl300a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().cEstMsgSwif().set(bghl300a().commarea().dadosSaida().cEstMsgSwifO());
            swSwitches().swCEstMsgSwif().set(bghl300a().commarea().dadosSaida().cEstMsgSwifO());
            log(TraceLevel.Debug, "   SW-C-EST-MSG-SWIF 2: ", swSwitches().swCEstMsgSwif());
        } else {
            /**
             * -- A MVPHIJ mostra todos os estados, independente de ser estado
             * final ou nao. A MVPHII só mostra os válidos.
             * IF SW-EST-FINAL-VALIDOS
             * CONTINUE
             * ELSE
             * MOVE CON-A-APL-GH         TO BHTL001A-A-APL-ERR
             * SET BHTL001A-ERROS-FUNCAO TO TRUE
             * SET BGHM1151-C-PAIS-ISO-ALFN-1
             * TO TRUE
             * MOVE BGHK0001-NAO-EXIST-MOV-CRIT
             * TO BGHM1151-C-PAIS-ISO-ALFN-M
             * DISPLAY ' ERRO-04'
             * END-IF
             */
            envOut.db2Log().sqlca().cSqlcode().set(bghl300a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bghl300a().commarea().erros().nmTabela());
            if (bghl300a().commarea().erros().erroFuncao().isTrue()) {
                envOut.errosGraves().aAplErr().set(bghl300a().commarea().erros().aAplErr());
                envOut.errosGraves().cTipoErroBbn().set(bghl300a().commarea().erros().cTipoErroBbn());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghl300a().commarea().erros().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-05");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-06");
            }
        }
    }
    
    /**
     * 
     * 2200-OBTEM-CLI-CGD
     * 
     */
    protected void m2200ObtemCliCgd() {
        log(TraceLevel.Debug, "  2200-OBTEM-CLI-CGD");
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(hv13001Movdep().movdep().cMnemEgcOpex());
        /**
         * *--- DOCUMENTO PRINCIPAL DO ITVT
         */
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
            msgOut().msg().ade().nmCliente().set(wsVariaveis().wsNmClienteTemp());
        } else {
            envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
            envOut.errosGraves().cTipoErroBbn().set(bhjl027a().commarea().erros().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
            if (bhjl027a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-07");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-08");
            }
        }
    }
    
    /**
     * 
     * 2300-OBTEM-DADOS-CLI
     * 
     */
    protected void m2300ObtemDadosCli() {
        log(TraceLevel.Debug, "  2300-OBTEM-DADOS-CLI");
        bhjl014a().commarea().initialize() ;
        bhjl014a().commarea().dadosEntrada().nCliente().set(msgOut().msg().ade().nCliente());
        bhjl014a().commarea().dadosEntrada().nsAbraCli().set(msgOut().msg().ade().nsAbraCli());
        bhjp5014AcedeMhjj014a() ;
        if (!bhjl014a().commarea().erros().semErros().isTrue()) {
            if (bhjl014a().commarea().erros().abendDb2().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl014a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl014a().commarea().erros().nmTabela());
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhjl014a().commarea().erros().cTipoErroBbn());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnS().set(CON_1);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl014a().commarea().erros().cRtnoEvenSwal());
                envOut.errosGraves().aAplErr().set(bhjl014a().commarea().erros().aAplErr());
            }
        } else {
            msgOut().msg().ade().cTipoCli().set(bhjl014a().commarea().dadosEntrada().cTipoCli());
            /**
             * -- SE CLIENTE PARTICULAR
             */
            if (!bhjl014a().commarea().dadosEntrada().cTipoCli().isEqual(CON_EMPRESA)) {
                msgOut().msg().ade().zNascCli().set(bhjl014a().commarea().dadosSaida().zNascCli());
                msgOut().msg().ade().cPaisNacnCli().set(bhjl014a().commarea().dadosSaida().cPaisIsoaNasc());
                msgOut().msg().ade().nmCliente().set(wsVariaveis().wsNmClienteTemp());
            } else {
                msgOut().msg().ade().nmEmpRnpc().set(wsVariaveis().wsNmClienteTemp());
            }
        }
    }
    
    /**
     * 
     * 2400-OBTEM-NIF
     * 
     */
    protected void m2400ObtemNif() {
        log(TraceLevel.Debug, "  2400-OBTEM-NIF");
        bhjl628a().commarea().initialize() ;
        bhjl628a().commarea().visualizacao().setTrue() ;
        bhjl628a().commarea().thj00023Docid().dadosInput().nCliente().set(msgOut().msg().ade().nCliente());
        bhjl628a().commarea().thj00023Docid().dadosInput().nsAbraCli().set(msgOut().msg().ade().nsAbraCli());
        if (!swSwitches().swDocNok().isTrue()) {
            bhjl628a().commarea().thj00023Docid().dadosInput().cPaisIsaEmsDoc().set(conDocNif().conNifCPais());
            bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().set(conDocNif().conNifTDoc());
        } else {
            bhjl628a().commarea().thj00023Docid().dadosInput().cPaisIsaEmsDoc().set(conDocNfePs().conNfeCPais());
            bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().set(conDocNfePs().conNfeTDoc());
        }
        log(TraceLevel.Debug, "   BHJL628A-C-TIPO-DOC-ID : ", bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId());
        bhjp0628Mhjj628a() ;
        if (bhjl628a().commarea().dadosErro().semErros().isTrue()) {
            swSwitches().swBuscaDocNao().setTrue() ;
            swSwitches().swDocOk().setTrue() ;
            msgOut().msg().ade().nif().set(bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId());
        } else if (bhjl628a().commarea().dadosErro().abendDb2().isTrue()) {
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl628a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl628a().commarea().dadosErro().nmTabela());
        } else if (bhjl628a().commarea().dadosErro().docNaoExis().isTrue()) {
            swSwitches().swBuscaDocSim().setTrue() ;
            swSwitches().swDocNok().setTrue() ;
        }
        if (bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().isEqual(conDocNfePs().conNfeTDoc())) {
            swSwitches().swBuscaDocNao().setTrue() ;
        }
    }
    
    /**
     * 
     * 2500-OBTEM-CAE
     * 
     */
    protected void m2500ObtemCae() {
        log(TraceLevel.Debug, "  2500-OBTEM-CAE    ");
        bhjl042a().commarea().initialize() ;
        bhjl042a().commarea().dadosEntrada().nCliente().set(msgOut().msg().ade().nCliente());
        bhjl042a().commarea().dadosEntrada().nsAbraCli().set(msgOut().msg().ade().nsAbraCli());
        bhjl042a().commarea().dadosEntrada().obtemUma().setTrue() ;
        bhjp5042AcedeMhjj042a() ;
        if (!bhjl042a().commarea().erros().semErros().isTrue()) {
            if (!bhjl042a().commarea().erros().fimConsulta().isTrue()) {
                if (bhjl042a().commarea().erros().abendDb2().isTrue()) {
                    envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                    envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                    envOut.db2Log().sqlca().cSqlcode().set(bhjl042a().commarea().erros().cSqlcode());
                    envOut.db2Log().nmTabela().set(bhjl042a().commarea().erros().nmTabela());
                }
            }
        } else {
            msgOut().msg().ade().cAe().set(bhjl042a().commarea().dadosSaida().get(1).cAe());
        }
    }
    
    /**
     * 
     * 2600-OBTEM-N-CLI-CGD
     * 
     */
    protected void m2600ObtemNCliCgd() {
        log(TraceLevel.Debug, " 2600-OBTEM-N-CLI-CGD");
        bhel100a().commarea().initialize() ;
        bhel100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bhel100a().commarea().dadosEntrada().iOperacao().set(CON_3N);
        bhel100a().commarea().dadosEntrada().cPaisIsoaOpe().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhel100a().commarea().dadosEntrada().cMnemEgcOpe().set(hv13001Movdep().movdep().cMnemEgcOpex());
        /**
         * *--- DOCUMENTO PRINCIPAL DO ITVT
         */
        bhel100a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisIsaEmsDoc());
        bhel100a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocId());
        bhel100a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocId());
        bhep5100TabNaoClientes() ;
        if (bhel100a().commarea().dadosSaida().semErros().isTrue()) {
            msgOut().msg().ade().cTipoCli().set(bhel100a().commarea().dadosSaida().cTipoNcliS());
            msgOut().msg().ade().nCliente().set(bhel100a().commarea().dadosSaida().nPrcpNcliS());
            msgOut().msg().ade().nsAbraCli().set(0);
            /**
             * --    SE NAO PARTICULAR
             */
            msgOut().msg().ade().zNascCli().set(bhel100a().commarea().dadosSaida().zNascNcliS());
            msgOut().msg().ade().cPaisNacnCli().set(bhel100a().commarea().dadosSaida().cPaisNacnNcliS());
            msgOut().msg().ade().nmCliente().set(bhel100a().commarea().dadosSaida().nmPrcpNcliS());
            /**
             * --    EMPRESA (TEM NICP)
             */
            if (bhel100a().commarea().dadosSaida().cTipoNcliS().isEqual(CON_EMPRESA)) {
                wsVariaveis().wsCPaisDocPcl().set(bhel100a().commarea().dadosSaida().cPaisEmsDocPS());
                wsVariaveis().wsCTipoDocPcl().set(bhel100a().commarea().dadosSaida().cTipoDocIdPS());
                msgOut().msg().ade().nIpc().set(bhel100a().commarea().dadosSaida().nDocIdPclvS());
                msgOut().msg().ade().nmEmpRnpc().set(bhel100a().commarea().dadosSaida().nmEmpRnpcS());
                msgOut().msg().ade().cAe().set(bhel100a().commarea().dadosSaida().cAeS());
                msgOut().msg().ade().dAe().set(bhel100a().commarea().dadosSaida().dAeS());
            } else if (!bhel100a().commarea().dadosSaida().cTipoNcliS().isEqual(CON_EMPRESA)) {
                wsVariaveis().wsCPaisDocPcl().set(bhel100a().commarea().dadosSaida().cPaisEmsDocPS());
                wsVariaveis().wsCTipoDocPcl().set(bhel100a().commarea().dadosSaida().cTipoDocIdPS());
                msgOut().msg().ade().nif().set(bhel100a().commarea().dadosSaida().nDocIdPclvS());
                msgOut().msg().ade().nmEmpRnpc().set(bhel100a().commarea().dadosSaida().nmEmpRnpcS());
                msgOut().msg().ade().cAe().set(bhel100a().commarea().dadosSaida().cAeS());
                msgOut().msg().ade().dAe().set(bhel100a().commarea().dadosSaida().dAeS());
            }
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
            envOut.db2Log().nmTabela().set(bhel100a().commarea().dadosSaida().nmTabela());
            if (bhel100a().commarea().dadosSaida().errosFuncao().isTrue()) {
                envOut.errosGraves().aAplErr().set(bhel100a().commarea().dadosSaida().aAplErr());
                envOut.errosGraves().cTipoErroBbn().set(bhel100a().commarea().dadosSaida().cTipoErroBbn());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-09");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-10");
            }
            log(TraceLevel.Error, "   ERRO AO OBTER NAO CLIENTE DA ROTINA MHEJ100A");
            log(TraceLevel.Error, "   BHEL100A-C-TIPO-ERRO-BBN  : ", bhel100a().commarea().dadosSaida().cTipoErroBbn());
            log(TraceLevel.Error, "   BHEL100A-A-APL-ERR        : ", bhel100a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "   BHEL100A-C-RTNO-EVEN-SWAL : ", bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "   BHEL100A-C-SQLCODE        : ", bhel100a().commarea().dadosSaida().cSqlcode());
            log(TraceLevel.Error, "   BHEL100A-NM-TABELA        : ", bhel100a().commarea().dadosSaida().nmTabela());
        }
    }
    
    /**
     * 
     * 2700-OBTEM-CLI-CGD-RPRT
     * 
     */
    protected void m2700ObtemCliCgdRprt() {
        log(TraceLevel.Debug, "2700-OBTEM-CLI-CGD-RPRT");
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(hv13001Movdep().movdep().cMnemEgcOpex());
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisEmsDocRpt());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocIdRprt());
        bhjl027a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocIdRprt());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISOA-OE-OPX: ", bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BHJL027A-C-MNEM-EGC-OPEX   : ", bhjl027a().commarea().dadosEntrada().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISA-EMS-DOC: ", bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BHJL027A-C-TIPO-DOC-ID     : ", bhjl027a().commarea().dadosEntrada().cTipoDocId());
        log(TraceLevel.Debug, "   BHJL027A-N-DOC-ID          : ", bhjl027a().commarea().dadosEntrada().nDocId());
        bhjp5027AcedeMhjj027a() ;
        if (bhjl027a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().nClienteRprt().set(bhjl027a().commarea().dadosSaida().nCliente());
            msgOut().msg().ade().nsAbraCliRprt().set(bhjl027a().commarea().dadosSaida().nsAbraCli());
        } else if (bhjl027a().commarea().erros().erroFuncao().isTrue() && bhjl027a().commarea().erros().docRepetido().isTrue()) {
            msgOut().msg().ade().nClienteRprt().set(0);
            msgOut().msg().ade().nsAbraCliRprt().set(0);
            msgOut().msg().ade().iRprtCliCgd().set(CON_VARIOS_CLI_CGD);
        } else {
            envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
            envOut.errosGraves().cTipoErroBbn().set(bhjl027a().commarea().erros().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
            if (bhjl027a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-11");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-12");
            }
        }
    }
    
    /**
     * 
     * 2800-OBTEM-DADOS-CLI-RPRT
     * 
     */
    protected void m2800ObtemDadosCliRprt() {
        log(TraceLevel.Debug, "2800-OBTEM-DADOS-CLI-RPRT");
        bhjl006a().commarea().initialize() ;
        bhjl006a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(msgOut().msg().ade().cPaisIsoaOeOpx());
        bhjl006a().commarea().dadosEntrada().cMnemEgcOpex().set(msgOut().msg().ade().cMnemEgcOpex());
        bhjl006a().commarea().dadosEntrada().nCliente().set(msgOut().msg().ade().nClienteRprt());
        bhjl006a().commarea().dadosSaida().nsAbraCli().set(msgOut().msg().ade().nsAbraCliRprt());
        log(TraceLevel.Debug, "   BHJL006A-N-CLIENTE   : ", bhjl006a().commarea().dadosEntrada().nCliente());
        log(TraceLevel.Debug, "   BHJL006A-NS-ABRA-CLI : ", bhjl006a().commarea().dadosSaida().nsAbraCli());
        bhjp6006AcedeMhjs006a() ;
        if (!bhjl006a().commarea().erros().semErros().isTrue()) {
            if (bhjl006a().commarea().erros().abendDb2().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl006a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl006a().commarea().erros().nmTabela());
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnS().set(CON_1);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl006a().commarea().erros().cRtnoEvenSwal());
                envOut.errosGraves().aAplErr().set(bhjl006a().commarea().erros().aAplErr());
            }
        } else {
            msgOut().msg().ade().cTipoCliRprt().set(bhjl006a().commarea().dadosSaida().cTipoCli());
            msgOut().msg().ade().nmClienteRprt().set(bhjl006a().commarea().dadosSaida().nmCliente());
        }
    }
    
    /**
     * 
     * 2900-OBTEM-N-CLI-CGD-RPRT
     * 
     */
    protected void m2900ObtemNCliCgdRprt() {
        log(TraceLevel.Debug, "2900-OBTEM-N-CLI-CGD-RPRT");
        bhel100a().commarea().initialize() ;
        bhel100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bhel100a().commarea().dadosEntrada().iOperacao().set(CON_3N);
        bhel100a().commarea().dadosEntrada().cPaisIsoaOpe().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhel100a().commarea().dadosEntrada().cMnemEgcOpe().set(hv13001Movdep().movdep().cMnemEgcOpex());
        bhel100a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisEmsDocRpt());
        bhel100a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocIdRprt());
        bhel100a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocIdRprt());
        bhep5100TabNaoClientes() ;
        if (bhel100a().commarea().dadosSaida().semErros().isTrue()) {
            msgOut().msg().ade().cTipoCliRprt().set(bhel100a().commarea().dadosSaida().cTipoNcliS());
            msgOut().msg().ade().nClienteRprt().set(bhel100a().commarea().dadosSaida().nPrcpNcliS());
            msgOut().msg().ade().nsAbraCliRprt().set(0);
            /**
             * --    SE  PARTICULAR
             */
            if (!bhel100a().commarea().dadosSaida().cTipoNcliS().isEqual(CON_EMPRESA)) {
                msgOut().msg().ade().nmClienteRprt().set(bhel100a().commarea().dadosSaida().nmPrcpNcliS());
            }
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
            envOut.db2Log().nmTabela().set(bhel100a().commarea().dadosSaida().nmTabela());
            if (bhel100a().commarea().dadosSaida().errosFuncao().isTrue()) {
                envOut.errosGraves().aAplErr().set(bhel100a().commarea().dadosSaida().aAplErr());
                envOut.errosGraves().cTipoErroBbn().set(bhel100a().commarea().dadosSaida().cTipoErroBbn());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-13");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-14");
            }
            log(TraceLevel.Error, "   ERRO AO OBTER NAO CLIENTE DA ROTINA MHEJ100A");
            log(TraceLevel.Error, "   BHEL100A-C-TIPO-ERRO-BBN  : ", bhel100a().commarea().dadosSaida().cTipoErroBbn());
            log(TraceLevel.Error, "   BHEL100A-A-APL-ERR        : ", bhel100a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "   BHEL100A-C-RTNO-EVEN-SWAL : ", bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "   BHEL100A-C-SQLCODE        : ", bhel100a().commarea().dadosSaida().cSqlcode());
            log(TraceLevel.Error, "   BHEL100A-NM-TABELA        : ", bhel100a().commarea().dadosSaida().nmTabela());
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
        if (!envOut.errosGraves().semErros().isTrue()) {
            log(TraceLevel.Debug, "   BGHM1151-ASE ", msgOut().msg().ase());
            m3100MensagemOutput() ;
        }
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
        log(TraceLevel.Debug, "  BGHM1151-C-PAIS-ISO-ALFN       : ", msgOut().msg().ade().cPaisIsoAlfn());
        log(TraceLevel.Debug, "  BGHM1151-C-MNEM-EMP-GCX        : ", msgOut().msg().ade().cMnemEmpGcx());
        log(TraceLevel.Debug, "  BGHM1151-C-REF-MSG-SWIF        : ", msgOut().msg().ade().cRefMsgSwif());
        log(TraceLevel.Debug, "  BGHM1151-C-EST-MSG-SWIF        : ", msgOut().msg().ade().cEstMsgSwif());
        log(TraceLevel.Debug, "  BGHM1151-C-PAIS-EMS-DOC-APT    : ", msgOut().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "  BGHM1151-C-TIPO-DOC-ID-APTD    : ", msgOut().msg().ade().cTipoDocIdAptd());
        log(TraceLevel.Debug, "  BGHM1151-N-DOC-ID-APTD         : ", msgOut().msg().ade().nDocIdAptd());
        log(TraceLevel.Debug, "  BGHM1151-Z-VLDE-DOC-ID-APTD    : ", msgOut().msg().ade().zVldeDocIdAptd());
        log(TraceLevel.Debug, "  BGHM1151-C-ENT-EMI-DID-APTD    : ", msgOut().msg().ade().cEntEmiDidAptd());
        log(TraceLevel.Debug, "  BGHM1151-C-PAIS-ISA-EMS-DOC    : ", msgOut().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "  BGHM1151-C-TIPO-DOC-ID         : ", msgOut().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "  BGHM1151-N-DOC-ID              : ", msgOut().msg().ade().nDocId());
        log(TraceLevel.Debug, "  BGHM1151-Z-VLDE-DOC-ID         : ", msgOut().msg().ade().zVldeDocId());
        log(TraceLevel.Debug, "  BGHM1151-C-ENT-EMIX-DOC-ID     : ", msgOut().msg().ade().cEntEmixDocId());
        log(TraceLevel.Debug, "  BGHM1151-C-PAIS-ISOA-OE-OPX    : ", msgOut().msg().ade().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "  BGHM1151-C-MNEM-EGC-OPEX       : ", msgOut().msg().ade().cMnemEgcOpex());
        log(TraceLevel.Debug, "  BGHM1151-C-OE-EGC-OPEX         : ", msgOut().msg().ade().cOeEgcOpex());
        log(TraceLevel.Debug, "  BGHM1151-C-TIPO-OPE-CONT       : ", msgOut().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "  BGHM1151-C-TIPO-CANL-ACES      : ", msgOut().msg().ade().cTipoCanlAces());
        log(TraceLevel.Debug, "  BGHM1151-I-TRNZ-EFCD-ONLN      : ", msgOut().msg().ade().iTrnzEfcdOnln());
        log(TraceLevel.Debug, "  BGHM1151-I-ESTORNO             : ", msgOut().msg().ade().iEstorno());
        log(TraceLevel.Debug, "  BGHM1151-C-TIPO-ITVT-DEP       : ", msgOut().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "  BGHM1151-M-MOV-EURO            : ", msgOut().msg().ade().mMovEuro());
        log(TraceLevel.Debug, "  BGHM1151-I-PED-JSTZ-ORM-FND    : ", msgOut().msg().ade().iPedJstzOrmFnd());
        log(TraceLevel.Debug, "  BGHM1151-I-RCS-JSTZ-ORM-FND    : ", msgOut().msg().ade().iRcsJstzOrmFnd());
        log(TraceLevel.Debug, "  BGHM1151-C-MTVO-PED-JSTZ       : ", msgOut().msg().ade().cMtvoPedJstz());
        log(TraceLevel.Debug, "  BGHM1151-N-CHEQUE              : ", msgOut().msg().ade().nCheque());
        log(TraceLevel.Debug, "  BGHM1151-C-TIPO-CLI            : ", msgOut().msg().ade().cTipoCli());
        log(TraceLevel.Debug, "  BGHM1151-I-CLI-CGD             : ", msgOut().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "  BGHM1151-N-CLIENTE             : ", msgOut().msg().ade().nCliente());
        log(TraceLevel.Debug, "  BGHM1151-NS-ABRA-CLI           : ", msgOut().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "  BGHM1151-NM-CLIENTE            : ", msgOut().msg().ade().nmCliente());
        log(TraceLevel.Debug, "  BGHM1151-Z-NASC-CLI            : ", msgOut().msg().ade().zNascCli());
        log(TraceLevel.Debug, "  BGHM1151-C-PAIS-NACN-CLI       : ", msgOut().msg().ade().cPaisNacnCli());
        log(TraceLevel.Debug, "  BGHM1151-NIF                   : ", msgOut().msg().ade().nif());
        log(TraceLevel.Debug, "  BGHM1151-N-IPC                 : ", msgOut().msg().ade().nIpc());
        log(TraceLevel.Debug, "  BGHM1151-NM-EMP-RNPC           : ", msgOut().msg().ade().nmEmpRnpc());
        log(TraceLevel.Debug, "  BGHM1151-D-AE                  : ", msgOut().msg().ade().dAe());
        log(TraceLevel.Debug, "  BGHM1151-C-AE                  : ", msgOut().msg().ade().cAe());
        log(TraceLevel.Debug, "  BGHM1151-C-TIPO-CLI-RPRT       : ", msgOut().msg().ade().cTipoCliRprt());
        log(TraceLevel.Debug, "  BGHM1151-I-RPRT-CLI-CGD        : ", msgOut().msg().ade().iRprtCliCgd());
        log(TraceLevel.Debug, "  BGHM1151-N-CLIENTE-RPRT        : ", msgOut().msg().ade().nClienteRprt());
        log(TraceLevel.Debug, "  BGHM1151-NS-ABRA-CLI-RPRT      : ", msgOut().msg().ade().nsAbraCliRprt());
        log(TraceLevel.Debug, "  BGHM1151-NM-CLIENTE-RPRT       : ", msgOut().msg().ade().nmClienteRprt());
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "******** FIM * GHIJ * MVPHIJ * FIM ***********");
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
     * *---DOCUMENTOS FISCAIS VALIDOS - SINGULAR
     * 
     * @version 2.0
     * 
     */
    public interface ConDocNif extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNifCPais() ;
        
        @Data(size=3, value="501")
        IString conNifTDoc() ;
        
    }
    public interface ConDocNfePs extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNfeCPais() ;
        
        @Data(size=3, value="806")
        IString conNfeTDoc() ;
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsNDocId
         */
        @Data
        WsNDocId wsNDocId() ;
        
        @Data(size=3, value=" ")
        IString wsCPaisDocPcl() ;
        
        @Data(size=3, value=" ")
        IString wsCTipoDocPcl() ;
        
        @Data(size=135, value=" ")
        IString wsNmClienteTemp() ;
        
        @Data(format="999-", value="0")
        IFormattedString wsSqlcodeErro() ;
        
        
        public interface WsNDocId extends IDataStruct {
            
            @Data(size=9, value="0")
            ILong wsNIpc() ;
            
            @Data(size=11, value=" ")
            IString wsResto() ;
            
        }
    }
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitches extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString swBuscaDoc() ;
        @Data
        @Condition("S")
        ICondition swBuscaDocSim() ;
        @Data
        @Condition("N")
        ICondition swBuscaDocNao() ;
        
        
        @Data(size=1, value=" ")
        IString swDoc() ;
        @Data
        @Condition("N")
        ICondition swDocNok() ;
        @Data
        @Condition("O")
        ICondition swDocOk() ;
        
        
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
        
        
        /**
         * *----- AVALIA ESTADO DA ORDEM - C-EST-MSG-SWIF
         */
        @Data(size=2, value="0")
        IInt swCEstMsgSwif() ;
        @Data
        @Condition("02")
        ICondition swEnviada() ;
        @Data
        @Condition("16")
        ICondition swAnulada() ;
        @Data
        @Condition("18")
        ICondition swDevolvida() ;
        @Data
        @Condition("28")
        ICondition swLiquidada() ;
        @Data
        @Condition("31")
        ICondition swEstornada() ;
        @Data
        @Condition("38")
        ICondition swAgrdDevolFundos() ;
        @Data
        @Condition("53")
        ICondition swFundosDesviados() ;
        @Data
        @Condition({ "02", "16", "16", "18", "28", "38", "53" })
        ICondition swEstFinalValidos() ;
        
        
        /**
         * *-- TIPO DE OPERACAO
         * TABELA GERAL LOGICA 'G65' - TIPO DE OPERACAO NA CONTA
         */
        @Data(size=1, value=" ")
        IString swCTipoOpeCont() ;
        @Data
        @Condition({ "C", "J", "K" })
        ICondition swCambio() ;
        @Data
        @Condition("J")
        ICondition swSgocvnHe34() ;
        @Data
        @Condition("K")
        ICondition swSgocvnHe35() ;
        @Data
        @Condition("D")
        ICondition swTrocoDestroco() ;
        @Data
        @Condition({ "T", "S", "R" })
        ICondition swTransferencias() ;
        @Data
        @Condition("S")
        ICondition swOrdensEmitidas() ;
        @Data
        @Condition("R")
        ICondition swOrdensRecebidas() ;
        @Data
        @Condition({ "O", "X", "H", "Y", "V" })
        ICondition swOcasionais() ;
        @Data
        @Condition("X")
        ICondition swSgix02() ;
        @Data
        @Condition("H")
        ICondition swSgovtcHe37() ;
        @Data
        @Condition("Y")
        ICondition swPi3501EmissChq() ;
        @Data
        @Condition("V")
        ICondition swChqhb0ChqBancario() ;
        
        
    }
    
}
