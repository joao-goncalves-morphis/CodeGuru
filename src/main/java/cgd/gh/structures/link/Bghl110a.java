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
public interface Bghl110a extends IDataStruct {
    
    @Data(size=3)
    IInt cRetorno() ;
    @Data
    @Condition("0")
    ICondition ok() ;
    @Data
    @Condition("233")
    ICondition dadosInvalidos() ;
    @Data
    @Condition("097")
    ICondition naoExiste() ;
    @Data
    @Condition("098")
    ICondition naoExisteConta() ;
    @Data
    @Condition("216")
    ICondition db2() ;
    
    
    @Data(size=9, signed=true, compression=COMP3)
    ILong cSqlcode() ;
    
    @Data(size=1)
    IString tipoRecurso() ;
    @Data
    @Condition("T")
    ICondition tabela() ;
    @Data
    @Condition("P")
    ICondition tape() ;
    
    
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
     * @return instancia da classe local Tab
     */
    @Data
    Tab tab() ;
    
    /**
     * Inner Classes
     */
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
        
    }
    public interface Detalhe extends IDataStruct {
        
        @Data(size=8)
        IString nmRecurso() ;
        
        @Data(size=1)
        IString cTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt zaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt zaFim() ;
        
    }
    public interface Tab extends IDataStruct {
        
        /**
         * GH 2292 - INI
         * 05  MGH110A-LISTA OCCURS 20 TIMES
         * @return instancia da classe local Lista
         */
        @Data(length=30)
        IArray<Lista> lista() ;
        
        
        
        /**
         * 
         * GH 2292 - INI
         * 05  MGH110A-LISTA OCCURS 20 TIMES
         * 
         * @version 2.0
         * 
         */
        public interface Lista extends IDataStruct {
            
            
            /**
             * @return instancia da classe local Item
             */
            @Data
            Item item() ;
            
            
            public interface Item extends IDataStruct {
                
                @Data(size=22)
                IString itemArgumento() ;
                
                @Data(size=15)
                IString itemDetalhe() ;
                
            }
        }
    }
    
}
