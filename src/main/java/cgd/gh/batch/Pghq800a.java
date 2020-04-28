package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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


/**
 * 
 * WORKING-STORAGE SECTION.
 * AREA DE INCLUDE DB2 - DCLGENS DAS TABELAS UTLIZADAS
 * VIEW DA TABELA DE MOVIMENTOS DE HISTORICO
 * DECLARACAO DE CURSORES
 * CURSOR S/ A TABELA DE MOVIMENTOS HISTORICO - INF. COMPLEMENTAR
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq800a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
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
     * @return instancia da classe Fgh800
     */
    @Handler(name="FGH800", record="regFgh800Pghq800a")
    @Data
    protected abstract Fgh800 ficheiroFgh800() ;
    
    /**
     * @return instancia da classe Fgh801
     */
    @Handler(name="FGH801", record="regFgh801Pghq800a")
    @Data
    protected abstract Fgh801 ficheiroFgh801() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ800A" ;
    
    protected static final String CON_DESCRICAO = "ACTUALIZACAO DE DESCRITIVOS" ;
    
    protected static final String CON_FGH800 = "FGH800" ;
    
    protected static final String CON_FGH801 = "FGH801" ;
    
    protected static final String CON_ZERO = "0" ;
    
    protected static final int CON_1 = 1 ;
    
    protected static final String CON_S = "S" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_VGH10201 = "VGH10201" ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    
    
    /**
     * 
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "------------INICIO - PGHQ800A -------------");
        m1000InicioPrograma() ;
        while (ficheiroFgh800().getStatusOk()) {
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
        log(TraceLevel.Debug, "-- 1000-INICIO-PROGRAMA");
        m1100Inicializacoes() ;
        m1200OpenFichInp() ;
        m1300ReadFichInp() ;
        m1400OpenFichTgh102() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        log(TraceLevel.Debug, "-- 1100-INICIALIZACOES");
        wsVariaveis().initialize() ;
        bhtw0030().dadosEntrada().initialize() ;
        bhtw0033().dadosGerais().initialize() ;
        hv00201Movhst().movhst().initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
        bhtp0011ObtemDados() ;
        bhtp0033AbreEstat() ;
        bhtp0015CurrentDate() ;
        bhtw0033().dadosGerais().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0033().dadosGerais().dFunlPrg().set(CON_DESCRICAO);
        bhtw0033().dadosGerais().zInicPrct().set(bhtw0015().area().currentFrm().dateFrm());
        bhtw0030().dadosEntrada().zInicExePrg().set(bhtw0015().area().currentFrm().dateFrm());
        bhtw0033().dadosGerais().hInicPrct().set(bhtw0015().area().currentFrm().timeFrm());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhtw0015().area().currentFrm().timeFrm());
        bhtp0033WriteEstatCab() ;
    }
    
    /**
     * 
     * 1200-OPEN-FICH-INP
     * 
     */
    protected void m1200OpenFichInp() {
        log(TraceLevel.Debug, "-- 1200-OPEN-FICH-INP");
        ficheiroFgh800().open() ;
        if (!ficheiroFgh800().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH800);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh800().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO OPEN DO FICHEIRO FGH800");
            m9100TrataErro() ;
        } else {
            swStatus().swOpeAgntNotfnd().setTrue() ;
        }
    }
    
    /**
     * 
     * 1300-READ-FICH-INP
     * 
     */
    protected void m1300ReadFichInp() {
        log(TraceLevel.Debug, "-- 1300-READ-FICH-INP");
        ficheiroFgh800().read() ;
        if (ficheiroFgh800().getStatusOk()) {
            wsVariaveis().wsTotReadFgh800().add(1);
            wsVariaveis().wsTotReadFgh800Aux().add(1);
        } else if (!ficheiroFgh800().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH800);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh800().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO READ DO FICHEIRO FGH800");
            m9100TrataErro() ;
        }
    }
    
    /**
     * 
     * 1400-OPEN-FICH-TGH102
     * 
     */
    protected void m1400OpenFichTgh102() {
        log(TraceLevel.Debug, "-- 1400-OPEN-FICH-TGH102");
        ficheiroFgh801().open() ;
        if (!ficheiroFgh801().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH801);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh801().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO OPEN DO FICHEIRO FGH801");
            m9100TrataErro() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "-- 2000-PROCESSO-PROGRAMA");
        log(TraceLevel.Debug, "--- FGH800-Z-PROCESSAMENTO: ", ficheiroFgh800().regFgh800Pghq800a().fgh800ZProcessamento());
        log(TraceLevel.Debug, "--- FGH800-N-JOUR-BBN     : ", ficheiroFgh800().regFgh800Pghq800a().fgh800NJourBbn());
        swStatus().swNsJourBbn1().setTrue() ;
        while (swStatus().swNsJourBbn1().isTrue()) {
            m2300TrataDescricao() ;
        }
        if (wsVariaveis().wsTotReadFgh800Aux().isEqual(500)) {
            commit() ;
            wsVariaveis().wsTotReadFgh800Aux().set(0);
        }
        m1300ReadFichInp() ;
    }
    
    /**
     * 
     * 2300-TRATA-DESCRICAO
     * 
     */
    protected void m2300TrataDescricao() {
        log(TraceLevel.Debug, "-- 2300-TRATA-DESCRICAO");
        log(TraceLevel.Debug, "--- FGH800-X-DSC1-SIBS  : ", ficheiroFgh800().regFgh800Pghq800a().fgh800XDsc1Sibs());
        log(TraceLevel.Debug, "--- FGH800-D-MOV-CADN   : ", ficheiroFgh800().regFgh800Pghq800a().fgh800DMovCadn());
        log(TraceLevel.Debug, "--- FGH800-X-REF-ADI-MOV: ", ficheiroFgh800().regFgh800Pghq800a().fgh800XRefAdiMov());
        m2310ReadFichTgh102() ;
        if (ficheiroFgh800().regFgh800Pghq800a().fgh800XDsc1Sibs().isEmpty()) {
            wsVariaveis().wsXRefMov().get(1, 9).set(ficheiroFgh800().regFgh800Pghq800a().fgh800DMovCadn()) ;
            wsVariaveis().wsXRefMov().get(10, 12).set(ficheiroFgh800().regFgh800Pghq800a().fgh800XRefAdiMov()) ;
        } else {
            wsVariaveis().wsXRefMov().set(ficheiroFgh800().regFgh800Pghq800a().fgh800XDsc1Sibs());
        }
        m2320ActzXRefMov() ;
        if (ficheiroFgh801().regFgh801Pghq800a().fgh801CUserid().isEqual("PVGS913A")) {
            m2330ActzUserid() ;
        }
    }
    
    /**
     * 
     * 2310-READ-FICH-TGH102
     * 
     */
    protected void m2310ReadFichTgh102() {
        log(TraceLevel.Debug, "-- 2310-READ-FICH-TGH102");
        log(TraceLevel.Debug, "--- FGH801-TS-MOVIMENTO: ", ficheiroFgh801().regFgh801Pghq800a().fgh801TsMovimento());
        log(TraceLevel.Debug, "--- FGH801-N-JOUR-BBN  : ", ficheiroFgh801().regFgh801Pghq800a().fgh801NJourBbn());
        log(TraceLevel.Debug, "--- FGH801-NS-JOUR-BBN : ", ficheiroFgh801().regFgh801Pghq800a().fgh801NsJourBbn());
        ficheiroFgh801().read() ;
        if (ficheiroFgh801().getStatusOk()) {
            wsVariaveis().wsTotReadFgh801().add(1);
            if (ficheiroFgh801().regFgh801Pghq800a().fgh801NsJourBbn().isEqual(2)) {
                swStatus().swNsJourBbn2().setTrue() ;
            }
        } else if (!ficheiroFgh801().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH800);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh800().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO READ DO FICHEIRO FGH801");
            m9100TrataErro() ;
        }
    }
    
    /**
     * 
     * 2320-ACTZ-X-REF-MOV
     * 
     */
    protected void m2320ActzXRefMov() {
        log(TraceLevel.Debug, "-- 2320-ACTZ-X-REF-MOV");
        log(TraceLevel.Debug, "--- WS-X-REF-MOV        : ", wsVariaveis().wsXRefMov());
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().xRefMov().set(wsVariaveis().wsXRefMov());
        hv00201Movhst().movhst().cPaisIsoaCont().set(ficheiroFgh801().regFgh801Pghq800a().fgh801CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(ficheiroFgh801().regFgh801Pghq800a().fgh801CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(ficheiroFgh801().regFgh801Pghq800a().fgh801COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(ficheiroFgh801().regFgh801Pghq800a().fgh801NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(ficheiroFgh801().regFgh801Pghq800a().fgh801VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(ficheiroFgh801().regFgh801Pghq800a().fgh801CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(ficheiroFgh801().regFgh801Pghq800a().fgh801CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(ficheiroFgh801().regFgh801Pghq800a().fgh801NsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(ficheiroFgh801().regFgh801Pghq800a().fgh801TsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(ficheiroFgh801().regFgh801Pghq800a().fgh801NsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq800a656() ;
        swStatus().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        if (!swStatus().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0033().dadosDb2().update().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosDb2().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH00201);
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO GRAVE NO UPDATE DA TABELA TGH00002");
            m9100TrataErro() ;
        } else {
            wsVariaveis().wsQUpdVgh00201().add(1);
            wsVariaveis().wsQUpdVgh00201Aux().add(1);
        }
    }
    
    /**
     * 
     * 2330-ACTZ-USERID
     * 
     */
    protected void m2330ActzUserid() {
        log(TraceLevel.Debug, "-- 2330-ACTZ-USERID");
        hv10201Movhstcpl().movhstcpl().cUserid().set("PVGS903A");
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().updatePghq800a703(ficheiroFgh801().regFgh801Pghq800a().fgh801CPaisIsoaCont(), ficheiroFgh801().regFgh801Pghq800a().fgh801CBancCont(), ficheiroFgh801().regFgh801Pghq800a().fgh801COeEgcCont(), ficheiroFgh801().regFgh801Pghq800a().fgh801NsRdclCont(), ficheiroFgh801().regFgh801Pghq800a().fgh801VChkdCont(), ficheiroFgh801().regFgh801Pghq800a().fgh801CTipoCont(), ficheiroFgh801().regFgh801Pghq800a().fgh801CMoedIsoScta(), ficheiroFgh801().regFgh801Pghq800a().fgh801NsDeposito(), ficheiroFgh801().regFgh801Pghq800a().fgh801TsMovimento(), ficheiroFgh801().regFgh801Pghq800a().fgh801NsMovimento()) ;
        swStatus().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        if (!swStatus().swVgh10201Ok().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0033().dadosDb2().update().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosDb2().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH10201);
            bhtw0030().dadosEntrada().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO GRAVE NO UPDATE DA TABELA TGH00102");
            m9100TrataErro() ;
        } else {
            wsVariaveis().wsQUpdVgh10201().add(1);
        }
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "-- 3000-FINAL-PROGRAMA");
        m3200CloseFichInp() ;
        m3300CloseFichTgh102() ;
        m3400DisplayFinal() ;
    }
    
    /**
     * 
     * 3200-CLOSE-FICH-INP
     * 
     */
    protected void m3200CloseFichInp() {
        log(TraceLevel.Debug, "-- 3200-CLOSE-FICH-INP");
        ficheiroFgh800().close() ;
        if (!ficheiroFgh800().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH800);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh800().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO CLOSE DO FICHEIRO FGH800");
            m9100TrataErro() ;
        }
    }
    
    /**
     * 
     * 3300-CLOSE-FICH-TGH102
     * 
     */
    protected void m3300CloseFichTgh102() {
        log(TraceLevel.Debug, "-- 3300-CLOSE-FICH-TGH102");
        ficheiroFgh801().close() ;
        if (!ficheiroFgh801().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH801);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh801().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO CLOSE DO FICHEIRO FGH801");
            m9100TrataErro() ;
        }
    }
    
    /**
     * 
     * 3400-DISPLAY-FINAL
     * 
     */
    protected void m3400DisplayFinal() {
        log(TraceLevel.Trace, "-------------------------------------------------");
        log(TraceLevel.Trace, "--- ESTATISTICA FINAL - CONTROLO DE PROCESSAMENTO");
        log(TraceLevel.Trace, "-");
        log(TraceLevel.Trace, "-- QTD TOTAL OPE - FICH INPUT : ", wsVariaveis().wsTotReadFgh800());
        log(TraceLevel.Trace, "-- QTD TOTAL MOV - FICH TGH102: ", wsVariaveis().wsTotReadFgh801());
        log(TraceLevel.Trace, "-- QTD TOTAL MOV - UPD TGH002 : ", wsVariaveis().wsQUpdVgh00201());
        log(TraceLevel.Trace, "-- QTD TOTAL MOV - UPD TGH102 : ", wsVariaveis().wsQUpdVgh10201());
        log(TraceLevel.Trace, "-");
        log(TraceLevel.Trace, "------------------------------------------------");
    }
    
    /**
     * 
     * 3500-ESCREVE-ESTAT
     * 
     */
    protected void m3500EscreveEstat() {
        log(TraceLevel.Debug, "-- 3500-ESCREVE-ESTAT");
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
        wsVariaveis().wsHoraFim().set( getDBTime() ) ;
        bhtw0033().dadosGerais().zFimPrct().set(wsVariaveis().wsDataFim());
        bhtw0033().dadosGerais().hFimPrct().set(wsVariaveis().wsHoraFim());
        bhtw0033().dadosDb2().cSqlcode().set("0");
        /**
         * \* READ - FICHEIRO DE INPUT
         */
        bhtw0033().dadosFicheiros().nmFicheiro().set(CON_FGH800);
        bhtw0033().dadosFicheiros().readSequential().setTrue() ;
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotReadFgh800());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFgh800().getStatus());
        bhtp0033WriteEstatF() ;
        /**
         * \* READ - FICHEIRO DE INPUT
         */
        bhtw0033().dadosFicheiros().nmFicheiro().set(CON_FGH801);
        bhtw0033().dadosFicheiros().readSequential().setTrue() ;
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotReadFgh801());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFgh801().getStatus());
        bhtp0033WriteEstatF() ;
        /**
         * \* UPDATE - TGH00002
         */
        bhtw0033().dadosDb2().nmTabela().set(CON_VGH00201);
        bhtw0033().dadosDb2().qAcesTab().set(wsVariaveis().wsQUpdVgh00201());
        bhtw0033().dadosDb2().cSqlcode().set(swStatus().swSqlcodeVgh00201());
        bhtw0033().dadosDb2().update().setTrue() ;
        bhtp0033WriteEstat() ;
        /**
         * \* UPDATE - TGH00102
         */
        bhtw0033().dadosDb2().nmTabela().set(CON_VGH10201);
        bhtw0033().dadosDb2().qAcesTab().set(wsVariaveis().wsQUpdVgh10201());
        bhtw0033().dadosDb2().cSqlcode().set(swStatus().swSqlcodeVgh10201());
        bhtw0033().dadosDb2().update().setTrue() ;
        bhtp0033WriteEstat() ;
        /**
         * \* FECHO DO FICHEIRO DE ESTATISTICAS
         */
        bhtp0033FechaEstat() ;
    }
    
    /**
     * 
     * 9100-TRATA-ERRO
     * 
     */
    protected void m9100TrataErro() {
        log(TraceLevel.Debug, "-- 9100-TRATA-ERRO");
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
        wsVariaveis().wsHoraFim().set( getDBTime() ) ;
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        m3400DisplayFinal() ;
        m3500EscreveEstat() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtp0030DisplayErro() ;
        /**
         * BHTP0031 - BATCH SEM DB2
         * ROLLBACK E FORMATACAO DE RETURN-CODE
         */
        rollback() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
        /**
         * 9900-ABEND
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
        
        @Data(size=1, value=" ")
        IString wsSysin() ;
        
        /**
         * @return instancia da classe local WsTimestamp
         */
        @Data
        WsTimestamp wsTimestamp() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value="0")
        ILong wsQSelVgh10201() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFgh801() ;
        
        @Data(size=10, value="0")
        ILong wsQUpdVgh00201() ;
        
        @Data(size=10, value="0")
        ILong wsQUpdVgh10201() ;
        
        @Data(size=10, value="0")
        ILong wsQUpdVgh00201Aux() ;
        
        @Data(size=10, value="0")
        ILong wsQOpeAgnt() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFgh800() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFgh800Aux() ;
        
        /**
         * @return instancia da classe local WsTsMovAux
         */
        @Data
        WsTsMovAux wsTsMovAux() ;
        
        /**
         * @return instancia da classe local WsTsIniAux
         */
        @Data
        WsTsIniAux wsTsIniAux() ;
        
        /**
         * @return instancia da classe local WsTsFimAux
         */
        @Data
        WsTsFimAux wsTsFimAux() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimentoIni() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimentoFim() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimentoAux() ;
        
        @Data(size=21, value=" ")
        IString wsXRefMov() ;
        
        @Data(size=9, signed=true, value="0", compression=COMP3)
        ILong wsNJourBbnAux() ;
        
        @Data(size=8, value=" ")
        IString wsCUseridIni() ;
        
        @Data(size=8, value=" ")
        IString wsCUseridFim() ;
        
        
        public interface WsTimestamp extends IDataStruct {
            
            /**
             * @return instancia da classe local WsDataAux2
             */
            @Data
            WsDataAux2 wsDataAux2() ;
            
            /**
             * @return instancia da classe local WsHoraAux2
             */
            @Data(lpadding=1, rpadding=7, lpaddingValue="-", rpaddingValue="-")
            WsHoraAux2 wsHoraAux2() ;
            
            
            public interface WsDataAux2 extends IDataStruct {
                
                @Data(size=2)
                IString wsDataAux2Sec() ;
                
                @Data(size=2)
                IString wsDataAux2Ano() ;
                
                @Data(size=2, lpadding=1, lpaddingValue="-")
                IString wsDataAux2Mes() ;
                
                @Data(size=2, lpadding=1, lpaddingValue="-")
                IString wsDataAux2Dia() ;
                
            }
            
            public interface WsHoraAux2 extends IDataStruct {
                
                @Data(size=2)
                IString wsHoraAux2H() ;
                
                @Data(size=2, lpadding=1, lpaddingValue=".")
                IString wsHoraAux2M() ;
                
                @Data(size=2, lpadding=1, lpaddingValue=".")
                IString wsHoraAux2S() ;
                
            }
        }
        
        public interface WsTsMovAux extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsTsMovAux1() ;
            
            @Data(size=16, value="-00.00.00.000000")
            IString wsTsMovAux2() ;
            
        }
        
        public interface WsTsIniAux extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsTsIniAux1() ;
            
            @Data(size=16, value="-00.00.00.000000")
            IString wsTsIniAux2() ;
            
        }
        
        public interface WsTsFimAux extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsTsFimAux1() ;
            
            @Data(size=16, value="-00.00.00.000000")
            IString wsTsFimAux2() ;
            
        }
    }
    
    /**
     * 
     * SWITCHES
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
        IString statusFgh800() ;
        @Data
        @Condition("00")
        ICondition swFgh800Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh800Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh801() ;
        @Data
        @Condition("00")
        ICondition swFgh801Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh801Eof() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh10201() ;
        @Data
        @Condition("0")
        ICondition swVgh10201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh10201Notfnd() ;
        
        
        @Data(size=1, value=" ")
        IString swOpeAgnt() ;
        @Data
        @Condition("S")
        ICondition swOpeAgntOk() ;
        @Data
        @Condition("N")
        ICondition swOpeAgntNotfnd() ;
        
        
        @Data(size=1, value=" ")
        IString swNsJourBbn() ;
        @Data
        @Condition("1")
        ICondition swNsJourBbn1() ;
        @Data
        @Condition("2")
        ICondition swNsJourBbn2() ;
        
        
    }
    
}
