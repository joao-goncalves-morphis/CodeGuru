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
public abstract class Fwkb15 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwkb15
     */
    @Data
    public abstract RegFwkb15 regFwkb15() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwkb15 extends IDataStruct {
        
        /**
         * @return instancia da classe local DetalheFwkb15
         */
        @Data
        DetalheFwkb15 detalheFwkb15() ;
        
        @Data(size=8)
        IString fwkb15NmRecurso() ;
        
        
        public interface DetalheFwkb15 extends IDataStruct {
            
            @Data(size=3)
            IString fwkb15CPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwkb15CBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwkb15COeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt fwkb15NsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt fwkb15VChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt fwkb15CTipoCont() ;
            
            @Data(size=3)
            IString fwkb15CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwkb15NsDeposito() ;
            
            @Data(size=7)
            IString fwkb15CPedInfOpps() ;
            
            @Data(size=10)
            IString fwkb15ZInicMov() ;
            
            @Data(size=10)
            IString fwkb15ZFimMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong fwkb15TsPedido() ;
            
            @Data(size=10)
            IString fwkb15ZPedido() ;
            
            @Data(size=1)
            IString fwkb15CEstPedHist() ;
            
            @Data(size=1)
            IString fwkb15CTipoRpte() ;
            
            @Data(size=20)
            IString fwkb15NmFichOutpRtno() ;
            
            @Data(size=2)
            IString fwkb15AAplDest() ;
            
            @Data(size=1)
            IString fwkb15CFrmtInf() ;
            
            @Data(size=2)
            IString fwkb15CCanlTrmzInf() ;
            
            @Data(size=15)
            IString fwkb15CEndcFtpDest() ;
            
            @Data(size=10)
            IString fwkb15ZCluzPed() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt fwkb15QDiaDpnzInf() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwkb15MParmPedHstMax() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal fwkb15MParmPedHstMin() ;
            
            @Data(size=15)
            IString fwkb15CParmPedHstMax() ;
            
            @Data(size=15)
            IString fwkb15CParmPedHstMin() ;
            
            @Data(size=40)
            IString fwkb15XMtvoDvlzPed() ;
            
            @Data(size=10)
            IString fwkb15ZEliminacao() ;
            
            @Data(size=8)
            IString fwkb15CUsidCrix() ;
            
            @Data(size=3)
            IString fwkb15CPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString fwkb15CMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwkb15COeEgcOpex() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt fwkb15QDdbtPed() ;
            
            @Data(size=26)
            IString fwkb15TsActzUlt() ;
            
            @Data(size=8)
            IString fwkb15CUsidActzUlt() ;
            
        }
    }
}
