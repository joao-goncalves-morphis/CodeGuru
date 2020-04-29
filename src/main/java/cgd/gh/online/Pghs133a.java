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
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm1130 ;
import cgd.gh.structures.messages.Bghm1131 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hj.structures.link.Bhjl027a ;
import cgd.hj.structures.link.Bhjl006a ;
import cgd.hg.structures.link.Bhgl052a ;
import cgd.hj.structures.link.Bhjl707a ;
import cgd.hj.structures.link.Bhjl249a ;
import cgd.hj.structures.link.Bhjl470a ;
import cgd.ho.structures.link.Bhol708a ;
import cgd.ho.structures.link.Bhol710a ;
import cgd.hy.structures.work.Bhyw0001 ;
import cgd.hj.structures.link.Bhjl628a ;
import cgd.ho.structures.link.Bhol002a ;
import cgd.hj.structures.link.Bhjl013a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.ho.common.constants.Bhok0001 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.gh.common.constants.Bghk0005 ;
import cgd.hj.common.constants.Bhjk0001 ;
import cgd.hj.common.constants.Bhjk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.routines.Mhts220a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj052a ;
import cgd.hj.routines.Mhjs006a ;
import cgd.hj.routines.Mhjj027a ;
import cgd.hj.routines.Mhjj470a ;
import cgd.hj.routines.Mhjj707a ;
import cgd.hj.routines.Mhjj249a ;
import cgd.ho.routines.Mhoj708a ;
import cgd.ho.routines.Mhoj710a ;
import cgd.hj.routines.Mhjj628a ;
import cgd.ho.routines.Mhoj002a ;
import cgd.hj.routines.Mhjj060a ;
import cgd.hj.routines.Mhjj013a ;
import cgd.hj.online.Phjs625a ;
import cgd.js.routines.Mjss130a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS133A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1488 - TERC - 1ª FASE - TRANSAÇÕES ON-LINE
 * FUNCAO     : MANUTENCAO IDENTIFICACAO INTERVENIENTE NA OPERACAO*
 * - DEPOSITOS / LEVANTAMENTOS / PAGAMENTOS DE CHEQUE
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES: LOCAL MVPHIH
 * LOG DE ALTERACOES
 * *PROC.GIP !   DATA   !UTILIZ.! OBSERVACOES
 * GH1488  !2014-07-17!DACT480! TERC - FASE 1 -CRIACAO DO PROGRAMA*
 * GH1621  !2014-11-28!DACT202! CARTOES EMPRESA -- NESTE PROCESSO
 * FOI ALTERADO O MODO COMO E REGISTADA A INFORMACAO DOS
 * DOS CARTOES EMPRESA NA BASE DE DADOS. AS VALIDACOES
 * MANTEM-SE TODAS IGUAIS ATE AO MOMENTO EM QUE VALIDA OS
 * MONTANTES, COMPORTANDO-SE NESSE MOMENTO COMO MANDATARIO*
 * DA CONTA SENDO REGISTADO NA BD COMO TAL.
 * GH1629  !2015-01-16!DACT649! TERC - FASE 3 - IDENTIFICACAO DO
 * INTERVENIENTE NOS LEVANTAMENTOS / PAGAMENTOS DE CHEQUE*
 * GH1981  !2017-01-18!E002444! CASO A CONTA POSSUA UMA NOVA
 * RESTRICAO ASSOCIADA AO CAMPO VHO00201-I-TIPO-RSTZ-MOVZ*
 * DEVOLVE 'INIBICAO MOVIMENTACAO DE NUMERARIO'
 * GHXXX   ! 2018-5-17!E001881!PREENCHER O NOME DO CLIENTE PARA
 * MADATARIOS E PRESTADORES SERVICO
 * *PASS2972 !2018-09-20!E003881! -FORMATACAO DA DATA DOS DOCUMENTOS*
 * VITALICIOS COM 2399-12-31 EM VEZ
 * DE 9999-12-31;
 * -FORMATACAO DO INDICADOR
 * BGHM1131-VALIDA-DOC-ID.
 * GH2161  !2018-11-23!E001881!PASSAR A VALIDAR OS DOC E COMPROVA-*
 * ! TIVOS PELA CLIJG6
 * GH2186  !2019-01-22!E001881!ALTERACAO IF ACESSO PARAGRAFO 1300
 * PASSIVAS 4357  !2019-08-28
 * SEMPRE QUE A OPERACAO CORRESPONDA A UM PRIMEIRO DEPOSITO EM
 * NUMERARIO DEVE SER DISPONIBILIZADA UMA MENSAGEM AO UTILIZADOR
 * ALERTANDO PARA A IMPOSSIBILIDADE DE CONCRETIZAR ESTE TIPO DE
 * OPERACAO EM CONTAS COM O NOVO CODIGO DE RESTRICAO 3
 * *PASS4497 !2019-10-15!ACCENTU! UCO 2.7 - LEI N.º 83  OSI3656
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs133a extends CgdGhBaseOnline<Pghs133a.EnvelopeIn, Pghs133a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1130
     */
    public abstract Bghm1130 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1131
     */
    public abstract Bghm1131 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1130.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1131.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps13001Movdep
     */
    @Data
    protected abstract Vwsdghps13001Movdep hv13001Movdep() ;
    
    
    /**
     * Handled Services
     */
    /**
     * @return instancia da classe Phjs625a
     */
    protected abstract Phjs625a hoPhjs625a() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhts220a
     */
    @Data
    protected abstract Mhts220a hrMhts220a() ;
    
    /**
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    /**
     * @return instancia da classe Mhgj052a
     */
    @Data
    protected abstract Mhgj052a hrMhgj052a() ;
    
    /**
     * @return instancia da classe Mhjs006a
     */
    @Data
    protected abstract Mhjs006a hrMhjs006a() ;
    
    /**
     * @return instancia da classe Mhjj027a
     */
    @Data
    protected abstract Mhjj027a hrMhjj027a() ;
    
    /**
     * @return instancia da classe Mhjj470a
     */
    @Data
    protected abstract Mhjj470a hrMhjj470a() ;
    
    /**
     * @return instancia da classe Mhjj707a
     */
    @Data
    protected abstract Mhjj707a hrMhjj707a() ;
    
    /**
     * @return instancia da classe Mhjj249a
     */
    @Data
    protected abstract Mhjj249a hrMhjj249a() ;
    
    /**
     * @return instancia da classe Mhoj708a
     */
    @Data
    protected abstract Mhoj708a hrMhoj708a() ;
    
    /**
     * @return instancia da classe Mhoj710a
     */
    @Data
    protected abstract Mhoj710a hrMhoj710a() ;
    
    /**
     * @return instancia da classe Mhjj628a
     */
    @Data
    protected abstract Mhjj628a hrMhjj628a() ;
    
    /**
     * @return instancia da classe Mhoj002a
     */
    @Data
    protected abstract Mhoj002a hrMhoj002a() ;
    
    /**
     * @return instancia da classe Mhjj060a
     */
    @Data
    protected abstract Mhjj060a hrMhjj060a() ;
    
    /**
     * @return instancia da classe Mhjj013a
     */
    @Data
    protected abstract Mhjj013a hrMhjj013a() ;
    
    /**
     * @return instancia da classe Mjss130a
     */
    @Data
    protected abstract Mjss130a hrMjss130a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhjl027a
     */
    @Data
    protected abstract Bhjl027a bhjl027a() ;
    
    /**
     * @return instancia da classe Bhjl006a
     */
    @Data
    protected abstract Bhjl006a bhjl006a() ;
    
    /**
     * @return instancia da classe Bhgl052a
     */
    @Data
    protected abstract Bhgl052a bhgl052a() ;
    
    /**
     * @return instancia da classe Bhjl707a
     */
    @Data
    protected abstract Bhjl707a bhjl707a() ;
    
    /**
     * @return instancia da classe Bhjl249a
     */
    @Data
    protected abstract Bhjl249a bhjl249a() ;
    
    /**
     * @return instancia da classe Bhjl470a
     */
    @Data
    protected abstract Bhjl470a bhjl470a() ;
    
    /**
     * @return instancia da classe Bhol708a
     */
    @Data
    protected abstract Bhol708a bhol708a() ;
    
    /**
     * @return instancia da classe Bhol710a
     */
    @Data
    protected abstract Bhol710a bhol710a() ;
    
    /**
     * @return instancia da classe Bhyw0001
     */
    @Data
    protected abstract Bhyw0001 bhyw0001() ;
    
    /**
     * @return instancia da classe Bhjl628a
     */
    @Data
    protected abstract Bhjl628a bhjl628a() ;
    
    /**
     * @return instancia da classe Bhol002a
     */
    @Data
    protected abstract Bhol002a bhol002a() ;
    
    /**
     * @return instancia da classe Bhjl013a
     */
    @Data
    protected abstract Bhjl013a bhjl013a() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe local Bhok0001Pghs133a
     */
    @Data
    protected abstract Bhok0001Pghs133a bhok0001() ;
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * @return instancia da classe Bghk0005
     */
    @Data
    protected abstract Bghk0005 bghk0005() ;
    
    /**
     * @return instancia da classe Bhjk0001
     */
    @Data
    protected abstract Bhjk0001 bhjk0001() ;
    
    /**
     * @return instancia da classe Bhjk0002
     */
    @Data
    protected abstract Bhjk0002 bhjk0002() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHS133A" ;
    
    protected static final String CON_MGHS111A = "MGHS111A" ;
    
    protected static final String CON_APLICACAO_GH = "GH" ;
    
    protected static final String CON_NAO = "N" ;
    
    protected static final String CON_SIM = "S" ;
    
    /**
     * *---TIPO DE CLIENTE---
     */
    protected static final String CON_EMPRESA = "E" ;
    
    protected static final String CON_PARTICULAR = "P" ;
    
    protected static final String CON_MENOR = "M" ;
    
    /**
     * *---TIPO DE INTERVENIENTE---
     */
    protected static final String CON_PROPRIO = "P" ;
    
    protected static final String CON_TERCEIROS = "T" ;
    
    protected static final String CON_MANDATARIO = "M" ;
    
    protected static final String CON_DEP_EXPRESSO_24H = "E" ;
    
    protected static final String CON_BENE_CHQ = "B" ;
    
    protected static final String CON_OUTRO = "O" ;
    
    /**
     * *---CANAL---
     */
    protected static final String CON_BALCAO = "BALC" ;
    
    protected static final String CON_ATS = "ATS" ;
    
    /**
     * *---ALERTAS DE ENTREGA---
     */
    protected static final String CON_MONT_ENTREGA = "E" ;
    
    protected static final String CON_ACUM_DEP_ATING = "D" ;
    
    protected static final String CON_ACUM_CNT_ATING = "C" ;
    
    /**
     * *---ALERTAS DE LEVANTAMENTO---
     */
    protected static final String CON_LEV_NMRI = "L" ;
    
    protected static final String CON_ACMD_ITV_LEV = "I" ;
    
    protected static final String CON_ACMD_LEV_CTA = "T" ;
    
    /**
     * *---ALERTAS DE PAGAMENTO DE CHEQUE---
     */
    protected static final String CON_CHQ_NMRI = "Q" ;
    
    protected static final String CON_ACMD_BENE_CHQ = "B" ;
    
    /**
     * *---DB2---
     */
    protected static final String CON_VGH13001 = "VGH13001" ;
    
    protected static final String CON_DATA_MIN = "0001-01-01" ;
    
    protected static final String CON_DATA_MAX = "9999-12-31" ;
    
    /**
     * *---TIPO DE MOVIMENTO---
     */
    protected static final String CON_CREDITO = "C" ;
    
    protected static final String CON_DEBITO = "D" ;
    
    protected static final int CON_1_TITULAR = 1 ;
    
    protected static final int CON_ZERO = 0 ;
    
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_10N = 10 ;
    
    protected static final int CON_11N = 11 ;
    
    protected static final int CON_250N = 250 ;
    
    protected static final int CON_100N = 100 ;
    
    /**
     * *---TABELAS GERAIS---
     */
    protected static final String CON_TIPODOCID_886 = "886" ;
    
    protected static final String CON_REGMJRDC_879 = "879" ;
    
    protected static final String CON_MOEDA_EURO = "EUR" ;
    
    /**
     * *---CODIGO TIPO DE MOVIMENTO DE SUBCONTA - C-TIPO-MOV-SCTA
     */
    protected static final String CON_ENTREGA = "E" ;
    
    protected static final String CON_LEVANTAMENTO = "L" ;
    
    /**
     * *---DOCUMENTOS VALIDOS PARA CLIENTES EMPRESA NAS ENTREGA EM ATS---
     * @return instancia da classe local ConDocNipc
     */
    @Data
    protected abstract ConDocNipc conDocNipc() ;
    
    /**
     * @return instancia da classe local ConDocNfie
     */
    @Data
    protected abstract ConDocNfie conDocNfie() ;
    
    /**
     * @return instancia da classe local ConDocNpc
     */
    @Data
    protected abstract ConDocNpc conDocNpc() ;
    
    /**
     * @return instancia da classe local ConDocNife
     */
    @Data
    protected abstract ConDocNife conDocNife() ;
    
    /**
     * *GH1621 - INI
     */
    protected static final String CON_MANDATARIO_EMP_CARD = "D" ;
    
    /**
     * *GH1621 - FIM
     * GH1981 - E002444 - 2017-01-18 - INICIO
     */
    protected static final String CON_0 = "0" ;
    
    protected static final String CON_1 = "1" ;
    
    protected static final String CON_2 = "2" ;
    
    /**
     * GH1981 - E002444 - 2017-01-18 - FIM
     * PASSIVAS 4357 - INI
     */
    protected static final String CON_3 = "3" ;
    
    protected static final int CON_0N = 0 ;
    
    /**
     * PASSIVAS 4357 - FIM
     * *PASS2972 - INI
     */
    protected static final String CON_9901VITAL = "9901VITAL" ;
    
    protected static final String CON_9902VITAL = "9902VITAL" ;
    
    protected static final String CON_9903VITAL = "9903VITAL" ;
    
    protected static final String CON_9901VTSSO2 = "9901VTSSO2" ;
    
    protected static final String CON_9902VTSSO2 = "9902VTSSO2" ;
    
    protected static final String CON_9903VTSSO2 = "9903VTSSO2" ;
    
    protected static final String CON_DATA_MAX_VIT = "2399-12-31" ;
    
    /**
     * CONSTANTES PARA VALIDACAO DOC CLIJG6
     */
    protected static final String CON_PHJS625A = "PHJS625A" ;
    
    protected static final int CON_IND_CLIJG6 = 12 ;
    
    protected static final int CON_01 = 1 ;
    
    /**
     * *PASS2972 - FIM
     */
    @Data(size=8, signed=true, compression=COMP)
    protected ILong cicscode ;
    
    /**
     * TABELA INTERNAS
     * @return instancia da classe local WsTabelasInternas
     */
    @Data
    protected abstract WsTabelasInternas wsTabelasInternas() ;
    
    /**
     * @return instancia da classe local WsTsTransaccao
     */
    @Data
    protected abstract WsTsTransaccao wsTsTransaccao() ;
    
    @Data(size=6, value="0")
    protected IInt wsTempoN6 ;
    
    /**
     * @return instancia da classe local WsTempo
     */
    @Data
    protected abstract WsTempo wsTempo() ;
    
    /**
     * @return instancia da classe local SwSwitchs
     */
    @Data
    protected abstract SwSwitchs swSwitchs() ;
    
    
    
    /**
     * 
     * 
     */
    protected void bhtp0003() {
        bhyw0001().journal().set(" ");
        bhyw0001().header2().initialize() ;
        bhyw0001().journal().headerMsg().set(message.mensagem().header());
        bhyw0001().journal().headerMsg().iTrnzSimz().set(message.mensagem().headerR().iTrnzSimz());
        bhyw0001().journal().headerMsg().iTrnzCblo().set(message.mensagem().headerR().iTrnzCblo());
        bhyw0001().journal().hProcessamento().set(envIn.controlo().hSessao());
        bhyw0001().journal().nEltnJourBbnKey().zProcessamentoKey().set(message.mensagem().headerR().nrElectronico().zProcessamento());
        bhyw0001().journal().nEltnJourBbnKey().cMnemEgcOpexKey().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhyw0001().journal().nEltnJourBbnKey().cPaisIsoaOpxKey().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhyw0001().journal().nEltnJourBbnKey().cOeEgcOpexKey().set(message.mensagem().headerR().nrElectronico().cOeEgcOpex());
        bhyw0001().journal().nEltnJourBbnKey().cUseridKey().set(message.mensagem().headerR().nrElectronico().cUserid());
        bhyw0001().journal().headerMsg().cTerminal().set(message.mensagem().headerR().cTerminal());
        bhyw0001().journal().headerMsg().nrElectronico().nJourBbn().set(message.mensagem().headerR().nrElectronico().nJourBbn());
        bhyw0001().journal().nEltnJourBbnKey().nJourBbnKey().set(message.mensagem().headerR().nrElectronico().nJourBbn());
        bhyw0001().journal().nsJourBbnKey().set(envOut.journal().nsJourBbn());
        bhyw0001().cImgTabJour().set(envOut.cImgTabJour());
        bhyw0001().journal().nmPrograma().set(envIn.cct().nmPrograma());
        bhyw0001().journal().xIdMovCriv().set(0);
        bhyw0001().journal().aAplCanl().set(envOut.header1().aAplCanl());
        bhyw0001().journal().aAplOrig().set(envOut.header3().aAplOrig());
        bhyw0001().journal().cOpczMenuOrig().set(envOut.header3().cOpczMenuOrig());
        bhyw0001().header2().set(envOut.header2());
        /**
         * *----------------------------------------------------------------*
         * INICIALIZA DADOS DAS CONTAS
         */
        bhyw0001().journal().dadosConta().get(1).cBancCont().set(0);
        bhyw0001().journal().dadosConta().get(2).cBancCont().set(0);
        bhyw0001().journal().dadosConta().get(3).cBancCont().set(0);
        bhyw0001().journal().dadosConta().get(1).cOeEgcCont().set(0);
        bhyw0001().journal().dadosConta().get(2).cOeEgcCont().set(0);
        bhyw0001().journal().dadosConta().get(3).cOeEgcCont().set(0);
        bhyw0001().journal().dadosConta().get(1).cOeEgcCont().set(0);
        bhyw0001().journal().dadosConta().get(2).cOeEgcCont().set(0);
        bhyw0001().journal().dadosConta().get(3).cOeEgcCont().set(0);
        bhyw0001().journal().dadosConta().get(1).nsRdclCont().set(0);
        bhyw0001().journal().dadosConta().get(2).nsRdclCont().set(0);
        bhyw0001().journal().dadosConta().get(3).nsRdclCont().set(0);
        bhyw0001().journal().dadosConta().get(1).vChkdCont().set(0);
        bhyw0001().journal().dadosConta().get(2).vChkdCont().set(0);
        bhyw0001().journal().dadosConta().get(3).vChkdCont().set(0);
        bhyw0001().journal().dadosConta().get(1).cTipoCont().set(0);
        bhyw0001().journal().dadosConta().get(2).cTipoCont().set(0);
        bhyw0001().journal().dadosConta().get(3).cTipoCont().set(0);
        bhyw0001().journal().dadosConta().get(1).nsDeposito().set(0);
        bhyw0001().journal().dadosConta().get(2).nsDeposito().set(0);
        bhyw0001().journal().dadosConta().get(3).nsDeposito().set(0);
        bhyw0001().journal().dadosConta().get(1).nCliente().set(0);
        bhyw0001().journal().dadosConta().get(2).nCliente().set(0);
        bhyw0001().journal().dadosConta().get(3).nCliente().set(0);
        bhyw0001().journal().dadosConta().get(1).cOeEgcTit().set(0);
        bhyw0001().journal().dadosConta().get(2).cOeEgcTit().set(0);
        bhyw0001().journal().dadosConta().get(3).cOeEgcTit().set(0);
        bhyw0001().journal().dadosConta().get(1).cSectIttlBpor().set(0);
        bhyw0001().journal().dadosConta().get(2).cSectIttlBpor().set(0);
        bhyw0001().journal().dadosConta().get(3).cSectIttlBpor().set(0);
        bhyw0001().journal().dadosConta().get(1).mLncdContLiq().set(0);
        bhyw0001().journal().dadosConta().get(2).mLncdContLiq().set(0);
        bhyw0001().journal().dadosConta().get(3).mLncdContLiq().set(0);
        bhyw0001().journal().dadosConta().get(1).mSldoCblo().set(0);
        bhyw0001().journal().dadosConta().get(2).mSldoCblo().set(0);
        bhyw0001().journal().dadosConta().get(3).mSldoCblo().set(0);
        bhyw0001().journal().dadosConta().get(1).mSldoDpnl().set(0);
        bhyw0001().journal().dadosConta().get(2).mSldoDpnl().set(0);
        bhyw0001().journal().dadosConta().get(3).mSldoDpnl().set(0);
        bhyw0001().journal().dadosConta().get(1).cAe().set(0);
        bhyw0001().journal().dadosConta().get(2).cAe().set(0);
        bhyw0001().journal().dadosConta().get(3).cAe().set(0);
        /**
         * *----------------------------------------------------------------*
         * INICIALIZA DADOS DOS MOVIMENTOS DAS CONTAS
         */
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(1).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(2).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(3).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(4).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(5).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(6).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(7).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(8).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(1).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(2).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(3).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(4).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(5).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(6).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(7).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(8).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(1).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(2).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(3).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(4).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(5).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(6).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(7).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(8).mBaseIcdcMov().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(1).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(2).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(3).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(4).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(5).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(6).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(7).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(8).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(1).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(2).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(3).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(4).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(5).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(6).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(7).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(8).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(1).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(2).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(3).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(4).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(5).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(6).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(7).mMovimento().set(0);
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(8).mMovimento().set(0);
        /**
         * *----------------------------------------------------------------*
         * INICIALIZA OUTROS DADOS
         */
        bhyw0001().journal().qCterCmptAlig().set(0);
        bhyw0001().journal().qCampEstTrnz().set(0);
        /**
         * *----------------------------------------------------------------*
         * INICIALIZA I-TIPO-NMRI COM '0' - NAO APLICAVEL
         */
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(1).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(2).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(3).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(4).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(5).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(6).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(7).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(1).dadosMovimento().get(8).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(1).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(2).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(3).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(4).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(5).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(6).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(7).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(2).dadosMovimento().get(8).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(1).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(2).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(3).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(4).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(5).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(6).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(7).iTipoNmri().set("0");
        bhyw0001().journal().dadosConta().get(3).dadosMovimento().get(8).iTipoNmri().set("0");
    }
    
    /**
     * 
     * 
     */
    protected void bhtp0005() {
        hrMhts220a().bhtl220a().commarea().header2().initialize() ;
        hrMhts220a().bhtl220a().commarea().cTipoErroBbn().set(" ");
        hrMhts220a().bhtl220a().commarea().cRtnoEvenSwal().set(0);
        hrMhts220a().bhtl220a().commarea().qCterCmptAlig().set(0);
        hrMhts220a().bhtl220a().commarea().xCteuRegJour().set(bhyw0001().journal());
        hrMhts220a().bhtl220a().commarea().cImgTabJour().set(bhyw0001().cImgTabJour());
        hrMhts220a().bhtl220a().commarea().header2().set(bhyw0001().header2());
        hrMhts220a().run() ;
        if (!hrMhts220a().bhtl220a().commarea().semErros().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(hrMhts220a().bhtl220a().commarea().cTipoErroBbn());
            envOut.errosGraves().cRtnoEvenSwal().set(hrMhts220a().bhtl220a().commarea().cRtnoEvenSwal());
            envOut.db2Log().sqlca().set(hrMhts220a().bhtl220a().commarea().sqlca());
            envOut.errosGraves().aAplErr().set(hrMhts220a().bhtl220a().commarea().sqlca().aAplErr());
        }
    }
    
    /**
     * 
     * TABELA GERAIS - ACESSO A TABELAS GERAIS
     * 
     */
    protected void bhgp0030AcessoTabela() {
        hrMhgj030a().run() ;
    }
    
    /**
     * 
     * ACESSO ROTINA MHGJ052A
     * 
     */
    protected void bhgp0052AcedeMhgj052a() {
        hrMhgj052a().run() ;
    }
    
    /**
     * 
     * BHJP6006-ACESSO AO MODULO QUE VALIDA A EXISTENCIA DO CLIENTE
     * E DEVOLVE ALGUNS INDICADORES BASICOS (MHJS006A)
     * 
     */
    protected void bhjp6006AcedeMhjs006a() {
        hrMhjs006a().run() ;
    }
    
    /**
     * 
     * BHJP5027-ACESSO AO MODULO QUE OBTEM E VALIDA CLIENTE
     * POR DOCUMENTO DE IDENTIFICACAO (MHJJ027A)
     * 
     */
    protected void bhjp5027AcedeMhjj027a() {
    }
    
    /**
     * 
     * BHJP5470 - ACESSO AO MODULO DE OBTENCAO DE INFORMACAO
     * DO ESTADO DO CLIENTE ATRIBUIDO PELO FILTERING
     * 
     */
    protected void bhjp5470AcedeMhjj470a() {
        hrMhjj470a().run() ;
    }
    
    /**
     * 
     * BHJP0707-ACESSO AO MODULO DE OBTENCAO DOS DOCUMENTOS
     * DE IDENTIFICACAO DO CLIENTE (MHJJ707A)
     * 
     */
    protected void bhjp0707AcedeMhjj707a() {
        hrMhjj707a().run() ;
    }
    
    /**
     * 
     * BHJP5249-ACESSO AO MODULO QUE OBTEM OBTEM OS CONTRATOS ACTIVOS
     * DE UM CLIENTE NUMA DETERMINADA DATA , COM POSSIBILIDADE DE
     * LIMITAR OS RESULTADOS POR  I_TIPO_ITVT (MHJJ249A)
     * 
     */
    protected void bhjp5249AcedeMhjj249a() {
        hrMhjj249a().run() ;
    }
    
    /**
     * 
     * BHOP0708 - COPY PROCEDURE DE CHAMADA A ROTINA DE VALIDACAO DE
     * CONTA E SITUACAO CONTRA ACCAO
     * 
     */
    protected void bhop0708ValConta() {
        hrMhoj708a().run() ;
    }
    
    /**
     * 
     * BHOP0710 - COPY PROCEDURE DE CHAMADA A ROTINA DE VALIDACAO
     * DE SUBCONTA E SITUACAO CONTRA ACCAO
     * 
     */
    protected void bhop0710ValSubconta() {
        hrMhoj710a().run() ;
    }
    
    /**
     * 
     * ROTINA DE MANUTENCAO DA TABELA DE DOCUMENTOS
     * DE IDENTIFICACAO (THJ00023)
     * 
     */
    protected void bhjp0628Mhjj628a() {
        hrMhjj628a().run() ;
    }
    
    /**
     * 
     * ACESSO ROTINA MHOJ002A
     * 
     */
    protected void bhop1002AcessoMhoj002a() {
        hrMhoj002a().run() ;
    }
    
    /**
     * 
     * BHJP5060-MODULO DE OBTENCAO DO CLIENTE INTERVENIENTE NO
     * CONTRATO POR DATA
     * 
     */
    protected void bhjp5060AcedeMhjj060a() {
        hrMhjj060a().run() ;
    }
    
    /**
     * 
     * BHJP5013-ACESSO AO MODULO DE OBTENCAO DOS DADOS
     * BASICOS DO CLIENTE (MHJJ013A)
     * 
     */
    protected void bhjp5013AcedeMhjj013a() {
        hrMhjj013a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "***** INICIO * GHIH * MVPHIH * INICIO ********");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "0000-MAINLINE");
        /**
         * *QUANDO PB:NA 1 CHAMADA , OS CAMPOS BGHM1130-I-VALIDA-DOC-ID E
         * BGHM1131-I-VALIDA-DOC-ID ESTAO AMBOS A ESPACO. SO EXECUTA
         * A 2 VEZ SE O CAMPO CAMPO BGHM1131-I-VALIDA-DOC-ID IGUAL A S.
         * A 2 EXECUCAO TEM DE ACABAR COM BGHM1131-I-VALIDA-DOC-ID PARA
         * A PB NAO LIMPAR OS CAMPOS DE OUTPUT.
         * QUANDO BGHM1131-I-VALIDA-DOC-ID IGUAL A S, A PB LIMPA O OUTPUT
         */
        m1000InicioPrograma() ;
        /**
         * *PASS2972 - FIM
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            log(TraceLevel.Debug, " BGHM1131-I-VALIDA-DOC-ID: ", msgOut().msg().ade().iValidaDocId());
            /**
             * *PASS2972 - INI
             */
            if (msgOut().msg().ade().iValidaDocId().isEqual(CON_NAO) || 
                !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO)) {
                /**
                 * *PASS2972 - FIM
                 */
                m2000ProcessoPrograma() ;
            }
        }
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * INICIA VARIAVEIS  ASSOCIADAS AO PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, " 1000-INICIO-PROGRAMA");
        wsTempo().wsDataDb2().set( getDBDate() ) ;
        /**
         * *GH2161-INICIO-COMENTAR
         * WS-TAB-INTERNA-DOC
         * *GH2161-COMENTAR
         * GH1981 - E002444 - 2017-01-18 - INICIO
         * GH1981 - E002444 - 2017-01-18 - FIM
         */
        swSwitchs().initialize() ;
        wsTabelasInternas().initialize() ;
        hv13001Movdep().movdep().initialize() ;
        msgOut().msg().initialize() ;
        bhjl027a().commarea().initialize() ;
        bhjl006a().commarea().initialize() ;
        bhgl052a().commarea().initialize() ;
        bhjl707a().commarea().initialize() ;
        bhjl249a().commarea().initialize() ;
        bhjl470a().commarea().initialize() ;
        bhol708a().commarea().initialize() ;
        bhol710a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        bhjl628a().commarea().initialize() ;
        bhol002a().commarea().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().msg().ade().set(msgIn().msg().ade());
        log(TraceLevel.Debug, "   BGHM1130-ASE  ", msgIn().msg().ase());
        log(TraceLevel.Debug, " BGHM1130-I-VALIDA-DOC-ID:", msgIn().msg().ade().iValidaDocId());
        m1100MensagemInput() ;
        if (msgIn().msg().ade().iValidaDocId().isEqual(CON_SIM)) {
            msgOut().msg().ade().iValidaDocId().set(CON_NAO);
        }
        if (msgIn().msg().ade().iValidaDocId().isEmpty() && 
            msgIn().msg().ade().cTipoItvtDep().isEqual(CON_PROPRIO) && 
            message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO)) {
            msgIn().msg().ade().cTipoItvtDep().set(CON_DEP_EXPRESSO_24H);
        }
        log(TraceLevel.Debug, " BGHM1131-I-VALIDA-DOC-ID: ", msgOut().msg().ade().iValidaDocId());
        swSwitchs().swCTipoMovScta().set(msgIn().msg().ade().cTipoMovScta());
        log(TraceLevel.Debug, "   SW-C-TIPO-MOV-SCTA : ", swSwitchs().swCTipoMovScta());
        log(TraceLevel.Debug, "       ENTREGA...................... E");
        log(TraceLevel.Debug, "       LEVANTAMENTO................. L");
        log(TraceLevel.Debug, "       LIQUIDACAO-CONTA............. I");
        log(TraceLevel.Debug, "       PAG-CHQ-CTA-HVL7............. P");
        log(TraceLevel.Debug, "       PAG-CHQ-VISADO-HVB2.......... M");
        log(TraceLevel.Debug, "       PAG-CHQ-OIC-HBF0............. Q");
        log(TraceLevel.Debug, "       PAG-CHQ-HVE5-HVL3............ N");
        log(TraceLevel.Debug, "       ENTREGA-N-ALNOVA............. A");
        if (message.mensagem().headerR().anulDiaNao().isTrue()) {
            m1150ValidaInput1() ;
        } else {
            m1155ValidaInput2() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && 
            (msgOut().msg().ade().iValidaDocId().isEqual(CON_NAO) || 
            !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO))) {
            /**
             * *PASS2972 - FIM
             */
            wsTempo().wsInd().set(CON_1N);
            m1200InicTabInternas() ;
        }
        /**
         * *GH2161-COMENTAR
         * *GH2024--> INICIO
         * IF BHTL001A-SEM-ERROS
         * *PASS2972 - INI
         * AND (BGHM1131-I-VALIDA-DOC-ID EQUAL CON-NAO
         * OR BHTL001A-C-TIPO-CANL-ACES NOT EQUAL CON-BALCAO)
         * *PASS2972 - FIM
         * PERFORM 1201-INIC-TAB-INT-DOC
         * THRU 1201-INIC-TAB-INT-DOC-EXIT
         * END-IF.
         * PERFORM 1700-OBTER-OBRIG-ID
         * THRU 1700-OBTER-OBRIG-ID-EXIT
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            (msgOut().msg().ade().iValidaDocId().isEmpty() || 
            !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO))) {
            m1700ObterObrigId() ;
        }
        /**
         * *PASS2972 - FIM
         * *GH2024--> FIM
         */
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            (msgOut().msg().ade().iValidaDocId().isEqual(CON_NAO) || 
            !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO))) {
            /**
             * *PASS2972 - FIM
             */
            if (!swSwitchs().swPagChqOicHbf0().isTrue() && !swSwitchs().swPagChqHve5Hvl3().isTrue()) {
                m1250ValidaConta() ;
            } else if (msgIn().msg().ade().iClszTtr1Cont().isEmpty()) {
                msgIn().msg().ade().iClszTtr1Cont().set(CON_PARTICULAR);
                msgOut().msg().ade().iClszTtr1Cont().set(CON_PARTICULAR);
            }
        }
        log(TraceLevel.Debug, "BGHM1130-C-TIPO-ITVT-DEP:");
        log(TraceLevel.Debug, msgIn().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "BGHM1130-C-TIPO-MDTI:", msgIn().msg().ade().cTipoMdti());
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            (!message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO) || 
            (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO) && 
            msgOut().msg().ade().iValidaDocId().isEqual(CON_NAO) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
            (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) || 
            msgIn().msg().ade().cTipoMdti().isEqual("E") || 
            msgIn().msg().ade().cTipoMdti().isEqual("D"))))) {
            /**
             * GH2186-FIM
             */
            m1300TipoCliente() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && 
            (msgOut().msg().ade().iValidaDocId().isEqual(CON_NAO) || 
            !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO)) && 
            message.mensagem().headerR().anulDiaNao().isTrue() && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
            msgIn().msg().ade().iCliCgd().isEqual(CON_SIM) && 
            msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) && 
            (msgIn().msg().ade().cTipoMdti().isEqual("E") || 
            msgIn().msg().ade().cTipoMdti().isEqual("D"))) {
            m1301TipoClienteMand() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            msgIn().msg().ade().iCliCgd().isEqual(CON_NAO) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
            (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) || 
            msgIn().msg().ade().cTipoMdti().isEqual("E") || 
            msgIn().msg().ade().cTipoMdti().isEqual("D")) && 
            (msgOut().msg().ade().iValidaDocId().isEqual(CON_NAO) || 
            !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO))) {
            /**
             * *PASS2972 - FIM
             * AND BGHM1130-C-TIPO-ITVT-DEP  NOT EQUAL CON-MANDATARIO
             * AND BGHM1130-C-TIPO-ITVT-DEP  NOT EQUAL CON-TERCEIROS
             */
            m1400ValidaCliNCgd() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            msgIn().msg().ade().iCliCgd().isEqual(CON_SIM) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
            (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) || 
            msgIn().msg().ade().cTipoMdti().isEqual("E") || 
            msgIn().msg().ade().cTipoMdti().isEqual("D")) && 
            (msgOut().msg().ade().iValidaDocId().isEqual(CON_NAO) || 
            !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO))) {
            /**
             * *PASS2972 - FIM
             */
            m1500ValidaCliCgd() ;
        }
        /**
         * GH1981 - E002444 - 2017-01-18 - INICIO
         * IF BHTL001A-SEM-ERROS
         * AND BHTL001A-ANUL-DIA-NAO
         * AND BGHM1130-C-TIPO-ITVT-DEP NOT EQUAL CON-BENE-CHQ
         * PERFORM 1550-VALIDA-SUBCONTA
         * THRU 1550-VALIDA-SUBCONTA-EXIT
         * END-IF.
         * GH1981 - E002444 - 2017-01-18 - FIM
         */
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzSim().isTrue() && 
            message.mensagem().headerR().anulDiaNao().isTrue()) {
            m1600LimpaOutput() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H)) {
            log(TraceLevel.Debug, " 1000-INICIO-PROGRAMA");
            swSwitchs().swDepositoExpresso24h().setTrue() ;
        }
    }
    
    /**
     * 
     * 1100-MENSAGEM-INPUT
     * 
     */
    protected void m1100MensagemInput() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, " 1000-INICIO-PROGRAMA");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISOA-CONT     : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BGHM1130-C-BANC-CONT          : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "   BGHM1130-C-OE-EGC-CONT        : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "   BGHM1130-NS-RDCL-CONT         : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "   BGHM1130-V-CHKD-CONT          : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-CONT          : ", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "   BGHM1130-C-MOED-ISO-SCTA      : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "   BGHM1130-NS-DEPOSITO          : ", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "   BGHM1130-N-CHEQUE             : ", msgIn().msg().ade().nCheque());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-ITVT-DEP      : ", msgIn().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-MDTI          : ", msgIn().msg().ade().cTipoMdti());
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI           : ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   BGHM1130-I-CLI-CGD            : ", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1130-N-CLIENTE            : ", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1130-NS-ABRA-CLI          : ", msgIn().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "   BGHM1130-I-CLSZ-TTR1-CONT     : ", msgIn().msg().ade().iClszTtr1Cont());
        log(TraceLevel.Debug, "   BGHM1130-NM-CLIENTE           : ", msgIn().msg().ade().nmCliente());
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISA-EMS-DOC   : ", msgIn().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-DOC-ID        : ", msgIn().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "   BGHM1130-N-DOC-ID             : ", msgIn().msg().ade().nDocId());
        log(TraceLevel.Debug, "   BGHM1130-Z-VLDE-DOC-ID        : ", msgIn().msg().ade().zVldeDocId());
        log(TraceLevel.Debug, "   BGHM1130-C-ENT-EMIX-DOC-ID    : ", msgIn().msg().ade().cEntEmixDocId());
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-EM-DOC-PRIN   : ", msgIn().msg().ade().cPaisEmDocPrin());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-DOC-ID-PRIN   : ", msgIn().msg().ade().cTipoDocIdPrin());
        log(TraceLevel.Debug, "   BGHM1130-N-DOC-ID-PRIN        : ", msgIn().msg().ade().nDocIdPrin());
        log(TraceLevel.Debug, "   BGHM1130-Z-VLDE-DOC-ID-PRIN   : ", msgIn().msg().ade().zVldeDocIdPrin());
        log(TraceLevel.Debug, "   BGHM1130-C-ENT-EMI-DOC-PRIN   : ", msgIn().msg().ade().cEntEmiDocPrin());
        log(TraceLevel.Debug, "   BGHM1130-I-RCS-JSTZ-ORM-FND   : ", msgIn().msg().ade().iRcsJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1130-Z-PROCESSAMENTO      : ", msgIn().msg().ade().nrElectronico().zProcessamento());
        log(TraceLevel.Debug, "   BGHM1130-C-MNEM-EGC-OPEX      : ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISOA-OE-OPX   : ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1130-C-OE-EGC-OPEX        : ", msgIn().msg().ade().nrElectronico().cOeEgcOpex());
        log(TraceLevel.Debug, "   BGHM1130-C-USERID             : ", msgIn().msg().ade().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1130-N-JOUR-BBN           : ", msgIn().msg().ade().nrElectronico().nJourBbn());
        log(TraceLevel.Debug, "   BGHM1130-Q-MOED               : ", msgIn().msg().ade().qMoed());
        log(TraceLevel.Debug, "   BGHM1130-I-PED-JSTZ-ORM-FND   : ", msgIn().msg().ade().iPedJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1130-C-MTVO-PED-JSTZ      : ", msgIn().msg().ade().cMtvoPedJstz());
        log(TraceLevel.Debug, "   BGHM1130-M-ACMD-ETGA          : ", msgIn().msg().ade().mAcmdEtga());
        log(TraceLevel.Debug, "   BGHM1130-I-DOC-DSZD           : ", msgIn().msg().ade().iDocDszd());
        log(TraceLevel.Debug, "   BGHM1130-I-NCSS-TRR-FOTOC     : ", msgIn().msg().ade().iNcssTrrFotoc());
        log(TraceLevel.Debug, "   BGHM1130-NM-CLIENTE-T         : ", msgIn().msg().ade().nmClienteT());
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISA-EMS-DOC-T : ", msgIn().msg().ade().cPaisIsaEmsDocT());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-DOC-ID-T      : ", msgIn().msg().ade().cTipoDocIdT());
        log(TraceLevel.Debug, "   BGHM1130-N-DOC-ID-T           : ", msgIn().msg().ade().nDocIdT());
        log(TraceLevel.Debug, "   BGHM1130-Z-VLDE-DOC-ID-T      : ", msgIn().msg().ade().zVldeDocIdT());
        log(TraceLevel.Debug, "   BGHM1130-C-ENT-EMIX-DOC-ID-T  : ", msgIn().msg().ade().cEntEmixDocIdT());
        log(TraceLevel.Debug, "   BGHM1130-I-CBRC-ENCG          : ", msgIn().msg().ade().iCbrcEncg());
        log(TraceLevel.Debug, "   BGHM1130-C-FAMI-PROD          : ", msgIn().msg().ade().cFamiProd());
        log(TraceLevel.Debug, "   BGHM1130-C-PRODUTO            : ", msgIn().msg().ade().cProduto());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-MOV-SCTA      : ", msgIn().msg().ade().cTipoMovScta());
        log(TraceLevel.Debug, "   BGHM1130-I-INSZ-DOC-ID-CLI    : ", msgIn().msg().ade().iInszDocIdCli());
        log(TraceLevel.Debug, "   BGHM1130-I-VALIDA-DOC-ID      : ", msgIn().msg().ade().iValidaDocId());
        log(TraceLevel.Debug, "   BGHM1130-C-TIP-REL-DEP        : ", msgIn().msg().ade().cTipRelDep());
        log(TraceLevel.Debug, "   BGHM1130-X-INF-JSTZ-DEP       : ", msgIn().msg().ade().xInfJstzDep());
        log(TraceLevel.Debug, "   ------DADOS DA ARQUITETURA------");
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-SIMZ          : ", message.mensagem().headerR().iTrnzSimz());
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-EFCD-ONLN     : ", message.mensagem().headerR().iTrnzEfcdOnln());
        log(TraceLevel.Debug, "   BHTL001A-I-ESTORNO            : ", message.mensagem().headerR().iEstorno());
        log(TraceLevel.Debug, "**********************************************");
    }
    
    /**
     * 
     * 1150-VALIDA-INPUT-1
     * 
     */
    protected void m1150ValidaInput1() {
        log(TraceLevel.Debug, "  1150-VALIDA-INPUT-1");
        /**
         * --- CLIENTE CGD OU NAO CGD
         */
        if (!msgIn().msg().ade().iCliCgd().isEqual(CON_NAO) && 
            !msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-01");
            log(TraceLevel.Debug, "   BGHM1130-I-CLI-CGD MAL FORMATADO ", msgIn().msg().ade().iCliCgd());
        }
        /**
         * --- N-CLIENTE
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!msgIn().msg().ade().nCliente().isNumeric() || !msgIn().msg().ade().nsAbraCli().isNumeric() || 
                (msgIn().msg().ade().nCliente().isEqual(0) && 
                !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
                msgIn().msg().ade().iCliCgd().isEqual(CON_SIM))) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Debug, "ERRO-02");
                log(TraceLevel.Debug, "   BGHM1130-N-CLIENTE FORMATADO ", msgIn().msg().ade().nCliente());
            }
        }
        /**
         * --- DOCUMENTO APRESENTADO
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H)) {
            if (msgIn().msg().ade().cPaisIsaEmsDoc().isEmpty() || 
                msgIn().msg().ade().cPaisIsaEmsDoc().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().cTipoDocId().isEmpty() || 
                msgIn().msg().ade().cTipoDocId().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().nDocId().isEmpty() || 
                msgIn().msg().ade().nDocId().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zVldeDocId().isEmpty() || 
                msgIn().msg().ade().zVldeDocId().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zVldeDocId().isEqual(CON_DATA_MIN)) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Debug, "ERRO-03");
                log(TraceLevel.Debug, "   DOCUMENTO APRESENTADO MAL FORMATADO ");
            }
        }
        /**
         * --- TIPOS DE INTERVENIENTE
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_PROPRIO) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENE_CHQ) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H)) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-04");
            log(TraceLevel.Debug, "   BGHM1130-C-TIPO-ITVT-DEP MAL FORMATADO ", msgIn().msg().ade().cTipoItvtDep());
        }
        /**
         * --- VALIDA CONTA
         */
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swPagChqOicHbf0().isTrue() && 
            (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cPaisIsoaCont().isEqual(String.valueOf(LOW_VALUES)) || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            !msgIn().msg().ade().cBancCont().isNumeric() || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            !msgIn().msg().ade().cOeEgcCont().isNumeric() || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            !msgIn().msg().ade().nsRdclCont().isNumeric() || 
            !msgIn().msg().ade().vChkdCont().isNumeric() || 
            !msgIn().msg().ade().cTipoCont().isNumeric() || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().cMoedIsoScta().isEqual(String.valueOf(LOW_VALUES)) || 
            !msgIn().msg().ade().nsDeposito().isNumeric())) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-05");
            log(TraceLevel.Debug, "   CONTA MAL FORMATADA ");
        }
        /**
         * --- MONTANTE DO MOVIMENTO EM NUMERARIO
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            (!msgIn().msg().ade().mMovNmri().isNumeric() || 
            msgIn().msg().ade().mMovNmri().isEqual(0))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-06");
            log(TraceLevel.Debug, " BGHM1130-M-MOV-NMRI MAL FORMATADO ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * --- VALIDA TIPOS DE OPERACAO VALIDOS
         */
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swTipoOpeValidos().isTrue()) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-07");
            log(TraceLevel.Debug, "   SW-C-TIPO-MOV-SCTA MAL FORMATADO ", swSwitchs().swCTipoMovScta());
        }
        /**
         * --- VALIDA NUMERO DE CHEQUE NO CASO DE SER PAGAMENTO DE CHEQUE
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            (swSwitchs().swPagChqCtaHvl7().isTrue() || swSwitchs().swPagChqOicHbf0().isTrue() || 
            swSwitchs().swPagChqHve5Hvl3().isTrue() || 
            swSwitchs().swPagChqVisadoHvb2().isTrue()) && 
            (!msgIn().msg().ade().nCheque().isNumeric() || 
            msgIn().msg().ade().nCheque().isEqual(0))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-08");
            log(TraceLevel.Debug, "   BGHM1130-N-CHEQUE MAL FORMATADO ", msgIn().msg().ade().nCheque());
        }
        /**
         * --- NO CASO DE SER PAGAMENTO DE CHEQUE POR CAIXA TEM DE SER
         * BENEFICIARIO DE CHEQUE
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            (swSwitchs().swPagChqOicHbf0().isTrue() || swSwitchs().swPagChqHve5Hvl3().isTrue()) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENE_CHQ)) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-09");
            log(TraceLevel.Debug, "   NO PAGAMENTO DE CHEQUE POR CAIXA O ", "INTERVENIENTE TEM DE SER BEFICIARIO DE CHEQUE ]");
        }
        /**
         * PASSIVAS 4497 (INICIO)
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!msgIn().msg().ade().iValidaDocId().isEmpty() || 
                !message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO)) {
                if (!swSwitchs().swLevantamento().isTrue()) {
                    if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS)) {
                        if (msgIn().msg().ade().cTipRelDep().isEmpty()) {
                            /**
                             * --- NO CASO DE MOVIMENTAÇÃO DEPOSITO E NÃO FOR INTERVENIENTE DA
                             * CONTA NEM MANDATÁRIO, OBRIGAR O PREENCHIMENTO DO CAMPO
                             * RELAÇÃO
                             */
                            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                            envOut.errosGraves().errosFuncao().setTrue() ;
                            log(TraceLevel.Debug, "ERRO-37");
                            log(TraceLevel.Debug, " BGHM1130-C-TIP-REL-DEP INVALIDO .", msgIn().msg().ade().cTipRelDep());
                        } else if (msgIn().msg().ade().cTipRelDep().isEqual(CON_OUTRO)) {
                            if (msgIn().msg().ade().xInfJstzDep().isEmpty()) {
                                /**
                                 * --- NO CASO DE MOVIMENTAÇÃO DEPOSITO E NÃO FOR INTERVENIENTE DA
                                 * CONTA NEM MANDATÁRIO, E RELAÇÃO "OUTRO", OBRIGAR O
                                 * PREENCHIMENTO DO CAMPO TEXTO A INDICAR A RELAÇÃO
                                 */
                                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                                envOut.errosGraves().errosFuncao().setTrue() ;
                                log(TraceLevel.Debug, "ERRO-38");
                                log(TraceLevel.Debug, " BGHM1130-X-INF-JSTZ-DEP S/ PREENCHIMENTO", msgIn().msg().ade().xInfJstzDep());
                            }
                        }
                    } else if (!msgIn().msg().ade().cTipRelDep().isEmpty() || 
                        !msgIn().msg().ade().xInfJstzDep().isEmpty()) {
                        /**
                         * --- NO CASO DE MOVIMENTAÇÃO DEPOSITO E INTERVENIENTE PRÓPRIO OU
                         * MANDATÁRIO, OS CAMPOS RELAÇÃO E TEXTO LIVRE A INDICAR A
                         * RELAÇÃO NÃO DEVERÃO ESTAR PREENCHIDOS
                         */
                        envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                        msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                        msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                        envOut.errosGraves().errosFuncao().setTrue() ;
                        log(TraceLevel.Debug, "ERRO-39");
                        log(TraceLevel.Debug, " CAMPO(S) RELAÇÃO PREENCHIDO(S)   ", msgIn().msg().ade().cTipRelDep(), " ", msgIn().msg().ade().xInfJstzDep());
                    }
                } else if (!msgIn().msg().ade().cTipRelDep().isEmpty() || 
                    !msgIn().msg().ade().xInfJstzDep().isEmpty()) {
                    /**
                     * --- NO CASO DE MOVIMENTAÇÃO LEVANTAMENTO, OS CAMPOS RELAÇÃO E
                     * TEXTO LIVRE A INDICAR A RELAÇÃO NÃO DEVERÃO ESTAR
                     * PREENCHIDOS
                     */
                    envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                    msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                    envOut.errosGraves().errosFuncao().setTrue() ;
                    log(TraceLevel.Debug, "ERRO-40");
                    log(TraceLevel.Debug, " CAMPO(S) RELAÇÃO PREENCHIDO(S)    ", msgIn().msg().ade().cTipRelDep(), " ", msgIn().msg().ade().xInfJstzDep());
                }
            }
        }
    }
    
    /**
     * 
     * 1155-VALIDA-INPUT-2
     * 
     */
    protected void m1155ValidaInput2() {
        log(TraceLevel.Debug, "  1155-VALIDA-INPUT-2");
        /**
         * *---VALIDA CONTA
         */
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swPagChqOicHbf0().isTrue() && 
            (msgIn().msg().ade().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().cPaisIsoaCont().isEqual(String.valueOf(LOW_VALUES)) || 
            msgIn().msg().ade().cBancCont().isEqual(0) || 
            !msgIn().msg().ade().cBancCont().isNumeric() || 
            msgIn().msg().ade().cOeEgcCont().isEqual(0) || 
            !msgIn().msg().ade().cOeEgcCont().isNumeric() || 
            msgIn().msg().ade().nsRdclCont().isEqual(0) || 
            !msgIn().msg().ade().nsRdclCont().isNumeric() || 
            !msgIn().msg().ade().vChkdCont().isNumeric() || 
            !msgIn().msg().ade().cTipoCont().isNumeric() || 
            msgIn().msg().ade().cMoedIsoScta().isEmpty() || 
            msgIn().msg().ade().cMoedIsoScta().isEqual(String.valueOf(LOW_VALUES)) || 
            !msgIn().msg().ade().nsDeposito().isNumeric())) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-10");
            log(TraceLevel.Debug, "   CONTA MAL FORMATADA ");
        }
        /**
         * *---VALIDA JOURNAL
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            (msgIn().msg().ade().nrElectronico().zProcessamento().isEqual(String.valueOf(LOW_VALUES)) || 
            msgIn().msg().ade().nrElectronico().zProcessamento().isEqual(CON_DATA_MIN) || 
            msgIn().msg().ade().nrElectronico().zProcessamento().isEqual(CON_DATA_MAX) || 
            msgIn().msg().ade().nrElectronico().cMnemEgcOpex().isEmpty() || 
            msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx().isEmpty() || 
            msgIn().msg().ade().nrElectronico().cOeEgcOpex().isEqual(0) || 
            !msgIn().msg().ade().nrElectronico().cOeEgcOpex().isNumeric() || 
            msgIn().msg().ade().nrElectronico().cUserid().isEmpty() || 
            !msgIn().msg().ade().nrElectronico().nJourBbn().isNumeric())) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().nJourBbnSt().nJourBbnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().nJourBbnSt().nJourBbn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-11");
            log(TraceLevel.Debug, "   BGHM1130-N-JOUR-BBN MAL FORMATADO");
        }
        /**
         * --- VALIDA NUMERO DE CHEQUE NO CASO DE SER PAGAMENTO DE CHEQUE
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            (swSwitchs().swPagChqCtaHvl7().isTrue() || swSwitchs().swPagChqHve5Hvl3().isTrue() || 
            swSwitchs().swPagChqVisadoHvb2().isTrue() || 
            swSwitchs().swPagChqOicHbf0().isTrue()) && 
            (!msgIn().msg().ade().nCheque().isNumeric() || 
            msgIn().msg().ade().nCheque().isEqual(0))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-12");
            log(TraceLevel.Debug, "   BGHM1130-N-CHEQUE MAL FORMATADO ", msgIn().msg().ade().nCheque());
        }
    }
    
    /**
     * 
     * 1200-INIC-TAB-INTERNAS
     * 
     */
    protected void m1200InicTabInternas() {
        if (wsTempo().wsInd().isEqual(CON_1N)) {
            log(TraceLevel.Debug, "  1200-INIC-TAB-INTERNAS");
        }
        wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo().set(" ");
        wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdXCteuCo03().set(" ");
        wsTempo().wsInd().add(CON_1N);
    }
    
    /**
     * 
     * *GH2161-COMENTAR
     * *GH2024--> INICIO
     * 1201-INIC-TAB-INT-DOC
     * *1201-INIC-TAB-INT-DOC.
     * MOVE '  1201-INIC-TAB-INT-DOC ' TO WS-PRG.
     * IF SW-DEBUG-SIM
     * AND WS-IND = CON-1N
     * DISPLAY WS-PARAG
     * END-IF.
     * MOVE CON-1N                  TO WS-IND.
     * PERFORM UNTIL WS-IND > CON-250N
     * MOVE SPACES                  TO WS-TAB-Z-VLDE-DOC (WS-IND)
     * WS-TD-C-CODIGO-DOC(WS-IND).
     * END-PERFORM.
     * ADD CON-1N                      TO WS-IND.
     * *1201-INIC-TAB-INT-DOC-EXIT.
     * EXIT.
     * *GH2204--> FIM
     * 1250-VALIDA-CONTA
     * 
     */
    protected void m1250ValidaConta() {
        log(TraceLevel.Debug, "  1250-VALIDA-CONTA");
        m1251AcessoMhoj708a() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m1252AcessoMhoj710a() ;
        }
        /**
         * GH1981 - E002444 - 2017-01-18 - INICIO
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            m1550ValidaSubconta() ;
        }
    }
    
    /**
     * 
     * 1251-ACESSO-MHOJ708A
     * 
     */
    protected void m1251AcessoMhoj708a() {
        log(TraceLevel.Debug, "   1251-ACESSO-MHOJ708A");
        bhol708a().commarea().initialize() ;
        bhol708a().commarea().dadosInput().conta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhol708a().commarea().dadosInput().conta().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhol708a().commarea().dadosInput().conta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhol708a().commarea().dadosInput().conta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhol708a().commarea().dadosInput().conta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhol708a().commarea().dadosInput().conta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhol708a().commarea().dadosInput().consulta().setTrue() ;
        bhol708a().commarea().dadosInput().seguranca().iraConNao().setTrue() ;
        bhop0708ValConta() ;
        if (!bhol708a().commarea().dadosOutput().fimConsulta().isTrue() && !bhol708a().commarea().dadosOutput().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhol708a().commarea().dadosOutput().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhol708a().commarea().dadosOutput().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhol708a().commarea().dadosOutput().cSqlcode());
            envOut.db2Log().nmTabela().set(bhol708a().commarea().dadosOutput().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-13");
        } else if (msgIn().msg().ade().iClszTtr1Cont().isEmpty()) {
            msgIn().msg().ade().iClszTtr1Cont().set(bhol708a().commarea().dadosOutput().vho00101().iClszTtr1Cont());
            msgOut().msg().ade().iClszTtr1Cont().set(bhol708a().commarea().dadosOutput().vho00101().iClszTtr1Cont());
        }
        if (!msgIn().msg().ade().iClszTtr1Cont().isEqual(CON_EMPRESA) && 
            msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO)) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Debug, "ERRO-14");
            log(TraceLevel.Debug, "   BGHM1130-C-TIPO-ITVT-DEP MAL FORMATADO ", msgIn().msg().ade().cTipoItvtDep());
        }
        log(TraceLevel.Debug, "   BHOL708A-I-EMPS-NOME-IDVL: ", bhol708a().commarea().dadosOutput().vho00101().iEmpsNomeIdvl());
        log(TraceLevel.Debug, "   BHOL708A-I-CLSZ-TTR1-CONT: ", bhol708a().commarea().dadosOutput().vho00101().iClszTtr1Cont());
        log(TraceLevel.Debug, "   BHOL708A-C-SECT-ITTL-BPOR: ", bhol708a().commarea().dadosOutput().vho00101().cSectIttlBpor());
    }
    
    /**
     * 
     * 1252-ACESSO-MHOJ710A
     * 
     */
    protected void m1252AcessoMhoj710a() {
        log(TraceLevel.Debug, "   1252-ACESSO-MHOJ710A");
        bhol710a().commarea().initialize() ;
        bhol710a().commarea().dadosInput().conta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhol710a().commarea().dadosInput().conta().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhol710a().commarea().dadosInput().conta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhol710a().commarea().dadosInput().conta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhol710a().commarea().dadosInput().conta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhol710a().commarea().dadosInput().conta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhol710a().commarea().dadosInput().conta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        bhol710a().commarea().dadosInput().conta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        bhol710a().commarea().dadosInput().consulta().setTrue() ;
        bhol710a().commarea().dadosInput().seguranca().iraConNao().setTrue() ;
        bhol710a().commarea().dadosInput().iCnslDadCheqN().setTrue() ;
        bhop0710ValSubconta() ;
        if (!bhol710a().commarea().dadosOutput().fimConsulta().isTrue() && !bhol710a().commarea().dadosOutput().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhol710a().commarea().dadosOutput().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhol710a().commarea().dadosOutput().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhol710a().commarea().dadosOutput().cSqlcode());
            envOut.db2Log().nmTabela().set(bhol710a().commarea().dadosOutput().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-15");
        }
    }
    
    /**
     * 
     * 1300-TIPO-CLIENTE
     * 
     */
    protected void m1300TipoCliente() {
        log(TraceLevel.Debug, "  1300-TIPO-CLIENTE");
        log(TraceLevel.Debug, "   BGHM1130-I-CLI-CGD  : ", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1130-N-CLIENTE  : ", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1130-NM-CLIENTE : ", msgIn().msg().ade().nmCliente());
        /**
         * -- CLIENTE NAO CGD
         */
        if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
            m1310ValidaDocumento() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                msgOut().msg().ade().nmCliente().set(msgIn().msg().ade().nmCliente());
                msgOut().msg().ade().iInszDocIdCli().set(CON_NAO);
            }
        }
        /**
         * -- CLIENTE CGD
         */
        if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
            wsTempo().wsBhjl006aNCliente().set(msgIn().msg().ade().nCliente());
            m1320ObtemNomeCli() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                msgIn().msg().ade().nCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
                msgOut().msg().ade().nCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
                msgIn().msg().ade().nsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                msgOut().msg().ade().nsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                msgIn().msg().ade().nmCliente().set(bhjl006a().commarea().dadosSaida().nmCliente());
                msgOut().msg().ade().nmCliente().set(bhjl006a().commarea().dadosSaida().nmCliente());
                swSwitchs().swValidaTipoCli().set(bhjl006a().commarea().dadosSaida().cTipoCli());
                /**
                 * -- NO CASO CLIENTE CGD, PASSARA A PEDIR SEMPRE O DOCUMENTO AO
                 * BALCAO - DOC ID APRESENTADO - QUE DEVE SER VALIDADO.
                 */
                if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO)) {
                    m1330ValidaNDocCli() ;
                } else {
                    /**
                     * -- LIMPA DOCUMENTO DE IDENTIFICACAO APRESENTADO PARA ATS
                     */
                    msgIn().msg().ade().cPaisIsaEmsDoc().set(" ");
                    msgOut().msg().ade().cPaisIsaEmsDoc().set(" ");
                    msgIn().msg().ade().cTipoDocId().set(" ");
                    msgOut().msg().ade().cTipoDocId().set(" ");
                    msgIn().msg().ade().nDocId().set(" ");
                    msgOut().msg().ade().nDocId().set(" ");
                    msgIn().msg().ade().cEntEmixDocId().set(" ");
                    msgOut().msg().ade().cEntEmixDocId().set(" ");
                    msgIn().msg().ade().zVldeDocId().set(CON_DATA_MIN);
                    msgOut().msg().ade().zVldeDocId().set(CON_DATA_MIN);
                    msgOut().msg().ade().iInszDocIdCli().set(CON_NAO);
                }
            }
        }
    }
    
    /**
     * 
     * 1301-TIPO-CLIENTE-MAND
     * 
     */
    protected void m1301TipoClienteMand() {
        log(TraceLevel.Debug, "  1300-TIPO-CLIENTE");
        log(TraceLevel.Debug, "   BGHM1130-I-CLI-CGD  : ", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1130-N-CLIENTE  : ", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1130-NM-CLIENTE : ", msgIn().msg().ade().nmCliente());
        wsTempo().wsBhjl006aNCliente().set(msgIn().msg().ade().nCliente());
        m1320ObtemNomeCli() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            msgIn().msg().ade().nCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
            msgOut().msg().ade().nCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
            msgIn().msg().ade().nsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
            msgOut().msg().ade().nsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
            msgIn().msg().ade().nmCliente().set(bhjl006a().commarea().dadosSaida().nmCliente());
            msgOut().msg().ade().nmCliente().set(bhjl006a().commarea().dadosSaida().nmCliente());
        }
        log(TraceLevel.Debug, "BGHM1131-N-CLIENTE:", msgOut().msg().ade().nCliente());
        log(TraceLevel.Debug, "BGHM1131-NS-ABRA-CLI:", msgOut().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "BGHM1131-NM-CLIENTE:", msgOut().msg().ade().nmCliente());
    }
    
    /**
     * 
     * 1310-VALIDA-DOCUMENTO
     * 
     */
    protected void m1310ValidaDocumento() {
        log(TraceLevel.Debug, "   1310-VALIDA-DOCUMENTO");
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISA-EMS-DOC: ", msgIn().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-DOC-ID     : ", msgIn().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "   BGHM1130-N-DOC-ID          : ", msgIn().msg().ade().nDocId());
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
        bhjl027a().commarea().dadosEntrada().nDocId().set(msgIn().msg().ade().nDocId());
        bhjp5027AcedeMhjj027a() ;
        log(TraceLevel.Debug, "   1310-VALIDA-DOCUMENTO");
        log(TraceLevel.Debug, "   BHJL027A-C-TIPO-ERRO-BBN   : ", bhjl027a().commarea().erros().cTipoErroBbn());
        log(TraceLevel.Debug, "   BHJL027A-A-APL-ERR         : ", bhjl027a().commarea().erros().aAplErr());
        log(TraceLevel.Debug, "   BHJL027A-C-RTNO-EVEN-SWAL  : ", bhjl027a().commarea().erros().cRtnoEvenSwal());
        log(TraceLevel.Debug, "    --CLIENTE-NAO-EXISTE......+002");
        log(TraceLevel.Debug, "    --CLIENTE-CONFIDENCIAL....+506");
        log(TraceLevel.Debug, "    --DOC-NAO-EXISTE..........+535");
        log(TraceLevel.Debug, "    --DOC-REPETIDO............+536");
        log(TraceLevel.Debug, "    --CLI-CANCELADO...........+622");
        if (bhjl027a().commarea().erros().semErros().isTrue() || bhjl027a().commarea().erros().fimConsulta().isTrue() || 
            (bhjl027a().commarea().erros().erroFuncao().isTrue() && 
            (bhjl027a().commarea().erros().clienteConfidencial().isTrue() || bhjl027a().commarea().erros().docRepetido().isTrue()))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().itvtOpexCliCgd());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-16");
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!bhjl027a().commarea().erros().semErros().isTrue() && !bhjl027a().commarea().erros().clienteNaoExiste().isTrue() && 
                !bhjl027a().commarea().erros().docNaoExis().isTrue() && 
                !bhjl027a().commarea().erros().cliCancelado().isTrue()) {
                envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "ERRO-17");
            }
        }
    }
    
    /**
     * 
     * 1320-OBTEM-NOME-CLI
     * 
     */
    protected void m1320ObtemNomeCli() {
        log(TraceLevel.Debug, "   1320-OBTEM-NOME-CLI");
        log(TraceLevel.Debug, "   WS-BHJL006A-N-CLIENTE: ", wsTempo().wsBhjl006aNCliente());
        bhjl006a().commarea().initialize() ;
        bhjl006a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl006a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl006a().commarea().dadosEntrada().nCliente().set(wsTempo().wsBhjl006aNCliente());
        bhjp6006AcedeMhjs006a() ;
        if (bhjl006a().commarea().erros().erroFuncao().isTrue() && bhjl006a().commarea().erros().clienteNaoExiste().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl006a().commarea().erros().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl006a().commarea().erros().cRtnoEvenSwal());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-18");
        }
        if (!bhjl006a().commarea().erros().fimConsulta().isTrue() && !bhjl006a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl006a().commarea().erros().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl006a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl006a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl006a().commarea().erros().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-19");
        }
    }
    
    /**
     * 
     * 1330-VALIDA-N-DOC-CLI
     * 
     */
    protected void m1330ValidaNDocCli() {
        log(TraceLevel.Debug, "   1330-VALIDA-N-DOC-CLI");
        bhjl628a().commarea().initialize() ;
        bhjl628a().commarea().visualizacao().setTrue() ;
        bhjl628a().commarea().thj00023Docid().dadosInput().nCliente().set(msgIn().msg().ade().nCliente());
        bhjl628a().commarea().thj00023Docid().dadosInput().nsAbraCli().set(msgIn().msg().ade().nsAbraCli());
        /**
         * -- TIPO DE DOCUMENTO APRESENTADO
         */
        bhjl628a().commarea().thj00023Docid().dadosInput().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
        bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
        bhjp0628Mhjj628a() ;
        if (bhjl628a().commarea().dadosErro().semErros().isTrue()) {
            if (!bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId().isEqual(msgIn().msg().ade().nDocId())) {
                /**
                 * ------ CLIENTE CGD COM DOC ID APRESENTADO CARREGADO NA BASE DE
                 * DADOS, MAS COM NUMERO DE DOC ID DIFERENTE
                 */
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().nDocAptdDiferente());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "ERRO-20");
                log(TraceLevel.Debug, "   BHJL628A-N-DOC-ID          : ", bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId());
                log(TraceLevel.Debug, "   BGHM1130-N-DOC-ID          : ", msgIn().msg().ade().nDocId());
            }
        } else if (bhjl628a().commarea().dadosErro().docNaoExis().isTrue()) {
            /**
             * --       SE TIPO DOCUMENTO NAO ESTA ATRIBUIDO AO CLIENTE CGD
             * VAMOS VER DOC APRESENTADO PERTENCE A OUTRO CLIENTE CGD
             */
            m1331VerificExistDoc() ;
        } else {
            envOut.errosGraves().aAplErr().set(bhjl628a().commarea().dadosErro().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl628a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl628a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl628a().commarea().dadosErro().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-21");
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * -- MOVE DOCUMENTO DE IDENTIFICACAO APRESENTADO
             */
            msgOut().msg().ade().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
            msgOut().msg().ade().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
            msgOut().msg().ade().nDocId().set(msgIn().msg().ade().nDocId());
            if ((msgOut().msg().ade().cEntEmixDocId().isEqual(CON_9901VITAL) || 
                msgOut().msg().ade().cEntEmixDocId().isEqual(CON_9902VITAL) || 
                msgOut().msg().ade().cEntEmixDocId().isEqual(CON_9903VITAL) || 
                msgOut().msg().ade().cEntEmixDocId().isEqual(CON_9901VTSSO2) || 
                msgOut().msg().ade().cEntEmixDocId().isEqual(CON_9902VTSSO2) || 
                msgOut().msg().ade().cEntEmixDocId().isEqual(CON_9903VTSSO2)) && 
                msgIn().msg().ade().zVldeDocId().isEqual(CON_DATA_MAX)) {
                msgOut().msg().ade().zVldeDocId().set(CON_DATA_MAX_VIT);
            } else {
                msgOut().msg().ade().zVldeDocId().set(msgIn().msg().ade().zVldeDocId());
            }
            msgOut().msg().ade().cEntEmixDocId().set(msgIn().msg().ade().cEntEmixDocId());
        }
    }
    
    /**
     * 
     * 1331-VERIFIC-EXIST-DOC
     * 
     */
    protected void m1331VerificExistDoc() {
        log(TraceLevel.Debug, "    1331-VERIFIC-EXIST-DOC");
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISA-EMS-DOC: ", msgIn().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-DOC-ID     : ", msgIn().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "   BGHM1130-N-DOC-ID          : ", msgIn().msg().ade().nDocId());
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
        bhjl027a().commarea().dadosEntrada().nDocId().set(msgIn().msg().ade().nDocId());
        bhjp5027AcedeMhjj027a() ;
        if (bhjl027a().commarea().erros().semErros().isTrue() || bhjl027a().commarea().erros().fimConsulta().isTrue() || 
            (bhjl027a().commarea().erros().erroFuncao().isTrue() && bhjl027a().commarea().erros().clienteConfidencial().isTrue())) {
            /**
             * -- O DOCUMENTO EXISTE E NAO PERTENCE AO CLIENTE DO DOC ID APTD
             */
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().docAptdOutroCli());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-22");
            log(TraceLevel.Debug, "    1331-VERIFIC-EXIST-DOC");
            log(TraceLevel.Debug, "   BHJL027A-N-CLIENTE         : ", bhjl027a().commarea().dadosSaida().nCliente());
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!bhjl027a().commarea().erros().semErros().isTrue() && !bhjl027a().commarea().erros().fimConsulta().isTrue()) {
                if (bhjl027a().commarea().erros().docNaoExis().isTrue()) {
                    msgOut().msg().ade().iInszDocIdCli().set(CON_SIM);
                }
                if (bhjl027a().commarea().erros().docRepetido().isTrue()) {
                    msgOut().msg().ade().iInszDocIdCli().set(CON_NAO);
                    envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().docAptdOutroCli());
                    msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                    envOut.errosGraves().errosFuncao().setTrue() ;
                    log(TraceLevel.Error, "ERRO-23");
                }
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && !bhjl027a().commarea().erros().docNaoExis().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-24");
        }
    }
    
    /**
     * 
     * 1400-VALIDA-CLI-N-CGD
     * 
     */
    protected void m1400ValidaCliNCgd() {
        log(TraceLevel.Debug, "  1400-VALIDA-CLI-N-CGD");
        log(TraceLevel.Debug, "   BGHM1130-I-CLSZ-TTR1-CONT: ", msgIn().msg().ade().iClszTtr1Cont());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-ITVT-DEP : ", msgIn().msg().ade().cTipoItvtDep());
        if (msgIn().msg().ade().iClszTtr1Cont().isEqual(CON_EMPRESA)) {
            if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO)) {
                swSwitchs().swPropOuMdtaEmpresa().setTrue() ;
            } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS)) {
                swSwitchs().swTerceirosEmpresa().setTrue() ;
            } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENE_CHQ)) {
                swSwitchs().swBeneChqEmpresa().setTrue() ;
            } else {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().identInvNExistRel());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "ERRO-25");
            }
        }
        if (msgIn().msg().ade().iClszTtr1Cont().isEqual(CON_PARTICULAR) || 
            msgIn().msg().ade().iClszTtr1Cont().isEqual(CON_MENOR)) {
            if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS)) {
                swSwitchs().swTerceirosParticular().setTrue() ;
            } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENE_CHQ)) {
                swSwitchs().swBeneChqParticular().setTrue() ;
            } else {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().identInvNExistRel());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "ERRO-26");
            }
        }
        msgOut().msg().ade().nCliente().set(0);
        msgOut().msg().ade().nsAbraCli().set(0);
        /**
         * -- MOVE DOCUMENTO DE IDENTIFICACAO APRESENTADO
         */
        msgOut().msg().ade().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
        msgOut().msg().ade().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
        msgOut().msg().ade().nDocId().set(msgIn().msg().ade().nDocId());
        msgOut().msg().ade().zVldeDocId().set(msgIn().msg().ade().zVldeDocId());
        msgOut().msg().ade().cEntEmixDocId().set(msgIn().msg().ade().cEntEmixDocId());
        /**
         * -- LIMPA DOCUMENTO IDETIFICACAO PRINCIPAL NO CASO CLIENTE N CGD
         */
        msgIn().msg().ade().cPaisEmDocPrin().set(" ");
        msgOut().msg().ade().cPaisEmDocPrin().set(" ");
        msgIn().msg().ade().cTipoDocIdPrin().set(" ");
        msgOut().msg().ade().cTipoDocIdPrin().set(" ");
        msgIn().msg().ade().nDocIdPrin().set(" ");
        msgOut().msg().ade().nDocIdPrin().set(" ");
        msgIn().msg().ade().cEntEmiDocPrin().set(" ");
        msgOut().msg().ade().cEntEmiDocPrin().set(" ");
        msgIn().msg().ade().zVldeDocIdPrin().set(CON_DATA_MIN);
        msgOut().msg().ade().zVldeDocIdPrin().set(CON_DATA_MIN);
    }
    
    /**
     * 
     * 1500-VALIDA-CLI-CGD
     * 
     */
    protected void m1500ValidaCliCgd() {
        log(TraceLevel.Debug, "  1500-VALIDA-CLI-CGD");
        log(TraceLevel.Debug, "   SW-VALIDA-TIPO-CLI       : ", swSwitchs().swValidaTipoCli());
        if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_ATS) && 
            swSwitchs().swClienteEmpresa().isTrue()) {
            swSwitchs().swCliEmpMandS().setTrue() ;
            /**
             * *GH1621 - FIM
             */
            wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNipc());
            wsTabelasInternas().wsTipoDocumento().get(2).wsTdCCodigo().set(conDocNfie());
            wsTabelasInternas().wsTipoDocumento().get(3).wsTdCCodigo().set(conDocNpc());
            wsTabelasInternas().wsTipoDocumento().get(4).wsTdCCodigo().set(conDocNife());
        } else {
            swSwitchs().swCliEmpMandN().setTrue() ;
            bhgl052a().commarea().initialize() ;
            wsTempo().wsInd().set(CON_1N);
            swSwitchs().swEmCiclo().setTrue() ;
            while (!swSwitchs().swFimCiclo().isTrue()) {
                m1510ObtemTpDoc() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1520OrdenaTabInterna() ;
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            wsTempo().wsNCliente().set(msgIn().msg().ade().nCliente());
            wsTempo().wsNsAbraCli().set(msgIn().msg().ade().nsAbraCli());
            wsTempo().wsInd().set(CON_1N);
            swSwitchs().swDocNok().setTrue() ;
            while (wsTempo().wsInd().isLessOrEqual(CON_250N) && !wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo().isEmpty() && envOut.errosGraves().semErros().isTrue()) {
                m1530ObtemDadosDoc() ;
            }
        }
        log(TraceLevel.Trace, "SW-DOC-01:", swSwitchs().swDoc());
        log(TraceLevel.Trace, "BHJL707A-C-PAIS-ISA-EMS-DOC (CON-1N):", bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
        log(TraceLevel.Trace, "BHJL707A-C-TIPO-DOC-ID      (CON-1N):", bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
        if (envOut.errosGraves().semErros().isTrue()) {
            if (swSwitchs().swDocNok().isTrue()) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                if (msgOut().msg().ade().iInszDocIdCli().isEqual(CON_SIM)) {
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().insDocAptdCli());
                } else {
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().itvtOpexSdocIdObg());
                }
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "ERRO-27");
            } else if (swSwitchs().swDocOk().isTrue()) {
                /**
                 * IF SW-DOC-OK-AUX
                 * MOVE BHJL707A-C-PAIS-ISA-EMS-DOC (CON-1N)
                 * BGHM1130-C-PAIS-ISA-EMS-DOC
                 * BGHM1131-C-PAIS-ISA-EMS-DOC
                 */
                msgIn().msg().ade().cPaisEmDocPrin().set(wsTempo().wsCPaisIsaEmsDocAux());
                msgOut().msg().ade().cPaisEmDocPrin().set(wsTempo().wsCPaisIsaEmsDocAux());
                /**
                 * MOVE BHJL707A-C-TIPO-DOC-ID      (CON-1N)
                 * TO BGHM1130-C-TIPO-DOC-ID
                 * BGHM1131-C-TIPO-DOC-ID
                 */
                msgIn().msg().ade().cTipoDocIdPrin().set(wsTempo().wsCTipoDocIdAux());
                msgOut().msg().ade().cTipoDocIdPrin().set(wsTempo().wsCTipoDocIdAux());
                /**
                 * MOVE BHJL707A-N-DOC-ID           (CON-1N)
                 * TO BGHM1130-N-DOC-ID
                 * BGHM1131-N-DOC-ID
                 */
                msgIn().msg().ade().nDocIdPrin().set(wsTempo().wsNDocIdAux());
                msgOut().msg().ade().nDocIdPrin().set(wsTempo().wsNDocIdAux());
                /**
                 * MOVE BHJL707A-Z-VLDE-DOC-ID      (CON-1N)
                 */
                if ((wsTempo().wsCEntEmixDocIdAux().isEqual(CON_9901VITAL) || 
                    wsTempo().wsCEntEmixDocIdAux().isEqual(CON_9902VITAL) || 
                    wsTempo().wsCEntEmixDocIdAux().isEqual(CON_9903VITAL) || 
                    wsTempo().wsCEntEmixDocIdAux().isEqual(CON_9901VTSSO2) || 
                    wsTempo().wsCEntEmixDocIdAux().isEqual(CON_9902VTSSO2) || 
                    wsTempo().wsCEntEmixDocIdAux().isEqual(CON_9903VTSSO2)) && 
                    wsTempo().wsZVldeDocIdAux().isEqual(CON_DATA_MAX)) {
                    msgIn().msg().ade().zVldeDocIdPrin().set(CON_DATA_MAX_VIT);
                    msgOut().msg().ade().zVldeDocIdPrin().set(CON_DATA_MAX_VIT);
                } else {
                    /**
                     * TO BGHM1130-Z-VLDE-DOC-ID
                     * BGHM1131-Z-VLDE-DOC-ID
                     */
                    msgIn().msg().ade().zVldeDocIdPrin().set(wsTempo().wsZVldeDocIdAux());
                    msgOut().msg().ade().zVldeDocIdPrin().set(wsTempo().wsZVldeDocIdAux());
                }
                /**
                 * MOVE BHJL707A-C-ENT-EMIX-DOC-ID  (CON-1N)
                 * TO BGHM1130-C-ENT-EMIX-DOC-ID
                 * BGHM1131-C-ENT-EMIX-DOC-ID
                 */
                msgIn().msg().ade().cEntEmiDocPrin().set(wsTempo().wsCEntEmixDocIdAux());
                msgOut().msg().ade().cEntEmiDocPrin().set(wsTempo().wsCEntEmixDocIdAux());
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m1540RelacaoCliCnt() ;
        }
    }
    
    /**
     * 
     * GH1981 - E002444 - 2017-01-18 - INICIO
     * 1550-VALIDA-SUBCONTA
     * 
     */
    protected void m1550ValidaSubconta() {
        log(TraceLevel.Debug, "  1550-VALIDA-SUBCONTA");
        bhol002a().commarea().initialize() ;
        bhol002a().commarea().dadosInput().modoConsulta().setTrue() ;
        bhol002a().commarea().dadosInput().chaveConsulta().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhol002a().commarea().dadosInput().chaveConsulta().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhol002a().commarea().dadosInput().chaveConsulta().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhol002a().commarea().dadosInput().chaveConsulta().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhol002a().commarea().dadosInput().chaveConsulta().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhol002a().commarea().dadosInput().chaveConsulta().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        bhol002a().commarea().dadosInput().chaveConsulta().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        bhol002a().commarea().dadosInput().chaveConsulta().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        bhop1002AcessoMhoj002a() ;
        if (bhol002a().commarea().dadosErro().semErros().isTrue()) {
            if (bhol002a().commarea().dadosOutput().iTipoRstzMovz().isEqual(CON_2)) {
                envOut.errosGraves().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcContM().set(bhok0001().inibicaoMovNum());
                envOut.errosGraves().cRtnoEvenSwal().set(bhok0001().inibicaoMovNum());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcCont1().setTrue() ;
                log(TraceLevel.Error, "HO -507 - INIBICAO MOVIMENTACAO NUMERARIO");
            }
            /**
             * PASSIVAS 4357 - INI
             */
            if (swSwitchs().swEntrega().isTrue() && 
                bhol002a().commarea().dadosOutput().nsMovUlt().isEqual(Pghs133a.CON_0N) && 
                bhol002a().commarea().dadosOutput().iTipoRstzMovz().isEqual(CON_3)) {
                envOut.errosGraves().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcContM().set(bhok0001().inibicaoMovPri());
                envOut.errosGraves().cRtnoEvenSwal().set(bhok0001().inibicaoMovPri());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcCont1().setTrue() ;
                log(TraceLevel.Error, "HO -744 - INIBICAO PRIMEIRA MOVIMENTACAO ", "EM NUMERARIO");
            }
        } else {
            /**
             * PASSIVAS 4357 - FIM
             */
            envOut.errosGraves().aAplErr().set(bhol002a().commarea().dadosErro().aAplErr());
            msgOut().msg().ase().cOeEgcContSt().cOeEgcContM().set(bhol002a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.errosGraves().cRtnoEvenSwal().set(bhol002a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.db2Log().nmTabela().set(bhol002a().commarea().dadosErro().nmTabela());
            envOut.db2Log().sqlca().cSqlcode().set(bhol002a().commarea().dadosErro().cSqlcode());
            msgOut().msg().ase().cOeEgcContSt().cOeEgcCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
        }
    }
    
    /**
     * 
     * GH1981 - E002444 - 2017-01-18 - FIM
     * 1600-LIMPA-OUTPUT
     * 
     */
    protected void m1600LimpaOutput() {
        log(TraceLevel.Debug, "  1600-LIMPA-OUTPUT");
        msgIn().msg().ade().iRcsJstzOrmFnd().set(CON_NAO);
        msgOut().msg().ade().iRcsJstzOrmFnd().set(CON_NAO);
        msgIn().msg().ade().iPedJstzOrmFnd().set(CON_NAO);
        msgOut().msg().ade().iPedJstzOrmFnd().set(CON_NAO);
        msgIn().msg().ade().iDocDszd().set(CON_NAO);
        msgOut().msg().ade().iDocDszd().set(CON_NAO);
        msgIn().msg().ade().iNcssTrrFotoc().set(CON_NAO);
        msgOut().msg().ade().iNcssTrrFotoc().set(CON_NAO);
        msgIn().msg().ade().cMtvoPedJstz().set(" ");
        msgOut().msg().ade().cMtvoPedJstz().set(" ");
        msgIn().msg().ade().mAcmdEtga().set(0);
        msgIn().msg().ade().mAcmdEtga().set(0);
        if (swSwitchs().swPagChqOicHbf0().isTrue()) {
            msgIn().msg().ade().cPaisIsoaCont().set(" ");
            msgOut().msg().ade().cPaisIsoaCont().set(" ");
            msgIn().msg().ade().cBancCont().set(0);
            msgOut().msg().ade().cBancCont().set(0);
            msgIn().msg().ade().cOeEgcCont().set(0);
            msgOut().msg().ade().cOeEgcCont().set(0);
            msgIn().msg().ade().nsRdclCont().set(0);
            msgOut().msg().ade().nsRdclCont().set(0);
            msgIn().msg().ade().vChkdCont().set(0);
            msgOut().msg().ade().vChkdCont().set(0);
            msgIn().msg().ade().cTipoCont().set(0);
            msgOut().msg().ade().cTipoCont().set(0);
            msgIn().msg().ade().cMoedIsoScta().set(" ");
            msgOut().msg().ade().cMoedIsoScta().set(" ");
            msgIn().msg().ade().nsDeposito().set(0);
            msgOut().msg().ade().nsDeposito().set(0);
        }
    }
    
    /**
     * 
     * 1510-OBTEM-TP-DOC
     * 
     */
    protected void m1510ObtemTpDoc() {
        log(TraceLevel.Debug, "   1510-OBTEM-TP-DOC");
        bhgl052a().commarea().dadosInput().cTabBbnIn().set(CON_TIPODOCID_886);
        bhgl052a().commarea().dadosInput().cIdioIsoIn().set(bhok0002().BHOK0002_IDIOMA_PORTUGAL);
        bhgl052a().commarea().dadosInput().pagInput().cCodigoPgIn().set(bhgl052a().commarea().dadosOutput().pagOutput().cCodigoPgOut());
        bhgl052a().commarea().dadosInput().pagInput().cIdioIsoPgIn().set(bhgl052a().commarea().dadosOutput().pagOutput().cIdioIsoPgOut());
        bhgp0052AcedeMhgj052a() ;
        if (!bhgl052a().commarea().dadosErro().fimConsulta().isTrue() && !bhgl052a().commarea().dadosErro().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhgl052a().commarea().dadosErro().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhgl052a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.db2Log().nmTabela().set(bhgl052a().commarea().dadosErro().nmTabela());
            envOut.db2Log().sqlca().cSqlcode().set(bhgl052a().commarea().dadosErro().cSqlcode());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-28");
            swSwitchs().swFimCiclo().setTrue() ;
        }
        bhgl052a().commarea().dadosOutput().indice().set(CON_1N);
        while (bhgl052a().commarea().dadosOutput().indice().isLessOrEqual(CON_100N) && !bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteLogica().cCodigo().isEmpty()) {
            wsTempo().wsCodCodigo().set(bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteLogica().cCodigo());
            if (wsTempo().wsCodCodigo().wsCcCPais().isEqual(bhok0002().cPaisIsoaCpd()) && 
                bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteFisica().xCteuCo01().isEqual(CON_SIM)) {
                wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo().set(bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteLogica().cCodigo());
                /**
                 * ------------- VHG88601-CT-PRIO-VLDZ-DID
                 */
                wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdXCteuCo03().set(bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteFisica().xCteuCo03());
                log(TraceLevel.Error, "WS-IND:", wsTempo().wsInd());
                log(TraceLevel.Error, "WS-TD-C-CODIGO:", wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo());
                log(TraceLevel.Error, "WS-TD-X-CTEU-CO03:", wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdXCteuCo03());
                wsTempo().wsInd().add(CON_1N);
            }
            bhgl052a().commarea().dadosOutput().indice().add(CON_1N);
        }
        if (bhgl052a().commarea().dadosOutput().logicaFisica().get(CON_100N).componenteLogica().cCodigo().isEmpty()) {
            swSwitchs().swFimCiclo().setTrue() ;
            wsTempo().wsInd().set(CON_1N);
            while (wsTempo().wsInd().isLessOrEqual(CON_100N) && !wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo().isEmpty()) {
                log(TraceLevel.Debug, "   WS-TD-C-CODIGO/WS-TD-X-CTEU-CO03", ":", wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo(), "/", wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdXCteuCo03());
                wsTempo().wsInd().add(CON_1N);
            }
        }
    }
    
    /**
     * 
     * 1520-ORDENA-TAB-INTERNA
     * 
     */
    protected void m1520OrdenaTabInterna() {
        log(TraceLevel.Debug, "   1520-ORDENA-TAB-INTERNA");
        wsTempo().wsIndExt().set(CON_1N);
        wsTempo().wsIndInt().set(CON_1N);
        while (wsTempo().wsIndExt().isLessOrEqual(CON_250N) && !wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndExt()).wsTdCCodigo().isEmpty()) {
            wsTempo().wsIndInt().set(wsTempo().wsIndExt());
            wsTempo().wsIndInt().add(CON_1N);
            while (wsTempo().wsIndInt().isLessOrEqual(CON_250N) && !wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndInt()).wsTdCCodigo().isEmpty()) {
                if (wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndExt()).wsTdXCteuCo03().isGreater(wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndInt()).wsTdXCteuCo03())) {
                    wsTempo().wsCCodigoTemp().set(wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndExt()).wsTdCCodigo());
                    wsTempo().wsXCteuCo03Temp().set(wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndExt()).wsTdXCteuCo03());
                    wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndExt()).wsTdCCodigo().set(wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndInt()).wsTdCCodigo());
                    wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndExt()).wsTdXCteuCo03().set(wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndInt()).wsTdXCteuCo03());
                    wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndInt()).wsTdCCodigo().set(wsTempo().wsCCodigoTemp());
                    wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsIndInt()).wsTdXCteuCo03().set(wsTempo().wsXCteuCo03Temp());
                }
                wsTempo().wsIndInt().add(CON_1N);
            }
            wsTempo().wsIndExt().add(CON_1N);
        }
        wsTempo().wsInd().set(CON_1N);
        while (wsTempo().wsInd().isLessOrEqual(CON_100N) && !wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo().isEmpty()) {
            log(TraceLevel.Debug, "   WS-TD-C-CODIGO/WS-TD-X-CTEU-CO03", ":", wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo(), "/", wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdXCteuCo03());
            wsTempo().wsInd().add(CON_1N);
        }
    }
    
    /**
     * 
     * 1530-OBTEM-DADOS-DOC
     * 
     */
    protected void m1530ObtemDadosDoc() {
        log(TraceLevel.Debug, "   1530-OBTEM-DADOS-DOC");
        if (wsTempo().wsInd().isEqual(1)) {
            log(TraceLevel.Debug, "   WS-N-CLIENTE  : ", wsTempo().wsNCliente());
            log(TraceLevel.Debug, "   WS-NS-ABRA-CLI: ", wsTempo().wsNsAbraCli());
        }
        log(TraceLevel.Debug, "   WS-TD-C-CODIGO: ", wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo());
        bhjl707a().commarea().initialize() ;
        bhjl707a().commarea().dadosEntrada().nCliente().set(wsTempo().wsNCliente());
        bhjl707a().commarea().dadosEntrada().nsAbraCli().set(wsTempo().wsNsAbraCli());
        wsTempo().wsCodCodigo().set(wsTabelasInternas().wsTipoDocumento().get(wsTempo().wsInd()).wsTdCCodigo());
        bhjl707a().commarea().dadosEntrada().cPaisEmsDocPed().set(wsTempo().wsCodCodigo().wsCcCPais());
        bhjl707a().commarea().dadosEntrada().cTipoDocPed().set(wsTempo().wsCodCodigo().wsCcTDoc());
        bhjp0707AcedeMhjj707a() ;
        log(TraceLevel.Debug, "BHJL707A-C-TIPO-ERRO-BBN:", bhjl707a().commarea().erros().cTipoErroBbn());
        if (bhjl707a().commarea().erros().semErros().isTrue() || bhjl707a().commarea().erros().fimConsulta().isTrue()) {
            /**
             * MOVE BHJL707A-Z-VLDE-DOC-ID(CON-1N) TO
             * WS-TAB-Z-VLDE-DOC(WS-IND)
             * IF SW-DEBUG-SIM
             * DISPLAY 'SW-DOC-02:'SW-DOC
             * DISPLAY 'WS-IND:'WS-IND
             * DISPLAY 'WS-TAB-Z-VLDE-DOC(WS-IND):'
             * DISPLAY 'WS-TD-C-CODIGO-DOC(WS-IND):'
             * WS-TD-C-CODIGO-DOC(WS-IND)
             * END-IF
             */
            if (bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc().isEqual(wsTempo().wsCodCodigo().wsCcCPais()) && 
                bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId().isEqual(wsTempo().wsCodCodigo().wsCcTDoc())) {
                swSwitchs().swDocOk().setTrue() ;
                if (swSwitchs().swDocAux().isEmpty()) {
                    swSwitchs().swDocOkAux().setTrue() ;
                    log(TraceLevel.Error, "SW-DOC-OK-AUX");
                    wsTempo().wsCPaisIsaEmsDocAux().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
                    wsTempo().wsCTipoDocIdAux().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
                    wsTempo().wsNDocIdAux().set(bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
                    wsTempo().wsZVldeDocIdAux().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                    wsTempo().wsCEntEmixDocIdAux().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
                    log(TraceLevel.Debug, "WS-C-PAIS-ISA-EMS-DOC-AUX:", wsTempo().wsCPaisIsaEmsDocAux());
                    log(TraceLevel.Debug, "WS-C-TIPO-DOC-ID-AUX:", wsTempo().wsCTipoDocIdAux());
                    log(TraceLevel.Debug, "WS-N-DOC-ID-AUX:", wsTempo().wsNDocIdAux());
                    log(TraceLevel.Debug, "WS-Z-VLDE-DOC-ID-AUX:", wsTempo().wsZVldeDocIdAux());
                    log(TraceLevel.Debug, "WS-C-ENT-EMIX-DOC-ID-AUX:", wsTempo().wsCEntEmixDocIdAux());
                }
            }
        } else if (!bhjl707a().commarea().erros().erroFuncao().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl707a().commarea().erros().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl707a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl707a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl707a().commarea().erros().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-29");
        }
        wsTempo().wsInd().add(CON_1N);
    }
    
    /**
     * 
     * 1540-RELACAO-CLI-CNT
     * 
     */
    protected void m1540RelacaoCliCnt() {
        log(TraceLevel.Debug, "   1540-RELACAO-CLI-CNT");
        if (!swSwitchs().swPagChqOicHbf0().isTrue() && !swSwitchs().swPagChqHve5Hvl3().isTrue()) {
            bhjl249a().commarea().initialize() ;
            m1541AcessoMhjj249a() ;
            wsTempo().wsObtemRel().set(0);
            swSwitchs().swCodIntervencao().set(0);
            wsTempo().wsInd().set(CON_1N);
            if (envOut.errosGraves().semErros().isTrue()) {
                while (wsTempo().wsInd().isLessOrEqual(bhjl249a().commarea().qOccursOut()) && !wsTempo().wsObtemRel().isEqual(CON_11N)) {
                    swSwitchs().swCodIntervencao().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).iTipoItvt());
                    log(TraceLevel.Debug, "   SW-COD-INTERVENCAO      : ", swSwitchs().swCodIntervencao());
                    log(TraceLevel.Debug, "    BHJL249A-Z-INIC-REL    : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).zInicRel());
                    log(TraceLevel.Debug, "    BHJL249A-Z-FIM-REL     : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).zFimRel());
                    if (msgIn().msg().ade().nCliente().isEqual(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nCliente()) && 
                        msgIn().msg().ade().nsAbraCli().isEqual(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsAbraCli()) && 
                        (swSwitchs().swItvtTitular().isTrue() || swSwitchs().swItvtAutorizado().isTrue())) {
                        wsTempo().wsObtemRel().add(CON_1N);
                    }
                    log(TraceLevel.Debug, "   BHJL249A-I-TIPO-ITVT: ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).iTipoItvt());
                    log(TraceLevel.Debug, "   BHJL249A-NS-TITC    : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsTitc());
                    log(TraceLevel.Debug, "   BHJL249A-N-CLIENTE  : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nCliente());
                    log(TraceLevel.Debug, "   BHJL249A-NS-ABRA-CLI: ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsAbraCli());
                    if (bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsTitc().isEqual(CON_1_TITULAR) && 
                        swSwitchs().swItvtTitular().isTrue()) {
                        wsTempo().wsObtemRel().add(CON_10N);
                        wsTempo().wsNCliente1t().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nCliente());
                        wsTempo().wsNsAbraCli1t().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsAbraCli());
                    }
                    wsTempo().wsInd().add(CON_1N);
                }
            }
        } else if (wsTempo().wsObtemRel().isEqual(0)) {
            wsTempo().wsObtemRel().add(CON_10N);
        }
        log(TraceLevel.Debug, "   COM (01 / 11) OU SEM (10) RELACAO...");
        log(TraceLevel.Debug, "   WS-OBTEM-REL : ", wsTempo().wsObtemRel());
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * --- COM RELACAO
             */
            if (wsTempo().wsObtemRel().isEqual(CON_1N) || 
                wsTempo().wsObtemRel().isEqual(CON_11N)) {
                if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_PROPRIO)) {
                    if (msgIn().msg().ade().iClszTtr1Cont().isEqual(CON_EMPRESA)) {
                        if (swSwitchs().swEntrega().isTrue() || swSwitchs().swEntregaNAlnova().isTrue()) {
                            swSwitchs().swPropOuMdtaEmpresa().setTrue() ;
                        } else if (swSwitchs().swLevantamento().isTrue() || swSwitchs().swLiquidacaoConta().isTrue()) {
                            swSwitchs().swPropLevEmpresa().setTrue() ;
                        } else if (swSwitchs().swPagChqCtaHvl7().isTrue() || swSwitchs().swPagChqVisadoHvb2().isTrue()) {
                            swSwitchs().swPropPagChqEmpresa().setTrue() ;
                        }
                    } else if (swSwitchs().swEntrega().isTrue() || swSwitchs().swEntregaNAlnova().isTrue()) {
                        swSwitchs().swPropriosParticular().setTrue() ;
                    } else if (swSwitchs().swLevantamento().isTrue() || swSwitchs().swLiquidacaoConta().isTrue()) {
                        swSwitchs().swPropLevParticular().setTrue() ;
                    } else if (swSwitchs().swPagChqCtaHvl7().isTrue() || swSwitchs().swPagChqVisadoHvb2().isTrue()) {
                        swSwitchs().swPropPagChqParticular().setTrue() ;
                    }
                } else {
                    envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().identInvCliCtaRel());
                    msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                    envOut.errosGraves().errosFuncao().setTrue() ;
                    log(TraceLevel.Error, "ERRO-30");
                }
            }
            if (envOut.errosGraves().semErros().isTrue() && 
                wsTempo().wsObtemRel().isEqual(CON_10N)) {
                if (msgIn().msg().ade().iClszTtr1Cont().isEqual(CON_EMPRESA)) {
                    if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO)) {
                        if (swSwitchs().swEntrega().isTrue() || swSwitchs().swEntregaNAlnova().isTrue()) {
                            swSwitchs().swPropOuMdtaEmpresa().setTrue() ;
                        }
                    } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS)) {
                        swSwitchs().swTerceirosEmpresa().setTrue() ;
                    } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENE_CHQ)) {
                        swSwitchs().swBeneChqEmpresa().setTrue() ;
                    } else {
                        envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                        msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().identInvNExistRel());
                        msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                        envOut.errosGraves().errosFuncao().setTrue() ;
                        log(TraceLevel.Error, "ERRO-31");
                    }
                } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS)) {
                    swSwitchs().swTerceirosParticular().setTrue() ;
                } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENE_CHQ)) {
                    swSwitchs().swBeneChqParticular().setTrue() ;
                } else {
                    envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().identInvNExistRel());
                    msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                    envOut.errosGraves().errosFuncao().setTrue() ;
                    log(TraceLevel.Error, "ERRO-32");
                }
            }
        }
    }
    
    /**
     * 
     * 1541-ACESSO-MHJJ249A
     * 
     */
    protected void m1541AcessoMhjj249a() {
        log(TraceLevel.Debug, "    1541-ACESSO-MHJJ249A");
        log(TraceLevel.Debug, "   BHTL001A-C-PAIS-ISOA-OE-OPX: ", message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BHTL001A-C-MNEM-EGC-OPEX   : ", message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISOA-CONT  : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BGHM1130-C-BANC-CONT       : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "   BGHM1130-C-OE-EGC-CONT     : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "   BGHM1130-NS-RDCL-CONT      : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "   BGHM1130-V-CHKD-CONT       : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-CONT       : ", msgIn().msg().ade().cTipoCont());
        bhjl249a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl249a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl249a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        bhjl249a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().cBancCont());
        bhjl249a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        bhjl249a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        bhjl249a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        bhjl249a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        if (message.mensagem().headerR().simzSim().isTrue()) {
            if (swSwitchs().swPagChqVisadoHvb2().isTrue()) {
                bhjl249a().commarea().dadosEntrada().zConsulta().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
            } else {
                bhjl249a().commarea().dadosEntrada().zConsulta().set(CON_DATA_MAX);
            }
        } else if (swSwitchs().swLiquidacaoConta().isTrue() || swSwitchs().swPagChqVisadoHvb2().isTrue()) {
            bhjl249a().commarea().dadosEntrada().zConsulta().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        } else {
            bhjl249a().commarea().dadosEntrada().zConsulta().set(CON_DATA_MAX);
        }
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-SIMZ       : ", message.mensagem().headerR().iTrnzSimz());
        log(TraceLevel.Debug, "   SW-C-TIPO-MOV-SCTA         : ", swSwitchs().swCTipoMovScta());
        log(TraceLevel.Debug, "   ...BHJL249A-Z-CONSULTA     : ", bhjl249a().commarea().dadosEntrada().zConsulta());
        if (bhjl249a().commarea().pagCheia().isTrue()) {
            bhjl249a().commarea().dadosEntrada().iTipoItvtPag().set(bhjl249a().commarea().dadosSaida().get(999).iTipoItvt());
            bhjl249a().commarea().dadosEntrada().nsTitcPag().set(bhjl249a().commarea().dadosSaida().get(999).nsTitc());
        }
        bhjp5249AcedeMhjj249a() ;
        if (!bhjl249a().commarea().erros().fimConsulta().isTrue() && !bhjl249a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl249a().commarea().erros().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl249a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().nmTabela().set(bhjl249a().commarea().erros().nmTabela());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl249a().commarea().erros().cSqlcode());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-33");
        }
    }
    
    /**
     * 
     * *GH2024--> INICIO
     * 1700-OBTER-OBRIG-ID
     * 
     */
    protected void m1700ObterObrigId() {
        log(TraceLevel.Debug, "    1700-OBTER-OBRIG-ID");
        log(TraceLevel.Debug, "C-TIPO-ITVT-DEP - INICIO ");
        log(TraceLevel.Debug, "C-TIPO-ITVT-DEP: ", msgIn().msg().ade().cTipoItvtDep());
        if (envOut.errosGraves().semErros().isTrue()) {
            m1701Obter1Titular() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m1702ObterSectIttl() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m1703ValidaObrigDoc() ;
        }
    }
    
    /**
     * 
     * 1701-OBTER-1-TITULAR
     * 
     */
    protected void m1701Obter1Titular() {
        log(TraceLevel.Debug, "    1701-OBTER-1-TITULAR");
        hrMhjj060a().bhjl060a().commarea().initialize() ;
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().zConsulta().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().iTipoItvt().set(bhok0002().iTipoItvt().itvtTitular());
        hrMhjj060a().bhjl060a().commarea().dadosEntrada().nsTitc().set(bhok0002().nsTitc().primeiroTitular());
        bhjp5060AcedeMhjj060a() ;
        if (!hrMhjj060a().bhjl060a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(hrMhjj060a().bhjl060a().commarea().erros().cTipoErroBbn());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(hrMhjj060a().bhjl060a().commarea().erros().cRtnoEvenSwal());
            envOut.errosGraves().cRtnoEvenSwal().set(hrMhjj060a().bhjl060a().commarea().erros().cRtnoEvenSwal());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.db2Log().sqlca().cSqlcode().set(hrMhjj060a().bhjl060a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhjj060a().bhjl060a().commarea().erros().nmTabela());
            envOut.errosGraves().aAplErr().set(hrMhjj060a().bhjl060a().commarea().erros().aAplErr());
        }
    }
    
    /**
     * 
     * 1702-OBTER-SECT-ITTL
     * 
     */
    protected void m1702ObterSectIttl() {
        log(TraceLevel.Debug, "    1702-OBTER-SECT-ITTL");
        bhjl013a().commarea().initialize() ;
        bhjl013a().commarea().dadosEntrada().nCliente().set(hrMhjj060a().bhjl060a().commarea().dadosSaida().nCliente());
        bhjl013a().commarea().dadosEntrada().nsAbraCli().set(hrMhjj060a().bhjl060a().commarea().dadosSaida().nsAbraCli());
        bhjl013a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl013a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjp5013AcedeMhjj013a() ;
        log(TraceLevel.Debug, " R E T O R N O   M H J J 0 1 3 A");
        log(TraceLevel.Debug, " --> BHJL013A-A-APL-ERR          :", bhjl013a().commarea().erros().aAplErr());
        log(TraceLevel.Debug, " --> BHJL013A-C-RTNO-EVEN-SWAL   :", bhjl013a().commarea().erros().cRtnoEvenSwal());
        log(TraceLevel.Debug, " --> BHJL013A-C-TIPO-ERRO-BBN    :", bhjl013a().commarea().erros().cTipoErroBbn());
        if (!bhjl013a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhjl013a().commarea().erros().cTipoErroBbn());
            envOut.errosGraves().aAplErr().set(bhjl013a().commarea().erros().aAplErr());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl013a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl013a().commarea().erros().nmTabela());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bhjl013a().commarea().erros().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 1703-VALIDA-OBRIG-DOC
     * 
     */
    protected void m1703ValidaObrigDoc() {
        log(TraceLevel.Debug, "   1703-VALIDA-OBRIG-DOC");
        log(TraceLevel.Debug, "SECT-ITTL-BPOR: ", bhjl013a().commarea().dadosSaida().cSectIttlBpor());
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().cMnemEmpGcx().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cPaisIsoAlfn().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cTabBbn().set(CON_REGMJRDC_879);
        hrMhgj030a().bhgl030a().commarea().dadosInput().cCodigo().set(bhjl013a().commarea().dadosSaida().cSectIttlBpor());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cIdioIso().set(bhok0002().BHOK0002_IDIOMA_PORTUGAL);
        hrMhgj030a().bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().conteudos().setTrue() ;
        bhgp0030AcessoTabela() ;
        /**
         * *PASS2972 - FIM
         */
        if (!hrMhgj030a().bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-35");
        } else if (hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo11().isEqual("N")) {
            msgIn().msg().ade().cTipoItvtDep().set(CON_DEP_EXPRESSO_24H);
            /**
             * *PASS2972 - INI
             * END-IF
             */
            msgIn().msg().ade().iValidaDocId().set(CON_NAO);
        } else {
            msgIn().msg().ade().iValidaDocId().set(CON_SIM);
        }
        log(TraceLevel.Debug, "BGHM1130-I-VALIDA-DOC-ID:", msgIn().msg().ade().iValidaDocId());
    }
    
    /**
     * 
     * *GH2024--> FIM
     * M000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        log(TraceLevel.Debug, "   SW-C-TIPO-MOV-SCTA         : ", swSwitchs().swCTipoMovScta());
        if (swSwitchs().swEntrega().isTrue() || swSwitchs().swEntregaNAlnova().isTrue()) {
            m2000aDepNumerario() ;
        } else if (swSwitchs().swLevantamento().isTrue() || swSwitchs().swLiquidacaoConta().isTrue() || 
            swSwitchs().swPagChqCtaHvl7().isTrue() || 
            swSwitchs().swPagChqOicHbf0().isTrue() || 
            swSwitchs().swPagChqHve5Hvl3().isTrue() || 
            swSwitchs().swPagChqVisadoHvb2().isTrue()) {
            m2000bLevOuPagChq() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzNao().isTrue() && 
            message.mensagem().headerR().anulDiaNao().isTrue()) {
            m2400InsereTgh130() ;
        }
        if (message.mensagem().headerR().anulDiaSim().isTrue()) {
            m2500Estorno() ;
        }
    }
    
    /**
     * 
     * 2000A-DEP-NUMERARIO
     * 
     */
    protected void m2000aDepNumerario() {
        log(TraceLevel.Debug, " 2000A-DEP-NUMERARIO");
        log(TraceLevel.Debug, "   SW-TIPO-ITVT-CLSZ-TTR1-CONT: ", swSwitchs().swTipoItvtClszTtr1Cont());
        log(TraceLevel.Debug, "   BHTL001A-C-TIPO-CANL-ACES  : ", message.mensagem().headerR().transaccao().cTipoCanlAces());
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-SIMZ       : ", message.mensagem().headerR().iTrnzSimz());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-97: ", wsTempo().wsMtItvtOpe());
        if (message.mensagem().headerR().simzSim().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue()) {
            if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO)) {
                m2100CanalBalcao() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2200Apura1titularCta() ;
                }
                /**
                 * NO AMBITO DO AVISO 5, VAMOS PASSAR A VALIDAR TODOS OS COMPROVA-
                 * TIVOS. DEVERA SER CONSULTADA A CLIJG6
                 */
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (msgOut().msg().ade().iDocDszd().isEqual(CON_NAO) && 
                        !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
                        (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) || 
                        msgIn().msg().ade().cTipoMdti().isEqual("E") || 
                        msgIn().msg().ade().cTipoMdti().isEqual("D")) && 
                        msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                        m2330ValidaDocClijg6() ;
                    }
                }
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue()) {
            if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_ATS)) {
                m2300CanalAts() ;
            }
        }
        /**
         * GH1981 - E002444 - 2017-01-18 - INICIO
         */
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue()) {
            if (bhol002a().commarea().dadosOutput().iTipoRstzMovz().isEqual(CON_0)) {
                envOut.errosGraves().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcContM().set(bhok0001().inibicaoMovNum());
                envOut.errosGraves().cRtnoEvenSwal().set(bhok0001().inibicaoMovNum());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcCont1().setTrue() ;
                log(TraceLevel.Error, "HO -507 - INIBICAO MOVIMENTACAO NUMERARIO");
            }
        }
    }
    
    /**
     * 
     * 2000B-LEV-OU-PAG-CHQ
     * 
     */
    protected void m2000bLevOuPagChq() {
        log(TraceLevel.Debug, " 2000B-LEV-OU-PAG-CHQ");
        log(TraceLevel.Debug, "   SW-TIPO-ITVT-CLSZ-TTR1-CONT: ", swSwitchs().swTipoItvtClszTtr1Cont());
        log(TraceLevel.Debug, "   BHTL001A-C-TIPO-CANL-ACES  : ", message.mensagem().headerR().transaccao().cTipoCanlAces());
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-SIMZ       : ", message.mensagem().headerR().iTrnzSimz());
        if (message.mensagem().headerR().simzSim().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue()) {
            /**
             * GH2161- FIM
             */
            if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_BALCAO)) {
                m2600BalcLevPagChq() ;
                if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swPagChqOicHbf0().isTrue() && 
                    !swSwitchs().swPagChqHve5Hvl3().isTrue() && 
                    !swSwitchs().swPagChqVisadoHvb2().isTrue()) {
                    m2200Apura1titularCta() ;
                }
                /**
                 * GH2161-INICIO
                 */
                if (envOut.errosGraves().semErros().isTrue()) {
                    if (msgOut().msg().ade().iDocDszd().isEqual(CON_NAO) && 
                        !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
                        (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) || 
                        msgIn().msg().ade().cTipoMdti().isEqual("E") || 
                        msgIn().msg().ade().cTipoMdti().isEqual("D")) && 
                        msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                        m2330ValidaDocClijg6() ;
                    }
                }
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue()) {
            if (message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_ATS)) {
                m2300CanalAts() ;
            }
        }
        /**
         * GH1981 - E002444 - 2017-01-18 - INICIO
         */
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue()) {
            if (bhol002a().commarea().dadosOutput().iTipoRstzMovz().isEqual(CON_1)) {
                envOut.errosGraves().aAplErr().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcContM().set(bhok0001().inibicaoMovNum());
                envOut.errosGraves().cRtnoEvenSwal().set(bhok0001().inibicaoMovNum());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcCont1().setTrue() ;
                log(TraceLevel.Error, "HO -507 - INIBICAO MOVIMENTACAO NUMERARIO");
            }
        }
    }
    
    /**
     * 
     * 2100-CANAL-BALCAO
     * 
     */
    protected void m2100CanalBalcao() {
        log(TraceLevel.Debug, "  2100-CANAL-BALCAO");
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-98: ", wsTempo().wsMtItvtOpe());
        if (!msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H) && 
            (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) || 
            msgIn().msg().ade().cTipoMdti().isEqual("E") || 
            msgIn().msg().ade().cTipoMdti().isEqual("D"))) {
            m2105ValDocDszd() ;
        }
        if (swSwitchs().swPropriosParticular().isTrue()) {
            log(TraceLevel.Debug, "--- A - SW-PROPRIOS-PARTICULAR");
            m2110AcumItvtOpe() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                m2120AcumConta() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m2130ValidaMontsA() ;
            }
        } else if (swSwitchs().swTerceirosParticular().isTrue()) {
            log(TraceLevel.Debug, "--- B - SW-TERCEIROS-PARTICULAR");
            bhjl249a().commarea().initialize() ;
            swSwitchs().swCliSemRisco().setTrue() ;
            while (!bhjl249a().commarea().erros().fimConsulta().isTrue() && envOut.errosGraves().semErros().isTrue() && !swSwitchs().swCliAltoRisco().isTrue()) {
                m2140ObtmIntvt() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m2110AcumItvtOpe() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m2150ValidaMontsB() ;
            }
        } else if (swSwitchs().swPropOuMdtaEmpresa().isTrue()) {
            log(TraceLevel.Debug, "--- C - PROP-OU-MDTA-EMPRESA   ");
            log(TraceLevel.Debug, "    BGHM1130-C-TIPO-ITVT-DEP : ", msgIn().msg().ade().cTipoItvtDep());
            if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_PROPRIO)) {
                m2110AcumItvtOpe() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2120AcumConta() ;
                }
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2160ValidaMontsCProp() ;
                }
            }
            /**
             * -- ENTREGA
             */
            if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO)) {
                log(TraceLevel.Debug, "  2100-CANAL-BALCAO");
                log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
                if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriMe())) {
                    msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                    msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
                    msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
                    log(TraceLevel.Debug, "    ATENCAO -- MONT-ENTREGA >= ", bghk0005().limitesMontanteNum().etgNmriMe(), " : ", msgIn().msg().ade().mMovNmri());
                }
            }
        } else if (swSwitchs().swTerceirosEmpresa().isTrue()) {
            log(TraceLevel.Debug, "--- D - SW-TERCEIROS-EMPRESA   ");
            log(TraceLevel.Debug, "    BHOL708A-I-CLSZ-TTR1-CONT: ", bhol708a().commarea().dadosOutput().vho00101().iClszTtr1Cont());
            bhjl249a().commarea().initialize() ;
            swSwitchs().swCliSemRisco().setTrue() ;
            while (!bhjl249a().commarea().erros().fimConsulta().isTrue() && !swSwitchs().swCliAltoRisco().isTrue() && envOut.errosGraves().semErros().isTrue()) {
                m2140ObtmIntvt() ;
            }
            log(TraceLevel.Debug, "   EMPRESA SEM OU ALTO RISCO (S/A)");
            log(TraceLevel.Debug, "    SW-RISCO-CLIENTE        : ", swSwitchs().swRiscoCliente());
            if (envOut.errosGraves().semErros().isTrue() && swSwitchs().swCliAltoRisco().isTrue()) {
                /**
                 * --- RISCO ALTO
                 */
                m2110AcumItvtOpe() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2170ValMontsDEmpRisc() ;
                }
            } else {
                /**
                 * --- RISCO BAIXO
                 */
                if (envOut.errosGraves().semErros().isTrue() && 
                    bhol708a().commarea().dadosOutput().vho00101().iClszTtr1Cont().isEqual(CON_EMPRESA)) {
                    m2175ValNatJurExc() ;
                }
                log(TraceLevel.Debug, "   EMPRESA NATUREZA JURIDICA DE EXCECAO (S/N)");
                log(TraceLevel.Debug, "    IND INDIVID RESPONS LDA : ", hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo08());
                log(TraceLevel.Debug, "    IND PESSOA COLETIVA SOC : ", hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo09());
                if (envOut.errosGraves().semErros().isTrue() && 
                    (hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo08().isEqual(CON_SIM) || 
                    hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo09().isEqual(CON_SIM))) {
                    log(TraceLevel.Error, "  ---EMPRESA DE NATUREZA JURIDICA DE EXCECAO");
                    m2110AcumItvtOpe() ;
                    if (envOut.errosGraves().semErros().isTrue()) {
                        m2180ValMontsDEmpExc() ;
                    }
                }
                if (envOut.errosGraves().semErros().isTrue() && 
                    hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo08().isEqual(CON_NAO) && 
                    hrMhgj030a().bhgl030a().commarea().dadosEntradaSaida().xCteuCo09().isEqual(CON_NAO)) {
                    log(TraceLevel.Error, "  ---EMPRESA DE NATUREZA JURIDICA NORMAL");
                    m2110AcumItvtOpe() ;
                    if (envOut.errosGraves().semErros().isTrue()) {
                        m2190ValMontsDEmpNor() ;
                    }
                }
            }
        } else if (swSwitchs().swDepositoExpresso24h().isTrue()) {
            log(TraceLevel.Debug, "--- E - SW-DEPOSITO-EXPRESSO-24H");
            /**
             * DE ACORDO COM A DCO (LUIS SOUSA), DEP EXPRESSO 24H PASSA A
             * CONTAR COMO SE FOSSE UM "MANDATARIO", APENAS VALIDA A ENTREGA.
             * PERFORM 2120-ACUM-CONTA
             * THRU 2120-ACUM-CONTA-EXIT
             */
            if (envOut.errosGraves().semErros().isTrue()) {
                m2195ValMontsDepExp24() ;
            }
        }
    }
    
    /**
     * 
     * 2105-VAL-DOC-DSZD
     * 
     */
    protected void m2105ValDocDszd() {
        log(TraceLevel.Debug, "   2105-VAL-DOC-DSZD");
        log(TraceLevel.Debug, "   SW-CLIENTE-EMP-MAND         : ", swSwitchs().swClienteEmpMand());
        log(TraceLevel.Debug, "BGHM1130-I-CLI-CGD:", msgIn().msg().ade().iCliCgd());
        /**
         * MOVE CON-1N                TO WS-INDOC
         * *GH2024--> INICIO
         */
        if (swSwitchs().swCliEmpMandN().isTrue()) {
            /**
             * PERFORM UNTIL WS-INDOC > CON-250N
             * OR WS-TAB-Z-VLDE-DOC(WS-INDOC) EQUAL SPACES
             * OR WS-TD-C-CODIGO-DOC(WS-INDOC) EQUAL SPACES
             * OR BGHM1131-I-DOC-DSZD EQUAL CON-SIM
             */
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                /**
                 * IF BGHM1130-Z-VLDE-DOC-ID < BHTL001A-Z-PRCT-JOUR-BBN
                 * DISPLAY 'PARAGRAFO 2105-1'
                 * DISPLAY 'BGHM1131-I-DOC-DSZD:' BGHM1131-I-DOC-DSZD
                 */
                if (msgOut().msg().ade().zVldeDocIdPrin().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
                    msgOut().msg().ade().iDocDszd().set(CON_SIM);
                    log(TraceLevel.Error, "BGHM1131-I-DOC-DSZD:", msgOut().msg().ade().iDocDszd());
                    if (!swSwitchs().swEntrega().isTrue()) {
                        msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                    }
                } else {
                    msgOut().msg().ade().iDocDszd().set(CON_NAO);
                }
            }
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                /**
                 * *GH2024--> INICIO
                 * IF  BGHM1130-Z-VLDE-DOC-ID NOT EQUAL CON-DATA-MIN
                 * AND BGHM1130-Z-VLDE-DOC-ID < BHTL001A-Z-PRCT-JOUR-BBN
                 * *GH2161
                 * DISPLAY 'PARAGRAFO 2105-2'
                 * DISPLAY 'BGHM1131-I-DOC-DSZD:' BGHM1131-I-DOC-DSZD
                 */
                if (!msgIn().msg().ade().zVldeDocId().isEqual(CON_DATA_MIN) && 
                    msgIn().msg().ade().zVldeDocId().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
                    /**
                     * *GH2161
                     * IF  WS-TAB-Z-VLDE-DOC(WS-INDOC)
                     * NOT EQUAL CON-DATA-MIN
                     * AND WS-TAB-Z-VLDE-DOC(WS-INDOC)
                     * < BHTL001A-Z-PRCT-JOUR-BBN
                     * *GH2024--> FIM
                     */
                    msgOut().msg().ade().iDocDszd().set(CON_SIM);
                    /**
                     * DISPLAY 'PARAGRAFO 2105-2'
                     * DISPLAY 'BGHM1131-I-DOC-DSZD:' BGHM1131-I-DOC-DSZD
                     * IF SW-DEBUG-SIM
                     * DISPLAY WS-PARAG
                     * DISPLAY 'CLIENTE NAO CGD'
                     * DISPLAY 'WS-INDOC:' WS-INDOC
                     * DISPLAY 'WS-TAB-Z-VLDE-DOC(WS-INDOC):'
                     * WS-TAB-Z-VLDE-DOC(WS-INDOC)
                     * DISPLAY 'WS-TD-C-CODIGO-DOC(WS-IND):'
                     * WS-TD-C-CODIGO-DOC(WS-IND)
                     * END-IF
                     */
                    if (!swSwitchs().swEntrega().isTrue()) {
                        msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                    }
                } else {
                    msgOut().msg().ade().iDocDszd().set(CON_NAO);
                }
            }
        } else {
            /**
             * *GH2161
             * ADD CON-1N              TO WS-INDOC
             * END-PERFORM
             * DISPLAY 'SAI PERFORM'
             * IF SW-DEBUG-SIM
             * DISPLAY 'BGHM1130-I-CLI-CGD:'
             * BGHM1130-I-CLI-CGD
             * DISPLAY 'BGHM1131-Z-VLDE-DOC-ID-PRIN:'
             * BGHM1131-Z-VLDE-DOC-ID-PRIN
             * DISPLAY 'BHTL001A-Z-PRCT-JOUR-BBN:'
             * BHTL001A-Z-PRCT-JOUR-BBN
             * END-IF
             */
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                /**
                 * DISPLAY 'PARAGRAFO 2105-3'
                 * DISPLAY 'BGHM1131-I-DOC-DSZD:' BGHM1131-I-DOC-DSZD
                 */
                if (msgOut().msg().ade().zVldeDocIdPrin().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
                    msgOut().msg().ade().iDocDszd().set(CON_SIM);
                    /**
                     * DISPLAY 'PARAGRAFO 2105-3'
                     * DISPLAY 'BGHM1131-I-DOC-DSZD:' BGHM1131-I-DOC-DSZD
                     */
                    if (!swSwitchs().swEntrega().isTrue()) {
                        msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                    }
                } else {
                    msgOut().msg().ade().iDocDszd().set(CON_NAO);
                }
            }
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                /**
                 * IF SW-DEBUG-SIM
                 * DISPLAY 'BGHM1130-I-CLI-CGD:'
                 * BGHM1130-I-CLI-CGD
                 * DISPLAY 'BGHM1131-Z-VLDE-DOC-ID-PRIN:'
                 * BGHM1131-Z-VLDE-DOC-ID-PRIN
                 * DISPLAY 'BHTL001A-Z-PRCT-JOUR-BBN:'
                 * BHTL001A-Z-PRCT-JOUR-BBN
                 * END-IF
                 * DISPLAY 'PARAGRAFO 2105-4'
                 * DISPLAY 'BGHM1131-I-DOC-DSZD:' BGHM1131-I-DOC-DSZD
                 */
                if (!msgIn().msg().ade().zVldeDocId().isEqual(CON_DATA_MIN) && 
                    msgIn().msg().ade().zVldeDocId().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
                    msgOut().msg().ade().iDocDszd().set(CON_SIM);
                    /**
                     * DISPLAY 'PARAGRAFO 2105-4'
                     * DISPLAY 'BGHM1131-I-DOC-DSZD:' BGHM1131-I-DOC-DSZD
                     */
                    if (!swSwitchs().swEntrega().isTrue()) {
                        msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                    }
                } else {
                    msgOut().msg().ade().iDocDszd().set(CON_NAO);
                }
            }
        }
    }
    
    /**
     * 
     * 2110-ACUM-ITVT-OPE
     * 
     */
    protected void m2110AcumItvtOpe() {
        log(TraceLevel.Debug, "   2110-ACUM-ITVT-OPE");
        log(TraceLevel.Debug, "   SW-C-TIPO-MOV-SCTA    : ", swSwitchs().swCTipoMovScta());
        hv13001Movdep().movdep().initialize() ;
        wsTempo().wsMtItvtOpe().initialize() ;
        if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
            /**
             * -- USAMOS O DOCUMENTO PRINCIPAL DO CLIENTE CGD PARA FAZERMOS
             * A VALIDACAO SEMPRE COM O MESMO DOCUMENTO
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmDocPrin());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdPrin());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocIdPrin());
        } else {
            /**
             * -- USAMOS O DOCUMENTO APRESENTADO QUANDO CLIENTE NAO CGD
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocId());
        }
        hv13001Movdep().movdep().zMovimento().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        if (swSwitchs().swEntrega().isTrue()) {
            hv13001Movdep().movdep().iDbcr().set(CON_CREDITO);
        } else if (swSwitchs().swLevantamento().isTrue() || swSwitchs().swLiquidacaoConta().isTrue() || 
            swSwitchs().swPagChqCtaHvl7().isTrue() || 
            swSwitchs().swPagChqOicHbf0().isTrue() || 
            swSwitchs().swPagChqHve5Hvl3().isTrue() || 
            swSwitchs().swPagChqVisadoHvb2().isTrue()) {
            hv13001Movdep().movdep().iDbcr().set(CON_DEBITO);
        }
        log(TraceLevel.Debug, "   VGH13001-I-DBCR       : ", hv13001Movdep().movdep().iDbcr());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-99: ", wsTempo().wsMtItvtOpe());
        hv13001Movdep().movdep().iEstorno().set(CON_NAO);
        log(TraceLevel.Debug, "BGHM1130-C-PAIS-EM-DOC-PRIN:", msgIn().msg().ade().cPaisEmDocPrin());
        log(TraceLevel.Debug, "BGHM1130-C-TIPO-DOC-ID-PRIN:", msgIn().msg().ade().cTipoDocIdPrin());
        log(TraceLevel.Debug, "BGHM1130-N-DOC-ID-PRIN:", msgIn().msg().ade().nDocIdPrin());
        log(TraceLevel.Debug, "BGHM1130-C-PAIS-ISA-EMS-DOC:", msgIn().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "BGHM1130-C-TIPO-DOC-ID:", msgIn().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "BGHM1130-N-DOC-ID:", msgIn().msg().ade().nDocId());
        log(TraceLevel.Debug, "BGHM1130-I-CLI-CGD:", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "BGHM1130-N-CLIENTE:", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "VGH13001-C-PAIS-ISA-EMS-DOC:", hv13001Movdep().movdep().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "VGH13001-C-TIPO-DOC-ID:", hv13001Movdep().movdep().cTipoDocId());
        log(TraceLevel.Debug, "VGH13001-N-DOC-ID:", hv13001Movdep().movdep().nDocId());
        log(TraceLevel.Debug, "VGH13001-Z-MOVIMENTO:", hv13001Movdep().movdep().zMovimento());
        log(TraceLevel.Debug, "VGH13001-I-DBCR:", hv13001Movdep().movdep().iDbcr());
        log(TraceLevel.Debug, "VGH13001-I-ESTORNO:", hv13001Movdep().movdep().iEstorno());
        log(TraceLevel.Debug, "VGH13001-M-MOV-EURO:", hv13001Movdep().movdep().mMovEuro());
        log(TraceLevel.Debug, "WS-MT-ITVT-OPE:", wsTempo().wsMtItvtOpe());
        log(TraceLevel.Debug, "WS-ST-NULL:", wsTempo().wsStNull());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH13001_MOVDEP
         */
        hv13001Movdep().selectPghs133a3622(wsTempo().wsMtItvtOpe()) ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (swSwitchs().swVgh13001Ok().isTrue()) {
            if (wsTempo().wsStNull().isLess(0)) {
                wsTempo().wsMtItvtOpe().set(0);
            }
            log(TraceLevel.Error, "WS-MT-ITVT-OPE-01:", wsTempo().wsMtItvtOpe());
            log(TraceLevel.Error, "WS-ST-NULL:", wsTempo().wsStNull());
        } else {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
        }
    }
    
    /**
     * 
     * 2120-ACUM-CONTA
     * 
     */
    protected void m2120AcumConta() {
        log(TraceLevel.Debug, "   2120-ACUM-CONTA");
        hv13001Movdep().movdep().initialize() ;
        hv13001Movdep().movdep().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv13001Movdep().movdep().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv13001Movdep().movdep().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv13001Movdep().movdep().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv13001Movdep().movdep().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv13001Movdep().movdep().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv13001Movdep().movdep().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv13001Movdep().movdep().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        hv13001Movdep().movdep().zMovimento().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        if (swSwitchs().swEntrega().isTrue()) {
            hv13001Movdep().movdep().iDbcr().set(CON_CREDITO);
        } else if (swSwitchs().swLevantamento().isTrue() || swSwitchs().swLiquidacaoConta().isTrue() || 
            swSwitchs().swPagChqCtaHvl7().isTrue() || 
            swSwitchs().swPagChqOicHbf0().isTrue() || 
            swSwitchs().swPagChqHve5Hvl3().isTrue() || 
            swSwitchs().swPagChqVisadoHvb2().isTrue()) {
            hv13001Movdep().movdep().iDbcr().set(CON_DEBITO);
        }
        log(TraceLevel.Debug, "   VGH13001-I-DBCR       : ", hv13001Movdep().movdep().iDbcr());
        log(TraceLevel.Debug, " WS-MT-CONTA  : ", wsTempo().wsMtConta());
        hv13001Movdep().movdep().iEstorno().set(CON_NAO);
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH13001_MOVDEP
         */
        hv13001Movdep().selectPghs133a3701(wsTempo().wsMtConta()) ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (swSwitchs().swVgh13001Ok().isTrue()) {
            if (wsTempo().wsStNull().isLess(0)) {
                wsTempo().wsMtConta().set(0);
            }
        } else {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
        }
    }
    
    /**
     * 
     * 2130-VALIDA-MONTS-A
     * 
     */
    protected void m2130ValidaMontsA() {
        log(TraceLevel.Debug, "   2130-VALIDA-MONTS-A");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-CONTA        : ", wsTempo().wsMtConta());
        log(TraceLevel.Debug, "WS-MT-ITVT-OPE-02:", wsTempo().wsMtItvtOpe());
        /**
         * -- ENTREGA
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriPp())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- MONT-ENTREGA >= ", bghk0005().limitesMontanteNum().etgNmriPp(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * -- SE A ENTREGA FOR 15000 E SE A CONTA OU DEPO FOREM ZERO TB
         * ATIVAM A FLAG DE PEDIDO DE JUSTIFICACAO
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_ENTREGA)) {
            /**
             * -- CONTA
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtConta()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-CONTA: ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdCtaPp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_CNT_ATING);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- MONT CTA+NMRI >= ", bghk0005().limitesMontanteNum().acmdCtaPp(), " : ", wsTempo().wsMontTotal());
            }
            /**
             * -- DEPOSITANTE
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-DEPO : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepPp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO - MONT DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepPp(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2140-OBTM-INTVT
     * 
     */
    protected void m2140ObtmIntvt() {
        log(TraceLevel.Debug, "   2140-OBTM-INTVT");
        m1541AcessoMhjj249a() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            wsTempo().wsInd().set(CON_1N);
            swSwitchs().swCodIntervencao().set(0);
            while (wsTempo().wsInd().isLessOrEqual(bhjl249a().commarea().qOccursOut()) && envOut.errosGraves().semErros().isTrue() && !swSwitchs().swCliAltoRisco().isTrue()) {
                swSwitchs().swCodIntervencao().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).iTipoItvt());
                log(TraceLevel.Debug, "   SW-COD-INTERVENCAO      : ", swSwitchs().swCodIntervencao());
                log(TraceLevel.Debug, "    BHJL249A-Z-INIC-REL    : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).zInicRel());
                log(TraceLevel.Debug, "    BHJL249A-Z-FIM-REL     : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).zFimRel());
                if (swSwitchs().swItvtTitular().isTrue() || swSwitchs().swItvtAutorizado().isTrue()) {
                    m2141ObtemFiltering() ;
                }
                wsTempo().wsInd().add(CON_1N);
            }
        }
    }
    
    /**
     * 
     * 2141-OBTEM-FILTERING
     * 
     */
    protected void m2141ObtemFiltering() {
        log(TraceLevel.Debug, "    2141-OBTEM-FILTERING");
        log(TraceLevel.Debug, "   BHJL249A-N-CLIENTE  : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nCliente());
        log(TraceLevel.Debug, "   BHJL249A-NS-ABRA-CLI: ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsAbraCli());
        bhjl470a().commarea().initialize() ;
        bhjl470a().commarea().dadosInput().visualizacao().setTrue() ;
        bhjl470a().commarea().dadosInOut().nCliente().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nCliente());
        bhjl470a().commarea().dadosInOut().nsAbraCli().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsAbraCli());
        bhjp5470AcedeMhjj470a() ;
        if (!bhjl470a().commarea().erros().fimConsulta().isTrue() && !bhjl470a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl470a().commarea().erros().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl470a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl470a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl470a().commarea().erros().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-34");
        }
        /**
         * *-- PARA OS CLIENTES DE RISCO MEDIO SAO APLICADOS OS PROCEDIMENTOS
         * DEFINIDOS PARA OS CLIENTES DE RISCO BAIXO.
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (bhjl470a().commarea().dadosInOut().cPAlto().isTrue()) {
                swSwitchs().swCliAltoRisco().setTrue() ;
            }
        }
        log(TraceLevel.Debug, "   BHJL470A-N-CLIENTE         : ", bhjl470a().commarea().dadosInOut().nCliente());
        log(TraceLevel.Debug, "   BHJL470A-NS-ABRA-CLI       : ", bhjl470a().commarea().dadosInOut().nsAbraCli());
        log(TraceLevel.Debug, "   BHJL470A-C-PFI-RIS-BRQM-CAP: ", bhjl470a().commarea().dadosInOut().cPfiRisBrqmCap());
        log(TraceLevel.Debug, "   SW-RISCO-CLIENTE           : ", swSwitchs().swRiscoCliente());
    }
    
    /**
     * 
     * 2150-VALIDA-MONTS-B
     * 
     */
    protected void m2150ValidaMontsB() {
        log(TraceLevel.Debug, "   2150-VALIDA-MONTS-B");
        log(TraceLevel.Debug, "   SW-RISCO-CLIENTE   : ", swSwitchs().swRiscoCliente());
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-03:", wsTempo().wsMtItvtOpe());
        /**
         * -- ENTREGA
         */
        if (swSwitchs().swCliAltoRisco().isTrue()) {
            if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriTpRisc())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
                log(TraceLevel.Debug, "    ATENCAO -- MONT-ETG RISC>= ", bghk0005().limitesMontanteNum().etgNmriTpRisc(), " : ", msgIn().msg().ade().mMovNmri());
            }
        } else if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriTp())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- MONT-ENTREGA >= ", bghk0005().limitesMontanteNum().etgNmriTp(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * -- SE A ENTREGA ATINGE LIMITE OS RESTANTES LIMITES JA NAO
         * IMPORTAM.
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_ENTREGA)) {
            /**
             * ----- DEPOSITANTE
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-DEPO : ", wsTempo().wsMontTotal());
            if (swSwitchs().swCliAltoRisco().isTrue()) {
                if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepTpRisc())) {
                    msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                    msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                    msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                    msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                    log(TraceLevel.Debug, "    ATENCAO -- CLI-ALTO-RISCO  ");
                    log(TraceLevel.Debug, "    DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepTpRisc(), " : ", wsTempo().wsMontTotal());
                }
            } else if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepTp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- CLI-BAIXO/MEDIO-RISCO  ");
                log(TraceLevel.Debug, "    DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepTp(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2160-VALIDA-MONTS-C-PROP
     * 
     */
    protected void m2160ValidaMontsCProp() {
        log(TraceLevel.Debug, "   2160-VALIDA-MONTS-C-PROP");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-CONTA        : ", wsTempo().wsMtConta());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-04:", wsTempo().wsMtItvtOpe());
        /**
         * -- ENTREGA
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriPe())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- MONT-ENTREGA  >= ", bghk0005().limitesMontanteNum().etgNmriPe(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * -- SE A ENTREGA FOR 15000 E SE A CONTA OU DEPO FOREM ZERO TB
         * ATIVAM A FLAG DE PEDIDO DE JUSTIFICACAO
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_ENTREGA)) {
            /**
             * -- CONTA
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtConta()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-CONTA: ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdCtaPe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_CNT_ATING);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- MONT CTA+NMRI >= ", bghk0005().limitesMontanteNum().acmdCtaPe(), " : ", wsTempo().wsMontTotal());
            }
            /**
             * -- DEPOSITANTE
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-DEPO : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepPe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- MONT DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepPe(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2169-VAL-MONTS-D-EMP-RISC
     * 
     */
    protected void m2170ValMontsDEmpRisc() {
        log(TraceLevel.Debug, "   2170-VAL-MONTS-D-EMP-RISC");
        log(TraceLevel.Debug, "   SW-RISCO-CLIENTE   : ", swSwitchs().swRiscoCliente());
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-05:", wsTempo().wsMtItvtOpe());
        /**
         * -- ENTREGA
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriTeRisc())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- MONT-ETG RISC>= ", bghk0005().limitesMontanteNum().etgNmriTeRisc(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * -- SE A ENTREGA ATINGE LIMITE OS RESTANTES LIMITES JA NAO
         * IMPORTAM.
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_ENTREGA)) {
            /**
             * ----- DEPOSITANTE
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-DEPO : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepTeRisc())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- CLI-ALTO-RISCO");
                log(TraceLevel.Debug, "    DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepTeRisc(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2175-VAL-NAT-JUR-EXC
     * ACESSO A MHGJ030A VALIDAR SE A NATUREZA JURIDICA E DE EXCECAO
     * 
     */
    protected void m2175ValNatJurExc() {
        log(TraceLevel.Debug, "   2175-VAL-NAT-JUR-EXC");
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().cMnemEmpGcx().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cPaisIsoAlfn().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cTabBbn().set(CON_REGMJRDC_879);
        hrMhgj030a().bhgl030a().commarea().dadosInput().cCodigo().set(bhol708a().commarea().dadosOutput().vho00101().cSectIttlBpor());
        hrMhgj030a().bhgl030a().commarea().dadosInput().cIdioIso().set(bhok0002().BHOK0002_IDIOMA_PORTUGAL);
        hrMhgj030a().bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        hrMhgj030a().bhgl030a().commarea().dadosInput().conteudos().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (!hrMhgj030a().bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().cSqlcode());
            envOut.db2Log().nmTabela().set(hrMhgj030a().bhgl030a().commarea().dadosOutput().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-35");
        }
    }
    
    /**
     * 
     * 2180-VAL-MONTS-D-EMP-EXC
     * 
     */
    protected void m2180ValMontsDEmpExc() {
        log(TraceLevel.Debug, "   2180-VAL-MONTS-D-EMP-EXC");
        log(TraceLevel.Debug, "   SW-RISCO-CLIENTE   : ", swSwitchs().swRiscoCliente());
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-06:", wsTempo().wsMtItvtOpe());
        /**
         * -- ENTREGA
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriTeExc())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- CLI-BAIXO/MEDIO-RISCO");
            log(TraceLevel.Debug, "    MONT-ENTREGA >= ", bghk0005().limitesMontanteNum().etgNmriTeExc(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * -- SE A ENTREGA FOR 15000 E SE A CONTA OU DEPO FOREM ZERO TB
         * ATIVAM A FLAG DE PEDIDO DE JUSTIFICACAO
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_ENTREGA)) {
            /**
             * -- DEPOSITANTE
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-DEPO : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepTeExc())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- CLI-BAIXO/MEDIO-RISCO");
                log(TraceLevel.Debug, "    DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepTeExc(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2190-VAL-MONTS-D-EMP-NOR
     * 
     */
    protected void m2190ValMontsDEmpNor() {
        log(TraceLevel.Debug, "   2190-VAL-MONTS-D-EMP-NOR");
        log(TraceLevel.Debug, "   SW-RISCO-CLIENTE   : ", swSwitchs().swRiscoCliente());
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-07:", wsTempo().wsMtItvtOpe());
        /**
         * -- ENTREGA
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriTe())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- MONT-ENTREGA >= ", bghk0005().limitesMontanteNum().etgNmriTe(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * -- SE A ENTREGA ATINGE LIMITE OS RESTANTES LIMITES JA NAO
         * IMPORTAM.
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_ENTREGA)) {
            /**
             * -- DEPOSITANTE
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-DEPO : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepTe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- CLI-BAIXO/MEDIO-RISCO");
                log(TraceLevel.Debug, "    DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepTe(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2195-VAL-MONTS-DEP-EXP24
     * 
     */
    protected void m2195ValMontsDepExp24() {
        log(TraceLevel.Debug, "   2195-VAL-MONTS-DEP-EXP24");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-CONTA        : ", wsTempo().wsMtConta());
        /**
         * -- ENTREGA
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmri24())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- MONT-ENTREGA >= ", bghk0005().limitesMontanteNum().etgNmri24(), " : ", msgIn().msg().ade().mMovNmri());
        }
    }
    
    /**
     * 
     * 2200-APURA-1TITULAR-CTA
     * 
     */
    protected void m2200Apura1titularCta() {
        log(TraceLevel.Debug, "  2200-APURA-1TITULAR-CTA");
        log(TraceLevel.Debug, "   WS-N-CLIENTE-1T   : ", wsTempo().wsNCliente1t());
        log(TraceLevel.Debug, "   WS-NS-ABRA-CLI-1T : ", wsTempo().wsNsAbraCli1t());
        log(TraceLevel.Debug, "   BGHM1130-I-CLI-CGD: ", msgIn().msg().ade().iCliCgd());
        if (wsTempo().wsNCliente1t().isEqual(0) && 
            wsTempo().wsNsAbraCli1t().isEqual(0)) {
            m2210ObtemCliCnt1tit() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            wsTempo().wsNCliente().set(wsTempo().wsNCliente1t());
            wsTempo().wsNsAbraCli().set(wsTempo().wsNsAbraCli1t());
            m2220ObtemDdDoc1tit() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            wsTempo().wsBhjl006aNCliente().set(wsTempo().wsNCliente1t());
            m1320ObtemNomeCli() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            msgIn().msg().ade().nmClienteT().set(bhjl006a().commarea().dadosSaida().nmCliente());
            msgOut().msg().ade().nmClienteT().set(bhjl006a().commarea().dadosSaida().nmCliente());
        }
    }
    
    /**
     * 
     * 2210-OBTEM-CLI-CNT-1TIT
     * 
     */
    protected void m2210ObtemCliCnt1tit() {
        log(TraceLevel.Debug, "   2210-OBTEM-CLI-CNT-1TIT");
        bhjl249a().commarea().initialize() ;
        bhjl249a().commarea().dadosEntrada().titularL().setTrue() ;
        log(TraceLevel.Debug, "   BHJL249A-I-TIPO-ITVT-L : ", bhjl249a().commarea().dadosEntrada().iTipoItvtL());
        m1541AcessoMhjj249a() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            wsTempo().wsInd().set(CON_1N);
            log(TraceLevel.Debug, "   BHJL249A-I-TIPO-ITVT   : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).iTipoItvt());
            log(TraceLevel.Debug, "   BHJL249A-NS-TITC       : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsTitc());
            log(TraceLevel.Debug, "    BHJL249A-Z-INIC-REL    : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).zInicRel());
            log(TraceLevel.Debug, "    BHJL249A-Z-FIM-REL     : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).zFimRel());
            log(TraceLevel.Debug, "   BHJL249A-N-CLIENTE     : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nCliente());
            log(TraceLevel.Debug, "   BHJL249A-NS-ABRA-CLI   : ", bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsAbraCli());
            wsTempo().wsNCliente1t().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nCliente());
            wsTempo().wsNsAbraCli1t().set(bhjl249a().commarea().dadosSaida().get(wsTempo().wsInd()).nsAbraCli());
        }
    }
    
    /**
     * 
     * 2220-OBTEM-DD-DOC-1TIT
     * 
     */
    protected void m2220ObtemDdDoc1tit() {
        log(TraceLevel.Debug, "   2220-OBTEM-DD-DOC-1TIT");
        log(TraceLevel.Debug, "   WS-N-CLIENTE  : ", wsTempo().wsNCliente());
        log(TraceLevel.Debug, "   WS-NS-ABRA-CLI: ", wsTempo().wsNsAbraCli());
        bhjl707a().commarea().initialize() ;
        bhjl707a().commarea().dadosEntrada().nCliente().set(wsTempo().wsNCliente());
        bhjl707a().commarea().dadosEntrada().nsAbraCli().set(wsTempo().wsNsAbraCli());
        bhjp0707AcedeMhjj707a() ;
        if (bhjl707a().commarea().erros().semErros().isTrue() || bhjl707a().commarea().erros().fimConsulta().isTrue()) {
            msgIn().msg().ade().cPaisIsaEmsDocT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
            msgOut().msg().ade().cPaisIsaEmsDocT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
            msgIn().msg().ade().cTipoDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
            msgOut().msg().ade().cTipoDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
            msgIn().msg().ade().nDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
            msgOut().msg().ade().nDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
            if ((bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9901VITAL) || 
                bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9902VITAL) || 
                bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9903VITAL) || 
                bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9901VTSSO2) || 
                bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9902VTSSO2) || 
                bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9903VTSSO2)) && 
                wsTempo().wsZVldeDocIdAux().isEqual(CON_DATA_MAX)) {
                msgIn().msg().ade().zVldeDocIdT().set(CON_DATA_MAX_VIT);
                msgOut().msg().ade().zVldeDocIdT().set(CON_DATA_MAX_VIT);
            } else {
                msgIn().msg().ade().zVldeDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                msgOut().msg().ade().zVldeDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
            }
            msgIn().msg().ade().cEntEmixDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
            msgOut().msg().ade().cEntEmixDocIdT().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
            log(TraceLevel.Debug, "BHJL707A-C-PAIS-ISA-EMS-DOC(CON-1N):", bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
            log(TraceLevel.Debug, "BHJL707A-C-TIPO-DOC-ID(CON-1N):", bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
            log(TraceLevel.Debug, "BHJL707A-N-DOC-ID(CON-1N):", bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
            log(TraceLevel.Debug, "BHJL707A-Z-VLDE-DOC-ID(CON-1N):", bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
            log(TraceLevel.Debug, "BHJL707A-C-ENT-EMIX-DOC-ID(CON-1N):", bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
        } else {
            envOut.errosGraves().aAplErr().set(bhjl707a().commarea().erros().aAplErr());
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl707a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl707a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl707a().commarea().erros().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "ERRO-36");
        }
    }
    
    /**
     * 
     * 2300-CANAL-ATS
     * 
     */
    protected void m2300CanalAts() {
        log(TraceLevel.Debug, "  2300-CANAL-ATS");
        log(TraceLevel.Debug, "   SW-CLIENTE-EMP-MAND : ", swSwitchs().swClienteEmpMand());
        /**
         * *GH2024--> INICIO
         */
        if (!msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO_24H)) {
            m2105ValDocDszd() ;
        }
        /**
         * *GH2024--> FIM
         */
        if (envOut.errosGraves().semErros().isTrue() && swSwitchs().swCliEmpMandN().isTrue()) {
            m2110AcumItvtOpe() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && swSwitchs().swCliEmpMandN().isTrue()) {
            m2120AcumConta() ;
        }
        if (swSwitchs().swEntrega().isTrue() || swSwitchs().swEntregaNAlnova().isTrue()) {
            if (envOut.errosGraves().semErros().isTrue()) {
                m2310ValidaMontsAts() ;
            }
        } else if (swSwitchs().swLevantamento().isTrue()) {
            if (envOut.errosGraves().semErros().isTrue()) {
                m2320ValMontsLevAts() ;
            }
        }
        log(TraceLevel.Debug, "BGHM1131-I-DOC-DSZD:", msgOut().msg().ade().iDocDszd());
        /**
         * NO AMBITO DO AVISO 5, VAMOS PASSAR A VALIDAR TODOS OS COMPROVA-
         * TIVOS. DEVERA SER CONSULTADA A CLIJG6
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (msgOut().msg().ade().iDocDszd().isEqual(CON_NAO) && 
                msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                m2330ValidaDocClijg6() ;
            }
        }
    }
    
    /**
     * 
     * 2310-VALIDA-MONTS-ATS
     * 
     */
    protected void m2310ValidaMontsAts() {
        log(TraceLevel.Debug, "   2310-VALIDA-MONTS-ATS");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-CONTA        : ", wsTempo().wsMtConta());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-08:", wsTempo().wsMtItvtOpe());
        /**
         * -- ENTREGA
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().etgNmriAts())) {
            msgIn().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgIn().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
            msgIn().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_ENTREGA);
            msgIn().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "    ATENCAO -- MONT-ENTREGA >= ", bghk0005().limitesMontanteNum().etgNmriAts(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * -- SE A ENTREGA FOR 15000 E SE A CONTA OU DEPO FOREM ZERO TB
         * ATIVAM A FLAG DE PEDIDO DE JUSTIFICACAO
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_ENTREGA)) {
            /**
             * -- CONTA
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtConta()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-CONTA: ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdCtaAts())) {
                msgIn().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgIn().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
                msgIn().msg().ade().cMtvoPedJstz().set(CON_ACUM_CNT_ATING);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_CNT_ATING);
                msgIn().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- MONT CTA+NMRI >= ", bghk0005().limitesMontanteNum().acmdCtaAts(), " : ", wsTempo().wsMontTotal());
            }
            /**
             * -- DEPOSITANTE
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-DEPO : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdDepAts())) {
                msgIn().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgIn().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
                msgIn().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACUM_DEP_ATING);
                msgIn().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO - MONT DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdDepAts(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2320-VAL-MONTS-LEV-ATS
     * 
     */
    protected void m2320ValMontsLevAts() {
        log(TraceLevel.Debug, "   2320-VAL-MONTS-LEV-ATS");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-CONTA        : ", wsTempo().wsMtConta());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-09:", wsTempo().wsMtItvtOpe());
        /**
         * -- LEVANTAMENTOS  ( SO PEMITE POR DIA ATE 400 EUROS )
         * IF BGHM1130-M-MOV-NMRI >= BGHK0005-ETG-NMRI-ATS
         * MOVE CON-SIM                 TO
         * BGHM1130-I-PED-JSTZ-ORM-FND
         * BGHM1131-I-PED-JSTZ-ORM-FND
         * BGHM1130-I-RCS-JSTZ-ORM-FND
         * BGHM1131-I-RCS-JSTZ-ORM-FND
         * MOVE CON-MONT-ENTREGA        TO BGHM1130-C-MTVO-PED-JSTZ
         * BGHM1131-C-MTVO-PED-JSTZ
         * MOVE BGHM1130-M-MOV-NMRI     TO BGHM1130-M-ACMD-ETGA
         * BGHM1131-M-ACMD-ETGA
         * IF SW-DEBUG-SIM
         * DISPLAY '    ATENCAO -- MONT-ENTREGA >= '
         * BGHK0005-ETG-NMRI-ATS
         * ' : ' BGHM1130-M-MOV-NMRI
         * END-IF
         * END-IF.
         * IF BGHM1131-C-MTVO-PED-JSTZ NOT EQUAL CON-MONT-ENTREGA
         * -- CONTA
         */
        wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtConta()));
        log(TraceLevel.Debug, "   WS-MONT-TOTAL-CONTA: ", wsTempo().wsMontTotal());
        if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdLevCtaAts())) {
            msgIn().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgIn().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
            msgIn().msg().ade().cMtvoPedJstz().set(CON_ACMD_LEV_CTA);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_LEV_CTA);
            msgIn().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
            msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
            log(TraceLevel.Debug, "    ATENCAO -- MONT CTA+NMRI >= ", bghk0005().limitesMontanteNum().acmdLevCtaAts(), " : ", wsTempo().wsMontTotal());
        }
        /**
         * -- INTERVENIENTE NA OPERACAO
         */
        wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
        log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT : ", wsTempo().wsMontTotal());
        if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvLevAts())) {
            msgIn().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgIn().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iRcsJstzOrmFnd().set(CON_SIM);
            msgIn().msg().ade().cMtvoPedJstz().set(CON_ACMD_ITV_LEV);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_ITV_LEV);
            msgIn().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
            msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
            log(TraceLevel.Debug, "    ATENCAO - MONT ITV LEV+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvLevAts(), " : ", wsTempo().wsMontTotal());
        }
    }
    
    /**
     * 
     * PASSIVAS 2972-INICIO
     * 2330-VALIDA-DOC-CLIJG6
     * 
     */
    protected void m2330ValidaDocClijg6() {
        log(TraceLevel.Debug, "   2330-VALIDA-DOC-CLIJG6");
        hoPhjs625a().msgIn().msg().ade().initialize() ;
        hoPhjs625a().msgIn().msg().ade().nCliente().set(msgIn().msg().ade().nCliente());
        hoPhjs625a().msgIn().msg().ade().nsAbraCli().set(msgIn().msg().ade().nsAbraCli());
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        hoPhjs625a().run() ;
        log(TraceLevel.Trace, "CICSCODE:", cicscode);
        log(TraceLevel.Trace, "BHTL001A-C-RTNO-EVEN-SWAL:", envOut.errosGraves().cRtnoEvenSwal());
        log(TraceLevel.Trace, "BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Trace, "BHTL001A-A-APL-ERR:", envOut.errosGraves().aAplErr());
        if (!cicscode.isEqual(0 /*NORMAL*/)) {
            envOut.errosGraves().aAplErr().set(bhjk0002().BHJK0002_APLICACAO_CLIENTES);
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendCics());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().pgmNotfnd());
        }
        if (!envOut.errosGraves().semErros().isTrue()) {
            if (envOut.errosGraves().fimConsulta().isTrue()) {
                envOut.errosGraves().semErros().setTrue() ;
                envOut.errosGraves().aAplErr().initialize() ;
                envOut.errosGraves().cTipoErroBbn().initialize() ;
                envOut.errosGraves().cRtnoEvenSwal().initialize() ;
            } else {
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(envOut.errosGraves().cRtnoEvenSwal());
            }
        }
        /**
         * -- POR CADA REGISTO DO CRS VERIFICA O QUE HJG6 RETORNOU
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            hoPhjs625a().msgOut().indice().set(CON_01);
            log(TraceLevel.Debug, "BGHM1131-I-DOC-DSZD:", msgOut().msg().ade().iDocDszd());
            log(TraceLevel.Debug, "BHJM1461-INDICE:", hoPhjs625a().msgOut().indice());
            while (!msgOut().msg().ade().iDocDszd().isEqual(CON_SIM) && !hoPhjs625a().msgOut().msg().ade().adeL().get(hoPhjs625a().msgOut().indice()).cTipoDocSpte().isEmpty() && hoPhjs625a().msgOut().indice().isLessOrEqual(CON_IND_CLIJG6)) {
                m2331DataClij6() ;
            }
        }
    }
    
    /**
     * 
     * 2331-DATA-CLIJ6
     * 
     */
    protected void m2331DataClij6() {
        log(TraceLevel.Debug, " 2331-DATA-CLIJ6");
        log(TraceLevel.Debug, "BHJM1461-INDICE:", hoPhjs625a().msgOut().indice());
        log(TraceLevel.Debug, "BHJM1461-C-TIPO-DOC-SPTE:", hoPhjs625a().msgOut().msg().ade().adeL().get(hoPhjs625a().msgOut().indice()).cTipoDocSpte());
        log(TraceLevel.Debug, "BHJM1461-I-ETGA-DOC:", hoPhjs625a().msgOut().msg().ade().adeL().get(hoPhjs625a().msgOut().indice()).iEtgaDoc());
        log(TraceLevel.Debug, "BHJM1461-Z-FIM-VLDE:", hoPhjs625a().msgOut().msg().ade().adeL().get(hoPhjs625a().msgOut().indice()).zFimVlde());
        log(TraceLevel.Debug, "BHTL001A-Z-PRCT-JOUR-BBN:", message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        /**
         * GH2161 - COMENTAR - INICIO
         * IF (BHJM1461-Z-FIM-VLDE(BHJM1461-INDICE)
         * NOT EQUAL CON-DATA-MIN)
         * AND (BHJM1461-Z-FIM-VLDE(BHJM1461-INDICE)
         * NOT EQUAL SPACES)
         * AND (BHJM1461-I-ETGA-DOC(BHJM1461-INDICE) EQUAL CON-SIM
         * OR BHJM1461-I-ETGA-DOC(BHJM1461-INDICE) EQUAL CON-NAO
         * OR BHJM1461-I-ETGA-DOC(BHJM1461-INDICE) EQUAL SPACES)
         * AND BHJM1461-Z-FIM-VLDE(BHJM1461-INDICE)
         * < BHTL001A-Z-PRCT-JOUR-BBN
         * GH2161 - COMENTAR - FIM
         */
        if (hoPhjs625a().msgOut().msg().ade().adeL().get(hoPhjs625a().msgOut().indice()).zFimVlde().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn()) || 
            !hoPhjs625a().msgOut().msg().ade().adeL().get(hoPhjs625a().msgOut().indice()).iEtgaDoc().isEqual(CON_SIM)) {
            msgOut().msg().ade().iDocDszd().set(CON_SIM);
        } else {
            msgOut().msg().ade().iDocDszd().set(CON_NAO);
        }
        hoPhjs625a().msgOut().indice().add(CON_01);
        log(TraceLevel.Debug, "BGHM1131-I-DOC-DSZD:", msgOut().msg().ade().iDocDszd());
        log(TraceLevel.Debug, "BHJM1461-INDICE:", hoPhjs625a().msgOut().indice());
    }
    
    /**
     * 
     * PASSIVAS 2972-FIM
     * 2400-INSERE-TGH130
     * 
     */
    protected void m2400InsereTgh130() {
        log(TraceLevel.Debug, "  2400-INSERE-TGH130");
        if (swSwitchs().swEntregaNAlnova().isTrue()) {
            m2405JournalNAlnova() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m2415FormataTgh130() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m2420InsertTgh130() ;
        }
    }
    
    /**
     * 
     * 2405-JOURNAL-N-ALNOVA
     * 
     */
    protected void m2405JournalNAlnova() {
        log(TraceLevel.Debug, "   2405-JOURNAL-N-ALNOVA");
        log(TraceLevel.Debug, "   SW-C-TIPO-MOV-SCTA      : ", swSwitchs().swCTipoMovScta());
        hrMjss130a().bjsl130a().commarea().initialize() ;
        hrMjss130a().bjsl130a().commarea().argumento().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hrMjss130a().bjsl130a().commarea().argumento().cBancCont().set(msgIn().msg().ade().cBancCont());
        hrMjss130a().bjsl130a().commarea().argumento().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hrMjss130a().bjsl130a().commarea().argumento().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hrMjss130a().bjsl130a().commarea().argumento().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hrMjss130a().bjsl130a().commarea().argumento().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        /**
         * TABELA TJS00605 TEM MOEDA A ESPACO.
         * MOVE BGHM1130-C-MOED-ISO-SCTA   TO MJS130A-C-MOED-ISO-SCTA
         */
        hrMjss130a().bjsl130a().commarea().argumento().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        /**
         * DADOS DE JOURNAL N-ALNOVA -- CAMPOS QUE FORAM RE-UTILIZADOS:
         * ALI-COD-TERMINAL(1:1)--> BGHM1130-C-FAMI-PROD
         * ALI-COD-TERMINAL(2:3)--> BGHM1130-C-PRODUTO
         */
        hrMjss130a().bjsl130a().commarea().argumento().cTerminal().get(1, 1).set(msgIn().msg().ade().cFamiProd().get(1, 1)) ;
        hrMjss130a().bjsl130a().commarea().argumento().cTerminal().get(2, 3).set(msgIn().msg().ade().cProduto()) ;
        hrMjss130a().bjsl130a().commarea().argumento().cMnemEgcOpex().set(msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        hrMjss130a().bjsl130a().commarea().argumento().cPaisIsoaOeOpx().set(msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        hrMjss130a().bjsl130a().commarea().argumento().cOeEgcOpex().set(msgIn().msg().ade().nrElectronico().cOeEgcOpex());
        /**
         * DADOS DE JOURNAL N-ALNOVA -- CAMPOS QUE FORAM RE-UTILIZADOS:
         * ALI-DAT-MOVIMENTO --> BGHM1130-Z-PROCESSAMENTO
         * ALI-DAT-TIMER     --> BGHM1130-N-JOUR-BBN
         */
        wsTsTransaccao().wsData().set(msgIn().msg().ade().nrElectronico().zProcessamento());
        wsTempoN6.set(msgIn().msg().ade().nrElectronico().nJourBbn());
        wsTempo().set(wsTempoN6);
        wsTsTransaccao().wsHora().set(wsTempo().wsHoraTempo());
        wsTsTransaccao().wsMinuntos().set(wsTempo().wsMinuntosTempo());
        wsTsTransaccao().wsSegundos().set(wsTempo().wsSegundosTempo());
        hrMjss130a().bjsl130a().commarea().argumento().tsTransaccao().set(wsTsTransaccao());
        hrMjss130a().bjsl130a().commarea().argumento().mMovimento().set(msgIn().msg().ade().mMovNmri());
        hrMjss130a().bjsl130a().commarea().argumento().cMoedIsoOriMov().set(CON_MOEDA_EURO);
        hrMjss130a().bjsl130a().commarea().argumento().nCheque().set(0);
        if (swSwitchs().swEntregaNAlnova().isTrue()) {
            hrMjss130a().bjsl130a().commarea().argumento().iDbcr().set(CON_CREDITO);
            msgIn().msg().ade().cTipoMovScta().set(CON_ENTREGA);
            msgOut().msg().ade().cTipoMovScta().set(CON_ENTREGA);
        }
        hrMjss130a().bjsl130a().commarea().argumento().cUserid().set(msgIn().msg().ade().nrElectronico().cUserid());
        hrMjss130a().run() ;
        if (hrMjss130a().bjsl130a().commarea().ok().isTrue()) {
            msgIn().msg().ade().nrElectronico().cUserid().set(" ");
            msgOut().msg().ade().nrElectronico().cUserid().set(" ");
            msgIn().msg().ade().nrElectronico().cUserid().set(hrMjss130a().bjsl130a().commarea().argumento().cTerminal());
            msgOut().msg().ade().nrElectronico().cUserid().set(hrMjss130a().bjsl130a().commarea().argumento().cTerminal());
            msgIn().msg().ade().nrElectronico().nJourBbn().set(hrMjss130a().bjsl130a().commarea().cDetalhe().nJourBbn());
            msgOut().msg().ade().nrElectronico().nJourBbn().set(hrMjss130a().bjsl130a().commarea().cDetalhe().nJourBbn());
            msgIn().msg().ade().cFamiProd().set(bhol708a().commarea().dadosOutput().vho00101().cFamiProd());
            msgOut().msg().ade().cFamiProd().set(bhol708a().commarea().dadosOutput().vho00101().cFamiProd());
            msgIn().msg().ade().cProduto().set(bhol710a().commarea().dadosOutput().innerStrct().cProduto());
            msgOut().msg().ade().cProduto().set(bhol710a().commarea().dadosOutput().innerStrct().cProduto());
        } else {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set("TJS00605");
            envOut.db2Log().sqlca().cSqlcode().set(hrMjss130a().bjsl130a().commarea().cSqlcode());
        }
    }
    
    /**
     * 
     * 2415-FORMATA-TGH130
     * 
     */
    protected void m2415FormataTgh130() {
        log(TraceLevel.Debug, "   2415-FORMATA-TGH130");
        log(TraceLevel.Debug, "   BGHM1130-Z-PROCESSAMENTO   : ", msgIn().msg().ade().nrElectronico().zProcessamento());
        log(TraceLevel.Debug, "   BGHM1130-C-MNEM-EGC-OPEX   : ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISOA-OE-OPX: ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1130-C-OE-EGC-OPEX     : ", msgIn().msg().ade().nrElectronico().cOeEgcOpex());
        log(TraceLevel.Debug, "   BGHM1130-C-USERID          : ", msgIn().msg().ade().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1130-N-JOUR-BBN        : ", msgIn().msg().ade().nrElectronico().nJourBbn());
        log(TraceLevel.Debug, "   BHTL001A-C-TIPO-CANL-ACES  : ", message.mensagem().headerR().transaccao().cTipoCanlAces());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-MOV-SCTA   : ", msgIn().msg().ade().cTipoMovScta());
        log(TraceLevel.Debug, "   BGHM1130-C-TIPO-ITVT-DEP   : ", msgIn().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "   BGHM1130-C-TIP-REL-DEP     : ", msgIn().msg().ade().cTipRelDep());
        log(TraceLevel.Debug, "   BGHM1130-X-INF-JSTZ-DEP    : ", msgIn().msg().ade().xInfJstzDep());
        hv13001Movdep().movdep().initialize() ;
        /**
         * -- CAMPOS DE JOURNAL
         */
        hv13001Movdep().movdep().zProcessamento().set(msgIn().msg().ade().nrElectronico().zProcessamento());
        hv13001Movdep().movdep().cMnemEgcOpex().set(msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        hv13001Movdep().movdep().cPaisIsoaOeOpx().set(msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        hv13001Movdep().movdep().cOeEgcOpex().set(msgIn().msg().ade().nrElectronico().cOeEgcOpex());
        hv13001Movdep().movdep().cUserid().set(msgIn().msg().ade().nrElectronico().cUserid());
        hv13001Movdep().movdep().nJourBbn().set(msgIn().msg().ade().nrElectronico().nJourBbn());
        /**
         * -- CAMPOS DA CONTA
         */
        hv13001Movdep().movdep().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaCont());
        hv13001Movdep().movdep().cBancCont().set(msgIn().msg().ade().cBancCont());
        hv13001Movdep().movdep().cOeEgcCont().set(msgIn().msg().ade().cOeEgcCont());
        hv13001Movdep().movdep().nsRdclCont().set(msgIn().msg().ade().nsRdclCont());
        hv13001Movdep().movdep().vChkdCont().set(msgIn().msg().ade().vChkdCont());
        hv13001Movdep().movdep().cTipoCont().set(msgIn().msg().ade().cTipoCont());
        hv13001Movdep().movdep().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoScta());
        hv13001Movdep().movdep().nsDeposito().set(msgIn().msg().ade().nsDeposito());
        /**
         * -- REFERENCIA SWIF
         */
        hv13001Movdep().movdep().cPaisIsoAlfn().set(" ");
        hv13001Movdep().movdep().cMnemEmpGcx().set(" ");
        hv13001Movdep().movdep().cRefMsgSwif().set(" ");
        hv13001Movdep().movdep().cEstMsgSwif().set(0);
        if (swSwitchs().swPagChqCtaHvl7().isTrue() || swSwitchs().swPagChqOicHbf0().isTrue() || 
            swSwitchs().swPagChqHve5Hvl3().isTrue() || 
            swSwitchs().swPagChqVisadoHvb2().isTrue() || 
            message.mensagem().headerR().transaccao().cTipoCanlAces().isEqual(CON_ATS)) {
            hv13001Movdep().movdep().nCheque().set(msgIn().msg().ade().nCheque());
        } else {
            hv13001Movdep().movdep().nCheque().set(0);
        }
        /**
         * -- DADOS DOCUMENTO CLIENTE - DOCUMENTO IDENTIFICACAO PRINCIPAL
         */
        if (msgIn().msg().ade().cPaisEmDocPrin().isEmpty() && 
            msgIn().msg().ade().cTipoDocIdPrin().isEmpty() && 
            msgIn().msg().ade().nDocIdPrin().isEmpty() && 
            (msgIn().msg().ade().zVldeDocIdPrin().isEqual(CON_DATA_MIN) || 
            msgIn().msg().ade().zVldeDocIdPrin().isEmpty()) && 
            msgIn().msg().ade().cEntEmiDocPrin().isEmpty()) {
            /**
             * SE CLIENTE NAO CGD, MOVE DOCUMENTO APRESENTADO
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocId());
            hv13001Movdep().movdep().zVldeDocId().set(msgIn().msg().ade().zVldeDocId());
            hv13001Movdep().movdep().cEntEmixDocId().set(msgIn().msg().ade().cEntEmixDocId());
        } else {
            /**
             * SE CLIENTE CGD, MOVE DOCUMENTO PRINCIPAL
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmDocPrin());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdPrin());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocIdPrin());
            hv13001Movdep().movdep().zVldeDocId().set(msgIn().msg().ade().zVldeDocIdPrin());
            hv13001Movdep().movdep().cEntEmixDocId().set(msgIn().msg().ade().cEntEmiDocPrin());
        }
        /**
         * -- DOCUMENTO DE IDENTIFICACAO APRESENTADO
         */
        hv13001Movdep().movdep().cPaisEmsDocApt().set(msgIn().msg().ade().cPaisIsaEmsDoc());
        hv13001Movdep().movdep().cTipoDocIdAptd().set(msgIn().msg().ade().cTipoDocId());
        hv13001Movdep().movdep().nDocIdAptd().set(msgIn().msg().ade().nDocId());
        hv13001Movdep().movdep().zVldeDocIdAptd().set(msgIn().msg().ade().zVldeDocId());
        hv13001Movdep().movdep().cEntEmiDidAptd().set(msgIn().msg().ade().cEntEmixDocId());
        hv13001Movdep().movdep().nmCliente().set(msgIn().msg().ade().nmCliente());
        hv13001Movdep().movdep().iCliCgd().set(msgIn().msg().ade().iCliCgd());
        hv13001Movdep().movdep().cTipoItvtDep().set(msgIn().msg().ade().cTipoItvtDep());
        hv13001Movdep().movdep().cTipoMdti().set(msgIn().msg().ade().cTipoMdti());
        /**
         * *GH1621 INI
         */
        if (swSwitchs().swCliEmpMandS().isTrue() && swSwitchs().swEntrega().isTrue()) {
            hv13001Movdep().movdep().cTipoItvtDep().set(CON_MANDATARIO);
            msgOut().msg().ade().cTipoItvtDep().set(CON_MANDATARIO);
            hv13001Movdep().movdep().cTipoMdti().set(CON_MANDATARIO_EMP_CARD);
            msgOut().msg().ade().cTipoMdti().set(CON_MANDATARIO_EMP_CARD);
        }
        /**
         * *GH1621 FIM
         */
        hv13001Movdep().movdep().zMovimento().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        /**
         * -- I-DBCR -- TIPO DE OPERACAO NA CONTA
         */
        if (swSwitchs().swEntrega().isTrue()) {
            hv13001Movdep().movdep().iDbcr().set(CON_CREDITO);
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_ENTREGA);
            msgOut().msg().ade().cTipoMovScta().set(CON_ENTREGA);
        } else if (swSwitchs().swLevantamento().isTrue() || swSwitchs().swLiquidacaoConta().isTrue() || 
            swSwitchs().swPagChqCtaHvl7().isTrue() || 
            swSwitchs().swPagChqOicHbf0().isTrue() || 
            swSwitchs().swPagChqHve5Hvl3().isTrue() || 
            swSwitchs().swPagChqVisadoHvb2().isTrue()) {
            hv13001Movdep().movdep().iDbcr().set(CON_DEBITO);
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_LEVANTAMENTO);
            msgOut().msg().ade().cTipoMovScta().set(CON_LEVANTAMENTO);
        }
        hv13001Movdep().movdep().mMovEuro().set(msgIn().msg().ade().mMovNmri());
        hv13001Movdep().movdep().cTipoCanlAces().set(message.mensagem().headerR().transaccao().cTipoCanlAces());
        hv13001Movdep().movdep().iTrnzEfcdOnln().set(message.mensagem().headerR().iTrnzEfcdOnln());
        hv13001Movdep().movdep().iPedJstzOrmFnd().set(msgIn().msg().ade().iPedJstzOrmFnd());
        hv13001Movdep().movdep().cMtvoPedJstz().set(msgIn().msg().ade().cMtvoPedJstz());
        hv13001Movdep().movdep().iRcsJstzOrmFnd().set(msgIn().msg().ade().iRcsJstzOrmFnd());
        hv13001Movdep().movdep().iEstorno().set(message.mensagem().headerR().iEstorno());
        /**
         * PASSIVAS 4497 (INICIO)
         */
        hv13001Movdep().movdep().cTipoRelDpst().set(msgIn().msg().ade().cTipRelDep());
        hv13001Movdep().movdep().xInfJstzDep().set(msgIn().msg().ade().xInfJstzDep());
        /**
         * PASSIVAS 4497 (FIM)
         */
        hv13001Movdep().movdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
    }
    
    /**
     * 
     * 2420-INSERT-TGH130
     * 
     */
    protected void m2420InsertTgh130() {
        log(TraceLevel.Debug, "   2420-INSERT-TGH130");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH13001_MOVDEP
         */
        hv13001Movdep().insertPghs133a5224() ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, "   ERRO NO INSERT TGH00130 - SQLCODE :", hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, "   CHAVE :", hv13001Movdep().movdep().zProcessamento(), "/", hv13001Movdep().movdep().cMnemEgcOpex(), "/", hv13001Movdep().movdep().cPaisIsoaOeOpx(), "/", hv13001Movdep().movdep().cOeEgcOpex(), "/", hv13001Movdep().movdep().cUserid(), "/", hv13001Movdep().movdep().nJourBbn(), "/", hv13001Movdep().movdep().cPaisIsoaCont(), "/", hv13001Movdep().movdep().cBancCont(), "/", hv13001Movdep().movdep().cOeEgcCont(), "/", hv13001Movdep().movdep().nsRdclCont(), "/", hv13001Movdep().movdep().vChkdCont(), "/", hv13001Movdep().movdep().cTipoCont(), "/", hv13001Movdep().movdep().cMoedIsoScta(), "/", hv13001Movdep().movdep().nsDeposito(), "/", hv13001Movdep().movdep().cPaisIsoAlfn(), "/", hv13001Movdep().movdep().cMnemEmpGcx(), "/", hv13001Movdep().movdep().cRefMsgSwif(), "/", hv13001Movdep().movdep().cEstMsgSwif(), "/", hv13001Movdep().movdep().nCheque(), "/", hv13001Movdep().movdep().cPaisIsaEmsDoc(), "/", hv13001Movdep().movdep().cTipoDocId(), "/", hv13001Movdep().movdep().nDocId(), "/", hv13001Movdep().movdep().zVldeDocId(), "/", hv13001Movdep().movdep().cEntEmixDocId(), "/", hv13001Movdep().movdep().cPaisEmsDocApt(), "/", hv13001Movdep().movdep().cTipoDocIdAptd(), "/", hv13001Movdep().movdep().nDocIdAptd(), "/", hv13001Movdep().movdep().zVldeDocIdAptd(), "/", hv13001Movdep().movdep().cEntEmiDidAptd(), "/", hv13001Movdep().movdep().nmCliente(), "/", hv13001Movdep().movdep().iCliCgd(), "/", hv13001Movdep().movdep().cTipoItvtDep(), "/", hv13001Movdep().movdep().cTipoMdti(), "/", hv13001Movdep().movdep().zMovimento(), "/", hv13001Movdep().movdep().iDbcr(), "/", hv13001Movdep().movdep().mMovEuro(), "/", hv13001Movdep().movdep().cTipoCanlAces(), "/", hv13001Movdep().movdep().cTipoOpeCont(), "/", hv13001Movdep().movdep().iTrnzEfcdOnln(), "/", hv13001Movdep().movdep().iPedJstzOrmFnd(), "/", hv13001Movdep().movdep().cMtvoPedJstz(), "/", hv13001Movdep().movdep().iRcsJstzOrmFnd(), "/", hv13001Movdep().movdep().iEstorno(), "/", hv13001Movdep().movdep().qMoeda(), "/", hv13001Movdep().movdep().cTipoRelDpst(), "/", hv13001Movdep().movdep().xInfJstzDep(), "/", "CURRENT_TIMESTAMP", "/", "CURRENT_TIMESTAMP", "/", hv13001Movdep().movdep().cUsidActzUlt(), " ");
        }
    }
    
    /**
     * 
     * 2500-ESTORNO
     * 
     */
    protected void m2500Estorno() {
        log(TraceLevel.Debug, "  2500-ESTORNO");
        log(TraceLevel.Debug, "   BHTL001A-I-ESTORNO          : ", message.mensagem().headerR().iEstorno());
        log(TraceLevel.Debug, "   BHTL001A-C-USERID           : ", message.mensagem().headerR().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1130-Z-PROCESSAMENTO    : ", msgIn().msg().ade().nrElectronico().zProcessamento());
        log(TraceLevel.Debug, "   BGHM1130-C-MNEM-EGC-OPEX    : ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1130-C-PAIS-ISOA-OE-OPX : ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1130-C-OE-EGC-OPEX      : ", msgIn().msg().ade().nrElectronico().cOeEgcOpex());
        log(TraceLevel.Debug, "   BGHM1130-C-USERID           : ", msgIn().msg().ade().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1130-N-JOUR-BBN         : ", msgIn().msg().ade().nrElectronico().nJourBbn());
        /**
         * *---
         */
        hv13001Movdep().movdep().iEstorno().set(message.mensagem().headerR().iEstorno());
        hv13001Movdep().movdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * *---
         */
        hv13001Movdep().movdep().zProcessamento().set(msgIn().msg().ade().nrElectronico().zProcessamento());
        hv13001Movdep().movdep().cMnemEgcOpex().set(msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        hv13001Movdep().movdep().cPaisIsoaOeOpx().set(msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        hv13001Movdep().movdep().cOeEgcOpex().set(msgIn().msg().ade().nrElectronico().cOeEgcOpex());
        hv13001Movdep().movdep().cUserid().set(msgIn().msg().ade().nrElectronico().cUserid());
        hv13001Movdep().movdep().nJourBbn().set(msgIn().msg().ade().nrElectronico().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH13001_MOVDEP
         */
        hv13001Movdep().updatePghs133a5438() ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, "   ERRO NO ESTORN TGH00130 - SQLCODE :", hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, "   CHAVE :", hv13001Movdep().movdep().zProcessamento(), "/", hv13001Movdep().movdep().cMnemEgcOpex(), "/", hv13001Movdep().movdep().cPaisIsoaOeOpx(), "/", hv13001Movdep().movdep().cOeEgcOpex(), "/", hv13001Movdep().movdep().cUserid(), "/", hv13001Movdep().movdep().nJourBbn());
        }
    }
    
    /**
     * 
     * 2600-BALC-LEV-PAG-CHQ
     * 
     */
    protected void m2600BalcLevPagChq() {
        log(TraceLevel.Debug, "  2600-BALC-LEV-PAG-CHQ");
        m2105ValDocDszd() ;
        if (swSwitchs().swPropLevParticular().isTrue() || swSwitchs().swPropPagChqParticular().isTrue()) {
            if (swSwitchs().swPropLevParticular().isTrue()) {
                log(TraceLevel.Debug, "--- A - SW-PROP-LEV-PARTICULAR");
            } else {
                log(TraceLevel.Debug, "--- A - SW-PROP-PAG-CHQ-PARTICULAR");
            }
            m2110AcumItvtOpe() ;
            if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swPagChqOicHbf0().isTrue() && 
                !swSwitchs().swPagChqHve5Hvl3().isTrue()) {
                m2120AcumConta() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m2610ValidaMontantesA() ;
            }
        } else if (swSwitchs().swBeneChqParticular().isTrue()) {
            log(TraceLevel.Debug, "--- B - SW-BENE-CHQ-PARTICULAR");
            m2110AcumItvtOpe() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                m2620ValidaMontantesB() ;
            }
        } else if (swSwitchs().swPropLevEmpresa().isTrue() || swSwitchs().swPropPagChqEmpresa().isTrue()) {
            if (swSwitchs().swPropLevEmpresa().isTrue()) {
                log(TraceLevel.Debug, "--- C - SW-PROP-LEV-EMPRESA");
            } else {
                log(TraceLevel.Debug, "--- C - SW-PROP-PAG-CHQ-EMPRESA");
            }
            m2110AcumItvtOpe() ;
            if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swPagChqOicHbf0().isTrue() && 
                !swSwitchs().swPagChqHve5Hvl3().isTrue()) {
                m2120AcumConta() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m2630ValidaMontantesC() ;
            }
        } else if (swSwitchs().swBeneChqEmpresa().isTrue()) {
            log(TraceLevel.Debug, "--- D - SW-BENE-CHQ-EMPRESA");
            m2110AcumItvtOpe() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                m2640ValidaMontantesD() ;
            }
        }
    }
    
    /**
     * 
     * 2610-VALIDA-MONTANTES-A
     * 
     */
    protected void m2610ValidaMontantesA() {
        log(TraceLevel.Debug, "   2610-VALIDA-MONTANTES-A");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-CONTA        : ", wsTempo().wsMtConta());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-10:", wsTempo().wsMtItvtOpe());
        /**
         * -- LEVANTAMENTO OU PAGAMENTO DE CHEQUE
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().levNmriPp())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_LEV_NMRI);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            if (swSwitchs().swPropLevParticular().isTrue()) {
                log(TraceLevel.Debug, "    ATENCAO -- MONT-LEVANT  >= ", bghk0005().limitesMontanteNum().levNmriPp(), " : ", msgIn().msg().ade().mMovNmri());
            } else {
                log(TraceLevel.Debug, "    ATENCAO -- MONT-PAG-CHQ >= ", bghk0005().limitesMontanteNum().levNmriPp(), " : ", msgIn().msg().ade().mMovNmri());
            }
        }
        /**
         * ----
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_LEV_NMRI)) {
            /**
             * -- CONTA
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtConta()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-CONTA: ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdLevCtaPp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_LEV_CTA);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- MONT CTA+NMRI >= ", bghk0005().limitesMontanteNum().acmdLevCtaPp(), " : ", wsTempo().wsMontTotal());
            }
            /**
             * -- INTERVENIENTE NA OPERACAO
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvLevPp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_ITV_LEV);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO - MONT ITVT LEV+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvLevPp(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2620-VALIDA-MONTANTES-B
     * 
     */
    protected void m2620ValidaMontantesB() {
        log(TraceLevel.Debug, "   2620-VALIDA-MONTANTES-B");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-11:", wsTempo().wsMtItvtOpe());
        /**
         * -- PAGAMENTO DE CHEQUE
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().chqNmriBp())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_CHQ_NMRI);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            }
            log(TraceLevel.Debug, "    ATENCAO -- MONT-PAG-CHQ >= ", bghk0005().limitesMontanteNum().chqNmriBp(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * ----
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_CHQ_NMRI)) {
            /**
             * -- INTERVENIENTE NA OPERACAO
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdChqBp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_BENE_CHQ);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                    msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                }
                log(TraceLevel.Debug, "    ATENCAO - MONT DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdChqBp(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2630-VALIDA-MONTANTES-C
     * 
     */
    protected void m2630ValidaMontantesC() {
        log(TraceLevel.Debug, "   2630-VALIDA-MONTANTES-C");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-CONTA        : ", wsTempo().wsMtConta());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-12:", wsTempo().wsMtItvtOpe());
        /**
         * -- LEVANTAMENTO OU PAGAMENTO DE CHEQUE
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().levNmriPe())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_LEV_NMRI);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            if (swSwitchs().swPropLevParticular().isTrue()) {
                log(TraceLevel.Debug, "    ATENCAO -- MONT-LEVANT  >= ", bghk0005().limitesMontanteNum().levNmriPe(), " : ", msgIn().msg().ade().mMovNmri());
            } else {
                log(TraceLevel.Debug, "    ATENCAO -- MONT-PAG-CHQ >= ", bghk0005().limitesMontanteNum().levNmriPe(), " : ", msgIn().msg().ade().mMovNmri());
            }
        }
        /**
         * ----
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_LEV_NMRI)) {
            /**
             * -- CONTA
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtConta()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-CONTA: ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdLevCtaPe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_LEV_CTA);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO -- MONT CTA+NMRI >= ", bghk0005().limitesMontanteNum().acmdLevCtaPe(), " : ", wsTempo().wsMontTotal());
            }
            /**
             * -- INTERVENIENTE NA OPERACAO
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvLevPe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_ITV_LEV);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                log(TraceLevel.Debug, "    ATENCAO - MONT ITVT LEV+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvLevPe(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 2640-VALIDA-MONTANTES-D
     * 
     */
    protected void m2640ValidaMontantesD() {
        log(TraceLevel.Debug, "   2640-VALIDA-MONTANTES-D");
        log(TraceLevel.Debug, "   BGHM1130-M-MOV-NMRI: ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, " WS-MT-ITVT-OPE-13:", wsTempo().wsMtItvtOpe());
        /**
         * -- PAGAMENTO DE CHEQUE
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().chqNmriBe())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_CHQ_NMRI);
            msgOut().msg().ade().mAcmdEtga().set(msgIn().msg().ade().mMovNmri());
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            }
            log(TraceLevel.Debug, "    ATENCAO -- MONT-PAG-CHQ >= ", bghk0005().limitesMontanteNum().chqNmriBe(), " : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * ----
         */
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_CHQ_NMRI)) {
            /**
             * -- INTERVENIENTE NA OPERACAO
             */
            wsTempo().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsTempo().wsMtItvtOpe()));
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT : ", wsTempo().wsMontTotal());
            if (wsTempo().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdChqBe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_ACMD_BENE_CHQ);
                msgOut().msg().ade().mAcmdEtga().set(wsTempo().wsMontTotal());
                if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                    msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                }
                log(TraceLevel.Debug, "    ATENCAO - MONT DEPOSIT+NMRI >= ", bghk0005().limitesMontanteNum().acmdChqBe(), " : ", wsTempo().wsMontTotal());
            }
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, " 3000-FIM-PROGRAMA");
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzNao().isTrue() && 
            message.mensagem().headerR().anulDiaNao().isTrue()) {
            m3010TrataJournal() ;
        }
        /**
         * PASSIVAS 2972->INICIO
         * *GH2161 - COMENTAR - INICIO
         * IF SW-DEBUG-SIM
         * DISPLAY 'BGHM1130-I-VALIDA-DOC-ID:'
         * BGHM1130-I-VALIDA-DOC-ID
         * DISPLAY 'BGHM1131-I-VALIDA-DOC-ID:'
         * BGHM1131-I-VALIDA-DOC-ID
         * DISPLAY 'BGHM1131-NM-CLIENTE:'
         * BGHM1131-NM-CLIENTE
         * DISPLAY 'BGHM1131-N-DOC-ID:'
         * BGHM1131-N-DOC-ID
         * DISPLAY 'BGHM1131-Z-VLDE-DOC-ID:'
         * BGHM1131-Z-VLDE-DOC-ID
         * END-IF.
         * *GH2161 - COMENTAR - FIM
         * LIMPAR OS CAMPOS C_TIPO_DOC_ID E DEPOSITANTE, PARA NAO APARECER
         * NO DOCUMENTO DE CERTIFICACAO:
         */
        if (msgOut().msg().ade().iValidaDocId().isEmpty() && 
            msgOut().msg().ade().nmCliente().isEmpty() && 
            msgOut().msg().ade().cEntEmixDocId().isEmpty()) {
            msgOut().msg().ade().cTipoDocId().initialize() ;
            msgOut().msg().ade().nDocId().initialize() ;
            msgOut().msg().ade().zVldeDocId().initialize() ;
        }
        if (msgOut().msg().ade().iValidaDocId().isEmpty()) {
            msgOut().msg().ade().iValidaDocId().set(msgIn().msg().ade().iValidaDocId());
            if (msgIn().msg().ade().iValidaDocId().isEqual(CON_NAO)) {
                msgOut().msg().ade().cTipoItvtDep().set(CON_DEP_EXPRESSO_24H);
            }
        }
        /**
         * PASSIVAS 4497 (INICIO)
         */
        if (msgOut().msg().ade().cTipRelDep().isEmpty()) {
            msgOut().msg().ade().cTipRelDep().set(msgIn().msg().ade().cTipRelDep());
        }
        if (msgOut().msg().ade().xInfJstzDep().isEmpty()) {
            msgOut().msg().ade().xInfJstzDep().set(msgIn().msg().ade().xInfJstzDep());
        }
        /**
         * PASSIVAS 4497 (FIM)
         * IF SW-DEBUG-SIM
         * DISPLAY 'BGHM1130-I-VALIDA-DOC-ID:'
         * BGHM1130-I-VALIDA-DOC-ID
         * DISPLAY 'BGHM1131-I-VALIDA-DOC-ID:'
         * BGHM1131-I-VALIDA-DOC-ID
         * END-IF
         * PERFORM 3100-MENSAGEM-OUTPUT
         * THRU 3100-MENSAGEM-OUTPUT-EXIT
         * END-IF.
         * PASSIVAS 2972->FIM
         */
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        log(TraceLevel.Debug, "   BGHM1131-ASE ", msgOut().msg().ase());
        if (message.mensagem().headerR().anulDiaNao().isTrue()) {
            m3100MensagemOutput() ;
        }
        exit() ;
    }
    
    /**
     * 
     * 
     */
    protected void m3010TrataJournal() {
        log(TraceLevel.Trace, "  3010-TRATA-JOURNAL");
        bhyw0001().journal().set(" ");
        bhtp0003() ;
        bhyw0001().journal().msgInput().set(msgIn().msg());
        bhyw0001().journal().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        bhyw0001().journal().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        bhyw0001().journal().msgOutput().set(msgOut().msg());
        bhtp0005() ;
    }
    
    /**
     * 
     * 
     */
    protected void m9010ErroCics() {
        envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().linkPgmjournal());
        bhtp0001() ;
    }
    
    /**
     * 
     * 3100-MENSAGEM-OUTPUT
     * 
     */
    protected void m3100MensagemOutput() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, " 3000-FIM-PROGRAMA");
        log(TraceLevel.Debug, "**********************************************");
        if (message.mensagem().headerR().simzSim().isTrue()) {
            log(TraceLevel.Error, "  -----------------  ");
            log(TraceLevel.Error, "  S I M U L A C A O  ", envOut.errosGraves().aAplErr(), "/", envOut.errosGraves().cRtnoEvenSwal());
            log(TraceLevel.Error, "  -----------------  ");
        } else if (message.mensagem().headerR().simzNao().isTrue()) {
            log(TraceLevel.Error, "  ---------------  ");
            log(TraceLevel.Error, "  I N S E R C A O  ", envOut.errosGraves().aAplErr(), "/", envOut.errosGraves().cRtnoEvenSwal());
            log(TraceLevel.Error, "  ---------------  ");
        }
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "   BGHM1131-C-PAIS-ISOA-CONT     : ", msgOut().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "   BGHM1131-C-BANC-CONT          : ", msgOut().msg().ade().cBancCont());
        log(TraceLevel.Debug, "   BGHM1131-C-OE-EGC-CONT        : ", msgOut().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "   BGHM1131-NS-RDCL-CONT         : ", msgOut().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "   BGHM1131-V-CHKD-CONT          : ", msgOut().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "   BGHM1131-C-TIPO-CONT          : ", msgOut().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "   BGHM1131-C-MOED-ISO-SCTA      : ", msgOut().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "   BGHM1131-NS-DEPOSITO          : ", msgOut().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "   BGHM1131-N-CHEQUE             : ", msgOut().msg().ade().nCheque());
        log(TraceLevel.Debug, "   BGHM1131-C-TIPO-ITVT-DEP      : ", msgOut().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "   BGHM1131-C-TIPO-MDTI          : ", msgOut().msg().ade().cTipoMdti());
        log(TraceLevel.Debug, "   BGHM1131-M-MOV-NMRI           : ", msgOut().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   BGHM1131-I-CLI-CGD            : ", msgOut().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1131-N-CLIENTE            : ", msgOut().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1131-NS-ABRA-CLI          : ", msgOut().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "   BGHM1131-I-CLSZ-TTR1-CONT     : ", msgOut().msg().ade().iClszTtr1Cont());
        log(TraceLevel.Debug, "   BGHM1131-NM-CLIENTE           : ", msgOut().msg().ade().nmCliente());
        log(TraceLevel.Debug, "   BGHM1131-C-PAIS-ISA-EMS-DOC   : ", msgOut().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BGHM1131-C-TIPO-DOC-ID        : ", msgOut().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "   BGHM1131-N-DOC-ID             : ", msgOut().msg().ade().nDocId());
        log(TraceLevel.Debug, "   BGHM1131-Z-VLDE-DOC-ID        : ", msgOut().msg().ade().zVldeDocId());
        log(TraceLevel.Debug, "   BGHM1131-C-ENT-EMIX-DOC-ID    : ", msgOut().msg().ade().cEntEmixDocId());
        log(TraceLevel.Debug, "   BGHM1131-C-PAIS-EM-DOC-PRIN   : ", msgOut().msg().ade().cPaisEmDocPrin());
        log(TraceLevel.Debug, "   BGHM1131-C-TIPO-DOC-ID-PRIN   : ", msgOut().msg().ade().cTipoDocIdPrin());
        log(TraceLevel.Debug, "   BGHM1131-N-DOC-ID-PRIN        : ", msgOut().msg().ade().nDocIdPrin());
        log(TraceLevel.Debug, "   BGHM1131-Z-VLDE-DOC-ID-PRIN   : ", msgOut().msg().ade().zVldeDocIdPrin());
        log(TraceLevel.Debug, "   BGHM1131-C-ENT-EMI-DOC-PRIN   : ", msgOut().msg().ade().cEntEmiDocPrin());
        log(TraceLevel.Debug, "   BGHM1131-I-RCS-JSTZ-ORM-FND   : ", msgOut().msg().ade().iRcsJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1131-Z-PROCESSAMENTO      : ", msgOut().msg().ade().nrElectronico().zProcessamento());
        log(TraceLevel.Debug, "   BGHM1131-C-MNEM-EGC-OPEX      : ", msgOut().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1131-C-PAIS-ISOA-OE-OPX   : ", msgOut().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1131-C-OE-EGC-OPEX        : ", msgOut().msg().ade().nrElectronico().cOeEgcOpex());
        log(TraceLevel.Debug, "   BGHM1131-C-USERID             : ", msgOut().msg().ade().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1131-N-JOUR-BBN           : ", msgOut().msg().ade().nrElectronico().nJourBbn());
        log(TraceLevel.Debug, "   BGHM1131-Q-MOED               : ", msgOut().msg().ade().qMoed());
        log(TraceLevel.Debug, "   BGHM1131-I-PED-JSTZ-ORM-FND   : ", msgOut().msg().ade().iPedJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1131-C-MTVO-PED-JSTZ      : ", msgOut().msg().ade().cMtvoPedJstz());
        log(TraceLevel.Debug, "   BGHM1131-M-ACMD-ETGA          : ", msgOut().msg().ade().mAcmdEtga());
        log(TraceLevel.Debug, "   BGHM1131-I-DOC-DSZD           : ", msgOut().msg().ade().iDocDszd());
        log(TraceLevel.Debug, "   BGHM1131-I-NCSS-TRR-FOTOC     : ", msgOut().msg().ade().iNcssTrrFotoc());
        log(TraceLevel.Debug, "   BGHM1131-NM-CLIENTE-T         : ", msgOut().msg().ade().nmClienteT());
        log(TraceLevel.Debug, "   BGHM1131-C-PAIS-ISA-EMS-DOC-T : ", msgOut().msg().ade().cPaisIsaEmsDocT());
        log(TraceLevel.Debug, "   BGHM1131-C-TIPO-DOC-ID-T      : ", msgOut().msg().ade().cTipoDocIdT());
        log(TraceLevel.Debug, "   BGHM1131-N-DOC-ID-T           : ", msgOut().msg().ade().nDocIdT());
        log(TraceLevel.Debug, "   BGHM1131-Z-VLDE-DOC-ID-T      : ", msgOut().msg().ade().zVldeDocIdT());
        log(TraceLevel.Debug, "   BGHM1131-C-ENT-EMIX-DOC-ID-T  : ", msgOut().msg().ade().cEntEmixDocIdT());
        log(TraceLevel.Debug, "   BGHM1131-I-CBRC-ENCG          : ", msgOut().msg().ade().iCbrcEncg());
        log(TraceLevel.Debug, "   BGHM1131-C-FAMI-PROD          : ", msgOut().msg().ade().cFamiProd());
        log(TraceLevel.Debug, "   BGHM1131-C-PRODUTO            : ", msgOut().msg().ade().cProduto());
        log(TraceLevel.Debug, "   BGHM1131-C-TIPO-MOV-SCTA      : ", msgOut().msg().ade().cTipoMovScta());
        log(TraceLevel.Debug, "   BGHM1131-I-INSZ-DOC-ID-CLI    : ", msgOut().msg().ade().iInszDocIdCli());
        log(TraceLevel.Debug, "   BGHM1131-I-VALIDA-DOC-ID      :", msgOut().msg().ade().iValidaDocId());
        log(TraceLevel.Debug, "   BGHM1131-C-TIP-REL-DEP        : ", msgOut().msg().ade().cTipRelDep());
        log(TraceLevel.Debug, "   BGHM1131-X-INF-JSTZ-DEP       : ", msgOut().msg().ade().xInfJstzDep());
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "******** FIM * GHIH * MVPHIH * FIM ***********");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, " ");
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
     * BHOK0001   CONSTANTES COM CODIGOS DE ERRO 'HO'
     * 
     * @version 2.0
     * 
     */
    public interface Bhok0001Pghs133a extends Bhok0001 {
        
        /**
         * *** HO-505 = INIBICAO MOVIM NUMERARIO
         */
        @Data(size=3, signed=true, value="-507")
        IInt inibicaoMovNum() ;
        
        /**
         * PASSIVAS 4357 - INIBICAO PRIMEIRO MOVIM EM NUMERARIO
         */
        @Data(size=3, signed=true, value="-744")
        IInt inibicaoMovPri() ;
        
    }
    
    /**
     * 
     * *---DOCUMENTOS VALIDOS PARA CLIENTES EMPRESA NAS ENTREGA EM ATS---
     * 
     * @version 2.0
     * 
     */
    public interface ConDocNipc extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNipcCPais() ;
        
        @Data(size=3, value="502")
        IString conNipcTDoc() ;
        
    }
    public interface ConDocNfie extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNfieCPais() ;
        
        @Data(size=3, value="861")
        IString conNfieTDoc() ;
        
    }
    public interface ConDocNpc extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNpcCPais() ;
        
        @Data(size=3, value="303")
        IString conNpcTDoc() ;
        
    }
    public interface ConDocNife extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNifeCPais() ;
        
        @Data(size=3, value="860")
        IString conNifeTDoc() ;
        
    }
    
    /**
     * 
     * TABELA INTERNAS
     * 
     * @version 2.0
     * 
     */
    public interface WsTabelasInternas extends IDataStruct {
        
        /**
         * @return instancia da classe local WsTipoDocumento
         */
        @Data(length=250)
        IArray<WsTipoDocumento> wsTipoDocumento() ;
        
        
        public interface WsTipoDocumento extends IDataStruct {
            
            @Data(size=20, value=" ")
            IString wsTdCCodigo() ;
            
            @Data(size=20, value=" ")
            IString wsTdXCteuCo03() ;
            
        }
    }
    public interface WsTsTransaccao extends IDataStruct {
        
        @Data(size=10)
        IString wsData() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
        IInt wsHora() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsMinuntos() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsSegundos() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRest() ;
        
    }
    public interface WsTempo extends IDataStruct {
        
        @Data(size=2, value="0")
        IInt wsHoraTempo() ;
        
        @Data(size=2, value="0")
        IInt wsMinuntosTempo() ;
        
        @Data(size=2, value="0")
        IInt wsSegundosTempo() ;
        
        @Data(size=3, value="0")
        IInt wsIndExt() ;
        
        @Data(size=3, value="0")
        IInt wsIndInt() ;
        
        @Data(size=3, value="0")
        IInt wsInd() ;
        
        @Data(size=3, value="0")
        IInt wsIndoc() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP)
        IInt wsStNull() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMtItvtOpe() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMtConta() ;
        
        @Data(size=17, decimal=2, signed=true, value="0")
        IDecimal wsMontTotal() ;
        
        @Data(size=10, value="0")
        ILong wsBhjl006aNCliente() ;
        
        @Data(size=10, value="0")
        ILong wsNCliente() ;
        
        @Data(size=3, value="0")
        IInt wsNsAbraCli() ;
        
        @Data(size=10, value="0")
        ILong wsNCliente1t() ;
        
        @Data(size=3, value="0")
        IInt wsNsAbraCli1t() ;
        
        @Data(size=2, value="0")
        IInt wsObtemRel() ;
        
        /**
         * @return instancia da classe local WsCodCodigo
         */
        @Data
        WsCodCodigo wsCodCodigo() ;
        
        @Data(size=20, value=" ")
        IString wsCCodigoTemp() ;
        
        @Data(size=20, value=" ")
        IString wsXCteuCo03Temp() ;
        
        @Data(size=10, value=" ")
        IString wsDataDb2() ;
        
        @Data(size=3, value=" ")
        IString wsCPaisIsaEmsDocAux() ;
        
        @Data(size=3, value=" ")
        IString wsCTipoDocIdAux() ;
        
        @Data(size=20, value=" ")
        IString wsNDocIdAux() ;
        
        @Data(size=10, value=" ")
        IString wsZVldeDocIdAux() ;
        
        @Data(size=10, value=" ")
        IString wsCEntEmixDocIdAux() ;
        
        
        public interface WsCodCodigo extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCcCPais() ;
            
            @Data(size=3, value=" ")
            IString wsCcTDoc() ;
            
        }
    }
    public interface SwSwitchs extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh13001() ;
        @Data
        @Condition("0")
        ICondition swVgh13001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh13001Notfnd() ;
        
        
        @Data(size=2, value=" ")
        IString swTipoItvtClszTtr1Cont() ;
        @Data
        @Condition("PP")
        ICondition swPropriosParticular() ;
        @Data
        @Condition("TP")
        ICondition swTerceirosParticular() ;
        @Data
        @Condition("PE")
        ICondition swPropOuMdtaEmpresa() ;
        @Data
        @Condition("TE")
        ICondition swTerceirosEmpresa() ;
        @Data
        @Condition("LP")
        ICondition swPropLevParticular() ;
        @Data
        @Condition("LE")
        ICondition swPropLevEmpresa() ;
        @Data
        @Condition("QP")
        ICondition swPropPagChqParticular() ;
        @Data
        @Condition("QE")
        ICondition swPropPagChqEmpresa() ;
        @Data
        @Condition("BP")
        ICondition swBeneChqParticular() ;
        @Data
        @Condition("BE")
        ICondition swBeneChqEmpresa() ;
        @Data
        @Condition("24")
        ICondition swDepositoExpresso24h() ;
        
        
        @Data(size=1, value=" ")
        IString swValidaTipoCli() ;
        @Data
        @Condition("E")
        ICondition swClienteEmpresa() ;
        @Data
        @Condition("P")
        ICondition swClienteParticular() ;
        @Data
        @Condition("I")
        ICondition swClienteEni() ;
        @Data
        @Condition({ "P", "I" })
        ICondition swClienteNEmpresa() ;
        
        
        @Data(size=1, value=" ")
        IString swCiclo() ;
        @Data
        @Condition("C")
        ICondition swEmCiclo() ;
        @Data
        @Condition("F")
        ICondition swFimCiclo() ;
        
        
        @Data(size=1, value=" ")
        IString swDoc() ;
        @Data
        @Condition("N")
        ICondition swDocNok() ;
        @Data
        @Condition("O")
        ICondition swDocOk() ;
        
        
        @Data(size=1, value=" ")
        IString swDocAux() ;
        @Data
        @Condition("N")
        ICondition swDocNokAux() ;
        @Data
        @Condition("O")
        ICondition swDocOkAux() ;
        
        
        @Data(size=1, value=" ")
        IString swRiscoCliente() ;
        @Data
        @Condition("S")
        ICondition swCliSemRisco() ;
        @Data
        @Condition("A")
        ICondition swCliAltoRisco() ;
        
        
        /**
         * *GH1621 - INI
         */
        @Data(size=1, value="N")
        IString swClienteEmpMand() ;
        @Data
        @Condition("S")
        ICondition swCliEmpMandS() ;
        @Data
        @Condition("N")
        ICondition swCliEmpMandN() ;
        
        
        /**
         * *GH1621 - FIM
         */
        @Data(size=3, signed=true, value="0")
        IInt swCodIntervencao() ;
        @Data
        @Condition(range={"101", "304"})
        ICondition swItvtTitular() ;
        @Data
        @Condition(range={"106", "109"})
        ICondition swItvtAutorizado() ;
        
        
        /**
         * *--- TABELA GERAL LOGICA 'G65' - TIPO DE OPERACAO NA CONTA
         */
        @Data(size=1, value=" ")
        IString swCTipoMovScta() ;
        @Data
        @Condition("E")
        ICondition swEntrega() ;
        @Data
        @Condition("L")
        ICondition swLevantamento() ;
        @Data
        @Condition("I")
        ICondition swLiquidacaoConta() ;
        @Data
        @Condition("P")
        ICondition swPagChqCtaHvl7() ;
        @Data
        @Condition("M")
        ICondition swPagChqVisadoHvb2() ;
        @Data
        @Condition("Q")
        ICondition swPagChqOicHbf0() ;
        @Data
        @Condition("N")
        ICondition swPagChqHve5Hvl3() ;
        @Data
        @Condition("A")
        ICondition swEntregaNAlnova() ;
        @Data
        @Condition({ "E", "L", "I", "P", "Q", "N", "M", "A" })
        ICondition swTipoOpeValidos() ;
        
        
    }
    
}
