package cgd.ht.structures.link;

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
public interface Bhtl010a extends IDataStruct {
    
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHTL010A   AREA DE LIGACAO ENTRE A ARQUITECTURA E OS
     * PROGRAMAS APLICACIONAIS
     * *O BHTL011A E UM COPYBOOK A SEMALHANCA DESTE NO ENTANTO TEM
     * *O ULTIMO CAMPO NIVEL 02 QUE E UTILIZADO PARA A COMUNICACAO ENTRE*
     * *OS PROGRAMAS DE UMA OPERACAO PELA WAI
     * LOG DE ALTERAÇÕES:
     * PROCESSO ! DATA       ! DESCRIÇÃO
     * HT1304   !            ! REUTILIZAÇÃO CAMPO-LIVRE-5:
     * !            !            > I-TRNZ-CBLO
     * HT1398   !            ! REUTILIZAÇÃO CAMPO-LIVRE-6:
     * !            !            > C-TIPO-CLI
     * HT1476   !            ! REUTILIZAÇÃO CAMPO-LIVRE-7:
     * !            !            > I-ACAO-01
     * !            !            > I-TRNZ-SIMZ
     * !            !            > I-CNSL-LOG
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-10:
     * !            !            > I-DEBUG
     * HT2165   !            ! REUTILIZAÇÃO CAMPO-LIVRE-8:
     * !            !            > I-ALERTA
     * HT4156   ! 2013-07-10 ! ADAPTAÇÃO PARA CANAL PRESENCIAL-FASE 1
     * !            ! REUTILIZAÇÃO DE CAMPOS LIVRES PARA
     * !            ! CONTER VARIAVEIS DA AREA DE LIGACAO
     * !            ! NECESSARIA AO CANAL PRESENCIAL
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-1:
     * !            !            > I-TRCD-LST
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-3:
     * !            !            > C-PAIS-ISOA-OE-ORI
     * !            !            > C-MNEM-EGC-ORIG
     * !            !            > C-OE-EGC-ORIG
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-4:
     * !            !            > C-USID-VRTL
     * !            !            > A-APL-CANL
     * !            ! RENOMEACAO DO CAMPO-LIVRE-5:
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-8:
     * !            !            > I-PED-DAD
     * !            !            > I-TRUNC-FU
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-9:
     * !            !            > NS-SESSAO
     * !            !            > I-EXI-ATZ-JOUR-BBN
     * !            !            > Z-PRTC-JOUR-BBN
     * !            !            > C-PAIS-ISO-ALFN
     * !            !            > C-MNEM-EGC-UTL
     * !            !            > C-IDIO-ISO
     * !            !            > C-PERF-UTL-BBN
     * !            !            > I-ACES-CONT-STFF
     * !            !            > C-USID-ALCL
     * !            !            > CT-NVL-ATZ-BBN-LCL
     * !            !            > N-EMPREGADO
     * !            !            > C-USID-ACRL
     * !            !            > CT-NVL-ATZ-BBN-CRL
     * !            !            > I-UTL-GERX-CLI
     * !            !            > I-UTL-GERX-CONT
     * !            !            > C-BANCO-ORIG
     * !            !            > C-PAIS-ISA-OE-ACRL
     * !            !            > C-MNEM-EGC-ACRL
     * !            !            > C-OE-EGC-ACRL
     * !            !            > C-TERM-ACRL
     * !            !            > C-PAIS-ISA-OE-ALCL
     * !            !            > C-MNEM-EGC-ALCL
     * !            !            > C-OE-EGC-ALCL
     * !            !            > C-TERM-ALCL
     * !            !            > C-PLTF-LOCL
     * !            !            > C-MOED-PAIS-OPER
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-11:
     * !            !            > Q-CAMP-EST-TRNZ
     * !            ! REUTILIZAÇÃO CAMPO-LIVRE-12:
     * !            !            > CT-NVEL-ATRZ-BBN
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        @Data(size=4, signed=true, compression=COMP3)
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
        @Condition("L")
        ICondition portaLink() ;
        @Data
        @Condition("W")
        ICondition aWai() ;
        
        
        @Data(size=8, compression=COMP3)
        ILong zSessao() ;
        
        @Data(size=6, compression=COMP3)
        IInt hSessao() ;
        
