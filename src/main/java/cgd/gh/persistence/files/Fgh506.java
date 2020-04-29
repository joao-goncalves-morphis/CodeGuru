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
public abstract class Fgh506 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rgh50601
     */
    @Data
    public abstract Rgh50601 rgh50601() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rgh50601 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh506Subconta
         */
        @Data
        Fgh506Subconta fgh506Subconta() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh506NsMovimento() ;
        
        @Data(size=10)
        IString fgh506ZMovimento() ;
        
        @Data(size=10)
        IString fgh506ZValor() ;
        
        @Data(size=21)
        IString fgh506XRefMov() ;
        
        @Data(size=3)
        IString fgh506CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh506MMovMoeOrigMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh506MMovimento() ;
        
        @Data(size=1)
        IString fgh506IEstorno() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh506MSldoCblo() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh506MSldoDpnl() ;
        
        @Data(size=4)
        IString fgh506CTipoCanlAces() ;
        
        @Data(size=3)
        IString fgh506CMnemEgcOpex() ;
        
        @Data(size=3)
        IString fgh506CPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh506COeEgcOpex() ;
        
        @Data(size=2)
        IString fgh506AAplicacao() ;
        
        @Data(size=3)
        IString fgh506COpczMenu() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh506NCheque() ;
        
        @Data(size=4)
        IString fgh506CEvenOpel() ;
        
        @Data(size=1)
        IString fgh506IDbcr() ;
        
        @Data(size=15)
        IString fgh506CEndcFtpDest() ;
        
        
        public interface Fgh506Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fgh506CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh506CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh506COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fgh506NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fgh506VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fgh506CTipoCont() ;
            
            @Data(size=3)
            IString fgh506CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fgh506NsDeposito() ;
            
        }
    }
}
