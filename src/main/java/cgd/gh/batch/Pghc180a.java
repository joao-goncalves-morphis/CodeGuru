package cgd.gh.batch;

import static java.nio.file.StandardOpenOption.* ;
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
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.im.common.constants.Bimk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghr1701 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hq.structures.link.Bhql028a ;
import cgd.hg.structures.link.Bhgl010a ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc180a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fhy003
     */
    @Handler(name="FHY003")
    @Data
    protected abstract Fhy003 ficheiroFhy003() ;
    
    /**
     * @return instancia da classe Fgh170
     */
    @Handler(name="FGH170", record="statusFgh170")
    @Data
    protected abstract Fgh170 ficheiroFgh170() ;
    
    /**
     * @return instancia da classe Fgh181
     */
    @Handler(name="FGH181", record="regFgh181400")
    @Data
    protected abstract Fgh181 ficheiroFgh181() ;
    
    
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
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
    /**
     * @return instancia da classe Bhtl250a
     */
    @Data
    protected abstract Bhtl250a bhtl250a() ;
    
    /**
     * @return instancia da classe Bhok0001
     */
    @Data
    protected abstract Bhok0001 bhok0001() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhok0003
     */
    @Data
    protected abstract Bhok0003 bhok0003() ;
    
    /**
     * @return instancia da classe Bhok0005
     */
    @Data
    protected abstract Bhok0005 bhok0005() ;
    
    /**
     * @return instancia da classe Bimk0002
     */
    @Data
    protected abstract Bimk0002 bimk0002() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * @return instancia da classe Bhtk0001
     */
    @Data
    protected abstract Bhtk0001 bhtk0001() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bghr1701
     */
    @Data
    protected abstract Bghr1701 bghr1701() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhql028a
     */
    @Data
    protected abstract Bhql028a bhql028a() ;
    
    /**
     * @return instancia da classe Bhgl010a
     */
    @Data
    protected abstract Bhgl010a bhgl010a() ;
    
    /**
     * AREA DE LIGACAO AH ROTINA MHQJ028A - OBTENCAO DADOS COE
     * AREA DE LIGACAO AH ROTINA MHGJ010A - OBTENCAO CODIGOS PAIS
     * STATUS
     * INICIO WORKING-STORAGE PGHC180A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FGH170 = "FGH170" ;
    
    protected static final String CON_FGH181 = "FGH181" ;
    
    protected static final String CON_FGH178 = "FGH178" ;
    
    protected static final String CON_FGH179 = "FGH179" ;
    
    protected static final int CON_1 = 1 ;
    
    /**
     * CONSTANTES DE C-OPE-BBN E C-EVEN-OPEL DO FGH178
     */
    protected static final String CON_HVA02 = "HVA02" ;
    
    protected static final String CON_HVA06 = "HVA06" ;
    
    protected static final String CON_HVA2 = "HVA2" ;
    
    protected static final String CON_HVA4 = "HVA4" ;
    
    /**
     * CONSTANTES DE C-OPE-BBN E C-EVEN-OPEL DO FGH179
     */
    protected static final String CON_PP661 = "PP661" ;
    
    protected static final String CON_PP663 = "PP663" ;
    
    protected static final String CON_PP665 = "PP665" ;
    
    protected static final String CON_PP667 = "PP667" ;
    
    protected static final String CON_HVB62 = "HVB62" ;
    
    protected static final String CON_HVB76 = "HVB76" ;
    
    protected static final String CON_CT68 = "CT68" ;
    
    protected static final String CON_CT69 = "CT69" ;
    
    protected static final String CON_CT70 = "CT70" ;
    
    protected static final String CON_CT71 = "CT71" ;
    
    protected static final String CON_HVB3 = "HVB3" ;
    
    /**
     * CONSTANTES DE C-OPE-BBN E C-EVEN-OPEL DO FGH179
     */
    protected static final String CON_NOME_PROGRAMA = "PGHQ180A" ;
    
    protected static final String CON_PROGRAM_DESC = "DIVISAO DO FICH DE INP NOS DIFRNTS FICH DE OUTP" ;
    
    /**
     * VARIAVEIS AUXILIARES
     */
    @Data(size=1, value=" ")
    protected IString dfheiblk ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
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
        log(TraceLevel.Debug, "*********** - INICIO - *************");
        log(TraceLevel.Debug, CON_NOME_PROGRAMA);
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (!ficheiroFgh170().getStatusOk()) {
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
        m1400ObterDatas() ;
        m1500AbreFicheiros() ;
        m1600ReadFgh170() ;
    }
    
    /**
     * 
     * 1100-INICIALIZA-VAR
     * 
     */
    protected void m1100InicializaVar() {
        log(TraceLevel.Debug, "1100-INICIALIZA-VAR");
        wsVariaveis().initialize() ;
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
     * 1400-OBTER-DATAS
     * 
     */
    protected void m1400ObterDatas() {
        log(TraceLevel.Debug, "1400-OBTER-DATAS");
        bhtl250a().commarea().initialize() ;
        bhtl250a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl250a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0250DatasDAplic() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set("MHYQ250A");
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl250a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl250a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl250a().commarea().dadosSaida().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OBTER-DATAS");
            bhtw0030().dadosEntrada().nmPrgChmd().set("MHTQ250A");
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl250a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl250a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-ABRE-FICHEIROS
     * 
     */
    protected void m1500AbreFicheiros() {
        log(TraceLevel.Debug, "1500-ABRE-FICHEIROS");
        m1510OpenFgh170() ;
        m1520OpenFgh181() ;
    }
    
    /**
     * 
     * 1510-OPEN-FGH170
     * 
     */
    protected void m1510OpenFgh170() {
        log(TraceLevel.Debug, "1510-OPEN-FGH170");
        /**
         * \* ABRE FICHEIRO DE INPUT - FGH170
         */
        ficheiroFgh170().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH170);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh170().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh170().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH170);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh170().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-OPEN-FGH170");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1520-OPEN-FGH181
     * 
     */
    protected void m1520OpenFgh181() {
        log(TraceLevel.Debug, "1520-OPEN-FGH181");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FGH181
         */
        ficheiroFgh181().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH181);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh181().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh181().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH181);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh181().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-OPEN-FGH181");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-READ-FGH170
     * 
     */
    protected void m1600ReadFgh170() {
        log(TraceLevel.Debug, "1600-READ-FGH170");
        ficheiroFgh170().read(bghr1701().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH170);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh170().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFgh170().getStatusOk()) {
            wsVariaveis().wsLidosFgh170().add(CON_1);
        } else if (!ficheiroFgh170().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH170);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh170().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1600-READ-FGH170");
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
        m2100TrataOutput() ;
        m1600ReadFgh170() ;
    }
    
    /**
     * 
     * 2100-TRATA-OUTPUT
     * 
     */
    protected void m2100TrataOutput() {
        log(TraceLevel.Debug, "2100-TRATA-OUTPUT");
        if ((bghr1701().registo().cOpeBbn().isEqual(CON_HVA02) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_HVA2)) || 
            (bghr1701().registo().cOpeBbn().isEqual(CON_HVA06) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_HVA4))) {
            bghr1701().registo().nmFicheiro().set(" ");
            bghr1701().registo().nmFicheiro().set(CON_FGH178);
            m2200WriteFgh181() ;
        }
        if ((bghr1701().registo().cOpeBbn().isEqual(CON_PP661) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_CT68)) || 
            (bghr1701().registo().cOpeBbn().isEqual(CON_PP663) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_CT69)) || 
            (bghr1701().registo().cOpeBbn().isEqual(CON_PP665) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_CT70)) || 
            (bghr1701().registo().cOpeBbn().isEqual(CON_PP667) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_CT71)) || 
            (bghr1701().registo().cOpeBbn().isEqual(CON_HVB62) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_HVB3)) || 
            (bghr1701().registo().cOpeBbn().isEqual(CON_HVB76) && 
            bghr1701().registo().cEvenOpel().isEqual(CON_HVB3))) {
            bghr1701().registo().nmFicheiro().set(" ");
            bghr1701().registo().nmFicheiro().set(CON_FGH179);
            m2200WriteFgh181() ;
        }
    }
    
    /**
     * 
     * 2200-WRITE-FGH181
     * 
     */
    protected void m2200WriteFgh181() {
        log(TraceLevel.Debug, "2200-WRITE-FGH181");
        ficheiroFgh181().write(ficheiroFgh181().regFgh181400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH181);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh181().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh181().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH181);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh181().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2200-WRITE-FGH181");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFgh181().add(CON_1);
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
        log(TraceLevel.Debug, " --3100-FECHAR-FICHEIROS");
        m3110CloseFgh170() ;
        m3120CloseFgh181() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FGH170
     * 
     */
    protected void m3110CloseFgh170() {
        log(TraceLevel.Debug, "3110-CLOSE-FGH170");
        ficheiroFgh170().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH170);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh170().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh170().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH170);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh170().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FGH170");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3120-CLOSE-FGH181
     * 
     */
    protected void m3120CloseFgh181() {
        log(TraceLevel.Debug, "3120-CLOSE-FGH181");
        ficheiroFgh181().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH181);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh181().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh181().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH181);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh181().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FGH181");
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
        log(TraceLevel.Trace, CON_NOME_PROGRAMA);
        log(TraceLevel.Trace, "**********        FIM       **********");
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
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
     * AREA DE LIGACAO AH ROTINA MHQJ028A - OBTENCAO DADOS COE
     * AREA DE LIGACAO AH ROTINA MHGJ010A - OBTENCAO CODIGOS PAIS
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
        ICondition fhy003Ok() ;
        @Data
        @Condition("10")
        ICondition fhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh170() ;
        @Data
        @Condition("00")
        ICondition swFgh170Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh170Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh181() ;
        @Data
        @Condition("00")
        ICondition swFgh181Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh181Eof() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString wsSysin() ;
        
        @Data(size=15, value="0")
        ILong wsLidosFgh170() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFgh181() ;
        
    }
    
}
