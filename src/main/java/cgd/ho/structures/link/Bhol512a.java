package cgd.ho.structures.link;

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
public interface Bhol512a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ512A")
    IString conMhoj512a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL512A - LINKAGE DA ROTINA MHOJ512A
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
            
            /**
             * @return instancia da classe local Conta
             */
            @Data
            Conta conta() ;
            
            
            public interface Conta extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcCont() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclCont() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdCont() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoCont() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=1)
            IString iEstBloq() ;
            @Data
            @Condition("S")
            ICondition iEstBloqS() ;
            @Data
            @Condition("N")
            ICondition iEstBloqN() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
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
