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
public interface Bhjl707a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ707A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * IGUAL A BHJL031A COM MAIS DOIS CAMPOS NAS OCORRENCIAS
     * (BHJL707A-Z-EMIS-DOC-ID     , BHJL707A-C-ENT-EMIX-DOC-ID)
     * BHJL707A AREA DE COMUNICACOES PARA O MHJJ707A
     * AREA DE LIGACAO COM ROTINA DE OBTENCAO
     * DOS DOCUMENTOS DE IDENTIFICACAO DO CLIENTE
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL707A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL707A-NAO-EXIT-REG             VALUE +215.
     * OCORRE QUANDO O REGISTO PRETENDIDO NAO EXISTE
     * BHJL707A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL707A-CLIENTE-CONFIDENCIAL     VALUE +506.
     * OCORRE QUANDO O CLIENTE QUE SE PRETENDE E CONFIDENCIAL
     * BHJL707A-DADOS-INCOMPATIVEIS      VALUE +623.
     * OCORRE QUANDO E FORMATADA A INFORMACAO DO CONTRATO E DO
     * CLIENTE NOS MODULOS EM QUE ISSO NAO PODE SER FEITO
     * BHJL707A-INTERV-N-EXISTE          VALUE +611.
     * OCORRE QUANDO A INTERVENCAO INDICADA NAO EXISTE NA TABELA
     * DE RELACAO ENTRE CLIENTES E CONTRATOS
     * OS CAMPOS N-CLIENTE E NS-ABRA-CLI, OU EM ALTERNATIVA, OS CAMPOS*
     * C-PAIS-ISOA-CONT, C-BANC-CONT, C-OE-EGC-CONT, NS-RDCL-CONT,
     * V-CHKD-CONT, C-TIPO-CONT, C-PAIS-ISOA-OE-OPX E C-MNEM-EGC-OPEX,*
     * TEM QUE ESTAR FORMATADOS.
     * NO CASO DE I-TIPO-ITVT, NS-TITC NAO ESTAREM FORMATADOS A
     * INFORMACAO OBTIDA DIZ RESPEITO AO PRIMEIRO TITULAR.
     * SE OS CAMPOS BHJL707A-C-PAIS-EMS-DOC-PED, BHJL707A-N-DOC-ID-L
     * E BHJL707A-C-TIPO-DOC-PED NAO ESTIVEREM FORMATADOS OU ESTIVEREM*
     * OS 3 PREENCHIDOS (PARA PAGINACAO) O MODULO DEVOLVE A LISTA DE
     * TODOS OS DOCUMENTOS DE IDENTIFICACAO DO CLIENTE INDICADO.
     * EM ALTERNATIVA, SE OS CAMPOS BHJL707A-C-PAIS-EMS-DOC-PED E
     * BHJL707A-C-TIPO-DOC-PED ESTIVEREM FORMATADOS E O CAMPO
     * BHJL707A-N-DOC-ID-L ESTIVER A ESPACOS O MODULO APENAS DEVOLVE
     * O TIPO DE DOCUMENTO QUE ESTIVER INDICADO PARA O CLIENTE
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
        @Data(length=100)
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
            
            @Data(size=3)
            IString cPaisEmsDocPed() ;
            
            @Data(size=3)
            IString cTipoDocPed() ;
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
            IString nDocIdL() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsaEmsDoc() ;
            
            @Data(size=3)
            IString cTipoDocId() ;
            
            @Data(size=20)
            IString nDocId() ;
            
            @Data(size=10)
            IString zVldeDocId() ;
            
            @Data(size=10)
            IString zEmisDocId() ;
            
            @Data(size=10)
            IString cEntEmixDocId() ;
            
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
            @Condition("623")
            ICondition dadosIncompativeis() ;
            @Data
            @Condition("611")
            ICondition intervNExiste() ;
            
            
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
