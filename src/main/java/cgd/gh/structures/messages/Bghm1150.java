package cgd.gh.structures.messages;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghm1150 extends IDataStruct {
    
    @Data(size=4, signed=true, value="32", compression=COMP)
    IInt qCterCmptAlig() ;
    
    @Data(size=3, value="3")
    IInt qCampEstTrnz() ;
    
    @Data(size=3, value="0")
    IInt indice() ;
    @Data
    @Condition("0")
    ICondition paginaCheia() ;
    
    
    @Data(size=3, value="0")
    IInt indiceInverso() ;
    
    @Data(size=4, signed=true, value="32", compression=COMP)
    IInt diminuiLength() ;
    
    @Data(size=3, value="0")
    IInt lengthOccur() ;
    
    /**
     * @return instancia da classe local Msg
     */
    @Data
    Msg msg() ;
    
    /**
     * Inner Classes
     */
    public interface Msg extends IDataStruct {
        
        /**
         * @return instancia da classe local Ase
         */
        @Data
        Ase ase() ;
        
        /**
         * @return instancia da classe local Ade
         */
        @Data
        Ade ade() ;
        
        
        public interface Ase extends IDataStruct {
            
            /**
             * @return instancia da classe local CPaisIsoAlfnSt
             */
            @Data
            CPaisIsoAlfnSt cPaisIsoAlfnSt() ;
            
            /**
             * @return instancia da classe local CMnemEmpGcxSt
             */
            @Data
            CMnemEmpGcxSt cMnemEmpGcxSt() ;
            
            /**
             * @return instancia da classe local CRefMsgSwifSt
             */
            @Data
            CRefMsgSwifSt cRefMsgSwifSt() ;
            
            
            public interface CPaisIsoAlfnSt extends IDataStruct {
                
                @Data(size=1)
                IString cPaisIsoAlfnS() ;
                @Data
                @Condition("0")
                ICondition cPaisIsoAlfn0() ;
                @Data
                @Condition("1")
                ICondition cPaisIsoAlfn1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cPaisIsoAlfnM() ;
                
            }
            
            public interface CMnemEmpGcxSt extends IDataStruct {
                
                @Data(size=1)
                IString cMnemEmpGcxS() ;
                @Data
                @Condition("0")
                ICondition cMnemEmpGcx0() ;
                @Data
                @Condition("1")
                ICondition cMnemEmpGcx1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cMnemEmpGcxM() ;
                
            }
            
            public interface CRefMsgSwifSt extends IDataStruct {
                
                @Data(size=1)
                IString cRefMsgSwifS() ;
                @Data
                @Condition("0")
                ICondition cRefMsgSwif0() ;
                @Data
                @Condition("1")
                ICondition cRefMsgSwif1() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cRefMsgSwifM() ;
                
            }
        }
        
        public interface Ade extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=16)
            IString cRefMsgSwif() ;
            
            @Data(size=1)
            IString cTipoOpeCont() ;
            
        }
    }
    
}
