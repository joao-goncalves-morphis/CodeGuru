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
import cgd.gh.structures.messages.Bghm1160 ;
import cgd.gh.structures.messages.Bghm1161 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hh.structures.link.Bhhl070a ;
import cgd.hj.structures.link.Bhjl027a ;
import cgd.he.structures.link.Bhel100a ;
import cgd.hj.structures.link.Bhjl042a ;
import cgd.hj.structures.link.Bhjl628a ;
import cgd.hj.structures.link.Bhjl014a ;
import cgd.gh.structures.link.Bghl300a ;
import cgd.hj.structures.link.Bhjl006a ;
import cgd.hg.structures.link.Bhgl052a ;
import cgd.hj.structures.link.Bhjl707a ;
import cgd.hj.structures.link.Bhjl249a ;
import cgd.hj.structures.link.Bhjl470a ;
import cgd.hy.structures.work.Bhyw0001 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.gh.common.constants.Bghk0005 ;
import cgd.hj.common.constants.Bhjk0001 ;
import cgd.hj.common.constants.Bhjk0011 ;
import cgd.hj.common.constants.Bhjk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.routines.Mhts220a ;
import cgd.hh.routines.Mhhj070a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj052a ;
import cgd.hj.routines.Mhjs006a ;
import cgd.hj.routines.Mhjj027a ;
import cgd.hj.routines.Mhjj470a ;
import cgd.hj.routines.Mhjj707a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.he.routines.Mhej100a ;
import cgd.hj.routines.Mhjj042a ;
import cgd.hj.routines.Mhjj628a ;
import cgd.hj.routines.Mhjj014a ;
import cgd.gh.routines.Mghj300a ;


