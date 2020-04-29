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
public abstract class Fgh504 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh504
     */
    @Data
    public abstract RegFgh504 regFgh504() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh504 extends IDataStruct {
        
        @Data(size=3)
        IString fgh504CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fgh504CBancCont() ;
        
        @Data(size=4)
        IInt fgh504COeEgcCont() ;
        
        @Data(size=7)
        IInt fgh504NsRdclCont() ;
        
        @Data(size=1)
        IInt fgh504VChkdCont() ;
        
        @Data(size=3)
        IInt fgh504CTipoCont() ;
        
        @Data(size=7)
        IInt fgh504QMovimento() ;
        
        @Data(size=3)
        IString fgh504CTipoMov() ;
        
        @Data(size=10)
        IString fgh504ZMovimento() ;
        
    }
}
