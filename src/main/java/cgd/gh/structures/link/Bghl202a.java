package cgd.gh.structures.link;

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


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghl202a extends IDataStruct {
    
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
    
    @Data(size=8, value="MGHJ202A")
    IString mgh202aCon() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * APLICACAO     : GH - GESTAO DE HISTORICOS DE MOVIMENTOS
     * PROGRAMA      : MGHJ202A
     * OBJECTIVO     : CRIACAO DE PEDIDOS NA TGH00015
     * 
     * @version 2.0
     * 
     */
    public interface DadosInput extends IDataStruct {
        
        @Data(size=1)
        IString cAccao() ;
        @Data
        @Condition({ "C", "A" })
        ICondition accaoValida() ;
        @Data
        @Condition("C")
        ICondition criacao() ;
        @Data
        @Condition("A")
        ICondition anulacao() ;
        
        
        @Data(size=7)
        IString cPedInfOpps() ;
        @Data
        @Condition("GH00012")
        ICondition invMovimentos() ;
        @Data
        @Condition("GH00094")
        ICondition mov2Vias() ;
        
        
        /**
         * @return instancia da classe local ArgumentoScta
         */
        @Data
        ArgumentoScta argumentoScta() ;
        
        /**
         * @return instancia da classe local ArgumentoDataMov
         */
        @Data
        ArgumentoDataMov argumentoDataMov() ;
        
        /**
         * @return instancia da classe local ArgumentoPedido
         */
        @Data
        ArgumentoPedido argumentoPedido() ;
        
        /**
         * @return instancia da classe local ArgumentoOrigem
         */
        @Data
        ArgumentoOrigem argumentoOrigem() ;
        
        /**
         * @return instancia da classe local ArgumentoChvPedido
         */
        @Data
        ArgumentoChvPedido argumentoChvPedido() ;
        
        
        public interface ArgumentoScta extends IDataStruct {
            
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
        
        public interface ArgumentoDataMov extends IDataStruct {
            
            @Data(size=10)
            IString zInicMov() ;
            
            @Data(size=10)
            IString zFimMov() ;
            
        }
        
        public interface ArgumentoPedido extends IDataStruct {
            
            @Data(size=2)
            IString aAplDest() ;
            
            @Data(size=2)
            IString cCanlTrmzInf() ;
            @Data
            @Condition("OA")
            ICondition oAplicacoes() ;
            
            
            @Data(size=15)
            IString cEndcFtpDest() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mParmPedHstMax() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mParmPedHstMin() ;
            
            @Data(size=15)
            IString cParmPedHstMax() ;
            
            @Data(size=15)
            IString cParmPedHstMin() ;
            
        }
        
        public interface ArgumentoOrigem extends IDataStruct {
            
            @Data(size=8)
            IString cUsidCrix() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex() ;
            
        }
        
        public interface ArgumentoChvPedido extends IDataStruct {
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong tsPedidoAnula() ;
            
        }
    }
    public interface DadosOutput extends IDataStruct {
        
        /**
         * @return instancia da classe local IdPedido
         */
        @Data
        IdPedido idPedido() ;
        
        /**
         * @return instancia da classe local GrErroBbn
         */
        @Data
        GrErroBbn grErroBbn() ;
        
        
        public interface IdPedido extends IDataStruct {
            
            @Data(size=10)
            IString zInicMovO() ;
            
            @Data(size=10)
            IString zFimMovO() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong tsPedido() ;
            
            @Data(size=10)
            IString zCluzPed() ;
            
            @Data(size=40)
            IString xMtvoDvlzPed() ;
            
        }
        
        public interface GrErroBbn extends IDataStruct {
            
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
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoSwal() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString aAplErro() ;
            
        }
    }
    
}
