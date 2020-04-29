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
public interface Bhol710a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ710A")
    IString conMhoj710a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL710A - AREA DE LIGACAO AO MODULO MHOJ710A
     * VALIDACAO DE SUBCONTA
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
        
        
        public interface DadosInput extends IDataStruct {
            
            /**
             * @return instancia da classe local Conta
             */
            @Data
            Conta conta() ;
            
            @Data(size=1, value=" ")
            IString accao() ;
            @Data
            @Condition("R")
            ICondition reaberturaSubconta() ;
            @Data
            @Condition("V")
            ICondition consulta() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("C")
            ICondition cancelamento() ;
            @Data
            @Condition("D")
            ICondition debito() ;
            @Data
            @Condition("X")
            ICondition credito() ;
            @Data
            @Condition("E")
            ICondition estorno() ;
            @Data
            @Condition("T")
            ICondition transferencia() ;
            @Data
            @Condition("B")
            ICondition validaSctaBase() ;
            
            
            /**
             * @return instancia da classe local Seguranca
             */
            @Data
            Seguranca seguranca() ;
            
            @Data(size=1)
            IString iCnslDadCheq() ;
            @Data
            @Condition("S")
            ICondition iCnslDadCheqS() ;
            @Data
            @Condition("N")
            ICondition iCnslDadCheqN() ;
            
            
            
            public interface Conta extends IDataStruct {
                
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
            
            public interface Seguranca extends IDataStruct {
                
                @Data(size=4)
                IString cTransaccao() ;
                
                @Data(size=8)
                IString cUserid() ;
                
                @Data(size=8)
                IString cPerfUtlBbn() ;
                
                @Data(size=1)
                IInt ctNvelAtrzBbn() ;
                
                @Data(size=1)
                IString iRstzAcesCont() ;
                @Data
                @Condition("0")
                ICondition iraConNao() ;
                @Data
                @Condition("1")
                ICondition iraConSim() ;
                @Data
                @Condition("2")
                ICondition iraConValSim() ;
                @Data
                @Condition("3")
                ICondition iraConValNao() ;
                
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("-149")
            ICondition subctaNaoExiste() ;
            @Data
            @Condition("-150")
            ICondition utilSemAcesso() ;
            @Data
            @Condition("002")
            ICondition accaoIncompSituacao() ;
            @Data
            @Condition("004")
            ICondition subcontaEncerrada() ;
            @Data
            @Condition("005")
            ICondition erroBaseDados() ;
            @Data
            @Condition("025")
            ICondition accaoInvalida() ;
            @Data
            @Condition("640")
            ICondition iEstSctaBaseInval() ;
            @Data
            @Condition("004")
            ICondition warningDb2() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
            @Data(size=18)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=40)
            IString chAcesso() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
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
            
            
            /**
             * @return instancia da classe local InnerStrct
             */
            @Data
            InnerStrct innerStrct() ;
            
            /**
             * @return instancia da classe local Vho00501
             */
            @Data
            Vho00501 vho00501() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoDpnlCnsl() ;
            
            
            public interface InnerStrct extends IDataStruct {
                
                @Data(size=3)
                IString cProduto() ;
                
                @Data(size=2)
                IString iEstScta() ;
                
                @Data(size=2)
                IString cBasIcdcCalJur() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt iTipPrzJstzMov() ;
                
                @Data(size=5, signed=true, compression=COMP3)
                IInt duTipoPrazJstz() ;
                
                @Data(size=5, signed=true, compression=COMP3)
                IInt qDiaPavs() ;
                
                @Data(size=2)
                IString cSitIcpt() ;
                
                @Data(size=10)
                IString zPabtScta() ;
                
                @Data(size=10)
                IString zAbraScta() ;
                
                @Data(size=10)
                IString zValAbraScta() ;
                
                @Data(size=10)
                IString zRabtScta() ;
                
                @Data(size=10)
                IString zMgrzScta() ;
                
                @Data(size=10)
                IString zValMovDiaMin() ;
                
                @Data(size=10)
                IString zMovUlt() ;
                
                @Data(size=10)
                IString zValMovMax() ;
                
                @Data(size=10)
                IString zEntdCapDiv() ;
                
                @Data(size=10)
                IString zSitIcpt() ;
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovUlt() ;
                
                @Data(size=1)
                IString iRfroPsvl() ;
                
                @Data(size=1)
                IString iMobaPsvl() ;
                
                @Data(size=1)
                IString iJstzMovDeb() ;
                
                @Data(size=1)
                IString iNtzaProd() ;
                
                @Data(size=1)
                IString iSldoCnat() ;
                
                @Data(size=1)
                IString iExisPlnoEtga() ;
                
                @Data(size=1)
                IString iLevtSldoIdnl() ;
                
                @Data(size=1)
                IString iDcboNgcdIsdp() ;
                
                @Data(size=1)
                IString iSldoCmrgIsdp() ;
                
                @Data(size=1)
                IString iNdebDspa() ;
                
                @Data(size=1)
                IString iContCrrtAssd() ;
                
                @Data(size=1)
                IString iExisRstzScta() ;
                
                @Data(size=1)
                IString iAvsoDbcrSwif() ;
                
                @Data(size=1)
                IString iOrigFndo() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mAbraSctaMin() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mAbraScta() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCblo() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloMax() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCbloMin() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoRetd() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoVcob() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoVcobUtid() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDcboNgcdAtrd() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDcboNgcdUtid() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mCmrgLim() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mCmrgUtid() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDcboMovSibs() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDcboDomz() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDcboVcob() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDcboActf() ;
                
            }
            
            public interface Vho00501 extends IDataStruct {
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong qCheqDpnl() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong qCheqDpnlMax() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong qCheqUtid() ;
                
                @Data(size=1)
                IString iInbzEmisCheq() ;
                
            }
        }
    }
    
}
