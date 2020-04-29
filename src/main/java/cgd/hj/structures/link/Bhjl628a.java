package cgd.hj.structures.link;

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
public interface Bhjl628a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ628A")
    IString conMhjj628a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL628A - AREA DE LIGACAO AO MODULO MHJJ628A
     * MANUTENCAO DA TABELA DE DOCUMENTOS DE IDENTIFICACAO (THJ00023)
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        @Data(size=1)
        IString iAccao() ;
        @Data
        @Condition("V")
        ICondition visualizacao() ;
        @Data
        @Condition("I")
        ICondition insercao() ;
        @Data
        @Condition("E")
        ICondition eliminacao() ;
        @Data
        @Condition("M")
        ICondition modificacao() ;
        
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        /**
         * @return instancia da classe local Thj00023Docid
         */
        @Data
        Thj00023Docid thj00023Docid() ;
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface Thj00023Docid extends IDataStruct {
            
            /**
             * @return instancia da classe local DadosInput
             */
            @Data
            DadosInput dadosInput() ;
            
            /**
             * @return instancia da classe local DadosInOut
             */
            @Data
            DadosInOut dadosInOut() ;
            
            
            public interface DadosInput extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsaEmsDoc() ;
                
                @Data(size=3)
                IString cTipoDocId() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nCliente() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsAbraCli() ;
                
                @Data(size=8)
                IString cUsidActzUlt() ;
                
            }
            
            public interface DadosInOut extends IDataStruct {
                
                @Data(size=20)
                IString nDocId() ;
                
                @Data(size=10)
                IString zEmisDocId() ;
                
                @Data(size=10)
                IString zVldeDocId() ;
                
                @Data(size=10)
                IString cEntEmixDocId() ;
                
                @Data(size=26)
                IString tsActzUlt() ;
                
            }
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("501")
            ICondition inputInsuf() ;
            @Data
            @Condition("802")
            ICondition codAcessoNExist() ;
            @Data
            @Condition("535")
            ICondition docNaoExis() ;
            @Data
            @Condition("539")
            ICondition docExiste() ;
            
            
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
            ICondition errosFuncao() ;
            @Data
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
