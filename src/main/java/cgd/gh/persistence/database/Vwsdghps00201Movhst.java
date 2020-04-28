package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
import cgd.gh.persistence.database.Vwsdghps10201Movhstcpl.Movhstcpl ;
import cgd.gh.structures.link.Bghl204a.Commarea.DadosOutput ;
import cgd.gh.structures.link.Bghl600a.Commarea.CamposEntrada ;
import cgd.gh.structures.work.Bghw8800 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps00201Movhst extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Movhst
     */
    @Data
    public abstract Movhst movhst() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH00201_MOVHST
     * 
     * @version 2.0
     * 
     */
    public interface Movhst extends IDataStruct {
        
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
     * extracted method to encapsulate CLOSE access to cursor CRS_VGH00201
     * called from Pghq101a.M2340CloseCrsVgh00201M2340CloseCrsVgh00201
     * 
     */
    public void closePghq101a1794() {
        BaseCursorHandler c = getCursor("CRS_VGH00201") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Pghq207a.A31700CloseCursorC3A31700CloseCursorC3
     * 
     */
    public void closePghq207a1080() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_VGH00201
     * called from Pghq101a.M2320FetchCrsVgh00201M2320FetchCrsVgh00201
     * 
     * @param pCEvenOpel
     */
    public void fetchPghq101a1714(IString pCEvenOpel) {
        BaseCursorHandler c = getCursor("CRS_VGH00201") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            pCEvenOpel.set(c.getValue("C_EVEN_OPEL")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Pghq207a.A31600FetchCursorC3A31600FetchCursorC3
     * 
     */
    public void fetchPghq207a1024() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00201_MOVHST
     * called from Pghq002a.A30001InsVgh00201MovhstA30001InsVgh00201Movhst
     * 
     */
    public void insertPghq002a1147() {
        sqlSttmt = "INSERT INTO VWSDGHPS00201_MOVHST ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "zValMov", movhst().zValMov(), java.sql.Date.class ) ;
        setQueryArgument( "zMovLocl", movhst().zMovLocl(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movhst().iDbcr() ) ;
        setQueryArgument( "mMovimento", movhst().mMovimento() ) ;
        setQueryArgument( "iEstorno", movhst().iEstorno() ) ;
        setQueryArgument( "cMoedIsoOriMov", movhst().cMoedIsoOriMov() ) ;
        setQueryArgument( "mSldoCbloApos", movhst().mSldoCbloApos() ) ;
        setQueryArgument( "mSldoDpnlApos", movhst().mSldoDpnlApos() ) ;
        setQueryArgument( "mMovMoeOrigMov", movhst().mMovMoeOrigMov() ) ;
        setQueryArgument( "xRefMov", movhst().xRefMov() ) ;
        setQueryArgument( "nDocOpps", movhst().nDocOpps() ) ;
        setQueryArgument( "aAplOrig", movhst().aAplOrig() ) ;
        setQueryArgument( "iExisInfAdi", movhst().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhst().xChavAcsInfAdi() ) ;
        setQueryArgument( "tsActzUlt", movhst().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_VGH00201
     * called from Pghq101a.M2310OpenCrsVgh00201M2310OpenCrsVgh00201
     * 
     * @param pCon4052
     * @param pCon4009
     * @param pCon4023
     * @param pCon4037
     * @param pConSx
     * @param pConGn
     * @param pConGp
     */
    public void openPghq101a1674(String pCon4052, String pCon4009, String pCon4023, String pCon4037, String pConSx, String pConGn, String pConGp) {
        sqlSttmt = "SELECT  " +
                "A.NS_DEPOSITO," +
                "A.NS_MOVIMENTO," +
                "A.I_DBCR," +
                "A.M_MOVIMENTO," +
                "A.X_REF_MOV," +
                "A.Z_VAL_MOV," +
                "A.Z_MOV_LOCL," +
                "B.C_EVEN_OPEL" +
            " FROM VWSDGHPS00201_MOVHST AS A, VWSDGHPS10201_MOVHSTCPL AS B" +
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
        BaseCursorHandler c = addCursor("CRS_VGH00201", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
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
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Pghq207a.A31500OpenCursorC3A31500OpenCursorC3
     * 
     * @param pWsTsMovFim
     * @param pWsTsMovInicio
     * @param pWsMParmPedHstMax
     * @param pWsMParmPedHstMin
     */
    public void openPghq207a995(IString pWsTsMovFim, IString pWsTsMovInicio, IDecimal pWsMParmPedHstMax, IDecimal pWsMParmPedHstMin) {
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
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "TS_MOVIMENTO <= :wsTsMovFim AND " +
                "TS_MOVIMENTO >= :wsTsMovInicio AND " +
                "M_MOVIMENTO <= :wsMParmPedHstMax AND " +
                "M_MOVIMENTO >= :wsMParmPedHstMin" +
            " ORDER BY " +
                "C_PAIS_ISOA_CONT ASC," +
                "C_BANC_CONT ASC," +
                "C_OE_EGC_CONT ASC," +
                "NS_RDCL_CONT ASC," +
                "V_CHKD_CONT ASC," +
                "C_TIPO_CONT ASC" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovInicio", pWsTsMovInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsMParmPedHstMax", pWsMParmPedHstMax ) ;
        c.setArgument( "wsMParmPedHstMin", pWsMParmPedHstMin ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq099a.A31000SelectRegistoA31000SelectRegisto
     * 
     */
    public void selectPghq099a516() {
        sqlSttmt = "SELECT  " +
                "X_REF_MOV" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq206a.A35530SelectTgh0002A35530SelectTgh0002
     * 
     * @param pMovhstcpl
     */
    public void selectPghq206a932(Movhstcpl pMovhstcpl) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "NS_DEPOSITO," +
                "C_MOED_ISO_SCTA," +
                "Z_MOV_LOCL," +
                "M_MOVIMENTO," +
                "I_DBCR," +
                "I_ESTORNO," +
                "M_SLDO_CBLO_APOS," +
                "Z_VAL_MOV," +
                "M_MOV_MOE_ORIG_MOV," +
                "C_MOED_ISO_ORI_MOV," +
                "NS_MOVIMENTO," +
                "X_REF_MOV," +
                "N_DOC_OPPS" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhstcpl.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcpl.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcpl.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcpl.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcpl.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcpl.cTipoCont() ) ;
        setQueryArgument( "nsDeposito", pMovhstcpl.nsDeposito() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcpl.cMoedIsoScta() ) ;
        setQueryArgument( "tsMovimento", pMovhstcpl.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcpl.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhst().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhst().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhst().zMovLocl().set(getQueryReturnedValue("Z_MOV_LOCL", String.class)) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movhst().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(getQueryReturnedValue("N_DOC_OPPS")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq003a.M2100TrataThg002M2100TrataThg002
     * 
     * @param pConTsAlterar
     */
    public void updatePghq003a531(IString pConTsAlterar) {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET TS_MOVIMENTO = :conTsAlterar" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "conTsAlterar", pConTsAlterar ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq022a.A30001InsVgh00201MovhstA30001InsVgh00201Movhst
     * 
     */
    public void updatePghq022a368() {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET X_CHAV_ACS_INF_ADI = :xChavAcsInfAdi, " +
                "I_EXIS_INF_ADI = :iExisInfAdi" +
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
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhst().xChavAcsInfAdi() ) ;
        setQueryArgument( "iExisInfAdi", movhst().iExisInfAdi() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq080a.A30000UpdateTabelaVgh00201A30000UpdateTabelaVgh00201
     * 
     * @param pWsTsMovimentoMin
     * @param pWsTsMovimentoMax
     */
    public void updatePghq080a692(IString pWsTsMovimentoMin, IString pWsTsMovimentoMax) {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET I_EXIS_INF_ADI = :iExisInfAdi, " +
                "X_CHAV_ACS_INF_ADI = :xChavAcsInfAdi, " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt, " +
                "TS_ACTZ_ULT = NOW()" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "TS_MOVIMENTO >= :wsTsMovimentoMin AND " +
                "TS_MOVIMENTO <= :wsTsMovimentoMax AND " +
                "N_DOC_OPPS = :nDocOpps" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "wsTsMovimentoMin", pWsTsMovimentoMin ) ;
        setQueryArgument( "wsTsMovimentoMax", pWsTsMovimentoMax, java.sql.Timestamp.class ) ;
        setQueryArgument( "nDocOpps", movhst().nDocOpps() ) ;
        setQueryArgument( "iExisInfAdi", movhst().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhst().xChavAcsInfAdi() ) ;
        setQueryArgument( "cUsidActzUlt", movhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq099a.A32000ActRegistoA32000ActRegisto
     * 
     */
    public void updatePghq099a578() {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET X_REF_MOV = :xRefMov" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "xRefMov", movhst().xRefMov() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq300a.M2100UpdVgh00201M2100UpdVgh00201
     * 
     * @param pConAplic
     * @param pNsMovimento
     * @param pWsXRefMovAux
     */
    public void updatePghq300a458(String pConAplic, ILong pNsMovimento, IString pWsXRefMovAux) {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET X_REF_MOV = :wsXRefMovAux, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "M_MOVIMENTO = :mMovimento AND " +
                "A_APL_ORIG = :conAplic AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "mMovimento", movhst().mMovimento() ) ;
        setQueryArgument( "conAplic", pConAplic ) ;
        setQueryArgument( "nsMovimento", pNsMovimento ) ;
        setQueryArgument( "wsXRefMovAux", pWsXRefMovAux ) ;
        setQueryArgument( "cUsidActzUlt", movhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq300a.M2200UpdVgh00201DstM2200UpdVgh00201Dst
     * 
     * @param pConAplic
     * @param pNsMovimento
     * @param pWsXRefMovAux
     */
    public void updatePghq300a548(String pConAplic, ILong pNsMovimento, IString pWsXRefMovAux) {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET X_REF_MOV = :wsXRefMovAux, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "M_MOVIMENTO = :mMovimento AND " +
                "A_APL_ORIG = :conAplic AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "mMovimento", movhst().mMovimento() ) ;
        setQueryArgument( "conAplic", pConAplic ) ;
        setQueryArgument( "nsMovimento", pNsMovimento ) ;
        setQueryArgument( "wsXRefMovAux", pWsXRefMovAux ) ;
        setQueryArgument( "cUsidActzUlt", movhst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS-HISTMOV
     * called from Pghq310a.M2400CloseCrsHistmovM2400CloseCrsHistmov
     * 
     */
    public void closePghq310a946() {
        BaseCursorHandler c = getCursor("CRS-HISTMOV") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq500a.A31400CloseC1A31400CloseC1
     * 
     */
    public void closePghq500a2011() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq502a.A31400CloseCursorC1A31400CloseCursorC1
     * 
     */
    public void closePghq502a839() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS-HISTMOV
     * called from Pghq310a.M2200FetchCrsHistmovM2200FetchCrsHistmov
     * 
     */
    public void fetchPghq310a742() {
        BaseCursorHandler c = getCursor("CRS-HISTMOV") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq500a.A31200FetchC1A31200FetchC1
     * 
     */
    public void fetchPghq500a896() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq502a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq502a624() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS-HISTMOV
     * called from Pghq310a.M2100OpenCrsHistmovM2100OpenCrsHistmov
     * 
     * @param pWsTsMov1Ano
     * @param pWsTsMovInicMes
     */
    public void openPghq310a706(IString pWsTsMov1Ano, IString pWsTsMovInicMes) {
        sqlSttmt = "SELECT  " +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "X_REF_MOV" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "TS_MOVIMENTO >= :wsTsMov1Ano AND " +
                "TS_MOVIMENTO < :wsTsMovInicMes" ;
        BaseCursorHandler c = addCursor("CRS-HISTMOV", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "wsTsMov1Ano", pWsTsMov1Ano, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovInicMes", pWsTsMovInicMes, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq500a.A31100OpenC1A31100OpenC1
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     */
    public void openPghq500a869(IString pWsTsInicio, IString pWsTsFim) {
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
            " FROM VWSDGHPS00201_MOVHST" +
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
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq502a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     * @param pWsTsMovFim
     * @param pWsTsMovInicio
     */
    public void openPghq502a595(IString pWsTsMovFim, IString pWsTsMovInicio) {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO," +
                "Z_VAL_MOV," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "A_APL_ORIG" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsMovFim AND " +
                "TS_MOVIMENTO >= :wsTsMovInicio" +
            " ORDER BY " +
                "NS_MOVIMENTO ASC" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovInicio", pWsTsMovInicio, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq320a.M2100ObtemDadTgh02M2100ObtemDadTgh02
     * 
     */
    public void selectPghq320a489() {
        sqlSttmt = "SELECT  " +
                "Z_MOV_LOCL," +
                "I_DBCR," +
                "M_MOVIMENTO" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().zMovLocl().set(getQueryReturnedValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq504a.A31310AcederMovHstA31310AcederMovHst
     * 
     * @param pMovhstcpl
     */
    public void selectPghq504a874(Movhstcpl pMovhstcpl) {
        sqlSttmt = "SELECT  " +
                "Z_VAL_MOV," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "A_APL_ORIG" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhstcpl.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcpl.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcpl.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcpl.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcpl.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcpl.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcpl.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcpl.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhstcpl.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcpl.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(getQueryReturnedValue("N_DOC_OPPS")) ;
            movhst().aAplOrig().set(getQueryReturnedValue("A_APL_ORIG")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq505a.A31310AcederMovHstA31310AcederMovHst
     * 
     * @param pMovhstcpl
     */
    public void selectPghq505a805(Movhstcpl pMovhstcpl) {
        sqlSttmt = "SELECT  " +
                "Z_VAL_MOV," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhstcpl.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcpl.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcpl.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcpl.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcpl.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcpl.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcpl.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcpl.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhstcpl.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcpl.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(getQueryReturnedValue("N_DOC_OPPS")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq523a.A31310AcederMovHstA31310AcederMovHst
     * 
     * @param pMovhstcpl
     */
    public void selectPghq523a1075(Movhstcpl pMovhstcpl) {
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
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "A_APL_ORIG" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhstcpl.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcpl.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcpl.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcpl.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcpl.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcpl.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcpl.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcpl.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhstcpl.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcpl.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(getQueryReturnedValue("N_DOC_OPPS")) ;
            movhst().aAplOrig().set(getQueryReturnedValue("A_APL_ORIG")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq524a.A31310AcederMovHstA31310AcederMovHst
     * 
     * @param pMovhstcpl
     */
    public void selectPghq524a803(Movhstcpl pMovhstcpl) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "Z_VAL_MOV," +
                "I_DBCR," +
                "M_MOVIMENTO," +
                "I_ESTORNO," +
                "C_MOED_ISO_ORI_MOV," +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "M_MOV_MOE_ORIG_MOV," +
                "X_REF_MOV," +
                "N_DOC_OPPS," +
                "A_APL_ORIG" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhstcpl.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcpl.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcpl.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcpl.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcpl.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcpl.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcpl.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcpl.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhstcpl.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcpl.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(getQueryReturnedValue("N_DOC_OPPS")) ;
            movhst().aAplOrig().set(getQueryReturnedValue("A_APL_ORIG")) ;
        }
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_TGH02
     * called from Pghq911a.M2540FechaCrsTgh02M2540FechaCrsTgh02
     * 
     */
    public void closePghq911a1631() {
        BaseCursorHandler c = getCursor("CRS_TGH02") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq999a.A31400CloseCursorC1A31400CloseCursorC1
     * 
     */
    public void closePghq999a626() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_TGH02
     * called from Pghq911a.M2520FetchCrsTgh02M2520FetchCrsTgh02
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
    public void fetchPghq911a1560(IString pWsCPaisIsoaCont, IInt pWsCBancCont, IInt pWsCOeEgcCont, IInt pWsNsRdclCont, IInt pWsVChkdCont, IInt pWsCTipoCont, IString pWsCMoedIsoScta, IInt pWsNsDeposito, IString pWsTsMovimento, IString pWsZValMov, IDecimal pWsMMovimento) {
        BaseCursorHandler c = getCursor("CRS_TGH02") ;
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
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq999a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq999a525() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00201_MOVHST
     * called from Pghqz02a.A30001EscreverHist002A30001EscreverHist002
     * 
     */
    public void insertPghqz02a1248() {
        sqlSttmt = "INSERT INTO VWSDGHPS00201_MOVHST ( " +
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
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "zValMov", movhst().zValMov(), java.sql.Date.class ) ;
        setQueryArgument( "zMovLocl", movhst().zMovLocl(), java.sql.Date.class ) ;
        setQueryArgument( "iDbcr", movhst().iDbcr() ) ;
        setQueryArgument( "mMovimento", movhst().mMovimento() ) ;
        setQueryArgument( "iEstorno", movhst().iEstorno() ) ;
        setQueryArgument( "cMoedIsoOriMov", movhst().cMoedIsoOriMov() ) ;
        setQueryArgument( "mSldoCbloApos", movhst().mSldoCbloApos() ) ;
        setQueryArgument( "mSldoDpnlApos", movhst().mSldoDpnlApos() ) ;
        setQueryArgument( "mMovMoeOrigMov", movhst().mMovMoeOrigMov() ) ;
        setQueryArgument( "xRefMov", movhst().xRefMov() ) ;
        setQueryArgument( "nDocOpps", movhst().nDocOpps() ) ;
        setQueryArgument( "aAplOrig", movhst().aAplOrig() ) ;
        setQueryArgument( "iExisInfAdi", movhst().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhst().xChavAcsInfAdi() ) ;
        setQueryArgument( "tsActzUlt", movhst().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", movhst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_TGH02
     * called from Pghq911a.M2510AbreCrsTgh02M2510AbreCrsTgh02
     * 
     * @param pConZFim
     * @param pConCredito
     */
    public void openPghq911a1522(String pConZFim, String pConCredito) {
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
            " FROM VWSDGHPS00201_MOVHST" +
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
        BaseCursorHandler c = addCursor("CRS_TGH02", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        c.setArgument( "conZFim", pConZFim, java.sql.Timestamp.class ) ;
        c.setArgument( "conCredito", pConCredito ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq999a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     * @param pWsTsMovFim
     * @param pWsTsMovInicio
     */
    public void openPghq999a496(IString pWsTsMovFim, IString pWsTsMovInicio) {
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
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsMovFim AND " +
                "TS_MOVIMENTO >= :wsTsMovInicio AND " +
                "X_REF_MOV = LOW_VALUES" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsMovFim", pWsTsMovFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsMovInicio", pWsTsMovInicio, java.sql.Timestamp.class ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq930a.M2100ObtemMovimentoM2100ObtemMovimento
     * 
     */
    public void selectPghq930a569() {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq931a.M2310ObtemMovimentoM2310ObtemMovimento
     * 
     */
    public void selectPghq931a940() {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghq998a.M2500AcedeTgh02M2500AcedeTgh02
     * 
     * @param pWsDataSaldo
     */
    public void selectPghq998a1788(IString pWsDataSaldo) {
        sqlSttmt = "SELECT  " +
                "M_SLDO_CBLO_APOS," +
                "M_SLDO_DPNL_APOS," +
                "C_MOED_ISO_ORI_MOV" +
            " FROM VWSDGHPS00201_MOVHST" +
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
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "wsDataSaldo", pWsDataSaldo, java.sql.Date.class ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq800a.M2320ActzXRefMovM2320ActzXRefMov
     * 
     */
    public void updatePghq800a656() {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET X_REF_MOV = :xRefMov" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "xRefMov", movhst().xRefMov() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq801a.M2200UpdateVgh00201PkM2200UpdateVgh00201Pk
     * 
     * @param pMovhst
     */
    public void updatePghq801a690(Bghw8800.Movhst pMovhst) {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET I_EXIS_INF_ADI = :iExisInfAdi, " +
                "X_CHAV_ACS_INF_ADI = :xChavAcsInfAdi" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhst.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhst.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhst.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhst.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhst.nsMovimento() ) ;
        setQueryArgument( "iExisInfAdi", movhst().iExisInfAdi() ) ;
        setQueryArgument( "xChavAcsInfAdi", movhst().xChavAcsInfAdi() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq801a.M2300UpdateVgh00201HoM2300UpdateVgh00201Ho
     * 
     * @param pMovhst
     */
    public void updatePghq801a747(Bghw8800.Movhst pMovhst) {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET I_EXIS_INF_ADI = :iExisInfAdi" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhst.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhst.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhst.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhst.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhst.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhst.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhst.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhst.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhst.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhst.nsMovimento() ) ;
        setQueryArgument( "iExisInfAdi", movhst().iExisInfAdi() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq802a.M2320ActzXRefMovM2320ActzXRefMov
     * 
     */
    public void updatePghq802a588() {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET X_REF_MOV = :xRefMov" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "xRefMov", movhst().xRefMov() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq900a.M2100ActzZMovTgh002M2100ActzZMovTgh002
     * 
     */
    public void updatePghq900a395() {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET TS_MOVIMENTO = '2012-02-22-00.00.00.000000'" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00201_MOVHST
     * called from Pghq999a.A31310AlterarRefA31310AlterarRef
     * 
     * @param pWsXRefMov
     */
    public void updatePghq999a584(IString pWsXRefMov) {
        sqlSttmt = "UPDATE VWSDGHPS00201_MOVHST " +
            "SET X_REF_MOV = :wsXRefMov" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        setQueryArgument( "wsXRefMov", pWsXRefMov ) ;
        executeUpdate() ;
    }
    /**
     * Online
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghs110a.M2424CloseC1M2424CloseC1
     * 
     */
    public void closePghs110a2329() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Pghs110a.M2434CloseC3M2434CloseC3
     * 
     */
    public void closePghs110a2472() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Pghs110a.M2444CloseC2M2444CloseC2
     * 
     */
    public void closePghs110a2615() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Pghs110a.M2454CloseC4M2454CloseC4
     * 
     */
    public void closePghs110a2758() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C5
     * called from Pghs110a.M2464CloseC5M2464CloseC5
     * 
     */
    public void closePghs110a2901() {
        BaseCursorHandler c = getCursor("C5") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C7
     * called from Pghs110a.M2474CloseC7M2474CloseC7
     * 
     */
    public void closePghs110a3044() {
        BaseCursorHandler c = getCursor("C7") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C6
     * called from Pghs110a.M2484CloseC6M2484CloseC6
     * 
     */
    public void closePghs110a3187() {
        BaseCursorHandler c = getCursor("C6") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C8
     * called from Pghs110a.M2494CloseC8M2494CloseC8
     * 
     */
    public void closePghs110a3330() {
        BaseCursorHandler c = getCursor("C8") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghs110a.M2422FetchC1M2422FetchC1
     * 
     */
    public void fetchPghs110a2250() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Pghs110a.M2432FetchC3M2432FetchC3
     * 
     */
    public void fetchPghs110a2393() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Pghs110a.M2442FetchC2M2442FetchC2
     * 
     */
    public void fetchPghs110a2536() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Pghs110a.M2452FetchC4M2452FetchC4
     * 
     */
    public void fetchPghs110a2679() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C5
     * called from Pghs110a.M2462FetchC5M2462FetchC5
     * 
     */
    public void fetchPghs110a2822() {
        BaseCursorHandler c = getCursor("C5") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C7
     * called from Pghs110a.M2472FetchC7M2472FetchC7
     * 
     */
    public void fetchPghs110a2965() {
        BaseCursorHandler c = getCursor("C7") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C6
     * called from Pghs110a.M2482FetchC6M2482FetchC6
     * 
     */
    public void fetchPghs110a3108() {
        BaseCursorHandler c = getCursor("C6") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C8
     * called from Pghs110a.M2492FetchC8M2492FetchC8
     * 
     */
    public void fetchPghs110a3251() {
        BaseCursorHandler c = getCursor("C8") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghs110a.M2421OpenC1M2421OpenC1
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a2218(IString pWsTsInicio, IString pWsTsFim, IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
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
                "NS_MOVIMENTO >= :nsMovimento AND " +
                "Z_VAL_MOV >= :wsValMovMin AND " +
                "Z_VAL_MOV <= :wsValMovMax AND " +
                "Z_VAL_MOV <> date(TS_MOVIMENTO) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Pghs110a.M2431OpenC3M2431OpenC3
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a2361(IString pWsTsInicio, IString pWsTsFim, IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
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
                "NS_MOVIMENTO >= :nsMovimento AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "Z_VAL_MOV >= :wsValMovMin AND " +
                "Z_VAL_MOV <= :wsValMovMax AND " +
                "Z_VAL_MOV <> date(TS_MOVIMENTO) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Pghs110a.M2441OpenC2M2441OpenC2
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a2504(IString pWsTsInicio, IString pWsTsFim, IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsInicio AND " +
                "TS_MOVIMENTO >= :wsTsFim AND " +
                "NS_MOVIMENTO <= :nsMovimento AND " +
                "Z_VAL_MOV <= :wsValMovMin AND " +
                "Z_VAL_MOV >= :wsValMovMax AND " +
                "Z_VAL_MOV <> date(TS_MOVIMENTO) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO DESC," +
                "NS_MOVIMENTO DESC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Pghs110a.M2451OpenC4M2451OpenC4
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a2647(IString pWsTsInicio, IString pWsTsFim, IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsInicio AND " +
                "TS_MOVIMENTO >= :wsTsFim AND " +
                "NS_MOVIMENTO <= :nsMovimento AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "Z_VAL_MOV <= :wsValMovMin AND " +
                "Z_VAL_MOV >= :wsValMovMax AND " +
                "Z_VAL_MOV <> date(TS_MOVIMENTO) AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO DESC," +
                "NS_MOVIMENTO DESC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C5
     * called from Pghs110a.M2461OpenC5M2461OpenC5
     * 
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a2790(IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO >= :nsMovimento AND " +
                "Z_VAL_MOV >= :wsValMovMin AND " +
                "Z_VAL_MOV <= :wsValMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C5", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C7
     * called from Pghs110a.M2471OpenC7M2471OpenC7
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a2933(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO >= :nsMovimento AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "Z_VAL_MOV >= :wsValMovMin AND " +
                "Z_VAL_MOV <= :wsValMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C7", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C6
     * called from Pghs110a.M2481OpenC6M2481OpenC6
     * 
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a3076(IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO <= :nsMovimento AND " +
                "Z_VAL_MOV <= :wsValMovMin AND " +
                "Z_VAL_MOV >= :wsValMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO DESC," +
                "NS_MOVIMENTO DESC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C6", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C8
     * called from Pghs110a.M2491OpenC8M2491OpenC8
     * 
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsValMovMin
     * @param pWsValMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openPghs110a3219(IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsValMovMin, IString pWsValMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO <= :nsMovimento AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "Z_VAL_MOV <= :wsValMovMin AND " +
                "Z_VAL_MOV >= :wsValMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO DESC," +
                "NS_MOVIMENTO DESC" +
            " LIMIT 12" ;
        BaseCursorHandler c = addCursor("C8", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsValMovMin", pWsValMovMin, java.sql.Date.class ) ;
        c.setArgument( "wsValMovMax", pWsValMovMax, java.sql.Date.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghs109a.M2200ObtemMovHistoricoM2200ObtemMovHistorico
     * 
     * @param pWsTsMovIni
     * @param pWsTsMovFim
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsQMovTgh2
     */
    public void selectPghs109a379(IString pWsTsMovIni, IString pWsTsMovFim, IString pWsCrit1, IString pWsCrit2, IDecimal pWsMMovMin, IDecimal pWsMMovMax, ILong pWsQMovTgh2) {
        sqlSttmt = "SELECT  " +
                "COALESCE(COUNT(*), '0')" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsMovIni || '-00.00.00.000000' AND " +
                "TS_MOVIMENTO <= :wsTsMovFim || '-23.59.59.999999' AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2) AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "wsTsMovIni", pWsTsMovIni ) ;
        setQueryArgument( "wsTsMovFim", pWsTsMovFim ) ;
        setQueryArgument( "wsCrit1", pWsCrit1 ) ;
        setQueryArgument( "wsCrit2", pWsCrit2 ) ;
        setQueryArgument( "wsMMovMin", pWsMMovMin ) ;
        setQueryArgument( "wsMMovMax", pWsMMovMax ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsQMovTgh2.set(getQueryReturnedInteger(1)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Pghs111a.M2291ObtemMovHistoricoM2291ObtemMovHistorico
     * 
     * @param pWsTsTgh1
     * @param pWsTsTgh2
     * @param pWsCrit1
     * @param pWsCrit2
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsQMovTgh2
     */
    public void selectPghs111a1421(IString pWsTsTgh1, IString pWsTsTgh2, IString pWsCrit1, IString pWsCrit2, IDecimal pWsMMovMin, IDecimal pWsMMovMax, ILong pWsQMovTgh2) {
        sqlSttmt = "SELECT  " +
                "COUNT(*)" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsTgh1 AND " +
                "TS_MOVIMENTO <= :wsTsTgh2 AND " +
                "I_DBCR IN  (:wsCrit1, :wsCrit2) AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "wsTsTgh1", pWsTsTgh1, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsTgh2", pWsTsTgh2, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsCrit1", pWsCrit1 ) ;
        setQueryArgument( "wsCrit2", pWsCrit2 ) ;
        setQueryArgument( "wsMMovMin", pWsMMovMin ) ;
        setQueryArgument( "wsMMovMax", pWsMMovMax ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pWsQMovTgh2.set(getQueryReturnedInteger(1)) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs002a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void closeMghs002a633() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C3
     * called from Mghs002a.A5300ListaAscMontanteA5300ListaAscMontante
     * 
     */
    public void closeMghs002a737() {
        BaseCursorHandler c = getCursor("C3") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C2
     * called from Mghs002a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void closeMghs002a841() {
        BaseCursorHandler c = getCursor("C2") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C4
     * called from Mghs002a.A5500ListaDscMontanteA5500ListaDscMontante
     * 
     */
    public void closeMghs002a945() {
        BaseCursorHandler c = getCursor("C4") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs092a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void closeMghs092a354() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs002a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs002a547() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs002a.A5200ListaAscDataA5200ListaAscData
     * 
     */
    public void fetchMghs002a616() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs002a.A5300ListaAscMontanteA5300ListaAscMontante
     * 
     */
    public void fetchMghs002a657() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C3
     * called from Mghs002a.A5300ListaAscMontanteA5300ListaAscMontante
     * 
     */
    public void fetchMghs002a720() {
        BaseCursorHandler c = getCursor("C3") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs002a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs002a761() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C2
     * called from Mghs002a.A5400ListaDscDataA5400ListaDscData
     * 
     */
    public void fetchMghs002a824() {
        BaseCursorHandler c = getCursor("C2") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs002a.A5500ListaDscMontanteA5500ListaDscMontante
     * 
     */
    public void fetchMghs002a865() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C4
     * called from Mghs002a.A5500ListaDscMontanteA5500ListaDscMontante
     * 
     */
    public void fetchMghs002a928() {
        BaseCursorHandler c = getCursor("C4") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs092a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void fetchMghs092a274() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs092a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void fetchMghs092a337() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(c.getValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(c.getValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(c.getValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(c.getValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(c.getValue("I_DBCR")) ;
            movhst().mMovimento().set(c.getValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(c.getValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(c.getValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(c.getValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(c.getValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(c.getValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(c.getValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(c.getValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(c.getValue("T_JURO")) ;
            movhst().aAplOrig().set(c.getValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(c.getValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(c.getValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs002a.A5200ListaAscDataA5200ListaAscData
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs002a535(IString pWsTsInicio, IString pWsTsFim, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "NS_MOVIMENTO >= :nsMovimento AND " +
                "TS_MOVIMENTO <= :wsTsFim AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C3
     * called from Mghs002a.A5300ListaAscMontanteA5300ListaAscMontante
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs002a645(IString pWsTsInicio, IString pWsTsFim, IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsInicio AND " +
                "NS_MOVIMENTO >= :nsMovimento AND " +
                "TS_MOVIMENTO <= :wsTsFim AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO ASC," +
                "NS_MOVIMENTO ASC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C3", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C2
     * called from Mghs002a.A5400ListaDscDataA5400ListaDscData
     * 
     * @param pWsTsInicio
     * @param pWsTsFim
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs002a749(IString pWsTsInicio, IString pWsTsFim, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsInicio AND " +
                "NS_MOVIMENTO <= :nsMovimento AND " +
                "TS_MOVIMENTO >= :wsTsFim AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO DESC," +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C2", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C4
     * called from Mghs002a.A5500ListaDscMontanteA5500ListaDscMontante
     * 
     * @param pWsTsInicio
     * @param pWsMMovMin
     * @param pWsMMovMax
     * @param pWsTsFim
     * @param pWsCrit1
     * @param pWsCrit2
     */
    public void openMghs002a853(IString pWsTsInicio, IDecimal pWsMMovMin, IDecimal pWsMMovMax, IString pWsTsFim, IString pWsCrit1, IString pWsCrit2) {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO <= :wsTsInicio AND " +
                "NS_MOVIMENTO <= :nsMovimento AND " +
                "M_MOVIMENTO >= :wsMMovMin AND " +
                "M_MOVIMENTO <= :wsMMovMax AND " +
                "TS_MOVIMENTO >= :wsTsFim AND " +
                "(I_DBCR = :wsCrit1 OR I_DBCR = :wsCrit2)" +
            " ORDER BY " +
                "TS_MOVIMENTO DESC," +
                "NS_MOVIMENTO DESC" +
            " LIMIT 13" ;
        BaseCursorHandler c = addCursor("C4", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.setArgument( "wsTsInicio", pWsTsInicio, java.sql.Timestamp.class ) ;
        c.setArgument( "nsMovimento", movhst().nsMovimento() ) ;
        c.setArgument( "wsMMovMin", pWsMMovMin ) ;
        c.setArgument( "wsMMovMax", pWsMMovMax ) ;
        c.setArgument( "wsTsFim", pWsTsFim, java.sql.Timestamp.class ) ;
        c.setArgument( "wsCrit1", pWsCrit1 ) ;
        c.setArgument( "wsCrit2", pWsCrit2 ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs092a.A5200AcedeTabelaA5200AcedeTabela
     * 
     */
    public void openMghs092a262() {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " ORDER BY " +
                "NS_MOVIMENTO DESC" +
            " LIMIT 30" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", movhst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", movhst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", movhst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", movhst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghj204a.A31600Select002A31600Select002
     * 
     * @param pMovhstcpl
     * @param pDadosOutput
     */
    public void selectMghj204a446(Movhstcpl pMovhstcpl, DadosOutput pDadosOutput) {
        sqlSttmt = "SELECT  " +
                "N_DOC_OPPS" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pMovhstcpl.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcpl.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcpl.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcpl.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcpl.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcpl.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcpl.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcpl.nsDeposito() ) ;
        setQueryArgument( "tsMovimento", pMovhstcpl.tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", pMovhstcpl.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pDadosOutput.nChequeO().set(getQueryReturnedValue("N_DOC_OPPS")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghj204a.A21300Select002A21300Select002
     * 
     */
    public void selectMghj204a525() {
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO," +
                "NS_MOVIMENTO" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "N_DOC_OPPS = :nDocOpps" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "nDocOpps", movhst().nDocOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghj207a.A5200AcederTabelaA5200AcederTabela
     * 
     */
    public void selectMghj207a156() {
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
            " FROM VWSDGHPS00201_MOVHST" +
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
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(getQueryReturnedValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(getQueryReturnedValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(getQueryReturnedValue("T_JURO")) ;
            movhst().aAplOrig().set(getQueryReturnedValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(getQueryReturnedValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(getQueryReturnedValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghj600a.M2100SelectAbM2100SelectAb
     * 
     * @param pCamposEntrada
     * @param pMovhstcpl
     */
    public void selectMghj600a195(CamposEntrada pCamposEntrada, Movhstcpl pMovhstcpl) {
        sqlSttmt = "SELECT  " +
                "A.Z_VAL_MOV," +
                "A.M_MOVIMENTO," +
                "A.M_MOV_MOE_ORIG_MOV," +
                "B.T_CAMBIO" +
            " FROM VWSDGHPS00201_MOVHST AS A, VWSDGHPS10201_MOVHSTCPL AS B" +
            " WHERE " +
                "'1' = '1' AND A.C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "A.C_BANC_CONT = :cBancCont AND " +
                "A.C_OE_EGC_CONT = :cOeEgcCont AND " +
                "A.NS_RDCL_CONT = :nsRdclCont AND " +
                "A.V_CHKD_CONT = :vChkdCont AND " +
                "A.C_TIPO_CONT = :cTipoCont AND " +
                "A.C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "A.NS_DEPOSITO = :nsDeposito AND " +
                "A.Z_MOV_LOCL = :zMovLocl AND " +
                "A.C_PAIS_ISOA_CONT = B.C_PAIS_ISOA_CONT AND " +
                "A.C_BANC_CONT = B.C_BANC_CONT AND " +
                "A.C_OE_EGC_CONT = B.C_OE_EGC_CONT AND " +
                "A.NS_RDCL_CONT = B.NS_RDCL_CONT AND " +
                "A.V_CHKD_CONT = B.V_CHKD_CONT AND " +
                "A.C_TIPO_CONT = B.C_TIPO_CONT AND " +
                "A.NS_DEPOSITO = B.NS_DEPOSITO AND " +
                "A.C_MOED_ISO_SCTA = B.C_MOED_ISO_SCTA AND " +
                "A.TS_MOVIMENTO = B.TS_MOVIMENTO AND " +
                "A.NS_MOVIMENTO = B.NS_MOVIMENTO AND " +
                "B.N_JOUR_BBN = :nJourBbn AND " +
                "B.NS_JOUR_BBN = :nsJourBbn" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", pCamposEntrada.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pCamposEntrada.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pCamposEntrada.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pCamposEntrada.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pCamposEntrada.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pCamposEntrada.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pCamposEntrada.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pCamposEntrada.nsDeposito() ) ;
        setQueryArgument( "zMovLocl", pCamposEntrada.zMovLocl(), java.sql.Date.class ) ;
        setQueryArgument( "nJourBbn", pCamposEntrada.nJourBbn() ) ;
        setQueryArgument( "nsJourBbn", pCamposEntrada.nsJourBbn() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            pMovhstcpl.tCambio().set(getQueryReturnedValue("T_CAMBIO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghs004a.A5200AcederTabelaA5200AcederTabela
     * 
     */
    public void selectMghs004a208() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_MOVIMENTO" +
            " FROM VWSDGHPS00201_MOVHST" +
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
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghs102a.A5411ObtemTsActzA5411ObtemTsActz
     * 
     * @param pMovhstcpl
     */
    public void selectMghs102a793(Movhstcpl pMovhstcpl) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS00201_MOVHST" +
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
        setQueryArgument( "cPaisIsoaCont", pMovhstcpl.cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", pMovhstcpl.cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", pMovhstcpl.cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", pMovhstcpl.nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", pMovhstcpl.vChkdCont() ) ;
        setQueryArgument( "cTipoCont", pMovhstcpl.cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", pMovhstcpl.cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", pMovhstcpl.nsDeposito() ) ;
        setQueryArgument( "nsMovimento", pMovhstcpl.nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghs200a.A5200AcederTabelaA5200AcederTabela
     * 
     */
    public void selectMghs200a157() {
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
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO = :tsMovimento AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", movhst().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            movhst().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            movhst().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            movhst().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            movhst().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            movhst().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
            movhst().cMoedIsoScta().set(getQueryReturnedValue("C_MOED_ISO_SCTA")) ;
            movhst().nsDeposito().set(getQueryReturnedValue("NS_DEPOSITO")) ;
            movhst().tsMovimento().set(getQueryReturnedValue("TS_MOVIMENTO", String.class)) ;
            movhst().nsMovimento().set(getQueryReturnedValue("NS_MOVIMENTO")) ;
            movhst().zValMov().set(getQueryReturnedValue("Z_VAL_MOV", String.class)) ;
            movhst().zMovLocl().set(getQueryReturnedValue("Z_MOV_LOCL", String.class)) ;
            movhst().iDbcr().set(getQueryReturnedValue("I_DBCR")) ;
            movhst().mMovimento().set(getQueryReturnedValue("M_MOVIMENTO")) ;
            movhst().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
            movhst().cMoedIsoOriMov().set(getQueryReturnedValue("C_MOED_ISO_ORI_MOV")) ;
            movhst().mSldoCbloApos().set(getQueryReturnedValue("M_SLDO_CBLO_APOS")) ;
            movhst().mSldoDpnlApos().set(getQueryReturnedValue("M_SLDO_DPNL_APOS")) ;
            movhst().mMovMoeOrigMov().set(getQueryReturnedValue("M_MOV_MOE_ORIG_MOV")) ;
            movhst().xRefMov().set(getQueryReturnedValue("X_REF_MOV")) ;
            movhst().nDocOpps().set(getQueryReturnedValue("N_DOC_OPPS")) ;
            movhst().tJuro().set(getQueryReturnedValue("T_JURO")) ;
            movhst().aAplOrig().set(getQueryReturnedValue("A_APL_ORIG")) ;
            movhst().iExisInfAdi().set(getQueryReturnedValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(getQueryReturnedValue("X_CHAV_ACS_INF_ADI", String.class)) ;
            movhst().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            movhst().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00201_MOVHST
     * called from Mghs902a.A5200AcederTabelaA5200AcederTabela
     * 
     * @param pWsTsMovimentoMin
     * @param pWsTsMovimentoMax
     */
    public void selectMghs902a179(IString pWsTsMovimentoMin, IString pWsTsMovimentoMax) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "I_EXIS_INF_ADI," +
                "X_CHAV_ACS_INF_ADI" +
            " FROM VWSDGHPS00201_MOVHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "TS_MOVIMENTO >= :wsTsMovimentoMin AND " +
                "TS_MOVIMENTO <= :wsTsMovimentoMax AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", movhst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", movhst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", movhst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", movhst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", movhst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", movhst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", movhst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", movhst().nsDeposito() ) ;
        setQueryArgument( "wsTsMovimentoMin", pWsTsMovimentoMin, java.sql.Timestamp.class ) ;
        setQueryArgument( "wsTsMovimentoMax", pWsTsMovimentoMax, java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", movhst().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            movhst().iExisInfAdi().set(getQueryReturnedValue("I_EXIS_INF_ADI")) ;
            movhst().xChavAcsInfAdi().set(getQueryReturnedValue("X_CHAV_ACS_INF_ADI", String.class)) ;
        }
    }
}
