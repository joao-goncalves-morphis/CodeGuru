package cgd.gh.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm0911 extends IDataStruct {
    
    @Data(size=4, signed=true, value="1300", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("12")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="12")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="1300", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=3, value="146")
    IInt lengthOccur() ;
    
    /**
     * @return instancia da classe local Msg
     */
    @Data
    Msg msg() ;
    
    /**
     * Inner Classes
     */
    public interface Msg extends IDataStruct {
        
        /**
         * @return instancia da classe local Ase
         */
        @Data
        Ase ase() ;
        
        /**
         * @return instancia da classe local Ade
         */
        @Data
        Ade ade() ;
        
        
        public interface Ase extends IDataStruct {
            
            /**
             * @return instancia da classe local CPaisIsoaContSt
             */
            @Data
            CPaisIsoaContSt cPaisIsoaContSt() ;
            
            
            public interface CPaisIsoaContSt extends IDataStruct {
                
                @Data(size=1)
                IString cPaisIsoaContS() ;
                @Data
                @Condition("0")
                ICondition cPaisIsoaCont0() ;
                @Data
                @Condition("1")
                ICondition cPaisIsoaCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPaisIsoaContM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=3)
            IString cTitHono() ;
            
            @Data(size=35)
            IString nmCliAbvd() ;
            
            /**
             * @return instancia da classe local GrMov
             */
            @Data(length=12)
            IArray<GrMov> grMov() ;
            
            @Data(size=1)
            IString iMsgCtnd() ;
            
            @Data(size=26)
            IString tsMovimentoK() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimentoK() ;
            
            
            public interface GrMov extends IDataStruct {
                
                
                @Data(size=10)
                IString zMovimento() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimento() ;
                
                @Data(size=10)
                IString zValMov() ;
                
                @Data(size=21)
                IString xRefMov() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimento() ;
                
                @Data(size=1)
                IString iDbcr() ;
                
                @Data(size=1)
                IString iEstorno() ;
                
                @Data(size=3)
                IString cMoedIsoOriMov() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloApos() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoDpnlApos() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMoeOrigMov() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nDocOpps() ;
                
                @Data(size=2)
                IString aAplOrig() ;
                
                @Data(size=5, decimal=3, signed=true, compression=COMP3)
                IDecimal tJuro() ;
                
                @Data(size=1)
                IString iExisInfAdi() ;
                
            }
        }
    }
    
}
