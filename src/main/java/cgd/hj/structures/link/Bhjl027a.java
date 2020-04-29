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
public interface Bhjl027a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ027A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL027A AREA DE COMUNICACOES PARA O MHJJ027A
     * AREA DE LIGACAO COM ROTINA DE
     * VALIDACAO DO CLIENTE POR DOCUMENTO DE IDENTIFICACAO
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL027A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL027A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL027A-CLIENTE-CONFIDENCIAL     VALUE +506.
     * OCORRE QUANDO O CLIENTE QUE SE PRETENDE E CONFIDENCIAL
     * BHJL027A-DOC-NAO-EXIS             VALUE +535.
     * OCORRE QUANDO O DOCUMENTO PRETENDIDO NAO EXISTE
     * BHJL027A-DOC-REPETIDO             VALUE +536.
     * OCORRE QUANDO O DOCUMENTO PRETENDIDO ESTA REGISTADO EM
     * MAIS QUE UM CLIENTE
     * BHJL027A-CLI-CANCELADO            VALUE +622.
     * OCORRE QUANDO O CLIENTE PRETENDIDO FOI CANCELADO
     * SE OS CAMPOS C-PAIS-ISOA-OE-OPX E C-MNEM-EGC-OPEX ESTIVEREM
     * FORMATADOS O MODULO DEVOLVE O N-CLIENTE  E O NS-ABRA-CLI. CASO
     * CONTRARIO DEVOLVE APENAS O N-CLIENTE
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
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=3)
            IString cPaisIsaEmsDoc() ;
            
            @Data(size=3)
            IString cTipoDocId() ;
            @Data
            @Condition("101")
            ICondition biPortugues() ;
            @Data
            @Condition("501")
            ICondition nifPortugues() ;
            @Data
            @Condition("502")
            ICondition nipcPortugues() ;
            
            
            @Data(size=20)
            IString nDocId() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
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
            @Condition("501")
            ICondition inputInsuf() ;
            @Data
            @Condition("506")
            ICondition clienteConfidencial() ;
            @Data
            @Condition("535")
            ICondition docNaoExis() ;
            @Data
            @Condition("536")
            ICondition docRepetido() ;
            @Data
            @Condition("622")
            ICondition cliCancelado() ;
            
            
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
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
