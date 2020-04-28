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
public abstract class Vwsdghps00701Infpesmov extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Infpesmov
     */
    @Data
    public abstract Infpesmov infpesmov() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH00701_INFPESMOV
     * 
     * @version 2.0
     * 
     */
    public interface Infpesmov extends IDataStruct {
        
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
         * X_INF_PESL_MOV
         */
        @Column(name="X_INF_PESL_MOV")
        @Data(size=70)
        IString xInfPeslMov() ;
        
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
     * extracted method to encapsulate DELETE access to table VGH00701_INFPESMOV
     * called from Mghs007a.A3400EliminaA3400Elimina
     * 
     */
    public void deleteMghs007a303() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "DELETE FROM VWSDGHPS00701_INFPESMOV " +
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
        setQueryArgument( "cPaisIsoaCont", infpesmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infpesmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infpesmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infpesmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infpesmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infpesmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infpesmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infpesmov().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infpesmov().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infpesmov().nsMovimento() ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00701_INFPESMOV
     * called from Mghs007a.A3200InsereA3200Insere
     * 
     */
    public void insertMghs007a222() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "INSERT INTO VWSDGHPS00701_INFPESMOV ( " +
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
        	"X_INF_PESL_MOV, " +
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
        	":xInfPeslMov, " +
        	"NOW(), " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infpesmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infpesmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infpesmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infpesmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infpesmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infpesmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infpesmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infpesmov().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infpesmov().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infpesmov().nsMovimento() ) ;
        setQueryArgument( "xInfPeslMov", infpesmov().xInfPeslMov() ) ;
        setQueryArgument( "cUsidActzUlt", infpesmov().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00701_INFPESMOV
     * called from Mghs007a.A3100ConsultaA3100Consulta
     * 
     */
    public void selectMghs007a179() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "X_INF_PESL_MOV," +
                "TS_ACTZ_ULT," +
                "C_USID_ACTZ_ULT" +
            " FROM VWSDGHPS00701_INFPESMOV" +
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
        setQueryArgument( "cPaisIsoaCont", infpesmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infpesmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infpesmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infpesmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infpesmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infpesmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infpesmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infpesmov().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infpesmov().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infpesmov().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infpesmov().xInfPeslMov().set(getQueryReturnedValue("X_INF_PESL_MOV")) ;
            infpesmov().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
            infpesmov().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00701_INFPESMOV
     * called from Mghs007a.A3300AlteraA3300Altera
     * 
     */
    public void updateMghs007a271() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "UPDATE VWSDGHPS00701_INFPESMOV " +
            "SET X_INF_PESL_MOV = :xInfPeslMov, " +
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
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infpesmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infpesmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infpesmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infpesmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infpesmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infpesmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infpesmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infpesmov().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infpesmov().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infpesmov().nsMovimento() ) ;
        setQueryArgument( "xInfPeslMov", infpesmov().xInfPeslMov() ) ;
        setQueryArgument( "cUsidActzUlt", infpesmov().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
}
