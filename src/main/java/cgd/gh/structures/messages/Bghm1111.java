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
public interface Bghm1111 extends IDataStruct {
    
    @Data(size=4, signed=true, value="7145", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="3")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("66")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="66")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="7145", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=4, value="105")
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
            
            @Data(size=26)
            IString tsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=1)
            IString iConsulta() ;
            @Data
            @Condition("A")
            ICondition ascendente() ;
            @Data
            @Condition("D")
            ICondition descendente() ;
            
            
            @Data(size=26)
            IString tsMovMax() ;
            
            @Data(size=1)
            IString iCritCl() ;
            @Data
            @Condition("S")
            ICondition comNmCli() ;
            @Data
            @Condition("N")
            ICondition semNmCli() ;
            
            
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
            
            
            @Data(size=10)
            IString zMovIni() ;
            
            @Data(size=10)
            IString zMovFim() ;
            
            @Data(size=3)
            IString cTitHono() ;
            
            @Data(size=35)
            IString nmCliAbvd() ;
            
            /**
             * 10 BGHM1111-GR-MOV OCCURS 67 TIMES
             * @return instancia da classe local GrMov
             */
            @Data(length=66)
            IArray<GrMov> grMov() ;
            
            @Data(size=1)
            IString iMsgCtnd() ;
            
            @Data(size=26)
            IString tsMovimentoK() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimentoK() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt qMovimentos() ;
            
            @Data(size=1)
            IString iBloco() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt qMovCnsl() ;
            
            
            public interface ICritMontante extends IDataStruct {
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMin() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMax() ;
                
            }
            
            
            /**
             * 
             * 10 BGHM1111-GR-MOV OCCURS 67 TIMES
             * 
             * @version 2.0
             * 
             */
            public interface GrMov extends IDataStruct {
                
                
                @Data(size=10)
                IString zMovimento() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimentoL() ;
                
                @Data(size=10)
                IString zValMov() ;
                
                @Data(size=21)
                IString xRefMov() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimento() ;
                
                @Data(size=1)
                IString iDbcr() ;
                
                @Data(size=1)
                IString iEstorno() ;
                
                @Data(size=3)
                IString cMoedIsoOriMov() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloApos() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoDpnlApos() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMoeOrigMov() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nDocOpps() ;
                
                @Data(size=2)
                IString aAplOrig() ;
                
                @Data(size=5, decimal=3, signed=true, compression=COMP3)
                IDecimal tJuro() ;
                
                @Data(size=1)
                IString iExisInfAdi() ;
                
                @Data(size=3)
                IString cCatgMov() ;
                
            }
        }
    }
    
}
