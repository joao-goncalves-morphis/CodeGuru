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


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fgh505 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh505
     */
    @Data
    public abstract RegFgh505 regFgh505() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh505 extends IDataStruct {
        
        @Data(size=3)
        IString fgh505CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fgh505CBancCont() ;
        
        @Data(size=13)
        ILong fgh505NConta() ;
        
        @Data(size=10)
        IString fgh505ZMovimento() ;
        
        @Data(size=10)
        IString fgh505ZValMov() ;
        
        @Data(size=21)
        IString fgh505XRefMov() ;
        
        @Data(size=3)
        IString fgh505CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh505MMovimento() ;
        
        @Data(size=1)
        IString fgh505SinalMov() ;
        
        @Data(size=1)
        IString fgh505IEstorno() ;
        
        @Data(size=4)
        IInt fgh505COeEgcOpex() ;
        
    }
}
