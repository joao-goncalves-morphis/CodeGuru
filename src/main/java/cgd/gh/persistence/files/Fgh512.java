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
public abstract class Fgh512 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh512
     */
    @Data
    public abstract RegFgh512 regFgh512() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh512 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh512Subconta
         */
        @Data
        Fgh512Subconta fgh512Subconta() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh512NsMovimento() ;
        
        @Data(size=10)
        IString fgh512ZMovimento() ;
        
        @Data(size=10)
        IString fgh512ZValMov() ;
        
        @Data(size=1)
        IString fgh512IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh512MMovimento() ;
        
        @Data(size=1)
        IString fgh512IEstorno() ;
        
        @Data(size=3)
        IString fgh512CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh512MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh512MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh512MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh512XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh512NDocOpps() ;
        
        @Data(size=2)
        IString fgh512AAplOrig() ;
        
        @Data(size=5)
        IString fgh512COpeBbn() ;
        
        @Data(size=3)
        IString fgh512COpczMenu() ;
        
        @Data(size=4)
        IString fgh512CTipoCanlAces() ;
        
        @Data(size=2)
        IString fgh512CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh512CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh512COeEgcOpex() ;
        
        
        public interface Fgh512Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fgh512CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh512CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh512COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fgh512NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fgh512VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fgh512CTipoCont() ;
            
            @Data(size=3)
            IString fgh512CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh512NsDeposito() ;
            
        }
    }
}
