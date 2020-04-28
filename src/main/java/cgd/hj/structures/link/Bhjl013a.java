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
public interface Bhjl013a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHJJ013A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL013A AREA DE LIGACAO PARA O MHJJ013A
     * MODULO QUE DEVOLVE OS DADOS BASICOS
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL013A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL013A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL013A-CLIENTE-CONFIDENCIAL     VALUE +506.
     * OCORRE QUANDO O CLIENTE QUE SE PRETENDE E CONFIDENCIAL
     * BHJL013A-DADOS-INCOMPATIVEIS      VALUE +623.
     * OCORRE QUANDO E FORMATADA A INFORMACAO DO CONTRATO E DO
     * CLIENTE NOS MODULOS EM QUE ISSO NAO PODE SER FEITO
     * BHJL013A-INTERV-N-EXISTE          VALUE +611.
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
            
            @Data(size=1)
            IString cTipoCli() ;
            
            @Data(size=1)
            IString iCliPrfl() ;
            
            @Data(size=1)
            IString iVip() ;
            
            @Data(size=6)
            IString cTipoIsezFscl() ;
            
            @Data(size=1)
            IString iCliSdadId() ;
            
            @Data(size=1)
            IString iBlqoCli() ;
            
            @Data(size=1)
            IString iCorrespondencia() ;
            
            @Data(size=1)
            IString iCliAntz() ;
            
            @Data(size=1)
            IString iNrsc() ;
            
            @Data(size=1)
            IString iInfAdi() ;
            
            @Data(size=3)
            IString cPaisIsoaOe() ;
            
            @Data(size=3)
            IString cMnemEgcOe() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCtco() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt cSectIttlBpor() ;
            
            @Data(size=135)
            IString nmCliente() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cUrscBpor() ;
            
            @Data(size=1)
            IString iCliDclzBpor() ;
            
            @Data(size=3)
            IString iSitCli() ;
            
            @Data(size=1)
            IString iCliRetzFnte() ;
            
            @Data(size=3)
            IString cPaisIsaDirGrx() ;
            
            @Data(size=3)
            IString cMnemEgcDirGrx() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cDirzGerx() ;
            
            @Data(size=8)
            IString cUsidGerxCli() ;
            
            @Data(size=10)
            IString zInicRelGrxCli() ;
            
            @Data(size=4)
            IString cRfin() ;
            
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
