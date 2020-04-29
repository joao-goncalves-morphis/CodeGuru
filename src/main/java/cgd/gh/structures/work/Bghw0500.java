package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw0500 extends IDataStruct {
    
    @Data(size=40)
    IString wXChavAcsInfAdi() ;
    
    /**
     * @return instancia da classe local Bghw0500WXChavAcsInfAdiMask
     */
    @Data
    @Mask
    Bghw0500WXChavAcsInfAdiMask wXChavAcsInfAdiMask() ;
    
    /**
     * Inner Classes
     */
    public interface Bghw0500WXChavAcsInfAdiMask extends IDataMask {
        
        @Data(size=14, signed=true, compression=COMP3)
        ILong wNRefCheqArqv() ;
        
        @Data(size=3)
        IString wCPaisIsaTmxChq() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wCBancTomador() ;
        
        @Data(size=4, signed=true, rpadding=23, compression=COMP3)
        IInt wCOeEgcTomxCheq() ;
        
    }
    
}
