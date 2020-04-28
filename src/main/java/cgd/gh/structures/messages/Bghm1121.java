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
public interface Bghm1121 extends IDataStruct {
    
    @Data(size=4, signed=true, value="410", compression=COMP)
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
    
    @Data(size=4, signed=true, value="407", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=2, value="0")
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
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=3)
            IString cPaisIsaEmsDoc() ;
            
            @Data(size=3)
            IString cTipoDocId() ;
            
            @Data(size=20)
            IString nDocId() ;
            
            @Data(size=10)
            IString zVldeDocId() ;
            
            @Data(size=10)
            IString cEntEmixDocId() ;
            
            @Data(size=3)
            IString cPaisEmsDocApt() ;
            
            @Data(size=3)
            IString cTipoDocIdAptd() ;
            
            @Data(size=20)
            IString nDocIdAptd() ;
            
            @Data(size=10)
            IString zVldeDocIdAptd() ;
            
            @Data(size=10)
            IString cEntEmiDidAptd() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCheque() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=135)
            IString nmCliente() ;
            
            @Data(size=1)
            IString iCliCgd() ;
            
            @Data(size=1)
            IString cTipoItvtDep() ;
            
            @Data(size=1)
            IString cTipoMdti() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovEuro() ;
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            @Data(size=50)
            IString xInfAts() ;
            
            @Data(size=1)
            IString cTipoOpeCont() ;
            
            @Data(size=1)
            IString iTrnzEfcdOnln() ;
            
            @Data(size=1)
            IString iPedJstzOrmFnd() ;
            
            @Data(size=1)
            IString cMtvoPedJstz() ;
            
            @Data(size=1)
            IString iRcsJstzOrmFnd() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            /**
             * PASSIVAS 4497 - INI
             */
            @Data(size=1)
            IString cTipRelDep() ;
            
            @Data(size=50)
            IString xInfJstzDep() ;
            
        }
    }
    
}
