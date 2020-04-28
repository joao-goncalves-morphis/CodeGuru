package cgd.gh.online;

import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseOnline ;
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
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0980 ;
import cgd.gh.structures.messages.Bghm0981 ;
import cgd.gh.structures.work.Bghw0500 ;
import cgd.d2.structures.work.Zd2667d ;
import cgd.ho.routines.Mhoj356a ;
import cgd.gh.routines.Mghs902a ;
import cgd.common.utilities.Yu1022 ;
import cgd.sx.routines.Msxs449a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.sx.routines.Msxs003a ;
import cgd.dr.routines.Mdrj402a ;
import cgd.sx.routines.Msxs093a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghs805a ;
import cgd.gh.routines.Mghs200a ;
import cgd.hm.routines.Mhmj215a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO ADICIONAL ASSOCIADA DO
 * MOVIMENTO
 * PROCESSO GIP: GH1350
 * DATA        : 2014-01-04
 * USER        : ACT0701
 * ALTERACOES  : CORRECÇÃO DO ACESSO AO MODULO MHMJ215A
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho098a extends CgdGhBaseOnline<Pgho098a.EnvelopeIn, Pgho098a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0980
     */
    public abstract Bghm0980 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0981
     */
    public abstract Bghm0981 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0980.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0981.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhoj356a
     */
    @Data
    protected abstract Mhoj356a hrMhoj356a() ;
    
    /**
     * @return instancia da classe Mghs902a
     */
    @Data
    protected abstract Mghs902a hrMghs902a() ;
    
    /**
     * @return instancia da classe Yu1022
     */
    @Data
    protected abstract Yu1022 hpyu1022() ;
    
    /**
     * @return instancia da classe Msxs449a
     */
    @Data
    protected abstract Msxs449a hrMsxs449a() ;
    
    /**
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    /**
     * @return instancia da classe Msxs003a
     */
    @Data
    protected abstract Msxs003a hrMsxs003a() ;
    
    /**
     * @return instancia da classe Mdrj402a
     */
    @Data
    protected abstract Mdrj402a hrMdrj402a() ;
    
    /**
     * @return instancia da classe Msxs093a
     */
    @Data
    protected abstract Msxs093a hrMsxs093a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mghs805a
     */
    @Data
    protected abstract Mghs805a hrMghs805a() ;
    
    /**
     * @return instancia da classe Mghs200a
     */
    @Data
    protected abstract Mghs200a hrMghs200a() ;
    
    /**
     * @return instancia da classe Mhmj215a
     */
    @Data
    protected abstract Mhmj215a hrMhmj215a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bghw0500
     */
    @Data
    protected abstract Bghw0500 bghw0500() ;
    
    /**
     * @return instancia da classe Zd2667d
     */
    @Data
    protected abstract Zd2667d zd2667d() ;
    
    @Data(size=3, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("067")
    protected ICondition progNaoExisteInfAdic ;
    @Data
    @Condition("097")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("080")
    protected ICondition progNaoExisteConta ;
    @Data
    @Condition("091")
    protected ICondition progDataMinInv ;
    @Data
    @Condition("092")
    protected ICondition progDataMaxInv ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    @Data
    @Condition("211")
    protected ICondition progAcesso ;
    
    
    @Data(size=1, value=" ")
    protected IString crtlMovDia ;
    @Data
    @Condition("D")
    protected ICondition movHoje ;
    
    
    @Data(size=8, value="MDRJ402A")
    protected IString bdrl402aNomeRotina ;
    
    @Data(size=8, value="MHGJ030A")
    protected IString bhgl030aNomeRotina ;
    
    @Data(size=8)
    protected IString wsCUserid ;
    
    /**
     * @return instancia da classe local WsCUseridMask
     */
    @Data
    @Mask
    protected abstract WsCUseridMask wsCUseridMask() ;
    
    @Data(size=30)
    protected IString wsCTipoServicoA ;
    
    /**
     * @return instancia da classe local WsCTipoServicoAMask
     */
    @Data
    @Mask
    protected abstract WsCTipoServicoAMask wsCTipoServicoAMask() ;
    
    /**
     * @return instancia da classe local WsCTipoTermSibs
     */
    @Data
    protected abstract WsCTipoTermSibs wsCTipoTermSibs() ;
    
    @Data(size=21)
    protected IString wsNibDstn ;
    
    /**
     * @return instancia da classe local WsNibDstnMask
     */
    @Data
    @Mask
    protected abstract WsNibDstnMask wsNibDstnMask() ;
    
    @Data(size=70)
    protected IString wsCDadAdc ;
    
    /**
     * @return instancia da classe local WsCDadAdcMask
     */
    @Data
    @Mask
    protected abstract WsCDadAdcMask wsCDadAdcMask() ;
    
    /**
     * @return instancia da classe local WsDataHoje
     */
    @Data
    protected abstract WsDataHoje wsDataHoje() ;
    
    /**
     * @return instancia da classe local WsData
     */
    @Data
    protected abstract WsData wsData() ;
    
    @Data(size=15)
    protected ILong wsNConta ;
    
    /**
     * @return instancia da classe local WsNContaMask
     */
    @Data
    @Mask
    protected abstract WsNContaMask wsNContaMask() ;
    
    /**
     * @return instancia da classe local WsHTransaccaoSx
     */
    @Data
    protected abstract WsHTransaccaoSx wsHTransaccaoSx() ;
    
    /**
     * @return instancia da classe local WsHTransaccao
     */
    @Data
    protected abstract WsHTransaccao wsHTransaccao() ;
    
    @Data(size=10)
    protected IString wsCIdTermSx ;
    
    /**
     * @return instancia da classe local WsCIdTermSxMask
     */
    @Data
    @Mask
    protected abstract WsCIdTermSxMask wsCIdTermSxMask() ;
    
    @Data(size=14)
    protected IString wsCRefSibs ;
    
    /**
     * @return instancia da classe local WsCRefSibsMask
     */
    @Data
    @Mask
    protected abstract WsCRefSibsMask wsCRefSibsMask() ;
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "PGHO098A * S10000-INICIAR ");
        msgIn().msg().initialize() ;
        msgOut().msg().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        progOk.setTrue() ;
    }
    
    /**
     * 
     * 
     */
    protected void s30000Validar() {
        log(TraceLevel.Debug, "PGHO098A * S30000-VALIDAR ");
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().tsMovimento().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        log(TraceLevel.Debug, "PGHO098A * S50000-PROCESSAR");
        log(TraceLevel.Debug, "   BGHM0980-A-APL-ORIG: ", msgIn().msg().ade().aAplOrig());
        if (msgIn().msg().ade().aAplOrig().isEqual("HH") || 
            msgIn().msg().ade().aAplOrig().isEqual("HC")) {
            a51000ObtemDadosHhHc() ;
        } else if (msgIn().msg().ade().aAplOrig().isEqual("ZD")) {
            a52000ObtemDadosZd() ;
        } else if (msgIn().msg().ade().aAplOrig().isEqual("DR")) {
            a53000ObtemDadosDr() ;
        } else if (msgIn().msg().ade().aAplOrig().isEqual("SX")) {
            a54000ObtemDadosSx() ;
        } else if (msgIn().msg().ade().aAplOrig().isEqual("HM")) {
            a55000ObtemDadosHm() ;
        } else {
            progNaoExisteInfAdic.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ObtemDadosHhHc() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs902a().bghl902a().initialize() ;
        hrMghs902a().bghl902a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs902a().bghl902a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs902a().bghl902a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs902a().bghl902a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs902a().bghl902a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs902a().bghl902a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs902a().bghl902a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs902a().bghl902a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs902a().bghl902a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs902a().bghl902a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs902a().bghl902a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs902a().run() ;
        if (!hrMghs902a().bghl902a().ok().isTrue() && !hrMghs902a().bghl902a().naoExiste().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs902a().bghl902a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00002");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs902a().bghl902a().detalhe().xChavAcsInfAdi().isEmpty()) {
                bghw0500().wXChavAcsInfAdi().set(" ");
                msgOut().msg().ade().grCheque().nRefCheqArqv().set(0);
                msgOut().msg().ade().grCheque().cPaisIsaTmxChq().set(" ");
                msgOut().msg().ade().grCheque().cBancTomador().set(0);
                msgOut().msg().ade().grCheque().cOeEgcTomxCheq().set(0);
            } else {
                bghw0500().wXChavAcsInfAdi().set(hrMghs902a().bghl902a().detalhe().xChavAcsInfAdi());
                msgOut().msg().ade().grCheque().nRefCheqArqv().set(bghw0500().wXChavAcsInfAdiMask().wNRefCheqArqv());
                msgOut().msg().ade().grCheque().cPaisIsaTmxChq().set(bghw0500().wXChavAcsInfAdiMask().wCPaisIsaTmxChq());
                msgOut().msg().ade().grCheque().cBancTomador().set(bghw0500().wXChavAcsInfAdiMask().wCBancTomador());
                msgOut().msg().ade().grCheque().cOeEgcTomxCheq().set(bghw0500().wXChavAcsInfAdiMask().wCOeEgcTomxCheq());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000ObtemDadosZd() {
        /**
         * *----------------------------------------------------------------*
         */
        a52100ObtemChaveJourn() ;
        if (progOk.isTrue()) {
            zd2667d().zvghIpMessage().zvghIpSegData().zd2667CPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            zd2667d().zvghIpMessage().zvghIpSegData().zd2667CMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            zd2667d().zvghIpMessage().zvghIpSegData().zd2667CUserId().set(hrMghs102a().bghl102a().detalhe().cUserid());
            zd2667d().zvghIpMessage().zvghIpSegData().zd2667NJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
            zd2667d().zvghIpMessage().zvghIpSegData().zd2667NsJourBbn().set(hrMghs102a().bghl102a().detalhe().nsJourBbn());
            hpyu1022().run() ;
            if (!zd2667d().zvghIpMessage().zvghOpSegData().btcbUserCc().isEqual(0)) {
                progStatus.set(zd2667d().zvghIpMessage().zvghOpSegData().btcbUserCc());
                log(TraceLevel.Error, "BTCB-USER-CC:", zd2667d().zvghIpMessage().zvghOpSegData().btcbUserCc());
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                /**
                 * MOVE 'ZD'             TO BHTL001A-A-APL-ERR
                 */
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
            }
            if (progOk.isTrue()) {
                msgOut().msg().ade().grOutros().nCartao().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667PlasticoContaCartao());
                msgOut().msg().ade().grOutros().nmEntidade().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667NomeLocComer());
                msgOut().msg().ade().grOutros().cIdentAtm().cCcmzApoi().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667AtmBalcaoApoio());
                msgOut().msg().ade().grOutros().cIdentAtm().cTermAtm().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667AtmCodigo());
                msgOut().msg().ade().grOutros().cLoclEntidade().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667LocalidadeAtm());
                msgOut().msg().ade().grOutros().cPostal().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667CodigoPostalAtm());
                msgOut().msg().ade().grOutros().hpTmerLocl().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667HoraTransaccao());
                msgOut().msg().ade().grOutros().mMovOrigTran().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667ValorOrigTxn());
                msgOut().msg().ade().grOutros().cMoeOrigTran().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667MoedaOrig());
                msgOut().msg().ade().grOutros().cRefDst().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667CodReferenciaDest());
                msgOut().msg().ade().grOutros().nmOrdnTrfc().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667NomeOrdenante());
                /**
                 * MOVE ZD2667-DESC-TIPO-SERVICO
                 * TO BGHM0981-X-TP-SERVICO
                 */
                msgOut().msg().ade().grOutros().cEntidade().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667Entidade());
                if (msgOut().msg().ade().grOutros().cEntidade().isEqual("00000") || 
                    msgOut().msg().ade().grOutros().cEntidade().get(1, 4).isEmpty()) {
                    msgOut().msg().ade().grOutros().cEntidade().set(" ");
                }
                msgOut().msg().ade().grOutros().cRefSibs().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667Referencia());
                if (msgOut().msg().ade().grOutros().cRefPagamento().isEqual("000000000") || 
                    msgOut().msg().ade().grOutros().cRefPagamento().get(1, 8).isEmpty()) {
                    msgOut().msg().ade().grOutros().cRefPagamento().set(" ");
                }
                msgOut().msg().ade().grOutros().cRefSibs().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667CodIdentSibs());
                msgOut().msg().ade().grOutros().iTipoSpteMov().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667TipoSuporteMov());
                msgOut().msg().ade().grOutros().cDadAdc().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667CodDadosAdicionais());
                if (!msgOut().msg().ade().grOutros().cEntidade().isEmpty()) {
                    a52200ObtemNomeEntidade() ;
                }
                if (zd2667d().zvghIpMessage().zvghOpSegData().zd2667DescTipoServico().get(1, 2).isEqual(" 0")) {
                    zd2667d().zvghIpMessage().zvghOpSegData().zd2667DescTipoServico().set(" ");
                }
                if (!zd2667d().zvghIpMessage().zvghOpSegData().zd2667DescTipoServico().isEmpty()) {
                    a52300ObtemNomeServico() ;
                }
                if (!zd2667d().zvghIpMessage().zvghOpSegData().zd2667AtmEquipamento().isEmpty()) {
                    a52400ObtemNomeEquipamento() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52200ObtemNomeEntidade() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMsxs449a().bsxl449a().commarea().initialize() ;
        hrMsxs449a().bsxl449a().commarea().input().codEnt().set(msgOut().msg().ade().grOutros().cEntidade());
        hrMsxs449a().run() ;
        if (hrMsxs449a().bsxl449a().commarea().output().dadosErro().semErros().isTrue()) {
            msgOut().msg().ade().grOutros().nmEntidade().set(hrMsxs449a().bsxl449a().commarea().output().nmCmctTermSibs());
        } else {
            msgOut().msg().ade().grOutros().nmEntidade().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52300ObtemNomeServico() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().cTabBbn().set("U51");
        wsCTipoServicoA.set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667DescTipoServico());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cCodigo().set(wsCTipoServicoAMask().wsCTipoServN());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        hrMhgj030a().bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        hrMhgj030a().run() ;
        if (hrMhgj030a().bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            msgOut().msg().ade().grOutros().xTpServico().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            msgOut().msg().ade().grOutros().xTpServico().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52400ObtemNomeEquipamento() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMsxs003a().bsxl003b().initialize() ;
        hrMsxs003a().bsxl003b().arealig().inputDados().ipTipAcesso().set("S");
        hrMsxs003a().bsxl003b().arealig().inputDados().ipCTabSx().set("CTT");
        hrMsxs003a().bsxl003b().arealig().inputDados().ipCCodigo().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667AtmEquipamento().get(1, 1));
        hrMsxs003a().run() ;
        if (hrMsxs003a().bsxl003b().arealig().output().outputStatus().opStatusOk().isTrue()) {
            msgOut().msg().ade().grOutros().cIdentAtm().cEquiAtm().set(hrMsxs003a().bsxl003b().arealig().output().outputDados().opDCodAbvd().get(1, 18));
        } else {
            msgOut().msg().ade().grOutros().cIdentAtm().cEquiAtm().set(zd2667d().zvghIpMessage().zvghOpSegData().zd2667AtmEquipamento());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53000ObtemDadosDr() {
        /**
         * *----------------------------------------------------------------*
         */
        a52100ObtemChaveJourn() ;
        if (progOk.isTrue()) {
            hrMdrj402a().bdrl402a().commarea().initialize() ;
            hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akZProcessamento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
            hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCPaisIsoaOeRpl().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCMnemEgcRspl().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCOeEgcRspl().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
            hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
            hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akNJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
            hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akNsJourBbn().set(hrMghs102a().bghl102a().detalhe().nsJourBbn());
            hrMdrj402a().run() ;
            if (!hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().semErros().isTrue()) {
                progStatus.set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCRtnoEvenSwal());
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
                envOut.db2Log().sqlca().cSqlcode().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCSqlcode());
                envOut.db2Log().nmTabela().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeNmTabela());
            }
            if (progOk.isTrue()) {
                msgOut().msg().ade().grOutros().nCartao().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofXIdSpteOpePcnp());
                msgOut().msg().ade().grOutros().cIdentAtm().cCcmzApoi().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
                msgOut().msg().ade().grOutros().nmEntidade().set("ATM CGD");
                msgOut().msg().ade().grOutros().cIdentAtm().cTermAtm().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCTermAts());
                msgOut().msg().ade().grOutros().cIdentAtm().cEquiAtm().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCDptvAts());
                msgOut().msg().ade().grOutros().cLoclEntidade().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofNmLocalidade());
                msgOut().msg().ade().grOutros().cPostal().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCPostal());
                msgOut().msg().ade().grOutros().hpTmerLocl().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofHTrnzLocl());
                msgOut().msg().ade().grOutros().mMovOrigTran().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofMMovimento());
                msgOut().msg().ade().grOutros().cMoeOrigTran().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCMoedIsoMov());
                msgOut().msg().ade().grOutros().cRefDst().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofXRefContDstMov());
                msgOut().msg().ade().grOutros().nmOrdnTrfc().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofNmOrdnTrfc());
                msgOut().msg().ade().grOutros().cEntidade().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCEntCbrSrvSibs());
                msgOut().msg().ade().grOutros().cRefPagamento().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCRefPagSrvSibs());
                msgOut().msg().ade().grOutros().xTpServico().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofDMsgSesBanSibs());
                if (hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCTipSteOpePcnp().isEqual("C")) {
                    msgOut().msg().ade().grOutros().iTipoSpteMov().set("CR");
                }
                if (hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCTipSteOpePcnp().isEqual("T")) {
                    msgOut().msg().ade().grOutros().iTipoSpteMov().set("CD");
                }
                msgOut().msg().ade().grOutros().cDadAdc().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofXInfAdiMov());
                wsCRefSibsMask().wsAplicN().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofCAplPddSibs());
                wsCRefSibsMask().wsIdlog().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofNRegLogSibs());
                wsCRefSibsMask().wsNrlog().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofNLogSibs());
                msgOut().msg().ade().grOutros().cRefSibs().set(wsCRefSibs);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a54000ObtemDadosSx() {
        log(TraceLevel.Debug, "PGHO098A * A54000-OBTEM-DADOS-SX");
        a52100ObtemChaveJourn() ;
        if (progOk.isTrue()) {
            hrMsxs093a().bsxl093a().arealig().initialize() ;
            hrMsxs093a().bsxl093a().arealig().dadosInput().zValorMovI().set(msgIn().msg().ade().tsMovimento().get(1, 10));
            hrMsxs093a().bsxl093a().arealig().dadosInput().nRegLogSibsI().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
            wsCUserid.set(hrMghs102a().bghl102a().detalhe().cUserid());
            hrMsxs093a().bsxl093a().arealig().dadosInput().cAplEpddSibsI().set(wsCUseridMask().wsAplic());
            if (wsCUseridMask().wsIdLog().isNumeric()) {
                hrMsxs093a().bsxl093a().arealig().dadosInput().nLogSibsI().set(wsCUseridMask().wsIdLog());
            }
            wsNContaMask().wsInicCont().set(0);
            wsNContaMask().wsCOeCont().set(msgIn().msg().ade().cOeEgcCont());
            wsNContaMask().wsNsRdclCont().set(msgIn().msg().ade().nsRdclCont());
            wsNContaMask().wsDigCont().set(msgIn().msg().ade().vChkdCont());
            wsNContaMask().wsTipoCont().set(msgIn().msg().ade().cTipoCont());
            hrMsxs093a().bsxl093a().arealig().dadosInput().nContSibsI().set(wsNConta);
            log(TraceLevel.Debug, "   BSXL093A-Z-VALOR-MOV-I     : ", hrMsxs093a().bsxl093a().arealig().dadosInput().zValorMovI());
            log(TraceLevel.Debug, "   BSXL093A-C-APL-EPDD-SIBS-I : ", hrMsxs093a().bsxl093a().arealig().dadosInput().cAplEpddSibsI());
            log(TraceLevel.Debug, "   BSXL093A-N-LOG-SIBS-I      : ", hrMsxs093a().bsxl093a().arealig().dadosInput().nLogSibsI());
            log(TraceLevel.Debug, "   BSXL093A-N-REG-LOG-SIBS-I  : ", hrMsxs093a().bsxl093a().arealig().dadosInput().nRegLogSibsI());
            log(TraceLevel.Debug, "   BSXL093A-N-CONT-SIBS-I     : ", hrMsxs093a().bsxl093a().arealig().dadosInput().nContSibsI());
            hrMsxs093a().run() ;
            if (!hrMsxs093a().bsxl093a().arealig().output().outputStatus().opStatusOk().isTrue()) {
                progNaoExisteInfAdic.setTrue() ;
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                envOut.db2Log().nmTabela().set(hrMsxs093a().bsxl093a().arealig().output().outputStatus().opMsgTabS().opNomeTabS());
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
            }
            if (progOk.isTrue()) {
                msgOut().msg().ade().grOutros().nCartao().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cPanCmplSibsO());
                msgOut().msg().ade().grOutros().cLoclEntidade().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().xLclzTermSibsO());
                msgOut().msg().ade().grOutros().cIdentAtm().cCcmzApoi().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cBancApoiSibsO());
                wsCIdTermSx.set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cIdTermSibsO());
                msgOut().msg().ade().grOutros().cIdentAtm().cTermAtm().set(wsCIdTermSxMask().wsTermSx());
                msgOut().msg().ade().grOutros().cIdentAtm().cEquiAtm().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().dTipoTermSibsO());
                /**
                 * MOVE BSXL093A-NM-LOCALIDADE-O
                 * TO BGHM0981-C-LOCL-ENTIDADE
                 */
                msgOut().msg().ade().grOutros().cPostal().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cPostalO());
                wsHTransaccaoSx().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().hTransaccaoO());
                wsHTransaccao().wsHh().set(wsHTransaccaoSx().wsHhSx());
                wsHTransaccao().wsMm().set(wsHTransaccaoSx().wsMmSx());
                wsHTransaccao().wsSs().set(wsHTransaccaoSx().wsSsSx());
                wsHTransaccao().wsDd().set(" ");
                msgOut().msg().ade().grOutros().hpTmerLocl().set(wsHTransaccao());
                msgOut().msg().ade().grOutros().mMovOrigTran().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().mMovimentoO());
                msgOut().msg().ade().grOutros().cMoeOrigTran().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cMoedIsoMovO());
                if (msgOut().msg().ade().grOutros().cMoeOrigTran().isEmpty()) {
                    msgOut().msg().ade().grOutros().cMoeOrigTran().set("EUR");
                }
                msgOut().msg().ade().grOutros().cRefDst().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().xRefMovDestO());
                msgOut().msg().ade().grOutros().nmOrdnTrfc().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().nmOrdnTrfcO());
                msgOut().msg().ade().grOutros().cEntidade().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cEntCbrSrvSibsO());
                if (msgOut().msg().ade().grOutros().cEntidade().isEqual("00000")) {
                    msgOut().msg().ade().grOutros().cEntidade().set(" ");
                }
                msgOut().msg().ade().grOutros().cRefPagamento().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cRefPagSrvSibsO());
                /**
                 * IF BGHM0981-C-REF-PAGAMENTO = '000000000'
                 * MOVE SPACES            TO BGHM0981-C-REF-PAGAMENTO
                 * END-IF
                 */
                if (msgOut().msg().ade().grOutros().cRefPagamento().isEqual("000000000000000")) {
                    msgOut().msg().ade().grOutros().cRefPagamento().set(" ");
                }
                wsCTipoTermSibs().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cTipoServSibsO());
                msgOut().msg().ade().grOutros().nmEntidade().set(wsCTipoTermSibs().wsDescEntidade());
                msgOut().msg().ade().grOutros().xTpServico().set(wsCTipoTermSibs().wsDescTiposerv());
                msgOut().msg().ade().grOutros().iTipoSpteMov().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cTipoSpteMovO());
                msgOut().msg().ade().grOutros().cDadAdc().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().xInfAdiMovO());
                wsCRefSibsMask().wsAplicN().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().cAplEpddSibsO());
                wsCRefSibsMask().wsNrlog().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().nLogSibsO());
                wsCRefSibsMask().wsIdlog().set(hrMsxs093a().bsxl093a().arealig().dadosOutput().nRegLogSibsO());
                msgOut().msg().ade().grOutros().cRefSibs().set(wsCRefSibs);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52100ObtemChaveJourn() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        hrMghs102a().bghl102a().criterioConsulta().crtJour().setTrue() ;
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs102a().run() ;
        if (hrMghs102a().bghl102a().naoExiste().isTrue()) {
            a52110ObtemJournHo() ;
        }
        if (!hrMghs102a().bghl102a().naoExiste().isTrue() && !hrMghs102a().bghl102a().ok().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52110ObtemJournHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj356a().bhol356a().commarea().initialize() ;
        hrMhoj356a().bhol356a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj356a().bhol356a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMhoj356a().run() ;
        if (!hrMhoj356a().bhol356a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj356a().bhol356a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj356a().bhol356a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj356a().bhol356a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj356a().bhol356a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj356a().bhol356a().commarea().dadosErro().aAplErr());
        }
        if (progOk.isTrue()) {
            hrMghs102a().bghl102a().initialize() ;
            hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cPaisIsoaOeOpx());
            hrMghs102a().bghl102a().detalhe().cMnemEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cMnemEgcOpex());
            hrMghs102a().bghl102a().detalhe().cOeEgcOpex().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cOeEgcOpex());
            hrMghs102a().bghl102a().detalhe().cUserid().set(hrMhoj356a().bhol356a().commarea().dadosOutput().cUserid());
            hrMghs102a().bghl102a().detalhe().nJourBbn().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nJourBbn());
            hrMghs102a().bghl102a().detalhe().nsJourBbn().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nsJourBbn());
            hrMghs102a().bghl102a().detalhe().nsJourBbnDtlh().set(hrMhoj356a().bhol356a().commarea().dadosOutput().nsJourBbnDtlh());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000ObtemDadosHm() {
        /**
         * *----------------------------------------------------------------*
         */
        a55100ObtemDadosCmpl() ;
        if (progOk.isTrue()) {
            if (hrMghs102a().bghl102a().naoExiste().isTrue()) {
                a55109ObtemDadosHo() ;
            } else {
                a55200ObtemDadosPrinc() ;
            }
        }
        if (progOk.isTrue()) {
            a55300AcedeHm() ;
        }
        if (progOk.isTrue()) {
            a55400PreencheOutputHm() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55100ObtemDadosCmpl() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        hrMghs102a().bghl102a().criterioConsulta().crtCompleto().setTrue() ;
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue() && !hrMghs102a().bghl102a().naoExiste().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55109ObtemDadosHo() {
        /**
         * *----------------------------------------------------------------*
         */
        crtlMovDia.set(" ");
        wsDataHoje().set(execStartDate) ;
        wsData().wsHojeAno().set(wsDataHoje().wsHojeAno());
        wsData().wsHojeMes().set(wsDataHoje().wsHojeMes());
        wsData().wsHojeDia().set(wsDataHoje().wsHojeDia());
        if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsData())) {
            a55119AcedeHo() ;
        } else {
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55119AcedeHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs805a().bghl805a().initialize() ;
        hrMghs805a().bghl805a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs805a().bghl805a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs805a().bghl805a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs805a().bghl805a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs805a().bghl805a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs805a().bghl805a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs805a().bghl805a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs805a().bghl805a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs805a().bghl805a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs805a().run() ;
        if (hrMghs805a().bghl805a().ok().isTrue()) {
            movHoje.setTrue() ;
        } else {
            progStatus.set(hrMghs805a().bghl805a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs805a().bghl805a().cSqlcode());
            envOut.db2Log().nmTabela().set("THO00020");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55200ObtemDadosPrinc() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs200a().bghl200a().initialize() ;
        hrMghs200a().bghl200a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs200a().bghl200a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs200a().bghl200a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs200a().bghl200a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs200a().bghl200a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs200a().bghl200a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs200a().bghl200a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs200a().bghl200a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs200a().bghl200a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs200a().bghl200a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs200a().run() ;
        if (!hrMghs200a().bghl200a().ok().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs200a().bghl200a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55300AcedeHm() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhmj215a().bhml215a().commarea().initialize() ;
        hrMhmj215a().bhml215a().commarea().dadosInput().zProcessamento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        hrMhmj215a().bhml215a().commarea().dadosInput().zMovimento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        if (movHoje.isTrue()) {
            hrMhmj215a().bhml215a().commarea().dadosInput().cMnemEgcOpex().set(hrMghs805a().bghl805a().detalhe().cMnemEgcOpex());
            hrMhmj215a().bhml215a().commarea().dadosInput().cPaisIsoaFich().set(hrMghs805a().bghl805a().detalhe().cPaisIsoaOeOpx());
            hrMhmj215a().bhml215a().commarea().dadosInput().cOeEgcOpex().set(hrMghs805a().bghl805a().detalhe().cOeEgcOpex());
            hrMhmj215a().bhml215a().commarea().dadosInput().cUserid().set(hrMghs805a().bghl805a().detalhe().cUserid());
            hrMhmj215a().bhml215a().commarea().dadosInput().nJourBbn().set(hrMghs805a().bghl805a().detalhe().nJourBbn());
            hrMhmj215a().bhml215a().commarea().dadosInput().nsJourBbn().set(hrMghs805a().bghl805a().detalhe().nsJourBbn());
            hrMhmj215a().bhml215a().commarea().dadosInput().cEvenOpel().set(hrMghs805a().bghl805a().detalhe().cEvenOpel());
            hrMhmj215a().bhml215a().commarea().dadosInput().iDbcr().set(hrMghs805a().bghl805a().detalhe().iDbcr());
            hrMhmj215a().bhml215a().commarea().dadosInput().xRefMov().set(hrMghs805a().bghl805a().detalhe().xRefMov());
            hrMhmj215a().bhml215a().commarea().dadosInput().cFamiProd().set(hrMghs805a().bghl805a().detalhe().cFamiProd());
            hrMhmj215a().bhml215a().commarea().dadosInput().cProduto().set(hrMghs805a().bghl805a().detalhe().cProduto());
            /**
             * GARANTIR QUE, QUANDO O MOVIMENTO E DO DIA,TODA A INFORMACAO
             * A PASSAR NO ACESSO A ROTINA MHMJ215A E OBTIDA A PARTIR DO
             * MODULO MGHS805A
             * MOVE MGH200A-N-DOC-OPPS TO BHML215A-N-DOC-OPPS-MOV
             */
            hrMhmj215a().bhml215a().commarea().dadosInput().nDocOppsMov().set(hrMghs805a().bghl805a().detalhe().nCheque());
        } else {
            hrMhmj215a().bhml215a().commarea().dadosInput().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            hrMhmj215a().bhml215a().commarea().dadosInput().cPaisIsoaFich().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            hrMhmj215a().bhml215a().commarea().dadosInput().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
            hrMhmj215a().bhml215a().commarea().dadosInput().cUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
            hrMhmj215a().bhml215a().commarea().dadosInput().nJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
            hrMhmj215a().bhml215a().commarea().dadosInput().nsJourBbn().set(hrMghs102a().bghl102a().detalhe().nsJourBbn());
            hrMhmj215a().bhml215a().commarea().dadosInput().cEvenOpel().set(hrMghs102a().bghl102a().detalhe().cEvenOpel());
            hrMhmj215a().bhml215a().commarea().dadosInput().iDbcr().set(hrMghs200a().bghl200a().detalhe().iDbcr());
            hrMhmj215a().bhml215a().commarea().dadosInput().xRefMov().set(hrMghs200a().bghl200a().detalhe().xRefMov());
            hrMhmj215a().bhml215a().commarea().dadosInput().cFamiProd().set(hrMghs102a().bghl102a().detalhe().cFamiProd());
            hrMhmj215a().bhml215a().commarea().dadosInput().cProduto().set(hrMghs102a().bghl102a().detalhe().cProduto());
            hrMhmj215a().bhml215a().commarea().dadosInput().nDocOppsMov().set(hrMghs200a().bghl200a().detalhe().nDocOpps());
        }
        hrMhmj215a().run() ;
        log(TraceLevel.Debug, "   BHML215A-C-TIPO-ERRO-BBN  -", hrMhmj215a().bhml215a().commarea().dadosErro().cTipoErroBbn());
        log(TraceLevel.Debug, "   BHML215A-C-RTNO-EVEN-SWAL -", hrMhmj215a().bhml215a().commarea().dadosErro().cRtnoEvenSwal());
        if (!hrMhmj215a().bhml215a().commarea().dadosErro().semErros().isTrue()) {
            progNaoExisteInfAdic.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().nmTabela().set(hrMhmj215a().bhml215a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55400PreencheOutputHm() {
        /**
         * *----------------------------------------------------------------*
         */
        wsCDadAdc.set(" ");
        wsNibDstn.set(" ");
        msgOut().msg().ade().grOutros().mMovOrigTran().set(hrMhmj215a().bhml215a().commarea().dadosOutput().mMovimento());
        msgOut().msg().ade().grOutros().cMoeOrigTran().set(hrMhmj215a().bhml215a().commarea().dadosOutput().cMoeIsoSctaMov());
        msgOut().msg().ade().grOutros().nmOrdnTrfc().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nmOrdn());
        msgOut().msg().ade().grOutros().xTpServico().set(hrMhmj215a().bhml215a().commarea().dadosOutput().dOpeSibs());
        msgOut().msg().ade().grOutros().cRefSibs().set(hrMhmj215a().bhml215a().commarea().dadosOutput().cOpeSibs());
        if (!hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().cCrtzMovCrcb().isEmpty()) {
            wsCDadAdcMask().wsCCrtzMovCrcb().set(hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().cCrtzMovCrcb());
        }
        if (!hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().xRefAdcCrxSibs().isEmpty()) {
            wsCDadAdcMask().wsXRefAdcCrxSibs().set(hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().xRefAdcCrxSibs());
        }
        if (!hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().nIdCrdxSibs().isEqual(0)) {
            wsCDadAdcMask().wsNIdCrdxSibs().set(hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().nIdCrdxSibs());
        }
        if (!hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().xRefMovOrig().isEmpty()) {
            wsCDadAdcMask().wsXRefMovOrig().set(hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().xRefMovOrig());
        }
        if (!hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().iSepa().isEmpty()) {
            wsCDadAdcMask().wsISepa().set(hrMhmj215a().bhml215a().commarea().dadosOutput().dadosAdic().iSepa());
        }
        msgOut().msg().ade().grOutros().cDadAdc().set(wsCDadAdc);
        if (hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cBancContOrdn().isEqual(msgIn().msg().ade().cBancCont()) && 
            hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cOeEgcContOrdn().isEqual(msgIn().msg().ade().cOeEgcCont()) && 
            hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().nsRdclContOrdn().isEqual(msgIn().msg().ade().nsRdclCont()) && 
            hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().vChkdContOrdn().isEqual(msgIn().msg().ade().vChkdCont()) && 
            hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cTipoContOrdn().isEqual(msgIn().msg().ade().cTipoCont()) && 
            hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cTipoContOrdn().isEqual(msgIn().msg().ade().cTipoCont())) {
            wsNibDstnMask().wsCBancContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibDstn().cBancContDstn());
            wsNibDstnMask().wsCOeEgcContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibDstn().cOeEgcContDstn());
            wsNibDstnMask().wsNsRdclContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibDstn().nsRdclContDstn());
            wsNibDstnMask().wsVChkdContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibDstn().vChkdContDstn());
            wsNibDstnMask().wsCTipoContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibDstn().cTipoContDstn());
            wsNibDstnMask().wsVChkdNibDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibDstn().vChkdNibDstn());
            if (hrMhmj215a().bhml215a().commarea().dadosOutput().nibDstn().cOeEgcContDstn().isEqual(0)) {
                msgOut().msg().ade().grOutros().cRefDst().set(" ");
            } else {
                msgOut().msg().ade().grOutros().cRefDst().set(wsNibDstn);
            }
        } else {
            wsNibDstnMask().wsCBancContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cBancContOrdn());
            wsNibDstnMask().wsCOeEgcContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cOeEgcContOrdn());
            wsNibDstnMask().wsNsRdclContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().nsRdclContOrdn());
            wsNibDstnMask().wsVChkdContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().vChkdContOrdn());
            wsNibDstnMask().wsCTipoContDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cTipoContOrdn());
            wsNibDstnMask().wsVChkdNibDstn().set(hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().vChkdNibOrdn());
            if (hrMhmj215a().bhml215a().commarea().dadosOutput().nibOrdn().cOeEgcContOrdn().isEqual(0)) {
                msgOut().msg().ade().grOutros().cRefDst().set(" ");
            } else {
                msgOut().msg().ade().grOutros().cRefDst().set(wsNibDstn);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Responder() {
        log(TraceLevel.Debug, "PGHO098A * S70000-RESPONDER");
        log(TraceLevel.Debug, "   PROG-STATUS        : ", progStatus);
        if (!progOk.isTrue()) {
            progNaoExisteInfAdic.setTrue() ;
        }
        envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
        if (!envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(progStatus);
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        message.mensagem().headerR().transaccao().vizualizacao().setTrue() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            s30000Validar() ;
        }
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsCUseridMask extends IDataMask {
        
        @Data(size=2)
        IString wsAplic() ;
        
        @Data(size=4)
        IInt wsIdLog() ;
        
    }
    public interface WsCTipoServicoAMask extends IDataMask {
        
        @Data(size=2)
        IInt wsCTipoServN() ;
        
        @Data(size=18)
        IString wsRestoServ() ;
        
    }
    public interface WsCTipoTermSibs extends IDataStruct {
        
        @Data(size=40, value=" ")
        IString wsDescEntidade() ;
        
        @Data(size=39, value=" ", lpadding=1, lpaddingValue=" ")
        IString wsDescTiposerv() ;
        
    }
    public interface WsNibDstnMask extends IDataMask {
        
        @Data(size=4)
        IInt wsCBancContDstn() ;
        
        @Data(size=4)
        IInt wsCOeEgcContDstn() ;
        
        @Data(size=7)
        IInt wsNsRdclContDstn() ;
        
        @Data(size=1)
        IInt wsVChkdContDstn() ;
        
        @Data(size=3)
        IInt wsCTipoContDstn() ;
        
        @Data(size=2)
        IInt wsVChkdNibDstn() ;
        
    }
    public interface WsCDadAdcMask extends IDataMask {
        
        @Data(size=3)
        IString wsCCrtzMovCrcb() ;
        
        @Data(size=20, lpadding=1)
        IString wsXRefAdcCrxSibs() ;
        
        @Data(size=6, lpadding=1)
        IInt wsNIdCrdxSibs() ;
        
        @Data(size=35, lpadding=1)
        IString wsXRefMovOrig() ;
        
        @Data(size=1, lpadding=1, rpadding=1)
        IString wsISepa() ;
        
    }
    public interface WsDataHoje extends IDataStruct {
        
        @Data(size=4, value="0")
        IInt wsHojeAno() ;
        
        @Data(size=2, value="0")
        IInt wsHojeMes() ;
        
        @Data(size=2, value="0")
        IInt wsHojeDia() ;
        
    }
    public interface WsData extends IDataStruct {
        
        @Data(size=4, value="0")
        IInt wsHojeAno() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
        IInt wsHojeMes() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
        IInt wsHojeDia() ;
        
    }
    public interface WsNContaMask extends IDataMask {
        
        @Data(size=2)
        IInt wsInicCont() ;
        
        @Data(size=4)
        IInt wsCOeCont() ;
        
        @Data(size=6)
        IInt wsNsRdclCont() ;
        
        @Data(size=1)
        IInt wsDigCont() ;
        
        @Data(size=2)
        IInt wsTipoCont() ;
        
    }
    public interface WsHTransaccaoSx extends IDataStruct {
        
        @Data(size=2)
        IString wsHhSx() ;
        
        @Data(size=2, lpadding=1)
        IString wsMmSx() ;
        
        @Data(size=2, lpadding=1)
        IString wsSsSx() ;
        
    }
    public interface WsHTransaccao extends IDataStruct {
        
        @Data(size=2)
        IString wsHh() ;
        
        @Data(size=2)
        IString wsMm() ;
        
        @Data(size=2)
        IString wsSs() ;
        
        @Data(size=2, value=" ")
        IString wsDd() ;
        
    }
    public interface WsCIdTermSxMask extends IDataMask {
        
        @Data(size=6)
        IString wsInicTermSx() ;
        
        @Data(size=4)
        IString wsTermSx() ;
        
    }
    public interface WsCRefSibsMask extends IDataMask {
        
        @Data(size=2)
        IString wsAplicN() ;
        
        @Data(size=4)
        IInt wsNrlog() ;
        
        @Data(size=8)
        ILong wsIdlog() ;
        
    }
    
}
