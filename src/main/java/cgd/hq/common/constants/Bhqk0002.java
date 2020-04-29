package cgd.hq.common.constants;

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
public interface Bhqk0002 extends IDataStruct {
    
    /**
     * @return instancia da classe local CAccao
     */
    @Data
    CAccao cAccao() ;
    
    /**
     * @return instancia da classe local CTabelas
     */
    @Data
    CTabelas cTabelas() ;
    
    /**
     * @return instancia da classe local CTabBbn
     */
    @Data
    CTabBbn cTabBbn() ;
    
    /**
     * @return instancia da classe local CProgramas
     */
    @Data
    CProgramas cProgramas() ;
    
    /**
     * @return instancia da classe local CTipoContaBdp
     */
    @Data
    CTipoContaBdp cTipoContaBdp() ;
    
    @Data(size=1, value=" ")
    IString swDeclaranteDirecto() ;
    @Data
    @Condition("S")
    ICondition swDdS() ;
    @Data
    @Condition("N")
    ICondition swDdN() ;
    
    
    /**
     * @return instancia da classe local CTipoContaBdpNum
     */
    @Data
    CTipoContaBdpNum cTipoContaBdpNum() ;
    
    @Data(size=2, value=" ")
    IString swValTipoCta() ;
    @Data
    @Condition({ "02", "99" })
    ICondition swValidaConta() ;
    @Data
    @Condition({ "01", "03", "04", "05", "06", "56", "58", "78" })
    ICondition swNaoValidaConta() ;
    
    
    @Data(size=3, value=" ")
    IString swValCBanco() ;
    @Data
    @Condition({ "054", "065" })
    ICondition swValidaCBanco() ;
    
    
    @Data(size=1, value=" ")
    IString swDetalheCoe() ;
    @Data
    @Condition("N")
    ICondition swSemDetalhe() ;
    @Data
    @Condition("C")
    ICondition swCoesMultiplas() ;
    @Data
    @Condition("D")
    ICondition swDesagregacao() ;
    
    
    /**
     * @return instancia da classe local CDetalheCoe
     */
    @Data
    CDetalheCoe cDetalheCoe() ;
    
    @Data(size=1, value=" ")
    IString swTipoCliente() ;
    @Data
    @Condition("E")
    ICondition swEmpresa() ;
    @Data
    @Condition("P")
    ICondition swParticular() ;
    @Data
    @Condition("M")
    ICondition swMenor() ;
    
    
    @Data(size=1, value=" ")
    IString swSectInst() ;
    @Data
    @Condition("1")
    ICondition swSectInstRes() ;
    @Data
    @Condition("2")
    ICondition swSectInstNaoRes() ;
    
    
    @Data(size=1, value=" ")
    IString swEstadoCoe() ;
    @Data
    @Condition("A")
    ICondition swAceite() ;
    @Data
    @Condition("B")
    ICondition swRecusadaBatch() ;
    @Data
    @Condition("C")
    ICondition swEnvConfirm() ;
    @Data
    @Condition("D")
    ICondition swRecusadaOffline() ;
    @Data
    @Condition("E")
    ICondition swEnvNaoConfirm() ;
    @Data
    @Condition("G")
    ICondition swAgregada() ;
    @Data
    @Condition("O")
    ICondition swRecBatchOrgExt() ;
    @Data
    @Condition("P")
    ICondition swPendClass() ;
    @Data
    @Condition("R")
    ICondition swRecusadaBdp() ;
    @Data
    @Condition("T")
    ICondition swTotal() ;
    
    
    /**
     * @return instancia da classe local CEstadoCoe
     */
    @Data
    CEstadoCoe cEstadoCoe() ;
    
    @Data(size=1, value=" ")
    IString swEmpsNomeIdvl() ;
    @Data
    @Condition("S")
    ICondition swEmpsNiS() ;
    @Data
    @Condition("N")
    ICondition swEmpsNiN() ;
    
    
    /**
     * @return instancia da classe local CNaturezaCoe
     */
    @Data
    CNaturezaCoe cNaturezaCoe() ;
    
