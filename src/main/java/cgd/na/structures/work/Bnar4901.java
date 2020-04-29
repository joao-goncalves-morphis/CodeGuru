package cgd.na.structures.work;

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
public interface Bnar4901 extends IDataStruct {
    
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
     * COPYBOOK : BNAR4901
     * INTERFACE PARA GH
     * TAMANHO DO FICHEIRO: 200 BYTES
     * ACTUALIZACOES AO COPYBOOK:
     * DATA   /       AUTOR       / DESCRICAO :
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        /**
         * @return instancia da classe local ChaveOperacao
         */
        @Data
        ChaveOperacao chaveOperacao() ;
        
        @Data(size=1)
        IString cSitOpcr() ;
        
        @Data(size=10)
        IString zInicVlde() ;
        
        @Data(size=10)
        IString zAbertura() ;
        
        @Data(size=10)
        IString zCancelamento() ;
        
        @Data(size=10)
        IString zSitOpcr() ;
        
        /**
         * @return instancia da classe local ContaDoDeb
         */
        @Data
        ContaDoDeb contaDoDeb() ;
        
        /**
         * @return instancia da classe local ContaDoCred
         */
        @Data
        ContaDoCred contaDoCred() ;
        
        @Data(size=99)
        IString filler() ;
        
        
        public interface ChaveOperacao extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaOpcr() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancOpcr() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpcr() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclOpcr() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdOpcr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContOpcr() ;
            
        }
        
        public interface ContaDoDeb extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsaCtaDeb() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContDeb() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContDeb() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContDeb() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContDeb() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContDeb() ;
            
            @Data(size=3)
            IString cMoeIsoSctaDeb() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepSctaDeb() ;
            
        }
        
        public interface ContaDoCred extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsaCtaCre() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContCred() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContCred() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContCred() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContCred() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContCred() ;
            
            @Data(size=3)
            IString cMoeIsoSctaCre() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepSctaCred() ;
            
        }
    }
    
}
