package cgd.hy.structures.link;

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
public interface Bhyl009a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHYJ009A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHYL009A
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=7)
            IString cMapa() ;
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBanco() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=1)
            IString iModAcesso() ;
            @Data
            @Condition("1")
            ICondition iModAcesPais() ;
            @Data
            @Condition("2")
            ICondition iModAcesMapa() ;
            
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            /**
             * @return instancia da classe local Dados
             */
            @Data(length=10)
            IArray<Dados> dados() ;
            
            
            public interface Dados extends IDataStruct {
                
                @Data(size=3)
                IString cMnemEgcDest() ;
                
                @Data(size=3)
                IString cPaisIsoaOeDst() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcDest() ;
                
                @Data(size=3)
                IString cIdiIsoPrdzMap() ;
                
            }
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
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
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition(" ")
            ICondition semErros() ;
            
            
        }
    }
    
}
