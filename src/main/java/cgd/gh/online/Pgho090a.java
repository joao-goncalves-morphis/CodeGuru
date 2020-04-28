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
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm0900 ;
import cgd.gh.structures.messages.Bghm0901 ;
import cgd.hj.structures.link.Bhjl001a ;
import cgd.gh.structures.work.Bghw0013 ;
import cgd.gh.routines.Mghs001a ;
import cgd.gh.routines.Mghs010a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghs002a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghs022a ;
import cgd.gh.routines.Mghs804a ;
import cgd.ho.routines.Mhoj354a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghj801a ;
import cgd.gh.routines.Mghs802a ;
import cgd.gh.routines.Mghs210a ;
import cgd.gh.routines.Mghs023a ;
import cgd.gh.routines.Mghs024a ;
import cgd.gh.routines.Mghs025a ;
import cgd.gh.routines.Mghs026a ;
import cgd.gh.routines.Mghs027a ;
import cgd.gh.routines.Mghs028a ;
import cgd.gh.routines.Mghs123a ;
import cgd.gh.routines.Mghs124a ;
import cgd.gh.routines.Mghs125a ;
import cgd.gh.routines.Mghs126a ;
import cgd.gh.routines.Mghs127a ;
import cgd.gh.routines.Mghs128a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : LISTA DETALHE DOS MOVIMENTOS DE UMA SUBCONTA
 * DATA ALTERACAO: 2015/11/27
 * DESCRICAO     : RESOLUCAO HD-1291910 (CONTORNAR ERRO GH091 -
 * : CRITERIO DATA MINIMA INVALIDO)
 * PRC19         : 2019-10-09 - PERMITIR A CONSULTA DOS MOVIMENTOS
 * : DE 8 ANOS MAIS O ANO CORRENTE. PREÇÁRIO 2019
 * 
 * @version 2.0
 * 
 */
