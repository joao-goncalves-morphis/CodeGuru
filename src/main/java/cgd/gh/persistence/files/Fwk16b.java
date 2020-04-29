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
public abstract class Fwk16b extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk16bPghq330a
     */
    @Data
    public abstract RegFwk16bPghq330a regFwk16bPghq330a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk16bPghq330a extends IDataStruct {
        
        @Data(size=3)
        IString fwk16bCPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwk16bCBancCont() ;
        
        @Data(size=4)
        IInt fwk16bCOeEgcCont() ;
        
        @Data(size=7)
        IInt fwk16bNsRdclCont() ;
        
        @Data(size=1)
        IInt fwk16bVChkdCont() ;
        
        @Data(size=3)
        IInt fwk16bCTipoCont() ;
        
        @Data(size=3)
        IString fwk16bCMoedIsoScta() ;
        
        @Data(size=4)
        IInt fwk16bNsDeposito() ;
        
        @Data(size=26)
        IString fwk16bTsMovimento() ;
        
        @Data(size=15)
        ILong fwk16bNsMovimento() ;
        
        @Data(size=10)
        IString fwk16bZValMov() ;
        
        @Data(size=10)
        IString fwk16bZMovLocl() ;
        
        @Data(size=1)
        IString fwk16bIDbcr() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk16bMMovimento() ;
        
        @Data(size=1)
        IString fwk16bSMovimento() ;
        
        @Data(size=1)
        IString fwk16bIEstorno() ;
        
        @Data(size=3)
        IString fwk16bCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk16bMSldoCbloApos() ;
        
        @Data(size=1)
        IString fwk16bSSldoCbloApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk16bMSldoDpnlApos() ;
        
        @Data(size=1)
        IString fwk16bSSldoDpnlApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk16bMMovMoeOrigMov() ;
        
        @Data(size=1)
        IString fwk16bSMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fwk16bXRefMov() ;
        
        @Data(size=10)
        ILong fwk16bNDocOpps() ;
        
        @Data(size=10, decimal=7)
        IDecimal fwk16bTJuro() ;
        
        @Data(size=2)
        IString fwk16bAAplOrig() ;
        
        @Data(size=26)
        IString fwk16bTsActzUlt() ;
        
        @Data(size=8)
        IString fwk16bCUsidActzUlt() ;
        
    }
}
