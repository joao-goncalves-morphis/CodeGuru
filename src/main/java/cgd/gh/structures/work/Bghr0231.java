package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr0231 extends IDataStruct {
    
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
     * DEFINICAO DO FICHEIRO FGH023
     * MIGRACAO HISTORICO DE MOVIMENTOS
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        @Data(size=4)
        IInt cBancCont() ;
        
        @Data(size=4)
        IInt cOeEgcCont() ;
        
        @Data(size=7)
        IInt nsRdclCont() ;
        
        @Data(size=1)
        IInt vChkdCont() ;
        
        @Data(size=3)
        IInt cTipoCont() ;
        
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        @Data(size=4)
        IInt nsDeposito() ;
        
        @Data(size=15)
        ILong nsMovimento() ;
        
        @Data(size=26)
        IString tsMovimento() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=10)
        IString zValMov() ;
        
        @Data(size=21)
        IString xRefMov() ;
        
        @Data(format="---------------9V99")
        IFormattedString mMovimento() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        @Data(format="---------------9V99")
        IFormattedString mSldoCbloApos() ;
        
        @Data(format="---------------9V99")
        IFormattedString mSldoDpnlApos() ;
        
        @Data(format="---------------9V99")
        IFormattedString mMovMoeOrigMov() ;
        
        @Data(size=10)
        ILong nDocOpps() ;
        
        @Data(size=2)
        IString aAplOrig() ;
        
        @Data(format="--9V999")
        IFormattedString tJuro() ;
        
        @Data(size=1)
        IString iExisInfAdi() ;
        
        @Data(format="---------------9V99")
        IFormattedString mSldoRetd() ;
        
        @Data(format="---------------9V99")
        IFormattedString mSldoVcob() ;
        
        @Data(size=3)
        IString cCategMov() ;
        
    }
    
}
