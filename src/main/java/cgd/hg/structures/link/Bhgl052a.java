package cgd.hg.structures.link;

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
public interface Bhgl052a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHGJ052A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHGL052A
     * ROTINA DE OBTENCAO DA COMPONENTE LOGICA E FISICA ASSOCIADA
     * NOTA - NO PRIMEIRO ACESSO PREENCHER OS CAMPOS DE PAGINAÇÃO
     * DE INPUT COM ESPAÇOS
     * - NOS ACESSOS SEGUINTES PARA PAGINAR PREENCHER OS CAMPOS
     * DE PAGINAÇÃO COM O SEGUINTE:
     * BHGL052A-C-CODIGO-PG-IN   = BHGL052A-C-CODIGO-PG-OUT
     * BHGL052A-C-IDIO-ISO-PG-IN = BHGL052A-C-IDIO-ISO-PG-OUT
     * - ATE SER RECEBIDO FIM DE CONSULTA (FC)
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=3)
            IString cTabBbnIn() ;
            
            @Data(size=3)
            IString cIdioIsoIn() ;
            
            /**
             * @return instancia da classe local PagInput
             */
            @Data
            PagInput pagInput() ;
            
            @Data(size=1)
            IString iDebug() ;
            @Data
            @Condition("S")
            ICondition debugS() ;
            @Data
            @Condition("N")
            ICondition debugN() ;
            
            
            
            public interface PagInput extends IDataStruct {
                
                @Data(size=20)
                IString cCodigoPgIn() ;
                
                @Data(size=3)
                IString cIdioIsoPgIn() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3)
            IInt indice() ;
            @Data
            @Condition("100")
            ICondition paginaCheia() ;
            
            
            /**
             * @return instancia da classe local PagOutput
             */
            @Data
            PagOutput pagOutput() ;
            
            /**
             * @return instancia da classe local LogicaFisica
             */
            @Data(length=100)
            IArray<LogicaFisica> logicaFisica() ;
            
            
            public interface PagOutput extends IDataStruct {
                
                @Data(size=20)
                IString cCodigoPgOut() ;
                
                @Data(size=3)
                IString cIdioIsoPgOut() ;
                
            }
            
            public interface LogicaFisica extends IDataStruct {
                
                /**
                 * @return instancia da classe local ComponenteLogica
                 */
                @Data
                ComponenteLogica componenteLogica() ;
                
                /**
                 * @return instancia da classe local ComponenteFisica
                 */
                @Data
                ComponenteFisica componenteFisica() ;
                
                
                public interface ComponenteLogica extends IDataStruct {
                    
                    @Data(size=20)
                    IString cCodigo() ;
                    
                    @Data(size=3)
                    IString cIdioIso() ;
                    
                    @Data(size=30)
                    IString dCodAbvd() ;
                    
                    @Data(size=80)
                    IString dCodLong() ;
                    
                }
                
                public interface ComponenteFisica extends IDataStruct {
                    
                    @Data(size=18)
                    IString xCteuCo01() ;
                    
                    @Data(size=18)
                    IString xCteuCo02() ;
                    
                    @Data(size=18)
                    IString xCteuCo03() ;
                    
                    @Data(size=18)
                    IString xCteuCo04() ;
                    
                    @Data(size=18)
                    IString xCteuCo05() ;
                    
                    @Data(size=18)
                    IString xCteuCo06() ;
                    
                    @Data(size=18)
                    IString xCteuCo07() ;
                    
                    @Data(size=18)
                    IString xCteuCo08() ;
                    
                    @Data(size=18)
                    IString xCteuCo09() ;
                    
                    @Data(size=18)
                    IString xCteuCo10() ;
                    
                    @Data(size=18)
                    IString xCteuCo11() ;
                    
                    @Data(size=18)
                    IString xCteuCo12() ;
                    
                    @Data(size=18)
                    IString xCteuCo13() ;
                    
                    @Data(size=18)
                    IString xCteuCo14() ;
                    
                    @Data(size=18)
                    IString xCteuCo15() ;
                    
                    @Data(size=18)
                    IString xCteuCo16() ;
                    
                    @Data(size=18)
                    IString xCteuCo17() ;
                    
                    @Data(size=18)
                    IString xCteuCo18() ;
                    
                    @Data(size=18)
                    IString xCteuCo19() ;
                    
                    @Data(size=18)
                    IString xCteuCo20() ;
                    
                    @Data(size=18)
                    IString xCteuCo21() ;
                    
                    @Data(size=18)
                    IString xCteuCo22() ;
                    
                    @Data(size=18)
                    IString xCteuCo23() ;
                    
                    @Data(size=18)
                    IString xCteuCo24() ;
                    
                    @Data(size=18)
                    IString xCteuCo25() ;
                    
                    @Data(size=18)
                    IString xCteuCo26() ;
                    
                    @Data(size=18)
                    IString xCteuCo27() ;
                    
                    @Data(size=18)
                    IString xCteuCo28() ;
                    
                    @Data(size=18)
                    IString xCteuCo29() ;
                    
                    @Data(size=18)
                    IString xCteuCo30() ;
                    
                }
            }
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=18)
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
            @Condition(" ")
            ICondition semErros() ;
            
            
        }
    }
    
}
