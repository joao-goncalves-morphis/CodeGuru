package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fgh595 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh59501
     */
    @Data
    public abstract Rgh59501 rgh59501() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh59501 extends IDataStruct {
        
        @Data(size=4)
        IInt fgh595Balcao() ;
        
        @Data(size=6)
        IInt fgh595RadicalConta() ;
        
    }
}
