package cgd.ho.common.constants;

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
public interface Bhok0002 extends IDataStruct {
    
    /**
     * @return instancia da classe local TipoTrttCont
     */
    @Data
    TipoTrttCont tipoTrttCont() ;
    
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
    
    
    @Data(size=2, value=" ")
    IString swCEstCta() ;
    @Data
    @Condition({ "10", "01", "02", "03", "20" })
    ICondition cEstCtaValida() ;
    
    
    @Data(size=2, value=" ")
    IString swCEstScta() ;
    @Data
    @Condition({ "10", "01", "02", "03", "20" })
    ICondition cEstSctaValida() ;
    
    
    public static final String BHOK0002_APLIC_MANUT_CONTAS = "HO" ;
    
    public static final String BHOK0002_APLIC_OPERATIVA = "HV" ;
    
    public static final String BHOK0002_A_APLIC_DOMICILIA = "HM" ;
    
    public static final String BHOK0002_A_APLIC_ACTIV_FINANC = "VM" ;
    
    public static final int BHOK0002_Q_DIA_SMR_DVAL_JC_STD = 1 ;
    
    public static final String BHOK0002_ICPT_GERAL = "9999" ;
    
    public static final String BHOK0002_C_ICPT_DIARIZ = "DIAR" ;
    
    public static final String BHOK0002_C_ICPT_ISSMD = "ISMD" ;
    
    public static final String BHOK0002_C_ICPT_JURO_ENCG = "JREC" ;
    
    public static final String BHOK0002_C_ICPT_PREP_LANC_JURO = "CJUR" ;
    
    public static final String BHOK0002_C_ICPT_PREP_ENCARGOS = "CENC" ;
    
    public static final String BHOK0002_C_ICPT_PREP_ISSMD = "CISM" ;
    
    public static final String BHOK0002_C_TIPO_ENCG_COMIS = "C" ;
    
    public static final String BHOK0002_C_GEST_SIT_ICPT = "00" ;
    
    public static final String BHOK0002_SGAFF = "VF" ;
    
    @Data(size=2, value=" ")
    IString swAplicSgaf() ;
    @Data
    @Condition("VF")
    ICondition swAplicSgafVf() ;
    @Data
    @Condition("VM")
    ICondition swAplicSgafVm() ;
    @Data
    @Condition("VP")
    ICondition swAplicSgafVp() ;
    @Data
    @Condition("VL")
    ICondition swAplicSgafVl() ;
    @Data
    @Condition({ "VF", "VM", "VP", "VL" })
    ICondition swAplicSgafTodas() ;
    
    
    /**
     * *TERESA*INICIO*VALOR PROVISORIO
     */
    public static final String BHOK0002_APLIC_CONTA_CORRENTE = "QC" ;
    
    /**
     * *TERESA*FIM
     */
    public static final String BHOK0002_C_OPCZ_MENU_MOV = "000" ;
    
    public static final String BHOK0002_OPC_MENU_LV_CH_VISADO = "012" ;
    
    public static final String BHOK0002_C_OPCZ_MENU_PERDAO = "325" ;
    
    public static final String BHOK0002_C_OPCZ_MENU_ANUL_PERD = "326" ;
    
    public static final String BHOK0002_C_OPCZ_MNU_RT_GST_VNC = "324" ;
    
    public static final String BHOK0002_C_OPCZ_MENU_ABATE_ACT = "323" ;
    
    public static final String BHOK0002_C_OPCZ_MENU_ANUL_ABTE = "322" ;
    
    public static final String BHOK0002_C_OPCZ_MENU_BATCH = "999" ;
    
    public static final String BHOK0002_C_OPCZ_MENU_DESCAT = "097" ;
    
    public static final String BHOK0002_CON_CMOEDA_EURO = "EUR" ;
    
    public static final int BHOK0002_NIF_CGD = 500960046 ;
    
    public static final String BHOK0002_CON_N = "N" ;
    
    public static final String BHOK0002_CON_S = "S" ;
    
    public static final String BHOK0002_NAO_RENOVAVEL = "N" ;
    
    public static final String BHOK0002_MAX_DATA_DB2 = "9999-12-31" ;
    
    public static final String BHOK0002_Z_CRIACAO = "0001-01-01" ;
    
    public static final String BHOK0002_CON_CREDITO = "C" ;
    
    public static final String BHOK0002_CON_DEBITO = "D" ;
    
    public static final String BHOK0002_CON_DEBITO_CREDITO = "A" ;
    
    public static final String BHOK0002_COD_PAIS_ISOA = "PT " ;
    
    public static final String BHOK0002_CON_DGCI = "DGCI" ;
    
    public static final String BHOK0002_CON_IGFPJ = "IGFPJ" ;
    
    public static final String BHOK0002_CON_IGFSS = "IGFSS" ;
    
    public static final int BHOK0002_PENDENTE_GLOBAL = 9999 ;
    
    public static final int BHOK0002_Q_DIAS_SEMANA = 7 ;
    
    public static final String BHOK0002_SIM = "S" ;
    
    public static final String BHOK0002_NAO = "N" ;
    
    public static final int BHOK0002_DIAS_MES_IMP_SELO = 30 ;
    
    public static final String BHOK0002_IDIOMA_PORTUGAL = "POR" ;
    
    public static final String BHOK0002_CLIENTE_FUNDIDO = "CLIENTE FUNDIDO" ;
    
    public static final String BHOK0002_C_ICPT_BATCH = "XXXX" ;
    
    @Data(size=4, signed=true, value="9520")
    IInt cOeEgcDso() ;
    
    @Data(size=4, signed=true, value="9170")
    IInt cOeEgcDci() ;
    
    @Data(size=4, signed=true, value="9876")
    IInt tsuOeDestDso() ;
    
    /**
     * @return instancia da classe local EstPedAltSubconta
     */
    @Data
    EstPedAltSubconta estPedAltSubconta() ;
    
    /**
     * @return instancia da classe local IExiAtzJourBbn
     */
    @Data
    IExiAtzJourBbn iExiAtzJourBbn() ;
    
    @Data(size=1, value=" ")
    IString tipoAccao() ;
    @Data
    @Condition(" ")
    ICondition semAccao() ;
    @Data
    @Condition("I")
    ICondition insercao() ;
    @Data
    @Condition("M")
    ICondition modificacao() ;
    @Data
    @Condition("A")
    ICondition anulacao() ;
    
    
    /**
     * @return instancia da classe local TpConta
     */
    @Data
    TpConta tpConta() ;
    
    /**
     * @return instancia da classe local MtvoRelCont
     */
    @Data
    MtvoRelCont mtvoRelCont() ;
    
    /**
     * @return instancia da classe local SwSldoContrNat
     */
    @Data
    SwSldoContrNat swSldoContrNat() ;
    
    @Data(size=1, value="S")
    IString indAlteracaoSim() ;
    
    /**
     * @return instancia da classe local SituacaoMov
     */
    @Data
    SituacaoMov situacaoMov() ;
    
    /**
     * @return instancia da classe local Tabelas
     */
    @Data
    Tabelas tabelas() ;
    
    /**
     * @return instancia da classe local TipoPrazos
     */
    @Data
    TipoPrazos tipoPrazos() ;
    
    /**
     * @return instancia da classe local IEstPed
     */
    @Data
    IEstPed iEstPed() ;
    
    /**
     * @return instancia da classe local TipoCheque
     */
    @Data
    TipoCheque tipoCheque() ;
    
    /**
     * @return instancia da classe local CanaisAcesso
     */
    @Data
    CanaisAcesso canaisAcesso() ;
    
    /**
     * @return instancia da classe local ISitPedAltOe
     */
    @Data
    ISitPedAltOe iSitPedAltOe() ;
    
    /**
     * @return instancia da classe local IIsezIs
     */
    @Data
    IIsezIs iIsezIs() ;
    
    /**
     * @return instancia da classe local CImpostoIr
     */
    @Data
    CImpostoIr cImpostoIr() ;
    
    /**
     * @return instancia da classe local EstGatConta
     */
    @Data
    EstGatConta estGatConta() ;
    
    /**
     * @return instancia da classe local IDcvoEspl
     */
    @Data
    IDcvoEspl iDcvoEspl() ;
    
    /**
     * @return instancia da classe local IEstAltProduto
     */
    @Data
    IEstAltProduto iEstAltProduto() ;
    
