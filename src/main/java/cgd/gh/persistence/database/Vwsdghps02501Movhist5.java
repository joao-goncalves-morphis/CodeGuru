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
import cgd.gh.persistence.database.Vwsdghps12501Movhstcp5.Movhstcp5 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps02501Movhist5 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhist5
     */
    @Data
    public abstract Movhist5 movhist5() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH02501_MOVHIST5
     * 
     * @version 2.0
     * 
     */
    public interface Movhist5 extends IDataStruct {
        
        /**
         * C_PAIS_ISOA_CONT
         */
        @Column(name="C_PAIS_ISOA_CONT")
        @Key
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * C_BANC_CONT
         */
        @Column(name="C_BANC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        /**
         * C_OE_EGC_CONT
         */
        @Column(name="C_OE_EGC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        /**
         * NS_RDCL_CONT
         */
        @Column(name="NS_RDCL_CONT")
        @Key
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        /**
         * V_CHKD_CONT
         */
        @Column(name="V_CHKD_CONT")
        @Key
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        /**
         * C_TIPO_CONT
         */
        @Column(name="C_TIPO_CONT")
        @Key
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        /**
         * C_MOED_ISO_SCTA
         */
        @Column(name="C_MOED_ISO_SCTA")
        @Key
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        /**
         * NS_DEPOSITO
         */
        @Column(name="NS_DEPOSITO")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        /**
         * TS_MOVIMENTO
         */
        @Column(name="TS_MOVIMENTO", type=java.sql.Timestamp.class)
        @Key
        @Data(size=26)
        IString tsMovimento() ;
        
        /**
         * NS_MOVIMENTO
         */
        @Column(name="NS_MOVIMENTO")
        @Key
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        /**
         * Z_VAL_MOV
         */
        @Column(name="Z_VAL_MOV", type=java.sql.Date.class)
        @Data(size=10)
        IString zValMov() ;
        
        /**
         * Z_MOV_LOCL
         */
        @Column(name="Z_MOV_LOCL", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovLocl() ;
        
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
         * I_ESTORNO
         */
        @Column(name="I_ESTORNO")
        @Data(size=1)
        IString iEstorno() ;
        
        /**
         * C_MOED_ISO_ORI_MOV
         */
        @Column(name="C_MOED_ISO_ORI_MOV")
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        /**
         * M_SLDO_CBLO_APOS
         */
        @Column(name="M_SLDO_CBLO_APOS")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCbloApos() ;
        
        /**
         * M_SLDO_DPNL_APOS
         */
        @Column(name="M_SLDO_DPNL_APOS")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnlApos() ;
        
        /**
         * M_MOV_MOE_ORIG_MOV
         */
        @Column(name="M_MOV_MOE_ORIG_MOV")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovMoeOrigMov() ;
        
        /**
         * X_REF_MOV
         */
        @Column(name="X_REF_MOV", type=byte[].class)
        @Data(size=21)
        IString xRefMov() ;
        
        /**
         * N_DOC_OPPS
         */
        @Column(name="N_DOC_OPPS")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nDocOpps() ;
        
        /**
         * T_JURO
         */
        @Column(name="T_JURO")
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal tJuro() ;
        
        /**
         * A_APL_ORIG
         */
        @Column(name="A_APL_ORIG")
        @Data(size=2)
        IString aAplOrig() ;
        
        /**
         * I_EXIS_INF_ADI
         */
        @Column(name="I_EXIS_INF_ADI")
        @Data(size=1)
        IString iExisInfAdi() ;
        
        /**
         * X_CHAV_ACS_INF_ADI
         */
        @Column(name="X_CHAV_ACS_INF_ADI", type=byte[].class)
        @Data(size=40)
        IString xChavAcsInfAdi() ;
        
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
     * BatchQ1
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq025a.A31400CloseC1A31400CloseC1
     * 
     */
    public void closePghq025a1829() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_VGH02501
     * called from Pghq101a.M2640CloseCrsVgh02501M2640CloseCrsVgh02501
     * 
     */
    public void closePghq101a2378() {
        BaseCursorHandler c = getCursor("CRS_VGH02501") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq025a.A31200FetchC1A31200FetchC1
     * 
     */
    public void fetchPghq025a845() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_VGH02501
     * called from Pghq101a.M2620FetchCrsVgh02501M2620FetchCrsVgh02501
     * 
     * @param pCEvenOpel
     */
    public void fetchPghq101a2298(IString pCEvenOpel) {
        BaseCursorHandler c = getCursor("CRS_VGH02501") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            pCEvenOpel.set(c.getValue("C_EVEN_OPEL")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq025a.A31100OpenC1A31100OpenC1
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openPghq025a818(IString pWsTsInicio, IString pWsTsFim) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02501_MOVHIST5" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "TS_MOVIMENTO <= :wsTsFim" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist5().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist5().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist5().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_VGH02501
     * called from Pghq101a.M2610OpenCrsVgh02501M2610OpenCrsVgh02501
     * 
     * @param pCon4052
     * @param pCon4009
     * @param pCon4023
     * @param pCon4037
     * @param pConSx
     * @param pConGn
     * @param pConGp
     */
    public void openPghq101a2258(String pCon4052, String pCon4009, String pCon4023, String pCon4037, String pConSx, String pConGn, String pConGp) {
        sqlSttmt = "SELECT  " +
                "A.NS_DEPOSITO," +
                "A.NS_MOVIMENTO," +
                "A.I_DBCR," +
                "A.M_MOVIMENTO," +
                "A.X_REF_MOV," +
                "A.Z_VAL_MOV," +
                "A.Z_MOV_LOCL," +
                "B.C_EVEN_OPEL" +
            " FROM VWSDGHPS02501_MOVHIST5 AS A, VWSDGHPS12501_MOVHSTCP5 AS B" +
            " WHERE " +
                "A.C_PAIS_ISOA_CONT = B.C_PAIS_ISOA_CONT AND " +
                "A.C_BANC_CONT = B.C_BANC_CONT AND " +
                "A.C_OE_EGC_CONT = B.C_OE_EGC_CONT AND " +
                "A.NS_RDCL_CONT = B.NS_RDCL_CONT AND " +
                "A.V_CHKD_CONT = B.V_CHKD_CONT AND " +
                "A.C_TIPO_CONT = B.C_TIPO_CONT AND " +
                "A.NS_MOVIMENTO = B.NS_MOVIMENTO AND " +
                "A.C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "A.C_BANC_CONT = :cBancCont AND " +
                "A.C_OE_EGC_CONT = :cOeEgcCont AND " +
                "A.NS_RDCL_CONT = :nsRdclCont AND " +
                "A.V_CHKD_CONT = :vChkdCont AND " +
                "A.C_TIPO_CONT = :cTipoCont AND " +
                "B.C_EVEN_OPEL <> :con4052 AND B.C_EVEN_OPEL <> :con4009 AND " +
                "B.C_EVEN_OPEL <> :con4023 AND " +
                "B.C_EVEN_OPEL <> :con4037 AND " +
                "(A.A_APL_ORIG = :conSx OR A.A_APL_ORIG = :conGn OR " +
                "A.A_APL_ORIG = :conGp)" +
            " ORDER BY " +
                "A.TS_MOVIMENTO DESC" ;
        BaseCursorHandler c = addCursor("CRS_VGH02501", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist5().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        c.setArgument( "con4052", pCon4052 ) ;
        c.setArgument( "con4009", pCon4009 ) ;
        c.setArgument( "con4023", pCon4023 ) ;
        c.setArgument( "con4037", pCon4037 ) ;
        c.setArgument( "conSx", pConSx ) ;
        c.setArgument( "conGn", pConGn ) ;
        c.setArgument( "conGp", pConGp ) ;
        c.open() ;
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH02501_MOVHIST5
     * called from Pghqz02a.A30005EscreverHist025A30005EscreverHist025
     * 
     */
    public void insertPghqz02a1716() {
        sqlSttmt = "INSERT INTO VWSDGHPS02501_MOVHIST5 ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"TS_MOVIMENTO, " +
        	"NS_MOVIMENTO, " +
        	"Z_VAL_MOV, " +
        	"Z_MOV_LOCL, " +
        	"I_DBCR, " +
        	"M_MOVIMENTO, " +
        	"I_ESTORNO, " +
        	"C_MOED_ISO_ORI_MOV, " +
        	"M_SLDO_CBLO_APOS, " +
        	"M_SLDO_DPNL_APOS, " +
        	"M_MOV_MOE_ORIG_MOV, " +
        	"X_REF_MOV, " +
        	"N_DOC_OPPS, " +
        	"A_APL_ORIG, " +
        	"I_EXIS_INF_ADI, " +
        	"X_CHAV_ACS_INF_ADI, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":cPaisIsoaCont, " +
        	":cBancCont, " +
        	":cOeEgcCont, " +
        	":nsRdclCont, " +
        	":vChkdCont, " +
        	":cTipoCont, " +
        	":cMoedIsoScta, " +
        	":nsDeposito, " +
        	":tsMovimento, " +
        	":nsMovimento, " +
        	":zValMov, " +
        	":zMovLocl, " +
        	":iDbcr, " +
        	":mMovimento, " +
        	":iEstorno, " +
        	":cMoedIsoOriMov, " +
        	":mSldoCbloApos, " +
        	":mSldoDpnlApos, " +
        	":mMovMoeOrigMov, " +
        	":xRefMov, " +
        	":nDocOpps, " +
        	":aAplOrig, " +
        	":iExisInfAdi, " +
        	":xChavAcsInfAdi, " +
        	":tsActzUlt, " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhist5().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhist5().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhist5().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhist5().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhist5().nsMovimento() ) ;
        setQueryArgument( "zValMov", movhist5().zValMov(), java.sql.Date.class ) ;
        setQueryArgument( "zMovLocl", movhist5().zMovLocl(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movhist5().iDbcr() ) ;
        setQueryArgument( "mMovimento", movhist5().mMovimento() ) ;
        setQueryArgument( "iEstorno", movhist5().iEstorno() ) ;
        setQueryArgument( "cMoedIsoOriMov", movhist5().cMoedIsoOriMov() ) ;
        setQueryArgument( "mSldoCbloApos", movhist5().mSldoCbloApos() ) ;
        setQueryArgument( "mSldoDpnlApos", movhist5().mSldoDpnlApos() ) ;
        setQueryArgument( "mMovMoeOrigMov", movhist5().mMovMoeOrigMov() ) ;
        setQueryArgument( "xRefMov", movhist5().xRefMov() ) ;
        setQueryArgument( "nDocOpps", movhist5().nDocOpps() ) ;
        setQueryArgument( "aAplOrig", movhist5().aAplOrig() ) ;
        setQueryArgument( "iExisInfAdi", movhist5().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhist5().xChavAcsInfAdi() ) ;
        setQueryArgument( "tsActzUlt", movhist5().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhist5().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02501_MOVHIST5
     * called from Pghq998a.M2650AcedeTgh25M2650AcedeTgh25
     * 
     * @param pWsDataSaldo
     */
    public void selectPghq998a2097(IString pWsDataSaldo) {
        sqlSttmt = "SELECT  " +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "C_MOED_ISO_ORI_MOV" +
            " FROM VWSDGHPS02501_MOVHIST5" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "Z_MOV_LOCL <= :wsDataSaldo" +
            " ORDER BY " +
                "Z_MOV_LOCL DESC," +
                "NS_MOVIMENTO DESC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhist5().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        setQueryArgument( "wsDataSaldo", pWsDataSaldo, java.sql.Date.class ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhist5().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs025a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void closeMghs025a614() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs025a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void closeMghs025a718() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs025a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void closeMghs025a822() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs025a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void closeMghs025a926() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs025a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs025a534() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs025a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs025a597() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs025a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs025a638() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs025a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs025a701() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs025a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs025a742() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs025a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs025a805() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs025a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs025a846() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs025a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs025a909() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist5().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist5().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist5().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist5().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist5().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist5().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist5().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist5().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist5().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist5().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist5().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist5().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist5().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist5().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist5().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist5().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist5().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist5().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist5().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist5().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist5().tJuro().set(c.getValue("T_JURO")) ;
            movhist5().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist5().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist5().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist5().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist5().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs025a.A5200ListaAscDataA5200ListaAscData
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs025a522(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02501_MOVHIST5" +
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
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "NS_MOVIMENTO >= :nsMovimento AND " +
                "TS_MOVIMENTO <= :wsTsFim" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist5().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist5().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist5().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist5().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs025a.A5300ListaAscMovA5300ListaAscMov
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs025a626(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02501_MOVHIST5" +
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
                "TS_MOVIMENTO <= :wsTsInicio AND NS_MOVIMENTO <= :nsMovimento AND " +
                "TS_MOVIMENTO >= :wsTsFim" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist5().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist5().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist5().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist5().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs025a.A5400ListaDscDataA5400ListaDscData
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs025a730(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02501_MOVHIST5" +
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
                "TS_MOVIMENTO <= :wsTsInicio AND NS_MOVIMENTO <= :nsMovimento AND " +
                "TS_MOVIMENTO >= :wsTsFim" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist5().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist5().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist5().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist5().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs025a.A5500ListaDscMovA5500ListaDscMov
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsNsMovMax
     * @param pWsNsMovMin
     */
    public void openMghs025a834(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, ILong pWsNsMovMax, ILong pWsNsMovMin) {
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
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "T_JURO," +
                "A_APL_ORIG," +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS02501_MOVHIST5" +
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
                "NS_MOVIMENTO <= :wsNsMovMax AND " +
                "NS_MOVIMENTO >= :wsNsMovMin" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist5().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist5().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist5().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist5().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist5().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist5().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist5().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist5().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsNsMovMax", pWsNsMovMax ) ;
        c.setArgument( "wsNsMovMin", pWsNsMovMin ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02501_MOVHIST5
     * called from Mghs203a.A5331ObtemTsActTgh25A5331ObtemTsActTgh25
     * 
     * @param pMovhstcp5
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a1666(Movhstcp5 pMovhstcp5, IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS02501_MOVHIST5" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "TS_MOVIMENTO <= :wsTsFim AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhstcp5.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcp5.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcp5.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcp5.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcp5.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcp5.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcp5.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcp5.nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcp5.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist5().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
}
