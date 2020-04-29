package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
public abstract class Vwsdghps00101Conthst extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Conthst
     */
    @Data
    public abstract Conthst conthst() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH00101_CONTHST
     * 
     * @version 2.0
     * 
     */
    public interface Conthst extends IDataStruct {
        
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
         * I_ACTIVO
         */
        @Column(name="I_ACTIVO")
        @Data(size=1)
        IString iActivo() ;
        
        /**
         * C_MOED_ISO_ANT_EUR
         */
        @Column(name="C_MOED_ISO_ANT_EUR")
        @Data(size=3)
        IString cMoedIsoAntEur() ;
        
        /**
         * Z_ABRA_CONT
         */
        @Column(name="Z_ABRA_CONT", type=java.sql.Date.class)
        @Data(size=10)
        IString zAbraCont() ;
        
        /**
         * Z_CCLT_CONT
         */
        @Column(name="Z_CCLT_CONT", type=java.sql.Date.class)
        @Data(size=10)
        IString zCcltCont() ;
        
        /**
         * Z_RABT_CONT
         */
        @Column(name="Z_RABT_CONT", type=java.sql.Date.class)
        @Data(size=10)
        IString zRabtCont() ;
        
        /**
         * Z_RABT_CONT_CCLD
         */
        @Column(name="Z_RABT_CONT_CCLD", type=java.sql.Date.class)
        @Data(size=10)
        IString zRabtContCcld() ;
        
        /**
         * Z_MOV_HIST_ULT
         */
        @Column(name="Z_MOV_HIST_ULT", type=java.sql.Date.class)
        @Data(size=10)
        IString zMovHistUlt() ;
        
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
     * called from Pghq015a.A31500CloseCursorC1A31500CloseCursorC1
     * 
     */
    public void closePghq015a940() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq081a.A31500CloseCursorC1A31500CloseCursorC1
     * 
     */
    public void closePghq081a944() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq015a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq015a769() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            conthst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            conthst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            conthst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            conthst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            conthst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            conthst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            conthst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            conthst().iActivo().set(c.getValue("I_ACTIVO")) ;
            conthst().cMoedIsoAntEur().set(c.getValue("C_MOED_ISO_ANT_EUR")) ;
            conthst().zAbraCont().set(c.getValue("Z_ABRA_CONT", String.class)) ;
            conthst().zCcltCont().set(c.getValue("Z_CCLT_CONT", String.class)) ;
            conthst().zRabtCont().set(c.getValue("Z_RABT_CONT", String.class)) ;
            conthst().zRabtContCcld().set(c.getValue("Z_RABT_CONT_CCLD", String.class)) ;
            conthst().zMovHistUlt().set(c.getValue("Z_MOV_HIST_ULT", String.class)) ;
            conthst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            conthst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq081a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq081a733() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            conthst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            conthst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            conthst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            conthst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            conthst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            conthst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            conthst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
            conthst().iActivo().set(c.getValue("I_ACTIVO")) ;
            conthst().cMoedIsoAntEur().set(c.getValue("C_MOED_ISO_ANT_EUR")) ;
            conthst().zAbraCont().set(c.getValue("Z_ABRA_CONT", String.class)) ;
            conthst().zCcltCont().set(c.getValue("Z_CCLT_CONT", String.class)) ;
            conthst().zRabtCont().set(c.getValue("Z_RABT_CONT", String.class)) ;
            conthst().zRabtContCcld().set(c.getValue("Z_RABT_CONT_CCLD", String.class)) ;
            conthst().zMovHistUlt().set(c.getValue("Z_MOV_HIST_ULT", String.class)) ;
            conthst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            conthst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00101_CONTHST
     * called from Pghq015a.A31400InsRegTgh1A31400InsRegTgh1
     * 
     */
    public void insertPghq015a872() {
        sqlSttmt = "INSERT INTO VWSDGHPS00101_CONTHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"I_ACTIVO, " +
        	"C_MOED_ISO_ANT_EUR, " +
        	"Z_ABRA_CONT, " +
        	"Z_CCLT_CONT, " +
        	"Z_RABT_CONT, " +
        	"Z_RABT_CONT_CCLD, " +
        	"Z_MOV_HIST_ULT, " +
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
        	":iActivo, " +
        	":cMoedIsoAntEur, " +
        	":zAbraCont, " +
        	":zCcltCont, " +
        	":zRabtCont, " +
        	":zRabtContCcld, " +
        	":zMovHistUlt, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", conthst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", conthst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", conthst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", conthst().nsDeposito() ) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "cMoedIsoAntEur", conthst().cMoedIsoAntEur() ) ;
        setQueryArgument( "zAbraCont", conthst().zAbraCont(), java.sql.Date.class ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        setQueryArgument( "zMovHistUlt", conthst().zMovHistUlt(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", conthst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00101_CONTHST
     * called from Pghq081a.A31400InsRegTgh1A31400InsRegTgh1
     * 
     */
    public void insertPghq081a876() {
        sqlSttmt = "INSERT INTO VWSDGHPS00101_CONTHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"I_ACTIVO, " +
        	"C_MOED_ISO_ANT_EUR, " +
        	"Z_ABRA_CONT, " +
        	"Z_CCLT_CONT, " +
        	"Z_RABT_CONT, " +
        	"Z_RABT_CONT_CCLD, " +
        	"Z_MOV_HIST_ULT, " +
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
        	":iActivo, " +
        	":cMoedIsoAntEur, " +
        	":zAbraCont, " +
        	":zCcltCont, " +
        	":zRabtCont, " +
        	":zRabtContCcld, " +
        	":zMovHistUlt, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", conthst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", conthst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", conthst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", conthst().nsDeposito() ) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "cMoedIsoAntEur", conthst().cMoedIsoAntEur() ) ;
        setQueryArgument( "zAbraCont", conthst().zAbraCont(), java.sql.Date.class ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        setQueryArgument( "zMovHistUlt", conthst().zMovHistUlt(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", conthst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq015a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     */
    public void openPghq015a741() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "I_ACTIVO," +
                "C_MOED_ISO_ANT_EUR," +
                "Z_ABRA_CONT," +
                "Z_CCLT_CONT," +
                "Z_RABT_CONT," +
                "Z_RABT_CONT_CCLD," +
                "Z_MOV_HIST_ULT," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", conthst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", conthst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", conthst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", conthst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq081a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     */
    public void openPghq081a705() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO," +
                "I_ACTIVO," +
                "C_MOED_ISO_ANT_EUR," +
                "Z_ABRA_CONT," +
                "Z_CCLT_CONT," +
                "Z_RABT_CONT," +
                "Z_RABT_CONT_CCLD," +
                "Z_MOV_HIST_ULT," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", conthst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", conthst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", conthst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", conthst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00101_CONTHST
     * called from Pghq015a.A31300ActRegTgh1A31300ActRegTgh1
     * 
     */
    public void updatePghq015a823() {
        sqlSttmt = "UPDATE VWSDGHPS00101_CONTHST " +
            "SET Z_MOV_HIST_ULT = :zMovHistUlt" +
            " WHERE " +
                "CURRENT OF PGHQ015A_C1"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "zMovHistUlt", conthst().zMovHistUlt(), java.sql.Date.class ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00101_CONTHST
     * called from Pghq081a.A31300ActRegTgh1A31300ActRegTgh1
     * 
     */
    public void updatePghq081a778() {
        sqlSttmt = "UPDATE VWSDGHPS00101_CONTHST " +
            "SET I_ACTIVO = :iActivo, " +
                "Z_CCLT_CONT = :zCcltCont, " +
                "Z_RABT_CONT = :zRabtCont, " +
                "Z_RABT_CONT_CCLD = :zRabtContCcld" +
            " WHERE " +
                "CURRENT OF PGHQ081A_C1"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00101_CONTHST
     * called from Pghq081a.A31350ActRegTgh1A31350ActRegTgh1
     * 
     */
    public void updatePghq081a823() {
        sqlSttmt = "UPDATE VWSDGHPS00101_CONTHST " +
            "SET I_ACTIVO = :iActivo, " +
                "Z_CCLT_CONT = :zCcltCont, " +
                "Z_RABT_CONT = :zRabtCont, " +
                "Z_RABT_CONT_CCLD = :zRabtContCcld" +
            " WHERE " +
                "CURRENT OF PGHQ081A_C1"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        executeUpdate() ;
    }
    /**
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq506a.A33000CloseCursorC1A33000CloseCursorC1
     * 
     */
    public void closePghq506a815() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq509a.A33000CloseCursorC1A33000CloseCursorC1
     * 
     */
    public void closePghq509a842() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Pghq520a.A33000CloseCursorC1A33000CloseCursorC1
     * 
     */
    public void closePghq520a909() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq506a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq506a576() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            conthst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            conthst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            conthst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            conthst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            conthst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            conthst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            conthst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq509a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq509a593() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            conthst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            conthst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            conthst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            conthst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            conthst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            conthst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            conthst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Pghq520a.A31200FetchCursorC1A31200FetchCursorC1
     * 
     */
    public void fetchPghq520a568() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            conthst().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            conthst().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            conthst().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            conthst().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            conthst().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
            conthst().cMoedIsoScta().set(c.getValue("C_MOED_ISO_SCTA")) ;
            conthst().nsDeposito().set(c.getValue("NS_DEPOSITO")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq506a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     */
    public void openPghq506a547() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", conthst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq509a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     * @param pWsCTipoContNostro
     * @param pWsCTipoContVostro
     */
    public void openPghq509a564(IInt pWsCTipoContNostro, IInt pWsCTipoContVostro) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_TIPO_CONT = :wsCTipoContNostro OR " +
                "C_TIPO_CONT = :wsCTipoContVostro" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "wsCTipoContNostro", pWsCTipoContNostro ) ;
        c.setArgument( "wsCTipoContVostro", pWsCTipoContVostro ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Pghq520a.A31100OpenCursorC1A31100OpenCursorC1
     * 
     */
    public void openPghq520a539() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT," +
                "C_MOED_ISO_SCTA," +
                "NS_DEPOSITO" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", conthst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", conthst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", conthst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", conthst().nsDeposito() ) ;
        c.open() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghj201a.A31000AbrirCursorC1A31000AbrirCursorC1
     * 
     */
    public void closeMghj201a177() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghj201a.A32000FetchCursorC1A32000FetchCursorC1
     * 
     */
    public void closeMghj201a206() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghj201a.A33000ActTabelaA33000ActTabela
     * 
     */
    public void closeMghj201a266() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs201a.A31000AbrirCursorC1A31000AbrirCursorC1
     * 
     */
    public void closeMghs201a180() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs201a.A32000FetchCursorC1A32000FetchCursorC1
     * 
     */
    public void closeMghs201a209() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs201a.A33000ActTabelaA33000ActTabela
     * 
     */
    public void closeMghs201a263() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghj201a.A32000FetchCursorC1A32000FetchCursorC1
     * 
     */
    public void fetchMghj201a188() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().iActivo().set(c.getValue("I_ACTIVO")) ;
            conthst().zAbraCont().set(c.getValue("Z_ABRA_CONT", String.class)) ;
            conthst().zCcltCont().set(c.getValue("Z_CCLT_CONT", String.class)) ;
            conthst().zRabtCont().set(c.getValue("Z_RABT_CONT", String.class)) ;
            conthst().zRabtContCcld().set(c.getValue("Z_RABT_CONT_CCLD", String.class)) ;
            conthst().zMovHistUlt().set(c.getValue("Z_MOV_HIST_ULT", String.class)) ;
            conthst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            conthst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs201a.A32000FetchCursorC1A32000FetchCursorC1
     * 
     */
    public void fetchMghs201a191() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().iActivo().set(c.getValue("I_ACTIVO")) ;
            conthst().zAbraCont().set(c.getValue("Z_ABRA_CONT", String.class)) ;
            conthst().zCcltCont().set(c.getValue("Z_CCLT_CONT", String.class)) ;
            conthst().zRabtCont().set(c.getValue("Z_RABT_CONT", String.class)) ;
            conthst().zRabtContCcld().set(c.getValue("Z_RABT_CONT_CCLD", String.class)) ;
            conthst().zMovHistUlt().set(c.getValue("Z_MOV_HIST_ULT", String.class)) ;
            conthst().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
            conthst().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00101_CONTHST
     * called from Mghj201a.A34000InsTabelaA34000InsTabela
     * 
     */
    public void insertMghj201a326() {
        sqlSttmt = "INSERT INTO VWSDGHPS00101_CONTHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"I_ACTIVO, " +
        	"C_MOED_ISO_ANT_EUR, " +
        	"Z_ABRA_CONT, " +
        	"Z_CCLT_CONT, " +
        	"Z_RABT_CONT, " +
        	"Z_RABT_CONT_CCLD, " +
        	"Z_MOV_HIST_ULT, " +
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
        	":iActivo, " +
        	":cMoedIsoAntEur, " +
        	":zAbraCont, " +
        	":zCcltCont, " +
        	":zRabtCont, " +
        	":zRabtContCcld, " +
        	":zMovHistUlt, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", conthst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", conthst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", conthst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", conthst().nsDeposito() ) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "cMoedIsoAntEur", conthst().cMoedIsoAntEur() ) ;
        setQueryArgument( "zAbraCont", conthst().zAbraCont(), java.sql.Date.class ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        setQueryArgument( "zMovHistUlt", conthst().zMovHistUlt(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", conthst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00101_CONTHST
     * called from Mghs201a.A34000InsTabelaA34000InsTabela
     * 
     */
    public void insertMghs201a322() {
        sqlSttmt = "INSERT INTO VWSDGHPS00101_CONTHST ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"I_ACTIVO, " +
        	"Z_ABRA_CONT, " +
        	"Z_CCLT_CONT, " +
        	"Z_RABT_CONT, " +
        	"Z_RABT_CONT_CCLD, " +
        	"Z_MOV_HIST_ULT, " +
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
        	":iActivo, " +
        	":zAbraCont, " +
        	":zCcltCont, " +
        	":zRabtCont, " +
        	":zRabtContCcld, " +
        	":zMovHistUlt, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", conthst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", conthst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", conthst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", conthst().nsDeposito() ) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "zAbraCont", conthst().zAbraCont(), java.sql.Date.class ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        setQueryArgument( "zMovHistUlt", conthst().zMovHistUlt(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", conthst().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghj201a.A31000AbrirCursorC1A31000AbrirCursorC1
     * 
     */
    public void openMghj201a168() {
        sqlSttmt = "SELECT  " +
                "I_ACTIVO," +
                "Z_ABRA_CONT," +
                "Z_CCLT_CONT," +
                "Z_RABT_CONT," +
                "Z_RABT_CONT_CCLD," +
                "Z_MOV_HIST_ULT," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", conthst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", conthst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", conthst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", conthst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs201a.A31000AbrirCursorC1A31000AbrirCursorC1
     * 
     */
    public void openMghs201a171() {
        sqlSttmt = "SELECT  " +
                "I_ACTIVO," +
                "Z_ABRA_CONT," +
                "Z_CCLT_CONT," +
                "Z_RABT_CONT," +
                "Z_RABT_CONT_CCLD," +
                "Z_MOV_HIST_ULT," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", conthst().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", conthst().vChkdCont() ) ;
        c.setArgument( "cTipoCont", conthst().cTipoCont() ) ;
        c.setArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        c.setArgument( "nsDeposito", conthst().nsDeposito() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00101_CONTHST
     * called from Mghj202a.A32000ValidarDatasCriterioA32000ValidarDatasCriterio
     * 
     */
    public void selectMghj202a419() {
        sqlSttmt = "SELECT  " +
                "I_ACTIVO," +
                "C_MOED_ISO_ANT_EUR," +
                "Z_ABRA_CONT," +
                "Z_CCLT_CONT," +
                "Z_RABT_CONT," +
                "Z_RABT_CONT_CCLD," +
                "Z_MOV_HIST_ULT" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", conthst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", conthst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", conthst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", conthst().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().iActivo().set(getQueryReturnedValue("I_ACTIVO")) ;
            conthst().cMoedIsoAntEur().set(getQueryReturnedValue("C_MOED_ISO_ANT_EUR")) ;
            conthst().zAbraCont().set(getQueryReturnedValue("Z_ABRA_CONT", String.class)) ;
            conthst().zCcltCont().set(getQueryReturnedValue("Z_CCLT_CONT", String.class)) ;
            conthst().zRabtCont().set(getQueryReturnedValue("Z_RABT_CONT", String.class)) ;
            conthst().zRabtContCcld().set(getQueryReturnedValue("Z_RABT_CONT_CCLD", String.class)) ;
            conthst().zMovHistUlt().set(getQueryReturnedValue("Z_MOV_HIST_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00101_CONTHST
     * called from Mghs001a.A5200AcederTabA5200AcederTab
     * 
     */
    public void selectMghs001a220() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "I_ACTIVO," +
                "C_MOED_ISO_ANT_EUR," +
                "Z_ABRA_CONT," +
                "Z_CCLT_CONT," +
                "Z_RABT_CONT," +
                "Z_RABT_CONT_CCLD," +
                "Z_MOV_HIST_ULT" +
            " FROM VWSDGHPS00101_CONTHST" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", conthst().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", conthst().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", conthst().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", conthst().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", conthst().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", conthst().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", conthst().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", conthst().nsDeposito() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            conthst().iActivo().set(getQueryReturnedValue("I_ACTIVO")) ;
            conthst().cMoedIsoAntEur().set(getQueryReturnedValue("C_MOED_ISO_ANT_EUR")) ;
            conthst().zAbraCont().set(getQueryReturnedValue("Z_ABRA_CONT", String.class)) ;
            conthst().zCcltCont().set(getQueryReturnedValue("Z_CCLT_CONT", String.class)) ;
            conthst().zRabtCont().set(getQueryReturnedValue("Z_RABT_CONT", String.class)) ;
            conthst().zRabtContCcld().set(getQueryReturnedValue("Z_RABT_CONT_CCLD", String.class)) ;
            conthst().zMovHistUlt().set(getQueryReturnedValue("Z_MOV_HIST_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00101_CONTHST
     * called from Mghj201a.A33000ActTabelaA33000ActTabela
     * 
     */
    public void updateMghj201a250() {
        sqlSttmt = "UPDATE VWSDGHPS00101_CONTHST " +
            "SET I_ACTIVO = :iActivo, " +
                "Z_ABRA_CONT = :zAbraCont, " +
                "Z_CCLT_CONT = :zCcltCont, " +
                "Z_RABT_CONT = :zRabtCont, " +
                "Z_RABT_CONT_CCLD = :zRabtContCcld, " +
                "Z_MOV_HIST_ULT = :zMovHistUlt, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "CURRENT OF MGHJ201A_C1"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "zAbraCont", conthst().zAbraCont(), java.sql.Date.class ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        setQueryArgument( "zMovHistUlt", conthst().zMovHistUlt(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", conthst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00101_CONTHST
     * called from Mghs201a.A33000ActTabelaA33000ActTabela
     * 
     */
    public void updateMghs201a247() {
        sqlSttmt = "UPDATE VWSDGHPS00101_CONTHST " +
            "SET I_ACTIVO = :iActivo, " +
                "Z_ABRA_CONT = :zAbraCont, " +
                "Z_CCLT_CONT = :zCcltCont, " +
                "Z_RABT_CONT = :zRabtCont, " +
                "Z_RABT_CONT_CCLD = :zRabtContCcld, " +
                "Z_MOV_HIST_ULT = :zMovHistUlt, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "CURRENT OF MGHS201A_C1"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "iActivo", conthst().iActivo() ) ;
        setQueryArgument( "zAbraCont", conthst().zAbraCont(), java.sql.Date.class ) ;
        setQueryArgument( "zCcltCont", conthst().zCcltCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtCont", conthst().zRabtCont(), java.sql.Date.class ) ;
        setQueryArgument( "zRabtContCcld", conthst().zRabtContCcld(), java.sql.Date.class ) ;
        setQueryArgument( "zMovHistUlt", conthst().zMovHistUlt(), java.sql.Date.class ) ;
        setQueryArgument( "cUsidActzUlt", conthst().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
}
