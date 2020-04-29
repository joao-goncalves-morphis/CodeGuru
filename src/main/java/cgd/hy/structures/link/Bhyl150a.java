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
public interface Bhyl150a extends IDataStruct {
    
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
            
            @Data(size=1)
            IString iTrnzApl() ;
            @Data
            @Condition("T")
            ICondition transaccao() ;
            @Data
            @Condition("A")
            ICondition aplicacao() ;
            @Data
            @Condition("B")
            ICondition todasTransaccoes() ;
            @Data
            @Condition("C")
            ICondition todasAplicacoes() ;
            @Data
            @Condition("D")
            ICondition todasTrnNIndPNeg() ;
            
            
            @Data(size=4)
            IString cTrnzApl() ;
            
            @Data(size=1)
            IString iAtvzDtvz() ;
            @Data
            @Condition("A")
            ICondition iAtvzDtvzActiva() ;
            @Data
            @Condition("I")
            ICondition iAtvzDtvzInactiva() ;
            
            
            @Data(size=20)
            IString xInfOrigPend() ;
            
            @Data(size=2)
            IString aAplicOrig() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("116")
            ICondition abendDb2() ;
            @Data
            @Condition("170")
            ICondition inputMalFormatad() ;
            @Data
            @Condition("206")
            ICondition dadosInvalidos() ;
            
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("A2")
            ICondition erroDb2() ;
            @Data
            @Condition("FU")
            ICondition erroFuncao() ;
            @Data
            @Condition("A5")
            ICondition escritaFicheiro() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            @Data(size=6)
            IString nmFicheiro() ;
            
            @Data(size=2)
            IString cRtnoAcesFich() ;
            
            @Data(size=30)
            IString nmCampErro() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
        }
    }
    
}
