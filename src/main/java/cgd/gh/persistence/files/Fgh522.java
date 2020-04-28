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
public abstract class Fgh522 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh522
     */
    @Data
    public abstract RegFgh522 regFgh522() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh522 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh522Subconta
         */
        @Data
        Fgh522Subconta fgh522Subconta() ;
        
        @Data(size=10)
        IString fgh522ZMovimento() ;
        
        @Data(size=10)
        IString fgh522ZValMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh522NsMovimento() ;
        
        @Data(size=1)
        IString fgh522IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh522MMovimento() ;
        
        @Data(size=3)
        IString fgh522CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh522MMovMoeOrigMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh522MSldoCbloApos() ;
        
        @Data(size=4)
        IString fgh522CEvenOpel() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh522COeEgcOpex() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh522NDocOpps() ;
        
        @Data(size=21)
        IString fgh522XRefMov() ;
        
        @Data(size=5)
        IString fgh522COpeBbn() ;
        
        @Data(size=1)
        IString fgh522IEstorno() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fgh522TCambio() ;
        
        @Data(size=100, rpadding=19)
        IString fgh522ChvFicheiro() ;
        
        
        public interface Fgh522Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fgh522CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh522CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh522COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fgh522NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fgh522VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fgh522CTipoCont() ;
            
            @Data(size=3)
            IString fgh522CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh522NsDeposito() ;
            
        }
    }
}
