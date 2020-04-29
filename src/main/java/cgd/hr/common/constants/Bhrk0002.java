package cgd.hr.common.constants;

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
public interface Bhrk0002 extends IDataStruct {
    
    /**
     * CONSTANTES DA APLICACAO HR GENERICAS
     */
    public static final String BHRK0002_C_PAIS_PORTUGAL = "PT" ;
    
    public static final String BHRK0002_C_PAIS_LUXEMBURGO = "LU " ;
    
    public static final String BHRK0002_C_EMP_SUC_LUX = "CLU" ;
    
    public static final int BHRK0002_C_BANCO_SUC_LUX = 302 ;
    
    public static final String BHRK0002_CON_1 = "1" ;
    
    public static final int BHRK0002_CON_1N = 1 ;
    
    public static final int BHRK0002_CON_43 = 43 ;
    
    public static final String BHRK0002_CON_N = "N" ;
    
    public static final String BHRK0002_CON_S = "S" ;
    
    public static final String BHRK0002_CON_C = "C" ;
    
    public static final String BHRK0002_CON_D = "D" ;
    
    public static final String BHRK0002_CON_I = "I" ;
    
    public static final String BHRK0002_CON_R1 = "R1" ;
    
    public static final String BHRK0002_CON_I07 = "I07" ;
    
    public static final String BHRK0002_ERROS_FUNCAO = "FU" ;
    
    public static final String BHRK0002_VISUALIZACAO = "V" ;
    
    public static final String BHRK0002_DESCRICOES = "D" ;
    
    /**
     * SIGLA DA APLICACAO
     */
    public static final String BHRK0002_A_APLICACAO = "HR" ;
    
    public static final String BHRK0002_APLIC = "R" ;
    
    public static final String BHRK0002_APLICACAO = "HR " ;
    
    public static final String BHRK0002_C_OPCZ_MENU_BATCH = "999" ;
    
    /**
     * SIGLA DA APLICACAO ORIGEM PARA INFORMACAO NA SEQ. DE FICHEIROS
     */
    public static final String BHRK0002_APLIC_ETR_PEDNIB = "HRNB" ;
    
    public static final String BHRK0002_APLIC_ETR_TRANSF = "HRTR" ;
    
    /**
     * CODIGOS DE FAMILIA PRODUTO DE TRANSFERENCIAS
     */
    public static final String BHRK0002_C_FAMI_PROD_TRFC = "405" ;
    
    public static final String BHRK0002_C_PRODUTO_TRFC = "001" ;
    
    /**
     * @return instancia da classe local CFichSibs
     */
    @Data
    CFichSibs cFichSibs() ;
    
    /**
     * @return instancia da classe local Mapas
     */
    @Data
    Mapas mapas() ;
    
    /**
     * @return instancia da classe local CEventoCmcz
     */
    @Data
    CEventoCmcz cEventoCmcz() ;
    
    /**
     * @return instancia da classe local Tabelas
     */
    @Data
    Tabelas tabelas() ;
    
    /**
     * @return instancia da classe local NomeColuna
     */
    @Data
    NomeColuna nomeColuna() ;
    
    /**
     * @return instancia da classe local Datas
     */
    @Data
    Datas datas() ;
    
    /**
     * @return instancia da classe local IEstOrdTrfc
     */
    @Data
    IEstOrdTrfc iEstOrdTrfc() ;
    
    /**
     * @return instancia da classe local CTipoOrdTrfc
     */
    @Data
    CTipoOrdTrfc cTipoOrdTrfc() ;
    
    /**
     * @return instancia da classe local IAccao
     */
    @Data
    IAccao iAccao() ;
    
    /**
     * @return instancia da classe local HorasFecho
     */
    @Data
    HorasFecho horasFecho() ;
    
    /**
     * @return instancia da classe local IFchoCpszUrgt
     */
    @Data
    IFchoCpszUrgt iFchoCpszUrgt() ;
    
    /**
     * @return instancia da classe local IEstExcsTrfc
     */
    @Data
    IEstExcsTrfc iEstExcsTrfc() ;
    
    /**
     * @return instancia da classe local CTipoExcsTrfc
     */
    @Data
    CTipoExcsTrfc cTipoExcsTrfc() ;
    
    /**
     * @return instancia da classe local CTipoCli
     */
    @Data
    CTipoCli cTipoCli() ;
    
    /**
     * @return instancia da classe local EmissaoAviso
     */
    @Data
    EmissaoAviso emissaoAviso() ;
    
    /**
     * @return instancia da classe local IPerExcsTrfc
     */
    @Data
    IPerExcsTrfc iPerExcsTrfc() ;
    
    /**
     * @return instancia da classe local Estados
     */
    @Data
    Estados estados() ;
    
    /**
     * @return instancia da classe local CTipoPraz
     */
    @Data
    CTipoPraz cTipoPraz() ;
    
    /**
     * @return instancia da classe local CodigosProcDatas
     */
    @Data
    CodigosProcDatas codigosProcDatas() ;
    
    /**
     * @return instancia da classe local IDebFrme
     */
    @Data
    IDebFrme iDebFrme() ;
    
    /**
     * @return instancia da classe local IAcsHist
     */
    @Data
    IAcsHist iAcsHist() ;
    
    /**
     * @return instancia da classe local IEstRegDstn
     */
    @Data
    IEstRegDstn iEstRegDstn() ;
    
    /**
     * @return instancia da classe local IEstPnot
     */
    @Data
    IEstPnot iEstPnot() ;
    
    @Data(size=1, value=" ")
    IString iAcczMntzLsta() ;
    @Data
    @Condition("C")
    ICondition acczLstaCriacao() ;
    @Data
    @Condition("A")
    ICondition acczLstaActualiza() ;
    @Data
    @Condition("E")
    ICondition acczLstaEliminacao() ;
    @Data
    @Condition("N")
    ICondition acczLstaNAlterada() ;
    
    
    /**
     * @return instancia da classe local IContDstnInto
     */
    @Data
    IContDstnInto iContDstnInto() ;
    
    /**
     * @return instancia da classe local IAccaoFecho
     */
    @Data
    IAccaoFecho iAccaoFecho() ;
    
    /**
     * @return instancia da classe local CEstPedEstt
     */
    @Data
    CEstPedEstt cEstPedEstt() ;
    
    /**
     * @return instancia da classe local CEstMovPedEstt
     */
    @Data
    CEstMovPedEstt cEstMovPedEstt() ;
    
    /**
     * @return instancia da classe local ITipMovPedEstt
     */
    @Data
    ITipMovPedEstt iTipMovPedEstt() ;
    
    @Data(size=1, signed=true, value="1", compression=COMP3)
    IInt nDstnCanc() ;
    
    /**
     * @return instancia da classe local ICancTodas
     */
    @Data
    ICancTodas iCancTodas() ;
    
    @Data(size=4, signed=true, value="987", compression=COMP3)
    IInt cServicoCentral() ;
    
    /**
     * @return instancia da classe local ServicoCentral
     */
    @Data
    ServicoCentral servicoCentral() ;
    
    /**
     * @return instancia da classe local BalcaoSede
     */
    @Data
    BalcaoSede balcaoSede() ;
    
    /**
     * @return instancia da classe local BalcaoCgdTelefone
     */
    @Data
    BalcaoCgdTelefone balcaoCgdTelefone() ;
    
    /**
     * @return instancia da classe local BalcaoCgdOnline
     */
    @Data
    BalcaoCgdOnline balcaoCgdOnline() ;
    
    /**
     * @return instancia da classe local BalcaoCgdEbanking
     */
    @Data
    BalcaoCgdEbanking balcaoCgdEbanking() ;
    
    /**
     * @return instancia da classe local BalcaoCgdEdibanca
     */
    @Data
    BalcaoCgdEdibanca balcaoCgdEdibanca() ;
    
    /**
     * @return instancia da classe local ContaDac
     */
    @Data
    ContaDac contaDac() ;
    
    /**
     * @return instancia da classe local EstIstzOrdTrf
     */
    @Data
    EstIstzOrdTrf estIstzOrdTrf() ;
    
    /**
     * @return instancia da classe local CTabGerais
     */
    @Data
    CTabGerais cTabGerais() ;
    
    /**
     * @return instancia da classe local CTipoRprz
     */
    @Data
    CTipoRprz cTipoRprz() ;
    
    /**
     * @return instancia da classe local TipoMov
     */
    @Data
    TipoMov tipoMov() ;
    
    /**
     * @return instancia da classe local ServSibs
     */
    @Data
    ServSibs servSibs() ;
    
    /**
     * @return instancia da classe local OpeSibs
     */
    @Data
    OpeSibs opeSibs() ;
    
    @Data(size=1, value="R")
    IString aplicFichSibs() ;
    
    /**
     * @return instancia da classe local FamiProd
     */
    @Data
    FamiProd famiProd() ;
    
    /**
     * @return instancia da classe local Produto
     */
    @Data
    Produto produto() ;
    
    /**
     * @return instancia da classe local CEvenOpel
     */
    @Data
    CEvenOpel cEvenOpel() ;
    
    /**
     * @return instancia da classe local SeveOpel
     */
    @Data
    SeveOpel seveOpel() ;
    
    /**
     * @return instancia da classe local IEstPedNib
     */
    @Data
    IEstPedNib iEstPedNib() ;
    
    /**
     * @return instancia da classe local CEstPedDvlzOtf
     */
    @Data
    CEstPedDvlzOtf cEstPedDvlzOtf() ;
    
    /**
     * @return instancia da classe local PreNotSibs
     */
    @Data
    PreNotSibs preNotSibs() ;
    
    /**
     * @return instancia da classe local IEstMovFichRtr
     */
    @Data
    IEstMovFichRtr iEstMovFichRtr() ;
    
    /**
     * @return instancia da classe local EstMovFichRtrpnib
     */
    @Data
    EstMovFichRtrpnib estMovFichRtrpnib() ;
    
