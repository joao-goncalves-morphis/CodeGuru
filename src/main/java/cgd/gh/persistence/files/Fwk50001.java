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
public abstract class Fwk50001 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh503
     */
    @Data
    public abstract RegFgh503 regFgh503() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh503 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh503Conta
         */
        @Data
        Fgh503Conta fgh503Conta() ;
        
        @Data(size=8)
        ILong fgh503QMovimentos() ;
        
        @Data(size=10)
        IString fgh503ZMovimento() ;
        
        
        public interface Fgh503Conta extends IDataStruct {
            
            @Data(size=3)
            IString fgh503CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt fgh503CBancCont() ;
            
            @Data(size=4)
            IInt fgh503COeEgcCont() ;
            
            @Data(size=7)
            IInt fgh503NsRdclCont() ;
            
            @Data(size=1)
            IInt fgh503VChkdCont() ;
            
            @Data(size=3)
            IInt fgh503CTipoCont() ;
            
        }
    }
}
