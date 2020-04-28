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
public interface Bhgl911a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHGJ011A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE LIGACAO
     * COM A ROTINA DE ACESSO A TABELAS GERAIS
     * INSTRUCOES DE PREENCHIMENTO
     * CAMPOS OBRIGATORIOS- BHGL911A-I-INDIC-BUSCA
     * BHGL911A-C-TAB-BBN
     * SE PESQUISA POR CHAVE, OBRIGATORIO BHGL911A-C-CODIGO
     * SE PESQUISA POR ATRIBUTO, OBRIGATORIO PREENCHER ALGUM INDICADOR
     * DE ATRIBUTO PARA PESQUISA
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
            
            /**
             * @return instancia da classe local IIndicBusca
             */
            @Data
            IIndicBusca iIndicBusca() ;
            
            @Data(size=1)
            IString iDebug() ;
            @Data
            @Condition("S")
            ICondition swDebugOn() ;
            @Data
            @Condition("N")
            ICondition swDebugOff() ;
            
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cTabBbn() ;
            
            @Data(size=20)
            IString cCodigo() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=8)
            IString nmPrograma() ;
            
            /**
             * @return instancia da classe local ChaveContinuacao
             */
            @Data
            ChaveContinuacao chaveContinuacao() ;
            
            @Data(size=3)
            IInt indiceAtributo() ;
            @Data
            @Condition("030")
            ICondition paginaCheiaA() ;
            
            
            /**
             * UM ATRIBUTO POR CADA UM DOS CRITERIOS DE PESQUISA
             * @return instancia da classe local SelAtributos
             */
            @Data(length=30)
            IArray<SelAtributos> selAtributos() ;
            
            
            public interface IIndicBusca extends IDataStruct {
                
                @Data(size=1)
                IString pesqChave() ;
                @Data
                @Condition("P")
                ICondition chaveParcial() ;
                @Data
                @Condition("C")
                ICondition consultaTotal() ;
                
                
                @Data(size=1)
                IString pesqAtrib() ;
                @Data
                @Condition("A")
                ICondition pesqAtributo() ;
                @Data
                @Condition("S")
                ICondition semPesqAtr() ;
                
                
            }
            
            public interface ChaveContinuacao extends IDataStruct {
                
                @Data(size=20)
                IString cCodigoL() ;
                
                @Data(size=3)
                IString cIdioIsoL() ;
                
            }
            
            
            /**
             * 
             * UM ATRIBUTO POR CADA UM DOS CRITERIOS DE PESQUISA
             * 
             * @version 2.0
             * 
             */
            public interface SelAtributos extends IDataStruct {
                
                @Data(size=1)
                IString xCteuCo00I() ;
                @Data
                @Condition("S")
                ICondition xCteuCo00IS() ;
                @Data
                @Condition(" ")
                ICondition xCteuCo00IN() ;
                
                
                @Data(size=18)
                IString xCteuCo00C() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3)
            IInt indice() ;
            @Data
            @Condition("100")
            ICondition paginaCheia() ;
            
            
            /**
             * @return instancia da classe local LogicaFisica
             */
            @Data(length=100)
            IArray<LogicaFisica> logicaFisica() ;
            
            
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
                    IString cCodigoOut() ;
                    
                    @Data(size=3)
                    IString cIdioIsoOut() ;
                    
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
