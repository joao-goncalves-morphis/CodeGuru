package cgd.gh.structures.link;

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
public interface Bghl300a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MGHJ300A")
    IString cMghj300a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE COMUNICACOES DA ROTINA MGHJ300A
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
        
        /**
         * @return instancia da classe local Erros
         */
        @Data
        Erros erros() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=1)
            IString iAccaoTabBbn() ;
            @Data
            @Condition("V")
            ICondition visualizacao() ;
            @Data
            @Condition("I")
            ICondition insercao() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("A")
            ICondition eliminacao() ;
            
            
            @Data(size=1)
            IString iAmbiente() ;
            @Data
            @Condition("O")
            ICondition bhol702aOnline() ;
            @Data
            @Condition("B")
            ICondition bhol702aBatch() ;
            
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=16)
            IString cRefMsgSwif() ;
            
            @Data(size=1)
            IString cTipoOpeCont() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwifI() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwifO() ;
            
        }
        
        public interface Erros extends IDataStruct {
            
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
            @Condition("  ")
            ICondition semErros() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=70)
            IString chAcesso() ;
            
        }
    }
    
}
