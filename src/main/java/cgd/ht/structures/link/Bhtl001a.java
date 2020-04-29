package cgd.ht.structures.link;

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
public interface Bhtl001a extends IDataStruct {
    
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
     * BHTL001A   AREA DE LIGCAO ENTRE A ARQUITECTURA E OS
     * PROGRAMAS APLICACIONAIS
     * LOG DE ALTERAÇÕES:
     * PROCESSO ! DATA       ! DESCRIÇÃO
     * HT4156   !            ! REUTILIZAÇÃO CAMPO-LIVRE-1:
     * !            !            > I-TRCD-LST
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local Controlo
         */
        @Data
        Controlo controlo() ;
        
        /**
         * @return instancia da classe local Balcao
         */
        @Data
        Balcao balcao() ;
        
        /**
         * @return instancia da classe local IndicaCutiliza
         */
        @Data
        IndicaCutiliza indicaCutiliza() ;
        
        @Data(size=1)
        IString iTipoTrnzBbn() ;
        @Data
        @Condition("A")
        ICondition aberturaBalcao() ;
        @Data
        @Condition("B")
        ICondition aberturaSemUser() ;
        @Data
        @Condition("M")
        ICondition trnAposFechoBal() ;
        @Data
        @Condition("T")
        ICondition transacao() ;
        @Data
        @Condition("C")
        ICondition conversacao() ;
        
        
        /**
         * @return instancia da classe local Cct
         */
        @Data
        Cct cct() ;
        
        /**
         * @return instancia da classe local Mensagem
         */
        @Data
        Mensagem mensagem() ;
        
        /**
         * @return instancia da classe local Journal
         */
        @Data
        Journal journal() ;
        
        /**
         * @return instancia da classe local AutorizacoesNiv
         */
        @Data
        AutorizacoesNiv autorizacoesNiv() ;
        
        /**
         * @return instancia da classe local Assyncrono
         */
        @Data
        Assyncrono assyncrono() ;
        
        /**
         * ****************** INICIO HT320 E HT321 **********************
         * 10 BHTL001A-X-ALIG-TRNZ-ASIN        PIC  X(249).
         * @return instancia da classe local Header1
         */
        @Data
        Header1 header1() ;
        
        /**
         * HEADER-2 FOI INCLUIDOS PARA UTILIZAOES FUTURAS
         * @return instancia da classe local Header2
         */
        @Data
        Header2 header2() ;
        
        /**
         * CAMPO APLICACAO E OPCAO MENU ORIGEM
         * @return instancia da classe local Header3
         */
        @Data
        Header3 header3() ;
        
        /**
         * CAMPO BHTL001A-I-MSG-TRUD INCLUIDO A PEDIDO DA WAI
         */
        @Data(size=1)
        IString iMsgTrud() ;
        @Data
        @Condition("N")
        ICondition naoTruncada() ;
        @Data
        @Condition("S")
        ICondition truncada() ;
        
        
        /**
         * CAMPOS DE APLICAOES PARA DESCODIFICAR AUTORIZACOES
         * @return instancia da classe local AplicacoesAutoriz
         */
        @Data(length=15)
        IArray<AplicacoesAutoriz> aplicacoesAutoriz() ;
        
        @Data(size=102)
        IString filler() ;
        
        /**
         * ******************  FIM  HT320 E HT321 ***********************
         */
        @Data(size=2, signed=true, compression=COMP3)
        IInt qPgnCnslLstMax() ;
        
        @Data(size=1)
        IString iCexiApl() ;
        @Data
        @Condition("S")
        ICondition iCexiAplSim() ;
        @Data
        @Condition("N")
        ICondition iCexiAplNao() ;
        
        
        @Data(size=4)
        IString cTrnzProx() ;
        
        @Data(size=1, signed=true)
        IInt cImgTabJour() ;
        
