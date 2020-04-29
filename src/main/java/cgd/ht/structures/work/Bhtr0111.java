package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtr0111 extends IDataStruct {
    
    /**
     * @return instancia da classe local Fht011Registo
     */
    @Data
    Fht011Registo fht011Registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTR0111- REGISTO DO FICHEIRO FHT011: DADOS DEFAULT PARA
     * PROCESSAMENTO BATCH
     * 
     * @version 2.0
     * 
     */
    public interface Fht011Registo extends IDataStruct {
        
        @Data(size=3)
        IString fht011CPaisIsoAlfn() ;
        
        @Data(size=3)
        IString fht011CIdioIso() ;
        
        @Data(size=31)
        IString fht011Filler() ;
        
    }
    
}
