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
public abstract class Fwk05403 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk054Pghc054a
     */
    @Data
    public abstract RegFwk054Pghc054a regFwk054Pghc054a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFwk054Pghc054a extends IDataStruct {
        
        @Data(size=6)
        IString fwk054Inicio() ;
        
        /**
         * @return instancia da classe local Fwk054RegTgh001
         */
        @Data
        Fwk054RegTgh001 fwk054RegTgh001() ;
        
        
        public interface Fwk054RegTgh001 extends IDataStruct {
            
            @Data(size=3)
            IString fwk054CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk054CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk054COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk054NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk054VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk054CTipoCont() ;
            
            @Data(size=3)
            IString fwk054CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk054NsDeposito() ;
            
            @Data(size=8)
            IString fwk054NmRecurso() ;
            
            @Data(size=1)
            IString fwk054CTipoInfHist() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk054ZaInicio() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk054ZaFim() ;
            
            @Data(size=26)
            IString fwk054TsActzUlt() ;
            
            @Data(size=8)
            IString fwk054CUsidActzUlt() ;
            
        }
    }
}
