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
public interface Bhjl067a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ067A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL067A AREA DE COMUNICACOES PARA A ROTINA  MHJJ067A
     * AREA DE LIGACAO COM ROTINA DE OBTENCAO
     * DO NOME DO CLIENTE
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL067A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL067A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL067A-NOME-N-EXI               VALUE +564.
     * OCORRE QUANDO O NOME INDICADO NAO EXISTE
     * BHJL067A-CLI-CANCELADO            VALUE +622.
     * OCORRE QUANDO O CLIENTE SE ENCONTRA CANCELADO
     * BHJL067A-ACESSO-VEDADO            VALUE +506.
     * OCORRE QUANDO O CLIENTE TEM ACESSO VEDADO / CONFIDENCIAL
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
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            /**
             * OS DOIS CAMPOS QUE SE SEGUEM DEVEM SER SEMPRE USADOS PARA
             * OBTER O CLIENTE INDEPENDENTEMENTE DE ESTAR FUNDIDO OU NAO.
             */
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliAgregador() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nsAbraCliAgreg() ;
            
            @Data(size=35)
            IString nmCliAbvd() ;
            
            @Data(size=3)
            IString cTitHono() ;
            
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
            @Condition("564")
            ICondition nomeNExi() ;
            @Data
            @Condition("622")
            ICondition cliCancelado() ;
            @Data
            @Condition("506")
            ICondition acessoVedado() ;
            
            
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
