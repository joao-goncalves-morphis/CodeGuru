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
public interface Bhol002a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ002A")
    IString cRotina() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * **                        BHOL002A
     * ROTINA DE CONSULTA A INFORMAÃ‡ÃƒO DE Subcontas NA THO00002
     * MODOS DE ACESSO
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
            @Condition("C")
            ICondition modoConsulta() ;
            
            
            /**
             * @return instancia da classe local ChaveConsulta
             */
            @Data
            ChaveConsulta chaveConsulta() ;
            
            
            public interface ChaveConsulta extends IDataStruct {
                
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
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=1)
            IString cBlqoScta() ;
            
            @Data(size=2)
            IString iEstScta() ;
            
            @Data(size=2)
            IString iEstSctaAnt() ;
            
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
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovMgrdUlt() ;
            
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
            
            @Data(size=10)
            IString zCntlSldo() ;
            
            @Data(size=10)
            IString zCntlDatValMov() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovUlt() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovAbraScta() ;
            
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
            
            @Data(size=1)
            IString iTipoRstzMovz() ;
            
            @Data(size=1)
            IString iExisSegmProt() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mAbraSctaMin() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mAbraScta() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCblo() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCbloCntl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCbloMax() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCbloMin() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoRetd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoRetdCntl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoVcob() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoVcobCntl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoVcobUtid() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldVcobUtdCtl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoNaoMobl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboNgcdAtrd() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcbNgcdAtdCtl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboNgcdUtid() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcbNgcdUtdCtl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgLim() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgLimCntl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgUtid() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgUtidCntl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboMovSibs() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboDomz() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboVcob() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDcboActf() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDngdAtdCtlAnt() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDngdUtdCtlAnt() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgLimCtlAnt() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCmrgUtdCtlAnt() ;
            
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
            
            @Data(size=2)
            IString cTipoOpeObjDb2() ;
            
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
