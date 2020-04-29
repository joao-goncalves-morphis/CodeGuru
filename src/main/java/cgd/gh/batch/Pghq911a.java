package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
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
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * WORKING STORAGE SECTION
 * P R O C E D U R E             D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq911a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02301Movhist3
     */
    @Data
    protected abstract Vwsdghps02301Movhist3 hv02301Movhist3() ;
    
    /**
     * @return instancia da classe Vwsdghps02801Movhist8
     */
    @Data
    protected abstract Vwsdghps02801Movhist8 hv02801Movhist8() ;
    
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    /**
     * @return instancia da classe Vwsdghps02601Movhist6
     */
    @Data
    protected abstract Vwsdghps02601Movhist6 hv02601Movhist6() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk112
     */
    @Handler(name="FWK112", record="statusFwk112")
    @Data
    protected abstract Fwk112 ficheiroFwk112() ;
    
    /**
     * @return instancia da classe Fwk911
     */
    @Handler(name="FWK911", record="regFwk91173")
    @Data
    protected abstract Fwk911 ficheiroFwk911() ;
    
    
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
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHQ911A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK112 = "FWK112" ;
    
    protected static final String CON_FWK911 = "FWK911" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ911A" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_Z_FIM = "2014-01-01-00.00.00.000000" ;
    
    protected static final String CON_PROGRAM_DESC = "MOVIMENTOS DE CREDITO DE VENCIMENTO" ;
    
    protected static final String CON_CREDITO = "C" ;
    
    protected static final int CON_2007 = 2007 ;
    
    protected static final int CON_2008 = 2008 ;
    
    protected static final int CON_2009 = 2009 ;
    
    protected static final int CON_2010 = 2010 ;
    
    protected static final int CON_2011 = 2011 ;
    
    /**
     * VARIAVEIS AUXILIARES
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * @return instancia da classe local Fwk112Registo
     */
    @Data
    protected abstract Fwk112Registo fwk112Registo() ;
    
    /**
     * @return instancia da classe local Fwk911Registo
     */
    @Data
    protected abstract Fwk911Registo fwk911Registo() ;
    
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
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
        while (!ficheiroFwk112().getStatusOk()) {
            m2000ProcPrograma() ;
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
        m1100InicializaVar() ;
        m1200TrataEstatIni() ;
        m1300ObterDadosBatch() ;
        m1400ObtemDataApl() ;
        m1500OpenFicheiros() ;
        m1600ReadFwk112() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        fwk911Registo().initialize() ;
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
     * 1400-OBTEM-DATA-APL
     * 
     */
    protected void m1400ObtemDataApl() {
        log(TraceLevel.Debug, "1400-OBTEM-DATA-APL");
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl250a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO PARAGRAFO 1400-OBTEM-DATA-APL");
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-TRATA-FICHEIROS
     * 
     */
    protected void m1500OpenFicheiros() {
        log(TraceLevel.Debug, "1500-OPEN-FICHEIROS");
        ficheiroFwk112().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK112);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk112().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk112().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK112);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk112().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-OPEN-FICHEIROS");
            m9900Abend() ;
        }
        ficheiroFwk911().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK911);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk911().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk911().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK911);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk911().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-OPEN-FICHEIROS");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FWK112
     * 
     */
    protected void m1600ReadFwk112() {
        log(TraceLevel.Debug, "1600-READ-FWK112");
        fwk112Registo().initialize() ;
        ficheiroFwk112().read(fwk112Registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK112);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk112().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk112().getStatusOk() && !ficheiroFwk112().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK112);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk112().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-READ-FWK112");
            m9900Abend() ;
        } else if (ficheiroFwk112().getStatusOk()) {
            wsVariaveis().wsRead().add(1);
            if (wsVariaveis().wsRead().isGreaterOrEqual(10000)) {
                log(TraceLevel.Error, " REGISTOS LIDOS : ", wsVariaveis().wsRead());
                wsVariaveis().wsRead().set(0);
            }
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        log(TraceLevel.Debug, "FWK112-REGISTO    ", fwk112Registo());
        if (fwk112Registo().fwk112ZMovimento().get(1, 4).isEqual(Pghq911a.CON_2007)) {
            /**
             * ano 2007
             */
            m2100AcedeTgh023() ;
            /**
             * ano 2008
             */
            m2200AcedeTgh028() ;
            /**
             * ano 2009
             */
            m2300AcedeTgh027() ;
            /**
             * ano 2010
             */
            m2400AcedeTgh026() ;
            /**
             * ano 2011-2014
             */
            m2500AcedeTgh002() ;
        } else if (fwk112Registo().fwk112ZMovimento().get(1, 4).isEqual(Pghq911a.CON_2008)) {
            /**
             * ano 2008
             */
            m2200AcedeTgh028() ;
            /**
             * ano 2009
             */
            m2300AcedeTgh027() ;
            /**
             * ano 2010
             */
            m2400AcedeTgh026() ;
            /**
             * ano 2011-2014
             */
            m2500AcedeTgh002() ;
        } else if (fwk112Registo().fwk112ZMovimento().get(1, 4).isEqual(Pghq911a.CON_2009)) {
            /**
             * ano 2009
             */
            m2300AcedeTgh027() ;
            /**
             * ano 2010
             */
            m2400AcedeTgh026() ;
            /**
             * ano 2011-2014
             */
            m2500AcedeTgh002() ;
        } else if (fwk112Registo().fwk112ZMovimento().get(1, 4).isEqual(Pghq911a.CON_2010)) {
            /**
             * ano 2010
             */
            m2400AcedeTgh026() ;
            /**
             * ano 2011-2014
             */
            m2500AcedeTgh002() ;
        } else if (fwk112Registo().fwk112ZMovimento().get(1, 4).isGreaterOrEqual(CON_2011)) {
            /**
             * ano 2011-2014
             */
            m2500AcedeTgh002() ;
        }
        m1600ReadFwk112() ;
    }
    
    /**
     * 
     * 2100-ACEDE-TGH023
     * 
     */
    protected void m2100AcedeTgh023() {
        log(TraceLevel.Debug, "2100-ACEDE-TGH023");
        m2110AbreCrsTgh23() ;
        m2120FetchCrsTgh23() ;
        while (swSwitches().swVgh02301Ok().isTrue()) {
            m2130TrataCrsTgh23() ;
        }
        m2140FechaCrsTgh23() ;
    }
    
    /**
     * 
     * 2110-ABRE-CRS-TGH23
     * 
     */
    protected void m2110AbreCrsTgh23() {
        log(TraceLevel.Debug, "2110-ABRE-CRS-TGH23");
        hv02301Movhist3().movhist3().initialize() ;
        hv02301Movhist3().movhist3().cPaisIsoaCont().set(fwk112Registo().fwk112CPaisIsoaCont());
        hv02301Movhist3().movhist3().cBancCont().set(fwk112Registo().fwk112CBancCont());
        hv02301Movhist3().movhist3().cOeEgcCont().set(fwk112Registo().fwk112COeEgcCont());
        hv02301Movhist3().movhist3().nsRdclCont().set(fwk112Registo().fwk112NsRdclCont());
        hv02301Movhist3().movhist3().vChkdCont().set(fwk112Registo().fwk112VChkdCont());
        hv02301Movhist3().movhist3().cTipoCont().set(fwk112Registo().fwk112CTipoCont());
        hv02301Movhist3().movhist3().cMoedIsoScta().set(fwk112Registo().fwk112CMoedIsoScta());
        hv02301Movhist3().movhist3().nsDeposito().set(fwk112Registo().fwk112NsDeposito());
        hv02301Movhist3().movhist3().tsMovimento().get(1, 10).set(fwk112Registo().fwk112ZMovimento()) ;
        hv02301Movhist3().movhist3().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_TGH23
         */
        hv02301Movhist3().openPghq911a771(CON_Z_FIM, CON_CREDITO) ;
        swSwitches().swSqlcodeVgh02301().set(hv02301Movhist3().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02301");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02301Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2110-ABRE-CRS-TGH23");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02301");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02301Movhist3().movhist3());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2120-FETCH-CRS-TGH23
     * 
     */
    protected void m2120FetchCrsTgh23() {
        log(TraceLevel.Debug, "2120-FETCH-CRS-TGH23");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_TGH23
         */
        hv02301Movhist3().fetchPghq911a809(wsVariaveis().wsCPaisIsoaCont(), wsVariaveis().wsCBancCont(), wsVariaveis().wsCOeEgcCont(), wsVariaveis().wsNsRdclCont(), wsVariaveis().wsVChkdCont(), wsVariaveis().wsCTipoCont(), wsVariaveis().wsCMoedIsoScta(), wsVariaveis().wsNsDeposito(), wsVariaveis().wsTsMovimento(), wsVariaveis().wsZValMov(), wsVariaveis().wsMMovimento()) ;
        swSwitches().swSqlcodeVgh02301().set(hv02301Movhist3().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02301");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02301Ok().isTrue() && !swSwitches().swVgh02301Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2120-FETCH-CRS-TGH23");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02301");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02301Movhist3().movhist3());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (swSwitches().swVgh02301Ok().isTrue()) {
            wsVariaveis().wsZMovimento().set(wsVariaveis().wsTsMovimento().get(1, 10));
        }
    }
    
    /**
     * 
     * 2130-TRATA-CRS-TGH23
     * 
     */
    protected void m2130TrataCrsTgh23() {
        log(TraceLevel.Debug, "2130-TRATA-CRS-TGH23");
        m8000EscreveOutput() ;
        m2120FetchCrsTgh23() ;
    }
    
    /**
     * 
     * 2140-FECHA-CRS-TGH23
     * 
     */
    protected void m2140FechaCrsTgh23() {
        log(TraceLevel.Debug, "2140-FECHA-CRS-TGH23");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_TGH23
         */
        hv02301Movhist3().closePghq911a880() ;
        swSwitches().swSqlcodeVgh02301().set(hv02301Movhist3().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02301");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02301Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2140-FECHA-CRS-TGH23");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02301Movhist3().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02301");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02301Movhist3().movhist3());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2200-ACEDE-TGH028
     * 
     */
    protected void m2200AcedeTgh028() {
        log(TraceLevel.Debug, "2200-ACEDE-TGH028");
        m2210AbreCrsTgh28() ;
        m2220FetchCrsTgh28() ;
        while (swSwitches().swVgh02801Ok().isTrue()) {
            m2230TrataCrsTgh28() ;
        }
        m2240FechaCrsTgh28() ;
    }
    
    /**
     * 
     * 2210-ABRE-CRS-TGH28
     * 
     */
    protected void m2210AbreCrsTgh28() {
        log(TraceLevel.Debug, "2210-ABRE-CRS-TGH28");
        hv02801Movhist8().movhist8().initialize() ;
        hv02801Movhist8().movhist8().cPaisIsoaCont().set(fwk112Registo().fwk112CPaisIsoaCont());
        hv02801Movhist8().movhist8().cBancCont().set(fwk112Registo().fwk112CBancCont());
        hv02801Movhist8().movhist8().cOeEgcCont().set(fwk112Registo().fwk112COeEgcCont());
        hv02801Movhist8().movhist8().nsRdclCont().set(fwk112Registo().fwk112NsRdclCont());
        hv02801Movhist8().movhist8().vChkdCont().set(fwk112Registo().fwk112VChkdCont());
        hv02801Movhist8().movhist8().cTipoCont().set(fwk112Registo().fwk112CTipoCont());
        hv02801Movhist8().movhist8().cMoedIsoScta().set(fwk112Registo().fwk112CMoedIsoScta());
        hv02801Movhist8().movhist8().nsDeposito().set(fwk112Registo().fwk112NsDeposito());
        hv02801Movhist8().movhist8().tsMovimento().get(1, 10).set(fwk112Registo().fwk112ZMovimento()) ;
        hv02801Movhist8().movhist8().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_TGH28
         */
        hv02801Movhist8().openPghq911a958(CON_Z_FIM, CON_CREDITO) ;
        swSwitches().swSqlcodeVgh02801().set(hv02801Movhist8().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02801");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02801Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2210-ABRE-CRS-TGH28");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02801");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02801Movhist8().movhist8());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2220-FETCH-CRS-TGH28
     * 
     */
    protected void m2220FetchCrsTgh28() {
        log(TraceLevel.Debug, "2220-FETCH-CRS-TGH28");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_TGH28
         */
        hv02801Movhist8().fetchPghq911a996(wsVariaveis().wsCPaisIsoaCont(), wsVariaveis().wsCBancCont(), wsVariaveis().wsCOeEgcCont(), wsVariaveis().wsNsRdclCont(), wsVariaveis().wsVChkdCont(), wsVariaveis().wsCTipoCont(), wsVariaveis().wsCMoedIsoScta(), wsVariaveis().wsNsDeposito(), wsVariaveis().wsTsMovimento(), wsVariaveis().wsZValMov(), wsVariaveis().wsMMovimento()) ;
        swSwitches().swSqlcodeVgh02801().set(hv02801Movhist8().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02801");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02801Ok().isTrue() && !swSwitches().swVgh02801Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2220-FETCH-CRS-TGH28");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02801");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02801Movhist8().movhist8());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (swSwitches().swVgh02801Ok().isTrue()) {
            wsVariaveis().wsZMovimento().set(wsVariaveis().wsTsMovimento().get(1, 10));
        }
    }
    
    /**
     * 
     * 2230-TRATA-CRS-TGH28
     * 
     */
    protected void m2230TrataCrsTgh28() {
        log(TraceLevel.Debug, "2230-TRATA-CRS-TGH28");
        m8000EscreveOutput() ;
        m2220FetchCrsTgh28() ;
    }
    
    /**
     * 
     * 2240-FECHA-CRS-TGH28
     * 
     */
    protected void m2240FechaCrsTgh28() {
        log(TraceLevel.Debug, "2240-FECHA-CRS-TGH28");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_TGH28
         */
        hv02801Movhist8().closePghq911a1067() ;
        swSwitches().swSqlcodeVgh02801().set(hv02801Movhist8().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02801");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02801Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2240-FECHA-CRS-TGH28");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02801Movhist8().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02801");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02801Movhist8().movhist8());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-ACEDE-TGH027
     * 
     */
    protected void m2300AcedeTgh027() {
        log(TraceLevel.Debug, "2300-ACEDE-TGH027");
        m2310AbreCrsTgh27() ;
        m2320FetchCrsTgh27() ;
        while (swSwitches().swVgh02701Ok().isTrue()) {
            m2330TrataCrsTgh27() ;
        }
        m2340FechaCrsTgh27() ;
    }
    
    /**
     * 
     * 2310-ABRE-CRS-TGH27
     * 
     */
    protected void m2310AbreCrsTgh27() {
        log(TraceLevel.Debug, "2210-ABRE-CRS-TGH27");
        hv02701Movhist7().movhist7().initialize() ;
        hv02701Movhist7().movhist7().cPaisIsoaCont().set(fwk112Registo().fwk112CPaisIsoaCont());
        hv02701Movhist7().movhist7().cBancCont().set(fwk112Registo().fwk112CBancCont());
        hv02701Movhist7().movhist7().cOeEgcCont().set(fwk112Registo().fwk112COeEgcCont());
        hv02701Movhist7().movhist7().nsRdclCont().set(fwk112Registo().fwk112NsRdclCont());
        hv02701Movhist7().movhist7().vChkdCont().set(fwk112Registo().fwk112VChkdCont());
        hv02701Movhist7().movhist7().cTipoCont().set(fwk112Registo().fwk112CTipoCont());
        hv02701Movhist7().movhist7().cMoedIsoScta().set(fwk112Registo().fwk112CMoedIsoScta());
        hv02701Movhist7().movhist7().nsDeposito().set(fwk112Registo().fwk112NsDeposito());
        hv02701Movhist7().movhist7().tsMovimento().get(1, 10).set(fwk112Registo().fwk112ZMovimento()) ;
        hv02701Movhist7().movhist7().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_TGH27
         */
        hv02701Movhist7().openPghq911a1146(CON_Z_FIM, CON_CREDITO) ;
        swSwitches().swSqlcodeVgh02701().set(hv02701Movhist7().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02701");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02701Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2310-ABRE-CRS-TGH27");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02701");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02701Movhist7().movhist7());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2320-FETCH-CRS-TGH27
     * 
     */
    protected void m2320FetchCrsTgh27() {
        log(TraceLevel.Debug, "2320-FETCH-CRS-TGH27");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_TGH27
         */
        hv02701Movhist7().fetchPghq911a1184(wsVariaveis().wsCPaisIsoaCont(), wsVariaveis().wsCBancCont(), wsVariaveis().wsCOeEgcCont(), wsVariaveis().wsNsRdclCont(), wsVariaveis().wsVChkdCont(), wsVariaveis().wsCTipoCont(), wsVariaveis().wsCMoedIsoScta(), wsVariaveis().wsNsDeposito(), wsVariaveis().wsTsMovimento(), wsVariaveis().wsZValMov(), wsVariaveis().wsMMovimento()) ;
        swSwitches().swSqlcodeVgh02701().set(hv02701Movhist7().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02701");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02701Ok().isTrue() && !swSwitches().swVgh02701Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-FETCH-CRS-TGH27");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02701");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02701Movhist7().movhist7());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (swSwitches().swVgh02701Ok().isTrue()) {
            wsVariaveis().wsZMovimento().set(wsVariaveis().wsTsMovimento().get(1, 10));
        }
    }
    
    /**
     * 
     * 2330-TRATA-CRS-TGH27
     * 
     */
    protected void m2330TrataCrsTgh27() {
        log(TraceLevel.Debug, "2330-TRATA-CRS-TGH27");
        m8000EscreveOutput() ;
        m2320FetchCrsTgh27() ;
    }
    
    /**
     * 
     * 2340-FECHA-CRS-TGH27
     * 
     */
    protected void m2340FechaCrsTgh27() {
        log(TraceLevel.Debug, "2340-FECHA-CRS-TGH27");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_TGH27
         */
        hv02701Movhist7().closePghq911a1255() ;
        swSwitches().swSqlcodeVgh02701().set(hv02701Movhist7().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02701");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02701Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2340-FECHA-CRS-TGH27");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02701Movhist7().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02701");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02701Movhist7().movhist7());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2400-ACEDE-TGH026
     * 
     */
    protected void m2400AcedeTgh026() {
        log(TraceLevel.Debug, "2400-ACEDE-TGH026");
        m2410AbreCrsTgh26() ;
        m2420FetchCrsTgh26() ;
        while (swSwitches().swVgh02601Ok().isTrue()) {
            m2430TrataCrsTgh26() ;
        }
        m2440FechaCrsTgh26() ;
    }
    
    /**
     * 
     * 2410-ABRE-CRS-TGH26
     * 
     */
    protected void m2410AbreCrsTgh26() {
        log(TraceLevel.Debug, "2410-ABRE-CRS-TGH26");
        hv02601Movhist6().movhist6().initialize() ;
        hv02601Movhist6().movhist6().cPaisIsoaCont().set(fwk112Registo().fwk112CPaisIsoaCont());
        hv02601Movhist6().movhist6().cBancCont().set(fwk112Registo().fwk112CBancCont());
        hv02601Movhist6().movhist6().cOeEgcCont().set(fwk112Registo().fwk112COeEgcCont());
        hv02601Movhist6().movhist6().nsRdclCont().set(fwk112Registo().fwk112NsRdclCont());
        hv02601Movhist6().movhist6().vChkdCont().set(fwk112Registo().fwk112VChkdCont());
        hv02601Movhist6().movhist6().cTipoCont().set(fwk112Registo().fwk112CTipoCont());
        hv02601Movhist6().movhist6().cMoedIsoScta().set(fwk112Registo().fwk112CMoedIsoScta());
        hv02601Movhist6().movhist6().nsDeposito().set(fwk112Registo().fwk112NsDeposito());
        hv02601Movhist6().movhist6().tsMovimento().get(1, 10).set(fwk112Registo().fwk112ZMovimento()) ;
        hv02601Movhist6().movhist6().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_TGH26
         */
        hv02601Movhist6().openPghq911a1334(CON_Z_FIM, CON_CREDITO) ;
        swSwitches().swSqlcodeVgh02601().set(hv02601Movhist6().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02601");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02601Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2310-ABRE-CRS-TGH26");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02601");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02601Movhist6().movhist6());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2420-FETCH-CRS-TGH26
     * 
     */
    protected void m2420FetchCrsTgh26() {
        log(TraceLevel.Debug, "2420-FETCH-CRS-TGH26");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_TGH26
         */
        hv02601Movhist6().fetchPghq911a1372(wsVariaveis().wsCPaisIsoaCont(), wsVariaveis().wsCBancCont(), wsVariaveis().wsCOeEgcCont(), wsVariaveis().wsNsRdclCont(), wsVariaveis().wsVChkdCont(), wsVariaveis().wsCTipoCont(), wsVariaveis().wsCMoedIsoScta(), wsVariaveis().wsNsDeposito(), wsVariaveis().wsTsMovimento(), wsVariaveis().wsZValMov(), wsVariaveis().wsMMovimento()) ;
        swSwitches().swSqlcodeVgh02601().set(hv02601Movhist6().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02601");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02601Ok().isTrue() && !swSwitches().swVgh02601Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2420-FETCH-CRS-TGH26");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02601");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02601Movhist6().movhist6());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (swSwitches().swVgh02601Ok().isTrue()) {
            wsVariaveis().wsZMovimento().set(wsVariaveis().wsTsMovimento().get(1, 10));
        }
    }
    
    /**
     * 
     * 2430-TRATA-CRS-TGH26
     * 
     */
    protected void m2430TrataCrsTgh26() {
        log(TraceLevel.Debug, "2430-TRATA-CRS-TGH26");
        m8000EscreveOutput() ;
        m2420FetchCrsTgh26() ;
    }
    
    /**
     * 
     * 2440-FECHA-CRS-TGH26
     * 
     */
    protected void m2440FechaCrsTgh26() {
        log(TraceLevel.Debug, "2440-FECHA-CRS-TGH26");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_TGH26
         */
        hv02601Movhist6().closePghq911a1443() ;
        swSwitches().swSqlcodeVgh02601().set(hv02601Movhist6().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH02601");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh02601Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2440-FECHA-CRS-TGH26");
            bhtw0030().dadosEntrada().cSqlcode().set(hv02601Movhist6().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH02601");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv02601Movhist6().movhist6());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2500-ACEDE-TGH002
     * 
     */
    protected void m2500AcedeTgh002() {
        log(TraceLevel.Debug, "2500-ACEDE-TGH002");
        m2510AbreCrsTgh02() ;
        m2520FetchCrsTgh02() ;
        while (swSwitches().swVgh00201Ok().isTrue()) {
            m2530TrataCrsTgh02() ;
        }
        m2540FechaCrsTgh02() ;
    }
    
    /**
     * 
     * 2510-ABRE-CRS-TGH02
     * 
     */
    protected void m2510AbreCrsTgh02() {
        log(TraceLevel.Debug, "2510-ABRE-CRS-TGH02");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(fwk112Registo().fwk112CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(fwk112Registo().fwk112CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fwk112Registo().fwk112COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(fwk112Registo().fwk112NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(fwk112Registo().fwk112VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(fwk112Registo().fwk112CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(fwk112Registo().fwk112CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(fwk112Registo().fwk112NsDeposito());
        hv00201Movhst().movhst().tsMovimento().get(1, 10).set(fwk112Registo().fwk112ZMovimento()) ;
        hv00201Movhst().movhst().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS_TGH02
         */
        hv00201Movhst().openPghq911a1522(CON_Z_FIM, CON_CREDITO) ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2510-ABRE-CRS-TGH02");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2520-FETCH-CRS-TGH02
     * 
     */
    protected void m2520FetchCrsTgh02() {
        log(TraceLevel.Debug, "2520-FETCH-CRS-TGH02");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS_TGH02
         */
        hv00201Movhst().fetchPghq911a1560(wsVariaveis().wsCPaisIsoaCont(), wsVariaveis().wsCBancCont(), wsVariaveis().wsCOeEgcCont(), wsVariaveis().wsNsRdclCont(), wsVariaveis().wsVChkdCont(), wsVariaveis().wsCTipoCont(), wsVariaveis().wsCMoedIsoScta(), wsVariaveis().wsNsDeposito(), wsVariaveis().wsTsMovimento(), wsVariaveis().wsZValMov(), wsVariaveis().wsMMovimento()) ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swFetch().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue() && !swSwitches().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2520-FETCH-CRS-TGH02");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (swSwitches().swVgh00201Ok().isTrue()) {
            wsVariaveis().wsZMovimento().set(wsVariaveis().wsTsMovimento().get(1, 10));
        }
    }
    
    /**
     * 
     * 2530-TRATA-CRS-TGH02
     * 
     */
    protected void m2530TrataCrsTgh02() {
        log(TraceLevel.Debug, "2530-TRATA-CRS-TGH02");
        m8000EscreveOutput() ;
        m2520FetchCrsTgh02() ;
    }
    
    /**
     * 
     * 2540-FECHA-CRS-TGH02
     * 
     */
    protected void m2540FechaCrsTgh02() {
        log(TraceLevel.Debug, "2540-FECHA-CRS-TGH02");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS_TGH02
         */
        hv00201Movhst().closePghq911a1631() ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swCloseCursor().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2540-FECHA-CRS-TGH02");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 8000-ESCREVE-OUTPUT
     * 
     */
    protected void m8000EscreveOutput() {
        log(TraceLevel.Debug, "8000-ESCREVE-OUTPUT");
        fwk911Registo().initialize() ;
        fwk911Registo().fwk911CPaisIsoaCont().set(wsVariaveis().wsCPaisIsoaCont());
        fwk911Registo().fwk911CBancCont().set(wsVariaveis().wsCBancCont());
        fwk911Registo().fwk911COeEgcCont().set(wsVariaveis().wsCOeEgcCont());
        fwk911Registo().fwk911NsRdclCont().set(wsVariaveis().wsNsRdclCont());
        fwk911Registo().fwk911VChkdCont().set(wsVariaveis().wsVChkdCont());
        fwk911Registo().fwk911CTipoCont().set(wsVariaveis().wsCTipoCont());
        fwk911Registo().fwk911CMoedIsoScta().set(wsVariaveis().wsCMoedIsoScta());
        fwk911Registo().fwk911NsDeposito().set(wsVariaveis().wsNsDeposito());
        fwk911Registo().fwk911ZMovimento().set(wsVariaveis().wsZMovimento());
        fwk911Registo().fwk911ZValMov().set(wsVariaveis().wsZValMov());
        fwk911Registo().fwk911MMovimento().set(wsVariaveis().wsMMovimento());
        fwk911Registo().filler1().set(";");
        fwk911Registo().filler2().set(";");
        fwk911Registo().filler3().set(";");
        fwk911Registo().filler4().set(";");
        fwk911Registo().filler5().set(";");
        fwk911Registo().filler6().set(";");
        ficheiroFwk911().write(ficheiroFwk911().regFwk91173) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK911);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk911().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk911().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK911);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk911().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("8000-ESCREVE-OUTPUT");
            m9900Abend() ;
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
        m3110CloseFicheiros() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FICHEIROS
     * 
     */
    protected void m3110CloseFicheiros() {
        log(TraceLevel.Debug, "3110-CLOSE-FICHEIROS");
        ficheiroFwk112().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK112);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk112().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk112().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK112);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk112().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FICHEIROS");
            m9900Abend() ;
        }
        ficheiroFwk911().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK911);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk911().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk911().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK911);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk911().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FICHEIROS");
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
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFwk112().close() ;
        ficheiroFwk911().close() ;
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
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk112() ;
        @Data
        @Condition("00")
        ICondition swFwk112Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk112Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk911() ;
        @Data
        @Condition("00")
        ICondition swFwk911Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk911Eof() ;
        
        
    }
    
    /**
     * 
     * VARIAVEIS AUXILIARES
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3)
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDeposito() ;
        
        @Data(size=26)
        IString wsTsMovimento() ;
        
        @Data(size=10)
        IString wsZValMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovimento() ;
        
        @Data(size=10)
        IString wsZMovimento() ;
        
        @Data(size=5)
        IInt wsRead() ;
        
    }
    public interface Fwk112Registo extends IDataStruct {
        
        @Data(size=3)
        IString fwk112CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwk112CBancCont() ;
        
        @Data(size=4)
        IInt fwk112COeEgcCont() ;
        
        @Data(size=7)
        IInt fwk112NsRdclCont() ;
        
        @Data(size=1)
        IInt fwk112VChkdCont() ;
        
        @Data(size=3)
        IInt fwk112CTipoCont() ;
        
        @Data(size=3)
        IString fwk112CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fwk112NsDeposito() ;
        
        @Data(size=6)
        IInt fwk112NsCmrg() ;
        
        @Data(size=10)
        IString fwk112ZMovimento() ;
        
    }
    public interface Fwk911Registo extends IDataStruct {
        
        @Data(size=3)
        IString fwk911CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwk911CBancCont() ;
        
        @Data(size=4)
        IInt fwk911COeEgcCont() ;
        
        @Data(size=7)
        IInt fwk911NsRdclCont() ;
        
        @Data(size=1)
        IInt fwk911VChkdCont() ;
        
        @Data(size=3)
        IInt fwk911CTipoCont() ;
        
        @Data(size=1, value=";")
        IString filler1() ;
        
        @Data(size=3)
        IString fwk911CMoedIsoScta() ;
        
        @Data(size=1, value=";")
        IString filler2() ;
        
        @Data(size=4)
        IInt fwk911NsDeposito() ;
        
        @Data(size=1, value=";")
        IString filler3() ;
        
        @Data(size=10)
        IString fwk911ZMovimento() ;
        
        @Data(size=1, value=";")
        IString filler4() ;
        
        @Data(size=10)
        IString fwk911ZValMov() ;
        
        @Data(size=1, value=";")
        IString filler5() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk911MMovimento() ;
        
        @Data(size=1, value=";")
        IString filler6() ;
        
    }
    public interface SwSwitches extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02301() ;
        @Data
        @Condition("0")
        ICondition swVgh02301Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02301Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02601() ;
        @Data
        @Condition("0")
        ICondition swVgh02601Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02601Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02701() ;
        @Data
        @Condition("0")
        ICondition swVgh02701Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02701Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh02801() ;
        @Data
        @Condition("0")
        ICondition swVgh02801Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh02801Notfnd() ;
        
        
    }
    
}
