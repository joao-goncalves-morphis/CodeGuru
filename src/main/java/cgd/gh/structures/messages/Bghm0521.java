package cgd.gh.structures.messages;

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
public interface Bghm0521 extends IDataStruct {
    
    @Data(size=4, signed=true, value="516", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("10")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="10")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="516", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=2, value="49")
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
             * @return instancia da classe local TsPedidoSt
             */
            @Data
            TsPedidoSt tsPedidoSt() ;
            
            
            public interface TsPedidoSt extends IDataStruct {
                
                @Data(size=1)
                IString tsPedidoS() ;
                @Data
                @Condition("0")
                ICondition tsPedido0() ;
                @Data
                @Condition("1")
                ICondition tsPedido1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt tsPedidoM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            /**
             * @return instancia da classe local GrPed
             */
            @Data(length=10)
            IArray<GrPed> grPed() ;
            
            @Data(size=1)
            IString iMsgCtnd() ;
            
            @Data(size=3)
            IString cPaisIsoaContK() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContK() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContK() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContK() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContK() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContK() ;
            
            @Data(size=3)
            IString cMoedIsoSctaK() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepositoK() ;
            
            
            public interface GrPed extends IDataStruct {
                
                
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
                
                @Data(size=7)
                IString cPedInfOpps() ;
                
                @Data(size=10)
                IString zInicMov() ;
                
                @Data(size=10)
                IString zFimMov() ;
                
            }
        }
    }
    
}
