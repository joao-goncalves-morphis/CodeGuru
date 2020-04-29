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
public interface Bghr0211 extends IDataStruct {
    
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
     * DEFINICAO DO FICHEIRO FGH021
     * (ENVIO PARA O DW)
     * UNLOAD DA TABELA TGH00201_TITEXGDEP
     * + DATA DE ENVIO
     * + N CLIENTE E NS ABRA CLI
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        /**
         * @return instancia da classe local Titexgdep
         */
        @Data
        Titexgdep titexgdep() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        @Data(size=10)
        IString zEnvio() ;
        
        
        public interface Titexgdep extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancCont() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCont() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclCont() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdCont() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoCont() ;
            
            @Data(size=3)
            IString cMoedIsoScta() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDeposito() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvt() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitc() ;
            
            @Data(size=1)
            IString iTitcExsGarDep() ;
            
            @Data(size=26)
            IString tsCriacao() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
        }
    }
    
}