    /**
     * @return instancia da classe local CDatas
     */
    @Data
    CDatas cDatas() ;
    
    /**
     * @return instancia da classe local CPaisesIsoAlfn
     */
    @Data
    CPaisesIsoAlfn cPaisesIsoAlfn() ;
    
    /**
     * @return instancia da classe local CIProc
     */
    @Data
    CIProc cIProc() ;
    
    /**
     * @return instancia da classe local CSimNao
     */
    @Data
    CSimNao cSimNao() ;
    
    /**
     * @return instancia da classe local CIEnvRec
     */
    @Data
    CIEnvRec cIEnvRec() ;
    
    /**
     * @return instancia da classe local CIOperMhyq300a
     */
    @Data
    CIOperMhyq300a cIOperMhyq300a() ;
    
    /**
     * @return instancia da classe local CIOperMhtq300a
     */
    @Data
    CIOperMhtq300a cIOperMhtq300a() ;
    
    @Data(size=4, value="0001")
    IString cBancoDePortugal() ;
    
    /**
     * @return instancia da classe local CFichBbn
     */
    @Data
    CFichBbn cFichBbn() ;
    
    /**
     * @return instancia da classe local CIdioIso
     */
    @Data
    CIdioIso cIdioIso() ;
    
    @Data(size=2, value=" ")
    IString swAplicacoes() ;
    @Data
    @Condition({ "HA", "HB", "HC", "HD", "HE", "HF", "HG", "HH", "HI", "HJ", "HK", "HM", "HN", "HO", "HQ", "HS", "HT", "HV", "HW", "HX", "HY", "HZ", "NA", "NB", "NF", "NG", "NH", "NI", "NJ", "NK", "NL", "NN", "NP", "NQ", "OX", "OY", "PK", "PQ", "PU", "PV", "VI", "VF", "VM", "VP" })
    ICondition swBaseBanca() ;
    
    
    @Data(size=2, value="HQ")
    IString cAplicacao() ;
    
    @Data(size=2, value="BB")
    IString cSiglAplDefault() ;
    
    @Data(size=4, value="JSZ0")
    IString cTrsJsz0() ;
    
    @Data(size=4, value="JSZ9")
    IString cTrsJsz9() ;
    
    @Data(size=4, value="JSZ2")
    IString cTrsJsz2() ;
    
    @Data(size=4, value="JSZ3")
    IString cTrsJsz3() ;
    
    @Data(size=3, signed=true, value="0", compression=COMP3)
    IInt swCTipoOpet() ;
    @Data
    @Condition("642")
    ICondition swRemEmigr() ;
    @Data
    @Condition("284")
    ICondition swLiqMovAtm() ;
    @Data
    @Condition("272")
    ICondition swCpraVndaNtEst() ;
    @Data
    @Condition("282")
    ICondition swLiqTc() ;
    
    
    /**
     * @return instancia da classe local CMinMax
     */
    @Data
    CMinMax cMinMax() ;
    
    /**
     * @return instancia da classe local CTipInterv
     */
    @Data
    CTipInterv cTipInterv() ;
    
    /**
     * @return instancia da classe local Varios
     */
    @Data
    Varios varios() ;
    
    /**
     * @return instancia da classe local CAut
     */
    @Data
    CAut cAut() ;
    
