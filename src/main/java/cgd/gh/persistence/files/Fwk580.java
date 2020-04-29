package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fwk500.RegFwk50002 ;
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
public abstract class Fwk580 extends DataFileHandler {
    
    /**
     * @return instancia da classe RegFwk50002
     */
    @Data
    public abstract RegFwk50002 regFwk500() ;
    
    /**
     * @return instancia da classe RegFwk50002
     */
    @Data
    public abstract RegFwk50002 regFwk50002() ;
}
