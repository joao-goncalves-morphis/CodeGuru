package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fwk400.RegFwk40002 ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fwk480 extends DataFileHandler {
    
    /**
     * @return instancia da classe RegFwk40002
     */
    @Data
    public abstract RegFwk40002 regFwk400() ;
    
    /**
     * @return instancia da classe RegFwk40002
     */
    @Data
    public abstract RegFwk40002 regFwk40002() ;
}
