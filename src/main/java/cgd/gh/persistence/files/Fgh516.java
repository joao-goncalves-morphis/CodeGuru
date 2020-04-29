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
public abstract class Fgh516 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh516
     */
    @Data
    public abstract RegFgh516 regFgh516() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh516 extends IDataStruct {
        
        @Data(size=3)
        IString fgh516CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fgh516CBancCont() ;
        
        @Data(size=4)
        IInt fgh516COeEgcCont() ;
        
        @Data(size=7)
        IInt fgh516NsRdclCont() ;
        
        @Data(size=1)
        IInt fgh516VChkdCont() ;
        
        @Data(size=3)
        IInt fgh516CTipoCont() ;
        
        @Data(size=3)
        IString fgh516CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fgh516NsDeposito() ;
        
        @Data(size=26)
        IString fgh516TsMovimento() ;
        
        @Data(size=15)
        ILong fgh516NsMovimento() ;
        
        @Data(size=10)
        IString fgh516ZValMov() ;
        
        @Data(size=10)
        IString fgh516ZMovLocl() ;
        
        @Data(size=1)
        IString fgh516IDbcr() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh516MMovimento() ;
        
        @Data(size=1)
        IString fgh516SMovimento() ;
        
        @Data(size=1)
        IString fgh516IEstorno() ;
        
        @Data(size=3)
        IString fgh516CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh516MSldoCbloApos() ;
        
        @Data(size=1)
        IString fgh516SSldoCbloApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh516MSldoDpnlApos() ;
        
        @Data(size=1)
        IString fgh516SSldoDpnlApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh516MMovMoeOrigMov() ;
        
        @Data(size=1)
        IString fgh516SMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh516XRefMov() ;
        
        @Data(size=10)
        ILong fgh516NDocOpps() ;
        
        @Data(size=10, decimal=7)
        IDecimal fgh516TJuro() ;
        
        @Data(size=2)
        IString fgh516AAplOrig() ;
        
        @Data(size=26)
        IString fgh516TsActzUlt() ;
        
        @Data(size=8)
        IString fgh516CUsidActzUlt() ;
        
    }
}
