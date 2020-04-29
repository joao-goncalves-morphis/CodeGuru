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
import cgd.ht.structures.link.Bhtl200a ;
import cgd.hj.structures.link.Bhjl051a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.gh.structures.work.Bghr0201 ;
import cgd.gh.structures.work.Bghr0211 ;
import cgd.ht.routines.Mhtq200a ;
import cgd.hj.routines.Mhjj051a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FGH020 - OUTPUT
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FGH021 - OUTPUT
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FWK020 - INPUT
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FWK021 - INPUT
 * WORKING-STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq902a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps20001Movexgdep
     */
    @Data
    protected abstract Vwsdghps20001Movexgdep hv20001Movexgdep() ;
    
    /**
     * @return instancia da classe Vwsdghps20101Titexgdep
     */
    @Data
    protected abstract Vwsdghps20101Titexgdep hv20101Titexgdep() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fhy003
     */
    @Handler(name="FHY003")
    @Data
    protected abstract Fhy003 ficheiroFhy003() ;
    
    /**
     * @return instancia da classe Fgh020
     */
    @Handler(name="FGH020", record="regFgh020153")
    @Data
    protected abstract Fgh020 ficheiroFgh020() ;
    
    /**
     * @return instancia da classe Fgh021
     */
    @Handler(name="FGH021", record="regFgh02187")
    @Data
    protected abstract Fgh021 ficheiroFgh021() ;
    
    /**
     * @return instancia da classe Fwk020
     */
    @Handler(name="FWK020", record="regFwk020")
    @Data
    protected abstract Fwk020 ficheiroFwk020() ;
    
    /**
     * @return instancia da classe Fwk021
     */
    @Handler(name="FWK021", record="regFwk021")
    @Data
    protected abstract Fwk021 ficheiroFwk021() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq200a
     */
    @Data
    protected abstract Mhtq200a hrMhtq200a() ;
    
    /**
     * @return instancia da classe Mhjj051a
     */
    @Data
    protected abstract Mhjj051a hrMhjj051a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtl200a
     */
    @Data
    protected abstract Bhtl200a bhtl200a() ;
    
    /**
     * @return instancia da classe Bhjl051a
     */
    @Data
    protected abstract Bhjl051a bhjl051a() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bghr0201
     */
    @Data
    protected abstract Bghr0201 bghr0201() ;
    
    /**
     * @return instancia da classe Bghr0211
     */
    @Data
    protected abstract Bghr0211 bghr0211() ;
    
    /**
     * ----- DB2
     */
    protected static final String CON_OPEN_CRS = "OP" ;
    
    protected static final String CON_FETCH = "FE" ;
    
    protected static final String CON_CLOSE_CRS = "CC" ;
    
    protected static final String CON_SELECT = "SE" ;
    
    protected static final String CON_INSERT = "IN" ;
    
    protected static final String CON_UPDATE = "UP" ;
    
    protected static final String CON_DELETE = "DL" ;
    
    /**
     * ----- FICHEIROS
     */
    protected static final String CON_OPEN_INPUT = "OI" ;
    
    protected static final String CON_OPEN_OUTPUT = "OO" ;
    
    protected static final String CON_OPEN_EXTEND = "OE" ;
    
    protected static final String CON_READ = "RE" ;
    
    protected static final String CON_CONSULTA = "CO" ;
    
    protected static final String CON_WRITE = "WR" ;
    
    protected static final String CON_CLOSE_FI = "CF" ;
    
    protected static final String CON_FWK020 = "FWK020" ;
    
    protected static final String CON_ERRO_FWK020 = "ERRO FIC. FWK020" ;
    
    protected static final String CON_FWK021 = "FWK021" ;
    
    protected static final String CON_ERRO_FWK021 = "ERRO FIC. FWK021" ;
    
    protected static final String CON_FGH020 = "FGH020" ;
    
    protected static final String CON_ERRO_FGH020 = "ERRO FIC. FGH020" ;
    
    protected static final String CON_FGH021 = "FGH021" ;
    
    protected static final String CON_ERRO_FGH021 = "ERRO FIC. FGH021" ;
    
    /**
     * ----- ROTINAS
     */
    protected static final String CON_ROTINA = "RO" ;
    
    protected static final String CON_GH = "GH" ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     */
    protected static final String CON_PROGRAMA = "PGHQ902A" ;
    
    protected static final String CON_VGH20001 = "VGH20001" ;
    
    protected static final String CON_ATIVO = "A" ;
    
    protected static final String CON_DESCRICAO = "OBT TGH00200_MOVEXTGT E TGH00201_TITEXTGT PARA DW." ;
    
    /**
     * TABELAS INTERNAS
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
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
     * BHTP0010
     * ACESSO A ROTINA DE OBTENCAO DE DATAS POR APLICACAO
     * MHTQ200A
     * 
     */
    protected void bhtp0010CaplicDatas() {
    }
    
    /**
     * 
     * BHJP5051-ACESSO AO MODULO QUE OBTEM OBTEM OS CONTRATOS ACTIVOS
     * DE UM CLIENTE NUMA DETERMINADA DATA , COM POSSIBILIDADE DE
     * LIMITAR OS RESULTADOS POR  I_TIPO_ITVT (MHJJ051A)
     * 
     */
    protected void bhjp5051AcedeMhjj051a() {
        hrMhjj051a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        m2000ProcessoPrograma() ;
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100Inicializacoes() ;
        bhtp0011ObtemDados() ;
        m1200AbreEstatistica() ;
        m1300ObtemDataApl() ;
        m1400AbreFicheiros() ;
        m1500LeFichFwk020() ;
        m1600LeFichFwk021() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        log(TraceLevel.Debug, "1100-INICIALIZACOES");
        wsVariaveis().initialize() ;
        bghr0201().registo().initialize() ;
        bghr0211().registo().initialize() ;
        bhtl200a().commarea().initialize() ;
        hv20001Movexgdep().movexgdep().initialize() ;
    }
    
    /**
     * 
     * 1200-ABRE-ESTATISTICA
     * 
     */
    protected void m1200AbreEstatistica() {
        log(TraceLevel.Debug, "1200-ABRE-ESTATISTICA");
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-OBTEM-DATA-APL
     * 
     */
    protected void m1300ObtemDataApl() {
        log(TraceLevel.Debug, "1300-OBTEM-DATA-APL");
        bhtl200a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl200a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0010CaplicDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl200a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl200a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl200a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl200a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl200a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl200a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl200a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO PARAGRAFO 1300-OBTEM-DATA-APL");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1400-ABRE-FICHEIROS
     * 
     */
    protected void m1400AbreFicheiros() {
        log(TraceLevel.Debug, "1400-ABRE-FICHEIROS");
        /**
         * ABRE FICHEIRO FWK020
         */
        ficheiroFwk020().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK020);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk020().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk020().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK020);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        /**
         * ABRE FICHEIRO FWK021
         */
        ficheiroFwk021().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK021);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk021().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk021().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK021);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        /**
         * ABRE FICHEIRO FGH020 - OUTPUT
         */
        ficheiroFgh020().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH020);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh020().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh020().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FGH020);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        /**
         * ABRE FICHEIRO FGH021 - OUTPUT
         */
        ficheiroFgh021().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH021);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh021().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh021().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FGH021);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-LE-FICH-FWK020
     * 
     */
    protected void m1500LeFichFwk020() {
        log(TraceLevel.Debug, "1500-LE-FICH-FWK020");
        ficheiroFwk020().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK020);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk020().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk020().getStatusOk()) {
            if (!ficheiroFwk020().getStatusOk()) {
                bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
                bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
                bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK020);
                bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
                m9900Abend() ;
            }
        } else {
            log(TraceLevel.Debug, "BGHW8020-C-PAIS-ISOA-CONT  : ", ficheiroFwk020().regFwk020().cPaisIsoaCont());
            log(TraceLevel.Debug, "BGHW8020-C-BANC-CONT       : ", ficheiroFwk020().regFwk020().cBancCont());
            log(TraceLevel.Debug, "BGHW8020-C-OE-EGC-CONT     : ", ficheiroFwk020().regFwk020().cOeEgcCont());
            log(TraceLevel.Debug, "BGHW8020-NS-RDCL-CONT      : ", ficheiroFwk020().regFwk020().nsRdclCont());
            log(TraceLevel.Debug, "BGHW8020-V-CHKD-CONT       : ", ficheiroFwk020().regFwk020().vChkdCont());
            log(TraceLevel.Debug, "BGHW8020-C-TIPO-CONT       : ", ficheiroFwk020().regFwk020().cTipoCont());
            log(TraceLevel.Debug, "BGHW8020-C-MOED-ISO-SCTA   : ", ficheiroFwk020().regFwk020().cMoedIsoScta());
            log(TraceLevel.Debug, "BGHW8020-NS-DEPOSITO       : ", ficheiroFwk020().regFwk020().nsDeposito());
            log(TraceLevel.Debug, "BGHW8020-NS-MOVIMENTO      : ", ficheiroFwk020().regFwk020().nsMovimento());
            log(TraceLevel.Debug, "BGHW8020-C-EST-EXTS-GAR-DEP: ", ficheiroFwk020().regFwk020().cEstExtsGarDep());
            log(TraceLevel.Debug, "BGHW8020-C-CRTZ-MOV-EXS-GAR: ", ficheiroFwk020().regFwk020().cCrtzMovExsGar());
            log(TraceLevel.Debug, "BGHW8020-M-MOVIMENTO       : ", ficheiroFwk020().regFwk020().mMovimento());
            log(TraceLevel.Debug, "BGHW8020-Z-INI-EXTS-GAR-DEP: ", ficheiroFwk020().regFwk020().zIniExtsGarDep());
            log(TraceLevel.Debug, "BGHW8020-Z-FIM-EXTS-GAR-DEP: ", ficheiroFwk020().regFwk020().zFimExtsGarDep());
            log(TraceLevel.Debug, "BGHW8020-I-TIP-ITVT-EXS-GAR: ", ficheiroFwk020().regFwk020().iTipItvtExsGar());
            log(TraceLevel.Debug, "BGHW8020-NS-TITC-EXTS-GART : ", ficheiroFwk020().regFwk020().nsTitcExtsGart());
            log(TraceLevel.Debug, "BGHW8020-TS-CRIACAO        : ", ficheiroFwk020().regFwk020().tsCriacao());
            log(TraceLevel.Debug, "BGHW8020-C-USID-CRIX       : ", ficheiroFwk020().regFwk020().cUsidCrix());
            log(TraceLevel.Debug, "BGHW8020-TS-ACTZ-ULT       : ", ficheiroFwk020().regFwk020().tsActzUlt());
            log(TraceLevel.Debug, "BGHW8020-C-USID-ACTZ-ULT   : ", ficheiroFwk020().regFwk020().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 1600-LE-FICH-FWK021
     * 
     */
    protected void m1600LeFichFwk021() {
        log(TraceLevel.Debug, "1600-LE-FICH-FWK021");
        ficheiroFwk021().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK021);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk021().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk021().getStatusOk()) {
            if (!ficheiroFwk021().getStatusOk()) {
                bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
                bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
                bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
                bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK021);
                bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
                m9900Abend() ;
            }
        } else {
            log(TraceLevel.Debug, "BGHW8021-C-PAIS-ISOA-CONT  : ", ficheiroFwk021().regFwk021().cPaisIsoaCont());
            log(TraceLevel.Debug, "BGHW8021-C-BANC-CONT       : ", ficheiroFwk021().regFwk021().cBancCont());
            log(TraceLevel.Debug, "BGHW8021-C-OE-EGC-CONT     : ", ficheiroFwk021().regFwk021().cOeEgcCont());
            log(TraceLevel.Debug, "BGHW8021-NS-RDCL-CONT      : ", ficheiroFwk021().regFwk021().nsRdclCont());
            log(TraceLevel.Debug, "BGHW8021-V-CHKD-CONT       : ", ficheiroFwk021().regFwk021().vChkdCont());
            log(TraceLevel.Debug, "BGHW8021-C-TIPO-CONT       : ", ficheiroFwk021().regFwk021().cTipoCont());
            log(TraceLevel.Debug, "BGHW8021-C-MOED-ISO-SCTA   : ", ficheiroFwk021().regFwk021().cMoedIsoScta());
            log(TraceLevel.Debug, "BGHW8021-NS-DEPOSITO       : ", ficheiroFwk021().regFwk021().nsDeposito());
            log(TraceLevel.Debug, "BGHW8021-NS-MOVIMENTO      : ", ficheiroFwk021().regFwk021().nsMovimento());
            log(TraceLevel.Debug, "BGHW8021-I-TIPO-ITVT       : ", ficheiroFwk021().regFwk021().iTipoItvt());
            log(TraceLevel.Debug, "BGHW8021-NS-TITC           : ", ficheiroFwk021().regFwk021().nsTitc());
            log(TraceLevel.Debug, "BGHW8021-I-TITC-EXS-GAR-DEP: ", ficheiroFwk021().regFwk021().iTitcExsGarDep());
            log(TraceLevel.Debug, "BGHW8021-TS-CRIACAO        : ", ficheiroFwk021().regFwk021().tsCriacao());
            log(TraceLevel.Debug, "BGHW8021-C-USID-ACTZ-ULT   : ", ficheiroFwk021().regFwk021().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        while (ficheiroFwk020().getStatusOk()) {
            m2100TrataFwk020() ;
        }
        while (ficheiroFwk021().getStatusOk()) {
            m2200TrataFwk021() ;
        }
    }
    
    /**
     * 
     * 2100-TRATA-FWK020
     * 
     */
    protected void m2100TrataFwk020() {
        log(TraceLevel.Debug, "2100-TRATA-FWK020");
        bhjl051a().commarea().initialize() ;
        bghr0201().registo().initialize() ;
        bghr0201().registo().movexgdep().cPaisIsoaCont().set(ficheiroFwk020().regFwk020().cPaisIsoaCont());
        bghr0201().registo().movexgdep().cBancCont().set(ficheiroFwk020().regFwk020().cBancCont());
        bghr0201().registo().movexgdep().cOeEgcCont().set(ficheiroFwk020().regFwk020().cOeEgcCont());
        bghr0201().registo().movexgdep().nsRdclCont().set(ficheiroFwk020().regFwk020().nsRdclCont());
        bghr0201().registo().movexgdep().vChkdCont().set(ficheiroFwk020().regFwk020().vChkdCont());
        bghr0201().registo().movexgdep().cTipoCont().set(ficheiroFwk020().regFwk020().cTipoCont());
        bghr0201().registo().movexgdep().cMoedIsoScta().set(ficheiroFwk020().regFwk020().cMoedIsoScta());
        bghr0201().registo().movexgdep().nsDeposito().set(ficheiroFwk020().regFwk020().nsDeposito());
        bghr0201().registo().movexgdep().nsMovimento().set(ficheiroFwk020().regFwk020().nsMovimento());
        bghr0201().registo().movexgdep().cEstExtsGarDep().set(ficheiroFwk020().regFwk020().cEstExtsGarDep());
        bghr0201().registo().movexgdep().cCrtzMovExsGar().set(ficheiroFwk020().regFwk020().cCrtzMovExsGar());
        bghr0201().registo().movexgdep().mMovimento().set(ficheiroFwk020().regFwk020().mMovimento());
        bghr0201().registo().movexgdep().zIniExtsGarDep().set(ficheiroFwk020().regFwk020().zIniExtsGarDep());
        bghr0201().registo().movexgdep().zFimExtsGarDep().set(ficheiroFwk020().regFwk020().zFimExtsGarDep());
        bghr0201().registo().movexgdep().iTipItvtExsGar().set(ficheiroFwk020().regFwk020().iTipItvtExsGar());
        bghr0201().registo().movexgdep().nsTitcExtsGart().set(ficheiroFwk020().regFwk020().nsTitcExtsGart());
        bghr0201().registo().movexgdep().tsCriacao().set(ficheiroFwk020().regFwk020().tsCriacao());
        bghr0201().registo().movexgdep().cUsidCrix().set(ficheiroFwk020().regFwk020().cUsidCrix());
        bghr0201().registo().movexgdep().tsActzUlt().set(ficheiroFwk020().regFwk020().tsActzUlt());
        bghr0201().registo().movexgdep().cUsidActzUlt().set(ficheiroFwk020().regFwk020().cUsidActzUlt());
        bghr0201().registo().zEnvio().set(bhtl200a().commarea().dadosSaida().zProcessamento());
        bhjl051a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhjl051a().commarea().dadosEntrada().cMnemEgcOpex().set(bhtw0011().commarea().dadosSaida().cMnemEmpGcx());
        bhjl051a().commarea().dadosEntrada().cPaisIsoaCont().set(ficheiroFwk020().regFwk020().cPaisIsoaCont());
        bhjl051a().commarea().dadosEntrada().cBancCont().set(ficheiroFwk020().regFwk020().cBancCont());
        bhjl051a().commarea().dadosEntrada().cOeEgcCont().set(ficheiroFwk020().regFwk020().cOeEgcCont());
        bhjl051a().commarea().dadosEntrada().nsRdclCont().set(ficheiroFwk020().regFwk020().nsRdclCont());
        bhjl051a().commarea().dadosEntrada().vChkdCont().set(ficheiroFwk020().regFwk020().vChkdCont());
        bhjl051a().commarea().dadosEntrada().cTipoCont().set(ficheiroFwk020().regFwk020().cTipoCont());
        bhjl051a().commarea().dadosEntrada().iTipoItvtPag().set(ficheiroFwk020().regFwk020().iTipItvtExsGar());
        bhjl051a().commarea().dadosEntrada().nsTitcPag().set(ficheiroFwk020().regFwk020().nsTitcExtsGart());
        bhjl051a().commarea().dadosEntrada().zConsulta().set(ficheiroFwk020().regFwk020().tsCriacao().get(1, 10));
        bhjp5051AcedeMhjj051a() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhjl051a().nomeRotina());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhjl051a().commarea().erros().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhjl051a().commarea().erros().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhjl051a().commarea().erros().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhjl051a().commarea().erros().semErros().isTrue() && !bhjl051a().commarea().erros().fimConsulta().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2100-TRATA-FWK020");
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhjl051a().nomeRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhjl051a().commarea().erros().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhjl051a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().nmTabela().set(bhjl051a().commarea().erros().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhjl051a().commarea());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        } else {
            log(TraceLevel.Debug, "BHJL051A-Q-OCCURS-OUT: ", bhjl051a().commarea().qOccursOut());
            wsVariaveis().wsIndex().set(0);
            swSwitches().swCicloNao().setTrue() ;
            for (wsVariaveis().wsIndex().set(1); wsVariaveis().wsIndex().isLessOrEqual(bhjl051a().commarea().qOccursOut()); wsVariaveis().wsIndex().add(1)) {
                if (bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).iTipoItvt().isEqual(ficheiroFwk020().regFwk020().iTipItvtExsGar()) && 
                    bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).nsTitc().isEqual(ficheiroFwk020().regFwk020().nsTitcExtsGart())) {
                    bghr0201().registo().nCliente().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).nCliente());
                    bghr0201().registo().nsAbraCli().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).nsAbraCli());
                    swSwitches().swCicloSim().setTrue() ;
                    m2300WriteFgh020() ;
                }
            }
        }
        if (swSwitches().swCicloNao().isTrue()) {
            log(TraceLevel.Debug, "#####################################");
            log(TraceLevel.Debug, "DADOS NAO ENCONTRADOS :");
            log(TraceLevel.Debug, "BGHW8020-I-TIP-ITVT-EXS-GAR:", ficheiroFwk020().regFwk020().iTipItvtExsGar());
            log(TraceLevel.Debug, "BGHW8020-NS-TITC-EXTS-GART :", ficheiroFwk020().regFwk020().nsTitcExtsGart());
            log(TraceLevel.Debug, "#####################################");
        }
        m1500LeFichFwk020() ;
    }
    
    /**
     * 
     * 2200-TRATA-FWK021
     * 
     */
    protected void m2200TrataFwk021() {
        log(TraceLevel.Debug, "2200-TRATA-FWK021");
        bhjl051a().commarea().initialize() ;
        bghr0211().registo().initialize() ;
        m2400ProcuraDataEvento() ;
        /**
         * MOVE BGHW8021-TITEXGDEP       TO BGHR0211-TITEXGDEP
         */
        bghr0211().registo().titexgdep().cPaisIsoaCont().set(ficheiroFwk021().regFwk021().cPaisIsoaCont());
        bghr0211().registo().titexgdep().cBancCont().set(ficheiroFwk021().regFwk021().cBancCont());
        bghr0211().registo().titexgdep().cOeEgcCont().set(ficheiroFwk021().regFwk021().cOeEgcCont());
        bghr0211().registo().titexgdep().nsRdclCont().set(ficheiroFwk021().regFwk021().nsRdclCont());
        bghr0211().registo().titexgdep().vChkdCont().set(ficheiroFwk021().regFwk021().vChkdCont());
        bghr0211().registo().titexgdep().cTipoCont().set(ficheiroFwk021().regFwk021().cTipoCont());
        bghr0211().registo().titexgdep().cMoedIsoScta().set(ficheiroFwk021().regFwk021().cMoedIsoScta());
        bghr0211().registo().titexgdep().nsDeposito().set(ficheiroFwk021().regFwk021().nsDeposito());
        bghr0211().registo().titexgdep().nsMovimento().set(ficheiroFwk021().regFwk021().nsMovimento());
        bghr0211().registo().titexgdep().iTipoItvt().set(ficheiroFwk021().regFwk021().iTipoItvt());
        bghr0211().registo().titexgdep().nsTitc().set(ficheiroFwk021().regFwk021().nsTitc());
        bghr0211().registo().titexgdep().iTitcExsGarDep().set(ficheiroFwk021().regFwk021().iTitcExsGarDep());
        bghr0211().registo().titexgdep().tsCriacao().set(ficheiroFwk021().regFwk021().tsCriacao());
        bghr0211().registo().titexgdep().cUsidActzUlt().set(ficheiroFwk021().regFwk021().cUsidActzUlt());
        bghr0211().registo().zEnvio().set(bhtl200a().commarea().dadosSaida().zProcessamento());
        bhjl051a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhjl051a().commarea().dadosEntrada().cMnemEgcOpex().set(bhtw0011().commarea().dadosSaida().cMnemEmpGcx());
        bhjl051a().commarea().dadosEntrada().cPaisIsoaCont().set(ficheiroFwk021().regFwk021().cPaisIsoaCont());
        bhjl051a().commarea().dadosEntrada().cBancCont().set(ficheiroFwk021().regFwk021().cBancCont());
        bhjl051a().commarea().dadosEntrada().cOeEgcCont().set(ficheiroFwk021().regFwk021().cOeEgcCont());
        bhjl051a().commarea().dadosEntrada().nsRdclCont().set(ficheiroFwk021().regFwk021().nsRdclCont());
        bhjl051a().commarea().dadosEntrada().vChkdCont().set(ficheiroFwk021().regFwk021().vChkdCont());
        bhjl051a().commarea().dadosEntrada().cTipoCont().set(ficheiroFwk021().regFwk021().cTipoCont());
        bhjl051a().commarea().dadosEntrada().iTipoItvtPag().set(ficheiroFwk021().regFwk021().iTipoItvt());
        bhjl051a().commarea().dadosEntrada().nsTitcPag().set(ficheiroFwk021().regFwk021().nsTitc());
        bhjl051a().commarea().dadosEntrada().zConsulta().set(hv20001Movexgdep().movexgdep().tsCriacao().get(1, 10));
        bhjp5051AcedeMhjj051a() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhjl051a().nomeRotina());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhjl051a().commarea().erros().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhjl051a().commarea().erros().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhjl051a().commarea().erros().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhjl051a().commarea().erros().semErros().isTrue() && !bhjl051a().commarea().erros().fimConsulta().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2200-TRATA-FWK021");
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhjl051a().nomeRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhjl051a().commarea().erros().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhjl051a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().nmTabela().set(bhjl051a().commarea().erros().nmTabela());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhjl051a().commarea());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        } else {
            wsVariaveis().wsIndex().set(0);
            swSwitches().swCicloNao().setTrue() ;
            for (wsVariaveis().wsIndex().set(1); wsVariaveis().wsIndex().isLessOrEqual(bhjl051a().commarea().qOccursOut()); wsVariaveis().wsIndex().add(1)) {
                if (bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).iTipoItvt().isEqual(ficheiroFwk021().regFwk021().iTipoItvt()) && 
                    bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).nsTitc().isEqual(ficheiroFwk021().regFwk021().nsTitc())) {
                    bghr0211().registo().nCliente().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).nCliente());
                    bghr0211().registo().nsAbraCli().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndex()).nsAbraCli());
                    swSwitches().swCicloSim().setTrue() ;
                    m2500WriteFgh021() ;
                }
            }
        }
        m1600LeFichFwk021() ;
    }
    
    /**
     * 
     * 2400-PROCURA-DATA-EVENTO
     * 
     */
    protected void m2400ProcuraDataEvento() {
        log(TraceLevel.Debug, "2400-PROCURA-DATA-EVENTO");
        hv20001Movexgdep().movexgdep().initialize() ;
        hv20001Movexgdep().movexgdep().cPaisIsoaCont().set(ficheiroFwk021().regFwk021().cPaisIsoaCont());
        hv20001Movexgdep().movexgdep().cBancCont().set(ficheiroFwk021().regFwk021().cBancCont());
        hv20001Movexgdep().movexgdep().cOeEgcCont().set(ficheiroFwk021().regFwk021().cOeEgcCont());
        hv20001Movexgdep().movexgdep().nsRdclCont().set(ficheiroFwk021().regFwk021().nsRdclCont());
        hv20001Movexgdep().movexgdep().vChkdCont().set(ficheiroFwk021().regFwk021().vChkdCont());
        hv20001Movexgdep().movexgdep().cTipoCont().set(ficheiroFwk021().regFwk021().cTipoCont());
        hv20001Movexgdep().movexgdep().cMoedIsoScta().set(ficheiroFwk021().regFwk021().cMoedIsoScta());
        hv20001Movexgdep().movexgdep().nsDeposito().set(ficheiroFwk021().regFwk021().nsDeposito());
        hv20001Movexgdep().movexgdep().nsMovimento().set(ficheiroFwk021().regFwk021().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().selectPghq902a960() ;
        swSwitches().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH20001);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh20001Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2400-PROCURA-DATA-EVENTO");
            bhtw0030().dadosEntrada().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH20001);
            wsVariaveis().wsCBancCont().set(hv20001Movexgdep().movexgdep().cBancCont());
            wsVariaveis().wsCOeEgcCont().set(hv20001Movexgdep().movexgdep().cOeEgcCont());
            wsVariaveis().wsNsRdclCont().set(hv20001Movexgdep().movexgdep().nsRdclCont());
            wsVariaveis().wsVChkdCont().set(hv20001Movexgdep().movexgdep().vChkdCont());
            wsVariaveis().wsCTipoCont().set(hv20001Movexgdep().movexgdep().cTipoCont());
            wsVariaveis().wsNsDeposito().set(hv20001Movexgdep().movexgdep().nsDeposito());
            wsVariaveis().wsNsMovimento().set(hv20001Movexgdep().movexgdep().nsMovimento());
            bhtw0030().dadosEntrada().xCteuAlig().set(concat(hv20001Movexgdep().movexgdep().cPaisIsoaCont(), "/", wsVariaveis().wsCBancCont(), "/", wsVariaveis().wsCOeEgcCont(), "/", wsVariaveis().wsNsRdclCont(), "/", wsVariaveis().wsVChkdCont(), "/", wsVariaveis().wsCTipoCont(), "/", hv20001Movexgdep().movexgdep().cMoedIsoScta(), "/", wsVariaveis().wsNsDeposito(), "/", wsVariaveis().wsNsMovimento(), "."));
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            log(TraceLevel.Error, " ACESSO TGH00200:");
            log(TraceLevel.Error, " - VGH20001-C-PAIS-ISOA-CONT       :", hv20001Movexgdep().movexgdep().cPaisIsoaCont());
            log(TraceLevel.Error, " - VGH20001-C-BANC-CONT            :", hv20001Movexgdep().movexgdep().cBancCont());
            log(TraceLevel.Error, " - VGH20001-C-OE-EGC-CONT          :", hv20001Movexgdep().movexgdep().cOeEgcCont());
            log(TraceLevel.Error, " - VGH20001-NS-RDCL-CONT           :", hv20001Movexgdep().movexgdep().nsRdclCont());
            log(TraceLevel.Error, " - VGH20001-V-CHKD-CONT            :", hv20001Movexgdep().movexgdep().vChkdCont());
            log(TraceLevel.Error, " - VGH20001-C-TIPO-CONT            :", hv20001Movexgdep().movexgdep().cTipoCont());
            log(TraceLevel.Error, " - VGH20001-C-MOED-ISO-SCTA        :", hv20001Movexgdep().movexgdep().cMoedIsoScta());
            log(TraceLevel.Error, " - VGH20001-NS-DEPOSITO            :", hv20001Movexgdep().movexgdep().nsDeposito());
            log(TraceLevel.Error, " - VGH20001-NS-MOVIMENTO           :", hv20001Movexgdep().movexgdep().nsMovimento());
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2300-WRITE-FGH020
     * 
     */
    protected void m2300WriteFgh020() {
        log(TraceLevel.Debug, "2300-WRITE-FGH020");
        ficheiroFgh020().write(ficheiroFgh020().regFgh020153) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH020);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh020().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh020().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_WRITE);
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH020);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh020().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FGH020);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2500-WRITE-FGH021
     * 
     */
    protected void m2500WriteFgh021() {
        log(TraceLevel.Debug, "2500-WRITE-FGH021");
        ficheiroFgh021().write(ficheiroFgh021().regFgh02187) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH021);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh021().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh021().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_WRITE);
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH021);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh021().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FGH021);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, "3000-FIM-PROGRAMA");
        m3100FechaFicheiros() ;
        bhop0013FimEstatistica() ;
    }
    
    /**
     * 
     * 3100-FECHA-FICHEIROS
     * 
     */
    protected void m3100FechaFicheiros() {
        log(TraceLevel.Debug, "3100-FECHA-FICHEIROS");
        ficheiroFwk020().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK020);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk020().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk020().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK020);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        ficheiroFwk021().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK021);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk021().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk021().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK021);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        ficheiroFgh020().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH020);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh020().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh020().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FGH020);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
        ficheiroFgh021().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH021);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh021().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh021().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FGH021);
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 8100-DATA-HORA-FIM
     * 
     */
    protected void m8100DataHoraFim() {
        log(TraceLevel.Debug, "8100-DATA-HORA-FIM");
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
        wsVariaveis().wsHoraFim().set( getDBTime() ) ;
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        m8100DataHoraFim() ;
        ficheiroFwk020().close() ;
        ficheiroFwk021().close() ;
        ficheiroFgh020().close() ;
        ficheiroFgh021().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
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
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * ****                  DATA E HORA                         ****
         */
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        /**
         * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
         */
        @Data(size=4, value="0")
        IInt wsCBancCont() ;
        
        @Data(size=4, value="0")
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, value="0")
        IInt wsNsRdclCont() ;
        
        @Data(size=1, value="0")
        IInt wsVChkdCont() ;
        
        @Data(size=3, value="0")
        IInt wsCTipoCont() ;
        
        @Data(size=4, value="0")
        IInt wsNsDeposito() ;
        
        @Data(size=15, value="0")
        ILong wsNsMovimento() ;
        
        @Data(size=4, value="0")
        IInt wsIndex() ;
        
    }
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitches extends IDataStruct {
        
        /**
         * ----- FICHEIROS
         */
        @Data(size=2, value="00")
        IString statusFwk020() ;
        @Data
        @Condition("00")
        ICondition swFwk020Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk020Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk021() ;
        @Data
        @Condition("00")
        ICondition swFwk021Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk021Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh020() ;
        @Data
        @Condition("00")
        ICondition swFgh020Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh020Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh021() ;
        @Data
        @Condition("00")
        ICondition swFgh021Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh021Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        @Data(size=1, value="N")
        IString statusCiclo() ;
        @Data
        @Condition("N")
        ICondition swCicloNao() ;
        @Data
        @Condition("S")
        ICondition swCicloSim() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20001() ;
        @Data
        @Condition("0")
        ICondition swVgh20001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh20001Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh20001Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh20001Null() ;
        
        
    }
    
}
