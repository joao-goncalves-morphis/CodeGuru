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
import cgd.gh.structures.work.Bghw0017 ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    - INCLUIR REGISTO EM TAPE
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc190a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fgh103
     */
    @Handler(name="FGH103", record="rgh10301")
    @Data
    protected abstract Fgh103 fgh103() ;
    
    /**
     * @return instancia da classe Fwk103
     */
    @Handler(name="FWK103", record="rwk10301Pghc190a")
    @Data
    protected abstract Fwk103 fwk103() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0017
     */
    @Data
    protected abstract Bghw0017 bghw0017() ;
    
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
    protected IString wsConcluido ;
    @Data
    @Condition("N")
    protected ICondition naoConcluido ;
    @Data
    @Condition("S")
    protected ICondition concluido ;
    
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    /**
     * @return instancia da classe local WsChaveFix
     */
    @Data
    protected abstract WsChaveFix wsChaveFix() ;
    
    /**
     * @return instancia da classe local WsChave
     */
    @Data
    protected abstract WsChave wsChave() ;
    
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
     * @return instancia da classe local WaRwk10301
     */
    @Data
    protected abstract WaRwk10301 waRwk10301() ;
    
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
        bghw0300().wsNmPrograma().set("PGHC190A");
        wsContadores().initialize() ;
        progOk.setTrue() ;
        naoConcluido.setTrue() ;
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
            a16000LerFwk103() ;
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
        log(TraceLevel.Debug, "A14000-ABRIR-FWK103");
        fwk103().open() ;
        if (!fwk103().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC190A - FWK103 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk103().getStatus());
        }
        fgh103().open(CREATE ) ;
        if (!fgh103().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC190A - FGH103 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh103().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFwk103() {
        log(TraceLevel.Debug, "A16000-LER-FWK103");
        fwk103().read() ;
        if (fwk103().getStatusOk()) {
            wsContadores().wsContadorLidos().add(1);
            wsChave().wsCPaisIsoaCont().set(fwk103().rwk10301Pghc190a().fwk103CPaisIsoaCont());
            wsChave().wsCBancCont().set(fwk103().rwk10301Pghc190a().fwk103CBancCont());
            wsChave().wsCOeEgcCont().set(fwk103().rwk10301Pghc190a().fwk103COeEgcCont());
            wsChave().wsNsRdclCont().set(fwk103().rwk10301Pghc190a().fwk103NsRdclCont());
            wsChave().wsVChkdCont().set(fwk103().rwk10301Pghc190a().fwk103VChkdCont());
            wsChave().wsCTipoCont().set(fwk103().rwk10301Pghc190a().fwk103CTipoCont());
            wsChave().wsCMoedIsoScta().set(fwk103().rwk10301Pghc190a().fwk103CMoedIsoScta());
            wsChave().wsNsDeposito().set(fwk103().rwk10301Pghc190a().fwk103NsDeposito());
            waRwk10301().set(fwk103().getRecord()) ;
        } else if (fwk103().getStatusOk()) {
            if (naoConcluido.isTrue()) {
                concluido.setTrue() ;
                a33000FormatarRegisto() ;
                if (progOk.isTrue()) {
                    a32000EscreverFgh103() ;
                }
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC190A - FWK103 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk103().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if ((fwk103().rwk10301Pghc190a().fwk103CTipoCont().isEqual(71) || 
            fwk103().rwk10301Pghc190a().fwk103CTipoCont().isEqual(72)) && 
            fwk103().rwk10301Pghc190a().fwk103AAplicacao().isEqual("ME")) {
            wsContadores().wsContEliminados().add(1);
        } else {
            /**
             * IF NAO-CONCLUIDO
             * IF WS-CHAVE < WS-CHAVE-FIX
             * MOVE RWK10301 TO RGH10301
             * PERFORM A32000-ESCREVER-FGH103
             * ELSE
             * SET CONCLUIDO     TO TRUE
             * PERFORM A33000-FORMATAR-REGISTO
             * IF PROG-OK
             * END-IF
             * MOVE WA-RWK10301 TO RGH10301
             */
            fgh103().setRecord(fwk103().getRecord()) ;
            a32000EscreverFgh103() ;
        }
        if (progOk.isTrue()) {
            a16000LerFwk103() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreverFgh103() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FGH103");
        fgh103().write(fgh103().rgh10301()) ;
        if (fgh103().getStatusOk()) {
            wsContadores().wsContEscritosFgh103().add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC190A - FGH103 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fgh103().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000FormatarRegisto() {
        log(TraceLevel.Debug, "A33000-FORMATAR-REGISTO");
        fgh103().rgh10301().initialize() ;
        fgh103().rgh10301().fgh103CPaisIsoaCont().set("PT");
        fgh103().rgh10301().fgh103CBancCont().set(35);
        fgh103().rgh10301().fgh103COeEgcCont().set(102);
        fgh103().rgh10301().fgh103NsRdclCont().set(20762);
        fgh103().rgh10301().fgh103VChkdCont().set(9);
        fgh103().rgh10301().fgh103CTipoCont().set(21);
        fgh103().rgh10301().fgh103CMoedIsoScta().set("EUR");
        fgh103().rgh10301().fgh103NsDeposito().set(102);
        fgh103().rgh10301().fgh103TsMovimento().set("2001-10-12-00.00.00.000000");
        fgh103().rgh10301().fgh103NsMovimento().set(3);
        fgh103().rgh10301().fgh103CTransaccao().set(" ");
        fgh103().rgh10301().fgh103AAplicacao().set("JF");
        fgh103().rgh10301().fgh103COpczMenu().set("LEV");
        fgh103().rgh10301().fgh103COpeBbn().set("HVB41");
        fgh103().rgh10301().fgh103CEvenOpel().set(" ");
        fgh103().rgh10301().fgh103CTerminal().set(" ");
        fgh103().rgh10301().fgh103COperador().set(9319);
        fgh103().rgh10301().fgh103COpexAtrx().set(9319);
        fgh103().rgh10301().fgh103CUserid().set("9319");
        fgh103().rgh10301().fgh103CTipoCanlAces().set("LTRT");
        fgh103().rgh10301().fgh103CPaisIsoaOeOpx().set("PT");
        fgh103().rgh10301().fgh103CMnemEgcOpex().set("CGD");
        fgh103().rgh10301().fgh103COeEgcOpex().set(9319);
        fgh103().rgh10301().fgh103CProdSgop().set(0);
        fgh103().rgh10301().fgh103CFamiProd().set("403");
        fgh103().rgh10301().fgh103CProduto().set("229");
        fgh103().rgh10301().fgh103CCndzMovzCont().set(0);
        fgh103().rgh10301().fgh103CGrupCont().set(0);
        fgh103().rgh10301().fgh103CTipoIttz().set(1321200);
        fgh103().rgh10301().fgh103TCambio().set(0);
        fgh103().rgh10301().fgh103MSldoRetd().set(0);
        fgh103().rgh10301().fgh103MSldoVcob().set(0);
        fgh103().rgh10301().fgh103MCmrgLim().set(0);
        fgh103().rgh10301().fgh103MCmrgUtid().set(0);
        fgh103().rgh10301().fgh103MDcboNgcdAtrd().set(0);
        fgh103().rgh10301().fgh103MDcboNgcdUtid().set(0);
        fgh103().rgh10301().fgh103NJourBbn().set(0);
        fgh103().rgh10301().fgh103NsJourBbn().set(0);
        fgh103().rgh10301().fgh103NsJourBbnDtlh().set(0);
        fgh103().rgh10301().fgh103NmArqvOrig().set("THO00024");
        fgh103().rgh10301().fgh103TsActzUlt().set("2001-10-12-00.00.00.000000");
        fgh103().rgh10301().fgh103CUsidActzUlt().set("CONVHO");
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
            tabelaImpressao().linha0702().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha05().impRegLidosFwk103().set(wsContadores().wsContadorLidos());
            tabelaImpressaoMask().zimp().setIndex(5) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FGH103");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContEscritosFgh103());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha07().impRegEliminados().set(wsContadores().wsContEliminados());
            tabelaImpressao().linha07().impFichElim().set(" ");
            tabelaImpressaoMask().zimp().setIndex(7) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha0702().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha0702().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC190A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fwk103().close() ;
        fgh103().close() ;
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
            while (!fwk103().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsChaveFix extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString wsCPaisIsoaContFix() ;
        
        @Data(size=4, signed=true, value="35", compression=COMP3)
        IInt wsCBancContFix() ;
        
        @Data(size=4, signed=true, value="102", compression=COMP3)
        IInt wsCOeEgcContFix() ;
        
        @Data(size=7, signed=true, value="20762", compression=COMP3)
        IInt wsNsRdclContFix() ;
        
        @Data(size=1, signed=true, value="9", compression=COMP3)
        IInt wsVChkdContFix() ;
        
        @Data(size=3, signed=true, value="21", compression=COMP3)
        IInt wsCTipoContAnt() ;
        
        @Data(size=3, value="EUR")
        IString wsCMoedIsoSctaFix() ;
        
        @Data(size=4, signed=true, value="102", compression=COMP3)
        IInt wsNsDepositoFix() ;
        
    }
    public interface WsChave extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, value="0", compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, value="0", compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, value="0", compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3, value=" ")
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt wsNsDeposito() ;
        
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
    public interface WaRwk10301 extends IDataStruct {
        
        @Data(size=3)
        IString waCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt waCBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt waCOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt waNsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt waVChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt waCTipoCont() ;
        
        @Data(size=3)
        IString waCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt waNsDeposito() ;
        
        @Data(size=26)
        IString waTsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong waNsMovimento() ;
        
        @Data(size=4)
        IString waCTransaccao() ;
        
        @Data(size=2)
        IString waAAplicacao() ;
        
        @Data(size=3)
        IString waCOpczMenu() ;
        
        @Data(size=5)
        IString waCOpeBbn() ;
        
        @Data(size=4)
        IString waCEvenOpel() ;
        
        @Data(size=4)
        IString waCTerminal() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt waCOperador() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt waCOpexAtrx() ;
        
        @Data(size=8)
        IString waCUserid() ;
        
        @Data(size=4)
        IString waCTipoCanlAces() ;
        
        @Data(size=3)
        IString waCPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString waCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt waCOeEgcOpex() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong waCProdSgop() ;
        
        @Data(size=3)
        IString waCFamiProd() ;
        
        @Data(size=3)
        IString waCProduto() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt waCCndzMovzCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt waCGrupCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt waCTipoIttz() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal waTCambio() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMSldoRetd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMSldoVcob() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMCmrgUtid() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMDcboNgcdAtrd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMDcboNgcdUtid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong waNJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt waNsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt waNsJourBbnDtlh() ;
        
        @Data(size=8)
        IString waNmArqvOrig() ;
        
        @Data(size=26)
        IString waTsActzUlt() ;
        
        @Data(size=8)
        IString waCUsidActzUlt() ;
        
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
        ILong wsContEscritosFgh103() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContEliminados() ;
        
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
         * @return instancia da classe local Linha0702
         */
        @Data
        Linha0702 linha0702() ;
        
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
            
            @Data(size=8, value="PGHC190A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC190A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK103")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk103() ;
            
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
            
            @Data(size=32, value="NUMERO DE REGISTOS ELIMINADOS  ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichElim() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEliminados() ;
            
        }
        
        public interface Linha0702 extends IDataStruct {
            
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
