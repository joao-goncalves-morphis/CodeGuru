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
public abstract class Fgh514 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh514
     */
    @Data
    public abstract RegFgh514 regFgh514() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh514 extends IDataStruct {
        
        @Data(size=10)
        IString fgh514ZUltProc() ;
        
        @Data(size=70)
        IString fgh514Resto() ;
        
    }
}
