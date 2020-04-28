package cgd.hv.structures.link;

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
public interface Bhvl100a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MHVK100A")
    IString conMhvk100a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHVL100A - AREA DE LIGACAO DA ROTINA DE MOVIMENTACAO
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local AreaInput
         */
        @Data
        AreaInput areaInput() ;
        
        /**
         * @return instancia da classe local AreaOutput
         */
        @Data
        AreaOutput areaOutput() ;
        
        
        public interface AreaInput extends IDataStruct {
            
            /**
             * @return instancia da classe local AreaDadosBase
             */
            @Data
            AreaDadosBase areaDadosBase() ;
            
            /**
             * @return instancia da classe local AreaOperacao
             */
            @Data
            AreaOperacao areaOperacao() ;
            
            /**
             * @return instancia da classe local AreaCondicoes
             */
            @Data
            AreaCondicoes areaCondicoes() ;
            
            /**
             * @return instancia da classe local AreaCambiais
             */
            @Data
            AreaCambiais areaCambiais() ;
            
            /**
             * **R
             * @return instancia da classe local AreaPrazos
             */
            @Data
            AreaPrazos areaPrazos() ;
            
            /**
             * @return instancia da classe local AreaOutrosDados
             */
            @Data
            AreaOutrosDados areaOutrosDados() ;
            
            /**
             * @return instancia da classe local AreaEstorno
             */
            @Data
            AreaEstorno areaEstorno() ;
            
            /**
             * @return instancia da classe local AreaAutorizacoes
             */
            @Data
            AreaAutorizacoes areaAutorizacoes() ;
            
            /**
             * @return instancia da classe local AreaContabilizacao
             */
            @Data
            AreaContabilizacao areaContabilizacao() ;
            
            /**
             * @return instancia da classe local AreaCativos
             */
            @Data
            AreaCativos areaCativos() ;
            
            /**
             * @return instancia da classe local AreaArquitectura
             */
            @Data
            AreaArquitectura areaArquitectura() ;
            
            /**
             * @return instancia da classe local AreaVarInternas
             */
            @Data
            AreaVarInternas areaVarInternas() ;
            
            /**
             * @return instancia da classe local AreaMultiEmpresa
             */
            @Data
            AreaMultiEmpresa areaMultiEmpresa() ;
            
            
            public interface AreaDadosBase extends IDataStruct {
                
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
            
            public interface AreaOperacao extends IDataStruct {
                
                @Data(size=3)
                IString cMoedIsoMov() ;
                
                @Data(size=1)
                IString iDbcr() ;
                @Data
                @Condition("D")
                ICondition debito() ;
                @Data
                @Condition("C")
                ICondition credito() ;
                
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovimento() ;
                
                @Data(size=5)
                IString cOpeBbn() ;
                
                @Data(size=10)
                IString zValor() ;
                
                @Data(size=21)
                IString xRefMov() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nCheque() ;
                
            }
            
            public interface AreaCondicoes extends IDataStruct {
                
                @Data(size=1)
                IString iVldzCndzMovz() ;
                @Data
                @Condition("N")
                ICondition iVldzCndzNao() ;
                @Data
                @Condition("S")
                ICondition iVldzCndzSim() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cCndzMovzCont() ;
                
                @Data(size=1)
                IString iDebPrcl() ;
                @Data
                @Condition("S")
                ICondition debPrclSim() ;
                @Data
                @Condition("N")
                ICondition debPrclNao() ;
                
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDebMin() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDcboLim() ;
                
            }
            
            public interface AreaCambiais extends IDataStruct {
                
                @Data(size=8, signed=true, compression=COMP3)
                ILong nAtrzCamb() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nCliAtrzCamb() ;
                
                @Data(size=1)
                IString iTipoCambMoedIn() ;
                @Data
                @Condition("D")
                ICondition tipoCambMoeInDiv() ;
                @Data
                @Condition("C")
                ICondition tipoCambMoeInChq() ;
                @Data
                @Condition("N")
                ICondition tipoCambMoeInNum() ;
                
                
                /**
                 * **R
                 * INCLUIDO PARA UTILIZACAO DE APLICACOES QUE PROCESSAM O CAMBIO
                 * ANTES DE CHAMAR A ROTINA DE MOVIMENTACAO. DESTA FORMA, TAXA E
                 * CONTRAVALOR FICAM ACTUALIZADOS NA TABELA DE MOVIMENTO
                 */
                @Data(size=11, decimal=6, signed=true, compression=COMP3)
                IDecimal tCambioI() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mCtrvlI() ;
                
            }
            
            
            /**
             * 
             * **R
             * 
             * @version 2.0
             * 
             */
            public interface AreaPrazos extends IDataStruct {
                
                @Data(size=1)
                IString iEstJstzMovDeb() ;
                
                @Data(size=3)
                IString cJstzMovDeb() ;
                
                @Data(size=1)
                IString iPenalizacao() ;
                
            }
            
            public interface AreaOutrosDados extends IDataStruct {
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt nsAbrCliPriTtr() ;
                
                @Data(size=10, signed=true, compression=COMP3)
                ILong nCliPrimTitr() ;
                
                @Data(size=5, signed=true, compression=COMP3)
                IInt qDiaPavs() ;
                
                @Data(size=30)
                IString xRefAux() ;
                
            }
            
            public interface AreaEstorno extends IDataStruct {
                
                @Data(size=1)
                IString iEstorno() ;
                @Data
                @Condition("S")
                ICondition estornoSim() ;
                
                
                @Data(size=3)
                IString cMnemEgcEstn() ;
                
                @Data(size=3)
                IString cPaisIsoaOeEsn() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcEstn() ;
                
                @Data(size=8)
                IString cUsidEstn() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong nJourBbnTrnEsn() ;
                
            }
            
            public interface AreaAutorizacoes extends IDataStruct {
                
                @Data(size=1)
                IString iAtrzBbnDant() ;
                
                @Data(size=1)
                IString iAtrzBbnMsldCblo() ;
                
                @Data(size=1)
                IString iAtrzBbnMsldDpnl() ;
                
                @Data(size=1)
                IString iAtrzBbnVcob() ;
                
                @Data(size=1)
                IString iAtrzBbnMmin() ;
                
                @Data(size=1)
                IString iAtrzQDiaPavs() ;
                
            }
            
            public interface AreaContabilizacao extends IDataStruct {
                
                @Data(size=4)
                IString cEvento() ;
                
                @Data(size=12, signed=true, compression=COMP3)
                ILong xIdMovCriv() ;
                
            }
            
            public interface AreaCativos extends IDataStruct {
                
                @Data(size=3)
                IString iTipoRsal() ;
                
                @Data(size=17)
                IString xRefRetzSldo() ;
                
                @Data(size=30)
                IString xJstzRsal() ;
                
                @Data(size=10)
                IString zLbtzIput() ;
                
                @Data(size=5, signed=true, compression=COMP3)
                IInt duPrazRsal() ;
                
            }
            
            public interface AreaArquitectura extends IDataStruct {
                
                /**
                 * @return instancia da classe local NrElectronico
                 */
                @Data
                NrElectronico nrElectronico() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nsSessao() ;
                
                @Data(size=26)
                IString tsLocal() ;
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt nsJourBbn() ;
                
                @Data(size=4)
                IString cTipoCanlAces() ;
                
                @Data(size=1)
                IString iTrnzEfcdOnln() ;
                @Data
                @Condition("1")
                ICondition trnOnLine() ;
                @Data
                @Condition("2")
                ICondition trnOffLine() ;
                
                
                /**
                 * **R
                 */
                @Data(size=2)
                IString aAplOrig() ;
                
                /**
                 * **R
                 */
                @Data(size=2)
                IString aAplicacao() ;
                
                @Data(size=3)
                IString cOpczMenu() ;
                
                @Data(size=1, signed=true)
                IInt cImgTabJour() ;
                
                /**
                 * @return instancia da classe local DatasProcesso
                 */
                @Data
                DatasProcesso datasProcesso() ;
                
                @Data(size=1)
                IString iTipoOrigTrnz() ;
                @Data
                @Condition("N")
                ICondition tipoOrigSigNao() ;
                @Data
                @Condition("S")
                ICondition tipoOrigSig() ;
                
                
                
                public interface NrElectronico extends IDataStruct {
                    
                    @Data(size=10)
                    IString zProcessamento() ;
                    
                    @Data(size=3)
                    IString cMnemEgcOpex() ;
                    
                    @Data(size=3)
                    IString cPaisIsoaOeOpx() ;
                    
                    @Data(size=4, signed=true, compression=COMP3)
                    IInt cOeEgcOpex() ;
                    
                    @Data(size=8)
                    IString cUserid() ;
                    
                    @Data(size=9)
                    ILong nJourBbn() ;
                    
                }
                
                public interface DatasProcesso extends IDataStruct {
                    
                    @Data(size=10)
                    IString zPrctJourBbn() ;
                    
                    @Data(size=10)
                    IString zCtlzJourBbn() ;
                    
                }
            }
            
            public interface AreaVarInternas extends IDataStruct {
                
                @Data(size=2, signed=true, compression=COMP3)
                IInt nsJourBbnDtlh() ;
                
                @Data(size=1)
                IString iLiqzJuroMomt() ;
                @Data
                @Condition("S")
                ICondition liqzJuroMomtSim() ;
                
                
            }
            
            public interface AreaMultiEmpresa extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaCtpt() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancMovCtpt() ;
                
            }
        }
        
        public interface AreaOutput extends IDataStruct {
            
            /**
             * @return instancia da classe local AreaDadosBaseOutp
             */
            @Data
            AreaDadosBaseOutp areaDadosBaseOutp() ;
            
            /**
             * @return instancia da classe local AreaOperacaoOutp
             */
            @Data
            AreaOperacaoOutp areaOperacaoOutp() ;
            
            /**
             * @return instancia da classe local AreaDebParciaisOut
             */
            @Data
            AreaDebParciaisOut areaDebParciaisOut() ;
            
            /**
             * @return instancia da classe local AreaPrazosOutp
             */
            @Data
            AreaPrazosOutp areaPrazosOutp() ;
            
            /**
             * @return instancia da classe local AreaAutorizacoesOut
             */
            @Data
            AreaAutorizacoesOut areaAutorizacoesOut() ;
            
            /**
             * @return instancia da classe local AreaCativosOutp
             */
            @Data
            AreaCativosOutp areaCativosOutp() ;
            
            /**
             * @return instancia da classe local AreaStdTratErros
             */
            @Data
            AreaStdTratErros areaStdTratErros() ;
            
            
            public interface AreaDadosBaseOutp extends IDataStruct {
                
                @Data(size=3)
                IString cMoeIsoSctaOut() ;
                
                @Data(size=3)
                IString cFamiProd() ;
                
                @Data(size=3)
                IString cProduto() ;
                
                @Data(size=3)
                IString cPaisIsoaGerx() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancGcxGerx() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcGerx() ;
                
                @Data(size=2)
                IString cTipoTrttCont() ;
                
                @Data(size=1)
                IString iGrazCoe() ;
                @Data
                @Condition("S")
                ICondition grazCoeSim() ;
                
                
            }
            
            public interface AreaOperacaoOutp extends IDataStruct {
                
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovimento() ;
                
                /**
                 * *NUMERO SEQUENCIAL DO MOVIMENTO ESTORNADO
                 */
                @Data(size=15, signed=true, compression=COMP3)
                ILong nsMovEtnd() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovMoedScta() ;
                
                @Data(size=11, decimal=6, signed=true, compression=COMP3)
                IDecimal tCambio() ;
                
                @Data(size=11, decimal=6, signed=true, compression=COMP3)
                IDecimal tCmbEuro() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoCblo() ;
                
                /**
                 * *SALDO DISPONIVEL PARA MOVIMENTACAO
                 */
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoDpnl() ;
                
                /**
                 * *SALDO DISPONIVEL PARA CONSULTA
                 */
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSdpnCnsl() ;
                
            }
            
            public interface AreaDebParciaisOut extends IDataStruct {
                
                @Data(size=1)
                IString iDebPrclOutp() ;
                @Data
                @Condition("S")
                ICondition debPrclSimOut() ;
                @Data
                @Condition("N")
                ICondition debPrclNaoOut() ;
                
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mDebPrcl() ;
                
            }
            
            public interface AreaPrazosOutp extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsaCtaJcr() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBancContJcrx() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcContJcrx() ;
                
                @Data(size=7, signed=true, compression=COMP3)
                IInt nsRdclContJcrx() ;
                
                @Data(size=1, signed=true, compression=COMP3)
                IInt vChkdContJcrx() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cTipoContJcrx() ;
                
                @Data(size=3)
                IString cMoeIsoSctaJcr() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt nsDepJcrx() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mJcrxLiqd() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mImpLiqd() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovJuroMoeDst() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovImpMoedDst() ;
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mMovLiqMoedDst() ;
                
            }
            
            public interface AreaAutorizacoesOut extends IDataStruct {
                
                @Data(size=1)
                IString iAtrzDantOutp() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAtrzDantOutpM() ;
                
                @Data(size=1)
                IString iAtrzMscbOutp() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAtrzMscbOutpM() ;
                
                @Data(size=1)
                IString iAtrzMsdpOutp() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAtrzMsdpOutpM() ;
                
                @Data(size=1)
                IString iAtrzVcobOutp() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAtrzVcobOutpM() ;
                
                @Data(size=1)
                IString iAtrzMinfOutp() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAtrzMinfOutpM() ;
                
                @Data(size=1)
                IString iAtrzDpavOutp() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt iAtrzDpavOutpM() ;
                
            }
            
            public interface AreaCativosOutp extends IDataStruct {
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal mSldoRetd() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nsRetzSldo() ;
                
                @Data(size=10)
                IString zLibertacao() ;
                
            }
            
            public interface AreaStdTratErros extends IDataStruct {
                
                @Data(size=50)
                IString msgErrob() ;
                
                @Data(size=8)
                IString modOrigemErro() ;
                
                @Data(size=40)
                IString chAcesso() ;
                
                @Data(size=2)
                IString aAplErr() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cRtnoEvenSwal() ;
                @Data
                @Condition("005")
                ICondition erroDb2R00() ;
                @Data
                @Condition("004")
                ICondition warningDb2() ;
                @Data
                @Condition("102")
                ICondition dadosInvalidos() ;
                @Data
                @Condition("103")
                ICondition tabSemCampDef() ;
                @Data
                @Condition("104")
                ICondition indicadorInexist() ;
                @Data
                @Condition("105")
                ICondition accaoInexistente() ;
                @Data
                @Condition("106")
                ICondition erroSelThg00002() ;
                @Data
                @Condition("117")
                ICondition tabNaoExiste() ;
                @Data
                @Condition("170")
                ICondition inputMalFormatad() ;
                @Data
                @Condition("172")
                ICondition opcaoMalFormatad() ;
                @Data
                @Condition("173")
                ICondition opcaoInvalida() ;
                @Data
                @Condition("177")
                ICondition dataIncorrecta() ;
                @Data
                @Condition("181")
                ICondition prazoNaoExiste() ;
                @Data
                @Condition("501")
                ICondition inputInsuf() ;
                @Data
                @Condition("611")
                ICondition intervNExiste() ;
                @Data
                @Condition("658")
                ICondition qOccursInvalida() ;
                @Data
                @Condition("002")
                ICondition clienteNaoExiste() ;
                @Data
                @Condition("215")
                ICondition naoExitReg() ;
                @Data
                @Condition("506")
                ICondition clienteConfidencial() ;
                @Data
                @Condition("623")
                ICondition dadosIncompativeis() ;
                @Data
                @Condition("027")
                ICondition dadosInputInv() ;
                @Data
                @Condition("009")
                ICondition moedaNaoExiste() ;
                @Data
                @Condition("004")
                ICondition erroSelVhd01401() ;
                @Data
                @Condition("029")
                ICondition estMoedInNPerm() ;
                @Data
                @Condition("036")
                ICondition estMoedOutNPerm() ;
                @Data
                @Condition("014")
                ICondition autNaoExiste() ;
                @Data
                @Condition("034")
                ICondition erroSelVhw03301() ;
                @Data
                @Condition("030")
                ICondition dadosAutInv() ;
                @Data
                @Condition("032")
                ICondition txCambNaoExiste() ;
                @Data
                @Condition("002")
                ICondition accaoIncompSituacao() ;
                @Data
                @Condition("003")
                ICondition ctaNaoExiste() ;
                @Data
                @Condition("004")
                ICondition subcontaEncerrada() ;
                @Data
                @Condition("008")
                ICondition catNaoExiste() ;
                @Data
                @Condition("009")
                ICondition canalNPermitMov() ;
                @Data
                @Condition("010")
                ICondition mSldoDisponivelNeg() ;
                @Data
                @Condition("011")
                ICondition sldoCbloPositivo() ;
                @Data
                @Condition("012")
                ICondition mvNRespeitRemanesc() ;
                @Data
                @Condition("020")
                ICondition debitoInvalido() ;
                @Data
                @Condition("025")
                ICondition accaoInvalida() ;
                @Data
                @Condition("317")
                ICondition dataInvalida() ;
                @Data
                @Condition("390")
                ICondition dctvzOnlineNao() ;
                @Data
                @Condition("391")
                ICondition sldoCativarInsuf() ;
                @Data
                @Condition("424")
                ICondition cndzMovzInvalida() ;
                @Data
                @Condition("519")
                ICondition erroDadosInput() ;
                @Data
                @Condition("572")
                ICondition iPenalizacaoErr() ;
                @Data
                @Condition("573")
                ICondition qDiasPavs() ;
                @Data
                @Condition("574")
                ICondition montNaoDisp() ;
                @Data
                @Condition("576")
                ICondition errLimMov() ;
                @Data
                @Condition("578")
                ICondition reforzoNPos() ;
                @Data
                @Condition("611")
                ICondition iJstzInvalido() ;
                @Data
                @Condition("612")
                ICondition cJstzInvalido() ;
                @Data
                @Condition("615")
                ICondition inputMalFormatado() ;
                @Data
                @Condition("640")
                ICondition iEstSctaBaseInval() ;
                @Data
                @Condition("656")
                ICondition erroDb2R01() ;
                @Data
                @Condition("794")
                ICondition subcontaBloqueada() ;
                @Data
                @Condition("845")
                ICondition refExistente() ;
                @Data
                @Condition("955")
                ICondition sldoCbloNegativo() ;
                @Data
                @Condition("971")
                ICondition estornoNaoPossivel() ;
                @Data
                @Condition("979")
                ICondition dadosMalFormatados() ;
                @Data
                @Condition("-066")
                ICondition movInexis() ;
                @Data
                @Condition("-149")
                ICondition subctaNaoExiste() ;
                @Data
                @Condition("-150")
                ICondition utilSemAcesso() ;
                @Data
                @Condition("-151")
                ICondition creditoUtilizado() ;
                @Data
                @Condition("-259")
                ICondition dataValorInvalida() ;
                @Data
                @Condition("-266")
                ICondition valSubconta() ;
                @Data
                @Condition("-288")
                ICondition montanteInsufCred() ;
                
                
                @Data(size=8)
                IString nmTabela() ;
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cSqlcode() ;
                
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
                @Condition(" ")
                ICondition semErros() ;
                
                
            }
        }
    }
    
}
