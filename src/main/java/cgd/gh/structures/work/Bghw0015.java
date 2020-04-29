package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw0015 extends IDataStruct {
    
    /**
     * @return instancia da classe local Rwk01501
     */
    @Data
    Rwk01501 rwk01501() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * FWK015 - SUBCONTA COM MOVIMENTO NO DIA PARA
     * 
     * @version 2.0
     * 
     */
    public interface Rwk01501 extends IDataStruct {
        
        @Data(size=3)
        IString fwk015CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk015NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk015VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk015CTipoCont() ;
        
        @Data(size=3)
        IString fwk015CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015NsDeposito() ;
        
        @Data(size=10)
        IString fwk015ZMovimento() ;
        
    }
    
}