    @Data(size=20, value=" ")
    IString dTabelaEmf() ;
    @Data
    @Condition("THQ00001_ROUTING")
    ICondition dThq00001() ;
    @Data
    @Condition("THQ00002_ITFN")
    ICondition dThq00002() ;
    @Data
    @Condition("THQ00003_SECTITTL")
    ICondition dThq00003() ;
    @Data
    @Condition("THQ00004_EXCSECTIT")
    ICondition dThq00004() ;
    @Data
    @Condition("THQ00005_ITFNPAIS")
    ICondition dThq00005() ;
    @Data
    @Condition("THQ00006_RCTBSITT")
    ICondition dThq00006() ;
    @Data
    @Condition("THQ00007_RCTBPAIS")
    ICondition dThq00007() ;
    @Data
    @Condition("THQ00008_ITFNRCTB")
    ICondition dThq00008() ;
    @Data
    @Condition("THQ00009_SECTPAIS")
    ICondition dThq00009() ;
    @Data
    @Condition({ "THQ00001_ROUTING", "THQ00002_ITFN", "THQ00003_SECTITTL", "THQ00004_EXCSECTIT", "THQ00005_ITFNPAIS", "THQ00006_RCTBSITT", "THQ00007_RCTBPAIS", "THQ00008_ITFNRCTB", "THQ00009_SECTPAIS" })
    ICondition dTabValida() ;
    
    
    @Data(size=8, value=" ")
    IString vRotinaEmf() ;
    @Data
    @Condition("MHQJ001A")
    ICondition vMhqj001a() ;
    @Data
    @Condition("MHQJ002A")
    ICondition vMhqj002a() ;
    @Data
    @Condition("MHQJ003A")
    ICondition vMhqj003a() ;
    @Data
    @Condition("MHQJ004A")
    ICondition vMhqj004a() ;
    @Data
    @Condition("MHQJ005A")
    ICondition vMhqj005a() ;
    @Data
    @Condition("MHQJ006A")
    ICondition vMhqj006a() ;
    @Data
    @Condition("MHQJ007A")
    ICondition vMhqj007a() ;
    @Data
    @Condition("MHQJ008A")
    ICondition vMhqj008a() ;
    @Data
    @Condition("MHQJ009A")
    ICondition vMhqj009a() ;
    @Data
    @Condition("MHQJ010A")
    ICondition vMhqj010a() ;
    @Data
    @Condition("MHQJ011A")
    ICondition vMhqj011a() ;
    @Data
    @Condition({ "MHQJ002A", "MHQJ003A", "MHQJ004A", "MHQJ005A", "MHQJ006A", "MHQJ007A", "MHQJ008A", "MHQJ009A", "MHQJ010A", "MHQJ011A" })
    ICondition vRotEmfVal() ;
    
    
    @Data(size=20, value=" ")
    IString aAtributoEmf() ;
    @Data
    @Condition("C-SECT-ITTL")
    ICondition aCSectIttl() ;
    @Data
    @Condition("C-PAIS-ISOA-RESI")
    ICondition aCPaisIsoaResi() ;
    @Data
    @Condition("C-PRAZO-CONTRAT")
    ICondition aCPrazoContrat() ;
    @Data
    @Condition("C-OE-EGC")
    ICondition aCOeEgc() ;
    @Data
    @Condition("C-FIN-CREDITO")
    ICondition aCFinCredito() ;
    @Data
    @Condition("N-TIP-INST")
    ICondition aNTipInst() ;
    @Data
    @Condition("C-SECT-PAIS")
    ICondition aCSectPais() ;
    @Data
    @Condition({ "C-SECT-ITTL", "C-PAIS-ISOA-RESI", "C-PRAZO-CONTRAT", "C-OE-EGC", "C-FIN-CREDITO", "N-TIP-INST", "C-SECT-PAIS" })
    ICondition aAtrbEmfVal() ;
    
    
    @Data(size=29, value=" ")
    IString cRotinaAtributo() ;
    @Data
    @Condition("MHQJ002A_C-SECT-ITTL")
    ICondition cMhqj002aAtrb() ;
    @Data
    @Condition("MHQJ003A_C-SECT-ITTL")
    ICondition cMhqj003aAtrb() ;
    @Data
    @Condition("MHQJ004A_C-SECT-ITTL")
    ICondition cMhqj004aAtrb() ;
    @Data
    @Condition("MHQJ005A_C-SECT-ITTL")
    ICondition cMhqj005aAtrb() ;
    @Data
    @Condition("MHQJ006A_C-PAIS-ISOA-RESI")
    ICondition cMhqj006aAtrb() ;
    @Data
    @Condition("MHQJ007A_C-SECT-PAIS")
    ICondition cMhqj007aAtrb() ;
    @Data
    @Condition("MHQJ008A_C-PRAZO-CONTRAT")
    ICondition cMhqj008aAtrb() ;
    @Data
    @Condition("MHQJ009A_C-OE-EGC")
    ICondition cMhqj009aAtrb() ;
    @Data
    @Condition("MHQJ010A_C-FIN-CREDITO")
    ICondition cMhqj010aAtrb() ;
    @Data
    @Condition("MHQJ011A_N-TIP-INST")
    ICondition cMhqj011aAtrb() ;
    
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHWK0002   COPY DE CONSTANTES 'HW'
     * 
     * @version 2.0
     * 
     */
    public interface CAccao extends IDataStruct {
        
