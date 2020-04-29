package cgd.gh.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
public interface Bghm0991 extends IDataStruct {
    
    @Data(size=4, signed=true, value="29", compression=COMP)
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
    
    @Data(size=4, signed=true, value="29", compression=COMP)
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
                IInt cPaisIsoaContS() ;
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
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cOeEgcOpex() ;
            
            @Data(size=8)
            IString nmArqvOrig() ;
            
            @Data(size=4)
            IString cTransaccao() ;
            
            @Data(size=2)
            IString aAplicacao() ;
            
            @Data(size=3)
            IString cOpczMenu() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambio() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoRetd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoVcob() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgLim() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgUtid() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboNgcdUtid() ;
            
            @Data(size=1)
            IString iTipoSpte() ;
            
            @Data(size=40)
            IString dMovSpte() ;
            
        }
    }
    
}
