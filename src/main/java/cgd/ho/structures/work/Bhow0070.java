package cgd.ho.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
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
public interface Bhow0070 extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * * * *         COES                       * * *
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local DadosOutput
         */
        @Data
        DadosOutput dadosOutput() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=4, value=" ")
            IString cTransaccaoArq() ;
            
            @Data(size=4, value=" ")
            IString cTransaccaoPgm() ;
            
            @Data(size=1, value=" ")
            IString swIEstorno() ;
            @Data
            @Condition("S")
            ICondition swIEstornoSim() ;
            @Data
            @Condition("N")
            ICondition swIEstornoNao() ;
            
            
            @Data(size=1, value=" ")
            IString swISimulz() ;
            @Data
            @Condition("S")
            ICondition swISimulzSim() ;
            @Data
            @Condition("N")
            ICondition swISimulzNao() ;
            
            
            @Data(size=1, value=" ")
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
            IString swTipoOper() ;
            @Data
            @Condition("A")
            ICondition swIAvlNecessCoe() ;
            @Data
            @Condition("V")
            ICondition swIAvlNecCoeCnt() ;
            @Data
            @Condition("M")
            ICondition swIValidaMotivo() ;
            @Data
            @Condition("G")
            ICondition swIGeraCoe() ;
            @Data
            @Condition("R")
            ICondition swIGeraCoeRedz() ;
            
            
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
            IInt cBancoOpex() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx() ;
            
            @Data(size=3)
            IString cMnemEgcOpex() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgc() ;
            
            @Data(size=8)
            IString cUserid() ;
            
            @Data(size=9)
            ILong nJourBbn() ;
            
            @Data(size=3)
            IString cPaisIsoaOeEsn() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcEstn() ;
            
            @Data(size=8)
            IString cUsidEstn() ;
            
            @Data(size=9)
            ILong nJourBbnEsn() ;
            
            @Data(size=2)
            IString aAplicacao() ;
            
            @Data(size=10)
            IString zProcessamento() ;
            
            @Data(size=26)
            IString tsCentral() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoOpetBpor() ;
            
            @Data(size=2)
            IString cTcmd() ;
            
            @Data(size=2)
            IString cTcmc() ;
            
            @Data(size=2)
            IString cBaseIcdcOpe() ;
            
            /**
             * AAP - HO23868 - INI - 2013-05-20
             * 10 BHOW0070-A-APLICACAO            PIC X(02).
             */
            @Data(size=3)
            IString cOpczMnReg() ;
            
            @Data(size=256)
            IString xAudtBporSegn() ;
            
            @Data(size=256)
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
            
            @Data(size=256)
            IString xAudtBporQrto() ;
            
            @Data(size=8)
            IString cUsidRsplCriz() ;
            
            /**
             * AAP - HO23868 - FIM - 2013-05-20
             * @return instancia da classe local AcessIcb
             */
            @Data(length=2)
            IArray<AcessIcb> acessIcb() ;
            
            @Data(size=4)
            IString cEvento() ;
            
            @Data(size=4)
            IString cSubEvento() ;
            
            @Data(size=10)
            IString zCtlzJourBbn() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=3)
            IString cMoedIsoAlfn() ;
            
            @Data(size=3)
            IString cPaisIsoAtc() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancMovCtpt() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nIpc() ;
            
            /**
             * @return instancia da classe local NIpc2
             */
            @Data
            NIpc2 nIpc2() ;
            
            @Data(size=1)
            IString swICtaEstrang() ;
            @Data
            @Condition("C")
            ICondition swICtaCreEst() ;
            @Data
            @Condition("D")
            ICondition swICtaDebEst() ;
            
            
            @Data(size=1, value=" ")
            IString obrigCoeInput() ;
            @Data
            @Condition("S")
            ICondition coeInputObrig() ;
            
            
            @Data(size=56)
            IString identContAux() ;
            
            @Data(size=33)
            IString acessIcbAux() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt opetBporAux() ;
            
            
            public interface IdentContDeb extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaContDeb() ;
                @Data
                @Condition("PT")
                ICondition cPaisIsoaDebPt() ;
                @Data
                @Condition("LU")
                ICondition cPaisIsoaDebLu() ;
                @Data
                @Condition("MO")
                ICondition cPaisIsoaDebMo() ;
                @Data
                @Condition("KY")
                ICondition cPaisIsoaDebKy() ;
                @Data
                @Condition("  ")
                ICondition cPaisIsoaDebSp() ;
                
                
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
                
                @Data(size=15)
                IString nsMovDeb() ;
                
                @Data(size=1)
                IString iGrazCoeDeb() ;
                @Data
                @Condition("S")
                ICondition iGrazCoeDebS() ;
                @Data
                @Condition("N")
                ICondition iGrazCoeDebN() ;
                @Data
                @Condition("D")
                ICondition iGrazCoeDDecgS() ;
                @Data
                @Condition("G")
                ICondition iGrazCoeDDecgN() ;
                
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt cSectIttlBporDeb() ;
                
                @Data(size=7)
                IInt cSectIttlAux1Deb() ;
                
                /**
                 * @return instancia da classe local CSectIttlAux2Deb
                 */
                @Data
                @Mask
                CSectIttlAux2Deb cSectIttlAux2Deb() ;
                
                @Data(size=1)
                IString iClszTtr1ContDeb() ;
                
                @Data(size=1)
                IString iEmpsNomeIdvlDeb() ;
                
                @Data(size=2)
                IString cTipoTrttContDeb() ;
                
                @Data(size=3)
                IString cMnemEmpGcxDeb() ;
                
                
                public interface CSectIttlAux2Deb extends IDataMask {
                    
                    @Data(size=1)
                    IString cSectIttlDeb() ;
                    
                    @Data(size=2, rpadding=4)
                    IString cSectPartDeb() ;
                    
                }
            }
            
            public interface IdentContCre extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaContCre() ;
                @Data
                @Condition("PT")
                ICondition cPaisIsoaCrePt() ;
                @Data
                @Condition("LU")
                ICondition cPaisIsoaCreLu() ;
                @Data
                @Condition("MO")
                ICondition cPaisIsoaCreMo() ;
                @Data
                @Condition("KY")
                ICondition cPaisIsoaCreKy() ;
                @Data
                @Condition("  ")
                ICondition cPaisIsoaCreSp() ;
                
                
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
                
                @Data(size=15)
                IString nsMovCre() ;
                
                @Data(size=1)
                IString iGrazCoeCre() ;
                @Data
                @Condition("S")
                ICondition iGrazCoeCreS() ;
                @Data
                @Condition("N")
                ICondition iGrazCoeCreN() ;
                @Data
                @Condition("D")
                ICondition iGrazCoeCDecgS() ;
                @Data
                @Condition("G")
                ICondition iGrazCoeCDecgN() ;
                
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt cSectIttlBporCre() ;
                
                @Data(size=7)
                IInt cSectIttlAux1Cre() ;
                
                /**
                 * @return instancia da classe local CSectIttlAux2Cre
                 */
                @Data
                @Mask
                CSectIttlAux2Cre cSectIttlAux2Cre() ;
                
                @Data(size=1)
                IString iClszTtr1ContCre() ;
                
                @Data(size=1)
                IString iEmpsNomeIdvlCre() ;
                
                @Data(size=2)
                IString cTipoTrttContCre() ;
                
                @Data(size=3)
                IString cMnemEmpGcxCre() ;
                
                
                public interface CSectIttlAux2Cre extends IDataMask {
                    
                    @Data(size=1)
                    IString cSectIttlCre() ;
                    
                    @Data(size=2, rpadding=4)
                    IString cSectPartCre() ;
                    
                }
            }
            
            
            /**
             * 
             * AAP - HO23868 - FIM - 2013-05-20
             * 
             * @version 2.0
             * 
             */
            public interface AcessIcb extends IDataStruct {
                
                @Data(size=2)
                IString aAplInszJour() ;
                
                @Data(size=3)
                IString cOpczMenu() ;
                
                @Data(size=5)
                IString cOpeBbn() ;
                
                @Data(size=3)
                IString cFamiProd() ;
                
                @Data(size=3)
                IString cProduto() ;
                
                @Data(size=3)
                IString cPaisIsoaOeDest() ;
                
                @Data(size=3)
                IString cMnemEgcDest() ;
                
                @Data(size=4)
                IInt cOeEgcDest() ;
                
                @Data(size=7)
                IInt cSectIttlBpor() ;
                
            }
            
            public interface NIpc2 extends IDataStruct {
                
                @Data(size=9, rpadding=11)
                ILong nIpcNum() ;
                
            }
        }
        
        public interface DadosOutput extends IDataStruct {
            
            @Data(size=26, value=" ")
            IString auxTs() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=3, signed=true, value="0", compression=COMP3)
            IInt cRtnoEvenSwal() ;
            @Data
            @Condition("002")
            ICondition clienteNaoExiste() ;
            @Data
            @Condition("005")
            ICondition erroBaseDados() ;
            
            
            @Data(size=8, value=" ")
            IString nmTabela() ;
            
            @Data(size=8, value=" ")
            IString modOrigemErro() ;
            
            @Data(size=40, value=" ")
            IString chAcesso() ;
            
            @Data(size=50, value=" ")
            IString msgErrob() ;
            
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
            ICondition errosFuncao() ;
            @Data
            @Condition(" ")
            ICondition semErros() ;
            
            
        }
    }
    
}
