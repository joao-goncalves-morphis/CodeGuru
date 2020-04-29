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
public abstract class Fwk815 extends DataFileHandler {
    
    /**
     * PRC19 - INI
     * *01 REG-FWK815                       PIC X(272).
     * @return instancia da classe local RegFwk815Pghq200a
     */
    @Data
    public abstract RegFwk815Pghq200a regFwk815Pghq200a() ;
    
    /**
     * @return instancia da classe local RegFwk815Pghq206a
     */
    @Data
    public abstract RegFwk815Pghq206a regFwk815Pghq206a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    
    /**
     * 
     * PRC19 - INI
     * *01 REG-FWK815                       PIC X(272).
     * 
     * @version 2.0
     * 
     */
    public interface RegFwk815Pghq200a extends IDataStruct {
        
        @Data(size=3)
        IString fwk815CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk815NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk815VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk815CTipoCont() ;
        
        @Data(size=3)
        IString fwk815CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815NsDeposito() ;
        
        @Data(size=7)
        IString fwk815CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk815ZInicMov() ;
        
        @Data(size=10)
        IString fwk815ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk815TsPedido() ;
        
        @Data(size=10)
        IString fwk815ZPedido() ;
        
        @Data(size=1)
        IString fwk815CEstPedHist() ;
        
        @Data(size=1)
        IString fwk815CTipoRpte() ;
        
        @Data(size=20)
        IString fwk815NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk815AAplDest() ;
        
        @Data(size=1)
        IString fwk815CFrmtInf() ;
        
        @Data(size=2)
        IString fwk815CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk815CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk815ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk815QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk815MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk815MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk815CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk815CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk815XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk815ZEliminacao() ;
        
        @Data(size=8)
        IString fwk815CUsidCrix() ;
        
        @Data(size=3)
        IString fwk815CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk815CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk815QDdbtPed() ;
        
        @Data(size=26)
        IString fwk815TsActzUlt() ;
        
        @Data(size=8)
        IString fwk815CUsidActzUlt() ;
        
    }
    public interface RegFwk815Pghq206a extends IDataStruct {
        
        @Data(size=3)
        IString fwk815CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk815NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk815VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk815CTipoCont() ;
        
        @Data(size=3)
        IString fwk815CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815NsDeposito() ;
        
        @Data(size=7)
        IString fwk815CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk815ZInicMov() ;
        
        @Data(size=10)
        IString fwk815ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk815TsPedido() ;
        
        @Data(size=10)
        IString fwk815ZPedido() ;
        
        @Data(size=1)
        IString fwk815CEstPedHist() ;
        
        @Data(size=1)
        IString fwk815CTipoRpte() ;
        
        @Data(size=20)
        IString fwk815NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk815AAplDest() ;
        
        @Data(size=1)
        IString fwk815CFrmtInf() ;
        
        @Data(size=2)
        IString fwk815CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk815CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk815ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk815QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk815MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk815MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk815CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk815CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk815XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk815ZEliminacao() ;
        
        @Data(size=8)
        IString fwk815CUsidCrix() ;
        
        @Data(size=3)
        IString fwk815CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk815CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk815COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk815QDdbtPed() ;
        
        @Data(size=26)
        IString fwk815TsActzUlt() ;
        
        @Data(size=8)
        IString fwk815CUsidActzUlt() ;
        
    }
}
