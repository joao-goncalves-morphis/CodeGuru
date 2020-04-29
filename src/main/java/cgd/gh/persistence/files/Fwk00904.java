package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Fwk00904 extends DataFileHandler {
    
    /**
     * @return instancia da classe local Fwk009RegPghc009a
     */
    @Data
    public abstract Fwk009RegPghc009a fwk009RegPghc009a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface Fwk009RegPghc009a extends IDataStruct {
        
        @Data(size=3)
        IString fwk009CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk009CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk009COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk009NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk009VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk009CTipoCont() ;
        
        @Data(size=3)
        IString fwk009CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk009NsDeposito() ;
        
        @Data(size=26)
        IString fwk009TsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong fwk009NsMovimento() ;
        
        @Data(size=1)
        IString fwk009ITrnzEfcdOnln() ;
        
        @Data(size=1)
        IString fwk009IExiAtzJourBbn() ;
        
        @Data(size=1)
        IString fwk009IPenalizacao() ;
        
        @Data(size=3)
        IString fwk009CPaisIsoaGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk009CBancGcxGerx() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk009COeEgcGerx() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong fwk009NAtrzCamb() ;
        
        @Data(size=35)
        IString fwk009XRefMovOrig() ;
        
        @Data(size=26)
        IString fwk009TsActzUlt() ;
        
        @Data(size=8)
        IString fwk009CUsidActzUlt() ;
        
    }
}
