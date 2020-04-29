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
public interface Bghr0531 extends IDataStruct {
    
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
     * COPYBOOK : BGHR0531
     * Estrutura do JCL para pesquisar no ficheiro FGH103
     * DATA   !    AUTOR    ! DESCRICAO :
     * 17-12-2018 !   E003828   ! Informação sobre o TPA a pesquisar
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=80)
        IString campoLivre() ;
        
    }
    
}
