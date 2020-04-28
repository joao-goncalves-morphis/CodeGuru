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
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.gh.persistence.database.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.gh.structures.messages.Bghm1190 ;
import cgd.gh.structures.messages.Bghm1191 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hh.structures.link.Bhhl070a ;
import cgd.hy.structures.work.Bhyw0001 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.gh.common.constants.Bghk0005 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.ht.structures.work.Bhtw0009 ;
import cgd.hj.structures.link.Bhjl051a ;
import cgd.hj.structures.link.Bhjl013a ;
import cgd.hj.structures.link.Bhjl101a ;
import cgd.ht.routines.Mhts220a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.gh.online.Pghs191a ;
import cgd.hj.routines.Mhjj051a ;
import cgd.hj.routines.Mhjj013a ;
import cgd.hj.routines.Mhjj101a ;


/**
 * 
 * AREA DE LIGACAO DA MHJJ101A
 * TABELA DE MOVIMENTOS DA EXTENSAO DE GARANTIA
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS193A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1863
 * FUNCAO     : HISTORICO DE MOVIMENTOS PASSIVAS - MANUTENCAO DA
 * EXTENSAO DE GARANTIA DE UM MOVIMENTO, BEM COMO
 * TODOS OS TITULARES ABRANGIDOS.
 * TIPO       : ONLINE COM DB2
 * OBSERVACOES:
 * LOG DE ALTERACOES
 * PROC.GIP !   DATA   !UTILIZ.! OBSERVACOES
 * GH1863  !2015-09-08!E000973! CRIACAO
 * GH1921  !2016-03-10!E002079! MANUTENÇÃO DOS MOVIMENTOS
 * !          !       ! MARCADOS COMO EXTENSÃO DA GARANTIA
 * !          !       ! DE DEPÓSITOS
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs193a extends CgdGhBaseOnline<Pghs193a.EnvelopeIn, Pghs193a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1190
     */
    public abstract Bghm1190 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1191
     */
    public abstract Bghm1191 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1190.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bghm1191.Msg msgOut() ;
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
     * @return instancia da classe Vwsdghps20001Movexgdep
     */
    @Data
    protected abstract Vwsdghps20001Movexgdep hv20001Movexgdep() ;
    
    /**
     * @return instancia da classe Vwsdghps20101Titexgdep
     */
    @Data
    protected abstract Vwsdghps20101Titexgdep hv20101Titexgdep() ;
    
    
    /**
     * Handled Services
     */
    /**
     * @return instancia da classe Pghs191a
     */
    protected abstract Pghs191a hoPghs191a() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhts220a
     */
    @Data
    protected abstract Mhts220a hrMhts220a() ;
    
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    /**
     * @return instancia da classe Mhjj051a
     */
    @Data
    protected abstract Mhjj051a hrMhjj051a() ;
    
    /**
     * @return instancia da classe Mhjj013a
     */
    @Data
    protected abstract Mhjj013a hrMhjj013a() ;
    
    /**
     * @return instancia da classe Mhjj101a
     */
    @Data
    protected abstract Mhjj101a hrMhjj101a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhhl070a
     */
    @Data
    protected abstract Bhhl070a bhhl070a() ;
    
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
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhtw0009
     */
    @Data
    protected abstract Bhtw0009 bhtw0009() ;
    
    /**
     * @return instancia da classe Bhjl051a
     */
    @Data
    protected abstract Bhjl051a bhjl051a() ;
    
    /**
     * @return instancia da classe Bhjl013a
     */
    @Data
    protected abstract Bhjl013a bhjl013a() ;
    
    /**
     * @return instancia da classe Bhjl101a
     */
    @Data
    protected abstract Bhjl101a bhjl101a() ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHS193A" ;
    
    protected static final String CON_PROGRAMA_CONSULTA = "PGHS191A" ;
    
    protected static final String CON_APLICACAO_GH = "GH" ;
    
    protected static final String CON_APLICACAO_HO = "HO" ;
    
    protected static final String CON_ACAO_MODIFICAR = "M" ;
    
    protected static final String CON_ATIVO = "A" ;
    
    protected static final String CON_CANCELADO = "C" ;
    
    protected static final String CON_ABRANGIDO = "S" ;
    
    protected static final String CON_NAO_ABRANGIDO = "N" ;
    
    protected static final String CON_DATA_MINIMA = "0001-01-01" ;
    
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_CLI_TIT_DIFTS = -439 ;
    
    protected static final int CON_ALTERACAO_N_PERMT = 110 ;
    
    /**
     * DB2
     */
    protected static final String CON_VGH20001 = "VGH20001" ;
    
    protected static final String CON_VGH20101 = "VGH20101" ;
    
    /**
     * TABELA INTERNAS
     * VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    @Data(size=1, value=" ")
    protected IString swMarcacaoMov ;
    @Data
    @Condition("1")
    protected ICondition swPrimeiraMarcacao ;
    @Data
    @Condition("2")
    protected ICondition swAtualizaMarcacao ;
    
    
    /**
     * -- FICA ATIVO QUANDO EXISTEM REGISTOS INSERIDOS NA TGH000201
     * -- CUJOS TITULARES NAO ESTAO ABRANGIDOS PELA EXTENSAO DA
     * -- GARANTIA, I.E., TODOS COM I_TITC_EXS_GAR_DEP A 'N'
     * *GH1921(I)
     * 88 SW-EXTENSAO-MOV-ANULADA                   VALUE '3'.
     * *GH1921(F)
     * SWITCHS
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
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
    }
    
    /**
     * 
     * . MOVE NOME DO PROGRAMA A EXECUTAR PARA BHTW0009-PGMID
     * . MOVE NR. SEQ. DE OPERACAO <> 00  PARA
     * BHTW0009-SEQUENCIA-OPER
     * . MOVE MSG A PROCESSAR PARA BHTW0009-MSG-SUB-FUNCAO
     * . MOVE LENGTH DA MSG A PROCESSAR PARA
     * BHTW0009-LENFTH-SUB-FUNCAO
     * . MOVE NR.CAMPOS DA MSG A PROCESSAR
     * BHTW0009-NR-CAMPOS-SUB-FUNCAO
     * == OBTEM ==
     * . NA BHTL001A - SQLCA E ERROS POSSIVEIS
     * . CICS LOG
     * BHTP0007
     * LINK A PROGRAMA DE FUNCAO A PARTIR DE
     * PROGRAMA DE FUNCAO BASE
     * EX. DP (CONSTITUI DEPOSITO A PRAZO)
     * LINK (PROGRAMA DEB DE DO PASSANDO COMMAREA)
     * 
     */
    protected void bhtp0007NovaFuncao() {
        bhtw0009().commarea().set(envelope);
        bhtw0009().commarea().header3().aAplOrig().set(message.mensagem().headerR().transaccao().aAplicacao());
        bhtw0009().commarea().header3().cOpczMenuOrig().set(message.mensagem().headerR().transaccao().cOpczMenu());
        bhtw0009().commarea().header3().nsJourBbnOut().set(0);
        bhtw0009().commarea().mensagem().headerR().cTransaccao().aAplicacao().set(bhtw0009().camposControlo().aAplicacaoSfun());
        bhtw0009().commarea().mensagem().headerR().cTransaccao().cOpczMenu().set(bhtw0009().camposControlo().cOpczMenuSfun());
        bhtw0009().commarea().journal().nsJourBbn().set(bhtw0009().camposControlo().nsJourBbnSfun());
        bhtw0009().commarea().mensagem().qCterCmptAlig().set(bhtw0009().camposControlo().qCterCmptAligSfun());
        bhtw0009().commarea().mensagem().qCampEstTrnz().set(bhtw0009().camposControlo().qCampEstTrnzSfun());
        bhtw0009().commarea().mensagem().xMsgBbn().set(bhtw0009().camposControlo().xMsgBbnSfun());
        bhtw0009().commarea().iCexiApl().set(envOut.iCexiApl());
        bhtw0009().commarea().cTrnzProx().set(envOut.cTrnzProx());
        bhtw0009().commarea().controlo().iTipoOrigTrnz().set(envIn.controlo().iTipoOrigTrnz());
        bhtw0009().commarea().cImgTabJour().set(envOut.cImgTabJour());
        bhtw0009().commarea().iTabJourMov().set(envOut.iTabJourMov());
        hoPghs191a().run() ;
        envOut.header3().nsJourBbnOut().set(bhtw0009().commarea().journal().nsJourBbn());
        envOut.db2Log().set(bhtw0009().commarea().db2Log());
        envOut.autorizacoesNiv().set(bhtw0009().commarea().autorizacoesNiv());
        envOut.cicsLog().set(bhtw0009().commarea().cicsLog());
        envOut.errosGraves().set(bhtw0009().commarea().errosGraves());
    }
    
    /**
     * 
     * 
     */
    protected void bhtp0007ErroFuncao() {
        envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendCics());
        envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
        envOut.cicsLog().cEibfn().set("EIBFN");
        envOut.cicsLog().cEibrcode().set("EIBRCODE");
        envOut.cicsLog().cEibrsrce().set("EIBRSRCE");
    }
    
    /**
     * 
     * BHJP5051-ACESSO AO MODULO QUE OBTEM OBTEM OS CONTRATOS ACTIVOS
     * DE UM CLIENTE NUMA DETERMINADA DATA , COM POSSIBILIDADE DE
     * LIMITAR OS RESULTADOS POR  I_TIPO_ITVT (MHJJ051A)
     * 
     */
    protected void bhjp5051AcedeMhjj051a() {
    }
    
    /**
     * 
     * BHJP5013-ACESSO AO MODULO DE OBTENCAO DOS DADOS
     * BASICOS DO CLIENTE (MHJJ013A)
     * 
     */
    protected void bhjp5013AcedeMhjj013a() {
    }
    
    /**
     * 
     * BHJP5101-MODULO QUE DEVOLVA OS CONTRATOS ACTIVOS ENTRE DATAS*
     * 
     */
    protected void bhjp5101AcedeMhjj101a() {
        hrMhjj101a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "********** INICIO DO PROGRAMA ****************");
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
        log(TraceLevel.Debug, "* * * * * * * * * * * * * * * * * * * * * * * *");
        log(TraceLevel.Debug, " BHTL001A-C-TIPO-ERRO-BBN:", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Debug, "* * * * * * * * * * * * * * * * * * * * * * * *");
        log(TraceLevel.Debug, "***********************************************");
        log(TraceLevel.Debug, " OCORRENCIAS DE INPUT -----> ", msgIn().indice());
        log(TraceLevel.Debug, "***********************************************");
        wsVariaveis().initialize() ;
        hv20001Movexgdep().movexgdep().initialize() ;
        hv20101Titexgdep().titexgdep().initialize() ;
        msgOut().msg().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().msg().ade().set(msgIn().msg().ade());
        msgOut().indice().set(CON_1N);
        while (msgOut().indice().isLessOrEqual(msgOut().indiceInverso())) {
            msgOut().msg().ade().linha().get(msgOut().indice()).iAcczMntzLstaL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iTitcExsGarL().set("0");
            msgOut().msg().ade().linha().get(msgOut().indice()).nsItvtL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).iTipoItvtL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(0);
            msgOut().indice().add(CON_1N);
        }
        log(TraceLevel.Debug, "BGHM1190-ASE : ", msgIn().msg().ase());
        m1100MensagemInput() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m1200ValidaInput() ;
        }
    }
    
    /**
     * 
     * 1100-MENSAGEM-INPUT
     * 
     */
    protected void m1100MensagemInput() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "***    M E N S A G E M    I N P U T    ***");
        log(TraceLevel.Debug, "     . BGHM1190-C-PAIS-ISOA-CONT     : ", msgIn().msg().ade().scta().cPaisIsoaCont());
        log(TraceLevel.Debug, "     . BGHM1190-C-BANC-CONT          : ", msgIn().msg().ade().scta().cBancCont());
        log(TraceLevel.Debug, "     . BGHM1190-C-OE-EGC-CONT        : ", msgIn().msg().ade().scta().cOeEgcCont());
        log(TraceLevel.Debug, "     . BGHM1190-NS-RDCL-CONT         : ", msgIn().msg().ade().scta().nsRdclCont());
        log(TraceLevel.Debug, "     . BGHM1190-V-CHKD-CONT          : ", msgIn().msg().ade().scta().vChkdCont());
        log(TraceLevel.Debug, "     . BGHM1190-C-TIPO-CONT          : ", msgIn().msg().ade().scta().cTipoCont());
        log(TraceLevel.Debug, "     . BGHM1190-C-MOED-ISO-SCTA      : ", msgIn().msg().ade().scta().cMoedIsoScta());
        log(TraceLevel.Debug, "     . BGHM1190-NS-DEPOSITO          : ", msgIn().msg().ade().scta().nsDeposito());
        log(TraceLevel.Debug, "     . BGHM1190-NS-MOVIMENTO        : ", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "     . BGHM1190-Z-MOVIMENTO         : ", msgIn().msg().ade().dadosGarantia().zMovimento());
        log(TraceLevel.Debug, "     . BGHM1190-M-MONTANTE-MOV      : ", msgIn().msg().ade().dadosGarantia().mMontanteMov());
        log(TraceLevel.Debug, "     . BGHM1190-C-MOED-MOV          : ", msgIn().msg().ade().dadosGarantia().cMoedMov());
        log(TraceLevel.Debug, "     . BGHM1190-M-MONTANTE-EXT      : ", msgIn().msg().ade().dadosGarantia().mMontanteExt());
        log(TraceLevel.Debug, "     . BGHM1190-C-MOED-EXT          : ", msgIn().msg().ade().dadosGarantia().cMoedExt());
        log(TraceLevel.Debug, "     . BGHM1190-C-CAR-EXT           : ", msgIn().msg().ade().dadosGarantia().cCarExt());
        log(TraceLevel.Debug, "     . BGHM1190-Z-INI-GARANTIA      : ", msgIn().msg().ade().dadosGarantia().zIniGarantia());
        log(TraceLevel.Debug, "     . BGHM1190-Z-FIM-GARANTIA      : ", msgIn().msg().ade().dadosGarantia().zFimGarantia());
        log(TraceLevel.Debug, "     . BGHM1190-NS-INT-SOL          : ", msgIn().msg().ade().solicitador().nsIntSol());
        log(TraceLevel.Debug, "     . BGHM1190-N-CLIENTE-SOL       : ", msgIn().msg().ade().solicitador().nClienteSol());
        log(TraceLevel.Debug, "     . BGHM1190-NM-CLI-ABV-SOL      : ", msgIn().msg().ade().solicitador().nmCliAbvSol());
        log(TraceLevel.Debug, "     . BGHM1190-C-TIPO-SOL          : ", msgIn().msg().ade().solicitador().cTipoSol());
        log(TraceLevel.Debug, "     . BGHM1190-I-TODOS-TIT-ABGD    : ", msgIn().msg().ade().iTodosTitAbgd());
        log(TraceLevel.Debug, "**********************************************");
    }
    
    /**
     * 
     * 1200-VALIDA-INPUT
     * 
     */
    protected void m1200ValidaInput() {
        log(TraceLevel.Debug, "1200-VALIDA-INPUT");
        /**
         * DADOS DE INPUT
         */
        if (msgIn().msg().ade().scta().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().scta().cBancCont().isEqual(0) || 
            !msgIn().msg().ade().scta().cBancCont().isNumeric() || 
            msgIn().msg().ade().scta().cOeEgcCont().isEqual(0) || 
            !msgIn().msg().ade().scta().cOeEgcCont().isNumeric() || 
            !msgIn().msg().ade().scta().nsRdclCont().isNumeric() || 
            !msgIn().msg().ade().scta().vChkdCont().isNumeric() || 
            !msgIn().msg().ade().scta().cTipoCont().isNumeric() || 
            msgIn().msg().ade().scta().cMoedIsoScta().isEmpty() || 
            !msgIn().msg().ade().scta().nsDeposito().isNumeric() || 
            !msgIn().msg().ade().nsMovimento().isNumeric() || 
            msgIn().msg().ade().nsMovimento().isEqual(0) || 
            msgIn().msg().ade().dadosGarantia().zMovimento().isEqual(CON_DATA_MINIMA) || 
            msgIn().msg().ade().dadosGarantia().mMontanteMov().isEqual(0) || 
            msgIn().msg().ade().dadosGarantia().cMoedMov().isEmpty() || 
            msgIn().msg().ade().dadosGarantia().mMontanteExt().isEqual(0) || 
            msgIn().msg().ade().dadosGarantia().cMoedExt().isEmpty() || 
            msgIn().msg().ade().dadosGarantia().cCarExt().isEmpty() || 
            msgIn().msg().ade().dadosGarantia().zIniGarantia().isEqual(CON_DATA_MINIMA) || 
            msgIn().msg().ade().dadosGarantia().zFimGarantia().isEqual(CON_DATA_MINIMA) || 
            msgIn().msg().ade().solicitador().nsIntSol().isEqual(0) || 
            msgIn().msg().ade().solicitador().nClienteSol().isEqual(0) || 
            msgIn().msg().ade().solicitador().cTipoSol().isEqual(0)) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            log(TraceLevel.Error, "ERRO-01");
        }
        if (msgIn().msg().ade().dadosGarantia().zIniGarantia().isGreater(message.mensagem().headerR().datasProcesso().zPrctJourBbn())) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
            log(TraceLevel.Error, "ERRO-14");
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * -- OBTEM NS-ABRA-CLI
             */
            m1211ObtemNsAbraCli() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * -- VALIDA TITULAR SOLICITADOR DA EXTENSAO DA GARANTIA
             */
            m1212ValidaTitSol() ;
        }
    }
    
    /**
     * 
     * 1211-OBTEM-NS-ABRA-CLI
     * 
     */
    protected void m1211ObtemNsAbraCli() {
        log(TraceLevel.Debug, " 1211-OBTEM-NS-ABRA-CLI");
        bhjl013a().commarea().initialize() ;
        bhjl013a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        bhjl013a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        bhjl013a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        bhjl013a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        bhjl013a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        bhjl013a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        bhjl013a().commarea().dadosEntrada().iTipoItvt().set(msgIn().msg().ade().solicitador().cTipoSol());
        bhjl013a().commarea().dadosEntrada().nsTitc().set(msgIn().msg().ade().solicitador().nsIntSol());
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
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl013a().commarea().erros().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 1212-VALIDA-TIT-SOL
     * 
     */
    protected void m1212ValidaTitSol() {
        log(TraceLevel.Debug, " 1212-VALIDA-TIT-SOL");
        bhjl101a().commarea().initialize() ;
        bhjl101a().commarea().dadosEntrada().unica().setTrue() ;
        bhjl101a().commarea().dadosEntrada().nCliente().set(msgIn().msg().ade().solicitador().nClienteSol());
        bhjl101a().commarea().dadosEntrada().nsAbraCli().set(bhjl013a().commarea().dadosEntrada().nsAbraCli());
        bhjl101a().commarea().dadosEntrada().zConsultaIni().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        bhjl101a().commarea().dadosEntrada().zConsultaFim().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        bhjl101a().commarea().dadosEntrada().cPaisIsoaContI().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        bhjl101a().commarea().dadosEntrada().cBancContI().set(msgIn().msg().ade().scta().cBancCont());
        bhjl101a().commarea().dadosEntrada().cOeEgcContI().set(msgIn().msg().ade().scta().cOeEgcCont());
        bhjl101a().commarea().dadosEntrada().nsRdclContI().set(msgIn().msg().ade().scta().nsRdclCont());
        bhjl101a().commarea().dadosEntrada().vChkdContI().set(msgIn().msg().ade().scta().vChkdCont());
        bhjl101a().commarea().dadosEntrada().cTipoContI().set(msgIn().msg().ade().scta().cTipoCont());
        log(TraceLevel.Debug, " A C E S S O   M H J J 1 0 1 A");
        log(TraceLevel.Debug, " --> BHJL101A-MODO-ACESSO      :", bhjl101a().commarea().dadosEntrada().modoAcesso());
        log(TraceLevel.Debug, " --> BHJL101A-N-CLIENTE        :", bhjl101a().commarea().dadosEntrada().nCliente());
        log(TraceLevel.Debug, " --> BHJL101A-NS-ABRA-CLI      :", bhjl101a().commarea().dadosEntrada().nsAbraCli());
        log(TraceLevel.Debug, " --> BHJL101A-Z-CONSULTA-INI   :", bhjl101a().commarea().dadosEntrada().zConsultaIni());
        log(TraceLevel.Debug, " --> BHJL101A-Z-CONSULTA-FIM   :", bhjl101a().commarea().dadosEntrada().zConsultaFim());
        log(TraceLevel.Debug, " --> BHJL101A-C-PAIS-ISOA-CONT-I:", bhjl101a().commarea().dadosEntrada().cPaisIsoaContI());
        log(TraceLevel.Debug, " --> BHJL101A-C-BANC-CONT-I    :", bhjl101a().commarea().dadosEntrada().cBancContI());
        log(TraceLevel.Debug, " --> BHJL101A-C-OE-EGC-CONT-I  :", bhjl101a().commarea().dadosEntrada().cOeEgcContI());
        log(TraceLevel.Debug, " --> BHJL101A-NS-RDCL-CONT-I   :", bhjl101a().commarea().dadosEntrada().nsRdclContI());
        log(TraceLevel.Debug, " --> BHJL101A-V-CHKD-CONT-I    :", bhjl101a().commarea().dadosEntrada().vChkdContI());
        log(TraceLevel.Debug, " --> BHJL101A-C-TIPO-CONT-I    :", bhjl101a().commarea().dadosEntrada().cTipoContI());
        bhjp5101AcedeMhjj101a() ;
        log(TraceLevel.Debug, " R E T O R N O   M H J J 1 0 1 A");
        log(TraceLevel.Debug, " --> BHJL101A-A-APL-ERR          :", bhjl101a().commarea().erros().aAplErr());
        log(TraceLevel.Debug, " --> BHJL101A-C-RTNO-EVEN-SWAL   :", bhjl101a().commarea().erros().cRtnoEvenSwal());
        log(TraceLevel.Debug, " --> BHJL101A-C-TIPO-ERRO-BBN    :", bhjl101a().commarea().erros().cTipoErroBbn());
        if (!bhjl101a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhjl101a().commarea().erros().cTipoErroBbn());
            envOut.errosGraves().aAplErr().set(bhjl101a().commarea().erros().aAplErr());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl101a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl101a().commarea().erros().nmTabela());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl101a().commarea().erros().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        /**
         * -- VALIDA SE MOVIMENTO JA ESTA MARCADO (BASTANTO TER UM
         * -- TITULAR ABRANGIDO PARA ESTAR)
         */
        wsVariaveis().wsITitcExsGarDep().set(CON_ABRANGIDO);
        m2910ObtemTitAbrang() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            if (wsVariaveis().wsCountTitAbrgd().isEqual(0)) {
                swPrimeiraMarcacao.setTrue() ;
            } else {
                swAtualizaMarcacao.setTrue() ;
                log(TraceLevel.Error, "»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
                log(TraceLevel.Error, "»»     SW-ATUALIZA-MARCACAO         ««");
                log(TraceLevel.Error, "««««««««««««««««««««««««««««««««««««««");
            }
        }
        /**
         * -- SE O MOVIMENTO EM QUESTAO AINDA NAO FOI TRATADO
         * -- INSERE A MARCACAO DO MOVIMENTO NA TGH00200,INSERINDO
         * -- TAMBEM TODOS OS TITULARES NA TGH00201
         * GH1921  (I)
         * IF SW-PRIMEIRA-MARCACAO OR SW-EXTENSAO-MOV-ANULADA
         * GH1921  (F)
         */
        if (swPrimeiraMarcacao.isTrue()) {
            m2200CriaExtensaoGar() ;
        } else {
            /**
             * -- SENAO, ATUALIZA DADOS DA MARCACAO
             */
            m2201TrataAtzExtGar() ;
        }
        /**
         * -- SE MOVIMENTO MARCADO INSERIDO / ATUALIZADO COM SUCESSO,
         * -- ATUALIZA OS CLIENTES TITULARES QUE NAO SERAO ABRANGIDOS
         * -- PELA EXTENSAO DO MONTANTE DA GARANTIA DE DEPOSITO.
         * -- PARA ISSO, A AREA DE RADIO BUTTONS COM AS OPCOES SIM E NAO
         * -- TERA DE ESTAR COM A OPCAO NAO SELECIONADA
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            msgIn().msg().ade().iTodosTitAbgd().isEqual("N")) {
            m2221AtlzTitNAbrangds() ;
        }
        /**
         * -- SE MOVIMENTO JA ESTAVA MARCADO E INDICADOR DE TODOS
         * -- OS TITULARES ABRANGIDOS = SIM, ATUALIZA INDICADOR DE TIT
         * -- ABRANGIDO (ANTES DESTA ALTERACAO PODERIAM EXISTIT TIT
         * -- NAO ABRANGIDOS)
         */
        if (envOut.errosGraves().semErros().isTrue() && 
            msgIn().msg().ade().iTodosTitAbgd().isEqual("S")) {
            m2222AtlzTitAbrangds() ;
        }
        /**
         * -- INVOCA PROGRAMA DE CONSULTA PARA PREENCHER RESTANTES
         * -- OCORRENCIAS DA LISTA, CASO EXISTAM
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            m2900LigacaoConsulta() ;
        }
        if (envOut.errosGraves().fimConsulta().isTrue()) {
            /**
             * -- SE JA EXISTEM MAIS TITULARES PARA TRATAR...
             */
            wsVariaveis().wsITitcExsGarDep().set(CON_ABRANGIDO);
            m2910ObtemTitAbrang() ;
            if (envOut.errosGraves().fimConsulta().isTrue() && 
                wsVariaveis().wsCountTitAbrgd().isEqual(0)) {
                /**
                 * *GH1921-INI
                 * AND SW-PRIMEIRA-MARCACAO
                 * *GH1921-FIM
                 * -- SE NENHUM CLIENTE FOI ABRANGIDO E FOI A PRIMEIRA
                 * -- MARCACAO, DEVOLVE ERRO FUNCIONAL, POIS PARA SE MARCAR
                 * -- O MOVIMENTO, DEVERA ESTAR ABRANGIDO PELO MENOS 1
                 * -- TITULAR DA CONTA
                 */
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_GH);
                log(TraceLevel.Error, "ERRO-09");
            }
            if (envOut.errosGraves().fimConsulta().isTrue() && swAtualizaMarcacao.isTrue() && 
                wsVariaveis().wsCountTitAbrgd().isEqual(0)) {
                /**
                 * -- SE O MOVIMENTO ESTAVA MARCADO MAS JA NAO EXISTEM
                 * -- CLIENTES ABRANGIDOS, ANULA A EXTENSAO DA GARANTIA
                 * -- ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
                 * -- NAO HAVENDO FORMA DE SABER SE SE TRATA DO PRIMEIRO
                 * -- MOVIMENTO MARCADO OU NAO, A PARTIR DO MOMENTO EM QUE
                 * -- EXISTEM MAIS DE 14 TITULARES, OPTOU-SE POR SE MARCAR
                 * -- O MOVIMENTO COMO ANULADO, CASO NENHUM DOS TITULARES
                 * -- SEJA SELECIONADO COMO ABRANGIDO
                 * *GH1921-INI
                 * PERFORM 2920-ANULA-EXTENSAO
                 * THRU 2920-ANULA-EXTENSAO-EXIT
                 * *GH1921-FIM
                 */
                msgOut().msg().ade().dadosGarantia().cCarExt().set(" ");
            }
        }
    }
    
    /**
     * 
     * 2200-CRIA-EXTENSAO-GAR
     * 
     */
    protected void m2200CriaExtensaoGar() {
        log(TraceLevel.Debug, "2200-CRIA-EXTENSAO-GAR");
        /**
         * -- INSERE NOVA MARCACAO - O MOVIMENTO EM QUESTAO AINDA
         * -- NAO FOI MARCADO (OU JA FOI E ENCONTRA-SE ANULADO)
         */
        m2250InsereTgh200() ;
        /**
         * GH1921  (I)
         * IF BHTL001A-SEM-ERROS AND SW-EXTENSAO-MOV-ANULADA
         * GH1921  (F)
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * -- SE O MOVIMENTO JA FOI ANTERIORMENTE MARCADO
             * -- JA TEM REGISTOS NA TGH00201 PELO QUE E NECESSARIO
             * -- ELIMINA LOS E VOLTAR A INSERI LOS (NAO BASTAVA
             * -- ATUALIZA LOS POIS NESTA ALTURA OS TITULARES PODERIAM
             * -- SER DIFERENTES)
             */
            m2250EliminaTitulares() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            /**
             * -- INSERE OS TITULARES DA CONTA DO MOVIMENTO EM QUESTAO
             */
            m2251InsereTgh201() ;
        }
    }
    
    /**
     * 
     * 2201-TRATA-ATZ-EXT-GAR
     * 
     */
    protected void m2201TrataAtzExtGar() {
        log(TraceLevel.Debug, "2201-TRATA-ATZ-EXT-GAR");
        hv20001Movexgdep().movexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20001Movexgdep().movexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20001Movexgdep().movexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20001Movexgdep().movexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20001Movexgdep().movexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20001Movexgdep().movexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20001Movexgdep().movexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20001Movexgdep().movexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20001Movexgdep().movexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().selectPghs193a748(CON_ATIVO) ;
        swSwitchs().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20001Movexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (swSwitchs().swVgh20001Ok().isTrue()) {
            /**
             * -- ATUALIZA MARCACAO DO MOVIMENTO
             */
            m2210ComparaReg() ;
        } else {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20001);
            envOut.db2Log().sqlca().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
            msgOut().msg().ase().cMoedIsoSctaSt().cMoedIsoSctaS().set("1");
            msgOut().msg().ase().cMoedIsoSctaSt().cMoedIsoSctaM().set(bghk0001().erros().inputInvalido());
            log(TraceLevel.Error, "ERRO-11");
            log(TraceLevel.Error, "ERRO NO 2201-TRATA-ATZ-EXT-GAR SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "CHAVE : ");
            log(TraceLevel.Error, "C-PAIS-ISOA-CONT = ", hv20001Movexgdep().movexgdep().cPaisIsoaCont());
            log(TraceLevel.Error, "C-BANC-CONT      = ", hv20001Movexgdep().movexgdep().cBancCont());
            log(TraceLevel.Error, "C-OE-EGC-CONT    = ", hv20001Movexgdep().movexgdep().cOeEgcCont());
            log(TraceLevel.Error, "NS-RDCL-CONT     = ", hv20001Movexgdep().movexgdep().nsRdclCont());
            log(TraceLevel.Error, "V-CHKD-CONT      = ", hv20001Movexgdep().movexgdep().vChkdCont());
            log(TraceLevel.Error, "C-TIPO-CONT      = ", hv20001Movexgdep().movexgdep().cTipoCont());
            log(TraceLevel.Error, "C-MOED-ISO-SCTA  = ", hv20001Movexgdep().movexgdep().cMoedIsoScta());
            log(TraceLevel.Error, "NS-DEPOSITO      = ", hv20001Movexgdep().movexgdep().nsDeposito());
            log(TraceLevel.Error, "NS-MOVIMENTO     = ", hv20001Movexgdep().movexgdep().nsMovimento());
        }
    }
    
    /**
     * 
     * 2210-COMPARA-REG
     * 
     */
    protected void m2210ComparaReg() {
        log(TraceLevel.Debug, "2210-COMPARA-REG");
        if (!hv20001Movexgdep().movexgdep().mMovimento().isEqual(msgOut().msg().ade().dadosGarantia().mMontanteExt()) || 
            !hv20001Movexgdep().movexgdep().cCrtzMovExsGar().isEqual(msgOut().msg().ade().dadosGarantia().cCarExt()) || 
            !hv20001Movexgdep().movexgdep().zIniExtsGarDep().isEqual(msgOut().msg().ade().dadosGarantia().zIniGarantia()) || 
            !hv20001Movexgdep().movexgdep().zFimExtsGarDep().isEqual(msgOut().msg().ade().dadosGarantia().zFimGarantia()) || 
            !hv20001Movexgdep().movexgdep().iTipItvtExsGar().isEqual(msgOut().msg().ade().solicitador().cTipoSol()) || 
            !hv20001Movexgdep().movexgdep().nsTitcExtsGart().isEqual(msgOut().msg().ade().solicitador().nsIntSol())) {
            m2230AtualizaTgh200() ;
        }
    }
    
    /**
     * 
     * 2230-ATUALIZA-TGH200
     * 
     */
    protected void m2230AtualizaTgh200() {
        log(TraceLevel.Debug, "2230-ATUALIZA-TGH200");
        hv20001Movexgdep().movexgdep().mMovimento().set(msgOut().msg().ade().dadosGarantia().mMontanteExt());
        hv20001Movexgdep().movexgdep().cCrtzMovExsGar().set(msgOut().msg().ade().dadosGarantia().cCarExt());
        hv20001Movexgdep().movexgdep().zIniExtsGarDep().set(msgOut().msg().ade().dadosGarantia().zIniGarantia());
        hv20001Movexgdep().movexgdep().zFimExtsGarDep().set(msgOut().msg().ade().dadosGarantia().zFimGarantia());
        hv20001Movexgdep().movexgdep().iTipItvtExsGar().set(msgOut().msg().ade().solicitador().cTipoSol());
        hv20001Movexgdep().movexgdep().nsTitcExtsGart().set(msgOut().msg().ade().solicitador().nsIntSol());
        hv20001Movexgdep().movexgdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().updatePghs193a879(CON_ATIVO) ;
        swSwitchs().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20001Movexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20001Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20001);
            envOut.db2Log().sqlca().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
            log(TraceLevel.Error, "ERRO-04");
            log(TraceLevel.Error, "ERRO NO 2230-ATUALIZA-TGH200: ", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, "CHAVE : ");
            log(TraceLevel.Error, "C-PAIS-ISOA-CONT = ", hv20001Movexgdep().movexgdep().cPaisIsoaCont());
            log(TraceLevel.Error, "C-BANC-CONT      = ", hv20001Movexgdep().movexgdep().cBancCont());
            log(TraceLevel.Error, "C-OE-EGC-CONT    = ", hv20001Movexgdep().movexgdep().cOeEgcCont());
            log(TraceLevel.Error, "NS-RDCL-CONT     = ", hv20001Movexgdep().movexgdep().nsRdclCont());
            log(TraceLevel.Error, "V-CHKD-CONT      = ", hv20001Movexgdep().movexgdep().vChkdCont());
            log(TraceLevel.Error, "C-TIPO-CONT      = ", hv20001Movexgdep().movexgdep().cTipoCont());
            log(TraceLevel.Error, "C-MOED-ISO-SCTA  = ", hv20001Movexgdep().movexgdep().cMoedIsoScta());
            log(TraceLevel.Error, "NS-DEPOSITO      = ", hv20001Movexgdep().movexgdep().nsDeposito());
            log(TraceLevel.Error, "NS-MOVIMENTO     = ", hv20001Movexgdep().movexgdep().nsMovimento());
        }
    }
    
    /**
     * 
     * 2221-ATLZ-TIT-N-ABRANGDS
     * 
     */
    protected void m2221AtlzTitNAbrangds() {
        log(TraceLevel.Debug, "2221-ATLZ-TIT-N-ABRANGDS");
        /**
         * -- PERCORRE TODAS AS LINHAS DA LISTA
         * -- SE ALGUM REGISTO TIVER SIDO MODIFICADO, VALIDA SE SE
         * -- TRATA DE UMA MARCACAO OU DESMARCACAO PARA PROSSEGUIR
         * -- COM O DEVIDO TRATAMENTO
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            for (msgIn().indice().set(1); !msgIn().msg().ade().linha().get(msgIn().indice()).nClienteL().isEqual(0) && !msgIn().paginaCheia().isTrue(); msgIn().indice().add(1)) {
                log(TraceLevel.Debug, ">>>>>>>>>>>>>>>>>>>>>>> OCORRENCIA ", msgIn().indice(), " <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                log(TraceLevel.Debug, ". BGHM1190-I-ACCZ-MNTZ-LSTA-L:", msgIn().msg().ade().linha().get(msgIn().indice()).iAcczMntzLstaL());
                /**
                 * -- SE ACAO DA LINHA FOR MODIFICAR, MARCA OU
                 * -- DESMARCA O MOVIMENTO DE EXTENSAO DA GARANTIA
                 * -- PARA O CLIENTE EM QUESTAO
                 */
                if (msgIn().msg().ade().linha().get(msgIn().indice()).iAcczMntzLstaL().isEqual(CON_ACAO_MODIFICAR)) {
                    log(TraceLevel.Debug, " ---------------------------------");
                    log(TraceLevel.Debug, " - BGHM1190-I-TITC-EXS-GAR:", msgIn().msg().ade().linha().get(msgIn().indice()).iTitcExsGar());
                    log(TraceLevel.Debug, " ---------------------------------");
                    m2310AtualizaTgh201() ;
                }
            }
        }
    }
    
    /**
     * 
     * 2250-INSERE-TGH200
     * 
     */
    protected void m2250InsereTgh200() {
        log(TraceLevel.Debug, "2250-INSERE-TGH200");
        hv20001Movexgdep().movexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20001Movexgdep().movexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20001Movexgdep().movexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20001Movexgdep().movexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20001Movexgdep().movexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20001Movexgdep().movexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20001Movexgdep().movexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20001Movexgdep().movexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20001Movexgdep().movexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hv20001Movexgdep().movexgdep().cEstExtsGarDep().set(CON_ATIVO);
        hv20001Movexgdep().movexgdep().cCrtzMovExsGar().set(msgIn().msg().ade().dadosGarantia().cCarExt());
        hv20001Movexgdep().movexgdep().mMovimento().set(msgIn().msg().ade().dadosGarantia().mMontanteExt());
        hv20001Movexgdep().movexgdep().zIniExtsGarDep().set(msgIn().msg().ade().dadosGarantia().zIniGarantia());
        hv20001Movexgdep().movexgdep().zFimExtsGarDep().set(msgIn().msg().ade().dadosGarantia().zFimGarantia());
        hv20001Movexgdep().movexgdep().iTipItvtExsGar().set(msgIn().msg().ade().solicitador().cTipoSol());
        hv20001Movexgdep().movexgdep().nsTitcExtsGart().set(msgIn().msg().ade().solicitador().nsIntSol());
        hv20001Movexgdep().movexgdep().cUsidCrix().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * MOVE CON-NOME-PROGRAMA        TO VGH20001-C-USID-ACTZ-ULT.
         */
        hv20001Movexgdep().movexgdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().insertPghs193a1013() ;
        swSwitchs().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20001Movexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20001Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20001);
            envOut.db2Log().sqlca().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
            msgOut().msg().ase().linhaSt().get(msgIn().indice()).nClienteSt().nClienteS().set("1");
            msgOut().msg().ase().linhaSt().get(msgIn().indice()).nClienteSt().nClienteM().set(bghk0001().erros().inputInvalido());
            log(TraceLevel.Error, "ERRO-05");
            log(TraceLevel.Error, "ERRO NO 2250-INSERE-TGH200 SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, " CHAVE : ");
            log(TraceLevel.Error, " - C-PAIS-ISOA-CONT : ", hv20001Movexgdep().movexgdep().cPaisIsoaCont());
            log(TraceLevel.Error, " - C-BANC-CONT      : ", hv20001Movexgdep().movexgdep().cBancCont());
            log(TraceLevel.Error, " - C-OE-EGC-CONT    : ", hv20001Movexgdep().movexgdep().cOeEgcCont());
            log(TraceLevel.Error, " - NS-RDCL-CONT     : ", hv20001Movexgdep().movexgdep().nsRdclCont());
            log(TraceLevel.Error, " - V-CHKD-CONT      : ", hv20001Movexgdep().movexgdep().vChkdCont());
            log(TraceLevel.Error, " - C-TIPO-CONT      : ", hv20001Movexgdep().movexgdep().cTipoCont());
            log(TraceLevel.Error, " - C-MOED-ISO-SCTA  : ", hv20001Movexgdep().movexgdep().cMoedIsoScta());
            log(TraceLevel.Error, " - NS-DEPOSITO      : ", hv20001Movexgdep().movexgdep().nsDeposito());
            log(TraceLevel.Error, " - NS-MOVIMENTO     : ", hv20001Movexgdep().movexgdep().nsMovimento());
        }
    }
    
    /**
     * 
     * 2222-ATLZ-TIT-ABRANGDS
     * 
     */
    protected void m2222AtlzTitAbrangds() {
        log(TraceLevel.Debug, "2222-ATLZ-TIT-ABRANGDS");
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hv20101Titexgdep().titexgdep().iTitcExsGarDep().set(CON_ABRANGIDO);
        hv20101Titexgdep().titexgdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH20101_TITEXGDEP
         */
        hv20101Titexgdep().updatePghs193a1116() ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue()) {
            if (swSwitchs().swVgh20101Notfnd().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_HO);
                msgOut().msg().ase().cMoedIsoSctaSt().cMoedIsoSctaS().set("1");
                msgOut().msg().ase().cMoedIsoSctaSt().cMoedIsoSctaM().set(CON_CLI_TIT_DIFTS);
                log(TraceLevel.Error, "ERRO-12");
            } else {
                envOut.errosGraves().abendDb2().setTrue() ;
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.db2Log().nmTabela().set(CON_VGH20101);
                envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
                log(TraceLevel.Error, "ERRO-06");
                log(TraceLevel.Error, "ERRO NO 2310-ATUALIZA-TGH201: ", wsVariaveis().wsSqlcodeErro());
                log(TraceLevel.Error, "CHAVE : ");
                log(TraceLevel.Error, "C-PAIS-ISOA-CONT = ", hv20101Titexgdep().titexgdep().cPaisIsoaCont());
                log(TraceLevel.Error, "C-BANC-CONT      = ", hv20101Titexgdep().titexgdep().cBancCont());
                log(TraceLevel.Error, "C-OE-EGC-CONT    = ", hv20101Titexgdep().titexgdep().cOeEgcCont());
                log(TraceLevel.Error, "NS-RDCL-CONT     = ", hv20101Titexgdep().titexgdep().nsRdclCont());
                log(TraceLevel.Error, "V-CHKD-CONT      = ", hv20101Titexgdep().titexgdep().vChkdCont());
                log(TraceLevel.Error, "C-TIPO-CONT      = ", hv20101Titexgdep().titexgdep().cTipoCont());
                log(TraceLevel.Error, "C-MOED-ISO-SCTA  = ", hv20101Titexgdep().titexgdep().cMoedIsoScta());
                log(TraceLevel.Error, "NS-DEPOSITO      = ", hv20101Titexgdep().titexgdep().nsDeposito());
                log(TraceLevel.Error, "NS-MOVIMENTO     = ", hv20101Titexgdep().titexgdep().nsMovimento());
            }
        }
    }
    
    /**
     * 
     * 2310-ATUALIZA-TGH201
     * 
     */
    protected void m2310AtualizaTgh201() {
        log(TraceLevel.Debug, "2310-ATUALIZA-TGH201");
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hv20101Titexgdep().titexgdep().nsTitc().set(msgIn().msg().ade().linha().get(msgIn().indice()).nsItvtL());
        hv20101Titexgdep().titexgdep().iTipoItvt().set(msgIn().msg().ade().linha().get(msgIn().indice()).iTipoItvtL());
        hv20101Titexgdep().titexgdep().iTitcExsGarDep().set(msgIn().msg().ade().linha().get(msgIn().indice()).iTitcExsGar());
        hv20101Titexgdep().titexgdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH20101_TITEXGDEP
         */
        hv20101Titexgdep().updatePghs193a1201() ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue()) {
            if (swSwitchs().swVgh20101Notfnd().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                envOut.errosGraves().aAplErr().set(CON_APLICACAO_HO);
                msgOut().msg().ase().linhaSt().get(msgIn().indice()).nClienteSt().nClienteS().set("1");
                msgOut().msg().ase().linhaSt().get(msgIn().indice()).nClienteSt().nClienteM().set(CON_ALTERACAO_N_PERMT);
                log(TraceLevel.Error, "ERRO-12");
            } else {
                envOut.errosGraves().abendDb2().setTrue() ;
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.db2Log().nmTabela().set(CON_VGH20101);
                envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
                log(TraceLevel.Error, "ERRO-06");
                log(TraceLevel.Error, "ERRO NO 2310-ATUALIZA-TGH201: ", wsVariaveis().wsSqlcodeErro());
                log(TraceLevel.Error, "CHAVE : ");
                log(TraceLevel.Error, "C-PAIS-ISOA-CONT = ", hv20101Titexgdep().titexgdep().cPaisIsoaCont());
                log(TraceLevel.Error, "C-BANC-CONT      = ", hv20101Titexgdep().titexgdep().cBancCont());
                log(TraceLevel.Error, "C-OE-EGC-CONT    = ", hv20101Titexgdep().titexgdep().cOeEgcCont());
                log(TraceLevel.Error, "NS-RDCL-CONT     = ", hv20101Titexgdep().titexgdep().nsRdclCont());
                log(TraceLevel.Error, "V-CHKD-CONT      = ", hv20101Titexgdep().titexgdep().vChkdCont());
                log(TraceLevel.Error, "C-TIPO-CONT      = ", hv20101Titexgdep().titexgdep().cTipoCont());
                log(TraceLevel.Error, "C-MOED-ISO-SCTA  = ", hv20101Titexgdep().titexgdep().cMoedIsoScta());
                log(TraceLevel.Error, "NS-DEPOSITO      = ", hv20101Titexgdep().titexgdep().nsDeposito());
                log(TraceLevel.Error, "NS-MOVIMENTO     = ", hv20101Titexgdep().titexgdep().nsMovimento());
            }
        }
    }
    
    /**
     * 
     * 2250-ELIMINA-TITULARES
     * 
     */
    protected void m2250EliminaTitulares() {
        log(TraceLevel.Debug, "2250-ELIMINA-TITULARES");
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH20101_TITEXGDEP
         */
        hv20101Titexgdep().deletePghs193a1284() ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue() && !swSwitchs().swVgh20101Notfnd().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20101);
            envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
            log(TraceLevel.Error, " ERRO-13");
            log(TraceLevel.Error, " ERRO NO 2250-ELIMINA-TITULARES SQLCODE :", wsVariaveis().wsSqlcodeErro());
            log(TraceLevel.Error, " CHAVE : ");
            log(TraceLevel.Error, " C-PAIS-ISOA-CONT = ", hv20101Titexgdep().titexgdep().cPaisIsoaCont());
            log(TraceLevel.Error, " C-BANC-CONT      = ", hv20101Titexgdep().titexgdep().cBancCont());
            log(TraceLevel.Error, " C-OE-EGC-CONT    = ", hv20101Titexgdep().titexgdep().cOeEgcCont());
            log(TraceLevel.Error, " NS-RDCL-CONT     = ", hv20101Titexgdep().titexgdep().nsRdclCont());
            log(TraceLevel.Error, " V-CHKD-CONT      = ", hv20101Titexgdep().titexgdep().vChkdCont());
            log(TraceLevel.Error, " C-TIPO-CONT      = ", hv20101Titexgdep().titexgdep().cTipoCont());
            log(TraceLevel.Error, " C-MOED-ISO-SCTA  = ", hv20101Titexgdep().titexgdep().cMoedIsoScta());
            log(TraceLevel.Error, " NS-DEPOSITO      = ", hv20101Titexgdep().titexgdep().nsDeposito());
            log(TraceLevel.Error, " NS-MOVIMENTO     = ", hv20101Titexgdep().titexgdep().nsMovimento());
        }
    }
    
    /**
     * 
     * 2251-INSERE-TGH201
     * 
     */
    protected void m2251InsereTgh201() {
        log(TraceLevel.Debug, "2251-INSERE-TGH201");
        bhjl051a().commarea().initialize() ;
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        /**
         * MOVE CON-NOME-PROGRAMA        TO VGH20101-C-USID-ACTZ-ULT.
         */
        hv20101Titexgdep().titexgdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        while (envOut.errosGraves().semErros().isTrue() && !bhjl051a().commarea().erros().fimConsulta().isTrue()) {
            m2351AcedeMhjj051a() ;
        }
    }
    
    /**
     * 
     * 2351-ACEDE-MHJJ051A
     * 
     */
    protected void m2351AcedeMhjj051a() {
        log(TraceLevel.Debug, "2351-ACEDE-MHJJ051A");
        bhjl051a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        bhjl051a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        bhjl051a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        bhjl051a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        bhjl051a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        bhjl051a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        /**
         * -- OBTENCAO DOS CLIENTES QUE ESTAO ATIVOS A DATA DA MARCACAO
         */
        bhjl051a().commarea().dadosEntrada().zConsulta().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
        bhjl051a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl051a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        if (!msgIn().msg().ade().chaveContinuacao().iTipoItvtPg().isEqual(0)) {
            bhjl051a().commarea().dadosEntrada().iTipoItvtPag().set(msgIn().msg().ade().chaveContinuacao().iTipoItvtPg());
            bhjl051a().commarea().dadosEntrada().nsTitcPag().set(msgIn().msg().ade().chaveContinuacao().nsTitcPg());
        }
        bhjl051a().commarea().dadosEntrada().titularL().setTrue() ;
        log(TraceLevel.Debug, " >>>>>>>>>>>>>> ACESSO MHJJ051A <<<<<<<<<<<<<<<");
        log(TraceLevel.Debug, " . BHJL051A-C-PAIS-ISOA-CONT        :", bhjl051a().commarea().dadosEntrada().cPaisIsoaCont());
        log(TraceLevel.Debug, " . BHJL051A-C-BANC-CONT             :", bhjl051a().commarea().dadosEntrada().cBancCont());
        log(TraceLevel.Debug, " . BHJL051A-C-OE-EGC-CONT           :", bhjl051a().commarea().dadosEntrada().cOeEgcCont());
        log(TraceLevel.Debug, " . BHJL051A-NS-RDCL-CONT            :", bhjl051a().commarea().dadosEntrada().nsRdclCont());
        log(TraceLevel.Debug, " . BHJL051A-V-CHKD-CONT             :", bhjl051a().commarea().dadosEntrada().vChkdCont());
        log(TraceLevel.Debug, " . BHJL051A-C-TIPO-CONT             :", bhjl051a().commarea().dadosEntrada().cTipoCont());
        log(TraceLevel.Debug, " . BHJL051A-Z-CONSULTA              :", bhjl051a().commarea().dadosEntrada().zConsulta());
        log(TraceLevel.Debug, " . BHJL051A-I-TIPO-ITVT-PAG         :", bhjl051a().commarea().dadosEntrada().iTipoItvtPag());
        log(TraceLevel.Debug, " >>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<");
        bhjp5051AcedeMhjj051a() ;
        log(TraceLevel.Debug, " >>>>>>>>>>>>>> RETORNO MHJJ051A <<<<<<<<<<<<<<<");
        log(TraceLevel.Debug, " . BHJL051A-C-SQLCODE               :", bhjl051a().commarea().erros().cSqlcode());
        log(TraceLevel.Debug, " . BHJL051A-A-APL-ERR               :", bhjl051a().commarea().erros().aAplErr());
        log(TraceLevel.Debug, " . BHJL051A-C-RTNO-EVEN-SWAL        :", bhjl051a().commarea().erros().cRtnoEvenSwal());
        log(TraceLevel.Debug, " . BHJL051A-MSG-ERROB               :", bhjl051a().commarea().erros().msgErrob());
        log(TraceLevel.Debug, " . BHJL051A-NM-TABELA               :", bhjl051a().commarea().erros().nmTabela());
        log(TraceLevel.Debug, " . BHJL051A-MOD-ORIGEM-ERRO         :", bhjl051a().commarea().erros().modOrigemErro());
        log(TraceLevel.Debug, " . BHJL051A-CH-ACESSO               :", bhjl051a().commarea().erros().chAcesso());
        log(TraceLevel.Debug, " . BHJL051A-C-TIPO-ERRO-BBN         :", bhjl051a().commarea().erros().cTipoErroBbn());
        log(TraceLevel.Debug, " >>>>>>>>>>>>>>>>>>>>>>>.<<<<<<<<<<<<<<<<<<<<<<<");
        envOut.errosGraves().cTipoErroBbn().set(bhjl051a().commarea().erros().cTipoErroBbn());
        if (bhjl051a().commarea().erros().semErros().isTrue() || bhjl051a().commarea().erros().fimConsulta().isTrue()) {
            if (bhjl051a().commarea().erros().fimConsulta().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(" ");
            }
            log(TraceLevel.Debug, " >>>>>>>>>>>> RETORNO MHJJ051A OK <<<<<<<<<<");
            log(TraceLevel.Debug, " --> BHJL051A-Q-OCCURS-OUT:", bhjl051a().commarea().qOccursOut());
            for (wsVariaveis().wsIndTit().set(1); wsVariaveis().wsIndTit().isLessOrEqual(bhjl051a().commarea().qOccursOut()) && envOut.errosGraves().semErros().isTrue(); wsVariaveis().wsIndTit().add(1)) {
                hv20101Titexgdep().titexgdep().nsTitc().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndTit()).nsTitc());
                hv20101Titexgdep().titexgdep().iTipoItvt().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsIndTit()).iTipoItvt());
                hv20101Titexgdep().titexgdep().iTitcExsGarDep().set(CON_ABRANGIDO);
                /**
                 * Migration Note:
                 * call to extracted method to access (INSERT) table VGH20101_TITEXGDEP
                 */
                hv20101Titexgdep().insertPghs193a1461() ;
                swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
                wsVariaveis().wsSqlcodeErro().set(hv20101Titexgdep().getPersistenceCode());
                bhtp0002M9020Db2check() ;
                if (!swSwitchs().swVgh20101Ok().isTrue()) {
                    envOut.errosGraves().abendDb2().setTrue() ;
                    envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                    envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                    envOut.db2Log().nmTabela().set(CON_VGH20101);
                    envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
                    log(TraceLevel.Error, "ERRO-07");
                    log(TraceLevel.Error, "ERRO NO 2251-INSERE-TGH201 SQLCODE :", wsVariaveis().wsSqlcodeErro());
                    log(TraceLevel.Error, "CHAVE : ");
                    log(TraceLevel.Error, "C-PAIS-ISOA-CONT = ", hv20101Titexgdep().titexgdep().cPaisIsoaCont());
                    log(TraceLevel.Error, "C-BANC-CONT      = ", hv20101Titexgdep().titexgdep().cBancCont());
                    log(TraceLevel.Error, "C-OE-EGC-CONT    = ", hv20101Titexgdep().titexgdep().cOeEgcCont());
                    log(TraceLevel.Error, "NS-RDCL-CONT     = ", hv20101Titexgdep().titexgdep().nsRdclCont());
                    log(TraceLevel.Error, "V-CHKD-CONT      = ", hv20101Titexgdep().titexgdep().vChkdCont());
                    log(TraceLevel.Error, "C-TIPO-CONT      = ", hv20101Titexgdep().titexgdep().cTipoCont());
                    log(TraceLevel.Error, "C-MOED-ISO-SCTA  = ", hv20101Titexgdep().titexgdep().cMoedIsoScta());
                    log(TraceLevel.Error, "NS-DEPOSITO      = ", hv20101Titexgdep().titexgdep().nsDeposito());
                    log(TraceLevel.Error, "NS-MOVIMENTO     = ", hv20101Titexgdep().titexgdep().nsMovimento());
                }
            }
        }
        if (bhjl051a().commarea().erros().semErros().isTrue() && bhjl051a().commarea().pagCheia().isTrue()) {
            bhjl051a().commarea().dadosEntrada().nsTitcPag().set(bhjl051a().commarea().dadosSaida().get(bhjl051a().commarea().qOccursOut()).nsTitc());
            bhjl051a().commarea().dadosEntrada().iTipoItvtPag().set(bhjl051a().commarea().dadosSaida().get(bhjl051a().commarea().qOccursOut()).nsTitc());
        }
    }
    
    /**
     * 
     * 2900-LIGACAO-CONSULTA
     * 
     */
    protected void m2900LigacaoConsulta() {
        log(TraceLevel.Debug, "2900-LIGACAO-CONSULTA");
        bhtw0009().camposControlo().qCampEstTrnzSfun().set(msgIn().qCampEstTrnz());
        bhtw0009().camposControlo().qCterCmptAligSfun().set(msgIn().qCterCmptAlig());
        bhtw0009().camposControlo().xMsgBbnSfun().set(msgIn().msg());
        bhtw0009().camposControlo().aAplicacaoSfun().set(CON_APLICACAO_GH);
        bhtw0009().camposControlo().cOpczMenuSfun().set(message.mensagem().headerR().transaccao().cOpczMenu());
        bhtw0009().camposControlo().nmProgramaSfun().set(CON_PROGRAMA_CONSULTA);
        bhtw0009().camposControlo().nsJourBbnSfun().add(1);
        bhtw0009().camposControlo().iEstornoSfun().set(message.mensagem().headerR().iEstorno());
        bhtw0009().camposControlo().cUsidEstornoSfun().set(message.mensagem().headerR().nrAnulacao().cUsidEstn());
        bhtw0009().camposControlo().zProcessamentoSfun().set(message.mensagem().headerR().nrElectronico().zProcessamento());
        bhtw0009().camposControlo().nJourTrnEsnSfun().set(message.mensagem().headerR().nrAnulacao().nJourBbnTrnEsn());
        bhtp0007NovaFuncao() ;
        msgOut().qCterCmptAlig().set(bhtw0009().commarea().mensagem().qCterCmptAlig());
        msgOut().qCampEstTrnz().set(bhtw0009().commarea().mensagem().qCampEstTrnz());
        msgOut().msg().set(bhtw0009().commarea().mensagem().xMsgBbn());
        envOut.errosGraves().cRtnoEvenSwal().set(bhtw0009().commarea().errosGraves().cRtnoEvenSwal());
        envOut.errosGraves().cTipoErroBbn().set(bhtw0009().commarea().errosGraves().cTipoErroBbn());
    }
    
    /**
     * 
     * 2910-OBTEM-TIT-ABRANG
     * 
     */
    protected void m2910ObtemTitAbrang() {
        log(TraceLevel.Debug, " 2910-OBTEM-TIT-ABRANG");
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "-------------------------------------------");
        log(TraceLevel.Debug, " . VGH20101-C-PAIS-ISOA-CONT  :", hv20101Titexgdep().titexgdep().cPaisIsoaCont());
        log(TraceLevel.Debug, " . VGH20101-C-BANC-CONT       :", hv20101Titexgdep().titexgdep().cBancCont());
        log(TraceLevel.Debug, " . VGH20101-C-OE-EGC-CONT     :", hv20101Titexgdep().titexgdep().cOeEgcCont());
        log(TraceLevel.Debug, " . VGH20101-NS-RDCL-CONT      :", hv20101Titexgdep().titexgdep().nsRdclCont());
        log(TraceLevel.Debug, " . VGH20101-V-CHKD-CONT       :", hv20101Titexgdep().titexgdep().vChkdCont());
        log(TraceLevel.Debug, " . VGH20101-C-TIPO-CONT       :", hv20101Titexgdep().titexgdep().cTipoCont());
        log(TraceLevel.Debug, " . VGH20101-C-MOED-ISO-SCTA   :", hv20101Titexgdep().titexgdep().cMoedIsoScta());
        log(TraceLevel.Debug, " . VGH20101-NS-DEPOSITO       :", hv20101Titexgdep().titexgdep().nsDeposito());
        log(TraceLevel.Debug, " . VGH20101-NS-MOVIMENTO      :", hv20101Titexgdep().titexgdep().nsMovimento());
        log(TraceLevel.Debug, "-------------------------------------------");
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH20101_TITEXGDEP
         */
        hv20101Titexgdep().selectPghs193a1627(wsVariaveis().wsITitcExsGarDep(), wsVariaveis().wsCountTitAbrgd()) ;
        log(TraceLevel.Debug, "----------------------------");
        log(TraceLevel.Debug, "WS-COUNT-TIT-ABRGD:", wsVariaveis().wsCountTitAbrgd());
        log(TraceLevel.Debug, "----------------------------");
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(hv20101Titexgdep().getPersistenceCode());
        log(TraceLevel.Debug, "*SQLCODE TGH00201: ", hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue()) {
            if (swSwitchs().swVgh20101Notfnd().isTrue()) {
                wsVariaveis().wsCountTitAbrgd().set(0);
            } else {
                envOut.errosGraves().abendDb2().setTrue() ;
                envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
                envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
                envOut.db2Log().nmTabela().set(CON_VGH20101);
                envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
                log(TraceLevel.Error, "ERRO-10");
                log(TraceLevel.Error, "ERRO NO 2910-OBTEM-TIT-ABRANG SQLCODE :", wsVariaveis().wsSqlcodeErro());
                log(TraceLevel.Error, "CHAVE : ");
                log(TraceLevel.Error, "C-PAIS-ISOA-CONT = ", hv20101Titexgdep().titexgdep().cPaisIsoaCont());
                log(TraceLevel.Error, "C-BANC-CONT      = ", hv20101Titexgdep().titexgdep().cBancCont());
                log(TraceLevel.Error, "C-OE-EGC-CONT    = ", hv20101Titexgdep().titexgdep().cOeEgcCont());
                log(TraceLevel.Error, "NS-RDCL-CONT     = ", hv20101Titexgdep().titexgdep().nsRdclCont());
                log(TraceLevel.Error, "V-CHKD-CONT      = ", hv20101Titexgdep().titexgdep().vChkdCont());
                log(TraceLevel.Error, "C-TIPO-CONT      = ", hv20101Titexgdep().titexgdep().cTipoCont());
                log(TraceLevel.Error, "C-MOED-ISO-SCTA  = ", hv20101Titexgdep().titexgdep().cMoedIsoScta());
                log(TraceLevel.Error, "NS-DEPOSITO      = ", hv20101Titexgdep().titexgdep().nsDeposito());
                log(TraceLevel.Error, "NS-MOVIMENTO     = ", hv20101Titexgdep().titexgdep().nsMovimento());
            }
        }
    }
    
    /**
     * 
     * *GH1921-INI
     * 2920-ANULA-EXTENSAO
     * *2920-ANULA-EXTENSAO.
     * MOVE '2920-ANULA-EXTENSAO'    TO WS-PRG.
     * IF SW-DEBUG-SIM
     * DISPLAY WS-PARAG
     * END-IF.
     * MOVE BGHM1190-C-PAIS-ISOA-CONT
     * TO VGH20001-C-PAIS-ISOA-CONT.
     * MOVE BGHM1190-C-BANC-CONT     TO VGH20001-C-BANC-CONT.
     * MOVE BGHM1190-C-OE-EGC-CONT   TO VGH20001-C-OE-EGC-CONT.
     * MOVE BGHM1190-NS-RDCL-CONT    TO VGH20001-NS-RDCL-CONT.
     * MOVE BGHM1190-V-CHKD-CONT     TO VGH20001-V-CHKD-CONT.
     * MOVE BGHM1190-C-TIPO-CONT     TO VGH20001-C-TIPO-CONT.
     * MOVE BGHM1190-C-MOED-ISO-SCTA TO VGH20001-C-MOED-ISO-SCTA.
     * MOVE BGHM1190-NS-DEPOSITO     TO VGH20001-NS-DEPOSITO.
     * MOVE BGHM1190-NS-MOVIMENTO    TO VGH20001-NS-MOVIMENTO.
     * MOVE CON-CANCELADO            TO VGH20001-C-EST-EXTS-GAR-DEP.
     * MOVE CON-NOME-PROGRAMA        TO VGH20001-C-USID-ACTZ-ULT.
     * MOVE BHTL001A-C-USERID        TO VGH20001-C-USID-ACTZ-ULT.
     * EXEC SQL
     * UPDATE VGH20001_MOVEXGDEP
     * SET C_EST_EXTS_GAR_DEP = :VGH20001-C-EST-EXTS-GAR-DEP
     * , TS_ACTZ_ULT        = CURRENT_TIMESTAMP
     * , C_USID_ACTZ_ULT    = :VGH20001-C-USID-ACTZ-ULT
     * WHERE C_PAIS_ISOA_CONT   = :VGH20001-C-PAIS-ISOA-CONT
     * AND C_BANC_CONT        = :VGH20001-C-BANC-CONT
     * AND C_OE_EGC_CONT      = :VGH20001-C-OE-EGC-CONT
     * AND NS_RDCL_CONT       = :VGH20001-NS-RDCL-CONT
     * AND V_CHKD_CONT        = :VGH20001-V-CHKD-CONT
     * AND C_TIPO_CONT        = :VGH20001-C-TIPO-CONT
     * AND C_MOED_ISO_SCTA    = :VGH20001-C-MOED-ISO-SCTA
     * AND NS_DEPOSITO        = :VGH20001-NS-DEPOSITO
     * AND NS_MOVIMENTO       = :VGH20001-NS-MOVIMENTO
     * END-EXEC.
     * MOVE SQLCODE                  TO SW-SQLCODE-VGH20001
     * WS-SQLCODE-ERRO.
     * PERFORM 9020-DB2CHECK
     * THRU 9029-DB2CHECK-EXIT.
     * IF NOT SW-VGH20001-OK
     * -- SO E POSSIVEL COLOCAR O MOVIMENTO COMO CANCELADO
     * -- UMA VEZ - TEMA ESCLARECIDO POR EMAIL COM NUNO AMARO
     * -- NO DIA 2015-11-26
     * SET BHTL001A-ABEND-DB2     TO TRUE
     * MOVE BHTK0002-SIGLA-ARQUIT TO BHTL001A-A-APL-ERR
     * MOVE BHTK0001-ERRO-DB2     TO BHTL001A-C-RTNO-EVEN-SWAL
     * MOVE CON-VGH20001          TO BHTL001A-NM-TABELA
     * MOVE SQLCODE               TO BHTL001A-C-SQLCODE
     * DISPLAY 'ERRO-02'
     * DISPLAY 'ERRO NO 2920-ANULA-EXTENSAO : 'WS-SQLCODE-ERRO
     * DISPLAY 'CHAVE : '
     * DISPLAY ' . C-PAIS-ISOA-CONT : '
     * VGH20001-C-PAIS-ISOA-CONT
     * DISPLAY ' . C-BANC-CONT      : '
     * VGH20001-C-BANC-CONT
     * DISPLAY ' . C-OE-EGC-CONT    : '
     * VGH20001-C-OE-EGC-CONT
     * DISPLAY ' . NS-RDCL-CONT     : '
     * VGH20001-NS-RDCL-CONT
     * DISPLAY ' . V-CHKD-CONT      : '
     * VGH20001-V-CHKD-CONT
     * DISPLAY ' . C-TIPO-CONT      : '
     * VGH20001-C-TIPO-CONT
     * DISPLAY ' . C-MOED-ISO-SCTA  : '
     * VGH20001-C-MOED-ISO-SCTA
     * DISPLAY ' . NS-DEPOSITO      : '
     * VGH20001-NS-DEPOSITO
     * DISPLAY ' . NS-MOVIMENTO     : '
     * VGH20001-NS-MOVIMENTO
     * *2920-ANULA-EXTENSAO-EXIT.
     * EXIT.
     * *GH1921-FIM
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, " 3000-FIM-PROGRAMA");
        if (envOut.errosGraves().semErros().isTrue()) {
            m3050TrataJournal() ;
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        if (!envOut.errosGraves().semErros().isTrue()) {
            m1100MensagemInput() ;
            m3100MensagemOutput() ;
        }
        exit() ;
    }
    
    /**
     * 
     * 
     */
    protected void m3050TrataJournal() {
        log(TraceLevel.Debug, "3050-TRATA-JOURNAL");
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
        log(TraceLevel.Trace, "**********************************************");
        log(TraceLevel.Trace, "*****    M E N S A G E M   O U T P U T    *****");
        log(TraceLevel.Trace, "      . BGHM1191-C-PAIS-ISOA-CONT     : ", msgOut().msg().ade().scta().cPaisIsoaCont());
        log(TraceLevel.Trace, "      . BGHM1191-C-BANC-CONT          : ", msgOut().msg().ade().scta().cBancCont());
        log(TraceLevel.Trace, "      . BGHM1191-C-OE-EGC-CONT        : ", msgOut().msg().ade().scta().cOeEgcCont());
        log(TraceLevel.Trace, "      . BGHM1191-NS-RDCL-CONT         : ", msgOut().msg().ade().scta().nsRdclCont());
        log(TraceLevel.Trace, "      . BGHM1191-V-CHKD-CONT          : ", msgOut().msg().ade().scta().vChkdCont());
        log(TraceLevel.Trace, "      . BGHM1191-C-TIPO-CONT          : ", msgOut().msg().ade().scta().cTipoCont());
        log(TraceLevel.Trace, "      . BGHM1191-C-MOED-ISO-SCTA      : ", msgOut().msg().ade().scta().cMoedIsoScta());
        log(TraceLevel.Trace, "      . BGHM1191-NS-DEPOSITO          : ", msgOut().msg().ade().scta().nsDeposito());
        log(TraceLevel.Trace, "      . BGHM1191-NS-MOVIMENTO        : ", msgOut().msg().ade().nsMovimento());
        log(TraceLevel.Trace, "**********************************************");
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
     * TABELA INTERNAS
     * VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt wsCountTitAbrgd() ;
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt wsIndTit() ;
        
        @Data(size=1)
        IString wsITitcExsGarDep() ;
        
        @Data(format="999-", value="0")
        IFormattedString wsSqlcodeErro() ;
        
    }
    
    /**
     * 
     * -- FICA ATIVO QUANDO EXISTEM REGISTOS INSERIDOS NA TGH000201
     * -- CUJOS TITULARES NAO ESTAO ABRANGIDOS PELA EXTENSAO DA
     * -- GARANTIA, I.E., TODOS COM I_TITC_EXS_GAR_DEP A 'N'
     * *GH1921(I)
     * 88 SW-EXTENSAO-MOV-ANULADA                   VALUE '3'.
     * *GH1921(F)
     * SWITCHS
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitchs extends IDataStruct {
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20001() ;
        @Data
        @Condition("0")
        ICondition swVgh20001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh20001Notfnd() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20101() ;
        @Data
        @Condition("0")
        ICondition swVgh20101Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh20101Notfnd() ;
        
        
    }
    
}
