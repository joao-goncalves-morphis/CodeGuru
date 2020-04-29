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
public abstract class Fwk070 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fwk070RegPghc001a
     */
    @Data
    public abstract Fwk070RegPghc001a fwk070RegPghc001a() ;
    
    /**
     * @return instancia da classe local Fwk070RegPghq009a
     */
    @Data
    public abstract Fwk070RegPghq009a fwk070RegPghq009a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface Fwk070RegPghc001a extends IDataStruct {
        
        @Data(size=3)
        IString fwk070CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk070CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk070COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk070NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk070VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk070CTipoCont() ;
        
        @Data(size=3)
        IString fwk070CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk070NsDeposito() ;
        
        @Data(size=26)
        IString fwk070TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk070NsMovimento() ;
        
        @Data(size=1)
        IString fwk070ITrnzEfcdOnln() ;
        
        @Data(size=1)
        IString fwk070IExiAtzJourBbn() ;
        
        @Data(size=1)
        IString fwk070IPenalizacao() ;
        
        @Data(size=3)
        IString fwk070CPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk070CBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk070COeEgcGerx() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong fwk070NAtrzCamb() ;
        
        @Data(size=35)
        IString fwk070XRefMovOrig() ;
        
        @Data(size=26)
        IString fwk070TsActzUlt() ;
        
        @Data(size=8)
        IString fwk070CUsidActzUlt() ;
        
        @Data(size=1)
        IString fwk070IEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk070NsMovEtnd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk070MMovCtrvEuro() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk070TCambEuro() ;
        
    }
    /**
     * BatchQ1
     */
    public interface Fwk070RegPghq009a extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk070WsChave
         */
        @Data
        Fwk070WsChave fwk070WsChave() ;
        
        @Data(size=1)
        IString fwk070ITrnzEfcdOnln() ;
        
        @Data(size=1)
        IString fwk070IExiAtzJourBbn() ;
        
        @Data(size=1)
        IString fwk070IPenalizacao() ;
        
        @Data(size=3)
        IString fwk070CPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk070CBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk070COeEgcGerx() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong fwk070NAtrzCamb() ;
        
        @Data(size=35)
        IString fwk070XRefMovOrig() ;
        
        @Data(size=26)
        IString fwk070TsActzUlt() ;
        
        @Data(size=8)
        IString fwk070CUsidActzUlt() ;
        
        @Data(size=1)
        IString fwk070IEstorno() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk070NsMovEtnd() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk070MMovCtrvEuro() ;
        
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal fwk070TCambEuro() ;
        
        
        public interface Fwk070WsChave extends IDataStruct {
            
            @Data(size=3)
            IString fwk070CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk070CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk070COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwk070NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwk070VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwk070CTipoCont() ;
            
            @Data(size=3)
            IString fwk070CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk070NsDeposito() ;
            
            @Data(size=26)
            IString fwk070TsMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwk070NsMovimento() ;
            
        }
    }
}
