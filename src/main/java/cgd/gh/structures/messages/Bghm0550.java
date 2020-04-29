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
public interface Bghm0550 extends IDataStruct {
    
    @Data(size=4, signed=true, value="131", compression=COMP)
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
    
    @Data(size=4, signed=true, value="131", compression=COMP)
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
             * @return instancia da classe local CAccaoSt
             */
            @Data
            CAccaoSt cAccaoSt() ;
            
            
            public interface CAccaoSt extends IDataStruct {
                
                @Data(size=1)
                IInt cAccaoS() ;
                @Data
                @Condition("0")
                ICondition cAccao0() ;
                @Data
                @Condition("1")
                ICondition cAccao1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cAccaoM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=2)
            IString cAccao() ;
            @Data
            @Condition("C")
            ICondition consultar() ;
            @Data
            @Condition("I")
            ICondition criar() ;
            @Data
            @Condition("A")
            ICondition modificar() ;
            @Data
            @Condition("E")
            ICondition eliminar() ;
            
            
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
            
            @Data(size=3)
            IString cMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDeposito() ;
            
            @Data(size=26)
            IString tsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=70)
            IString xInfPeslMov() ;
            
        }
    }
    
}
