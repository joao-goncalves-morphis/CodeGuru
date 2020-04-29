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
import cgd.gh.structures.work.Bghr0021 ;
import cgd.gh.structures.work.Bghr0101 ;
import cgd.gh.structures.work.Bghwz001 ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CARREGAMENTO DAS TABELAS:
 * - TGH00010_CONTIPHST
 * FICHEIROS     : VARIOS
 * TODOS ESTES FICHEIROS SAO IDENTIFICADOS NO
 * PROGRAMA COMO INPUT1
 * 
 * @version 2.0
 * 
 */
public abstract class Pghqz29a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
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
     * @return instancia da classe Input1
     */
    @Handler(name="INPUT1", record="statusInput102")
    @Data
    protected abstract Input1 input1() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghqz29a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghr0021
     */
    @Data
    protected abstract Bghr0021 bghr0021() ;
    
    /**
     * @return instancia da classe Bghr0101
     */
    @Data
    protected abstract Bghr0101 bghr0101() ;
    
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
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=15, value="0")
    protected ILong wsNContaAnt ;
    
    /**
     * @return instancia da classe local WsNContaAntMask
     */
    @Data
    @Mask
    protected abstract WsNContaAntMask wsNContaAntMask() ;
    
    /**
     * @return instancia da classe local ChaveFgh002
     */
    @Data
    protected abstract ChaveFgh002 chaveFgh002() ;
    
    @Data(size=15, value="0")
    protected ILong wsNConta ;
    
    /**
     * @return instancia da classe local WsNContaMask
     */
    @Data
    @Mask
    protected abstract WsNContaMask wsNContaMask() ;
    
    @Data(size=3, value=" ")
    protected IString wsCMoedIsoSctaAnt ;
    
    @Data(size=3, value=" ")
    protected IString wsCMoedIsoScta ;
    
    @Data(size=1, value=" ")
    protected IString wsCTipoInfHist ;
    
    @Data(size=10, value=" ")
    protected IString wsZMovHstUlt ;
    
    @Data(size=4, signed=true, value="0", compression=COMP3)
    protected IInt wsNsDepositoAnt ;
    
    @Data(size=4, signed=true, value="0", compression=COMP3)
    protected IInt wsNsDeposito ;
    
    @Data(size=4, signed=true, value="0", compression=COMP3)
    protected IInt wsZaInicioAnt ;
    
    @Data(size=4, signed=true, value="0", compression=COMP3)
    protected IInt wsZaFimAnt ;
    
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
     * @return instancia da classe local WsVgh01001
     */
    @Data
    protected abstract WsVgh01001 wsVgh01001() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosInput1 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh02401 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh01001 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQZ29A");
        wsCTipoInfHist.set("P");
        wsZMovHstUlt.set("0001-01-01");
        wsNContaAnt.set(0);
        wsNConta.set(0);
        wsNsDepositoAnt.set(0);
        wsNsDeposito.set(0);
        wsZaInicioAnt.set(0);
        wsZaFimAnt.set(0);
        wsCMoedIsoSctaAnt.set(" ");
        wsCMoedIsoScta.set(" ");
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
            tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - FWK900 - OPEN - ");
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
            auxContRegLidos.set(fwk900().fwk900RegPghqz29a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghqz29a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - FWK900 - READ - ");
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
            fwk900().fwk900RegPghqz29a().initialize() ;
            fwk900().fwk900RegPghqz29a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghqz29a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - FWK900 - OPEN- ");
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
            tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - INPUT1 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(input1().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerInput1() {
        log(TraceLevel.Debug, "A17000-LER-INPUT1");
        wsVgh01001().initialize() ;
        input1().read(bghr0021().rgh00201()) ;
        if (input1().getStatusOk()) {
            contRegLidosInput1.add(1);
            chaveFgh002().cPaisIsoaContFgh002().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
            chaveFgh002().cBancContFgh002().set(bghr0021().rgh00201().fgh002CBancCont());
            wsNContaMask().wsCOeCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
            chaveFgh002().cOeEgcContFgh002().set(bghr0021().rgh00201().fgh002COeEgcCont());
            wsNContaMask().wsNsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
            chaveFgh002().nsRdclContFgh002().set(bghr0021().rgh00201().fgh002NsRdclCont());
            wsNContaMask().wsVChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
            chaveFgh002().vChkdContFgh002().set(bghr0021().rgh00201().fgh002VChkdCont());
            wsNContaMask().wsCTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
            chaveFgh002().cTipoContFgh002().set(bghr0021().rgh00201().fgh002CTipoCont());
            wsCMoedIsoScta.set(bghr0021().rgh00201().fgh002CMoedIsoScta());
            chaveFgh002().cMoedIsoSctaFgh002().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
            wsNsDeposito.set(bghr0021().rgh00201().fgh002NsDeposito());
            chaveFgh002().nsDepositoFgh002().set(bghr0021().rgh00201().fgh002NsDeposito());
            if (wsNConta.isEqual(wsNContaAnt) && 
                bghr0021().rgh00201().fgh002CMoedIsoScta().isEqual(wsCMoedIsoSctaAnt) && 
                bghr0021().rgh00201().fgh002NsDeposito().isEqual(wsNsDepositoAnt)) {
                swContaIgual.setTrue() ;
            } else {
                swContaDiferente.setTrue() ;
                wsNContaAntMask().wsCOeContAnt().set(bghr0021().rgh00201().fgh002COeEgcCont());
                wsNContaAntMask().wsNsRdclContAnt().set(bghr0021().rgh00201().fgh002NsRdclCont());
                wsNContaAntMask().wsVChkdContAnt().set(bghr0021().rgh00201().fgh002VChkdCont());
                wsNContaAntMask().wsCTipoContAnt().set(bghr0021().rgh00201().fgh002CTipoCont());
                wsCMoedIsoSctaAnt.set(bghr0021().rgh00201().fgh002CMoedIsoScta());
                wsNsDepositoAnt.set(bghr0021().rgh00201().fgh002NsDeposito());
            }
        }
        if (!input1().getStatusOk() && !input1().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - INPUT1 - READ - ");
            tabelaImpressao().linha09().impStatus().set(input1().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        /**
         * PERFORM A30000-ESCREVER-HISTORICO
         */
        if (progOk.isTrue()) {
            a31000TratarContiphst() ;
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
            if (wsNContaMask().wsCOeCont().isGreaterOrEqual(0) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(100)) {
                tabelaImpressao().linha05().impFichRead().set("FWK007");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(101) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(200)) {
                tabelaImpressao().linha05().impFichRead().set("FWK207");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(201) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(300)) {
                tabelaImpressao().linha05().impFichRead().set("FWK307");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(301) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(400)) {
                tabelaImpressao().linha05().impFichRead().set("FWK407");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(401) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(500)) {
                tabelaImpressao().linha05().impFichRead().set("FWK507");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(501) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(600)) {
                tabelaImpressao().linha05().impFichRead().set("FWK607");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(601) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(700)) {
                tabelaImpressao().linha05().impFichRead().set("FWK707");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(701) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(800)) {
                tabelaImpressao().linha05().impFichRead().set("FWK807");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(801) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(900)) {
                tabelaImpressao().linha05().impFichRead().set("FWK907");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(901) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(1500)) {
                tabelaImpressao().linha05().impFichRead().set("FWK497");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(1501) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(2100)) {
                tabelaImpressao().linha05().impFichRead().set("FWK697");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(2101) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(2500)) {
                tabelaImpressao().linha05().impFichRead().set("FWK897");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(2501) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(9999)) {
                tabelaImpressao().linha05().impFichRead().set("FWK337");
            }
            tabelaImpressao().linha05().impRegLidosInput1().set(contRegLidosInput1);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("VGH02401");
            tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh02401);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("VGH01001");
            tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh01001);
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
            tabelaImpressao().linha08().impMens1().set("PGHQZ29A - FIM ANORMAL ");
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
     * *A30000-ESCREVER-HISTORICO.
     * IF SW-DEBUG-ON
     * DISPLAY 'A30000-ESCREVER-HISTORICO'
     * END-IF
     * INITIALIZE VGH02401-MOVHIST4
     * MOVE FGH002-C-PAIS-ISOA-CONT    TO VGH02401-C-PAIS-ISOA-CONT
     * MOVE FGH002-C-BANC-CONT         TO VGH02401-C-BANC-CONT
     * MOVE FGH002-C-OE-EGC-CONT       TO VGH02401-C-OE-EGC-CONT
     * MOVE FGH002-NS-RDCL-CONT        TO VGH02401-NS-RDCL-CONT
     * MOVE FGH002-V-CHKD-CONT         TO VGH02401-V-CHKD-CONT
     * MOVE FGH002-C-TIPO-CONT         TO VGH02401-C-TIPO-CONT
     * MOVE FGH002-C-MOED-ISO-SCTA     TO VGH02401-C-MOED-ISO-SCTA
     * MOVE FGH002-NS-DEPOSITO         TO VGH02401-NS-DEPOSITO
     * MOVE FGH002-TS-MOVIMENTO        TO VGH02401-TS-MOVIMENTO
     * MOVE FGH002-NS-MOVIMENTO        TO VGH02401-NS-MOVIMENTO
     * MOVE FGH002-Z-VAL-MOV           TO VGH02401-Z-VAL-MOV
     * MOVE FGH002-Z-MOV-LOCL          TO VGH02401-Z-MOV-LOCL
     * MOVE FGH002-I-DBCR              TO VGH02401-I-DBCR
     * MOVE FGH002-M-MOVIMENTO         TO VGH02401-M-MOVIMENTO
     * MOVE FGH002-I-ESTORNO           TO VGH02401-I-ESTORNO
     * MOVE FGH002-C-MOED-ISO-ORI-MOV
     * TO VGH02401-C-MOED-ISO-ORI-MOV
     * MOVE FGH002-M-SLDO-CBLO-APOS    TO VGH02401-M-SLDO-CBLO-APOS
     * MOVE FGH002-M-SLDO-DPNL-APOS    TO VGH02401-M-SLDO-DPNL-APOS
     * MOVE FGH002-M-MOV-MOE-ORIG-MOV
     * TO VGH02401-M-MOV-MOE-ORIG-MOV
     * MOVE FGH002-X-REF-MOV           TO VGH02401-X-REF-MOV
     * MOVE FGH002-N-DOC-OPPS          TO VGH02401-N-DOC-OPPS
     * MOVE FGH002-A-APL-ORIG          TO VGH02401-A-APL-ORIG
     * MOVE FGH002-I-EXIS-INF-ADI      TO VGH02401-I-EXIS-INF-ADI
     * MOVE FGH002-X-CHAV-ACS-INF-ADI
     * TO VGH02401-X-CHAV-ACS-INF-ADI
     * MOVE FGH002-TS-ACTZ-ULT         TO VGH02401-TS-ACTZ-ULT
     * MOVE FGH002-C-USID-ACTZ-ULT     TO VGH02401-C-USID-ACTZ-ULT
     * EXEC SQL
     * INSERT INTO VGH02401_MOVHIST4
     * C_PAIS_ISOA_CONT     ,
     * C_BANC_CONT          ,
     * C_OE_EGC_CONT        ,
     * NS_RDCL_CONT         ,
     * V_CHKD_CONT          ,
     * C_TIPO_CONT          ,
     * C_MOED_ISO_SCTA      ,
     * NS_DEPOSITO          ,
     * TS_MOVIMENTO         ,
     * NS_MOVIMENTO         ,
     * Z_VAL_MOV            ,
     * Z_MOV_LOCL           ,
     * I_DBCR               ,
     * M_MOVIMENTO          ,
     * I_ESTORNO            ,
     * C_MOED_ISO_ORI_MOV   ,
     * M_SLDO_CBLO_APOS     ,
     * M_SLDO_DPNL_APOS     ,
     * M_MOV_MOE_ORIG_MOV   ,
     * X_REF_MOV            ,
     * N_DOC_OPPS           ,
     * A_APL_ORIG           ,
     * I_EXIS_INF_ADI       ,
     * X_CHAV_ACS_INF_ADI   ,
     * TS_ACTZ_ULT          ,
     * C_USID_ACTZ_ULT
     * VALUES
     * :VGH02401-C-PAIS-ISOA-CONT      ,
     * :VGH02401-C-BANC-CONT           ,
     * :VGH02401-C-OE-EGC-CONT         ,
     * :VGH02401-NS-RDCL-CONT          ,
     * :VGH02401-V-CHKD-CONT           ,
     * :VGH02401-C-TIPO-CONT           ,
     * :VGH02401-C-MOED-ISO-SCTA       ,
     * :VGH02401-NS-DEPOSITO           ,
     * :VGH02401-TS-MOVIMENTO          ,
     * :VGH02401-NS-MOVIMENTO          ,
     * :VGH02401-Z-VAL-MOV             ,
     * :VGH02401-Z-MOV-LOCL            ,
     * :VGH02401-I-DBCR                ,
     * :VGH02401-M-MOVIMENTO           ,
     * :VGH02401-I-ESTORNO             ,
     * :VGH02401-C-MOED-ISO-ORI-MOV    ,
     * :VGH02401-M-SLDO-CBLO-APOS      ,
     * :VGH02401-M-SLDO-DPNL-APOS      ,
     * :VGH02401-M-MOV-MOE-ORIG-MOV    ,
     * :VGH02401-X-REF-MOV             ,
     * :VGH02401-N-DOC-OPPS            ,
     * :VGH02401-A-APL-ORIG            ,
     * :VGH02401-I-EXIS-INF-ADI        ,
     * :VGH02401-X-CHAV-ACS-INF-ADI    ,
     * :VGH02401-TS-ACTZ-ULT           ,
     * :VGH02401-C-USID-ACTZ-ULT
     * END-EXEC
     * EVALUATE TRUE
     * WHEN SQLCODE = 0
     * ADD +1               TO CONT-REG-INS-VGH02401
     * WHEN OTHER
     * MOVE +16              TO RETURN-CODE
     * PROG-STATUS
     * MOVE 'PGHQZ29A - VGH02401 - INSERT  - '
     * TO MSG-STATUS
     * MOVE SQLCODE          TO W-SQLCODE
     * MOVE W-SQLCODE        TO IMP-STATUS
     * DISPLAY 'W-SQLCODE -' W-SQLCODE
     * END-EVALUATE
     * 
     */
    protected void a31000TratarContiphst() {
        log(TraceLevel.Debug, "A31000-TRATAR-CONTIPHST");
        wTimestamp().set(bghr0021().rgh00201().fgh002TsMovimento());
        verContaHst.setTrue() ;
        if (swContaIgual.isTrue()) {
            if (wTimestamp().wDataTimestamp().wAnoAa().isLessOrEqual(wsZaFimAnt)) {
                naoVerContaHst.setTrue() ;
            }
        }
        if (verContaHst.isTrue()) {
            if (progOk.isTrue()) {
                a31300ActRegContiphst() ;
            }
            if (progNaoExiste.isTrue()) {
                progOk.setTrue() ;
                if (progOk.isTrue()) {
                    a31400InsRegContiphst() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300ActRegContiphst() {
        log(TraceLevel.Debug, "A31300-ACT-REG-CONTIPHST");
        wsVgh01001().wsVgh01001CPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        wsVgh01001().wsVgh01001CBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        wsVgh01001().wsVgh01001COeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        wsVgh01001().wsVgh01001NsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        wsVgh01001().wsVgh01001VChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        wsVgh01001().wsVgh01001CTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        wsVgh01001().wsVgh01001CMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        wsVgh01001().wsVgh01001NsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        wsVgh01001().wsVgh01001NmRecurso().set("GHSA1994");
        wTimestamp().set(bghr0021().rgh00201().fgh002TsMovimento());
        wsVgh01001().wsVgh01001ZaFim().set(wTimestamp().wDataTimestamp().wAnoAa());
        wsVgh01001().wsVgh01001CUsidActzUlt().set(bghw0300().wsNmPrograma());
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().updatePghqz29a899(wsVgh01001().wsVgh01001CPaisIsoaCont(), wsVgh01001().wsVgh01001CBancCont(), wsVgh01001().wsVgh01001COeEgcCont(), wsVgh01001().wsVgh01001NsRdclCont(), wsVgh01001().wsVgh01001VChkdCont(), wsVgh01001().wsVgh01001CTipoCont(), wsVgh01001().wsVgh01001CMoedIsoScta(), wsVgh01001().wsVgh01001NsDeposito(), wsVgh01001().wsVgh01001NmRecurso(), wsVgh01001().wsVgh01001ZaFim(), wsVgh01001().wsVgh01001CUsidActzUlt()) ;
        wSqlcode.set(hv01001Contiphst().getPersistenceCode());
        switch (hv01001Contiphst().getPersistenceCode()) {
            case NORMAL:
                contRegInsVgh01001.add(1);
                wsZaFimAnt.set(wsVgh01001().wsVgh01001ZaFim());
                break;
            case NOTFND:
                progNaoExiste.setTrue() ;
                break;
            default :
                wSqlcode.set(getPersistenceCode());
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - UPD C1 - VGH01001 - ");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
                break;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400InsRegContiphst() {
        log(TraceLevel.Debug, "A31400-INS-REG-CONTIPHST");
        wSqlcode.initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set("GHSA1994");
        hv01001Contiphst().contiphst().cTipoInfHist().set(wsCTipoInfHist);
        wTimestamp().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv01001Contiphst().contiphst().zaInicio().set(wTimestamp().wDataTimestamp().wAnoAa());
        hv01001Contiphst().contiphst().zaFim().set(wTimestamp().wDataTimestamp().wAnoAa());
        hv01001Contiphst().contiphst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().insertPghqz29a964() ;
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh01001.add(1);
            wsZaFimAnt.set(hv01001Contiphst().contiphst().zaFim());
        } else {
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ29A - INSERT- VGH01001 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "SQLCODE-", wSqlcode);
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
            fwk900().fwk900RegPghqz29a().initialize() ;
            fwk900().fwk900RegPghqz29a().fwk900NCommit().set(add(fwk900().fwk900RegPghqz29a().fwk900NCommit(), contRegCommit));
            fwk900().rewrite(fwk900().fwk900RegPghqz29a()) ;
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
    public interface WsNContaAntMask extends IDataMask {
        
        @Data(size=4)
        IInt wsCOeContAnt() ;
        
        @Data(size=7)
        IInt wsNsRdclContAnt() ;
        
        @Data(size=1)
        IInt wsVChkdContAnt() ;
        
        @Data(size=3)
        IInt wsCTipoContAnt() ;
        
    }
    public interface ChaveFgh002 extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaContFgh002() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancContFgh002() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcContFgh002() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclContFgh002() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdContFgh002() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoContFgh002() ;
        
        @Data(size=3)
        IString cMoedIsoSctaFgh002() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDepositoFgh002() ;
        
    }
    public interface WsNContaMask extends IDataMask {
        
        @Data(size=4)
        IInt wsCOeCont() ;
        
        @Data(size=7)
        IInt wsNsRdclCont() ;
        
        @Data(size=1)
        IInt wsVChkdCont() ;
        
        @Data(size=3)
        IInt wsCTipoCont() ;
        
    }
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
    public interface WsVgh01001 extends IDataStruct {
        
        @Data(size=3)
        IString wsVgh01001CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsVgh01001CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsVgh01001COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsVgh01001NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVgh01001VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsVgh01001CTipoCont() ;
        
        @Data(size=3)
        IString wsVgh01001CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsVgh01001NsDeposito() ;
        
        @Data(size=8)
        IString wsVgh01001NmRecurso() ;
        
        @Data(size=1)
        IString wsVgh01001CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsVgh01001ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsVgh01001ZaFim() ;
        
        @Data(size=26)
        IString wsVgh01001TsActzUlt() ;
        
        @Data(size=8)
        IString wsVgh01001CUsidActzUlt() ;
        
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
            
            @Data(size=8, value="PGHQZ29A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQZ29A")
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
            
            @Data(size=32, value="NUMERO DE REGISTOS ESCRITOS EM ")
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
