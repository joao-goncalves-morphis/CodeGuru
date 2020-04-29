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
public abstract class Fwk215 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk215Pghc201a
     */
    @Data
    public abstract RegFwk215Pghc201a regFwk215Pghc201a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFwk215Pghc201a extends IDataStruct {
        
        @Data(size=3)
        IString fwk215CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk215CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk215COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk215NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk215VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk215CTipoCont() ;
        
        @Data(size=3)
        IString fwk215CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk215NsDeposito() ;
        
        @Data(size=7)
        IString fwk215CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk215ZInicMov() ;
        
        @Data(size=10)
        IString fwk215ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk215TsPedido() ;
        
        @Data(size=10)
        IString fwk215ZPedido() ;
        
        @Data(size=1)
        IString fwk215CEstPedHist() ;
        
        @Data(size=1)
        IString fwk215CTipoRpte() ;
        
        @Data(size=20)
        IString fwk215NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk215AAplDest() ;
        
        @Data(size=1)
        IString fwk215CFrmtInf() ;
        
        @Data(size=2)
        IString fwk215CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk215CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk215ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk215QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk215MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk215MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk215CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk215CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk215XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk215ZEliminacao() ;
        
        @Data(size=8)
        IString fwk215CUsidCrix() ;
        
        @Data(size=3)
        IString fwk215CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk215CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk215COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk215QDdbtPed() ;
        
        @Data(size=26)
        IString fwk215TsActzUlt() ;
        
        @Data(size=8)
        IString fwk215CUsidActzUlt() ;
        
    }
}