    /**
     * @return instancia da classe local CTipoMov
     */
    @Data
    CTipoMov cTipoMov() ;
    
    /**
     * @return instancia da classe local CodSistema
     */
    @Data
    CodSistema codSistema() ;
    
    /**
     * @return instancia da classe local TipoInicOper
     */
    @Data
    TipoInicOper tipoInicOper() ;
    
    /**
     * @return instancia da classe local IContDstnInto02
     */
    @Data
    IContDstnInto02 iContDstnInto02() ;
    
    /**
     * @return instancia da classe local IIsezEncg
     */
    @Data
    IIsezEncg iIsezEncg() ;
    
    /**
     * @return instancia da classe local Hdt
     */
    @Data
    Hdt hdt() ;
    
    /**
     * @return instancia da classe local CServSibsTei
     */
    @Data
    CServSibsTei cServSibsTei() ;
    
    /**
     * @return instancia da classe local CErroSibs
     */
    @Data
    CErroSibs cErroSibs() ;
    
    /**
     * @return instancia da classe local Fecho
     */
    @Data
    Fecho fecho() ;
    
    /**
     * @return instancia da classe local CRejzTrfcSibs
     */
    @Data
    CRejzTrfcSibs cRejzTrfcSibs() ;
    
    /**
     * @return instancia da classe local Rotinas
     */
    @Data
    Rotinas rotinas() ;
    
    /**
     * @return instancia da classe local CTipoEncargo
     */
    @Data
    CTipoEncargo cTipoEncargo() ;
    
    /**
     * @return instancia da classe local CEstLoteTrfc
     */
    @Data
    CEstLoteTrfc cEstLoteTrfc() ;
    
    /**
     * @return instancia da classe local IEstTrfc
     */
    @Data
    IEstTrfc iEstTrfc() ;
    
    /**
     * @return instancia da classe local IEstEnviPlaf
     */
    @Data
    IEstEnviPlaf iEstEnviPlaf() ;
    
    /**
     * @return instancia da classe local IGerzPlafSibs
     */
    @Data
    IGerzPlafSibs iGerzPlafSibs() ;
    
    /**
     * @return instancia da classe local CProcBbn
     */
    @Data
    CProcBbn cProcBbn() ;
    
    /**
     * @return instancia da classe local IEstSitEncg
     */
    @Data
    IEstSitEncg iEstSitEncg() ;
    
    /**
     * @return instancia da classe local IOrdnDstn
     */
    @Data
    IOrdnDstn iOrdnDstn() ;
    
    /**
     * @return instancia da classe local IEstorno
     */
    @Data
    IEstorno iEstorno() ;
    
    /**
     * @return instancia da classe local IDbcr
     */
    @Data
    IDbcr iDbcr() ;
    
    /**
     * @return instancia da classe local CEntOrigFich
     */
    @Data
    CEntOrigFich cEntOrigFich() ;
    
    /**
     * @return instancia da classe local ILoteDupd
     */
    @Data
    ILoteDupd iLoteDupd() ;
    
    /**
     * @return instancia da classe local IFichDupd
     */
    @Data
    IFichDupd iFichDupd() ;
    
    /**
     * @return instancia da classe local IEstPedAvsoTrf
     */
    @Data
    IEstPedAvsoTrf iEstPedAvsoTrf() ;
    
    /**
     * @return instancia da classe local ICobrancaSgr
     */
    @Data
    ICobrancaSgr iCobrancaSgr() ;
    
    /**
     * @return instancia da classe local ITipoFmon
     */
    @Data
    ITipoFmon iTipoFmon() ;
    
    /**
     * @return instancia da classe local CCmczCli
     */
    @Data
    CCmczCli cCmczCli() ;
    
    @Data(size=3, value="CGD")
    IString contabEmpresa() ;
    
    @Data(size=3, value="PT")
    IString contabPais() ;
    
    @Data(size=4, value="9520")
    IInt contabOrgao() ;
    
    /**
     * @return instancia da classe local CEstMovCrcb
     */
    @Data
    CEstMovCrcb cEstMovCrcb() ;
    
    /**
     * @return instancia da classe local CTipoPedEstt
     */
    @Data
    CTipoPedEstt cTipoPedEstt() ;
    
    /**
     * @return instancia da classe local ITipoMovimento
     */
    @Data
    ITipoMovimento iTipoMovimento() ;
    
    /**
     * @return instancia da classe local ITipoCbrcEncg
     */
    @Data
    ITipoCbrcEncg iTipoCbrcEncg() ;
    
    /**
     * @return instancia da classe local EstLancRetag
     */
    @Data
    EstLancRetag estLancRetag() ;
    
    /**
     * @return instancia da classe local EstProcesso
     */
    @Data
    EstProcesso estProcesso() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * CODIGOS DE FICHEIRO DA APLICACAO.
     * 
     * @version 2.0
     * 
     */
    public interface CFichSibs extends IDataStruct {
        
        @Data(size=3, value="PLF")
        IString hrPlf() ;
        
        @Data(size=3, value="ANL")
        IString hrAnl() ;
        
        @Data(size=3, value="EDV")
        IString hrEdv() ;
        
        @Data(size=3, value="ETR")
        IString hrEtr() ;
        
        @Data(size=3, value="ERR")
        IString hrErr() ;
        
        @Data(size=3, value="ETA")
        IString fichEta() ;
        
        @Data(size=3, value="RTR")
        IString fichRtr() ;
        
        @Data(size=3, value="FCT")
        IString fichFct() ;
        
        @Data(size=3, value="RCT")
        IString fichRct() ;
        
        /**
         * TIPO TRATAMENTO CONTA
         */
        @Data(size=2, value="34")
        IString cTipoTrttContTr() ;
        
    }
    
    /**
     * 
     * NOMES DE MAPAS
     * 
     * @version 2.0
     * 
     */
    public interface Mapas extends IDataStruct {
        
        @Data(size=6, value="MHR007")
        IString mhr007() ;
        
        @Data(size=6, value="MHR008")
        IString mhr008() ;
        
        @Data(size=6, value="MHR009")
        IString mhr009() ;
        
        @Data(size=6, value="MHR010")
        IString mhr010() ;
        
    }
    
    /**
     * 
     * *--- CODIGOS DE EVENTO DE COMUNICACAO - SGCC - TAB. GERAL T21
     * *--- Comunicacao 6 - Operacoes de transferencias
     * 
     * @version 2.0
     * 
     */
    public interface CEventoCmcz extends IDataStruct {
        
        /**
         * *--- Transferencias Nacionais SEPA
         */
        @Data(size=4, value="HR01")
        IString cEventoCmczHr01() ;
        
        @Data(size=4, value="HR02")
        IString cEventoCmczHr02() ;
        
        /**
         * *---Comissoes e Impostos de transferencias Nacionais e SEPA
         */
        @Data(size=4, value="HR03")
        IString cEventoCmczHr03() ;
        
    }
    
    /**
     * 
     * NOMES DE TABELAS
     * 
     * @version 2.0
     * 
     */
    public interface Tabelas extends IDataStruct {
        
        @Data(size=18, value="VHR00101_ORDTRFC")
        IString vhr00101() ;
        
        @Data(size=18, value="VHR00201_DSTNOTRF")
        IString vhr00201() ;
        
        @Data(size=18, value="VHR00301_HORDTRFC")
        IString vhr00301() ;
        
        @Data(size=18, value="VHR00401_HDSTNOTRF")
        IString vhr00401() ;
        
        @Data(size=18, value="VHR00501_EXCSOTRF")
        IString vhr00501() ;
        
        @Data(size=18, value="VHR00601_ISTZORDN")
        IString vhr00601() ;
        
        @Data(size=18, value="VHR00701_ISTZDSTN")
        IString vhr00701() ;
        
        @Data(size=18, value="VHR00801_ANLALTNIB")
        IString vhr00801() ;
        
        @Data(size=18, value="VHR00901_MOVRECEBI")
        IString vhr00901() ;
        
        @Data(size=18, value="VHR01001_HITMOVREC")
        IString vhr01001() ;
        
        @Data(size=18, value="VHR01101_PLAFONDS")
        IString vhr01101() ;
        
        @Data(size=18, value="VHR01201_PRENTFZ")
        IString vhr01201() ;
        
        @Data(size=18, value="VHR01301_BANCRPRD")
        IString vhr01301() ;
        
        @Data(size=18, value="VHR01401_ENCARGO")
        IString vhr01401() ;
        
        @Data(size=18, value="VHR01501_PEDNIBOIC")
        IString vhr01501() ;
        
        @Data(size=18, value="VHR01601_PEDNIBCGD")
        IString vhr01601() ;
        
        @Data(size=18, value="VHR01701_MOVCPSZ")
        IString vhr01701() ;
        
        @Data(size=18, value="VHR01801_FTRZ")
        IString vhr01801() ;
        
        @Data(size=18, value="VHR01901_LOGORDENS")
        IString vhr01901() ;
        
        @Data(size=18, value="VHR02001_LOTE")
        IString vhr02001() ;
        
        @Data(size=18, value="VHR02101_AGNATRF")
        IString vhr02101() ;
        
        @Data(size=18, value="VHR02201_PEDDVZCGD")
        IString vhr02201() ;
        
        @Data(size=18, value="VHR02301_PEDDVZOIC")
        IString vhr02301() ;
        
        @Data(size=18, value="VHR02401_HISTZORDN")
        IString vhr02401() ;
        
        @Data(size=18, value="VHR02501_HISTZDSTN")
        IString vhr02501() ;
        
        @Data(size=18, value="VHR02601_HAGNATRF")
        IString vhr02601() ;
        
        @Data(size=18, value="VHR02701_PEDESTT")
        IString vhr02701() ;
        
        @Data(size=18, value="VHR02901_PDMOVBKUP")
        IString vhr02901() ;
        
        @Data(size=18, value="VHR03001_PROCESSOS")
        IString vhr03001() ;
        
        @Data(size=18, value="VHR03101_FCHENVSIB")
        IString vhr03101() ;
        
