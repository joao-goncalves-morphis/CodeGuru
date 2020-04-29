package cgd.gh.online;

import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
import cgd.gh.structures.messages.Bghm1020 ;
import cgd.gh.structures.messages.Bghm1021 ;
import cgd.ho.routines.Mhoj356a ;
import cgd.gh.routines.Mghs102a ;
import cgd.ho.routines.Mhoj358a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO ADICIONAL ASSOCIADA AO
 * MOVIMENTO DE JUROS DA APLICACAO HO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho102a extends CgdGhBaseOnline<Pgho102a.EnvelopeIn, Pgho102a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1020
     */
    public abstract Bghm1020 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1021
     */
    public abstract Bghm1021 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1020.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1021.Msg msgOut() ;
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
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mhoj358a
     */
    @Data
    protected abstract Mhoj358a hrMhoj358a() ;
    
    
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
    
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    @Data(size=2, value="0")
    protected IInt wIndice ;
    
    /**
     * @return instancia da classe local WsDataToday
     */
    @Data
    protected abstract WsDataToday wsDataToday() ;
    
    /**
     * @return instancia da classe local WsDataDia
     */
    @Data
    protected abstract WsDataDia wsDataDia() ;
    
    
    
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
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().nsMovimento().isEqual(0) || 
            msgIn().msg().ade().cTrnzIput().isZeros() || 
            msgIn().msg().ade().mMovimento().isEqual(0) || 
            msgIn().msg().ade().xRefMov().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            wsDataToday().set(getTimeAsLong());
            wsDataDia().wAnoData().set(wsDataToday().wsAnoToday());
            wsDataDia().wMesData().set(wsDataToday().wsMesToday());
            wsDataDia().wDiaData().set(wsDataToday().wsDiaToday());
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
        a51000ObtemChaveJourn() ;
        if (progOk.isTrue()) {
            a52000AcedeHo() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ObtemChaveJourn() {
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
            if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(wsDataDia())) {
                a52110ObtemJournHo() ;
            } else {
                progNaoExisteMov.setTrue() ;
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
                envOut.db2Log().nmTabela().set("TGH00102");
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
            }
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
    protected void a52000AcedeHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj358a().bhol358a().commarea().initialize() ;
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj358a().bhol358a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj358a().bhol358a().commarea().dadosInput().mMovimento().set(msgIn().msg().ade().mMovimento());
        hrMhoj358a().bhol358a().commarea().dadosInput().xRefMov().set(msgIn().msg().ade().xRefMov());
        hrMhoj358a().bhol358a().commarea().dadosInput().cIdioIso().set("POR");
        hrMhoj358a().bhol358a().commarea().dadosInput().zProcessamento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        hrMhoj358a().bhol358a().commarea().dadosInput().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
        hrMhoj358a().bhol358a().commarea().dadosInput().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
        hrMhoj358a().bhol358a().commarea().dadosInput().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        hrMhoj358a().bhol358a().commarea().dadosInput().cUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
        hrMhoj358a().bhol358a().commarea().dadosInput().nJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
        hrMhoj358a().run() ;
        if (!hrMhoj358a().bhol358a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj358a().bhol358a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj358a().bhol358a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj358a().bhol358a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj358a().bhol358a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj358a().bhol358a().commarea().dadosErro().aAplErr());
        }
        log(TraceLevel.Trace, "BHTL001A-C-TIPO-ERRO-BBN-", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Trace, "BHTL001A-C-RTNO-EVEN-SWAL-", envOut.errosGraves().cRtnoEvenSwal());
        if (progOk.isTrue()) {
            msgOut().msg().ade().cPaisIsoaJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().cPaisIsoaContO());
            msgOut().msg().ade().cBancContJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().cBancContO());
            msgOut().msg().ade().cOeEgcContJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().cOeEgcContO());
            msgOut().msg().ade().nsRdclContJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().nsRdclContO());
            msgOut().msg().ade().vChkdContJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().vChkdContO());
            msgOut().msg().ade().cTipoContJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().cTipoContO());
            msgOut().msg().ade().cMoedIsoSctaJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().cMoedIsoSctaO());
            msgOut().msg().ade().nsDepositoJur().set(hrMhoj358a().bhol358a().commarea().dadosOutput().subcontaOut().nsDepositoO());
            msgOut().msg().ade().nsCmrg().set(hrMhoj358a().bhol358a().commarea().dadosOutput().nsCmrg());
            msgOut().msg().ade().nsSdep().set(hrMhoj358a().bhol358a().commarea().dadosOutput().nsSdep());
            msgOut().msg().ade().cTipoJuro().set(hrMhoj358a().bhol358a().commarea().dadosOutput().cTipoJuro());
            msgOut().msg().ade().zFimPerCalc().set(hrMhoj358a().bhol358a().commarea().dadosOutput().zFimPerCalc());
            msgOut().msg().ade().zInicPerCalc().set(hrMhoj358a().bhol358a().commarea().dadosOutput().zInicPerCalc());
            msgOut().msg().ade().mJuro().set(hrMhoj358a().bhol358a().commarea().dadosOutput().mJuro());
            msgOut().msg().ade().mImposto().set(hrMhoj358a().bhol358a().commarea().dadosOutput().mImposto());
            msgOut().msg().ade().mIsezImp().set(hrMhoj358a().bhol358a().commarea().dadosOutput().mIsezImp());
            msgOut().msg().ade().mJmorPago().set(hrMhoj358a().bhol358a().commarea().dadosOutput().mJmorPago());
            msgOut().msg().ade().mImpJmorPago().set(hrMhoj358a().bhol358a().commarea().dadosOutput().mImpJmorPago());
            msgOut().msg().ade().mMovCtrvEuro().set(hrMhoj358a().bhol358a().commarea().dadosOutput().mMovCtrvEuro());
            msgOut().msg().ade().tCambEuro().set(hrMhoj358a().bhol358a().commarea().dadosOutput().tCambEuro());
            if (!hrMhoj358a().bhol358a().commarea().dadosOutput().tCambEuro().isEqual(1.000000)) {
                msgOut().msg().ade().tCambEuro().set(hrMhoj358a().bhol358a().commarea().dadosOutput().tCambEuro());
                if (hrMhoj358a().bhol358a().commarea().dadosOutput().mMovCtrvEuro().isEqual(0)) {
                    msgOut().msg().ade().mMovCtrvEuro().set(multiply(hrMhoj358a().bhol358a().commarea().dadosOutput().mJuro(), hrMhoj358a().bhol358a().commarea().dadosOutput().tCambEuro()));
                }
            } else {
                msgOut().msg().ade().tCambEuro().set(0);
            }
            if (hrMhoj358a().bhol358a().commarea().dadosOutput().cProdCmrg().isEmpty()) {
                msgOut().msg().ade().cFamiProd().set(hrMhoj358a().bhol358a().commarea().dadosOutput().cFamiProdJur());
                msgOut().msg().ade().cProduto().set(hrMhoj358a().bhol358a().commarea().dadosOutput().cProdJur());
                msgOut().msg().ade().dCodAbvdProd().set(hrMhoj358a().bhol358a().commarea().dadosOutput().dCodAbvdProdJur());
            } else {
                msgOut().msg().ade().cFamiProd().set(hrMhoj358a().bhol358a().commarea().dadosOutput().cFamiProdCmrg());
                msgOut().msg().ade().cProduto().set(hrMhoj358a().bhol358a().commarea().dadosOutput().cProdJur());
                msgOut().msg().ade().dCodAbvdProd().set(hrMhoj358a().bhol358a().commarea().dadosOutput().dCodAbvdProdCmr());
            }
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
        if (!envOut.errosGraves().semErros().isTrue() && !envOut.errosGraves().fimConsulta().isTrue()) {
            progNaoExisteInfAdic.setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(progStatus);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
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
    public interface WsDataToday extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoToday() ;
        
        @Data(size=2)
        IInt wsMesToday() ;
        
        @Data(size=2)
        IInt wsDiaToday() ;
        
    }
    public interface WsDataDia extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesData() ;
        
        @Data(size=2, lpadding=1, rpadding=1, lpaddingValue="-", rpaddingValue="-")
        IInt wDiaData() ;
        
    }
    
}
