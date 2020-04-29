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
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : GERA FICHEIRO DE MOVIMENTOS COM INFORMACAO
 * COMPLETAR
 * ---- > FICHEIROS COM OS MOVIMENTOS DAS CONTAS           < ---
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq330a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk16b
     */
    @Handler(name="FWK16B", record="regFwk16bPghq330a")
    @Data
    protected abstract Fwk16b fwk16b() ;
    
    /**
     * @return instancia da classe Fwk102
     */
    @Handler(name="FWK102", record="regFwk102Pghq330a")
    @Data
    protected abstract Fwk102 fwk102() ;
    
    /**
     * @return instancia da classe Fwk59002
     */
    @Handler(name="FWK590", record="regFwk590Pghq330a")
    @Data
    protected abstract Fwk59002 fwk590() ;
    
    
    /**
     * Member Variables(Working Storage)
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
    
    
    @Data(size=4, signed=true, value="0", compression=COMP3)
    protected IInt wsZaFim ;
    
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
     * @return instancia da classe local WsChaveFwk16b
     */
    @Data
    protected abstract WsChaveFwk16b wsChaveFwk16b() ;
    
    /**
     * @return instancia da classe local WsChaveFwk102
     */
    @Data
    protected abstract WsChaveFwk102 wsChaveFwk102() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk16b ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk102 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscritosFwk590 ;
    
    /**
     * TABELA DE IMPRESSAO DE FWK16B
     * @return instancia da classe local TabelaImpressao
     */
    @Data
    protected abstract TabelaImpressao tabelaImpressao() ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ330A");
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
        /**
         * INITIALIZE REG-FWK16B
         * INITIALIZE REG-FWK102
         * INITIALIZE REG-FWK590
         * INITIALIZE WS-CHAVE-FWK16B
         * INITIALIZE WS-CHAVE-FWK102
         */
        a10000AbrirFwk590() ;
        if (progOk.isTrue()) {
            a14000AbrirFwk16b() ;
        }
        if (progOk.isTrue()) {
            a16000AbrirFwk102() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk16b() ;
        }
        if (progOk.isTrue()) {
            a17000LerFwk102() ;
        }
        if (progOk.isTrue()) {
            while (wsChaveFwk102().isLess(wsChaveFwk16b()) && !fwk102().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17000LerFwk102() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFwk590() {
        log(TraceLevel.Debug, "A10000-ABRIR-FWK590");
        fwk590().open(CREATE ) ;
        if (!fwk590().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FWK590 - OPEN - ", fwk590().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000EscreverFwk590() {
        log(TraceLevel.Debug, "A12000-ESCREVER-FWK590");
        fwk590().regFwk590Pghq330a().initialize() ;
        fwk590().regFwk590Pghq330a().wsVirgula1().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula2().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula3().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula4().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula5().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula6().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula7().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula8().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula9().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula10().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula11().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula12().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula13().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula14().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula15().set(";");
        fwk590().regFwk590Pghq330a().wsVirgula16().set(";");
        fwk590().regFwk590Pghq330a().fwk590CPaisIsoaCont().set(fwk16b().regFwk16bPghq330a().fwk16bCPaisIsoaCont());
        fwk590().regFwk590Pghq330a().fwk590CBancCont().set(fwk16b().regFwk16bPghq330a().fwk16bCBancCont());
        fwk590().regFwk590Pghq330a().fwk590COeEgcCont().set(fwk16b().regFwk16bPghq330a().fwk16bCOeEgcCont());
        fwk590().regFwk590Pghq330a().fwk590NsRdclCont().set(fwk16b().regFwk16bPghq330a().fwk16bNsRdclCont());
        fwk590().regFwk590Pghq330a().fwk590VChkdCont().set(fwk16b().regFwk16bPghq330a().fwk16bVChkdCont());
        fwk590().regFwk590Pghq330a().fwk590CTipoCont().set(fwk16b().regFwk16bPghq330a().fwk16bCTipoCont());
        fwk590().regFwk590Pghq330a().fwk590CMoedIsoScta().set(fwk16b().regFwk16bPghq330a().fwk16bCMoedIsoScta());
        fwk590().regFwk590Pghq330a().fwk590NsDeposito().set(fwk16b().regFwk16bPghq330a().fwk16bNsDeposito());
        fwk590().regFwk590Pghq330a().fwk590TsZMovimento().set(fwk16b().regFwk16bPghq330a().fwk16bTsActzUlt().get(1, 10));
        fwk590().regFwk590Pghq330a().fwk590ZValMov().set(fwk16b().regFwk16bPghq330a().fwk16bZValMov());
        fwk590().regFwk590Pghq330a().fwk590TsTimer().set(fwk16b().regFwk16bPghq330a().fwk16bTsActzUlt().get(12, 15));
        fwk590().regFwk590Pghq330a().fwk590XRefMov().set(fwk16b().regFwk16bPghq330a().fwk16bXRefMov());
        fwk590().regFwk590Pghq330a().fwk590NDocOpps().set(fwk16b().regFwk16bPghq330a().fwk16bNDocOpps());
        fwk590().regFwk590Pghq330a().fwk590MMovimento().set(fwk16b().regFwk16bPghq330a().fwk16bMMovimento());
        fwk590().regFwk590Pghq330a().fwk590MSldoCbloApos().set(fwk16b().regFwk16bPghq330a().fwk16bMSldoCbloApos());
        fwk590().regFwk590Pghq330a().fwk590IDbcr().set(fwk16b().regFwk16bPghq330a().fwk16bIDbcr());
        fwk590().regFwk590Pghq330a().fwk590IEstorno().set(fwk16b().regFwk16bPghq330a().fwk16bIEstorno());
        fwk590().regFwk590Pghq330a().fwk590CUserid102().set(fwk102().regFwk102Pghq330a().fwk102CUserid());
        fwk590().regFwk590Pghq330a().fwk590NsMovimento().set(fwk16b().regFwk16bPghq330a().fwk16bNsMovimento());
        fwk590().regFwk590Pghq330a().fwk590COeEgcOpex102().set(fwk102().regFwk102Pghq330a().fwk102COeEgcOpex());
        fwk590().regFwk590Pghq330a().fwk590CTipoCanlAces102().set(fwk102().regFwk102Pghq330a().fwk102CTipoCanlAces());
        fwk590().write(fwk590().regFwk590Pghq330a()) ;
        if (!fwk590().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FWK590 - WRITE - ", fwk590().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk16b() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK16B");
        fwk16b().open() ;
        if (!fwk16b().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ330A - FWK16B - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk16b().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk16b() {
        log(TraceLevel.Debug, "A15000-LER-FWK16B");
        fwk16b().read() ;
        if (fwk16b().getStatusOk()) {
            wsChaveFwk16b().wsFwk16bCPaisIsoaCont().set(fwk16b().regFwk16bPghq330a().fwk16bCPaisIsoaCont());
            wsChaveFwk16b().wsFwk16bCBancCont().set(fwk16b().regFwk16bPghq330a().fwk16bCBancCont());
            wsChaveFwk16b().wsFwk16bCOeEgcCont().set(fwk16b().regFwk16bPghq330a().fwk16bCOeEgcCont());
            wsChaveFwk16b().wsFwk16bNsRdclCont().set(fwk16b().regFwk16bPghq330a().fwk16bNsRdclCont());
            wsChaveFwk16b().wsFwk16bVChkdCont().set(fwk16b().regFwk16bPghq330a().fwk16bVChkdCont());
            wsChaveFwk16b().wsFwk16bCTipoCont().set(fwk16b().regFwk16bPghq330a().fwk16bCTipoCont());
            wsChaveFwk16b().wsFwk16bCMoedIsoScta().set(fwk16b().regFwk16bPghq330a().fwk16bCMoedIsoScta());
            wsChaveFwk16b().wsFwk16bNsDeposito().set(fwk16b().regFwk16bPghq330a().fwk16bNsDeposito());
            wsChaveFwk16b().wsFwk16bTsMovimento().set(fwk16b().regFwk16bPghq330a().fwk16bTsMovimento());
            wsChaveFwk16b().wsFwk16bNsMovimento().set(fwk16b().regFwk16bPghq330a().fwk16bNsMovimento());
            contRegLidosFwk16b.add(1);
        } else if (fwk16b().getStatusOk()) {
            fwk16b().setStatusEof();
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ330A - FWK16B - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk16b().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirFwk102() {
        log(TraceLevel.Debug, "A16000-ABRIR-FWK102");
        fwk102().open() ;
        if (!fwk102().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ330A - FWK102 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk102().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerFwk102() {
        log(TraceLevel.Debug, "A17000-LER-FWK102");
        fwk102().read() ;
        if (fwk102().getStatusOk()) {
            wsChaveFwk102().wsFwk102CPaisIsoaCont().set(fwk102().regFwk102Pghq330a().fwk102CPaisIsoaCont());
            wsChaveFwk102().wsFwk102CBancCont().set(fwk102().regFwk102Pghq330a().fwk102CBancCont());
            wsChaveFwk102().wsFwk102COeEgcCont().set(fwk102().regFwk102Pghq330a().fwk102COeEgcCont());
            wsChaveFwk102().wsFwk102NsRdclCont().set(fwk102().regFwk102Pghq330a().fwk102NsRdclCont());
            wsChaveFwk102().wsFwk102VChkdCont().set(fwk102().regFwk102Pghq330a().fwk102VChkdCont());
            wsChaveFwk102().wsFwk102CTipoCont().set(fwk102().regFwk102Pghq330a().fwk102CTipoCont());
            wsChaveFwk102().wsFwk102CMoedIsoScta().set(fwk102().regFwk102Pghq330a().fwk102CMoedIsoScta());
            wsChaveFwk102().wsFwk102NsDeposito().set(fwk102().regFwk102Pghq330a().fwk102NsDeposito());
            wsChaveFwk102().wsFwk102TsMovimento().set(fwk102().regFwk102Pghq330a().fwk102TsMovimento());
            wsChaveFwk102().wsFwk102NsMovimento().set(fwk102().regFwk102Pghq330a().fwk102NsMovimento());
            contRegLidosFwk102.add(1);
        }
        if (!fwk102().getStatusOk() && !fwk102().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ330A - FWK102 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk102().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (wsChaveFwk16b().isEqual(wsChaveFwk102())) {
            a12000EscreverFwk590() ;
        } else if (wsChaveFwk16b().isGreater(wsChaveFwk102())) {
            while (wsChaveFwk102().isLess(wsChaveFwk16b()) && !fwk102().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17000LerFwk102() ;
            }
            if (wsChaveFwk16b().isEqual(wsChaveFwk102())) {
                a12000EscreverFwk590() ;
            }
        }
        if (progOk.isTrue()) {
            a15000LerFwk16b() ;
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
        }
        fwk16b().close() ;
        fwk102().close() ;
        fwk590().close() ;
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
            while (!fwk16b().getStatusOk() && progOk.isTrue()) {
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
    public interface WsChaveFwk16b extends IDataStruct {
        
        @Data(size=3)
        IString wsFwk16bCPaisIsoaCont() ;
        
        @Data(size=4)
        IInt wsFwk16bCBancCont() ;
        
        @Data(size=4)
        IInt wsFwk16bCOeEgcCont() ;
        
        @Data(size=7)
        IInt wsFwk16bNsRdclCont() ;
        
        @Data(size=1)
        IInt wsFwk16bVChkdCont() ;
        
        @Data(size=3)
        IInt wsFwk16bCTipoCont() ;
        
        @Data(size=3)
        IString wsFwk16bCMoedIsoScta() ;
        
        @Data(size=4)
        IInt wsFwk16bNsDeposito() ;
        
        @Data(size=26)
        IString wsFwk16bTsMovimento() ;
        
        @Data(size=15)
        ILong wsFwk16bNsMovimento() ;
        
    }
    public interface WsChaveFwk102 extends IDataStruct {
        
        @Data(size=3)
        IString wsFwk102CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt wsFwk102CBancCont() ;
        
        @Data(size=4)
        IInt wsFwk102COeEgcCont() ;
        
        @Data(size=7)
        IInt wsFwk102NsRdclCont() ;
        
        @Data(size=1)
        IInt wsFwk102VChkdCont() ;
        
        @Data(size=3)
        IInt wsFwk102CTipoCont() ;
        
        @Data(size=3)
        IString wsFwk102CMoedIsoScta() ;
        
        @Data(size=4)
        IInt wsFwk102NsDeposito() ;
        
        @Data(size=26)
        IString wsFwk102TsMovimento() ;
        
        @Data(size=15)
        ILong wsFwk102NsMovimento() ;
        
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
     * TABELA DE IMPRESSAO DE FWK16B
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
            
            @Data(size=8, value="PGHQ330A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ330A")
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
            IFormattedString impRegLidosFwk16b() ;
            
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
    
}
