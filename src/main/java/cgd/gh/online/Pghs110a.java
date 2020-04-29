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
import static morphis.framework.datatypes.serialization.Algorithm.* ;
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
import cgd.gh.structures.messages.Bghm1100 ;
import cgd.gh.structures.messages.Bghm1101 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.structures.link.Bhol804a ;
import cgd.hj.structures.link.Bhjl001a ;
import cgd.gh.structures.work.Bghw0013 ;
import cgd.ho.routines.Mhos804a ;
import cgd.ho.routines.Mhoj354a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghs001a ;
import cgd.gh.routines.Mghs010a ;
import cgd.hj.routines.Mhjj060a ;
import cgd.hj.routines.Mhjj200a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghj801a ;
import cgd.gh.routines.Mghs802a ;


/**
 * 
 * DECLARACAO DE CURSORES
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS110A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1274 - NOVA TRANSAÇÃO DE CONSULTA DE MOVIMENTOS
 * COM DATA VALOR
 * FUNCAO     : LISTA DETALHE DOS MOVIMENTOS POR DATA VALOR DE UMA*
 * SUBCONTA
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES: CRIACAO.
 * LOG DE ALTERACOES
 * PROCESSO GIP !   DATA   !    UTILIZADOR    !    OBSERVACOES
 * GH1274       2013-11-06  DACT712-ACCENTURE      CRIACAO.
 * GH1877       2015-11-27  DACT575-ACCENTURE      ALTERACAO
 * DESCRICAO : RESOLUCAO HD-1291910 (CONTORNAR ERRO GH091 -
 * : CRITERIO DATA MINIMA INVALIDO)
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs110a extends CgdGhBaseOnline<Pghs110a.EnvelopeIn, Pghs110a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1100
     */
    public abstract Bghm1100 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1101
     */
    public abstract Bghm1101 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1100.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1101.Msg msgOut() ;
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
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhos804a
     */
    @Data
    protected abstract Mhos804a hrMhos804a() ;
    
    /**
     * @return instancia da classe Mhoj354a
     */
    @Data
    protected abstract Mhoj354a hrMhoj354a() ;
    
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
    /**
     * @return instancia da classe Mghs001a
     */
    @Data
    protected abstract Mghs001a hrMghs001a() ;
    
    /**
     * @return instancia da classe Mghs010a
     */
    @Data
    protected abstract Mghs010a hrMghs010a() ;
    
    /**
     * @return instancia da classe Mhjj060a
     */
    @Data
    protected abstract Mhjj060a hrMhjj060a() ;
    
    /**
     * @return instancia da classe Mhjj200a
     */
    @Data
    protected abstract Mhjj200a hrMhjj200a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mghj801a
     */
    @Data
    protected abstract Mghj801a hrMghj801a() ;
    
    /**
     * @return instancia da classe Mghs802a
     */
    @Data
    protected abstract Mghs802a hrMghs802a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhol804a
     */
    @Data
    protected abstract Bhol804a bhol804a() ;
    
    /**
     * @return instancia da classe Bhjl001a
     */
    @Data
    protected abstract Bhjl001a bhjl001a() ;
    
    /**
     * @return instancia da classe Bghw0013
     */
    @Data
    protected abstract Bghw0013 bghw0013() ;
    
    protected static final String CON_MHOJ354A = "MHOJ354A" ;
    
    /**
     * ----- DB2
     */
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_GH = "GH" ;
    
    protected static final String CON_NAO = "N" ;
    
    protected static final String CON_SIM = "S" ;
    
    /**
     * ----- OUTROS CRITERIOS
     */
    protected static final String CON_DEBITO = "D" ;
    
    protected static final String CON_CREDITO = "C" ;
    
    /**
     * ----- INDICADOR DE CONSULTA
     */
    protected static final String CON_ASCENDENTE = "A" ;
    
    protected static final String CON_DESCENDENTE = "D" ;
    
    /**
     * ----- DATAS LIMITES
     */
    protected static final String CON_Z_CRIACAO = "0001-01-01" ;
    
    protected static final String CON_MAX_DATA_DB2 = "9999-12-31" ;
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    @Data(size=2)
    protected IString wsCTipoTrttCont ;
    @Data
    @Condition("01")
    protected ICondition wsTrttDepOrdem ;
    @Data
    @Condition("02")
    protected ICondition wsTrttPoupanca ;
    @Data
    @Condition("03")
    protected ICondition wsTrttDepPrazo ;
    @Data
    @Condition("09")
    protected ICondition wsTrttDepEstru ;
    @Data
    @Condition("12")
    protected ICondition wsTrttDepObrig ;
    @Data
    @Condition("19")
    protected ICondition wsTrttCtaMarg ;
    @Data
    @Condition("26")
    protected ICondition wsTrttCashCarry ;
    @Data
    @Condition("27")
    protected ICondition wsTrttCtaVostr ;
    @Data
    @Condition("28")
    protected ICondition wsTrttCtaNostr ;
    @Data
    @Condition("32")
    protected ICondition wsTrttCtaInter ;
    
    
    @Data(size=10, decimal=7, signed=true, value="0")
    protected IDecimal wsTJuro ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    @Data(size=2, value="11")
    protected IInt wsMovFalta ;
    
    /**
     * @return instancia da classe local WsTs
     */
    @Data
    protected abstract WsTs wsTs() ;
    
    /**
     * @return instancia da classe local WsTsMax
     */
    @Data
    protected abstract WsTsMax wsTsMax() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * ACESSO A ROTINA MHOS804A
     * 
     */
    protected void bhop0804AcedeMhos804a() {
        hrMhos804a().run() ;
    }
    
    /**
     * 
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
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
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100Inicializacoes() ;
        while (!msgOut().paginaCheia().isTrue()) {
            m1200IniciaOcurrs() ;
        }
        msgOut().indice().set(0);
        m1300ValidaInput() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual("BALC")) {
                swSwitches().swBalcao().setTrue() ;
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (msgIn().msg().ade().critDatasMovDif().isEqual("S")) {
                swSwitches().swDatasDiferentesS().setTrue() ;
            } else {
                swSwitches().swDatasDiferentesN().setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        log(TraceLevel.Debug, "1100-INICIALIZACOES");
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().msg().ade().initialize() ;
        bhol804a().commarea().initialize() ;
        hv00201Movhst().movhst().initialize() ;
        wsVariaveis().initialize() ;
        msgOut().indice().set(0);
    }
    
    /**
     * 
     * 1200-INICIA-OCURRS
     * 
     */
    protected void m1200IniciaOcurrs() {
        log(TraceLevel.Debug, "1200-INICIA-OCURRS");
        msgOut().indice().add(1);
        msgOut().msg().ade().grMov().get(msgOut().indice()).initialize() ;
    }
    
    /**
     * 
     * 1300-VALIDA-INPUT
     * 
     */
    protected void m1300ValidaInput() {
        log(TraceLevel.Debug, "1300-VALIDA-INPUT");
        log(TraceLevel.Debug, "   BGHM1100-C-PAIS-ISOA-CONT : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BGHM1100-C-BANC-CONT      : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "   BGHM1100-C-OE-EGC-CONT    : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "   BGHM1100-NS-RDCL-CONT     : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "   BGHM1100-C-MOED-ISO-SCTA  : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "   BGHM1100-I-CONSULTA       : ", msgIn().msg().ade().iConsulta());
        log(TraceLevel.Debug, "   BGHM1100-TS-MOVIMENTO     : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "   BGHM1100-TS-MOV-MAX       : ", msgIn().msg().ade().tsMovMax());
        log(TraceLevel.Debug, "   BGHM1100-Z-VAL-MOV-MIN    : ", msgIn().msg().ade().zValMovMin());
        log(TraceLevel.Debug, "   BGHM1100-Z-VAL-MOV-MAX    : ", msgIn().msg().ade().zValMovMax());
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().iConsulta().isEmpty()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            swSwitches().progDadosInvalidos().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().aAplErr().set(CON_GH);
        }
        if (msgIn().msg().ade().ascendente().isTrue() && msgIn().msg().ade().descendente().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            swSwitches().progDadosInvalidos().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().aAplErr().set(CON_GH);
        }
        if ((msgIn().msg().ade().zValMovMin().isEqual(bhok0002().BHOK0002_Z_CRIACAO) || 
            msgIn().msg().ade().zValMovMax().isEqual(bhok0002().BHOK0002_Z_CRIACAO)) && 
            (msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().tsMovMax().isEmpty())) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            swSwitches().progDadosInvalidos().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().aAplErr().set(CON_GH);
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        if (envOut.errosGraves().semErros().isTrue()) {
            if (msgIn().msg().ade().comNmCli().isTrue()) {
                m2050ObtemCliente() ;
            }
        }
        log(TraceLevel.Debug, "BGHM1100-TS-MOVIMENTO : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "BGHM1100-TS-MOV-MAX   : ", msgIn().msg().ade().tsMovMax());
        log(TraceLevel.Debug, "BGHM1100-Z-VAL-MOV-MIN: ", msgIn().msg().ade().zValMovMin());
        log(TraceLevel.Debug, "BGHM1100-Z-VAL-MOV-MAX: ", msgIn().msg().ade().zValMovMax());
        /**
         * CONSULTA POR DATA DO MOVIMENTO
         */
        if (!msgIn().msg().ade().tsMovimento().isEmpty() && 
            !msgIn().msg().ade().tsMovMax().isEmpty()) {
            m2100MovPorTsMovimento() ;
        } else if (!msgIn().msg().ade().zValMovMin().isEqual(bhok0002().BHOK0002_Z_CRIACAO) && 
            !msgIn().msg().ade().zValMovMax().isEqual(bhok0002().BHOK0002_Z_CRIACAO)) {
            m2600MovPorZValMov() ;
        }
        /**
         * *....TRATA FIM CONSULTA                                           
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!msgOut().paginaCheia().isTrue()) {
                msgOut().indiceInverso().subtract(msgOut().indice());
                msgOut().diminuiLength().set(multiply(msgOut().indiceInverso(), msgOut().lengthOccur()));
                msgOut().qCterCmptAlig().subtract(msgOut().diminuiLength());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().fimConsulta());
                msgOut().msg().ade().iMsgCtnd().set(CON_NAO);
            } else {
                /**
                 * PAGINACAO
                 */
                msgOut().msg().ade().iMsgCtnd().set(CON_SIM);
                log(TraceLevel.Debug, "SW-ULT-MOV-GH     : ", swSwitches().swUltMovGh());
                log(TraceLevel.Debug, "WS-TS-MOVIMENTO-GH: ", wsVariaveis().wsTsMovimentoGh());
                log(TraceLevel.Debug, "W-DATA-TS         : ", wsTs().wDataTs());
                log(TraceLevel.Debug, "WS-TS             : ", wsTs());
                if (swSwitches().swUltMovGhS().isTrue()) {
                    msgOut().msg().ade().tsMovimentoK().set(wsVariaveis().wsTsMovimentoGh());
                } else {
                    wsTs().wDataTs().set(msgOut().msg().ade().grMov().get(11).zMovimento());
                    msgOut().msg().ade().tsMovimentoK().set(wsTs());
                }
                msgOut().msg().ade().nsMovimentoK().set(msgOut().msg().ade().grMov().get(11).nsMovimento());
                msgOut().msg().ade().zValMovK().set(wsVariaveis().wsValMovMin());
            }
        }
        log(TraceLevel.Debug, "...2999-PROCESSO-PROGRAMA-EXIT");
        log(TraceLevel.Debug, "   BHTL001A-C-TIPO-ERRO-BBN : ", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Debug, "   BGHM1101-I-MSG-CTND      : ", msgOut().msg().ade().iMsgCtnd());
        log(TraceLevel.Debug, "   BGHM1101-TS-MOVIMENTO-K  : ", msgOut().msg().ade().tsMovimentoK());
        log(TraceLevel.Debug, "   BGHM1101-NS-MOVIMENTO-K  : ", msgOut().msg().ade().nsMovimentoK());
        log(TraceLevel.Debug, "   BGHM1101-Z-VAL-MOV-K     : ", msgOut().msg().ade().zValMovK());
    }
    
    /**
     * 
     * 2100-MOV-POR-TS-MOVIMENTO
     * 
     */
    protected void m2100MovPorTsMovimento() {
        log(TraceLevel.Debug, "2100-MOV-POR-TS-MOVIMENTO");
        /**
         * CONSULTA TGH003:
         * ESTADO H: MOVIMENTOS DE D-1 ESTAO NOS HOS
         * ESTADO A: MOVIMENTOS DE D-1 ESTAO NA TGH022 -- DESCONTINUADA
         * ESTADO I: MOVIMENTOS DE D-1 ESTAO JA EM HISTORICO
         */
        m2200ConsultaGatCnsMov() ;
        /**
         * CONSULTA DATAS DA TGH010 COM RECURSO TGH00002
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            m2300ValidaPedido() ;
        }
        log(TraceLevel.Debug, "ORDEM DA CONSULTA          : ", msgIn().msg().ade().iConsulta());
        log(TraceLevel.Debug, "BGHM1100-TS-MOVIMENTO(1:10): ", msgIn().msg().ade().tsMovimento().get(1, 10));
        log(TraceLevel.Debug, "MGH003A-Z-HOJE             : ", hrMghs003a().bghl003a().zHoje());
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * ORDEM ASCENDENTE
             */
            if (msgIn().msg().ade().ascendente().isTrue()) {
                if (msgIn().msg().ade().tsMovimento().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                    m2400ObtemMovhstTgh002() ;
                    if (envOut.errosGraves().semErros().isTrue()) {
                        if (msgOut().paginaCheia().isTrue()) {
                            swSwitches().swUltMovGhS().setTrue() ;
                        }
                    }
                }
                log(TraceLevel.Debug, "BGHM1101-INDICE: ", msgOut().indice());
                log(TraceLevel.Debug, "VGH00201-TS-MOVIMENTO: ", hv00201Movhst().movhst().tsMovimento());
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (!msgOut().paginaCheia().isTrue()) {
                        if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("H")) {
                            bhol804a().commarea().dadosInput().criterioDia().iMovDia().set("N");
                            m2520ObtemMovDiaHo() ;
                            if (envOut.errosGraves().semErros().isTrue()) {
                                if (msgOut().paginaCheia().isTrue()) {
                                    swSwitches().swUltMovGhN().setTrue() ;
                                }
                            }
                        }
                    }
                }
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (!msgOut().paginaCheia().isTrue()) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
                            bhol804a().commarea().dadosInput().criterioDia().iMovDia().set("S");
                            m2520ObtemMovDiaHo() ;
                            if (envOut.errosGraves().semErros().isTrue()) {
                                if (msgOut().paginaCheia().isTrue()) {
                                    swSwitches().swUltMovGhN().setTrue() ;
                                }
                            }
                        }
                    }
                }
            } else {
                /**
                 * ORDEM DESCENDENTE
                 */
                if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
                    bhol804a().commarea().dadosInput().criterioDia().iMovDia().set("S");
                    m2520ObtemMovDiaHo() ;
                    if (envOut.errosGraves().semErros().isTrue()) {
                        if (msgOut().paginaCheia().isTrue()) {
                            swSwitches().swUltMovGhN().setTrue() ;
                        }
                    }
                }
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (!msgOut().paginaCheia().isTrue()) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                            if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("H")) {
                                bhol804a().commarea().dadosInput().criterioDia().iMovDia().set("N");
                                m2520ObtemMovDiaHo() ;
                                if (envOut.errosGraves().semErros().isTrue()) {
                                    if (msgOut().paginaCheia().isTrue()) {
                                        swSwitches().swUltMovGhN().setTrue() ;
                                    }
                                }
                            }
                        }
                    }
                }
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (!msgOut().paginaCheia().isTrue()) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                            m2400ObtemMovhstTgh002() ;
                        }
                        if (envOut.errosGraves().semErros().isTrue()) {
                            if (msgOut().paginaCheia().isTrue()) {
                                swSwitches().swUltMovGhS().setTrue() ;
                            }
                        }
                    }
                }
                log(TraceLevel.Debug, "BGHM1101-INDICE: ", msgOut().indice());
                log(TraceLevel.Debug, "VGH00201-TS-MOVIMENTO: ", hv00201Movhst().movhst().tsMovimento());
            }
        }
        log(TraceLevel.Debug, "...NO FIM 2100-MOV-POR-TS-MOVIMENTO");
        log(TraceLevel.Debug, "   BGHM1101-Z-MOVIMENTO(1) :", msgOut().msg().ade().grMov().get(1).zMovimento());
        log(TraceLevel.Debug, "   BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Debug, "   SW-ULT-MOV-GH           :", swSwitches().swUltMovGh());
        if (envOut.errosGraves().semErros().isTrue() && 
            msgOut().msg().ade().grMov().get(1).zMovimento().isEmpty()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            swSwitches().progNaoExisteMov().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().aAplErr().set(CON_GH);
        }
    }
    
    /**
     * 
     * 2600-MOV-POR-Z-VAL-MOV
     * 
     */
    protected void m2600MovPorZValMov() {
        log(TraceLevel.Debug, "2600-MOV-POR-Z-VAL-MOV");
        log(TraceLevel.Debug, "   BGHM1100-I-CONSULTA : ", msgIn().msg().ade().iConsulta());
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * ORDEM ASCENDENTE
             */
            if (msgIn().msg().ade().ascendente().isTrue()) {
                m2400ObtemMovhstTgh002() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (!msgOut().paginaCheia().isTrue()) {
                        bhol804a().commarea().dadosInput().criterioDia().iMovDia().set("S");
                        m2520ObtemMovDiaHo() ;
                    }
                }
            } else {
                /**
                 * ORDEM DESCENDENTE
                 */
                bhol804a().commarea().dadosInput().criterioDia().iMovDia().set("S");
                m2520ObtemMovDiaHo() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (!msgOut().paginaCheia().isTrue()) {
                        m2400ObtemMovhstTgh002() ;
                    }
                }
            }
        }
        log(TraceLevel.Debug, "...NO FIM 2600-MOV-POR-Z-VAL-MOV");
        log(TraceLevel.Debug, "   BGHM1101-Z-MOVIMENTO(1) :", msgOut().msg().ade().grMov().get(1).zMovimento());
        log(TraceLevel.Debug, "   BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
        if (envOut.errosGraves().semErros().isTrue() && 
            msgOut().msg().ade().grMov().get(1).zMovimento().isEmpty()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            swSwitches().progNaoExisteMov().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().aAplErr().set(CON_GH);
        }
    }
    
    /**
     * 
     * 2525-CALCULA-SLDO-DPNL-HO
     * 
     */
    protected void m2525CalculaSldoDpnlHo() {
        log(TraceLevel.Debug, "2525-CALCULA-SLDO-DPNL-HO");
        hrMhoj354a().bhol354a().commarea().initialize() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set(bhol804a().commarea().dadosInput().criterioDia().iMovDia());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj354a().bhol354a().commarea().dadosInput().nsMovimento().set(msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento());
        hrMhoj354a().run() ;
        log(TraceLevel.Debug, "BHOL354A-C-TIPO-ERRO-BBN : ", hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
        log(TraceLevel.Debug, "BHOL354A-A-APL-ERR       : ", hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
        log(TraceLevel.Debug, "BHOL354A-C-SQLCODE       : ", hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
        log(TraceLevel.Debug, "BHOL354A-NM-TABELA       : ", hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
        log(TraceLevel.Debug, "BHOL354A-C-RTNO-EVEN-SWAL: ", hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
        log(TraceLevel.Debug, "BGHM1101-M-SLDO-CBLO-APOS: ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos());
        log(TraceLevel.Debug, "BHOL354A-M-SLDO-RETD     : ", hrMhoj354a().bhol354a().commarea().areaOutput().mSldoRetd());
        log(TraceLevel.Debug, "BHOL354A-M-SLDO-VCOB     : ", hrMhoj354a().bhol354a().commarea().areaOutput().mSldoVcob());
        if (hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue() || hrMhoj354a().bhol354a().commarea().dadosErro().fimConsulta().isTrue()) {
            msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos().set(subtract(msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos(), add(hrMhoj354a().bhol354a().commarea().areaOutput().mSldoRetd(), hrMhoj354a().bhol354a().commarea().areaOutput().mSldoVcob())));
        } else {
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
            envOut.errosGraves().aAplErr().set(hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            swSwitches().progStatus().set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cRtnoEvenSwal().set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 2200-CONSULTA-GAT-CNS-MOV
     * 
     */
    protected void m2200ConsultaGatCnsMov() {
        log(TraceLevel.Debug, "2200-CONSULTA-GAT-CNS-MOV");
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set("TGH00022");
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set("I");
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            swSwitches().progStatus().set(hrMghs003a().bghl003a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs003a().bghl003a().cRetorno());
            envOut.errosGraves().cRtnoEvenSwal().set(hrMghs003a().bghl003a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00003");
            envOut.errosGraves().aAplErr().set(CON_GH);
            log(TraceLevel.Debug, "ERRO MGH003A");
            log(TraceLevel.Debug, "BHTL001A-C-RTNO-EVEN-SWAL: ", envOut.errosGraves().cRtnoEvenSwal());
            log(TraceLevel.Debug, "BHTL001A-C-TIPO-ERRO-BBN:  ", envOut.errosGraves().cTipoErroBbn());
            log(TraceLevel.Debug, "BHTL001A-C-SQLCODE:        ", envOut.db2Log().sqlca().cSqlcode());
            log(TraceLevel.Debug, "BHTL001A-NM-TABELA:        ", envOut.db2Log().nmTabela());
            log(TraceLevel.Debug, "BHTL001A-A-APL-ERR:        ", envOut.errosGraves().aAplErr());
        }
    }
    
    /**
     * 
     * 2300-VALIDA-PEDIDO
     * 
     */
    protected void m2300ValidaPedido() {
        log(TraceLevel.Debug, "2300-VALIDA-PEDIDO");
        hrMghs001a().bghl001a().initialize() ;
        hrMghs010a().bghl010a().initialize() ;
        hrMghs001a().bghl001a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs010a().bghl010a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs001a().bghl001a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs010a().bghl010a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs001a().bghl001a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs010a().bghl010a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs001a().bghl001a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs010a().bghl010a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs001a().bghl001a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs010a().bghl010a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs001a().bghl001a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs010a().bghl010a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs001a().bghl001a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs010a().bghl010a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs001a().bghl001a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs010a().bghl010a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs001a().run() ;
        if (hrMghs001a().bghl001a().ok().isTrue()) {
            m2250ValidaDatas() ;
        } else {
            swSwitches().progStatus().set(hrMghs001a().bghl001a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs001a().bghl001a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00001");
            envOut.errosGraves().aAplErr().set(CON_GH);
            log(TraceLevel.Debug, "ERRO MGH001A");
            log(TraceLevel.Debug, "BHTL001A-C-RTNO-EVEN-SWAL: ", envOut.errosGraves().cRtnoEvenSwal());
            log(TraceLevel.Debug, "BHTL001A-C-TIPO-ERRO-BBN:  ", envOut.errosGraves().cTipoErroBbn());
            log(TraceLevel.Debug, "BHTL001A-C-SQLCODE:        ", envOut.db2Log().sqlca().cSqlcode());
            log(TraceLevel.Debug, "BHTL001A-NM-TABELA:        ", envOut.db2Log().nmTabela());
            log(TraceLevel.Debug, "BHTL001A-A-APL-ERR:        ", envOut.errosGraves().aAplErr());
        }
    }
    
    /**
     * 
     * 2250-VALIDA-DATAS
     * 
     */
    protected void m2250ValidaDatas() {
        log(TraceLevel.Debug, "2250-VALIDA-DATAS");
        if (msgIn().msg().ade().ascendente().isTrue()) {
            wTimestamp().set(msgIn().msg().ade().tsMovimento());
        } else {
            wTimestamp().set(msgIn().msg().ade().tsMovMax());
        }
        if (wTimestamp().wDataTimestamp().isLess(hrMghs001a().bghl001a().detalhe().zAbraCont())) {
            if (!msgIn().msg().ade().cTipoCont().isEqual(34)) {
                wTimestamp().wDataTimestamp().set(hrMghs001a().bghl001a().detalhe().zAbraCont());
            }
            if (msgIn().msg().ade().ascendente().isTrue()) {
                msgIn().msg().ade().tsMovimento().set(wTimestamp());
            } else {
                msgIn().msg().ade().tsMovMax().set(wTimestamp());
            }
        }
        hrMghs010a().bghl010a().argumento().nmRecurso().set(CON_VGH00201);
        hrMghs010a().run() ;
        log(TraceLevel.Debug, "MGH010A-C-RETORNO        : ", hrMghs010a().bghl010a().cRetorno());
        log(TraceLevel.Debug, "W-ANO-AA                 : ", wTimestamp().wDataTimestamp().wAnoAa());
        log(TraceLevel.Debug, "MGH010A-ZA-INICIO        : ", hrMghs010a().bghl010a().detalhe().zaInicio());
        log(TraceLevel.Debug, "BHTL001A-C-TIPO-CANL-ACES: ", message.mensagem().headerR().transaccao().cTipoCanlAces());
        if (hrMghs010a().bghl010a().ok().isTrue()) {
            /**
             * END-IF
             */
            if (wTimestamp().wDataTimestamp().wAnoAa().isLess(hrMghs010a().bghl010a().detalhe().zaInicio())) {
                /**
                 * INICIO
                 * IF BHTL001A-C-TIPO-CANL-ACES = 'BALC'
                 * SET PROG-DATA-MIN-INV
                 * TO TRUE
                 * MOVE BHTK0002-ERROS-FUNCAO
                 * TO BHTL001A-C-TIPO-ERRO-BBN
                 * MOVE CON-GH     TO BHTL001A-A-APL-ERR
                 * SET  BGHM1101-C-PAIS-ISOA-CONT-1
                 * MOVE PROG-STATUS
                 * TO BGHM1101-C-PAIS-ISOA-CONT-M
                 * BHTL001A-C-RTNO-EVEN-SWAL
                 * MOVE MGH010A-C-SQLCODE
                 * TO BHTL001A-C-SQLCODE
                 * MOVE 'TGH00010'
                 * TO BHTL001A-NM-TABELA
                 * IF SW-DEBUG-SIM
                 * DISPLAY 'ERRO MGH010A'
                 * DISPLAY 'BHTL001A-C-RTNO-EVEN-SWAL: '
                 * DISPLAY 'BHTL001A-C-TIPO-ERRO-BBN:  '
                 * BHTL001A-C-TIPO-ERRO-BBN
                 * DISPLAY 'BHTL001A-C-SQLCODE:        '
                 * BHTL001A-C-SQLCODE
                 * DISPLAY 'BHTL001A-NM-TABELA:        '
                 * BHTL001A-NM-TABELA
                 * DISPLAY 'BHTL001A-A-APL-ERR:        '
                 * BHTL001A-A-APL-ERR
                 * END-IF
                 * ELSE
                 * FIM
                 */
                wTimestamp().wDataTimestamp().wAnoAa().set(hrMghs010a().bghl010a().detalhe().zaInicio());
                wTimestamp().wDataTimestamp().wMesMm().set(1);
                wTimestamp().wDataTimestamp().wDiaDd().set(1);
                wTimestamp().wTimerTimestamp().wHora().set(0);
                wTimestamp().wTimerTimestamp().wMinuto().set(0);
                wTimestamp().wTimerTimestamp().wSegundo().set(0);
                wTimestamp().wTimerTimestamp().wResto().set(0);
                if (msgIn().msg().ade().ascendente().isTrue()) {
                    msgIn().msg().ade().tsMovimento().set(wTimestamp());
                } else {
                    msgIn().msg().ade().tsMovMax().set(wTimestamp());
                }
            }
        } else if (!hrMghs001a().bghl001a().detalhe().zAbraCont().isEqual(hrMghs003a().bghl003a().zHoje()) && 
            !msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
            swSwitches().progStatus().set(hrMghs010a().bghl010a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs010a().bghl010a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00010");
            envOut.errosGraves().aAplErr().set(CON_GH);
            log(TraceLevel.Debug, "ERRO MGH010A");
            log(TraceLevel.Debug, "BHTL001A-C-RTNO-EVEN-SWAL: ", envOut.errosGraves().cRtnoEvenSwal());
            log(TraceLevel.Debug, "BHTL001A-C-TIPO-ERRO-BBN:  ", envOut.errosGraves().cTipoErroBbn());
            log(TraceLevel.Debug, "BHTL001A-C-SQLCODE:        ", envOut.db2Log().sqlca().cSqlcode());
            log(TraceLevel.Debug, "BHTL001A-NM-TABELA:        ", envOut.db2Log().nmTabela());
            log(TraceLevel.Debug, "BHTL001A-A-APL-ERR:        ", envOut.errosGraves().aAplErr());
        }
    }
    
    /**
     * 
     * 2050-OBTEM-CLIENTE
     * 
     */
    protected void m2050ObtemCliente() {
        log(TraceLevel.Debug, "2050-OBTEM-CLIENTE");
        hrMhjj060a().bhjl060a().commarea().initialize() ;
        bhjl001a().commarea().initialize() ;
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl001a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl001a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().zConsulta().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhjl001a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhjl001a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhjl001a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhjl001a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhjl001a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhjl001a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().iTipoItvt().set(101);
        bhjl001a().commarea().dadosEntrada().iTipoItvt().set(101);
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsTitc().set(1);
        bhjl001a().commarea().dadosEntrada().nsTitc().set(1);
        hrMhjj060a().run() ;
        if (hrMhjj060a().bhjl060a().commarea().erros().semErros().isTrue()) {
            if (hrMhjj060a().bhjl060a().commarea().erros().clienteConfidencial().isTrue()) {
                msgOut().msg().ade().cTitHono().set(" ");
                msgOut().msg().ade().nmCliAbvd().set(" ");
            } else {
                bhjl001a().commarea().dadosEntrada().nsAbraCli().set(hrMhjj060a().bhjl060a().commarea().dadosSaida().nsAbraCli());
                m2350ObtemNomeCli() ;
            }
        } else {
            envOut.errosGraves().cTipoErroBbn().set(hrMhjj060a().bhjl060a().commarea().erros().cTipoErroBbn());
            swSwitches().progStatus().set(hrMhjj060a().bhjl060a().commarea().erros().cRtnoEvenSwal());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.db2Log().sqlca().cSqlcode().set(hrMhjj060a().bhjl060a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhjj060a().bhjl060a().commarea().erros().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhjj060a().bhjl060a().commarea().erros().aAplErr());
        }
    }
    
    /**
     * 
     * 2350-OBTEM-NOME-CLI
     * 
     */
    protected void m2350ObtemNomeCli() {
        log(TraceLevel.Debug, "2350-OBTEM-NOME-CLI");
        hrMhjj200a().run() ;
        if (bhjl001a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().cTitHono().set(bhjl001a().commarea().dadosSaida().cTitHono());
            msgOut().msg().ade().nmCliAbvd().set(bhjl001a().commarea().dadosSaida().nmCliAbvd());
        } else if (bhjl001a().commarea().erros().nomeNExi().isTrue()) {
            msgOut().msg().ade().cTitHono().set(" ");
            msgOut().msg().ade().nmCliAbvd().set(" ");
        } else {
            envOut.errosGraves().cTipoErroBbn().set(bhjl001a().commarea().erros().cTipoErroBbn());
            swSwitches().progStatus().set(bhjl001a().commarea().erros().cRtnoEvenSwal());
            envOut.errosGraves().cRtnoEvenSwal().set(bhjl001a().commarea().erros().cRtnoEvenSwal());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.db2Log().sqlca().cSqlcode().set(bhjl001a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl001a().commarea().erros().nmTabela());
            envOut.errosGraves().aAplErr().set(bhjl001a().commarea().erros().aAplErr());
        }
    }
    
    /**
     * 
     * 2400-OBTEM-MOVHST-TGH002
     * 
     */
    protected void m2400ObtemMovhstTgh002() {
        log(TraceLevel.Debug, "2400-OBTEM-MOVHST-TGH002");
        hv00201Movhst().movhst().initialize() ;
        wsVariaveis().wsCrit1().initialize() ;
        wsVariaveis().wsCrit2().initialize() ;
        wsVariaveis().wsMMovMin().initialize() ;
        wsVariaveis().wsMMovMax().initialize() ;
        /**
         * *----CONTA
         */
        hv00201Movhst().movhst().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hv00201Movhst().movhst().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        if (msgIn().msg().ade().descendente().isTrue()) {
            if (msgIn().msg().ade().nsMovimento().isEqual(0)) {
                hv00201Movhst().movhst().nsMovimento().set(9);
            }
        }
        swSwitches().swNaoHaCritMontantes().setTrue() ;
        if (msgIn().msg().ade().iCritMontante().mMovMin().isEqual(0) && 
            msgIn().msg().ade().iCritMontante().mMovMax().isEqual(0)) {
            swSwitches().swNaoHaCritMontantes().setTrue() ;
        } else {
            swSwitches().swHaCritMontantes().setTrue() ;
            wsVariaveis().wsMMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
            wsVariaveis().wsMMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        }
        /**
         * ORDEM ASCENDENTE
         */
        if (msgIn().msg().ade().ascendente().isTrue()) {
            /**
             * CONSULTA POR DATA DO MOVIMENTO
             */
            if (!msgIn().msg().ade().tsMovimento().isEmpty() && 
                !msgIn().msg().ade().tsMovMax().isEmpty()) {
                wsVariaveis().wsTsInicio().set(msgIn().msg().ade().tsMovimento());
                wsVariaveis().wsTsFim().set(msgIn().msg().ade().tsMovMax());
                wsVariaveis().wsValMovMin().set(CON_Z_CRIACAO);
                wsVariaveis().wsValMovMax().set(CON_MAX_DATA_DB2);
            } else if (!msgIn().msg().ade().zValMovMin().isEqual(bhok0002().BHOK0002_Z_CRIACAO) && 
                !msgIn().msg().ade().zValMovMax().isEqual(bhok0002().BHOK0002_Z_CRIACAO)) {
                wsTs().wDataTs().set(CON_Z_CRIACAO);
                wsVariaveis().wsTsInicio().set(wsTs());
                wsTsMax().wDataTsMax().set(CON_MAX_DATA_DB2);
                wsVariaveis().wsTsFim().set(wsTsMax());
                wsVariaveis().wsValMovMin().set(msgIn().msg().ade().zValMovMin());
                wsVariaveis().wsValMovMax().set(msgIn().msg().ade().zValMovMax());
            }
        } else if (!msgIn().msg().ade().tsMovimento().isEmpty() && 
            !msgIn().msg().ade().tsMovMax().isEmpty()) {
            wsVariaveis().wsTsInicio().set(msgIn().msg().ade().tsMovimento());
            wsVariaveis().wsTsFim().set(msgIn().msg().ade().tsMovMax());
            wsVariaveis().wsValMovMax().set(CON_Z_CRIACAO);
            wsVariaveis().wsValMovMin().set(CON_MAX_DATA_DB2);
        } else if (!msgIn().msg().ade().zValMovMin().isEqual(bhok0002().BHOK0002_Z_CRIACAO) && 
            !msgIn().msg().ade().zValMovMax().isEqual(bhok0002().BHOK0002_Z_CRIACAO)) {
            wsTs().wDataTs().set(CON_Z_CRIACAO);
            wsVariaveis().wsTsFim().set(wsTs());
            wsTsMax().wDataTsMax().set(CON_MAX_DATA_DB2);
            wsVariaveis().wsTsInicio().set(wsTsMax());
            wsVariaveis().wsValMovMin().set(msgIn().msg().ade().zValMovMin());
            wsVariaveis().wsValMovMax().set(msgIn().msg().ade().zValMovMax());
        }
        /**
         * *----BGHM1100-I-CRIT-DBCR
         */
        if (msgIn().msg().ade().ambos().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        } else if (msgIn().msg().ade().debito().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_DEBITO);
        } else {
            wsVariaveis().wsCrit1().set(CON_CREDITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        }
        log(TraceLevel.Debug, "   VGH00201-C-PAIS-ISOA-CONT  : ", hv00201Movhst().movhst().cPaisIsoaCont());
        log(TraceLevel.Debug, "   VGH00201-C-BANC-CONT       : ", hv00201Movhst().movhst().cBancCont());
        log(TraceLevel.Debug, "   VGH00201-C-OE-EGC-CONT     : ", hv00201Movhst().movhst().cOeEgcCont());
        log(TraceLevel.Debug, "   VGH00201-NS-RDCL-CONT      : ", hv00201Movhst().movhst().nsRdclCont());
        log(TraceLevel.Debug, "   VGH00201-V-CHKD-CONT       : ", hv00201Movhst().movhst().vChkdCont());
        log(TraceLevel.Debug, "   VGH00201-C-TIPO-CONT       : ", hv00201Movhst().movhst().cTipoCont());
        log(TraceLevel.Debug, "   VGH00201-C-MOED-ISO-SCTA   : ", hv00201Movhst().movhst().cMoedIsoScta());
        log(TraceLevel.Debug, "   VGH00201-NS-DEPOSITO       : ", hv00201Movhst().movhst().nsDeposito());
        log(TraceLevel.Debug, "   VGH00201-NS-MOVIMENTO      : ", hv00201Movhst().movhst().nsMovimento());
        log(TraceLevel.Debug, "   SW-CRIT-MONTANTES          : ", swSwitches().swCritMontantes());
        log(TraceLevel.Debug, "      WS-M-MOV-MIN            : ", wsVariaveis().wsMMovMin());
        log(TraceLevel.Debug, "      WS-M-MOV-MAX            : ", wsVariaveis().wsMMovMax());
        log(TraceLevel.Debug, "   BGHM1100-TS-MOVIMENTO      : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "   BGHM1100-TS-MOV-MAX        : ", msgIn().msg().ade().tsMovMax());
        log(TraceLevel.Debug, "   BGHM1100-Z-VAL-MOV-MIN     : ", msgIn().msg().ade().zValMovMin());
        log(TraceLevel.Debug, "   BGHM1100-Z-VAL-MOV-MAX     : ", msgIn().msg().ade().zValMovMax());
        log(TraceLevel.Debug, "      WS-TS-INICIO            : ", wsVariaveis().wsTsInicio());
        log(TraceLevel.Debug, "      WS-TS-FIM               : ", wsVariaveis().wsTsFim());
        log(TraceLevel.Debug, "      WS-VAL-MOV-MIN          : ", wsVariaveis().wsValMovMin());
        log(TraceLevel.Debug, "      WS-VAL-MOV-MAX          : ", wsVariaveis().wsValMovMax());
        log(TraceLevel.Debug, "   BGHM1100-I-CRIT-DBCR       : ", msgIn().msg().ade().iCritDbcr());
        log(TraceLevel.Debug, "      WS-CRIT-1               : ", wsVariaveis().wsCrit1());
        log(TraceLevel.Debug, "      WS-CRIT-2               : ", wsVariaveis().wsCrit2());
        log(TraceLevel.Debug, "   BGHM1100-CRIT-DATAS-MOV-DIF: ", msgIn().msg().ade().critDatasMovDif());
        log(TraceLevel.Debug, "   BGHM1100-I-CONSULTA        : ", msgIn().msg().ade().iConsulta());
        m2410VerificaCursor() ;
    }
    
    /**
     * 
     * 2410-VERIFICA-CURSOR
     * 
     */
    protected void m2410VerificaCursor() {
        log(TraceLevel.Debug, "2410-VERIFICA-CURSOR");
        /**
         * CONSULTA COM DATA DO MOVIMENTO <> DATA VALOR
         */
        if (swSwitches().swDatasDiferentesS().isTrue()) {
            switch (msgIn().msg().ade().iConsulta().get()) {
                case CON_ASCENDENTE:
                    if (swSwitches().swNaoHaCritMontantes().isTrue()) {
                        m2420ListaAscData() ;
                    } else {
                        m2430ListaAscMontante() ;
                    }
                    break;
                case CON_DESCENDENTE:
                    if (swSwitches().swNaoHaCritMontantes().isTrue()) {
                        m2440ListaDscData() ;
                    } else {
                        m2450ListaDscMontante() ;
                    }
                    break;
                default :
                    break ;
            }
        } else {
            /**
             * CONSULTA COM DATA DO MOVIMENTO = DATA VALOR
             */
            switch (msgIn().msg().ade().iConsulta().get()) {
                case CON_ASCENDENTE:
                    if (swSwitches().swNaoHaCritMontantes().isTrue()) {
                        m2460ListaAscData2() ;
                    } else {
                        m2470ListaAscMontante2() ;
                    }
                    break;
                case CON_DESCENDENTE:
                    if (swSwitches().swNaoHaCritMontantes().isTrue()) {
                        m2480ListaDscData2() ;
                    } else {
                        m2490ListaDscMontante2() ;
                    }
                    break;
                default :
                    break ;
            }
        }
    }
    
    /**
     * 
     * 2420-LISTA-ASC-DATA
     * 
     */
    protected void m2420ListaAscData() {
        log(TraceLevel.Debug, "2420-LISTA-ASC-DATA");
        m2421OpenC1() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2422FetchC1() ;
        }
        while (!swSwitches().sw1Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2423TrataC1() ;
        }
        m2424CloseC1() ;
    }
    
    /**
     * 
     * 2430-LISTA-ASC-MONTANTE
     * 
     */
    protected void m2430ListaAscMontante() {
        log(TraceLevel.Debug, "2430-LISTA-ASC-MONTANTE");
        m2431OpenC3() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2432FetchC3() ;
        }
        while (!swSwitches().sw3Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2433TrataC3() ;
        }
        m2434CloseC3() ;
    }
    
    /**
     * 
     * 2440-LISTA-DSC-DATA
     * 
     */
    protected void m2440ListaDscData() {
        log(TraceLevel.Debug, "2440-LISTA-DSC-DATA");
        m2441OpenC2() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2442FetchC2() ;
        }
        while (!swSwitches().sw2Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2443TrataC2() ;
        }
        m2444CloseC2() ;
    }
    
    /**
     * 
     * 2450-LISTA-DSC-MONTANTE
     * 
     */
    protected void m2450ListaDscMontante() {
        log(TraceLevel.Debug, "2450-LISTA-DSC-MONTANTE");
        m2451OpenC4() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2452FetchC4() ;
        }
        while (!swSwitches().sw4Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2453TrataC4() ;
        }
        m2454CloseC4() ;
    }
    
    /**
     * 
     * 2460-LISTA-ASC-DATA-2
     * 
     */
    protected void m2460ListaAscData2() {
        log(TraceLevel.Debug, "2460-LISTA-ASC-DATA-2");
        m2461OpenC5() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2462FetchC5() ;
        }
        while (!swSwitches().sw5Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2463TrataC5() ;
        }
        m2464CloseC5() ;
    }
    
    /**
     * 
     * 2470-LISTA-ASC-MONTANTE-2
     * 
     */
    protected void m2470ListaAscMontante2() {
        log(TraceLevel.Debug, "2470-LISTA-ASC-MONTANTE-2");
        m2471OpenC7() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2472FetchC7() ;
        }
        while (!swSwitches().sw7Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2473TrataC7() ;
        }
        m2474CloseC7() ;
    }
    
    /**
     * 
     * 2480-LISTA-DSC-DATA-2
     * 
     */
    protected void m2480ListaDscData2() {
        log(TraceLevel.Debug, "2480-LISTA-DSC-DATA-2");
        m2481OpenC6() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2482FetchC6() ;
        }
        while (!swSwitches().sw6Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2483TrataC6() ;
        }
        m2484CloseC6() ;
    }
    
    /**
     * 
     * 2490-LISTA-DSC-MONTANTE-2
     * 
     */
    protected void m2490ListaDscMontante2() {
        log(TraceLevel.Debug, "2490-LISTA-DSC-MONTANTE-2");
        m2491OpenC8() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2492FetchC8() ;
        }
        while (!swSwitches().sw8Vgh00201Notfnd().isTrue() && !msgOut().paginaCheia().isTrue() && envOut.errosGraves().semErros().isTrue()) {
            m2493TrataC8() ;
        }
        m2494CloseC8() ;
    }
    
    /**
     * 
     * 2421-OPEN-C1
     * 
     */
    protected void m2421OpenC1() {
        log(TraceLevel.Debug, "2421-OPEN-C1");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00201Movhst().openPghs110a2218(wsVariaveis().wsTsInicio(), wsVariaveis().wsTsFim(), wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw1SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw1Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2422-FETCH-C1
     * 
     */
    protected void m2422FetchC1() {
        log(TraceLevel.Debug, "2422-FETCH-C1");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv00201Movhst().fetchPghs110a2250() ;
        swSwitches().sw1SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw1Vgh00201Ok().isTrue() && !swSwitches().sw1Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2423-TRATA-C1
     * 
     */
    protected void m2423TrataC1() {
        log(TraceLevel.Debug, "2423-TRATA-C1");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2422FetchC1() ;
        }
    }
    
    /**
     * 
     * 2424-CLOSE-C1
     * 
     */
    protected void m2424CloseC1() {
        log(TraceLevel.Debug, "2424-CLOSE-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv00201Movhst().closePghs110a2329() ;
        swSwitches().sw1SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw1Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2431-OPEN-C3
     * 
     */
    protected void m2431OpenC3() {
        log(TraceLevel.Debug, "2431-OPEN-C3");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv00201Movhst().openPghs110a2361(wsVariaveis().wsTsInicio(), wsVariaveis().wsTsFim(), wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw3SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw3Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2432-FETCH-C3
     * 
     */
    protected void m2432FetchC3() {
        log(TraceLevel.Debug, "2432-FETCH-C3");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C3
         */
        hv00201Movhst().fetchPghs110a2393() ;
        swSwitches().sw3SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw3Vgh00201Ok().isTrue() && !swSwitches().sw3Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2433-TRATA-C3
     * 
     */
    protected void m2433TrataC3() {
        log(TraceLevel.Debug, "2433-TRATA-C3");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2432FetchC3() ;
        }
    }
    
    /**
     * 
     * 2434-CLOSE-C3
     * 
     */
    protected void m2434CloseC3() {
        log(TraceLevel.Debug, "2434-CLOSE-C3");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C3
         */
        hv00201Movhst().closePghs110a2472() ;
        swSwitches().sw3SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw3Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2441-OPEN-C2
     * 
     */
    protected void m2441OpenC2() {
        log(TraceLevel.Debug, "2441-OPEN-C2");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv00201Movhst().openPghs110a2504(wsVariaveis().wsTsInicio(), wsVariaveis().wsTsFim(), wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw2SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw3Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2442-FETCH-C2
     * 
     */
    protected void m2442FetchC2() {
        log(TraceLevel.Debug, "2442-FETCH-C2");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C2
         */
        hv00201Movhst().fetchPghs110a2536() ;
        swSwitches().sw2SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw2Vgh00201Ok().isTrue() && !swSwitches().sw2Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2443-TRATA-C2
     * 
     */
    protected void m2443TrataC2() {
        log(TraceLevel.Debug, "2443-TRATA-C2");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2442FetchC2() ;
        }
    }
    
    /**
     * 
     * 2444-CLOSE-C2
     * 
     */
    protected void m2444CloseC2() {
        log(TraceLevel.Debug, "2444-CLOSE-C2");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C2
         */
        hv00201Movhst().closePghs110a2615() ;
        swSwitches().sw2SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw2Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2451-OPEN-C4
     * 
     */
    protected void m2451OpenC4() {
        log(TraceLevel.Debug, "2451-OPEN-C4");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C4
         */
        hv00201Movhst().openPghs110a2647(wsVariaveis().wsTsInicio(), wsVariaveis().wsTsFim(), wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw4SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw4Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2452-FETCH-C4
     * 
     */
    protected void m2452FetchC4() {
        log(TraceLevel.Debug, "2452-FETCH-C4");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C4
         */
        hv00201Movhst().fetchPghs110a2679() ;
        swSwitches().sw4SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw4Vgh00201Ok().isTrue() && !swSwitches().sw4Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2453-TRATA-C4
     * 
     */
    protected void m2453TrataC4() {
        log(TraceLevel.Debug, "2453-TRATA-C4");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2452FetchC4() ;
        }
    }
    
    /**
     * 
     * 2454-CLOSE-C4
     * 
     */
    protected void m2454CloseC4() {
        log(TraceLevel.Debug, "2454-CLOSE-C4");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C4
         */
        hv00201Movhst().closePghs110a2758() ;
        swSwitches().sw4SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw4Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2461-OPEN-C5
     * 
     */
    protected void m2461OpenC5() {
        log(TraceLevel.Debug, "2461-OPEN-C5");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C5
         */
        hv00201Movhst().openPghs110a2790(wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw5SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw5Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2462-FETCH-C5
     * 
     */
    protected void m2462FetchC5() {
        log(TraceLevel.Debug, "2462-FETCH-C5");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C5
         */
        hv00201Movhst().fetchPghs110a2822() ;
        swSwitches().sw5SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw5Vgh00201Ok().isTrue() && !swSwitches().sw5Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2463-TRATA-C5
     * 
     */
    protected void m2463TrataC5() {
        log(TraceLevel.Debug, "2463-TRATA-C5");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2462FetchC5() ;
        }
    }
    
    /**
     * 
     * 2464-CLOSE-C5
     * 
     */
    protected void m2464CloseC5() {
        log(TraceLevel.Debug, "2464-CLOSE-C5");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C5
         */
        hv00201Movhst().closePghs110a2901() ;
        swSwitches().sw5SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw5Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2471-OPEN-C7
     * 
     */
    protected void m2471OpenC7() {
        log(TraceLevel.Debug, "2471-OPEN-C7");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C7
         */
        hv00201Movhst().openPghs110a2933(wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw7SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw7Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2472-FETCH-C7
     * 
     */
    protected void m2472FetchC7() {
        log(TraceLevel.Debug, "2472-FETCH-C7");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C7
         */
        hv00201Movhst().fetchPghs110a2965() ;
        swSwitches().sw7SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw7Vgh00201Ok().isTrue() && !swSwitches().sw7Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2473-TRATA-C7
     * 
     */
    protected void m2473TrataC7() {
        log(TraceLevel.Debug, "2473-TRATA-C7");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2472FetchC7() ;
        }
    }
    
    /**
     * 
     * 2474-CLOSE-C7
     * 
     */
    protected void m2474CloseC7() {
        log(TraceLevel.Debug, "2474-CLOSE-C7");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C7
         */
        hv00201Movhst().closePghs110a3044() ;
        swSwitches().sw7SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw7Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2481-OPEN-C6
     * 
     */
    protected void m2481OpenC6() {
        log(TraceLevel.Debug, "2481-OPEN-C6");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C6
         */
        hv00201Movhst().openPghs110a3076(wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw6SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw6Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2482-FETCH-C6
     * 
     */
    protected void m2482FetchC6() {
        log(TraceLevel.Debug, "2482-FETCH-C6");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C6
         */
        hv00201Movhst().fetchPghs110a3108() ;
        swSwitches().sw6SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw6Vgh00201Ok().isTrue() && !swSwitches().sw6Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2483-TRATA-C6
     * 
     */
    protected void m2483TrataC6() {
        log(TraceLevel.Debug, "2483-TRATA-C6");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2482FetchC6() ;
        }
    }
    
    /**
     * 
     * 2484-CLOSE-C6
     * 
     */
    protected void m2484CloseC6() {
        log(TraceLevel.Debug, "2484-CLOSE-C6");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C6
         */
        hv00201Movhst().closePghs110a3187() ;
        swSwitches().sw6SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw6Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2491-OPEN-C8
     * 
     */
    protected void m2491OpenC8() {
        log(TraceLevel.Debug, "2491-OPEN-C8");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C8
         */
        hv00201Movhst().openPghs110a3219(wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsValMovMin(), wsVariaveis().wsValMovMax(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2()) ;
        swSwitches().sw8SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw8Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2492-FETCH-C8
     * 
     */
    protected void m2492FetchC8() {
        log(TraceLevel.Debug, "2492-FETCH-C8");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C8
         */
        hv00201Movhst().fetchPghs110a3251() ;
        swSwitches().sw8SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw8Vgh00201Ok().isTrue() && !swSwitches().sw8Vgh00201Notfnd().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2493-TRATA-C8
     * 
     */
    protected void m2493TrataC8() {
        log(TraceLevel.Debug, "2493-TRATA-C8");
        m2900FormataLista() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2492FetchC8() ;
        }
    }
    
    /**
     * 
     * 2494-CLOSE-C8
     * 
     */
    protected void m2494CloseC8() {
        log(TraceLevel.Debug, "2494-CLOSE-C8");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C8
         */
        hv00201Movhst().closePghs110a3330() ;
        swSwitches().sw8SqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        envOut.db2Log().nmTabela().set(CON_VGH00201);
        bhtp0002M9020Db2check() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!swSwitches().sw8Vgh00201Ok().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            }
        }
    }
    
    /**
     * 
     * 2520-OBTEM-MOV-DIA-HO
     * 
     */
    protected void m2520ObtemMovDiaHo() {
        log(TraceLevel.Debug, "2520-OBTEM-MOV-DIA-HO");
        if (!msgIn().msg().ade().ascendente().isTrue() && !msgIn().msg().ade().descendente().isTrue()) {
            swSwitches().progDadosInvalidos().setTrue() ;
        }
        swSwitches().swNaoHaMov().setTrue() ;
        bhol804a().commarea().dadosInput().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhol804a().commarea().dadosInput().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhol804a().commarea().dadosInput().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhol804a().commarea().dadosInput().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhol804a().commarea().dadosInput().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhol804a().commarea().dadosInput().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhol804a().commarea().dadosInput().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        bhol804a().commarea().dadosInput().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        bhol804a().commarea().dadosInput().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        bhol804a().commarea().dadosInput().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        bhol804a().commarea().dadosInput().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        log(TraceLevel.Debug, "BGHM1100-I-CRIT-DBCR: ", msgIn().msg().ade().iCritDbcr());
        if (msgIn().msg().ade().debito().isTrue()) {
            bhol804a().commarea().dadosInput().debito().setTrue() ;
        } else {
            bhol804a().commarea().dadosInput().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        }
        bhol804a().commarea().dadosInput().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        /**
         * AS DATAS VAL-MOV-MIN E VAL-MOV-MAX SO ESTAO PREENCHIDAS
         * SE A CONSULTA FOR POR DATA VALOR
         */
        if (!msgIn().msg().ade().tsMovimento().isEmpty() && 
            !msgIn().msg().ade().tsMovMax().isEmpty()) {
            bhol804a().commarea().dadosInput().zValorMin().set(CON_Z_CRIACAO);
            bhol804a().commarea().dadosInput().zValorMax().set(CON_MAX_DATA_DB2);
        } else if (!msgIn().msg().ade().zValMovMin().isEqual(bhok0002().BHOK0002_Z_CRIACAO) && 
            !msgIn().msg().ade().zValMovMax().isEqual(bhok0002().BHOK0002_Z_CRIACAO)) {
            if (msgIn().msg().ade().ascendente().isTrue()) {
                bhol804a().commarea().dadosInput().zValorMin().set(wsVariaveis().wsValMovMin());
                bhol804a().commarea().dadosInput().zValorMax().set(wsVariaveis().wsValMovMax());
            } else {
                /**
                 * **            LOCAL TROCA
                 */
                bhol804a().commarea().dadosInput().zValorMin().set(msgIn().msg().ade().zValMovMax());
                wsVariaveis().wsValMovMax().set(msgIn().msg().ade().zValMovMax());
                bhol804a().commarea().dadosInput().zValorMax().set(msgIn().msg().ade().zValMovMin());
                wsVariaveis().wsValMovMin().set(msgIn().msg().ade().zValMovMin());
            }
        }
        bhol804a().commarea().dadosInput().critDatasMovDif().set(msgIn().msg().ade().critDatasMovDif());
        log(TraceLevel.Debug, "   BHOL804A-C-PAIS-ISOA-CONT  : ", bhol804a().commarea().dadosInput().argumento().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BHOL804A-C-BANC-CONT       : ", bhol804a().commarea().dadosInput().argumento().cBancCont());
        log(TraceLevel.Debug, "   BHOL804A-C-OE-EGC-CONT     : ", bhol804a().commarea().dadosInput().argumento().cOeEgcCont());
        log(TraceLevel.Debug, "   BHOL804A-NS-RDCL-CONT      : ", bhol804a().commarea().dadosInput().argumento().nsRdclCont());
        log(TraceLevel.Debug, "   BHOL804A-V-CHKD-CONT       : ", bhol804a().commarea().dadosInput().argumento().vChkdCont());
        log(TraceLevel.Debug, "   BHOL804A-C-TIPO-CONT       : ", bhol804a().commarea().dadosInput().argumento().cTipoCont());
        log(TraceLevel.Debug, "   BHOL804A-C-MOED-ISO-SCTA   : ", bhol804a().commarea().dadosInput().argumento().cMoedIsoScta());
        log(TraceLevel.Debug, "   BHOL804A-NS-DEPOSITO       : ", bhol804a().commarea().dadosInput().argumento().nsDeposito());
        log(TraceLevel.Debug, "   BHOL804A-NS-MOVIMENTO      : ", bhol804a().commarea().dadosInput().argumento().nsMovimento());
        log(TraceLevel.Debug, "   BHOL804A-M-MOV-MAX         : ", bhol804a().commarea().dadosInput().criterioMontante().mMovMax());
        log(TraceLevel.Debug, "   BHOL804A-M-MOV-MIN         : ", bhol804a().commarea().dadosInput().criterioMontante().mMovMin());
        log(TraceLevel.Debug, "   BHOL804A-I-CRITERIO-DBCR   : ", bhol804a().commarea().dadosInput().iCriterioDbcr());
        log(TraceLevel.Debug, "   BHOL804A-I-CRITERIO-CNS    : ", bhol804a().commarea().dadosInput().criterioConsulta().iCriterioCns());
        log(TraceLevel.Debug, "   BHOL804A-Z-VALOR-MIN       : ", bhol804a().commarea().dadosInput().zValorMin());
        log(TraceLevel.Debug, "   BHOL804A-Z-VALOR-MAX       : ", bhol804a().commarea().dadosInput().zValorMax());
        log(TraceLevel.Debug, "   BHOL804A-CRIT-DATAS-MOV-DIF: ", bhol804a().commarea().dadosInput().critDatasMovDif());
        log(TraceLevel.Debug, "   BHOL804A-I-MOV-DIA         : ", bhol804a().commarea().dadosInput().criterioDia().iMovDia());
        log(TraceLevel.Debug, "   BHOL804A-DEBUG             : ", bhol804a().commarea().dadosInput().debug());
        bhop0804AcedeMhos804a() ;
        if (bhol804a().commarea().dadosErro().semErros().isTrue()) {
            swSwitches().swHaMov().setTrue() ;
        }
        if (!bhol804a().commarea().dadosErro().semErros().isTrue() && !bhol804a().commarea().dadosErro().naoExiste().isTrue()) {
            swSwitches().progStatus().set(bhol804a().commarea().dadosErro().cRtnoEvenSwal());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(swSwitches().progStatus());
            envOut.errosGraves().cRtnoEvenSwal().set(swSwitches().progStatus());
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.db2Log().sqlca().cSqlcode().set(bhol804a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set("THO00020");
            envOut.errosGraves().aAplErr().set(bhol804a().commarea().dadosErro().aAplErr());
        }
        log(TraceLevel.Debug, "SW-CRT-MOV      : ", swSwitches().swCrtMov());
        log(TraceLevel.Debug, "WS-MOV-FALTA    : ", wsMovFalta);
        log(TraceLevel.Debug, "SW-CRT-CANAL    : ", swSwitches().swCrtCanal());
        log(TraceLevel.Debug, "BHOL804A-Q-ITENS: ", bhol804a().commarea().dadosOutput().qItens());
        if (swSwitches().swHaMov().isTrue()) {
            if (bhol804a().commarea().dadosOutput().qItens().isLessOrEqual(wsMovFalta)) {
                wsVariaveis().wsQItens().set(bhol804a().commarea().dadosOutput().qItens());
            } else {
                wsVariaveis().wsQItens().set(wsMovFalta);
            }
            log(TraceLevel.Debug, "WS-MOV-FALTA    : ", wsMovFalta);
            log(TraceLevel.Debug, "WS-Q-ITENS      : ", wsVariaveis().wsQItens());
            wsMovFalta.set(subtract(wsMovFalta, wsVariaveis().wsQItens()));
            for (bhol804a().commarea().dadosOutput().lista().setIndex(1); bhol804a().commarea().dadosOutput().lista().index().isLessOrEqual(wsVariaveis().wsQItens()) && swSwitches().progStatus().isLessOrEqual(0); bhol804a().commarea().dadosOutput().lista().incIndex()) {
                if (!msgOut().paginaCheia().isTrue()) {
                    bhol804a().commarea().dadosInput().argumento().set(bhol804a().commarea().dadosOutput().lista().getCurrent().item().itemArgumento());
                    bhol804a().commarea().dadosInput().detalhe().set(bhol804a().commarea().dadosOutput().lista().getCurrent().item().itemDetalhe());
                    msgOut().indice().add(1);
                    msgOut().msg().ade().grMov().get(msgOut().indice()).zMovimento().set(bhol804a().commarea().dadosInput().argumento().zMovimento());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento().set(bhol804a().commarea().dadosInput().argumento().nsMovimento());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).zValMov().set(bhol804a().commarea().dadosInput().detalhe().zValor());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr().set(bhol804a().commarea().dadosInput().detalhe().iDbcr());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).mMovimento().set(bhol804a().commarea().dadosInput().detalhe().mMovimento());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).iEstorno().set(bhol804a().commarea().dadosInput().detalhe().iEstorno());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).cMoedIsoOriMov().set(bhol804a().commarea().dadosInput().detalhe().cMoedIsoOriMov());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos().set(bhol804a().commarea().dadosInput().detalhe().mSldoCbloApos());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos().set(bhol804a().commarea().dadosInput().detalhe().mSldoDpnlApos());
                    if (!swSwitches().swBalcao().isTrue()) {
                        log(TraceLevel.Debug, "BGHM1101-INDICE           : ", msgOut().indice());
                        log(TraceLevel.Debug, "BGHM1101-M-SLDO-CBLO-APOS : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos());
                        log(TraceLevel.Debug, "BGHM1101-M-SLDO-DPNL-APOS : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos());
                        if (!msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos().isEqual(msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos())) {
                            m2525CalculaSldoDpnlHo() ;
                        }
                    }
                    msgOut().msg().ade().grMov().get(msgOut().indice()).mMovMoeOrigMov().set(bhol804a().commarea().dadosInput().detalhe().mMovMoeOrigMov());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov().set(bhol804a().commarea().dadosInput().detalhe().xRefMov());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).nDocOpps().set(bhol804a().commarea().dadosInput().detalhe().nDocOpps());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).tJuro().set(bhol804a().commarea().dadosInput().detalhe().tJuro());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).aAplOrig().set(bhol804a().commarea().dadosInput().detalhe().aAplOrig());
                    msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi().set("N");
                }
                log(TraceLevel.Debug, "   ---------------------------- ");
                log(TraceLevel.Debug, "... LISTA                     : ");
                log(TraceLevel.Debug, "   ---------------------------- ");
                log(TraceLevel.Debug, "   BGHM1101-Z-MOVIMENTO       : ", msgOut().msg().ade().grMov().get(msgOut().indice()).zMovimento());
                log(TraceLevel.Debug, "   BGHM1101-NS-MOVIMENTO      : ", msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento());
                log(TraceLevel.Debug, "   BGHM1101-Z-VAL-MOV         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).zValMov());
                log(TraceLevel.Debug, "   BGHM1101-X-REF-MOV         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov());
                log(TraceLevel.Debug, "   BGHM1101-M-MOVIMENTO       : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mMovimento());
                log(TraceLevel.Debug, "   BGHM1101-I-DBCR            : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr());
                log(TraceLevel.Debug, "   BGHM1101-I-ESTORNO         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iEstorno());
                log(TraceLevel.Debug, "   BGHM1101-C-MOED-ISO-ORI-MOV: ", msgOut().msg().ade().grMov().get(msgOut().indice()).cMoedIsoOriMov());
                log(TraceLevel.Debug, "   BGHM1101-M-SLDO-CBLO-APOS  : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos());
                log(TraceLevel.Debug, "   BGHM1101-M-SLDO-DPNL-APOS  : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos());
                log(TraceLevel.Debug, "   BGHM1101-M-MOV-MOE-ORIG-MOV: ", msgOut().msg().ade().grMov().get(msgOut().indice()).mMovMoeOrigMov());
                log(TraceLevel.Debug, "   BGHM1101-N-DOC-OPPS        : ", msgOut().msg().ade().grMov().get(msgOut().indice()).nDocOpps());
                log(TraceLevel.Debug, "   BGHM1101-A-APL-ORIG        : ", msgOut().msg().ade().grMov().get(msgOut().indice()).aAplOrig());
                log(TraceLevel.Debug, "   BGHM1101-T-JURO            : ", msgOut().msg().ade().grMov().get(msgOut().indice()).tJuro());
                log(TraceLevel.Debug, "   BGHM1101-I-EXIS-INF-ADI    : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi());
            }
        }
    }
    
    /**
     * 
     * 2900-FORMATA-LISTA
     * 
     */
    protected void m2900FormataLista() {
        log(TraceLevel.Debug, "2900-FORMATA-LISTA");
        msgOut().indice().add(1);
        msgOut().msg().ade().grMov().get(msgOut().indice()).zMovimento().set(hv00201Movhst().movhst().tsMovimento().get(1, 10));
        log(TraceLevel.Debug, "BGHM1101-INDICE: ", msgOut().indice());
        log(TraceLevel.Debug, "VGH00201-TS-MOVIMENTO(1:10): ", hv00201Movhst().movhst().tsMovimento().get(1, 10));
        if (msgOut().paginaCheia().isTrue()) {
            wsVariaveis().wsTsMovimentoGh().set(hv00201Movhst().movhst().tsMovimento());
        }
        msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        msgOut().msg().ade().grMov().get(msgOut().indice()).zValMov().set(hv00201Movhst().movhst().zValMov());
        msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr().set(hv00201Movhst().movhst().iDbcr());
        msgOut().msg().ade().grMov().get(msgOut().indice()).mMovimento().set(hv00201Movhst().movhst().mMovimento());
        msgOut().msg().ade().grMov().get(msgOut().indice()).iEstorno().set(hv00201Movhst().movhst().iEstorno());
        msgOut().msg().ade().grMov().get(msgOut().indice()).cMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
        msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
        if (!swSwitches().swBalcao().isTrue()) {
            log(TraceLevel.Debug, "BGHM1101-INDICE           : ", msgOut().indice());
            log(TraceLevel.Debug, "BGHM1101-M-SLDO-CBLO-APOS : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos());
            log(TraceLevel.Debug, "BGHM1101-M-SLDO-DPNL-APOS : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos());
            if (!msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos().isEqual(msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos())) {
                m2910CalculaSldoDpnlGh() ;
            }
        }
        msgOut().msg().ade().grMov().get(msgOut().indice()).mMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
        msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov().set(hv00201Movhst().movhst().xRefMov());
        msgOut().msg().ade().grMov().get(msgOut().indice()).nDocOpps().set(hv00201Movhst().movhst().nDocOpps());
        msgOut().msg().ade().grMov().get(msgOut().indice()).tJuro().set(hv00201Movhst().movhst().tJuro());
        msgOut().msg().ade().grMov().get(msgOut().indice()).aAplOrig().set(hv00201Movhst().movhst().aAplOrig());
        msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
        log(TraceLevel.Debug, "BGHM1101-I-EXIS-INF-ADI   : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi());
        if (msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi().isEqual("N")) {
            m2905VerInfAdiApl() ;
        }
        log(TraceLevel.Debug, "BGHM1101-I-EXIS-INF-ADI   : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi());
        log(TraceLevel.Debug, "BGHM1101-X-REF-MOV        : ", msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov());
        if (msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov().isEmpty()) {
            m2906ObtemDescritivoMov() ;
        } else {
            m2915VerificaContaHo() ;
        }
        log(TraceLevel.Debug, "WS-C-TIPO-TRTT-CONT       : ", wsCTipoTrttCont);
        if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
            wsTJuro.set(0);
            m2920ObtemTaxa() ;
            log(TraceLevel.Debug, "WS-T-JURO                 : ", wsTJuro);
            if (wsTJuro.isGreater(0)) {
                msgOut().msg().ade().grMov().get(msgOut().indice()).tJuro().set(wsTJuro);
            }
        }
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "... LISTA                     : ");
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "   BGHM1101-Z-MOVIMENTO       : ", msgOut().msg().ade().grMov().get(msgOut().indice()).zMovimento());
        log(TraceLevel.Debug, "   BGHM1101-NS-MOVIMENTO      : ", msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento());
        log(TraceLevel.Debug, "   BGHM1101-Z-VAL-MOV         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).zValMov());
        log(TraceLevel.Debug, "   BGHM1101-X-REF-MOV         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov());
        log(TraceLevel.Debug, "   BGHM1101-M-MOVIMENTO       : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mMovimento());
        log(TraceLevel.Debug, "   BGHM1101-I-DBCR            : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr());
        log(TraceLevel.Debug, "   BGHM1101-I-ESTORNO         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iEstorno());
        log(TraceLevel.Debug, "   BGHM1101-C-MOED-ISO-ORI-MOV: ", msgOut().msg().ade().grMov().get(msgOut().indice()).cMoedIsoOriMov());
        log(TraceLevel.Debug, "   BGHM1101-M-SLDO-CBLO-APOS  : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoCbloApos());
        log(TraceLevel.Debug, "   BGHM1101-M-SLDO-DPNL-APOS  : ", msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos());
        log(TraceLevel.Debug, "   BGHM1101-M-MOV-MOE-ORIG-MOV: ", msgOut().msg().ade().grMov().get(msgOut().indice()).mMovMoeOrigMov());
        log(TraceLevel.Debug, "   BGHM1101-N-DOC-OPPS        : ", msgOut().msg().ade().grMov().get(msgOut().indice()).nDocOpps());
        log(TraceLevel.Debug, "   BGHM1101-A-APL-ORIG        : ", msgOut().msg().ade().grMov().get(msgOut().indice()).aAplOrig());
        log(TraceLevel.Debug, "   BGHM1101-T-JURO            : ", msgOut().msg().ade().grMov().get(msgOut().indice()).tJuro());
        log(TraceLevel.Debug, "   BGHM1101-I-EXIS-INF-ADI    : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi());
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "... PARA ENCADEAMENTO           ");
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "   BGHM1100-C-PAIS-ISOA-CONT  : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BGHM1100-C-BANC-CONT       : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "   BGHM1100-C-OE-EGC-CONT     : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "   BGHM1100-NS-RDCL-CONT      : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "   BGHM1100-V-CHKD-CONT       : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "   BGHM1100-C-TIPO-CONT       : ", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "   BGHM1100-C-MOED-ISO-SCTA   : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "   BGHM1100-NS-DEPOSITO       : ", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "   BGHM1100-TS-MOVIMENTO      : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "   BGHM1101-Z-MOVIMENTO       : ", msgOut().msg().ade().grMov().get(msgOut().indice()).zMovimento());
        log(TraceLevel.Debug, "   BGHM1101-NS-MOVIMENTO      : ", msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento());
        log(TraceLevel.Debug, "   BGHM1101-Z-VAL-MOV         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).zValMov());
        log(TraceLevel.Debug, "   BGHM1101-X-REF-MOV         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov());
        log(TraceLevel.Debug, "   BGHM1101-I-DBCR            : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr());
        log(TraceLevel.Debug, "   BGHM1101-I-ESTORNO         : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iEstorno());
        log(TraceLevel.Debug, "   BGHM1101-N-DOC-OPPS        : ", msgOut().msg().ade().grMov().get(msgOut().indice()).nDocOpps());
        log(TraceLevel.Debug, "   BGHM1101-A-APL-ORIG        : ", msgOut().msg().ade().grMov().get(msgOut().indice()).aAplOrig());
        log(TraceLevel.Debug, "   BGHM1101-T-JURO            : ", msgOut().msg().ade().grMov().get(msgOut().indice()).tJuro());
        log(TraceLevel.Debug, "   BGHM1101-I-EXIS-INF-ADI    : ", msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi());
    }
    
    /**
     * 
     * 2905-VER-INF-ADI-APL
     * 
     */
    protected void m2905VerInfAdiApl() {
        log(TraceLevel.Debug, "2905-VER-INF-ADI-APL");
        bghw0013().tbAplDtArr().itemApl().resetIndex() ;
        while (bghw0013().tbAplDtArr().itemApl().index().isLessOrEqual(10)) {
            if (msgOut().msg().ade().grMov().get(msgOut().indice()).zMovimento().isGreaterOrEqual(bghw0013().tbAplDtArr().itemApl().getCurrent().tabZArranq()) && 
                msgOut().msg().ade().grMov().get(msgOut().indice()).aAplOrig().isEqual(bghw0013().tbAplDtArr().itemApl().getCurrent().tabAAplic())) {
                msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi().set("S");
                break;
            }
            bghw0013().tbAplDtArr().itemApl().incIndex() ;
        }
        if (bghw0013().tbAplDtArr().itemApl().atEnd()) {
            msgOut().msg().ade().grMov().get(msgOut().indice()).iExisInfAdi().set("N");
        }
    }
    
    /**
     * 
     * 2906-OBTEM-DESCRITIVO-MOV
     * 
     */
    protected void m2906ObtemDescritivoMov() {
        log(TraceLevel.Debug, "2906-OBTEM-DESCRITIVO-MOV");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(msgOut().msg().ade().grMov().get(msgOut().indice()).iEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(msgOut().msg().ade().grMov().get(msgOut().indice()).zValMov());
        m2907ObterCOeOpex() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m2908ObtemCOpeBbn() ;
        }
        log(TraceLevel.Debug, "MGH102A-C-OPE-BBN: ", hrMghs102a().bghl102a().detalhe().cOpeBbn());
        if (envOut.errosGraves().semErros().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs102a().bghl102a().detalhe().cOpeBbn());
            hrMghk800a().run() ;
            if (hrMghk800a().bghl800a().ok().isTrue()) {
                msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
                wsCTipoTrttCont.set(hrMghk800a().bghl800a().output().cTipoTrttCont());
            } else {
                log(TraceLevel.Debug, "MGH800A-C-RETORNO  -", hrMghk800a().bghl800a().cRetorno());
                log(TraceLevel.Debug, "MGH800A-NM-PROGRAMA-", hrMghk800a().bghl800a().nmPrograma());
                log(TraceLevel.Debug, "MGH800A-C-SQLCODE  -", hrMghk800a().bghl800a().cSqlcode());
                msgOut().msg().ade().grMov().get(msgOut().indice()).xRefMov().set(" ");
            }
        }
    }
    
    /**
     * 
     * 2907-OBTER-C-OE-OPEX
     * 
     */
    protected void m2907ObterCOeOpex() {
        log(TraceLevel.Debug, "2907-OBTER-C-OE-OPEX");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            envOut.errosGraves().cRtnoEvenSwal().set(hrMghs102a().bghl102a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs102a().bghl102a().cRetorno());
            swSwitches().progStatus().set(hrMghs102a().bghl102a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 2908-OBTEM-C-OPE-BBN
     * 
     */
    protected void m2908ObtemCOpeBbn() {
        log(TraceLevel.Debug, "2908-OBTEM-C-OPE-BBN");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            swSwitches().progStatus().set(hrMghs102a().bghl102a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs102a().bghl102a().cRetorno());
            envOut.errosGraves().cRtnoEvenSwal().set(hrMghs102a().bghl102a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 2910-CALCULA-SLDO-DPNL-GH
     * 
     */
    protected void m2910CalculaSldoDpnlGh() {
        log(TraceLevel.Debug, "2910-CALCULA-SLDO-DPNL-GH");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        hrMghs102a().bghl102a().criterioConsulta().crtSaldos().setTrue() ;
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(hv00201Movhst().movhst().tsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(hv00201Movhst().movhst().nsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            swSwitches().progStatus().set(hrMghs102a().bghl102a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMghs102a().bghl102a().cRetorno());
            envOut.errosGraves().cRtnoEvenSwal().set(hrMghs102a().bghl102a().cRetorno());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
        log(TraceLevel.Debug, "MGH102A-C-RETORNO        : ", hrMghs102a().bghl102a().cRetorno());
        log(TraceLevel.Debug, "WS-APL-HST               : ", WS_APL_HST);
        log(TraceLevel.Debug, "WS-ERR-FUNC              : ", WS_ERR_FUNC);
        log(TraceLevel.Debug, "MGH102A-C-SQLCODE        : ", hrMghs102a().bghl102a().cSqlcode());
        log(TraceLevel.Debug, "MGH102A-M-SLDO-RETD      : ", hrMghs102a().bghl102a().detalhe().mSldoRetd());
        log(TraceLevel.Debug, "MGH102A-M-SLDO-VCOB      : ", hrMghs102a().bghl102a().detalhe().mSldoVcob());
        log(TraceLevel.Debug, "VGH00201-M-SLDO-CBLO-APOS: ", hv00201Movhst().movhst().mSldoCbloApos());
        if (envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ade().grMov().get(msgOut().indice()).mSldoDpnlApos().set(subtract(hv00201Movhst().movhst().mSldoCbloApos(), add(hrMghs102a().bghl102a().detalhe().mSldoRetd(), hrMghs102a().bghl102a().detalhe().mSldoVcob())));
        }
    }
    
    /**
     * 
     * 2915-VERIFICA-CONTA-HO
     * 
     */
    protected void m2915VerificaContaHo() {
        log(TraceLevel.Debug, "2915-VERIFICA-CONTA-HO");
        hrMghj801a().bghl801a().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghj801a().bghl801a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghj801a().bghl801a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        if (msgOut().msg().ade().grMov().get(msgOut().indice()).iEstorno().isEqual("E")) {
            if (msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(msgOut().msg().ade().grMov().get(msgOut().indice()).iDbcr());
        }
        hrMghj801a().run() ;
        if (hrMghj801a().bghl801a().ok().isTrue()) {
            wsCTipoTrttCont.set(hrMghj801a().bghl801a().detalhe().cTipoTrttCont());
        } else {
            wsCTipoTrttCont.set(" ");
        }
    }
    
    /**
     * 
     * 2920-OBTEM-TAXA
     * 
     */
    protected void m2920ObtemTaxa() {
        log(TraceLevel.Debug, "2920-OBTEM-TAXA");
        hrMghs802a().bghl802a().initialize() ;
        hrMghs802a().bghl802a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs802a().bghl802a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs802a().bghl802a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs802a().bghl802a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs802a().bghl802a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs802a().bghl802a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs802a().bghl802a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs802a().bghl802a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs802a().bghl802a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().get(msgOut().indice()).nsMovimento());
        hrMghs802a().run() ;
        if (hrMghs802a().bghl802a().ok().isTrue()) {
            wsTJuro.set(hrMghs802a().bghl802a().detalhe().tJuro());
        } else {
            wsTJuro.set(0);
        }
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "3000-FINAL-PROGRAMA");
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        message.mensagem().headerR().transaccao().vizualizacao().setTrue() ;
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "...Se Erro:                  ");
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "   BGHM1101-C-PAIS-ISOA-CONT-S: ", msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContS());
        log(TraceLevel.Debug, "   BHTL001A-C-TIPO-ERRO-BBN   : ", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Debug, "   BHTL001A-C-RTNO-EVEN-SWAL  : ", envOut.errosGraves().cRtnoEvenSwal());
        log(TraceLevel.Debug, "   BHTL001A-A-APL-ERR         : ", envOut.errosGraves().aAplErr());
        log(TraceLevel.Debug, "   BGHM1101-C-PAIS-ISOA-CONT-M: ", msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM());
        log(TraceLevel.Debug, "   BHTL001A-C-SQLCODE         : ", envOut.db2Log().sqlca().cSqlcode());
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "...OUTPUT DA MENSAGEM         : ");
        log(TraceLevel.Debug, "   ---------------------------- ");
        log(TraceLevel.Debug, "   BGHM1101-C-TIT-HONO        : ", msgOut().msg().ade().cTitHono());
        log(TraceLevel.Debug, "   BGHM1101-NM-CLI-ABVD       : ", msgOut().msg().ade().nmCliAbvd());
        log(TraceLevel.Debug, "   BGHM1101-I-MSG-CTND        : ", msgOut().msg().ade().iMsgCtnd());
        log(TraceLevel.Debug, "   BGHM1101-TS-MOVIMENTO-K    : ", msgOut().msg().ade().tsMovimentoK());
        log(TraceLevel.Debug, "   BGHM1101-NS-MOVIMENTO-K    : ", msgOut().msg().ade().nsMovimentoK());
        log(TraceLevel.Debug, "   BGHM1101-Z-VAL-MOV-K       : ", msgOut().msg().ade().zValMovK());
        exit() ;
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
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimentoGh() ;
        
        @Data(size=10, value="0")
        ILong wsQMovTot() ;
        
        @Data(size=10, value=" ")
        IString wsTsMovIni() ;
        
        @Data(size=10, value=" ")
        IString wsTsMovFim() ;
        
        @Data(size=1, value=" ")
        IString wsCrit1() ;
        
        @Data(size=1, value=" ")
        IString wsCrit2() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMMovMin() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMMovMax() ;
        
        @Data(size=10)
        IString wsValMovMin() ;
        
        @Data(size=10)
        IString wsValMovMax() ;
        
        @Data(size=26)
        IString wsTsInicio() ;
        
        /**
         * @return instancia da classe local WTsInicio
         */
        @Data
        WTsInicio wTsInicio() ;
        
        @Data(size=26)
        IString wsTsFim() ;
        
        /**
         * @return instancia da classe local WTsFim
         */
        @Data
        WTsFim wTsFim() ;
        
        @Data(size=2, value="0")
        IInt wsQItens() ;
        
        
        public interface WTsInicio extends IDataStruct {
            
            @Data(size=10)
            IString wsDataInicio() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IInt wsHoraInicio() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wsMinInicio() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wsSecInicio() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wsRestInicio() ;
            
        }
        
        public interface WTsFim extends IDataStruct {
            
            @Data(size=10)
            IString wsDataFim() ;
            
            @Data(size=2, value="23", lpadding=1, lpaddingValue="-")
            IInt wsHoraFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wsMinFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wsSecFim() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wsRestFim() ;
            
        }
    }
    public interface WsTs extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTs
         */
        @Data(rpadding=16, rpaddingValue="")
        WDataTs wDataTs() ;
        
        
        public interface WDataTs extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaMin() ;
            
        }
    }
    public interface WsTsMax extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTsMax
         */
        @Data(rpadding=16, rpaddingValue="")
        WDataTsMax wDataTsMax() ;
        
        
        public interface WDataTsMax extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoMax() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMax() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaMax() ;
            
        }
    }
    public interface WTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestamp
         */
        @Data
        WDataTimestamp wDataTimestamp() ;
        
        /**
         * @return instancia da classe local WTimerTimestamp
         */
        @Data
        WTimerTimestamp wTimerTimestamp() ;
        
        
        public interface WDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMm() ;
            
            @Data(size=2, lpadding=1, rpadding=1, lpaddingValue="-", rpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wHora() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wMinuto() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wSegundo() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wResto() ;
            
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
        
        @Data(size=3, signed=true, value="0")
        IInt progStatus() ;
        @Data
        @Condition("0")
        ICondition progOk() ;
        @Data
        @Condition("233")
        ICondition progDadosInvalidos() ;
        @Data
        @Condition("097")
        ICondition progNaoExisteMov() ;
        @Data
        @Condition("080")
        ICondition progNaoExisteConta() ;
        @Data
        @Condition("091")
        ICondition progDataMinInv() ;
        @Data
        @Condition("092")
        ICondition progDataMaxInv() ;
        @Data
        @Condition("328")
        ICondition progMovJaExiste() ;
        @Data
        @Condition("216")
        ICondition progDb2() ;
        @Data
        @Condition("211")
        ICondition progAcesso() ;
        
        
        /**
         * -----HA MAIS MOVIMENTOS
         */
        @Data(size=1, value="N")
        IString swCrtMov() ;
        @Data
        @Condition("S")
        ICondition swNaoHaMov() ;
        @Data
        @Condition("N")
        ICondition swHaMov() ;
        
        
        /**
         * -----HA CRITERIO DE MONTANTES
         */
        @Data(size=1, value="N")
        IString swCritMontantes() ;
        @Data
        @Condition("S")
        ICondition swHaCritMontantes() ;
        @Data
        @Condition("N")
        ICondition swNaoHaCritMontantes() ;
        
        
        /**
         * -----DATA VALOR DIF DATA MOVIMENTO
         */
        @Data(size=1, value="N")
        IString swCritDatasMovDif() ;
        @Data
        @Condition("S")
        ICondition swDatasDiferentesS() ;
        @Data
        @Condition("N")
        ICondition swDatasDiferentesN() ;
        
        
        @Data(size=1, value="N")
        IString swUltMovGh() ;
        @Data
        @Condition("S")
        ICondition swUltMovGhS() ;
        @Data
        @Condition("N")
        ICondition swUltMovGhN() ;
        
        
        /**
         * -----CANAL
         */
        @Data(size=1, value=" ")
        IString swCrtCanal() ;
        @Data
        @Condition("A")
        ICondition swBalcao() ;
        
        
        /**
         * ----- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt sw1SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw1Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw1Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw1Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw1Vgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt sw2SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw2Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw2Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw2Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw2Vgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt sw3SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw3Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw3Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw3Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw3Vgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt sw4SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw4Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw4Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw4Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw4Vgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt sw5SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw5Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw5Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw5Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw5Vgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt sw6SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw6Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw6Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw6Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw6Vgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt sw7SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw7Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw7Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw7Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw7Vgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt sw8SqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition sw8Vgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition sw8Vgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition sw8Vgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition sw8Vgh00201Null() ;
        
        
    }
    
}
