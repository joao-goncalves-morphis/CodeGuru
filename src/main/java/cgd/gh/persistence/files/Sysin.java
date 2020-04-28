package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.persistence.files.DataFileHandler ;
import static morphis.framework.commons.StringHandling.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Sysin extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFgh110Pghc109a
     */
    @Data
    public abstract RegFgh110Pghc109a regFgh110Pghc109a() ;
    
    /**
     * @return instancia da classe local RegFgh110Pghc110a
     */
    @Data
    public abstract RegFgh110Pghc110a regFgh110Pghc110a() ;
    
    /**
     * @return instancia da classe local RegFwk091Pghc091a
     */
    @Data
    public abstract RegFwk091Pghc091a regFwk091Pghc091a() ;
    
    /**
     * @return instancia da classe local RegFwk091Pghc191a
     */
    @Data
    public abstract RegFwk091Pghc191a regFwk091Pghc191a() ;
    
    /**
     * @return instancia da classe local RegFwk099Pghq099a
     */
    @Data
    public abstract RegFwk099Pghq099a regFwk099Pghq099a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchC
     */
    public interface RegFgh110Pghc109a extends IDataStruct {
        
        @Data(size=4)
        IString fgh110CTransacao1() ;
        
        @Data(size=4, lpadding=1)
        IString fgh110CTransacao2() ;
        
        @Data(size=4, lpadding=1)
        IString fgh110CTransacao3() ;
        
        @Data(size=4, lpadding=1, rpadding=61)
        IString fgh110CTransacao4() ;
        
    }
    public interface RegFgh110Pghc110a extends IDataStruct {
        
        @Data(size=4)
        IString fgh110CTransacao1() ;
        
        @Data(size=4, lpadding=1)
        IString fgh110CTransacao2() ;
        
        @Data(size=4, lpadding=1)
        IString fgh110CTransacao3() ;
        
        @Data(size=4, lpadding=1, rpadding=61)
        IString fgh110CTransacao4() ;
        
    }
    public interface RegFwk091Pghc091a extends IDataStruct {
        
        @Data(size=3)
        IString fwk091CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwk091CBancCont() ;
        
        @Data(size=4)
        IInt fwk091COeEgcCont() ;
        
        @Data(size=7)
        IInt fwk091NsRdclCont() ;
        
        @Data(size=1)
        IInt fwk091VChkdCont() ;
        
        @Data(size=3)
        IInt fwk091CTipoCont() ;
        
        @Data(size=3)
        IString fwk091CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fwk091NsDeposito() ;
        
        @Data(size=10)
        IString fwk091ZMovimento() ;
        
        @Data(size=15)
        ILong fwk091NsMovimento() ;
        
        @Data(size=15)
        ILong fwk091NsMovNovo() ;
        
        @Data(size=11)
        ILong fwk091Resto() ;
        
    }
    public interface RegFwk091Pghc191a extends IDataStruct {
        
        @Data(size=3)
        IString fwk091CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwk091CBancCont() ;
        
        @Data(size=4)
        IInt fwk091COeEgcCont() ;
        
        @Data(size=7)
        IInt fwk091NsRdclCont() ;
        
        @Data(size=1)
        IInt fwk091VChkdCont() ;
        
        @Data(size=3)
        IInt fwk091CTipoCont() ;
        
        @Data(size=3)
        IString fwk091CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fwk091NsDeposito() ;
        
        @Data(size=10)
        IString fwk091ZMovimento() ;
        
        @Data(size=15)
        ILong fwk091NsMovimento() ;
        
        @Data(size=15)
        ILong fwk091NsMovNovo() ;
        
        @Data(size=11)
        ILong fwk091Resto() ;
        
    }
    /**
     * BatchQ1
     */
    public interface RegFwk099Pghq099a extends IDataStruct {
        
        @Data(size=3)
        IString fwk099CPaisIsoaCont() ;
        
        @Data(size=4)
        IInt fwk099CBancCont() ;
        
        @Data(size=4)
        IInt fwk099COeEgcCont() ;
        
        @Data(size=7)
        IInt fwk099NsRdclCont() ;
        
        @Data(size=1)
        IInt fwk099VChkdCont() ;
        
        @Data(size=3)
        IInt fwk099CTipoCont() ;
        
        @Data(size=3)
        IString fwk099CMoedIsoScta() ;
        
        @Data(size=4)
        IInt fwk099NsDeposito() ;
        
        @Data(size=26)
        IString fwk099TsMovimento() ;
        
        @Data(size=15)
        ILong fwk099NsMovimento() ;
        
        @Data(size=10)
        IString fwk099XRefMov() ;
        
    }
}