        @Data(size=1)
        IString iOfflPlgd() ;
        @Data
        @Condition("S")
        ICondition offlPlgdSim() ;
        @Data
        @Condition("N")
        ICondition offlPlgdNao() ;
        
        
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
        
        
        @Data
        Mensagem mensagem() ;
        
        /**
         * *TERMINO DA MENSAGEM
         */
        @Data(size=4)
        IString cTerminal() ;
        
        @Data(size=2, signed=true, compression=COMP3)
        IInt nsJourBbn() ;
        
        @Data
        Assyncrono assyncrono() ;
        
        @Data(size=1, signed=true)
        IInt cImgTabJour() ;
        @Data
        @Condition("1")
        ICondition cJournal1() ;
        @Data
        @Condition("2")
        ICondition cJournal2() ;
        
        
        @Data(size=1, signed=true)
        IInt iTabJourMov() ;
        @Data
        @Condition("1")
        ICondition iJournal1() ;
        @Data
        @Condition("2")
        ICondition iJournal2() ;
        
        
        @Data(size=99)
        IString chvTabErro() ;
        
        @Data(size=2)
        IString cEibfn() ;
        
        @Data(size=6)
        IString cEibrcode() ;
        
        @Data(size=8)
        IString cEibrsrce() ;
        
        @Data
        Db2Log db2Log() ;
        
        @Data(size=8, signed=true, compression=COMP)
        ILong cEibresp() ;
        
        
        public interface Mensagem extends IDataStruct {
            
            @Data(size=4)
            IString cTransaccao() ;
            
            @Data(size=2)
            IString aAplicacao() ;
            
            @Data(size=5)
            IString cOpePcnp() ;
            
            @Data(size=15)
            IString xChavOpePcnp() ;
            
            @Data(size=4)
            IString cTipoCanlAces() ;
            
            @Data
            NEltnJourBbn nEltnJourBbn() ;
            
            @Data(size=20)
            IString cTermPcnp() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nSessTermPcnp() ;
            
            @Data(size=26)
            IString tsTrnzLocl() ;
            
            @Data(size=26)
            IString tsInicPrctCtrl() ;
            
            @Data(size=26)
            IString tsFimPrctCtrl() ;
            
            @Data(size=1)
            IString iTrnzEfcdOnln() ;
            
            @Data(size=1)
            IString iAccao() ;
            
            @Data(size=1)
            IString iCslzTrnz() ;
            
            @Data(size=1)
            IString cEstPrctReg() ;
            
            @Data(size=1)
            IString cTipSteOpePcnp() ;
            
            @Data(size=21)
            IString xIdSpteOpePcnp() ;
            
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
            
            @Data(size=11)
            IString cBancSwif() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoCblo() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoDpnl() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mSldoAtrd() ;
            
            /**
             * PARA QUE AS APLICACOES POSSAM EFECTUAR A CONTABILIZACAO ATRAVES*
             * DO NOVO MODELO CONTABILISTICO FOI NECESSARIO MODIFICAR AS DATAS*
             * PARA O FORMATO DATE
             */
            @Data(size=10)
            IString zMovimento() ;
            
            @Data(size=10)
            IString zValor() ;
            
            @Data(size=10)
            IString zCtlzJourBbn() ;
            
            @Data(size=3)
            IString cMoedIsoMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovimento() ;
            
            @Data(size=3)
            IString cOpczMenu() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli() ;
            
            @Data(size=3)
            IString cGranCli() ;
            
            @Data(size=10)
            IString cSegmCrm() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-1         PIC S9(15)V99 COMP-3.
             */
            @Data
            CampoLivre1 campoLivre1() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal campoLivre2() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-3         PIC X(10).
             */
            @Data
            CampoLivre3 campoLivre3() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-4         PIC X(10).
             */
            @Data
            CampoLivre4 campoLivre4() ;
            
