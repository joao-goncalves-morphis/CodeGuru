package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
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
import cgd.gh.structures.messages.Bghm0950 ;
import cgd.gh.structures.messages.Bghm0951 ;
import cgd.ho.routines.Mhoj355a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghs801a ;
import cgd.gh.routines.Mghs501a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : CONSULTA POSICAO DA CONTA NO MOMENTO DA OPERA-*
 * CAO PARA UM DETERMINADO MOVIMENTO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho095a extends CgdGhBaseOnline<Pgho095a.EnvelopeIn, Pgho095a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0950
     */
    public abstract Bghm0950 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0951
     */
    public abstract Bghm0951 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0950.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0951.Msg msgOut() ;
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
     * @return instancia da classe Mhoj355a
     */
    @Data
    protected abstract Mhoj355a hrMhoj355a() ;
    
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
     * @return instancia da classe Mghs801a
     */
    @Data
    protected abstract Mghs801a hrMghs801a() ;
    
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
        if (progOk.isTrue()) {
            a55000ObtemPosicaoActual() ;
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
        a52500PreencheA355() ;
        hrMhoj355a().bhol355a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj355a().run() ;
        if (!hrMhoj355a().bhol355a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj355a().bhol355a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj355a().bhol355a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj355a().bhol355a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj355a().bhol355a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj355a().bhol355a().commarea().dadosErro().aAplErr());
        }
        /**
         * --> ACESSO AO MHOJ355A
         * MOVE BHOL355A-C-CNDZ-MOVZ-CONT
         * TO BGHM0951-C-CNDZ-MOVZ-CONT-MOV
         */
        if (hrMhoj355a().bhol355a().commarea().dadosErro().semErros().isTrue()) {
            msgOut().msg().ade().posicaoMov().cFamiProdMov().set(hrMhoj355a().bhol355a().commarea().areaOutput().cFamiProd());
            msgOut().msg().ade().posicaoMov().cProdutoMov().set(hrMhoj355a().bhol355a().commarea().areaOutput().cProduto());
            msgOut().msg().ade().posicaoMov().cSectIttlBporMov().set(hrMhoj355a().bhol355a().commarea().areaOutput().cSectIttlBpor());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a52500PreencheA355() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj355a().bhol355a().commarea().initialize() ;
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj355a().bhol355a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj355a().bhol355a().commarea().dadosInput().nsMovimento().set(msgIn().msg().ade().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a53000ObtemDadosHst() {
        hrMghs102a().bghl102a().criterioConsulta().crtPosicao().setTrue() ;
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
            msgOut().msg().ade().posicaoMov().cFamiProdMov().set(hrMghs102a().bghl102a().detalhe().cFamiProd());
            msgOut().msg().ade().posicaoMov().cProdutoMov().set(hrMghs102a().bghl102a().detalhe().cProduto());
            msgOut().msg().ade().posicaoMov().cSectIttlBporMov().set(hrMghs102a().bghl102a().detalhe().cTipoIttz());
            msgOut().msg().ade().posicaoMov().cCndzMovzContMov().set(hrMghs102a().bghl102a().detalhe().cCndzMovzCont());
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
        a52500PreencheA355() ;
        hrMhoj355a().bhol355a().commarea().dadosInput().iMovDia().set("N");
        hrMhoj355a().run() ;
        if (!hrMhoj355a().bhol355a().commarea().dadosErro().semErros().isTrue()) {
            progStatus.set(hrMhoj355a().bhol355a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cTipoErroBbn().set(hrMhoj355a().bhol355a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj355a().bhol355a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhoj355a().bhol355a().commarea().dadosErro().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhoj355a().bhol355a().commarea().dadosErro().aAplErr());
        }
        /**
         * --> ACESSO AO MHOJ355A
         * MOVE BHOL355A-C-TIPO-ITTZ
         * TO BGHM0951-C-SECT-ITTL-BPOR-MOV
         * MOVE BHOL355A-C-CNDZ-MOVZ-CONT
         * TO BGHM0951-C-CNDZ-MOVZ-CONT-MOV
         */
        if (hrMhoj355a().bhol355a().commarea().dadosErro().semErros().isTrue()) {
            msgOut().msg().ade().posicaoMov().cFamiProdMov().set(hrMhoj355a().bhol355a().commarea().areaOutput().cFamiProd());
            msgOut().msg().ade().posicaoMov().cProdutoMov().set(hrMhoj355a().bhol355a().commarea().areaOutput().cProduto());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000ObtemPosicaoActual() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs801a().bghl801a().initialize() ;
        hrMghs801a().bghl801a().iDadosSubcontaS().setTrue() ;
        hrMghs801a().bghl801a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs801a().bghl801a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs801a().bghl801a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs801a().bghl801a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs801a().bghl801a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs801a().bghl801a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs801a().bghl801a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs801a().bghl801a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs801a().run() ;
        if (!hrMghs801a().bghl801a().ok().isTrue()) {
            progStatus.set(hrMghs801a().bghl801a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs801a().bghl801a().cSqlcode());
            envOut.db2Log().nmTabela().set("THO00001");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            msgOut().msg().ade().posicaoActual().cFamiProd().set(hrMghs801a().bghl801a().detalhe().cFamiProd());
            msgOut().msg().ade().posicaoActual().cProduto().set(hrMghs801a().bghl801a().detalhe().cProduto());
            msgOut().msg().ade().posicaoActual().cSectIttlBpor().set(hrMghs801a().bghl801a().detalhe().cSectIttlBpor());
            msgOut().msg().ade().posicaoActual().cCndzMovzCont().set(hrMghs801a().bghl801a().detalhe().cCndzMovzCont());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a60000TratarHstNaoActivo() {
        hrMghs501a().bghl501a().criterioConsulta().crtPosicao().setTrue() ;
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
            msgOut().msg().ade().posicaoMov().cFamiProdMov().set(hrMghs501a().bghl501a().detalhe().cFamiProd());
            msgOut().msg().ade().posicaoMov().cProdutoMov().set(hrMghs501a().bghl501a().detalhe().cProduto());
            msgOut().msg().ade().posicaoMov().cSectIttlBporMov().set(hrMghs501a().bghl501a().detalhe().cTipoIttz());
            msgOut().msg().ade().posicaoMov().cCndzMovzContMov().set(hrMghs501a().bghl501a().detalhe().cCndzMovzCont());
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
