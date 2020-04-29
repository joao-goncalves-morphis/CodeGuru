package cgd.framework.envelope;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
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
public interface CgdMessageV2 extends IDataStruct {
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe local Mensagem
     */
    Mensagem mensagem() ;
    
    
    
    
    /**
     * 
     * 
     * @version 2.0
     * 
     */
    @Data
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
        
        /**
         * @return instancia da classe local NEltnJourBbn
         */
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
         * @return instancia da classe local CampoLivre1
         */
        @Data
        CampoLivre1 campoLivre1() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal campoLivre2() ;
        
        /**
         * 10 BHTL010A-CAMPO-LIVRE-3         PIC X(10).
         * @return instancia da classe local CampoLivre3
         */
        @Data
        CampoLivre3 campoLivre3() ;
        
        /**
         * 10 BHTL010A-CAMPO-LIVRE-4         PIC X(10).
         * @return instancia da classe local CampoLivre4
         */
        @Data
        CampoLivre4 campoLivre4() ;
        
        /**
         * O CAMPO-LIVRE-5 ESTA SER UTILIZADO PARA MOVER O INDICADOR DE
         * TRANSACCAO CONTABILISTICA
         * 10 BHTL010A-CAMPO-LIVRE-5         PIC X(01).
         * @return instancia da classe local CampoLivre5
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
         * @return instancia da classe local CampoLivre8
         */
        @Data
        CampoLivre8 campoLivre8() ;
        
        /**
         * 10 BHTL010A-CAMPO-LIVRE-9         PIC X(50).
         * @return instancia da classe local CampoLivre9
         */
        @Data
        CampoLivre9 campoLivre9() ;
        
        /**
         * 10 BHTL010A-CAMPO-LIVRE-10        PIC X(49).
         * @return instancia da classe local CampoLivre10
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
         * @return instancia da classe local CampoLivre11
         */
        @Data
        CampoLivre11 campoLivre11() ;
        
        /**
         * 10 BHTL010A-CAMPO-LIVRE-12        PIC S9(3)V9(7) COMP-3.
         * @return instancia da classe local CampoLivre12
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
}
