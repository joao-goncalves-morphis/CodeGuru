package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Saida extends DataFileHandler {
    
    @Data
    public abstract Reg reg() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface Reg extends IDataStruct {
        
        @Data(size=4)
        IString trans() ;
        
        @Data(size=8)
        IString progName() ;
        
        @Data(size=2)
        IString envVersion() ;
        
        @Data(size=10)
        IString zProcessamento() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=4, signed=true)
        IInt cOeEgcOpex() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=9, signed=true)
        ILong nJourBbn() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
        @Data(size=5)
        IString cOpePcnp() ;
        
        @Data(size=15)
        IString xChavOpePcnp() ;
        
        @Data(size=8500)
        IString msgInp() ;
        
        @Data(size=8500)
        IString msgOut() ;
        
        @Data(size=1)
        IString toTest() ;
        
    }
}
