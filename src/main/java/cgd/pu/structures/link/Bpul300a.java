package cgd.pu.structures.link;

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
public interface Bpul300a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    @Data(size=8, value="MPUJ300A")
    IString cMpuj300a() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * AREA DE COMUNICACOES DA ROTINA MPUJ300A
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
            
            @Data(size=16, signed=true, compression=COMP3)
            ILong nsMsgSwf11() ;
            
            @Data(size=16, signed=true, compression=COMP3)
            ILong nsMsgSwf21() ;
            
            @Data(size=1)
            IString cTipoItvtOpag1() ;
            
            @Data(size=1)
            IString iTipRegMsgSwif1() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoMsgSwif1() ;
            
            @Data(size=4)
            IString cTipoCnlAcsOrm1() ;
            
            @Data(size=1)
            IString cFrmLiqzOpag1() ;
            
            @Data(size=3)
            IString cTipOpeMsgSwif1() ;
            
            @Data(size=16)
            IString cRefRldMsgSwif1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwif1() ;
            
            @Data(size=1)
            IString cTipoPedRgzOpg1() ;
            
            @Data(size=3)
            IString cTipLqzPagItrl1() ;
            
            @Data(size=10)
            IString zEmisOpag1() ;
            
            @Data(size=10)
            IString zValMsgSwif1() ;
            
            @Data(size=1)
            IString iMtvoEnviConf1() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwif1() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMovBcdtSwif1() ;
            
            @Data(size=3)
            IString cMoedIso1() ;
            
            @Data(size=2)
            IString aAplOrig1() ;
            
            @Data(size=1)
            IString cTipoRlhaOpag1() ;
            
            @Data(size=3)
            IString cOpczMenuOrig1() ;
            
            @Data(size=3)
            IString cOpczMenuDest1() ;
            
            @Data(size=3)
            IString cFamiProd1() ;
            
            @Data(size=3)
            IString cProduto1() ;
            
            @Data(size=4)
            IString cEvenOpel1() ;
            
            @Data(size=12, signed=true, compression=COMP3)
            ILong xIdMovCriv1() ;
            
            @Data(size=4)
            IString cSeveOpel1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt qCtfzEmid1() ;
            
            @Data(size=1)
            IString iOrdPagPrdc1() ;
            
            @Data(size=16)
            IString xRefTpltPgil1() ;
            
            @Data(size=20)
            IString xDescTpltRef1() ;
            
            @Data(size=26)
            IString hSaidOrdPag1() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcOrig1() ;
            
            @Data(size=1)
            IString cNvelItvzPrct1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwifPrx1() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cEstMsgSwifAnt1() ;
            
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
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsSessao1() ;
            
            @Data(size=26)
            IString tsInicTrttOpag1() ;
            
            @Data(size=8)
            IString cUsidActzUlt1() ;
            
            @Data(size=26)
            IString tsInsercao1() ;
            
            @Data(size=26)
            IString tsActzUlt1() ;
            
            @Data(size=4)
            IString cOpeBancSwif2() ;
            
            @Data(size=10)
            IString zValCaldOpag2() ;
            
            @Data(size=10)
            IString zValDeb2() ;
            
            @Data(size=10)
            IString zMovDebCli2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambCald2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambio2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambEncg2() ;
            
            @Data(size=11, decimal=6, signed=true, compression=COMP3)
            IDecimal tCambEcgCtaOrn2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mCbrdOrdnTot2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwifMoeOri2() ;
            
            @Data(size=3)
            IString cMoedIsoOrig2() ;
            
            @Data(size=1)
            IString iMontIstdOrdn2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mMsgSwifDvld2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcCrizOpag2() ;
            
            @Data(size=12)
            IString cSnamBancDest2() ;
            
            @Data(size=11)
            IString cEndcSwifBdst2() ;
            
            @Data(size=25)
            IString nmLocBbenSwif2() ;
            
            @Data(size=3)
            IString cPaisIsoaDest2() ;
            
            @Data(size=11)
            IString cEndSwfCdtBemi2() ;
            
            @Data(size=12)
            IString cSnamCpdtBemi2() ;
            
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
            
            @Data(size=8)
            IString xIdEntOrdnOpag2() ;
            
            @Data(size=6, signed=true, compression=COMP3)
            IInt nsFichEntOrdn2() ;
            
            @Data(size=20)
            IString xRefOpagEntOrn2() ;
            
            @Data(size=1)
            IString iFrmtContOrdn2() ;
            
            @Data(size=35)
            IString xInfOrdnLn012() ;
            
            @Data(size=1)
            IString iContOrdnEq2() ;
            
            @Data(size=20)
            IString xIdBeneOpag2() ;
            
            @Data(size=1)
            IString iFrmtContBene2() ;
            
            @Data(size=35)
            IString xInfBeneLn012() ;
            
            @Data(size=1)
            IString iContIbanIvld2() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt cOeEgcRctb2() ;
            
            @Data(size=1)
            IString iBancGcx2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cTipoOpetBpor2() ;
            
            @Data(size=3)
            IString cTipoTrnzSwif2() ;
            
            @Data(size=1)
            IString iTipoPagDspa2() ;
            
            @Data(size=1)
            IString iTipoPagImp2() ;
            
            @Data(size=1)
            IString iTipoPagComs2() ;
            
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
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong nPrcpNcli2() ;
            
            @Data(size=1)
            IString iAcdoLvp2() ;
            
            @Data(size=8)
            IString cAcdoLvp2() ;
            
            @Data(size=1)
            IString iAcdoDspaOur2() ;
            
            @Data(size=5, signed=true, compression=COMP3)
            IInt cOpgt2() ;
            
            @Data(size=6)
            IString cNormAdenOpgt2() ;
            
            @Data(size=3)
            IString cFichDestSibs2() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cServSibsTei2() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cOpeSibs2() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt cSectIttlBpor2() ;
            
            @Data(size=1)
            IString iNcssEnviCoe2() ;
            
            @Data(size=16)
            IString cRefRcnzMsgSwf2() ;
            
            @Data(size=10)
            IString zAnlzOrdPag2() ;
            
            @Data(size=10)
            IString zPedCcltOrdPag2() ;
            
            @Data(size=10)
            IString zDvlzOrdPag2() ;
            
            @Data(size=34)
            IString xIdContLiqz2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cCndMovzCtaOrn2() ;
            
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
            
            @Data(size=34)
            IString xIdContLiqzEcg2() ;
            
            @Data(size=3, signed=true, compression=COMP3)
            IInt cCndMovzCtaEcg2() ;
            
            @Data(size=17)
            IString xRefRetzSldEcg2() ;
            
            @Data(size=1)
            IString iTipoCtfzOutp2() ;
            
            @Data(size=17)
            IString xRefRetzSldo2() ;
            
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
            
            @Data(size=1)
            IString iEncgPrtdDtcb2() ;
            
            @Data(size=1)
            IString iCvrsCambDtcb2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgOrdnSwif2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgOrnMoeCta2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgOrnMoeTrf2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgBbenSwif2() ;
            
            @Data(size=15, decimal=2, signed=true, compression=COMP3)
            IDecimal mEncgBbenCtve2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mDspaTot2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mImpDspa2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mCtrvEuroTot2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mPveiBasOpeEur2() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal mPveiEuroTot2() ;
            
            @Data(size=1)
            IString cOpczTg50Swif2() ;
            
            @Data(size=11)
            IString cEndcSwifBemi2() ;
            
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
            IString iInfAdiTg72Swf2() ;
            
            @Data(size=1)
            IString iOpagUrgt2() ;
            
            @Data(size=1)
            IString iDestAplFnco2() ;
            
            @Data(size=1)
            IString iStp2() ;
            
            @Data(size=1)
            IString cTipoOrdnOpag2() ;
            
            @Data(size=1)
            IString cTipBanDstOpag2() ;
            
            @Data(size=3)
            IString cFrmCmczOpag2() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cMtvoAnlzOpag2() ;
            
            @Data(size=1)
            IString iRspeAnlzOpe2() ;
            
            @Data(size=2, signed=true, compression=COMP3)
            IInt cMtvDvzCpltOpg2() ;
            
            @Data(size=8)
            IString cUsidActzUlt2() ;
            
            @Data(size=26)
            IString tsInsercao2() ;
            
            @Data(size=26)
            IString tsActzUlt2() ;
            
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