            /**
             * O CAMPO-LIVRE-5 ESTA SER UTILIZADO PARA MOVER O INDICADOR DE
             * TRANSACCAO CONTABILISTICA
             * 10 BHTL010A-CAMPO-LIVRE-5         PIC X(01).
             */
            @Data
            CampoLivre5 campoLivre5() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-6         PIC X(01).
             */
            @Data(size=1)
            IString cTipoCli() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-7         PIC X(03).
             */
            @Data(size=1)
            IString iAccao01() ;
            @Data
            @Condition("V")
            ICondition x01Vizualizacao() ;
            @Data
            @Condition("C")
            ICondition x01Criacao() ;
            @Data
            @Condition("M")
            ICondition x01Modificacao() ;
            @Data
            @Condition("A")
            ICondition x01Anulacao() ;
            @Data
            @Condition("N")
            ICondition x01AnulNotrunc() ;
            
            
            @Data(size=1)
            IString iTrnzSimz() ;
            @Data
            @Condition("S")
            ICondition iTrnzSimzSim() ;
            @Data
            @Condition("N")
            ICondition iTrnzSimzNao() ;
            
            
            @Data(size=1)
            IString iCnslLog() ;
            @Data
            @Condition("S")
            ICondition iCnslLogSim() ;
            @Data
            @Condition("N")
            ICondition iCnslLogNao() ;
            
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-8         PIC X(03).
             */
            @Data(size=1)
            IString iAlerta() ;
            @Data
            @Condition("S")
            ICondition alertaSim() ;
            @Data
            @Condition("N")
            ICondition alertaNao() ;
            
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-8         PIC X(02).
             */
            @Data
            CampoLivre8 campoLivre8() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-9         PIC X(50).
             */
            @Data
            CampoLivre9 campoLivre9() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-10        PIC X(49).
             */
            @Data
            CampoLivre10 campoLivre10() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-10        PIC X(50).
             */
            @Data(size=1)
            IString iDebug() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-11        PIC S9(3)V9(7) COMP-3.
             */
            @Data
            CampoLivre11 campoLivre11() ;
            
            /**
             * 10 BHTL010A-CAMPO-LIVRE-12        PIC S9(3)V9(7) COMP-3.
             */
            @Data
            CampoLivre12 campoLivre12() ;
            
            @Data(size=3)
            IString cFamiProd() ;
            
            @Data(size=3)
            IString cProduto() ;
            
            @Data(size=4)
            IString cEvenOpel() ;
            
            @Data(size=5)
            IString cOpeBbn() ;
            
            @Data(size=10)
            IString cCpltMvopIcb() ;
            
            @Data(size=12, signed=true, compression=COMP3)
            ILong xIdMovCriv() ;
            
            @Data(size=1)
            IString iEstorno() ;
            @Data
            @Condition("S")
            ICondition anulDiaSim() ;
            @Data
            @Condition("N")
            ICondition anulDiaNao() ;
            
            
            @Data(size=15)
            IString xChvOpePcnpOri() ;
            
            @Data(size=3)
            IString cPaisIsoaOeEsn() ;
            
            @Data(size=3)
            IString cMnemEgcEstn() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcEstn() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbnTrnEsn() ;
            
            @Data(size=8)
            IString cUsidEstn() ;
            
            @Data(size=2)
            IString aAplErro() ;
            
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
            @Condition("AV")
            ICondition occurAviso() ;
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
            @Condition({ "AV", "FC", "  " })
            ICondition errosValidos() ;
            @Data
            @Condition({ "  ", "AV" })
            ICondition semErros() ;
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoSwal() ;
            
            @Data(size=4)
            IString cLclzErroPrg() ;
            
            @Data(size=8)
            IString nmPrgErro() ;
            
            @Data(size=100)
            IString xInfCplrErro() ;
            
            @Data(size=5)
            IString cRtnoSwalPcnp() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsVersMsg() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt qCterCmpMsgInp() ;
            
            @Data(size=7192)
            IString xMsgBbnIput() ;
            
            
            public interface NEltnJourBbn extends IDataStruct {
                
                @Data(size=10)
                IString zProcessamento() ;
                
                @Data(size=3)
                IString cPaisIsoaOeOpx() ;
                
                @Data(size=3)
                IString cMnemEgcOpex() ;
                
                @Data(size=4, signed=true, compression=COMP3)
                IInt cOeEgcOpex() ;
                
                @Data(size=8)
                IString cUserid() ;
                
