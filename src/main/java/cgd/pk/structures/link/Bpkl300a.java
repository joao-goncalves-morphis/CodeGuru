package cgd.pk.structures.link;

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
public interface Bpkl300a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MPKJ300A")
    IString cMpkj300a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE COMUNICACOES DA ROTINA MPUJ300A
     * TODOS OS DADOS RELATIVOS AH TABELA 1 E 2 DE PK'S
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
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=1)
            IString iAccaoTabBbn() ;
            @Data
            @Condition("V")
            ICondition visualizacao() ;
            @Data
            @Condition("C")
            ICondition insercao() ;
            @Data
            @Condition("M")
            ICondition modificacao() ;
            @Data
            @Condition("A")
            ICondition eliminacao() ;
            
            
            @Data(size=2)
            IInt iOperacao() ;
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=16)
            IString cRefMsgSwif() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwif() ;
            
            @Data(size=8)
            IString cUsidActzUlt() ;
            
            @Data(size=26)
            IString tsInsercao() ;
            
            @Data(size=26)
            IString tsActzUlt() ;
            
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=3)
            IString cPaisIsoAlfnS() ;
            
            @Data(size=3)
            IString cMnemEmpGcxS() ;
            
            @Data(size=16)
            IString cRefMsgSwifS() ;
            
            /**
             * TPK01
             */
            @Data(size=16, signed=true, compression=COMP3)
            ILong nsMsgSwif1() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoMsgSwif1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwif1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwifPrx1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwifAnt1() ;
            
            @Data(size=1)
            IString cTipoItvtOpag1() ;
            
            @Data(size=3)
            IString cTipLqzPgilOrm1() ;
            
            @Data(size=3)
            IString cTipLqzPgilDst1() ;
            
            @Data(size=3)
            IString cCnlEntdMovOpg1() ;
            
            @Data(size=3)
            IString cCnlSaiMovOpag1() ;
            
            @Data(size=1)
            IString cFrmLiqzOpag1() ;
            
            @Data(size=3)
            IString cTipOpeMsgSwif1() ;
            
            @Data(size=1)
            IString iOrdRcdPndSgoe1() ;
            
            @Data(size=1)
            IString iTipoPagOrdRcd1() ;
            
            @Data(size=1)
            IString iDstOrdPagSgoe1() ;
            
            @Data(size=16)
            IString cRefRldMsgSwif1() ;
            
            @Data(size=10)
            IString zValMsgSwif1() ;
            
            @Data(size=2)
            IString aAplOrig1() ;
            
            @Data(size=3)
            IString cOpczMenuOrig1() ;
            
            @Data(size=2)
            IString aAplDest1() ;
            
            @Data(size=3)
            IString cOpczMenuDest1() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcDest1() ;
            
            @Data(size=8)
            IString xIdEntEmixOpag1() ;
            
            @Data(size=8)
            IString xIdEntOrdnOpag1() ;
            
            @Data(size=20)
            IString nBeneSsocSibs1() ;
            
            @Data(size=3)
            IString cFamiProd1() ;
            
            @Data(size=3)
            IString cProduto1() ;
            
            @Data(size=4)
            IString cEvenOpel1() ;
            
            @Data(size=4)
            IString cSeveOpel1() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong nsMovimento1() ;
            
            @Data(size=4)
            IString cEvenOpelMov1() ;
            
            @Data(size=5)
            IString cOpeBbn1() ;
            
            @Data(size=2)
            IString aAplicacao1() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoSwal1() ;
            
            @Data(size=12, signed=true, compression=COMP3)
            ILong xIdMovCriv1() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt iFchoCpsz1() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsFichEntEmix1() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsMovFchEntEmi1() ;
            
            @Data(size=1)
            IString cTipMovFchEemi1() ;
            
            @Data(size=20)
            IString xRefMovOrnSibs1() ;
            
            @Data(size=1)
            IString iGrazCchq1() ;
            
            @Data(size=10)
            IString zEmis2vaPedDvz1() ;
            
            @Data(size=10)
            IString zProcessamento1() ;
            
            @Data(size=3)
            IString cMnemEgcOpex1() ;
            
            @Data(size=3)
            IString cPaisIsoaOeOpx1() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOpex1() ;
            
            @Data(size=8)
            IString cUserid1() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nJourBbn1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt nsJourBbn1() ;
            
            @Data(size=8)
            IString cUsidActzUlt1() ;
            
            @Data(size=26)
            IString tsInicTrttOpag1() ;
            
            @Data(size=26)
            IString tsInsercao1() ;
            
            @Data(size=26)
            IString tsActzUlt1() ;
            
            /**
             * TPK02
             */
            @Data(size=4)
            IString cOpeBancSwif2() ;
            
            @Data(size=2)
            IInt iMsgSwifCov() ;
            
            @Data(size=10)
            IString zEmisOpag2() ;
            
            @Data(size=10)
            IString zReczOpag2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt hpReczOpag2() ;
            
            @Data(size=10)
            IString zReczCbrtOpag2() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt zValOpeCbrtSwf2() ;
            
            @Data(size=10)
            IString zValCaldOpag2() ;
            
            @Data(size=10)
            IString zValOpag2() ;
            
            @Data(size=10)
            IString zCambio2() ;
            
            @Data(size=10)
            IString zDebito2() ;
            
            @Data(size=10)
            IString zDocumento2() ;
            
            @Data(size=1)
            IString iOrdRecdCtff2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambCald2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambio2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambEncg2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambEcgCtaBen2() ;
            
            @Data(size=3)
            IString cMoedIsoTrfc2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwif2() ;
            
            @Data(size=3)
            IString cMoedIsoCred2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovCredTot2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mPveiBasOpeEur2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mPveiEuroTot2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwifDvld2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCtrvEuroTot2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mLiqMsgSwifEur2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwfMoeCcdt2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCrddEuroSgoe2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCrddMoedCcdt2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCrddMoedCprn2() ;
            
            @Data(size=35)
            IString xInfOrdnLn012() ;
            
            @Data(size=35)
            IString xInfOrdnLn022() ;
            
            @Data(size=35)
            IString xInfBeneLn012() ;
            
            @Data(size=35)
            IString xInfBeneLn022() ;
            
            @Data(size=3)
            IString cPaisIsoaCont2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancCont2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCont2() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclCont2() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdCont2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoCont2() ;
            
            @Data(size=3)
            IString cMoedIsoScta2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDeposito2() ;
            
            @Data(size=1)
            IString iContEq2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcDestOpag2() ;
            
            @Data(size=11)
            IString cEndcSwifCbrt2() ;
            
            @Data(size=12)
            IString cSnamBancEmix2() ;
            
            @Data(size=11)
            IString cEndcSwifBemi2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancOrdn2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancDstn2() ;
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt cOpgt2() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cOpeSibs2() ;
            
            @Data(size=3)
            IString cPaisIsoaEmix2() ;
            
            @Data(size=3)
            IString cPaisIsoaDest2() ;
            
            @Data(size=12)
            IString cSnamBancBene2() ;
            
            @Data(size=12)
            IString cSnamBancDest2() ;
            
            @Data(size=11)
            IString cEndcSwifBdst2() ;
            
            @Data(size=11)
            IString cEndSwfCdtBemi2() ;
            
            @Data(size=1)
            IString cOpczTg53Swif2() ;
            
            @Data(size=11)
            IString cEndSwfCdtBben2() ;
            
            @Data(size=1)
            IString cOpczTg54Swif2() ;
            
            @Data(size=11)
            IString cEndcSwifBitm2() ;
            
            @Data(size=1)
            IString cOpczTg56Swif2() ;
            
            @Data(size=11)
            IString cEndSwfIttzCta2() ;
            
            @Data(size=1)
            IString cOpczTg57Swif2() ;
            
            @Data(size=11)
            IString cEndSwfIttzBen2() ;
            
            @Data(size=1)
            IString cOpczTg58Swif2() ;
            
            @Data(size=2)
            IString cTipoClrg2() ;
            
            @Data(size=23)
            IString cClearing2() ;
            
            @Data(size=1)
            IString iFrmtContBene2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoOpetBpor2() ;
            
            @Data(size=1)
            IString iNcssEnviCoe2() ;
            
            @Data(size=3)
            IString cTipoTrnzSwif2() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nCliente2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsAbraCli2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt iTipoItvt2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt nsTitc2() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong nAtrzCamb2() ;
            
            @Data(size=9, signed=true, compression=COMP3)
            ILong nsAtrzDeb2() ;
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nPrcpNcli2() ;
            
            @Data(size=8)
            IString cAcdoLvp2() ;
            
            @Data(size=16)
            IString cRefOrdCbrt2() ;
            
            @Data(size=16)
            IString cRefOrdRnvi2() ;
            
            @Data(size=16)
            IString cRefRldMsgSwif2() ;
            
            @Data(size=16)
            IString cRefRldBcdtSwf2() ;
            
            @Data(size=16)
            IString cRefOrdExrt2() ;
            
            @Data(size=16)
            IString cRefMsgSwifEmd2() ;
            
            @Data(size=10)
            IString zAnlzOrdPag2() ;
            
            @Data(size=10)
            IString zDvlzOrdPag2() ;
            
            @Data(size=10)
            IString zLiqzOrdPag2() ;
            
            @Data(size=10)
            IString zCrboCorr2() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cMtvoDvlzOpag2() ;
            
            @Data(size=1)
            IString iTipoPagDspa2() ;
            
            @Data(size=1)
            IString iTipoPagComs2() ;
            
            @Data(size=1)
            IString iTipoPagImp2() ;
            
            @Data(size=1)
            IString iCbrcJuroBckv2() ;
            
            @Data(size=4)
            IString cIstzOc01Swif2() ;
            
            @Data(size=30)
            IString xIstzOc01Swif2() ;
            
            @Data(size=4)
            IString cIstzOc02Swif2() ;
            
            @Data(size=30)
            IString xIstzOc02Swif2() ;
            
            @Data(size=4)
            IString cIstzOc03Swif2() ;
            
            @Data(size=30)
            IString xIstzOc03Swif2() ;
            
            @Data(size=3)
            IString cDtlhEncgSwif2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgCbdCliTot2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgEuro2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgMoedCprn2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgOrdnSwif2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mUtidMontT71g2() ;
            
            @Data(size=3)
            IString cPaisIsaCtaEcg2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContEncg2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContEncg2() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContEncg2() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContEncg2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContEncg2() ;
            
            @Data(size=3)
            IString cMoedIsoSctEcg2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepEncg2() ;
            
            @Data(size=3)
            IString cPaisIsoaBcdd2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cBancContBcdd2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcContBcdd2() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt nsRdclContBcdd2() ;
            
            @Data(size=1, signed=true, compression=COMP3)
            IInt vChkdContBcdd2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoContBcdd2() ;
            
            @Data(size=3)
            IString cMoeIsoCtaBcdd2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt nsDepContBcdd2() ;
            
            @Data(size=1)
            IString cTipoContSgoe2() ;
            
            @Data(size=1)
            IString cOpczTg50Swif2() ;
            
            @Data(size=1)
            IString cOpczTg52Swif2() ;
            
            @Data(size=1)
            IString cOpczTg59Swif2() ;
            
            @Data(size=1)
            IString iInfAdiTg50Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg52Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg53Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg54Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg56Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg57Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg58Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg59Swf2() ;
            
            @Data(size=1)
            IString iInfAdiTg70Swf2() ;
            
            @Data(size=1)
            IString iInfAdiT71fSwf2() ;
            
            @Data(size=1)
            IString iInfAdiT71gSwf2() ;
            
            @Data(size=1)
            IString iInfAdiTg72Swf2() ;
            
            @Data(size=1)
            IString iInfAdiT77bSwf2() ;
            
            @Data(size=1)
            IString iPedEslt2() ;
            
            @Data(size=1)
            IString iCliente2() ;
            
            @Data(size=1)
            IString iStp2() ;
            
            @Data(size=1)
            IString cTipoBeneOpag2() ;
            
            @Data(size=1)
            IString cTipoBanOrmOpg2() ;
            
            @Data(size=1)
            IString iDvlzOpag2() ;
            
            @Data(size=3)
            IString cFineOpeSgoe2() ;
            
            @Data(size=8)
            IString cUsidActzUlt2() ;
            
            @Data(size=26)
            IString tsInsercao2() ;
            
            @Data(size=26)
            IString tsActzUlt2() ;
            
            /**
             * ERROS
             */
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
            
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cRtnoEvenSwal() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cSqlcode() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            @Data(size=50)
            IString msgErrob() ;
            
            @Data(size=8)
            IString nmTabela() ;
            
            @Data(size=8)
            IString modOrigemErro() ;
            
            @Data(size=70)
            IString chAcesso() ;
            
        }
    }
    
}
