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
 * FWK003 - HISTORICO DE MOVIMENTOS
 * - INFORMACAO PRINCIPAL
 * FWK101 - FICHEIRO PARA ACTUALIZACAO DA TGH010
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.ACERTAR A TABELA TGH010 COM OS MOVIMENTOS
 * ALTERACOES:
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc916a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk00303
     */
    @Handler(name="FWK003", record="rgh00301")
    @Data
    protected abstract Fwk00303 fwk003() ;
    
    /**
     * @return instancia da classe Fwk101
     */
    @Handler(name="FWK101", record="rgh01001")
    @Data
    protected abstract Fwk101 fwk101() ;
    
    
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
    
    
    @Data(size=1)
    protected IString swCrtlConta ;
    @Data
    @Condition("3")
    protected ICondition mudouConta ;
    
    
    @Data(size=4, value="0")
    protected IInt wsAnoMin ;
    
    @Data(size=4, value="0")
    protected IInt wsAnoMax ;
    
    /**
     * @return instancia da classe local WsChaveAnt
     */
    @Data
    protected abstract WsChaveAnt wsChaveAnt() ;
    
    /**
     * @return instancia da classe local WsChaveLida
     */
    @Data
    protected abstract WsChaveLida wsChaveLida() ;
    
    /**
     * @return instancia da classe local WsChaveEsc
     */
    @Data
    protected abstract WsChaveEsc wsChaveEsc() ;
    
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
    
    @Data(size=26, value=" ")
    protected IString wsTsMovFim ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovInicio ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk003 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk101 ;
    
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
        bghw0300().wsNmPrograma().set("PGHC916A");
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
            a11000AbrirFichInput() ;
        }
        if (progOk.isTrue()) {
            a12000AbrirFichOutput() ;
        }
        if (progOk.isTrue()) {
            a14000LerFwk003() ;
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
    protected void a11000AbrirFichInput() {
        log(TraceLevel.Debug, "A11000-ABRIR-FICH-INPUT");
        fwk003().open() ;
        if (!fwk003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC916A - FWK003 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000AbrirFichOutput() {
        log(TraceLevel.Debug, "A12000-ABRIR-FICH-OUTPUT");
        fwk101().open(CREATE ) ;
        if (!fwk101().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC916A - FWK101 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk101().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000LerFwk003() {
        log(TraceLevel.Debug, "A14000-LER-FWK003");
        fwk003().read() ;
        if (fwk003().getStatusOk()) {
            contRegLidosFwk003.add(1);
            wsChaveLida().wsChvLida().wsCPaisIsoaCont().set(fwk003().rgh00301().fgh003CPaisIsoaCont());
            wsChaveLida().wsChvLida().wsCBancCont().set(fwk003().rgh00301().fgh003CBancCont());
            wsChaveLida().wsChvLida().wsCOeEgcCont().set(fwk003().rgh00301().fgh003COeEgcCont());
            wsChaveLida().wsChvLida().wsNsRdclCont().set(fwk003().rgh00301().fgh003NsRdclCont());
            wsChaveLida().wsChvLida().wsVChkdCont().set(fwk003().rgh00301().fgh003VChkdCont());
            wsChaveLida().wsChvLida().wsCTipoCont().set(fwk003().rgh00301().fgh003CTipoCont());
            wsChaveLida().wsChvLida().wsCMoedIsoScta().set(fwk003().rgh00301().fgh003CMoedIsoScta());
            wsChaveLida().wsChvLida().wsNsDeposito().set(fwk003().rgh00301().fgh003NsDeposito());
            wsChaveLida().wsChvAno().wsZaMov().set(fwk003().rgh00301().fgh003TsMovimento().get(1, 4));
            if (contRegLidosFwk003.isEqual(1)) {
                wsAnoMin.set(wsChaveLida().wsChvAno().wsZaMov());
                wsAnoMax.set(wsChaveLida().wsChvAno().wsZaMov());
                wsChaveAnt().wsChvAnt().set(wsChaveLida().wsChvLida());
            } else if (wsChaveLida().wsChvLida().isEqual(wsChaveAnt().wsChvAnt())) {
                wsAnoMax.set(wsChaveLida().wsChvAno().wsZaMov());
            } else {
                mudouConta.setTrue() ;
            }
        } else if (fwk003().getStatusOk()) {
            if (!contRegLidosFwk003.isEqual(0)) {
                if (!wsChaveLida().wsChvLida().isEqual(wsChaveEsc().wsChvEsc())) {
                    a31000EscreverFwk101() ;
                }
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC916A - FWK003 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (mudouConta.isTrue()) {
            a31000EscreverFwk101() ;
            if (progOk.isTrue()) {
                wsAnoMin.set(wsChaveLida().wsChvAno().wsZaMov());
                wsAnoMax.set(wsChaveLida().wsChvAno().wsZaMov());
                wsChaveAnt().wsChvAnt().set(wsChaveLida().wsChvLida());
                swCrtlConta.set(" ");
            }
        }
        if (progOk.isTrue()) {
            while (!mudouConta.isTrue() && !fwk003().getStatusOk() && progOk.isTrue()) {
                a14000LerFwk003() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000EscreverFwk101() {
        log(TraceLevel.Debug, "A31000-ESCREVER-FWK101");
        fwk101().rgh01001().initialize() ;
        fwk101().rgh01001().fgh010CPaisIsoaCont().set(wsChaveAnt().wsChvAnt().wsCPaisIsoaContAnt());
        fwk101().rgh01001().fgh010CBancCont().set(wsChaveAnt().wsChvAnt().wsCBancContAnt());
        fwk101().rgh01001().fgh010COeEgcCont().set(wsChaveAnt().wsChvAnt().wsCOeEgcContAnt());
        fwk101().rgh01001().fgh010NsRdclCont().set(wsChaveAnt().wsChvAnt().wsNsRdclContAnt());
        fwk101().rgh01001().fgh010VChkdCont().set(wsChaveAnt().wsChvAnt().wsVChkdContAnt());
        fwk101().rgh01001().fgh010CTipoCont().set(wsChaveAnt().wsChvAnt().wsCTipoContAnt());
        fwk101().rgh01001().fgh010CMoedIsoScta().set(wsChaveAnt().wsChvAnt().wsCMoedIsoSctaAnt());
        fwk101().rgh01001().fgh010NsDeposito().set(wsChaveAnt().wsChvAnt().wsNsDepositoAnt());
        fwk101().rgh01001().fgh010NmRecurso().set("VGH00201");
        fwk101().rgh01001().fgh010CTipoInfHist().set("P");
        fwk101().rgh01001().fgh010ZaInicio().set(wsAnoMin);
        fwk101().rgh01001().fgh010ZaFim().set(wsAnoMax);
        fwk101().rgh01001().fgh010TsActzUlt().set(wTimestamp());
        fwk101().rgh01001().fgh010CUsidActzUlt().set("PGHC916A");
        fwk101().write(fwk101().rgh01001()) ;
        if (fwk101().getStatusOk()) {
            contRegEscrtFwk101.add(1);
            wsChaveEsc().set(wsChaveAnt());
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC916A - FWK101 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk101().getStatus());
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
            tabelaImpressao().linha05().impRegLidosFwk003().set(contRegLidosFwk003);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FWK101");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk101);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC916A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(11); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk003().close() ;
        fwk101().close() ;
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
         * *-----------------------------------------------------------------
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
    public interface WsChaveAnt extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvAnt
         */
        @Data
        WsChvAnt wsChvAnt() ;
        
        /**
         * @return instancia da classe local WsChvAnoAnt
         */
        @Data
        WsChvAnoAnt wsChvAnoAnt() ;
        
        
        public interface WsChvAnt extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaContAnt() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancContAnt() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcContAnt() ;
            
            @Data(size=7, signed=true, value="0", compression=COMP3)
            IInt wsNsRdclContAnt() ;
            
            @Data(size=1, signed=true, value="0", compression=COMP3)
            IInt wsVChkdContAnt() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt wsCTipoContAnt() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedIsoSctaAnt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsNsDepositoAnt() ;
            
        }
        
        public interface WsChvAnoAnt extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsZaMovAnt() ;
            
        }
    }
    public interface WsChaveLida extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvLida
         */
        @Data
        WsChvLida wsChvLida() ;
        
        /**
         * @return instancia da classe local WsChvAno
         */
        @Data
        WsChvAno wsChvAno() ;
        
        
        public interface WsChvLida extends IDataStruct {
            
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
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsNsDeposito() ;
            
        }
        
        public interface WsChvAno extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsZaMov() ;
            
        }
    }
    public interface WsChaveEsc extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvEsc
         */
        @Data
        WsChvEsc wsChvEsc() ;
        
        
        public interface WsChvEsc extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaContEsc() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancContEsc() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcContEsc() ;
            
            @Data(size=7, signed=true, value="0", compression=COMP3)
            IInt wsNsRdclContEsc() ;
            
            @Data(size=1, signed=true, value="0", compression=COMP3)
            IInt wsVChkdContEsc() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt wsCTipoContEsc() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedIsoSctaEsc() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt wsNsDepositoEsc() ;
            
        }
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
            
            @Data(size=8, value="PGHC916A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC916A")
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
