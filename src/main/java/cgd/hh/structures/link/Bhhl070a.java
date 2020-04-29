package cgd.hh.structures.link;

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
public interface Bhhl070a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHHJ070A")
    IString cRotina() ;
    
    /**
     * Inner Classes
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
        
        
        public interface DadosInput extends IDataStruct {
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nChequeInp() ;
            
            @Data(size=2)
            IString cSrieCheqInp() ;
            
            @Data(size=3)
            IString cPaisIsoaContN() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContN() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContN() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContN() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContN() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContN() ;
            
        }
        
        public interface DadosOutput extends IDataStruct {
            
            /**
             * @return instancia da classe local DadosErro
             */
            @Data
            DadosErro dadosErro() ;
            
            /**
             * @return instancia da classe local Vhh01101
             */
            @Data
            Vhh01101 vhh01101() ;
            
            
            public interface DadosErro extends IDataStruct {
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cSqlcode() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cRtnoEvenSwal() ;
                
                @Data(size=50)
                IString msgErrob() ;
                
                @Data(size=18)
                IString nmTabela() ;
                
                @Data(size=8)
                IString modOrigemErro() ;
                
                @Data(size=40)
                IString chAcesso() ;
                
                @Data(size=2)
                IString aAplErr() ;
                
                @Data(size=2, value=" ")
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
            
            public interface Vhh01101 extends IDataStruct {
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nCheque() ;
                
                @Data(size=2)
                IString cSrieCheq() ;
                
                @Data(size=3)
                IString cPaisIsoaCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcCont() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclCont() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt vChkdCont() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoCont() ;
                
                @Data(size=3)
                IString cMoedIsoScta() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt nsDeposito() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nLchq() ;
                
                @Data(size=2)
                IString iEstCheq() ;
                
                @Data(size=3)
                IString cPaisIsaPagChq() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancPagCheq() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcPagCheq() ;
                
                @Data(size=10)
                IString zPagCheq() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mCheque() ;
                
                @Data(size=10)
                IString zMovimento() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOpx() ;
                
                @Data(size=3)
                IString cMnemEgcOpex() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcOpex() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nJourBbn() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt nsJourBbn() ;
                
                @Data(size=8)
                IString cUserid() ;
                
                @Data(size=2)
                IString aAplicacao() ;
                
                @Data(size=3)
                IString cOpczMenu() ;
                
                @Data(size=5)
                IString cOpeBbn() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloApos() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoDpnlApos() ;
                
                @Data(size=1)
                IString iTipoIcdcCheq() ;
                
                @Data(size=26)
                IString tsActzUlt() ;
                
                @Data(size=8)
                IString cUsidActzUlt() ;
                
            }
        }
    }
    
}
