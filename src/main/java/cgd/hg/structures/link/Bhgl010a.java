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
public interface Bhgl010a extends IDataStruct {
    
    @Data(size=8, value="MHGJ010A")
    IString rotCodPais() ;
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
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
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=1)
            IString indTipoCodPais() ;
            
            @Data(size=3)
            IString codPais() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMoedIsoDflt() ;
            
            @Data(size=4)
            IString cPaisChkdIban() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cPaisIsoNmrc() ;
            
            @Data(size=3)
            IString cPaisIsoAlf3() ;
            
            @Data(size=1)
            IString iPaisUe() ;
            
            @Data(size=1)
            IString cContinente() ;
            
            @Data(size=1)
            IString iPaisPrsoFscl() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("004")
            ICondition warningDb2() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            @Data
            @Condition("102")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("014")
            ICondition tabelaSemDados() ;
            
            
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
            @Condition("AT")
            ICondition erroArquitectura() ;
            @Data
            @Condition("DA")
            ICondition dadosEntrada() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
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
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlcode() ;
                
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
