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
public abstract class Vwsdhops11901Dcvoespl extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Dcvoespl
     */
    @Data
    public abstract Dcvoespl dcvoespl() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO11901_DCVOESPL
     * 
     * @version 2.0
     * 
     */
    public interface Dcvoespl extends IDataStruct {
        
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
         * I_DBCR
         */
        @Column(name="I_DBCR")
        @Data(size=1)
        IString iDbcr() ;
        
        /**
         * C_DCVO_ESPL
         */
        @Column(name="C_DCVO_ESPL")
        @Data(size=3)
        IString cDcvoEspl() ;
        
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
     * extracted method to encapsulate SELECT access to table VHO11901_DCVOESPL
     * called from Mghj801a.A5300AcederDescEspecialA5300AcederDescEspecial
     * 
     */
    public void selectMghj801a238() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_DCVO_ESPL" +
            " FROM VWSDHOPS11901_DCVOESPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "I_DBCR = :iDbcr" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", dcvoespl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", dcvoespl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", dcvoespl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", dcvoespl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", dcvoespl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", dcvoespl().cTipoCont() ) ;
        setQueryArgument( "iDbcr", dcvoespl().iDbcr() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            dcvoespl().cDcvoEspl().set(getQueryReturnedValue("C_DCVO_ESPL")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO11901_DCVOESPL
     * called from Mghs801a.A5300AcederDescEspecialA5300AcederDescEspecial
     * 
     */
    public void selectMghs801a327() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_DCVO_ESPL" +
            " FROM VWSDHOPS11901_DCVOESPL" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "I_DBCR = :iDbcr" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", dcvoespl().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", dcvoespl().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", dcvoespl().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", dcvoespl().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", dcvoespl().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", dcvoespl().cTipoCont() ) ;
        setQueryArgument( "iDbcr", dcvoespl().iDbcr() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            dcvoespl().cDcvoEspl().set(getQueryReturnedValue("C_DCVO_ESPL")) ;
        }
    }
}
