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
public abstract class Fwk095 extends DataFileHandler {
    
    @Data(size=272)
    public IString regFwk095272 ;
    
    /**
     * @return instancia da classe local RegFwk095Pghq505a
     */
    @Data
    public abstract RegFwk095Pghq505a regFwk095Pghq505a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ2
     */
    public interface RegFwk095Pghq505a extends IDataStruct {
        
        @Data(size=3)
        IString fwk095CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk095CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk095COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk095NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk095VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk095CTipoCont() ;
        
        @Data(size=3)
        IString fwk095CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk095NsDeposito() ;
        
        @Data(size=7)
        IString fwk095CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk095ZInicMov() ;
        
        @Data(size=10)
        IString fwk095ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk095TsPedido() ;
        
        @Data(size=10)
        IString fwk095ZPedido() ;
        
        @Data(size=1)
        IString fwk095CEstPedHist() ;
        
        @Data(size=1)
        IString fwk095CTipoRpte() ;
        
        @Data(size=20)
        IString fwk095NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk095AAplDest() ;
        
        @Data(size=1)
        IString fwk095CFrmtInf() ;
        
        @Data(size=2)
        IString fwk095CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk095CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk095ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk095QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk095MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk095MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk095CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk095CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk095XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk095ZEliminacao() ;
        
        @Data(size=8)
        IString fwk095CUsidCrix() ;
        
        @Data(size=3)
        IString fwk095CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk095CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk095COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk095QDdbtPed() ;
        
        @Data(size=26)
        IString fwk095TsActzUlt() ;
        
        @Data(size=8)
        IString fwk095CUsidActzUlt() ;
        
    }
}
