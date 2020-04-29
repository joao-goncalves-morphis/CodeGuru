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
public abstract class Fwk290 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk290
     */
    @Data
    public abstract RegFwk290 regFwk290() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk290 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk290FicheiroFgh500
         */
        @Data
        Fwk290FicheiroFgh500 fwk290FicheiroFgh500() ;
        
        /**
         * @return instancia da classe local Fwk290Pedido
         */
        @Data
        Fwk290Pedido fwk290Pedido() ;
        
        
        public interface Fwk290FicheiroFgh500 extends IDataStruct {
            
            @Data(size=3)
            IString fwk290CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk290CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk290COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk290NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk290VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk290CTipoCont() ;
            
            @Data(size=3)
            IString fwk290CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk290NsDeposito() ;
            
            @Data(size=26)
            IString fwk290TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk290NsMovimento() ;
            
            @Data(size=10)
            IString fwk290ZValMov() ;
            
            @Data(size=10)
            IString fwk290ZMovLocl() ;
            
            @Data(size=1)
            IString fwk290IDbcr() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk290MMovimento() ;
            
            @Data(size=1)
            IString fwk290IEstorno() ;
            
            @Data(size=3)
            IString fwk290CMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk290MSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk290MSldoDpnlApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk290MMovMoeOrigMov() ;
            
            @Data(size=21)
            IString fwk290XRefMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong fwk290NDocOpps() ;
            
            @Data(size=10, decimal=7, signed=true, compression=COMP3)
            IDecimal fwk290TJuro() ;
            
            @Data(size=2)
            IString fwk290AAplOrig() ;
            
            @Data(size=26)
            IString fwk290TsActzUlt() ;
            
            @Data(size=8)
            IString fwk290CUsidActzUlt() ;
            
        }
        
        public interface Fwk290Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk290CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk290ZInicMov() ;
            
            @Data(size=10)
            IString fwk290ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk290TsPedido() ;
            
            @Data(size=16)
            IString fwk290CEndcFtpDest() ;
            
        }
    }
}
