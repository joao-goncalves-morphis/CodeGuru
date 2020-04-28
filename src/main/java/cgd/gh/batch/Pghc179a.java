package cgd.gh.batch;

import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
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
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghr1702 ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc179a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011", record="statusFht011")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fwk811
     */
    @Handler(name="FWK811", record="statusFwk811")
    @Data
    protected abstract Fwk811 ficheiroFwk811() ;
    
    /**
     * @return instancia da classe Fgh179
     */
    @Handler(name="FGH179", record="regFgh179400")
    @Data
    protected abstract Fgh179 ficheiroFgh179() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
    /**
     * @return instancia da classe Bhtl200a
     */
    @Data
    protected abstract Bhtl200a bhtl200a() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bhok0001
     */
    @Data
    protected abstract Bhok0001 bhok0001() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhok0003
     */
    @Data
    protected abstract Bhok0003 bhok0003() ;
    
    /**
     * @return instancia da classe Bhok0005
     */
    @Data
    protected abstract Bhok0005 bhok0005() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * @return instancia da classe Bhtk0001
     */
    @Data
    protected abstract Bhtk0001 bhtk0001() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bghr1702
     */
    @Data
    protected abstract Bghr1702 bghr1702() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHC179A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK811 = "FWK811" ;
    
    protected static final String CON_FGH179 = "FGH179" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHC179A" ;
    
    protected static final String CON_PROGRAM_DESC = "REFORMATADOR MOVIM VIA TELECOM, DIGITAL OR IT" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    /**
     * ****              CONSTANTES NUMERICAS                    ****
     */
    protected static final int CON_N1 = 1 ;
    
    protected static final String CON_C_BANC = "302" ;
    
    protected static final int CON_01 = 1 ;
    
    protected static final int CON_12 = 12 ;
    
    /**
     * VARIAVEIS AUXILIARES
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
    /**
     * 
     * ACESSO A ROTINA QUE OBTEM AS DATAS D POR APLICACAO
     * MHTQ250A
     * 
     */
    protected void bhtp0250DatasDAplic() {
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "*********** - INICIO - *************");
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        m2000ProcPrograma() ;
        m3000FinalPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100InicializaVar() ;
        m1200TrataEstatIni() ;
        m1300ObterDadosBatch() ;
        m1400ObterDatas() ;
        m1500TrataFicheiros() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        wsVariaveis().initialize() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        log(TraceLevel.Debug, "1200-TRATA-ESTAT-INI");
        bhow0013().dadosInput().nmPrograma().set(CON_NOME_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_PROGRAM_DESC);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-OBTER-DADOS-BATCH
     * 
     */
    protected void m1300ObterDadosBatch() {
        log(TraceLevel.Debug, "1300-OBTER-DADOS-BATCH");
        bhtp0011ObtemDados() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set("FHT011");
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
        bhop0013FormataAcesso() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1300-OBTER-DADOS-BATCH");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set("FHT011");
            bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1400-OBTER-DATAS
     * 
     */
    protected void m1400ObterDatas() {
        log(TraceLevel.Debug, "1400-OBTER-DATAS");
        bhtl250a().commarea().initialize() ;
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("MHYQ250A");
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OBTER-DATAS");
            bhtw0030().dadosEntrada().nmPrgChmd().set("MHTQ250A");
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(wsVariaveis().wsXCteuMhtq250a());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl250a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-TRATA-FICHEIROS
     * 
     */
    protected void m1500TrataFicheiros() {
        log(TraceLevel.Debug, "1500-TRATA-FICHEIROS");
        m1510OpenFwk811() ;
        m1520OpenFgh179() ;
    }
    
    /**
     * 
     * 1510-OPEN-FWK811
     * 
     */
    protected void m1510OpenFwk811() {
        log(TraceLevel.Debug, "1510-OPEN-FWK811");
        /**
         * \* ABRE FICHEIRO DE INPUT - FWK811
         */
        ficheiroFwk811().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK811);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk811().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk811().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK811);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk811().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-OPEN-FWK811");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1520-OPEN-FGH179
     * 
     */
    protected void m1520OpenFgh179() {
        log(TraceLevel.Debug, "1520-OPEN-FGH179");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FGH179
         */
        ficheiroFgh179().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH179);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh179().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh179().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH179);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh179().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-OPEN-FGH179");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        while (!ficheiroFwk811().getStatusOk()) {
            m2100FormataDetalhe() ;
        }
    }
    
    /**
     * 
     * 2100-FORMATA-DETALHE
     * 
     */
    protected void m2100FormataDetalhe() {
        log(TraceLevel.Debug, "2100-FORMATA-DETALHE");
        log(TraceLevel.Debug, "WS-Z-OPERACAO-ANT: ", wsVariaveis().wsAnt().wsZOperacaoAnt());
        log(TraceLevel.Debug, "WS-C-TIP-OPER-ANT: ", wsVariaveis().wsAnt().wsCTipOperAnt());
        log(TraceLevel.Debug, "WS-C-TIP-DIR-MOV-ANT: ", wsVariaveis().wsAnt().wsCTipDirMovAnt());
        log(TraceLevel.Debug, "WS-M-VALOR-ANT: ", wsVariaveis().wsAnt().wsMValorAnt());
        log(TraceLevel.Debug, "WS-C-MOED-MOV-ANT: ", wsVariaveis().wsAnt().wsCMoedMovAnt());
        log(TraceLevel.Debug, "WS-C-PAIS-DEST-OPER-ANT:", wsVariaveis().wsAnt().wsCPaisDestOperAnt());
        log(TraceLevel.Debug, "WS-Q-VOLUME-ANT: ", wsVariaveis().wsAnt().wsQVolumeAnt());
        if (wsVariaveis().wsAnt().wsZOperacaoAnt().isEmpty() && 
            wsVariaveis().wsAnt().wsCTipOperAnt().isEmpty() && 
            wsVariaveis().wsAnt().wsCTipDirMovAnt().isEmpty() && 
            wsVariaveis().wsAnt().wsMValorAnt().isEqual(0) && 
            wsVariaveis().wsAnt().wsCMoedMovAnt().isEmpty() && 
            wsVariaveis().wsAnt().wsCPaisDestOperAnt().isEmpty() && 
            wsVariaveis().wsAnt().wsQVolumeAnt().isEqual(0)) {
            m2200ReadFwk811() ;
            wsVariaveis().wsAnt().wsTipMovAnt().set(bghr1702().registo().detalheV112().iTipMovV112());
            wsVariaveis().wsAnt().wsZOperacaoAnt().set(bghr1702().registo().detalheV112().zOperacaoV112());
            wsVariaveis().wsAnt().wsQVolumeAnt().set(bghr1702().registo().detalheV112().qVolumeRegV112());
            wsVariaveis().wsAnt().wsCTipOperAnt().set(bghr1702().registo().detalheV112().cTipOperV112());
            wsVariaveis().wsAnt().wsCTipDirMovAnt().set(bghr1702().registo().detalheV112().cTipDirMovV112());
            wsVariaveis().wsAnt().wsMValorAnt().set(bghr1702().registo().detalheV112().mValorV112());
            wsVariaveis().wsAnt().wsMValFilAnt().set(bghr1702().registo().detalheV112().mValFillerV112());
            wsVariaveis().wsAnt().wsCPaisDestOperAnt().set(bghr1702().registo().detalheV112().cPaisDestOperV112());
            wsVariaveis().wsAnt().wsCMoedMovAnt().set(bghr1702().registo().detalheV112().cMoedMovV112());
            wsVariaveis().wsAnt().wsXDescAnt().set(bghr1702().registo().detalheV112().xDescritivoV112());
            log(TraceLevel.Debug, "WS-TIP-MOV-ANT: ", wsVariaveis().wsAnt().wsTipMovAnt());
            log(TraceLevel.Debug, "WS-Z-OPERACAO-ANT: ", wsVariaveis().wsAnt().wsZOperacaoAnt());
            log(TraceLevel.Debug, "WS-C-TIP-OPER-ANT: ", wsVariaveis().wsAnt().wsCTipOperAnt());
            log(TraceLevel.Debug, "WS-C-TIP-DIR-MOV-ANT : ", wsVariaveis().wsAnt().wsCTipDirMovAnt());
            log(TraceLevel.Debug, "WS-M-VALOR-ANT: ", wsVariaveis().wsAnt().wsMValorAnt());
            log(TraceLevel.Debug, "WS-M-VAL-FIL-ANT: ", wsVariaveis().wsAnt().wsMValFilAnt());
            log(TraceLevel.Debug, "WS-C-PAIS-DEST-OPER-ANT: ", wsVariaveis().wsAnt().wsCPaisDestOperAnt());
            log(TraceLevel.Debug, "WS-C-MOED-MOV-ANT: ", wsVariaveis().wsAnt().wsCMoedMovAnt());
            log(TraceLevel.Debug, "WS-X-DESC-ANT: ", wsVariaveis().wsAnt().wsXDescAnt());
        }
        log(TraceLevel.Debug, "WS-LIDOS-FWK80-TOTAL:", wsVariaveis().wsLidosFwk811Total());
        if (wsVariaveis().wsLidosFwk811Total().isEqual(1)) {
            m2300FormataHeader() ;
        }
        if (!ficheiroFwk811().getStatusOk()) {
            m2200ReadFwk811() ;
        }
        log(TraceLevel.Debug, "BGHR1702-Z-OPERACAO-V112: ", bghr1702().registo().detalheV112().zOperacaoV112());
        log(TraceLevel.Debug, "WS-Z-OPERACAO-ANT: ", wsVariaveis().wsAnt().wsZOperacaoAnt());
        log(TraceLevel.Debug, "BGHR1702-C-TIP-OPER-V112: ", bghr1702().registo().detalheV112().cTipOperV112());
        log(TraceLevel.Debug, "WS-C-TIP-OPER-ANT: ", wsVariaveis().wsAnt().wsCTipOperAnt());
        log(TraceLevel.Debug, "BGHR1702-C-TIP-DIR-MOV-V112: ", bghr1702().registo().detalheV112().cTipDirMovV112());
        log(TraceLevel.Debug, "WS-C-PAIS-DEST-OPER-ANT: ", wsVariaveis().wsAnt().wsCPaisDestOperAnt());
        log(TraceLevel.Debug, "BGHR1702-C-MOED-MOV-V112:", bghr1702().registo().detalheV112().cMoedMovV112());
        log(TraceLevel.Debug, "WS-C-MOED-MOV-ANT:", wsVariaveis().wsAnt().wsCMoedMovAnt());
        if ((!wsVariaveis().wsAnt().wsZOperacaoAnt().isEmpty() || 
            !wsVariaveis().wsAnt().wsCTipOperAnt().isEmpty() || 
            !wsVariaveis().wsAnt().wsCTipDirMovAnt().isEmpty() || 
            !wsVariaveis().wsAnt().wsCMoedMovAnt().isEmpty()) && 
            !wsVariaveis().wsLidosFwk811Total().isEqual(1)) {
            if (!bghr1702().registo().detalheV112().zOperacaoV112().isEqual(wsVariaveis().wsAnt().wsZOperacaoAnt()) || 
                !bghr1702().registo().detalheV112().cTipOperV112().isEqual(wsVariaveis().wsAnt().wsCTipOperAnt()) || 
                !bghr1702().registo().detalheV112().cTipDirMovV112().isEqual(wsVariaveis().wsAnt().wsCTipDirMovAnt()) || 
                !bghr1702().registo().detalheV112().cPaisDestOperV112().isEqual(wsVariaveis().wsAnt().wsCPaisDestOperAnt()) || 
                !bghr1702().registo().detalheV112().cMoedMovV112().isEqual(wsVariaveis().wsAnt().wsCMoedMovAnt()) || 
                ficheiroFwk811().getStatusOk()) {
                log(TraceLevel.Debug, "BGHR1702-I-TIP-MOV-V112: ", bghr1702().registo().detalheV112().iTipMovV112());
                log(TraceLevel.Debug, "BGHR1702-Z-OPERACAO-V112: ", bghr1702().registo().detalheV112().zOperacaoV112());
                log(TraceLevel.Debug, "BGHR1702-C-TIP-OPER-V112: ", bghr1702().registo().detalheV112().cTipOperV112());
                log(TraceLevel.Debug, "BGHR1702-C-TIP-DIR-MOV-V112: ", bghr1702().registo().detalheV112().cTipDirMovV112());
                log(TraceLevel.Debug, "BGHR1702-Q-VOLUME-REG-V112: ", bghr1702().registo().detalheV112().qVolumeRegV112());
                log(TraceLevel.Debug, "BGHR1702-M-VALOR-V112: ", bghr1702().registo().detalheV112().mValorV112());
                log(TraceLevel.Debug, "BGHR1702-M-VAL-FILLER-V112: ", bghr1702().registo().detalheV112().mValFillerV112());
                log(TraceLevel.Debug, "BGHR1702-C-PAIS-DEST-OPER-V112: ", bghr1702().registo().detalheV112().cPaisDestOperV112());
                log(TraceLevel.Debug, "BGHR1702-C-MOED-MOV-V112: ", bghr1702().registo().detalheV112().cMoedMovV112());
                log(TraceLevel.Debug, "BGHR1702-X-DESCRITIVO-V112: ", bghr1702().registo().detalheV112().xDescritivoV112());
                m2400EscreveOutput() ;
                wsVariaveis().wsAnt().initialize() ;
                wsVariaveis().wsAnt().wsTipMovAnt().set(wsVariaveis().wsBghrAux().wsTipMovAux());
                wsVariaveis().wsAnt().wsZOperacaoAnt().set(wsVariaveis().wsBghrAux().wsZOperacaoAux());
                wsVariaveis().wsAnt().wsQVolumeAnt().set(wsVariaveis().wsBghrAux().wsQVolumeAux());
                wsVariaveis().wsAnt().wsCTipOperAnt().set(wsVariaveis().wsBghrAux().wsCTipOperAux());
                wsVariaveis().wsAnt().wsCTipDirMovAnt().set(wsVariaveis().wsBghrAux().wsCTipDirMovAux());
                wsVariaveis().wsAnt().wsMValorAnt().set(wsVariaveis().wsBghrAux().wsMValorAux());
                wsVariaveis().wsAnt().wsMValFilAnt().set(wsVariaveis().wsBghrAux().wsMValFilAux());
                wsVariaveis().wsAnt().wsCPaisDestOperAnt().set(wsVariaveis().wsBghrAux().wsCPaisDestOperAux());
                wsVariaveis().wsAnt().wsCMoedMovAnt().set(wsVariaveis().wsBghrAux().wsCMoedMovAux());
                wsVariaveis().wsAnt().wsXDescAnt().set(wsVariaveis().wsBghrAux().wsXDescAux());
            } else {
                wsVariaveis().wsAnt().wsMValorAnt().add(bghr1702().registo().detalheV112().mValorV112());
                wsVariaveis().wsAnt().wsQVolumeAnt().add(CON_N1);
            }
        }
    }
    
    /**
     * 
     * 2200-READ-FWK811
     * 
     */
    protected void m2200ReadFwk811() {
        log(TraceLevel.Debug, "2200-READ-FWK811");
        ficheiroFwk811().read(bghr1702().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK811);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk811().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFwk811().getStatusOk()) {
            wsVariaveis().wsLidosFwk811().add(CON_N1);
        } else if (!ficheiroFwk811().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK811);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk811().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2200-READ-FWK811");
            m9900Abend() ;
        }
        wsVariaveis().wsLidosFwk811Total().add(CON_N1);
    }
    
    /**
     * 
     * 2300-FORMATA-HEADER
     * DESC: FORMATACAO DO CABECALHO DO FICHEIRO V112
     * 
     */
    protected void m2300FormataHeader() {
        log(TraceLevel.Debug, "2300-FORMATA-HEADER");
        bghr1702().registo().componentComum().initialize() ;
        bghr1702().registo().header().cVersaoV05().setTrue() ;
        bghr1702().registo().header().cIdFichV112().setTrue() ;
        bghr1702().registo().header().cBanco().get(1, 3).set(CON_C_BANC) ;
        bghr1702().registo().header().cBanco().get(4, 2).set(" ") ;
        wsVariaveis().wsAnoMovBht().set(bhtl250a().commarea().dadosSaida().zProcessamento().get(1, 4));
        wsVariaveis().wsMesMovBht().set(bhtl250a().commarea().dadosSaida().zProcessamento().get(6, 2));
        log(TraceLevel.Debug, "WS-ANO-MOV-BHT:", wsVariaveis().wsAnoMovBht());
        log(TraceLevel.Debug, "WS-MES-MOV-BHT:", wsVariaveis().wsMesMovBht());
        /**
         * SE ESTA A PROCESSAR EM JANEIRO SUBTRAI 1 AO ANO E O MES PASSA 12
         */
        if (wsVariaveis().wsMesMovBht().isEqual(CON_01)) {
            wsVariaveis().wsZAnoMov().set(subtract(wsVariaveis().wsAnoMovBht(), CON_01));
            wsVariaveis().wsZMesMov().set(CON_12);
        } else {
            wsVariaveis().wsZMesMov().set(subtract(wsVariaveis().wsMesMovBht(), CON_01));
            wsVariaveis().wsZAnoMov().set(wsVariaveis().wsAnoMovBht());
        }
        log(TraceLevel.Debug, "WS-Z-MES-MOV:", wsVariaveis().wsZMesMov());
        log(TraceLevel.Debug, "WS-Z-OPERACAO-ANT(5:2):", wsVariaveis().wsAnt().wsZOperacaoAnt().get(5, 2));
        log(TraceLevel.Debug, "WS-Z-ANO-MOV:", wsVariaveis().wsZAnoMov());
        log(TraceLevel.Debug, "WS-Z-OPERACAO-ANT(1:4):", wsVariaveis().wsAnt().wsZOperacaoAnt().get(1, 4));
        if (wsVariaveis().wsAnt().wsZOperacaoAnt().get(5, 2).isZeros()) {
            if ((wsVariaveis().wsAnt().wsZOperacaoAnt().get(5, 2).isLess(wsVariaveis().wsZMesMov()) && 
                wsVariaveis().wsAnt().wsZOperacaoAnt().get(1, 4).isLessOrEqual(wsVariaveis().wsZAnoMov())) || 
                wsVariaveis().wsAnt().wsZOperacaoAnt().get(1, 4).isLess(wsVariaveis().wsZAnoMov())) {
                wsVariaveis().wsZMesMov().set(wsVariaveis().wsAnt().wsZOperacaoAnt().get(5, 2));
                wsVariaveis().wsZAnoMov().set(wsVariaveis().wsAnt().wsZOperacaoAnt().get(1, 4));
            }
        }
        bghr1702().registo().header().zMesMov().set(wsVariaveis().wsZMesMov());
        bghr1702().registo().header().zAnoMov().set(wsVariaveis().wsZAnoMov());
        log(TraceLevel.Debug, "HEADER:");
        log(TraceLevel.Debug, "BGHR1702-C-VERSAO: ", bghr1702().registo().header().cVersao());
        log(TraceLevel.Debug, "BGHR1702-C-ID-FICH: ", bghr1702().registo().header().cIdFich());
        log(TraceLevel.Debug, "BGHR1702-C-BANCO: ", bghr1702().registo().header().cBanco());
        log(TraceLevel.Debug, "BGHR1702-Z-ANO-MOV: ", bghr1702().registo().header().zAnoMov());
        log(TraceLevel.Debug, "BGHR1702-Z-MES-MOV: ", bghr1702().registo().header().zMesMov());
        m2400EscreveOutput() ;
        bghr1702().registo().componentComum().initialize() ;
    }
    
    /**
     * 
     * 2400-ESCREVE-OUTPUT
     * 
     */
    protected void m2400EscreveOutput() {
        log(TraceLevel.Debug, "2400-ESCREVE-OUTPUT");
        wsVariaveis().wsBghrAux().initialize() ;
        log(TraceLevel.Debug, "WS-LIDOS-FWK811-TOTAL:", wsVariaveis().wsLidosFwk811Total());
        if (!wsVariaveis().wsLidosFwk811Total().isEqual(1)) {
            wsVariaveis().wsBghrAux().wsTipMovAux().set(bghr1702().registo().detalheV112().iTipMovV112());
            wsVariaveis().wsBghrAux().wsZOperacaoAux().set(bghr1702().registo().detalheV112().zOperacaoV112());
            wsVariaveis().wsBghrAux().wsCTipOperAux().set(bghr1702().registo().detalheV112().cTipOperV112());
            wsVariaveis().wsBghrAux().wsCTipDirMovAux().set(bghr1702().registo().detalheV112().cTipDirMovV112());
            wsVariaveis().wsBghrAux().wsQVolumeAux().set(bghr1702().registo().detalheV112().qVolumeRegV112());
            wsVariaveis().wsBghrAux().wsMValorAux().set(bghr1702().registo().detalheV112().mValorV112());
            wsVariaveis().wsBghrAux().wsMValFilAux().set(bghr1702().registo().detalheV112().mValFillerV112());
            wsVariaveis().wsBghrAux().wsCPaisDestOperAux().set(bghr1702().registo().detalheV112().cPaisDestOperV112());
            wsVariaveis().wsBghrAux().wsCMoedMovAux().set(bghr1702().registo().detalheV112().cMoedMovV112());
            wsVariaveis().wsBghrAux().wsXDescAux().set(bghr1702().registo().detalheV112().xDescritivoV112());
            bghr1702().registo().detalheV112().iTipMovV112().set(wsVariaveis().wsAnt().wsTipMovAnt());
            bghr1702().registo().detalheV112().zOperacaoV112().set(wsVariaveis().wsAnt().wsZOperacaoAnt());
            bghr1702().registo().detalheV112().cTipOperV112().set(wsVariaveis().wsAnt().wsCTipOperAnt());
            bghr1702().registo().detalheV112().cTipDirMovV112().set(wsVariaveis().wsAnt().wsCTipDirMovAnt());
            bghr1702().registo().detalheV112().qVolumeRegV112().set(wsVariaveis().wsAnt().wsQVolumeAnt());
            bghr1702().registo().detalheV112().mValorV112().set(wsVariaveis().wsAnt().wsMValorAnt());
            bghr1702().registo().detalheV112().mValFillerV112().set(wsVariaveis().wsAnt().wsMValFilAnt());
            bghr1702().registo().detalheV112().cPaisDestOperV112().set(wsVariaveis().wsAnt().wsCPaisDestOperAnt());
            bghr1702().registo().detalheV112().cMoedMovV112().set(wsVariaveis().wsAnt().wsCMoedMovAnt());
            bghr1702().registo().detalheV112().xDescritivoV112().set(wsVariaveis().wsAnt().wsXDescAnt());
            ficheiroFgh179().write(ficheiroFgh179().regFgh179400) ;
        } else {
            ficheiroFgh179().write(ficheiroFgh179().regFgh179400) ;
        }
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH179);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh179().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh179().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH179);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh179().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-WRITE-FICH-PRD");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFgh179().add(1);
        }
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "3000-FINAL-PROGRAMA");
        m3100FecharFicheiros() ;
        m3200EscreveEstat() ;
    }
    
    /**
     * 
     * 3100-FECHAR-FICHEIROS
     * 
     */
    protected void m3100FecharFicheiros() {
        log(TraceLevel.Debug, " --3100-FECHAR-FICHEIROS");
        m3110CloseFwk811() ;
        m3120CloseFgh179() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FWK811
     * 
     */
    protected void m3110CloseFwk811() {
        log(TraceLevel.Debug, "3110-CLOSE-FWK811");
        ficheiroFwk811().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK811);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk811().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk811().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK811);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk811().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FWK811");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3120-CLOSE-FGH179
     * 
     */
    protected void m3120CloseFgh179() {
        log(TraceLevel.Debug, "3120-CLOSE-FGH179");
        ficheiroFgh179().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH179);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh179().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh179().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH179);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh179().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FGH179");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3200-ESCREVE-ESTAT
     * 
     */
    protected void m3200EscreveEstat() {
        log(TraceLevel.Debug, "3200-ESCREVE-ESTAT");
        bhop0013FimEstatistica() ;
        log(TraceLevel.Trace, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Trace, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFwk811().close() ;
        ficheiroFgh179().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
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
    
    /**
     * 
     * STATUS
     * 
     * @version 2.0
     * 
     */
    public interface SwStatus extends IDataStruct {
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition fhy003Ok() ;
        @Data
        @Condition("10")
        ICondition fhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk811() ;
        @Data
        @Condition("00")
        ICondition swFwk811Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk811Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh179() ;
        @Data
        @Condition("00")
        ICondition swFgh179Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh179Eof() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=15, value="0")
        ILong wsLidosFwk811() ;
        
        @Data(size=15, value="0")
        ILong wsLidosFwk811Total() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFgh179() ;
        
        @Data(size=2, value="0")
        IInt wsZMesMov() ;
        
        @Data(size=4, value="0")
        IInt wsZAnoMov() ;
        
        @Data(size=4, value="0")
        IInt wsAnoMovBht() ;
        
        @Data(size=2, value="0")
        IInt wsMesMovBht() ;
        
        /**
         * @return instancia da classe local WsXCteuMhtq250a
         */
        @Data
        WsXCteuMhtq250a wsXCteuMhtq250a() ;
        
        /**
         * 05 WS-DADOS-SYSIN.
         * 10 WS-DEBUG                 PIC X(01) VALUE SPACES.
         * 88 SW-DEBUG-SIM           VALUE 'S'.
         * 88 SW-DEBUG-NOT           VALUE 'N'.
         * 10 WS-C-VERSAO              PIC x(03) VALUE SPACES.
         * @return instancia da classe local WsAnt
         */
        @Data
        WsAnt wsAnt() ;
        
        /**
         * @return instancia da classe local WsBghrAux
         */
        @Data
        WsBghrAux wsBghrAux() ;
        
        
        public interface WsXCteuMhtq250a extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString wsCPaisIsoMhyq250a() ;
            
            @Data(size=8, value=" ", lpadding=3, rpadding=79, lpaddingValue=" / ", rpaddingValue=" / ")
            IString wsAAplSgccMhyq250a() ;
            
        }
        
        
        /**
         * 
         * 05 WS-DADOS-SYSIN.
         * 10 WS-DEBUG                 PIC X(01) VALUE SPACES.
         * 88 SW-DEBUG-SIM           VALUE 'S'.
         * 88 SW-DEBUG-NOT           VALUE 'N'.
         * 10 WS-C-VERSAO              PIC x(03) VALUE SPACES.
         * 
         * @version 2.0
         * 
         */
        public interface WsAnt extends IDataStruct {
            
            @Data(size=1, value=" ")
            IString wsTipMovAnt() ;
            
            @Data(size=8, value=" ")
            IString wsZOperacaoAnt() ;
            
            @Data(size=15, value="0")
            ILong wsQVolumeAnt() ;
            
            @Data(size=3, value=" ")
            IString wsCTipOperAnt() ;
            
            @Data(size=3, value=" ")
            IString wsCTipDirMovAnt() ;
            
            @Data(size=15, value="0")
            ILong wsMValorAnt() ;
            
            @Data(size=2, value="0")
            IInt wsMValFilAnt() ;
            
            @Data(size=2, value=" ")
            IString wsCPaisDestOperAnt() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedMovAnt() ;
            
            @Data(size=255, value=" ")
            IString wsXDescAnt() ;
            
        }
        
        public interface WsBghrAux extends IDataStruct {
            
            @Data(size=1, value=" ")
            IString wsTipMovAux() ;
            
            @Data(size=8, value=" ")
            IString wsZOperacaoAux() ;
            
            @Data(size=15, value="0")
            ILong wsQVolumeAux() ;
            
            @Data(size=3, value=" ")
            IString wsCTipOperAux() ;
            
            @Data(size=3, value=" ")
            IString wsCTipDirMovAux() ;
            
            @Data(size=15, value="0")
            ILong wsMValorAux() ;
            
            @Data(size=2, value="0")
            IInt wsMValFilAux() ;
            
            @Data(size=2, value=" ")
            IString wsCPaisDestOperAux() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedMovAux() ;
            
            @Data(size=255, value=" ")
            IString wsXDescAux() ;
            
        }
    }
    
}
