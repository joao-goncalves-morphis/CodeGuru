package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.MathHandling.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fgh507 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh507
     */
    @Data
    public abstract RegFgh507 regFgh507() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh507 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh507Subconta
         */
        @Data
        Fgh507Subconta fgh507Subconta() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh507NsMovimento() ;
        
        @Data(size=10)
        IString fgh507ZMovimento() ;
        
        @Data(size=10)
        IString fgh507ZValMov() ;
        
        @Data(size=1)
        IString fgh507IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh507MMovimento() ;
        
        @Data(size=1)
        IString fgh507IEstorno() ;
        
        @Data(size=3)
        IString fgh507CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh507MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh507MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh507MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh507XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh507NDocOpps() ;
        
        @Data(size=2)
        IString fgh507AAplOrig() ;
        
        @Data(size=5)
        IString fgh507COpeBbn() ;
        
        @Data(size=3)
        IString fgh507COpczMenu() ;
        
        @Data(size=4)
        IString fgh507CTipoCanlAces() ;
        
        @Data(size=2)
        IString fgh507CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh507CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh507COeEgcOpex() ;
        
        
        public interface Fgh507Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fgh507CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh507CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh507COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fgh507NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fgh507VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fgh507CTipoCont() ;
            
            @Data(size=3)
            IString fgh507CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh507NsDeposito() ;
            
        }
    }
}
