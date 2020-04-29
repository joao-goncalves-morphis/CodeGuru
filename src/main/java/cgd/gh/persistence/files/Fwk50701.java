package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.arrays.IArray ;
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
public abstract class Fwk50701 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rwk50201
     */
    @Data
    public abstract Rwk50201 rwk50201() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rwk50201 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk502Subconta
         */
        @Data
        Fwk502Subconta fwk502Subconta() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk502NsMovimento() ;
        
        @Data(size=10)
        IString fwk502ZMovimento() ;
        
        @Data(size=10)
        IString fwk502ZValMov() ;
        
        @Data(size=1)
        IString fwk502IDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk502MMovimento() ;
        
        @Data(size=1)
        IString fwk502IEstorno() ;
        
        @Data(size=3)
        IString fwk502CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk502MSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk502MSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk502MMovMoeOrigMov() ;
        
        @Data(size=40)
        IString fwk502XRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fwk502NDocOpps() ;
        
        @Data(size=2)
        IString fwk502AAplOrig() ;
        
        @Data(size=5)
        IString fwk502COpeBbn() ;
        
        @Data(size=3)
        IString fwk502COpczMenu() ;
        
        @Data(size=4)
        IString fwk502CTipoCanlAces() ;
        
        @Data(size=2)
        IString fwk502CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk502CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk502COeEgcOpex() ;
        
        @Data(size=4)
        IString fwk502CEvenOpel() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk502TCambio() ;
        
        @Data(size=100)
        IString fwk502ChvFicheiro() ;
        
        /**
         * @return instancia da classe local Fwk502GrFicheiro
         */
        @Data(length=3)
        IArray<Fwk502GrFicheiro> fwk502GrFicheiro() ;
        
        
        public interface Fwk502Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fwk502CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk502CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk502COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk502NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk502VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk502CTipoCont() ;
            
            @Data(size=3)
            IString fwk502CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk502NsDeposito() ;
            
        }
        
        public interface Fwk502GrFicheiro extends IDataStruct {
            
            
            @Data(size=6)
            IString fwk502NmFicheiro() ;
            
        }
    }
}
