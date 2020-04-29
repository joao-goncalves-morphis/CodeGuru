package cgd.gh.online;

import morphis.framework.server.controller.PersistenceCode ;
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
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.work.* ;
import cgd.gh.structures.work.Bghwk141.WsDocCliLinha;
import cgd.gh.persistence.database.* ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdHeaderV2 ;
import cgd.framework.envelope.CgdMessageV2 ;
import cgd.framework.envelope.CgdFooterV2 ;
import cgd.gh.structures.messages.Bghm1140 ;
import cgd.gh.structures.messages.Bghm1141 ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hg.structures.link.Bhgl052a ;
import cgd.hj.structures.link.Bhjl027a ;
import cgd.hj.structures.link.Bhjl006a ;
import cgd.hj.structures.link.Bhjl031a ;
import cgd.hj.structures.link.Bhjl707a ;
import cgd.hj.structures.link.Bhjl939a ;
import cgd.hj.structures.link.Bhjl470a ;
import cgd.ho.structures.link.Bhol708a ;
import cgd.ho.structures.link.Bhol710a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.gh.common.constants.Bghk0001 ;
import cgd.hj.common.constants.Bhjk0001 ;
import cgd.hj.common.constants.Bhjk0002 ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.gh.structures.link.Bghl300a ;
import cgd.he.structures.link.Bhel100a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj052a ;
import cgd.hj.routines.Mhjj027a ;
import cgd.hj.routines.Mhjj031a ;
import cgd.hj.routines.Mhjs006a ;
import cgd.hj.routines.Mhjj707a ;
import cgd.hj.routines.Mhjj939a ;
import cgd.hj.routines.Mhjj470a ;
import cgd.ho.routines.Mhoj708a ;
import cgd.ho.routines.Mhoj710a ;
import cgd.gh.routines.Mghj300a ;
import cgd.he.routines.Mhej100a ;
import cgd.dr.routines.Mdrj402a ;


