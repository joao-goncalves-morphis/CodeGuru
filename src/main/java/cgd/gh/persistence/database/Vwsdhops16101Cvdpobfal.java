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
public abstract class Vwsdhops16101Cvdpobfal extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Cvdpobfal
     */
    @Data
    public abstract Cvdpobfal cvdpobfal() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHO16101_CVDPOBFAL
     * 
     * @version 2.0
     * 
     */
    public interface Cvdpobfal extends IDataStruct {
        
        /**
         * N_CONTA
         */
        @Column(name="N_CONTA")
        @Data(size=13, signed=true, compression=COMP3)
        ILong nConta() ;
        
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
        
    }
    
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO16101_CVDPOBFAL
     * called from Mghs001a.A5210AcederHoA5210AcederHo
     * 
     */
    public void selectMghs001a293() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT" +
            " FROM VWSDHOPS16101_CVDPOBFAL" +
            " WHERE " +
                "N_CONTA = :nConta"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nConta", cvdpobfal().nConta() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            cvdpobfal().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            cvdpobfal().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            cvdpobfal().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            cvdpobfal().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            cvdpobfal().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            cvdpobfal().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO16101_CVDPOBFAL
     * called from Mghs113a.A5009AcederHoA5009AcederHo
     * 
     */
    public void selectMghs113a322() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT" +
            " FROM VWSDHOPS16101_CVDPOBFAL" +
            " WHERE " +
                "N_CONTA = :nConta"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nConta", cvdpobfal().nConta() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            cvdpobfal().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            cvdpobfal().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            cvdpobfal().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            cvdpobfal().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            cvdpobfal().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            cvdpobfal().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO16101_CVDPOBFAL
     * called from Mghs114a.A5009AcederHoA5009AcederHo
     * 
     */
    public void selectMghs114a508() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT" +
            " FROM VWSDHOPS16101_CVDPOBFAL" +
            " WHERE " +
                "N_CONTA = :nConta"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nConta", cvdpobfal().nConta() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            cvdpobfal().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            cvdpobfal().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            cvdpobfal().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            cvdpobfal().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            cvdpobfal().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            cvdpobfal().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO16101_CVDPOBFAL
     * called from Mghs203a.A5009AcederHoA5009AcederHo
     * 
     */
    public void selectMghs203a333() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT" +
            " FROM VWSDHOPS16101_CVDPOBFAL" +
            " WHERE " +
                "N_CONTA = :nConta"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nConta", cvdpobfal().nConta() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            cvdpobfal().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            cvdpobfal().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            cvdpobfal().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            cvdpobfal().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            cvdpobfal().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            cvdpobfal().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHO16101_CVDPOBFAL
     * called from Mghs801a.A5209AcederHoA5209AcederHo
     * 
     */
    public void selectMghs801a281() {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT" +
            " FROM VWSDHOPS16101_CVDPOBFAL" +
            " WHERE " +
                "N_CONTA = :nConta"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nConta", cvdpobfal().nConta() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            cvdpobfal().cPaisIsoaCont().set(getQueryReturnedValue("C_PAIS_ISOA_CONT")) ;
            cvdpobfal().cBancCont().set(getQueryReturnedValue("C_BANC_CONT")) ;
            cvdpobfal().cOeEgcCont().set(getQueryReturnedValue("C_OE_EGC_CONT")) ;
            cvdpobfal().nsRdclCont().set(getQueryReturnedValue("NS_RDCL_CONT")) ;
            cvdpobfal().vChkdCont().set(getQueryReturnedValue("V_CHKD_CONT")) ;
            cvdpobfal().cTipoCont().set(getQueryReturnedValue("C_TIPO_CONT")) ;
        }
    }
}
