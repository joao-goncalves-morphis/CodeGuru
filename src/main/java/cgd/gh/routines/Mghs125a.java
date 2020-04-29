package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl125a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00123_MOVHSTCP5
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS125A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs125a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl125a
     */
    @Data
    public abstract Bghl125a bghl125a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps12501Movhstcp5
     */
    @Data
    protected abstract Vwsdghps12501Movhstcp5 hv12501Movhstcp5() ;
    
    
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
        bghl125a().cRetorno().initialize() ;
        bghl125a().cSqlcode().initialize() ;
        if (bghl125a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl125a().argumento().cBancCont().isEqual(0) || 
            bghl125a().argumento().cOeEgcCont().isEqual(0) || 
            bghl125a().argumento().nsRdclCont().isEqual(0) || 
            bghl125a().argumento().cMoedIsoScta().isEmpty() || 
            bghl125a().argumento().tsMovimento().isEmpty() || 
            bghl125a().argumento().nsMovimento().isEqual(0) || 
            bghl125a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl125a().criterioConsulta().iCriterioCns());
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
        hv12501Movhstcp5().movhstcp5().initialize() ;
        hv12501Movhstcp5().movhstcp5().cPaisIsoaCont().set(bghl125a().argumento().cPaisIsoaCont());
        hv12501Movhstcp5().movhstcp5().cBancCont().set(bghl125a().argumento().cBancCont());
        hv12501Movhstcp5().movhstcp5().cOeEgcCont().set(bghl125a().argumento().cOeEgcCont());
        hv12501Movhstcp5().movhstcp5().nsRdclCont().set(bghl125a().argumento().nsRdclCont());
        hv12501Movhstcp5().movhstcp5().vChkdCont().set(bghl125a().argumento().vChkdCont());
        hv12501Movhstcp5().movhstcp5().cTipoCont().set(bghl125a().argumento().cTipoCont());
        hv12501Movhstcp5().movhstcp5().cMoedIsoScta().set(bghl125a().argumento().cMoedIsoScta());
        hv12501Movhstcp5().movhstcp5().nsDeposito().set(bghl125a().argumento().nsDeposito());
        hv12501Movhstcp5().movhstcp5().tsMovimento().set(bghl125a().argumento().tsMovimento());
        hv12501Movhstcp5().movhstcp5().nsMovimento().set(bghl125a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs125a186() ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl125a().detalhe().cTransaccao().set(hv12501Movhstcp5().movhstcp5().cTransaccao());
            bghl125a().detalhe().aAplicacao().set(hv12501Movhstcp5().movhstcp5().aAplicacao());
            bghl125a().detalhe().cOpczMenu().set(hv12501Movhstcp5().movhstcp5().cOpczMenu());
            bghl125a().detalhe().cOpeBbn().set(hv12501Movhstcp5().movhstcp5().cOpeBbn());
            bghl125a().detalhe().cEvenOpel().set(hv12501Movhstcp5().movhstcp5().cEvenOpel());
            bghl125a().detalhe().cTerminal().set(hv12501Movhstcp5().movhstcp5().cTerminal());
            bghl125a().detalhe().cOperador().set(hv12501Movhstcp5().movhstcp5().cOperador());
            bghl125a().detalhe().cOpexAtrx().set(hv12501Movhstcp5().movhstcp5().cOpexAtrx());
            bghl125a().detalhe().cUserid().set(hv12501Movhstcp5().movhstcp5().cUserid());
            bghl125a().detalhe().cTipoCanlAces().set(hv12501Movhstcp5().movhstcp5().cTipoCanlAces());
            bghl125a().detalhe().cPaisIsoaOeOpx().set(hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx());
            bghl125a().detalhe().cMnemEgcOpex().set(hv12501Movhstcp5().movhstcp5().cMnemEgcOpex());
            bghl125a().detalhe().cOeEgcOpex().set(hv12501Movhstcp5().movhstcp5().cOeEgcOpex());
            bghl125a().detalhe().cProdSgop().set(hv12501Movhstcp5().movhstcp5().cProdSgop());
            bghl125a().detalhe().cFamiProd().set(hv12501Movhstcp5().movhstcp5().cFamiProd());
            bghl125a().detalhe().cProduto().set(hv12501Movhstcp5().movhstcp5().cProduto());
            bghl125a().detalhe().cCndzMovzCont().set(hv12501Movhstcp5().movhstcp5().cCndzMovzCont());
            bghl125a().detalhe().cGrupCont().set(hv12501Movhstcp5().movhstcp5().cGrupCont());
            bghl125a().detalhe().cTipoIttz().set(hv12501Movhstcp5().movhstcp5().cTipoIttz());
            bghl125a().detalhe().tCambio().set(hv12501Movhstcp5().movhstcp5().tCambio());
            bghl125a().detalhe().mSldoRetd().set(hv12501Movhstcp5().movhstcp5().mSldoRetd());
            bghl125a().detalhe().mSldoVcob().set(hv12501Movhstcp5().movhstcp5().mSldoVcob());
            bghl125a().detalhe().mCmrgLim().set(hv12501Movhstcp5().movhstcp5().mCmrgLim());
            bghl125a().detalhe().mCmrgUtid().set(hv12501Movhstcp5().movhstcp5().mCmrgUtid());
            bghl125a().detalhe().mDcboNgcdAtrd().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdAtrd());
            bghl125a().detalhe().mDcboNgcdUtid().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdUtid());
            bghl125a().detalhe().nJourBbn().set(hv12501Movhstcp5().movhstcp5().nJourBbn());
            bghl125a().detalhe().nsJourBbn().set(hv12501Movhstcp5().movhstcp5().nsJourBbn());
            bghl125a().detalhe().nsJourBbnDtlh().set(hv12501Movhstcp5().movhstcp5().nsJourBbnDtlh());
            bghl125a().detalhe().nmArqvOrig().set(hv12501Movhstcp5().movhstcp5().nmArqvOrig());
            bghl125a().detalhe().tsActzUlt().set(hv12501Movhstcp5().movhstcp5().tsActzUlt());
            bghl125a().detalhe().cUsidActzUlt().set(hv12501Movhstcp5().movhstcp5().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300CriterioOnde() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs125a324() ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl125a().detalhe().cTipoCanlAces().set(hv12501Movhstcp5().movhstcp5().cTipoCanlAces());
            bghl125a().detalhe().cTerminal().set(hv12501Movhstcp5().movhstcp5().cTerminal());
            bghl125a().detalhe().cPaisIsoaOeOpx().set(hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx());
            bghl125a().detalhe().cMnemEgcOpex().set(hv12501Movhstcp5().movhstcp5().cMnemEgcOpex());
            bghl125a().detalhe().cOeEgcOpex().set(hv12501Movhstcp5().movhstcp5().cOeEgcOpex());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400CriterioQuem() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs125a375() ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl125a().detalhe().cTransaccao().set(hv12501Movhstcp5().movhstcp5().cTransaccao());
            bghl125a().detalhe().aAplicacao().set(hv12501Movhstcp5().movhstcp5().aAplicacao());
            bghl125a().detalhe().cOpczMenu().set(hv12501Movhstcp5().movhstcp5().cOpczMenu());
            bghl125a().detalhe().cOpeBbn().set(hv12501Movhstcp5().movhstcp5().cOpeBbn());
            bghl125a().detalhe().cEvenOpel().set(hv12501Movhstcp5().movhstcp5().cEvenOpel());
            bghl125a().detalhe().cOperador().set(hv12501Movhstcp5().movhstcp5().cOperador());
            bghl125a().detalhe().cOpexAtrx().set(hv12501Movhstcp5().movhstcp5().cOpexAtrx());
            bghl125a().detalhe().cUserid().set(hv12501Movhstcp5().movhstcp5().cUserid());
            bghl125a().detalhe().tCambio().set(hv12501Movhstcp5().movhstcp5().tCambio());
            bghl125a().detalhe().nmArqvOrig().set(hv12501Movhstcp5().movhstcp5().nmArqvOrig());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500CriterioSaldos() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs125a439() ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl125a().detalhe().mSldoRetd().set(hv12501Movhstcp5().movhstcp5().mSldoRetd());
            bghl125a().detalhe().mSldoVcob().set(hv12501Movhstcp5().movhstcp5().mSldoVcob());
            bghl125a().detalhe().mCmrgLim().set(hv12501Movhstcp5().movhstcp5().mCmrgLim());
            bghl125a().detalhe().mCmrgUtid().set(hv12501Movhstcp5().movhstcp5().mCmrgUtid());
            bghl125a().detalhe().mDcboNgcdAtrd().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdAtrd());
            bghl125a().detalhe().mDcboNgcdUtid().set(hv12501Movhstcp5().movhstcp5().mDcboNgcdUtid());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5600CriterioPosicao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs125a493() ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl125a().detalhe().cProdSgop().set(hv12501Movhstcp5().movhstcp5().cProdSgop());
            bghl125a().detalhe().cFamiProd().set(hv12501Movhstcp5().movhstcp5().cFamiProd());
            bghl125a().detalhe().cProduto().set(hv12501Movhstcp5().movhstcp5().cProduto());
            bghl125a().detalhe().cCndzMovzCont().set(hv12501Movhstcp5().movhstcp5().cCndzMovzCont());
            bghl125a().detalhe().cGrupCont().set(hv12501Movhstcp5().movhstcp5().cGrupCont());
            bghl125a().detalhe().cTipoIttz().set(hv12501Movhstcp5().movhstcp5().cTipoIttz());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5700CriterioJour() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().selectMghs125a545() ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl125a().detalhe().cPaisIsoaOeOpx().set(hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx());
            bghl125a().detalhe().cMnemEgcOpex().set(hv12501Movhstcp5().movhstcp5().cMnemEgcOpex());
            bghl125a().detalhe().cOeEgcOpex().set(hv12501Movhstcp5().movhstcp5().cOeEgcOpex());
            bghl125a().detalhe().cUserid().set(hv12501Movhstcp5().movhstcp5().cUserid());
            bghl125a().detalhe().nJourBbn().set(hv12501Movhstcp5().movhstcp5().nJourBbn());
            bghl125a().detalhe().nsJourBbn().set(hv12501Movhstcp5().movhstcp5().nsJourBbn());
            bghl125a().detalhe().nsJourBbnDtlh().set(hv12501Movhstcp5().movhstcp5().nsJourBbnDtlh());
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
        bghl125a().cRetorno().set(progStatus);
        bghl125a().cSqlcode().set(getPersistenceCode());
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
}
