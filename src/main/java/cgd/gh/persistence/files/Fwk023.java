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
public abstract class Fwk023 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk023Pghq026a
     */
    @Data
    public abstract RegFwk023Pghq026a regFwk023Pghq026a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    public interface RegFwk023Pghq026a extends IDataStruct {
        
        @Data(size=3)
        IString fwk023CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk023CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk023COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk023NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk023VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk023CTipoCont() ;
        
        @Data(size=3)
        IString fwk023CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk023NsDeposito() ;
        
        @Data(size=7)
        IString fwk023CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk023ZInicMov() ;
        
        @Data(size=10)
        IString fwk023ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk023TsPedido() ;
        
        @Data(size=10)
        IString fwk023ZPedido() ;
        
        @Data(size=1)
        IString fwk023CEstPedHist() ;
        
        @Data(size=1)
        IString fwk023CTipoRpte() ;
        
        @Data(size=20)
        IString fwk023NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk023AAplDest() ;
        
        @Data(size=1)
        IString fwk023CFrmtInf() ;
        
        @Data(size=2)
        IString fwk023CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk023CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk023ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk023QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk023MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk023MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk023CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk023CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk023XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk023ZEliminacao() ;
        
        @Data(size=8)
        IString fwk023CUsidCrix() ;
        
        @Data(size=3)
        IString fwk023CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk023CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk023COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk023QDdbtPed() ;
        
        @Data(size=26)
        IString fwk023TsActzUlt() ;
        
        @Data(size=8)
        IString fwk023CUsidActzUlt() ;
        
    }
}
