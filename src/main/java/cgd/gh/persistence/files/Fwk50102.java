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
public abstract class Fwk50102 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk500
     */
    @Data
    public abstract RegFwk500 regFwk500() ;
    
    @Data(size=291)
    public IString regFwk501291 ;
    /**
     * Global
     */
    public interface RegFwk500 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk500FicheiroFgh871
         */
        @Data
        Fwk500FicheiroFgh871 fwk500FicheiroFgh871() ;
        
        /**
         * @return instancia da classe local Fwk500Pedido
         */
        @Data
        Fwk500Pedido fwk500Pedido() ;
        
        
        public interface Fwk500FicheiroFgh871 extends IDataStruct {
            
            @Data(size=3)
            IString fwk500CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk500CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk500COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk500NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk500VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk500CTipoCont() ;
            
            @Data(size=3)
            IString fwk500CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk500NsDeposito() ;
            
            @Data(size=26)
            IString fwk500TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk500NsMovimento() ;
            
            @Data(size=10)
            IString fwk500ZMovimento() ;
            
            @Data(size=21)
            IString fwk500DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk500MMovimento() ;
            
            @Data(size=1)
            IString fwk500SinalMov() ;
            
            @Data(size=1)
            IString fwk500IDbcr() ;
            
            @Data(size=1)
            IString fwk500IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk500MSldoCblo() ;
            
            @Data(size=1)
            IString fwk500SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk500MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk500SinalDpnl() ;
            
            @Data(size=10)
            IString fwk500ZValor() ;
            
            @Data(size=10)
            ILong fwk500NDocOpps() ;
            
            @Data(size=3)
            IString fwk500CMoedIsoOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk500MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk500SinalMovOrg() ;
            
            @Data(size=2)
            IString fwk500AApl() ;
            
            @Data(size=4)
            IString fwk500CTipoCanlAces() ;
            
            @Data(size=4)
            IString fwk500CTerminal() ;
            
            @Data(size=4)
            IInt fwk500COeEgcOpex() ;
            
            @Data(size=8)
            IString fwk500COperador() ;
            
        }
        
        public interface Fwk500Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk500CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk500ZInicMov() ;
            
            @Data(size=10)
            IString fwk500ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk500TsPedido() ;
            
        }
    }
}
