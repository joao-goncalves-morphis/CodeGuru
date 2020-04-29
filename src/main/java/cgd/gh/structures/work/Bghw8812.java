package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw8812 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * FICHEIRO FWK812
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        @Data(size=4, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        /**
         * @return instancia da classe local Conta
         */
        @Data
        Conta conta() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt iTipoItvt() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsTitc() ;
        
        @Data(size=2)
        IString iEstCont() ;
        
        @Data(size=10)
        IString zInicRel() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCblo() ;
        
        @Data(size=1)
        IString iExisRstzCont() ;
        
        @Data(size=45)
        IString filler() ;
        
        
        public interface Conta extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoCont() ;
            
        }
    }
    
}
