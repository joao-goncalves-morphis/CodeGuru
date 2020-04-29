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
public interface Bhol351a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ351A")
    IString nmRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL351A - AREA DE LIGACAO DA ROTINA HISTORICO DE MOVIMENTOS
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
         * @return instancia da classe local AreaOutput
         */
        @Data
        AreaOutput areaOutput() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=1)
            IString debug() ;
            @Data
            @Condition("S")
            ICondition debugSim() ;
            @Data
            @Condition("N")
            ICondition debugNao() ;
            
            
            /**
             * @return instancia da classe local Subconta
             */
            @Data
            Subconta subconta() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=1)
            IString iConsultas() ;
            
            @Data(size=1)
            IString iMovDia() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qMovimentos() ;
            
            
            public interface Subconta extends IDataStruct {
                
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
                
            }
        }
        
        public interface AreaOutput extends IDataStruct {
            
            /**
             * @return instancia da classe local TabMovimentos
             */
            @Data(length=13)
            IArray<TabMovimentos> tabMovimentos() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qPndeEnvr() ;
            @Data
            @Condition("13")
            ICondition pagCheia() ;
            
            
            /**
             * @return instancia da classe local DadosErro
             */
            @Data
            DadosErro dadosErro() ;
            
            
            public interface TabMovimentos extends IDataStruct {
                
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimentoO() ;
                
                @Data(size=10)
                IString zMovimentoO() ;
                
                @Data(size=10)
                IString zValorO() ;
                
                @Data(size=21)
                IString xRefMovO() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimentoO() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloO() ;
                
                @Data(size=1)
                IString iDbcrO() ;
                
                @Data(size=1)
                IString iEstornoO() ;
                
                @Data(size=3)
                IString cMoedIsoOriMovO() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloAposO() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoDpnlAposO() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nDocumentoO() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMoeOrigMovO() ;
                
                @Data(size=2)
                IString aAplOrigO() ;
                
                @Data(size=12, decimal=5, signed=true, compression=COMP3)
                IDecimal tJuroO() ;
                
            }
            
            public interface DadosErro extends IDataStruct {
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong cSqlcode() ;
                
                @Data(size=2)
                IString aAplErr() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cRtnoEvenSwal() ;
                @Data
                @Condition("049")
                ICondition dadosNotfnd() ;
                
                
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
    
}
