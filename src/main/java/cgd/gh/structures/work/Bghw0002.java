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
public interface Bghw0002 extends IDataStruct {
    
    @Data(size=4, value=" ")
    IString wsCTipoCanlAces() ;
    
    @Data(size=4, value=" ")
    IString wsCTerminal() ;
    
    @Data(size=2, value=" ")
    IString wsAAplicacao() ;
    
    @Data(size=4, value="0")
    IInt wsBalcaoMov() ;
    
    /**
     * @return instancia da classe local TabelaBalcCanal
     */
    @Data
    TabelaBalcCanal tabelaBalcCanal() ;
    
    /**
     * @return instancia da classe local TabBalcCanal
     */
    @Data
    @Mask
    TabBalcCanal tabBalcCanal() ;
    
    /**
     * Inner Classes
     */
    public interface TabelaBalcCanal extends IDataStruct {
        
        @Data(size=9, value="0948-0003")
        IString filler001() ;
        
        @Data(size=9, value="0945-0002")
        IString filler002() ;
        
        @Data(size=9, value="0940-0001")
        IString filler003() ;
        
        @Data(size=9, value="0995-0001")
        IString filler004() ;
        
        @Data(size=9, value="0946-EBCA")
        IString filler005() ;
        
        @Data(size=9, value="9321-SIBS")
        IString filler006() ;
        
        @Data(size=9, value="9390-SIBS")
        IString filler007() ;
        
        @Data(size=9, value="9601-GTAS")
        IString filler008() ;
        
        @Data(size=9, value="9602-GTAS")
        IString filler009() ;
        
        @Data(size=9, value="9603-GTAS")
        IString filler010() ;
        
        @Data(size=9, value="9604-GTAS")
        IString filler011() ;
        
        @Data(size=9, value="9605-GTAS")
        IString filler012() ;
        
        @Data(size=9, value="9606-GTAS")
        IString filler013() ;
        
    }
    public interface TabBalcCanal extends IDataMask {
        
        /**
         * @return instancia da classe local ItemAplCnl
         */
        @Data(length=13)
        IArray<ItemAplCnl> itemAplCnl() ;
        
        
        public interface ItemAplCnl extends IDataMask {
            
            
            @Data(size=4)
            IInt tabCBalc() ;
            
            @Data(size=4, lpadding=1)
            IString tabCCanal() ;
            
        }
    }
    
}
