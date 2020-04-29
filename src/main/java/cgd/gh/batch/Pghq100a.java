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
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.structures.work.Bghw0503 ;
import cgd.hy.structures.link.Bhyl230a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.TRATAR MOVIMENTOS DE 2008 A ENVIAR PARA
 * FWK007(INPUT1) CRIADO NO PROGRAMA PGHQ200A
 * 2.CRIA OS FICHEIROS FWK201, FWK301, FWK401,
 * FWK501, FWK601, FWK701
 * ALTERACOES:   1.ALIMENTAR OS NOVOS CAMPOS DO BOOK BGHW8200
 * GIP:GH385
 * ALTERACOES    : FORMATA SEGUNDA REFERENCIA EM FWK201
 * GIP:GH776 ! AUTOR:DACT685 ! DATA:2012-01-09
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq100a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00801Refmcbl
     */
    @Data
    protected abstract Vwsdghps00801Refmcbl hv00801Refmcbl() ;
    
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
     * @return instancia da classe Fwk00302
     */
    @Handler(name="FWK003", record="rgh00301")
    @Data
    protected abstract Fwk00302 fgh003() ;
    
    /**
     * @return instancia da classe Fwk20102
     */
    @Handler(name="FWK201", record="regFwk201286")
    @Data
    protected abstract Fwk20102 fwk201() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0503
     */
    @Data
    protected abstract Bghw0503 bghw0503() ;
    
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
    protected IString swCrtlConta ;
    @Data
    @Condition("3")
    protected ICondition swContaIgual ;
    @Data
    @Condition("4")
    protected ICondition swContaDiferente ;
    
    
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
    
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString wsMghj801a ;
    
    @Data(size=8, value="MGHK800A")
    protected IString wsMghk800a ;
    
    /**
     * @return instancia da classe local WsChaveAnt
     */
    @Data
    protected abstract WsChaveAnt wsChaveAnt() ;
    
    /**
     * @return instancia da classe local WsSysin
     */
    @Data
    protected abstract WsSysin wsSysin() ;
    
    /**
     * @return instancia da classe local WsChaveFgh003
     */
    @Data
    protected abstract WsChaveFgh003 wsChaveFgh003() ;
    
    /**
     * @return instancia da classe local WsInput1
     */
    @Data
    protected abstract WsInput1 wsInput1() ;
    
    /**
     * @return instancia da classe local WsFgh003
     */
    @Data
    protected abstract WsFgh003 wsFgh003() ;
    
    @Data(size=2, signed=true, value="0")
    protected IInt wContador ;
    @Data
    @Condition("3")
    protected ICondition terceiraVez ;
    @Data
    @Condition("4")
    protected ICondition sair ;
    
    
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
    protected ILong contRegLidosFgh003 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk201 ;
    
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
        /**
         * *----------------------------------------------------------------*
         * SET SW-DEBUG-ON TO TRUE
         * SET SW-DEBUG-OFF TO TRUE
         */
        wsSysin().set(getDate()) ;
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ100A");
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
            a14000LerFgh003() ;
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
        fgh003().open() ;
        if (!fgh003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ100A - FGH003 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fgh003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000AbrirFichOutput() {
        log(TraceLevel.Debug, "A12000-ABRIR-FICH-OUTPUT");
        fwk201().open(CREATE ) ;
        if (!fwk201().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ100A - FWK201 - OPEN - ");
            tabelaImpressao().linha11().impStatus().set(fwk201().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000LerFgh003() {
        log(TraceLevel.Debug, "A14000-LER-FGH003");
        fgh003().read() ;
        if (fgh003().getStatusOk()) {
            contRegLidosFgh003.add(1);
            wsChaveFgh003().wsChvPrincFgh003().wsCPaisIsoaContFgh003().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
            wsFgh003().wsCPaisIsoaContD003().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCBancContFgh003().set(fgh003().rgh00301().fgh003CBancCont());
            wsFgh003().wsCBancContD003().set(fgh003().rgh00301().fgh003CBancCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCOeEgcContFgh003().set(fgh003().rgh00301().fgh003COeEgcCont());
            wsFgh003().wsCOeEgcContD003().set(fgh003().rgh00301().fgh003COeEgcCont());
            wsChaveFgh003().wsChvPrincFgh003().wsNsRdclContFgh003().set(fgh003().rgh00301().fgh003NsRdclCont());
            wsFgh003().wsNsRdclContD003().set(fgh003().rgh00301().fgh003NsRdclCont());
            wsChaveFgh003().wsChvPrincFgh003().wsVChkdContFgh003().set(fgh003().rgh00301().fgh003VChkdCont());
            wsFgh003().wsVChkdContD003().set(fgh003().rgh00301().fgh003VChkdCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCTipoContFgh003().set(fgh003().rgh00301().fgh003CTipoCont());
            wsFgh003().wsCTipoContD003().set(fgh003().rgh00301().fgh003CTipoCont());
            wsChaveFgh003().wsChvPrincFgh003().wsCMoedIsoSctaFgh003().set(fgh003().rgh00301().fgh003CMoedIsoScta());
            wsFgh003().wsCMoedIsoSctaD003().set(fgh003().rgh00301().fgh003CMoedIsoScta());
            wsChaveFgh003().wsChvPrincFgh003().wsNsDepositoFgh003().set(fgh003().rgh00301().fgh003NsDeposito());
            wsFgh003().wsNsDepositoD003().set(fgh003().rgh00301().fgh003NsDeposito());
            wsChaveFgh003().wsChvSecFgh003().wsTsMovimentoFgh003().set(fgh003().rgh00301().fgh003TsMovimento());
            wsFgh003().wsTsMovimentoD003().set(fgh003().rgh00301().fgh003TsMovimento());
            wsChaveFgh003().wsChvSecFgh003().wsNsMovimentoFgh003().set(fgh003().rgh00301().fgh003NsMovimento());
            wsFgh003().wsNsMovimentoD003().set(fgh003().rgh00301().fgh003NsMovimento());
        }
        if (!fgh003().getStatusOk() && !fgh003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ100A - FGH003 - READ - ");
            tabelaImpressao().linha11().impStatus().set(fgh003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        while (!fgh003().getStatusOk() && progOk.isTrue()) {
            a31000TratarMovimentos() ;
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
            tabelaImpressao().linha06().impRegLidosFgh003().set(contRegLidosFgh003);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(7); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha08().impFichEsc().set("FWK201");
            tabelaImpressao().linha08().impRegEscrt().set(contRegEscrtFwk201);
            tabelaImpressaoMask().zimp().setIndex(8) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha09().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha09().impReturnCode().set(returnCode);
            tabelaImpressao().linha10().impMens1().set("PGHQ100A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(12); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fgh003().close() ;
        fwk201().close() ;
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
    protected void a31000TratarMovimentos() {
        log(TraceLevel.Debug, "A31000-TRATAR-MOVIMENTOS");
        log(TraceLevel.Debug, "WS-TS-MOVIMENTO-FGH003:", wsChaveFgh003().wsChvSecFgh003().wsTsMovimentoFgh003().get(1, 10));
        log(TraceLevel.Debug, "WS-DT-INI-SYS:", wsSysin().wsDtIniSys());
        log(TraceLevel.Debug, "WS-DT-FIM-SYS:", wsSysin().wsDtFimSys());
        if (wsChaveFgh003().wsChvSecFgh003().wsTsMovimentoFgh003().get(1, 10).isGreaterOrEqual(wsSysin().wsDtIniSys()) && 
            wsChaveFgh003().wsChvSecFgh003().wsTsMovimentoFgh003().get(1, 10).isLessOrEqual(wsSysin().wsDtFimSys())) {
            a34000EscreveFwk201() ;
        }
        if (progOk.isTrue()) {
            a14000LerFgh003() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreveFwk201() {
        log(TraceLevel.Debug, "A34000-ESCREVE-FWK201");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(fgh003().rgh00301().fgh003CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(fgh003().rgh00301().fgh003CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fgh003().rgh00301().fgh003COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(fgh003().rgh00301().fgh003NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(fgh003().rgh00301().fgh003VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(fgh003().rgh00301().fgh003CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(fgh003().rgh00301().fgh003CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(fgh003().rgh00301().fgh003NsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(fgh003().rgh00301().fgh003TsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(fgh003().rgh00301().fgh003NsMovimento());
        hv00201Movhst().movhst().zValMov().set(fgh003().rgh00301().fgh003ZValMov());
        hv00201Movhst().movhst().zMovLocl().set(fgh003().rgh00301().fgh003ZMovLocl());
        hv00201Movhst().movhst().iDbcr().set(fgh003().rgh00301().fgh003IDbcr());
        hv00201Movhst().movhst().mMovimento().set(fgh003().rgh00301().fgh003MMovimento());
        hv00201Movhst().movhst().iEstorno().set(fgh003().rgh00301().fgh003IEstorno());
        hv00201Movhst().movhst().cMoedIsoOriMov().set(fgh003().rgh00301().fgh003CMoedIsoOriMov());
        hv00201Movhst().movhst().mSldoCbloApos().set(fgh003().rgh00301().fgh003MSldoCbloApos());
        hv00201Movhst().movhst().mSldoDpnlApos().set(fgh003().rgh00301().fgh003MSldoDpnlApos());
        hv00201Movhst().movhst().mMovMoeOrigMov().set(fgh003().rgh00301().fgh003MMovMoeOrigMov());
        hv00201Movhst().movhst().xRefMov().set(fgh003().rgh00301().fgh003XRefMov());
        /**
         * IF VGH00201-X-REF-MOV     EQUAL SPACES OR LOW-VALUES
         * PERFORM A32100-BUSCA-DESCRICAO
         * MOVE MGH800A-X-REF-MOV   TO VGH00201-X-REF-MOV
         * END-IF
         */
        hv00201Movhst().movhst().nDocOpps().set(fgh003().rgh00301().fgh003NDocOpps());
        hv00201Movhst().movhst().tJuro().set(fgh003().rgh00301().fgh003TJuro());
        hv00201Movhst().movhst().aAplOrig().set(fgh003().rgh00301().fgh003AAplOrig());
        hv00201Movhst().movhst().tsActzUlt().set(fgh003().rgh00301().fgh003TsActzUlt());
        hv00201Movhst().movhst().cUsidActzUlt().set(fgh003().rgh00301().fgh003CUsidActzUlt());
        fwk201().write(fwk201().regFwk201286) ;
        if (fwk201().getStatusOk()) {
            contRegEscrtFwk201.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha11().msgStatus().set("PGHQ100A - FWK201 - WRITE   - ");
            tabelaImpressao().linha11().impStatus().set(fwk201().getStatus());
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
    public interface WsChaveAnt extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvPrincAnt
         */
        @Data
        WsChvPrincAnt wsChvPrincAnt() ;
        
        /**
         * @return instancia da classe local WsChvSecAnt
         */
        @Data
        WsChvSecAnt wsChvSecAnt() ;
        
        
        public interface WsChvPrincAnt extends IDataStruct {
            
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
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsNsDepositoAnt() ;
            
        }
        
        public interface WsChvSecAnt extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsZInicMovAnt() ;
            
            @Data(size=10, value=" ")
            IString wsZFimMovAnt() ;
            
        }
    }
    public interface WsSysin extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString wsDebugSys() ;
        
        @Data(size=10, value=" ")
        IString wsDtIniSys() ;
        
        @Data(size=10, value=" ")
        IString wsDtFimSys() ;
        
    }
    public interface WsChaveFgh003 extends IDataStruct {
        
        /**
         * @return instancia da classe local WsChvPrincFgh003
         */
        @Data
        WsChvPrincFgh003 wsChvPrincFgh003() ;
        
        /**
         * @return instancia da classe local WsChvSecFgh003
         */
        @Data
        WsChvSecFgh003 wsChvSecFgh003() ;
        
        
        public interface WsChvPrincFgh003 extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaContFgh003() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancContFgh003() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcContFgh003() ;
            
            @Data(size=7, signed=true, value="0", compression=COMP3)
            IInt wsNsRdclContFgh003() ;
            
            @Data(size=1, signed=true, value="0", compression=COMP3)
            IInt wsVChkdContFgh003() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt wsCTipoContFgh003() ;
            
            @Data(size=3, value=" ")
            IString wsCMoedIsoSctaFgh003() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsNsDepositoFgh003() ;
            
        }
        
        public interface WsChvSecFgh003 extends IDataStruct {
            
            @Data(size=26, value=" ")
            IString wsTsMovimentoFgh003() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong wsNsMovimentoFgh003() ;
            
        }
    }
    public interface WsInput1 extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaContD315() ;
        
        @Data(size=4, value="0")
        IInt wsCBancContD315() ;
        
        @Data(size=4, value="0")
        IInt wsCOeEgcContD315() ;
        
        @Data(size=7, value="0")
        IInt wsNsRdclContD315() ;
        
        @Data(size=1, value="0")
        IInt wsVChkdContD315() ;
        
        @Data(size=3, value="0")
        IInt wsCTipoContD315() ;
        
        @Data(size=3, value=" ")
        IString wsCMoedIsoSctaD315() ;
        
        @Data(size=4, value="0")
        IInt wsNsDepositoD315() ;
        
        @Data(size=10, value=" ")
        IString wsZInicMovD315() ;
        
        @Data(size=10, value=" ")
        IString wsZFimMovD315() ;
        
    }
    public interface WsFgh003 extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString wsCPaisIsoaContD003() ;
        
        @Data(size=4, value="0")
        IInt wsCBancContD003() ;
        
        @Data(size=4, value="0")
        IInt wsCOeEgcContD003() ;
        
        @Data(size=7, value="0")
        IInt wsNsRdclContD003() ;
        
        @Data(size=1, value="0")
        IInt wsVChkdContD003() ;
        
        @Data(size=3, value="0")
        IInt wsCTipoContD003() ;
        
        @Data(size=3, value=" ")
        IString wsCMoedIsoSctaD003() ;
        
        @Data(size=4, value="0")
        IInt wsNsDepositoD003() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimentoD003() ;
        
        @Data(size=15, value="0")
        ILong wsNsMovimentoD003() ;
        
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
         * @return instancia da classe local Linha06
         */
        @Data
        Linha06 linha06() ;
        
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
            
            @Data(size=8, value="PGHQ100A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ100A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FGH003")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFgh003() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS ESCRITOS EM ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
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
        
        @Data(length=9, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
