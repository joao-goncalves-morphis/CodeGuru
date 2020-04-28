package cgd.ho.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
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
public interface Bhol804a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOS804A")
    IString conMhos804a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * **                        BHOL804A
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
            
            @Data(size=1)
            IString debug() ;
            @Data
            @Condition("S")
            ICondition debugS() ;
            @Data
            @Condition("N")
            ICondition debugN() ;
            
            
            /**
             * @return instancia da classe local CriterioConsulta
             */
            @Data
            CriterioConsulta criterioConsulta() ;
            
            @Data(size=1)
            IString iCriterioDbcr() ;
            @Data
            @Condition("D")
            ICondition debito() ;
            @Data
            @Condition("C")
            ICondition credito() ;
            @Data
            @Condition(" ")
            ICondition ambos() ;
            
            
            /**
             * @return instancia da classe local CriterioMontante
             */
            @Data
            CriterioMontante criterioMontante() ;
            
            /**
             * @return instancia da classe local CriterioSeleccao
             */
            @Data
            CriterioSeleccao criterioSeleccao() ;
            
            /**
             * @return instancia da classe local CriterioDia
             */
            @Data
            CriterioDia criterioDia() ;
            
            @Data(size=1)
            IString critDatasMovDif() ;
            @Data
            @Condition("S")
            ICondition critDatasMovDifS() ;
            @Data
            @Condition("N")
            ICondition critDatasMovDifN() ;
            
            
            @Data(size=10)
            IString zValorMax() ;
            
            @Data(size=10)
            IString zValorMin() ;
            
            /**
             * @return instancia da classe local Argumento
             */
            @Data
            Argumento argumento() ;
            
            /**
             * @return instancia da classe local Detalhe
             */
            @Data
            Detalhe detalhe() ;
            
            
            public interface CriterioConsulta extends IDataStruct {
                
                @Data(size=1)
                IString iCriterioCns() ;
                @Data
                @Condition("A")
                ICondition ascendente() ;
                @Data
                @Condition("D")
                ICondition descendente() ;
                
                
            }
            
            public interface CriterioMontante extends IDataStruct {
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMax() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMin() ;
                
            }
            
            public interface CriterioSeleccao extends IDataStruct {
                
                @Data(size=26)
                IString tsMovMax() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovMax() ;
                
            }
            
            public interface CriterioDia extends IDataStruct {
                
                @Data(size=1)
                IString iMovDia() ;
                @Data
                @Condition("S")
                ICondition iMovDiaS() ;
                @Data
                @Condition("N")
                ICondition iMovDiaN() ;
                
                
            }
            
            public interface Argumento extends IDataStruct {
                
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
                
                @Data(size=3)
                IString cMoedIsoScta() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt nsDeposito() ;
                
                @Data(size=10)
                IString zMovimento() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimento() ;
                
            }
            
            public interface Detalhe extends IDataStruct {
                
                @Data(size=10)
                IString zValor() ;
                
                @Data(size=1)
                IString iDbcr() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimento() ;
                
                @Data(size=1)
                IString iEstorno() ;
                
                @Data(size=3)
                IString cMoedIsoOriMov() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloApos() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoDpnlApos() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMoeOrigMov() ;
                
                @Data(size=21)
                IString xRefMov() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nDocOpps() ;
                
                @Data(size=10, decimal=7, signed=true, compression=COMP3)
                IDecimal tJuro() ;
                
                @Data(size=2)
                IString aAplOrig() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=2)
            IInt qItens() ;
            
            /**
             * @return instancia da classe local Lista
             */
            @Data(length=12)
            IArray<Lista> lista() ;
            
            
            public interface Lista extends IDataStruct {
                
                
                /**
                 * @return instancia da classe local Item
                 */
                @Data
                Item item() ;
                
                
                public interface Item extends IDataStruct {
                    
                    @Data(size=40)
                    IString itemArgumento() ;
                    
                    @Data(size=86)
                    IString itemDetalhe() ;
                    
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
            @Data
            @Condition("000")
            ICondition ok() ;
            @Data
            @Condition("233")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("049")
            ICondition naoExiste() ;
            @Data
            @Condition("216")
            ICondition db2() ;
            
            
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
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
