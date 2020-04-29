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
public abstract class Fwk015 extends DataFileHandler {
    
    @Data(size=237)
    public IString fwk015Reg237 ;
    
    @Data(size=80)
    public IString regFwk01580 ;
    
    /**
     * @return instancia da classe local RegFwk015Pghq200a
     */
    @Data
    public abstract RegFwk015Pghq200a regFwk015Pghq200a() ;
    /**
     * BatchQ1
     */
    public interface RegFwk015Pghq200a extends IDataStruct {
        
        @Data(size=3)
        IString fwk015CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk015NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk015VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk015CTipoCont() ;
        
        @Data(size=3)
        IString fwk015CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015NsDeposito() ;
        
        @Data(size=7)
        IString fwk015CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk015ZInicMov() ;
        
        @Data(size=10)
        IString fwk015ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk015TsPedido() ;
        
        @Data(size=10)
        IString fwk015ZPedido() ;
        
        @Data(size=1)
        IString fwk015CEstPedHist() ;
        
        @Data(size=1)
        IString fwk015CTipoRpte() ;
        
        @Data(size=20)
        IString fwk015NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk015AAplDest() ;
        
        @Data(size=1)
        IString fwk015CFrmtInf() ;
        
        @Data(size=2)
        IString fwk015CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk015CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk015ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk015QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk015MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk015MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk015CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk015CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk015XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk015ZEliminacao() ;
        
        @Data(size=8)
        IString fwk015CUsidCrix() ;
        
        @Data(size=3)
        IString fwk015CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk015CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk015QDdbtPed() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fwk015NCliPed() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk015NsAbraCliPed() ;
        
        @Data(size=26)
        IString fwk015TsActzUlt() ;
        
        @Data(size=8)
        IString fwk015CUsidActzUlt() ;
        
    }
}
