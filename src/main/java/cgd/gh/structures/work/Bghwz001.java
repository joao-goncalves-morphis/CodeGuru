package cgd.gh.structures.work;

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
public interface Bghwz001 extends IDataStruct {
    
    /**
     * @return instancia da classe local Rghw0101
     */
    @Data
    Rghw0101 rghw0101() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * DEFINICAO DO FICHEIRO FWKZXX
     * FICHEIRO PARA ACTUALIZACAO DA TABELA VHG01001
     * 
     * @version 2.0
     * 
     */
    public interface Rghw0101 extends IDataStruct {
        
        @Data(size=3)
        IString fwkz01CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwkz01CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwkz01COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt fwkz01NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt fwkz01VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt fwkz01CTipoCont() ;
        
        @Data(size=3)
        IString fwkz01CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt fwkz01NsDeposito() ;
        
        @Data(size=10)
        IString fwkz01ZMovimento() ;
        
    }
    
}
