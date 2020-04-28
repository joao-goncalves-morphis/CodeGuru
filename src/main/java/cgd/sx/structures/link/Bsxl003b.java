package cgd.sx.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bsxl003b extends IDataStruct {
    
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
     * FUNCAO:        AREA DE LIGACAO AO MODULO MSXS003A
     * *ALTERACOES:
     * PROCESSO:
     * DESCRICAO:
     * DATA:
     * PROGRAMACAO:
     * 
     * @version 2.0
     * 
     */
    public interface Arealig extends IDataStruct {
        
        /**
         * @return instancia da classe local InputDados
         */
        @Data
        InputDados inputDados() ;
        
        /**
         * @return instancia da classe local Output
         */
        @Data
        Output output() ;
        
        
        public interface InputDados extends IDataStruct {
            
            @Data(size=1)
            IString ipTipAcesso() ;
            
            @Data(size=3)
            IString ipCTabSx() ;
            
            @Data(size=20)
            IString ipCCodigo() ;
            
            @Data(size=30)
            IString ipDCodAbvd() ;
            
            @Data(size=80)
            IString ipDCodLong() ;
            
            @Data(size=1)
            IString ipIElizLogc() ;
            
            @Data(size=8)
            IString ipNmPrgActzUlt() ;
            
        }
        
        public interface Output extends IDataStruct {
            
            /**
             * @return instancia da classe local OutputStatus
             */
            @Data
            OutputStatus outputStatus() ;
            
            /**
             * @return instancia da classe local OutputDados
             */
            @Data
            OutputDados outputDados() ;
            
            
            public interface OutputStatus extends IDataStruct {
                
                @Data(size=2)
                IString opStatusRetorno() ;
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
                IString opPosErro() ;
                
                @Data(size=99)
                IString opMsgGeral() ;
                
                /**
                 * @return instancia da classe local OpMsgFich
                 */
                @Data
                @Mask
                OpMsgFich opMsgFich() ;
                
                /**
                 * @return instancia da classe local OpMsgTab
                 */
                @Data
                @Mask
                OpMsgTab opMsgTab() ;
                
                @Data(size=4)
                IString opReturnCode() ;
                
                
                public interface OpMsgFich extends IDataMask {
                    
                    @Data(size=8)
                    IString opNomeFich() ;
                    
                    @Data(size=2)
                    IString opAcessoFich() ;
                    
                    @Data(size=2)
                    IString opFileStatus() ;
                    
                    @Data(format="Z(07)9")
                    IFormattedString opTotAcessosFich() ;
                    
                    @Data(size=73, rpadding=6)
                    IString opDescAcessoFich() ;
                    
                }
                
                public interface OpMsgTab extends IDataMask {
                    
                    @Data(size=8)
                    IString opNomeTab() ;
                    
                    @Data(size=2)
                    IString opAcessoTab() ;
                    @Data
                    @Condition("IN")
                    ICondition dInsert() ;
                    @Data
                    @Condition("UP")
                    ICondition dUpdate() ;
                    @Data
                    @Condition("DE")
                    ICondition dDelete() ;
                    @Data
                    @Condition("SE")
                    ICondition dSelect() ;
                    @Data
                    @Condition("OP")
                    ICondition dOpen() ;
                    @Data
                    @Condition("FE")
                    ICondition dFetch() ;
                    @Data
                    @Condition("CL")
                    ICondition dClose() ;
                    @Data
                    @Condition("DC")
                    ICondition dDeclare() ;
                    
                    
                    @Data(format="-9(03)")
                    IFormattedString opReturnSqlCode() ;
                    
                    @Data(format="Z(07)9")
                    IFormattedString opTotAcessosTab() ;
                    
                    @Data(size=73, rpadding=4)
                    IString opDescAcessoTab() ;
                    
                }
            }
            
            public interface OutputDados extends IDataStruct {
                
                @Data(size=3)
                IString opCTabSx() ;
                
                @Data(size=20)
                IString opCCodigo() ;
                
                @Data(size=30)
                IString opDCodAbvd() ;
                
                @Data(size=80)
                IString opDCodLong() ;
                
                @Data(size=1)
                IString opIElizLogc() ;
                
                @Data(size=8)
                IString opCUsidActzUlt() ;
                
                @Data(size=8)
                IString opNmPrgActzUlt() ;
                
                @Data(size=26)
                IString opTsCriacao() ;
                
                @Data(size=26)
                IString opTsActzUlt() ;
                
            }
        }
    }
    
}