        @Data(size=1, signed=true)
        IInt iTabJourMov() ;
        @Data
        @Condition("1")
        ICondition journal1() ;
        @Data
        @Condition("2")
        ICondition journal2() ;
        @Data
        @Condition("3")
        ICondition journal3() ;
        @Data
        @Condition("4")
        ICondition journal4() ;
        @Data
        @Condition("5")
        ICondition journalVespera() ;
        
        
        /**
         * @return instancia da classe local ErrosGraves
         */
        @Data
        ErrosGraves errosGraves() ;
        
        /**
         * @return instancia da classe local CicsLog
         */
        @Data
        CicsLog cicsLog() ;
        
        /**
         * @return instancia da classe local Db2Log
         */
        @Data
        Db2Log db2Log() ;
        
        @Data(size=8, signed=true, compression=COMP)
        ILong cEibresp() ;
        
        
        public interface Controlo extends IDataStruct {
            
            @Data(size=4, signed=true, compression=COMP)
            IInt qCterCmptMsg() ;
            
            @Data(size=1)
            IString iTipoOrigTrnz() ;
            @Data
            @Condition("E")
            ICondition ambiente3270() ;
            @Data
            @Condition("P")
            ICondition ambiente3600() ;
            @Data
            @Condition("T")
            ICondition ambienteTele() ;
            @Data
            @Condition("S")
            ICondition ambienteSibs() ;
            @Data
            @Condition("B")
            ICondition batch() ;
            @Data
            @Condition("M")
            ICondition mqseries() ;
            @Data
            @Condition("L")
            ICondition portaLink() ;
            
            
            @Data(size=8)
            ILong zSessao() ;
            
            @Data(size=6)
            IInt hSessao() ;
            
            @Data(size=1)
            IString iMsgPendEnvi() ;
            @Data
            @Condition("S")
            ICondition msgSim() ;
            @Data
            @Condition("N")
            ICondition msgNao() ;
            
            
        }
        
        public interface Balcao extends IDataStruct {
            
            @Data(size=1)
            IString iOfflPlgd() ;
            @Data
            @Condition("S")
            ICondition iOfflPlgdSim() ;
            @Data
            @Condition("N")
            ICondition iOfflPlgdNao() ;
            
            
        }
        
        public interface IndicaCutiliza extends IDataStruct {
            
            @Data(size=1)
            IString ctNvelAtrzBbn() ;
            
        }
        
        public interface Cct extends IDataStruct {
            
            @Data(size=1)
            IString iTrnAcsCtaStff() ;
            @Data
            @Condition("S")
            ICondition iTrnAcesSim() ;
            @Data
            @Condition("N")
            ICondition iTrnAcesNao() ;
            
            
            @Data(size=8)
            IString nmPrograma() ;
            
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
            
            
            @Data(size=1)
            IString iRstzAcesCli() ;
            @Data
            @Condition("0")
            ICondition iraCliNao() ;
            @Data
            @Condition("1")
            ICondition iraCliSim() ;
            @Data
            @Condition("2")
            ICondition iraCliValSim() ;
            @Data
            @Condition("3")
            ICondition iraCliValNao() ;
            
            
        }
        
        public interface Mensagem extends IDataStruct {
            
            @Data(size=221)
            IString header() ;
            
            /**
             * @return instancia da classe local HeaderR
             */
            @Data
            @Mask
            HeaderR headerR() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt qCterCmptAlig() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt qCampEstTrnz() ;
            
            @Data(size=1300)
            IString xMsgBbn() ;
            
            
            public interface HeaderR extends IDataMask {
                
                @Data(size=4)
                IString cTransaccao() ;
                
                /**
                 * @return instancia da classe local Transaccao
                 */
                @Data
                Transaccao transaccao() ;
                
                /**
                 * @return instancia da classe local NrElectronico
                 */
                @Data
                NrElectronico nrElectronico() ;
                
                @Data(size=6, signed=true, compression=COMP3)
                IInt nsSessao() ;
                
