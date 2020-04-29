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
public abstract class Fwk581 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk59002
     */
    @Data
    public abstract RegFwk59002 regFwk590() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk59002 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk590FicheiroFgh871
         */
        @Data
        Fwk590FicheiroFgh871 fwk590FicheiroFgh871() ;
        
        /**
         * @return instancia da classe local Fwk590Pedido
         */
        @Data
        Fwk590Pedido fwk590Pedido() ;
        
        /**
         * @return instancia da classe local Fwk590Destino
         */
        @Data
        Fwk590Destino fwk590Destino() ;
        
        
        public interface Fwk590FicheiroFgh871 extends IDataStruct {
            
            @Data(size=3)
            IString fwk590CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk590CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk590COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk590NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk590VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk590CTipoCont() ;
            
            @Data(size=3)
            IString fwk590CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk590NsDeposito() ;
            
            @Data(size=26)
            IString fwk590TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk590NsMovimento() ;
            
            @Data(size=10)
            IString fwk590ZMovimento() ;
            
            @Data(size=21)
            IString fwk590DDesc() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk590MMovimento() ;
            
            @Data(size=1)
            IString fwk590SinalMov() ;
            
            @Data(size=1)
            IString fwk590IDbcr() ;
            
            @Data(size=1)
            IString fwk590IEstorno() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk590MSldoCblo() ;
            
            @Data(size=1)
            IString fwk590SinalSld() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk590MSldoDpnl() ;
            
            @Data(size=1)
            IString fwk590SinalDpnl() ;
            
            @Data(size=10)
            IString fwk590ZValor() ;
            
            @Data(size=10)
            ILong fwk590NDocOpps() ;
            
            @Data(size=3)
            IString fwk590CMoedIsoOrg() ;
            
            @Data(size=17, decimal=2)
            IDecimal fwk590MMovMoeOrig() ;
            
            @Data(size=1)
            IString fwk590SinalMovOrg() ;
            
            @Data(size=2)
            IString fwk590AApl() ;
            
            @Data(size=4)
            IString fwk590CTipoCanlAces() ;
            
            @Data(size=4)
            IString fwk590CTerminal() ;
            
            @Data(size=4)
            IInt fwk590COeEgcOpex() ;
            
            @Data(size=8)
            IString fwk590COperador() ;
            
        }
        
        public interface Fwk590Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk590CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk590ZInicMov() ;
            
            @Data(size=10)
            IString fwk590ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk590TsPedido() ;
            
        }
        
        public interface Fwk590Destino extends IDataStruct {
            
            @Data(size=3)
            IString fwk590CPaisIsoaDest() ;
            
            @Data(size=3)
            IString fwk590CMnemEgcDest() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk590COeEgcDest() ;
            
        }
    }
}
