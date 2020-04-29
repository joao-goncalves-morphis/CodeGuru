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
import cgd.hj.structures.link.Bhjl001a ;


/**
 * 
 * FWK211 - FICHEIRO DOS MOVIMENTOS NOSVOS
 * FGH515 - FICHEIRO MENSAL NOSVOS PARA A DBR
 * FGH516 - FICHEIRO MENSAL NOSVOS PARA A DPI
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CONTROI FICHEIROS FGH515(DBR) E FGH516(DPI)
 * TERMINA PROCESSO GH00004
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq510a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    
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
     * @return instancia da classe Fwk211
     */
    @Handler(name="FWK211", record="regFwk211")
    @Data
    protected abstract Fwk211 fwk211() ;
    
    /**
     * @return instancia da classe Fgh515
     */
    @Handler(name="FGH515", record="regFgh515")
    @Data
    protected abstract Fgh515 fgh515() ;
    
    /**
     * @return instancia da classe Fgh516
     */
    @Handler(name="FGH516", record="regFgh516")
    @Data
    protected abstract Fgh516 fgh516() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhjl001a
     */
    @Data
    protected abstract Bhjl001a bhjl001a() ;
    
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
    protected IString swCrtlSair ;
    @Data
    @Condition("A")
    protected ICondition sair ;
    @Data
    @Condition("B")
    protected ICondition naoSair ;
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    /**
     * @return instancia da classe local WsRegisto
     */
    @Data
    protected abstract WsRegisto wsRegisto() ;
    
    /**
     * @return instancia da classe local WsChaveAnt
     */
    @Data
    protected abstract WsChaveAnt wsChaveAnt() ;
    
    /**
     * @return instancia da classe local WsChave
     */
    @Data
    protected abstract WsChave wsChave() ;
    
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
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk211 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh515 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh516 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ510A");
        progOk.setTrue() ;
        wTimestamp().wTimerTimestamp().wDd().set(0);
        wsChaveAnt().initialize() ;
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
            a14000AbrirFwk211() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk211() ;
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
        fgh515().open(CREATE ) ;
        if (!fgh515().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ510A - FGH515 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh515().getStatus());
        }
        fgh516().open(CREATE ) ;
        if (!fgh516().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ510A - FGH516 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh516().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk211() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK211");
        fwk211().open() ;
        if (!fwk211().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ510A - FWK211 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk211().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk211() {
        log(TraceLevel.Debug, "A15000-LER-FWK211");
        fwk211().read() ;
        if (fwk211().getStatusOk()) {
            contRegLidosFwk211.add(1);
            wsChave().wsCPaisIsoaCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CPaisIsoaCont());
            wsChave().wsCBancCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CBancCont());
            wsChave().wsCOeEgcCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211COeEgcCont());
            wsChave().wsNsRdclCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsRdclCont());
            wsChave().wsVChkdCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211VChkdCont());
            wsChave().wsCTipoCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CTipoCont());
            wsChave().wsCMoedIsoScta().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CMoedIsoScta());
            wsChave().wsNsDeposito().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsDeposito());
            wsChave().wsCPedInfOpps().set(fwk211().regFwk211().fwk211Pedido().fwk211CPedInfOpps());
            wsChave().wsZInicMov().set(fwk211().regFwk211().fwk211Pedido().fwk211ZInicMov());
            wsChave().wsZFimMov().set(fwk211().regFwk211().fwk211Pedido().fwk211ZFimMov());
        }
        if (!fwk211().getStatusOk() && !fwk211().getStatusOk() && 
            !fwk211().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK211 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk211().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarRegisto() ;
        switch (fwk211().regFwk211().fwk211Pedido().fwk211CEndcFtpDest().get(1, 3).get()) {
            case "DCR":
                a31000TratarFgh515() ;
                break;
            case "DPI":
                a32000TratarFgh516() ;
                break;
            default :
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ510A - NAO EXISTE INF DE ENDERECO");
                break;
        }
        if (progOk.isTrue()) {
            a15000LerFwk211() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarRegisto() {
        log(TraceLevel.Debug, "A31000-TRATAR-REGISTO");
        wsRegisto().initialize() ;
        wsRegisto().waCPaisIsoaCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CPaisIsoaCont());
        wsRegisto().waCBancCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CBancCont());
        wsRegisto().waCOeEgcCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211COeEgcCont());
        wsRegisto().waNsRdclCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsRdclCont());
        wsRegisto().waVChkdCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211VChkdCont());
        wsRegisto().waCTipoCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CTipoCont());
        wsRegisto().waCMoedIsoScta().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CMoedIsoScta());
        wsRegisto().waNsDeposito().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsDeposito());
        wsRegisto().waTsMovimento().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211TsMovimento());
        wsRegisto().waNsMovimento().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsMovimento());
        wsRegisto().waZValMov().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211ZValMov());
        wsRegisto().waZMovLocl().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211ZMovLocl());
        wsRegisto().waIDbcr().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211IDbcr());
        wsRegisto().waMMovimento().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MMovimento());
        wsRegisto().waMMovMoeOrigMov().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MMovMoeOrigMov());
        wsRegisto().waSMovimento().set("+");
        wsRegisto().waSMovMoeOrigMov().set("+");
        if (wsRegisto().waIEstorno().isEmpty()) {
            if (wsRegisto().waIDbcr().isEqual("D")) {
                wsRegisto().waSMovimento().set("-");
                wsRegisto().waSMovMoeOrigMov().set("-");
            }
        } else if (wsRegisto().waIDbcr().isEqual("C")) {
            wsRegisto().waSMovimento().set("-");
            wsRegisto().waSMovMoeOrigMov().set("-");
        }
        wsRegisto().waIEstorno().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211IEstorno());
        wsRegisto().waCMoedIsoOriMov().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CMoedIsoOriMov());
        wsRegisto().waMSldoCbloApos().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MSldoCbloApos());
        wsRegisto().waSSldoCbloApos().set("+");
        if (fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MSldoCbloApos().isLess(0)) {
            wsRegisto().waSSldoCbloApos().set("-");
        }
        wsRegisto().waMSldoDpnlApos().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MSldoDpnlApos());
        wsRegisto().waSSldoDpnlApos().set("+");
        if (fwk211().regFwk211().fwk211FicheiroFgh515().fwk211MSldoDpnlApos().isLess(0)) {
            wsRegisto().waSSldoDpnlApos().set("-");
        }
        wsRegisto().waXRefMov().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211XRefMov());
        wsRegisto().waNDocOpps().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NDocOpps());
        wsRegisto().waTJuro().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211TJuro());
        wsRegisto().waAAplOrig().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211AAplOrig());
        wsRegisto().waTsActzUlt().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211TsActzUlt());
        wsRegisto().waCUsidActzUlt().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CUsidActzUlt());
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarFgh515() {
        log(TraceLevel.Debug, "A31000-TRATAR-FGH515");
        fgh515().regFgh515().initialize() ;
        fgh515().setRecord(wsRegisto()) ;
        fgh515().write(fgh515().regFgh515()) ;
        if (fgh515().getStatusOk()) {
            contRegEscrtFgh515.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ210A - FGH515 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh515().getStatus());
        }
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                a31200ActPedido() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000TratarFgh516() {
        log(TraceLevel.Debug, "A32000-TRATAR-FGH516");
        fgh516().regFgh516().initialize() ;
        fgh516().setRecord(wsRegisto()) ;
        fgh516().write(fgh516().regFgh516()) ;
        if (fgh516().getStatusOk()) {
            contRegEscrtFgh516.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ210A - FGH516 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh516().getStatus());
        }
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                a31200ActPedido() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200ActPedido() {
        log(TraceLevel.Debug, "A31200-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk211().regFwk211().fwk211FicheiroFgh515().fwk211NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk211().regFwk211().fwk211Pedido().fwk211CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk211().regFwk211().fwk211Pedido().fwk211ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk211().regFwk211().fwk211Pedido().fwk211ZFimMov());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq510a667() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            wsChaveAnt().set(wsChave());
        } else {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("- UPDATE VGH01501 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
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
            tabelaImpressaoMask().zimp().setIndex(5) ;
            tabelaImpressao().linha05().impFichRead().set("FWK211");
            tabelaImpressao().linha05().impRegRead().set(contRegLidosFwk211);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("FGH515");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh515);
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ510A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk211().close() ;
        fgh515().close() ;
        fgh516().close() ;
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
            while (!fwk211().getStatusOk() && !sair.isTrue() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsRegisto extends IDataStruct {
        
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
        
        @Data(size=26)
        IString waTsMovimento() ;
        
        @Data(size=15)
        ILong waNsMovimento() ;
        
        @Data(size=10)
        IString waZValMov() ;
        
        @Data(size=10)
        IString waZMovLocl() ;
        
        @Data(size=1)
        IString waIDbcr() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMMovimento() ;
        
        @Data(size=1)
        IString waSMovimento() ;
        
        @Data(size=1)
        IString waIEstorno() ;
        
        @Data(size=3)
        IString waCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMSldoCbloApos() ;
        
        @Data(size=1)
        IString waSSldoCbloApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMSldoDpnlApos() ;
        
        @Data(size=1)
        IString waSSldoDpnlApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMMovMoeOrigMov() ;
        
        @Data(size=1)
        IString waSMovMoeOrigMov() ;
        
        @Data(size=21)
        IString waXRefMov() ;
        
        @Data(size=10)
        ILong waNDocOpps() ;
        
        @Data(size=10, decimal=7)
        IDecimal waTJuro() ;
        
        @Data(size=2)
        IString waAAplOrig() ;
        
        @Data(size=26)
        IString waTsActzUlt() ;
        
        @Data(size=8)
        IString waCUsidActzUlt() ;
        
    }
    public interface WsChaveAnt extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaContAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancContAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcContAnt() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclContAnt() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdContAnt() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoContAnt() ;
        
        @Data(size=3)
        IString wsCMoedIsoSctaAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDepositoAnt() ;
        
        @Data(size=7)
        IString wsCPedInfOppsAnt() ;
        
        @Data(size=10)
        IString wsZInicMovAnt() ;
        
        @Data(size=10)
        IString wsZFimMovAnt() ;
        
    }
    public interface WsChave extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3)
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDeposito() ;
        
        @Data(size=7)
        IString wsCPedInfOpps() ;
        
        @Data(size=10)
        IString wsZInicMov() ;
        
        @Data(size=10)
        IString wsZFimMov() ;
        
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
            
            @Data(size=8, value="PGHQ510A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ510A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS     ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegRead() ;
            
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
