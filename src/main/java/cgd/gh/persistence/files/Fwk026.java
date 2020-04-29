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
public abstract class Fwk026 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk026
     */
    @Data
    public abstract RegFwk026 regFwk026() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk026 extends IDataStruct {
        
        /**
         * @return instancia da classe local Conta
         */
        @Data
        Conta conta() ;
        
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt nsCmrg() ;
        
        @Data(size=10)
        IString zAbraCmrg() ;
        
        @Data(size=10)
        IString zFimVldeCmrg() ;
        
        @Data(size=10)
        IString zCntlSldo() ;
        
        @Data(size=3)
        IString cFamiProdCmrg() ;
        
        @Data(size=3)
        IString cProdCmrg() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLimCntl() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCmrg() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCmrgCntl() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsUtizCmrg() ;
        
        @Data(size=1)
        IString iExisCttoFisi() ;
        
        @Data(size=1)
        IString cEstCmrg() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt zdAtvzCmrg() ;
        
        @Data(size=10)
        IString zInicUtizCmrg() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal tTaeg() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal tTaegStd() ;
        
        @Data(size=6, signed=true, compression=COMP3)
        IInt cFineCred() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal tTan() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal tTanStd() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
        
        public interface Conta extends IDataStruct {
            
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
            
        }
    }
}
