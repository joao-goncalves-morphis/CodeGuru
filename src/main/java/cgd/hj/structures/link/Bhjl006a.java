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
public interface Bhjl006a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=4, signed=true, value="296", compression=COMP)
    IInt length() ;
    
    @Data(size=8, value="MHJS006A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJL006A AREA DE COMUNICACOES PARA O MHJS006A
     * AREA DE LIGACAO COM ROTINA DE VALIDACAO DO CLIENTE
     * EXPLICACAO DOS CODIGOS DE ERROS:
     * BHJL006A-CLIENTE-NAO-EXISTE       VALUE +002.
     * OCORRE QUANDO O CLIENTE PRETENDIDO NAO EXISTE
     * BHJL006A-INPUT-INSUF              VALUE +501.
     * OCORRE QUANDO O INPUT FORNECIDO A ROTINA E INSUFICIENTE
     * BHJL006A-CLIENTE-CONFIDENCIAL     VALUE +506.
     * OCORRE QUANDO O CLIENTE QUE SE PRETENDE E CONFIDENCIAL
     * BHJL006A-CLI-CANCELADO            VALUE +622.
     * OCORRE QUANDO O CLIENTE PRETENDIDO FOI CANCELADO
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
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=1)
            IString iRstzAces() ;
            
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
            
            @Data(size=3)
            IString cPaisIsoaOeNeg() ;
            
            @Data(size=3)
            IString cMnemEgcOeNeg() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcNeg() ;
            
            @Data(size=12)
            IString cSegmCliPrin() ;
            
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
            @Condition("622")
            ICondition cliCancelado() ;
            
            
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
