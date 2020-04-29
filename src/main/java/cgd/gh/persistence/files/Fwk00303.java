package cgd.gh.persistence.files;

import cgd.gh.persistence.files.Fgh003.Rgh00301 ;
import cgd.gh.persistence.files.Fgh003.Rgh0030102 ;
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
public abstract class Fwk00303 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk003
     */
    @Data
    public abstract RegFwk003 regFwk003() ;
    
    /**
     * @return instancia da classe Rgh0030102
     */
    @Data
    public abstract Rgh0030102 rgh00301() ;
    
    /**
     * @return instancia da classe Rgh0030102
     */
    @Data
    public abstract Rgh0030102 rgh0030102() ;
    
    /**
     * @return instancia da classe local Rwk00301Pghc090a
     */
    @Data
    public abstract Rwk00301Pghc090a rwk00301Pghc090a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface Rwk00301Pghc090a extends IDataStruct {
        
        @Data(size=3)
        IString fwk003CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk003NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk003VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk003CTipoCont() ;
        
        @Data(size=3)
        IString fwk003CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003NsDeposito() ;
        
        @Data(size=26)
        IString fwk003TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk003NsMovimento() ;
        
        @Data(size=10)
        IString fwk003ZValMov() ;
        
        @Data(size=10)
        IString fwk003ZMovLocl() ;
        
        @Data(size=1)
        IString fwk003IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk003MMovimento() ;
        
        @Data(size=1)
        IString fwk003IEstorno() ;
        
        @Data(size=3)
        IString fwk003CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk003MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk003MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk003MMovMoeOrigMov() ;
        
        @Data(size=21)
        IString fwk003XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fwk003NDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal fwk003TJuro() ;
        
        @Data(size=2)
        IString fwk003AAplOrig() ;
        
        @Data(size=1)
        IString fwk003IExisInfAdi() ;
        
        @Data(size=40)
        IString fwk003XChavAcsInfAdi() ;
        
        @Data(size=26)
        IString fwk003TsActzUlt() ;
        
        @Data(size=8)
        IString fwk003CUsidActzUlt() ;
        
    }
    /**
     * Global
     */
    public interface RegFwk003 extends IDataStruct {
        
        @Data(size=3)
        IString fwk003CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk003NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk003VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk003CTipoCont() ;
        
        @Data(size=3)
        IString fwk003CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003NsDeposito() ;
        
        @Data(size=8)
        IString fwk003NmRecurso() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk003ZaFim() ;
        
        @Data(size=1)
        IString fwk003IAcao() ;
        
    }
}
