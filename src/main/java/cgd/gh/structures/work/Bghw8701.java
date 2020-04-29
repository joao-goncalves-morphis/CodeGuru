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
public interface Bghw8701 extends IDataStruct {
    
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
     * LAYOUT DO FICHEIRO FWK701 CRIADO NO PGHQ082A
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        /**
         * @return instancia da classe local Conta
         */
        @Data
        Conta conta() ;
        
        /**
         * @return instancia da classe local XInfPend
         */
        @Data
        XInfPend xInfPend() ;
        
        
        public interface Conta extends IDataStruct {
            
            @Data(size=13, signed=true, compression=COMP3)
            ILong nConta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBanco() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDeposito() ;
            
        }
        
        public interface XInfPend extends IDataStruct {
            
            /**
             * @return instancia da classe local TsPndeX
             */
            @Data
            TsPndeX tsPndeX() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cCcmz() ;
            
            @Data(size=4)
            IString cTerminal() ;
            
            @Data(size=4)
            IString cTransaccao() ;
            
            @Data(size=3)
            IString cMoedIsoMov() ;
            
            @Data(size=12)
            IString dPnde() ;
            
            /**
             * @return instancia da classe local DTransaccao
             */
            @Data
            DTransaccao dTransaccao() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovCtrv() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCbloCtrv() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mPnde() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoDpnlApos() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nDocOppsMov() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong zValMov() ;
            
            
            public interface TsPndeX extends IDataStruct {
                
                @Data(size=14, signed=true, compression=COMP3)
                ILong tsPnde() ;
                
            }
            
            public interface DTransaccao extends IDataStruct {
                
                @Data(size=3)
                IString dTransTip() ;
                
                @Data(size=3)
                IString filler() ;
                
            }
        }
    }
    
}
