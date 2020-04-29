package cgd.gh.persistence.files;

import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.arrays.IArray ;
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
public abstract class Fwk051 extends DataFileHandler {
    
    @Data(size=32)
    public IString fwk051Reg32 ;
    
    /**
     * @return instancia da classe local RegFwk050
     */
    @Data
    public abstract RegFwk050 regFwk050() ;
    
    /**
     * @return instancia da classe local Rwk01501
     */
    @Data
    public abstract Rwk01501 rwk01501() ;
    /**
     * Inner Classes
     */
    
    /**
     * Global
     */
    public interface RegFwk050 extends IDataStruct {
        
        /**
         * @return instancia da classe local Fwk050Subconta
         */
        @Data
        Fwk050Subconta fwk050Subconta() ;
        
        @Data(size=10)
        IString fwk050ZIniMov() ;
        
        @Data(size=10)
        IString fwk050ZFimMov() ;
        
        @Data(size=100)
        IString fwk050ChvFicheiro() ;
        
        /**
         * @return instancia da classe local Fwk050GrFicheiro
         */
        @Data(length=3)
        IArray<Fwk050GrFicheiro> fwk050GrFicheiro() ;
        
        
        public interface Fwk050Subconta extends IDataStruct {
            
            /**
             * @return instancia da classe local Fwk050Conta
             */
            @Data
            Fwk050Conta fwk050Conta() ;
            
            @Data(size=3)
            IString fwk050CMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt fwk050NsDeposito() ;
            
            
            public interface Fwk050Conta extends IDataStruct {
                
                @Data(size=3)
                IString fwk050CPaisIsoaCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt fwk050CBancCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt fwk050COeEgcCont() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt fwk050NsRdclCont() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt fwk050VChkdCont() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt fwk050CTipoCont() ;
                
            }
        }
        
        public interface Fwk050GrFicheiro extends IDataStruct {
            
            
            @Data(size=6)
            IString fwk050NmFicheiro() ;
            
        }
    }
    
    /**
     * 
     * FWK015 - SUBCONTA COM MOVIMENTO NO DIA PARA
     * 
     * @version 2.0
     * 
     */
    public interface Rwk01501 extends IDataStruct {
        
        @Data(size=3)
        IString fwk015CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwk015NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwk015VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwk015CTipoCont() ;
        
        @Data(size=3)
        IString fwk015CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwk015NsDeposito() ;
        
        @Data(size=10)
        IString fwk015ZMovimento() ;
        
    }
}
