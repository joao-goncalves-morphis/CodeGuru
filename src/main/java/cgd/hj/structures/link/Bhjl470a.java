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
public interface Bhjl470a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ470A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL470A - AREA DE LIGACAO AO MODULO MHJJ470A
     * HJ5158 - 2010-09-27
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
         * @return instancia da classe local DadosInput02
         */
        @Data
        DadosInput02 dadosInput02() ;
        
        /**
         * @return instancia da classe local DadosInOut
         */
        @Data
        DadosInOut dadosInOut() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * @return instancia da classe local Erros
         */
        @Data
        Erros erros() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=1)
            IString iAccao() ;
            @Data
            @Condition("V")
            ICondition visualizacao() ;
            @Data
            @Condition("I")
            ICondition insercao() ;
            @Data
            @Condition("C")
            ICondition criacao() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("E")
            ICondition eliminacao() ;
            
            
        }
        
        public interface DadosInput02 extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
        }
        
        public interface DadosInOut extends IDataStruct {
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=2)
            IString cEstCliFltg() ;
            @Data
            @Condition("00")
            ICondition cliLimpo() ;
            @Data
            @Condition("01")
            ICondition cliSancionado() ;
            @Data
            @Condition("02")
            ICondition cliPep() ;
            @Data
            @Condition("03")
            ICondition cliDuvSancionado() ;
            @Data
            @Condition("04")
            ICondition cliDuvPep() ;
            @Data
            @Condition("05")
            ICondition cliPepNAut() ;
            @Data
            @Condition("06")
            ICondition cliNFiltrado() ;
            @Data
            @Condition("07")
            ICondition cliSancionadoAut() ;
            
            
            @Data(size=1)
            IString cPfiRisBrqmCap() ;
            @Data
            @Condition("A")
            ICondition cPAlto() ;
            @Data
            @Condition("M")
            ICondition cPMedio() ;
            @Data
            @Condition("B")
            ICondition cPBaixo() ;
            
            
            @Data(size=10)
            IString zRevsPrcKycUlt() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt nsHistorico() ;
            
            @Data(size=10)
            IString zInicio() ;
            
            @Data(size=10)
            IString zFim() ;
            
            @Data(size=10)
            IString zActzPerfRisc() ;
            
            @Data(size=10)
            IString zActzRevPrcKyc() ;
            
            @Data(size=8)
            IString cUsidRevPrcKyc() ;
            
            @Data(size=10)
            IString zRevsPrcKycPvi() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
        }
        
        public interface Erros extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("002")
            ICondition clienteNaoExiste() ;
            @Data
            @Condition("215")
            ICondition naoExitReg() ;
            @Data
            @Condition("501")
            ICondition inputInsuf() ;
            @Data
            @Condition("612")
            ICondition regDuplic() ;
            @Data
            @Condition("623")
            ICondition dadosIncompativeis() ;
            
            
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
