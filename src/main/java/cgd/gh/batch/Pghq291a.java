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


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVO     : TRATAMENTO DO PEDIDO GH00011
 * . FICHEIRO PARA SER CONVERTIDO PARA EXCEL
 * ALTERACOES    : INTRODUÇÃO DE NOVOS CAMPOS NO FICHEIRO
 * GIP:GH385
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq291a extends CgdGhBaseBatch {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da classe AreaParm
     */
    @Data
    public abstract AreaParm areaParm() ;
    
    
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
     * @return instancia da classe Fwk50102
     */
    @Handler(name="FWK501", record="regFwk501291")
    @Data
    protected abstract Fwk50102 fwk501() ;
    
    /**
     * @return instancia da classe Fwk291
     */
    @Handler(name="FWK291", record="regFwk291")
    @Data
    protected abstract Fwk291 fwk291() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREAS DE TRABALHO COMUM    ***
     */
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    
    
    @Data(size=10, signed=true, value="0")
    protected ILong wSqlcode ;
    
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
    
    @Data(size=17, decimal=2, value="0")
    protected IDecimal wsMMovimento ;
    
    /**
     * @return instancia da classe local WsMMovimentoMask
     */
    @Data
    @Mask
    protected abstract WsMMovimentoMask wsMMovimentoMask() ;
    
    @Data(size=10, decimal=7, value="0")
    protected IDecimal wsTJuro ;
    
    /**
     * @return instancia da classe local WsTJuroMask
     */
    @Data
    @Mask
    protected abstract WsTJuroMask wsTJuroMask() ;
    
    @Data(size=1, value=",")
    protected IString conVirgula ;
    
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
    
    @Data(size=60, value="INVENTARIO DE MOVIMENTOS")
    protected IString wsTitulo ;
    
    /**
     * @return instancia da classe local WsCabecalho
     */
    @Data
    protected abstract WsCabecalho wsCabecalho() ;
    
    /**
     * @return instancia da classe local WsFwk501
     */
    @Data
    protected abstract WsFwk501 wsFwk501() ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFwk501 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk291 ;
    
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
    protected void s00000ValidarParm() {
        progOk.setTrue() ;
        if (areaParm().pEndcFtp().isEmpty()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, "PARM INVALIDO");
        }
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ291A");
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
        wsChaveAnt().initialize() ;
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AbrirFwk501() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk291() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk291() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A10000-ABRIR-FGH300");
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
    protected void a13000AbrirFwk501() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWK501");
        fwk501().open(CREATE ) ;
        if (!fwk501().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ291A - FWK501 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk501().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk291() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK291");
        fwk291().open() ;
        if (!fwk291().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ291A - FWK291 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk291().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk291() {
        log(TraceLevel.Debug, "A15000-LER-FWK291");
        fwk291().read() ;
        if (fwk291().getStatusOk()) {
            contRegLidosFwk291.add(1);
            wsChave().wsCPaisIsoaContA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CPaisIsoaCont());
            wsChave().wsCBancContA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CBancCont());
            wsChave().wsCOeEgcContA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200COeEgcCont());
            wsChave().wsNsRdclContA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NsRdclCont());
            wsChave().wsVChkdContA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200VChkdCont());
            wsChave().wsCTipoContA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CTipoCont());
            wsChave().wsCMoedIsoSctaA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CMoedIsoScta());
            wsChave().wsNsDepositoA().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NsDeposito());
            wsChave().wsCPedInfOppsA().set(fwk291().regFwk291().fwk200Pedido().fwk200CPedInfOpps());
            wsChave().wsZInicMovA().set(fwk291().regFwk291().fwk200Pedido().fwk200ZInicMov());
            wsChave().wsZFimMovA().set(fwk291().regFwk291().fwk200Pedido().fwk200ZFimMov());
        }
        if (!fwk291().getStatusOk() && !fwk291().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK291 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk291().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a30000FormatarTitulo() ;
        if (progOk.isTrue()) {
            a30000FormatarHeader() ;
        }
        if (progOk.isTrue()) {
            while (!fwk291().getStatusOk() && progOk.isTrue()) {
                a31000TratarFwk501() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30000FormatarTitulo() {
        log(TraceLevel.Debug, "A30000-FORMATAR-TITULO");
        fwk501().regFwk501291.initialize() ;
        fwk501().setRecord(wsTitulo) ;
        fwk501().write(fwk501().regFwk501291) ;
        if (fwk501().getStatusOk()) {
            contRegEscrtFwk501.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ291A - FWK501 -WRITE TITULO- ");
            tabelaImpressao().linha09().impStatus().set(fwk501().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30000FormatarHeader() {
        log(TraceLevel.Debug, "A30000-FORMATAR-HEADER");
        fwk501().regFwk501291.initialize() ;
        fwk501().setRecord(wsCabecalho()) ;
        fwk501().write(fwk501().regFwk501291) ;
        if (fwk501().getStatusOk()) {
            contRegEscrtFwk501.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ291A - FWK501 -WRITE HEADER- ");
            tabelaImpressao().linha09().impStatus().set(fwk501().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarFwk501() {
        log(TraceLevel.Debug, "A31000-TRATAR-FWK501");
        a31100EscreverFwk501() ;
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                a31200ActPedido() ;
            }
        }
        if (progOk.isTrue()) {
            a15000LerFwk291() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100EscreverFwk501() {
        log(TraceLevel.Debug, "A31100-ESCREVER-FWK501");
        wsFwk501().wsCPaisIsoaCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CPaisIsoaCont());
        wsFwk501().wsCBancCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CBancCont());
        wsFwk501().wsCOeEgcCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200COeEgcCont());
        wsFwk501().wsNsRdclCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NsRdclCont());
        wsFwk501().wsVChkdCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200VChkdCont());
        wsFwk501().wsCTipoCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CTipoCont());
        wsFwk501().wsCMoedIsoScta().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CMoedIsoScta());
        wsFwk501().wsNsDeposito().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NsDeposito());
        wsFwk501().wsZMovimento().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200TsMovimento().get(1, 10));
        wsFwk501().wsZValMov().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200ZValMov());
        wsFwk501().wsXRefMov().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200XRefMov());
        wsMMovimento.set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200MMovimento());
        wsFwk501().wsMMovInt().set(wsMMovimentoMask().wsMMovimentoInt());
        wsFwk501().wsVirgMov().set(conVirgula);
        wsFwk501().wsMMovDec().set(wsMMovimentoMask().wsMMovimentoDec());
        switch (fwk291().regFwk291().fwk200FicheiroFgh500().fwk200IDbcr().get()) {
            case "C":
                if (fwk291().regFwk291().fwk200FicheiroFgh500().fwk200IEstorno().isEmpty()) {
                    wsFwk501().wsISnlMovimento().set("+");
                    wsFwk501().wsISnlMovMoe().set("+");
                } else {
                    wsFwk501().wsISnlMovimento().set("-");
                    wsFwk501().wsISnlMovMoe().set("-");
                }
                break;
            case "D":
                if (fwk291().regFwk291().fwk200FicheiroFgh500().fwk200IEstorno().isEmpty()) {
                    wsFwk501().wsISnlMovimento().set("-");
                    wsFwk501().wsISnlMovMoe().set("-");
                } else {
                    wsFwk501().wsISnlMovimento().set("+");
                    wsFwk501().wsISnlMovMoe().set("+");
                }
                break;
            default :
                break ;
        }
        wsFwk501().wsIDbcr().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200IDbcr());
        wsFwk501().wsIEstorno().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200IEstorno());
        if (fwk291().regFwk291().fwk200FicheiroFgh500().fwk200IEstorno().isEqual("E")) {
            wsFwk501().wsIEstorno().set("S");
        } else {
            wsFwk501().wsIEstorno().set("N");
        }
        wsMMovimento.set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200MSldoCbloApos());
        wsFwk501().wsMSldoCbloInt().set(wsMMovimentoMask().wsMMovimentoInt());
        wsFwk501().wsVirgCblo().set(conVirgula);
        wsFwk501().wsMSldoCbloDec().set(wsMMovimentoMask().wsMMovimentoDec());
        if (fwk291().regFwk291().fwk200FicheiroFgh500().fwk200MSldoCbloApos().isLess(0)) {
            wsFwk501().wsISnlSldoCblo().set("-");
        } else {
            wsFwk501().wsISnlSldoCblo().set("+");
        }
        wsMMovimento.set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200MSldoDpnlApos());
        wsFwk501().wsMSldoDpnlInt().set(wsMMovimentoMask().wsMMovimentoInt());
        wsFwk501().wsVirgDpnl().set(conVirgula);
        wsFwk501().wsMSldoDpnlDec().set(wsMMovimentoMask().wsMMovimentoDec());
        if (fwk291().regFwk291().fwk200FicheiroFgh500().fwk200MSldoDpnlApos().isLess(0)) {
            wsFwk501().wsISnlSldoDpnl().set("-");
        } else {
            wsFwk501().wsISnlSldoDpnl().set("+");
        }
        wsFwk501().wsNDocOpps().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NDocOpps());
        wsMMovimento.set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200MMovMoeOrigMov());
        wsFwk501().wsMMovMoeOrigInt().set(wsMMovimentoMask().wsMMovimentoInt());
        wsFwk501().wsVirgMoeOrig().set(conVirgula);
        wsFwk501().wsMMovMoeOrigDec().set(wsMMovimentoMask().wsMMovimentoDec());
        wsFwk501().wsCMoedIsoOriMov().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CMoedIsoOriMov());
        wsTJuro.set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200TJuro());
        wsFwk501().wsTJuroInt().set(wsTJuroMask().wsJuroInt());
        wsFwk501().wsVirgTaxa().set(conVirgula);
        wsFwk501().wsTJuroDec().set(wsTJuroMask().wsJuroDec());
        wsFwk501().wsAAplOrig().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200AAplOrig());
        wsFwk501().wsCUsidActzUlt().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CUsidActzUlt());
        wsFwk501().wsNsMovimento().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NsMovimento());
        wsFwk501().wsCTerminal().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CTerminal());
        wsFwk501().wsCTipoCanlAces().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CTipoCanlAces());
        wsFwk501().wsCPaisIsoaOeOpx().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CPaisIsoaOeOpx());
        wsFwk501().wsCMnemEgcOpex().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CMnemEgcOpex());
        wsFwk501().wsCOeEgcOpex().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200COeEgcOpex());
        wsFwk501().wsXRefAux().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200XRefAux());
        fwk501().setRecord(wsFwk501()) ;
        fwk501().write(fwk501().regFwk501291) ;
        if (fwk501().getStatusOk()) {
            contRegEscrtFwk501.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ291A - FWK501 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk501().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200ActPedido() {
        log(TraceLevel.Debug, "A31200-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk291().regFwk291().fwk200FicheiroFgh500().fwk200NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk291().regFwk291().fwk200Pedido().fwk200CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk291().regFwk291().fwk200Pedido().fwk200ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk291().regFwk291().fwk200Pedido().fwk200ZFimMov());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq291a812() ;
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
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichRead().set("FWK291");
            tabelaImpressao().linha05().impRegLidosFwk291().set(contRegLidosFwk291);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FWK501");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk501);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ291A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk291().close() ;
        fwk501().close() ;
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
        s00000ValidarParm() ;
        if (progOk.isTrue()) {
            s10000Iniciar() ;
        }
        if (progOk.isTrue()) {
            while (!fwk291().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface AreaParm extends IDataStruct {
        
        @Data(size=16, lpadding=2, rpadding=2)
        IString pEndcFtp() ;
        
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
    public interface WsMMovimentoMask extends IDataMask {
        
        @Data(size=15)
        ILong wsMMovimentoInt() ;
        
        @Data(size=2)
        IInt wsMMovimentoDec() ;
        
    }
    public interface WsTJuroMask extends IDataMask {
        
        @Data(size=3)
        IInt wsJuroInt() ;
        
        @Data(size=7)
        IInt wsJuroDec() ;
        
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
        IString wsCPaisIsoaContA() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancContA() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcContA() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclContA() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdContA() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoContA() ;
        
        @Data(size=3)
        IString wsCMoedIsoSctaA() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDepositoA() ;
        
        @Data(size=7)
        IString wsCPedInfOppsA() ;
        
        @Data(size=10)
        IString wsZInicMovA() ;
        
        @Data(size=10)
        IString wsZFimMovA() ;
        
    }
    public interface WsCabecalho extends IDataStruct {
        
        @Data(size=4, value="PAIS")
        IString filler001() ;
        
        @Data(size=1, value=";")
        IString filler002() ;
        
        @Data(size=5, value="BANCO")
        IString filler003() ;
        
        @Data(size=1, value=";")
        IString filler004() ;
        
        @Data(size=5, value="CONTA")
        IString filler005() ;
        
        @Data(size=1, value=";")
        IString filler006() ;
        
        @Data(size=3, value="MOE")
        IString filler007() ;
        
        @Data(size=1, value=";")
        IString filler008() ;
        
        @Data(size=4, value="DEP ")
        IString filler009() ;
        
        @Data(size=1, value=";")
        IString filler010() ;
        
        @Data(size=10, value="DATA MOVIM")
        IString filler011() ;
        
        @Data(size=1, value=";")
        IString filler012() ;
        
        @Data(size=10, value="DATA VALOR")
        IString filler013() ;
        
        @Data(size=1, value=";")
        IString filler014() ;
        
        @Data(size=14, value="DESC.MOVIMENTO")
        IString filler015() ;
        
        @Data(size=1, value=";")
        IString filler016() ;
        
        @Data(size=14, value="SEG.REFERENCIA")
        IString filler017() ;
        
        @Data(size=1, value=";")
        IString filler018() ;
        
        @Data(size=16, value="MONT.MOEDA CONTA")
        IString filler019() ;
        
        @Data(size=1, value=";")
        IString filler020() ;
        
        @Data(size=5, value="SINAL")
        IString filler021() ;
        
        @Data(size=1, value=";")
        IString filler022() ;
        
        @Data(size=6, value="TP MOV")
        IString filler023() ;
        
        @Data(size=1, value=";")
        IString filler024() ;
        
        @Data(size=6, value="ESTORN")
        IString filler025() ;
        
        @Data(size=1, value=";")
        IString filler026() ;
        
        @Data(size=10, value="SALDO APOS")
        IString filler027() ;
        
        @Data(size=1, value=";")
        IString filler028() ;
        
        @Data(size=5, value="SINAL")
        IString filler029() ;
        
        @Data(size=1, value=";")
        IString filler030() ;
        
        @Data(size=15, value="SALDO DISP APOS")
        IString filler031() ;
        
        @Data(size=1, value=";")
        IString filler032() ;
        
        @Data(size=5, value="SINAL")
        IString filler033() ;
        
        @Data(size=1, value=";")
        IString filler034() ;
        
        @Data(size=9, value="DOCUMENTO")
        IString filler035() ;
        
        @Data(size=1, value=";")
        IString filler036() ;
        
        @Data(size=17, value="MONT.MOEDA ORIGEM")
        IString filler037() ;
        
        @Data(size=1, value=";")
        IString filler038() ;
        
        @Data(size=5, value="SINAL")
        IString filler039() ;
        
        @Data(size=1, value=";")
        IString filler040() ;
        
        @Data(size=4, value="MOED")
        IString filler041() ;
        
        @Data(size=1, value=";")
        IString filler042() ;
        
        @Data(size=9, value="TAXA JURO")
        IString filler043() ;
        
        @Data(size=1, value=";")
        IString filler044() ;
        
        @Data(size=3, value="APL")
        IString filler045() ;
        
        @Data(size=1, value=";")
        IString filler046() ;
        
        @Data(size=8, value="OPERADOR")
        IString filler047() ;
        
        @Data(size=1, value=";")
        IString filler048() ;
        
        @Data(size=13, value="NUM MOVIMENTO")
        IString filler049() ;
        
        @Data(size=1, value=";")
        IString filler050() ;
        
        @Data(size=9, value="COD.TERM.")
        IString filler051() ;
        
        @Data(size=1, value=";")
        IString filler052() ;
        
        @Data(size=5, value="CANAL")
        IString filler053() ;
        
        @Data(size=1, value=";")
        IString filler054() ;
        
        @Data(size=10, value="PAIS OPER.")
        IString filler055() ;
        
        @Data(size=1, value=";")
        IString filler056() ;
        
        @Data(size=9, value="EMP.OPER.")
        IString filler057() ;
        
        @Data(size=1, value=";")
        IString filler058() ;
        
        @Data(size=12, value="BALCAO OPER.")
        IString filler059() ;
        
        @Data(size=1, value=";")
        IString filler060() ;
        
    }
    public interface WsFwk501 extends IDataStruct {
        
        @Data(size=4)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, lpadding=1, lpaddingValue=";")
        IInt wsCBancCont() ;
        
        @Data(size=4, lpadding=1, lpaddingValue=";")
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, lpadding=1, lpaddingValue=" ")
        IInt wsNsRdclCont() ;
        
        @Data(size=1, lpadding=1, lpaddingValue=" ")
        IInt wsVChkdCont() ;
        
        @Data(size=3, lpadding=1, lpaddingValue=" ")
        IInt wsCTipoCont() ;
        
        @Data(size=3, lpadding=1, lpaddingValue=";")
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, lpadding=1, lpaddingValue=";")
        IInt wsNsDeposito() ;
        
        @Data(size=10, lpadding=1, lpaddingValue=";")
        IString wsZMovimento() ;
        
        @Data(size=10, lpadding=1, lpaddingValue=";")
        IString wsZValMov() ;
        
        @Data(size=21, lpadding=1, lpaddingValue=";")
        IString wsXRefMov() ;
        
        @Data(size=16, lpadding=1, lpaddingValue=";")
        IString wsXRefAux() ;
        
        @Data(size=15, lpadding=1, lpaddingValue=";")
        ILong wsMMovInt() ;
        
        @Data(size=1)
        IString wsVirgMov() ;
        
        @Data(size=2)
        IInt wsMMovDec() ;
        
        @Data(size=1, lpadding=1, lpaddingValue=";")
        IString wsISnlMovimento() ;
        
        @Data(size=1, lpadding=1, lpaddingValue=";")
        IString wsIDbcr() ;
        
        @Data(size=1, lpadding=1, lpaddingValue=";")
        IString wsIEstorno() ;
        
        @Data(size=15, lpadding=1, lpaddingValue=";")
        ILong wsMSldoCbloInt() ;
        
        @Data(size=1)
        IString wsVirgCblo() ;
        
        @Data(size=2)
        IInt wsMSldoCbloDec() ;
        
        @Data(size=1, lpadding=1, lpaddingValue=";")
        IString wsISnlSldoCblo() ;
        
        @Data(size=15, lpadding=1, lpaddingValue=";")
        ILong wsMSldoDpnlInt() ;
        
        @Data(size=1)
        IString wsVirgDpnl() ;
        
        @Data(size=2)
        IInt wsMSldoDpnlDec() ;
        
        @Data(size=1, lpadding=1, lpaddingValue=";")
        IString wsISnlSldoDpnl() ;
        
        @Data(size=10, lpadding=1, lpaddingValue=";")
        ILong wsNDocOpps() ;
        
        @Data(size=15, lpadding=1, lpaddingValue=";")
        ILong wsMMovMoeOrigInt() ;
        
        @Data(size=1)
        IString wsVirgMoeOrig() ;
        
        @Data(size=2)
        IInt wsMMovMoeOrigDec() ;
        
        @Data(size=1, lpadding=1, lpaddingValue=";")
        IString wsISnlMovMoe() ;
        
        @Data(size=3, lpadding=1, lpaddingValue=";")
        IString wsCMoedIsoOriMov() ;
        
        @Data(size=3, lpadding=1, lpaddingValue=";")
        IInt wsTJuroInt() ;
        
        @Data(size=1)
        IString wsVirgTaxa() ;
        
        @Data(size=7)
        IInt wsTJuroDec() ;
        
        @Data(size=2, lpadding=1, lpaddingValue=";")
        IString wsAAplOrig() ;
        
        @Data(size=8, lpadding=1, lpaddingValue=";")
        IString wsCUsidActzUlt() ;
        
        @Data(size=15, lpadding=1, lpaddingValue=";")
        ILong wsNsMovimento() ;
        
        @Data(size=4, lpadding=1, lpaddingValue=";")
        IString wsCTerminal() ;
        
        @Data(size=4, lpadding=1, lpaddingValue=";")
        IString wsCTipoCanlAces() ;
        
        @Data(size=3, lpadding=1, lpaddingValue=";")
        IString wsCPaisIsoaOeOpx() ;
        
        @Data(size=3, lpadding=1, lpaddingValue=";")
        IString wsCMnemEgcOpex() ;
        
        @Data(size=4, lpadding=1, lpaddingValue=";")
        IInt wsCOeEgcOpex() ;
        
        @Data(size=1, value=";")
        IString filler001() ;
        
        @Data(size=27, value=" ")
        IString filler002() ;
        
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
         * @return instancia da classe local Linha0602
         */
        @Data
        Linha0602 linha0602() ;
        
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
            
            @Data(size=8, value="PGHQ291A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ291A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosFwk291() ;
            
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
        
        public interface Linha0602 extends IDataStruct {
            
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
