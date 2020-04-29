package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr0551 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPYBOOK : BGHR0551
     * DATA   !    AUTOR    ! DESCRICAO :
     * 17-12-2018 !   E003828   ! Informação sobre o TPA a pesquisar
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=10)
        IString cTermSibs() ;
        
        @Data(size=4)
        IInt ano() ;
        
    }
    
}
