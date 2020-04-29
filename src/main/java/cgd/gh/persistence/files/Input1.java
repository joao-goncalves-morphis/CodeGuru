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
public abstract class Input1 extends DataFileHandler {
    
    @Data(size=227)
    public IString input1Reg ;
    
    @Data(size=227)
    public IString input1Reg02 ;
    
    @Data(size=227)
    public IString input1Reg227 ;
    
    /**
     * @return instancia da classe local RegInput1Pghq202a
     */
    @Data
    public abstract RegInput1Pghq202a regInput1Pghq202a() ;
    /**
     * BatchQ1
     */
    public interface RegInput1Pghq202a extends IDataStruct {
        
        @Data(size=3)
        IString input1CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt input1CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt input1COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt input1NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt input1VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt input1CTipoCont() ;
        
        @Data(size=3)
        IString input1CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt input1NsDeposito() ;
        
        @Data(size=7)
        IString input1CPedInfOpps() ;
        
        @Data(size=10)
        IString input1ZInicMov() ;
        
        @Data(size=10)
        IString input1ZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong input1TsPedido() ;
        
        @Data(size=10)
        IString input1ZPedido() ;
        
        @Data(size=1)
        IString input1CEstPedHist() ;
        
        @Data(size=1)
        IString input1CTipoRpte() ;
        
        @Data(size=20)
        IString input1NmFichOutpRtno() ;
        
        @Data(size=2)
        IString input1AAplDest() ;
        
        @Data(size=1)
        IString input1CFrmtInf() ;
        
        @Data(size=2)
        IString input1CCanlTrmzInf() ;
        
        @Data(size=15)
        IString input1CEndcFtpDest() ;
        
        @Data(size=10)
        IString input1ZCluzPed() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt input1QDiaDpnzInf() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal input1MParmPedHstMax() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal input1MParmPedHstMin() ;
        
        @Data(size=15)
        IString input1CParmPedHstMax() ;
        
        @Data(size=15)
        IString input1CParmPedHstMin() ;
        
        @Data(size=40)
        IString input1XMtvoDvlzPed() ;
        
        @Data(size=10)
        IString input1ZEliminacao() ;
        
        @Data(size=8)
        IString input1CUsidCrix() ;
        
        @Data(size=3)
        IString input1CPaisIsoaOeOpx() ;
        
        @Data(size=3)
        IString input1CMnemEgcOpex() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt input1COeEgcOpex() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt input1QDdbtPed() ;
        
        @Data(size=26)
        IString input1TsActzUlt() ;
        
        @Data(size=8)
        IString input1CUsidActzUlt() ;
        
    }
}
