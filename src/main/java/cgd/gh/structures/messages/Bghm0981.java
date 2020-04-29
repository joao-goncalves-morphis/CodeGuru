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
public interface Bghm0981 extends IDataStruct {
    
    @Data(size=4, signed=true, value="376", compression=COMP)
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
    
    @Data(size=4, signed=true, value="370", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=3, value="0")
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
             * @return instancia da classe local CPaisIsoaContSt
             */
            @Data
            CPaisIsoaContSt cPaisIsoaContSt() ;
            
            
            public interface CPaisIsoaContSt extends IDataStruct {
                
                @Data(size=1)
                IString cPaisIsoaContS() ;
                @Data
                @Condition("0")
                ICondition cPaisIsoaCont0() ;
                @Data
                @Condition("1")
                ICondition cPaisIsoaCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPaisIsoaContM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            /**
             * @return instancia da classe local GrCheque
             */
            @Data
            GrCheque grCheque() ;
            
            /**
             * @return instancia da classe local GrOutros
             */
            @Data
            GrOutros grOutros() ;
            
            
            public interface GrCheque extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsaTmxChq() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancTomador() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcTomxCheq() ;
                
                @Data(size=14, signed=true, compression=COMP3)
                ILong nRefCheqArqv() ;
                
            }
            
            public interface GrOutros extends IDataStruct {
                
                @Data(size=23)
                IString nCartao() ;
                
                @Data(size=40)
                IString nmEntidade() ;
                
                /**
                 * @return instancia da classe local CIdentAtm
                 */
                @Data
                CIdentAtm cIdentAtm() ;
                
                @Data(size=40)
                IString cLoclEntidade() ;
                
                @Data(size=15)
                IString cPostal() ;
                
                @Data(size=8)
                IString hpTmerLocl() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovOrigTran() ;
                
                @Data(size=3)
                IString cMoeOrigTran() ;
                
                @Data(size=21)
                IString cRefDst() ;
                
                @Data(size=36)
                IString nmOrdnTrfc() ;
                
                @Data(size=5)
                IString cEntidade() ;
                
                /**
                 * 15 BGHM0981-C-REF-PAGAMENTO     PIC X(9).
                 */
                @Data(size=15)
                IString cRefPagamento() ;
                
                @Data(size=30)
                IString xTpServico() ;
                
                @Data(size=14)
                IString cRefSibs() ;
                
                @Data(size=2)
                IString iTipoSpteMov() ;
                
                @Data(size=70)
                IString cDadAdc() ;
                
                
                public interface CIdentAtm extends IDataStruct {
                    
                    @Data(size=4, signed=true, compression=COMP3)
                    IInt cCcmzApoi() ;
                    
                    @Data(size=4)
                    IString cTermAtm() ;
                    
                    @Data(size=18)
                    IString cEquiAtm() ;
                    
                }
            }
        }
    }
    
}
