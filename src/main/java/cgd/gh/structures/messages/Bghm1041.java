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


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm1041 extends IDataStruct {
    
    @Data(size=4, signed=true, value="205", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("06")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="6")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="205", compression=COMP)
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
            
            @Data(size=21)
            IString nrOpeActf() ;
            
            @Data(size=9)
            IString dTipoMovDo() ;
            
            @Data(size=3)
            IString cPaisIsaCtaAcf() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContActf() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContActf() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContActf() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContActf() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContActf() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsPrclContActf() ;
            
            @Data(size=30)
            IString dTipoOpeActf() ;
            
            @Data(size=13, signed=true, compression=COMP3)
            ILong nsEvenActf() ;
            
            @Data(size=30)
            IString dTipoEvenActf() ;
            
            @Data(size=12)
            IString cEspeActf() ;
            
            @Data(size=30)
            IString dLoclNgcz() ;
            
            @Data(size=18, decimal=9, signed=true, compression=COMP3)
            IDecimal mPrcoActfObls() ;
            
            @Data(size=18, decimal=2, signed=true, compression=COMP3)
            IDecimal mOpeActf() ;
            
            @Data(size=1)
            IString iExisCotzActf() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=10)
            IString zOperacao() ;
            
            @Data(size=10)
            IString zLiqzMontObls() ;
            
        }
    }
    
}
