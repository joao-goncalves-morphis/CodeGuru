package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
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
import cgd.na.common.constants.Bnak0002 ;
import cgd.na.structures.work.Bnaw0501 ;
import cgd.na.common.constants.Bnak0001 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.routines.Mhtq200a ;


/**
 * 
 * FILE SECTION
 * WORKING-STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq901a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00901Infauxmov
     */
    @Data
    protected abstract Vwsdghps00901Infauxmov hv00901Infauxmov() ;
    
    
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
     * @return instancia da classe Fwk00101
     */
    @Handler(name="FWK001", record="regFwk001")
    @Data
    protected abstract Fwk00101 ficheiroFwk001() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq200a
     */
    @Data
    protected abstract Mhtq200a hrMhtq200a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bnak0002
     */
    @Data
    protected abstract Bnak0002 bnak0002() ;
    
    /**
     * @return instancia da classe Bnaw0501
     */
    @Data
    protected abstract Bnaw0501 bnaw0501() ;
    
    /**
     * @return instancia da classe Bnak0001
     */
    @Data
    protected abstract Bnak0001 bnak0001() ;
    
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
     * ----- DB2
     */
    protected static final String CON_VGH00901 = "VGH00901" ;
    
    /**
     * ----- FICHEIROS
     */
    protected static final String CON_FWK001 = "FWK001" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_ERRO_FWK001 = "ERRO FIC. FWK001" ;
    
    /**
     * ----- ROTINAS
     * ****              CONSTANTES ALFANUMERICAS                ****
     */
    protected static final String CON_PROGRAMA_DESC = "UPD I-ESTORNO, NS-MOV-ETND TGH09 A PARTIR DE THO23" ;
    
    protected static final String CON_PROGRAMA_ID = "PGHQ901A" ;
    
    /**
     * ****                CONSTANTES NUMERICAS                  ****
     */
    protected static final int CON_UM = 1 ;
    
    /**
     * AREA DE SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * @return instancia da classe local WsTimestamp
     */
    @Data
    protected abstract WsTimestamp wsTimestamp() ;
    
    
    
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
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (!ficheiroFwk001().getStatusOk()) {
            m2000ProcessoPrograma() ;
        }
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
        m1200ObterDadosBatch() ;
        m1300ObtemDataApl() ;
        m1400AbreFicheiros() ;
        m1500ReadFicheiro() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        log(TraceLevel.Debug, "1100-INICIALIZACOES");
        wsVariaveis().initialize() ;
        hv00901Infauxmov().infauxmov().initialize() ;
        bhtl200a().commarea().initialize() ;
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA_ID);
        bhow0013().dadosInput().dFunlPrg().set(CON_PROGRAMA_DESC);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1200-OBTER-DADOS-BATCH
     * 
     */
    protected void m1200ObterDadosBatch() {
        log(TraceLevel.Debug, "1200-OBTER-DADOS-BATCH");
        bhtp0011ObtemDados() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set("FHT011");
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
        bhop0013FormataAcesso() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1200-OBTER-DADOS-BATCH");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set("FHT011");
            bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1300-OBTEM-DATA-APL
     * 
     */
    protected void m1300ObtemDataApl() {
        log(TraceLevel.Debug, "1300-OBTEM-DATA-APL");
        bhtl200a().commarea().initialize() ;
        bhtl200a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl200a().commarea().dadosEntrada().aAplicacao().set(bnak0002().valoresGenericos().aAplCredito());
        bhtp0010CaplicDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl200a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl200a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl200a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl200a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl200a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl200a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO 1300-OBTEM-DATA-APL");
            bhtw0030().dadosEntrada().abend().setTrue() ;
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
        m1410OpenFwk001() ;
    }
    
    /**
     * 
     * 1410-OPEN-FWK001
     * 
     */
    protected void m1410OpenFwk001() {
        log(TraceLevel.Debug, "1410-OPEN-FWK001");
        ficheiroFwk001().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk001().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk001().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk001().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK001);
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-READ-FICHEIRO
     * 
     */
    protected void m1500ReadFicheiro() {
        log(TraceLevel.Debug, "1500-READ-FICHEIRO");
        ficheiroFwk001().regFwk001().initialize() ;
        ficheiroFwk001().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk001().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk001().getStatusOk() && !ficheiroFwk001().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().get(1, 18).set("1500-READ-FICHEIRO") ;
            bhtw0030().dadosEntrada().xSugRtnoSwal().get(19, 3).set(" / ") ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk001().getStatus());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        m2100InsereTgh009() ;
        if (swSwitches().swVgh00901Dupkey().isTrue()) {
            m2200ActualizaTgh009() ;
        }
        commit() ;
        m1500ReadFicheiro() ;
    }
    
    /**
     * 
     * 2100-INSERE-TGH009
     * 
     */
    protected void m2100InsereTgh009() {
        log(TraceLevel.Debug, "2100-INSERE-TGH009");
        hv00901Infauxmov().infauxmov().initialize() ;
        hv00901Infauxmov().infauxmov().cPaisIsoaCont().set(ficheiroFwk001().regFwk001().cPaisIsoaCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCPaisIsoaCont().set(ficheiroFwk001().regFwk001().cPaisIsoaCont());
        hv00901Infauxmov().infauxmov().cBancCont().set(ficheiroFwk001().regFwk001().cBancCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCBancCont().set(ficheiroFwk001().regFwk001().cBancCont());
        hv00901Infauxmov().infauxmov().cOeEgcCont().set(ficheiroFwk001().regFwk001().cOeEgcCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCOeEgcCont().set(ficheiroFwk001().regFwk001().cOeEgcCont());
        hv00901Infauxmov().infauxmov().nsRdclCont().set(ficheiroFwk001().regFwk001().nsRdclCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsRdclCont().set(ficheiroFwk001().regFwk001().nsRdclCont());
        hv00901Infauxmov().infauxmov().vChkdCont().set(ficheiroFwk001().regFwk001().vChkdCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsVChkdCont().set(ficheiroFwk001().regFwk001().vChkdCont());
        hv00901Infauxmov().infauxmov().cTipoCont().set(ficheiroFwk001().regFwk001().cTipoCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCTipoCont().set(ficheiroFwk001().regFwk001().cTipoCont());
        hv00901Infauxmov().infauxmov().cMoedIsoScta().set(ficheiroFwk001().regFwk001().cMoedIsoScta());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCMoedIsoScta().set(ficheiroFwk001().regFwk001().cMoedIsoScta());
        hv00901Infauxmov().infauxmov().nsDeposito().set(ficheiroFwk001().regFwk001().nsDeposito());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsDeposito().set(ficheiroFwk001().regFwk001().nsDeposito());
        hv00901Infauxmov().infauxmov().tsActzUlt().set(ficheiroFwk001().regFwk001().tsActzUlt());
        wsTimestamp().wsDataTimestamp().set(ficheiroFwk001().regFwk001().tsActzUlt());
        wsTimestamp().wsTimerTimestamp().wsHh().set(0);
        wsTimestamp().wsTimerTimestamp().wsMm().set(0);
        wsTimestamp().wsTimerTimestamp().wsSs().set(0);
        wsTimestamp().wsTimerTimestamp().wsResto().set(0);
        hv00901Infauxmov().infauxmov().tsMovimento().set(wsTimestamp());
        hv00901Infauxmov().infauxmov().nsMovimento().set(ficheiroFwk001().regFwk001().nsMovimento());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsMovimento().set(ficheiroFwk001().regFwk001().nsMovimento());
        hv00901Infauxmov().infauxmov().iTrnzEfcdOnln().set(ficheiroFwk001().regFwk001().iTrnzEfcdOnln());
        hv00901Infauxmov().infauxmov().iExiAtzJourBbn().set(ficheiroFwk001().regFwk001().iExiAtzJourBbn());
        hv00901Infauxmov().infauxmov().iPenalizacao().set(ficheiroFwk001().regFwk001().iPenalizacao());
        hv00901Infauxmov().infauxmov().cPaisIsoaGerx().set(ficheiroFwk001().regFwk001().cPaisIsoaGerx());
        hv00901Infauxmov().infauxmov().cBancGcxGerx().set(ficheiroFwk001().regFwk001().cBancGcxGerx());
        hv00901Infauxmov().infauxmov().cOeEgcGerx().set(ficheiroFwk001().regFwk001().cOeEgcGerx());
        hv00901Infauxmov().infauxmov().nAtrzCamb().set(0);
        hv00901Infauxmov().infauxmov().xRefMovOrig().set(" ");
        hv00901Infauxmov().infauxmov().cUsidActzUlt().set(CON_PROGRAMA_ID);
        hv00901Infauxmov().infauxmov().iEstorno().set(ficheiroFwk001().regFwk001().iEstorno());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsIEstorno().set(ficheiroFwk001().regFwk001().iEstorno());
        hv00901Infauxmov().infauxmov().nsMovEtnd().set(ficheiroFwk001().regFwk001().nsMovEtnd());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsMovEtnd().set(ficheiroFwk001().regFwk001().nsMovEtnd());
        hv00901Infauxmov().infauxmov().mMovCtrvEuro().set(ficheiroFwk001().regFwk001().mMovimento());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsMMovCtrvEuro().set(ficheiroFwk001().regFwk001().mMovimento());
        hv00901Infauxmov().infauxmov().tCambEuro().set(ficheiroFwk001().regFwk001().tCambio());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsTCambEuro().set(ficheiroFwk001().regFwk001().tCambio());
        log(TraceLevel.Debug, "VGH00901-C-PAIS-ISOA-CONT  : ", hv00901Infauxmov().infauxmov().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH00901-C-BANC-CONT       : ", hv00901Infauxmov().infauxmov().cBancCont());
        log(TraceLevel.Debug, "VGH00901-C-OE-EGC-CONT     : ", hv00901Infauxmov().infauxmov().cOeEgcCont());
        log(TraceLevel.Debug, "VGH00901-NS-RDCL-CONT      : ", hv00901Infauxmov().infauxmov().nsRdclCont());
        log(TraceLevel.Debug, "VGH00901-V-CHKD-CONT       : ", hv00901Infauxmov().infauxmov().vChkdCont());
        log(TraceLevel.Debug, "VGH00901-C-TIPO-CONT       : ", hv00901Infauxmov().infauxmov().cTipoCont());
        log(TraceLevel.Debug, "VGH00901-C-MOED-ISO-SCTA   : ", hv00901Infauxmov().infauxmov().cMoedIsoScta());
        log(TraceLevel.Debug, "VGH00901-NS-DEPOSITO       : ", hv00901Infauxmov().infauxmov().nsDeposito());
        log(TraceLevel.Debug, "VGH00901-TS-MOVIMENTO      : ", hv00901Infauxmov().infauxmov().tsMovimento());
        log(TraceLevel.Debug, "VGH00901-NS-MOVIMENTO      : ", hv00901Infauxmov().infauxmov().nsMovimento());
        log(TraceLevel.Debug, "VGH00901-I-TRNZ-EFCD-ONLN  : ", hv00901Infauxmov().infauxmov().iTrnzEfcdOnln());
        log(TraceLevel.Debug, "VGH00901-I-EXI-ATZ-JOUR-BBN: ", hv00901Infauxmov().infauxmov().iExiAtzJourBbn());
        log(TraceLevel.Debug, "VGH00901-I-PENALIZACAO     : ", hv00901Infauxmov().infauxmov().iPenalizacao());
        log(TraceLevel.Debug, "VGH00901-C-PAIS-ISOA-GERX  : ", hv00901Infauxmov().infauxmov().cPaisIsoaGerx());
        log(TraceLevel.Debug, "VGH00901-C-BANC-GCX-GERX   : ", hv00901Infauxmov().infauxmov().cBancGcxGerx());
        log(TraceLevel.Debug, "VGH00901-C-OE-EGC-GERX     : ", hv00901Infauxmov().infauxmov().cOeEgcGerx());
        log(TraceLevel.Debug, "VGH00901-N-ATRZ-CAMB       : ", hv00901Infauxmov().infauxmov().nAtrzCamb());
        log(TraceLevel.Debug, "VGH00901-X-REF-MOV-ORIG    : ", hv00901Infauxmov().infauxmov().xRefMovOrig());
        log(TraceLevel.Debug, "VGH00901-I-ESTORNO         : ", hv00901Infauxmov().infauxmov().iEstorno());
        log(TraceLevel.Debug, "VGH00901-NS-MOV-ETND       : ", hv00901Infauxmov().infauxmov().nsMovEtnd());
        log(TraceLevel.Debug, "VGH00901-M-MOV-CTRV-EURO   : ", hv00901Infauxmov().infauxmov().mMovCtrvEuro());
        log(TraceLevel.Debug, "VGH00901-T-CAMB-EURO       : ", hv00901Infauxmov().infauxmov().tCambEuro());
        log(TraceLevel.Debug, "VGH00901-C-TERMINAL        : ", hv00901Infauxmov().infauxmov().cTerminal());
        log(TraceLevel.Debug, "VGH00901-TS-ACTZ-ULT       : ", hv00901Infauxmov().infauxmov().tsActzUlt());
        log(TraceLevel.Debug, "VGH00901-C-USID-ACTZ-ULT   : ", hv00901Infauxmov().infauxmov().cUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00901_INFAUXMOV
         */
        hv00901Infauxmov().insertPghq901a607() ;
        swSwitches().swSqlcodeVgh00901().set(hv00901Infauxmov().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swInsert().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00901);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().swSqlcodeVgh00901());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00901Ok().isTrue() && !swSwitches().swVgh00901Dupkey().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh00901());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00901);
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xCteuChavTab().set(concat(wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCPaisIsoaCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCBancCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCOeEgcCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsRdclCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsVChkdCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCTipoCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCMoedIsoScta(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsDeposito(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsMovimento()));
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO INSERT VGH00901_INFAUXMOV");
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 2200-ACTUALIZA-TGH009
     * 
     */
    protected void m2200ActualizaTgh009() {
        log(TraceLevel.Debug, "2200-ACTUALIZA-TGH009");
        hv00901Infauxmov().infauxmov().initialize() ;
        hv00901Infauxmov().infauxmov().cPaisIsoaCont().set(ficheiroFwk001().regFwk001().cPaisIsoaCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCPaisIsoaCont().set(ficheiroFwk001().regFwk001().cPaisIsoaCont());
        hv00901Infauxmov().infauxmov().cBancCont().set(ficheiroFwk001().regFwk001().cBancCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCBancCont().set(ficheiroFwk001().regFwk001().cBancCont());
        hv00901Infauxmov().infauxmov().cOeEgcCont().set(ficheiroFwk001().regFwk001().cOeEgcCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCOeEgcCont().set(ficheiroFwk001().regFwk001().cOeEgcCont());
        hv00901Infauxmov().infauxmov().nsRdclCont().set(ficheiroFwk001().regFwk001().nsRdclCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsRdclCont().set(ficheiroFwk001().regFwk001().nsRdclCont());
        hv00901Infauxmov().infauxmov().vChkdCont().set(ficheiroFwk001().regFwk001().vChkdCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsVChkdCont().set(ficheiroFwk001().regFwk001().vChkdCont());
        hv00901Infauxmov().infauxmov().cTipoCont().set(ficheiroFwk001().regFwk001().cTipoCont());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCTipoCont().set(ficheiroFwk001().regFwk001().cTipoCont());
        hv00901Infauxmov().infauxmov().cMoedIsoScta().set(ficheiroFwk001().regFwk001().cMoedIsoScta());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCMoedIsoScta().set(ficheiroFwk001().regFwk001().cMoedIsoScta());
        hv00901Infauxmov().infauxmov().nsDeposito().set(ficheiroFwk001().regFwk001().nsDeposito());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsDeposito().set(ficheiroFwk001().regFwk001().nsDeposito());
        hv00901Infauxmov().infauxmov().nsMovimento().set(ficheiroFwk001().regFwk001().nsMovimento());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsMovimento().set(ficheiroFwk001().regFwk001().nsMovimento());
        hv00901Infauxmov().infauxmov().cUsidActzUlt().set(CON_PROGRAMA_ID);
        hv00901Infauxmov().infauxmov().iEstorno().set(ficheiroFwk001().regFwk001().iEstorno());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsIEstorno().set(ficheiroFwk001().regFwk001().iEstorno());
        hv00901Infauxmov().infauxmov().nsMovEtnd().set(ficheiroFwk001().regFwk001().nsMovEtnd());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsMovEtnd().set(ficheiroFwk001().regFwk001().nsMovEtnd());
        hv00901Infauxmov().infauxmov().mMovCtrvEuro().set(ficheiroFwk001().regFwk001().mMovimento());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsMMovCtrvEuro().set(ficheiroFwk001().regFwk001().mMovimento());
        hv00901Infauxmov().infauxmov().tCambEuro().set(ficheiroFwk001().regFwk001().tCambio());
        wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsTCambEuro().set(ficheiroFwk001().regFwk001().tCambio());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00901_INFAUXMOV
         */
        hv00901Infauxmov().updatePghq901a747() ;
        swSwitches().swSqlcodeVgh00901().set(hv00901Infauxmov().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00901);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitches().swSqlcodeVgh00901());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00901Ok().isTrue() && !swSwitches().swVgh00901Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh00901());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00901);
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            /**
             * NA30184 - FIM
             * Reservados... (INI).
             * 05 B..K0001-MONT-DCBO-NGCD-N-STND   PIC S9(3) VALUE +841.
             * 05 B..K0001-PRZ-DCBO-NGCD-N-ALT     PIC S9(3) VALUE +844.
             */
            bhtw0030().dadosEntrada().xCteuChavTab().set(concat(wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCPaisIsoaCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCBancCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCOeEgcCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsRdclCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsVChkdCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCTipoCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCMoedIsoScta(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsDeposito(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsMovimento()));
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO UPDATE VGH00901_INFAUXMOV");
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (swSwitches().swVgh00901Notfnd().isTrue()) {
            log(TraceLevel.Error, "# O REGISTO COM A CHAVE: ", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCPaisIsoaCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCBancCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCOeEgcCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsRdclCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsVChkdCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCTipoCont(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsCMoedIsoScta(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsDeposito(), "/", wsTimestamp().wsTimerTimestamp().wsVgh09Chave().wsNsMovimento());
            log(TraceLevel.Error, " NAO FOI ENCONTRADO PARA UPDATE.");
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
        m3110CloseFwk001() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FWK001
     * 
     */
    protected void m3110CloseFwk001() {
        log(TraceLevel.Debug, "3110-CLOSE-FWK001");
        ficheiroFwk001().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk001().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk001().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FWK001");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk001().getStatus());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
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
        m8100DataHoraFim() ;
        ficheiroFwk001().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA_ID);
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
     * 8100-DATA-HORA-FIM
     * 
     */
    protected void m8100DataHoraFim() {
        log(TraceLevel.Debug, "8100-DATA-HORA-FIM");
        wsVariaveis().wsDatas().wsDataFim().set( getDBDate() ) ;
        wsVariaveis().wsDatas().wsHoraFim().set( getDBTime() ) ;
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
     * AREA DE SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitches extends IDataStruct {
        
        /**
         * ----- FICHEIROS
         */
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk001() ;
        @Data
        @Condition("00")
        ICondition swFwk001Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk001Eof() ;
        
        
        /**
         * ----- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00901() ;
        @Data
        @Condition("0")
        ICondition swVgh00901Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00901Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh00901Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh00901Null() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDatas
         */
        @Data
        WsDatas wsDatas() ;
        
        
        public interface WsDatas extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsDataIni() ;
            
            @Data(size=10, value=" ")
            IString wsDataFim() ;
            
            @Data(size=8, value=" ")
            IString wsHoraIni() ;
            
            @Data(size=8, value=" ")
            IString wsHoraFim() ;
            
        }
    }
    public interface WsTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataTimestamp
         */
        @Data
        WsDataTimestamp wsDataTimestamp() ;
        
        /**
         * @return instancia da classe local WsTimerTimestamp
         */
        @Data(lpadding=1, lpaddingValue="-")
        WsTimerTimestamp wsTimerTimestamp() ;
        
        
        public interface WsDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wsAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wsMesMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wsDiaDd() ;
            
        }
        
        public interface WsTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wsHh() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wsMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wsSs() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wsResto() ;
            
            /**
             * @return instancia da classe local WsVgh09Chave
             */
            @Data
            WsVgh09Chave wsVgh09Chave() ;
            
            
            public interface WsVgh09Chave extends IDataStruct {
                
                @Data(size=3, value=" ")
                IString wsCPaisIsoaCont() ;
                
                @Data(size=4, signed=true, value="0")
                IInt wsCBancCont() ;
                
                @Data(size=4, signed=true, value="0")
                IInt wsCOeEgcCont() ;
                
                @Data(size=7, signed=true, value="0")
                IInt wsNsRdclCont() ;
                
                @Data(size=1, signed=true, value="0")
                IInt wsVChkdCont() ;
                
                @Data(size=3, signed=true, value="0")
                IInt wsCTipoCont() ;
                
                @Data(size=3, value=" ")
                IString wsCMoedIsoScta() ;
                
                @Data(size=4, signed=true, value="0")
                IInt wsNsDeposito() ;
                
                @Data(size=15, signed=true, value="0")
                ILong wsNsMovimento() ;
                
                @Data(size=1, value=" ")
                IString wsIEstorno() ;
                
                @Data(size=15, signed=true, value="0")
                ILong wsNsMovEtnd() ;
                
                @Data(size=17, decimal=2, signed=true, value="0")
                IDecimal wsMMovCtrvEuro() ;
                
                @Data(size=11, decimal=6, signed=true, value="0")
                IDecimal wsTCambEuro() ;
                
            }
        }
    }
    
}
