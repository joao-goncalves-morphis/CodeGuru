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
public interface Bhjl051a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ051A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL051A AREA DE LIGACAO PARA O MHJJ051A
     * DEVOLVE AS RELACOES ACTIVAS DE UM CONTRATO NUMA DATA
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL051A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL051A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL051A-CLIENTE-CONFIDENCIAL     VALUE +506.
     * OCORRE QUANDO O CLIENTE QUE SE PRETENDE E CONFIDENCIAL
     * BHJL051A-INTERV-N-EXISTE          VALUE +611.
     * OCORRE QUANDO A INTERVENCAO INDICADA NAO EXISTE NA TABELA
     * DE RELACAO ENTRE CLIENTES E CONTRATOS
     * BHJL051A-DADOS-INCOMPATIVEIS      VALUE +623.
     * OCORRE QUANDO E FORMATADA A INFORMACAO DO CONTRATO E DO
     * CLIENTE NOS MODULOS EM QUE ISSO NAO PODE SER FEITO
     * BHJL051A-Q-OCCURS-INVALIDA        VALUE +658.
     * OCORRE QUANDO A QUANTIDADE DE OCORRENCIAS PEDIDA E MAIOR
     * QUE A QUANTIDADE MAXIMA DO MODULO
     * OS CAMPOS C-PAIS-ISOA-CONT, C-BANC-CONT, C-OE-EGC-CONT,
     * NS-RDCL-CONT, V-CHKD-CONT, C-TIPO-CONT, C-PAIS-ISOA-OE-OPX E
     * C-MNEM-EGC-OPEX, TEM QUE ESTAR FORMATADOS.
     * ESTE MODULO NAO DEVOLVE AS INTERVENCOES QUE SEJAM CONFIDENCIAIS*
     * PARA A INSTITUICAO INDICADA.
     * O CAMPO BHJL051A-I-TIPO-ITVT-L E USADO PARA LIMITAR O RESULTADO*
     * SE BHJL051A-CTTO-N-NORMALIZADO ESTIVER ACTIVO O CAMPO
     * BHJL051A-N-CONTRATO-L PARA LIMITAR O RESULTADO
     * OS CAMPOS BHJL051A-I-TIPO-ITVT-PAG E BHJL051A-NS-TITC-PAG
     * SAO USADOS PARA A PAGINACAO.
     * SE BHJL051A-CONTA-ITVT ESTIVER ACTIVO O CAMPO
     * BHJL051A-I-TIPO-ITVT-C E USADO PARA CONTAR APENAS UM TIPO DE
     * INTERVENCAO.
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
        @Data(length=999)
        IArray<DadosSaida> dadosSaida() ;
        
        @Data(size=3)
        IInt qOccursOut() ;
        
        @Data(size=6)
        IInt qItvt() ;
        
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
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
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
            IInt iTipoItvtPag() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitcPag() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvtC() ;
            @Data
            @Condition("006")
            ICondition sacadorC() ;
            @Data
            @Condition("007")
            ICondition sacadoC() ;
            @Data
            @Condition("101")
            ICondition titularC() ;
            @Data
            @Condition("106")
            ICondition autorizadoC() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvtL() ;
            @Data
            @Condition("006")
            ICondition sacadorL() ;
            @Data
            @Condition("007")
            ICondition sacadoL() ;
            @Data
            @Condition("101")
            ICondition titularL() ;
            @Data
            @Condition("106")
            ICondition autorizadoL() ;
            
            
            @Data(size=10)
            IString zConsulta() ;
            
            @Data(size=23)
            IString nContratoL() ;
            
            @Data(size=1)
            IString tipoContrato() ;
            @Data
            @Condition(" ")
            ICondition cttoNormalizado() ;
            @Data
            @Condition("S")
            ICondition cttoNNormalizado() ;
            
            
            @Data(size=1)
            IString iAccao() ;
            @Data
            @Condition("S")
            ICondition contaItvt() ;
            @Data
            @Condition(" ")
            ICondition nContaItvt() ;
            
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitc() ;
            
            @Data(size=23)
            IString nContrato() ;
            
            @Data(size=10)
            IString zInicRel() ;
            
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
            @Condition("611")
            ICondition intervNExiste() ;
            @Data
            @Condition("623")
            ICondition dadosIncompativeis() ;
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
