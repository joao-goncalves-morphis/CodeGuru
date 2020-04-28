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
public abstract class Fwk050 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk050Pghc050a
     */
    @Data
    public abstract RegFwk050Pghc050a regFwk050Pghc050a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFwk050Pghc050a extends IDataStruct {
        
        @Data(size=6)
        IString fwk050Inicio() ;
        
        /**
         * @return instancia da classe local Fwk050RegTgh001
         */
        @Data
        Fwk050RegTgh001 fwk050RegTgh001() ;
        
        
        public interface Fwk050RegTgh001 extends IDataStruct {
            
            @Data(size=3)
            IString fwk050CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk050CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk050COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk050NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk050VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk050CTipoCont() ;
            
            @Data(size=3)
            IString fwk050CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk050NsDeposito() ;
            
            @Data(size=8)
            IString fwk050NmRecurso() ;
            
            @Data(size=1)
            IString fwk050CTipoInfHist() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk050ZaInicio() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk050ZaFim() ;
            
            @Data(size=26)
            IString fwk050TsActzUlt() ;
            
            @Data(size=8)
            IString fwk050CUsidActzUlt() ;
            
        }
    }
}
