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
import cgd.gh.structures.messages.Bghm1050 ;
import cgd.gh.structures.messages.Bghm1051 ;
import cgd.ho.routines.Mhoj356a ;
import cgd.ho.routines.Mhoj353a ;
import cgd.gh.routines.Mghs102a ;
import cgd.hb.routines.Mhbj342a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO ADICIONAL ASSOCIADA AO
 * MOVIMENTO DE ENCARGOS - HB
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho105a extends CgdGhBaseOnline<Pgho105a.EnvelopeIn, Pgho105a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1050
     */
    public abstract Bghm1050 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1051
     */
    public abstract Bghm1051 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1050.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1051.Msg msgOut() ;
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
     * @return instancia da classe Mhoj353a
     */
    @Data
    protected abstract Mhoj353a hrMhoj353a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mhbj342a
     */
    @Data
    protected abstract Mhbj342a hrMhbj342a() ;
    
    
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
            msgIn().msg().ade().aAplOrig().isEmpty() || 
            msgIn().msg().ade().cTrnzIput().isEmpty()) {
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
            a52000AcedeHb() ;
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
        hrMhoj353a().bhol353a().commarea().initialize() ;
        hrMhoj356a().bhol356a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj353a().bhol353a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj356a().bhol356a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj356a().bhol356a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMhoj353a().bhol353a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMhoj356a().run() ;
        if (!hrMhoj356a().bhol356a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj356a().bhol356a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj356a().bhol356a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj356a().bhol356a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj356a().bhol356a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj356a().bhol356a().commarea().dadosErro().aAplErr());
        }
        if (progOk.isTrue()) {
            hrMhoj353a().run() ;
            if (!hrMhoj353a().bhol353a().commarea().dadosErro().semErros().isTrue()) {
                progStatus.set(hrMhoj353a().bhol353a().commarea().dadosErro().cRtnoEvenSwal());
                envOut.errosGraves().cTipoErroBbn().set(hrMhoj353a().bhol353a().commarea().dadosErro().cTipoErroBbn());
                envOut.db2Log().sqlca().cSqlcode().set(hrMhoj353a().bhol353a().commarea().dadosErro().cSqlcode());
                envOut.db2Log().nmTabela().set(hrMhoj353a().bhol353a().commarea().dadosErro().nmTabela());
                envOut.errosGraves().aAplErr().set(hrMhoj353a().bhol353a().commarea().dadosErro().aAplErr());
            }
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
            hrMghs102a().bghl102a().detalhe().cEvenOpel().set(hrMhoj353a().bhol353a().commarea().dadosOutput().cEvenOpel());
            hrMghs102a().bghl102a().detalhe().cOpeBbn().set(hrMhoj353a().bhol353a().commarea().dadosOutput().cOpeBbn());
            hrMghs102a().bghl102a().detalhe().cOpczMenu().set(hrMhoj353a().bhol353a().commarea().dadosOutput().cOpczMenu());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000AcedeHb() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhbj342a().bhbl342a().commarea().initialize() ;
        hrMhbj342a().bhbl342a().commarea().dadosInput().debugN().setTrue() ;
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().zProcessamento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().iDbcr().set(msgIn().msg().ade().iDbcr());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().nJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().cOpczMenu().set(hrMghs102a().bghl102a().detalhe().cOpczMenu());
        hrMhbj342a().bhbl342a().commarea().dadosInput().camposObrig().aAplicacao().set(msgIn().msg().ade().aAplOrig());
        hrMhbj342a().run() ;
        log(TraceLevel.Trace, "BHBL342A-C-RTNO-EVEN-SWAL-", hrMhbj342a().bhbl342a().commarea().dadosErro().cRtnoEvenSwal());
        log(TraceLevel.Trace, "BHBL342A-C-TIPO-ERRO-BBN -", hrMhbj342a().bhbl342a().commarea().dadosErro().cTipoErroBbn());
        log(TraceLevel.Trace, "BHBL342A-NM-TABELA-", hrMhbj342a().bhbl342a().commarea().dadosErro().nmTabela());
        if (!hrMhbj342a().bhbl342a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhbj342a().bhbl342a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhbj342a().bhbl342a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhbj342a().bhbl342a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhbj342a().bhbl342a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhbj342a().bhbl342a().commarea().dadosErro().aAplErr());
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().cFamiProd().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().cFamiProd());
            msgOut().msg().ade().cProduto().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().cProduto());
            msgOut().msg().ade().cEvenOpel().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().cEvenOpel());
            msgOut().msg().ade().cSeveOpel().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().cSeveOpel());
            msgOut().msg().ade().cMoedIso().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().cMoedIso());
            msgOut().msg().ade().nContribuinte().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().nContribuinte());
            msgOut().msg().ade().iTipoPagEncg().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().iTipoPagEncg());
            msgOut().msg().ade().tabelaEncargos().resetIndex() ;
            for (hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().setIndex(1); hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().index().isLessOrEqual(5); hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().incIndex()) {
                msgOut().msg().ade().tabelaEncargos().getCurrent().cTipoEncg().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cTipoEncg());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cEncargo().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cEncargo());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cMoeIsoPaisEcg().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cMoeIsoPaisEcg());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cOpeBbnEncg().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cOpeBbnEncg());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cOpeBbnEcgAnlz().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cOpeBbnEcgAnlz());
                msgOut().msg().ade().tabelaEncargos().getCurrent().mEncgStd().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().mEncgStd());
                msgOut().msg().ade().tabelaEncargos().getCurrent().mEncgNgcd().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().mEncgNgcd());
                msgOut().msg().ade().tabelaEncargos().getCurrent().mEncgIsenUtl().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().mEncgIsenUtl());
                msgOut().msg().ade().tabelaEncargos().getCurrent().mEncargo().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().mEncargo());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cImposto().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cImposto());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cMoedIsoImp().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cMoedIsoImp());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cOpeBbnImp().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cOpeBbnImp());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cOpeBbnImpAnlz().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cOpeBbnImpAnlz());
                msgOut().msg().ade().tabelaEncargos().getCurrent().mImposto().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().mImposto());
                msgOut().msg().ade().tabelaEncargos().getCurrent().tImposto().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().tImposto());
                msgOut().msg().ade().tabelaEncargos().getCurrent().tImpStd().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().tImpStd());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cOpeBbnIsezImp().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cOpeBbnIsezImp());
                msgOut().msg().ade().tabelaEncargos().getCurrent().cOpeBbnIseAnlz().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().cOpeBbnIseAnlz());
                msgOut().msg().ade().tabelaEncargos().getCurrent().mIsezImp().set(hrMhbj342a().bhbl342a().commarea().dadosOutput().tabelaEncargos().getCurrent().mIsezImp());
                msgOut().msg().ade().tabelaEncargos().incIndex() ;
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
