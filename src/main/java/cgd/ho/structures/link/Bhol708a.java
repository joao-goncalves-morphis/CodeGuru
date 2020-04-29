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
public interface Bhol708a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHOJ708A")
    IString conMhoj708a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHOL708A - AREA DE LIGACAO AO MODULO MHOJ708A
     * VALIDACAO DE CONTA
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
            @Condition("S")
            ICondition aberturaSubconta() ;
            @Data
            @Condition("R")
            ICondition reaberturaConta() ;
            @Data
            @Condition("V")
            ICondition consulta() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("E")
            ICondition modificacaoEspecial() ;
            @Data
            @Condition("C")
            ICondition cancelamento() ;
            @Data
            @Condition("T")
            ICondition validaSuporte() ;
            
            
            /**
             * @return instancia da classe local Seguranca
             */
            @Data
            Seguranca seguranca() ;
            
            
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
            @Condition("-150")
            ICondition utilSemAcesso() ;
            @Data
            @Condition("002")
            ICondition accaoIncompSituacao() ;
            @Data
            @Condition("003")
            ICondition ctaNaoExiste() ;
            @Data
            @Condition("005")
            ICondition erroBaseDados() ;
            @Data
            @Condition("025")
            ICondition accaoInvalida() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
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
             * @return instancia da classe local Vho00101
             */
            @Data
            Vho00101 vho00101() ;
            
            
            public interface Vho00101 extends IDataStruct {
                
                @Data(size=3)
                IString cFamiProd() ;
                
                @Data(size=2)
                IString cTipoTrttCont() ;
                
                @Data(size=3)
                IString cPaisIsoaGerx() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancGcxGerx() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcGerx() ;
                
                @Data(size=3)
                IString cPaisIsoaAbra() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancAbraCont() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcAbra() ;
                
                @Data(size=3)
                IString cMoedIso() ;
                
                @Data(size=2)
                IString iEstCont() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cCndzMovzCont() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt cSectIttlBpor() ;
                
                @Data(size=10)
                IString zAbraCont() ;
                
                @Data(size=10)
                IString zValAbraCont() ;
                
                @Data(size=10)
                IString zRabtContUlt() ;
                
                @Data(size=10)
                IString zCcltCont() ;
                
                @Data(size=10)
                IString zMgrzCont() ;
                
                @Data(size=1)
                IString iTipoSpte() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt qTitc() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt qTitcAtiv() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt qAtrdAtiv() ;
                
                @Data(size=15)
                IString nFaxCtco() ;
                
                @Data(size=1)
                IString iAtrzAsstFax() ;
                
                @Data(size=1)
                IString iInbzCheq() ;
                
                @Data(size=1)
                IString iExisObsCont() ;
                
                @Data(size=1)
                IString iExisContSpte() ;
                
                @Data(size=1)
                IString iExisCttoFisi() ;
                
                @Data(size=1)
                IString iEmpsNomeIdvl() ;
                
                @Data(size=1)
                IString iExisRstzCont() ;
                
                @Data(size=1)
                IString iExisGerxCont() ;
                
                @Data(size=1)
                IString iEmsAvsoAbrCta() ;
                
                @Data(size=1)
                IString iClszTtr1Cont() ;
                
                @Data(size=1)
                IString iObrgExisScta() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt qAtrzDomz() ;
                
                @Data(size=3)
                IString cProdDflt() ;
                
                @Data(size=3)
                IString cMnemEmpGcx() ;
                
                @Data(size=4)
                IString cTipoCanlAces() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nsAvsoContUlt() ;
                
                @Data(size=1)
                IString iAltOeEgcGerx() ;
                
                @Data(size=1)
                IString iAltUsidGrxCta() ;
                
                @Data(size=1)
                IString iObrgEtgJurEst() ;
                
                @Data(size=1)
                IString iIgdeIrTitc() ;
                
                @Data(size=1)
                IString iDcvoEspl() ;
                
                @Data(size=1)
                IString iGrazCoe() ;
                
                @Data(size=1)
                IString iExrtSwif() ;
                
                @Data(size=26)
                IString tsActzUlt() ;
                
                @Data(size=8)
                IString cUsidActzUlt() ;
                
            }
        }
    }
    
}
