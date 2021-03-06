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
import cgd.gh.persistence.database.Vwsdghps12801Movhstcp8.Movhstcp8 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps02801Movhist8 extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhist8
     */
    @Data
    public abstract Movhist8 movhist8() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH02801_MOVHIST8
     * 
     * @version 2.0
     * 
     */
    public interface Movhist8 extends IDataStruct {
        
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
     * called from Pghq028a.A31400CloseC1A31400CloseC1
     * 
     */
    public void closePghq028a1831() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_VGH02801
     * called from Pghq101a.M2940CloseCrsVgh02801M2940CloseCrsVgh02801
     * 
     */
    public void closePghq101a2961() {
        BaseCursorHandler c = getCursor("CRS_VGH02801") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq028a.A31200FetchC1A31200FetchC1
     * 
     */
    public void fetchPghq028a845() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_VGH02801
     * called from Pghq101a.M2920FetchCrsVgh02801M2920FetchCrsVgh02801
     * 
     * @param pCEvenOpel
     */
    public void fetchPghq101a2881(IString pCEvenOpel) {
        BaseCursorHandler c = getCursor("CRS_VGH02801") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            pCEvenOpel.set(c.getValue("C_EVEN_OPEL")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq028a.A31100OpenC1A31100OpenC1
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openPghq028a818(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        c.setArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist8().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist8().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_VGH02801
     * called from Pghq101a.M2910OpenCrsVgh02801M2910OpenCrsVgh02801
     * 
     * @param pCon4052
     * @param pCon4009
     * @param pCon4023
     * @param pCon4037
     * @param pConSx
     * @param pConGn
     * @param pConGp
     */
    public void openPghq101a2841(String pCon4052, String pCon4009, String pCon4023, String pCon4037, String pConSx, String pConGn, String pConGp) {
        sqlSttmt = "SELECT  " +
                "A.NS_DEPOSITO," +
                "A.NS_MOVIMENTO," +
                "A.I_DBCR," +
                "A.M_MOVIMENTO," +
                "A.X_REF_MOV," +
                "A.Z_VAL_MOV," +
                "A.Z_MOV_LOCL," +
                "B.C_EVEN_OPEL" +
            " FROM VWSDGHPS02801_MOVHIST8 AS A, VWSDGHPS12801_MOVHSTCP8 AS B" +
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
        BaseCursorHandler c = addCursor("CRS_VGH02801", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist8().cTipoCont() ) ;
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
     * extracted method to encapsulate CLOSE access to cursor CRS_TGH28
     * called from Pghq911a.M2240FechaCrsTgh28M2240FechaCrsTgh28
     * 
     */
    public void closePghq911a1067() {
        BaseCursorHandler c = getCursor("CRS_TGH28") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_TGH28
     * called from Pghq911a.M2220FetchCrsTgh28M2220FetchCrsTgh28
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
    public void fetchPghq911a996(IString pWsCPaisIsoaCont, IInt pWsCBancCont, IInt pWsCOeEgcCont, IInt pWsNsRdclCont, IInt pWsVChkdCont, IInt pWsCTipoCont, IString pWsCMoedIsoScta, IInt pWsNsDeposito, IString pWsTsMovimento, IString pWsZValMov, IDecimal pWsMMovimento) {
        BaseCursorHandler c = getCursor("CRS_TGH28") ;
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
     * extracted method to encapsulate INSERT access to table VGH02801_MOVHIST8
     * called from Pghqz02a.A30002EscreverHist028A30002EscreverHist028
     * 
     */
    public void insertPghqz02a1365() {
        sqlSttmt = "INSERT INTO VWSDGHPS02801_MOVHIST8 ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhist8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhist8().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhist8().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhist8().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhist8().nsMovimento() ) ;
        setQueryArgument( "zValMov", movhist8().zValMov(), java.sql.Date.class ) ;
        setQueryArgument( "zMovLocl", movhist8().zMovLocl(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movhist8().iDbcr() ) ;
        setQueryArgument( "mMovimento", movhist8().mMovimento() ) ;
        setQueryArgument( "iEstorno", movhist8().iEstorno() ) ;
        setQueryArgument( "cMoedIsoOriMov", movhist8().cMoedIsoOriMov() ) ;
        setQueryArgument( "mSldoCbloApos", movhist8().mSldoCbloApos() ) ;
        setQueryArgument( "mSldoDpnlApos", movhist8().mSldoDpnlApos() ) ;
        setQueryArgument( "mMovMoeOrigMov", movhist8().mMovMoeOrigMov() ) ;
        setQueryArgument( "xRefMov", movhist8().xRefMov() ) ;
        setQueryArgument( "nDocOpps", movhist8().nDocOpps() ) ;
        setQueryArgument( "aAplOrig", movhist8().aAplOrig() ) ;
        setQueryArgument( "iExisInfAdi", movhist8().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhist8().xChavAcsInfAdi() ) ;
        setQueryArgument( "tsActzUlt", movhist8().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhist8().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_TGH28
     * called from Pghq911a.M2210AbreCrsTgh28M2210AbreCrsTgh28
     * 
     * @param pConZFim
     * @param pConCredito
     */
    public void openPghq911a958(String pConZFim, String pConCredito) {
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
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        BaseCursorHandler c = addCursor("CRS_TGH28", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist8().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist8().nsDeposito() ) ;
        c.setArgument( "tsMovimento", movhist8().tsMovimento(), java.sql.Timestamp.class ) ;
        c.setArgument( "conZFim", pConZFim, java.sql.Timestamp.class ) ;
        c.setArgument( "conCredito", pConCredito ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH02801_MOVHIST8
     * called from Pghq998a.M2800AcedeTgh28M2800AcedeTgh28
     * 
     * @param pWsDataSaldo
     */
    public void selectPghq998a2406(IString pWsDataSaldo) {
        sqlSttmt = "SELECT  " +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "C_MOED_ISO_ORI_MOV" +
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        setQueryArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhist8().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        setQueryArgument( "wsDataSaldo", pWsDataSaldo, java.sql.Date.class ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhist8().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs028a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void closeMghs028a614() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs028a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void closeMghs028a718() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs028a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void closeMghs028a822() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs028a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void closeMghs028a926() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs028a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs028a534() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs028a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs028a597() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs028a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs028a638() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs028a.A5300ListaAscMovA5300ListaAscMov
     * 
     */
    public void fetchMghs028a701() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs028a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs028a742() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs028a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs028a805() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs028a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs028a846() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs028a.A5500ListaDscMovA5500ListaDscMov
     * 
     */
    public void fetchMghs028a909() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhist8().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhist8().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhist8().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhist8().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhist8().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhist8().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhist8().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhist8().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhist8().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhist8().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhist8().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhist8().iDbcr().set(c.getValue("I_DBCR")) ;
            movhist8().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhist8().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhist8().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhist8().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhist8().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhist8().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhist8().xRefMov().set(c.getValue("X_REF_MOV", String.class)) ;
            movhist8().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhist8().tJuro().set(c.getValue("T_JURO")) ;
            movhist8().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhist8().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhist8().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhist8().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhist8().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs028a.A5200ListaAscDataA5200ListaAscData
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs028a522(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        c.setArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist8().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist8().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist8().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs028a.A5300ListaAscMovA5300ListaAscMov
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs028a626(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        c.setArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist8().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist8().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist8().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs028a.A5400ListaDscDataA5400ListaDscData
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openMghs028a730(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        c.setArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist8().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist8().nsDeposito() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhist8().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs028a.A5500ListaDscMovA5500ListaDscMov
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsNsMovMax
     * @param pWsNsMovMin
     */
    public void openMghs028a834(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2, ILong pWsNsMovMax, ILong pWsNsMovMin) {
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
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        c.setArgument( "cPaisIsoaCont", movhist8().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhist8().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhist8().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhist8().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhist8().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhist8().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhist8().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhist8().nsDeposito() ) ;
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
     * extracted method to encapsulate SELECT access to table VGH02801_MOVHIST8
     * called from Mghs203a.A5631ObtemTsActTgh28A5631ObtemTsActTgh28
     * 
     * @param pMovhstcp8
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void selectMghs203a3154(Movhstcp8 pMovhstcp8, IString pWsTsInicio, IString pWsTsFim) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS02801_MOVHIST8" +
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
        setQueryArgument( "cPaisIsoaCont", pMovhstcp8.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcp8.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcp8.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcp8.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcp8.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcp8.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcp8.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcp8.nsDeposito() ) ;
        setQueryArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcp8.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhist8().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
}
