package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl102a ;
import cgd.gh.routines.Mghs203a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00102_MOVHSTCPL
 * : TGH00022_MOVDIAANT
 * DESCRICAO     : OBTEM DADOS DAS TABELAS
 * ALTERAÇÕES :  PASSA A ACEDER A INF PRINCIPAL PARA OBTER O
 * TS-ACT-ULT NO CRITERIO QUEM - 2010-05-21
 * PASSIVAS 2540 - 2018-03-13 - PREENCHER O NOVO CAMPO DA
 * TABELA TGH00102
 * 
 * migrated from program [MGHS102A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs102a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl102a
     */
    @Data
    public abstract Bghl102a bghl102a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps02201Movdiaant
     */
    @Data
    protected abstract Vwsdghps02201Movdiaant hv02201Movdiaant() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs203a
     */
    @Data
    protected abstract Mghs203a hrMghs203a() ;
    
    
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
    
    
    @Data(size=1)
    protected IString wsHaMov ;
    @Data
    @Condition("S")
    protected ICondition haMov ;
    @Data
    @Condition("N")
    protected ICondition naoHaMov ;
    
    
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
    
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl102a().cRetorno().initialize() ;
        bghl102a().cSqlcode().initialize() ;
        if (bghl102a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl102a().argumento().cBancCont().isEqual(0) || 
            bghl102a().argumento().cOeEgcCont().isEqual(0) || 
            bghl102a().argumento().nsRdclCont().isEqual(0) || 
            bghl102a().argumento().cMoedIsoScta().isEmpty() || 
            bghl102a().argumento().tsMovimento().isEmpty() || 
            bghl102a().argumento().nsMovimento().isEqual(0) || 
            bghl102a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl102a().criterioConsulta().iCriterioCns());
            if (!criterioValido.isTrue()) {
                progDadosInvalidos.setTrue() ;
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
        a5100FormatarArea() ;
        if (criterioCompleto.isTrue()) {
            a5200CriterioCompleto() ;
        } else if (criterioOnde.isTrue()) {
            a5300CriterioOnde() ;
        } else if (criterioQuem.isTrue()) {
            a5400CriterioQuem() ;
        } else if (criterioSaldos.isTrue()) {
            a5500CriterioSaldos() ;
        } else if (criterioPosicao.isTrue()) {
            a5600CriterioPosicao() ;
        } else if (criterioJour.isTrue()) {
            a5700CriterioJour() ;
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
        if (bghl102a().criterioConsulta().movHstS().isTrue()) {
            hv10201Movhstcpl().movhstcpl().initialize() ;
            hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghl102a().argumento().cPaisIsoaCont());
            hv10201Movhstcpl().movhstcpl().cBancCont().set(bghl102a().argumento().cBancCont());
            hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghl102a().argumento().cOeEgcCont());
            hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghl102a().argumento().nsRdclCont());
            hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghl102a().argumento().vChkdCont());
            hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghl102a().argumento().cTipoCont());
            hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghl102a().argumento().cMoedIsoScta());
            hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghl102a().argumento().nsDeposito());
            wTsInicio().set(bghl102a().argumento().tsMovimento());
            wsTsInicio.set(bghl102a().argumento().tsMovimento());
            wTsFim().wsDataFim().set(wTsInicio().wsDataInicio());
            wsTsFim.set(wTsFim());
            /**
             * MOVE MGH102A-TS-MOVIMENTO     TO VGH10201-TS-MOVIMENTO
             */
            hv10201Movhstcpl().movhstcpl().nsMovimento().set(bghl102a().argumento().nsMovimento());
        } else {
            hv02201Movdiaant().movdiaant().initialize() ;
            hv02201Movdiaant().movdiaant().cPaisIsoaCont().set(bghl102a().argumento().cPaisIsoaCont());
            hv02201Movdiaant().movdiaant().cBancCont().set(bghl102a().argumento().cBancCont());
            hv02201Movdiaant().movdiaant().cOeEgcCont().set(bghl102a().argumento().cOeEgcCont());
            hv02201Movdiaant().movdiaant().nsRdclCont().set(bghl102a().argumento().nsRdclCont());
            hv02201Movdiaant().movdiaant().vChkdCont().set(bghl102a().argumento().vChkdCont());
            hv02201Movdiaant().movdiaant().cTipoCont().set(bghl102a().argumento().cTipoCont());
            hv02201Movdiaant().movdiaant().cMoedIsoScta().set(bghl102a().argumento().cMoedIsoScta());
            hv02201Movdiaant().movdiaant().nsDeposito().set(bghl102a().argumento().nsDeposito());
            hv02201Movdiaant().movdiaant().nsMovimento().set(bghl102a().argumento().nsMovimento());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl102a().criterioConsulta().movHstS().isTrue()) {
            a5210AcedeTgh102T() ;
        } else {
            a5220AcedeTgh022T() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5210AcedeTgh102T() {
        naoHaMov.setTrue() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs102a261() ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                haMov.setTrue() ;
                break;
            case NOTFND:
                a5900AcederHstNormal() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                bghl102a().detalhe().cTransaccao().set(hv10201Movhstcpl().movhstcpl().cTransaccao());
                bghl102a().detalhe().aAplicacao().set(hv10201Movhstcpl().movhstcpl().aAplicacao());
                bghl102a().detalhe().cOpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
                bghl102a().detalhe().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
                bghl102a().detalhe().cEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
                bghl102a().detalhe().cTerminal().set(hv10201Movhstcpl().movhstcpl().cTerminal());
                bghl102a().detalhe().cOperador().set(hv10201Movhstcpl().movhstcpl().cOperador());
                bghl102a().detalhe().cOpexAtrx().set(hv10201Movhstcpl().movhstcpl().cOpexAtrx());
                bghl102a().detalhe().cUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
                bghl102a().detalhe().cTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
                bghl102a().detalhe().cPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
                bghl102a().detalhe().cMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
                bghl102a().detalhe().cOeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
                bghl102a().detalhe().cProdSgop().set(hv10201Movhstcpl().movhstcpl().cProdSgop());
                bghl102a().detalhe().cFamiProd().set(hv10201Movhstcpl().movhstcpl().cFamiProd());
                bghl102a().detalhe().cProduto().set(hv10201Movhstcpl().movhstcpl().cProduto());
                bghl102a().detalhe().cCndzMovzCont().set(hv10201Movhstcpl().movhstcpl().cCndzMovzCont());
                bghl102a().detalhe().cGrupCont().set(hv10201Movhstcpl().movhstcpl().cGrupCont());
                bghl102a().detalhe().cTipoIttz().set(hv10201Movhstcpl().movhstcpl().cTipoIttz());
                bghl102a().detalhe().tCambio().set(hv10201Movhstcpl().movhstcpl().tCambio());
                bghl102a().detalhe().mSldoRetd().set(hv10201Movhstcpl().movhstcpl().mSldoRetd());
                bghl102a().detalhe().mSldoVcob().set(hv10201Movhstcpl().movhstcpl().mSldoVcob());
                bghl102a().detalhe().mCmrgLim().set(hv10201Movhstcpl().movhstcpl().mCmrgLim());
                bghl102a().detalhe().mCmrgUtid().set(hv10201Movhstcpl().movhstcpl().mCmrgUtid());
                bghl102a().detalhe().mDcboNgcdAtrd().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd());
                bghl102a().detalhe().mDcboNgcdUtid().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid());
                bghl102a().detalhe().nJourBbn().set(hv10201Movhstcpl().movhstcpl().nJourBbn());
                bghl102a().detalhe().nsJourBbn().set(hv10201Movhstcpl().movhstcpl().nsJourBbn());
                bghl102a().detalhe().nsJourBbnDtlh().set(hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh());
                bghl102a().detalhe().nmArqvOrig().set(hv10201Movhstcpl().movhstcpl().nmArqvOrig());
                bghl102a().detalhe().tsActzUlt().set(hv10201Movhstcpl().movhstcpl().tsActzUlt());
                bghl102a().detalhe().cUsidActzUlt().set(hv10201Movhstcpl().movhstcpl().cUsidActzUlt());
            } else {
                bghl102a().detalhe().cTransaccao().set(hrMghs203a().bghl203a().detalhe().cTransaccao());
                bghl102a().detalhe().aAplicacao().set(hrMghs203a().bghl203a().detalhe().aAplicacao());
                bghl102a().detalhe().cOpczMenu().set(hrMghs203a().bghl203a().detalhe().cOpczMenu());
                bghl102a().detalhe().cOpeBbn().set(hrMghs203a().bghl203a().detalhe().cOpeBbn());
                bghl102a().detalhe().cEvenOpel().set(hrMghs203a().bghl203a().detalhe().cEvenOpel());
                bghl102a().detalhe().cTerminal().set(hrMghs203a().bghl203a().detalhe().cTerminal());
                bghl102a().detalhe().cOperador().set(hrMghs203a().bghl203a().detalhe().cOperador());
                bghl102a().detalhe().cOpexAtrx().set(hrMghs203a().bghl203a().detalhe().cOpexAtrx());
                bghl102a().detalhe().cUserid().set(hrMghs203a().bghl203a().detalhe().cUserid());
                bghl102a().detalhe().cTipoCanlAces().set(hrMghs203a().bghl203a().detalhe().cTipoCanlAces());
                bghl102a().detalhe().cPaisIsoaOeOpx().set(hrMghs203a().bghl203a().detalhe().cPaisIsoaOeOpx());
                bghl102a().detalhe().cMnemEgcOpex().set(hrMghs203a().bghl203a().detalhe().cMnemEgcOpex());
                bghl102a().detalhe().cOeEgcOpex().set(hrMghs203a().bghl203a().detalhe().cOeEgcOpex());
                bghl102a().detalhe().cProdSgop().set(hrMghs203a().bghl203a().detalhe().cProdSgop());
                bghl102a().detalhe().cFamiProd().set(hrMghs203a().bghl203a().detalhe().cFamiProd());
                bghl102a().detalhe().cProduto().set(hrMghs203a().bghl203a().detalhe().cProduto());
                bghl102a().detalhe().cCndzMovzCont().set(hrMghs203a().bghl203a().detalhe().cCndzMovzCont());
                bghl102a().detalhe().cGrupCont().set(hrMghs203a().bghl203a().detalhe().cGrupCont());
                bghl102a().detalhe().cTipoIttz().set(hrMghs203a().bghl203a().detalhe().cTipoIttz());
                bghl102a().detalhe().tCambio().set(hrMghs203a().bghl203a().detalhe().tCambio());
                bghl102a().detalhe().mSldoRetd().set(hrMghs203a().bghl203a().detalhe().mSldoRetd());
                bghl102a().detalhe().mSldoVcob().set(hrMghs203a().bghl203a().detalhe().mSldoVcob());
                bghl102a().detalhe().mCmrgLim().set(hrMghs203a().bghl203a().detalhe().mCmrgLim());
                bghl102a().detalhe().mCmrgUtid().set(hrMghs203a().bghl203a().detalhe().mCmrgUtid());
                bghl102a().detalhe().mDcboNgcdAtrd().set(hrMghs203a().bghl203a().detalhe().mDcboNgcdAtrd());
                bghl102a().detalhe().mDcboNgcdUtid().set(hrMghs203a().bghl203a().detalhe().mDcboNgcdUtid());
                bghl102a().detalhe().nJourBbn().set(hrMghs203a().bghl203a().detalhe().nJourBbn());
                bghl102a().detalhe().nsJourBbn().set(hrMghs203a().bghl203a().detalhe().nsJourBbn());
                bghl102a().detalhe().nsJourBbnDtlh().set(hrMghs203a().bghl203a().detalhe().nsJourBbnDtlh());
                bghl102a().detalhe().nmArqvOrig().set(hrMghs203a().bghl203a().detalhe().nmArqvOrig());
                bghl102a().detalhe().tsActzUlt().set(hrMghs203a().bghl203a().detalhe().tsActzUlt());
                bghl102a().detalhe().cUsidActzUlt().set(hrMghs203a().bghl203a().detalhe().cUsidActzUlt());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5220AcedeTgh022T() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectMghs102a443() ;
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl102a().detalhe().aAplicacao().set(hv02201Movdiaant().movdiaant().aAplicacao());
            bghl102a().detalhe().cOpczMenu().set(hv02201Movdiaant().movdiaant().cOpczMenu());
            bghl102a().detalhe().cOpeBbn().set(hv02201Movdiaant().movdiaant().cOpeBbn());
            bghl102a().detalhe().cEvenOpel().set(hv02201Movdiaant().movdiaant().cEvenOpel());
            bghl102a().detalhe().cUserid().set(hv02201Movdiaant().movdiaant().cUserid());
            bghl102a().detalhe().cTipoCanlAces().set(hv02201Movdiaant().movdiaant().cTipoCanlAces());
            bghl102a().detalhe().cPaisIsoaOeOpx().set(hv02201Movdiaant().movdiaant().cPaisIsoaOeOpx());
            bghl102a().detalhe().cMnemEgcOpex().set(hv02201Movdiaant().movdiaant().cMnemEgcOpex());
            bghl102a().detalhe().cOeEgcOpex().set(hv02201Movdiaant().movdiaant().cOeEgcOpex());
            bghl102a().detalhe().cFamiProd().set(hv02201Movdiaant().movdiaant().cFamiProd());
            bghl102a().detalhe().cProduto().set(hv02201Movdiaant().movdiaant().cProduto());
            bghl102a().detalhe().cTipoIttz().set(hv02201Movdiaant().movdiaant().cSectIttlBpor());
            bghl102a().detalhe().tCambio().set(hv02201Movdiaant().movdiaant().tCambio());
            bghl102a().detalhe().mSldoRetd().set(hv02201Movdiaant().movdiaant().mSldoRetd());
            bghl102a().detalhe().mSldoVcob().set(hv02201Movdiaant().movdiaant().mSldoVcob());
            bghl102a().detalhe().mCmrgLim().set(hv02201Movdiaant().movdiaant().mCmrgLim());
            bghl102a().detalhe().mCmrgUtid().set(hv02201Movdiaant().movdiaant().mCmrgUtid());
            bghl102a().detalhe().mDcboNgcdAtrd().set(hv02201Movdiaant().movdiaant().mDcboNgcdAtrd());
            bghl102a().detalhe().mDcboNgcdUtid().set(hv02201Movdiaant().movdiaant().mDcboNgcdUtid());
            bghl102a().detalhe().nJourBbn().set(hv02201Movdiaant().movdiaant().nJourBbn());
            bghl102a().detalhe().nsJourBbn().set(hv02201Movdiaant().movdiaant().nsJourBbn());
            bghl102a().detalhe().nsJourBbnDtlh().set(hv02201Movdiaant().movdiaant().nsJourBbnDtlh());
            bghl102a().detalhe().nmArqvOrig().set("HO");
            bghl102a().detalhe().tsActzUlt().set(hv02201Movdiaant().movdiaant().tsActzUlt());
            bghl102a().detalhe().cUsidActzUlt().set(hv02201Movdiaant().movdiaant().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl102a().criterioConsulta().movHstS().isTrue()) {
            a5310AcedeTgh102O() ;
        } else {
            a5320AcedeTgh022O() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5310AcedeTgh102O() {
        naoHaMov.setTrue() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs102a568() ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                haMov.setTrue() ;
                break;
            case NOTFND:
                a5900AcederHstNormal() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                bghl102a().detalhe().cTipoCanlAces().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
                bghl102a().detalhe().cTerminal().set(hv10201Movhstcpl().movhstcpl().cTerminal());
                bghl102a().detalhe().cPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
                bghl102a().detalhe().cMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
                bghl102a().detalhe().cOeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
                /**
                 * PASSIVAS 2540 - 2018-03-13 - INI
                 */
                bghl102a().detalhe().categMov().set(hv10201Movhstcpl().movhstcpl().cCatgMov());
            } else {
                /**
                 * PASSIVAS 2540 - 2018-03-13 - FIM
                 */
                bghl102a().detalhe().cTipoCanlAces().set(hrMghs203a().bghl203a().detalhe().cTipoCanlAces());
                bghl102a().detalhe().cTerminal().set(hrMghs203a().bghl203a().detalhe().cTerminal());
                bghl102a().detalhe().cPaisIsoaOeOpx().set(hrMghs203a().bghl203a().detalhe().cPaisIsoaOeOpx());
                bghl102a().detalhe().cMnemEgcOpex().set(hrMghs203a().bghl203a().detalhe().cMnemEgcOpex());
                bghl102a().detalhe().cOeEgcOpex().set(hrMghs203a().bghl203a().detalhe().cOeEgcOpex());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5320AcedeTgh022O() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectMghs102a642() ;
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl102a().detalhe().cTipoCanlAces().set(hv02201Movdiaant().movdiaant().cTipoCanlAces());
            bghl102a().detalhe().cPaisIsoaOeOpx().set(hv02201Movdiaant().movdiaant().cPaisIsoaOeOpx());
            bghl102a().detalhe().cMnemEgcOpex().set(hv02201Movdiaant().movdiaant().cMnemEgcOpex());
            bghl102a().detalhe().cOeEgcOpex().set(hv02201Movdiaant().movdiaant().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl102a().criterioConsulta().movHstS().isTrue()) {
            a5410AcedeTgh102Q() ;
        } else {
            a5420AcedeTgh022Q() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5410AcedeTgh102Q() {
        naoHaMov.setTrue() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs102a701() ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                haMov.setTrue() ;
                break;
            case NOTFND:
                a5900AcederHstNormal() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                bghl102a().detalhe().cTransaccao().set(hv10201Movhstcpl().movhstcpl().cTransaccao());
                bghl102a().detalhe().aAplicacao().set(hv10201Movhstcpl().movhstcpl().aAplicacao());
                bghl102a().detalhe().cOpczMenu().set(hv10201Movhstcpl().movhstcpl().cOpczMenu());
                bghl102a().detalhe().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
                bghl102a().detalhe().cEvenOpel().set(hv10201Movhstcpl().movhstcpl().cEvenOpel());
                bghl102a().detalhe().cOperador().set(hv10201Movhstcpl().movhstcpl().cOperador());
                bghl102a().detalhe().cOpexAtrx().set(hv10201Movhstcpl().movhstcpl().cOpexAtrx());
                bghl102a().detalhe().cUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
                bghl102a().detalhe().tCambio().set(hv10201Movhstcpl().movhstcpl().tCambio());
                bghl102a().detalhe().nmArqvOrig().set(hv10201Movhstcpl().movhstcpl().nmArqvOrig());
                /**
                 * PASSIVAS 2540 - 2018-03-13 - INI
                 */
                bghl102a().detalhe().categMov().set(hv10201Movhstcpl().movhstcpl().cCatgMov());
                /**
                 * PASSIVAS 2540 - 2018-03-13 - FIM
                 */
                a5411ObtemTsActz() ;
            } else {
                /**
                 * MOVE VGH10201-TS-ACTZ-ULT   TO MGH102A-TS-ACTZ-ULT
                 */
                bghl102a().detalhe().cTransaccao().set(hrMghs203a().bghl203a().detalhe().cTransaccao());
                bghl102a().detalhe().aAplicacao().set(hrMghs203a().bghl203a().detalhe().aAplicacao());
                bghl102a().detalhe().cOpczMenu().set(hrMghs203a().bghl203a().detalhe().cOpczMenu());
                bghl102a().detalhe().cOpeBbn().set(hrMghs203a().bghl203a().detalhe().cOpeBbn());
                bghl102a().detalhe().cEvenOpel().set(hrMghs203a().bghl203a().detalhe().cEvenOpel());
                bghl102a().detalhe().cOperador().set(hrMghs203a().bghl203a().detalhe().cOperador());
                bghl102a().detalhe().cOpexAtrx().set(hrMghs203a().bghl203a().detalhe().cOpexAtrx());
                bghl102a().detalhe().cUserid().set(hrMghs203a().bghl203a().detalhe().cUserid());
                bghl102a().detalhe().tCambio().set(hrMghs203a().bghl203a().detalhe().tCambio());
                bghl102a().detalhe().nmArqvOrig().set(hrMghs203a().bghl203a().detalhe().nmArqvOrig());
                bghl102a().detalhe().tsActzUlt().set(hrMghs203a().bghl203a().detalhe().tsActzUlt());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5411ObtemTsActz() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectMghs102a793(hv10201Movhstcpl().movhstcpl()) ;
        switch (hv00201Movhst().getPersistenceCode()) {
            case NORMAL:
                bghl102a().detalhe().tsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
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
    public void a5420AcedeTgh022Q() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectMghs102a827() ;
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl102a().detalhe().aAplicacao().set(hv02201Movdiaant().movdiaant().aAplicacao());
            bghl102a().detalhe().cOpczMenu().set(hv02201Movdiaant().movdiaant().cOpczMenu());
            bghl102a().detalhe().cOpeBbn().set(hv02201Movdiaant().movdiaant().cOpeBbn());
            bghl102a().detalhe().cEvenOpel().set(hv02201Movdiaant().movdiaant().cEvenOpel());
            bghl102a().detalhe().cUserid().set(hv02201Movdiaant().movdiaant().cUserid());
            bghl102a().detalhe().tCambio().set(hv02201Movdiaant().movdiaant().tCambio());
            bghl102a().detalhe().nmArqvOrig().set("HO");
            bghl102a().detalhe().tsActzUlt().set(hv02201Movdiaant().movdiaant().tsActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl102a().criterioConsulta().movHstS().isTrue()) {
            a5510AcedeTgh102S() ;
        } else {
            a5520AcedeTgh022S() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5510AcedeTgh102S() {
        naoHaMov.setTrue() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs102a893() ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                haMov.setTrue() ;
                break;
            case NOTFND:
                a5900AcederHstNormal() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                bghl102a().detalhe().mSldoRetd().set(hv10201Movhstcpl().movhstcpl().mSldoRetd());
                bghl102a().detalhe().mSldoVcob().set(hv10201Movhstcpl().movhstcpl().mSldoVcob());
                bghl102a().detalhe().mCmrgLim().set(hv10201Movhstcpl().movhstcpl().mCmrgLim());
                bghl102a().detalhe().mCmrgUtid().set(hv10201Movhstcpl().movhstcpl().mCmrgUtid());
                bghl102a().detalhe().mDcboNgcdAtrd().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd());
                bghl102a().detalhe().mDcboNgcdUtid().set(hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid());
                /**
                 * PASSIVAS 2540 - 2018-03-13 - INI
                 */
                bghl102a().detalhe().categMov().set(hv10201Movhstcpl().movhstcpl().cCatgMov());
            } else {
                /**
                 * PASSIVAS 2540 - 2018-03-13 - FIM
                 */
                bghl102a().detalhe().mSldoRetd().set(hrMghs203a().bghl203a().detalhe().mSldoRetd());
                bghl102a().detalhe().mSldoVcob().set(hrMghs203a().bghl203a().detalhe().mSldoVcob());
                bghl102a().detalhe().mCmrgLim().set(hrMghs203a().bghl203a().detalhe().mCmrgLim());
                bghl102a().detalhe().mCmrgUtid().set(hrMghs203a().bghl203a().detalhe().mCmrgUtid());
                bghl102a().detalhe().mDcboNgcdAtrd().set(hrMghs203a().bghl203a().detalhe().mDcboNgcdAtrd());
                bghl102a().detalhe().mDcboNgcdUtid().set(hrMghs203a().bghl203a().detalhe().mDcboNgcdUtid());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5520AcedeTgh022S() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectMghs102a968() ;
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl102a().detalhe().mSldoRetd().set(hv02201Movdiaant().movdiaant().mSldoRetd());
            bghl102a().detalhe().mSldoVcob().set(hv02201Movdiaant().movdiaant().mSldoVcob());
            bghl102a().detalhe().mCmrgLim().set(hv02201Movdiaant().movdiaant().mCmrgLim());
            bghl102a().detalhe().mCmrgUtid().set(hv02201Movdiaant().movdiaant().mCmrgUtid());
            bghl102a().detalhe().mDcboNgcdAtrd().set(hv02201Movdiaant().movdiaant().mDcboNgcdAtrd());
            bghl102a().detalhe().mDcboNgcdUtid().set(hv02201Movdiaant().movdiaant().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5600CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl102a().criterioConsulta().movHstS().isTrue()) {
            a5610AcedeTgh102P() ;
        } else {
            a5620AcedeTgh022P() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5610AcedeTgh102P() {
        naoHaMov.setTrue() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs102a1032() ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                haMov.setTrue() ;
                break;
            case NOTFND:
                a5900AcederHstNormal() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                bghl102a().detalhe().cProdSgop().set(hv10201Movhstcpl().movhstcpl().cProdSgop());
                bghl102a().detalhe().cFamiProd().set(hv10201Movhstcpl().movhstcpl().cFamiProd());
                bghl102a().detalhe().cProduto().set(hv10201Movhstcpl().movhstcpl().cProduto());
                bghl102a().detalhe().cCndzMovzCont().set(hv10201Movhstcpl().movhstcpl().cCndzMovzCont());
                bghl102a().detalhe().cGrupCont().set(hv10201Movhstcpl().movhstcpl().cGrupCont());
                bghl102a().detalhe().cTipoIttz().set(hv10201Movhstcpl().movhstcpl().cTipoIttz());
            } else {
                bghl102a().detalhe().cProdSgop().set(hrMghs203a().bghl203a().detalhe().cProdSgop());
                bghl102a().detalhe().cFamiProd().set(hrMghs203a().bghl203a().detalhe().cFamiProd());
                bghl102a().detalhe().cProduto().set(hrMghs203a().bghl203a().detalhe().cProduto());
                bghl102a().detalhe().cCndzMovzCont().set(hrMghs203a().bghl203a().detalhe().cCndzMovzCont());
                bghl102a().detalhe().cGrupCont().set(hrMghs203a().bghl203a().detalhe().cGrupCont());
                bghl102a().detalhe().cTipoIttz().set(hrMghs203a().bghl203a().detalhe().cTipoIttz());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5620AcedeTgh022P() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectMghs102a1096() ;
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl102a().detalhe().cFamiProd().set(hv02201Movdiaant().movdiaant().cFamiProd());
            bghl102a().detalhe().cProduto().set(hv02201Movdiaant().movdiaant().cProduto());
            bghl102a().detalhe().cTipoIttz().set(hv02201Movdiaant().movdiaant().cSectIttlBpor());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5700CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl102a().criterioConsulta().movHstS().isTrue()) {
            a5710AcedeTgh102J() ;
        } else {
            a5720AcedeTgh022J() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5710AcedeTgh102J() {
        naoHaMov.setTrue() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs102a1150() ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                haMov.setTrue() ;
                break;
            case NOTFND:
                a5900AcederHstNormal() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                bghl102a().detalhe().cPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
                bghl102a().detalhe().cMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
                bghl102a().detalhe().cOeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
                bghl102a().detalhe().cUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
                bghl102a().detalhe().nJourBbn().set(hv10201Movhstcpl().movhstcpl().nJourBbn());
                bghl102a().detalhe().nsJourBbn().set(hv10201Movhstcpl().movhstcpl().nsJourBbn());
                bghl102a().detalhe().nsJourBbnDtlh().set(hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh());
            } else {
                bghl102a().detalhe().cPaisIsoaOeOpx().set(hrMghs203a().bghl203a().detalhe().cPaisIsoaOeOpx());
                bghl102a().detalhe().cMnemEgcOpex().set(hrMghs203a().bghl203a().detalhe().cMnemEgcOpex());
                bghl102a().detalhe().cOeEgcOpex().set(hrMghs203a().bghl203a().detalhe().cOeEgcOpex());
                bghl102a().detalhe().cUserid().set(hrMghs203a().bghl203a().detalhe().cUserid());
                bghl102a().detalhe().nJourBbn().set(hrMghs203a().bghl203a().detalhe().nJourBbn());
                bghl102a().detalhe().nsJourBbn().set(hrMghs203a().bghl203a().detalhe().nsJourBbn());
                bghl102a().detalhe().nsJourBbnDtlh().set(hrMghs203a().bghl203a().detalhe().nsJourBbnDtlh());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5720AcedeTgh022J() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH02201_MOVDIAANT
         */
        hv02201Movdiaant().selectMghs102a1224() ;
        if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl102a().detalhe().cPaisIsoaOeOpx().set(hv02201Movdiaant().movdiaant().cPaisIsoaOeOpx());
            bghl102a().detalhe().cMnemEgcOpex().set(hv02201Movdiaant().movdiaant().cMnemEgcOpex());
            bghl102a().detalhe().cOeEgcOpex().set(hv02201Movdiaant().movdiaant().cOeEgcOpex());
            bghl102a().detalhe().cUserid().set(hv02201Movdiaant().movdiaant().cUserid());
            bghl102a().detalhe().nJourBbn().set(hv02201Movdiaant().movdiaant().nJourBbn());
            bghl102a().detalhe().nsJourBbn().set(hv02201Movdiaant().movdiaant().nsJourBbn());
            bghl102a().detalhe().nsJourBbnDtlh().set(hv02201Movdiaant().movdiaant().nsJourBbnDtlh());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5900AcederHstNormal() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs203a().bghl203a().initialize() ;
        hrMghs203a().bghl203a().criterioConsulta().iCriterioCns().set(bghl102a().criterioConsulta().iCriterioCns());
        hrMghs203a().bghl203a().argumento().cPaisIsoaCont().set(bghl102a().argumento().cPaisIsoaCont());
        hrMghs203a().bghl203a().argumento().cBancCont().set(bghl102a().argumento().cBancCont());
        hrMghs203a().bghl203a().argumento().cOeEgcCont().set(bghl102a().argumento().cOeEgcCont());
        hrMghs203a().bghl203a().argumento().nsRdclCont().set(bghl102a().argumento().nsRdclCont());
        hrMghs203a().bghl203a().argumento().vChkdCont().set(bghl102a().argumento().vChkdCont());
        hrMghs203a().bghl203a().argumento().cTipoCont().set(bghl102a().argumento().cTipoCont());
        hrMghs203a().bghl203a().argumento().cMoedIsoScta().set(bghl102a().argumento().cMoedIsoScta());
        hrMghs203a().bghl203a().argumento().nsDeposito().set(bghl102a().argumento().nsDeposito());
        hrMghs203a().bghl203a().argumento().tsMovimento().set(bghl102a().argumento().tsMovimento());
        hrMghs203a().bghl203a().argumento().nsMovimento().set(bghl102a().argumento().nsMovimento());
        hrMghs203a().run() ;
        if (!hrMghs203a().bghl203a().ok().isTrue()) {
            progStatus.set(hrMghs203a().bghl203a().cRetorno());
            hrMghs203a().setPersistenceCode(hrMghs203a().bghl203a().cSqlcode()) ;
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
        bghl102a().cRetorno().set(progStatus);
        bghl102a().cSqlcode().set(getPersistenceCode());
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
