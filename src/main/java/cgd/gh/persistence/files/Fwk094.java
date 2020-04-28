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
public abstract class Fwk094 extends DataFileHandler {
    
    @Data(size=272)
    public IString regFwk094272 ;
    
    /**
     * @return instancia da classe local RegFwk094Pghq524a
     */
    @Data
    public abstract RegFwk094Pghq524a regFwk094Pghq524a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk094Pghq524a extends IDataStruct {
        
        @Data(size=3)
        IString fwk094CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk094CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk094COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk094NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk094VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk094CTipoCont() ;
        
        @Data(size=3)
        IString fwk094CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk094NsDeposito() ;
        
        @Data(size=7)
        IString fwk094CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk094ZInicMov() ;
        
        @Data(size=10)
        IString fwk094ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk094TsPedido() ;
        
        @Data(size=10)
        IString fwk094ZPedido() ;
        
        @Data(size=1)
        IString fwk094CEstPedHist() ;
        
        @Data(size=1)
        IString fwk094CTipoRpte() ;
        
        @Data(size=20)
        IString fwk094NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk094AAplDest() ;
        
        @Data(size=1)
        IString fwk094CFrmtInf() ;
        
        @Data(size=2)
        IString fwk094CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk094CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk094ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk094QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk094MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk094MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk094CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk094CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk094XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk094ZEliminacao() ;
        
        @Data(size=8)
        IString fwk094CUsidCrix() ;
        
        @Data(size=3)
        IString fwk094CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk094CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk094COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk094QDdbtPed() ;
        
        @Data(size=26)
        IString fwk094TsActzUlt() ;
        
        @Data(size=8)
        IString fwk094CUsidActzUlt() ;
        
    }
}
