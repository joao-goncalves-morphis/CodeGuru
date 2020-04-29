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
import cgd.gh.structures.work.Bghw8800 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hy.structures.link.Bhyl500a ;
import cgd.ht.structures.link.Bhtl034a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.hg.structures.link.Bhgl003a ;
import cgd.hy.routines.Mhyq500a ;
import cgd.ht.routines.Mhtq034a ;
import cgd.ht.routines.Mhtq250a ;
import cgd.hg.routines.Mhgj003a ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq801a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk800
     */
    @Handler(name="FWK800", record="statusFwk800")
    @Data
    protected abstract Fwk800 ficheiroFwk800() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyq500a
     */
    @Data
    protected abstract Mhyq500a hrMhyq500a() ;
    
    /**
     * @return instancia da classe Mhtq034a
     */
    @Data
    protected abstract Mhtq034a hrMhtq034a() ;
    
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mhgj003a
     */
    @Data
    protected abstract Mhgj003a hrMhgj003a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw8800
     */
    @Data
    protected abstract Bghw8800 bghw8800() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
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
     * @return instancia da classe Bhyl500a
     */
    @Data
    protected abstract Bhyl500a bhyl500a() ;
    
    /**
     * @return instancia da classe Bhtl034a
     */
    @Data
    protected abstract Bhtl034a bhtl034a() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bhgl003a
     */
    @Data
    protected abstract Bhgl003a bhgl003a() ;
    
    protected static final String CON_PROGRAMA = "PGHQ801A" ;
    
    protected static final String CON_DESCRICAO = "ATUALIZAR A TGH02, COM O IND. DE INFORMACAO A S PARA APL PK" ;
    
    protected static final String CON_FWK800 = "FWK800" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    protected static final String CON_ROTINA = "RO" ;
    
    protected static final String CON_APL_PK = "PK" ;
    
    protected static final String CON_JURDEV = "JURDEV" ;
    
    protected static final String CON_JURLDN = "JURLDN" ;
    
    protected static final String CON_JUR0 = "JUR0" ;
    
    protected static final String CON_JUR1 = "JUR1" ;
    
    protected static final String CON_N = "N" ;
    
    protected static final String CON_S = "S" ;
    
    protected static final String CON_MOSELLE = "MOSELLE" ;
    
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_10000N = 10000 ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitch
     */
    @Data
    protected abstract SwSwitch swSwitch() ;
    
    /**
     * VARIAVEIS
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
    /**
     * 
     * ACESSO A ROTINA DE ACTUALIZACAO DO NUMERO
     * DE COMMITS POR PROCESSO
     * MHYQ500A
     * 
     */
    protected void bhyp0500CommitsProc() {
        hrMhyq500a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA DE RECUPERACAO PARA O BATCH
     * MHTQ034A
     * 
     */
    protected void bhtp0034AcessoRecup() {
        hrMhtq034a().run() ;
    }
    
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
     * ACESSO A ROTINA DE ACESSO AOS DADOS DA EMPRESA DO GCX
     * MHGJ003A
     * 
     */
    protected void bhgp0003RotDadosEmp() {
        hrMhgj003a().run() ;
    }
    
    /**
     * 
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        wsVariaveis().wsMsg().wsMsgP().set("0000-MAINLINE");
        log(TraceLevel.Debug, "********** INICIO **********");
        log(TraceLevel.Debug, CON_PROGRAMA, " - ", CON_DESCRICAO);
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        m1000InicioPrograma() ;
        while (!ficheiroFwk800().getStatusOk()) {
            m2000ProcPrograma() ;
        }
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        wsVariaveis().wsMsg().wsMsgP().set(" 1000-INICIO-PROGRAMA");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        m1100IniciaVars() ;
        m1200TrataEstatIni() ;
        m8000DataHoraIni() ;
        m1300DataApl() ;
        m1400OpenFicheiros() ;
        m1500ObtemNrCommits() ;
        m1600ValidaRearranque() ;
        while (wsVariaveis().wsLidosFwk800().isLessOrEqual(wsVariaveis().wsChaveRearranque().wsNumRegFwk800()) && ficheiroFwk800().getStatusOk()) {
            m1700ReadFwk800() ;
        }
    }
    
    /**
     * 
     * 1100-INICIA-VARS
     * 
     */
    protected void m1100IniciaVars() {
        wsVariaveis().wsMsg().wsMsgP().set("  1100-INICIA-VARS");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        wsVariaveis().initialize() ;
        bghw8800().movhst().initialize() ;
        bhtl034a().commarea().initialize() ;
        bhyl500a().commarea().initialize() ;
        hv00201Movhst().movhst().initialize() ;
        bhtp0011ObtemDados() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        wsVariaveis().wsMsg().wsMsgP().set("  1200-TRATA-ESTAT-INI");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-DATA-APL
     * 
     */
    protected void m1300DataApl() {
        wsVariaveis().wsMsg().wsMsgP().set("  1300-DATA-APL");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        bhtl250a().commarea().initialize() ;
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasDAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasDAplic());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl250a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl250a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
        wsVariaveis().wsMsg().wsMsgP().set("   BHTL250A-Z-PROCESSAMENTO");
        log(TraceLevel.Debug, wsVariaveis().wsMsg(), bhtl250a().commarea().dadosSaida().zProcessamento());
    }
    
    /**
     * 
     * 1400-OPEN-FICHEIROS
     * 
     */
    protected void m1400OpenFicheiros() {
        wsVariaveis().wsMsg().wsMsgP().set("  1400-OPEN-FICHEIROS");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        ficheiroFwk800().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK800);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk800().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk800().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1500-OBTEM-NR-COMMITS
     * 
     */
    protected void m1500ObtemNrCommits() {
        wsVariaveis().wsMsg().wsMsgP().set("  1500-OBTEM-NR-COMMITS");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        bhyl500a().commarea().initialize() ;
        bhyl500a().commarea().dadosInput().nmPrgBtch().set(CON_PROGRAMA);
        bhyl500a().commarea().dadosInput().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhyl500a().commarea().dadosInput().hFimExePrg().set(wsVariaveis().wsHoraIni());
        bhyp0500CommitsProc() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhyk0002().alfanumeric().rotCommitsProc());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhyl500a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhyl500a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhyl500a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhyl500a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhow0013().dadosInput().dadosRotinas().nmRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhyl500a().commarea().dadosInput());
            bhtw0030().dadosEntrada().cSqlcode().set(bhyl500a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhyl500a().commarea().dadosOutput().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhyl500a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
        if (bhyl500a().commarea().dadosOutput().qCommit().isEqual(0)) {
            bhyl500a().commarea().dadosOutput().qCommit().set(CON_10000N);
        }
        wsVariaveis().wsMsg().wsMsgP().set("   BHYL500A-Q-COMMIT");
        log(TraceLevel.Debug, wsVariaveis().wsMsg(), bhyl500a().commarea().dadosOutput().qCommit());
    }
    
    /**
     * 
     * 1600-VALIDA-REARRANQUE
     * 
     */
    protected void m1600ValidaRearranque() {
        wsVariaveis().wsMsg().wsMsgP().set("  1600-VALIDA-REARRANQUE");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().consulta().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtl034a().commarea().dadosInput().zProcessamento().set(bhtl250a().commarea().dadosSaida().zProcessamento());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotRecuperacao());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl034a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            wsVariaveis().wsChaveRearranque().set(bhtl034a().commarea().dadosInpOut().xDescChavTab());
        } else if (bhtl034a().commarea().dadosOutput().errosFuncao().isTrue()) {
            wsVariaveis().wsChaveRearranque().initialize() ;
        } else {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhow0013().dadosInput().dadosRotinas().nmRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl034a().commarea().dadosInput());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl034a().commarea().dadosOutput().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
        wsVariaveis().wsMsg().wsMsgP().set("   WS-NUM-REG-FWK800");
        log(TraceLevel.Debug, wsVariaveis().wsMsg(), wsVariaveis().wsChaveRearranque().wsNumRegFwk800());
    }
    
    /**
     * 
     * 1700-READ-FWK800
     * 
     */
    protected void m1700ReadFwk800() {
        wsVariaveis().wsMsg().wsMsgP().set("  1700-READ-FWK800");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        ficheiroFwk800().read(bghw8800().movhst()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK800);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk800().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFwk800().getStatusOk()) {
            wsVariaveis().wsLidosFwk800().add(CON_1N);
        } else if (!ficheiroFwk800().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        wsVariaveis().wsMsg().wsMsgP().set(" 2000-PROC-PROGRAMA");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        if (bghw8800().movhst().aAplOrig().isEqual(CON_APL_PK) && 
            bghw8800().movhst().iExisInfAdi().isEqual(CON_N)) {
            m2100ApuraMnem() ;
            m2200UpdateVgh00201Pk() ;
        } else if ((bghw8800().movhst().aAplOrig().isEqual(bhok0002().BHOK0002_APLIC_MANUT_CONTAS) || 
            bghw8800().movhst().aAplOrig().isEqual(bhok0002().BHOK0002_APLIC_OPERATIVA)) && 
            (bghw8800().movhst().xRefMov().get(1, 6).isEqual(CON_JURDEV) || 
            bghw8800().movhst().xRefMov().get(1, 6).isEqual(CON_JURLDN) || 
            bghw8800().movhst().xRefMov().get(1, 4).isEqual(CON_JUR0) || 
            bghw8800().movhst().xRefMov().get(1, 4).isEqual(CON_JUR1)) && 
            bghw8800().movhst().iExisInfAdi().isEqual(CON_N) && 
            !bghw8800().movhst().cUsidActzUlt().isEqual(CON_MOSELLE)) {
            m2300UpdateVgh00201Ho() ;
        }
        wsVariaveis().wsNrCommits().add(CON_1N);
        if (wsVariaveis().wsNrCommits().isEqual(bhyl500a().commarea().dadosOutput().qCommit())) {
            m2400FazCommit() ;
        }
        m1700ReadFwk800() ;
    }
    
    /**
     * 
     * 2100-APURA-MNEM
     * 
     */
    protected void m2100ApuraMnem() {
        wsVariaveis().wsMsg().wsMsgP().set("  2100-APURA-MNEM");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        wsVariaveis().wsMsg().wsMsgP().set("   BGHW8800-C-PAIS-ISOA-CONT");
        log(TraceLevel.Debug, wsVariaveis().wsMsg(), bghw8800().movhst().cPaisIsoaCont());
        wsVariaveis().wsMsg().wsMsgP().set("   BGHW8800-C-BANC-CONT");
        log(TraceLevel.Debug, wsVariaveis().wsMsg(), bghw8800().movhst().cBancCont());
        bhgl003a().commarea().initialize() ;
        bhgl003a().commarea().dadosInput().cPaisIsoAlfn().set(bghw8800().movhst().cPaisIsoaCont());
        bhgl003a().commarea().dadosInput().cBanco().set(bghw8800().movhst().cBancCont());
        bhgp0003RotDadosEmp() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhgk0002().rotDadosEmpresa());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhgl003a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhgl003a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhgl003a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhgl003a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhow0013().dadosInput().dadosRotinas().nmRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhgl003a().commarea().dadosInput());
            bhtw0030().dadosEntrada().cSqlcode().set(bhgl003a().commarea().dadosOutput().sqlca().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhgl003a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 2200-UPDATE-VGH00201-PK
     * 
     */
    protected void m2200UpdateVgh00201Pk() {
        wsVariaveis().wsMsg().wsMsgP().set("  2200-UPDATE-VGH00201-PK");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().iExisInfAdi().set(CON_S);
        wsVariaveis().wsXChavAcsInfAdi().wsCPaisIsoa().set(bghw8800().movhst().cPaisIsoaCont());
        wsVariaveis().wsXChavAcsInfAdi().wsCMnemEmp().set(bhgl003a().commarea().dadosInput().cMnemEmpGcx());
        wsVariaveis().wsXChavAcsInfAdi().wsXRef().set(bghw8800().movhst().xRefMov());
        hv00201Movhst().movhst().xChavAcsInfAdi().set(wsVariaveis().wsXChavAcsInfAdi());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq801a690(bghw8800().movhst()) ;
        swSwitch().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitch().swSqlcodeVgh00201());
        bhop0013FormataAcesso() ;
        if (!swSwitch().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xCteuChavTab().set(bghw8800().movhst());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2300-UPDATE-VGH00201-HO
     * 
     */
    protected void m2300UpdateVgh00201Ho() {
        wsVariaveis().wsMsg().wsMsgP().set("  2300-UPDATE-VGH00201-HO");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().iExisInfAdi().set(CON_S);
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq801a747(bghw8800().movhst()) ;
        swSwitch().swSqlcodeVgh00201().set(hv00201Movhst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH00201);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(swSwitch().swSqlcodeVgh00201());
        bhop0013FormataAcesso() ;
        if (!swSwitch().swVgh00201Ok().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(bhow0013().dadosInput().dadosTabela().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhow0013().dadosInput().dadosTabela().nmTabela());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().xCteuChavTab().set(bghw8800().movhst());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2400-FAZ-COMMIT
     * 
     */
    protected void m2400FazCommit() {
        wsVariaveis().wsMsg().wsMsgP().set("  2400-FAZ-COMMIT");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        bhtl034a().commarea().initialize() ;
        wsVariaveis().wsChaveRearranque().wsNumRegFwk800().add(wsVariaveis().wsNrCommits());
        wsVariaveis().wsChaveRearranque().wsChaveRearrFiller().set(" ");
        bhtl034a().commarea().dadosInput().modificacao().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtl034a().commarea().dadosInput().zProcessamento().set(bhtl250a().commarea().dadosSaida().zProcessamento());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsChaveRearranque());
        bhtp0034AcessoRecup() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotRecuperacao());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl034a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhow0013().dadosInput().dadosRotinas().nmRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl034a().commarea().dadosInput());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl034a().commarea().dadosOutput().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
        wsVariaveis().wsNrCommits().set(0);
        wsVariaveis().wsMsg().wsMsgP().set("   WS-NUM-REG-FWK800");
        log(TraceLevel.Debug, wsVariaveis().wsMsg(), wsVariaveis().wsChaveRearranque().wsNumRegFwk800());
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        wsVariaveis().wsMsg().wsMsgP().set(" 3000-FIM-PROGRAMA");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        m3100FechaFicheiros() ;
        m3200FechaRearranque() ;
        bhop0013FimEstatistica() ;
    }
    
    /**
     * 
     * 3100-FECHA-FICHEIROS
     * 
     */
    protected void m3100FechaFicheiros() {
        wsVariaveis().wsMsg().wsMsgP().set("  3100-FECHA-FICHEIROS");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        ficheiroFwk800().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK800);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk800().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk800().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmFicheiro().set(bhow0013().dadosInput().dadosFicheiro().nmFicheiro());
            bhtw0030().dadosEntrada().cFsttCobl().set(bhow0013().dadosInput().dadosFicheiro().cFsttCobl());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 3200-FECHA-REARRANQUE
     * 
     */
    protected void m3200FechaRearranque() {
        wsVariaveis().wsMsg().wsMsgP().set("  3200-FECHA-REARRANQUE");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        bhtl034a().commarea().initialize() ;
        wsVariaveis().wsChaveRearranque().wsNumRegFwk800().add(wsVariaveis().wsNrCommits());
        wsVariaveis().wsChaveRearranque().wsChaveRearrFiller().set(" ");
        bhtl034a().commarea().dadosInput().fimProcessoOk().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtl034a().commarea().dadosInput().zProcessamento().set(bhtl250a().commarea().dadosSaida().zProcessamento());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsChaveRearranque());
        bhtp0034AcessoRecup() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotRecuperacao());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl034a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsVariaveis().wsMsg());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhow0013().dadosInput().dadosRotinas().nmRotina());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhow0013().dadosInput().dadosRotinas().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl034a().commarea().dadosInput());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl034a().commarea().dadosOutput().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
        wsVariaveis().wsMsg().wsMsgP().set("   WS-NUM-REG-FWK800");
        log(TraceLevel.Debug, wsVariaveis().wsMsg(), wsVariaveis().wsChaveRearranque().wsNumRegFwk800());
    }
    
    /**
     * 
     * PARAGRAFOS PADROES
     * 8000-DATA-HORA-INI
     * 
     */
    protected void m8000DataHoraIni() {
        wsVariaveis().wsMsg().wsMsgP().set("   8000-DATA-HORA-INI");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        wsVariaveis().wsDataIni().set( getDBDate() ) ;
        wsVariaveis().wsHoraIni().set( getDBTime() ) ;
        wsVariaveis().wsTimestamp().set( getDBTimestamp() ) ;
    }
    
    /**
     * 
     * 8100-DATA-HORA-FIM
     * 
     */
    protected void m8100DataHoraFim() {
        wsVariaveis().wsMsg().wsMsgP().set("   8100-DATA-HORA-FIM");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
        wsVariaveis().wsHoraFim().set( getDBTime() ) ;
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
        wsVariaveis().wsMsg().wsMsgP().set("   9000-TRATA-ERRO-ROTINA");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
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
        wsVariaveis().wsMsg().wsMsgP().set("   9100-TRATA-ERRO-FICH");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
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
        wsVariaveis().wsMsg().wsMsgP().set("   9200-TRATA-ERRO-DB2");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
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
        wsVariaveis().wsMsg().wsMsgP().set("    9900-ABEND");
        log(TraceLevel.Debug, wsVariaveis().wsMsg());
        ficheiroFwk800().close() ;
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
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitch extends IDataStruct {
        
        @Data(size=2, value=" ")
        IString statusFwk800() ;
        @Data
        @Condition("00")
        ICondition swFwk800Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk800Eof() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh00201() ;
        @Data
        @Condition("0")
        ICondition swVgh00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh00201Notfnd() ;
        
        
        @Data(size=2, value=" ")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Eof() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsMsg
         */
        @Data
        WsMsg wsMsg() ;
        
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
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        @Data(size=7, value="0")
        IInt wsLidosFwk800() ;
        
        @Data(size=7, value="0")
        IInt wsNrCommits() ;
        
        /**
         * @return instancia da classe local WsChaveRearranque
         */
        @Data
        WsChaveRearranque wsChaveRearranque() ;
        
        /**
         * @return instancia da classe local WsXChavAcsInfAdi
         */
        @Data
        WsXChavAcsInfAdi wsXChavAcsInfAdi() ;
        
        
        public interface WsMsg extends IDataStruct {
            
            @Data(size=35, value=" ", lpadding=11, lpaddingValue="PGHQ801A - ")
            IString wsMsgP() ;
            
        }
        
        public interface WsChaveRearranque extends IDataStruct {
            
            @Data(size=15, value="0")
            ILong wsNumRegFwk800() ;
            
            @Data(size=235, value=" ")
            IString wsChaveRearrFiller() ;
            
        }
        
        public interface WsXChavAcsInfAdi extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoa() ;
            
            @Data(size=3, value=" ")
            IString wsCMnemEmp() ;
            
            @Data(size=21, value=" ")
            IString wsXRef() ;
            
        }
    }
    
}
