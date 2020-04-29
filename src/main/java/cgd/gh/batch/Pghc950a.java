package cgd.gh.batch;

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
import cgd.gh.structures.work.Bghf0832 ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    - FILTRA O UNLOAD DAS TABELAS DE GH PARA OBTER
 * UM FICHEIRO COM AS TRANSFERENCIAS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc950a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk00104
     */
    @Handler(name="FWK001", record="regFwk001243")
    @Data
    protected abstract Fwk00104 fwk001() ;
    
    /**
     * @return instancia da classe Fgh832
     */
    @Handler(name="FGH832", record="regFgh832294")
    @Data
    protected abstract Fgh832 fgh832() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghf0832
     */
    @Data
    protected abstract Bghf0832 bghf0832() ;
    
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
    
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    @Data(size=6, value="MGH874")
    protected IString wsMapa ;
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=8, value="MGHK800A")
    protected IString wsDescritivos ;
    
    @Data(size=2)
    protected IString statusFwk501 ;
    @Data
    @Condition("00")
    protected ICondition fwk501StatusOk ;
    @Data
    @Condition("10")
    protected ICondition fwk501StatusEof ;
    
    
    @Data(size=2)
    protected IString statusFwk601 ;
    @Data
    @Condition("00")
    protected ICondition fwk601StatusOk ;
    @Data
    @Condition("10")
    protected ICondition fwk601StatusEof ;
    
    
    @Data(size=2)
    protected IString statusFwk701 ;
    @Data
    @Condition("00")
    protected ICondition fwk701StatusOk ;
    @Data
    @Condition("10")
    protected ICondition fwk701StatusEof ;
    
    
    /**
     * @return instancia da classe local WTsInicio
     */
    @Data
    protected abstract WTsInicio wTsInicio() ;
    
    /**
     * @return instancia da classe local WTsFim
     */
    @Data
    protected abstract WTsFim wTsFim() ;
    
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
     * AREAS DE LIGACAO
     * CONTADORES
     * @return instancia da classe local WsContadores
     */
    @Data
    protected abstract WsContadores wsContadores() ;
    
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
        bghw0300().wsNmPrograma().set("PGHC950A");
        wsContadores().initialize() ;
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
        a11000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk001() ;
        }
        if (progOk.isTrue()) {
            a15000AbrirFgh832() ;
        }
        if (progOk.isTrue()) {
            a16000LerFwk001() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a11000AbrirFgh300() {
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
    protected void a14000AbrirFwk001() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK001");
        fwk001().open() ;
        if (!fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC950A - FWK001 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000AbrirFgh832() {
        log(TraceLevel.Debug, "A15000-ABRIR-FGH832");
        fgh832().open(CREATE ) ;
        if (!fgh832().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC950A - FGH832 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh832().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFwk001() {
        log(TraceLevel.Debug, "A16000-LER-FWK001");
        fwk001().read() ;
        if (fwk001().getStatusOk()) {
            wsContadores().wsContadorLidos().add(1);
            bghf0832().registo().set((String)fwk001().getRecord()) ;
        }
        if (!fwk001().getStatusOk() && !fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC950A - FWK001 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarPedido() ;
        if (progOk.isTrue()) {
            a16000LerFwk001() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarPedido() {
        log(TraceLevel.Debug, "A31000-TRATAR-PEDIDO");
        switch (bghf0832().registo().aAplicacao().get()) {
            case "AU":
                if (bghf0832().registo().cEvenOpel().isEmpty() && 
                    (bghf0832().registo().cOpeBbn().isEqual("HVB40") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVB41"))) {
                    a31500EscreverFgh832() ;
                } else {
                    wsContadores().wsContadorExcluidos().add(1);
                }
                break;
            case "HV":
                if (bghf0832().registo().cEvenOpel().isEqual("HVA4") && 
                    bghf0832().registo().cOpeBbn().isEqual("TVA41")) {
                    /**
                     * (BGHF0832-C-OPE-BBN   = 'TVA41'   OR
                     * BGHF0832-C-OPE-BBN   = 'HVA17')
                     */
                    a31500EscreverFgh832() ;
                } else if (bghf0832().registo().cEvenOpel().isEqual("HVA5") && 
                    (bghf0832().registo().cOpeBbn().isEqual("HVG65") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVG66"))) {
                    a31500EscreverFgh832() ;
                } else if (bghf0832().registo().cEvenOpel().isEqual("HVB3") && 
                    (bghf0832().registo().cOpeBbn().isEqual("HVB62") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVB76") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVB77"))) {
                    a31500EscreverFgh832() ;
                } else if (bghf0832().registo().cEvenOpel().isEqual("HVC7") && 
                    (bghf0832().registo().cOpeBbn().isEqual("HVB63") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVB78"))) {
                    a31500EscreverFgh832() ;
                } else if (bghf0832().registo().cEvenOpel().isEqual("HVD6") && 
                    (bghf0832().registo().cOpeBbn().isEqual("HVB66") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVB81"))) {
                    a31500EscreverFgh832() ;
                } else if (bghf0832().registo().cEvenOpel().isEqual("HVA4") && 
                    (bghf0832().registo().cOpeBbn().isEqual("HVG50") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVG51"))) {
                    a31500EscreverFgh832() ;
                } else if (bghf0832().registo().cEvenOpel().isEqual("HVK8") && 
                    (bghf0832().registo().cOpeBbn().isEqual("HVA74") || 
                    bghf0832().registo().cOpeBbn().isEqual("HVA84"))) {
                    a31500EscreverFgh832() ;
                } else {
                    wsContadores().wsContadorExcluidos().add(1);
                }
                break;
            default :
                wsContadores().wsContadorExcluidos().add(1);
                break;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31500EscreverFgh832() {
        log(TraceLevel.Debug, "A31500-ESCREVER-FGH832");
        fgh832().regFgh832294.initialize() ;
        fgh832().setRecord(bghf0832().registo()) ;
        fgh832().write(fgh832().regFgh832294) ;
        if (fgh832().getStatusOk()) {
            wsContadores().wsContadorEscritos().add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC950A - FGH832 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fgh832().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
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
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha05().impRegLidosFwk001().set(wsContadores().wsContadorLidos());
            tabelaImpressaoMask().zimp().setIndex(5) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FGH832");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContadorEscritos());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha08().impMens1().set("REGISTOS EXCLUIDOS");
            tabelaImpressao().linha08().impReg1().set(wsContadores().wsContadorExcluidos());
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC950A - FIM ANORMAL ");
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
    @Override
    protected void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!fwk001().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WTsInicio extends IDataStruct {
        
        @Data(size=10)
        IString wsDataInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
        IInt wsHoraInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsMinInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsSecInicio() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestInicio() ;
        
    }
    public interface WTsFim extends IDataStruct {
        
        @Data(size=10)
        IString wsDataFim() ;
        
        @Data(size=2, value="23", lpadding=1, lpaddingValue="-")
        IInt wsHoraFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsMinFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsSecFim() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestFim() ;
        
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
    
    /**
     * 
     * AREAS DE LIGACAO
     * CONTADORES
     * 
     * @version 2.0
     * 
     */
    public interface WsContadores extends IDataStruct {
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorLidos() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorEscritos() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContadorExcluidos() ;
        
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
            
            @Data(size=8, value="PGHC950A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC950A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK001")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk001() ;
            
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
            
            @Data(size=20, value=" ", lpadding=16, lpaddingValue=" ")
            IString impMens1() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=23, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impReg1() ;
            
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
