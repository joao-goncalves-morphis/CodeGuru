package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fwk581.RegFwk59002 ;
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
public abstract class Fwk59001 extends DataFileHandler {
    
    /**
     * @return instancia da classe RegFwk59002
     */
    @Data
    public abstract RegFwk59002 regFwk590() ;
    
    /**
     * @return instancia da classe RegFwk59002
     */
    @Data
    public abstract RegFwk59002 regFwk59002() ;
}
