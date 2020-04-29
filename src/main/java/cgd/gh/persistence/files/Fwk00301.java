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
public abstract class Fwk00301 extends DataFileHandler {
    
    @Data(size=327)
    public IString fwk003Reg327 ;
    
    /**
     * @return instancia da classe local RegFwk003
     */
    @Data
    public abstract RegFwk003 regFwk003() ;
    
    @Data(size=400)
    public IString regFwk003400 ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk003 extends IDataStruct {
        
        @Data(size=3)
        IString fwk003CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk003NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk003VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk003CTipoCont() ;
        
        @Data(size=3)
        IString fwk003CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003NsDeposito() ;
        
        @Data(size=8)
        IString fwk003NmRecurso() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003ZaFim() ;
        
        @Data(size=1)
        IString fwk003IAcao() ;
        
    }
}
