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
public interface Bhjl086a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ086A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL086A AREA DE LIGACAO PARA O MHJJ086A
     * DEVOLVE AS RELACOES ACTIVAS, INACTIVAS OU TODAS DE UM
     * CONTRATO
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL086A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL086A-INTERV-N-EXISTE          VALUE +611.
     * OCORRE QUANDO A INTERVENCAO INDICADA NAO EXISTE NA TABELA
     * DE RELACAO ENTRE CLIENTES E CONTRATOS
     * BHJL086A-Q-OCCURS-INVALIDA        VALUE +658.
     * OCORRE QUANDO A QUANTIDADE DE OCORRENCIAS PEDIDA E MAIOR
     * QUE A QUANTIDADE MAXIMA DO MODULO
     * OS CAMPOS C-PAIS-ISOA-CONT, C-BANC-CONT, C-OE-EGC-CONT,
     * NS-RDCL-CONT, V-CHKD-CONT, C-TIPO-CONT, C-PAIS-ISOA-OE-OPX E
     * C-MNEM-EGC-OPEX, BHJL086A-N-CONTRATO E BHJL086A-I-TIPO-ITVT-L
     * TEM DE SER FORMATADOS
     * O CAMPO BHJL086A-Z-INIC-REL E USADO PARA LIMITAR O RESULTADO
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
        @Data(length=150)
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
            IInt iTipoItvtL() ;
            
            @Data(size=10)
            IString zInicRelL() ;
            
            @Data(size=23)
            IString nContrato() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitcPag() ;
            
            @Data(size=10)
            IString zInicRelPag() ;
            
            @Data(size=10)
            IString zFimRelPag() ;
            
            @Data(size=1)
            IString tipoIntervencao() ;
            @Data
            @Condition("A")
            ICondition itvtActiva() ;
            @Data
            @Condition("C")
            ICondition itvtCancelada() ;
            @Data
            @Condition("T")
            ICondition itvtTodas() ;
            
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=1)
            IString cTipoCli() ;
            
            @Data(size=135)
            IString nmCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitc() ;
            
            @Data(size=10)
            IString zInicRel() ;
            
            @Data(size=10)
            IString zFimRel() ;
            
        }
        
        public interface Erros extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("501")
            ICondition inputInsuf() ;
            @Data
            @Condition("611")
            ICondition intervNExiste() ;
            @Data
            @Condition("658")
            ICondition qOccursInvalida() ;
            @Data
            @Condition("215")
            ICondition nExistReg() ;
            
            
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