/**
 * 
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS163A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1692 - TERC - 3ª FASE - TRANSACOES OCASIONIAS
 * FUNCAO     : MANUTENCAO IDENTIFICACAO INTERVENIENTE EM OPERACAO
 * OCASIONAL- TRANSFERENCIAS /CAMBIO /TROCO E DESTROCO
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES: CENTRAL - GHIK / LOCAL - MVPHIK
 * LOG DE ALTERACOES
 * *PROC.GIP !   DATA   !UTILIZ.! OBSERVACOES
 * GH1692  !2015-03-04!ACT0649! TERC - FASE 3 -  CRIACAO
 * *PASS2972 !2018-09-20!E003881! FORMATACAO DA DATA DOS DOCUMENTOS
 * VITALICIOS COM 2399-12-31 EM VEZ
 * DE 9999-12-31
 * *PASS4497 !2019-10-15!ACCENTU! UCO 2.7 - LEI N.º 83  OSI3656
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs163a extends CgdGhBaseOnline<Pghs163a.EnvelopeIn, Pghs163a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1160
     */
    public abstract Bghm1160 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1161
     */
    public abstract Bghm1161 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1160.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1161.Msg msgOut() ;
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
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhts220a
     */
    @Data
    protected abstract Mhts220a hrMhts220a() ;
    
    /**
     * @return instancia da classe Mhhj070a
     */
    @Data
    protected abstract Mhhj070a hrMhhj070a() ;
    
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
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    /**
     * @return instancia da classe Mhej100a
     */
    @Data
    protected abstract Mhej100a hrMhej100a() ;
    
    /**
     * @return instancia da classe Mhjj042a
     */
    @Data
    protected abstract Mhjj042a hrMhjj042a() ;
    
    /**
     * @return instancia da classe Mhjj628a
     */
    @Data
    protected abstract Mhjj628a hrMhjj628a() ;
    
    /**
     * @return instancia da classe Mhjj014a
     */
    @Data
    protected abstract Mhjj014a hrMhjj014a() ;
    
    /**
     * @return instancia da classe Mghj300a
     */
    @Data
    protected abstract Mghj300a hrMghj300a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhhl070a
     */
    @Data
    protected abstract Bhhl070a bhhl070a() ;
    
    /**
     * @return instancia da classe Bhjl027a
     */
    @Data
    protected abstract Bhjl027a bhjl027a() ;
    
    /**
     * @return instancia da classe Bhel100a
     */
    @Data
    protected abstract Bhel100a bhel100a() ;
    
    /**
     * @return instancia da classe Bhjl042a
     */
    @Data
    protected abstract Bhjl042a bhjl042a() ;
    
    /**
     * @return instancia da classe Bhjl628a
     */
    @Data
    protected abstract Bhjl628a bhjl628a() ;
    
    /**
     * @return instancia da classe Bhjl014a
     */
    @Data
    protected abstract Bhjl014a bhjl014a() ;
    
    /**
     * @return instancia da classe Bghl300a
     */
    @Data
    protected abstract Bghl300a bghl300a() ;
    
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
     * @return instancia da classe Bhyw0001
     */
    @Data
    protected abstract Bhyw0001 bhyw0001() ;
    
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
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
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
     * @return instancia da classe Bhjk0011
     */
    @Data
    protected abstract Bhjk0011 bhjk0011() ;
    
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
    
    protected static final String CON_NOME_PROGRAMA = "PGHS163A" ;
    
    protected static final String CON_APLICACAO_GH = "GH" ;
    
    protected static final String CON_NAO = "N" ;
    
    protected static final String CON_SIM = "S" ;
    
    protected static final String CON_ANULADA = "A" ;
    
    protected static final int CON_1_TITULAR = 1 ;
    
    protected static final int CON_ZERO = 0 ;
    
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_3N = 3 ;
    
    protected static final int CON_10N = 10 ;
    
    protected static final int CON_11N = 11 ;
    
    protected static final int CON_250N = 250 ;
    
    protected static final int CON_100N = 100 ;
    
    /**
     * *---CALCULO DA DATA MENOS 30 DIAS
     */
    protected static final String CON_SUBTR_PRZ_DATA = "23" ;
    
    protected static final int CON_C_TIPO_PRAZ_1 = 1 ;
    
    protected static final int CON_DU_TIPO_PRAZ_30 = 30 ;
    
    /**
     * *---TIPO DE INTERVENIENTE---
     */
    protected static final String CON_ORDENANTE = "O" ;
    
    protected static final String CON_BENEFICIARIO = "F" ;
    
    /**
     * *---TIPO DE CLIENTE---
     */
    protected static final String CON_EMPRESA = "E" ;
    
    protected static final String CON_ENI = "I" ;
    
    protected static final String CON_PARTICULAR = "P" ;
    
    /**
     * *---ALERTAS DAS OPERACOES OCASIONAIS---
     * TABELA GERAL LOGICA 'G64' - MOTIVO DO PEDIDO DE JUSTIFICACAO
     */
    protected static final String CON_MONT_OPERACAO = "M" ;
    
    protected static final String CON_LIM_ACMD_ITVT = "I" ;
    
    /**
     * *---DB2---
     */
    protected static final String CON_VGH13001 = "VGH13001" ;
    
    protected static final String CON_DATA_MIN = "0001-01-01" ;
    
    protected static final String CON_DATA_MAX = "9999-12-31" ;
    
    /**
     * *---TABELAS GERAIS---
     */
    protected static final String CON_TIPODOCID_886 = "886" ;
    
    /**
     * *---DOCUMENTOS FISCAIS VALIDOS - SINGULAR
     * @return instancia da classe local ConDocNif
     */
    @Data
    protected abstract ConDocNif conDocNif() ;
    
    /**
     * @return instancia da classe local ConDocNfePs
     */
    @Data
    protected abstract ConDocNfePs conDocNfePs() ;
    
    /**
     * *---DOCUMENTOS VALIDOS PARA CLIENTES EMPRESA
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
     * *---TIPO DE OPERACAO
     */
    protected static final String CON_CAMBIO = "C" ;
    
    protected static final String CON_TROCO_DESTROCO = "D" ;
    
    protected static final String CON_ORDENS_RECEBIDAS = "R" ;
    
    protected static final String CON_ORDENS_EMITIDAS = "S" ;
    
    protected static final String CON_OCASIONAIS = "O" ;
    
    /**
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
     * *PASS2972 - FIM
     * TABELA INTERNAS
     * @return instancia da classe local WsTabelasInternas
     */
    @Data
    protected abstract WsTabelasInternas wsTabelasInternas() ;
    
    /**
     * *GH2024--> INICIO
     * @return instancia da classe local WsTabInternaDoc
     */
    @Data
    protected abstract WsTabInternaDoc wsTabInternaDoc() ;
    
    /**
     * *GH2024--> FIM
     * VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * *-- SWITCHS
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
    }
    
    /**
     * 
     * ROTINA DE OBTENCAO DOS CAMPOS DA TABELA DE CHEQUES
     * THH00011_CHEQUES.
     * 
     */
    protected void bhhp0070ConsThh11Cheq() {
        hrMhhj070a().run() ;
    }
    
    /**
     * 
     * TABELA GERAIS - ACESSO A TABELAS GERAIS
     * 
     */
    protected void bhgp0030AcessoTabela() {
    }
    
    /**
     * 
     * ACESSO ROTINA MHGJ052A
     * 
     */
    protected void bhgp0052AcedeMhgj052a() {
    }
    
    /**
     * 
     * BHJP6006-ACESSO AO MODULO QUE VALIDA A EXISTENCIA DO CLIENTE
     * E DEVOLVE ALGUNS INDICADORES BASICOS (MHJS006A)
     * 
     */
    protected void bhjp6006AcedeMhjs006a() {
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
    }
    
    /**
     * 
     * BHJP0707-ACESSO AO MODULO DE OBTENCAO DOS DOCUMENTOS
     * DE IDENTIFICACAO DO CLIENTE (MHJJ707A)
     * 
     */
    protected void bhjp0707AcedeMhjj707a() {
    }
    
    /**
     * 
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MHEJ100A - MANUTENCAO DA TABELA DE DADOS DE NAO CLIENTES
     * 
     */
    protected void bhep5100TabNaoClientes() {
    }
    
    /**
     * 
     * BHJP5042-ACESSO AO MODULO QUE DEVOLVE AS ACTIVIDADES
     * DO CLIENTE (MHJJ042A)
     * 
     */
    protected void bhjp5042AcedeMhjj042a() {
    }
    
    /**
     * 
     * ROTINA DE MANUTENCAO DA TABELA DE DOCUMENTOS
     * DE IDENTIFICACAO (THJ00023)
     * 
     */
    protected void bhjp0628Mhjj628a() {
    }
    
    /**
     * 
     * BHJP5014-ACESSO AO MODULO DE OBTENCAO DOS DADOS
     * COMPLEMENTARES DO CLIENTE (MHJJ014A)
     * 
     */
    protected void bhjp5014AcedeMhjj014a() {
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MGHJ300A - VERIFICA ESTADO ORDENS EMITIDAS OU RECEBIDAS
     * 
     */
    protected void bghp1300VerifEstadOrd() {
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "***** INICIO * GHIK * MVPHIK * INICIO ********");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2000ProcessoPrograma() ;
        }
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, " 1000-INICIO-PROGRAMA");
        wsTabelasInternas().initialize() ;
        wsVariaveis().initialize() ;
        hv13001Movdep().movdep().initialize() ;
        msgOut().msg().initialize() ;
        bhjl027a().commarea().initialize() ;
        bhel100a().commarea().initialize() ;
        bhjl042a().commarea().initialize() ;
        bhjl628a().commarea().initialize() ;
        bhjl014a().commarea().initialize() ;
        bghl300a().commarea().initialize() ;
        bhjl006a().commarea().initialize() ;
        bhgl052a().commarea().initialize() ;
        bhjl707a().commarea().initialize() ;
        bhjl249a().commarea().initialize() ;
        bhjl470a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        hrMhts220a().bhtl220a().commarea().initialize() ;
        bhyl230a().commarea().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().msg().ade().set(msgIn().msg().ade());
        log(TraceLevel.Debug, "   BGHM1160-ASE  ", msgIn().msg().ase());
        m1100MensagemInput() ;
        swSwitchs().swCTipoOpeCont().set(msgIn().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "   SW-C-TIPO-OPE-CONT : ", swSwitchs().swCTipoOpeCont());
        log(TraceLevel.Debug, "    1 - CAMBIO .................. C J K");
        log(TraceLevel.Debug, "          SGOCVN-HE34 ........... J");
        log(TraceLevel.Debug, "          SGOCVN-HE35 ........... K");
        log(TraceLevel.Debug, "    2 - TROCO-DESTROCO .......... D");
        log(TraceLevel.Debug, "    3 - TRANSFERENCIAS .......... T S R");
        log(TraceLevel.Debug, "          ORDENS-EMITIDAS ....... S");
        log(TraceLevel.Debug, "          ORDENS-RECEBIDAS ...... R");
        log(TraceLevel.Debug, "    4 - OCASIONAIS .............. O C J K D T");
        log(TraceLevel.Debug, "                   .............. S R X H Y V");
        log(TraceLevel.Debug, "          SGIX02 ................ X");
        log(TraceLevel.Debug, "          SGOVTC-HE37 ........... H");
        log(TraceLevel.Debug, "          PI3501-EMISS-CHQ....... Y");
        log(TraceLevel.Debug, "          CHQHB0-CHQ-BANCARIO.... V");
        log(TraceLevel.Debug, "  ");
        log(TraceLevel.Debug, "    ANULACOES / ESTORNOS ");
        log(TraceLevel.Debug, "          PI3105-ESTORNO-ORDENS.. U");
        log(TraceLevel.Debug, "          PI3102-CAN-ANUL-EMITD.. W");
        log(TraceLevel.Debug, "          PI3503-ANUL-ESTOR-CHQ.. Z");
        if (message.mensagem().headerR().anulDiaNao().isTrue() && !swSwitchs().swAnulacoesEstornosRef().isTrue()) {
            m1150ValidaInput1() ;
        } else {
            m1155ValidaInput2() ;
        }
        /**
         * *GH2024--> INICIO
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsInd().set(CON_1N);
            m1201InicTabIntDoc() ;
        }
        /**
         * *GH2024--> FIM
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsInd().set(CON_1N);
            while (wsVariaveis().wsInd().isLessOrEqual(CON_250N)) {
                m1200InicTabInternas() ;
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            !swSwitchs().swAnulacoesEstornosRef().isTrue()) {
            m1300ValClienteItvt() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            !swSwitchs().swAnulacoesEstornosRef().isTrue() && 
            msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            m1400ValClienteRprt() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().anulDiaNao().isTrue() && 
            !swSwitchs().swAnulacoesEstornosRef().isTrue()) {
            m1500TipoItvtCliente() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzSim().isTrue() && 
            message.mensagem().headerR().anulDiaNao().isTrue() && 
            !swSwitchs().swAnulacoesEstornosRef().isTrue()) {
            m1600LimpaOutput() ;
        }
    }
    
    /**
     * 
     * 1100-MENSAGEM-INPUT
     * 
     */
    protected void m1100MensagemInput() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, " 3000-FIM-PROGRAMA");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISO-ALFN      : ", msgIn().msg().ade().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   BGHM1160-C-MNEM-EMP-GCX       : ", msgIn().msg().ade().cMnemEmpGcx());
        log(TraceLevel.Debug, "   BGHM1160-C-REF-MSG-SWIF       : ", msgIn().msg().ade().cRefMsgSwif());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-OPE-CONT      : ", msgIn().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "   BGHM1160-N-CHEQUE             : ", msgIn().msg().ade().nCheque());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-ITVT-DEP      : ", msgIn().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "   BGHM1160-M-MOV-NMRI           : ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   BGHM1160-I-CLI-CGD            : ", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-CLI           : ", msgIn().msg().ade().cTipoCli());
        log(TraceLevel.Debug, "   BGHM1160-N-CLIENTE            : ", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1160-NS-ABRA-CLI          : ", msgIn().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "   BGHM1160-NM-CLIENTE           : ", msgIn().msg().ade().nmCliente());
        log(TraceLevel.Debug, "   BGHM1160-Z-NASC-CLI           : ", msgIn().msg().ade().zNascCli());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-NACN-CLI      : ", msgIn().msg().ade().cPaisNacnCli());
        log(TraceLevel.Debug, "   BGHM1160-NM-EMP-RNPC          : ", msgIn().msg().ade().nmEmpRnpc());
        log(TraceLevel.Debug, "   BGHM1160-C-AE                 : ", msgIn().msg().ade().cAe());
        log(TraceLevel.Debug, "   BGHM1160-D-AE                 : ", msgIn().msg().ade().dAe());
        log(TraceLevel.Debug, "   BGHM1160-N-IPC                : ", msgIn().msg().ade().nIpc());
        log(TraceLevel.Debug, "   BGHM1160-I-CLI-CGD-RPRT       : ", msgIn().msg().ade().iCliCgdRprt());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-CLI-RPRT      : ", msgIn().msg().ade().cTipoCliRprt());
        log(TraceLevel.Debug, "   BGHM1160-N-CLIENTE-RPRT       : ", msgIn().msg().ade().nClienteRprt());
        log(TraceLevel.Debug, "   BGHM1160-NS-ABRA-CLI-RPRT     : ", msgIn().msg().ade().nsAbraCliRprt());
        log(TraceLevel.Debug, "   BGHM1160-NM-CLIENTE-RPRT      : ", msgIn().msg().ade().nmClienteRprt());
        log(TraceLevel.Debug, "   BGHM1160-Z-NASC-CLI-RPRT      : ", msgIn().msg().ade().zNascCliRprt());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-NACN-CLI-RP   : ", msgIn().msg().ade().cPaisNacnCliRp());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-APT   : ", msgIn().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-APTD   : ", msgIn().msg().ade().cTipoDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-APTD        : ", msgIn().msg().ade().nDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1160-Z-VLDE-DOC-ID-APTD   : ", msgIn().msg().ade().zVldeDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1160-C-ENT-EMI-DID-APTD   : ", msgIn().msg().ade().cEntEmiDidAptd());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISA-EMS-DOC   : ", msgIn().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID        : ", msgIn().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID             : ", msgIn().msg().ade().nDocId());
        log(TraceLevel.Debug, "   BGHM1160-Z-VLDE-DOC-ID        : ", msgIn().msg().ade().zVldeDocId());
        log(TraceLevel.Debug, "   BGHM1160-C-ENT-EMIX-DOC-ID    : ", msgIn().msg().ade().cEntEmixDocId());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-RPT   : ", msgIn().msg().ade().cPaisEmsDocRpt());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-RPRT   : ", msgIn().msg().ade().cTipoDocIdRprt());
        log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-RPRT        : ", msgIn().msg().ade().nDocIdRprt());
        log(TraceLevel.Debug, "   BGHM1160-Z-VLDE-DOC-ID-RPRT   : ", msgIn().msg().ade().zVldeDocIdRprt());
        log(TraceLevel.Debug, "   BGHM1160-C-ENT-EMIX-DID-RPT   : ", msgIn().msg().ade().cEntEmixDidRpt());
        log(TraceLevel.Debug, "   OUT....                         ");
        log(TraceLevel.Debug, "   BGHM1160-I-PED-JSTZ-ORM-FND   : ", msgIn().msg().ade().iPedJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1160-I-RCS-JSTZ-ORM-FND   : ", msgIn().msg().ade().iRcsJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1160-C-MTVO-PED-JSTZ      : ", msgIn().msg().ade().cMtvoPedJstz());
        log(TraceLevel.Debug, "   BGHM1160-M-ACMD-LIM-OPE       : ", msgIn().msg().ade().mAcmdLimOpe());
        log(TraceLevel.Debug, "   BGHM1160-Z-PROCESSAMENTO      : ", msgIn().msg().ade().nrElectronico().zProcessamento());
        log(TraceLevel.Debug, "   BGHM1160-C-MNEM-EGC-OPEX      : ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISOA-OE-OPX   : ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1160-C-OE-EGC-OPEX        : ", msgIn().msg().ade().nrElectronico().cOeEgcOpex());
        log(TraceLevel.Debug, "   BGHM1160-C-USERID             : ", msgIn().msg().ade().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1160-N-JOUR-BBN           : ", msgIn().msg().ade().nrElectronico().nJourBbn());
        log(TraceLevel.Debug, "   BGHM1160-Q-MOED               : ", msgIn().msg().ade().qMoed());
        log(TraceLevel.Debug, "   BGHM1160-I-DOC-DSZD           : ", msgIn().msg().ade().iDocDszd());
        log(TraceLevel.Debug, "   BGHM1160-I-NCSS-TRR-FOTOC     : ", msgIn().msg().ade().iNcssTrrFotoc());
        log(TraceLevel.Debug, "   BGHM1160-I-CBRC-ENCG          : ", msgIn().msg().ade().iCbrcEncg());
        log(TraceLevel.Debug, "   BGHM1160-C-FAMI-PROD          : ", msgIn().msg().ade().cFamiProd());
        log(TraceLevel.Debug, "   BGHM1160-C-PRODUTO            : ", msgIn().msg().ade().cProduto());
        log(TraceLevel.Debug, "   BGHM1160-I-INSZ-DOC-ID-CLI    : ", msgIn().msg().ade().iInszDocIdCli());
        log(TraceLevel.Debug, "   BGHM1160-C-EST-CLI-FLTG       : ", msgIn().msg().ade().cEstCliFltg());
        log(TraceLevel.Debug, "   BGHM1160-C-PFI-RIS-BRQM-CAP   : ", msgIn().msg().ade().cPfiRisBrqmCap());
        log(TraceLevel.Debug, "   BGHM1160-I-DOC-DSZD-RPRT      : ", msgIn().msg().ade().iDocDszdRprt());
        log(TraceLevel.Debug, "   BGHM1160-I-NCSS-TRR-FOT-RPT   : ", msgIn().msg().ade().iNcssTrrFotRpt());
        log(TraceLevel.Debug, "   BGHM1160-I-INSZ-DOC-CLI-RPT   : ", msgIn().msg().ade().iInszDocCliRpt());
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
         * *-1- TIPOS DE INTERVENIENTE
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_ORDENANTE) && 
            !msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENEFICIARIO)) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-01");
            log(TraceLevel.Error, "   BGHM1160-C-TIPO-ITVT-DEP MAL FORMATADO : ", msgIn().msg().ade().cTipoItvtDep());
        }
        /**
         * *-2- CLIENTE CGD OU NAO CGD
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            !msgIn().msg().ade().iCliCgd().isEqual(CON_NAO) && 
            !msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-02");
            log(TraceLevel.Error, "   BGHM1160-I-CLI-CGD MAL FORMATADO : ", msgIn().msg().ade().iCliCgd());
        }
        /**
         * *-3- TIPO DE CLIENTE
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            !msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA) && 
            !msgIn().msg().ade().cTipoCli().isEqual(CON_ENI) && 
            !msgIn().msg().ade().cTipoCli().isEqual(CON_PARTICULAR)) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().ncliDadosIncomp());
            } else {
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            }
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-03");
            log(TraceLevel.Error, "   BGHM1160-C-TIPO-CLI MAL FORMATADO : ", msgIn().msg().ade().cTipoCli());
        }
        /**
         * *-4- N-CLIENTE
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!msgIn().msg().ade().nCliente().isNumeric() || 
                msgIn().msg().ade().nCliente().isEqual(0) || 
                !msgIn().msg().ade().nsAbraCli().isNumeric()) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-04");
                log(TraceLevel.Error, "   BGHM1160-N-CLIENTE FORMATADO : ", msgIn().msg().ade().nCliente());
            }
        }
        /**
         * *-5- DOCUMENTO APRESENTADO PELO ITVT OU PELO RPRT
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (msgIn().msg().ade().cPaisEmsDocApt().isEmpty() || 
                msgIn().msg().ade().cPaisEmsDocApt().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().cTipoDocIdAptd().isEmpty() || 
                msgIn().msg().ade().cTipoDocIdAptd().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().nDocIdAptd().isEmpty() || 
                msgIn().msg().ade().nDocIdAptd().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zVldeDocIdAptd().isEmpty() || 
                msgIn().msg().ade().zVldeDocIdAptd().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zVldeDocIdAptd().isEqual(CON_DATA_MIN)) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-05");
                log(TraceLevel.Error, "   DOCUMENTO APRESENTADO MAL FORMATADO ");
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cPaisEmsDocApt());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cTipoDocIdAptd());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().nDocIdAptd());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().zVldeDocIdAptd());
            }
        }
        /**
         * *-6- VALIDA REPRESENTANTE E EMPRESA
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            /**
             * *----1- CLIENTE REPRESENTANTE CGD OU NAO CGD
             */
            if (!msgIn().msg().ade().iCliCgdRprt().isEqual(CON_NAO) && 
                !msgIn().msg().ade().iCliCgdRprt().isEqual(CON_SIM)) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-06");
                log(TraceLevel.Error, "   BGHM1160-I-CLI-CGD-RPRT MAL FORMATADO : ", msgIn().msg().ade().iCliCgdRprt());
            }
            /**
             * *----2- TIPO DE CLIENTE REPRESENTANTE
             */
            if (envOut.errosGraves().semErros().isTrue() && 
                !msgIn().msg().ade().cTipoCliRprt().isEqual(CON_EMPRESA) && 
                !msgIn().msg().ade().cTipoCliRprt().isEqual(CON_ENI) && 
                !msgIn().msg().ade().cTipoCliRprt().isEqual(CON_PARTICULAR)) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                if (msgIn().msg().ade().iCliCgdRprt().isEqual(CON_NAO)) {
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nCliRprtDadosInc());
                } else {
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
                }
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-07");
                log(TraceLevel.Error, "   BGHM1160-C-TIPO-CLI-RPRT MAL FORMATADO : ", msgIn().msg().ade().cTipoCliRprt());
            }
            /**
             * *----3- N-CLIENTE-RPRT
             */
            if (envOut.errosGraves().semErros().isTrue() && 
                (!msgIn().msg().ade().nClienteRprt().isNumeric() || 
                msgIn().msg().ade().nClienteRprt().isEqual(0) || 
                !msgIn().msg().ade().nsAbraCliRprt().isNumeric())) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-08");
                log(TraceLevel.Error, "   BGHM1160-N-CLIENTE-RPRT MAL FORMATADO : ", msgIn().msg().ade().nClienteRprt());
            }
            /**
             * *----4- DOCUMENTO DA EMPRESA
             */
            if (envOut.errosGraves().semErros().isTrue() && 
                (msgIn().msg().ade().cPaisIsaEmsDoc().isEmpty() || 
                msgIn().msg().ade().cPaisIsaEmsDoc().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().cTipoDocId().isEmpty() || 
                msgIn().msg().ade().cTipoDocId().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().nDocId().isEmpty() || 
                msgIn().msg().ade().nDocId().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zVldeDocId().isEmpty() || 
                msgIn().msg().ade().zVldeDocId().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zVldeDocId().isEqual(CON_DATA_MIN))) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-09");
                log(TraceLevel.Error, "   DOCUMENTO DA EMPRESA MAL FORMATADO");
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cPaisIsaEmsDoc());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cTipoDocId());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().nDocId());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().zVldeDocId());
            }
            /**
             * *----5- DADOS DO SGOE THE00075 - CLI PARTICULAR / ENI
             */
            if (envOut.errosGraves().semErros().isTrue() && 
                msgIn().msg().ade().iCliCgdRprt().isEqual(CON_NAO) && 
                !msgIn().msg().ade().cTipoCliRprt().isEqual(CON_EMPRESA) && 
                (msgIn().msg().ade().nmClienteRprt().isEmpty() || 
                msgIn().msg().ade().zNascCliRprt().isEmpty() || 
                msgIn().msg().ade().zNascCliRprt().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zNascCliRprt().isEqual(CON_DATA_MIN) || 
                msgIn().msg().ade().cPaisNacnCliRp().isEmpty())) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nCliRprtDadosInc());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-10");
                log(TraceLevel.Error, "   DADOS SGOE THE00075 - CLI RPRT PART/ENI : ");
                log(TraceLevel.Error, "   ", msgIn().msg().ade().nmClienteRprt());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().zNascCliRprt());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cPaisNacnCliRp());
            }
        }
        /**
         * *-7- TIPO DE OPERACAO DE ENTRADA
         */
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swTodosCTipoOpe().isTrue()) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-11");
            log(TraceLevel.Error, "   TIPO DE OPERACAO DE ENTRADA : ", swSwitchs().swCTipoOpeCont());
        }
        /**
         * *-8- MONTANTE DO MOVIMENTO EM NUMERARIO
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            (!msgIn().msg().ade().mMovNmri().isNumeric() || 
            msgIn().msg().ade().mMovNmri().isEqual(0))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-12");
            log(TraceLevel.Error, " BGHM1160-M-MOV-NMRI MAL FORMATADO : ", msgIn().msg().ade().mMovNmri());
        }
        /**
         * *-9- VALIDA NUMERO DE CHEQUE NO CASO DAS TRANSACOES COM CHEQUES
         */
        if (envOut.errosGraves().semErros().isTrue() && swSwitchs().swChqhb0ChqBancario().isTrue() && 
            (!msgIn().msg().ade().nCheque().isNumeric() || 
            msgIn().msg().ade().nCheque().isEqual(0))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-13");
            log(TraceLevel.Error, "   BGHM1160-N-CHEQUE MAL FORMATADO : ", msgIn().msg().ade().nCheque());
        }
        /**
         * *-10- NOS CASOS DE CLIENTE NAO CGD ITVT NA OPERACAO
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
            /**
             * *----1- DADOS DO SGOE THE00075 - CLI PARTICULAR / ENI
             */
            if (!msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA) && 
                (msgIn().msg().ade().nmCliente().isEmpty() || 
                msgIn().msg().ade().zNascCli().isEmpty() || 
                msgIn().msg().ade().zNascCli().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zNascCli().isEqual(CON_DATA_MIN) || 
                msgIn().msg().ade().cPaisNacnCli().isEmpty())) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().ncliDadosIncomp());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-14");
                log(TraceLevel.Error, "   DADOS SGOE THE00075 - CLI PARTICULAR/ENI: ");
                log(TraceLevel.Error, "   ", msgIn().msg().ade().nmCliente());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cPaisNacnCli());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().zNascCli());
            }
            /**
             * *----2- DADOS DO SGOE THE00075 - CLI EMPRESA
             */
            if (envOut.errosGraves().semErros().isTrue() && 
                msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA) && 
                (msgIn().msg().ade().nmCliente().isEmpty() || 
                msgIn().msg().ade().zNascCli().isEmpty() || 
                msgIn().msg().ade().zNascCli().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().zNascCli().isEqual(CON_DATA_MIN) || 
                msgIn().msg().ade().cPaisNacnCli().isEmpty() || 
                msgIn().msg().ade().nmEmpRnpc().isEmpty() || 
                msgIn().msg().ade().cAe().isEqual(0) || 
                msgIn().msg().ade().dAe().isEmpty() || 
                msgIn().msg().ade().nIpc().isEmpty())) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().ncliDadosIncomp());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-15");
                log(TraceLevel.Error, "   DADOS SGOE THE00075 - CLI PARTICULAR/ENI: ");
                log(TraceLevel.Error, "   ", msgIn().msg().ade().nmCliente());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cPaisNacnCli());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().zNascCli());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().nmEmpRnpc());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().cAe());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().dAe());
                log(TraceLevel.Error, "   ", msgIn().msg().ade().nIpc());
            }
        }
        /**
         * *-10- CHAVE DE REFERENCIA
         */
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzNao().isTrue() && 
            !swSwitchs().swTrocoDestroco().isTrue() && 
            (msgIn().msg().ade().cPaisIsoAlfn().isEmpty() || 
            msgIn().msg().ade().cPaisIsoAlfn().isEqual(String.valueOf(LOW_VALUES)) || 
            msgIn().msg().ade().cMnemEmpGcx().isEmpty() || 
            msgIn().msg().ade().cMnemEmpGcx().isEqual(String.valueOf(LOW_VALUES)) || 
            msgIn().msg().ade().cRefMsgSwif().isEmpty() || 
            msgIn().msg().ade().cRefMsgSwif().isEqual(String.valueOf(LOW_VALUES)))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-16");
            log(TraceLevel.Error, "   CHAVE DE REFERENCIA MAL FORMATADA: ");
            log(TraceLevel.Error, "   ", msgIn().msg().ade().cPaisIsoAlfn());
            log(TraceLevel.Error, "   ", msgIn().msg().ade().cMnemEmpGcx());
            log(TraceLevel.Error, "   ", msgIn().msg().ade().cRefMsgSwif());
        }
        /**
         * *-11- VALIDA JOURNAL
         */
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzNao().isTrue() && 
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
            log(TraceLevel.Error, " ERRO-17");
            log(TraceLevel.Error, "   CHAVE DE JOURNAL MAL FORMATADO");
            log(TraceLevel.Error, "   Z-PR ", msgIn().msg().ade().nrElectronico().zProcessamento());
            log(TraceLevel.Error, "   MNEM ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
            log(TraceLevel.Error, "   PAIS ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
            log(TraceLevel.Error, "   OE   ", msgIn().msg().ade().nrElectronico().cOeEgcOpex());
            log(TraceLevel.Error, "   USER ", msgIn().msg().ade().nrElectronico().cUserid());
            log(TraceLevel.Error, "   JOUR ", msgIn().msg().ade().nrElectronico().nJourBbn());
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
         * *-1- TIPO DE OPERACAO DE ENTRADA
         */
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swTodosCTipoOpe().isTrue()) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-18");
            log(TraceLevel.Error, "   TIPO DE OPERACAO DE ENTRADA : ", swSwitchs().swCTipoOpeCont());
        }
        /**
         * *-2- CHAVE DE REFERENCIA
         */
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swTrocoDestroco().isTrue() && 
            !swSwitchs().swPi3501EmissChq().isTrue() && 
            (msgIn().msg().ade().cPaisIsoAlfn().isEmpty() || 
            msgIn().msg().ade().cPaisIsoAlfn().isEqual(String.valueOf(LOW_VALUES)) || 
            msgIn().msg().ade().cMnemEmpGcx().isEmpty() || 
            msgIn().msg().ade().cMnemEmpGcx().isEqual(String.valueOf(LOW_VALUES)) || 
            msgIn().msg().ade().cRefMsgSwif().isEmpty() || 
            msgIn().msg().ade().cRefMsgSwif().isEqual(String.valueOf(LOW_VALUES)))) {
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-19");
            log(TraceLevel.Error, "   CHAVE DE REFERENCIA MAL FORMATADA: ");
            log(TraceLevel.Error, "   ", msgIn().msg().ade().cPaisIsoAlfn());
            log(TraceLevel.Error, "   ", msgIn().msg().ade().cMnemEmpGcx());
            log(TraceLevel.Error, "   ", msgIn().msg().ade().cRefMsgSwif());
        }
        /**
         * *-3- VALIDA JOURNAL
         */
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swAnulacoesEstornosRef().isTrue() && 
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
            log(TraceLevel.Error, " ERRO-20");
            log(TraceLevel.Error, "   CHAVE DE JOURNAL MAL FORMATADO");
            log(TraceLevel.Error, "   Z-PR ", msgIn().msg().ade().nrElectronico().zProcessamento());
            log(TraceLevel.Error, "   MNEM ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
            log(TraceLevel.Error, "   PAIS ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
            log(TraceLevel.Error, "   OE   ", msgIn().msg().ade().nrElectronico().cOeEgcOpex());
            log(TraceLevel.Error, "   USER ", msgIn().msg().ade().nrElectronico().cUserid());
            log(TraceLevel.Error, "   JOUR ", msgIn().msg().ade().nrElectronico().nJourBbn());
        }
    }
    
    /**
     * 
     * 1200-INIC-TAB-INTERNAS
     * 
     */
    protected void m1200InicTabInternas() {
        if (wsVariaveis().wsInd().isEqual(CON_1N)) {
            log(TraceLevel.Debug, "  1200-INIC-TAB-INTERNAS");
        }
        wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo().set(" ");
        wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdXCteuCo03().set(" ");
        wsVariaveis().wsInd().add(CON_1N);
    }
    
    /**
     * 
     * *GH2024--> INICIO
     * 1201-INIC-TAB-INT-DOC
     * 
     */
    protected void m1201InicTabIntDoc() {
        if (wsVariaveis().wsInd().isEqual(CON_1N)) {
            log(TraceLevel.Debug, "  1201-INIC-TAB-INT-DOC ");
        }
        /**
         * PERFORM UNTIL WS-IND > CON-250N
         */
        wsTabInternaDoc().wsZVldDocumento().get(wsVariaveis().wsInd()).wsTabZVldeDoc().set(" ");
        wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdXCteuCo03().set(" ");
    }
    
    /**
     * 
     * *GH2204--> FIM
     * 1300-VAL-CLIENTE-ITVT
     * 
     */
    protected void m1300ValClienteItvt() {
        log(TraceLevel.Debug, "  1300-VAL-CLIENTE-ITVT");
        log(TraceLevel.Debug, "   BGHM1160-I-CLI-CGD  : ", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1160-N-CLIENTE  : ", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1160-NM-CLIENTE : ", msgIn().msg().ade().nmCliente());
        /**
         * -- CLIENTE NAO CGD
         */
        if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
            m1305ValidaDocAptd() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                m1310ValidaCliNaoCgd() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                if (msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                    if (bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS().isEqual(msgIn().msg().ade().cPaisIsaEmsDoc()) && 
                        bhel100a().commarea().dadosSaida().cTipoDocIdS().isEqual(msgIn().msg().ade().cTipoDocId())) {
                        if (!bhel100a().commarea().dadosSaida().nDocIdS().isEqual(msgIn().msg().ade().nDocId())) {
                            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nDocAptdNcliDif());
                            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                            envOut.errosGraves().errosFuncao().setTrue() ;
                            log(TraceLevel.Error, " ERRO-21");
                        }
                    } else {
                        m1320ValDocCliNcgd() ;
                    }
                } else {
                    /**
                     * ----------- DOCUMENTO PRINCIPAL DO NAO CLIENTE PART/ENI
                     */
                    msgIn().msg().ade().cPaisIsaEmsDoc().set(bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS());
                    msgOut().msg().ade().cPaisIsaEmsDoc().set(bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS());
                    msgIn().msg().ade().cTipoDocId().set(bhel100a().commarea().dadosSaida().cTipoDocIdS());
                    msgOut().msg().ade().cTipoDocId().set(bhel100a().commarea().dadosSaida().cTipoDocIdS());
                    msgIn().msg().ade().nDocId().set(bhel100a().commarea().dadosSaida().nDocIdS());
                    msgOut().msg().ade().nDocId().set(bhel100a().commarea().dadosSaida().nDocIdS());
                    msgIn().msg().ade().zVldeDocId().set(bhel100a().commarea().dadosEntrada().zVldeDocId());
                    msgOut().msg().ade().zVldeDocId().set(bhel100a().commarea().dadosEntrada().zVldeDocId());
                    msgIn().msg().ade().cEntEmixDocId().set(bhel100a().commarea().dadosEntrada().cEntEmixDocId());
                    msgOut().msg().ade().cEntEmixDocId().set(bhel100a().commarea().dadosEntrada().cEntEmixDocId());
                    /**
                     * -----------
                     */
                    if (bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS().isEqual(msgIn().msg().ade().cPaisEmsDocApt()) && 
                        bhel100a().commarea().dadosSaida().cTipoDocIdS().isEqual(msgIn().msg().ade().cTipoDocIdAptd())) {
                        if (!bhel100a().commarea().dadosSaida().nDocIdS().isEqual(msgIn().msg().ade().nDocIdAptd())) {
                            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nDocAptdNcliDif());
                            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                            envOut.errosGraves().errosFuncao().setTrue() ;
                            log(TraceLevel.Error, " ERRO-22");
                        }
                    } else {
                        m1320ValDocCliNcgd() ;
                    }
                }
            }
        }
        /**
         * -- CLIENTE CGD
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
            wsVariaveis().wsBhjl006aNCliente().set(msgIn().msg().ade().nCliente());
            m1330ValBasicosCli() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                msgIn().msg().ade().nCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
                msgOut().msg().ade().nCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
                wsVariaveis().wsBhjl470aNCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
                msgIn().msg().ade().nsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                msgOut().msg().ade().nsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                wsVariaveis().wsBhjl470aNsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                msgIn().msg().ade().nmCliente().set(bhjl006a().commarea().dadosSaida().nmCliente());
                msgOut().msg().ade().nmCliente().set(bhjl006a().commarea().dadosSaida().nmCliente());
                if (!bhjl006a().commarea().dadosSaida().cTipoCli().isEqual(CON_PARTICULAR)) {
                    msgOut().msg().ade().nmEmpRnpc().set(bhjl006a().commarea().dadosSaida().nmCliente());
                }
                swSwitchs().swValidaTipoCliItvt().set(bhjl006a().commarea().dadosSaida().cTipoCli());
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1340ObtemMaisDadosCli() ;
            }
            /**
             * ----- NO CASO CLIENTE CGD, PASSARA A PEDIR SEMPRE O DOCUMENTO AO
             * BALCAO - DOC ID APRESENTADO - QUE DEVE SER VALIDADO.
             */
            if (envOut.errosGraves().semErros().isTrue() && 
                !msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                m1350ValidaNDocCli() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1360ObtemFiltering() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1370ObtemDocPrinItvt() ;
            }
        }
    }
    
    /**
     * 
     * 1305-VALIDA-DOC-APTD
     * 
     */
    protected void m1305ValidaDocAptd() {
        log(TraceLevel.Debug, "   1305-VALIDA-DOC-APTD   ");
        if (msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISA-EMS-DOC: ", msgIn().msg().ade().cPaisIsaEmsDoc());
            log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID     : ", msgIn().msg().ade().cTipoDocId());
            log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID          : ", msgIn().msg().ade().nDocId());
        } else {
            log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-APT: ", msgIn().msg().ade().cPaisEmsDocApt());
            log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-APTD: ", msgIn().msg().ade().cTipoDocIdAptd());
            log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-APTD     : ", msgIn().msg().ade().nDocIdAptd());
        }
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        if (msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
            bhjl027a().commarea().dadosEntrada().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
            bhjl027a().commarea().dadosEntrada().nDocId().set(msgIn().msg().ade().nDocId());
        } else {
            bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
            bhjl027a().commarea().dadosEntrada().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
            bhjl027a().commarea().dadosEntrada().nDocId().set(msgIn().msg().ade().nDocIdAptd());
        }
        bhjp5027AcedeMhjj027a() ;
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
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().itvtOpexCliCgd());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-23");
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!bhjl027a().commarea().erros().semErros().isTrue() && !bhjl027a().commarea().erros().clienteNaoExiste().isTrue() && 
                !bhjl027a().commarea().erros().docNaoExis().isTrue() && 
                !bhjl027a().commarea().erros().cliCancelado().isTrue()) {
                envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-24");
            }
        }
    }
    
    /**
     * 
     * 1310-VALIDA-CLI-NAO-CGD
     * 
     */
    protected void m1310ValidaCliNaoCgd() {
        log(TraceLevel.Debug, "   1310-VALIDA-CLI-NAO-CGD");
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISOA-OE-OPX: ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1160-C-MNEM-EGC-OPEX   : ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1160-N-CLIENTE         : ", msgIn().msg().ade().nCliente());
        wsVariaveis().wsBhel100aNPrcpNcli().set(msgIn().msg().ade().nCliente());
        m1311AcedeMhej100aCli() ;
        log(TraceLevel.Debug, "   SAIDA MHEJ100A...           ");
        if (envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ade().cTipoCli().set(bhel100a().commarea().dadosSaida().cTipoNcliS());
            msgOut().msg().ade().nCliente().set(bhel100a().commarea().dadosSaida().nPrcpNcliS());
            msgOut().msg().ade().nsAbraCli().set(0);
            msgOut().msg().ade().zNascCli().set(bhel100a().commarea().dadosSaida().zNascNcliS());
            msgOut().msg().ade().cPaisNacnCli().set(bhel100a().commarea().dadosSaida().cPaisNacnNcliS());
            msgOut().msg().ade().nmCliente().set(bhel100a().commarea().dadosSaida().nmPrcpNcliS());
            wsVariaveis().wsCPaisDocPcl().set(bhel100a().commarea().dadosSaida().cPaisEmsDocPS());
            wsVariaveis().wsCTipoDocPcl().set(bhel100a().commarea().dadosSaida().cTipoDocIdPS());
            msgOut().msg().ade().nIpc().set(bhel100a().commarea().dadosSaida().nDocIdPclvS());
            msgOut().msg().ade().nmEmpRnpc().set(bhel100a().commarea().dadosSaida().nmEmpRnpcS());
            msgOut().msg().ade().cAe().set(bhel100a().commarea().dadosSaida().cAeS());
            msgOut().msg().ade().dAe().set(bhel100a().commarea().dadosSaida().dAeS());
            msgOut().msg().ade().iInszDocIdCli().set(CON_NAO);
        }
    }
    
    /**
     * 
     * 1311-ACEDE-MHEJ100A-CLI
     * 
     */
    protected void m1311AcedeMhej100aCli() {
        log(TraceLevel.Debug, "    1311-ACEDE-MHEJ100A-CLI");
        bhel100a().commarea().initialize() ;
        bhel100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bhel100a().commarea().dadosEntrada().iOperacao().set(CON_1N);
        bhel100a().commarea().dadosEntrada().cPaisIsoaOpe().set(msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        bhel100a().commarea().dadosEntrada().cMnemEgcOpe().set(msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        /**
         * -- CLIENTE ITVT OU RPRT
         */
        bhel100a().commarea().dadosEntrada().nPrcpNcli().set(wsVariaveis().wsBhel100aNPrcpNcli());
        bhep5100TabNaoClientes() ;
        if (!bhel100a().commarea().dadosSaida().semErros().isTrue()) {
            envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
            envOut.db2Log().nmTabela().set(bhel100a().commarea().dadosSaida().nmTabela());
            if (bhel100a().commarea().dadosSaida().errosFuncao().isTrue()) {
                envOut.errosGraves().aAplErr().set(bhel100a().commarea().dadosSaida().aAplErr());
                envOut.errosGraves().cTipoErroBbn().set(bhel100a().commarea().dadosSaida().cTipoErroBbn());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-25");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-26");
            }
            log(TraceLevel.Error, "   ERRO NA ROTINA MHEJ100A - VALIDA CLI");
            log(TraceLevel.Error, "   BHEL100A-C-TIPO-ERRO-BBN  : ", bhel100a().commarea().dadosSaida().cTipoErroBbn());
            log(TraceLevel.Error, "   BHEL100A-A-APL-ERR        : ", bhel100a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "   BHEL100A-C-RTNO-EVEN-SWAL : ", bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "      DADOS-INPUT-INVALIDOS...... +009");
            log(TraceLevel.Error, "      ERRO-SEL-VHE07501.......... +010");
            log(TraceLevel.Error, "      ERRO-INS-VHE07501.......... +011");
            log(TraceLevel.Error, "      ERRO-UPD-VHE07501.......... +012");
            log(TraceLevel.Error, "      NAO-EXISTEM-DADOS.......... +053");
            log(TraceLevel.Error, "      NAO-CLIENTE-INEXIST........ +059");
            log(TraceLevel.Error, "      NAO-CLIENTE-JA-EXIST....... +074");
            log(TraceLevel.Error, "      DOCUMENTO-JA-EXISTE........ +108");
            log(TraceLevel.Error, "      CLIENTE-CGD................ +109");
            log(TraceLevel.Error, "   BHEL100A-C-SQLCODE        : ", bhel100a().commarea().dadosSaida().cSqlcode());
            log(TraceLevel.Error, "   BHEL100A-NM-TABELA        : ", bhel100a().commarea().dadosSaida().nmTabela());
        }
    }
    
    /**
     * 
     * 1320-VAL-DOC-CLI-NCGD
     * 
     */
    protected void m1320ValDocCliNcgd() {
        log(TraceLevel.Debug, "   1320-VAL-DOC-CLI-NCGD");
        if (msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISA-EMS-DOC: ", msgIn().msg().ade().cPaisIsaEmsDoc());
            log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID     : ", msgIn().msg().ade().cTipoDocId());
            log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID          : ", msgIn().msg().ade().nDocId());
        } else {
            log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-APT: ", msgIn().msg().ade().cPaisEmsDocApt());
            log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-APTD: ", msgIn().msg().ade().cTipoDocIdAptd());
            log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-APTD     : ", msgIn().msg().ade().nDocIdAptd());
        }
        if (msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            wsVariaveis().wsBhel100aCPaisIsaDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
            wsVariaveis().wsBhel100aCTipoDocId().set(msgIn().msg().ade().cTipoDocId());
            wsVariaveis().wsBhel100aNDocId().set(msgIn().msg().ade().nDocId());
        } else {
            wsVariaveis().wsBhel100aCPaisIsaDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
            wsVariaveis().wsBhel100aCTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
            wsVariaveis().wsBhel100aNDocId().set(msgIn().msg().ade().nDocIdAptd());
        }
        m1321AcedeMhej100aDoc() ;
        log(TraceLevel.Debug, "   SAIDA MHEJ100A...           ");
        log(TraceLevel.Debug, "   BHEL100A-C-PAIS-ISOA-OPE-S : ", bhel100a().commarea().dadosSaida().cPaisIsoaOpeS());
        log(TraceLevel.Debug, "   BHEL100A-C-MNEM-EGC-OPE-S  : ", bhel100a().commarea().dadosSaida().cMnemEgcOpeS());
        log(TraceLevel.Debug, "   BHEL100A-N-PRCP-NCLI-S     : ", bhel100a().commarea().dadosSaida().nPrcpNcliS());
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!bhel100a().commarea().dadosSaida().nPrcpNcliS().isEqual(msgIn().msg().ade().nCliente()) && 
                !bhel100a().commarea().dadosEntrada().nPrcpNcli().isEqual(0)) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().docAptdOutNcli());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-27");
            }
        }
    }
    
    /**
     * 
     * 1321-ACEDE-MHEJ100A-DOC
     * 
     */
    protected void m1321AcedeMhej100aDoc() {
        log(TraceLevel.Debug, "    1321-ACEDE-MHEJ100A-DOC");
        bhel100a().commarea().initialize() ;
        bhel100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bhel100a().commarea().dadosEntrada().iOperacao().set(CON_3N);
        bhel100a().commarea().dadosEntrada().cPaisIsoaOpe().set(msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        bhel100a().commarea().dadosEntrada().cMnemEgcOpe().set(msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        /**
         * -- DOCUMENTO APTD OU RPRT
         */
        bhel100a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(wsVariaveis().wsBhel100aCPaisIsaDoc());
        bhel100a().commarea().dadosEntrada().cTipoDocId().set(wsVariaveis().wsBhel100aCTipoDocId());
        bhel100a().commarea().dadosEntrada().nDocId().set(wsVariaveis().wsBhel100aNDocId());
        bhep5100TabNaoClientes() ;
        if (!bhel100a().commarea().dadosSaida().semErros().isTrue()) {
            if (bhel100a().commarea().dadosSaida().errosFuncao().isTrue()) {
                if (!bhel100a().commarea().dadosSaida().naoClienteInexist().isTrue()) {
                    envOut.errosGraves().aAplErr().set(bhel100a().commarea().dadosSaida().aAplErr());
                    envOut.errosGraves().cTipoErroBbn().set(bhel100a().commarea().dadosSaida().cTipoErroBbn());
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
                    envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
                    envOut.db2Log().nmTabela().set(bhel100a().commarea().dadosSaida().nmTabela());
                    log(TraceLevel.Error, " ERRO-28");
                }
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
                envOut.db2Log().nmTabela().set(bhel100a().commarea().dadosSaida().nmTabela());
                log(TraceLevel.Error, " ERRO-29");
            }
            log(TraceLevel.Error, "   ERRO NA ROTINA MHEJ100A - VALIDA DOC");
            log(TraceLevel.Error, "   BHEL100A-C-TIPO-ERRO-BBN  : ", bhel100a().commarea().dadosSaida().cTipoErroBbn());
            log(TraceLevel.Error, "   BHEL100A-A-APL-ERR        : ", bhel100a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "   BHEL100A-C-RTNO-EVEN-SWAL : ", bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "      DADOS-INPUT-INVALIDOS...... +009");
            log(TraceLevel.Error, "      ERRO-SEL-VHE07501.......... +010");
            log(TraceLevel.Error, "      ERRO-INS-VHE07501.......... +011");
            log(TraceLevel.Error, "      ERRO-UPD-VHE07501.......... +012");
            log(TraceLevel.Error, "      NAO-EXISTEM-DADOS.......... +053");
            log(TraceLevel.Error, "      NAO-CLIENTE-INEXIST........ +059");
            log(TraceLevel.Error, "      NAO-CLIENTE-JA-EXIST....... +074");
            log(TraceLevel.Error, "      DOCUMENTO-JA-EXISTE........ +108");
            log(TraceLevel.Error, "      CLIENTE-CGD................ +109");
            log(TraceLevel.Error, "   BHEL100A-C-SQLCODE        : ", bhel100a().commarea().dadosSaida().cSqlcode());
            log(TraceLevel.Error, "   BHEL100A-NM-TABELA        : ", bhel100a().commarea().dadosSaida().nmTabela());
        }
    }
    
    /**
     * 
     * 1330-VAL-BASICOS-CLI
     * 
     */
    protected void m1330ValBasicosCli() {
        log(TraceLevel.Debug, "   1330-VAL-BASICOS-CLI");
        log(TraceLevel.Debug, "   WS-BHJL006A-N-CLIENTE: ", wsVariaveis().wsBhjl006aNCliente());
        bhjl006a().commarea().initialize() ;
        bhjl006a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl006a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl006a().commarea().dadosEntrada().nCliente().set(wsVariaveis().wsBhjl006aNCliente());
        bhjp6006AcedeMhjs006a() ;
        if (bhjl006a().commarea().erros().erroFuncao().isTrue() && bhjl006a().commarea().erros().clienteNaoExiste().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl006a().commarea().erros().aAplErr());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl006a().commarea().erros().cRtnoEvenSwal());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-30");
        }
        if (!bhjl006a().commarea().erros().fimConsulta().isTrue() && !bhjl006a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl006a().commarea().erros().aAplErr());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl006a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl006a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl006a().commarea().erros().nmTabela());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-31");
            log(TraceLevel.Error, "   BHJL006A-C-TIPO-ERRO-BBN  : ", bhjl006a().commarea().erros().cTipoErroBbn());
            log(TraceLevel.Error, "   BHJL006A-A-APL-ERR        : ", bhjl006a().commarea().erros().aAplErr());
            log(TraceLevel.Error, "   BHJL006A-C-RTNO-EVEN-SWAL : ", bhjl006a().commarea().erros().cRtnoEvenSwal());
            log(TraceLevel.Error, "   BHJL006A-C-SQLCODE        : ", bhjl006a().commarea().erros().cSqlcode());
            log(TraceLevel.Error, "   BHJL006A-NM-TABELA        : ", bhjl006a().commarea().erros().nmTabela());
        }
    }
    
    /**
     * 
     * 1340-OBTEM-MAIS-DADOS-CLI
     * 
     */
    protected void m1340ObtemMaisDadosCli() {
        log(TraceLevel.Debug, "   1340-OBTEM-MAIS-DADOS-CLI");
        if (envOut.errosGraves().semErros().isTrue()) {
            m1341ObtemDadosCompCli() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!msgOut().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                swSwitchs().swBuscaDocSim().setTrue() ;
                swSwitchs().swDoc().set(" ");
                while (!swSwitchs().swBuscaDocNao().isTrue() && envOut.errosGraves().semErros().isTrue()) {
                    m1342ObtemNif() ;
                }
            } else {
                msgOut().msg().ade().nIpc().set(msgIn().msg().ade().nDocId());
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && 
            !msgOut().msg().ade().cTipoCli().isEqual(CON_PARTICULAR)) {
            m1343ObtemCae() ;
        }
    }
    
    /**
     * 
     * 1341-OBTEM-DADOS-COMP-CLI
     * 
     */
    protected void m1341ObtemDadosCompCli() {
        log(TraceLevel.Debug, "    1341-OBTEM-DADOS-COMP-CLI");
        bhjl014a().commarea().initialize() ;
        bhjl014a().commarea().dadosEntrada().nCliente().set(msgOut().msg().ade().nCliente());
        bhjl014a().commarea().dadosEntrada().nsAbraCli().set(msgOut().msg().ade().nsAbraCli());
        bhjp5014AcedeMhjj014a() ;
        if (!bhjl014a().commarea().erros().semErros().isTrue()) {
            if (bhjl014a().commarea().erros().abendDb2().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl014a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl014a().commarea().erros().nmTabela());
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhjl014a().commarea().erros().cTipoErroBbn());
                envOut.errosGraves().aAplErr().set(bhjl014a().commarea().erros().aAplErr());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl014a().commarea().erros().cRtnoEvenSwal());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                log(TraceLevel.Error, " ERRO-32");
            }
        } else {
            msgOut().msg().ade().cTipoCli().set(bhjl014a().commarea().dadosEntrada().cTipoCli());
            /**
             * -- SE CLIENTE EMPRESA
             */
            if (bhjl014a().commarea().dadosEntrada().cTipoCli().isEqual(CON_EMPRESA)) {
                msgOut().msg().ade().zNascCli().set(bhjl014a().commarea().dadosSaida().zCstzEmp());
                msgOut().msg().ade().cPaisNacnCli().set(bhjl014a().commarea().dadosSaida().cPaisIsoaEmp());
            } else {
                /**
                 * -- SE CLIENTE PARTICULAR/ENI
                 */
                msgOut().msg().ade().zNascCli().set(bhjl014a().commarea().dadosSaida().zNascCli());
                msgOut().msg().ade().cPaisNacnCli().set(bhjl014a().commarea().dadosSaida().cPaisIsoaNacn());
            }
        }
    }
    
    /**
     * 
     * 1342-OBTEM-NIF
     * 
     */
    protected void m1342ObtemNif() {
        log(TraceLevel.Debug, "    1342-OBTEM-NIF");
        bhjl628a().commarea().initialize() ;
        bhjl628a().commarea().visualizacao().setTrue() ;
        bhjl628a().commarea().thj00023Docid().dadosInput().nCliente().set(msgOut().msg().ade().nCliente());
        bhjl628a().commarea().thj00023Docid().dadosInput().nsAbraCli().set(msgOut().msg().ade().nsAbraCli());
        if (!swSwitchs().swDocNok().isTrue()) {
            bhjl628a().commarea().thj00023Docid().dadosInput().cPaisIsaEmsDoc().set(conDocNif().conNifCPais());
            bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().set(conDocNif().conNifTDoc());
        } else {
            bhjl628a().commarea().thj00023Docid().dadosInput().cPaisIsaEmsDoc().set(conDocNfePs().conNfeCPais());
            bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().set(conDocNfePs().conNfeTDoc());
        }
        log(TraceLevel.Debug, "   BHJL628A-C-TIPO-DOC-ID : ", bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId());
        bhjp0628Mhjj628a() ;
        if (bhjl628a().commarea().dadosErro().semErros().isTrue()) {
            swSwitchs().swBuscaDocNao().setTrue() ;
            swSwitchs().swDocOk().setTrue() ;
            msgOut().msg().ade().nIpc().set(bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId());
        } else if (bhjl628a().commarea().dadosErro().abendDb2().isTrue()) {
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl628a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl628a().commarea().dadosErro().nmTabela());
        } else if (bhjl628a().commarea().dadosErro().docNaoExis().isTrue()) {
            swSwitchs().swBuscaDocSim().setTrue() ;
            swSwitchs().swDocNok().setTrue() ;
        }
        if (bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().isEqual(conDocNfePs().conNfeTDoc())) {
            swSwitchs().swBuscaDocNao().setTrue() ;
        }
    }
    
    /**
     * 
     * 1343-OBTEM-CAE
     * 
     */
    protected void m1343ObtemCae() {
        log(TraceLevel.Debug, "    1343-OBTEM-CAE     ");
        bhjl042a().commarea().initialize() ;
        bhjl042a().commarea().dadosEntrada().nCliente().set(msgOut().msg().ade().nCliente());
        bhjl042a().commarea().dadosEntrada().nsAbraCli().set(msgOut().msg().ade().nsAbraCli());
        bhjl042a().commarea().dadosEntrada().obtemUma().setTrue() ;
        bhjp5042AcedeMhjj042a() ;
        if (!bhjl042a().commarea().erros().semErros().isTrue()) {
            if (!bhjl042a().commarea().erros().fimConsulta().isTrue()) {
                if (bhjl042a().commarea().erros().abendDb2().isTrue()) {
                    envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                    envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                    envOut.db2Log().sqlca().cSqlcode().set(bhjl042a().commarea().erros().cSqlcode());
                    envOut.db2Log().nmTabela().set(bhjl042a().commarea().erros().nmTabela());
                }
            }
        } else {
            msgOut().msg().ade().cAe().set(bhjl042a().commarea().dadosSaida().get(1).cAe());
        }
    }
    
    /**
     * 
     * 1350-VALIDA-N-DOC-CLI
     * 
     */
    protected void m1350ValidaNDocCli() {
        log(TraceLevel.Debug, "   1350-VALIDA-N-DOC-CLI");
        log(TraceLevel.Debug, "   BGHM1160-N-CLIENTE            : ", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1160-NS-ABRA-CLI          : ", msgIn().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-APT   : ", msgIn().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-APTD   : ", msgIn().msg().ade().cTipoDocIdAptd());
        swSwitchs().swValidaNDocCliAptd().setTrue() ;
        bhjl628a().commarea().initialize() ;
        bhjl628a().commarea().visualizacao().setTrue() ;
        bhjl628a().commarea().thj00023Docid().dadosInput().nCliente().set(msgIn().msg().ade().nCliente());
        bhjl628a().commarea().thj00023Docid().dadosInput().nsAbraCli().set(msgIn().msg().ade().nsAbraCli());
        /**
         * -- TIPO DE DOCUMENTO APRESENTADO
         */
        bhjl628a().commarea().thj00023Docid().dadosInput().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
        bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
        bhjp0628Mhjj628a() ;
        log(TraceLevel.Debug, "   SAIDA MHJJ628A.............. ");
        log(TraceLevel.Debug, "   BHJL628A-N-DOC-ID          : ", bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId());
        log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-APTD     : ", msgIn().msg().ade().nDocIdAptd());
        log(TraceLevel.Debug, "   BHJL628A-C-TIPO-ERRO-BBN   : ", bhjl628a().commarea().dadosErro().cTipoErroBbn());
        log(TraceLevel.Debug, "   BHJL628A-A-APL-ERR         : ", bhjl628a().commarea().dadosErro().aAplErr());
        log(TraceLevel.Debug, "   BHJL628A-C-RTNO-EVEN-SWAL  : ", bhjl628a().commarea().dadosErro().cRtnoEvenSwal());
        log(TraceLevel.Debug, "    --DOC-NAO-EXIS ...... +535");
        log(TraceLevel.Debug, "    --DOC-EXISTE ........ +539");
        if (bhjl628a().commarea().dadosErro().semErros().isTrue()) {
            if (!bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId().isEqual(msgIn().msg().ade().nDocIdAptd())) {
                /**
                 * ------ CLIENTE CGD COM DOC ID APRESENTADO CARREGADO NA BASE DE
                 * DADOS, MAS COM NUMERO DE DOC ID DIFERENTE
                 */
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nDocAptdDiferente());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-33");
            }
        } else if (bhjl628a().commarea().dadosErro().docNaoExis().isTrue()) {
            /**
             * --       SE TIPO DOCUMENTO NAO ESTA ATRIBUIDO AO CLIENTE CGD
             * VAMOS VER DOC APRESENTADO PERTENCE A OUTRO CLIENTE CGD
             */
            wsVariaveis().wsBhjl027aCPaisIsaDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
            wsVariaveis().wsBhjl027aCTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
            wsVariaveis().wsBhjl027aNDocId().set(msgIn().msg().ade().nDocIdAptd());
            m1351VerificExistDoc() ;
        } else {
            envOut.errosGraves().aAplErr().set(bhjl628a().commarea().dadosErro().aAplErr());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl628a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl628a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl628a().commarea().dadosErro().nmTabela());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-34");
        }
    }
    
    /**
     * 
     * 1351-VERIFIC-EXIST-DOC
     * 
     */
    protected void m1351VerificExistDoc() {
        log(TraceLevel.Debug, "    1351-VERIFIC-EXIST-DOC");
        log(TraceLevel.Debug, "   SW-VALIDA-N-DOC-CLI (A / R): ", swSwitchs().swValidaNDocCli());
        log(TraceLevel.Debug, "   WS-BHJL027A-C-PAIS-ISA-DOC : ", wsVariaveis().wsBhjl027aCPaisIsaDoc());
        log(TraceLevel.Debug, "   WS-BHJL027A-C-TIPO-DOC-ID  : ", wsVariaveis().wsBhjl027aCTipoDocId());
        log(TraceLevel.Debug, "   WS-BHJL027A-N-DOC-ID       : ", wsVariaveis().wsBhjl027aNDocId());
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(wsVariaveis().wsBhjl027aCPaisIsaDoc());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(wsVariaveis().wsBhjl027aCTipoDocId());
        bhjl027a().commarea().dadosEntrada().nDocId().set(wsVariaveis().wsBhjl027aNDocId());
        bhjp5027AcedeMhjj027a() ;
        log(TraceLevel.Debug, "   BHJL027A-N-CLIENTE         : ", bhjl027a().commarea().dadosSaida().nCliente());
        log(TraceLevel.Debug, "   BHJL027A-NS-ABRA-CLI       : ", bhjl027a().commarea().dadosSaida().nsAbraCli());
        log(TraceLevel.Debug, "   BHJL027A-C-TIPO-ERRO-BBN   : ", bhjl027a().commarea().erros().cTipoErroBbn());
        log(TraceLevel.Debug, "   BHJL027A-A-APL-ERR         : ", bhjl027a().commarea().erros().aAplErr());
        log(TraceLevel.Debug, "   BHJL027A-C-RTNO-EVEN-SWAL  : ", bhjl027a().commarea().erros().cRtnoEvenSwal());
        log(TraceLevel.Debug, "    --CLIENTE-NAO-EXISTE .... +002");
        log(TraceLevel.Debug, "    --INPUT-INSUF ........... +501");
        log(TraceLevel.Debug, "    --CLIENTE-CONFIDENCIAL .. +506");
        log(TraceLevel.Debug, "    --DOC-NAO-EXIS .......... +535");
        log(TraceLevel.Debug, "    --DOC-REPETIDO .......... +536");
        log(TraceLevel.Debug, "    --CLI-CANCELADO ......... +622");
        if (bhjl027a().commarea().erros().semErros().isTrue() || bhjl027a().commarea().erros().fimConsulta().isTrue() || 
            (bhjl027a().commarea().erros().erroFuncao().isTrue() && bhjl027a().commarea().erros().clienteConfidencial().isTrue())) {
            /**
             * -- O DOCUMENTO EXISTE E NAO PERTENCE AO CLIENTE DO DOC ID APTD
             * -- OU DOC ID APTD DO REPRESENTANTE
             */
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            if (swSwitchs().swValidaNDocCliAptd().isTrue()) {
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().docAptdOutroCli());
            } else if (swSwitchs().swValidaNDocCliRprt().isTrue()) {
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().docAptdRptOutCli());
            }
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-35");
            log(TraceLevel.Debug, "    1351-VERIFIC-EXIST-DOC");
            log(TraceLevel.Debug, "   BHJL027A-N-CLIENTE         : ", bhjl027a().commarea().dadosSaida().nCliente());
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!bhjl027a().commarea().erros().semErros().isTrue() && !bhjl027a().commarea().erros().fimConsulta().isTrue()) {
                if (bhjl027a().commarea().erros().docNaoExis().isTrue()) {
                    if (swSwitchs().swValidaNDocCliAptd().isTrue()) {
                        msgOut().msg().ade().iInszDocIdCli().set(CON_SIM);
                    } else if (swSwitchs().swValidaNDocCliRprt().isTrue()) {
                        msgOut().msg().ade().iInszDocCliRpt().set(CON_SIM);
                    }
                }
                if (bhjl027a().commarea().erros().docRepetido().isTrue()) {
                    if (swSwitchs().swValidaNDocCliAptd().isTrue()) {
                        msgOut().msg().ade().iInszDocIdCli().set(CON_NAO);
                    } else if (swSwitchs().swValidaNDocCliRprt().isTrue()) {
                        msgOut().msg().ade().iInszDocCliRpt().set(CON_NAO);
                    }
                    envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().docAptdOutroCli());
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                    envOut.errosGraves().errosFuncao().setTrue() ;
                    log(TraceLevel.Error, " ERRO-36");
                }
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && !bhjl027a().commarea().erros().docNaoExis().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-37");
        }
    }
    
    /**
     * 
     * 1360-OBTEM-FILTERING
     * 
     */
    protected void m1360ObtemFiltering() {
        log(TraceLevel.Debug, "    1360-OBTEM-FILTERING");
        log(TraceLevel.Debug, "   WS-BHJL470A-N-CLIENTE       : ", wsVariaveis().wsBhjl470aNCliente());
        log(TraceLevel.Debug, "   WS-BHJL470A-NS-ABRA-CLI     : ", wsVariaveis().wsBhjl470aNsAbraCli());
        bhjl470a().commarea().initialize() ;
        bhjl470a().commarea().dadosInput().visualizacao().setTrue() ;
        bhjl470a().commarea().dadosInOut().nCliente().set(wsVariaveis().wsBhjl470aNCliente());
        bhjl470a().commarea().dadosInOut().nsAbraCli().set(wsVariaveis().wsBhjl470aNsAbraCli());
        bhjp5470AcedeMhjj470a() ;
        if (!bhjl470a().commarea().erros().semErros().isTrue()) {
            if (bhjl470a().commarea().erros().abendDb2().isTrue()) {
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl470a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl470a().commarea().erros().nmTabela());
                log(TraceLevel.Error, " ERRO-38");
            } else {
                envOut.errosGraves().aAplErr().set(bhjl470a().commarea().erros().aAplErr());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl470a().commarea().erros().cRtnoEvenSwal());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl470a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl470a().commarea().erros().nmTabela());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-39");
            }
        } else {
            msgOut().msg().ade().cEstCliFltg().set(bhjl470a().commarea().dadosInOut().cEstCliFltg());
            msgOut().msg().ade().cPfiRisBrqmCap().set(bhjl470a().commarea().dadosInOut().cPfiRisBrqmCap());
            log(TraceLevel.Debug, "   FILTERING CLIENTE           : ", swSwitchs().swValidaNDocCli());
            log(TraceLevel.Debug, "      CLI-APTD ............. A");
            log(TraceLevel.Debug, "      CLI-RPRT ............. R");
            log(TraceLevel.Debug, "   BGHM1161-C-EST-CLI-FLTG     : ", msgOut().msg().ade().cEstCliFltg());
            log(TraceLevel.Debug, "      CLI-LIMPO ........... 00");
            log(TraceLevel.Debug, "      CLI-SANCIONADO ...... 01");
            log(TraceLevel.Debug, "      CLI-PEP ............. 02");
            log(TraceLevel.Debug, "      CLI-DUV-SANCIONADO .. 03");
            log(TraceLevel.Debug, "      CLI-DUV-PEP ......... 04");
            log(TraceLevel.Debug, "      CLI-PEP-N-AUT ....... 05");
            log(TraceLevel.Debug, "      CLI-N-FILTRADO ...... 06");
            log(TraceLevel.Debug, "   BGHM1160-C-PFI-RIS-BRQM-CAP : ", msgIn().msg().ade().cPfiRisBrqmCap());
            log(TraceLevel.Debug, "      C-PERFIL-ALTO ........ A");
            log(TraceLevel.Debug, "      C-PERFIL-MEDIO ....... M");
            log(TraceLevel.Debug, "      C-PERFIL-BAIXO ....... B");
        }
    }
    
    /**
     * 
     * 1370-OBTEM-DOC-PRIN-ITVT
     * 
     */
    protected void m1370ObtemDocPrinItvt() {
        log(TraceLevel.Debug, "  1370-OBTEM-DOC-PRIN-ITVT");
        log(TraceLevel.Debug, "   SW-VALIDA-TIPO-CLI-ITVT  : ", swSwitchs().swValidaTipoCliItvt());
        if (swSwitchs().swCliEmpresaItvt().isTrue()) {
            if (msgIn().msg().ade().cPaisIsaEmsDoc().isEqual(conDocNipc().conNipcCPais()) && 
                msgIn().msg().ade().cTipoDocId().isEqual(conDocNipc().conNipcTDoc())) {
                wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNipc());
            } else if (msgIn().msg().ade().cPaisIsaEmsDoc().isEqual(conDocNfie().conNfieCPais()) && 
                msgIn().msg().ade().cTipoDocId().isEqual(conDocNfie().conNfieTDoc())) {
                wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNfie());
            } else if (msgIn().msg().ade().cPaisIsaEmsDoc().isEqual(conDocNpc().conNpcCPais()) && 
                msgIn().msg().ade().cTipoDocId().isEqual(conDocNpc().conNpcTDoc())) {
                wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNpc());
            } else if (msgIn().msg().ade().cPaisIsaEmsDoc().isEqual(conDocNife().conNifeCPais()) && 
                msgIn().msg().ade().cTipoDocId().isEqual(conDocNife().conNifeTDoc())) {
                wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNife());
            } else {
                wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNipc());
                wsTabelasInternas().wsTipoDocumento().get(2).wsTdCCodigo().set(conDocNfie());
                wsTabelasInternas().wsTipoDocumento().get(3).wsTdCCodigo().set(conDocNpc());
                wsTabelasInternas().wsTipoDocumento().get(4).wsTdCCodigo().set(conDocNife());
            }
        } else {
            bhgl052a().commarea().initialize() ;
            wsVariaveis().wsInd().set(CON_1N);
            swSwitchs().swEmCiclo().setTrue() ;
            while (!swSwitchs().swFimCiclo().isTrue()) {
                m1371ObtemTpDoc() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1372OrdenaTabInterna() ;
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsNCliente().set(msgIn().msg().ade().nCliente());
            wsVariaveis().wsNsAbraCli().set(msgIn().msg().ade().nsAbraCli());
            wsVariaveis().wsInd().set(CON_1N);
            swSwitchs().swDocNok().setTrue() ;
            while (wsVariaveis().wsInd().isLessOrEqual(CON_250N) && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo().isEmpty() && envOut.errosGraves().semErros().isTrue()) {
                m1373ObtemDadosDoc() ;
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (swSwitchs().swDocNok().isTrue()) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                if (msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().insDocCliEmpresa());
                } else if (msgOut().msg().ade().iInszDocIdCli().isEqual(CON_SIM)) {
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().insDocAptdCli());
                } else {
                    msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().itvtOpexSdocIdObg());
                }
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-40");
            } else if (swSwitchs().swDocOk().isTrue()) {
                msgIn().msg().ade().cPaisIsaEmsDoc().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
                msgOut().msg().ade().cPaisIsaEmsDoc().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
                msgIn().msg().ade().cTipoDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
                msgOut().msg().ade().cTipoDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
                if (msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                    if (!bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId().isEqual(msgIn().msg().ade().nDocId())) {
                        envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                        msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nDocEmpCliDif());
                        msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                        envOut.errosGraves().errosFuncao().setTrue() ;
                        log(TraceLevel.Error, " ERRO-41");
                    } else {
                        msgOut().msg().ade().nDocId().set(msgIn().msg().ade().nDocId());
                        if ((msgIn().msg().ade().cEntEmixDocId().isEqual(CON_9901VITAL) || 
                            msgIn().msg().ade().cEntEmixDocId().isEqual(CON_9902VITAL) || 
                            msgIn().msg().ade().cEntEmixDocId().isEqual(CON_9903VITAL) || 
                            msgIn().msg().ade().cEntEmixDocId().isEqual(CON_9901VTSSO2) || 
                            msgIn().msg().ade().cEntEmixDocId().isEqual(CON_9902VTSSO2) || 
                            msgIn().msg().ade().cEntEmixDocId().isEqual(CON_9903VTSSO2)) && 
                            msgIn().msg().ade().zVldeDocId().isEqual(CON_DATA_MAX)) {
                            msgOut().msg().ade().zVldeDocId().set(CON_DATA_MAX_VIT);
                        } else {
                            msgOut().msg().ade().zVldeDocId().set(msgIn().msg().ade().zVldeDocId());
                        }
                        wsVariaveis().wsZVldeDocIdEmpPrin().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                        msgOut().msg().ade().cEntEmixDocId().set(msgIn().msg().ade().cEntEmixDocId());
                    }
                } else {
                    msgIn().msg().ade().nDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
                    msgOut().msg().ade().nDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
                    if ((bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9901VITAL) || 
                        bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9902VITAL) || 
                        bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9903VITAL) || 
                        bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9901VTSSO2) || 
                        bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9902VTSSO2) || 
                        bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9903VTSSO2)) && 
                        bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId().isEqual(CON_DATA_MAX)) {
                        msgIn().msg().ade().zVldeDocId().set(CON_DATA_MAX_VIT);
                        msgOut().msg().ade().zVldeDocId().set(CON_DATA_MAX_VIT);
                    } else {
                        msgIn().msg().ade().zVldeDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                        msgOut().msg().ade().zVldeDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                    }
                    msgIn().msg().ade().cEntEmixDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
                    msgOut().msg().ade().cEntEmixDocId().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
                }
            }
        }
    }
    
    /**
     * 
     * 1371-OBTEM-TP-DOC
     * 
     */
    protected void m1371ObtemTpDoc() {
        log(TraceLevel.Debug, "   1371-OBTEM-TP-DOC");
        bhgl052a().commarea().dadosInput().cTabBbnIn().set(CON_TIPODOCID_886);
        bhgl052a().commarea().dadosInput().cIdioIsoIn().set(bhok0002().BHOK0002_IDIOMA_PORTUGAL);
        bhgl052a().commarea().dadosInput().pagInput().cCodigoPgIn().set(bhgl052a().commarea().dadosOutput().pagOutput().cCodigoPgOut());
        bhgl052a().commarea().dadosInput().pagInput().cIdioIsoPgIn().set(bhgl052a().commarea().dadosOutput().pagOutput().cIdioIsoPgOut());
        bhgp0052AcedeMhgj052a() ;
        if (!bhgl052a().commarea().dadosErro().fimConsulta().isTrue() && !bhgl052a().commarea().dadosErro().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhgl052a().commarea().dadosErro().aAplErr());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhgl052a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.db2Log().nmTabela().set(bhgl052a().commarea().dadosErro().nmTabela());
            envOut.db2Log().sqlca().cSqlcode().set(bhgl052a().commarea().dadosErro().cSqlcode());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-42");
            swSwitchs().swFimCiclo().setTrue() ;
        }
        bhgl052a().commarea().dadosOutput().indice().set(CON_1N);
        while (bhgl052a().commarea().dadosOutput().indice().isLessOrEqual(CON_100N) && !bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteLogica().cCodigo().isEmpty()) {
            wsVariaveis().wsCodCodigo().set(bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteLogica().cCodigo());
            if (wsVariaveis().wsCodCodigo().wsCcCPais().isEqual(bhok0002().cPaisIsoaCpd()) && 
                bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteFisica().xCteuCo01().isEqual(CON_SIM)) {
                wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo().set(bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteLogica().cCodigo());
                /**
                 * ------------- VHG88601-CT-PRIO-VLDZ-DID
                 */
                wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdXCteuCo03().set(bhgl052a().commarea().dadosOutput().logicaFisica().get(bhgl052a().commarea().dadosOutput().indice()).componenteFisica().xCteuCo03());
                wsVariaveis().wsInd().add(CON_1N);
            }
            bhgl052a().commarea().dadosOutput().indice().add(CON_1N);
        }
        if (bhgl052a().commarea().dadosOutput().logicaFisica().get(CON_100N).componenteLogica().cCodigo().isEmpty()) {
            swSwitchs().swFimCiclo().setTrue() ;
            wsVariaveis().wsInd().set(CON_1N);
            while (wsVariaveis().wsInd().isLessOrEqual(CON_100N) && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo().isEmpty()) {
                log(TraceLevel.Debug, "   WS-TD-C-CODIGO/WS-TD-X-CTEU-CO03", ":", wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo(), "/", wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdXCteuCo03());
                wsVariaveis().wsInd().add(CON_1N);
            }
        }
    }
    
    /**
     * 
     * 1372-ORDENA-TAB-INTERNA
     * 
     */
    protected void m1372OrdenaTabInterna() {
        log(TraceLevel.Debug, "   1372-ORDENA-TAB-INTERNA");
        wsVariaveis().wsIndExt().set(CON_1N);
        wsVariaveis().wsIndInt().set(CON_1N);
        while (wsVariaveis().wsIndExt().isLessOrEqual(CON_250N) && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndExt()).wsTdCCodigo().isEmpty()) {
            wsVariaveis().wsIndInt().set(wsVariaveis().wsIndExt());
            wsVariaveis().wsIndInt().add(CON_1N);
            while (wsVariaveis().wsIndInt().isLessOrEqual(CON_250N) && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndInt()).wsTdCCodigo().isEmpty()) {
                if (wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndExt()).wsTdXCteuCo03().isGreater(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndInt()).wsTdXCteuCo03())) {
                    wsVariaveis().wsCCodigoTemp().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndExt()).wsTdCCodigo());
                    wsVariaveis().wsXCteuCo03Temp().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndExt()).wsTdXCteuCo03());
                    wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndExt()).wsTdCCodigo().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndInt()).wsTdCCodigo());
                    wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndExt()).wsTdXCteuCo03().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndInt()).wsTdXCteuCo03());
                    wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndInt()).wsTdCCodigo().set(wsVariaveis().wsCCodigoTemp());
                    wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndInt()).wsTdXCteuCo03().set(wsVariaveis().wsXCteuCo03Temp());
                }
                wsVariaveis().wsIndInt().add(CON_1N);
            }
            wsVariaveis().wsIndExt().add(CON_1N);
        }
        wsVariaveis().wsInd().set(CON_1N);
        while (wsVariaveis().wsInd().isLessOrEqual(CON_100N) && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo().isEmpty()) {
            log(TraceLevel.Debug, "   WS-TD-C-CODIGO/WS-TD-X-CTEU-CO03", ":", wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo(), "/", wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdXCteuCo03());
            wsVariaveis().wsInd().add(CON_1N);
        }
    }
    
    /**
     * 
     * 1373-OBTEM-DADOS-DOC
     * 
     */
    protected void m1373ObtemDadosDoc() {
        log(TraceLevel.Debug, "   1373-OBTEM-DADOS-DOC");
        if (wsVariaveis().wsInd().isEqual(1)) {
            log(TraceLevel.Debug, "   WS-N-CLIENTE  : ", wsVariaveis().wsNCliente());
            log(TraceLevel.Debug, "   WS-NS-ABRA-CLI: ", wsVariaveis().wsNsAbraCli());
        }
        log(TraceLevel.Debug, "   WS-TD-C-CODIGO: ", wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo());
        bhjl707a().commarea().initialize() ;
        bhjl707a().commarea().dadosEntrada().nCliente().set(wsVariaveis().wsNCliente());
        bhjl707a().commarea().dadosEntrada().nsAbraCli().set(wsVariaveis().wsNsAbraCli());
        wsVariaveis().wsCodCodigo().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo());
        bhjl707a().commarea().dadosEntrada().cPaisEmsDocPed().set(wsVariaveis().wsCodCodigo().wsCcCPais());
        bhjl707a().commarea().dadosEntrada().cTipoDocPed().set(wsVariaveis().wsCodCodigo().wsCcTDoc());
        bhjp0707AcedeMhjj707a() ;
        wsTabInternaDoc().wsZVldDocumento().get(wsVariaveis().wsInd()).wsTdCCodigoDoc().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo());
        if (bhjl707a().commarea().erros().semErros().isTrue() || bhjl707a().commarea().erros().fimConsulta().isTrue()) {
            /**
             * *GH2024--> FIM
             */
            if (bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc().isEqual(wsVariaveis().wsCodCodigo().wsCcCPais()) && 
                bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId().isEqual(wsVariaveis().wsCodCodigo().wsCcTDoc())) {
                swSwitchs().swDocOk().setTrue() ;
                log(TraceLevel.Debug, "   BHJL707A-C-TIPO-DOC-ID(ENCONTROU): ", bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
                /**
                 * *GH2024--> INICIO
                 * MOVE WS-TD-C-CODIGO (WS-IND)    TO
                 * WS-TD-C-CODIGO-DOC (WS-IND)
                 */
                if (!msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                    wsTabInternaDoc().wsZVldDocumento().get(wsVariaveis().wsInd()).wsTabZVldeDoc().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                }
            }
        } else if (!bhjl707a().commarea().erros().erroFuncao().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl707a().commarea().erros().aAplErr());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl707a().commarea().erros().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl707a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl707a().commarea().erros().nmTabela());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-43");
        }
        wsVariaveis().wsInd().add(CON_1N);
    }
    
    /**
     * 
     * 1400-VAL-CLIENTE-RPRT
     * 
     */
    protected void m1400ValClienteRprt() {
        log(TraceLevel.Debug, "  1400-VAL-CLIENTE-RPRT  ");
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-CLI : ", msgIn().msg().ade().cTipoCli());
        /**
         * -- CLIENTE REPRESENTANTE NAO CGD
         */
        if (msgIn().msg().ade().iCliCgdRprt().isEqual(CON_NAO)) {
            m1405ValDocAptdRprt() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                m1410ValCliRprtNCgd() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                /**
                 * -------- DOCUMENTO PRINCIPAL DO NAO CLIENTE REPRESENTANTE
                 */
                msgIn().msg().ade().cPaisEmsDocRpt().set(bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS());
                msgOut().msg().ade().cPaisEmsDocRpt().set(bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS());
                msgIn().msg().ade().cTipoDocIdRprt().set(bhel100a().commarea().dadosSaida().cTipoDocIdS());
                msgOut().msg().ade().cTipoDocIdRprt().set(bhel100a().commarea().dadosSaida().cTipoDocIdS());
                msgIn().msg().ade().nDocIdRprt().set(bhel100a().commarea().dadosSaida().nDocIdS());
                msgOut().msg().ade().nDocIdRprt().set(bhel100a().commarea().dadosSaida().nDocIdS());
                msgIn().msg().ade().zVldeDocIdRprt().set(bhel100a().commarea().dadosEntrada().zVldeDocId());
                msgOut().msg().ade().zVldeDocIdRprt().set(bhel100a().commarea().dadosEntrada().zVldeDocId());
                msgIn().msg().ade().cEntEmixDidRpt().set(bhel100a().commarea().dadosEntrada().cEntEmixDocId());
                msgOut().msg().ade().cEntEmixDidRpt().set(bhel100a().commarea().dadosEntrada().cEntEmixDocId());
                /**
                 * -----------
                 */
                if (bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS().isEqual(msgIn().msg().ade().cPaisEmsDocApt()) && 
                    bhel100a().commarea().dadosSaida().cTipoDocIdS().isEqual(msgIn().msg().ade().cTipoDocIdAptd())) {
                    if (!bhel100a().commarea().dadosSaida().nDocIdS().isEqual(msgIn().msg().ade().nDocIdAptd())) {
                        envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                        msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nDocAptNcliRptD());
                        msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                        envOut.errosGraves().errosFuncao().setTrue() ;
                        log(TraceLevel.Error, " ERRO-44");
                    }
                } else {
                    m1420ValDocRprtNcgd() ;
                }
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && 
            msgIn().msg().ade().iCliCgdRprt().isEqual(CON_SIM)) {
            wsVariaveis().wsBhjl006aNCliente().set(msgIn().msg().ade().nClienteRprt());
            m1330ValBasicosCli() ;
            if (envOut.errosGraves().semErros().isTrue()) {
                msgIn().msg().ade().nClienteRprt().set(bhjl006a().commarea().dadosEntrada().nCliente());
                msgOut().msg().ade().nClienteRprt().set(bhjl006a().commarea().dadosEntrada().nCliente());
                wsVariaveis().wsBhjl470aNCliente().set(bhjl006a().commarea().dadosEntrada().nCliente());
                msgIn().msg().ade().nsAbraCliRprt().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                msgOut().msg().ade().nsAbraCliRprt().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                wsVariaveis().wsBhjl470aNsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
                msgIn().msg().ade().nmClienteRprt().set(bhjl006a().commarea().dadosSaida().nmCliente());
                msgOut().msg().ade().nmClienteRprt().set(bhjl006a().commarea().dadosSaida().nmCliente());
                swSwitchs().swValidaTipoCliRprt().set(bhjl006a().commarea().dadosSaida().cTipoCli());
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1430MaisDadosCliRprt() ;
            }
            /**
             * -- VALIDA O DOCUMENTO APRESENTADO PELO REPRESENTANTE DA EMPRESA
             */
            if (envOut.errosGraves().semErros().isTrue()) {
                m1440ValNDocCliRprt() ;
            }
            if (envOut.errosGraves().semErros().isTrue() && 
                msgIn().msg().ade().iCliCgd().isEqual(CON_NAO) && 
                msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
                m1360ObtemFiltering() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1450ObtemDocPrinRprt() ;
            }
        }
    }
    
    /**
     * 
     * 1405-VAL-DOC-APTD-RPRT
     * 
     */
    protected void m1405ValDocAptdRprt() {
        log(TraceLevel.Debug, "   1405-VAL-DOC-APTD-RPRT ");
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-APT: ", msgIn().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-APTD: ", msgIn().msg().ade().cTipoDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-APTD     : ", msgIn().msg().ade().nDocIdAptd());
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
        bhjl027a().commarea().dadosEntrada().nDocId().set(msgIn().msg().ade().nDocIdAptd());
        bhjp5027AcedeMhjj027a() ;
        log(TraceLevel.Debug, "   1405-VAL-DOC-APTD-RPRT ");
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
            envOut.errosGraves().aAplErr().set(bhjk0002().BHJK0002_APLICACAO_CLIENTES);
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjk0011().erros().bhjk0001DocEmVariosClis());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-45");
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!bhjl027a().commarea().erros().semErros().isTrue() && !bhjl027a().commarea().erros().clienteNaoExiste().isTrue() && 
                !bhjl027a().commarea().erros().docNaoExis().isTrue() && 
                !bhjl027a().commarea().erros().cliCancelado().isTrue()) {
                envOut.errosGraves().aAplErr().set(bhjl027a().commarea().erros().aAplErr());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-46");
            }
        }
    }
    
    /**
     * 
     * 1410-VAL-CLI-RPRT-N-CGD
     * 
     */
    protected void m1410ValCliRprtNCgd() {
        log(TraceLevel.Debug, "   1410-VAL-CLI-RPRT-N-CGD");
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISOA-OE-OPX: ", msgIn().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1160-C-MNEM-EGC-OPEX   : ", msgIn().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1160-N-CLIENTE         : ", msgIn().msg().ade().nCliente());
        wsVariaveis().wsBhel100aNPrcpNcli().set(msgIn().msg().ade().nClienteRprt());
        m1311AcedeMhej100aCli() ;
        log(TraceLevel.Debug, "   SAIDA MHEJ100A...           ");
        if (envOut.errosGraves().semErros().isTrue()) {
            msgOut().msg().ade().cTipoCliRprt().set(bhel100a().commarea().dadosSaida().cTipoNcliS());
            msgOut().msg().ade().nClienteRprt().set(bhel100a().commarea().dadosSaida().nPrcpNcliS());
            msgOut().msg().ade().nsAbraCliRprt().set(0);
            msgOut().msg().ade().zNascCliRprt().set(bhel100a().commarea().dadosSaida().zNascNcliS());
            msgOut().msg().ade().cPaisNacnCliRp().set(bhel100a().commarea().dadosSaida().cPaisNacnNcliS());
            msgOut().msg().ade().nmClienteRprt().set(bhel100a().commarea().dadosSaida().nmPrcpNcliS());
            msgOut().msg().ade().iInszDocCliRpt().set(CON_NAO);
        }
    }
    
    /**
     * 
     * 1420-VAL-DOC-RPRT-NCGD
     * 
     */
    protected void m1420ValDocRprtNcgd() {
        log(TraceLevel.Debug, "   1420-VAL-DOC-RPRT-NCGD");
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-APT: ", msgIn().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-APTD: ", msgIn().msg().ade().cTipoDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-APTD     : ", msgIn().msg().ade().nDocIdAptd());
        /**
         * -- DOCUMENTO APRESENTADO PELO REPRESENTANTE
         */
        wsVariaveis().wsBhel100aCPaisIsaDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
        wsVariaveis().wsBhel100aCTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
        wsVariaveis().wsBhel100aNDocId().set(msgIn().msg().ade().nDocIdAptd());
        m1321AcedeMhej100aDoc() ;
        log(TraceLevel.Debug, "   SAIDA MHEJ100A...           ");
        log(TraceLevel.Debug, "   BHEL100A-C-PAIS-ISOA-OPE-S : ", bhel100a().commarea().dadosSaida().cPaisIsoaOpeS());
        log(TraceLevel.Debug, "   BHEL100A-C-MNEM-EGC-OPE-S  : ", bhel100a().commarea().dadosSaida().cMnemEgcOpeS());
        log(TraceLevel.Debug, "   BHEL100A-N-PRCP-NCLI-S     : ", bhel100a().commarea().dadosSaida().nPrcpNcliS());
        if (envOut.errosGraves().semErros().isTrue()) {
            if (!bhel100a().commarea().dadosSaida().nPrcpNcliS().isEqual(msgIn().msg().ade().nClienteRprt()) && 
                !bhel100a().commarea().dadosSaida().nPrcpNcliS().isEqual(0)) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().docAptdRptOtNcli());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-47");
            }
        }
    }
    
    /**
     * 
     * 1430-MAIS-DADOS-CLI-RPRT
     * 
     */
    protected void m1430MaisDadosCliRprt() {
        log(TraceLevel.Debug, "   1430-MAIS-DADOS-CLI-RPRT");
        bhjl014a().commarea().initialize() ;
        bhjl014a().commarea().dadosEntrada().nCliente().set(msgOut().msg().ade().nClienteRprt());
        bhjl014a().commarea().dadosEntrada().nsAbraCli().set(msgOut().msg().ade().nsAbraCliRprt());
        bhjp5014AcedeMhjj014a() ;
        if (!bhjl014a().commarea().erros().semErros().isTrue()) {
            if (bhjl014a().commarea().erros().abendDb2().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl014a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl014a().commarea().erros().nmTabela());
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhjl014a().commarea().erros().cTipoErroBbn());
                envOut.errosGraves().aAplErr().set(bhjl014a().commarea().erros().aAplErr());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl014a().commarea().erros().cRtnoEvenSwal());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                log(TraceLevel.Error, " ERRO-48");
            }
        } else {
            /**
             * -- SE CLIENTE PARTICULAR/ENI
             */
            msgOut().msg().ade().cTipoCliRprt().set(bhjl014a().commarea().dadosEntrada().cTipoCli());
            msgOut().msg().ade().zNascCliRprt().set(bhjl014a().commarea().dadosSaida().zNascCli());
            msgOut().msg().ade().cPaisNacnCliRp().set(bhjl014a().commarea().dadosSaida().cPaisIsoaNacn());
        }
    }
    
    /**
     * 
     * 1440-VAL-N-DOC-CLI-RPRT
     * 
     */
    protected void m1440ValNDocCliRprt() {
        log(TraceLevel.Debug, "   1440-VAL-N-DOC-CLI-RPRT");
        log(TraceLevel.Debug, "   BGHM1160-N-CLIENTE-RPRT       : ", msgIn().msg().ade().nClienteRprt());
        log(TraceLevel.Debug, "   BGHM1160-NS-ABRA-CLI-RPRT     : ", msgIn().msg().ade().nsAbraCliRprt());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-EMS-DOC-APT   : ", msgIn().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-DOC-ID-APTD   : ", msgIn().msg().ade().cTipoDocIdAptd());
        swSwitchs().swValidaNDocCliRprt().setTrue() ;
        bhjl628a().commarea().initialize() ;
        bhjl628a().commarea().visualizacao().setTrue() ;
        bhjl628a().commarea().thj00023Docid().dadosInput().nCliente().set(msgIn().msg().ade().nClienteRprt());
        bhjl628a().commarea().thj00023Docid().dadosInput().nsAbraCli().set(msgIn().msg().ade().nsAbraCliRprt());
        /**
         * -- TIPO DE DOCUMENTO APRESENTADO PELO REPRESENTANTE DA EMPRESA
         */
        bhjl628a().commarea().thj00023Docid().dadosInput().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
        bhjl628a().commarea().thj00023Docid().dadosInput().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
        bhjp0628Mhjj628a() ;
        log(TraceLevel.Debug, "   SAIDA MHJJ628A.............. ");
        log(TraceLevel.Debug, "   BHJL628A-N-DOC-ID          : ", bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId());
        log(TraceLevel.Debug, "   BGHM1160-N-DOC-ID-APTD     : ", msgIn().msg().ade().nDocIdAptd());
        log(TraceLevel.Debug, "   BHJL628A-C-TIPO-ERRO-BBN   : ", bhjl628a().commarea().dadosErro().cTipoErroBbn());
        log(TraceLevel.Debug, "   BHJL628A-A-APL-ERR         : ", bhjl628a().commarea().dadosErro().aAplErr());
        log(TraceLevel.Debug, "   BHJL628A-C-RTNO-EVEN-SWAL  : ", bhjl628a().commarea().dadosErro().cRtnoEvenSwal());
        log(TraceLevel.Debug, "    --DOC-NAO-EXIS ...... +535");
        log(TraceLevel.Debug, "    --DOC-EXISTE ........ +539");
        if (bhjl628a().commarea().dadosErro().semErros().isTrue()) {
            if (!bhjl628a().commarea().thj00023Docid().dadosInOut().nDocId().isEqual(msgIn().msg().ade().nDocIdAptd())) {
                /**
                 * ------ CLIENTE REPRESENTANTE CGD COM DOC ID APRESENTADO
                 * ------ CARREGADO NA BASE DE DADOS, MAS COM NUMERO DE DOC ID
                 * ------ DIFERENTE
                 */
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().nDocAptdRprtDif());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-49");
            }
        } else if (bhjl628a().commarea().dadosErro().docNaoExis().isTrue()) {
            /**
             * -------- SE TIPO DOCUMENTO NAO ESTA ATRIBUIDO AO CLIENTE RPRT
             * -------- CGD VAMOS VER DOC APRESENTADO PERTENCE A OUTRO CLI CGD
             */
            wsVariaveis().wsBhjl027aCPaisIsaDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
            wsVariaveis().wsBhjl027aCTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
            wsVariaveis().wsBhjl027aNDocId().set(msgIn().msg().ade().nDocIdAptd());
            m1351VerificExistDoc() ;
        } else {
            envOut.errosGraves().aAplErr().set(bhjl628a().commarea().dadosErro().aAplErr());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhjl628a().commarea().dadosErro().cRtnoEvenSwal());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl628a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl628a().commarea().dadosErro().nmTabela());
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            envOut.errosGraves().errosFuncao().setTrue() ;
            log(TraceLevel.Error, " ERRO-50");
        }
    }
    
    /**
     * 
     * 1450-OBTEM-DOC-PRIN-RPRT
     * 
     */
    protected void m1450ObtemDocPrinRprt() {
        log(TraceLevel.Debug, "  1450-OBTEM-DOC-PRIN-RPRT");
        log(TraceLevel.Debug, "   SW-VALIDA-TIPO-CLI-RPRT  : ", swSwitchs().swValidaTipoCliRprt());
        if (envOut.errosGraves().semErros().isTrue()) {
            bhgl052a().commarea().initialize() ;
            wsVariaveis().wsInd().set(CON_1N);
            swSwitchs().swEmCiclo().setTrue() ;
            while (!swSwitchs().swFimCiclo().isTrue()) {
                m1371ObtemTpDoc() ;
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                m1372OrdenaTabInterna() ;
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsNCliente().set(msgIn().msg().ade().nClienteRprt());
            wsVariaveis().wsNsAbraCli().set(msgIn().msg().ade().nsAbraCliRprt());
            wsVariaveis().wsInd().set(CON_1N);
            swSwitchs().swDocNok().setTrue() ;
            while (wsVariaveis().wsInd().isLessOrEqual(CON_250N) && !swSwitchs().swDocOk().isTrue() && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsInd()).wsTdCCodigo().isEmpty() && envOut.errosGraves().semErros().isTrue()) {
                m1373ObtemDadosDoc() ;
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            if (swSwitchs().swDocNok().isTrue()) {
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghk0001().erros().cliRptSDocValido());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                envOut.errosGraves().errosFuncao().setTrue() ;
                log(TraceLevel.Error, " ERRO-51");
            } else if (swSwitchs().swDocOk().isTrue()) {
                msgIn().msg().ade().cPaisEmsDocRpt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
                msgOut().msg().ade().cPaisEmsDocRpt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cPaisIsaEmsDoc());
                msgIn().msg().ade().cTipoDocIdRprt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
                msgOut().msg().ade().cTipoDocIdRprt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cTipoDocId());
                msgIn().msg().ade().nDocIdRprt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
                msgOut().msg().ade().nDocIdRprt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).nDocId());
                if ((bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9901VITAL) || 
                    bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9902VITAL) || 
                    bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9903VITAL) || 
                    bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9901VTSSO2) || 
                    bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9902VTSSO2) || 
                    bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId().isEqual(CON_9903VTSSO2)) && 
                    bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId().isEqual(CON_DATA_MAX)) {
                    msgIn().msg().ade().zVldeDocIdRprt().set(CON_DATA_MAX_VIT);
                    msgOut().msg().ade().zVldeDocIdRprt().set(CON_DATA_MAX_VIT);
                } else {
                    msgIn().msg().ade().zVldeDocIdRprt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                    msgOut().msg().ade().zVldeDocIdRprt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).zVldeDocId());
                }
                msgIn().msg().ade().cEntEmixDidRpt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
                msgOut().msg().ade().cEntEmixDidRpt().set(bhjl707a().commarea().dadosSaida().get(CON_1N).cEntEmixDocId());
            }
        }
    }
    
    /**
     * 
     * 1500-TIPO-ITVT-CLIENTE
     * 
     */
    protected void m1500TipoItvtCliente() {
        log(TraceLevel.Debug, "  1500-TIPO-ITVT-CLIENTE");
        if (!msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_ORDENANTE)) {
                swSwitchs().swOrdenanteParticular().setTrue() ;
            } else {
                swSwitchs().swBeneficiarioParticular().setTrue() ;
            }
        } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_ORDENANTE)) {
            swSwitchs().swOrdenanteEmpresa().setTrue() ;
        } else {
            swSwitchs().swBeneficiarioEmpresa().setTrue() ;
        }
    }
    
    /**
     * 
     * 1600-LIMPA-OUTPUT
     * 
     */
    protected void m1600LimpaOutput() {
        log(TraceLevel.Debug, "  1600-LIMPA-OUTPUT");
        msgIn().msg().ade().iPedJstzOrmFnd().set(CON_NAO);
        msgOut().msg().ade().iPedJstzOrmFnd().set(CON_NAO);
        msgIn().msg().ade().iRcsJstzOrmFnd().set(CON_NAO);
        msgOut().msg().ade().iRcsJstzOrmFnd().set(CON_NAO);
        msgIn().msg().ade().iDocDszd().set(CON_NAO);
        msgOut().msg().ade().iDocDszd().set(CON_NAO);
        msgIn().msg().ade().iDocDszdRprt().set(CON_NAO);
        msgOut().msg().ade().iDocDszdRprt().set(CON_NAO);
        msgIn().msg().ade().iNcssTrrFotoc().set(CON_NAO);
        msgOut().msg().ade().iNcssTrrFotoc().set(CON_NAO);
        msgIn().msg().ade().iNcssTrrFotRpt().set(CON_NAO);
        msgOut().msg().ade().iNcssTrrFotRpt().set(CON_NAO);
        msgIn().msg().ade().iCbrcEncg().set(CON_NAO);
        msgOut().msg().ade().iCbrcEncg().set(CON_NAO);
        msgIn().msg().ade().cMtvoPedJstz().set(" ");
        msgOut().msg().ade().cMtvoPedJstz().set(" ");
        msgIn().msg().ade().mAcmdLimOpe().set(0);
        msgIn().msg().ade().mAcmdLimOpe().set(0);
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        log(TraceLevel.Debug, "   SW-C-TIPO-OPE-CONT         : ", swSwitchs().swCTipoOpeCont());
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzSim().isTrue() && 
            message.mensagem().headerR().anulDiaNao().isTrue() && 
            swSwitchs().swTipoOpeValIns().isTrue()) {
            m2100OperacoesOcasionais() ;
        }
        /**
         * *--- REGISTO DO INTERVENIENTE DA OPERACAO
         */
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().simzNao().isTrue() && 
            message.mensagem().headerR().anulDiaNao().isTrue() && 
            swSwitchs().swTipoOpeValIns().isTrue()) {
            m2200InsereTgh130() ;
        }
        /**
         * *--- ESTORNO / ANULACAO
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            if (message.mensagem().headerR().anulDiaSim().isTrue() && !swSwitchs().swAnulacoesEstornosRef().isTrue()) {
                m2300EstornoJournal() ;
            } else if (swSwitchs().swAnulacoesEstornosRef().isTrue()) {
                if (swSwitchs().swTipoOpeValEstOrdem().isTrue()) {
                    m2220ApuraEstMsgSwif() ;
                }
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2400EstorAnulRef() ;
                }
            }
        }
    }
    
    /**
     * 
     * 2100-OPERACOES-OCASIONAIS
     * 
     */
    protected void m2100OperacoesOcasionais() {
        log(TraceLevel.Debug, " 2100-OPERACOES-OCASIONAIS");
        log(TraceLevel.Debug, "   SW-TIPO-ITVT-TIPO-CLI      : ", swSwitchs().swTipoItvtTipoCli());
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-SIMZ       : ", message.mensagem().headerR().iTrnzSimz());
        m2110ValDocsDszd() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (swSwitchs().swOrdenanteParticular().isTrue()) {
                log(TraceLevel.Debug, "--- A - SW-ORDENANTE-PARTICULAR");
                m2120AcumItvtOpe() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2130ValidaMontsA() ;
                }
            } else if (swSwitchs().swBeneficiarioParticular().isTrue()) {
                log(TraceLevel.Debug, "--- B - SW-BENEFICIARIO-PARTICULAR");
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2120AcumItvtOpe() ;
                }
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2140ValidaMontsB() ;
                }
            } else if (swSwitchs().swOrdenanteEmpresa().isTrue()) {
                log(TraceLevel.Debug, "--- C - SW-ORDENANTE-EMPRESA");
                m2120AcumItvtOpe() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2150ValidaMontsC() ;
                }
            } else if (swSwitchs().swBeneficiarioEmpresa().isTrue()) {
                log(TraceLevel.Debug, "--- D - SW-BENEFICIARIO-EMPRESA");
                m2120AcumItvtOpe() ;
                if (envOut.errosGraves().semErros().isTrue()) {
                    m2160ValidaMontsD() ;
                }
            }
        }
    }
    
    /**
     * 
     * 2110-VAL-DOCS-DSZD
     * 
     */
    protected void m2110ValDocsDszd() {
        log(TraceLevel.Debug, "   2110-VAL-DOCS-DSZD");
        log(TraceLevel.Debug, "   BGHM1160-I-CLI-CGD           : ", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "     BGHM1161-Z-VLDE-DOC-ID     : ", msgOut().msg().ade().zVldeDocId());
        log(TraceLevel.Debug, "   BGHM1160-C-TIPO-CLI          : ", msgIn().msg().ade().cTipoCli());
        log(TraceLevel.Debug, "     WS-Z-VLDE-DOC-ID-EMP-PRIN  : ", wsVariaveis().wsZVldeDocIdEmpPrin());
        log(TraceLevel.Debug, "   BGHM1160-I-CLI-CGD-RPRT      : ", msgIn().msg().ade().iCliCgdRprt());
        log(TraceLevel.Debug, "     BGHM1160-Z-VLDE-DOC-ID-RPRT: ", msgIn().msg().ade().zVldeDocIdRprt());
        if (!msgIn().msg().ade().cTipoCli().isEqual(CON_EMPRESA)) {
            /**
             * *GH2024--> INICIO
             */
            wsVariaveis().wsIndoc().set(CON_1N);
            while (wsVariaveis().wsIndoc().isLessOrEqual(CON_100N) && !wsTabInternaDoc().wsZVldDocumento().get(wsVariaveis().wsIndoc()).wsTdCCodigoDoc().isEmpty() && !msgOut().msg().ade().iDocDszd().isEqual(CON_SIM)) {
                /**
                 * *GH2024--> FIM
                 */
                if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                    /**
                     * IF BGHM1161-Z-VLDE-DOC-ID
                     * LESS BHTL001A-Z-PRCT-JOUR-BBN
                     * *PASS2972 - INI
                     * IF (BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9901VITAL
                     * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9902VITAL
                     * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9903VITAL
                     * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL
                     * CON-9901VTSSO2
                     * CON-9902VTSSO2
                     * CON-9903VTSSO2)
                     * **            AND WS-TAB-Z-VLDE-DOC(WS-INDOC)
                     * EQUAL CON-DATA-MAX
                     * MOVE CON-DATA-MAX-VIT TO
                     * BGHM1161-Z-VLDE-DOC-ID
                     * END-IF
                     * *PASS2972 - FIM
                     */
                    if (!wsTabInternaDoc().wsZVldDocumento().get(wsVariaveis().wsIndoc()).wsTabZVldeDoc().isEmpty() && 
                        wsTabInternaDoc().wsZVldDocumento().get(wsVariaveis().wsIndoc()).wsTabZVldeDoc().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
                        /**
                         * *GH2024--> FIM
                         */
                        msgOut().msg().ade().iDocDszd().set(CON_SIM);
                        msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                    } else {
                        msgOut().msg().ade().iDocDszd().set(CON_NAO);
                    }
                }
                wsVariaveis().wsIndoc().add(CON_1N);
            }
        } else {
            /**
             * ----- DOCUMENTO PRINCIPAL CLIENTE EMPRESA
             */
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
                /**
                 * *PASS2972 - INI
                 * IF BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9901VITAL
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9902VITAL
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9903VITAL
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9901VTSSO2
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9902VTSSO2
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9903VTSSO2
                 * AND WS-TAB-Z-VLDE-DOC(WS-INDOC)
                 * EQUAL CON-DATA-MAX
                 * MOVE CON-DATA-MAX-VIT TO BGHM1161-Z-VLDE-DOC-ID
                 * END-IF
                 * *PASS2972 - FIM
                 */
                if (wsVariaveis().wsZVldeDocIdEmpPrin().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
                    msgOut().msg().ade().iDocDszd().set(CON_SIM);
                    msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                } else {
                    msgOut().msg().ade().iDocDszd().set(CON_NAO);
                }
            }
            /**
             * ----- DOCUMENTO PRINCIPAL CLIENTE REPRESENTANTE DA EMPRESA
             */
            if (msgIn().msg().ade().iCliCgdRprt().isEqual(CON_SIM)) {
                /**
                 * *PASS2972 - INI
                 * IF BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9901VITAL
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9902VITAL
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9903VITAL
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9901VTSSO2
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9902VTSSO2
                 * OR BGHM1160-C-ENT-EMIX-DOC-ID EQUAL CON-9903VTSSO2
                 * AND WS-TAB-Z-VLDE-DOC(WS-INDOC)
                 * EQUAL CON-DATA-MAX
                 * MOVE CON-DATA-MAX-VIT TO BGHM1161-Z-VLDE-DOC-ID
                 * END-IF
                 * *PASS2972 - FIM
                 */
                if (msgOut().msg().ade().zVldeDocIdRprt().isLess(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
                    msgOut().msg().ade().iDocDszdRprt().set(CON_SIM);
                    msgOut().msg().ade().iNcssTrrFotRpt().set(CON_SIM);
                } else {
                    msgOut().msg().ade().iDocDszdRprt().set(CON_NAO);
                }
            }
        }
    }
    
    /**
     * 
     * 2120-ACUM-ITVT-OPE
     * 
     */
    protected void m2120AcumItvtOpe() {
        log(TraceLevel.Debug, "   2120-ACUM-ITVT-OPE");
        hv13001Movdep().movdep().initialize() ;
        if (msgIn().msg().ade().cPaisIsaEmsDoc().isEmpty() && 
            msgIn().msg().ade().cTipoDocId().isEmpty() && 
            msgIn().msg().ade().nDocId().isEmpty()) {
            /**
             * ----- DOCUMENTO APRESENTADO
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocIdAptd());
        } else {
            /**
             * ----- DOCUMENTO PRINCIPAL
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocId());
        }
        hv13001Movdep().movdep().iDbcr().set(" ");
        hv13001Movdep().movdep().iEstorno().set(CON_NAO);
        hv13001Movdep().movdep().iPedJstzOrmFnd().set(CON_SIM);
        hv13001Movdep().movdep().iRcsJstzOrmFnd().set(CON_NAO);
        log(TraceLevel.Debug, "   VGH13001-C-PAIS-ISA-EMS-DOC: ", hv13001Movdep().movdep().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   VGH13001-C-TIPO-DOC-ID     : ", hv13001Movdep().movdep().cTipoDocId());
        log(TraceLevel.Debug, "   VGH13001-N-DOC-ID          : ", hv13001Movdep().movdep().nDocId());
        log(TraceLevel.Debug, "   VGH13001-I-DBCR            : ", hv13001Movdep().movdep().iDbcr());
        log(TraceLevel.Debug, "   VGH13001-I-ESTORNO         : ", hv13001Movdep().movdep().iEstorno());
        log(TraceLevel.Debug, "   VGH13001-I-PED-JSTZ-ORM-FND: ", hv13001Movdep().movdep().iPedJstzOrmFnd());
        log(TraceLevel.Debug, "   VGH13001-I-RCS-JSTZ-ORM-FND: ", hv13001Movdep().movdep().iRcsJstzOrmFnd());
        m2121ApuraUltMov() ;
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swItvtSemMov().isTrue()) {
            m2122UltMov30Dias() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swItvtSemMov().isTrue()) {
            m2123UltMovJustif() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && !swSwitchs().swItvtSemMov().isTrue()) {
            m2124SomaMontantes() ;
        }
    }
    
    /**
     * 
     * 2121-APURA-ULT-MOV
     * 
     */
    protected void m2121ApuraUltMov() {
        log(TraceLevel.Debug, "    2121-APURA-ULT-MOV");
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH13001_MOVDEP
         */
        hv13001Movdep().selectPghs163a3547() ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (swSwitchs().swVgh13001Notfnd().isTrue()) {
            swSwitchs().swItvtSemMov().setTrue() ;
            log(TraceLevel.Debug, "   SW-ITVT-TEM-MOV            : ", swSwitchs().swItvtTemMov());
        } else if (swSwitchs().swVgh13001Ok().isTrue()) {
            wsVariaveis().wsZMovimentoUlt().set(hv13001Movdep().movdep().zMovimento());
        } else {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, " ERRO-52");
            log(TraceLevel.Error, "   ERRO NO 2121-APURA-ULT-MOV - SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "   CHAVE : ");
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsaEmsDoc());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoDocId());
            log(TraceLevel.Error, "    N-DOC- ", hv13001Movdep().movdep().nDocId());
            log(TraceLevel.Error, "    I-DBCR ", hv13001Movdep().movdep().iDbcr());
            log(TraceLevel.Error, "    I-ESTO ", hv13001Movdep().movdep().iEstorno());
        }
    }
    
    /**
     * 
     * 2122-ULT-MOV-30-DIAS
     * 
     */
    protected void m2122UltMov30Dias() {
        log(TraceLevel.Debug, "    2122-ULT-MOV-30-DIAS");
        log(TraceLevel.Debug, "   WS-Z-MOVIMENTO-ULT       : ", wsVariaveis().wsZMovimentoUlt());
        bhyl230a().commarea().initialize() ;
        bhyl230a().commarea().dadosEntrada().reduzido().setTrue() ;
        bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(CON_SUBTR_PRZ_DATA);
        bhyl230a().commarea().dadosEntrada().datInput1().set(wsVariaveis().wsZMovimentoUlt());
        bhyl230a().commarea().dadosEntrada().prazo().cTipoPraz().set(CON_C_TIPO_PRAZ_1);
        bhyl230a().commarea().dadosEntrada().prazo().duTipoPraz().set(CON_DU_TIPO_PRAZ_30);
        bhyp0200RotinaDatas() ;
        envOut.errosGraves().cTipoErroBbn().set(bhyl230a().commarea().dadosSaida().estado().cTipoErroBbn());
        if (!envOut.errosGraves().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhyl230a().commarea().dadosSaida().aAplErr());
            msgIn().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
            msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
        } else {
            wsVariaveis().wsZMovimento30().set(bhyl230a().commarea().dadosSaida().zOutput());
        }
    }
    
    /**
     * 
     * 2123-ULT-MOV-JUSTIF
     * 
     */
    protected void m2123UltMovJustif() {
        log(TraceLevel.Debug, "    2123-ULT-MOV-JUSTIF");
        log(TraceLevel.Debug, "   WS-Z-MOVIMENTO-ULT <=    : ", wsVariaveis().wsZMovimentoUlt());
        log(TraceLevel.Debug, "   WS-Z-MOVIMENTO-30  >=    : ", wsVariaveis().wsZMovimento30());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH13001_MOVDEP
         */
        hv13001Movdep().selectPghs163a3650(wsVariaveis().wsZMovimentoUlt(), wsVariaveis().wsZMovimento30()) ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (swSwitchs().swVgh13001Notfnd().isTrue()) {
            swSwitchs().swItvtSemJustf().setTrue() ;
            wsVariaveis().wsZMovUltJustf().set(wsVariaveis().wsZMovimento30());
            wsVariaveis().wsTsInsUltJustfTemp().wsData().set(wsVariaveis().wsZMovimento30());
            wsVariaveis().wsTsInsUltJustf().set(wsVariaveis().wsTsInsUltJustfTemp());
            log(TraceLevel.Debug, "   SW-ITVT-TEM-JUSTF           : ", swSwitchs().swItvtTemJustf());
            log(TraceLevel.Debug, "    WS-Z-MOV-ULT-JUSTF         : ", wsVariaveis().wsZMovUltJustf());
            log(TraceLevel.Debug, "    WS-TS-INS-ULT-JUSTF-TEMP   : ", wsVariaveis().wsTsInsUltJustfTemp());
            log(TraceLevel.Debug, "    WS-TS-INS-ULT-JUSTF        : ", wsVariaveis().wsTsInsUltJustf());
        } else if (swSwitchs().swVgh13001Ok().isTrue()) {
            wsVariaveis().wsZMovUltJustf().set(hv13001Movdep().movdep().zMovimento());
            wsVariaveis().wsTsInsUltJustf().set(hv13001Movdep().movdep().tsInsercao());
        } else {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, " ERRO-53");
            log(TraceLevel.Error, "   ERRO NO 2123-ULT-MOV-JUSTIF - SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "   CHAVE : ");
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsaEmsDoc());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoDocId());
            log(TraceLevel.Error, "    N-DOC- ", hv13001Movdep().movdep().nDocId());
            log(TraceLevel.Error, "    WS-Z-M ", wsVariaveis().wsZMovimento30());
            log(TraceLevel.Error, "    Z-MOVI ", hv13001Movdep().movdep().zMovimento());
            log(TraceLevel.Error, "    I-DBCR ", hv13001Movdep().movdep().iDbcr());
            log(TraceLevel.Error, "    I-ESTO ", hv13001Movdep().movdep().iEstorno());
            log(TraceLevel.Error, "    I-PED- ", hv13001Movdep().movdep().iPedJstzOrmFnd());
        }
    }
    
    /**
     * 
     * 2124-SOMA-MONTANTES
     * 
     */
    protected void m2124SomaMontantes() {
        log(TraceLevel.Debug, "    2124-SOMA-MONTANTES");
        log(TraceLevel.Debug, "   WS-Z-MOVIMENTO-30    <=  : ", wsVariaveis().wsZMovimento30());
        log(TraceLevel.Debug, "   WS-Z-MOV-ULT-JUSTF   >=  : ", wsVariaveis().wsZMovUltJustf());
        log(TraceLevel.Debug, "   WS-TS-INS-ULT-JUSTF  >   : ", wsVariaveis().wsTsInsUltJustf());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH13001_MOVDEP
         */
        hv13001Movdep().selectPghs163a3737(wsVariaveis().wsZMovimentoUlt(), wsVariaveis().wsZMovUltJustf(), wsVariaveis().wsTsInsUltJustf(), wsVariaveis().wsMtItvtOpe()) ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (swSwitchs().swVgh13001Ok().isTrue()) {
            if (wsVariaveis().wsStNull().isLess(0)) {
                wsVariaveis().wsMtItvtOpe().set(0);
            }
        } else {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, " ERRO-54");
            log(TraceLevel.Error, "   ERRO NO 2124-SOMA-MONTANTES - SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "   CHAVE : ");
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsaEmsDoc());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoDocId());
            log(TraceLevel.Error, "    N-DOC- ", hv13001Movdep().movdep().nDocId());
            log(TraceLevel.Error, "    Z-ULT  ", wsVariaveis().wsZMovimentoUlt());
            log(TraceLevel.Error, "    Z-MOVI ", hv13001Movdep().movdep().zMovimento());
            log(TraceLevel.Error, "    TS-INS ", hv13001Movdep().movdep().tsInsercao());
            log(TraceLevel.Error, "    I-DBCR ", hv13001Movdep().movdep().iDbcr());
            log(TraceLevel.Error, "    I-ESTO ", hv13001Movdep().movdep().iEstorno());
        }
    }
    
    /**
     * 
     * 2130-VALIDA-MONTS-A
     * 
     */
    protected void m2130ValidaMontsA() {
        log(TraceLevel.Debug, "   2130-VALIDA-MONTS-A");
        log(TraceLevel.Debug, "   BGHM1160-M-MOV-NMRI      : ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-ITVT-OPE           : ", wsVariaveis().wsMtItvtOpe());
        /**
         * PASSIVAS 4497 (INICIO)
         */
        if (!swSwitchs().swTransferencias().isTrue()) {
            m2131ValidaMontsA() ;
        } else {
            m2132ValidaMontsA() ;
        }
    }
    
    /**
     * 
     * 2131-VALIDA-MONTS-A
     * 
     */
    protected void m2131ValidaMontsA() {
        log(TraceLevel.Debug, "   2131-VALIDA-MONTS-A");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaOp())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            }
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaOp(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaOp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                    msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                }
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaOp(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * 2132-VALIDA-MONTS-A
     * 
     */
    protected void m2132ValidaMontsA() {
        log(TraceLevel.Debug, "   2132-VALIDA-MONTS-A");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaOpLei83())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaOpLei83(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaOpLei83())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaOpLei83(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * 2140-VALIDA-MONTS-B
     * 
     */
    protected void m2140ValidaMontsB() {
        log(TraceLevel.Debug, "   2140-VALIDA-MONTS-B");
        log(TraceLevel.Debug, "   BGHM1160-M-MOV-NMRI        : ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-ITVT-OPE             : ", wsVariaveis().wsMtItvtOpe());
        if (!swSwitchs().swTransferencias().isTrue()) {
            m2141ValidaMontsB() ;
        } else {
            m2142ValidaMontsB() ;
        }
    }
    
    /**
     * 
     * 2141-VALIDA-MONTS-B
     * 
     */
    protected void m2141ValidaMontsB() {
        log(TraceLevel.Debug, "   2141-VALIDA-MONTS-B");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaBp())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            }
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaBp(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaBp())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                    msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                }
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaBp(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * 2142-VALIDA-MONTS-B
     * 
     */
    protected void m2142ValidaMontsB() {
        log(TraceLevel.Debug, "   2142-VALIDA-MONTS-B");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaBpLei83())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaBpLei83(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaBpLei83())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaBpLei83(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * 2150-VALIDA-MONTS-C
     * 
     */
    protected void m2150ValidaMontsC() {
        log(TraceLevel.Debug, "   2150-VALIDA-MONTS-C");
        log(TraceLevel.Debug, "   BGHM1160-M-MOV-NMRI        : ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-ITVT-OPE             : ", wsVariaveis().wsMtItvtOpe());
        if (!swSwitchs().swTransferencias().isTrue()) {
            m2151ValidaMontsC() ;
        } else {
            m2152ValidaMontsC() ;
        }
    }
    
    /**
     * 
     * 2151-VALIDA-MONTS-C
     * 
     */
    protected void m2151ValidaMontsC() {
        log(TraceLevel.Debug, "   2151-VALIDA-MONTS-C");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaOe())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaOe(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaOe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaOe(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * 2152-VALIDA-MONTS-C
     * 
     */
    protected void m2152ValidaMontsC() {
        log(TraceLevel.Debug, "   2152-VALIDA-MONTS-C");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaOeLei83())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaOeLei83(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaOeLei83())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaOeLei83(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * 2160-VALIDA-MONTS-D
     * 
     */
    protected void m2160ValidaMontsD() {
        log(TraceLevel.Debug, "   2160-VALIDA-MONTS-D");
        log(TraceLevel.Debug, "   BGHM1160-M-MOV-NMRI        : ", msgIn().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   WS-MT-ITVT-OPE             : ", wsVariaveis().wsMtItvtOpe());
        if (!swSwitchs().swTransferencias().isTrue()) {
            m2161ValidaMontsD() ;
        } else {
            m2162ValidaMontsD() ;
        }
    }
    
    /**
     * 
     * 2161-VALIDA-MONTS-D
     * 
     */
    protected void m2161ValidaMontsD() {
        log(TraceLevel.Debug, "   2161-VALIDA-MONTS-D");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaBe())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaBe(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaBe())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaBe(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * 2162-VALIDA-MONTS-D
     * 
     */
    protected void m2162ValidaMontsD() {
        log(TraceLevel.Debug, "   2162-VALIDA-MONTS-D");
        /**
         * -- POR CADA OPERACAO
         */
        if (msgIn().msg().ade().mMovNmri().isGreaterOrEqual(bghk0005().limitesMontanteNum().montOpeOcaBeLei83())) {
            msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
            msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
            msgOut().msg().ade().cMtvoPedJstz().set(CON_MONT_OPERACAO);
            msgOut().msg().ade().mAcmdLimOpe().set(msgIn().msg().ade().mMovNmri());
            log(TraceLevel.Debug, "   ATENCAO - MONT-OPE-OCA >= ", bghk0005().limitesMontanteNum().montOpeOcaBeLei83(), " :", msgIn().msg().ade().mMovNmri());
        }
        if (!msgOut().msg().ade().cMtvoPedJstz().isEqual(CON_MONT_OPERACAO)) {
            /**
             * -- PELO MESMO INTERVENINENTE
             */
            wsVariaveis().wsMontTotal().set(add(msgIn().msg().ade().mMovNmri(), wsVariaveis().wsMtItvtOpe()));
            wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
            log(TraceLevel.Debug, "   WS-MONT-TOTAL-ITVT         :", wsVariaveis().wsMontTotalDisplay());
            if (wsVariaveis().wsMontTotal().isGreaterOrEqual(bghk0005().limitesMontanteNum().acmdItvOcaBeLei83())) {
                msgOut().msg().ade().iPedJstzOrmFnd().set(CON_SIM);
                msgOut().msg().ade().iNcssTrrFotoc().set(CON_SIM);
                msgOut().msg().ade().cMtvoPedJstz().set(CON_LIM_ACMD_ITVT);
                msgOut().msg().ade().mAcmdLimOpe().set(wsVariaveis().wsMontTotal());
                wsVariaveis().wsMontTotalDisplay().set(wsVariaveis().wsMontTotal());
                log(TraceLevel.Debug, "   ATENCAO - ACMD-ITV-OCA+NMRI >= ", bghk0005().limitesMontanteNum().acmdItvOcaBeLei83(), " :", wsVariaveis().wsMontTotalDisplay());
            }
        }
    }
    
    /**
     * 
     * PASSIVAS 4497 (FIM)
     * 2200-INSERE-TGH130
     * 
     */
    protected void m2200InsereTgh130() {
        log(TraceLevel.Debug, "  2200-INSERE-TGH130");
        if (envOut.errosGraves().semErros().isTrue() && swSwitchs().swChqhb0ChqBancario().isTrue()) {
            m2210ObtemCtaChq() ;
        }
        if (envOut.errosGraves().semErros().isTrue() && swSwitchs().swTipoOpeValEstOrdem().isTrue()) {
            m2220ApuraEstMsgSwif() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m2230FormataTgh130() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m2240InsertTgh130() ;
        }
    }
    
    /**
     * 
     * 2210-OBTEM-CTA-CHQ
     * 
     */
    protected void m2210ObtemCtaChq() {
        log(TraceLevel.Debug, "   2210-OBTEM-CTA-CHQ");
        log(TraceLevel.Debug, "   BGHM1160-N-CHEQUE       : ", msgIn().msg().ade().nCheque());
        log(TraceLevel.Debug, "   C-SRIE-CHEQ-INP         : ", msgIn().msg().ade().cRefMsgSwif());
        bhhl070a().commarea().initialize() ;
        bhhl070a().commarea().dadosInput().nChequeInp().set(msgIn().msg().ade().nCheque());
        bhhl070a().commarea().dadosInput().cSrieCheqInp().set(msgIn().msg().ade().cRefMsgSwif().get(1, 2));
        bhhp0070ConsThh11Cheq() ;
        if (!bhhl070a().commarea().dadosOutput().dadosErro().semErros().isTrue()) {
            if (bhhl070a().commarea().dadosOutput().dadosErro().abendDb2().isTrue()) {
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.db2Log().sqlca().cSqlcode().set(bhhl070a().commarea().dadosOutput().dadosErro().cSqlcode());
                envOut.db2Log().nmTabela().set(bhhl070a().commarea().dadosOutput().dadosErro().nmTabela());
                log(TraceLevel.Error, " ERRO-55");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.errosGraves().aAplErr().set(bhhl070a().commarea().dadosOutput().dadosErro().aAplErr());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bhhl070a().commarea().dadosOutput().dadosErro().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-56");
            }
        }
    }
    
    /**
     * 
     * 2220-APURA-EST-MSG-SWIF
     * 
     */
    protected void m2220ApuraEstMsgSwif() {
        log(TraceLevel.Debug, "   2220-APURA-EST-MSG-SWIF");
        bghl300a().commarea().initialize() ;
        bghl300a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bghl300a().commarea().dadosEntrada().cPaisIsoAlfn().set(msgIn().msg().ade().cPaisIsoAlfn());
        bghl300a().commarea().dadosEntrada().cMnemEmpGcx().set(msgIn().msg().ade().cMnemEmpGcx());
        bghl300a().commarea().dadosEntrada().cRefMsgSwif().set(msgIn().msg().ade().cRefMsgSwif());
        bghl300a().commarea().dadosEntrada().cTipoOpeCont().set(msgIn().msg().ade().cTipoOpeCont());
        bghl300a().commarea().dadosEntrada().cEstMsgSwifI().set(0);
        bghp1300VerifEstadOrd() ;
        log(TraceLevel.Debug, "   BGHL300A-C-EST-MSG-SWIF-O : ", bghl300a().commarea().dadosSaida().cEstMsgSwifO());
        if (bghl300a().commarea().erros().semErros().isTrue()) {
            wsVariaveis().wsCEstMsgSwif().set(bghl300a().commarea().dadosSaida().cEstMsgSwifO());
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(bghl300a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bghl300a().commarea().erros().nmTabela());
            if (bghl300a().commarea().erros().erroFuncao().isTrue()) {
                envOut.errosGraves().aAplErr().set(bghl300a().commarea().erros().aAplErr());
                envOut.errosGraves().cTipoErroBbn().set(bghl300a().commarea().erros().cTipoErroBbn());
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfn1().setTrue() ;
                msgOut().msg().ase().cPaisIsoAlfnSt().cPaisIsoAlfnM().set(bghl300a().commarea().erros().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-57");
            } else {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-58");
            }
        }
    }
    
    /**
     * 
     * 2230-FORMATA-TGH130
     * 
     */
    protected void m2230FormataTgh130() {
        log(TraceLevel.Debug, "   2230-FORMATA-TGH130");
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
         * -- CONTA
         */
        if (swSwitchs().swChqhb0ChqBancario().isTrue()) {
            hv13001Movdep().movdep().cPaisIsoaCont().set(bhhl070a().commarea().dadosOutput().vhh01101().cPaisIsoaCont());
            hv13001Movdep().movdep().cBancCont().set(bhhl070a().commarea().dadosOutput().vhh01101().cBancCont());
            hv13001Movdep().movdep().cOeEgcCont().set(bhhl070a().commarea().dadosOutput().vhh01101().cOeEgcCont());
            hv13001Movdep().movdep().nsRdclCont().set(bhhl070a().commarea().dadosOutput().vhh01101().nsRdclCont());
            hv13001Movdep().movdep().vChkdCont().set(bhhl070a().commarea().dadosOutput().vhh01101().vChkdCont());
            hv13001Movdep().movdep().cTipoCont().set(bhhl070a().commarea().dadosOutput().vhh01101().cTipoCont());
            hv13001Movdep().movdep().cMoedIsoScta().set(bhhl070a().commarea().dadosOutput().vhh01101().cMoedIsoScta());
            hv13001Movdep().movdep().nsDeposito().set(bhhl070a().commarea().dadosOutput().vhh01101().nsDeposito());
        } else {
            /**
             * ----- REFERENCIA
             */
            hv13001Movdep().movdep().cPaisIsoAlfn().set(msgIn().msg().ade().cPaisIsoAlfn());
            hv13001Movdep().movdep().cMnemEmpGcx().set(msgIn().msg().ade().cMnemEmpGcx());
            hv13001Movdep().movdep().cRefMsgSwif().set(msgIn().msg().ade().cRefMsgSwif());
            hv13001Movdep().movdep().cEstMsgSwif().set(wsVariaveis().wsCEstMsgSwif());
        }
        /**
         * --
         */
        hv13001Movdep().movdep().nCheque().set(msgIn().msg().ade().nCheque());
        /**
         * -- DADOS DOCUMENTO CLIENTE - DOCUMENTO IDENTIFICACAO PRINCIPAL
         */
        if (msgIn().msg().ade().cPaisIsaEmsDoc().isEmpty() && 
            msgIn().msg().ade().cPaisIsaEmsDoc().isEmpty() && 
            msgIn().msg().ade().nDocId().isEmpty() && 
            (msgIn().msg().ade().zVldeDocId().isEqual(CON_DATA_MIN) || 
            msgIn().msg().ade().zVldeDocId().isEmpty()) && 
            msgIn().msg().ade().cEntEmixDocId().isEmpty()) {
            /**
             * SEM DOC PRINC, MOVE DOCUMENTO APRESENTADO
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisEmsDocApt());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocIdAptd());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocIdAptd());
            hv13001Movdep().movdep().zVldeDocId().set(msgIn().msg().ade().zVldeDocIdAptd());
            hv13001Movdep().movdep().cEntEmixDocId().set(msgIn().msg().ade().cEntEmiDidAptd());
        } else {
            /**
             * COM DOC PRINC,  MOVE DOCUMENTO PRINCIPAL
             */
            hv13001Movdep().movdep().cPaisIsaEmsDoc().set(msgIn().msg().ade().cPaisIsaEmsDoc());
            hv13001Movdep().movdep().cTipoDocId().set(msgIn().msg().ade().cTipoDocId());
            hv13001Movdep().movdep().nDocId().set(msgIn().msg().ade().nDocId());
            hv13001Movdep().movdep().zVldeDocId().set(msgIn().msg().ade().zVldeDocId());
            hv13001Movdep().movdep().cEntEmixDocId().set(msgIn().msg().ade().cEntEmixDocId());
        }
        /**
         * -- DOCUMENTO DE IDENTIFICACAO APRESENTADO
         */
        hv13001Movdep().movdep().cPaisEmsDocApt().set(msgIn().msg().ade().cPaisEmsDocApt());
        hv13001Movdep().movdep().cTipoDocIdAptd().set(msgIn().msg().ade().cTipoDocIdAptd());
        hv13001Movdep().movdep().nDocIdAptd().set(msgIn().msg().ade().nDocIdAptd());
        hv13001Movdep().movdep().zVldeDocIdAptd().set(msgIn().msg().ade().zVldeDocIdAptd());
        hv13001Movdep().movdep().cEntEmiDidAptd().set(msgIn().msg().ade().cEntEmiDidAptd());
        /**
         * -- DOCUMENTO PRINC DE IDENTIFICACAO DO REPRESENTANTE DA EMPRESA
         */
        hv13001Movdep().movdep().cPaisEmsDocRpt().set(msgIn().msg().ade().cPaisEmsDocRpt());
        hv13001Movdep().movdep().cTipoDocIdRprt().set(msgIn().msg().ade().cTipoDocIdRprt());
        hv13001Movdep().movdep().nDocIdRprt().set(msgIn().msg().ade().nDocIdRprt());
        hv13001Movdep().movdep().zVldeDocIdRprt().set(msgIn().msg().ade().zVldeDocIdRprt());
        hv13001Movdep().movdep().cEntEmixDidRpt().set(msgIn().msg().ade().cEntEmixDidRpt());
        /**
         * --
         */
        hv13001Movdep().movdep().nmCliente().set(msgIn().msg().ade().nmCliente());
        hv13001Movdep().movdep().iCliCgd().set(msgIn().msg().ade().iCliCgd());
        hv13001Movdep().movdep().iRprtCliCgd().set(msgIn().msg().ade().iCliCgdRprt());
        hv13001Movdep().movdep().cTipoItvtDep().set(msgIn().msg().ade().cTipoItvtDep());
        hv13001Movdep().movdep().cTipoMdti().set(" ");
        hv13001Movdep().movdep().zMovimento().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        hv13001Movdep().movdep().iDbcr().set(" ");
        hv13001Movdep().movdep().mMovEuro().set(msgIn().msg().ade().mMovNmri());
        hv13001Movdep().movdep().cTipoCanlAces().set(message.mensagem().headerR().transaccao().cTipoCanlAces());
        /**
         * -- TIPO DE OPERACAO
         */
        if (swSwitchs().swCambio().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_CAMBIO);
        } else if (swSwitchs().swTrocoDestroco().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_TROCO_DESTROCO);
        } else if (swSwitchs().swOrdensEmitidas().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_ORDENS_EMITIDAS);
        } else if (swSwitchs().swOrdensRecebidas().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_ORDENS_RECEBIDAS);
        } else if (swSwitchs().swOcasionais().isTrue()) {
            hv13001Movdep().movdep().cTipoOpeCont().set(CON_OCASIONAIS);
        }
        /**
         * --
         */
        hv13001Movdep().movdep().iTrnzEfcdOnln().set(message.mensagem().headerR().iTrnzEfcdOnln());
        hv13001Movdep().movdep().iPedJstzOrmFnd().set(msgIn().msg().ade().iPedJstzOrmFnd());
        hv13001Movdep().movdep().cMtvoPedJstz().set(msgIn().msg().ade().cMtvoPedJstz());
        hv13001Movdep().movdep().iRcsJstzOrmFnd().set(msgIn().msg().ade().iRcsJstzOrmFnd());
        /**
         * *GH2024-->INICIO
         */
        hv13001Movdep().movdep().qMoeda().set(msgIn().msg().ade().qMoed());
        /**
         * *GH2024-->FIM
         * PASSIVAS 4497 (INICIO)
         */
        hv13001Movdep().movdep().cTipoRelDpst().set(" ");
        hv13001Movdep().movdep().xInfJstzDep().set(" ");
        /**
         * PASSIVAS 4497 (FIM)
         */
        hv13001Movdep().movdep().iEstorno().set(message.mensagem().headerR().iEstorno());
        hv13001Movdep().movdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
    }
    
    /**
     * 
     * 2240-INSERT-TGH130
     * 
     */
    protected void m2240InsertTgh130() {
        log(TraceLevel.Debug, "   2240-INSERT-TGH130");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH13001_MOVDEP
         */
        hv13001Movdep().insertPghs163a4659() ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, " ERRO-59");
            log(TraceLevel.Error, "   ERRO NO INSERT TGH00130 - SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "   CHAVE : ");
            log(TraceLevel.Error, "    Z-PROC ", hv13001Movdep().movdep().zProcessamento());
            log(TraceLevel.Error, "    C-MNEM ", hv13001Movdep().movdep().cMnemEgcOpex());
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsoaOeOpx());
            log(TraceLevel.Error, "    C-OE-E ", hv13001Movdep().movdep().cOeEgcOpex());
            log(TraceLevel.Error, "    C-USER ", hv13001Movdep().movdep().cUserid());
            log(TraceLevel.Error, "    N-JOUR ", hv13001Movdep().movdep().nJourBbn());
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsoaCont());
            log(TraceLevel.Error, "    C-BANC ", hv13001Movdep().movdep().cBancCont());
            log(TraceLevel.Error, "    C-OE-E ", hv13001Movdep().movdep().cOeEgcCont());
            log(TraceLevel.Error, "    NS-RDC ", hv13001Movdep().movdep().nsRdclCont());
            log(TraceLevel.Error, "    V-CHKD ", hv13001Movdep().movdep().vChkdCont());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoCont());
            log(TraceLevel.Error, "    C-MOED ", hv13001Movdep().movdep().cMoedIsoScta());
            log(TraceLevel.Error, "    NS-DEP ", hv13001Movdep().movdep().nsDeposito());
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsoAlfn());
            log(TraceLevel.Error, "    C-MNEM ", hv13001Movdep().movdep().cMnemEmpGcx());
            log(TraceLevel.Error, "    C-REF- ", hv13001Movdep().movdep().cRefMsgSwif());
            log(TraceLevel.Error, "    C-EST- ", hv13001Movdep().movdep().cEstMsgSwif());
            log(TraceLevel.Error, "    N-CHEQ ", hv13001Movdep().movdep().nCheque());
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsaEmsDoc());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoDocId());
            log(TraceLevel.Error, "    N-DOC- ", hv13001Movdep().movdep().nDocId());
            log(TraceLevel.Error, "    Z-VLDE ", hv13001Movdep().movdep().zVldeDocId());
            log(TraceLevel.Error, "    C-ENT- ", hv13001Movdep().movdep().cEntEmixDocId());
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisEmsDocApt());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoDocIdAptd());
            log(TraceLevel.Error, "    N-DOC- ", hv13001Movdep().movdep().nDocIdAptd());
            log(TraceLevel.Error, "    Z-VLDE ", hv13001Movdep().movdep().zVldeDocIdAptd());
            log(TraceLevel.Error, "    C-ENT- ", hv13001Movdep().movdep().cEntEmiDidAptd());
            log(TraceLevel.Error, "    NM-CLI ", hv13001Movdep().movdep().nmCliente());
            log(TraceLevel.Error, "    I-CLI- ", hv13001Movdep().movdep().iCliCgd());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoItvtDep());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoMdti());
            log(TraceLevel.Error, "    Z-MOVI ", hv13001Movdep().movdep().zMovimento());
            log(TraceLevel.Error, "    I-DBCR ", hv13001Movdep().movdep().iDbcr());
            log(TraceLevel.Error, "    M-MOV- ", hv13001Movdep().movdep().mMovEuro());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoCanlAces());
            log(TraceLevel.Error, "    C-TIPO ", hv13001Movdep().movdep().cTipoOpeCont());
            log(TraceLevel.Error, "    I-TRNZ ", hv13001Movdep().movdep().iTrnzEfcdOnln());
            log(TraceLevel.Error, "    I-PED- ", hv13001Movdep().movdep().iPedJstzOrmFnd());
            log(TraceLevel.Error, "    C-MTVO ", hv13001Movdep().movdep().cMtvoPedJstz());
            log(TraceLevel.Error, "    I-RCS- ", hv13001Movdep().movdep().iRcsJstzOrmFnd());
            log(TraceLevel.Error, "    I-ESTO ", hv13001Movdep().movdep().iEstorno());
            log(TraceLevel.Error, "    TIMES  ", "CURRENT_TIMESTAMP");
            log(TraceLevel.Error, "    TIMES  ", "CURRENT_TIMESTAMP");
            log(TraceLevel.Error, "    C-USID ", hv13001Movdep().movdep().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 2300-ESTORNO-JOURNAL
     * 
     */
    protected void m2300EstornoJournal() {
        log(TraceLevel.Debug, "  2300-ESTORNO-JOURNAL");
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
        log(TraceLevel.Debug, "   VGH13001-I-ESTORNO          : ", hv13001Movdep().movdep().iEstorno());
        log(TraceLevel.Debug, "   VGH13001-C-USID-ACTZ-ULT    : ", hv13001Movdep().movdep().cUsidActzUlt());
        log(TraceLevel.Debug, "   VGH13001-Z-PROCESSAMENTO    : ", hv13001Movdep().movdep().zProcessamento());
        log(TraceLevel.Debug, "   VGH13001-C-MNEM-EGC-OPEX    : ", hv13001Movdep().movdep().cMnemEgcOpex());
        log(TraceLevel.Debug, "   VGH13001-C-PAIS-ISOA-OE-OPX : ", hv13001Movdep().movdep().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   VGH13001-C-OE-EGC-OPEX      : ", hv13001Movdep().movdep().cOeEgcOpex());
        log(TraceLevel.Debug, "   VGH13001-C-USERID           : ", hv13001Movdep().movdep().cUserid());
        log(TraceLevel.Debug, "   VGH13001-N-JOUR-BBN         : ", hv13001Movdep().movdep().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH13001_MOVDEP
         */
        hv13001Movdep().updatePghs163a4886() ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, " ERRO-60");
            log(TraceLevel.Error, "   ERRO NO ESTORN TGH00130 - SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "   CHAVE : ");
            log(TraceLevel.Error, "    Z-PROC ", hv13001Movdep().movdep().zProcessamento());
            log(TraceLevel.Error, "    C-MNEM ", hv13001Movdep().movdep().cMnemEgcOpex());
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsoaOeOpx());
            log(TraceLevel.Error, "    C-OE-E ", hv13001Movdep().movdep().cOeEgcOpex());
            log(TraceLevel.Error, "    C-USER ", hv13001Movdep().movdep().cUserid());
            log(TraceLevel.Error, "    N-JOUR ", hv13001Movdep().movdep().nJourBbn());
        }
    }
    
    /**
     * 
     * 2400-ESTOR-ANUL-REF
     * 
     */
    protected void m2400EstorAnulRef() {
        log(TraceLevel.Debug, "  2400-ESTOR-ANUL-REF");
        log(TraceLevel.Debug, "   WS-C-EST-MSG-SWIF  : ", wsVariaveis().wsCEstMsgSwif());
        /**
         * *---
         */
        if (swSwitchs().swPi3105EstornoOrdens().isTrue()) {
            hv13001Movdep().movdep().iEstorno().set(CON_SIM);
            hv13001Movdep().movdep().cEstMsgSwif().set(wsVariaveis().wsCEstMsgSwif());
        } else if (swSwitchs().swPi3102AnulacaoOrdens().isTrue()) {
            hv13001Movdep().movdep().iEstorno().set(CON_ANULADA);
            hv13001Movdep().movdep().cEstMsgSwif().set(wsVariaveis().wsCEstMsgSwif());
        } else if (swSwitchs().swPi3503AnulEstorChq().isTrue()) {
            hv13001Movdep().movdep().iEstorno().set(CON_ANULADA);
            hv13001Movdep().movdep().cEstMsgSwif().set(0);
        }
        hv13001Movdep().movdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * *---
         */
        hv13001Movdep().movdep().cPaisIsoAlfn().set(msgIn().msg().ade().cPaisIsoAlfn());
        hv13001Movdep().movdep().cMnemEmpGcx().set(msgIn().msg().ade().cMnemEmpGcx());
        hv13001Movdep().movdep().cRefMsgSwif().set(msgIn().msg().ade().cRefMsgSwif());
        log(TraceLevel.Debug, "   VGH13001-I-ESTORNO          : ", hv13001Movdep().movdep().iEstorno());
        log(TraceLevel.Debug, "   VGH13001-C-EST-MSG-SWIF     : ", hv13001Movdep().movdep().cEstMsgSwif());
        log(TraceLevel.Debug, "   BHTL001A-C-USERID           : ", message.mensagem().headerR().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1160-C-PAIS-ISO-ALFN    : ", msgIn().msg().ade().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   BGHM1160-C-MNEM-EMP-GCX     : ", msgIn().msg().ade().cMnemEmpGcx());
        log(TraceLevel.Debug, "   BGHM1160-C-REF-MSG-SWIF     : ", msgIn().msg().ade().cRefMsgSwif());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH13001_MOVDEP
         */
        hv13001Movdep().updatePghs163a4973() ;
        swSwitchs().swSqlcodeVgh13001().set(hv13001Movdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv13001Movdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue() && !swSwitchs().swVgh13001Notfnd().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(hv13001Movdep().getPersistenceCode());
            log(TraceLevel.Error, " ERRO-61");
            log(TraceLevel.Error, "   ERRO NO ESTORN TGH00130 - SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "   CHAVE : ");
            log(TraceLevel.Error, "    C-PAIS ", hv13001Movdep().movdep().cPaisIsoAlfn());
            log(TraceLevel.Error, "    C-MNEM ", hv13001Movdep().movdep().cMnemEmpGcx());
            log(TraceLevel.Error, "    C-REF- ", hv13001Movdep().movdep().cRefMsgSwif());
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
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        log(TraceLevel.Debug, "   BGHM1161-ASE ", msgOut().msg().ase());
        m3100MensagemOutput() ;
        exit() ;
    }
    
    /**
     * 
     * 
     */
    protected void m3010TrataJournal() {
        log(TraceLevel.Debug, "  3010-TRATA-JOURNAL");
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
            log(TraceLevel.Error, "  S I M U L A C A O  ");
            log(TraceLevel.Error, "    ", envOut.errosGraves().aAplErr(), "/", envOut.errosGraves().cRtnoEvenSwal(), "    ");
            log(TraceLevel.Error, "  -----------------  ");
        } else if (!swSwitchs().swAnulacoesEstornosRef().isTrue()) {
            log(TraceLevel.Error, "  ---------------  ");
            log(TraceLevel.Error, "  I N S E R C A O  ");
            log(TraceLevel.Error, "    ", envOut.errosGraves().aAplErr(), "/", envOut.errosGraves().cRtnoEvenSwal(), "    ");
            log(TraceLevel.Error, "  ---------------  ");
        } else {
            log(TraceLevel.Error, "  ---------------  ");
            log(TraceLevel.Error, "  E S T O R N O / A N U L A C A O ");
            log(TraceLevel.Error, "    ", envOut.errosGraves().aAplErr(), "/", envOut.errosGraves().cRtnoEvenSwal(), "    ");
            log(TraceLevel.Error, "  ---------------  ");
        }
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "   BGHM1161-C-PAIS-ISO-ALFN      : ", msgOut().msg().ade().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   BGHM1161-C-MNEM-EMP-GCX       : ", msgOut().msg().ade().cMnemEmpGcx());
        log(TraceLevel.Debug, "   BGHM1161-C-REF-MSG-SWIF       : ", msgOut().msg().ade().cRefMsgSwif());
        log(TraceLevel.Debug, "   BGHM1161-C-TIPO-OPE-CONT      : ", msgOut().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "   BGHM1161-N-CHEQUE             : ", msgOut().msg().ade().nCheque());
        log(TraceLevel.Debug, "   BGHM1161-C-TIPO-ITVT-DEP      : ", msgOut().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "   BGHM1161-M-MOV-NMRI           : ", msgOut().msg().ade().mMovNmri());
        log(TraceLevel.Debug, "   BGHM1161-I-CLI-CGD            : ", msgOut().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "   BGHM1161-C-TIPO-CLI           : ", msgOut().msg().ade().cTipoCli());
        log(TraceLevel.Debug, "   BGHM1161-N-CLIENTE            : ", msgOut().msg().ade().nCliente());
        log(TraceLevel.Debug, "   BGHM1161-NS-ABRA-CLI          : ", msgOut().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "   BGHM1161-NM-CLIENTE           : ", msgOut().msg().ade().nmCliente());
        log(TraceLevel.Debug, "   BGHM1161-Z-NASC-CLI           : ", msgOut().msg().ade().zNascCli());
        log(TraceLevel.Debug, "   BGHM1161-C-PAIS-NACN-CLI      : ", msgOut().msg().ade().cPaisNacnCli());
        log(TraceLevel.Debug, "   BGHM1161-NM-EMP-RNPC          : ", msgOut().msg().ade().nmEmpRnpc());
        log(TraceLevel.Debug, "   BGHM1161-C-AE                 : ", msgOut().msg().ade().cAe());
        log(TraceLevel.Debug, "   BGHM1161-D-AE                 : ", msgOut().msg().ade().dAe());
        log(TraceLevel.Debug, "   BGHM1161-N-IPC                : ", msgOut().msg().ade().nIpc());
        log(TraceLevel.Debug, "   BGHM1161-I-CLI-CGD-RPRT       : ", msgOut().msg().ade().iCliCgdRprt());
        log(TraceLevel.Debug, "   BGHM1161-C-TIPO-CLI-RPRT      : ", msgOut().msg().ade().cTipoCliRprt());
        log(TraceLevel.Debug, "   BGHM1161-N-CLIENTE-RPRT       : ", msgOut().msg().ade().nClienteRprt());
        log(TraceLevel.Debug, "   BGHM1161-NS-ABRA-CLI-RPRT     : ", msgOut().msg().ade().nsAbraCliRprt());
        log(TraceLevel.Debug, "   BGHM1161-NM-CLIENTE-RPRT      : ", msgOut().msg().ade().nmClienteRprt());
        log(TraceLevel.Debug, "   BGHM1161-Z-NASC-CLI-RPRT      : ", msgOut().msg().ade().zNascCliRprt());
        log(TraceLevel.Debug, "   BGHM1161-C-PAIS-NACN-CLI-RP   : ", msgOut().msg().ade().cPaisNacnCliRp());
        log(TraceLevel.Debug, "   BGHM1161-C-PAIS-EMS-DOC-APT   : ", msgOut().msg().ade().cPaisEmsDocApt());
        log(TraceLevel.Debug, "   BGHM1161-C-TIPO-DOC-ID-APTD   : ", msgOut().msg().ade().cTipoDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1161-N-DOC-ID-APTD        : ", msgOut().msg().ade().nDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1161-Z-VLDE-DOC-ID-APTD   : ", msgOut().msg().ade().zVldeDocIdAptd());
        log(TraceLevel.Debug, "   BGHM1161-C-ENT-EMI-DID-APTD   : ", msgOut().msg().ade().cEntEmiDidAptd());
        log(TraceLevel.Debug, "   BGHM1161-C-PAIS-ISA-EMS-DOC   : ", msgOut().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BGHM1161-C-TIPO-DOC-ID        : ", msgOut().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "   BGHM1161-N-DOC-ID             : ", msgOut().msg().ade().nDocId());
        log(TraceLevel.Debug, "   BGHM1161-Z-VLDE-DOC-ID        : ", msgOut().msg().ade().zVldeDocId());
        log(TraceLevel.Debug, "   BGHM1161-C-ENT-EMIX-DOC-ID    : ", msgOut().msg().ade().cEntEmixDocId());
        log(TraceLevel.Debug, "   BGHM1161-C-PAIS-EMS-DOC-RPT   : ", msgOut().msg().ade().cPaisEmsDocRpt());
        log(TraceLevel.Debug, "   BGHM1161-C-TIPO-DOC-ID-RPRT   : ", msgOut().msg().ade().cTipoDocIdRprt());
        log(TraceLevel.Debug, "   BGHM1161-N-DOC-ID-RPRT        : ", msgOut().msg().ade().nDocIdRprt());
        log(TraceLevel.Debug, "   BGHM1161-Z-VLDE-DOC-ID-RPRT   : ", msgOut().msg().ade().zVldeDocIdRprt());
        log(TraceLevel.Debug, "   BGHM1161-C-ENT-EMIX-DID-RPT   : ", msgOut().msg().ade().cEntEmixDidRpt());
        log(TraceLevel.Debug, "   BGHM1161-I-PED-JSTZ-ORM-FND   : ", msgOut().msg().ade().iPedJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1161-I-RCS-JSTZ-ORM-FND   : ", msgOut().msg().ade().iRcsJstzOrmFnd());
        log(TraceLevel.Debug, "   BGHM1161-C-MTVO-PED-JSTZ      : ", msgOut().msg().ade().cMtvoPedJstz());
        log(TraceLevel.Debug, "   BGHM1161-M-ACMD-LIM-OPE       : ", msgOut().msg().ade().mAcmdLimOpe());
        log(TraceLevel.Debug, "   BGHM1161-Z-PROCESSAMENTO      : ", msgOut().msg().ade().nrElectronico().zProcessamento());
        log(TraceLevel.Debug, "   BGHM1161-C-MNEM-EGC-OPEX      : ", msgOut().msg().ade().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BGHM1161-C-PAIS-ISOA-OE-OPX   : ", msgOut().msg().ade().nrElectronico().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BGHM1161-C-OE-EGC-OPEX        : ", msgOut().msg().ade().nrElectronico().cOeEgcOpex());
        log(TraceLevel.Debug, "   BGHM1161-C-USERID             : ", msgOut().msg().ade().nrElectronico().cUserid());
        log(TraceLevel.Debug, "   BGHM1161-N-JOUR-BBN           : ", msgOut().msg().ade().nrElectronico().nJourBbn());
        log(TraceLevel.Debug, "   BGHM1161-Q-MOED               : ", msgOut().msg().ade().qMoed());
        log(TraceLevel.Debug, "   BGHM1161-I-DOC-DSZD           : ", msgOut().msg().ade().iDocDszd());
        log(TraceLevel.Debug, "   BGHM1161-I-NCSS-TRR-FOTOC     : ", msgOut().msg().ade().iNcssTrrFotoc());
        log(TraceLevel.Debug, "   BGHM1161-I-CBRC-ENCG          : ", msgOut().msg().ade().iCbrcEncg());
        log(TraceLevel.Debug, "   BGHM1161-C-FAMI-PROD          : ", msgOut().msg().ade().cFamiProd());
        log(TraceLevel.Debug, "   BGHM1161-C-PRODUTO            : ", msgOut().msg().ade().cProduto());
        log(TraceLevel.Debug, "   BGHM1161-I-INSZ-DOC-ID-CLI    : ", msgOut().msg().ade().iInszDocIdCli());
        log(TraceLevel.Debug, "   BGHM1161-C-EST-CLI-FLTG       : ", msgOut().msg().ade().cEstCliFltg());
        log(TraceLevel.Debug, "   BGHM1161-C-PFI-RIS-BRQM-CAP   : ", msgOut().msg().ade().cPfiRisBrqmCap());
        log(TraceLevel.Debug, "   BGHM1161-I-DOC-DSZD-RPRT      : ", msgOut().msg().ade().iDocDszdRprt());
        log(TraceLevel.Debug, "   BGHM1161-I-NCSS-TRR-FOT-RPT   : ", msgOut().msg().ade().iNcssTrrFotRpt());
        log(TraceLevel.Debug, "   BGHM1161-I-INSZ-DOC-CLI-RPT   : ", msgOut().msg().ade().iInszDocCliRpt());
        log(TraceLevel.Debug, "   ------DADOS DA ARQUITETURA------");
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-SIMZ          : ", message.mensagem().headerR().iTrnzSimz());
        log(TraceLevel.Debug, "   BHTL001A-I-TRNZ-EFCD-ONLN     : ", message.mensagem().headerR().iTrnzEfcdOnln());
        log(TraceLevel.Debug, "   BHTL001A-I-ESTORNO            : ", message.mensagem().headerR().iEstorno());
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "******** FIM * GHIK * MVPHIK * FIM ***********");
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
     * *---DOCUMENTOS FISCAIS VALIDOS - SINGULAR
     * 
     * @version 2.0
     * 
     */
    public interface ConDocNif extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNifCPais() ;
        
        @Data(size=3, value="501")
        IString conNifTDoc() ;
        
    }
    public interface ConDocNfePs extends IDataStruct {
        
        @Data(size=3, value="PT")
        IString conNfeCPais() ;
        
        @Data(size=3, value="806")
        IString conNfeTDoc() ;
        
    }
    
    /**
     * 
     * *---DOCUMENTOS VALIDOS PARA CLIENTES EMPRESA
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
     * *PASS2972 - FIM
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
    
    /**
     * 
     * *GH2024--> INICIO
     * 
     * @version 2.0
     * 
     */
    public interface WsTabInternaDoc extends IDataStruct {
        
        /**
         * @return instancia da classe local WsZVldDocumento
         */
        @Data(length=250)
        IArray<WsZVldDocumento> wsZVldDocumento() ;
        
        
        public interface WsZVldDocumento extends IDataStruct {
            
            @Data(size=10, value=" ")
            IString wsTabZVldeDoc() ;
            
            @Data(size=20, value=" ")
            IString wsTdCCodigoDoc() ;
            
        }
    }
    
    /**
     * 
     * *GH2024--> FIM
     * VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * --TAB INTERNA - DOCUMENTO PRINCIPAL
         */
        @Data(size=3, value="0")
        IInt wsIndExt() ;
        
        @Data(size=3, value="0")
        IInt wsIndInt() ;
        
        @Data(size=3, value="0")
        IInt wsInd() ;
        
        @Data(size=3, value="0")
        IInt wsIndoc() ;
        
        /**
         * @return instancia da classe local WsCodCodigo
         */
        @Data
        WsCodCodigo wsCodCodigo() ;
        
        @Data(size=20, value=" ")
        IString wsCCodigoTemp() ;
        
        @Data(size=20, value=" ")
        IString wsXCteuCo03Temp() ;
        
        /**
         * --MONTANTE ACUMULADO
         */
        @Data(size=4, signed=true, value="0", compression=COMP)
        IInt wsStNull() ;
        
        @Data(size=17, decimal=2, signed=true, value="0", compression=COMP3)
        IDecimal wsMtItvtOpe() ;
        
        @Data(size=17, decimal=2, signed=true, value="0")
        IDecimal wsMontTotal() ;
        
        @Data(format="-9(15)V99", value="0")
        IFormattedString wsMontTotalDisplay() ;
        
        @Data(size=10, value=" ")
        IString wsZVldeDocIdEmpPrin() ;
        
        @Data(size=10, value=" ")
        IString wsZMovimentoUlt() ;
        
        @Data(size=10, value=" ")
        IString wsZMovimento30() ;
        
        @Data(size=10, value=" ")
        IString wsZMovUltJustf() ;
        
        @Data(size=26, value=" ")
        IString wsTsInsUltJustf() ;
        
        /**
         * @return instancia da classe local WsTsInsUltJustfTemp
         */
        @Data
        WsTsInsUltJustfTemp wsTsInsUltJustfTemp() ;
        
        @Data(size=10, value="0")
        ILong wsBhjl006aNCliente() ;
        
        @Data(size=10, value="0")
        ILong wsBhjl470aNCliente() ;
        
        @Data(size=3, value="0")
        IInt wsBhjl470aNsAbraCli() ;
        
        @Data(size=3, value=" ")
        IString wsBhjl027aCPaisIsaDoc() ;
        
        @Data(size=3, value=" ")
        IString wsBhjl027aCTipoDocId() ;
        
        @Data(size=20, value=" ")
        IString wsBhjl027aNDocId() ;
        
        @Data(size=3, value=" ")
        IString wsBhel100aCPaisIsaDoc() ;
        
        @Data(size=3, value=" ")
        IString wsBhel100aCTipoDocId() ;
        
        @Data(size=20, value=" ")
        IString wsBhel100aNDocId() ;
        
        @Data(size=10, value="0")
        ILong wsBhel100aNPrcpNcli() ;
        
        @Data(size=10, value="0")
        ILong wsNCliente() ;
        
        @Data(size=3, value="0")
        IInt wsNsAbraCli() ;
        
        @Data(size=2, value="0")
        IInt wsCEstMsgSwif() ;
        
        @Data(format="999-", value="0")
        IFormattedString wsSqlcodeErro() ;
        
        /**
         * *-- NIPC CLIENTE NAO CGD
         */
        @Data(size=3, value=" ")
        IString wsCPaisDocPcl() ;
        
        @Data(size=3, value=" ")
        IString wsCTipoDocPcl() ;
        
        
        public interface WsCodCodigo extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCcCPais() ;
            
            @Data(size=3, value=" ")
            IString wsCcTDoc() ;
            
        }
        
        public interface WsTsInsUltJustfTemp extends IDataStruct {
            
            @Data(size=10)
            IString wsData() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IInt wsHora() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wsMin() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wsSec() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wsRest() ;
            
        }
    }
    
    /**
     * 
     * *-- SWITCHS
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitchs extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh13001() ;
        @Data
        @Condition("0")
        ICondition swVgh13001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh13001Notfnd() ;
        
        
        @Data(size=1, value=" ")
        IString swItvtTemMov() ;
        @Data
        @Condition("N")
        ICondition swItvtSemMov() ;
        @Data
        @Condition("S")
        ICondition swItvtComMov() ;
        
        
        @Data(size=1, value=" ")
        IString swItvtTemJustf() ;
        @Data
        @Condition("N")
        ICondition swItvtSemJustf() ;
        @Data
        @Condition("S")
        ICondition swItvtComJustf() ;
        
        
        @Data(size=2, value=" ")
        IString swTipoItvtTipoCli() ;
        @Data
        @Condition("OP")
        ICondition swOrdenanteParticular() ;
        @Data
        @Condition("BP")
        ICondition swBeneficiarioParticular() ;
        @Data
        @Condition("OE")
        ICondition swOrdenanteEmpresa() ;
        @Data
        @Condition("BE")
        ICondition swBeneficiarioEmpresa() ;
        
        
        /**
         * *-- TIPO DE CLIENTE INTERVENIENTE NA OPERACAO
         */
        @Data(size=2, value=" ")
        IString swValidaTipoCliItvt() ;
        @Data
        @Condition("E")
        ICondition swCliEmpresaItvt() ;
        @Data
        @Condition("P")
        ICondition swCliParticularItvt() ;
        @Data
        @Condition("I")
        ICondition swCliEniItvt() ;
        @Data
        @Condition({ "P", "I" })
        ICondition swCliNEmpresaItvt() ;
        
        
        /**
         * *-- TIPO DE CLIENTE REPRESENTANTE
         */
        @Data(size=2, value=" ")
        IString swValidaTipoCliRprt() ;
        @Data
        @Condition("E")
        ICondition swCliEmpresaRprt() ;
        @Data
        @Condition("P")
        ICondition swCliParticularRprt() ;
        @Data
        @Condition("I")
        ICondition swCliEniRprt() ;
        @Data
        @Condition({ "P", "I" })
        ICondition swCliNEmpresaRprt() ;
        
        
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
        IString swBuscaDoc() ;
        @Data
        @Condition("S")
        ICondition swBuscaDocSim() ;
        @Data
        @Condition("N")
        ICondition swBuscaDocNao() ;
        
        
        /**
         * *-- VALIDADO DOCUMENTO APRESENTADO E DO REPRESENTANTE
         */
        @Data(size=1, value=" ")
        IString swValidaNDocCli() ;
        @Data
        @Condition("A")
        ICondition swValidaNDocCliAptd() ;
        @Data
        @Condition("R")
        ICondition swValidaNDocCliRprt() ;
        
        
        /**
         * *-- TIPO DE OPERACAO DE ENTRADA (CHAMAM A GHIK)
         * TABELA GERAL LOGICA 'G65' - TIPO DE OPERACAO NA CONTA
         */
        @Data(size=1, value=" ")
        IString swCTipoOpeCont() ;
        @Data
        @Condition({ "C", "J", "K" })
        ICondition swCambio() ;
        @Data
        @Condition("J")
        ICondition swSgocvnHe34() ;
        @Data
        @Condition("K")
        ICondition swSgocvnHe35() ;
        @Data
        @Condition("D")
        ICondition swTrocoDestroco() ;
        @Data
        @Condition({ "T", "S", "R" })
        ICondition swTransferencias() ;
        @Data
        @Condition("S")
        ICondition swOrdensEmitidas() ;
        @Data
        @Condition("R")
        ICondition swOrdensRecebidas() ;
        @Data
        @Condition({ "O", "X", "H", "Y", "V" })
        ICondition swOcasionais() ;
        @Data
        @Condition("X")
        ICondition swSgix02() ;
        @Data
        @Condition("H")
        ICondition swSgovtcHe37() ;
        @Data
        @Condition("Y")
        ICondition swPi3501EmissChq() ;
        @Data
        @Condition("V")
        ICondition swChqhb0ChqBancario() ;
        @Data
        @Condition({ "J", "K", "D", "S", "R", "X", "H", "Y", "V" })
        ICondition swTipoOpeValIns() ;
        @Data
        @Condition({ "S", "R", "U", "W" })
        ICondition swTipoOpeValEstOrdem() ;
        @Data
        @Condition({ "U", "W", "Z" })
        ICondition swAnulacoesEstornosRef() ;
        @Data
        @Condition("U")
        ICondition swPi3105EstornoOrdens() ;
        @Data
        @Condition("W")
        ICondition swPi3102AnulacaoOrdens() ;
        @Data
        @Condition("Z")
        ICondition swPi3503AnulEstorChq() ;
        @Data
        @Condition({ "C", "J", "K", "D", "T", "S", "R", "O", "X", "H", "Y", "V", "U", "W", "Z" })
        ICondition swTodosCTipoOpe() ;
        
        
    }
    
}
