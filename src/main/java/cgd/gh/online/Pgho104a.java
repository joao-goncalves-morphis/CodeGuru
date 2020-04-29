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
import cgd.gh.structures.messages.Bghm1040 ;
import cgd.gh.structures.messages.Bghm1041 ;
import cgd.ho.routines.Mhoj356a ;
import cgd.ho.routines.Mhoj353a ;
import cgd.gh.routines.Mghs102a ;
import cgd.vm.routines.Mvmj070a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO ADICIONAL ASSOCIADA AO
 * MOVIMENTO DE ACTIVOS FINANCEIROS - VM
 * ALTERACAO     : INCLUSAO DO CAMPO I-EXIS-COTZ-ACTF
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho104a extends CgdGhBaseOnline<Pgho104a.EnvelopeIn, Pgho104a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1040
     */
    public abstract Bghm1040 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1041
     */
    public abstract Bghm1041 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1040.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1041.Msg msgOut() ;
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
     * @return instancia da classe Mvmj070a
     */
    @Data
    protected abstract Mvmj070a hrMvmj070a() ;
    
    
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
        log(TraceLevel.Debug, "-- S10000-INICIAR --");
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
        log(TraceLevel.Debug, "-- S30000-VALIDAR --");
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().nsMovimento().isEqual(0) || 
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
        log(TraceLevel.Debug, "-- S50000-PROCESSAR --");
        a51000ObtemChaveJourn() ;
        if (progOk.isTrue()) {
            a52000AcedeVm() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ObtemChaveJourn() {
        log(TraceLevel.Debug, "-- A51000-OBTEM-CHAVE-JOURN --");
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
        log(TraceLevel.Debug, "-- A52110-OBTEM-JOURN-HO --");
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
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000AcedeVm() {
        log(TraceLevel.Debug, "-- A52000-ACEDE-VM. --");
        hrMvmj070a().bvml070a().commarea().initialize() ;
        hrMvmj070a().bvml070a().commarea().input().cPaisIsoaCtaDo().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMvmj070a().bvml070a().commarea().input().cBancContDo().set(msgIn().msg().ade().cBancCont());
        hrMvmj070a().bvml070a().commarea().input().cOeEgcContDo().set(msgIn().msg().ade().cOeEgcCont());
        hrMvmj070a().bvml070a().commarea().input().nsRdclContDo().set(msgIn().msg().ade().nsRdclCont());
        hrMvmj070a().bvml070a().commarea().input().vChkdContDo().set(msgIn().msg().ade().vChkdCont());
        hrMvmj070a().bvml070a().commarea().input().cTipoContDo().set(msgIn().msg().ade().cTipoCont());
        hrMvmj070a().bvml070a().commarea().input().nsDepSctaDo().set(msgIn().msg().ade().nsDeposito());
        hrMvmj070a().bvml070a().commarea().input().cEvenOpel().set(hrMghs102a().bghl102a().detalhe().cEvenOpel());
        hrMvmj070a().bvml070a().commarea().input().cOpeBbn().set(hrMghs102a().bghl102a().detalhe().cOpeBbn());
        hrMvmj070a().bvml070a().commarea().input().nrElectronico().zProcessamento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        hrMvmj070a().bvml070a().commarea().input().nrElectronico().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
        hrMvmj070a().bvml070a().commarea().input().nrElectronico().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
        hrMvmj070a().bvml070a().commarea().input().nrElectronico().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        hrMvmj070a().bvml070a().commarea().input().nrElectronico().cUserid().set(hrMghs102a().bghl102a().detalhe().cUserid());
        hrMvmj070a().bvml070a().commarea().input().nrElectronico().nJourBbn().set(hrMghs102a().bghl102a().detalhe().nJourBbn());
        hrMvmj070a().bvml070a().commarea().input().nsJourBbn().set(hrMghs102a().bghl102a().detalhe().nsJourBbn());
        hrMvmj070a().bvml070a().commarea().input().aAplicacao().set(msgIn().msg().ade().aAplOrig());
        hrMvmj070a().run() ;
        log(TraceLevel.Debug, "-- ERRO --");
        log(TraceLevel.Debug, "BVML070A-C-RTNO-EVEN-SWAL-", hrMvmj070a().bvml070a().commarea().erros().cRtnoEvenSwal());
        log(TraceLevel.Debug, "BVML070A-C-TIPO-ERRO-BBN -", hrMvmj070a().bvml070a().commarea().erros().cTipoErroBbn());
        log(TraceLevel.Debug, "BVML070A-NM-TABELA-", hrMvmj070a().bvml070a().commarea().erros().nmTabela());
        log(TraceLevel.Debug, "-- OUTPUT --");
        log(TraceLevel.Debug, "BVML070A-NR-OPE-ACTF", hrMvmj070a().bvml070a().commarea().output().nrOpeActf());
        log(TraceLevel.Debug, "BVML070A-D-TIPO-MOV-DO", hrMvmj070a().bvml070a().commarea().output().dTipoMovDo());
        log(TraceLevel.Debug, "BVML070A-C-PAIS-ISA-CTA-ACF", hrMvmj070a().bvml070a().commarea().output().cPaisIsaCtaAcf());
        log(TraceLevel.Debug, "BVML070A-C-BANC-CONT-ACTF", hrMvmj070a().bvml070a().commarea().output().cBancContActf());
        log(TraceLevel.Debug, "BVML070A-C-OE-EGC-CONT-ACTF", hrMvmj070a().bvml070a().commarea().output().cOeEgcContActf());
        log(TraceLevel.Debug, "BVML070A-NS-RDCL-CONT-ACTF", hrMvmj070a().bvml070a().commarea().output().nsRdclContActf());
        log(TraceLevel.Debug, "BVML070A-V-CHKD-CONT-ACTF", hrMvmj070a().bvml070a().commarea().output().vChkdContActf());
        log(TraceLevel.Debug, "BVML070A-C-TIPO-CONT-ACTF", hrMvmj070a().bvml070a().commarea().output().cTipoContActf());
        log(TraceLevel.Debug, "BVML070A-NS-PRCL-CONT-ACTF", hrMvmj070a().bvml070a().commarea().output().nsPrclContActf());
        log(TraceLevel.Debug, "BVML070A-D-TIPO-OPE-ACTF", hrMvmj070a().bvml070a().commarea().output().dTipoOpeActf());
        log(TraceLevel.Debug, "BVML070A-NS-EVEN-ACTF", hrMvmj070a().bvml070a().commarea().output().nsEvenActf());
        log(TraceLevel.Debug, "BVML070A-D-TIPO-EVEN-ACTF", hrMvmj070a().bvml070a().commarea().output().dTipoEvenActf());
        log(TraceLevel.Debug, "BVML070A-C-ESPE-ACTF", hrMvmj070a().bvml070a().commarea().output().cEspeActf());
        log(TraceLevel.Debug, "BVML070A-D-LOCL-NGCZ", hrMvmj070a().bvml070a().commarea().output().dLoclNgcz());
        log(TraceLevel.Debug, "BVML070A-M-PRCO-ACTF-OBLS", hrMvmj070a().bvml070a().commarea().output().mPrcoActfObls());
        log(TraceLevel.Debug, "BVML070A-M-OPE-ACTF", hrMvmj070a().bvml070a().commarea().output().mOpeActf());
        log(TraceLevel.Debug, "BVML070A-I-EXIS-COTZ-ACTF", hrMvmj070a().bvml070a().commarea().output().iExisCotzActf());
        log(TraceLevel.Debug, "BVML070A-C-MOED-ISO", hrMvmj070a().bvml070a().commarea().output().cMoedIso());
        log(TraceLevel.Debug, "BVML070A-Z-OPERACAO", hrMvmj070a().bvml070a().commarea().output().zOperacao());
        log(TraceLevel.Debug, "BVML070A-Z-LIQZ-MONT-OBLS", hrMvmj070a().bvml070a().commarea().output().zLiqzMontObls());
        if (!hrMvmj070a().bvml070a().commarea().erros().semErros().isTrue() && !hrMvmj070a().bvml070a().commarea().erros().fimConsulta().isTrue()) {
            progStatus.set(hrMvmj070a().bvml070a().commarea().erros().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMvmj070a().bvml070a().commarea().erros().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMvmj070a().bvml070a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMvmj070a().bvml070a().commarea().erros().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMvmj070a().bvml070a().commarea().erros().aAplErr());
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().nrOpeActf().set(hrMvmj070a().bvml070a().commarea().output().nrOpeActf());
            msgOut().msg().ade().dTipoMovDo().set(hrMvmj070a().bvml070a().commarea().output().dTipoMovDo());
            msgOut().msg().ade().cPaisIsaCtaAcf().set(hrMvmj070a().bvml070a().commarea().output().cPaisIsaCtaAcf());
            msgOut().msg().ade().cBancContActf().set(hrMvmj070a().bvml070a().commarea().output().cBancContActf());
            msgOut().msg().ade().cOeEgcContActf().set(hrMvmj070a().bvml070a().commarea().output().cOeEgcContActf());
            msgOut().msg().ade().nsRdclContActf().set(hrMvmj070a().bvml070a().commarea().output().nsRdclContActf());
            msgOut().msg().ade().vChkdContActf().set(hrMvmj070a().bvml070a().commarea().output().vChkdContActf());
            msgOut().msg().ade().cTipoContActf().set(hrMvmj070a().bvml070a().commarea().output().cTipoContActf());
            msgOut().msg().ade().nsPrclContActf().set(hrMvmj070a().bvml070a().commarea().output().nsPrclContActf());
            msgOut().msg().ade().dTipoOpeActf().set(hrMvmj070a().bvml070a().commarea().output().dTipoOpeActf());
            msgOut().msg().ade().nsEvenActf().set(hrMvmj070a().bvml070a().commarea().output().nsEvenActf());
            msgOut().msg().ade().dTipoEvenActf().set(hrMvmj070a().bvml070a().commarea().output().dTipoEvenActf());
            msgOut().msg().ade().cEspeActf().set(hrMvmj070a().bvml070a().commarea().output().cEspeActf());
            msgOut().msg().ade().dLoclNgcz().set(hrMvmj070a().bvml070a().commarea().output().dLoclNgcz());
            msgOut().msg().ade().mPrcoActfObls().set(hrMvmj070a().bvml070a().commarea().output().mPrcoActfObls());
            msgOut().msg().ade().mOpeActf().set(hrMvmj070a().bvml070a().commarea().output().mOpeActf());
            msgOut().msg().ade().iExisCotzActf().set(hrMvmj070a().bvml070a().commarea().output().iExisCotzActf());
            msgOut().msg().ade().cMoedIso().set(hrMvmj070a().bvml070a().commarea().output().cMoedIso());
            msgOut().msg().ade().zOperacao().set(hrMvmj070a().bvml070a().commarea().output().zOperacao());
            msgOut().msg().ade().zLiqzMontObls().set(hrMvmj070a().bvml070a().commarea().output().zLiqzMontObls());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Responder() {
        log(TraceLevel.Debug, "-- S70000-RESPONDER --");
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