        @Data(size=1, value="V")
        IString cVisualizacao() ;
        
        @Data(size=1, value="C")
        IString cCriacao() ;
        
        @Data(size=1, value="M")
        IString cModificacao() ;
        
        @Data(size=1, value="A")
        IString cAnulacao() ;
        
    }
    public interface CTabelas extends IDataStruct {
        
        @Data(size=8, value="THQ00001")
        IString cThq00001() ;
        
        @Data(size=8, value="THQ00002")
        IString cThq00002() ;
        
        @Data(size=8, value="THQ00003")
        IString cThq00003() ;
        
        @Data(size=8, value="THQ00004")
        IString cThq00004() ;
        
        @Data(size=8, value="THQ00005")
        IString cThq00005() ;
        
        @Data(size=8, value="THQ00006")
        IString cThq00006() ;
        
        @Data(size=8, value="THQ00007")
        IString cThq00007() ;
        
        @Data(size=8, value="THQ00008")
        IString cThq00008() ;
        
        @Data(size=8, value="THQ00009")
        IString cThq00009() ;
        
        @Data(size=8, value="THQ00028")
        IString cThq00028() ;
        
        @Data(size=8, value="THQ00029")
        IString cThq00029() ;
        
    }
    public interface CTabBbn extends IDataStruct {
        
        @Data(size=3, value="006")
        IString c006() ;
        
        @Data(size=3, value="091")
        IString c091() ;
        
        @Data(size=3, value="764")
        IString c764() ;
        
        @Data(size=3, value="812")
        IString c812() ;
        
        @Data(size=3, value="821")
        IString c821() ;
        
        @Data(size=3, value="822")
        IString c822() ;
        
        @Data(size=3, value="901")
        IString c901() ;
        
        @Data(size=3, value="910")
        IString c910() ;
        
        @Data(size=3, value="983")
        IString c983() ;
        
        @Data(size=3, value="850")
        IString c850() ;
        
        @Data(size=3, value="879")
        IString c879() ;
        
    }
    public interface CProgramas extends IDataStruct {
        
        @Data(size=8, value="MHQJ001A")
        IString cMhqj001a() ;
        
        @Data(size=8, value="MHQJ002A")
        IString cMhqj002a() ;
        
        @Data(size=8, value="MHQJ003A")
        IString cMhqj003a() ;
        
        @Data(size=8, value="MHQJ004A")
        IString cMhqj004a() ;
        
        @Data(size=8, value="MHQJ005A")
        IString cMhqj005a() ;
        
        @Data(size=8, value="MHQJ006A")
        IString cMhqj006a() ;
        
        @Data(size=8, value="MHQJ007A")
        IString cMhqj007a() ;
        
        @Data(size=8, value="MHQJ008A")
        IString cMhqj008a() ;
        
