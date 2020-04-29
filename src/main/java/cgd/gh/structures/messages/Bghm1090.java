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
public interface Bghm1090 extends IDataStruct {
    
    @Data(size=4, signed=true, value="70", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="3")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("0")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="0")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="70", compression=COMP)
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
             * @return instancia da classe local NsRdclContSt
             */
            @Data
            NsRdclContSt nsRdclContSt() ;
            
            /**
             * @return instancia da classe local ZMovIniSt
             */
            @Data
            ZMovIniSt zMovIniSt() ;
            
            /**
             * @return instancia da classe local ZMovFimSt
             */
            @Data
            ZMovFimSt zMovFimSt() ;
            
            
            public interface NsRdclContSt extends IDataStruct {
                
                @Data(size=1)
                IString nsRdclContS() ;
                @Data
                @Condition("0")
                ICondition nsRdclCont0() ;
                @Data
                @Condition("1")
                ICondition nsRdclCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsRdclContM() ;
                
            }
            
            public interface ZMovIniSt extends IDataStruct {
                
                @Data(size=1)
                IString zMovIniS() ;
                @Data
                @Condition("0")
                ICondition zMovIni0() ;
                @Data
                @Condition("1")
                ICondition zMovIni1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt zMovIniM() ;
                
            }
            
            public interface ZMovFimSt extends IDataStruct {
                
                @Data(size=1)
                IString zMovFimS() ;
                @Data
                @Condition("0")
                ICondition zMovFim0() ;
                @Data
                @Condition("1")
                ICondition zMovFim1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt zMovFimM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
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
            IString zMovIni() ;
            
            @Data(size=10)
            IString zMovFim() ;
            
            /**
             * @return instancia da classe local ICritMontante
             */
            @Data
            ICritMontante iCritMontante() ;
            
            @Data(size=1)
            IString iCritDbcr() ;
            @Data
            @Condition("T")
            ICondition debito() ;
            @Data
            @Condition("C")
            ICondition credito() ;
            @Data
            @Condition(" ")
            ICondition ambos() ;
            
            
            
            public interface ICritMontante extends IDataStruct {
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMin() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMax() ;
                
            }
        }
    }
    
}
