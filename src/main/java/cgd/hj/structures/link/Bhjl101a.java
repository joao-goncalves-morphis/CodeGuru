package cgd.hj.structures.link;

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
public interface Bhjl101a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ101A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL101A AREA DE LIGACAO PARA O MHJJ101A
     * MODULO QUE DEVOLVA OS CONTRATOS ACTIVOS ENTRE DATAS
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL101A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL101A-NAO-EXIT-REG             VALUE +215
     * OCORRE QUANDO NAO EXISTEM REGISTOS
     * BHJL101A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL101A-Q-OCCURS-INVALIDA        VALUE +658.
     * OCORRE QUANDO O NUMERO DE OCORRENCIAS E INVALIDO
     * *** TODOS OS CAMPOS DE INPUT SAO DE PREENCHIMENTO OBRIGATORIO  ***
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
        @Data(length=75)
        IArray<DadosSaida> dadosSaida() ;
        
        @Data(size=3)
        IInt qOccursOut() ;
        
        @Data(size=1)
        IString cRetorno() ;
        @Data
        @Condition("C")
        ICondition pagCheia() ;
        
        
        /**
         * @return instancia da classe local Erros
         */
        @Data
        Erros erros() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=3)
            IInt qOccursInp() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
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
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvtPag() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitcPag() ;
            
            /**
             * *HJ12948-INI-14/01/2014
             */
            @Data(size=3)
            IString cFamiProdPag() ;
            
            @Data(size=3)
            IString cProdutoPag() ;
            
            /**
             * *HJ12948-FIM-14/01/2014
             */
            @Data(size=10)
            IString zConsultaIni() ;
            
            @Data(size=10)
            IString zConsultaFim() ;
            
            @Data(size=1)
            IString modoAcesso() ;
            @Data
            @Condition("T")
            ICondition todas() ;
            @Data
            @Condition("U")
            ICondition unica() ;
            @Data
            @Condition("O")
            ICondition ordem() ;
            
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
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
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitc() ;
            
            @Data(size=10)
            IString zInicRel() ;
            
            @Data(size=10)
            IString zFimRel() ;
            
            @Data(size=2)
            IString cTipoTrttCont() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=23)
            IString nContrato() ;
            
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
            @Condition("658")
            ICondition qOccursInvalida() ;
            
            
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
