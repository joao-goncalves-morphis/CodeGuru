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
public abstract class Fwk211 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk211
     */
    @Data
    public abstract RegFwk211 regFwk211() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk211 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk211FicheiroFgh515
         */
        @Data
        Fwk211FicheiroFgh515 fwk211FicheiroFgh515() ;
        
        /**
         * @return instancia da classe local Fwk211Pedido
         */
        @Data
        Fwk211Pedido fwk211Pedido() ;
        
        
        public interface Fwk211FicheiroFgh515 extends IDataStruct {
            
            @Data(size=3)
            IString fwk211CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk211CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk211COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk211NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk211VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk211CTipoCont() ;
            
            @Data(size=3)
            IString fwk211CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk211NsDeposito() ;
            
            @Data(size=26)
            IString fwk211TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk211NsMovimento() ;
            
            @Data(size=10)
            IString fwk211ZValMov() ;
            
            @Data(size=10)
            IString fwk211ZMovLocl() ;
            
            @Data(size=1)
            IString fwk211IDbcr() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk211MMovimento() ;
            
            @Data(size=1)
            IString fwk211IEstorno() ;
            
            @Data(size=3)
            IString fwk211CMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk211MSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk211MSldoDpnlApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk211MMovMoeOrigMov() ;
            
            @Data(size=21)
            IString fwk211XRefMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong fwk211NDocOpps() ;
            
            @Data(size=10, decimal=7, signed=true, compression=COMP3)
            IDecimal fwk211TJuro() ;
            
            @Data(size=2)
            IString fwk211AAplOrig() ;
            
            @Data(size=26)
            IString fwk211TsActzUlt() ;
            
            @Data(size=8)
            IString fwk211CUsidActzUlt() ;
            
        }
        
        public interface Fwk211Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk211CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk211ZInicMov() ;
            
            @Data(size=10)
            IString fwk211ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk211TsPedido() ;
            
            @Data(size=16)
            IString fwk211CEndcFtpDest() ;
            
        }
    }
}
