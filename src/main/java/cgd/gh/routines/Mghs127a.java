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
import cgd.gh.structures.link.Bghl127a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00127_MOVHSTCP7
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS127A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs127a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl127a
     */
    @Data
    public abstract Bghl127a bghl127a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps12701Movhstcp7
     */
    @Data
    protected abstract Vwsdghps12701Movhstcp7 hv12701Movhstcp7() ;
    
    
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
        bghl127a().cRetorno().initialize() ;
        bghl127a().cSqlcode().initialize() ;
        if (bghl127a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl127a().argumento().cBancCont().isEqual(0) || 
            bghl127a().argumento().cOeEgcCont().isEqual(0) || 
            bghl127a().argumento().nsRdclCont().isEqual(0) || 
            bghl127a().argumento().cMoedIsoScta().isEmpty() || 
            bghl127a().argumento().tsMovimento().isEmpty() || 
            bghl127a().argumento().nsMovimento().isEqual(0) || 
            bghl127a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl127a().criterioConsulta().iCriterioCns());
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
        hv12701Movhstcp7().movhstcp7().initialize() ;
        hv12701Movhstcp7().movhstcp7().cPaisIsoaCont().set(bghl127a().argumento().cPaisIsoaCont());
        hv12701Movhstcp7().movhstcp7().cBancCont().set(bghl127a().argumento().cBancCont());
        hv12701Movhstcp7().movhstcp7().cOeEgcCont().set(bghl127a().argumento().cOeEgcCont());
        hv12701Movhstcp7().movhstcp7().nsRdclCont().set(bghl127a().argumento().nsRdclCont());
        hv12701Movhstcp7().movhstcp7().vChkdCont().set(bghl127a().argumento().vChkdCont());
        hv12701Movhstcp7().movhstcp7().cTipoCont().set(bghl127a().argumento().cTipoCont());
        hv12701Movhstcp7().movhstcp7().cMoedIsoScta().set(bghl127a().argumento().cMoedIsoScta());
        hv12701Movhstcp7().movhstcp7().nsDeposito().set(bghl127a().argumento().nsDeposito());
        hv12701Movhstcp7().movhstcp7().tsMovimento().set(bghl127a().argumento().tsMovimento());
        hv12701Movhstcp7().movhstcp7().nsMovimento().set(bghl127a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs127a186() ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl127a().detalhe().cTransaccao().set(hv12701Movhstcp7().movhstcp7().cTransaccao());
            bghl127a().detalhe().aAplicacao().set(hv12701Movhstcp7().movhstcp7().aAplicacao());
            bghl127a().detalhe().cOpczMenu().set(hv12701Movhstcp7().movhstcp7().cOpczMenu());
            bghl127a().detalhe().cOpeBbn().set(hv12701Movhstcp7().movhstcp7().cOpeBbn());
            bghl127a().detalhe().cEvenOpel().set(hv12701Movhstcp7().movhstcp7().cEvenOpel());
            bghl127a().detalhe().cTerminal().set(hv12701Movhstcp7().movhstcp7().cTerminal());
            bghl127a().detalhe().cOperador().set(hv12701Movhstcp7().movhstcp7().cOperador());
            bghl127a().detalhe().cOpexAtrx().set(hv12701Movhstcp7().movhstcp7().cOpexAtrx());
            bghl127a().detalhe().cUserid().set(hv12701Movhstcp7().movhstcp7().cUserid());
            bghl127a().detalhe().cTipoCanlAces().set(hv12701Movhstcp7().movhstcp7().cTipoCanlAces());
            bghl127a().detalhe().cPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            bghl127a().detalhe().cMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            bghl127a().detalhe().cOeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
            bghl127a().detalhe().cProdSgop().set(hv12701Movhstcp7().movhstcp7().cProdSgop());
            bghl127a().detalhe().cFamiProd().set(hv12701Movhstcp7().movhstcp7().cFamiProd());
            bghl127a().detalhe().cProduto().set(hv12701Movhstcp7().movhstcp7().cProduto());
            bghl127a().detalhe().cCndzMovzCont().set(hv12701Movhstcp7().movhstcp7().cCndzMovzCont());
            bghl127a().detalhe().cGrupCont().set(hv12701Movhstcp7().movhstcp7().cGrupCont());
            bghl127a().detalhe().cTipoIttz().set(hv12701Movhstcp7().movhstcp7().cTipoIttz());
            bghl127a().detalhe().tCambio().set(hv12701Movhstcp7().movhstcp7().tCambio());
            bghl127a().detalhe().mSldoRetd().set(hv12701Movhstcp7().movhstcp7().mSldoRetd());
            bghl127a().detalhe().mSldoVcob().set(hv12701Movhstcp7().movhstcp7().mSldoVcob());
            bghl127a().detalhe().mCmrgLim().set(hv12701Movhstcp7().movhstcp7().mCmrgLim());
            bghl127a().detalhe().mCmrgUtid().set(hv12701Movhstcp7().movhstcp7().mCmrgUtid());
            bghl127a().detalhe().mDcboNgcdAtrd().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd());
            bghl127a().detalhe().mDcboNgcdUtid().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid());
            bghl127a().detalhe().nJourBbn().set(hv12701Movhstcp7().movhstcp7().nJourBbn());
            bghl127a().detalhe().nsJourBbn().set(hv12701Movhstcp7().movhstcp7().nsJourBbn());
            bghl127a().detalhe().nsJourBbnDtlh().set(hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh());
            bghl127a().detalhe().nmArqvOrig().set(hv12701Movhstcp7().movhstcp7().nmArqvOrig());
            bghl127a().detalhe().tsActzUlt().set(hv12701Movhstcp7().movhstcp7().tsActzUlt());
            bghl127a().detalhe().cUsidActzUlt().set(hv12701Movhstcp7().movhstcp7().cUsidActzUlt());
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
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs127a324() ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl127a().detalhe().cTipoCanlAces().set(hv12701Movhstcp7().movhstcp7().cTipoCanlAces());
            bghl127a().detalhe().cTerminal().set(hv12701Movhstcp7().movhstcp7().cTerminal());
            bghl127a().detalhe().cPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            bghl127a().detalhe().cMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            bghl127a().detalhe().cOeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
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
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs127a375() ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl127a().detalhe().cTransaccao().set(hv12701Movhstcp7().movhstcp7().cTransaccao());
            bghl127a().detalhe().aAplicacao().set(hv12701Movhstcp7().movhstcp7().aAplicacao());
            bghl127a().detalhe().cOpczMenu().set(hv12701Movhstcp7().movhstcp7().cOpczMenu());
            bghl127a().detalhe().cOpeBbn().set(hv12701Movhstcp7().movhstcp7().cOpeBbn());
            bghl127a().detalhe().cEvenOpel().set(hv12701Movhstcp7().movhstcp7().cEvenOpel());
            bghl127a().detalhe().cOperador().set(hv12701Movhstcp7().movhstcp7().cOperador());
            bghl127a().detalhe().cOpexAtrx().set(hv12701Movhstcp7().movhstcp7().cOpexAtrx());
            bghl127a().detalhe().cUserid().set(hv12701Movhstcp7().movhstcp7().cUserid());
            bghl127a().detalhe().tCambio().set(hv12701Movhstcp7().movhstcp7().tCambio());
            bghl127a().detalhe().nmArqvOrig().set(hv12701Movhstcp7().movhstcp7().nmArqvOrig());
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
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs127a439() ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl127a().detalhe().mSldoRetd().set(hv12701Movhstcp7().movhstcp7().mSldoRetd());
            bghl127a().detalhe().mSldoVcob().set(hv12701Movhstcp7().movhstcp7().mSldoVcob());
            bghl127a().detalhe().mCmrgLim().set(hv12701Movhstcp7().movhstcp7().mCmrgLim());
            bghl127a().detalhe().mCmrgUtid().set(hv12701Movhstcp7().movhstcp7().mCmrgUtid());
            bghl127a().detalhe().mDcboNgcdAtrd().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd());
            bghl127a().detalhe().mDcboNgcdUtid().set(hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid());
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
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs127a493() ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl127a().detalhe().cProdSgop().set(hv12701Movhstcp7().movhstcp7().cProdSgop());
            bghl127a().detalhe().cFamiProd().set(hv12701Movhstcp7().movhstcp7().cFamiProd());
            bghl127a().detalhe().cProduto().set(hv12701Movhstcp7().movhstcp7().cProduto());
            bghl127a().detalhe().cCndzMovzCont().set(hv12701Movhstcp7().movhstcp7().cCndzMovzCont());
            bghl127a().detalhe().cGrupCont().set(hv12701Movhstcp7().movhstcp7().cGrupCont());
            bghl127a().detalhe().cTipoIttz().set(hv12701Movhstcp7().movhstcp7().cTipoIttz());
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
         * call to extracted method to access (SELECT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().selectMghs127a545() ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl127a().detalhe().cPaisIsoaOeOpx().set(hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx());
            bghl127a().detalhe().cMnemEgcOpex().set(hv12701Movhstcp7().movhstcp7().cMnemEgcOpex());
            bghl127a().detalhe().cOeEgcOpex().set(hv12701Movhstcp7().movhstcp7().cOeEgcOpex());
            bghl127a().detalhe().cUserid().set(hv12701Movhstcp7().movhstcp7().cUserid());
            bghl127a().detalhe().nJourBbn().set(hv12701Movhstcp7().movhstcp7().nJourBbn());
            bghl127a().detalhe().nsJourBbn().set(hv12701Movhstcp7().movhstcp7().nsJourBbn());
            bghl127a().detalhe().nsJourBbnDtlh().set(hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh());
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
        bghl127a().cRetorno().set(progStatus);
        bghl127a().cSqlcode().set(getPersistenceCode());
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