public abstract class Pgho090a extends CgdGhBaseOnline<Pgho090a.EnvelopeIn, Pgho090a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm0900
     */
    public abstract Bghm0900 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm0901
     */
    public abstract Bghm0901 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0900.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm0901.Msg msgOut() ;
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
     * @return instancia da classe Mghs010a
     */
    @Data
    protected abstract Mghs010a hrMghs010a() ;
    
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
    /**
     * @return instancia da classe Mghs002a
     */
    @Data
    protected abstract Mghs002a hrMghs002a() ;
    
    /**
     * @return instancia da classe Mghs102a
     */
    @Data
    protected abstract Mghs102a hrMghs102a() ;
    
    /**
     * @return instancia da classe Mghs022a
     */
    @Data
    protected abstract Mghs022a hrMghs022a() ;
    
    /**
     * @return instancia da classe Mghs804a
     */
    @Data
    protected abstract Mghs804a hrMghs804a() ;
    
    /**
     * @return instancia da classe Mhoj354a
     */
    @Data
    protected abstract Mhoj354a hrMhoj354a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
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
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bhjl001a
     */
    @Data
    protected abstract Bhjl001a bhjl001a() ;
    
    /**
     * @return instancia da classe Bghw0013
     */
    @Data
    protected abstract Bghw0013 bghw0013() ;
    
    /**
     * PRC19 - FIM
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
    
    protected static final String WS_FIM_CONSULTA = "FC" ;
    
    @Data(size=2, value="12")
    protected IInt wsQItens ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH00201")
    protected IString wsNmRecurso ;
    
    @Data(size=8, value="MHOJ354A")
    protected IString bhol354aNmRotina ;
    
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
    protected IString wsCrtCanal ;
    @Data
    @Condition("A")
    protected ICondition balcao ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtMovHst ;
    @Data
    @Condition("S")
    protected ICondition wsMovHstS ;
    @Data
    @Condition("N")
    protected ICondition wsMovHstN ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtSair ;
    @Data
    @Condition("1")
    protected ICondition naoSair ;
    @Data
    @Condition("2")
    protected ICondition sair ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtMais ;
    @Data
    @Condition("1")
    protected ICondition naoHaMais ;
    @Data
    @Condition("2")
    protected ICondition haMais ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtMov ;
    @Data
    @Condition("N")
    protected ICondition naoHaMov ;
    @Data
    @Condition("S")
    protected ICondition haMov ;
    
    
    @Data(size=2, value="13")
    protected IInt wsLimite ;
    
    @Data(size=2, value="13")
    protected IInt wsMovFalta ;
    
    @Data(size=2, value="0")
    protected IInt wIndice ;
    
    @Data(size=2, value="0")
    protected IInt wsTotEnvr ;
    
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
     * PRC19 - INI
     * @return instancia da classe local WsTsAux
     */
    @Data
    protected abstract WsTsAux wsTsAux() ;
    
    /**
     * PRC19 - FIM
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovimento ;
    
    /**
     * @return instancia da classe local WsTabelaMovimento
     */
    @Data
    protected abstract WsTabelaMovimento wsTabelaMovimento() ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "--- PGHO090A S10000-INICIAR ---");
        msgIn().msg().initialize() ;
        msgOut().msg().initialize() ;
        wsCrtCanal.initialize() ;
        wsTabelaMovimento().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        log(TraceLevel.Debug, "BGHM0900-C-PAIS-ISOA-CONT: ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "BGHM0900-C-BANC-CONT     : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "BGHM0900-C-OE-EGC-CONT   : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "BGHM0900-NS-RDCL-CONT    : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "BGHM0900-V-CHKD-CONT     : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "BGHM0900-C-TIPO-CONT     : ", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "BGHM0900-C-MOED-ISO-SCTA : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "BGHM0900-NS-DEPOSITO     : ", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "BGHM0900-TS-MOVIMENTO    : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, "BGHM0900-NS-MOVIMENTO    : ", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "BGHM0900-I-CONSULTA      : ", msgIn().msg().ade().iConsulta());
        log(TraceLevel.Debug, "BGHM0900-TS-MOV-MAX      : ", msgIn().msg().ade().tsMovMax());
        log(TraceLevel.Debug, "BGHM0900-I-CRIT-CL       : ", msgIn().msg().ade().iCritCl());
        log(TraceLevel.Debug, "BGHM0900-M-MOV-MIN       : ", msgIn().msg().ade().iCritMontante().mMovMin());
        log(TraceLevel.Debug, "BGHM0900-M-MOV-MAX       : ", msgIn().msg().ade().iCritMontante().mMovMax());
        log(TraceLevel.Debug, "BGHM0900-I-CRIT-DBCR     : ", msgIn().msg().ade().iCritDbcr());
        msgOut().msg().ase().set(msgIn().msg().ase());
        progOk.setTrue() ;
        msgOut().msg().ade().grMov().resetIndex() ;
        naoHaMais.setTrue() ;
    }
    
    /**
     * 
     * 
     */
    protected void s30000Validar() {
        log(TraceLevel.Debug, "--- PGHO090A S30000-VALIDAR ---");
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
        if (progOk.isTrue()) {
            if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual("BALC")) {
                balcao.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Processar() {
        log(TraceLevel.Debug, "--- PGHO090A S50000-PROCESSAR ---");
        a52000ConsultaGatcnsmov() ;
        if (progOk.isTrue()) {
            a50000ValidaPedido() ;
        }
        /**
         * DEIXA DE OBTER O NOME DO CLIENTE, PASSOU A SER OBTIDO NA CLIJ87
         * IF PROG-OK
         * IF BGHM0900-COM-NM-CLI
         * PERFORM A51000-OBTEM-CLIENTE
         * END-IF
         */
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().ascendente().isTrue()) {
                if (msgIn().msg().ade().tsMovimento().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                    /**
                     * PERFORM UNTIL W-ANO-AA > MGH010A-ZA-INICIO
                     */
                    while (wTimestamp().wDataTimestamp().wAnoAa().isLessOrEqual(msgIn().msg().ade().tsMovMax().get(1, 4)) && !hrMghs210a().bghl210a().detalhe().nmRecurso().isEqual("VGH00201") && !wsMovFalta.isEqual(0) && progOk.isTrue()) {
                        a56000ObtemHst() ;
                    }
                    if (progOk.isTrue()) {
                        if (wsMovFalta.isGreater(0)) {
                            a53000ObtemMovHst() ;
                        }
                    }
                }
                if (progOk.isTrue()) {
                    if (wsMovFalta.isGreater(0)) {
                        a54000ObtemMovOntem() ;
                    }
                }
                if (progOk.isTrue()) {
                    if (wsMovFalta.isGreater(0)) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
                            a55000ObtemMovDiaHo() ;
                        }
                    }
                }
            } else {
                if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
                    a55000ObtemMovDiaHo() ;
                }
                if (progOk.isTrue()) {
                    if (wsMovFalta.isGreater(0)) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                            a54000ObtemMovOntem() ;
                        }
                    }
                }
                if (progOk.isTrue()) {
                    if (wsMovFalta.isGreater(0)) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                            a53000ObtemMovHst() ;
                            if (progOk.isTrue()) {
                                while (wTimestamp().wDataTimestamp().wAnoAa().isGreaterOrEqual(msgIn().msg().ade().tsMovMax().get(1, 4)) && !wsMovFalta.isEqual(0) && progOk.isTrue()) {
                                    a56000ObtemHst() ;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a50000ValidaPedido() {
        log(TraceLevel.Debug, "--- PGHO090A A50000-VALIDA-PEDIDO ---");
        hrMghs001a().bghl001a().initialize() ;
        hrMghs010a().bghl010a().initialize() ;
        hrMghs001a().bghl001a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs010a().bghl010a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs001a().bghl001a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs010a().bghl010a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs001a().bghl001a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs010a().bghl010a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs001a().bghl001a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs010a().bghl010a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs001a().bghl001a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs010a().bghl010a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs001a().bghl001a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs010a().bghl010a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs001a().bghl001a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs010a().bghl010a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs001a().bghl001a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs010a().bghl010a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs001a().run() ;
        if (hrMghs001a().bghl001a().ok().isTrue()) {
            if (msgIn().msg().ade().ascendente().isTrue()) {
                wTimestamp().set(msgIn().msg().ade().tsMovimento());
                wsTsAux().set(msgIn().msg().ade().tsMovMax());
            } else {
                wTimestamp().set(msgIn().msg().ade().tsMovMax());
                wsTsAux().set(msgIn().msg().ade().tsMovimento());
            }
            /**
             * SUBTRACT 2 FROM W-ANO-AUX
             * IF BHTL001A-C-TIPO-CANL-ACES NOT EQUAL 'BALC'
             * MOVE W-DATA-TS-AUX TO W-DATA-TIMESTAMP
             * END-IF
             * IF W-DATA-TIMESTAMP < W-DATA-TS-AUX
             * IF W-DATA-TIMESTAMP < MGH001A-Z-ABRA-CONT
             * SET PROG-DATA-ABERTURA TO TRUE
             * MOVE WS-ERR-FUNC      TO BHTL001A-C-TIPO-ERRO-BBN
             * MOVE WS-APL-HST       TO BHTL001A-A-APL-ERR
             * ELSE
             */
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
        log(TraceLevel.Debug, "--- PGHO090A A50100-VALIDA-DATAS ---");
        /**
         * IF BGHM0900-ASCENDENTE
         * MOVE BGHM0900-TS-MOVIMENTO TO W-TIMESTAMP
         * ELSE
         * MOVE BGHM0900-TS-MOV-MAX   TO W-TIMESTAMP
         * END-IF
         * IF W-DATA-TIMESTAMP < MGH001A-Z-ABRA-CONT
         * IF BGHM0900-C-TIPO-CONT NOT =  34
         * MOVE MGH001A-Z-ABRA-CONT
         * TO W-DATA-TIMESTAMP
         * MOVE W-TIMESTAMP     TO BGHM0900-TS-MOVIMENTO
         * MOVE W-TIMESTAMP     TO BGHM0900-TS-MOV-MAX
         */
        hrMghs010a().bghl010a().argumento().nmRecurso().set(wsNmRecurso);
        hrMghs010a().run() ;
        if (hrMghs010a().bghl010a().ok().isTrue()) {
            /**
             * IF W-ANO-AA < MGH010A-ZA-INICIO
             * INICIO
             * IF BHTL001A-C-TIPO-CANL-ACES = 'BALC'
             * SET PROG-DATA-MIN-INV TO TRUE
             * MOVE WS-ERR-FUNC   TO BHTL001A-C-TIPO-ERRO-BBN
             * MOVE WS-APL-HST    TO BHTL001A-A-APL-ERR
             * ELSE
             * FIM
             * MOVE MGH010A-ZA-INICIO TO W-ANO-AA
             * MOVE 01                TO W-MES-MM
             * W-DIA-DD
             * MOVE ZEROS             TO W-HORA
             * W-MINUTO
             * W-SEGUNDO
             * W-RESTO
             * IF BGHM0900-ASCENDENTE
             * MOVE W-TIMESTAMP    TO BGHM0900-TS-MOVIMENTO
             * MOVE W-TIMESTAMP    TO BGHM0900-TS-MOV-MAX
             * END-IF
             */
            if (msgIn().msg().ade().ascendente().isTrue()) {
                wTimestamp().wDataTimestamp().wAnoAa().set(msgIn().msg().ade().tsMovimento().get(1, 4));
            } else {
                wTimestamp().wDataTimestamp().wAnoAa().set(msgIn().msg().ade().tsMovimento().get(1, 4));
                hrMghs010a().bghl010a().detalhe().zaInicio().set(wTimestamp().wDataTimestamp().wAnoAa());
            }
        } else if (hrMghs010a().bghl010a().naoExisteConta().isTrue()) {
            /**
             * IF BGHM0900-ASCENDENTE
             */
            wTimestamp().wDataTimestamp().wAnoAa().set(msgIn().msg().ade().tsMovimento().get(1, 4));
            /**
             * ELSE
             * MOVE BGHM0900-TS-MOV-MAX(1:4)
             * TO W-ANO-AA
             * END-IF
             */
            hrMghs010a().bghl010a().detalhe().zaInicio().set(wTimestamp().wDataTimestamp().wAnoAa());
        } else if (!hrMghs001a().bghl001a().detalhe().zAbraCont().isEqual(hrMghs003a().bghl003a().zHoje()) && 
            !msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
            progStatus.set(hrMghs010a().bghl010a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs010a().bghl010a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00010");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * PRC19 - INI
     * *A51000-OBTEM-CLIENTE.
     * IF SW-DEBUG-SIM
     * DISPLAY '--- PGHO090A A51000-OBTEM-CLIENTE ---'
     * END-IF
     * INITIALIZE BHJL060A-COMMAREA
     * BHJL001A-COMMAREA
     * MOVE BHTL001A-C-PAIS-ISOA-OE-OPX
     * TO BHJL060A-C-PAIS-ISOA-OE-OPX
     * BHJL001A-C-PAIS-ISOA-OE-OPX
     * MOVE BHTL001A-C-MNEM-EGC-OPEX  TO BHJL060A-C-MNEM-EGC-OPEX
     * BHJL001A-C-MNEM-EGC-OPEX
     * MOVE BHTL001A-Z-PRCT-JOUR-BBN  TO BHJL060A-Z-CONSULTA
     * MOVE BGHM0900-C-PAIS-ISOA-CONT TO BHJL060A-C-PAIS-ISOA-CONT
     * BHJL001A-C-PAIS-ISOA-CONT
     * MOVE BGHM0900-C-BANC-CONT      TO BHJL060A-C-BANC-CONT
     * BHJL001A-C-BANC-CONT
     * MOVE BGHM0900-C-OE-EGC-CONT    TO BHJL060A-C-OE-EGC-CONT
     * BHJL001A-C-OE-EGC-CONT
     * MOVE BGHM0900-NS-RDCL-CONT     TO BHJL060A-NS-RDCL-CONT
     * BHJL001A-NS-RDCL-CONT
     * MOVE BGHM0900-V-CHKD-CONT      TO BHJL060A-V-CHKD-CONT
     * BHJL001A-V-CHKD-CONT
     * MOVE BGHM0900-C-TIPO-CONT      TO BHJL060A-C-TIPO-CONT
     * BHJL001A-C-TIPO-CONT
     * MOVE 101                       TO BHJL060A-I-TIPO-ITVT
     * BHJL001A-I-TIPO-ITVT
     * MOVE 1                         TO BHJL060A-NS-TITC
     * BHJL001A-NS-TITC
     * CALL BHJL060A-NOME-ROTINA USING DFHEIBLK DFHCOMMAREA
     * BHJL060A-COMMAREA
     * IF BHJL060A-SEM-ERROS
     * IF BHJL060A-CLIENTE-CONFIDENCIAL
     * MOVE SPACES              TO BGHM0901-C-TIT-HONO
     * BGHM0901-NM-CLI-ABVD
     * ELSE
     * MOVE BHJL060A-N-CLIENTE    TO BHJL001A-N-CLIENTE
     * DISPLAY 'BHJL001A-N-CLIENTE-' BHJL001A-N-CLIENTE
     * MOVE BHJL060A-NS-ABRA-CLI  TO BHJL001A-NS-ABRA-CLI
     * PERFORM A51100-OBTEM-NOME-CLI
     * MOVE BHJL060A-C-TIPO-ERRO-BBN
     * TO BHTL001A-C-TIPO-ERRO-BBN
     * MOVE BHJL060A-C-RTNO-EVEN-SWAL
     * TO PROG-STATUS
     * MOVE BHJL060A-C-SQLCODE      TO BHTL001A-C-SQLCODE
     * MOVE BHJL060A-NM-TABELA      TO BHTL001A-NM-TABELA
     * MOVE BHJL060A-A-APL-ERR      TO BHTL001A-A-APL-ERR
     * *A51100-OBTEM-NOME-CLI.
     * DISPLAY '--- PGHO090A A51100-OBTEM-NOME-CLI ---'
     * CALL BHJL001A-NOME-ROTINA USING DFHEIBLK DFHCOMMAREA
     * IF BHJL001A-SEM-ERROS
     * MOVE BHJL001A-C-TIT-HONO   TO BGHM0901-C-TIT-HONO
     * MOVE BHJL001A-NM-CLI-ABVD  TO BGHM0901-NM-CLI-ABVD
     * IF BHJL001A-NOME-N-EXI
     * MOVE SPACES             TO BGHM0901-C-TIT-HONO
     * MOVE BHJL001A-C-TIPO-ERRO-BBN
     * MOVE BHJL001A-C-RTNO-EVEN-SWAL
     * MOVE BHJL001A-C-SQLCODE   TO BHTL001A-C-SQLCODE
     * MOVE BHJL001A-NM-TABELA   TO BHTL001A-NM-TABELA
     * MOVE BHJL001A-A-APL-ERR   TO BHTL001A-A-APL-ERR
     * PRC19 - FIM
     * 
     */
    protected void a52000ConsultaGatcnsmov() {
        log(TraceLevel.Debug, "--- PGHO090A A52000-CONSULTA-GATCNSMOV ---");
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set("TGH00022");
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set("I");
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            progStatus.set(hrMghs003a().bghl003a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00003");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53000ObtemMovHst() {
        log(TraceLevel.Debug, "--- PGHO090A A53000-OBTEM-MOV-HST ---");
        naoHaMov.setTrue() ;
        hrMghs002a().bghl002a().initialize() ;
        hrMghs002a().bghl002a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs002a().bghl002a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs002a().bghl002a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs002a().bghl002a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs002a().bghl002a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs002a().bghl002a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs002a().bghl002a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs002a().bghl002a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs002a().bghl002a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs002a().bghl002a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
        hrMghs002a().bghl002a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs002a().bghl002a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs002a().bghl002a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs002a().bghl002a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs002a().bghl002a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs002a().run() ;
        if (hrMghs002a().bghl002a().ok().isTrue()) {
            haMov.setTrue() ;
        }
        if (!hrMghs002a().bghl002a().ok().isTrue() && !hrMghs002a().bghl002a().naoExiste().isTrue()) {
            progStatus.set(hrMghs002a().bghl002a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs002a().bghl002a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00002");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (haMov.isTrue()) {
            if (hrMghs002a().bghl002a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs002a().bghl002a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs002a().bghl002a().tabela().lista().setIndex(1); hrMghs002a().bghl002a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs002a().bghl002a().tabela().lista().incIndex()) {
                hrMghs002a().bghl002a().argumento().set(hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs002a().bghl002a().detalhe().set(hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(hrMghs002a().bghl002a().argumento().tsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs002a().bghl002a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs002a().bghl002a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs002a().bghl002a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs002a().bghl002a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs002a().bghl002a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs002a().bghl002a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs002a().bghl002a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs002a().bghl002a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs002a().bghl002a().detalhe().mSldoDpnlApos());
                wsMovHstS.setTrue() ;
                if (!balcao.isTrue()) {
                    if (!hrMghs002a().bghl002a().detalhe().mSldoCbloApos().isEqual(hrMghs002a().bghl002a().detalhe().mSldoDpnlApos())) {
                        a53500CalculaSldoDpnl() ;
                    }
                }
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs002a().bghl002a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs002a().bghl002a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs002a().bghl002a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs002a().bghl002a().detalhe().iExisInfAdi());
                if (wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().isEqual("N")) {
                    a53400VerInfAdiApl() ;
                }
                if (hrMghs002a().bghl002a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs002a().bghl002a().argumento().tsMovimento());
                    a53100ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                    }
                }
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53500CalculaSldoDpnl() {
        log(TraceLevel.Debug, "--- PGHO090A A53500-CALCULA-SLDO-DPNL ---");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtSaldos().setTrue() ;
        if (wsMovHstS.isTrue()) {
            hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        } else {
            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
        }
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(hrMghs002a().bghl002a().argumento().tsMovimento());
        hrMghs102a().bghl102a().argumento().nsMovimento().set(hrMghs002a().bghl002a().argumento().nsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            progStatus.set(hrMghs102a().bghl102a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
        if (progOk.isTrue()) {
            wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(subtract(hrMghs002a().bghl002a().detalhe().mSldoCbloApos(), add(hrMghs102a().bghl102a().detalhe().mSldoRetd(), hrMghs102a().bghl102a().detalhe().mSldoVcob())));
        }
    }
    
    /**
     * 
     * 
     */
    protected void a54000ObtemMovOntem() {
        log(TraceLevel.Debug, "--- PGHO090A A54000-OBTEM-MOV-ONTEM ---");
        switch (hrMghs003a().bghl003a().detalhe().iEstRcrs().get()) {
            case "A":
                /**
                 * MOVIMENTOS DO DIA D -1 ESTAO NA TGH022              -*
                 */
                a54100ObtemMovDiaAntGh() ;
                break;
            case "H":
                /**
                 * MOVIMENTOS DO DIA D -1 ESTAO NA NA APLICACAO HO     -*
                 */
                a54200ObtemMovDiaAntHo() ;
                break;
            default :
                break ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a54100ObtemMovDiaAntGh() {
        log(TraceLevel.Debug, "--- PGHO090A A54100-OBTEM-MOV-DIA-ANT-GH ---");
        naoHaMov.setTrue() ;
        hrMghs022a().bghl022a().initialize() ;
        hrMghs022a().bghl022a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs022a().bghl022a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs022a().bghl022a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs022a().bghl022a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs022a().bghl022a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs022a().bghl022a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs022a().bghl022a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs022a().bghl022a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs022a().bghl022a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs022a().bghl022a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs022a().bghl022a().argumento().zMovimento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
        hrMghs022a().bghl022a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs022a().bghl022a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs022a().bghl022a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs022a().bghl022a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs022a().run() ;
        if (hrMghs022a().bghl022a().ok().isTrue()) {
            haMov.setTrue() ;
        }
        if (!hrMghs022a().bghl022a().ok().isTrue() && !hrMghs022a().bghl022a().naoExiste().isTrue()) {
            progStatus.set(hrMghs022a().bghl022a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs022a().bghl022a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00022");
            if (hrMghs022a().bghl022a().aAplErr().isEmpty()) {
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
            } else {
                envOut.errosGraves().aAplErr().set(hrMghs022a().bghl022a().aAplErr());
            }
        }
        if (haMov.isTrue()) {
            if (hrMghs022a().bghl022a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs022a().bghl022a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs022a().bghl022a().tabela().lista().setIndex(1); hrMghs022a().bghl022a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs022a().bghl022a().tabela().lista().incIndex()) {
                hrMghs022a().bghl022a().argumento().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs022a().bghl022a().detalhe().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTs().wDataTs().set(hrMghs022a().bghl022a().argumento().zMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(wsTs());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs022a().bghl022a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs022a().bghl022a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs022a().bghl022a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs022a().bghl022a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs022a().bghl022a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs022a().bghl022a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs022a().bghl022a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs022a().bghl022a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs022a().bghl022a().detalhe().mSldoDpnlApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs022a().bghl022a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs022a().bghl022a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs022a().bghl022a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set("N");
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a54200ObtemMovDiaAntHo() {
        log(TraceLevel.Debug, "--- PGHO090A A54200-OBTEM-MOV-DIA-ANT-HO ---");
        naoHaMov.setTrue() ;
        hrMghs804a().bghl804a().initialize() ;
        hrMghs804a().bghl804a().criterioDia().iMovDia().set("N");
        a54210AcedeHo() ;
    }
    
    /**
     * 
     * 
     */
    protected void a54210AcedeHo() {
        log(TraceLevel.Debug, "--- PGHO090A A54210-ACEDE-HO ---");
        hrMghs804a().bghl804a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs804a().bghl804a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs804a().bghl804a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs804a().bghl804a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs804a().bghl804a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs804a().bghl804a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs804a().bghl804a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs804a().bghl804a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs804a().bghl804a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hrMghs804a().bghl804a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs804a().bghl804a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs804a().bghl804a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs804a().bghl804a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs804a().run() ;
        if (hrMghs804a().bghl804a().ok().isTrue()) {
            haMov.setTrue() ;
        }
        if (!hrMghs804a().bghl804a().ok().isTrue() && !hrMghs804a().bghl804a().naoExiste().isTrue()) {
            progStatus.set(hrMghs804a().bghl804a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs804a().bghl804a().cSqlcode());
            envOut.db2Log().nmTabela().set("THO00020");
            envOut.errosGraves().aAplErr().set(hrMghs804a().bghl804a().aAplErr());
        }
        if (haMov.isTrue()) {
            if (hrMghs804a().bghl804a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs804a().bghl804a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs804a().bghl804a().tabela().lista().setIndex(1); hrMghs804a().bghl804a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs804a().bghl804a().tabela().lista().incIndex()) {
                hrMghs804a().bghl804a().argumento().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs804a().bghl804a().detalhe().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTs().wDataTs().set(hrMghs804a().bghl804a().argumento().zMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(wsTs());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs804a().bghl804a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs804a().bghl804a().detalhe().zValor());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs804a().bghl804a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs804a().bghl804a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs804a().bghl804a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs804a().bghl804a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs804a().bghl804a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs804a().bghl804a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs804a().bghl804a().detalhe().mSldoDpnlApos());
                wsMovHstS.setTrue() ;
                if (!balcao.isTrue()) {
                    if (!wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().isEqual(wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos())) {
                        a54211CalculaSldoDpnl() ;
                    }
                }
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs804a().bghl804a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs804a().bghl804a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs804a().bghl804a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set("N");
                wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(hrMghs804a().bghl804a().detalhe().tJuro());
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a55000ObtemMovDiaHo() {
        log(TraceLevel.Debug, "--- PGHO090A A55000-OBTEM-MOV-DIA-HO ---");
        naoHaMov.setTrue() ;
        hrMghs804a().bghl804a().initialize() ;
        hrMghs804a().bghl804a().criterioDia().iMovDia().set("S");
        a54210AcedeHo() ;
    }
    
    /**
     * 
     * 
     */
    protected void a54211CalculaSldoDpnl() {
        log(TraceLevel.Debug, "--- PGHO090A A54211-CALCULA-SLDO-DPNL ---");
        hrMhoj354a().bhol354a().commarea().initialize() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set(hrMghs804a().bghl804a().criterioDia().iMovDia());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj354a().bhol354a().commarea().dadosInput().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
        hrMhoj354a().run() ;
        if (hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue() || hrMhoj354a().bhol354a().commarea().dadosErro().fimConsulta().isTrue()) {
            wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(subtract(wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos(), add(hrMhoj354a().bhol354a().commarea().areaOutput().mSldoRetd(), hrMhoj354a().bhol354a().commarea().areaOutput().mSldoVcob())));
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53100ObtemDescritivoMov() {
        log(TraceLevel.Debug, "--- PGHO090A A53100-OBTEM-DESCRITIVO-MOV ---");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov());
        a53110ObterCOeOpex() ;
        if (progOk.isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        }
        if (progOk.isTrue()) {
            a53120ObtemCOpeBbn() ;
        }
        if (progOk.isTrue()) {
            hrMghk800a().bghl800a().input().cOpeBbn().set(hrMghs102a().bghl102a().detalhe().cOpeBbn());
        }
        if (progOk.isTrue()) {
            hrMghk800a().run() ;
            if (hrMghk800a().bghl800a().ok().isTrue()) {
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
                wsCTipoTrttCont.set(hrMghk800a().bghl800a().output().cTipoTrttCont());
            } else {
                log(TraceLevel.Error, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno());
                log(TraceLevel.Error, "MGH800A-NM-PROGRAMA-", hrMghk800a().bghl800a().nmPrograma());
                log(TraceLevel.Error, "MGH800A-C-SQLCODE-", hrMghk800a().bghl800a().cSqlcode());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(" ");
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53110ObterCOeOpex() {
        log(TraceLevel.Debug, "--- PGHO090A A53110-OBTER-C-OE-OPEX ---");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtOnde().setTrue() ;
        if (wsMovHstS.isTrue()) {
            hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        } else {
            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
        }
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs102a().bghl102a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            progStatus.set(hrMghs102a().bghl102a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53120ObtemCOpeBbn() {
        log(TraceLevel.Debug, "--- PGHO090A A53120-OBTEM-C-OPE-BBN ---");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtQuem().setTrue() ;
        if (wsMovHstS.isTrue()) {
            hrMghs102a().bghl102a().criterioConsulta().movHstS().setTrue() ;
        } else {
            hrMghs102a().bghl102a().criterioConsulta().movHstN().setTrue() ;
        }
        hrMghs102a().bghl102a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs102a().bghl102a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs102a().bghl102a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs102a().bghl102a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs102a().bghl102a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs102a().bghl102a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs102a().bghl102a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs102a().bghl102a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs102a().bghl102a().argumento().tsMovimento().set(wsTsMovimento);
        hrMghs102a().bghl102a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            progStatus.set(hrMghs102a().bghl102a().cRetorno());
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a53200VerificaContaHo() {
        log(TraceLevel.Debug, "--- PGHO090A A53200-VERIFICA-CONTA-HO ---");
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
        if (wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().isEqual("E")) {
            if (wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr());
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
        log(TraceLevel.Debug, "--- PGHO090A A53300-OBTEM-TAXA ---");
        hrMghs802a().bghl802a().initialize() ;
        hrMghs802a().bghl802a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs802a().bghl802a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs802a().bghl802a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs802a().bghl802a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs802a().bghl802a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs802a().bghl802a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs802a().bghl802a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs802a().bghl802a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghs802a().bghl802a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
    protected void a53400VerInfAdiApl() {
        log(TraceLevel.Debug, "--- PGHO090A A53400-VER-INF-ADI-APL ---");
        /**
         * *-------------------------------------------------------------*
         * CONTROLO DO ARRANQUE DAS APLICACOES
         * INFORMACAO ADICIONAL
         */
        bghw0013().tbAplDtArr().itemApl().resetIndex() ;
        while (bghw0013().tbAplDtArr().itemApl().index().isLessOrEqual(10)) {
            if (wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().get(1, 10).isGreaterOrEqual(bghw0013().tbAplDtArr().itemApl().getCurrent().tabZArranq()) && 
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().isEqual(bghw0013().tbAplDtArr().itemApl().getCurrent().tabAAplic())) {
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set("S");
                break;
            }
            bghw0013().tbAplDtArr().itemApl().incIndex() ;
        }
        if (bghw0013().tbAplDtArr().itemApl().atEnd()) {
            wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set("N");
        }
    }
    
    /**
     * 
     * PRC19 - INI
     * 
     */
    protected void a56000ObtemHst() {
        log(TraceLevel.Debug, "--- PGHO090A A56000-OBTEM-HST ---");
        a56700ValidaDatas() ;
        if (progOk.isTrue() && !hrMghs210a().bghl210a().naoExisteConta().isTrue()) {
            switch (hrMghs210a().bghl210a().detalhe().nmRecurso().get()) {
                case "VGH02301":
                    a56100AcederTgh00023() ;
                    break;
                case "VGH02401":
                    a56200AcederTgh00024() ;
                    break;
                case "VGH02501":
                    a56300AcederTgh00025() ;
                    break;
                case "VGH02601":
                    a56400AcederTgh00026() ;
                    break;
                case "VGH02701":
                    a56500AcederTgh00027() ;
                    break;
                case "VGH02801":
                    a56600AcederTgh00028() ;
                    break;
                default :
                    break ;
            }
            if (msgOut().msg().ade().iMsgCtnd().isEqual("N") || 
                wsMovFalta.isGreater(0)) {
                if (!hrMghs210a().bghl210a().detalhe().nmRecurso().isEqual("VGH00201") && 
                    !hrMghs210a().bghl210a().detalhe().nmRecurso().isEmpty()) {
                    if (msgIn().msg().ade().ascendente().isTrue()) {
                        wTimestamp().wDataTimestamp().wAnoAa().add(1);
                        wTimestamp().wDataTimestamp().wMesMm().set(1);
                        wTimestamp().wDataTimestamp().wDiaDd().set(1);
                        wTimestamp().wTimerTimestamp().wHora().set(0);
                        wTimestamp().wTimerTimestamp().wMinuto().set(0);
                        wTimestamp().wTimerTimestamp().wSegundo().set(0);
                        wTimestamp().wTimerTimestamp().wResto().set(0);
                        msgIn().msg().ade().tsMovimento().set(wTimestamp());
                    } else {
                        wTimestamp().wDataTimestamp().wAnoAa().subtract(1);
                        wTimestamp().wDataTimestamp().wMesMm().set(12);
                        wTimestamp().wDataTimestamp().wDiaDd().set(31);
                        wTimestamp().wTimerTimestamp().wHora().set(23);
                        wTimestamp().wTimerTimestamp().wMinuto().set(59);
                        wTimestamp().wTimerTimestamp().wSegundo().set(59);
                        wTimestamp().wTimerTimestamp().wResto().set(999999);
                        msgIn().msg().ade().tsMovimento().set(wTimestamp());
                    }
                } else {
                    /**
                     * FORÇA ESTE RECURSO PARA SAIR DO CICLO
                     */
                    hrMghs210a().bghl210a().detalhe().nmRecurso().set("VGH00201");
                    if (msgIn().msg().ade().descendente().isTrue()) {
                        wTimestamp().wDataTimestamp().wAnoAa().subtract(1);
                        wTimestamp().wDataTimestamp().wMesMm().set(12);
                        wTimestamp().wDataTimestamp().wDiaDd().set(31);
                        wTimestamp().wTimerTimestamp().wHora().set(23);
                        wTimestamp().wTimerTimestamp().wMinuto().set(59);
                        wTimestamp().wTimerTimestamp().wSegundo().set(59);
                        wTimestamp().wTimerTimestamp().wResto().set(999999);
                        msgIn().msg().ade().tsMovimento().set(wTimestamp());
                    }
                }
            }
        } else if (hrMghs210a().bghl210a().naoExisteConta().isTrue()) {
            /**
             * MOVE W-TIMESTAMP     TO BGHM0900-TS-MOVIMENTO
             */
            if (msgIn().msg().ade().ascendente().isTrue()) {
                wTimestamp().wDataTimestamp().wAnoAa().add(1);
                wTimestamp().wDataTimestamp().wMesMm().set(1);
                wTimestamp().wDataTimestamp().wDiaDd().set(1);
            } else {
                /**
                 * MOVE W-TIMESTAMP     TO BGHM0900-TS-MOVIMENTO
                 */
                wTimestamp().wDataTimestamp().wAnoAa().subtract(1);
                wTimestamp().wDataTimestamp().wMesMm().set(12);
                wTimestamp().wDataTimestamp().wDiaDd().set(31);
            }
            progOk.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56700ValidaDatas() {
        log(TraceLevel.Debug, "--- PGHO090A A56700-VALIDA-DATAS ---");
        hrMghs210a().bghl210a().initialize() ;
        hrMghs210a().bghl210a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs210a().bghl210a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs210a().bghl210a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs210a().bghl210a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs210a().bghl210a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs210a().bghl210a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs210a().bghl210a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs210a().bghl210a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        /**
         * IF BGHM0900-ASCENDENTE
         * MOVE BGHM0900-TS-MOVIMENTO TO W-TIMESTAMP
         * END-IF
         */
        hrMghs210a().bghl210a().argumento().zaInicio().set(wTimestamp().wDataTimestamp().wAnoAa());
        hrMghs210a().run() ;
        if (!hrMghs210a().bghl210a().ok().isTrue() && !hrMghs210a().bghl210a().naoExisteConta().isTrue()) {
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
    protected void a56100AcederTgh00023() {
        log(TraceLevel.Debug, "--- PGHO090A A56100-ACEDER-TGH00023 ---");
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
        hrMghs023a().bghl023a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs023a().bghl023a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs023a().bghl023a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs023a().run() ;
        if (!hrMghs023a().bghl023a().ok().isTrue() && !hrMghs023a().bghl023a().naoExiste().isTrue()) {
            progStatus.set(hrMghs023a().bghl023a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs023a().bghl023a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00023");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (hrMghs023a().bghl023a().ok().isTrue()) {
            if (hrMghs023a().bghl023a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs023a().bghl023a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs023a().bghl023a().tabela().lista().setIndex(1); hrMghs023a().bghl023a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs023a().bghl023a().tabela().lista().incIndex()) {
                hrMghs023a().bghl023a().argumento().set(hrMghs023a().bghl023a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs023a().bghl023a().detalhe().set(hrMghs023a().bghl023a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(hrMghs023a().bghl023a().argumento().tsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs023a().bghl023a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs023a().bghl023a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs023a().bghl023a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs023a().bghl023a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs023a().bghl023a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs023a().bghl023a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs023a().bghl023a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs023a().bghl023a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs023a().bghl023a().detalhe().mSldoDpnlApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs023a().bghl023a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs023a().bghl023a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs023a().bghl023a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs023a().bghl023a().detalhe().iExisInfAdi());
                if (hrMghs023a().bghl023a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs023a().bghl023a().argumento().tsMovimento());
                    a56310ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                    }
                }
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        } else {
            msgOut().msg().ade().iMsgCtnd().set("N");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56200AcederTgh00024() {
        log(TraceLevel.Debug, "--- PGHO090A A56200-ACEDER-TGH00024 ---");
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
        hrMghs023a().bghl023a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs023a().bghl023a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs023a().bghl023a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs024a().run() ;
        if (!hrMghs024a().bghl024a().ok().isTrue() && !hrMghs024a().bghl024a().naoExiste().isTrue()) {
            progStatus.set(hrMghs024a().bghl024a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs024a().bghl024a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00024");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (hrMghs024a().bghl024a().ok().isTrue()) {
            if (hrMghs024a().bghl024a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs024a().bghl024a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs024a().bghl024a().tabela().lista().setIndex(1); hrMghs024a().bghl024a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs024a().bghl024a().tabela().lista().incIndex()) {
                hrMghs024a().bghl024a().argumento().set(hrMghs024a().bghl024a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs024a().bghl024a().detalhe().set(hrMghs024a().bghl024a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(hrMghs024a().bghl024a().argumento().tsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs024a().bghl024a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs024a().bghl024a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs024a().bghl024a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs024a().bghl024a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs024a().bghl024a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs024a().bghl024a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs024a().bghl024a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs024a().bghl024a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs024a().bghl024a().detalhe().mSldoDpnlApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs024a().bghl024a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs024a().bghl024a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs024a().bghl024a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs024a().bghl024a().detalhe().iExisInfAdi());
                if (hrMghs024a().bghl024a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs024a().bghl024a().argumento().tsMovimento());
                    a56310ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                    }
                }
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        } else {
            msgOut().msg().ade().iMsgCtnd().set("N");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56300AcederTgh00025() {
        log(TraceLevel.Debug, "--- PGHO090A A56300-ACEDER-TGH00025 ---");
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
        hrMghs025a().bghl025a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs025a().bghl025a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs025a().bghl025a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs025a().run() ;
        if (!hrMghs025a().bghl025a().ok().isTrue() && !hrMghs025a().bghl025a().naoExiste().isTrue()) {
            progStatus.set(hrMghs025a().bghl025a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs025a().bghl025a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00025");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (hrMghs025a().bghl025a().ok().isTrue()) {
            if (hrMghs025a().bghl025a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs025a().bghl025a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs025a().bghl025a().tabela().lista().setIndex(1); hrMghs025a().bghl025a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs025a().bghl025a().tabela().lista().incIndex()) {
                hrMghs025a().bghl025a().argumento().set(hrMghs025a().bghl025a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs025a().bghl025a().detalhe().set(hrMghs025a().bghl025a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(hrMghs025a().bghl025a().argumento().tsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs025a().bghl025a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs025a().bghl025a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs025a().bghl025a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs025a().bghl025a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs025a().bghl025a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs025a().bghl025a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs025a().bghl025a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs025a().bghl025a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs025a().bghl025a().detalhe().mSldoDpnlApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs025a().bghl025a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs025a().bghl025a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs025a().bghl025a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs025a().bghl025a().detalhe().iExisInfAdi());
                if (hrMghs025a().bghl025a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs025a().bghl025a().argumento().tsMovimento());
                    a56310ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                    }
                }
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        } else {
            msgOut().msg().ade().iMsgCtnd().set("N");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56400AcederTgh00026() {
        log(TraceLevel.Debug, "--- PGHO090A A56400-ACEDER-TGH00026 ---");
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
        hrMghs026a().bghl026a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs026a().bghl026a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs026a().bghl026a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs026a().run() ;
        if (!hrMghs026a().bghl026a().ok().isTrue() && !hrMghs026a().bghl026a().naoExiste().isTrue()) {
            progStatus.set(hrMghs026a().bghl026a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs026a().bghl026a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00026");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (hrMghs026a().bghl026a().ok().isTrue()) {
            if (hrMghs026a().bghl026a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs026a().bghl026a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs026a().bghl026a().tabela().lista().setIndex(1); hrMghs026a().bghl026a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs026a().bghl026a().tabela().lista().incIndex()) {
                hrMghs026a().bghl026a().argumento().set(hrMghs026a().bghl026a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs026a().bghl026a().detalhe().set(hrMghs026a().bghl026a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(hrMghs026a().bghl026a().argumento().tsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs026a().bghl026a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs026a().bghl026a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs026a().bghl026a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs026a().bghl026a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs026a().bghl026a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs026a().bghl026a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs026a().bghl026a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs026a().bghl026a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs026a().bghl026a().detalhe().mSldoDpnlApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs026a().bghl026a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs026a().bghl026a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs026a().bghl026a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs026a().bghl026a().detalhe().iExisInfAdi());
                if (hrMghs026a().bghl026a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs026a().bghl026a().argumento().tsMovimento());
                    a56310ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                    }
                }
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        } else {
            msgOut().msg().ade().iMsgCtnd().set("N");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56500AcederTgh00027() {
        log(TraceLevel.Debug, "--- PGHO090A A56500-ACEDER-TGH00027 ---");
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
        hrMghs027a().bghl027a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs027a().bghl027a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs027a().bghl027a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs027a().run() ;
        if (!hrMghs027a().bghl027a().ok().isTrue() && !hrMghs027a().bghl027a().naoExiste().isTrue()) {
            progStatus.set(hrMghs027a().bghl027a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs027a().bghl027a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00027");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (hrMghs027a().bghl027a().ok().isTrue()) {
            if (hrMghs027a().bghl027a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs027a().bghl027a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs027a().bghl027a().tabela().lista().setIndex(1); hrMghs027a().bghl027a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs027a().bghl027a().tabela().lista().incIndex()) {
                hrMghs027a().bghl027a().argumento().set(hrMghs027a().bghl027a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs027a().bghl027a().detalhe().set(hrMghs027a().bghl027a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(hrMghs027a().bghl027a().argumento().tsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs027a().bghl027a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs027a().bghl027a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs027a().bghl027a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs027a().bghl027a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs027a().bghl027a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs027a().bghl027a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs027a().bghl027a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs027a().bghl027a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs027a().bghl027a().detalhe().mSldoDpnlApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs027a().bghl027a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs027a().bghl027a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs027a().bghl027a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs027a().bghl027a().detalhe().iExisInfAdi());
                if (hrMghs027a().bghl027a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs027a().bghl027a().argumento().tsMovimento());
                    a56310ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                    }
                }
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        } else {
            msgOut().msg().ade().iMsgCtnd().set("N");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56600AcederTgh00028() {
        log(TraceLevel.Debug, "--- PGHO090A A56600-ACEDER-TGH00028 ---");
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
        hrMghs028a().bghl028a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs028a().bghl028a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs028a().bghl028a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMghs028a().run() ;
        if (!hrMghs028a().bghl028a().ok().isTrue() && !hrMghs028a().bghl028a().naoExiste().isTrue()) {
            progStatus.set(hrMghs028a().bghl028a().cRetorno());
            envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs028a().bghl028a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00028");
            envOut.errosGraves().aAplErr().set(WS_APL_HST);
        }
        if (hrMghs028a().bghl028a().ok().isTrue()) {
            if (hrMghs028a().bghl028a().qItens().isLessOrEqual(wsMovFalta)) {
                wsQItens.set(hrMghs028a().bghl028a().qItens());
            } else {
                wsQItens.set(wsMovFalta);
            }
            wsMovFalta.set(subtract(wsMovFalta, wsQItens));
            for (hrMghs028a().bghl028a().tabela().lista().setIndex(1); hrMghs028a().bghl028a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isLessOrEqual(0); hrMghs028a().bghl028a().tabela().lista().incIndex()) {
                hrMghs028a().bghl028a().argumento().set(hrMghs028a().bghl028a().tabela().lista().getCurrent().item().itemArgumento());
                hrMghs028a().bghl028a().detalhe().set(hrMghs028a().bghl028a().tabela().lista().getCurrent().item().itemDetalhe());
                wsTabelaMovimento().wsMovimentos().getCurrent().waTsMovimento().set(hrMghs028a().bghl028a().argumento().tsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento().set(hrMghs028a().bghl028a().argumento().nsMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov().set(hrMghs028a().bghl028a().detalhe().zValMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghs028a().bghl028a().detalhe().xRefMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovimento().set(hrMghs028a().bghl028a().detalhe().mMovimento());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr().set(hrMghs028a().bghl028a().detalhe().iDbcr());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno().set(hrMghs028a().bghl028a().detalhe().iEstorno());
                wsTabelaMovimento().wsMovimentos().getCurrent().waCMoedIsoOriMov().set(hrMghs028a().bghl028a().detalhe().cMoedIsoOriMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().set(hrMghs028a().bghl028a().detalhe().mSldoCbloApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(hrMghs028a().bghl028a().detalhe().mSldoDpnlApos());
                wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs028a().bghl028a().detalhe().mMovMoeOrigMov());
                wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs028a().bghl028a().detalhe().nDocOpps());
                wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs028a().bghl028a().detalhe().aAplOrig());
                wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs028a().bghl028a().detalhe().iExisInfAdi());
                if (hrMghs028a().bghl028a().detalhe().xRefMov().isEmpty()) {
                    wsTsMovimento.set(hrMghs028a().bghl028a().argumento().tsMovimento());
                    a56310ObtemDescritivoMov() ;
                } else {
                    a53200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wsTJuro.set(0);
                    a53300ObtemTaxa() ;
                    if (wsTJuro.isGreater(0)) {
                        wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                    }
                }
                wsTotEnvr.add(1);
                wsTabelaMovimento().wsMovimentos().incIndex() ;
            }
        } else {
            msgOut().msg().ade().iMsgCtnd().set("N");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56310ObtemDescritivoMov() {
        log(TraceLevel.Debug, "--- PGHO090A A56310-OBTEM-DESCRITIVO-MOV ---");
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(wsTabelaMovimento().wsMovimentos().getCurrent().waIDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(wsTabelaMovimento().wsMovimentos().getCurrent().waIEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(wsTabelaMovimento().wsMovimentos().getCurrent().waZValMov());
        a56311ObterCOeOpex() ;
        if (progOk.isTrue()) {
            a56312ObtemCOpeBbn() ;
        }
        if (progOk.isTrue()) {
            if (hrMghk800a().bghl800a().input().cOpeBbn().isEmpty()) {
                wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(" ");
            } else {
                hrMghk800a().run() ;
                if (hrMghk800a().bghl800a().ok().isTrue()) {
                    wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
                    wsCTipoTrttCont.set(hrMghk800a().bghl800a().output().cTipoTrttCont());
                } else {
                    wsTabelaMovimento().wsMovimentos().getCurrent().waXRefMov().set(" ");
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a56311ObterCOeOpex() {
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
        log(TraceLevel.Debug, "--- PGHO090A A53111-ACEDER-TGH00123 ---");
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
        hrMghs123a().bghl123a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53112-ACEDER-TGH00124 ---");
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
        hrMghs124a().bghl124a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53113-ACEDER-TGH00125 ---");
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
        hrMghs125a().bghl125a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53114-ACEDER-TGH00126 ---");
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
        hrMghs126a().bghl126a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53115-ACEDER-TGH00127 ---");
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
        hrMghs127a().bghl127a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53116-ACEDER-TGH00128 ---");
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
        hrMghs128a().bghl128a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
    protected void a56312ObtemCOpeBbn() {
        log(TraceLevel.Debug, "--- PGHO090A A56312-OBTEM-C-OPE-BBN ---");
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
        log(TraceLevel.Debug, "--- PGHO090A A53121-ACEDER-TGH00123 ---");
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
        hrMghs123a().bghl123a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53122-ACEDER-TGH00124 ---");
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
        hrMghs124a().bghl124a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53123-ACEDER-TGH00125 ---");
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
        hrMghs125a().bghl125a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53124-ACEDER-TGH00126 ---");
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
        hrMghs126a().bghl126a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53125-ACEDER-TGH00127 ---");
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
        hrMghs127a().bghl127a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
        log(TraceLevel.Debug, "--- PGHO090A A53126-ACEDER-TGH00128 ---");
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
        hrMghs128a().bghl128a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
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
     * PRC19 - FIM
     * 
     */
    protected void s70000Responder() {
        log(TraceLevel.Debug, "--- PGHO090A S70000-RESPONDER ---");
        if (progOk.isTrue()) {
            if (wsTotEnvr.isEqual(0)) {
                progNaoExisteMov.setTrue() ;
                envOut.errosGraves().aAplErr().set(WS_APL_HST);
                envOut.errosGraves().cTipoErroBbn().set(WS_ERR_FUNC);
            } else {
                a71000DescarregaTabela() ;
            }
        }
        envOut.errosGraves().cRtnoEvenSwal().set(progStatus);
        if (progOk.isTrue()) {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont0().setTrue() ;
        } else {
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
    protected void a71000DescarregaTabela() {
        log(TraceLevel.Debug, "--- PGHO090A A71000-DESCARREGA-TABELA ---");
        naoHaMais.setTrue() ;
        if (wsTotEnvr.isGreater(12)) {
            haMais.setTrue() ;
        }
        msgOut().msg().ade().grMov().resetIndex() ;
        wsTotEnvr.set(1);
        naoSair.setTrue() ;
        while (wsTotEnvr.isLessOrEqual(12) && !sair.isTrue()) {
            if (wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waTsMovimento().isEmpty()) {
                sair.setTrue() ;
            } else {
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waTsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimento().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waNsMovimento());
                msgOut().msg().ade().grMov().getCurrent().zValMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waZValMov());
                msgOut().msg().ade().grMov().getCurrent().xRefMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waXRefMov());
                msgOut().msg().ade().grMov().getCurrent().mMovimento().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waMMovimento());
                msgOut().msg().ade().grMov().getCurrent().iDbcr().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waIDbcr());
                msgOut().msg().ade().grMov().getCurrent().iEstorno().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waIEstorno());
                msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waCMoedIsoOriMov());
                msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waMSldoCbloApos());
                msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waMSldoDpnlApos());
                msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waMMovMoeOrigMov());
                msgOut().msg().ade().grMov().getCurrent().nDocOpps().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waNDocOpps());
                msgOut().msg().ade().grMov().getCurrent().aAplOrig().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waAAplOrig());
                msgOut().msg().ade().grMov().getCurrent().tJuro().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waTJuro());
                msgOut().msg().ade().grMov().getCurrent().iExisInfAdi().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waIExisInfAdi());
                wsTotEnvr.add(1);
                msgOut().msg().ade().grMov().incIndex() ;
            }
        }
        if (haMais.isTrue()) {
            msgOut().msg().ade().iMsgCtnd().set("S");
            msgOut().msg().ade().tsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(12).waTsMovimento());
            msgOut().msg().ade().nsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(12).waNsMovimento());
        } else {
            if (!wsTabelaMovimento().wsMovimentos().get(12).waNsMovimento().isEqual(0)) {
                msgOut().msg().ade().tsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(12).waTsMovimento());
                msgOut().msg().ade().nsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(12).waNsMovimento());
            }
            msgOut().msg().ade().iMsgCtnd().set("N");
            envOut.errosGraves().cTipoErroBbn().set(WS_FIM_CONSULTA);
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        log(TraceLevel.Debug, "*** INICIO DO PROGRAMA PGHO090A ***");
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
    
    /**
     * 
     * PRC19 - INI
     * 
     * @version 2.0
     * 
     */
    public interface WsTsAux extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTsAux
         */
        @Data(rpadding=16)
        WDataTsAux wDataTsAux() ;
        
        
        public interface WDataTsAux extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAux() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesAux() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaAux() ;
            
        }
    }
    
    /**
     * 
     * PRC19 - FIM
     * 
     * @version 2.0
     * 
     */
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
    public interface WsTabelaMovimento extends IDataStruct {
        
        /**
         * @return instancia da classe local WsMovimentos
         */
        @Data(length=13)
        IArray<WsMovimentos> wsMovimentos() ;
        
        
        public interface WsMovimentos extends IDataStruct {
            
            
            @Data(size=26)
            IString waTsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong waNsMovimento() ;
            
            @Data(size=10)
            IString waZValMov() ;
            
            @Data(size=21)
            IString waXRefMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal waMMovimento() ;
            
            @Data(size=1)
            IString waIDbcr() ;
            
            @Data(size=1)
            IString waIEstorno() ;
            
            @Data(size=3)
            IString waCMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal waMSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal waMSldoDpnlApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal waMMovMoeOrigMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong waNDocOpps() ;
            
            @Data(size=2)
            IString waAAplOrig() ;
            
            @Data(size=5, decimal=3, signed=true, compression=COMP3)
            IDecimal waTJuro() ;
            
            @Data(size=1)
            IString waIExisInfAdi() ;
            
        }
    }
    
}
