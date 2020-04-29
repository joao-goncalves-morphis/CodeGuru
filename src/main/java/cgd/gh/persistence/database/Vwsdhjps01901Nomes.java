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
public abstract class Vwsdhjps01901Nomes extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Nomes
     */
    @Data
    public abstract Nomes nomes() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHJ01901_NOMES
     * 
     * @version 2.0
     * 
     */
    public interface Nomes extends IDataStruct {
        
        /**
         * N_CLIENTE
         */
        @Column(name="N_CLIENTE")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        /**
         * NS_ABRA_CLI
         */
        @Column(name="NS_ABRA_CLI")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        /**
         * NS_NOME_CLI
         */
        @Column(name="NS_NOME_CLI")
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsNomeCli() ;
        
        /**
         * C_TIPO_NOME_CLI
         */
        @Column(name="C_TIPO_NOME_CLI")
        @Data(size=3)
        IString cTipoNomeCli() ;
        
        /**
         * NM_CLI_ABVD
         */
        @Column(name="NM_CLI_ABVD")
        @Data(size=35)
        IString nmCliAbvd() ;
        
        /**
         * AN_CLI_PRIM
         */
        @Column(name="AN_CLI_PRIM")
        @Data(size=20)
        IString anCliPrim() ;
        
        /**
         * AN_CLI_SEGN
         */
        @Column(name="AN_CLI_SEGN")
        @Data(size=6)
        IString anCliSegn() ;
        
        /**
         * AN_CLI_TERC
         */
        @Column(name="AN_CLI_TERC")
        @Data(size=22)
        IString anCliTerc() ;
        
        /**
         * C_USID_ACTZ_ULT
         */
        @Column(name="C_USID_ACTZ_ULT")
        @Data(size=8)
        IString cUsidActzUlt() ;
        
        /**
         * TS_ACTZ_ULT
         */
        @Column(name="TS_ACTZ_ULT", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsActzUlt() ;
        
    }
    
    /**
     * Copybooks
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHJ01901_NOMES
     * called from Bhjp0016AcedeNomes
     * 
     */
    public void selectBhjp0016148() {
        sqlSttmt = "SELECT  " +
                "NS_NOME_CLI," +
                "NM_CLI_ABVD," +
                "AN_CLI_PRIM," +
                "AN_CLI_SEGN," +
                "AN_CLI_TERC" +
            " FROM VWSDHJPS01901_NOMES" +
            " WHERE " +
                "N_CLIENTE = :nCliente AND NS_ABRA_CLI = :nsAbraCli AND " +
                "C_TIPO_NOME_CLI = :cTipoNomeCli" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nCliente", nomes().nCliente() ) ;
        setQueryArgument( "nsAbraCli", nomes().nsAbraCli() ) ;
        setQueryArgument( "cTipoNomeCli", nomes().cTipoNomeCli() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            nomes().nsNomeCli().set(getQueryReturnedValue("NS_NOME_CLI")) ;
            nomes().nmCliAbvd().set(getQueryReturnedValue("NM_CLI_ABVD")) ;
            nomes().anCliPrim().set(getQueryReturnedValue("AN_CLI_PRIM")) ;
            nomes().anCliSegn().set(getQueryReturnedValue("AN_CLI_SEGN")) ;
            nomes().anCliTerc().set(getQueryReturnedValue("AN_CLI_TERC")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHJ01901_NOMES
     * called from Bhjp1019Consulta
     * 
     */
    public void selectBhjp101914() {
        sqlSttmt = "SELECT  " +
                "C_TIPO_NOME_CLI," +
                "NM_CLI_ABVD," +
                "AN_CLI_PRIM," +
                "AN_CLI_SEGN," +
                "AN_CLI_TERC," +
                "C_USID_ACTZ_ULT," +
                "TS_ACTZ_ULT" +
            " FROM VWSDHJPS01901_NOMES" +
            " WHERE " +
                "N_CLIENTE = :nCliente AND NS_ABRA_CLI = :nsAbraCli AND " +
                "NS_NOME_CLI = :nsNomeCli" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nCliente", nomes().nCliente() ) ;
        setQueryArgument( "nsAbraCli", nomes().nsAbraCli() ) ;
        setQueryArgument( "nsNomeCli", nomes().nsNomeCli() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            nomes().cTipoNomeCli().set(getQueryReturnedValue("C_TIPO_NOME_CLI")) ;
            nomes().nmCliAbvd().set(getQueryReturnedValue("NM_CLI_ABVD")) ;
            nomes().anCliPrim().set(getQueryReturnedValue("AN_CLI_PRIM")) ;
            nomes().anCliSegn().set(getQueryReturnedValue("AN_CLI_SEGN")) ;
            nomes().anCliTerc().set(getQueryReturnedValue("AN_CLI_TERC")) ;
            nomes().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
            nomes().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
}
