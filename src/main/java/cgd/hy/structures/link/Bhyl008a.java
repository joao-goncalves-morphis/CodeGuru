package cgd.hy.structures.link;

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
public interface Bhyl008a extends IDataStruct {
    
    @Data(size=8, value="MHYJ008A")
    IString mhyj008a() ;
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=2)
            IString aAplicacao() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=10)
            IString zContabilizacao() ;
            
            @Data(size=10)
            IString zCredito() ;
            
            @Data(size=10)
            IString zDebito() ;
            
            /**
             * CAMPOS DE ERRO
             */
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("A1")
            ICondition abend() ;
            @Data
            @Condition("A2")
            ICondition abendDb2() ;
            @Data
            @Condition("A3")
            ICondition abendCics() ;
            @Data
            @Condition("FU")
            ICondition erroFuncao() ;
            @Data
            @Condition("AT")
            ICondition erroArquitectura() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            @Data(size=30)
            IString chvAces() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
            @Data(size=30)
            IString campErro() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
        }
    }
    
}
