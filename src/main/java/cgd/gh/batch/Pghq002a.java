package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import static java.nio.file.StandardOpenOption.* ;
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
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.structures.work.Bghwz001 ;
import cgd.gh.structures.work.Bghw0004 ;
import cgd.ho.structures.link.Bhol826a ;
import cgd.ho.routines.Mhoj826a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CARREGAMENTO DAS TABELAS DE HISTORICOS COM OS
 * OS MOVIMENTOS RECEBIDOS DIARIAMENTOS DOS HO'S
 * 1 CARREGAMENTO DOS REGISTOS NAS TABELAS:
 * - TGH00002_MOVHST
 * - TGH00102_MOVHSTCPL
 * 2 ELIMINACAO DOS MESMOS REGISTOS NA TABELA
 * - TGH00022_MOVDIAANT
 * FICHEIROS     : FWK001 A FWK014 CRIADOS NO PGHC001A
 * TODOS ESTES FICHEIROS SAO IDENTIFICADOS NO
 * PROGRAMA COMO INPUT1
 * FWK600 SORT DO FHO04C (UNLOAD DA THO0022)
 * 26/12/2013    : ALTERACAO DO MATCHING DE FICHEIROS GH1307
 * GH1352 - 20114-04-17 - FORMATACAO DOS CAMPOS I-EXIS-INF-ADI
 * E X-CHAV-ACS-INF-ADI DA TGH002
 * PASSIVAS 2540 - 2018-03-12 - PREENCHER O NOVO CAMPO DA
 * TABELA TGH00102
 * GH2181 - 2019-01-02- ALTERAR ACESSO MHOJ826A
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq002a extends CgdGhBaseBatch {
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
     * @return instancia da classe Vwsdghps02201Movdiaant
     */
    @Data
    protected abstract Vwsdghps02201Movdiaant hv02201Movdiaant() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    /**
     * @return instancia da classe Fwk00101
     */
    @Handler(name="INPUT1", record="input1Reg")
    @Data
    protected abstract Fwk00101 input1() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghq002a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    /**
     * @return instancia da classe Fwk600
     */
    @Handler(name="FWK600", record="registo")
    @Data
    protected abstract Fwk600 fwk600() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhoj826a
     */
    @Data
    protected abstract Mhoj826a hrMhoj826a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghwz001
     */
    @Data
    protected abstract Bghwz001 bghwz001() ;
    
    /**
     * @return instancia da classe Bghw0004
     */
    @Data
    protected abstract Bghw0004 bghw0004() ;
    
    /**
     * @return instancia da classe Bhol826a
     */
    @Data
    protected abstract Bhol826a bhol826a() ;
    
    /**
     * 88 SW-DEBUG-ON                        VALUE 'O'.
     * 88 SW-DEBUG-OFF                       VALUE 'F'.
     */
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("8")
    protected ICondition progJaExiste ;
    
    
    @Data(size=1)
    protected IString swCrtlConta ;
    @Data
    @Condition("3")
    protected ICondition swContaIgual ;
    @Data
    @Condition("4")
    protected ICondition swContaDiferente ;
    
    
    @Data(size=1)
    protected IString swCrtlExiste ;
    @Data
    @Condition("6")
    protected ICondition swContaExiste ;
    @Data
    @Condition("4")
    protected ICondition swContaNaoExiste ;
    
    
    @Data(size=1)
    protected IString swCrtlVerContaHst ;
    @Data
    @Condition("5")
    protected ICondition verContaHst ;
    @Data
    @Condition("4")
    protected ICondition naoVerContaHst ;
    
    
    @Data(size=1, value=" ")
    protected IString swChave ;
    @Data
    @Condition(" ")
    protected ICondition swChaveVazia ;
    @Data
    @Condition("=")
    protected ICondition swChaveIgual ;
    @Data
    @Condition(">")
    protected ICondition swChaveMaior ;
    @Data
    @Condition("<")
    protected ICondition swChaveMenor ;
    
    
    /**
     * PASSIVAS 2540 - 2018-03-12 - INI
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * PASSIVAS 2540 - 2018-03-12 - FIM
     */
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=8, value="0")
    protected ILong dataCorrente ;
    
    /**
     * @return instancia da classe local DataCorrenteMask
     */
    @Data
    @Mask
    protected abstract DataCorrenteMask dataCorrenteMask() ;
    
    @Data(size=8, value="0")
    protected ILong dataNum ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * @return instancia da classe local Variaveis
     */
    @Data
    protected abstract Variaveis variaveis() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosInput1 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk600 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh00201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh10201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegDelVgh02201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong auxContRegLidos ;
    
    /**
     * TABELA DE IMPRESSAO DE FGH300
     * @return instancia da classe local TabelaImpressao
     */
    @Data
    protected abstract TabelaImpressao tabelaImpressao() ;
    
    /**
     * @return instancia da classe local TabelaImpressaoMask
     */
    @Data
    @Mask
    protected abstract TabelaImpressaoMask tabelaImpressaoMask() ;
    
    
    
    /**
     * 
     * COPY PROCEDURE ROTINA DE CLASSIFICACAO MOVIMENTOS EM CONTA DO
     * POR CATEGORIA
     * 
     */
    protected void bhop0826ClassMov() {
        hrMhoj826a().run() ;
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ002A");
        progOk.setTrue() ;
        bghw0300().wsVariaveisHora().horaInicio().set(getTime()) ;
        dataCorrente.set(getTime("yyyyMMdd"));
        dataNum.set(dataCorrente);
        wTimestamp().wDataTimestamp().wAnoAa().set(dataCorrenteMask().anoCorrente());
        wTimestamp().wDataTimestamp().wMesMm().set(dataCorrenteMask().mesCorrente());
        wTimestamp().wDataTimestamp().wDiaDd().set(dataCorrenteMask().diaCorrente());
        tabelaImpressao().linha02().impData().set(wTimestamp().wDataTimestamp());
        tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
        wTimestamp().wTimerTimestamp().wHh().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().hhInicio());
        wTimestamp().wTimerTimestamp().wMm().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().mmInicio());
        wTimestamp().wTimerTimestamp().wSs().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().ssInicio());
        wTimestamp().wTimerTimestamp().wDd().set(0);
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk900() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk900() ;
        }
        if (progOk.isTrue()) {
            a16000AbrirInput1() ;
        }
        if (progOk.isTrue()) {
            while (contRegLidosInput1.isLessOrEqual(auxContRegLidos) && !input1().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17000LerInput1() ;
            }
        }
        /**
         * *...........
         */
        if (progOk.isTrue()) {
            a18000AbrirFwk600() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A12000-ABRIR-FGH300");
        fgh300().open(WRITE) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - OPEN - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000EscreverFgh300() {
        log(TraceLevel.Debug, "A12000-ESCREVER-FGH300");
        fgh300().write(fgh300().rgh03001121) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - WRITE - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk900() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK900");
        fwk900().open(WRITE) ;
        if (!fwk900().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - FWK900 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk900() {
        log(TraceLevel.Debug, "A15000-LER-FWK900");
        fwk900().read() ;
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq002a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - FWK900 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq002a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - FWK900 - READ - ");
            tabelaImpressao().linha10().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15100TratarOutputFwk900() {
        log(TraceLevel.Debug, "A15100-TRATAR-OUTPUT-FWK900");
        fwk900().open(CREATE ) ;
        if (fwk900().getStatusOk()) {
            fwk900().fwk900RegPghq002a().initialize() ;
            fwk900().fwk900RegPghq002a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghq002a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHQ002A - FWK900 - WRITE- ");
                tabelaImpressao().linha10().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - FWK900 - OPEN- ");
            tabelaImpressao().linha10().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirInput1() {
        log(TraceLevel.Debug, "A16000-ABRIR-INPUT1");
        input1().open() ;
        if (!input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - INPUT1 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(input1().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerInput1() {
        log(TraceLevel.Debug, "A17000-LER-INPUT1");
        input1().read() ;
        if (input1().getStatusOk()) {
            contRegLidosInput1.add(1);
            /**
             * ..CHAVE DO INPUT1
             */
            variaveis().wsK8267().wsK8267CPaisIsoaCont().set(input1().input1Reg().subconta().cPaisIsoaCont());
            variaveis().wsK8267().wsK8267CBancCont().set(input1().input1Reg().subconta().cBancCont());
            variaveis().wsK8267().wsK8267COeEgcCont().set(input1().input1Reg().subconta().cOeEgcCont());
            variaveis().wsK8267().wsK8267NsRdclCont().set(input1().input1Reg().subconta().nsRdclCont());
            variaveis().wsK8267().wsK8267VChkdCont().set(input1().input1Reg().subconta().vChkdCont());
            variaveis().wsK8267().wsK8267CTipoCont().set(input1().input1Reg().subconta().cTipoCont());
            variaveis().wsK8267().wsK8267CMoedIsoScta().set(input1().input1Reg().subconta().cMoedIsoScta());
            variaveis().wsK8267().wsK8267NsDeposito().set(input1().input1Reg().subconta().nsDeposito());
            variaveis().wsK8267().wsK8267NsMovimento().set(input1().input1Reg().nsMovimento());
            if (input1().input1Reg().aAplicacao().isEqual("PP")) {
                log(TraceLevel.Debug, "WS-K8267: PP-", variaveis().wsK8267());
            }
            swChaveVazia.setTrue() ;
        }
        if (!input1().getStatusOk() && !input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - INPUT1 - READ - ");
            tabelaImpressao().linha10().impStatus().set(input1().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a18000AbrirFwk600() {
        log(TraceLevel.Debug, "A18000-ABRIR-FWK600");
        fwk600().open() ;
        if (!fwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - FWK600 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk600().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a19000LerFwk600() {
        log(TraceLevel.Debug, "A19000-LER-FWK600");
        fwk600().read() ;
        if (fwk600().getStatusOk()) {
            contRegLidosFwk600.add(1);
            /**
             * ..CHAVE DO FWK600
             */
            variaveis().wsK04c().wsK04cCPaisIsoaCont().set(fwk600().registo().conta().cPaisIsoaCont());
            variaveis().wsK04c().wsK04cCBancCont().set(fwk600().registo().conta().cBancCont());
            variaveis().wsK04c().wsK04cCOeEgcCont().set(fwk600().registo().conta().cOeEgcCont());
            variaveis().wsK04c().wsK04cNsRdclCont().set(fwk600().registo().conta().nsRdclCont());
            variaveis().wsK04c().wsK04cVChkdCont().set(fwk600().registo().conta().vChkdCont());
            variaveis().wsK04c().wsK04cCTipoCont().set(fwk600().registo().conta().cTipoCont());
            variaveis().wsK04c().wsK04cCMoedIsoScta().set(fwk600().registo().conta().cMoedIsoScta());
            variaveis().wsK04c().wsK04cNsDeposito().set(fwk600().registo().conta().nsDeposito());
            variaveis().wsK04c().wsK04cNsMovimento().set(fwk600().registo().nsMovimento());
            log(TraceLevel.Debug, "WS-K04C:TMN: ", variaveis().wsK04c());
        }
        if (!fwk600().getStatusOk() && !fwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - FWK600 - READ - ");
            tabelaImpressao().linha10().impStatus().set(fwk600().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (fwk600().getStatusOk() && progOk.isTrue() && 
            variaveis().wsK04c().isLess(variaveis().wsK8267())) {
            while (variaveis().wsK04c().isLessOrEqual(variaveis().wsK8267()) && !variaveis().wsK04c().isEqual(variaveis().wsK8267()) && !fwk600().getStatusOk()) {
                a29000MatchingFwk600() ;
            }
        }
        /**
         * *........
         * PASSIVAS 2540 - 2018-03-12 - INI
         */
        if (progOk.isTrue()) {
            a20000ObtemDescMovimento() ;
        }
        /**
         * PASSIVAS 2540 - 2018-03-12 - FIM
         * *........
         */
        if (progOk.isTrue()) {
            a30000EscreverHistorico() ;
        }
        if (progOk.isTrue()) {
            a31000DelDiaAnterior() ;
        }
        /**
         * *........
         */
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        /**
         * *........
         */
        if (progOk.isTrue()) {
            a17000LerInput1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a29000MatchingFwk600() {
        log(TraceLevel.Debug, "A29000-MATCHING-FWK600");
        /**
         * IF WS-K04C NOT = WS-K8267
         */
        if (variaveis().wsK04c().isLess(variaveis().wsK8267())) {
            a19000LerFwk600() ;
        }
        if (fwk600().getStatusOk()) {
            if (variaveis().wsK04c().isEqual(variaveis().wsK8267())) {
                swChaveIgual.setTrue() ;
            } else if (variaveis().wsK04c().isLess(variaveis().wsK8267())) {
                swChaveMenor.setTrue() ;
            } else if (variaveis().wsK04c().isGreater(variaveis().wsK8267())) {
                swChaveMaior.setTrue() ;
            }
            if (input1().input1Reg().aAplicacao().isEqual("PP")) {
                log(TraceLevel.Debug, "APLICACAO PP");
                log(TraceLevel.Debug, "WS-K04C :", variaveis().wsK04c());
                log(TraceLevel.Debug, "WS-K8267:", variaveis().wsK8267());
                log(TraceLevel.Debug, "BHOR04C1-X-REF-MOV  :", fwk600().registo().xRefMov());
                log(TraceLevel.Debug, "BHOR04C1-C-EVEN-OPEL:", fwk600().registo().cEvenOpel());
                log(TraceLevel.Debug, "BHOR04C1-C-OPE-BBN  :", fwk600().registo().cOpeBbn());
                log(TraceLevel.Debug, "SW-CHAVE: WS-K04C ", swChave, " WS-K8267");
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        /**
         * *----------------------------------------------------------------*
         */
        if (progOk.isTrue()) {
            tabelaImpressao().linha08().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            if (input1().input1Reg().subconta().cPaisIsoaCont().isEqual("PT") && 
                input1().input1Reg().subconta().cBancCont().isEqual(35)) {
                if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(0) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(100)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK001");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(101) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(200)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK002");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(201) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(300)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK003");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(301) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(400)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK004");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(401) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(500)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK005");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(501) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(600)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK006");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(601) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(700)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK007");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(701) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(800)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK008");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(801) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(900)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK009");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(901) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(1500)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK010");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(1501) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(2100)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK011");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(2101) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(2500)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK012");
                } else if (input1().input1Reg().subconta().cOeEgcCont().isGreaterOrEqual(2501) && 
                    input1().input1Reg().subconta().cOeEgcCont().isLessOrEqual(9999)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK013");
                }
            } else {
                tabelaImpressao().linha05().impFichRead().set("FWK014");
            }
            tabelaImpressao().linha05().impRegLidosInput1().set(contRegLidosInput1);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("TGH00002");
            tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh00201);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("TGH00102");
            tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh10201);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha07().impFichDel().set("TGH00022");
            tabelaImpressao().linha07().impRegDel().set(contRegDelVgh02201);
            tabelaImpressaoMask().zimp().setIndex(7) ;
            a12000EscreverFgh300() ;
            if (progOk.isTrue()) {
                commit() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha08().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha08().impReturnCode().set(returnCode);
            tabelaImpressao().linha09().impMens1().set("PGHQ002A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        input1().close() ;
        fwk600().close() ;
    }
    
    /**
     * 
     * 
     */
    protected void a71000CalculaTempoExecucao() {
        /**
         * *----------------------------------------------------------------*
         */
        bghw0300().wsVariaveisHora().horaFim().set(getTime()) ;
        /**
         * BOOK QUE CONTEM A ROTINA DE CALCULO DO TEMPO DE EXECUCAO
         * DO PROGRAMA
         */
        bghp0300() ;
    }
    
    /**
     * 
     * PASSIVAS 2540 - 2018-03-12 - INI
     * 
     */
    protected void a20000ObtemDescMovimento() {
        log(TraceLevel.Debug, "A20000-OBTEM-DESC-MOVIMENTO");
        bhol826a().commarea().initialize() ;
        bhol826a().commarea().dadosInput().cPaisIsoaOpe().set(input1().input1Reg().cPaisIsoaOeOpx());
        bhol826a().commarea().dadosInput().cMnemEgcOpe().set(input1().input1Reg().cMnemEgcOpex());
        bhol826a().commarea().dadosInput().aAplOrig().set(input1().input1Reg().aAplicacao());
        if (input1().input1Reg().iEstorno().isEmpty()) {
            bhol826a().commarea().dadosInput().iEstorno().set("N");
        } else {
            bhol826a().commarea().dadosInput().iEstorno().set(input1().input1Reg().iEstorno());
        }
        bhol826a().commarea().dadosInput().subconta().cPaisIsoaCont().set(input1().input1Reg().subconta().cPaisIsoaCont());
        bhol826a().commarea().dadosInput().subconta().cBancCont().set(input1().input1Reg().subconta().cBancCont());
        bhol826a().commarea().dadosInput().subconta().cOeEgcCont().set(input1().input1Reg().subconta().cOeEgcCont());
        bhol826a().commarea().dadosInput().subconta().nsRdclCont().set(input1().input1Reg().subconta().nsRdclCont());
        bhol826a().commarea().dadosInput().subconta().vChkdCont().set(input1().input1Reg().subconta().vChkdCont());
        bhol826a().commarea().dadosInput().subconta().cTipoCont().set(input1().input1Reg().subconta().cTipoCont());
        bhol826a().commarea().dadosInput().subconta().cMoedIsoScta().set(input1().input1Reg().subconta().cMoedIsoScta());
        bhol826a().commarea().dadosInput().subconta().nsDeposito().set(input1().input1Reg().subconta().nsDeposito());
        bhol826a().commarea().dadosInput().zMovimento().set(input1().input1Reg().zMovimento());
        bhol826a().commarea().dadosInput().nsMovimento().set(input1().input1Reg().nsMovimento());
        if (input1().input1Reg().aAplicacao().isEqual("PP")) {
            bhol826a().commarea().dadosInput().xRefMov().set(fwk600().registo().xRefMov());
            /**
             * GH 2181- ALTERACAO ACESSO PP - INICIO
             * MOVE BHOR04C1-C-EVEN-OPEL  TO BHOL826A-C-EVEN-OPEL
             */
            bhol826a().commarea().dadosInput().cEvenOpel().set(input1().input1Reg().cEvenOpel());
            /**
             * MOVE ZEROES                TO BHOL826A-C-OPE-BBN
             */
            bhol826a().commarea().dadosInput().cOpeBbn().set(input1().input1Reg().cOpeBbn());
        } else {
            /**
             * GH 2181 -ALTERACAO ACESSO PP - FIM
             */
            bhol826a().commarea().dadosInput().xRefMov().set(input1().input1Reg().xRefMov());
            bhol826a().commarea().dadosInput().cEvenOpel().set(input1().input1Reg().cEvenOpel());
            bhol826a().commarea().dadosInput().cOpeBbn().set(input1().input1Reg().cOpeBbn());
        }
        variaveis().wsNCheque().set(input1().input1Reg().nCheque());
        bhol826a().commarea().dadosInput().nCheque().set(variaveis().wsNCheque());
        bhol826a().commarea().dadosInput().cUserid().set(input1().input1Reg().cUserid());
        bhol826a().commarea().dadosInput().nJourBbn().set(input1().input1Reg().nJourBbn());
        bhol826a().commarea().dadosInput().cOeEgcOpex().set(input1().input1Reg().cOeEgcOpex());
        log(TraceLevel.Debug, "BHOL826A-C-PAIS-ISOA-OPE:", bhol826a().commarea().dadosInput().cPaisIsoaOpe());
        log(TraceLevel.Debug, "BHOL826A-C-MNEM-EGC-OPE:", bhol826a().commarea().dadosInput().cMnemEgcOpe());
        log(TraceLevel.Debug, "BHOL826A-A-APL-ORIG:", bhol826a().commarea().dadosInput().aAplOrig());
        log(TraceLevel.Debug, "BHOL826A-C-EVEN-OPEL:", bhol826a().commarea().dadosInput().cEvenOpel());
        log(TraceLevel.Debug, "BHOL826A-C-OPE-BBN:", bhol826a().commarea().dadosInput().cOpeBbn());
        log(TraceLevel.Debug, "BHOL826A-I-ESTORNO:", bhol826a().commarea().dadosInput().iEstorno());
        log(TraceLevel.Debug, "BHOL826A-C-PAIS-ISOA-CONT:", bhol826a().commarea().dadosInput().subconta().cPaisIsoaCont());
        log(TraceLevel.Debug, "BHOL826A-C-BANC-CONT:", bhol826a().commarea().dadosInput().subconta().cBancCont());
        log(TraceLevel.Debug, "BHOL826A-C-OE-EGC-CONT:", bhol826a().commarea().dadosInput().subconta().cOeEgcCont());
        log(TraceLevel.Debug, "BHOL826A-NS-RDCL-CONT:", bhol826a().commarea().dadosInput().subconta().nsRdclCont());
        log(TraceLevel.Debug, "BHOL826A-V-CHKD-CONT:", bhol826a().commarea().dadosInput().subconta().vChkdCont());
        log(TraceLevel.Debug, "BHOL826A-C-TIPO-CONT:", bhol826a().commarea().dadosInput().subconta().cTipoCont());
        log(TraceLevel.Debug, "BHOL826A-C-MOED-ISO-SCTA:", bhol826a().commarea().dadosInput().subconta().cMoedIsoScta());
        log(TraceLevel.Debug, "BHOL826A-NS-DEPOSITO:", bhol826a().commarea().dadosInput().subconta().nsDeposito());
        log(TraceLevel.Debug, "BHOL826A-X-REF-MOV:", bhol826a().commarea().dadosInput().xRefMov());
        log(TraceLevel.Debug, "BHOL826A-N-CHEQUE:", bhol826a().commarea().dadosInput().nCheque());
        log(TraceLevel.Debug, "BHOL826A-C-USERID:", bhol826a().commarea().dadosInput().cUserid());
        log(TraceLevel.Debug, "BHOL826A-N-JOUR-BBN:", bhol826a().commarea().dadosInput().nJourBbn());
        log(TraceLevel.Debug, "BHOL826A-C-OE-EGC-OPEX:", bhol826a().commarea().dadosInput().cOeEgcOpex());
        bhop0826ClassMov() ;
        if (!bhol826a().commarea().dadosErro().semErros().isTrue()) {
            tabelaImpressao().linha08().impReturnCode().set(bhol826a().commarea().dadosErro().cRtnoEvenSwal());
            /**
             * BHOL826A-C-RTNO-EVEN-SWAL ' '
             */
            tabelaImpressao().linha10().msgStatus().set(concat("PGHQ002A - ", bhol826a().cRotina(), " ", bhol826a().commarea().dadosErro().cTipoErroBbn(), " ", bhol826a().commarea().dadosErro().aAplErr(), " ", tabelaImpressao().linha08().impReturnCode(), " ", bhol826a().commarea().dadosErro().nmTabela()));
            tabelaImpressao().linha10().impStatus().set(bhol826a().commarea().dadosErro().cSqlcode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().impReturnCode().set(returnCode);
            log(TraceLevel.Debug, "BHOL826A-C-PAIS-ISOA-OPE   : ", bhol826a().commarea().dadosInput().cPaisIsoaOpe());
            log(TraceLevel.Debug, "BHOL826A-C-MNEM-EGC-OPE    : ", bhol826a().commarea().dadosInput().cMnemEgcOpe());
            log(TraceLevel.Debug, "BHOL826A-A-APL-ORIG        : ", bhol826a().commarea().dadosInput().aAplOrig());
            log(TraceLevel.Debug, "BHOL826A-C-EVEN-OPEL       : ", bhol826a().commarea().dadosInput().cEvenOpel());
            log(TraceLevel.Debug, "BHOL826A-C-OPE-BBN         : ", bhol826a().commarea().dadosInput().cOpeBbn());
            log(TraceLevel.Debug, "BHOL826A-I-ESTORNO         : ", bhol826a().commarea().dadosInput().iEstorno());
            log(TraceLevel.Debug, "BHOL826A-D-MOVIMENTO       : ", bhol826a().commarea().dadosOutput().dMovimento());
            log(TraceLevel.Debug, "BHOL826A-C-CATG-MOV        : ", bhol826a().commarea().dadosOutput().cCatgMov());
            log(TraceLevel.Debug, "BHOL826A-C-CATG-MOV-NVL1   : ", bhol826a().commarea().dadosOutput().cCatgMovNvl1());
            log(TraceLevel.Debug, "BHOL826A-I-CATG-NVL2       : ", bhol826a().commarea().dadosOutput().iCatgNvl2());
            log(TraceLevel.Debug, "BHOL826A-C-TIPO-ENT-NVL2   : ", bhol826a().commarea().dadosOutput().cTipoEntNvl2());
            log(TraceLevel.Debug, "BHOL826A-C-ATBT-ENT-NVL2   : ", bhol826a().commarea().dadosOutput().cAtbtEntNvl2());
            log(TraceLevel.Debug, "BHOL826A-V-POSZ-INI-ENT-NV2: ", bhol826a().commarea().dadosOutput().vPoszIniEntNv2());
            log(TraceLevel.Debug, "BHOL826A-Q-CTER-CMP-ENT-NV2: ", bhol826a().commarea().dadosOutput().qCterCmpEntNv2());
            log(TraceLevel.Debug, "BHOL826A-C-ID-CRDX-CBC-SEPA: ", bhol826a().commarea().dadosOutput().cIdCrdxCbcSepa());
        }
    }
    
    /**
     * 
     * PASSIVAS 2540 - 2018-03-12 - FIM
     * 
     */
    protected void a30000EscreverHistorico() {
        log(TraceLevel.Debug, "A30000-ESCREVER-HISTORICO");
        hv00201Movhst().movhst().initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(input1().input1Reg().subconta().cPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(input1().input1Reg().subconta().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(input1().input1Reg().subconta().cBancCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(input1().input1Reg().subconta().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(input1().input1Reg().subconta().cOeEgcCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(input1().input1Reg().subconta().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(input1().input1Reg().subconta().nsRdclCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(input1().input1Reg().subconta().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(input1().input1Reg().subconta().vChkdCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(input1().input1Reg().subconta().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(input1().input1Reg().subconta().cTipoCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(input1().input1Reg().subconta().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(input1().input1Reg().subconta().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(input1().input1Reg().subconta().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(input1().input1Reg().subconta().nsDeposito());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(input1().input1Reg().subconta().nsDeposito());
        hv00201Movhst().movhst().nsMovimento().set(input1().input1Reg().nsMovimento());
        hv10201Movhstcpl().movhstcpl().nsMovimento().set(input1().input1Reg().nsMovimento());
        wTimestamp().wDataTimestamp().set(input1().input1Reg().zMovimento());
        wTimestamp().set(input1().input1Reg().tsActzUlt());
        /**
         * MOVE ZEROS                       TO W-HH
         * W-MM
         * W-SS
         * W-DD
         */
        hv00201Movhst().movhst().tsMovimento().set(wTimestamp());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(wTimestamp());
        hv00201Movhst().movhst().zValMov().set(input1().input1Reg().zValor());
        hv00201Movhst().movhst().zMovLocl().set(input1().input1Reg().zProcessamento());
        hv00201Movhst().movhst().iDbcr().set(input1().input1Reg().iDbcr());
        hv00201Movhst().movhst().mMovimento().set(input1().input1Reg().mMovimento());
        if (input1().input1Reg().iEstorno().isEqual("A")) {
            hv00201Movhst().movhst().iEstorno().set(" ");
        } else {
            hv00201Movhst().movhst().iEstorno().set(input1().input1Reg().iEstorno());
        }
        hv00201Movhst().movhst().cMoedIsoOriMov().set(input1().input1Reg().cMoedIsoOriMov());
        hv00201Movhst().movhst().mSldoCbloApos().set(input1().input1Reg().mSldoCblo());
        hv00201Movhst().movhst().mSldoDpnlApos().set(input1().input1Reg().mSldoDpnl());
        hv00201Movhst().movhst().mMovMoeOrigMov().set(input1().input1Reg().mMovMoeOrigMov());
        hv00201Movhst().movhst().xRefMov().set(input1().input1Reg().xRefMov());
        hv00201Movhst().movhst().nDocOpps().set(input1().input1Reg().nCheque());
        if (input1().input1Reg().aAplicacao().isEmpty()) {
            hv00201Movhst().movhst().aAplOrig().set("HO");
        } else {
            hv00201Movhst().movhst().aAplOrig().set(input1().input1Reg().aAplicacao());
        }
        /**
         * *GH1352-F
         */
        if ((hv00201Movhst().movhst().aAplOrig().isEqual("PP") && 
            variaveis().wsK04c().isEqual(variaveis().wsK8267())) || 
            (variaveis().wsK04c().isEqual(variaveis().wsK8267()) && 
            input1().input1Reg().cOpeBbn().get(1, 2).isEqual("PP") && 
            (input1().input1Reg().cEvenOpel().isEqual("HVA6") || 
            input1().input1Reg().cEvenOpel().isEqual("HVA8")))) {
            hv00201Movhst().movhst().xChavAcsInfAdi().get(1, 21).set(fwk600().registo().xRefMov()) ;
            hv00201Movhst().movhst().xChavAcsInfAdi().get(22, 4).set(fwk600().registo().cEvenOpel()) ;
            hv00201Movhst().movhst().xChavAcsInfAdi().get(26, 5).set(fwk600().registo().cOpeBbn()) ;
            hv00201Movhst().movhst().iExisInfAdi().set("S");
            log(TraceLevel.Debug, "APLICACAO PP E CHAVE IGUAL");
            log(TraceLevel.Debug, "VGH00201-X-CHAV-ACS-INF-ADI:", hv00201Movhst().movhst().xChavAcsInfAdi());
        } else {
            hv00201Movhst().movhst().iExisInfAdi().set("N");
            if (hv00201Movhst().movhst().aAplOrig().isEqual("PP")) {
                log(TraceLevel.Debug, "APLICACAO PP E CHAVE DIFERENTE");
            }
            if (hv00201Movhst().movhst().aAplOrig().isEqual("HO") || 
                hv00201Movhst().movhst().aAplOrig().isEqual("HV")) {
                bghw0004().tbInfAdi().itemAdi().resetIndex() ;
                while (bghw0004().tbInfAdi().itemAdi().index().isLessOrEqual(6)) {
                    if (input1().input1Reg().cEvenOpel().isEqual(bghw0004().tbInfAdi().itemAdi().getCurrent().tabRefAdi().get(1, 4))) {
                        hv00201Movhst().movhst().iExisInfAdi().set("S");
                        break;
                    }
                    bghw0004().tbInfAdi().itemAdi().incIndex() ;
                }
                if (bghw0004().tbInfAdi().itemAdi().atEnd()) {
                    hv00201Movhst().movhst().iExisInfAdi().set("N");
                }
            }
            /**
             * *GH1352-I
             */
            if (hv00201Movhst().movhst().aAplOrig().isEqual("PK")) {
                hv00201Movhst().movhst().iExisInfAdi().set("S");
                hv00201Movhst().movhst().xChavAcsInfAdi().get(1, 3).set(input1().input1Reg().subconta().cPaisIsoaCont()) ;
                hv00201Movhst().movhst().xChavAcsInfAdi().get(4, 3).set(input1().input1Reg().cMnemEgcOpex()) ;
                hv00201Movhst().movhst().xChavAcsInfAdi().get(7, 21).set(input1().input1Reg().xRefMov()) ;
            }
        }
        /**
         * MOVE SPACES                    TO VGH00201-X-CHAV-ACS-INF-ADI
         */
        hv00201Movhst().movhst().tsActzUlt().set(input1().input1Reg().tsActzUlt());
        hv10201Movhstcpl().movhstcpl().tsActzUlt().set(input1().input1Reg().tsActzUlt());
        hv00201Movhst().movhst().cUsidActzUlt().set(input1().input1Reg().cUsidActzUlt());
        hv10201Movhstcpl().movhstcpl().cUsidActzUlt().set(input1().input1Reg().cUsidActzUlt());
        hv10201Movhstcpl().movhstcpl().cTransaccao().set(" ");
        if (input1().input1Reg().aAplicacao().isEmpty()) {
            hv10201Movhstcpl().movhstcpl().aAplicacao().set("HO");
        } else {
            hv10201Movhstcpl().movhstcpl().aAplicacao().set(input1().input1Reg().aAplicacao());
        }
        hv10201Movhstcpl().movhstcpl().cOpczMenu().set(input1().input1Reg().cOpczMenu());
        hv10201Movhstcpl().movhstcpl().cOpeBbn().set(input1().input1Reg().cOpeBbn());
        hv10201Movhstcpl().movhstcpl().cEvenOpel().set(input1().input1Reg().cEvenOpel());
        hv10201Movhstcpl().movhstcpl().cTerminal().set(" ");
        hv10201Movhstcpl().movhstcpl().cOperador().set(0);
        hv10201Movhstcpl().movhstcpl().cOpexAtrx().set(0);
        hv10201Movhstcpl().movhstcpl().cUserid().set(input1().input1Reg().cUserid());
        hv10201Movhstcpl().movhstcpl().cTipoCanlAces().set(input1().input1Reg().cTipoCanlAces());
        hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx().set(input1().input1Reg().cPaisIsoaOeOpx());
        hv10201Movhstcpl().movhstcpl().cMnemEgcOpex().set(input1().input1Reg().cMnemEgcOpex());
        hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(input1().input1Reg().cOeEgcOpex());
        hv10201Movhstcpl().movhstcpl().cProdSgop().set(0);
        hv10201Movhstcpl().movhstcpl().cFamiProd().set(input1().input1Reg().cFamiProd());
        hv10201Movhstcpl().movhstcpl().cProduto().set(input1().input1Reg().cProduto());
        hv10201Movhstcpl().movhstcpl().cCndzMovzCont().set(0);
        hv10201Movhstcpl().movhstcpl().cGrupCont().set(0);
        hv10201Movhstcpl().movhstcpl().cTipoIttz().set(input1().input1Reg().cSectIttlBpor());
        hv10201Movhstcpl().movhstcpl().tCambio().set(input1().input1Reg().tCambio());
        hv10201Movhstcpl().movhstcpl().mSldoRetd().set(input1().input1Reg().mSldoRetd());
        hv10201Movhstcpl().movhstcpl().mSldoVcob().set(input1().input1Reg().mSldoVcob());
        hv10201Movhstcpl().movhstcpl().mCmrgLim().set(input1().input1Reg().mCmrgLim());
        hv10201Movhstcpl().movhstcpl().mCmrgUtid().set(input1().input1Reg().mCmrgUtid());
        hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd().set(input1().input1Reg().mDcboNgcdAtrd());
        hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid().set(input1().input1Reg().mDcboNgcdUtid());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(input1().input1Reg().nJourBbn());
        hv10201Movhstcpl().movhstcpl().nsJourBbn().set(input1().input1Reg().nsJourBbn());
        hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh().set(input1().input1Reg().nsJourBbnDtlh());
        hv10201Movhstcpl().movhstcpl().nmArqvOrig().set("THO00020");
        /**
         * PASSIVAS 2540 - 2018-03-12 - INI
         */
        hv10201Movhstcpl().movhstcpl().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-12 - FIM
         */
        a30001InsVgh00201Movhst() ;
        if (progOk.isTrue()) {
            a30002InsVgh10201Movhstcpl() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30001InsVgh00201Movhst() {
        log(TraceLevel.Debug, "A30001-INS-VGH00201-MOVHST");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00201_MOVHST
         */
        hv00201Movhst().insertPghq002a1147() ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh00201.add(1);
        } else {
            log(TraceLevel.Trace, " CHAVE VGH00201: ");
            log(TraceLevel.Trace, " C-PAIS-ISOA-CONT:", hv00201Movhst().movhst().cPaisIsoaCont());
            log(TraceLevel.Trace, " C-BANC-CONT     :", hv00201Movhst().movhst().cBancCont());
            log(TraceLevel.Trace, " C-OE-EGC-CONT   :", hv00201Movhst().movhst().cOeEgcCont());
            log(TraceLevel.Trace, " NS-RDCL-CONT    :", hv00201Movhst().movhst().nsRdclCont());
            log(TraceLevel.Trace, " V-CHKD-CONT     :", hv00201Movhst().movhst().vChkdCont());
            log(TraceLevel.Trace, " C-TIPO-CONT     :", hv00201Movhst().movhst().cTipoCont());
            log(TraceLevel.Trace, " C-MOED-ISO-SCTA :", hv00201Movhst().movhst().cMoedIsoScta());
            log(TraceLevel.Trace, " NS-DEPOSITO     :", hv00201Movhst().movhst().nsDeposito());
            log(TraceLevel.Trace, " TS-MOVIMENTO    :", hv00201Movhst().movhst().tsMovimento());
            log(TraceLevel.Trace, " NS-MOVIMENTO    :", hv00201Movhst().movhst().nsMovimento());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - VGH00201 - INSERT  - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30002InsVgh10201Movhstcpl() {
        log(TraceLevel.Debug, "A30002-INS-VGH10201-MOVHSTCPL");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().insertPghq002a1240() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh10201.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - VGH10201-INSERT - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000DelDiaAnterior() {
        log(TraceLevel.Debug, "A31000-DEL-DIA-ANTERIOR");
        /**
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().deletePghq002a1359(hv00201Movhst().movhst()) ;
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegDelVgh02201.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ002A - VGH02201 - DELETE  - ");
            wSqlcode.set(hv02201Movdiaant().getPersistenceCode());
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36000ControlaCommit() {
        log(TraceLevel.Debug, "A36000-CONTROLA-COMMIT");
        contRegCommit.add(1);
        if (contRegCommit.isEqual(1000)) {
            commit() ;
            a36100EscreverFwk900() ;
            if (progOk.isTrue()) {
                contRegCommit.set(0);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36100EscreverFwk900() {
        log(TraceLevel.Debug, "A36100-ESCREVER-FWK900");
        a14000AbrirFwk900() ;
        if (progOk.isTrue()) {
            fwk900().read() ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHQZ02A - FWK900 - READ - ");
                tabelaImpressao().linha10().impStatus().set(wSqlcode);
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQZ02A - FWK900 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghq002a().fwk900NCommit().set(add(fwk900().fwk900RegPghq002a().fwk900NCommit(), contRegCommit));
            fwk900().rewrite() ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHQZ02A - FWK900 - REWRITE -");
                tabelaImpressao().linha10().impStatus().set(wSqlcode);
            }
        }
        if (progOk.isTrue()) {
            fwk900().close() ;
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         * DISPLAY 'INICIO DO PGHQ002A'
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!input1().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=4)
        IInt anoCorrente() ;
        
        @Data(size=2)
        IInt mesCorrente() ;
        
        @Data(size=2)
        IInt diaCorrente() ;
        
    }
    public interface WTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestamp
         */
        @Data
        WDataTimestamp wDataTimestamp() ;
        
        /**
         * @return instancia da classe local WTimerTimestamp
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerTimestamp wTimerTimestamp() ;
        
        
        public interface WDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wHh() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wSs() ;
            
            @Data(size=6, lpadding=1, lpaddingValue=".")
            IInt wDd() ;
            
        }
    }
    public interface Variaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsK8267
         */
        @Data
        WsK8267 wsK8267() ;
        
        /**
         * @return instancia da classe local WsK04c
         */
        @Data
        WsK04c wsK04c() ;
        
        @Data(size=10)
        IString wsNCheque() ;
        
        
        public interface WsK8267 extends IDataStruct {
            
            @Data(size=3)
            IString wsK8267CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt wsK8267CBancCont() ;
            
            @Data(size=4)
            IInt wsK8267COeEgcCont() ;
            
            @Data(size=7)
            IInt wsK8267NsRdclCont() ;
            
            @Data(size=1)
            IInt wsK8267VChkdCont() ;
            
            @Data(size=3)
            IInt wsK8267CTipoCont() ;
            
            @Data(size=3)
            IString wsK8267CMoedIsoScta() ;
            
            @Data(size=4)
            IInt wsK8267NsDeposito() ;
            
            @Data(size=15)
            ILong wsK8267NsMovimento() ;
            
        }
        
        public interface WsK04c extends IDataStruct {
            
            @Data(size=3)
            IString wsK04cCPaisIsoaCont() ;
            
            @Data(size=4)
            IInt wsK04cCBancCont() ;
            
            @Data(size=4)
            IInt wsK04cCOeEgcCont() ;
            
            @Data(size=7)
            IInt wsK04cNsRdclCont() ;
            
            @Data(size=1)
            IInt wsK04cVChkdCont() ;
            
            @Data(size=3)
            IInt wsK04cCTipoCont() ;
            
            @Data(size=3)
            IString wsK04cCMoedIsoScta() ;
            
            @Data(size=4)
            IInt wsK04cNsDeposito() ;
            
            @Data(size=15)
            ILong wsK04cNsMovimento() ;
            
        }
    }
    
    /**
     * 
     * TABELA DE IMPRESSAO DE FGH300
     * 
     * @version 2.0
     * 
     */
    public interface TabelaImpressao extends IDataStruct {
        
        @Data(size=121, value=" ")
        IString linha01() ;
        
        /**
         * @return instancia da classe local Linha02
         */
        @Data
        Linha02 linha02() ;
        
        /**
         * @return instancia da classe local Linha03
         */
        @Data
        Linha03 linha03() ;
        
        /**
         * @return instancia da classe local Linha04
         */
        @Data
        Linha04 linha04() ;
        
        /**
         * @return instancia da classe local Linha05
         */
        @Data
        Linha05 linha05() ;
        
        /**
         * @return instancia da classe local Linha06
         */
        @Data
        Linha06 linha06() ;
        
        /**
         * @return instancia da classe local Linha07
         */
        @Data
        Linha07 linha07() ;
        
        /**
         * @return instancia da classe local Linha08
         */
        @Data
        Linha08 linha08() ;
        
        /**
         * @return instancia da classe local Linha09
         */
        @Data
        Linha09 linha09() ;
        
        /**
         * @return instancia da classe local Linha10
         */
        @Data
        Linha10 linha10() ;
        
        /**
         * @return instancia da classe local Linha11
         */
        @Data
        Linha11 linha11() ;
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ002A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="DATA:     ")
            IString filler004() ;
            
            @Data(size=10, rpadding=84, rpaddingValue="")
            IString impData() ;
            
        }
        
        public interface Linha03 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="HORA INICIO: ")
            IString filler002() ;
            
            @Data(size=8, decimal=2, value="0")
            IDecimal impHoraInicio() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="HORA FIM: ")
            IString filler004() ;
            
            @Data(size=8, decimal=2, value="0", rpadding=55, rpaddingValue="")
            IDecimal impHoraFim() ;
            
        }
        
        public interface Linha04 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ002A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosInput1() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ESCRITOS  ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ELIMINADOS ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichDel() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegDel() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha11 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=11, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
