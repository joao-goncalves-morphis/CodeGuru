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
public abstract class Fwk910 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk910Pghq667a
     */
    @Data
    public abstract RegFwk910Pghq667a regFwk910Pghq667a() ;
    
    /**
     * @return instancia da classe local RegFwk910Pghq668a
     */
    @Data
    public abstract RegFwk910Pghq668a regFwk910Pghq668a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk910Pghq667a extends IDataStruct {
        
        @Data(size=3)
        IString fwk910CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk910NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk910VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk910CTipoCont() ;
        
        @Data(size=3)
        IString fwk910CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910NsDeposito() ;
        
        @Data(size=8)
        IString fwk910NmRecurso() ;
        
        @Data(size=1)
        IString fwk910CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910ZaFim() ;
        
        @Data(size=26)
        IString fwk910TsActzUlt() ;
        
        @Data(size=8)
        IString fwk910CUsidActzUlt() ;
        
    }
    public interface RegFwk910Pghq668a extends IDataStruct {
        
        @Data(size=3)
        IString fwk910CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk910NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk910VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk910CTipoCont() ;
        
        @Data(size=3)
        IString fwk910CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910NsDeposito() ;
        
        @Data(size=8)
        IString fwk910NmRecurso() ;
        
        @Data(size=1)
        IString fwk910CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk910ZaFim() ;
        
        @Data(size=26)
        IString fwk910TsActzUlt() ;
        
        @Data(size=8)
        IString fwk910CUsidActzUlt() ;
        
    }
}
