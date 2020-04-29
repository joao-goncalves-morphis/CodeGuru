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
public interface Bhgl004a extends IDataStruct {
    
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
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=40)
            IString nmOe() ;
            
            @Data(size=16)
            IString nmOeAbvd() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=1)
            IString cEstCvOe() ;
            
            @Data(size=1)
            IString cTipoOe() ;
            
            @Data(size=1)
            IString cTipoDirzGerx() ;
            
            @Data(size=1)
            IString cRgad() ;
            
            @Data(size=2)
            IString cZonaGeofCpsz() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cPrcaCpsz() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cRgaoCblo() ;
            
            @Data(size=1)
            IString iOeStff() ;
            
            @Data(size=1)
            IString cEstCvCcst() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cCtrlDtbz() ;
            
            @Data(size=1)
            IString cTipoPrctOe() ;
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt cEdificio() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsMorada() ;
            
            @Data(size=10)
            IString zInicVldeCcst() ;
            
            @Data(size=10)
            IString zFimVldeCcst() ;
            
            @Data(size=10)
            IString zInicVldeOe() ;
            
            @Data(size=10)
            IString zFimVldeOe() ;
            
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
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=10)
            IString zContabilizacao() ;
            
            @Data(size=10)
            IString zCredito() ;
            
            @Data(size=10)
            IString zDebito() ;
            
            @Data(size=10)
            IString zPrctUlt() ;
            
            @Data(size=10)
            IString zCtlzUlt() ;
            
            @Data(size=10)
            IString zCredUlt() ;
            
            @Data(size=10)
            IString zDebUlt() ;
            
            @Data(size=2)
            IString cTipoOrggAgen() ;
            
            @Data(size=2)
            IString cTipoAgen() ;
            
            @Data(size=1)
            IString iUtlLogCnsl() ;
            
            @Data(size=1)
            IString iOfflPlgd() ;
            
            @Data(size=5)
            IString cModlFuntOe() ;
            
            @Data(size=10)
            IString zAsszModlFunt() ;
            
            @Data(size=3)
            IString cMnemOe() ;
            
            @Data(size=8)
            IString cMnemGrupTrmOe() ;
            
            @Data(size=3)
            IString cDbtzGeofValOe() ;
            
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
            @Condition("116")
            ICondition oeNaoExiste() ;
            
            
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
