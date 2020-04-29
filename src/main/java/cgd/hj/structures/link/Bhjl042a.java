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
public interface Bhjl042a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ042A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL042A AREA DE LIGACAO PARA O MHJJ042A
     * OBTEM AS ACTIVIDADES DO CLIENTE
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL042A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL042A-NAO-EXIT-REG             VALUE +215.
     * OCORRE QUANDO O REGISTO PRETENDIDO NAO EXISTE
     * BHJL042A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL042A-CLIENTE-CONFIDENCIAL     VALUE +506.
     * OCORRE QUANDO O CLIENTE QUE SE PRETENDE E CONFIDENCIAL
     * BHJL042A-DADOS-INCOMPATIVEIS      VALUE +623.
     * OCORRE QUANDO E FORMATADA A INFORMACAO DO CONTRATO E DO
     * CLIENTE NOS MODULOS EM QUE ISSO NAO PODE SER FEITO
     * BHJL042A-INTERV-N-EXISTE          VALUE +611.
     * OCORRE QUANDO A INTERVENCAO INDICADA NAO EXISTE NA TABELA
     * DE RELACAO ENTRE CLIENTES E CONTRATOS
     * BHJL042A-Q-OCCURS-INVALIDA        VALUE +658.
     * OCORRE QUANDO A QUANTIDADE DE OCORRENCIAS PEDIDA E MAIOR
     * QUE A QUANTIDADE MAXIMA DO MODULO
     * OS CAMPOS N-CLIENTE E NS-ABRA-CLI, OU EM ALTERNATIVA, OS CAMPOS*
     * C-PAIS-ISOA-CONT, C-BANC-CONT, C-OE-EGC-CONT, NS-RDCL-CONT,
     * V-CHKD-CONT, C-TIPO-CONT, C-PAIS-ISOA-OE-OPX E C-MNEM-EGC-OPEX,*
     * TEM QUE ESTAR FORMATADOS.
     * NO CASO DE I-TIPO-ITVT, NS-TITC NAO ESTAREM FORMATADOS A
     * INFORMACAO OBTIDA DIZ RESPEITO AO PRIMEIRO TITULAR.
     * OS CAMPOS C-AE-I E I-REVS-AE-I SAO USADOS PARA PAGINAR E PARA
     * LIMITAR OS RESULTADOS DEPENDENDO DO ESTADO DO SWITCH I-ACCAO.
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
        @Data(length=170)
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
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
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
            @Data
            @Condition("006")
            ICondition sacador() ;
            @Data
            @Condition("007")
            ICondition sacado() ;
            @Data
            @Condition("101")
            ICondition titular() ;
            @Data
            @Condition("106")
            ICondition autorizado() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitc() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt cAeI() ;
            
            @Data(size=1)
            IString iRevsAeI() ;
            
            @Data(size=1)
            IString iAccao() ;
            @Data
            @Condition("T")
            ICondition obtemTodas() ;
            @Data
            @Condition("U")
            ICondition obtemUma() ;
            
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt cAe() ;
            
            @Data(size=1)
            IString iRevsAe() ;
            
            @Data(size=1)
            IString iAePrin() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong nAlvrAeCli() ;
            
            @Data(size=10)
            IString zInicAtve() ;
            
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
