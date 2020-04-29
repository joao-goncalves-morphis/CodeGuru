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
public abstract class Input104 extends DataFileHandler {
    
    @Data
    public abstract Rwk01501 rwk01501() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    
    /**
     * 
     * FWK015 - SUBCONTA COM MOVIMENTO NO DIA PARA
     * 
     * @version 2.0
     * 
     */
    public interface Rwk01501 extends IDataStruct {
        
        @Data(size=3)
        IString fwk015CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk015NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk015VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk015CTipoCont() ;
        
        @Data(size=3)
        IString fwk015CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015NsDeposito() ;
        
        @Data(size=10)
        IString fwk015ZMovimento() ;
        
    }
}
