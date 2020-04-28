package cgd.hq.structures.link;

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
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhql100a extends IDataStruct {
    
    @Data(size=8, value="MHQJ100A")
    IString cMhqj100a() ;
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    public interface Commarea extends IDataStruct {
        
        @Data(size=24)
        IString nRefOpetBpor() ;
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=1)
            IString swIEstorno() ;
            @Data
            @Condition("S")
            ICondition swIEstornoSim() ;
            @Data
            @Condition("N")
            ICondition swIEstornoNao() ;
            
            
            @Data(size=1)
            IString swISimulz() ;
            @Data
            @Condition("S")
            ICondition swISimulzSim() ;
            @Data
            @Condition("N")
            ICondition swISimulzNao() ;
            
            
            @Data(size=1)
            IString swIOffline() ;
            @Data
            @Condition("2")
            ICondition swIOfflineSim() ;
            @Data
            @Condition("1")
            ICondition swIOfflineNao() ;
            
            
            @Data(size=1)
            IString swIProc() ;
            @Data
            @Condition("B")
            ICondition swIBatch() ;
            @Data
            @Condition("O")
            ICondition swIOnLine() ;
            
            
            @Data(size=1)
            IString tipoOper() ;
            @Data
            @Condition("A")
            ICondition swAvlNecessCoe() ;
            @Data
            @Condition("V")
            ICondition swAvlNecCoeCnt() ;
            @Data
            @Condition("M")
            ICondition swValidaMotivo() ;
            @Data
            @Condition("G")
            ICondition swGeraCoe() ;
            @Data
            @Condition("R")
            ICondition swGeraCoeRedz() ;
            
            
            /**
             * @return instancia da classe local AcessoCntas
             */
            @Data
            AcessoCntas acessoCntas() ;
            
            @Data(size=1)
            IString iOpCxMe() ;
            @Data
            @Condition("S")
            ICondition iOpCxMeSim() ;
            @Data
            @Condition("N")
            ICondition iOpCxMeNao() ;
            
            
            /**
             * @return instancia da classe local AcessIcb
             */
            @Data(length=2)
            IArray<AcessIcb> acessIcb() ;
            
            @Data(size=4)
            IString cEvento() ;
            
            @Data(size=4)
            IString cSubEvento() ;
            
            @Data(size=2)
            IString cBaseIcdcOpe() ;
            
            @Data(size=3)
            IString cPaisIsoBancPt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cEmpBancPt() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
            @Data(size=2)
            IString cSiglApl() ;
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=10)
            IString zOpert() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mOpetBpor() ;
            
            @Data(size=3)
            IString cMoedIsoAlfn() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoOpetBpor() ;
            
            @Data(size=3)
            IString cPaisIsoAtc() ;
            
            @Data(size=2)
            IString cTcmd() ;
            
            @Data(size=2)
            IString cTcmc() ;
            
            /**
             * @return instancia da classe local IdentContDeb
             */
            @Data
            IdentContDeb identContDeb() ;
            
            /**
             * @return instancia da classe local IdentContCre
             */
            @Data
            IdentContCre identContCre() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBanco() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nIpc() ;
            
            @Data(size=24)
            IString cRefOrigOpet() ;
            
            @Data(size=9)
            ILong nJourBbn() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=26)
            IString tsTransaccao() ;
            
            @Data(size=255)
            IString xAudtBporSegn() ;
            
            @Data(size=255)
            IString xAudtBporTerc() ;
            
            @Data(size=50)
            IString cEntEmitCtrpBp() ;
            
            @Data(size=3)
            IString cPaisResiCtpBp() ;
            
            @Data(size=3)
            IString cPaisEntActfBp() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt cSectIttlBpCtp() ;
            
            @Data(size=150)
            IString xObsOpetBpor() ;
            
            @Data(size=255)
            IString xAudtBporQrto() ;
            
            @Data(size=8)
            IString cUsidRsplCriz() ;
            
            @Data(size=2)
            IString aAplicacao() ;
            
            @Data(size=3)
            IString cOpczMnReg() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=1, value=" ")
            IString iObtzInfCplr() ;
            @Data
            @Condition("S")
            ICondition iObtzInfCplrS() ;
            @Data
            @Condition("N")
            ICondition iObtzInfCplrN() ;
            
            
            @Data(size=1, value=" ")
            IString iTrttParcial() ;
            @Data
            @Condition("S")
            ICondition iTrttParcialS() ;
            @Data
            @Condition("N")
            ICondition iTrttParcialN() ;
            
            
            @Data(size=1, value=" ")
            IString iNtzaRegBpor() ;
            @Data
            @Condition("C")
            ICondition iNtzaCriacao() ;
            @Data
            @Condition("A")
            ICondition iNtzaAnulacao() ;
            
            
            
            public interface AcessoCntas extends IDataStruct {
                
                @Data(size=1)
                IString cSectIttlBporAl() ;
                
                @Data(size=1)
                IString iClszTtr1Cont() ;
                
                @Data(size=2)
                IString cTipoTrttCont() ;
                
                @Data(size=1)
                IString iEmpsNomeIdvl() ;
                
            }
            
            public interface AcessIcb extends IDataStruct {
                
                @Data(size=2)
                IString aAplInszJour() ;
                
                @Data(size=3)
                IString cOpczMenu() ;
                
                @Data(size=5)
                IString cOpeBbn() ;
                
                @Data(size=10)
                IString cCpltMvopIcb() ;
                
                @Data(size=1)
                IString iTipoFmonIcb() ;
                
                @Data(size=3)
                IString cFamiProd() ;
                
                @Data(size=3)
                IString cProduto() ;
                
                @Data(size=3)
                IString cPaisIsoaOeDst() ;
                
                @Data(size=3)
                IString cMnemEgcDest() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcDest() ;
                
                @Data(size=3)
                IString cPrazIcb() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt cSectIttlBpor() ;
                
            }
            
            public interface IdentContDeb extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaContDeb() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContDeb() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContDeb() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclContDeb() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContDeb() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoContDeb() ;
                
                @Data(size=3)
                IString cMoedIsoSctaDeb() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt nsDepositoDeb() ;
                
            }
            
            public interface IdentContCre extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaContCre() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContCre() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContCre() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclContCre() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContCre() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoContCre() ;
                
                @Data(size=3)
                IString cMoedIsoSctaCre() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt nsDepositoCre() ;
                
            }
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=1, value=" ")
            IString swDeclaranteDirecto() ;
            @Data
            @Condition("S")
            ICondition swDdS() ;
            @Data
            @Condition("N")
            ICondition swDdN() ;
            
            
            @Data(size=1)
            IString iAvlNecessCoe() ;
            @Data
            @Condition("S")
            ICondition iNecessGeraCoeS() ;
            @Data
            @Condition("N")
            ICondition iNecessGeraCoeN() ;
            
            
            @Data(size=1)
            IString iValidaMotivo() ;
            @Data
            @Condition("I")
            ICondition motivoInvalido() ;
            @Data
            @Condition("V")
            ICondition motivoValido() ;
            
            
            @Data(size=1, value=" ")
            IString iGerComunica() ;
            @Data
            @Condition("S")
            ICondition iGerComunicaS() ;
            @Data
            @Condition("N")
            ICondition iGerComunicaN() ;
            
            
            @Data(size=4, value=" ")
            IString cTipoRpte() ;
            @Data
            @Condition("COPE")
            ICondition cTipoRpteCope() ;
            @Data
            @Condition("COL")
            ICondition cTipoRpteCol() ;
            
            
            @Data(size=20)
            IString cIdOpetBpor() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("009")
            ICondition erroInsVhq02801() ;
            @Data
            @Condition("011")
            ICondition erroDelVhq02801() ;
            @Data
            @Condition("019")
            ICondition dadInpMhqj100aInv() ;
            @Data
            @Condition("021")
            ICondition coeNaoExiste() ;
            @Data
            @Condition("022")
            ICondition erroAcessoVhq02801() ;
            @Data
            @Condition("028")
            ICondition tipOperMhqj100aInv() ;
            @Data
            @Condition("029")
            ICondition acesIcbMhqj100aInv() ;
            @Data
            @Condition("068")
            ICondition erroInsVhq03001() ;
            @Data
            @Condition("069")
            ICondition erroUpdVhq12801() ;
            @Data
            @Condition("070")
            ICondition rubricaContabInext() ;
            @Data
            @Condition("071")
            ICondition erroObtSeqDb2() ;
            @Data
            @Condition("072")
            ICondition natNPermManut() ;
            @Data
            @Condition("073")
            ICondition erroSelVhq03001() ;
            @Data
            @Condition("074")
            ICondition erroSelVhq12801() ;
            @Data
            @Condition("075")
            ICondition erroSelVhq13001() ;
            @Data
            @Condition("076")
            ICondition erroAcessoVhq03001() ;
            @Data
            @Condition("077")
            ICondition erroAcessoVhq12801() ;
            @Data
            @Condition("078")
            ICondition erroAcessoVhq13001() ;
            
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=70)
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
            @Data
            @Condition("DA")
            ICondition erDadosEntrada() ;
            
            
        }
    }
    
}
