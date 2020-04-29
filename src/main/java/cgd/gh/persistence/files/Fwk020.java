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
public abstract class Fwk020 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk020
     */
    @Data
    public abstract RegFwk020 regFwk020() ;
    
    @Data(size=80)
    public IString regFwk02080 ;
    
    /**
     * @return instancia da classe local RegFwk020Pghq023a
     */
    @Data
    public abstract RegFwk020Pghq023a regFwk020Pghq023a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ1
     */
    public interface RegFwk020Pghq023a extends IDataStruct {
        
        @Data(size=3)
        IString fwk020CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk020CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk020COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk020NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk020VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk020CTipoCont() ;
        
        @Data(size=3)
        IString fwk020CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk020NsDeposito() ;
        
        @Data(size=7)
        IString fwk020CPedInfOpps() ;
        
        @Data(size=10)
        IString fwk020ZInicMov() ;
        
        @Data(size=10)
        IString fwk020ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk020TsPedido() ;
        
        @Data(size=10)
        IString fwk020ZPedido() ;
        
        @Data(size=1)
        IString fwk020CEstPedHist() ;
        
        @Data(size=1)
        IString fwk020CTipoRpte() ;
        
        @Data(size=20)
        IString fwk020NmFichOutpRtno() ;
        
        @Data(size=2)
        IString fwk020AAplDest() ;
        
        @Data(size=1)
        IString fwk020CFrmtInf() ;
        
        @Data(size=2)
        IString fwk020CCanlTrmzInf() ;
        
        @Data(size=15)
        IString fwk020CEndcFtpDest() ;
        
        @Data(size=10)
        IString fwk020ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk020QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk020MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal fwk020MParmPedHstMin() ;
        
        @Data(size=15)
        IString fwk020CParmPedHstMax() ;
        
        @Data(size=15)
        IString fwk020CParmPedHstMin() ;
        
        @Data(size=40)
        IString fwk020XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString fwk020ZEliminacao() ;
        
        @Data(size=8)
        IString fwk020CUsidCrix() ;
        
        @Data(size=3)
        IString fwk020CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString fwk020CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk020COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt fwk020QDdbtPed() ;
        
        @Data(size=26)
        IString fwk020TsActzUlt() ;
        
        @Data(size=8)
        IString fwk020CUsidActzUlt() ;
        
    }
    /**
     * Global
     */
    public interface RegFwk020 extends IDataStruct {
        
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
        
        @Data(size=1)
        IString cEstExtsGarDep() ;
        
        @Data(size=3)
        IString cCrtzMovExsGar() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=10)
        IString zIniExtsGarDep() ;
        
        @Data(size=10)
        IString zFimExtsGarDep() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt iTipItvtExsGar() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsTitcExtsGart() ;
        
        @Data(size=26)
        IString tsCriacao() ;
        
        @Data(size=8)
        IString cUsidCrix() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
}
