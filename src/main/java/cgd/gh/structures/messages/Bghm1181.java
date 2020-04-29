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
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm1181 extends IDataStruct {
    
    @Data(size=4, signed=true, value="1274", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="9")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("21")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="21")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="1274", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=3, value="57")
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
            
            /**
             * @return instancia da classe local CBancContSt
             */
            @Data
            CBancContSt cBancContSt() ;
            
            /**
             * @return instancia da classe local COeEgcContSt
             */
            @Data
            COeEgcContSt cOeEgcContSt() ;
            
            /**
             * @return instancia da classe local NsRdclContSt
             */
            @Data
            NsRdclContSt nsRdclContSt() ;
            
            /**
             * @return instancia da classe local VChkdContSt
             */
            @Data
            VChkdContSt vChkdContSt() ;
            
            /**
             * @return instancia da classe local CTipoContSt
             */
            @Data
            CTipoContSt cTipoContSt() ;
            
            /**
             * @return instancia da classe local CMoedIsoSctaSt
             */
            @Data
            CMoedIsoSctaSt cMoedIsoSctaSt() ;
            
            /**
             * @return instancia da classe local NsDepositoSt
             */
            @Data
            NsDepositoSt nsDepositoSt() ;
            
            /**
             * @return instancia da classe local NsMovimentoSt
             */
            @Data
            NsMovimentoSt nsMovimentoSt() ;
            
            
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
            
            public interface CBancContSt extends IDataStruct {
                
                @Data(size=1)
                IString cBancContS() ;
                @Data
                @Condition("0")
                ICondition cBancCont0() ;
                @Data
                @Condition("1")
                ICondition cBancCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cBancContM() ;
                
            }
            
            public interface COeEgcContSt extends IDataStruct {
                
                @Data(size=1)
                IString cOeEgcContS() ;
                @Data
                @Condition("0")
                ICondition cOeEgcCont0() ;
                @Data
                @Condition("1")
                ICondition cOeEgcCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cOeEgcContM() ;
                
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
            
            public interface VChkdContSt extends IDataStruct {
                
                @Data(size=1)
                IString vChkdContS() ;
                @Data
                @Condition("0")
                ICondition vChkdCont0() ;
                @Data
                @Condition("1")
                ICondition vChkdCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt vChkdContM() ;
                
            }
            
            public interface CTipoContSt extends IDataStruct {
                
                @Data(size=1)
                IString cTipoContS() ;
                @Data
                @Condition("0")
                ICondition cTipoCont0() ;
                @Data
                @Condition("1")
                ICondition cTipoCont1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoContM() ;
                
            }
            
            public interface CMoedIsoSctaSt extends IDataStruct {
                
                @Data(size=1)
                IString cMoedIsoSctaS() ;
                @Data
                @Condition("0")
                ICondition cMoedIsoScta0() ;
                @Data
                @Condition("1")
                ICondition cMoedIsoScta1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cMoedIsoSctaM() ;
                
            }
            
            public interface NsDepositoSt extends IDataStruct {
                
                @Data(size=1)
                IString nsDepositoS() ;
                @Data
                @Condition("0")
                ICondition nsDeposito0() ;
                @Data
                @Condition("1")
                ICondition nsDeposito1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsDepositoM() ;
                
            }
            
            public interface NsMovimentoSt extends IDataStruct {
                
                @Data(size=1)
                IString nsMovimentoS() ;
                @Data
                @Condition("0")
                ICondition nsMovimento0() ;
                @Data
                @Condition("1")
                ICondition nsMovimento1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsMovimentoM() ;
                
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
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=10)
            IString zIniCons() ;
            
            @Data(size=10)
            IString zFimCons() ;
            
            /**
             * @return instancia da classe local Linha
             */
            @Data(length=21)
            IArray<Linha> linha() ;
            
            
            public interface Linha extends IDataStruct {
                
                @Data(size=10)
                IString zMovimentoL() ;
                
                @Data(size=21)
                IString xRefMovL() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMontanteMovL() ;
                
                @Data(size=3)
                IString cMoedaMovL() ;
                
                @Data(size=3)
                IString cCarExtL() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt nsDepositoL() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimentoL() ;
                
            }
        }
    }
    
}
