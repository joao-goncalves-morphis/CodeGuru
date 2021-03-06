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
public interface Bghm0581 extends IDataStruct {
    
    @Data(size=4, signed=true, value="3", compression=COMP)
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
    
    @Data(size=4, signed=true, value="3", compression=COMP)
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
        
        
        public interface Ase extends IDataStruct {
            
            /**
             * @return instancia da classe local IAcco
             */
            @Data
            IAcco iAcco() ;
            
            
            public interface IAcco extends IDataStruct {
                
                @Data(size=1)
                IString iAccaoS() ;
                @Data
                @Condition("0")
                ICondition iAccao0() ;
                @Data
                @Condition("1")
                ICondition iAccao1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAccaoM() ;
                
            }
        }
    }
    
}
