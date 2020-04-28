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
public abstract class Fwk024 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk024Pghq027a
     */
    @Data
    public abstract RegFwk024Pghq027a regFwk024Pghq027a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    public interface RegFwk024Pghq027a extends IDataStruct {
        
        @Data(size=3)
        IString fwk024CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk024CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk024COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk024NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk024VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk024CTipoCont() ;
        
        @Data(size=3)
        IString fwk024CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk024NsDeposito() ;
        
        @Data(size=7)
        IString fwk024CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk024ZInicMov() ;
        
        @Data(size=10)
        IString fwk024ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk024TsPedido() ;
        
        @Data(size=10)
        IString fwk024ZPedido() ;
        
        @Data(size=1)
        IString fwk024CEstPedHist() ;
        
        @Data(size=1)
        IString fwk024CTipoRpte() ;
        
        @Data(size=20)
        IString fwk024NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk024AAplDest() ;
        
        @Data(size=1)
        IString fwk024CFrmtInf() ;
        
        @Data(size=2)
        IString fwk024CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk024CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk024ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk024QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk024MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk024MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk024CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk024CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk024XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk024ZEliminacao() ;
        
        @Data(size=8)
        IString fwk024CUsidCrix() ;
        
        @Data(size=3)
        IString fwk024CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk024CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk024COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk024QDdbtPed() ;
        
        @Data(size=26)
        IString fwk024TsActzUlt() ;
        
        @Data(size=8)
        IString fwk024CUsidActzUlt() ;
        
    }
}
