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
public abstract class Fwk098 extends DataFileHandler {
    
    @Data(size=272)
    public IString regFwk098272 ;
    
    /**
     * @return instancia da classe local RegFwk098Pghq504a
     */
    @Data
    public abstract RegFwk098Pghq504a regFwk098Pghq504a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk098Pghq504a extends IDataStruct {
        
        @Data(size=3)
        IString fwk098CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk098CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk098COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk098NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk098VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk098CTipoCont() ;
        
        @Data(size=3)
        IString fwk098CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk098NsDeposito() ;
        
        @Data(size=7)
        IString fwk098CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk098ZInicMov() ;
        
        @Data(size=10)
        IString fwk098ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk098TsPedido() ;
        
        @Data(size=10)
        IString fwk098ZPedido() ;
        
        @Data(size=1)
        IString fwk098CEstPedHist() ;
        
        @Data(size=1)
        IString fwk098CTipoRpte() ;
        
        @Data(size=20)
        IString fwk098NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk098AAplDest() ;
        
        @Data(size=1)
        IString fwk098CFrmtInf() ;
        
        @Data(size=2)
        IString fwk098CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk098CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk098ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk098QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk098MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk098MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk098CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk098CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk098XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk098ZEliminacao() ;
        
        @Data(size=8)
        IString fwk098CUsidCrix() ;
        
        @Data(size=3)
        IString fwk098CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk098CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk098COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk098QDdbtPed() ;
        
        @Data(size=26)
        IString fwk098TsActzUlt() ;
        
        @Data(size=8)
        IString fwk098CUsidActzUlt() ;
        
    }
}