    @Data(size=1)
    IString iTipoRstzMovz() ;
    @Data
    @Condition("X")
    ICondition rstzSemRestr() ;
    @Data
    @Condition({ "C", "F", "I", "L", "O", "R", "U", "Y" })
    ICondition rstzMovzAmbos() ;
    @Data
    @Condition({ "A", "C", "D", "F", "G", "I", "J", "L", "M", "O", "P", "R", "S", "U", "V", "Y" })
    ICondition rstzMovzDb() ;
    @Data
    @Condition({ "B", "C", "E", "F", "H", "I", "K", "L", "N", "O", "Q", "R", "T", "U", "W", "Y" })
    ICondition rstzMovzCr() ;
    @Data
    @Condition({ "A", "B", "C", "J", "K", "L", "M", "N", "O", "S", "T", "U" })
    ICondition rstzMovzCnl() ;
    @Data
    @Condition({ "D", "E", "F", "J", "K", "L", "P", "Q", "R", "S", "T", "U" })
    ICondition rstzMovzEv() ;
    @Data
    @Condition({ "G", "H", "I", "M", "N", "O", "P", "Q", "R", "S", "T", "U" })
    ICondition rstzMovzOe() ;
    @Data
    @Condition({ "V", "W", "Y" })
    ICondition rstzMovzMdlo() ;
    @Data
    @Condition({ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y" })
    ICondition rstzMovzValidos() ;
    
    
    /**
     * @return instancia da classe local INtzaProd
     */
    @Data
    INtzaProd iNtzaProd() ;
    
    /**
     * @return instancia da classe local IEstNegEclo
     */
    @Data
    IEstNegEclo iEstNegEclo() ;
    
    /**
     * @return instancia da classe local TipoDeEscalao
     */
    @Data
    TipoDeEscalao tipoDeEscalao() ;
    
    /**
     * @return instancia da classe local ITipCondEsp
     */
    @Data
    ITipCondEsp iTipCondEsp() ;
    
    /**
     * @return instancia da classe local OrigemPgmEncg
     */
    @Data
    OrigemPgmEncg origemPgmEncg() ;
    
    /**
     * @return instancia da classe local CEstEncgPend
     */
    @Data
    CEstEncgPend cEstEncgPend() ;
    
    /**
     * @return instancia da classe local ITipoItvt
     */
    @Data
    ITipoItvt iTipoItvt() ;
    
    /**
     * @return instancia da classe local NsTitc
     */
    @Data
    NsTitc nsTitc() ;
    
    @Data(size=3)
    IString cTipoDocPed() ;
    @Data
    @Condition({ "303", "501", "502", "849", "861" })
    ICondition nif() ;
    @Data
    @Condition({ "101", "102", "201", "202", "203", "206", "301", "601" })
    ICondition bi() ;
    
    
    @Data(size=3, value="001")
    IString inbzCheq() ;
    
    /**
     * @return instancia da classe local CTipoCli
     */
    @Data
    CTipoCli cTipoCli() ;
    
    @Data(size=1)
    IString codTipoCli() ;
    @Data
    @Condition("P")
    ICondition cTipoCliPart() ;
    @Data
    @Condition("E")
    ICondition cTipoCliEmp() ;
    @Data
    @Condition("I")
    ICondition cTipoCliEni() ;
    
    
    /**
     * @return instancia da classe local Sequenciadores
     */
    @Data
    Sequenciadores sequenciadores() ;
    
    /**
     * @return instancia da classe local CFicheiro
     */
    @Data
    CFicheiro cFicheiro() ;
    
    /**
     * @return instancia da classe local DefaultContab
     */
    @Data
    DefaultContab defaultContab() ;
    
    /**
     * @return instancia da classe local CIcdcOpe
     */
    @Data
    CIcdcOpe cIcdcOpe() ;
    
    /**
     * @return instancia da classe local FichMovJustificados
     */
    @Data
    FichMovJustificados fichMovJustificados() ;
    
    /**
     * @return instancia da classe local Codigo
     */
    @Data
    Codigo codigo() ;
    
    /**
     * @return instancia da classe local EstadoAssServico
     */
    @Data
    EstadoAssServico estadoAssServico() ;
    
    @Data(size=1)
    IString swSituacaoSeguros() ;
    @Data
    @Condition("N")
    ICondition swSegNovo() ;
    @Data
    @Condition("R")
    ICondition swSegRenovado() ;
    @Data
    @Condition("P")
    ICondition swSegPedido() ;
    @Data
    @Condition("X")
    ICondition swSegNaoRenovado() ;
    @Data
    @Condition("A")
    ICondition swSegPedNaoAceite() ;
    
    
    /**
     * @return instancia da classe local MotivoAnulServico
     */
    @Data
    MotivoAnulServico motivoAnulServico() ;
    
    @Data(size=1)
    IString codMtvCancelSeg() ;
    @Data
    @Condition("F")
    ICondition clienteMorto() ;
    @Data
    @Condition("E")
    ICondition subcontaEncerrada() ;
    @Data
    @Condition("Z")
    ICondition naoAceiteCliente() ;
    @Data
    @Condition("C")
    ICondition condicoesNSatisf() ;
    
    
    @Data(size=1)
    IString procPrdEspComVenc() ;
    @Data
    @Condition("H")
    ICondition procProdEspHabitac() ;
    @Data
    @Condition("D")
    ICondition procProdEspDclAno() ;
    @Data
    @Condition("A")
    ICondition procProdEspHabDcl() ;
    @Data
    @Condition({ "H", "A" })
    ICondition procProdEspTrtHab() ;
    @Data
    @Condition({ "D", "A" })
    ICondition procProdEspTrtDcl() ;
    
    
    /**
     * @return instancia da classe local EstGrupCash
     */
    @Data
    EstGrupCash estGrupCash() ;
    
    /**
     * @return instancia da classe local TiposCashPooling
     */
    @Data
    TiposCashPooling tiposCashPooling() ;
    
    /**
     * @return instancia da classe local TiposCashManagement
     */
    @Data
    TiposCashManagement tiposCashManagement() ;
    
    /**
     * @return instancia da classe local TipoAssConta
     */
    @Data
    TipoAssConta tipoAssConta() ;
    
    /**
     * @return instancia da classe local TiposCashCarry
     */
    @Data
    TiposCashCarry tiposCashCarry() ;
    
    /**
     * @return instancia da classe local DescobertoCashCarry
     */
    @Data
    DescobertoCashCarry descobertoCashCarry() ;
    
    /**
     * @return instancia da classe local IExrtCmbd
     */
    @Data
    IExrtCmbd iExrtCmbd() ;
    
    /**
     * @return instancia da classe local IEstPedExrt
     */
    @Data
    IEstPedExrt iEstPedExrt() ;
    
    /**
     * @return instancia da classe local IInfAdiExrt
     */
    @Data
    IInfAdiExrt iInfAdiExrt() ;
    
    /**
     * @return instancia da classe local IEstJstzMov
     */
    @Data
    IEstJstzMov iEstJstzMov() ;
    
    /**
     * @return instancia da classe local IEstMovPoup
     */
    @Data
    IEstMovPoup iEstMovPoup() ;
    
    /**
     * @return instancia da classe local CJustzMoveDeb
     */
    @Data
    CJustzMoveDeb cJustzMoveDeb() ;
    
    @Data(size=6)
    IString familiaProdPoup() ;
    @Data
    @Condition("PPHPPH")
    ICondition famProdPh() ;
    @Data
    @Condition("009001")
    ICondition famProdDclAno() ;
    
    
    /**
     * @return instancia da classe local ConRotDatas
     */
    @Data
    ConRotDatas conRotDatas() ;
    
    /**
     * @return instancia da classe local PrazosDias
     */
    @Data
    PrazosDias prazosDias() ;
    
    /**
     * @return instancia da classe local CsitoperDuc
     */
    @Data
    CsitoperDuc csitoperDuc() ;
    
    /**
     * @return instancia da classe local CEstMovTsu
     */
    @Data
    CEstMovTsu cEstMovTsu() ;
    
    /**
     * @return instancia da classe local CEstMovGtrb
     */
    @Data
    CEstMovGtrb cEstMovGtrb() ;
    
    /**
     * @return instancia da classe local PedidoFotocopias
     */
    @Data
    PedidoFotocopias pedidoFotocopias() ;
    
    /**
     * @return instancia da classe local PrzMaxPedFot
     */
    @Data
    PrzMaxPedFot przMaxPedFot() ;
    
    /**
     * @return instancia da classe local EntidadesFich
     */
    @Data
    EntidadesFich entidadesFich() ;
    
    /**
     * @return instancia da classe local CTipoPagamento
     */
    @Data
    CTipoPagamento cTipoPagamento() ;
    
    /**
     * @return instancia da classe local CtipdocDuc
     */
    @Data
    CtipdocDuc ctipdocDuc() ;
    
    /**
     * @return instancia da classe local ITrttDgiDuc
     */
    @Data
    ITrttDgiDuc iTrttDgiDuc() ;
    
    /**
     * @return instancia da classe local TiposMovims
     */
    @Data
    TiposMovims tiposMovims() ;
    
    /**
     * @return instancia da classe local IEstornoTsu
     */
    @Data
    IEstornoTsu iEstornoTsu() ;
    
    @Data(size=1)
    IString iTipoMovTsu() ;
    @Data
    @Condition({ " ", "A" })
    ICondition iMovTsuPtu() ;
    @Data
    @Condition("U")
    ICondition iMovTsuRtu() ;
    
    
    /**
     * @return instancia da classe local Autorizacoes
     */
    @Data
    Autorizacoes autorizacoes() ;
    
    /**
     * @return instancia da classe local BaseIcdcCalcJur
     */
    @Data
    BaseIcdcCalcJur baseIcdcCalcJur() ;
    
    @Data(size=2, value=" ")
    IString swBaseIcdcCalcJur() ;
    @Data
    @Condition("SV")
    ICondition jurosSv() ;
    @Data
    @Condition("SM")
    ICondition jurosSm() ;
    @Data
    @Condition("SD")
    ICondition jurosSvd() ;
    @Data
    @Condition("JM")
    ICondition jurosAoMov() ;
    @Data
    @Condition("SC")
    ICondition jurosSmc() ;
    
    
    /**
     * @return instancia da classe local PlanosRemuneracao
     */
    @Data
    PlanosRemuneracao planosRemuneracao() ;
    
    /**
     * @return instancia da classe local ITipoValQEclo
     */
    @Data
    ITipoValQEclo iTipoValQEclo() ;
    
    /**
     * @return instancia da classe local IEstJuro
     */
    @Data
    IEstJuro iEstJuro() ;
    
    /**
     * @return instancia da classe local IDataPrzTax
     */
    @Data
    IDataPrzTax iDataPrzTax() ;
    
    @Data(size=1)
    IString iTipoCalcTax() ;
    @Data
    @Condition("C")
    ICondition iTipoCalcTaxConst() ;
    @Data
    @Condition("L")
    ICondition iTipoCalcTaxLiq() ;
    
    
    /**
     * @return instancia da classe local ITipoPagJcrx
     */
    @Data
    ITipoPagJcrx iTipoPagJcrx() ;
    
    /**
     * @return instancia da classe local IFrmPagJcrx
     */
    @Data
    IFrmPagJcrx iFrmPagJcrx() ;
    
    @Data(size=1)
    IString estJurosPagCobrar() ;
    @Data
    @Condition("P")
    ICondition iEstJuroPago() ;
    @Data
    @Condition("N")
    ICondition iEstJuroNaoPago() ;
    
    
    /**
     * @return instancia da classe local TipoRegulJuros
     */
    @Data
    TipoRegulJuros tipoRegulJuros() ;
    
    /**
     * @return instancia da classe local TipoRgzzEncg
     */
    @Data
    TipoRgzzEncg tipoRgzzEncg() ;
    
    /**
     * @return instancia da classe local IOrigMovRegJuros
     */
    @Data
    IOrigMovRegJuros iOrigMovRegJuros() ;
    
    /**
     * @return instancia da classe local ITipoMov
     */
    @Data
    ITipoMov iTipoMov() ;
    
    @Data(size=2, value=" ")
    IString iTipoMovVal() ;
    @Data
    @Condition({ "MC", "MD", "LA", "LJ", "EC", "ED", "EL", "NG", "RN" })
    ICondition tipoMovValido() ;
    
    
    /**
     * @return instancia da classe local TipoRegularizacao
     */
    @Data
    TipoRegularizacao tipoRegularizacao() ;
    
    /**
     * @return instancia da classe local EstGatCalcJuros
     */
    @Data
    EstGatCalcJuros estGatCalcJuros() ;
    
    /**
     * @return instancia da classe local ParamPassIncobravel
     */
    @Data
    ParamPassIncobravel paramPassIncobravel() ;
    
    @Data(size=1)
    IString iTipoMont() ;
    @Data
    @Condition("1")
    ICondition juro() ;
    @Data
    @Condition("3")
    ICondition juroMora() ;
    @Data
    @Condition({ "1", "3" })
    ICondition juros() ;
    @Data
    @Condition("2")
    ICondition imposto() ;
    @Data
    @Condition("4")
    ICondition impMora() ;
    @Data
    @Condition({ "2", "4" })
    ICondition impostos() ;
    @Data
    @Condition("5")
    ICondition montLiquido() ;
    
    
    @Data(size=1)
    IString iTipMov() ;
    @Data
    @Condition("L")
    ICondition liquido() ;
    @Data
    @Condition("B")
    ICondition bruto() ;
    
    
    /**
     * @return instancia da classe local CSectIttlBpor
     */
    @Data
    CSectIttlBpor cSectIttlBpor() ;
    
    /**
     * @return instancia da classe local CEstObjDpob
     */
    @Data
    CEstObjDpob cEstObjDpob() ;
    
    /**
     * @return instancia da classe local CTipoOcraDpob
     */
    @Data
    CTipoOcraDpob cTipoOcraDpob() ;
    
    /**
     * @return instancia da classe local IAltMordScta
     */
    @Data
    IAltMordScta iAltMordScta() ;
    
    /**
     * @return instancia da classe local CEstOcraDpob
     */
    @Data
    CEstOcraDpob cEstOcraDpob() ;
    
    /**
     * @return instancia da classe local CEstPrec
     */
    @Data
    CEstPrec cEstPrec() ;
    
    /**
     * @return instancia da classe local ITipoPrec
     */
    @Data
    ITipoPrec iTipoPrec() ;
    
    /**
     * @return instancia da classe local IPrecCndl
     */
    @Data
    IPrecCndl iPrecCndl() ;
    
    /**
     * @return instancia da classe local CModoPag
     */
    @Data
    CModoPag cModoPag() ;
    
    /**
     * @return instancia da classe local CodTabGerais
     */
    @Data
    CodTabGerais codTabGerais() ;
    
    /**
     * @return instancia da classe local AcessoBhgp0030
     */
    @Data
    AcessoBhgp0030 acessoBhgp0030() ;
    
    /**
     * @return instancia da classe local CTgParam
     */
    @Data
    CTgParam cTgParam() ;
    
    /**
     * @return instancia da classe local Descobertos
     */
    @Data
    Descobertos descobertos() ;
    
    /**
     * @return instancia da classe local ISldoCmrgIsdp
     */
    @Data
    ISldoCmrgIsdp iSldoCmrgIsdp() ;
    
    /**
     * @return instancia da classe local IDcboNgcdIsdp
     */
    @Data
    IDcboNgcdIsdp iDcboNgcdIsdp() ;
    
    /**
     * @return instancia da classe local IRnvzDcboNgcd
     */
    @Data
    IRnvzDcboNgcd iRnvzDcboNgcd() ;
    
    /**
     * @return instancia da classe local CEstDngcCmrg
     */
    @Data
    CEstDngcCmrg cEstDngcCmrg() ;
    
    /**
     * @return instancia da classe local IEstRetzSldo
     */
    @Data
    IEstRetzSldo iEstRetzSldo() ;
    
    /**
     * @return instancia da classe local IEstVcob
     */
    @Data
    IEstVcob iEstVcob() ;
    
    /**
     * @return instancia da classe local IOrigLoteVcob
     */
    @Data
    IOrigLoteVcob iOrigLoteVcob() ;
    
    /**
     * @return instancia da classe local IEstadoLote
     */
    @Data
    IEstadoLote iEstadoLote() ;
    
    @Data(size=1)
    IString swIOrigLoteVcob() ;
    @Data
    @Condition("C")
    ICondition swIOrigCtrlAut() ;
    @Data
    @Condition("A")
    ICondition swIOrigAts() ;
    @Data
    @Condition("B")
    ICondition swIOrigAgencia() ;
    @Data
    @Condition("S")
    ICondition swIOrigSibs() ;
    
    
    /**
     * @return instancia da classe local ITipoEtga
     */
    @Data
    ITipoEtga iTipoEtga() ;
    
    @Data(size=1)
    IString iContCrrtAssd() ;
    @Data
    @Condition("S")
    ICondition iContCrrtAssdS() ;
    @Data
    @Condition("N")
    ICondition iContCrrtAssdN() ;
    
    
    /**
     * @return instancia da classe local IRnvzVnct
     */
    @Data
    IRnvzVnct iRnvzVnct() ;
    
    /**
     * @return instancia da classe local ITipoCapzJuro
     */
    @Data
    ITipoCapzJuro iTipoCapzJuro() ;
    
    /**
     * @return instancia da classe local IExisNgczEclo
     */
    @Data
    IExisNgczEclo iExisNgczEclo() ;
    
    /**
     * @return instancia da classe local IExisRstzCont
     */
    @Data
    IExisRstzCont iExisRstzCont() ;
    
    /**
     * @return instancia da classe local IInbzCheq
     */
    @Data
    IInbzCheq iInbzCheq() ;
    
    /**
     * @return instancia da classe local IndInsFundos
     */
    @Data
    IndInsFundos indInsFundos() ;
    
    /**
     * @return instancia da classe local IExisContSpte
     */
    @Data
    IExisContSpte iExisContSpte() ;
    
    /**
     * @return instancia da classe local IEmpsNomeIdvl
     */
    @Data
    IEmpsNomeIdvl iEmpsNomeIdvl() ;
    
    /**
     * @return instancia da classe local IClszTtr1Cont
     */
    @Data
    IClszTtr1Cont iClszTtr1Cont() ;
    
    /**
     * @return instancia da classe local ITipoSpte
     */
    @Data
    ITipoSpte iTipoSpte() ;
    
    /**
     * @return instancia da classe local IRnvzCndzRmnz
     */
    @Data
    IRnvzCndzRmnz iRnvzCndzRmnz() ;
    
    /**
     * @return instancia da classe local NomeTabelas
     */
    @Data
    NomeTabelas nomeTabelas() ;
    
    /**
     * @return instancia da classe local AvsoGerx
     */
    @Data
    AvsoGerx avsoGerx() ;
    
    /**
     * @return instancia da classe local CEstPedidoMapas
     */
    @Data
    CEstPedidoMapas cEstPedidoMapas() ;
    
    @Data(size=7)
    IString cMapa() ;
    @Data
    @Condition("MHO131 ")
    ICondition mDepNgczEnc() ;
    @Data
    @Condition("MHO863 ")
    ICondition mMovMont() ;
    @Data
    @Condition("MHO866 ")
    ICondition mSctaProd() ;
    @Data
    @Condition("MHO867 ")
    ICondition mContTipoInstit() ;
    @Data
    @Condition("MHO868 ")
    ICondition mContZAbert() ;
    @Data
    @Condition("MHO872 ")
    ICondition mMovCont() ;
    @Data
    @Condition("MHO873 ")
    ICondition mMovUserid() ;
    @Data
    @Condition("MHO882 ")
    ICondition mSctaSldo() ;
    @Data
    @Condition("MHO883 ")
    ICondition mSctaZAbra() ;
    @Data
    @Condition("MHO915 ")
    ICondition mJustifJurSldVal() ;
    @Data
    @Condition("MHO916 ")
    ICondition mJustifJurSldMed() ;
    @Data
    @Condition("MHO917 ")
    ICondition mJustifJurAoMovim() ;
    @Data
    @Condition("FHO902 ")
    ICondition depositoEstruturado() ;
    @Data
    @Condition("FHO918 ")
    ICondition fJustifJurSldVal() ;
    @Data
    @Condition("FHO919 ")
    ICondition fJustifJurSldMed() ;
    @Data
    @Condition("FHO920 ")
    ICondition fJustifJurAoMovim() ;
    
    
    /**
     * @return instancia da classe local IEstCbrcDspa
     */
    @Data
    IEstCbrcDspa iEstCbrcDspa() ;
    
    /**
     * @return instancia da classe local ICbrcDspaMntzTho4
     */
    @Data
    ICbrcDspaMntzTho4 iCbrcDspaMntzTho4() ;
    
    /**
     * @return instancia da classe local DespesasManutencao
     */
    @Data
    DespesasManutencao despesasManutencao() ;
    
    @Data(size=4, signed=true, value="987", compression=COMP3)
    IInt cOeEgcCaixaPostal() ;
    
    /**
     * @return instancia da classe local COpeBbnAglut
     */
    @Data
    COpeBbnAglut cOpeBbnAglut() ;
    
    /**
     * @return instancia da classe local IEstViaSpte
     */
    @Data
    IEstViaSpte iEstViaSpte() ;
    
    /**
     * @return instancia da classe local IMovAglxPer
     */
    @Data
    IMovAglxPer iMovAglxPer() ;
    
    /**
     * @return instancia da classe local IMovAglxAtzUlt
     */
    @Data
    IMovAglxAtzUlt iMovAglxAtzUlt() ;
    
    /**
     * @return instancia da classe local IMovActzUlt
     */
    @Data
    IMovActzUlt iMovActzUlt() ;
    
    /**
     * @return instancia da classe local CProtCont
     */
    @Data
    CProtCont cProtCont() ;
    
    @Data(size=5)
    IString cOpeBbnIdentifMov() ;
    @Data
    @Condition("HVB58")
    ICondition cOpeMovProtClay() ;
    @Data
    @Condition({ "HVB56", "HVA66" })
    ICondition cOpeMovProtUnve() ;
    @Data
    @Condition({ "HVC31", "HVC35", "HVC36" })
    ICondition cOpeMovEntdBanc() ;
    
    
    /**
     * @return instancia da classe local CTipoPremio
     */
    @Data
    CTipoPremio cTipoPremio() ;
    
    /**
     * @return instancia da classe local Premios
     */
    @Data
    Premios premios() ;
    
    /**
     * @return instancia da classe local CEstPremOpps
     */
    @Data
    CEstPremOpps cEstPremOpps() ;
    
    /**
     * @return instancia da classe local GatilhosVespera
     */
    @Data
    GatilhosVespera gatilhosVespera() ;
    
    /**
     * @return instancia da classe local EstGatVespera
     */
    @Data
    EstGatVespera estGatVespera() ;
    
    /**
     * @return instancia da classe local Gatilhos
     */
    @Data
    Gatilhos gatilhos() ;
    
    @Data(size=3, signed=true)
    IInt cCndzMovzCont() ;
    @Data
    @Condition("002")
    ICondition cCndzMovMenor() ;
    @Data
    @Condition("094")
    ICondition cCndzMovEmbargada() ;
    @Data
    @Condition("099")
    ICondition cCndzMovMenNAut() ;
    @Data
    @Condition("999")
    ICondition cCndzMovIndividual() ;
    
    
    /**
     * @return instancia da classe local CndzMovzContIdade
     */
    @Data
    CndzMovzContIdade cndzMovzContIdade() ;
    
    /**
     * @return instancia da classe local NsCodTrfDia
     */
    @Data
    NsCodTrfDia nsCodTrfDia() ;
    
    /**
     * @return instancia da classe local ParamPassHist
     */
    @Data
    ParamPassHist paramPassHist() ;
    
    /**
     * @return instancia da classe local ISitLoteVcob
     */
    @Data
    ISitLoteVcob iSitLoteVcob() ;
    
    /**
     * @return instancia da classe local CCmczCli
     */
    @Data
    CCmczCli cCmczCli() ;
    
    /**
     * @return instancia da classe local IOrigemFichLr
     */
    @Data
    IOrigemFichLr iOrigemFichLr() ;
    
    /**
     * @return instancia da classe local LrImpSelSmDevedor
     */
    @Data
    LrImpSelSmDevedor lrImpSelSmDevedor() ;
    
    /**
     * @return instancia da classe local LrEncargos
     */
    @Data
    LrEncargos lrEncargos() ;
    
    /**
     * @return instancia da classe local LrDespesaManutencao
     */
    @Data
    LrDespesaManutencao lrDespesaManutencao() ;
    
    /**
     * @return instancia da classe local LrAnulCbrEncg
     */
    @Data
    LrAnulCbrEncg lrAnulCbrEncg() ;
    
    /**
     * @return instancia da classe local LrJurosAPagar
     */
    @Data
    LrJurosAPagar lrJurosAPagar() ;
    
    /**
     * @return instancia da classe local LrJurosACobrar
     */
    @Data
    LrJurosACobrar lrJurosACobrar() ;
    
    /**
     * @return instancia da classe local LrLiqVencDepositos
     */
    @Data
    LrLiqVencDepositos lrLiqVencDepositos() ;
    
    /**
     * @return instancia da classe local LrLiqVencDepEstr
     */
    @Data
    LrLiqVencDepEstr lrLiqVencDepEstr() ;
    
    /**
     * *COBRANCA FIRME ENCARGOS LIQUIDOS SOBRE EMISSAO EXTRACTO SIMPLES
     * @return instancia da classe local LrEncgExtrSimples
     */
    @Data
    LrEncgExtrSimples lrEncgExtrSimples() ;
    
    @Data(size=3, signed=true, compression=COMP3)
    IInt swServPrdCgd() ;
    @Data
    @Condition("114")
    ICondition swIsCServPrsdCgd() ;
    @Data
    @Condition("113")
    ICondition swEcCServPrsdCgd() ;
    @Data
    @Condition("513")
    ICondition swAnServPrsdCgd() ;
    @Data
    @Condition({ "113", "513" })
    ICondition swEncargosServPrsd() ;
    @Data
    @Condition("112")
    ICondition swMtCServPrsdCgd() ;
    @Data
    @Condition("510")
    ICondition swPgJuroCgd() ;
    @Data
    @Condition("111")
    ICondition swCbJuroCgd() ;
    @Data
    @Condition("110")
    ICondition swCbJuroFirme() ;
    @Data
    @Condition({ "510", "111", "110" })
    ICondition swJurosServPrsd() ;
    @Data
    @Condition("511")
    ICondition swLqServPrsdCgd() ;
    @Data
    @Condition("512")
    ICondition swLqSvPrsdCgdEst() ;
    @Data
    @Condition("117")
    ICondition swEcServExtrSCgd() ;
    
    
    /**
     * @return instancia da classe local BloqueiosContas
     */
    @Data
    BloqueiosContas bloqueiosContas() ;
    
    @Data(size=1)
    IString iGrazCoe() ;
    @Data
    @Condition("S")
    ICondition iGrazCoeSim() ;
    @Data
    @Condition("N")
    ICondition iGrazCoeNao() ;
    @Data
    @Condition("D")
    ICondition iGrazCoeDecgS() ;
    @Data
    @Condition("G")
    ICondition iGrazCoeDecgN() ;
    
    
    @Data(size=3, value="088")
    IString cTipOptBporDecg() ;
    
    /**
     * @return instancia da classe local CCmnzSgpd
     */
    @Data
    CCmnzSgpd cCmnzSgpd() ;
    
    /**
     * @return instancia da classe local XRefMovAbr
     */
    @Data
    XRefMovAbr xRefMovAbr() ;
    
    @Data(size=1, value="I")
    IString iTipoFmonIcb() ;
    
    /**
     * @return instancia da classe local PedidoAltCalJur
     */
    @Data
    PedidoAltCalJur pedidoAltCalJur() ;
    
    /**
     * @return instancia da classe local EstadoPagamentoEnc
     */
    @Data
    EstadoPagamentoEnc estadoPagamentoEnc() ;
    
    /**
     * @return instancia da classe local CImpostosSelo
     */
    @Data
    CImpostosSelo cImpostosSelo() ;
    
    /**
     * @return instancia da classe local DadosFicheiroCrm
     */
    @Data
    DadosFicheiroCrm dadosFicheiroCrm() ;
    
    /**
     * @return instancia da classe local CTransaccao
     */
    @Data
    CTransaccao cTransaccao() ;
    
    /**
     * @return instancia da classe local CSitIcpt
     */
    @Data
    CSitIcpt cSitIcpt() ;
    
    /**
     * @return instancia da classe local CTipoMovIcpt
     */
    @Data
    CTipoMovIcpt cTipoMovIcpt() ;
    
    /**
     * @return instancia da classe local Rotinas
     */
    @Data
    Rotinas rotinas() ;
    
    /**
     * @return instancia da classe local CMtvoDvlChq
     */
    @Data
    CMtvoDvlChq cMtvoDvlChq() ;
    
    /**
     * @return instancia da classe local CEstCvProd
     */
    @Data
    CEstCvProd cEstCvProd() ;
    
    /**
     * @return instancia da classe local IContrapartida
     */
    @Data
    IContrapartida iContrapartida() ;
    
    /**
     * @return instancia da classe local CodigoMovimentacao
     */
    @Data
    CodigoMovimentacao codigoMovimentacao() ;
    
    /**
     * @return instancia da classe local CodigoOperacaoTrf
     */
    @Data
    CodigoOperacaoTrf codigoOperacaoTrf() ;
    
    /**
     * @return instancia da classe local CTipoPagamento02
     */
    @Data
    CTipoPagamento02 cTipoPagamento02() ;
    
    /**
     * @return instancia da classe local CEstadoPendente
     */
    @Data
    CEstadoPendente cEstadoPendente() ;
    
    /**
     * @return instancia da classe local IMobilizacao
     */
    @Data
    IMobilizacao iMobilizacao() ;
    
    @Data(size=4, value="9930")
    IInt bancoOffShore() ;
    
    @Data(size=4, value="35")
    IInt bancoCoeOffShore() ;
    
    /**
     * @return instancia da classe local Modelo15
     */
    @Data
    Modelo15 modelo15() ;
    
    @Data(size=1)
    IString iTipoPnlz() ;
    @Data
    @Condition("D")
    ICondition iTipoPnlzDias() ;
    @Data
    @Condition("A")
    ICondition iTipoPnlzAmbas() ;
    @Data
    @Condition("T")
    ICondition iTipoPnlzTaxa() ;
    
    
    /**
     * @return instancia da classe local IMobaPsvl
     */
    @Data
    IMobaPsvl iMobaPsvl() ;
    
    @Data(size=1)
    IString cEstMsgSwifPed() ;
    @Data
    @Condition("A")
    ICondition msgSwifPedActiva() ;
    @Data
    @Condition("I")
    ICondition msgSwifPedInact() ;
    @Data
    @Condition("T")
    ICondition msgSwifPedTodas() ;
    
    
    @Data(size=5, value="MT920")
    IString mt920() ;
    
    @Data(size=5, value="MT941")
    IString mt941() ;
    
    @Data(size=5, value="MT942")
    IString mt942() ;
    
    @Data(size=8, value="00359310")
    IString cBancEmi() ;
    
    @Data(size=3, value="SCE")
    IString cEntDest() ;
    
    /**
     * @return instancia da classe local ITipoCndzEspl
     */
    @Data
    ITipoCndzEspl iTipoCndzEspl() ;
    
    @Data(size=1)
    IString estadoMovCnos() ;
    @Data
    @Condition("I")
    ICondition movCnosIrrec() ;
    @Data
    @Condition("E")
    ICondition movCnosEstrIrre() ;
    @Data
    @Condition("R")
    ICondition movCnosReconc() ;
    @Data
    @Condition("F")
    ICondition movCnosEstrRec() ;
    
    
    /**
     * @return instancia da classe local EstadoMovNostro
     */
    @Data
    EstadoMovNostro estadoMovNostro() ;
    
    /**
     * @return instancia da classe local IIgdeIrTitc
     */
    @Data
    IIgdeIrTitc iIgdeIrTitc() ;
    
    @Data(size=1)
    IString swIIgdeIrTitc() ;
    @Data
    @Condition("S")
    ICondition swIgdIrTitSim() ;
    @Data
    @Condition("N")
    ICondition swIgdIrTitNao() ;
    @Data
    @Condition("P")
    ICondition swIgdIrTitEspec() ;
    @Data
    @Condition("X")
    ICondition swIgdIrTitSemSig() ;
    
    
    @Data(size=5, value="HVG12")
    IString cOpeBbnEntrEstado() ;
    
    @Data(size=1, value="9")
    IString cFineMovIntEmpr() ;
    
    @Data(size=8, value="MHTS200A")
    IString rotinaMhts200a() ;
    
    @Data(size=4, value="HVK9")
    IString transCtaCorrente() ;
    
    @Data(size=3, value="109")
    IString cOpczCtaCorrente() ;
    
    @Data(size=3, value="CGD")
    IString cMnemEmpCpd() ;
    
    @Data(size=3, value="PT")
    IString cPaisIsoaCpd() ;
    
    @Data(size=4, signed=true, value="9500", compression=COMP3)
    IInt cOeCpd() ;
    
    @Data(size=1, value="P")
    IString ctaCorrenteProc() ;
    
    @Data(size=1, value="N")
    IString ctaCorrenteNProc() ;
    
    @Data(size=3, value="004")
    IString ldnScoring() ;
    
    /**
     * @return instancia da classe local ITipoNmri
     */
    @Data
    ITipoNmri iTipoNmri() ;
    
    /**
     * @return instancia da classe local CTipoTaxPpgmGtb
     */
    @Data
    CTipoTaxPpgmGtb cTipoTaxPpgmGtb() ;
    
    @Data(size=3, value="520")
    IString cFamiProdSup() ;
    
    @Data(size=3, value="001")
    IString cProdutoCadern() ;
    
    @Data(size=3, value="002")
    IString cProdutoTitulo() ;
    
    @Data(size=3, value="003")
    IString cProdutoExtracto() ;
    
    @Data(size=8, value="YCDHO247")
    IString cUserExciDes() ;
    
    @Data(size=8, value="YCIHO247")
    IString cUserExciInt() ;
    
    @Data(size=8, value="YCQHO247")
    IString cUserExciCq() ;
    
    @Data(size=8, value="YCPHO247")
    IString cUserExciPrd() ;
    
    @Data(size=2)
    IString sistemaControlConta() ;
    @Data
    @Condition("BB")
    ICondition contaBb() ;
    
    
    @Data(size=3, value="997")
    IString cFamiProdAvsGen() ;
    
    @Data(size=3, value="001")
    IString cProdutoAvsGen() ;
    
    /**
     * @return instancia da classe local CTipoCont
     */
    @Data
    CTipoCont cTipoCont() ;
    
    /**
     * @return instancia da classe local CFineScta
     */
    @Data
    CFineScta cFineScta() ;
    
    /**
     * @return instancia da classe local CFamiProd
     */
    @Data
    CFamiProd cFamiProd() ;
    
    /**
     * @return instancia da classe local ConstMoselle
     */
    @Data
    ConstMoselle constMoselle() ;
    
    /**
     * @return instancia da classe local CProduto
     */
    @Data
    CProduto cProduto() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOK0002 - CONSTANTES DA APLICACAO DE PASSIVAS
     * TEMAS PENDENTES:
     * PROCURAR TERESA
     * PROCURAR DORIS
     * PROCURAR RPAULO
     * PROCURAR FMUNHOZ
     * PROCURAR LR-PENDENTES
     * SITUACOES DE CONTA, SUBCONTA E TIPOS DE TRATAMENTO DE CONTA
     * 
     * @version 2.0
     * 
     */
    public interface TipoTrttCont extends IDataStruct {
        
        @Data(size=2, value="01")
        IString trttDepOrdem() ;
        
        @Data(size=2, value="02")
        IString trttPoupanca() ;
        
        @Data(size=2, value="03")
        IString trttDepPrazo() ;
        
        @Data(size=2, value="09")
        IString trttDepEstru() ;
        
        @Data(size=2, value="12")
        IString trttDepObrig() ;
        
        @Data(size=2, value="19")
        IString trttCtaMarg() ;
        
        @Data(size=2, value="26")
        IString trttCashCarry() ;
        
        @Data(size=2, value="27")
        IString trttCtaVostr() ;
        
        @Data(size=2, value="28")
        IString trttCtaNostr() ;
        
        @Data(size=2, value="32")
        IString trttCtaInter() ;
        
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
    public interface EstPedAltSubconta extends IDataStruct {
        
        @Data(size=1, value="A")
        IString pedAltSctaAceite() ;
        
        @Data(size=1, value="P")
        IString pedAltSctaPedido() ;
        
        @Data(size=1, value="R")
        IString pedAltSctaRejeit() ;
        
    }
    public interface IExiAtzJourBbn extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iExiAtzJourBbnS() ;
        
        @Data(size=1, value="N")
        IString iExiAtzJourBbnN() ;
        
    }
    public interface TpConta extends IDataStruct {
        
        @Data(size=1, value="E")
        IString tpContaEmpresa() ;
        
        @Data(size=1, value="P")
        IString tpContaParticular() ;
        
        @Data(size=1, value="M")
        IString tpContaMenores() ;
        
    }
    public interface MtvoRelCont extends IDataStruct {
        
        @Data(size=3, value="111")
        IString relDoSpte() ;
        
        @Data(size=3, value="002")
        IString relJuCredor() ;
        
        @Data(size=3, value="003")
        IString relJuDevedor() ;
        
        @Data(size=3, value="029")
        IString agendaTransferenc() ;
        
    }
    public interface SwSldoContrNat extends IDataStruct {
        
        @Data(size=1, value="S")
        IString swSldoContrNatS() ;
        
        @Data(size=1, value="N")
        IString swSldoContrNatN() ;
        
    }
    
    /**
     * 
     * FMUNHOZ * INICIO ALT ESTORNADO E->A ESTORNADOR R->E
     * 
     * @version 2.0
     * 
     */
    public interface SituacaoMov extends IDataStruct {
        
        @Data(size=1, value="A")
        IString sitMovEstornado() ;
        
        @Data(size=1, value="E")
        IString sitMovEstornador() ;
        
    }
    
    /**
     * 
     * FMUNHOZ * FIM
     * 
     * @version 2.0
     * 
     */
    public interface Tabelas extends IDataStruct {
        
        @Data(size=1, value="1")
        IInt conTabMov1() ;
        
        @Data(size=1, value="2")
        IInt conTabMov2() ;
        
    }
    public interface TipoPrazos extends IDataStruct {
        
        @Data(size=4, value="1")
        IInt tipoPrDia() ;
        
    }
    public interface IEstPed extends IDataStruct {
        
        @Data(size=1, value="A")
        IString iEstPedAceite() ;
        
        @Data(size=1, value="R")
        IString iEstPedRejeitado() ;
        
        @Data(size=1, value="P")
        IString iEstPedProcessar() ;
        
        @Data(size=1, value="E")
        IString iEstPedEliminado() ;
        
    }
    public interface TipoCheque extends IDataStruct {
        
        @Data(size=1, value="V")
        IString cheqVisado() ;
        
        @Data(size=1, value="N")
        IString cheqNormal() ;
        
        @Data(size=1, value="B")
        IString cheqBancario() ;
        
        @Data(size=1, value="C")
        IString cartaCheque() ;
        
    }
    public interface CanaisAcesso extends IDataStruct {
        
        @Data(size=4, value="ATS")
        IString canalAts() ;
        
        @Data(size=4, value="BALC")
        IString canalBalcao() ;
        
        @Data(size=4, value="BATC")
        IString canalBatch() ;
        
        @Data(size=4, value="SIBS")
        IString canalSibs() ;
        
        @Data(size=4, value="LCRT")
        IString canalLancRetaguarda() ;
        
        @Data(size=4, value="SWIF")
        IString canalSwift() ;
        
    }
    public interface ISitPedAltOe extends IDataStruct {
        
        @Data(size=1, value="A")
        IString altOeAceite() ;
        
        @Data(size=1, value="P")
        IString altOePedido() ;
        
        @Data(size=1, value="R")
        IString altOeRejeitado() ;
        
    }
    public interface IIsezIs extends IDataStruct {
        
        @Data(size=1, value="I")
        IString isIsento() ;
        
        @Data(size=1, value="N")
        IString isNaoPago() ;
        
        @Data(size=1, value="P")
        IString isPago() ;
        
    }
    public interface CImpostoIr extends IDataStruct {
        
        @Data(size=3, value="IRS")
        IString irIrs() ;
        
        @Data(size=3, value="IRC")
        IString irIrc() ;
        
    }
    public interface EstGatConta extends IDataStruct {
        
        @Data(size=1, value="P")
        IString gatContaProc() ;
        
        @Data(size=1, value="N")
        IString gatContaNProc() ;
        
    }
    public interface IDcvoEspl extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iDcvoEsplN() ;
        
        @Data(size=1, value="S")
        IString iDcvoEsplS() ;
        
    }
    public interface IEstAltProduto extends IDataStruct {
        
        @Data(size=1, value="A")
        IString iSitAltProdAceite() ;
        
        @Data(size=1, value="P")
        IString iSitAltProdPedido() ;
        
        @Data(size=1, value="R")
        IString iSitAltProdRejeit() ;
        
    }
    public interface INtzaProd extends IDataStruct {
        
        @Data(size=1, value="D")
        IString ntzaDevedora() ;
        
        @Data(size=1, value="C")
        IString ntzaCredora() ;
        
    }
    
    /**
     * 
     * ENCARGOS
     * 
     * @version 2.0
     * 
     */
    public interface IEstNegEclo extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iEstNegNaoExiste() ;
        
        @Data(size=1, value="S")
        IString iEstNegAprovado() ;
        
        @Data(size=1, value="P")
        IString iEstNegPendente() ;
        
    }
    public interface TipoDeEscalao extends IDataStruct {
        
