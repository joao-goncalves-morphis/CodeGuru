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
public abstract class Fwkb16 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwkb16
     */
    @Data
    public abstract RegFwkb16 regFwkb16() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwkb16 extends IDataStruct {
        
        @Data(size=3)
        IString fwkb16CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwkb16CBancCont() ;
        
        @Data(size=4)
        IInt fwkb16COeEgcCont() ;
        
        @Data(size=7)
        IInt fwkb16NsRdclCont() ;
        
        @Data(size=1)
        IInt fwkb16VChkdCont() ;
        
        @Data(size=3)
        IInt fwkb16CTipoCont() ;
        
        @Data(size=3)
        IString fwkb16CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fwkb16NsDeposito() ;
        
        @Data(size=26)
        IString fwkb16TsMovimento() ;
        
        @Data(size=15)
        ILong fwkb16NsMovimento() ;
        
        @Data(size=10)
        IString fwkb16ZValMov() ;
        
        @Data(size=10)
        IString fwkb16ZMovLocl() ;
        
        @Data(size=1)
        IString fwkb16IDbcr() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwkb16MMovimento() ;
        
        @Data(size=1)
        IString fwkb16SMovimento() ;
        
        @Data(size=1)
        IString fwkb16IEstorno() ;
        
        @Data(size=3)
        IString fwkb16CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwkb16MSldoCbloApos() ;
        
        @Data(size=1)
        IString fwkb16SSldoCbloApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwkb16MSldoDpnlApos() ;
        
        @Data(size=1)
        IString fwkb16SSldoDpnlApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwkb16MMovMoeOrigMov() ;
        
        @Data(size=1)
        IString fwkb16SMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fwkb16XRefMov() ;
        
        @Data(size=10)
        ILong fwkb16NDocOpps() ;
        
        @Data(size=10, decimal=7)
        IDecimal fwkb16TJuro() ;
        
        @Data(size=2)
        IString fwkb16AAplOrig() ;
        
        @Data(size=26)
        IString fwkb16TsActzUlt() ;
        
        @Data(size=8)
        IString fwkb16CUsidActzUlt() ;
        
    }
}
