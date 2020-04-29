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
public abstract class Fwk025 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk025Pghq028a
     */
    @Data
    public abstract RegFwk025Pghq028a regFwk025Pghq028a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    public interface RegFwk025Pghq028a extends IDataStruct {
        
        @Data(size=3)
        IString fwk025CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk025CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk025COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk025NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk025VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk025CTipoCont() ;
        
        @Data(size=3)
        IString fwk025CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk025NsDeposito() ;
        
        @Data(size=7)
        IString fwk025CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk025ZInicMov() ;
        
        @Data(size=10)
        IString fwk025ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk025TsPedido() ;
        
        @Data(size=10)
        IString fwk025ZPedido() ;
        
        @Data(size=1)
        IString fwk025CEstPedHist() ;
        
        @Data(size=1)
        IString fwk025CTipoRpte() ;
        
        @Data(size=20)
        IString fwk025NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk025AAplDest() ;
        
        @Data(size=1)
        IString fwk025CFrmtInf() ;
        
        @Data(size=2)
        IString fwk025CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk025CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk025ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk025QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk025MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk025MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk025CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk025CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk025XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk025ZEliminacao() ;
        
        @Data(size=8)
        IString fwk025CUsidCrix() ;
        
        @Data(size=3)
        IString fwk025CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk025CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk025COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk025QDdbtPed() ;
        
        @Data(size=26)
        IString fwk025TsActzUlt() ;
        
        @Data(size=8)
        IString fwk025CUsidActzUlt() ;
        
    }
}