        @Data(size=1, value="M")
        IString escalEncMont() ;
        
        @Data(size=1, value="Q")
        IString escalEncQtd() ;
        
    }
    public interface ITipCondEsp extends IDataStruct {
        
        @Data(size=1, value="R")
        IString tipRelativo() ;
        
        @Data(size=1, value="F")
        IString tipFixo() ;
        
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
    public interface CEstEncgPend extends IDataStruct {
        
        @Data(size=1, value="A")
        IString actPendente() ;
        
    }
    
    /**
     * 
     * INTERVENIENTES DE CONTA
     * 
     * @version 2.0
     * 
     */
    public interface ITipoItvt extends IDataStruct {
        
        @Data(size=3, signed=true, value="101", compression=COMP3)
        IInt itvtTitular() ;
        
        @Data(size=3, signed=true, value="106", compression=COMP3)
        IInt itvtAutorizado() ;
        
    }
    public interface NsTitc extends IDataStruct {
        
        @Data(size=3, signed=true, value="1", compression=COMP3)
        IInt primeiroTitular() ;
        
        @Data(size=3, signed=true, value="2", compression=COMP3)
        IInt segundoTitular() ;
        
        @Data(size=3, signed=true, value="3", compression=COMP3)
        IInt terceiroTitular() ;
        
    }
    public interface CTipoCli extends IDataStruct {
        
        @Data(size=1, value="P")
        IString cliParticular() ;
        
        @Data(size=1, value="E")
        IString cliEmpresa() ;
        
        @Data(size=1, value="I")
        IString cliEni() ;
        
    }
    
    /**
     * 
     * SEQUENCIADORES
     * 
     * @version 2.0
     * 
     */
    public interface Sequenciadores extends IDataStruct {
        
        @Data(size=20, value="ASSOC-CTA")
        IString seqAssCnt() ;
        
        @Data(size=20, value="PPCJ003")
        IString seqPpcj003() ;
        
        @Data(size=20, value="PPCJ006")
        IString seqPpcj006() ;
        
    }
    public interface CFicheiro extends IDataStruct {
        
        @Data(size=3, value="SCE")
        IString cFichSce() ;
        
        @Data(size=3, value="DEE")
        IString cFichDee() ;
        
        @Data(size=4, value="MCGD")
        IString cFichMcgd() ;
        
        @Data(size=4, value="CPCJ")
        IString cFichCpcj() ;
        
        @Data(size=3, value="IGF")
        IString cFichIgf() ;
        
