package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static java.nio.file.StandardOpenOption.* ;
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
import cgd.gh.structures.work.Bghw0150 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ht.routines.Mhtq200a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FWK001
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FWK002
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FWK003
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq931a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
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
     * @return instancia da classe Fwk00102
     */
    @Handler(name="FWK001", record="rgh01001")
    @Data
    protected abstract Fwk00102 fgh010() ;
    
    /**
     * @return instancia da classe Fwk00201
     */
    @Handler(name="FWK002", record="rgh10201")
    @Data
    protected abstract Fwk00201 fgh102() ;
    
    /**
     * @return instancia da classe Fwk00301
     */
    @Handler(name="FWK003", record="regFwk003")
    @Data
    protected abstract Fwk00301 fwk003() ;
    
    
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
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bghw0150
     */
    @Data
    protected abstract Bghw0150 bghw0150() ;
    
    /**
     * @return instancia da classe Bhtl200a
     */
    @Data
    protected abstract Bhtl200a bhtl200a() ;
    
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
    
    protected static final String CON_PROGRAMA = "PGHQ931A" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_GHSA9999 = "GHSA9999" ;
    
    protected static final String CON_DESCRICAO = "ESCREVE FICH REG A ELIMINAR/INSERIR NA TGH00010  " ;
    
    protected static final String CON_FWK001 = "FWK001" ;
    
    protected static final String CON_FWK002 = "FWK002" ;
    
    protected static final String CON_FWK003 = "FWK003" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final int CON_3 = 3 ;
    
    protected static final int CON_8 = 8 ;
    
    protected static final int CON_1990 = 1990 ;
    
    protected static final String CON_I = "I" ;
    
    protected static final String CON_E = "E" ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitch
     */
    @Data
    protected abstract SwSwitch swSwitch() ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
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
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "********** INICIO **********");
        log(TraceLevel.Debug, CON_PROGRAMA, " - ", CON_DESCRICAO);
        m1000InicioPrograma() ;
        while (fgh102().getStatusOk() || fgh010().getStatusOk()) {
            m2000MatchRecurso() ;
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
        m1100IniciaVars() ;
        m1200TrataEstatIni() ;
        m1300ObtemData() ;
        m8000DataHoraIni() ;
        m1400OpenFicheiros() ;
        wsVariaveis().wsFgh102ContaAnt().set(wsVariaveis().wsFgh102Chave().wsFgh102Conta());
        m1600ReadFgh102() ;
        m1700DeterminaRecurso() ;
        while (!wsVariaveis().wsFwk001Chave().wsFwk001NmRecurso().isEqual(wsVariaveis().wsNmRecurso()) && fgh010().getStatusOk()) {
            m1500ReadFwk001() ;
        }
    }
    
    /**
     * 
     * 1100-INICIA-VARS
     * 
     */
    protected void m1100IniciaVars() {
        log(TraceLevel.Debug, "1100-INICIA-VARS");
        wsVariaveis().initialize() ;
        bhtl200a().commarea().initialize() ;
        bhtp0011ObtemDados() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        log(TraceLevel.Debug, "1200-TRATA-ESTAT-INI");
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-OBTEM-DATA
     * 
     */
    protected void m1300ObtemData() {
        log(TraceLevel.Debug, "1300-OBTEM-DATA");
        bhtl200a().commarea().initialize() ;
        bhtl200a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl200a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0010CaplicDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl200a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl200a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (bhtl200a().commarea().dadosSaida().semErros().isTrue()) {
            wsVariaveis().wsZProcessamento().set(bhtl200a().commarea().dadosSaida().zProcessamento());
        } else {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl200a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl200a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl200a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl200a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 1400-OPEN-FICHEIROS
     * 
     */
    protected void m1400OpenFicheiros() {
        log(TraceLevel.Debug, "1400-OPEN-FICHEIROS");
        fgh010().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fgh010().getStatus());
        bhop0013FormataAcesso() ;
        if (!fgh010().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(fgh010().getStatus());
            m9100TrataErroFich() ;
        }
        fgh102().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK002);
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fgh102().getStatus());
        bhop0013FormataAcesso() ;
        if (!fgh102().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK002);
            bhtw0030().dadosEntrada().cFsttCobl().set(fgh102().getStatus());
            m9100TrataErroFich() ;
        }
        fwk003().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (!fwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(fwk003().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1500-READ-FWK001
     * 
     */
    protected void m1500ReadFwk001() {
        log(TraceLevel.Debug, "1500-READ-FWK001");
        fgh010().rgh01001().initialize() ;
        fgh010().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fgh010().getStatus());
        bhop0013FormataAcesso() ;
        if (fgh010().getStatusOk()) {
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CPaisIsoaCont().set(fgh010().rgh01001().fgh010CPaisIsoaCont());
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CBancCont().set(fgh010().rgh01001().fgh010CBancCont());
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001COeEgcCont().set(fgh010().rgh01001().fgh010COeEgcCont());
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001NsRdclCont().set(fgh010().rgh01001().fgh010NsRdclCont());
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001VChkdCont().set(fgh010().rgh01001().fgh010VChkdCont());
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CTipoCont().set(fgh010().rgh01001().fgh010CTipoCont());
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CMoedIsoScta().set(fgh010().rgh01001().fgh010CMoedIsoScta());
            wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001NsDeposito().set(fgh010().rgh01001().fgh010NsDeposito());
            wsVariaveis().wsFwk001Chave().wsFwk001ZaInicio().set(fgh010().rgh01001().fgh010ZaInicio());
            wsVariaveis().wsFwk001Chave().wsFwk001ZaFim().set(fgh010().rgh01001().fgh010ZaFim());
            wsVariaveis().wsFwk001Chave().wsFwk001NmRecurso().set(fgh010().rgh01001().fgh010NmRecurso());
            log(TraceLevel.Debug, "C-PAIS-ISOA-CONT:", fgh010().rgh01001().fgh010CPaisIsoaCont());
            log(TraceLevel.Debug, "C-BANC-CONT     :", fgh010().rgh01001().fgh010CBancCont());
            log(TraceLevel.Debug, "C-OE-EGC-CONT   :", fgh010().rgh01001().fgh010COeEgcCont());
            log(TraceLevel.Debug, "NS-RDCL-CONT    :", fgh010().rgh01001().fgh010NsRdclCont());
            log(TraceLevel.Debug, "V-CHKD-CONT     :", fgh010().rgh01001().fgh010VChkdCont());
            log(TraceLevel.Debug, "C-TIPO-CONT     :", fgh010().rgh01001().fgh010CTipoCont());
            log(TraceLevel.Debug, "C-MOED-ISO-SCTA :", fgh010().rgh01001().fgh010CMoedIsoScta());
            log(TraceLevel.Debug, "NS-DEPOSITO     :", fgh010().rgh01001().fgh010NsDeposito());
            log(TraceLevel.Debug, "ZA-INICIO       :", fgh010().rgh01001().fgh010ZaInicio());
            log(TraceLevel.Debug, "ZA-FIM          :", fgh010().rgh01001().fgh010ZaFim());
            log(TraceLevel.Debug, "NM-RECURSO      :", fgh010().rgh01001().fgh010NmRecurso());
        } else {
            log(TraceLevel.Error, "FIM--->FWK001:", fgh010().getStatus());
            if (fgh010().getStatusOk()) {
                wsVariaveis().wsFwk001Chave().wsFwk001Conta().set(String.valueOf(HIGH_VALUES));
                wsVariaveis().wsFwk001Chave().wsFwk001ZaInicio().set(0);
                wsVariaveis().wsFwk001Chave().wsFwk001NmRecurso().set(" ");
            } else {
                bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-READ-FWK001");
                bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
                bhtw0030().dadosEntrada().cFsttCobl().set(fgh010().getStatus());
                m9100TrataErroFich() ;
            }
        }
    }
    
    /**
     * 
     * 1600-READ-FGH102
     * 
     */
    protected void m1600ReadFgh102() {
        log(TraceLevel.Debug, "1600-READ-FGH102");
        fgh102().rgh10201().initialize() ;
        wsVariaveis().wsFgh102ContaAnt().set(wsVariaveis().wsFgh102Chave().wsFgh102Conta());
        wsVariaveis().wsAnoMovimentoAnt().set(wsVariaveis().wsAnoMovimento());
        fgh102().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK002);
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fgh102().getStatus());
        bhop0013FormataAcesso() ;
        if (fgh102().getStatusOk()) {
            wsVariaveis().wsAnoMovimento().set(fgh102().rgh10201().fgh102TsMovimento().get(1, 4));
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102CPaisIsoaCont().set(fgh102().rgh10201().fgh102CPaisIsoaCont());
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102CBancCont().set(fgh102().rgh10201().fgh102CBancCont());
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102COeEgcCont().set(fgh102().rgh10201().fgh102COeEgcCont());
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102NsRdclCont().set(fgh102().rgh10201().fgh102NsRdclCont());
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102VChkdCont().set(fgh102().rgh10201().fgh102VChkdCont());
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102CTipoCont().set(fgh102().rgh10201().fgh102CTipoCont());
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102CMoedIsoScta().set(fgh102().rgh10201().fgh102CMoedIsoScta());
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().wsFgh102NsDeposito().set(fgh102().rgh10201().fgh102NsDeposito());
            wsVariaveis().wsFgh102Chave().wsFgh102ZaInicio().set(wsVariaveis().wsAnoMovimento());
            wsVariaveis().wsFgh102Chave().wsFgh102NmRecurso().set(wsVariaveis().wsNmRecurso());
            log(TraceLevel.Debug, "C-PAIS-ISOA-CONT:", fgh102().rgh10201().fgh102CPaisIsoaCont());
            log(TraceLevel.Debug, "C-BANC-CONT     :", fgh102().rgh10201().fgh102CBancCont());
            log(TraceLevel.Debug, "C-OE-EGC-CONT   :", fgh102().rgh10201().fgh102COeEgcCont());
            log(TraceLevel.Debug, "NS-RDCL-CONT    :", fgh102().rgh10201().fgh102NsRdclCont());
            log(TraceLevel.Debug, "V-CHKD-CONT     :", fgh102().rgh10201().fgh102VChkdCont());
            log(TraceLevel.Debug, "C-TIPO-CONT     :", fgh102().rgh10201().fgh102CTipoCont());
            log(TraceLevel.Debug, "C-MOED-ISO-SCTA :", fgh102().rgh10201().fgh102CMoedIsoScta());
            log(TraceLevel.Debug, "NS-DEPOSITO     :", fgh102().rgh10201().fgh102NsDeposito());
            log(TraceLevel.Debug, "WS-ANO-MOVIMENTO:", wsVariaveis().wsAnoMovimento());
            log(TraceLevel.Debug, "WS-NM-RECURSO   :", wsVariaveis().wsNmRecurso());
        } else if (fgh102().getStatusOk()) {
            wsVariaveis().wsFgh102Chave().wsFgh102Conta().set(String.valueOf(HIGH_VALUES));
            wsVariaveis().wsFgh102Chave().wsFgh102ZaInicio().set(0);
            wsVariaveis().wsFgh102Chave().wsFgh102NmRecurso().set(" ");
        } else {
            /**
             * MOVE WS-FGH102-CONTA-ANT  TO WS-FGH102-CONTA
             */
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-READ-FGH102");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK002);
            bhtw0030().dadosEntrada().cFsttCobl().set(fgh102().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1700-DETERMINA-RECURSO
     * 
     */
    protected void m1700DeterminaRecurso() {
        log(TraceLevel.Debug, "1700-DETERMINA-RECURSO");
        wsVariaveis().wsAnoCorrente().set(wsVariaveis().wsZProcessamento().get(1, 4));
        wsVariaveis().wsAnoFwk002().set(fgh102().rgh10201().fgh102TsMovimento().get(1, 4));
        if (wsVariaveis().wsNAnos().isLess(CON_3)) {
            wsVariaveis().wsNmRecurso().set(CON_VGH00201);
        } else if (wsVariaveis().wsNAnos().isGreaterOrEqual(CON_3) && 
            wsVariaveis().wsNAnos().isLessOrEqual(CON_8)) {
            m1750BaldHistAct() ;
        } else if (wsVariaveis().wsAnoFwk002().isLess(CON_1990)) {
            wsVariaveis().wsNmRecurso().set(CON_GHSA9999);
        } else if (wsVariaveis().wsNAnos().isGreater(CON_8)) {
            m1760BaldHistNorm() ;
        }
        log(TraceLevel.Trace, "WS-NM-RECURSO: ", wsVariaveis().wsNmRecurso());
    }
    
    /**
     * 
     * 1750-BALD-HIST-ACT
     * 
     */
    protected void m1750BaldHistAct() {
        log(TraceLevel.Debug, "1750-BALD-HIST-ACT");
        bghw0150().tbBaldHstAct().itemHstA().resetIndex() ;
        while (bghw0150().tbBaldHstAct().itemHstA().index().isLessOrEqual(30)) {
            if (wsVariaveis().wsAnoMovimento().isEqual(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabZaAnoAct())) {
                wsVariaveis().wsNmRecurso().set(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabNmRecursoAct());
                break;
            }
            bghw0150().tbBaldHstAct().itemHstA().incIndex() ;
        }
        if (bghw0150().tbBaldHstAct().itemHstA().atEnd()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("]]] RECURSO BALDEAMENTO INEXISTENTE ]]]");
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1760-BALD-HIST-NORM
     * 
     */
    protected void m1760BaldHistNorm() {
        log(TraceLevel.Debug, "1750-BALD-HIST-NORM");
        bghw0150().tbBaldHstNorm().itemHstB().resetIndex() ;
        while (bghw0150().tbBaldHstNorm().itemHstB().index().isLessOrEqual(42)) {
            if (wsVariaveis().wsAnoMovimento().isEqual(bghw0150().tbBaldHstNorm().itemHstB().getCurrent().tabZaAnoNorm())) {
                wsVariaveis().wsNmRecurso().set(bghw0150().tbBaldHstNorm().itemHstB().getCurrent().tabNmRecursoNorm());
                break;
            }
            bghw0150().tbBaldHstNorm().itemHstB().incIndex() ;
        }
        if (bghw0150().tbBaldHstNorm().itemHstB().atEnd()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("]]] RECURSO BALDEAMENTO INEXISTENTE ]]]");
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-MATCH-RECURSO
     * 
     */
    protected void m2000MatchRecurso() {
        log(TraceLevel.Debug, "2000-MATCH-RECURSO");
        wsVariaveis().wsAnoMovimentoIni().set(wsVariaveis().wsFgh102Chave().wsFgh102ZaInicio());
        wsVariaveis().wsAnoMovimentoFim().set(wsVariaveis().wsFgh102Chave().wsFgh102ZaInicio());
        if (wsVariaveis().wsFgh102Chave().wsFgh102Conta().isEqual(wsVariaveis().wsFwk001Chave().wsFwk001Conta())) {
            log(TraceLevel.Debug, "CONTAS =, ANO/RECURSO = ");
            wsVariaveis().wsFgh102ContaAnt().set(wsVariaveis().wsFgh102Chave().wsFgh102Conta());
            wsVariaveis().wsFwk001Chave().wsFwk001NmRecurso().set(" ");
            while (!wsVariaveis().wsFwk001Chave().wsFwk001NmRecurso().isEqual(wsVariaveis().wsNmRecurso()) && fgh010().getStatusOk()) {
                m1500ReadFwk001() ;
            }
            while (wsVariaveis().wsFgh102Chave().wsFgh102Conta().isEqual(wsVariaveis().wsFgh102ContaAnt()) && fgh102().getStatusOk()) {
                m1600ReadFgh102() ;
            }
        } else if (wsVariaveis().wsFgh102Chave().wsFgh102Conta().isLess(wsVariaveis().wsFwk001Chave().wsFwk001Conta())) {
            log(TraceLevel.Debug, "CONTA FGH102<FWK001");
            wsVariaveis().wsAnoMovimentoIni().set(wsVariaveis().wsAnoMovimento());
            wsVariaveis().wsFgh102ContaAnt().set(wsVariaveis().wsFgh102Chave().wsFgh102Conta());
            while (wsVariaveis().wsFgh102Chave().wsFgh102Conta().isEqual(wsVariaveis().wsFgh102ContaAnt()) && fgh102().getStatusOk()) {
                m1600ReadFgh102() ;
            }
            wsVariaveis().wsAnoMovimentoFim().set(wsVariaveis().wsAnoMovimentoAnt());
            m2200FormataRegistoI() ;
            /**
             * *GH1528--> INICIO
             */
            m2310ObtemMovimento() ;
            /**
             * *GH1528--> FIM
             */
            m2300EscreveFwk003() ;
        } else {
            log(TraceLevel.Debug, "FGH102-CONTA>FWK001-CONTA");
            m2100FormataRegistoE() ;
            m2300EscreveFwk003() ;
            wsVariaveis().wsFwk001Chave().wsFwk001NmRecurso().set(" ");
            while (!wsVariaveis().wsFwk001Chave().wsFwk001NmRecurso().isEqual(wsVariaveis().wsNmRecurso()) && fgh010().getStatusOk()) {
                m1500ReadFwk001() ;
            }
        }
    }
    
    /**
     * 
     * 2100-FORMATA-REGISTO-E
     * 
     */
    protected void m2100FormataRegistoE() {
        log(TraceLevel.Debug, "2100-FORMATA-REGISTO-E");
        log(TraceLevel.Debug, "WS-ANO-MOVIMENTO-INI :", wsVariaveis().wsAnoMovimentoIni());
        log(TraceLevel.Debug, "WS-ANO-MOVIMENTO-FIM :", wsVariaveis().wsAnoMovimentoFim());
        fwk003().regFwk003().initialize() ;
        fwk003().regFwk003().fwk003CPaisIsoaCont().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CPaisIsoaCont());
        fwk003().regFwk003().fwk003CBancCont().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CBancCont());
        fwk003().regFwk003().fwk003COeEgcCont().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001COeEgcCont());
        fwk003().regFwk003().fwk003NsRdclCont().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001NsRdclCont());
        fwk003().regFwk003().fwk003VChkdCont().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001VChkdCont());
        fwk003().regFwk003().fwk003CTipoCont().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CTipoCont());
        fwk003().regFwk003().fwk003CMoedIsoScta().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001CMoedIsoScta());
        fwk003().regFwk003().fwk003NsDeposito().set(wsVariaveis().wsFwk001Chave().wsFwk001Conta().wsFwk001NsDeposito());
        fwk003().regFwk003().fwk003NmRecurso().set(wsVariaveis().wsNmRecurso());
        fwk003().regFwk003().fwk003ZaInicio().set(wsVariaveis().wsAnoMovimentoIni());
        fwk003().regFwk003().fwk003ZaFim().set(wsVariaveis().wsAnoMovimentoFim());
        fwk003().regFwk003().fwk003IAcao().set(CON_E);
        log(TraceLevel.Debug, "FWK003-ZA-INICIO: ", fwk003().regFwk003().fwk003ZaInicio());
        log(TraceLevel.Debug, "FWK003-ZA-FIM : ", fwk003().regFwk003().fwk003ZaFim());
    }
    
    /**
     * 
     * 2200-FORMATA-REGISTO-I
     * 
     */
    protected void m2200FormataRegistoI() {
        log(TraceLevel.Debug, "2200-FORMATA-REGISTO-I");
        log(TraceLevel.Debug, "WS-ANO-MOVIMENTO-INI :", wsVariaveis().wsAnoMovimentoIni());
        log(TraceLevel.Debug, "WS-ANO-MOVIMENTO-FIM :", wsVariaveis().wsAnoMovimentoFim());
        fwk003().regFwk003().initialize() ;
        fwk003().regFwk003().fwk003CPaisIsoaCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CPaisIsoaContAnt());
        wsVariaveis().wsConta().wsCPaisIsoaCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CPaisIsoaContAnt());
        fwk003().regFwk003().fwk003CBancCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CBancContAnt());
        wsVariaveis().wsConta().wsCBancCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CBancContAnt());
        fwk003().regFwk003().fwk003COeEgcCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102COeEgcContAnt());
        wsVariaveis().wsConta().wsCOeEgcCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102COeEgcContAnt());
        fwk003().regFwk003().fwk003NsRdclCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102NsRdclContAnt());
        wsVariaveis().wsConta().wsNsRdclCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102NsRdclContAnt());
        fwk003().regFwk003().fwk003VChkdCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102VChkdContAnt());
        wsVariaveis().wsConta().wsVChkdCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102VChkdContAnt());
        fwk003().regFwk003().fwk003CTipoCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CTipoContAnt());
        wsVariaveis().wsConta().wsCTipoCont().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CTipoContAnt());
        fwk003().regFwk003().fwk003CMoedIsoScta().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CMoedIsoSctaAnt());
        wsVariaveis().wsConta().wsCMoedIsoScta().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102CMoedIsoSctaAnt());
        fwk003().regFwk003().fwk003NsDeposito().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102NsDepositoAnt());
        wsVariaveis().wsConta().wsNsDeposito().set(wsVariaveis().wsFgh102ContaAnt().wsFgh102NsDepositoAnt());
        fwk003().regFwk003().fwk003NmRecurso().set(wsVariaveis().wsNmRecurso());
        fwk003().regFwk003().fwk003ZaInicio().set(wsVariaveis().wsAnoMovimentoIni());
        fwk003().regFwk003().fwk003ZaFim().set(wsVariaveis().wsAnoMovimentoFim());
        fwk003().regFwk003().fwk003IAcao().set(CON_I);
        log(TraceLevel.Debug, "FWK003-ZA-INICIO: ", fwk003().regFwk003().fwk003ZaInicio());
        log(TraceLevel.Debug, "FWK003-ZA-FIM : ", fwk003().regFwk003().fwk003ZaFim());
    }
    
    /**
     * 
     * 2300-ESCREVE-FWK003
     * 
     */
    protected void m2300EscreveFwk003() {
        log(TraceLevel.Debug, "2300-ESCREVE-FWK003");
        fwk003().write(fwk003().regFwk003()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (!fwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2300-ESCREVE-FWK003");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(fwk003().getStatus());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * *GH1528--> INICIO
     * 2310-OBTEM-MOVIMENTO
     * 
     */
    protected void m2310ObtemMovimento() {
        log(TraceLevel.Debug, "2310-OBTEM-MOVIMENTO");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(wsVariaveis().wsConta().wsCPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(wsVariaveis().wsConta().wsCBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(wsVariaveis().wsConta().wsCOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(wsVariaveis().wsConta().wsNsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(wsVariaveis().wsConta().wsVChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(wsVariaveis().wsConta().wsCTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(wsVariaveis().wsConta().wsCMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(wsVariaveis().wsConta().wsNsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghq931a940() ;
        swSwitch().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        log(TraceLevel.Debug, "SQLCODE: ", bhow0013().dadosInput().dadosTabela().cSqlcode());
        bhop0013FormataAcesso() ;
        if (!swSwitch().swVgh00201Ok().isTrue() && !swSwitch().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2310-OBTEM-MOVIMENTO");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (!swSwitch().swVgh00201Notfnd().isTrue()) {
            log(TraceLevel.Debug, "NS-RDCL-CONT: ", hv00201Movhst().movhst().nsRdclCont());
            log(TraceLevel.Debug, "TS-MOVIMENTO: ", hv00201Movhst().movhst().tsMovimento());
            wsVariaveis().wsTsData().set(hv00201Movhst().movhst().tsMovimento().get(1, 4));
            /**
             * VALIDA DATAS
             */
            if (!wsVariaveis().wsTsData().isEqual(fgh010().rgh01001().fgh010ZaInicio())) {
                fwk003().regFwk003().fwk003ZaInicio().set(wsVariaveis().wsTsData());
            }
        }
    }
    
    /**
     * 
     * *GH1528--> FIM
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
        fgh010().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK001);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fgh010().getStatus());
        bhop0013FormataAcesso() ;
        if (!fgh010().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(fgh010().getStatus());
            m9100TrataErroFich() ;
        }
        fgh102().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK002);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fgh102().getStatus());
        bhop0013FormataAcesso() ;
        if (!fgh102().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK002);
            bhtw0030().dadosEntrada().cFsttCobl().set(fgh102().getStatus());
            m9100TrataErroFich() ;
        }
        fwk003().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (!fwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(fwk003().getStatus());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
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
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADAS AS SE-
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
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosRotinas().iOperacao());
        bhop0013FimEstatistica() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9100-TRATA-ERRO-FICH
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADAS AS SE-
     * GUINTES VARIAVEIS:
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
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
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
        log(TraceLevel.Trace, "***************************************");
        log(TraceLevel.Trace, "             9900-ABEND");
        log(TraceLevel.Trace, "***************************************");
        log(TraceLevel.Trace, "   BGHF0010 : ");
        log(TraceLevel.Trace, "   FGH010-C-PAIS-ISOA-CONT : ", fgh010().rgh01001().fgh010CPaisIsoaCont());
        log(TraceLevel.Trace, "   FGH010-C-BANC-CONT      : ", fgh010().rgh01001().fgh010CBancCont());
        log(TraceLevel.Trace, "   FGH010-C-OE-EGC-CONT    : ", fgh010().rgh01001().fgh010COeEgcCont());
        log(TraceLevel.Trace, "   FGH010-NS-RDCL-CONT     : ", fgh010().rgh01001().fgh010NsRdclCont());
        log(TraceLevel.Trace, "   FGH010-V-CHKD-CONT      : ", fgh010().rgh01001().fgh010VChkdCont());
        log(TraceLevel.Trace, "   FGH010-C-TIPO-CONT      : ", fgh010().rgh01001().fgh010CTipoCont());
        log(TraceLevel.Trace, "   FGH010-C-MOED-ISO-SCTA  : ", fgh010().rgh01001().fgh010CMoedIsoScta());
        log(TraceLevel.Trace, "   FGH010-NS-DEPOSITO      : ", fgh010().rgh01001().fgh010NsDeposito());
        log(TraceLevel.Trace, "   FGH010-NM-RECURSO       : ", fgh010().rgh01001().fgh010NmRecurso());
        log(TraceLevel.Trace, "   FGH010-C-TIPO-INF-HIST  : ", fgh010().rgh01001().fgh010CTipoInfHist());
        log(TraceLevel.Trace, "   FGH010-ZA-INICIO        : ", fgh010().rgh01001().fgh010ZaInicio());
        log(TraceLevel.Trace, "   FGH010-ZA-FIM           : ", fgh010().rgh01001().fgh010ZaFim());
        log(TraceLevel.Trace, "   FGH010-TS-ACTZ-ULT      : ", fgh010().rgh01001().fgh010TsActzUlt());
        log(TraceLevel.Trace, "   FGH010-C-USID-ACTZ-ULT  : ", fgh010().rgh01001().fgh010CUsidActzUlt());
        log(TraceLevel.Trace, "   STATUS-FWK001           :  ", fgh010().getStatus());
        log(TraceLevel.Trace, "  ");
        log(TraceLevel.Trace, "   BGHF0102   ");
        log(TraceLevel.Trace, "   FGH102-C-PAIS-ISOA-CONT : ", fgh102().rgh10201().fgh102CPaisIsoaCont());
        log(TraceLevel.Trace, "   FGH102-C-BANC-CONT      : ", fgh102().rgh10201().fgh102CBancCont());
        log(TraceLevel.Trace, "   FGH102-C-OE-EGC-CONT    : ", fgh102().rgh10201().fgh102COeEgcCont());
        log(TraceLevel.Trace, "   FGH102-NS-RDCL-CONT     : ", fgh102().rgh10201().fgh102NsRdclCont());
        log(TraceLevel.Trace, "   FGH102-V-CHKD-CONT      : ", fgh102().rgh10201().fgh102VChkdCont());
        log(TraceLevel.Trace, "   FGH102-C-TIPO-CONT      : ", fgh102().rgh10201().fgh102CTipoCont());
        log(TraceLevel.Trace, "   FGH102-C-MOED-ISO-SCTA  : ", fgh102().rgh10201().fgh102CMoedIsoScta());
        log(TraceLevel.Trace, "   FGH102-NS-DEPOSITO      : ", fgh102().rgh10201().fgh102NsDeposito());
        log(TraceLevel.Trace, "   FGH102-TS-MOVIMENTO     : ", fgh102().rgh10201().fgh102TsMovimento());
        log(TraceLevel.Trace, "   FGH102-NS-MOVIMENTO     : ", fgh102().rgh10201().fgh102NsMovimento());
        log(TraceLevel.Trace, "   FGH102-C-TRANSACCAO     : ", fgh102().rgh10201().fgh102CTransaccao());
        log(TraceLevel.Trace, "   FGH102-A-APLICACAO      : ", fgh102().rgh10201().fgh102AAplicacao());
        log(TraceLevel.Trace, "   FGH102-C-OPCZ-MENU      : ", fgh102().rgh10201().fgh102COpczMenu());
        log(TraceLevel.Trace, "   FGH102-C-OPE-BBN        : ", fgh102().rgh10201().fgh102COpeBbn());
        log(TraceLevel.Trace, "   FGH102-C-EVEN-OPEL      : ", fgh102().rgh10201().fgh102CEvenOpel());
        log(TraceLevel.Trace, "   FGH102-C-TERMINAL       : ", fgh102().rgh10201().fgh102CTerminal());
        log(TraceLevel.Trace, "   FGH102-C-OPERADOR       : ", fgh102().rgh10201().fgh102COperador());
        log(TraceLevel.Trace, "   FGH102-C-OPEX-ATRX      : ", fgh102().rgh10201().fgh102COpexAtrx());
        log(TraceLevel.Trace, "   FGH102-C-USERID         : ", fgh102().rgh10201().fgh102CUserid());
        log(TraceLevel.Trace, "   FGH102-C-TIPO-CANL-ACES : ", fgh102().rgh10201().fgh102CTipoCanlAces());
        log(TraceLevel.Trace, "   FGH102-C-PAIS-ISOA-OE-OPX ", fgh102().rgh10201().fgh102CPaisIsoaOeOpx());
        log(TraceLevel.Trace, "   FGH102-C-MNEM-EGC-OPEX  : ", fgh102().rgh10201().fgh102CMnemEgcOpex());
        log(TraceLevel.Trace, "   FGH102-C-OE-EGC-OPEX    : ", fgh102().rgh10201().fgh102COeEgcOpex());
        log(TraceLevel.Trace, "   FGH102-C-PROD-SGOP      : ", fgh102().rgh10201().fgh102CProdSgop());
        log(TraceLevel.Trace, "   FGH102-C-FAMI-PROD      : ", fgh102().rgh10201().fgh102CFamiProd());
        log(TraceLevel.Trace, "   FGH102-C-PRODUTO        : ", fgh102().rgh10201().fgh102CProduto());
        log(TraceLevel.Trace, "   FGH102-C-CNDZ-MOVZ-CONT : ", fgh102().rgh10201().fgh102CCndzMovzCont());
        log(TraceLevel.Trace, "   FGH102-C-GRUP-CONT      : ", fgh102().rgh10201().fgh102CGrupCont());
        log(TraceLevel.Trace, "   FGH102-C-TIPO-ITTZ      : ", fgh102().rgh10201().fgh102CTipoIttz());
        log(TraceLevel.Trace, "   FGH102-T-CAMBIO         : ", fgh102().rgh10201().fgh102TCambio());
        log(TraceLevel.Trace, "   FGH102-M-SLDO-RETD      : ", fgh102().rgh10201().fgh102MSldoRetd());
        log(TraceLevel.Trace, "   FGH102-M-SLDO-VCOB      : ", fgh102().rgh10201().fgh102MSldoVcob());
        log(TraceLevel.Trace, "   FGH102-M-CMRG-LIM       : ", fgh102().rgh10201().fgh102MCmrgLim());
        log(TraceLevel.Trace, "   FGH102-M-CMRG-UTID      : ", fgh102().rgh10201().fgh102MCmrgUtid());
        log(TraceLevel.Trace, "   FGH102-M-DCBO-NGCD-ATRD : ", fgh102().rgh10201().fgh102MDcboNgcdAtrd());
        log(TraceLevel.Trace, "   FGH102-M-DCBO-NGCD-UTID : ", fgh102().rgh10201().fgh102MDcboNgcdUtid());
        log(TraceLevel.Trace, "   FGH102-N-JOUR-BBN       : ", fgh102().rgh10201().fgh102NJourBbn());
        log(TraceLevel.Trace, "   FGH102-NS-JOUR-BBN      : ", fgh102().rgh10201().fgh102NsJourBbn());
        log(TraceLevel.Trace, "   FGH102-NS-JOUR-BBN-DTLH : ", fgh102().rgh10201().fgh102NsJourBbnDtlh());
        log(TraceLevel.Trace, "   FGH102-NM-ARQV-ORIG     : ", fgh102().rgh10201().fgh102NmArqvOrig());
        log(TraceLevel.Trace, "   FGH102-TS-ACTZ-ULT      : ", fgh102().rgh10201().fgh102TsActzUlt());
        log(TraceLevel.Trace, "   FGH102-C-USID-ACTZ-ULT  : ", fgh102().rgh10201().fgh102CUsidActzUlt());
        log(TraceLevel.Trace, "   STATUS-FGH102           :  ", fgh102().getStatus());
        log(TraceLevel.Trace, "  ");
        log(TraceLevel.Trace, "   BGHW8111   ");
        log(TraceLevel.Trace, "   FWK003-C-PAIS-ISOA-CONT : ", fwk003().regFwk003().fwk003CPaisIsoaCont());
        log(TraceLevel.Trace, "   FWK003-C-BANC-CONT      : ", fwk003().regFwk003().fwk003CBancCont());
        log(TraceLevel.Trace, "   FWK003-C-OE-EGC-CONT    : ", fwk003().regFwk003().fwk003COeEgcCont());
        log(TraceLevel.Trace, "   FWK003-NS-RDCL-CONT     : ", fwk003().regFwk003().fwk003NsRdclCont());
        log(TraceLevel.Trace, "   FWK003-V-CHKD-CONT      : ", fwk003().regFwk003().fwk003VChkdCont());
        log(TraceLevel.Trace, "   FWK003-C-TIPO-CONT      : ", fwk003().regFwk003().fwk003CTipoCont());
        log(TraceLevel.Trace, "   FWK003-C-MOED-ISO-SCTA  : ", fwk003().regFwk003().fwk003CMoedIsoScta());
        log(TraceLevel.Trace, "   FWK003-NS-DEPOSITO      : ", fwk003().regFwk003().fwk003NsDeposito());
        log(TraceLevel.Trace, "   FWK003-NM-RECURSO       : ", fwk003().regFwk003().fwk003ZaInicio());
        log(TraceLevel.Trace, "   FWK003-ZA-INICIO        : ", fwk003().regFwk003().fwk003ZaFim());
        log(TraceLevel.Trace, "   FWK003-ZA-FIM           : ", fwk003().regFwk003().fwk003IAcao());
        log(TraceLevel.Trace, "   FWK003-I-ACAO           : ");
        fgh010().close() ;
        fgh102().close() ;
        fwk003().close() ;
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
         * FORMATACAO DE RETURN-CODE
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
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitch extends IDataStruct {
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk001() ;
        @Data
        @Condition("00")
        ICondition swFwk001Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk001Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh102() ;
        @Data
        @Condition("00")
        ICondition swFgh102Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh102Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk003() ;
        @Data
        @Condition("00")
        ICondition swFwk003Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk003Eof() ;
        
        
        /**
         * *GH1528--> INICIO
         */
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        /**
         * *GH1528--> FIM
         */
        @Data(size=1, value=" ")
        IString swRecAnual() ;
        @Data
        @Condition("S")
        ICondition swRecAnualS() ;
        @Data
        @Condition("N")
        ICondition swRecAnualN() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=8, value=" ")
        IString wsNmRecurso() ;
        
        @Data(size=10, value=" ")
        IString wsZProcessamento() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        @Data(size=4, value="0")
        IInt wsAnoCorrente() ;
        
        @Data(size=4, value="0")
        IInt wsNAnos() ;
        
        @Data(size=4, value="0")
        IInt wsAnoFwk002() ;
        
        @Data(size=4, value="0")
        IInt wsAnoMovimento() ;
        
        @Data(size=4, value="0")
        IInt wsAnoMovimentoAnt() ;
        
        @Data(size=4, value="0")
        IInt wsAnoMovimentoIni() ;
        
        @Data(size=4, value="0")
        IInt wsAnoMovimentoFim() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsTsData() ;
        
        /**
         * @return instancia da classe local WsConta
         */
        @Data
        WsConta wsConta() ;
        
        /**
         * @return instancia da classe local WsFwk001Chave
         */
        @Data
        WsFwk001Chave wsFwk001Chave() ;
        
        /**
         * @return instancia da classe local WsFgh102Chave
         */
        @Data
        WsFgh102Chave wsFgh102Chave() ;
        
        /**
         * @return instancia da classe local WsFgh102ContaAnt
         */
        @Data
        WsFgh102ContaAnt wsFgh102ContaAnt() ;
        
        
        public interface WsConta extends IDataStruct {
            
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
            
            @Data(size=1)
            IString wsIAcao() ;
            
        }
        
        public interface WsFwk001Chave extends IDataStruct {
            
            /**
             * @return instancia da classe local WsFwk001Conta
             */
            @Data
            WsFwk001Conta wsFwk001Conta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsFwk001ZaInicio() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsFwk001ZaFim() ;
            
            @Data(size=8)
            IString wsFwk001NmRecurso() ;
            
            
            public interface WsFwk001Conta extends IDataStruct {
                
                @Data(size=3)
                IString wsFwk001CPaisIsoaCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt wsFwk001CBancCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt wsFwk001COeEgcCont() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt wsFwk001NsRdclCont() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt wsFwk001VChkdCont() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt wsFwk001CTipoCont() ;
                
                @Data(size=3)
                IString wsFwk001CMoedIsoScta() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt wsFwk001NsDeposito() ;
                
            }
        }
        
        public interface WsFgh102Chave extends IDataStruct {
            
            /**
             * @return instancia da classe local WsFgh102Conta
             */
            @Data
            WsFgh102Conta wsFgh102Conta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsFgh102ZaInicio() ;
            
            @Data(size=8)
            IString wsFgh102NmRecurso() ;
            
            
            public interface WsFgh102Conta extends IDataStruct {
                
                @Data(size=3)
                IString wsFgh102CPaisIsoaCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt wsFgh102CBancCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt wsFgh102COeEgcCont() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt wsFgh102NsRdclCont() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt wsFgh102VChkdCont() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt wsFgh102CTipoCont() ;
                
                @Data(size=3)
                IString wsFgh102CMoedIsoScta() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt wsFgh102NsDeposito() ;
                
            }
        }
        
        public interface WsFgh102ContaAnt extends IDataStruct {
            
            @Data(size=3)
            IString wsFgh102CPaisIsoaContAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsFgh102CBancContAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsFgh102COeEgcContAnt() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt wsFgh102NsRdclContAnt() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt wsFgh102VChkdContAnt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt wsFgh102CTipoContAnt() ;
            
            @Data(size=3)
            IString wsFgh102CMoedIsoSctaAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsFgh102NsDepositoAnt() ;
            
        }
    }
    
}
