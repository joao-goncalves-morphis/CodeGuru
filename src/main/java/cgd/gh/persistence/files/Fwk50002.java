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
public abstract class Fwk50002 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk500Pghc050a
     */
    @Data
    public abstract RegFwk500Pghc050a regFwk500Pghc050a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFwk500Pghc050a extends IDataStruct {
        
        @Data(size=3)
        IString fwk500CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk500CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk500COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk500NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk500VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk500CTipoCont() ;
        
        @Data(size=3)
        IString fwk500CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk500NsDeposito() ;
        
        @Data(size=8)
        IString fwk500NmRecurso() ;
        
        @Data(size=1)
        IString fwk500CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk500ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk500ZaFim() ;
        
        @Data(size=26)
        IString fwk500TsActzUlt() ;
        
        @Data(size=8)
        IString fwk500CUsidActzUlt() ;
        
    }
}
