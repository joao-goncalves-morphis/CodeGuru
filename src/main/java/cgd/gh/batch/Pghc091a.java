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
import cgd.gh.structures.work.Bghw0001 ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    - CORRECCAO DE MOVIMENTOS FORA DE ORDEM
 * NA APLICACOES ORIGENS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc091a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fgh003
     */
    @Handler(name="FGH003", record="rgh00301")
    @Data
    protected abstract Fgh003 fgh003() ;
    
    /**
     * @return instancia da classe Sysin
     */
    @Handler(name="SYSIN", record="regFwk091Pghc091a")
    @Data
    protected abstract Sysin fwk091() ;
    
    /**
     * @return instancia da classe Fwk30102
     */
    @Handler(name="FWK301", record="rwk30101Pghc091a")
    @Data
    protected abstract Fwk30102 fwk301() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0001
     */
    @Data
    protected abstract Bghw0001 bghw0001() ;
    
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
    
    
    @Data(size=1, value=" ")
    protected IString wsCrlAlteracao ;
    @Data
    @Condition("1")
    protected ICondition haAlteracao ;
    @Data
    @Condition("2")
    protected ICondition naoHaAlteracao ;
    
    
    @Data(size=8, value="CONVHO")
    protected IString wsCUseridHo ;
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    /**
     * @return instancia da classe local WsRegFwk091
     */
    @Data
    protected abstract WsRegFwk091 wsRegFwk091() ;
    
    /**
     * @return instancia da classe local WsChaveFwk091
     */
    @Data
    protected abstract WsChaveFwk091 wsChaveFwk091() ;
    
    /**
     * @return instancia da classe local WsChaveFgh003
     */
    @Data
    protected abstract WsChaveFgh003 wsChaveFgh003() ;
    
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
        bghw0300().wsNmPrograma().set("PGHC091A");
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
            a14000AbrirFicheiros() ;
        }
        if (progOk.isTrue()) {
            a16000LerFgh003() ;
        }
        if (progOk.isTrue()) {
            a17000LerFwk091() ;
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
    protected void a14000AbrirFicheiros() {
        log(TraceLevel.Debug, "A14000-ABRIR-FGH003");
        fwk091().open() ;
        if (!fwk091().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC091A - FWK091 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk091().getStatus());
        }
        fgh003().open() ;
        if (!fgh003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC091A - FGH003 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fgh003().getStatus());
        }
        fwk301().open(CREATE ) ;
        if (!fwk301().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC091A - FWK301 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk301().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFgh003() {
        log(TraceLevel.Debug, "A16000-LER-FGH003");
        fgh003().read() ;
        if (fgh003().getStatusOk()) {
            wsContadores().wsContLidosFgh003().add(1);
            wsChaveFgh003().waCPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
            wsChaveFgh003().waCBancCont().set(fgh003().rgh00301().fgh003CBancCont());
            wsChaveFgh003().waCOeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
            wsChaveFgh003().waNsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
            wsChaveFgh003().waVChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
            wsChaveFgh003().waCTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
            wsChaveFgh003().waCMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
            wsChaveFgh003().waNsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
            wsChaveFgh003().waZMovimento().set(fgh003().rgh00301().fgh003TsMovimento().get(1, 10));
            wsChaveFgh003().waNsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        }
        if (!fgh003().getStatusOk() && !fgh003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC091A - FGH003 - READ - ");
            tabelaImpressao().linha10().impStatus().set(fgh003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerFwk091() {
        log(TraceLevel.Debug, "A17000-LER-FWK091");
        fwk091().read(wsRegFwk091()) ;
        if (fwk091().getStatusOk()) {
            wsContadores().wsContLidosFwk091().add(1);
            wsChaveFwk091().wsCPaisIsoaCont().set(wsRegFwk091().wsFwk091CPaisIsoaCont());
            wsChaveFwk091().wsCBancCont().set(wsRegFwk091().wsFwk091CBancCont());
            wsChaveFwk091().wsCOeEgcCont().set(wsRegFwk091().wsFwk091COeEgcCont());
            wsChaveFwk091().wsNsRdclCont().set(wsRegFwk091().wsFwk091NsRdclCont());
            wsChaveFwk091().wsVChkdCont().set(wsRegFwk091().wsFwk091VChkdCont());
            wsChaveFwk091().wsCTipoCont().set(wsRegFwk091().wsFwk091CTipoCont());
            wsChaveFwk091().wsCMoedIsoScta().set(wsRegFwk091().wsFwk091CMoedIsoScta());
            wsChaveFwk091().wsNsDeposito().set(wsRegFwk091().wsFwk091NsDeposito());
            wsChaveFwk091().wsZMovimento().set(wsRegFwk091().wsFwk091ZMovimento());
            wsChaveFwk091().wsNsMovimento().set(wsRegFwk091().wsFwk091NsMovimento());
        }
        if (!fwk091().getStatusOk() && !fwk091().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC091A - FWK091 - READ - ");
            tabelaImpressao().linha10().impStatus().set(fwk091().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        if (!fwk091().getStatusOk()) {
            if (wsChaveFwk091().isLess(wsChaveFgh003())) {
                if (progOk.isTrue()) {
                    a17000LerFwk091() ;
                }
            } else if (wsChaveFwk091().isEqual(wsChaveFgh003())) {
                haAlteracao.setTrue() ;
                a32000EscreverFwk301() ;
                if (progOk.isTrue()) {
                    a16000LerFgh003() ;
                }
                if (progOk.isTrue()) {
                    a17000LerFwk091() ;
                }
            } else if (wsChaveFwk091().isGreater(wsChaveFgh003())) {
                naoHaAlteracao.setTrue() ;
                a32000EscreverFwk301() ;
                if (progOk.isTrue()) {
                    a16000LerFgh003() ;
                }
            }
        } else {
            naoHaAlteracao.setTrue() ;
            a32000EscreverFwk301() ;
            if (progOk.isTrue()) {
                a16000LerFgh003() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreverFwk301() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FWK301");
        fwk301().setRecord(fgh003().getRecord()) ;
        if (haAlteracao.isTrue()) {
            fwk301().rwk30101Pghc091a().fwk301NsMovimento().set(fwk091().regFwk091Pghc091a().fwk091NsMovNovo());
        }
        fwk301().write(fwk301().rwk30101Pghc091a()) ;
        if (fwk301().getStatusOk()) {
            wsContadores().wsContEscritosFwk301().add(1);
            naoHaAlteracao.setTrue() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC091A - FWK301 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk301().getStatus());
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
            tabelaImpressao().linha08().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha05().impRegLidosFgh003().set(wsContadores().wsContLidosFgh003());
            tabelaImpressaoMask().zimp().setIndex(5) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impRegLidosFwk091().set(wsContadores().wsContLidosFwk091());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha07().impFichEsc().set("FWK301");
            tabelaImpressao().linha07().impRegEscrt().set(wsContadores().wsContEscritosFwk301());
            tabelaImpressaoMask().zimp().setIndex(7) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha08().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha08().impReturnCode().set(returnCode);
            tabelaImpressao().linha09().impMens1().set("PGHC091A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh003().close() ;
        fwk091().close() ;
        fwk301().close() ;
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
            while (!fgh003().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsRegFwk091 extends IDataStruct {
        
        @Data(size=3)
        IString wsFwk091CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt wsFwk091CBancCont() ;
        
        @Data(size=4)
        IInt wsFwk091COeEgcCont() ;
        
        @Data(size=7)
        IInt wsFwk091NsRdclCont() ;
        
        @Data(size=1)
        IInt wsFwk091VChkdCont() ;
        
        @Data(size=3)
        IInt wsFwk091CTipoCont() ;
        
        @Data(size=3)
        IString wsFwk091CMoedIsoScta() ;
        
        @Data(size=4)
        IInt wsFwk091NsDeposito() ;
        
        @Data(size=10)
        IString wsFwk091ZMovimento() ;
        
        @Data(size=15)
        ILong wsFwk091NsMovimento() ;
        
        @Data(size=15)
        ILong wsFwk091NsMovNovo() ;
        
        @Data(size=11)
        ILong wsFwk091Resto() ;
        
    }
    public interface WsChaveFwk091 extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4)
        IInt wsCBancCont() ;
        
        @Data(size=4)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7)
        IInt wsNsRdclCont() ;
        
        @Data(size=1)
        IInt wsVChkdCont() ;
        
        @Data(size=3)
        IInt wsCTipoCont() ;
        
        @Data(size=3)
        IString wsCMoedIsoScta() ;
        
        @Data(size=4)
        IInt wsNsDeposito() ;
        
        @Data(size=10)
        IString wsZMovimento() ;
        
        @Data(size=15)
        ILong wsNsMovimento() ;
        
    }
    public interface WsChaveFgh003 extends IDataStruct {
        
        @Data(size=3)
        IString waCPaisIsoaCont() ;
        
        @Data(size=4)
        IInt waCBancCont() ;
        
        @Data(size=4)
        IInt waCOeEgcCont() ;
        
        @Data(size=7)
        IInt waNsRdclCont() ;
        
        @Data(size=1)
        IInt waVChkdCont() ;
        
        @Data(size=3)
        IInt waCTipoCont() ;
        
        @Data(size=3)
        IString waCMoedIsoScta() ;
        
        @Data(size=4)
        IInt waNsDeposito() ;
        
        @Data(size=10)
        IString waZMovimento() ;
        
        @Data(size=15)
        ILong waNsMovimento() ;
        
    }
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
        ILong wsContLidosFwk091() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContLidosFgh003() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContEscritosFwk301() ;
        
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
            
            @Data(size=8, value="PGHC091A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC091A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FGH003")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFgh003() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK091")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk091() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS ESCRITOS EM ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
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
            
            @Data(size=20, value=" ", lpadding=16, lpaddingValue=" ")
            IString impMens1() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=23, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impReg1() ;
            
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
