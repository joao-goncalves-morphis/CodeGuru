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
 * OBJECTIVO     : TRATAMENTO DO PEDIDO GH00002 - TERMINO
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq390a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps50001Infhst
     */
    @Data
    protected abstract Vwsdghps50001Infhst hv50001Infhst() ;
    
    /**
     * @return instancia da classe Vwsdghps50101Infhstcpl
     */
    @Data
    protected abstract Vwsdghps50101Infhstcpl hv50101Infhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="rwk00101Pghq390a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    /**
     * @return instancia da classe Fwk390
     */
    @Handler(name="FWK390", record="regFwk390")
    @Data
    protected abstract Fwk390 fwk390() ;
    
    
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
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtVgh50001 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtVgh50101 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk390 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt auxContRegLidos ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegCommit ;
    
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
        progOk.setTrue() ;
        wsChaveAnt().initialize() ;
        bghw0300().wsNmPrograma().set("PGHQ390A");
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
            a13000AbrirFwk900() ;
        }
        if (progOk.isTrue()) {
            a13100LerFwk900() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk390() ;
        }
        if (progOk.isTrue()) {
            while (contRegLidosFwk390.isLessOrEqual(auxContRegLidos) && !fwk390().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a15000LerFwk390() ;
            }
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
    protected void a13000AbrirFwk900() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWK900");
        fwk900().open(WRITE) ;
        if (!fwk900().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a13100LerFwk900() {
        log(TraceLevel.Debug, "A13100-LER-FWK900");
        fwk900().read() ;
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().rwk00101Pghq390a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a13200TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK900 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a13200TratarOutputFwk900() {
        /**
         * *----------------------------------------------------------------*
         */
        fwk900().open(CREATE ) ;
        if (fwk900().getStatusOk()) {
            fwk900().rwk00101Pghq390a().initialize() ;
            fwk900().rwk00101Pghq390a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().rwk00101Pghq390a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK900 - OPEN O-");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk390() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK390");
        fwk390().open() ;
        if (!fwk390().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK390 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk390().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk390() {
        log(TraceLevel.Debug, "A15000-LER-FWK390");
        fwk390().read() ;
        if (fwk390().getStatusOk()) {
            contRegLidosFwk390.add(1);
            wsChave().wsCPaisIsoaCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CPaisIsoaCont());
            wsChave().wsCBancCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CBancCont());
            wsChave().wsCOeEgcCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300COeEgcCont());
            wsChave().wsNsRdclCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsRdclCont());
            wsChave().wsVChkdCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300VChkdCont());
            wsChave().wsCTipoCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CTipoCont());
            wsChave().wsCMoedIsoScta().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CMoedIsoScta());
            wsChave().wsNsDeposito().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsDeposito());
            wsChave().wsCPedInfOpps().set(fwk390().regFwk390().fwk300Pedido().fwk300CPedInfOpps());
            wsChave().wsZInicMov().set(fwk390().regFwk390().fwk300Pedido().fwk300ZInicMov());
            wsChave().wsZFimMov().set(fwk390().regFwk390().fwk300Pedido().fwk300ZFimMov());
        }
        if (!fwk390().getStatusOk() && !fwk390().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK390 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk390().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000PreencherInformacao() ;
        if (progOk.isTrue()) {
            a32000InserirVgh50001() ;
        }
        if (progOk.isTrue()) {
            a33000InserirVgh50101() ;
        }
        if (progOk.isTrue()) {
            if (!wsChave().isEqual(wsChaveAnt())) {
                a34000ActPedido() ;
            }
        }
        if (progOk.isTrue()) {
            a35000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk390() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000PreencherInformacao() {
        log(TraceLevel.Debug, "A31000-PREENCHER-INFORMACAO");
        hv50001Infhst().infhst().initialize() ;
        hv50101Infhstcpl().infhstcpl().initialize() ;
        hv50001Infhst().infhst().cPaisIsoaCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CPaisIsoaCont());
        hv50101Infhstcpl().infhstcpl().cPaisIsoaCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CPaisIsoaCont());
        hv50001Infhst().infhst().cBancCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CBancCont());
        hv50101Infhstcpl().infhstcpl().cBancCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CBancCont());
        hv50001Infhst().infhst().cOeEgcCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300COeEgcCont());
        hv50101Infhstcpl().infhstcpl().cOeEgcCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300COeEgcCont());
        hv50001Infhst().infhst().nsRdclCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsRdclCont());
        hv50101Infhstcpl().infhstcpl().nsRdclCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsRdclCont());
        hv50001Infhst().infhst().vChkdCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300VChkdCont());
        hv50101Infhstcpl().infhstcpl().vChkdCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300VChkdCont());
        hv50001Infhst().infhst().cTipoCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CTipoCont());
        hv50101Infhstcpl().infhstcpl().cTipoCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CTipoCont());
        hv50001Infhst().infhst().cMoedIsoScta().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CMoedIsoScta());
        hv50101Infhstcpl().infhstcpl().cMoedIsoScta().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CMoedIsoScta());
        hv50001Infhst().infhst().nsDeposito().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsDeposito());
        hv50101Infhstcpl().infhstcpl().nsDeposito().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsDeposito());
        hv50001Infhst().infhst().tsMovimento().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300TsMovimento());
        hv50101Infhstcpl().infhstcpl().tsMovimento().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300TsMovimento());
        hv50001Infhst().infhst().nsMovimento().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsMovimento());
        hv50101Infhstcpl().infhstcpl().nsMovimento().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsMovimento());
        hv50001Infhst().infhst().zValMov().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300ZValMov());
        hv50001Infhst().infhst().zMovLocl().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300ZMovLocl());
        hv50001Infhst().infhst().iDbcr().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300IDbcr());
        hv50001Infhst().infhst().mMovimento().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300MMovimento());
        hv50001Infhst().infhst().iEstorno().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300IEstorno());
        hv50001Infhst().infhst().cMoedIsoOriMov().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CMoedIsoOriMov());
        hv50001Infhst().infhst().mSldoCbloApos().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300MSldoCbloApos());
        hv50001Infhst().infhst().mSldoDpnlApos().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300MSldoDpnlApos());
        hv50001Infhst().infhst().mMovMoeOrigMov().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300MMovMoeOrigMov());
        hv50001Infhst().infhst().xRefMov().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300XRefMov());
        hv50001Infhst().infhst().nDocOpps().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NDocOpps());
        hv50001Infhst().infhst().tJuro().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300TJuro());
        hv50001Infhst().infhst().aAplOrig().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300AAplOrig());
        hv50001Infhst().infhst().zEliminacao().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300ZEliminacao());
        hv50101Infhstcpl().infhstcpl().zEliminacao().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300ZEliminacao());
        hv50001Infhst().infhst().tsPedido().set(fwk390().regFwk390().fwk300Pedido().fwk300TsPedido());
        hv50001Infhst().infhst().tsActzUlt().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300TsActzUlt());
        hv50101Infhstcpl().infhstcpl().tsActzUlt().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300TsActzUlt());
        hv50001Infhst().infhst().cUsidActzUlt().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CUsidActzUlt());
        hv50101Infhstcpl().infhstcpl().cUsidActzUlt().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CUsidActzUlt());
        hv50101Infhstcpl().infhstcpl().cTransaccao().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CTransaccao());
        hv50101Infhstcpl().infhstcpl().aAplicacao().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300AAplicacao());
        hv50101Infhstcpl().infhstcpl().cOpczMenu().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300COpczMenu());
        hv50101Infhstcpl().infhstcpl().cOpeBbn().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300COpeBbn());
        hv50101Infhstcpl().infhstcpl().cEvenOpel().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CEvenOpel());
        hv50101Infhstcpl().infhstcpl().cTerminal().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CTerminal());
        hv50101Infhstcpl().infhstcpl().cOperador().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300COperador());
        hv50101Infhstcpl().infhstcpl().cOpexAtrx().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300COpexAtrx());
        hv50101Infhstcpl().infhstcpl().cUserid().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CUserid());
        hv50101Infhstcpl().infhstcpl().cTipoCanlAces().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CTipoCanlAces());
        hv50101Infhstcpl().infhstcpl().cPaisIsoaOeOpx().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CPaisIsoaOeOpx());
        hv50101Infhstcpl().infhstcpl().cMnemEgcOpex().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CMnemEgcOpex());
        hv50101Infhstcpl().infhstcpl().cOeEgcOpex().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300COeEgcOpex());
        hv50101Infhstcpl().infhstcpl().cProdSgop().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CProdSgop());
        hv50101Infhstcpl().infhstcpl().cFamiProd().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CFamiProd());
        hv50101Infhstcpl().infhstcpl().cProduto().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CProduto());
        hv50101Infhstcpl().infhstcpl().cCndzMovzCont().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CCndzMovzCont());
        hv50101Infhstcpl().infhstcpl().cGrupCont().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CGrupCont());
        hv50101Infhstcpl().infhstcpl().cSectIttlBpor().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300CSectIttlBpor());
        hv50101Infhstcpl().infhstcpl().tCambio().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300TCambio());
        hv50101Infhstcpl().infhstcpl().mSldoRetd().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300MSldoRetd());
        hv50101Infhstcpl().infhstcpl().mSldoVcob().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300MSldoVcob());
        hv50101Infhstcpl().infhstcpl().mCmrgLim().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300MCmrgLim());
        hv50101Infhstcpl().infhstcpl().mCmrgUtid().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300MCmrgUtid());
        hv50101Infhstcpl().infhstcpl().mDcboNgcdAtrd().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdAtrd());
        hv50101Infhstcpl().infhstcpl().mDcboNgcdUtid().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300MDcboNgcdUtid());
        hv50101Infhstcpl().infhstcpl().nJourBbn().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300NJourBbn());
        hv50101Infhstcpl().infhstcpl().nsJourBbn().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300NsJourBbn());
        hv50101Infhstcpl().infhstcpl().nsJourBbnDtlh().set(fwk390().regFwk390().fwk300Tgh00501Infhstcpl().fwk300NsJourBbnDtlh());
    }
    
    /**
     * 
     * 
     */
    protected void a32000InserirVgh50001() {
        log(TraceLevel.Debug, "A32000-INSERIR-VGH50001");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH50001_INFHST
         */
        hv50001Infhst().insertPghq390a613() ;
        if (hv50001Infhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegEscrtVgh50001.add(1);
        } else {
            wSqlcode.set(hv50001Infhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("- INSERT VGH50001 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000InserirVgh50101() {
        log(TraceLevel.Debug, "A33000-INSERIR-VGH50101");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH50101_INFHSTCPL
         */
        hv50101Infhstcpl().insertPghq390a700() ;
        if (hv50101Infhstcpl().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegEscrtVgh50101.add(1);
        } else {
            wSqlcode.set(hv50101Infhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("- INSERT VGH50101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000ActPedido() {
        log(TraceLevel.Debug, "A34000-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk390().regFwk390().fwk300Tgh00500Infhst().fwk300NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk390().regFwk390().fwk300Pedido().fwk300CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk390().regFwk390().fwk300Pedido().fwk300ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk390().regFwk390().fwk300Pedido().fwk300ZFimMov());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq390a830() ;
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
    protected void a35000ControlaCommit() {
        log(TraceLevel.Debug, "A35000-CONTROLA-COMMIT");
        contRegCommit.add(1);
        if (contRegCommit.isEqual(1000)) {
            commit() ;
            a35100EscreverFwk900() ;
            if (progOk.isTrue()) {
                contRegCommit.set(0);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35100EscreverFwk900() {
        /**
         * *----------------------------------------------------------------*
         */
        a13000AbrirFwk900() ;
        if (progOk.isTrue()) {
            fwk900().read() ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK900 - READ - ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk900().rwk00101Pghq390a().initialize() ;
            fwk900().rwk00101Pghq390a().fwk900NCommit().set(contRegCommit);
            fwk900().rewrite() ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ390A - FWK900 - REWRITE -");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk900().close() ;
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
            tabelaImpressao().linha05().impFichRead().set("FWK390");
            tabelaImpressao().linha05().impRegLidosFwk390().set(contRegLidosFwk390);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("VGH50001");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtVgh50001);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("VGH50011");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtVgh50101);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ390A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk390().close() ;
        fwk900().close() ;
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
            while (!fwk390().getStatusOk() && progOk.isTrue()) {
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
            
            @Data(size=8, value="PGHQ390A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ390A")
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
            IFormattedString impRegLidosFwk390() ;
            
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
