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
import cgd.gh.structures.messages.Bghm0940 ;
import cgd.gh.structures.messages.Bghm0941 ;
import cgd.ho.routines.Mhoj354a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghs501a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA SALDOS COMPLEMENTARES DE UM DETERMI
 * NADO MOVIMENTO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho094a extends CgdGhBaseOnline<Pgho094a.EnvelopeIn, Pgho094a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0940
     */
    public abstract Bghm0940 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0941
     */
    public abstract Bghm0941 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0940.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0941.Msg msgOut() ;
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
     * @return instancia da classe Mhoj354a
     */
    @Data
    protected abstract Mhoj354a hrMhoj354a() ;
    
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
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
            msgIn().msg().ade().cTrnzIput().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().cTrnzIput().isEqual("GHIB")) {
                msgIn().msg().ade().hstActivo().setTrue() ;
            }
            if (!msgIn().msg().ade().hstActivo().isTrue() && !msgIn().msg().ade().hstNaoActivo().isTrue()) {
                progDadosInvalidos.setTrue() ;
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
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
                            /**
                             * MOVIMENTOS DO DIA D -1 ESTAO NA NA APLICACAO HO     -*
                             */
                            a54000ObtemDadosHoOntem() ;
                            break;
                        default :
                            break ;
                    }
                }
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
        a52500PreencheA354() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj354a().run() ;
        if (!hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
        }
        /**
         * --> ACESSO AO MHOJ354A
         */
        if (progOk.isTrue()) {
            msgOut().msg().ade().mSldoRetd().set(hrMhoj354a().bhol354a().commarea().areaOutput().mSldoRetd());
            msgOut().msg().ade().mSldoVcob().set(hrMhoj354a().bhol354a().commarea().areaOutput().mSldoVcob());
            msgOut().msg().ade().mCmrgLim().set(hrMhoj354a().bhol354a().commarea().areaOutput().mCmrgLim());
            msgOut().msg().ade().mCmrgUtid().set(hrMhoj354a().bhol354a().commarea().areaOutput().mCmrgUtid());
            msgOut().msg().ade().mDcboNgcdAtrd().set(hrMhoj354a().bhol354a().commarea().areaOutput().mDcboNgcdAtrd());
            msgOut().msg().ade().mDcboNgcdUtid().set(hrMhoj354a().bhol354a().commarea().areaOutput().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52500PreencheA354() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj354a().bhol354a().commarea().initialize() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj354a().bhol354a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a53000ObtemDadosHst() {
        hrMghs102a().bghl102a().criterioConsulta().crtSaldos().setTrue() ;
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
    protected void a54000ObtemDadosHoOntem() {
        /**
         * *----------------------------------------------------------------*
         */
        a52500PreencheA354() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set("N");
        hrMhoj354a().run() ;
        if (!hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
        }
        /**
         * --> ACESSO AO MHOJ354A
         */
        if (progOk.isTrue()) {
            msgOut().msg().ade().mSldoRetd().set(hrMhoj354a().bhol354a().commarea().areaOutput().mSldoRetd());
            msgOut().msg().ade().mSldoVcob().set(hrMhoj354a().bhol354a().commarea().areaOutput().mSldoVcob());
            msgOut().msg().ade().mCmrgLim().set(hrMhoj354a().bhol354a().commarea().areaOutput().mCmrgLim());
            msgOut().msg().ade().mCmrgUtid().set(hrMhoj354a().bhol354a().commarea().areaOutput().mCmrgUtid());
            msgOut().msg().ade().mDcboNgcdAtrd().set(hrMhoj354a().bhol354a().commarea().areaOutput().mDcboNgcdAtrd());
            msgOut().msg().ade().mDcboNgcdUtid().set(hrMhoj354a().bhol354a().commarea().areaOutput().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a60000TratarHstNaoActivo() {
        hrMghs501a().bghl501a().criterioConsulta().crtSaldos().setTrue() ;
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
