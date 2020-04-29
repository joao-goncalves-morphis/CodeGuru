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
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdhops02001Movdia1 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movdia1
     */
    @Data
    public abstract Movdia1 movdia1() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO02001_MOVDIA1
     * 
     * @version 2.0
     * 
     */
    public interface Movdia1 extends IDataStruct {
        
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
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs804a.A5200ListaAscMont20A5200ListaAscMont20
     * 
     */
    public void closeMghs804a1152() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs804a.A5300ListaAsc20A5300ListaAsc20
     * 
     */
    public void closeMghs804a1261() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Mghs804a.A5400ListaDscMont20A5400ListaDscMont20
     * 
     */
    public void closeMghs804a1371() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs804a.A5500ListaDsc20A5500ListaDsc20
     * 
     */
    public void closeMghs804a1481() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs804a.A5200ListaAscMont20A5200ListaAscMont20
     * 
     */
    public void fetchMghs804a1066() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs804a.A5200ListaAscMont20A5200ListaAscMont20
     * 
     */
    public void fetchMghs804a1134() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs804a.A5300ListaAsc20A5300ListaAsc20
     * 
     */
    public void fetchMghs804a1176() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs804a.A5300ListaAsc20A5300ListaAsc20
     * 
     */
    public void fetchMghs804a1243() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs804a.A5400ListaDscMont20A5400ListaDscMont20
     * 
     */
    public void fetchMghs804a1285() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs804a.A5400ListaDscMont20A5400ListaDscMont20
     * 
     */
    public void fetchMghs804a1353() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs804a.A5500ListaDsc20A5500ListaDsc20
     * 
     */
    public void fetchMghs804a1395() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs804a.A5500ListaDsc20A5500ListaDsc20
     * 
     */
    public void fetchMghs804a1463() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(c.getValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(c.getValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(c.getValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(c.getValue("I_DBCR")) ;
            movdia1().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(c.getValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(c.getValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(c.getValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(c.getValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movdia1().nCheque().set(c.getValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(c.getValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(c.getValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(c.getValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(c.getValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(c.getValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(c.getValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(c.getValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(c.getValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(c.getValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(c.getValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(c.getValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(c.getValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(c.getValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(c.getValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(c.getValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(c.getValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(c.getValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(c.getValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(c.getValue("C_USERID")) ;
            movdia1().nJourBbn().set(c.getValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(c.getValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(c.getValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(c.getValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(c.getValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(c.getValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(c.getValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(c.getValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(c.getValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(c.getValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(c.getValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(c.getValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(c.getValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(c.getValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(c.getValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(c.getValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(c.getValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs804a.A5200ListaAscMont20A5200ListaAscMont20
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1054(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDHOPS02001_MOVDIA1" +
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
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdia1().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdia1().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs804a.A5300ListaAsc20A5300ListaAsc20
     * 
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1164(IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDHOPS02001_MOVDIA1" +
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
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdia1().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdia1().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Mghs804a.A5400ListaDscMont20A5400ListaDscMont20
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1273(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDHOPS02001_MOVDIA1" +
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
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdia1().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdia1().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs804a.A5500ListaDsc20A5500ListaDsc20
     * 
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs804a1383(IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDHOPS02001_MOVDIA1" +
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
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movdia1().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "nsMovimento", movdia1().nsMovimento() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02001_MOVDIA1
     * called from Mghj008a.A5003AcedeTho20JornalA5003AcedeTho20Jornal
     * 
     */
    public void selectMghj008a392() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "NS_MOVIMENTO" +
            " FROM VWSDHOPS02001_MOVDIA1" +
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
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "NS_JOUR_BBN_DTLH = :nsJourBbnDtlh" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdia1().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        setQueryArgument( "zMovimento", movdia1().zMovimento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", movdia1().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movdia1().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movdia1().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movdia1().cUserid() ) ;
        setQueryArgument( "nJourBbn", movdia1().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movdia1().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movdia1().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02001_MOVDIA1
     * called from Mghj008a.A5004AcedeTho20MovA5004AcedeTho20Mov
     * 
     */
    public void selectMghj008a440() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "Z_MOVIMENTO," +
                "C_MNEM_EGC_OPEX," +
                "C_PAIS_ISOA_OE_OPX," +
                "C_OE_EGC_OPEX," +
                "C_USERID," +
                "N_JOUR_BBN," +
                "NS_JOUR_BBN," +
                "NS_JOUR_BBN_DTLH" +
            " FROM VWSDHOPS02001_MOVDIA1" +
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
        setQueryArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdia1().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdia1().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdia1().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02001_MOVDIA1
     * called from Mghj206a.A5200AcedeTho20A5200AcedeTho20
     * 
     */
    public void selectMghj206a243() {
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
            " FROM VWSDHOPS02001_MOVDIA1" +
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
        setQueryArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdia1().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdia1().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(getQueryReturnedValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(getQueryReturnedValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movdia1().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(getQueryReturnedValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(getQueryReturnedValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movdia1().nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(getQueryReturnedValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(getQueryReturnedValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(getQueryReturnedValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(getQueryReturnedValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(getQueryReturnedValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(getQueryReturnedValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(getQueryReturnedValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(getQueryReturnedValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdia1().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(getQueryReturnedValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(getQueryReturnedValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(getQueryReturnedValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(getQueryReturnedValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(getQueryReturnedValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(getQueryReturnedValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(getQueryReturnedValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02001_MOVDIA1
     * called from Mghs112a.A3121AcedeTho20A3121AcedeTho20
     * 
     */
    public void selectMghs112a282() {
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
            " FROM VWSDHOPS02001_MOVDIA1" +
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
                "C_USERID = :cUserid AND " +
                "N_JOUR_BBN = :nJourBbn AND " +
                "NS_JOUR_BBN = :nsJourBbn AND " +
                "NS_JOUR_BBN_DTLH = :nsJourBbnDtlh" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdia1().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        setQueryArgument( "zProcessamento", movdia1().zProcessamento(), java.sql.Date.class ) ;
        setQueryArgument( "cMnemEgcOpex", movdia1().cMnemEgcOpex() ) ;
        setQueryArgument( "cPaisIsoaOeOpx", movdia1().cPaisIsoaOeOpx() ) ;
        setQueryArgument( "cOeEgcOpex", movdia1().cOeEgcOpex() ) ;
        setQueryArgument( "cUserid", movdia1().cUserid() ) ;
        setQueryArgument( "nJourBbn", movdia1().nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", movdia1().nsJourBbn() ) ;
        setQueryArgument( "nsJourBbnDtlh", movdia1().nsJourBbnDtlh() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movdia1().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movdia1().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movdia1().nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            movdia1().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movdia1().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO02001_MOVDIA1
     * called from Mghs805a.A5200AcedeTho20A5200AcedeTho20
     * 
     */
    public void selectMghs805a222() {
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
            " FROM VWSDHOPS02001_MOVDIA1" +
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
        setQueryArgument( "cPaisIsoaCont", movdia1().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movdia1().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movdia1().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movdia1().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movdia1().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movdia1().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movdia1().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movdia1().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movdia1().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movdia1().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movdia1().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movdia1().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movdia1().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movdia1().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movdia1().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movdia1().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movdia1().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movdia1().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movdia1().zContabilizacao().set(getQueryReturnedValue("Z_CONTABILIZACAO", String.class)) ;
            movdia1().zMovimento().set(getQueryReturnedValue("Z_MOVIMENTO", String.class)) ;
            movdia1().zValor().set(getQueryReturnedValue("Z_VALOR", String.class)) ;
            movdia1().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movdia1().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movdia1().mSldoCblo().set(getQueryReturnedValue("M_SLDO_CBLO")) ;
            movdia1().mSldoDpnl().set(getQueryReturnedValue("M_SLDO_DPNL")) ;
            movdia1().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movdia1().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movdia1().tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
            movdia1().cOpeBbn().set(getQueryReturnedValue("C_OPE_BBN")) ;
            movdia1().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movdia1().nCheque().set(getQueryReturnedValue("N_CHEQUE")) ;
            movdia1().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movdia1().nsMovEtnd().set(getQueryReturnedValue("NS_MOV_ETND")) ;
            movdia1().iTrnzEfcdOnln().set(getQueryReturnedValue("I_TRNZ_EFCD_ONLN")) ;
            movdia1().iTipoOrigTrnz().set(getQueryReturnedValue("I_TIPO_ORIG_TRNZ")) ;
            movdia1().iExiAtzJourBbn().set(getQueryReturnedValue("I_EXI_ATZ_JOUR_BBN")) ;
            movdia1().cTipoCanlAces().set(getQueryReturnedValue("C_TIPO_CANL_ACES")) ;
            movdia1().aAplicacao().set(getQueryReturnedValue("A_APLICACAO")) ;
            movdia1().cOpczMenu().set(getQueryReturnedValue("C_OPCZ_MENU")) ;
            movdia1().cFamiProd().set(getQueryReturnedValue("C_FAMI_PROD")) ;
            movdia1().cProduto().set(getQueryReturnedValue("C_PRODUTO")) ;
            movdia1().cSectIttlBpor().set(getQueryReturnedValue("C_SECT_ITTL_BPOR")) ;
            movdia1().cPaisIsoaGerx().set(getQueryReturnedValue("C_PAIS_ISOA_GERX")) ;
            movdia1().cBancGcxGerx().set(getQueryReturnedValue("C_BANC_GCX_GERX")) ;
            movdia1().cOeEgcGerx().set(getQueryReturnedValue("C_OE_EGC_GERX")) ;
            movdia1().iMovActzVsld().set(getQueryReturnedValue("I_MOV_ACTZ_VSLD")) ;
            movdia1().zProcessamento().set(getQueryReturnedValue("Z_PROCESSAMENTO", String.class)) ;
            movdia1().cMnemEgcOpex().set(getQueryReturnedValue("C_MNEM_EGC_OPEX")) ;
            movdia1().cPaisIsoaOeOpx().set(getQueryReturnedValue("C_PAIS_ISOA_OE_OPX")) ;
            movdia1().cOeEgcOpex().set(getQueryReturnedValue("C_OE_EGC_OPEX")) ;
            movdia1().cUserid().set(getQueryReturnedValue("C_USERID")) ;
            movdia1().nJourBbn().set(getQueryReturnedValue("N_JOUR_BBN")) ;
            movdia1().nsJourBbn().set(getQueryReturnedValue("NS_JOUR_BBN")) ;
            movdia1().nsJourBbnDtlh().set(getQueryReturnedValue("NS_JOUR_BBN_DTLH")) ;
            movdia1().mSldoRetd().set(getQueryReturnedValue("M_SLDO_RETD")) ;
            movdia1().mSldoVcob().set(getQueryReturnedValue("M_SLDO_VCOB")) ;
            movdia1().mSldoVcobUtid().set(getQueryReturnedValue("M_SLDO_VCOB_UTID")) ;
            movdia1().mDcboNgcdAtrd().set(getQueryReturnedValue("M_DCBO_NGCD_ATRD")) ;
            movdia1().mDcboNgcdUtid().set(getQueryReturnedValue("M_DCBO_NGCD_UTID")) ;
            movdia1().mCmrgLim().set(getQueryReturnedValue("M_CMRG_LIM")) ;
            movdia1().mCmrgUtid().set(getQueryReturnedValue("M_CMRG_UTID")) ;
            movdia1().qDiaCalcJuro().set(getQueryReturnedValue("Q_DIA_CALC_JURO")) ;
            movdia1().cTipoJuro().set(getQueryReturnedValue("C_TIPO_JURO")) ;
            movdia1().iTipoCalcJuro().set(getQueryReturnedValue("I_TIPO_CALC_JURO")) ;
            movdia1().iPenalizacao().set(getQueryReturnedValue("I_PENALIZACAO")) ;
            movdia1().qRenovacao().set(getQueryReturnedValue("Q_RENOVACAO")) ;
            movdia1().nsUtizCmrg().set(getQueryReturnedValue("NS_UTIZ_CMRG")) ;
            movdia1().cEvenOpel().set(getQueryReturnedValue("C_EVEN_OPEL")) ;
            movdia1().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movdia1().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
}