        @Data(size=3, value="SEG")
        IString cFichSegNovRenov() ;
        
        @Data(size=3, value="EXE")
        IString cFichExe() ;
        
    }
    
    /**
     * 
     * DEFAULT CONTABILIZACAO
     * 
     * @version 2.0
     * 
     */
    public interface DefaultContab extends IDataStruct {
        
        @Data(size=3, value="999")
        IString famProdDfltContab() ;
        
        @Data(size=3, value="999")
        IString prodDfltContab() ;
        
        @Data(size=7, signed=true, value="9999999", compression=COMP3)
        IInt sectIttlDfltContab() ;
        
    }
    public interface CIcdcOpe extends IDataStruct {
        
        @Data(size=2, value="A4")
        IString cIcdcOpeCaixa() ;
        
        @Data(size=2, value="A5")
        IString cIcdcOpeDebito() ;
        
        @Data(size=2, value="A6")
        IString cIcdcOpeCredito() ;
        
        @Data(size=2, value="A7")
        IString cIcdcOpeChqVisado() ;
        
        @Data(size=2, value="A8")
        IString cIcdcOpeChqBanc() ;
        
        @Data(size=2, value="A9")
        IString cIcdcOpeCartaChq() ;
        
        @Data(size=2, value="51")
        IString cIcdcOpeCapital() ;
        
        @Data(size=2, value="58")
        IString cIcdcOpeJuros() ;
        
        @Data(size=2, value="N9")
        IString cIcdcOpeAno() ;
        
        @Data(size=2, value="O1")
        IString cIcdcOpeAant() ;
        
        @Data(size=2, value="91")
        IString cBaseIcdcEncgCoe() ;
        
        @Data(size=2, value="03")
        IString cBaseIcdcImpCoe() ;
        
        @Data(size=2, value="N9")
        IString cIcdcOpePerAno() ;
        
        @Data(size=2, value="O1")
        IString cIcdcOpePerAant() ;
        
    }
    
    /**
     * 
     * FICHEIRO MOVIMENTOS JUSTIFICADOS
     * 
     * @version 2.0
     * 
     */
    public interface FichMovJustificados extends IDataStruct {
        
        @Data(size=1, value="2")
        IInt codMobiliz() ;
        
        @Data(size=1, value="0")
        IInt codAlterac() ;
        
        @Data(size=1, value="1")
        IString tipoDeclaracao() ;
        
    }
    
    /**
     * 
     * SEGUROS
     * CODIGOS DE FAMILIA/PRODUTO SEGUROS (ACTUALIZAR QD DEFENIDO)
     * 
     * @version 2.0
     * 
     */
    public interface Codigo extends IDataStruct {
        
        @Data(size=3, value="503")
        IString familiaSeguros() ;
        
        @Data(size=3, value="004")
        IString produtoSeguros() ;
        
    }
    public interface EstadoAssServico extends IDataStruct {
        
        @Data(size=1, value="P")
        IString assSeguroPedida() ;
        
        @Data(size=1, value="N")
        IString assSeguroNova() ;
        
        @Data(size=1, value="R")
        IString assSeguroRenovada() ;
        
        @Data(size=1, value="X")
        IString assSeguroNaoRenov() ;
        
        @Data(size=1, value="A")
        IString assSeguroNaoAceite() ;
        
        @Data(size=1, value="C")
        IString assSeguroCancelada() ;
        
    }
    public interface MotivoAnulServico extends IDataStruct {
        
        @Data(size=1, value="F")
        IString cClienteMorto() ;
        
        @Data(size=1, value="E")
        IString cSubcontaEncerrada() ;
        
        @Data(size=1, value="Z")
        IString cNaoAceiteCliente() ;
        
        @Data(size=1, value="C")
        IString cCondicoesNSatisf() ;
        
    }
    
    /**
     * 
     * CASH POOLING / CASH MANAGEMENT / CASH CARRY
     * 
     * @version 2.0
     * 
     */
    public interface EstGrupCash extends IDataStruct {
        
        @Data(size=1, value="I")
        IString inactivo() ;
        
        @Data(size=1, value="A")
        IString activo() ;
        
    }
    public interface TiposCashPooling extends IDataStruct {
        
        @Data(size=2, value="01")
        IString cashPoolingTipo1() ;
        
        @Data(size=2, value="02")
        IString cashPoolingTipo2() ;
        
        @Data(size=2, value="03")
        IString cashPoolingTipo3() ;
        
        @Data(size=2, value="04")
        IString cashPoolingTipo4() ;
        
        @Data(size=2, value="05")
        IString cashPoolingTipo5() ;
        
    }
    public interface TiposCashManagement extends IDataStruct {
        
        @Data(size=2, value="01")
        IString cashManagementTp1() ;
        
        @Data(size=2, value="02")
        IString cashManagementTp2() ;
        
    }
    public interface TipoAssConta extends IDataStruct {
        
        @Data(size=2, value="CP")
        IString tipoAssContaCp() ;
        
        @Data(size=2, value="CM")
        IString tipoAssContaCm() ;
        
        @Data(size=2, value="CC")
        IString tipoAssContaCc() ;
        
    }
    public interface TiposCashCarry extends IDataStruct {
        
        @Data(size=2, value="01")
        IString cashCarryTipo1() ;
        
    }
    public interface DescobertoCashCarry extends IDataStruct {
        
        @Data(size=3, value="002")
        IString cDcboNgcCashCarry() ;
        
    }
    
    /**
     * 
     * EXTRACTOS
     * 
     * @version 2.0
     * 
     */
    public interface IExrtCmbd extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iExrtCmbdS() ;
        
        @Data(size=1, value="N")
        IString iExrtCmbdN() ;
        
    }
    public interface IEstPedExrt extends IDataStruct {
        
        @Data(size=1, value="A")
        IString pedExtractoActivo() ;
        
        @Data(size=1, value="P")
        IString pedExtrProcessado() ;
        
        @Data(size=1, value="R")
        IString pedExtrProcCErro() ;
        
    }
    public interface IInfAdiExrt extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iInfAdiExrtS() ;
        
