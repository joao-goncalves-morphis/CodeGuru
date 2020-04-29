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
import cgd.gh.structures.link.Bghl113a ;
import cgd.gh.routines.Mghs210a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00123_MOVHSTCP3
 * TGH00124_MOVHSTCP4
 * TGH00125_MOVHSTCP5
 * TGH00126_MOVHSTCP6
 * TGH00127_MOVHSTCP7
 * TGH00128_MOVHSTCP8
 * DESCRICAO     : OBTEM NS-MOVIMENTO ATRAVES DA CHAVE DE JOURN
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS113A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs113a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl113a
     */
    @Data
    public abstract Bghl113a bghl113a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhops16101Cvdpobfal
     */
    @Data
    protected abstract Vwsdhops16101Cvdpobfal hv16101Cvdpobfal() ;
    
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
    
    @Data(size=1, value=" ")
    protected IString wsCrtCriterio ;
    @Data
    @Condition({ "T", "O", "Q", "S", "P", "J" })
    protected ICondition criterioValido ;
    @Data
    @Condition("T")
    protected ICondition criterioCompleto ;
    @Data
    @Condition("O")
    protected ICondition criterioOnde ;
    @Data
    @Condition("Q")
    protected ICondition criterioQuem ;
    @Data
    @Condition("S")
    protected ICondition criterioSaldos ;
    @Data
    @Condition("P")
    protected ICondition criterioPosicao ;
    @Data
    @Condition("J")
    protected ICondition criterioJour ;
    
    
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
        bghl113a().cRetorno().initialize() ;
        bghl113a().cSqlcode().initialize() ;
        if (bghl113a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl113a().argumento().cBancCont().isEqual(0) || 
            bghl113a().argumento().cOeEgcCont().isEqual(0) || 
            bghl113a().argumento().nsRdclCont().isEqual(0) || 
            bghl113a().argumento().cMoedIsoScta().isEmpty() || 
            bghl113a().argumento().zMovimento().isEmpty() || 
            bghl113a().argumento().nJourBbn().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wTsInicio().wsDataInicio().set(bghl113a().argumento().zMovimento());
            wTsFim().wsDataFim().set(bghl113a().argumento().zMovimento());
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
        hrMghs210a().bghl210a().argumento().cPaisIsoaCont().set(bghl113a().argumento().cPaisIsoaCont());
        hrMghs210a().bghl210a().argumento().cBancCont().set(bghl113a().argumento().cBancCont());
        hrMghs210a().bghl210a().argumento().cOeEgcCont().set(bghl113a().argumento().cOeEgcCont());
        hrMghs210a().bghl210a().argumento().nsRdclCont().set(bghl113a().argumento().nsRdclCont());
        hrMghs210a().bghl210a().argumento().vChkdCont().set(bghl113a().argumento().vChkdCont());
        hrMghs210a().bghl210a().argumento().cTipoCont().set(bghl113a().argumento().cTipoCont());
        hrMghs210a().bghl210a().argumento().cMoedIsoScta().set(bghl113a().argumento().cMoedIsoScta());
        hrMghs210a().bghl210a().argumento().nsDeposito().set(bghl113a().argumento().nsDeposito());
        hrMghs210a().bghl210a().argumento().zaInicio().set(bghl113a().argumento().zMovimento().get(1, 4));
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
        filler02().wCOeContaBb().set(bghl113a().argumento().cOeEgcCont());
        filler02().wNsRadicalBb().set(bghl113a().argumento().nsRdclCont());
        filler02().wCheckDigBb().set(bghl113a().argumento().vChkdCont());
        filler02().wTipoBb().set(bghl113a().argumento().cTipoCont());
        wNContaMask().wCOeConta().set(filler02().wCOeContaBb());
        wNContaMask().wNsRadical().set(filler02().wNsRadicalBb().get(2, 6));
        wNContaMask().wCheckDig().set(filler02().wCheckDigBb());
        wNContaMask().wTipo().set(filler02().wTipoBb().get(2, 2));
        hv16101Cvdpobfal().cvdpobfal().nConta().set(wNConta);
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO16101_CVDPOBFAL
         */
        hv16101Cvdpobfal().selectMghs113a322() ;
        switch (hv16101Cvdpobfal().getPersistenceCode()) {
            case NORMAL:
                bghl113a().argumento().cPaisIsoaCont().set(hv16101Cvdpobfal().cvdpobfal().cPaisIsoaCont());
                bghl113a().argumento().cBancCont().set(hv16101Cvdpobfal().cvdpobfal().cBancCont());
                bghl113a().argumento().cOeEgcCont().set(hv16101Cvdpobfal().cvdpobfal().cOeEgcCont());
                bghl113a().argumento().nsRdclCont().set(hv16101Cvdpobfal().cvdpobfal().nsRdclCont());
                bghl113a().argumento().vChkdCont().set(hv16101Cvdpobfal().cvdpobfal().vChkdCont());
                bghl113a().argumento().cTipoCont().set(hv16101Cvdpobfal().cvdpobfal().cTipoCont());
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
        hv12301Movhstcp3().movhstcp3().cPaisIsoaCont().set(bghl113a().argumento().cPaisIsoaCont());
        hv12301Movhstcp3().movhstcp3().cBancCont().set(bghl113a().argumento().cBancCont());
        hv12301Movhstcp3().movhstcp3().cOeEgcCont().set(bghl113a().argumento().cOeEgcCont());
        hv12301Movhstcp3().movhstcp3().nsRdclCont().set(bghl113a().argumento().nsRdclCont());
        hv12301Movhstcp3().movhstcp3().vChkdCont().set(bghl113a().argumento().vChkdCont());
        hv12301Movhstcp3().movhstcp3().cTipoCont().set(bghl113a().argumento().cTipoCont());
        hv12301Movhstcp3().movhstcp3().cMoedIsoScta().set(bghl113a().argumento().cMoedIsoScta());
        hv12301Movhstcp3().movhstcp3().nsDeposito().set(bghl113a().argumento().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl113a().argumento().zMovimento());
        wTsFim().wsDataFim().set(bghl113a().argumento().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12301Movhstcp3().movhstcp3().cMnemEgcOpex().set(bghl113a().argumento().cMnemEgcOpex());
        hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx().set(bghl113a().argumento().cPaisIsoaOeOpx());
        hv12301Movhstcp3().movhstcp3().cOeEgcOpex().set(bghl113a().argumento().cOeEgcOpex());
        hv12301Movhstcp3().movhstcp3().cUserid().set(bghl113a().argumento().cUserid());
        hv12301Movhstcp3().movhstcp3().nJourBbn().set(bghl113a().argumento().nJourBbn());
        hv12301Movhstcp3().movhstcp3().nsJourBbn().set(bghl113a().argumento().nsJourBbn());
        hv12301Movhstcp3().movhstcp3().nsJourBbnDtlh().set(bghl113a().argumento().nsJourBbnDtlh());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs113a393(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl113a().detalhe().tsMovimento().set(hv12301Movhstcp3().movhstcp3().tsMovimento());
            bghl113a().detalhe().nsMovimento().set(hv12301Movhstcp3().movhstcp3().nsMovimento());
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
        hv12401Movhstcp4().movhstcp4().cPaisIsoaCont().set(bghl113a().argumento().cPaisIsoaCont());
        hv12401Movhstcp4().movhstcp4().cBancCont().set(bghl113a().argumento().cBancCont());
        hv12401Movhstcp4().movhstcp4().cOeEgcCont().set(bghl113a().argumento().cOeEgcCont());
        hv12401Movhstcp4().movhstcp4().nsRdclCont().set(bghl113a().argumento().nsRdclCont());
        hv12401Movhstcp4().movhstcp4().vChkdCont().set(bghl113a().argumento().vChkdCont());
        hv12401Movhstcp4().movhstcp4().cTipoCont().set(bghl113a().argumento().cTipoCont());
        hv12401Movhstcp4().movhstcp4().cMoedIsoScta().set(bghl113a().argumento().cMoedIsoScta());
        hv12401Movhstcp4().movhstcp4().nsDeposito().set(bghl113a().argumento().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl113a().argumento().zMovimento());
        wTsFim().wsDataFim().set(bghl113a().argumento().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12401Movhstcp4().movhstcp4().cMnemEgcOpex().set(bghl113a().argumento().cMnemEgcOpex());
        hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx().set(bghl113a().argumento().cPaisIsoaOeOpx());
        hv12401Movhstcp4().movhstcp4().cOeEgcOpex().set(bghl113a().argumento().cOeEgcOpex());
        hv12401Movhstcp4().movhstcp4().cUserid().set(bghl113a().argumento().cUserid());
        hv12401Movhstcp4().movhstcp4().nJourBbn().set(bghl113a().argumento().nJourBbn());
        hv12401Movhstcp4().movhstcp4().nsJourBbn().set(bghl113a().argumento().nsJourBbn());
        hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh().set(bghl113a().argumento().nsJourBbnDtlh());
        hv12401Movhstcp4().movhstcp4().nJourBbn().set(bghl113a().argumento().nJourBbn());
        hv12401Movhstcp4().movhstcp4().nsJourBbn().set(bghl113a().argumento().nsJourBbn());
        hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh().set(bghl113a().argumento().nsJourBbnDtlh());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs113a472(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl113a().detalhe().tsMovimento().set(hv12401Movhstcp4().movhstcp4().tsMovimento());
            bghl113a().detalhe().nsMovimento().set(hv12401Movhstcp4().movhstcp4().nsMovimento());
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
        hv12501Movhstcp5().movhstcp5().cPaisIsoaCont().set(bghl113a().argumento().cPaisIsoaCont());
        hv12501Movhstcp5().movhstcp5().cBancCont().set(bghl113a().argumento().cBancCont());
        hv12501Movhstcp5().movhstcp5().cOeEgcCont().set(bghl113a().argumento().cOeEgcCont());
        hv12501Movhstcp5().movhstcp5().nsRdclCont().set(bghl113a().argumento().nsRdclCont());
        hv12501Movhstcp5().movhstcp5().vChkdCont().set(bghl113a().argumento().vChkdCont());
        hv12501Movhstcp5().movhstcp5().cTipoCont().set(bghl113a().argumento().cTipoCont());
        hv12501Movhstcp5().movhstcp5().cMoedIsoScta().set(bghl113a().argumento().cMoedIsoScta());
        hv12501Movhstcp5().movhstcp5().nsDeposito().set(bghl113a().argumento().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl113a().argumento().zMovimento());
        wTsFim().wsDataFim().set(bghl113a().argumento().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12501Movhstcp5().movhstcp5().cMnemEgcOpex().set(bghl113a().argumento().cMnemEgcOpex());
        hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx().set(bghl113a().argumento().cPaisIsoaOeOpx());
        hv12501Movhstcp5().movhstcp5().cOeEgcOpex().set(bghl113a().argumento().cOeEgcOpex());
        hv12501Movhstcp5().movhstcp5().cUserid().set(bghl113a().argumento().cUserid());
        hv12501Movhstcp5().movhstcp5().nJourBbn().set(bghl113a().argumento().nJourBbn());
        hv12501Movhstcp5().movhstcp5().nsJourBbn().set(bghl113a().argumento().nsJourBbn());
        hv12501Movhstcp5().movhstcp5().nsJourBbnDtlh().set(bghl113a().argumento().nsJourBbnDtlh());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs113a548(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl113a().detalhe().tsMovimento().set(hv12501Movhstcp5().movhstcp5().tsMovimento());
            bghl113a().detalhe().nsMovimento().set(hv12501Movhstcp5().movhstcp5().nsMovimento());
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
        hv12601Movhstcp6().movhstcp6().cPaisIsoaCont().set(bghl113a().argumento().cPaisIsoaCont());
        hv12601Movhstcp6().movhstcp6().cBancCont().set(bghl113a().argumento().cBancCont());
        hv12601Movhstcp6().movhstcp6().cOeEgcCont().set(bghl113a().argumento().cOeEgcCont());
        hv12601Movhstcp6().movhstcp6().nsRdclCont().set(bghl113a().argumento().nsRdclCont());
        hv12601Movhstcp6().movhstcp6().vChkdCont().set(bghl113a().argumento().vChkdCont());
        hv12601Movhstcp6().movhstcp6().cTipoCont().set(bghl113a().argumento().cTipoCont());
        hv12601Movhstcp6().movhstcp6().cMoedIsoScta().set(bghl113a().argumento().cMoedIsoScta());
        hv12601Movhstcp6().movhstcp6().nsDeposito().set(bghl113a().argumento().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl113a().argumento().zMovimento());
        wTsFim().wsDataFim().set(bghl113a().argumento().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12601Movhstcp6().movhstcp6().cMnemEgcOpex().set(bghl113a().argumento().cMnemEgcOpex());
        hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx().set(bghl113a().argumento().cPaisIsoaOeOpx());
        hv12601Movhstcp6().movhstcp6().cOeEgcOpex().set(bghl113a().argumento().cOeEgcOpex());
        hv12601Movhstcp6().movhstcp6().cUserid().set(bghl113a().argumento().cUserid());
        hv12601Movhstcp6().movhstcp6().nJourBbn().set(bghl113a().argumento().nJourBbn());
        hv12601Movhstcp6().movhstcp6().nsJourBbn().set(bghl113a().argumento().nsJourBbn());
        hv12601Movhstcp6().movhstcp6().nsJourBbnDtlh().set(bghl113a().argumento().nsJourBbnDtlh());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs113a623(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl113a().detalhe().tsMovimento().set(hv12601Movhstcp6().movhstcp6().tsMovimento());
            bghl113a().detalhe().nsMovimento().set(hv12601Movhstcp6().movhstcp6().nsMovimento());
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
        hv12701Movhstcp7().movhstcp7().cPaisIsoaCont().set(bghl113a().argumento().cPaisIsoaCont());
        hv12701Movhstcp7().movhstcp7().cBancCont().set(bghl113a().argumento().cBancCont());
        hv12701Movhstcp7().movhstcp7().cOeEgcCont().set(bghl113a().argumento().cOeEgcCont());
        hv12701Movhstcp7().movhstcp7().nsRdclCont().set(bghl113a().argumento().nsRdclCont());
        hv12701Movhstcp7().movhstcp7().vChkdCont().set(bghl113a().argumento().vChkdCont());
        hv12701Movhstcp7().movhstcp7().cTipoCont().set(bghl113a().argumento().cTipoCont());
        hv12701Movhstcp7().movhstcp7().cMoedIsoScta().set(bghl113a().argumento().cMoedIsoScta());
        hv12701Movhstcp7().movhstcp7().nsDeposito().set(bghl113a().argumento().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl113a().argumento().zMovimento());
        wTsFim().wsDataFim().set(bghl113a().argumento().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12701Movhstcp7().movhstcp7().cMnemEgcOpex().set(bghl113a().argumento().cMnemEgcOpex());
        hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx().set(bghl113a().argumento().cPaisIsoaOeOpx());
        hv12701Movhstcp7().movhstcp7().cOeEgcOpex().set(bghl113a().argumento().cOeEgcOpex());
        hv12701Movhstcp7().movhstcp7().cUserid().set(bghl113a().argumento().cUserid());
        hv12701Movhstcp7().movhstcp7().nJourBbn().set(bghl113a().argumento().nJourBbn());
        hv12701Movhstcp7().movhstcp7().nsJourBbn().set(bghl113a().argumento().nsJourBbn());
        hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh().set(bghl113a().argumento().nsJourBbnDtlh());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs113a699(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl113a().detalhe().tsMovimento().set(hv12701Movhstcp7().movhstcp7().tsMovimento());
            bghl113a().detalhe().nsMovimento().set(hv12701Movhstcp7().movhstcp7().nsMovimento());
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
        hv12801Movhstcp8().movhstcp8().cPaisIsoaCont().set(bghl113a().argumento().cPaisIsoaCont());
        hv12801Movhstcp8().movhstcp8().cBancCont().set(bghl113a().argumento().cBancCont());
        hv12801Movhstcp8().movhstcp8().cOeEgcCont().set(bghl113a().argumento().cOeEgcCont());
        hv12801Movhstcp8().movhstcp8().nsRdclCont().set(bghl113a().argumento().nsRdclCont());
        hv12801Movhstcp8().movhstcp8().vChkdCont().set(bghl113a().argumento().vChkdCont());
        hv12801Movhstcp8().movhstcp8().cTipoCont().set(bghl113a().argumento().cTipoCont());
        hv12801Movhstcp8().movhstcp8().cMoedIsoScta().set(bghl113a().argumento().cMoedIsoScta());
        hv12801Movhstcp8().movhstcp8().nsDeposito().set(bghl113a().argumento().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl113a().argumento().zMovimento());
        wTsFim().wsDataFim().set(bghl113a().argumento().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv12801Movhstcp8().movhstcp8().cMnemEgcOpex().set(bghl113a().argumento().cMnemEgcOpex());
        hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx().set(bghl113a().argumento().cPaisIsoaOeOpx());
        hv12801Movhstcp8().movhstcp8().cOeEgcOpex().set(bghl113a().argumento().cOeEgcOpex());
        hv12801Movhstcp8().movhstcp8().cUserid().set(bghl113a().argumento().cUserid());
        hv12801Movhstcp8().movhstcp8().nJourBbn().set(bghl113a().argumento().nJourBbn());
        hv12801Movhstcp8().movhstcp8().nsJourBbn().set(bghl113a().argumento().nsJourBbn());
        hv12801Movhstcp8().movhstcp8().nsJourBbnDtlh().set(bghl113a().argumento().nsJourBbnDtlh());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs113a776(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl113a().detalhe().tsMovimento().set(hv12801Movhstcp8().movhstcp8().tsMovimento());
            bghl113a().detalhe().nsMovimento().set(hv12801Movhstcp8().movhstcp8().nsMovimento());
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
        bghl113a().cRetorno().set(progStatus);
        bghl113a().cSqlcode().set(getPersistenceCode());
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