/**
 * 
 * CURSORES
 * *-- CURSOR POR CONTA ASCENDENTE  --CRS1A
 * *-- CHAVE DE CONTINUACAO - ASC
 * AND (    Z_MOVIMENTO     > :VGH13001-Z-MOVIMENTO
 * OR (    Z_MOVIMENTO     = :VGH13001-Z-MOVIMENTO
 * AND Z_PROCESSAMENTO > :VGH13001-Z-PROCESSAMENTO )
 * AND Z_PROCESSAMENTO = :VGH13001-Z-PROCESSAMENTO
 * AND C_MNEM_EGC_OPEX > :VGH13001-C-MNEM-EGC-OPEX )
 * AND C_MNEM_EGC_OPEX = :VGH13001-C-MNEM-EGC-OPEX
 * AND C_PAIS_ISOA_OE_OPX >
 * :VGH13001-C-PAIS-ISOA-OE-OPX)
 * AND C_PAIS_ISOA_OE_OPX =
 * :VGH13001-C-PAIS-ISOA-OE-OPX
 * AND C_OE_EGC_OPEX   > :VGH13001-C-OE-EGC-OPEX   )
 * AND C_OE_EGC_OPEX   = :VGH13001-C-OE-EGC-OPEX
 * AND C_USERID        > :VGH13001-C-USERID        )
 * AND C_USERID        = :VGH13001-C-USERID
 * AND N_JOUR_BBN     >= :VGH13001-N-JOUR-BBN     ))
 * ORDER BY Z_MOVIMENTO
 * , Z_PROCESSAMENTO
 * , C_MNEM_EGC_OPEX
 * , C_PAIS_ISOA_OE_OPX
 * , C_OE_EGC_OPEX
 * , C_USERID
 * , N_JOUR_BBN
 * END-EXEC.
 * *-- CURSOR POR CONTA DESCENDENTE  --CRS1D
 * *-- CHAVE DE CONTINUACAO - DESC
 * AND (    Z_MOVIMENTO     < :VGH13001-Z-MOVIMENTO
 * AND Z_PROCESSAMENTO < :VGH13001-Z-PROCESSAMENTO )
 * AND C_MNEM_EGC_OPEX < :VGH13001-C-MNEM-EGC-OPEX )
 * AND C_PAIS_ISOA_OE_OPX <
 * AND C_OE_EGC_OPEX   < :VGH13001-C-OE-EGC-OPEX   )
 * AND C_USERID        < :VGH13001-C-USERID        )
 * AND N_JOUR_BBN     <= :VGH13001-N-JOUR-BBN     ))
 * ORDER BY Z_MOVIMENTO        DESC
 * , Z_PROCESSAMENTO    DESC
 * , C_MNEM_EGC_OPEX    DESC
 * , C_PAIS_ISOA_OE_OPX DESC
 * , C_OE_EGC_OPEX      DESC
 * , C_USERID           DESC
 * , N_JOUR_BBN         DESC
 * *-- CURSOR POR CONTA ASCENDENTE  --CRS1A-CHEQUE
 * *-- CURSOR POR CONTA DESCENDENTE  --CRS1D-CHEQUE
 * *-- CURSOR POR CLIENTE ASCENDENTE  --CRS2A
 * AND (   Z_MOVIMENTO      > :VGH13001-Z-MOVIMENTO
 * OR (   Z_MOVIMENTO      = :VGH13001-Z-MOVIMENTO
 * AND C_PAIS_ISOA_CONT > :VGH13001-C-PAIS-ISOA-CONT)
 * AND C_PAIS_ISOA_CONT = :VGH13001-C-PAIS-ISOA-CONT
 * AND C_BANC_CONT      > :VGH13001-C-BANC-CONT     )
 * AND C_BANC_CONT      = :VGH13001-C-BANC-CONT
 * AND C_OE_EGC_CONT    > :VGH13001-C-OE-EGC-CONT   )
 * AND C_OE_EGC_CONT    = :VGH13001-C-OE-EGC-CONT
 * AND NS_RDCL_CONT     > :VGH13001-NS-RDCL-CONT    )
 * AND NS_RDCL_CONT     = :VGH13001-NS-RDCL-CONT
 * AND V_CHKD_CONT      > :VGH13001-V-CHKD-CONT     )
 * AND V_CHKD_CONT      = :VGH13001-V-CHKD-CONT
 * AND C_TIPO_CONT      > :VGH13001-C-TIPO-CONT     )
 * AND C_TIPO_CONT      = :VGH13001-C-TIPO-CONT
 * AND C_MOED_ISO_SCTA  > :VGH13001-C-MOED-ISO-SCTA )
 * AND C_MOED_ISO_SCTA  = :VGH13001-C-MOED-ISO-SCTA
 * AND NS_DEPOSITO      > :VGH13001-NS-DEPOSITO     )
 * AND NS_DEPOSITO      = :VGH13001-NS-DEPOSITO
 * AND Z_PROCESSAMENTO  > :VGH13001-Z-PROCESSAMENTO )
 * AND Z_PROCESSAMENTO  = :VGH13001-Z-PROCESSAMENTO
 * AND C_MNEM_EGC_OPEX  > :VGH13001-C-MNEM-EGC-OPEX )
 * AND C_MNEM_EGC_OPEX  = :VGH13001-C-MNEM-EGC-OPEX
 * AND C_OE_EGC_OPEX    > :VGH13001-C-OE-EGC-OPEX   )
 * AND C_OE_EGC_OPEX    = :VGH13001-C-OE-EGC-OPEX
 * AND C_USERID         > :VGH13001-C-USERID        )
 * AND C_USERID         = :VGH13001-C-USERID
 * AND N_JOUR_BBN      >= :VGH13001-N-JOUR-BBN     ))
 * , C_PAIS_ISOA_CONT
 * , C_BANC_CONT
 * , C_OE_EGC_CONT
 * , NS_RDCL_CONT
 * , V_CHKD_CONT
 * , C_TIPO_CONT
 * , C_MOED_ISO_SCTA
 * , NS_DEPOSITO
 * *-- CURSOR POR CLIENTE DESCENDENTE  --CRS2D
 * AND (   Z_MOVIMENTO      < :VGH13001-Z-MOVIMENTO
 * AND C_PAIS_ISOA_CONT < :VGH13001-C-PAIS-ISOA-CONT)
 * AND C_BANC_CONT      < :VGH13001-C-BANC-CONT     )
 * AND C_OE_EGC_CONT    < :VGH13001-C-OE-EGC-CONT   )
 * AND NS_RDCL_CONT     < :VGH13001-NS-RDCL-CONT    )
 * AND V_CHKD_CONT      < :VGH13001-V-CHKD-CONT     )
 * AND C_TIPO_CONT      < :VGH13001-C-TIPO-CONT     )
 * AND C_MOED_ISO_SCTA  < :VGH13001-C-MOED-ISO-SCTA )
 * AND NS_DEPOSITO      < :VGH13001-NS-DEPOSITO     )
 * AND Z_PROCESSAMENTO  < :VGH13001-Z-PROCESSAMENTO )
 * AND C_MNEM_EGC_OPEX  < :VGH13001-C-MNEM-EGC-OPEX )
 * AND C_OE_EGC_OPEX    < :VGH13001-C-OE-EGC-OPEX   )
 * AND C_USERID         < :VGH13001-C-USERID        )
 * AND N_JOUR_BBN      <= :VGH13001-N-JOUR-BBN     ))
 * ORDER BY Z_MOVIMENTO         DESC
 * , C_PAIS_ISOA_CONT    DESC
 * , C_BANC_CONT         DESC
 * , C_OE_EGC_CONT       DESC
 * , NS_RDCL_CONT        DESC
 * , V_CHKD_CONT         DESC
 * , C_TIPO_CONT         DESC
 * , C_MOED_ISO_SCTA     DESC
 * , NS_DEPOSITO         DESC
 * , Z_PROCESSAMENTO     DESC
 * , C_MNEM_EGC_OPEX     DESC
 * , C_PAIS_ISOA_OE_OPX  DESC
 * , C_OE_EGC_OPEX       DESC
 * , C_USERID            DESC
 * , N_JOUR_BBN          DESC
 * *-- CURSOR POR DOCUMENTO ASCENDENTE  --CRS3A
 * *-- CURSOR POR DOCUMENTO DESCENDENTE  --CRS3D
 * *-- CURSOR POR NOME ASCENDENTE  --CRS4A
 * *-- CURSOR POR NOME DESCENDENTE  --CRS4D
 * , C_PAIS_ISOA_CONT   DESC
 * , C_BANC_CONT        DESC
 * , C_OE_EGC_CONT      DESC
 * , NS_RDCL_CONT       DESC
 * , V_CHKD_CONT        DESC
 * , C_TIPO_CONT        DESC
 * , C_MOED_ISO_SCTA    DESC
 * , NS_DEPOSITO        DESC
 * *-- CURSOR POR ORDEM TRANS. ASCENDENTE  --CRS5A
 * *-- CURSOR POR ORDEM TRANS. DESCENDENTE  --CRS5D
 * *-- CURSOR POR MONTANTE ASCENDENTE  --CRS6A
 * *-- CURSOR POR MONTANTE DESCENDENTE  --CRS6D
 * WORKING-STORAGE SECTION
 * PROGRAMA   : PGHS141A.
 * APLICACAO  : GH - GESTAO DE HISTORICO
 * PROCESSO   : GH1488 - TERC - 1ª FASE - TRANSAÇÕES ON-LINE
 * FUNCAO     : CONSULTA EM LISTA DE MOVIMENTOS DE DEPOSITANTE
 * TIPO       : ONLINE COM DB2
 * LOG DE ALTERACOES
 * *PROC.GIP¨   DATA   ¨UTILIZ.¨ OBSERVACOES
 * GH1488 ¨2014-07-22¨DACT480¨ CRIACAO DO PROGRAMA
 * GH1692 "2015-03-04"ACT0649" TERC FASE 3 - TRANSACOES OCASIONAIS*
 * *PASS2972 !2018-09-20!E003881! FORMATACAO DA DATA DOS DOCUMENTOS
 * VITALICIOS COM 2399-12-31 EM VEZ
 * DE 9999-12-31
 * *PASS4497 !2019-10-17!ACCENTU! UCO 2.7 - LEI N.º 83  OSI3656
 * E N V I R O N M E N T    D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghs141a extends CgdGhBaseOnline<Pghs141a.EnvelopeIn, Pghs141a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bghm1140
     */
    public abstract Bghm1140 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bghm1141
     */
    public abstract Bghm1141 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm1140.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV2 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV2.Mensagem {
            @Data
            Bghm1141.Msg msgOut() ;
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
     * @return instancia da classe Vwsdghps13001Movdep
     */
    @Data
    protected abstract Vwsdghps13001Movdep hv13001Movdep() ;
    
    
    /**
     * Handled Routines
     */
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
     * @return instancia da classe Mhjj027a
     */
    @Data
    protected abstract Mhjj027a hrMhjj027a() ;
    
    /**
     * @return instancia da classe Mhjj031a
     */
    @Data
    protected abstract Mhjj031a hrMhjj031a() ;
    
    /**
     * @return instancia da classe Mhjs006a
     */
    @Data
    protected abstract Mhjs006a hrMhjs006a() ;
    
    /**
     * @return instancia da classe Mhjj707a
     */
    @Data
    protected abstract Mhjj707a hrMhjj707a() ;
    
    /**
     * @return instancia da classe Mhjj939a
     */
    @Data
    protected abstract Mhjj939a hrMhjj939a() ;
    
    /**
     * @return instancia da classe Mhjj470a
     */
    @Data
    protected abstract Mhjj470a hrMhjj470a() ;
    
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
     * @return instancia da classe Mghj300a
     */
    @Data
    protected abstract Mghj300a hrMghj300a() ;
    
    /**
     * @return instancia da classe Mhej100a
     */
    @Data
    protected abstract Mhej100a hrMhej100a() ;
    
    /**
     * @return instancia da classe Mdrj402a
     */
    @Data
    protected abstract Mdrj402a hrMdrj402a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhgl052a
     */
    @Data
    protected abstract Bhgl052a bhgl052a() ;
    
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
     * @return instancia da classe Bhjl031a
     */
    @Data
    protected abstract Bhjl031a bhjl031a() ;
    
    /**
     * @return instancia da classe Bhjl707a
     */
    @Data
    protected abstract Bhjl707a bhjl707a() ;
    
    /**
     * @return instancia da classe Bhjl939a
     */
    @Data
    protected abstract Bhjl939a bhjl939a() ;
    
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
    
    /**
     * @return instancia da classe Bghl300a
     */
    @Data
    protected abstract Bghl300a bghl300a() ;
    
    /**
     * @return instancia da classe Bhel100a
     */
    @Data
    protected abstract Bhel100a bhel100a() ;
    
    protected static final String CON_NOME_PROGRAMA = "PGHS141A" ;
    
    protected static final String CON_COD_APLICACAO = "GH" ;
    
    protected static final String CON_VGH13001 = "VGH13001" ;
    
    protected static final String CON_CSLT_CONTA = "C" ;
    
    protected static final String CON_CSLT_CLIENTE = "L" ;
    
    protected static final String CON_CSLT_DOCUM = "D" ;
    
    protected static final String CON_CSLT_NOME = "N" ;
    
    protected static final String CON_CSLT_ORDEM = "O" ;
    
    protected static final String CON_CSLT_MONT = "M" ;
    
    protected static final String CON_ASCENDENTE = "A" ;
    
    protected static final String CON_DESCENDENTE = "D" ;
    
    protected static final String CON_DEBITO = "D" ;
    
    protected static final String CON_CREDITO = "C" ;
    
    protected static final String CON_AMBOS = "A" ;
    
    protected static final String CON_SIM = "S" ;
    
    protected static final String CON_NAO = "N" ;
    
    protected static final String CON_OS_DOIS = "A" ;
    
    /**
     * *---TIPO DE INTERVENIENTE---
     */
    protected static final String CON_TODOS = "N" ;
    
    protected static final String CON_PROPIO = "P" ;
    
    protected static final String CON_TERCEIROS = "T" ;
    
    protected static final String CON_MANDATARIO = "M" ;
    
    protected static final String CON_DEP_EXPRESSO = "E" ;
    
    protected static final String CON_BENE_CHQ = "B" ;
    
    protected static final String CON_ORDENANTE_ORD = "O" ;
    
    protected static final String CON_BENEFICIARIO_ORD = "F" ;
    
    protected static final String CON_DATA_MIN = "0001-01-01" ;
    
    protected static final String CON_DATA_MAX = "9999-12-31" ;
    
    protected static final int CON_1N = 1 ;
    
    protected static final int CON_3N = 3 ;
    
    protected static final int CON_14N = 14 ;
    
    protected static final int CON_100N = 100 ;
    
    protected static final int CON_250N = 250 ;
    
    protected static final String CON_VARIOS_CLI_CGD = "V" ;
    
    /**
     * *---TIPO DE OPERACAO NA CONTA
     */
    protected static final String CON_ENTREGA = "E" ;
    
    protected static final String CON_LEVANTAMENTO = "L" ;
    
    protected static final String CON_CAMBIO = "C" ;
    
    protected static final String CON_TROCO_DESTROCO = "D" ;
    
    protected static final String CON_TRANSFERENCIAS = "T" ;
    
    protected static final String CON_ORDENS_EMITIDAS = "S" ;
    
    protected static final String CON_ORDENS_RECEBIDAS = "R" ;
    
    protected static final String CON_OCASIONAIS = "O" ;
    
    protected static final String CON_ATM_CGD = "- ATM CGD " ;
    
    protected static final String CON_MDRJ402A = "MDRJ402A" ;
    
    /**
     * *---CONTA PARA CHEQUE BANCARIO
     */
    protected static final String CON_C_PAIS_CHQ_BANC = "PT" ;
    
    protected static final int CON_C_BANC_CHQ_BANC = 35 ;
    
    protected static final int CON_C_OE_CHQ_BANC = 9318 ;
    
    protected static final int CON_NS_RDCL_CHQ_BANC = 350062 ;
    
    protected static final int CON_V_CHKD_CHQ_BANC = 4 ;
    
    protected static final int CON_C_TIPO_CHQ_BANC = 98 ;
    
    protected static final String CON_C_MOED_CHQ_BANC = "EUR" ;
    
    protected static final int CON_NS_DEP_CHQ_BAN = 0 ;
    
    /**
     * *---CONTA PARA CARTA CHEQUE
     */
    protected static final String CON_C_PAIS_CARTA_CHQ = "PT" ;
    
    protected static final int CON_C_BANC_CARTA_CHQ = 35 ;
    
    protected static final int CON_C_OE_CARTA_CHQ = 9310 ;
    
    protected static final int CON_NS_RDCL_CARTA_CHQ = 350064 ;
    
    protected static final int CON_V_CHKD_CARTA_CHQ = 0 ;
    
    protected static final int CON_C_TIPO_CARTA_CHQ = 97 ;
    
    protected static final String CON_C_MOED_CARTA_CHQ = "EUR" ;
    
    protected static final int CON_NS_DEP_CARTA_CHQ = 0 ;
    
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
     * TABELA INTERNAS
     * @return instancia da classe local WsTabelasInternas
     */
    @Data
    protected abstract WsTabelasInternas wsTabelasInternas() ;
    
    /**
     * VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * @return instancia da classe local SwSwitchs
     */
    @Data
    protected abstract SwSwitchs swSwitchs() ;
    
    
    
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
     * BHJP5027-ACESSO AO MODULO QUE OBTEM E VALIDA CLIENTE
     * POR DOCUMENTO DE IDENTIFICACAO (MHJJ027A)
     * 
     */
    protected void bhjp5027AcedeMhjj027a() {
    }
    
    /**
     * 
     * BHJP5031-ACESSO AO MODULO DE OBTENCAO DOS DOCUMENTOS
     * DE IDENTIFICACAO DO CLIENTE (MHJJ031A)
     * 
     */
    protected void bhjp5031AcedeMhjj031a() {
        hrMhjj031a().run() ;
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
     * BHJP0707-ACESSO AO MODULO DE OBTENCAO DOS DOCUMENTOS
     * DE IDENTIFICACAO DO CLIENTE (MHJJ707A)
     * 
     */
    protected void bhjp0707AcedeMhjj707a() {
    }
    
    /**
     * 
     * BHJP5939-ACESSO AO MODULO QUE DEVOLVE AS RELACOES
     * ACTIVAS DE UMA CONTA (MHJJ939A)
     * 
     */
    protected void bhjp5939AcedeMhjj939a() {
        hrMhjj939a().run() ;
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
     * BHOP0708 - COPY PROCEDURE DE CHAMADA A ROTINA DE VALIDACAO DE
     * CONTA E SITUACAO CONTRA ACCAO
     * 
     */
    protected void bhop0708ValConta() {
    }
    
    /**
     * 
     * BHOP0710 - COPY PROCEDURE DE CHAMADA A ROTINA DE VALIDACAO
     * DE SUBCONTA E SITUACAO CONTRA ACCAO
     * 
     */
    protected void bhop0710ValSubconta() {
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MGHJ300A - VERIFICA ESTADO ORDENS EMITIDAS OU RECEBIDAS
     * 
     */
    protected void bghp1300VerifEstadOrd() {
        hrMghj300a().run() ;
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MHEJ100A - MANUTENCAO DA TABELA DE DADOS DE NAO CLIENTES
     * 
     */
    protected void bhep5100TabNaoClientes() {
        hrMhej100a().run() ;
    }
    
    /**
     * 
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "***** INICIO * GHII * MVPHII * INICIO ********");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        if (messageV2.mensagem().semErros().isTrue()) {
            m2000ProcessoPrograma() ;
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
        wsVariaveis().wsDataDb2().set( getDBDate() ) ;
        swSwitchs().initialize() ;
        wsTabelasInternas().initialize() ;
        wsTabelasInternas().wsDocumentosCliente().initialize() ;
        wsVariaveis().initialize() ;
        hv13001Movdep().movdep().initialize() ;
        msgOut().msg().initialize() ;
        wsTabelasInternas().wsDocCliLinha().initialize() ;
        hrMhgj030a().bhgl030a().commarea().initialize() ;
        bhgl052a().commarea().initialize() ;
        bhjl006a().commarea().initialize() ;
        bhjl027a().commarea().initialize() ;
        bhjl031a().commarea().initialize() ;
        bhjl470a().commarea().initialize() ;
        bhjl707a().commarea().initialize() ;
        bhjl939a().commarea().initialize() ;
        bhol708a().commarea().initialize() ;
        bhol710a().commarea().initialize() ;
        msgIn().msg().set(envIn.mensagem().msgIn()) ;
        msgOut().msg().ase().set(msgIn().msg().ase());
        msgOut().msg().ade().set(msgIn().msg().ade());
        msgOut().indice().set(CON_1N);
        while (msgOut().indice().isLessOrEqual(10)) {
            /**
             * PASSIVAS 4497 (INICIO)
             */
            msgIn().msg().ade().linha().get(msgOut().indice()).zProcessamentoL().set(" ");
            msgIn().msg().ade().linha().get(msgOut().indice()).cMnemEgcOpexL().set(" ");
            msgIn().msg().ade().linha().get(msgOut().indice()).cPaisIsoaOpxL().set(" ");
            msgIn().msg().ade().linha().get(msgOut().indice()).cUseridL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoaContL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cMoedIsoSctaL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoAlfnL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cMnemEmpGcxL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cRefMsgSwifL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).zMovimentoL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIEmsDocL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmiDocIdL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cPaisEmsDocAL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdApL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdAptdL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdApL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmiDidApL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iCliCgdL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoItvtDepL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoMdtiL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iDbcrL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoCanlAcesL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iTrnzEfcdOnlnL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iPedJstzOFndL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cMtvoPedJstzL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iRcsJstzOFndL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iEstornoL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).tsInsercaoL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cPaisEmsDocRL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdRpL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdRprtL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdRpL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmixDidRL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).iRprtCliCgd().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplRprL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipRelDepL().set(" ");
            msgOut().msg().ade().linha().get(msgOut().indice()).xInfJstzDepL().set(" ");
            /**
             * PASSIVAS 4497 (FIM)
             */
            msgIn().msg().ade().linha().get(msgOut().indice()).cOeEgcOpexL().set(0);
            msgIn().msg().ade().linha().get(msgOut().indice()).nJourBbnL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).cBancContL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).cOeEgcContL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nsRdclContL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).vChkdContL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoContL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nsDepositoL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).cEstMsgSwifL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nChequeL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteRprtL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliRprtL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).mMovEuroL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).qMoedaL().set(0);
            msgOut().indice().add(CON_1N);
        }
        m1100MensagemInput() ;
        m1150ValidaModoPesq() ;
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsContaAsc().isTrue() || swSwitchs().swTpConsContaDesc().isTrue()) && 
            !msgIn().msg().ade().cPaisIsoaCont().isEmpty() && 
            !swSwitchs().swChequeBancarioSim().isTrue() && 
            !swSwitchs().swCartaChequeSim().isTrue()) {
            m1200ValidaConta() ;
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsContaAsc().isTrue() || swSwitchs().swTpConsContaDesc().isTrue()) && 
            !msgIn().msg().ade().cPaisIsoaCont().isEmpty() && 
            !swSwitchs().swChequeBancarioSim().isTrue() && 
            !swSwitchs().swCartaChequeSim().isTrue()) {
            m1300ValidaSubconta() ;
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsClienteAsc().isTrue() || swSwitchs().swTpConsClienteDesc().isTrue())) {
            m1400ValidaCliente() ;
        }
    }
    
    /**
     * 
     * 1100-MENSAGEM-INPUT
     * 
     */
    protected void m1100MensagemInput() {
        log(TraceLevel.Debug, "  1100-MENSAGEM-INPUT");
        log(TraceLevel.Debug, " *********************************************");
        log(TraceLevel.Debug, "              I N P U T                       ");
        log(TraceLevel.Debug, " *********************************************");
        log(TraceLevel.Debug, "  BGHM1140-C-PAIS-ISOA-CONT   : ", msgIn().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "  BGHM1140-C-BANC-CONT        : ", msgIn().msg().ade().cBancCont());
        log(TraceLevel.Debug, "  BGHM1140-C-OE-EGC-CONT      : ", msgIn().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "  BGHM1140-NS-RDCL-CONT       : ", msgIn().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "  BGHM1140-V-CHKD-CONT        : ", msgIn().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "  BGHM1140-C-TIPO-CONT        : ", msgIn().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "  BGHM1140-C-MOED-ISO-SCTA    : ", msgIn().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "  BGHM1140-NS-DEPOSITO        : ", msgIn().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "  BGHM1140-C-PAIS-ISO-ALFN    : ", msgIn().msg().ade().cPaisIsoAlfn());
        log(TraceLevel.Debug, "  BGHM1140-C-MNEM-EMP-GCX     : ", msgIn().msg().ade().cMnemEmpGcx());
        log(TraceLevel.Debug, "  BGHM1140-C-REF-MSG-SWIF     : ", msgIn().msg().ade().cRefMsgSwif());
        log(TraceLevel.Debug, "  BGHM1140-N-CHEQUE           : ", msgIn().msg().ade().nCheque());
        log(TraceLevel.Debug, "  BGHM1140-N-CLIENTE          : ", msgIn().msg().ade().nCliente());
        log(TraceLevel.Debug, "  BGHM1140-NS-ABRA-CLI        : ", msgIn().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "  BGHM1140-C-PAIS-ISA-EMS-DOC : ", msgIn().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "  BGHM1140-C-TIPO-DOC-ID      : ", msgIn().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "  BGHM1140-N-DOC-ID           : ", msgIn().msg().ade().nDocId());
        log(TraceLevel.Debug, "  BGHM1140-NM-CLI-COMPL       : ", msgIn().msg().ade().nmCliCompl());
        log(TraceLevel.Debug, "  BGHM1140-M-MOV-NMRI-MIN     : ", msgIn().msg().ade().mMovNmriMin());
        log(TraceLevel.Debug, "  BGHM1140-M-MOV-NMRI-MAX     : ", msgIn().msg().ade().mMovNmriMax());
        log(TraceLevel.Debug, "  BGHM1140-I-CRIT-DBCR        : ", msgIn().msg().ade().iCritDbcr());
        log(TraceLevel.Debug, "  BGHM1140-C-TIPO-OPE-CONT    : ", msgIn().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "  BGHM1140-I-CLI-CGD          : ", msgIn().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "  BGHM1140-C-TIPO-ITVT-DEP    : ", msgIn().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "  BGHM1140-I-CONSULTA         : ", msgIn().msg().ade().iConsulta());
        log(TraceLevel.Debug, "  BGHM1140-Z-MOVIMENTO-MIN    : ", msgIn().msg().ade().zMovimentoMin());
        log(TraceLevel.Debug, "  BGHM1140-Z-MOVIMENTO-MAX    : ", msgIn().msg().ade().zMovimentoMax());
        log(TraceLevel.Debug, "  BGHM1140-I-MODO-PESQ        : ", msgIn().msg().ade().iModoPesq());
        log(TraceLevel.Debug, "                                ");
        log(TraceLevel.Debug, "  ...CHAVE DE CONTINUACAO...    ");
        log(TraceLevel.Debug, "  BGHM1140-TS-INSERCAO-C      : ", msgIn().msg().ade().tsInsercaoC());
    }
    
    /**
     * 
     * 1150-VALIDA-MODO-PESQ
     * 
     */
    protected void m1150ValidaModoPesq() {
        log(TraceLevel.Debug, "  1150-VALIDA-MODO-PESQ");
        if (!msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_CONTA) && 
            !msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_CLIENTE) && 
            !msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_DOCUM) && 
            !msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_NOME) && 
            !msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_ORDEM) && 
            !msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_MONT)) {
            messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            messageV2.mensagem().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "  BGHM1140-I-MODO-PESQ MAL FORMATADO");
            log(TraceLevel.Error, " ERRO-01");
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            !msgIn().msg().ade().iConsulta().isEqual(CON_ASCENDENTE) && 
            !msgIn().msg().ade().iConsulta().isEqual(CON_DESCENDENTE)) {
            messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            messageV2.mensagem().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "  BGHM1140-I-CONSULTA MAL FORMATADO");
            log(TraceLevel.Error, " ERRO-02");
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            if (msgIn().msg().ade().iConsulta().isEqual(CON_ASCENDENTE)) {
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_CONTA)) {
                    swSwitchs().swTpConsContaAsc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_CLIENTE)) {
                    swSwitchs().swTpConsClienteAsc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_DOCUM)) {
                    swSwitchs().swTpConsDocumAsc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_NOME)) {
                    swSwitchs().swTpConsNomeAsc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_ORDEM)) {
                    swSwitchs().swTpConsOrdemAsc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_MONT)) {
                    swSwitchs().swTpConsMontAsc().setTrue() ;
                }
            } else {
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_CONTA)) {
                    swSwitchs().swTpConsContaDesc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_CLIENTE)) {
                    swSwitchs().swTpConsClienteDesc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_DOCUM)) {
                    swSwitchs().swTpConsDocumDesc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_NOME)) {
                    swSwitchs().swTpConsNomeDesc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_ORDEM)) {
                    swSwitchs().swTpConsOrdemDesc().setTrue() ;
                }
                if (msgIn().msg().ade().iModoPesq().isEqual(CON_CSLT_MONT)) {
                    swSwitchs().swTpConsMontDesc().setTrue() ;
                }
            }
        }
        log(TraceLevel.Debug, "  SW-I-MODO-PESQ : ", swSwitchs().swIModoPesq());
        /**
         * IF BHTL010A-SEM-ERROS
         * AND (SW-TP-CONS-CONTA-ASC OR SW-TP-CONS-CONTA-DESC)
         * IF (BGHM1140-C-PAIS-ISOA-CONT = (SPACES OR LOW-VALUES)
         * OR BGHM1140-C-BANC-CONT      = ZEROS
         * OR BGHM1140-C-BANC-CONT      NOT NUMERIC
         * OR BGHM1140-C-OE-EGC-CONT    = ZEROS
         * OR BGHM1140-C-OE-EGC-CONT    NOT NUMERIC
         * OR BGHM1140-NS-RDCL-CONT     = ZEROS
         * OR BGHM1140-NS-RDCL-CONT     NOT NUMERIC
         * OR BGHM1140-V-CHKD-CONT      NOT NUMERIC
         * OR BGHM1140-C-TIPO-CONT      NOT NUMERIC
         * OR BGHM1140-C-MOED-ISO-SCTA  = (SPACES OR LOW-VALUES)
         * OR BGHM1140-NS-DEPOSITO      NOT NUMERIC)
         * MOVE CON-COD-APLICACAO    TO BHTL010A-A-APL-ERRO
         * MOVE BGHK0001-INPUT-INVALIDO
         * TO BGHM1141-C-BANC-CONT-M
         * SET BGHM1141-C-BANC-CONT-1
         * BHTL010A-ERROS-FUNCAO TO TRUE
         * DISPLAY '  BGHM1140-C-PAIS-ISOA-CONT MAL FORMATADO'
         * DISPLAY ' ERRO-03'
         * END-IF
         * END-IF.
         */
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsContaAsc().isTrue() || swSwitchs().swTpConsContaDesc().isTrue())) {
            if (msgIn().msg().ade().cPaisIsoaCont().isEqual(CON_C_PAIS_CHQ_BANC) && 
                msgIn().msg().ade().cBancCont().isEqual(CON_C_BANC_CHQ_BANC) && 
                msgIn().msg().ade().cOeEgcCont().isEqual(CON_C_OE_CHQ_BANC) && 
                msgIn().msg().ade().nsRdclCont().isEqual(CON_NS_RDCL_CHQ_BANC) && 
                msgIn().msg().ade().vChkdCont().isEqual(CON_V_CHKD_CHQ_BANC) && 
                msgIn().msg().ade().cTipoCont().isEqual(CON_C_TIPO_CHQ_BANC) && 
                msgIn().msg().ade().cMoedIsoScta().isEqual(CON_C_MOED_CHQ_BANC) && 
                msgIn().msg().ade().nsDeposito().isEqual(CON_NS_DEP_CHQ_BAN)) {
                swSwitchs().swChequeBancarioSim().setTrue() ;
            }
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsContaAsc().isTrue() || swSwitchs().swTpConsContaDesc().isTrue())) {
            if (msgIn().msg().ade().cPaisIsoaCont().isEqual(CON_C_PAIS_CARTA_CHQ) && 
                msgIn().msg().ade().cBancCont().isEqual(CON_C_BANC_CARTA_CHQ) && 
                msgIn().msg().ade().cOeEgcCont().isEqual(CON_C_OE_CARTA_CHQ) && 
                msgIn().msg().ade().nsRdclCont().isEqual(CON_NS_RDCL_CARTA_CHQ) && 
                msgIn().msg().ade().vChkdCont().isEqual(CON_V_CHKD_CARTA_CHQ) && 
                msgIn().msg().ade().cTipoCont().isEqual(CON_C_TIPO_CARTA_CHQ) && 
                msgIn().msg().ade().cMoedIsoScta().isEqual(CON_C_MOED_CARTA_CHQ) && 
                msgIn().msg().ade().nsDeposito().isEqual(CON_NS_DEP_CARTA_CHQ)) {
                swSwitchs().swCartaChequeSim().setTrue() ;
            }
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsClienteAsc().isTrue() || swSwitchs().swTpConsClienteDesc().isTrue())) {
            if (msgIn().msg().ade().nCliente().isEqual(0) || 
                !msgIn().msg().ade().nCliente().isNumeric()) {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-N-CLIENTE MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-04");
            }
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsDocumAsc().isTrue() || swSwitchs().swTpConsDocumDesc().isTrue())) {
            if (msgIn().msg().ade().cPaisIsaEmsDoc().isEmpty() || 
                msgIn().msg().ade().cPaisIsaEmsDoc().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().cTipoDocId().isEmpty() || 
                msgIn().msg().ade().cTipoDocId().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().nDocId().isEmpty() || 
                msgIn().msg().ade().nDocId().isEqual(String.valueOf(LOW_VALUES))) {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-C-PAIS-ISA-EMS-DOC MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-05");
            }
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsNomeAsc().isTrue() || swSwitchs().swTpConsNomeDesc().isTrue())) {
            if (msgIn().msg().ade().nmCliCompl().isEmpty() || 
                msgIn().msg().ade().nmCliCompl().isEqual(String.valueOf(LOW_VALUES))) {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-NM-CLI-COMPL MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-06");
            }
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsOrdemAsc().isTrue() || swSwitchs().swTpConsOrdemDesc().isTrue())) {
            if (msgIn().msg().ade().cPaisIsoAlfn().isEmpty() || 
                msgIn().msg().ade().cPaisIsoAlfn().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().cMnemEmpGcx().isEmpty() || 
                msgIn().msg().ade().cMnemEmpGcx().isEqual(String.valueOf(LOW_VALUES)) || 
                msgIn().msg().ade().cRefMsgSwif().isEmpty() || 
                msgIn().msg().ade().cRefMsgSwif().isEqual(String.valueOf(LOW_VALUES))) {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-C-REF-MSG-SWIF MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-07");
            }
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            (swSwitchs().swTpConsMontAsc().isTrue() || swSwitchs().swTpConsMontDesc().isTrue())) {
            if (!msgIn().msg().ade().mMovNmriMin().isNumeric() || !msgIn().msg().ade().mMovNmriMax().isNumeric()) {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-M-MOV-NMRI-MIN MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-08");
            }
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            if (msgIn().msg().ade().iCritDbcr().isEqual(CON_DEBITO) || 
                msgIn().msg().ade().iCritDbcr().isEqual(CON_CREDITO)) {
                wsVariaveis().wsCrit1().set(msgIn().msg().ade().iCritDbcr());
                wsVariaveis().wsCrit2().set(msgIn().msg().ade().iCritDbcr());
                wsVariaveis().wsCrit3().set(msgIn().msg().ade().iCritDbcr());
            } else if (msgIn().msg().ade().iCritDbcr().isEqual(CON_AMBOS)) {
                wsVariaveis().wsCrit1().set(CON_CREDITO);
                wsVariaveis().wsCrit2().set(CON_DEBITO);
                wsVariaveis().wsCrit3().set(" ");
            } else {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-I-CRIT-DBCR MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-09");
            }
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM) || 
                msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
                wsVariaveis().wsICliCgd1().set(msgIn().msg().ade().iCliCgd());
                wsVariaveis().wsICliCgd2().set(msgIn().msg().ade().iCliCgd());
            } else if (msgIn().msg().ade().iCliCgd().isEqual(CON_OS_DOIS)) {
                wsVariaveis().wsICliCgd1().set(CON_SIM);
                wsVariaveis().wsICliCgd2().set(CON_NAO);
            } else {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-I-CLI-CGD MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-10");
            }
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_MANDATARIO) || 
                msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TERCEIROS) || 
                msgIn().msg().ade().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO) || 
                msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENE_CHQ) || 
                msgIn().msg().ade().cTipoItvtDep().isEqual(CON_ORDENANTE_ORD) || 
                msgIn().msg().ade().cTipoItvtDep().isEqual(CON_BENEFICIARIO_ORD) || 
                msgIn().msg().ade().cTipoItvtDep().isEqual(CON_PROPIO)) {
                wsVariaveis().wsCTipoItvtDep1().set(msgIn().msg().ade().cTipoItvtDep());
                wsVariaveis().wsCTipoItvtDep2().set(msgIn().msg().ade().cTipoItvtDep());
                wsVariaveis().wsCTipoItvtDep3().set(msgIn().msg().ade().cTipoItvtDep());
                wsVariaveis().wsCTipoItvtDep4().set(msgIn().msg().ade().cTipoItvtDep());
                wsVariaveis().wsCTipoItvtDep5().set(msgIn().msg().ade().cTipoItvtDep());
                wsVariaveis().wsCTipoItvtDep6().set(msgIn().msg().ade().cTipoItvtDep());
                wsVariaveis().wsCTipoItvtDep7().set(msgIn().msg().ade().cTipoItvtDep());
            } else if (msgIn().msg().ade().cTipoItvtDep().isEqual(CON_TODOS)) {
                wsVariaveis().wsCTipoItvtDep1().set(CON_MANDATARIO);
                wsVariaveis().wsCTipoItvtDep2().set(CON_TERCEIROS);
                wsVariaveis().wsCTipoItvtDep3().set(CON_PROPIO);
                wsVariaveis().wsCTipoItvtDep4().set(CON_DEP_EXPRESSO);
                wsVariaveis().wsCTipoItvtDep5().set(CON_BENE_CHQ);
                wsVariaveis().wsCTipoItvtDep6().set(CON_ORDENANTE_ORD);
                wsVariaveis().wsCTipoItvtDep7().set(CON_BENEFICIARIO_ORD);
            } else {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-C-TIPO-ITVT-DEP MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-11");
            }
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            swSwitchs().swCTipoOpeContIn().set(msgIn().msg().ade().cTipoOpeCont());
            if (swSwitchs().swTodosIn().isTrue()) {
                wsVariaveis().wsCTipoOpeCont1().set(CON_ENTREGA);
                wsVariaveis().wsCTipoOpeCont2().set(CON_LEVANTAMENTO);
                wsVariaveis().wsCTipoOpeCont3().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont4().set(CON_TROCO_DESTROCO);
                /**
                 * ----------- TRANSFERENCIAS
                 */
                wsVariaveis().wsCTipoOpeCont5().set(CON_ORDENS_EMITIDAS);
                wsVariaveis().wsCTipoOpeCont6().set(CON_ORDENS_RECEBIDAS);
                /**
                 * --------------------------
                 */
                wsVariaveis().wsCTipoOpeCont7().set(CON_OCASIONAIS);
            } else if (swSwitchs().swOcasionaisIn().isTrue()) {
                wsVariaveis().wsCTipoOpeCont1().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont2().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont3().set(CON_ORDENS_EMITIDAS);
                wsVariaveis().wsCTipoOpeCont4().set(CON_ORDENS_EMITIDAS);
                wsVariaveis().wsCTipoOpeCont5().set(CON_ORDENS_RECEBIDAS);
                wsVariaveis().wsCTipoOpeCont6().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont7().set(CON_OCASIONAIS);
            } else if (swSwitchs().swTransferenciasIn().isTrue()) {
                wsVariaveis().wsCTipoOpeCont1().set(CON_ORDENS_EMITIDAS);
                wsVariaveis().wsCTipoOpeCont2().set(CON_ORDENS_EMITIDAS);
                wsVariaveis().wsCTipoOpeCont3().set(CON_ORDENS_EMITIDAS);
                wsVariaveis().wsCTipoOpeCont4().set(CON_ORDENS_EMITIDAS);
                wsVariaveis().wsCTipoOpeCont5().set(CON_ORDENS_RECEBIDAS);
                wsVariaveis().wsCTipoOpeCont6().set(CON_ORDENS_RECEBIDAS);
                wsVariaveis().wsCTipoOpeCont7().set(CON_ORDENS_RECEBIDAS);
            } else if (swSwitchs().swTrocoDestrocoIn().isTrue()) {
                wsVariaveis().wsCTipoOpeCont1().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont2().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont3().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont4().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont5().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont6().set(CON_TROCO_DESTROCO);
                wsVariaveis().wsCTipoOpeCont7().set(CON_TROCO_DESTROCO);
            } else if (swSwitchs().swCambioIn().isTrue()) {
                wsVariaveis().wsCTipoOpeCont1().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont2().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont3().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont4().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont5().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont6().set(CON_CAMBIO);
                wsVariaveis().wsCTipoOpeCont7().set(CON_CAMBIO);
            } else if (swSwitchs().swLevantamentosIn().isTrue()) {
                wsVariaveis().wsCTipoOpeCont1().set(CON_LEVANTAMENTO);
                wsVariaveis().wsCTipoOpeCont2().set(CON_LEVANTAMENTO);
                wsVariaveis().wsCTipoOpeCont3().set(CON_LEVANTAMENTO);
                wsVariaveis().wsCTipoOpeCont4().set(CON_LEVANTAMENTO);
                wsVariaveis().wsCTipoOpeCont5().set(CON_LEVANTAMENTO);
                wsVariaveis().wsCTipoOpeCont6().set(CON_LEVANTAMENTO);
                wsVariaveis().wsCTipoOpeCont7().set(CON_LEVANTAMENTO);
            } else if (swSwitchs().swEntregasIn().isTrue()) {
                wsVariaveis().wsCTipoOpeCont1().set(CON_ENTREGA);
                wsVariaveis().wsCTipoOpeCont2().set(CON_ENTREGA);
                wsVariaveis().wsCTipoOpeCont3().set(CON_ENTREGA);
                wsVariaveis().wsCTipoOpeCont4().set(CON_ENTREGA);
                wsVariaveis().wsCTipoOpeCont5().set(CON_ENTREGA);
                wsVariaveis().wsCTipoOpeCont6().set(CON_ENTREGA);
                wsVariaveis().wsCTipoOpeCont7().set(CON_ENTREGA);
            } else {
                messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                messageV2.mensagem().errosFuncao().setTrue() ;
                log(TraceLevel.Error, "  BGHM1140-C-TIPO-OPE-CONT MAL FORMATADO");
                log(TraceLevel.Error, " ERRO-12");
            }
        }
    }
    
    /**
     * 
     * 1200-VALIDA-CONTA
     * 
     */
    protected void m1200ValidaConta() {
        log(TraceLevel.Debug, "  1200-VALIDA-CONTA");
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
            messageV2.mensagem().aAplErro().set(bhol708a().commarea().dadosOutput().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhol708a().commarea().dadosOutput().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhol708a().commarea().dadosOutput().cSqlcode());
            envOut.db2Log().nmTabela().set(bhol708a().commarea().dadosOutput().nmTabela());
            if (bhol708a().commarea().dadosOutput().errosFuncao().isTrue()) {
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhol708a().commarea().dadosOutput().cRtnoEvenSwal());
            } else {
                messageV2.mensagem().cRtnoSwal().set(bhol708a().commarea().dadosOutput().cRtnoEvenSwal());
            }
        }
    }
    
    /**
     * 
     * 1300-VALIDA-SUBCONTA
     * 
     */
    protected void m1300ValidaSubconta() {
        log(TraceLevel.Debug, "  1300-VALIDA-SUBCONTA");
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
            messageV2.mensagem().aAplErro().set(bhol710a().commarea().dadosOutput().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhol710a().commarea().dadosOutput().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhol710a().commarea().dadosOutput().cSqlcode());
            envOut.db2Log().nmTabela().set(bhol710a().commarea().dadosOutput().nmTabela());
            if (bhol710a().commarea().dadosOutput().errosFuncao().isTrue()) {
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhol710a().commarea().dadosOutput().cRtnoEvenSwal());
            } else {
                messageV2.mensagem().cRtnoSwal().set(bhol710a().commarea().dadosOutput().cRtnoEvenSwal());
            }
        }
    }
    
    /**
     * 
     * 1400-VALIDA-CLIENTE
     * 
     */
    protected void m1400ValidaCliente() {
        log(TraceLevel.Debug, "  1400-VALIDA-CLIENTE");
        log(TraceLevel.Debug, "   BGHM1140-N-CLIENTE : ", msgIn().msg().ade().nCliente());
        if (msgIn().msg().ade().iCliCgd().isEqual(CON_SIM)) {
            wsVariaveis().wsBhjl006aCPais().set(messageV2.mensagem().nEltnJourBbn().cPaisIsoaOeOpx());
            wsVariaveis().wsBhjl006aCMnem().set(messageV2.mensagem().nEltnJourBbn().cMnemEgcOpex());
            wsVariaveis().wsBhjl006aNCli().set(msgIn().msg().ade().nCliente());
            m1410ValidaCliente() ;
            if (messageV2.mensagem().semErros().isTrue()) {
                log(TraceLevel.Debug, "  1400-VALIDA-CLIENTE");
                log(TraceLevel.Debug, "   BHJL006A-C-TIPO-CLI: ", bhjl006a().commarea().dadosSaida().cTipoCli());
                if (!bhjl006a().commarea().dadosSaida().cTipoCli().isEqual(bhjk0002().BHJK0002_CLIENTE_EMPRESA)) {
                    m1420ObtmDadosTg886() ;
                } else {
                    wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNipc());
                    wsTabelasInternas().wsTipoDocumento().get(2).wsTdCCodigo().set(conDocNfie());
                    wsTabelasInternas().wsTipoDocumento().get(3).wsTdCCodigo().set(conDocNpc());
                    wsTabelasInternas().wsTipoDocumento().get(4).wsTdCCodigo().set(conDocNife());
                }
                if (messageV2.mensagem().semErros().isTrue()) {
                    m1430ObtemDocum() ;
                }
            }
        } else if (msgIn().msg().ade().iCliCgd().isEqual(CON_NAO)) {
            m1440ValidaNaoCliente() ;
            if (messageV2.mensagem().semErros().isTrue()) {
                log(TraceLevel.Debug, "  1400-VALIDA-CLIENTE");
                log(TraceLevel.Debug, "   BHEL100A-C-TIPO-NCLI-S: ", bhel100a().commarea().dadosSaida().cTipoNcliS());
                if (!bhel100a().commarea().dadosSaida().cTipoNcliS().isEqual(bhjk0002().BHJK0002_CLIENTE_EMPRESA)) {
                    m1420ObtmDadosTg886() ;
                } else {
                    wsTabelasInternas().wsTipoDocumento().get(1).wsTdCCodigo().set(conDocNipc());
                    wsTabelasInternas().wsTipoDocumento().get(2).wsTdCCodigo().set(conDocNfie());
                    wsTabelasInternas().wsTipoDocumento().get(3).wsTdCCodigo().set(conDocNpc());
                    wsTabelasInternas().wsTipoDocumento().get(4).wsTdCCodigo().set(conDocNife());
                }
                if (messageV2.mensagem().semErros().isTrue()) {
                    m1450CarregaDocNcli() ;
                }
            }
        } else {
            messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().inputInvalido());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            messageV2.mensagem().errosFuncao().setTrue() ;
        }
    }
    
    /**
     * 
     * 1410-VALIDA-CLIENTE
     * VALIDA A EXISTENCIA DO CLIENTE E DEVOLVE ALGUNS INDICADORES
     * 
     */
    protected void m1410ValidaCliente() {
        log(TraceLevel.Debug, "   1410-VALIDA-CLIENTE");
        bhjl006a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(wsVariaveis().wsBhjl006aCPais());
        bhjl006a().commarea().dadosEntrada().cMnemEgcOpex().set(wsVariaveis().wsBhjl006aCMnem());
        bhjl006a().commarea().dadosEntrada().nCliente().set(wsVariaveis().wsBhjl006aNCli());
        bhjp6006AcedeMhjs006a() ;
        if (!bhjl006a().commarea().erros().fimConsulta().isTrue() && !bhjl006a().commarea().erros().semErros().isTrue()) {
            messageV2.mensagem().aAplErro().set(bhjl006a().commarea().erros().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhjl006a().commarea().erros().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl006a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl006a().commarea().erros().nmTabela());
            if (bhjl006a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl006a().commarea().erros().cRtnoEvenSwal());
            } else {
                messageV2.mensagem().cRtnoSwal().set(bhjl006a().commarea().erros().cRtnoEvenSwal());
            }
        }
    }
    
    /**
     * 
     * 1420-OBTM-DADOS-TG886
     * OBTENCAO DE REGISTOS DE UMA TABELA LOGICA E FISICA 886
     * 
     */
    protected void m1420ObtmDadosTg886() {
        log(TraceLevel.Debug, "   1420-OBTM-DADOS-TG886");
        wsVariaveis().wsInd().set(CON_1N);
        swSwitchs().swEmCiclo().setTrue() ;
        while (!swSwitchs().swFimCiclo().isTrue()) {
            m1421ObtemTpDoc() ;
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            m1422OrdenaTabInterna() ;
        }
    }
    
    /**
     * 
     * 1421-OBTEM-TP-DOC
     * 
     */
    protected void m1421ObtemTpDoc() {
        log(TraceLevel.Debug, "    1421-OBTEM-TP-DOC");
        bhgl052a().commarea().dadosInput().cTabBbnIn().set("886");
        bhgl052a().commarea().dadosInput().cIdioIsoIn().set(bhok0002().BHOK0002_IDIOMA_PORTUGAL);
        bhgl052a().commarea().dadosInput().pagInput().cCodigoPgIn().set(bhgl052a().commarea().dadosOutput().pagOutput().cCodigoPgOut());
        bhgl052a().commarea().dadosInput().pagInput().cIdioIsoPgIn().set(bhgl052a().commarea().dadosOutput().pagOutput().cIdioIsoPgOut());
        bhgp0052AcedeMhgj052a() ;
        if (!bhgl052a().commarea().dadosErro().fimConsulta().isTrue() && !bhgl052a().commarea().dadosErro().semErros().isTrue()) {
            messageV2.mensagem().aAplErro().set(bhgl052a().commarea().dadosErro().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhgl052a().commarea().dadosErro().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhgl052a().commarea().dadosErro().cSqlcode());
            envOut.db2Log().nmTabela().set(bhgl052a().commarea().dadosErro().nmTabela());
            swSwitchs().swFimCiclo().setTrue() ;
            if (bhgl052a().commarea().dadosErro().erroFuncao().isTrue()) {
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhgl052a().commarea().dadosErro().cRtnoEvenSwal());
            } else {
                messageV2.mensagem().cRtnoSwal().set(bhgl052a().commarea().dadosErro().cRtnoEvenSwal());
            }
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
     * 1422-ORDENA-TAB-INTERNA
     * 
     */
    protected void m1422OrdenaTabInterna() {
        log(TraceLevel.Debug, "    1422-ORDENA-TAB-INTERNA");
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
     * 1430-OBTEM-DOCUM
     * 
     */
    protected void m1430ObtemDocum() {
        log(TraceLevel.Debug, "   1430-OBTEM-DOCUM");
        bhjl031a().commarea().initialize() ;
        wsVariaveis().wsQtDoc().initialize() ;
        bhjl031a().commarea().dadosEntrada().nCliente().set(msgIn().msg().ade().nCliente());
        bhjl031a().commarea().dadosEntrada().nsAbraCli().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
        swSwitchs().swEmCiclo().setTrue() ;
        while (!swSwitchs().swFimCiclo().isTrue() && messageV2.mensagem().semErros().isTrue()) {
            m1431ObtemDocCli() ;
        }
    }
    
    /**
     * 
     * 1431-OBTEM-DOC-CLI
     * OBTEM OS DOCUMENTOS DE IDENTIFICACAO DO CLIENTE
     * 
     */
    protected void m1431ObtemDocCli() {
        log(TraceLevel.Debug, "    1431-OBTEM-DOC-CLI");
        bhjl031a().commarea().dadosEntrada().nDocIdL().set(bhjl031a().commarea().dadosSaida().get(CON_100N).nDocId());
        bhjp5031AcedeMhjj031a() ;
        if (!bhjl031a().commarea().erros().fimConsulta().isTrue() && !bhjl031a().commarea().erros().semErros().isTrue()) {
            messageV2.mensagem().aAplErro().set(bhjl031a().commarea().erros().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhjl031a().commarea().erros().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl031a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl031a().commarea().erros().nmTabela());
            swSwitchs().swFimCiclo().setTrue() ;
            if (bhjl031a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl031a().commarea().erros().cRtnoEvenSwal());
            } else {
                messageV2.mensagem().cRtnoSwal().set(bhjl031a().commarea().erros().cRtnoEvenSwal());
            }
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            wsVariaveis().wsIndTi2().set(0);
            wsVariaveis().wsIndTi().set(CON_1N);
            while (wsVariaveis().wsIndTi().isLessOrEqual(CON_250N) && !swSwitchs().swFimCiclo().isTrue() && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndTi()).wsTdCCodigo().isEmpty() && messageV2.mensagem().semErros().isTrue()) {
                wsVariaveis().wsIndRot().set(CON_1N);
                wsVariaveis().wsCodCodigo().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndTi()).wsTdCCodigo());
                swSwitchs().swDocNfound().setTrue() ;
                while (wsVariaveis().wsIndRot().isLessOrEqual(CON_100N) && !swSwitchs().swFimCiclo().isTrue() && !swSwitchs().swDocFound().isTrue() && !bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cTipoDocId().isEmpty() && messageV2.mensagem().semErros().isTrue()) {
                    log(TraceLevel.Debug, "   WS-CC-C-PAIS          : ", wsVariaveis().wsCodCodigo().wsCcCPais());
                    log(TraceLevel.Debug, "   WS-CC-T-DOC           : ", wsVariaveis().wsCodCodigo().wsCcTDoc());
                    log(TraceLevel.Debug, "   BHJL031A-C-PAIS-ISA-EM: ", bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cPaisIsaEmsDoc());
                    log(TraceLevel.Debug, "   BHJL031A-C-TIPO-DOC-ID: ", bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cTipoDocId());
                    if (wsVariaveis().wsCodCodigo().wsCcCPais().isEqual(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cPaisIsaEmsDoc()) && 
                        wsVariaveis().wsCodCodigo().wsCcTDoc().isEqual(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cTipoDocId())) {
                        wsVariaveis().wsIndTi2().add(CON_1N);
                        wsVariaveis().wsQtDoc().add(CON_1N);
                        swSwitchs().swDocFound().setTrue() ;
                        wsTabelasInternas().wsDocumentosCliente().wsDocumCli().get(wsVariaveis().wsIndTi2()).wsTdCPaisIsaEmsDoc().set(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cPaisIsaEmsDoc());
                        wsTabelasInternas().wsDocumentosCliente().wsDocumCli().get(wsVariaveis().wsIndTi2()).wsTdCTipoDocId().set(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cTipoDocId());
                        wsTabelasInternas().wsDocumentosCliente().wsDocumCli().get(wsVariaveis().wsIndTi2()).wsTdNDocId().set(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).nDocId());
                        if (messageV2.mensagem().semErros().isTrue()) {
                            m1432ValidaDocCli() ;
                        }
                    }
                    if (wsVariaveis().wsQtDoc().isEqual(CON_14N)) {
                        swSwitchs().swFimCiclo().setTrue() ;
                    }
                    wsVariaveis().wsIndRot().add(CON_1N);
                }
                wsVariaveis().wsIndTi().add(CON_1N);
            }
            if (!bhjl031a().commarea().pagCheia().isTrue()) {
                swSwitchs().swFimCiclo().setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 1432-VALIDA-DOC-CLI
     * 
     */
    protected void m1432ValidaDocCli() {
        log(TraceLevel.Debug, "    1432-VALIDA-DOC-CLI");
        log(TraceLevel.Debug, "   BHJL031A-C-PAIS-ISA-EMS-DOC: ", bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BHJL031A-C-TIPO-DOC-ID     : ", bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cTipoDocId());
        log(TraceLevel.Debug, "   BHJL031A-N-DOC-ID          : ", bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).nDocId());
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cPaisIsaEmsDoc());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).cTipoDocId());
        bhjl027a().commarea().dadosEntrada().nDocId().set(bhjl031a().commarea().dadosSaida().get(wsVariaveis().wsIndRot()).nDocId());
        bhjp5027AcedeMhjj027a() ;
        if (!bhjl027a().commarea().erros().semErros().isTrue() && !bhjl027a().commarea().erros().fimConsulta().isTrue()) {
            messageV2.mensagem().aAplErro().set(bhjl027a().commarea().erros().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhjl027a().commarea().erros().cTipoErroBbn());
            envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
            if (bhjl027a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                if (bhjl027a().commarea().erros().docRepetido().isTrue() && 
                    bhjl027a().commarea().erros().aAplErr().isEqual(bhjk0002().BHJK0002_APLICACAO_CLIENTES)) {
                    messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().cliDocIdComum());
                } else {
                    msgOut().msg().ase().cBancContSt().cBancContM().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
                }
            } else {
                messageV2.mensagem().cRtnoSwal().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
            }
        }
    }
    
    /**
     * 
     * 1440-VALIDA-NAO-CLIENTE
     * VALIDA A EXISTENCIA DO NAO CLIENTE
     * 
     */
    protected void m1440ValidaNaoCliente() {
        log(TraceLevel.Debug, "   1440-VALIDA-NAO-CLIENTE");
        bhel100a().commarea().initialize() ;
        bhel100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        /**
         * -- MODO DE VISUALIZACAO / OPERACAO (CHAVE):
         * --  1 - PAIS, EMPRESA, NUM NAO CLIENTE
         */
        bhel100a().commarea().dadosEntrada().iOperacao().set(CON_1N);
        bhel100a().commarea().dadosEntrada().cPaisIsoaOpe().set(messageV2.mensagem().nEltnJourBbn().cPaisIsoaOeOpx());
        bhel100a().commarea().dadosEntrada().cMnemEgcOpe().set(messageV2.mensagem().nEltnJourBbn().cMnemEgcOpex());
        bhel100a().commarea().dadosEntrada().nPrcpNcli().set(msgIn().msg().ade().nCliente());
        bhep5100TabNaoClientes() ;
        if (!bhel100a().commarea().dadosSaida().semErros().isTrue()) {
            envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
            messageV2.mensagem().aAplErro().set(bhel100a().commarea().dadosSaida().aAplErr());
            messageV2.mensagem().cTipoErroBbn().set(bhel100a().commarea().dadosSaida().cTipoErroBbn());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            msgOut().msg().ase().cBancContSt().cBancContM().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            messageV2.mensagem().cRtnoSwal().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "   ERRO NA ROTINA MHEJ100A - VALIDA NCLI");
            log(TraceLevel.Error, "   BHEL100A-C-TIPO-ERRO-BBN  : ", bhel100a().commarea().dadosSaida().cTipoErroBbn());
            log(TraceLevel.Error, "   BHEL100A-A-APL-ERR        : ", bhel100a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "   BHEL100A-C-RTNO-EVEN-SWAL : ", bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "   BHEL100A-C-SQLCODE        : ", bhel100a().commarea().dadosSaida().cSqlcode());
            log(TraceLevel.Error, "   BHEL100A-NM-TABELA        : ", bhel100a().commarea().dadosSaida().nmTabela());
        } else if (bhel100a().commarea().dadosSaida().cTipoNcliS().isEmpty()) {
            messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().ncliDadosIncomp());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            messageV2.mensagem().errosFuncao().setTrue() ;
            log(TraceLevel.Error, "  BHEL100A-C-TIPO-NCLI-S MAL FORMATADO");
            log(TraceLevel.Error, " ERRO-13B");
        }
    }
    
    /**
     * 
     * 1450-CARREGA-DOC-NCLI
     * 
     */
    protected void m1450CarregaDocNcli() {
        log(TraceLevel.Debug, " 1450-CARREGA-DOC-NCLI");
        wsTabelasInternas().wsDocCliLinha().initialize() ;
        wsVariaveis().wsQtDoc().initialize() ;
        wsTabelasInternas().wsDocumentosCliente().initialize() ;
        if (messageV2.mensagem().semErros().isTrue()) {
            wsVariaveis().wsIndTi2().set(0);
            wsVariaveis().wsIndTi().set(CON_1N);
            while (wsVariaveis().wsIndTi().isLessOrEqual(CON_250N) && !swSwitchs().swDocFound().isTrue() && !wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndTi()).wsTdCCodigo().isEmpty() && messageV2.mensagem().semErros().isTrue()) {
                wsVariaveis().wsCodCodigo().set(wsTabelasInternas().wsTipoDocumento().get(wsVariaveis().wsIndTi()).wsTdCCodigo());
                swSwitchs().swDocNfound().setTrue() ;
                log(TraceLevel.Debug, "   WS-CC-C-PAIS                 : ", wsVariaveis().wsCodCodigo().wsCcCPais());
                log(TraceLevel.Debug, "   WS-CC-T-DOC                  : ", wsVariaveis().wsCodCodigo().wsCcTDoc());
                log(TraceLevel.Debug, "   BHEL100A-C-PAIS-ISA-EMS-DOC-S: ", bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS());
                log(TraceLevel.Debug, "   BHEL100A-C-TIPO-DOC-ID-S     : ", bhel100a().commarea().dadosSaida().cTipoDocIdS());
                if (wsVariaveis().wsCodCodigo().wsCcCPais().isEqual(bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS()) && 
                    wsVariaveis().wsCodCodigo().wsCcTDoc().isEqual(bhel100a().commarea().dadosSaida().cTipoDocIdS())) {
                    wsVariaveis().wsIndTi2().add(CON_1N);
                    wsVariaveis().wsQtDoc().add(CON_1N);
                    swSwitchs().swDocFound().setTrue() ;
                    wsTabelasInternas().wsDocumentosCliente().wsDocumCli().get(wsVariaveis().wsIndTi2()).wsTdCPaisIsaEmsDoc().set(bhel100a().commarea().dadosSaida().cPaisIsaEmsDocS());
                    wsTabelasInternas().wsDocumentosCliente().wsDocumCli().get(wsVariaveis().wsIndTi2()).wsTdCTipoDocId().set(bhel100a().commarea().dadosSaida().cTipoDocIdS());
                    wsTabelasInternas().wsDocumentosCliente().wsDocumCli().get(wsVariaveis().wsIndTi2()).wsTdNDocId().set(bhel100a().commarea().dadosSaida().nDocIdS());
                }
                wsVariaveis().wsIndTi().add(CON_1N);
            }
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, " 2000-PROCESSO-PROGRAMA");
        m2100AbrirCursor() ;
        if (messageV2.mensagem().semErros().isTrue()) {
            m2200LerCursor() ;
        }
        /**
         * IF SW-VGH13001-NOTFND
         * MOVE CON-COD-APLICACAO       TO BHTL010A-A-APL-ERRO
         * MOVE BGHK0001-NAO-EXIST-MOV-CRIT
         * TO BGHM1141-C-BANC-CONT-M
         * SET BGHM1141-C-BANC-CONT-1
         * BHTL010A-ERROS-FUNCAO TO TRUE
         * END-IF
         */
        if (messageV2.mensagem().semErros().isTrue()) {
            msgOut().indice().set(0);
            while (swSwitchs().swVgh13001Ok().isTrue() && !msgOut().paginaCheia().isTrue() && messageV2.mensagem().semErros().isTrue()) {
                m2300Ciclo() ;
            }
        }
        if (messageV2.mensagem().semErros().isTrue()) {
            m2400FecharCursor() ;
        }
        if (messageV2.mensagem().semErros().isTrue() && 
            msgOut().msg().ade().linha().get(1).cTipoOpeContL().isEmpty()) {
            messageV2.mensagem().aAplErro().set(CON_COD_APLICACAO);
            msgOut().msg().ase().cBancContSt().cBancContM().set(bghk0001().erros().naoExistMovCrit());
            msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
            messageV2.mensagem().errosFuncao().setTrue() ;
        }
    }
    
    /**
     * 
     * 2100-ABRIR-CURSOR
     * 
     */
    protected void m2100AbrirCursor() {
        log(TraceLevel.Debug, "  2100-ABRIR-CURSOR");
        log(TraceLevel.Debug, "   BGHM1140-Z-MOVIMENTO-MIN : ", msgIn().msg().ade().zMovimentoMin());
        log(TraceLevel.Debug, "   BGHM1140-Z-MOVIMENTO-MAX : ", msgIn().msg().ade().zMovimentoMax());
        log(TraceLevel.Debug, "   WS-C-TIPO-OPE-CONT-1     : ", wsVariaveis().wsCTipoOpeCont1());
        log(TraceLevel.Debug, "   WS-C-TIPO-OPE-CONT-2     : ", wsVariaveis().wsCTipoOpeCont2());
        log(TraceLevel.Debug, "   WS-C-TIPO-OPE-CONT-3     : ", wsVariaveis().wsCTipoOpeCont3());
        log(TraceLevel.Debug, "   WS-C-TIPO-OPE-CONT-4     : ", wsVariaveis().wsCTipoOpeCont4());
        log(TraceLevel.Debug, "   WS-C-TIPO-OPE-CONT-5     : ", wsVariaveis().wsCTipoOpeCont5());
        log(TraceLevel.Debug, "   WS-C-TIPO-OPE-CONT-6     : ", wsVariaveis().wsCTipoOpeCont6());
        log(TraceLevel.Debug, "   WS-C-TIPO-OPE-CONT-7     : ", wsVariaveis().wsCTipoOpeCont7());
        log(TraceLevel.Debug, "   WS-I-CLI-CGD-1           : ", wsVariaveis().wsICliCgd1());
        log(TraceLevel.Debug, "   WS-I-CLI-CGD-2           : ", wsVariaveis().wsICliCgd2());
        log(TraceLevel.Debug, "   WS-C-TIPO-ITVT-DEP-1     : ", wsVariaveis().wsCTipoItvtDep1());
        log(TraceLevel.Debug, "   WS-C-TIPO-ITVT-DEP-2     : ", wsVariaveis().wsCTipoItvtDep2());
        log(TraceLevel.Debug, "   WS-C-TIPO-ITVT-DEP-3     : ", wsVariaveis().wsCTipoItvtDep3());
        log(TraceLevel.Debug, "   WS-C-TIPO-ITVT-DEP-4     : ", wsVariaveis().wsCTipoItvtDep4());
        log(TraceLevel.Debug, "   WS-C-TIPO-ITVT-DEP-5     : ", wsVariaveis().wsCTipoItvtDep5());
        log(TraceLevel.Debug, "   WS-C-TIPO-ITVT-DEP-6     : ", wsVariaveis().wsCTipoItvtDep6());
        log(TraceLevel.Debug, "   WS-C-TIPO-ITVT-DEP-7     : ", wsVariaveis().wsCTipoItvtDep7());
        log(TraceLevel.Debug, "   WS-CRIT-1                : ", wsVariaveis().wsCrit1());
        log(TraceLevel.Debug, "   WS-CRIT-2                : ", wsVariaveis().wsCrit2());
        log(TraceLevel.Debug, "   WS-CRIT-3                : ", wsVariaveis().wsCrit3());
        log(TraceLevel.Debug, "   BGHM1140-M-MOV-NMRI-MIN  : ", msgIn().msg().ade().mMovNmriMin());
        log(TraceLevel.Debug, "   BGHM1140-M-MOV-NMRI-MAX  : ", msgIn().msg().ade().mMovNmriMax());
        /**
         * IF BGHM1140-C-PAIS-ISOA-CONT-C EQUAL (SPACES OR LOW-VALUES)
         */
        if (msgIn().msg().ade().tsInsercaoC().isEmpty() || 
            msgIn().msg().ade().tsInsercaoC().isEqual(String.valueOf(LOW_VALUES))) {
            if (msgIn().msg().ade().iConsulta().isEqual(CON_ASCENDENTE)) {
                hv13001Movdep().movdep().zProcessamento().set("0001-01-01");
                hv13001Movdep().movdep().zMovimento().set("0001-01-01");
                hv13001Movdep().movdep().cMnemEgcOpex().set("AAAAAAA");
                hv13001Movdep().movdep().cPaisIsoaOeOpx().set("AAAAAAA");
                hv13001Movdep().movdep().cUserid().set("AAAAAAA");
                hv13001Movdep().movdep().cPaisIsoaCont().set("AAAAAAA");
                hv13001Movdep().movdep().cMoedIsoScta().set("AAAAAAA");
                hv13001Movdep().movdep().cOeEgcOpex().set(0);
                hv13001Movdep().movdep().nJourBbn().set(0);
                hv13001Movdep().movdep().cBancCont().set(0);
                hv13001Movdep().movdep().cOeEgcCont().set(0);
                hv13001Movdep().movdep().nsRdclCont().set(0);
                hv13001Movdep().movdep().vChkdCont().set(0);
                hv13001Movdep().movdep().cTipoCont().set(0);
                hv13001Movdep().movdep().nsDeposito().set(0);
                hv13001Movdep().movdep().tsInsercao().set("0001-01-01-00.00.00.000000");
            } else {
                hv13001Movdep().movdep().zProcessamento().set("9999-12-31");
                hv13001Movdep().movdep().zMovimento().set("9999-12-31");
                hv13001Movdep().movdep().cMnemEgcOpex().set("9999999");
                hv13001Movdep().movdep().cPaisIsoaOeOpx().set("9999999");
                hv13001Movdep().movdep().cUserid().set("9999999");
                hv13001Movdep().movdep().cPaisIsoaCont().set("9999999");
                hv13001Movdep().movdep().cMoedIsoScta().set("9999999");
                hv13001Movdep().movdep().cOeEgcOpex().set(9999999999L);
                hv13001Movdep().movdep().nJourBbn().set(9999999999L);
                hv13001Movdep().movdep().cOeEgcCont().set(9999999999L);
                hv13001Movdep().movdep().nsRdclCont().set(9999999999L);
                hv13001Movdep().movdep().vChkdCont().set(9999999999L);
                hv13001Movdep().movdep().cTipoCont().set(9999999999L);
                hv13001Movdep().movdep().nsDeposito().set(9999999999L);
                hv13001Movdep().movdep().tsInsercao().set("9999-12-31-23.59.59.999999");
            }
        } else {
            hv13001Movdep().movdep().zProcessamento().set(msgIn().msg().ade().zProcessamentoC());
            hv13001Movdep().movdep().cMnemEgcOpex().set(msgIn().msg().ade().cMnemEgcOpexC());
            hv13001Movdep().movdep().cPaisIsoaOeOpx().set(msgIn().msg().ade().cPaisIsoaOpxC());
            hv13001Movdep().movdep().cOeEgcOpex().set(msgIn().msg().ade().cOeEgcOpexC());
            hv13001Movdep().movdep().cUserid().set(msgIn().msg().ade().cUseridC());
            hv13001Movdep().movdep().nJourBbn().set(msgIn().msg().ade().nJourBbnC());
            hv13001Movdep().movdep().cPaisIsoaCont().set(msgIn().msg().ade().cPaisIsoaContC());
            hv13001Movdep().movdep().cBancCont().set(msgIn().msg().ade().cBancContC());
            hv13001Movdep().movdep().cOeEgcCont().set(msgIn().msg().ade().cOeEgcContC());
            hv13001Movdep().movdep().nsRdclCont().set(msgIn().msg().ade().nsRdclContC());
            hv13001Movdep().movdep().vChkdCont().set(msgIn().msg().ade().vChkdContC());
            hv13001Movdep().movdep().cTipoCont().set(msgIn().msg().ade().cTipoContC());
            hv13001Movdep().movdep().cMoedIsoScta().set(msgIn().msg().ade().cMoedIsoSctaC());
            hv13001Movdep().movdep().nsDeposito().set(msgIn().msg().ade().nsDepositoC());
            hv13001Movdep().movdep().zMovimento().set(msgIn().msg().ade().zMovimentoC());
            hv13001Movdep().movdep().tsInsercao().set(msgIn().msg().ade().tsInsercaoC());
        }
        log(TraceLevel.Debug, "   CAMPOS DA PAGINACAO...       ");
        log(TraceLevel.Debug, "   VGH13001-TS-INSERCAO       : ", hv13001Movdep().movdep().tsInsercao());
        /**
         * *----CONTA*
         */
        if (swSwitchs().swTpConsContaAsc().isTrue()) {
            if (msgIn().msg().ade().nCheque().isEqual(0)) {
                /**
                 * Migration Note:
                 * call to extracted method to access (OPEN) cursor CRS_CONTA_2_ASC
                 */
                hv13001Movdep().openPghs141a4808(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
            } else {
                /**
                 * Migration Note:
                 * call to extracted method to access (OPEN) cursor CRS_CONTA_ASC
                 */
                hv13001Movdep().openPghs141a4812(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
            }
        }
        if (swSwitchs().swTpConsContaDesc().isTrue()) {
            if (msgIn().msg().ade().nCheque().isEqual(0)) {
                /**
                 * Migration Note:
                 * call to extracted method to access (OPEN) cursor CRS_CONTA_2_DESC
                 */
                hv13001Movdep().openPghs141a4820(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
            } else {
                /**
                 * Migration Note:
                 * call to extracted method to access (OPEN) cursor CRS_CONTA_DESC
                 */
                hv13001Movdep().openPghs141a4824(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
            }
        }
        /**
         * *----CLIENTE*
         */
        if (swSwitchs().swTpConsClienteAsc().isTrue() || swSwitchs().swTpConsClienteDesc().isTrue()) {
            log(TraceLevel.Debug, "   WS-DOC-CLI-LINHA : ");
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc1(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId1(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId1());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc2(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId2(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId2());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc3(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId3(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId3());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc4(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId4(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId4());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc5(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId5(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId5());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc6(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId6(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId6());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc7(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId7(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId7());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc8(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId8(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId8());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc9(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId9(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId9());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc10(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId10(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId10());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc11(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId11(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId11());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc12(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId12(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId12());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc13(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId13(), " ", wsTabelasInternas().wsDocCliLinha().wsNDocId13());
            log(TraceLevel.Debug, " ", wsTabelasInternas().wsDocCliLinha().wsCPaisIsaEmsDoc14(), wsTabelasInternas().wsDocCliLinha().wsCTipoDocId14(), wsTabelasInternas().wsDocCliLinha().wsNDocId14());
        }
        if (swSwitchs().swTpConsClienteAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_CLIENTE_ASC
             */
            hv13001Movdep().openPghs141a4882(wsTabelasInternas().wsDocCliLinha(), msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        if (swSwitchs().swTpConsClienteDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_CLIENTE_DESC
             */
            hv13001Movdep().openPghs141a4888(wsTabelasInternas().wsDocCliLinha(), msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        /**
         * *----DOCUMENTO*
         */
        if (swSwitchs().swTpConsDocumAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_DOC_ASC
             */
            hv13001Movdep().openPghs141a4896(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        if (swSwitchs().swTpConsDocumDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_DOC_DESC
             */
            hv13001Movdep().openPghs141a4902(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        /**
         * *----NOME*
         */
        if (swSwitchs().swTpConsNomeAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_NOME_ASC
             */
            hv13001Movdep().openPghs141a4909(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        if (swSwitchs().swTpConsNomeDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_NOME_DESC
             */
            hv13001Movdep().openPghs141a4915(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        /**
         * *----ORDENS TRANSF.
         */
        if (swSwitchs().swTpConsOrdemAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_ORDEM_ASC
             */
            hv13001Movdep().openPghs141a4922(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        if (swSwitchs().swTpConsOrdemDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_ORDEM_DESC
             */
            hv13001Movdep().openPghs141a4928(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        /**
         * *----MONTANTE*
         */
        if (swSwitchs().swTpConsMontAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_MONT_ASC
             */
            hv13001Movdep().openPghs141a4935(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        if (swSwitchs().swTpConsMontDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (OPEN) cursor CRS_MONT_DESC
             */
            hv13001Movdep().openPghs141a4941(msgIn().msg().ade(), wsVariaveis().wsCTipoOpeCont1(), wsVariaveis().wsCTipoOpeCont2(), wsVariaveis().wsCTipoOpeCont3(), wsVariaveis().wsCTipoOpeCont4(), wsVariaveis().wsCTipoOpeCont5(), wsVariaveis().wsCTipoOpeCont6(), wsVariaveis().wsCTipoOpeCont7(), wsVariaveis().wsICliCgd1(), wsVariaveis().wsICliCgd2(), wsVariaveis().wsCTipoItvtDep1(), wsVariaveis().wsCTipoItvtDep2(), wsVariaveis().wsCTipoItvtDep3(), wsVariaveis().wsCTipoItvtDep4(), wsVariaveis().wsCTipoItvtDep5(), wsVariaveis().wsCTipoItvtDep6(), wsVariaveis().wsCTipoItvtDep7(), wsVariaveis().wsCrit1(), wsVariaveis().wsCrit2(), wsVariaveis().wsCrit3()) ;
        }
        swSwitchs().swSqlcodeVgh13001().set(getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(getPersistenceCode());
        log(TraceLevel.Debug, "   *****************************");
        log(TraceLevel.Debug, "      SW-SQLCODE-VGH13001     : ", wsVariaveis().wsSqlcodeErro());
        log(TraceLevel.Debug, "   *****************************");
        bhtp0008M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue()) {
            messageV2.mensagem().abendDb2().setTrue() ;
            messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
            messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(getPersistenceCode());
        }
    }
    
    /**
     * 
     * 2200-LER-CURSOR
     * 
     */
    protected void m2200LerCursor() {
        log(TraceLevel.Debug, "  2200-LER-CURSOR");
        log(TraceLevel.Debug, "   SW-I-MODO-PESQ           : ", swSwitchs().swIModoPesq());
        if (swSwitchs().swTpConsContaAsc().isTrue()) {
            if (msgIn().msg().ade().nCheque().isEqual(0)) {
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor CRS_CONTA_2_ASC
                 */
                hv13001Movdep().fetchPghs141a4983() ;
            } else {
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor CRS_CONTA_ASC
                 */
                hv13001Movdep().fetchPghs141a5044() ;
            }
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsContaDesc().isTrue()) {
            if (msgIn().msg().ade().nCheque().isEqual(0)) {
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor CRS_CONTA_2_DESC
                 */
                hv13001Movdep().fetchPghs141a5109() ;
            } else {
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor CRS_CONTA_DESC
                 */
                hv13001Movdep().fetchPghs141a5170() ;
            }
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsClienteAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_CLIENTE_ASC
             */
            hv13001Movdep().fetchPghs141a5234() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsClienteDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_CLIENTE_DESC
             */
            hv13001Movdep().fetchPghs141a5297() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsDocumAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_DOC_ASC
             */
            hv13001Movdep().fetchPghs141a5360() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsDocumDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_DOC_DESC
             */
            hv13001Movdep().fetchPghs141a5423() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsNomeAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_NOME_ASC
             */
            hv13001Movdep().fetchPghs141a5486() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsNomeDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_NOME_DESC
             */
            hv13001Movdep().fetchPghs141a5549() ;
        }
        /**
         * *----ORDENS TRANSF.
         */
        if (swSwitchs().swTpConsOrdemAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_ORDEM_ASC
             */
            hv13001Movdep().fetchPghs141a5613() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsOrdemDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_ORDEM_DESC
             */
            hv13001Movdep().fetchPghs141a5676() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsMontAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_MONT_ASC
             */
            hv13001Movdep().fetchPghs141a5739() ;
        }
        /**
         * --
         */
        if (swSwitchs().swTpConsMontDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor CRS_MONT_DESC
             */
            hv13001Movdep().fetchPghs141a5802() ;
        }
        swSwitchs().swSqlcodeVgh13001().set(getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(getPersistenceCode());
        log(TraceLevel.Debug, "   *****************************");
        log(TraceLevel.Debug, "      SW-SQLCODE-VGH13001     : ", wsVariaveis().wsSqlcodeErro());
        log(TraceLevel.Debug, "   *****************************");
        bhtp0008M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue() && !swSwitchs().swVgh13001Notfnd().isTrue()) {
            messageV2.mensagem().abendDb2().setTrue() ;
            messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
            messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(getPersistenceCode());
        }
    }
    
    /**
     * 
     * 2300-CICLO
     * 
     */
    protected void m2300Ciclo() {
        log(TraceLevel.Debug, "  2300-CICLO");
        /**
         * -- VALIDAR SE O ESTADO DA ORDEM E FINAL
         */
        swSwitchs().swCEstMsgSwif().set(hv13001Movdep().movdep().cEstMsgSwif());
        wsVariaveis().wsCEstMsgSwifTemp().set(hv13001Movdep().movdep().cEstMsgSwif());
        log(TraceLevel.Debug, "   SW-C-EST-MSG-SWIF 1      : ", swSwitchs().swCEstMsgSwif());
        log(TraceLevel.Debug, "   .........................");
        log(TraceLevel.Debug, "   VGH13001-C-PAIS-ISO-ALFN : ", hv13001Movdep().movdep().cPaisIsoAlfn());
        log(TraceLevel.Debug, "   VGH13001-C-TIPO-OPE-CONT : ", hv13001Movdep().movdep().cTipoOpeCont());
        if (hv13001Movdep().movdep().cPaisIsoAlfn().isEmpty() || 
            (!hv13001Movdep().movdep().cTipoOpeCont().isEqual(CON_ORDENS_EMITIDAS) && 
            !hv13001Movdep().movdep().cTipoOpeCont().isEqual(CON_ORDENS_RECEBIDAS))) {
            /**
             * NAO SE TRATA DE SGOE O REGISTO
             */
            m2310FormataOut() ;
        } else if (swSwitchs().swEstFinalValidos().isTrue()) {
            m2310FormataOut() ;
        } else {
            m2320ValEstMsgSwif() ;
            if (messageV2.mensagem().semErros().isTrue() && swSwitchs().swEstFinalValidos().isTrue()) {
                m2310FormataOut() ;
            }
        }
        if (messageV2.mensagem().semErros().isTrue() && !msgOut().paginaCheia().isTrue()) {
            m2200LerCursor() ;
        }
    }
    
    /**
     * 
     * 2310-FORMATA-OUT
     * 
     */
    protected void m2310FormataOut() {
        log(TraceLevel.Debug, "   2310-FORMATA-OUT   ");
        msgOut().indice().add(CON_1N);
        wsVariaveis().wsCountIndice().add(CON_1N);
        /**
         * --
         */
        msgOut().msg().ade().linha().get(msgOut().indice()).zProcessamentoL().set(hv13001Movdep().movdep().zProcessamento());
        msgOut().msg().ade().linha().get(msgOut().indice()).cMnemEgcOpexL().set(hv13001Movdep().movdep().cMnemEgcOpex());
        msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoaOpxL().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        msgOut().msg().ade().linha().get(msgOut().indice()).cOeEgcOpexL().set(hv13001Movdep().movdep().cOeEgcOpex());
        msgOut().msg().ade().linha().get(msgOut().indice()).cUseridL().set(hv13001Movdep().movdep().cUserid());
        msgOut().msg().ade().linha().get(msgOut().indice()).nJourBbnL().set(hv13001Movdep().movdep().nJourBbn());
        msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoaContL().set(hv13001Movdep().movdep().cPaisIsoaCont());
        msgOut().msg().ade().linha().get(msgOut().indice()).cBancContL().set(hv13001Movdep().movdep().cBancCont());
        msgOut().msg().ade().linha().get(msgOut().indice()).cOeEgcContL().set(hv13001Movdep().movdep().cOeEgcCont());
        msgOut().msg().ade().linha().get(msgOut().indice()).nsRdclContL().set(hv13001Movdep().movdep().nsRdclCont());
        msgOut().msg().ade().linha().get(msgOut().indice()).vChkdContL().set(hv13001Movdep().movdep().vChkdCont());
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipoContL().set(hv13001Movdep().movdep().cTipoCont());
        msgOut().msg().ade().linha().get(msgOut().indice()).cMoedIsoSctaL().set(hv13001Movdep().movdep().cMoedIsoScta());
        msgOut().msg().ade().linha().get(msgOut().indice()).nsDepositoL().set(hv13001Movdep().movdep().nsDeposito());
        msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoAlfnL().set(hv13001Movdep().movdep().cPaisIsoAlfn());
        msgOut().msg().ade().linha().get(msgOut().indice()).cMnemEmpGcxL().set(hv13001Movdep().movdep().cMnemEmpGcx());
        msgOut().msg().ade().linha().get(msgOut().indice()).cRefMsgSwifL().set(hv13001Movdep().movdep().cRefMsgSwif());
        msgOut().msg().ade().linha().get(msgOut().indice()).cEstMsgSwifL().set(hv13001Movdep().movdep().cEstMsgSwif());
        msgOut().msg().ade().linha().get(msgOut().indice()).nChequeL().set(hv13001Movdep().movdep().nCheque());
        msgOut().msg().ade().linha().get(msgOut().indice()).zMovimentoL().set(hv13001Movdep().movdep().zMovimento());
        msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIEmsDocL().set(hv13001Movdep().movdep().cPaisIsaEmsDoc());
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdL().set(hv13001Movdep().movdep().cTipoDocId());
        msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdL().set(hv13001Movdep().movdep().nDocId());
        log(TraceLevel.Debug, "VGH13001-C-ENT-EMIX-DOC-ID ", hv13001Movdep().movdep().cEntEmixDocId());
        if ((hv13001Movdep().movdep().cEntEmixDocId().isEqual(CON_9901VITAL) || 
            hv13001Movdep().movdep().cEntEmixDocId().isEqual(CON_9902VITAL) || 
            hv13001Movdep().movdep().cEntEmixDocId().isEqual(CON_9903VITAL) || 
            hv13001Movdep().movdep().cEntEmixDocId().isEqual(CON_9901VTSSO2) || 
            hv13001Movdep().movdep().cEntEmixDocId().isEqual(CON_9902VTSSO2) || 
            hv13001Movdep().movdep().cEntEmixDocId().isEqual(CON_9903VTSSO2)) && 
            hv13001Movdep().movdep().zVldeDocId().isEqual(CON_DATA_MAX)) {
            msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdL().set(CON_DATA_MAX_VIT);
            log(TraceLevel.Debug, "DTA MÁXIMA ", msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdL());
        } else {
            msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdL().set(hv13001Movdep().movdep().zVldeDocId());
            log(TraceLevel.Debug, "DTA DE VALIDADE DOC ", msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdL());
        }
        /**
         * MOVE VGH13001-Z-VLDE-DOC-ID     TO
         * BGHM1141-Z-VLDE-DOC-ID-L         (BGHM1141-INDICE).
         * *PASS2972 - FIM
         */
        msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmiDocIdL().set(hv13001Movdep().movdep().cEntEmixDocId());
        msgOut().msg().ade().linha().get(msgOut().indice()).cPaisEmsDocAL().set(hv13001Movdep().movdep().cPaisEmsDocApt());
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdApL().set(hv13001Movdep().movdep().cTipoDocIdAptd());
        msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdAptdL().set(hv13001Movdep().movdep().nDocIdAptd());
        msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdApL().set(hv13001Movdep().movdep().zVldeDocIdAptd());
        msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmiDidApL().set(hv13001Movdep().movdep().cEntEmiDidAptd());
        msgOut().msg().ade().linha().get(msgOut().indice()).cPaisEmsDocRL().set(hv13001Movdep().movdep().cPaisEmsDocRpt());
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdRpL().set(hv13001Movdep().movdep().cTipoDocIdRprt());
        msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdRprtL().set(hv13001Movdep().movdep().nDocIdRprt());
        msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdRpL().set(hv13001Movdep().movdep().zVldeDocIdRprt());
        msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmixDidRL().set(hv13001Movdep().movdep().cEntEmixDidRpt());
        msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplL().set(hv13001Movdep().movdep().nmCliente());
        msgOut().msg().ade().linha().get(msgOut().indice()).iCliCgdL().set(hv13001Movdep().movdep().iCliCgd());
        /**
         * -- AVALIA VGH13001-C-TIPO-OPE-CONT
         */
        swSwitchs().swCTipoOpeContL().set(hv13001Movdep().movdep().cTipoOpeCont());
        if (swSwitchs().swEntregaL().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL().set(CON_ENTREGA);
        } else if (swSwitchs().swLevantamentosL().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL().set(CON_LEVANTAMENTO);
        } else if (swSwitchs().swCambioL().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL().set(CON_CAMBIO);
        } else if (swSwitchs().swTrocoDestrocoL().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL().set(CON_TROCO_DESTROCO);
        } else if (swSwitchs().swTransferenciasL().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL().set(CON_TRANSFERENCIAS);
        } else if (swSwitchs().swOcasionaisL().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL().set(CON_OCASIONAIS);
        }
        if (hv13001Movdep().movdep().iCliCgd().isEqual(CON_SIM)) {
            if (swSwitchs().swTpConsClienteAsc().isTrue() || swSwitchs().swTpConsClienteDesc().isTrue()) {
                msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(bhjl006a().commarea().dadosEntrada().nCliente());
                msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL().set(bhjl006a().commarea().dadosSaida().nsAbraCli());
            } else if (hv13001Movdep().movdep().cTipoItvtDep().isEqual(CON_DEP_EXPRESSO)) {
                msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(0);
                msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL().set(0);
                msgOut().msg().ade().linha().get(msgOut().indice()).iCliCgdL().set(CON_SIM);
            } else if (messageV2.mensagem().semErros().isTrue()) {
                m2311ObtemNCliente() ;
            }
        } else if (swSwitchs().swCambioL().isTrue() || swSwitchs().swTrocoDestrocoL().isTrue() || 
            swSwitchs().swTransferenciasL().isTrue() || 
            swSwitchs().swOcasionaisL().isTrue()) {
            if (messageV2.mensagem().semErros().isTrue()) {
                m2312ObtemNaoCliCgd() ;
            }
        } else {
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(0);
            msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL().set(0);
        }
        msgOut().msg().ade().linha().get(msgOut().indice()).iRprtCliCgd().set(hv13001Movdep().movdep().iRprtCliCgd());
        if (messageV2.mensagem().semErros().isTrue() && 
            !hv13001Movdep().movdep().iRprtCliCgd().isEmpty()) {
            if (hv13001Movdep().movdep().iRprtCliCgd().isEqual(CON_SIM)) {
                m2313ObtemRprtCgd() ;
            }
            if (hv13001Movdep().movdep().iRprtCliCgd().isEqual(CON_NAO)) {
                m2316ObtemRprtNCgd() ;
            }
        }
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipoItvtDepL().set(hv13001Movdep().movdep().cTipoItvtDep());
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipoMdtiL().set(hv13001Movdep().movdep().cTipoMdti());
        msgOut().msg().ade().linha().get(msgOut().indice()).iDbcrL().set(hv13001Movdep().movdep().iDbcr());
        msgOut().msg().ade().linha().get(msgOut().indice()).mMovEuroL().set(hv13001Movdep().movdep().mMovEuro());
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipoCanlAcesL().set(hv13001Movdep().movdep().cTipoCanlAces());
        if (messageV2.mensagem().semErros().isTrue()) {
            if (hv13001Movdep().movdep().cTipoCanlAces().isEqual("ATS")) {
                m2318ObtemXInfAts() ;
            } else {
                msgOut().msg().ade().linha().get(msgOut().indice()).xInfAtsL().set(" ");
            }
        }
        msgOut().msg().ade().linha().get(msgOut().indice()).iTrnzEfcdOnlnL().set(hv13001Movdep().movdep().iTrnzEfcdOnln());
        msgOut().msg().ade().linha().get(msgOut().indice()).iPedJstzOFndL().set(hv13001Movdep().movdep().iPedJstzOrmFnd());
        msgOut().msg().ade().linha().get(msgOut().indice()).cMtvoPedJstzL().set(hv13001Movdep().movdep().cMtvoPedJstz());
        msgOut().msg().ade().linha().get(msgOut().indice()).iRcsJstzOFndL().set(hv13001Movdep().movdep().iRcsJstzOrmFnd());
        msgOut().msg().ade().linha().get(msgOut().indice()).iEstornoL().set(hv13001Movdep().movdep().iEstorno());
        msgOut().msg().ade().linha().get(msgOut().indice()).qMoedaL().set(hv13001Movdep().movdep().qMoeda());
        /**
         * PASSIVAS 4497 (INICIO)
         */
        msgOut().msg().ade().linha().get(msgOut().indice()).cTipRelDepL().set(hv13001Movdep().movdep().cTipoRelDpst());
        msgOut().msg().ade().linha().get(msgOut().indice()).xInfJstzDepL().set(hv13001Movdep().movdep().xInfJstzDep());
        /**
         * PASSIVAS 4497 (FIM)
         */
        msgOut().msg().ade().linha().get(msgOut().indice()).tsInsercaoL().set(hv13001Movdep().movdep().tsInsercao());
        log(TraceLevel.Debug, "  *****************************  ");
        log(TraceLevel.Debug, "  ***  OCORRENCIA DE LISTA  ***  ");
        log(TraceLevel.Debug, "  *****************************  ");
        log(TraceLevel.Debug, "  LINHA ", wsVariaveis().wsCountIndice());
        log(TraceLevel.Debug, "  -------------------------------");
        log(TraceLevel.Debug, "  BGHM1141-Z-PROCESSAMENTO-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).zProcessamentoL());
        log(TraceLevel.Debug, "  BGHM1141-C-MNEM-EGC-OPEX-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).cMnemEgcOpexL());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-ISOA-OPX-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoaOpxL());
        log(TraceLevel.Debug, "  BGHM1141-C-OE-EGC-OPEX-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).cOeEgcOpexL());
        log(TraceLevel.Debug, "  BGHM1141-C-USERID-L          : ", msgOut().msg().ade().linha().get(msgOut().indice()).cUseridL());
        log(TraceLevel.Debug, "  BGHM1141-N-JOUR-BBN-L        : ", msgOut().msg().ade().linha().get(msgOut().indice()).nJourBbnL());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-ISOA-CONT-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoaContL());
        log(TraceLevel.Debug, "  BGHM1141-C-BANC-CONT-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).cBancContL());
        log(TraceLevel.Debug, "  BGHM1141-C-OE-EGC-CONT-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).cOeEgcContL());
        log(TraceLevel.Debug, "  BGHM1141-NS-RDCL-CONT-L      : ", msgOut().msg().ade().linha().get(msgOut().indice()).nsRdclContL());
        log(TraceLevel.Debug, "  BGHM1141-V-CHKD-CONT-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).vChkdContL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-CONT-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoContL());
        log(TraceLevel.Debug, "  BGHM1141-C-MOED-ISO-SCTA-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).cMoedIsoSctaL());
        log(TraceLevel.Debug, "  BGHM1141-NS-DEPOSITO-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).nsDepositoL());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-ISO-ALFN-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIsoAlfnL());
        log(TraceLevel.Debug, "  BGHM1141-C-MNEM-EMP-GCX-L    : ", msgOut().msg().ade().linha().get(msgOut().indice()).cMnemEmpGcxL());
        log(TraceLevel.Debug, "  BGHM1141-C-REF-MSG-SWIF-L    : ", msgOut().msg().ade().linha().get(msgOut().indice()).cRefMsgSwifL());
        log(TraceLevel.Debug, "  BGHM1141-C-EST-MSG-SWIF-L    : ", msgOut().msg().ade().linha().get(msgOut().indice()).cEstMsgSwifL());
        log(TraceLevel.Debug, "  BGHM1141-N-CHEQUE-L          : ", msgOut().msg().ade().linha().get(msgOut().indice()).nChequeL());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-I-EMS-DOC-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cPaisIEmsDocL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-DOC-ID-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdL());
        log(TraceLevel.Debug, "  BGHM1141-N-DOC-ID-L          : ", msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdL());
        log(TraceLevel.Debug, "  BGHM1141-Z-VLDE-DOC-ID-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdL());
        log(TraceLevel.Debug, "  BGHM1141-C-ENT-EMI-DOC-ID-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmiDocIdL());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-EMS-DOC-A-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cPaisEmsDocAL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-DOC-ID-AP-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdApL());
        log(TraceLevel.Debug, "  BGHM1141-N-DOC-ID-APTD-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdAptdL());
        log(TraceLevel.Debug, "  BGHM1141-Z-VLDE-DOC-ID-AP-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdApL());
        log(TraceLevel.Debug, "  BGHM1141-C-ENT-EMI-DID-AP-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmiDidApL());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-EMS-DOC-R-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cPaisEmsDocRL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-DOC-ID-RP-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoDocIdRpL());
        log(TraceLevel.Debug, "  BGHM1141-N-DOC-ID-RPRT-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).nDocIdRprtL());
        log(TraceLevel.Debug, "  BGHM1141-Z-VLDE-DOC-ID-RP-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).zVldeDocIdRpL());
        log(TraceLevel.Debug, "  BGHM1141-C-ENT-EMIX-DID-R-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cEntEmixDidRL());
        log(TraceLevel.Debug, "  BGHM1141-I-CLI-CGD-L         : ", msgOut().msg().ade().linha().get(msgOut().indice()).iCliCgdL());
        log(TraceLevel.Debug, "  BGHM1141-N-CLIENTE-L         : ", msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL());
        log(TraceLevel.Debug, "  BGHM1141-NS-ABRA-CLI-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL());
        log(TraceLevel.Debug, "  BGHM1141-NM-CLI-COMPL-L      : ", msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplL());
        log(TraceLevel.Debug, "  BGHM1141-I-RPRT-CLI-CGD      : ", msgOut().msg().ade().linha().get(msgOut().indice()).iRprtCliCgd());
        log(TraceLevel.Debug, "  BGHM1141-N-CLIENTE-RPRT-L    : ", msgOut().msg().ade().linha().get(msgOut().indice()).nClienteRprtL());
        log(TraceLevel.Debug, "  BGHM1141-NS-ABRA-CLI-RPRT-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliRprtL());
        log(TraceLevel.Debug, "  BGHM1141-NM-CLI-COMPL-RPR-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplRprL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-ITVT-DEP-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoItvtDepL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-MDTI-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoMdtiL());
        log(TraceLevel.Debug, "  BGHM1141-Z-MOVIMENTO-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).zMovimentoL());
        log(TraceLevel.Debug, "  BGHM1141-I-DBCR-L            : ", msgOut().msg().ade().linha().get(msgOut().indice()).iDbcrL());
        log(TraceLevel.Debug, "  BGHM1141-M-MOV-EURO-L        : ", msgOut().msg().ade().linha().get(msgOut().indice()).mMovEuroL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-CANL-ACES-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoCanlAcesL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-OPE-CONT-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipoOpeContL());
        log(TraceLevel.Debug, "  BGHM1141-I-TRNZ-EFCD-ONLN-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).iTrnzEfcdOnlnL());
        log(TraceLevel.Debug, "  BGHM1141-I-PED-JSTZ-O-FND-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).iPedJstzOFndL());
        log(TraceLevel.Debug, "  BGHM1141-C-MTVO-PED-JSTZ-L   : ", msgOut().msg().ade().linha().get(msgOut().indice()).cMtvoPedJstzL());
        log(TraceLevel.Debug, "  BGHM1141-I-RCS-JSTZ-O-FND-L  : ", msgOut().msg().ade().linha().get(msgOut().indice()).iRcsJstzOFndL());
        log(TraceLevel.Debug, "  BGHM1141-I-ESTORNO-L         : ", msgOut().msg().ade().linha().get(msgOut().indice()).iEstornoL());
        log(TraceLevel.Debug, "  BGHM1141-Q-MOEDA-L           : ", msgOut().msg().ade().linha().get(msgOut().indice()).qMoedaL());
        log(TraceLevel.Debug, "  BGHM1141-C-TIP-REL-DEP-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).cTipRelDepL());
        log(TraceLevel.Debug, "  BGHM1141-X-INF-JSTZ-DEP-L    : ", msgOut().msg().ade().linha().get(msgOut().indice()).xInfJstzDepL());
        log(TraceLevel.Debug, "  BGHM1141-TS-INSERCAO-L       : ", msgOut().msg().ade().linha().get(msgOut().indice()).tsInsercaoL());
        log(TraceLevel.Debug, "  BGHM1141-X-INF-ATS-L         : ", msgOut().msg().ade().linha().get(msgOut().indice()).xInfAtsL());
        log(TraceLevel.Debug, "  *****************************  ");
    }
    
    /**
     * 
     * 2311-OBTEM-N-CLIENTE
     * 
     */
    protected void m2311ObtemNCliente() {
        log(TraceLevel.Debug, "    2311-OBTEM-N-CLIENTE");
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(hv13001Movdep().movdep().cMnemEgcOpex());
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisIsaEmsDoc());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocId());
        bhjl027a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocId());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISOA-OE-OPX: ", bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BHJL027A-C-MNEM-EGC-OPEX   : ", bhjl027a().commarea().dadosEntrada().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISA-EMS-DOC: ", bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BHJL027A-C-TIPO-DOC-ID     : ", bhjl027a().commarea().dadosEntrada().cTipoDocId());
        log(TraceLevel.Debug, "   BHJL027A-N-DOC-ID          : ", bhjl027a().commarea().dadosEntrada().nDocId());
        bhjp5027AcedeMhjj027a() ;
        if (bhjl027a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(bhjl027a().commarea().dadosSaida().nCliente());
            msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL().set(bhjl027a().commarea().dadosSaida().nsAbraCli());
        } else {
            if (bhjl027a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(0);
                msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL().set(0);
                msgOut().msg().ade().linha().get(msgOut().indice()).iCliCgdL().set(CON_VARIOS_CLI_CGD);
            } else {
                messageV2.mensagem().aAplErro().set(bhjl027a().commarea().erros().aAplErr());
                messageV2.mensagem().cTipoErroBbn().set(bhjl027a().commarea().erros().cTipoErroBbn());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
                messageV2.mensagem().cRtnoSwal().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
            }
            log(TraceLevel.Debug, "   ----------------------------------");
            log(TraceLevel.Debug, "   ERRO VALIDO 2311-OBTEM-N-CLIENTE  ");
            log(TraceLevel.Debug, "   ----------------------------------");
            log(TraceLevel.Debug, "    BGHM1141-I-CLI-CGD-L     : ", msgOut().msg().ade().linha().get(msgOut().indice()).iCliCgdL());
            log(TraceLevel.Debug, "   ---------------------------");
            log(TraceLevel.Debug, "    BHJL027A-A-APL-ERR       : ", bhjl027a().commarea().erros().aAplErr());
            log(TraceLevel.Debug, "    BHJL027A-C-RTNO-EVEN-SWAL: ", bhjl027a().commarea().erros().cRtnoEvenSwal());
            log(TraceLevel.Debug, "        CLIENTE-NAO-EXISTE..... +002");
            log(TraceLevel.Debug, "        INPUT-INSUF............ +501");
            log(TraceLevel.Debug, "        CLIENTE-CONFIDENCIAL... +506");
            log(TraceLevel.Debug, "        DOC-NAO-EXIS........... +535");
            log(TraceLevel.Debug, "        DOC-REPETIDO........... +536");
            log(TraceLevel.Debug, "        CLI-CANCELADO.......... +622");
            log(TraceLevel.Debug, "    BHJL027A-C-TIPO-ERRO-BBN : ", bhjl027a().commarea().erros().cTipoErroBbn());
            log(TraceLevel.Debug, "    BHJL027A-C-SQLCODE       : ", bhjl027a().commarea().erros().cSqlcode());
            log(TraceLevel.Debug, "    BHJL027A-NM-TABELA       : ", bhjl027a().commarea().erros().nmTabela());
            log(TraceLevel.Debug, "   ---------------------------");
        }
    }
    
    /**
     * 
     * 2312-OBTEM-NAO-CLI-CGD
     * 
     */
    protected void m2312ObtemNaoCliCgd() {
        log(TraceLevel.Debug, "    2312-OBTEM-NAO-CLI-CGD");
        bhel100a().commarea().initialize() ;
        bhel100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bhel100a().commarea().dadosEntrada().iOperacao().set(CON_3N);
        bhel100a().commarea().dadosEntrada().cPaisIsoaOpe().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhel100a().commarea().dadosEntrada().cMnemEgcOpe().set(hv13001Movdep().movdep().cMnemEgcOpex());
        bhel100a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisIsaEmsDoc());
        bhel100a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocId());
        bhel100a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocId());
        bhep5100TabNaoClientes() ;
        log(TraceLevel.Debug, "   SAIDA MHEJ100A...           ");
        log(TraceLevel.Debug, "     BHEL100A-N-PRCP-NCLI-S  : ", bhel100a().commarea().dadosSaida().nPrcpNcliS());
        if (bhel100a().commarea().dadosSaida().semErros().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteL().set(bhel100a().commarea().dadosSaida().nPrcpNcliS());
            msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliL().set(0);
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
            envOut.db2Log().nmTabela().set(bhel100a().commarea().dadosSaida().nmTabela());
            if (bhel100a().commarea().dadosSaida().errosFuncao().isTrue()) {
                messageV2.mensagem().aAplErro().set(bhel100a().commarea().dadosSaida().aAplErr());
                messageV2.mensagem().cTipoErroBbn().set(bhel100a().commarea().dadosSaida().cTipoErroBbn());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-14");
            } else {
                messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
                messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-15");
            }
            log(TraceLevel.Error, "   ERRO NO 2312-OBTEM-NAO-CLI-CGD - MHEJ100A");
            log(TraceLevel.Error, "   BHEL100A-C-TIPO-ERRO-BBN  : ", bhel100a().commarea().dadosSaida().cTipoErroBbn());
            log(TraceLevel.Error, "   BHEL100A-A-APL-ERR        : ", bhel100a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "   BHEL100A-C-RTNO-EVEN-SWAL : ", bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "   BHEL100A-C-SQLCODE        : ", bhel100a().commarea().dadosSaida().cSqlcode());
            log(TraceLevel.Error, "   BHEL100A-NM-TABELA        : ", bhel100a().commarea().dadosSaida().nmTabela());
        }
    }
    
    /**
     * 
     * 2313-OBTEM-RPRT-CGD
     * 
     */
    protected void m2313ObtemRprtCgd() {
        log(TraceLevel.Debug, "    2313-OBTEM-RPRT-CGD    ");
        if (messageV2.mensagem().semErros().isTrue()) {
            m2314ObtemNCliRprt() ;
        }
    }
    
    /**
     * 
     * 2314-OBTEM-N-CLI-RPRT
     * 
     */
    protected void m2314ObtemNCliRprt() {
        log(TraceLevel.Debug, "  2314-OBTEM-N-CLI-RPRT  ");
        bhjl027a().commarea().initialize() ;
        bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhjl027a().commarea().dadosEntrada().cMnemEgcOpex().set(hv13001Movdep().movdep().cMnemEgcOpex());
        bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisEmsDocRpt());
        bhjl027a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocIdRprt());
        bhjl027a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocIdRprt());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISOA-OE-OPX: ", bhjl027a().commarea().dadosEntrada().cPaisIsoaOeOpx());
        log(TraceLevel.Debug, "   BHJL027A-C-MNEM-EGC-OPEX   : ", bhjl027a().commarea().dadosEntrada().cMnemEgcOpex());
        log(TraceLevel.Debug, "   BHJL027A-C-PAIS-ISA-EMS-DOC: ", bhjl027a().commarea().dadosEntrada().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "   BHJL027A-C-TIPO-DOC-ID     : ", bhjl027a().commarea().dadosEntrada().cTipoDocId());
        log(TraceLevel.Debug, "   BHJL027A-N-DOC-ID          : ", bhjl027a().commarea().dadosEntrada().nDocId());
        bhjp5027AcedeMhjj027a() ;
        if (bhjl027a().commarea().erros().semErros().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteRprtL().set(bhjl027a().commarea().dadosSaida().nCliente());
            msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliRprtL().set(bhjl027a().commarea().dadosSaida().nsAbraCli());
            m2315ObtemNomeRprt() ;
        } else {
            if (bhjl027a().commarea().erros().erroFuncao().isTrue()) {
                msgOut().msg().ade().linha().get(msgOut().indice()).nClienteRprtL().set(0);
                msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliRprtL().set(0);
                msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplRprL().set(" ");
                msgOut().msg().ade().linha().get(msgOut().indice()).iRprtCliCgd().set(CON_VARIOS_CLI_CGD);
            } else {
                messageV2.mensagem().aAplErro().set(bhjl027a().commarea().erros().aAplErr());
                messageV2.mensagem().cTipoErroBbn().set(bhjl027a().commarea().erros().cTipoErroBbn());
                envOut.db2Log().sqlca().cSqlcode().set(bhjl027a().commarea().erros().cSqlcode());
                envOut.db2Log().nmTabela().set(bhjl027a().commarea().erros().nmTabela());
                messageV2.mensagem().cRtnoSwal().set(bhjl027a().commarea().erros().cRtnoEvenSwal());
            }
            log(TraceLevel.Debug, "   ---------------------------");
            log(TraceLevel.Debug, "   ERRO 2311-OBTEM-N-CLIENTE  ");
            log(TraceLevel.Debug, "   ---------------------------");
            log(TraceLevel.Debug, "    BGHM1141-I-RPRT-CLI-CGD  : ", msgOut().msg().ade().linha().get(msgOut().indice()).iRprtCliCgd());
            log(TraceLevel.Debug, "   ---------------------------");
            log(TraceLevel.Debug, "    BHJL027A-A-APL-ERR       : ", bhjl027a().commarea().erros().aAplErr());
            log(TraceLevel.Debug, "    BHJL027A-C-RTNO-EVEN-SWAL: ", bhjl027a().commarea().erros().cRtnoEvenSwal());
            log(TraceLevel.Debug, "    BHJL027A-C-TIPO-ERRO-BBN : ", bhjl027a().commarea().erros().cTipoErroBbn());
            log(TraceLevel.Debug, "    BHJL027A-C-SQLCODE       : ", bhjl027a().commarea().erros().cSqlcode());
            log(TraceLevel.Debug, "    BHJL027A-NM-TABELA       : ", bhjl027a().commarea().erros().nmTabela());
            log(TraceLevel.Debug, "   ---------------------------");
        }
    }
    
    /**
     * 
     * 2315-OBTEM-NOME-RPRT
     * 
     */
    protected void m2315ObtemNomeRprt() {
        log(TraceLevel.Debug, "    2315-OBTEM-NOME-RPRT  ");
        bhjl006a().commarea().initialize() ;
        wsVariaveis().wsBhjl006aCPais().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        wsVariaveis().wsBhjl006aCMnem().set(hv13001Movdep().movdep().cMnemEgcOpex());
        wsVariaveis().wsBhjl006aNCli().set(bhjl027a().commarea().dadosSaida().nCliente());
        m1410ValidaCliente() ;
        msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplRprL().set(bhjl006a().commarea().dadosSaida().nmCliente());
    }
    
    /**
     * 
     * 2316-OBTEM-RPRT-N-CGD
     * 
     */
    protected void m2316ObtemRprtNCgd() {
        log(TraceLevel.Debug, "    2316-OBTEM-RPRT-N-CGD ");
        bhel100a().commarea().initialize() ;
        bhel100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bhel100a().commarea().dadosEntrada().iOperacao().set(CON_3N);
        bhel100a().commarea().dadosEntrada().cPaisIsoaOpe().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        bhel100a().commarea().dadosEntrada().cMnemEgcOpe().set(hv13001Movdep().movdep().cMnemEgcOpex());
        bhel100a().commarea().dadosEntrada().cPaisIsaEmsDoc().set(hv13001Movdep().movdep().cPaisEmsDocRpt());
        bhel100a().commarea().dadosEntrada().cTipoDocId().set(hv13001Movdep().movdep().cTipoDocIdRprt());
        bhel100a().commarea().dadosEntrada().nDocId().set(hv13001Movdep().movdep().nDocIdRprt());
        bhep5100TabNaoClientes() ;
        if (bhel100a().commarea().dadosSaida().semErros().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).nClienteRprtL().set(bhel100a().commarea().dadosSaida().nPrcpNcliS());
            msgOut().msg().ade().linha().get(msgOut().indice()).nmCliComplRprL().set(bhel100a().commarea().dadosSaida().nmPrcpNcliS());
            msgOut().msg().ade().linha().get(msgOut().indice()).nsAbraCliRprtL().set(0);
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(bhel100a().commarea().dadosSaida().cSqlcode());
            envOut.db2Log().nmTabela().set(bhel100a().commarea().dadosSaida().nmTabela());
            if (bhel100a().commarea().dadosSaida().errosFuncao().isTrue()) {
                messageV2.mensagem().aAplErro().set(bhel100a().commarea().dadosSaida().aAplErr());
                messageV2.mensagem().cTipoErroBbn().set(bhel100a().commarea().dadosSaida().cTipoErroBbn());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-16");
            } else {
                messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
                messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-17");
            }
            log(TraceLevel.Error, "   ERRO AO OBTER NAO CLIENTE DA ROTINA MHEJ100A");
            log(TraceLevel.Error, "   BHEL100A-C-TIPO-ERRO-BBN  : ", bhel100a().commarea().dadosSaida().cTipoErroBbn());
            log(TraceLevel.Error, "   BHEL100A-A-APL-ERR        : ", bhel100a().commarea().dadosSaida().aAplErr());
            log(TraceLevel.Error, "   BHEL100A-C-RTNO-EVEN-SWAL : ", bhel100a().commarea().dadosSaida().cRtnoEvenSwal());
            log(TraceLevel.Error, "   BHEL100A-C-SQLCODE        : ", bhel100a().commarea().dadosSaida().cSqlcode());
            log(TraceLevel.Error, "   BHEL100A-NM-TABELA        : ", bhel100a().commarea().dadosSaida().nmTabela());
        }
    }
    
    /**
     * 
     * 2318-OBTEM-X-INF-ATS
     * 
     */
    protected void m2318ObtemXInfAts() {
        log(TraceLevel.Debug, "    2318-OBTEM-X-INF-ATS  ");
        hrMdrj402a().bdrl402a().commarea().initialize() ;
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akZProcessamento().set(hv13001Movdep().movdep().zProcessamento());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCPaisIsoaOeRpl().set(hv13001Movdep().movdep().cPaisIsoaOeOpx());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCMnemEgcRspl().set(hv13001Movdep().movdep().cMnemEgcOpex());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCOeEgcRspl().set(hv13001Movdep().movdep().cOeEgcOpex());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akCUserid().set(hv13001Movdep().movdep().cUserid());
        hrMdrj402a().bdrl402a().commarea().dadosInput().accessKey().akNJourBbn().set(hv13001Movdep().movdep().nJourBbn());
        hrMdrj402a().run() ;
        if (hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().semErros().isTrue()) {
            msgOut().msg().ade().linha().get(msgOut().indice()).xInfAtsL().set(concat(CON_ATM_CGD, hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputFields().ofNmLocalidade()));
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCSqlcode());
            envOut.db2Log().nmTabela().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeNmTabela());
            if (hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().errosFuncao().isTrue()) {
                messageV2.mensagem().aAplErro().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeAAplErr());
                messageV2.mensagem().cTipoErroBbn().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCTipoErroBbn());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-18");
            } else {
                messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
                messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-19");
            }
            log(TraceLevel.Error, "   ERRO AO OBTER X-INF-ATS DA ROTINA MDRJ402A");
            log(TraceLevel.Error, "   BDRL402A-OE-C-TIPO-ERRO-BBN : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCTipoErroBbn());
            log(TraceLevel.Error, "   BDRL402A-OE-A-APL-ERR       : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeAAplErr());
            log(TraceLevel.Error, "   BDRL402A-OE-C-RTNO-EVEN-SWAL: ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCRtnoEvenSwal());
            log(TraceLevel.Error, "   BDRL402A-OE-C-SQLCODE       : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeCSqlcode());
            log(TraceLevel.Error, "   BDRL402A-OE-NM-TABELA       : ", hrMdrj402a().bdrl402a().commarea().dadosOutput().wOutputError().oeNmTabela());
        }
    }
    
    /**
     * 
     * 2320-VAL-EST-MSG-SWIF
     * 
     */
    protected void m2320ValEstMsgSwif() {
        log(TraceLevel.Debug, "   2320-VAL-EST-MSG-SWIF");
        bghl300a().commarea().initialize() ;
        bghl300a().commarea().dadosEntrada().visualizacao().setTrue() ;
        bghl300a().commarea().dadosEntrada().cPaisIsoAlfn().set(hv13001Movdep().movdep().cPaisIsoAlfn());
        bghl300a().commarea().dadosEntrada().cMnemEmpGcx().set(hv13001Movdep().movdep().cMnemEmpGcx());
        bghl300a().commarea().dadosEntrada().cRefMsgSwif().set(hv13001Movdep().movdep().cRefMsgSwif());
        bghl300a().commarea().dadosEntrada().cTipoOpeCont().set(hv13001Movdep().movdep().cTipoOpeCont());
        bghl300a().commarea().dadosEntrada().cEstMsgSwifI().set(hv13001Movdep().movdep().cEstMsgSwif());
        bghp1300VerifEstadOrd() ;
        if (bghl300a().commarea().erros().semErros().isTrue()) {
            swSwitchs().swCEstMsgSwif().set(bghl300a().commarea().dadosSaida().cEstMsgSwifO());
            log(TraceLevel.Debug, "   SW-C-EST-MSG-SWIF 2: ", swSwitchs().swCEstMsgSwif());
        } else {
            envOut.db2Log().sqlca().cSqlcode().set(bghl300a().commarea().erros().cSqlcode());
            envOut.db2Log().nmTabela().set(bghl300a().commarea().erros().nmTabela());
            if (bghl300a().commarea().erros().erroFuncao().isTrue()) {
                messageV2.mensagem().aAplErro().set(bghl300a().commarea().erros().aAplErr());
                messageV2.mensagem().cTipoErroBbn().set(bghl300a().commarea().erros().cTipoErroBbn());
                msgOut().msg().ase().cBancContSt().cBancCont1().setTrue() ;
                msgOut().msg().ase().cBancContSt().cBancContM().set(bghl300a().commarea().erros().cRtnoEvenSwal());
                log(TraceLevel.Error, " ERRO-20");
            } else {
                messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().abendDb2());
                messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
                messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
                log(TraceLevel.Error, " ERRO-21");
            }
        }
    }
    
    /**
     * 
     * 2400-FECHAR-CURSOR
     * 
     */
    protected void m2400FecharCursor() {
        log(TraceLevel.Debug, "  2400-FECHAR-CURSOR");
        if (swSwitchs().swTpConsContaAsc().isTrue()) {
            if (msgIn().msg().ade().nCheque().isEqual(0)) {
                /**
                 * Migration Note:
                 * call to extracted method to access (CLOSE) cursor CRS_CONTA_2_ASC
                 */
                hv13001Movdep().closePghs141a6848() ;
            } else {
                /**
                 * Migration Note:
                 * call to extracted method to access (CLOSE) cursor CRS_CONTA_ASC
                 */
                hv13001Movdep().closePghs141a6852() ;
            }
        }
        if (swSwitchs().swTpConsContaDesc().isTrue()) {
            if (msgIn().msg().ade().nCheque().isEqual(0)) {
                /**
                 * Migration Note:
                 * call to extracted method to access (CLOSE) cursor CRS_CONTA_2_DESC
                 */
                hv13001Movdep().closePghs141a6859() ;
            } else {
                /**
                 * Migration Note:
                 * call to extracted method to access (CLOSE) cursor CRS_CONTA_DESC
                 */
                hv13001Movdep().closePghs141a6863() ;
            }
        }
        if (swSwitchs().swTpConsClienteAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_CLIENTE_ASC
             */
            hv13001Movdep().closePghs141a6869() ;
        }
        if (swSwitchs().swTpConsClienteDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_CLIENTE_DESC
             */
            hv13001Movdep().closePghs141a6874() ;
        }
        if (swSwitchs().swTpConsDocumAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_DOC_ASC
             */
            hv13001Movdep().closePghs141a6879() ;
        }
        if (swSwitchs().swTpConsDocumDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_DOC_DESC
             */
            hv13001Movdep().closePghs141a6884() ;
        }
        if (swSwitchs().swTpConsNomeAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_NOME_ASC
             */
            hv13001Movdep().closePghs141a6889() ;
        }
        if (swSwitchs().swTpConsNomeDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_NOME_DESC
             */
            hv13001Movdep().closePghs141a6894() ;
        }
        if (swSwitchs().swTpConsOrdemAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_ORDEM_ASC
             */
            hv13001Movdep().closePghs141a6899() ;
        }
        if (swSwitchs().swTpConsOrdemDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_ORDEM_DESC
             */
            hv13001Movdep().closePghs141a6904() ;
        }
        if (swSwitchs().swTpConsMontAsc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_MONT_ASC
             */
            hv13001Movdep().closePghs141a6909() ;
        }
        if (swSwitchs().swTpConsMontDesc().isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor CRS_MONT_DESC
             */
            hv13001Movdep().closePghs141a6914() ;
        }
        swSwitchs().swSqlcodeVgh13001().set(getPersistenceCode());
        wsVariaveis().wsSqlcodeErro().set(getPersistenceCode());
        log(TraceLevel.Debug, "   *****************************");
        log(TraceLevel.Debug, "      SW-SQLCODE-VGH13001     : ", wsVariaveis().wsSqlcodeErro());
        log(TraceLevel.Debug, "   *****************************");
        bhtp0008M9020Db2check() ;
        if (!swSwitchs().swVgh13001Ok().isTrue() && !swSwitchs().swVgh13001Notfnd().isTrue()) {
            messageV2.mensagem().abendDb2().setTrue() ;
            messageV2.mensagem().aAplErro().set(bhtk0002().siglaArquit());
            messageV2.mensagem().cRtnoSwal().set(bhtk0001().erros().erroDb2());
            envOut.db2Log().nmTabela().set(CON_VGH13001);
            envOut.db2Log().sqlca().cSqlcode().set(getPersistenceCode());
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, " 3000-FIM-PROGRAMA");
        if (messageV2.mensagem().semErros().isTrue() && !msgOut().paginaCheia().isTrue()) {
            msgOut().indiceInverso().subtract(msgOut().indice());
            msgOut().diminuiLength().set(multiply(msgOut().indiceInverso(), msgOut().lengthOccur()));
            msgOut().qCterCmptAlig().subtract(msgOut().diminuiLength());
            messageV2.mensagem().cTipoErroBbn().set(bhtk0002().indErros().fimConsulta());
        }
        envOut.mensagem().msgOut().set(msgOut().msg()) ;
        messageV2.mensagem().campoLivre11().qCampEstTrnz().set(msgOut().qCampEstTrnz());
        messageV2.mensagem().qCterCmpMsgInp().set(msgOut().qCterCmptAlig());
        log(TraceLevel.Debug, "   BGHM1141-ASE ", msgOut().msg().ase());
        m3100MensagemOutput() ;
        exit() ;
    }
    
    /**
     * 
     * 3100-MENSAGEM-OUTPUT
     * 
     */
    protected void m3100MensagemOutput() {
        log(TraceLevel.Debug, "  3100-MENSAGEM-OUTPUT");
        log(TraceLevel.Debug, " *********************************************");
        log(TraceLevel.Debug, "            O U T P U T                       ");
        log(TraceLevel.Debug, " *********************************************");
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-ISOA-CONT   : ", msgOut().msg().ade().cPaisIsoaCont());
        log(TraceLevel.Debug, "  BGHM1141-C-BANC-CONT        : ", msgOut().msg().ade().cBancCont());
        log(TraceLevel.Debug, "  BGHM1141-C-OE-EGC-CONT      : ", msgOut().msg().ade().cOeEgcCont());
        log(TraceLevel.Debug, "  BGHM1141-NS-RDCL-CONT       : ", msgOut().msg().ade().nsRdclCont());
        log(TraceLevel.Debug, "  BGHM1141-V-CHKD-CONT        : ", msgOut().msg().ade().vChkdCont());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-CONT        : ", msgOut().msg().ade().cTipoCont());
        log(TraceLevel.Debug, "  BGHM1141-C-MOED-ISO-SCTA    : ", msgOut().msg().ade().cMoedIsoScta());
        log(TraceLevel.Debug, "  BGHM1141-NS-DEPOSITO        : ", msgOut().msg().ade().nsDeposito());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-ISO-ALFN    : ", msgOut().msg().ade().cPaisIsoAlfn());
        log(TraceLevel.Debug, "  BGHM1141-C-MNEM-EMP-GCX     : ", msgOut().msg().ade().cMnemEmpGcx());
        log(TraceLevel.Debug, "  BGHM1141-C-REF-MSG-SWIF     : ", msgOut().msg().ade().cRefMsgSwif());
        log(TraceLevel.Debug, "  BGHM1141-N-CHEQUE           : ", msgOut().msg().ade().nCheque());
        log(TraceLevel.Debug, "  BGHM1141-N-CLIENTE          : ", msgOut().msg().ade().nCliente());
        log(TraceLevel.Debug, "  BGHM1141-NS-ABRA-CLI        : ", msgOut().msg().ade().nsAbraCli());
        log(TraceLevel.Debug, "  BGHM1141-C-PAIS-ISA-EMS-DOC : ", msgOut().msg().ade().cPaisIsaEmsDoc());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-DOC-ID      : ", msgOut().msg().ade().cTipoDocId());
        log(TraceLevel.Debug, "  BGHM1141-N-DOC-ID           : ", msgOut().msg().ade().nDocId());
        log(TraceLevel.Debug, "  BGHM1141-NM-CLI-COMPL       : ", msgOut().msg().ade().nmCliCompl());
        log(TraceLevel.Debug, "  BGHM1141-M-MOV-NMRI-MIN     : ", msgOut().msg().ade().mMovNmriMin());
        log(TraceLevel.Debug, "  BGHM1141-M-MOV-NMRI-MAX     : ", msgOut().msg().ade().mMovNmriMax());
        log(TraceLevel.Debug, "  BGHM1141-I-CRIT-DBCR        : ", msgOut().msg().ade().iCritDbcr());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-OPE-CONT    : ", msgOut().msg().ade().cTipoOpeCont());
        log(TraceLevel.Debug, "  BGHM1141-I-CLI-CGD          : ", msgOut().msg().ade().iCliCgd());
        log(TraceLevel.Debug, "  BGHM1141-C-TIPO-ITVT-DEP    : ", msgOut().msg().ade().cTipoItvtDep());
        log(TraceLevel.Debug, "  BGHM1141-I-CONSULTA         : ", msgOut().msg().ade().iConsulta());
        log(TraceLevel.Debug, "  BGHM1141-Z-MOVIMENTO-MIN    : ", msgOut().msg().ade().zMovimentoMin());
        log(TraceLevel.Debug, "  BGHM1141-Z-MOVIMENTO-MAX    : ", msgOut().msg().ade().zMovimentoMax());
        log(TraceLevel.Debug, "  BGHM1141-I-MODO-PESQ        : ", msgOut().msg().ade().iModoPesq());
        log(TraceLevel.Debug, "  ");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, "****** FIM *** GHII * MVPHII ** FIM **********");
        log(TraceLevel.Debug, "**********************************************");
        log(TraceLevel.Debug, " FIM PGHS141A ");
        log(TraceLevel.Debug, "  ");
        log(TraceLevel.Debug, "  ");
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
     * *PASS2972 - FIM
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
        
        /**
         * @return instancia da classe local WsDocumentosCliente
         */
        @Data
        WsDocumentosCliente wsDocumentosCliente() ;
        
        /**
         * @return instancia da classe local WsDocCliLinha
         */
        @Data
        @Mask
        WsDocCliLinha wsDocCliLinha() ;
        
        
        public interface WsTipoDocumento extends IDataStruct {
            
            @Data(size=20, value=" ")
            IString wsTdCCodigo() ;
            
            @Data(size=20, value=" ")
            IString wsTdXCteuCo03() ;
            
        }
        
        public interface WsDocumentosCliente extends IDataStruct {
            
            /**
             * @return instancia da classe local WsDocumCli
             */
            @Data(length=14)
            IArray<WsDocumCli> wsDocumCli() ;
            
            
            public interface WsDocumCli extends IDataStruct {
                
                @Data(size=3, value=" ")
                IString wsTdCPaisIsaEmsDoc() ;
                
                @Data(size=3, value=" ")
                IString wsTdCTipoDocId() ;
                
                @Data(size=20, value=" ")
                IString wsTdNDocId() ;
                
            }
        }
        
//        public interface WsDocCliLinha extends IDataMask {
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc1() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId1() ;
//            
//            @Data(size=20)
//            IString wsNDocId1() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc2() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId2() ;
//            
//            @Data(size=20)
//            IString wsNDocId2() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc3() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId3() ;
//            
//            @Data(size=20)
//            IString wsNDocId3() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc4() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId4() ;
//            
//            @Data(size=20)
//            IString wsNDocId4() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc5() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId5() ;
//            
//            @Data(size=20)
//            IString wsNDocId5() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc6() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId6() ;
//            
//            @Data(size=20)
//            IString wsNDocId6() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc7() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId7() ;
//            
//            @Data(size=20)
//            IString wsNDocId7() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc8() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId8() ;
//            
//            @Data(size=20)
//            IString wsNDocId8() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc9() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId9() ;
//            
//            @Data(size=20)
//            IString wsNDocId9() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc10() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId10() ;
//            
//            @Data(size=20)
//            IString wsNDocId10() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc11() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId11() ;
//            
//            @Data(size=20)
//            IString wsNDocId11() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc12() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId12() ;
//            
//            @Data(size=20)
//            IString wsNDocId12() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc13() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId13() ;
//            
//            @Data(size=20)
//            IString wsNDocId13() ;
//            
//            @Data(size=3)
//            IString wsCPaisIsaEmsDoc14() ;
//            
//            @Data(size=3)
//            IString wsCTipoDocId14() ;
//            
//            @Data(size=20)
//            IString wsNDocId14() ;
//            
//        }
    }
    
    /**
     * 
     * VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsCodCodigo
         */
        @Data
        WsCodCodigo wsCodCodigo() ;
        
        @Data(size=20, value=" ")
        IString wsCCodigoTemp() ;
        
        @Data(size=20, value=" ")
        IString wsXCteuCo03Temp() ;
        
        @Data(size=3, value="0")
        IInt wsInd() ;
        
        @Data(size=3, value="0")
        IInt wsIndExt() ;
        
        @Data(size=3, value="0")
        IInt wsIndInt() ;
        
        @Data(size=3, value="0")
        IInt wsIndRot() ;
        
        @Data(size=3, value="0")
        IInt wsIndTi() ;
        
        @Data(size=3, value="0")
        IInt wsIndTi2() ;
        
        @Data(size=1, value=" ")
        IString wsICliCgd1() ;
        
        @Data(size=1, value=" ")
        IString wsICliCgd2() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoItvtDep1() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoItvtDep2() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoItvtDep3() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoItvtDep4() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoItvtDep5() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoItvtDep6() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoItvtDep7() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoOpeCont1() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoOpeCont2() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoOpeCont3() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoOpeCont4() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoOpeCont5() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoOpeCont6() ;
        
        @Data(size=1, value=" ")
        IString wsCTipoOpeCont7() ;
        
        @Data(size=1, value=" ")
        IString wsCrit1() ;
        
        @Data(size=1, value=" ")
        IString wsCrit2() ;
        
        @Data(size=1, value=" ")
        IString wsCrit3() ;
        
        @Data(size=2, value="0")
        IInt wsQtDoc() ;
        
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
        
        @Data(size=10, value=" ")
        IString wsDataDb2() ;
        
        @Data(size=3, value="0")
        IInt wsCountIndice() ;
        
        @Data(size=2, value="0")
        IInt wsCEstMsgSwifTemp() ;
        
        @Data(format="999-", value="0")
        IFormattedString wsSqlcodeErro() ;
        
        @Data(size=3, value=" ")
        IString wsBhjl006aCPais() ;
        
        @Data(size=3, value=" ")
        IString wsBhjl006aCMnem() ;
        
        @Data(size=10, signed=true, value="0")
        ILong wsBhjl006aNCli() ;
        
        
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
        
        
        @Data(size=1, value=" ")
        IString swCiclo() ;
        @Data
        @Condition("E")
        ICondition swEmCiclo() ;
        @Data
        @Condition("F")
        ICondition swFimCiclo() ;
        
        
        @Data(size=1, value=" ")
        IString swBuscaDoc() ;
        @Data
        @Condition("N")
        ICondition swDocNfound() ;
        @Data
        @Condition("F")
        ICondition swDocFound() ;
        
        
        @Data(size=2, value=" ")
        IString swIModoPesq() ;
        @Data
        @Condition("CA")
        ICondition swTpConsContaAsc() ;
        @Data
        @Condition("CD")
        ICondition swTpConsContaDesc() ;
        @Data
        @Condition("LA")
        ICondition swTpConsClienteAsc() ;
        @Data
        @Condition("LD")
        ICondition swTpConsClienteDesc() ;
        @Data
        @Condition("DA")
        ICondition swTpConsDocumAsc() ;
        @Data
        @Condition("DD")
        ICondition swTpConsDocumDesc() ;
        @Data
        @Condition("NA")
        ICondition swTpConsNomeAsc() ;
        @Data
        @Condition("ND")
        ICondition swTpConsNomeDesc() ;
        @Data
        @Condition("OA")
        ICondition swTpConsOrdemAsc() ;
        @Data
        @Condition("OD")
        ICondition swTpConsOrdemDesc() ;
        @Data
        @Condition("MA")
        ICondition swTpConsMontAsc() ;
        @Data
        @Condition("MD")
        ICondition swTpConsMontDesc() ;
        
        
        /**
         * *----- AGRUPAMENTO DE TODOS OS TIPO DE OPERACAO
         */
        @Data(size=1, value=" ")
        IString swCTipoOpeContL() ;
        @Data
        @Condition("E")
        ICondition swEntregaL() ;
        @Data
        @Condition("L")
        ICondition swLevantamentosL() ;
        @Data
        @Condition("C")
        ICondition swCambioL() ;
        @Data
        @Condition("D")
        ICondition swTrocoDestrocoL() ;
        @Data
        @Condition({ "T", "S", "R" })
        ICondition swTransferenciasL() ;
        @Data
        @Condition("S")
        ICondition swOrdensEmitidasL() ;
        @Data
        @Condition("R")
        ICondition swOrdensRecebidasL() ;
        @Data
        @Condition("O")
        ICondition swOcasionaisL() ;
        
        
        /**
         * *----- TIPOS DE OPERACAO QUE SURGEM NA COMBO DA TRANSACAO
         * TABELA GERAL LOGICA 'G65' - TIPO DE OPERACAO NA CONTA
         */
        @Data(size=1, value=" ")
        IString swCTipoOpeContIn() ;
        @Data
        @Condition("A")
        ICondition swTodosIn() ;
        @Data
        @Condition("E")
        ICondition swEntregasIn() ;
        @Data
        @Condition("L")
        ICondition swLevantamentosIn() ;
        @Data
        @Condition("C")
        ICondition swCambioIn() ;
        @Data
        @Condition("D")
        ICondition swTrocoDestrocoIn() ;
        @Data
        @Condition("T")
        ICondition swTransferenciasIn() ;
        @Data
        @Condition("O")
        ICondition swOcasionaisIn() ;
        @Data
        @Condition({ "A", "E", "L", "C", "D", "T", "O" })
        ICondition swTipoOpeValidosIn() ;
        
        
        /**
         * *----- AVALIA ESTADO DA ORDEM - C-EST-MSG-SWIF
         */
        @Data(size=2, value="0")
        IInt swCEstMsgSwif() ;
        @Data
        @Condition("02")
        ICondition swEnviada() ;
        @Data
        @Condition("16")
        ICondition swAnulada() ;
        @Data
        @Condition("18")
        ICondition swDevolvida() ;
        @Data
        @Condition("28")
        ICondition swLiquidada() ;
        @Data
        @Condition("31")
        ICondition swEstornada() ;
        @Data
        @Condition("38")
        ICondition swAgrdDevolFundos() ;
        @Data
        @Condition("53")
        ICondition swFundosDesviados() ;
        @Data
        @Condition({ "02", "16", "18", "28", "38", "53" })
        ICondition swEstFinalValidos() ;
        
        
        /**
         * *...... CHEQUE BANCARIO
         */
        @Data(size=1, value=" ")
        IString swChequeBancario() ;
        @Data
        @Condition("S")
        ICondition swChequeBancarioSim() ;
        @Data
        @Condition("N")
        ICondition swChequeBancarioNao() ;
        
        
        /**
         * *...... CARTA CHEQUE
         */
        @Data(size=1, value=" ")
        IString swCartaCheque() ;
        @Data
        @Condition("S")
        ICondition swCartaChequeSim() ;
        @Data
        @Condition("N")
        ICondition swCartaChequeNao() ;
        
        
    }
    
}
