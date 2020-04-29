package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fwk600.RegFwk60002 ;
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
public abstract class Fwk680 extends DataFileHandler {
    
    /**
     * @return instancia da classe RegFwk60002
     */
    @Data
    public abstract RegFwk60002 regFwk600() ;
    
    /**
     * @return instancia da classe RegFwk60002
     */
    @Data
    public abstract RegFwk60002 regFwk60002() ;
}
