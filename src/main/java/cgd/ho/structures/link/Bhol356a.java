package cgd.ho.structures.link;

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
public interface Bhol356a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ356A")
    IString conMhoj356a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL356A - DEVOLVE INFORMACAO SOBRE CHAVES DE JOURNAL
     * DATA CRIACAO - 2009-03-19   UTILIZADOR: DACT546
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
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
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosInput extends IDataStruct {
            
            /**
             * @return instancia da classe local Subconta
             */
            @Data
            Subconta subconta() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=1)
            IString iMovDia() ;
            
            
            public interface Subconta extends IDataStruct {
                
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
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=4, compression=COMP3)
            IInt cOeEgcOpex() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=9, compression=COMP3)
            ILong nJourBbn() ;
            
            @Data(size=2, compression=COMP3)
            IInt nsJourBbn() ;
            
            @Data(size=9, compression=COMP3)
            ILong nsJourBbnDtlh() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
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
            ICondition abendCics() ;
            @Data
            @Condition("FU")
            ICondition erroFuncao() ;
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
