package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw0004 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaInfAdi
     */
    @Data
    TabelaInfAdi tabelaInfAdi() ;
    
    /**
     * @return instancia da classe local TbInfAdi
     */
    @Data
    @Mask
    TbInfAdi tbInfAdi() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * REFERENCIA QUE IMPLICA A ACTIVACAO DE I-EXIS-INF-ADI
     * PARA 'S'
     * 
     * @version 2.0
     * 
     */
    public interface TabelaInfAdi extends IDataStruct {
        
        @Data(size=11, value="0050       ")
        IString filler001() ;
        
        @Data(size=11, value="0051       ")
        IString filler002() ;
        
        @Data(size=11, value="0024       ")
        IString filler003() ;
        
        @Data(size=11, value="0025       ")
        IString filler004() ;
        
        @Data(size=11, value="HVD1       ")
        IString filler005() ;
        
        @Data(size=11, value="HVD2       ")
        IString filler006() ;
        
    }
    public interface TbInfAdi extends IDataMask {
        
        /**
         * @return instancia da classe local ItemAdi
         */
        @Data(length=6)
        IArray<ItemAdi> itemAdi() ;
        
        
        public interface ItemAdi extends IDataMask {
            
            
            @Data(size=11)
            IString tabRefAdi() ;
            
        }
    }
    
}
