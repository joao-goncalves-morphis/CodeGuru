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
public interface Bghm1061 extends IDataStruct {
    
    @Data(size=4, signed=true, value="1014", compression=COMP)
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
    
    @Data(size=4, signed=true, value="1014", compression=COMP)
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
            
            @Data(size=2)
            IString aAplOrig() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=4)
            IString cTrnzIput() ;
            
            /**
             * @return instancia da classe local XInfOrdnLn01
             */
            @Data
            XInfOrdnLn01 xInfOrdnLn01() ;
            
            @Data(size=3)
            IString cMoedIsoOrig() ;
            
            @Data(size=35)
            IString xNomeOrdn() ;
            
            /**
             * DADOS DO BENEFICIARIO
             */
            @Data(size=25)
            IString xInfBeneLn01() ;
            
            @Data(size=35)
            IString xNomeBene() ;
            
            /**
             * 10 BGHM1061-X-MORADA-BENE         PIC X(35).
             */
            @Data(size=40)
            IString xMoradaBene() ;
            
            @Data(size=10)
            IString xCodPostalBene() ;
            
            /**
             * 10 BGHM1061-X-CIDADE-BENE         PIC X(25).
             */
            @Data(size=40)
            IString xCidadeBene() ;
            
            @Data(size=3)
            IString xPaisBene() ;
            
            /**
             * DADOS DO BANCO DO BENEFICIARIO
             */
            @Data(size=11)
            IString cEndSwf() ;
            
            @Data(size=35)
            IString xNomeBcoBene() ;
            
            @Data(size=35)
            IString xMoradaBcoBene() ;
            
            @Data(size=10)
            IString xCodPostalBcoBene() ;
            
            @Data(size=25)
            IString xCidadeBcoBene() ;
            
            @Data(size=3)
            IString xPaisBcoBene() ;
            
            @Data(size=2)
            IString cTipoClrg() ;
            
            @Data(size=23)
            IString cClearing() ;
            
            /**
             * DADOS DA TRANSFERENCIA
             */
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwif() ;
            
            @Data(size=3)
            IString cMoedIsoOrigT() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwifMoeOri() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong nAtrzCamb() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambio() ;
            
            @Data(size=10)
            IString zValMsgSwif() ;
            
            @Data(size=1)
            IString iOpagUrgt() ;
            
            @Data(size=3)
            IString cTipLqzPagItrl() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoOpetBpor() ;
            
            @Data(size=3)
            IString cDtlhEncgSwif() ;
            
            @Data(size=35)
            IString xDetPag1() ;
            
            @Data(size=35)
            IString xDetPag2() ;
            
            @Data(size=35)
            IString xDetPag3() ;
            
            @Data(size=35)
            IString xDetPag4() ;
            
            @Data(size=35)
            IString xInfPag1() ;
            
            @Data(size=35)
            IString xInfPag2() ;
            
            @Data(size=1)
            IString iAcdoLvp() ;
            
            /**
             * @return instancia da classe local XIdContLiqzEcg
             */
            @Data
            XIdContLiqzEcg xIdContLiqzEcg() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgOrdnSwif() ;
            
            /**
             * DESPESAS BANCARIAS
             * @return instancia da classe local TabIncEncg
             */
            @Data(length=10)
            IArray<TabIncEncg> tabIncEncg() ;
            
            /**
             * RETORNO DO COMPLEMENTO
             */
            @Data(size=2, signed=true, compression=COMP3)
            IInt cMtvDvzCpltOpg() ;
            
            
            public interface XInfOrdnLn01 extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcCntOrd() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclCntOrd() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdCntOrd() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoCntOrd() ;
                
            }
            
            public interface XIdContLiqzEcg extends IDataStruct {
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcCntEcg() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclCntEcg() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdCntEcg() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoCntEcg() ;
                
            }
            
            
            /**
             * 
             * DESPESAS BANCARIAS
             * 
             * @version 2.0
             * 
             */
            public interface TabIncEncg extends IDataStruct {
                
                @Data(size=1)
                IString cTipoEncg() ;
                
                @Data(size=3)
                IString cEncargo() ;
                
                @Data(size=15, decimal=2, signed=true, compression=COMP3)
                IDecimal mEncargo() ;
                
                @Data(size=3)
                IString cMoedEncg() ;
                
                @Data(size=1)
                IString cTipoImp() ;
                
                @Data(size=3)
                IString cImposto() ;
                
                @Data(size=15, decimal=2, signed=true, compression=COMP3)
                IDecimal mImposto() ;
                
                @Data(size=3)
                IString cMoedIsoImp() ;
                
            }
        }
    }
    
}
