package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.persistence.relational.annotations.Key ;
import morphis.framework.persistence.relational.annotations.Column ;
import morphis.framework.persistence.relational.BaseTableHandler ;
import morphis.framework.persistence.relational.BaseCursorHandler ;
import morphis.framework.exceptions.* ;
/**
 * External
 */
import cgd.gh.persistence.database.Vwsdhops02001Movdia1.Movdia1 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdhops02101Movdia2 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movdia2
     */
    @Data
    public abstract Movdia2 movdia2() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO02101_MOVDIA2
     * 
     * @version 2.0
     * 
     */
    public interface Movdia2 extends IDataStruct {
        
        /**
         * C_PAIS_ISOA_CONT
         */
        @Column(name="C_PAIS_ISOA_CONT")
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * C_BANC_CONT
         */
        @Column(name="C_BANC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        /**
         * C_OE_EGC_CONT
         */
        @Column(name="C_OE_EGC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        /**
         * NS_RDCL_CONT
         */
        @Column(name="NS_RDCL_CONT")
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        /**
         * V_CHKD_CONT
         */
        @Column(name="V_CHKD_CONT")
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        /**
         * C_TIPO_CONT
         */
        @Column(name="C_TIPO_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        /**
         * C_MOED_ISO_SCTA
         */
        @Column(name="C_MOED_ISO_SCTA")
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        /**
         * NS_DEPOSITO
         */
        @Column(name="NS_DEPOSITO")
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        /**
         * NS_MOVIMENTO
         */
        @Column(name="NS_MOVIMENTO")
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        /**
         * Z_CONTABILIZACAO
         */
        @Column(name="Z_CONTABILIZACAO", type=java.sql.Date.class)
        @Data(size=10)
        IString zContabilizacao() ;
        
        /**
         * Z_MOVIMENTO
         */
        @Column(name="Z_MOVIMENTO", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovimento() ;
        
        /**
         * Z_VALOR
         */
        @Column(name="Z_VALOR", type=java.sql.Date.class)
        @Data(size=10)
        IString zValor() ;
        
        /**
         * I_DBCR
         */
        @Column(name="I_DBCR")
        @Data(size=1)
        IString iDbcr() ;
        
        /**
         * M_MOVIMENTO
         */
        @Column(name="M_MOVIMENTO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        /**
         * M_SLDO_CBLO
         */
        @Column(name="M_SLDO_CBLO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCblo() ;
        
        /**
         * M_SLDO_DPNL
         */
        @Column(name="M_SLDO_DPNL")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnl() ;
        
        /**
         * C_MOED_ISO_ORI_MOV
         */
        @Column(name="C_MOED_ISO_ORI_MOV")
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        /**
         * M_MOV_MOE_ORIG_MOV
         */
        @Column(name="M_MOV_MOE_ORIG_MOV")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        /**
         * T_CAMBIO
         */
        @Column(name="T_CAMBIO")
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal tCambio() ;
        
        /**
         * C_OPE_BBN
         */
        @Column(name="C_OPE_BBN")
        @Data(size=5)
        IString cOpeBbn() ;
        
        /**
         * X_REF_MOV
         */
        @Column(name="X_REF_MOV")
        @Data(size=21)
        IString xRefMov() ;
        
        /**
         * N_CHEQUE
         */
        @Column(name="N_CHEQUE")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCheque() ;
        
        /**
         * I_ESTORNO
         */
        @Column(name="I_ESTORNO")
        @Data(size=1)
        IString iEstorno() ;
        
        /**
         * NS_MOV_ETND
         */
        @Column(name="NS_MOV_ETND")
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovEtnd() ;
        
        /**
         * I_TRNZ_EFCD_ONLN
         */
        @Column(name="I_TRNZ_EFCD_ONLN")
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        /**
         * I_TIPO_ORIG_TRNZ
         */
        @Column(name="I_TIPO_ORIG_TRNZ")
        @Data(size=1)
        IString iTipoOrigTrnz() ;
        
        /**
         * I_EXI_ATZ_JOUR_BBN
         */
        @Column(name="I_EXI_ATZ_JOUR_BBN")
        @Data(size=1)
        IString iExiAtzJourBbn() ;
        
        /**
         * C_TIPO_CANL_ACES
         */
        @Column(name="C_TIPO_CANL_ACES")
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        /**
         * A_APLICACAO
         */
        @Column(name="A_APLICACAO")
        @Data(size=2)
        IString aAplicacao() ;
        
        /**
         * C_OPCZ_MENU
         */
        @Column(name="C_OPCZ_MENU")
        @Data(size=3)
        IString cOpczMenu() ;
        
        /**
         * C_FAMI_PROD
         */
        @Column(name="C_FAMI_PROD")
        @Data(size=3)
        IString cFamiProd() ;
        
        /**
         * C_PRODUTO
         */
        @Column(name="C_PRODUTO")
        @Data(size=3)
        IString cProduto() ;
        
        /**
         * C_SECT_ITTL_BPOR
         */
        @Column(name="C_SECT_ITTL_BPOR")
        @Data(size=7, signed=true, compression=COMP3)
        IInt cSectIttlBpor() ;
        
        /**
         * C_PAIS_ISOA_GERX
         */
        @Column(name="C_PAIS_ISOA_GERX")
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        /**
         * C_BANC_GCX_GERX
         */
        @Column(name="C_BANC_GCX_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        /**
         * C_OE_EGC_GERX
         */
        @Column(name="C_OE_EGC_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        /**
         * I_MOV_ACTZ_VSLD
         */
        @Column(name="I_MOV_ACTZ_VSLD")
        @Data(size=1)
        IString iMovActzVsld() ;
        
        /**
         * Z_PROCESSAMENTO
         */
        @Column(name="Z_PROCESSAMENTO", type=java.sql.Date.class)
        @Data(size=10)
        IString zProcessamento() ;
        
        /**
         * C_MNEM_EGC_OPEX
         */
        @Column(name="C_MNEM_EGC_OPEX")
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        /**
         * C_PAIS_ISOA_OE_OPX
         */
        @Column(name="C_PAIS_ISOA_OE_OPX")
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        /**
         * C_OE_EGC_OPEX
         */
        @Column(name="C_OE_EGC_OPEX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcOpex() ;
        
        /**
         * C_USERID
         */
        @Column(name="C_USERID")
        @Data(size=8)
        IString cUserid() ;
        
        /**
         * N_JOUR_BBN
         */
        @Column(name="N_JOUR_BBN")
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        /**
         * NS_JOUR_BBN
         */
        @Column(name="NS_JOUR_BBN")
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        /**
         * NS_JOUR_BBN_DTLH
         */
        @Column(name="NS_JOUR_BBN_DTLH")
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnDtlh() ;
        
        /**
         * M_SLDO_RETD
         */
        @Column(name="M_SLDO_RETD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoRetd() ;
        
        /**
         * M_SLDO_VCOB
         */
        @Column(name="M_SLDO_VCOB")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcob() ;
        
        /**
         * M_SLDO_VCOB_UTID
         */
        @Column(name="M_SLDO_VCOB_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoVcobUtid() ;
        
        /**
         * M_DCBO_NGCD_ATRD
         */
        @Column(name="M_DCBO_NGCD_ATRD")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdAtrd() ;
        
        /**
         * M_DCBO_NGCD_UTID
         */
        @Column(name="M_DCBO_NGCD_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mDcboNgcdUtid() ;
        
        /**
         * M_CMRG_LIM
         */
        @Column(name="M_CMRG_LIM")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        /**
         * M_CMRG_UTID
         */
        @Column(name="M_CMRG_UTID")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgUtid() ;
        
        /**
         * Q_DIA_CALC_JURO
         */
        @Column(name="Q_DIA_CALC_JURO")
        @Data(size=5, signed=true, compression=COMP3)
        IInt qDiaCalcJuro() ;
        
        /**
         * C_TIPO_JURO
         */
        @Column(name="C_TIPO_JURO")
        @Data(size=2)
        IString cTipoJuro() ;
        
        /**
         * I_TIPO_CALC_JURO
         */
        @Column(name="I_TIPO_CALC_JURO")
        @Data(size=1)
        IString iTipoCalcJuro() ;
        
        /**
         * I_PENALIZACAO
         */
        @Column(name="I_PENALIZACAO")
        @Data(size=1)
        IString iPenalizacao() ;
        
        /**
         * Q_RENOVACAO
         */
        @Column(name="Q_RENOVACAO")
        @Data(size=3, signed=true, compression=COMP3)
        IInt qRenovacao() ;
        
        /**
         * NS_UTIZ_CMRG
         */
        @Column(name="NS_UTIZ_CMRG")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsUtizCmrg() ;
        
        /**
         * C_EVEN_OPEL
         */
        @Column(name="C_EVEN_OPEL")
        @Data(size=4)
        IString cEvenOpel() ;
        
        /**
         * TS_ACTZ_ULT
         */
        @Column(name="TS_ACTZ_ULT", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsActzUlt() ;
        
        /**
         * C_USID_ACTZ_ULT
         */
        @Column(name="C_USID_ACTZ_ULT")
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C5
     * called from Mghs804a.A5600ListaAscMont21A5600ListaAscMont21
     * 
     */
    public void closeMghs804a1591() {
        BaseCursorHandler c = getCursor("C5") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C6
     * called from Mghs804a.A5700ListaAsc21A5700ListaAsc21
     * 
     */
    public void closeMghs804a1702() {
        BaseCursorHandler c = getCursor("C6") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C7
     * called from Mghs804a.A5800ListaDscMont21A5800ListaDscMont21
     * 
     */
    public void closeMghs804a1812() {
        BaseCursorHandler c = getCursor("C7") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C8
     * called from Mghs804a.A5900ListaDsc21A5900ListaDsc21
     * 
     */
    public void closeMghs804a1922() {
        BaseCursorHandler c = getCursor("C8") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C5
     * called from Mghs804a.A5600ListaAscMont21A5600ListaAscMont21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1505(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C5") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C5
     * called from Mghs804a.A5600ListaAscMont21A5600ListaAscMont21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1573(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C5") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C6
     * called from Mghs804a.A5700ListaAsc21A5700ListaAsc21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1615(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C6") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C6
     * called from Mghs804a.A5700ListaAsc21A5700ListaAsc21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1684(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C6") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C7
     * called from Mghs804a.A5800ListaDscMont21A5800ListaDscMont21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1726(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C7") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C7
     * called from Mghs804a.A5800ListaDscMont21A5800ListaDscMont21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1794(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C7") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C8
     * called from Mghs804a.A5900ListaDsc21A5900ListaDsc21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1836(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C8") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C8
     * called from Mghs804a.A5900ListaDsc21A5900ListaDsc21
     * 
     * @param pMovdia1
     */
    public void fetchMghs804a1904(Movdia1 pMovdia1) {
        BaseCursorHandler c = getCursor("C8") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(c.getValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(c.getValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(c.getValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(c.getValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(c.getValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(c.getValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(c.getValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(c.getValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(c.getValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(c.getValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C5
     * called from Mghs804a.A5600ListaAscMont21A5600ListaAscMont21
     * 
     * @param pMovdia1
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1493(Movdia1 pMovdia1, IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO >= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C5", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", pMovdia1.nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C6
     * called from Mghs804a.A5700ListaAsc21A5700ListaAsc21
     * 
     * @param pMovdia1
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1603(Movdia1 pMovdia1, IString pWsCrit1, IString pWsCrit2) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO >= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C6", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", pMovdia1.nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C7
     * called from Mghs804a.A5800ListaDscMont21A5800ListaDscMont21
     * 
     * @param pMovdia1
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1714(Movdia1 pMovdia1, IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO <= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C7", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", pMovdia1.nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C8
     * called from Mghs804a.A5900ListaDsc21A5900ListaDsc21
     * 
     * @param pMovdia1
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1824(Movdia1 pMovdia1, IString pWsCrit1, IString pWsCrit2) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "NS_MOVIMENTO <= :nsMovimento" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C8", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        c.setArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        c.setArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        c.setArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", pMovdia1.nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02101_MOVDIA2
     * called from Mghj008a.A5005AcedeTho21JornalA5005AcedeTho21Jornal
     * 
     * @param pMovdia1
     */
    public void selectMghj008a499(Movdia1 pMovdia1) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "Z_MOVIMENTO = :zMovimento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "NS_JOUR_BBN_DTLH = :nsJourBbnDtlh" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        setQueryArgument( "zMovimento", pMovdia1.zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", pMovdia1.cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pMovdia1.cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", pMovdia1.cOeEgcOpex() ) ;
        setQueryArgument( "nJourBbn", pMovdia1.nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", pMovdia1.nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", pMovdia1.nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia2().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02101_MOVDIA2
     * called from Mghj008a.A5006AcedeTho21MovA5006AcedeTho21Mov
     * 
     * @param pMovdia1
     */
    public void selectMghj008a546(Movdia1 pMovdia1) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "Z_MOVIMENTO = :zMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        setQueryArgument( "zMovimento", pMovdia1.zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "nsMovimento", pMovdia1.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia2().zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            movdia2().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdia2().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia2().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdia2().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdia2().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdia2().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movdia2().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02101_MOVDIA2
     * called from Mghj206a.A5300AcedeTho21A5300AcedeTho21
     * 
     * @param pMovdia1
     */
    public void selectMghj206a334(Movdia1 pMovdia1) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        setQueryArgument( "nsMovimento", pMovdia1.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(getQueryReturnedValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(getQueryReturnedValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(getQueryReturnedValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(getQueryReturnedValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(getQueryReturnedValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(getQueryReturnedValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(getQueryReturnedValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(getQueryReturnedValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(getQueryReturnedValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(getQueryReturnedValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(getQueryReturnedValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(getQueryReturnedValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(getQueryReturnedValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(getQueryReturnedValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(getQueryReturnedValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(getQueryReturnedValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(getQueryReturnedValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(getQueryReturnedValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(getQueryReturnedValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(getQueryReturnedValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02101_MOVDIA2
     * called from Mghs112a.A3122AcedeTho21A3122AcedeTho21
     * 
     * @param pMovdia1
     */
    public void selectMghs112a341(Movdia1 pMovdia1) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO," +
                "M_MOVIMENTO," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_DBCR," +
                "A_APLICACAO" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "Z_PROCESSAMENTO = :zProcessamento AND " +
                "C_MNEM_EGC_OPEX = :cMnemEgcOpex AND " +
                "C_PAIS_ISOA_OE_OPX = :cPaisIsoaOeOpx AND " +
                "C_OE_EGC_OPEX = :cOeEgcOpex AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "NS_JOUR_BBN_DTLH = :nsJourBbnDtlh" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        setQueryArgument( "zProcessamento", pMovdia1.zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", pMovdia1.cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", pMovdia1.cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", pMovdia1.cOeEgcOpex() ) ;
        setQueryArgument( "nJourBbn", pMovdia1.nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", pMovdia1.nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", pMovdia1.nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia2().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movdia2().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movdia2().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movdia2().nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            movdia2().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movdia2().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02101_MOVDIA2
     * called from Mghs805a.A5300AcedeTho21A5300AcedeTho21
     * 
     * @param pMovdia1
     */
    public void selectMghs805a313(Movdia1 pMovdia1) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "NS_MOVIMENTO," +
                "Z_CONTABILIZACAO," +
                "Z_MOVIMENTO," +
                "Z_VALOR," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "M_SLDO_CBLO," +
                "M_SLDO_DPNL," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "T_CAMBIO," +
                "C_OPE_BBN," +
                "X_REF_MOV," +
                "N_CHEQUE," +
                "I_ESTORNO," +
                "NS_MOV_ETND," +
                "I_TRNZ_EFCD_ONLN," +
                "I_TIPO_ORIG_TRNZ," +
                "I_EXI_ATZ_JOUR_BBN," +
                "C_TIPO_CANL_ACES," +
                "A_APLICACAO," +
                "C_OPCZ_MENU," +
                "C_FAMI_PROD," +
                "C_PRODUTO," +
                "C_SECT_ITTL_BPOR," +
                "C_PAIS_ISOA_GERX," +
                "C_BANC_GCX_GERX," +
                "C_OE_EGC_GERX," +
                "I_MOV_ACTZ_VSLD," +
                "Z_PROCESSAMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH," +
                "M_SLDO_RETD," +
                "M_SLDO_VCOB," +
                "M_SLDO_VCOB_UTID," +
                "M_DCBO_NGCD_ATRD," +
                "M_DCBO_NGCD_UTID," +
                "M_CMRG_LIM," +
                "M_CMRG_UTID," +
                "Q_DIA_CALC_JURO," +
                "C_TIPO_JURO," +
                "I_TIPO_CALC_JURO," +
                "I_PENALIZACAO," +
                "Q_RENOVACAO," +
                "NS_UTIZ_CMRG," +
                "C_EVEN_OPEL," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDHOPS02101_MOVDIA2" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovdia1.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovdia1.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovdia1.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovdia1.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovdia1.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovdia1.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovdia1.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovdia1.nsDeposito() ) ;
        setQueryArgument( "nsMovimento", pMovdia1.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pMovdia1.cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            pMovdia1.cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            pMovdia1.cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            pMovdia1.nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            pMovdia1.vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            pMovdia1.cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            pMovdia1.cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            pMovdia1.nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            pMovdia1.nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            pMovdia1.zContabilizacao().set(getQueryReturnedValue("Z_CONTABILIZACAO", String.class)) ;
            pMovdia1.zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            pMovdia1.zValor().set(getQueryReturnedValue("Z_VALOR", String.class)) ;
            pMovdia1.iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            pMovdia1.mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            pMovdia1.mSldoCblo().set(getQueryReturnedValue("M_SLDO_CBLO")) ;
            pMovdia1.mSldoDpnl().set(getQueryReturnedValue("M_SLDO_DPNL")) ;
            pMovdia1.cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            pMovdia1.mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovdia1.tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            pMovdia1.cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            pMovdia1.xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            pMovdia1.nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            pMovdia1.iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            pMovdia1.nsMovEtnd().set(getQueryReturnedValue("NS_MOV_ETND")) ;
            pMovdia1.iTrnzEfcdOnln().set(getQueryReturnedValue("I_TRNZ_EFCD_ONLN")) ;
            pMovdia1.iTipoOrigTrnz().set(getQueryReturnedValue("I_TIPO_ORIG_TRNZ")) ;
            pMovdia1.iExiAtzJourBbn().set(getQueryReturnedValue("I_EXI_ATZ_JOUR_BBN")) ;
            pMovdia1.cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            pMovdia1.aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            pMovdia1.cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            pMovdia1.cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            pMovdia1.cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            pMovdia1.cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            pMovdia1.cPaisIsoaGerx().set(getQueryReturnedValue("C_PAIS_ISOA_GERX")) ;
            pMovdia1.cBancGcxGerx().set(getQueryReturnedValue("C_BANC_GCX_GERX")) ;
            pMovdia1.cOeEgcGerx().set(getQueryReturnedValue("C_OE_EGC_GERX")) ;
            pMovdia1.iMovActzVsld().set(getQueryReturnedValue("I_MOV_ACTZ_VSLD")) ;
            pMovdia1.zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            pMovdia1.cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            pMovdia1.cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            pMovdia1.cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            pMovdia1.cUserid().set(getQueryReturnedValue("C_USERID")) ;
            pMovdia1.nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            pMovdia1.nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            pMovdia1.nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            pMovdia1.mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            pMovdia1.mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            pMovdia1.mSldoVcobUtid().set(getQueryReturnedValue("M_SLDO_VCOB_UTID")) ;
            pMovdia1.mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            pMovdia1.mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            pMovdia1.mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            pMovdia1.mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            pMovdia1.qDiaCalcJuro().set(getQueryReturnedValue("Q_DIA_CALC_JURO")) ;
            pMovdia1.cTipoJuro().set(getQueryReturnedValue("C_TIPO_JURO")) ;
            pMovdia1.iTipoCalcJuro().set(getQueryReturnedValue("I_TIPO_CALC_JURO")) ;
            pMovdia1.iPenalizacao().set(getQueryReturnedValue("I_PENALIZACAO")) ;
            pMovdia1.qRenovacao().set(getQueryReturnedValue("Q_RENOVACAO")) ;
            pMovdia1.nsUtizCmrg().set(getQueryReturnedValue("NS_UTIZ_CMRG")) ;
            pMovdia1.cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            pMovdia1.tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            pMovdia1.cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
}
