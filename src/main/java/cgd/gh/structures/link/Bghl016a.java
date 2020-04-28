package cgd.gh.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
public interface Bghl016a extends IDataStruct {
    
    @Data(size=2)
    IString cAcesso() ;
    @Data
    @Condition({ "C", "L", "I", "E" })
    ICondition acessoValido() ;
    @Data
    @Condition("C")
    ICondition consultar() ;
    @Data
    @Condition("L")
    ICondition listar() ;
    @Data
    @Condition("I ")
    ICondition inserir() ;
    @Data
    @Condition("E ")
    ICondition eliminar() ;
    
    
    @Data(size=3)
    IInt cRetorno() ;
    @Data
    @Condition("0")
    ICondition ok() ;
    @Data
    @Condition("233")
    ICondition dadosInvalidos() ;
    @Data
    @Condition("099")
    ICondition naoExisteInf() ;
    @Data
    @Condition("089")
    ICondition jaExiste() ;
    @Data
    @Condition("094")
    ICondition estadoPdInv() ;
    @Data
    @Condition("077")
    ICondition existePedido() ;
    @Data
    @Condition("216")
    ICondition db2() ;
    
    
    @Data(size=9, signed=true, compression=COMP3)
    ILong cSqlcode() ;
    
    /**
     * @return instancia da classe local Argumento
     */
    @Data
    Argumento argumento() ;
    
    /**
     * @return instancia da classe local Detalhe
     */
    @Data
    Detalhe detalhe() ;
    
    @Data(size=2)
    IInt qItens() ;
    
    /**
     * @return instancia da classe local Tabela
     */
    @Data
    Tabela tabela() ;
    
    /**
     * Inner Classes
     */
    public interface Argumento extends IDataStruct {
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong tsPedido() ;
        
        @Data(size=3)
        IString cPaisIsoaDest() ;
        
        @Data(size=3)
        IString cMnemEgcDest() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcDest() ;
        
    }
    public interface Detalhe extends IDataStruct {
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    public interface Tabela extends IDataStruct {
        
        /**
         * @return instancia da classe local Lista
         */
        @Data(length=11)
        IArray<Lista> lista() ;
        
        
        public interface Lista extends IDataStruct {
            
            
            /**
             * @return instancia da classe local Item
             */
            @Data
            Item item() ;
            
            
            public interface Item extends IDataStruct {
                
                @Data(size=17)
                IString itemArgumento() ;
                
                @Data(size=34)
                IString itemDetalhe() ;
                
            }
        }
    }
    
}
