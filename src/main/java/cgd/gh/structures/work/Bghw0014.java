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
public interface Bghw0014 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaAplTrnzProg
     */
    @Data
    TabelaAplTrnzProg tabelaAplTrnzProg() ;
    
    /**
     * @return instancia da classe local TbAplTrnzProg
     */
    @Data
    @Mask
    TbAplTrnzProg tbAplTrnzProg() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * TABELA DE TRANSACCOES PROGRAMAS ASSOCIADOS A
     * INFORMACAO ADICIONAL
     * 
     * @version 2.0
     * 
     */
    public interface TabelaAplTrnzProg extends IDataStruct {
        
        @Data(size=16, value="ZD-GHI8-PGHO098A")
        IString filler001() ;
        
        @Data(size=16, value="DR-GHI8-PGHO098A")
        IString filler002() ;
        
        @Data(size=16, value="SX-GHI8-PGHO098A")
        IString filler003() ;
        
        @Data(size=16, value="HM-GHI8-PGHO098A")
        IString filler004() ;
        
        @Data(size=16, value="NA-GHJ8-PGHO108A")
        IString filler005() ;
        
        @Data(size=16, value="HO-GHJ2-PGHO102A")
        IString filler006() ;
        
        @Data(size=16, value="HR-GHJ3-PGHO103A")
        IString filler007() ;
        
        @Data(size=16, value="VM-GHJ4-PGHO104A")
        IString filler008() ;
        
        @Data(size=16, value="VF-GHJ4-PGHO104A")
        IString filler009() ;
        
        @Data(size=16, value="HB-GHJ5-PGHO105A")
        IString filler010() ;
        
        @Data(size=16, value="PU-GHJ6-PGHO106A")
        IString filler011() ;
        
    }
    public interface TbAplTrnzProg extends IDataMask {
        
        /**
         * @return instancia da classe local ItemTrn
         */
        @Data(length=11)
        IArray<ItemTrn> itemTrn() ;
        
        
        public interface ItemTrn extends IDataMask {
            
            
            @Data(size=2)
            IString tabAplicacao() ;
            
            @Data(size=4, lpadding=1)
            IString tabTrnzAdic() ;
            
            @Data(size=8, lpadding=1)
            IString tabNmPrgAdic() ;
            
        }
    }
    
}
