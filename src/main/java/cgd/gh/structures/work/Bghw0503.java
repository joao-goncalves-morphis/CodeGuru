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
public interface Bghw0503 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaContDbi
     */
    @Data
    TabelaContDbi tabelaContDbi() ;
    
    /**
     * @return instancia da classe local TabContDbi
     */
    @Data
    @Mask
    TabContDbi tabContDbi() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHW0503 - CONTAS DA DBI
     * 
     * @version 2.0
     * 
     */
    public interface TabelaContDbi extends IDataStruct {
        
        @Data(size=39, value="PT 35 0698 0025984 5 030 EUR 0000 HVB56")
        IString filler001() ;
        
        @Data(size=39, value="PT 35 0698 0030170 1 030 EUR 0000 HVB56")
        IString filler002() ;
        
    }
    public interface TabContDbi extends IDataMask {
        
        /**
         * @return instancia da classe local ElemDbi
         */
        @Data(length=2)
        IArray<ElemDbi> elemDbi() ;
        
        
        public interface ElemDbi extends IDataMask {
            
            
            @Data(size=2)
            IString tabCPaisIsoaCont() ;
            
            @Data(size=2, lpadding=1)
            IInt tabCBancCont() ;
            
            @Data(size=4, lpadding=1)
            IInt tabCOeEgcCont() ;
            
            @Data(size=7, lpadding=1)
            IInt tabNsRdclCont() ;
            
            @Data(size=1, lpadding=1)
            IInt tabVChkdCont() ;
            
            @Data(size=3, lpadding=1)
            IInt tabCTipoCont() ;
            
            @Data(size=3, lpadding=1)
            IString tabCMoedIsoScta() ;
            
            @Data(size=4, lpadding=1)
            IInt tabNsDeposito() ;
            
            @Data(size=5, lpadding=1)
            IString tabCOpeBbn() ;
            
        }
    }
    
}
