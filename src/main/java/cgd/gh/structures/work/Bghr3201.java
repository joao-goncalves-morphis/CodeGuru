package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr3201 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHR3201-FICHEIRO FGH320 - MOVIMENTOS DE CREDITO DE VENCIMENTO
     * DO ULTIMO ANO
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
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
        
        @Data(size=10)
        IString zMovLocl() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mCmrgLim() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Data(size=10)
        IString zExtracao() ;
        
        @Data(size=33)
        IString filler() ;
        
    }
    
}
