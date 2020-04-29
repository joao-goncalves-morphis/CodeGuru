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


/**
 * 
 * AREA DB2/SQL - COMUNICATION AREA
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * ROTINA DIARIA
 * OBJECTIVOS    : CARREGAMENTO DAS TABELAS:
 * - TGH00001_CONTHST
 * - TGH00010_CONTIPHST
 * COM OS FICHEIROS FWK051 A FWK059 E FWK060 A
 * FWK064 GERADOS NO PROGRAMA PGHC001A.
 * ESTES FICHEIROS SAO IDENTIFICADOS COMO INPUT1.
 * ---- > FICHEIROS COM AS CONTAS QUE MOVIMENTARAM NO DIA  < ---
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq015a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00101Conthst
     */
    @Data
    protected abstract Vwsdghps00101Conthst hv00101Conthst() ;
    
    /**
     * @return instancia da classe Vwsdghps01001Contiphst
     */
    @Data
    protected abstract Vwsdghps01001Contiphst hv01001Contiphst() ;
    
    
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
     * @return instancia da classe Fwk051
     */
    @Handler(name="INPUT1", record="rwk01501")
    @Data
    protected abstract Fwk051 input1() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghq015a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghwz001
     */
    @Data
    protected abstract Bghwz001 bghwz001() ;
    
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
    
    
    @Data(size=4, signed=true, value="0", compression=COMP3)
    protected IInt wsZaFim ;
    
    @Data(size=1, value=" ")
    protected IString wCrtlVerTg10 ;
    @Data
    @Condition("N")
    protected ICondition naoVerTgh10 ;
    @Data
    @Condition("S")
    protected ICondition verTgh10 ;
    
    
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
    
    @Data(size=4)
    protected IInt wsAnoAa ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosInput1 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegActVgh00101 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegActVgh01001 ;
    
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
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ015A");
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
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
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
            auxContRegLidos.set(fwk900().fwk900RegPghq015a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq015a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - FWK900 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
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
            fwk900().fwk900RegPghq015a().initialize() ;
            fwk900().fwk900RegPghq015a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghq015a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ015A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - FWK900 - OPEN- ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
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
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - INPUT1 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(input1().getStatus());
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
        }
        if (!input1().getStatusOk() && !input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - INPUT1 - READ - ");
            tabelaImpressao().linha09().impStatus().set(input1().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarTgh1Conthst() ;
        if (progOk.isTrue()) {
            a32001VerificarTgh10() ;
        }
        if (verTgh10.isTrue()) {
            if (progOk.isTrue()) {
                a32000TratarTgh10Contiphst() ;
            }
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17000LerInput1() ;
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
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            if (input1().rwk01501().fwk015CPaisIsoaCont().isEqual("PT") && 
                input1().rwk01501().fwk015CBancCont().isEqual(35)) {
                if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(0) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(100)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK051");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(101) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(200)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK052");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(201) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(300)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK053");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(301) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(400)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK054");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(401) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(500)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK055");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(501) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(600)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK056");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(601) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(700)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK057");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(701) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(800)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK058");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(801) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(900)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK059");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(901) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(1500)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK060");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(1501) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(2100)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK061");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(2101) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(2500)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK062");
                } else if (input1().rwk01501().fwk015COeEgcCont().isGreaterOrEqual(2501) && 
                    input1().rwk01501().fwk015COeEgcCont().isLessOrEqual(9999)) {
                    tabelaImpressao().linha05().impFichRead().set("FWK063");
                }
            } else {
                tabelaImpressao().linha05().impFichRead().set("FWK064");
            }
            tabelaImpressao().linha05().impRegLidosInput1().set(contRegLidosInput1);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("VGH00101");
            tabelaImpressao().linha06().impRegEscrt().set(contRegActVgh00101);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("VGH01001");
            tabelaImpressao().linha06().impRegEscrt().set(contRegActVgh01001);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            if (progOk.isTrue()) {
                commit() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ015A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        input1().close() ;
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
     * 
     */
    protected void a31000TratarTgh1Conthst() {
        log(TraceLevel.Debug, "A31000-TRATAR-TGH1-CONTHST");
        a31100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            a31300ActRegTgh1() ;
        } else if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
            if (progOk.isTrue()) {
                a31400InsRegTgh1() ;
            }
        }
        if (progOk.isTrue()) {
            a31500CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100OpenCursorC1() {
        log(TraceLevel.Debug, "A31100-OPEN-CURSOR-C1");
        wSqlcode.initialize() ;
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cPaisIsoaCont().set(input1().rwk01501().fwk015CPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(input1().rwk01501().fwk015CBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(input1().rwk01501().fwk015COeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(input1().rwk01501().fwk015NsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(input1().rwk01501().fwk015VChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(input1().rwk01501().fwk015CTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(input1().rwk01501().fwk015CMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(input1().rwk01501().fwk015NsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00101Conthst().openPghq015a741() ;
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200FetchCursorC1() {
        log(TraceLevel.Debug, "A31200-FETCH-CURSOR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv00101Conthst().fetchPghq015a769() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - FETCH C1- VGH01001 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
            a31500CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300ActRegTgh1() {
        log(TraceLevel.Debug, "A31300-ACT-REG-TGH1");
        hv00101Conthst().conthst().zMovHistUlt().set(input1().rwk01501().fwk015ZMovimento());
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00101_CONTHST
         */
        hv00101Conthst().updatePghq015a823() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegActVgh00101.add(1);
        } else {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - UPD C1 - VGH01001 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400InsRegTgh1() {
        log(TraceLevel.Debug, "A31400-INS-REG-TGH1");
        wSqlcode.initialize() ;
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cPaisIsoaCont().set(input1().rwk01501().fwk015CPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(input1().rwk01501().fwk015CBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(input1().rwk01501().fwk015COeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(input1().rwk01501().fwk015NsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(input1().rwk01501().fwk015VChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(input1().rwk01501().fwk015CTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(input1().rwk01501().fwk015CMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(input1().rwk01501().fwk015NsDeposito());
        hv00101Conthst().conthst().iActivo().set("N");
        hv00101Conthst().conthst().zAbraCont().set("0001-01-01");
        hv00101Conthst().conthst().zCcltCont().set("0001-01-01");
        hv00101Conthst().conthst().zRabtCont().set("0001-01-01");
        hv00101Conthst().conthst().zRabtContCcld().set("0001-01-01");
        hv00101Conthst().conthst().zMovHistUlt().set(input1().rwk01501().fwk015ZMovimento());
        hv00101Conthst().conthst().cUsidActzUlt().set("PGHQ015A");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00101_CONTHST
         */
        hv00101Conthst().insertPghq015a872() ;
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegActVgh00101.add(1);
        } else {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - INSERT- VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "SQLCODE-", wSqlcode);
            a31500CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31500CloseCursorC1() {
        log(TraceLevel.Debug, "A31500-CLOSE-CURSOR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv00101Conthst().closePghq015a940() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - CLOSE C1-VGH01001 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32001VerificarTgh10() {
        log(TraceLevel.Debug, "A32001-VERIFICAR-TGH10");
        verTgh10.setTrue() ;
        wSqlcode.initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        wsZaFim.initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(input1().rwk01501().fwk015CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(input1().rwk01501().fwk015CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(input1().rwk01501().fwk015COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(input1().rwk01501().fwk015NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(input1().rwk01501().fwk015VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(input1().rwk01501().fwk015CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(input1().rwk01501().fwk015CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(input1().rwk01501().fwk015NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set("VGH00201");
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().selectPghq015a983() ;
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL) {
            wsZaFim.set(input1().rwk01501().fwk015ZMovimento().get(1, 4));
            if (wsZaFim.isEqual(hv01001Contiphst().contiphst().zaFim())) {
                naoVerTgh10.setTrue() ;
            }
        }
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - SELECT - ");
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000TratarTgh10Contiphst() {
        log(TraceLevel.Debug, "A32000-TRATAR-TGH10-CONTIPHST");
        a32100OpenCursorC2() ;
        if (progOk.isTrue()) {
            a32200FetchCursorC2() ;
        }
        if (progOk.isTrue()) {
            a32300ActRegTgh10() ;
        } else if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
            if (progOk.isTrue()) {
                a32400InsRegTgh10() ;
            }
        }
        if (progOk.isTrue()) {
            a32500CloseCursorC2() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100OpenCursorC2() {
        log(TraceLevel.Debug, "A32100-OPEN-CURSOR-C2");
        wSqlcode.initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(input1().rwk01501().fwk015CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(input1().rwk01501().fwk015CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(input1().rwk01501().fwk015COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(input1().rwk01501().fwk015NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(input1().rwk01501().fwk015VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(input1().rwk01501().fwk015CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(input1().rwk01501().fwk015CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(input1().rwk01501().fwk015NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set("VGH00201");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv01001Contiphst().openPghq015a1070() ;
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - CURSOR C2   - OPEN - ");
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32200FetchCursorC2() {
        log(TraceLevel.Debug, "A32200-FETCH-CURSOR-C2");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C2
         */
        hv01001Contiphst().fetchPghq015a1098() ;
        wSqlcode.set(hv01001Contiphst().getPersistenceCode());
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - FETCH C2- VGH01001 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
            a32500CloseCursorC2() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32300ActRegTgh10() {
        log(TraceLevel.Debug, "A32300-ACT-REG-TGH10");
        wsAnoAa.set(input1().rwk01501().fwk015ZMovimento().get(1, 4));
        hv01001Contiphst().contiphst().zaFim().set(wsAnoAa);
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().updatePghq015a1137() ;
        wSqlcode.set(hv01001Contiphst().getPersistenceCode());
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegActVgh01001.add(1);
        } else {
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - UPD C2 - VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32400InsRegTgh10() {
        log(TraceLevel.Debug, "A32400-INS-REG-TGH10");
        wSqlcode.initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(input1().rwk01501().fwk015CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(input1().rwk01501().fwk015CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(input1().rwk01501().fwk015COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(input1().rwk01501().fwk015NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(input1().rwk01501().fwk015VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(input1().rwk01501().fwk015CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(input1().rwk01501().fwk015CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(input1().rwk01501().fwk015NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set("VGH00201");
        hv01001Contiphst().contiphst().cTipoInfHist().set("P");
        wsAnoAa.set(input1().rwk01501().fwk015ZMovimento().get(1, 4));
        hv01001Contiphst().contiphst().zaInicio().set(wsAnoAa);
        hv01001Contiphst().contiphst().zaFim().set(wsAnoAa);
        hv01001Contiphst().contiphst().cUsidActzUlt().set("PGHQ015A");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().insertPghq015a1185() ;
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegActVgh01001.add(1);
        } else {
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - INSERT- VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "SQLCODE-", wSqlcode);
            a32500CloseCursorC2() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32500CloseCursorC2() {
        log(TraceLevel.Debug, "A32500-CLOSE-CURSOR-C2");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C2
         */
        hv01001Contiphst().closePghq015a1246() ;
        wSqlcode.set(hv01001Contiphst().getPersistenceCode());
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ015A - CLOSE C2-VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
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
                tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - READ - ");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghq015a().initialize() ;
            fwk900().fwk900RegPghq015a().fwk900NCommit().set(contRegCommit);
            fwk900().rewrite(fwk900().fwk900RegPghq015a()) ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - REWRITE -");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ015A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ015A")
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
            
            @Data(size=32, value="NUMERO DE REGISTOS ACTUALIZADOS")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=10, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
