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
public interface Bghm1051 extends IDataStruct {
    
    @Data(size=4, signed=true, value="570", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("05")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="5")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="570", compression=COMP)
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
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=4)
            IString cSeveOpel() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nContribuinte() ;
            
            @Data(size=1)
            IString iTipoPagEncg() ;
            
            /**
             * @return instancia da classe local TabelaEncargos
             */
            @Data(length=5)
            IArray<TabelaEncargos> tabelaEncargos() ;
            
            
            public interface TabelaEncargos extends IDataStruct {
                
                
                @Data(size=1)
                IString cTipoEncg() ;
                
                @Data(size=3)
                IString cEncargo() ;
                
                @Data(size=3)
                IString cMoeIsoPaisEcg() ;
                
                @Data(size=5)
                IString cOpeBbnEncg() ;
                
                @Data(size=5)
                IString cOpeBbnEcgAnlz() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncgStd() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncgNgcd() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncgIsenUtl() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mEncargo() ;
                
                @Data(size=3)
                IString cImposto() ;
                
                @Data(size=3)
                IString cMoedIsoImp() ;
                
                @Data(size=5)
                IString cOpeBbnImp() ;
                
                @Data(size=5)
                IString cOpeBbnImpAnlz() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mImposto() ;
                
                @Data(size=10, decimal=7, compression=COMP3)
                IDecimal tImposto() ;
                
                @Data(size=10, decimal=7, compression=COMP3)
                IDecimal tImpStd() ;
                
                @Data(size=5)
                IString cOpeBbnIsezImp() ;
                
                @Data(size=5)
                IString cOpeBbnIseAnlz() ;
                
                @Data(size=17, decimal=2, compression=COMP3)
                IDecimal mIsezImp() ;
                
            }
        }
    }
    
}
