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
public abstract class Fwk101 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh01001
     */
    @Data
    public abstract Rgh01001 rgh01001() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh01001 extends IDataStruct {
        
        @Data(size=3)
        IString fgh010CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh010CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh010COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh010NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh010VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh010CTipoCont() ;
        
        @Data(size=3)
        IString fgh010CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh010NsDeposito() ;
        
        @Data(size=8)
        IString fgh010NmRecurso() ;
        
        @Data(size=1)
        IString fgh010CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh010ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh010ZaFim() ;
        
        @Data(size=26)
        IString fgh010TsActzUlt() ;
        
        @Data(size=8)
        IString fgh010CUsidActzUlt() ;
        
    }
}
