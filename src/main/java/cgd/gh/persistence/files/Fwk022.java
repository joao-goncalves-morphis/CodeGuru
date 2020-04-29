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
public abstract class Fwk022 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk022Pghq025a
     */
    @Data
    public abstract RegFwk022Pghq025a regFwk022Pghq025a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    public interface RegFwk022Pghq025a extends IDataStruct {
        
        @Data(size=3)
        IString fwk022CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk022CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk022COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk022NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk022VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk022CTipoCont() ;
        
        @Data(size=3)
        IString fwk022CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk022NsDeposito() ;
        
        @Data(size=7)
        IString fwk022CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk022ZInicMov() ;
        
        @Data(size=10)
        IString fwk022ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk022TsPedido() ;
        
        @Data(size=10)
        IString fwk022ZPedido() ;
        
        @Data(size=1)
        IString fwk022CEstPedHist() ;
        
        @Data(size=1)
        IString fwk022CTipoRpte() ;
        
        @Data(size=20)
        IString fwk022NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk022AAplDest() ;
        
        @Data(size=1)
        IString fwk022CFrmtInf() ;
        
        @Data(size=2)
        IString fwk022CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk022CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk022ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk022QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk022MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk022MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk022CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk022CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk022XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk022ZEliminacao() ;
        
        @Data(size=8)
        IString fwk022CUsidCrix() ;
        
        @Data(size=3)
        IString fwk022CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk022CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk022COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk022QDdbtPed() ;
        
        @Data(size=26)
        IString fwk022TsActzUlt() ;
        
        @Data(size=8)
        IString fwk022CUsidActzUlt() ;
        
    }
}
