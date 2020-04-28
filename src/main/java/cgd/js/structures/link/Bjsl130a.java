package cgd.js.structures.link;

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
public interface Bjsl130a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MJSS130A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE LIGACAO PARA O MODULO MJSS130A
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cRetorno() ;
        @Data
        @Condition("000")
        ICondition ok() ;
        @Data
        @Condition("233")
        ICondition dadosInvalidos() ;
        @Data
        @Condition("097")
        ICondition naoExiste() ;
        @Data
        @Condition("216")
        ICondition db2() ;
        
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong cSqlcode() ;
        
        @Data(size=5)
        IString cSqlstate() ;
        
        /**
         * @return instancia da classe local Argumento
         */
        @Data
        Argumento argumento() ;
        
        /**
         * @return instancia da classe local CDetalhe
         */
        @Data
        CDetalhe cDetalhe() ;
        
        
        public interface Argumento extends IDataStruct {
            
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
            
            @Data(size=4)
            IString cTerminal() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=26)
            IString tsTransaccao() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=3)
            IString cMoedIsoOriMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCheque() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
            @Data(size=8)
            IString cUserid() ;
            
        }
        
        public interface CDetalhe extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbn() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
        }
    }
    
}
