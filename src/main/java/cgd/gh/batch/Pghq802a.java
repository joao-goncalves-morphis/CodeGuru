package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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


/**
 * 
 * WORKING-STORAGE SECTION.
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq802a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fgh802
     */
    @Handler(name="FGH802", record="regFgh802Pghq802a")
    @Data
    protected abstract Fgh802 ficheiroFgh802() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ802A" ;
    
    protected static final String CON_DESCRICAO = "ACTUALIZACAO DE DESCRITIVOS" ;
    
    protected static final String CON_FGH802 = "FGH802" ;
    
    protected static final String CON_ZERO = "0" ;
    
    protected static final int CON_1 = 1 ;
    
    protected static final String CON_S = "S" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_VGH10201 = "VGH10201" ;
    
    protected static final String CON_104 = "IRS                  " ;
    
    protected static final String CON_163 = "IMPOSTO DE SELO      " ;
    
    protected static final String CON_160 = "IMT                  " ;
    
    protected static final String CON_111 = "IMI                  " ;
    
    protected static final String CON_117 = "COIMA                " ;
    
    protected static final String CON_118 = "EXECUÇAO FISCAL      " ;
    
    protected static final String CON_171 = "EXECUÇÃO FISCAL      " ;
    
    protected static final String CON_176 = "PENHORA              " ;
    
    protected static final String CON_501 = "ERS-TX MANUTENÇÃO    " ;
    
    protected static final String CON_703 = "GUIAS TRIBUNAL       " ;
    
    protected static final String CON_167 = "IUC                  " ;
    
    protected static final String CON_511 = "ISP                  " ;
    
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
        log(TraceLevel.Debug, "------------INICIO - PGHQ802A -------------");
        m1000InicioPrograma() ;
        while (ficheiroFgh802().getStatusOk()) {
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
        ficheiroFgh802().open() ;
        if (!ficheiroFgh802().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH802);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh802().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO OPEN DO FICHEIRO FGH802");
            m9100TrataErro() ;
        }
    }
    
    /**
     * 
     * 1300-READ-FICH-INP
     * 
     */
    protected void m1300ReadFichInp() {
        log(TraceLevel.Debug, "-- 1300-READ-FICH-INP");
        ficheiroFgh802().read() ;
        if (ficheiroFgh802().getStatusOk()) {
            wsVariaveis().wsTotReadFgh802().add(1);
            wsVariaveis().wsTotReadFgh802Aux().add(1);
        } else if (!ficheiroFgh802().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH802);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh802().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO READ DO FICHEIRO FGH802");
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
        m2300TrataDescricao() ;
        if (wsVariaveis().wsTotReadFgh802Aux().isEqual(250)) {
            commit() ;
            wsVariaveis().wsTotReadFgh802Aux().set(0);
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
        log(TraceLevel.Debug, "-- FGH802-C-PAIS-ISOA-CONT: ", ficheiroFgh802().regFgh802Pghq802a().fgh802CPaisIsoaCont());
        log(TraceLevel.Debug, "-- FGH802-C-BANC-CONT     : ", ficheiroFgh802().regFgh802Pghq802a().fgh802CBancCont());
        log(TraceLevel.Debug, "-- FGH802-C-OE-EGC-CONT   : ", ficheiroFgh802().regFgh802Pghq802a().fgh802COeEgcCont());
        log(TraceLevel.Debug, "-- FGH802-NS-RDCL-CONT    : ", ficheiroFgh802().regFgh802Pghq802a().fgh802NsRdclCont());
        log(TraceLevel.Debug, "-- FGH802-V-CHKD-CONT     : ", ficheiroFgh802().regFgh802Pghq802a().fgh802VChkdCont());
        log(TraceLevel.Debug, "-- FGH802-C-TIPO-CONT     : ", ficheiroFgh802().regFgh802Pghq802a().fgh802CTipoCont());
        log(TraceLevel.Debug, "-- FGH802-C-MOED-ISO-SCTA : ", ficheiroFgh802().regFgh802Pghq802a().fgh802CMoedIsoScta());
        log(TraceLevel.Debug, "-- FGH802-NS-DEPOSITO     : ", ficheiroFgh802().regFgh802Pghq802a().fgh802NsDeposito());
        log(TraceLevel.Debug, "-- FGH802-Z-EXE-OPE-AGNT  : ", ficheiroFgh802().regFgh802Pghq802a().fgh802ZExeOpeAgnt());
        log(TraceLevel.Debug, "-- FGH802-N-JOUR-BBN      : ", ficheiroFgh802().regFgh802Pghq802a().fgh802NJourBbn());
        log(TraceLevel.Debug, "-- FGH802-NS-JOUR-BBN     : ", ficheiroFgh802().regFgh802Pghq802a().fgh802NsJourBbn());
        m2310ObtemNsMov() ;
        m2320ActzXRefMov() ;
    }
    
    /**
     * 
     * 2310-OBTEM-NS-MOV
     * 
     */
    protected void m2310ObtemNsMov() {
        log(TraceLevel.Debug, "-- 2310-OBTEM-NS-MOV");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(ficheiroFgh802().regFgh802Pghq802a().fgh802NsDeposito());
        wsVariaveis().wsTsMovAux().wsTsMovAux1().set(ficheiroFgh802().regFgh802Pghq802a().fgh802ZExeOpeAgnt());
        wsVariaveis().wsTsMovAux().wsTsMovAux2().set("-00.00.00.000000");
        wsVariaveis().wsTsMovimento().set(wsVariaveis().wsTsMovAux());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(wsVariaveis().wsTsMovimento());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(ficheiroFgh802().regFgh802Pghq802a().fgh802NJourBbn());
        hv10201Movhstcpl().movhstcpl().cUserid().set("PVGS903A");
        log(TraceLevel.Trace, "VGH10201-TS-MOVIMENTO: ", hv10201Movhstcpl().movhstcpl().tsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghq802a478() ;
        swStatus().swSqlcodeVgh10201().set(hv10201Movhstcpl().getPersistenceCode());
        if (!swStatus().swVgh10201Ok().isTrue()) {
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            bhtw0033().dadosDb2().select().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosDb2().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH10201);
            bhtw0030().dadosEntrada().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO GRAVE NO SELECT DA TABELA TGH00102");
            m9100TrataErro() ;
        } else {
            wsVariaveis().wsQSelVgh10201().add(1);
        }
    }
    
    /**
     * 
     * 2320-ACTZ-X-REF-MOV
     * 
     */
    protected void m2320ActzXRefMov() {
        log(TraceLevel.Debug, "-- 2320-ACTZ-X-REF-MOV");
        hv00201Movhst().movhst().initialize() ;
        wsVariaveis().wsCRefSrvEspSibs().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CRefSrvEspSibs());
        wsVariaveis().wsCRSrvSibsAux().set(wsVariaveis().wsCRefSrvEspSibs().get(1, 3));
        log(TraceLevel.Trace, "WS-C-R-SRV-SIBS-AUX: ", wsVariaveis().wsCRSrvSibsAux());
        switch (wsVariaveis().wsCRSrvSibsAux().get()) {
            case 104:
                hv00201Movhst().movhst().xRefMov().set(CON_104);
                wsVariaveis().ws104().add(1);
                break;
            case 163:
                hv00201Movhst().movhst().xRefMov().set(CON_163);
                wsVariaveis().ws163().add(1);
                break;
            case 160:
                hv00201Movhst().movhst().xRefMov().set(CON_160);
                wsVariaveis().ws160().add(1);
                break;
            case 111:
                hv00201Movhst().movhst().xRefMov().set(CON_111);
                wsVariaveis().ws111().add(1);
                break;
            case 117:
                hv00201Movhst().movhst().xRefMov().set(CON_117);
                wsVariaveis().ws117().add(1);
                break;
            case 118:
                hv00201Movhst().movhst().xRefMov().set(CON_118);
                wsVariaveis().ws118().add(1);
                break;
            case 171:
                hv00201Movhst().movhst().xRefMov().set(CON_171);
                wsVariaveis().ws171().add(1);
                break;
            case 176:
                hv00201Movhst().movhst().xRefMov().set(CON_176);
                wsVariaveis().ws176().add(1);
                break;
            case 501:
                hv00201Movhst().movhst().xRefMov().set(CON_501);
                wsVariaveis().ws501().add(1);
                break;
            case 703:
                hv00201Movhst().movhst().xRefMov().set(CON_703);
                wsVariaveis().ws703().add(1);
                break;
            case 167:
                hv00201Movhst().movhst().xRefMov().set(CON_167);
                wsVariaveis().ws167().add(1);
                break;
            case 511:
                hv00201Movhst().movhst().xRefMov().set(CON_511);
                wsVariaveis().ws511().add(1);
                break;
            default :
                break ;
        }
        hv00201Movhst().movhst().cPaisIsoaCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(ficheiroFgh802().regFgh802Pghq802a().fgh802CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(ficheiroFgh802().regFgh802Pghq802a().fgh802NsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
        log(TraceLevel.Trace, "VGH00201-NS-MOVIMENTO: ", hv00201Movhst().movhst().nsMovimento());
        log(TraceLevel.Trace, "VGH00201-X-REF-MOV   : ", hv00201Movhst().movhst().xRefMov());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq802a588() ;
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
        m3400DisplayFinal() ;
    }
    
    /**
     * 
     * 3200-CLOSE-FICH-INP
     * 
     */
    protected void m3200CloseFichInp() {
        log(TraceLevel.Debug, "-- 3200-CLOSE-FICH-INP");
        ficheiroFgh802().close() ;
        if (!ficheiroFgh802().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH802);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh802().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO CLOSE DO FICHEIRO FGH802");
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
        log(TraceLevel.Trace, "-- QTD TOTAL OPE - FICH INPUT : ", wsVariaveis().wsTotReadFgh802());
        log(TraceLevel.Trace, "-- QTD TOTAL MOV - UPD TGH002 : ", wsVariaveis().wsQUpdVgh00201());
        log(TraceLevel.Trace, "-- QTD TOTAL MOV - SEL TGH102 : ", wsVariaveis().wsQSelVgh10201());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-104 -> 10");
        log(TraceLevel.Trace, "-- QTD REF-104 MOV - UPD TGH002 : ", wsVariaveis().ws104());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-163 -> 13");
        log(TraceLevel.Trace, "-- QTD REF-163 MOV - UPD TGH002 : ", wsVariaveis().ws163());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-160 -> 1");
        log(TraceLevel.Trace, "-- QTD REF-160 MOV - UPD TGH002 : ", wsVariaveis().ws160());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-111 -> 31");
        log(TraceLevel.Trace, "-- QTD REF-111 MOV - UPD TGH002 : ", wsVariaveis().ws111());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-117 -> 5");
        log(TraceLevel.Trace, "-- QTD REF-117 MOV - UPD TGH002 : ", wsVariaveis().ws117());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-118 -> 12");
        log(TraceLevel.Trace, "-- QTD REF-118 MOV - UPD TGH002 : ", wsVariaveis().ws118());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-171 -> 12");
        log(TraceLevel.Trace, "-- QTD REF-171 MOV - UPD TGH002 : ", wsVariaveis().ws171());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-176 -> 2");
        log(TraceLevel.Trace, "-- QTD REF-176 MOV - UPD TGH002 : ", wsVariaveis().ws176());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-501 -> 2");
        log(TraceLevel.Trace, "-- QTD REF-501 MOV - UPD TGH002 : ", wsVariaveis().ws501());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-703 -> 3");
        log(TraceLevel.Trace, "-- QTD REF-703 MOV - UPD TGH002 : ", wsVariaveis().ws703());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-167 -> 464");
        log(TraceLevel.Trace, "-- QTD REF-167 MOV - UPD TGH002 : ", wsVariaveis().ws167());
        log(TraceLevel.Trace, "-- QTD TOTAL DE REF-511 -> 2");
        log(TraceLevel.Trace, "-- QTD REF-511 MOV - UPD TGH002 : ", wsVariaveis().ws511());
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
        bhtw0033().dadosFicheiros().nmFicheiro().set(CON_FGH802);
        bhtw0033().dadosFicheiros().readSequential().setTrue() ;
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotReadFgh802());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFgh802().getStatus());
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
         * \* SELECT - TGH00102
         */
        bhtw0033().dadosDb2().nmTabela().set(CON_VGH10201);
        bhtw0033().dadosDb2().qAcesTab().set(wsVariaveis().wsQSelVgh10201());
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
        ILong wsQUpdVgh00201() ;
        
        @Data(size=10, value="0")
        ILong wsQSelVgh10201() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFgh802() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFgh802Aux() ;
        
        @Data(size=10, value="0")
        ILong ws104() ;
        
        @Data(size=10, value="0")
        ILong ws163() ;
        
        @Data(size=10, value="0")
        ILong ws160() ;
        
        @Data(size=10, value="0")
        ILong ws111() ;
        
        @Data(size=10, value="0")
        ILong ws117() ;
        
        @Data(size=10, value="0")
        ILong ws118() ;
        
        @Data(size=10, value="0")
        ILong ws171() ;
        
        @Data(size=10, value="0")
        ILong ws176() ;
        
        @Data(size=10, value="0")
        ILong ws501() ;
        
        @Data(size=10, value="0")
        ILong ws703() ;
        
        @Data(size=10, value="0")
        ILong ws167() ;
        
        @Data(size=10, value="0")
        ILong ws511() ;
        
        /**
         * @return instancia da classe local WsTsMovAux
         */
        @Data
        WsTsMovAux wsTsMovAux() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimento() ;
        
        @Data(size=21, value=" ")
        IString wsXRefMov() ;
        
        @Data(size=3, value="0")
        IInt wsCRSrvSibsAux() ;
        
        @Data(size=15, value="0")
        ILong wsCRefSrvEspSibs() ;
        
        
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
        IString statusFgh802() ;
        @Data
        @Condition("00")
        ICondition swFgh802Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh802Eof() ;
        
        
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
        
        
    }
    
}