        @Data(size=18, value="VHR03201_ESTTTRFC")
        IString vhr03201() ;
        
        @Data(size=18, value="VHR03301_MOVBANRPD")
        IString vhr03301() ;
        
        @Data(size=18, value="VHR03401_PLNOTRFC")
        IString vhr03401() ;
        
        @Data(size=18, value="VHR04001_DLHAVSDTN")
        IString vhr04001() ;
        
        @Data(size=18, value="VHR04101_DLHAVSORD")
        IString vhr04101() ;
        
        @Data(size=18, value="VHR04201_DLHAVSDSP")
        IString vhr04201() ;
        
        @Data(size=18, value="VHR04301_PEDAVSTRF")
        IString vhr04301() ;
        
    }
    
    /**
     * 
     * AREA DE NOMES DE COLUNAS PARA LOG
     * 
     * @version 2.0
     * 
     */
    public interface NomeColuna extends IDataStruct {
        
        @Data(size=18, value="I-DEB-FRME")
        IString colIDebFrme() ;
        
        @Data(size=18, value="I-EMIS-AVSO-ORDN")
        IString colIEmisAvsoOrdn() ;
        
        @Data(size=18, value="F-ISEZ-ENCG")
        IString colFIsezEncg() ;
        
        @Data(size=18, value="Z-INIC-TRFC")
        IString colZInicTrfc() ;
        
        @Data(size=18, value="Q-TNTV-DEB")
        IString colQTntvDeb() ;
        
        @Data(size=18, value="M-TRFC-TOT")
        IString colMTrfcTot() ;
        
        @Data(size=18, value="I-EST-ORD-TRFC")
        IString colIEstOrdTrfc() ;
        
    }
    
    /**
     * 
     * CONSTANTES DE DATAS
     * 
     * @version 2.0
     * 
     */
    public interface Datas extends IDataStruct {
        
        @Data(size=10, value="0001-01-01")
        IString dataMinima10() ;
        
        @Data(size=8, value="00010101")
        IString dataMinima8() ;
        
        @Data(size=10, value="9999-12-31")
        IString dataMaxima10() ;
        
        @Data(size=8, value="99991231")
        IString dataMaxima8() ;
        
    }
    
    /**
     * 
     * CAMPO I-EST-ORD-TRF (INDICADOR DO ESTADO DA ORDEM DE
     * TRANSFERENCIA) DA TABELA 1
     * 
     * @version 2.0
     * 
     */
    public interface IEstOrdTrfc extends IDataStruct {
        
        @Data(size=1, value="A")
        IString estOrdTrfAberta() ;
        
        @Data(size=1, value="F")
        IString estOrdTrfFechada() ;
        
        @Data(size=1, value="E")
        IString estOrdTrfExecutada() ;
        
        @Data(size=1, value="C")
        IString estOrdTrfCancelada() ;
        
    }
    
    /**
     * 
     * TIPOS DE ORDENS DE TRANSFERENCIA
     * 
     * @version 2.0
     * 
     */
    public interface CTipoOrdTrfc extends IDataStruct {
        
        @Data(size=1, value="P")
        IString permanente() ;
        
        @Data(size=1, value="U")
        IString pontual() ;
        
        @Data(size=1, value="V")
        IString periodica() ;
        
    }
    
    /**
     * 
     * INDICADOR DE ACCAO
     * 
     * @version 2.0
     * 
     */
    public interface IAccao extends IDataStruct {
        
        @Data(size=1, value="M")
        IString accaoModificacao() ;
        
        @Data(size=1, value="A")
        IString accaoAnulacao() ;
        
        @Data(size=1, value="V")
        IString accaoVizualizacao() ;
        
        @Data(size=1, value="C")
        IString accaoCriacao() ;
        
        @Data(size=1, value="N")
        IString accaoAnulNotrunc() ;
        
    }
    
    /**
     * 
     * HORAS DE FECHO
     * 
     * @version 2.0
     * 
     */
    public interface HorasFecho extends IDataStruct {
        
        @Data(size=8, value="19.00.00")
        IString hora1Fecho() ;
        
        @Data(size=8, value="13.45.00")
        IString hora2Fecho() ;
        
    }
    
    /**
     * 
     * INDICADOR DE FECHO DE ORDEM URGENTE
     * 
     * @version 2.0
     * 
     */
    public interface IFchoCpszUrgt extends IDataStruct {
        
        @Data(size=1, signed=true, value="2", compression=COMP3)
        IInt fchoUrgtSim() ;
        
        @Data(size=1, signed=true, value="1", compression=COMP3)
        IInt fchoUrgtNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DO ESTADO DE EXCLUSAO
     * 
     * @version 2.0
     * 
     */
    public interface IEstExcsTrfc extends IDataStruct {
        
        @Data(size=1, value="A")
        IString excsTrfcActivo() ;
        
        @Data(size=1, value="I")
        IString excsTrfcInactivo() ;
        
        @Data(size=1, value="C")
        IString excsTrfcCancelado() ;
        
    }
    
    /**
     * 
     * TIPO DE EXCLUSAO DE ORDEM
     * 
     * @version 2.0
     * 
     */
    public interface CTipoExcsTrfc extends IDataStruct {
        
        @Data(size=1, value="P")
        IString tipoExcsPermanente() ;
        
        @Data(size=1, value="T")
        IString tipoExcsPontual() ;
        
    }
    
    /**
     * 
     * TIPO DE CLIENTE
     * 
     * @version 2.0
     * 
     */
    public interface CTipoCli extends IDataStruct {
        
        @Data(size=1, value="E")
        IString clienteEmpresa() ;
        
        @Data(size=1, value="I")
        IString clienteEni() ;
        
        @Data(size=1, value="P")
        IString clienteParticular() ;
        
    }
    
    /**
     * 
     * INDICADOR DE EMISSAO DE AVISO
     * 
     * @version 2.0
     * 
     */
    public interface EmissaoAviso extends IDataStruct {
        
        @Data(size=1, value="S")
        IString emissaoAvisoSim() ;
        
        @Data(size=1, value="N")
        IString emissaoAvisoNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DO PERIODO EXCLUSAO DA ORDEM
     * 
     * @version 2.0
     * 
     */
    public interface IPerExcsTrfc extends IDataStruct {
        
        @Data(size=1, value="S")
        IString perExcsTrfcSim() ;
        
        @Data(size=1, value="N")
        IString perExcsTrfcNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DE ESTADOS (GERAL)
     * 
     * @version 2.0
     * 
     */
    public interface Estados extends IDataStruct {
        
        @Data(size=1, value="A")
        IString activo() ;
        
        @Data(size=1, value="C")
        IString cancelado() ;
        
        @Data(size=1, value="I")
        IString inactivo() ;
        
        @Data(size=1, value="M")
        IString modificada() ;
        
        @Data(size=1, value="R")
        IString rejeitada() ;
        
        @Data(size=1, value="N")
        IString nao() ;
        
        @Data(size=1, value="S")
        IString sim() ;
        
        @Data(size=3, value="EUR")
        IString euro() ;
        
        @Data(size=1, value="A")
        IString aEnviar() ;
        
        @Data(size=1, value="E")
        IString executado() ;
        
    }
    
    /**
     * 
     * CODIGOS DE TIPOS DE PRAZO PARA CALCULO DE DATAS
     * 
     * @version 2.0
     * 
     */
    public interface CTipoPraz extends IDataStruct {
        
        @Data(size=4, value="1")
        IInt prazoDiario() ;
        
    }
    
    /**
     * 
     * CODIGOS DE PROCESAMENTO DE DATAS
     * 
     * @version 2.0
     * 
     */
    public interface CodigosProcDatas extends IDataStruct {
        
        @Data(size=1, value="B")
        IString processamentoBase() ;
        
        @Data(size=2, value="10")
        IString proxDiaUtil() ;
        
        @Data(size=2, value="21")
        IString calcDtPrz() ;
        
        @Data(size=2, value="25")
        IString somaDiaUtil() ;
        
        @Data(size=2, value="27")
        IString subtraiDiaUtil() ;
        
    }
    
    /**
     * 
     * INDICADOR DE DEBITO FIRME
     * 
     * @version 2.0
     * 
     */
    public interface IDebFrme extends IDataStruct {
        
        @Data(size=1, value="S")
        IString debFirmeSim() ;
        
        @Data(size=1, value="N")
        IString debFirmeNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DE ACESSO A HISTORICO
     * 
     * @version 2.0
     * 
     */
    public interface IAcsHist extends IDataStruct {
        
        @Data(size=1, value="S")
        IString acsHistSim() ;
        
        @Data(size=1, value="N")
        IString acsHistNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DA SITUACAO DO REGISTO DESTINATARIO
     * 
     * @version 2.0
     * 
     */
    public interface IEstRegDstn extends IDataStruct {
        
        @Data(size=1, value="A")
        IString estRegDtnActivo() ;
        
        @Data(size=1, value="C")
        IString estRegDtnCancelado() ;
        
    }
    
    /**
     * 
     * INDICADOR DA SITUACAO DA PRE-NOTIFICACAO VHR01201
     * 
     * @version 2.0
     * 
     */
    public interface IEstPnot extends IDataStruct {
        
        @Data(size=1, value="A")
        IString pnotATratar() ;
        
        @Data(size=1, value="E")
        IString pnotAEnviar() ;
        
        @Data(size=1, value="P")
        IString pnotProcessada() ;
        
        @Data(size=1, value="R")
        IString pnotRejeitadaSibs() ;
        
    }
    
    /**
     * 
     * INDICADOR DE CONTA DE DESTINO (INTERNA/EXTERNA)
     * 
     * @version 2.0
     * 
     */
    public interface IContDstnInto extends IDataStruct {
        
        @Data(size=1, value="O")
        IString contDstnExterna() ;
        
        @Data(size=1, value="C")
        IString contDstnInterna() ;
        
    }
    
    /**
     * 
     * INDICADOR DE ACCAO DE FECHO
     * 
     * @version 2.0
     * 
     */
    public interface IAccaoFecho extends IDataStruct {
        
