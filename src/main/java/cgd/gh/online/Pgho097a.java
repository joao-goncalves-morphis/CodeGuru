package cgd.gh.online;

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
import cgd.gh.structures.messages.Bghm0970 ;
import cgd.gh.structures.messages.Bghm0971 ;
import cgd.ho.routines.Mhoj352a ;
import cgd.ho.routines.Mhoj353a ;
import cgd.gh.routines.Mghs801a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghs102a ;
import cgd.ho.routines.Mhoj727a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA DESCRITIVO DO SUPORTE
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho097a extends CgdGhBaseOnline<Pgho097a.EnvelopeIn, Pgho097a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0970
     */
    public abstract Bghm0970 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0971
     */
    public abstract Bghm0971 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0970.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0971.Msg msgOut() ;
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
     * @return instancia da classe Mhoj352a
     */
    @Data
    protected abstract Mhoj352a hrMhoj352a() ;
    
    /**
     * @return instancia da classe Mhoj353a
     */
    @Data
    protected abstract Mhoj353a hrMhoj353a() ;
    
    /**
     * @return instancia da classe Mghs801a
     */
    @Data
    protected abstract Mghs801a hrMghs801a() ;
    
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
     * @return instancia da classe Mhoj727a
     */
    @Data
    protected abstract Mhoj727a hrMhoj727a() ;
    
    
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
    
    
    @Data(size=25)
    protected IString wsDescCad ;
    
    @Data(size=5, decimal=3)
    protected IDecimal wsTJuro ;
    
    /**
     * @return instancia da classe local WsTJuroMask
     */
    @Data
    @Mask
    protected abstract WsTJuroMask wsTJuroMask() ;
    
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
            msgIn().msg().ade().zValMov().isEmpty() || 
            msgIn().msg().ade().iDbcr().isEmpty() || 
            msgIn().msg().ade().aAplOrig().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            wsDescCad.set(" ");
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
        a51000ConsultaScta() ;
        if (progOk.isTrue()) {
            if (hrMghs801a().bghl801a().detalhe().iTipoSpteExt().isTrue()) {
                a52000ObtemDescritivoExt() ;
            } else if (hrMghs801a().bghl801a().detalhe().trttPoupanca().isTrue() || hrMghs801a().bghl801a().detalhe().trttDepPrazo().isTrue()) {
                if (msgIn().msg().ade().iDbcr().isEqual("C")) {
                    a53000ObtemDescPrazPoup() ;
                } else {
                    msgOut().msg().ade().dMovSpte().set(msgIn().msg().ade().xRefMov());
                }
            } else {
                a54000ObtemDescritivoCad() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a51000ConsultaScta() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs801a().bghl801a().initialize() ;
        hrMghs801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghs801a().bghl801a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs801a().bghl801a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs801a().bghl801a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs801a().bghl801a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs801a().bghl801a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs801a().bghl801a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs801a().bghl801a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs801a().bghl801a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs801a().bghl801a().argumento().iDbcr().set(msgIn().msg().ade().iDbcr());
        hrMghs801a().run() ;
        if (hrMghs801a().bghl801a().ok().isTrue()) {
            msgOut().msg().ade().iTipoSpte().set(hrMghs801a().bghl801a().detalhe().iTipoSpte());
        } else {
            progStatus.set(hrMghs801a().bghl801a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs801a().bghl801a().cSqlcode());
            envOut.db2Log().nmTabela().set("THO00001");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52000ObtemDescritivoExt() {
        /**
         * *----------------------------------------------------------------*
         */
        a52100ConsultaGatcnsmov() ;
        hrMhoj727a().bhol727a().commarea().initialize() ;
        if (progOk.isTrue()) {
            if (hrMghs003a().bghl003a().zHoje().isEqual(msgIn().msg().ade().tsMovimento().get(1, 10)) || 
                hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("H")) {
                a52200ObtemDadosHo() ;
            } else {
                a52300ObtemDadosHst() ;
            }
        }
        if (progOk.isTrue()) {
            a52400DescritivoExtracto() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52100ConsultaGatcnsmov() {
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
    protected void a52200ObtemDadosHo() {
        /**
         * *----------------------------------------------------------------*
         */
        a52210PreencheAreas() ;
        if (hrMghs003a().bghl003a().zHoje().isEqual(msgIn().msg().ade().tsMovimento().get(1, 10))) {
            hrMhoj352a().bhol352a().commarea().dadosInput().iMovDia().set("S");
            hrMhoj353a().bhol353a().commarea().dadosInput().iMovDia().set("S");
        } else {
            hrMhoj352a().bhol352a().commarea().dadosInput().iMovDia().set("N");
            hrMhoj353a().bhol353a().commarea().dadosInput().iMovDia().set("N");
        }
        hrMhoj352a().run() ;
        if (!hrMhoj352a().bhol352a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj352a().bhol352a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj352a().bhol352a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj352a().bhol352a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj352a().bhol352a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj352a().bhol352a().commarea().dadosErro().aAplErr());
        }
        if (progOk.isTrue()) {
            hrMhoj727a().bhol727a().commarea().dadosInput().cOeEgc().set(hrMhoj352a().bhol352a().commarea().dadosOutput().cOeEgcOpex());
            hrMhoj353a().run() ;
            if (!hrMhoj353a().bhol353a().commarea().dadosErro().semErros().isTrue()) {
                progStatus.set(hrMhoj353a().bhol353a().commarea().dadosErro().cRtnoEvenSwal());
                envOut.errosGraves().cTipoErroBbn().set(hrMhoj353a().bhol353a().commarea().dadosErro().cTipoErroBbn());
                envOut.db2Log().sqlca().cSqlcode().set(hrMhoj353a().bhol353a().commarea().dadosErro().cSqlcode());
                envOut.db2Log().nmTabela().set(hrMhoj353a().bhol353a().commarea().dadosErro().nmTabela());
                envOut.errosGraves().aAplErr().set(hrMhoj353a().bhol353a().commarea().dadosErro().aAplErr());
            }
            if (progOk.isTrue()) {
                hrMhoj727a().bhol727a().commarea().dadosInput().cOpeBbn().set(hrMhoj353a().bhol353a().commarea().dadosOutput().cOpeBbn());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52210PreencheAreas() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj352a().bhol352a().commarea().initialize() ;
        hrMhoj353a().bhol353a().commarea().initialize() ;
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj352a().bhol352a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj353a().bhol353a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj352a().bhol352a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMhoj353a().bhol353a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a52300ObtemDadosHst() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs102a().bghl102a().initialize() ;
        if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("A")) {
            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
        } else {
            hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        }
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
        if (hrMghs102a().bghl102a().ok().isTrue()) {
            hrMhoj727a().bhol727a().commarea().dadosInput().cOeEgc().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
            hrMhoj727a().bhol727a().commarea().dadosInput().cOpeBbn().set(hrMghs102a().bghl102a().detalhe().cOpeBbn());
        } else if (hrMghs102a().bghl102a().naoExiste().isTrue()) {
            progNaoExisteMov.setTrue() ;
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        } else {
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
    protected void a52400DescritivoExtracto() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().conta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj727a().bhol727a().commarea().dadosInput().iDbcr().set(msgIn().msg().ade().iDbcr());
        hrMhoj727a().bhol727a().commarea().dadosInput().iDcvoEspl().set(hrMghs801a().bghl801a().detalhe().iDcvoEspl());
        hrMhoj727a().bhol727a().commarea().dadosInput().iEstorno().set(msgIn().msg().ade().iEstorno());
        hrMhoj727a().bhol727a().commarea().dadosInput().zValor().set(msgIn().msg().ade().zValMov());
        hrMhoj727a().bhol727a().commarea().dadosInput().nCheque().set(msgIn().msg().ade().nDocOpps());
        hrMhoj727a().bhol727a().commarea().dadosInput().xRefMov().set(msgIn().msg().ade().xRefMov());
        hrMhoj727a().bhol727a().commarea().dadosInput().cIdioIso().set("POR");
        if (progOk.isTrue()) {
            hrMhoj727a().run() ;
        }
        if (progOk.isTrue()) {
            if (hrMhoj727a().bhol727a().commarea().dadosErro().semErros().isTrue()) {
                msgOut().msg().ade().dMovSpte().set(hrMhoj727a().bhol727a().commarea().dadosOutput().dMovimento());
                log(TraceLevel.Error, "BHOL727A-D-MOVIMENTO-", hrMhoj727a().bhol727a().commarea().dadosOutput().dMovimento());
            } else {
                log(TraceLevel.Error, "BHOL727A-C-RTNO-EVEN-SWAL-", hrMhoj727a().bhol727a().commarea().dadosErro().cRtnoEvenSwal());
                progStatus.set(hrMhoj727a().bhol727a().commarea().dadosErro().cRtnoEvenSwal());
                envOut.errosGraves().aAplErr().set(hrMhoj727a().bhol727a().commarea().dadosErro().aAplErr());
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
                envOut.db2Log().nmTabela().set("MHOJ727A");
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53000ObtemDescPrazPoup() {
        /**
         * *----------------------------------------------------------------*
         */
        wsDescCad.get(1, 18).set(msgIn().msg().ade().xRefMov().get(1, 18)) ;
        wsDescCad.get(19, 1).set(" ") ;
        wsDescCad.get(20, 1).set("%") ;
        wsDescCad.get(23, 1).set(",") ;
        wsTJuro.set(msgIn().msg().ade().tJuro());
        wsDescCad.get(21, 2).set(wsTJuroMask().wsTJuroInt()) ;
        wsDescCad.get(24, 2).set(wsTJuroMask().wsTJuroDec()) ;
        msgOut().msg().ade().dMovSpte().set(wsDescCad);
    }
    
    /**
     * 
     * 
     */
    protected void a54000ObtemDescritivoCad() {
        /**
         * *----------------------------------------------------------------*
         */
        wsDescCad.set(msgIn().msg().ade().xRefMov());
        if (msgIn().msg().ade().aAplOrig().isEqual("HC") || 
            msgIn().msg().ade().aAplOrig().isEqual("HH")) {
            if (msgIn().msg().ade().nDocOpps().isGreater(0)) {
                wsDescCad.get(1, 14).set(msgIn().msg().ade().xRefMov().get(1, 14)) ;
                wsDescCad.get(16, 10).set(msgIn().msg().ade().nDocOpps()) ;
            } else {
                wsDescCad.set(msgIn().msg().ade().xRefMov());
            }
        }
        if (!msgIn().msg().ade().aAplOrig().isEqual("HC") && 
            !msgIn().msg().ade().aAplOrig().isEqual("ZD")) {
            if (msgIn().msg().ade().nDocOpps().isGreater(0)) {
                wsDescCad.get(1, 14).set(msgIn().msg().ade().xRefMov().get(1, 14)) ;
                wsDescCad.get(16, 10).set(msgIn().msg().ade().nDocOpps()) ;
            }
        }
        msgOut().msg().ade().dMovSpte().set(wsDescCad);
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
    /**
     * Inner Classes
     */
    public interface WsTJuroMask extends IDataMask {
        
        @Data(size=2)
        IInt wsTJuroInt() ;
        
        @Data(size=3)
        IInt wsTJuroDec() ;
        
    }
    
}
