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
public abstract class Fwk681 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk69002
     */
    @Data
    public abstract RegFwk69002 regFwk690() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk69002 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk690FicheiroFgh872
         */
        @Data
        Fwk690FicheiroFgh872 fwk690FicheiroFgh872() ;
        
        /**
         * @return instancia da classe local Fwk690Pedido
         */
        @Data
        Fwk690Pedido fwk690Pedido() ;
        
        /**
         * @return instancia da classe local Fwk690Destino
         */
        @Data
        Fwk690Destino fwk690Destino() ;
        
        
        public interface Fwk690FicheiroFgh872 extends IDataStruct {
            
            @Data(size=3)
            IString fwk690CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk690CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk690COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk690NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk690VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk690CTipoCont() ;
            
            @Data(size=3)
            IString fwk690CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk690NsDeposito() ;
            
            @Data(size=26)
            IString fwk690TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk690NsMovimento() ;
            
            @Data(size=10)
            IString fwk690ZMovimento() ;
            
            @Data(size=21)
            IString fwk690DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MMovimento() ;
            
            @Data(size=1)
            IString fwk690SinalMov() ;
            
            @Data(size=1)
            IString fwk690IDbcr() ;
            
            @Data(size=1)
            IString fwk690IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MSldoCblo() ;
            
            @Data(size=1)
            IString fwk690SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk690SinalDpnl() ;
            
            @Data(size=10)
            IString fwk690ZValor() ;
            
            @Data(size=10)
            ILong fwk690NDocOpps() ;
            
            @Data(size=3)
            IString fwk690CMoedIsoOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk690SinalMovOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MSldoRetd() ;
            
            @Data(size=1)
            IString fwk690SinalSldoRetd() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MSldoVcob() ;
            
            @Data(size=1)
            IString fwk690SinalSldoVcob() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MCmrgLim() ;
            
            @Data(size=1)
            IString fwk690SinalCmrgLim() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MCmrgUtid() ;
            
            @Data(size=1)
            IString fwk690SinalCmrgUtid() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MDcboNgcdAtrd() ;
            
            @Data(size=1)
            IString fwk690SinalDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk690MDcboNgcdUtid() ;
            
            @Data(size=1)
            IString fwk690SinalDcboNgcdUtid() ;
            
        }
        
        public interface Fwk690Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk690CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk690ZInicMov() ;
            
            @Data(size=10)
            IString fwk690ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk690TsPedido() ;
            
        }
        
        public interface Fwk690Destino extends IDataStruct {
            
            @Data(size=3)
            IString fwk690CPaisIsoaDest() ;
            
            @Data(size=3)
            IString fwk690CMnemEgcDest() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk690COeEgcDest() ;
            
        }
    }
}