        @Data(size=1, value="F")
        IString accaoFecho() ;
        
    }
    
    /**
     * 
     * INDICADOR DO ESTADO DO PEDIDO DE ESTATISTICA
     * 
     * @version 2.0
     * 
     */
    public interface CEstPedEstt extends IDataStruct {
        
        @Data(size=1, value="A")
        IString aProcessar() ;
        
        @Data(size=1, value="P")
        IString processado() ;
        
    }
    
    /**
     * 
     * INDICADOR DO ESTADO DO MOVIMENTO DO PEDIDO DE ESTATISTICA
     * ESTADO DO MOVIMENTO (THR00032)
     * 
     * @version 2.0
     * 
     */
    public interface CEstMovPedEstt extends IDataStruct {
        
        @Data(size=1, value="L")
        IString lancado() ;
        
        @Data(size=1, value="R")
        IString rejeitado() ;
        
        @Data(size=1, value="S")
        IString dvlDuplicacao() ;
        
        @Data(size=1, value="T")
        IString dvlIndevido() ;
        
        @Data(size=1, value="U")
        IString respDvlSemValor() ;
        
        @Data(size=1, value="V")
        IString respDvlComValor() ;
        
    }
    
    /**
     * 
     * TIPO DE MOVIMENTO DE PEDIDOS DE ESTATISTICAS
     * TIPO MOVIMENTO (THR00032)
     * 
     * @version 2.0
     * 
     */
    public interface ITipMovPedEstt extends IDataStruct {
        
        @Data(size=1, value="E")
        IString pedEsttEnviado() ;
        
        @Data(size=1, value="R")
        IString pedEsttRecebido() ;
        
    }
    
    /**
     * 
     * INDICADOR DE CANCELAMENTO DE TODAS AS ORDENS
     * 
     * @version 2.0
     * 
     */
    public interface ICancTodas extends IDataStruct {
        
        @Data(size=1, value="S")
        IString cancTodasSim() ;
        
        @Data(size=1, value="N")
        IString cancTodasNao() ;
        
    }
    public interface ServicoCentral extends IDataStruct {
        
        @Data(size=3, value="PT ")
        IString cPaisIsoCentral() ;
        
        @Data(size=4, value="35")
        IInt cBancCentral() ;
        
        @Data(size=3, value="CGD")
        IString cMnemEgcCentral() ;
        
        @Data(size=4, value="0987")
        IString cOeEgcCentral() ;
        
    }
    
    /**
     * 
     * BALCAO SEDE
     * 
     * @version 2.0
     * 
     */
    public interface BalcaoSede extends IDataStruct {
        
        @Data(size=3, value="PT ")
        IString cPaisIsoSede() ;
        
        @Data(size=4, value="35")
        IInt cBancSede() ;
        
        @Data(size=3, value="CGD")
        IString cMnemEgcSede() ;
        
        @Data(size=4, value="0001")
        IString cOeEgcSede() ;
        
    }
    
    /**
     * 
     * CNP - CANAIS NAO PRESENCIAIS
     * BALCAO DA CAIXA DIRECTA TELEFONE
     * 
     * @version 2.0
     * 
     */
    public interface BalcaoCgdTelefone extends IDataStruct {
        
        @Data(size=3, value="PT ")
        IString cPaisIsoCgdTelfn() ;
        
        @Data(size=4, value="35")
        IInt cBancTelfn() ;
        
        @Data(size=3, value="CGD")
        IString cMnemEgcTelfn() ;
        
        @Data(size=4, value="940")
        IInt cOeEgcTelfn() ;
        
    }
    
    /**
     * 
     * BALCAO DA CAIXA DIRECTA ONLINE
     * 
     * @version 2.0
     * 
     */
    public interface BalcaoCgdOnline extends IDataStruct {
        
        @Data(size=3, value="PT ")
        IString cPaisIsoCgdOnline() ;
        
        @Data(size=4, value="35")
        IInt cBancOnline() ;
        
        @Data(size=3, value="CGD")
        IString cMnemEgcOnline() ;
        
        @Data(size=4, value="945")
        IInt cOeEgcOnline() ;
        
    }
    
    /**
     * 
     * BALCAO DA CAIXA DIRECTA EBANKING
     * 
     * @version 2.0
     * 
     */
    public interface BalcaoCgdEbanking extends IDataStruct {
        
        @Data(size=3, value="PT ")
        IString cPaisIsoCgdEbank() ;
        
        @Data(size=4, value="35")
        IInt cBancEbank() ;
        
        @Data(size=3, value="CGD")
        IString cMnemEgcEbank() ;
        
        @Data(size=4, value="948")
        IInt cOeEgcEbank() ;
        
    }
    
    /**
     * 
     * BALCAO DA CAIXA EDIBANCA
     * 
     * @version 2.0
     * 
     */
    public interface BalcaoCgdEdibanca extends IDataStruct {
        
        @Data(size=3, value="PT ")
        IString cPaisIsoCgdEdiban() ;
        
        @Data(size=4, value="35")
        IInt cBancEdiban() ;
        
        @Data(size=3, value="CGD")
        IString cMnemEgcEdiban() ;
        
        @Data(size=4, value="946")
        IInt cOeEgcEdiban() ;
        
    }
    
    /**
     * 
     * CONSTANTES CONTA DAC
     * 
     * @version 2.0
     * 
     */
    public interface ContaDac extends IDataStruct {
        
        @Data(size=3, value="PT ")
        IString cPaisIsoContDac() ;
        
        @Data(size=4, value="35")
        IInt cBancContDac() ;
        
        @Data(size=4, value="1")
        IInt cOeEgcContDac() ;
        
        @Data(size=7, value="585")
        IInt nsRdclContDac() ;
        
        @Data(size=1, value="0")
        IInt vChkdContDac() ;
        
        @Data(size=2, value="30")
        IInt cTipoContDac() ;
        
    }
    
    /**
     * 
     * INDICADOR SITUACAO DA TRANSFERENCIA
     * 
     * @version 2.0
     * 
     */
    public interface EstIstzOrdTrf extends IDataStruct {
        
        @Data(size=1, value="A")
        IString activaTrf() ;
        
        @Data(size=1, value="C")
        IString rejeitadaCond() ;
        
        @Data(size=1, value="P")
        IString prcdaTrf() ;
        
        @Data(size=1, value="D")
        IString devolvida() ;
        
        @Data(size=1, value="J")
        IString rjtadaTrf() ;
        
        @Data(size=1, value="S")
        IString rjtadaSldIns() ;
        
        @Data(size=1, value="U")
        IString rjtadaUtl() ;
        
        @Data(size=1, value="R")
        IString rjtadaSibs() ;
        
        @Data(size=1, value="X")
        IString rjtadaExcl() ;
        
    }
    
    /**
     * 
     * CONSTANTES USADAS NO ACESSO A ROTINA DE TAB GERAIS
     * 
     * @version 2.0
     * 
     */
    public interface CTabGerais extends IDataStruct {
        
        @Data(size=3, value="A07")
        IString cTabBbnA07() ;
        
        @Data(size=3, value="072")
        IString cTabBbn072() ;
        
        @Data(size=3, value="260")
        IString cTabBbn260() ;
        
        @Data(size=3, value="330")
        IString cTabBbn330() ;
        
        @Data(size=3, value="517")
        IString cTabBbn517() ;
        
        @Data(size=3, value="756")
        IString cTabBbn756() ;
        
        @Data(size=3, value="764")
        IString cTabBbn764() ;
        
        @Data(size=3, value="910")
        IString cTabBbn910() ;
        
        @Data(size=3, value="920")
        IString cTabBbn920() ;
        
        @Data(size=3, value="983")
        IString cTabBbn983() ;
        
        @Data(size=3, value="H32")
        IString cTabBbnH32() ;
        
        @Data(size=3, value="H33")
        IString cTabBbnH33() ;
        
        @Data(size=3, value="I02")
        IString cTabBbnI02() ;
        
        @Data(size=3, value="I03")
        IString cTabBbnI03() ;
        
        @Data(size=3, value="I04")
        IString cTabBbnI04() ;
        
        @Data(size=3, value="I05")
        IString cTabBbnI05() ;
        
        @Data(size=3, value="I08")
        IString cTabBbnI08() ;
        
        @Data(size=3, value="I12")
        IString cTabBbnI12() ;
        
        @Data(size=3, value="I13")
        IString cTabBbnI13() ;
        
        @Data(size=3, value="I14")
        IString cTabBbnI14() ;
        
        @Data(size=3, value="I15")
        IString cTabBbnI15() ;
        
        @Data(size=3, value="I16")
        IString cTabBbnI16() ;
        
        @Data(size=3, value="I17")
        IString cTabBbnI17() ;
        
        @Data(size=3, value="I23")
        IString cTabBbnI23() ;
        
        @Data(size=3, value="I27")
        IString cTabBbnI27() ;
        
        @Data(size=3, value="I30")
        IString cTabBbnI30() ;
        
        @Data(size=3, value="I33")
        IString cTabBbnI33() ;
        
        @Data(size=3, value="I41")
        IString cTabBbnI41() ;
        
        @Data(size=3, value="I34")
        IString cTabBbnI34() ;
        
        @Data(size=3, value="I37")
        IString cTabBbnI37() ;
        
        @Data(size=3, value="I42")
        IString cTabBbnI42() ;
        
        @Data(size=3, value="I44")
        IString cTabBbnI44() ;
        
        @Data(size=3, value="I01")
        IString cTabBbnI01() ;
        
        @Data(size=3, value="I22")
        IString cTabBbnI22() ;
        
        @Data(size=3, value="I11")
        IString cTabBbnI11() ;
        
        @Data(size=3, value="I29")
        IString cTabBbnI29() ;
        
        @Data(size=3, value="I36")
        IString cTabBbnI36() ;
        
        @Data(size=3, value="I19")
        IString cTabBbnI19() ;
        
