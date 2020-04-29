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
import cgd.gh.structures.work.Bghw0150 ;
import cgd.ht.structures.link.Bhtl034a ;
import cgd.hy.structures.link.Bhyl500a ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ht.routines.Mhtq200a ;
import cgd.ht.routines.Mhtq034a ;
import cgd.hy.routines.Mhyq500a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FWK001
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq930a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps01001Contiphst
     */
    @Data
    protected abstract Vwsdghps01001Contiphst hv01001Contiphst() ;
    
    
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
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq200a
     */
    @Data
    protected abstract Mhtq200a hrMhtq200a() ;
    
    /**
     * @return instancia da classe Mhtq034a
     */
    @Data
    protected abstract Mhtq034a hrMhtq034a() ;
    
    /**
     * @return instancia da classe Mhyq500a
     */
    @Data
    protected abstract Mhyq500a hrMhyq500a() ;
    
    
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
     * @return instancia da classe Bhtl034a
     */
    @Data
    protected abstract Bhtl034a bhtl034a() ;
    
    /**
     * @return instancia da classe Bhyl500a
     */
    @Data
    protected abstract Bhyl500a bhyl500a() ;
    
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
    
    protected static final String CON_PROGRAMA = "PGHQ930A" ;
    
    protected static final String CON_MHTQ034A = "MHTQ034A" ;
    
    protected static final String CON_MHTQ500A = "MHTQ500A" ;
    
    protected static final String CON_DESCRICAO = "REGULARIZACAO DA TGH00010  " ;
    
    protected static final String CON_FWK001 = "FWK001" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final int CON_3 = 3 ;
    
    protected static final int CON_8 = 8 ;
    
    protected static final int CON_1 = 1 ;
    
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
     * ACESSO A ROTINA DE RECUPERACAO PARA O BATCH
     * MHTQ034A
     * 
     */
    protected void bhtp0034AcessoRecup() {
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACTUALIZACAO DO NUMERO
     * DE COMMITS POR PROCESSO
     * MHYQ500A
     * 
     */
    protected void bhyp0500CommitsProc() {
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
        while (fgh010().getStatusOk()) {
            m2000Processa() ;
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
        m1010CommitsPorProc() ;
        m1020AnalisaRearranque() ;
        while (wsVariaveis().wsNumRegFwk001().isLessOrEqual(wsVariaveis().wsRearranque().wsNumRegRearran001()) && !fgh010().getStatusOk()) {
            m1500ReadFwk001() ;
        }
    }
    
    /**
     * 
     * 1010-COMMITS-POR-PROC
     * 
     */
    protected void m1010CommitsPorProc() {
        log(TraceLevel.Debug, "1010-COMMITS-POR-PROC");
        bhyl500a().commarea().dadosInput().nmPrgBtch().set(CON_PROGRAMA);
        bhyl500a().commarea().dadosInput().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhyl500a().commarea().dadosInput().hFimExePrg().set(wsVariaveis().wsHoraIni());
        bhyp0500CommitsProc() ;
        if (!bhyl500a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0033().dadosRotina().nmRtnaAces().set(CON_MHTQ500A);
            wsVariaveis().wsNmTabela().set(bhyl500a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhyl500a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhyl500a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhyl500a().commarea().dadosInput());
            m9000TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 1020-ANALISA-REARRANQUE
     * 
     */
    protected void m1020AnalisaRearranque() {
        log(TraceLevel.Debug, "1020-ANALISA-REARRANQUE");
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().consulta().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtl034a().commarea().dadosInput().zProcessamento().set(wsVariaveis().wsDataIni());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        log(TraceLevel.Trace, "BHTL034A-C-TIPO-ERRO-BBN : ", bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        if (bhtl034a().commarea().dadosOutput().errosFuncao().isTrue()) {
            log(TraceLevel.Error, "ERROS-FUNCAO");
            wsVariaveis().wsRearranque().initialize() ;
        } else if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            log(TraceLevel.Error, "SEM-ERROS");
            wsVariaveis().wsRearranque().set(bhtl034a().commarea().dadosInpOut().xDescChavTab());
        } else {
            log(TraceLevel.Error, "ERROS");
            bhtw0033().dadosRotina().nmRtnaAces().set(CON_MHTQ034A);
            wsVariaveis().wsNmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhtl034a().commarea().dadosInput());
            m9000TrataErroRotina() ;
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
            wsVariaveis().wsNumRegFwk001().add(1);
        } else if (fgh010().getStatusOk()) {
            log(TraceLevel.Error, "FIM--->FWK001:", fgh010().getStatus());
        } else {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-READ-FWK001");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK001);
            bhtw0030().dadosEntrada().cFsttCobl().set(fgh010().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSA
     * 
     */
    protected void m2000Processa() {
        log(TraceLevel.Debug, "2000-PROCESSA");
        m2100ObtemMovimento() ;
        /**
         * VALIDA DATAS
         */
        if (!wsVariaveis().wsTsData().isEqual(fgh010().rgh01001().fgh010ZaInicio()) && 
            swSwitch().swVgh00201Ok().isTrue()) {
            m2200ActualizaTgh0010() ;
        }
        if (wsVariaveis().wsNumRegFwk001().isGreaterOrEqual(CON_1) && 
            swSwitch().swVgh00201Ok().isTrue()) {
            m2300ExecutaCommit() ;
        }
        m1500ReadFwk001() ;
    }
    
    /**
     * 
     * 2100-OBTEM-MOVIMENTO
     * 
     */
    protected void m2100ObtemMovimento() {
        log(TraceLevel.Debug, "2100-OBTEM-MOVIMENTO");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(fgh010().rgh01001().fgh010CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(fgh010().rgh01001().fgh010CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fgh010().rgh01001().fgh010COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(fgh010().rgh01001().fgh010NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(fgh010().rgh01001().fgh010VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(fgh010().rgh01001().fgh010CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(fgh010().rgh01001().fgh010CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(fgh010().rgh01001().fgh010NsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghq930a569() ;
        swSwitch().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swSelect().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("VGH00201");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv00201Movhst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitch().swVgh00201Ok().isTrue() && !swSwitch().swVgh00201Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2100-OBTEM-MOVIMENTO");
            bhtw0030().dadosEntrada().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set("VGH00201");
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv00201Movhst().movhst());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else if (swSwitch().swVgh00201Notfnd().isTrue()) {
            log(TraceLevel.Error, "***************************************");
            log(TraceLevel.Error, "         NOT FOUND TGH00002_MOVHST");
            log(TraceLevel.Error, "***************************************");
            log(TraceLevel.Error, "   BGHF0010 : ");
            log(TraceLevel.Error, "   FGH010-C-PAIS-ISOA-CONT : ", fgh010().rgh01001().fgh010CPaisIsoaCont());
            log(TraceLevel.Error, "   FGH010-C-BANC-CONT      : ", fgh010().rgh01001().fgh010CBancCont());
            log(TraceLevel.Error, "   FGH010-C-OE-EGC-CONT    : ", fgh010().rgh01001().fgh010COeEgcCont());
            log(TraceLevel.Error, "   FGH010-NS-RDCL-CONT     : ", fgh010().rgh01001().fgh010NsRdclCont());
            log(TraceLevel.Error, "   FGH010-V-CHKD-CONT      : ", fgh010().rgh01001().fgh010VChkdCont());
            log(TraceLevel.Error, "   FGH010-C-TIPO-CONT      : ", fgh010().rgh01001().fgh010CTipoCont());
            log(TraceLevel.Error, "   FGH010-C-MOED-ISO-SCTA  : ", fgh010().rgh01001().fgh010CMoedIsoScta());
            log(TraceLevel.Error, "   FGH010-NS-DEPOSITO      : ", fgh010().rgh01001().fgh010NsDeposito());
            log(TraceLevel.Error, "   FGH010-NM-RECURSO       : ", fgh010().rgh01001().fgh010NmRecurso());
            log(TraceLevel.Error, "   FGH010-C-TIPO-INF-HIST  : ", fgh010().rgh01001().fgh010CTipoInfHist());
            log(TraceLevel.Error, "   FGH010-ZA-INICIO        : ", fgh010().rgh01001().fgh010ZaInicio());
            log(TraceLevel.Error, "   FGH010-ZA-FIM           : ", fgh010().rgh01001().fgh010ZaFim());
            log(TraceLevel.Error, "   FGH010-TS-ACTZ-ULT      : ", fgh010().rgh01001().fgh010TsActzUlt());
            log(TraceLevel.Error, "   FGH010-C-USID-ACTZ-ULT  : ", fgh010().rgh01001().fgh010CUsidActzUlt());
        } else {
            log(TraceLevel.Debug, "NS-RDCL-CONT: ", hv00201Movhst().movhst().nsRdclCont());
            log(TraceLevel.Debug, "TS-MOVIMENTO: ", hv00201Movhst().movhst().tsMovimento());
            wsVariaveis().wsTsData().set(hv00201Movhst().movhst().tsMovimento().get(1, 4));
        }
    }
    
    /**
     * 
     * 2200-ACTUALIZA-TGH0010
     * 
     */
    protected void m2200ActualizaTgh0010() {
        log(TraceLevel.Debug, "2200-ACTUALIZA-TGH0010");
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(fgh010().rgh01001().fgh010CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(fgh010().rgh01001().fgh010CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(fgh010().rgh01001().fgh010COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(fgh010().rgh01001().fgh010NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(fgh010().rgh01001().fgh010VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(fgh010().rgh01001().fgh010CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(fgh010().rgh01001().fgh010CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(fgh010().rgh01001().fgh010NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set(fgh010().rgh01001().fgh010NmRecurso());
        /**
         * VGH00201-TS-MOVIMENTO(1:4) => VGH01001-ZA-INICIO
         */
        hv01001Contiphst().contiphst().zaInicio().set(wsVariaveis().wsTsData());
        hv01001Contiphst().contiphst().cUsidActzUlt().set(CON_PROGRAMA);
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().updatePghq930a678() ;
        swSwitch().swSqlcodeVgh01001().set(hv01001Contiphst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set("TGH00010");
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitch().swVgh01001Ok().isTrue()) {
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2300-EXECUTA-COMMIT
     * 
     */
    protected void m2300ExecutaCommit() {
        log(TraceLevel.Debug, "2300-EXECUTA-COMMIT");
        bhtl034a().commarea().initialize() ;
        wsVariaveis().wsRearranque().wsNumRegRearran001().add(wsVariaveis().wsNumRegFwk001());
        bhtl034a().commarea().dadosInput().modificacao().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtl034a().commarea().dadosInput().zProcessamento().set(wsVariaveis().wsDataIni());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsRearranque());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            wsVariaveis().wsNumRegFwk001().set(0);
        } else {
            bhtw0033().dadosRotina().nmRtnaAces().set(CON_MHTQ034A);
            wsVariaveis().wsNmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhtl034a().commarea().dadosInput());
            m9000TrataErroRotina() ;
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
        m3300FechaRecuperacao() ;
        commit() ;
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
    }
    
    /**
     * 
     * 3300-FECHA-RECUPERACAO
     * 
     */
    protected void m3300FechaRecuperacao() {
        log(TraceLevel.Debug, "3300-FECHA-RECUPERACAO");
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().fimProcessoOk().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtl034a().commarea().dadosInput().zProcessamento().set(wsVariaveis().wsDataIni());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsRearranque());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        if (!bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0033().dadosRotina().nmRtnaAces().set(CON_MHTQ034A);
            wsVariaveis().wsNmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhtl034a().commarea().dadosInput());
            m9000TrataErroRotina() ;
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
     * 9200-TRATA-ERRO-DB2
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
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
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
        fgh010().close() ;
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
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh01001() ;
        @Data
        @Condition("0")
        ICondition swVgh01001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh01001Notfnd() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=8, value=" ")
        IString wsNmTabela() ;
        
        @Data(size=3, signed=true, value="0")
        IInt wsCSqlcode() ;
        
        @Data(size=100, value=" ")
        IString wsDadosEntrada() ;
        
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=10, value=" ")
        IString wsZProcessamento() ;
        
        @Data(size=8, value=" ")
        IString wsNmRecurso() ;
        
        @Data(size=10, value="0")
        ILong wsNumRegFwk001() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsTsData() ;
        
        /**
         * @return instancia da classe local WsConta
         */
        @Data
        WsConta wsConta() ;
        
        /**
         * @return instancia da classe local WsRearranque
         */
        @Data
        WsRearranque wsRearranque() ;
        
        /**
         * @return instancia da classe local WsFwk001Chave
         */
        @Data
        WsFwk001Chave wsFwk001Chave() ;
        
        
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
        
        public interface WsRearranque extends IDataStruct {
            
            @Data(size=15, value="0", rpadding=235)
            ILong wsNumRegRearran001() ;
            
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
    }
    
}
