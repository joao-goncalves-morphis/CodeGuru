package cgd.hy.structures.link;

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
public interface Bhyl100a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE LIGACAO COM A ROTINA MHYQ100A
     * AREA DE LIGACAO COM A ROTINA DE ACTUALIZACAO DE TABELAS ACTIVAS*
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=1)
            IString iOperacao() ;
            @Data
            @Condition("V")
            ICondition visualizacao() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            
            
            @Data(size=2)
            IString aAplicacao() ;
            
            @Data(size=18)
            IString cGrupTabAtiv() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt cImgGrupTab() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt qImgGrupTabMax() ;
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("FU")
            ICondition erroFuncao() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            @Data
            @Condition("A2")
            ICondition abendDb2() ;
            @Data
            @Condition("DA")
            ICondition erDadosEntrada() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("004")
            ICondition warningDb2() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            @Data
            @Condition("134")
            ICondition tabelaInexistente() ;
            @Data
            @Condition("206")
            ICondition dadosInvalidos() ;
            
            
            @Data(size=18)
            IString cNmTabela() ;
            
            @Data(size=9, signed=true, compression=COMP)
            ILong cSqlcode() ;
            
            @Data(size=30)
            IString chvAces() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
            @Data(size=30)
            IString campErro() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
        }
    }
    
}
