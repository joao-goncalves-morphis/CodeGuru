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
public interface Bhol500a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOK501A")
    IString cRotina() ;
    
    @Data(size=8, value="MHOK502A")
    IString mhok502a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL500A
     * COPY DE LINKAGE DOS MODULOS DE CALCULO DE DESCRITIVOS
     * ESPECIAIS
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
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
            @Data(size=10)
            IString zValor() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=40)
            IString dMovimento() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("939")
            ICondition inputInsuf() ;
            @Data
            @Condition("004")
            ICondition warningDb2() ;
            @Data
            @Condition("005")
            ICondition msgErroDb2() ;
            @Data
            @Condition("912")
            ICondition opcaoMalFormatad() ;
            @Data
            @Condition("913")
            ICondition opcaoInvalida() ;
            @Data
            @Condition("917")
            ICondition dataIncorrecta() ;
            @Data
            @Condition("921")
            ICondition prazoNaoExiste() ;
            
            
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
