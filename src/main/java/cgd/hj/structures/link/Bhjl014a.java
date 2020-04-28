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
public interface Bhjl014a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ014A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL014A AREA DE LIGACAO PARA O MHJJ014A
     * AREA DE LIGACAO PARA O MODULO QUE DEVOLVE OS
     * COMPLEMENTARES DO CLIENTE
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL014A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL014A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL014A-CLIENTE-CONFIDENCIAL     VALUE +506.
     * OCORRE QUANDO O CLIENTE QUE SE PRETENDE E CONFIDENCIAL
     * BHJL014A-DADOS-INCOMPATIVEIS      VALUE +623.
     * OCORRE QUANDO E FORMATADA A INFORMACAO DO CONTRATO E DO
     * CLIENTE NOS MODULOS EM QUE ISSO NAO PODE SER FEITO
     * BHJL014A-INTERV-N-EXISTE          VALUE +611.
     * OCORRE QUANDO A INTERVENCAO INDICADA NAO EXISTE NA TABELA
     * DE RELACAO ENTRE CLIENTES E CONTRATOS
     * OS CAMPOS N-CLIENTE E NS-ABRA-CLI, OU EM ALTERNATIVA, OS CAMPOS*
     * C-PAIS-ISOA-CONT, C-BANC-CONT, C-OE-EGC-CONT, NS-RDCL-CONT,
     * V-CHKD-CONT, C-TIPO-CONT, C-PAIS-ISOA-OE-OPX E C-MNEM-EGC-OPEX,*
     * TEM QUE ESTAR FORMATADOS.
     * NO CASO DE I-TIPO-ITVT, NS-TITC NAO ESTAREM FORMATADOS A
     * INFORMACAO OBTIDA DIZ RESPEITO AO PRIMEIRO TITULAR.
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
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=1)
            IString cTipoCli() ;
            
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
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=10)
            IString zMrteCli() ;
            
            @Data(size=10)
            IString zNascCli() ;
            
            @Data(size=15)
            IString cEndcRglNatCli() ;
            
            @Data(size=3)
            IString cPaisIsoaNacn() ;
            
            @Data(size=3)
            IString cPaisIsoaNasc() ;
            
            @Data(size=3)
            IString cPaisIsoaDnac() ;
            
            @Data(size=3)
            IString cTitHono() ;
            
            @Data(size=1)
            IString iGnroCli() ;
            
            @Data(size=3)
            IString cTipoDfct() ;
            
            @Data(size=3)
            IString cHbli() ;
            
            @Data(size=3)
            IString cAreaAcdm() ;
            
            @Data(size=40)
            IString nmPai() ;
            
            @Data(size=40)
            IString nmMae() ;
            
            @Data(size=3)
            IString cGranCli() ;
            
            @Data(size=3)
            IString iEstuEmgt() ;
            
            @Data(size=3)
            IString cTipoEmgt() ;
            
            @Data(size=3)
            IString cPaisIsoaResi() ;
            
            @Data(size=3)
            IString cCatgEmpdCgd() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nEmpregado() ;
            
            @Data(size=3)
            IString cPaisIsaEmpGcx() ;
            
            @Data(size=3)
            IString cMnemEgcEmpd() ;
            
            @Data(size=3)
            IString cEstCivl() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qFilho() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qPessAgfm() ;
            
            @Data(size=3)
            IString cTipoHabz() ;
            
            @Data(size=1)
            IString iReformado() ;
            
            @Data(size=1)
            IString iSitPrfm() ;
            
            @Data(size=10)
            IString zPrfm() ;
            
            @Data(size=1)
            IString iCredVnct() ;
            
            @Data(size=10)
            IString zCstzEmp() ;
            
            @Data(size=10)
            IString zDslzEmp() ;
            
            @Data(size=3)
            IString cPaisIsoaSede() ;
            
            @Data(size=15)
            IString cEndcRgnlEmp() ;
            
            @Data(size=3)
            IString cPaisIsoaEmp() ;
            
            @Data(size=3)
            IString cTipoEmp() ;
            
            @Data(size=3)
            IString cTipoScde() ;
            
            @Data(size=3)
            IString cSitEmp() ;
            
            @Data(size=1)
            IString iEmpGcx() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=3)
            IString cTipoItlzEmp() ;
            
            @Data(size=4, compression=COMP3)
            IInt zaBlnoUlt() ;
            
            @Data(size=3)
            IString cPaisIsoaOeClc() ;
            
            @Data(size=3)
            IString cMnemEgcOeClc() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcClc() ;
            
            @Data(size=3)
            IString cPaisIsaRsiFsl() ;
            
            @Data(size=10)
            IString zInfPaisRsiFsl() ;
            
            @Data(size=1)
            IString iCpvPaisRsiFsl() ;
            
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
