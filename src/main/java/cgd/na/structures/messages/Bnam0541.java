package cgd.na.structures.messages;

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
public interface Bnam0541 extends IDataStruct {
    
    @Data(size=4, signed=true, value="1217", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("22")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="22")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="1217", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=2, value="51")
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
            
            @Data(size=1)
            IString cSitOpcr() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3)
            IString cTitHono() ;
            
            @Data(size=35)
            IString nmCliAbvd() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            /**
             * 10  BNAM0541-N-REFERENCIA             PIC S9(09) COMP-3.
             * @return instancia da classe local Linha
             */
            @Data(length=22)
            IArray<Linha> linha() ;
            
            
            
            /**
             * 
             * 10  BNAM0541-N-REFERENCIA             PIC S9(09) COMP-3.
             * 
             * @version 2.0
             * 
             */
            public interface Linha extends IDataStruct {
                
                /**
                 * 10  BNAM0541-LINHA OCCURS 23 TIMES.
                 */
                @Data(size=10)
                IString zMovimentoL() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimentoL() ;
                
                @Data(size=10)
                IString zValMovL() ;
                
                @Data(size=5)
                IString cOpeBbnL() ;
                
                @Data(size=1)
                IString iDbcrL() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimentoL() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsPrszOpcrL() ;
                
            }
        }
    }
    
}
