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
public interface Bghw0013 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaAplDtArr
     */
    @Data
    TabelaAplDtArr tabelaAplDtArr() ;
    
    /**
     * @return instancia da classe local TbAplDtArr
     */
    @Data
    @Mask
    TbAplDtArr tbAplDtArr() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * CONTROLO DO ARRANQUE DAS APLICACOES
     * INFORMACAO ADICIONAL
     * 
     * @version 2.0
     * 
     */
    public interface TabelaAplDtArr extends IDataStruct {
        
        @Data(size=13, value="ZD-2010-01-11")
        IString filler001() ;
        
        @Data(size=13, value="DR-2009-11-01")
        IString filler002() ;
        
        @Data(size=13, value="SX-2010-04-14")
        IString filler003() ;
        
        @Data(size=13, value="NA-2009-08-15")
        IString filler004() ;
        
        @Data(size=13, value="HM-2010-07-13")
        IString filler005() ;
        
        @Data(size=13, value="HR-2010-08-04")
        IString filler006() ;
        
        @Data(size=13, value="VM-2010-09-23")
        IString filler007() ;
        
        @Data(size=13, value="VF-2010-09-23")
        IString filler008() ;
        
        @Data(size=13, value="HB-2009-01-01")
        IString filler009() ;
        
        @Data(size=13, value="PU-2010-12-01")
        IString filler010() ;
        
    }
    public interface TbAplDtArr extends IDataMask {
        
        /**
         * @return instancia da classe local ItemApl
         */
        @Data(length=10)
        IArray<ItemApl> itemApl() ;
        
        
        public interface ItemApl extends IDataMask {
            
            
            @Data(size=2)
            IString tabAAplic() ;
            
            @Data(size=10, lpadding=1)
            IString tabZArranq() ;
            
        }
    }
    
}
