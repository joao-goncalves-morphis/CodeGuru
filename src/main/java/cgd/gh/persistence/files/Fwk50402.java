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
public abstract class Fwk50402 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk504Pghc054a
     */
    @Data
    public abstract RegFwk504Pghc054a regFwk504Pghc054a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFwk504Pghc054a extends IDataStruct {
        
        @Data(size=3)
        IString fwk504CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk504NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk504VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk504CTipoCont() ;
        
        @Data(size=3)
        IString fwk504CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504NsDeposito() ;
        
        @Data(size=8)
        IString fwk504NmRecurso() ;
        
        @Data(size=1)
        IString fwk504CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk504ZaFim() ;
        
        @Data(size=26)
        IString fwk504TsActzUlt() ;
        
        @Data(size=8)
        IString fwk504CUsidActzUlt() ;
        
    }
}
