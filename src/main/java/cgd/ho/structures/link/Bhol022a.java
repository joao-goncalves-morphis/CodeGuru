package cgd.ho.structures.link;

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
public interface Bhol022a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ022A")
    IString conMhoj022a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * **                        BHOL022A
     * ROTINA DE CONSULTA A INFORMAÇÃO DE MOVIMENTOS NA THO00022
     * MODOS DE ACESSO
     * 1 - CHAVE DE JOURNAL   - PREENCHER CAMPOS REFERENTES A CHAVE DE
     * JOURNAL
     * 2 - CHAVE DE MOVIMENTO - PREENCHER CAMPOS REFERENTES A CHAVE
     * DE MOVIMENTO
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
            
            @Data(size=1)
            IString debug() ;
            @Data
            @Condition("S")
            ICondition debugS() ;
            @Data
            @Condition("N")
            ICondition debugN() ;
            
            
            @Data(size=1)
            IString modoAcesso() ;
            @Data
            @Condition("J")
            ICondition modoJournal() ;
            @Data
            @Condition("M")
            ICondition modoMov() ;
            
            
            /**
             * USAR CAMPOS CHAVE JOURNAL PARA ACESSO POR JOURNAL
             * @return instancia da classe local ChaveJournal
             */
            @Data
            ChaveJournal chaveJournal() ;
            
            /**
             * USAR CAMPOS CHAVE MOVIMENTO PARA ACESSO POR CHAVE DE MOVIMENTO
             * @return instancia da classe local ChaveMovimento
             */
            @Data
            ChaveMovimento chaveMovimento() ;
            
            
            
            /**
             * 
             * USAR CAMPOS CHAVE JOURNAL PARA ACESSO POR JOURNAL
             * 
             * @version 2.0
             * 
             */
            public interface ChaveJournal extends IDataStruct {
                
                @Data(size=10)
                IString zProcessamentoI() ;
                
                @Data(size=3)
                IString cMnemEgcOpexI() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOpxI() ;
                
                @Data(size=4)
                IInt cOeEgcOpexI() ;
                
                @Data(size=8)
                IString cUseridI() ;
                
                @Data(size=9)
                ILong nJourBbnI() ;
                
                @Data(size=2)
                IInt nsJourBbnI() ;
                
                @Data(size=2)
                IInt nsJourBbnDtlhI() ;
                
            }
            
            
            /**
             * 
             * USAR CAMPOS CHAVE MOVIMENTO PARA ACESSO POR CHAVE DE MOVIMENTO
             * 
             * @version 2.0
             * 
             */
            public interface ChaveMovimento extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaContI() ;
                
                @Data(size=4)
                IInt cBancContI() ;
                
                @Data(size=4)
                IInt cOeEgcContI() ;
                
                @Data(size=7)
                IInt nsRdclContI() ;
                
                @Data(size=1)
                IInt vChkdContI() ;
                
                @Data(size=3)
                IInt cTipoContI() ;
                
                @Data(size=3)
                IString cMoedIsoSctaI() ;
                
                @Data(size=4)
                IInt nsDepositoI() ;
                
                @Data(size=15)
                ILong nsMovimentoI() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoaCont() ;
            
            @Data(size=4)
            IInt cBancCont() ;
            
            @Data(size=4)
            IInt cOeEgcCont() ;
            
            @Data(size=7)
            IInt nsRdclCont() ;
            
            @Data(size=1)
            IInt vChkdCont() ;
            
            @Data(size=3)
            IInt cTipoCont() ;
            
            @Data(size=3)
            IString cMoedIsoScta() ;
            
            @Data(size=4)
            IInt nsDeposito() ;
            
            @Data(size=15)
            ILong nsMovimento() ;
            
            @Data(size=10)
            IString zContabilizacao() ;
            
            @Data(size=10)
            IString zMovimento() ;
            
            @Data(size=10)
            IString zValor() ;
            
            @Data(size=1)
            IString iDbcr() ;
            
            @Data(size=17, decimal=2)
            IDecimal mMovimento() ;
            
            @Data(size=17, decimal=2)
            IDecimal mSldoCblo() ;
            
            @Data(size=17, decimal=2)
            IDecimal mSldoDpnl() ;
            
            @Data(size=3)
            IString cMoedIsoOriMov() ;
            
            @Data(size=17, decimal=2)
            IDecimal mMovMoeOrigMov() ;
            
            @Data(size=11, decimal=6)
            IDecimal tCambio() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            @Data(size=21)
            IString xRefMov() ;
            
            @Data(size=10)
            ILong nCheque() ;
            
            @Data(size=1)
            IString iEstorno() ;
            
            @Data(size=15)
            ILong nsMovEtnd() ;
            
            @Data(size=1)
            IString iTrnzEfcdOnln() ;
            
            @Data(size=1)
            IString iTipoOrigTrnz() ;
            
            @Data(size=1)
            IString iExiAtzJourBb() ;
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            @Data(size=2)
            IString aAplicacao() ;
            
            @Data(size=3)
            IString cOpczMenu() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=7)
            IInt cSectIttlBpor() ;
            
            @Data(size=3)
            IString cPaisIsoaGerx() ;
            
            @Data(size=4)
            IInt cBancGcxGerx() ;
            
            @Data(size=4)
            IInt cOeEgcGerx() ;
            
            @Data(size=1)
            IInt iMovActzVsld() ;
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=4)
            IInt cOeEgcOpex() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=9)
            ILong nJourBbn() ;
            
            @Data(size=2)
            IInt nsJourBbn() ;
            
            @Data(size=2)
            IInt nsJourBbnDtlh() ;
            
            @Data(size=17, decimal=2)
            IDecimal mSldoRetd() ;
            
            @Data(size=17, decimal=2)
            IDecimal mSldoVcob() ;
            
            @Data(size=17, decimal=2)
            IDecimal mSldoVcobUtid() ;
            
            @Data(size=17, decimal=2)
            IDecimal mDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2)
            IDecimal mDcboNgcdUtid() ;
            
            @Data(size=17, decimal=2)
            IDecimal mCmrgLim() ;
            
            @Data(size=17, decimal=2)
            IDecimal mCmrgUtid() ;
            
            @Data(size=5)
            IInt qDiaCalcJuro() ;
            
            @Data(size=2)
            IString cTipoJuro() ;
            
            @Data(size=1)
            IString iTipoCalcJuro() ;
            
            @Data(size=1)
            IString iPenalizacao() ;
            
            @Data(size=5)
            IInt qRenovacao() ;
            
            @Data(size=3)
            IInt nsUtizCmrg() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
        }
        
        public interface DadosErro extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
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
