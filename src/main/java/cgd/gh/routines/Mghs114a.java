package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl114a ;
import cgd.gh.routines.Mghs210a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00123_MOVHSTCP3
 * TGH00124_MOVHSTCP4
 * TGH00125_MOVHSTCP5
 * TGH00126_MOVHSTCP6
 * TGH00127_MOVHSTCP7
 * TGH00128_MOVHSTCP8
 * DESCRICAO     : OBTEM RESTANTES DADOS DA CHAVE DE JOURN
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS114A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs114a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl114a
     */
    @Data
    public abstract Bghl114a bghl114a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps12301Movhstcp3
     */
    @Data
    protected abstract Vwsdghps12301Movhstcp3 hv12301Movhstcp3() ;
    
    /**
     * @return instancia da classe Vwsdghps12401Movhstcp4
     */
    @Data
    protected abstract Vwsdghps12401Movhstcp4 hv12401Movhstcp4() ;
    
    /**
     * @return instancia da classe Vwsdghps12501Movhstcp5
     */
    @Data
    protected abstract Vwsdghps12501Movhstcp5 hv12501Movhstcp5() ;
    
    /**
     * @return instancia da classe Vwsdghps12601Movhstcp6
     */
    @Data
    protected abstract Vwsdghps12601Movhstcp6 hv12601Movhstcp6() ;
    
    /**
     * @return instancia da classe Vwsdghps12701Movhstcp7
     */
    @Data
    protected abstract Vwsdghps12701Movhstcp7 hv12701Movhstcp7() ;
    
    /**
     * @return instancia da classe Vwsdghps12801Movhstcp8
     */
    @Data
    protected abstract Vwsdghps12801Movhstcp8 hv12801Movhstcp8() ;
    
    /**
     * @return instancia da classe Vwsdhops16101Cvdpobfal
     */
    @Data
    protected abstract Vwsdhops16101Cvdpobfal hv16101Cvdpobfal() ;
    
    /**
     * @return instancia da classe Vwsdghps02301Movhist3
     */
    @Data
    protected abstract Vwsdghps02301Movhist3 hv02301Movhist3() ;
    
    /**
     * @return instancia da classe Vwsdghps02401Movhist4
     */
    @Data
    protected abstract Vwsdghps02401Movhist4 hv02401Movhist4() ;
    
    /**
     * @return instancia da classe Vwsdghps02501Movhist5
     */
    @Data
    protected abstract Vwsdghps02501Movhist5 hv02501Movhist5() ;
    
    /**
     * @return instancia da classe Vwsdghps02601Movhist6
     */
    @Data
    protected abstract Vwsdghps02601Movhist6 hv02601Movhist6() ;
    
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    /**
     * @return instancia da classe Vwsdghps02801Movhist8
     */
    @Data
    protected abstract Vwsdghps02801Movhist8 hv02801Movhist8() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs210a
     */
    @Data
    protected abstract Mghs210a hrMghs210a() ;
    
    
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
    @Condition("066")
    protected ICondition progNaoExisMovHstAno ;
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
    
    
    @Data(size=3, value="0")
    protected IInt wCTipoConta ;
    @Data
    @Condition({ "30", "32" })
    protected ICondition cashCarry ;
    
    
    @Data(size=13)
    protected ILong wNConta ;
    
    /**
     * @return instancia da classe local WNContaMask
     */
    @Data
    @Mask
    protected abstract WNContaMask wNContaMask() ;
    
    /**
     * @return instancia da classe local Filler
     */
    @Data
    protected abstract Filler filler02() ;
    
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
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl114a().dadosOutput().dadosErro().cRtnoEvenSwal().initialize() ;
        bghl114a().dadosOutput().dadosErro().cTipoErroBbn().initialize() ;
        bghl114a().dadosOutput().dadosErro().cSqlcode().initialize() ;
        if (bghl114a().dadosInput().subconta().cPaisIsoaCont().isEmpty() || 
            bghl114a().dadosInput().subconta().cBancCont().isEqual(0) || 
            bghl114a().dadosInput().subconta().cOeEgcCont().isEqual(0) || 
            bghl114a().dadosInput().subconta().nsRdclCont().isEqual(0) || 
            bghl114a().dadosInput().subconta().cMoedIsoScta().isEmpty() || 
            bghl114a().dadosInput().zMovimento().isEmpty() || 
            bghl114a().dadosInput().cMnemEgcOpex().isEmpty() || 
            bghl114a().dadosInput().cPaisIsoaOeOpx().isEmpty() || 
            bghl114a().dadosInput().cOeEgcOpex().isEqual(0) || 
            bghl114a().dadosInput().cUserid().isEmpty() || 
            bghl114a().dadosInput().nJourBbn().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wTsInicio().wsDataInicio().set(bghl114a().dadosInput().zMovimento());
            wTsFim().wsDataFim().set(bghl114a().dadosInput().zMovimento());
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
        a5000DeterminarTabHst() ;
        if (progOk.isTrue()) {
            switch (hrMghs210a().bghl210a().detalhe().nmRecurso().get()) {
                case "VGH02301":
                    a5100AcederTgh00123() ;
                    break;
                case "VGH02401":
                    a5200AcederTgh00124() ;
                    break;
                case "VGH02501":
                    a5300AcederTgh00125() ;
                    break;
                case "VGH02601":
                    a5400AcederTgh00126() ;
                    break;
                case "VGH02701":
                    a5500AcederTgh00127() ;
                    break;
                case "VGH02801":
                    a5600AcederTgh00128() ;
                    break;
                default :
                    progNaoExisteMov.setTrue() ;
                    break;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5000DeterminarTabHst() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs210a().bghl210a().initialize() ;
        hrMghs210a().bghl210a().argumento().cPaisIsoaCont().set(bghl114a().dadosInput().subconta().cPaisIsoaCont());
        hrMghs210a().bghl210a().argumento().cBancCont().set(bghl114a().dadosInput().subconta().cBancCont());
        hrMghs210a().bghl210a().argumento().cOeEgcCont().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        hrMghs210a().bghl210a().argumento().nsRdclCont().set(bghl114a().dadosInput().subconta().nsRdclCont());
        hrMghs210a().bghl210a().argumento().vChkdCont().set(bghl114a().dadosInput().subconta().vChkdCont());
        hrMghs210a().bghl210a().argumento().cTipoCont().set(bghl114a().dadosInput().subconta().cTipoCont());
        hrMghs210a().bghl210a().argumento().cMoedIsoScta().set(bghl114a().dadosInput().subconta().cMoedIsoScta());
        hrMghs210a().bghl210a().argumento().nsDeposito().set(bghl114a().dadosInput().subconta().nsDeposito());
        hrMghs210a().bghl210a().argumento().zaInicio().set(bghl114a().dadosInput().zMovimento().get(1, 4));
        hrMghs210a().run() ;
        if (hrMghs210a().bghl210a().naoExisteConta().isTrue()) {
            if (cashCarry.isTrue()) {
                a5009AcederHo() ;
            } else {
                progNaoExisMovHstAno.setTrue() ;
            }
        }
        if (!hrMghs210a().bghl210a().naoExisteConta().isTrue() && !hrMghs210a().bghl210a().ok().isTrue()) {
            progStatus.set(hrMghs210a().bghl210a().cRetorno());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5009AcederHo() {
        /**
         * *----------------------------------------------------------------*
         */
        wCTipoConta.set(0);
        hv16101Cvdpobfal().cvdpobfal().initialize() ;
        filler02().wCOeContaBb().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        filler02().wNsRadicalBb().set(bghl114a().dadosInput().subconta().nsRdclCont());
        filler02().wCheckDigBb().set(bghl114a().dadosInput().subconta().vChkdCont());
        filler02().wTipoBb().set(bghl114a().dadosInput().subconta().cTipoCont());
        wNContaMask().wCOeConta().set(filler02().wCOeContaBb());
        wNContaMask().wNsRadical().set(filler02().wNsRadicalBb().get(2, 6));
        wNContaMask().wCheckDig().set(filler02().wCheckDigBb());
        wNContaMask().wTipo().set(filler02().wTipoBb().get(2, 2));
        hv16101Cvdpobfal().cvdpobfal().nConta().set(wNConta);
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO16101_CVDPOBFAL
         */
        hv16101Cvdpobfal().selectMghs114a508() ;
        switch (hv16101Cvdpobfal().getPersistenceCode()) {
            case NORMAL:
                bghl114a().dadosInput().subconta().cPaisIsoaCont().set(hv16101Cvdpobfal().cvdpobfal().cPaisIsoaCont());
                bghl114a().dadosInput().subconta().cBancCont().set(hv16101Cvdpobfal().cvdpobfal().cBancCont());
                bghl114a().dadosInput().subconta().cOeEgcCont().set(hv16101Cvdpobfal().cvdpobfal().cOeEgcCont());
                bghl114a().dadosInput().subconta().nsRdclCont().set(hv16101Cvdpobfal().cvdpobfal().nsRdclCont());
                bghl114a().dadosInput().subconta().vChkdCont().set(hv16101Cvdpobfal().cvdpobfal().vChkdCont());
                bghl114a().dadosInput().subconta().cTipoCont().set(hv16101Cvdpobfal().cvdpobfal().cTipoCont());
                a5000DeterminarTabHst() ;
                break;
            case NOTFND:
                progNaoExisMovHstAno.setTrue() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5100AcederTgh00123() {
        /**
         * *----------------------------------------------------------------*
         */
        hv12301Movhstcp3().movhstcp3().initialize() ;
        hv12301Movhstcp3().movhstcp3().cPaisIsoaCont().set(bghl114a().dadosInput().subconta().cPaisIsoaCont());
        hv12301Movhstcp3().movhstcp3().cBancCont().set(bghl114a().dadosInput().subconta().cBancCont());
        hv12301Movhstcp3().movhstcp3().cOeEgcCont().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        hv12301Movhstcp3().movhstcp3().nsRdclCont().set(bghl114a().dadosInput().subconta().nsRdclCont());
        hv12301Movhstcp3().movhstcp3().vChkdCont().set(bghl114a().dadosInput().subconta().vChkdCont());
        hv12301Movhstcp3().movhstcp3().cTipoCont().set(bghl114a().dadosInput().subconta().cTipoCont());
        hv12301Movhstcp3().movhstcp3().cMoedIsoScta().set(bghl114a().dadosInput().subconta().cMoedIsoScta());
        hv12301Movhstcp3().movhstcp3().nsDeposito().set(bghl114a().dadosInput().subconta().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl114a().dadosInput().zMovimento());
        wTsFim().wsDataFim().set(bghl114a().dadosInput().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12301Movhstcp3().movhstcp3().cMnemEgcOpex().set(bghl114a().dadosInput().cMnemEgcOpex());
        hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx().set(bghl114a().dadosInput().cPaisIsoaOeOpx());
        hv12301Movhstcp3().movhstcp3().cOeEgcOpex().set(bghl114a().dadosInput().cOeEgcOpex());
        hv12301Movhstcp3().movhstcp3().cUserid().set(bghl114a().dadosInput().cUserid());
        hv12301Movhstcp3().movhstcp3().nJourBbn().set(bghl114a().dadosInput().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv12301Movhstcp3().openMghs114a578(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv12301Movhstcp3().fetchMghs114a590() ;
            if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl114a().dadosOutput().ghJourn().setIndex(1); hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NORMAL && bghl114a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl114a().dadosOutput().ghJourn().incIndex()) {
                bghl114a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv12301Movhstcp3().movhstcp3().nsMovimento());
                bghl114a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv12301Movhstcp3().movhstcp3().aAplicacao());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv12301Movhstcp3().movhstcp3().nsJourBbn());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv12301Movhstcp3().movhstcp3().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv12301Movhstcp3().fetchMghs114a626() ;
                if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv12301Movhstcp3().closeMghs114a646() ;
            if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200AcederTgh00124() {
        /**
         * *----------------------------------------------------------------*
         */
        hv12401Movhstcp4().movhstcp4().initialize() ;
        hv12401Movhstcp4().movhstcp4().cPaisIsoaCont().set(bghl114a().dadosInput().subconta().cPaisIsoaCont());
        hv12401Movhstcp4().movhstcp4().cBancCont().set(bghl114a().dadosInput().subconta().cBancCont());
        hv12401Movhstcp4().movhstcp4().cOeEgcCont().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        hv12401Movhstcp4().movhstcp4().nsRdclCont().set(bghl114a().dadosInput().subconta().nsRdclCont());
        hv12401Movhstcp4().movhstcp4().vChkdCont().set(bghl114a().dadosInput().subconta().vChkdCont());
        hv12401Movhstcp4().movhstcp4().cTipoCont().set(bghl114a().dadosInput().subconta().cTipoCont());
        hv12401Movhstcp4().movhstcp4().cMoedIsoScta().set(bghl114a().dadosInput().subconta().cMoedIsoScta());
        hv12401Movhstcp4().movhstcp4().nsDeposito().set(bghl114a().dadosInput().subconta().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl114a().dadosInput().zMovimento());
        wTsFim().wsDataFim().set(bghl114a().dadosInput().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12401Movhstcp4().movhstcp4().cMnemEgcOpex().set(bghl114a().dadosInput().cMnemEgcOpex());
        hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx().set(bghl114a().dadosInput().cPaisIsoaOeOpx());
        hv12401Movhstcp4().movhstcp4().cOeEgcOpex().set(bghl114a().dadosInput().cOeEgcOpex());
        hv12401Movhstcp4().movhstcp4().cUserid().set(bghl114a().dadosInput().cUserid());
        hv12401Movhstcp4().movhstcp4().nJourBbn().set(bghl114a().dadosInput().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv12401Movhstcp4().openMghs114a683(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv12401Movhstcp4().fetchMghs114a695() ;
            if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl114a().dadosOutput().ghJourn().setIndex(1); hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NORMAL && bghl114a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl114a().dadosOutput().ghJourn().incIndex()) {
                bghl114a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv12401Movhstcp4().movhstcp4().nsMovimento());
                bghl114a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv12401Movhstcp4().movhstcp4().aAplicacao());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv12401Movhstcp4().movhstcp4().nsJourBbn());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv12401Movhstcp4().fetchMghs114a731() ;
                if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv12401Movhstcp4().closeMghs114a751() ;
            if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300AcederTgh00125() {
        /**
         * *----------------------------------------------------------------*
         */
        hv12501Movhstcp5().movhstcp5().initialize() ;
        hv12501Movhstcp5().movhstcp5().cPaisIsoaCont().set(bghl114a().dadosInput().subconta().cPaisIsoaCont());
        hv12501Movhstcp5().movhstcp5().cBancCont().set(bghl114a().dadosInput().subconta().cBancCont());
        hv12501Movhstcp5().movhstcp5().cOeEgcCont().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        hv12501Movhstcp5().movhstcp5().nsRdclCont().set(bghl114a().dadosInput().subconta().nsRdclCont());
        hv12501Movhstcp5().movhstcp5().vChkdCont().set(bghl114a().dadosInput().subconta().vChkdCont());
        hv12501Movhstcp5().movhstcp5().cTipoCont().set(bghl114a().dadosInput().subconta().cTipoCont());
        hv12501Movhstcp5().movhstcp5().cMoedIsoScta().set(bghl114a().dadosInput().subconta().cMoedIsoScta());
        hv12501Movhstcp5().movhstcp5().nsDeposito().set(bghl114a().dadosInput().subconta().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl114a().dadosInput().zMovimento());
        wTsFim().wsDataFim().set(bghl114a().dadosInput().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12501Movhstcp5().movhstcp5().cMnemEgcOpex().set(bghl114a().dadosInput().cMnemEgcOpex());
        hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx().set(bghl114a().dadosInput().cPaisIsoaOeOpx());
        hv12501Movhstcp5().movhstcp5().cOeEgcOpex().set(bghl114a().dadosInput().cOeEgcOpex());
        hv12501Movhstcp5().movhstcp5().cUserid().set(bghl114a().dadosInput().cUserid());
        hv12501Movhstcp5().movhstcp5().nJourBbn().set(bghl114a().dadosInput().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv12501Movhstcp5().openMghs114a789(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C3
             */
            hv12501Movhstcp5().fetchMghs114a801() ;
            if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl114a().dadosOutput().ghJourn().setIndex(1); hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NORMAL && bghl114a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl114a().dadosOutput().ghJourn().incIndex()) {
                bghl114a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv12501Movhstcp5().movhstcp5().nsMovimento());
                bghl114a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv12501Movhstcp5().movhstcp5().aAplicacao());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv12501Movhstcp5().movhstcp5().nsJourBbn());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv12501Movhstcp5().movhstcp5().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C3
                 */
                hv12501Movhstcp5().fetchMghs114a837() ;
                if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C3
             */
            hv12501Movhstcp5().closeMghs114a857() ;
            if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400AcederTgh00126() {
        /**
         * *----------------------------------------------------------------*
         */
        hv12601Movhstcp6().movhstcp6().initialize() ;
        hv12601Movhstcp6().movhstcp6().cPaisIsoaCont().set(bghl114a().dadosInput().subconta().cPaisIsoaCont());
        hv12601Movhstcp6().movhstcp6().cBancCont().set(bghl114a().dadosInput().subconta().cBancCont());
        hv12601Movhstcp6().movhstcp6().cOeEgcCont().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        hv12601Movhstcp6().movhstcp6().nsRdclCont().set(bghl114a().dadosInput().subconta().nsRdclCont());
        hv12601Movhstcp6().movhstcp6().vChkdCont().set(bghl114a().dadosInput().subconta().vChkdCont());
        hv12601Movhstcp6().movhstcp6().cTipoCont().set(bghl114a().dadosInput().subconta().cTipoCont());
        hv12601Movhstcp6().movhstcp6().cMoedIsoScta().set(bghl114a().dadosInput().subconta().cMoedIsoScta());
        hv12601Movhstcp6().movhstcp6().nsDeposito().set(bghl114a().dadosInput().subconta().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl114a().dadosInput().zMovimento());
        wTsFim().wsDataFim().set(bghl114a().dadosInput().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12601Movhstcp6().movhstcp6().cMnemEgcOpex().set(bghl114a().dadosInput().cMnemEgcOpex());
        hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx().set(bghl114a().dadosInput().cPaisIsoaOeOpx());
        hv12601Movhstcp6().movhstcp6().cOeEgcOpex().set(bghl114a().dadosInput().cOeEgcOpex());
        hv12601Movhstcp6().movhstcp6().cUserid().set(bghl114a().dadosInput().cUserid());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C4
         */
        hv12601Movhstcp6().openMghs114a895(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv12601Movhstcp6().fetchMghs114a907() ;
            if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl114a().dadosOutput().ghJourn().setIndex(1); hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NORMAL && bghl114a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl114a().dadosOutput().ghJourn().incIndex()) {
                bghl114a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv12601Movhstcp6().movhstcp6().nsMovimento());
                bghl114a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv12601Movhstcp6().movhstcp6().aAplicacao());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv12601Movhstcp6().movhstcp6().nsJourBbn());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv12601Movhstcp6().movhstcp6().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv12601Movhstcp6().fetchMghs114a943() ;
                if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv12601Movhstcp6().closeMghs114a963() ;
            if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500AcederTgh00127() {
        /**
         * *----------------------------------------------------------------*
         */
        hv12701Movhstcp7().movhstcp7().initialize() ;
        hv12701Movhstcp7().movhstcp7().cPaisIsoaCont().set(bghl114a().dadosInput().subconta().cPaisIsoaCont());
        hv12701Movhstcp7().movhstcp7().cBancCont().set(bghl114a().dadosInput().subconta().cBancCont());
        hv12701Movhstcp7().movhstcp7().cOeEgcCont().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        hv12701Movhstcp7().movhstcp7().nsRdclCont().set(bghl114a().dadosInput().subconta().nsRdclCont());
        hv12701Movhstcp7().movhstcp7().vChkdCont().set(bghl114a().dadosInput().subconta().vChkdCont());
        hv12701Movhstcp7().movhstcp7().cTipoCont().set(bghl114a().dadosInput().subconta().cTipoCont());
        hv12701Movhstcp7().movhstcp7().cMoedIsoScta().set(bghl114a().dadosInput().subconta().cMoedIsoScta());
        hv12701Movhstcp7().movhstcp7().nsDeposito().set(bghl114a().dadosInput().subconta().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl114a().dadosInput().zMovimento());
        wTsFim().wsDataFim().set(bghl114a().dadosInput().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12701Movhstcp7().movhstcp7().cMnemEgcOpex().set(bghl114a().dadosInput().cMnemEgcOpex());
        hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx().set(bghl114a().dadosInput().cPaisIsoaOeOpx());
        hv12701Movhstcp7().movhstcp7().cOeEgcOpex().set(bghl114a().dadosInput().cOeEgcOpex());
        hv12701Movhstcp7().movhstcp7().cUserid().set(bghl114a().dadosInput().cUserid());
        hv12701Movhstcp7().movhstcp7().nJourBbn().set(bghl114a().dadosInput().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C5
         */
        hv12701Movhstcp7().openMghs114a1000(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C5
             */
            hv12701Movhstcp7().fetchMghs114a1012() ;
            if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl114a().dadosOutput().ghJourn().setIndex(1); hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NORMAL && bghl114a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl114a().dadosOutput().ghJourn().incIndex()) {
                bghl114a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv12701Movhstcp7().movhstcp7().nsMovimento());
                bghl114a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv12701Movhstcp7().movhstcp7().aAplicacao());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv12701Movhstcp7().movhstcp7().nsJourBbn());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C5
                 */
                hv12701Movhstcp7().fetchMghs114a1048() ;
                if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C5
             */
            hv12701Movhstcp7().closeMghs114a1068() ;
            if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5600AcederTgh00128() {
        /**
         * *----------------------------------------------------------------*
         */
        hv12801Movhstcp8().movhstcp8().initialize() ;
        hv12801Movhstcp8().movhstcp8().cPaisIsoaCont().set(bghl114a().dadosInput().subconta().cPaisIsoaCont());
        hv12801Movhstcp8().movhstcp8().cBancCont().set(bghl114a().dadosInput().subconta().cBancCont());
        hv12801Movhstcp8().movhstcp8().cOeEgcCont().set(bghl114a().dadosInput().subconta().cOeEgcCont());
        hv12801Movhstcp8().movhstcp8().nsRdclCont().set(bghl114a().dadosInput().subconta().nsRdclCont());
        hv12801Movhstcp8().movhstcp8().vChkdCont().set(bghl114a().dadosInput().subconta().vChkdCont());
        hv12801Movhstcp8().movhstcp8().cTipoCont().set(bghl114a().dadosInput().subconta().cTipoCont());
        hv12801Movhstcp8().movhstcp8().cMoedIsoScta().set(bghl114a().dadosInput().subconta().cMoedIsoScta());
        hv12801Movhstcp8().movhstcp8().nsDeposito().set(bghl114a().dadosInput().subconta().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl114a().dadosInput().zMovimento());
        wTsFim().wsDataFim().set(bghl114a().dadosInput().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12801Movhstcp8().movhstcp8().cMnemEgcOpex().set(bghl114a().dadosInput().cMnemEgcOpex());
        hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx().set(bghl114a().dadosInput().cPaisIsoaOeOpx());
        hv12801Movhstcp8().movhstcp8().cOeEgcOpex().set(bghl114a().dadosInput().cOeEgcOpex());
        hv12801Movhstcp8().movhstcp8().cUserid().set(bghl114a().dadosInput().cUserid());
        hv12801Movhstcp8().movhstcp8().nJourBbn().set(bghl114a().dadosInput().nJourBbn());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C6
         */
        hv12801Movhstcp8().openMghs114a1107(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C6
             */
            hv12801Movhstcp8().fetchMghs114a1119() ;
            if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (bghl114a().dadosOutput().ghJourn().setIndex(1); hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NORMAL && bghl114a().dadosOutput().ghJourn().index().isLessOrEqual(10); bghl114a().dadosOutput().ghJourn().incIndex()) {
                bghl114a().dadosOutput().ghJourn().getCurrent().nsMovimento().set(hv12801Movhstcp8().movhstcp8().nsMovimento());
                bghl114a().dadosOutput().ghJourn().getCurrent().aAplicacao().set(hv12801Movhstcp8().movhstcp8().aAplicacao());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbn().set(hv12801Movhstcp8().movhstcp8().nsJourBbn());
                bghl114a().dadosOutput().ghJourn().getCurrent().nsJourBbnDtlh().set(hv12801Movhstcp8().movhstcp8().nsJourBbnDtlh());
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C6
                 */
                hv12801Movhstcp8().fetchMghs114a1155() ;
                if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C6
             */
            hv12801Movhstcp8().closeMghs114a1175() ;
            if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
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
        bghl114a().dadosOutput().dadosErro().cRtnoEvenSwal().set(progStatus);
        bghl114a().dadosOutput().dadosErro().cSqlcode().set(getPersistenceCode());
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
    
    public interface WNContaMask extends IDataMask {
        
        @Data(size=4)
        IInt wCOeConta() ;
        
        @Data(size=6)
        IInt wNsRadical() ;
        
        @Data(size=1)
        IInt wCheckDig() ;
        
        @Data(size=2)
        IInt wTipo() ;
        
    }
    
    public interface Filler extends IDataStruct {
        
        @Data(size=4)
        IInt wCOeContaBb() ;
        
        @Data(size=7)
        IInt wNsRadicalBb() ;
        
        @Data(size=1)
        IInt wCheckDigBb() ;
        
        @Data(size=3)
        IInt wTipoBb() ;
        
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
