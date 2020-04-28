package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl202a ;
import cgd.gh.structures.work.Bghw0017 ;


/**
 * 
 * DECLARACAO DE CURSORES
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS DE ASSIVAS
 * DESCRICAO     : CRIA PEDIDOS NA TABELA TGH00015_PEDMOVHST
 * 
 * migrated from program [MGHJ202A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj202a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl202a
     */
    @Data
    public abstract Bghl202a bghl202a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    /**
     * @return instancia da classe Vwsdghps01801Pedinf
     */
    @Data
    protected abstract Vwsdghps01801Pedinf hv01801Pedinf() ;
    
    /**
     * @return instancia da classe Vwsdghps00101Conthst
     */
    @Data
    protected abstract Vwsdghps00101Conthst hv00101Conthst() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0017
     */
    @Data
    protected abstract Bghw0017 bghw0017() ;
    
    /**
     * ***     AREA DE TRABALHO           ***
     */
    @Data(size=4, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("093")
    protected ICondition progJaExiste ;
    @Data
    @Condition("094")
    protected ICondition progEstadoInv ;
    @Data
    @Condition("095")
    protected ICondition progPedidoInvalido ;
    @Data
    @Condition("096")
    protected ICondition progPedidoConcluido ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtlMoeda ;
    @Data
    @Condition("S")
    protected ICondition haMoedaDiferente ;
    @Data
    @Condition("D")
    protected ICondition haDataMoedaDiferente ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlOrdemRef ;
    @Data
    @Condition("1")
    protected ICondition primeiroRegisto ;
    @Data
    @Condition("2")
    protected ICondition segundoRegisto ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlAnulacao ;
    @Data
    @Condition("P")
    protected ICondition anulacaoTsPedido ;
    @Data
    @Condition("T")
    protected ICondition anulacaoConta ;
    
    
    @Data(size=26)
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=15, signed=true, compression=COMP3)
    protected ILong wsTsPedido ;
    
    @Data(size=15)
    protected ILong wTsPedido ;
    
    /**
     * @return instancia da classe local WTsPedidoMask
     */
    @Data
    @Mask
    protected abstract WTsPedidoMask wTsPedidoMask() ;
    
    
    
    /**
     * 
     * 
     */
    public void s10000Iniciar() {
        progOk.setTrue() ;
        bghl202a().dadosOutput().grErroBbn().cTipoErroBbn().initialize() ;
        bghl202a().dadosOutput().grErroBbn().cRtnoSwal().initialize() ;
        bghl202a().dadosOutput().grErroBbn().nmTabela().initialize() ;
        bghl202a().dadosOutput().grErroBbn().cSqlcode().initialize() ;
        bghl202a().dadosOutput().grErroBbn().aAplErro().initialize() ;
        bghl202a().dadosOutput().idPedido().zInicMovO().initialize() ;
        bghl202a().dadosOutput().idPedido().zFimMovO().initialize() ;
        bghl202a().dadosOutput().idPedido().tsPedido().initialize() ;
        bghl202a().dadosOutput().idPedido().zCluzPed().initialize() ;
        bghl202a().dadosOutput().idPedido().xMtvoDvlzPed().initialize() ;
        if (!bghl202a().dadosInput().accaoValida().isTrue()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl202a().dadosInput().criacao().isTrue()) {
                if (bghl202a().dadosInput().cPedInfOpps().isEmpty() || 
                    bghl202a().dadosInput().argumentoScta().cPaisIsoaCont().isEmpty() || 
                    bghl202a().dadosInput().argumentoScta().cBancCont().isEqual(0) || 
                    bghl202a().dadosInput().argumentoScta().cOeEgcCont().isEqual(0) || 
                    bghl202a().dadosInput().argumentoScta().cMoedIsoScta().isEmpty() || 
                    bghl202a().dadosInput().argumentoPedido().cCanlTrmzInf().isEmpty() || 
                    bghl202a().dadosInput().argumentoOrigem().cUsidCrix().isEmpty() || 
                    bghl202a().dadosInput().argumentoOrigem().cPaisIsoaOeOpx().isEmpty() || 
                    bghl202a().dadosInput().argumentoOrigem().cMnemEgcOpex().isEmpty() || 
                    bghl202a().dadosInput().argumentoOrigem().cOeEgcOpex().isEqual(0)) {
                    progDadosInvalidos.setTrue() ;
                }
            } else if (bghl202a().dadosInput().argumentoChvPedido().tsPedidoAnula().isEqual(0) && 
                (bghl202a().dadosInput().cPedInfOpps().isEmpty() || 
                bghl202a().dadosInput().cPedInfOpps().isEmpty() || 
                bghl202a().dadosInput().argumentoScta().cPaisIsoaCont().isEmpty() || 
                bghl202a().dadosInput().argumentoScta().cBancCont().isEqual(0) || 
                bghl202a().dadosInput().argumentoScta().cOeEgcCont().isEqual(0) || 
                bghl202a().dadosInput().argumentoScta().cMoedIsoScta().isEmpty() || 
                bghl202a().dadosInput().argumentoDataMov().zInicMov().isEmpty() || 
                bghl202a().dadosInput().argumentoDataMov().zFimMov().isEmpty() || 
                bghl202a().dadosInput().argumentoPedido().cCanlTrmzInf().isEmpty() || 
                bghl202a().dadosInput().argumentoOrigem().cUsidCrix().isEmpty() || 
                bghl202a().dadosInput().argumentoOrigem().cPaisIsoaOeOpx().isEmpty() || 
                bghl202a().dadosInput().argumentoOrigem().cMnemEgcOpex().isEmpty() || 
                bghl202a().dadosInput().argumentoOrigem().cOeEgcOpex().isEqual(0))) {
                progDadosInvalidos.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            if (!bghl202a().dadosInput().argumentoPedido().aAplDest().isEqual("HJ")) {
                if (bghl202a().dadosInput().argumentoDataMov().zInicMov().isEmpty() || 
                    bghl202a().dadosInput().argumentoDataMov().zFimMov().isEmpty() || 
                    bghl202a().dadosInput().argumentoDataMov().zInicMov().isEqual("0001-01-01") || 
                    bghl202a().dadosInput().argumentoDataMov().zFimMov().isEqual("0001-01-01")) {
                    progDadosInvalidos.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (bghl202a().dadosInput().anulacao().isTrue()) {
                if (bghl202a().dadosInput().argumentoChvPedido().tsPedidoAnula().isGreater(0)) {
                    anulacaoTsPedido.setTrue() ;
                } else {
                    anulacaoConta.setTrue() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void s30000Processar() {
        a31000ValidarPedido() ;
        if (progOk.isTrue()) {
            if (bghl202a().dadosInput().criacao().isTrue()) {
                /**
                 * IF NOT MGH202A-MOV-2-VIAS
                 */
                a32000ValidarDatasCriterio() ;
                /**
                 * END-IF
                 */
                if (progOk.isTrue()) {
                    primeiroRegisto.setTrue() ;
                    a33000FormatarPedido() ;
                    if (progOk.isTrue()) {
                        a34000InsTabelaPedidos() ;
                    }
                }
                if (progOk.isTrue()) {
                    if (haDataMoedaDiferente.isTrue()) {
                        segundoRegisto.setTrue() ;
                        a33000FormatarPedido() ;
                        if (progOk.isTrue()) {
                            a34000InsTabelaPedidos() ;
                        }
                    }
                }
            } else if (anulacaoTsPedido.isTrue()) {
                a35000AnulaPedidoTs() ;
            } else {
                a36000AnulaPedidoConta() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a31000ValidarPedido() {
        hv01801Pedinf().pedinf().initialize() ;
        hv01801Pedinf().pedinf().cPedInfOpps().set(bghl202a().dadosInput().cPedInfOpps());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01801_PEDINF
         */
        hv01801Pedinf().selectMghj202a377() ;
        if (hv01801Pedinf().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a32000ValidarDatasCriterio() {
        wsCrtlMoeda.set(" ");
        wsCrtlOrdemRef.set(" ");
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cPaisIsoaCont().set(bghl202a().dadosInput().argumentoScta().cPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(bghl202a().dadosInput().argumentoScta().cBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(bghl202a().dadosInput().argumentoScta().cOeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(bghl202a().dadosInput().argumentoScta().nsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(bghl202a().dadosInput().argumentoScta().vChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(bghl202a().dadosInput().argumentoScta().cTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(bghl202a().dadosInput().argumentoScta().cMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(bghl202a().dadosInput().argumentoScta().nsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00101_CONTHST
         */
        hv00101Conthst().selectMghj202a419() ;
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl202a().dadosInput().cPedInfOpps().isEqual("GH00012") && 
                bghl202a().dadosInput().argumentoPedido().aAplDest().isEqual("HJ")) {
                bghl202a().dadosInput().argumentoDataMov().zFimMov().set(hv00101Conthst().conthst().zMovHistUlt());
                bghl202a().dadosInput().argumentoDataMov().zInicMov().set(hv00101Conthst().conthst().zMovHistUlt());
            } else {
                if (!hv00101Conthst().conthst().zAbraCont().isEqual("0001-01-01")) {
                    if (bghl202a().dadosInput().argumentoDataMov().zInicMov().isLess(hv00101Conthst().conthst().zAbraCont())) {
                        bghl202a().dadosInput().argumentoDataMov().zInicMov().set(hv00101Conthst().conthst().zAbraCont());
                    }
                }
                if (!hv00101Conthst().conthst().zCcltCont().isEqual("0001-01-01")) {
                    if (bghl202a().dadosInput().argumentoDataMov().zFimMov().isGreater(hv00101Conthst().conthst().zCcltCont())) {
                        bghl202a().dadosInput().argumentoDataMov().zFimMov().set(hv00101Conthst().conthst().zCcltCont());
                    }
                }
                if (bghl202a().dadosInput().argumentoDataMov().zFimMov().isGreater(hv00101Conthst().conthst().zMovHistUlt())) {
                    bghl202a().dadosInput().argumentoDataMov().zFimMov().set(hv00101Conthst().conthst().zMovHistUlt());
                }
            }
        }
        if (progOk.isTrue()) {
            if (!hv00101Conthst().conthst().cMoedIsoAntEur().isEqual(bghl202a().dadosInput().argumentoScta().cMoedIsoScta())) {
                if (bghw0017().wZInicTrocaMoeda().isGreater(bghl202a().dadosInput().argumentoDataMov().zInicMov()) && 
                    bghw0017().wZInicTrocaMoeda().isGreater(bghl202a().dadosInput().argumentoDataMov().zFimMov())) {
                    haMoedaDiferente.setTrue() ;
                } else if (bghw0017().wZInicTrocaMoeda().isGreater(bghl202a().dadosInput().argumentoDataMov().zInicMov())) {
                    haDataMoedaDiferente.setTrue() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a33000FormatarPedido() {
        wsTimestamp.set( getDBTimestamp() ) ;
        wTimestamp().set(wsTimestamp);
        wTsPedidoMask().wAnoPedido().set(wTimestamp().wDataTimestamp().wAnoAa());
        wTsPedidoMask().wMesPedido().set(wTimestamp().wDataTimestamp().wMesMm());
        wTsPedidoMask().wDiaPedido().set(wTimestamp().wDataTimestamp().wDiaDd());
        wTsPedidoMask().wHhPedido().set(wTimestamp().wTimerTimestamp().wHh());
        wTsPedidoMask().wMmPedido().set(wTimestamp().wTimerTimestamp().wMm());
        wTsPedidoMask().wSsPedido().set(wTimestamp().wTimerTimestamp().wSs());
        wTsPedidoMask().wDdPedido().set(wTimestamp().wTimerTimestamp().wDd().get(1, 1));
        wsTsPedido.set(wTsPedido);
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl202a().dadosInput().cPedInfOpps());
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl202a().dadosInput().argumentoScta().cPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(bghl202a().dadosInput().argumentoScta().cBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghl202a().dadosInput().argumentoScta().cOeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghl202a().dadosInput().argumentoScta().nsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghl202a().dadosInput().argumentoScta().vChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghl202a().dadosInput().argumentoScta().cTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghl202a().dadosInput().argumentoScta().cMoedIsoScta());
        if (haMoedaDiferente.isTrue()) {
            hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(hv00101Conthst().conthst().cMoedIsoAntEur());
        } else if (haDataMoedaDiferente.isTrue()) {
            if (primeiroRegisto.isTrue()) {
                hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(hv00101Conthst().conthst().cMoedIsoAntEur());
            }
        }
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghl202a().dadosInput().argumentoScta().nsDeposito());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(bghl202a().dadosInput().argumentoDataMov().zInicMov());
        if (haDataMoedaDiferente.isTrue()) {
            if (segundoRegisto.isTrue()) {
                hv01501Pedmovhst().pedmovhst().zInicMov().set(bghw0017().wZInicTrocaMoeda());
            }
        }
        hv01501Pedmovhst().pedmovhst().zFimMov().set(bghl202a().dadosInput().argumentoDataMov().zFimMov());
        if (haDataMoedaDiferente.isTrue()) {
            if (primeiroRegisto.isTrue()) {
                hv01501Pedmovhst().pedmovhst().zFimMov().set(bghw0017().wZInicTrocaMoeda());
            }
        }
        hv01501Pedmovhst().pedmovhst().tsPedido().set(wsTsPedido);
        hv01501Pedmovhst().pedmovhst().zPedido().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("A");
        hv01501Pedmovhst().pedmovhst().aAplDest().set(bghl202a().dadosInput().argumentoPedido().aAplDest());
        hv01501Pedmovhst().pedmovhst().cCanlTrmzInf().set(bghl202a().dadosInput().argumentoPedido().cCanlTrmzInf());
        hv01501Pedmovhst().pedmovhst().cEndcFtpDest().set(bghl202a().dadosInput().argumentoPedido().cEndcFtpDest());
        hv01501Pedmovhst().pedmovhst().zCluzPed().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().zEliminacao().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().cUsidCrix().set(bghl202a().dadosInput().argumentoOrigem().cUsidCrix());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghl202a().dadosInput().argumentoOrigem().cUsidCrix());
        hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx().set(bghl202a().dadosInput().argumentoOrigem().cPaisIsoaOeOpx());
        hv01501Pedmovhst().pedmovhst().cMnemEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cMnemEgcOpex());
        hv01501Pedmovhst().pedmovhst().cOeEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cOeEgcOpex());
        hv01501Pedmovhst().pedmovhst().cFrmtInf().set(hv01801Pedinf().pedinf().cFrmtInf());
        hv01501Pedmovhst().pedmovhst().cTipoRpte().set(hv01801Pedinf().pedinf().cTipoRpte());
        hv01501Pedmovhst().pedmovhst().nmFichOutpRtno().set(hv01801Pedinf().pedinf().nmFichOutpRtno());
        hv01501Pedmovhst().pedmovhst().qDiaDpnzInf().set(hv01801Pedinf().pedinf().qDiaDpnzInf());
    }
    
    /**
     * 
     * 
     */
    public void a34000InsTabelaPedidos() {
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().insertMghj202a580() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.DUPLICATED) {
            a36000AnulaPedidoConta() ;
        }
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.DUPLICATED && 
            hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a35000AnulaPedidoTs() {
        a35100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a35200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            if (hv01501Pedmovhst().pedmovhst().cEstPedHist().isEqual("A")) {
                while (getPersistenceCode() == PersistenceCode.NORMAL) {
                    a35300AnulaPedidoTgh15() ;
                }
            } else {
                progEstadoInv.setTrue() ;
            }
        }
        if (progOk.isTrue() || progEstadoInv.isTrue()) {
            a35400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a35100OpenCursorC1() {
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl202a().dadosInput().cPedInfOpps());
        hv01501Pedmovhst().pedmovhst().tsPedido().set(bghl202a().dadosInput().argumentoChvPedido().tsPedidoAnula());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01501Pedmovhst().openMghj202a695() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a35200FetchCursorC1() {
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv01501Pedmovhst().fetchMghj202a710() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        log(TraceLevel.Trace, "SQLCODE -", wSqlcode);
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
            progDb2.setTrue() ;
            a35400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a35300AnulaPedidoTgh15() {
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("N");
        hv01501Pedmovhst().pedmovhst().zEliminacao().set(hv01501Pedmovhst().pedmovhst().zPedido());
        hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx().set(bghl202a().dadosInput().argumentoOrigem().cPaisIsoaOeOpx());
        hv01501Pedmovhst().pedmovhst().cMnemEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cMnemEgcOpex());
        hv01501Pedmovhst().pedmovhst().cOeEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cOeEgcOpex());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghl202a().dadosInput().argumentoOrigem().cUsidCrix());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updateMghj202a778() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            a35200FetchCursorC1() ;
        } else {
            progDb2.setTrue() ;
            a35400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a35400CloseCursorC1() {
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv01501Pedmovhst().closeMghj202a803() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a36000AnulaPedidoConta() {
        a36100OpenCursorC2() ;
        if (progOk.isTrue()) {
            a36200FetchCursorC2() ;
        }
        if (progOk.isTrue()) {
            if (bghl202a().dadosInput().criacao().isTrue()) {
                switch (hv01501Pedmovhst().pedmovhst().cEstPedHist().get()) {
                    case "N":
                        a36500ActPedidoTgh15() ;
                        break;
                    case "A":
                        progJaExiste.setTrue() ;
                        break;
                    case "C":
                        progPedidoConcluido.setTrue() ;
                        break;
                    default :
                        progPedidoInvalido.setTrue() ;
                        break;
                }
            } else if (hv01501Pedmovhst().pedmovhst().cEstPedHist().isEqual("A")) {
                while (getPersistenceCode() == PersistenceCode.NORMAL) {
                    a36300AnulaPedidoTgh15() ;
                }
            } else {
                progEstadoInv.setTrue() ;
            }
        }
        if (progOk.isTrue() || progEstadoInv.isTrue()) {
            a36400CloseCursorC2() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a36100OpenCursorC2() {
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl202a().dadosInput().argumentoScta().cPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghl202a().dadosInput().argumentoScta().cPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(bghl202a().dadosInput().argumentoScta().cBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghl202a().dadosInput().argumentoScta().cOeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghl202a().dadosInput().argumentoScta().nsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghl202a().dadosInput().argumentoScta().vChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghl202a().dadosInput().argumentoScta().cTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghl202a().dadosInput().argumentoScta().cMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghl202a().dadosInput().argumentoScta().nsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(bghl202a().dadosInput().cPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(bghl202a().dadosInput().argumentoDataMov().zInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(bghl202a().dadosInput().argumentoDataMov().zFimMov());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv01501Pedmovhst().openMghj202a872() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a36200FetchCursorC2() {
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C2
         */
        hv01501Pedmovhst().fetchMghj202a888() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NOTFND) {
            progDb2.setTrue() ;
            a36400CloseCursorC2() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a36300AnulaPedidoTgh15() {
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("N");
        hv01501Pedmovhst().pedmovhst().zEliminacao().set(hv01501Pedmovhst().pedmovhst().zPedido());
        hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx().set(bghl202a().dadosInput().argumentoOrigem().cPaisIsoaOeOpx());
        hv01501Pedmovhst().pedmovhst().cMnemEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cMnemEgcOpex());
        hv01501Pedmovhst().pedmovhst().cOeEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cOeEgcOpex());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghl202a().dadosInput().argumentoOrigem().cUsidCrix());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updateMghj202a926() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            a36200FetchCursorC2() ;
        } else {
            progDb2.setTrue() ;
            a36400CloseCursorC2() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a36500ActPedidoTgh15() {
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("A");
        hv01501Pedmovhst().pedmovhst().zEliminacao().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx().set(bghl202a().dadosInput().argumentoOrigem().cPaisIsoaOeOpx());
        hv01501Pedmovhst().pedmovhst().cMnemEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cMnemEgcOpex());
        hv01501Pedmovhst().pedmovhst().cOeEgcOpex().set(bghl202a().dadosInput().argumentoOrigem().cOeEgcOpex());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghl202a().dadosInput().argumentoOrigem().cUsidCrix());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updateMghj202a962() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            a36400CloseCursorC2() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a36400CloseCursorC2() {
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C2
         */
        hv01501Pedmovhst().closeMghj202a987() ;
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void s50000Responder() {
        bghl202a().dadosOutput().grErroBbn().cRtnoSwal().set(progStatus);
        if (progOk.isTrue()) {
            if (bghl202a().dadosInput().criacao().isTrue()) {
                bghl202a().dadosOutput().idPedido().tsPedido().set(wsTsPedido);
                bghl202a().dadosOutput().idPedido().zInicMovO().set(bghl202a().dadosInput().argumentoDataMov().zInicMov());
                bghl202a().dadosOutput().idPedido().zFimMovO().set(bghl202a().dadosInput().argumentoDataMov().zFimMov());
            }
        } else {
            bghl202a().dadosOutput().grErroBbn().nmTabela().set("VGH01501");
            bghl202a().dadosOutput().grErroBbn().cSqlcode().set(getPersistenceCode());
            bghl202a().dadosOutput().grErroBbn().aAplErro().set("GH");
            bghl202a().dadosOutput().grErroBbn().abend().setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            s30000Processar() ;
        }
        s50000Responder() ;
        exit() ;
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
    
    public interface WTsPedidoMask extends IDataMask {
        
        @Data(size=4)
        IInt wAnoPedido() ;
        
        @Data(size=2)
        IInt wMesPedido() ;
        
        @Data(size=2)
        IInt wDiaPedido() ;
        
        @Data(size=2)
        IInt wHhPedido() ;
        
        @Data(size=2)
        IInt wMmPedido() ;
        
        @Data(size=2)
        IInt wSsPedido() ;
        
        @Data(size=1)
        IInt wDdPedido() ;
        
    }
}
