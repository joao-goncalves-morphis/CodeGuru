package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
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
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtr0112 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.gh.structures.work.Bghw8812 ;
import cgd.gh.structures.work.Bghr0511 ;
import cgd.ho.structures.link.Bhol512a ;
import cgd.hj.structures.link.Bhjl013a ;
import cgd.hg.structures.link.Bhgl030a ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.ht.routines.Mhtq250a ;
import cgd.ho.routines.Mhoj512a ;
import cgd.hj.routines.Mhjj013a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.za.utilities.Ezacic04 ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE INPUT - FWK812
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE OUTPUT - FGH051
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq011a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk812
     */
    @Handler(name="FWK812", record="statusFwk812")
    @Data
    protected abstract Fwk812 ficheiroFwk812() ;
    
    /**
     * @return instancia da classe Fgh051
     */
    @Handler(name="FGH051", record="regFgh051200")
    @Data
    protected abstract Fgh051 ficheiroFgh051() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mhoj512a
     */
    @Data
    protected abstract Mhoj512a hrMhoj512a() ;
    
    /**
     * @return instancia da classe Mhjj013a
     */
    @Data
    protected abstract Mhjj013a hrMhjj013a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    /**
     * @return instancia da classe Ezacic04
     */
    @Data
    protected abstract Ezacic04 hpezacic04() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0112
     */
    @Data
    protected abstract Bhtr0112 bhtr0112() ;
    
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
     * @return instancia da classe Bghw8812
     */
    @Data
    protected abstract Bghw8812 bghw8812() ;
    
    /**
     * @return instancia da classe Bghr0511
     */
    @Data
    protected abstract Bghr0511 bghr0511() ;
    
    /**
     * @return instancia da classe Bhol512a
     */
    @Data
    protected abstract Bhol512a bhol512a() ;
    
    /**
     * @return instancia da classe Bhjl013a
     */
    @Data
    protected abstract Bhjl013a bhjl013a() ;
    
    /**
     * @return instancia da classe Bhgl030a
     */
    @Data
    protected abstract Bhgl030a bhgl030a() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * AREA DE INCLUDE DB2
     * STATUS
     * INICIO WORKING-STORAGE PGHQ011A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FGH051 = "FGH051" ;
    
    protected static final String CON_FWK812 = "FWK812" ;
    
    protected static final String CON_MHOJ512A = "MHOJ512A" ;
    
    protected static final String CON_MHJJ013A = "MHJJ013A" ;
    
    protected static final String CON_MHGJ030A = "MHGJ030A" ;
    
    protected static final String CON_MHYJ230A = "MHYJ230A" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ011A" ;
    
    protected static final String CON_CGD = "CGD" ;
    
    protected static final String CON_I_SIT_CLI_06 = "06" ;
    
    protected static final String CON_I_SIT_CLI_94 = "94" ;
    
    protected static final String CON_632 = "632" ;
    
    protected static final String CON_PONT_VIRG = ";" ;
    
    protected static final String CON_PT = "PT " ;
    
    protected static final String CON_PROGRAM_DESC = "VERIFICACAO DE DOCS ID CADUCADOS DO CLIENTE" ;
    
    /**
     * CONSTANTES NOMES COLUNAS DO EXCEL
     */
    protected static final String CON_PAIS_GST = "PAIS GST" ;
    
    protected static final String CON_BANC_GST = "BANC GST" ;
    
    protected static final String CON_BALC_GST = "BALC GST" ;
    
    protected static final String CON_PAIS_CNT = "PAIS CNT" ;
    
    protected static final String CON_BANC_CNT = "BANC CNT" ;
    
    protected static final String CON_BALC_CNTDE = "BALC CNT" ;
    
    protected static final String CON_RDCL_CNT = "RDCL CNT" ;
    
    protected static final String CON_CHKD_CNTOV = "CHKD CNT" ;
    
    protected static final String CON_TIPO_CNT = "TIPO CNT" ;
    
    protected static final String CON_CLIENTE = "CLIENTE" ;
    
    protected static final String CON_NS_CLIENTE = "NS CLIENTE" ;
    
    protected static final String CON_TIP_ITVT = "TIP ITVT" ;
    
    protected static final String CON_NS_TITULAR = "NS TITULAR" ;
    
    protected static final String CON_I_SIT_CLI = "I SIT CLI" ;
    
    protected static final String CON_DATA_INIC_REL = "DATA INIC RELACAO" ;
    
    protected static final String CON_I_EST_CNT = "I EST CNT" ;
    
    protected static final String CON_I_RESTRICAO_CNT = "I RESTRICAO CNT" ;
    
    protected static final String CON_SLDO_CBLO = "SLDO CBLO" ;
    
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
     * @return instancia da classe local WsHeader1
     */
    @Data
    protected abstract WsHeader1 wsHeader1() ;
    
    /**
     * VARIAVEIS PARA CONVERSAO EBCDIC
     */
    @Data(size=8, value="198", compression=COMP)
    protected ILong nbytes ;
    
    @Data(size=200)
    protected IString inputEbcdic ;
    
    
    
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
     * BHOP0512 - ACESSO AO MODULO DE CONSULTA DE BLOQUEIO DO
     * AVISO 11
     * 
     */
    protected void bhop0512AcedeMhoj512a() {
        hrMhoj512a().run() ;
    }
    
    /**
     * 
     * BHJP5013-ACESSO AO MODULO DE OBTENCAO DOS DADOS
     * BASICOS DO CLIENTE (MHJJ013A)
     * 
     */
    protected void bhjp5013AcedeMhjj013a() {
        hrMhjj013a().run() ;
    }
    
    /**
     * 
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
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
        m2000ProcessoPrograma() ;
        /**
         * UNTIL NOT SW-FWK812-OK.
         */
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
        m8000DataHoraIni() ;
        m1500AbreFicheiros() ;
        m1600LeFwk812() ;
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
        m1510AbreFgh051() ;
        m1530AbreFwk812() ;
    }
    
    /**
     * 
     * 1510-ABRE-FGH051
     * 
     */
    protected void m1510AbreFgh051() {
        log(TraceLevel.Debug, "1510-ABRE-FGH051");
        /**
         * *ABRE FICHEIRO DE OUTPUT - FGH051
         */
        ficheiroFgh051().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH051);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh051().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh051().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH051);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh051().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-ABRE-FGH051");
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
         * *ABRE FICHEIRO DE INPUT - FWK812
         */
        ficheiroFwk812().open() ;
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
     * 1600-LE-FWK812
     * 
     */
    protected void m1600LeFwk812() {
        log(TraceLevel.Debug, "1600-LE-FWK812");
        bghw8812().registo().initialize() ;
        ficheiroFwk812().read(bghw8812().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK812);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk812().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk812().getStatusOk() && !ficheiroFwk812().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK812);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk812().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-LE-FWK812");
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
        m2010TrataHeader() ;
        m2020TrataCabecalho() ;
        while (ficheiroFwk812().getStatusOk()) {
            m2050TrataDetalhe() ;
        }
    }
    
    /**
     * 
     * 2010-TRATA-HEADER
     * 
     */
    protected void m2010TrataHeader() {
        log(TraceLevel.Debug, "2010-TRATA-HEADER");
        m8100DataHoraFim() ;
        /**
         * ESCREVE CABECALHO HEADER 1 POR MAPA
         */
        bghr0511().registo().initialize() ;
        wsHeader1().wsDataH1().set(wsVariaveis().wsDataIni());
        bghr0511().registo().registoHeader1().tituloH1().set(wsHeader1());
        m2350ConverEbcdic() ;
        /**
         * WRITE REG-FGH051              FROM BGHR0511-REGISTO.
         */
        ficheiroFgh051().write(ficheiroFgh051().regFgh051200) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH051);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh051().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh051().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH051);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh051().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2300-ESCREVE-FGH051");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2020-TRATA-CABECALHO
     * 
     */
    protected void m2020TrataCabecalho() {
        log(TraceLevel.Debug, "2020-TRATA-CABECALHO");
        /**
         * ESCREVE CABECALHO POR COLUNA
         */
        bghr0511().registo().initialize() ;
        bghr0511().registo().registoHeader3().paisIsoaGH().set(CON_PAIS_GST);
        bghr0511().registo().registoHeader3().bancGesH().set(CON_BANC_GST);
        bghr0511().registo().registoHeader3().oeGesH().set(CON_BALC_GST);
        bghr0511().registo().registoHeader3().paisContH().set(CON_PAIS_CNT);
        bghr0511().registo().registoHeader3().bancContH().set(CON_BANC_CNT);
        bghr0511().registo().registoHeader3().oeContH().set(CON_BALC_CNTDE);
        bghr0511().registo().registoHeader3().rdclContH().set(CON_RDCL_CNT);
        bghr0511().registo().registoHeader3().chkdContH().set(CON_CHKD_CNTOV);
        bghr0511().registo().registoHeader3().tipoContH().set(CON_TIPO_CNT);
        bghr0511().registo().registoHeader3().nClienteH().set(CON_CLIENTE);
        bghr0511().registo().registoHeader3().nsAbraCliH().set(CON_NS_CLIENTE);
        bghr0511().registo().registoHeader3().iTipoItvtH().set(CON_TIP_ITVT);
        bghr0511().registo().registoHeader3().nsTitcH().set(CON_NS_TITULAR);
        bghr0511().registo().registoHeader3().iSitCliH().set(CON_I_SIT_CLI);
        bghr0511().registo().registoHeader3().zInicRelH().set(CON_DATA_INIC_REL);
        bghr0511().registo().registoHeader3().iEstContH().set(CON_I_EST_CNT);
        bghr0511().registo().registoHeader3().iRstzContH().set(CON_I_RESTRICAO_CNT);
        bghr0511().registo().registoHeader3().mSldContabH().set(CON_SLDO_CBLO);
        bghr0511().registo().registoHeader3().fillerH1().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH2().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH3().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH4().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH5().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH6().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH7().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH8().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH9().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH10().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH11().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH12().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH13().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH14().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH15().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH16().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH17().set(CON_PONT_VIRG);
        bghr0511().registo().registoHeader3().fillerH18().set(CON_PONT_VIRG);
        m2350ConverEbcdic() ;
        /**
         * WRITE REG-FGH051              FROM BGHR0511-REGISTO.
         */
        ficheiroFgh051().write(ficheiroFgh051().regFgh051200) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH051);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh051().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh051().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH051);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh051().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2300-ESCREVE-FGH051");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2050-TRATA-DETALHE
     * 
     */
    protected void m2050TrataDetalhe() {
        log(TraceLevel.Debug, "2050-TRATA-DETALHE");
        log(TraceLevel.Debug, "BGHW8812-C-PAIS-ISOA-CONT:", bghw8812().registo().conta().cPaisIsoaCont());
        log(TraceLevel.Debug, "BGHW8812-C-BANC-CONT:", bghw8812().registo().conta().cBancCont());
        log(TraceLevel.Debug, "BGHW8812-C-OE-EGC-CONT:", bghw8812().registo().conta().cOeEgcCont());
        log(TraceLevel.Debug, "BGHW8812-NS-RDCL-CONT:", bghw8812().registo().conta().nsRdclCont());
        log(TraceLevel.Debug, "BGHW8812-V-CHKD-CONT:", bghw8812().registo().conta().vChkdCont());
        log(TraceLevel.Debug, "BGHW8812-C-TIPO-CONT:", bghw8812().registo().conta().cTipoCont());
        /**
         * PERFORM 2100-TRATA-MAPA
         * THRU 2100-TRATA-MAPA-EXIT.
         * IF SW-DEBUG-SIM
         * DISPLAY 'BHOL512A-I-EST-BLOQ' BHOL512A-I-EST-BLOQ
         * END-IF.
         * IF BHOL512A-I-EST-BLOQ-S
         */
        m2200AcedeMhjj013a() ;
        log(TraceLevel.Debug, "BHJL013A-I-SIT-CLI", bhjl013a().commarea().dadosSaida().iSitCli());
        if (bhjl013a().commarea().erros().semErros().isTrue() && 
            (bhjl013a().commarea().dadosSaida().iSitCli().get(2, 2).isEqual(CON_I_SIT_CLI_06) || 
            bhjl013a().commarea().dadosSaida().iSitCli().get(2, 2).isEqual(CON_I_SIT_CLI_94))) {
            m2300EscreveFgh051() ;
        }
        /**
         * END-IF.
         */
        m1600LeFwk812() ;
    }
    
    /**
     * 
     * 2100-TRATA-MAPA
     * *2100-TRATA-MAPA.
     * IF SW-DEBUG-SIM
     * DISPLAY '2100-TRATA-MAPA'
     * END-IF.
     * INITIALIZE BHOL512A-COMMAREA  REPLACING
     * ALPHANUMERIC BY SPACES
     * NUMERIC      BY ZEROES.
     * MOVE BGHW8812-C-PAIS-ISOA-CONT
     * TO BHOL512A-C-PAIS-ISOA-CONT.
     * MOVE BGHW8812-C-BANC-CONT     TO BHOL512A-C-BANC-CONT.
     * MOVE BGHW8812-C-OE-EGC-CONT   TO BHOL512A-C-OE-EGC-CONT.
     * MOVE BGHW8812-NS-RDCL-CONT    TO BHOL512A-NS-RDCL-CONT.
     * MOVE BGHW8812-V-CHKD-CONT     TO BHOL512A-V-CHKD-CONT.
     * MOVE BGHW8812-C-TIPO-CONT     TO BHOL512A-C-TIPO-CONT.
     * PERFORM BHOP0512-ACEDE-MHOJ512A
     * THRU BHOP0512-ACEDE-MHOJ512A-EXIT.
     * IF NOT BHOL512A-SEM-ERROS AND NOT BHOL512A-FIM-CONSULTA
     * MOVE BHOL512A-C-TIPO-ERRO-BBN
     * TO BHTW0030-C-TIPO-ERRO-BBN
     * MOVE BHOL512A-C-SQLCODE    TO BHTW0030-C-SQLCODE
     * MOVE CON-MHOJ512A          TO BHTW0030-NM-PRG-CHMD
     * MOVE BHOL512A-DADOS-INPUT
     * TO BHTW0030-X-CTEU-ALIG
     * MOVE BHOL512A-NM-TABELA    TO BHTW0030-NM-TABELA
     * MOVE BHOL512A-MSG-ERROB    TO BHTW0030-X-SUG-RTNO-SWAL
     * SET  BHTW0030-ABEND        TO TRUE
     * PERFORM 9900-ABEND
     * THRU 9900-ABEND-EXIT
     * *2100-TRATA-MAPA-EXIT.
     * EXIT.
     * 2200-ACEDE-MHJJ013A
     * 
     */
    protected void m2200AcedeMhjj013a() {
        log(TraceLevel.Debug, "2200-ACEDE-MHJJ013A");
        bhjl013a().commarea().initialize() ;
        bhjl013a().commarea().dadosEntrada().nCliente().set(bghw8812().registo().nCliente());
        bhjl013a().commarea().dadosEntrada().nsAbraCli().set(bghw8812().registo().nsAbraCli());
        bhjp5013AcedeMhjj013a() ;
        if (!bhjl013a().commarea().erros().semErros().isTrue() && !bhjl013a().commarea().erros().fimConsulta().isTrue()) {
            bhtw0030().dadosEntrada().cTipoErroBbn().set(bhjl013a().commarea().erros().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhjl013a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MHJJ013A);
            bhtw0030().dadosEntrada().xCteuAlig().set(bhjl013a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhjl013a().commarea().erros().nmTabela());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhjl013a().commarea().erros().msgErrob());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-ESCREVE-FGH051
     * 
     */
    protected void m2300EscreveFgh051() {
        log(TraceLevel.Debug, "2300-ESCREVE-FGH051");
        /**
         * ESCRITA DO REGISTO DE DETALHE
         */
        bghr0511().registo().initialize() ;
        bghr0511().registo().registoDetalhe().cPaisIsoaGerx().set(bghw8812().registo().cPaisIsoaGerx());
        bghr0511().registo().registoDetalhe().cBancGcxGerx().set(bghw8812().registo().cBancGcxGerx());
        bghr0511().registo().registoDetalhe().cOeEgcGerx().set(bghw8812().registo().cOeEgcGerx());
        bghr0511().registo().registoDetalhe().conta().cPaisIsoaCont().set(bghw8812().registo().conta().cPaisIsoaCont());
        bghr0511().registo().registoDetalhe().conta().cBancCont().set(bghw8812().registo().conta().cBancCont());
        bghr0511().registo().registoDetalhe().conta().cOeEgcCont().set(bghw8812().registo().conta().cOeEgcCont());
        bghr0511().registo().registoDetalhe().conta().nsRdclCont().set(bghw8812().registo().conta().nsRdclCont());
        bghr0511().registo().registoDetalhe().conta().vChkdCont().set(bghw8812().registo().conta().vChkdCont());
        bghr0511().registo().registoDetalhe().conta().cTipoCont().set(bghw8812().registo().conta().cTipoCont());
        bghr0511().registo().registoDetalhe().nCliente().set(bghw8812().registo().nCliente());
        bghr0511().registo().registoDetalhe().nsAbraCli().set(bghw8812().registo().nsAbraCli());
        bghr0511().registo().registoDetalhe().iTipoItvt().set(bghw8812().registo().iTipoItvt());
        bghr0511().registo().registoDetalhe().nsTitc().set(bghw8812().registo().nsTitc());
        bghr0511().registo().registoDetalhe().iSitCli().set(bhjl013a().commarea().dadosSaida().iSitCli());
        bghr0511().registo().registoDetalhe().zInicRel().set(bghw8812().registo().zInicRel());
        bghr0511().registo().registoDetalhe().iEstCont().set(bghw8812().registo().iEstCont());
        bghr0511().registo().registoDetalhe().iExisRstzCont().set(bghw8812().registo().iExisRstzCont());
        bghr0511().registo().registoDetalhe().mSldoCblo().set(bghw8812().registo().mSldoCblo());
        bghr0511().registo().registoDetalhe().v01().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v02().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v03().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().conta().v04().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().conta().v05().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().conta().v06().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().conta().v07().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().conta().v08().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().conta().v09().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v10().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v11().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v12().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v13().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v14().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v15().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v16().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v17().set(CON_PONT_VIRG);
        bghr0511().registo().registoDetalhe().v18().set(CON_PONT_VIRG);
        m2350ConverEbcdic() ;
        /**
         * WRITE REG-FGH051              FROM BGHR0511-REGISTO.
         */
        ficheiroFgh051().write(ficheiroFgh051().regFgh051200) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH051);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh051().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh051().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH051);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh051().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2300-ESCREVE-FGH051");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2350-CONVER-EBCDIC
     * 
     */
    protected void m2350ConverEbcdic() {
        log(TraceLevel.Debug, "2350-CONVER-EBCDIC");
        inputEbcdic.set(bghr0511().registo());
        hpezacic04().run() ;
        inputEbcdic.get(add(nbytes, 1), 2).set("0D0A") ;
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
        m3110FechaFgh051() ;
        m3130FechaFwk812() ;
    }
    
    /**
     * 
     * 3110-FECHA-FGH051
     * 
     */
    protected void m3110FechaFgh051() {
        log(TraceLevel.Debug, "3110-FECHA-FGH051");
        ficheiroFgh051().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH051);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh051().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh051().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH051);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh051().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-FECHA-FGH051");
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
     * 8000-DATA-HORA-INI
     * 
     */
    protected void m8000DataHoraIni() {
        log(TraceLevel.Debug, "8000-DATA-HORA-INI");
        wsVariaveis().wsDataIni().set( getDBDate() ) ;
        if (getPersistenceCode() != PersistenceCode.NORMAL) {
            bhtw0030().dadosEntrada().cSqlcode().set(getPersistenceCode());
            bhtw0030().dadosEntrada().nmTabela().set("SET CUR DATE");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().xCteuChavTab().set(" ");
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO SET CURRENT_DATE");
            m9900Abend() ;
        }
        wsVariaveis().wsHoraIni().set( getDBTime() ) ;
        if (getPersistenceCode() != PersistenceCode.NORMAL) {
            bhtw0030().dadosEntrada().cSqlcode().set(getPersistenceCode());
            bhtw0030().dadosEntrada().nmTabela().set("SET CUR TIME");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().xCteuChavTab().set(" ");
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO SET CURRENT_TIME");
            m9900Abend() ;
        }
        wsVariaveis().wsTimestamp().set( getDBTimestamp() ) ;
    }
    
    /**
     * 
     * 8100-DATA-HORA-FIM
     * 
     */
    protected void m8100DataHoraFim() {
        log(TraceLevel.Debug, "8100-DATA-HORA-FIM");
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
        if (getPersistenceCode() != PersistenceCode.NORMAL) {
            bhtw0030().dadosEntrada().cSqlcode().set(getPersistenceCode());
            bhtw0030().dadosEntrada().nmTabela().set("SET CUR DATE");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().xCteuChavTab().set(" ");
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO SET CURRENT_DATE FIM");
            m9900Abend() ;
        }
        wsVariaveis().wsHoraFim().set( getDBTime() ) ;
        if (getPersistenceCode() != PersistenceCode.NORMAL) {
            bhtw0030().dadosEntrada().cSqlcode().set(getPersistenceCode());
            bhtw0030().dadosEntrada().nmTabela().set("SET CUR TIME");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().xCteuChavTab().set(" ");
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO SET CURRENT_TIME FIM");
            m9900Abend() ;
        }
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
     * AREA DE INCLUDE DB2
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
        IString statusFgh051() ;
        @Data
        @Condition("00")
        ICondition swFgh051Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh051Eof() ;
        
        
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
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        @Data(size=10)
        IString wsZReferencia() ;
        
        /**
         * @return instancia da classe local WsZReferenciaMask
         */
        @Data
        @Mask
        WsZReferenciaMask wsZReferenciaMask() ;
        
        
        public interface WsZReferenciaMask extends IDataMask {
            
            @Data(size=4)
            IInt wsAaaaReferencia() ;
            
            @Data(size=2, lpadding=1)
            IInt wsMmReferencia() ;
            
            @Data(size=2, lpadding=1)
            IInt wsDdReferencia() ;
            
        }
    }
    public interface WsHeader1 extends IDataStruct {
        
        @Data(size=10, value=" ", lpadding=5, lpaddingValue="DATA:")
        IString wsDataH1() ;
        
    }
    
}