                @Data(size=1)
                IString iExiAtzJourBbn() ;
                @Data
                @Condition("0")
                ICondition semAut() ;
                @Data
                @Condition("1")
                ICondition comAut() ;
                @Data
                @Condition("3")
                ICondition comAutLoc() ;
                
                
                @Data(size=1)
                IString iPedDad() ;
                @Data
                @Condition("S")
                ICondition pedidoSim() ;
                @Data
                @Condition("N")
                ICondition pedidoNao() ;
                
                
                @Data(size=1)
                IString iTrnzSimz() ;
                @Data
                @Condition("S")
                ICondition simzSim() ;
                @Data
                @Condition("N")
                ICondition simzNao() ;
                
                
                /**
                 * @return instancia da classe local DatasProcesso
                 */
                @Data
                DatasProcesso datasProcesso() ;
                
                @Data(size=4)
                IString cTerminal() ;
                
                @Data(size=8)
                IString cUsidVrtl() ;
                
                /**
                 * @return instancia da classe local Seguranca
                 */
                @Data
                Seguranca seguranca() ;
                
                @Data(size=1)
                IString iTrnzEfcdOnln() ;
                @Data
                @Condition("1")
                ICondition trnOnLine() ;
                @Data
                @Condition("2")
                ICondition trnOffLine() ;
                
                
                @Data(size=1)
                IString iEstorno() ;
                @Data
                @Condition("S")
                ICondition anulDiaSim() ;
                @Data
                @Condition("N")
                ICondition anulDiaNao() ;
                
                
                /**
                 * @return instancia da classe local NrAnulacao
                 */
                @Data
                NrAnulacao nrAnulacao() ;
                
                @Data(size=3)
                IString cMnemEgcOrig() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOri() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcOrig() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cBanco() ;
                
                @Data(size=26)
                IString tsLocal() ;
                
                @Data(size=26)
                IString tsCentral() ;
                
                @Data(size=1)
                IString iTrnzCblo() ;
                @Data
                @Condition("S")
                ICondition iTrnzCbloSim() ;
                @Data
                @Condition("N")
                ICondition iTrnzCbloNao() ;
                
                
                
                public interface Transaccao extends IDataMask {
                    
                    @Data(size=2)
                    IString aAplicacao() ;
                    
                    @Data(size=3)
                    IString cOpczMenu() ;
                    
                    @Data(size=1)
                    IString iAccao() ;
                    @Data
                    @Condition("V")
                    ICondition vizualizacao() ;
                    @Data
                    @Condition("C")
                    ICondition criacao() ;
                    @Data
                    @Condition("M")
                    ICondition modificacao() ;
                    @Data
                    @Condition("A")
                    ICondition anulacao() ;
                    @Data
                    @Condition("N")
                    ICondition anulNotrunc() ;
                    
                    
                    @Data(size=4)
                    IString cTipoCanlAces() ;
                    
                }
                
                public interface NrElectronico extends IDataMask {
                    
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
                    
                }
                
                public interface DatasProcesso extends IDataMask {
                    
                    @Data(size=10)
                    IString zPrctJourBbn() ;
                    
                    @Data(size=10)
                    IString zCtlzJourBbn() ;
                    
                }
                
                public interface Seguranca extends IDataMask {
                    
                    @Data(size=3)
                    IString cPaisIsoAlfn() ;
                    
                    @Data(size=3)
                    IString cMnemEgcUtl() ;
                    
                    @Data(size=3)
                    IString cIdioIso() ;
                    
                    @Data(size=8)
                    IString cPerfUtlBbn() ;
                    
                    @Data(size=1)
                    IString iAcesContStff() ;
                    @Data
                    @Condition("S")
                    ICondition iAcesContStffS() ;
                    @Data
                    @Condition("N")
                    ICondition iAcesContStffN() ;
                    
                    
                    @Data(size=8)
                    IString cUsidAlcl() ;
                    
                    @Data(size=1)
                    IString ctNvlAtzBbnLcl() ;
                    
