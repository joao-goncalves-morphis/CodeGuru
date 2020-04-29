package cgd.gh.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
public interface Bghm1000 extends IDataStruct {
    
    @Data(size=4, signed=true, value="10", compression=COMP)
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
    
    @Data(size=4, signed=true, value="10", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=1, value="0")
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
             * @return instancia da classe local CPedInfOppsSt
             */
            @Data
            CPedInfOppsSt cPedInfOppsSt() ;
            
            
            public interface CPedInfOppsSt extends IDataStruct {
                
                @Data(size=1)
                IString cPedInfOppsS() ;
                @Data
                @Condition("0")
                ICondition cPedInfOpps0() ;
                @Data
                @Condition("1")
                ICondition cPedInfOpps1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPedInfOppsM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=7)
            IString cPedInfOpps() ;
            
        }
    }
    
}
