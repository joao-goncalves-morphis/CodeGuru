package cgd.sx.structures.link;

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
public interface Bsxl449a extends IDataStruct {
    
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
     * AREA DE LIGACAO DA ROTINA DE NOMES DE ENTIDADES
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local Input
         */
        @Data
        Input input() ;
        
        /**
         * DADOS DE OUTPUT.
         * @return instancia da classe local Output
         */
        @Data
        Output output() ;
        
        
        public interface Input extends IDataStruct {
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt codEnt() ;
            
        }
        
        
        /**
         * 
         * DADOS DE OUTPUT.
         * 
         * @version 2.0
         * 
         */
        public interface Output extends IDataStruct {
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt cEntCbrSrvSibs() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nCmctSibs() ;
            
            @Data(size=40)
            IString nmCmctTermSibs() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cTipoServSibs() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancApoiSibs() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt cTipoEntSibs() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt cTipVlzEntSibs() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt iModEnvEntSibs() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cMoedIsoNmrc() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=8)
            IString nmPrgActzUlt() ;
            
            @Data(size=26)
            IString tsCriacao() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
            /**
             * @return instancia da classe local DadosErro
             */
            @Data
            DadosErro dadosErro() ;
            
            
            public interface DadosErro extends IDataStruct {
                
                @Data(size=9, signed=true)
                ILong cSqlcode() ;
                
                @Data(size=2)
                IString aAplErr() ;
                
                @Data(size=3, signed=true)
                IInt cRtnoEvenSwal() ;
                @Data
                @Condition("501")
                ICondition inputInsuf() ;
                @Data
                @Condition("215")
                ICondition naoExitReg() ;
                
                
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
    
}
