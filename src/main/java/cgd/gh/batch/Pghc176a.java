package cgd.gh.batch;

import static java.nio.file.StandardOpenOption.* ;
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
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.ht.structures.work.Bhtw0005 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl250a ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0003 ;
import cgd.ho.common.constants.Bhok0005 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghr1702 ;
import cgd.ht.routines.Mhtq250a ;


/**
 * 
 * WORKING STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc176a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk01303
     */
    @Handler(name="FWK013", record="statusFwk013")
    @Data
    protected abstract Fwk01303 ficheiroFwk013() ;
    
    /**
     * @return instancia da classe Fgh176
     */
    @Handler(name="FGH176", record="regFgh176400")
    @Data
    protected abstract Fgh176 ficheiroFgh176() ;
    
    
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
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhtw0005
     */
    @Data
    protected abstract Bhtw0005 bhtw0005() ;
    
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
     * @return instancia da classe Bghr1702
     */
    @Data
    protected abstract Bghr1702 bghr1702() ;
    
    /**
     * STATUS
     * INICIO WORKING-STORAGE PGHC176A
     * @return instancia da classe local SwStatus
     */
    @Data
    protected abstract SwStatus swStatus() ;
    
    protected static final String CON_FWK013 = "FWK013" ;
    
    protected static final String CON_FGH176 = "FGH176" ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHC176A" ;
    
    protected static final String CON_PROGRAM_DESC = "REFORMATADOR MOVIMENTOS INTERNOS" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    /**
     * ****              CONSTANTES NUMERICAS                    ****
     */
    protected static final int CON_N1 = 1 ;
    
    /**
     * GH1303 - INICIO
     * 05 CON-C-BANC                  PIC 9(03) VALUE 302.
     */
    protected static final String CON_C_BANC = "302" ;
    
    /**
     * GH1303 - FIM
     * GH1702 - INICIO
     */
    protected static final int CON_01 = 1 ;
    
    protected static final int CON_12 = 12 ;
    
    /**
     * GH1702 - FIM
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
        log(TraceLevel.Debug, CON_NOME_PROGRAMA, " - ", CON_PROGRAM_DESC);
        log(TraceLevel.Debug, "0000-MAINLINE");
        /**
         * GH2027-FIM
         */
        m1000InicioPrograma() ;
        m2000ProcPrograma() ;
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
        m1500TrataFicheiros() ;
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
            bhtw0030().dadosEntrada().xCteuAlig().set(wsVariaveis().wsXCteuMhtq250a());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl250a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl250a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl250a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1500-TRATA-FICHEIROS
     * 
     */
    protected void m1500TrataFicheiros() {
        log(TraceLevel.Debug, "1500-TRATA-FICHEIROS");
        m1510OpenFwk013() ;
        m1520OpenFgh176() ;
    }
    
    /**
     * 
     * 1510-OPEN-FWK013
     * 
     */
    protected void m1510OpenFwk013() {
        log(TraceLevel.Debug, "1510-OPEN-FWK013");
        /**
         * \* ABRE FICHEIRO DE INPUT - FWK013
         */
        ficheiroFwk013().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK013);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk013().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk013().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openInput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK013);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk013().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1510-OPEN-FWK013");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1520-OPEN-FGH176
     * 
     */
    protected void m1520OpenFgh176() {
        log(TraceLevel.Debug, "1520-OPEN-FGH176");
        /**
         * \* ABRE FICHEIRO DE OUTPUT - FGH176
         */
        ficheiroFgh176().open(CREATE ) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH176);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh176().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh176().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().openOutput().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH176);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh176().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1520-OPEN-FGH176");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1540-READ-FWK013
     * 
     */
    protected void m1540ReadFwk013() {
        log(TraceLevel.Debug, "1540-READ-FWK013");
        ficheiroFwk013().read(bghr1702().registo()) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK013);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk013().getStatus());
        bhop0013FormataAcesso() ;
        if (ficheiroFwk013().getStatusOk()) {
            wsVariaveis().wsLidosFwk013().add(CON_N1);
        } else if (!ficheiroFwk013().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().readSequential().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK013);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk013().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1540-READ-FWK013");
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
        m2100FormataHeader() ;
        m2300EscreveOutput() ;
        m1540ReadFwk013() ;
        while (!ficheiroFwk013().getStatusOk()) {
            m2200FormataDetalhe() ;
        }
    }
    
    /**
     * 
     * 2100-FORMATA-HEADER
     * DESC: FORMATACAO DO CABECALHO DO FICHEIRO V15
     * 
     */
    protected void m2100FormataHeader() {
        log(TraceLevel.Debug, "2100-FORMATA-HEADER");
        bghr1702().registo().componentComum().initialize() ;
        bghr1702().registo().header().cVersaoV05().setTrue() ;
        bghr1702().registo().header().cIdFichV105().setTrue() ;
        /**
         * GH1983 - FIM
         * GH1303 - INICIO
         * MOVE CON-C-BANC               TO BGHR1702-C-BANCO.
         */
        bghr1702().registo().header().cBanco().get(1, 3).set(CON_C_BANC) ;
        /**
         * MOVE SPACES                   TO BGHR1702-C-BANCO(4:1).
         */
        bghr1702().registo().header().cBanco().get(4, 2).set(" ") ;
        /**
         * GH1303 - FIM
         */
        bghr1702().registo().header().zAnoMov().set(bhtl250a().commarea().dadosSaida().zProcessamento().get(1, 4));
        bghr1702().registo().header().zMesMov().set(bhtl250a().commarea().dadosSaida().zProcessamento().get(6, 2));
        /**
         * SE ESTA A PROCESSAR EM JANEIRO SUBTRAI 1 AO ANO E O MES PASSA 12
         */
        wsVariaveis().wsZMesMov().set(bghr1702().registo().header().zMesMov());
        wsVariaveis().wsZAnoMov().set(bghr1702().registo().header().zAnoMov());
        if (wsVariaveis().wsZMesMov().isEqual(CON_01)) {
            wsVariaveis().wsZAnoMov().set(subtract(wsVariaveis().wsZAnoMov(), CON_01));
            wsVariaveis().wsZMesMov().set(CON_12);
        } else {
            wsVariaveis().wsZMesMov().set(subtract(wsVariaveis().wsZMesMov(), CON_01));
        }
        bghr1702().registo().header().zMesMov().set(wsVariaveis().wsZMesMov());
        bghr1702().registo().header().zAnoMov().set(wsVariaveis().wsZAnoMov());
    }
    
    /**
     * 
     * 2200-FORMATA-DETALHE
     * 
     */
    protected void m2200FormataDetalhe() {
        log(TraceLevel.Debug, "2200-FORMATA-DETALHE");
        m2300EscreveOutput() ;
        m1540ReadFwk013() ;
    }
    
    /**
     * 
     * 2300-ESCREVE-OUTPUT
     * 
     */
    protected void m2300EscreveOutput() {
        log(TraceLevel.Debug, "2300-ESCREVE-OUTPUT");
        ficheiroFgh176().write(ficheiroFgh176().regFgh176400) ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH176);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh176().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh176().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().write().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH176);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh176().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2320-WRITE-FICH-PRD");
            m9900Abend() ;
        } else {
            wsVariaveis().wsEscritFgh176().add(1);
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
        m3110CloseFwk013() ;
        m3120CloseFgh176() ;
    }
    
    /**
     * 
     * 3110-CLOSE-FWK013
     * 
     */
    protected void m3110CloseFwk013() {
        log(TraceLevel.Debug, "3110-CLOSE-FWK013");
        ficheiroFwk013().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK013);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk013().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFwk013().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK013);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk013().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3110-CLOSE-FWK013");
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3120-CLOSE-FGH176
     * 
     */
    protected void m3120CloseFgh176() {
        log(TraceLevel.Debug, "3120-CLOSE-FGH176");
        ficheiroFgh176().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH176);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh176().getStatus());
        bhop0013FormataAcesso() ;
        if (!ficheiroFgh176().getStatusOk()) {
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            bhtw0033().dadosFicheiros().close().setTrue() ;
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtw0033().dadosFicheiros().cTipoOpeFich());
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH176);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh176().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3120-CLOSE-FGH176");
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
        ficheiroFwk013().close() ;
        ficheiroFgh176().close() ;
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
        ICondition fhy003Ok() ;
        @Data
        @Condition("10")
        ICondition fhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk013() ;
        @Data
        @Condition("00")
        ICondition swFwk013Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk013Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh176() ;
        @Data
        @Condition("00")
        ICondition swFgh176Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh176Eof() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString wsSysin() ;
        
        @Data(size=15, value="0")
        ILong wsLidosFwk013() ;
        
        @Data(size=15, value="0")
        ILong wsEscritFgh176() ;
        
        @Data(size=2, value="0")
        IInt wsZMesMov() ;
        
        @Data(size=4, value="0")
        IInt wsZAnoMov() ;
        
        /**
         * @return instancia da classe local WsXCteuMhtq250a
         */
        @Data
        WsXCteuMhtq250a wsXCteuMhtq250a() ;
        
        
        public interface WsXCteuMhtq250a extends IDataStruct {
            
            @Data(size=8, value=" ")
            IString wsCPaisIsoMhyq250a() ;
            
            @Data(size=8, value=" ", lpadding=3, rpadding=79, lpaddingValue=" / ", rpaddingValue=" / ")
            IString wsAAplSgccMhyq250a() ;
            
        }
    }
    
}
