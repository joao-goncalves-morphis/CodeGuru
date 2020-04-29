package cgd.gh.batch;

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
import cgd.gh.structures.work.Bghr1291 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.gh.structures.link.Bghl300a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.routines.Mhtq250a ;
import cgd.gh.routines.Mghj300a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * CLAUSULA DE FILE DEFINITION DO FICHEIRO DE INPUT
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq131a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fgh129
     */
    @Handler(name="FGH129", record="regFgh129451")
    @Data
    protected abstract Fgh129 ficheiroFgh129() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq250a
     */
    @Data
    protected abstract Mhtq250a hrMhtq250a() ;
    
    /**
     * @return instancia da classe Mghj300a
     */
    @Data
    protected abstract Mghj300a hrMghj300a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghr1291
     */
    @Data
    protected abstract Bghr1291 bghr1291() ;
    
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
     * @return instancia da classe Bghl300a
     */
    @Data
    protected abstract Bghl300a bghl300a() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHQ131A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FGH129 = "FGH129" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHQ131A" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_MGHJ300A = "MGHJ300A" ;
    
    protected static final String CON_PROGRAM_DESC = "BATCH DIARIO DE SINCRONISMO DO ESTADO DE ORDENS" ;
    
    /**
     * VARIAVEIS AUXILIARES
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
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
     * COPY DE ACESSO A ROTINA
     * MGHJ300A - VERIFICA ESTADO ORDENS EMITIDAS OU RECEBIDAS
     * 
     */
    protected void bghp1300VerifEstadOrd() {
        hrMghj300a().run() ;
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
        while (!ficheiroFgh129().getStatusOk()) {
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
        m1400ObtemDataApl() ;
        m1500OpenFicheiros() ;
        m1600ReadFgh129() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        wsVariaveis().initialize() ;
        bhtl250a().commarea().initialize() ;
        bghl300a().commarea().initialize() ;
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
     * 1400-OBTEM-DATA-APL
     * 
     */
    protected void m1400ObtemDataApl() {
        log(TraceLevel.Debug, "1400-OBTEM-DATA-APL");
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
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl250a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO PARAGRAFO 1400-OBTEM-DATA-APL");
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-OPEN-FICHEIROS
     * 
     */
    protected void m1500OpenFicheiros() {
        log(TraceLevel.Debug, "1500-OPEN-FICHEIROS");
        ficheiroFgh129().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH129);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh129().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh129().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH129);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh129().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-OPEN-FICHEIROS");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FGH129
     * 
     */
    protected void m1600ReadFgh129() {
        log(TraceLevel.Debug, "1600-READ-FGH129");
        ficheiroFgh129().read(bghr1291().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH129);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh129().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh129().getStatusOk() && !ficheiroFgh129().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH129);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh129().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-READ-FGH129");
            m9900Abend() ;
        } else if (ficheiroFgh129().getStatusOk()) {
            wsVariaveis().wsRead().add(1);
            bghr1291().registo().set((String)ficheiroFgh129().getRecord()) ;
            if (wsVariaveis().wsRead().isGreaterOrEqual(10000)) {
                log(TraceLevel.Error, " REGISTOS LIDOS : ", wsVariaveis().wsRead());
                wsVariaveis().wsRead().set(0);
            }
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        m2100ChamaMghj300a() ;
        m1600ReadFgh129() ;
    }
    
    /**
     * 
     * 2100-CHAMA-MGHJ300A
     * 
     */
    protected void m2100ChamaMghj300a() {
        log(TraceLevel.Debug, "2100-CHAMA-MGHJ300A");
        log(TraceLevel.Debug, " BGHR1291-C-PAIS-ISO-ALFN  :  ", bghr1291().registo().cPaisIsoAlfn());
        log(TraceLevel.Debug, " BGHR1291-C-MNEM-EMP-GCX   :  ", bghr1291().registo().cMnemEmpGcx());
        log(TraceLevel.Debug, " BGHR1291-C-REF-MSG-SWIF   :  ", bghr1291().registo().cRefMsgSwif());
        log(TraceLevel.Debug, " BGHR1291-C-TIPO-OPE-CONT  :  ", bghr1291().registo().cTipoOpeCont());
        log(TraceLevel.Debug, " BGHR1291-C-EST-MSG-SWIF    : ", bghr1291().registo().cEstMsgSwif());
        bghl300a().commarea().initialize() ;
        bghl300a().commarea().dadosEntrada().modificacao().setTrue() ;
        bghl300a().commarea().dadosEntrada().cPaisIsoAlfn().set(bghr1291().registo().cPaisIsoAlfn());
        bghl300a().commarea().dadosEntrada().cMnemEmpGcx().set(bghr1291().registo().cMnemEmpGcx());
        bghl300a().commarea().dadosEntrada().cRefMsgSwif().set(bghr1291().registo().cRefMsgSwif());
        bghl300a().commarea().dadosEntrada().cTipoOpeCont().set(bghr1291().registo().cTipoOpeCont());
        bghl300a().commarea().dadosEntrada().cEstMsgSwifI().set(bghr1291().registo().cEstMsgSwif());
        log(TraceLevel.Debug, " BGHL300A-C-PAIS-ISO-ALFN:  ", bghl300a().commarea().dadosEntrada().cPaisIsoAlfn());
        log(TraceLevel.Debug, " BGHL300A-C-MNEM-EMP-GCX :  ", bghl300a().commarea().dadosEntrada().cMnemEmpGcx());
        log(TraceLevel.Debug, " BGHL300A-C-REF-MSG-SWIF :  ", bghl300a().commarea().dadosEntrada().cRefMsgSwif());
        log(TraceLevel.Debug, " BGHL300A-C-TIPO-OPE-CONT:  ", bghl300a().commarea().dadosEntrada().cTipoOpeCont());
        log(TraceLevel.Debug, " BGHL300A-C-EST-MSG-SWIF-I: ", bghl300a().commarea().dadosEntrada().cEstMsgSwifI());
        bghp1300VerifEstadOrd() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(CON_MGHJ300A);
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bghl300a().commarea().erros().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bghl300a().commarea().erros().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bghl300a().commarea().erros().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bghl300a().commarea().erros().semErros().isTrue()) {
            bhtw0030().dadosEntrada().abend().setTrue() ;
            bhtw0030().dadosEntrada().cSqlcode().set(bghl300a().commarea().erros().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bghl300a().commarea().erros().nmTabela());
            bhtw0030().dadosEntrada().nmPrgChmd().set(CON_MGHJ300A);
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bghl300a().commarea().erros().msgErrob());
            m9900Abend() ;
        }
    }
    
    /**
     * 
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
        log(TraceLevel.Debug, "3100-FECHAR-FICHEIROS");
        ficheiroFgh129().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH129);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh129().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh129().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH129);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh129().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHAR-FICHEIROS");
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
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        ficheiroFgh129().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_NOME_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
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
        IString statusFgh129() ;
        @Data
        @Condition("00")
        ICondition swFgh129Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh129Eof() ;
        
        
    }
    
    /**
     * 
     * VARIAVEIS AUXILIARES
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=5)
        IInt wsRead() ;
        
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
    
}
