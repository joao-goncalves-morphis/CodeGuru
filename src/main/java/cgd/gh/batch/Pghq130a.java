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
import cgd.gh.structures.work.Bghr1301 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * CLAUSULA DE FILE DEFINITION DO FICHEIRO DE INPUT
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq130a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps13001Movdep
     */
    @Data
    protected abstract Vwsdghps13001Movdep hv13001Movdep() ;
    
    
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
     * @return instancia da classe Fgh130
     */
    @Handler(name="FGH130", record="statusFgh130")
    @Data
    protected abstract Fgh130 ficheiroFgh130() ;
    
    
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
     * @return instancia da classe Bghr1301
     */
    @Data
    protected abstract Bghr1301 bghr1301() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHQ130A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    /**
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    protected static final String CON_C_TIPO_OPE_ENTREGA = "E" ;
    
    protected static final String CON_CREDITO = "C" ;
    
    protected static final String CON_FGH130 = "FGH130" ;
    
    protected static final String CON_FHT011 = "FHT011" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ130A" ;
    
    protected static final String CON_VGH13001 = "VGH13001" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_COMMIT = 5000 ;
    
    protected static final String CON_TS_MIN = "0001-01-01-00.00.00.000000" ;
    
    protected static final String CON_PROGRAM_DESC = "ACTUALIZACAO DE TIMESTAMPS NA TGH00130" ;
    
    /**
     * VARIAVEIS AUXILIARES
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    
    
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
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Trace, "*********** - INICIO - *************");
        log(TraceLevel.Trace, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (!ficheiroFgh130().getStatusOk()) {
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
        m1400AbrirFgh130() ;
        m1500LerFgh130() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        wsVariaveis().initialize() ;
        bghr1301().registo().initialize() ;
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
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FHT011);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
        bhop0013FormataAcesso() ;
        if (!bhtw0011().areaDados().dadosInternos().fht011Ok().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1300-OBTER-DADOS-BATCH");
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FHT011);
            bhtw0030().dadosEntrada().cFsttCobl().set(bhtw0011().areaDados().dadosInternos().statusFht011());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * ABRIR-FGH130
     * 
     */
    protected void m1400AbrirFgh130() {
        log(TraceLevel.Debug, "1400-ABRIR-FGH130");
        ficheiroFgh130().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH130);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh130().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh130().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH130);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh130().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-ABRIR-FGH130");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-LER-FGH130
     * 
     */
    protected void m1500LerFgh130() {
        log(TraceLevel.Debug, "1500-LER-FGH130");
        bghr1301().registo().initialize() ;
        ficheiroFgh130().read(bghr1301().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH130);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh130().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFgh130().getStatusOk()) {
            wsVariaveis().wsChave().wsChaveZProcessamento().set(bghr1301().registo().zProcessamento());
            wsVariaveis().wsChave().wsChaveCMnemEgcOpex().set(bghr1301().registo().cMnemEgcOpex());
            wsVariaveis().wsChave().wsChaveCPaisIsoaOeOpx().set(bghr1301().registo().cPaisIsoaOeOpx());
            wsVariaveis().wsChave().wsChaveCOeEgcOpex().set(bghr1301().registo().cOeEgcOpex());
            wsVariaveis().wsChave().wsChaveCUserid().set(bghr1301().registo().cUserid());
            wsVariaveis().wsChave().wsChaveNJourBbn().set(bghr1301().registo().nJourBbn());
            wsVariaveis().wsChave().wsChaveIDbcr().set(bghr1301().registo().iDbcr());
            wsVariaveis().wsChave().wsChaveCTipoOpeCont().set(bghr1301().registo().cTipoOpeCont());
            wsVariaveis().wsChave().wsChaveTsInsercao().set(bghr1301().registo().tsInsercao());
            wsVariaveis().wsChave().wsChaveTsActzUlt().set(bghr1301().registo().tsActzUlt());
        } else if (!ficheiroFgh130().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH130);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh130().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-LER-FGH130");
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
        if (bghr1301().registo().tsInsercao().isEqual(CON_TS_MIN)) {
            m2100UpdateTgh00130() ;
        }
        m1500LerFgh130() ;
        if (wsVariaveis().wsNumRegUpdate().isGreaterOrEqual(CON_COMMIT) || 
            ficheiroFgh130().getStatusOk()) {
            m2200ExecutaCommit() ;
        }
    }
    
    /**
     * 
     * 2100-UPDATE-TGH13001
     * 
     */
    protected void m2100UpdateTgh00130() {
        log(TraceLevel.Debug, "2100-UPDATE-TGH00130");
        hv13001Movdep().movdep().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH13001_MOVDEP
         */
        hv13001Movdep().updatePghq130a425(bghr1301().registo(), CON_CREDITO, CON_TS_MIN, CON_C_TIPO_OPE_ENTREGA) ;
        swSwitches().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv13001Movdep().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swUpdate().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH13001);
        bhop0013FormataAcesso() ;
        if (swSwitches().swVgh13001Ok().isTrue()) {
            wsVariaveis().wsNumRegUpdate().add(CON_1N);
        } else if (!swSwitches().swVgh13001Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2100-UPDATE-TGH00130");
            bhtw0030().dadosEntrada().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH13001);
            bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsChave());
            bhtw0030().dadosEntrada().abendDb2().setTrue() ;
            m9900Abend() ;
        } else {
            log(TraceLevel.Error, "=== REGISTO NAO ACTUALIZADO ===");
            log(TraceLevel.Error, "SW-SQLCODE-VGH13001: ", swSwitches().swSqlcodeVgh13001());
            log(TraceLevel.Error, "WS-CHAVE-Z-PROCESSAMENTO   : ", wsVariaveis().wsChave().wsChaveZProcessamento());
            log(TraceLevel.Error, "WS-CHAVE-C-MNEM-EGC-OPEX   : ", wsVariaveis().wsChave().wsChaveCMnemEgcOpex());
            log(TraceLevel.Error, "WS-CHAVE-C-PAIS-ISOA-OE-OPX: ", wsVariaveis().wsChave().wsChaveCPaisIsoaOeOpx());
            log(TraceLevel.Error, "WS-CHAVE-C-OE-EGC-OPEX     : ", wsVariaveis().wsChave().wsChaveCOeEgcOpex());
            log(TraceLevel.Error, "WS-CHAVE-C-USERID          : ", wsVariaveis().wsChave().wsChaveCUserid());
            log(TraceLevel.Error, "WS-CHAVE-N-JOUR-BBN        : ", wsVariaveis().wsChave().wsChaveNJourBbn());
            log(TraceLevel.Error, "WS-CHAVE-I-DBCR            : ", wsVariaveis().wsChave().wsChaveIDbcr());
            log(TraceLevel.Error, "WS-CHAVE-C-TIPO-OPE-CONT   : ", wsVariaveis().wsChave().wsChaveCTipoOpeCont());
            log(TraceLevel.Error, "WS-CHAVE-TS-INSERCAO       : ", wsVariaveis().wsChave().wsChaveTsInsercao());
            log(TraceLevel.Error, "WS-CHAVE-TS-ACTZ-ULT       : ", wsVariaveis().wsChave().wsChaveTsActzUlt());
        }
    }
    
    /**
     * 
     * 2200-EXECUTA-COMMIT
     * 
     */
    protected void m2200ExecutaCommit() {
        log(TraceLevel.Debug, "2200-EXECUTA-COMMIT");
        commit() ;
        wsVariaveis().wsNumRegUpdate().set(0);
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "3000-FINAL-PROGRAMA");
        m3100FecharFicheiro() ;
        m3200EscreveEstat() ;
    }
    
    /**
     * 
     * 3100-FECHAR-FICHEIRO
     * 
     */
    protected void m3100FecharFicheiro() {
        log(TraceLevel.Debug, "3100-FECHAR-FICHEIRO");
        ficheiroFgh130().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH130);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh130().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh130().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH130);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh130().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHAR-FICHEIRO");
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
        ficheiroFgh130().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        rollback() ;
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
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh130() ;
        @Data
        @Condition("00")
        ICondition swFgh130Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh130Eof() ;
        
        
    }
    public interface SwSwitches extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh13001() ;
        @Data
        @Condition("0")
        ICondition swVgh13001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh13001Notfnd() ;
        
        
    }
    
    /**
     * 
     * VARIAVEIS AUXILIARES
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=4, value="0")
        IInt wsNumRegUpdate() ;
        
        /**
         * @return instancia da classe local WsChave
         */
        @Data
        WsChave wsChave() ;
        
        
        public interface WsChave extends IDataStruct {
            
            @Data(size=10)
            IString wsChaveZProcessamento() ;
            
            @Data(size=3)
            IString wsChaveCMnemEgcOpex() ;
            
            @Data(size=3)
            IString wsChaveCPaisIsoaOeOpx() ;
            
            @Data(size=4)
            IInt wsChaveCOeEgcOpex() ;
            
            @Data(size=8)
            IString wsChaveCUserid() ;
            
            @Data(size=9)
            ILong wsChaveNJourBbn() ;
            
            @Data(size=1)
            IString wsChaveIDbcr() ;
            
            @Data(size=1)
            IString wsChaveCTipoOpeCont() ;
            
            @Data(size=26)
            IString wsChaveTsInsercao() ;
            
            @Data(size=26)
            IString wsChaveTsActzUlt() ;
            
        }
    }
    
}
