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
public interface Bhgl030a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE LIGACAO
     * COM A ROTINA DE ACESSO A TABELAS GERAIS
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
         * @return instancia da classe local DadosEntradaSaida
         */
        @Data
        DadosEntradaSaida dadosEntradaSaida() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosInput extends IDataStruct {
            
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
            
            @Data(size=1)
            IString iAccaoTabBbn() ;
            @Data
            @Condition("V")
            ICondition visualizacao() ;
            @Data
            @Condition("I")
            ICondition insercao() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("E")
            ICondition eliminacao() ;
            @Data
            @Condition("P")
            ICondition purge() ;
            
            
            @Data(size=1)
            IString iDadosObtr() ;
            @Data
            @Condition("D")
            ICondition descricoes() ;
            @Data
            @Condition("C")
            ICondition conteudos() ;
            @Data
            @Condition("A")
            ICondition ambos() ;
            
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=8)
            IString nmPrograma() ;
            
        }
        
        public interface DadosEntradaSaida extends IDataStruct {
            
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
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=80)
            IString dCodLong() ;
            
            @Data(size=30)
            IString dCodAbvd() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("102")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("103")
            ICondition tabSemCampDef() ;
            @Data
            @Condition("104")
            ICondition indicInexistente() ;
            @Data
            @Condition("105")
            ICondition accaoInexistente() ;
            @Data
            @Condition("106")
            ICondition erroSelTabThg00002() ;
            @Data
            @Condition("107")
            ICondition erroSelTabThg00001() ;
            @Data
            @Condition("109")
            ICondition codigoInexistente() ;
            @Data
            @Condition("110")
            ICondition erroSelect() ;
            @Data
            @Condition("111")
            ICondition erroInsert() ;
            @Data
            @Condition("112")
            ICondition erroUpdate() ;
            @Data
            @Condition("113")
            ICondition erroDelete() ;
            @Data
            @Condition("114")
            ICondition registoExistente() ;
            @Data
            @Condition("117")
            ICondition codTabNaoExiste() ;
            
            
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
            @Condition("AT")
            ICondition erroArquitectura() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            @Data
            @Condition("DA")
            ICondition dadosEntrada() ;
            
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            @Data
            @Condition("100")
            ICondition notfnd() ;
            @Data
            @Condition("0")
            ICondition ok() ;
            
            
            @Data(size=30)
            IString chvAces() ;
            
            @Data(size=1)
            IString cAccao() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
            @Data(size=30)
            IString campErro() ;
            
            /**
             * @return instancia da classe local Sqlca
             */
            @Data
            Sqlca sqlca() ;
            
            
            public interface Sqlca extends IDataStruct {
                
                @Data(size=8)
                IString xSqlaid() ;
                
                @Data(size=9, signed=true, compression=COMP)
                ILong qSqlabc() ;
                
                /**
                 * @return instancia da classe local Sqlerrm
                 */
                @Data
                Sqlerrm sqlerrm() ;
                
                @Data(size=8)
                IString sqlerrp() ;
                
                /**
                 * @return instancia da classe local Sqlerrd
                 */
                @Data(length=6)
                IArray<Sqlerrd> sqlerrd() ;
                
                /**
                 * @return instancia da classe local Sqlwarn
                 */
                @Data
                Sqlwarn sqlwarn() ;
                
                @Data(size=8)
                IString xSqlext() ;
                
                
                public interface Sqlerrm extends IDataStruct {
                    
                    @Data(size=4, signed=true, compression=COMP)
                    IInt qSqlerrml() ;
                    
                    @Data(size=70)
                    IString xSqlerrmc() ;
                    
                }
                
                public interface Sqlerrd extends IDataStruct {
                    
                    @Data(size=9, signed=true, compression=COMP)
                    ILong cSqlerrdItem() ;
                    
                }
                
                public interface Sqlwarn extends IDataStruct {
                    
                    @Data(size=1)
                    IString iSqlwarn0() ;
                    
                    @Data(size=1)
                    IString iSqlwarn1() ;
                    
                    @Data(size=1)
                    IString iSqlwarn2() ;
                    
                    @Data(size=1)
                    IString iSqlwarn3() ;
                    
                    @Data(size=1)
                    IString iSqlwarn4() ;
                    
                    @Data(size=1)
                    IString iSqlwarn5() ;
                    
                    @Data(size=1)
                    IString iSqlwarn502() ;
                    
                    @Data(size=1)
                    IString iSqlwarn6() ;
                    
                    @Data(size=1)
                    IString iSqlwarn7() ;
                    
                }
            }
        }
    }
    
}
