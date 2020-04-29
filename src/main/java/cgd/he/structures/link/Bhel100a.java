package cgd.he.structures.link;

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
public interface Bhel100a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHEJ100A")
    IString cMhej100a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE LIGACAO DA ROTINA MHEJ100A
     * MANUTENCAO DA TABELA DE DADOS DE NAO CLIENTES
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
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=1)
            IString iAccaoTabBbn() ;
            @Data
            @Condition("V")
            ICondition visualizacao() ;
            @Data
            @Condition("C")
            ICondition insercao() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("A")
            ICondition eliminacao() ;
            
            
            @Data(size=2)
            IInt iOperacao() ;
            
            @Data(size=3)
            IString cPaisIsoaOpe() ;
            
            @Data(size=3)
            IString cMnemEgcOpe() ;
            
            @Data(size=10, compression=COMP3)
            ILong nPrcpNcli() ;
            
            @Data(size=135)
            IString nmPrcpNcli() ;
            
            @Data(size=40)
            IString dArruamento() ;
            
            @Data(size=40)
            IString xCpltMord() ;
            
            @Data(size=40)
            IString nmLocalidade() ;
            
            @Data(size=15)
            IString cEndcRgnl() ;
            
            @Data(size=15)
            IString cPostal() ;
            
            @Data(size=3)
            IString cPaisIsoaMord() ;
            
            @Data(size=15)
            IString nTelNcli() ;
            
            @Data(size=3)
            IString cPaisIsaEmsDoc() ;
            
            @Data(size=3)
            IString cTipoDocId() ;
            
            @Data(size=20)
            IString nDocId() ;
            
            @Data(size=1)
            IString cTipoNcli() ;
            
            @Data(size=10)
            IString zNascNcli() ;
            
            @Data(size=3)
            IString cPaisNacnNcli() ;
            
            @Data(size=10)
            IString zVldeDocId() ;
            
            @Data(size=10)
            IString cEntEmixDocId() ;
            
            @Data(size=3)
            IString cPaisEmsDocPcl() ;
            
            @Data(size=3)
            IString cTipoDocIdPclv() ;
            
            @Data(size=20)
            IString nDocIdPclv() ;
            
            @Data(size=10)
            IString zVldeDocIdPclv() ;
            
            @Data(size=10)
            IString cEntEmiDidPclv() ;
            
            @Data(size=160)
            IString nmEmpRnpc() ;
            
            @Data(size=6, compression=COMP3)
            IInt cAe() ;
            
            @Data(size=7, compression=COMP3)
            IInt cSectIttlBpor() ;
            
            @Data(size=80)
            IString dAe() ;
            
            @Data(size=3)
            IString cPaisIsoaSede() ;
            
            @Data(size=40)
            IString dArruMordSede() ;
            
            @Data(size=40)
            IString xCpltMordSede() ;
            
            @Data(size=15)
            IString cPostMordSede() ;
            
            @Data(size=40)
            IString nmLoclSedeEmp() ;
            
            @Data(size=15)
            IString cEndcRgnlSede() ;
            
            @Data(size=1)
            IString iEtbIdvlRpsLda() ;
            
            @Data(size=1)
            IString iCicvSemPjrd() ;
            
            @Data(size=10)
            IString zOpeUlt() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=10, compression=COMP3)
            ILong nPrcpNcliC() ;
            
            @Data(size=135)
            IString nmPrcpNcliC() ;
            
            @Data(size=40)
            IString nmLocalidadeC() ;
            
            @Data(size=3)
            IString cPaisIsaEmsDocC() ;
            
            @Data(size=3)
            IString cTipoDocIdC() ;
            
            @Data(size=20)
            IString nDocIdC() ;
            
            @Data(size=1)
            IString cTipoNcliC() ;
            
            @Data(size=10)
            IString zNascNcliC() ;
            
            @Data(size=3)
            IString cPaisNacnNcliC() ;
            
            @Data(size=10)
            IString zOpeUltC() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaOpeS() ;
            
            @Data(size=3)
            IString cMnemEgcOpeS() ;
            
            @Data(size=10, compression=COMP3)
            ILong nPrcpNcliS() ;
            
            @Data(size=135)
            IString nmPrcpNcliS() ;
            
            @Data(size=40)
            IString dArruamentoS() ;
            
            @Data(size=40)
            IString xCpltMordS() ;
            
            @Data(size=40)
            IString nmLocalidadeS() ;
            
            @Data(size=15)
            IString cEndcRgnlS() ;
            
            @Data(size=15)
            IString cPostalS() ;
            
            @Data(size=3)
            IString cPaisIsoaMordS() ;
            
            @Data(size=15)
            IString nTelNcliS() ;
            
            @Data(size=3)
            IString cPaisIsaEmsDocS() ;
            
            @Data(size=3)
            IString cTipoDocIdS() ;
            
            @Data(size=20)
            IString nDocIdS() ;
            
            @Data(size=1)
            IString cTipoNcliS() ;
            
            @Data(size=10)
            IString zNascNcliS() ;
            
            @Data(size=3)
            IString cPaisNacnNcliS() ;
            
            @Data(size=10)
            IString zVldeDocIdS() ;
            
            @Data(size=10)
            IString cEntEmixDocIdS() ;
            
            @Data(size=3)
            IString cPaisEmsDocPS() ;
            
            @Data(size=3)
            IString cTipoDocIdPS() ;
            
            @Data(size=20)
            IString nDocIdPclvS() ;
            
            @Data(size=10)
            IString zVldeDocIdPS() ;
            
            @Data(size=10)
            IString cEntEmiDidPS() ;
            
            @Data(size=160)
            IString nmEmpRnpcS() ;
            
            @Data(size=6, compression=COMP3)
            IInt cAeS() ;
            
            @Data(size=7, compression=COMP3)
            IInt cSectIttlBporS() ;
            
            @Data(size=80)
            IString dAeS() ;
            
            @Data(size=3)
            IString cPaisIsoaSedeS() ;
            
            @Data(size=40)
            IString dArruMordSedeS() ;
            
            @Data(size=40)
            IString xCpltMordSedeS() ;
            
            @Data(size=15)
            IString cPostMordSedeS() ;
            
            @Data(size=40)
            IString nmLoclSedeEmpS() ;
            
            @Data(size=15)
            IString cEndcRgnlSedeS() ;
            
            @Data(size=1)
            IString iEtbIdvlRpsLS() ;
            
            @Data(size=1)
            IString iCicvSemPjrdS() ;
            
            @Data(size=10)
            IString zOpeUltS() ;
            
            @Data(size=8)
            IString cUsidActzUltS() ;
            
            @Data(size=26)
            IString tsInsercao() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
            @Data(size=2)
            IInt indice() ;
            @Data
            @Condition("50")
            ICondition paginaCheia() ;
            
            
            /**
             * @return instancia da classe local Matriz
             */
            @Data(length=50)
            IArray<Matriz> matriz() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("009")
            ICondition dadosInputInvalidos() ;
            @Data
            @Condition("010")
            ICondition erroSelVhe07501() ;
            @Data
            @Condition("059")
            ICondition naoClienteInexist() ;
            @Data
            @Condition("012")
            ICondition erroUpdVhe07501() ;
            @Data
            @Condition("074")
            ICondition naoClienteJaExist() ;
            @Data
            @Condition("011")
            ICondition erroInsVhe07501() ;
            @Data
            @Condition("053")
            ICondition naoExistemDados() ;
            @Data
            @Condition("108")
            ICondition documentoJaExiste() ;
            @Data
            @Condition("109")
            ICondition clienteCgd() ;
            
            
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
            ICondition errosFuncao() ;
            @Data
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            @Data
            @Condition("DA")
            ICondition erDadosEntrada() ;
            
            
            
            public interface Matriz extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaOpeL() ;
                
                @Data(size=3)
                IString cMnemEgcOpeL() ;
                
                @Data(size=10, compression=COMP3)
                ILong nPrcpNcliL() ;
                
                @Data(size=135)
                IString nmPrcpNcliL() ;
                
                @Data(size=40)
                IString dArruamentoL() ;
                
                @Data(size=40)
                IString xCpltMordL() ;
                
                @Data(size=40)
                IString nmLocalidadeL() ;
                
                @Data(size=15)
                IString cEndcRgnlL() ;
                
                @Data(size=15)
                IString cPostalL() ;
                
                @Data(size=3)
                IString cPaisIsoaMordL() ;
                
                @Data(size=15)
                IString nTelNcliL() ;
                
                @Data(size=3)
                IString cPaisIsaEmsDocL() ;
                
                @Data(size=3)
                IString cTipoDocIdL() ;
                
                @Data(size=20)
                IString nDocIdL() ;
                
                @Data(size=1)
                IString cTipoNcliL() ;
                
                @Data(size=10)
                IString zNascNcliL() ;
                
                @Data(size=3)
                IString cPaisNacnNcliL() ;
                
                @Data(size=10)
                IString zVldeDocIdL() ;
                
                @Data(size=10)
                IString cEntEmixDocIdL() ;
                
                @Data(size=3)
                IString cPaisEmsDocPL() ;
                
                @Data(size=3)
                IString cTipoDocIdPL() ;
                
                @Data(size=20)
                IString nDocIdPclvL() ;
                
                @Data(size=10)
                IString zVldeDocIdPL() ;
                
                @Data(size=10)
                IString cEntEmiDidPL() ;
                
                @Data(size=160)
                IString nmEmpRnpcL() ;
                
                @Data(size=6, compression=COMP3)
                IInt cAeL() ;
                
                @Data(size=7, compression=COMP3)
                IInt cSectIttlBporL() ;
                
                @Data(size=80)
                IString dAeL() ;
                
                @Data(size=3)
                IString cPaisIsoaSedeL() ;
                
                @Data(size=40)
                IString dArruMordSedeL() ;
                
                @Data(size=40)
                IString xCpltMordSedeL() ;
                
                @Data(size=15)
                IString cPostMordSedeL() ;
                
                @Data(size=30)
                IString nmLoclSedeEmpL() ;
                
                @Data(size=15)
                IString cEndcRgnlSedeL() ;
                
                @Data(size=1)
                IString iEtbIdvlRpsLL() ;
                
                @Data(size=1)
                IString iCicvSemPjrdL() ;
                
                @Data(size=10)
                IString zOpeUltL() ;
                
            }
        }
    }
    
}
