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
public abstract class Fwk915 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh015
     */
    @Data
    public abstract RegFgh015 regFgh015() ;
    
    /**
     * PRC19 - INI
     * *01 REG-FWK915                       PIC X(272).
     * @return instancia da classe local RegFwk915Pghq200a
     */
    @Data
    public abstract RegFwk915Pghq200a regFwk915Pghq200a() ;
    
    /**
     * @return instancia da classe local RegFwk915Pghq207a
     */
    @Data
    public abstract RegFwk915Pghq207a regFwk915Pghq207a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    
    /**
     * 
     * PRC19 - INI
     * *01 REG-FWK915                       PIC X(272).
     * 
     * @version 2.0
     * 
     */
    public interface RegFwk915Pghq200a extends IDataStruct {
        
        @Data(size=3)
        IString fwk915CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk915NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk915VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk915CTipoCont() ;
        
        @Data(size=3)
        IString fwk915CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915NsDeposito() ;
        
        @Data(size=7)
        IString fwk915CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk915ZInicMov() ;
        
        @Data(size=10)
        IString fwk915ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk915TsPedido() ;
        
        @Data(size=10)
        IString fwk915ZPedido() ;
        
        @Data(size=1)
        IString fwk915CEstPedHist() ;
        
        @Data(size=1)
        IString fwk915CTipoRpte() ;
        
        @Data(size=20)
        IString fwk915NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk915AAplDest() ;
        
        @Data(size=1)
        IString fwk915CFrmtInf() ;
        
        @Data(size=2)
        IString fwk915CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk915CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk915ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk915QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk915MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk915MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk915CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk915CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk915XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk915ZEliminacao() ;
        
        @Data(size=8)
        IString fwk915CUsidCrix() ;
        
        @Data(size=3)
        IString fwk915CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk915CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk915QDdbtPed() ;
        
        @Data(size=26)
        IString fwk915TsActzUlt() ;
        
        @Data(size=8)
        IString fwk915CUsidActzUlt() ;
        
    }
    public interface RegFwk915Pghq207a extends IDataStruct {
        
        @Data(size=3)
        IString fwk915CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk915NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk915VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk915CTipoCont() ;
        
        @Data(size=3)
        IString fwk915CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915NsDeposito() ;
        
        @Data(size=7)
        IString fwk915CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk915ZInicMov() ;
        
        @Data(size=10)
        IString fwk915ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk915TsPedido() ;
        
        @Data(size=10)
        IString fwk915ZPedido() ;
        
        @Data(size=1)
        IString fwk915CEstPedHist() ;
        
        @Data(size=1)
        IString fwk915CTipoRpte() ;
        
        @Data(size=20)
        IString fwk915NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk915AAplDest() ;
        
        @Data(size=1)
        IString fwk915CFrmtInf() ;
        
        @Data(size=2)
        IString fwk915CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk915CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk915ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk915QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk915MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk915MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk915CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk915CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk915XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk915ZEliminacao() ;
        
        @Data(size=8)
        IString fwk915CUsidCrix() ;
        
        @Data(size=3)
        IString fwk915CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk915CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk915COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk915QDdbtPed() ;
        
        @Data(size=26)
        IString fwk915TsActzUlt() ;
        
        @Data(size=8)
        IString fwk915CUsidActzUlt() ;
        
    }
    /**
     * Global
     */
    public interface RegFgh015 extends IDataStruct {
        
        @Data(size=3)
        IString fgh015CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fgh015NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fgh015VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh015CTipoCont() ;
        
        @Data(size=3)
        IString fgh015CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015NsDeposito() ;
        
        @Data(size=7)
        IString fgh015CPedInfOpps() ;
        
        @Data(size=10)
        IString fgh015ZInicMov() ;
        
        @Data(size=10)
        IString fgh015ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fgh015TsPedido() ;
        
        @Data(size=10)
        IString fgh015ZPedido() ;
        
        @Data(size=1)
        IString fgh015CEstPedHist() ;
        
        @Data(size=1)
        IString fgh015CTipoRpte() ;
        
        @Data(size=20)
        IString fgh015NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fgh015AAplDest() ;
        
        @Data(size=1)
        IString fgh015CFrmtInf() ;
        
        @Data(size=2)
        IString fgh015CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fgh015CEndcFtpDest() ;
        
        @Data(size=10)
        IString fgh015ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh015QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh015MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fgh015MParmPedHstMin() ;
        
        @Data(size=15)
        IString fgh015CParmPedHstMax() ;
        
        @Data(size=15)
        IString fgh015CParmPedHstMin() ;
        
        @Data(size=40)
        IString fgh015XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fgh015ZEliminacao() ;
        
        @Data(size=8)
        IString fgh015CUsidCrix() ;
        
        @Data(size=3)
        IString fgh015CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fgh015CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fgh015COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fgh015QDdbtPed() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong fgh015NCliPed() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fgh015NsAbraCliPed() ;
        
        @Data(size=26)
        IString fgh015TsActzUlt() ;
        
        @Data(size=8)
        IString fgh015CUsidActzUlt() ;
        
    }
}