        @Data(size=8, value="MHQJ009A")
        IString cMhqj009a() ;
        
        @Data(size=8, value="MHQJ010A")
        IString cMhqj010a() ;
        
        @Data(size=8, value="MHQJ011A")
        IString cMhqj011a() ;
        
        @Data(size=8, value="MHQJ100A")
        IString cMhqj100a() ;
        
        @Data(size=8, value="PHQQ100A")
        IString cPhqq100a() ;
        
        @Data(size=8, value="PHQQ200A")
        IString cPhqq200a() ;
        
        @Data(size=8, value="PHQQ300A")
        IString cPhqq300a() ;
        
        @Data(size=8, value="PHQQ400A")
        IString cPhqq400a() ;
        
    }
    public interface CTipoContaBdp extends IDataStruct {
        
        @Data(size=2, value="01")
        IString cVostro() ;
        
        @Data(size=2, value="02")
        IString cNaoResidente() ;
        
        @Data(size=2, value="03")
        IString cNostro() ;
        
        @Data(size=2, value="04")
        IString cAplicacaoFundos() ;
        
        @Data(size=2, value="05")
        IString cTomadaFundos() ;
        
        @Data(size=2, value="06")
        IString cCaixaMe() ;
        
        @Data(size=2, value="56")
        IString cTransitoria() ;
        
        @Data(size=2, value="58")
        IString cCtaDonic() ;
        
        @Data(size=2, value="78")
        IString cOutraCtaBanco() ;
        
        @Data(size=2, value="99")
        IString cResidente() ;
        
    }
    public interface CTipoContaBdpNum extends IDataStruct {
        
        @Data(size=2, value="2")
        IInt cNaoResidenteNum() ;
        
        @Data(size=2, value="99")
        IInt cResidenteNum() ;
        
    }
    public interface CDetalheCoe extends IDataStruct {
        
        @Data(size=1, value="N")
        IString cSemDetalhe() ;
        
        @Data(size=1, value="C")
        IString cCoesMultiplas() ;
        
        @Data(size=1, value="D")
        IString cDesagregacao() ;
        
    }
    public interface CEstadoCoe extends IDataStruct {
        
        @Data(size=1, value="A")
        IString cAceite() ;
        
        @Data(size=1, value="B")
        IString cRecusadaBatch() ;
        
        @Data(size=1, value="C")
        IString cEnvConfirm() ;
        
        @Data(size=1, value="D")
        IString cRecusadaOffline() ;
        
        @Data(size=1, value="E")
        IString cEnvNaoConfirm() ;
        
        @Data(size=1, value="G")
        IString cAgregada() ;
        
        @Data(size=1, value="O")
        IString cRecBatchOrgExt() ;
        
        @Data(size=1, value="P")
        IString cPendClass() ;
        
        @Data(size=1, value="R")
        IString cRecusadaBdp() ;
        
        @Data(size=1, value="T")
        IString cTotal() ;
        
    }
    public interface CNaturezaCoe extends IDataStruct {
        
        @Data(size=1, value="C")
        IString cNatCriacao() ;
        
        @Data(size=1, value="A")
        IString cNatAnulacao() ;
        
    }
    public interface CDatas extends IDataStruct {
        
        @Data(size=10, value="0001-01-01")
        IString cDataMin() ;
        
        @Data(size=10, value="9999-12-31")
        IString cDataMax() ;
        
    }
    public interface CPaisesIsoAlfn extends IDataStruct {
        
        @Data(size=3, value="PRT")
        IString cPortugal() ;
        
    }
    public interface CIProc extends IDataStruct {
        
        @Data(size=3, value="B")
        IString cIBatch() ;
        
        @Data(size=3, value="O")
        IString cIOnLine() ;
        
    }
    public interface CSimNao extends IDataStruct {
        
        @Data(size=3, value="S")
        IString cSim() ;
        
