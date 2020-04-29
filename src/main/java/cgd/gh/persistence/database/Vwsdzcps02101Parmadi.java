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
public abstract class Vwsdzcps02101Parmadi extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Parmadi
     */
    @Data
    public abstract Parmadi parmadi() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VZC02101_PARMADI
     * 
     * @version 2.0
     * 
     */
    public interface Parmadi extends IDataStruct {
        
        /**
         * C_PAIS_ISO_ALFN
         */
        @Data(size=3)
        IString cPaisIsoAlfn() ;
        
        /**
         * C_MNEM_EMP_GCX
         */
        @Data(size=3)
        IString cMnemEmpGcx() ;
        
        /**
         * C_ADI_CMCZ
         */
        @Data(size=3)
        IString cAdiCmcz() ;
        
        /**
         * C_FAMI_CMCZ_CLI
         */
        @Data(size=3)
        IString cFamiCmczCli() ;
        
        /**
         * C_CMCZ_CLI
         */
        @Data(size=3)
        IString cCmczCli() ;
        
        /**
         * C_FAMI_PROD_MKT
         */
        @Data(size=3)
        IString cFamiProdMkt() ;
        
        /**
         * C_TIPO_ALVO_PRMZ
         */
        @Data(size=1)
        IString cTipoAlvoPrmz() ;
        
        /**
         * C_SEGM_CRM
         */
        @Data(size=10)
        IString cSegmCrm() ;
        
        /**
         * C_GRAN_CLI
         */
        @Data(size=3)
        IString cGranCli() ;
        
        /**
         * Z_INIC_VLDE
         */
        @Data(size=10)
        IString zInicVlde() ;
        
        /**
         * Z_FIM_VLDE
         */
        @Data(size=10)
        IString zFimVlde() ;
        
        /**
         * NS_PARM_ADI_CMCZ
         */
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsParmAdiCmcz() ;
        
        /**
         * C_TIPO_ADI_CMCZ
         */
        @Data(size=1)
        IString cTipoAdiCmcz() ;
        
        /**
         * C_USID_CRIZ
         */
        @Data(size=8)
        IString cUsidCriz() ;
        
        /**
         * C_USID_ACTZ_ULT
         */
        @Data(size=8)
        IString cUsidActzUlt() ;
        
        /**
         * TS_ACTZ_ULT
         */
        @Data(size=26)
        IString tsActzUlt() ;
        
    }
    
}
