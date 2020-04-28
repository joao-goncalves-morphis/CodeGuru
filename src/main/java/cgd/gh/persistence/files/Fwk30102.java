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
public abstract class Fwk30102 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rwk30101Pghc091a
     */
    @Data
    public abstract Rwk30101Pghc091a rwk30101Pghc091a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface Rwk30101Pghc091a extends IDataStruct {
        
        @Data(size=3)
        IString fwk301CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk301CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk301COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk301NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk301VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk301CTipoCont() ;
        
        @Data(size=3)
        IString fwk301CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk301NsDeposito() ;
        
        @Data(size=26)
        IString fwk301TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk301NsMovimento() ;
        
        @Data(size=10)
        IString fwk301ZValMov() ;
        
        @Data(size=10)
        IString fwk301ZMovLocl() ;
        
        @Data(size=1)
        IString fwk301IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk301MMovimento() ;
        
        @Data(size=1)
        IString fwk301IEstorno() ;
        
        @Data(size=3)
        IString fwk301CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk301MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk301MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk301MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fwk301XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fwk301NDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal fwk301TJuro() ;
        
        @Data(size=2)
        IString fwk301AAplOrig() ;
        
        @Data(size=1)
        IString fwk301IExisInfAdi() ;
        
        @Data(size=40)
        IString fwk301XChavAcsInfAdi() ;
        
        @Data(size=26)
        IString fwk301TsActzUlt() ;
        
        @Data(size=8)
        IString fwk301CUsidActzUlt() ;
        
    }
}
