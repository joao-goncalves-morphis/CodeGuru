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
import cgd.gh.structures.work.Bghw9999 ;


/**
 * 
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1. CORRECCAO DA REFERENCIA DE MOVIMENTO QUE
 * TENHAM LOW-VALUES - TABELA TGH0002
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq999a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw9999
     */
    @Data
    protected abstract Bghw9999 bghw9999() ;
    
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
    
    
    @Data(size=21)
    protected IString wsXRefMov ;
    
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
     * @return instancia da classe local DataNumMask
     */
    @Data
    @Mask
    protected abstract DataNumMask dataNumMask() ;
    
    @Data(size=26)
    protected IString wsTsMovFim ;
    
    @Data(size=26)
    protected IString wsTsMovInicio ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * @return instancia da classe local WsTsInicio
     */
    @Data
    protected abstract WsTsInicio wsTsInicio() ;
    
    /**
     * @return instancia da classe local WsTsFim
     */
    @Data
    protected abstract WsTsFim wsTsFim() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosTab ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegSelectTgh02 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegUpdateTgh02 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ999A");
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
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        contRegLidosTab.add(1);
        a31100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue()) {
                a31300TratarReferencia() ;
            }
        }
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a31400CloseCursorC1() ;
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
            tabelaImpressao().linha08().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichTb().set("FBV423");
            tabelaImpressao().linha05().impRegTb().set(contRegLidosTab);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichSel().set("TGH002");
            tabelaImpressao().linha06().impRegSel().set(contRegSelectTgh02);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha07().impFichAlt().set("TGH002");
            tabelaImpressao().linha07().impRegAlt().set(contRegUpdateTgh02);
            tabelaImpressaoMask().zimp().setIndex(7) ;
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha08().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha08().impReturnCode().set(returnCode);
            tabelaImpressao().linha09().impMens1().set("PGHQ999A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
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
    protected void a31100OpenCursorC1() {
        log(TraceLevel.Debug, "A31100-OPEN-CURSOR-C1");
        wSqlcode.initialize() ;
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set("PT");
        hv00201Movhst().movhst().cBancCont().set(35);
        hv00201Movhst().movhst().cOeEgcCont().set(bghw9999().tbEndcBv().itemBv().getCurrent().tabNConta().tabCOeEgc());
        hv00201Movhst().movhst().nsRdclCont().set(bghw9999().tbEndcBv().itemBv().getCurrent().tabNConta().tabNsRdcl());
        hv00201Movhst().movhst().vChkdCont().set(bghw9999().tbEndcBv().itemBv().getCurrent().tabNConta().tabVChkd());
        hv00201Movhst().movhst().cTipoCont().set(bghw9999().tbEndcBv().itemBv().getCurrent().tabNConta().tabCTipo());
        hv00201Movhst().movhst().cMoedIsoScta().set("EUR");
        hv00201Movhst().movhst().nsDeposito().set(0);
        dataNum.set(bghw9999().tbEndcBv().itemBv().getCurrent().tabZMovimento());
        wsTsInicio().wsDataInicio().wAnoAaIni().set(dataNumMask().anoNum());
        wsTsFim().wsDataFim().wAnoAaFim().set(dataNumMask().anoNum());
        wsTsInicio().wsDataInicio().wMesMmIni().set(dataNumMask().mesNum());
        wsTsFim().wsDataFim().wMesMmFim().set(dataNumMask().mesNum());
        wsTsInicio().wsDataInicio().wDiaDdIni().set(dataNumMask().diaNum());
        wsTsFim().wsDataFim().wDiaDdFim().set(dataNumMask().diaNum());
        wsTsMovInicio.set(wsTsInicio());
        wsTsMovFim.set(wsTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00201Movhst().openPghq999a496(wsTsMovFim, wsTsMovInicio) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ999A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
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
        hv00201Movhst().fetchPghq999a525() ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ999A - FETCH C1- VGH00201 - ");
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300TratarReferencia() {
        log(TraceLevel.Debug, "A31300-TRATAR-REFERENCIA");
        a31310AlterarRef() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31310AlterarRef() {
        log(TraceLevel.Debug, "A31310-ALTERAR-REF");
        wsXRefMov.set("PAGAMENTO");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq999a584(wsXRefMov) ;
        wSqlcode.set(hv00201Movhst().getPersistenceCode());
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ999A - UPDATE  - VGH00201 - ");
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400CloseCursorC1() {
        log(TraceLevel.Debug, "A31400-CLOSE-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv00201Movhst().closePghq999a626() ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHQ999A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha10().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        /**
         * *-----------------------------------------------------------------
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            for (bghw9999().tbEndcBv().itemBv().setIndex(1); bghw9999().tbEndcBv().itemBv().index().isLessOrEqual(331) && progOk.isTrue(); bghw9999().tbEndcBv().itemBv().incIndex()) {
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
    public interface DataNumMask extends IDataMask {
        
        @Data(size=4)
        IInt anoNum() ;
        
        @Data(size=2)
        IInt mesNum() ;
        
        @Data(size=2)
        IInt diaNum() ;
        
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
    public interface WsTsInicio extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataInicio
         */
        @Data
        WsDataInicio wsDataInicio() ;
        
        /**
         * @return instancia da classe local WTimerInicio
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerInicio wTimerInicio() ;
        
        
        public interface WsDataInicio extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAaIni() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMmIni() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDdIni() ;
            
        }
        
        public interface WTimerInicio extends IDataStruct {
            
            @Data(size=2, value="0")
            IInt wHhIni() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wMmIni() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wSsIni() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wDdIni() ;
            
        }
    }
    public interface WsTsFim extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataFim
         */
        @Data
        WsDataFim wsDataFim() ;
        
        /**
         * @return instancia da classe local WTimerFim
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerFim wTimerFim() ;
        
        
        public interface WsDataFim extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAaFim() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMmFim() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDdFim() ;
            
        }
        
        public interface WTimerFim extends IDataStruct {
            
            @Data(size=2, value="23")
            IInt wHhFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wMmFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wSsFim() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wDdFim() ;
            
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
            
            @Data(size=8, value="PGHQ999A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ999A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS TB INTERNA")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichTb() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegTb() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS     ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichSel() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegSel() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ALTERADOS ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichAlt() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegAlt() ;
            
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
        
        @Data(length=9, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