                @Data(size=9, signed=true, compression=COMP3)
                ILong nJourBbn() ;
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-1         PIC S9(15)V99 COMP-3.
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre1 extends IDataStruct {
                
                @Data(size=17, decimal=2, signed=true, compression=COMP3)
                IDecimal iTrcdLst() ;
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-3         PIC X(10).
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre3 extends IDataStruct {
                
                @Data(size=3)
                IString cPaisIsoaOeOri() ;
                
                @Data(size=3)
                IString cMnemEgcOrig() ;
                
                @Data(size=4)
                IInt cOeEgcOrig() ;
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-4         PIC X(10).
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre4 extends IDataStruct {
                
                @Data(size=8)
                IString cUsidVrtl() ;
                
                @Data(size=2)
                IString aAplCanl() ;
                
            }
            
            
            /**
             * 
             * O CAMPO-LIVRE-5 ESTA SER UTILIZADO PARA MOVER O INDICADOR DE
             * TRANSACCAO CONTABILISTICA
             * 10 BHTL010A-CAMPO-LIVRE-5         PIC X(01).
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre5 extends IDataStruct {
                
                @Data(size=1)
                IString iTrnzCblo() ;
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-8         PIC X(02).
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre8 extends IDataStruct {
                
                @Data(size=1)
                IString iPedDad() ;
                @Data
                @Condition("S")
                ICondition iPedDadS() ;
                @Data
                @Condition("N")
                ICondition iPedDadN() ;
                
                
                @Data(size=1)
                IString iTruncFu() ;
                @Data
                @Condition("S")
                ICondition sTruncaFu() ;
                @Data
                @Condition("N")
                ICondition nTruncaFu() ;
                
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-9         PIC X(50).
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre9 extends IDataStruct {
                
                @Data(size=6)
                IInt nsSessao() ;
                
                @Data(size=1)
                IString iExiAtzJourBbn() ;
                
                @Data(size=10)
                IString zPrctJourBbn() ;
                
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
                
                @Data(size=8)
                IString cUsidAlcl() ;
                
                @Data(size=1)
                IString ctNvlAtzBbnLcl() ;
                
                @Data(size=6)
                IInt nEmpregado() ;
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-10        PIC X(49).
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre10 extends IDataStruct {
                
                @Data(size=8)
                IString cUsidAcrl() ;
                
                @Data(size=1)
                IString ctNvlAtzBbnCrl() ;
                
                @Data(size=1)
                IString iUtlGerxCli() ;
                
                @Data(size=1)
                IString iUtlGerxCont() ;
                
                @Data(size=4)
                IInt cBancoOrig() ;
                
                @Data(size=3)
                IString cPaisIsaOeAcrl() ;
                
                @Data(size=3)
                IString cMnemEgcAcrl() ;
                
                @Data(size=4)
                IInt cOeEgcAcrl() ;
                
                @Data(size=4)
                IString cTermAcrl() ;
                
                @Data(size=3)
                IString cPaisIsaOeAlcl() ;
                
                @Data(size=3)
                IString cMnemEgcAlcl() ;
                
                @Data(size=4)
                IInt cOeEgcAlcl() ;
                
                @Data(size=4)
                IString cTermAlcl() ;
                
                @Data(size=3)
                IString cPltfLocl() ;
                
                @Data(size=3)
                IString cMoedPaisOper() ;
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-11        PIC S9(3)V9(7) COMP-3.
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre11 extends IDataStruct {
                
                @Data(size=10, decimal=7, signed=true, compression=COMP3)
                IDecimal qCampEstTrnz() ;
                
            }
            
            
            /**
             * 
             * 10 BHTL010A-CAMPO-LIVRE-12        PIC S9(3)V9(7) COMP-3.
             * 
             * @version 2.0
             * 
             */
            public interface CampoLivre12 extends IDataStruct {
                
                @Data(size=1, rpadding=5)
                IString ctNvelAtrzBbn() ;
                
            }
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
            
            
            @Data(size=249)
            IString xAligTrnzAsin() ;
            
        }
        
        public interface Db2Log extends IDataStruct {
            
            @Data(size=16)
            IString nmTabela() ;
            
            @Data
            Sqlca sqlca() ;
            
            
            public interface Sqlca extends IDataStruct {
                
                @Data(size=8)
                IString xSqlcaid() ;
                
                @Data(size=9, signed=true, compression=COMP)
                ILong qSqlcabc() ;
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlcode() ;
                
                @Data(size=4, signed=true, compression=COMP)
                IInt qSqlerrml() ;
                
                @Data(size=70)
                IString xSqlerrmc() ;
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlerrd() ;
                
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
                
                @Data(size=8)
                IString xSqlext() ;
                
            }
        }
    }
    
}
