package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0990 ;
import cgd.gh.structures.messages.Bghm0991 ;
import cgd.ho.structures.link.Bhol351a ;
import cgd.gh.online.Pgho097a ;
import cgd.gh.routines.Mghs003a ;
import cgd.ho.routines.Mhoj357a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghs501a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO COMPLEMENTAR ASSOCIADA AO
 * MOVIMENTO - DISPONIVEL APENAS NOS CANAIS DA
 * CAIXA DIRECTA ONLINE
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho099a extends CgdGhBaseOnline<Pgho099a.EnvelopeIn, Pgho099a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0990
     */
    public abstract Bghm0990 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0991
     */
    public abstract Bghm0991 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0990.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0991.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Services
     */
    /**
     * @return instancia da classe Pgho097a
     */
    protected abstract Pgho097a hoPgho097a() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
    /**
     * @return instancia da classe Mhoj357a
     */
    @Data
    protected abstract Mhoj357a hrMhoj357a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mghs501a
     */
    @Data
    protected abstract Mghs501a hrMghs501a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bhol351a
     */
    @Data
    protected abstract Bhol351a bhol351a() ;
    
    /**
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
    protected IString wsCrtlContHo ;
    @Data
    @Condition("A")
    protected ICondition contaHo ;
    
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    
    
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
        wsCrtlContHo.initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        progOk.setTrue() ;
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
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().zValMov().isEmpty() || 
            msgIn().msg().ade().iDbcr().isEmpty() || 
            !msgIn().msg().ade().nDocOpps().isNumeric() || 
            !msgIn().msg().ade().tJuro().isNumeric() || 
            msgIn().msg().ade().cTrnzIput().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().cTrnzIput().isEqual("GHIB")) {
                msgIn().msg().ade().hstActivo().setTrue() ;
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
        if (msgIn().msg().ade().hstActivo().isTrue()) {
            a50000TratarHstActivo() ;
        } else {
            a60000TratarHstNaoActivo() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a50000TratarHstActivo() {
        /**
         * *----------------------------------------------------------------*
         */
        a51000ConsultaGatcnsmov() ;
        if (progOk.isTrue()) {
            if (hrMghs003a().bghl003a().zHoje().isEqual(msgIn().msg().ade().tsMovimento().get(1, 10))) {
                contaHo.setTrue() ;
                hrMhoj357a().bhol357a().commarea().initialize() ;
                hrMhoj357a().bhol357a().commarea().dadosInput().iMovDia().set("S");
                hrMhoj357a().bhol357a().commarea().dadosInput().iConsultas().set("A");
                a52000ObtemDadosHo() ;
            } else {
                hrMghs102a().bghl102a().initialize() ;
                hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
                a53000ObtemDadosHst() ;
                if (hrMghs102a().bghl102a().naoExiste().isTrue()) {
                    switch (hrMghs003a().bghl003a().detalhe().iEstRcrs().get()) {
                        case "I":
                            progNaoExisteMov.setTrue() ;
                            envOut.errosGraves().aAplErr().set(WS_APL_HST);
                            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                            break;
                        case "A":
                            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
                            a53000ObtemDadosHst() ;
                            break;
                        case "H":
                            hrMhoj357a().bhol357a().commarea().initialize() ;
                            hrMhoj357a().bhol357a().commarea().dadosInput().iMovDia().set("N");
                            hrMhoj357a().bhol357a().commarea().dadosInput().iConsultas().set("A");
                            contaHo.setTrue() ;
                            a52000ObtemDadosHo() ;
                            break;
                        default :
                            break ;
                    }
                }
            }
        }
        if (progOk.isTrue()) {
            if (!contaHo.isTrue()) {
                a55000ObtemDescSuporte() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ConsultaGatcnsmov() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set("TGH00022");
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set("I");
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00003");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000ObtemDadosHo() {
        /**
         * *----------------------------------------------------------------*
         */
        a52100PreencheAcessoHo() ;
        a52110AcedeHo() ;
        if (progOk.isTrue()) {
            a52120PreencheOutputHo() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52100PreencheAcessoHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj357a().bhol357a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj357a().bhol357a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a52110AcedeHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj357a().run() ;
        if (!hrMhoj357a().bhol357a().commarea().areaOutput().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj357a().bhol357a().commarea().areaOutput().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj357a().bhol357a().commarea().areaOutput().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj357a().bhol357a().commarea().areaOutput().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj357a().bhol357a().commarea().areaOutput().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj357a().bhol357a().commarea().areaOutput().dadosErro().aAplErr());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52120PreencheOutputHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().resetIndex() ;
        msgOut().msg().ade().cTipoCanlAces().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cTipoCanlAcesO());
        msgOut().msg().ade().cPaisIsoaOeOpx().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cPaisIsoaOeOpxO());
        msgOut().msg().ade().cMnemEgcOpex().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cMnemEgcOpexO());
        msgOut().msg().ade().cOeEgcOpex().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cOeEgcOpexO());
        msgOut().msg().ade().nmArqvOrig().set("HO");
        msgOut().msg().ade().aAplicacao().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).aAplicacaoO());
        msgOut().msg().ade().cOpczMenu().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cOpczMenuO());
        msgOut().msg().ade().cOpeBbn().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cOpeBbnO());
        msgOut().msg().ade().cEvenOpel().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cEvenOpelO());
        msgOut().msg().ade().cUserid().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).cUseridO());
        msgOut().msg().ade().tCambio().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).tCambioO());
        msgOut().msg().ade().mSldoRetd().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).mSldoRetdO());
        msgOut().msg().ade().mSldoVcob().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).mSldoVcobO());
        msgOut().msg().ade().mCmrgLim().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).mCmrgLimO());
        msgOut().msg().ade().mCmrgUtid().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).mCmrgUtidO());
        msgOut().msg().ade().mDcboNgcdAtrd().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).mDcboNgcdAtrdO());
        msgOut().msg().ade().mDcboNgcdUtid().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).mDcboNgcdUtidO());
        msgOut().msg().ade().iTipoSpte().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).iTipoSpteO());
        msgOut().msg().ade().dMovSpte().set(hrMhoj357a().bhol357a().commarea().areaOutput().tabMovimentos().get(1).dMovSpteO());
    }
    
    /**
     * 
     * 
     */
    protected void a53000ObtemDadosHst() {
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
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().cTipoCanlAces().set(hrMghs102a().bghl102a().detalhe().cTipoCanlAces());
            msgOut().msg().ade().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            msgOut().msg().ade().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            msgOut().msg().ade().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
            msgOut().msg().ade().nmArqvOrig().set(hrMghs102a().bghl102a().detalhe().nmArqvOrig());
            msgOut().msg().ade().cTransaccao().set(hrMghs102a().bghl102a().detalhe().cTransaccao());
            msgOut().msg().ade().aAplicacao().set(hrMghs102a().bghl102a().detalhe().aAplicacao());
            msgOut().msg().ade().cOpczMenu().set(hrMghs102a().bghl102a().detalhe().cOpczMenu());
            msgOut().msg().ade().cOpeBbn().set(hrMghs102a().bghl102a().detalhe().cOpeBbn());
            msgOut().msg().ade().cEvenOpel().set(hrMghs102a().bghl102a().detalhe().cEvenOpel());
            msgOut().msg().ade().cUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
            msgOut().msg().ade().tCambio().set(hrMghs102a().bghl102a().detalhe().tCambio());
            msgOut().msg().ade().mSldoRetd().set(hrMghs102a().bghl102a().detalhe().mSldoRetd());
            msgOut().msg().ade().mSldoVcob().set(hrMghs102a().bghl102a().detalhe().mSldoVcob());
            msgOut().msg().ade().mCmrgLim().set(hrMghs102a().bghl102a().detalhe().mCmrgLim());
            msgOut().msg().ade().mCmrgUtid().set(hrMghs102a().bghl102a().detalhe().mCmrgUtid());
            msgOut().msg().ade().mDcboNgcdAtrd().set(hrMghs102a().bghl102a().detalhe().mDcboNgcdAtrd());
            msgOut().msg().ade().mDcboNgcdUtid().set(hrMghs102a().bghl102a().detalhe().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000ObtemDescSuporte() {
        /**
         * *----------------------------------------------------------------*
         */
        hoPgho097a().msgIn().msg().ade().initialize() ;
        hoPgho097a().msgIn().msg().ade().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hoPgho097a().msgIn().msg().ade().cBancCont().set(msgIn().msg().ade().cBancCont());
        hoPgho097a().msgIn().msg().ade().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hoPgho097a().msgIn().msg().ade().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hoPgho097a().msgIn().msg().ade().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hoPgho097a().msgIn().msg().ade().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hoPgho097a().msgIn().msg().ade().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hoPgho097a().msgIn().msg().ade().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hoPgho097a().msgIn().msg().ade().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hoPgho097a().msgIn().msg().ade().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hoPgho097a().msgIn().msg().ade().zValMov().set(msgIn().msg().ade().zValMov());
        hoPgho097a().msgIn().msg().ade().iDbcr().set(msgIn().msg().ade().iDbcr());
        hoPgho097a().msgIn().msg().ade().iEstorno().set(msgIn().msg().ade().iEstorno());
        hoPgho097a().msgIn().msg().ade().nDocOpps().set(msgIn().msg().ade().nDocOpps());
        hoPgho097a().msgIn().msg().ade().xRefMov().set(msgIn().msg().ade().xRefMov());
        hoPgho097a().msgIn().msg().ade().tJuro().set(msgIn().msg().ade().tJuro());
        hoPgho097a().msgIn().msg().ade().aAplOrig().set(msgIn().msg().ade().aAplOrig());
        hoPgho097a().run() ;
        if (envOut.errosGraves().semErros().isTrue() || envOut.errosGraves().fimConsulta().isTrue()) {
            msgOut().msg().ade().iTipoSpte().set(hoPgho097a().msgOut().msg().ade().iTipoSpte());
            msgOut().msg().ade().dMovSpte().set(hoPgho097a().msgOut().msg().ade().dMovSpte());
        } else {
            msgOut().msg().ade().iTipoSpte().set(" ");
            msgOut().msg().ade().dMovSpte().set(" ");
            envOut.errosGraves().semErros().setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a60000TratarHstNaoActivo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs501a().bghl501a().initialize() ;
        hrMghs501a().bghl501a().criterioConsulta().crtOnde().setTrue() ;
        hrMghs501a().bghl501a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs501a().bghl501a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs501a().bghl501a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs501a().bghl501a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs501a().bghl501a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs501a().bghl501a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs501a().bghl501a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs501a().bghl501a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs501a().bghl501a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs501a().bghl501a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs501a().run() ;
        if (!hrMghs501a().bghl501a().ok().isTrue() && !hrMghs501a().bghl501a().naoExiste().isTrue()) {
            progDb2.setTrue() ;
            envOut.errosGraves().cTipoErroBbn().set(WS_ERRO);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs501a().bghl501a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00501");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().cTipoCanlAces().set(hrMghs501a().bghl501a().detalhe().cTipoCanlAces());
            msgOut().msg().ade().cPaisIsoaOeOpx().set(hrMghs501a().bghl501a().detalhe().cPaisIsoaOeOpx());
            msgOut().msg().ade().cMnemEgcOpex().set(hrMghs501a().bghl501a().detalhe().cMnemEgcOpex());
            msgOut().msg().ade().cOeEgcOpex().set(hrMghs501a().bghl501a().detalhe().cOeEgcOpex());
            msgOut().msg().ade().nmArqvOrig().set(hrMghs501a().bghl501a().detalhe().nmArqvOrig());
            msgOut().msg().ade().cTransaccao().set(hrMghs501a().bghl501a().detalhe().cTransaccao());
            msgOut().msg().ade().aAplicacao().set(hrMghs501a().bghl501a().detalhe().aAplicacao());
            msgOut().msg().ade().cOpczMenu().set(hrMghs501a().bghl501a().detalhe().cOpczMenu());
            msgOut().msg().ade().cOpeBbn().set(hrMghs501a().bghl501a().detalhe().cOpeBbn());
            msgOut().msg().ade().cEvenOpel().set(hrMghs501a().bghl501a().detalhe().cEvenOpel());
            msgOut().msg().ade().cUserid().set(hrMghs501a().bghl501a().detalhe().cUserid());
            msgOut().msg().ade().tCambio().set(hrMghs501a().bghl501a().detalhe().tCambio());
            msgOut().msg().ade().mSldoRetd().set(hrMghs501a().bghl501a().detalhe().mSldoRetd());
            msgOut().msg().ade().mSldoVcob().set(hrMghs501a().bghl501a().detalhe().mSldoVcob());
            msgOut().msg().ade().mCmrgLim().set(hrMghs501a().bghl501a().detalhe().mCmrgLim());
            msgOut().msg().ade().mCmrgUtid().set(hrMghs501a().bghl501a().detalhe().mCmrgUtid());
            msgOut().msg().ade().mDcboNgcdAtrd().set(hrMghs501a().bghl501a().detalhe().mDcboNgcdAtrd());
            msgOut().msg().ade().mDcboNgcdUtid().set(hrMghs501a().bghl501a().detalhe().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
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
}