        @Data(size=3, value="I26")
        IString cTabBbnI26() ;
        
        @Data(size=3, value="I43")
        IString cTabBbnI43() ;
        
    }
    
    /**
     * 
     * INDICADOR DO TIPO DE REPRESENTACAO
     * 
     * @version 2.0
     * 
     */
    public interface CTipoRprz extends IDataStruct {
        
        @Data(size=1, value="A")
        IString activa() ;
        
        @Data(size=1, value="P")
        IString passiva() ;
        
    }
    
    /**
     * 
     * INDICADOR DO TIPO MOVIMENTO (I20)
     * 
     * @version 2.0
     * 
     */
    public interface TipoMov extends IDataStruct {
        
        @Data(size=3, value="DOO")
        IString doo() ;
        
        @Data(size=3, value="COI")
        IString coi() ;
        
        @Data(size=3, value="COE")
        IString coe() ;
        
        @Data(size=3, value="COD")
        IString cod() ;
        
        @Data(size=3, value="CDT")
        IString cdt() ;
        
        @Data(size=3, value="DPD")
        IString dpd() ;
        
        @Data(size=3, value="CDR")
        IString cdr() ;
        
        /**
         * DEBITO ORDENANTE DO ENCARGO
         */
        @Data(size=3, value="DON")
        IString don() ;
        
        /**
         * DEBITO DESTINATARIO DO ENCARGO
         */
        @Data(size=3, value="DDN")
        IString ddn() ;
        
    }
    
    /**
     * 
     * *CODIGO SERVICO SIBS
     * 
     * @version 2.0
     * 
     */
    public interface ServSibs extends IDataStruct {
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt sibsTrfc() ;
        
    }
    
    /**
     * 
     * *CODIGO OPERACAO SIBS
     * 
     * @version 2.0
     * 
     */
    public interface OpeSibs extends IDataStruct {
        
        @Data(size=2, signed=true, value="3", compression=COMP3)
        IInt opeReembolso() ;
        
        @Data(size=2, signed=true, value="7", compression=COMP3)
        IInt opeRenda() ;
        
        @Data(size=2, signed=true, value="8", compression=COMP3)
        IInt opeOrdenado() ;
        
        @Data(size=2, signed=true, value="9", compression=COMP3)
        IInt opeForn() ;
        
        @Data(size=2, signed=true, value="10", compression=COMP3)
        IInt opePrstSegSoc() ;
        
        @Data(size=2, signed=true, value="11", compression=COMP3)
        IInt opePensoes() ;
        
        @Data(size=2, signed=true, value="12", compression=COMP3)
        IInt opeTrfc() ;
        
        @Data(size=2, signed=true, value="12", compression=COMP3)
        IInt opePednibcgd() ;
        
        @Data(size=2, signed=true, value="13", compression=COMP3)
        IInt opeReembEstado() ;
        
        @Data(size=2, signed=true, value="15", compression=COMP3)
        IInt opeTeiTrtManl() ;
        
    }
    public interface FamiProd extends IDataStruct {
        
        @Data(size=3, value="405")
        IString famiProdPednibcgd() ;
        
        /**
         * FAMILIA DE PRODUTO DAS DEVOLUCOES CODSER = 03
         */
        @Data(size=3, value="405")
        IString famiProdDevtrfc() ;
        
        /**
         * FAMILIA DE PRODUTO DAS RECEPCOES DE TEIS CODSER=2, 92
         */
        @Data(size=3, value="405")
        IString famiProdRectrfc() ;
        
        /**
         * FAMILIA DE PRODUTO DOS PEDIDOS DEVOLUCAO OIC CODSER=27
         */
        @Data(size=3, value="405")
        IString famiProdPeddev() ;
        
        /**
         * FAMILIA DE PRODUTO DAS AGENDAS DE TRANSFERENCIA
         */
        @Data(size=3, value="405")
        IString famiProdAgenda() ;
        
        /**
         * FAMILIA DE PRODUTO DAS ORDENS DE TRANSFERENCIA
         */
        @Data(size=3, value="405")
        IString famiProdTrfc() ;
        
        /**
         * FAMILIA DE PRODUTO DA MOVIMENTACAO DE BANCOS REPRESENTADOS
         */
        @Data(size=3, value="405")
        IString famiProdMovRprd() ;
        
        /**
         * FAMILIA DE PRODUTO DE PEDIDOS DE SEGUNDA VIA
         */
        @Data(size=3, value="405")
        IString famiProdPed2via() ;
        
    }
    public interface Produto extends IDataStruct {
        
        @Data(size=3, value="001")
        IString produtoPednibcgd() ;
        
        /**
         * PRODUTO DAS DEVOLUCOES CODSER = 03
         */
        @Data(size=3, value="001")
        IString produtoDevtrfc() ;
        
        /**
         * PRODUTO DAS RECEPCOES DE TEIS CODSER=2, 92
         * TEIS NAO URGENTES
         */
        @Data(size=3, value="001")
        IString produtoRectrfc1() ;
        
        /**
         * TEIS URGENTES
         */
        @Data(size=3, value="001")
        IString produtoRectrfc2() ;
        
        /**
         * PRODUTO DOS PEDIDOS DEVOLUCAO OIC CODSER=27
         */
        @Data(size=3, value="001")
        IString produtoPeddev() ;
        
        /**
         * PRODUTO DAS AGENDAS DE TRANSFERENCIAS
         */
        @Data(size=3, value="001")
        IString produtoAgenda() ;
        
        @Data(size=3, value="001")
        IString produtoAvsLanDst() ;
        
        @Data(size=3, value="001")
        IString produtoAvsLanOrn() ;
        
        @Data(size=3, value="001")
        IString produtoTeisRct() ;
        
        /**
         * PRODUTO DA MOVIMENTACAO DE BANCOS REPRESENTADOS
         */
        @Data(size=3, value="001")
        IString produtoMovRprd() ;
        
        /**
         * PRODUTO DAS CONTAS ORDENANTES
         */
        @Data(size=3, value="001")
        IString produtoConOrd() ;
        
        /**
         * PRODUTO DE PEDIDOS DE SEGUNDA VIA
         */
        @Data(size=3, value="001")
        IString produtoPed2via() ;
        
    }
    public interface CEvenOpel extends IDataStruct {
        
        /**
         * TEIS 1 FECHO
         */
        @Data(size=4, value="1903")
        IString evenTeis1Fecho() ;
        
        /**
         * CREDITO AOS DESTINATARIOS INTERNOS DE TEIS 1 FECHO
         */
        @Data(size=4, value="1904")
        IString evenCreDstTeis1f() ;
        
        /**
         * TEIS 2 FECHO
         */
        @Data(size=4, value="1905")
        IString evenTeis2Fecho() ;
        
        /**
         * TEIS 1 FECHO E TRANSFERENCIAS INTERNAS
         */
        @Data(size=4, value="1907")
        IString evenAgendamentosTrf() ;
        
        /**
         * CREDITO AOS DESTINATARIOS DAS AGENDAS DE TRANSFERENCIAS
         */
        @Data(size=4, value="1908")
        IString evenCreDstAgdaTrf() ;
        
        /**
         * RECEPCAO DE TEIS 1 FECHO COM ORIGEM EM OIC
         */
        @Data(size=4, value="1909")
        IString evenTeis1fOicRtr() ;
        
        /**
         * RECEPCAO DE TEIS 2 FECHO COM ORIGEM EM OIC
         */
        @Data(size=4, value="1910")
        IString evenRecpTeis2fOic() ;
        
        /**
         * DEVOLUCAO DE TEIS RECEBIDAS 1 FECHO
         */
        @Data(size=4, value="1911")
        IString evenDevTeisReb1f() ;
        
        /**
         * DEVOLUCAO DE TEIS RECEBIDAS 2 FECHO
         */
        @Data(size=4, value="1912")
        IString evenDevTeisReb2f() ;
        
        /**
         * REJEICAO NA SIBS DE DEVOLUCAO DE TEIS RECEBIDAS 1F
         */
        @Data(size=4, value="1913")
        IString evenRejSibsTeis1f() ;
        
        /**
         * REJEICAO NA SIBS DE DEVOLUCAO DE TEIS RECEBIDAS 2F
         */
        @Data(size=4, value="1914")
        IString evenRejSibsTeis2f() ;
        
        /**
         * REJEICAO DE TEIS NA SIBS (1 FECHO) ERR do ETR
         */
        @Data(size=4, value="1915")
        IString evenRejTeisSibs1f() ;
        
        /**
         * REJEICAO DE TEIS NA SIBS (2 FECHO) ERR do ETR
         */
        @Data(size=4, value="1916")
        IString evenRejTeisSibs2f() ;
        
        /**
         * REJEICAO de TEIS por OIC (1 FECHO)
         */
        @Data(size=4, value="1917")
        IString evenRejTeisOic1f() ;
        
        /**
         * REJEICAO de TEIS INTERNAS
         */
        @Data(size=4, value="1918")
        IString evenRejSibsInterna() ;
        
        /**
         * PEDIDOS DE DEVOLUCAO CGD PARA DESTINATARIOS INTERNOS
         */
        @Data(size=4, value="1919")
        IString evenPedDevDstInt() ;
        
        /**
         * PEDIDOS DE DEVOLUCAO CGD PARA DESTINATARIOS EXTERNOS
         */
        @Data(size=4, value="1920")
        IString evenPedDevDstExt() ;
        
        /**
         * RESPOSTA A PEDIDOS DE DEVOLUCAO OIC
         */
        @Data(size=4, value="1921")
        IString evenRespPedDevOic() ;
        
        /**
         * REJEICAO DO PEDIDO DE DEVOLUCAO OIC NA SIBS
         */
        @Data(size=4, value="1922")
        IString evenRejPedOicSbs() ;
        
        /**
         * COBRANCA DE ENCARGOS PARA PEDIDOS NIB OIC
         */
        @Data(size=4, value="1923")
        IString evenEncgPedNibCgd() ;
        
