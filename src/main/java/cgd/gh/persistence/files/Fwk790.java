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
public abstract class Fwk790 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk790
     */
    @Data
    public abstract RegFwk790 regFwk790() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk790 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk790FicheiroFgh873
         */
        @Data
        Fwk790FicheiroFgh873 fwk790FicheiroFgh873() ;
        
        /**
         * @return instancia da classe local Fwk790Pedido
         */
        @Data
        Fwk790Pedido fwk790Pedido() ;
        
        /**
         * @return instancia da classe local Fwk790Destino
         */
        @Data
        Fwk790Destino fwk790Destino() ;
        
        
        public interface Fwk790FicheiroFgh873 extends IDataStruct {
            
            @Data(size=3)
            IString fwk790CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk790CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk790COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk790NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk790VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk790CTipoCont() ;
            
            @Data(size=3)
            IString fwk790CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk790NsDeposito() ;
            
            @Data(size=26)
            IString fwk790TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk790NsMovimento() ;
            
            @Data(size=10)
            IString fwk790ZMovimento() ;
            
            @Data(size=21)
            IString fwk790DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk790MMovimento() ;
            
            @Data(size=1)
            IString fwk790SinalMov() ;
            
            @Data(size=1)
            IString fwk790IDbcr() ;
            
            @Data(size=1)
            IString fwk790IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk790MSldoCblo() ;
            
            @Data(size=1)
            IString fwk790SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk790MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk790SinalDpnl() ;
            
            @Data(size=10)
            IString fwk790ZValor() ;
            
            @Data(size=10)
            ILong fwk790NDocOpps() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk790MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk790SinalMovOrg() ;
            
            @Data(size=3)
            IString fwk790CMoedIsoOrg() ;
            
            @Data(size=9)
            IString fwk790CProduto() ;
            
            @Data(size=7)
            IInt fwk790CSectGrupo() ;
            
            @Data(size=4)
            IInt fwk790CCndzCont() ;
            
        }
        
        public interface Fwk790Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk790CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk790ZInicMov() ;
            
            @Data(size=10)
            IString fwk790ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk790TsPedido() ;
            
        }
        
        public interface Fwk790Destino extends IDataStruct {
            
            @Data(size=3)
            IString fwk790CPaisIsoaDest() ;
            
            @Data(size=3)
            IString fwk790CMnemEgcDest() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk790COeEgcDest() ;
            
        }
    }
}
