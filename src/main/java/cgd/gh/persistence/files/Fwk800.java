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
public abstract class Fwk800 extends DataFileHandler {
    
    @Data(size=227)
    public IString fwk800Registo227 ;
    
    /**
     * @return instancia da classe local RegFwk800Pghq500a
     */
    @Data
    public abstract RegFwk800Pghq500a regFwk800Pghq500a() ;
    /**
     * BatchQ2
     */
    public interface RegFwk800Pghq500a extends IDataStruct {
        
        @Data(size=3)
        IString fwk800CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk800CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk800COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk800NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk800VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk800CTipoCont() ;
        
        @Data(size=3)
        IString fwk800CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk800NsDeposito() ;
        
        @Data(size=7)
        IString fwk800CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk800ZInicMov() ;
        
        @Data(size=10)
        IString fwk800ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk800TsPedido() ;
        
        @Data(size=10)
        IString fwk800ZPedido() ;
        
        @Data(size=1)
        IString fwk800CEstPedHist() ;
        
        @Data(size=1)
        IString fwk800CTipoRpte() ;
        
        @Data(size=20)
        IString fwk800NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk800AAplDest() ;
        
        @Data(size=1)
        IString fwk800CFrmtInf() ;
        
        @Data(size=2)
        IString fwk800CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk800CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk800ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk800QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk800MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk800MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk800CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk800CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk800XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk800ZEliminacao() ;
        
        @Data(size=8)
        IString fwk800CUsidCrix() ;
        
        @Data(size=3)
        IString fwk800CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk800CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk800COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk800QDdbtPed() ;
        
        @Data(size=26)
        IString fwk800TsActzUlt() ;
        
        @Data(size=8)
        IString fwk800CUsidActzUlt() ;
        
    }
}
