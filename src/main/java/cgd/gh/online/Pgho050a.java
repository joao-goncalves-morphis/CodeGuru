package cgd.gh.online;

import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV2 ;
import cgd.framework.envelope.CgdMessageV2 ;
import cgd.framework.envelope.CgdFooterV2 ;
import cgd.gh.structures.messages.Bghm0500 ;
import cgd.gh.structures.messages.Bghm0501 ;
import cgd.gh.structures.work.Bghw0010 ;
import cgd.gh.structures.work.Bghw0017 ;
import cgd.gh.routines.Mghs015a ;
import cgd.gh.routines.Mghs016a ;
import cgd.gh.routines.Mghs018a ;
import cgd.gh.routines.Mghs001a ;
import cgd.gh.routines.Mghs110a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CARREGMENTO DE PEDIDOS DE INFORMACAO
 * NOTA          : PEDIDOS COM MAIS DE 2 ANOS SO PERMITE CARREGAR*
 * UM POR CONTA
 * ALTERACOES    : 2011-03-14 - TRATAMENTO ESPECIAL PARA OS
 * PEDIDOS DA TAPE GHSA1999
 * : 2011-12-15 - GIP GH805 - ACT0643
 * : 2019-10-09 - PREÇÁRIO 2019 - INCLUSÃO GH00107
 * : CONVERSÃO PARA ALNOVA V2
 * : 2019-12-16 - GH 2292: DESCOMENTAR MOVE DO
 * CAMPO BGHM0500-C-MOED-ISO-SCTA NO ACESSO
 * AH ROTINA MGHS110A
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho050a extends CgdGhBaseOnline<Pgho050a.EnvelopeIn, Pgho050a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0500
     */
    public abstract Bghm0500 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0501
     */
    public abstract Bghm0501 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm0500.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm0501.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV2, MessageIn, CgdFooterV2, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV2, MessageOut, CgdFooterV2, CgdEnvelope {
    }
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs015a
     */
    @Data
    protected abstract Mghs015a hrMghs015a() ;
    
    /**
     * @return instancia da classe Mghs016a
     */
    @Data
    protected abstract Mghs016a hrMghs016a() ;
    
    /**
     * @return instancia da classe Mghs018a
     */
    @Data
    protected abstract Mghs018a hrMghs018a() ;
    
    /**
     * @return instancia da classe Mghs001a
     */
    @Data
    protected abstract Mghs001a hrMghs001a() ;
    
    /**
     * @return instancia da classe Mghs110a
     */
    @Data
    protected abstract Mghs110a hrMghs110a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bghw0010
     */
    @Data
    protected abstract Bghw0010 bghw0010() ;
    
    /**
     * @return instancia da classe Bghw0017
     */
    @Data
    protected abstract Bghw0017 bghw0017() ;
    
    /**
     * COPY BGHW9998.
     * ***     AREAS DE TRABALHO COMUM    ***
     */
    @Data(size=3, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("088")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("089")
    protected ICondition progJaExiste ;
    @Data
    @Condition("079")
    protected ICondition progAutorizacao ;
    @Data
    @Condition("095")
    protected ICondition progPedInvalido ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    @Data
    @Condition("211")
    protected ICondition progAcesso ;
    @Data
    @Condition("094")
    protected ICondition progEstadoPedInv ;
    @Data
    @Condition("091")
    protected ICondition progDataMinInv ;
    @Data
    @Condition("092")
    protected ICondition progDataMaxInv ;
    @Data
    @Condition("072")
    protected ICondition progHaPedSubconta ;
    @Data
    @Condition("076")
    protected ICondition progCanalInv ;
    @Data
    @Condition("073")
    protected ICondition progAplDstInv ;
    @Data
    @Condition("074")
    protected ICondition progOeDstInv ;
    @Data
    @Condition("075")
    protected ICondition progEnderecoInv ;
    @Data
    @Condition("099")
    protected ICondition progNaoExisteInf ;
    @Data
    @Condition("095")
    protected ICondition progPedidoInv ;
    @Data
    @Condition("066")
    protected ICondition progNaoExisMovHstAno ;
    
    
    @Data(size=1)
    protected IString wsCrtlPedHoje ;
    @Data
    @Condition("H")
    protected ICondition pedidoHoje ;
    @Data
    @Condition("D")
    protected ICondition pedidoDia ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlPedido ;
    @Data
    @Condition("N")
    protected ICondition pedidoNovo ;
    @Data
    @Condition("A")
    protected ICondition pedidoAntigo ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlTape ;
    @Data
    @Condition("8")
    protected ICondition tapeGrande ;
    
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    protected static final int CON_DSO = 987 ;
    
    @Data(size=2, value="0")
    protected IInt wsQItens ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtSair ;
    @Data
    @Condition("1")
    protected ICondition naoSair ;
    @Data
    @Condition("2")
    protected ICondition sair ;
    
    
    @Data(size=2, value="0")
    protected IInt wsAnos ;
    
    @Data(size=4, value="0")
    protected IInt wsZaAnos ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH01801")
    protected IString wsNmRecurso ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsCEibresp ;
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=4, value="0")
    protected IInt wsCOeEgcDst ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=10, value=" ")
    protected IString wsZEliminacao ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong wsTsPedido ;
    
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
    protected IString wsCrtlOeDst ;
    @Data
    @Condition("O")
    protected ICondition haOeDst ;
    @Data
    @Condition("N")
    protected ICondition naoHaOeDst ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlMais ;
    @Data
    @Condition("3")
    protected ICondition haMais ;
    @Data
    @Condition("4")
    protected ICondition naoHaMais ;
    
    
    /**
     * @return instancia da classe local WsDataToday
     */
    @Data
    protected abstract WsDataToday wsDataToday() ;
    
    @Data(size=4)
    protected IInt wsZaMinimo ;
    
    @Data(size=4)
    protected IInt wsZaMaximo ;
    
    /**
     * @return instancia da classe local WData
     */
    @Data
    protected abstract WData wData() ;
    
    /**
     * @return instancia da classe local WDataInic
     */
    @Data
    protected abstract WDataInic wDataInic() ;
    
    /**
     * @return instancia da classe local WDataFim
     */
    @Data
    protected abstract WDataFim wDataFim() ;
    
    @Data(size=2)
    protected IString wsCCanlTrnzInf ;
    @Data
    @Condition({ "FT", "CD", "TD", "DC", "OA" })
    protected ICondition canlTrnzValido ;
    @Data
    @Condition("FT")
    protected ICondition fileTransfer ;
    @Data
    @Condition("CD")
    protected ICondition connectDirect ;
    @Data
    @Condition("TD")
    protected ICondition controlD ;
    @Data
    @Condition("DC")
    protected ICondition disco ;
    @Data
    @Condition("OA")
    protected ICondition outrasAplicacoes ;
    
    
    @Data(size=7)
    protected IString wsCPedInfOpps ;
    @Data
    @Condition("GH00001")
    protected ICondition ficheiro ;
    @Data
    @Condition("GH00003")
    protected ICondition ficheiroRepsol ;
    @Data
    @Condition("GH00004")
    protected ICondition ficheiroNosvos ;
    @Data
    @Condition("GH00005")
    protected ICondition ficheiroRhenus ;
    @Data
    @Condition("GH00011")
    protected ICondition ficheiroExcel ;
    @Data
    @Condition("GH00012")
    protected ICondition ficheiroAplicacoes ;
    @Data
    @Condition("GH00002")
    protected ICondition transaccao ;
    @Data
    @Condition("GH00094")
    protected ICondition segViasExtracto ;
    @Data
    @Condition("GH00095")
    protected ICondition contasDcr ;
    @Data
    @Condition("GH00096")
    protected ICondition movimentosDbi ;
    @Data
    @Condition("GH00097")
    protected ICondition justifJuro ;
    @Data
    @Condition("GH00098")
    protected ICondition pagamentosTsu ;
    @Data
    @Condition("GH00101")
    protected ICondition mapaContas ;
    @Data
    @Condition("GH00102")
    protected ICondition mapaContasOrig ;
    @Data
    @Condition("GH00103")
    protected ICondition mapaContasSldo ;
    @Data
    @Condition("GH00104")
    protected ICondition mapaContasPosic ;
    @Data
    @Condition("GH00105")
    protected ICondition montante ;
    @Data
    @Condition("GH00106")
    protected ICondition utilizador ;
    @Data
    @Condition("GH00107")
    protected ICondition comprovMovim ;
    @Data
    @Condition({ "GH00012", "GH00094", "GH00095", "GH00096", "GH00098", "GH00004" })
    protected ICondition invalidosGhe0 ;
    
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        /**
         * *----------------------------------------------------------------*
         */
        msgIn().msg().initialize() ;
        msgOut().msg().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        progOk.setTrue() ;
        if (!msgIn().msg().ade().criacao().isTrue() && !msgIn().msg().ade().anulacao().isTrue()) {
            progDadosInvalidos.setTrue() ;
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (msgIn().msg().ade().criacao().isTrue()) {
            if (msgIn().msg().ade().zInicMov().isEmpty() || 
                msgIn().msg().ade().zInicMov().isEqual("0001-01-01")) {
                progDadosInvalidos.setTrue() ;
                messageV2.mensagem().aAplErro().set(WS_APL_HST);
                messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            }
        }
        if (msgIn().msg().ade().anulacao().isTrue()) {
            if (msgIn().msg().ade().tsPedido().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
                messageV2.mensagem().aAplErro().set(WS_APL_HST);
                messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        if (msgIn().msg().ade().anulacao().isTrue()) {
            a51000AnulaPedido() ;
            if (progOk.isTrue()) {
                a51100AnulaOeDstPed() ;
            }
        } else {
            a52000ValidaPedido() ;
            if (progOk.isTrue()) {
                a53000ValidaInfPedida() ;
            }
            /**
             * *GH805--> INICIO
             */
            if (progOk.isTrue() && ficheiroRhenus.isTrue() && 
                msgIn().msg().ade().criacao().isTrue()) {
                a56000ValidaPedidoRhenus() ;
            }
            /**
             * *GH805--> FIM
             */
            if (progOk.isTrue()) {
                primeiroRegisto.setTrue() ;
                a54000InserePedido() ;
                if (progOk.isTrue()) {
                    if (haDataMoedaDiferente.isTrue()) {
                        segundoRegisto.setTrue() ;
                        a54000InserePedido() ;
                    }
                }
            }
            if (progOk.isTrue()) {
                if (hrMghs018a().bghl018a().detalhe().cTipoRpte().isEqual("M") || 
                    ficheiroExcel.isTrue()) {
                    a55000InsereOeDst() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000AnulaPedido() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs015a().bghl015a().initialize() ;
        hrMghs015a().bghl015a().eliminar().setTrue() ;
        hrMghs015a().bghl015a().detalhe().tsPedido().set(msgIn().msg().ade().tsPedido());
        hrMghs015a().run() ;
        if (!hrMghs015a().bghl015a().ok().isTrue()) {
            progStatus.set(hrMghs015a().bghl015a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs015a().bghl015a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00015");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51100AnulaOeDstPed() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs016a().bghl016a().initialize() ;
        hrMghs016a().bghl016a().eliminar().setTrue() ;
        hrMghs016a().bghl016a().argumento().tsPedido().set(msgIn().msg().ade().tsPedido());
        hrMghs016a().run() ;
    }
    
    /**
     * 
     * 
     */
    protected void a52000ValidaPedido() {
        /**
         * *----------------------------------------------------------------*
         */
        wsCPedInfOpps.set(msgIn().msg().ade().cPedInfOpps());
        if (invalidosGhe0.isTrue()) {
            progPedidoInv.setTrue() ;
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
        } else {
            hrMghs018a().bghl018a().initialize() ;
            hrMghs018a().bghl018a().consultar().setTrue() ;
            hrMghs018a().bghl018a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
            hrMghs018a().run() ;
            if (!hrMghs018a().bghl018a().ok().isTrue()) {
                progStatus.set(hrMghs018a().bghl018a().cRetorno());
                messageV2.mensagem().cTipoErroBbn().set(WS_ERRO);
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs018a().bghl018a().cSqlcode());
                envOut.db2Log().nmTabela().set("TGH00018");
                messageV2.mensagem().aAplErro().set(WS_APL_HST);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53000ValidaInfPedida() {
        /**
         * *----------------------------------------------------------------*
         */
        wsCPedInfOpps.set(msgIn().msg().ade().cPedInfOpps());
        if (montante.isTrue() || utilizador.isTrue()) {
            wTimestamp().set(messageV2.mensagem().tsTrnzLocl());
            wData().set(msgIn().msg().ade().zInicMov());
            wsZaAnos.set(subtract(wTimestamp().wDataTimestamp().wAnoAa(), 2));
            if (wData().wAnoData().isLess(wsZaAnos)) {
                progDataMinInv.setTrue() ;
                messageV2.mensagem().aAplErro().set(WS_APL_HST);
                messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            }
            wData().set(msgIn().msg().ade().zFimMov());
            if (wData().wAnoData().isLess(wsZaAnos)) {
                progDataMaxInv.setTrue() ;
                messageV2.mensagem().aAplErro().set(WS_APL_HST);
                messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            }
        }
        if (progOk.isTrue()) {
            if (montante.isTrue()) {
                if (msgIn().msg().ade().mParmPedHstMax().isEqual(0) || 
                    msgIn().msg().ade().mParmPedHstMin().isEqual(0)) {
                    progDadosInvalidos.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            } else if (utilizador.isTrue()) {
                if (msgIn().msg().ade().cParmPedHstMax().isEmpty() || 
                    msgIn().msg().ade().cParmPedHstMin().isEmpty()) {
                    progDadosInvalidos.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            } else {
                a53100ValidarPedidosOutros() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53100ValidarPedidosOutros() {
        /**
         * *----------------------------------------------------------------*
         */
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().zInicMov().isEmpty() || 
            msgIn().msg().ade().zFimMov().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (!transaccao.isTrue()) {
            if (msgIn().msg().ade().cCanlTrmzInf().isEmpty() || 
                msgIn().msg().ade().cPaisIsoaOeOpx().isEmpty() || 
                msgIn().msg().ade().cMnemEgcOpex().isEmpty() || 
                msgIn().msg().ade().cOeEgcOpx().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
                messageV2.mensagem().aAplErro().set(WS_APL_HST);
                messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            }
        }
        if (progOk.isTrue()) {
            wDataInic().set(msgIn().msg().ade().zInicMov());
            wDataFim().set(msgIn().msg().ade().zFimMov());
            if (wDataInic().wAnoInic().isGreater(1989) || 
                wDataFim().wAnoFim().isGreater(1989)) {
                wsAnos.set(subtract(wDataFim().wAnoFim(), wDataInic().wAnoInic()));
                if (wsAnos.isGreater(2)) {
                    progPedidoInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            }
        }
        if (progOk.isTrue()) {
            wsDataToday().set(getTimeAsLong());
            wData().wAnoData().set(wsDataToday().wsAnoToday());
            wData().wMesData().set(wsDataToday().wsMesToday());
            wData().wDiaData().set(wsDataToday().wsDiaToday());
            if (msgIn().msg().ade().zInicMov().isEqual(wData()) && 
                msgIn().msg().ade().zFimMov().isEqual(wData())) {
                pedidoDia.setTrue() ;
            } else if (msgIn().msg().ade().zFimMov().isEqual(wData())) {
                pedidoHoje.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            if (justifJuro.isTrue()) {
                if (messageV2.mensagem().nEltnJourBbn().cOeEgcOpex().isLessOrEqual(9000) && 
                    !messageV2.mensagem().nEltnJourBbn().cOeEgcOpex().isEqual(987)) {
                    progPedidoInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            }
        }
        if (progOk.isTrue()) {
            if (ficheiroRepsol.isTrue() || ficheiroRhenus.isTrue()) {
                if (messageV2.mensagem().nEltnJourBbn().cOeEgcOpex().isLessOrEqual(9000)) {
                    progPedidoInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            }
        }
        if (progOk.isTrue()) {
            if (!transaccao.isTrue()) {
                a53110ValidarContaHst() ;
            }
        }
        if (progOk.isTrue()) {
            if (!pedidoDia.isTrue()) {
                a53130VerDataHst() ;
            }
        }
        if (progOk.isTrue()) {
            if (pedidoAntigo.isTrue()) {
                a53160VerExistOutrosPed() ;
            }
        }
        if (progOk.isTrue()) {
            a53140ValidarOutrosDados() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53110ValidarContaHst() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs001a().bghl001a().initialize() ;
        hrMghs001a().bghl001a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs001a().bghl001a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs001a().bghl001a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs001a().bghl001a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs001a().bghl001a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs001a().bghl001a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs001a().bghl001a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs001a().bghl001a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        /**
         * SOLUCAO PROVISORIA PARA RETORNAR OS MOVIMENTOS CORRECTAMENTE
         * RETIRAR ESTA VALIDACAO APOS A CORRECCAO DA MIGRACAO DOS MOVIMENT
         * DE CONTAS DO PROVENIENTES DO BNU
         */
        if ((msgIn().msg().ade().cTipoCont().isEqual(30) || 
            msgIn().msg().ade().cTipoCont().isEqual(31) || 
            msgIn().msg().ade().cTipoCont().isEqual(32)) && 
            msgIn().msg().ade().cPaisIsoaCont().isEqual("PT") && 
            msgIn().msg().ade().cBancCont().isEqual(35) && 
            msgIn().msg().ade().cOeEgcCont().isGreaterOrEqual(2000)) {
            bghw0017().wZInicTrocaMoeda().set(bghw0017().wZInicTrocaMoedaBnu());
        }
        hrMghs001a().run() ;
        if (hrMghs001a().bghl001a().ok().isTrue()) {
            msgIn().msg().ade().cMoedIsoScta().set(hrMghs001a().bghl001a().argumento().cMoedIsoScta());
            if (hrMghs001a().bghl001a().detalhe().iActivo().isEqual("D") || 
                !hrMghs001a().bghl001a().detalhe().cMoedIsoAntEur().isEqual(msgIn().msg().ade().cMoedIsoScta())) {
                if (bghw0017().wZInicTrocaMoeda().isGreater(msgIn().msg().ade().zInicMov()) && 
                    bghw0017().wZInicTrocaMoeda().isGreater(msgIn().msg().ade().zFimMov())) {
                    haMoedaDiferente.setTrue() ;
                } else if (bghw0017().wZInicTrocaMoeda().isGreater(msgIn().msg().ade().zInicMov())) {
                    haDataMoedaDiferente.setTrue() ;
                }
            }
        } else {
            progStatus.set(hrMghs001a().bghl001a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs001a().bghl001a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00001");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53130VerDataHst() {
        pedidoNovo.setTrue() ;
        naoSair.setTrue() ;
        wDataInic().set(msgIn().msg().ade().zInicMov());
        wDataFim().set(msgIn().msg().ade().zFimMov());
        wsZaMinimo.set(9);
        wsZaMaximo.set(0);
        hrMghs110a().bghl110a().initialize() ;
        hrMghs110a().bghl110a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs110a().bghl110a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs110a().bghl110a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs110a().bghl110a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs110a().bghl110a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs110a().bghl110a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        /**
         * GH 2292 - INI
         */
        hrMghs110a().bghl110a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        /**
         * GH 2292 - FIM
         */
        hrMghs110a().bghl110a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs110a().bghl110a().tabela().setTrue() ;
        hrMghs110a().run() ;
        if (hrMghs110a().bghl110a().ok().isTrue()) {
            for (hrMghs110a().bghl110a().tab().lista().setIndex(1); hrMghs110a().bghl110a().tab().lista().index().isLessOrEqual(30) && !sair.isTrue() && progStatus.isLessOrEqual(0); hrMghs110a().bghl110a().tab().lista().incIndex()) {
                hrMghs110a().bghl110a().argumento().set(hrMghs110a().bghl110a().tab().lista().getCurrent().item().itemArgumento());
                hrMghs110a().bghl110a().detalhe().set(hrMghs110a().bghl110a().tab().lista().getCurrent().item().itemDetalhe());
                if (hrMghs110a().bghl110a().detalhe().nmRecurso().isEmpty()) {
                    sair.setTrue() ;
                } else {
                    if (hrMghs110a().bghl110a().detalhe().zaInicio().isLess(wsZaMinimo)) {
                        wsZaMinimo.set(hrMghs110a().bghl110a().detalhe().zaInicio());
                    }
                    if (hrMghs110a().bghl110a().detalhe().zaFim().isGreater(wsZaMaximo)) {
                        wsZaMaximo.set(hrMghs110a().bghl110a().detalhe().zaFim());
                    }
                }
            }
            if (wDataInic().wAnoInic().isGreaterOrEqual(wsZaMinimo) && 
                wDataFim().wAnoFim().isLessOrEqual(wsZaMaximo)) {
                if (transaccao.isTrue()) {
                    progPedInvalido.setTrue() ;
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                }
            } else if (wDataInic().wAnoInic().isLess(wsZaMinimo)) {
                pedidoAntigo.setTrue() ;
            } else {
                pedidoNovo.setTrue() ;
            }
        } else if (hrMghs110a().bghl110a().naoExisteConta().isTrue()) {
            pedidoAntigo.setTrue() ;
        } else {
            progStatus.set(hrMghs110a().bghl110a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs110a().bghl110a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00010");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            /**
             * ELSE
             * IF TRANSACCAO
             * SET PROG-PED-INVALIDO TO TRUE
             * MOVE WS-ERR-FUNC      TO BHTL010A-C-TIPO-ERRO-BBN
             * MOVE WS-APL-HST       TO BHTL010A-A-APL-ERRO
             * END-IF
             */
            if (pedidoAntigo.isTrue()) {
                if (pedidoHoje.isTrue()) {
                    progPedInvalido.setTrue() ;
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                } else {
                    a53131VerInfTape() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53131VerInfTape() {
        naoSair.setTrue() ;
        wsCrtlTape.set(" ");
        wsZaMinimo.set(9);
        wsZaMaximo.set(0);
        hrMghs110a().bghl110a().initialize() ;
        hrMghs110a().bghl110a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs110a().bghl110a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs110a().bghl110a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs110a().bghl110a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs110a().bghl110a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs110a().bghl110a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        /**
         * GH 2292 - INI
         */
        hrMghs110a().bghl110a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        /**
         * GH 2292 - FIM
         */
        hrMghs110a().bghl110a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs110a().bghl110a().tape().setTrue() ;
        hrMghs110a().run() ;
        if (hrMghs110a().bghl110a().ok().isTrue()) {
            for (hrMghs110a().bghl110a().tab().lista().setIndex(1); hrMghs110a().bghl110a().tab().lista().index().isLessOrEqual(30) && !sair.isTrue() && progStatus.isLessOrEqual(0); hrMghs110a().bghl110a().tab().lista().incIndex()) {
                hrMghs110a().bghl110a().argumento().set(hrMghs110a().bghl110a().tab().lista().getCurrent().item().itemArgumento());
                hrMghs110a().bghl110a().detalhe().set(hrMghs110a().bghl110a().tab().lista().getCurrent().item().itemDetalhe());
                if (hrMghs110a().bghl110a().detalhe().nmRecurso().isEmpty()) {
                    sair.setTrue() ;
                } else {
                    if (hrMghs110a().bghl110a().detalhe().zaInicio().isLess(wsZaMinimo)) {
                        wsZaMinimo.set(hrMghs110a().bghl110a().detalhe().zaInicio());
                    }
                    if (hrMghs110a().bghl110a().detalhe().zaFim().isGreater(wsZaMaximo)) {
                        wsZaMaximo.set(hrMghs110a().bghl110a().detalhe().zaFim());
                    }
                    if (hrMghs110a().bghl110a().detalhe().nmRecurso().isEqual("GHSA9999") && 
                        wDataInic().wAnoInic().isGreaterOrEqual(hrMghs110a().bghl110a().detalhe().zaInicio()) && 
                        wDataFim().wAnoFim().isLessOrEqual(hrMghs110a().bghl110a().detalhe().zaFim())) {
                        tapeGrande.setTrue() ;
                    }
                }
            }
        } else {
            progStatus.set(hrMghs110a().bghl110a().cRetorno());
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs110a().bghl110a().cSqlcode());
        }
        if (progOk.isTrue()) {
            if (!tapeGrande.isTrue()) {
                if (!wDataInic().wAnoInic().isEqual(wDataFim().wAnoFim())) {
                    progPedInvalido.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (wDataInic().wAnoInic().isLess(wsZaMinimo) || 
                wDataFim().wAnoFim().isGreater(wsZaMaximo)) {
                if (hrMghs018a().bghl018a().detalhe().cTipoRpte().isEqual("M")) {
                    pedidoAntigo.setTrue() ;
                } else {
                    progNaoExisMovHstAno.setTrue() ;
                }
            }
        }
        if (!progOk.isTrue()) {
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().nmTabela().set("TGH00010");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53160VerExistOutrosPed() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs015a().bghl015a().initialize() ;
        hrMghs015a().bghl015a().cnslCntPed().setTrue() ;
        hrMghs015a().bghl015a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs015a().bghl015a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs015a().bghl015a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs015a().bghl015a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs015a().bghl015a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs015a().bghl015a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs015a().bghl015a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        if (tapeGrande.isTrue()) {
            hrMghs015a().bghl015a().argumento().zInicMov().set("1989-01-01");
        } else {
            hrMghs015a().bghl015a().argumento().zInicMov().set(msgIn().msg().ade().zInicMov());
        }
        hrMghs015a().run() ;
        if (hrMghs015a().bghl015a().ok().isTrue()) {
            progHaPedSubconta.setTrue() ;
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (!hrMghs015a().bghl015a().ok().isTrue() && !hrMghs015a().bghl015a().naoExisteInf().isTrue()) {
            progStatus.set(hrMghs015a().bghl015a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs015a().bghl015a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00015");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53140ValidarOutrosDados() {
        /**
         * *----------------------------------------------------------------*
         */
        if (hrMghs018a().bghl018a().detalhe().cTipoRpte().isEqual("F")) {
            if (msgIn().msg().ade().cCanlTrmzInf().isEmpty()) {
                progDadosInvalidos.setTrue() ;
                messageV2.mensagem().aAplErro().set(WS_APL_HST);
                messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            } else {
                wsCCanlTrnzInf.set(msgIn().msg().ade().cCanlTrmzInf());
                if (!canlTrnzValido.isTrue()) {
                    progCanalInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            }
        }
        if (progOk.isTrue()) {
            if (ficheiro.isTrue()) {
                /**
                 * *GH1108--> INICIO
                 * IF FILE-TRANSFER
                 */
                if (!fileTransfer.isTrue() && !connectDirect.isTrue()) {
                    progCanalInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            }
        }
        if (progOk.isTrue()) {
            if (fileTransfer.isTrue() || connectDirect.isTrue()) {
                if (msgIn().msg().ade().cEndcFtpDest().isEmpty()) {
                    progEnderecoInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                } else if (ficheiro.isTrue()) {
                    a53140ValidaEndereco() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (outrasAplicacoes.isTrue()) {
                if (msgIn().msg().ade().aAplDst().isEmpty()) {
                    progEnderecoInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            }
        }
        if (progOk.isTrue()) {
            if (hrMghs018a().bghl018a().detalhe().cTipoRpte().isEqual("M") || 
                ficheiroExcel.isTrue()) {
                if (msgIn().msg().ade().cPaisIsoaDst().isEmpty() || 
                    msgIn().msg().ade().cMnemEgcDst().isEmpty() || 
                    msgIn().msg().ade().cOeEgcDst().isEqual(0)) {
                    progOeDstInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
            }
        }
        if (progOk.isTrue()) {
            if (ficheiroExcel.isTrue()) {
                if (!msgIn().msg().ade().cOeEgcDst().isEqual(CON_DSO)) {
                    wsCOeEgcDst.set(msgIn().msg().ade().cOeEgcDst());
                    if (wsCOeEgcDst.get(1, 1).isEqual(9) || 
                        wsCOeEgcDst.get(1, 1).isEqual(7)) {
                        msgIn().msg().ade().cCanlTrmzInf().set("TD");
                    } else {
                        progOeDstInv.setTrue() ;
                        messageV2.mensagem().aAplErro().set(WS_APL_HST);
                        messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                    }
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53140ValidaEndereco() {
        /**
         * *----------------------------------------------------------------*
         */
        bghw0010().tbEndcFtp().itemFtp().resetIndex() ;
        while (bghw0010().tbEndcFtp().itemFtp().index().isLessOrEqual(9)) {
            if (msgIn().msg().ade().cEndcFtpDest().get(1, 3).isEqual(bghw0010().tbEndcFtp().itemFtp().getCurrent().tabEndcFtp())) {
                if (!msgIn().msg().ade().cPedInfOpps().isEqual(bghw0010().tbEndcFtp().itemFtp().getCurrent().tabCPed())) {
                    progEnderecoInv.setTrue() ;
                    messageV2.mensagem().aAplErro().set(WS_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
                }
                break;
            }
            bghw0010().tbEndcFtp().itemFtp().incIndex() ;
        }
        if (bghw0010().tbEndcFtp().itemFtp().atEnd()) {
            progEnderecoInv.setTrue() ;
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a54000InserePedido() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs015a().bghl015a().initialize() ;
        hrMghs015a().bghl015a().inserir().setTrue() ;
        hrMghs015a().bghl015a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs015a().bghl015a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs015a().bghl015a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        if (montante.isTrue() || utilizador.isTrue()) {
            hrMghs015a().bghl015a().argumento().nsRdclCont().set(9);
            hrMghs015a().bghl015a().argumento().vChkdCont().set(9);
            hrMghs015a().bghl015a().argumento().cTipoCont().set(9);
            hrMghs015a().bghl015a().argumento().nsDeposito().set(9);
            hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(" ");
        } else {
            hrMghs015a().bghl015a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
            hrMghs015a().bghl015a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
            hrMghs015a().bghl015a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
            hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
            hrMghs015a().bghl015a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
            if (haMoedaDiferente.isTrue()) {
                hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(hrMghs001a().bghl001a().detalhe().cMoedIsoAntEur());
            } else if (haDataMoedaDiferente.isTrue()) {
                if (primeiroRegisto.isTrue()) {
                    hrMghs015a().bghl015a().argumento().cMoedIsoScta().set(hrMghs001a().bghl001a().detalhe().cMoedIsoAntEur());
                }
            }
        }
        hrMghs015a().bghl015a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
        hrMghs015a().bghl015a().argumento().zInicMov().set(msgIn().msg().ade().zInicMov());
        if (haDataMoedaDiferente.isTrue()) {
            if (segundoRegisto.isTrue()) {
                hrMghs015a().bghl015a().argumento().zInicMov().set(bghw0017().wZInicTrocaMoeda());
            }
        }
        hrMghs015a().bghl015a().argumento().zFimMov().set(msgIn().msg().ade().zFimMov());
        if (haDataMoedaDiferente.isTrue()) {
            if (primeiroRegisto.isTrue()) {
                hrMghs015a().bghl015a().argumento().zFimMov().set(bghw0017().wZInicTrocaMoeda());
            }
        }
        hrMghs015a().bghl015a().detalhe().zPedido().set(messageV2.mensagem().tsTrnzLocl().get(1, 10));
        if (segundoRegisto.isTrue()) {
            hrMghs015a().bghl015a().detalhe().tsPedido().set(wsTsPedido);
        }
        hrMghs015a().bghl015a().detalhe().cEstPedHist().set("A");
        hrMghs015a().bghl015a().detalhe().aAplDest().set(msgIn().msg().ade().aAplDst());
        hrMghs015a().bghl015a().detalhe().cCanlTrmzInf().set(msgIn().msg().ade().cCanlTrmzInf());
        hrMghs015a().bghl015a().detalhe().cEndcFtpDest().set(msgIn().msg().ade().cEndcFtpDest());
        hrMghs015a().bghl015a().detalhe().zCluzPed().set("0001-01-01");
        hrMghs015a().bghl015a().detalhe().zEliminacao().set("0001-01-01");
        hrMghs015a().bghl015a().detalhe().cUsidCrix().set(messageV2.mensagem().nEltnJourBbn().cUserid());
        hrMghs015a().bghl015a().detalhe().cUsidActzUlt().set(messageV2.mensagem().nEltnJourBbn().cUserid());
        hrMghs015a().bghl015a().detalhe().cPaisIsoaOeOpx().set(msgIn().msg().ade().cPaisIsoaOeOpx());
        hrMghs015a().bghl015a().detalhe().cMnemEgcOpex().set(msgIn().msg().ade().cMnemEgcOpex());
        hrMghs015a().bghl015a().detalhe().cOeEgcOpex().set(msgIn().msg().ade().cOeEgcOpx());
        hrMghs015a().bghl015a().detalhe().mParmPedHstMax().set(msgIn().msg().ade().mParmPedHstMax());
        hrMghs015a().bghl015a().detalhe().mParmPedHstMin().set(msgIn().msg().ade().mParmPedHstMin());
        hrMghs015a().bghl015a().detalhe().cParmPedHstMin().set(msgIn().msg().ade().cParmPedHstMin());
        hrMghs015a().bghl015a().detalhe().cParmPedHstMax().set(msgIn().msg().ade().cParmPedHstMax());
        hrMghs015a().bghl015a().nClientePed().set(msgIn().msg().ade().nClientePed());
        hrMghs015a().bghl015a().nsAbraCliPed().set(msgIn().msg().ade().nsAbraCliPed());
        hrMghs015a().bghl015a().detalhe().cFrmtInf().set(hrMghs018a().bghl018a().detalhe().cFrmtInf());
        hrMghs015a().bghl015a().detalhe().cTipoRpte().set(hrMghs018a().bghl018a().detalhe().cTipoRpte());
        hrMghs015a().bghl015a().detalhe().nmFichOutpRtno().set(hrMghs018a().bghl018a().detalhe().nmFichOutpRtno());
        hrMghs015a().bghl015a().detalhe().qDiaDpnzInf().set(hrMghs018a().bghl018a().detalhe().qDiaDpnzInf());
        hrMghs015a().run() ;
        if (hrMghs015a().bghl015a().ok().isTrue()) {
            msgOut().msg().ade().tsPedido().set(hrMghs015a().bghl015a().detalhe().tsPedido());
            wsTsPedido.set(hrMghs015a().bghl015a().detalhe().tsPedido());
        } else {
            progStatus.set(hrMghs015a().bghl015a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs015a().bghl015a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00015");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000InsereOeDst() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs016a().bghl016a().initialize() ;
        hrMghs016a().bghl016a().inserir().setTrue() ;
        hrMghs016a().bghl016a().argumento().tsPedido().set(wsTsPedido);
        hrMghs016a().bghl016a().argumento().cPaisIsoaDest().set(msgIn().msg().ade().cPaisIsoaDst());
        hrMghs016a().bghl016a().argumento().cMnemEgcDest().set(msgIn().msg().ade().cMnemEgcOpex());
        hrMghs016a().bghl016a().argumento().cOeEgcDest().set(msgIn().msg().ade().cOeEgcDst());
        hrMghs016a().bghl016a().detalhe().cUsidActzUlt().set(messageV2.mensagem().nEltnJourBbn().cUserid());
        hrMghs016a().run() ;
        if (!hrMghs016a().bghl016a().ok().isTrue()) {
            progStatus.set(hrMghs016a().bghl016a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs016a().bghl016a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00016");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * *GH805--> INICIO
     * 
     */
    protected void a56000ValidaPedidoRhenus() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs015a().bghl015a().initialize() ;
        hrMghs015a().bghl015a().cnslPedAct().setTrue() ;
        hrMghs015a().bghl015a().argumento().cPedInfOpps().set(msgIn().msg().ade().cPedInfOpps());
        hrMghs015a().run() ;
        if (hrMghs015a().bghl015a().existePedido().isTrue()) {
            progJaExiste.setTrue() ;
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (!hrMghs015a().bghl015a().existePedido().isTrue() && !hrMghs015a().bghl015a().ok().isTrue()) {
            progStatus.set(hrMghs015a().bghl015a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs015a().bghl015a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00015");
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * *GH805--> FIM
     * 
     */
    protected void s70000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        messageV2.mensagem().cRtnoSwal().set(progStatus);
        if (!messageV2.mensagem().semErros().isTrue()) {
            msgOut().msg().ase().iAccaoSt().iAccao1().setTrue() ;
            msgOut().msg().ase().iAccaoSt().iAccaoM().set(progStatus);
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        messageV2.mensagem().campoLivre11().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        envIn.qCterCmptMsg().set(msgOut().qCterCmptAlig());
        messageV2.mensagem().x01Vizualizacao().setTrue() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestamp
         */
        @Data
        WDataTimestamp wDataTimestamp() ;
        
        /**
         * @return instancia da classe local WTimerTimestamp
         */
        @Data
        WTimerTimestamp wTimerTimestamp() ;
        
        
        public interface WDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMm() ;
            
            @Data(size=2, lpadding=1, rpadding=1, lpaddingValue="-", rpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wHora() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wMinuto() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wSegundo() ;
            
            @Data(size=1, value=".")
            IString filler001() ;
            
            @Data(size=6, value="0")
            IInt filler002() ;
            
        }
    }
    public interface WsDataToday extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoToday() ;
        
        @Data(size=2)
        IInt wsMesToday() ;
        
        @Data(size=2)
        IInt wsDiaToday() ;
        
    }
    public interface WData extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaData() ;
        
    }
    public interface WDataInic extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoInic() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesInic() ;
        
        @Data(size=2, lpadding=1, rpadding=1, lpaddingValue="-", rpaddingValue="-")
        IInt wDiaInic() ;
        
    }
    public interface WDataFim extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesFim() ;
        
        @Data(size=2, lpadding=1, rpadding=1, lpaddingValue="-", rpaddingValue="-")
        IInt wDiaFim() ;
        
    }
    
}
