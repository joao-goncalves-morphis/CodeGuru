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
import cgd.gh.persistence.database.Vwsdghps12701Movhstcp7.Movhstcp7 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps02701Movhist7 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhist7
     */
    @Data
    public abstract Movhist7 movhist7() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH02701_MOVHIST7
     * 
     * @version 2.0
     * 
     */
    public interface Movhist7 extends IDataStruct {
        
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
        @Column(name="X_REF_MOV")
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
     * called from Pghq027a.A31400CloseC1A31400CloseC1
     * 
     */
    public void closePghq027a1827() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_VGH02701
     * called from Pghq101a.M2840CloseCrsVgh02701M2840CloseCrsVgh02701
     * 
     */
    public void closePghq101a2766() {
        BaseCursorHandler c = getCursor("CRS_VGH02701") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq027a.A31200FetchC1A31200FetchC1
     * 
     */
    public void fetchPghq027a846() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_VGH02701
     * called from Pghq101a.M2820FetchCrsVgh02701M2820FetchCrsVgh02701
     * 
     * @param pCEvenOpel
     */
    public void fetchPghq101a2686(IString pCEvenOpel) {
        BaseCursorHandler c = getCursor("CRS_VGH02701") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            pCEvenOpel.set(c.getValue("C_EVEN_OPEL")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq027a.A31100OpenC1A31100OpenC1
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openPghq027a819(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02701_MOVHIST7" +
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
        c.setArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist7().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist7().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist7().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_VGH02701
     * called from Pghq101a.M2810OpenCrsVgh02701M2810OpenCrsVgh02701
     * 
     * @param pCon4052
     * @param pCon4009
     * @param pCon4023
     * @param pCon4037
     * @param pConSx
     * @param pConGn
     * @param pConGp
     */
    public void openPghq101a2646(String pCon4052, String pCon4009, String pCon4023, String pCon4037, String pConSx, String pConGn, String pConGp) {
        sqlSttmt = "SELECT  " +
                "A.NS_DEPOSITO," +
                "A.NS_MOVIMENTO," +
                "A.I_DBCR," +
                "A.M_MOVIMENTO," +
                "A.X_REF_MOV," +
                "A.Z_VAL_MOV," +
                "A.Z_MOV_LOCL," +
                "B.C_EVEN_OPEL" +
            " FROM VWSDGHPS02701_MOVHIST7 AS A, VWSDGHPS12701_MOVHSTCP7 AS B" +
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
        BaseCursorHandler c = addCursor("CRS_VGH02701", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist7().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist7().cTipoCont() ) ;
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
     * extracted method to encapsulate CLOSE access to cursor CRS_TGH27
     * called from Pghq911a.M2340FechaCrsTgh27M2340FechaCrsTgh27
     * 
     */
    public void closePghq911a1255() {
        BaseCursorHandler c = getCursor("CRS_TGH27") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_TGH27
     * called from Pghq911a.M2320FetchCrsTgh27M2320FetchCrsTgh27
     * 
     * @param pWsCPaisIsoaCont
     * @param pWsCBancCont
     * @param pWsCOeEgcCont
     * @param pWsNsRdclCont
     * @param pWsVChkdCont
     * @param pWsCTipoCont
     * @param pWsCMoedIsoScta
     * @param pWsNsDeposito
     * @param pWsTsMovimento
     * @param pWsZValMov
     * @param pWsMMovimento
     */
    public void fetchPghq911a1184(IString pWsCPaisIsoaCont, IInt pWsCBancCont, IInt pWsCOeEgcCont, IInt pWsNsRdclCont, IInt pWsVChkdCont, IInt pWsCTipoCont, IString pWsCMoedIsoScta, IInt pWsNsDeposito, IString pWsTsMovimento, IString pWsZValMov, IDecimal pWsMMovimento) {
        BaseCursorHandler c = getCursor("CRS_TGH27") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsCPaisIsoaCont.set(c.getValue("C_PAIS_ISOA_CONT")) ;
            pWsCBancCont.set(c.getValue("C_BANC_CONT")) ;
            pWsCOeEgcCont.set(c.getValue("C_OE_EGC_CONT")) ;
            pWsNsRdclCont.set(c.getValue("NS_RDCL_CONT")) ;
            pWsVChkdCont.set(c.getValue("V_CHKD_CONT")) ;
            pWsCTipoCont.set(c.getValue("C_TIPO_CONT")) ;
            pWsCMoedIsoScta.set(c.getValue("C_MOED_ISO_SCTA")) ;
            pWsNsDeposito.set(c.getValue("NS_DEPOSITO")) ;
            pWsTsMovimento.set(c.getValue("TS_MOVIMENTO", String.class)) ;
            pWsZValMov.set(c.getValue("Z_VAL_MOV", String.class)) ;
            pWsMMovimento.set(c.getValue("M_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH02701_MOVHIST7
     * called from Pghqz02a.A30007EscreverHist027A30007EscreverHist027
     * 
     */
    public void insertPghqz02a1951() {
        sqlSttmt = "INSERT INTO VWSDGHPS02701_MOVHIST7 ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhist7().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhist7().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhist7().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhist7().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhist7().nsMovimento() ) ;
        setQueryArgument( "zValMov", movhist7().zValMov(), java.sql.Date.class ) ;
        setQueryArgument( "zMovLocl", movhist7().zMovLocl(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movhist7().iDbcr() ) ;
        setQueryArgument( "mMovimento", movhist7().mMovimento() ) ;
        setQueryArgument( "iEstorno", movhist7().iEstorno() ) ;
        setQueryArgument( "cMoedIsoOriMov", movhist7().cMoedIsoOriMov() ) ;
        setQueryArgument( "mSldoCbloApos", movhist7().mSldoCbloApos() ) ;
        setQueryArgument( "mSldoDpnlApos", movhist7().mSldoDpnlApos() ) ;
        setQueryArgument( "mMovMoeOrigMov", movhist7().mMovMoeOrigMov() ) ;
        setQueryArgument( "xRefMov", movhist7().xRefMov() ) ;
        setQueryArgument( "nDocOpps", movhist7().nDocOpps() ) ;
        setQueryArgument( "aAplOrig", movhist7().aAplOrig() ) ;
        setQueryArgument( "iExisInfAdi", movhist7().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhist7().xChavAcsInfAdi() ) ;
        setQueryArgument( "tsActzUlt", movhist7().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhist7().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_TGH27
     * called from Pghq911a.M2310AbreCrsTgh27M2310AbreCrsTgh27
     * 
     * @param pConZFim
     * @param pConCredito
     */
    public void openPghq911a1146(String pConZFim, String pConCredito) {
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
                "Z_VAL_MOV," +
                "M_MOVIMENTO" +
            " FROM VWSDGHPS02701_MOVHIST7" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :tsMovimento AND " +
                "TS_MOVIMENTO < :conZFim AND " +
                "I_DBCR = :conCredito" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("CRS_TGH27", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist7().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist7().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist7().nsDeposito() ) ;
        c.setArgument( "tsMovimento", movhist7().tsMovimento(), java.sql.Timestamp.class ) ;
        c.setArgument( "conZFim", pConZFim, java.sql.Timestamp.class ) ;
        c.setArgument( "conCredito", pConCredito ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02701_MOVHIST7
     * called from Pghq998a.M2750AcedeTgh27M2750AcedeTgh27
     * 
     * @param pWsDataSaldo
     */
    public void selectPghq998a2303(IString pWsDataSaldo) {
        sqlSttmt = "SELECT  " +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "C_MOED_ISO_ORI_MOV" +
            " FROM VWSDGHPS02701_MOVHIST7" +
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
        setQueryArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhist7().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        setQueryArgument( "wsDataSaldo", pWsDataSaldo, java.sql.Date.class ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhist7().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs027a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void closeMghs027a614() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs027a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void closeMghs027a718() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs027a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void closeMghs027a822() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs027a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void closeMghs027a926() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs027a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs027a534() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs027a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs027a597() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs027a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs027a638() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs027a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs027a701() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs027a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs027a742() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs027a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs027a805() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs027a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs027a846() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs027a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs027a909() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist7().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist7().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist7().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist7().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist7().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist7().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist7().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist7().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist7().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist7().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist7().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist7().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist7().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist7().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist7().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist7().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist7().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist7().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist7().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhist7().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist7().tJuro().set(c.getValue("T_JURO")) ;
            movhist7().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist7().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist7().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist7().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist7().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs027a.A5200ListaAscDataA5200ListaAscData
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs027a522(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02701_MOVHIST7" +
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
        c.setArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist7().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist7().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist7().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist7().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs027a.A5300ListaAscMovA5300ListaAscMov
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs027a626(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02701_MOVHIST7" +
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
        c.setArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist7().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist7().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist7().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist7().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs027a.A5400ListaDscDataA5400ListaDscData
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs027a730(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02701_MOVHIST7" +
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
        c.setArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist7().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist7().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist7().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist7().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs027a.A5500ListaDscMovA5500ListaDscMov
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsNsMovMax
     * @param pWsNsMovMin
     */
    public void openMghs027a834(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, ILong pWsNsMovMax, ILong pWsNsMovMin) {
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
            " FROM VWSDGHPS02701_MOVHIST7" +
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
        c.setArgument( "cPaisIsoaCont", movhist7().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist7().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist7().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist7().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist7().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist7().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist7().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist7().nsDeposito() ) ;
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
     * extracted method to encapsulate SELECT access to table VGH02701_MOVHIST7
     * called from Mghs203a.A5531ObtemTsActTgh27A5531ObtemTsActTgh27
     * 
     * @param pMovhstcp7
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a2657(Movhstcp7 pMovhstcp7, IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS02701_MOVHIST7" +
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
        setQueryArgument( "cPaisIsoaCont", pMovhstcp7.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcp7.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcp7.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcp7.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcp7.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcp7.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcp7.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcp7.nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcp7.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist7().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
}
