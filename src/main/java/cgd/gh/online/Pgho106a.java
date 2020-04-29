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
import cgd.framework.envelope.CgdHeaderV2 ;
import cgd.framework.envelope.CgdMessageV2 ;
import cgd.framework.envelope.CgdFooterV2 ;
import cgd.gh.structures.messages.Bghm1060 ;
import cgd.gh.structures.messages.Bghm1061 ;
import cgd.pu.routines.Mpuj008a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA INFORMACAO ADICIONAL ASSOCIADA AO
 * ORDENS EMITIDAS - PU
 * ALTERACAO     : GH1174
 * REMOCAO DA VALIDACAO O DO CAMPO X-REF-MOV
 * INCLUSAO DE CAMPOS NO ACESSO A MPUJ008A
 * ACT0677 VALERIO SILVA
 * ALTERACAO     : GH1967
 * INCLUSÃO DO CAMPO X-NOME-ORDN NO ACESSO
 * A MPUJ008A. MIGRACAO PARA BHTL010A.
 * E001881
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho106a extends CgdGhBaseOnline<Pgho106a.EnvelopeIn, Pgho106a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1060
     */
    public abstract Bghm1060 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1061
     */
    public abstract Bghm1061 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm1060.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm1061.Msg msgOut() ;
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
     * @return instancia da classe Mpuj008a
     */
    @Data
    protected abstract Mpuj008a hrMpuj008a() ;
    
    
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
    protected IInt wsIndice ;
    
    @Data(size=2, value="0")
    protected IInt wsIndex ;
    
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
     * *GH1174-I
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
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
        /**
         * MOVE BHTL001A-X-MSG-BBN     OF BHTL001A-COMMAREA
         * MOVE BHTL010A-X-MSG-BBN-IPUT OF BHTL010A-COMMAREA
         */
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        log(TraceLevel.Trace, "BGHM1060-C-PAIS-ISOA-CONT:", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Trace, "BGHM1060-C-BANC-CONT     :", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Trace, "BGHM1060-C-OE-EGC-CONT   :", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Trace, "BGHM1060-NS-RDCL-CONT    :", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Trace, "BGHM1060-V-CHKD-CONT     :", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Trace, "BGHM1060-C-TIPO-CONT     :", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Trace, "BGHM1060-C-MOED-ISO-SCTA :", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Trace, "BGHM1060-NS-DEPOSITO     :", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Trace, "BGHM1060-TS-MOVIMENTO    :", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Trace, "BGHM1060-NS-MOVIMENTO    :", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Trace, "BGHM1060-A-APL-ORIG      :", msgIn().msg().ade().aAplOrig());
        log(TraceLevel.Trace, "BGHM1060-X-REF-MOV       :", msgIn().msg().ade().xRefMov());
        log(TraceLevel.Trace, "BGHM1060-C-TRNZ-IPUT    :", msgIn().msg().ade().cTrnzIput());
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
            /**
             * MOVE WS-APL-HST          TO BHTL001A-A-APL-ERR
             * MOVE WS-ERR-FUNC         TO BHTL001A-C-TIPO-ERRO-BBN
             */
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
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
         * *GH1174-I
         */
        hrMpuj008a().bpul008a().commarea().initialize() ;
        wsVariaveis().initialize() ;
        /**
         * *GH1174-F
         */
        hrMpuj008a().bpul008a().commarea().dadosInput().cPaisIsoAlfn().set(msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Trace, "BPUL008A-C-PAIS-ISO-ALFN-", hrMpuj008a().bpul008a().commarea().dadosInput().cPaisIsoAlfn());
        hrMpuj008a().bpul008a().commarea().dadosInput().cRefMsgSwif().set(msgIn().msg().ade().xRefMov());
        log(TraceLevel.Trace, "BPUL008A-C-REF-MSG-SWIF-", hrMpuj008a().bpul008a().commarea().dadosInput().cRefMsgSwif());
        hrMpuj008a().bpul008a().commarea().dadosInput().cBancCont().set(msgIn().msg().ade().cBancCont());
        log(TraceLevel.Trace, "BPUL008A-C-BANC-CONT-", hrMpuj008a().bpul008a().commarea().dadosInput().cBancCont());
        hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Trace, "BPUL008A-C-OE-EGC-CONT-", hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().cOeEgcCont());
        hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Trace, "BPUL008A-NS-RDCL-CONT-", hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().nsRdclCont());
        hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Trace, "BPUL008A-V-CHKD-CONT-", hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().vChkdCont());
        hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Trace, "BPUL008A-C-TIPO-CONT-", hrMpuj008a().bpul008a().commarea().dadosInput().xNumConta().cTipoCont());
        /**
         * *GH1174-I
         */
        hrMpuj008a().bpul008a().commarea().dadosInput().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Trace, "BPUL008A-C-MOED-ISO-SCTA", hrMpuj008a().bpul008a().commarea().dadosInput().cMoedIsoScta());
        hrMpuj008a().bpul008a().commarea().dadosInput().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Trace, "BPUL008A-NS-DEPOSITO ", hrMpuj008a().bpul008a().commarea().dadosInput().nsDeposito());
        hrMpuj008a().bpul008a().commarea().dadosInput().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Trace, "BPUL008A-TS-MOVIMENTO ", hrMpuj008a().bpul008a().commarea().dadosInput().tsMovimento());
        hrMpuj008a().bpul008a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Trace, "BGHM1060-NS-MOVIMENTO ", msgIn().msg().ade().nsMovimento());
        /**
         * *GH1174-F
         */
        hrMpuj008a().run() ;
        log(TraceLevel.Trace, "BPUL008A-C-RTNO-EVEN-SWAL-", hrMpuj008a().bpul008a().commarea().areaOutput().cRtnoEvenSwal());
        log(TraceLevel.Trace, "BPUL008A-C-TIPO-ERRO-BBN -", hrMpuj008a().bpul008a().commarea().areaOutput().cTipoErroBbn());
        log(TraceLevel.Trace, "BPUL008A-NM-TABELA-", hrMpuj008a().bpul008a().commarea().areaOutput().nmTabela());
        if (!hrMpuj008a().bpul008a().commarea().areaOutput().semErros().isTrue()) {
            progStatus.set(hrMpuj008a().bpul008a().commarea().areaOutput().cRtnoEvenSwal());
            /**
             * TO BHTL001A-C-TIPO-ERRO-BBN
             * MOVE BPUL008A-C-SQLCODE TO BHTL001A-C-SQLCODE
             * MOVE BPUL008A-NM-TABELA TO BHTL001A-NM-TABELA
             * MOVE BPUL008A-A-APL-ERR TO BHTL001A-A-APL-ERR
             */
            messageV2.mensagem().cTipoErroBbn().set(hrMpuj008a().bpul008a().commarea().areaOutput().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMpuj008a().bpul008a().commarea().areaOutput().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMpuj008a().bpul008a().commarea().areaOutput().nmTabela());
            messageV2.mensagem().aAplErro().set(hrMpuj008a().bpul008a().commarea().areaOutput().aAplErr());
        }
        if (progOk.isTrue()) {
            /**
             * *GH1174-I
             * MOVE BPUL008A-C-OE-EGC-CNT-ORD
             * TO BGHM1061-C-OE-EGC-CNT-ORD
             * MOVE BPUL008A-NS-RDCL-CNT-ORD
             * TO BGHM1061-NS-RDCL-CNT-ORD
             * MOVE BPUL008A-V-CHKD-CNT-ORD
             * TO BGHM1061-V-CHKD-CNT-ORD
             * MOVE BPUL008A-C-TIPO-CNT-ORD
             * TO BGHM1061-C-TIPO-CNT-ORD
             * *DESCOMPACTACAO
             */
            wsVariaveis().wsCOeEgcCntOrd().set(hrMpuj008a().bpul008a().commarea().areaOutput().xInfOrdnLn01().cOeEgcCntOrd());
            msgOut().msg().ade().xInfOrdnLn01().cOeEgcCntOrd().set(wsVariaveis().wsCOeEgcCntOrd());
            wsVariaveis().wsNsRdclCntOrd().set(hrMpuj008a().bpul008a().commarea().areaOutput().xInfOrdnLn01().nsRdclCntOrd());
            msgOut().msg().ade().xInfOrdnLn01().nsRdclCntOrd().set(wsVariaveis().wsNsRdclCntOrd());
            wsVariaveis().wsVChkdCntOrd().set(hrMpuj008a().bpul008a().commarea().areaOutput().xInfOrdnLn01().vChkdCntOrd());
            msgOut().msg().ade().xInfOrdnLn01().vChkdCntOrd().set(wsVariaveis().wsVChkdCntOrd());
            wsVariaveis().wsCTipoCntOrd().set(hrMpuj008a().bpul008a().commarea().areaOutput().xInfOrdnLn01().cTipoCntOrd());
            msgOut().msg().ade().xInfOrdnLn01().cTipoCntOrd().set(wsVariaveis().wsCTipoCntOrd());
            /**
             * *GH1174-F
             */
            wsVariaveis().wsXNomeOrdn().set(hrMpuj008a().bpul008a().commarea().areaOutput().xNomeOrdn());
            msgOut().msg().ade().xNomeOrdn().set(wsVariaveis().wsXNomeOrdn());
            log(TraceLevel.Error, "BGHM1061-X-NOME-ORDN:", msgOut().msg().ade().xNomeOrdn());
            msgOut().msg().ade().cMoedIsoOrig().set(hrMpuj008a().bpul008a().commarea().areaOutput().cMoedIsoOrig());
            msgOut().msg().ade().xInfBeneLn01().set(hrMpuj008a().bpul008a().commarea().areaOutput().xInfBeneLn01());
            msgOut().msg().ade().xNomeBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xNomeBene());
            msgOut().msg().ade().xMoradaBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xMoradaBene());
            msgOut().msg().ade().xCodPostalBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xCodPostalBene());
            msgOut().msg().ade().xCidadeBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xCidadeBene());
            msgOut().msg().ade().xPaisBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xPaisBene());
            msgOut().msg().ade().cEndSwf().set(hrMpuj008a().bpul008a().commarea().areaOutput().cEndSwf());
            msgOut().msg().ade().xNomeBcoBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xNomeBcoBene());
            msgOut().msg().ade().xMoradaBcoBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xMoradaBcoBene());
            msgOut().msg().ade().xCodPostalBcoBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xCodPostalBcoBene());
            msgOut().msg().ade().xCidadeBcoBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xCidadeBcoBene());
            msgOut().msg().ade().xPaisBcoBene().set(hrMpuj008a().bpul008a().commarea().areaOutput().xPaisBcoBene());
            msgOut().msg().ade().cTipoClrg().set(hrMpuj008a().bpul008a().commarea().areaOutput().cTipoClrg());
            msgOut().msg().ade().cClearing().set(hrMpuj008a().bpul008a().commarea().areaOutput().cClearing());
            msgOut().msg().ade().cTipoClrg().set(hrMpuj008a().bpul008a().commarea().areaOutput().cTipoClrg());
            msgOut().msg().ade().cClearing().set(hrMpuj008a().bpul008a().commarea().areaOutput().cClearing());
            msgOut().msg().ade().cMoedIso().set(hrMpuj008a().bpul008a().commarea().areaOutput().cMoedIso());
            msgOut().msg().ade().mMsgSwif().set(hrMpuj008a().bpul008a().commarea().areaOutput().mMsgSwif());
            msgOut().msg().ade().cMoedIsoOrigT().set(hrMpuj008a().bpul008a().commarea().areaOutput().cMoedIsoOrigT());
            msgOut().msg().ade().mMsgSwifMoeOri().set(hrMpuj008a().bpul008a().commarea().areaOutput().mMsgSwifMoeOri());
            msgOut().msg().ade().nAtrzCamb().set(hrMpuj008a().bpul008a().commarea().areaOutput().nAtrzCamb());
            msgOut().msg().ade().tCambio().set(hrMpuj008a().bpul008a().commarea().areaOutput().tCambio());
            msgOut().msg().ade().zValMsgSwif().set(hrMpuj008a().bpul008a().commarea().areaOutput().zValMsgSwif());
            msgOut().msg().ade().iOpagUrgt().set(hrMpuj008a().bpul008a().commarea().areaOutput().iOpagUrgt());
            msgOut().msg().ade().cTipLqzPagItrl().set(hrMpuj008a().bpul008a().commarea().areaOutput().cTipLqzPagItrl());
            msgOut().msg().ade().cTipoOpetBpor().set(hrMpuj008a().bpul008a().commarea().areaOutput().cTipoOpetBpor());
            msgOut().msg().ade().cDtlhEncgSwif().set(hrMpuj008a().bpul008a().commarea().areaOutput().cDtlhEncgSwif());
            msgOut().msg().ade().xDetPag1().set(hrMpuj008a().bpul008a().commarea().areaOutput().xDetPag1());
            msgOut().msg().ade().xDetPag2().set(hrMpuj008a().bpul008a().commarea().areaOutput().xDetPag2());
            msgOut().msg().ade().xDetPag3().set(hrMpuj008a().bpul008a().commarea().areaOutput().xDetPag3());
            msgOut().msg().ade().xDetPag4().set(hrMpuj008a().bpul008a().commarea().areaOutput().xDetPag4());
            msgOut().msg().ade().xInfPag1().set(hrMpuj008a().bpul008a().commarea().areaOutput().xInfPag1());
            msgOut().msg().ade().xInfPag2().set(hrMpuj008a().bpul008a().commarea().areaOutput().xInfPag2());
            msgOut().msg().ade().iAcdoLvp().set(hrMpuj008a().bpul008a().commarea().areaOutput().iAcdoLvp());
            /**
             * *GH1174-I
             * MOVE BPUL008A-C-OE-EGC-CNT-ECG
             * TO BGHM1061-C-OE-EGC-CNT-ECG
             * MOVE BPUL008A-NS-RDCL-CNT-ECG
             * TO BGHM1061-NS-RDCL-CNT-ECG
             * MOVE BPUL008A-V-CHKD-CNT-ECG
             * TO BGHM1061-V-CHKD-CNT-ECG
             * MOVE BPUL008A-C-TIPO-CNT-ECG
             * TO BGHM1061-C-TIPO-CNT-ECG
             * *DESCOMPACTACAO
             */
            wsVariaveis().wsCOeEgcCntEcg().set(hrMpuj008a().bpul008a().commarea().areaOutput().xIdContLiqzEcg().cOeEgcCntEcg());
            msgOut().msg().ade().xIdContLiqzEcg().cOeEgcCntEcg().set(wsVariaveis().wsCOeEgcCntEcg());
            wsVariaveis().wsNsRdclCntEcg().set(hrMpuj008a().bpul008a().commarea().areaOutput().xIdContLiqzEcg().nsRdclCntEcg());
            msgOut().msg().ade().xIdContLiqzEcg().nsRdclCntEcg().set(wsVariaveis().wsNsRdclCntEcg());
            wsVariaveis().wsVChkdCntEcg().set(hrMpuj008a().bpul008a().commarea().areaOutput().xIdContLiqzEcg().vChkdCntEcg());
            msgOut().msg().ade().xIdContLiqzEcg().vChkdCntEcg().set(wsVariaveis().wsVChkdCntEcg());
            wsVariaveis().wsCTipoCntEcg().set(hrMpuj008a().bpul008a().commarea().areaOutput().xIdContLiqzEcg().cTipoCntEcg());
            msgOut().msg().ade().xIdContLiqzEcg().cTipoCntEcg().set(wsVariaveis().wsCTipoCntEcg());
            /**
             * *GH1174-F
             */
            msgOut().msg().ade().mEncgOrdnSwif().set(hrMpuj008a().bpul008a().commarea().areaOutput().mEncgOrdnSwif());
            wsIndice.set(1);
            wsIndex.set(1);
            for (wsIndex.set(1); wsIndex.isLessOrEqual(10) && progStatus.isLessOrEqual(0); wsIndex.add(1)) {
                msgOut().msg().ade().tabIncEncg().get(wsIndice).cTipoEncg().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).cTipoEncg());
                msgOut().msg().ade().tabIncEncg().get(wsIndice).cEncargo().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).cEncg());
                msgOut().msg().ade().tabIncEncg().get(wsIndice).mEncargo().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).mEncg());
                msgOut().msg().ade().tabIncEncg().get(wsIndice).cMoedEncg().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).cMoedEncg());
                msgOut().msg().ade().tabIncEncg().get(wsIndice).cTipoImp().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).cTipoImp());
                msgOut().msg().ade().tabIncEncg().get(wsIndice).cImposto().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).cImp());
                msgOut().msg().ade().tabIncEncg().get(wsIndice).mImposto().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).mImp());
                msgOut().msg().ade().tabIncEncg().get(wsIndice).cMoedIsoImp().set(hrMpuj008a().bpul008a().commarea().areaOutput().tabIncEncg().get(wsIndex).cMoedImp());
                wsIndice.add(1);
            }
            msgOut().msg().ade().cMtvDvzCpltOpg().set(hrMpuj008a().bpul008a().commarea().areaOutput().cMtvDvzCpltOpg());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Responder() {
        /**
         * *----------------------------------------------------------------*
         * IF BHTL001A-SEM-ERROS OR BHTL001A-FIM-CONSULTA
         */
        if (!messageV2.mensagem().semErros().isTrue() && !messageV2.mensagem().fimConsulta().isTrue()) {
            progNaoExisteInfAdic.setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            /**
             * MOVE PROG-STATUS         TO BHTL001A-C-RTNO-EVEN-SWAL
             */
            messageV2.mensagem().cRtnoSwal().set(progStatus);
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(progStatus);
            /**
             * MOVE WS-ERR-FUNC         TO BHTL001A-C-TIPO-ERRO-BBN
             */
            messageV2.mensagem().cTipoErroBbn().set(WS_ERR_FUNC);
            /**
             * MOVE WS-APL-HST          TO BHTL001A-A-APL-ERR
             */
            messageV2.mensagem().aAplErro().set(WS_APL_HST);
        }
        /**
         * MOVE BGHM1061-MSG           TO BHTL001A-X-MSG-BBN
         */
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        /**
         * TO BHTL001A-Q-CAMP-EST-TRNZ
         */
        messageV2.mensagem().campoLivre11().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        /**
         * TO BHTL001A-Q-CTER-CMPT-ALIG
         */
        messageV2.mensagem().qCterCmpMsgInp().set(msgOut().qCterCmptAlig());
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
    
    /**
     * 
     * *GH1174-I
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=4)
        IInt wsCOeEgcCntOrd() ;
        
        @Data(size=7)
        IInt wsNsRdclCntOrd() ;
        
        @Data(size=1)
        IInt wsVChkdCntOrd() ;
        
        @Data(size=3)
        IInt wsCTipoCntOrd() ;
        
        @Data(size=35)
        IString wsXNomeOrdn() ;
        
        @Data(size=4)
        IInt wsCOeEgcCntEcg() ;
        
        @Data(size=7)
        IInt wsNsRdclCntEcg() ;
        
        @Data(size=1)
        IInt wsVChkdCntEcg() ;
        
        @Data(size=3)
        IInt wsCTipoCntEcg() ;
        
    }
    
}
