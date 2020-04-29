package cgd.hg.structures.link;

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
public interface Bhgl007a extends IDataStruct {
    
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
     * BHGL007A AREA DE COMUNICACOES PARA O MHGS007A
     * AREA DE LIGACAO COM A ROTINA DE CONSULTA EM LISTA QUE
     * DEVOLVE OE'S RELACIONADOS COM UM OE INDICADO
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
            
            @Data(size=3)
            IString cMnemEmpGcxChv() ;
            
            @Data(size=3)
            IString cPaisIsoAlfnChv() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcChav() ;
            
            @Data(size=2)
            IString cTipoRelHrqaOe() ;
            
            @Data(size=3)
            IString cMnemEgcRldChv() ;
            
            @Data(size=3)
            IString cPaisIsoaRldChv() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcReldChav() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            /**
             * @return instancia da classe local Lista
             */
            @Data(length=120)
            IArray<Lista> lista() ;
            
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
            @Data
            @Condition("118")
            ICondition paisObrigatorio() ;
            @Data
            @Condition("119")
            ICondition empObrigatoria() ;
            @Data
            @Condition("122")
            ICondition cOeObrigatorio() ;
            @Data
            @Condition("128")
            ICondition cRelHrqaObrigat() ;
            @Data
            @Condition("129")
            ICondition semDados() ;
            @Data
            @Condition("004")
            ICondition warningDb2() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            
            
            @Data(size=2)
            IString cEibfn() ;
            
            @Data(size=6)
            IString cEibrcode() ;
            
            @Data(size=8)
            IString cEibrsrce() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=8)
            IString xSqlcaid() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong qSqlcabc() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            @Data(size=4, signed=true, compression=COMP)
            IInt qSqlerrml() ;
            
            @Data(size=70)
            IString xSqlerrmc() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlerrd() ;
            
            @Data(size=1)
            IString iSqlwarn0() ;
            
            @Data(size=1)
            IString iSqlwarn1() ;
            
            @Data(size=1)
            IString iSqlwarn2() ;
            
            @Data(size=1)
            IString iSqlwarn3() ;
            
            @Data(size=1)
            IString iSqlwarn4() ;
            
            @Data(size=1)
            IString iSqlwarn5() ;
            
            @Data(size=1)
            IString iSqlwarn6() ;
            
            @Data(size=1)
            IString iSqlwarn7() ;
            
            @Data(size=8)
            IString xSqlext() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            
            public interface Lista extends IDataStruct {
                
                @Data(size=3)
                IString cMnemEgcRldLst() ;
                
                @Data(size=3)
                IString cPaisIsoaRldLst() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcReldLsta() ;
                
            }
        }
    }
    
}
