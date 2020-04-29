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
public interface Bhtl034a extends IDataStruct {
    
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
     * AREA DE LIGACAO COM O MODULO DE RECUPERACAO PARA O BATCH
     * MHTQ034A
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
         * @return instancia da classe local DadosInpOut
         */
        @Data
        DadosInpOut dadosInpOut() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=1)
            IString iAccao() ;
            @Data
            @Condition("V")
            ICondition consulta() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("F")
            ICondition fimProcessoOk() ;
            
            
            @Data(size=8)
            IString nmPrograma() ;
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=50)
            IString xCteuChavTab() ;
            
        }
        
        public interface DadosInpOut extends IDataStruct {
            
            @Data(size=250)
            IString xDescChavTab() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            @Data
            @Condition("A1")
            ICondition abend() ;
            @Data
            @Condition("A2")
            ICondition abendDb2() ;
            @Data
            @Condition("FU")
            ICondition errosFuncao() ;
            @Data
            @Condition("DA")
            ICondition dadosEntrada() ;
            @Data
            @Condition("PF")
            ICondition processoFinalizado() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            @Data
            @Condition("242")
            ICondition naoExstDdsRecup() ;
            @Data
            @Condition("871")
            ICondition inputMalFormatad() ;
            
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            @Data(size=70)
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
