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
public interface Bghm0951 extends IDataStruct {
    
    @Data(size=4, signed=true, value="27", compression=COMP)
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
    
    @Data(size=4, signed=true, value="27", compression=COMP)
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
            
            /**
             * @return instancia da classe local PosicaoActual
             */
            @Data
            PosicaoActual posicaoActual() ;
            
            /**
             * @return instancia da classe local PosicaoMov
             */
            @Data
            PosicaoMov posicaoMov() ;
            
            
            public interface PosicaoActual extends IDataStruct {
                
                @Data(size=3)
                IString cFamiProd() ;
                
                @Data(size=3)
                IString cProduto() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt cSectIttlBpor() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cCndzMovzCont() ;
                
            }
            
            public interface PosicaoMov extends IDataStruct {
                
                @Data(size=3)
                IString cFamiProdMov() ;
                
                @Data(size=3)
                IString cProdutoMov() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt cSectIttlBporMov() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cCndzMovzContMov() ;
                
            }
        }
    }
    
}
