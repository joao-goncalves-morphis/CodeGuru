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
public abstract class Fgh926 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh92601
     */
    @Data
    public abstract Rgh92601 rgh92601() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh92601 extends IDataStruct {
        
        @Data(size=3)
        IString fgh926CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fgh926CBancCont() ;
        
        @Data(size=4)
        IInt fgh926COeEgcCont() ;
        
        @Data(size=6)
        IInt fgh926NsRdclCont() ;
        
        @Data(size=1)
        IInt fgh926VChkdCont() ;
        
        @Data(size=2)
        IInt fgh926CTipoCont() ;
        
        @Data(size=3)
        IString fgh926CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fgh926NsDeposito() ;
        
        @Data(size=7)
        IString fgh926CPedInfOpps() ;
        
        @Data(size=10)
        IString fgh926ZInicMov() ;
        
        @Data(size=10)
        IString fgh926ZFimMov() ;
        
        @Data(size=4)
        IInt fgh926COeEgcDest() ;
        
    }
}
