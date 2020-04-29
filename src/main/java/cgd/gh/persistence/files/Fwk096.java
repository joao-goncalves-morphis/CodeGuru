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
public abstract class Fwk096 extends DataFileHandler {
    
    @Data(size=272)
    public IString regFwk096272 ;
    
    /**
     * @return instancia da classe local RegFwk096Pghq523a
     */
    @Data
    public abstract RegFwk096Pghq523a regFwk096Pghq523a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk096Pghq523a extends IDataStruct {
        
        @Data(size=3)
        IString fwk096CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk096CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk096COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk096NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk096VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk096CTipoCont() ;
        
        @Data(size=3)
        IString fwk096CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk096NsDeposito() ;
        
        @Data(size=7)
        IString fwk096CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk096ZInicMov() ;
        
        @Data(size=10)
        IString fwk096ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk096TsPedido() ;
        
        @Data(size=10)
        IString fwk096ZPedido() ;
        
        @Data(size=1)
        IString fwk096CEstPedHist() ;
        
        @Data(size=1)
        IString fwk096CTipoRpte() ;
        
        @Data(size=20)
        IString fwk096NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk096AAplDest() ;
        
        @Data(size=1)
        IString fwk096CFrmtInf() ;
        
        @Data(size=2)
        IString fwk096CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk096CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk096ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk096QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk096MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk096MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk096CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk096CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk096XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk096ZEliminacao() ;
        
        @Data(size=8)
        IString fwk096CUsidCrix() ;
        
        @Data(size=3)
        IString fwk096CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk096CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk096COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk096QDdbtPed() ;
        
        @Data(size=26)
        IString fwk096TsActzUlt() ;
        
        @Data(size=8)
        IString fwk096CUsidActzUlt() ;
        
    }
}