                    @Data(size=8)
                    IString cUsidAcrl() ;
                    
                    @Data(size=1)
                    IString ctNvlAtzBbnCrl() ;
                    
                    @Data(size=6, signed=true, compression=COMP3)
                    IInt nEmpregado() ;
                    
                    @Data(size=1)
                    IString iUltGerxCli() ;
                    
                    @Data(size=1)
                    IString iUltGerxCont() ;
                    
                }
                
                public interface NrAnulacao extends IDataMask {
                    
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
            }
        }
        
        public interface Journal extends IDataStruct {
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbn() ;
            
        }
        
        public interface AutorizacoesNiv extends IDataStruct {
            
            @Data(size=1)
            IInt ctNvlAtzBbn() ;
            
            @Data(size=3)
            IString cPaisIsoCtaAtz() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancAtrz() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContAtrz() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContAtrz() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContAtrz() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContAtrz() ;
            
            @Data(size=3)
            IString cMoedIsoSctaAtrz() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepositoAtrz() ;
            
            @Data(size=10)
            IString zValor() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoDpnl() ;
            
            @Data(size=3)
            IString cMoedIso() ;
            
        }
        
        public interface Assyncrono extends IDataStruct {
            
            @Data(size=1)
            IString iTipoPrctTrnz() ;
            @Data
            @Condition("S")
            ICondition iTipoPrctTrnzOn() ;
            @Data
            @Condition("A")
            ICondition iTipoPrctTrnzOff() ;
            
            
        }
        
        
        /**
         * 
         * ****************** INICIO HT320 E HT321 **********************
         * 10 BHTL001A-X-ALIG-TRNZ-ASIN        PIC  X(249).
         * 
         * @version 2.0
         * 
         */
        public interface Header1 extends IDataStruct {
            
            @Data(size=2)
            IString aAplCanl() ;
            
            @Data(size=12, signed=true, compression=COMP3)
            ILong xIdMovCriv() ;
            
            @Data(size=3)
            IString cPaisIsaOeAcrl() ;
            
            @Data(size=3)
            IString cMnemEgcAcrl() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcAcrl() ;
            
            @Data(size=4)
            IString cTermAcrl() ;
            
            @Data(size=3)
            IString cPaisIsaOeAlcl() ;
            
            @Data(size=3)
            IString cMnemEgcAlcl() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcAlcl() ;
            
            @Data(size=4)
            IString cTermAlcl() ;
            
            @Data(size=1)
            IString iMsgLong() ;
            @Data
            @Condition("S")
            ICondition iMsgSup1300Sim() ;
            @Data
            @Condition("N")
            ICondition iMsgSup1300Nao() ;
            
            
        }
        
        
        /**
         * 
         * HEADER-2 FOI INCLUIDOS PARA UTILIZAOES FUTURAS
         * 
         * @version 2.0
         * 
         */
        public interface Header2 extends IDataStruct {
            
            /**
             * 10 BHTL001A-CAMPO-LIVRE-1            PIC S9(15)V99 COMP-3.
             * @return instancia da classe local CampoLivre1
             */
            @Data
            CampoLivre1 campoLivre1() ;
            
            @Data(size=10)
            IString campoLivre2() ;
            
            @Data(size=1)
            IString campoLivre3() ;
            
            @Data(size=3)
            IString campoLivre4() ;
            
            @Data(size=50)
            IString campoLivre5() ;
            
            
            
            /**
             * 
             * 10 BHTL001A-CAMPO-LIVRE-1            PIC S9(15)V99 COMP-3.
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre1 extends IDataStruct {
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal iTrcdLst() ;
                
            }
        }
        
        
        /**
         * 
         * CAMPO APLICACAO E OPCAO MENU ORIGEM
         * 
         * @version 2.0
         * 
         */
        public interface Header3 extends IDataStruct {
            
            @Data(size=2)
            IString aAplOrig() ;
            
