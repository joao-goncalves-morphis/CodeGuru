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
public interface Bghr1001 extends IDataStruct {
    
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
     * DEFINICAO DE FICHEIRO FGH100
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=30)
        IString cCttoEgc() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=4)
        IString timerMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal mMovimento() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=4)
        IInt oeOrigMov() ;
        
        @Data(size=1)
        IString iEstorno() ;
        
        @Data(size=1)
        IString iDbcr() ;
        
        @Data(size=10)
        IString dataValor() ;
        
        @Data(size=3)
        IString cMoedIsoOriMov() ;
        
        @Data(size=5)
        IString cOpeBbn() ;
        
        @Data(size=4)
        IString cTipoCanlAces() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
        @Data(size=3)
        IString cOpczMenu() ;
        
        @Data(size=4)
        IString evento() ;
        
    }
    
}
