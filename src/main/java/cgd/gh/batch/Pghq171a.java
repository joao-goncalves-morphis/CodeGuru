package cgd.gh.batch;

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
import cgd.ht.structures.work.Bhtr0112 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.im.common.constants.Bimk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghr1701 ;
import cgd.gh.structures.work.Bghr1702 ;
import cgd.im.structures.link.Biml002a ;
import cgd.im.structures.link.Biml004a ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hq.structures.link.Bhql028a ;
import cgd.hg.structures.link.Bhgl010a ;
import cgd.ht.routines.Mhtq250a ;
import cgd.im.routines.Mimj002a ;
import cgd.im.routines.Mimj004a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.hq.routines.Mhqj028a ;
import cgd.hg.routines.Mhgj010a ;


/**
 * 
 * *GH2027-FIM
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq171a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdzcps02101Parmadi
     */
    @Data
    protected abstract Vwsdzcps02101Parmadi hv02101Parmadi() ;
    
    
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
     * @return instancia da classe Fwk00301
     */
    @Handler(name="FWK003", record="statusFwk003")
    @Data
    protected abstract Fwk00301 ficheiroFwk003() ;
    
    /**
     * @return instancia da classe Fwk004
     */
    @Handler(name="FWK004", record="regFwk004400")
    @Data
    protected abstract Fwk004 ficheiroFwk004() ;
    
    /**
     * @return instancia da classe Fwk006
     */
    @Handler(name="FWK006", record="regFwk006400")
    @Data
    protected abstract Fwk006 ficheiroFwk006() ;
    
    /**
     * @return instancia da classe Fwk008
     */
    @Handler(name="FWK008", record="regFwk008400")
    @Data
    protected abstract Fwk008 ficheiroFwk008() ;
    
    /**
     * @return instancia da classe Fwk010
     */
    @Handler(name="FWK010", record="regFwk010400")
    @Data
    protected abstract Fwk010 ficheiroFwk010() ;
    
    /**
     * @return instancia da classe Fwk012
     */
    @Handler(name="FWK012", record="regFwk012400")
    @Data
    protected abstract Fwk012 ficheiroFwk012() ;
    
    /**
     * @return instancia da classe Fwk808
     */
    @Handler(name="FWK808", record="regFwk808400")
    @Data
    protected abstract Fwk808 ficheiroFwk808() ;
    
    /**
     * @return instancia da classe Fwk809
     */
    @Handler(name="FWK809", record="regFwk809400")
    @Data
    protected abstract Fwk809 ficheiroFwk809() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mimj002a
     */
    @Data
    protected abstract Mimj002a hrMimj002a() ;
    
    /**
     * @return instancia da classe Mimj004a
     */
    @Data
    protected abstract Mimj004a hrMimj004a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    /**
     * @return instancia da classe Mhqj028a
     */
    @Data
    protected abstract Mhqj028a hrMhqj028a() ;
    
    /**
     * @return instancia da classe Mhgj010a
     */
    @Data
    protected abstract Mhgj010a hrMhgj010a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtr0112
     */
    @Data
    protected abstract Bhtr0112 bhtr0112() ;
    
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
     * @return instancia da classe Bimk0002
     */
    @Data
    protected abstract Bimk0002 bimk0002() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bghr1701
     */
    @Data
    protected abstract Bghr1701 bghr1701() ;
    
    /**
     * @return instancia da classe Bghr1702
     */
    @Data
    protected abstract Bghr1702 bghr1702() ;
    
    /**
     * @return instancia da classe Biml002a
     */
    @Data
    protected abstract Biml002a biml002a() ;
    
    /**
     * @return instancia da classe Biml004a
     */
    @Data
    protected abstract Biml004a biml004a() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhql028a
     */
    @Data
    protected abstract Bhql028a bhql028a() ;
    
    /**
     * @return instancia da classe Bhgl010a
     */
    @Data
    protected abstract Bhgl010a bhgl010a() ;
    
    /**
     * AREA DE LIGACAO AH ROTINA MHQJ028A - OBTENCAO DADOS COE
     * AREA DE LIGACAO AH ROTINA MHGJ010A - OBTENCAO CODIGOS PAIS
     * STATUS
     * INICIO WORKING-STORAGE PGHQ171A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK003 = "FWK003" ;
    
    protected static final String CON_FWK004 = "FWK004" ;
    
    protected static final String CON_FWK006 = "FWK006" ;
    
    protected static final String CON_FWK008 = "FWK008" ;
    
    protected static final String CON_FWK010 = "FWK010" ;
    
    protected static final String CON_FWK012 = "FWK012" ;
    
    protected static final String CON_FWK808 = "FWK808" ;
    
    protected static final String CON_FWK809 = "FWK809" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ171A" ;
    
    protected static final String CON_MIMJ002A = "MIMJ002A" ;
    
    protected static final String CON_MIMJ004A = "MIMJ004A" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_ITT = "ITT" ;
    
    protected static final String CON_LU = "LU" ;
    
    protected static final String CON_PROGRAM_DESC = "DIVISAO DO FICH DE INP NOS DIFRNTS FICH DE OUTP" ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     */
    protected static final String CON_001 = "001" ;
    
    protected static final String CON_004 = "004" ;
    
    protected static final String CON_HVB62 = "HVB62" ;
    
    protected static final String CON_X_BALC = "BALC" ;
    
    /**
     * GH1964 - INI
     */
    protected static final String CON_EVE_DD = "ID01" ;
    
    /**
     * GH1964 - FIM
     */
    protected static final String CON_X_MOV = "MOV" ;
    
    protected static final String CON_52 = "52" ;
    
    protected static final String CON_R = "R" ;
    
    protected static final String CON_X_2 = "2" ;
    
    protected static final String CON_X_LUX = "LUX" ;
    
    protected static final String CON_ELFBA = "ELFBA" ;
    
    protected static final String CON_MHYJ230A = "MHYJ230A" ;
    
    protected static final String CON_ERR_ACES_MHYJ230A = "MHYJ230A - ACESSO ROTINA DE DATAS INVALIDO]     " ;
    
    protected static final String CON_MHQJ028A = "MHQJ028A" ;
    
    protected static final String CON_ERR_ACES_MHQJ028A = "MHQJ028A - ACESSO ROTINA OBTENCAO COE COM ERRO] " ;
    
    protected static final String CON_MHGJ010A = "MHGJ010A" ;
    
    protected static final String CON_ERR_ACES_MHGJ010A = "MHGJ010A - ACESSO ROTINA OBTENCAO PAIS COM ERRO]" ;
    
    /**
     * ****              CONSTANTES NUMERICAS                    ****
     */
    protected static final int CON_N1 = 1 ;
    
    protected static final int CON_CDO = 2 ;
    
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
     * ACESSO A ROTINA DE CONSULTA DE TABELAS TIM00002 (MIMJ002A)
     * 
     */
    protected void bimp1002ConsTim00002() {
        hrMimj002a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA DE CONSULTA DA TABELA TIM0004
     * 
     */
    protected void bimp0004ConsTim00004() {
        hrMimj004a().run() ;
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
     * ROTINA DE CONSULTA DE INFORMACAO DE COE'S
     * 
     */
    protected void bhqp5028ConsultaCoe() {
        hrMhqj028a().run() ;
    }
    
    /**
     * 
     * ROTINA MHGJ010A DE OBTENCAO DE
     * CODIGOS DE PAIS NUMERICO/ALFANUMERICO
     * 
     */
    protected void bhgp0010RotCodPais() {
        hrMhgj010a().run() ;
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
        while (!ficheiroFwk003().getStatusOk()) {
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
        m1510OpenFwk003() ;
        m1520OpenFwk004() ;
        m1530OpenFwk006() ;
        m1540OpenFwk008() ;
        m1550OpenFwk010() ;
        m1560OpenFwk012() ;
        /**
         * *GH2027-INI: NOVOS FICHEIROS
         */
        m1580OpenFwk808() ;
        m1590OpenFwk809() ;
        /**
         * *GH2027-INI
         */
        m1570ReadFwk003() ;
    }
    
    /**
     * 
     * 1510-OPEN-FWK003
     * 
     */
    protected void m1510OpenFwk003() {
        log(TraceLevel.Debug, "1510-OPEN-FWK003");
        /**
         * \* ABRE FICHEIRO DE INPUT - FWK003
         */
        ficheiroFwk003().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk003().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-OPEN-FWK003");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1520-OPEN-FWK004
     * 
     */
    protected void m1520OpenFwk004() {
        log(TraceLevel.Debug, "1520-OPEN-FWK004");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK004
         */
        ficheiroFwk004().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK004);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk004().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk004().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK004);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk004().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-OPEN-FWK004");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1530-OPEN-FWK006
     * 
     */
    protected void m1530OpenFwk006() {
        log(TraceLevel.Debug, "1530-OPEN-FWK006");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK006
         */
        ficheiroFwk006().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK006);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk006().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk006().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK006);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk006().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1530-OPEN-FWK006");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1540-OPEN-FWK008
     * 
     */
    protected void m1540OpenFwk008() {
        log(TraceLevel.Debug, "1540-OPEN-FWK008");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK008
         */
        ficheiroFwk008().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK008);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk008().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk008().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK008);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk008().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1540-OPEN-FWK008");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1550-OPEN-FWK010
     * 
     */
    protected void m1550OpenFwk010() {
        log(TraceLevel.Debug, "1550-OPEN-FWK010");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK010
         */
        ficheiroFwk010().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK010);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk010().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk010().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK010);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk010().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1550-OPEN-FWK010");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1560-OPEN-FWK012
     * 
     */
    protected void m1560OpenFwk012() {
        log(TraceLevel.Debug, "1560-OPEN-FWK012");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK012
         */
        ficheiroFwk012().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK012);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk012().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk012().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK012);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk012().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1560-OPEN-FWK012");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * *GH2027-INI: NOVOS FICHEIROS
     * 1580-OPEN-FWK808
     * 
     */
    protected void m1580OpenFwk808() {
        log(TraceLevel.Debug, "1580-OPEN-FWK808");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK808
         */
        ficheiroFwk808().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK808);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk808().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk808().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK808);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk808().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1580-OPEN-FWK808");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1590-OPEN-FWK809
     * 
     */
    protected void m1590OpenFwk809() {
        log(TraceLevel.Debug, "1590-OPEN-FWK809");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FWK809
         */
        ficheiroFwk809().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK809);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk809().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk809().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK809);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk809().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1590-OPEN-FWK809");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * GH2027-FIM
     * 1570-READ-FWK003
     * 
     */
    protected void m1570ReadFwk003() {
        log(TraceLevel.Debug, "1570-READ-FWK003");
        ficheiroFwk003().read(bghr1701().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFwk003().getStatusOk()) {
            wsVariaveis().wsLidosFwk003().add(CON_N1);
        } else if (!ficheiroFwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk003().getStatus());
            /**
             * MOVE '1540-READ-FWK003'
             */
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1570-READ-FWK003");
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
        swStatus().swNmFicheiro().set(" ");
        swStatus().swNmFicheiro().set(bghr1701().registo().nmFicheiro());
        m2100EscreveOutput() ;
        m1570ReadFwk003() ;
    }
    
    /**
     * 
     * 2100-ESCREVE-OUTPUT
     * 
     */
    protected void m2100EscreveOutput() {
        log(TraceLevel.Debug, "2100-ESCREVE-OUTPUT");
        log(TraceLevel.Debug, "-------------------");
        log(TraceLevel.Debug, "SW-NM-FICHEIRO:", swStatus().swNmFicheiro());
        if (swStatus().swV11().isTrue()) {
            m2110ObtemInfoV11() ;
            m2210FormataV11() ;
            m2310EscreveV11() ;
        } else if (swStatus().swV12().isTrue()) {
            m2120ObtemInfoV12() ;
            m2220FormataV12() ;
            m2320EscreveV12() ;
        } else if (swStatus().swV17().isTrue()) {
            m2130ObtemInfoV17() ;
            m2230FormataV17() ;
            m2330EscreveV17() ;
        } else if (swStatus().swV13().isTrue()) {
            m2140ObtemInfoV13() ;
            m2240FormataV13() ;
            m2340EscreveV13() ;
        } else if (swStatus().swV15().isTrue()) {
            m2150ObtemInfoV15() ;
            m2250FormataV15() ;
            m2350EscreveV15() ;
        } else if (swStatus().swV111().isTrue()) {
            m2160ObtemInfoV111() ;
            m2260FormataV111() ;
            m2360EscreveV111() ;
        } else if (swStatus().swV112().isTrue()) {
            if (bghr1701().registo().cTipoCanlAces().isEqual(Pghq171a.CON_CDO)) {
                m2170ObtemInfoV112() ;
                m2270FormataV112() ;
                if (bghr1701().registo().subconta().cPaisIsoaCont().isEqual(CON_LU)) {
                    m2370EscreveV112() ;
                }
            }
        } else {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2100-ESCREVE-OUTPUT");
            bhtw0030().dadosEntrada().nmPrgChmd().set(" ");
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(" ");
            bhtw0030().dadosEntrada().xCteuAlig().get(1, 16).set("SW-NM-FICHEIRO: ") ;
            bhtw0030().dadosEntrada().xCteuAlig().get(17, 6).set(swStatus().swNmFicheiro()) ;
            bhtw0030().dadosEntrada().cSqlcode().set("0");
            bhtw0030().dadosEntrada().nmTabela().set(" ");
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2110-OBTEM-INFO-V11
     * DESC: OBTEM DETALHE V11
     * 
     */
    protected void m2110ObtemInfoV11() {
        log(TraceLevel.Debug, "2110-OBTEM-INFO-V11");
        if (bghr1701().registo().iGrazCoe().isEqual(bhok0002().BHOK0002_CON_S)) {
            m2111ObtemDataJuliana() ;
            m2113ObtemDadosCoe() ;
            m2115ObtemPaisX2() ;
        } else {
            log(TraceLevel.Debug, "NAO TEM GERACAO COE]");
            log(TraceLevel.Debug, "FHT011-C-PAIS-CONTXT.. ", bhtr0112().fht011Registo().fht011CPaisContxt());
            wsVariaveis().wsCPaisIsoAlfn().set(bhtr0112().fht011Registo().fht011CPaisContxt());
        }
    }
    
    /**
     * 
     * 2111-OBTEM-DATA-JULIANA
     * 
     */
    protected void m2111ObtemDataJuliana() {
        log(TraceLevel.Debug, "2111-OBTEM-DATA-JULIANA");
        log(TraceLevel.Debug, ":BGHR1701-Z-MOVIMENTO..: ", bghr1701().registo().zMovimento());
        bhyl230a().commarea().initialize() ;
        wsVariaveis().wsDataJuliana().set(" ");
        wsVariaveis().wsData().set(bghr1701().registo().zMovimento());
        wsVariaveis().wsDataJuliana().get(1, 2).set(wsVariaveis().wsData().wsAno().get(3, 2)) ;
        bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(CON_52);
        wsVariaveis().wsXCteuMhyj230a().wsCFunzMdloMhyj230a().set(CON_52);
        wsVariaveis().wsXCteuMhyj230a().wsITipoExeMhyj230a().set(CON_R);
        bhyl230a().commarea().dadosEntrada().reduzido().setTrue() ;
        bhyl230a().commarea().dadosEntrada().datInput1().set(wsVariaveis().wsData());
        wsVariaveis().wsXCteuMhyj230a().wsDatInput1Mhyj230a().set(wsVariaveis().wsData());
        bhyp0200RotinaDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MHYJ230A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhyl230a().commarea().dadosSaida().aAplErr());
        if (bhyl230a().commarea().dadosSaida().estado().semErros().isTrue()) {
            wsVariaveis().wsDataJuliana().get(3, 3).set(bhyl230a().commarea().dadosSaida().zOutpJuln().get(4, 3)) ;
            log(TraceLevel.Debug, "::BHYL230A-Z-OUTP-JULN..: ", bhyl230a().commarea().dadosSaida().zOutpJuln());
            log(TraceLevel.Debug, "::WS-DATA-JULIANA.......: ", wsVariaveis().wsDataJuliana());
        } else {
            bhtw0030().dadosEntrada().nmPrograma().set(CON_MHYJ230A);
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhyl230a().commarea().dadosSaida().estado().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhyl230a().commarea().dadosSaida().estado().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(wsVariaveis().wsXCteuMhyj230a());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_NOME_PROGRAMA);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERR_ACES_MHYJ230A);
        }
    }
    
    /**
     * 
     * 2113-OBTEM-DADOS-COE
     * 
     */
    protected void m2113ObtemDadosCoe() {
        log(TraceLevel.Debug, "2113-OBTEM-DADOS-COE");
        bhql028a().commarea().initialize() ;
        wsVariaveis().wsCPaisIsoAlf3().set(" ");
        bhql028a().commarea().dadosEntrada().swIConsultaConta().setTrue() ;
        if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_CREDITO)) {
            bhql028a().commarea().dadosEntrada().swIMovimentoC().setTrue() ;
        } else {
            bhql028a().commarea().dadosEntrada().swIMovimentoD().setTrue() ;
        }
        bhql028a().commarea().dadosEntrada().cPaisIsoCoeI().set(bghr1701().registo().cPaisIsoaGerx());
        bhql028a().commarea().dadosEntrada().cBancRsplOpetI().set(bghr1701().registo().cBancGcxGerx());
        wsVariaveis().wsNRefOpetBpor().wsCAplic().set(bghr1701().registo().aAplicacao());
        wsVariaveis().wsNRefOpetBpor().wsCUserId().set(bghr1701().registo().cUserid());
        wsVariaveis().wsNRefOpetBpor().wsDataJul().set(wsVariaveis().wsDataJuliana());
        wsVariaveis().wsNJourBbnN().set(bghr1701().registo().nJourBbn());
        wsVariaveis().wsNRefOpetBpor().wsNJourBbn().set(wsVariaveis().wsNJourBbnR().wsNJourBbnX());
        bhql028a().commarea().dadosEntrada().nRefOpetBporI().set(wsVariaveis().wsNRefOpetBpor());
        bhql028a().commarea().dadosEntrada().nsOpetI().set(0);
        bhql028a().commarea().dadosEntrada().cPaisIsoaCont().set(bghr1701().registo().subconta().cPaisIsoaCont());
        bhql028a().commarea().dadosEntrada().cBancCont().set(bghr1701().registo().subconta().cBancCont());
        bhql028a().commarea().dadosEntrada().cOeEgcCont().set(bghr1701().registo().subconta().cOeEgcCont());
        bhql028a().commarea().dadosEntrada().nsRdclCont().set(bghr1701().registo().subconta().nsRdclCont());
        bhql028a().commarea().dadosEntrada().vChkdCont().set(bghr1701().registo().subconta().vChkdCont());
        bhql028a().commarea().dadosEntrada().cTipoCont().set(bghr1701().registo().subconta().cTipoCont());
        bhql028a().commarea().dadosEntrada().cMoedIsoScta().set(bghr1701().registo().subconta().cMoedIsoScta());
        bhql028a().commarea().dadosEntrada().nsDeposito().set(bghr1701().registo().subconta().nsDeposito());
        bhqp5028ConsultaCoe() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhql028a().cMhqj028a());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhql028a().commarea().dadosErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhql028a().commarea().dadosErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhql028a().commarea().dadosErro().aAplErr());
        if (bhql028a().commarea().dadosErro().semErros().isTrue()) {
            wsVariaveis().wsCPaisIsoAlf3().set(bhql028a().commarea().dadosOutput().get(1).cPaisIsoAlf3());
            log(TraceLevel.Debug, "::BHQL028A-C-PAIS-ISO-ALF3(1): ", bhql028a().commarea().dadosOutput().get(1).cPaisIsoAlf3());
            log(TraceLevel.Debug, "::WS-C-PAIS-ISO-ALF3.........: ", wsVariaveis().wsCPaisIsoAlf3());
        } else if (bhql028a().commarea().dadosErro().erroFuncao().isTrue() && bhql028a().commarea().dadosErro().coeNaoExiste().isTrue()) {
            wsVariaveis().wsCPaisIsoAlf3().set(CON_X_LUX);
            log(TraceLevel.Debug, "::COE NOTFND MHQJ028A");
            log(TraceLevel.Debug, "::WS-C-PAIS-ISO-ALF3.........: ", wsVariaveis().wsCPaisIsoAlf3());
        } else {
            bhtw0030().dadosEntrada().nmPrograma().set(CON_MHQJ028A);
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhql028a().commarea().dadosErro().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhql028a().commarea().dadosErro().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhql028a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_NOME_PROGRAMA);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhql028a().commarea().dadosErro().cTipoErroBbn());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERR_ACES_MHQJ028A);
        }
    }
    
    /**
     * 
     * 2115-OBTEM-PAIS-X2
     * 
     */
    protected void m2115ObtemPaisX2() {
        log(TraceLevel.Debug, "2115-OBTEM-PAIS-X2");
        bhgl010a().commarea().initialize() ;
        wsVariaveis().wsCPaisIsoAlfn().set(" ");
        bhgl010a().commarea().dadosInput().indTipoCodPais().set(CON_X_2);
        wsVariaveis().wsXCteuMhgj010a().wsTipoCodPaisMhgj010a().set(CON_X_2);
        bhgl010a().commarea().dadosInput().codPais().set(wsVariaveis().wsCPaisIsoAlf3());
        wsVariaveis().wsXCteuMhgj010a().wsCodPaisMhgj010a().set(wsVariaveis().wsCPaisIsoAlf3());
        bhgp0010RotCodPais() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MHGJ010A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhgl010a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhgl010a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhgl010a().commarea().dadosOutput().aAplErr());
        if (bhgl010a().commarea().dadosOutput().semErros().isTrue()) {
            wsVariaveis().wsCPaisIsoAlfn().set(bhgl010a().commarea().dadosOutput().cPaisIsoAlfn());
            log(TraceLevel.Debug, "::BHGL010A-C-PAIS-ISO-ALFN.: ", bhgl010a().commarea().dadosOutput().cPaisIsoAlfn());
            log(TraceLevel.Debug, "::WS-C-PAIS-ISO-ALFN.......: ", wsVariaveis().wsCPaisIsoAlfn());
        } else {
            bhtw0030().dadosEntrada().nmPrograma().set(CON_MHGJ010A);
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhgl010a().commarea().dadosOutput().sqlca().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhgl010a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(wsVariaveis().wsXCteuMhgj010a());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_NOME_PROGRAMA);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhgl010a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERR_ACES_MHGJ010A);
        }
    }
    
    /**
     * 
     * 2120-OBTEM-INFO-V12
     * DESC: OBTEM DETALHE V12
     * 
     */
    protected void m2120ObtemInfoV12() {
        log(TraceLevel.Debug, "2120-OBTEM-INFO-V12");
        if (bghr1701().registo().iGrazCoe().isEqual(bhok0002().BHOK0002_CON_S)) {
            m2111ObtemDataJuliana() ;
            m2113ObtemDadosCoe() ;
            m2115ObtemPaisX2() ;
        } else {
            log(TraceLevel.Debug, "NAO TEM GERACAO COE]");
            log(TraceLevel.Debug, "FHT011-C-PAIS-CONTXT.. ", bhtr0112().fht011Registo().fht011CPaisContxt());
            wsVariaveis().wsCPaisIsoAlfn().set(bhtr0112().fht011Registo().fht011CPaisContxt());
        }
    }
    
    /**
     * 
     * 2130-OBTEM-INFO-V17
     * DESC: OBTEM DETALHE V17
     * 
     */
    protected void m2130ObtemInfoV17() {
        log(TraceLevel.Debug, "2130-OBTEM-INFO-V17");
    }
    
    /**
     * 
     * 2140-OBTEM-INFO-V13
     * DESC: OBTEM DETALHE V13
     * 
     */
    protected void m2140ObtemInfoV13() {
        log(TraceLevel.Debug, "2140-OBTEM-INFO-V13");
    }
    
    /**
     * 
     * 2150-OBTEM-INFO-V15
     * DESC: OBTEM DETALHE V15
     * 
     */
    protected void m2150ObtemInfoV15() {
        log(TraceLevel.Debug, "2151-OBTEM-INFO-TIM0002");
        m2151ObtemInfoTim0002() ;
        if (biml002a().commarea().dadosErro().semErros().isTrue() && bimk0002().swSqlcode().swVim00201Ok().isTrue()) {
            /**
             * *PROJ GH1926 - INI
             */
            m2152ConverteInput() ;
            /**
             * *PROJ GH1926 - FIM
             */
            m2152ObtemInfoTim0004() ;
            m2115ObtemPaisX2() ;
        }
    }
    
    /**
     * 
     * 2151-OBTEM-INFO-TIM0002
     * DESC: OBTEM INFO TIM0002
     * 
     */
    protected void m2151ObtemInfoTim0002() {
        log(TraceLevel.Debug, "2151-OBTEM-INFO-TIM0002");
        biml002a().commarea().dadosInput().iModoAcesso().set("A");
        biml002a().commarea().dadosInput().cPaisIsaCtaMovIn().set(bghr1701().registo().subconta().cPaisIsoaCont());
        biml002a().commarea().dadosInput().cBancContMovIn().set(bghr1701().registo().subconta().cBancCont());
        biml002a().commarea().dadosInput().cOeEgcContMovIn().set(bghr1701().registo().subconta().cOeEgcCont());
        biml002a().commarea().dadosInput().nsRdclContMovIn().set(bghr1701().registo().subconta().nsRdclCont());
        biml002a().commarea().dadosInput().vChkdContMovIn().set(bghr1701().registo().subconta().vChkdCont());
        biml002a().commarea().dadosInput().cTipoContMovIn().set(bghr1701().registo().subconta().cTipoCont());
        biml002a().commarea().dadosInput().cMoeIsoSctaMovIn().set(bghr1701().registo().subconta().cMoedIsoScta());
        biml002a().commarea().dadosInput().zValorIn().set(bghr1701().registo().zValor());
        biml002a().commarea().dadosInput().nJourBbnIn().set(bghr1701().registo().nJourBbn());
        biml002a().commarea().dadosInput().mMovimentoIn().set(bghr1701().registo().mMovimento());
        biml002a().commarea().dadosInput().cEvenOpelIn().set(bghr1701().registo().cEvenOpel());
        biml002a().commarea().dadosOutput().initialize() ;
        bimp1002ConsTim00002() ;
        log(TraceLevel.Debug, "BIML002A-C-TIPO-TERM-CETR ", biml002a().commarea().dadosOutput().cTipoTermCetr());
        log(TraceLevel.Debug, "BIML002A-C-CATG-OPE-CETR  ", biml002a().commarea().dadosOutput().cCatgOpeCetr());
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MIMJ002A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(biml002a().commarea().dadosErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(biml002a().commarea().dadosErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(biml002a().commarea().dadosErro().aAplErr());
        bhop0013FormataAcesso() ;
        bimk0002().swSqlcode().swSqlcodeVim00201().set(biml002a().commarea().dadosErro().cSqlcode());
        if (!biml002a().commarea().dadosErro().semErros().isTrue() && !biml002a().commarea().dadosErro().fimConsulta().isTrue() && 
            !biml002a().commarea().dadosErro().erroFuncao().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(biml002a().commarea().dadosErro().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(biml002a().commarea().dadosErro().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MIMJ002A);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(biml002a().commarea().dadosErro().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(biml002a().commarea().dadosInput());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(biml002a().commarea().dadosErro().cRtnoEvenSwal());
            m9900Abend() ;
        } else {
            log(TraceLevel.Debug, "BIMK0002-SW-SQLCODE-VIM00201 : ", bimk0002().swSqlcode().swSqlcodeVim00201());
            log(TraceLevel.Debug, "BIML002A-C-SQLCODE           : ", biml002a().commarea().dadosErro().cSqlcode());
            log(TraceLevel.Debug, "BIML002A-NM-TABELA           : ", biml002a().commarea().dadosErro().nmTabela());
            log(TraceLevel.Debug, "CON-MIMJ002A                 : ", CON_MIMJ002A);
            log(TraceLevel.Debug, "BIML002A-C-TIPO-ERRO-BBN     : ", biml002a().commarea().dadosErro().cTipoErroBbn());
            log(TraceLevel.Debug, "BIML002A-DADOS-INPUT         : ", biml002a().commarea().dadosInput());
            log(TraceLevel.Debug, "BIML002A-C-RTNO-EVEN-SWAL    : ", biml002a().commarea().dadosErro().cRtnoEvenSwal());
            if (bimk0002().swSqlcode().swVim00201Notfnd().isTrue()) {
                bhtw0030().dadosEntrada().cSqlcode().set(biml002a().commarea().dadosErro().cSqlcode());
                bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
                bhtw0030().dadosEntrada().nmTabela().set(biml002a().commarea().dadosErro().nmTabela());
                bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MIMJ002A);
                bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(biml002a().commarea().dadosErro().cTipoErroBbn());
                bhtw0030().dadosEntrada().xCteuAlig().set(biml002a().commarea().dadosInput());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(biml002a().commarea().dadosErro().cRtnoEvenSwal());
                m9900Abend() ;
            } else if (bimk0002().swSqlcode().swVim00201Ok().isTrue()) {
                /**
                 * GUARDAMOS O PAIS DE 3 PARA IR OBTER O PAIS DE 2
                 */
                wsVariaveis().wsCPaisIsoAlf3().set(" ");
                wsVariaveis().wsCPaisIsoAlf3().set(biml002a().commarea().dadosOutput().cPaisIsoaOpe());
            }
        }
    }
    
    /**
     * 
     * PROJ GH1926 - INI
     * 2152-CONVERTE-INPUT
     * 
     */
    protected void m2152ConverteInput() {
        log(TraceLevel.Debug, "2152-CONVERTE-INPUT    ");
        wsVariaveis().wsZValidade().set(" ");
        wsVariaveis().wsDtT04().wsAnomesT04().set(biml002a().commarea().dadosOutput().zpExpzCart());
        m2051CalculaUltimoDia() ;
        wsVariaveis().wsZValidade().set(wsVariaveis().wsDataPass());
        log(TraceLevel.Debug, "WS-Z-VALIDADE :", wsVariaveis().wsZValidade());
    }
    
    /**
     * 
     * 2051-CALCULA-ULTIMO-DIA
     * 
     */
    protected void m2051CalculaUltimoDia() {
        log(TraceLevel.Debug, "2051-CALCULA-ULTIMO-DIA");
        bhyl230a().commarea().initialize() ;
        bhyl230a().commarea().dadosEntrada().cPaisIsoAlfn().set(biml002a().commarea().dadosOutput().cPaisIsoaOeOpx());
        bhyl230a().commarea().dadosEntrada().cMnemEmpGcx().set(biml002a().commarea().dadosOutput().cMnemEgcOpex());
        /**
         * CALCULA ULTIMO DIA DO MES
         */
        bhyl230a().commarea().dadosEntrada().cFunzMdloData().set("09");
        wsVariaveis().wsDtT06().set(wsVariaveis().wsDtT04());
        wsVariaveis().wsDtTemp().wsAnoT06().set(wsVariaveis().wsDtT06().wsAnoT06());
        wsVariaveis().wsDtTemp().wsMesT06().set(wsVariaveis().wsDtT06().wsMesT06());
        wsVariaveis().wsDtT8().set(wsVariaveis().wsDtTemp());
        wsVariaveis().wsDtT10().wsAnoT().set(wsVariaveis().wsDtT8().wsAnoT());
        wsVariaveis().wsDtT10().wsMesT().set(wsVariaveis().wsDtT8().wsMesT());
        wsVariaveis().wsDtT10().wsDiaT().set(wsVariaveis().wsDtT8().wsDiaT());
        wsVariaveis().wsDataPass().set(wsVariaveis().wsDtT10());
        bhyl230a().commarea().dadosEntrada().datInput1().set(wsVariaveis().wsDataPass());
        bhyl230a().commarea().dadosEntrada().reduzido().setTrue() ;
        bhyp0200RotinaDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("MHYJ230A");
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhyl230a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhyl230a().commarea().dadosSaida().estado().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhyl230a().commarea().dadosSaida().estado().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhyl230a().commarea().dadosSaida().estado().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set("MHYJ230A");
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
            m9900Abend() ;
        } else {
            wsVariaveis().wsDataPass().set(bhyl230a().commarea().dadosSaida().zOutput());
        }
    }
    
    /**
     * 
     * 2152-OBTEM-INFO-TIM0004
     * 
     */
    protected void m2152ObtemInfoTim0004() {
        log(TraceLevel.Debug, "2152-OBTEM-INFO-TIM0004");
        biml004a().commarea().initialize() ;
        biml004a().commarea().dadosInput().cTim00004().setTrue() ;
        biml004a().commarea().dadosInput().nCartCluIn().set(biml002a().commarea().dadosOutput().nCartClu());
        biml004a().commarea().dadosInput().zVldeCart().set(wsVariaveis().wsZValidade());
        biml004a().commarea().dadosInput().nsRemzCartClu().set(biml002a().commarea().dadosOutput().nsRemzCartClu());
        log(TraceLevel.Debug, "BIML004A-I-DEBUG : ", biml004a().commarea().dadosInput().iDebug());
        log(TraceLevel.Debug, "BIML004A-N-CART-CLU-IN : ", biml004a().commarea().dadosInput().nCartCluIn());
        log(TraceLevel.Debug, "BIML004A-Z-VLDE-CART : ", biml004a().commarea().dadosInput().zVldeCart());
        log(TraceLevel.Debug, "BIML004A-NS-REMZ-CART-CLU : ", biml004a().commarea().dadosInput().nsRemzCartClu());
        bimp0004ConsTim00004() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MIMJ004A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(biml004a().commarea().dadosErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(biml004a().commarea().dadosErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(biml004a().commarea().dadosErro().aAplErr());
        bhop0013FormataAcesso() ;
        if (!biml004a().commarea().dadosErro().semErros().isTrue() && 
            (!biml004a().commarea().dadosErro().erroFuncao().isTrue() || !biml004a().commarea().dadosErro().regInexistente().isTrue())) {
            bhtw0030().dadosEntrada().cSqlcode().set(biml004a().commarea().dadosErro().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(biml004a().commarea().dadosErro().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MIMJ004A);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(biml004a().commarea().dadosErro().cTipoErroBbn());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(biml004a().commarea().dadosErro().cRtnoEvenSwal());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2152-OBTEM-INFO-TIM0004
     * DESC: OBTEM INFO TIM0004
     * *2152-OBTEM-INFO-TIM0004.
     * IF SW-DEBUG-SIM
     * DISPLAY '2152-OBTEM-INFO-TIM0004'
     * END-IF.
     * MOVE SW-DEBUG                 TO BIML004A-I-DEBUG.
     * MOVE 'B'                      TO BIML004A-I-MODO-ACESSO.
     * MOVE BIML002A-C-PAIS-ISOA-PRCT
     * TO
     * BIML004A-C-PAIS-ISOA-PRCT-IN
     * MOVE BIML002A-C-BANC-PRCT       TO BIML004A-C-BANC-PRCT-IN
     * MOVE BIML002A-C-PAIS-ISA-CTA-MOV
     * BIML004A-C-PAIS-ISOA-CONT-IN
     * MOVE BIML002A-C-BANC-CONT-MOV   TO BIML004A-C-BANC-CONT-IN
     * MOVE BIML002A-C-OE-EGC-CONT-MOV TO BIML004A-C-OE-EGC-CONT-IN
     * MOVE BIML002A-NS-RDCL-CONT-MOV  TO BIML004A-NS-RDCL-CONT-IN
     * MOVE BIML002A-V-CHKD-CONT-MOV   TO BIML004A-V-CHKD-CONT-IN
     * MOVE BIML002A-C-TIPO-CONT-MOV   TO BIML004A-C-TIPO-CONT-IN
     * MOVE BIML002A-C-MOE-ISO-SCTA-MOV
     * BIML004A-C-MOED-ISO-SCTA-IN
     * MOVE BIML002A-NS-DEP-SCTA-MOV   TO BIML004A-NS-DEP-SCTA-IN
     * MOVE BIML002A-N-CART-CLU        TO BIML004A-N-CART-CLU-IN
     * INITIALIZE BIML004A-DADOS-OUTPUT REPLACING
     * ALPHANUMERIC          BY SPACES
     * NUMERIC               BY ZEROS
     * PERFORM BIMP0004-CONS-TIM00004
     * THRU BIMP0004-CONS-TIM00004-EXIT
     * DISPLAY 'BIML004A-C-TIPO-CART-CETR '
     * BIML004A-C-TIPO-CART-CETR
     * FORMATA ESTATISTICA
     * SET BHOW0013-ROTINA           TO TRUE
     * MOVE CON-MIMJ004A             TO BHOW0013-NM-ROTINA
     * MOVE CON-CONSULTA             TO BHOW0013-I-OPERACAO
     * SET BHOW0013-SW-SELECT        TO TRUE
     * MOVE BIML004A-C-TIPO-ERRO-BBN TO BHOW0013-C-TIPO-ERRO-BBN
     * MOVE BIML004A-C-RTNO-EVEN-SWAL
     * TO BHOW0013-C-RTNO-EVEN-SWAL
     * MOVE BIML004A-A-APL-ERR       TO BHOW0013-A-APL-ERR
     * PERFORM BHOP0013-FORMATA-ACESSO
     * THRU BHOP0013-FORMATA-ACESSO-EXIT
     * MOVE BIML004A-C-SQLCODE       TO
     * BIMK0002-SW-SQLCODE-VIM00401
     * IF NOT BIML004A-SEM-ERROS
     * AND NOT BIML004A-FIM-CONSULTA
     * AND NOT BIML004A-ERRO-FUNCAO
     * MOVE BIML004A-C-SQLCODE    TO BHTW0030-C-SQLCODE
     * MOVE BHOW0013-C-TIPO-OPE-OBJ-DB2
     * BHTW0030-C-TIPO-OPE-OBJ-DB2
     * MOVE BIML004A-NM-TABELA    TO BHTW0030-NM-TABELA
     * MOVE CON-MIMJ004A          TO BHTW0030-NM-PRG-CHMD
     * MOVE BIML004A-C-TIPO-ERRO-BBN
     * BHTW0030-C-TIPO-ERR-PRG-CHMD
     * MOVE BIML004A-DADOS-INPUT
     * TO BHTW0030-X-CTEU-ALIG
     * TO BHTW0030-X-SUG-RTNO-SWAL
     * PERFORM 9900-ABEND
     * THRU 9900-ABEND-EXIT
     * ELSE
     * DISPLAY 'BIMK0002-SW-SQLCODE-VIM00401 : '
     * DISPLAY 'BIML004A-C-SQLCODE           : '
     * BIML004A-C-SQLCODE
     * DISPLAY 'BIML004A-NM-TABELA           : '
     * BIML004A-NM-TABELA
     * DISPLAY 'CON-MIMJ004A                 : '
     * CON-MIMJ004A
     * DISPLAY 'BIML004A-C-TIPO-ERRO-BBN     : '
     * BIML004A-C-TIPO-ERRO-BBN
     * DISPLAY 'BIML004A-DADOS-INPUT         : '
     * BIML004A-DADOS-INPUT
     * DISPLAY 'BIML004A-C-RTNO-EVEN-SWAL    : '
     * BIML004A-C-RTNO-EVEN-SWAL
     * END-IF
     * IF BIMK0002-SW-VIM00401-NOTFND
     * MOVE BIML004A-C-SQLCODE   TO BHTW0030-C-SQLCODE
     * MOVE BIML004A-NM-TABELA   TO BHTW0030-NM-TABELA
     * MOVE CON-MIMJ004A         TO BHTW0030-NM-PRG-CHMD
     * *2152-OBTEM-INFO-TIM0004-EXIT.
     * EXIT.
     * PROJ GH1926 - FIM
     * *GH2027-INI: NOVOS FICHEIROS
     * 2160-OBTEM-INFO-V111
     * DESC: OBTEM DETALHE V111
     * 
     */
    protected void m2160ObtemInfoV111() {
        log(TraceLevel.Debug, "2160-OBTEM-INFO-V111");
    }
    
    /**
     * 
     * 2170-OBTEM-INFO-V112
     * DESC: OBTEM DETALHE V112
     * 
     */
    protected void m2170ObtemInfoV112() {
        log(TraceLevel.Debug, "2170-OBTEM-INFO-V112");
        if (bghr1701().registo().iGrazCoe().isEqual(bhok0002().BHOK0002_CON_S)) {
            m2111ObtemDataJuliana() ;
            m2113ObtemDadosCoe() ;
            m2115ObtemPaisX2() ;
        } else {
            log(TraceLevel.Debug, "NAO TEM GERACAO COE]");
            log(TraceLevel.Debug, "FHT011-C-PAIS-CONTXT.. ", bhtr0112().fht011Registo().fht011CPaisContxt());
            wsVariaveis().wsCPaisIsoAlfn().set(bhtr0112().fht011Registo().fht011CPaisContxt());
        }
    }
    
    /**
     * 
     * *GH2027-FIM
     * 2210-FORMATA-V11
     * DESC: FORMATAR OS CAMPOS DO OUTPUT
     * 
     */
    protected void m2210FormataV11() {
        log(TraceLevel.Debug, "2210-FORMATA-V11");
        bghr1702().registo().componentComum().initialize() ;
        if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_DEBITO)) {
            bghr1702().registo().detalheV11().iTipMov1V11().setTrue() ;
        } else {
            bghr1702().registo().detalheV11().iTipMov2V11().setTrue() ;
        }
        bghr1702().registo().detalheV11().zOperacaoV11().get(1, 4).set(bghr1701().registo().zMovimento().get(1, 4)) ;
        bghr1702().registo().detalheV11().zOperacaoV11().get(5, 2).set(bghr1701().registo().zMovimento().get(6, 2)) ;
        bghr1702().registo().detalheV11().zOperacaoV11().get(7, 2).set(bghr1701().registo().zMovimento().get(9, 2)) ;
        if (bghr1702().registo().detalheV11().iTipMov1V11().isTrue()) {
            bghr1702().registo().detalheV11().cTipPagmtoVireV11().setTrue() ;
        } else if (bghr1702().registo().detalheV11().iTipMov2V11().isTrue()) {
            if (bghr1701().registo().aAplicacao().isEqual(bhok0002().BHOK0002_APLIC_OPERATIVA) && 
                (bghr1701().registo().cOpczMenu().isEqual(CON_001) || 
                bghr1701().registo().cOpczMenu().isEqual(CON_004))) {
                bghr1702().registo().detalheV11().cTipPagmtoVersV11().setTrue() ;
            } else {
                bghr1702().registo().detalheV11().cTipPagmtoVireV11().setTrue() ;
            }
        } else {
            bghr1702().registo().detalheV11().cTipPagmtoV11().set(" ");
        }
        bghr1702().registo().detalheV11().customerCatgV11().set("ANIF");
        /**
         * SET BGHR1702-C-TIP-LQZ-PAG-AUT-V11
         * TO TRUE.
         */
        if (bghr1702().registo().detalheV11().iTipMov1V11().isTrue()) {
            bghr1702().registo().detalheV11().cTipLqzPagOnsV11().setTrue() ;
        }
        if (bghr1702().registo().detalheV11().iTipMov2V11().isTrue()) {
            /**
             * AND BGHR1701-A-APLICACAO EQUAL BHOK0002-APLIC-OPERATIVA
             * AND (BGHR1701-C-OPCZ-MENU EQUAL CON-001
             * OR BGHR1701-C-OPCZ-MENU EQUAL CON-004)
             */
            if (bghr1702().registo().detalheV11().cTipPagmtoVireV11().isTrue()) {
                bghr1702().registo().detalheV11().cTipLqzPagOnsV11().setTrue() ;
            } else {
                bghr1702().registo().detalheV11().cTipLqzPagCasV11().setTrue() ;
            }
        }
        /**
         * IF BGHR1701-X-REF-MOV(1:3) EQUAL CON-X-MOV
         * SET BGHR1702-C-TIP-LQZ-PAG-NOL-V11
         * TO TRUE
         * END-IF.
         */
        bghr1702().registo().detalheV11().cTipClienteV11().set(" ");
        if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_DEBITO)) {
            bghr1702().registo().detalheV11().cTipDirMovEmiV11().setTrue() ;
        } else if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_CREDITO)) {
            bghr1702().registo().detalheV11().cTipDirMovRecV11().setTrue() ;
        } else {
            bghr1702().registo().detalheV11().cTipDirMovV11().set(" ");
        }
        if (bghr1702().registo().detalheV11().cTipLqzPagSt2V11().isTrue()) {
            bghr1702().registo().detalheV11().iMovSepaOV11().setTrue() ;
        } else {
            bghr1702().registo().detalheV11().iMovSepaNV11().setTrue() ;
        }
        /**
         * IF BGHR1701-C-TIPO-CANL-ACES EQUAL CON-X-BALC
         * SET BGHR1702-I-FORM-PAPEL-O-V11
         * TO TRUE
         * ELSE
         * SET BGHR1702-I-FORM-PAPEL-N-V11
         * END-IF.
         */
        swStatus().swCanlAcesBalc().set(bghr1701().registo().cTipoCanlAces());
        if (swStatus().swCanlAcesBalcS().isTrue()) {
            bghr1702().registo().detalheV11().cOrigOrdemPpV11().setTrue() ;
        } else {
            bghr1702().registo().detalheV11().cOrigOrdemSwV11().setTrue() ;
        }
        bghr1702().registo().detalheV11().cPaisDestOperV11().set(wsVariaveis().wsCPaisIsoAlfn());
        bghr1702().registo().detalheV11().cPaisOrigOperV11().set(bghr1701().registo().cPaisIsoaOeOpx());
        bghr1702().registo().detalheV11().qVolumeRegV11().set(CON_N1);
        bghr1702().registo().detalheV11().mMovimentoV11().set(bghr1701().registo().mMovimento());
        bghr1702().registo().detalheV11().mMovFillerV11().set(0);
        /**
         * GH1303 - INICIO
         * IF BGHR1701-M-MOVIMENTO LESS THAN ZEROS
         * SET BGHR1702-I-MOVIMENTO-NEG-V11
         * TO TRUE
         * ELSE
         * SET BGHR1702-I-MOVIMENTO-POS-V11
         * END-IF.
         * SET BGHR1702-CUSTM-CATG-V11-INCO
         * TO TRUE.
         */
        bghr1702().registo().detalheV11().typeRTransV11().set(" ");
        /**
         * GH1303 - FIM
         * MOVE BGHR1701-C-MOED-ISO-ORI-MOV
         */
        bghr1702().registo().detalheV11().cMoedMovV11().set(bghr1701().registo().subconta().cMoedIsoScta());
        bghr1702().registo().detalheV11().xDescritivoV11().set(" ");
    }
    
    /**
     * 
     * 2220-FORMATA-V12
     * DESC: FORMATAR OS CAMPOS DO OUTPUT
     * 
     */
    protected void m2220FormataV12() {
        log(TraceLevel.Debug, "2220-FORMATA-V12");
        bghr1702().registo().componentComum().initialize() ;
        if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_DEBITO)) {
            bghr1702().registo().detalheV12().iTipMov1V12().setTrue() ;
        } else {
            bghr1702().registo().detalheV12().iTipMov2V12().setTrue() ;
        }
        bghr1702().registo().detalheV12().zOperacaoV12().get(1, 4).set(bghr1701().registo().zMovimento().get(1, 4)) ;
        bghr1702().registo().detalheV12().zOperacaoV12().get(5, 2).set(bghr1701().registo().zMovimento().get(6, 2)) ;
        bghr1702().registo().detalheV12().zOperacaoV12().get(7, 2).set(bghr1701().registo().zMovimento().get(9, 2)) ;
        bghr1702().registo().detalheV12().cTipPagmtoVireV12().setTrue() ;
        bghr1702().registo().detalheV12().cTipLqzPagTarV12().setTrue() ;
        bghr1702().registo().detalheV12().cTipClienteBalV12().setTrue() ;
        if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_DEBITO)) {
            bghr1702().registo().detalheV12().cTipDirMovEmiV12().setTrue() ;
        } else if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_CREDITO)) {
            bghr1702().registo().detalheV12().cTipDirMovRecV12().setTrue() ;
        } else {
            bghr1702().registo().detalheV12().cTipDirMovV12().set(" ");
        }
        bghr1702().registo().detalheV12().iMovSepaNV12().setTrue() ;
        bghr1702().registo().detalheV12().iFormPapelOV12().setTrue() ;
        bghr1702().registo().detalheV12().cPaisDestOperV12().set(wsVariaveis().wsCPaisIsoAlfn());
        /**
         * MOVE BGHR1701-C-PAIS-ISOA-OE-OPX
         * TO
         * BGHR1702-C-PAIS-ORIG-OPER-V12
         */
        bghr1702().registo().detalheV12().qVolumeRegV12().set(CON_N1);
        bghr1702().registo().detalheV12().mMovimentoV12().set(bghr1701().registo().mMovimento());
        bghr1702().registo().detalheV12().mMovFillerV12().set(0);
        /**
         * GH1303 - INICIO
         * IF BGHR1701-M-MOVIMENTO LESS THAN ZEROS
         * SET BGHR1702-I-MOVIMENTO-NEG-V12
         * TO TRUE
         * ELSE
         * SET BGHR1702-I-MOVIMENTO-POS-V12
         * END-IF.
         * GH1303 - FIM
         * MOVE BGHR1701-C-MOED-ISO-ORI-MOV
         */
        bghr1702().registo().detalheV12().cMoedMovV12().set(bghr1701().registo().subconta().cMoedIsoScta());
        bghr1702().registo().detalheV12().xDescritivoV12().set(" ");
    }
    
    /**
     * 
     * 2230-FORMATA-V17
     * FORMATAR OS CAMPOS DE DETALHE DO FICHEIRO V17 - CHEQUES
     * 
     */
    protected void m2230FormataV17() {
        log(TraceLevel.Debug, "2230-FORMATA-V17");
        bghr1702().registo().componentComum().initialize() ;
        /**
         * INDICADOR TIPO DE MOVIMENTO
         */
        if (bghr1701().registo().cEvenOpel().isEqual(bhok0005().eventos().levantChqProp()) || 
            bghr1701().registo().cEvenOpel().isEqual("0628")) {
            bghr1702().registo().detalheV17().iTipMov1V17().setTrue() ;
        } else {
            bghr1702().registo().detalheV17().iTipMov2V17().setTrue() ;
        }
        /**
         * DATA DA OPERACAO
         */
        bghr1702().registo().detalheV17().zOperacaoV17().get(1, 4).set(bghr1701().registo().zMovimento().get(1, 4)) ;
        bghr1702().registo().detalheV17().zOperacaoV17().get(5, 2).set(bghr1701().registo().zMovimento().get(6, 2)) ;
        bghr1702().registo().detalheV17().zOperacaoV17().get(7, 2).set(bghr1701().registo().zMovimento().get(9, 2)) ;
        bghr1702().registo().detalheV17().cTipPagmtoCheqV17().setTrue() ;
        /**
         * TIPO DE CANAL DE TRANSMISSAO
         */
        if (bghr1702().registo().detalheV17().iTipMov1V17().isTrue()) {
            bghr1702().registo().detalheV17().cTipCnlTrmOnuV17().setTrue() ;
        } else {
            bghr1702().registo().detalheV17().cTipCnlTrmBilV17().setTrue() ;
        }
        /**
         * CODIGO DO PAIS DE ORIGEM DA OPERACAO
         */
        bghr1702().registo().detalheV17().cPaisOrigOperV17().set(bghr1701().registo().cPaisIsoaOeOpx().get(1, 2));
        /**
         * NUMERO DE TRANSACCOES
         */
        bghr1702().registo().detalheV17().qVolumeV17().set(CON_N1);
        /**
         * MONTANTE DO MOVIMENTO
         */
        bghr1702().registo().detalheV17().mValorV17().set(bghr1701().registo().mMovimento());
        bghr1702().registo().detalheV17().mValFillerV17().set(0);
        /**
         * GH1303 - INICIO
         * **   INDICADOR DO SINAL DO MOVIMENTO
         * IF BGHR1701-I-DBCR EQUAL BHOK0002-CON-DEBITO
         * SET BGHR1702-I-VALOR-NEG-V17
         * TO TRUE
         * ELSE
         * SET BGHR1702-I-VALOR-POS-V17
         * END-IF.
         * GH1303 - FIM
         * CODIGO DA MOEDA DO MOVIMENTO
         */
        bghr1702().registo().detalheV17().cMoedMovV17().set(bghr1701().registo().cMoedIsoOriMov());
        /**
         * TEXTO LIVRE
         */
        bghr1702().registo().detalheV17().xDescritivoV17().set(" ");
    }
    
    /**
     * 
     * 2240-FORMATA-V13
     * FORMATAR OS CAMPOS DE DETALHE DO FICHEIRO V13 - DOMICILIACOES
     * 
     */
    protected void m2240FormataV13() {
        log(TraceLevel.Debug, "2240-FORMATA-V13");
        bghr1702().registo().componentComum().initialize() ;
        /**
         * INDICADOR TIPO DE MOVIMENTO
         * BIDK0002-EVE-DD = ID01
         * GH1964 - INI
         * IF BGHR1701-C-EVEN-OPEL EQUAL BIDK0002-EVE-DD
         */
        if (bghr1701().registo().cEvenOpel().isEqual(CON_EVE_DD)) {
            bghr1702().registo().detalheV13().iTipMov1V13().setTrue() ;
        } else if (bghr1701().registo().cEvenOpel().isEqual(bimk0002().cEvento().eveFun()) || 
            bghr1701().registo().cEvenOpel().isEqual(bimk0002().cEvento().eveMcc())) {
            bghr1702().registo().detalheV13().iTipMov2V13().setTrue() ;
        }
        /**
         * DATA DA OPERACAO
         * MOVE BHTL250A-Z-PROCESSAMENTO(1:4)
         * TO
         * BGHR1702-Z-OPERACAO-V13(1:4).
         */
        bghr1702().registo().detalheV13().zOperacaoV13().get(1, 4).set(bghr1701().registo().zMovimento().get(1, 4)) ;
        bghr1702().registo().detalheV13().zOperacaoV13().get(5, 2).set(bghr1701().registo().zMovimento().get(6, 2)) ;
        bghr1702().registo().detalheV13().zOperacaoV13().get(7, 2).set(bghr1701().registo().zMovimento().get(9, 2)) ;
        /**
         * TIPO DE INSTRUMENTO DE PAGAMENTO
         */
        if (bghr1702().registo().detalheV13().iTipMov1V13().isTrue()) {
            bghr1702().registo().detalheV13().cTipPagmtoDedeV13().setTrue() ;
        } else {
            bghr1702().registo().detalheV13().cTipPagmtoRescV13().setTrue() ;
        }
        /**
         * TIPO DE CANAL DE LIQUIDACAO
         */
        if (bghr1702().registo().detalheV13().iTipMov1V13().isTrue()) {
            bghr1702().registo().detalheV13().cTipLqzPagTarV13().setTrue() ;
        } else {
            bghr1702().registo().detalheV13().cTipLqzPagOnsV13().setTrue() ;
        }
        /**
         * ORIGEM DO PAGAMENTO
         */
        bghr1702().registo().detalheV13().cOrigPagV13().set(CON_ELFBA);
        /**
         * TIPO DE CANAL DE TRANSMISSAO
         */
        if (bghr1702().registo().detalheV13().iTipMov1V13().isTrue()) {
            bghr1702().registo().detalheV13().cTipCnlTrmDomV13().setTrue() ;
        } else {
            bghr1702().registo().detalheV13().cTipCnlTrmIncV13().setTrue() ;
        }
        /**
         * NUMERO DE TRANSACCOES
         */
        bghr1702().registo().detalheV13().qVolumeRegV13().set(CON_N1);
        /**
         * MONTANTE DO MOVIMENTO
         */
        bghr1702().registo().detalheV13().mMovimentoV13().set(bghr1701().registo().mMovimento());
        bghr1702().registo().detalheV13().mMovFillerV13().set(0);
        bghr1702().registo().detalheV13().custmCatgV13Inco().setTrue() ;
        bghr1702().registo().detalheV13().typeRTransV13().set(" ");
        bghr1702().registo().detalheV13().sddSchemeV13().set(" ");
        bghr1702().registo().detalheV13().cPaisDestOperV13().set(" ");
        bghr1702().registo().detalheV13().cPaisOrigOperV13().set(" ");
        /**
         * GH1303 - FIM
         * CODIGO DA MOEDA DO MOVIMENTO
         */
        bghr1702().registo().detalheV13().cMoedMovV13().set(bghr1701().registo().cMoedIsoOriMov());
        /**
         * TEXTO LIVRE
         */
        bghr1702().registo().detalheV13().xDescritivoV13().set(" ");
    }
    
    /**
     * 
     * 2250-FORMATA-V15
     * FORMATAR OS CAMPOS DE DETALHE DO FICHEIRO V15 - CARTOES
     * 
     */
    protected void m2250FormataV15() {
        log(TraceLevel.Debug, "2250-FORMATA-V15");
        bghr1702().registo().componentComum().initialize() ;
        /**
         * INDICADOR TIPO DE MOVIMENTO
         */
        if (bghr1701().registo().cEvenOpel().isEqual(bimk0002().cEvento().eveMcd()) || 
            bghr1701().registo().cEvenOpel().isEqual(bimk0002().cEvento().eveAcd())) {
            bghr1702().registo().detalheV15().iTipMov1V15().setTrue() ;
        }
        /**
         * DATA DA OPERACAO
         */
        bghr1702().registo().detalheV15().zOperacaoV15().get(1, 4).set(bghr1701().registo().zMovimento().get(1, 4)) ;
        bghr1702().registo().detalheV15().zOperacaoV15().get(5, 2).set(bghr1701().registo().zMovimento().get(6, 2)) ;
        bghr1702().registo().detalheV15().zOperacaoV15().get(7, 2).set(bghr1701().registo().zMovimento().get(9, 2)) ;
        bghr1702().registo().detalheV15().cTipPagmtoCadeV15().setTrue() ;
        /**
         * TIPO DE ACORDO (acesso a tabela VIM00401_INFCDEB
         * obter C_TIPO_CART_CETR)
         */
        switch (biml004a().commarea().dadosInOut().cTipoCartCetr().get()) {
            case Bimk0002.BIMK0002_C_TIPO_CART_VPAY:
                bghr1702().registo().detalheV15().cTipShemeVpayV15().setTrue() ;
                break;
            case Bimk0002.BIMK0002_C_TIPO_CART_MAES:
                bghr1702().registo().detalheV15().cTipShemeMaesV15().setTrue() ;
                break;
            default :
                bghr1702().registo().detalheV15().cTipShemeAutrV15().setTrue() ;
                break;
        }
        log(TraceLevel.Debug, "C_TIPO_TERM_CETR : ", biml002a().commarea().dadosOutput().cTipoTermCetr());
        swStatus().swCTipoTermCetr().set(biml002a().commarea().dadosOutput().cTipoTermCetr());
        if (swStatus().swCTipoTermCetrAtm().isTrue()) {
            bghr1702().registo().detalheV15().cTipTermAtmV15().setTrue() ;
        } else if (swStatus().swCTipoTermCetrPos().isTrue()) {
            bghr1702().registo().detalheV15().cTipTermPosV15().setTrue() ;
        } else if (swStatus().swCTipoTermCetrEco().isTrue()) {
            bghr1702().registo().detalheV15().cTipTermEcoV15().setTrue() ;
        } else if (swStatus().swCTipoTermCetrImp().isTrue()) {
            bghr1702().registo().detalheV15().cTipTermImpV15().setTrue() ;
        } else {
            bghr1702().registo().detalheV15().cTipTermAutV15().setTrue() ;
        }
        log(TraceLevel.Debug, "C_CATG_OPE_CETR : ", biml002a().commarea().dadosOutput().cCatgOpeCetr());
        swStatus().swCCatgOpeCetr().set(biml002a().commarea().dadosOutput().cCatgOpeCetr());
        if (swStatus().swCCatgOpeCetrSal().isTrue()) {
            bghr1702().registo().detalheV15().cTipOperSalV15().setTrue() ;
        } else if (swStatus().swCCatgOpeCetrAtm().isTrue()) {
            bghr1702().registo().detalheV15().cTipOperAtmV15().setTrue() ;
        } else if (swStatus().swCCatgOpeCetrCas().isTrue()) {
            bghr1702().registo().detalheV15().cTipOperCasV15().setTrue() ;
        } else if (swStatus().swCCatgOpeCetrCre().isTrue()) {
            bghr1702().registo().detalheV15().cTipOperCreV15().setTrue() ;
        } else {
            bghr1702().registo().detalheV15().cTipOperAutV15().setTrue() ;
        }
        bghr1702().registo().detalheV15().cTipMoAceiConV15().setTrue() ;
        log(TraceLevel.Debug, "BIML002A-C-PAIS-ISOA-OPE  : ", biml002a().commarea().dadosOutput().cPaisIsoaOpe());
        log(TraceLevel.Debug, "BHGL010A-C-PAIS-ISO-ALFN  : ", bhgl010a().commarea().dadosOutput().cPaisIsoAlfn());
        bghr1702().registo().detalheV15().cPaisOrigOperV15().set(bhgl010a().commarea().dadosOutput().cPaisIsoAlfn());
        /**
         * NUMERO DE TRANSACOES
         */
        bghr1702().registo().detalheV15().qVolumeV15().set(CON_N1);
        /**
         * MONTANTE DO MOVIMENTO
         */
        bghr1702().registo().detalheV15().mValorV15().set(bghr1701().registo().mMovimento());
        bghr1702().registo().detalheV15().mValFillerV15().set(0);
        /**
         * GH1303 - INICIO
         * INDICADOR DO SINAL DO MOVIMENTO
         * IF BGHR1701-I-DBCR EQUAL BHOK0002-CON-DEBITO
         * SET BGHR1702-I-VALOR-NEG-V15
         * TO TRUE
         * ELSE
         * SET BGHR1702-I-VALOR-POS-V15
         * END-IF.
         * GH1303 - FIM
         * CODIGO DA MOEDA DO MOVIMENTO
         */
        bghr1702().registo().detalheV15().cMoedMovV15().set(bghr1701().registo().cMoedIsoOriMov());
        /**
         * TEXTO LIVRE
         */
        bghr1702().registo().detalheV15().xDescritivoV15().set(" ");
    }
    
    /**
     * 
     * *GH2027-INI: NOVOS FICHEIROS
     * 2260-FORMATA-V111
     * FORMATAR OS CAMPOS DE DETALHE DO FICHEIRO V111
     * 
     */
    protected void m2260FormataV111() {
        log(TraceLevel.Debug, "2260-FORMATA-V111");
        bghr1702().registo().componentComum().initialize() ;
        /**
         * DATA DA OPERACAO
         */
        bghr1702().registo().detalheV111().zOperacaoV111().get(1, 4).set(bghr1701().registo().zMovimento().get(1, 4)) ;
        bghr1702().registo().detalheV111().zOperacaoV111().get(5, 2).set(bghr1701().registo().zMovimento().get(6, 2)) ;
        bghr1702().registo().detalheV111().zOperacaoV111().get(7, 2).set(bghr1701().registo().zMovimento().get(9, 2)) ;
        bghr1702().registo().detalheV111().iTipMov1V111().setTrue() ;
        /**
         * CODIGO TIPO DE OPERACAO
         */
        if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_DEBITO)) {
            bghr1702().registo().detalheV111().cTipOperDepV111().setTrue() ;
        } else {
            bghr1702().registo().detalheV111().cTipOperWitV111().setTrue() ;
        }
        /**
         * CODIGO DA MOEDA DO MOVIMENTO
         */
        bghr1702().registo().detalheV111().cMoedMovV111().set(bghr1701().registo().cMoedIsoOriMov());
        /**
         * MONTANTE DO MOVIMENTO
         */
        bghr1702().registo().detalheV111().mValorV111().set(bghr1701().registo().mMovimento());
        bghr1702().registo().detalheV111().mValFillerV111().set(0);
        /**
         * VOLUME
         */
        bghr1702().registo().detalheV111().qVolumeRegV111().set(CON_N1);
        /**
         * TEXTO LIVRE
         */
        bghr1702().registo().detalheV111().xDescritivoV111().set(" ");
    }
    
    /**
     * 
     * 2270-FORMATA-V112
     * FORMATAR OS CAMPOS DE DETALHE DO FICHEIRO V112
     * 
     */
    protected void m2270FormataV112() {
        log(TraceLevel.Debug, "2270-FORMATA-V112");
        bghr1702().registo().componentComum().initialize() ;
        /**
         * DATA DA OPERACAO
         */
        bghr1702().registo().detalheV112().zOperacaoV112().get(1, 4).set(bghr1701().registo().zMovimento().get(1, 4)) ;
        bghr1702().registo().detalheV112().zOperacaoV112().get(5, 2).set(bghr1701().registo().zMovimento().get(6, 2)) ;
        bghr1702().registo().detalheV112().zOperacaoV112().get(7, 2).set(bghr1701().registo().zMovimento().get(9, 2)) ;
        bghr1702().registo().detalheV112().iTipMov1V112().setTrue() ;
        bghr1702().registo().detalheV112().cTipOperIttV112().setTrue() ;
        /**
         * DIRECCAO DA OPERACAO
         */
        if (bghr1701().registo().iDbcr().isEqual(bhok0002().BHOK0002_CON_DEBITO)) {
            bghr1702().registo().detalheV112().cTipDirMovEmV112().setTrue() ;
        } else {
            bghr1702().registo().detalheV112().cTipDirMovReV112().setTrue() ;
        }
        /**
         * VOLUME
         */
        bghr1702().registo().detalheV112().qVolumeRegV112().set(CON_N1);
        /**
         * MONTANTE DO MOVIMENTO
         */
        bghr1702().registo().detalheV112().mValorV112().set(bghr1701().registo().mMovimento());
        bghr1702().registo().detalheV112().mValFillerV112().set(0);
        /**
         * CODIGO DA MOEDA DO MOVIMENTO
         */
        bghr1702().registo().detalheV112().cMoedMovV112().set(bghr1701().registo().cMoedIsoOriMov());
        /**
         * PAIS
         */
        bghr1702().registo().detalheV112().cPaisDestOperV112().set(wsVariaveis().wsCPaisIsoAlfn());
        /**
         * TEXTO LIVRE
         */
        bghr1702().registo().detalheV112().xDescritivoV112().set(" ");
    }
    
    /**
     * 
     * *GH2027-FIM
     * 2310-ESCREVE-V11
     * 
     */
    protected void m2310EscreveV11() {
        log(TraceLevel.Debug, "2310-ESCREVE-V11");
        ficheiroFwk004().write(ficheiroFwk004().regFwk004400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK004);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk004().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk004().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK004);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk004().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2310-ESCREVE-V11");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk004().add(1);
        }
    }
    
    /**
     * 
     * 2320-ESCREVE-V12
     * 
     */
    protected void m2320EscreveV12() {
        log(TraceLevel.Debug, "2320-ESCREVE-V12");
        ficheiroFwk006().write(ficheiroFwk006().regFwk006400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK006);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk006().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk006().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK006);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk006().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-ESCREVE-V12");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk006().add(1);
        }
    }
    
    /**
     * 
     * 2330-ESCREVE-V17
     * 
     */
    protected void m2330EscreveV17() {
        log(TraceLevel.Debug, "2330-ESCREVE-V17");
        ficheiroFwk008().write(ficheiroFwk008().regFwk008400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK008);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk008().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk008().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK008);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk008().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2330-ESCREVE-V17");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk008().add(1);
        }
    }
    
    /**
     * 
     * 2340-ESCREVE-V13
     * 
     */
    protected void m2340EscreveV13() {
        log(TraceLevel.Debug, "2340-ESCREVE-V13");
        ficheiroFwk010().write(ficheiroFwk010().regFwk010400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK010);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk010().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk010().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK010);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk010().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2340-ESCREVE-V13");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk010().add(1);
        }
    }
    
    /**
     * 
     * 2350-ESCREVE-V15
     * 
     */
    protected void m2350EscreveV15() {
        log(TraceLevel.Debug, "2350-ESCREVE-V15");
        ficheiroFwk012().write(ficheiroFwk012().regFwk012400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK012);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk012().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk012().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK012);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk012().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2350-ESCREVE-V15");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk012().add(1);
        }
    }
    
    /**
     * 
     * *GH2027-INI: NOVOS FICHEIROS
     * 2360-ESCREVE-V111
     * 
     */
    protected void m2360EscreveV111() {
        log(TraceLevel.Debug, "2360-ESCREVE-V111");
        ficheiroFwk808().write(ficheiroFwk808().regFwk808400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK808);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk808().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk012().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK808);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk808().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2360-ESCREVE-V111");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk808().add(1);
        }
    }
    
    /**
     * 
     * 2370-ESCREVE-V112
     * 
     */
    protected void m2370EscreveV112() {
        log(TraceLevel.Debug, "2370-ESCREVE-V112");
        ficheiroFwk809().write(ficheiroFwk809().regFwk809400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK809);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk809().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk809().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK809);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk809().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2370-ESCREVE-V112");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFwk809().add(1);
        }
    }
    
    /**
     * 
     * *GH2027-FIM
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
        m3110CloseFwk003() ;
        m3120CloseFwk004() ;
        m3130CloseFwk006() ;
        m3140CloseFwk008() ;
        m3150CloseFwk010() ;
        m3160CloseFwk012() ;
        /**
         * *GH2027-INI: NOVOS FICHEIROS
         */
        m3170CloseFwk808() ;
        m3180CloseFwk809() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FWK003
     * 
     */
    protected void m3110CloseFwk003() {
        log(TraceLevel.Debug, "3110-CLOSE-FWK003");
        ficheiroFwk003().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk003().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FWK003");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3120-CLOSE-FWK004
     * 
     */
    protected void m3120CloseFwk004() {
        log(TraceLevel.Debug, "3120-CLOSE-FWK004");
        ficheiroFwk004().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK004);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk004().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk004().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK004);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk004().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FWK004");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3130-CLOSE-FWK006
     * 
     */
    protected void m3130CloseFwk006() {
        log(TraceLevel.Debug, "3130-CLOSE-FWK006");
        ficheiroFwk006().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK006);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk006().getStatus());
        bhop0013FormataAcesso() ;
        /**
         * IF NOT SW-FWK004-OK
         */
        if (!ficheiroFwk006().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            /**
             * MOVE CON-FWK004            TO BHTW0030-NM-FICHEIRO
             * MOVE STATUS-FWK004         TO BHTW0030-C-FSTT-COBL
             */
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK006);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk006().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3130-CLOSE-FWK006");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3140-CLOSE-FWK008
     * 
     */
    protected void m3140CloseFwk008() {
        log(TraceLevel.Debug, "3140-CLOSE-FWK008");
        ficheiroFwk008().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK008);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk008().getStatus());
        bhop0013FormataAcesso() ;
        /**
         * IF NOT SW-FWK004-OK
         */
        if (!ficheiroFwk008().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            /**
             * MOVE CON-FWK004            TO BHTW0030-NM-FICHEIRO
             * MOVE STATUS-FWK004         TO BHTW0030-C-FSTT-COBL
             */
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK008);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk008().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3140-CLOSE-FWK008");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3150-CLOSE-FWK010
     * 
     */
    protected void m3150CloseFwk010() {
        log(TraceLevel.Debug, "3150-CLOSE-FWK010");
        ficheiroFwk010().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK010);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk010().getStatus());
        bhop0013FormataAcesso() ;
        /**
         * IF NOT SW-FWK004-OK
         */
        if (!ficheiroFwk010().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            /**
             * MOVE CON-FWK004            TO BHTW0030-NM-FICHEIRO
             * MOVE STATUS-FWK004         TO BHTW0030-C-FSTT-COBL
             */
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK010);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk010().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3150-CLOSE-FWK010");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3160-CLOSE-FWK012
     * 
     */
    protected void m3160CloseFwk012() {
        log(TraceLevel.Debug, "3160-CLOSE-FWK012");
        ficheiroFwk012().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK012);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk012().getStatus());
        bhop0013FormataAcesso() ;
        /**
         * IF NOT SW-FWK004-OK
         */
        if (!ficheiroFwk012().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            /**
             * MOVE CON-FWK004            TO BHTW0030-NM-FICHEIRO
             * MOVE STATUS-FWK004         TO BHTW0030-C-FSTT-COBL
             */
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK012);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk012().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3160-CLOSE-FWK012");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * *GH2027-INI: NOVOS FICHEIROS
     * 3170-CLOSE-FWK808
     * 
     */
    protected void m3170CloseFwk808() {
        log(TraceLevel.Debug, "3170-CLOSE-FWK808");
        ficheiroFwk808().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK808);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk808().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk808().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK808);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk808().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3160-CLOSE-FWK808");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3180-CLOSE-FWK809
     * 
     */
    protected void m3180CloseFwk809() {
        log(TraceLevel.Debug, "3180-CLOSE-FWK809");
        ficheiroFwk809().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK809);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk809().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk809().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK809);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk809().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3160-CLOSE-FWK809");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * *GH2027-FIM
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
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        /**
         * BHTP0031 - BATCH SEM DB2
         * ROLLBACK E FORMATACAO DE RETURN-CODE
         */
        rollback() ;
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
     * AREA DE LIGACAO AH ROTINA MHQJ028A - OBTENCAO DADOS COE
     * AREA DE LIGACAO AH ROTINA MHGJ010A - OBTENCAO CODIGOS PAIS
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
        IString statusFwk003() ;
        @Data
        @Condition("00")
        ICondition swFwk003Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk003Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk004() ;
        @Data
        @Condition("00")
        ICondition swFwk004Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk004Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk006() ;
        @Data
        @Condition("00")
        ICondition swFwk006Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk006Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk008() ;
        @Data
        @Condition("00")
        ICondition swFwk008Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk008Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk010() ;
        @Data
        @Condition("00")
        ICondition swFwk010Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk010Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk012() ;
        @Data
        @Condition("00")
        ICondition swFwk012Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk012Eof() ;
        
        
        /**
         * *GH2027-INI: NOVOS FICHEIROS
         */
        @Data(size=2, value="00")
        IString statusFwk808() ;
        @Data
        @Condition("00")
        ICondition swFwk808Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk808Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk809() ;
        @Data
        @Condition("00")
        ICondition swFwk809Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk809Eof() ;
        
        
        /**
         * *GH2027-FIM
         * SWITCH NOME DE FICHEIRO
         */
        @Data(size=6, value="      ")
        IString swNmFicheiro() ;
        @Data
        @Condition("FGH172")
        ICondition swV11() ;
        @Data
        @Condition("FGH173")
        ICondition swV12() ;
        @Data
        @Condition("FGH174")
        ICondition swV17() ;
        @Data
        @Condition("FGH175")
        ICondition swV13() ;
        @Data
        @Condition("FGH176")
        ICondition swV15() ;
        @Data
        @Condition("FGH178")
        ICondition swV111() ;
        @Data
        @Condition("FGH179")
        ICondition swV112() ;
        
        
        /**
         * SWITCH V15
         */
        @Data(size=1, value=" ")
        IString swCTipoTermCetr() ;
        @Data
        @Condition("A")
        ICondition swCTipoTermCetrAtm() ;
        @Data
        @Condition("P")
        ICondition swCTipoTermCetrPos() ;
        @Data
        @Condition("E")
        ICondition swCTipoTermCetrEco() ;
        @Data
        @Condition("I")
        ICondition swCTipoTermCetrImp() ;
        
        
        @Data(size=1, value=" ")
        IString swCCatgOpeCetr() ;
        @Data
        @Condition("S")
        ICondition swCCatgOpeCetrSal() ;
        @Data
        @Condition("G")
        ICondition swCCatgOpeCetrAtm() ;
        @Data
        @Condition("C")
        ICondition swCCatgOpeCetrCas() ;
        @Data
        @Condition("R")
        ICondition swCCatgOpeCetrCre() ;
        
        
        @Data(size=4, value=" ")
        IString swCanlAcesBalc() ;
        @Data
        @Condition({ "BALC", "0005" })
        ICondition swCanlAcesBalcS() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString wsSysin() ;
        
        @Data(size=15, value="0")
        ILong wsLidosFwk003() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk004() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk006() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk008() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk010() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk012() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk808() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFwk809() ;
        
        /**
         * *PRO GH1926 - INI
         */
        @Data(size=10, value=" ")
        IString wsZValidade() ;
        
        /**
         * @return instancia da classe local WsDtT04
         */
        @Data
        WsDtT04 wsDtT04() ;
        
        /**
         * @return instancia da classe local WsDataPass
         */
        @Data
        WsDataPass wsDataPass() ;
        
        /**
         * @return instancia da classe local WsDtT06
         */
        @Data
        WsDtT06 wsDtT06() ;
        
        /**
         * @return instancia da classe local WsDtTemp
         */
        @Data
        WsDtTemp wsDtTemp() ;
        
        /**
         * @return instancia da classe local WsDtT8
         */
        @Data
        WsDtT8 wsDtT8() ;
        
        /**
         * @return instancia da classe local WsDtT10
         */
        @Data
        WsDtT10 wsDtT10() ;
        
        /**
         * *PRO GH1926 - FIM
         * @return instancia da classe local WsData
         */
        @Data
        WsData wsData() ;
        
        @Data(size=5, value=" ")
        IString wsDataJuliana() ;
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoAlf3() ;
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoAlfn() ;
        
        /**
         * @return instancia da classe local WsNRefOpetBpor
         */
        @Data
        WsNRefOpetBpor wsNRefOpetBpor() ;
        
        @Data(size=9, value="0")
        ILong wsNJourBbnN() ;
        
        /**
         * @return instancia da classe local WsNJourBbnR
         */
        @Data
        @Mask
        WsNJourBbnR wsNJourBbnR() ;
        
        /**
         * @return instancia da classe local WsXCteuMhtq250a
         */
        @Data
        WsXCteuMhtq250a wsXCteuMhtq250a() ;
        
        /**
         * @return instancia da classe local WsXCteuMhyj230a
         */
        @Data
        WsXCteuMhyj230a wsXCteuMhyj230a() ;
        
        /**
         * @return instancia da classe local WsXCteuMhgj010a
         */
        @Data
        WsXCteuMhgj010a wsXCteuMhgj010a() ;
        
        
        public interface WsDtT04 extends IDataStruct {
            
            @Data(size=4, value="0", lpadding=2, lpaddingValue="20")
            IInt wsAnomesT04() ;
            
        }
        
        public interface WsDataPass extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsAnoT() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IInt wsMesT() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IInt wsDiaT() ;
            
        }
        
        public interface WsDtT06 extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsAnoT06() ;
            
            @Data(size=2, value="0")
            IInt wsMesT06() ;
            
        }
        
        public interface WsDtTemp extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsAnoT06() ;
            
            @Data(size=2, value="0", rpadding=2, rpaddingValue="")
            IInt wsMesT06() ;
            
        }
        
        public interface WsDtT8 extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsAnoT() ;
            
            @Data(size=2, value="0")
            IInt wsMesT() ;
            
            @Data(size=2, value="0")
            IInt wsDiaT() ;
            
        }
        
        public interface WsDtT10 extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsAnoT() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IInt wsMesT() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IInt wsDiaT() ;
            
        }
        
        
        /**
         * 
         * *PRO GH1926 - FIM
         * 
         * @version 2.0
         * 
         */
        public interface WsData extends IDataStruct {
            
            @Data(size=4)
            IString wsAno() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IString wsMes() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IString wsDia() ;
            
        }
        
        public interface WsNRefOpetBpor extends IDataStruct {
            
            @Data(size=2, value=" ")
            IString wsCAplic() ;
            
            @Data(size=8, value=" ")
            IString wsCUserId() ;
            
            @Data(size=5, value=" ")
            IString wsDataJul() ;
            
            @Data(size=9, value=" ")
            IString wsNJourBbn() ;
            
        }
        
        public interface WsNJourBbnR extends IDataMask {
            
            @Data(size=9)
            IString wsNJourBbnX() ;
            
        }
        
        public interface WsXCteuMhtq250a extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString wsCPaisIsoMhyq250a() ;
            
            @Data(size=8, value=" ", lpadding=3, rpadding=79, lpaddingValue=" / ", rpaddingValue=" / ")
            IString wsAAplSgccMhyq250a() ;
            
        }
        
        public interface WsXCteuMhyj230a extends IDataStruct {
            
            @Data(size=2, value=" ")
            IString wsCFunzMdloMhyj230a() ;
            
            @Data(size=1, value=" ", lpadding=3, lpaddingValue=" / ")
            IString wsITipoExeMhyj230a() ;
            
            @Data(size=10, value=" ", lpadding=3, lpaddingValue=" / ")
            IString wsDatInput1Mhyj230a() ;
            
            @Data(size=1, value="!")
            IString filler001() ;
            
            @Data(size=81, value=" ")
            IString filler002() ;
            
        }
        
        public interface WsXCteuMhgj010a extends IDataStruct {
            
            @Data(size=1, value=" ")
            IString wsTipoCodPaisMhgj010a() ;
            
            @Data(size=3, value=" ", lpadding=3, lpaddingValue=" / ")
            IString wsCodPaisMhgj010a() ;
            
            @Data(size=1, value="!")
            IString filler001() ;
            
            @Data(size=92, value=" ")
            IString filler002() ;
            
        }
    }
    
}
