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
import cgd.hy.structures.link.Bhyl230a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * -------------->     HISTORICO ACTIVO   <----------------
 * OBJECTIVOS    :-SEPARA FICHEIRO FWK215 CRIADO NO PGHQ200A POR
 * CODIGO DO PEDIDO
 * -CRIA OS FICHEIROS:
 * . FWK094 - PEDIDO GH0094-2AS. VIAS
 * . FWK095 - PEDIDO GH0095-DCR
 * . FWK096 - PEDIDO GH0096-DBI E GH0097-HO
 * . FWK098 - PEDIDO GH0098-TSU/DBI
 * . FWK100 - OUTROS PEDIDOS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc201a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk215
     */
    @Handler(name="FWK215", record="regFwk215Pghc201a")
    @Data
    protected abstract Fwk215 fwk215() ;
    
    /**
     * @return instancia da classe Fwk096
     */
    @Handler(name="FWK096", record="regFwk096272")
    @Data
    protected abstract Fwk096 fwk096() ;
    
    /**
     * @return instancia da classe Fwk095
     */
    @Handler(name="FWK095", record="regFwk095272")
    @Data
    protected abstract Fwk095 fwk095() ;
    
    /**
     * @return instancia da classe Fwk098
     */
    @Handler(name="FWK098", record="regFwk098272")
    @Data
    protected abstract Fwk098 fwk098() ;
    
    /**
     * @return instancia da classe Fwk094
     */
    @Handler(name="FWK094", record="regFwk094272")
    @Data
    protected abstract Fwk094 fwk094() ;
    
    /**
     * @return instancia da classe Fwk100
     */
    @Handler(name="FWK100", record="regFwk100272")
    @Data
    protected abstract Fwk100 fwk100() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
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
    protected IString wsCrtlMais ;
    @Data
    @Condition("S")
    protected ICondition haMais ;
    @Data
    @Condition("N")
    protected ICondition naoHaMais ;
    
    
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
     * @return instancia da classe local WsDataInic
     */
    @Data
    protected abstract WsDataInic wsDataInic() ;
    
    /**
     * @return instancia da classe local WsDataFim
     */
    @Data
    protected abstract WsDataFim wsDataFim() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk215 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk094 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk095 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk096 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk098 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk100 ;
    
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
        bghw0300().wsNmPrograma().set("PGHC201A");
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
            a13000AbrirFicheiros() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk215() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk215() ;
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
    protected void a13000AbrirFicheiros() {
        log(TraceLevel.Debug, "A13000-ABRIR-FICHEIROS");
        fwk096().open(CREATE ) ;
        if (!fwk096().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK096 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk096().getStatus());
        }
        if (progOk.isTrue()) {
            fwk095().open(CREATE ) ;
            if (!fwk095().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK095 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk095().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk098().open(CREATE ) ;
            if (!fwk098().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK098 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk098().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk094().open(CREATE ) ;
            if (!fwk094().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK094 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk094().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk100().open(CREATE ) ;
            if (!fwk100().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK100 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk100().getStatus());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk215() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK215");
        fwk215().open() ;
        if (!fwk215().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK215 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk215().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk215() {
        log(TraceLevel.Debug, "A15000-LER-FWK215");
        fwk215().read() ;
        if (fwk215().getStatusOk()) {
            contRegLidosFwk215.add(1);
        }
        if (!fwk215().getStatusOk() && !fwk215().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK215 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk215().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        switch (fwk215().regFwk215Pghc201a().fwk215CPedInfOpps().get()) {
            case "GH00094":
                a31000EscreverFwk094() ;
                break;
            case "GH00095":
                a32000EscreverFwk095() ;
                break;
            case "GH00096":
                a33000EscreverFwk096() ;
                break;
            case "GH00097":
                a33000EscreverFwk096() ;
                break;
            case "GH00098":
                a34000EscreverFwk098() ;
                break;
            default :
                a35000EscreverFwk100() ;
                break;
        }
        if (progOk.isTrue()) {
            a15000LerFwk215() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000EscreverFwk094() {
        log(TraceLevel.Debug, "A31000-ESCREVER-FWK094");
        fwk094().regFwk094272.initialize() ;
        /**
         * MOVE REG-FGH015          TO REG-FWK094
         */
        fwk094().setRecord(fwk215().getRecord()) ;
        fwk094().write(fwk094().regFwk094272) ;
        if (fwk094().getStatusOk()) {
            contRegEscrtFwk094.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK094 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk094().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreverFwk095() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FWK095");
        fwk095().regFwk095272.initialize() ;
        /**
         * MOVE REG-FGH015          TO REG-FWK095
         */
        fwk095().setRecord(fwk215().getRecord()) ;
        fwk095().write(fwk095().regFwk095272) ;
        if (fwk095().getStatusOk()) {
            contRegEscrtFwk095.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK095 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk095().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000EscreverFwk096() {
        log(TraceLevel.Debug, "A33000-ESCREVER-FWK096");
        fwk096().regFwk096272.initialize() ;
        /**
         * MOVE REG-FGH015          TO REG-FWK096
         */
        fwk096().setRecord(fwk215().getRecord()) ;
        fwk096().write(fwk096().regFwk096272) ;
        if (fwk096().getStatusOk()) {
            contRegEscrtFwk096.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK096 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk096().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreverFwk098() {
        log(TraceLevel.Debug, "A34000-ESCREVER-FWK098");
        fwk098().regFwk098272.initialize() ;
        /**
         * MOVE REG-FGH015          TO REG-FWK098
         */
        fwk098().setRecord(fwk215().getRecord()) ;
        fwk098().write(fwk098().regFwk098272) ;
        if (fwk098().getStatusOk()) {
            contRegEscrtFwk098.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK098 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk098().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35000EscreverFwk100() {
        log(TraceLevel.Debug, "A35000-ESCREVER-FWK100");
        fwk100().regFwk100272.initialize() ;
        /**
         * MOVE REG-FGH015          TO REG-FWK100
         */
        fwk100().setRecord(fwk215().getRecord()) ;
        fwk100().write(fwk100().regFwk100272) ;
        if (fwk100().getStatusOk()) {
            contRegEscrtFwk100.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK100 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk100().getStatus());
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
            tabelaImpressao().linha05().impFichRead().set("FWK215");
            tabelaImpressao().linha05().impRegLidosFwk215().set(contRegLidosFwk215);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FWK094");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk094);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK095");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk095);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK096");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk096);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK098");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk098);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FWK100");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk100);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHC201A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk215().close() ;
        fwk094().close() ;
        fwk095().close() ;
        fwk096().close() ;
        fwk098().close() ;
        fwk100().close() ;
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
            while (!fwk215().getStatusOk() && progOk.isTrue()) {
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
    public interface WsDataInic extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoInic() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesInic() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaInic() ;
        
    }
    public interface WsDataFim extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaFim() ;
        
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
         * @return instancia da classe local Linha0602
         */
        @Data
        Linha0602 linha0602() ;
        
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
            
            @Data(size=8, value="PGHC201A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC201A")
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
            
            @Data(size=8, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosFwk215() ;
            
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
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha0602 extends IDataStruct {
            
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
