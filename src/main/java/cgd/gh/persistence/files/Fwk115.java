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
public abstract class Fwk115 extends DataFileHandler {
    
    /**
     * PRC19 - INI
     * *01 REG-FWK115                       PIC X(272).
     * @return instancia da classe local RegFwk115Pghq200a
     */
    @Data
    public abstract RegFwk115Pghq200a regFwk115Pghq200a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    
    /**
     * 
     * PRC19 - INI
     * *01 REG-FWK115                       PIC X(272).
     * 
     * @version 2.0
     * 
     */
    public interface RegFwk115Pghq200a extends IDataStruct {
        
        @Data(size=3)
        IString fwk115CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk115CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk115COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk115NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk115VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk115CTipoCont() ;
        
        @Data(size=3)
        IString fwk115CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk115NsDeposito() ;
        
        @Data(size=7)
        IString fwk115CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk115ZInicMov() ;
        
        @Data(size=10)
        IString fwk115ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk115TsPedido() ;
        
        @Data(size=10)
        IString fwk115ZPedido() ;
        
        @Data(size=1)
        IString fwk115CEstPedHist() ;
        
        @Data(size=1)
        IString fwk115CTipoRpte() ;
        
        @Data(size=20)
        IString fwk115NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk115AAplDest() ;
        
        @Data(size=1)
        IString fwk115CFrmtInf() ;
        
        @Data(size=2)
        IString fwk115CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk115CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk115ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk115QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk115MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk115MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk115CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk115CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk115XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk115ZEliminacao() ;
        
        @Data(size=8)
        IString fwk115CUsidCrix() ;
        
        @Data(size=3)
        IString fwk115CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk115CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk115COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk115QDdbtPed() ;
        
        @Data(size=26)
        IString fwk115TsActzUlt() ;
        
        @Data(size=8)
        IString fwk115CUsidActzUlt() ;
        
    }
}
