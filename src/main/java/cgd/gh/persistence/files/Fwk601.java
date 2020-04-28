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
public abstract class Fwk601 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk600
     */
    @Data
    public abstract RegFwk600 regFwk600() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk600 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk600FicheiroFgh872
         */
        @Data
        Fwk600FicheiroFgh872 fwk600FicheiroFgh872() ;
        
        /**
         * @return instancia da classe local Fwk600Pedido
         */
        @Data
        Fwk600Pedido fwk600Pedido() ;
        
        
        public interface Fwk600FicheiroFgh872 extends IDataStruct {
            
            @Data(size=3)
            IString fwk600CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk600NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk600VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk600CTipoCont() ;
            
            @Data(size=3)
            IString fwk600CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk600NsDeposito() ;
            
            @Data(size=26)
            IString fwk600TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk600NsMovimento() ;
            
            @Data(size=10)
            IString fwk600ZMovimento() ;
            
            @Data(size=21)
            IString fwk600DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MMovimento() ;
            
            @Data(size=1)
            IString fwk600SinalMov() ;
            
            @Data(size=1)
            IString fwk600IDbcr() ;
            
            @Data(size=1)
            IString fwk600IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoCblo() ;
            
            @Data(size=1)
            IString fwk600SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk600SinalDpnl() ;
            
            @Data(size=10)
            IString fwk600ZValor() ;
            
            @Data(size=10)
            ILong fwk600NDocOpps() ;
            
            @Data(size=3)
            IString fwk600CMoedIsoOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk600SinalMovOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoRetd() ;
            
            @Data(size=1)
            IString fwk600SinalSldoRetd() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MSldoVcob() ;
            
            @Data(size=1)
            IString fwk600SinalSldoVcob() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MCmrgLim() ;
            
            @Data(size=1)
            IString fwk600SinalCmrgLim() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MCmrgUtid() ;
            
            @Data(size=1)
            IString fwk600SinalCmrgUtid() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MDcboNgcdAtrd() ;
            
            @Data(size=1)
            IString fwk600SinalDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk600MDcboNgcdUtid() ;
            
            @Data(size=1)
            IString fwk600SinalDcboNgcdUtid() ;
            
        }
        
        public interface Fwk600Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk600CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk600ZInicMov() ;
            
            @Data(size=10)
            IString fwk600ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk600TsPedido() ;
            
        }
    }
}
