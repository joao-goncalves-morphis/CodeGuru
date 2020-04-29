package cgd.ho.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
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
public interface Bhow0023 extends IDataStruct {
    
    /**
     * @return instancia da classe local AreaComum
     */
    @Data
    AreaComum areaComum() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOW0023
     * COPY DE WORKING PARA OBTENCAO DE DADOS DE BALCAO
     * 
     * @version 2.0
     * 
     */
    public interface AreaComum extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosInput
         */
        @Data
        DadosInput dadosInput() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * @return instancia da classe local DadosInternos
         */
        @Data
        DadosInternos dadosInternos() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=40)
            IString nmOe() ;
            
            @Data(size=16)
            IString nmOeAbvd() ;
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("004")
            ICondition warningDb2() ;
            @Data
            @Condition("005")
            ICondition erroDb2() ;
            @Data
            @Condition("102")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("116")
            ICondition oeNaoExiste() ;
            
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
            @Data(size=2)
            IString cTipoErroBbn() ;
            @Data
            @Condition("A1")
            ICondition abend() ;
            @Data
            @Condition("A2")
            ICondition abendDb2() ;
            @Data
            @Condition("A3")
            ICondition erroCics() ;
            @Data
            @Condition("FU")
            ICondition errosFuncao() ;
            @Data
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition(" ")
            ICondition semErros() ;
            
            
        }
        
        public interface DadosInternos extends IDataStruct {
            
            /**
             * @return instancia da classe local TabelaBalcoes
             */
            @Data(length=999)
            IArray<TabelaBalcoes> tabelaBalcoes() ;
            
            
            public interface TabelaBalcoes extends IDataStruct {
                
                
                @Data(size=3)
                IString pais() ;
                
                @Data(size=3)
                IString mnem() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt oe() ;
                
                @Data(size=40)
                IString balcao() ;
                
                @Data(size=16)
                IString balcaoAbvd() ;
                
                @Data(size=3)
                IString idioma() ;
                
            }
        }
    }
    
}
