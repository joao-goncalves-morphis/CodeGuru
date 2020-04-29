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
public abstract class Fgh800 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh800Pghq800a
     */
    @Data
    public abstract RegFgh800Pghq800a regFgh800Pghq800a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ3
     */
    public interface RegFgh800Pghq800a extends IDataStruct {
        
        @Data(size=10)
        IString fgh800ZProcessamento() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh800NJourBbn() ;
        
        @Data(size=9)
        IString fgh800DMovCadn() ;
        
        @Data(size=12)
        IString fgh800XRefAdiMov() ;
        
        @Data(size=20)
        IString fgh800XDsc1Sibs() ;
        
    }
}
