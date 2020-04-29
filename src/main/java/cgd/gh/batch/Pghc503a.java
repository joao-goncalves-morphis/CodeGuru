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
 * FWK504 - FICHEIRO DOS MOVIMENTOS DAS CONTA DA DBI
 * FWK500 - FICHEIRO MENSAL DO ACUMULADO DOS MOVIMENTOS PARA A DBI
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : ACUMULA MOVIMENTOS DO MES ANTERIOR NO FICHEIRO*
 * FWK500
 * .O FICHEIRO FWK500 E ORDENADO PARA O FGH503
 * PARA SER ENVIDADO POR CONNECT DIRECT PARA DBI
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc503a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk50401
     */
    @Handler(name="FWK504", record="rwk50301")
    @Data
    protected abstract Fwk50401 fwk504() ;
    
    /**
     * @return instancia da classe Fwk50001
     */
    @Handler(name="FWK500", record="regFgh503")
    @Data
    protected abstract Fwk50001 fwk500() ;
    
    
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
    protected IString swCrtlSair ;
    @Data
    @Condition("A")
    protected ICondition sair ;
    @Data
    @Condition("B")
    protected ICondition naoSair ;
    
    
    @Data(size=10)
    protected IString wsZMovimento ;
    
    @Data(size=10)
    protected IString wsZMovimentoAnt ;
    
    /**
     * @return instancia da classe local WsContaFwk504
     */
    @Data
    protected abstract WsContaFwk504 wsContaFwk504() ;
    
    /**
     * @return instancia da classe local WsContaFwk504Ant
     */
    @Data
    protected abstract WsContaFwk504Ant wsContaFwk504Ant() ;
    
    @Data(size=10)
    protected IString wsZInicMov ;
    
    @Data(size=10)
    protected IString wsZFimMov ;
    
    @Data(size=2)
    protected IInt wsQDiaMes ;
    
    @Data(size=8)
    protected ILong wsQMov ;
    
    /**
     * @return instancia da classe local WsZCrtl
     */
    @Data
    protected abstract WsZCrtl wsZCrtl() ;
    
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
    protected ILong contRegLidosFwk504 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk500 ;
    
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
        bghw0300().wsNmPrograma().set("PGHC503A");
        progOk.setTrue() ;
        naoSair.setTrue() ;
        swContaIgual.setTrue() ;
        contaNova.setTrue() ;
        wsContaFwk504Ant().wsCPaisIsoaContAnt().set(" ");
        wsContaFwk504Ant().wsCBancContAnt().set(0);
        wsContaFwk504Ant().wsCOeEgcContAnt().set(0);
        wsContaFwk504Ant().wsNsRdclContAnt().set(0);
        wsContaFwk504Ant().wsVChkdContAnt().set(0);
        wsContaFwk504Ant().wsCTipoContAnt().set(0);
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
            a13000AbrirFwk500() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk504() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk504() ;
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
    protected void a13000AbrirFwk500() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWK500");
        fwk500().open(CREATE ) ;
        if (!fwk500().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC503A - FWK500 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk500().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk504() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK504");
        fwk504().open() ;
        if (!fwk504().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC503A - FWK504 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk504().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk504() {
        log(TraceLevel.Debug, "A15000-LER-FWK504");
        fwk504().read() ;
        if (fwk504().getStatusOk()) {
            contRegLidosFwk504.add(1);
            wsContaFwk504().wsCPaisIsoaCont().set(fwk504().rwk50301().fwk503Subconta().fwk503CPaisIsoaCont());
            wsContaFwk504().wsCBancCont().set(fwk504().rwk50301().fwk503Subconta().fwk503CBancCont());
            wsContaFwk504().wsCOeEgcCont().set(fwk504().rwk50301().fwk503Subconta().fwk503COeEgcCont());
            wsContaFwk504().wsNsRdclCont().set(fwk504().rwk50301().fwk503Subconta().fwk503NsRdclCont());
            wsContaFwk504().wsVChkdCont().set(fwk504().rwk50301().fwk503Subconta().fwk503VChkdCont());
            wsContaFwk504().wsCTipoCont().set(fwk504().rwk50301().fwk503Subconta().fwk503CTipoCont());
            wsZMovimento.set(fwk504().rwk50301().fwk503ZMovimento());
            if (contRegLidosFwk504.isEqual(1)) {
                swContaIgual.setTrue() ;
                wsZInicMov.set(fwk504().rwk50301().fwk503Pedido().fwk503ZInicMov());
                wsZCrtl().set(fwk504().rwk50301().fwk503Pedido().fwk503ZInicMov());
                wsZFimMov.set(fwk504().rwk50301().fwk503Pedido().fwk503ZFimMov());
                wsQDiaMes.set(wsZFimMov.get(9, 2));
                if (wsZCrtl().isLess(fwk504().rwk50301().fwk503ZMovimento())) {
                    while (wsZCrtl().isLess(fwk504().rwk50301().fwk503ZMovimento())) {
                        a15100EscreverFwk500() ;
                    }
                }
            } else if (wsContaFwk504().isEqual(wsContaFwk504Ant()) && 
                wsZMovimento.isEqual(wsZMovimentoAnt)) {
                swContaIgual.setTrue() ;
                naoContaNova.setTrue() ;
            } else {
                swContaDiferente.setTrue() ;
                contaNova.setTrue() ;
            }
        } else if (fwk504().getStatusOk()) {
            if (wsQMov.isGreater(0)) {
                wsZCrtl().set(wsZMovimentoAnt);
                a15200EscreverFwk500() ;
            }
            if (wsZCrtl().wsDiaCrtl().isEqual(wsQDiaMes)) {
                sair.setTrue() ;
            } else {
                wsQMov.set(0);
                while (wsZCrtl().wsDiaCrtl().isLessOrEqual(wsQDiaMes)) {
                    a15200EscreverFwk500() ;
                }
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK504 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk504().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15100EscreverFwk500() {
        log(TraceLevel.Debug, "A15100-ESCREVER-FWK500");
        fwk500().regFgh503().initialize() ;
        fwk500().regFgh503().fgh503Conta().fgh503CPaisIsoaCont().set(fwk504().rwk50301().fwk503Subconta().fwk503CPaisIsoaCont());
        fwk500().regFgh503().fgh503Conta().fgh503CBancCont().set(fwk504().rwk50301().fwk503Subconta().fwk503CBancCont());
        fwk500().regFgh503().fgh503Conta().fgh503COeEgcCont().set(fwk504().rwk50301().fwk503Subconta().fwk503COeEgcCont());
        fwk500().regFgh503().fgh503Conta().fgh503NsRdclCont().set(fwk504().rwk50301().fwk503Subconta().fwk503NsRdclCont());
        fwk500().regFgh503().fgh503Conta().fgh503VChkdCont().set(fwk504().rwk50301().fwk503Subconta().fwk503VChkdCont());
        fwk500().regFgh503().fgh503Conta().fgh503CTipoCont().set(fwk504().rwk50301().fwk503Subconta().fwk503CTipoCont());
        fwk500().regFgh503().fgh503QMovimentos().set(0);
        fwk500().regFgh503().fgh503ZMovimento().set(wsZCrtl());
        fwk500().write(fwk500().regFgh503()) ;
        if (fwk500().getStatusOk()) {
            contRegEscrtFwk500.add(1);
            wsZCrtl().wsDiaCrtl().add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC503A - FWK500 - WRITE A15100 - ");
            tabelaImpressao().linha09().impStatus().set(fwk500().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15200EscreverFwk500() {
        log(TraceLevel.Debug, "A15200-ESCREVER-FWK500");
        fwk500().regFgh503().initialize() ;
        fwk500().regFgh503().fgh503Conta().fgh503CPaisIsoaCont().set(wsContaFwk504Ant().wsCPaisIsoaContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503CBancCont().set(wsContaFwk504Ant().wsCBancContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503COeEgcCont().set(wsContaFwk504Ant().wsCOeEgcContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503NsRdclCont().set(wsContaFwk504Ant().wsNsRdclContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503VChkdCont().set(wsContaFwk504Ant().wsVChkdContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503CTipoCont().set(wsContaFwk504Ant().wsCTipoContAnt());
        fwk500().regFgh503().fgh503QMovimentos().set(wsQMov);
        fwk500().regFgh503().fgh503ZMovimento().set(wsZCrtl());
        fwk500().write(fwk500().regFgh503()) ;
        if (fwk500().getStatusOk()) {
            contRegEscrtFwk500.add(1);
            wsZCrtl().wsDiaCrtl().add(1);
            wsQMov.set(0);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC503A - FWK500 - WRITE A15200 - ");
            tabelaImpressao().linha09().impStatus().set(fwk500().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (swContaIgual.isTrue()) {
            while (!swContaDiferente.isTrue() && !fwk504().getStatusOk() && progOk.isTrue()) {
                a31000AcumulaMov() ;
            }
        } else {
            a32000EscreverFwk500() ;
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
            tabelaImpressao().linha05().impFichRead().set("FWK504");
            tabelaImpressao().linha05().impRegRead().set(contRegLidosFwk504);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("FWK500");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk500);
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC503A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk504().close() ;
        fwk500().close() ;
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
    protected void a31000AcumulaMov() {
        log(TraceLevel.Debug, "A31000-ACUMULA-MOV");
        wsQMov.add(1);
        wsContaFwk504Ant().wsCPaisIsoaContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503CPaisIsoaCont());
        wsContaFwk504Ant().wsCBancContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503CBancCont());
        wsContaFwk504Ant().wsCOeEgcContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503COeEgcCont());
        wsContaFwk504Ant().wsNsRdclContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503NsRdclCont());
        wsContaFwk504Ant().wsVChkdContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503VChkdCont());
        wsContaFwk504Ant().wsCTipoContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503CTipoCont());
        wsZMovimentoAnt.set(fwk504().rwk50301().fwk503ZMovimento());
        naoContaNova.setTrue() ;
        a15000LerFwk504() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreverFwk500() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FWK500");
        fwk500().regFgh503().initialize() ;
        fwk500().regFgh503().fgh503Conta().fgh503CPaisIsoaCont().set(wsContaFwk504Ant().wsCPaisIsoaContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503CBancCont().set(wsContaFwk504Ant().wsCBancContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503COeEgcCont().set(wsContaFwk504Ant().wsCOeEgcContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503NsRdclCont().set(wsContaFwk504Ant().wsNsRdclContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503VChkdCont().set(wsContaFwk504Ant().wsVChkdContAnt());
        fwk500().regFgh503().fgh503Conta().fgh503CTipoCont().set(wsContaFwk504Ant().wsCTipoContAnt());
        fwk500().regFgh503().fgh503QMovimentos().set(wsQMov);
        fwk500().regFgh503().fgh503ZMovimento().set(wsZMovimentoAnt);
        wsZCrtl().set(wsZMovimentoAnt);
        fwk500().write(fwk500().regFgh503()) ;
        if (fwk500().getStatusOk()) {
            contRegEscrtFwk500.add(1);
            wsQMov.set(0);
            wsZCrtl().wsDiaCrtl().add(1);
            if (wsContaFwk504().isEqual(wsContaFwk504Ant())) {
                while (!wsZCrtl().isEqual(fwk504().rwk50301().fwk503ZMovimento())) {
                    a15200EscreverFwk500() ;
                }
            } else {
                while (wsZCrtl().wsDiaCrtl().isLessOrEqual(wsQDiaMes)) {
                    a15200EscreverFwk500() ;
                }
                if (progOk.isTrue()) {
                    wsZInicMov.set(fwk504().rwk50301().fwk503Pedido().fwk503ZInicMov());
                    wsZCrtl().set(fwk504().rwk50301().fwk503Pedido().fwk503ZInicMov());
                    wsZFimMov.set(fwk504().rwk50301().fwk503Pedido().fwk503ZFimMov());
                    wsQDiaMes.set(wsZFimMov.get(9, 2));
                    while (wsZCrtl().isLess(fwk504().rwk50301().fwk503ZMovimento())) {
                        a15100EscreverFwk500() ;
                    }
                }
            }
            wsContaFwk504Ant().wsCPaisIsoaContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503CPaisIsoaCont());
            wsContaFwk504Ant().wsCBancContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503CBancCont());
            wsContaFwk504Ant().wsCOeEgcContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503COeEgcCont());
            wsContaFwk504Ant().wsNsRdclContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503NsRdclCont());
            wsContaFwk504Ant().wsVChkdContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503VChkdCont());
            wsContaFwk504Ant().wsCTipoContAnt().set(fwk504().rwk50301().fwk503Subconta().fwk503CTipoCont());
            wsZMovimentoAnt.set(fwk504().rwk50301().fwk503ZMovimento());
            wsQMov.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC503A - FWK500 - WRITE A32000 - ");
            tabelaImpressao().linha09().impStatus().set(fwk500().getStatus());
        }
        if (progOk.isTrue()) {
            if (!fwk504().getStatusOk()) {
                a15000LerFwk504() ;
            }
        }
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
            while (!fwk504().getStatusOk() && !sair.isTrue() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsContaFwk504 extends IDataStruct {
        
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
        
    }
    public interface WsContaFwk504Ant extends IDataStruct {
        
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
        
    }
    public interface WsZCrtl extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoCrtl() ;
        
        @Data(size=2, lpadding=1)
        IInt wsMesCrtl() ;
        
        @Data(size=2, lpadding=1)
        IInt wsDiaCrtl() ;
        
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
            
            @Data(size=8, value="PGHC503A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC503A")
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
