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
public interface Bghm0530 extends IDataStruct {
    
    @Data(size=4, signed=true, value="57", compression=COMP)
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
    
    @Data(size=4, signed=true, value="57", compression=COMP)
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
             * @return instancia da classe local TsPedidoSt
             */
            @Data
            TsPedidoSt tsPedidoSt() ;
            
            
            public interface TsPedidoSt extends IDataStruct {
                
                @Data(size=1)
                IString tsPedidoS() ;
                @Data
                @Condition("0")
                ICondition tsPedido0() ;
                @Data
                @Condition("1")
                ICondition tsPedido1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt tsPedidoM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=1)
            IString iAccao() ;
            @Data
            @Condition("C")
            ICondition criacao() ;
            @Data
            @Condition("A")
            ICondition anulacao() ;
            
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong tsPedido() ;
            
            /**
             * @return instancia da classe local GrOePed
             */
            @Data(length=5)
            IArray<GrOePed> grOePed() ;
            
            
            public interface GrOePed extends IDataStruct {
                
                
                @Data(size=3)
                IString cPaisIsoaDst() ;
                
                @Data(size=3)
                IString cMnemEgcDst() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcDest() ;
                
            }
        }
    }
    
}
