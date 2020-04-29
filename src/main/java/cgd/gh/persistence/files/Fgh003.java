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
public abstract class Fgh003 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh0030102
     */
    @Data
    public abstract Rgh0030102 rgh00301() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh00301 extends IDataStruct {
        
        @Data(size=3)
        IString fgh003CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh003CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh003COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh003NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh003VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh003CTipoCont() ;
        
        @Data(size=3)
        IString fgh003CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh003NsDeposito() ;
        
        @Data(size=26)
        IString fgh003TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh003NsMovimento() ;
        
        @Data(size=10)
        IString fgh003ZValMov() ;
        
        @Data(size=10)
        IString fgh003ZMovLocl() ;
        
        @Data(size=1)
        IString fgh003IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MMovimento() ;
        
        @Data(size=1)
        IString fgh003IEstorno() ;
        
        @Data(size=3)
        IString fgh003CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh003XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh003NDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal fgh003TJuro() ;
        
        @Data(size=2)
        IString fgh003AAplOrig() ;
        
        @Data(size=1)
        IString fgh003IExisInfAdi() ;
        
        @Data(size=40)
        IString fgh003XChavAcsInfAdi() ;
        
        @Data(size=26)
        IString fgh003TsActzUlt() ;
        
        @Data(size=8)
        IString fgh003CUsidActzUlt() ;
        
    }
    public interface Rgh0030102 extends IDataStruct {
        
        @Data(size=3)
        IString fgh003CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh003CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh003COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh003NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh003VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh003CTipoCont() ;
        
        @Data(size=3)
        IString fgh003CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh003NsDeposito() ;
        
        @Data(size=26)
        IString fgh003TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh003NsMovimento() ;
        
        @Data(size=10)
        IString fgh003ZValMov() ;
        
        @Data(size=10)
        IString fgh003ZMovLocl() ;
        
        @Data(size=1)
        IString fgh003IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MMovimento() ;
        
        @Data(size=1)
        IString fgh003IEstorno() ;
        
        @Data(size=3)
        IString fgh003CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh003MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fgh003XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh003NDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal fgh003TJuro() ;
        
        @Data(size=2)
        IString fgh003AAplOrig() ;
        
        @Data(size=1)
        IString fgh003IExisInfAdi() ;
        
        @Data(size=40)
        IString fgh003XChavAcsInfAdi() ;
        
        @Data(size=26)
        IString fgh003TsActzUlt() ;
        
        @Data(size=8)
        IString fgh003CUsidActzUlt() ;
        
    }
}
