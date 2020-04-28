package cgd.sx.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
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
public interface Bsxl093a extends IDataStruct {
    
    /**
     * @return instancia da classe local Arealig
     */
    @Data
    Arealig arealig() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BSXL093A
     * AREA DE LIGACAO DA ROTINA QUE OS DADOS ADICIONAIS DE UM MOVIMEN*
     * TO - MSXS093A
     * 
     * @version 2.0
     * 
     */
    public interface Arealig extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * @return instancia da classe local Output
         */
        @Data
        Output output() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=10)
            IString zValorMovI() ;
            
            @Data(size=2)
            IString cAplEpddSibsI() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nLogSibsI() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong nRegLogSibsI() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nContSibsI() ;
            
        }
        
        public interface Output extends IDataStruct {
            
            /**
             * @return instancia da classe local OutputStatus
             */
            @Data
            OutputStatus outputStatus() ;
            
            
            public interface OutputStatus extends IDataStruct {
                
                @Data(size=2)
                IString stRetornoS() ;
                @Data
                @Condition("00")
                ICondition opStatusOk() ;
                @Data
                @Condition("01")
                ICondition opErroDados() ;
                @Data
                @Condition("02")
                ICondition opNaoExiste() ;
                @Data
                @Condition("03")
                ICondition opErroDb2() ;
                
                
                @Data(size=4)
                IString posErroS() ;
                
                @Data(size=80)
                IString descErroS() ;
                
                /**
                 * @return instancia da classe local OpMsgTabS
                 */
                @Data
                @Mask
                OpMsgTabS opMsgTabS() ;
                
                
                public interface OpMsgTabS extends IDataMask {
                    
                    @Data(size=3)
                    IInt opReturnSqlcodeS() ;
                    
                    @Data(size=8)
                    IString opNomeTabS() ;
                    
                    @Data(size=2)
                    IString opAcessoTabS() ;
                    @Data
                    @Condition("SE")
                    ICondition dSelect() ;
                    
                    
                    @Data(size=10)
                    IString zValorMovS() ;
                    
                    @Data(size=2)
                    IString cAplEpddSibsS() ;
                    
                    @Data(size=4)
                    IInt nLogSibsS() ;
                    
                    @Data(size=8)
                    ILong nRegLogSibsS() ;
                    
                    @Data(size=15, rpadding=28)
                    ILong nContSibsS() ;
                    
                }
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=10)
            IString zValorMovO() ;
            
            @Data(size=2)
            IString cAplEpddSibsO() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nLogSibsO() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong nRegLogSibsO() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nContSibsO() ;
            
            @Data(size=19)
            IString cPanCmplSibsO() ;
            
            @Data(size=40)
            IString xLclzTermSibsO() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancApoiSibsO() ;
            
            @Data(size=10)
            IString cIdTermSibsO() ;
            
            @Data(size=18)
            IString dTipoTermSibsO() ;
            
            @Data(size=40)
            IString nmLocalidadeO() ;
            
            @Data(size=15)
            IString cPostalO() ;
            
            @Data(size=8)
            IString hTransaccaoO() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimentoO() ;
            
            @Data(size=3)
            IString cMoedIsoMovO() ;
            
            @Data(size=21)
            IString xRefMovDestO() ;
            
            @Data(size=36)
            IString nmOrdnTrfcO() ;
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt cEntCbrSrvSibsO() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong cRefPagSrvSibsO() ;
            
            /**
             * 10 BSXL093A-C-REF-PAG-SRV-SIBS-O  PIC S9(09)V USAGE COMP-3.
             */
            @Data(size=80)
            IString cTipoServSibsO() ;
            
            @Data(size=2)
            IString cTipoSpteMovO() ;
            
            @Data(size=100)
            IString xInfAdiMovO() ;
            
        }
    }
    
}
