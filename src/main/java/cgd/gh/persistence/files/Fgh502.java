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
public abstract class Fgh502 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh502
     */
    @Data
    public abstract RegFgh502 regFgh502() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh502 extends IDataStruct {
        
        @Data(size=3)
        IString fgh502CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh502CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh502COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh502NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh502VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh502CTipoCont() ;
        
        @Data(size=3)
        IString fgh502CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh502NsDeposito() ;
        
        @Data(size=26)
        IString fgh502TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh502NsMovimento() ;
        
        @Data(size=10)
        IString fgh502ZValMov() ;
        
        @Data(size=10)
        IString fgh502ZMovLocl() ;
        
        @Data(size=1)
        IString fgh502IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh502MMovimento() ;
        
        @Data(size=1)
        IString fgh502IEstorno() ;
        
        @Data(size=3)
        IString fgh502CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh502MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh502MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh502MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh502XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh502NDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal fgh502TJuro() ;
        
        @Data(size=2)
        IString fgh502AAplOrig() ;
        
        @Data(size=26)
        IString fgh502TsActzUlt() ;
        
        @Data(size=8)
        IString fgh502CUsidActzUlt() ;
        
    }
}