        @Data(size=1, value="N")
        IString iInfAdiExrtN() ;
        
    }
    
    /**
     * 
     * MOVIMENTOS POUPANCAS
     * 
     * @version 2.0
     * 
     */
    public interface IEstJstzMov extends IDataStruct {
        
        @Data(size=1, value="J")
        IString movPoupJustificado() ;
        
        @Data(size=1, value="I")
        IString movPoupInjustificad() ;
        
        @Data(size=1, value="R")
        IString movPoupComReserva() ;
        
    }
    public interface IEstMovPoup extends IDataStruct {
        
        @Data(size=1, value="P")
        IString movPoupProcessado() ;
        
        @Data(size=1, value="N")
        IString movPoupNaoProcess() ;
        
        @Data(size=1, value="E")
        IString movPoupEstornado() ;
        
    }
    public interface CJustzMoveDeb extends IDataStruct {
        
        @Data(size=3, value="DRI")
        IString cJstzMovDebImpost() ;
        
        @Data(size=3, value="OHP")
        IString cJstzLevObHabPer() ;
        
        @Data(size=3, value="OHA")
        IString cJstzLevObArrend() ;
        
        @Data(size=3, value="DPR")
        IString cJstzRegPremio() ;
        
    }
    
    /**
     * 
     * *DORIS*FIM*
     * ROTINA DATAS
     * 
     * @version 2.0
     * 
     */
    public interface ConRotDatas extends IDataStruct {
        
        @Data(size=2, value="03")
        IString conUltDUtilMes() ;
        
        @Data(size=2, value="06")
        IString conSubtraiDatas() ;
        
        @Data(size=2, value="09")
        IString conUltDiaMes() ;
        
        @Data(size=2, value="21")
        IString conAdicPrzData() ;
        
        @Data(size=2, value="23")
        IString conSubtrPrzData() ;
        
        @Data(size=2, value="25")
        IString conAdicPrzDatUtil() ;
        
        @Data(size=2, value="27")
        IString conSubDiasUtDat() ;
        
        @Data(size=2, value="33")
        IString conSumDia() ;
        
        @Data(size=2, value="34")
        IString conMenosDia() ;
        
        @Data(size=4, signed=true, value="1", compression=COMP3)
        IInt conTipoPrazDia() ;
        
        @Data(size=4, signed=true, value="0", compression=COMP3)
        IInt conTipoPrazZero() ;
        
        @Data(size=4, signed=true, value="4", compression=COMP3)
        IInt conTipoPrazMes() ;
        
        @Data(size=4, signed=true, value="9", compression=COMP3)
        IInt conTipoPrazAno() ;
        
    }
    public interface PrazosDias extends IDataStruct {
        
        @Data(size=2, value="31")
        IInt mensal() ;
        
        @Data(size=2, value="92")
        IInt trimestral() ;
        
        @Data(size=3, value="184")
        IInt semestral() ;
        
        @Data(size=3, value="365")
        IInt anual() ;
        
    }
    
    /**
     * 
     * PROTOCOLOS: DUCS / TSUS / GTRBS
     * 
     * @version 2.0
     * 
     */
    public interface CsitoperDuc extends IDataStruct {
        
        @Data(size=1, value="P")
        IString cobrNEnv() ;
        
        @Data(size=1, value="E")
        IString cobrEnviado() ;
        
        @Data(size=1, value="N")
        IString corrNifNEnv() ;
        
        @Data(size=1, value="M")
        IString corrMontNEnv() ;
        
        @Data(size=1, value="A")
        IString corrNifMontNEnv() ;
        
        @Data(size=1, value="V")
        IString corrEnviado() ;
        
        @Data(size=1, value="X")
        IString estornado() ;
        
    }
    public interface CEstMovTsu extends IDataStruct {
        
        @Data(size=1, value="P")
        IString pagoNaoEnviado() ;
        
        @Data(size=1, value="E")
        IString pagoEnviado() ;
        
        @Data(size=1, value="C")
        IString recebidoOk() ;
        
        @Data(size=1, value="R")
        IString recComErro() ;
        
        @Data(size=1, value="X")
        IString tsuEstornado() ;
        
    }
    public interface CEstMovGtrb extends IDataStruct {
        
        @Data(size=1, value="B")
        IString anulNaoEnviado() ;
        
        @Data(size=1, value="L")
        IString anuladEnviado() ;
        
        @Data(size=1, value="E")
        IString enviado() ;
        
        @Data(size=1, value="P")
        IString naoEnviado() ;
        
        @Data(size=1, value="X")
        IString gtrbEstornada() ;
        
    }
    public interface PedidoFotocopias extends IDataStruct {
        
        @Data(size=1, value="P")
        IString fotocopiaPedido() ;
        
        @Data(size=1, value="A")
        IString fotocopiaAceite() ;
        
    }
    public interface PrzMaxPedFot extends IDataStruct {
        
        @Data(size=4, value="4")
        IInt przMaxPedFotCod() ;
        
        @Data(size=5, value="18")
        IInt przMaxPedFotDur() ;
        
    }
    public interface EntidadesFich extends IDataStruct {
        
        @Data(size=3, value="DGC")
        IString cDgc() ;
        
        @Data(size=3, value="CGD")
        IString cCgd() ;
        
    }
    public interface CTipoPagamento extends IDataStruct {
        
        @Data(size=1, value="N")
        IString numerario() ;
        
        @Data(size=1, value="V")
        IString valor() ;
        
        @Data(size=1, value="T")
        IString transferencia() ;
        
        @Data(size=1, value="E")
        IString misto() ;
        
    }
    public interface CtipdocDuc extends IDataStruct {
        
        @Data(size=1, value="1")
        IString liqPrevia() ;
        
        @Data(size=1, value="2")
        IString autoLiq() ;
        
    }
    public interface ITrttDgiDuc extends IDataStruct {
        
        @Data(size=1, value="N")
        IString detAliqNEnv() ;
        
        @Data(size=1, value="S")
        IString detAliqEnviado() ;
        
    }
    public interface TiposMovims extends IDataStruct {
        
        @Data(size=3, value="PTU")
        IString movimPtu() ;
        
        @Data(size=3, value="RTU")
        IString movimRtu() ;
        
        @Data(size=3, value="DIV")
        IString movimDiv() ;
        
    }
    public interface IEstornoTsu extends IDataStruct {
        
        @Data(size=1, value=" ")
        IString tsuSemEstorno() ;
        
        @Data(size=1, value="E")
        IString tsuEstornados() ;
        
        @Data(size=1, value="R")
        IString tsuEstornador() ;
        
        @Data(size=1, value="A")
        IString tsuAnulado() ;
        
        @Data(size=1, value="U")
        IString tsuAnulador() ;
        
        @Data(size=1, value="L")
        IString tsuAnulEstornada() ;
        
        @Data(size=1, value="T")
        IString tsuEstornadorAnul() ;
        
    }
    
    /**
     * 
     * AUTORIZACOES
     * 
     * @version 2.0
     * 
     */
    public interface Autorizacoes extends IDataStruct {
        
        @Data(size=1, value="A")
        IString iAtrzLiqPremios() ;
        
        @Data(size=1, value="B")
        IString iAtrzLiqTrsfFutur() ;
        
        @Data(size=1, value="H")
        IString iAtrzChqActivos() ;
        
        @Data(size=1, value="T")
        IString iAtrzLiqMovRetro() ;
        
        @Data(size=1, value="J")
        IString iAtrzLdnExc() ;
        
        @Data(size=1, value="F")
        IString iAtrzLimCmrg() ;
        
        @Data(size=1, value="L")
        IString iAtrzLimDngd() ;
        
        @Data(size=1, value="M")
        IString iAtrzMovFutRejeit() ;
        
        @Data(size=1, value="N")
        IString iAtrzPrazoDngd() ;
        
        @Data(size=1, value="V")
        IString iAtrzPremioActivo() ;
        
        @Data(size=1, value="X")
        IString iAtrzOeGestor() ;
        
        @Data(size=1, value="S")
        IString iAtrzSldoDpnlCat() ;
        
        @Data(size=1, value="I")
        IString iAtrzSitIcpt() ;
        
        @Data(size=1, value="G")
        IString iAtrzNecMontPrec() ;
        
        @Data(size=1, value="A")
        IString iAtrzAnulCbrEncg() ;
        
        /**
         * AUTORIZACOES DA ROTINA DE MOVIMENTACAO
         */
        @Data(size=1, value="D")
        IString iAtrzBbnDant() ;
        
        @Data(size=1, value="C")
        IString iAtrzBbnMsldCblo() ;
        
        @Data(size=1, value="E")
        IString iAtrzBbnMsldDpnl() ;
        
        @Data(size=1, value="P")
        IString iAtrzBbnVcob() ;
        
        @Data(size=1, value="R")
        IString iAtrzBbnMmin() ;
        
        @Data(size=1, value="Q")
        IString iAtrzQDiaPavs() ;
        
    }
    
    /**
     * 
     * DADOS DE JUROS
     * 
     * @version 2.0
     * 
     */
    public interface BaseIcdcCalcJur extends IDataStruct {
        
        @Data(size=2, value="SV")
        IString calJurosSv() ;
        
        @Data(size=2, value="SM")
        IString calJurosSm() ;
        
        @Data(size=2, value="SD")
        IString calJurosSvd() ;
        
        @Data(size=2, value="JM")
        IString calJurosAoMov() ;
        
        @Data(size=2, value="SC")
        IString calJurosSmc() ;
        
    }
    public interface PlanosRemuneracao extends IDataStruct {
        
        @Data(size=1, value="M")
        IString escalPlnRemMont() ;
        
        /**
         * @return instancia da classe local PrTipos
         */
        @Data
        PrTipos prTipos() ;
        
        /**
         * @return instancia da classe local PrTiposX1
         */
        @Data
        PrTiposX1 prTiposX1() ;
        
        
        public interface PrTipos extends IDataStruct {
            
            @Data(size=2, value="CR")
            IString prCredor() ;
            
            @Data(size=2, value="DV")
            IString prDevedor() ;
            
            @Data(size=2, value="MA")
            IString prMobAnt() ;
            
            @Data(size=2, value="MO")
            IString prMobAntDo() ;
            
            @Data(size=2, value="LA")
            IString prLiquidacao() ;
            
            @Data(size=2, value="LR")
            IString prEspecLiqAnt() ;
            
        }
        
        public interface PrTiposX1 extends IDataStruct {
            
            @Data(size=1, value="C")
            IString x1Credor() ;
            
            @Data(size=1, value="D")
            IString x1Devedor() ;
            
            @Data(size=1, value="M")
            IString x1MobAnt() ;
            
            @Data(size=1, value="O")
            IString x1MobAntDo() ;
            
            @Data(size=1, value="L")
            IString x1Liquidacao() ;
            
        }
    }
    public interface ITipoValQEclo extends IDataStruct {
        
        @Data(size=1, value="R")
        IString qtdeRenovacoes() ;
        
        @Data(size=1, value="S")
        IString semEscaloes() ;
        
    }
    public interface IEstJuro extends IDataStruct {
        
        @Data(size=1, value="P")
        IString juroPendente() ;
        
        @Data(size=1, value="V")
        IString juroVencido() ;
        
        @Data(size=1, value="I")
        IString juroIncobravel() ;
        
    }
    public interface IDataPrzTax extends IDataStruct {
        
        @Data(size=1, value="A")
        IString iDataPrzTaxAbert() ;
        
        @Data(size=1, value="R")
        IString iDataPrzTaxRenov() ;
        
        @Data(size=1, value="L")
        IString iDataPrzTaxLiq() ;
        
    }
    public interface ITipoPagJcrx extends IDataStruct {
        
        @Data(size=1, value="P")
        IString iTipoPagPost() ;
        
        @Data(size=1, value="A")
        IString iTipoPagAnt() ;
        
    }
    public interface IFrmPagJcrx extends IDataStruct {
        
        @Data(size=1, value="E")
        IString iFrmPagEspecie() ;
        
        @Data(size=1, value="C")
        IString iFrmPagCapital() ;
        
    }
    public interface TipoRegulJuros extends IDataStruct {
        
        @Data(size=1, value="T")
        IString regulTotalJuros() ;
        
        @Data(size=1, value="A")
        IString aumentarJuros() ;
        
        @Data(size=1, value="D")
        IString diminuirJuros() ;
        
    }
    public interface TipoRgzzEncg extends IDataStruct {
        
        @Data(size=1, value="T")
        IString regulTotalEncg() ;
        
        @Data(size=1, value="A")
        IString aumentarEncg() ;
        
        @Data(size=1, value="D")
        IString diminuirEncg() ;
        
    }
    public interface IOrigMovRegJuros extends IDataStruct {
        
        @Data(size=1, value="L")
        IString jurosLancados() ;
        
        @Data(size=1, value="J")
        IString jurosAguardamLanc() ;
        
        @Data(size=1, value="P")
        IString jurosPendentes() ;
        
    }
    public interface ITipoMov extends IDataStruct {
        
        @Data(size=2, value="MD")
        IString movDebito() ;
        
        @Data(size=2, value="RC")
        IString movRecalJcrx() ;
        
        @Data(size=2, value="DC")
        IString movDesfazCrd() ;
        
        @Data(size=2, value="EB")
        IString estornoDesfazCrd() ;
        
        @Data(size=2, value="ER")
        IString estornoRecalJcrx() ;
        
        @Data(size=2, value="MC")
        IString credit() ;
        
        @Data(size=2, value="LA")
        IString liquidacao() ;
        
        @Data(size=2, value="LJ")
        IString liqJuros() ;
        
        @Data(size=2, value="EC")
        IString estornoCredito() ;
        
        @Data(size=2, value="ED")
        IString estornoDebito() ;
        
        @Data(size=2, value="EL")
        IString estornoLiquidacao() ;
        
        @Data(size=2, value="NG")
        IString negociacao() ;
        
        @Data(size=2, value="RN")
        IString recalculoValor() ;
        
    }
    public interface TipoRegularizacao extends IDataStruct {
        
        @Data(size=1, value="J")
        IString regJurosAguardam() ;
        
        @Data(size=1, value="I")
        IString regJurosImpostos() ;
        
        @Data(size=1, value="P")
        IString regJurosPendentes() ;
        
    }
    public interface EstGatCalcJuros extends IDataStruct {
        
        @Data(size=1, value="P")
        IString gatCalcJuroProc() ;
        
        @Data(size=1, value="N")
        IString gatCalcJuroNProc() ;
        
    }
    public interface ParamPassIncobravel extends IDataStruct {
        
        @Data(size=1, value="4")
        IInt incobEuroTipoPrazo() ;
        
        @Data(size=2, value="12")
        IInt incobEuroDuPrazo() ;
        
        @Data(size=2, value="25")
        IInt incobEurMTotal() ;
        
        @Data(size=1, value="5")
        IInt incobEurMPrest() ;
        
    }
    
    /**
     * 
     * *DORIS*INICIO*DOMINIO
     * 
     * @version 2.0
     * 
     */
    public interface CSectIttlBpor extends IDataStruct {
        
        @Data(size=7, signed=true, value="1000000", compression=COMP3)
        IInt sectIttlTribunal() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt sectIttlEstado() ;
        @Data
        @Condition({ "1211010", "1211099" })
        ICondition sectIttlObrJurEst() ;
        
        
    }
    
    /**
     * 
     * *DORIS*FIM*
     * DEPOSITOS OBRIGATORIOS
     * 
     * @version 2.0
     * 
     */
    public interface CEstObjDpob extends IDataStruct {
        
        @Data(size=1, value="A")
        IString objectoActivo() ;
        
        @Data(size=1, value="I")
        IString objectoInactivo() ;
        
        @Data(size=1, value="E")
        IString objPrecEmit() ;
        
    }
    public interface CTipoOcraDpob extends IDataStruct {
        
        @Data(size=3, value="002")
        IString ocorrDepCondic() ;
        
    }
    public interface IAltMordScta extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iAltMordSctaSim() ;
        
        @Data(size=1, value="N")
        IString iAltMordSctaNao() ;
        
    }
    public interface CEstOcraDpob extends IDataStruct {
        
        @Data(size=1, value="A")
        IString cEstOcraActiva() ;
        
        @Data(size=1, value="I")
        IString cEstOcraInactiva() ;
        
    }
    public interface CEstPrec extends IDataStruct {
        
        @Data(size=1, value="A")
        IString cEstPrecAct() ;
        
        @Data(size=1, value="C")
        IString cEstPrecCat() ;
        
        @Data(size=1, value="N")
        IString cEstPrecAnu() ;
        
        @Data(size=1, value="P")
        IString cEstPrecPag() ;
        
    }
    public interface ITipoPrec extends IDataStruct {
        
        @Data(size=1, value="0")
        IInt capitalEJuros() ;
        
        @Data(size=1, value="1")
        IInt capital() ;
        
        @Data(size=1, value="2")
        IInt jurosDevidos() ;
        
        @Data(size=1, value="3")
        IInt jurosAnuais() ;
        
        @Data(size=1, value="4")
        IInt objecto() ;
        
    }
    public interface IPrecCndl extends IDataStruct {
        
        @Data(size=1, value="S")
        IString precCndlSim() ;
        
        @Data(size=1, value="N")
        IString precCndlNao() ;
        
    }
    public interface CModoPag extends IDataStruct {
        
        @Data(size=1, value="N")
        IString pagNumerario() ;
        
        @Data(size=1, value="C")
        IString pagDebitoEmCta() ;
        
    }
    
    /**
     * 
     * ACESSOS TABELAS GERAIS
     * 
     * @version 2.0
     * 
     */
    public interface CodTabGerais extends IDataStruct {
        
        @Data(size=3, value="158")
        IString tgProdutos() ;
        
        @Data(size=3, value="196")
        IString tgAltSitScta() ;
        
        @Data(size=3, value="257")
        IString tgTaxas() ;
        
        @Data(size=3, value="257")
        IString tgDescrTaxa() ;
        
        @Data(size=3, value="260")
        IString tgPeriodicidades() ;
        
        @Data(size=3, value="260")
        IString tgDescrPrde() ;
        
        @Data(size=3, value="277")
        IString tgPrazos() ;
        
        @Data(size=3, value="378")
        IString tgTipoJuro() ;
        
        @Data(size=3, value="610")
        IString tgPremios() ;
        
        @Data(size=3, value="616")
        IString tgTipoPrecatorio() ;
        
        @Data(size=3, value="626")
        IString tgParamGerais() ;
        
        @Data(size=3, value="627")
        IString tgExcepCodOper() ;
        
        @Data(size=3, value="630")
        IString tgSitIcpt() ;
        
        @Data(size=3, value="631")
        IString tgEstadosMovsNostr() ;
        
        @Data(size=3, value="695")
        IString tgAltSitIcpt() ;
        
        @Data(size=3, value="756")
        IString tgEncargos() ;
        
        @Data(size=3, value="758")
        IString tgTipoRetSaldo() ;
        
        @Data(size=3, value="764")
        IString tgDescrCaderneta() ;
        
        @Data(size=3, value="764")
        IString tgDescrExtracto() ;
        
        @Data(size=3, value="765")
        IString tgFamilias() ;
        
        @Data(size=3, value="800")
        IString tgPaisMnemMoed() ;
        
        @Data(size=3, value="860")
        IString tgRepartFinanc() ;
        
        @Data(size=3, value="879")
        IString tgSectIttlBpor() ;
        
        @Data(size=3, value="903")
        IString tgCanlAcesso() ;
        
        @Data(size=3, value="910")
        IString tgPaises() ;
        
        @Data(size=3, value="920")
        IString tgCodPostais() ;
        
        @Data(size=3, value="E03")
        IString tgEventoSubevento() ;
        
        @Data(size=3, value="A07")
        IString tgDescricaoErros() ;
        
        @Data(size=3, value="G11")
        IString tgEstadoDespManut() ;
        
        @Data(size=3, value="G18")
        IString tgTesourariasEstado() ;
        
        @Data(size=3, value="G35")
        IString tgTipoValEclo() ;
        
        @Data(size=3, value="G36")
        IString tgTipoCndzEspl() ;
        
        @Data(size=3, value="G39")
        IString tgRelInterven() ;
        
        @Data(size=3, value="J07")
        IString tgAvisoOp() ;
        
    }
    public interface AcessoBhgp0030 extends IDataStruct {
        
        @Data(size=1, value="V")
        IString iAccaoTabBbnV() ;
        
        @Data(size=1, value="C")
        IString iDadosObtrC() ;
        
    }
    
    /**
     * 
     * CONSTANTES ACESSO A TAB. GERAL DE PARAMETROS (626)
     * 
     * @version 2.0
     * 
     */
    public interface CTgParam extends IDataStruct {
        
        /**
         * NUMERO DE MOVIMENTOS MINIMO PARA EXTRACTOS
         */
        @Data(size=3, value="MME")
        IString cTgParamMvMinExt() ;
        
        /**
         * NUMERO DE MOVIMENTOS MINIMO PARA AGLUTINACAO DE MOVIMENTOS
         */
        @Data(size=3, value="MMC")
        IString cTgParamMvAglCad() ;
        
        /**
         * PARAMETROS PARA DESPESAS DE MANUTENCAO
         */
        @Data(size=3, value="DMN")
        IString cTgParamDspzMntz() ;
        
        /**
         * PASSAGEM A HISTORICO DOS MOVIMENTOS DE POUPANCA
         */
        @Data(size=3, value="HMP")
        IString cTgParamHistMpoup() ;
        
        /**
         * PASSAGEM A HISTORICO DA NEGOCIACAO DE TAXAS DE JURO
         */
        @Data(size=3, value="HNT")
        IString cTgParamHisNegTx() ;
        
        /**
         * PASSAGEM A HISTORICO DA NEGOCIACAO DE ENCARGOS
         */
        @Data(size=3, value="HNE")
        IString cTgParamHisNegEc() ;
        
        /**
         * PASSAGEM A HISTORICO DA NEGOCIACAO DE ENCARGOS
         */
        @Data(size=3, value="EXP")
        IString cTgParamExpurCta() ;
        
        @Data(size=3, value="EDO")
        IString cTgParamExpDobrig() ;
        
        /**
         * VENCIMENTO DEP ESTRUTURADO
         */
        @Data(size=3, value="VDE")
        IString cTgParamVencDEst() ;
        
        @Data(size=3, value="HPE")
        IString cTgHistPgmEncg() ;
        
        @Data(size=3, value="HEP")
        IString cTgHistEcgPend() ;
        
        @Data(size=3, value="CRM")
        IString cTgParamCrm() ;
        
        /**
         * EXPURGO/HISTORICO DE EXTRACTOS
         */
        @Data(size=3, value="EXT")
        IString cTgParamExpExt() ;
        
        @Data(size=3, value="VSD")
        IString cTgParamVectSldo() ;
        
        /**
         * OBTEM MONTANTE MINIMO PARA FLUXOS
         */
        @Data(size=3, value="FLX")
        IString obtemMMinFluxos() ;
        
        /**
         * OBTEM MONTANTE MINIMO PARA SALDOS
         */
        @Data(size=3, value="SLD")
        IString obtemMMinSaldos() ;
        
        /**
         * OBTEM MONTANTE MINIMO PARA SALDOS
         */
        @Data(size=3, value="HCD")
        IString cTgHistCtrAutDep() ;
        
        /**
         * EXPURGO/HISTORICO DE CATIVOS
         */
        @Data(size=3, value="EXC")
        IString cTgParamExpCativo() ;
        
    }
    
    /**
     * 
     * DESCOBERTOS / CMRG / CATIVOS / PENDENTES
     * 
     * @version 2.0
     * 
     */
    public interface Descobertos extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iAltLimDngdSim() ;
        
        @Data(size=1, value="N")
        IString iAltLimDngdNao() ;
        
        @Data(size=1, value="N")
        IString iAltPrzDngdNao() ;
        
        @Data(size=1, value="S")
        IString iAltPrzDngdSim() ;
        
    }
    public interface ISldoCmrgIsdp extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iSldoCmrgIsdpN() ;
        
        @Data(size=1, value="S")
        IString iSldoCmrgIsdpS() ;
        
    }
    public interface IDcboNgcdIsdp extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iDcboNgcdIsdpNao() ;
        
        @Data(size=1, value="S")
        IString iDcboNgcdIsdpSim() ;
        
    }
    public interface IRnvzDcboNgcd extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iRnvzDcboNgcdS() ;
        
        @Data(size=1, value="N")
        IString iRnvzDcboNgcdN() ;
        
    }
    public interface CEstDngcCmrg extends IDataStruct {
        
        @Data(size=1, value="A")
        IString cEstActivo() ;
        
        @Data(size=1, value="E")
        IString cEstEncerrado() ;
        
        @Data(size=1, value="I")
        IString cEstInactivo() ;
        
    }
    public interface IEstRetzSldo extends IDataStruct {
        
        @Data(size=1, value="A")
        IString cativoActivo() ;
        
        @Data(size=1, value="E")
        IString cativoExpirado() ;
        
        @Data(size=1, value="C")
        IString cativoCancelado() ;
        
    }
    public interface IEstVcob extends IDataStruct {
        
        @Data(size=1, value="A")
        IString vcobPendActivo() ;
        
        @Data(size=1, value="E")
        IString vcobPendExpirado() ;
        
        @Data(size=1, value="C")
        IString vcobPendCancelado() ;
        
    }
    public interface IOrigLoteVcob extends IDataStruct {
        
        @Data(size=1, value="A")
        IString iOrigAts() ;
        
        @Data(size=1, value="B")
        IString iOrigAgencia() ;
        
        @Data(size=1, value="C")
        IString iOrigAgenciaCtd() ;
        
        @Data(size=1, value="S")
        IString iOrigSibs() ;
        
    }
    public interface IEstadoLote extends IDataStruct {
        
        @Data(size=1, value="P")
        IString porTratar() ;
        
        @Data(size=1, value="S")
        IString tratadoSErros() ;
        
        @Data(size=1, value="E")
        IString tratadoCErroSMapa() ;
        
        @Data(size=1, value="M")
        IString tratadoCErroCMapa() ;
        
    }
    public interface ITipoEtga extends IDataStruct {
        
        @Data(size=1, value="L")
        IString entregaDeLote() ;
        
        @Data(size=1, value="D")
        IString etgaValDesdobrados() ;
        
    }
    public interface IRnvzVnct extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iRnvzVnctNao() ;
        
        @Data(size=1, value="S")
        IString iRnvzVnctSim() ;
        
        @Data(size=1, value="V")
        IString vencido() ;
        
        @Data(size=1, value="R")
        IString renovado() ;
        
    }
    public interface ITipoCapzJuro extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iTipoCapzJuroNao() ;
        
        @Data(size=1, value="S")
        IString iTipoCapzJuroSim() ;
        
    }
    public interface IExisNgczEclo extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iExisNgczEcloN() ;
        
        @Data(size=1, value="S")
        IString iExisNgczEcloS() ;
        
        @Data(size=1, value="P")
        IString iEstNegPorAprovar() ;
        
        @Data(size=1, value="E")
        IString iEstNegErro() ;
        
    }
    public interface IExisRstzCont extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iExisRstzContN() ;
        
        @Data(size=1, value="S")
        IString iExisRstzContS() ;
        
    }
    public interface IInbzCheq extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iInbzCheqN() ;
        
        @Data(size=1, value="S")
        IString iInbzCheqS() ;
        
    }
    public interface IndInsFundos extends IDataStruct {
        
        @Data(size=1, value="S")
        IString comInsFundos() ;
        
        @Data(size=1, value="N")
        IString semInsFundos() ;
        
    }
    public interface IExisContSpte extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iExisContSpteS() ;
        
        @Data(size=1, value="N")
        IString iExisContSpteN() ;
        
    }
    public interface IEmpsNomeIdvl extends IDataStruct {
        
        @Data(size=1, value="N")
        IString iEmpsNomeIdvlN() ;
        
        @Data(size=1, value="S")
        IString iEmpsNomeIdvlS() ;
        
    }
    public interface IClszTtr1Cont extends IDataStruct {
        
        @Data(size=1, value="E")
        IString iClszTtr1ContEmp() ;
        
        @Data(size=1, value="P")
        IString iClszTtr1ContPart() ;
        
        @Data(size=1, value="M")
        IString iClszTtr1ContMen() ;
        
    }
    public interface ITipoSpte extends IDataStruct {
        
        @Data(size=1, value="E")
        IString iTipoSpteExt() ;
        
        @Data(size=1, value="C")
        IString iTipoSpteCad() ;
        
        @Data(size=1, value="T")
        IString iTipoSpteTit() ;
        
        @Data(size=1, value="O")
        IString iTipoSpteOut() ;
        
    }
    public interface IRnvzCndzRmnz extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iRnvzSim() ;
        
        @Data(size=1, value="N")
        IString iRnvzNao() ;
        
    }
    
    /**
     * 
     * TABELAS DE CONTAS
     * 
     * @version 2.0
     * 
     */
    public interface NomeTabelas extends IDataStruct {
        
        @Data(size=18, value="VHO00101_CONTAS   ")
        IString vho00101() ;
        
        @Data(size=18, value="VHO00201_SUBCONTAS")
        IString vho00201() ;
        
        @Data(size=18, value="VHO00301_SCTAJUROS")
        IString vho00301() ;
        
        @Data(size=18, value="VHO00401_SCTACOMPL")
        IString vho00401() ;
        
        @Data(size=18, value="VHO00501_SCTACHEQ ")
        IString vho00501() ;
        
        @Data(size=18, value="VHO00601_PEDEXT   ")
        IString vho00601() ;
        
        @Data(size=18, value="VHO00701_REMNEGBAS")
        IString vho00701() ;
        
        @Data(size=18, value="VHO00801_HISTLIQ  ")
        IString vho00801() ;
        
        @Data(size=18, value="VHO00901_MEMOEXT  ")
        IString vho00901() ;
        
        @Data(size=18, value="VHO01001_GRUPCASH ")
        IString vho01001() ;
        
        @Data(size=18, value="VHO01101_AVISOS   ")
        IString vho01101() ;
        
        @Data(size=18, value="VHO01201_CATIVOS  ")
        IString vho01201() ;
        
        @Data(size=18, value="VHO01301_INDISP   ")
        IString vho01301() ;
        
        @Data(size=18, value="VHO01401_LOTES    ")
        IString vho01401() ;
        
        @Data(size=18, value="VHO01501_SCTAREL  ")
        IString vho01501() ;
        
        @Data(size=18, value="VHO01601_EXTEMIT  ")
        IString vho01601() ;
        
        @Data(size=18, value="VHO01701_EXTRACTO ")
        IString vho01701() ;
        
        @Data(size=18, value="VHO01801_PIN      ")
        IString vho01801() ;
        
        @Data(size=18, value="VHO01901_HISTPIN  ")
        IString vho01901() ;
        
        @Data(size=18, value="VHO02001_MOVDIA1  ")
        IString vho02001() ;
        
        @Data(size=18, value="VHO02101_MOVDIA2  ")
        IString vho02101() ;
        
        @Data(size=18, value="VHO02201_MOVDIAANT")
        IString vho02201() ;
        
        @Data(size=18, value="VHO02301_HISTMOV1 ")
        IString vho02301() ;
        
        @Data(size=18, value="VHO02401_HISTMOV2 ")
        IString vho02401() ;
        
        @Data(size=18, value="VHO02501_PARAVIGST")
        IString vho02501() ;
        
        @Data(size=18, value="VHO02601_CTAMARGEM")
        IString vho02601() ;
        
        @Data(size=18, value="VHO02701_CTRLDES  ")
        IString vho02701() ;
        
        @Data(size=18, value="VHO02801_PEDALTSCT")
        IString vho02801() ;
        
        @Data(size=18, value="VHO02901_ABALGST  ")
        IString vho02901() ;
        
        @Data(size=18, value="VHO03001_AVISGEST ")
        IString vho03001() ;
        
        @Data(size=18, value="VHO03101_TRNCONT  ")
        IString vho03101() ;
        
        @Data(size=18, value="VHO03201 N EXISTE ")
        IString vho03201() ;
        
        @Data(size=18, value="VHO03301_ENTANO   ")
        IString vho03301() ;
        
        @Data(size=18, value="VHO03401_DESPMAN  ")
        IString vho03401() ;
        
        @Data(size=18, value="VHO03501_FICHASSI ")
        IString vho03501() ;
        
        @Data(size=18, value="VHO03601_IMPOSTOS ")
        IString vho03601() ;
        
        @Data(size=18, value="VHO03701_SEGVIAEXT")
        IString vho03701() ;
        
        @Data(size=18, value="VHO03801_PLANOS   ")
        IString vho03801() ;
        
        @Data(size=18, value="VHO03901_HISTPLAN ")
        IString vho03901() ;
        
        @Data(size=18, value="VHO04001_SALDOS   ")
        IString vho04001() ;
        
        @Data(size=18, value="VHO04101_VECTJUROS")
        IString vho04101() ;
        
        @Data(size=18, value="VHO04201_JUSJURVAL")
        IString vho04201() ;
        
        @Data(size=18, value="VHO04301_JURALIQO ")
        IString vho04301() ;
        
        @Data(size=18, value="VHO04401_JUSJURMOV")
        IString vho04401() ;
        
        @Data(size=18, value="VHO04501_JURRELIQO")
        IString vho04501() ;
        
        @Data(size=18, value="VHO04601_JURALIQB ")
        IString vho04601() ;
        
        @Data(size=18, value="VHO04701_JURRELIQB")
        IString vho04701() ;
        
        @Data(size=18, value="VHO04801_JUROSBENS")
        IString vho04801() ;
        
        @Data(size=18, value="VHO04901_JUROSPEND")
        IString vho04901() ;
        
        @Data(size=18, value="VHO05001_DETPAGJUR")
        IString vho05001() ;
        
        @Data(size=18, value="VHO05101_IMPSMDEV ")
        IString vho05101() ;
        
        @Data(size=18, value="VHO05201_SALMED   ")
        IString vho05201() ;
        
        @Data(size=18, value="VHO05301_LOGALT   ")
        IString vho05301() ;
        
        @Data(size=18, value="VHO05401_MOVREG   ")
        IString vho05401() ;
        
        @Data(size=18, value="VHO05501_LOGCATD  ")
        IString vho05501() ;
        
        @Data(size=18, value="VHO05601_JURCOBPAG")
        IString vho05601() ;
        
        @Data(size=18, value="VHO05701_DIARJURAN")
        IString vho05701() ;
        
        @Data(size=18, value="VHO05801_DIARINCJU")
        IString vho05801() ;
        
        @Data(size=18, value="VHO05901_DIARJUROS")
        IString vho05901() ;
        
        @Data(size=18, value="VHO06001_PEDFOTO  ")
        IString vho06001() ;
        
        @Data(size=18, value="VHO06101_DUCMOV   ")
        IString vho06101() ;
        
        @Data(size=18, value="VHO06201_DUCLINDET")
        IString vho06201() ;
        
        @Data(size=18, value="VHO06301_LOTEDUC  ")
        IString vho06301() ;
        
        @Data(size=18, value="VHO06401_DUCHIST  ")
        IString vho06401() ;
        
        @Data(size=18, value="VHO06501_DUCDET   ")
        IString vho06501() ;
        
        @Data(size=18, value="VHO06601_MOVJUST  ")
        IString vho06601() ;
        
        @Data(size=18, value="VHO06701_MOVPOUP  ")
        IString vho06701() ;
        
        @Data(size=18, value="VHO06801_ALTPROD  ")
        IString vho06801() ;
        
        @Data(size=18, value="VHO06901_ALTCTMRG ")
        IString vho06901() ;
        
        @Data(size=18, value="VHO07001_SERVICOS ")
        IString vho07001() ;
        
        @Data(size=18, value="VHO07101 N EXISTE ")
        IString vho07101() ;
        
        @Data(size=18, value="VHO07201_PREMIOS  ")
        IString vho07201() ;
        
        @Data(size=18, value="VHO07301_HISTAVISO")
        IString vho07301() ;
        
        @Data(size=18, value="VHO07401_DPOBESP  ")
        IString vho07401() ;
        
        @Data(size=18, value="VHO07501_DPOBPREC ")
        IString vho07501() ;
        
        @Data(size=18, value="VHO07601_DPOBOBJ  ")
        IString vho07601() ;
        
        @Data(size=18, value="VHO07701_DPOBOCRA ")
        IString vho07701() ;
        
        @Data(size=18, value="VHO07801_REMNEGESC")
        IString vho07801() ;
        
        @Data(size=18, value="VHO07901_GESTCONT ")
        IString vho07901() ;
        
        @Data(size=18, value="VHO08001_ENCCONT  ")
        IString vho08001() ;
        
        @Data(size=18, value="VHO08101_MFIXENC  ")
        IString vho08101() ;
        
        @Data(size=18, value="VHO08201_CADERNETA")
        IString vho08201() ;
        
        @Data(size=18, value="VHO08301_MOVAGLU  ")
        IString vho08301() ;
        
        @Data(size=18, value="VHO08401_MOVFUTUR ")
        IString vho08401() ;
        
        @Data(size=18, value="VHO08501_EXTCMBEMI")
        IString vho08501() ;
        
        @Data(size=18, value="VHO08601_SEGVIAEXC")
        IString vho08601() ;
        
        @Data(size=18, value="VHO08701_HISLIQLDN")
        IString vho08701() ;
        
        @Data(size=18, value="VHO08801_JUSJURMED")
        IString vho08801() ;
        
        @Data(size=18, value="VHO08901_ALTCANAL ")
        IString vho08901() ;
        
        @Data(size=18, value="VHO09001_DEPESTRUT")
        IString vho09001() ;
        
        @Data(size=18, value="VHO09101_GATCALJUR")
        IString vho09101() ;
        
        @Data(size=18, value="VHO09201_ACJUROSV ")
        IString vho09201() ;
        
        @Data(size=18, value="VHO09301_SPRBUND  ")
        IString vho09301() ;
        
        @Data(size=18, value="VHO09401_PEDMAPAS ")
        IString vho09401() ;
        
        @Data(size=18, value="VHO09501_SLDFIMDIA")
        IString vho09501() ;
        
        @Data(size=18, value="VHO09601_HISDSPMAN")
        IString vho09601() ;
        
        @Data(size=18, value="VHO09701_ERROMOVB ")
        IString vho09701() ;
        
        @Data(size=18, value="VHO09801_GTMOV    ")
        IString vho09801() ;
        
        @Data(size=18, value="VHO09901_GTPREPAG ")
        IString vho09901() ;
        
        @Data(size=18, value="VHO10001_TRIBUNAL ")
        IString vho10001() ;
        
        @Data(size=18, value="VHO10101 N EXISTE ")
        IString vho10101() ;
        
        @Data(size=18, value="VHO10201_GTPRPAGES")
        IString vho10201() ;
        
        @Data(size=18, value="VHO10301_TSU      ")
        IString vho10301() ;
        
        @Data(size=18, value="VHO10401_TSUHIST  ")
        IString vho10401() ;
        
        @Data(size=18, value="VHO10501_PAGISSMD ")
        IString vho10501() ;
        
        @Data(size=18, value="VHO10601_MOVCALJUR")
        IString vho10601() ;
        
        @Data(size=18, value="VHO10701_SCTAVENC ")
        IString vho10701() ;
        
        @Data(size=18, value="VHO10801_CONTSPTE ")
        IString vho10801() ;
        
        @Data(size=18, value="VHO10901_HISIRTIT ")
        IString vho10901() ;
        
        @Data(size=18, value="VHO11001_IRTIT    ")
        IString vho11001() ;
        
        @Data(size=18, value="VHO11101_ENCGPEND ")
        IString vho11101() ;
        
        @Data(size=18, value="VHO11201_DETPGENCG")
        IString vho11201() ;
        
        @Data(size=18, value="VHO11301_IRPAGTIT ")
        IString vho11301() ;
        
        @Data(size=18, value="VHO11401_GATCTA   ")
        IString vho11401() ;
        
        @Data(size=18, value="VHO11501_HISTISMD ")
        IString vho11501() ;
        
        @Data(size=18, value="VHO11601_CNVBNUCGD")
        IString vho11601() ;
        
        @Data(size=18, value="VHO11701_CNVUNIBNU")
        IString vho11701() ;
        
        @Data(size=18, value="VHO11801_CERTSLDJU")
        IString vho11801() ;
        
        @Data(size=18, value="VHO11901_DCVOESPL ")
        IString vho11901() ;
        
        @Data(size=18, value="VHO12001_HJUSJUVAL")
        IString vho12001() ;
        
        @Data(size=18, value="VHO12101_HJUSJUMOV")
        IString vho12101() ;
        
        @Data(size=18, value="VHO12201_HDETPAGJU")
        IString vho12201() ;
        
        @Data(size=18, value="VHO12301_HJUSJUMED")
        IString vho12301() ;
        
        @Data(size=18, value="VHO12401_MSGEXRTSW")
        IString vho12401() ;
        
        @Data(size=18, value="VHO12501_DADEXRTSW")
        IString vho12501() ;
        
        @Data(size=18, value="VHO12601_EXRTSWEMI")
        IString vho12601() ;
        
        @Data(size=18, value="VHO12701_BLOQUEIOS")
        IString vho12701() ;
        
        @Data(size=18, value="VHO12801_GATVESP  ")
        IString vho12801() ;
        
        @Data(size=18, value="VHO12901_TXCADERN ")
        IString vho12901() ;
        
        @Data(size=18, value="VHO13001_ALTCALJUR")
        IString vho13001() ;
        
        @Data(size=18, value="VHO13101_SLDOCCTE ")
        IString vho13101() ;
        
        @Data(size=18, value="VHO13201_LOGMOVCPH")
        IString vho13201() ;
        
        @Data(size=18, value="VHO13301_ENDCSWIF ")
        IString vho13301() ;
        
        @Data(size=18, value="VHO13401_PAGENCG  ")
        IString vho13401() ;
        
        @Data(size=18, value="VHO13501_DETENCGPD")
        IString vho13501() ;
        
        @Data(size=18, value="VHO13601_RGZENCGPD")
        IString vho13601() ;
        
        @Data(size=18, value="VHO13701_DETRGENCG")
        IString vho13701() ;
        
        @Data(size=18, value="VHO13801_SCTAICPT ")
        IString vho13801() ;
        
        @Data(size=18, value="VHO13901_MSGSWPED ")
        IString vho13901() ;
        
        @Data(size=18, value="VHO14001_MOVNOSTRO")
        IString vho14001() ;
        
        @Data(size=18, value="VHO14101_AVISOOPE ")
        IString vho14101() ;
        
        @Data(size=18, value="VHO14201_MOVJUREST")
        IString vho14201() ;
        
        @Data(size=18, value="VHO14301_EXTCORONA")
        IString vho14301() ;
        
        @Data(size=18, value="VHO14401_CNTLDEP  ")
        IString vho14401() ;
        
        @Data(size=18, value="VHO14501_GTLOVPRA2")
        IString vho14501() ;
        
        @Data(size=18, value="VHO14601_GTLVPRLI1")
        IString vho14601() ;
        
        @Data(size=18, value="VHO14701_GTLVPRLI2")
        IString vho14701() ;
        
        @Data(size=18, value="VHO14801_GTLVPRSP1")
        IString vho14801() ;
        
        @Data(size=18, value="VHO14901_GTLVPRSP2")
        IString vho14901() ;
        
        @Data(size=18, value="VHO15001_GTLVPRAG1")
        IString vho15001() ;
        
        @Data(size=18, value="VHO15101_GTLVPRAG2")
        IString vho15101() ;
        
        @Data(size=18, value="VHO15201_GTLVPRD11")
        IString vho15201() ;
        
        @Data(size=18, value="VHO15301_GTLVPRD12")
        IString vho15301() ;
        
        @Data(size=18, value="VHO15401_LIMSLDDPL")
        IString vho15401() ;
        
        @Data(size=18, value="VHO15501_CNLEVESCT")
        IString vho15501() ;
        
        @Data(size=18, value="VHO15601_MOVFINE  ")
        IString vho15601() ;
        
        @Data(size=18, value="VHO15701_DCBOMAX  ")
        IString vho15701() ;
        
        @Data(size=18, value="VHO15801_LRETBBN  ")
        IString vho15801() ;
        
        @Data(size=18, value="VHO15901_MOVDEP   ")
        IString vho15901() ;
        
        @Data(size=18, value="VHO16001_PNDECADN ")
        IString vho16001() ;
        
        @Data(size=18, value="VHO16101_CVDPOBFAL")
        IString vho16101() ;
        
        @Data(size=18, value="VHO16201_DSPMANMEN")
        IString vho16201() ;
        
        @Data(size=18, value="VHO16301_VNCTPNDE ")
        IString vho16301() ;
        
        @Data(size=18, value="VHO16401_MOVZECI  ")
        IString vho16401() ;
        
        @Data(size=18, value="VHO16501_LOGBLQO  ")
        IString vho16501() ;
        
        @Data(size=18, value="VHO22101_INTCBL1  ")
        IString vho22101() ;
        
        @Data(size=18, value="VHO22201_INTCBL2  ")
        IString vho22201() ;
        
    }
    
    /**
     * 
     * AVISOS DE GESTOR
     * 
     * @version 2.0
     * 
     */
    public interface AvsoGerx extends IDataStruct {
        
        @Data(size=3, value="001")
        IString cAvsoGerxData() ;
        
        @Data(size=3, value="002")
        IString cAvsoGerxSldo() ;
        
        @Data(size=3, value="003")
        IString cAvsoGerxMove() ;
        
    }
    
    /**
     * 
     * MAPAS
     * 
     * @version 2.0
     * 
     */
    public interface CEstPedidoMapas extends IDataStruct {
        
        @Data(size=1, value="P")
        IString pedMapProcessado() ;
        
        @Data(size=1, value="N")
        IString pedMapNProcessado() ;
        
    }
    
    /**
     * 
     * DESPESAS DE MANUTENCAO
     * 
     * @version 2.0
     * 
     */
    public interface IEstCbrcDspa extends IDataStruct {
        
        @Data(size=1, value="N")
        IString despManNaoProc() ;
        
        @Data(size=1, value="P")
        IString despManProcessadas() ;
        
        @Data(size=1, value="E")
        IString despManPerdoadas() ;
        
        @Data(size=1, value="D")
        IString despManDebitadas() ;
        
        @Data(size=1, value="C")
        IString despManParcCobr() ;
        
        @Data(size=1, value="R")
        IString despManRejeitadas() ;
        
    }
    public interface ICbrcDspaMntzTho4 extends IDataStruct {
        
        /**
         * *A CONTA E ABERTA COM 'N'. A 1A VEZ QUE E PASSIVEL DE COBRANCA
         * *ENVIA CARTA, NAO COBRA E PASSA A 'C'. A 2A VEZ QUE E PASSIVEL
         * *DE COBRANCA, TEM 'C', PASSA A 'S' E COBRA. AS PROXIMAS VEZES TEM
         * *'S' E COBRA.
         */
        @Data(size=1, value="N")
        IString dspManNuncaCalc() ;
        
        @Data(size=1, value="C")
        IString dspManCartaJaFoi() ;
        
        @Data(size=1, value="S")
        IString dspManCobrar() ;
        
    }
    public interface DespesasManutencao extends IDataStruct {
        
        @Data(size=7, signed=true)
        IInt cTipoIttzPartcular() ;
        @Data
        @Condition({ "1321200", "1330000", "2321200", "2330000" })
        ICondition cTipoIttzIncPart() ;
        
        
        @Data(size=4, signed=true)
        IInt cTipoIttzEmpresa() ;
        @Data
        @Condition({ "1312", "2312", "1321", "2321" })
        ICondition cTipoIttzIncEmp() ;
        
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt errosPrmzMhaj200a() ;
        @Data
        @Condition({ "610", "611", "607", "595", "029" })
        ICondition erroParametrizacao() ;
        
        
    }
    
    /**
     * 
     * CADERNETAS
     * 
     * @version 2.0
     * 
     */
    public interface COpeBbnAglut extends IDataStruct {
        
        @Data(size=5, value="DBITO")
        IString cOpeBbnAglutDb() ;
        
        @Data(size=5, value="CRDTO")
        IString cOpeBbnAglutCr() ;
        
    }
    public interface IEstViaSpte extends IDataStruct {
        
        @Data(size=1, value="A")
        IString iEstViaActiva() ;
        
        @Data(size=1, value="I")
        IString iEstViaInactiva() ;
        
    }
    public interface IMovAglxPer extends IDataStruct {
        
        @Data(size=1, value="N")
        IString naoExisMovAglxPer() ;
        
        @Data(size=1, value="S")
        IString exisMovAglxPer() ;
        
    }
    public interface IMovAglxAtzUlt extends IDataStruct {
        
        @Data(size=1, value="N")
        IString naoExisMovAglxUlt() ;
        
        @Data(size=1, value="S")
        IString exisMovAglxUlt() ;
        
    }
    public interface IMovActzUlt extends IDataStruct {
        
        @Data(size=1, value="N")
        IString naoExisMovActzUlt() ;
        
        @Data(size=1, value="S")
        IString exisMovActzUlt() ;
        
    }
    
    /**
     * 
     * PROTOCOLOS
     * 
     * @version 2.0
     * 
     */
    public interface CProtCont extends IDataStruct {
        
        @Data(size=3, value="TSU")
        IString protocoloTsu() ;
        
        @Data(size=4, value="UNVE")
        IString universidade() ;
        
        @Data(size=4, value="CLEI")
        IString circuloLeitores() ;
        
        @Data(size=4, value="CLAY")
        IString cristianLay() ;
        
        @Data(size=4, value="TSUC")
        IString tsuContinente() ;
        
        @Data(size=4, value="TSUM")
        IString tsuMadeira() ;
        
        @Data(size=4, value="TSUA")
        IString tsuAcores() ;
        
        @Data(size=4, value="DUCS")
        IString ducs() ;
        
        @Data(size=3, value="DGT")
        IString protocoloDgt() ;
        
        @Data(size=3, value="DUC")
        IString protocoloDuc() ;
        
        @Data(size=3, value="SWF")
        IString protocoloSwift() ;
        
        @Data(size=3, value="IRE")
        IString dgciIr() ;
        
        @Data(size=3, value="IRC")
        IString dgciIrc() ;
        
        @Data(size=3, value="IRS")
        IString dgciIrs() ;
        
        @Data(size=3, value="BCA")
        IString contaBca() ;
        
        @Data(size=4, value="TSUG")
        IString tesourarias() ;
        
        @Data(size=3, value="ATQ")
        IString contribAutq() ;
        
        @Data(size=3, value="IVA")
        IString protocoloIva() ;
        
    }
    
    /**
     * 
     * PREMIOS
     * 
     * @version 2.0
     * 
     */
    public interface CTipoPremio extends IDataStruct {
        
        @Data(size=1, value="M")
        IString premioMonetario() ;
        
        @Data(size=1, value="E")
        IString premioEspecie() ;
        
    }
    public interface Premios extends IDataStruct {
        
        @Data(size=1, value="A")
        IString premioActivo() ;
        
        @Data(size=1, value="N")
        IString premioEliminado() ;
        
        @Data(size=1, value="P")
        IString premioPago() ;
        
    }
    public interface CEstPremOpps extends IDataStruct {
        
        @Data(size=1, value="P")
        IString cEstPremPago() ;
        
        @Data(size=1, value="N")
        IString cEstPremEliminado() ;
        
        @Data(size=1, value="A")
        IString cEstPremActivo() ;
        
    }
    
    /**
     * 
     * GATILHOS DE VESPERA
     * 
     * @version 2.0
     * 
     */
    public interface GatilhosVespera extends IDataStruct {
        
        @Data(size=5, value="QDDIV")
        IString gatvQRetdCmrgDcbo() ;
        
        @Data(size=5, value="QVCOB")
        IString gatvQuedaVcob() ;
        
        @Data(size=5, value="LIQJU")
        IString gatvLiqJuros() ;
        
        @Data(size=5, value="AGMOV")
        IString gatvAglutMovCad() ;
        
        @Data(size=5, value="NEGTX")
        IString gatvNegTaxa() ;
        
        @Data(size=5, value="NEGEC")
        IString gatvNegEncg() ;
        
        @Data(size=5, value="SPRDV")
        IString gatvSpreadBundDv() ;
        
        @Data(size=5, value="SPRCR")
        IString gatvSpreadBundCr() ;
        
        @Data(size=5, value="SPRAM")
        IString gatvSpreadBundAmb() ;
        
    }
    public interface EstGatVespera extends IDataStruct {
        
        @Data(size=1, value="A")
        IString iEstGtloActivo() ;
        
        @Data(size=1, value="C")
        IString iEstGtloCancelado() ;
        
    }
    
    /**
     * 
     * GATILHOS DE CONTA
     * 
     * @version 2.0
     * 
     */
    public interface Gatilhos extends IDataStruct {
        
        @Data(size=3, value="RDI")
        IString gatCtaReclasDiariz() ;
        
        @Data(size=3, value="ENC")
        IString gatCtaEncerrConta() ;
        
        @Data(size=3, value="LQS")
        IString gatCtaLiqSubconta() ;
        
        @Data(size=3, value="NGZ")
        IString gatCtaValNgczEclo() ;
        
    }
    public interface CndzMovzContIdade extends IDataStruct {
        
        @Data(size=3, signed=true, value="15")
        IInt cndzMovzIMenor() ;
        
        @Data(size=3, signed=true, value="18")
        IInt cndzMovzIMenNAut() ;
        
    }
    
    /**
     * 
     * TAREFAS
     * 
     * @version 2.0
     * 
     */
    public interface NsCodTrfDia extends IDataStruct {
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt alteracaoGestorCta() ;
        
        @Data(size=2, signed=true, value="2", compression=COMP3)
        IInt alteracaoOeCta() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt liquidacaoDepositos() ;
        
        @Data(size=2, signed=true, value="2", compression=COMP3)
        IInt liquidacaoDeposRej() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt liquidDepsExtrutr() ;
        
        @Data(size=2, signed=true, value="2", compression=COMP3)
        IInt liquidDepsExtRej() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt cashManagementRejt() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt liquidAntecpdRejt() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt movimFuturoRejt() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt pedidoFotocDucs() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt cobrancaDespManut() ;
        
    }
    
    /**
     * 
     * CRITERIOS DE PASSAGEM A HISTORICO
     * 
     * @version 2.0
     * 
     */
    public interface ParamPassHist extends IDataStruct {
        
        /**
         * @return instancia da classe local HistGuiasTribunal
         */
        @Data
        HistGuiasTribunal histGuiasTribunal() ;
        
        
        public interface HistGuiasTribunal extends IDataStruct {
            
            @Data(size=2, value="27")
            IInt histGuiaTribCPrz() ;
            
            @Data(size=2, value="1")
            IInt histGuiaTribDuPrz() ;
            
        }
    }
    
    /**
     * 
     * LOTES
     * 
     * @version 2.0
     * 
     */
    public interface ISitLoteVcob extends IDataStruct {
        
        @Data(size=1, value="A")
        IString loteAberto() ;
        
        @Data(size=1, value="F")
        IString loteFechado() ;
        
    }
    
    /**
     * 
     * COMUNICACOES
     * 
     * @version 2.0
     * 
     */
    public interface CCmczCli extends IDataStruct {
        
        @Data(size=3, value="EMA")
        IString cmczAglutinacaoMovs() ;
        
        @Data(size=3, value="AAC")
        IString cmczAberturaCta() ;
        
        @Data(size=3, value="EXS")
        IString cmczExtractoSimples() ;
        
        @Data(size=3, value="EXC")
        IString cmczExtractoCombin() ;
        
        @Data(size=3, value="EXJ")
        IString cmczExtractoJuros() ;
        
        @Data(size=3, value="ADM")
        IString cmczCobDespManut() ;
        
        @Data(size=3, value="DEE")
        IString cmczDeclEntrEfect() ;
        
        @Data(size=3, value="APE")
        IString cmczPlanoNaoCump() ;
        
        @Data(size=3, value="ISC")
        IString cmczDebIsCapital() ;
        
        @Data(size=3, value="JDV")
        IString cmczDebJurosDev() ;
        
        @Data(size=3, value="MBA")
        IString cmczMobAntecipada() ;
        
        @Data(size=3, value="IRC")
        IString cmczDeclaracaoIrs() ;
        
        @Data(size=3, value="AOP")
        IString cmczAvsoOper() ;
        
        @Data(size=3, value="CRJ")
        IString cmczCreJuros() ;
        
        @Data(size=3, value="030")
        IString cmczModelo15() ;
        
        @Data(size=3, value="101")
        IString cmczAbertDpMe() ;
        
        @Data(size=3, value="102")
        IString cmczAlterAutomProd() ;
        
    }
    
    /**
     * 
     * LANCAMENTOS DE RETAGUARDA
     * 
     * @version 2.0
     * 
     */
    public interface IOrigemFichLr extends IDataStruct {
        
        @Data(size=1, value="P")
        IString movLrJuroPendente() ;
        
        @Data(size=1, value="O")
        IString movLrJuroPagCob() ;
        
        @Data(size=1, value="E")
        IString movLrJurPendBloq() ;
        
        @Data(size=1, value="B")
        IString movLrJurPagcobBlq() ;
        
        /**
         * *COBRANCA FIRME ENCARGOS LIQUIDOS SOBRE EMISSAO EXTRACTO SIMPLES
         */
        @Data(size=1, value="X")
        IString movLrEncgExtrSmpl() ;
        
    }
    public interface LrImpSelSmDevedor extends IDataStruct {
        
        @Data(size=3, signed=true, value="114", compression=COMP3)
        IInt isCServPrsdCgd() ;
        
        @Data(size=3, value="PT ")
        IString isCPaisIsoaOeOpx() ;
        
        @Data(size=3, value="CGD")
        IString isCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt isCOeGerx() ;
        
    }
    public interface LrEncargos extends IDataStruct {
        
        @Data(size=3, signed=true, value="113", compression=COMP3)
        IInt ecCServPrsdCgd() ;
        
        @Data(size=3, value="PT ")
        IString ecCPaisIsoaOeOpx() ;
        
        @Data(size=3, value="CGD")
        IString ecCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt ecCOeGerx() ;
        
    }
    public interface LrDespesaManutencao extends IDataStruct {
        
        @Data(size=3, signed=true, value="112", compression=COMP3)
        IInt mtCServPrsdCgd() ;
        
        @Data(size=3, value="PT ")
        IString mtCPaisIsoaOeOpx() ;
        
        @Data(size=3, value="CGD")
        IString mtCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt mtCOeGerx() ;
        
    }
    public interface LrAnulCbrEncg extends IDataStruct {
        
        @Data(size=3, signed=true, value="513", compression=COMP3)
        IInt anServPrsdCgd() ;
        
        @Data(size=3, value="PT ")
        IString anCPaisIsoaOeOpx() ;
        
        @Data(size=3, value="CGD")
        IString anCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt anCOeGerx() ;
        
    }
    public interface LrJurosAPagar extends IDataStruct {
        
        @Data(size=3, signed=true, value="510", compression=COMP3)
        IInt pgJuroCgd() ;
        
        @Data(size=3, value="PT ")
        IString pgCPaisIsoaOeOpx() ;
        
        @Data(size=3, value="CGD")
        IString pgCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt pgCOeGerx() ;
        
    }
    public interface LrJurosACobrar extends IDataStruct {
        
        @Data(size=3, signed=true, value="111", compression=COMP3)
        IInt cbJuroCgd() ;
        
        @Data(size=3, signed=true, value="110", compression=COMP3)
        IInt cbJuroFirme() ;
        
        @Data(size=3, value="PT ")
        IString cCPaisIsoaOeOpx() ;
        
        @Data(size=3, value="CGD")
        IString cCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt cCOeGerx() ;
        
    }
    public interface LrLiqVencDepositos extends IDataStruct {
        
        @Data(size=3, signed=true, value="511", compression=COMP3)
        IInt lqServPrsdCgd() ;
        
        @Data(size=3, value="PT ")
        IString lqCPaisIsoaOeOpx() ;
        
        @Data(size=3, value="CGD")
        IString lqCMnemEgcOpex() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt lqCOeGerx() ;
        
    }
    public interface LrLiqVencDepEstr extends IDataStruct {
        
        @Data(size=3, signed=true, value="512", compression=COMP3)
        IInt lqSvPrsdCgdEstr() ;
        
        @Data(size=3, value="PT ")
        IString lqCPaisIsoaEstr() ;
        
        @Data(size=3, value="CGD")
        IString lqCMnemEgcEstr() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt lqCOeGerxEstr() ;
        
    }
    
    /**
     * 
     * *COBRANCA FIRME ENCARGOS LIQUIDOS SOBRE EMISSAO EXTRACTO SIMPLES
     * 
     * @version 2.0
     * 
     */
    public interface LrEncgExtrSimples extends IDataStruct {
        
        @Data(size=3, signed=true, value="117", compression=COMP3)
        IInt encgCServExtrSimp() ;
        
        @Data(size=3, value="PT ")
        IString encgCPaisIsaExtS() ;
        
        @Data(size=3, value="CGD")
        IString encgCMnemExtrS() ;
        
        @Data(size=4, signed=true, value="9170", compression=COMP3)
        IInt encgCOeGerxExtrS() ;
        
    }
    
    /**
     * 
     * LR-PENDENTES
     * VALORES NAO DEFINIDOS TALVEZ NAO NECESSARIOS
     * LR DE MOVIMENTOS A FUTURO PARA CREDITO (CR) E DEBITO (DB)
     * 05 BHOK0002-LR-MOV-FUT-N-LIQ-C.
     * 10 BHOK0002-MOV-SV-PRSD-CGD-CR PIC S9(3) COMP-3 VALUE 513.
     * 10 BHOK0002-MOV-C-PAIS-ISOA-CR
     * PIC X(03) VALUE 'PT '.
     * 10 BHOK0002-MOV-C-MNEM-EGC-CR  PIC X(03) VALUE 'CGD'.
     * 10 BHOK0002-MOV-C-OE-GERX-CR   PIC S9(4) COMP-3 VALUE 9171.
     * 05 BHOK0002-LR-MOV-FUT-N-LIQ-D.
     * 10 BHOK0002-MOV-SV-PRSD-CGD-DB PIC S9(3) COMP-3 VALUE 514.
     * 10 BHOK0002-MOV-C-PAIS-ISOA-DB
     * 10 BHOK0002-MOV-C-MNEM-EGC-DB  PIC X(03) VALUE 'CGD'.
     * 10 BHOK0002-MOV-C-OE-GERX-DB   PIC S9(4) COMP-3 VALUE 9172.
     * BLOQUEIOS
     * A CONSTANTE BHOK0002-BLOQ-ALT-PRODUTO E APENAS UMA CONSTANTE
     * DE CONTROLE DA QUANTIDADE DE BLOQUEIOS ORIGINADA POR ALTERACAO
     * DE PRODUTO, NAO ORIGINA BLOQUEIOS DE CONTA OU SUBCONTA
     * 
     * @version 2.0
     * 
     */
    public interface BloqueiosContas extends IDataStruct {
        
        @Data(size=5, value="HV000")
        IString bloqMovimentacao() ;
        
        @Data(size=5, value="ALTPR")
        IString bloqAltProduto() ;
        
        @Data(size=5, value="HO003")
        IString bloqManutTitular() ;
        
        @Data(size=5, value="HV014")
        IString bloqTransCaderneta() ;
        
        @Data(size=5, value="HO002")
        IString bloqAltDadCont() ;
        
        @Data(size=5, value="HO009")
        IString bloqAltDadScta() ;
        
        @Data(size=5, value="HO016")
        IString bloqZFimLiq() ;
        
        @Data(size=5, value="HO017")
        IString bloqAbrtScta() ;
        
        @Data(size=5, value="HV011")
        IString bloqLiqScta() ;
        
        @Data(size=5, value="HO026")
        IString bloqAltSctasJur() ;
        
        @Data(size=5, value="SPRDB")
        IString bloqSpreadsBund() ;
        
        @Data(size=5, value="NGCZT")
        IString bloqNgczTaxa() ;
        
        @Data(size=5, value="NGCZE")
        IString bloqNgczEncg() ;
        
        @Data(size=5, value="PGENC")
        IString bloqPagEncargo() ;
        
    }
    
    /**
     * 
     * CODIGOS DE COMUNICACAO PARA IMPRESSAO NO SGPD
     * 
     * @version 2.0
     * 
     */
    public interface CCmnzSgpd extends IDataStruct {
        
        /**
         * AVISO DE ABETURA DE CONTA
         */
        @Data(size=6, value="MHO451")
        IString cartaAvisoAbrtCont() ;
        
        /**
         * AVISO DE DEBITO DE IMPOSTO SELO SOBRE CAPITAL
         */
        @Data(size=6, value="MHO124")
        IString cartaAviDebIsCapt() ;
        
        @Data(size=6, value="MHO899")
        IString cartaPlnEntrNCump() ;
        
        @Data(size=6, value="MHO114")
        IString avsCreditoJuros() ;
        
        @Data(size=6, value="MHO123")
        IString avsDebJurosDevdors() ;
        
        @Data(size=6, value="MHO125")
        IString avsDebJurosMobAnt() ;
        
        @Data(size=6, value="MHO472")
        IString cartaDespesasManuts() ;
        
        @Data(size=6, value="MHO464")
        IString cartaEntrEfectuadas() ;
        
        @Data(size=6, value="MHO242")
        IString cartaDeclaracaoIrc() ;
        
        @Data(size=6, value="MHO423")
        IString extrMovAglutinados() ;
        
        @Data(size=6, value="MHO234")
        IString extractoSimples() ;
        
        @Data(size=6, value="MHO235")
        IString extractoCombinado() ;
        
        @Data(size=6, value="MHO436")
        IString extrJurosSaldoVal() ;
        
        @Data(size=6, value="MHO446")
        IString extrJurosSaldoMed() ;
        
        @Data(size=6, value="MHO112")
        IString avisosOpersScta() ;
        
        @Data(size=6, value="MHO741")
        IString jurosEntEstado() ;
        
    }
    
    /**
     * 
     * REFERENCIA DO PRIMEIRO MOVIMENTO DA SUBCONTA
     * 
     * @version 2.0
     * 
     */
    public interface XRefMovAbr extends IDataStruct {
        
        @Data(size=8, value="ABERTURA")
        IString xRefMovAbertura() ;
        
    }
    
    /**
     * 
     * ESTADO DE PEDIDO DE ALTERAÃƒ O DE INDICADOR DE C LCULO DE JURO
     * 
     * @version 2.0
     * 
     */
    public interface PedidoAltCalJur extends IDataStruct {
        
        @Data(size=1, value="A")
        IString altCalJurAceite() ;
        
        @Data(size=1, value="R")
        IString altCalJurRejeitado() ;
        
        @Data(size=1, value="P")
        IString altCalJurPedido() ;
        
        @Data(size=1, value="E")
        IString altCalJurEliminado() ;
        
    }
    
    /**
     * 
     * ESTADO DO PAGAMENTO DE ENCARGOS (TAB GERAL G34)
     * 
     * @version 2.0
     * 
     */
    public interface EstadoPagamentoEnc extends IDataStruct {
        
        @Data(size=1, value="C")
        IString pagamentoCobrado() ;
        
        @Data(size=1, value="A")
        IString pagamentoAnulado() ;
        
        @Data(size=1, value="X")
        IString movimentoAnulacao() ;
        
    }
    public interface CImpostosSelo extends IDataStruct {
        
        @Data(size=3, value="I03")
        IString isJuros() ;
        
        @Data(size=3, value="I04")
        IString isJurosPrLetras() ;
        
        @Data(size=3, value="I05")
        IString isComisGarantPrs() ;
        
        @Data(size=3, value="I06")
        IString isComisContratprs() ;
        
        @Data(size=3, value="I08")
        IString isCheques() ;
        
        @Data(size=3, value="I17")
        IString isEscritos() ;
        
        @Data(size=3, value="I18")
        IString isSmd() ;
        
        @Data(size=3, value="I19")
        IString isPrecatorios() ;
        
    }
    public interface DadosFicheiroCrm extends IDataStruct {
        
        @Data(size=8, value="THO00002")
        IString nmTabelaI2() ;
        
        @Data(size=9, value="M_EXC_LIM")
        IString nmCampoI2() ;
        
        @Data(size=8, value="THO00003")
        IString nmTabelaN11() ;
        
        @Data(size=8, value="REN_NCAP")
        IString nmCampoN11() ;
        
        @Data(size=3, value="CRM")
        IString crm() ;
        
    }
    public interface CTransaccao extends IDataStruct {
        
        @Data(size=4, value="HOA6")
        IString abertContaExterna() ;
        
        @Data(size=4, value="HOA8")
        IString abertSctaExterna() ;
        
        @Data(size=5, value="HV042")
        IString protUniversidade() ;
        
        @Data(size=4, value="HVE2")
        IString cTranHve2() ;
        
        @Data(size=5, value="HV044")
        IString protCristianLay() ;
        
        @Data(size=4, value="HVE4")
        IString cTranHve4() ;
        
        @Data(size=4, value="HVC1")
        IString cTranHvc1() ;
        
        @Data(size=4, value="HVK4")
        IString cTranHvk4() ;
        
    }
    
    /**
     * 
     * INCUMPRIMENTO  - SERVICOS E CONSTANTES DAS ROTINAS
     * 
     * @version 2.0
     * 
     */
    public interface CSitIcpt extends IDataStruct {
        
        @Data(size=2, value="PC")
        IString cSitIcptPreCtx() ;
        
        @Data(size=2, value="DC")
        IString cSitIcptDespCtx() ;
        
        @Data(size=2, value="CJ")
        IString cSitIcptDajCobr() ;
        
        @Data(size=2, value="CO")
        IString cSitIcptDajOutr() ;
        
        @Data(size=2, value="RS")
        IString cSitIcptRetornGes() ;
        
        @Data(size=2, value="RC")
        IString cSitIcptRtGesRV() ;
        
        @Data(size=2, value="AB")
        IString cSitIcptAbatActiv() ;
        
        @Data(size=2, value="IN")
        IString cSitIcptPerdDiv() ;
        
        @Data(size=2, value="??")
        IString cSitIcptRetGesVc() ;
        
        @Data(size=2, value="NR")
        IString cSitIcptNormal() ;
        
    }
    public interface CTipoMovIcpt extends IDataStruct {
        
        @Data(size=2, value="01")
        IString cTipoMovIcptCom() ;
        
        @Data(size=2, value="02")
        IString cTipoMovIcptCap() ;
        
        @Data(size=2, value="03")
        IString cTipoMovIcptDpa() ;
        
        @Data(size=2, value="04")
        IString cTipoMovIcptJur() ;
        
        @Data(size=2, value="05")
        IString cTipoMovIcptMor() ;
        
        @Data(size=2, value="06")
        IString cTipoMovIcptImp() ;
        
    }
    public interface Rotinas extends IDataStruct {
        
        @Data(size=8, value="MHOK326A")
        IString mhok326a() ;
        
        @Data(size=8, value="MHOS324A")
        IString mhos324a() ;
        
        @Data(size=8, value="MHOS325A")
        IString mhos325a() ;
        
    }
    
    /**
     * 
     * CÃ‹DIGO MOTIVO DEVOLUÃƒ O DE CHEQUE
     * 
     * @version 2.0
     * 
     */
    public interface CMtvoDvlChq extends IDataStruct {
        
        @Data(size=2, value="15")
        IInt faltaSaldo() ;
        
    }
    
    /**
     * 
     * CODIGO ESTADO DEPOSITOS ESTRUTURADOS
     * 
     * @version 2.0
     * 
     */
    public interface CEstCvProd extends IDataStruct {
        
        @Data(size=2, signed=true, value="4")
        IInt cEstCvProdCmrc() ;
        
    }
    
    /**
     * 
     * CODIGO CONTRAPARTIDA DEPOSITOS ESTRUTURADOS
     * 
     * @version 2.0
     * 
     */
    public interface IContrapartida extends IDataStruct {
        
        @Data(size=1, value="B")
        IString creditoDo() ;
        
        @Data(size=1, value="A")
        IString abrtDepEstrut() ;
        
        @Data(size=1, value="C")
        IString entregDepEstrut() ;
        
    }
    
    /**
     * 
     * CODIGO MOVIMENTACAO
     * 
     * @version 2.0
     * 
     */
    public interface CodigoMovimentacao extends IDataStruct {
        
        @Data(size=5, value="HOZ01")
        IString cOpeBbnCph() ;
        
        @Data(size=5, value="HOZ10")
        IString cOpeBbnEmcCoe() ;
        
        @Data(size=5, value="HOZ11")
        IString cOpeBbnImpCoe() ;
        
        /**
         * CODIGO MOVIMENTACAO DE INCUMPRIMENTO
         */
        @Data(size=5, value="HOZ02")
        IString cOpeCapitalVencido() ;
        
        @Data(size=5, value="HOZ03")
        IString cOpeJuroVencidDiv() ;
        
        @Data(size=5, value="HOZ04")
        IString cOpeComissVencDiv() ;
        
        @Data(size=5, value="HOZ05")
        IString cOpeDespVencidDiv() ;
        
        @Data(size=5, value="HOZ06")
        IString cOpeImpostoDivida() ;
        
        @Data(size=5, value="HOZ07")
        IString cOpeJuroMoraDivid() ;
        
        @Data(size=5, value="HOZ08")
        IString cOpeImpostoSmd() ;
        
        @Data(size=5, value="HOZ09")
        IString cOpeImpostoJmor() ;
        
    }
    
    /**
     * 
     * CODIGO DE OPERACAO PARA TRANSFERENCIA DE DEPOSITOS
     * 
     * @version 2.0
     * 
     */
    public interface CodigoOperacaoTrf extends IDataStruct {
        
        @Data(size=5, value="HOZ13")
        IString cOpeBbnTransfDb() ;
        
        @Data(size=5, value="HOZ14")
        IString cOpeBbnTransfCr() ;
        
    }
    
    /**
     * 
     * CÃ‹DIGO TIPO DE PAGAMENTO DE ENCARGO
     * 
     * @version 2.0
     * 
     */
    public interface CTipoPagamento02 extends IDataStruct {
        
        @Data(size=1, value="P")
        IString pgmEncgParcial() ;
        
        @Data(size=1, value="T")
        IString pgmEncgTotal() ;
        
    }
    
    /**
     * 
     * CODIGO DO ESTADO DO PENDENTE
     * 
     * @version 2.0
     * 
     */
    public interface CEstadoPendente extends IDataStruct {
        
        @Data(size=1, value="A")
        IString pendActivo() ;
        
        @Data(size=1, value="C")
        IString pendCalculado() ;
        
        @Data(size=1, value="P")
        IString pendPerdoado() ;
        
        @Data(size=1, value="R")
        IString pendRetGestao() ;
        
    }
    
    /**
     * 
     * INDICADOR DE MOBILIZACAO
     * 
     * @version 2.0
     * 
     */
    public interface IMobilizacao extends IDataStruct {
        
        @Data(size=1, value="T")
        IString mobilizTotal() ;
        
        @Data(size=1, value="P")
        IString mobilizParcial() ;
        
    }
    
    /**
     * 
     * MOV CHP PARA MODELO 15 DGCI
     * *RPAULO
     * 
     * @version 2.0
     * 
     */
    public interface Modelo15 extends IDataStruct {
        
        @Data(size=1, value="0")
        IInt tipoRegisto() ;
        
        @Data(size=9, value="500960046")
        IString declarante() ;
        
        @Data(size=9, value="999999999")
        IString toc() ;
        
        @Data(size=4, value="3298")
        IInt servFiscal() ;
        
        @Data(size=1, value="1")
        IInt tipo() ;
        
        @Data(size=8, value="MODELO15")
        IString modelo() ;
        
    }
    
    /**
     * 
     * INDICADOR DE MOBILIZACAO POSSIVEL
     * 
     * @version 2.0
     * 
     */
    public interface IMobaPsvl extends IDataStruct {
        
        @Data(size=1, value="S")
        IString mobaPsvlSim() ;
        
        @Data(size=1, value="N")
        IString mobaPsvlNao() ;
        
    }
    
    /**
     * 
     * TIPO DE CONDICAO ESPECIAL - ENCARGOS
     * 
     * @version 2.0
     * 
     */
    public interface ITipoCndzEspl extends IDataStruct {
        
        @Data(size=1, value="R")
        IString isencaoRelativa() ;
        
        @Data(size=1, value="F")
        IString montanteFixo() ;
        
        @Data(size=1, value="T")
        IString taxaFixa() ;
        
    }
    public interface EstadoMovNostro extends IDataStruct {
        
        @Data(size=1, value="I")
        IString eMovCnosIrrec() ;
        
        @Data(size=1, value="E")
        IString eMovCnosEstrIrre() ;
        
        @Data(size=1, value="R")
        IString eMovCnosReconc() ;
        
        @Data(size=1, value="F")
        IString eMovCnosEstrRec() ;
        
        @Data(size=1, value="X")
        IString eMovCnosEestrIrec() ;
        
        @Data(size=1, value="W")
        IString eMovCnosEestrRec() ;
        
    }
    
    /**
     * 
     * INDICADOR DE IGUALDADE DE RENDIMENTO POR TITULAR
     * 
     * @version 2.0
     * 
     */
    public interface IIgdeIrTitc extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iIgdeIrTitSim() ;
        
        @Data(size=1, value="N")
        IString iIgdeIrTitNao() ;
        
        @Data(size=1, value="P")
        IString iIgdeIrTitEspec() ;
        
        @Data(size=1, value="X")
        IString iIgdeIrTitSemSig() ;
        
    }
    public interface ITipoNmri extends IDataStruct {
        
        @Data(size=1, value="I")
        IString iTipoNmriInterno() ;
        
        @Data(size=1, value="E")
        IString iTipoNmriExterno() ;
        
    }
    
    /**
     * 
     * GUIAS TRIBUNAL
     * 
     * @version 2.0
     * 
     */
    public interface CTipoTaxPpgmGtb extends IDataStruct {
        
        @Data(size=3, signed=true, value="3", compression=COMP3)
        IInt cTipoTaxPpcj003() ;
        
        @Data(size=3, signed=true, value="4", compression=COMP3)
        IInt cTipoTaxPpcj004() ;
        
        @Data(size=3, signed=true, value="5", compression=COMP3)
        IInt cTipoTaxPpcj005() ;
        
        @Data(size=3, signed=true, value="6", compression=COMP3)
        IInt cTipoTaxPpcj006() ;
        
    }
    
    /**
     * 
     * TIPOS DE CONTA
     * 
     * @version 2.0
     * 
     */
    public interface CTipoCont extends IDataStruct {
        
        @Data(size=3, value="57")
        IInt ctasCxPostal() ;
        
        @Data(size=3, value="999")
        IInt cTipoContDflt() ;
        
    }
    
    /**
     * 
     * FINALIDADES
     * 
     * @version 2.0
     * 
     */
    public interface CFineScta extends IDataStruct {
        
        /**
         * DOMICILIACAO SALARIAL
         */
        @Data(size=2, value="DS")
        IString domSalarial() ;
        
        /**
         * DOMICILIACAO PENSAO
         */
        @Data(size=2, value="DP")
        IString domPensao() ;
        
        /**
         * PRESTACAO DA SEGURANCA SOCIAL
         */
        @Data(size=2, value="PS")
        IString prestSegSoc() ;
        
        /**
         * ULTIMO MOVIMENTO DE DEBITO
         */
        @Data(size=2, value="UD")
        IString ultMovDeb() ;
        
        /**
         * ULTIMO MOVIMENTO DE CREDITO
         */
        @Data(size=2, value="UC")
        IString ultMovCred() ;
        
    }
    
    /**
     * 
     * FAMILIA DE PRODUTO PARA ISENCAO DE DESPESAS DE MANUTENCAO
     * 
     * @version 2.0
     * 
     */
    public interface CFamiProd extends IDataStruct {
        
        /**
         * FAMILIA DEPOSITO A ORDEM
         */
        @Data(size=3, value="400")
        IString famiDepOrd() ;
        
    }
    
    /**
     * 
     * CONSTANTES MOSELLE
     * 
     * @version 2.0
     * 
     */
    public interface ConstMoselle extends IDataStruct {
        
        @Data(size=3, value="LU ")
        IString cPaisLux() ;
        
        @Data(size=4, signed=true, value="302", compression=COMP3)
        IInt cBancLux() ;
        
        @Data(size=3, value="CLU")
        IString cEmpGcxLux() ;
        
    }
    
    /**
     * 
     * PRODUTOS PARA ISENCAO DE DESPESAS DE MANUTENCAO
     * 
     * @version 2.0
     * 
     */
    public interface CProduto extends IDataStruct {
        
        /**
         * PRODUTO CAIXA CRESCER
         */
        @Data(size=3, value="011")
        IString prodCxCresc() ;
        
        /**
         * PRODUTO CAIXA JOVEM
         */
        @Data(size=3, value="012")
        IString prodCxJovem() ;
        
        /**
         * PRODUTO CAIXA CRESCER EXTRACTO
         */
        @Data(size=3, value="013")
        IString prodCxCrescEx() ;
        
        /**
         * PRODUTO CAIXA JOVEM EXTRACTO
         */
        @Data(size=3, value="014")
        IString prodCxJovemEx() ;
        
    }
    
}
