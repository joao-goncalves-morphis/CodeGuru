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
public abstract class Fwk021 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk021
     */
    @Data
    public abstract RegFwk021 regFwk021() ;
    
    /**
     * @return instancia da classe local RegFwk021Pghq024a
     */
    @Data
    public abstract RegFwk021Pghq024a regFwk021Pghq024a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    public interface RegFwk021Pghq024a extends IDataStruct {
        
        @Data(size=3)
        IString fwk021CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk021CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk021COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk021NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk021VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk021CTipoCont() ;
        
        @Data(size=3)
        IString fwk021CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk021NsDeposito() ;
        
        @Data(size=7)
        IString fwk021CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk021ZInicMov() ;
        
        @Data(size=10)
        IString fwk021ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk021TsPedido() ;
        
        @Data(size=10)
        IString fwk021ZPedido() ;
        
        @Data(size=1)
        IString fwk021CEstPedHist() ;
        
        @Data(size=1)
        IString fwk021CTipoRpte() ;
        
        @Data(size=20)
        IString fwk021NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk021AAplDest() ;
        
        @Data(size=1)
        IString fwk021CFrmtInf() ;
        
        @Data(size=2)
        IString fwk021CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk021CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk021ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk021QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk021MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk021MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk021CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk021CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk021XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk021ZEliminacao() ;
        
        @Data(size=8)
        IString fwk021CUsidCrix() ;
        
        @Data(size=3)
        IString fwk021CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk021CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk021COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk021QDdbtPed() ;
        
        @Data(size=26)
        IString fwk021TsActzUlt() ;
        
        @Data(size=8)
        IString fwk021CUsidActzUlt() ;
        
    }
    /**
     * Global
     */
    public interface RegFwk021 extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt iTipoItvt() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsTitc() ;
        
        @Data(size=1)
        IString iTitcExsGarDep() ;
        
        @Data(size=26)
        IString tsCriacao() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
}
