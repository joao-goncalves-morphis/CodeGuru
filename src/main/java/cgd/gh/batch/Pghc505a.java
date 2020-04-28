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


/**
 * 
 * FGH512 - FICHEIRO COM OS MOVIMENTOS DE CONTAS
 * FGH522 - FICHEIRO DE MOVIMENTOS DE CONTAS
 * FGH300 - FICHEIRO DE CONTROLO DE EXECUCAO DO PROGRAMA
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * *---> SEPARA FWK507 EM VARIOS FICHEIROS PARA A APLICACAO HO <---
 * OBJECTIVOS    : SEPARA FICHEIRO FWK507 CRIADO NO PGHQ502A
 * EM VARIOS FICHEIROS PARA A APLICACAO HO
 * ALTERACAO     :
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc505a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk50701
     */
    @Handler(name="FWK507", record="rwk50201")
    @Data
    protected abstract Fwk50701 fwk507() ;
    
    /**
     * @return instancia da classe Fgh512
     */
    @Handler(name="FGH512", record="regFgh512")
    @Data
    protected abstract Fgh512 fgh512() ;
    
    /**
     * @return instancia da classe Fgh522
     */
    @Handler(name="FGH522", record="regFgh522")
    @Data
    protected abstract Fgh522 fgh522() ;
    
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    @Data(size=5, signed=true, compression=COMP3)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk507 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh512 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh522 ;
    
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
    
    @Data(size=8, value="0")
    protected ILong wsDataAux ;
    
    /**
     * @return instancia da classe local WsZAux
     */
    @Data
    protected abstract WsZAux wsZAux() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
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
        bghw0300().wsNmPrograma().set("PGHC505A");
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
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AbrirFicheiros() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A11000-ABRIR-FGH300");
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
        fgh512().open(CREATE ) ;
        if (!fgh512().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FGH512 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh512().getStatus());
        }
        if (progOk.isTrue()) {
            fgh522().open(CREATE ) ;
            if (!fgh522().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC505A - FGH522 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fgh522().getStatus());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (progOk.isTrue()) {
            a31000OpenFwk507() ;
            if (progOk.isTrue()) {
                a32000LerFwk507() ;
            }
            if (progOk.isTrue()) {
                while (!fwk507().getStatusOk() && progOk.isTrue()) {
                    a33000TratarFwk507() ;
                }
                if (progOk.isTrue()) {
                    a40000FecharFicheiros() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000OpenFwk507() {
        log(TraceLevel.Debug, "A31000-OPEN-FWK507");
        fwk507().open() ;
        if (!fwk507().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FWK507 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk507().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000LerFwk507() {
        log(TraceLevel.Debug, "A32000-LER-FWK507");
        fwk507().read() ;
        if (fwk507().getStatusOk()) {
            contRegLidosFwk507.add(1);
        }
        if (!fwk507().getStatusOk() && !fwk507().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FGH512 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk507().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000TratarFwk507() {
        log(TraceLevel.Debug, "A33000-TRTAR-FWK507");
        for (fwk507().rwk50201().fwk502GrFicheiro().setIndex(1); fwk507().rwk50201().fwk502GrFicheiro().index().isLessOrEqual(3); fwk507().rwk50201().fwk502GrFicheiro().incIndex()) {
            if (fwk507().rwk50201().fwk502GrFicheiro().getCurrent().fwk502NmFicheiro().isEqual("FGH512")) {
                a32100EscreverFgh512() ;
            }
            if (fwk507().rwk50201().fwk502GrFicheiro().getCurrent().fwk502NmFicheiro().isEqual("FGH522")) {
                a32200EscreverFgh522() ;
            }
        }
        if (progOk.isTrue()) {
            a32000LerFwk507() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100EscreverFgh512() {
        log(TraceLevel.Debug, "A32100-ESCREVER-FGH512");
        fgh512().regFgh512().initialize() ;
        fgh512().regFgh512().fgh512Subconta().fgh512CPaisIsoaCont().set(fwk507().rwk50201().fwk502Subconta().fwk502CPaisIsoaCont());
        fgh512().regFgh512().fgh512Subconta().fgh512CBancCont().set(fwk507().rwk50201().fwk502Subconta().fwk502CBancCont());
        fgh512().regFgh512().fgh512Subconta().fgh512COeEgcCont().set(fwk507().rwk50201().fwk502Subconta().fwk502COeEgcCont());
        fgh512().regFgh512().fgh512Subconta().fgh512NsRdclCont().set(fwk507().rwk50201().fwk502Subconta().fwk502NsRdclCont());
        fgh512().regFgh512().fgh512Subconta().fgh512VChkdCont().set(fwk507().rwk50201().fwk502Subconta().fwk502VChkdCont());
        fgh512().regFgh512().fgh512Subconta().fgh512CTipoCont().set(fwk507().rwk50201().fwk502Subconta().fwk502CTipoCont());
        fgh512().regFgh512().fgh512Subconta().fgh512CMoedIsoScta().set(fwk507().rwk50201().fwk502Subconta().fwk502CMoedIsoScta());
        fgh512().regFgh512().fgh512Subconta().fgh512NsDeposito().set(fwk507().rwk50201().fwk502Subconta().fwk502NsDeposito());
        fgh512().regFgh512().fgh512NsMovimento().set(fwk507().rwk50201().fwk502NsMovimento());
        fgh512().regFgh512().fgh512ZMovimento().set(fwk507().rwk50201().fwk502ZMovimento());
        fgh512().regFgh512().fgh512ZValMov().set(fwk507().rwk50201().fwk502ZValMov());
        fgh512().regFgh512().fgh512IDbcr().set(fwk507().rwk50201().fwk502IDbcr());
        fgh512().regFgh512().fgh512MMovimento().set(fwk507().rwk50201().fwk502MMovimento());
        fgh512().regFgh512().fgh512IEstorno().set(fwk507().rwk50201().fwk502IEstorno());
        fgh512().regFgh512().fgh512CMoedIsoOriMov().set(fwk507().rwk50201().fwk502CMoedIsoOriMov());
        fgh512().regFgh512().fgh512MSldoCbloApos().set(fwk507().rwk50201().fwk502MSldoCbloApos());
        fgh512().regFgh512().fgh512MSldoDpnlApos().set(fwk507().rwk50201().fwk502MSldoDpnlApos());
        fgh512().regFgh512().fgh512MMovMoeOrigMov().set(fwk507().rwk50201().fwk502MMovMoeOrigMov());
        fgh512().regFgh512().fgh512XRefMov().set(fwk507().rwk50201().fwk502XRefMov());
        fgh512().regFgh512().fgh512NDocOpps().set(fwk507().rwk50201().fwk502NDocOpps());
        fgh512().regFgh512().fgh512AAplOrig().set(fwk507().rwk50201().fwk502AAplOrig());
        fgh512().regFgh512().fgh512COpeBbn().set(fwk507().rwk50201().fwk502COpeBbn());
        fgh512().regFgh512().fgh512COpczMenu().set(fwk507().rwk50201().fwk502COpczMenu());
        fgh512().regFgh512().fgh512CTipoCanlAces().set(fwk507().rwk50201().fwk502CTipoCanlAces());
        fgh512().regFgh512().fgh512CTipoCanlAces().set(fwk507().rwk50201().fwk502CTipoCanlAces());
        fgh512().regFgh512().fgh512CPaisIsoaOeOpx().set(fwk507().rwk50201().fwk502CPaisIsoaOeOpx());
        fgh512().regFgh512().fgh512CMnemEgcOpex().set(fwk507().rwk50201().fwk502CMnemEgcOpex());
        fgh512().regFgh512().fgh512COeEgcOpex().set(fwk507().rwk50201().fwk502COeEgcOpex());
        fgh512().write(fgh512().regFgh512()) ;
        if (fgh512().getStatusOk()) {
            contRegEscrtFgh512.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FGH512 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fgh512().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32200EscreverFgh522() {
        log(TraceLevel.Debug, "A32200-ESCREVER-FGH522");
        fgh522().regFgh522().initialize() ;
        fgh522().regFgh522().fgh522Subconta().fgh522CPaisIsoaCont().set(fwk507().rwk50201().fwk502Subconta().fwk502CPaisIsoaCont());
        fgh522().regFgh522().fgh522Subconta().fgh522CBancCont().set(fwk507().rwk50201().fwk502Subconta().fwk502CBancCont());
        fgh522().regFgh522().fgh522Subconta().fgh522COeEgcCont().set(fwk507().rwk50201().fwk502Subconta().fwk502COeEgcCont());
        fgh522().regFgh522().fgh522Subconta().fgh522NsRdclCont().set(fwk507().rwk50201().fwk502Subconta().fwk502NsRdclCont());
        fgh522().regFgh522().fgh522Subconta().fgh522VChkdCont().set(fwk507().rwk50201().fwk502Subconta().fwk502VChkdCont());
        fgh522().regFgh522().fgh522Subconta().fgh522CTipoCont().set(fwk507().rwk50201().fwk502Subconta().fwk502CTipoCont());
        fgh522().regFgh522().fgh522Subconta().fgh522CMoedIsoScta().set(fwk507().rwk50201().fwk502Subconta().fwk502CMoedIsoScta());
        fgh522().regFgh522().fgh522Subconta().fgh522NsDeposito().set(fwk507().rwk50201().fwk502Subconta().fwk502NsDeposito());
        fgh522().regFgh522().fgh522ZMovimento().set(fwk507().rwk50201().fwk502ZMovimento());
        fgh522().regFgh522().fgh522ZValMov().set(fwk507().rwk50201().fwk502ZValMov());
        fgh522().regFgh522().fgh522NsMovimento().set(fwk507().rwk50201().fwk502NsMovimento());
        fgh522().regFgh522().fgh522IDbcr().set(fwk507().rwk50201().fwk502IDbcr());
        fgh522().regFgh522().fgh522MMovimento().set(fwk507().rwk50201().fwk502MMovimento());
        fgh522().regFgh522().fgh522CMoedIsoOriMov().set(fwk507().rwk50201().fwk502CMoedIsoOriMov());
        fgh522().regFgh522().fgh522MMovMoeOrigMov().set(fwk507().rwk50201().fwk502MMovMoeOrigMov());
        fgh522().regFgh522().fgh522MSldoCbloApos().set(fwk507().rwk50201().fwk502MSldoCbloApos());
        fgh522().regFgh522().fgh522CEvenOpel().set(fwk507().rwk50201().fwk502CEvenOpel());
        fgh522().regFgh522().fgh522COeEgcOpex().set(fwk507().rwk50201().fwk502COeEgcOpex());
        fgh522().regFgh522().fgh522NDocOpps().set(fwk507().rwk50201().fwk502NDocOpps());
        fgh522().regFgh522().fgh522XRefMov().set(fwk507().rwk50201().fwk502XRefMov());
        fgh522().regFgh522().fgh522COpeBbn().set(fwk507().rwk50201().fwk502COpeBbn());
        fgh522().regFgh522().fgh522IEstorno().set(fwk507().rwk50201().fwk502IEstorno());
        fgh522().regFgh522().fgh522TCambio().set(fwk507().rwk50201().fwk502TCambio());
        fgh522().regFgh522().fgh522ChvFicheiro().set(fwk507().rwk50201().fwk502ChvFicheiro());
        fgh522().write(fgh522().regFgh522()) ;
        if (fgh522().getStatusOk()) {
            contRegEscrtFgh522.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FGH522 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fgh522().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Fim() {
        log(TraceLevel.Debug, "S50000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a51000CalculaTempoExecucao() ;
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impRegLidosFwk507().set(contRegLidosFwk507);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh512);
            tabelaImpressao().linha06().impFichEsc().set("FGH512");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh522);
            tabelaImpressao().linha06().impFichEsc().set("FGH522");
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC505A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
    }
    
    /**
     * 
     * 
     */
    protected void a40000FecharFicheiros() {
        log(TraceLevel.Debug, "A40000-FECHAR-FICHEIROS");
        fwk507().close() ;
        if (!fwk507().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FWK507 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk507().getStatus());
        }
        fgh512().close() ;
        if (!fgh512().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FGH512 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fgh512().getStatus());
        }
        fgh522().close() ;
        if (!fgh522().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC505A - FGH522 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fgh522().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000CalculaTempoExecucao() {
        log(TraceLevel.Debug, "A51000-CALCULA-TEMPO-EXECUCAO");
        bghw0300().wsVariaveisHora().horaFim().set(getTime()) ;
        /**
         * BOOK QUE CONTEM A ROTINA DE CALCULO DO TEMPO DE EXECUCAO
         * DO PROGRAMA
         */
        bghp0300() ;
        tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
        tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
        tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
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
            s30000Processar() ;
        }
        s50000Fim() ;
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
    public interface WsZAux extends IDataStruct {
        
        @Data(size=4)
        IInt anoAux() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt mesAux() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt diaAux() ;
        
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
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wResto() ;
            
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
            
            @Data(size=8, value="PGHC505A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC505A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK507")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk507() ;
            
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
            
            @Data(size=4, value=" ", lpadding=2, rpadding=58, lpaddingValue=" ", rpaddingValue=" ")
            IString impStatus() ;
            
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
