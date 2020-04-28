package cgd.hj.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhjk0002 extends IDataStruct {
    
    public static final String BHJK0002_BI_PORTUGUES = "101" ;
    
    public static final String BHJK0002_BI_ESTRANGEIRO = "301" ;
    
    public static final String BHJK0002_BI_NAC_RES_EST = "102" ;
    
    public static final String BHJK0002_NIF_PORTUGUES = "501" ;
    
    public static final String BHJK0002_NIPC_PORTUGUES = "502" ;
    
    public static final String BHJK0002_CODIGO_LEI = "810" ;
    
    public static final String BHJK0002_ACC_JUD_ACT = "A" ;
    
    public static final String BHJK0002_ACC_JUD_CANC = "C" ;
    
    public static final String BHJK0002_ACC_JUD_JUSTIF = "J" ;
    
    public static final String BHJK0002_ANOTACAO_ACTIVA = "S" ;
    
    public static final String BHJK0002_ANOTACAO_INACTIVA = "N" ;
    
    public static final String BHJK0002_ANOT_AVISA = "S" ;
    
    public static final String BHJK0002_ANOT_NAO_AVISA = "N" ;
    
    public static final String BHJK0002_I_EMIS_AVSO_S = "S" ;
    
    public static final String BHJK0002_APLICACAO_CLIENTES = "HJ" ;
    
    public static final String BHJK0002_CANAL_ACTIVO = "S" ;
    
    public static final String BHJK0002_CANAL_INACTIVO = "N" ;
    
    public static final String BHJK0002_CENTRAL = "C" ;
    
    public static final String BHJK0002_CLIENTE_CONFIDENCIAL = "10" ;
    
    public static final String BHJK0002_CLIENTE_EMPRESA = "E" ;
    
    public static final String BHJK0002_CLIENTE_ENI = "I" ;
    
    public static final String BHJK0002_CLIENTE_PARTICULAR = "P" ;
    
    public static final String BHJK0002_CLIENTES = "CLIENTES" ;
    
    public static final String BHJK0002_CLI_SEM_REL_BANCO = "30" ;
    
    public static final String BHJK0002_CLI_SEM_REL_BANCO_OPE = "20" ;
    
    public static final String BHJK0002_COM_CONFIDENCIALIDADE = "S" ;
    
    public static final String BHJK0002_CONTEUDOS = "C" ;
    
    public static final String BHJK0002_CRIACAO_FORCADA = "S" ;
    
    public static final String BHJK0002_DESAGREGACAO_APROVADA = "A" ;
    
    public static final String BHJK0002_DESAGREGACAO_PEDIDA = "P" ;
    
    public static final String BHJK0002_DESAGREGACAO_RECUSADA = "R" ;
    
    public static final String BHJK0002_DESAGREGACAO_CANCELA = "C" ;
    
    public static final String BHJK0002_ELIMINACAO = "E" ;
    
    public static final String BHJK0002_ERRO_DB2 = "90" ;
    
    public static final String BHJK0002_ERRO_FUNCAO = "1" ;
    
    public static final String BHJK0002_EST_ASS_ACT = "S" ;
    
    public static final String BHJK0002_CLI_NAO_EMIGRANTE = "000" ;
    
    public static final String BHJK0002_DOC_N_ENT = "899" ;
    
    public static final String BHJK0002_EXISTE_ANOTACAO = "S" ;
    
    public static final String BHJK0002_EXISTE_TRB = "S" ;
    
    public static final String BHJK0002_EXISTE_UTR = "S" ;
    
    public static final String BHJK0002_ESTADO_PEMIGR_ACTIVA = "000" ;
    
    public static final String BHJK0002_ESTADO_PEMIGR_PROVIS = "001" ;
    
    public static final String BHJK0002_ESTADO_PEMIGR_ARQ = "002" ;
    
    public static final String BHJK0002_ESTADO_PEMIGR_LAPSO = "003" ;
    
    public static final String BHJK0002_ESTADO_PEMIGR_CADUC = "004" ;
    
    public static final String BHJK0002_ESTADO_PEMIGR_ATRASO = "005" ;
    
    public static final String BHJK0002_FAL_DECLARADA = "DF" ;
    
    public static final String BHJK0002_FAL_RETIRADA = "RE" ;
    
    public static final String BHJK0002_FUSAO = "FUSAO" ;
    
    public static final String BHJK0002_FUSAO_APROVADA = "A" ;
    
    public static final String BHJK0002_FUSAO_EXECUTADA = "E" ;
    
    public static final String BHJK0002_FUSAO_PEDIDA = "P" ;
    
    public static final String BHJK0002_FUSAO_RECUSADA = "R" ;
    
    public static final String BHJK0002_FUSAO_CANCELADA = "C" ;
    
    public static final String BHJK0002_INCID_ACCAO_JUDIC = "004" ;
    
    public static final String BHJK0002_INCID_FALENCIA = "005" ;
    
    public static final String BHJK0002_INCID_PED_FALN = "021" ;
    
    public static final String BHJK0002_INCID_PER = "019" ;
    
    public static final String BHJK0002_C_EST_ACCJ = "S" ;
    
    public static final String BHJK0002_INCIDENTE_ACTIVO = "S" ;
    
    public static final String BHJK0002_IND_PROT_ACT = "S" ;
    
    public static final String BHJK0002_IND_PROT_INACT = "N" ;
    
    public static final String BHJK0002_PROT_ELI = "N" ;
    
    public static final String BHJK0002_INIBIDO_BP = "003" ;
    
    public static final String BHJK0002_INSERCAO = "I" ;
    
    public static final String BHJK0002_MODIFICA = "M" ;
    
    public static final String BHJK0002_MORD_PRINC = "000" ;
    
    public static final String BHJK0002_MORD_SECUND = "003" ;
    
    public static final String BHJK0002_NAO_EXISTE_ANOTACAO = "N" ;
    
    public static final String BHJK0002_NAO_EXISTE_TRB = "N" ;
    
    public static final String BHJK0002_NAO_EXISTE_UTR = "N" ;
    
    public static final String BHJK0002_NAO_TEM_INCIDENTE = "N" ;
    
    public static final String BHJK0002_NOME_CARTAO = "003" ;
    
    public static final String BHJK0002_NM_PRINCIP = "001" ;
    
    public static final String BHJK0002_NM_SECUND = "002" ;
    
    public static final int BHJK0002_PRIMEIRA_MORADA = 1 ;
    
    public static final int BHJK0002_PRIM_NOME = 1 ;
    
    public static final int BHJK0002_PRIM_ITVT = 1 ;
    
    public static final String BHJK0002_REL_ACTIVAS = "A" ;
    
    public static final String BHJK0002_REL_INACTIVAS = "I" ;
    
    public static final String BHJK0002_RETORNO_SEM_ERROS = "00" ;
    
    public static final int BHJK0002_SEGUNDO_NOME = 2 ;
    
    public static final String BHJK0002_SEM_CONFIDENCIALIDADE = "N" ;
    
    public static final int BHJK0002_NS_ABRA_CLI_INI = 1 ;
    
    public static final String BHJK0002_TEM_INCIDENTE = "S" ;
    
    public static final String BHJK0002_THG_DOC_ID = "886" ;
    
    public static final String BHJK0002_THG_PERIOD = "865" ;
    
    public static final String BHJK0002_THG_VINCULOS = "853" ;
    
    public static final int BHJK0002_TITULAR = 101 ;
    
    public static final String BHJK0002_TODAS_REL = "T" ;
    
    public static final String BHJK0002_VISUALIZA = "V" ;
    
    public static final String BHJK0002_MIN_EBCDIC_X3 = "  a" ;
    
    public static final String BHJK0002_MAX_EBCDIC_X3 = "999" ;
    
    public static final String BHJK0002_MIN_EBCDIC_X2 = " a" ;
    
    public static final String BHJK0002_MAX_EBCDIC_X2 = "99" ;
    
    public static final String BHJK0002_REL_ELIMINADA = "N" ;
    
    public static final String BHJK0002_REL_ACTIVA = "S" ;
    
    public static final String BHJK0002_CONT_ELIMINADO = "N" ;
    
    public static final String BHJK0002_CONT_ACTIVO = "S" ;
    
    public static final String BHJK0002_IND_SIT_ANULADO = "A" ;
    
    public static final String BHJK0002_IND_SIT_N_ENTREGUE = "N" ;
    
    public static final String BHJK0002_IND_SIT_ENTREGUE = "S" ;
    
    public static final String BHJK0002_IND_SUBST_S = "S" ;
    
    public static final String BHJK0002_IND_CTRL_VAL_S = "S" ;
    
    public static final String BHJK0002_CTRATCTA_DO = "01" ;
    
    public static final String BHJK0002_BLOQUEIO_OBITO = "001" ;
    
    public static final String BHJK0002_BLOQUEIO_FALENCIA = "002" ;
    
    public static final String BHJK0002_CLI_N_BLOQ = "N" ;
    
    public static final String BHJK0002_CLI_BLOQ = "S" ;
    
    public static final String BHJK0002_ALT_CONF_PEDIDA = "P" ;
    
    public static final String BHJK0002_PED_ALT_CONF_EXEC = "E" ;
    
    public static final String BHJK0002_PED_ALT_CONF_CAN = "C" ;
    
    public static final String BHJK0002_C_CMCZ_STAND = "STD" ;
    
    public static final String BHJK0002_C_CMCZ_CANAIS = "CNL" ;
    
    public static final String BHJK0002_C_PAIS_ISO_PORTUGAL = "PT" ;
    
    public static final String BHJK0002_TIPO_BLOQ_UTR = "003" ;
    
    public static final String BHJK0002_TIPO_BLOQ_TRB = "004" ;
    
    public static final String BHJK0002_MTVO_BLQO_INIB_BP = "003" ;
    
    public static final String BHJK0002_DESAUTORIZADO = "N" ;
    
    public static final String BHJK0002_AUTORIZADO = "S" ;
    
    public static final String BHJK0002_CLI_SEM_DADOS = "S" ;
    
    public static final String BHJK0002_CLI_COM_DADOS = "N" ;
    
    public static final String BHJK0002_I_TIPO_CNDZ_ESPL_F = "F" ;
    
    public static final String BHJK0002_I_EXRT_ATIV = "A" ;
    
    public static final String BHJK0002_I_EXRT_INACT = "I" ;
    
    public static final String BHJK0002_I_TIPO_CNDZ_ESPL_R = "R" ;
    
    public static final String BHJK0002_I_EXIS_ECLO_S = "S" ;
    
    public static final String BHJK0002_I_EXIS_ECLO_N = "N" ;
    
    public static final String BHJK0002_TIPO_EXRT_INTEGRADO = "01" ;
    
    public static final String BHJK0002_TIPO_EXRT_COMBINADO = "02" ;
    
    public static final String BHJK0002_FAM_CANAIS = "900" ;
    
    public static final String BHJK0002_PROD_CANAIS = "001" ;
    
    public static final int BHJK0002_C_TIPO_CONT = 81 ;
    
    public static final String BHJK0002_C_TIPO_TRTT_CONT = "29" ;
    
    @Data(size=3)
    IString cTipInfCplrMkt() ;
    @Data
    @Condition("001")
    ICondition informacaoMkt() ;
    @Data
    @Condition("002")
    ICondition actvBanc() ;
    
    
    /**
     * @return instancia da classe local TipoDeEscalao
     */
    @Data
    TipoDeEscalao tipoDeEscalao() ;
    
    /**
     * @return instancia da classe local Gatilhos
     */
    @Data
    Gatilhos gatilhos() ;
    
    public static final String BHJK0002_N_CLIENTE = "N_CLIENTE" ;
    
    public static final String BHJK0002_DATA_MAXIMA_DB2 = "9999-12-31" ;
    
    public static final String BHJK0002_DATA_MINIMA_DB2 = "0001-01-01" ;
    
    public static final String BHJK0002_TIMESTAMP_MINIMO_DB2 = "0001-01-01-00.00.00.000000" ;
    
    /**
     * TIPOS DE CONTACTO
     */
    public static final String BHJK0002_CONTACTO_TELEFONE = "001" ;
    
    public static final String BHJK0002_CONTACTO_FAX = "002" ;
    
    public static final String BHJK0002_CONTACTO_EMAIL = "003" ;
    
    public static final String BHJK0002_CONTACTO_TELEX = "004" ;
    
    public static final String BHJK0002_TELEF_BANC_TELEMATIC = "005" ;
    
    public static final String BHJK0002_TELEF_SEC_TELEMATIC = "006" ;
    
    public static final String BHJK0002_FAX_BANCO_TELEMATICO = "007" ;
    
    public static final String BHJK0002_EMAIL_BANC_TELEMATIC = "008" ;
    
    /**
     * TIPOS DE ANOTACAO
     */
    public static final String BHJK0002_TIPO_ANOT_DOC_INV = "100" ;
    
    public static final String BHJK0002_TIPO_ANOT_CLI_INV = "101" ;
    
    public static final String BHJK0002_TIPO_ANOT_CLI_INC = "102" ;
    
    public static final String BHJK0002_T_OBS_MORD = "A01" ;
    
    public static final String BHJK0002_T_OBS_DOC = "A02" ;
    
    public static final String BHJK0002_T_OBS_DOC_N_ENT = "A03" ;
    
    public static final String BHJK0002_T_OBS_CRIA_CANAL = "A04" ;
    
    /**
     * SUBTIPOS DE ANOTACAO
     */
    public static final String BHJK0002_SUBTIPO_ANOT_DOC_INV = "100" ;
    
    public static final String BHJK0002_SUBTIPO_ANOT_CLI_INV = "101" ;
    
    public static final String BHJK0002_SUBTIPO_ANOT_CLI_INC = "102" ;
    
    public static final String BHJK0002_ST_OBS_MORD = "A01" ;
    
    public static final String BHJK0002_ST_OBS_DOC = "A02" ;
    
    public static final String BHJK0002_ST_OBS_DOC_N_ENT = "A03" ;
    
    public static final String BHJK0002_ST_OBS_CRIA_CANAL = "A04" ;
    
    public static final String BHJK0002_SUBTIPO_ANULA_CNL = "A06" ;
    
    public static final String BHJK0002_SUBTIPO_NOVOS_PINS = "A07" ;
    
    public static final String BHJK0002_SUBTIPO_NOVA_CONTA = "A08" ;
    
    /**
     * DOCUMENTOS PROPRIOS DO LUXEMBURGO
     */
    public static final String BHJK0002_NUM_REG_COMERCIAL = "103" ;
    
    public static final String BHJK0002_NUM_TVA = "503" ;
    
    /**
     * RELSERV
     */
    @Data(size=3, value=" ")
    IString swFamRelserv() ;
    @Data
    @Condition({ "400", "401", "402", "403", "967", "500", "409" })
    ICondition cFamiRelserv() ;
    
    
    /**
     * HJ16906 (FIM)
     */
    public static final String BHJK0002_PORTUGAL = "PT " ;
    
    public static final String BHJK0002_LUXEMBURGO = "LU " ;
    
    /**
     * Inner Classes
     */
    public interface TipoDeEscalao extends IDataStruct {
        
        @Data(size=1, value="M")
        IString escalEncMont() ;
        
        @Data(size=1, value="Q")
        IString escalEncQtd() ;
        
    }
    public interface Gatilhos extends IDataStruct {
        
        @Data(size=3, value="001")
        IString gtloSectIttlBp() ;
        
        @Data(size=3, value="002")
        IString gtloIsezFscl() ;
        
        @Data(size=3, value="003")
        IString gtloCriaCrm() ;
        
        @Data(size=3, value="004")
        IString gtloElimCrm() ;
        
        @Data(size=3, value="005")
        IString gtloAltCRfin() ;
        
        @Data(size=3, value="006")
        IString gtloAltCTipoCli() ;
        
    }
    
}
