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
import cgd.gh.structures.messages.Bghm1190 ;
import cgd.gh.structures.messages.Bghm1191 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.hj.structures.link.Bhjl051a ;
import cgd.hj.structures.link.Bhjl086a ;
import cgd.hj.structures.link.Bhjl067a ;
import cgd.hj.structures.link.Bhjl039a ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hj.routines.Mhjj051a ;
import cgd.hj.routines.Mhjj067a ;
import cgd.hj.routines.Mhjj086a ;
import cgd.hg.routines.Mhgj030a ;


/**
 * 
 * DECLARACOES DE CURSORES
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS191A
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1863: FUNDO DE GARANTIA DE DEPOSITOS
 * FUNCAO     : HISTORICO DE MOVIMENTOS DE PASSIVAS
 * TIPO       : ONLINE COM DB2
 * LOG DE ALTERACOES
 * PROCESSO GIP !   DATA   ! UTILIZADOR ! OBSERVACOES
 * GH1863       07-09-2015   E001202       CRIACAO
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs191a extends CgdGhBaseOnline<Pghs191a.EnvelopeIn, Pghs191a.EnvelopeOut> {
    
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
     * @return instancia da classe Vwsdghps20101Titexgdep
     */
    @Data
    protected abstract Vwsdghps20101Titexgdep hv20101Titexgdep() ;
    
    /**
     * @return instancia da classe Vwsdghps20001Movexgdep
     */
    @Data
    protected abstract Vwsdghps20001Movexgdep hv20001Movexgdep() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhjj051a
     */
    @Data
    protected abstract Mhjj051a hrMhjj051a() ;
    
    /**
     * @return instancia da classe Mhjj067a
     */
    @Data
    protected abstract Mhjj067a hrMhjj067a() ;
    
    /**
     * @return instancia da classe Mhjj086a
     */
    @Data
    protected abstract Mhjj086a hrMhjj086a() ;
    
    /**
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghk0001
     */
    @Data
    protected abstract Bghk0001 bghk0001() ;
    
    /**
     * @return instancia da classe Bhjl051a
     */
    @Data
    protected abstract Bhjl051a bhjl051a() ;
    
    /**
     * @return instancia da classe Bhjl086a
     */
    @Data
    protected abstract Bhjl086a bhjl086a() ;
    
    /**
     * @return instancia da classe Bhjl067a
     */
    @Data
    protected abstract Bhjl067a bhjl067a() ;
    
    /**
     * @return instancia da classe Bhjl039a
     */
    @Data
    protected abstract Bhjl039a bhjl039a() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    protected static final String CON_NM_PROGRAMA = "PPUS973A" ;
    
    protected static final String CON_VGH20001 = "VGH20001" ;
    
    protected static final String CON_VGH20101 = "VGH20101" ;
    
    protected static final String CON_APLICACAO = "GH" ;
    
    protected static final String CON_APLICACAO_HO = "HO" ;
    
    protected static final String CON_ATIVO = "A" ;
    
    protected static final String CON_ABRANGIDO = "S" ;
    
    protected static final String CON_TODOS_ABRANGIDOS = "S" ;
    
    protected static final String CON_NAO_ABRANGIDO = "N" ;
    
    protected static final String CON_NAO_TODOS_ABRANG = "N" ;
    
    protected static final String CON_TAB_CAR_EXT = "G66" ;
    
    protected static final String CON_POR = "POR" ;
    
    protected static final String CON_DATA_MAX = "9999-12-31" ;
    
    protected static final int CON_1 = 1 ;
    
    protected static final int CON_11 = 11 ;
    
    protected static final int CON_75 = 75 ;
    
    /**
     * -- ERRO HO439 CLIENTES TITULARES DIFERENTES
     */
    protected static final int CON_HO_439 = -439 ;
    
    /**
     * VARIAVEIS
     * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * TABELA INTERNA
     * @return instancia da classe local WsTabelaTitulares
     */
    @Data
    protected abstract WsTabelaTitulares wsTabelaTitulares() ;
    
    /**
     * TABELA INTERNA PARA OBTENCAO DOS DADOS DOS TITULARES GUARDADOS
     * NA TGH00201
     * @return instancia da classe local WsTabelaTitularesTgh201
     */
    @Data
    protected abstract WsTabelaTitularesTgh201 wsTabelaTitularesTgh201() ;
    
    /**
     * DEFINICAO DE TABELAS DB2
     * TABELA DE MOVIMENTOS ABRANGIDOS PELA EXTENSAO DE GARANTIA DE
     * DEPOSITOS
     * TABELA DE TITULARES DA CONTA ABRANGIDOS PELA EXTENSAO DE
     * GARANTIA DE DEPOSITOS NUM DETERMINADO MOVIMENTO.
     * DEFINICAO DA SQL COMMUNICATION AREA
     * SWITCHES
     * @return instancia da classe local SwSwitchs
     */
    @Data
    protected abstract SwSwitchs swSwitchs() ;
    
    
    
    /**
     * 
     * BHJP5051-ACESSO AO MODULO QUE OBTEM OBTEM OS CONTRATOS ACTIVOS
     * DE UM CLIENTE NUMA DETERMINADA DATA , COM POSSIBILIDADE DE
     * LIMITAR OS RESULTADOS POR  I_TIPO_ITVT (MHJJ051A)
     * 
     */
    protected void bhjp5051AcedeMhjj051a() {
        hrMhjj051a().run() ;
    }
    
    /**
     * 
     * BHJP5067-ACESSO AO MODULO DE OBTENCAO DO NOME DO CLIENTE
     * (MHJJ067A)
     * 
     */
    protected void bhjp5067AcedeMhjj067a() {
        hrMhjj067a().run() ;
    }
    
    /**
     * 
     * BHJP5086-ACESSO AO MODULO QUE OBTEM OBTEM OS CONTRATOS ACTIVOS,*
     * CANCELADOS OU TODOS DE UM CLIENTE NUMA DETERMINADA DATA , COM
     * POSSIBILIDADE DE LIMITAR OS RESULTADOS POR  I_TIPO_ITVT E POR
     * Z_INIC_REL (MHJJ086A)
     * 
     */
    protected void bhjp5086AcedeMhjj086a() {
        hrMhjj086a().run() ;
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
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "********** INICIO PGHS191A **********");
        log(TraceLevel.Debug, "0000-MAINLINE");
        log(TraceLevel.Debug, "BGHM1190-MSG ", msgIn().msg());
        m1000InicioPrograma() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2000ProcessoPrograma() ;
        }
        m3000FinalPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ade().initialize() ;
        wsVariaveis().initialize() ;
        hv20001Movexgdep().movexgdep().initialize() ;
        hv20101Titexgdep().titexgdep().initialize() ;
        bhjl051a().commarea().initialize() ;
        bhjl086a().commarea().initialize() ;
        bhjl067a().commarea().initialize() ;
        bhjl039a().commarea().initialize() ;
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().msg().ade().set(msgIn().msg().ade());
        while (!msgOut().paginaCheia().isTrue()) {
            m1100IniciaOcorrencias() ;
        }
        while (wsTabelaTitulares().wsTitulares().index().isLessOrEqual(CON_75)) {
            m1200IniciaTabTitulares() ;
        }
        msgOut().indice().set(0);
        wsTabelaTitulares().wsTitulares().resetIndex() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            log(TraceLevel.Debug, " -- A N T E S -- ");
            log(TraceLevel.Debug, " -- BGHM1190-NS-TITC-PG:", msgIn().msg().ade().chaveContinuacao().nsTitcPg());
            log(TraceLevel.Debug, " -- BGHM1190-I-TIPO-ITVT-PG:", msgIn().msg().ade().chaveContinuacao().iTipoItvtPg());
            log(TraceLevel.Debug, "......... ULTIMA OCORRENCIA .........");
            log(TraceLevel.Debug, " . BGHM1190-I-TIPO-ITVT-L:", msgIn().msg().ade().linha().get(15).iTipoItvtL());
            log(TraceLevel.Debug, " . BGHM1190-NS-ITVT-L    :", msgIn().msg().ade().linha().get(15).nsItvtL());
            log(TraceLevel.Debug, " . BGHM1190-N-CLIENTE-L  :", msgIn().msg().ade().linha().get(15).nClienteL());
            msgIn().paginaCheia().setTrue() ;
            if (!msgIn().msg().ade().linha().get(msgIn().indice()).iTipoItvtL().isEqual(0)) {
                msgIn().msg().ade().chaveContinuacao().iTipoItvtPg().set(msgIn().msg().ade().linha().get(msgIn().indice()).iTipoItvtL());
                msgIn().msg().ade().chaveContinuacao().nsTitcPg().set(msgIn().msg().ade().linha().get(msgIn().indice()).nsItvtL());
                msgIn().msg().ade().chaveContinuacao().nClientePg().set(msgIn().msg().ade().linha().get(msgIn().indice()).nClienteL());
                log(TraceLevel.Debug, " -- D E P O I S -- ");
                log(TraceLevel.Debug, " -- BGHM1190-NS-TITC-PG:", msgIn().msg().ade().chaveContinuacao().nsTitcPg());
                log(TraceLevel.Debug, " -- BGHM1190-I-TIPO-ITVT-PG:", msgIn().msg().ade().chaveContinuacao().iTipoItvtPg());
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m1300ValidaInput() ;
        }
        log(TraceLevel.Debug, ">>>>>>>>>>>>> CAMPOS - I N P U T <<<<<<<<<<<<<<");
        log(TraceLevel.Debug, " --------------- SUBCONTA --------------- ");
        log(TraceLevel.Debug, "  . BGHM1190-C-PAIS-ISOA-CONT       :", msgIn().msg().ade().scta().cPaisIsoaCont());
        log(TraceLevel.Debug, "  . BGHM1190-C-BANC-CONT            :", msgIn().msg().ade().scta().cBancCont());
        log(TraceLevel.Debug, "  . BGHM1190-C-OE-EGC-CONT          :", msgIn().msg().ade().scta().cOeEgcCont());
        log(TraceLevel.Debug, "  . BGHM1190-NS-RDCL-CONT           :", msgIn().msg().ade().scta().nsRdclCont());
        log(TraceLevel.Debug, "  . BGHM1190-V-CHKD-CONT            :", msgIn().msg().ade().scta().vChkdCont());
        log(TraceLevel.Debug, "  . BGHM1190-C-TIPO-CONT            :", msgIn().msg().ade().scta().cTipoCont());
        log(TraceLevel.Debug, "  . BGHM1190-C-MOED-ISO-SCTA        :", msgIn().msg().ade().scta().cMoedIsoScta());
        log(TraceLevel.Debug, "  . BGHM1190-NS-DEPOSITO            :", msgIn().msg().ade().scta().nsDeposito());
        log(TraceLevel.Debug, " --------------- NS MOVIMENTO --------------- ");
        log(TraceLevel.Debug, "  . BGHM1190-NS-MOVIMENTO           :", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, " --------------- DADOS GARANTIA ---------------");
        log(TraceLevel.Debug, "  . BGHM1190-Z-MOVIMENTO            :", msgIn().msg().ade().dadosGarantia().zMovimento());
        log(TraceLevel.Debug, "  . BGHM1190-X-REF-MOV              :", msgIn().msg().ade().dadosGarantia().xRefMov());
        log(TraceLevel.Debug, "  . BGHM1190-M-MONTANTE-MOV         :", msgIn().msg().ade().dadosGarantia().mMontanteMov());
        log(TraceLevel.Debug, "  . BGHM1190-C-MOED-MOV             :", msgIn().msg().ade().dadosGarantia().cMoedMov());
        log(TraceLevel.Debug, "  . BGHM1190-M-MONTANTE-EXT         :", msgIn().msg().ade().dadosGarantia().mMontanteExt());
        log(TraceLevel.Debug, "  . BGHM1190-C-MOED-EXT             :", msgIn().msg().ade().dadosGarantia().cMoedExt());
        log(TraceLevel.Debug, "  . BGHM1190-C-CAR-EXT              :", msgIn().msg().ade().dadosGarantia().cCarExt());
        log(TraceLevel.Debug, "  . BGHM1190-Z-INI-GARANTIA         :", msgIn().msg().ade().dadosGarantia().zIniGarantia());
        log(TraceLevel.Debug, "  . BGHM1190-Z-FIM-GARANTIA         :", msgIn().msg().ade().dadosGarantia().zFimGarantia());
        log(TraceLevel.Debug, " --------------- SOLICITADOR ---------------");
        log(TraceLevel.Debug, "  . BGHM1190-NS-INT-SOL             :", msgIn().msg().ade().solicitador().nsIntSol());
        log(TraceLevel.Debug, "  . BGHM1190-N-CLIENTE-SOL          :", msgIn().msg().ade().solicitador().nClienteSol());
        log(TraceLevel.Debug, "  . BGHM1190-NM-CLI-ABV-SOL         :", msgIn().msg().ade().solicitador().nmCliAbvSol());
        log(TraceLevel.Debug, "  . BGHM1190-C-TIPO-SOL             :", msgIn().msg().ade().solicitador().cTipoSol());
        log(TraceLevel.Debug, " --------------- REGISTO --------------- ");
        log(TraceLevel.Debug, "  . BGHM1190-N-UTL-INS-GT           :", msgIn().msg().ade().registo().nUtlInsGt());
        log(TraceLevel.Debug, "  . BGHM1190-Z-INS-GT               :", msgIn().msg().ade().registo().zInsGt());
        log(TraceLevel.Debug, "  . BGHM1190-H-INS-GT               :", msgIn().msg().ade().registo().hInsGt());
        log(TraceLevel.Debug, " --------------- ULT ALTERACAO --------------- ");
        log(TraceLevel.Debug, "  . BGHM1190-N-UTL-ULT-ALT          :", msgIn().msg().ade().ultAlteracao().nUtlUltAlt());
        log(TraceLevel.Debug, "  . BGHM1190-Z-ULT-ALT              :", msgIn().msg().ade().ultAlteracao().zUltAlt());
        log(TraceLevel.Debug, "  . BGHM1190-H-ULT-ALT              :", msgIn().msg().ade().ultAlteracao().hUltAlt());
        log(TraceLevel.Debug, " --------------- TODOS TITULARES ---------------");
        log(TraceLevel.Debug, "  . BGHM1190-I-TODOS-TIT-ABGD       :", msgIn().msg().ade().iTodosTitAbgd());
        log(TraceLevel.Debug, " --------------- CHV CONTINUACAO ---------------");
        log(TraceLevel.Debug, "  . BGHM1190-N-CLIENTE-PG           :", msgIn().msg().ade().chaveContinuacao().nClientePg());
        log(TraceLevel.Debug, "  . BGHM1190-I-TIPO-ITVT-PG         :", msgIn().msg().ade().chaveContinuacao().iTipoItvtPg());
        log(TraceLevel.Debug, "  . BGHM1190-NS-TITC-PG             :", msgIn().msg().ade().chaveContinuacao().nsTitcPg());
        log(TraceLevel.Debug, " ----------------------------------------- ");
        log(TraceLevel.Debug, " --------------- L I S T A --------------- ");
        log(TraceLevel.Debug, " ----------------------------------------- ");
        wsVariaveis().wsIndLista().set(0);
        for (int i = 1; i <= msgIn().indiceInverso().get(); i++) {
            wsVariaveis().wsIndLista().add(1);
            log(TraceLevel.Debug, "  ------ OCORRENCIA ", wsVariaveis().wsIndLista(), " ------ ");
            log(TraceLevel.Debug, "      . BGHM1190-I-ACCZ-MNTZ-LSTA-L :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).iAcczMntzLstaL());
            log(TraceLevel.Debug, "      . BGHM1190-NS-ITVT-L          :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).nsItvtL());
            log(TraceLevel.Debug, "      . BGHM1190-I-TIPO-ITVT-L      :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).iTipoItvtL());
            log(TraceLevel.Debug, "      . BGHM1190-N-CLIENTE-L        :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).nClienteL());
            log(TraceLevel.Debug, "      . BGHM1190-NM-CLI-ABVD-L      :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).nmCliAbvdL());
            log(TraceLevel.Debug, "      . BGHM1190-Z-INI-ITVT-L       :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).zIniItvtL());
            log(TraceLevel.Debug, "      . BGHM1190-Z-FIM-ITVT-L       :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).zFimItvtL());
            log(TraceLevel.Debug, "      . BGHM1190-I-TITC-EXS-GAR     :", msgIn().msg().ade().linha().get(wsVariaveis().wsIndLista()).iTitcExsGar());
        }
        log(TraceLevel.Debug, ">>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    
    /**
     * 
     * 1100-INICIA-OCORRENCIAS
     * 
     */
    protected void m1100IniciaOcorrencias() {
        log(TraceLevel.Debug, "1100-INICIA-OCORRENCIAS");
        msgOut().indice().add(CON_1);
        msgOut().msg().ade().linha().get(msgOut().indice()).initialize() ;
    }
    
    /**
     * 
     * 1200-INICIA-TAB-TITULARES
     * 
     */
    protected void m1200IniciaTabTitulares() {
        log(TraceLevel.Debug, "1200-INICIA-TAB-TITULARES");
        wsTabelaTitulares().wsTitulares().getCurrent().wsIAcczMntzListaL().set(" ");
        wsTabelaTitulares().wsTitulares().getCurrent().wsNmCliAbvdL().set(" ");
        wsTabelaTitulares().wsTitulares().getCurrent().wsZIniItvtL().set(" ");
        wsTabelaTitulares().wsTitulares().getCurrent().wsZFimItvtL().set(" ");
        wsTabelaTitulares().wsTitulares().getCurrent().wsITitcExsGarL().set(" ");
        wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL().set(0);
        wsTabelaTitulares().wsTitulares().getCurrent().wsITipoItvtL().set(0);
        wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL().set(0);
        wsTabelaTitulares().wsTitulares().incIndex() ;
    }
    
    /**
     * 
     * 1300-VALIDA-INPUT
     * 
     */
    protected void m1300ValidaInput() {
        log(TraceLevel.Debug, "1300-VALIDA-INPUT");
        log(TraceLevel.Debug, "------------ INPUT ------------");
        log(TraceLevel.Debug, " --> BGHM1190-C-PAIS-ISOA-CONT :", msgIn().msg().ade().scta().cPaisIsoaCont());
        log(TraceLevel.Debug, " --> BGHM1190-C-BANC-CONT      :", msgIn().msg().ade().scta().cBancCont());
        log(TraceLevel.Debug, " --> BGHM1190-C-OE-EGC-CONT    :", msgIn().msg().ade().scta().cOeEgcCont());
        log(TraceLevel.Debug, " --> BGHM1190-NS-RDCL-CONT     :", msgIn().msg().ade().scta().nsRdclCont());
        log(TraceLevel.Debug, " --> BGHM1190-V-CHKD-CONT      :", msgIn().msg().ade().scta().vChkdCont());
        log(TraceLevel.Debug, " --> BGHM1190-C-TIPO-CONT      :", msgIn().msg().ade().scta().cTipoCont());
        log(TraceLevel.Debug, " --> BGHM1190-C-MOED-ISO-SCTA  :", msgIn().msg().ade().scta().cMoedIsoScta());
        log(TraceLevel.Debug, " --> BGHM1190-NS-DEPOSITO      :", msgIn().msg().ade().scta().nsDeposito());
        log(TraceLevel.Debug, " --> BGHM1190-NS-MOVIMENTO     :", msgIn().msg().ade().nsMovimento());
        log(TraceLevel.Debug, " --> BGHM1190-Z-MOVIMENTO      :", msgIn().msg().ade().dadosGarantia().zMovimento());
        log(TraceLevel.Debug, " --> BGHM1190-X-REF-MOV        :", msgIn().msg().ade().dadosGarantia().xRefMov());
        log(TraceLevel.Debug, " --> BGHM1190-M-MONTANTE-MOV   :", msgIn().msg().ade().dadosGarantia().mMontanteMov());
        log(TraceLevel.Debug, " --> BGHM1190-C-MOED-MOV       :", msgIn().msg().ade().dadosGarantia().cMoedMov());
        log(TraceLevel.Debug, " --> BGHM1190-M-MONTANTE-EXT   :", msgIn().msg().ade().dadosGarantia().mMontanteExt());
        log(TraceLevel.Debug, " --> BGHM1190-C-MOED-EXT       :", msgIn().msg().ade().dadosGarantia().cMoedExt());
        log(TraceLevel.Debug, " --> BGHM1190-C-CAR-EXT        :", msgIn().msg().ade().dadosGarantia().cCarExt());
        log(TraceLevel.Debug, " --> BGHM1190-Z-INI-GARANTIA   :", msgIn().msg().ade().dadosGarantia().zIniGarantia());
        log(TraceLevel.Debug, " --> BGHM1190-Z-FIM-GARANTIA   :", msgIn().msg().ade().dadosGarantia().zFimGarantia());
        log(TraceLevel.Debug, " --> BGHM1190-NS-INT-SOL       :", msgIn().msg().ade().solicitador().nsIntSol());
        log(TraceLevel.Debug, " --> BGHM1190-N-CLIENTE-SOL    :", msgIn().msg().ade().solicitador().nClienteSol());
        log(TraceLevel.Debug, " --> BGHM1190-NM-CLI-ABV-SOL   :", msgIn().msg().ade().solicitador().nmCliAbvSol());
        log(TraceLevel.Debug, " --> BGHM1190-C-TIPO-SOL       :", msgIn().msg().ade().solicitador().cTipoSol());
        log(TraceLevel.Debug, " --> BGHM1190-N-UTL-INS-GT     :", msgIn().msg().ade().registo().nUtlInsGt());
        log(TraceLevel.Debug, " --> BGHM1190-Z-INS-GT         :", msgIn().msg().ade().registo().zInsGt());
        log(TraceLevel.Debug, " --> BGHM1190-H-INS-GT         :", msgIn().msg().ade().registo().hInsGt());
        log(TraceLevel.Debug, " --> BGHM1190-N-UTL-ULT-ALT    :", msgIn().msg().ade().ultAlteracao().nUtlUltAlt());
        log(TraceLevel.Debug, " --> BGHM1190-Z-ULT-ALT        :", msgIn().msg().ade().ultAlteracao().zUltAlt());
        log(TraceLevel.Debug, " --> BGHM1190-H-ULT-ALT        :", msgIn().msg().ade().ultAlteracao().hUltAlt());
        log(TraceLevel.Debug, " --> BGHM1190-N-CLIENTE-PG     :", msgIn().msg().ade().chaveContinuacao().nClientePg());
        log(TraceLevel.Debug, " --> BGHM1190-I-TIPO-ITVT-PG   :", msgIn().msg().ade().chaveContinuacao().iTipoItvtPg());
        log(TraceLevel.Debug, " --> BGHM1190-NS-TITC-PG       :", msgIn().msg().ade().chaveContinuacao().nsTitcPg());
        /**
         * VERIFICAR SE OS SEGUINTES CAMPOS ESTAO PREENCHIDOS
         */
        if (msgIn().msg().ade().scta().cPaisIsoaCont().isEmpty() || 
            msgIn().msg().ade().scta().cBancCont().isEqual(0) || 
            !msgIn().msg().ade().scta().cBancCont().isNumeric() || 
            msgIn().msg().ade().scta().cOeEgcCont().isEqual(0) || 
            !msgIn().msg().ade().scta().cOeEgcCont().isNumeric() || 
            msgIn().msg().ade().scta().nsRdclCont().isEqual(0) || 
            !msgIn().msg().ade().scta().vChkdCont().isNumeric() || 
            !msgIn().msg().ade().scta().cTipoCont().isNumeric() || 
            msgIn().msg().ade().scta().cMoedIsoScta().isEmpty() || 
            !msgIn().msg().ade().scta().nsDeposito().isNumeric() || 
            msgIn().msg().ade().nsMovimento().isEqual(0) || 
            !msgIn().msg().ade().nsMovimento().isNumeric()) {
            log(TraceLevel.Error, " ------------------------------ ");
            log(TraceLevel.Error, " ------ ERRO DADOS INPUT ------ ");
            log(TraceLevel.Error, " ------------------------------ ");
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(CON_APLICACAO);
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        m2100SelecionarExtensao() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2200SelecionarTitulares() ;
        }
    }
    
    /**
     * 
     * 2100-SELECIONAR-EXTENSAO
     * 
     */
    protected void m2100SelecionarExtensao() {
        log(TraceLevel.Debug, "2100-SELECIONAR-EXTENSAO");
        hv20001Movexgdep().movexgdep().initialize() ;
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
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH20001_MOVEXGDEP
         */
        hv20001Movexgdep().selectPghs191a628() ;
        swSwitchs().swSqlcodeVgh20001().set(hv20001Movexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (swSwitchs().swVgh20001Ok().isTrue()) {
            msgOut().msg().ade().nsMovimento().set(hv20001Movexgdep().movexgdep().nsMovimento());
            msgOut().msg().ade().dadosGarantia().mMontanteExt().set(hv20001Movexgdep().movexgdep().mMovimento());
            /**
             * -- A MOEDA DO MONTANTE DA EXTENSAO E IGUAL A MOEDA
             * -- DO MOVIMENTO MARCADO
             */
            msgOut().msg().ade().dadosGarantia().cMoedExt().set(msgIn().msg().ade().dadosGarantia().cMoedMov());
            msgOut().msg().ade().dadosGarantia().cCarExt().set(hv20001Movexgdep().movexgdep().cCrtzMovExsGar());
            msgOut().msg().ade().dadosGarantia().zIniGarantia().set(hv20001Movexgdep().movexgdep().zIniExtsGarDep());
            msgOut().msg().ade().dadosGarantia().zFimGarantia().set(hv20001Movexgdep().movexgdep().zFimExtsGarDep());
            msgOut().msg().ade().solicitador().cTipoSol().set(hv20001Movexgdep().movexgdep().iTipItvtExsGar());
            msgOut().msg().ade().solicitador().nsIntSol().set(hv20001Movexgdep().movexgdep().nsTitcExtsGart());
            msgOut().msg().ade().registo().nUtlInsGt().set(hv20001Movexgdep().movexgdep().cUsidCrix());
            msgOut().msg().ade().registo().zInsGt().set(hv20001Movexgdep().movexgdep().tsCriacao().get(1, 10));
            msgOut().msg().ade().registo().hInsGt().set(hv20001Movexgdep().movexgdep().tsCriacao().get(12, 8));
            msgOut().msg().ade().ultAlteracao().zUltAlt().set(hv20001Movexgdep().movexgdep().tsActzUlt().get(1, 10));
            msgOut().msg().ade().ultAlteracao().hUltAlt().set(hv20001Movexgdep().movexgdep().tsActzUlt().get(12, 8));
            msgOut().msg().ade().ultAlteracao().nUtlUltAlt().set(hv20001Movexgdep().movexgdep().cUsidActzUlt());
        } else if (swSwitchs().swVgh20001Notfnd().isTrue()) {
            msgOut().msg().ade().registo().nUtlInsGt().set(message.mensagem().headerR().nrElectronico().cUserid());
            msgOut().msg().ade().registo().zInsGt().set(message.mensagem().headerR().datasProcesso().zPrctJourBbn());
            msgOut().msg().ade().registo().hInsGt().set(envIn.controlo().hSessao());
            msgOut().msg().ade().dadosGarantia().mMontanteExt().set(msgIn().msg().ade().dadosGarantia().mMontanteMov());
            msgOut().msg().ade().dadosGarantia().cMoedExt().set(msgIn().msg().ade().dadosGarantia().cMoedMov());
        } else {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(hv20001Movexgdep().getPersistenceCode());
            envOut.db2Log().nmTabela().set(CON_VGH20001);
        }
    }
    
    /**
     * 
     * 2200-SELECIONAR-TITULARES
     * 
     */
    protected void m2200SelecionarTitulares() {
        log(TraceLevel.Debug, "2200-SELECIONAR-TITULARES");
        log(TraceLevel.Debug, " »»»»»»»»»» SW-SQLCODE-VGH20001:", swSwitchs().swSqlcodeVgh20001());
        if (swSwitchs().swVgh20001Ok().isTrue()) {
            swSwitchs().swExisteMarcacaoAtiva().setTrue() ;
            m2210TitularesTgh201() ;
        } else {
            swSwitchs().swNaoExisteMarcacao().setTrue() ;
            m2220TitularesClientes() ;
        }
    }
    
    /**
     * 
     * 2210-TITULARES-TGH201
     * 
     */
    protected void m2210TitularesTgh201() {
        log(TraceLevel.Debug, "2210-TITULARES-TGH201");
        m2211AbreCrsTgh201() ;
        if (envOut.errosGraves().semErros().isTrue()) {
            m2212FetchCrsTgh201() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m2214ObtemClientes() ;
            wsTabelaTitulares().wsTitulares().resetIndex() ;
            while (!swSwitchs().swVgh20101Notfnd().isTrue() && envOut.errosGraves().semErros().isTrue()) {
                m2213TrataCrsTgh201() ;
            }
        }
        m2216CloseCrsTgh201() ;
    }
    
    /**
     * 
     * 2211-ABRE-CRS-TGH201
     * 
     */
    protected void m2211AbreCrsTgh201() {
        log(TraceLevel.Debug, "2211-ABRE-CRS-TGH201");
        hv20101Titexgdep().titexgdep().initialize() ;
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        if (!msgIn().msg().ade().chaveContinuacao().iTipoItvtPg().isEqual(0)) {
            hv20101Titexgdep().titexgdep().iTipoItvt().set(msgIn().msg().ade().chaveContinuacao().iTipoItvtPg());
            hv20101Titexgdep().titexgdep().nsTitc().set(msgIn().msg().ade().chaveContinuacao().nsTitcPg());
        } else {
            hv20101Titexgdep().titexgdep().iTipoItvt().set(0);
            hv20101Titexgdep().titexgdep().nsTitc().set(0);
        }
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor CRS-TGH201
         */
        hv20101Titexgdep().openPghs191a820() ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
            envOut.db2Log().nmTabela().set(CON_VGH20101);
        }
    }
    
    /**
     * 
     * 2212-FETCH-CRS-TGH201
     * 
     */
    protected void m2212FetchCrsTgh201() {
        log(TraceLevel.Debug, "2212-FETCH-CRS-TGH201");
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor CRS-TGH201
         */
        hv20101Titexgdep().fetchPghs191a849() ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue() && !swSwitchs().swVgh20101Notfnd().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
            envOut.db2Log().nmTabela().set(CON_VGH20101);
        }
    }
    
    /**
     * 
     * 2213-TRATA-CRS-TGH201
     * 
     */
    protected void m2213TrataCrsTgh201() {
        log(TraceLevel.Debug, "2213-TRATA-CRS-TGH201");
        log(TraceLevel.Debug, " ---> VGH20101-NS-TITC            :", hv20101Titexgdep().titexgdep().nsTitc());
        log(TraceLevel.Debug, " ---> VGH20101-I-TIPO-ITVT        :", hv20101Titexgdep().titexgdep().iTipoItvt());
        log(TraceLevel.Debug, " ---> VGH20101-I-TITC-EXS-GAR-DEP :", hv20101Titexgdep().titexgdep().iTitcExsGarDep());
        wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL().set(hv20101Titexgdep().titexgdep().nsTitc());
        wsTabelaTitulares().wsTitulares().getCurrent().wsITipoItvtL().set(hv20101Titexgdep().titexgdep().iTipoItvt());
        wsTabelaTitulares().wsTitulares().getCurrent().wsITitcExsGarL().set(hv20101Titexgdep().titexgdep().iTitcExsGarDep());
        wsTabelaTitularesTgh201().wsTitularesMhjj086a().resetIndex() ;
        while (wsTabelaTitularesTgh201().wsTitularesMhjj086a().index().isLessOrEqual(999)) {
            if (wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNsTitcMhj86().isEqual(wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL())) {
                wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL().set(wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNClienteMhj86());
                wsTabelaTitulares().wsTitulares().getCurrent().wsZIniItvtL().set(wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsZIniItvtMhj86());
                wsTabelaTitulares().wsTitulares().getCurrent().wsZFimItvtL().set(wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsZFimItvtMhj86());
                log(TraceLevel.Debug, "»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
                log(TraceLevel.Debug, " » CLIENTE            :", wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL());
                log(TraceLevel.Debug, " » INICIO RELACAO     :", wsTabelaTitulares().wsTitulares().getCurrent().wsZIniItvtL());
                log(TraceLevel.Debug, " » FIM RELACAO        :", wsTabelaTitulares().wsTitulares().getCurrent().wsZFimItvtL());
                log(TraceLevel.Debug, "«««««««««««««««««««««««««««««««««");
                break;
            }
            wsTabelaTitularesTgh201().wsTitularesMhjj086a().incIndex() ;
        }
        if (wsTabelaTitularesTgh201().wsTitularesMhjj086a().atEnd()) {
            log(TraceLevel.Trace, " CLIENTE TITULAR COM SEQ INTERVENCAO ");
            log(TraceLevel.Trace, hv20101Titexgdep().titexgdep().nsTitc(), " INEXISTENTE]");
        }
        log(TraceLevel.Debug, "_________________________________________");
        log(TraceLevel.Debug, " ");
        log(TraceLevel.Debug, "----> WS-NS-TITC-MHJ86(WS-IND-CLI-MHJ86):", wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNsTitcMhj86());
        log(TraceLevel.Debug, "----> WS-NS-TITC-L(WS-IND-TIT):", wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL());
        log(TraceLevel.Debug, "_________________________________________");
        if (wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNsTitcMhj86().isEqual(wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL())) {
            m2215AcedeMhjj067a() ;
            /**
             * -- SE DATA FIM DE INTERVENCAO MENOR OU IGUAL DO QUE DATA
             * -- DO DIA, O CLIENTE EM QUESTAO JA NAO PODE SER
             * -- ABRANGIDO
             */
            if (wsTabelaTitulares().wsTitulares().getCurrent().wsZFimItvtL().isLessOrEqual(message.mensagem().headerR().datasProcesso().zPrctJourBbn()) && 
                message.mensagem().headerR().transaccao().modificacao().isTrue()) {
                /**
                 * -- ATUALIZA INDICADOR DE TITULAR ABRANGIDO COM 'N'
                 */
                m2213AtlzTitAbgd() ;
                wsTabelaTitulares().wsTitulares().getCurrent().wsITitcExsGarL().set(CON_NAO_ABRANGIDO);
            }
            if (envOut.errosGraves().semErros().isTrue()) {
                log(TraceLevel.Debug, " ---> BHJL067A-NM-CLI-ABVD        :", bhjl067a().commarea().dadosSaida().nmCliAbvd());
                wsTabelaTitulares().wsTitulares().getCurrent().wsNmCliAbvdL().set(bhjl067a().commarea().dadosSaida().nmCliAbvd());
            }
        } else {
            /**
             * ------------ CLIENTES TITULARES DIFERENTES
             */
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(CON_HO_439);
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_HO);
        }
        m2212FetchCrsTgh201() ;
        wsTabelaTitulares().wsTitulares().incIndex() ;
    }
    
    /**
     * 
     * 2213-ATLZ-TIT-ABGD
     * 
     */
    protected void m2213AtlzTitAbgd() {
        log(TraceLevel.Debug, "2213-ATLZ-TIT-ABGD");
        hv20101Titexgdep().titexgdep().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        hv20101Titexgdep().titexgdep().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        hv20101Titexgdep().titexgdep().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        hv20101Titexgdep().titexgdep().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        hv20101Titexgdep().titexgdep().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        hv20101Titexgdep().titexgdep().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        hv20101Titexgdep().titexgdep().cMoedIsoScta().set(msgIn().msg().ade().scta().cMoedIsoScta());
        hv20101Titexgdep().titexgdep().nsDeposito().set(msgIn().msg().ade().scta().nsDeposito());
        hv20101Titexgdep().titexgdep().nsMovimento().set(msgIn().msg().ade().nsMovimento());
        hv20101Titexgdep().titexgdep().iTipoItvt().set(wsTabelaTitulares().wsTitulares().getCurrent().wsITipoItvtL());
        hv20101Titexgdep().titexgdep().nsTitc().set(wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL());
        hv20101Titexgdep().titexgdep().cUsidActzUlt().set(message.mensagem().headerR().nrElectronico().cUserid());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH20101_TITEXGDEP
         */
        hv20101Titexgdep().updatePghs191a1016(CON_NAO_ABRANGIDO) ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue()) {
            envOut.errosGraves().abendDb2().setTrue() ;
            envOut.errosGraves().aAplErr().set(bhtk0002().siglaArquit());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH20101);
            envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
            log(TraceLevel.Error, "ERRO-06");
            log(TraceLevel.Error, "ERRO NO 2213-ATLZ-TIT-ABGD: ", hv20101Titexgdep().getPersistenceCode());
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
            log(TraceLevel.Error, "I-TIPO-ITVT      = ", hv20101Titexgdep().titexgdep().iTipoItvt());
            log(TraceLevel.Error, "NS-TITC          = ", hv20101Titexgdep().titexgdep().nsTitc());
        }
    }
    
    /**
     * 
     * 2214-OBTEM-CLIENTES
     * 
     */
    protected void m2214ObtemClientes() {
        log(TraceLevel.Debug, "2214-OBTEM-CLIENTES");
        /**
         * INICIALIZA INDICE DA TABELA INTERNA ONDE VAO SER GUARDADOS
         * OS TITULARES
         */
        wsTabelaTitularesTgh201().wsTitularesMhjj086a().resetIndex() ;
        /**
         * -- OBTEM TODOS OS TITULARES 101
         */
        wsVariaveis().wsITipoItvtAux().set(101);
        m2214ObtemDadosCli() ;
        /**
         * -- OBTEM TODOS OS TITULARES 102 ASS. UNICA
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsITipoItvtAux().set(102);
            m2214ObtemDadosCli() ;
        }
        /**
         * -- OBTEM TODOS OS TITULARES 103 ASS.OBRIGAT
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsITipoItvtAux().set(103);
            m2214ObtemDadosCli() ;
        }
        /**
         * -- OBTEM TODOS OS TITULARES 104 ASS.CONJUNTA
         */
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsITipoItvtAux().set(104);
            m2214ObtemDadosCli() ;
        }
        /**
         * -- SE NAO FOI DEVOLVIDO NENHUM REGISTO EM NENHUM DOS ACESSOS
         * -- DEVOLVE ERRO
         */
        if (wsTabelaTitularesTgh201().wsTitularesMhjj086a().get(1).wsNsTitcMhj86().isEqual(0)) {
            /**
             * ------------ CLIENTES TITULARES DIFERENTES
             */
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaContM().set(CON_HO_439);
            msgOut().msg().ase().cPaisIsoaContSt().cPaisIsoaCont1().setTrue() ;
            envOut.errosGraves().aAplErr().set(CON_APLICACAO_HO);
            log(TraceLevel.Error, "ERRO-99");
        }
    }
    
    /**
     * 
     * 2214-OBTEM-DADOS-CLI
     * 
     */
    protected void m2214ObtemDadosCli() {
        log(TraceLevel.Debug, "2214-OBTEM-DADOS-CLI");
        bhjl086a().commarea().initialize() ;
        bhjl086a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl086a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjl086a().commarea().dadosEntrada().cPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        wsVariaveis().wsNContrato().wsCPaisIsoaCont().set(msgIn().msg().ade().scta().cPaisIsoaCont());
        bhjl086a().commarea().dadosEntrada().cBancCont().set(msgIn().msg().ade().scta().cBancCont());
        wsVariaveis().wsNContrato().wsCBancCont().set(msgIn().msg().ade().scta().cBancCont());
        bhjl086a().commarea().dadosEntrada().cOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        wsVariaveis().wsNContrato().wsCOeEgcCont().set(msgIn().msg().ade().scta().cOeEgcCont());
        bhjl086a().commarea().dadosEntrada().nsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        wsVariaveis().wsNContrato().wsNsRdclCont().set(msgIn().msg().ade().scta().nsRdclCont());
        bhjl086a().commarea().dadosEntrada().vChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        wsVariaveis().wsNContrato().wsVChkdCont().set(msgIn().msg().ade().scta().vChkdCont());
        bhjl086a().commarea().dadosEntrada().cTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        wsVariaveis().wsNContrato().wsCTipoCont().set(msgIn().msg().ade().scta().cTipoCont());
        bhjl086a().commarea().dadosEntrada().nContrato().set(wsVariaveis().wsNContrato());
        bhjl086a().commarea().dadosEntrada().iTipoItvtL().set(wsVariaveis().wsITipoItvtAux());
        bhjl086a().commarea().dadosEntrada().itvtTodas().setTrue() ;
        log(TraceLevel.Debug, " ----- ACESSO  M H J J 0 8 6 A ----- ");
        log(TraceLevel.Debug, " -----> BHJL086A-NS-TITC-PAG       :", bhjl086a().commarea().dadosEntrada().nsTitcPag());
        log(TraceLevel.Debug, " -----> BHJL086A-I-TIPO-ITVT-L     :", bhjl086a().commarea().dadosEntrada().iTipoItvtL());
        log(TraceLevel.Debug, " ----------------------------------- ");
        bhjp5086AcedeMhjj086a() ;
        log(TraceLevel.Debug, " - - - RETORNO  M H J J 0 8 6 A - - - ");
        log(TraceLevel.Debug, " -----> BHJL086A-Q-OCCURS-OUT:", bhjl086a().commarea().qOccursOut());
        log(TraceLevel.Debug, " -----> BHJL086A-C-TIPO-ERRO-BBN:", bhjl086a().commarea().erros().cTipoErroBbn());
        envOut.errosGraves().cTipoErroBbn().set(bhjl086a().commarea().erros().cTipoErroBbn());
        if (!bhjl086a().commarea().erros().semErros().isTrue()) {
            if (bhjl086a().commarea().erros().fimConsulta().isTrue() || bhjl086a().commarea().erros().nExistReg().isTrue()) {
                envOut.errosGraves().cTipoErroBbn().set(" ");
            } else {
                envOut.errosGraves().aAplErr().set(bhjl086a().commarea().erros().aAplErr());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl086a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl086a().commarea().erros().nmTabela());
                msgOut().msg().ase().cOeEgcContSt().cOeEgcCont1().setTrue() ;
                msgOut().msg().ase().cOeEgcContSt().cOeEgcContM().set(bhjl086a().commarea().erros().cRtnoEvenSwal());
            }
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsIndCli().set(1);
            for (int i = 1; i <= bhjl086a().commarea().qOccursOut().get(); i++) {
                wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNsTitcMhj86().set(bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).nsTitc());
                wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNClienteMhj86().set(bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).nCliente());
                wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsZIniItvtMhj86().set(bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).zInicRel());
                wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsZFimItvtMhj86().set(bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).zFimRel());
                log(TraceLevel.Debug, "»»»»»»»»»»»»» ", wsVariaveis().wsIndCli(), " «««««««««««««");
                log(TraceLevel.Debug, "  - BHJL086A-N-CLIENTE           :", bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).nCliente());
                log(TraceLevel.Debug, "  - BHJL086A-NS-ABRA-CLI         :", bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).nsAbraCli());
                log(TraceLevel.Debug, "  - BHJL086A-C-TIPO-CLI          :", bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).cTipoCli());
                log(TraceLevel.Debug, "  - BHJL086A-I-TIPO-ITVT         :", bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).iTipoItvt());
                log(TraceLevel.Debug, "  - BHJL086A-NS-TITC             :", bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).nsTitc());
                log(TraceLevel.Debug, "  - BHJL086A-Z-INIC-REL          :", bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).zInicRel());
                log(TraceLevel.Debug, "  - BHJL086A-Z-FIM-REL           :", bhjl086a().commarea().dadosSaida().get(wsVariaveis().wsIndCli()).zFimRel());
                wsVariaveis().wsIndCli().add(1);
                wsTabelaTitularesTgh201().wsTitularesMhjj086a().incIndex() ;
            }
        }
    }
    
    /**
     * 
     * 2215-ACEDE-MHJJ067A
     * 
     */
    protected void m2215AcedeMhjj067a() {
        log(TraceLevel.Debug, "2215-ACEDE-MHJJ067A");
        bhjl067a().commarea().initialize() ;
        bhjl067a().commarea().dadosEntrada().nCliente().set(wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNClienteMhj86());
        bhjl067a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl067a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        bhjp5067AcedeMhjj067a() ;
        envOut.errosGraves().cTipoErroBbn().set(bhjl067a().commarea().erros().cTipoErroBbn());
        if (!bhjl067a().commarea().erros().semErros().isTrue()) {
            envOut.errosGraves().aAplErr().set(bhjl067a().commarea().erros().aAplErr());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl067a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl067a().commarea().erros().nmTabela());
            msgOut().msg().ase().nsRdclContSt().nsRdclCont1().setTrue() ;
            msgOut().msg().ase().nsRdclContSt().nsRdclContM().set(bhjl067a().commarea().erros().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 2216-CLOSE-CRS-TGH201
     * 
     */
    protected void m2216CloseCrsTgh201() {
        log(TraceLevel.Debug, "2216-CLOSE-CRS-TGH201");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor CRS-TGH201
         */
        hv20101Titexgdep().closePghs191a1279() ;
        swSwitchs().swSqlcodeVgh20101().set(hv20101Titexgdep().getPersistenceCode());
        bhtp0002M9020Db2check() ;
        if (!swSwitchs().swVgh20101Ok().isTrue()) {
            envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
            envOut.errosGraves().cRtnoEvenSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().sqlca().cSqlcode().set(hv20101Titexgdep().getPersistenceCode());
            envOut.db2Log().nmTabela().set(CON_VGH20101);
        }
    }
    
    /**
     * 
     * 2220-TITULARES-CLIENTES
     * 
     */
    protected void m2220TitularesClientes() {
        log(TraceLevel.Debug, "2220-TITULARES-CLIENTES");
        bhjl051a().commarea().initialize() ;
        while (envOut.errosGraves().semErros().isTrue() && !bhjl051a().commarea().erros().fimConsulta().isTrue()) {
            m2221AcedeMhjj051a() ;
        }
    }
    
    /**
     * 
     * 2221-ACEDE-MHJJ051A
     * 
     */
    protected void m2221AcedeMhjj051a() {
        log(TraceLevel.Debug, "2221-ACEDE-MHJJ051A");
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
            log(TraceLevel.Debug, " >>>>>>>>>>>> RETORNO MHJJ051A OK <<<<<<<<<<");
            log(TraceLevel.Debug, " --> BHJL051A-Q-OCCURS-OUT:", bhjl051a().commarea().qOccursOut());
            for (int i = 1; i <= bhjl051a().commarea().qOccursOut().get(); i++) {
                wsVariaveis().wsOcc().add(1);
                log(TraceLevel.Debug, " --> BHJL051A-N-CLIENTE:", wsVariaveis().wsOcc(), " ", bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsOcc()).nCliente());
            }
            wsVariaveis().wsOcc().set(0);
            for (wsTabelaTitulares().wsTitulares().setIndex(1); wsTabelaTitulares().wsTitulares().index().isLessOrEqual(bhjl051a().commarea().qOccursOut()) && bhjl067a().commarea().erros().semErros().isTrue(); wsTabelaTitulares().wsTitulares().incIndex()) {
                wsVariaveis().wsOcc().add(1);
                log(TraceLevel.Debug, "BHJL051A-N-CLIENTE(WS-IND-TIT):", bhjl051a().commarea().dadosSaida().get(wsTabelaTitulares().wsTitulares().index()).nCliente());
                wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsOcc()).nCliente());
                wsTabelaTitulares().wsTitulares().getCurrent().wsITipoItvtL().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsOcc()).iTipoItvt());
                wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsOcc()).nsTitc());
                wsTabelaTitulares().wsTitulares().getCurrent().wsZIniItvtL().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsOcc()).zInicRel());
                wsTabelaTitulares().wsTitulares().getCurrent().wsZFimItvtL().set(CON_DATA_MAX);
                wsTabelaTitulares().wsTitulares().getCurrent().wsITitcExsGarL().set(CON_ABRANGIDO);
                wsTabelaTitulares().wsTitulares().getCurrent().wsIAcczMntzListaL().set(message.mensagem().headerR().transaccao().iAccao());
                m2222AcedeMhjj067a() ;
            }
        } else {
            envOut.errosGraves().aAplErr().set(bhjl051a().commarea().erros().aAplErr());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl051a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl051a().commarea().erros().nmTabela());
            msgOut().msg().ase().nsRdclContSt().nsRdclCont1().setTrue() ;
            msgOut().msg().ase().nsRdclContSt().nsRdclContM().set(bhjl051a().commarea().erros().cRtnoEvenSwal());
        }
        if (bhjl051a().commarea().erros().semErros().isTrue() && bhjl051a().commarea().pagCheia().isTrue()) {
            bhjl051a().commarea().dadosEntrada().nsTitcPag().set(bhjl051a().commarea().dadosSaida().get(bhjl051a().commarea().qOccursOut()).nsTitc());
            bhjl051a().commarea().dadosEntrada().iTipoItvtPag().set(bhjl051a().commarea().dadosSaida().get(bhjl051a().commarea().qOccursOut()).iTipoItvt());
        }
    }
    
    /**
     * 
     * 2222-ACEDE-MHJJ067A
     * 
     */
    protected void m2222AcedeMhjj067a() {
        log(TraceLevel.Debug, "2222-ACEDE-MHJJ067A");
        bhjl067a().commarea().initialize() ;
        bhjl067a().commarea().dadosEntrada().nCliente().set(bhjl051a().commarea().dadosSaida().get(wsVariaveis().wsOcc()).nCliente());
        bhjl067a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(message.mensagem().headerR().nrElectronico().cPaisIsoaOeOpx());
        bhjl067a().commarea().dadosEntrada().cMnemEgcOpex().set(message.mensagem().headerR().nrElectronico().cMnemEgcOpex());
        log(TraceLevel.Debug, ">>>>>>>>>>>>>> ACESSO MHJJ067A <<<<<<<<<<<<<<");
        log(TraceLevel.Debug, " . BHJL067A-N-CLIENTE          :", bhjl067a().commarea().dadosEntrada().nCliente());
        log(TraceLevel.Debug, " . BHJL067A-C-PAIS-ISOA-OE-OPX :", bhjl067a().commarea().dadosEntrada().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, " . BHJL067A-C-MNEM-EGC-OPEX    :", bhjl067a().commarea().dadosEntrada().cMnemEgcOpex());
        log(TraceLevel.Debug, ">>>>>>>>>>>>>>>>>>>>>>.<<<<<<<<<<<<<<<<<<<<<<");
        bhjp5067AcedeMhjj067a() ;
        envOut.errosGraves().cTipoErroBbn().set(bhjl067a().commarea().erros().cTipoErroBbn());
        if (bhjl067a().commarea().erros().semErros().isTrue()) {
            wsTabelaTitulares().wsTitulares().getCurrent().wsNmCliAbvdL().set(bhjl067a().commarea().dadosSaida().nmCliAbvd());
            log(TraceLevel.Error, ">>>>>>>>>>> NOME CLIENTE :", bhjl067a().commarea().dadosSaida().nmCliAbvd());
        } else {
            envOut.errosGraves().aAplErr().set(bhjl067a().commarea().erros().aAplErr());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl067a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl067a().commarea().erros().nmTabela());
            msgOut().msg().ase().nsRdclContSt().nsRdclCont1().setTrue() ;
            msgOut().msg().ase().nsRdclContSt().nsRdclContM().set(bhjl067a().commarea().erros().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 3000-FINAL-PROGRAMA
     * 
     */
    protected void m3000FinalPrograma() {
        log(TraceLevel.Debug, "3000-FINAL-PROGRAMA");
        wsVariaveis().wsIndiceOut().set(0);
        wsTabelaTitulares().wsTitulares().resetIndex() ;
        while (wsTabelaTitulares().wsTitulares().index().isLessOrEqual(msgOut().indiceInverso()) && !wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL().isEqual(0) && envOut.errosGraves().semErros().isTrue()) {
            m3100FormataOutput() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m3110FormataResto() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            m3999DisplayDadosOut() ;
        }
        if (envOut.errosGraves().semErros().isTrue()) {
            log(TraceLevel.Error, "BGHM1191-INDICE:", msgOut().indice());
            if (!msgOut().paginaCheia().isTrue()) {
                msgOut().indiceInverso().subtract(msgOut().indice());
                msgOut().diminuiLength().set(multiply(msgOut().indiceInverso(), msgOut().lengthOccur()));
                msgOut().qCterCmptAlig().subtract(msgOut().diminuiLength());
                log(TraceLevel.Debug, "-----------------------------------");
                log(TraceLevel.Debug, "-- F I M  D E  C O N S U L T A  ---");
                log(TraceLevel.Debug, "-----------------------------------");
                envOut.errosGraves().cTipoErroBbn().set(bhtk0002().indErros().fimConsulta());
            }
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        message.mensagem().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        message.mensagem().qCterCmptAlig().set(msgOut().qCterCmptAlig());
        log(TraceLevel.Debug, " _____________________________________ ");
        log(TraceLevel.Debug, " -- BGHM1191-C-PAIS-ISOA-CONT    :", msgOut().msg().ade().scta().cPaisIsoaCont());
        log(TraceLevel.Debug, " -- BGHM1191-C-BANC-CONT         :", msgOut().msg().ade().scta().cBancCont());
        log(TraceLevel.Debug, " -- BGHM1191-C-OE-EGC-CONT       :", msgOut().msg().ade().scta().cOeEgcCont());
        log(TraceLevel.Debug, " -- BGHM1191-NS-RDCL-CONT        :", msgOut().msg().ade().scta().nsRdclCont());
        log(TraceLevel.Debug, " -- BGHM1191-V-CHKD-CONT         :", msgOut().msg().ade().scta().vChkdCont());
        log(TraceLevel.Debug, " -- BGHM1191-C-TIPO-CONT         :", msgOut().msg().ade().scta().cTipoCont());
        log(TraceLevel.Debug, " -- BGHM1191-C-MOED-ISO-SCTA     :", msgOut().msg().ade().scta().cMoedIsoScta());
        log(TraceLevel.Debug, " -- BGHM1191-NS-DEPOSITO         :", msgOut().msg().ade().scta().nsDeposito());
        log(TraceLevel.Debug, " -- BHTL001A-C-TIPO-ERRO-BBN     :", envOut.errosGraves().cTipoErroBbn());
        log(TraceLevel.Debug, " -- BHTL001A-A-APL-ERR           :", envOut.errosGraves().aAplErr());
        log(TraceLevel.Debug, " -- BHTL001A-C-RTNO-EVEN-SWAL    :", envOut.errosGraves().cRtnoEvenSwal());
        log(TraceLevel.Debug, " ------ CAMPOS STATUS -------");
        log(TraceLevel.Debug, " . BGHM1191-C-PAIS-ISOA-CONT-ST  :", msgOut().msg().ase().cPaisIsoaContSt());
        log(TraceLevel.Debug, " . BGHM1191-C-BANC-CONT-ST       :", msgOut().msg().ase().cBancContSt());
        log(TraceLevel.Debug, " . BGHM1191-C-OE-EGC-CONT-ST     :", msgOut().msg().ase().cOeEgcContSt());
        log(TraceLevel.Debug, " . BGHM1191-NS-RDCL-CONT-ST      :", msgOut().msg().ase().nsRdclContSt());
        log(TraceLevel.Debug, " . BGHM1191-V-CHKD-CONT-ST       :", msgOut().msg().ase().vChkdContSt());
        log(TraceLevel.Debug, " . BGHM1191-C-TIPO-CONT-ST       :", msgOut().msg().ase().cTipoContSt());
        log(TraceLevel.Debug, " . BGHM1191-C-MOED-ISO-SCTA-ST   :", msgOut().msg().ase().cMoedIsoSctaSt());
        log(TraceLevel.Debug, " . BGHM1191-NS-DEPOSITO-ST       :", msgOut().msg().ase().nsDepositoSt());
        log(TraceLevel.Debug, " _____________________________________ ");
        exit() ;
    }
    
    /**
     * 
     * 3100-FORMATA-OUTPUT
     * 
     */
    protected void m3100FormataOutput() {
        log(TraceLevel.Debug, "3100-FORMATA-OUTPUT");
        msgOut().indice().add(CON_1);
        msgOut().msg().ade().linha().get(msgOut().indice()).nsItvtL().set(wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL());
        msgOut().msg().ade().linha().get(msgOut().indice()).iTipoItvtL().set(wsTabelaTitulares().wsTitulares().getCurrent().wsITipoItvtL());
        msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL());
        msgOut().msg().ade().linha().get(msgOut().indice()).nmCliAbvdL().set(wsTabelaTitulares().wsTitulares().getCurrent().wsNmCliAbvdL());
        msgOut().msg().ade().linha().get(msgOut().indice()).zIniItvtL().set(wsTabelaTitulares().wsTitulares().getCurrent().wsZIniItvtL());
        msgOut().msg().ade().linha().get(msgOut().indice()).zFimItvtL().set(wsTabelaTitulares().wsTitulares().getCurrent().wsZFimItvtL());
        msgOut().msg().ade().linha().get(msgOut().indice()).iTitcExsGarL().set(wsTabelaTitulares().wsTitulares().getCurrent().wsITitcExsGarL());
        if (wsTabelaTitulares().wsTitulares().getCurrent().wsITitcExsGarL().isEqual("N")) {
            swSwitchs().swTitNaoAbrangidos().setTrue() ;
        }
        if (msgOut().msg().ade().solicitador().nsIntSol().isEqual(wsTabelaTitulares().wsTitulares().getCurrent().wsNsTitcL())) {
            msgOut().msg().ade().solicitador().nClienteSol().set(wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL());
            msgOut().msg().ade().solicitador().nmCliAbvSol().set(wsTabelaTitulares().wsTitulares().getCurrent().wsNmCliAbvdL());
        }
        log(TraceLevel.Debug, "»»»»»»»»»»»»»»»»»»»» ", msgOut().indice(), " ««««««««««««««««««««");
        log(TraceLevel.Debug, " » BGHM1191-NS-ITVT-L         :", msgOut().msg().ade().linha().get(msgOut().indice()).nsItvtL());
        log(TraceLevel.Debug, " » BGHM1191-I-TIPO-ITVT-L     :", msgOut().msg().ade().linha().get(msgOut().indice()).iTipoItvtL());
        log(TraceLevel.Debug, " » BGHM1191-N-CLIENTE-L       :", msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL());
        log(TraceLevel.Debug, " » BGHM1191-NM-CLI-ABVD-L     :", msgOut().msg().ade().linha().get(msgOut().indice()).nmCliAbvdL());
        log(TraceLevel.Debug, " » BGHM1191-Z-INI-ITVT-L      :", msgOut().msg().ade().linha().get(msgOut().indice()).zIniItvtL());
        log(TraceLevel.Debug, " » BGHM1191-Z-FIM-ITVT-L      :", msgOut().msg().ade().linha().get(msgOut().indice()).zFimItvtL());
        log(TraceLevel.Debug, " » BGHM1191-I-TITC-EXS-GAR-L  :", msgOut().msg().ade().linha().get(msgOut().indice()).iTitcExsGarL());
        log(TraceLevel.Debug, "»»»»»»»»»»»»»»»»»»»»««««««««««««««««««««");
        wsTabelaTitulares().wsTitulares().incIndex() ;
    }
    
    /**
     * 
     * 3110-FORMATA-RESTO
     * 
     */
    protected void m3110FormataResto() {
        log(TraceLevel.Trace, "3110-FORMATA-RESTO");
        if (swSwitchs().swTitNaoAbrangidos().isTrue()) {
            msgOut().msg().ade().iTodosTitAbgd().set("N");
        }
        if (swSwitchs().swExisteMarcacaoAtiva().isTrue() && 
            msgOut().msg().ade().solicitador().nmCliAbvSol().isEmpty()) {
            /**
             * -- OBTEM NOME DO SOLICITADOR QUE NAO E TITULAR
             * -- PARA O CASO DOS MENORES OU EMPRESA, O SOLICITADOR
             * -- TEM DE SER UM AUTORIZADO, LOGO, AINDA NAO FOI OBTIDO
             */
            wsTabelaTitularesTgh201().wsTitularesMhjj086a().resetIndex() ;
            m3110ObtemNmSol() ;
            wsTabelaTitularesTgh201().wsTitularesMhjj086a().resetIndex() ;
            while (wsTabelaTitularesTgh201().wsTitularesMhjj086a().index().isLessOrEqual(999)) {
                if (wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNsTitcMhj86().isEqual(hv20001Movexgdep().movexgdep().nsTitcExtsGart())) {
                    log(TraceLevel.Debug, "»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
                    log(TraceLevel.Debug, " » CLIENTE            :", wsTabelaTitulares().wsTitulares().getCurrent().wsNClienteL());
                    log(TraceLevel.Debug, "«««««««««««««««««««««««««««««««««");
                    msgOut().msg().ade().solicitador().nClienteSol().set(wsTabelaTitularesTgh201().wsTitularesMhjj086a().getCurrent().wsNClienteMhj86());
                    m2215AcedeMhjj067a() ;
                    if (envOut.errosGraves().semErros().isTrue()) {
                        msgOut().msg().ade().solicitador().nmCliAbvSol().set(bhjl067a().commarea().dadosSaida().nmCliAbvd());
                    }
                    break;
                }
                wsTabelaTitularesTgh201().wsTitularesMhjj086a().incIndex() ;
            }
            if (wsTabelaTitularesTgh201().wsTitularesMhjj086a().atEnd()) {
                log(TraceLevel.Error, " CLIENTE SOLICITADOR C SEQ INTERVENCAO ");
                log(TraceLevel.Error, hv20001Movexgdep().movexgdep().nsTitcExtsGart(), " INEXISTENTE]");
            }
        }
        if (envOut.errosGraves().semErros().isTrue() && message.mensagem().headerR().transaccao().anulacao().isTrue()) {
            envOut.errosGraves().fimConsulta().setTrue() ;
        }
    }
    
    /**
     * 
     * 3110-OBTEM-NM-SOL
     * 
     */
    protected void m3110ObtemNmSol() {
        log(TraceLevel.Trace, "3110-OBTEM-NM-SOL");
        if (envOut.errosGraves().semErros().isTrue()) {
            wsVariaveis().wsITipoItvtAux().set(hv20001Movexgdep().movexgdep().iTipItvtExsGar());
            m2214ObtemDadosCli() ;
        }
    }
    
    /**
     * 
     * 3999-DISPLAY-DADOS-OUT
     * 
     */
    protected void m3999DisplayDadosOut() {
        log(TraceLevel.Debug, "3999-DISPLAY-DADOS-OUT");
        log(TraceLevel.Debug, " ---------------- O U T P U T ---------------- ");
        log(TraceLevel.Debug, "        ------  S U B C O N T A ------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-C-PAIS-ISOA-CONT          :", msgOut().msg().ade().scta().cPaisIsoaCont());
        log(TraceLevel.Debug, " ------> BGHM1191-C-BANC-CONT               :", msgOut().msg().ade().scta().cBancCont());
        log(TraceLevel.Debug, " ------> BGHM1191-C-OE-EGC-CONT             :", msgOut().msg().ade().scta().cOeEgcCont());
        log(TraceLevel.Debug, " ------> BGHM1191-NS-RDCL-CONT              :", msgOut().msg().ade().scta().nsRdclCont());
        log(TraceLevel.Debug, " ------> BGHM1191-V-CHKD-CONT               :", msgOut().msg().ade().scta().vChkdCont());
        log(TraceLevel.Debug, " ------> BGHM1191-C-TIPO-CONT               :", msgOut().msg().ade().scta().cTipoCont());
        log(TraceLevel.Debug, " ------> BGHM1191-C-MOED-ISO-SCTA           :", msgOut().msg().ade().scta().cMoedIsoScta());
        log(TraceLevel.Debug, " ------> BGHM1191-NS-DEPOSITO               :", msgOut().msg().ade().scta().nsDeposito());
        log(TraceLevel.Debug, "    ------  N S  M O V I M E N T O ------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-NS-MOVIMENTO              :", msgOut().msg().ade().nsMovimento());
        log(TraceLevel.Debug, "    ------  E X T  G A R A N T I A ------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-Z-MOVIMENTO               :", msgOut().msg().ade().dadosGarantia().zMovimento());
        log(TraceLevel.Debug, " ------> BGHM1191-X-REF-MOV                 :", msgOut().msg().ade().dadosGarantia().xRefMov());
        log(TraceLevel.Debug, " ------> BGHM1191-M-MONTANTE-MOV            :", msgOut().msg().ade().dadosGarantia().mMontanteMov());
        log(TraceLevel.Debug, " ------> BGHM1191-C-MOED-MOV                :", msgOut().msg().ade().dadosGarantia().cMoedMov());
        log(TraceLevel.Debug, " ------> BGHM1191-M-MONTANTE-EXT            :", msgOut().msg().ade().dadosGarantia().mMontanteExt());
        log(TraceLevel.Debug, " ------> BGHM1191-C-MOED-EXT                :", msgOut().msg().ade().dadosGarantia().cMoedExt());
        log(TraceLevel.Debug, " ------> BGHM1191-C-CAR-EXT                 :", msgOut().msg().ade().dadosGarantia().cCarExt());
        log(TraceLevel.Debug, " ------> BGHM1191-Z-INI-GARANTIA            :", msgOut().msg().ade().dadosGarantia().zIniGarantia());
        log(TraceLevel.Debug, " ------> BGHM1191-Z-FIM-GARANTIA            :", msgOut().msg().ade().dadosGarantia().zFimGarantia());
        log(TraceLevel.Debug, "    ------  S O L I C I T A D O R ------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-NS-INT-SOL                :", msgOut().msg().ade().solicitador().nsIntSol());
        log(TraceLevel.Debug, " ------> BGHM1191-N-CLIENTE-SOL             :", msgOut().msg().ade().solicitador().nClienteSol());
        log(TraceLevel.Debug, " ------> BGHM1191-NM-CLI-ABV-SOL            :", msgOut().msg().ade().solicitador().nmCliAbvSol());
        log(TraceLevel.Debug, " ------> BGHM1191-C-TIPO-SOL                :", msgOut().msg().ade().solicitador().cTipoSol());
        log(TraceLevel.Debug, "       ------  R E G I S T O  ------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-N-UTL-INS-GT              :", msgOut().msg().ade().registo().nUtlInsGt());
        log(TraceLevel.Debug, " ------> BGHM1191-Z-INS-GT                  :", msgOut().msg().ade().registo().zInsGt());
        log(TraceLevel.Debug, " ------> BGHM1191-H-INS-GT                  :", msgOut().msg().ade().registo().hInsGt());
        log(TraceLevel.Debug, "     ------  U L T I M A  A L T ------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-N-UTL-ULT-ALT             :", msgOut().msg().ade().ultAlteracao().nUtlUltAlt());
        log(TraceLevel.Debug, " ------> BGHM1191-Z-ULT-ALT                 :", msgOut().msg().ade().ultAlteracao().zUltAlt());
        log(TraceLevel.Debug, " ------> BGHM1191-H-ULT-ALT                 :", msgOut().msg().ade().ultAlteracao().hUltAlt());
        log(TraceLevel.Debug, "     ------  T O D O S  T I T ------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-I-TODOS-TIT-ABGD          :", msgOut().msg().ade().iTodosTitAbgd());
        log(TraceLevel.Debug, " ------  C H V  C O N T I N U A C A O------ ");
        log(TraceLevel.Debug, " ------> BGHM1191-N-CLIENTE-PG              :", msgOut().msg().ade().chaveContinuacao().nClientePg());
        log(TraceLevel.Debug, " ------> BGHM1191-I-TIPO-ITVT-PG            :", msgOut().msg().ade().chaveContinuacao().iTipoItvtPg());
        log(TraceLevel.Debug, " ------> BGHM1191-NS-TITC-PG                :", msgOut().msg().ade().chaveContinuacao().nsTitcPg());
        log(TraceLevel.Debug, " ---------------------- . ---------------------- ");
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
        
        @Data(size=3)
        IInt wsIndCli() ;
        
        @Data(size=2)
        IInt wsOcc() ;
        
        @Data(size=2)
        IInt wsIndLista() ;
        
        @Data(size=2)
        IInt wsIndiceOut() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsITipoItvtAux() ;
        
        /**
         * @return instancia da classe local WsNContrato
         */
        @Data
        WsNContrato wsNContrato() ;
        
        
        public interface WsNContrato extends IDataStruct {
            
            @Data(size=3)
            IString wsCPaisIsoaCont() ;
            
            @Data(size=4)
            IInt wsCBancCont() ;
            
            @Data(size=4)
            IInt wsCOeEgcCont() ;
            
            @Data(size=7)
            IInt wsNsRdclCont() ;
            
            @Data(size=1)
            IInt wsVChkdCont() ;
            
            @Data(size=3)
            IInt wsCTipoCont() ;
            
        }
    }
    
    /**
     * 
     * TABELA INTERNA
     * 
     * @version 2.0
     * 
     */
    public interface WsTabelaTitulares extends IDataStruct {
        
        /**
         * @return instancia da classe local WsTitulares
         */
        @Data(length=75)
        IArray<WsTitulares> wsTitulares() ;
        
        
        public interface WsTitulares extends IDataStruct {
            
            
            @Data(size=1)
            IString wsIAcczMntzListaL() ;
            
            @Data(size=3, compression=COMP3)
            IInt wsNsTitcL() ;
            
            @Data(size=3, compression=COMP3)
            IInt wsITipoItvtL() ;
            
            @Data(size=10, compression=COMP3)
            ILong wsNClienteL() ;
            
            @Data(size=35)
            IString wsNmCliAbvdL() ;
            
            @Data(size=10)
            IString wsZIniItvtL() ;
            
            @Data(size=10)
            IString wsZFimItvtL() ;
            
            @Data(size=1)
            IString wsITitcExsGarL() ;
            
        }
    }
    
    /**
     * 
     * TABELA INTERNA PARA OBTENCAO DOS DADOS DOS TITULARES GUARDADOS
     * NA TGH00201
     * 
     * @version 2.0
     * 
     */
    public interface WsTabelaTitularesTgh201 extends IDataStruct {
        
        /**
         * @return instancia da classe local WsTitularesMhjj086a
         */
        @Data(length=999)
        IArray<WsTitularesMhjj086a> wsTitularesMhjj086a() ;
        
        
        public interface WsTitularesMhjj086a extends IDataStruct {
            
            
            @Data(size=3, compression=COMP3)
            IInt wsNsTitcMhj86() ;
            
            @Data(size=10, compression=COMP3)
            ILong wsNClienteMhj86() ;
            
            @Data(size=10)
            IString wsZIniItvtMhj86() ;
            
            @Data(size=10)
            IString wsZFimItvtMhj86() ;
            
        }
    }
    
    /**
     * 
     * DEFINICAO DE TABELAS DB2
     * TABELA DE MOVIMENTOS ABRANGIDOS PELA EXTENSAO DE GARANTIA DE
     * DEPOSITOS
     * TABELA DE TITULARES DA CONTA ABRANGIDOS PELA EXTENSAO DE
     * GARANTIA DE DEPOSITOS NUM DETERMINADO MOVIMENTO.
     * DEFINICAO DA SQL COMMUNICATION AREA
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitchs extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString swAbrangidos() ;
        @Data
        @Condition("N")
        ICondition swTitNaoAbrangidos() ;
        @Data
        @Condition("S")
        ICondition swTitAbrangidos() ;
        
        
        @Data(size=1, value=" ")
        IString swMarcacaoExtensao() ;
        @Data
        @Condition("S")
        ICondition swExisteMarcacaoAtiva() ;
        @Data
        @Condition("N")
        ICondition swNaoExisteMarcacao() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20001() ;
        @Data
        @Condition("100")
        ICondition swVgh20001Notfnd() ;
        @Data
        @Condition("0")
        ICondition swVgh20001Ok() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh20101() ;
        @Data
        @Condition("100")
        ICondition swVgh20101Notfnd() ;
        @Data
        @Condition("0")
        ICondition swVgh20101Ok() ;
        
        
    }
    
}
