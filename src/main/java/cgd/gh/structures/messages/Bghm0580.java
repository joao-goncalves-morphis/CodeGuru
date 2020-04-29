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
public interface Bghm0580 extends IDataStruct {
    
    @Data(size=4, signed=true, value="87", compression=COMP)
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
    
    @Data(size=4, signed=true, value="87", compression=COMP)
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
             * @return instancia da classe local IAccaoSt
             */
            @Data
            IAccaoSt iAccaoSt() ;
            
            
            public interface IAccaoSt extends IDataStruct {
                
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
        
        public interface Ade extends IDataStruct {
            
            @Data(size=1)
            IString iAccao() ;
            @Data
            @Condition("C")
            ICondition criacao() ;
            @Data
            @Condition("A")
            ICondition eliminacao() ;
            
            
            @Data(size=7)
            IString cPedInfOpps() ;
            
            @Data(size=50)
            IString dPedInfOpps() ;
            
            @Data(size=1)
            IString cFrmtInf() ;
            @Data
            @Condition({ "X", "T", "N" })
            ICondition frmtValido() ;
            @Data
            @Condition("X")
            ICondition excel() ;
            @Data
            @Condition("T")
            ICondition texto() ;
            @Data
            @Condition("N")
            ICondition normal() ;
            
            
            @Data(size=1)
            IString cTipoRpte() ;
            @Data
            @Condition({ "M", "F", "T" })
            ICondition rpteValido() ;
            @Data
            @Condition("M")
            ICondition mapa() ;
            @Data
            @Condition("F")
            ICondition ficheiro() ;
            @Data
            @Condition("T")
            ICondition transaccao() ;
            
            
            @Data(size=20)
            IString nmFichOutpRtno() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qDiaDpnzInf() ;
            
            @Data(size=1)
            IString iAtrzElmPed() ;
            @Data
            @Condition("Z")
            ICondition autorizado() ;
            
            
        }
    }
    
}
