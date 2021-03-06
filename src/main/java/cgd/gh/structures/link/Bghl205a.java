package cgd.gh.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
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
public interface Bghl205a extends IDataStruct {
    
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
     * Inner Classes
     */
    
    /**
     * 
     * BGHL205A- AREA DE ACESSO A MGHS205A
     * DATA CRIACAO - 2011-01-24   UTILIZADOR: DC05708
     * 
     * @version 2.0
     * 
     */
    public interface DadosInput extends IDataStruct {
        
        /**
         * @return instancia da classe local Subconta
         */
        @Data
        Subconta subconta() ;
        
        @Data(size=10)
        IString zMovimento() ;
        
        @Data(size=3)
        IString cMnemEgcOpex() ;
        
        @Data(size=3)
        IString cPaisIsoaOeOpx() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong cOeEgcOpex() ;
        
        @Data(size=8)
        IString cUserid() ;
        
        @Data(size=9, signed=true, compression=COMP3)
        ILong nJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbnDtlh() ;
        
        @Data(size=2)
        IString aAplicacao() ;
        
        
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
        
        /**
         * @return instancia da classe local DadosMov
         */
        @Data
        DadosMov dadosMov() ;
        
        /**
         * @return instancia da classe local DadosAdic
         */
        @Data
        DadosAdic dadosAdic() ;
        
        /**
         * @return instancia da classe local DadosErro
         */
        @Data
        DadosErro dadosErro() ;
        
        
        public interface DadosMov extends IDataStruct {
            
            @Data(size=26)
            IString tsMovimento() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nsMovimento() ;
            
            @Data(size=2)
            IString aAplOrig() ;
            
            @Data(size=4)
            IString cTrnzIput() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nDocOpps() ;
            
        }
        
        public interface DadosAdic extends IDataStruct {
            
            @Data(size=4)
            IString cTrnzAdic() ;
            
            @Data(size=8)
            IString nmPrgAdic() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("233")
            ICondition dadosInvalidos() ;
            @Data
            @Condition("098")
            ICondition semInfAdic() ;
            @Data
            @Condition("097")
            ICondition naoExisteMov() ;
            
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
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