        /**
         * RECEPCAO DE TEIS 1F COM ORIGEM EM OIC
         */
        @Data(size=4, value="1925")
        IString evenCancTeis2f() ;
        
        /**
         * CANCELAMENTO DE TEIS DE 1F
         */
        @Data(size=4, value="1926")
        IString evenCancTeis1f() ;
        
        /**
         * CONTABILIZACAO DO RESUMO DA COMPENSACAO DA CGD 1F
         */
        @Data(size=4, value="1927")
        IString evenCtbCompCgd1f() ;
        
        /**
         * CONTAB. DO RESUMO DA COMPENSACAO DE BANCOS REP. 1F
         */
        @Data(size=4, value="1928")
        IString evenCtbCompRprd1f() ;
        
        /**
         * CONTABILIZACAO DO RESUMO DA COMPENSACAO DA CGD 2F
         */
        @Data(size=4, value="1929")
        IString evenCtbCompCgd2f() ;
        
        /**
         * CONTAB. DO RESUMO DA COMPENSACAO DE BANCOS REP. 2F
         */
        @Data(size=4, value="1930")
        IString evenCtbCompRprd2f() ;
        
        /**
         * MOVIMENTACAO BANCOS REPRESENTADOS - 1 E 2 FECHO
         */
        @Data(size=4, value="1931")
        IString evenMovBancoRep1f() ;
        
        @Data(size=4, value="1932")
        IString evenMovBancoRep2f() ;
        
        /**
         * MOVIMENTOS A CREDITO E DEBITO A EMPRESAS REPRESENTADAS
         */
        @Data(size=4, value="1933")
        IString evenMovCreEmpRep() ;
        
        @Data(size=4, value="1934")
        IString evenMovDebEmpRep() ;
        
        /**
         * CONTABILIZACAO DAS TEIS ENVIADAS NO ETR
         */
        @Data(size=4, value="1935")
        IString evenCtaEnvEtrTeis() ;
        
        /**
         * TRATAMENTO MANUAL TEIS 1 FECHO
         */
        @Data(size=4, value="1936")
        IString evenTrtManTeis1f() ;
        
        /**
         * TRATAMENTO MANUAL TEIS 2 FECHO
         */
        @Data(size=4, value="1937")
        IString evenTrtManTeis2f() ;
        
        /**
         * EVENTOS PARA ACESSO A ROTINA MHAJ160A
         */
        @Data(size=4, value="HR99")
        IString evenAvsLanOrn() ;
        
        @Data(size=4, value="HR99")
        IString evenAvsLanDst() ;
        
    }
    public interface SeveOpel extends IDataStruct {
        
        @Data(size=4, value=" ")
        IString seveOpelPednibcgd() ;
        
        @Data(size=4, value=" ")
        IString seveOpelDevtrfc() ;
        
        @Data(size=4, value=" ")
        IString seveOpelRectrfc() ;
        
        @Data(size=4, value=" ")
        IString seveOpelPeddev() ;
        
        @Data(size=4, value=" ")
        IString seveOpelAgenda() ;
        
        @Data(size=4, value=" ")
        IString seveTei1Fecho() ;
        
        @Data(size=4, value=" ")
        IString seveTei2Fecho() ;
        
        @Data(size=4, value=" ")
        IString seveAvsLanDst() ;
        
        @Data(size=4, value=" ")
        IString seveAvsLanOrn() ;
        
        @Data(size=4, value=" ")
        IString sevenPedDevDtnCgd() ;
        
        @Data(size=4, value=" ")
        IString sevenPedDevDtnOic() ;
        
        @Data(size=4, value=" ")
        IString sevenPed2via() ;
        
        /**
         * *SUB EVENTOS DE ORDENS DE PRIMEIRO FECHO
         */
        @Data(size=4, value="0001")
        IString perIntDestIgOrd() ;
        
        @Data(size=4, value="0002")
        IString perIntDestDfOrd() ;
        
        @Data(size=4, value="0003")
        IString pntIntDestIgOrd() ;
        
        @Data(size=4, value="0004")
        IString pntIntDestDfOrd() ;
        
        @Data(size=4, value="0005")
        IString periodicaExterna() ;
        
        @Data(size=4, value="0006")
        IString pontualExterna() ;
        
        @Data(size=4, value="0007")
        IString emissAvisLanc1f() ;
        
        /**
         * *SUB EVENTOS DE ORDENS DE SEGUNDO FECHO
         */
        @Data(size=4, value="0001")
        IString pontual2f() ;
        
        @Data(size=4, value="0002")
        IString emissAvisLanc2f() ;
        
    }
    
    /**
     * 
     * ESTADOS DOS PEDIDOS DE NIB
     * 
     * @version 2.0
     * 
     */
    public interface IEstPedNib extends IDataStruct {
        
        @Data(size=1, value="R")
        IString estPednibRejeitado() ;
        
        @Data(size=1, value="A")
        IString estPednibEnviar() ;
        
        @Data(size=1, value="E")
        IString estPednibEnviado() ;
        
        @Data(size=1, value="C")
        IString estPednibCancelado() ;
        
        @Data(size=1, value="P")
        IString estPednibProcessado() ;
        
        @Data(size=1, value="S")
        IString estPednibRespondido() ;
        
    }
    
    /**
     * 
     * ESTADOS DOS PEDIDOS DE DEVOLUCAO ORIGEM CGD
     * 
     * @version 2.0
     * 
     */
    public interface CEstPedDvlzOtf extends IDataStruct {
        
        @Data(size=1, value="A")
        IString pedevAEnviar() ;
        
        @Data(size=1, value="E")
        IString pedevEnviado() ;
        
        @Data(size=1, value="C")
        IString pedevCancelado() ;
        
        @Data(size=1, value="D")
        IString pedevDevolvido() ;
        
        @Data(size=1, value="R")
        IString pedevRejSibs() ;
        
        @Data(size=1, value="P")
        IString pedevProcessado() ;
        
        @Data(size=1, value="M")
        IString pedevMovRejeitada() ;
        
        @Data(size=1, value="J")
        IString pedevRejeitado() ;
        
    }
    
    /**
     * 
     * CODIGO PRE-NOTIFICACOES SIBS
     * 
     * @version 2.0
     * 
     */
    public interface PreNotSibs extends IDataStruct {
        
        @Data(size=2, signed=true, value="11", compression=COMP3)
        IInt suspPreNot() ;
        
        @Data(size=2, signed=true, value="12", compression=COMP3)
        IInt rejPreNot() ;
        
        @Data(size=2, signed=true, value="13", compression=COMP3)
        IInt acetPreNot() ;
        
    }
    
    /**
     * 
     * ESTADO DO MOVIMENTO (THR00009, THR00010, THR00023)
     * 
     * @version 2.0
     * 
     */
    public interface IEstMovFichRtr extends IDataStruct {
        
        @Data(size=1, value="A")
        IString aTratar() ;
        
        @Data(size=1, value="E")
        IString enviar() ;
        
        @Data(size=1, value="D")
        IString aDevolver() ;
        
        @Data(size=1, value="S")
        IString processada() ;
        
        @Data(size=1, value="J")
        IString trfRejeitada() ;
        
        @Data(size=1, value="P")
        IString trfAProcessar() ;
        
        @Data(size=1, value="R")
        IString rejeitadaSibs() ;
        
    }
    
    /**
     * 
     * ESTADO DO MOVIMENTO (THR00015) - DESCODIFICA TABELA I07
     * 
     * @version 2.0
     * 
     */
    public interface EstMovFichRtrpnib extends IDataStruct {
        
        @Data(size=1, value="A")
        IString pnibATratar() ;
        
        @Data(size=1, value="E")
        IString pnibAEnviar() ;
        
        @Data(size=1, value="P")
        IString pnibProcessado() ;
        
        @Data(size=1, value="R")
        IString pnibRejeitadoSibs() ;
        
    }
    
    /**
     * 
     * CODIGO DO TIPO DE MOVIMENTO
     * 
     * @version 2.0
     * 
     */
    public interface CTipoMov extends IDataStruct {
        
        @Data(size=1, value="R")
        IString recebidos() ;
        
        @Data(size=1, value="E")
        IString enviados() ;
        
    }
    
    /**
     * 
     * CODIGO DE SISTEMA (SICOI TEI OU CONTAS INTERNAS)
     * 
     * @version 2.0
     * 
     */
    public interface CodSistema extends IDataStruct {
        
        @Data(size=3, value="SD0")
        IString codSistemaSd0() ;
        
        @Data(size=3, value="SD1")
        IString codSistemaSd1() ;
        
    }
    
    /**
     * 
     * TIPO DE INICIADOR DE OPERACAO.
     * 
     * @version 2.0
     * 
     */
    public interface TipoInicOper extends IDataStruct {
        
        @Data(size=1, value="P")
        IString tipoInicPapel() ;
        
        @Data(size=1, value="A")
        IString tipoInicAuto() ;
        
    }
    
    /**
     * 
     * INDICADOR DO TIPO DE CONTA - CGD / OIC
     * 
     * @version 2.0
     * 
     */
    public interface IContDstnInto02 extends IDataStruct {
        
        @Data(size=1, value="C")
        IString cgd() ;
        
        @Data(size=1, value="O")
        IString oic() ;
        
    }
    
    /**
     * 
     * INDICADOR DE ISENCAO DE ENCARGOS
     * 
     * @version 2.0
     * 
     */
    public interface IIsezEncg extends IDataStruct {
        
        @Data(size=1, value="S")
        IString isezEncgSim() ;
        
        @Data(size=1, value="N")
        IString isezEncgNao() ;
        
    }
    
    /**
     * 
     * VALORES QUA PODE ASSUMIR HDT PARA OS FIC. BATCH
     * 
     * @version 2.0
     * 
     */
    public interface Hdt extends IDataStruct {
        
        @Data(size=1, signed=true, value="0", compression=COMP3)
        IInt hdt0() ;
        
        @Data(size=1, signed=true, value="1", compression=COMP3)
        IInt hdt1() ;
        
