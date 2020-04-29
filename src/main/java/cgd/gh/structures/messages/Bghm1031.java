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
public interface Bghm1031 extends IDataStruct {
    
    @Data(size=4, signed=true, value="1292", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="1")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("06")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="6")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="1292", compression=COMP)
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
            
            @Data(size=1)
            IString iFchoCpszUrgt() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cServSibsTei() ;
            
            @Data(size=30)
            IString dServSibsTei() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cOpeSibs() ;
            
            @Data(size=30)
            IString dOpeSibs() ;
            
            @Data(size=11)
            IString cEndcSwifOrdn() ;
            
            @Data(size=34)
            IString cIbanOrdn() ;
            
            /**
             * 10 BGHM1031-NM-ORDN                 PIC  X(30).
             */
            @Data(size=35)
            IString nmOrdn() ;
            
            @Data(size=35)
            IString nmOrdnPp() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qTrfcDstn() ;
            
            @Data(size=1)
            IString iTrfcDstnExced() ;
            
            /**
             * @return instancia da classe local ChaveContOut
             */
            @Data
            ChaveContOut chaveContOut() ;
            
            /**
             * @return instancia da classe local TabDstnTrfc
             */
            @Data(length=3)
            IArray<TabDstnTrfc> tabDstnTrfc() ;
            
            
            public interface ChaveContOut extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaTrfc() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancTrfc() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt zaOrdTrfc() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nsOrdTrfc() ;
                
                @Data(size=10)
                IString zProcessamento() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nsIstzDstnTrfc() ;
                
            }
            
            public interface TabDstnTrfc extends IDataStruct {
                
                
                @Data(size=11)
                IString cEndcSwifDstn() ;
                
                @Data(size=34)
                IString cIbanDstn() ;
                
                @Data(size=3)
                IString cMoedContDstn() ;
                
                /**
                 * 15 BGHM1031-NM-DSTN              PIC  X(30).
                 */
                @Data(size=35)
                IString nmDstn() ;
                
                @Data(size=35)
                IString nmDstnPp() ;
                
                @Data(size=15, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovOrdDstn() ;
                
                @Data(size=20)
                IString xRefMovOrnSibs() ;
                
                @Data(size=4)
                IString cMtvoDvlzSepa() ;
                
                @Data(size=35)
                IString xMtvoTrnzSepa() ;
                
                @Data(size=4)
                IString cCatgMtvTrfIso() ;
                
                @Data(size=30)
                IString dCatgMtvTrfIso() ;
                
                @Data(size=140)
                IString xInfAdiSepa() ;
                
            }
        }
    }
    
}
