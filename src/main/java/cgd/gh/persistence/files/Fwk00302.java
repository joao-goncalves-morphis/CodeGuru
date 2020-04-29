package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fgh003.Rgh00301 ;
import cgd.gh.persistence.files.Fgh003.Rgh0030102 ;
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
public abstract class Fwk00302 extends DataFileHandler {
    
    @Data(size=227)
    public IString fwk003Reg227 ;
    
    @Data(size=75)
    public IString fwk003Reg75 ;
    
    /**
     * @return instancia da classe Rgh0030102
     */
    @Data
    public abstract Rgh0030102 rgh00301() ;
    
    /**
     * @return instancia da classe Rgh0030102
     */
    @Data
    public abstract Rgh0030102 rgh0030102() ;
}
