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
public interface Bhyl500a extends IDataStruct {
    
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
     * AREA DE LIGACAO COM A ROTINA MHYQ500A
     * AREA DE LIGACAO COM A ROTINA DE CONSULTA DE COMMITS P/ PROCESSO*
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
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=8)
            IString nmPrgBtch() ;
            
            @Data(size=8)
            IString hInicExePrg() ;
            
            @Data(size=8)
            IString hFimExePrg() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt qCommit() ;
            
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
            @Data
            @Condition("DA")
            ICondition dadosEntrada() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("206")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("207")
            ICondition prgbatchInexist() ;
            
            
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
