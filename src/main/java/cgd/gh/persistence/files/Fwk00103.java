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
public abstract class Fwk00103 extends DataFileHandler {
    
    @Data(size=227)
    public IString fwk001Reg227 ;
    
    @Data(size=200)
    public IString regFwk001200 ;
    
    /**
     * @return instancia da classe local Rgh20201
     */
    @Data
    public abstract Rgh20201 rgh20201() ;
    /**
     * Global
     */
    public interface Rgh20201 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh202NSubconta
         */
        @Data
        Fgh202NSubconta fgh202NSubconta() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh202NCheque() ;
        
        @Data(size=10)
        IString fgh202ZPagCheq() ;
        
        @Data(size=14, signed=true, compression=COMP3)
        ILong fgh202NRefCheqArqv() ;
        
        @Data(size=3)
        IString fgh202CPaisIsaTmxChq() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh202CBancTomador() ;
        
        @Data(size=4, signed=true, rpadding=20, compression=COMP3)
        IInt fgh202COeEgcTomxCheq() ;
        
        
        public interface Fgh202NSubconta extends IDataStruct {
            
            @Data(size=3)
            IString fgh202CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh202CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh202COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fgh202NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fgh202VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fgh202CTipoCont() ;
            
            @Data(size=3)
            IString fgh202CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh202NsDeposito() ;
            
        }
    }
}
