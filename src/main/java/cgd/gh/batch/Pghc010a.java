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
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.gh.structures.work.Bghr2511 ;
import cgd.gh.structures.work.Bghr2521 ;
import cgd.gh.structures.work.Bghw8812 ;
import cgd.hj.structures.link.Bhjl939a ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hj.common.constants.Bhjk0001 ;
import cgd.ht.routines.Mhtq250a ;
import cgd.hj.routines.Mhjj939a ;
import cgd.hy.routines.Mhyj230a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE INPUT - FGH251
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE INPUT - FGH252
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE OUTPUT - FWK812
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc010a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fhy003
     */
    @Handler(name="FHY003")
    @Data
    protected abstract Fhy003 ficheiroFhy003() ;
    
    /**
     * @return instancia da classe Fgh251
     */
    @Handler(name="FGH251", record="statusFgh251")
    @Data
    protected abstract Fgh251 ficheiroFgh251() ;
    
    /**
     * @return instancia da classe Fgh252
     */
    @Handler(name="FGH252", record="statusFgh252")
    @Data
    protected abstract Fgh252 ficheiroFgh252() ;
    
    /**
     * @return instancia da classe Fwk812
     */
    @Handler(name="FWK812", record="regFwk812104")
    @Data
    protected abstract Fwk812 ficheiroFwk812() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mhjj939a
     */
    @Data
    protected abstract Mhjj939a hrMhjj939a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bghr2511
     */
    @Data
    protected abstract Bghr2511 bghr2511() ;
    
    /**
     * @return instancia da classe Bghr2521
     */
    @Data
    protected abstract Bghr2521 bghr2521() ;
    
    /**
     * @return instancia da classe Bghw8812
     */
    @Data
    protected abstract Bghw8812 bghw8812() ;
    
    /**
     * @return instancia da classe Bhjl939a
     */
    @Data
    protected abstract Bhjl939a bhjl939a() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhjk0001
     */
    @Data
    protected abstract Bhjk0001 bhjk0001() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHC010A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FGH251 = "FGH251" ;
    
    protected static final String CON_FGH252 = "FGH252" ;
    
    protected static final String CON_FWK812 = "FWK812" ;
    
    protected static final String CON_C_TIPO_TRTT_CONT = "01" ;
    
    protected static final String CON_CALC_PROC = "34" ;
    
    protected static final String CON_MHYJ230A = "MHYJ230A" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHC010A" ;
    
    protected static final String CON_DTA_MIN = "0001-01-01" ;
    
    protected static final String CON_PROGRAM_DESC = "RECOLHA DE INF. PARA CLIENTES DE CADA CONTA" ;
    
    protected static final String CON_30 = "30" ;
    
    protected static final int CON_1 = 1 ;
    
    protected static final int CON_MAX_OCCURS = 75 ;
    
    protected static final int CON_NUM_DIAS = 30 ;
    
    protected static final int CON_632 = 632 ;
    
    protected static final String CON_PT = "PT" ;
    
    protected static final String CON_CGD = "CGD" ;
    
    /**
     * PASSIVAS 3419 - INI
     */
    protected static final String CON_DTA_2013 = "2013-01-01" ;
    
    /**
     * PASSIVAS 3419 - FIM
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
        hrMhtq250a().run() ;
    }
    
    /**
     * 
     * BHJP5939-ACESSO AO MODULO QUE DEVOLVE AS RELACOES
     * ACTIVAS DE UMA CONTA (MHJJ939A)
     * 
     */
    protected void bhjp5939AcedeMhjj939a() {
        hrMhjj939a().run() ;
    }
    
    /**
     * 
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
        hrMhyj230a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "*********** - INICIO - *************");
        log(TraceLevel.Debug, CON_NOME_PROGRAMA);
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (ficheiroFgh251().getStatusOk() && ficheiroFgh252().getStatusOk()) {
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
        m1100InicializaVariaveis() ;
        m1200TrataEstatIni() ;
        m1300ObterDadosBatch() ;
        m1400ObterDatas() ;
        m1500AbreFicheiros() ;
        m1600LeFgh251() ;
        m1700LeFgh252() ;
        m1800ObtemDataAnt() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VARIAVEIS
     * 
     */
    protected void m1100InicializaVariaveis() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VARIAVEIS");
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
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl250a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-ABRE-FICHEIROS
     * 
     */
    protected void m1500AbreFicheiros() {
        log(TraceLevel.Debug, "1500-ABRE-FICHEIROS");
        m1510AbreFgh251() ;
        m1520AbreFgh252() ;
        m1530AbreFwk812() ;
    }
    
    /**
     * 
     * 1510-ABRE-FGH251
     * 
     */
    protected void m1510AbreFgh251() {
        log(TraceLevel.Debug, "1510-ABRE-FGH251");
        /**
         * *ABRE FICHEIRO DE INPUT - FGH251
         */
        ficheiroFgh251().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH251);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh251().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh251().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH251);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh251().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-ABRE-FGH251");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1520-ABRE-FGH252
     * 
     */
    protected void m1520AbreFgh252() {
        log(TraceLevel.Debug, "1520-ABRE-FGH252");
        /**
         * *ABRE FICHEIRO DE INPUT - FGH252
         */
        ficheiroFgh252().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH252);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh252().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh252().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH252);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh252().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-ABRE-FGH252");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1530-ABRE-FWK812
     * 
     */
    protected void m1530AbreFwk812() {
        log(TraceLevel.Debug, "1530-ABRE-FWK812");
        /**
         * *ABRE FICHEIRO DE OUTPUT - FWK812
         */
        ficheiroFwk812().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK812);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk812().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk812().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK812);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk812().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1530-ABRE-FWK812");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-LE-FGH251
     * 
     */
    protected void m1600LeFgh251() {
        log(TraceLevel.Debug, "1600-LE-FGH251");
        bghr2511().registo().initialize() ;
        ficheiroFgh251().read(bghr2511().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH251);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh251().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh251().getStatusOk() && !ficheiroFgh251().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH251);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh251().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-LE-FGH251");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1700-LE-FGH252
     * 
     */
    protected void m1700LeFgh252() {
        log(TraceLevel.Debug, "1700-LE-FGH252");
        bghr2521().registo().initialize() ;
        ficheiroFgh252().read(bghr2521().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH252);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh252().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh252().getStatusOk() && !ficheiroFgh252().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH252);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh252().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1700-LE-FGH252");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1800-OBTEM-DATA-ANT
     * 
     */
    protected void m1800ObtemDataAnt() {
        log(TraceLevel.Debug, "1800-OBTEM-DATA-ANT");
        bhyl230a().commarea().initialize() ;
        bhyl230a().commarea().dadosEntrada().reduzido().setTrue() ;
        bhyl230a().commarea().dadosEntrada().datInput1().set(bhtl250a().commarea().dadosSaida().zProcessamento());
        bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(CON_CALC_PROC);
        bhyl230a().commarea().dadosEntrada().duPrazDia().set(CON_NUM_DIAS);
        bhyp0200RotinaDatas() ;
        if (!bhyl230a().commarea().dadosSaida().estado().semErros().isTrue()) {
            log(TraceLevel.Error, "******************************");
            log(TraceLevel.Error, "* ERRO NA ROTINA MHYJ230A    *");
            log(TraceLevel.Error, "******************************");
            log(TraceLevel.Error, "DADOS DE INPUT:");
            log(TraceLevel.Error, "******************************");
            log(TraceLevel.Error, "DAT-INPUT1      :", bhyl230a().commarea().dadosEntrada().datInput1());
            log(TraceLevel.Error, "C-FUNZ-MDLO-DATA:", bhyl230a().commarea().dadosEntrada().cFunzMdloData());
            log(TraceLevel.Error, "******************************");
            log(TraceLevel.Error, "ERRO.......:", bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
            log(TraceLevel.Error, "APLICACAO..:", bhyl230a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "******************************");
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MHYJ230A);
            bhtw0030().dadosEntrada().cTipoErroBbn().set(bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
            bhtw0030().dadosEntrada().nmTabela().set(bhyl230a().commarea().dadosSaida().estado().nmTabela());
            bhtw0030().dadosEntrada().cSqlcode().set(bhyl230a().commarea().dadosSaida().estado().cSqlcode());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhyl230a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1800-OBTEM-DATA-ANT");
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        log(TraceLevel.Debug, "FGH251-CONTA: ", bghr2511().registo().conta().cPaisIsoaCont(), "/", bghr2511().registo().conta().cBancCont(), "/", bghr2511().registo().conta().cOeEgcCont(), "/", bghr2511().registo().conta().nsRdclCont(), "/", bghr2511().registo().conta().vChkdCont(), "/", bghr2511().registo().conta().cTipoCont());
        log(TraceLevel.Debug, "FGH252-CONTA: ", bghr2521().registo().subconta().conta().cPaisIsoaCont(), "/", bghr2521().registo().subconta().conta().cBancCont(), "/", bghr2521().registo().subconta().conta().cOeEgcCont(), "/", bghr2521().registo().subconta().conta().nsRdclCont(), "/", bghr2521().registo().subconta().conta().vChkdCont(), "/", bghr2521().registo().subconta().conta().cTipoCont());
        log(TraceLevel.Debug, "DTA 30 DIAS ATRAS: ", bhyl230a().commarea().dadosSaida().zOutput());
        log(TraceLevel.Debug, "DTA PROCESSAMENTO: ", bhtl250a().commarea().dadosSaida().zProcessamento());
        log(TraceLevel.Debug, "DTA RABT CONTA: ", bghr2521().registo().zRabtScta());
        log(TraceLevel.Debug, "DTA ABRA CONTA: ", bghr2521().registo().zAbraScta());
        log(TraceLevel.Debug, "BGHR2511-C-TIPO-TRTT-CONT : ", bghr2511().registo().cTipoTrttCont());
        if (bghr2521().registo().subconta().conta().isEqual(bghr2511().registo().conta())) {
            if (bghr2511().registo().conta().cPaisIsoaCont().isEqual(CON_PT) && 
                bghr2511().registo().cMnemEmpGcx().isEqual(CON_CGD)) {
                if (bghr2511().registo().cTipoTrttCont().isEqual(CON_C_TIPO_TRTT_CONT) && 
                    !bghr2511().registo().iEstCont().isEqual(CON_30)) {
                    /**
                     * IF BGHR2521-Z-RABT-SCTA > BGHR2511-Z-CCLT-CONT
                     */
                    if (bghr2521().registo().zRabtScta().isGreater(bghr2521().registo().zAbraScta()) && 
                        bghr2521().registo().zRabtScta().isGreaterOrEqual(CON_DTA_2013)) {
                        /**
                         * PASSIVAS 3419 - FIM
                         * AND BHYL230A-Z-OUTPUT > BGHR2521-Z-RABT-SCTA
                         */
                        if (bhyl230a().commarea().dadosSaida().zOutput().isGreater(bghr2521().registo().zRabtScta())) {
                            /**
                             * IF SW-DEBUG-SIM
                             * DISPLAY
                             * 'BHYL230A-Z-OUTPUT MENOR QUE BGHR2521-Z-RABT-SCTA'
                             * END-IF
                             */
                            m2100AcedeMhjj939a() ;
                            wsVariaveis().wsIndice().set(CON_1);
                            while (wsVariaveis().wsIndice().isLessOrEqual(CON_MAX_OCCURS) && !bhjl939a().commarea().dadosSaida().get(wsVariaveis().wsIndice()).nCliente().isEqual(0)) {
                                m2300EscreveFwk812() ;
                            }
                        }
                    } else if (bghr2521().registo().zRabtScta().isLess(bghr2521().registo().zAbraScta()) && 
                        bghr2521().registo().zAbraScta().isGreaterOrEqual(CON_DTA_2013)) {
                        /**
                         * IF BHYL230A-Z-OUTPUT > BGHR2511-Z-ABRA-CONT
                         */
                        if (bhyl230a().commarea().dadosSaida().zOutput().isGreater(bghr2521().registo().zAbraScta())) {
                            /**
                             * PASSIVAS 3419 - FIM
                             * IF SW-DEBUG-SIM
                             * DISPLAY
                             * 'BHYL230A-Z-OUTPUT MAIOR QUE BGHR2511-Z-ABRA-CONT'
                             * END-IF
                             */
                            m2100AcedeMhjj939a() ;
                            /**
                             * PASSIVAS 3419 - INI
                             * IF SW-DEBUG-SIM
                             * DISPLAY 'BHJL939A-C-TIPO-ERRO-BBN '
                             * BHJL939A-C-TIPO-ERRO-BBN
                             * END-IF
                             * PASSIVAS 3419 - FIM
                             */
                            wsVariaveis().wsIndice().set(CON_1);
                            /**
                             * PASSIVAS 3419 - INI
                             * DISPLAY 'WS-INDICE ' WS-INDICE
                             * PASSIVAS 3419 - FIM
                             */
                            while (wsVariaveis().wsIndice().isLessOrEqual(CON_MAX_OCCURS) && !bhjl939a().commarea().dadosSaida().get(wsVariaveis().wsIndice()).nCliente().isEqual(0)) {
                                m2300EscreveFwk812() ;
                            }
                        }
                    }
                }
            }
            m1600LeFgh251() ;
        } else if (bghr2521().registo().subconta().conta().isGreater(bghr2511().registo().conta())) {
            /**
             * PASSIVAS 3419 - INI
             * IF SW-DEBUG-SIM
             * DISPLAY 'BGHR2521-CONTA MAIOR QUE BGHR2511-CONTA'
             * END-IF
             * PASSIVAS 3419 - FIM
             */
            m1600LeFgh251() ;
        } else if (bghr2511().registo().conta().isGreater(bghr2521().registo().subconta().conta())) {
            /**
             * PASSIVAS 3419 - INI
             * IF SW-DEBUG-SIM
             * DISPLAY 'BGHR2511-CONTA MAIOR QUE BGHR2521-CONTA'
             * END-IF
             * PASSIVAS 3419 - FIM
             */
            m1700LeFgh252() ;
        }
    }
    
    /**
     * 
     * 2100-ACEDE-MHJJ939A
     * 
     */
    protected void m2100AcedeMhjj939a() {
        log(TraceLevel.Debug, "2100-ACEDE-MHJJ939A");
        bhjl939a().commarea().initialize() ;
        bhjl939a().commarea().dadosEntrada().cPaisIsoaCont().set(bghr2511().registo().conta().cPaisIsoaCont());
        bhjl939a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bghr2511().registo().conta().cPaisIsoaCont());
        bhjl939a().commarea().dadosEntrada().cMnemEgcOpex().set(bghr2511().registo().cMnemEmpGcx());
        bhjl939a().commarea().dadosEntrada().cBancCont().set(bghr2511().registo().conta().cBancCont());
        bhjl939a().commarea().dadosEntrada().cOeEgcCont().set(bghr2511().registo().conta().cOeEgcCont());
        bhjl939a().commarea().dadosEntrada().nsRdclCont().set(bghr2511().registo().conta().nsRdclCont());
        bhjl939a().commarea().dadosEntrada().vChkdCont().set(bghr2511().registo().conta().vChkdCont());
        bhjl939a().commarea().dadosEntrada().cTipoCont().set(bghr2511().registo().conta().cTipoCont());
        log(TraceLevel.Debug, "BHJL939A-C-PAIS-ISOA-CONT.  ", bhjl939a().commarea().dadosEntrada().cPaisIsoaCont());
        log(TraceLevel.Debug, "BHJL939A-C-PAIS-ISOA-OE-OPX.", bhjl939a().commarea().dadosEntrada().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "BHJL939A-C-MNEM-EGC-OPEX.   ", bhjl939a().commarea().dadosEntrada().cMnemEgcOpex());
        log(TraceLevel.Debug, "BHJL939A-C-BANC-CONT.       ", bhjl939a().commarea().dadosEntrada().cBancCont());
        log(TraceLevel.Debug, "BHJL939A-C-OE-EGC-CONT.     ", bhjl939a().commarea().dadosEntrada().cOeEgcCont());
        log(TraceLevel.Debug, "BHJL939A-NS-RDCL-CONT.      ", bhjl939a().commarea().dadosEntrada().nsRdclCont());
        log(TraceLevel.Debug, "BHJL939A-V-CHKD-CONT.       ", bhjl939a().commarea().dadosEntrada().vChkdCont());
        log(TraceLevel.Debug, "BHJL939A-C-TIPO-CONT        ", bhjl939a().commarea().dadosEntrada().cTipoCont());
        bhjp5939AcedeMhjj939a() ;
        log(TraceLevel.Debug, "BHJL939A-C-TIPO-ERRO-BBN ", bhjl939a().commarea().erros().cTipoErroBbn());
        log(TraceLevel.Debug, "BHJL939A-C-RTNO-EVEN-SWAL:", bhjl939a().commarea().erros().cRtnoEvenSwal());
        if (!bhjl939a().commarea().erros().semErros().isTrue() && !bhjl939a().commarea().erros().fimConsulta().isTrue() && 
            !bhjl939a().commarea().erros().cRtnoEvenSwal().isEqual(bhjk0001().erros().naoExitReg())) {
            bhtw0030().dadosEntrada().cTipoErroBbn().set(bhjl939a().commarea().erros().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhjl939a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhjl939a().nomeRotina());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhjl939a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhjl939a().commarea().erros().nmTabela());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhjl939a().commarea().erros().msgErrob());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-ESCREVE-FWK812
     * 
     */
    protected void m2300EscreveFwk812() {
        log(TraceLevel.Debug, "2300-ESCREVE-FWK812");
        bghw8812().registo().initialize() ;
        bghw8812().registo().cPaisIsoaGerx().set(bghr2511().registo().cPaisIsoaGerx());
        bghw8812().registo().cBancGcxGerx().set(bghr2511().registo().cBancGcxGerx());
        bghw8812().registo().conta().set(bghr2511().registo().conta());
        bghw8812().registo().cOeEgcGerx().set(bghr2511().registo().cOeEgcGerx());
        bghw8812().registo().mSldoCblo().set(bghr2521().registo().mSldoCblo());
        bghw8812().registo().iEstCont().set(bghr2511().registo().iEstCont());
        bghw8812().registo().iExisRstzCont().set(bghr2511().registo().iExisRstzCont());
        bghw8812().registo().nCliente().set(bhjl939a().commarea().dadosSaida().get(wsVariaveis().wsIndice()).nCliente());
        bghw8812().registo().nsAbraCli().set(bhjl939a().commarea().dadosSaida().get(wsVariaveis().wsIndice()).nsAbraCli());
        bghw8812().registo().iTipoItvt().set(bhjl939a().commarea().dadosSaida().get(wsVariaveis().wsIndice()).iTipoItvt());
        bghw8812().registo().nsTitc().set(bhjl939a().commarea().dadosSaida().get(wsVariaveis().wsIndice()).nsTitc());
        bghw8812().registo().zInicRel().set(bhjl939a().commarea().dadosSaida().get(wsVariaveis().wsIndice()).zInicRel());
        ficheiroFwk812().write(ficheiroFwk812().regFwk812104) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK812);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk812().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk812().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK812);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk812().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2300-ESCREVE-FWK812");
            m9900Abend() ;
        }
        wsVariaveis().wsIndice().add(CON_1);
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
        m3110FechaFgh251() ;
        m3120FechaFgh252() ;
        m3130FechaFwk812() ;
    }
    
    /**
     * 
     * 3110-FECHA-FGH251
     * 
     */
    protected void m3110FechaFgh251() {
        log(TraceLevel.Debug, "3110-FECHA-FGH251");
        ficheiroFgh251().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH251);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh251().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh251().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH251);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh251().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-FECHA-FGH251");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3120-FECHA-FGH252
     * 
     */
    protected void m3120FechaFgh252() {
        log(TraceLevel.Debug, "3120-FECHA-FGH252");
        ficheiroFgh252().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH252);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh252().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh252().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH252);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh252().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-FECHA-FGH252");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3130-FECHA-FWK812
     * 
     */
    protected void m3130FechaFwk812() {
        log(TraceLevel.Debug, "3130-FECHA-FWK812");
        ficheiroFwk812().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK812);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk812().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk812().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK812);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk812().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3130-FECHA-FWK812");
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
        log(TraceLevel.Trace, CON_NOME_PROGRAMA);
        log(TraceLevel.Trace, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
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
        IString statusFgh251() ;
        @Data
        @Condition("00")
        ICondition swFgh251Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh251Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh252() ;
        @Data
        @Condition("00")
        ICondition swFgh252Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh252Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk812() ;
        @Data
        @Condition("00")
        ICondition swFwk812Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk812Eof() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=2, value="0")
        IInt wsIndice() ;
        
    }
    
}
