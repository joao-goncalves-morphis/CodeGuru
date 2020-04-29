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
public abstract class Fwk210 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk210
     */
    @Data
    public abstract RegFwk210 regFwk210() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk210 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk210FicheiroFgh513
         */
        @Data
        Fwk210FicheiroFgh513 fwk210FicheiroFgh513() ;
        
        /**
         * @return instancia da classe local Fwk210Pedido
         */
        @Data
        Fwk210Pedido fwk210Pedido() ;
        
        
        public interface Fwk210FicheiroFgh513 extends IDataStruct {
            
            @Data(size=3)
            IString fwk210CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk210CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk210COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk210NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk210VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk210CTipoCont() ;
            
            @Data(size=3)
            IString fwk210CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk210NsDeposito() ;
            
            @Data(size=10)
            IString fwk210ZMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk210NsMovimento() ;
            
            @Data(size=10)
            IString fwk210ZValMov() ;
            
            @Data(size=1)
            IString fwk210IDbcr() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk210MMovimento() ;
            
            @Data(size=1)
            IString fwk210IEstorno() ;
            
            @Data(size=3)
            IString fwk210CMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk210MSldoCbloApos() ;
            
            @Data(size=21)
            IString fwk210XRefMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong fwk210NDocOpps() ;
            
            @Data(size=2)
            IString fwk210AAplOrig() ;
            
            @Data(size=3)
            IString fwk210CPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString fwk210CMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk210COeEgcOpex() ;
            
            @Data(size=4)
            IString fwk210CTipoCanlAces() ;
            
            @Data(size=3)
            IString fwk210COpczMenu() ;
            
            @Data(size=5)
            IString fwk210COpeBbn() ;
            
            @Data(size=4)
            IString fwk210CEvenOpel() ;
            
        }
        
        public interface Fwk210Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk210CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk210ZInicMov() ;
            
            @Data(size=10)
            IString fwk210ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk210TsPedido() ;
            
            @Data(size=16)
            IString fwk210CEndcFtpDest() ;
            
        }
    }
}
