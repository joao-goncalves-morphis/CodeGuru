package cgd.gh.online;

import morphis.framework.server.controller.PersistenceCode ;
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
import cgd.gh.persistence.database.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV2 ;
import cgd.framework.envelope.CgdMessageV2 ;
import cgd.framework.envelope.CgdFooterV2 ;
import cgd.gh.structures.messages.Bghm1110 ;
import cgd.gh.structures.messages.Bghm1111 ;
import cgd.hj.structures.link.Bhjl001a ;
import cgd.hy.structures.link.Bhyl025a ;
import cgd.hy.structures.link.Bhyl008a ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.structures.work.Bghw0013 ;
import cgd.hy.routines.Mhyj025a ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.hy.routines.Mhyj008a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.gh.routines.Mghs003a ;
import cgd.gh.routines.Mghs001a ;
import cgd.gh.routines.Mghs010a ;
import cgd.hj.routines.Mhjj060a ;
import cgd.hj.routines.Mhjj200a ;
import cgd.ho.routines.Mhoj354a ;
import cgd.gh.routines.Mghs002a ;
import cgd.gh.routines.Mghs102a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghj801a ;
import cgd.gh.routines.Mghs802a ;
import cgd.gh.routines.Mghs022a ;
import cgd.gh.routines.Mghs804a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS111A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1345
 * FUNCAO     : LISTA DETALHE DOS MOVIMENTOS DE UMA SUBCONTA
 * TIPO       : ONLINE COM DB2
 * LOG DE ALTERACOES
 * PROCESSO GIP !   DATA   ! UTILIZADOR ! OBSERVACOES
 * GH1345     2014-05-21 DACT350-ACC   CRIACAO
 * GH1862     2016-05-04               CRIACAO V3 - OFFLOAD
 * GH1979     2017-01-17               CORRECAO OBTENCAO SEMAF
 * GH1978     2017-01-17               TESTES COM PCE E WAI
 * GH2016     2017-04-03 E001881-ACC   ALTERACAO ACESSO TGH2
 * GH2080     2018-04-17 E001881-ACC   RETIRAR 1 OCORRENCIA
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs111a extends CgdGhBaseOnline<Pghs111a.EnvelopeIn, Pghs111a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1110
     */
    public abstract Bghm1110 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1111
     */
    public abstract Bghm1111 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm1110.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm1111.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV2, MessageIn, CgdFooterV2, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV2, MessageOut, CgdFooterV2, CgdEnvelope {
    }
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps02201Movdiaant
     */
    @Data
    protected abstract Vwsdghps02201Movdiaant hv02201Movdiaant() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyj025a
     */
    @Data
    protected abstract Mhyj025a hrMhyj025a() ;
    
    /**
     * @return instancia da classe Mhyj008a
     */
    @Data
    protected abstract Mhyj008a hrMhyj008a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    /**
     * @return instancia da classe Mghs003a
     */
    @Data
    protected abstract Mghs003a hrMghs003a() ;
    
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
     * @return instancia da classe Mhoj354a
     */
    @Data
    protected abstract Mhoj354a hrMhoj354a() ;
    
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
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhjl001a
     */
    @Data
    protected abstract Bhjl001a bhjl001a() ;
    
    /**
     * @return instancia da classe Bhyl025a
     */
    @Data
    protected abstract Bhyl025a bhyl025a() ;
    
    /**
     * @return instancia da classe Bhyl008a
     */
    @Data
    protected abstract Bhyl008a bhyl008a() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bghw0013
     */
    @Data
    protected abstract Bghw0013 bghw0013() ;
    
    protected static final int CON_1 = 1 ;
    
    protected static final String CON_23 = "-23.59.59.999999" ;
    
    protected static final String CON_00 = "-00.00.00.000000" ;
    
    protected static final String CON_DATA_MINIMA = "0001-01-01" ;
    
    protected static final String CON_DEBITO = "D" ;
    
    protected static final String CON_CREDITO = "C" ;
    
    protected static final String CON_APL_HST = "GH" ;
    
    protected static final String CON_ERR_FUNC = "FU" ;
    
    protected static final String CON_ERRO = "A1" ;
    
    protected static final String CON_ERR_DB2 = "A2" ;
    
    protected static final String CON_FIM_CONSULTA = "FC" ;
    
    /**
     * VARIAVEIS
     * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    @Data(size=3, value="0")
    protected IInt wsDuTipoPraz ;
    
    @Data(size=2, value="0")
    protected IInt wsQItens ;
    
    @Data(size=2, value="13")
    protected IInt wsQItensMax ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH00201")
    protected IString wsRecursoVgh00201 ;
    
    @Data(size=8, value="MHOJ354A")
    protected IString bhol354aNmRotina ;
    
    @Data(size=8, value="MGHS003A")
    protected IString mgh003aNmRotina ;
    
    @Data(size=8, value="MGHK800A")
    protected IString mgh800aCRotina ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString mghj801aCRotina ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsCEibresp ;
    
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
    
    
    /**
     * 01 WS-TOT-MOV-MAX                      PIC 9(2) VALUE 67.
     */
    @Data(size=2, value="66")
    protected IInt wsTotMovMax ;
    
    @Data(size=2, value="0")
    protected IInt wsTotEnvr ;
    
    @Data(size=10, value=" ")
    protected IString wsDataDb2 ;
    
    @Data(size=26, value=" ")
    protected IString wsTimeExe ;
    
    /**
     * @return instancia da classe local WsTs
     */
    @Data
    protected abstract WsTs wsTs() ;
    
    @Data(size=26, value=" ")
    protected IString wsTsTgh1 ;
    
    @Data(size=26, value=" ")
    protected IString wsTsTgh2 ;
    
    /**
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
     * SWITCHES
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
    
    
    @Data(size=1, value="N")
    protected IString swControloCiclo ;
    @Data
    @Condition("A")
    protected ICondition swAcabou ;
    @Data
    @Condition("N")
    protected ICondition swNAcabou ;
    
    
    @Data(size=1)
    protected IString swControlo3 ;
    @Data
    @Condition("A")
    protected ICondition primeiraVez ;
    @Data
    @Condition("B")
    protected ICondition segundaVez ;
    
    
    @Data(size=1, value=" ")
    protected IString swCrtCanal ;
    @Data
    @Condition("A")
    protected ICondition balcao ;
    
    
    @Data(size=1, value=" ")
    protected IString swCrtMovHst ;
    @Data
    @Condition("S")
    protected ICondition swMovHstS ;
    @Data
    @Condition("N")
    protected ICondition swMovHstN ;
    
    
    @Data(size=1, value=" ")
    protected IString swCrtSair ;
    @Data
    @Condition("1")
    protected ICondition naoSair ;
    @Data
    @Condition("2")
    protected ICondition sair ;
    
    
    @Data(size=1, value=" ")
    protected IString swCrtMais ;
    @Data
    @Condition("1")
    protected ICondition naoHaMais ;
    @Data
    @Condition("2")
    protected ICondition haMais ;
    
    
    @Data(size=1, value=" ")
    protected IString swCrtMov ;
    @Data
    @Condition("N")
    protected ICondition naoHaMov ;
    @Data
    @Condition("S")
    protected ICondition haMov ;
    
    
    
    
    /**
     * 
     * COPY DE PROCEDURE DE ACESSO ROTINA MHYJ025A
     * 
     */
    protected void bhyp0025Mhyj025a() {
        hrMhyj025a().run() ;
    }
    
    /**
     * 
     * COPY DE PROCEDURE DE ACESSO ROTINA MHYJ008A
     * 
     */
    protected void bhyp0008Mhyj008a() {
        hrMhyj008a().run() ;
    }
    
    /**
     * 
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
        hrMhyj230a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "------ PGHS111A - 0000-MAINLINE ------");
        m1000InicioPrograma() ;
        if (progOk.isTrue()) {
            m2000ProcessoPrograma() ;
        }
        m3000Responder() ;
        exit() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * INICIA VARIAVEIS  ASSOCIADAS AO PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "--- PGHS111A - 1000-INICIO-PROGRAMA");
        wsDataDb2.set( getDBDate() ) ;
        wsTimeExe.set( getDBTimestamp() ) ;
        log(TraceLevel.Debug, "WS-DATA-DB2: ", wsDataDb2);
        log(TraceLevel.Debug, "WS-TIME-EXE: ", wsTimeExe);
        hrMghs804a().bghl804a().initialize() ;
        msgIn().msg().initialize() ;
        msgOut().msg().initialize() ;
        swCrtCanal.initialize() ;
        wsTabelaMovimento().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        log(TraceLevel.Debug, "============================================");
        log(TraceLevel.Debug, "========== V R 0 4 = I N P U T =============");
        log(TraceLevel.Debug, "============================================");
        log(TraceLevel.Debug, " BGHM1110-C-PAIS-ISOA-CONT : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, " BGHM1110-C-BANC-CONT      : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, " BGHM1110-C-OE-EGC-CONT    : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, " BGHM1110-NS-RDCL-CONT     : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, " BGHM1110-V-CHKD-CONT      : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, " BGHM1110-C-TIPO-CONT      : ", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, " BGHM1110-C-MOED-ISO-SCTA  : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, " BGHM1110-NS-DEPOSITO      : ", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, " BGHM1110-TS-MOVIMENTO     : ", msgIn().msg().ade().tsMovimento());
        log(TraceLevel.Debug, " BGHM1110-NS-MOVIMENTO     : ", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, " BGHM1110-I-CONSULTA       : ", msgIn().msg().ade().iConsulta());
        log(TraceLevel.Debug, " BGHM1110-TS-MOV-MAX       : ", msgIn().msg().ade().tsMovMax());
        log(TraceLevel.Debug, " BGHM1110-I-CRIT-CL        : ", msgIn().msg().ade().iCritCl());
        log(TraceLevel.Debug, " BGHM1110-I-CRIT-MONTANTE  : ", msgIn().msg().ade().iCritMontante());
        log(TraceLevel.Debug, " BGHM1110-I-CRIT-DBCR      : ", msgIn().msg().ade().iCritDbcr());
        log(TraceLevel.Debug, " BGHM1110-Z-MOV-INI        : ", msgIn().msg().ade().zMovIni());
        log(TraceLevel.Debug, " BGHM1110-Z-MOV-FIM        : ", msgIn().msg().ade().zMovFim());
        log(TraceLevel.Debug, " BGHM1110-C-TIT-HONO       : ", msgIn().msg().ade().cTitHono());
        log(TraceLevel.Debug, " BGHM1110-NM-CLI-ABVD      : ", msgIn().msg().ade().nmCliAbvd());
        log(TraceLevel.Debug, " BGHM1110-I-MSG-CTND       : ", msgIn().msg().ade().iMsgCtnd());
        log(TraceLevel.Debug, " ............................");
        log(TraceLevel.Debug, " BGHM1110-TS-MOVIMENTO-K   : ", msgIn().msg().ade().tsMovimentoK());
        log(TraceLevel.Debug, " BGHM1110-NS-MOVIMENTO-K   : ", msgIn().msg().ade().nsMovimentoK());
        log(TraceLevel.Debug, " ............................");
        log(TraceLevel.Debug, " BGHM1110-Q-MOVIMENTOS     : ", msgIn().msg().ade().qMovimentos());
        log(TraceLevel.Debug, " BGHM1110-Q-MOV-CNSL       : ", msgIn().msg().ade().qMovCnsl());
        log(TraceLevel.Debug, " BGHM1110-I-BLOCO          : ", msgIn().msg().ade().iBloco());
        progOk.setTrue() ;
        msgOut().msg().ade().grMov().resetIndex() ;
        naoHaMais.setTrue() ;
        if (progOk.isTrue()) {
            m1100ValidaInput() ;
        }
        if (progOk.isTrue()) {
            m1200ValidaTsMov() ;
        }
        /**
         * IF  BHTL010A-NS-VERS-MSG = 3
         */
        if (messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1) && 
            msgIn().msg().ade().qMovCnsl().isLess(wsTotMovMax)) {
            /**
             * PARA A CHAMADA AS ROTINAS DEVOLVEREM SO AS QUE PRECISAMOS
             */
            if (wsTotMovMax.isLess(wsQItensMax)) {
                wsQItensMax.set(wsTotMovMax);
            }
        }
        /**
         * CALCULA DATA MAXIMA NOS SD
         * IF BHTL010A-NS-VERS-MSG = 3 AND BGHM1110-I-BLOCO = '0'
         */
        if (messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1) && 
            msgIn().msg().ade().iBloco().isEqual("0") && 
            msgIn().msg().ade().descendente().isTrue()) {
            wsVariaveis().wsDataDispMovSd2().set( getDBDate() ) ;
            /**
             * SE O PERIODO EM CONSULTA ESTA FORA DO PERIODO DE SD SALTA PARA
             * O BLOCO '2', EH ESCUSADO IR AO DISTRIBUIDO PQ JA NAO TEM MOVS
             * EXEMP Z-MOV-FIM 2017-01-26, Z-MOV-INI 2016-01-20, PESQUISA COM
             * MAIS DE 1 ANO, VAI SO AO CENTRAL
             * IF BGHM1110-Z-MOV-FIM <= WS-DATA-DISP-MOV-SD2
             */
            if (msgIn().msg().ade().zMovIni().isLessOrEqual(wsVariaveis().wsDataDispMovSd2())) {
                msgIn().msg().ade().iBloco().set("2");
            }
        }
        /**
         * CONSULTA SEMAFORO DOS SISTEMAS DISTRIBUIDOS PARA
         * AVERIGUAR QUAL A ULTIMA DATA DE MOVIMENTOS CARREGADOS
         * NA APLICACAO DE SISTEMAS DISTRIBUIDOS
         * IF PROG-OK AND BHTL010A-NS-VERS-MSG = 3
         */
        if (progOk.isTrue() && messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1)) {
            m2600ConsultaSemafSd() ;
            /**
             * SE DATA MINIMA EH PORQUE FOI ACCIONADO O
             * BOTAO DE PANICO BGHM1110-I-BLOCO = ' ' OU SEJA TUDO CENTRAL
             * 20160122 - DEFINIDO EM REUNIAO COM ISRAEL CAETANO/WAI/PCE
             */
            if (wsVariaveis().wsDataDispMovSd().isEqual(CON_DATA_MINIMA)) {
                msgIn().msg().ade().iBloco().set(" ");
            } else if (msgIn().msg().ade().zMovIni().isLess(wsVariaveis().wsDataDispMovSd2()) && 
                msgIn().msg().ade().zMovFim().isGreater(wsVariaveis().wsDataDispMovSd())) {
                msgIn().msg().ade().iBloco().set(" ");
            } else if (!wsDuTipoPraz.isEqual(CON_1)) {
                msgIn().msg().ade().iBloco().set(" ");
            }
        }
    }
    
    /**
     * 
     * 1100-VALIDA-INPUT
     * 
     */
    protected void m1100ValidaInput() {
        log(TraceLevel.Debug, "--- PGHS111A - 1100-VALIDA-INPUT");
        if (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            !msgIn().msg().ade().cBancCont().isNumeric() || 
            !msgIn().msg().ade().cOeEgcCont().isNumeric() || 
            !msgIn().msg().ade().nsRdclCont().isNumeric() || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().iConsulta().isEmpty() || 
            msgIn().msg().ade().tsMovimento().isEmpty() || 
            msgIn().msg().ade().tsMovMax().isEmpty() || 
            msgIn().msg().ade().zMovIni().isEmpty() || 
            msgIn().msg().ade().zMovFim().isEmpty() || 
            msgIn().msg().ade().zMovFim().isLess(msgIn().msg().ade().zMovIni())) {
            progDadosInvalidos.setTrue() ;
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            if (messageV2.mensagem().cTipoCanlAces().isEqual("BALC")) {
                balcao.setTrue() ;
            }
        }
        if (progOk.isTrue() && !msgIn().msg().ade().iBloco().isEmpty() && 
            !msgIn().msg().ade().iBloco().isEqual("0") && 
            !msgIn().msg().ade().iBloco().isEqual("2")) {
            progDadosInvalidos.setTrue() ;
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
        }
    }
    
    /**
     * 
     * 1200-VALIDA-TS-MOV
     * 
     */
    protected void m1200ValidaTsMov() {
        log(TraceLevel.Debug, "--- PGHS111A - 1200-VALIDA-TS-MOV");
        if (!msgIn().msg().ade().tsMovimentoK().isEmpty() && 
            !msgIn().msg().ade().nsMovimentoK().isEqual(0)) {
            msgIn().msg().ade().tsMovimento().set(msgIn().msg().ade().tsMovimentoK());
            msgIn().msg().ade().nsMovimento().set(msgIn().msg().ade().nsMovimentoK());
            log(TraceLevel.Debug, " ---------------------------");
            log(TraceLevel.Debug, "  NOVA CHAMADA DO PROGRAMA !");
            log(TraceLevel.Debug, " ---------------------------");
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "--- PGHS111A - 2000-PROCESSO-PROGRAMA");
        /**
         * O PROGRAMA DEVE FUNCIONAR NA FORMA "APENAS CENTRAL" EXCEPTO
         * SE INVOCADO COM VERSAO 3 E I-BLOCO = 0 E PESQUISA DESCENDENTE
         * E NESSE CASO FUNCIONA NA FORMA "MISTA CENTRAL + DISTRIBUIDO"
         * IF BHTL010A-NS-VERS-MSG NOT = 3
         * IF BHTL010A-NS-VERS-MSG NOT = 1
         */
        if ((messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1) && 
            msgIn().msg().ade().iBloco().isEmpty()) || 
            (messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1) && 
            msgIn().msg().ade().iBloco().isEqual("2") && 
            msgIn().msg().ade().descendente().isTrue()) || 
            msgIn().msg().ade().ascendente().isTrue()) {
            m2010AcessoVersao2() ;
        } else {
            m2020AcessoVersao3() ;
        }
    }
    
    /**
     * 
     * 2010-ACESSO-VERSAO-2
     * 
     */
    protected void m2010AcessoVersao2() {
        log(TraceLevel.Debug, "--- PGHS111A - 2010-ACESSO-VERSAO-2");
        /**
         * CONSULTA TGH003:
         * ESTADO H: MOVIMENTOS DE D-1 ESTAO NOS HO S
         * ESTADO A: MOVIMENTOS DE D-1 ESTAO NA TGH022
         * ESTADO I: MOVIMENTOS DE D-1 ESTAO JA EM HISTORICO
         */
        m2100ConsultaGatcnsmov() ;
        /**
         * CONSULTA DATAS DA TGH010 COM RECURSO TGH00002
         */
        if (progOk.isTrue()) {
            m2150ValidaPedido() ;
        }
        if (progOk.isTrue()) {
            if (msgIn().msg().ade().comNmCli().isTrue()) {
                m2200ObtemCliente() ;
            }
        }
        /**
         * NOS CANAIS NAO PRESENCIAIS INICIALMENTE E APURADO O NR DE MOV
         * QUE ESTAO NO INTERVALO DADO PELO UTILIZADOR, ESTE VALOR EH
         * APRESENTADO NO FUNDO DA PAGINA NA CDO P.EX.
         */
        if (progOk.isTrue() && msgIn().msg().ade().qMovimentos().isEqual(0)) {
            m2290ObtemNMovimentos() ;
        } else {
            msgOut().msg().ade().qMovimentos().set(msgIn().msg().ade().qMovimentos());
        }
        log(TraceLevel.Debug, "   --------ORDEM DA CONSULTA  : ", msgIn().msg().ade().iConsulta());
        log(TraceLevel.Debug, "   BGHM1110-TS-MOVIMENTO(1:10): ", msgIn().msg().ade().tsMovimento().get(1, 10));
        log(TraceLevel.Debug, "   MGH003A-Z-HOJE             : ", hrMghs003a().bghl003a().zHoje());
        log(TraceLevel.Debug, "   ");
        log(TraceLevel.Debug, "   PROG-STATUS               : ", progStatus);
        log(TraceLevel.Debug, "   WS-TOT-ENVR               : ", wsTotEnvr);
        swNAcabou.setTrue() ;
        if (progOk.isTrue()) {
            /**
             * ORDEM ASCENDENTE
             */
            if (msgIn().msg().ade().ascendente().isTrue()) {
                if (msgIn().msg().ade().tsMovimento().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                    while (!swAcabou.isTrue() && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                        m2300ObtemMovHst() ;
                    }
                }
                wsVariaveis().wsTsMovimento13().set(" ");
                wsVariaveis().wsZMovimento13().set(" ");
                wsVariaveis().wsNsMovimento13().set(0);
                swNAcabou.setTrue() ;
                if (progOk.isTrue()) {
                    if (wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                        m2400ObtemMovOntem() ;
                    }
                }
                swNAcabou.setTrue() ;
                wsVariaveis().wsTsMovimento13().set(" ");
                wsVariaveis().wsZMovimento13().set(" ");
                wsVariaveis().wsNsMovimento13().set(0);
                log(TraceLevel.Debug, "   BGHM1110-TS-MOV-MAX(1:10) : ", msgIn().msg().ade().tsMovMax().get(1, 10));
                log(TraceLevel.Debug, "   MGH003A-Z-HOJE            : ", hrMghs003a().bghl003a().zHoje());
                log(TraceLevel.Debug, "   ");
                log(TraceLevel.Debug, "   PROG-STATUS               : ", progStatus);
                log(TraceLevel.Debug, "   WS-TOT-ENVR               : ", wsTotEnvr);
                if (progOk.isTrue()) {
                    if (wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
                            while (!swAcabou.isTrue() && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                                m2500ObtemMovDiaHo() ;
                            }
                        }
                    }
                }
            } else {
                /**
                 * ORDEM DESCENDENTE
                 */
                if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
                    while (!swAcabou.isTrue() && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                        m2500ObtemMovDiaHo() ;
                    }
                }
                swNAcabou.setTrue() ;
                wsVariaveis().wsTsMovimento13().set(" ");
                wsVariaveis().wsZMovimento13().set(" ");
                wsVariaveis().wsNsMovimento13().set(0);
                if (progOk.isTrue()) {
                    if (wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                            m2400ObtemMovOntem() ;
                        }
                    }
                }
                swNAcabou.setTrue() ;
                wsVariaveis().wsTsMovimento13().set(" ");
                wsVariaveis().wsZMovimento13().set(" ");
                wsVariaveis().wsNsMovimento13().set(0);
                log(TraceLevel.Debug, "   BGHM1110-TS-MOV-MAX(1:10) : ", msgIn().msg().ade().tsMovMax().get(1, 10));
                log(TraceLevel.Debug, "   MGH003A-Z-HOJE            : ", hrMghs003a().bghl003a().zHoje());
                log(TraceLevel.Debug, "   ");
                log(TraceLevel.Debug, "   PROG-STATUS               : ", progStatus);
                log(TraceLevel.Debug, "   WS-TOT-ENVR               : ", wsTotEnvr);
                if (progOk.isTrue()) {
                    if (wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                        if (msgIn().msg().ade().tsMovMax().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                            while (!swAcabou.isTrue() && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                                m2300ObtemMovHst() ;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 
     * 2020-ACESSO-VERSAO-3
     * 
     */
    protected void m2020AcessoVersao3() {
        log(TraceLevel.Debug, "--- PGHS111A - 2020-ACESSO-VERSAO-3");
        if (msgIn().msg().ade().descendente().isTrue()) {
            if (msgIn().msg().ade().iBloco().isEqual("0")) {
                /**
                 * EM SUBSTITUICAO DA CHAMADA 2100-CONSULTA-GATCNSMOV
                 * POIS NAO PRECISAMOS SABER EM QUE TABELA ESTAO OS GH
                 * SERAO APENAS MOVIMENTOS DO DIA
                 * NO ENTANTO DEVIDO A ATRASOS
                 * QUE PODEM OCORRER NO CAREGAMENTO DO SD MANTEVE-SE
                 * EXEC SQL
                 * SET :MGH003A-Z-HOJE = CURRENT DATE
                 * END-EXEC
                 * CONSULTA TGH003:
                 * ESTADO H: MOVIMENTOS DE D-1 ESTAO NOS HO S
                 * ESTADO A: MOVIMENTOS DE D-1 ESTAO NA TGH022
                 * ESTADO I: MOVIMENTOS DE D-1 ESTAO JA EM HISTORICO
                 */
                m2100ConsultaGatcnsmov() ;
                log(TraceLevel.Debug, "                  NS_MSG = 3; I-BLOCO = 0");
                log(TraceLevel.Debug, "                  WS-TOT-MOV-MAX: ", wsTotMovMax);
                /**
                 * SE MOVIMENTOS A CONSULTAR JA ESTAO TODOS NO DISTRIBUIDOS
                 * INFORMA QUE DEVE SER EFETUADA CONSULTA AO BLOCO 1 (SD)
                 */
                if (progOk.isTrue()) {
                    if (msgIn().msg().ade().zMovFim().isLessOrEqual(wsVariaveis().wsDataDispMovSd())) {
                        msgOut().msg().ade().iBloco().set("1");
                        messageV2.mensagem().cTipoErroBbn().set(CON_FIM_CONSULTA);
                        /**
                         * CONSULTA DATAS DA TGH010 COM RECURSO TGH00002
                         */
                        if (progOk.isTrue()) {
                            m2150ValidaPedido() ;
                        }
                        if (progOk.isTrue()) {
                            if (msgIn().msg().ade().comNmCli().isTrue()) {
                                m2200ObtemCliente() ;
                            }
                        }
                        /**
                         * NOS CANAIS NAO PRESENCIAIS INICIALMENTE E APURADO O NR DE MOV
                         * QUE ESTAO NO INTERVALO DADO PELO UTILIZADOR, ESTE VALOR EH
                         * APRESENTADO NO FUNDO DA PAGINA NA CDO P.EX.
                         */
                        if (progOk.isTrue() && 
                            msgIn().msg().ade().qMovimentos().isEqual(0)) {
                            m2290ObtemNMovimentos() ;
                        } else {
                            msgOut().msg().ade().qMovimentos().set(msgIn().msg().ade().qMovimentos());
                        }
                    } else {
                        if (progOk.isTrue()) {
                            m2150ValidaPedido() ;
                        }
                        if (progOk.isTrue()) {
                            if (msgIn().msg().ade().comNmCli().isTrue()) {
                                m2200ObtemCliente() ;
                            }
                        }
                        /**
                         * NOS CANAIS NAO PRESENCIAIS INICIALMENTE E APURADO O NR DE MOV
                         * QUE ESTAO NO INTERVALO DADO PELO UTILIZADOR
                         */
                        if (progOk.isTrue() && 
                            msgIn().msg().ade().qMovimentos().isEqual(0)) {
                            m2290ObtemNMovimentos() ;
                        } else {
                            msgOut().msg().ade().qMovimentos().set(msgIn().msg().ade().qMovimentos());
                        }
                        log(TraceLevel.Debug, "   --------ORDEM DA CONSULTA  : ", msgIn().msg().ade().iConsulta());
                        log(TraceLevel.Debug, "   BGHM1110-TS-MOVIMENTO(1:10): ", msgIn().msg().ade().tsMovimento().get(1, 10));
                        log(TraceLevel.Debug, "   MGH003A-Z-HOJE             : ", hrMghs003a().bghl003a().zHoje());
                        log(TraceLevel.Debug, "   ");
                        log(TraceLevel.Debug, "   PROG-STATUS               : ", progStatus);
                        log(TraceLevel.Debug, "   WS-TOT-ENVR               : ", wsTotEnvr);
                        swNAcabou.setTrue() ;
                        if (msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
                            while (!swAcabou.isTrue() && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                                m2500ObtemMovDiaHo() ;
                            }
                        }
                        swNAcabou.setTrue() ;
                        wsVariaveis().wsTsMovimento13().set(" ");
                        wsVariaveis().wsZMovimento13().set(" ");
                        wsVariaveis().wsNsMovimento13().set(0);
                        if (progOk.isTrue()) {
                            if (wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                                if (msgIn().msg().ade().tsMovMax().get(1, 10).isLess(hrMghs003a().bghl003a().zHoje())) {
                                    m2400ObtemMovOntem() ;
                                }
                            }
                        }
                        /**
                         * *SE JA ENCHEMOS A PAGINA E A DATA DO MOVIMENTO ESTA ACIMA DO CORTE
                         * *PASSA AO BLOCO SEGUINTE, SENAO CONTINUA NO BLOCO '0'
                         */
                        if (wsTotEnvr.isGreater(wsTotMovMax)) {
                            log(TraceLevel.Error, "PAG-CHEIA, DEVE VOLTAR AO CENTRAL");
                            msgOut().msg().ade().iBloco().set("0");
                            log(TraceLevel.Debug, "WS-Z-MOVIMENTO-ULT < WS-DATA-DISP-MOV-SD");
                            log(TraceLevel.Debug, wsVariaveis().wsZMovimentoUlt(), "<", wsVariaveis().wsDataDispMovSd());
                            log(TraceLevel.Debug, "BGHM1111-I-BLOCO ", msgOut().msg().ade().iBloco());
                        } else {
                            /**
                             * *ELSE : OS MOVIMENTOS EXISTENTES NAO ENCHEM A PAGINA
                             * *SE DATA INICIO PESQUISA SUPERIOR A DATA DE CORTE
                             * *INDICA QUE A PESQUISA TERMINOU, CASO CONTRARIO,
                             * *TERA QUE CONTINUAR A PESQUISA NOS SISTEMAS DISTRIBUIDOS
                             * IF BGHM1110-Z-MOV-INI >= WS-DATA-DISP-MOV-SD
                             */
                            if (msgIn().msg().ade().zMovIni().isGreater(wsVariaveis().wsDataDispMovSd())) {
                                msgOut().msg().ade().iBloco().set("3");
                            } else {
                                msgOut().msg().ade().iBloco().set("1");
                            }
                            messageV2.mensagem().cTipoErroBbn().set(CON_FIM_CONSULTA);
                            log(TraceLevel.Debug, "BGHM1110-Z-MOV-INI > WS-DATA-DISP-MOV-SD");
                            log(TraceLevel.Debug, msgIn().msg().ade().zMovIni(), ">", wsVariaveis().wsDataDispMovSd());
                            log(TraceLevel.Debug, "BGHM1111-I-BLOCO ", msgOut().msg().ade().iBloco());
                        }
                    }
                }
            } else {
                log(TraceLevel.Error, "UH-OH!--1");
            }
        } else {
            log(TraceLevel.Error, "UH-OH!--2");
        }
    }
    
    /**
     * 
     * 2100-CONSULTA-GATCNSMOV
     * 
     */
    protected void m2100ConsultaGatcnsmov() {
        log(TraceLevel.Debug, "--- PGHS111A - 2100-CONSULTA-GATCNSMOV");
        hrMghs003a().bghl003a().initialize() ;
        hrMghs003a().bghl003a().argumento().nmRecurso().set("TGH00022");
        mgh003aNmRotina.set("MGHS003A");
        hrMghs003a().run() ;
        if (hrMghs003a().bghl003a().naoExiste().isTrue()) {
            hrMghs003a().bghl003a().detalhe().iEstRcrs().set("I");
        }
        if (!hrMghs003a().bghl003a().naoExiste().isTrue() && !hrMghs003a().bghl003a().ok().isTrue()) {
            progStatus.set(hrMghs003a().bghl003a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs003a().bghl003a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00003");
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
        }
    }
    
    /**
     * 
     * 2150-VALIDA-PEDIDO
     * 
     */
    protected void m2150ValidaPedido() {
        log(TraceLevel.Debug, "--- PGHS111A - 2150-VALIDA-PEDIDO");
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
            m2155ValidaDatas() ;
        } else {
            progStatus.set(hrMghs001a().bghl001a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs001a().bghl001a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00001");
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            log(TraceLevel.Debug, "ERRO MGH001A");
            log(TraceLevel.Debug, "PROG-STATUS             : ", progStatus);
            log(TraceLevel.Debug, "BHTL010A-C-TIPO-ERRO-BBN: ", messageV2.mensagem().cTipoErroBbn());
            log(TraceLevel.Debug, "BHTL010A-C-SQLCODE:       ", envOut.db2Log().sqlca().cSqlcode());
            log(TraceLevel.Debug, "BHTL010A-NM-TABELA:       ", envOut.db2Log().nmTabela());
            log(TraceLevel.Debug, "BHTL010A-A-APL-ERRO:      ", messageV2.mensagem().aAplErro());
        }
    }
    
    /**
     * 
     * 2155-VALIDA-DATAS
     * 
     */
    protected void m2155ValidaDatas() {
        log(TraceLevel.Debug, "--- PGHS111A - 2155-VALIDA-DATAS");
        if (msgIn().msg().ade().ascendente().isTrue()) {
            wTimestamp().set(msgIn().msg().ade().tsMovimento());
        } else {
            wTimestamp().set(msgIn().msg().ade().tsMovMax());
        }
        if (wTimestamp().wDataTimestamp().isLess(hrMghs001a().bghl001a().detalhe().zAbraCont())) {
            if (!msgIn().msg().ade().cTipoCont().isEqual(34)) {
                wTimestamp().wDataTimestamp().set(hrMghs001a().bghl001a().detalhe().zAbraCont());
            }
            if (msgIn().msg().ade().ascendente().isTrue()) {
                msgIn().msg().ade().tsMovimento().set(wTimestamp());
            } else {
                msgIn().msg().ade().tsMovMax().set(wTimestamp());
            }
        }
        hrMghs010a().bghl010a().argumento().nmRecurso().set(wsRecursoVgh00201);
        hrMghs010a().run() ;
        log(TraceLevel.Debug, "MGH010A-C-RETORNO        : ", hrMghs010a().bghl010a().cRetorno());
        log(TraceLevel.Debug, "W-ANO-AA                 : ", wTimestamp().wDataTimestamp().wAnoAa());
        log(TraceLevel.Debug, "MGH010A-ZA-INICIO        : ", hrMghs010a().bghl010a().detalhe().zaInicio());
        log(TraceLevel.Debug, "BHTL010A-C-TIPO-CANL-ACES: ", messageV2.mensagem().cTipoCanlAces());
        if (hrMghs010a().bghl010a().ok().isTrue()) {
            if (wTimestamp().wDataTimestamp().wAnoAa().isLess(hrMghs010a().bghl010a().detalhe().zaInicio())) {
                if (messageV2.mensagem().cTipoCanlAces().isEqual("BALC")) {
                    progDataMinInv.setTrue() ;
                    messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
                    messageV2.mensagem().aAplErro().set(CON_APL_HST);
                } else {
                    wTimestamp().wDataTimestamp().wAnoAa().set(hrMghs010a().bghl010a().detalhe().zaInicio());
                    wTimestamp().wDataTimestamp().wMesMm().set(1);
                    wTimestamp().wDataTimestamp().wDiaDd().set(1);
                    wTimestamp().wTimerTimestamp().wHora().set(0);
                    wTimestamp().wTimerTimestamp().wMinuto().set(0);
                    wTimestamp().wTimerTimestamp().wSegundo().set(0);
                    wTimestamp().wTimerTimestamp().wResto().set(0);
                    if (msgIn().msg().ade().ascendente().isTrue()) {
                        msgIn().msg().ade().tsMovimento().set(wTimestamp());
                    } else {
                        msgIn().msg().ade().tsMovMax().set(wTimestamp());
                    }
                }
            }
        } else if (!hrMghs001a().bghl001a().detalhe().zAbraCont().isEqual(hrMghs003a().bghl003a().zHoje()) && 
            !msgIn().msg().ade().tsMovimento().get(1, 10).isEqual(hrMghs003a().bghl003a().zHoje())) {
            progStatus.set(hrMghs010a().bghl010a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs010a().bghl010a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00010");
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            log(TraceLevel.Debug, "ERRO MGH010A");
            log(TraceLevel.Debug, "MGH010A-C-RETORNO       :  ", hrMghs010a().bghl010a().cRetorno());
            log(TraceLevel.Debug, "BHTL010A-C-TIPO-ERRO-BBN:  ", messageV2.mensagem().cTipoErroBbn());
            log(TraceLevel.Debug, "BHTL010A-C-SQLCODE:        ", envOut.db2Log().sqlca().cSqlcode());
            log(TraceLevel.Debug, "BHTL010A-NM-TABELA:        ", envOut.db2Log().nmTabela());
            log(TraceLevel.Debug, "BHTL010A-A-APL-ERRO:       ", messageV2.mensagem().aAplErro());
        }
    }
    
    /**
     * 
     * 2200-OBTEM-CLIENTE
     * 
     */
    protected void m2200ObtemCliente() {
        log(TraceLevel.Debug, "--- PGHS111A - 2200-OBTEM-CLIENTE");
        hrMhjj060a().bhjl060a().commarea().initialize() ;
        bhjl001a().commarea().initialize() ;
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(messageV2.mensagem().nEltnJourBbn().cPaisIsoaOeOpx());
        bhjl001a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(messageV2.mensagem().nEltnJourBbn().cPaisIsoaOeOpx());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cMnemEgcOpex().set(messageV2.mensagem().nEltnJourBbn().cMnemEgcOpex());
        bhjl001a().commarea().dadosEntrada().cMnemEgcOpex().set(messageV2.mensagem().nEltnJourBbn().cMnemEgcOpex());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().zConsulta().set(messageV2.mensagem().campoLivre9().zPrctJourBbn());
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
                bhjl001a().commarea().dadosEntrada().nsAbraCli().set(hrMhjj060a().bhjl060a().commarea().dadosSaida().nsAbraCli());
                m2250ObtemNomeCli() ;
            }
        } else {
            log(TraceLevel.Error, "ERRO 1");
            messageV2.mensagem().cTipoErroBbn().set(hrMhjj060a().bhjl060a().commarea().erros().cTipoErroBbn());
            progStatus.set(hrMhjj060a().bhjl060a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhjj060a().bhjl060a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhjj060a().bhjl060a().commarea().erros().nmTabela());
            messageV2.mensagem().aAplErro().set(hrMhjj060a().bhjl060a().commarea().erros().aAplErr());
        }
    }
    
    /**
     * 
     * 2250-OBTEM-NOME-CLI
     * 
     */
    protected void m2250ObtemNomeCli() {
        log(TraceLevel.Debug, "--- PGHS111A - 2250-OBTEM-NOME-CLI");
        hrMhjj200a().run() ;
        if (bhjl001a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().cTitHono().set(bhjl001a().commarea().dadosSaida().cTitHono());
            msgOut().msg().ade().nmCliAbvd().set(bhjl001a().commarea().dadosSaida().nmCliAbvd());
        } else if (bhjl001a().commarea().erros().nomeNExi().isTrue()) {
            msgOut().msg().ade().cTitHono().set(" ");
            msgOut().msg().ade().nmCliAbvd().set(" ");
        } else {
            log(TraceLevel.Error, "ERRO 2");
            messageV2.mensagem().cTipoErroBbn().set(bhjl001a().commarea().erros().cTipoErroBbn());
            progStatus.set(bhjl001a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl001a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl001a().commarea().erros().nmTabela());
            messageV2.mensagem().aAplErro().set(bhjl001a().commarea().erros().aAplErr());
        }
    }
    
    /**
     * 
     * 2290-OBTEM-N-MOVIMENTOS
     * OBTEM DA TABELA DE MOVIMENTOS O NR DE OCORRENCIAS QUE ESTA
     * DEVOLVERA PARA A CONTA NO PERIODO CONSIDERADO
     * 
     */
    protected void m2290ObtemNMovimentos() {
        log(TraceLevel.Debug, "--- PGHS111A - 2290-OBTEM-N-MOVIMENTOS");
        log(TraceLevel.Debug, " BGHM1110-Z-MOV-FIM  : ", msgIn().msg().ade().zMovFim());
        log(TraceLevel.Debug, " MGH003A-Z-HOJE      : ", hrMghs003a().bghl003a().zHoje());
        log(TraceLevel.Debug, " MGH003A-I-EST-RCRS  : ", hrMghs003a().bghl003a().detalhe().iEstRcrs());
        if (msgIn().msg().ade().zMovFim().isLess(hrMghs003a().bghl003a().zHoje())) {
            m2291ObtemMovHistorico() ;
            if (progOk.isTrue()) {
                m2292ObtemMovOntem() ;
            }
        } else if (msgIn().msg().ade().zMovFim().isEqual(hrMghs003a().bghl003a().zHoje())) {
            m2291ObtemMovHistorico() ;
            if (progOk.isTrue()) {
                m2292ObtemMovOntem() ;
            }
            if (progOk.isTrue()) {
                if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("I")) {
                    m2295ObtemMovDiaHo() ;
                }
            }
        }
        if (progOk.isTrue()) {
            m2296QMovimentos() ;
        }
    }
    
    /**
     * 
     * 2291-OBTEM-MOV-HISTORICO
     * 
     */
    protected void m2291ObtemMovHistorico() {
        log(TraceLevel.Debug, "--- PGHS111A - 2291-OBTEM-MOV-HISTORICO");
        hv00201Movhst().movhst().initialize() ;
        wsVariaveis().wsQMovTgh2().set(0);
        wsVariaveis().wsMMovMin().set(0);
        wsVariaveis().wsMMovMax().set(0);
        wsVariaveis().wsCrit1().set(" ");
        wsVariaveis().wsCrit2().set(" ");
        hv00201Movhst().movhst().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        wsVariaveis().wsTsMovIni().set(msgIn().msg().ade().zMovIni());
        wsVariaveis().wsTsMovFim().set(msgIn().msg().ade().zMovFim());
        if (msgIn().msg().ade().ambos().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        } else if (msgIn().msg().ade().debito().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_DEBITO);
        } else {
            wsVariaveis().wsCrit1().set(CON_CREDITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        }
        if (msgIn().msg().ade().iCritMontante().mMovMin().isEqual(0) && 
            msgIn().msg().ade().iCritMontante().mMovMax().isEqual(0)) {
            wsVariaveis().wsMMovMin().set(0);
            wsVariaveis().wsMMovMax().set(999999999999999.99);
        } else {
            wsVariaveis().wsMMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
            wsVariaveis().wsMMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        }
        wsTsTgh1.get(1, 10).set(wsVariaveis().wsTsMovIni()) ;
        wsTsTgh1.get(11, 16).set(CON_00) ;
        wsTsTgh2.get(1, 10).set(wsVariaveis().wsTsMovFim()) ;
        wsTsTgh2.get(11, 16).set(CON_23) ;
        log(TraceLevel.Debug, " VGH00201-C-PAIS-ISOA-CONT", hv00201Movhst().movhst().cPaisIsoaCont());
        log(TraceLevel.Debug, " VGH00201-C-BANC-CONT:", hv00201Movhst().movhst().cBancCont());
        log(TraceLevel.Debug, " VGH00201-C-OE-EGC-CONT:", hv00201Movhst().movhst().cOeEgcCont());
        log(TraceLevel.Debug, " VGH00201-NS-RDCL-CONT:", hv00201Movhst().movhst().nsRdclCont());
        log(TraceLevel.Debug, " VGH00201-V-CHKD-CONT:", hv00201Movhst().movhst().vChkdCont());
        log(TraceLevel.Debug, " VGH00201-C-TIPO-CONT:", hv00201Movhst().movhst().cTipoCont());
        log(TraceLevel.Debug, " VGH00201-C-MOED-ISO-SCTA:", hv00201Movhst().movhst().cMoedIsoScta());
        log(TraceLevel.Debug, " VGH00201-NS-DEPOSITO:", hv00201Movhst().movhst().nsDeposito());
        log(TraceLevel.Debug, " WS-TS-TGH-1:", wsTsTgh1);
        log(TraceLevel.Debug, " WS-TS-TGH-2:", wsTsTgh2);
        log(TraceLevel.Debug, " WS-CRIT-1:", wsVariaveis().wsCrit1());
        log(TraceLevel.Debug, " WS-CRIT-2:", wsVariaveis().wsCrit2());
        log(TraceLevel.Debug, " WS-M-MOV-MIN:", wsVariaveis().wsMMovMin());
        log(TraceLevel.Debug, " WS-M-MOV-MAX:", wsVariaveis().wsMMovMax());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghs111a1421(wsTsTgh1, wsTsTgh2, wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsQMovTgh2()) ;
        log(TraceLevel.Debug, " SQLCODE       : ", hv00201Movhst().getPersistenceCode());
        log(TraceLevel.Debug, " WS-Q-MOV-TGH2 : ", wsVariaveis().wsQMovTgh2());
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_DB2);
        }
        if (progOk.isTrue()) {
            wsVariaveis().wsQMovTot().add(wsVariaveis().wsQMovTgh2());
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            envOut.db2Log().nmTabela().set("VGH00201_MOVHST");
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
        }
    }
    
    /**
     * 
     * 2292-OBTEM-MOV-ONTEM
     * 
     */
    protected void m2292ObtemMovOntem() {
        log(TraceLevel.Debug, "--- PGHS111A - 2292-OBTEM-MOV-ONTEM");
        if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("A")) {
            /**
             * ---MOVIMENTOS DO DIA D-1 ESTAO NA TGH022
             */
            m2293ObtemMovDiaAntGh() ;
        } else if (hrMghs003a().bghl003a().detalhe().iEstRcrs().isEqual("H")) {
            /**
             * ---MOVIMENTOS DO DIA D-1 ESTAO NA APLICACAO HO
             */
            m2294ObtemMovDiaAntHo() ;
        }
    }
    
    /**
     * 
     * 2293-OBTEM-MOV-DIA-ANT-GH
     * 
     */
    protected void m2293ObtemMovDiaAntGh() {
        log(TraceLevel.Debug, "--- PGHS111A - 2293-OBTEM-MOV-DIA-ANT-GH");
        hv02201Movdiaant().movdiaant().initialize() ;
        wsVariaveis().wsQMovTgh22().set(0);
        wsVariaveis().wsMMovMin().set(0);
        wsVariaveis().wsMMovMax().set(0);
        wsVariaveis().wsCrit1().set(" ");
        wsVariaveis().wsCrit2().set(" ");
        hv02201Movdiaant().movdiaant().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv02201Movdiaant().movdiaant().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv02201Movdiaant().movdiaant().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv02201Movdiaant().movdiaant().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv02201Movdiaant().movdiaant().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv02201Movdiaant().movdiaant().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv02201Movdiaant().movdiaant().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv02201Movdiaant().movdiaant().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        wsVariaveis().wsTsMovIni().set(msgIn().msg().ade().zMovIni());
        wsVariaveis().wsTsMovFim().set(msgIn().msg().ade().zMovFim());
        if (msgIn().msg().ade().ambos().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        } else if (msgIn().msg().ade().debito().isTrue()) {
            wsVariaveis().wsCrit1().set(CON_DEBITO);
            wsVariaveis().wsCrit2().set(CON_DEBITO);
        } else {
            wsVariaveis().wsCrit1().set(CON_CREDITO);
            wsVariaveis().wsCrit2().set(CON_CREDITO);
        }
        if (msgIn().msg().ade().iCritMontante().mMovMin().isEqual(0) && 
            msgIn().msg().ade().iCritMontante().mMovMax().isEqual(0)) {
            wsVariaveis().wsMMovMin().set(0);
            wsVariaveis().wsMMovMax().set(999999999999999.99);
        } else {
            wsVariaveis().wsMMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
            wsVariaveis().wsMMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        }
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectPghs111a1541(wsVariaveis().wsTsMovIni(), wsVariaveis().wsTsMovFim(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsMMovMin(), wsVariaveis().wsMMovMax(), wsVariaveis().wsQMovTgh22()) ;
        log(TraceLevel.Debug, " SQLCODE       : ", hv02201Movdiaant().getPersistenceCode());
        log(TraceLevel.Debug, " WS-Q-MOV-TGH22: ", wsVariaveis().wsQMovTgh22());
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
        }
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_DB2);
        }
        if (progOk.isTrue()) {
            wsVariaveis().wsQMovTot().add(wsVariaveis().wsQMovTgh22());
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(hv02201Movdiaant().getPersistenceCode());
            envOut.db2Log().nmTabela().set("VGH02201_MOVDIAANT");
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
        }
    }
    
    /**
     * 
     * 2294-OBTEM-MOV-DIA-ANT-HO
     * 
     */
    protected void m2294ObtemMovDiaAntHo() {
        log(TraceLevel.Debug, "--- PGHS111A - 2294-OBTEM-MOV-DIA-ANT-HO");
        hrMhoj354a().bhol354a().commarea().initialize() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().consultaMovDia().setTrue() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set("N");
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovIni().set(msgIn().msg().ade().zMovIni());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovFim().set(msgIn().msg().ade().zMovFim());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritDbcr().set(msgIn().msg().ade().iCritDbcr());
        hrMhoj354a().run() ;
        if (!hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue()) {
            log(TraceLevel.Error, "ERRO 3");
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
            messageV2.mensagem().aAplErro().set(hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
            envOut.db2Log().nmTabela().set(hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
            messageV2.mensagem().cTipoErroBbn().set(hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
            progStatus.set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
        } else {
            wsVariaveis().wsQMovTot().add(hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
        }
        log(TraceLevel.Debug, "PROG-STATUS      :", progStatus);
        log(TraceLevel.Debug, "BHOL354A-Q-MOV-HO:", hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
    }
    
    /**
     * 
     * 2295-OBTEM-MOV-DIA-HO
     * 
     */
    protected void m2295ObtemMovDiaHo() {
        log(TraceLevel.Debug, "--- PGHS111A - 2295-OBTEM-MOV-DIA-HO");
        hrMhoj354a().bhol354a().commarea().initialize() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().consultaMovDia().setTrue() ;
        hrMhoj354a().bhol354a().commarea().dadosInput().iMovDia().set("S");
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMhoj354a().bhol354a().commarea().dadosInput().subconta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovIni().set(msgIn().msg().ade().zMovIni());
        hrMhoj354a().bhol354a().commarea().dadosInput().zMovFim().set(msgIn().msg().ade().zMovFim());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMhoj354a().bhol354a().commarea().dadosInput().iCritDbcr().set(msgIn().msg().ade().iCritDbcr());
        wsVariaveis().wsNmRotina().set("MHOJ354A");
        hrMhoj354a().run() ;
        if (!hrMhoj354a().bhol354a().commarea().dadosErro().semErros().isTrue()) {
            envOut.db2Log().sqlca().cSqlcode().set(hrMhoj354a().bhol354a().commarea().dadosErro().cSqlcode());
            messageV2.mensagem().aAplErro().set(hrMhoj354a().bhol354a().commarea().dadosErro().aAplErr());
            envOut.db2Log().nmTabela().set(hrMhoj354a().bhol354a().commarea().dadosErro().nmTabela());
            messageV2.mensagem().cTipoErroBbn().set(hrMhoj354a().bhol354a().commarea().dadosErro().cTipoErroBbn());
            log(TraceLevel.Error, "ERRO 4");
            progStatus.set(hrMhoj354a().bhol354a().commarea().dadosErro().cRtnoEvenSwal());
        } else {
            wsVariaveis().wsQMovTot().add(hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
        }
        log(TraceLevel.Debug, "PROG-STATUS      :", progStatus);
        log(TraceLevel.Debug, "BHOL354A-Q-MOV-HO:", hrMhoj354a().bhol354a().commarea().areaOutput().qMovHo());
    }
    
    /**
     * 
     * 2296-Q-MOVIMENTOS
     * 
     */
    protected void m2296QMovimentos() {
        log(TraceLevel.Debug, "--- PGHS111A - 2296-Q-MOVIMENTOS");
        msgOut().msg().ade().zMovIni().set(msgIn().msg().ade().zMovIni());
        msgOut().msg().ade().zMovFim().set(msgIn().msg().ade().zMovFim());
        msgOut().msg().ade().qMovimentos().set(wsVariaveis().wsQMovTot());
        log(TraceLevel.Debug, " BGHM1111-Q-MOVIMENTOS: ", msgOut().msg().ade().qMovimentos());
    }
    
    /**
     * 
     * 2300-OBTEM-MOV-HST
     * 
     */
    protected void m2300ObtemMovHst() {
        log(TraceLevel.Debug, "--- PGHS111A - 2300-OBTEM-MOV-HST");
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
        if (wsVariaveis().wsTsMovimento13().isEmpty()) {
            hrMghs002a().bghl002a().argumento().tsMovimento().set(msgIn().msg().ade().tsMovimento());
            hrMghs002a().bghl002a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        } else {
            hrMghs002a().bghl002a().argumento().tsMovimento().set(wsVariaveis().wsTsMovimento13());
            hrMghs002a().bghl002a().argumento().nsMovimento().set(wsVariaveis().wsNsMovimento13());
        }
        hrMghs002a().bghl002a().criterioSeleccao().tsMovMax().set(msgIn().msg().ade().tsMovMax());
        hrMghs002a().bghl002a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs002a().bghl002a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs002a().bghl002a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        log(TraceLevel.Debug, "   MGH002A-TS-MOVIMENTO : ", hrMghs002a().bghl002a().argumento().tsMovimento());
        log(TraceLevel.Debug, "   MGH002A-NS-MOVIMENTO : ", hrMghs002a().bghl002a().argumento().nsMovimento());
        log(TraceLevel.Debug, "   MGH002A-TS-MOV-MAX   : ", hrMghs002a().bghl002a().criterioSeleccao().tsMovMax());
        hrMghs002a().run() ;
        if (hrMghs002a().bghl002a().ok().isTrue()) {
            haMov.setTrue() ;
        }
        if (!hrMghs002a().bghl002a().ok().isTrue() && !hrMghs002a().bghl002a().naoExiste().isTrue()) {
            progStatus.set(hrMghs002a().bghl002a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs002a().bghl002a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00002");
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
        }
        hrMghs002a().bghl002a().tabela().lista().resetIndex() ;
        wsQItens.set(hrMghs002a().bghl002a().qItens());
        log(TraceLevel.Debug, " MGH002A-Q-ITENS              : ", wsQItens);
        if (haMov.isTrue()) {
            for (hrMghs002a().bghl002a().tabela().lista().setIndex(1); hrMghs002a().bghl002a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax) && !hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemDetalhe().isEmpty(); hrMghs002a().bghl002a().tabela().lista().incIndex()) {
                if (hrMghs002a().bghl002a().tabela().lista().index().isLess(wsQItensMax)) {
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
                    swMovHstS.setTrue() ;
                    if (!balcao.isTrue()) {
                        if (!hrMghs002a().bghl002a().detalhe().mSldoCbloApos().isEqual(hrMghs002a().bghl002a().detalhe().mSldoDpnlApos())) {
                            m2310CalculaSldoDpnl() ;
                        }
                    }
                    wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs002a().bghl002a().detalhe().mMovMoeOrigMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs002a().bghl002a().detalhe().nDocOpps());
                    wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs002a().bghl002a().detalhe().aAplOrig());
                    wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set(hrMghs002a().bghl002a().detalhe().iExisInfAdi());
                    if (wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().isEqual("N")) {
                        /**
                         * ACEDE A BGHP0013 - SEARCH ITEM-APL
                         */
                        m2320VerInfAdiApl() ;
                    }
                    log(TraceLevel.Debug, "MGH002A-X-REF-MOV:", hrMghs002a().bghl002a().detalhe().xRefMov());
                    log(TraceLevel.Debug, "MGH002A-TS-MOVIMENTO:", hrMghs002a().bghl002a().argumento().tsMovimento());
                    log(TraceLevel.Debug, "WS-TS-MOVIMENTO:", wsTsMovimento);
                    log(TraceLevel.Debug, "MGH002A-NS-MOVIMENTO:", hrMghs002a().bghl002a().argumento().nsMovimento());
                    log(TraceLevel.Debug, "MGH002A-Z-VAL-MOV:", hrMghs002a().bghl002a().detalhe().zValMov());
                    if (hrMghs002a().bghl002a().detalhe().xRefMov().isEmpty()) {
                        wsTsMovimento.set(hrMghs002a().bghl002a().argumento().tsMovimento());
                        m2330ObtemDescritivoMov() ;
                    } else {
                        m2340VerificaContaHo() ;
                    }
                    if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                        wsTJuro.set(0);
                        m2350ObtemTaxa() ;
                        if (wsTJuro.isGreater(0)) {
                            wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(wsTJuro);
                        }
                    }
                    /**
                     * CORREÇÃO PARA VERIFICAR SE CATG-MOV É PRENCHIDO
                     * IF SW-DEBUG-SIM
                     * DISPLAY 'WA-C-CATG-MOV(WA-ALO-I1)ANTES :'
                     * WA-C-CATG-MOV(WA-ALO-I1)
                     * END-IF
                     */
                    if (wsTabelaMovimento().wsMovimentos().getCurrent().waCCatgMov().isEmpty()) {
                        m2333ObterCOeOpex() ;
                    }
                    wsTotEnvr.add(1);
                    wsTabelaMovimento().wsMovimentos().incIndex() ;
                    log(TraceLevel.Debug, "   .............................");
                    log(TraceLevel.Debug, "   MGH002A-IND < WS-Q-ITENS-MAX ");
                    log(TraceLevel.Debug, "   WS-TOT-ENVR                : ", wsTotEnvr);
                } else if (hrMghs002a().bghl002a().tabela().lista().index().isEqual(wsQItensMax)) {
                    hrMghs002a().bghl002a().argumento().set(hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemArgumento());
                    hrMghs002a().bghl002a().detalhe().set(hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemDetalhe());
                    wsVariaveis().wsTsMovimento13().set(hrMghs002a().bghl002a().argumento().tsMovimento());
                    wsVariaveis().wsNsMovimento13().set(hrMghs002a().bghl002a().argumento().nsMovimento());
                    log(TraceLevel.Debug, "   .............................");
                    log(TraceLevel.Debug, "   MGH002A-IND = WS-Q-ITENS-MAX ", wsQItensMax);
                    log(TraceLevel.Debug, "   MGH002A-TS-MOVIMENTO       : ", hrMghs002a().bghl002a().argumento().tsMovimento());
                    log(TraceLevel.Debug, "   MGH002A-NS-MOVIMENTO       : ", hrMghs002a().bghl002a().argumento().nsMovimento());
                }
            }
            if ((hrMghs002a().bghl002a().tabela().lista().index().isLessOrEqual(wsQItensMax) && 
                hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemDetalhe().isEmpty()) || 
                wsTotEnvr.isEqual(0)) {
                swAcabou.setTrue() ;
            }
        } else {
            swAcabou.setTrue() ;
        }
        log(TraceLevel.Debug, "...2300-OBTEM-MOV-HST-EXIT    ");
        log(TraceLevel.Debug, "   SW-CONTROLO-CICLO        : ", swControloCiclo);
        log(TraceLevel.Debug, "   PROG-STATUS              : ", progStatus);
        log(TraceLevel.Debug, "   WS-TOT-ENVR              : ", wsTotEnvr);
        log(TraceLevel.Debug, "   MGH002A-ITEM-DETALHE     : ", hrMghs002a().bghl002a().tabela().lista().getCurrent().item().itemDetalhe());
    }
    
    /**
     * 
     * 2310-CALCULA-SLDO-DPNL
     * 
     */
    protected void m2310CalculaSldoDpnl() {
        log(TraceLevel.Debug, "--- PGHS111A - 2310-CALCULA-SLDO-DPNL");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtSaldos().setTrue() ;
        if (swMovHstS.isTrue()) {
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
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
        if (progOk.isTrue()) {
            wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos().set(subtract(hrMghs002a().bghl002a().detalhe().mSldoCbloApos(), add(hrMghs102a().bghl102a().detalhe().mSldoRetd(), hrMghs102a().bghl102a().detalhe().mSldoVcob())));
        }
    }
    
    /**
     * 
     * 2320-VER-INF-ADI-APL
     * 
     */
    protected void m2320VerInfAdiApl() {
        log(TraceLevel.Debug, "--- PGHS111A - 2320-VER-INF-ADI-APL");
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
     * 2330-OBTEM-DESCRITIVO-MOV
     * 
     */
    protected void m2330ObtemDescritivoMov() {
        log(TraceLevel.Debug, "--- PGHS111A - 2330-OBTEM-DESCRITIVO-MOV");
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
        m2331ObterCOeOpex() ;
        if (progOk.isTrue()) {
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hrMghs102a().bghl102a().detalhe().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hrMghs102a().bghl102a().detalhe().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hrMghs102a().bghl102a().detalhe().cOeEgcOpex());
        }
        if (progOk.isTrue()) {
            m2332ObtemCOpeBbn() ;
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
     * 2331-OBTER-C-OE-OPEX
     * 
     */
    protected void m2331ObterCOeOpex() {
        log(TraceLevel.Debug, "--- PGHS111A - 2331-OBTER-C-OE-OPEX");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtOnde().setTrue() ;
        if (swMovHstS.isTrue()) {
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
        /**
         * MOVE WS-TS-MOVIMENTO          TO MGH102A-TS-MOVIMENTO.
         */
        if (wsTsMovimento.isEmpty()) {
            hrMghs102a().bghl102a().argumento().tsMovimento().set(hrMghs102a().bghl102a().argumento().tsMovimento());
        } else {
            hrMghs102a().bghl102a().argumento().tsMovimento().set(wsTsMovimento);
        }
        hrMghs102a().bghl102a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
        /**
         * IF SW-DEBUG-SIM
         * DISPLAY 'MGH102A-C-PAIS-ISOA-CONT:'
         * MGH102A-C-PAIS-ISOA-CONT
         * DISPLAY 'MGH102A-C-BANC-CONT     :'
         * MGH102A-C-BANC-CONT
         * DISPLAY 'MGH102A-C-OE-EGC-CONT   :'
         * MGH102A-C-OE-EGC-CONT
         * DISPLAY 'MGH102A-NS-RDCL-CONT    :'
         * MGH102A-NS-RDCL-CONT
         * DISPLAY 'MGH102A-V-CHKD-CONT     :'
         * MGH102A-V-CHKD-CONT
         * DISPLAY 'MGH102A-C-TIPO-CONT     :'
         * MGH102A-C-TIPO-CONT
         * DISPLAY 'MGH102A-C-MOED-ISO-SCTA :'
         * MGH102A-C-MOED-ISO-SCTA
         * DISPLAY 'MGH102A-NS-DEPOSITO     :'
         * MGH102A-NS-DEPOSITO
         * DISPLAY 'MGH102A-TS-MOVIMENTO    :'
         * MGH102A-TS-MOVIMENTO
         * DISPLAY 'MGH102A-NS-MOVIMENTO    :'
         * MGH102A-NS-MOVIMENTO
         * END-IF.
         */
        hrMghs102a().run() ;
        log(TraceLevel.Debug, "MGH102A-C-RETORNO       :", hrMghs102a().bghl102a().cRetorno());
        if (!hrMghs102a().bghl102a().ok().isTrue()) {
            progStatus.set(hrMghs102a().bghl102a().cRetorno());
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 2333-OBTER-C-OE-OPEX
     * 
     */
    protected void m2333ObterCOeOpex() {
        log(TraceLevel.Debug, "--- PGHS111A - 2333-OBTER-C-OE-OPEX");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtOnde().setTrue() ;
        if (swMovHstS.isTrue()) {
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
        /**
         * MOVE WS-TS-MOVIMENTO          TO MGH102A-TS-MOVIMENTO.
         */
        if (wsTsMovimento.isEmpty()) {
            hrMghs102a().bghl102a().argumento().tsMovimento().set(hrMghs002a().bghl002a().argumento().tsMovimento());
        } else {
            hrMghs102a().bghl102a().argumento().tsMovimento().set(wsTsMovimento);
        }
        hrMghs102a().bghl102a().argumento().nsMovimento().set(wsTabelaMovimento().wsMovimentos().getCurrent().waNsMovimento());
        /**
         * IF SW-DEBUG-SIM
         * DISPLAY 'MGH102A-C-PAIS-ISOA-CONT:'
         * MGH102A-C-PAIS-ISOA-CONT
         * DISPLAY 'MGH102A-C-BANC-CONT     :'
         * MGH102A-C-BANC-CONT
         * DISPLAY 'MGH102A-C-OE-EGC-CONT   :'
         * MGH102A-C-OE-EGC-CONT
         * DISPLAY 'MGH102A-NS-RDCL-CONT    :'
         * MGH102A-NS-RDCL-CONT
         * DISPLAY 'MGH102A-V-CHKD-CONT     :'
         * MGH102A-V-CHKD-CONT
         * DISPLAY 'MGH102A-C-TIPO-CONT     :'
         * MGH102A-C-TIPO-CONT
         * DISPLAY 'MGH102A-C-MOED-ISO-SCTA :'
         * MGH102A-C-MOED-ISO-SCTA
         * DISPLAY 'MGH102A-NS-DEPOSITO     :'
         * MGH102A-NS-DEPOSITO
         * DISPLAY 'MGH102A-TS-MOVIMENTO    :'
         * MGH102A-TS-MOVIMENTO
         * DISPLAY 'MGH102A-NS-MOVIMENTO    :'
         * MGH102A-NS-MOVIMENTO
         * END-IF.
         */
        hrMghs102a().run() ;
        if (!hrMghs102a().bghl102a().ok().isTrue() && !hrMghs102a().bghl102a().naoExiste().isTrue()) {
            log(TraceLevel.Error, "ERRO ROTINA MGH102A");
            progStatus.set(hrMghs102a().bghl102a().cRetorno());
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 2332-OBTEM-C-OPE-BBN
     * 
     */
    protected void m2332ObtemCOpeBbn() {
        log(TraceLevel.Debug, "--- PGHS111A - 2332-OBTEM-C-OPE-BBN");
        hrMghs102a().bghl102a().initialize() ;
        hrMghs102a().bghl102a().criterioConsulta().crtQuem().setTrue() ;
        if (swMovHstS.isTrue()) {
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
            messageV2.mensagem().aAplErro().set(CON_APL_HST);
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs102a().bghl102a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00102");
        }
    }
    
    /**
     * 
     * 2340-VERIFICA-CONTA-HO
     * 
     */
    protected void m2340VerificaContaHo() {
        log(TraceLevel.Debug, "--- PGHS111A - 2340-VERIFICA-CONTA-HO");
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
     * 2350-OBTEM-TAXA
     * 
     */
    protected void m2350ObtemTaxa() {
        log(TraceLevel.Debug, "--- PGHS111A - 2350-OBTEM-TAXA");
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
     * 2400-OBTEM-MOV-ONTEM
     * 
     */
    protected void m2400ObtemMovOntem() {
        log(TraceLevel.Debug, "--- PGHS111A - 2400-OBTEM-MOV-ONTEM");
        log(TraceLevel.Debug, " MGH003A-I-EST-RCRS : ", hrMghs003a().bghl003a().detalhe().iEstRcrs());
        switch (hrMghs003a().bghl003a().detalhe().iEstRcrs().get()) {
            case "A":
                while (!swAcabou.isTrue() && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                    m2410ObtemMovDiaAntGh() ;
                }
                break;
            case "H":
                while (!swAcabou.isTrue() && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax)) {
                    m2420ObtemMovDiaAntHo() ;
                }
                break;
            default :
                break ;
        }
    }
    
    /**
     * 
     * 2410-OBTEM-MOV-DIA-ANT-GH
     * 
     */
    protected void m2410ObtemMovDiaAntGh() {
        log(TraceLevel.Debug, "--- PGHS111A - 2410-OBTEM-MOV-DIA-ANT-GH");
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
        if (wsVariaveis().wsZMovimento13().isEmpty()) {
            hrMghs022a().bghl022a().argumento().zMovimento().set(msgIn().msg().ade().tsMovimento().get(1, 10));
            hrMghs022a().bghl022a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        } else {
            hrMghs022a().bghl022a().argumento().zMovimento().set(wsVariaveis().wsZMovimento13());
            hrMghs022a().bghl022a().argumento().nsMovimento().set(wsVariaveis().wsNsMovimento13());
        }
        hrMghs022a().bghl022a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs022a().bghl022a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs022a().bghl022a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        log(TraceLevel.Debug, "   MGH022A-Z-MOVIMENTO  : ", hrMghs022a().bghl022a().argumento().zMovimento());
        log(TraceLevel.Debug, "   MGH022A-NS-MOVIMENTO : ", hrMghs022a().bghl022a().argumento().nsMovimento());
        log(TraceLevel.Debug, "   MGH002A-TS-MOV-MAX   : ", hrMghs022a().bghl022a().criterioSeleccao().tsMovMax());
        hrMghs022a().run() ;
        if (hrMghs022a().bghl022a().ok().isTrue()) {
            haMov.setTrue() ;
        }
        if (!hrMghs022a().bghl022a().ok().isTrue() && !hrMghs022a().bghl022a().naoExiste().isTrue()) {
            progStatus.set(hrMghs022a().bghl022a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs022a().bghl022a().cSqlcode());
            envOut.db2Log().nmTabela().set("TGH00022");
            if (hrMghs022a().bghl022a().aAplErr().isEmpty()) {
                messageV2.mensagem().aAplErro().set(CON_APL_HST);
            } else {
                messageV2.mensagem().aAplErro().set(hrMghs022a().bghl022a().aAplErr());
            }
        }
        hrMghs022a().bghl022a().tabela().lista().resetIndex() ;
        wsQItens.set(hrMghs022a().bghl022a().qItens());
        log(TraceLevel.Debug, " MGH022A-Q-ITENS              : ", wsQItens);
        if (haMov.isTrue()) {
            for (hrMghs022a().bghl022a().tabela().lista().setIndex(1); hrMghs022a().bghl022a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax) && !hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe().isEmpty(); hrMghs022a().bghl022a().tabela().lista().incIndex()) {
                if (hrMghs022a().bghl022a().tabela().lista().index().isLess(wsQItensMax)) {
                    hrMghs022a().bghl022a().argumento().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemArgumento());
                    hrMghs022a().bghl022a().detalhe().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe());
                    wsTs().wDataTs().set(hrMghs022a().bghl022a().argumento().zMovimento());
                    wsVariaveis().wsZMovimentoUlt().set(hrMghs022a().bghl022a().argumento().zMovimento());
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
                    log(TraceLevel.Debug, "   .............................");
                    log(TraceLevel.Debug, "   MGH022A-IND < WS-Q-ITENS-MAX ");
                    log(TraceLevel.Debug, "   WS-TOT-ENVR                : ", wsTotEnvr);
                } else if (hrMghs022a().bghl022a().tabela().lista().index().isEqual(wsQItensMax)) {
                    hrMghs022a().bghl022a().argumento().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemArgumento());
                    hrMghs022a().bghl022a().detalhe().set(hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe());
                    wsVariaveis().wsZMovimento13().set(hrMghs022a().bghl022a().argumento().zMovimento());
                    wsVariaveis().wsZMovimentoUlt().set(hrMghs022a().bghl022a().argumento().zMovimento());
                    wsVariaveis().wsNsMovimento13().set(hrMghs022a().bghl022a().argumento().nsMovimento());
                    log(TraceLevel.Debug, "   .............................");
                    log(TraceLevel.Debug, "   MGH022A-IND = WS-Q-ITENS-MAX ");
                    log(TraceLevel.Debug, "   MGH022A-Z-MOVIMENTO        : ", hrMghs022a().bghl022a().argumento().zMovimento());
                    log(TraceLevel.Debug, "   MGH022A-NS-MOVIMENTO       : ", hrMghs022a().bghl022a().argumento().nsMovimento());
                }
            }
            if ((hrMghs022a().bghl022a().tabela().lista().index().isLessOrEqual(wsQItensMax) && 
                hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe().isEmpty()) || 
                wsTotEnvr.isEqual(0)) {
                swAcabou.setTrue() ;
            }
        } else {
            swAcabou.setTrue() ;
        }
        log(TraceLevel.Debug, "...2410-OBTEM-MOV-DIA-ANT-GH-EXIT");
        log(TraceLevel.Debug, "   SW-CONTROLO-CICLO        : ", swControloCiclo);
        log(TraceLevel.Debug, "   PROG-STATUS              : ", progStatus);
        log(TraceLevel.Debug, "   WS-TOT-ENVR              : ", wsTotEnvr);
        log(TraceLevel.Debug, "   MGH022A-ITEM-DETALHE     : ", hrMghs022a().bghl022a().tabela().lista().getCurrent().item().itemDetalhe());
    }
    
    /**
     * 
     * 2420-OBTEM-MOV-DIA-ANT-HO
     * 
     */
    protected void m2420ObtemMovDiaAntHo() {
        log(TraceLevel.Debug, "--- PGHS111A - 2420-OBTEM-MOV-DIA-ANT-HO");
        naoHaMov.setTrue() ;
        hrMghs804a().bghl804a().initialize() ;
        hrMghs804a().bghl804a().criterioDia().iMovDia().set("N");
        m2550AcedeHo() ;
    }
    
    /**
     * 
     * 2500-OBTEM-MOV-DIA-HO
     * 
     */
    protected void m2500ObtemMovDiaHo() {
        log(TraceLevel.Debug, "--- PGHS111A - 2500-OBTEM-MOV-DIA-HO");
        naoHaMov.setTrue() ;
        hrMghs804a().bghl804a().initialize() ;
        hrMghs804a().bghl804a().criterioDia().iMovDia().set("S");
        m2550AcedeHo() ;
    }
    
    /**
     * 
     * 2550-ACEDE-HO
     * 
     */
    protected void m2550AcedeHo() {
        log(TraceLevel.Debug, "--- PGHS111A - 2550-ACEDE-HO");
        hrMghs804a().bghl804a().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMghs804a().bghl804a().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMghs804a().bghl804a().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMghs804a().bghl804a().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMghs804a().bghl804a().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMghs804a().bghl804a().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMghs804a().bghl804a().argumento().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hrMghs804a().bghl804a().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        if (wsVariaveis().wsNsMovimento13().isEqual(0)) {
            hrMghs804a().bghl804a().argumento().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        } else {
            hrMghs804a().bghl804a().argumento().nsMovimento().set(wsVariaveis().wsNsMovimento13());
        }
        hrMghs804a().bghl804a().criterioConsulta().iCriterioCns().set(msgIn().msg().ade().iConsulta());
        hrMghs804a().bghl804a().criterioMontante().mMovMax().set(msgIn().msg().ade().iCritMontante().mMovMax());
        hrMghs804a().bghl804a().criterioMontante().mMovMin().set(msgIn().msg().ade().iCritMontante().mMovMin());
        hrMghs804a().bghl804a().criterioDbcr().iCriterioDbcr().set(msgIn().msg().ade().iCritDbcr());
        log(TraceLevel.Debug, "   MGH804A-NS-MOVIMENTO : ", hrMghs804a().bghl804a().argumento().nsMovimento());
        hrMghs804a().run() ;
        if (hrMghs804a().bghl804a().ok().isTrue()) {
            haMov.setTrue() ;
        }
        if (!hrMghs804a().bghl804a().ok().isTrue() && !hrMghs804a().bghl804a().naoExiste().isTrue()) {
            progStatus.set(hrMghs804a().bghl804a().cRetorno());
            messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
            envOut.db2Log().sqlca().cSqlcode().set(hrMghs804a().bghl804a().cSqlcode());
            envOut.db2Log().nmTabela().set("THO00020");
            messageV2.mensagem().aAplErro().set(hrMghs804a().bghl804a().aAplErr());
        }
        hrMghs804a().bghl804a().tabela().lista().resetIndex() ;
        wsQItens.set(hrMghs804a().bghl804a().qItens());
        log(TraceLevel.Debug, " MGH804A-Q-ITENS              : ", wsQItens);
        if (haMov.isTrue()) {
            for (hrMghs804a().bghl804a().tabela().lista().setIndex(1); hrMghs804a().bghl804a().tabela().lista().index().isLessOrEqual(wsQItens) && progStatus.isEqual(0) && wsTotEnvr.isLessOrEqual(wsTotMovMax) && !hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemDetalhe().isEmpty(); hrMghs804a().bghl804a().tabela().lista().incIndex()) {
                if (hrMghs804a().bghl804a().tabela().lista().index().isLess(wsQItensMax)) {
                    hrMghs804a().bghl804a().argumento().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemArgumento());
                    hrMghs804a().bghl804a().detalhe().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemDetalhe());
                    wsTs().wDataTs().set(hrMghs804a().bghl804a().argumento().zMovimento());
                    wsVariaveis().wsZMovimentoUlt().set(hrMghs804a().bghl804a().argumento().zMovimento());
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
                    swMovHstS.setTrue() ;
                    if (!balcao.isTrue()) {
                        if (!wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoCbloApos().isEqual(wsTabelaMovimento().wsMovimentos().getCurrent().waMSldoDpnlApos())) {
                            m2555CalculaSldoDpnl() ;
                        }
                    }
                    wsTabelaMovimento().wsMovimentos().getCurrent().waMMovMoeOrigMov().set(hrMghs804a().bghl804a().detalhe().mMovMoeOrigMov());
                    wsTabelaMovimento().wsMovimentos().getCurrent().waNDocOpps().set(hrMghs804a().bghl804a().detalhe().nDocOpps());
                    wsTabelaMovimento().wsMovimentos().getCurrent().waAAplOrig().set(hrMghs804a().bghl804a().detalhe().aAplOrig());
                    wsTabelaMovimento().wsMovimentos().getCurrent().waIExisInfAdi().set("N");
                    wsTabelaMovimento().wsMovimentos().getCurrent().waTJuro().set(hrMghs804a().bghl804a().detalhe().tJuro());
                    wsTotEnvr.add(1);
                    wsTabelaMovimento().wsMovimentos().incIndex() ;
                    log(TraceLevel.Debug, "   .............................");
                    log(TraceLevel.Debug, "   MGH804A-IND < WS-Q-ITENS-MAX ");
                    log(TraceLevel.Debug, "   WS-TOT-ENVR                : ", wsTotEnvr);
                } else if (hrMghs804a().bghl804a().tabela().lista().index().isEqual(wsQItensMax)) {
                    hrMghs804a().bghl804a().argumento().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemArgumento());
                    hrMghs804a().bghl804a().detalhe().set(hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemDetalhe());
                    wsVariaveis().wsNsMovimento13().set(hrMghs804a().bghl804a().argumento().nsMovimento());
                    wsVariaveis().wsZMovimentoUlt().set(hrMghs804a().bghl804a().argumento().zMovimento());
                    log(TraceLevel.Debug, "   .............................");
                    log(TraceLevel.Debug, "   MGH804A-IND = WS-Q-ITENS-MAX ", wsQItensMax);
                    log(TraceLevel.Debug, "   MGH804A-NS-MOVIMENTO       : ", hrMghs002a().bghl002a().argumento().nsMovimento());
                }
            }
            if ((hrMghs804a().bghl804a().tabela().lista().index().isLessOrEqual(wsQItensMax) && 
                hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemDetalhe().isEmpty()) || 
                wsTotEnvr.isEqual(0)) {
                swAcabou.setTrue() ;
            }
        } else {
            swAcabou.setTrue() ;
        }
        log(TraceLevel.Debug, "...2550-ACEDE-HO-EXIT         ");
        log(TraceLevel.Debug, "   SW-CONTROLO-CICLO        : ", swControloCiclo);
        log(TraceLevel.Debug, "   PROG-STATUS              : ", progStatus);
        log(TraceLevel.Debug, "   WS-TOT-ENVR              : ", wsTotEnvr);
        log(TraceLevel.Debug, "   MGH804A-ITEM-DETALHE     : ", hrMghs804a().bghl804a().tabela().lista().getCurrent().item().itemDetalhe());
    }
    
    /**
     * 
     * 2555-CALCULA-SLDO-DPNL
     * 
     */
    protected void m2555CalculaSldoDpnl() {
        log(TraceLevel.Debug, "--- PGHS111A - 2555-CALCULA-SLDO-DPNL");
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
     * 2600-CONSULTA-SEMAF-SD
     * 
     */
    protected void m2600ConsultaSemafSd() {
        log(TraceLevel.Debug, "--- PGHS111A - 2600-CONSULTA-SEMAF-SD");
        bhyl025a().commarea().initialize() ;
        /**
         * TRATA-SE DO SEMAFORO QUE É INDEPENDENTE DO PAIS
         * MOVE BHTL010A-C-PAIS-ISOA-OE-OPX
         */
        bhyl025a().commarea().dadosEntrada().cPaisIsoAlfn().set("PT ");
        bhyl025a().commarea().dadosEntrada().aAplicacao().set("93");
        bhyp0025Mhyj025a() ;
        messageV2.mensagem().cTipoErroBbn().set(bhyl025a().commarea().dadosSaida().cTipoErroBbn());
        if (!messageV2.mensagem().semErros().isTrue()) {
            messageV2.mensagem().aAplErro().set(bhyl025a().commarea().dadosSaida().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            progStatus.set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(bhyl025a().commarea().dadosSaida().cSqlcode());
            envOut.db2Log().nmTabela().set(bhyl025a().commarea().dadosSaida().nmTabela());
        } else {
            wsVariaveis().wsDataDispMovSd().set(bhyl025a().commarea().dadosSaida().zProcessamento());
        }
        bhyl008a().commarea().initialize() ;
        /**
         * TRATA-SE DO SEMAFORO QUE É INDEPENDENTE DO PAIS
         * MOVE BHTL010A-C-PAIS-ISOA-OE-OPX
         */
        bhyl008a().commarea().dadosEntrada().cPaisIsoAlfn().set("PT ");
        bhyl008a().commarea().dadosEntrada().aAplicacao().set("HO");
        bhyp0008Mhyj008a() ;
        messageV2.mensagem().cTipoErroBbn().set(bhyl008a().commarea().dadosSaida().cTipoErroBbn());
        if (!messageV2.mensagem().semErros().isTrue()) {
            messageV2.mensagem().aAplErro().set(bhyl008a().commarea().dadosSaida().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            progStatus.set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(bhyl008a().commarea().dadosSaida().cSqlcode());
            envOut.db2Log().nmTabela().set(bhyl008a().commarea().dadosSaida().nmTabela());
        }
        bhyl230a().commarea().initialize() ;
        bhyl230a().commarea().dadosEntrada().cFunzMdloData().set("06");
        bhyl230a().commarea().dadosEntrada().iTipoExe().set("R");
        bhyl230a().commarea().dadosEntrada().datInput1().set(wsVariaveis().wsDataDispMovSd());
        bhyl230a().commarea().dadosEntrada().datInput2().set(bhyl008a().commarea().dadosSaida().zProcessamento());
        bhyp0200RotinaDatas() ;
        if (!bhyl230a().commarea().dadosSaida().estado().semErros().isTrue()) {
            messageV2.mensagem().aAplErro().set(bhyl230a().commarea().dadosSaida().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            progStatus.set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(bhyl230a().commarea().dadosSaida().estado().cSqlcode());
            envOut.db2Log().nmTabela().set(bhyl230a().commarea().dadosSaida().estado().nmTabela());
        } else {
            wsDuTipoPraz.set(bhyl230a().commarea().dadosSaida().qDiaOutp());
        }
    }
    
    /**
     * 
     * 3000-RESPONDER
     * 
     */
    protected void m3000Responder() {
        log(TraceLevel.Debug, "--- PGHS111A - 3000-RESPONDER");
        log(TraceLevel.Debug, "WS-TOT-ENVR : ", wsTotEnvr);
        if (progOk.isTrue()) {
            /**
             * AND NOT BHTL010A-FIM-CONSULTA
             */
            if (wsTotEnvr.isEqual(0)) {
                if (!msgOut().msg().ade().iBloco().isEqual("1")) {
                    progNaoExisteMov.setTrue() ;
                    messageV2.mensagem().aAplErro().set(CON_APL_HST);
                    messageV2.mensagem().cTipoErroBbn().set(CON_ERR_FUNC);
                }
            } else {
                m3100DescarregaTabela() ;
            }
        }
        messageV2.mensagem().cRtnoSwal().set(progStatus);
        if (progOk.isTrue()) {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont0().setTrue() ;
        } else {
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(progStatus);
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        messageV2.mensagem().campoLivre11().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        messageV2.mensagem().qCterCmpMsgInp().set(msgOut().qCterCmptAlig());
        messageV2.mensagem().x01Vizualizacao().setTrue() ;
        log(TraceLevel.Debug, "============================================");
        log(TraceLevel.Debug, "========== V R 0 4 = O U T P U T ===========");
        log(TraceLevel.Debug, "============================================");
        log(TraceLevel.Debug, " BGHM1111-I-MSG-CTND       : ", msgOut().msg().ade().iMsgCtnd());
        log(TraceLevel.Debug, " BGHM1111-TS-MOVIMENTO-K   : ", msgOut().msg().ade().tsMovimentoK());
        log(TraceLevel.Debug, " BGHM1111-NS-MOVIMENTO-K   : ", msgOut().msg().ade().nsMovimentoK());
        log(TraceLevel.Debug, " ............................");
        log(TraceLevel.Debug, " BGHM1111-Q-MOVIMENTOS     : ", msgOut().msg().ade().qMovimentos());
        log(TraceLevel.Debug, " BGHM1111-Q-MOV-CNSL       : ", msgOut().msg().ade().qMovCnsl());
        log(TraceLevel.Debug, " BGHM1111-I-BLOCO          : ", msgOut().msg().ade().iBloco());
        log(TraceLevel.Debug, " BHTL010A-A-APL-ERRO       : ", messageV2.mensagem().aAplErro());
        log(TraceLevel.Debug, " BHTL010A-C-TIPO-ERRO-BBN  : ", messageV2.mensagem().cTipoErroBbn());
        log(TraceLevel.Debug, " BHTL010A-C-RTNO-SWAL      : ", messageV2.mensagem().cRtnoSwal());
        log(TraceLevel.Debug, "============================================");
        log(TraceLevel.Debug, "========== V R 0 4 = O U T P U T ===========");
        log(TraceLevel.Debug, "============================================");
        wsTimeExe.set( getDBTimestamp() ) ;
        log(TraceLevel.Debug, "WS-TIME-EXE: ", wsTimeExe);
    }
    
    /**
     * 
     * 3100-DESCARREGA-TABELA
     * 
     */
    protected void m3100DescarregaTabela() {
        log(TraceLevel.Debug, "--- PGHS111A - 3100-DESCARREGA-TABELA");
        log(TraceLevel.Debug, "   WS-TOT-ENVR     :", wsTotEnvr);
        log(TraceLevel.Debug, "   WS-TOT-MOV-MAX  :", wsTotMovMax);
        log(TraceLevel.Debug, "BGHM1111-I-BLOCO   :", msgOut().msg().ade().iBloco());
        log(TraceLevel.Debug, "BGHM1110-Z-MOV-INI :", msgIn().msg().ade().zMovIni());
        log(TraceLevel.Debug, "WS-DATA-DISP-MOV-SD:", wsVariaveis().wsDataDispMovSd());
        log(TraceLevel.Debug, "BHTL010A-NS-VERS-MSG:", messageV2.mensagem().nsVersMsg());
        naoHaMais.setTrue() ;
        if (wsTotEnvr.isGreaterOrEqual(wsTotMovMax)) {
            haMais.setTrue() ;
        }
        msgOut().msg().ade().grMov().resetIndex() ;
        wsTotEnvr.set(1);
        naoSair.setTrue() ;
        while (wsTotEnvr.isLessOrEqual(wsTotMovMax) && !sair.isTrue()) {
            log(TraceLevel.Trace, "WS-TOT-ENVR:", wsTotEnvr);
            log(TraceLevel.Trace, "WA-TS-MOVIMENTO(WS-TOT-ENVR):", wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waTsMovimento());
            if (wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waTsMovimento().isEmpty()) {
                sair.setTrue() ;
            } else {
                msgOut().msg().ade().grMov().getCurrent().zMovimento().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waTsMovimento().get(1, 10));
                msgOut().msg().ade().grMov().getCurrent().nsMovimentoL().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waNsMovimento());
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
                msgOut().msg().ade().grMov().getCurrent().cCatgMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).waCCatgMov());
                log(TraceLevel.Debug, "WS-TOT-ENVR:", wsTotEnvr);
                log(TraceLevel.Debug, "BGHM1111-Z-MOVIMENTO(ALO-I1):", msgOut().msg().ade().grMov().getCurrent().zMovimento());
                log(TraceLevel.Debug, "BGHM1111-NS-MOVIMENTO-L(ALO-I1):", msgOut().msg().ade().grMov().getCurrent().nsMovimentoL());
                log(TraceLevel.Debug, "BGHM1111-Z-VAL-MOV(ALO-I1):", msgOut().msg().ade().grMov().getCurrent().zValMov());
                wsTotEnvr.add(1);
                msgOut().msg().ade().grMov().incIndex() ;
            }
        }
        if (haMais.isTrue()) {
            msgOut().msg().ade().iMsgCtnd().set("S");
            msgOut().msg().ade().tsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(wsTotMovMax).waTsMovimento());
            msgOut().msg().ade().nsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(wsTotMovMax).waNsMovimento());
        } else {
            if (!wsTabelaMovimento().wsMovimentos().get(wsTotMovMax).waNsMovimento().isEqual(0)) {
                msgOut().msg().ade().tsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(wsTotMovMax).waTsMovimento());
                msgOut().msg().ade().nsMovimentoK().set(wsTabelaMovimento().wsMovimentos().get(wsTotMovMax).waNsMovimento());
            }
            msgOut().msg().ade().iMsgCtnd().set("N");
            messageV2.mensagem().cTipoErroBbn().set(CON_FIM_CONSULTA);
            if ((wsVariaveis().wsDataDispMovSd2().isGreaterOrEqual(msgIn().msg().ade().zMovIni()) && 
                messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1)) || 
                (msgIn().msg().ade().zMovIni().isGreater(wsVariaveis().wsDataDispMovSd()) && 
                messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1)) || 
                (messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1) && 
                msgIn().msg().ade().iBloco().isEmpty()) || 
                (messageV2.mensagem().nsVersMsg().isGreaterOrEqual(1) && 
                msgIn().msg().ade().iBloco().isEqual("2") && 
                msgIn().msg().ade().descendente().isTrue())) {
                /**
                 * OR  BHTL010A-NS-VERS-MSG = 2
                 */
                msgOut().msg().ade().iBloco().set("3");
            } else {
                msgOut().msg().ade().iBloco().set("1");
            }
        }
        log(TraceLevel.Debug, "--- PGHS111A - 3100-DESCARREGA-TABELA - 1");
        log(TraceLevel.Debug, "BGHM1111-I-BLOCO:", msgOut().msg().ade().iBloco());
        log(TraceLevel.Debug, "  BGHM1111-I-MSG-CTND            : ", msgOut().msg().ade().iMsgCtnd());
        log(TraceLevel.Debug, "  WA-TS-MOVIMENTO(WS-TOT-MOV-MAX): ", wsTabelaMovimento().wsMovimentos().get(wsTotMovMax).waTsMovimento());
        log(TraceLevel.Debug, "  WA-NS-MOVIMENTO(WS-TOT-MOV-MAX): ", wsTabelaMovimento().wsMovimentos().get(wsTotMovMax).waNsMovimento());
        log(TraceLevel.Debug, "  BHTL010A-C-TIPO-ERRO-BBN       : ", messageV2.mensagem().cTipoErroBbn());
        /**
         * IF WS-TOT-ENVR < 67
         */
        if (wsTotEnvr.isLess(66)) {
            log(TraceLevel.Debug, "   SW-CRT-MAIS ", swCrtMais);
            log(TraceLevel.Debug, "   BGHM1111-Z-MOVIMENTO((ALO-I1) ", msgOut().msg().ade().grMov().getCurrent().zMovimento());
            log(TraceLevel.Debug, "   BGHM1111-Z-MOVIMENTO(WS-TOT-ENVR) ", msgOut().msg().ade().grMov().get(wsTotEnvr).zMovimento());
            log(TraceLevel.Debug, "   BGHM1111-NS-MOVIMENTO-L(WS-TOT-ENVR) ", msgOut().msg().ade().grMov().get(wsTotEnvr).nsMovimentoL());
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        m0000Mainline() ;
    }
    /**
     * Inner Classes
     */
    
    /**
     * 
     * VARIAVEIS
     * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=8, value=" ")
        IString wsNmRotina() ;
        
        @Data(size=10, signed=true, value="0", compression=COMP3)
        ILong wsQMovTgh2() ;
        
        @Data(size=10, signed=true, value="0", compression=COMP3)
        ILong wsQMovTgh22() ;
        
        @Data(size=10, value="0")
        ILong wsQMovTot() ;
        
        @Data(size=10, value=" ")
        IString wsTsMovIni() ;
        
        @Data(size=10, value=" ")
        IString wsTsMovFim() ;
        
        @Data(size=1, value=" ")
        IString wsCrit1() ;
        
        @Data(size=1, value=" ")
        IString wsCrit2() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMMovMin() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMMovMax() ;
        
        @Data(size=10, value=" ")
        IString wsZMovimento13() ;
        
        @Data(size=10, value=" ")
        IString wsZMovimentoUlt() ;
        
        @Data(size=10, value=" ")
        IString wsDataDispMovSd() ;
        
        @Data(size=10, value=" ")
        IString wsDataDispMovSd2() ;
        
        @Data(size=26, value=" ")
        IString wsTsMovimento13() ;
        
        @Data(size=15, value="0")
        ILong wsNsMovimento13() ;
        
    }
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
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
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
         * 05 WS-MOVIMENTOS        OCCURS 68 TIMES
         * 05 WS-MOVIMENTOS        OCCURS 66 TIMES
         * @return instancia da classe local WsMovimentos
         */
        @Data(length=67)
        IArray<WsMovimentos> wsMovimentos() ;
        
        
        
        /**
         * 
         * 05 WS-MOVIMENTOS        OCCURS 68 TIMES
         * 05 WS-MOVIMENTOS        OCCURS 66 TIMES
         * 
         * @version 2.0
         * 
         */
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
            
            @Data(size=3)
            IString waCCatgMov() ;
            
        }
    }
    
}
