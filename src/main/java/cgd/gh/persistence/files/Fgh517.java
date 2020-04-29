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
public abstract class Fgh517 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh517
     */
    @Data
    public abstract RegFgh517 regFgh517() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFgh517 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fgh517Registo
         */
        @Data
        Fgh517Registo fgh517Registo() ;
        
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
        
        
        public interface Fgh517Registo extends IDataStruct {
            
            @Data(size=2)
            IString fgh517TipoReg() ;
            
            @Data(size=78)
            IString fgh517RegData() ;
            
        }
        
        public interface Rghf5131 extends IDataMask {
            
            @Data(size=2)
            IString fgh517TipoReg11() ;
            
            @Data(size=4)
            IInt fgh517CBancCont11() ;
            
            @Data(size=4)
            IInt fgh517COeEgcCont11() ;
            
            @Data(size=10)
            ILong fgh517NConta11() ;
            
            @Data(size=6)
            IInt fgh517ZInicPer() ;
            
            @Data(size=6)
            IInt fgh517ZFimPer() ;
            
            @Data(size=1)
            IString fgh517ISnlSldoInic() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh517MSldoCbloInic() ;
            
            @Data(size=3)
            IInt fgh517CMoedNmrScta() ;
            
            @Data(size=1)
            IInt fgh517CodTres() ;
            
            @Data(size=26)
            IString fgh517NmAbrvCli() ;
            
            @Data(size=3)
            IString fgh517Filler11() ;
            
        }
        
        public interface Rghf5132 extends IDataMask {
            
            @Data(size=2)
            IInt fgh517TipoReg22() ;
            
            @Data(size=4)
            IString fgh517Filler22() ;
            
            @Data(size=4)
            IInt fgh517COeEgcOpex() ;
            
            @Data(size=6)
            IInt fgh517ZMovimento() ;
            
            @Data(size=6)
            IInt fgh517ZValMov() ;
            
            @Data(size=2)
            IInt fgh517CodComum() ;
            
            @Data(size=3)
            IInt fgh517CodProprio() ;
            
            @Data(size=1)
            IInt fgh517IDbcr() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh517MMovimento() ;
            
            @Data(size=10)
            ILong fgh517NDocOpps() ;
            
            @Data(size=12)
            ILong fgh517XRefPrim() ;
            
            @Data(size=16)
            IString fgh517XRefSeg() ;
            
        }
        
        public interface Rghf5133 extends IDataMask {
            
            @Data(size=2)
            IInt fgh517TipoReg23() ;
            
            @Data(size=2)
            IInt fgh517NsOrdMov() ;
            
            @Data(size=38)
            IString fgh517XRefMovPrim() ;
            
            @Data(size=38)
            IString fgh517XRefMovSegn() ;
            
        }
        
        public interface Rghf5134 extends IDataMask {
            
            @Data(size=2)
            IInt fgh517TipoReg33() ;
            
            @Data(size=4)
            IInt fgh517CBancCont33() ;
            
            @Data(size=4)
            IInt fgh517COeEgcCont33() ;
            
            @Data(size=10)
            ILong fgh517NConta33() ;
            
            @Data(size=5)
            IInt fgh517QOpeDebTot() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh517MDebTot() ;
            
            @Data(size=5)
            IInt fgh517QOpeCredTot() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh517MCredTot() ;
            
            @Data(size=1)
            IString fgh517ISnlSldoFim() ;
            
            @Data(size=14, decimal=2)
            IDecimal fgh517MSldoCbloFim() ;
            
            @Data(size=3)
            IInt fgh517CMoedNmrCont() ;
            
            @Data(size=4)
            IString fgh517Filler33() ;
            
        }
        
        public interface Rghf5135 extends IDataMask {
            
            @Data(size=2)
            IInt fgh517TipoReg88() ;
            
            @Data(size=18)
            ILong fgh517CodNoves() ;
            
            @Data(size=6)
            IInt fgh517QRegTot() ;
            
            @Data(size=54)
            IString fgh517Filler88() ;
            
        }
    }
}
