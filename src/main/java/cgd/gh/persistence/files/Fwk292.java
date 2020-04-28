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
public abstract class Fwk292 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk292
     */
    @Data
    public abstract RegFwk292 regFwk292() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk292 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk292FicheiroFgh500
         */
        @Data
        Fwk292FicheiroFgh500 fwk292FicheiroFgh500() ;
        
        /**
         * @return instancia da classe local Fwk292Pedido
         */
        @Data
        Fwk292Pedido fwk292Pedido() ;
        
        
        public interface Fwk292FicheiroFgh500 extends IDataStruct {
            
            @Data(size=3)
            IString fwk292CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk292CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk292COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk292NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk292VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk292CTipoCont() ;
            
            @Data(size=3)
            IString fwk292CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk292NsDeposito() ;
            
            @Data(size=26)
            IString fwk292TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk292NsMovimento() ;
            
            @Data(size=10)
            IString fwk292ZValMov() ;
            
            @Data(size=10)
            IString fwk292ZMovLocl() ;
            
            @Data(size=1)
            IString fwk292IDbcr() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk292MMovimento() ;
            
            @Data(size=1)
            IString fwk292IEstorno() ;
            
            @Data(size=3)
            IString fwk292CMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk292MSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk292MSldoDpnlApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk292MMovMoeOrigMov() ;
            
            @Data(size=21)
            IString fwk292XRefMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong fwk292NDocOpps() ;
            
            @Data(size=10, decimal=7, signed=true, compression=COMP3)
            IDecimal fwk292TJuro() ;
            
            @Data(size=2)
            IString fwk292AAplOrig() ;
            
            @Data(size=26)
            IString fwk292TsActzUlt() ;
            
            @Data(size=8)
            IString fwk292CUsidActzUlt() ;
            
        }
        
        public interface Fwk292Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk292CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk292ZInicMov() ;
            
            @Data(size=10)
            IString fwk292ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk292TsPedido() ;
            
            @Data(size=16)
            IString fwk292CEndcFtpDest() ;
            
        }
    }
}
