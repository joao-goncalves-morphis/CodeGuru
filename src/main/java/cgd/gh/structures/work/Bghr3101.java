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
public interface Bghr3101 extends IDataStruct {
    
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
     * BGHR3101 - FICHEIRO FGH310 - MOVIMENTOS DE CONTAS DO ASSOCIADAS*
     * A CONTRATOS DE CREDITO CONTRATADOS HA MENOS DE 1 ANO*
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
        
        @Data(size=26)
        IString tsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        @Data(size=10)
        IString zValMov() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovimento() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mSldoDpnlApos() ;
        
        @Data(size=21)
        IString xRefMov() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=4)
        IString cEvenOpel() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=10)
        IString zExtracao() ;
        
        @Data(size=53)
        IString filler() ;
        
    }
    
}
