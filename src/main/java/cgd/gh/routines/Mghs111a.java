package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl111a ;
import cgd.gh.routines.Mghs114a ;
import cgd.hy.routines.Mhyj100a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00102_MOVHST
 * DESCRICAO     : DEVOLVE A CHAVE COMPLETA DE JOURNAL
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS111A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs111a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl111a
     */
    @Data
    public abstract Bghl111a bghl111a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Tbsdhop00020Movdia1
     */
    @Data
    protected abstract Tbsdhop00020Movdia1 ht0020Movdia1() ;
    
    /**
     * @return instancia da classe Tbsdhop00021Movdia2
     */
    @Data
    protected abstract Tbsdhop00021Movdia2 ht0021Movdia2() ;
    
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
     * @return instancia da classe Mghs114a
     */
    @Data
    protected abstract Mghs114a hrMghs114a() ;
    
    /**
     * @return instancia da classe Mhyj100a
     */
    @Data
    protected abstract Mhyj100a hrMhyj100a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREA DE TRABALHO COMUM     ***
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
    @Condition("097")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("328")
    protected ICondition progMovJaEstornado ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    
    
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
    
    
    /**
     * @return instancia da classe local Bhok0002Tabelas
     */
    @Data
    protected abstract Bhok0002Tabelas bhok0002Tabelas() ;
    
    @Data(size=8, value="MHYJ100A")
    protected IString bhyk0002RotActTabAct ;
    
    /**
     * @return instancia da classe local WsDataToday
     */
    @Data
    protected abstract WsDataToday wsDataToday() ;
    
    /**
     * @return instancia da classe local WsDataDia
     */
    @Data
    protected abstract WsDataDia wsDataDia() ;
    
    @Data(size=26)
    protected IString wsTsInicio ;
    
    /**
     * @return instancia da classe local WTsInicio
     */
    @Data
    protected abstract WTsInicio wTsInicio() ;
    
    @Data(size=26)
    protected IString wsTsFim ;
    
    /**
     * @return instancia da classe local WTsFim
     */
    @Data
    protected abstract WTsFim wTsFim() ;
    
    @Data(size=26, value=" ")
    protected IString wsTimestamp ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl111a().dadosOutput().dadosErro().cRtnoEvenSwal().initialize() ;
        bghl111a().dadosOutput().dadosErro().cTipoErroBbn().initialize() ;
        bghl111a().dadosOutput().dadosErro().cSqlcode().initialize() ;
        if (bghl111a().dadosInput().subconta().cPaisIsoaCont().isEmpty() || 
            bghl111a().dadosInput().subconta().cBancCont().isEqual(0) || 
            bghl111a().dadosInput().subconta().cOeEgcCont().isEqual(0) || 
            bghl111a().dadosInput().subconta().nsRdclCont().isEqual(0) || 
            bghl111a().dadosInput().subconta().cMoedIsoScta().isEmpty() || 
            bghl111a().dadosInput().zMovimento().isEmpty() || 
            bghl111a().dadosInput().cMnemEgcOpex().isEmpty() || 
            bghl111a().dadosInput().cPaisIsoaOeOpx().isEmpty() || 
            bghl111a().dadosInput().cOeEgcOpex().isEqual(0) || 
            bghl111a().dadosInput().cUserid().isEmpty() || 
            bghl111a().dadosInput().nJourBbn().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (progOk.isTrue()) {
                wsDataToday().set(getTimeAsLong());
                wsDataDia().wAnoData().set(wsDataToday().wsAnoToday());
                wsDataDia().wMesData().set(wsDataToday().wsMesToday());
                wsDataDia().wDiaData().set(wsDataToday().wsDiaToday());
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
        if (bghl111a().dadosInput().zMovimento().isEqual(wsDataDia())) {
            a3100ObtemDadosHo() ;
        } else {
            a5200FormatarArea() ;
            if (progOk.isTrue()) {
                a5300AcedeTabGh() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a3100ObtemDadosHo() {
        /**
         * *----------------------------------------------------------------*
         */
        a3110ObtemTabMov() ;
        if (progOk.isTrue()) {
            a3120AcedeTabHo() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a3110ObtemTabMov() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhyj100a().bhyl100a().commarea().initialize() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().aAplicacao().set("HY");
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().cGrupTabAtiv().set("TABARQ");
        hrMhyj100a().run() ;
        if (!hrMhyj100a().bhyl100a().commarea().dadosSaida().semErros().isTrue()) {
            bghl111a().dadosOutput().dadosErro().cSqlcode().set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cSqlcode());
            progStatus.set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 
     */
    public void a3120AcedeTabHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hv02001Movdia1().movdia1().initialize() ;
        hv02001Movdia1().movdia1().cPaisIsoaCont().set(bghl111a().dadosInput().subconta().cPaisIsoaCont());
        hv02001Movdia1().movdia1().cBancCont().set(bghl111a().dadosInput().subconta().cBancCont());
        hv02001Movdia1().movdia1().cOeEgcCont().set(bghl111a().dadosInput().subconta().cOeEgcCont());
        hv02001Movdia1().movdia1().nsRdclCont().set(bghl111a().dadosInput().subconta().nsRdclCont());
        hv02001Movdia1().movdia1().vChkdCont().set(bghl111a().dadosInput().subconta().vChkdCont());
        hv02001Movdia1().movdia1().cTipoCont().set(bghl111a().dadosInput().subconta().cTipoCont());
        hv02001Movdia1().movdia1().cMoedIsoScta().set(bghl111a().dadosInput().subconta().cMoedIsoScta());
        hv02001Movdia1().movdia1().nsDeposito().set(bghl111a().dadosInput().subconta().nsDeposito());
        hv02001Movdia1().movdia1().zProcessamento().set(bghl111a().dadosInput().zMovimento());
        hv02001Movdia1().movdia1().cMnemEgcOpex().set(bghl111a().dadosInput().cMnemEgcOpex());
        hv02001Movdia1().movdia1().cPaisIsoaOeOpx().set(bghl111a().dadosInput().cPaisIsoaOeOpx());
        hv02001Movdia1().movdia1().cOeEgcOpex().set(bghl111a().dadosInput().cOeEgcOpex());
        hv02001Movdia1().movdia1().cUserid().set(bghl111a().dadosInput().cUserid());
        hv02001Movdia1().movdia1().nJourBbn().set(bghl111a().dadosInput().nJourBbn());
        if (hrMhyj100a().bhyl100a().commarea().dadosSaida().cImgGrupTab().isEqual(bhok0002Tabelas().bhok0002ConTabMov1())) {
            a3121AcedeTho20() ;
        } else {
            a3122AcedeTho21() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a3121AcedeTho20() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        ht0020Movdia1().openMghs111a366(hv02001Movdia1().movdia1()) ;
        if (ht0020Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            ht0020Movdia1().fetchMghs111a378(hv02001Movdia1().movdia1().nsMovimento(), hv02001Movdia1().movdia1().aAplicacao(), hv02001Movdia1().movdia1().nsJourBbn(), hv02001Movdia1().movdia1().nsJourBbnDtlh()) ;
            if (ht0020Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (ht0020Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
                ht0020Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl111a().dadosOutput().ghJourn().setIndex(1); ht0020Movdia1().getPersistenceCode() == PersistenceCode.NORMAL && bghl111a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl111a().dadosOutput().ghJourn().incIndex()) {
                bghl111a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                bghl111a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv02001Movdia1().movdia1().nsJourBbn());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv02001Movdia1().movdia1().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                ht0020Movdia1().fetchMghs111a414(hv02001Movdia1().movdia1().nsMovimento(), hv02001Movdia1().movdia1().aAplicacao(), hv02001Movdia1().movdia1().nsJourBbn(), hv02001Movdia1().movdia1().nsJourBbnDtlh()) ;
                if (ht0020Movdia1().getPersistenceCode() != PersistenceCode.NORMAL && 
                    ht0020Movdia1().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            ht0020Movdia1().closeMghs111a434() ;
            if (ht0020Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a3122AcedeTho21() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        ht0021Movdia2().openMghs111a448(hv02001Movdia1().movdia1()) ;
        if (ht0021Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C3
             */
            ht0021Movdia2().fetchMghs111a460(hv02001Movdia1().movdia1().nsMovimento(), hv02001Movdia1().movdia1().aAplicacao(), hv02001Movdia1().movdia1().nsJourBbn(), hv02001Movdia1().movdia1().nsJourBbnDtlh()) ;
            if (ht0021Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (ht0021Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
                ht0021Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl111a().dadosOutput().ghJourn().setIndex(1); ht0021Movdia2().getPersistenceCode() == PersistenceCode.NORMAL && bghl111a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl111a().dadosOutput().ghJourn().incIndex()) {
                bghl111a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
                bghl111a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv02001Movdia1().movdia1().aAplicacao());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv02001Movdia1().movdia1().nsJourBbn());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv02001Movdia1().movdia1().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C3
                 */
                ht0021Movdia2().fetchMghs111a496(hv02001Movdia1().movdia1().nsMovimento(), hv02001Movdia1().movdia1().aAplicacao(), hv02001Movdia1().movdia1().nsJourBbn(), hv02001Movdia1().movdia1().nsJourBbnDtlh()) ;
                if (ht0021Movdia2().getPersistenceCode() != PersistenceCode.NORMAL && 
                    ht0021Movdia2().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C3
             */
            ht0021Movdia2().closeMghs111a516() ;
            if (ht0021Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200FormatarArea() {
        /**
         * *----------------------------------------------------------------*
         */
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghl111a().dadosInput().subconta().cPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bghl111a().dadosInput().subconta().cBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghl111a().dadosInput().subconta().cOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghl111a().dadosInput().subconta().nsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghl111a().dadosInput().subconta().vChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghl111a().dadosInput().subconta().cTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghl111a().dadosInput().subconta().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghl111a().dadosInput().subconta().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl111a().dadosInput().zMovimento());
        wTsFim().wsDataFim().set(bghl111a().dadosInput().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv10201Movhstcpl().movhstcpl().cMnemEgcOpex().set(bghl111a().dadosInput().cMnemEgcOpex());
        hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx().set(bghl111a().dadosInput().cPaisIsoaOeOpx());
        hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(bghl111a().dadosInput().cOeEgcOpex());
        hv10201Movhstcpl().movhstcpl().cUserid().set(bghl111a().dadosInput().cUserid());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(bghl111a().dadosInput().nJourBbn());
    }
    
    /**
     * 
     * 
     */
    public void a5300AcedeTabGh() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv10201Movhstcpl().openMghs111a554(wsTsInicio, wsTsFim) ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv10201Movhstcpl().fetchMghs111a566() ;
            if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
                a3310AcederHstNormal() ;
            }
            if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl111a().dadosOutput().ghJourn().setIndex(1); hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NORMAL && bghl111a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl111a().dadosOutput().ghJourn().incIndex()) {
                bghl111a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
                bghl111a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv10201Movhstcpl().movhstcpl().aAplicacao());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv10201Movhstcpl().movhstcpl().nsJourBbn());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv10201Movhstcpl().fetchMghs111a602() ;
                if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv10201Movhstcpl().closeMghs111a622() ;
            if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a3310AcederHstNormal() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs114a().bghl114a().initialize() ;
        hrMghs114a().bghl114a().dadosInput().subconta().cPaisIsoaCont().set(bghl111a().dadosInput().subconta().cPaisIsoaCont());
        hrMghs114a().bghl114a().dadosInput().subconta().cBancCont().set(bghl111a().dadosInput().subconta().cBancCont());
        hrMghs114a().bghl114a().dadosInput().subconta().cOeEgcCont().set(bghl111a().dadosInput().subconta().cOeEgcCont());
        hrMghs114a().bghl114a().dadosInput().subconta().nsRdclCont().set(bghl111a().dadosInput().subconta().nsRdclCont());
        hrMghs114a().bghl114a().dadosInput().subconta().vChkdCont().set(bghl111a().dadosInput().subconta().vChkdCont());
        hrMghs114a().bghl114a().dadosInput().subconta().cTipoCont().set(bghl111a().dadosInput().subconta().cTipoCont());
        hrMghs114a().bghl114a().dadosInput().subconta().cMoedIsoScta().set(bghl111a().dadosInput().subconta().cMoedIsoScta());
        hrMghs114a().bghl114a().dadosInput().subconta().nsDeposito().set(bghl111a().dadosInput().subconta().nsDeposito());
        hrMghs114a().bghl114a().dadosInput().zMovimento().set(bghl111a().dadosInput().zMovimento());
        hrMghs114a().bghl114a().dadosInput().cMnemEgcOpex().set(bghl111a().dadosInput().cMnemEgcOpex());
        hrMghs114a().bghl114a().dadosInput().cPaisIsoaOeOpx().set(bghl111a().dadosInput().cPaisIsoaOeOpx());
        hrMghs114a().bghl114a().dadosInput().cOeEgcOpex().set(bghl111a().dadosInput().cOeEgcOpex());
        hrMghs114a().bghl114a().dadosInput().cUserid().set(bghl111a().dadosInput().cUserid());
        hrMghs114a().bghl114a().dadosInput().nJourBbn().set(bghl111a().dadosInput().nJourBbn());
        hrMghs114a().run() ;
        if (hrMghs114a().bghl114a().dadosOutput().dadosErro().semErros().isTrue()) {
            bghl111a().dadosOutput().ghJourn().resetIndex() ;
            for (hrMghs114a().bghl114a().dadosOutput().ghJourn().setIndex(1); hrMghs114a().bghl114a().dadosOutput().ghJourn().index().isLessOrEqual(10); hrMghs114a().bghl114a().dadosOutput().ghJourn().incIndex()) {
                bghl111a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hrMghs114a().bghl114a().dadosOutput().ghJourn().getCurrent().nsMovimento());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hrMghs114a().bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbn());
                bghl111a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hrMghs114a().bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh());
                bghl111a().dadosOutput().ghJourn().incIndex() ;
            }
        } else {
            progStatus.set(hrMghs114a().bghl114a().dadosOutput().dadosErro().cRtnoEvenSwal());
            bghl111a().dadosOutput().dadosErro().cSqlcode().set(hrMghs114a().bghl114a().dadosOutput().dadosErro().cSqlcode());
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
        bghl111a().dadosOutput().dadosErro().cRtnoEvenSwal().set(progStatus);
        bghl111a().dadosOutput().dadosErro().cSqlcode().set(getPersistenceCode());
        if (!progOk.isTrue()) {
            bghl111a().dadosOutput().dadosErro().erroFuncao().setTrue() ;
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
    
    public interface Bhok0002Tabelas extends IDataStruct {
        
        @Data(size=1, value="1")
        IInt bhok0002ConTabMov1() ;
        
        @Data(size=1, value="2")
        IInt bhok0002ConTabMov2() ;
        
    }
    
    public interface WsDataToday extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoToday() ;
        
        @Data(size=2)
        IInt wsMesToday() ;
        
        @Data(size=2)
        IInt wsDiaToday() ;
        
    }
    
    public interface WsDataDia extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaData() ;
        
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
}
