package cgd.hk.structures.link;

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
public interface Bhkl072a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHKJ072A")
    IString nomeRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE LIGACAO COM A ROTINA MHKJ072A
     * AREA DE LIGACAO COM A ROTINA DE DERIVACAO DE SWIFT ATRAVES
     * DO IBAN
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * DADOS DE ENTRADA
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * *HK1728-FIM
         * DADOS DE SAIDA
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        /**
         * DADOS DE ERRO
         * @return instancia da classe local DadosErros
         */
        @Data
        DadosErros dadosErros() ;
        
        
        
        /**
         * 
         * DADOS DE ENTRADA
         * 
         * @version 2.0
         * 
         */
        public interface DadosEntrada extends IDataStruct {
            
            /**
             * DADOS DE INPUT OBRIGATORIOS
             */
            @Data(size=1)
            IString modoAcesso() ;
            @Data
            @Condition("1")
            ICondition modoSepa() ;
            @Data
            @Condition("2")
            ICondition modoStag22() ;
            @Data
            @Condition("3")
            ICondition modoSwift() ;
            @Data
            @Condition("4")
            ICondition modoObtemRegra() ;
            
            
            /**
             * *HK1728-FIM
             */
            @Data(size=1)
            IString modoSepa1() ;
            @Data
            @Condition("1")
            ICondition sepaCt() ;
            @Data
            @Condition("2")
            ICondition sepaDd() ;
            @Data
            @Condition("3")
            ICondition sepaIp() ;
            
            
            @Data(size=34)
            IString iban() ;
            
            /**
             * *HK1728-INI
             */
            @Data(size=2)
            IString cPaisIsoAlfn() ;
            
            @Data(size=10)
            IString cAgenBnci() ;
            
        }
        
        
        /**
         * 
         * *HK1728-FIM
         * DADOS DE SAIDA
         * 
         * @version 2.0
         * 
         */
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=11)
            IString endSwif() ;
            
            @Data(size=1)
            IString iTipoDerv() ;
            @Data
            @Condition("N")
            ICondition nPrev() ;
            @Data
            @Condition("S")
            ICondition efetuado() ;
            @Data
            @Condition("M")
            ICondition maisRegisto() ;
            
            
            @Data(size=1)
            IString canalStag22() ;
            @Data
            @Condition("W")
            ICondition canlStag22Swift() ;
            @Data
            @Condition("S")
            ICondition canlStag22Sepa() ;
            
            
            @Data(size=1)
            IString iPrevAccuity() ;
            @Data
            @Condition("S")
            ICondition iPrevAccuityS() ;
            @Data
            @Condition("N")
            ICondition iPrevAccuityN() ;
            
            
        }
        
        
        /**
         * 
         * DADOS DE ERRO
         * 
         * @version 2.0
         * 
         */
        public interface DadosErros extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
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
            @Condition("A1")
            ICondition abend() ;
            @Data
            @Condition("A2")
            ICondition abendDb2() ;
            @Data
            @Condition("A3")
            ICondition abendCics() ;
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
            @Condition("  ")
            ICondition semErros() ;
            
            
        }
    }
    
}
