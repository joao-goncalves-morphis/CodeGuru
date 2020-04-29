package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtr0112 extends IDataStruct {
    
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
     * BHTR0112- REGISTO DO FICHEIRO FHT011: DADOS DEFAULT PARA
     * PROCESSAMENTO BATCH ESPECIFICOS POR EMPRESA
     * 
     * @version 2.0
     * 
     */
    public interface Fht011Registo extends IDataStruct {
        
        @Data(size=3)
        IString fht011CPaisIsoAlfn() ;
        
        @Data(size=3)
        IString fht011CIdioIso() ;
        
        @Data(size=3)
        IString fht011CPaisContxt() ;
        
        @Data(size=3)
        IString fht011CMnemContxt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fht011CBancContxt() ;
        
        @Data(size=3)
        IString fht011CIdioContxt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fht011COeDci() ;
        
        @Data(size=3)
        IString fht011CPaisIsoaCpd() ;
        
        @Data(size=3)
        IString fht011CMnemEmpCpd() ;
        
        @Data(size=4, signed=true, rpadding=7, compression=COMP3)
        IInt fht011COeCpd() ;
        
    }
    
}
