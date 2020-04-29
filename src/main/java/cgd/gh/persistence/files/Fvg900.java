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
public abstract class Fvg900 extends DataFileHandler {
    
    /**
     * @return instancia da classe local RegFwk545Pghq900a
     */
    @Data
    public abstract RegFwk545Pghq900a regFwk545Pghq900a() ;
    /**
     * Inner Classes
     */
    
    /**
     * BatchQ3
     */
    public interface RegFwk545Pghq900a extends IDataStruct {
        
        /**
         * @return instancia da classe local Bhow8545Subconta
         */
        @Data
        Bhow8545Subconta bhow8545Subconta() ;
        
        @Data(size=15)
        ILong bhow8545NsMovimento() ;
        
        @Data(size=10)
        IString bhow8545ZMovimentoF() ;
        
        @Data(size=10, lpadding=61, rpadding=75)
        IString bhow8545ZMovimento() ;
        
        
        public interface Bhow8545Subconta extends IDataStruct {
            
            /**
             * @return instancia da classe local Bhow8545Conta
             */
            @Data
            Bhow8545Conta bhow8545Conta() ;
            
            @Data(size=3)
            IString bhow8545CMoedIsoScta() ;
            
            @Data(size=4)
            IInt bhow8545NsDeposito() ;
            
            
            public interface Bhow8545Conta extends IDataStruct {
                
                @Data(size=3)
                IString bhow8545CPaisIsoaCont() ;
                
                @Data(size=4)
                IInt bhow8545CBancCont() ;
                
                @Data(size=4)
                IInt bhow8545COeEgcCont() ;
                
                @Data(size=7)
                IInt bhow8545NsRdclCont() ;
                
                @Data(size=1)
                IInt bhow8545VChkdCont() ;
                
                @Data(size=3)
                IInt bhow8545CTipoCont() ;
                
            }
        }
    }
}
