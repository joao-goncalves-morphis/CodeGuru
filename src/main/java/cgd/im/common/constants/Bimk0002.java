package cgd.im.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bimk0002 extends IDataStruct {
    
    public static final String BIMK0002_A_APL = "IM" ;
    
    public static final String BIMK0002_FICH_REFRESH = "CARTREF-LU" ;
    
    /**
     * @return instancia da classe local EstadoEntCred
     */
    @Data
    EstadoEntCred estadoEntCred() ;
    
    public static final String BIMK0002_C_MOEDA = "EUR" ;
    
    public static final String BIMK0002_C_FAMILIA = "400" ;
    
    /**
     * @return instancia da classe local CEvento
     */
    @Data
    CEvento cEvento() ;
    
    /**
     * @return instancia da classe local CServPrsdCgd
     */
    @Data
    CServPrsdCgd cServPrsdCgd() ;
    
    public static final int BIMK0002_C_OE_GERX = 9940 ;
    
    /**
     * @return instancia da classe local Descricoes
     */
    @Data
    Descricoes descricoes() ;
    
    public static final String BIMK0002_CODIGO_CI = "CINTLUX" ;
    
    public static final String BIMK0002_CODIGO_EMP = "EUROPAY" ;
    
    public static final String BIMK0002_COD_EUROPAY = "EURO" ;
    
    public static final String BIMK0002_COD_SIX_CETREL = "SPSE" ;
    
    public static final String BIMK0002_COD_CONTA_INT = "INT" ;
    
    public static final String BIMK0002_COD_CONTA_EMP = "EMP" ;
    
    public static final String BIMK0002_CODIGO_REJ = "CREJLUX" ;
    
    public static final String BIMK0002_C_OPCZ_MENU_BATCH = "999" ;
    
    public static final String BIMK0002_C_OPCZ_MENU_MOV = "000" ;
    
    public static final int BIMK0002_BANCO_OFF_SHORE = 9930 ;
    
    public static final int BIMK0002_BANCO_COE_OFF_SHORE = 35 ;
    
    public static final String BIMK0002_C_TIP_OPT_BPOR_DECG = "088" ;
    
    public static final int BIMK0002_NIF_CGD = 500960046 ;
    
    /**
     * @return instancia da classe local TpConta
     */
    @Data
    TpConta tpConta() ;
    
    @Data(size=2)
    IString cTipoTrttCont() ;
    @Data
    @Condition("01")
    ICondition cTipoTrttDepOrdem() ;
    @Data
    @Condition("02")
    ICondition cTipoTrttPoupanca() ;
    @Data
    @Condition("03")
    ICondition cTipoTrttDepPrazo() ;
    @Data
    @Condition("09")
    ICondition cTipoTrttDepEstru() ;
    @Data
    @Condition("12")
    ICondition cTipoTrttDepObrig() ;
    @Data
    @Condition("19")
    ICondition cTipoTrttCtaMarg() ;
    @Data
    @Condition("26")
    ICondition cTipoTrttCashCar() ;
    @Data
    @Condition("27")
    ICondition cTipoTrttCtaVostr() ;
    @Data
    @Condition("28")
    ICondition cTipoTrttCtaNostr() ;
    @Data
    @Condition("32")
    ICondition cTipoTrttCtaInter() ;
    @Data
    @Condition({ "02", "03", "09", "26" })
    ICondition cTipoTrttDosptObr() ;
    @Data
    @Condition({ "02", "03", "09" })
    ICondition cTipoTrttProdVenc() ;
    @Data
    @Condition({ "01", "02", "03", "09", "12", "19", "26", "27", "28", "32" })
    ICondition cTipoTrttTodos() ;
    
    
    public static final String BIMK0002_COD_PAIS_ISOA = "PT " ;
    
    public static final String BIMK0002_IBAN = "LU343020011234567892              " ;
    
    public static final String BIMK0002_CANAL_BATCH = "BATC" ;
    
    /**
     * @return instancia da classe local CTipoPagamento
     */
    @Data
    CTipoPagamento cTipoPagamento() ;
    
    /**
     * @return instancia da classe local OrigemPgmEncg
     */
    @Data
    OrigemPgmEncg origemPgmEncg() ;
    
    /**
     * @return instancia da classe local SituacaoConta
     */
    @Data
    SituacaoConta situacaoConta() ;
    
    @Data(size=2, value=" ")
    IString swSituacaoConta() ;
    @Data
    @Condition("10")
    ICondition sitAberta() ;
    @Data
    @Condition("01")
    ICondition sitBloqueadaDebito() ;
    @Data
    @Condition("02")
    ICondition sitBloqueadaCredito() ;
    @Data
    @Condition("03")
    ICondition sitBloqueada() ;
    @Data
    @Condition("30")
    ICondition sitCancelada() ;
    @Data
    @Condition("20")
    ICondition sitSuspensa() ;
    @Data
    @Condition("09")
    ICondition sitPreaberta() ;
    @Data
    @Condition({ "10", "01", "02", "03", "20" })
    ICondition sitValida() ;
    @Data
    @Condition("31")
    ICondition sitTransferida() ;
    @Data
    @Condition("60")
    ICondition sitEstornada() ;
    @Data
    @Condition({ "30", "31", "60" })
    ICondition sitEncerrada() ;
    
    
    /**
     * VARIAVEIS PARA A MIGRACAO DE IM
     */
    public static final String BIMK0002_CAMPO_INVAL = "CAMPO INVALIDO" ;
    
    public static final String BIMK0002_DUPP_KEY = "CHAVE DUPLICADA" ;
    
    public static final String BIMK0002_PAIS_PRCT_INVAL = "PAIS DE PROCESSAMENTO INVALIDO" ;
    
    public static final String BIMK0002_PAIS_CONT_INVAL = "PAIS DA CONTA INVALIDO" ;
    
    public static final String BIMK0002_BALC_PRCT_INVAL = "BALCAO DE PROCESSAMENTO INVALIDO" ;
    
    public static final String BIMK0002_BALC_CONT_INVAL = "BALCAO DA CONTA INVALIDO" ;
    
    public static final String BIMK0002_OE_INVAL = "OE INVALIDO" ;
    
    public static final String BIMK0002_TIPO_CONT_INVAL = "TIPO DE CONTA INVALIDO" ;
    
    public static final String BIMK0002_MOE_INVAL = "MOEDA INVALIDA" ;
    
    public static final String BIMK0002_FAMI_INVAL = "FAMILIA INVALIDA" ;
    
    public static final String BIMK0002_PROD_INVAL = "PRODUTO INVALIDO" ;
    
    public static final String BIMK0002_C_EST_CDEB_INVAL = "ESTADO DE CARTAO INVALIDO" ;
    
    public static final String BIMK0002_C_TIP_CDEB_INVAL = "TIPO DE CARTAO INVALIDO" ;
    
    public static final String BIMK0002_TIP_DEBITO_INVAL = "TIPO DE DEBITO INVALIDO" ;
    
    public static final String BIMK0002_TIP_ACESSO_INVAL = "TIPO DE ACESSO INVALIDO" ;
    
    public static final String BIMK0002_BLQO_CART_INVAL = "BLOQUEIO DE CARTAO INVALIDO" ;
    
    public static final String BIMK0002_MTV_BLQ_CART_INVAL = "MOTIVO DE BLOQUEIO INVALIDO" ;
    
    public static final String BIMK0002_DSPA_CART_INVAL = "DESPESA DE CARTAO INVALIDO" ;
    
    public static final String BIMK0002_TIP_UTILIZ_INVAL = "TIPO DE UTILIZACAO INVALIDO" ;
    
    public static final String BIMK0002_TIP_COMS_INVAL = "TIPO DE COMISSAO INVALIDO" ;
    
    public static final String BIMK0002_ENT_INVAL = "ENTIDADE INVALIDA" ;
    
    public static final String BIMK0002_DAT_N_NUM = "CAMPO DATA NAO NUMERICO" ;
    
    public static final String BIMK0002_INVAL_DAT_FORMAT = "FORMATO DE ANO/MES/DIA INVALIDO" ;
    
    public static final String BIMK0002_DATA_ZEROS = "DATA A ZEROS" ;
    
    public static final String BIMK0002_SEQ_CDEB_INVAL = "SEQUENCIA DE CARTAO INVALIDA" ;
    
    public static final String BIMK0002_DAT_N_PREENCH = "DT.VALIDADE DEVE ESTAR PREENCHIDA" ;
    
    /**
     * FAMILIA PRODUTO DOS CARTÃ•ES
     */
    public static final String BIMK0002_C_FAM_PROD = "421" ;
    
    /**
     * PRODUTOS
     */
    public static final String BIMK0002_C_PROD_BANCOMAT = "L01" ;
    
    public static final String BIMK0002_C_PROD_MAESTRO = "L02" ;
    
    public static final String BIMK0002_C_PROD_VPAY = "L03" ;
    
    /**
     * TIPO DE CARTÃƒO
     */
    public static final String BIMK0002_C_TIPO_CART_BMAT = "BM" ;
    
    public static final String BIMK0002_C_TIPO_CART_MAES = "EC" ;
    
    public static final String BIMK0002_C_TIPO_CART_VPAY = "VP" ;
    
    /**
     * EVENTOS
     */
    public static final String BIMK0002_EVE_EMISS_MAES = "IM05" ;
    
    public static final String BIMK0002_EVE_EMISS_BMAT = "IM06" ;
    
    public static final String BIMK0002_EVE_EMISS_VPAY = "IM11" ;
    
    public static final String BIMK0002_EVE_RENOV_MAES = "IM07" ;
    
    public static final String BIMK0002_EVE_RENOV_BMAT = "IM08" ;
    
    public static final String BIMK0002_EVE_RENOV_VPAY = "IM12" ;
    
    public static final String BIMK0002_EVE_REAT_PIN = "IM09" ;
    
    @Data(size=4, value=" ")
    IString swEncargos() ;
    @Data
    @Condition({ "IM05", "IM06", "IM11" })
    ICondition swEmissao() ;
    @Data
    @Condition({ "IM07", "IM08", "IM12" })
    ICondition swRenovacao() ;
    @Data
    @Condition("IM09")
    ICondition swReemissao() ;
    
    
    public static final String BIMK0002_CDEB_ACT_EXP = "CARTAO EXPIRADO MAS ACTIVO" ;
    
    public static final String BIMK0002_COD_BLQO_INCOMP_CART = "COD.BLOQ INCOMPATIVEL C/ EST.CART" ;
    
    public static final String BIMK0002_DT_BLQO_INCOMP_CART = "DT.BLOQUEIO INCOMPATIVEL C/ EST.CART" ;
    
    public static final String BIMK0002_DT_CANC_INCOMP_CART = "DT.CANCELAMENTO INCOMPATIVEL C/ EST.CART" ;
    
    public static final String BIMK0002_EST_CBEB_INC_DT_ANUL = "EST.CART INCOMPATIVEL COM DT.ANULACAO" ;
    
    public static final String BIMK0002_DT_ANUL_DT_BLQO = "DT.ANULACAO BLOQUEIO <DT.BLOQUEIO CART" ;
    
    public static final String BIMK0002_DT_PED_N_PREENCH = "DT.PEDIDO DEVE ESTAR PREENCHIDA" ;
    
    public static final String BIMK0002_DT_EMI_N_PREENCH = "DT.DEBITO EMISSAO DEVE ESTAR PREENCHIDA" ;
    
    public static final String BIMK0002_DT_ENTREGA_N_PREENCH = "DT.ENTREGA DEVE ESTAR PREENCHIDA" ;
    
    public static final String BIMK0002_DT_RECEP_N_PREENCH = "DT.RECEPCAO DEVE ESTAR PREENCHIDA" ;
    
    public static final String BIMK0002_N_CONT_ANT_INVAL = "NUMERO DE CONTA ANTIGA INVALIDA" ;
    
    public static final String BIMK0002_CART_REPEAT = "NÂº CARTAO REPETIDO" ;
    
    /**
     * @return instancia da classe local SwSqlcode
     */
    @Data
    SwSqlcode swSqlcode() ;
    
    /**
     * Inner Classes
     */
    public interface EstadoEntCred extends IDataStruct {
        
        @Data(size=1, value="A")
        IString entActiva() ;
        
        @Data(size=1, value="I")
        IString entInact() ;
        
    }
    public interface CEvento extends IDataStruct {
        
        @Data(size=4, value="IM01")
        IString eveFun() ;
        
        @Data(size=4, value="IM03")
        IString eveMcd() ;
        
        @Data(size=4, value="IM02")
        IString eveAcd() ;
        
        @Data(size=4, value="IM04")
        IString eveMcc() ;
        
        @Data(size=4, value="IM05")
        IString eveEem() ;
        
        @Data(size=4, value="IM06")
        IString eveEeb() ;
        
        @Data(size=4, value="IM07")
        IString eveErm() ;
        
        @Data(size=4, value="IM08")
        IString eveErb() ;
        
        @Data(size=4, value="IM09")
        IString eveErp() ;
        
        @Data(size=4, value="IM10")
        IString eveEme() ;
        
    }
    public interface CServPrsdCgd extends IDataStruct {
        
        @Data(size=3, signed=true, value="100")
        IInt cServPrsdCgdEccr() ;
        
        @Data(size=3, signed=true, value="101")
        IInt cServPrsdCgdDbpr() ;
        
        @Data(size=3, signed=true, value="500")
        IInt cServPrsdCgdCrpr() ;
        
        @Data(size=3, signed=true, value="102")
        IInt cServPrsdCgdDbfu() ;
        
        @Data(size=3, signed=true, value="501")
        IInt cServPrsdCgdCrfu() ;
        
    }
    public interface Descricoes extends IDataStruct {
        
        @Data(size=21, value="FUN-DEB CONTA INTERNA")
        IString dMovDFun() ;
        
        @Data(size=21, value="FUN-CRE CONTA EMPRESA")
        IString dMovCFun() ;
        
        @Data(size=21, value="PREE-DEB CLIENTES")
        IString dMovDPre() ;
        
        @Data(size=21, value="PREE-CRE CTA INTERNA")
        IString dMovCPre() ;
        
        @Data(size=21, value="PRBC-DEB CTA EMPRESA")
        IString dMovD1Prb() ;
        
        @Data(size=21, value="PRBC-DEB CLIENTES")
        IString dMovD2Prb() ;
        
        @Data(size=21, value="PRBC-CRE CLIENTES")
        IString dMovC1Prb() ;
        
        @Data(size=21, value="PRBC-CRE CTA EMPRESA")
        IString dMovC2Prb() ;
        
        @Data(size=21, value="ECIC-DEB CTA EMPRESA")
        IString dMovD1Eci() ;
        
        @Data(size=21, value="ECIC-DEB CLIENTES")
        IString dMovD2Eci() ;
        
        @Data(size=21, value="ECIC-CRE CLIENTES")
        IString dMovC1Eci() ;
        
        @Data(size=21, value="ECIC-CRE CTA EMPRESA")
        IString dMovC2Eci() ;
        
    }
    public interface TpConta extends IDataStruct {
        
        @Data(size=1, value="E")
        IString tpContaEmpresa() ;
        
        @Data(size=1, value="P")
        IString tpContaParticular() ;
        
        @Data(size=1, value="M")
        IString tpContaMenores() ;
        
    }
    public interface CTipoPagamento extends IDataStruct {
        
        @Data(size=1, value="P")
        IString pgmEncgParcial() ;
        
        @Data(size=1, value="T")
        IString pgmEncgTotal() ;
        
    }
    public interface OrigemPgmEncg extends IDataStruct {
        
        @Data(size=1, value="P")
        IString pgmPendOnline() ;
        
        @Data(size=1, value="A")
        IString pgmPendBatch() ;
        
        @Data(size=1, value="O")
        IString pgmOnline() ;
        
        @Data(size=1, value="B")
        IString pgmBatch() ;
        
    }
    public interface SituacaoConta extends IDataStruct {
        
        @Data(size=2, value="10")
        IString aberta() ;
        
        @Data(size=2, value="01")
        IString bloqueadaDebito() ;
        
        @Data(size=2, value="02")
        IString bloqueadaCredito() ;
        
        @Data(size=2, value="03")
        IString bloqueada() ;
        
        @Data(size=2, value="30")
        IString cancelada() ;
        
        @Data(size=2, value="20")
        IString suspensa() ;
        
        @Data(size=2, value="09")
        IString preaberta() ;
        
        @Data(size=2, value="31")
        IString transferida() ;
        
        @Data(size=2, value="60")
        IString estornada() ;
        
    }
    public interface SwSqlcode extends IDataStruct {
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt swSqlcodeVim00101() ;
        @Data
        @Condition("0")
        ICondition swVim00101Ok() ;
        @Data
        @Condition("100")
        ICondition swVim00101Notfnd() ;
        @Data
        @Condition("-305")
        ICondition swVim00101Nullval() ;
        @Data
        @Condition("-811")
        ICondition swVim00101Multrow() ;
        @Data
        @Condition("-803")
        ICondition swVim00101Duprec() ;
        
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt swSqlcodeVim00201() ;
        @Data
        @Condition("0")
        ICondition swVim00201Ok() ;
        @Data
        @Condition("100")
        ICondition swVim00201Notfnd() ;
        @Data
        @Condition("-305")
        ICondition swVim00201Nullval() ;
        @Data
        @Condition("-811")
        ICondition swVim00201Multrow() ;
        @Data
        @Condition("-803")
        ICondition swVim00201Duprec() ;
        
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt swSqlcodeVim00301() ;
        @Data
        @Condition("0")
        ICondition swVim00301Ok() ;
        @Data
        @Condition("100")
        ICondition swVim00301Notfnd() ;
        @Data
        @Condition("-305")
        ICondition swVim00301Nullval() ;
        @Data
        @Condition("-811")
        ICondition swVim00301Multrow() ;
        @Data
        @Condition("-803")
        ICondition swVim00301Duprec() ;
        
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt swSqlcodeVim00401() ;
        @Data
        @Condition("0")
        ICondition swVim00401Ok() ;
        @Data
        @Condition("100")
        ICondition swVim00401Notfnd() ;
        @Data
        @Condition("-305")
        ICondition swVim00401Nullval() ;
        @Data
        @Condition("-811")
        ICondition swVim00401Multrow() ;
        @Data
        @Condition("-803")
        ICondition swVim00401Duprec() ;
        
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt swSqlcodeVim90001() ;
        @Data
        @Condition("0")
        ICondition swVim90001Ok() ;
        @Data
        @Condition("100")
        ICondition swVim90001Notfnd() ;
        @Data
        @Condition("-305")
        ICondition swVim90001Nullval() ;
        @Data
        @Condition("-811")
        ICondition swVim90001Multrow() ;
        @Data
        @Condition("-803")
        ICondition swVim90001Duprec() ;
        
        
    }
    
}
