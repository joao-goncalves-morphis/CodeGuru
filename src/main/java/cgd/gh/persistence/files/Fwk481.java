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
public abstract class Fwk481 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk49002
     */
    @Data
    public abstract RegFwk49002 regFwk490() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk49002 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk490FicheiroFgh870
         */
        @Data
        Fwk490FicheiroFgh870 fwk490FicheiroFgh870() ;
        
        /**
         * @return instancia da classe local Fwk490Pedido
         */
        @Data
        Fwk490Pedido fwk490Pedido() ;
        
        /**
         * @return instancia da classe local Fwk490Destino
         */
        @Data
        Fwk490Destino fwk490Destino() ;
        
        
        public interface Fwk490FicheiroFgh870 extends IDataStruct {
            
            @Data(size=3)
            IString fwk490CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk490CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk490COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk490NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk490VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk490CTipoCont() ;
            
            @Data(size=3)
            IString fwk490CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk490NsDeposito() ;
            
            @Data(size=26)
            IString fwk490TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk490NsMovimento() ;
            
            @Data(size=10)
            IString fwk490ZMovimento() ;
            
            @Data(size=21)
            IString fwk490DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk490MMovimento() ;
            
            @Data(size=1)
            IString fwk490SinalMov() ;
            
            @Data(size=1)
            IString fwk490IDbcr() ;
            
            @Data(size=1)
            IString fwk490IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk490MSldoCblo() ;
            
            @Data(size=1)
            IString fwk490SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk490MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk490SinalDpnl() ;
            
            @Data(size=10)
            IString fwk490ZValor() ;
            
            @Data(size=10)
            ILong fwk490NDocOpps() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk490MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk490SinalMovOrg() ;
            
            @Data(size=3)
            IString fwk490CMoedIsoOrg() ;
            
            @Data(size=2)
            IString fwk490AApl() ;
            
        }
        
        public interface Fwk490Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk490CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk490ZInicMov() ;
            
            @Data(size=10)
            IString fwk490ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk490TsPedido() ;
            
        }
        
        public interface Fwk490Destino extends IDataStruct {
            
            @Data(size=3)
            IString fwk490CPaisIsoaDest() ;
            
            @Data(size=3)
            IString fwk490CMnemEgcDest() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk490COeEgcDest() ;
            
        }
    }
}
