package cgd.gh.online;

import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
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
import cgd.gh.structures.messages.Bghm0910 ;
import cgd.gh.structures.messages.Bghm0911 ;
import cgd.hj.structures.link.Bhjl001a ;
import cgd.hj.routines.Mhjj060a ;
import cgd.hj.routines.Mhjj200a ;
import cgd.gh.routines.Mghs500a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghs501a ;
import cgd.gh.routines.Mghj801a ;
import cgd.gh.routines.Mghs802a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : LISTA DETALHE DOS MOVIMENTOS DE UMA SUBCONTA
 * FEITA POR UM PEDIDO
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho091a extends CgdGhBaseOnline<Pgho091a.EnvelopeIn, Pgho091a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0910
     */
    public abstract Bghm0910 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0911
     */
    public abstract Bghm0911 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0910.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0911.Msg msgOut() ;
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
     * @return instancia da classe Mghs500a
     */
    @Data
    protected abstract Mghs500a hrMghs500a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    /**
     * @return instancia da classe Mghs501a
     */
    @Data
    protected abstract Mghs501a hrMghs501a() ;
    
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
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bhjl001a
     */
    @Data
    protected abstract Bhjl001a bhjl001a() ;
    
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
    
    protected static final String WS_FIM_CONSULTA = "FC" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    @Data(size=2, value="0")
    protected IInt wsQItens ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH00201")
    protected IString wsNmRecurso ;
    
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
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtMovHst ;
    @Data
    @Condition("S")
    protected ICondition wsMovHstS ;
    @Data
    @Condition("N")
    protected ICondition wsMovHstN ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtMais ;
    @Data
    @Condition("1")
    protected ICondition naoHaMais ;
    @Data
    @Condition("2")
    protected ICondition haMais ;
    
    
    @Data(size=2, value="13")
    protected IInt wsLimite ;
    
    @Data(size=2, value="0")
    protected IInt wsMovFalta ;
    
    @Data(size=2, value="0")
    protected IInt wsMovCrtl ;
    
    @Data(size=1)
    protected IString wsControlo3 ;
    @Data
    @Condition("A")
    protected ICondition primeiraVez ;
    @Data
    @Condition("B")
    protected ICondition segundaVez ;
    
    
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
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        /**
         * *----------------------------------------------------------------*
         * PERFORM A50000-VALIDA-PEDIDO
         */
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().comNmCli().isTrue()) {
                a51000ObtemCliente() ;
            }
        }
        if (progOk.isTrue()) {
            wsMovFalta.set(wsLimite);
            naoHaMais.setTrue() ;
            a53000ObtemMovHst() ;
        }
    }
    
    /**
     * 
     * *A50000-VALIDA-PEDIDO.
     * INITIALIZE BGHL001A
     * BGHL010A
     * MOVE BGHM0910-C-PAIS-ISOA-CONT
     * TO MGH001A-C-PAIS-ISOA-CONT
     * MGH010A-C-PAIS-ISOA-CONT
     * MOVE BGHM0910-C-BANC-CONT     TO MGH001A-C-BANC-CONT
     * MGH010A-C-BANC-CONT
     * MOVE BGHM0910-C-OE-EGC-CONT   TO MGH001A-C-OE-EGC-CONT
     * MGH010A-C-OE-EGC-CONT
     * MOVE BGHM0910-NS-RDCL-CONT    TO MGH001A-NS-RDCL-CONT
     * MGH010A-NS-RDCL-CONT
     * MOVE BGHM0910-V-CHKD-CONT     TO MGH001A-V-CHKD-CONT
     * MGH010A-V-CHKD-CONT
     * MOVE BGHM0910-C-TIPO-CONT     TO MGH001A-C-TIPO-CONT
     * MGH010A-C-TIPO-CONT
     * MOVE BGHM0910-C-MOED-ISO-SCTA TO MGH001A-C-MOED-ISO-SCTA
     * MGH010A-C-MOED-ISO-SCTA
     * MOVE BGHM0910-NS-DEPOSITO     TO MGH001A-NS-DEPOSITO
     * MGH010A-NS-DEPOSITO
     * EXEC CICS LINK
     * PROGRAM('MGHS001A')
     * COMMAREA(BGHL001A)
     * RESP(CICSCODE)
     * END-EXEC
     * EVALUATE TRUE
     * WHEN MGH001A-OK
     * PERFORM A50100-VALIDA-DATAS
     * WHEN OTHER
     * MOVE MGH001A-C-RETORNO  TO PROG-STATUS
     * MOVE WS-ERR-FUNC        TO BHTL001A-C-TIPO-ERRO-BBN
     * MOVE MGH001A-C-SQLCODE  TO BHTL001A-C-SQLCODE
     * MOVE 'TGH00001'         TO BHTL001A-NM-TABELA
     * MOVE WS-APL-HST         TO BHTL001A-A-APL-ERR
     * END-EVALUATE
     * *A50100-VALIDA-DATAS.
     * MOVE BGHM0910-TS-MOVIMENTO TO W-TIMESTAMP
     * IF W-DATA-TIMESTAMP < MGH001A-Z-ABRA-CONT
     * MOVE MGH001A-Z-ABRA-CONT
     * TO W-DATA-TIMESTAMP
     * MOVE W-TIMESTAMP        TO BGHM0910-TS-MOVIMENTO
     * END-IF
     * MOVE BGHM0910-TS-MOV-MAX   TO W-TIMESTAMP
     * IF W-DATA-TIMESTAMP > MGH001A-Z-MOV-HIST-ULT
     * MOVE MGH001A-Z-MOV-HIST-ULT
     * MOVE W-TIMESTAMP        TO BGHM0910-TS-MOV-MAX
     * MOVE WS-NM-RECURSO       TO MGH010A-NM-RECURSO
     * PROGRAM('MGHS010A')
     * COMMAREA(BGHL010A)
     * WHEN MGH010A-OK
     * IF W-ANO-AA < MGH010A-ZA-INICIO
     * SET PROG-DATA-MIN-INV TO TRUE
     * IF PROG-OK
     * MOVE BGHM0910-TS-MOV-MAX TO W-TIMESTAMP
     * IF W-ANO-AA > MGH010A-ZA-FIM
     * MOVE MGH010A-C-RETORNO  TO PROG-STATUS
     * MOVE WS-ERRO            TO BHTL001A-C-TIPO-ERRO-BBN
     * MOVE MGH010A-C-SQLCODE  TO BHTL001A-C-SQLCODE
     * MOVE 'TGH00010'         TO BHTL001A-NM-TABELA
     * 
     */
    protected void a51000ObtemCliente() {
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
                 * MOVE BHJL060A-N-CLIENTE  TO BHJL001A-N-CLIENTE
                 */
                bhjl001a().commarea().dadosEntrada().nsAbraCli().set(hrMhjj060a().bhjl060a().commarea().dadosSaida().nsAbraCli());
                a51100ObtemNomeCli() ;
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
    protected void a51100ObtemNomeCli() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhjj200a().run() ;
        if (bhjl001a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().cTitHono().set(bhjl001a().commarea().dadosSaida().nmCliAbvd());
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
     * 
     */
    protected void a53000ObtemMovHst() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs500a().bghl500a().initialize() ;
        hrMghs500a().bghl500a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs500a().bghl500a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs500a().bghl500a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs500a().bghl500a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs500a().bghl500a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs500a().bghl500a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs500a().bghl500a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs500a().bghl500a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs500a().bghl500a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs500a().bghl500a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs500a().bghl500a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs500a().bghl500a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs500a().bghl500a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs500a().run() ;
        if (!hrMghs500a().bghl500a().ok().isTrue()) {
            progStatus.set(hrMghs500a().bghl500a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs500a().bghl500a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00500");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (progOk.isTrue()) {
            wsMovCrtl.set(subtract(wsMovFalta, 1));
            if (hrMghs500a().bghl500a().qItens().isLessOrEqual(wsMovCrtl)) {
                wsQItens.set(hrMghs500a().bghl500a().qItens());
            } else {
                wsQItens.set(wsMovCrtl);
                haMais.setTrue() ;
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs500a().bghl500a().tabela().lista().setIndex(1); hrMghs500a().bghl500a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs500a().bghl500a().tabela().lista().incIndex()) {
                hrMghs500a().bghl500a().argumento().set(hrMghs500a().bghl500a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs500a().bghl500a().detalhe().set(hrMghs500a().bghl500a().tabela().lista().getCurrent().item().itemDetalhe());
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(hrMghs500a().bghl500a().argumento().tsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(hrMghs500a().bghl500a().argumento().nsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(hrMghs500a().bghl500a().detalhe().zValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghs500a().bghl500a().detalhe().xRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(hrMghs500a().bghl500a().detalhe().mMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(hrMghs500a().bghl500a().detalhe().iDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(hrMghs500a().bghl500a().detalhe().iEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(hrMghs500a().bghl500a().detalhe().cMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(hrMghs500a().bghl500a().detalhe().mSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(hrMghs500a().bghl500a().detalhe().mSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(hrMghs500a().bghl500a().detalhe().mMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(hrMghs500a().bghl500a().detalhe().nDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(hrMghs500a().bghl500a().detalhe().aAplOrig());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(hrMghs500a().bghl500a().detalhe().iExisInfAdi());
                if (hrMghs500a().bghl500a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs500a().bghl500a().argumento().tsMovimento());
                    wsMovHstS.setTrue() ;
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
        }
        if (progOk.isTrue()) {
            if (haMais.isTrue()) {
                msgOut().msg().ade().iMsgCtnd().set("S");
                msgOut().msg().ade().tsMovimentoK().set(hrMghs500a().bghl500a().argumento().tsMovimento());
                msgOut().msg().ade().nsMovimentoK().set(hrMghs500a().bghl500a().argumento().nsMovimento());
            } else {
                msgOut().msg().ade().iMsgCtnd().set("N");
                envOut.errosGraves().fimConsulta().setTrue() ;
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
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs501a().bghl501a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs501a().bghl501a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs501a().bghl501a().detalhe().cOeEgcOpex());
        }
        if (progOk.isTrue()) {
            a53120ObtemCOpeBbn() ;
        }
        if (progOk.isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs501a().bghl501a().detalhe().cOpeBbn());
        }
        if (progOk.isTrue()) {
            hrMghk800a().run() ;
            if (hrMghk800a().bghl800a().ok().isTrue()) {
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
                wsCTipoTrttCont.set(hrMghk800a().bghl800a().output().cTipoTrttCont());
            } else {
                log(TraceLevel.Error, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno());
                log(TraceLevel.Error, "MGH800A-NM-PROGRAMA-", hrMghk800a().bghl800a().nmPrograma());
                log(TraceLevel.Error, "MGH800A-C-SQLCODE-", hrMghk800a().bghl800a().cSqlcode());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(" ");
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
        hrMghs501a().bghl501a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs501a().bghl501a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs501a().run() ;
        if (!hrMghs501a().bghl501a().ok().isTrue()) {
            progStatus.set(hrMghs501a().bghl501a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs501a().bghl501a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00501");
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
        hrMghs501a().bghl501a().initialize() ;
        hrMghs501a().bghl501a().criterioConsulta().crtQuem().setTrue() ;
        hrMghs501a().bghl501a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs501a().bghl501a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs501a().bghl501a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs501a().bghl501a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs501a().bghl501a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs501a().bghl501a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs501a().bghl501a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs501a().bghl501a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs501a().bghl501a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs501a().bghl501a().argumento().nsMovimento().set(msgOut().msg().ade().grMov().getCurrent().nsMovimento());
        hrMghs501a().run() ;
        if (!hrMghs501a().bghl501a().ok().isTrue()) {
            progStatus.set(hrMghs501a().bghl501a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs501a().bghl501a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00501");
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
            
            @Data(size=1, value=".")
            IString filler001() ;
            
            @Data(size=6, value="0")
            IInt filler002() ;
            
        }
    }
    
}
