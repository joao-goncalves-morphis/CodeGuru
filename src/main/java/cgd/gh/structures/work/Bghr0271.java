package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr0271 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHR0271 - DEFINICAO DO FICHEIRO FHOG50
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=500)
        IString dados() ;
        
        /**
         * @return instancia da classe local Reg1
         */
        @Data
        @Mask
        Reg1 reg1() ;
        
        /**
         * @return instancia da classe local Reg2
         */
        @Data
        @Mask
        Reg2 reg2() ;
        
        
        public interface Reg1 extends IDataMask {
            
            @Data(size=2)
            IString x1CTipoRegisto() ;
            
            @Data(size=1)
            IString x1V11() ;
            
            @Data(size=2)
            IString x1CPeriodo() ;
            
            @Data(size=1)
            IString x1V12() ;
            
            @Data(size=10)
            IString x1ZPerIni() ;
            
            @Data(size=1)
            IString x1V13() ;
            
            @Data(size=10)
            IString x1ZPerFim() ;
            
            @Data(size=1)
            IString x1V14() ;
            
            @Data(size=3)
            IString x1CPaisIsoa() ;
            
            @Data(size=4)
            IInt x1CBanc() ;
            
            @Data(size=4)
            IInt x1COeEgc() ;
            
            @Data(size=1)
            IString x1V15() ;
            
            @Data(size=3)
            IString x1CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt x1CBancCont() ;
            
            @Data(size=4)
            IInt x1COeEgcCont() ;
            
            @Data(size=7)
            IInt x1NsRdclCont() ;
            
            @Data(size=1)
            IInt x1VChkdCont() ;
            
            @Data(size=3)
            IInt x1CTipoCont() ;
            
            @Data(size=1)
            IString x1V16() ;
            
            @Data(size=17, decimal=2)
            IDecimal x1MCmrgLim() ;
            
            @Data(size=1)
            IString x1V17() ;
            
            @Data(size=17, decimal=2)
            IDecimal x1MUtilizado() ;
            
            @Data(size=400)
            IString x1Filler() ;
            
        }
        
        public interface Reg2 extends IDataMask {
            
            @Data(size=2)
            IString x2CTipoRegisto() ;
            
            @Data(size=1)
            IString x2V21() ;
            
            @Data(size=2)
            IString x2CPeriodo() ;
            
            @Data(size=1)
            IString x2V22() ;
            
            @Data(size=10)
            IString x2ZPerIni() ;
            
            @Data(size=1)
            IString x2V23() ;
            
            @Data(size=10)
            IString x2ZPerFim() ;
            
            @Data(size=1)
            IString x2V24() ;
            
            @Data(size=3)
            IString x2CPaisIsoa() ;
            
            @Data(size=4)
            IInt x2CBanc() ;
            
            @Data(size=4)
            IInt x2COeEgc() ;
            
            @Data(size=1)
            IString x2V25() ;
            
            @Data(size=3)
            IString x2CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt x2CBancCont() ;
            
            @Data(size=4)
            IInt x2COeEgcCont() ;
            
            @Data(size=7)
            IInt x2NsRdclCont() ;
            
            @Data(size=1)
            IInt x2VChkdCont() ;
            
            @Data(size=3)
            IInt x2CTipoCont() ;
            
            @Data(size=1)
            IString x2V26() ;
            
            @Data(size=3)
            IInt x2NsCmrg() ;
            
            @Data(size=1)
            IString x2V27() ;
            
            @Data(size=10)
            IString x2ZAbraCmrg() ;
            
            @Data(size=1)
            IString x2V28() ;
            
            @Data(size=10)
            IString x2ZFimVldeCmrg() ;
            
            @Data(size=1)
            IString x2V29() ;
            
            @Data(size=1)
            IString x2CEstado() ;
            
            @Data(size=410)
            IString x2Filler() ;
            
        }
    }
    
}
