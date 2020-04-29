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
public abstract class Fwk200 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk200
     */
    @Data
    public abstract RegFwk200 regFwk200() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk200 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk200FicheiroFgh500
         */
        @Data
        Fwk200FicheiroFgh500 fwk200FicheiroFgh500() ;
        
        /**
         * @return instancia da classe local Fwk200Pedido
         */
        @Data
        Fwk200Pedido fwk200Pedido() ;
        
        
        public interface Fwk200FicheiroFgh500 extends IDataStruct {
            
            @Data(size=3)
            IString fwk200CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk200CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk200COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk200NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk200VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk200CTipoCont() ;
            
            @Data(size=3)
            IString fwk200CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk200NsDeposito() ;
            
            @Data(size=26)
            IString fwk200TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk200NsMovimento() ;
            
            @Data(size=10)
            IString fwk200ZValMov() ;
            
            @Data(size=10)
            IString fwk200ZMovLocl() ;
            
            @Data(size=1)
            IString fwk200IDbcr() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk200MMovimento() ;
            
            @Data(size=1)
            IString fwk200IEstorno() ;
            
            @Data(size=3)
            IString fwk200CMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk200MSldoCbloApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk200MSldoDpnlApos() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwk200MMovMoeOrigMov() ;
            
            @Data(size=21)
            IString fwk200XRefMov() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong fwk200NDocOpps() ;
            
            @Data(size=10, decimal=7, signed=true, compression=COMP3)
            IDecimal fwk200TJuro() ;
            
            @Data(size=2)
            IString fwk200AAplOrig() ;
            
            @Data(size=26)
            IString fwk200TsActzUlt() ;
            
            @Data(size=8)
            IString fwk200CUsidActzUlt() ;
            
            @Data(size=4)
            IString fwk200CTerminal() ;
            
            @Data(size=4)
            IString fwk200CTipoCanlAces() ;
            
            @Data(size=3)
            IString fwk200CPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString fwk200CMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk200COeEgcOpex() ;
            
            @Data(size=16, rpadding=16)
            IString fwk200XRefAux() ;
            
        }
        
        public interface Fwk200Pedido extends IDataStruct {
            
            @Data(size=7)
            IString fwk200CPedInfOpps() ;
            
            @Data(size=10)
            IString fwk200ZInicMov() ;
            
            @Data(size=10)
            IString fwk200ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk200TsPedido() ;
            
            @Data(size=16)
            IString fwk200CEndcFtpDest() ;
            
        }
    }
}
