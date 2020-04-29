package cgd.hj.structures.messages;

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
public interface Bhjm1460 extends IDataStruct {
    
    @Data(size=4, signed=true, value="269", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="5")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("12")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="12")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="269", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=2, value="17")
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
             * @return instancia da classe local NClienteSt
             */
            @Data
            NClienteSt nClienteSt() ;
            
            /**
             * @return instancia da classe local NsAbraCliSt
             */
            @Data
            NsAbraCliSt nsAbraCliSt() ;
            
            /**
             * @return instancia da classe local CodOrigClienteSt
             */
            @Data
            CodOrigClienteSt codOrigClienteSt() ;
            
            /**
             * @return instancia da classe local CTipoCliSt
             */
            @Data
            CTipoCliSt cTipoCliSt() ;
            
            /**
             * @return instancia da classe local CEvenOpelSt
             */
            @Data
            CEvenOpelSt cEvenOpelSt() ;
            
            
            public interface NClienteSt extends IDataStruct {
                
                @Data(size=1)
                IString nClienteS() ;
                @Data
                @Condition("0")
                ICondition nCliente0() ;
                @Data
                @Condition("1")
                ICondition nCliente1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nClienteM() ;
                
            }
            
            public interface NsAbraCliSt extends IDataStruct {
                
                @Data(size=1)
                IString nsAbraCliS() ;
                @Data
                @Condition("0")
                ICondition nsAbraCli0() ;
                @Data
                @Condition("1")
                ICondition nsAbraCli1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsAbraCliM() ;
                
            }
            
            public interface CodOrigClienteSt extends IDataStruct {
                
                @Data(size=1)
                IString codOrigClienteS() ;
                @Data
                @Condition("0")
                ICondition codOrigCliente0() ;
                @Data
                @Condition("1")
                ICondition codOrigCliente1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt codOrigClienteM() ;
                
            }
            
            public interface CTipoCliSt extends IDataStruct {
                
                @Data(size=1)
                IString cTipoCliS() ;
                @Data
                @Condition("0")
                ICondition cTipoCli0() ;
                @Data
                @Condition("1")
                ICondition cTipoCli1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoCliM() ;
                
            }
            
            public interface CEvenOpelSt extends IDataStruct {
                
                @Data(size=1)
                IString cEvenOpelS() ;
                @Data
                @Condition("0")
                ICondition cEvenOpel0() ;
                @Data
                @Condition("1")
                ICondition cEvenOpel1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cEvenOpelM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=35)
            IString nmCliAbvd() ;
            
            @Data(size=2)
            IString codOrigCliente() ;
            
            @Data(size=1)
            IString cTipoCli() ;
            @Data
            @Condition("P")
            ICondition particular() ;
            @Data
            @Condition("I")
            ICondition empresarioIndividual() ;
            @Data
            @Condition("E")
            ICondition empresa() ;
            
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            /**
             * @return instancia da classe local AdeL
             */
            @Data(length=12)
            IArray<AdeL> adeL() ;
            
            
            public interface AdeL extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsaEmsDoc() ;
                
                @Data(size=3)
                IString cTipoDocSpte() ;
                
                @Data(size=1)
                IString iEtgaDoc() ;
                @Data
                @Condition("S")
                ICondition documentoEntregue() ;
                @Data
                @Condition("N")
                ICondition documentoNEntregue() ;
                
                
                @Data(size=10)
                IString zFimVlde() ;
                
            }
        }
    }
    
}
