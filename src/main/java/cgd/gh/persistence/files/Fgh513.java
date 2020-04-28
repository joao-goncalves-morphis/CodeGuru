package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.annotations.Mask ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.MathHandling.* ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fgh513 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh513
     */
    @Data
    public abstract RegFgh513 regFgh513() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh513 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh513Registo
         */
        @Data
        Fgh513Registo fgh513Registo() ;
        
        /**
         * @return instancia da classe local Rghf5131
         */
        @Data
        @Mask
        Rghf5131 rghf5131() ;
        
        /**
         * @return instancia da classe local Rghf5132
         */
        @Data
        @Mask
        Rghf5132 rghf5132() ;
        
        /**
         * @return instancia da classe local Rghf5133
         */
        @Data
        @Mask
        Rghf5133 rghf5133() ;
        
        /**
         * @return instancia da classe local Rghf5134
         */
        @Data
        @Mask
        Rghf5134 rghf5134() ;
        
        /**
         * @return instancia da classe local Rghf5135
         */
        @Data
        @Mask
        Rghf5135 rghf5135() ;
        
        
        public interface Fgh513Registo extends IDataStruct {
            
            @Data(size=2)
            IString fgh513TipoReg() ;
            
            @Data(size=78)
            IString fgh513RegData() ;
            
        }
        
        public interface Rghf5131 extends IDataMask {
            
            @Data(size=2)
            IString fgh513TipoReg11() ;
            
            @Data(size=4)
            IInt fgh513CBancCont11() ;
            
            @Data(size=4)
            IInt fgh513COeEgcCont11() ;
            
            @Data(size=10)
            ILong fgh513NConta11() ;
            
            @Data(size=6)
            IInt fgh513ZInicPer() ;
            
            @Data(size=6)
            IInt fgh513ZFimPer() ;
            
            @Data(size=1)
            IString fgh513ISnlSldoInic() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh513MSldoCbloInic() ;
            
            @Data(size=3)
            IInt fgh513CMoedNmrScta() ;
            
            @Data(size=1)
            IInt fgh513CodTres() ;
            
            @Data(size=26)
            IString fgh513NmAbrvCli() ;
            
            @Data(size=3)
            IString fgh513Filler11() ;
            
        }
        
        public interface Rghf5132 extends IDataMask {
            
            @Data(size=2)
            IInt fgh513TipoReg22() ;
            
            @Data(size=4)
            IString fgh513Filler22() ;
            
            @Data(size=4)
            IInt fgh513COeEgcOpex() ;
            
            @Data(size=6)
            IInt fgh513ZMovimento() ;
            
            @Data(size=6)
            IInt fgh513ZValMov() ;
            
            @Data(size=2)
            IInt fgh513CodComum() ;
            
            @Data(size=3)
            IInt fgh513CodProprio() ;
            
            @Data(size=1)
            IInt fgh513IDbcr() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh513MMovimento() ;
            
            @Data(size=10)
            ILong fgh513NDocOpps() ;
            
            @Data(size=12)
            ILong fgh513XRefPrim() ;
            
            @Data(size=16)
            IString fgh513XRefSeg() ;
            
        }
        
        public interface Rghf5133 extends IDataMask {
            
            @Data(size=2)
            IInt fgh513TipoReg23() ;
            
            @Data(size=2)
            IInt fgh513NsOrdMov() ;
            
            @Data(size=38)
            IString fgh513XRefMovPrim() ;
            
            @Data(size=38)
            IString fgh513XRefMovSegn() ;
            
        }
        
        public interface Rghf5134 extends IDataMask {
            
            @Data(size=2)
            IInt fgh513TipoReg33() ;
            
            @Data(size=4)
            IInt fgh513CBancCont33() ;
            
            @Data(size=4)
            IInt fgh513COeEgcCont33() ;
            
            @Data(size=10)
            ILong fgh513NConta33() ;
            
            @Data(size=5)
            IInt fgh513QOpeDebTot() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh513MDebTot() ;
            
            @Data(size=5)
            IInt fgh513QOpeCredTot() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh513MCredTot() ;
            
            @Data(size=1)
            IString fgh513ISnlSldoFim() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh513MSldoCbloFim() ;
            
            @Data(size=3)
            IInt fgh513CMoedNmrCont() ;
            
            @Data(size=4)
            IString fgh513Filler33() ;
            
        }
        
        public interface Rghf5135 extends IDataMask {
            
            @Data(size=2)
            IInt fgh513TipoReg88() ;
            
            @Data(size=18)
            ILong fgh513CodNoves() ;
            
            @Data(size=6)
            IInt fgh513QRegTot() ;
            
            @Data(size=54)
            IString fgh513Filler88() ;
            
        }
    }
}
