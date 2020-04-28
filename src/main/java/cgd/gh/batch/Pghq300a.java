package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
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
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.work.Bhtw0015 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq300a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    
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
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fwk299
     */
    @Handler(name="FWK299", record="regFwk299")
    @Data
    protected abstract Fwk299 ficheiroFwk299() ;
    
    
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
     * @return instancia da classe Bhtw0015
     */
    @Data
    protected abstract Bhtw0015 bhtw0015() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
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
     * ****    CONSTANTES UTILIZADAS PARA FORMATACAO DE ERROS    ****
     * ----- DB2
     */
    protected static final String CON_SELECT = "SE" ;
    
    protected static final String CON_INSERT = "IN" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_VGH10201 = "VGH10201" ;
    
    /**
     * ----- FICHEIROS
     */
    protected static final String CON_OPEN_INPUT = "OI" ;
    
    protected static final String CON_READ = "RE" ;
    
    protected static final String CON_CLOSE_FI = "CF" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_FWK299 = "FWK299" ;
    
    protected static final String CON_ERRO_FWK299 = "ERRO FIC. FWK299" ;
    
    /**
     * ----- ROTINAS
     */
    protected static final String CON_ROTINA = "RO" ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     */
    protected static final String CON_PROGRAMA = "PGHQ300A" ;
    
    protected static final String CON_APLIC = "VG" ;
    
    protected static final String CON_DESCRICAO = "TRATAMENTO DE DESCRITIVO DE VENCIMENTO " ;
    
    /**
     * ****              CONSTANTES NUMERICAS                    ****
     */
    protected static final int CON_1N = 1 ;
    
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
     * ACESSO A ROTINA QUE OBTEM AS DATAS D POR APLICACAO
     * MHTQ250A
     * 
     */
    protected void bhtp0250DatasDAplic() {
    }
    
    /**
     * 
     * FINALMENTE, MOVER AS VARIAVEIS DE OUTPUT PARA A AREA QUE SE
     * PRETENDE. POR EXEMPLO A WS-DATA-INI.
     * MOVE BHTW0015-DATE-FRM         TO WS-DATA-INI.
     * (FORMATO DATE YYYY-MM-DD)
     * MOVE BHTW0015-TIME-FRM         TO WS-HORA-INI.
     * (FORMATO TIME HH:MM:SS)
     * OU
     * MOVE BHTW0015-TMST-FRM         TO WS-CURRENT-TIMESTAMP.
     * (FORMATO TIMESTAMP 26 YYYY-MM-DD-HH.MM.SS.SSSSSS)
     * COPY DE FORMATACAO E OBTENCAO DE DATAS DE SISTEMA.
     * OBTEM A DATA DE SISTEMA COM SECULO E DISPONIBILIZA-A COM E SEM
     * FORMATACAO.
     * INSTRUCOES DE UTILIZACAO.
     * PERFORM BHTP0015-CURRENT-DATE
     * THRU BHTP0015-CURRENT-DATE-EXIT.
     * 
     */
    protected void bhtp0015CurrentDate() {
        bhtw0015().area().current().set(getTimeAsLong());
        bhtw0015().area().currentFrm().dateFrm().dateYearFrm().set(bhtw0015().area().current().currentDate().dateYear());
        bhtw0015().area().currentFrm().tmstFrm().tmstYearFrm().set(bhtw0015().area().current().currentDate().dateYear());
        bhtw0015().area().currentFrm().dateFrm().dateMonthFrm().set(bhtw0015().area().current().currentDate().dateMonth());
        bhtw0015().area().currentFrm().tmstFrm().tmstMonthFrm().set(bhtw0015().area().current().currentDate().dateMonth());
        bhtw0015().area().currentFrm().dateFrm().dateDayFrm().set(bhtw0015().area().current().currentDate().dateDay());
        bhtw0015().area().currentFrm().tmstFrm().tmstDayFrm().set(bhtw0015().area().current().currentDate().dateDay());
        bhtw0015().area().currentFrm().timeFrm().timeHhFrm().set(bhtw0015().area().current().currentTime().timeHour());
        bhtw0015().area().currentFrm().tmstFrm().tmstHhFrm().set(bhtw0015().area().current().currentTime().timeHour());
        bhtw0015().area().currentFrm().timeFrm().timeMmFrm().set(bhtw0015().area().current().currentTime().timeMin());
        bhtw0015().area().currentFrm().tmstFrm().tmstMmFrm().set(bhtw0015().area().current().currentTime().timeMin());
        bhtw0015().area().currentFrm().timeFrm().timeSsFrm().set(bhtw0015().area().current().currentTime().timeSec());
        bhtw0015().area().currentFrm().tmstFrm().tmstSsFrm().set(bhtw0015().area().current().currentTime().timeSec());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs1Frm().set(bhtw0015().area().current().currentTmst().tmstSs1());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs2Frm().set(bhtw0015().area().current().currentTmst().tmstSs2());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs3Frm().set(bhtw0015().area().current().currentTmst().tmstSs3());
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (ficheiroFwk299().getStatusOk()) {
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
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA ");
        m1100Inicializacoes() ;
        bhtp0011ObtemDados() ;
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        m8000DataHoraIni() ;
        bhop0013InicioEstat() ;
        m1200ObtemDataApl() ;
        m1300AbreFicheiros() ;
        m1400LeFwk299() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        log(TraceLevel.Debug, "1100-INICIALIZACOES");
        wsVariaveis().initialize() ;
        bhtl250a().commarea().initialize() ;
        hv00201Movhst().movhst().initialize() ;
    }
    
    /**
     * 
     * 1200-OBTEM-DATA-APL
     * 
     */
    protected void m1200ObtemDataApl() {
        log(TraceLevel.Debug, "1200-OBTEM-DATA-APL");
        bhtl250a().commarea().initialize() ;
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
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl250a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl250a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            m9000TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 1300-ABRE-FICHEIROS
     * 
     */
    protected void m1300AbreFicheiros() {
        log(TraceLevel.Debug, "1300-ABRE-FICHEIROS");
        ficheiroFwk299().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK299);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk299().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk299().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_OPEN_INPUT);
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK299);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk299().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK299);
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1400-LE-FWK299
     * 
     */
    protected void m1400LeFwk299() {
        log(TraceLevel.Debug, "1400-LE-FWK299");
        ficheiroFwk299().regFwk299().initialize() ;
        ficheiroFwk299().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK299);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk299().getStatus());
        bhop0013FormataAcesso() ;
        wsVariaveis().wsNContNibDstnAux().set(ficheiroFwk299().regFwk299().nContNibDstn());
        if (!ficheiroFwk299().getStatusOk() && !ficheiroFwk299().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_READ);
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK299);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk299().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK299);
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        wsVariaveis().wsTimestampAux().get(1, 10).set(ficheiroFwk299().regFwk299().zExeOpeAgnt()) ;
        wsVariaveis().wsTimestampAux().get(11, 16).set("-00.00.00.000000") ;
        m2300SelVgh10201() ;
        m2100UpdVgh00201() ;
        m2400SelVgh10201Dst() ;
        m2200UpdVgh00201Dst() ;
        m1400LeFwk299() ;
    }
    
    /**
     * 
     * 2100-UPD-VGH00201
     * 
     */
    protected void m2100UpdVgh00201() {
        log(TraceLevel.Debug, "2100-UPD-VGH00201");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(ficheiroFwk299().regFwk299().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(ficheiroFwk299().regFwk299().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(ficheiroFwk299().regFwk299().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(ficheiroFwk299().regFwk299().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(ficheiroFwk299().regFwk299().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(ficheiroFwk299().regFwk299().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(ficheiroFwk299().regFwk299().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(ficheiroFwk299().regFwk299().nsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(wsVariaveis().wsTimestampAux());
        hv00201Movhst().movhst().mMovimento().set(ficheiroFwk299().regFwk299().mOpeAgntEfcd());
        wsVariaveis().wsXRefMovAux().set(ficheiroFwk299().regFwk299().xDsc1Sibs());
        wsVariaveis().wsXRefMovAux().get(21, 1).set(ficheiroFwk299().regFwk299().xDsc2Sibs()) ;
        hv00201Movhst().movhst().cUsidActzUlt().set("PGHQ300A");
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq300a458(CON_APLIC, hv10201Movhstcpl().movhstcpl().nsMovimento(), wsVariaveis().wsXRefMovAux()) ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue() && !swSwitches().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00201);
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh00201());
            wsVariaveis().wsChaveAcesso().wsCPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
            wsVariaveis().wsChaveAcesso().wsCBancCont().set(hv00201Movhst().movhst().cBancCont());
            wsVariaveis().wsChaveAcesso().wsCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
            wsVariaveis().wsChaveAcesso().wsNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
            wsVariaveis().wsChaveAcesso().wsVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
            wsVariaveis().wsChaveAcesso().wsCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
            wsVariaveis().wsChaveAcesso().wsCMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
            wsVariaveis().wsChaveAcesso().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsChaveAcesso());
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2200-UPD-VGH00201-DST
     * 
     */
    protected void m2200UpdVgh00201Dst() {
        log(TraceLevel.Debug, "2200-UPD-VGH00201-DST");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(ficheiroFwk299().regFwk299().cPaisIsaCtaDtn());
        hv00201Movhst().movhst().cBancCont().set(ficheiroFwk299().regFwk299().cBancNibDstn());
        hv00201Movhst().movhst().cOeEgcCont().set(ficheiroFwk299().regFwk299().cOeNibDstn());
        hv00201Movhst().movhst().nsRdclCont().set(wsVariaveis().wsNibConvConta().wsNsRdclContAux());
        hv00201Movhst().movhst().vChkdCont().set(wsVariaveis().wsNibConvConta().wsVChkdContAux());
        hv00201Movhst().movhst().cTipoCont().set(wsVariaveis().wsNibConvConta().wsCTipoContAux());
        hv00201Movhst().movhst().cMoedIsoScta().set(ficheiroFwk299().regFwk299().cMoeIsoSctaDtn());
        hv00201Movhst().movhst().nsDeposito().set(ficheiroFwk299().regFwk299().nsDepSctaDstn());
        hv00201Movhst().movhst().tsMovimento().set(wsVariaveis().wsTimestampAux());
        hv00201Movhst().movhst().mMovimento().set(ficheiroFwk299().regFwk299().mOpeAgntEfcd());
        wsVariaveis().wsXRefMovAux().set(ficheiroFwk299().regFwk299().xDsc1Sibs());
        wsVariaveis().wsXRefMovAux().get(21, 1).set(ficheiroFwk299().regFwk299().xDsc2Sibs()) ;
        hv00201Movhst().movhst().cUsidActzUlt().set("PGHQ300A");
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq300a548(CON_APLIC, hv10201Movhstcpl().movhstcpl().nsMovimento(), wsVariaveis().wsXRefMovAux()) ;
        swSwitches().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh00201Ok().isTrue() && !swSwitches().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00201);
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh00201());
            wsVariaveis().wsChaveAcesso().wsCPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
            wsVariaveis().wsChaveAcesso().wsCBancCont().set(hv00201Movhst().movhst().cBancCont());
            wsVariaveis().wsChaveAcesso().wsCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
            wsVariaveis().wsChaveAcesso().wsNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
            wsVariaveis().wsChaveAcesso().wsVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
            wsVariaveis().wsChaveAcesso().wsCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
            wsVariaveis().wsChaveAcesso().wsCMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
            wsVariaveis().wsChaveAcesso().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsChaveAcesso());
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2300-SEL-VGH10201
     * 
     */
    protected void m2300SelVgh10201() {
        log(TraceLevel.Debug, "2300-SEL-VGH10201");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(ficheiroFwk299().regFwk299().cPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(ficheiroFwk299().regFwk299().cBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(ficheiroFwk299().regFwk299().cOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(ficheiroFwk299().regFwk299().nsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(ficheiroFwk299().regFwk299().vChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(ficheiroFwk299().regFwk299().cTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(ficheiroFwk299().regFwk299().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(ficheiroFwk299().regFwk299().nsDeposito());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(wsVariaveis().wsTimestampAux());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(ficheiroFwk299().regFwk299().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghq300a633(CON_APLIC) ;
        swSwitches().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH10201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh10201Ok().isTrue() && !swSwitches().swVgh10201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH10201);
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
            wsVariaveis().wsChaveAcesso().wsCPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
            wsVariaveis().wsChaveAcesso().wsCBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
            wsVariaveis().wsChaveAcesso().wsCOeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
            wsVariaveis().wsChaveAcesso().wsNsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
            wsVariaveis().wsChaveAcesso().wsVChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
            wsVariaveis().wsChaveAcesso().wsCTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
            wsVariaveis().wsChaveAcesso().wsCMoedIsoScta().set(hv10201Movhstcpl().movhstcpl().cMoedIsoScta());
            wsVariaveis().wsChaveAcesso().wsNsDeposito().set(hv10201Movhstcpl().movhstcpl().nsDeposito());
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsChaveAcesso());
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2400-SEL-VGH10201-DST
     * 
     */
    protected void m2400SelVgh10201Dst() {
        log(TraceLevel.Debug, "2400-SEL-VGH10201-DST");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(ficheiroFwk299().regFwk299().cPaisIsaCtaDtn());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(ficheiroFwk299().regFwk299().cBancNibDstn());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(ficheiroFwk299().regFwk299().cOeNibDstn());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(wsVariaveis().wsNibConvConta().wsNsRdclContAux());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(wsVariaveis().wsNibConvConta().wsVChkdContAux());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(wsVariaveis().wsNibConvConta().wsCTipoContAux());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(ficheiroFwk299().regFwk299().cMoeIsoSctaDtn());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(ficheiroFwk299().regFwk299().nsDepSctaDstn());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(wsVariaveis().wsTimestampAux());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(ficheiroFwk299().regFwk299().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghq300a718(CON_APLIC) ;
        swSwitches().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH10201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitches().swVgh10201Ok().isTrue() && !swSwitches().swVgh10201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH10201);
            bhtw0030().dadosEntrada().cSqlcode().set(swSwitches().swSqlcodeVgh10201());
            wsVariaveis().wsChaveAcesso().wsCPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
            wsVariaveis().wsChaveAcesso().wsCBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
            wsVariaveis().wsChaveAcesso().wsCOeEgcCont().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
            wsVariaveis().wsChaveAcesso().wsNsRdclCont().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
            wsVariaveis().wsChaveAcesso().wsVChkdCont().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
            wsVariaveis().wsChaveAcesso().wsCTipoCont().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
            wsVariaveis().wsChaveAcesso().wsCMoedIsoScta().set(hv10201Movhstcpl().movhstcpl().cMoedIsoScta());
            wsVariaveis().wsChaveAcesso().wsNsDeposito().set(hv10201Movhstcpl().movhstcpl().nsDeposito());
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsChaveAcesso());
            m9200TrataErroDb2() ;
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
        ficheiroFwk299().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK299);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk299().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk299().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_CLOSE_FI);
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK299);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk299().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK299);
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * PARAGRAFOS PADROES
     * 8000-DATA-HORA-INI
     * 
     */
    protected void m8000DataHoraIni() {
        log(TraceLevel.Debug, "8000-DATA-HORA-INI");
        bhtp0015CurrentDate() ;
        wsVariaveis().wsDataIni().set(bhtw0015().area().currentFrm().dateFrm());
        wsVariaveis().wsHoraIni().set(bhtw0015().area().currentFrm().timeFrm());
        wsVariaveis().wsTimestamp().set(bhtw0015().area().currentFrm().tmstFrm());
    }
    
    /**
     * 
     * 8100-DATA-HORA-FIM
     * 
     */
    protected void m8100DataHoraFim() {
        log(TraceLevel.Debug, "8100-DATA-HORA-FIM");
        bhtp0015CurrentDate() ;
        wsVariaveis().wsDataFim().set(bhtw0015().area().currentFrm().dateFrm());
        wsVariaveis().wsHoraFim().set(bhtw0015().area().currentFrm().timeFrm());
    }
    
    /**
     * 
     * 9000-TRATA-ERRO-ROTINA
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADA AS SE-
     * GUINTES VARIAVEIS:
     * BHTW0030-C-SQLCODE: SQLCODE DEVOLVIDO PELA ROTINA
     * BHTW0030-NM-TABELA: NOME TABELA DEVOLVIDO PELA ROTINA
     * BHTW0030-NM-PRG-CHMD: NOME PROGRAMA CHAMADO (ROTINA)
     * BHTW0030-C-TIPO-ERR-PRG-CHMD: ERRO DEVOLVIDO PELA PROGRAMA
     * CHAMADO (ROTINA) -
     * C-TIPO-ERRO-BBN
     * BHTW0030-X-CTEU-ALIG: DADOS DE INPUT DA ROTINA
     * BHTW0030-X-SUG-RTNO-SWAL: OBSERVACOES A RESPEITO DO ERRO
     * OCORRIDO (PREENCHER COM O NOME
     * DO PARAGRAFO DO PROGRAMA ONDE A
     * FALHA TEVE ORIGEM)
     * 
     */
    protected void m9000TrataErroRotina() {
        log(TraceLevel.Debug, "9000-TRATA-ERRO-ROTINA");
        m8100DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abend().setTrue() ;
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_ROTINA);
        bhop0013FimEstatistica() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9100-TRATA-ERRO-FICH
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADA AS SE-
     * GUINTES VARIAVEIS:
     * BHTW0030-C-TIPO-OPE-OBJ-DB2 :  CONFORME A OPERACAO EFECTUADA:
     * CON-OPEN-INPUT
     * CON-OPEN-OUTPUT
     * CON-OPEN-EXTEND
     * CON-READ
     * CON-WRITE
     * CON-CLOSE-FI
     * BHTW0030-NM-FICHEIRO : NOME FICHEIRO
     * BHTW0030-C-FSTT-COBL: FILE STATUS
     * BHTW0030-X-SUG-RTNO-SWAL: DESCRICAO DO ERRO
     * 
     */
    protected void m9100TrataErroFich() {
        log(TraceLevel.Debug, "9100-TRATA-ERRO-FICH");
        m8100DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhop0013FimEstatistica() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9200-TRATA-ERRO-DB2
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADA AS SE-
     * GUINTES VARIAVEIS:
     * BHTW0030-C-SQLCODE : SQLCODE RETORNADO PELA OPERACAO DB2
     * BHTW0030-NM-TABELA: NOME DA TABELA CUJO ACESSO RETORNOU ERRO
     * BHTW0030-C-TIPO-OPE-OBJ-DB2: CONFORME A OPERACAO EFECTUADA:
     * CON-OPEN-CRS
     * CON-FETCH
     * CON-CLOSE-CRS
     * CON-SELECT
     * CON-INSERT
     * CON-UPDATE
     * CON-DELETE
     * BHTW0030-X-CTEU-CHAV-TAB: CHV DE ACESSO A TABELA
     * (CONDICOES DA CLAUSULA WHERE)
     * BHTW0030-X-SUG-RTNO-SWAL: DESCRICAO DO ERRO
     * 
     */
    protected void m9200TrataErroDb2() {
        log(TraceLevel.Debug, "9200-TRATA-ERRO-DB2");
        m8100DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abendDb2().setTrue() ;
        bhop0013FimEstatistica() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFwk299().close() ;
        /**
         * BHTP0031 - BATCH SEM DB2
         * ROLLBACK E FORMATACAO DE RETURN-CODE
         */
        rollback() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
        /**
         * FORMATACAO DE RETURN-CODE E ROLLBACK
         */
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
        IString wsHoraIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        /**
         * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
         * @return instancia da classe local WsChaveAcesso
         */
        @Data
        WsChaveAcesso wsChaveAcesso() ;
        
        @Data(size=11)
        ILong wsNContNibDstnAux() ;
        
        /**
         * @return instancia da classe local WsNibConvConta
         */
        @Data
        @Mask
        WsNibConvConta wsNibConvConta() ;
        
        @Data(size=26)
        IString wsTimestampAux() ;
        
        @Data(size=21)
        IString wsXRefMovAux() ;
        
        
        
        /**
         * 
         * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
         * 
         * @version 2.0
         * 
         */
        public interface WsChaveAcesso extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaCont() ;
            
            @Data(size=4)
            IInt wsCBancCont() ;
            
            @Data(size=4)
            IInt wsCOeEgcCont() ;
            
            @Data(size=7)
            IInt wsNsRdclCont() ;
            
            @Data(size=1)
            IInt wsVChkdCont() ;
            
            @Data(size=3)
            IInt wsCTipoCont() ;
            
            @Data(size=3)
            IString wsCMoedIsoScta() ;
            
            @Data(size=4)
            IInt wsNsDeposito() ;
            
        }
        
        public interface WsNibConvConta extends IDataMask {
            
            @Data(size=1)
            IInt wsCTipoContAux1() ;
            
            @Data(size=7)
            IInt wsNsRdclContAux() ;
            
            @Data(size=1)
            IInt wsVChkdContAux() ;
            
            @Data(size=2)
            IInt wsCTipoContAux() ;
            
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
        IString statusFwk299() ;
        @Data
        @Condition("00")
        ICondition swFwk299Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk299Fim() ;
        
        
        /**
         * ----- DB2
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh00201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh00201Null() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh10201() ;
        @Data
        @Condition("0")
        ICondition swVgh10201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh10201Notfnd() ;
        @Data
        @Condition("-803")
        ICondition swVgh10201Dupkey() ;
        @Data
        @Condition("-305")
        ICondition swVgh10201Null() ;
        
        
    }
    
}
