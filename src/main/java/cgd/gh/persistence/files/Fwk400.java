package cgd.gh.persistence.files;

import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.MathHandling.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fwk400 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk40002
     */
    @Data
    public abstract RegFwk40002 regFwk400() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk40002 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk400FicheiroFgh870
         */
        @Data
        Fwk400FicheiroFgh870 fwk400FicheiroFgh870() ;
        
        /**
         * @return instancia da classe local Fwk400Pedido
         */
        @Data
        Fwk400Pedido fwk400Pedido() ;
        
        
        public interface Fwk400FicheiroFgh870 extends IDataStruct {
            
            @Data(size=3)
            IString fwk400CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk400CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk400COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk400NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk400VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk400CTipoCont() ;
            
            @Data(size=3)
            IString fwk400CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk400NsDeposito() ;
            
            @Data(size=26)
            IString fwk400TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk400NsMovimento() ;
            
            @Data(size=10)
            IString fwk400ZMovimento() ;
            
            @Data(size=21)
            IString fwk400DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk400MMovimento() ;
            
            @Data(size=1)
            IString fwk400SinalMov() ;
            
            @Data(size=1)
            IString fwk400IDbcr() ;
            
            @Data(size=1)
            IString fwk400IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk400MSldoCblo() ;
            
            @Data(size=1)
            IString fwk400SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk400MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk400SinalDpnl() ;
            
            @Data(size=10)
            IString fwk400ZValor() ;
            
            @Data(size=10)
            ILong fwk400NDocOpps() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk400MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk400SinalMovOrg() ;
            
            @Data(size=3)
            IString fwk400CMoedIsoOrg() ;
            
            @Data(size=2)
            IString fwk400AApl() ;
            
        }
        
        public interface Fwk400Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk400CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk400ZInicMov() ;
            
            @Data(size=10)
            IString fwk400ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk400TsPedido() ;
            
        }
    }
}
