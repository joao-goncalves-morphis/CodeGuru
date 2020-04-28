package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl804a ;
import cgd.gh.routines.Mghs802a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghj801a ;
import cgd.hy.routines.Mhyj100a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * ASCENDENTE COM MONTANTES DE CRITERIO - DIA
 * ASCENDENTE SEM MONTANTES DE CRITERIO  - DIA
 * DESCENDENTES COM MONTANTES - DIA
 * DESCENDENTES SEM MONTANTES  - DIA
 * ASCENDENTE COM MONTANTES DE CRITERIO - DIA  -1
 * ASCENDENTE SEM MONTANTES DE CRITERIO  - DIA -1
 * DESCENDENTES COM MONTANTES - DIA -1
 * DESCENDENTES SEM MONTANTES  - DIA - 1
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : THO00020_MOVDIA1
 * THO00021_MOVDIA2
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS804A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs804a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl804a
     */
    @Data
    public abstract Bghl804a bghl804a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhops02001Movdia1
     */
    @Data
    protected abstract Vwsdhops02001Movdia1 hv02001Movdia1() ;
    
    /**
     * @return instancia da classe Vwsdhops02101Movdia2
     */
    @Data
    protected abstract Vwsdhops02101Movdia2 hv02101Movdia2() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs802a
     */
    @Data
    protected abstract Mghs802a hrMghs802a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    /**
     * @return instancia da classe Mghj801a
     */
    @Data
    protected abstract Mghj801a hrMghj801a() ;
    
    /**
     * @return instancia da classe Mhyj100a
     */
    @Data
    protected abstract Mhyj100a hrMhyj100a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    @Data(size=4, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("233")
    protected ICondition progDadosInvalidos ;
    @Data
    @Condition("049")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("328")
    protected ICondition progMovJaEstornado ;
    @Data
    @Condition("005")
    protected ICondition progDb2 ;
    
    
    @Data(size=2)
    protected IString wsCTipoTrttCont ;
    @Data
    @Condition("01")
    protected ICondition wsTrttDepOrdem ;
    @Data
    @Condition("02")
    protected ICondition wsTrttPoupanca ;
    @Data
    @Condition("03")
    protected ICondition wsTrttDepPrazo ;
    @Data
    @Condition("09")
    protected ICondition wsTrttDepEstru ;
    @Data
    @Condition("12")
    protected ICondition wsTrttDepObrig ;
    @Data
    @Condition("19")
    protected ICondition wsTrttCtaMarg ;
    @Data
    @Condition("26")
    protected ICondition wsTrttCashCarry ;
    @Data
    @Condition("27")
    protected ICondition wsTrttCtaVostr ;
    @Data
    @Condition("28")
    protected ICondition wsTrttCtaNostr ;
    @Data
    @Condition("32")
    protected ICondition wsTrttCtaInter ;
    
    
    @Data(size=2, value=" ")
    protected IString wCTipoErroBbn ;
    @Data
    @Condition(" ")
    protected ICondition wsSemErros ;
    @Data
    @Condition("A1")
    protected ICondition wsAbend ;
    @Data
    @Condition("A2")
    protected ICondition wsAbendDb2 ;
    @Data
    @Condition("A3")
    protected ICondition wsAbendCics ;
    @Data
    @Condition("FU")
    protected ICondition wsErrosFuncao ;
    @Data
    @Condition("AU")
    protected ICondition wsAutorizacao ;
    @Data
    @Condition("FC")
    protected ICondition wsFimConsulta ;
    
    
    @Data(size=2)
    protected IInt wsInd ;
    
    @Data(size=10, decimal=7, signed=true, value="0")
    protected IDecimal wTJuro ;
    
    @Data(size=2, value="GH")
    protected IString wsAplHst ;
    
    @Data(size=2, value="HO")
    protected IString wsAplHo ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtCriterio ;
    @Data
    @Condition("1")
    protected ICondition haCritMontantes ;
    @Data
    @Condition("2")
    protected ICondition naoHaCritMontantes ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtCriterio02 ;
    @Data
    @Condition("Z")
    protected ICondition criterioData ;
    @Data
    @Condition("N")
    protected ICondition criterioMovimento ;
    
    
    @Data(size=8, value="MHYJ100A")
    protected IString wsModMhyj100a ;
    
    @Data(size=1, value="1")
    protected IInt wsConTabMov1 ;
    
    @Data(size=1, value="2")
    protected IInt wsConTabMov2 ;
    
    /**
     * @return instancia da classe local WsVariaveisCrt
     */
    @Data
    protected abstract WsVariaveisCrt wsVariaveisCrt() ;
    
    @Data(size=8, value="MGHK800A")
    protected IString mgh800aCRotina ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString mghj801aCRotina ;
    
    @Data(size=1, value=" ")
    protected IString wsCrit1 ;
    
    @Data(size=1, value=" ")
    protected IString wsCrit2 ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMMovMin ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMMovMax ;
    
    /**
     * @return instancia da classe local WTsInicio
     */
    @Data
    protected abstract WTsInicio wTsInicio() ;
    
    /**
     * @return instancia da classe local WTsFim
     */
    @Data
    protected abstract WTsFim wTsFim() ;
    
    @Data(size=26, value=" ")
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WsVho02001
     */
    @Data
    protected abstract WsVho02001 wsVho02001() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl804a().cRetorno().initialize() ;
        bghl804a().cSqlcode().initialize() ;
        if (bghl804a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl804a().argumento().cBancCont().isEqual(0) || 
            bghl804a().argumento().cOeEgcCont().isEqual(0) || 
            bghl804a().argumento().nsRdclCont().isEqual(0) || 
            bghl804a().argumento().cMoedIsoScta().isEmpty() || 
            bghl804a().criterioConsulta().iCriterioCns().isEmpty() || 
            bghl804a().criterioDia().iMovDia().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            bghl804a().aAplErr().set(wsAplHst);
        }
        if (progOk.isTrue()) {
            if (!bghl804a().criterioConsulta().ascendente().isTrue() && !bghl804a().criterioConsulta().descendente().isTrue()) {
                progDadosInvalidos.setTrue() ;
                bghl804a().aAplErr().set(wsAplHst);
            }
        }
        if (progOk.isTrue()) {
            if (bghl804a().criterioMontante().mMovMax().isEqual(0) && 
                bghl804a().criterioMontante().mMovMin().isEqual(0)) {
                naoHaCritMontantes.setTrue() ;
            } else {
                haCritMontantes.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void s3000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        a5000ObterImgTabJour() ;
        if (progOk.isTrue()) {
            a5100FormatarArea() ;
        }
        if ((hrMhyj100a().bhyl100a().commarea().dadosSaida().cImgGrupTab().isEqual(wsConTabMov1) && 
            bghl804a().criterioDia().iMovDia().isEqual("S")) || 
            (hrMhyj100a().bhyl100a().commarea().dadosSaida().cImgGrupTab().isEqual(wsConTabMov2) && 
            bghl804a().criterioDia().iMovDia().isEqual("N"))) {
            if (bghl804a().criterioConsulta().ascendente().isTrue()) {
                if (haCritMontantes.isTrue()) {
                    a5200ListaAscMont20() ;
                } else {
                    a5300ListaAsc20() ;
                }
            } else if (bghl804a().criterioConsulta().descendente().isTrue()) {
                if (haCritMontantes.isTrue()) {
                    a5400ListaDscMont20() ;
                } else {
                    a5500ListaDsc20() ;
                }
            }
        } else if (bghl804a().criterioConsulta().ascendente().isTrue()) {
            if (haCritMontantes.isTrue()) {
                a5600ListaAscMont21() ;
            } else {
                a5700ListaAsc21() ;
            }
        } else if (bghl804a().criterioConsulta().descendente().isTrue()) {
            if (haCritMontantes.isTrue()) {
                a5800ListaDscMont21() ;
            } else {
                a5900ListaDsc21() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5000ObterImgTabJour() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhyj100a().bhyl100a().commarea().initialize() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().iOperacao().set("V");
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().aAplicacao().set("HY");
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().cGrupTabAtiv().set("TABARQ");
        hrMhyj100a().run() ;
        if (!hrMhyj100a().bhyl100a().commarea().dadosSaida().semErros().isTrue()) {
            progStatus.set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cRtnoEvenSwal());
            bghl804a().aAplErr().set(hrMhyj100a().bhyl100a().commarea().dadosSaida().aAplErr());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5100FormatarArea() {
        /**
         * *----------------------------------------------------------------*
         */
        hv02001Movdia1().movdia1().initialize() ;
        hv02001Movdia1().movdia1().cPaisIsoaCont().set(bghl804a().argumento().cPaisIsoaCont());
        hv02001Movdia1().movdia1().cBancCont().set(bghl804a().argumento().cBancCont());
        hv02001Movdia1().movdia1().cOeEgcCont().set(bghl804a().argumento().cOeEgcCont());
        hv02001Movdia1().movdia1().nsRdclCont().set(bghl804a().argumento().nsRdclCont());
        hv02001Movdia1().movdia1().vChkdCont().set(bghl804a().argumento().vChkdCont());
        hv02001Movdia1().movdia1().cTipoCont().set(bghl804a().argumento().cTipoCont());
        hv02001Movdia1().movdia1().cMoedIsoScta().set(bghl804a().argumento().cMoedIsoScta());
        hv02001Movdia1().movdia1().nsDeposito().set(bghl804a().argumento().nsDeposito());
        hv02001Movdia1().movdia1().nsMovimento().set(bghl804a().argumento().nsMovimento());
        if (bghl804a().criterioConsulta().descendente().isTrue()) {
            if (bghl804a().argumento().nsMovimento().isEqual(0)) {
                hv02001Movdia1().movdia1().nsMovimento().set(9);
            }
        }
        if (haCritMontantes.isTrue()) {
            wsMMovMin.set(bghl804a().criterioMontante().mMovMin());
            wsMMovMax.set(bghl804a().criterioMontante().mMovMax());
        }
        if (bghl804a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl804a().criterioDbcr().debito().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conDebito());
        } else {
            wsCrit1.set(wsVariaveisCrt().conCredito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200ListaAscMont20() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv02001Movdia1().openMghs804a1054(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2) ;
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02001Movdia1().fetchMghs804a1066() ;
            if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02001Movdia1().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02001Movdia1().fetchMghs804a1134() ;
                if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02001Movdia1().closeMghs804a1152() ;
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300ListaAsc20() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv02001Movdia1().openMghs804a1164(wsCrit1, wsCrit2) ;
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02001Movdia1().fetchMghs804a1176() ;
            if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02001Movdia1().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02001Movdia1().fetchMghs804a1243() ;
                if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02001Movdia1().closeMghs804a1261() ;
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400ListaDscMont20() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv02001Movdia1().openMghs804a1273(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2) ;
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C3
             */
            hv02001Movdia1().fetchMghs804a1285() ;
            if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02001Movdia1().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C3
                 */
                hv02001Movdia1().fetchMghs804a1353() ;
                if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C3
             */
            hv02001Movdia1().closeMghs804a1371() ;
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500ListaDsc20() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C4
         */
        hv02001Movdia1().openMghs804a1383(wsCrit1, wsCrit2) ;
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02001Movdia1().fetchMghs804a1395() ;
            if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02001Movdia1().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02001Movdia1().fetchMghs804a1463() ;
                if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02001Movdia1().closeMghs804a1481() ;
            if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5600ListaAscMont21() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C5
         */
        hv02101Movdia2().openMghs804a1493(hv02001Movdia1().movdia1(), wsMMovMin, wsMMovMax, wsCrit1, wsCrit2) ;
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C5
             */
            hv02101Movdia2().fetchMghs804a1505(hv02001Movdia1().movdia1()) ;
            if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02101Movdia2().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C5
                 */
                hv02101Movdia2().fetchMghs804a1573(hv02001Movdia1().movdia1()) ;
                if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C5
             */
            hv02101Movdia2().closeMghs804a1591() ;
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5700ListaAsc21() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C6
         */
        hv02101Movdia2().openMghs804a1603(hv02001Movdia1().movdia1(), wsCrit1, wsCrit2) ;
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C6
             */
            hv02101Movdia2().fetchMghs804a1615(hv02001Movdia1().movdia1()) ;
            if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02101Movdia2().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C6
                 */
                hv02101Movdia2().fetchMghs804a1684(hv02001Movdia1().movdia1()) ;
                if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C6
             */
            hv02101Movdia2().closeMghs804a1702() ;
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5800ListaDscMont21() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C7
         */
        hv02101Movdia2().openMghs804a1714(hv02001Movdia1().movdia1(), wsMMovMin, wsMMovMax, wsCrit1, wsCrit2) ;
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C7
             */
            hv02101Movdia2().fetchMghs804a1726(hv02001Movdia1().movdia1()) ;
            if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02101Movdia2().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C7
                 */
                hv02101Movdia2().fetchMghs804a1794(hv02001Movdia1().movdia1()) ;
                if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C7
             */
            hv02101Movdia2().closeMghs804a1812() ;
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5900ListaDsc21() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C8
         */
        hv02101Movdia2().openMghs804a1824(hv02001Movdia1().movdia1(), wsCrit1, wsCrit2) ;
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C8
             */
            hv02101Movdia2().fetchMghs804a1836(hv02001Movdia1().movdia1()) ;
            if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl804a().aAplErr().set(wsAplHo);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02101Movdia2().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVho02001().wsCPaisIsoaCont().set(hv02001Movdia1().movdia1().cPaisIsoaCont());
                wsVho02001().wsCBancCont().set(hv02001Movdia1().movdia1().cBancCont());
                wsVho02001().wsCOeEgcCont().set(hv02001Movdia1().movdia1().cOeEgcCont());
                wsVho02001().wsNsRdclCont().set(hv02001Movdia1().movdia1().nsRdclCont());
                wsVho02001().wsVChkdCont().set(hv02001Movdia1().movdia1().vChkdCont());
                wsVho02001().wsCTipoCont().set(hv02001Movdia1().movdia1().cTipoCont());
                wsVho02001().wsCMoedIsoScta().set(hv02001Movdia1().movdia1().cMoedIsoScta());
                wsVho02001().wsNsDeposito().set(hv02001Movdia1().movdia1().nsDeposito());
                wsVho02001().wsZMovimento().set(hv02001Movdia1().movdia1().zMovimento());
                wsVho02001().wsNsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                wsVho02001().wsZValMov().set(hv02001Movdia1().movdia1().zValor());
                wsVho02001().wsIDbcr().set(hv02001Movdia1().movdia1().iDbcr());
                wsVho02001().wsMMovimento().set(hv02001Movdia1().movdia1().mMovimento());
                wsVho02001().wsIEstorno().set(hv02001Movdia1().movdia1().iEstorno());
                wsVho02001().wsCMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
                wsVho02001().wsMSldoCbloApos().set(hv02001Movdia1().movdia1().mSldoCblo());
                wsVho02001().wsMSldoDpnlApos().set(hv02001Movdia1().movdia1().mSldoDpnl());
                wsVho02001().wsMMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
                wsVho02001().wsXRefMov().set(hv02001Movdia1().movdia1().xRefMov());
                if (wsVho02001().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                wsVho02001().wsTJuro().set(0);
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    a9300ObtemTaxa() ;
                }
                wsVho02001().wsNDocOpps().set(hv02001Movdia1().movdia1().nCheque());
                wsVho02001().wsAAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl804a().tabela().lista().get(wsInd).item().set(wsVho02001());
                bghl804a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C8
                 */
                hv02101Movdia2().fetchMghs804a1904(hv02001Movdia1().movdia1()) ;
                if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C8
             */
            hv02101Movdia2().closeMghs804a1922() ;
            if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a9100ObtemDescritivo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(bghl804a().argumento().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(bghl804a().argumento().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(bghl804a().argumento().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(bghl804a().argumento().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(bghl804a().argumento().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(bghl804a().argumento().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(bghl804a().argumento().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(bghl804a().argumento().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(hv02001Movdia1().movdia1().iDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(hv02001Movdia1().movdia1().iEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(hv02001Movdia1().movdia1().zValor());
        hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hv02001Movdia1().movdia1().cPaisIsoaOeOpx());
        hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hv02001Movdia1().movdia1().cMnemEgcOpex());
        hrMghk800a().bghl800a().input().cOeEgcOpex().set(hv02001Movdia1().movdia1().cOeEgcOpex());
        hrMghk800a().bghl800a().input().cOpeBbn().set(hv02001Movdia1().movdia1().cOpeBbn());
        hrMghk800a().run() ;
        log(TraceLevel.Trace, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno());
        if (hrMghk800a().bghl800a().ok().isTrue()) {
            wsVho02001().wsXRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
            wsCTipoTrttCont.set(hrMghk800a().bghl800a().output().cTipoTrttCont());
            log(TraceLevel.Error, "WS-X-REF-MOV-", hrMghk800a().bghl800a().output().xRefMov());
        } else {
            wsVho02001().wsXRefMov().set(" ");
            wsCTipoTrttCont.set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    public void a9200VerificaContaHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghj801a().bghl801a().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(bghl804a().argumento().cPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(bghl804a().argumento().cBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(bghl804a().argumento().cOeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(bghl804a().argumento().nsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(bghl804a().argumento().vChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(bghl804a().argumento().cTipoCont());
        hrMghj801a().bghl801a().argumento().cMoedIsoScta().set(bghl804a().argumento().cMoedIsoScta());
        hrMghj801a().bghl801a().argumento().nsDeposito().set(bghl804a().argumento().nsDeposito());
        if (hv02001Movdia1().movdia1().iEstorno().isEqual("E")) {
            if (hv02001Movdia1().movdia1().iDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(hv02001Movdia1().movdia1().iDbcr());
        }
        hrMghj801a().run() ;
        if (hrMghj801a().bghl801a().ok().isTrue()) {
            wsCTipoTrttCont.set(hrMghj801a().bghl801a().detalhe().cTipoTrttCont());
        } else {
            wsCTipoTrttCont.set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    public void a9300ObtemTaxa() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs802a().bghl802a().initialize() ;
        hrMghs802a().bghl802a().argumento().cPaisIsoaCont().set(bghl804a().argumento().cPaisIsoaCont());
        hrMghs802a().bghl802a().argumento().cBancCont().set(bghl804a().argumento().cBancCont());
        hrMghs802a().bghl802a().argumento().cOeEgcCont().set(bghl804a().argumento().cOeEgcCont());
        hrMghs802a().bghl802a().argumento().nsRdclCont().set(bghl804a().argumento().nsRdclCont());
        hrMghs802a().bghl802a().argumento().vChkdCont().set(bghl804a().argumento().vChkdCont());
        hrMghs802a().bghl802a().argumento().cTipoCont().set(bghl804a().argumento().cTipoCont());
        hrMghs802a().bghl802a().argumento().cMoedIsoScta().set(bghl804a().argumento().cMoedIsoScta());
        hrMghs802a().bghl802a().argumento().nsDeposito().set(bghl804a().argumento().nsDeposito());
        hrMghs802a().bghl802a().argumento().nsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
        hrMghs802a().run() ;
        if (hrMghs802a().bghl802a().ok().isTrue()) {
            wsVho02001().wsTJuro().set(hrMghs802a().bghl802a().detalhe().tJuro());
        } else {
            wsVho02001().wsTJuro().set(0);
        }
    }
    
    /**
     * 
     * 
     */
    public void s5000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl804a().cRetorno().set(progStatus);
        bghl804a().cSqlcode().set(getPersistenceCode());
        if (bghl804a().aAplErr().isEmpty()) {
            bghl804a().aAplErr().set("HO");
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         */
        s1000Iniciar() ;
        if (progOk.isTrue()) {
            s3000Processar() ;
        }
        s5000Responder() ;
        exit() ;
    }
    
    public interface WsVariaveisCrt extends IDataStruct {
        
        @Data(size=1, value="D")
        IString conDebito() ;
        
        @Data(size=1, value="C")
        IString conCredito() ;
        
        @Data(size=1, value="A")
        IString conDebCred() ;
        
    }
    
    public interface WTsInicio extends IDataStruct {
        
        @Data(size=10)
        IString wsDataInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
        IInt wsHoraInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsMinInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsSecInicio() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestInicio() ;
        
    }
    
    public interface WTsFim extends IDataStruct {
        
        @Data(size=10)
        IString wsDataFim() ;
        
        @Data(size=2, value="23", lpadding=1, lpaddingValue="-")
        IInt wsHoraFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsMinFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsSecFim() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestFim() ;
        
    }
    
    public interface WsVho02001 extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3)
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDeposito() ;
        
        @Data(size=10)
        IString wsZMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovimento() ;
        
        @Data(size=10)
        IString wsZValMov() ;
        
        @Data(size=1)
        IString wsIDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovimento() ;
        
        @Data(size=1)
        IString wsIEstorno() ;
        
        @Data(size=3)
        IString wsCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovMoeOrigMov() ;
        
        @Data(size=21)
        IString wsXRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong wsNDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal wsTJuro() ;
        
        @Data(size=2)
        IString wsAAplOrig() ;
        
    }
}
