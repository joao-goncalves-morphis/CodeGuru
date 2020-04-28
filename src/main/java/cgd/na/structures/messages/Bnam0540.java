package cgd.na.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
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
public interface Bnam0540 extends IDataStruct {
    
    @Data(size=4, signed=true, value="59", compression=COMP)
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
    
    @Data(size=4, signed=true, value="59", compression=COMP)
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
             * @return instancia da classe local NsRdclOpcrSt
             */
            @Data
            NsRdclOpcrSt nsRdclOpcrSt() ;
            
            /**
             * @return instancia da classe local NsRdclContSt
             */
            @Data
            NsRdclContSt nsRdclContSt() ;
            
            /**
             * @return instancia da classe local NReferenciaSt
             */
            @Data
            NReferenciaSt nReferenciaSt() ;
            
            
            public interface NsRdclOpcrSt extends IDataStruct {
                
                @Data(size=1)
                IString nsRdclOpcrS() ;
                @Data
                @Condition("0")
                ICondition nsRdclOpcr0() ;
                @Data
                @Condition("1")
                ICondition nsRdclOpcr1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsRdclOpcrM() ;
                
            }
            
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
            
            public interface NReferenciaSt extends IDataStruct {
                
                @Data(size=1)
                IString nReferenciaS() ;
                @Data
                @Condition("0")
                ICondition nReferencia0() ;
                @Data
                @Condition("1")
                ICondition nReferencia1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nReferenciaM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaOpcr() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancOpcr() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpcr() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclOpcr() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdOpcr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContOpcr() ;
            
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
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nReferencia() ;
            
            @Data(size=10)
            IString zMovimentoC() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimentoC() ;
            
        }
    }
    
}
