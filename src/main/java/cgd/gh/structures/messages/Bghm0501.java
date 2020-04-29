package cgd.gh.structures.messages;

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
public interface Bghm0501 extends IDataStruct {
    
    @Data(size=4, signed=true, value="154", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("0")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="0")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="154", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=1, value="0")
    IInt lengthOccur() ;
    
    /**
     * @return instancia da classe local Msg
     */
    @Data
    Msg msg() ;
    
    /**
     * Inner Classes
     */
    public interface Msg extends IDataStruct {
        
        /**
         * @return instancia da classe local Ase
         */
        @Data
        Ase ase() ;
        
        /**
         * @return instancia da classe local Ade
         */
        @Data
        Ade ade() ;
        
        
        public interface Ase extends IDataStruct {
            
            /**
             * @return instancia da classe local IAccaoSt
             */
            @Data
            IAccaoSt iAccaoSt() ;
            
            
            public interface IAccaoSt extends IDataStruct {
                
                @Data(size=1)
                IString iAccaoS() ;
                @Data
                @Condition("0")
                ICondition iAccao0() ;
                @Data
                @Condition("1")
                ICondition iAccao1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAccaoM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            /**
             * PRC19 - INI
             * 10 BGHM0501-TS-PEDIDO              PIC S9(15) COMP-3.
             */
            @Data(size=1)
            IString iAccao() ;
            @Data
            @Condition("C")
            ICondition criacao() ;
            @Data
            @Condition("A")
            ICondition anulacao() ;
            
            
            @Data(size=7)
            IString cPedInfOpps() ;
            
            @Data(size=10)
            IString zInicMov() ;
            
            @Data(size=10)
            IString zFimMov() ;
            
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
            
            @Data(size=2)
            IString cCanlTrmzInf() ;
            
            @Data(size=15)
            IString cEndcFtpDest() ;
            
            @Data(size=2)
            IString aAplDst() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mParmPedHstMax() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mParmPedHstMin() ;
            
            @Data(size=15)
            IString cParmPedHstMax() ;
            
            @Data(size=15)
            IString cParmPedHstMin() ;
            
            @Data(size=3)
            IString cPaisIsoaDst() ;
            
            @Data(size=3)
            IString cMnemEgcDst() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcDst() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpx() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong tsPedido() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nClientePed() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCliPed() ;
            
        }
    }
    
}
