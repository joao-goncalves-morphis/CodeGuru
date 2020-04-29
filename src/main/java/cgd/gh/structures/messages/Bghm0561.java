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


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm0561 extends IDataStruct {
    
    @Data(size=4, signed=true, value="180", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("0")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="0")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="180", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=3, value="0")
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
             * @return instancia da classe local CPaisIsoaCont
             */
            @Data
            CPaisIsoaCont cPaisIsoaCont() ;
            
            
            public interface CPaisIsoaCont extends IDataStruct {
                
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
            
            @Data(size=10)
            IString zPedido() ;
            
            @Data(size=1)
            IString cEstPed() ;
            
            @Data(size=2)
            IString cCanlTrmzInf() ;
            
            @Data(size=15)
            IString cEndcFtpDest() ;
            
            @Data(size=2)
            IString aAplDst() ;
            
            @Data(size=10)
            IString zCluzPed() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qDiasDpnzInf() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mParmPedHstMax() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mParmPedHstMin() ;
            
            @Data(size=15)
            IString cParmPedHstMax() ;
            
            @Data(size=15)
            IString cParmPedHstMin() ;
            
            @Data(size=20)
            IString nmFichOutpRtno() ;
            
            @Data(size=40)
            IString xMtvoDvlzPed() ;
            
            @Data(size=10)
            IString zEliminacaoPed() ;
            
            @Data(size=8)
            IString cUsidCrix() ;
            
            @Data(size=3)
            IString cPaisIsoaOpex() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
        }
    }
    
}
