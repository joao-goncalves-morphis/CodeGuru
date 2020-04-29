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
public interface Bghw0010 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaEndcFtp
     */
    @Data
    TabelaEndcFtp tabelaEndcFtp() ;
    
    /**
     * @return instancia da classe local TbEndcFtp
     */
    @Data
    @Mask
    TbEndcFtp tbEndcFtp() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * ENDERECOS DE FILE -TRANSFER VALIDOS PARA PEDIDOS
     * 
     * @version 2.0
     * 
     */
    public interface TabelaEndcFtp extends IDataStruct {
        
        @Data(size=11, value="DSO-GH00001")
        IString filler001() ;
        
        @Data(size=11, value="DGE-GH00001")
        IString filler002() ;
        
        @Data(size=11, value="DAI-GH00001")
        IString filler003() ;
        
        @Data(size=11, value="DCI-GH00001")
        IString filler004() ;
        
        @Data(size=11, value="DPI-GH00001")
        IString filler005() ;
        
        @Data(size=11, value="DBI-GH00001")
        IString filler006() ;
        
        @Data(size=11, value="PCE-GH00001")
        IString filler007() ;
        
        @Data(size=11, value="DES-GH00003")
        IString filler008() ;
        
        @Data(size=11, value="DES-GH00005")
        IString filler009() ;
        
    }
    public interface TbEndcFtp extends IDataMask {
        
        /**
         * @return instancia da classe local ItemFtp
         */
        @Data(length=9)
        IArray<ItemFtp> itemFtp() ;
        
        
        public interface ItemFtp extends IDataMask {
            
            
            @Data(size=3)
            IString tabEndcFtp() ;
            
            @Data(size=7, lpadding=1)
            IString tabCPed() ;
            
        }
    }
    
}
