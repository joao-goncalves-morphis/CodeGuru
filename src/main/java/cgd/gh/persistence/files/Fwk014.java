package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fwk014 extends DataFileHandler {
    
    @Data(size=237)
    public IString fwk014Reg237 ;
    
    @Data(size=327)
    public IString fwk014Reg327 ;
    
    @Data(size=80)
    public IString regFwk01480 ;
}
