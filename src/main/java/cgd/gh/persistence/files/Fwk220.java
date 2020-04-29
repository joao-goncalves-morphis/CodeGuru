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
public abstract class Fwk220 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk220
     */
    @Data
    public abstract RegFwk220 regFwk220() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk220 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk220FicheiroFgh517
         */
        @Data
        Fwk220FicheiroFgh517 fwk220FicheiroFgh517() ;
        
        /**
         * @return instancia da classe local Fwk220Pedido
         */
        @Data
        Fwk220Pedido fwk220Pedido() ;
        
        
        public interface Fwk220FicheiroFgh517 extends IDataStruct {
            
            @Data(size=3)
            IString fwk220CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk220CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk220COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk220NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk220VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk220CTipoCont() ;
            
            @Data(size=3)
            IString fwk220CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk220NsDeposito() ;
            
            @Data(size=10)
            IString fwk220ZMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk220NsMovimento() ;
            
            @Data(size=10)
            IString fwk220ZValMov() ;
            
            @Data(size=1)
            IString fwk220IDbcr() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk220MMovimento() ;
            
            @Data(size=1)
            IString fwk220IEstorno() ;
            
            @Data(size=3)
            IString fwk220CMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk220MSldoCbloApos() ;
            
            @Data(size=21)
            IString fwk220XRefMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong fwk220NDocOpps() ;
            
            @Data(size=2)
            IString fwk220AAplOrig() ;
            
            @Data(size=3)
            IString fwk220CPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString fwk220CMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk220COeEgcOpex() ;
            
            @Data(size=4)
            IString fwk220CTipoCanlAces() ;
            
            @Data(size=3)
            IString fwk220COpczMenu() ;
            
            @Data(size=5)
            IString fwk220COpeBbn() ;
            
            @Data(size=4)
            IString fwk220CEvenOpel() ;
            
        }
        
        public interface Fwk220Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk220CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk220ZInicMov() ;
            
            @Data(size=10)
            IString fwk220ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk220TsPedido() ;
            
            @Data(size=16)
            IString fwk220CEndcFtpDest() ;
            
        }
    }
}
