package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
public abstract class Vwsdghps00301Gatcnsmov extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Gatcnsmov
     */
    @Data
    public abstract Gatcnsmov gatcnsmov() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH00301_GATCNSMOV
     * 
     * @version 2.0
     * 
     */
    public interface Gatcnsmov extends IDataStruct {
        
        /**
         * NM_RECURSO
         */
        @Column(name="NM_RECURSO")
        @Key
        @Data(size=8)
        IString nmRecurso() ;
        
        /**
         * I_EST_RCRS
         */
        @Column(name="I_EST_RCRS")
        @Data(size=1)
        IString iEstRcrs() ;
        
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
     * Copybooks
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from A35000CloseCursorC1
     * 
     */
    public void closeBghp0003193() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from A32000FetchCursorC1
     * 
     */
    public void fetchBghp000370() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            gatcnsmov().iEstRcrs().set(c.getValue("I_EST_RCRS")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00301_GATCNSMOV
     * called from A34000InsTabela
     * 
     */
    public void insertBghp0003151() {
        sqlSttmt = "INSERT INTO VWSDGHPS00301_GATCNSMOV ( " +
        	"NM_RECURSO, " +
        	"I_EST_RCRS, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":nmRecurso, " +
        	":iEstRcrs, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nmRecurso", gatcnsmov().nmRecurso() ) ;
        setQueryArgument( "iEstRcrs", gatcnsmov().iEstRcrs() ) ;
        setQueryArgument( "cUsidActzUlt", gatcnsmov().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from A31000OpenCursorC1
     * 
     */
    public void openBghp000342() {
        sqlSttmt = "SELECT  " +
                "I_EST_RCRS" +
            " FROM VWSDGHPS00301_GATCNSMOV" +
            " WHERE " +
                "NM_RECURSO = :nmRecurso"  +
            " LIMIT 1" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "nmRecurso", gatcnsmov().nmRecurso() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00301_GATCNSMOV
     * called from A33000ActTabela
     * 
     */
    public void updateBghp0003110() {
        sqlSttmt = "UPDATE VWSDGHPS00301_GATCNSMOV " +
            "SET I_EST_RCRS = :iEstRcrs, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "CURRENT OF PGHQ301A_C1"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "iEstRcrs", gatcnsmov().iEstRcrs() ) ;
        setQueryArgument( "cUsidActzUlt", gatcnsmov().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00301_GATCNSMOV
     * called from Mghs003a.S3000ProcessarS3000Processar
     * 
     * @param pWsNmRecurso
     */
    public void selectMghs003a126(IString pWsNmRecurso) {
        sqlSttmt = "SELECT  " +
                "I_EST_RCRS" +
            " FROM VWSDGHPS00301_GATCNSMOV" +
            " WHERE " +
                "NM_RECURSO = :wsNmRecurso"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "wsNmRecurso", pWsNmRecurso ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            gatcnsmov().iEstRcrs().set(getQueryReturnedValue("I_EST_RCRS")) ;
        }
    }
}
