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
public abstract class Fgh802 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh802Pghq802a
     */
    @Data
    public abstract RegFgh802Pghq802a regFgh802Pghq802a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ3
     */
    public interface RegFgh802Pghq802a extends IDataStruct {
        
        @Data(size=3)
        IString fgh802CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh802CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh802COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh802NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh802VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh802CTipoCont() ;
        
        @Data(size=3)
        IString fgh802CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh802NsDeposito() ;
        
        @Data(size=10)
        IString fgh802ZExeOpeAgnt() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh802CRefSrvEspSibs() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong fgh802NJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh802NsJourBbn() ;
        
    }
}