        @Data(size=1, signed=true, value="2", compression=COMP3)
        IInt hdt2() ;
        
        @Data(size=1, signed=true, value="3", compression=COMP3)
        IInt hdt3() ;
        
        @Data(size=1, signed=true, value="8", compression=COMP3)
        IInt hdt8() ;
        
        @Data(size=1, signed=true, value="9", compression=COMP3)
        IInt hdt9() ;
        
    }
    
    /**
     * 
     * CODIGO DO CAMPO CODOSER
     * 
     * @version 2.0
     * 
     */
    public interface CServSibsTei extends IDataStruct {
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt servSibsTei01() ;
        
        @Data(size=2, signed=true, value="2", compression=COMP3)
        IInt servSibsTei02() ;
        
        @Data(size=2, signed=true, value="3", compression=COMP3)
        IInt servSibsTei03() ;
        
        @Data(size=2, signed=true, value="5", compression=COMP3)
        IInt servSibsTei05() ;
        
        @Data(size=2, signed=true, value="7", compression=COMP3)
        IInt servSibsTei07() ;
        
        @Data(size=2, signed=true, value="8", compression=COMP3)
        IInt servSibsTei08() ;
        
        @Data(size=2, signed=true, value="9", compression=COMP3)
        IInt servSibsTei09() ;
        
        @Data(size=2, signed=true, value="10", compression=COMP3)
        IInt servSibsTei10() ;
        
        @Data(size=2, signed=true, value="11", compression=COMP3)
        IInt servSibsTei11() ;
        
        @Data(size=2, signed=true, value="12", compression=COMP3)
        IInt servSibsTei12() ;
        
        @Data(size=2, signed=true, value="21", compression=COMP3)
        IInt servSibsTei21() ;
        
        @Data(size=2, signed=true, value="22", compression=COMP3)
        IInt servSibsTei22() ;
        
        @Data(size=2, signed=true, value="23", compression=COMP3)
        IInt servSibsTei23() ;
        
        @Data(size=2, signed=true, value="24", compression=COMP3)
        IInt servSibsTei24() ;
        
        @Data(size=2, signed=true, value="25", compression=COMP3)
        IInt servSibsTei25() ;
        
        @Data(size=2, signed=true, value="26", compression=COMP3)
        IInt servSibsTei26() ;
        
        @Data(size=2, signed=true, value="27", compression=COMP3)
        IInt servSibsTei27() ;
        
        @Data(size=2, signed=true, value="28", compression=COMP3)
        IInt servSibsTei28() ;
        
        @Data(size=2, signed=true, value="29", compression=COMP3)
        IInt servSibsTei29() ;
        
        @Data(size=2, signed=true, value="32", compression=COMP3)
        IInt servSibsTei32() ;
        
        @Data(size=2, signed=true, value="33", compression=COMP3)
        IInt servSibsTei33() ;
        
        @Data(size=2, signed=true, value="34", compression=COMP3)
        IInt servSibsTei34() ;
        
        @Data(size=2, signed=true, value="35", compression=COMP3)
        IInt servSibsTei35() ;
        
        @Data(size=2, signed=true, value="36", compression=COMP3)
        IInt servSibsTei36() ;
        
        @Data(size=2, signed=true, value="50", compression=COMP3)
        IInt servSibsTei50() ;
        
        @Data(size=2, signed=true, value="51", compression=COMP3)
        IInt servSibsTei51() ;
        
        @Data(size=2, signed=true, value="92", compression=COMP3)
        IInt servSibsTei92() ;
        
        @Data(size=2, signed=true, value="93", compression=COMP3)
        IInt servSibsTei93() ;
        
        @Data(size=2, signed=true, value="99", compression=COMP3)
        IInt servSibsTei99() ;
        
    }
    
    /**
     * 
     * CODIGO DE ERRO SIBS
     * 
     * @version 2.0
     * 
     */
    public interface CErroSibs extends IDataStruct {
        
        @Data(size=4, value="I017")
        IString ficheiroDupd() ;
        
        @Data(size=4, value="I045")
        IString loteDupd() ;
        
    }
    
    /**
     * 
     * FECHO DE COMPENSACAO
     * 
     * @version 2.0
     * 
     */
    public interface Fecho extends IDataStruct {
        
        @Data(size=1, signed=true, value="0", compression=COMP3)
        IInt fecho0() ;
        
        @Data(size=1, signed=true, value="1", compression=COMP3)
        IInt fecho1() ;
        
        @Data(size=1, signed=true, value="2", compression=COMP3)
        IInt fecho2() ;
        
        @Data(size=1, signed=true, value="3", compression=COMP3)
        IInt fecho3() ;
        
    }
    
    /**
     * 
     * CODIGOS DE REJEICAO
     * 
     * @version 2.0
     * 
     */
    public interface CRejzTrfcSibs extends IDataStruct {
        
        @Data(size=2, value="0")
        IInt lancamentoExec() ;
        
        @Data(size=2, value="1")
        IInt nExisteAutzDeb() ;
        
        @Data(size=2, value="2")
        IInt recusaDebito() ;
        
        @Data(size=2, value="3")
        IInt ctaSemSaldo() ;
        
        @Data(size=2, value="4")
        IInt nibInvalido() ;
        
        @Data(size=2, value="5")
        IInt registoInvalido() ;
        
        @Data(size=2, value="6")
        IInt canInstrucoes() ;
        
        @Data(size=2, value="7")
        IInt efectuadoMeioPag() ;
        
        @Data(size=2, value="8")
        IInt operDuplic() ;
        
        @Data(size=2, value="9")
        IInt operNCliente() ;
        
        @Data(size=2, value="10")
        IInt nmDstNCorrFich() ;
        
        @Data(size=2, value="11")
        IInt suspensaoPreNotif() ;
        
        @Data(size=2, value="12")
        IInt rejeicaoPreNotif() ;
        
        @Data(size=2, value="13")
        IInt aceitacaoPreNotif() ;
        
        @Data(size=2, value="14")
        IInt balcaoInexist() ;
        
        @Data(size=2, value="15")
        IInt contaInexistente() ;
        
        @Data(size=2, value="16")
        IInt ctaNMovimentavel() ;
        
        @Data(size=2, value="17")
        IInt importInvalida() ;
        
        @Data(size=2, value="18")
        IInt dstNIdentific() ;
        
        @Data(size=2, value="19")
        IInt nibDstAlt() ;
        
        @Data(size=2, value="20")
        IInt nibDstAnul() ;
        
        @Data(size=2, value="21")
        IInt movNaoPermitido() ;
        
        @Data(size=2, value="22")
        IInt dstDevOrdn() ;
        
        @Data(size=2, value="23")
        IInt acertoContas() ;
        
        @Data(size=2, value="24")
        IInt emRecuperacao() ;
        
        @Data(size=2, value="25")
        IInt naoRecuperavel() ;
        
        @Data(size=2, value="30")
        IInt nifInexistente() ;
        
        @Data(size=2, value="31")
        IInt duplicacao() ;
        
        @Data(size=2, value="32")
        IInt trfADevolver() ;
        
    }
    
    /**
     * 
     * ROTINAS
     * 
     * @version 2.0
     * 
     */
    public interface Rotinas extends IDataStruct {
        
        @Data(size=8, value="MHRC200A")
        IString rotCalcAlgoritmo() ;
        
        @Data(size=8, value="MHRC300A")
        IString rotCalcAlgoritmo3() ;
        
        @Data(size=8, value="MHRK100A")
        IString mhrk100a() ;
        
    }
    public interface CTipoEncargo extends IDataStruct {
        
        @Data(size=1, value="C")
        IString comissao() ;
        
        @Data(size=1, value="D")
        IString despesa() ;
        
        @Data(size=1, value="I")
        IString imposto() ;
        
    }
    
    /**
     * 
     * INDICADOR DO ESTADO DE LOTE (TAB GERAL I36)
     * 
     * @version 2.0
     * 
     */
    public interface CEstLoteTrfc extends IDataStruct {
        
        @Data(size=1, value="E")
        IString enviado() ;
        
        @Data(size=1, value="R")
        IString rejeitadoSibs() ;
        
        @Data(size=1, value="P")
        IString pedidoAnl() ;
        
        @Data(size=1, value="N")
        IString anuladoEnv() ;
        
        @Data(size=1, value="J")
        IString anuladoRej() ;
        
        @Data(size=1, value="A")
        IString anulado() ;
        
        @Data(size=1, value="D")
        IString devolvido() ;
        
    }
    
    /**
     * 
     * INDICADOR DO ESTADO DE TRANSFERENCIA (TAB GERAL I19)
     * 
     * @version 2.0
     * 
     */
    public interface IEstTrfc extends IDataStruct {
        
        @Data(size=1, value="D")
        IString estTrfcDevolvida() ;
        
        @Data(size=1, value="R")
        IString rejPelaSibs() ;
        
        @Data(size=1, value="L")
        IString rejLancRetag() ;
        
        @Data(size=1, value="A")
        IString estTrfcActiva() ;
        
        @Data(size=1, value="C")
        IString estTrfcCancelada() ;
        
        @Data(size=1, value="P")
        IString estTrfcProcessada() ;
        
        @Data(size=1, value="J")
        IString estTrfcRejeitada() ;
        
        @Data(size=1, value="X")
        IString rejPorExcl() ;
        
        @Data(size=1, value="I")
        IString estIstzEncgIsenta() ;
        
        @Data(size=1, value="U")
        IString rejPeloUtilizador() ;
        
        @Data(size=1, value="E")
        IString estTrfcEnviada() ;
        
    }
    public interface IEstEnviPlaf extends IDataStruct {
        
        @Data(size=1, value="E")
        IString estEnvioEnviado() ;
        
        @Data(size=1, value="J")
        IString estEnvioRej() ;
        
        @Data(size=1, value="A")
        IString estEnvioEnviar() ;
        
