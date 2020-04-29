package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fwk700.RegFwk70002 ;
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
public abstract class Fwk780 extends DataFileHandler {
    
    /**
     * @return instancia da classe RegFwk70002
     */
    @Data
    public abstract RegFwk70002 regFwk700() ;
    
    /**
     * @return instancia da classe RegFwk70002
     */
    @Data
    public abstract RegFwk70002 regFwk70002() ;
}
