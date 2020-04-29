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
public abstract class Fwk006 extends DataFileHandler {
    
    @Data(size=227)
    public IString fwk006Reg227 ;
    
    @Data(size=327)
    public IString fwk006Reg327 ;
    
    @Data(size=400)
    public IString regFwk006400 ;
    
    @Data(size=80)
    public IString regFwk00680 ;
}
