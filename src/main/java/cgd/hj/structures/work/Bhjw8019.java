package cgd.hj.structures.work;

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
public interface Bhjw8019 extends IDataStruct {
    
    /**
     * @return instancia da classe local Tabela
     */
    @Data
    Tabela tabela() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHJW8019 - Â‡REA DE LIGAÃƒÂ†O COM O COPY DE ACESSO
     * Â‚ TABELA DE NOMES
     * 
     * @version 2.0
     * 
     */
    public interface Tabela extends IDataStruct {
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsNomeCli() ;
        
        @Data(size=3)
        IString cTipoNomeCli() ;
        
        @Data(size=35)
        IString nmCliAbvd() ;
        
        @Data(size=20)
        IString anCliPrim() ;
        
        @Data(size=6)
        IString anCliSegn() ;
        
        @Data(size=22)
        IString anCliTerc() ;
        
        @Data(size=8)
        IString cUsidActzUlt() ;
        
        @Data(size=26)
        IString tsActzUlt() ;
        
    }
    
}
