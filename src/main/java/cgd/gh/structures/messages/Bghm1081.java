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
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm1081 extends IDataStruct {
    
    @Data(size=4, signed=true, value="1151", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("22")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="22")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="1151", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=2, value="51")
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
             * @return instancia da classe local CPaisIsoaOpcrSt
             */
            @Data
            CPaisIsoaOpcrSt cPaisIsoaOpcrSt() ;
            
            
            public interface CPaisIsoaOpcrSt extends IDataStruct {
                
                @Data(size=1)
                IString cPaisIsoaOpcrS() ;
                @Data
                @Condition("0")
                ICondition cPaisIsoaOpcr0() ;
                @Data
                @Condition("1")
                ICondition cPaisIsoaOpcr1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPaisIsoaOpcrM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaOpcr() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancOpcr() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpcr() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclOpcr() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdOpcr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContOpcr() ;
            
            @Data(size=1)
            IString cSitOpcr() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            /**
             * @return instancia da classe local Linha
             */
            @Data(length=22)
            IArray<Linha> linha() ;
            
            
            public interface Linha extends IDataStruct {
                
                
                @Data(size=10)
                IString zMovimentoL() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimentoL() ;
                
                @Data(size=10)
                IString zValMovL() ;
                
                @Data(size=5)
                IString cOpeBbnL() ;
                
                @Data(size=1)
                IString iDbcrL() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimentoL() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsPrszOpcrL() ;
                
            }
        }
    }
    
}
