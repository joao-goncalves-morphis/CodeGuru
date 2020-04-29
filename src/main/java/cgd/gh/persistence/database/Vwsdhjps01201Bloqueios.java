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
public abstract class Vwsdhjps01201Bloqueios extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Bloqueios
     */
    @Data
    public abstract Bloqueios bloqueios() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHJ01201_BLOQUEIOS
     * 
     * @version 2.0
     * 
     */
    public interface Bloqueios extends IDataStruct {
        
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
         * C_TIPO_BLQO_CLI
         */
        @Column(name="C_TIPO_BLQO_CLI")
        @Data(size=3)
        IString cTipoBlqoCli() ;
        
        /**
         * NS_BLQO_CLI
         */
        @Column(name="NS_BLQO_CLI")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsBlqoCli() ;
        
        /**
         * C_MTVO_BLQO_CLI
         */
        @Column(name="C_MTVO_BLQO_CLI")
        @Data(size=3)
        IString cMtvoBlqoCli() ;
        
        /**
         * Z_INICIO
         */
        @Column(name="Z_INICIO", type=java.sql.Date.class)
        @Data(size=10)
        IString zInicio() ;
        
        /**
         * Z_FIM
         */
        @Column(name="Z_FIM", type=java.sql.Date.class)
        @Data(size=10)
        IString zFim() ;
        
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
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VHJ01201_BLOQUEIOS
     * called from Pghq998a.M2300AcedeThj12M2300AcedeThj12
     * 
     * @param pBhjk0002BloqueioObito
     * @param pConSeis
     */
    public void selectPghq998a1480(String pBhjk0002BloqueioObito, String pConSeis) {
        sqlSttmt = "SELECT  " +
                "Z_INICIO" +
            " FROM VWSDHJPS01201_BLOQUEIOS" +
            " WHERE " +
                "N_CLIENTE = :nCliente AND " +
                "(C_TIPO_BLQO_CLI = :bloqueioObito OR C_TIPO_BLQO_CLI = :conSeis)" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "nCliente", bloqueios().nCliente() ) ;
        setQueryArgument( "bloqueioObito", pBhjk0002BloqueioObito ) ;
        setQueryArgument( "conSeis", pConSeis ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            bloqueios().zInicio().set(getQueryReturnedValue("Z_INICIO", String.class)) ;
        }
    }
}
