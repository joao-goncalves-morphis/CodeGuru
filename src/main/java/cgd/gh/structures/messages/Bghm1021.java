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
public interface Bghm1021 extends IDataStruct {
    
    @Data(size=4, signed=true, value="180", compression=COMP)
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
    
    @Data(size=4, signed=true, value="180", compression=COMP)
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
            IString cTipoJuro() ;
            
            @Data(size=30)
            IString dCodAbvdJuro() ;
            
            @Data(size=10)
            IString zInicPerCalc() ;
            
            @Data(size=10)
            IString zFimPerCalc() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mJuro() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mImposto() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mIsezImp() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mJmorPago() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mImpJmorPago() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovCtrvEuro() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambEuro() ;
            
            @Data(size=3)
            IString cPaisIsoaJur() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContJur() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContJur() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContJur() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContJur() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContJur() ;
            
            @Data(size=3)
            IString cMoedIsoSctaJur() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepositoJur() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsCmrg() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsSdep() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=30)
            IString dCodAbvdProd() ;
            
        }
    }
    
}