        @Data(size=3, value="N")
        IString cNao() ;
        
    }
    public interface CIEnvRec extends IDataStruct {
        
        @Data(size=1, value="E")
        IString cIEnvio() ;
        
        @Data(size=1, value="R")
        IString cIRecepcao() ;
        
    }
    public interface CIOperMhyq300a extends IDataStruct {
        
        @Data(size=1, value="1")
        IString cIConsulta() ;
        
        @Data(size=1, value="2")
        IString cIActualizacao() ;
        
    }
    public interface CIOperMhtq300a extends IDataStruct {
        
        @Data(size=1, value="1")
        IString cIIncrementa1() ;
        
        @Data(size=1, value="6")
        IString cIConsultaSeq() ;
        
    }
    public interface CFichBbn extends IDataStruct {
        
        @Data(size=4, value="ECOE")
        IString cEcoe() ;
        
        @Data(size=4, value="ECOR")
        IString cEcor() ;
        
    }
    public interface CIdioIso extends IDataStruct {
        
        @Data(size=3, value="POR")
        IString cPortugues() ;
        
    }
    public interface CMinMax extends IDataStruct {
        
        @Data(size=3, value=" ")
        IString cPaisIsoCoeMin() ;
        
        @Data(size=4, value="0")
        IInt cBancRsplOpetMin() ;
        
        @Data(size=24, value=" ")
        IString nRefOpetBporMin() ;
        
        @Data(size=24, value="999999999999999999999999")
        IString nRefOpetBporMax() ;
        
        @Data(size=4, value="0")
        IInt nsOpetMin() ;
        
        @Data(size=4, value="0")
        IInt cOeEgcMin() ;
        
        @Data(size=4, value="9999")
        IInt cOeEgcMax() ;
        
        @Data(size=1, value=" ")
        IString cEstCoeMin() ;
        
        @Data(size=1, value="9")
        IString cEstCoeMax() ;
        
        @Data(size=3, value=" ")
        IString cMoedIsoMin() ;
        
        @Data(size=3, value="999")
        IString cMoedIsoMax() ;
        
        @Data(size=3, value="0")
        IInt cTipoOpetBporMin() ;
        
        @Data(size=3, value="999")
        IInt cTipoOpetBporMax() ;
        
        @Data(size=9, value="0")
        ILong nIpcMin() ;
        
        @Data(size=9, value="999999999")
        ILong nIpcMax() ;
        
        @Data(size=15, value="0")
        ILong mOpetBporMin() ;
        
        @Data(size=15, value="999999999999999")
        ILong mOpetBporMax() ;
        
        @Data(size=1)
        IString tipoOper() ;
        @Data
        @Condition("A")
        ICondition swAvlNecessCoe() ;
        @Data
        @Condition("V")
        ICondition swAvlNecCoeCnt() ;
        @Data
        @Condition("M")
        ICondition swValidaMotivo() ;
        @Data
        @Condition("G")
        ICondition swGeraCoe() ;
        @Data
        @Condition("R")
        ICondition swGeraCoeRedz() ;
        
        
    }
    public interface CTipInterv extends IDataStruct {
        
        @Data(size=2, signed=true, value="8", compression=COMP3)
        IInt cInsercao() ;
        
        @Data(size=2, signed=true, value="4", compression=COMP3)
        IInt cEliminacao() ;
        
        @Data(size=2, signed=true, value="1", compression=COMP3)
        IInt cManutencao() ;
        
    }
    public interface Varios extends IDataStruct {
        
        @Data(size=3, value="REG")
        IString cParametrizacao() ;
        
        @Data(size=3, value="021")
        IString cOpczMenu() ;
        
    }
    public interface CAut extends IDataStruct {
        
        @Data(size=1, value="C")
        IString cAutMoe() ;
        
        @Data(size=1, value="M")
        IString cAutMon() ;
        
    }
    
}
