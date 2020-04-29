package cgd.gh.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
public interface Bghm1001 extends IDataStruct {
    
    @Data(size=4, signed=true, value="1161", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("10")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="10")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="1161", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=3, value="115")
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
            
            /**
             * @return instancia da classe local GrPed
             */
            @Data(length=10)
            IArray<GrPed> grPed() ;
            
            @Data(size=1)
            IString iMsgCtnd() ;
            
            @Data(size=7)
            IString cPedInfOppsK() ;
            
            
            public interface GrPed extends IDataStruct {
                
                
                @Data(size=7)
                IString cPedInfOpps() ;
                
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
    
}
