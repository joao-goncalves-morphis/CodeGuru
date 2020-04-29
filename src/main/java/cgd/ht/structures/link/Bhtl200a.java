package cgd.ht.structures.link;

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
public interface Bhtl200a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTL200A   AREA DE COMUNICACOES PARA O MHTQ200A
     * 
     * @version 2.0
     * 
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
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            @Data
            @Condition("A2")
            ICondition erroDb2R00() ;
            @Data
            @Condition("DA")
            ICondition dadosInvalidos() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("005")
            ICondition erroDb2R01() ;
            @Data
            @Condition("127")
            ICondition aplicacaoInexist() ;
            
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
        }
    }
    
}
