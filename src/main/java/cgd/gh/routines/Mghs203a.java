package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl203a ;
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
 * DESCRICAO     : OBTEM DADOS DAS TABELAS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS203A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs203a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl203a
     */
    @Data
    public abstract Bghl203a bghl203a() ;
    
    
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
     * @return instancia da classe Vwsdghps02301Movhist3
     */
    @Data
    protected abstract Vwsdghps02301Movhist3 hv02301Movhist3() ;
    
    /**
     * @return instancia da classe Vwsdghps12401Movhstcp4
     */
    @Data
    protected abstract Vwsdghps12401Movhstcp4 hv12401Movhstcp4() ;
    
    /**
     * @return instancia da classe Vwsdghps02401Movhist4
     */
    @Data
    protected abstract Vwsdghps02401Movhist4 hv02401Movhist4() ;
    
    /**
     * @return instancia da classe Vwsdghps12501Movhstcp5
     */
    @Data
    protected abstract Vwsdghps12501Movhstcp5 hv12501Movhstcp5() ;
    
    /**
     * @return instancia da classe Vwsdghps02501Movhist5
     */
    @Data
    protected abstract Vwsdghps02501Movhist5 hv02501Movhist5() ;
    
    /**
     * @return instancia da classe Vwsdghps12601Movhstcp6
     */
    @Data
    protected abstract Vwsdghps12601Movhstcp6 hv12601Movhstcp6() ;
    
    /**
     * @return instancia da classe Vwsdghps02601Movhist6
     */
    @Data
    protected abstract Vwsdghps02601Movhist6 hv02601Movhist6() ;
    
    /**
     * @return instancia da classe Vwsdghps12701Movhstcp7
     */
    @Data
    protected abstract Vwsdghps12701Movhstcp7 hv12701Movhstcp7() ;
    
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    /**
     * @return instancia da classe Vwsdghps12801Movhstcp8
     */
    @Data
    protected abstract Vwsdghps12801Movhstcp8 hv12801Movhstcp8() ;
    
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
        bghl203a().cRetorno().initialize() ;
        bghl203a().cSqlcode().initialize() ;
        if (bghl203a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl203a().argumento().cBancCont().isEqual(0) || 
            bghl203a().argumento().cOeEgcCont().isEqual(0) || 
            bghl203a().argumento().nsRdclCont().isEqual(0) || 
            bghl203a().argumento().cMoedIsoScta().isEmpty() || 
            bghl203a().argumento().tsMovimento().isEmpty() || 
            bghl203a().argumento().nsMovimento().isEqual(0) || 
            bghl203a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl203a().criterioConsulta().iCriterioCns());
            if (!criterioValido.isTrue()) {
                progDadosInvalidos.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            wTsInicio().set(bghl203a().argumento().tsMovimento());
            wsTsInicio.set(bghl203a().argumento().tsMovimento());
            wCTipoConta.set(bghl203a().argumento().cTipoCont());
            wTsFim().wsDataFim().set(wTsInicio().wsDataInicio());
            wsTsFim.set(wTsFim());
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
        hrMghs210a().bghl210a().argumento().cPaisIsoaCont().set(bghl203a().argumento().cPaisIsoaCont());
        hrMghs210a().bghl210a().argumento().cBancCont().set(bghl203a().argumento().cBancCont());
        hrMghs210a().bghl210a().argumento().cOeEgcCont().set(bghl203a().argumento().cOeEgcCont());
        hrMghs210a().bghl210a().argumento().nsRdclCont().set(bghl203a().argumento().nsRdclCont());
        hrMghs210a().bghl210a().argumento().vChkdCont().set(bghl203a().argumento().vChkdCont());
        hrMghs210a().bghl210a().argumento().cTipoCont().set(bghl203a().argumento().cTipoCont());
        hrMghs210a().bghl210a().argumento().cMoedIsoScta().set(bghl203a().argumento().cMoedIsoScta());
        hrMghs210a().bghl210a().argumento().nsDeposito().set(bghl203a().argumento().nsDeposito());
        hrMghs210a().bghl210a().argumento().zaInicio().set(bghl203a().argumento().tsMovimento().get(1, 4));
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
        filler02().wCOeContaBb().set(bghl203a().argumento().cOeEgcCont());
        filler02().wNsRadicalBb().set(bghl203a().argumento().nsRdclCont());
        filler02().wCheckDigBb().set(bghl203a().argumento().vChkdCont());
        filler02().wTipoBb().set(bghl203a().argumento().cTipoCont());
        wNContaMask().wCOeConta().set(filler02().wCOeContaBb());
        wNContaMask().wNsRadical().set(filler02().wNsRadicalBb().get(2, 6));
        wNContaMask().wCheckDig().set(filler02().wCheckDigBb());
        wNContaMask().wTipo().set(filler02().wTipoBb().get(2, 2));
        hv16101Cvdpobfal().cvdpobfal().nConta().set(wNConta);
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO16101_CVDPOBFAL
         */
        hv16101Cvdpobfal().selectMghs203a333() ;
        switch (hv16101Cvdpobfal().getPersistenceCode()) {
            case NORMAL:
                bghl203a().argumento().cPaisIsoaCont().set(hv16101Cvdpobfal().cvdpobfal().cPaisIsoaCont());
                bghl203a().argumento().cBancCont().set(hv16101Cvdpobfal().cvdpobfal().cBancCont());
                bghl203a().argumento().cOeEgcCont().set(hv16101Cvdpobfal().cvdpobfal().cOeEgcCont());
                bghl203a().argumento().nsRdclCont().set(hv16101Cvdpobfal().cvdpobfal().nsRdclCont());
                bghl203a().argumento().vChkdCont().set(hv16101Cvdpobfal().cvdpobfal().vChkdCont());
                bghl203a().argumento().cTipoCont().set(hv16101Cvdpobfal().cvdpobfal().cTipoCont());
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
        hv12301Movhstcp3().movhstcp3().cPaisIsoaCont().set(bghl203a().argumento().cPaisIsoaCont());
        hv12301Movhstcp3().movhstcp3().cBancCont().set(bghl203a().argumento().cBancCont());
        hv12301Movhstcp3().movhstcp3().cOeEgcCont().set(bghl203a().argumento().cOeEgcCont());
        hv12301Movhstcp3().movhstcp3().nsRdclCont().set(bghl203a().argumento().nsRdclCont());
        hv12301Movhstcp3().movhstcp3().vChkdCont().set(bghl203a().argumento().vChkdCont());
        hv12301Movhstcp3().movhstcp3().cTipoCont().set(bghl203a().argumento().cTipoCont());
        hv12301Movhstcp3().movhstcp3().cMoedIsoScta().set(bghl203a().argumento().cMoedIsoScta());
        hv12301Movhstcp3().movhstcp3().nsDeposito().set(bghl203a().argumento().nsDeposito());
        hv12301Movhstcp3().movhstcp3().nsMovimento().set(bghl203a().argumento().nsMovimento());
        if (criterioCompleto.isTrue()) {
            a5110CriterioCompleto() ;
        } else if (criterioOnde.isTrue()) {
            a5120CriterioOnde() ;
        } else if (criterioQuem.isTrue()) {
            a5130CriterioQuem() ;
        } else if (criterioSaldos.isTrue()) {
            a5140CriterioSaldos() ;
        } else if (criterioPosicao.isTrue()) {
            a5150CriterioPosicao() ;
        } else if (criterioJour.isTrue()) {
            a5160CriterioJour() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5110CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs203a412(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12301Movhstcp3().movhstcp3().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12301Movhstcp3().movhstcp3().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12301Movhstcp3().movhstcp3().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12301Movhstcp3().movhstcp3().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12301Movhstcp3().movhstcp3().cEvenOpel());
            bghl203a().detalhe().cTerminal().set(hv12301Movhstcp3().movhstcp3().cTerminal());
            bghl203a().detalhe().cOperador().set(hv12301Movhstcp3().movhstcp3().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12301Movhstcp3().movhstcp3().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12301Movhstcp3().movhstcp3().cUserid());
            bghl203a().detalhe().cTipoCanlAces().set(hv12301Movhstcp3().movhstcp3().cTipoCanlAces());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12301Movhstcp3().movhstcp3().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12301Movhstcp3().movhstcp3().cOeEgcOpex());
            bghl203a().detalhe().cProdSgop().set(hv12301Movhstcp3().movhstcp3().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12301Movhstcp3().movhstcp3().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12301Movhstcp3().movhstcp3().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12301Movhstcp3().movhstcp3().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12301Movhstcp3().movhstcp3().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12301Movhstcp3().movhstcp3().cTipoIttz());
            bghl203a().detalhe().tCambio().set(hv12301Movhstcp3().movhstcp3().tCambio());
            bghl203a().detalhe().mSldoRetd().set(hv12301Movhstcp3().movhstcp3().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12301Movhstcp3().movhstcp3().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12301Movhstcp3().movhstcp3().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12301Movhstcp3().movhstcp3().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdUtid());
            bghl203a().detalhe().nJourBbn().set(hv12301Movhstcp3().movhstcp3().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12301Movhstcp3().movhstcp3().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12301Movhstcp3().movhstcp3().nsJourBbnDtlh());
            bghl203a().detalhe().nmArqvOrig().set(hv12301Movhstcp3().movhstcp3().nmArqvOrig());
            bghl203a().detalhe().tsActzUlt().set(hv12301Movhstcp3().movhstcp3().tsActzUlt());
            bghl203a().detalhe().cUsidActzUlt().set(hv12301Movhstcp3().movhstcp3().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5120CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs203a551(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTipoCanlAces().set(hv12301Movhstcp3().movhstcp3().cTipoCanlAces());
            bghl203a().detalhe().cTerminal().set(hv12301Movhstcp3().movhstcp3().cTerminal());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12301Movhstcp3().movhstcp3().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12301Movhstcp3().movhstcp3().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5130CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs203a604(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        /**
         * MOVE VGH12301-TS-ACTZ-ULT   TO MGH203A-TS-ACTZ-ULT
         */
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12301Movhstcp3().movhstcp3().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12301Movhstcp3().movhstcp3().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12301Movhstcp3().movhstcp3().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12301Movhstcp3().movhstcp3().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12301Movhstcp3().movhstcp3().cEvenOpel());
            bghl203a().detalhe().cOperador().set(hv12301Movhstcp3().movhstcp3().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12301Movhstcp3().movhstcp3().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12301Movhstcp3().movhstcp3().cUserid());
            bghl203a().detalhe().tCambio().set(hv12301Movhstcp3().movhstcp3().tCambio());
            bghl203a().detalhe().nmArqvOrig().set(hv12301Movhstcp3().movhstcp3().nmArqvOrig());
            a5131ObtemTsActTgh23() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5131ObtemTsActTgh23() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02301_MOVHIST3
         */
        hv02301Movhist3().selectMghs203a673(hv12301Movhstcp3().movhstcp3(), wsTsInicio, wsTsFim) ;
        switch (hv02301Movhist3().getPersistenceCode()) {
            case NORMAL:
                bghl203a().detalhe().tsActzUlt().set(hv02301Movhist3().movhist3().tsActzUlt());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
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
    public void a5140CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs203a706(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().mSldoRetd().set(hv12301Movhstcp3().movhstcp3().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12301Movhstcp3().movhstcp3().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12301Movhstcp3().movhstcp3().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12301Movhstcp3().movhstcp3().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5150CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs203a761(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cProdSgop().set(hv12301Movhstcp3().movhstcp3().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12301Movhstcp3().movhstcp3().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12301Movhstcp3().movhstcp3().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12301Movhstcp3().movhstcp3().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12301Movhstcp3().movhstcp3().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12301Movhstcp3().movhstcp3().cTipoIttz());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5160CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs203a815(wsTsInicio, wsTsFim) ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12301Movhstcp3().movhstcp3().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12301Movhstcp3().movhstcp3().cOeEgcOpex());
            bghl203a().detalhe().cUserid().set(hv12301Movhstcp3().movhstcp3().cUserid());
            bghl203a().detalhe().nJourBbn().set(hv12301Movhstcp3().movhstcp3().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12301Movhstcp3().movhstcp3().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12301Movhstcp3().movhstcp3().nsJourBbnDtlh());
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
        hv12401Movhstcp4().movhstcp4().cPaisIsoaCont().set(bghl203a().argumento().cPaisIsoaCont());
        hv12401Movhstcp4().movhstcp4().cBancCont().set(bghl203a().argumento().cBancCont());
        hv12401Movhstcp4().movhstcp4().cOeEgcCont().set(bghl203a().argumento().cOeEgcCont());
        hv12401Movhstcp4().movhstcp4().nsRdclCont().set(bghl203a().argumento().nsRdclCont());
        hv12401Movhstcp4().movhstcp4().vChkdCont().set(bghl203a().argumento().vChkdCont());
        hv12401Movhstcp4().movhstcp4().cTipoCont().set(bghl203a().argumento().cTipoCont());
        hv12401Movhstcp4().movhstcp4().cMoedIsoScta().set(bghl203a().argumento().cMoedIsoScta());
        hv12401Movhstcp4().movhstcp4().nsDeposito().set(bghl203a().argumento().nsDeposito());
        hv12401Movhstcp4().movhstcp4().nsMovimento().set(bghl203a().argumento().nsMovimento());
        if (criterioCompleto.isTrue()) {
            a5210CriterioCompleto() ;
        } else if (criterioOnde.isTrue()) {
            a5220CriterioOnde() ;
        } else if (criterioQuem.isTrue()) {
            a5230CriterioQuem() ;
        } else if (criterioSaldos.isTrue()) {
            a5240CriterioSaldos() ;
        } else if (criterioPosicao.isTrue()) {
            a5250CriterioPosicao() ;
        } else if (criterioJour.isTrue()) {
            a5260CriterioJour() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5210CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs203a908(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12401Movhstcp4().movhstcp4().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12401Movhstcp4().movhstcp4().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12401Movhstcp4().movhstcp4().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12401Movhstcp4().movhstcp4().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12401Movhstcp4().movhstcp4().cEvenOpel());
            bghl203a().detalhe().cTerminal().set(hv12401Movhstcp4().movhstcp4().cTerminal());
            bghl203a().detalhe().cOperador().set(hv12401Movhstcp4().movhstcp4().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12401Movhstcp4().movhstcp4().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12401Movhstcp4().movhstcp4().cUserid());
            bghl203a().detalhe().cTipoCanlAces().set(hv12401Movhstcp4().movhstcp4().cTipoCanlAces());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12401Movhstcp4().movhstcp4().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12401Movhstcp4().movhstcp4().cOeEgcOpex());
            bghl203a().detalhe().cProdSgop().set(hv12401Movhstcp4().movhstcp4().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12401Movhstcp4().movhstcp4().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12401Movhstcp4().movhstcp4().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12401Movhstcp4().movhstcp4().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12401Movhstcp4().movhstcp4().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12401Movhstcp4().movhstcp4().cTipoIttz());
            bghl203a().detalhe().tCambio().set(hv12401Movhstcp4().movhstcp4().tCambio());
            bghl203a().detalhe().mSldoRetd().set(hv12401Movhstcp4().movhstcp4().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12401Movhstcp4().movhstcp4().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12401Movhstcp4().movhstcp4().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12401Movhstcp4().movhstcp4().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdUtid());
            bghl203a().detalhe().nJourBbn().set(hv12401Movhstcp4().movhstcp4().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12401Movhstcp4().movhstcp4().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh());
            bghl203a().detalhe().nmArqvOrig().set(hv12401Movhstcp4().movhstcp4().nmArqvOrig());
            bghl203a().detalhe().tsActzUlt().set(hv12401Movhstcp4().movhstcp4().tsActzUlt());
            bghl203a().detalhe().cUsidActzUlt().set(hv12401Movhstcp4().movhstcp4().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5220CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs203a1047(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTipoCanlAces().set(hv12401Movhstcp4().movhstcp4().cTipoCanlAces());
            bghl203a().detalhe().cTerminal().set(hv12401Movhstcp4().movhstcp4().cTerminal());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12401Movhstcp4().movhstcp4().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12401Movhstcp4().movhstcp4().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5230CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs203a1100(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        /**
         * MOVE VGH12401-TS-ACTZ-ULT   TO MGH203A-TS-ACTZ-ULT
         */
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12401Movhstcp4().movhstcp4().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12401Movhstcp4().movhstcp4().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12401Movhstcp4().movhstcp4().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12401Movhstcp4().movhstcp4().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12401Movhstcp4().movhstcp4().cEvenOpel());
            bghl203a().detalhe().cOperador().set(hv12401Movhstcp4().movhstcp4().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12401Movhstcp4().movhstcp4().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12401Movhstcp4().movhstcp4().cUserid());
            bghl203a().detalhe().tCambio().set(hv12401Movhstcp4().movhstcp4().tCambio());
            bghl203a().detalhe().nmArqvOrig().set(hv12401Movhstcp4().movhstcp4().nmArqvOrig());
            a5231ObtemTsActTgh24() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5231ObtemTsActTgh24() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02401_MOVHIST4
         */
        hv02401Movhist4().selectMghs203a1169(hv12401Movhstcp4().movhstcp4(), wsTsInicio, wsTsFim) ;
        switch (hv02401Movhist4().getPersistenceCode()) {
            case NORMAL:
                bghl203a().detalhe().tsActzUlt().set(hv02401Movhist4().movhist4().tsActzUlt());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
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
    public void a5240CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs203a1203(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().mSldoRetd().set(hv12401Movhstcp4().movhstcp4().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12401Movhstcp4().movhstcp4().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12401Movhstcp4().movhstcp4().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12401Movhstcp4().movhstcp4().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5250CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs203a1258(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cProdSgop().set(hv12401Movhstcp4().movhstcp4().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12401Movhstcp4().movhstcp4().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12401Movhstcp4().movhstcp4().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12401Movhstcp4().movhstcp4().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12401Movhstcp4().movhstcp4().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12401Movhstcp4().movhstcp4().cTipoIttz());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5260CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs203a1312(wsTsInicio, wsTsFim) ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12401Movhstcp4().movhstcp4().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12401Movhstcp4().movhstcp4().cOeEgcOpex());
            bghl203a().detalhe().cUserid().set(hv12401Movhstcp4().movhstcp4().cUserid());
            bghl203a().detalhe().nJourBbn().set(hv12401Movhstcp4().movhstcp4().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12401Movhstcp4().movhstcp4().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh());
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
        hv12501Movhstcp5().movhstcp5().cPaisIsoaCont().set(bghl203a().argumento().cPaisIsoaCont());
        hv12501Movhstcp5().movhstcp5().cBancCont().set(bghl203a().argumento().cBancCont());
        hv12501Movhstcp5().movhstcp5().cOeEgcCont().set(bghl203a().argumento().cOeEgcCont());
        hv12501Movhstcp5().movhstcp5().nsRdclCont().set(bghl203a().argumento().nsRdclCont());
        hv12501Movhstcp5().movhstcp5().vChkdCont().set(bghl203a().argumento().vChkdCont());
        hv12501Movhstcp5().movhstcp5().cTipoCont().set(bghl203a().argumento().cTipoCont());
        hv12501Movhstcp5().movhstcp5().cMoedIsoScta().set(bghl203a().argumento().cMoedIsoScta());
        hv12501Movhstcp5().movhstcp5().nsDeposito().set(bghl203a().argumento().nsDeposito());
        hv12501Movhstcp5().movhstcp5().nsMovimento().set(bghl203a().argumento().nsMovimento());
        if (criterioCompleto.isTrue()) {
            a5310CriterioCompleto() ;
        } else if (criterioOnde.isTrue()) {
            a5320CriterioOnde() ;
        } else if (criterioQuem.isTrue()) {
            a5330CriterioQuem() ;
        } else if (criterioSaldos.isTrue()) {
            a5340CriterioSaldos() ;
        } else if (criterioPosicao.isTrue()) {
            a5350CriterioPosicao() ;
        } else if (criterioJour.isTrue()) {
            a5360CriterioJour() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5310CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs203a1405(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12501Movhstcp5().movhstcp5().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12501Movhstcp5().movhstcp5().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12501Movhstcp5().movhstcp5().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12501Movhstcp5().movhstcp5().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12501Movhstcp5().movhstcp5().cEvenOpel());
            bghl203a().detalhe().cTerminal().set(hv12501Movhstcp5().movhstcp5().cTerminal());
            bghl203a().detalhe().cOperador().set(hv12501Movhstcp5().movhstcp5().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12501Movhstcp5().movhstcp5().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12501Movhstcp5().movhstcp5().cUserid());
            bghl203a().detalhe().cTipoCanlAces().set(hv12501Movhstcp5().movhstcp5().cTipoCanlAces());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12501Movhstcp5().movhstcp5().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12501Movhstcp5().movhstcp5().cOeEgcOpex());
            bghl203a().detalhe().cProdSgop().set(hv12501Movhstcp5().movhstcp5().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12501Movhstcp5().movhstcp5().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12501Movhstcp5().movhstcp5().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12501Movhstcp5().movhstcp5().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12501Movhstcp5().movhstcp5().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12501Movhstcp5().movhstcp5().cTipoIttz());
            bghl203a().detalhe().tCambio().set(hv12501Movhstcp5().movhstcp5().tCambio());
            bghl203a().detalhe().mSldoRetd().set(hv12501Movhstcp5().movhstcp5().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12501Movhstcp5().movhstcp5().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12501Movhstcp5().movhstcp5().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12501Movhstcp5().movhstcp5().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdUtid());
            bghl203a().detalhe().nJourBbn().set(hv12501Movhstcp5().movhstcp5().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12501Movhstcp5().movhstcp5().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12501Movhstcp5().movhstcp5().nsJourBbnDtlh());
            bghl203a().detalhe().nmArqvOrig().set(hv12501Movhstcp5().movhstcp5().nmArqvOrig());
            bghl203a().detalhe().tsActzUlt().set(hv12501Movhstcp5().movhstcp5().tsActzUlt());
            bghl203a().detalhe().cUsidActzUlt().set(hv12501Movhstcp5().movhstcp5().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5320CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs203a1544(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTipoCanlAces().set(hv12501Movhstcp5().movhstcp5().cTipoCanlAces());
            bghl203a().detalhe().cTerminal().set(hv12501Movhstcp5().movhstcp5().cTerminal());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12501Movhstcp5().movhstcp5().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12501Movhstcp5().movhstcp5().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5330CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs203a1597(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        /**
         * MOVE VGH12501-TS-ACTZ-ULT   TO MGH203A-TS-ACTZ-ULT
         */
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12501Movhstcp5().movhstcp5().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12501Movhstcp5().movhstcp5().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12501Movhstcp5().movhstcp5().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12501Movhstcp5().movhstcp5().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12501Movhstcp5().movhstcp5().cEvenOpel());
            bghl203a().detalhe().cOperador().set(hv12501Movhstcp5().movhstcp5().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12501Movhstcp5().movhstcp5().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12501Movhstcp5().movhstcp5().cUserid());
            bghl203a().detalhe().tCambio().set(hv12501Movhstcp5().movhstcp5().tCambio());
            bghl203a().detalhe().nmArqvOrig().set(hv12501Movhstcp5().movhstcp5().nmArqvOrig());
            a5331ObtemTsActTgh25() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5331ObtemTsActTgh25() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02501_MOVHIST5
         */
        hv02501Movhist5().selectMghs203a1666(hv12501Movhstcp5().movhstcp5(), wsTsInicio, wsTsFim) ;
        switch (hv02501Movhist5().getPersistenceCode()) {
            case NORMAL:
                bghl203a().detalhe().tsActzUlt().set(hv02501Movhist5().movhist5().tsActzUlt());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
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
    public void a5340CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs203a1700(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().mSldoRetd().set(hv12501Movhstcp5().movhstcp5().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12501Movhstcp5().movhstcp5().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12501Movhstcp5().movhstcp5().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12501Movhstcp5().movhstcp5().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5350CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs203a1755(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cProdSgop().set(hv12501Movhstcp5().movhstcp5().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12501Movhstcp5().movhstcp5().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12501Movhstcp5().movhstcp5().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12501Movhstcp5().movhstcp5().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12501Movhstcp5().movhstcp5().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12501Movhstcp5().movhstcp5().cTipoIttz());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5360CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs203a1809(wsTsInicio, wsTsFim) ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12501Movhstcp5().movhstcp5().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12501Movhstcp5().movhstcp5().cOeEgcOpex());
            bghl203a().detalhe().cUserid().set(hv12501Movhstcp5().movhstcp5().cUserid());
            bghl203a().detalhe().nJourBbn().set(hv12501Movhstcp5().movhstcp5().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12501Movhstcp5().movhstcp5().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12501Movhstcp5().movhstcp5().nsJourBbnDtlh());
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
        hv12601Movhstcp6().movhstcp6().cPaisIsoaCont().set(bghl203a().argumento().cPaisIsoaCont());
        hv12601Movhstcp6().movhstcp6().cBancCont().set(bghl203a().argumento().cBancCont());
        hv12601Movhstcp6().movhstcp6().cOeEgcCont().set(bghl203a().argumento().cOeEgcCont());
        hv12601Movhstcp6().movhstcp6().nsRdclCont().set(bghl203a().argumento().nsRdclCont());
        hv12601Movhstcp6().movhstcp6().vChkdCont().set(bghl203a().argumento().vChkdCont());
        hv12601Movhstcp6().movhstcp6().cTipoCont().set(bghl203a().argumento().cTipoCont());
        hv12601Movhstcp6().movhstcp6().cMoedIsoScta().set(bghl203a().argumento().cMoedIsoScta());
        hv12601Movhstcp6().movhstcp6().nsDeposito().set(bghl203a().argumento().nsDeposito());
        hv12601Movhstcp6().movhstcp6().nsMovimento().set(bghl203a().argumento().nsMovimento());
        if (criterioCompleto.isTrue()) {
            a5410CriterioCompleto() ;
        } else if (criterioOnde.isTrue()) {
            a5420CriterioOnde() ;
        } else if (criterioQuem.isTrue()) {
            a5430CriterioQuem() ;
        } else if (criterioSaldos.isTrue()) {
            a5440CriterioSaldos() ;
        } else if (criterioPosicao.isTrue()) {
            a5450CriterioPosicao() ;
        } else if (criterioJour.isTrue()) {
            a5460CriterioJour() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5410CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs203a1901(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12601Movhstcp6().movhstcp6().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12601Movhstcp6().movhstcp6().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12601Movhstcp6().movhstcp6().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12601Movhstcp6().movhstcp6().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12601Movhstcp6().movhstcp6().cEvenOpel());
            bghl203a().detalhe().cTerminal().set(hv12601Movhstcp6().movhstcp6().cTerminal());
            bghl203a().detalhe().cOperador().set(hv12601Movhstcp6().movhstcp6().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12601Movhstcp6().movhstcp6().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12601Movhstcp6().movhstcp6().cUserid());
            bghl203a().detalhe().cTipoCanlAces().set(hv12601Movhstcp6().movhstcp6().cTipoCanlAces());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12601Movhstcp6().movhstcp6().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12601Movhstcp6().movhstcp6().cOeEgcOpex());
            bghl203a().detalhe().cProdSgop().set(hv12601Movhstcp6().movhstcp6().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12601Movhstcp6().movhstcp6().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12601Movhstcp6().movhstcp6().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12601Movhstcp6().movhstcp6().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12601Movhstcp6().movhstcp6().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12601Movhstcp6().movhstcp6().cTipoIttz());
            bghl203a().detalhe().tCambio().set(hv12601Movhstcp6().movhstcp6().tCambio());
            bghl203a().detalhe().mSldoRetd().set(hv12601Movhstcp6().movhstcp6().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12601Movhstcp6().movhstcp6().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12601Movhstcp6().movhstcp6().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12601Movhstcp6().movhstcp6().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdUtid());
            bghl203a().detalhe().nJourBbn().set(hv12601Movhstcp6().movhstcp6().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12601Movhstcp6().movhstcp6().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12601Movhstcp6().movhstcp6().nsJourBbnDtlh());
            bghl203a().detalhe().nmArqvOrig().set(hv12601Movhstcp6().movhstcp6().nmArqvOrig());
            bghl203a().detalhe().tsActzUlt().set(hv12601Movhstcp6().movhstcp6().tsActzUlt());
            bghl203a().detalhe().cUsidActzUlt().set(hv12601Movhstcp6().movhstcp6().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5420CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs203a2040(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTipoCanlAces().set(hv12601Movhstcp6().movhstcp6().cTipoCanlAces());
            bghl203a().detalhe().cTerminal().set(hv12601Movhstcp6().movhstcp6().cTerminal());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12601Movhstcp6().movhstcp6().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12601Movhstcp6().movhstcp6().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5430CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs203a2093(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        /**
         * MOVE VGH12601-TS-ACTZ-ULT   TO MGH203A-TS-ACTZ-ULT
         */
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12601Movhstcp6().movhstcp6().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12601Movhstcp6().movhstcp6().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12601Movhstcp6().movhstcp6().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12601Movhstcp6().movhstcp6().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12601Movhstcp6().movhstcp6().cEvenOpel());
            bghl203a().detalhe().cOperador().set(hv12601Movhstcp6().movhstcp6().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12601Movhstcp6().movhstcp6().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12601Movhstcp6().movhstcp6().cUserid());
            bghl203a().detalhe().tCambio().set(hv12601Movhstcp6().movhstcp6().tCambio());
            bghl203a().detalhe().nmArqvOrig().set(hv12601Movhstcp6().movhstcp6().nmArqvOrig());
            a5431ObtemTsActTgh26() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5431ObtemTsActTgh26() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02601_MOVHIST6
         */
        hv02601Movhist6().selectMghs203a2162(hv12601Movhstcp6().movhstcp6(), wsTsInicio, wsTsFim) ;
        switch (hv02601Movhist6().getPersistenceCode()) {
            case NORMAL:
                bghl203a().detalhe().tsActzUlt().set(hv02601Movhist6().movhist6().tsActzUlt());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
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
    public void a5440CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs203a2196(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().mSldoRetd().set(hv12601Movhstcp6().movhstcp6().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12601Movhstcp6().movhstcp6().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12601Movhstcp6().movhstcp6().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12601Movhstcp6().movhstcp6().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5450CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs203a2251(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cProdSgop().set(hv12601Movhstcp6().movhstcp6().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12601Movhstcp6().movhstcp6().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12601Movhstcp6().movhstcp6().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12601Movhstcp6().movhstcp6().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12601Movhstcp6().movhstcp6().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12601Movhstcp6().movhstcp6().cTipoIttz());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5460CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs203a2305(wsTsInicio, wsTsFim) ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12601Movhstcp6().movhstcp6().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12601Movhstcp6().movhstcp6().cOeEgcOpex());
            bghl203a().detalhe().cUserid().set(hv12601Movhstcp6().movhstcp6().cUserid());
            bghl203a().detalhe().nJourBbn().set(hv12601Movhstcp6().movhstcp6().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12601Movhstcp6().movhstcp6().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12601Movhstcp6().movhstcp6().nsJourBbnDtlh());
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
        hv12701Movhstcp7().movhstcp7().cPaisIsoaCont().set(bghl203a().argumento().cPaisIsoaCont());
        hv12701Movhstcp7().movhstcp7().cBancCont().set(bghl203a().argumento().cBancCont());
        hv12701Movhstcp7().movhstcp7().cOeEgcCont().set(bghl203a().argumento().cOeEgcCont());
        hv12701Movhstcp7().movhstcp7().nsRdclCont().set(bghl203a().argumento().nsRdclCont());
        hv12701Movhstcp7().movhstcp7().vChkdCont().set(bghl203a().argumento().vChkdCont());
        hv12701Movhstcp7().movhstcp7().cTipoCont().set(bghl203a().argumento().cTipoCont());
        hv12701Movhstcp7().movhstcp7().cMoedIsoScta().set(bghl203a().argumento().cMoedIsoScta());
        hv12701Movhstcp7().movhstcp7().nsDeposito().set(bghl203a().argumento().nsDeposito());
        hv12701Movhstcp7().movhstcp7().nsMovimento().set(bghl203a().argumento().nsMovimento());
        if (criterioCompleto.isTrue()) {
            a5510CriterioCompleto() ;
        } else if (criterioOnde.isTrue()) {
            a5520CriterioOnde() ;
        } else if (criterioQuem.isTrue()) {
            a5530CriterioQuem() ;
        } else if (criterioSaldos.isTrue()) {
            a5540CriterioSaldos() ;
        } else if (criterioPosicao.isTrue()) {
            a5550CriterioPosicao() ;
        } else if (criterioJour.isTrue()) {
            a5560CriterioJour() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5510CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs203a2397(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12701Movhstcp7().movhstcp7().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12701Movhstcp7().movhstcp7().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12701Movhstcp7().movhstcp7().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12701Movhstcp7().movhstcp7().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12701Movhstcp7().movhstcp7().cEvenOpel());
            bghl203a().detalhe().cTerminal().set(hv12701Movhstcp7().movhstcp7().cTerminal());
            bghl203a().detalhe().cOperador().set(hv12701Movhstcp7().movhstcp7().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12701Movhstcp7().movhstcp7().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12701Movhstcp7().movhstcp7().cUserid());
            bghl203a().detalhe().cTipoCanlAces().set(hv12701Movhstcp7().movhstcp7().cTipoCanlAces());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
            bghl203a().detalhe().cProdSgop().set(hv12701Movhstcp7().movhstcp7().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12701Movhstcp7().movhstcp7().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12701Movhstcp7().movhstcp7().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12701Movhstcp7().movhstcp7().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12701Movhstcp7().movhstcp7().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12701Movhstcp7().movhstcp7().cTipoIttz());
            bghl203a().detalhe().tCambio().set(hv12701Movhstcp7().movhstcp7().tCambio());
            bghl203a().detalhe().mSldoRetd().set(hv12701Movhstcp7().movhstcp7().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12701Movhstcp7().movhstcp7().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12701Movhstcp7().movhstcp7().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12701Movhstcp7().movhstcp7().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid());
            bghl203a().detalhe().nJourBbn().set(hv12701Movhstcp7().movhstcp7().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12701Movhstcp7().movhstcp7().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh());
            bghl203a().detalhe().nmArqvOrig().set(hv12701Movhstcp7().movhstcp7().nmArqvOrig());
            bghl203a().detalhe().tsActzUlt().set(hv12701Movhstcp7().movhstcp7().tsActzUlt());
            bghl203a().detalhe().cUsidActzUlt().set(hv12701Movhstcp7().movhstcp7().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5520CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs203a2536(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTipoCanlAces().set(hv12701Movhstcp7().movhstcp7().cTipoCanlAces());
            bghl203a().detalhe().cTerminal().set(hv12701Movhstcp7().movhstcp7().cTerminal());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5530CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs203a2589(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        /**
         * MOVE VGH12701-TS-ACTZ-ULT   TO MGH203A-TS-ACTZ-ULT
         */
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12701Movhstcp7().movhstcp7().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12701Movhstcp7().movhstcp7().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12701Movhstcp7().movhstcp7().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12701Movhstcp7().movhstcp7().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12701Movhstcp7().movhstcp7().cEvenOpel());
            bghl203a().detalhe().cOperador().set(hv12701Movhstcp7().movhstcp7().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12701Movhstcp7().movhstcp7().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12701Movhstcp7().movhstcp7().cUserid());
            bghl203a().detalhe().tCambio().set(hv12701Movhstcp7().movhstcp7().tCambio());
            bghl203a().detalhe().nmArqvOrig().set(hv12701Movhstcp7().movhstcp7().nmArqvOrig());
            a5531ObtemTsActTgh27() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5531ObtemTsActTgh27() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02701_MOVHIST7
         */
        hv02701Movhist7().selectMghs203a2657(hv12701Movhstcp7().movhstcp7(), wsTsInicio, wsTsFim) ;
        switch (hv02701Movhist7().getPersistenceCode()) {
            case NORMAL:
                bghl203a().detalhe().tsActzUlt().set(hv02701Movhist7().movhist7().tsActzUlt());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
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
    public void a5540CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs203a2691(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().mSldoRetd().set(hv12701Movhstcp7().movhstcp7().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12701Movhstcp7().movhstcp7().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12701Movhstcp7().movhstcp7().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12701Movhstcp7().movhstcp7().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5550CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs203a2746(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cProdSgop().set(hv12701Movhstcp7().movhstcp7().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12701Movhstcp7().movhstcp7().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12701Movhstcp7().movhstcp7().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12701Movhstcp7().movhstcp7().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12701Movhstcp7().movhstcp7().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12701Movhstcp7().movhstcp7().cTipoIttz());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5560CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs203a2800(wsTsInicio, wsTsFim) ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
            bghl203a().detalhe().cUserid().set(hv12701Movhstcp7().movhstcp7().cUserid());
            bghl203a().detalhe().nJourBbn().set(hv12701Movhstcp7().movhstcp7().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12701Movhstcp7().movhstcp7().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh());
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
        hv12801Movhstcp8().movhstcp8().cPaisIsoaCont().set(bghl203a().argumento().cPaisIsoaCont());
        hv12801Movhstcp8().movhstcp8().cBancCont().set(bghl203a().argumento().cBancCont());
        hv12801Movhstcp8().movhstcp8().cOeEgcCont().set(bghl203a().argumento().cOeEgcCont());
        hv12801Movhstcp8().movhstcp8().nsRdclCont().set(bghl203a().argumento().nsRdclCont());
        hv12801Movhstcp8().movhstcp8().vChkdCont().set(bghl203a().argumento().vChkdCont());
        hv12801Movhstcp8().movhstcp8().cTipoCont().set(bghl203a().argumento().cTipoCont());
        hv12801Movhstcp8().movhstcp8().cMoedIsoScta().set(bghl203a().argumento().cMoedIsoScta());
        hv12801Movhstcp8().movhstcp8().nsDeposito().set(bghl203a().argumento().nsDeposito());
        hv12801Movhstcp8().movhstcp8().nsMovimento().set(bghl203a().argumento().nsMovimento());
        if (criterioCompleto.isTrue()) {
            a5610CriterioCompleto() ;
        } else if (criterioOnde.isTrue()) {
            a5620CriterioOnde() ;
        } else if (criterioQuem.isTrue()) {
            a5630CriterioQuem() ;
        } else if (criterioSaldos.isTrue()) {
            a5640CriterioSaldos() ;
        } else if (criterioPosicao.isTrue()) {
            a5650CriterioPosicao() ;
        } else if (criterioJour.isTrue()) {
            a5660CriterioJour() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5610CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs203a2893(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12801Movhstcp8().movhstcp8().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12801Movhstcp8().movhstcp8().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12801Movhstcp8().movhstcp8().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12801Movhstcp8().movhstcp8().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12801Movhstcp8().movhstcp8().cEvenOpel());
            bghl203a().detalhe().cTerminal().set(hv12801Movhstcp8().movhstcp8().cTerminal());
            bghl203a().detalhe().cOperador().set(hv12801Movhstcp8().movhstcp8().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12801Movhstcp8().movhstcp8().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12801Movhstcp8().movhstcp8().cUserid());
            bghl203a().detalhe().cTipoCanlAces().set(hv12801Movhstcp8().movhstcp8().cTipoCanlAces());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12801Movhstcp8().movhstcp8().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12801Movhstcp8().movhstcp8().cOeEgcOpex());
            bghl203a().detalhe().cProdSgop().set(hv12801Movhstcp8().movhstcp8().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12801Movhstcp8().movhstcp8().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12801Movhstcp8().movhstcp8().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12801Movhstcp8().movhstcp8().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12801Movhstcp8().movhstcp8().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12801Movhstcp8().movhstcp8().cTipoIttz());
            bghl203a().detalhe().tCambio().set(hv12801Movhstcp8().movhstcp8().tCambio());
            bghl203a().detalhe().mSldoRetd().set(hv12801Movhstcp8().movhstcp8().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12801Movhstcp8().movhstcp8().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12801Movhstcp8().movhstcp8().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12801Movhstcp8().movhstcp8().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdUtid());
            bghl203a().detalhe().nJourBbn().set(hv12801Movhstcp8().movhstcp8().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12801Movhstcp8().movhstcp8().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12801Movhstcp8().movhstcp8().nsJourBbnDtlh());
            bghl203a().detalhe().nmArqvOrig().set(hv12801Movhstcp8().movhstcp8().nmArqvOrig());
            bghl203a().detalhe().tsActzUlt().set(hv12801Movhstcp8().movhstcp8().tsActzUlt());
            bghl203a().detalhe().cUsidActzUlt().set(hv12801Movhstcp8().movhstcp8().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5620CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs203a3032(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTipoCanlAces().set(hv12801Movhstcp8().movhstcp8().cTipoCanlAces());
            bghl203a().detalhe().cTerminal().set(hv12801Movhstcp8().movhstcp8().cTerminal());
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12801Movhstcp8().movhstcp8().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12801Movhstcp8().movhstcp8().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5630CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs203a3085(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        /**
         * MOVE VGH12801-TS-ACTZ-ULT   TO MGH203A-TS-ACTZ-ULT
         */
        if (progOk.isTrue()) {
            bghl203a().detalhe().cTransaccao().set(hv12801Movhstcp8().movhstcp8().cTransaccao());
            bghl203a().detalhe().aAplicacao().set(hv12801Movhstcp8().movhstcp8().aAplicacao());
            bghl203a().detalhe().cOpczMenu().set(hv12801Movhstcp8().movhstcp8().cOpczMenu());
            bghl203a().detalhe().cOpeBbn().set(hv12801Movhstcp8().movhstcp8().cOpeBbn());
            bghl203a().detalhe().cEvenOpel().set(hv12801Movhstcp8().movhstcp8().cEvenOpel());
            bghl203a().detalhe().cOperador().set(hv12801Movhstcp8().movhstcp8().cOperador());
            bghl203a().detalhe().cOpexAtrx().set(hv12801Movhstcp8().movhstcp8().cOpexAtrx());
            bghl203a().detalhe().cUserid().set(hv12801Movhstcp8().movhstcp8().cUserid());
            bghl203a().detalhe().tCambio().set(hv12801Movhstcp8().movhstcp8().tCambio());
            bghl203a().detalhe().nmArqvOrig().set(hv12801Movhstcp8().movhstcp8().nmArqvOrig());
            a5631ObtemTsActTgh28() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5631ObtemTsActTgh28() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02801_MOVHIST8
         */
        hv02801Movhist8().selectMghs203a3154(hv12801Movhstcp8().movhstcp8(), wsTsInicio, wsTsFim) ;
        switch (hv02801Movhist8().getPersistenceCode()) {
            case NORMAL:
                bghl203a().detalhe().tsActzUlt().set(hv02801Movhist8().movhist8().tsActzUlt());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
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
    public void a5640CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs203a3188(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().mSldoRetd().set(hv12801Movhstcp8().movhstcp8().mSldoRetd());
            bghl203a().detalhe().mSldoVcob().set(hv12801Movhstcp8().movhstcp8().mSldoVcob());
            bghl203a().detalhe().mCmrgLim().set(hv12801Movhstcp8().movhstcp8().mCmrgLim());
            bghl203a().detalhe().mCmrgUtid().set(hv12801Movhstcp8().movhstcp8().mCmrgUtid());
            bghl203a().detalhe().mDcboNgcdAtrd().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdAtrd());
            bghl203a().detalhe().mDcboNgcdUtid().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5650CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs203a3243(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cProdSgop().set(hv12801Movhstcp8().movhstcp8().cProdSgop());
            bghl203a().detalhe().cFamiProd().set(hv12801Movhstcp8().movhstcp8().cFamiProd());
            bghl203a().detalhe().cProduto().set(hv12801Movhstcp8().movhstcp8().cProduto());
            bghl203a().detalhe().cCndzMovzCont().set(hv12801Movhstcp8().movhstcp8().cCndzMovzCont());
            bghl203a().detalhe().cGrupCont().set(hv12801Movhstcp8().movhstcp8().cGrupCont());
            bghl203a().detalhe().cTipoIttz().set(hv12801Movhstcp8().movhstcp8().cTipoIttz());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5660CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs203a3297(wsTsInicio, wsTsFim) ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl203a().detalhe().cPaisIsoaOeOpx().set(hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx());
            bghl203a().detalhe().cMnemEgcOpex().set(hv12801Movhstcp8().movhstcp8().cMnemEgcOpex());
            bghl203a().detalhe().cOeEgcOpex().set(hv12801Movhstcp8().movhstcp8().cOeEgcOpex());
            bghl203a().detalhe().cUserid().set(hv12801Movhstcp8().movhstcp8().cUserid());
            bghl203a().detalhe().nJourBbn().set(hv12801Movhstcp8().movhstcp8().nJourBbn());
            bghl203a().detalhe().nsJourBbn().set(hv12801Movhstcp8().movhstcp8().nsJourBbn());
            bghl203a().detalhe().nsJourBbnDtlh().set(hv12801Movhstcp8().movhstcp8().nsJourBbnDtlh());
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
        bghl203a().cRetorno().set(progStatus);
        bghl203a().cSqlcode().set(getPersistenceCode());
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
