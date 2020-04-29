package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw0099 extends IDataStruct {
    
    /**
     * @return instancia da classe local AreaDescritivo
     */
    @Data
    AreaDescritivo areaDescritivo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHW0998 - DESCRITIVOS VALIDOS
     * 
     * @version 2.0
     * 
     */
    public interface AreaDescritivo extends IDataStruct {
        
        @Data(length=21, size=1)
        IArray<IString> letra() ;
        @Data
        @Condition({ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "%", "-" })
        IConditions letraValida() ;
        
        
    }
    
}
