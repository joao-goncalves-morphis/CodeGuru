package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr0201 extends IDataStruct {
    
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
     * DEFINICAO DO FICHEIRO FGH020
     * (ENVIO PARA O DW)
     * UNLOAD DA TABELA TGH00200_MOVEXGDEP
     * + DATA DE ENVIO
     * + N CLIENTE E NS ABRA CLI
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        /**
         * @return instancia da classe local Movexgdep
         */
        @Data
        Movexgdep movexgdep() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        @Data(size=10)
        IString zEnvio() ;
        
        
        public interface Movexgdep extends IDataStruct {
            
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
            
            @Data(size=1)
            IString cEstExtsGarDep() ;
            
            @Data(size=3)
            IString cCrtzMovExsGar() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=10)
            IString zIniExtsGarDep() ;
            
            @Data(size=10)
            IString zFimExtsGarDep() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipItvtExsGar() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitcExtsGart() ;
            
            @Data(size=26)
            IString tsCriacao() ;
            
            @Data(size=8)
            IString cUsidCrix() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
        }
    }
    
}
