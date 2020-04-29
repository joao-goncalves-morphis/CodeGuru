package cgd.gh.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
public interface Bghm0571 extends IDataStruct {
    
    @Data(size=4, signed=true, value="111", compression=COMP)
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
    
    @Data(size=4, signed=true, value="68", compression=COMP)
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
             * @return instancia da classe local CPedInfOpps
             */
            @Data
            CPedInfOpps cPedInfOpps() ;
            
            
            public interface CPedInfOpps extends IDataStruct {
                
                @Data(size=1)
                IInt cPedInfOppsS() ;
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
            
            @Data(size=50)
            IString dPedInfOpps() ;
            
            @Data(size=1)
            IString cFrmtInf() ;
            
            @Data(size=1)
            IString cTipoRpte() ;
            
            @Data(size=20)
            IString nmFichOutpRtno() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qDiaDpnzInf() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
        }
    }
    
}