            @Data(size=3)
            IString cOpczMenuOrig() ;
            
            @Data(size=2)
            IInt nsJourBbnOut() ;
            
        }
        
        
        /**
         * 
         * CAMPOS DE APLICAOES PARA DESCODIFICAR AUTORIZACOES
         * 
         * @version 2.0
         * 
         */
        public interface AplicacoesAutoriz extends IDataStruct {
            
            @Data(size=2)
            IString aAplAutz() ;
            
        }
        
        public interface ErrosGraves extends IDataStruct {
            
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
            @Condition("AT")
            ICondition errosArq() ;
            @Data
            @Condition({ "FU", "AU", "  ", "FC", "FT", "BL" })
            ICondition errosValidos() ;
            @Data
            @Condition("FU")
            ICondition errosFuncao() ;
            @Data
            @Condition("FT")
            ICondition errosTele() ;
            @Data
            @Condition("AU")
            ICondition autorizacao() ;
            @Data
            @Condition("FC")
            ICondition fimConsulta() ;
            @Data
            @Condition("PF")
            ICondition pgmFuncao() ;
            @Data
            @Condition("NF")
            ICondition npgmFuncao() ;
            @Data
            @Condition("LP")
            ICondition limPaginas() ;
            @Data
            @Condition("BL")
            ICondition blif() ;
            @Data
            @Condition("  ")
            ICondition semErros() ;
            @Data
            @Condition({ "A1", "A2", "A3" })
            ICondition errosAbend() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
        }
        
        public interface CicsLog extends IDataStruct {
            
            @Data(size=2)
            IString cEibfn() ;
            
            @Data(size=6)
            IString cEibrcode() ;
            
            @Data(size=8)
            IString cEibrsrce() ;
            
        }
        
        public interface Db2Log extends IDataStruct {
            
            @Data(size=16)
            IString nmTabela() ;
            
            /**
             * @return instancia da classe local Sqlca
             */
            @Data
            Sqlca sqlca() ;
            
            
            public interface Sqlca extends IDataStruct {
                
                @Data(size=8)
                IString xSqlaid() ;
                
                @Data(size=9, signed=true, compression=COMP)
                ILong qSqlabc() ;
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlcode() ;
                
                /**
                 * @return instancia da classe local Sqlerrm
                 */
                @Data
                Sqlerrm sqlerrm() ;
                
                @Data(size=8)
                IString sqlerrp() ;
                
                /**
                 * @return instancia da classe local CSqlerrd
                 */
                @Data(length=6)
                IArray<CSqlerrd> cSqlerrd() ;
                
                /**
                 * @return instancia da classe local Sqlwarn
                 */
                @Data
                Sqlwarn sqlwarn() ;
                
                @Data(size=8)
                IString xSqlext() ;
                
                
                public interface Sqlerrm extends IDataStruct {
                    
                    @Data(size=4, signed=true, compression=COMP)
                    IInt qSqlerrml() ;
                    
                    @Data(size=70)
                    IString xSqlerrmc() ;
                    
                }
                
                public interface CSqlerrd extends IDataStruct {
                    
                    @Data(size=9, signed=true, compression=COMP)
                    ILong cSqlerrdItem() ;
                    
                }
                
                public interface Sqlwarn extends IDataStruct {
                    
                    @Data(size=1)
                    IString iSqlwarn0() ;
                    
                    @Data(size=1)
                    IString iSqlwarn1() ;
                    
                    @Data(size=1)
                    IString iSqlwarn2() ;
                    
                    @Data(size=1)
                    IString iSqlwarn3() ;
                    
                    @Data(size=1)
                    IString iSqlwarn4() ;
                    
                    @Data(size=1)
                    IString iSqlwarn5() ;
                    
                    @Data(size=1)
                    IString iSqlwarn6() ;
                    
                    @Data(size=1)
                    IString iSqlwarn7() ;
                    
                }
            }
        }
    }
    
}
