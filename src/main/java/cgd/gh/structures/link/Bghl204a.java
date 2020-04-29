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
public interface Bghl204a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MGHJ204A")
    IString conMghj204a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHL204A
     * AREA DE LIGACAO COM A ROTINA DE ACESSO POR JOURNAL OU
     * N-DOCUMENTO (PEDIDO DO SGOA).
     * MGHJ204A
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * DADOS DE INPUT
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * DADOS DE OUTPUT
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * DADOS OBRIGATORIOS OUTPUT
         * @return instancia da classe local AreaErro
         */
        @Data
        AreaErro areaErro() ;
        
        
        
        /**
         * 
         * DADOS DE INPUT
         * 
         * @version 2.0
         * 
         */
        public interface DadosInput extends IDataStruct {
            
            /**
             * DADOS OBRIGATORIOS INPUT
             */
            @Data(size=2)
            IString pesquisaI() ;
            @Data
            @Condition("P1")
            ICondition pesquisaP1I() ;
            @Data
            @Condition("P2")
            ICondition pesquisaP2I() ;
            
            
            @Data(size=3)
            IString cPaisIsoaContI() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContI() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContI() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContI() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContI() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContI() ;
            
            @Data(size=3)
            IString cMoedIsoSctaI() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepositoI() ;
            
            /**
             * DADOS FACULTATIVOS - OBRIGATORIOS PARA P1 (PESQUISA TIPO 1)
             */
            @Data(size=10)
            IString zProcessamentoI() ;
            
            @Data(size=3)
            IString cMnemEgcOpexI() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpxI() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpexI() ;
            
            @Data(size=8)
            IString cUseridI() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbnI() ;
            
            /**
             * DADOS FACULTATIVOS - SO SE APLICA PARA P1
             */
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbnI() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbnDtlhI() ;
            
            /**
             * DADOS FACULTATIVOS - OBRIGATORIOS PARA P2 (PESQUISA TIPO 2)
             */
            @Data(size=10, signed=true, compression=COMP3)
            ILong nChequeI() ;
            
        }
        
        
        /**
         * 
         * DADOS DE OUTPUT
         * 
         * @version 2.0
         * 
         */
        public interface DadosOutput extends IDataStruct {
            
            /**
             * DADOS FACULTATIVOS - OBRIGATORIOS PARA P1 (PESQUISA TIPO 1)
             */
            @Data(size=10, signed=true, compression=COMP3)
            ILong nChequeO() ;
            
            /**
             * DADOS FACULTATIVOS - OBRIGATORIOS PARA P2 (PESQUISA TIPO 2)
             */
            @Data(size=10)
            IString zProcessamentoO() ;
            
            @Data(size=3)
            IString cMnemEgcOpexO() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpxO() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpexO() ;
            
            @Data(size=8)
            IString cUseridO() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbnO() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbnO() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbnDtlhO() ;
            
        }
        
        
        /**
         * 
         * DADOS OBRIGATORIOS OUTPUT
         * 
         * @version 2.0
         * 
         */
        public interface AreaErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
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
