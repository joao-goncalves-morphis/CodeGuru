package cgd.hg.structures.link;

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
public interface Bhgl012a extends IDataStruct {
    
    @Data(size=8, value="MHGJ012A")
    IString rotCodMoeda() ;
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosIO
         */
        @Data
        DadosIO dadosIO() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosIO extends IDataStruct {
            
            @Data(size=3)
            IString cIdioIso() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cMoedIsoNmrc() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=1)
            IString iMoeoUe() ;
            
            @Data(size=3)
            IString cPaisIsaMoeDft() ;
            
            @Data(size=30)
            IString dCodAbvd() ;
            
            @Data(size=80)
            IString dCodLong() ;
            
            @Data(size=1)
            IString iMoedRcnzScls() ;
            
            @Data(size=11)
            IString cEndcSwifScls() ;
            
            /**
             * @return instancia da classe local DadosErro
             */
            @Data
            DadosErro dadosErro() ;
            
            
            public interface DadosErro extends IDataStruct {
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlcode() ;
                
                @Data(size=18)
                IString nmTabela() ;
                
                @Data(size=2)
                IString aAplErr() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cRtnoEvenSwal() ;
                @Data
                @Condition("005")
                ICondition erroDb2() ;
                @Data
                @Condition("102")
                ICondition dadosInvalidos() ;
                @Data
                @Condition("014")
                ICondition tabelaSemDados() ;
                
                
                @Data(size=2)
                IString cTipoErroBbn() ;
                @Data
                @Condition("A2")
                ICondition abendDb2() ;
                @Data
                @Condition("FU")
                ICondition erroFuncao() ;
                @Data
                @Condition("DA")
                ICondition dadosEntrada() ;
                @Data
                @Condition("  ")
                ICondition semErros() ;
                
                
            }
        }
    }
    
}
