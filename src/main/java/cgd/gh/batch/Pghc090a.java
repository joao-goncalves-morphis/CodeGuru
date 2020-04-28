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
 * OBJECTIVOS    - INCLUSAO DE REGISTO EM TAPE
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc090a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk00303
     */
    @Handler(name="FWK003", record="rgh00301")
    @Data
    protected abstract Fwk00303 fwk003() ;
    
    
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
    
    
    @Data(size=8, value="CONVHO")
    protected IString wsCUseridHo ;
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    /**
     * @return instancia da classe local WsChaveFix
     */
    @Data
    protected abstract WsChaveFix wsChaveFix() ;
    
    /**
     * 01  WS-TS-MOVIMENTO-1        PIC X(26)
     * VALUE '1998-06-22-00.00.00.000000'.
     * 01  WS-TS-MOVIMENTO-2        PIC X(26)
     * VALUE '1998-10-28-00.00.00.000000'.
     * 01  WS-NS-MOVIMENTO-1        PIC S9(15)V USAGE COMP-3
     * VALUE +457575.
     * 01  WS-NS-MOVIMENTO-2        PIC S9(15)V USAGE COMP-3
     * VALUE +457576.
     * @return instancia da classe local WsChave
     */
    @Data
    protected abstract WsChave wsChave() ;
    
    /**
     * @return instancia da classe local WaRwk00301
     */
    @Data
    protected abstract WaRwk00301 waRwk00301() ;
    
    @Data(size=1, value=" ")
    protected IString wsConcluido ;
    @Data
    @Condition("N")
    protected ICondition naoConcluido ;
    @Data
    @Condition("S")
    protected ICondition concluido ;
    
    
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
        bghw0300().wsNmPrograma().set("PGHC090A");
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
            a16000LerFwk003() ;
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
        log(TraceLevel.Debug, "A14000-ABRIR-FWK003");
        fwk003().open() ;
        if (!fwk003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC090A - FWK003 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk003().getStatus());
        }
        fgh003().open(CREATE ) ;
        if (!fgh003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC090A - FGH003 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fgh003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFwk003() {
        log(TraceLevel.Debug, "A16000-LER-FWK003");
        fwk003().read() ;
        if (fwk003().getStatusOk()) {
            wsContadores().wsContadorLidos().add(1);
            wsChave().wsCPaisIsoaCont().set(fwk003().rwk00301Pghc090a().fwk003CPaisIsoaCont());
            wsChave().wsCBancCont().set(fwk003().rwk00301Pghc090a().fwk003CBancCont());
            wsChave().wsCOeEgcCont().set(fwk003().rwk00301Pghc090a().fwk003COeEgcCont());
            wsChave().wsNsRdclCont().set(fwk003().rwk00301Pghc090a().fwk003NsRdclCont());
            wsChave().wsVChkdCont().set(fwk003().rwk00301Pghc090a().fwk003VChkdCont());
            wsChave().wsCTipoCont().set(fwk003().rwk00301Pghc090a().fwk003CTipoCont());
            wsChave().wsCMoedIsoScta().set(fwk003().rwk00301Pghc090a().fwk003CMoedIsoScta());
            wsChave().wsNsDeposito().set(fwk003().rwk00301Pghc090a().fwk003NsDeposito());
            waRwk00301().set(fwk003().getRecord()) ;
        }
        if (!fwk003().getStatusOk() && !fwk003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC090A - FWK003 - READ - ");
            tabelaImpressao().linha10().impStatus().set(fwk003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if ((fwk003().rwk00301Pghc090a().fwk003CTipoCont().isEqual(71) || 
            fwk003().rwk00301Pghc090a().fwk003CTipoCont().isEqual(72)) && 
            fwk003().rwk00301Pghc090a().fwk003AAplOrig().isEqual("ME")) {
            wsContadores().wsContEliminados().add(1);
        } else {
            fgh003().setRecord(fwk003().getRecord()) ;
            a32000EscreverFgh003() ;
        }
        /**
         * IF NAO-CONCLUIDO
         * IF WS-CHAVE < WS-CHAVE-FIX
         * MOVE RWK00301 TO RGH00301
         * PERFORM A32000-ESCREVER-FGH003
         * ELSE
         * SET CONCLUIDO     TO TRUE
         * PERFORM A33000-FORMATAR-REGISTO
         * IF PROG-OK
         * END-IF
         * MOVE WA-RWK00301 TO RGH00301
         */
        if (progOk.isTrue()) {
            a16000LerFwk003() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreverFgh003() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FGH003");
        fgh003().write(fgh003().rgh00301()) ;
        if (fgh003().getStatusOk()) {
            wsContadores().wsContEscritosFgh003().add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC090A - FGH003 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fgh003().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * *A33000-FORMATAR-REGISTO.
     * IF SW-DEBUG-ON
     * DISPLAY 'A33000-FORMATAR-REGISTO'
     * END-IF
     * INITIALIZE RGH00301
     * MOVE 'PT'                    TO FGH003-C-PAIS-ISOA-CONT
     * MOVE 35                      TO FGH003-C-BANC-CONT
     * MOVE 102                     TO FGH003-C-OE-EGC-CONT
     * MOVE 20762                   TO FGH003-NS-RDCL-CONT
     * MOVE 9                       TO FGH003-V-CHKD-CONT
     * MOVE 21                      TO FGH003-C-TIPO-CONT
     * MOVE 'EUR'                   TO FGH003-C-MOED-ISO-SCTA
     * MOVE 102                     TO FGH003-NS-DEPOSITO
     * MOVE '2001-10-12-00.00.00.000000'
     * TO FGH003-TS-MOVIMENTO
     * MOVE 3                       TO FGH003-NS-MOVIMENTO
     * MOVE '2001-10-12'            TO FGH003-Z-VAL-MOV
     * FGH003-Z-MOV-LOCL
     * MOVE 'D'                     TO FGH003-I-DBCR
     * MOVE 200736,23               TO FGH003-M-MOVIMENTO
     * MOVE SPACES                  TO FGH003-I-ESTORNO
     * MOVE 'PTE'                   TO FGH003-C-MOED-ISO-ORI-MOV
     * MOVE ZEROS                   TO FGH003-M-SLDO-CBLO-APOS
     * FGH003-M-SLDO-DPNL-APOS
     * MOVE 40244000,00             TO FGH003-M-MOV-MOE-ORIG-MOV
     * MOVE 'RENOVACAO'             TO FGH003-X-REF-MOV
     * MOVE ZEROS                   TO FGH003-N-DOC-OPPS
     * FGH003-T-JURO
     * MOVE 'JF'                    TO FGH003-A-APL-ORIG
     * MOVE 'N'                     TO FGH003-I-EXIS-INF-ADI
     * MOVE SPACES                  TO FGH003-X-CHAV-ACS-INF-ADI
     * TO FGH003-TS-ACTZ-ULT
     * MOVE 'CONVHO'               TO FGH003-C-USID-ACTZ-ULT
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
            tabelaImpressao().linha05().impRegLidosFwk003().set(wsContadores().wsContadorLidos());
            tabelaImpressaoMask().zimp().setIndex(5) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FGH003");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().wsContEscritosFgh003());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha07().impFichElim().set(" ");
            tabelaImpressao().linha07().impRegEliminados().set(wsContadores().wsContEliminados());
            tabelaImpressaoMask().zimp().setIndex(7) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha08().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha08().impReturnCode().set(returnCode);
            tabelaImpressao().linha09().impMens1().set("PGHC090A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(11); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fwk003().close() ;
        fgh003().close() ;
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
            while (!fwk003().getStatusOk() && progOk.isTrue()) {
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
    
    /**
     * 
     * 01  WS-TS-MOVIMENTO-1        PIC X(26)
     * VALUE '1998-06-22-00.00.00.000000'.
     * 01  WS-TS-MOVIMENTO-2        PIC X(26)
     * VALUE '1998-10-28-00.00.00.000000'.
     * 01  WS-NS-MOVIMENTO-1        PIC S9(15)V USAGE COMP-3
     * VALUE +457575.
     * 01  WS-NS-MOVIMENTO-2        PIC S9(15)V USAGE COMP-3
     * VALUE +457576.
     * 
     * @version 2.0
     * 
     */
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
    public interface WaRwk00301 extends IDataStruct {
        
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
        
        @Data(size=10)
        IString waZValMov() ;
        
        @Data(size=10)
        IString waZMovLocl() ;
        
        @Data(size=1)
        IString waIDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMMovimento() ;
        
        @Data(size=1)
        IString waIEstorno() ;
        
        @Data(size=3)
        IString waCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal waMMovMoeOrigMov() ;
        
        @Data(size=21)
        IString waXRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong waNDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal waTJuro() ;
        
        @Data(size=2)
        IString waAAplOrig() ;
        
        @Data(size=1)
        IString waIExisInfAdi() ;
        
        @Data(size=40)
        IString waXChavAcsInfAdi() ;
        
        @Data(size=26)
        IString waTsActzUlt() ;
        
        @Data(size=8)
        IString waCUsidActzUlt() ;
        
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
        ILong wsContadorLidos() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContEliminados() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong wsContEscritosFgh003() ;
        
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
            
            @Data(size=8, value="PGHC090A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC090A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK003")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk003() ;
            
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