        @Data(size=1, value="P")
        IString estEnvioProcessado() ;
        
    }
    public interface IGerzPlafSibs extends IDataStruct {
        
        @Data(size=1, signed=true, value="1", compression=COMP3)
        IInt gerzPlafInserir() ;
        
        @Data(size=1, signed=true, value="2", compression=COMP3)
        IInt gerzPlafModificar() ;
        
        @Data(size=1, signed=true, value="3", compression=COMP3)
        IInt gerzPlafAnular() ;
        
    }
    public interface CProcBbn extends IDataStruct {
        
        @Data(size=3, value="1AL")
        IString x1Anl() ;
        
        @Data(size=3, value="2AL")
        IString x2Anl() ;
        
        @Data(size=3, value="1FC")
        IString x1Fecho() ;
        
        @Data(size=3, value="2FC")
        IString x2Fecho() ;
        
        @Data(size=3, value="LR3")
        IString lancaRetag() ;
        
        @Data(size=3, value="BD1")
        IString batchDiario() ;
        
    }
    
    /**
     * 
     * INDICADOR DE SITUACAO ENCARGO (TABELA GERAL I25)
     * 
     * @version 2.0
     * 
     */
    public interface IEstSitEncg extends IDataStruct {
        
        @Data(size=1, value="A")
        IString estEncgActivo() ;
        
        @Data(size=1, value="P")
        IString estEncgProcessado() ;
        
        @Data(size=1, value="R")
        IString estEncgRejeitado() ;
        
        @Data(size=1, value="I")
        IString estEncgIsento() ;
        
        @Data(size=1, value="C")
        IString estEncgCancelado() ;
        
        @Data(size=1, value="G")
        IString estEncgRegularizar() ;
        
    }
    
    /**
     * 
     * INDICADOR ORDENANTE DESTINATARIO (TABELA 14 - ENCARGOS)
     * 
     * @version 2.0
     * 
     */
    public interface IOrdnDstn extends IDataStruct {
        
        @Data(size=1, value="O")
        IString iOrdn() ;
        
        @Data(size=1, value="D")
        IString iDstn() ;
        
    }
    
    /**
     * 
     * INDICADOR DE ESTORNO (TABELA 14 - ENCARGOS)
     * 
     * @version 2.0
     * 
     */
    public interface IEstorno extends IDataStruct {
        
        @Data(size=1, value="S")
        IString iEstornoSim() ;
        
        @Data(size=1, value="N")
        IString iEstornoNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DE DEBITO OU CREDITO (TABELA 14 - ENCARGOS)
     * 
     * @version 2.0
     * 
     */
    public interface IDbcr extends IDataStruct {
        
        @Data(size=1, value="D")
        IString iDebito() ;
        
        @Data(size=1, value="C")
        IString iCredito() ;
        
    }
    
    /**
     * 
     * ENTIDADES DE ORIGEM DOS FICHEIROS ENVIADOS POR HR
     * 
     * @version 2.0
     * 
     */
    public interface CEntOrigFich extends IDataStruct {
        
        @Data(size=4, value="HM")
        IString entHm() ;
        
        @Data(size=4, value="TQ")
        IString entTq() ;
        
    }
    
    /**
     * 
     * INDICADOR DE LOTE DUPLICADO
     * 
     * @version 2.0
     * 
     */
    public interface ILoteDupd extends IDataStruct {
        
        @Data(size=1, value="S")
        IString loteDupdSim() ;
        
        @Data(size=1, value="N")
        IString loteDupdNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DE FICHEIRO DUPLICADO
     * 
     * @version 2.0
     * 
     */
    public interface IFichDupd extends IDataStruct {
        
        @Data(size=1, value="S")
        IString fichDupdSim() ;
        
        @Data(size=1, value="N")
        IString fichDupdNao() ;
        
    }
    
    /**
     * 
     * INDICADOR DO ESTADO DE PEDIDO DE 2 VIA
     * 
     * @version 2.0
     * 
     */
    public interface IEstPedAvsoTrf extends IDataStruct {
        
        @Data(size=1, value="A")
        IString pedAvsoAProcessar() ;
        
        @Data(size=1, value="P")
        IString pedAvsoProcessado() ;
        
        @Data(size=1, value="C")
        IString pedAvsoCancelado() ;
        
    }
    
    /**
     * 
     * INDICADOR DE COBRANCA PARA O FICHEIRO MENSAL SGR
     * 
     * @version 2.0
     * 
     */
    public interface ICobrancaSgr extends IDataStruct {
        
        @Data(size=1, value="C")
        IString cobradoSgr() ;
        
        @Data(size=1, value="A")
        IString anuladoSgr() ;
        
    }
    
    /**
     * 
     * TIPO FLUXO PARA OBTER A RUBRICA CONTABILISTICA
     * 
     * @version 2.0
     * 
     */
    public interface ITipoFmon extends IDataStruct {
        
        @Data(size=1, value="I")
        IString iTipoFmonIcb() ;
        
        /**
         * SERVICO A FORMATAR PARA LR'S
         * CODIGOS PARA A PRIMEIRA SESSAO DE LANCAMENTOS
         */
        @Data(size=3, signed=true, value="511", compression=COMP3)
        IInt cServTrfCobCre() ;
        
        @Data(size=3, signed=true, value="120", compression=COMP3)
        IInt cServTrfCobDeb() ;
        
        @Data(size=3, signed=true, value="121", compression=COMP3)
        IInt cServDescDeb() ;
        
        /**
         * CODIGOS PARA A SEGUNDA SESSAO DE LANCAMENTOS
         */
        @Data(size=3, signed=true, value="538", compression=COMP3)
        IInt cServCreSess2() ;
        
        @Data(size=3, signed=true, value="149", compression=COMP3)
        IInt cServDebSess2() ;
        
        @Data(size=3, signed=true, value="144", compression=COMP3)
        IInt cServDescSess2() ;
        
        /**
         * CODIGOS PARA A TERCEIRA SESSAO DE LANCAMENTOS
         */
        @Data(size=3, signed=true, value="539", compression=COMP3)
        IInt cServCreSess3() ;
        
        @Data(size=3, signed=true, value="145", compression=COMP3)
        IInt cServDebSess3() ;
        
        @Data(size=3, signed=true, value="146", compression=COMP3)
        IInt cServDescSess3() ;
        
        /**
         * CODIGOS PARA A QUARTA SESSAO DE LANCAMENTOS
         */
        @Data(size=3, signed=true, value="540", compression=COMP3)
        IInt cServCreSess4() ;
        
        @Data(size=3, signed=true, value="147", compression=COMP3)
        IInt cServDebSess4() ;
        
        @Data(size=3, signed=true, value="148", compression=COMP3)
        IInt cServDescSess4() ;
        
        /**
         * OE GESTOR A FORMATAR PARA LR'S
         */
        @Data(size=4, signed=true, value="9520", compression=COMP3)
        IInt cOeGerxLr() ;
        
    }
    
    /**
     * 
     * CODIGOS DE COMUNICACAO PARA AVISOS DE LANCAMENTO
     * 
     * @version 2.0
     * 
     */
    public interface CCmczCli extends IDataStruct {
        
        @Data(size=3, value="STD")
        IString cCmczStd() ;
        
        @Data(size=3, value="300")
        IString avsLanDestOic() ;
        
        /**
         * OE DE CONTROLO PARA MAPA RESUMO DA COMPENSACAO
         */
        @Data(size=4, signed=true, value="9179", compression=COMP3)
        IInt cOeDpiCtrl() ;
        
        /**
         * CODIGO DE TARIFA SIBS
         */
        @Data(size=3, value="N41")
        IString tarf1fecho() ;
        
        @Data(size=3, value="N42")
        IString tarf2fecho() ;
        
        @Data(size=3, value="N43")
        IString tarfAnl() ;
        
        @Data(size=3, value="N44")
        IString tarfRespPreNot() ;
        
        @Data(size=3, value="N45")
        IString tarfUrgencia() ;
        
    }
    public interface CEstMovCrcb extends IDataStruct {
        
        @Data(size=1, value="M")
        IString estMovRejeitado() ;
        
        @Data(size=1, value="A")
        IString estMovAProcessar() ;
        
        @Data(size=1, value="P")
        IString estMovProcessado() ;
        
    }
    public interface CTipoPedEstt extends IDataStruct {
        
        @Data(size=1, value="T")
        IString pedEsttTodos() ;
        
        @Data(size=1, value="O")
        IString pedEsttOrgao() ;
        
    }
    
    /**
     * 
     * TIPO DE MOVIMENTO DA TABELA DE MOVIMENTOS A BANCOS REPRESENTADOS
     * 
     * @version 2.0
     * 
     */
    public interface ITipoMovimento extends IDataStruct {
        
        @Data(size=1, value="J")
        IString movJustificativo() ;
        
        @Data(size=1, value="M")
        IString movAConta() ;
        
    }
    
    /**
     * 
     * TIPO DE COBRANCA DE ENCARGO
     * 
     * @version 2.0
     * 
     */
    public interface ITipoCbrcEncg extends IDataStruct {
        
        @Data(size=1, value="B")
        IString bruto() ;
        
        @Data(size=1, value="L")
        IString liquido() ;
        
        @Data(size=1, value="D")
        IString diferido() ;
        
    }
    
    /**
     * 
     * TIPO DE ESTADOS DOS LANCAMENTOS DE RETAGUARDA - TAB 30
     * 
     * @version 2.0
     * 
     */
    public interface EstLancRetag extends IDataStruct {
        
        @Data(size=1, value="A")
        IString lancRetagActiva() ;
        
        @Data(size=1, value="I")
        IString lancRetagInacti() ;
        
    }
    
    /**
     * 
     * TIPO DE ESTADOS DOS PROCESSO - TAB 30
     * 
     * @version 2.0
     * 
     */
    public interface EstProcesso extends IDataStruct {
        
        @Data(size=1, value="A")
        IString processoActivo() ;
        
        @Data(size=1, value="I")
        IString processoInactivo() ;
        
    }
    
}
