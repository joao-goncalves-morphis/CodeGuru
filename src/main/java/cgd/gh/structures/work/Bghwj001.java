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
public interface Bghwj001 extends IDataStruct {
    
    @Data(size=3, value="0")
    IInt wsCTaxaJcrx() ;
    
    @Data(size=2, value="0")
    IInt wsCTipoConta() ;
    
    @Data(size=8, value="0")
    ILong wsCProdSgop() ;
    
    /**
     * @return instancia da classe local TabelaProdSgop
     */
    @Data
    TabelaProdSgop tabelaProdSgop() ;
    
    /**
     * @return instancia da classe local TabProdSgop
     */
    @Data
    @Mask
    TabProdSgop tabProdSgop() ;
    
    /**
     * Inner Classes
     */
    public interface TabelaProdSgop extends IDataStruct {
        
        @Data(size=15, value="302-00-20010730")
        IString filler001() ;
        
        @Data(size=15, value="303-00-20010830")
        IString filler002() ;
        
        @Data(size=15, value="306-00-20010030")
        IString filler003() ;
        
        @Data(size=15, value="307-00-20010130")
        IString filler004() ;
        
        @Data(size=15, value="310-00-20010230")
        IString filler005() ;
        
        @Data(size=15, value="312-00-20010630")
        IString filler006() ;
        
        @Data(size=15, value="330-00-20020020")
        IString filler007() ;
        
        @Data(size=15, value="330-18-20020220")
        IString filler008() ;
        
        @Data(size=15, value="330-22-20020022")
        IString filler009() ;
        
        @Data(size=15, value="331-00-20020021")
        IString filler010() ;
        
        @Data(size=15, value="332-00-20020028")
        IString filler011() ;
        
        @Data(size=15, value="333-00-20020060")
        IString filler012() ;
        
        @Data(size=15, value="334-00-20020160")
        IString filler013() ;
        
        @Data(size=15, value="340-00-20030023")
        IString filler014() ;
        
        @Data(size=15, value="341-00-20030123")
        IString filler015() ;
        
        @Data(size=15, value="342-00-20030027")
        IString filler016() ;
        
        @Data(size=15, value="343-00-20030127")
        IString filler017() ;
        
        @Data(size=15, value="344-00-20030061")
        IString filler018() ;
        
        @Data(size=15, value="345-00-20030161")
        IString filler019() ;
        
        @Data(size=15, value="346-00-20030261")
        IString filler020() ;
        
        @Data(size=15, value="347-00-20030361")
        IString filler021() ;
        
        @Data(size=15, value="348-00-20030461")
        IString filler022() ;
        
        @Data(size=15, value="349-00-20030068")
        IString filler023() ;
        
        @Data(size=15, value="399-00-20011030")
        IString filler024() ;
        
    }
    public interface TabProdSgop extends IDataMask {
        
        /**
         * @return instancia da classe local ItemPrdSgp
         */
        @Data(length=24)
        IArray<ItemPrdSgp> itemPrdSgp() ;
        
        
        public interface ItemPrdSgp extends IDataMask {
            
            
            @Data(size=3)
            IInt tabCTaxaJcrx() ;
            
            @Data(size=2, lpadding=1)
            IInt tabCTipoConta() ;
            
            @Data(size=8, lpadding=1)
            ILong tabCProdSgop() ;
            
        }
    }
    
}
