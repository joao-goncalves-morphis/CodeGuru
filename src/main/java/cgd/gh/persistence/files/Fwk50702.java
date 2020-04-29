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
public abstract class Fwk50702 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk507Pghc050a
     */
    @Data
    public abstract RegFwk507Pghc050a regFwk507Pghc050a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFwk507Pghc050a extends IDataStruct {
        
        @Data(size=3)
        IString fwk507CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk507CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk507COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk507NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk507VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk507CTipoCont() ;
        
        @Data(size=3)
        IString fwk507CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk507NsDeposito() ;
        
        @Data(size=8)
        IString fwk507NmRecurso() ;
        
        @Data(size=1)
        IString fwk507CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk507ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk507ZaFim() ;
        
        @Data(size=26)
        IString fwk507TsActzUlt() ;
        
        @Data(size=8)
        IString fwk507CUsidActzUlt() ;
        
    }
}
