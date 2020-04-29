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
public abstract class Fwk503 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Rwk50301
     */
    @Data
    public abstract Rwk50301 rwk50301() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Rwk50301 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk503Subconta
         */
        @Data
        Fwk503Subconta fwk503Subconta() ;
        
        @Data(size=15)
        ILong fwk503NsMovimento() ;
        
        @Data(size=10)
        IString fwk503ZMovimento() ;
        
        @Data(size=10)
        IString fwk503ZValor() ;
        
        @Data(size=21)
        IString fwk503XRefMov() ;
        
        @Data(size=3)
        IString fwk503CMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MMovMoeOrigMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MMovimento() ;
        
        @Data(size=1)
        IString fwk503IEstorno() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MSldoCblo() ;
        
        @Data(size=1)
        IString fwk503ISinalSldoCblo() ;
        
        @Data(size=17, decimal=2)
        IDecimal fwk503MSldoDpnl() ;
        
        @Data(size=1)
        IString fwk503ISinalSldoDpnl() ;
        
        @Data(size=4)
        IString fwk503CTipoCanlAces() ;
        
        @Data(size=3)
        IString fwk503CMnemEgcOpex() ;
        
        @Data(size=3)
        IString fwk503CPaisIsoaOeOpx() ;
        
        @Data(size=4)
        IInt fwk503COeEgcOpex() ;
        
        @Data(size=2)
        IString fwk503AAplicacao() ;
        
        @Data(size=3)
        IString fwk503COpczMenu() ;
        
        @Data(size=10)
        ILong fwk503NCheque() ;
        
        @Data(size=4)
        IString fwk503CEvenOpel() ;
        
        @Data(size=1)
        IString fwk503IDbcr() ;
        
        /**
         * @return instancia da classe local Fwk503Pedido
         */
        @Data
        Fwk503Pedido fwk503Pedido() ;
        
        
        public interface Fwk503Subconta extends IDataStruct {
            
            @Data(size=3)
            IString fwk503CPaisIsoaCont() ;
            
            @Data(size=4)
            IInt fwk503CBancCont() ;
            
            @Data(size=4)
            IInt fwk503COeEgcCont() ;
            
            @Data(size=7)
            IInt fwk503NsRdclCont() ;
            
            @Data(size=1)
            IInt fwk503VChkdCont() ;
            
            @Data(size=3)
            IInt fwk503CTipoCont() ;
            
            @Data(size=3)
            IString fwk503CMoedIsoScta() ;
            
            @Data(size=4)
            IInt fwk503NsDeposito() ;
            
        }
        
        public interface Fwk503Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk503CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk503ZInicMov() ;
            
            @Data(size=10)
            IString fwk503ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk503TsPedido() ;
            
        }
    }
}
