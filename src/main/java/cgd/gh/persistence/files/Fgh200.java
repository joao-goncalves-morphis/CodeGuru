package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fgh200 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh20001
     */
    @Data
    public abstract Rgh20001 rgh20001() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh20001 extends IDataStruct {
        
        @Data(size=2)
        IString fgh200CAccao() ;
        @Data
        @Condition("CS")
        ICondition fgh200CcltScta() ;
        @Data
        @Condition("XS")
        ICondition fgh200ExprScta() ;
        @Data
        @Condition("AS")
        ICondition fgh200AbrtScta() ;
        
        
        /**
         * @return instancia da classe local Fgh200NSubconta
         */
        @Data
        Fgh200NSubconta fgh200NSubconta() ;
        
        @Data(size=10)
        IString fgh200ZCcltScta() ;
        
        @Data(size=10)
        IString fgh200ZExprScta() ;
        
        @Data(size=10, rpadding=8)
        IString fgh200ZAbraScta() ;
        
        
        public interface Fgh200NSubconta extends IDataStruct {
            
            @Data(size=3)
            IString fgh200CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh200CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh200COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fgh200NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fgh200VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fgh200CTipoCont() ;
            
            @Data(size=3)
            IString fgh200CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh200NsDeposito() ;
            
        }
    }
}
