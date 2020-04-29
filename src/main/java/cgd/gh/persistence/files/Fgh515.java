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
public abstract class Fgh515 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh515
     */
    @Data
    public abstract RegFgh515 regFgh515() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh515 extends IDataStruct {
        
        @Data(size=3)
        IString fgh515CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fgh515CBancCont() ;
        
        @Data(size=4)
        IInt fgh515COeEgcCont() ;
        
        @Data(size=7)
        IInt fgh515NsRdclCont() ;
        
        @Data(size=1)
        IInt fgh515VChkdCont() ;
        
        @Data(size=3)
        IInt fgh515CTipoCont() ;
        
        @Data(size=3)
        IString fgh515CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fgh515NsDeposito() ;
        
        @Data(size=26)
        IString fgh515TsMovimento() ;
        
        @Data(size=15)
        ILong fgh515NsMovimento() ;
        
        @Data(size=10)
        IString fgh515ZValMov() ;
        
        @Data(size=10)
        IString fgh515ZMovLocl() ;
        
        @Data(size=1)
        IString fgh515IDbcr() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh515MMovimento() ;
        
        @Data(size=1)
        IString fgh515SMovimento() ;
        
        @Data(size=1)
        IString fgh515IEstorno() ;
        
        @Data(size=3)
        IString fgh515CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh515MSldoCbloApos() ;
        
        @Data(size=1)
        IString fgh515SSldoCbloApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh515MSldoDpnlApos() ;
        
        @Data(size=1)
        IString fgh515SSldoDpnlApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fgh515MMovMoeOrigMov() ;
        
        @Data(size=1)
        IString fgh515SMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh515XRefMov() ;
        
        @Data(size=10)
        ILong fgh515NDocOpps() ;
        
        @Data(size=10, decimal=7)
        IDecimal fgh515TJuro() ;
        
        @Data(size=2)
        IString fgh515AAplOrig() ;
        
        @Data(size=26)
        IString fgh515TsActzUlt() ;
        
        @Data(size=8)
        IString fgh515CUsidActzUlt() ;
        
    }
}
