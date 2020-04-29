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
import cgd.hj.routines.Mhjj060a ;
import cgd.hj.routines.Mhjj200a ;
import cgd.hg.routines.Mhgj012a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CONTROI FICHEIRO FGH517 PARA A RHENUS LDA
 * TERMINA PROCESSO GH00005
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq517a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk220
     */
    @Handler(name="FWK220", record="regFwk220")
    @Data
    protected abstract Fwk220 fwk220() ;
    
    /**
     * @return instancia da classe Fgh517
     */
    @Handler(name="FGH517", record="regFgh517")
    @Data
    protected abstract Fgh517 fgh517() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhjj060a
     */
    @Data
    protected abstract Mhjj060a hrMhjj060a() ;
    
    /**
     * @return instancia da classe Mhjj200a
     */
    @Data
    protected abstract Mhjj200a hrMhjj200a() ;
    
    /**
     * @return instancia da classe Mhgj012a
     */
    @Data
    protected abstract Mhgj012a hrMhgj012a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhjl001a
     */
    @Data
    protected abstract Bhjl001a bhjl001a() ;
    
    /**
     * ***     AREAS DE TRABALHO          ***
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
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
    protected IString swCrtlContaNova ;
    @Data
    @Condition("5")
    protected ICondition contaNova ;
    @Data
    @Condition("4")
    protected ICondition naoContaNova ;
    
    
    @Data(size=1)
    protected IString swCrtlConta ;
    @Data
    @Condition("3")
    protected ICondition swContaIgual ;
    @Data
    @Condition("4")
    protected ICondition swContaDiferente ;
    
    
    @Data(size=1)
    protected IString swCrtlTrf ;
    @Data
    @Condition("T")
    protected ICondition trf ;
    @Data
    @Condition("U")
    protected ICondition naoTrf ;
    
    
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
    
    @Data(size=10)
    protected IString wsZMovimentoAnt ;
    
    /**
     * @return instancia da classe local WaNConta11
     */
    @Data
    protected abstract WaNConta11 waNConta11() ;
    
    /**
     * @return instancia da classe local WsContaFwk220
     */
    @Data
    protected abstract WsContaFwk220 wsContaFwk220() ;
    
    /**
     * @return instancia da classe local WsContaFwk220Ant
     */
    @Data
    protected abstract WsContaFwk220Ant wsContaFwk220Ant() ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsQRegTot ;
    
    @Data(size=5, signed=true, value="0", compression=COMP3)
    protected IInt wsQOpeDebCont ;
    
    @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
    protected IDecimal wsMDebCont ;
    
    @Data(size=5, signed=true, value="0", compression=COMP3)
    protected IInt wsQOpeCredCont ;
    
    @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
    protected IDecimal wsMCredCont ;
    
    @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
    protected IDecimal wsMSldoCbloFim ;
    
    @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
    protected IDecimal wsMSldoCblo ;
    
    @Data(size=3, signed=true, value="0", compression=COMP3)
    protected IInt wsCMoedIsoNmrc ;
    
    @Data(size=3, signed=true, value="0", compression=COMP3)
    protected IInt wsCMoedIsoNmrcAnt ;
    
    @Data(size=3, value=" ")
    protected IString wsCMoedIso ;
    
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
     * @return instancia da classe local WsData
     */
    @Data
    protected abstract WsData wsData() ;
    
    /**
     * @return instancia da classe local WaData
     */
    @Data
    protected abstract WaData waData() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk220 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh517 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ517A");
        progOk.setTrue() ;
        naoSair.setTrue() ;
        swContaIgual.setTrue() ;
        contaNova.setTrue() ;
        wsContaFwk220Ant().wsCPaisIsoaContAnt().set(" ");
        wsContaFwk220Ant().wsCBancContAnt().set(0);
        wsContaFwk220Ant().wsCOeEgcContAnt().set(0);
        wsContaFwk220Ant().wsNsRdclContAnt().set(0);
        wsContaFwk220Ant().wsVChkdContAnt().set(0);
        wsContaFwk220Ant().wsCTipoContAnt().set(0);
        wsZMovimentoAnt.set(" ");
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
            a13000AbrirFgh517() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk220() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk220() ;
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
    protected void a13000AbrirFgh517() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH517");
        fgh517().open(CREATE ) ;
        if (!fgh517().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ517A - FGH517 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh517().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk220() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK220");
        fwk220().open() ;
        if (!fwk220().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ517A - FWK220 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk220().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk220() {
        log(TraceLevel.Debug, "A15000-LER-FWK220");
        fwk220().read() ;
        if (fwk220().getStatusOk()) {
            contRegLidosFwk220.add(1);
            wsContaFwk220().wsCPaisIsoaCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaCont());
            wsContaFwk220().wsCBancCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CBancCont());
            wsContaFwk220().wsCOeEgcCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcCont());
            wsContaFwk220().wsNsRdclCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsRdclCont());
            wsContaFwk220().wsVChkdCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220VChkdCont());
            wsContaFwk220().wsCTipoCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCont());
            wsContaFwk220().wsCMoedIsoScta().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMoedIsoScta());
            wsCMoedIso.set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMoedIsoScta());
            wsContaFwk220().wsNsDeposito().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsDeposito());
            if (contRegLidosFwk220.isEqual(1)) {
                swContaDiferente.setTrue() ;
            } else if (wsContaFwk220().isEqual(wsContaFwk220Ant())) {
                swContaIgual.setTrue() ;
            } else {
                swContaDiferente.setTrue() ;
                a15100FormataReg33() ;
            }
        } else if (fwk220().getStatusOk()) {
            if (contRegLidosFwk220.isGreater(0)) {
                a15100FormataReg33() ;
                if (progOk.isTrue()) {
                    a15200FormataReg88() ;
                }
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK220 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk220().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15100FormataReg33() {
        log(TraceLevel.Debug, "A15100-FORMATA-REG-33");
        fgh517().regFgh517().initialize() ;
        fgh517().regFgh517().rghf5134().fgh517TipoReg33().set(33);
        fgh517().regFgh517().rghf5134().fgh517CBancCont33().set(wsContaFwk220Ant().wsCBancContAnt());
        fgh517().regFgh517().rghf5134().fgh517COeEgcCont33().set(wsContaFwk220Ant().wsCOeEgcContAnt());
        waNConta11().waNsRdclCont().set(wsContaFwk220Ant().wsNsRdclContAnt());
        waNConta11().waVChkdCont().set(wsContaFwk220Ant().wsVChkdContAnt());
        waNConta11().waCTipoCont().set(wsContaFwk220Ant().wsCTipoContAnt().get(2, 2));
        fgh517().regFgh517().rghf5134().fgh517NConta33().set(waNConta11());
        fgh517().regFgh517().rghf5134().fgh517QOpeDebTot().set(wsQOpeDebCont);
        fgh517().regFgh517().rghf5134().fgh517MDebTot().set(wsMDebCont);
        fgh517().regFgh517().rghf5134().fgh517QOpeCredTot().set(wsQOpeCredCont);
        fgh517().regFgh517().rghf5134().fgh517MCredTot().set(wsMCredCont);
        if (wsMSldoCbloFim.isGreaterOrEqual(0)) {
            fgh517().regFgh517().rghf5134().fgh517ISnlSldoFim().set("2");
        } else {
            fgh517().regFgh517().rghf5134().fgh517ISnlSldoFim().set("1");
        }
        fgh517().regFgh517().rghf5134().fgh517MSldoCbloFim().set(wsMSldoCbloFim);
        fgh517().regFgh517().rghf5134().fgh517CMoedNmrCont().set(wsCMoedIsoNmrcAnt);
        a60000EscreverFgh517() ;
        if (progOk.isTrue()) {
            wsQOpeDebCont.set(0);
            wsMDebCont.set(0);
            wsQOpeCredCont.set(0);
            wsMCredCont.set(0);
            wsMSldoCbloFim.set(0);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15200FormataReg88() {
        log(TraceLevel.Debug, "A15200-FORMATA-REG-88");
        fgh517().regFgh517().initialize() ;
        fgh517().regFgh517().rghf5135().fgh517TipoReg88().set(88);
        fgh517().regFgh517().rghf5135().fgh517CodNoves().set(9);
        fgh517().regFgh517().rghf5135().fgh517QRegTot().set(add(contRegEscrtFgh517, 1));
        a60000EscreverFgh517() ;
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (swContaDiferente.isTrue()) {
            a31000FormataReg11() ;
        }
        if (progOk.isTrue()) {
            swContaIgual.setTrue() ;
            while (!swContaDiferente.isTrue() && !fwk220().getStatusOk() && progOk.isTrue()) {
                a32000TrataMovimentos() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000FormataReg11() {
        log(TraceLevel.Debug, "A31000-FORMATA-REG-11");
        fgh517().regFgh517().initialize() ;
        fgh517().regFgh517().rghf5131().fgh517TipoReg11().set("11");
        fgh517().regFgh517().rghf5131().fgh517CBancCont11().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CBancCont());
        fgh517().regFgh517().rghf5131().fgh517COeEgcCont11().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcCont());
        waNConta11().waNsRdclCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsRdclCont());
        waNConta11().waVChkdCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220VChkdCont());
        waNConta11().waCTipoCont().set(wsContaFwk220().wsCTipoCont().get(2, 2));
        fgh517().regFgh517().rghf5131().fgh517NConta11().set(waNConta11());
        wsData().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220ZMovimento());
        waData().waAno().set(wsData().wsAno().get(3, 2));
        waData().waMes().set(wsData().wsMes());
        waData().waDia().set(wsData().wsDia());
        fgh517().regFgh517().rghf5131().fgh517ZInicPer().set(waData());
        fgh517().regFgh517().rghf5131().fgh517ZFimPer().set(waData());
        if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("C")) {
            if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IEstorno().isEmpty()) {
                wsMSldoCblo.set(subtract(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MSldoCbloApos(), fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento()));
            } else {
                wsMSldoCblo.set(add(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MSldoCbloApos(), fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento()));
            }
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IEstorno().isEmpty()) {
            wsMSldoCblo.set(add(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MSldoCbloApos(), fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento()));
        } else {
            wsMSldoCblo.set(subtract(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MSldoCbloApos(), fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento()));
        }
        if (wsMSldoCblo.isGreaterOrEqual(0)) {
            fgh517().regFgh517().rghf5131().fgh517ISnlSldoInic().set("2");
        } else {
            fgh517().regFgh517().rghf5131().fgh517ISnlSldoInic().set("1");
        }
        fgh517().regFgh517().rghf5131().fgh517MSldoCbloInic().set(wsMSldoCblo);
        fgh517().regFgh517().rghf5131().fgh517CodTres().set(3);
        a31100ObtemNmCliente() ;
        if (progOk.isTrue()) {
            wsCMoedIsoNmrc.set(0);
            a31200ObtemMoedaNmrc() ;
        }
        if (progOk.isTrue()) {
            fgh517().regFgh517().rghf5131().fgh517CMoedNmrScta().set(wsCMoedIsoNmrc);
        }
        if (progOk.isTrue()) {
            a60000EscreverFgh517() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100ObtemNmCliente() {
        log(TraceLevel.Debug, "A31100-OBTEM-NM-CLIENTE");
        hrMhjj060a().bhjl060a().commarea().initialize() ;
        bhjl001a().commarea().initialize() ;
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaOeOpx());
        bhjl001a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaOeOpx());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cMnemEgcOpex().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMnemEgcOpex());
        bhjl001a().commarea().dadosEntrada().cMnemEgcOpex().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMnemEgcOpex());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().zConsulta().set(wTimestamp().wDataTimestamp());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaCont());
        bhjl001a().commarea().dadosEntrada().cPaisIsoaCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cBancCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CBancCont());
        bhjl001a().commarea().dadosEntrada().cBancCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CBancCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cOeEgcCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcCont());
        bhjl001a().commarea().dadosEntrada().cOeEgcCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsRdclCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsRdclCont());
        bhjl001a().commarea().dadosEntrada().nsRdclCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsRdclCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().vChkdCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220VChkdCont());
        bhjl001a().commarea().dadosEntrada().vChkdCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220VChkdCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cTipoCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCont());
        bhjl001a().commarea().dadosEntrada().cTipoCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().iTipoItvt().set(101);
        bhjl001a().commarea().dadosEntrada().iTipoItvt().set(101);
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsTitc().set(1);
        bhjl001a().commarea().dadosEntrada().nsTitc().set(1);
        hrMhjj060a().run() ;
        if (hrMhjj060a().bhjl060a().commarea().erros().semErros().isTrue()) {
            if (hrMhjj060a().bhjl060a().commarea().erros().clienteConfidencial().isTrue()) {
                fgh517().regFgh517().rghf5131().fgh517NmAbrvCli().set(" ");
            } else {
                bhjl001a().commarea().dadosEntrada().nsAbraCli().set(hrMhjj060a().bhjl060a().commarea().dadosSaida().nsAbraCli());
                a31110ObtemNomeCli() ;
            }
        } else {
            fgh517().regFgh517().rghf5131().fgh517NmAbrvCli().set(" ");
            log(TraceLevel.Debug, "BHJL060A-C-TIPO-ERRO-BBN-", hrMhjj060a().bhjl060a().commarea().erros().cTipoErroBbn());
            log(TraceLevel.Debug, "BHJL060A-C-RTNO-EVEN-SWAL-", hrMhjj060a().bhjl060a().commarea().erros().cRtnoEvenSwal());
            log(TraceLevel.Debug, "BHJL060A-NM-TABELA -", hrMhjj060a().bhjl060a().commarea().erros().nmTabela());
            log(TraceLevel.Debug, "BHJL060A-C-SQLCODE-", hrMhjj060a().bhjl060a().commarea().erros().cSqlcode());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31110ObtemNomeCli() {
        log(TraceLevel.Debug, "A31110-OBTEM-NOME-CLI");
        hrMhjj200a().run() ;
        if (bhjl001a().commarea().erros().semErros().isTrue()) {
            fgh517().regFgh517().rghf5131().fgh517NmAbrvCli().set(bhjl001a().commarea().dadosSaida().nmCliAbvd());
        } else {
            fgh517().regFgh517().rghf5131().fgh517NmAbrvCli().set(" ");
            log(TraceLevel.Debug, "BHJL001A-C-TIPO-ERRO-BBN-", bhjl001a().commarea().erros().cTipoErroBbn());
            log(TraceLevel.Debug, "BHJL001A-C-RTNO-EVEN-SWAL-", bhjl001a().commarea().erros().cRtnoEvenSwal());
            log(TraceLevel.Debug, "BHJL001A-NM-TABELA -", bhjl001a().commarea().erros().nmTabela());
            log(TraceLevel.Debug, "BHJL001A-C-SQLCODE-", bhjl001a().commarea().erros().cSqlcode());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200ObtemMoedaNmrc() {
        log(TraceLevel.Debug, "A31200-OBTEM-MOEDA-NMRC");
        hrMhgj012a().bhgl012a().commarea().initialize() ;
        hrMhgj012a().bhgl012a().commarea().dadosIO().cIdioIso().set("POR");
        hrMhgj012a().bhgl012a().commarea().dadosIO().cMoedIso().set(wsCMoedIso);
        hrMhgj012a().run() ;
        if (hrMhgj012a().bhgl012a().commarea().dadosOutput().dadosErro().semErros().isTrue()) {
            wsCMoedIsoNmrc.set(hrMhgj012a().bhgl012a().commarea().dadosIO().cMoedIsoNmrc());
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("OBTEM-MOEDA");
            tabelaImpressao().linha09().impStatus().set(hrMhgj012a().bhgl012a().commarea().dadosOutput().dadosErro().cRtnoEvenSwal());
            log(TraceLevel.Debug, "BHGL012A-C-TIPO-ERRO-BBN-", hrMhgj012a().bhgl012a().commarea().dadosOutput().dadosErro().cTipoErroBbn());
            log(TraceLevel.Debug, "BHGL012A-C-RTNO-EVEN-SWAL-", hrMhgj012a().bhgl012a().commarea().dadosOutput().dadosErro().cRtnoEvenSwal());
            log(TraceLevel.Debug, "BHGL012A-NM-TABELA -", hrMhgj012a().bhgl012a().commarea().dadosOutput().dadosErro().nmTabela());
            log(TraceLevel.Debug, "BHGL012A-C-SQLCODE-", hrMhgj012a().bhgl012a().commarea().dadosOutput().dadosErro().cSqlcode());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000TrataMovimentos() {
        log(TraceLevel.Debug, "A32000-TRATA-MOVIMENTOS");
        fgh517().regFgh517().initialize() ;
        fgh517().regFgh517().rghf5132().fgh517TipoReg22().set(22);
        fgh517().regFgh517().rghf5132().fgh517Filler22().set(" ");
        fgh517().regFgh517().rghf5132().fgh517COeEgcOpex().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcOpex());
        wsData().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220ZMovimento());
        waData().waAno().set(wsData().wsAno().get(3, 2));
        waData().waMes().set(wsData().wsMes());
        waData().waDia().set(wsData().wsDia());
        fgh517().regFgh517().rghf5132().fgh517ZMovimento().set(waData());
        wsData().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220ZValMov());
        waData().waAno().set(wsData().wsAno().get(3, 2));
        waData().waMes().set(wsData().wsMes());
        waData().waDia().set(wsData().wsDia());
        fgh517().regFgh517().rghf5132().fgh517ZValMov().set(waData());
        fgh517().regFgh517().rghf5132().fgh517CodComum().set(9);
        fgh517().regFgh517().rghf5132().fgh517MMovimento().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento());
        wsMSldoCbloFim.set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MSldoCbloApos());
        if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
            if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IEstorno().isEmpty()) {
                fgh517().regFgh517().rghf5132().fgh517IDbcr().set(1);
            } else {
                fgh517().regFgh517().rghf5132().fgh517IDbcr().set(2);
            }
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IEstorno().isEmpty()) {
            fgh517().regFgh517().rghf5132().fgh517IDbcr().set(2);
        } else {
            fgh517().regFgh517().rghf5132().fgh517IDbcr().set(1);
        }
        if (fgh517().regFgh517().rghf5132().fgh517IDbcr().isEqual("2")) {
            wsQOpeCredCont.add(1);
            wsMCredCont.set(add(wsMCredCont, fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento()));
        } else {
            wsQOpeDebCont.add(1);
            wsMDebCont.set(add(wsMDebCont, fwk220().regFwk220().fwk220FicheiroFgh517().fwk220MMovimento()));
        }
        fgh517().regFgh517().rghf5132().fgh517NDocOpps().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NDocOpps());
        fgh517().regFgh517().rghf5132().fgh517XRefPrim().set(0);
        fgh517().regFgh517().rghf5132().fgh517XRefSeg().set(" ");
        a61000DetCodProprio() ;
        a60000EscreverFgh517() ;
        if (progOk.isTrue()) {
            a32100FormataReg23() ;
        }
        if (progOk.isTrue()) {
            wsContaFwk220Ant().set(wsContaFwk220());
            wsCMoedIsoNmrcAnt.set(wsCMoedIsoNmrc);
            a15000LerFwk220() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100FormataReg23() {
        log(TraceLevel.Debug, "A32000-TRATA-MOVIMENTOS");
        fgh517().regFgh517().initialize() ;
        fgh517().regFgh517().rghf5133().fgh517TipoReg23().set(23);
        fgh517().regFgh517().rghf5133().fgh517NsOrdMov().set(1);
        fgh517().regFgh517().rghf5133().fgh517XRefMovPrim().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220XRefMov());
        /**
         * MOVE FWK220-N-DOC-OPPS        TO FGH517-X-REF-MOV-SEGN
         */
        a60000EscreverFgh517() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32200ActPedido() {
        log(TraceLevel.Debug, "A32200-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk220().regFwk220().fwk220Pedido().fwk220CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk220().regFwk220().fwk220Pedido().fwk220ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk220().regFwk220().fwk220Pedido().fwk220ZFimMov());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq517a860() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
    protected void a61000DetCodProprio() {
        log(TraceLevel.Debug, "A61000-DET-COD-PROPRIO");
        if ((fwk220().regFwk220().fwk220FicheiroFgh517().fwk220AAplOrig().isEqual("HH") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220AAplOrig().isEqual("HC")) && 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220NDocOpps().isGreater(0)) {
            fgh517().regFgh517().rghf5132().fgh517CodProprio().set(104);
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().isEqual("ATS")) {
            if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220XRefMov().isEqual("TRF ATM")) {
                if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
                    fgh517().regFgh517().rghf5132().fgh517CodProprio().set(103);
                } else {
                    fgh517().regFgh517().rghf5132().fgh517CodProprio().set(503);
                }
            } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(105);
            } else {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(505);
            }
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().isEqual("SIBS")) {
            if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(102);
            } else {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(502);
            }
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().isEqual("BALC")) {
            if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220AAplOrig().isEqual("HV")) {
                a61100DetCodPropHv() ;
            } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(101);
            } else {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(501);
            }
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().isEqual("0001") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().isEqual("0002") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().isEqual("0003") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CTipoCanlAces().isEqual("0004")) {
            if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(106);
            } else {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(506);
            }
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
            fgh517().regFgh517().rghf5132().fgh517CodProprio().set(109);
        } else {
            fgh517().regFgh517().rghf5132().fgh517CodProprio().set(509);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a61100DetCodPropHv() {
        log(TraceLevel.Debug, "A61100-DET-COD-PROP-HV");
        naoTrf.setTrue() ;
        if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVA4") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("TVA41") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVA17"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVA5") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVG65") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVG66"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVB1") && 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB74")) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVB3") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB62") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB76") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB77"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVC7") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB63") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB78"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVD6") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB66") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVB81"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVE2") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVE57") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVE58"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVA4") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVG50") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVG51"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("HVK8") && 
            (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVA74") || 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVA84"))) {
            trf.setTrue() ;
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220CEvenOpel().isEqual("UNVE") && 
            fwk220().regFwk220().fwk220FicheiroFgh517().fwk220COpeBbn().isEqual("HVA65")) {
            trf.setTrue() ;
        } else {
            naoTrf.setTrue() ;
        }
        if (trf.isTrue()) {
            if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(103);
            } else {
                fgh517().regFgh517().rghf5132().fgh517CodProprio().set(503);
            }
        } else if (fwk220().regFwk220().fwk220FicheiroFgh517().fwk220IDbcr().isEqual("D")) {
            fgh517().regFgh517().rghf5132().fgh517CodProprio().set(101);
        } else {
            fgh517().regFgh517().rghf5132().fgh517CodProprio().set(501);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a60000EscreverFgh517() {
        log(TraceLevel.Debug, "A60000-ESCREVER-FGH517");
        fgh517().write(fgh517().regFgh517()) ;
        if (fgh517().getStatusOk()) {
            contRegEscrtFgh517.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ517A - FGH517 - WRITE A60000 - ");
            tabelaImpressao().linha09().impStatus().set(fgh517().getStatus());
        }
        if (progOk.isTrue()) {
            if (!wsContaFwk220().isEqual(wsContaFwk220Ant())) {
                a32200ActPedido() ;
            }
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
            tabelaImpressao().linha05().impFichRead().set("FWK220");
            tabelaImpressao().linha05().impRegRead().set(contRegLidosFwk220);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("FGH517");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh517);
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ517A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk220().close() ;
        fgh517().close() ;
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
            while (!fwk220().getStatusOk() && !sair.isTrue() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WaNConta11 extends IDataStruct {
        
        @Data(size=7)
        IInt waNsRdclCont() ;
        
        @Data(size=1)
        IInt waVChkdCont() ;
        
        @Data(size=2)
        IInt waCTipoCont() ;
        
    }
    public interface WsContaFwk220 extends IDataStruct {
        
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
        
    }
    public interface WsContaFwk220Ant extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaContAnt() ;
        
        @Data(size=4)
        IInt wsCBancContAnt() ;
        
        @Data(size=4)
        IInt wsCOeEgcContAnt() ;
        
        @Data(size=7)
        IInt wsNsRdclContAnt() ;
        
        @Data(size=1)
        IInt wsVChkdContAnt() ;
        
        @Data(size=3)
        IInt wsCTipoContAnt() ;
        
        @Data(size=3)
        IString wsCMoedIsoSctaAnt() ;
        
        @Data(size=4)
        IInt wsNsDepositoAnt() ;
        
    }
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=4)
        IInt anoCorrente() ;
        
        @Data(size=2)
        IInt mesCorrente() ;
        
        @Data(size=2)
        IInt diaCorrente() ;
        
    }
    public interface WsData extends IDataStruct {
        
        @Data(size=4)
        IInt wsAno() ;
        
        @Data(size=2, lpadding=1)
        IInt wsMes() ;
        
        @Data(size=2, lpadding=1)
        IInt wsDia() ;
        
    }
    public interface WaData extends IDataStruct {
        
        @Data(size=2)
        IInt waAno() ;
        
        @Data(size=2)
        IInt waMes() ;
        
        @Data(size=2)
        IInt waDia() ;
        
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
            
            @Data(size=8, value="PGHQ517A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ517A")
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
