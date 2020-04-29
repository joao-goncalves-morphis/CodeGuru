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
import cgd.hg.routines.Mhgj960a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.FICHEIRO MENSAL DE PAGAMENTOS DA TSU - FGH504
 * ENVIADO POR CONNECT DIRECT PARA A DBI
 * 2.O FICHEIRO DE INPUT FWK506(FWK505 ORDENADO)
 * E GERADO NO PROGRAMA PGHQ504A
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc504a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk506
     */
    @Handler(name="FWK506", record="regFwk505")
    @Data
    protected abstract Fwk506 fwk506() ;
    
    /**
     * @return instancia da classe Fgh504
     */
    @Handler(name="FGH504", record="regFgh504")
    @Data
    protected abstract Fgh504 fgh504() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhgj960a
     */
    @Data
    protected abstract Mhgj960a hrMhgj960a() ;
    
    
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
    
    
    @Data(size=3, value="TSU")
    protected IString wsProtocoloTsu ;
    
    @Data(size=4)
    protected IString swCProtoc ;
    @Data
    @Condition({ "TSUC", "TSUM", "TSUA" })
    protected ICondition swProtocCma ;
    @Data
    @Condition("TSUT")
    protected ICondition swProtocT ;
    
    
    /**
     * @return instancia da classe local WsCProtoc
     */
    @Data
    protected abstract WsCProtoc wsCProtoc() ;
    
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
    
    
    /**
     * @return instancia da classe local WsContaAnt
     */
    @Data
    protected abstract WsContaAnt wsContaAnt() ;
    
    /**
     * @return instancia da classe local WsContaFwk506
     */
    @Data
    protected abstract WsContaFwk506 wsContaFwk506() ;
    
    @Data(size=7)
    protected IInt wsQDiasMes ;
    
    @Data(size=10)
    protected IString wsZDataMax ;
    
    @Data(size=10)
    protected IString wsZMovimentoAnt ;
    
    @Data(size=3, value="PTU")
    protected IString conPtu ;
    
    @Data(size=3, value="RTU")
    protected IString conRtu ;
    
    @Data(size=3, value="DEP")
    protected IString conDep ;
    
    @Data(size=3, value="REP")
    protected IString conRep ;
    
    @Data(size=7)
    protected IInt wsQuantPtu ;
    
    @Data(size=7)
    protected IInt wsQuantRtu ;
    
    @Data(size=7)
    protected IInt wsQuantDep ;
    
    @Data(size=7)
    protected IInt wsQuantRep ;
    
    @Data(size=3)
    protected IString wsDescMov ;
    
    /**
     * @return instancia da classe local WsContaTsuc
     */
    @Data
    protected abstract WsContaTsuc wsContaTsuc() ;
    
    /**
     * @return instancia da classe local WsContaTsua
     */
    @Data
    protected abstract WsContaTsua wsContaTsua() ;
    
    /**
     * @return instancia da classe local WsContaTsum
     */
    @Data
    protected abstract WsContaTsum wsContaTsum() ;
    
    /**
     * @return instancia da classe local WsContaTsut
     */
    @Data
    protected abstract WsContaTsut wsContaTsut() ;
    
    /**
     * @return instancia da classe local TabInterna
     */
    @Data
    protected abstract TabInterna tabInterna() ;
    
    @Data(size=1)
    protected IString dfheiblk ;
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(format="+ZZ9")
    protected IFormattedString wsCRtnoEvenSwal ;
    
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
     * @return instancia da classe local WsZAProcessar
     */
    @Data
    protected abstract WsZAProcessar wsZAProcessar() ;
    
    @Data(size=2, value="0")
    protected IInt wsDiaProcessamento ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegReadFwk506 ;
    
    @Data(size=5, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFgh504 ;
    
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
        wsQuantPtu.initialize() ;
        wsQuantRtu.initialize() ;
        wsQuantDep.initialize() ;
        wsQuantRep.initialize() ;
        tabInterna().initialize() ;
        bghw0300().wsNmPrograma().set("PGHC504A");
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
            a13000AbrirFgh504() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk506() ;
        }
        if (progOk.isTrue()) {
            a15000BuscaProtocolo() ;
        }
        if (progOk.isTrue()) {
            while (!hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cPaisIsoaCont().isEmpty()) {
                a15100ObtemContasProt() ;
            }
        }
        if (progOk.isTrue()) {
            a16000LerFwk506() ;
        }
        if (progOk.isTrue()) {
            wsContaAnt().wsCPaisAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505CPaisIsoaCont());
            wsContaAnt().wsCBancAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505CBancCont());
            wsContaAnt().wsCOeAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505COeEgcCont());
            wsContaAnt().wsNsRdclAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505NsRdclCont());
            wsContaAnt().wsVChkdAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505VChkdCont());
            wsContaAnt().wsCTipoAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505CTipoCont());
            wsZMovimentoAnt.set(fwk506().regFwk505().fwk505ZMovimento());
            tabInterna().wsTabInterna().resetIndex() ;
            while (wsDiaProcessamento.isLessOrEqual(wsQDiasMes)) {
                a16100InicializaTi() ;
            }
            wsDiaProcessamento.set(1);
            wsZAProcessar().wsDiaProcessar().set(wsDiaProcessamento);
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
    protected void a13000AbrirFgh504() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH504");
        fgh504().open(CREATE ) ;
        if (!fgh504().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC504A - FGH504 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh504().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk506() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK506");
        fwk506().open() ;
        if (!fwk506().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC504A - FWK506 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk506().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000BuscaProtocolo() {
        log(TraceLevel.Debug, "A15000-BUSCA-PROTOCOLO");
        hrMhgj960a().bhgl960a().commarea().initialize() ;
        hrMhgj960a().bhgl960a().commarea().dadosInput().cProtContI().set(wsProtocoloTsu);
        hrMhgj960a().run() ;
        if (!hrMhgj960a().bhgl960a().commarea().dadosOutput().semErros().isTrue()) {
            if (hrMhgj960a().bhgl960a().commarea().dadosOutput().dadosNotfnd().isTrue()) {
                hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().resetIndex() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().get(1, 21).set("PGHC504A - MHGJ960A -") ;
                wSqlcode.set(hrMhgj960a().bhgl960a().commarea().dadosOutput().cSqlcode());
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
                wsCRtnoEvenSwal.set(hrMhgj960a().bhgl960a().commarea().dadosOutput().cRtnoEvenSwal());
                tabelaImpressao().linha09().msgStatus().get(22, 4).set(wsCRtnoEvenSwal) ;
            }
        } else {
            hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().resetIndex() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15100ObtemContasProt() {
        log(TraceLevel.Debug, "A15100-OBTEM-CONTAS-PROT");
        wsCProtoc().wsCProtocP().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cProtContP());
        wsCProtoc().wsCProtocS().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cProtContS());
        if (wsCProtoc().get(1, 4).isEqual("TSUC")) {
            wsContaTsuc().wsCPaisIsoaContTsuc().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cPaisIsoaCont());
            wsContaTsuc().wsCBancContTsuc().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cBancCont());
            wsContaTsuc().wsCOeEgcContTsuc().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cOeEgcCont());
            wsContaTsuc().wsNsRdclContTsuc().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().nsRdclCont());
            wsContaTsuc().wsVChkdContTsuc().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().vChkdCont());
            wsContaTsuc().wsCTipoContTsuc().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cTipoCont());
        }
        if (wsCProtoc().get(1, 4).isEqual("TSUA")) {
            wsContaTsua().wsCPaisIsoaContTsua().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cPaisIsoaCont());
            wsContaTsua().wsCBancContTsua().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cBancCont());
            wsContaTsua().wsCOeEgcContTsua().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cOeEgcCont());
            wsContaTsua().wsNsRdclContTsua().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().nsRdclCont());
            wsContaTsua().wsVChkdContTsua().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().vChkdCont());
            wsContaTsua().wsCTipoContTsua().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cTipoCont());
        }
        if (wsCProtoc().get(1, 4).isEqual("TSUM")) {
            wsContaTsum().wsCPaisIsoaContTsum().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cPaisIsoaCont());
            wsContaTsum().wsCBancContTsum().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cBancCont());
            wsContaTsum().wsCOeEgcContTsum().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cOeEgcCont());
            wsContaTsum().wsNsRdclContTsum().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().nsRdclCont());
            wsContaTsum().wsVChkdContTsum().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().vChkdCont());
            wsContaTsum().wsCTipoContTsum().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cTipoCont());
        }
        if (wsCProtoc().get(1, 4).isEqual("TSUT")) {
            wsContaTsut().wsCPaisIsoaContTsut().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cPaisIsoaCont());
            wsContaTsut().wsCBancContTsut().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cBancCont());
            wsContaTsut().wsCOeEgcContTsut().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cOeEgcCont());
            wsContaTsut().wsNsRdclContTsut().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().nsRdclCont());
            wsContaTsut().wsVChkdContTsut().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().vChkdCont());
            wsContaTsut().wsCTipoContTsut().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cTipoCont());
        }
        hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().incIndex() ;
    }
    
    /**
     * 
     * 
     */
    protected void a16100InicializaTi() {
        log(TraceLevel.Debug, "A16100-INICIALIZA-TI");
        tabInterna().wsTabInterna().getCurrent().wsTiConta().set(wsContaTsua());
        tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento().set(wsZAProcessar());
        tabInterna().wsTabInterna().getCurrent().wsTiQPtu().set(0);
        tabInterna().wsTabInterna().getCurrent().wsTiQRtu().set(0);
        tabInterna().wsTabInterna().incIndex() ;
        tabInterna().wsTabInterna().getCurrent().wsTiConta().set(wsContaTsum());
        tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento().set(wsZAProcessar());
        tabInterna().wsTabInterna().getCurrent().wsTiQPtu().set(0);
        tabInterna().wsTabInterna().getCurrent().wsTiQRtu().set(0);
        tabInterna().wsTabInterna().incIndex() ;
        tabInterna().wsTabInterna().getCurrent().wsTiConta().set(wsContaTsuc());
        tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento().set(wsZAProcessar());
        tabInterna().wsTabInterna().getCurrent().wsTiQPtu().set(0);
        tabInterna().wsTabInterna().getCurrent().wsTiQRtu().set(0);
        tabInterna().wsTabInterna().incIndex() ;
        tabInterna().wsTabInterna().getCurrent().wsTiConta().set(wsContaTsut());
        tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento().set(wsZAProcessar());
        tabInterna().wsTabInterna().getCurrent().wsTiQDep().set(0);
        tabInterna().wsTabInterna().getCurrent().wsTiQRep().set(0);
        tabInterna().wsTabInterna().incIndex() ;
        wsDiaProcessamento.add(1);
        wsZAProcessar().wsDiaProcessar().set(wsDiaProcessamento);
    }
    
    /**
     * 
     * 
     */
    protected void a16000LerFwk506() {
        log(TraceLevel.Debug, "A16000-LER-FWK506");
        fwk506().read() ;
        if (fwk506().getStatusOk()) {
            contRegReadFwk506.add(1);
            wsContaFwk506().wsCPaisFwk506().set(fwk506().regFwk505().fwk505Subconta().fwk505CPaisIsoaCont());
            wsContaFwk506().wsCBancFwk506().set(fwk506().regFwk505().fwk505Subconta().fwk505CBancCont());
            wsContaFwk506().wsCOeFwk506().set(fwk506().regFwk505().fwk505Subconta().fwk505COeEgcCont());
            wsContaFwk506().wsNsRdclFwk506().set(fwk506().regFwk505().fwk505Subconta().fwk505NsRdclCont());
            wsContaFwk506().wsVChkdFwk506().set(fwk506().regFwk505().fwk505Subconta().fwk505VChkdCont());
            wsContaFwk506().wsCTipoFwk506().set(fwk506().regFwk505().fwk505Subconta().fwk505CTipoCont());
            if (wsContaFwk506().isEqual(wsContaTsuc())) {
                swCProtoc.set("TSUC");
            } else if (wsContaFwk506().isEqual(wsContaTsua())) {
                swCProtoc.set("TSUA");
            } else if (wsContaFwk506().isEqual(wsContaTsum())) {
                swCProtoc.set("TSUM");
            } else if (wsContaFwk506().isEqual(wsContaTsut())) {
                swCProtoc.set("TSUT");
            }
            if (contRegReadFwk506.isEqual(1)) {
                wsQDiasMes.set(fwk506().regFwk505().fwk505ZFimMov().get(9, 2));
                wsZDataMax.set(fwk506().regFwk505().fwk505ZFimMov());
                wsZAProcessar().set(fwk506().regFwk505().fwk505ZInicMov());
                wsDiaProcessamento.set(wsZAProcessar().wsDiaProcessar());
            }
        }
        if (!fwk506().getStatusOk() && !fwk506().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK506 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk506().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        while (wsContaFwk506().isEqual(wsContaAnt()) && fwk506().regFwk505().fwk505ZMovimento().isEqual(wsZMovimentoAnt) && fwk506().regFwk505().fwk505ZMovimento().isLessOrEqual(wsZAProcessar()) && !fwk506().getStatusOk()) {
            a31000AcumulaMontantes() ;
        }
        if (wsQuantPtu.isGreater(0) || wsQuantRtu.isGreater(0)) {
            a32000WriteTabIntPtu() ;
            a33000WriteTabIntRtu() ;
        } else if (wsQuantRep.isGreater(0) || wsQuantDep.isGreater(0)) {
            a34000WriteTabIntDep() ;
            a35000WriteTabIntRep() ;
        }
        if (fwk506().regFwk505().fwk505ZMovimento().isGreater(wsZAProcessar()) || 
            fwk506().getStatusOk()) {
            wsZAProcessar().wsDiaProcessar().add(1);
            wsDiaProcessamento.set(wsZAProcessar().wsDiaProcessar());
        }
        wsZMovimentoAnt.set(fwk506().regFwk505().fwk505ZMovimento());
        wsQuantPtu.initialize() ;
        wsQuantRtu.initialize() ;
        wsQuantDep.initialize() ;
        wsQuantRep.initialize() ;
        wsContaAnt().set(wsContaFwk506());
    }
    
    /**
     * 
     * 
     */
    protected void a31000AcumulaMontantes() {
        log(TraceLevel.Debug, "A31000-ACUMULA-MONTANTES");
        wsDescMov.set(" ");
        if (!swProtocT.isTrue()) {
            if ((fwk506().regFwk505().fwk505IDbcr().isEqual("C") && 
                fwk506().regFwk505().fwk505IEstorno().isEmpty()) || 
                (fwk506().regFwk505().fwk505IDbcr().isEqual("D") && 
                !fwk506().regFwk505().fwk505IEstorno().isEmpty())) {
                if (fwk506().regFwk505().fwk505COeEgcOpex().isEqual(9319) || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("0050") || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("0051") || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("0024") || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("0025") || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("HVD1") || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("HVD2") || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("HVC4") || 
                    fwk506().regFwk505().fwk505CEvenOpel().isEqual("0008")) {
                    wsDescMov.set(" ");
                } else {
                    wsDescMov.set("PTU");
                }
            } else if (fwk506().regFwk505().fwk505COeEgcOpex().isEqual(987)) {
                wsDescMov.set("RTU");
            }
        } else if (fwk506().regFwk505().fwk505CEvenOpel().isEqual("HVE1") || 
            fwk506().regFwk505().fwk505CEvenOpel().isEqual("HVE2")) {
            wsDescMov.set("DEP");
        } else if (fwk506().regFwk505().fwk505CEvenOpel().isEqual("HVE3")) {
            wsDescMov.set("REP");
        }
        if (fwk506().regFwk505().fwk505IEstorno().isEmpty()) {
            if (wsDescMov.isEqual("PTU")) {
                wsQuantPtu.add(1);
            } else if (wsDescMov.isEqual("RTU")) {
                wsQuantRtu.add(1);
            } else if (wsDescMov.isEqual("DEP")) {
                wsQuantDep.add(1);
            } else if (wsDescMov.isEqual("REP")) {
                wsQuantRep.add(1);
            }
        } else if (wsDescMov.isEqual("PTU")) {
            wsQuantPtu.subtract(1);
        } else if (wsDescMov.isEqual("RTU")) {
            wsQuantRtu.subtract(1);
        } else if (wsDescMov.isEqual("DEP")) {
            wsQuantDep.subtract(1);
        } else if (wsDescMov.isEqual("REP")) {
            wsQuantRep.subtract(1);
        }
        wsContaAnt().wsCPaisAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505CPaisIsoaCont());
        wsContaAnt().wsCBancAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505CBancCont());
        wsContaAnt().wsCOeAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505COeEgcCont());
        wsContaAnt().wsNsRdclAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505NsRdclCont());
        wsContaAnt().wsVChkdAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505VChkdCont());
        wsContaAnt().wsCTipoAnt().set(fwk506().regFwk505().fwk505Subconta().fwk505CTipoCont());
        wsZMovimentoAnt.set(fwk506().regFwk505().fwk505ZMovimento());
        a16000LerFwk506() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32000WriteTabIntPtu() {
        log(TraceLevel.Debug, "A32000-WRITE-TAB-INT-PTU");
        tabInterna().wsTabInterna().resetIndex() ;
        while (tabInterna().wsTabInterna().index().isLessOrEqual(124)) {
            if (wsContaAnt().isEqual(tabInterna().wsTabInterna().getCurrent().wsTiConta()) && 
                wsZMovimentoAnt.isEqual(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento())) {
                tabInterna().wsTabInterna().getCurrent().wsTiQPtu().add(wsQuantPtu);
                break;
            }
            tabInterna().wsTabInterna().incIndex() ;
        }
        if (tabInterna().wsTabInterna().atEnd()) {
            log(TraceLevel.Trace, "NAO ENCONTROU]");
            log(TraceLevel.Trace, "WS-CONTA-ANT: ", wsContaAnt());
            log(TraceLevel.Trace, "WS-Z-MOVIMENTO-ANT: ", wsZMovimentoAnt);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000WriteTabIntRtu() {
        log(TraceLevel.Debug, "A33000-WRITE-TAB-INT-RTU");
        tabInterna().wsTabInterna().resetIndex() ;
        while (tabInterna().wsTabInterna().index().isLessOrEqual(124)) {
            if (wsContaAnt().isEqual(tabInterna().wsTabInterna().getCurrent().wsTiConta()) && 
                wsZMovimentoAnt.isEqual(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento())) {
                tabInterna().wsTabInterna().getCurrent().wsTiQRtu().add(wsQuantRtu);
                break;
            }
            tabInterna().wsTabInterna().incIndex() ;
        }
        if (tabInterna().wsTabInterna().atEnd()) {
            log(TraceLevel.Trace, "NAO ENCONTROU]");
            log(TraceLevel.Trace, "WS-CONTA-ANT: ", wsContaAnt());
            log(TraceLevel.Trace, "WS-Z-MOVIMENTO-ANT: ", wsZMovimentoAnt);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000WriteTabIntDep() {
        log(TraceLevel.Debug, "A34000-WRITE-TAB-INT-DEP");
        tabInterna().wsTabInterna().resetIndex() ;
        while (tabInterna().wsTabInterna().index().isLessOrEqual(124)) {
            if (wsContaAnt().isEqual(tabInterna().wsTabInterna().getCurrent().wsTiConta()) && 
                wsZMovimentoAnt.isEqual(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento())) {
                tabInterna().wsTabInterna().getCurrent().wsTiQDep().add(wsQuantDep);
                break;
            }
            tabInterna().wsTabInterna().incIndex() ;
        }
        if (tabInterna().wsTabInterna().atEnd()) {
            log(TraceLevel.Trace, "NAO ENCONTROU]");
            log(TraceLevel.Trace, "WS-CONTA-ANT: ", wsContaAnt());
            log(TraceLevel.Trace, "WS-Z-MOVIMENTO-ANT: ", wsZMovimentoAnt);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35000WriteTabIntRep() {
        log(TraceLevel.Debug, "A35000-WRITE-TAB-INT-REP");
        tabInterna().wsTabInterna().resetIndex() ;
        while (tabInterna().wsTabInterna().index().isLessOrEqual(124)) {
            if (wsContaAnt().isEqual(tabInterna().wsTabInterna().getCurrent().wsTiConta()) && 
                wsZMovimentoAnt.isEqual(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento())) {
                tabInterna().wsTabInterna().getCurrent().wsTiQRep().add(wsQuantRep);
                break;
            }
            tabInterna().wsTabInterna().incIndex() ;
        }
        if (tabInterna().wsTabInterna().atEnd()) {
            log(TraceLevel.Trace, "NAO ENCONTROU]");
            log(TraceLevel.Trace, "WS-CONTA-ANT: ", wsContaAnt());
            log(TraceLevel.Trace, "WS-Z-MOVIMENTO-ANT: ", wsZMovimentoAnt);
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            wsZAProcessar().wsDiaProcessar().set(1);
            wsDiaProcessamento.set(wsZAProcessar().wsDiaProcessar());
            tabInterna().wsTabInterna().resetIndex() ;
            while (wsDiaProcessamento.isLessOrEqual(wsQDiasMes)) {
                a71000EscreveTabInt() ;
            }
        }
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressaoMask().zimp().setIndex(5) ;
            tabelaImpressao().linha05().impFichRead().set("FWK506");
            tabelaImpressao().linha05().impRegRead().set(contRegReadFwk506);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("FGH504");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh504);
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC504A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fwk506().close() ;
        fgh300().close() ;
        fgh504().close() ;
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
    protected void a71000EscreveTabInt() {
        log(TraceLevel.Debug, "A71000-ESCREVE-TAB-INT");
        a71100WritePtu() ;
        if (progOk.isTrue()) {
            a71200WriteRtu() ;
        }
        if (progOk.isTrue()) {
            tabInterna().wsTabInterna().incIndex() ;
            a71100WritePtu() ;
        }
        if (progOk.isTrue()) {
            a71200WriteRtu() ;
        }
        if (progOk.isTrue()) {
            tabInterna().wsTabInterna().incIndex() ;
            a71100WritePtu() ;
            if (progOk.isTrue()) {
                a71200WriteRtu() ;
            }
        }
        if (progOk.isTrue()) {
            tabInterna().wsTabInterna().incIndex() ;
            a71300WriteDep() ;
            if (progOk.isTrue()) {
                a71400WriteRep() ;
            }
        }
        if (progOk.isTrue()) {
            tabInterna().wsTabInterna().incIndex() ;
            wsZAProcessar().wsDiaProcessar().add(1);
            wsDiaProcessamento.set(wsZAProcessar().wsDiaProcessar());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a71100WritePtu() {
        log(TraceLevel.Debug, "A71100-WRITE-PTU");
        fgh504().regFgh504().initialize() ;
        fgh504().regFgh504().fgh504CPaisIsoaCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCPaisIsoaCont());
        fgh504().regFgh504().fgh504CBancCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCBancCont());
        fgh504().regFgh504().fgh504COeEgcCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCOeEgcCont());
        fgh504().regFgh504().fgh504NsRdclCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiNsRdclCont());
        fgh504().regFgh504().fgh504VChkdCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiVChkdCont());
        fgh504().regFgh504().fgh504CTipoCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCTipoCont());
        fgh504().regFgh504().fgh504QMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiQPtu());
        fgh504().regFgh504().fgh504CTipoMov().set(conPtu);
        fgh504().regFgh504().fgh504ZMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento());
        fgh504().write(fgh504().regFgh504()) ;
        if (fgh504().getStatusOk()) {
            contRegEscrtFgh504.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC504A - FGH504 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh504().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a71200WriteRtu() {
        log(TraceLevel.Debug, "A71200-WRITE-RTU");
        fgh504().regFgh504().initialize() ;
        fgh504().regFgh504().fgh504CPaisIsoaCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCPaisIsoaCont());
        fgh504().regFgh504().fgh504CBancCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCBancCont());
        fgh504().regFgh504().fgh504COeEgcCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCOeEgcCont());
        fgh504().regFgh504().fgh504NsRdclCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiNsRdclCont());
        fgh504().regFgh504().fgh504VChkdCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiVChkdCont());
        fgh504().regFgh504().fgh504CTipoCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCTipoCont());
        fgh504().regFgh504().fgh504QMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiQRtu());
        fgh504().regFgh504().fgh504CTipoMov().set(conRtu);
        fgh504().regFgh504().fgh504ZMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento());
        fgh504().write(fgh504().regFgh504()) ;
        if (fgh504().getStatusOk()) {
            contRegEscrtFgh504.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC504A - FGH504 - WRITE -A71200 - ");
            tabelaImpressao().linha09().impStatus().set(fgh504().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a71300WriteDep() {
        log(TraceLevel.Debug, "A71300-WRITE-DEP");
        fgh504().regFgh504().fgh504CPaisIsoaCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCPaisIsoaCont());
        fgh504().regFgh504().fgh504CBancCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCBancCont());
        fgh504().regFgh504().fgh504COeEgcCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCOeEgcCont());
        fgh504().regFgh504().fgh504NsRdclCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiNsRdclCont());
        fgh504().regFgh504().fgh504VChkdCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiVChkdCont());
        fgh504().regFgh504().fgh504CTipoCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCTipoCont());
        fgh504().regFgh504().fgh504QMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiQDep());
        fgh504().regFgh504().fgh504CTipoMov().set(conDep);
        fgh504().regFgh504().fgh504ZMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento());
        fgh504().write(fgh504().regFgh504()) ;
        if (fgh504().getStatusOk()) {
            contRegEscrtFgh504.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC504A - FGH504 - WRITE -A71300 - ");
            tabelaImpressao().linha09().impStatus().set(fgh504().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a71400WriteRep() {
        log(TraceLevel.Debug, "A71400-WRITE-REP");
        fgh504().regFgh504().fgh504CPaisIsoaCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCPaisIsoaCont());
        fgh504().regFgh504().fgh504CBancCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCBancCont());
        fgh504().regFgh504().fgh504COeEgcCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCOeEgcCont());
        fgh504().regFgh504().fgh504NsRdclCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiNsRdclCont());
        fgh504().regFgh504().fgh504VChkdCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiVChkdCont());
        fgh504().regFgh504().fgh504CTipoCont().set(tabInterna().wsTabInterna().getCurrent().wsTiConta().wsTiCTipoCont());
        fgh504().regFgh504().fgh504QMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiQRep());
        fgh504().regFgh504().fgh504CTipoMov().set(conRep);
        fgh504().regFgh504().fgh504ZMovimento().set(tabInterna().wsTabInterna().getCurrent().wsTiZProcessamento());
        fgh504().write(fgh504().regFgh504()) ;
        if (fgh504().getStatusOk()) {
            contRegEscrtFgh504.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC504A - FGH504 - WRITE -A71400 - ");
            tabelaImpressao().linha09().impStatus().set(fgh504().getStatus());
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
            while (wsDiaProcessamento.isLessOrEqual(wsQDiasMes)) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsCProtoc extends IDataStruct {
        
        @Data(size=3)
        IString wsCProtocP() ;
        
        @Data(size=4)
        IString wsCProtocS() ;
        
    }
    public interface WsContaAnt extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisAnt() ;
        
        @Data(size=4)
        IInt wsCBancAnt() ;
        
        @Data(size=4)
        IInt wsCOeAnt() ;
        
        @Data(size=7)
        IInt wsNsRdclAnt() ;
        
        @Data(size=1)
        IInt wsVChkdAnt() ;
        
        @Data(size=3)
        IInt wsCTipoAnt() ;
        
    }
    public interface WsContaFwk506 extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisFwk506() ;
        
        @Data(size=4)
        IInt wsCBancFwk506() ;
        
        @Data(size=4)
        IInt wsCOeFwk506() ;
        
        @Data(size=7)
        IInt wsNsRdclFwk506() ;
        
        @Data(size=1)
        IInt wsVChkdFwk506() ;
        
        @Data(size=3)
        IInt wsCTipoFwk506() ;
        
    }
    public interface WsContaTsuc extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaContTsuc() ;
        
        @Data(size=4)
        IInt wsCBancContTsuc() ;
        
        @Data(size=4)
        IInt wsCOeEgcContTsuc() ;
        
        @Data(size=7)
        IInt wsNsRdclContTsuc() ;
        
        @Data(size=1)
        IInt wsVChkdContTsuc() ;
        
        @Data(size=3)
        IInt wsCTipoContTsuc() ;
        
    }
    public interface WsContaTsua extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaContTsua() ;
        
        @Data(size=4)
        IInt wsCBancContTsua() ;
        
        @Data(size=4)
        IInt wsCOeEgcContTsua() ;
        
        @Data(size=7)
        IInt wsNsRdclContTsua() ;
        
        @Data(size=1)
        IInt wsVChkdContTsua() ;
        
        @Data(size=3)
        IInt wsCTipoContTsua() ;
        
    }
    public interface WsContaTsum extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaContTsum() ;
        
        @Data(size=4)
        IInt wsCBancContTsum() ;
        
        @Data(size=4)
        IInt wsCOeEgcContTsum() ;
        
        @Data(size=7)
        IInt wsNsRdclContTsum() ;
        
        @Data(size=1)
        IInt wsVChkdContTsum() ;
        
        @Data(size=3)
        IInt wsCTipoContTsum() ;
        
    }
    public interface WsContaTsut extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaContTsut() ;
        
        @Data(size=4)
        IInt wsCBancContTsut() ;
        
        @Data(size=4)
        IInt wsCOeEgcContTsut() ;
        
        @Data(size=7)
        IInt wsNsRdclContTsut() ;
        
        @Data(size=1)
        IInt wsVChkdContTsut() ;
        
        @Data(size=3)
        IInt wsCTipoContTsut() ;
        
    }
    public interface TabInterna extends IDataStruct {
        
        /**
         * @return instancia da classe local WsTabInterna
         */
        @Data(length=124)
        IArray<WsTabInterna> wsTabInterna() ;
        
        
        public interface WsTabInterna extends IDataStruct {
            
            
            /**
             * @return instancia da classe local WsTiConta
             */
            @Data
            WsTiConta wsTiConta() ;
            
            @Data(size=10)
            IString wsTiZProcessamento() ;
            
            @Data(size=7, signed=true)
            IInt wsTiQPtu() ;
            
            @Data(size=7, signed=true)
            IInt wsTiQRtu() ;
            
            @Data(size=7, signed=true)
            IInt wsTiQDep() ;
            
            @Data(size=7, signed=true)
            IInt wsTiQRep() ;
            
            
            public interface WsTiConta extends IDataStruct {
                
                @Data(size=3)
                IString wsTiCPaisIsoaCont() ;
                
                @Data(size=4)
                IInt wsTiCBancCont() ;
                
                @Data(size=4)
                IInt wsTiCOeEgcCont() ;
                
                @Data(size=7)
                IInt wsTiNsRdclCont() ;
                
                @Data(size=1)
                IInt wsTiVChkdCont() ;
                
                @Data(size=3)
                IInt wsTiCTipoCont() ;
                
            }
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
    public interface WsZAProcessar extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoProcessar() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wsMesProcessar() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wsDiaProcessar() ;
        
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
            
            @Data(size=8, value="PGHC504A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC504A")
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
