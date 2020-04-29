package cgd.gn.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bgnl105a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MGNJ105A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local Erros
         */
        @Data
        Erros erros() ;
        
        /**
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=1)
            IString debug() ;
            @Data
            @Condition("S")
            ICondition debugS() ;
            @Data
            @Condition("N")
            ICondition debugN() ;
            
            
            @Data(size=10)
            IString cTermSibs() ;
            
            @Data(size=4, signed=true)
            IInt ano() ;
            
        }
        
        public interface Erros extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("001")
            ICondition precAntNExiste() ;
            
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("A2")
            ICondition abendDb2() ;
            @Data
            @Condition("FU")
            ICondition errosFuncao() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
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
            
        }
    }
    
}
