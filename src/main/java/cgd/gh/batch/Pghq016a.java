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
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : ELIMINACAO DOS REGISTOS NA TABELA ANTERIORES A
 * DATA DO DIA:
 * - TGH00016_OEATRDPED
 * FICHEIROS     : FWK016- FICHEIROS DE BACKUP DOS REGISTOS
 * ELIMINADOS DA TABELA
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq016a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01601Oeatrdped
     */
    @Data
    protected abstract Vwsdghps01601Oeatrdped hv01601Oeatrdped() ;
    
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    
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
     * @return instancia da classe Fwk016
     */
    @Handler(name="FWK016", record="fwk016Reg51")
    @Data
    protected abstract Fwk016 fwk016() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghq016a")
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
    
    @Data(size=10, value=" ")
    protected IString wsDataCorrente ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegSelVgh01601 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegDelVgh01601 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk016 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ016A");
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
        wsDataCorrente.set(wTimestamp().wDataTimestamp());
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
            a16000AbrirFwk016() ;
        }
        if (progOk.isTrue()) {
            a33100OpenCursorC1() ;
        }
        if (progOk.isTrue()) {
            a33200FetchCursorC1() ;
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
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk900().getStatus());
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
            auxContRegLidos.set(fwk900().fwk900RegPghq016a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq016a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - READ - ");
            tabelaImpressao().linha11().impStatus().set(fwk900().getStatus());
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
            fwk900().fwk900RegPghq016a().initialize() ;
            fwk900().fwk900RegPghq016a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghq016a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - WRITE- ");
                tabelaImpressao().linha11().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - OPEN- ");
            tabelaImpressao().linha11().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirFwk016() {
        log(TraceLevel.Debug, "A16000-ABRIR-FWK016");
        fwk016().open(CREATE ) ;
        if (!fwk016().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK016 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk016().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (progOk.isTrue()) {
            a32000EscreveFwk016() ;
        }
        if (progOk.isTrue()) {
            a31000DelTgh016() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a33200FetchCursorC1() ;
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
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            tabelaImpressao().linha09().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impRegLidosInput1().set(contRegSelVgh01601);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(6); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha07().impFichEsc().set("FWK016");
            tabelaImpressao().linha07().impRegEscrt().set(contRegEscrtFwk016);
            tabelaImpressaoMask().zimp().setIndex(7) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha08().impFichDel().set("TGH00016");
            tabelaImpressao().linha08().impRegDel().set(contRegDelVgh01601);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
            /**
             * EXEC SQL
             * ROLLBACK
             * END-EXEC
             */
            if (progOk.isTrue()) {
                commit() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha09().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha09().impReturnCode().set(returnCode);
            tabelaImpressao().linha10().impMens1().set("PGHQ016A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(9); tabelaImpressaoMask().zimp().index().isLessOrEqual(11); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a33400CloseCursorC1() ;
        }
        fgh300().close() ;
        fwk016().close() ;
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
    protected void a31000DelTgh016() {
        log(TraceLevel.Debug, "A31000-DEL-TGH016");
        /**
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH01601_OEATRDPED
         */
        hv01601Oeatrdped().deletePghq016a591() ;
        if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegDelVgh01601.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - VGH01601 - DELETE  - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha11().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreveFwk016() {
        log(TraceLevel.Debug, "A32000-ESCREVE-FWK016");
        fwk016().fwk016Reg51.initialize() ;
        fwk016().setRecord(hv01601Oeatrdped().oeatrdped()) ;
        fwk016().write(fwk016().fwk016Reg51) ;
        if (fwk016().getStatusOk()) {
            contRegEscrtFwk016.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK016 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk016().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33100OpenCursorC1() {
        log(TraceLevel.Debug, "A33100-OPEN-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01601Oeatrdped().openPghq016a645(wsDataCorrente) ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha11().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33200FetchCursorC1() {
        log(TraceLevel.Debug, "A33200-FETCH-CURSOR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv01601Oeatrdped().fetchPghq016a672() ;
        wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
        if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FETCH C1- VGH01601 - ");
            tabelaImpressao().linha11().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33400CloseCursorC1() {
        log(TraceLevel.Debug, "A33400-CLOSE-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv01601Oeatrdped().closePghq016a707() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NOTFND) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha11().impStatus().set(wSqlcode);
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
                tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - READ - ");
                tabelaImpressao().linha11().impStatus().set(wSqlcode);
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghq016a().initialize() ;
            fwk900().fwk900RegPghq016a().fwk900NCommit().set(contRegCommit);
            fwk900().rewrite(fwk900().fwk900RegPghq016a()) ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha11().msgStatus().set("PGHQ016A - FWK900 - REWRITE -");
                tabelaImpressao().linha11().impStatus().set(wSqlcode);
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
            while (progOk.isTrue() && !progNaoExiste.isTrue()) {
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
        
        @Data(size=121, value=" ")
        IString linha06() ;
        
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
        
        /**
         * @return instancia da classe local Linha12
         */
        @Data
        Linha12 linha12() ;
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ016A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ016A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=8, value="TGH00016")
            IString filler003() ;
            
            @Data(size=5, value=" ")
            IString filler004() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosInput1() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ESCRITOS  ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ELIMINADOS ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichDel() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegDel() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha11 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha12 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=11, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
