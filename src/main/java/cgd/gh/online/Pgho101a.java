package cgd.gh.online;

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
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm1010 ;
import cgd.gh.structures.messages.Bghm1011 ;
import cgd.hj.structures.link.Bhjl001a ;
import cgd.ho.structures.link.Bhol351a ;
import cgd.gh.routines.Mghs001a ;
import cgd.gh.routines.Mghs210a ;
import cgd.gh.routines.Mghs023a ;
import cgd.gh.routines.Mghs024a ;
import cgd.gh.routines.Mghs025a ;
import cgd.gh.routines.Mghs026a ;
import cgd.gh.routines.Mghs027a ;
import cgd.gh.routines.Mghs028a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghs123a ;
import cgd.gh.routines.Mghs124a ;
import cgd.gh.routines.Mghs125a ;
import cgd.gh.routines.Mghs126a ;
import cgd.gh.routines.Mghs127a ;
import cgd.gh.routines.Mghs128a ;
import cgd.gh.routines.Mghj801a ;
import cgd.gh.routines.Mghs802a ;
import cgd.hj.routines.Mhjj060a ;
import cgd.hj.routines.Mhjj200a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : LISTA DETALHE DOS MOVIMENTOS DE UMA SUBCONTA
 * ---------->   HISTORICO "NORMAL" DE 3 A 8 ANOS <-----------
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho101a extends CgdGhBaseOnline<Pgho101a.EnvelopeIn, Pgho101a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1010
     */
    public abstract Bghm1010 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1011
     */
    public abstract Bghm1011 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1010.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1011.Msg msgOut() ;
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
     * @return instancia da classe Mghs001a
     */
    @Data
    protected abstract Mghs001a hrMghs001a() ;
    
    /**
     * @return instancia da classe Mghs210a
     */
    @Data
    protected abstract Mghs210a hrMghs210a() ;
    
    /**
     * @return instancia da classe Mghs023a
     */
    @Data
    protected abstract Mghs023a hrMghs023a() ;
    
    /**
     * @return instancia da classe Mghs024a
     */
    @Data
    protected abstract Mghs024a hrMghs024a() ;
    
    /**
     * @return instancia da classe Mghs025a
     */
    @Data
    protected abstract Mghs025a hrMghs025a() ;
    
    /**
     * @return instancia da classe Mghs026a
     */
    @Data
    protected abstract Mghs026a hrMghs026a() ;
    
    /**
     * @return instancia da classe Mghs027a
     */
    @Data
    protected abstract Mghs027a hrMghs027a() ;
    
    /**
     * @return instancia da classe Mghs028a
     */
    @Data
    protected abstract Mghs028a hrMghs028a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    /**
     * @return instancia da classe Mghs123a
     */
    @Data
    protected abstract Mghs123a hrMghs123a() ;
    
    /**
     * @return instancia da classe Mghs124a
     */
    @Data
    protected abstract Mghs124a hrMghs124a() ;
    
    /**
     * @return instancia da classe Mghs125a
     */
    @Data
    protected abstract Mghs125a hrMghs125a() ;
    
    /**
     * @return instancia da classe Mghs126a
     */
    @Data
    protected abstract Mghs126a hrMghs126a() ;
    
    /**
     * @return instancia da classe Mghs127a
     */
    @Data
    protected abstract Mghs127a hrMghs127a() ;
    
    /**
     * @return instancia da classe Mghs128a
     */
    @Data
    protected abstract Mghs128a hrMghs128a() ;
    
    /**
     * @return instancia da classe Mghj801a
     */
    @Data
    protected abstract Mghj801a hrMghj801a() ;
    
    /**
     * @return instancia da classe Mghs802a
     */
    @Data
    protected abstract Mghs802a hrMghs802a() ;
    
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
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bhjl001a
     */
    @Data
    protected abstract Bhjl001a bhjl001a() ;
    
    /**
     * @return instancia da classe Bhol351a
     */
    @Data
    protected abstract Bhol351a bhol351a() ;
    
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
    @Condition("097")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("066")
    protected ICondition progNaoExisMovHstAno ;
    @Data
    @Condition("098")
    protected ICondition progNaoContaHst ;
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
    
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    protected static final String WS_FIM_CONSULTA = "FC" ;
    
    @Data(size=2, value="12")
    protected IInt wsQItens ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="MGHK800A")
    protected IString mgh800aCRotina ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString mghj801aCRotina ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsCEibresp ;
    
    @Data(size=21, value=" ")
    protected IString wsXRefMov ;
    
    @Data(size=10, decimal=7, signed=true, value="0")
    protected IDecimal wsTJuro ;
    
    @Data(size=2)
    protected IString wsCTipoTrttCont ;
    @Data
    @Condition("01")
    protected ICondition wsTrttDepOrdem ;
    @Data
    @Condition("02")
    protected ICondition wsTrttPoupanca ;
    @Data
    @Condition("03")
    protected ICondition wsTrttDepPrazo ;
    @Data
    @Condition("09")
    protected ICondition wsTrttDepEstru ;
    @Data
    @Condition("12")
    protected ICondition wsTrttDepObrig ;
    @Data
    @Condition("19")
    protected ICondition wsTrttCtaMarg ;
    @Data
    @Condition("26")
    protected ICondition wsTrttCashCarry ;
    @Data
    @Condition("27")
    protected ICondition wsTrttCtaVostr ;
    @Data
    @Condition("28")
    protected ICondition wsTrttCtaNostr ;
    @Data
    @Condition("32")
    protected ICondition wsTrttCtaInter ;
    
    
    /**
     * @return instancia da classe local WsTs
     */
    @Data
    protected abstract WsTs wsTs() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovimento ;
    
    
    
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
        msgOut().msg().ase().set(msgIn().msg().ase());
        progOk.setTrue() ;
        msgOut().msg().ade().grMov().resetIndex() ;
    }
    
    /**
     * 
     * 
     */
    protected void s30000Validar() {
        /**
         * *----------------------------------------------------------------*
         */
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().iConsulta().isEmpty() || 
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().tsMovMax().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
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
        a50000ValidaPedido() ;
        if (progOk.isTrue()) {
            switch (hrMghs210a().bghl210a().detalhe().nmRecurso().get()) {
                case "VGH02301":
                    a51000AcederTgh00023() ;
                    break;
                case "VGH02401":
                    a52000AcederTgh00024() ;
                    break;
                case "VGH02501":
                    /**
                     * PERFORM A9999-VER-CONTA
                     */
                    if (progOk.isTrue()) {
                        a53000AcederTgh00025() ;
                    }
                    break;
                case "VGH02601":
                    /**
                     * PERFORM A9999-VER-CONTA
                     */
                    if (progOk.isTrue()) {
                        a54000AcederTgh00026() ;
                    }
                    break;
                case "VGH02701":
                    /**
                     * PERFORM A9999-VER-CONTA
                     */
                    if (progOk.isTrue()) {
                        a55000AcederTgh00027() ;
                    }
                    break;
                case "VGH02801":
                    /**
                     * PERFORM A9999-VER-CONTA
                     */
                    if (progOk.isTrue()) {
                        a56000AcederTgh00028() ;
                    }
                    break;
                default :
                    break ;
            }
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().comNmCli().isTrue()) {
                a59000ObtemCliente() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a50000ValidaPedido() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs001a().bghl001a().initialize() ;
        hrMghs210a().bghl210a().initialize() ;
        hrMghs001a().bghl001a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs210a().bghl210a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs001a().bghl001a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs210a().bghl210a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs001a().bghl001a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs210a().bghl210a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs001a().bghl001a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs210a().bghl210a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs001a().bghl001a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs210a().bghl210a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs001a().bghl001a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs210a().bghl210a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs001a().bghl001a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs210a().bghl210a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs001a().bghl001a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs210a().bghl210a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs001a().run() ;
        if (hrMghs001a().bghl001a().ok().isTrue()) {
            a50100ValidaDatas() ;
        } else {
            progStatus.set(hrMghs001a().bghl001a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs001a().bghl001a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00001");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a50100ValidaDatas() {
        /**
         * *----------------------------------------------------------------*
         */
        if (msgIn().msg().ade().ascendente().isTrue()) {
            wTimestamp().set(msgIn().msg().ade().tsMovimento());
        } else {
            wTimestamp().set(msgIn().msg().ade().tsMovMax());
        }
        if (wTimestamp().wDataTimestamp().isLess(hrMghs001a().bghl001a().detalhe().zAbraCont())) {
            if (!msgIn().msg().ade().cTipoCont().isEqual(34)) {
                wTimestamp().wDataTimestamp().set(hrMghs001a().bghl001a().detalhe().zAbraCont());
            }
            if (msgIn().msg().ade().ascendente().isTrue()) {
                msgIn().msg().ade().tsMovimento().set(wTimestamp());
            } else {
                msgIn().msg().ade().tsMovMax().set(wTimestamp());
            }
        }
        hrMghs210a().bghl210a().argumento().zaInicio().set(msgIn().msg().ade().zaMovimento());
        hrMghs210a().run() ;
        if (hrMghs210a().bghl210a().naoExisteConta().isTrue()) {
            progNaoExisMovHstAno.setTrue() ;
        }
        if (!hrMghs210a().bghl210a().naoExisteConta().isTrue() && !hrMghs210a().bghl210a().ok().isTrue()) {
            progStatus.set(hrMghs210a().bghl210a().cRetorno());
        }
        if (!progOk.isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs210a().bghl210a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00010");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000AcederTgh00023() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs023a().bghl023a().initialize() ;
        hrMghs023a().bghl023a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs023a().bghl023a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs023a().bghl023a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs023a().bghl023a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs023a().bghl023a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs023a().bghl023a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs023a().bghl023a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs023a().bghl023a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs023a().bghl023a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs023a().bghl023a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs023a().bghl023a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs023a().bghl023a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs023a().run() ;
        if (!hrMghs023a().bghl023a().ok().isTrue()) {
            progStatus.set(hrMghs023a().bghl023a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs023a().bghl023a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00023");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs023a().bghl023a().qItens().isLessOrEqual(wsQItens)) {
                wsQItens.set(hrMghs023a().bghl023a().qItens());
            }
            for (hrMghs023a().bghl023a().tabela().lista().setIndex(1); hrMghs023a().bghl023a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs023a().bghl023a().tabela().lista().incIndex()) {
                hrMghs023a().bghl023a().argumento().set(hrMghs023a().bghl023a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs023a().bghl023a().detalhe().set(hrMghs023a().bghl023a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(hrMghs023a().bghl023a().argumento().tsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(hrMghs023a().bghl023a().argumento().nsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(hrMghs023a().bghl023a().detalhe().zValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghs023a().bghl023a().detalhe().xRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(hrMghs023a().bghl023a().detalhe().mMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(hrMghs023a().bghl023a().detalhe().iDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(hrMghs023a().bghl023a().detalhe().iEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(hrMghs023a().bghl023a().detalhe().cMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(hrMghs023a().bghl023a().detalhe().mSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(hrMghs023a().bghl023a().detalhe().mSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(hrMghs023a().bghl023a().detalhe().mMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(hrMghs023a().bghl023a().detalhe().nDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(hrMghs023a().bghl023a().detalhe().aAplOrig());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(hrMghs023a().bghl023a().detalhe().iExisInfAdi());
                if (hrMghs023a().bghl023a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs023a().bghl023a().argumento().tsMovimento());
                    a53100ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        msgOut().msg().ade().grMov().getCurrent().tJuro().set(wsTJuro);
                    }
                }
                msgOut().msg().ade().grMov().incIndex() ;
            }
            if (progOk.isTrue()) {
                if (hrMghs023a().bghl023a().qItens().isEqual(13)) {
                    msgOut().msg().ade().iMsgCtnd().set("S");
                    msgOut().msg().ade().tsMovimentoK().set(hrMghs023a().bghl023a().argumento().tsMovimento());
                    msgOut().msg().ade().nsMovimentoK().set(hrMghs023a().bghl023a().argumento().nsMovimento());
                } else {
                    msgOut().msg().ade().iMsgCtnd().set("N");
                    envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000AcederTgh00024() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs024a().bghl024a().initialize() ;
        hrMghs024a().bghl024a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs024a().bghl024a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs024a().bghl024a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs024a().bghl024a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs024a().bghl024a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs024a().bghl024a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs024a().bghl024a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs024a().bghl024a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs024a().bghl024a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs024a().bghl024a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs024a().bghl024a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs024a().bghl024a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs024a().run() ;
        if (!hrMghs024a().bghl024a().ok().isTrue()) {
            progStatus.set(hrMghs024a().bghl024a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs024a().bghl024a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00024");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs024a().bghl024a().qItens().isLessOrEqual(wsQItens)) {
                wsQItens.set(hrMghs024a().bghl024a().qItens());
            }
            for (hrMghs024a().bghl024a().tabela().lista().setIndex(1); hrMghs024a().bghl024a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs024a().bghl024a().tabela().lista().incIndex()) {
                hrMghs024a().bghl024a().argumento().set(hrMghs024a().bghl024a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs024a().bghl024a().detalhe().set(hrMghs024a().bghl024a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(hrMghs024a().bghl024a().argumento().tsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(hrMghs024a().bghl024a().argumento().nsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(hrMghs024a().bghl024a().detalhe().zValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghs024a().bghl024a().detalhe().xRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(hrMghs024a().bghl024a().detalhe().mMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(hrMghs024a().bghl024a().detalhe().iDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(hrMghs024a().bghl024a().detalhe().iEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(hrMghs024a().bghl024a().detalhe().cMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(hrMghs024a().bghl024a().detalhe().mSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(hrMghs024a().bghl024a().detalhe().mSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(hrMghs024a().bghl024a().detalhe().mMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(hrMghs024a().bghl024a().detalhe().nDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(hrMghs024a().bghl024a().detalhe().aAplOrig());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(hrMghs024a().bghl024a().detalhe().iExisInfAdi());
                if (hrMghs024a().bghl024a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs024a().bghl024a().argumento().tsMovimento());
                    a53100ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        msgOut().msg().ade().grMov().getCurrent().tJuro().set(wsTJuro);
                    }
                }
                msgOut().msg().ade().grMov().incIndex() ;
            }
            if (progOk.isTrue()) {
                if (hrMghs024a().bghl024a().qItens().isEqual(13)) {
                    msgOut().msg().ade().iMsgCtnd().set("S");
                    msgOut().msg().ade().tsMovimentoK().set(hrMghs024a().bghl024a().argumento().tsMovimento());
                    msgOut().msg().ade().nsMovimentoK().set(hrMghs024a().bghl024a().argumento().nsMovimento());
                } else {
                    msgOut().msg().ade().iMsgCtnd().set("N");
                    envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53000AcederTgh00025() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs025a().bghl025a().initialize() ;
        hrMghs025a().bghl025a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs025a().bghl025a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs025a().bghl025a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs025a().bghl025a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs025a().bghl025a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs025a().bghl025a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs025a().bghl025a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs025a().bghl025a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs025a().bghl025a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs025a().bghl025a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs025a().bghl025a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs025a().bghl025a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs025a().run() ;
        if (!hrMghs025a().bghl025a().ok().isTrue()) {
            progStatus.set(hrMghs025a().bghl025a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs025a().bghl025a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00025");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs025a().bghl025a().qItens().isLessOrEqual(wsQItens)) {
                wsQItens.set(hrMghs025a().bghl025a().qItens());
            }
            for (hrMghs025a().bghl025a().tabela().lista().setIndex(1); hrMghs025a().bghl025a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs025a().bghl025a().tabela().lista().incIndex()) {
                hrMghs025a().bghl025a().argumento().set(hrMghs025a().bghl025a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs025a().bghl025a().detalhe().set(hrMghs025a().bghl025a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(hrMghs025a().bghl025a().argumento().tsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(hrMghs025a().bghl025a().argumento().nsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(hrMghs025a().bghl025a().detalhe().zValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghs025a().bghl025a().detalhe().xRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(hrMghs025a().bghl025a().detalhe().mMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(hrMghs025a().bghl025a().detalhe().iDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(hrMghs025a().bghl025a().detalhe().iEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(hrMghs025a().bghl025a().detalhe().cMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(hrMghs025a().bghl025a().detalhe().mSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(hrMghs025a().bghl025a().detalhe().mSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(hrMghs025a().bghl025a().detalhe().mMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(hrMghs025a().bghl025a().detalhe().nDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(hrMghs025a().bghl025a().detalhe().aAplOrig());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(hrMghs025a().bghl025a().detalhe().iExisInfAdi());
                if (hrMghs025a().bghl025a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs025a().bghl025a().argumento().tsMovimento());
                    a53100ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        msgOut().msg().ade().grMov().getCurrent().tJuro().set(wsTJuro);
                    }
                }
                msgOut().msg().ade().grMov().incIndex() ;
            }
            if (progOk.isTrue()) {
                if (hrMghs025a().bghl025a().qItens().isEqual(13)) {
                    msgOut().msg().ade().iMsgCtnd().set("S");
                    msgOut().msg().ade().tsMovimentoK().set(hrMghs025a().bghl025a().argumento().tsMovimento());
                    msgOut().msg().ade().nsMovimentoK().set(hrMghs025a().bghl025a().argumento().nsMovimento());
                } else {
                    msgOut().msg().ade().iMsgCtnd().set("N");
                    envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a54000AcederTgh00026() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs026a().bghl026a().initialize() ;
        hrMghs026a().bghl026a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs026a().bghl026a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs026a().bghl026a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs026a().bghl026a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs026a().bghl026a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs026a().bghl026a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs026a().bghl026a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs026a().bghl026a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs026a().bghl026a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs026a().bghl026a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs026a().bghl026a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs026a().bghl026a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs026a().run() ;
        if (!hrMghs026a().bghl026a().ok().isTrue()) {
            progStatus.set(hrMghs026a().bghl026a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs026a().bghl026a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00026");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs026a().bghl026a().qItens().isLessOrEqual(wsQItens)) {
                wsQItens.set(hrMghs026a().bghl026a().qItens());
            }
            for (hrMghs026a().bghl026a().tabela().lista().setIndex(1); hrMghs026a().bghl026a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs026a().bghl026a().tabela().lista().incIndex()) {
                hrMghs026a().bghl026a().argumento().set(hrMghs026a().bghl026a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs026a().bghl026a().detalhe().set(hrMghs026a().bghl026a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(hrMghs026a().bghl026a().argumento().tsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(hrMghs026a().bghl026a().argumento().nsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(hrMghs026a().bghl026a().detalhe().zValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghs026a().bghl026a().detalhe().xRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(hrMghs026a().bghl026a().detalhe().mMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(hrMghs026a().bghl026a().detalhe().iDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(hrMghs026a().bghl026a().detalhe().iEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(hrMghs026a().bghl026a().detalhe().cMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(hrMghs026a().bghl026a().detalhe().mSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(hrMghs026a().bghl026a().detalhe().mSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(hrMghs026a().bghl026a().detalhe().mMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(hrMghs026a().bghl026a().detalhe().nDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(hrMghs026a().bghl026a().detalhe().aAplOrig());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(hrMghs026a().bghl026a().detalhe().iExisInfAdi());
                if (hrMghs026a().bghl026a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs026a().bghl026a().argumento().tsMovimento());
                    a53100ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        msgOut().msg().ade().grMov().getCurrent().tJuro().set(wsTJuro);
                    }
                }
                msgOut().msg().ade().grMov().incIndex() ;
            }
            if (progOk.isTrue()) {
                if (hrMghs026a().bghl026a().qItens().isEqual(13)) {
                    msgOut().msg().ade().iMsgCtnd().set("S");
                    msgOut().msg().ade().tsMovimentoK().set(hrMghs026a().bghl026a().argumento().tsMovimento());
                    msgOut().msg().ade().nsMovimentoK().set(hrMghs026a().bghl026a().argumento().nsMovimento());
                } else {
                    msgOut().msg().ade().iMsgCtnd().set("N");
                    envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000AcederTgh00027() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs027a().bghl027a().initialize() ;
        hrMghs027a().bghl027a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs027a().bghl027a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs027a().bghl027a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs027a().bghl027a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs027a().bghl027a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs027a().bghl027a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs027a().bghl027a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs027a().bghl027a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs027a().bghl027a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs027a().bghl027a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs027a().bghl027a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs027a().bghl027a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs027a().run() ;
        if (!hrMghs027a().bghl027a().ok().isTrue()) {
            progStatus.set(hrMghs027a().bghl027a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs027a().bghl027a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00027");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs027a().bghl027a().qItens().isLessOrEqual(wsQItens)) {
                wsQItens.set(hrMghs027a().bghl027a().qItens());
            }
            for (hrMghs027a().bghl027a().tabela().lista().setIndex(1); hrMghs027a().bghl027a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs027a().bghl027a().tabela().lista().incIndex()) {
                hrMghs027a().bghl027a().argumento().set(hrMghs027a().bghl027a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs027a().bghl027a().detalhe().set(hrMghs027a().bghl027a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(hrMghs027a().bghl027a().argumento().tsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(hrMghs027a().bghl027a().argumento().nsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(hrMghs027a().bghl027a().detalhe().zValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghs027a().bghl027a().detalhe().xRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(hrMghs027a().bghl027a().detalhe().mMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(hrMghs027a().bghl027a().detalhe().iDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(hrMghs027a().bghl027a().detalhe().iEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(hrMghs027a().bghl027a().detalhe().cMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(hrMghs027a().bghl027a().detalhe().mSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(hrMghs027a().bghl027a().detalhe().mSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(hrMghs027a().bghl027a().detalhe().mMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(hrMghs027a().bghl027a().detalhe().nDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(hrMghs027a().bghl027a().detalhe().aAplOrig());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(hrMghs027a().bghl027a().detalhe().iExisInfAdi());
                if (hrMghs027a().bghl027a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs027a().bghl027a().argumento().tsMovimento());
                    a53100ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        msgOut().msg().ade().grMov().getCurrent().tJuro().set(wsTJuro);
                    }
                }
                msgOut().msg().ade().grMov().incIndex() ;
            }
            if (progOk.isTrue()) {
                if (hrMghs027a().bghl027a().qItens().isEqual(13)) {
                    msgOut().msg().ade().iMsgCtnd().set("S");
                    msgOut().msg().ade().tsMovimentoK().set(hrMghs027a().bghl027a().argumento().tsMovimento());
                    msgOut().msg().ade().nsMovimentoK().set(hrMghs027a().bghl027a().argumento().nsMovimento());
                } else {
                    msgOut().msg().ade().iMsgCtnd().set("N");
                    envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56000AcederTgh00028() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs028a().bghl028a().initialize() ;
        hrMghs028a().bghl028a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs028a().bghl028a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs028a().bghl028a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs028a().bghl028a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs028a().bghl028a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs028a().bghl028a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs028a().bghl028a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs028a().bghl028a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs028a().bghl028a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs028a().bghl028a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs028a().bghl028a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs028a().bghl028a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs028a().run() ;
        if (!hrMghs028a().bghl028a().ok().isTrue()) {
            progStatus.set(hrMghs028a().bghl028a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs028a().bghl028a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00028");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            if (hrMghs028a().bghl028a().qItens().isLessOrEqual(wsQItens)) {
                wsQItens.set(hrMghs028a().bghl028a().qItens());
            }
            for (hrMghs028a().bghl028a().tabela().lista().setIndex(1); hrMghs028a().bghl028a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs028a().bghl028a().tabela().lista().incIndex()) {
                hrMghs028a().bghl028a().argumento().set(hrMghs028a().bghl028a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs028a().bghl028a().detalhe().set(hrMghs028a().bghl028a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(hrMghs028a().bghl028a().argumento().tsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(hrMghs028a().bghl028a().argumento().nsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(hrMghs028a().bghl028a().detalhe().zValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghs028a().bghl028a().detalhe().xRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(hrMghs028a().bghl028a().detalhe().mMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(hrMghs028a().bghl028a().detalhe().iDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(hrMghs028a().bghl028a().detalhe().iEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(hrMghs028a().bghl028a().detalhe().cMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(hrMghs028a().bghl028a().detalhe().mSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(hrMghs028a().bghl028a().detalhe().mSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(hrMghs028a().bghl028a().detalhe().mMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(hrMghs028a().bghl028a().detalhe().nDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(hrMghs028a().bghl028a().detalhe().aAplOrig());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(hrMghs028a().bghl028a().detalhe().iExisInfAdi());
                if (hrMghs028a().bghl028a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs028a().bghl028a().argumento().tsMovimento());
                    a53100ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        msgOut().msg().ade().grMov().getCurrent().tJuro().set(wsTJuro);
                    }
                }
                msgOut().msg().ade().grMov().incIndex() ;
            }
            if (progOk.isTrue()) {
                if (hrMghs028a().bghl028a().qItens().isEqual(13)) {
                    msgOut().msg().ade().iMsgCtnd().set("S");
                    msgOut().msg().ade().tsMovimentoK().set(hrMghs028a().bghl028a().argumento().tsMovimento());
                    msgOut().msg().ade().nsMovimentoK().set(hrMghs028a().bghl028a().argumento().nsMovimento());
                } else {
                    msgOut().msg().ade().iMsgCtnd().set("N");
                    envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53100ObtemDescritivoMov() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(msgOut().msg().ade().grMov().getCurrent().iDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(msgOut().msg().ade().grMov().getCurrent().iEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(msgOut().msg().ade().grMov().getCurrent().zValMov());
        a53110ObterCOeOpex() ;
        if (progOk.isTrue()) {
            a53120ObtemCOpeBbn() ;
        }
        if (progOk.isTrue()) {
            if (hrMghk800a().bghl800a().input().cOpeBbn().isEmpty()) {
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(" ");
            } else {
                hrMghk800a().run() ;
                if (hrMghk800a().bghl800a().ok().isTrue()) {
                    msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
                    wsCTipoTrttCont.set(hrMghk800a().bghl800a().output().cTipoTrttCont());
                } else {
                    msgOut().msg().ade().grMov().getCurrent().xRefMov().set(" ");
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53110ObterCOeOpex() {
        /**
         * *----------------------------------------------------------------*
         */
        switch (hrMghs210a().bghl210a().detalhe().nmRecurso().get()) {
            case "VGH02301":
                a53111AcederTgh00123() ;
                break;
            case "VGH02401":
                a53112AcederTgh00124() ;
                break;
            case "VGH02501":
                a53113AcederTgh00125() ;
                break;
            case "VGH02601":
                a53114AcederTgh00126() ;
                break;
            case "VGH02701":
                a53115AcederTgh00127() ;
                break;
            case "VGH02801":
                a53116AcederTgh00128() ;
                break;
            default :
                break ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53111AcederTgh00123() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs123a().bghl123a().initialize() ;
        hrMghs123a().bghl123a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs123a().bghl123a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs123a().bghl123a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs123a().bghl123a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs123a().bghl123a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs123a().bghl123a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs123a().bghl123a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs123a().bghl123a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs123a().bghl123a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs123a().bghl123a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs123a().bghl123a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs123a().run() ;
        if (hrMghs123a().bghl123a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs123a().bghl123a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs123a().bghl123a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs123a().bghl123a().detalhe().cOeEgcOpex());
        } else {
            progStatus.set(hrMghs123a().bghl123a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs123a().bghl123a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00123");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53112AcederTgh00124() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs124a().bghl124a().initialize() ;
        hrMghs124a().bghl124a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs124a().bghl124a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs124a().bghl124a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs124a().bghl124a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs124a().bghl124a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs124a().bghl124a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs124a().bghl124a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs124a().bghl124a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs124a().bghl124a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs124a().bghl124a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs124a().bghl124a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs124a().run() ;
        if (hrMghs124a().bghl124a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs124a().bghl124a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs124a().bghl124a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs124a().bghl124a().detalhe().cOeEgcOpex());
        } else {
            progStatus.set(hrMghs124a().bghl124a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs124a().bghl124a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00124");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53113AcederTgh00125() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs125a().bghl125a().initialize() ;
        hrMghs125a().bghl125a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs125a().bghl125a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs125a().bghl125a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs125a().bghl125a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs125a().bghl125a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs125a().bghl125a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs125a().bghl125a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs125a().bghl125a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs125a().bghl125a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs125a().bghl125a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs125a().bghl125a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs125a().run() ;
        if (hrMghs125a().bghl125a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs125a().bghl125a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs125a().bghl125a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs125a().bghl125a().detalhe().cOeEgcOpex());
        } else {
            progStatus.set(hrMghs125a().bghl125a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs125a().bghl125a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00125");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53114AcederTgh00126() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs126a().bghl126a().initialize() ;
        hrMghs126a().bghl126a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs126a().bghl126a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs126a().bghl126a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs126a().bghl126a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs126a().bghl126a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs126a().bghl126a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs126a().bghl126a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs126a().bghl126a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs126a().bghl126a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs126a().bghl126a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs126a().bghl126a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs126a().run() ;
        if (hrMghs126a().bghl126a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs126a().bghl126a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs126a().bghl126a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs126a().bghl126a().detalhe().cOeEgcOpex());
        } else {
            progStatus.set(hrMghs126a().bghl126a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs126a().bghl126a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00126");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53115AcederTgh00127() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs127a().bghl127a().initialize() ;
        hrMghs127a().bghl127a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs127a().bghl127a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs127a().bghl127a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs127a().bghl127a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs127a().bghl127a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs127a().bghl127a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs127a().bghl127a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs127a().bghl127a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs127a().bghl127a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs127a().bghl127a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs127a().bghl127a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs127a().run() ;
        if (hrMghs127a().bghl127a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs127a().bghl127a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs127a().bghl127a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs127a().bghl127a().detalhe().cOeEgcOpex());
        } else {
            progStatus.set(hrMghs127a().bghl127a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs127a().bghl127a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00127");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53116AcederTgh00128() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs128a().bghl128a().initialize() ;
        hrMghs128a().bghl128a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs128a().bghl128a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs128a().bghl128a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs128a().bghl128a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs128a().bghl128a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs128a().bghl128a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs128a().bghl128a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs128a().bghl128a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs128a().bghl128a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs128a().bghl128a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs128a().bghl128a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs128a().run() ;
        if (hrMghs128a().bghl128a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs128a().bghl128a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs128a().bghl128a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs128a().bghl128a().detalhe().cOeEgcOpex());
        } else {
            progStatus.set(hrMghs128a().bghl128a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs128a().bghl128a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00128");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53120ObtemCOpeBbn() {
        /**
         * *----------------------------------------------------------------*
         */
        switch (hrMghs210a().bghl210a().detalhe().nmRecurso().get()) {
            case "VGH02301":
                a53121AcederTgh00123() ;
                break;
            case "VGH02401":
                a53122AcederTgh00124() ;
                break;
            case "VGH02501":
                a53123AcederTgh00125() ;
                break;
            case "VGH02601":
                a53124AcederTgh00126() ;
                break;
            case "VGH02701":
                a53125AcederTgh00127() ;
                break;
            case "VGH02801":
                a53126AcederTgh00128() ;
                break;
            default :
                break ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53121AcederTgh00123() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs123a().bghl123a().initialize() ;
        hrMghs123a().bghl123a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs123a().bghl123a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs123a().bghl123a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs123a().bghl123a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs123a().bghl123a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs123a().bghl123a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs123a().bghl123a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs123a().bghl123a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs123a().bghl123a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs123a().bghl123a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs123a().bghl123a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs123a().run() ;
        if (hrMghs123a().bghl123a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs123a().bghl123a().detalhe().cOpeBbn());
        } else {
            progStatus.set(hrMghs123a().bghl123a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs123a().bghl123a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53122AcederTgh00124() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs124a().bghl124a().initialize() ;
        hrMghs124a().bghl124a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs124a().bghl124a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs124a().bghl124a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs124a().bghl124a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs124a().bghl124a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs124a().bghl124a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs124a().bghl124a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs124a().bghl124a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs124a().bghl124a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs124a().bghl124a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs124a().bghl124a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs124a().run() ;
        if (hrMghs124a().bghl124a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs124a().bghl124a().detalhe().cOpeBbn());
        } else {
            progStatus.set(hrMghs124a().bghl124a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs124a().bghl124a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00124");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53123AcederTgh00125() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs125a().bghl125a().initialize() ;
        hrMghs125a().bghl125a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs125a().bghl125a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs125a().bghl125a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs125a().bghl125a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs125a().bghl125a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs125a().bghl125a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs125a().bghl125a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs125a().bghl125a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs125a().bghl125a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs125a().bghl125a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs125a().bghl125a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs125a().run() ;
        if (hrMghs125a().bghl125a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs125a().bghl125a().detalhe().cOpeBbn());
        } else {
            progStatus.set(hrMghs125a().bghl125a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs125a().bghl125a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00125");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53124AcederTgh00126() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs126a().bghl126a().initialize() ;
        hrMghs126a().bghl126a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs126a().bghl126a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs126a().bghl126a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs126a().bghl126a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs126a().bghl126a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs126a().bghl126a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs126a().bghl126a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs126a().bghl126a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs126a().bghl126a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs126a().bghl126a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs126a().bghl126a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs126a().run() ;
        if (hrMghs126a().bghl126a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs126a().bghl126a().detalhe().cOpeBbn());
        } else {
            progStatus.set(hrMghs126a().bghl126a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs126a().bghl126a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00126");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53125AcederTgh00127() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs127a().bghl127a().initialize() ;
        hrMghs127a().bghl127a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs127a().bghl127a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs127a().bghl127a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs127a().bghl127a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs127a().bghl127a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs127a().bghl127a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs127a().bghl127a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs127a().bghl127a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs127a().bghl127a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs127a().bghl127a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs127a().bghl127a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs127a().run() ;
        if (hrMghs127a().bghl127a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs127a().bghl127a().detalhe().cOpeBbn());
        } else {
            progStatus.set(hrMghs127a().bghl127a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs127a().bghl127a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00127");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53126AcederTgh00128() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs128a().bghl128a().initialize() ;
        hrMghs128a().bghl128a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs128a().bghl128a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs128a().bghl128a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs128a().bghl128a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs128a().bghl128a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs128a().bghl128a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs128a().bghl128a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs128a().bghl128a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs128a().bghl128a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs128a().bghl128a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs128a().bghl128a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs128a().run() ;
        if (hrMghs128a().bghl128a().ok().isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs128a().bghl128a().detalhe().cOpeBbn());
        } else {
            progStatus.set(hrMghs128a().bghl128a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs128a().bghl128a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00128");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53200VerificaContaHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghj801a().bghl801a().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghj801a().bghl801a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghj801a().bghl801a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        if (msgOut().msg().ade().grMov().getCurrent().iEstorno().isEqual("E")) {
            if (msgOut().msg().ade().grMov().getCurrent().iDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(msgOut().msg().ade().grMov().getCurrent().iDbcr());
        }
        hrMghj801a().run() ;
        if (hrMghj801a().bghl801a().ok().isTrue()) {
            wsCTipoTrttCont.set(hrMghj801a().bghl801a().detalhe().cTipoTrttCont());
        } else {
            wsCTipoTrttCont.set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53300ObtemTaxa() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs802a().bghl802a().initialize() ;
        hrMghs802a().bghl802a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs802a().bghl802a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs802a().bghl802a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs802a().bghl802a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs802a().bghl802a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs802a().bghl802a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs802a().bghl802a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs802a().bghl802a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs802a().run() ;
        if (hrMghs802a().bghl802a().ok().isTrue()) {
            wsTJuro.set(hrMghs802a().bghl802a().detalhe().tJuro());
        } else {
            wsTJuro.set(0);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a59000ObtemCliente() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhjj060a().bhjl060a().commarea().initialize() ;
        bhjl001a().commarea().initialize() ;
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl001a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl001a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().zConsulta().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhjl001a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhjl001a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhjl001a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhjl001a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhjl001a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhjl001a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().iTipoItvt().set(101);
        bhjl001a().commarea().dadosEntrada().iTipoItvt().set(101);
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsTitc().set(1);
        bhjl001a().commarea().dadosEntrada().nsTitc().set(1);
        hrMhjj060a().run() ;
        if (hrMhjj060a().bhjl060a().commarea().erros().semErros().isTrue()) {
            if (hrMhjj060a().bhjl060a().commarea().erros().clienteConfidencial().isTrue()) {
                msgOut().msg().ade().cTitHono().set(" ");
                msgOut().msg().ade().nmCliAbvd().set(" ");
            } else {
                /**
                 * MOVE BHJL060A-N-CLIENTE    TO BHJL001A-N-CLIENTE
                 * DISPLAY 'BHJL001A-N-CLIENTE-' BHJL001A-N-CLIENTE
                 */
                bhjl001a().commarea().dadosEntrada().nsAbraCli().set(hrMhjj060a().bhjl060a().commarea().dadosSaida().nsAbraCli());
                a59100ObtemNomeCli() ;
            }
        } else {
            envOut.errosGraves().cTipoErroBbn().set(hrMhjj060a().bhjl060a().commarea().erros().cTipoErroBbn());
            progStatus.set(hrMhjj060a().bhjl060a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhjj060a().bhjl060a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhjj060a().bhjl060a().commarea().erros().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhjj060a().bhjl060a().commarea().erros().aAplErr());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a59100ObtemNomeCli() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhjj200a().run() ;
        if (bhjl001a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().cTitHono().set(bhjl001a().commarea().dadosSaida().cTitHono());
            msgOut().msg().ade().nmCliAbvd().set(bhjl001a().commarea().dadosSaida().nmCliAbvd());
        } else if (bhjl001a().commarea().erros().nomeNExi().isTrue()) {
            msgOut().msg().ade().cTitHono().set(" ");
            msgOut().msg().ade().nmCliAbvd().set(" ");
        } else {
            envOut.errosGraves().cTipoErroBbn().set(bhjl001a().commarea().erros().cTipoErroBbn());
            progStatus.set(bhjl001a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl001a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl001a().commarea().erros().nmTabela());
            envOut.errosGraves().aAplErr().set(bhjl001a().commarea().erros().aAplErr());
        }
    }
    
    /**
     * 
     * *A9999-VER-CONTA.
     * COPY BGHP9998.
     * 
     */
    protected void s70000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
        if (!progOk.isTrue()) {
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
    public interface WsTs extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTs
         */
        @Data(rpadding=16, rpaddingValue="")
        WDataTs wDataTs() ;
        
        
        public interface WDataTs extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaMin() ;
            
        }
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
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wResto() ;
            
        }
    }
    
}
