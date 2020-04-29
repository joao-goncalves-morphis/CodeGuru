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
import cgd.gh.structures.link.Bghl126a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00123_MOVHSTCP6
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS126A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs126a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl126a
     */
    @Data
    public abstract Bghl126a bghl126a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps12601Movhstcp6
     */
    @Data
    protected abstract Vwsdghps12601Movhstcp6 hv12601Movhstcp6() ;
    
    
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
        bghl126a().cRetorno().initialize() ;
        bghl126a().cSqlcode().initialize() ;
        if (bghl126a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl126a().argumento().cBancCont().isEqual(0) || 
            bghl126a().argumento().cOeEgcCont().isEqual(0) || 
            bghl126a().argumento().nsRdclCont().isEqual(0) || 
            bghl126a().argumento().cMoedIsoScta().isEmpty() || 
            bghl126a().argumento().tsMovimento().isEmpty() || 
            bghl126a().argumento().nsMovimento().isEqual(0) || 
            bghl126a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl126a().criterioConsulta().iCriterioCns());
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
        hv12601Movhstcp6().movhstcp6().initialize() ;
        hv12601Movhstcp6().movhstcp6().cPaisIsoaCont().set(bghl126a().argumento().cPaisIsoaCont());
        hv12601Movhstcp6().movhstcp6().cBancCont().set(bghl126a().argumento().cBancCont());
        hv12601Movhstcp6().movhstcp6().cOeEgcCont().set(bghl126a().argumento().cOeEgcCont());
        hv12601Movhstcp6().movhstcp6().nsRdclCont().set(bghl126a().argumento().nsRdclCont());
        hv12601Movhstcp6().movhstcp6().vChkdCont().set(bghl126a().argumento().vChkdCont());
        hv12601Movhstcp6().movhstcp6().cTipoCont().set(bghl126a().argumento().cTipoCont());
        hv12601Movhstcp6().movhstcp6().cMoedIsoScta().set(bghl126a().argumento().cMoedIsoScta());
        hv12601Movhstcp6().movhstcp6().nsDeposito().set(bghl126a().argumento().nsDeposito());
        hv12601Movhstcp6().movhstcp6().tsMovimento().set(bghl126a().argumento().tsMovimento());
        hv12601Movhstcp6().movhstcp6().nsMovimento().set(bghl126a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs126a186() ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl126a().detalhe().cTransaccao().set(hv12601Movhstcp6().movhstcp6().cTransaccao());
            bghl126a().detalhe().aAplicacao().set(hv12601Movhstcp6().movhstcp6().aAplicacao());
            bghl126a().detalhe().cOpczMenu().set(hv12601Movhstcp6().movhstcp6().cOpczMenu());
            bghl126a().detalhe().cOpeBbn().set(hv12601Movhstcp6().movhstcp6().cOpeBbn());
            bghl126a().detalhe().cEvenOpel().set(hv12601Movhstcp6().movhstcp6().cEvenOpel());
            bghl126a().detalhe().cTerminal().set(hv12601Movhstcp6().movhstcp6().cTerminal());
            bghl126a().detalhe().cOperador().set(hv12601Movhstcp6().movhstcp6().cOperador());
            bghl126a().detalhe().cOpexAtrx().set(hv12601Movhstcp6().movhstcp6().cOpexAtrx());
            bghl126a().detalhe().cUserid().set(hv12601Movhstcp6().movhstcp6().cUserid());
            bghl126a().detalhe().cTipoCanlAces().set(hv12601Movhstcp6().movhstcp6().cTipoCanlAces());
            bghl126a().detalhe().cPaisIsoaOeOpx().set(hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx());
            bghl126a().detalhe().cMnemEgcOpex().set(hv12601Movhstcp6().movhstcp6().cMnemEgcOpex());
            bghl126a().detalhe().cOeEgcOpex().set(hv12601Movhstcp6().movhstcp6().cOeEgcOpex());
            bghl126a().detalhe().cProdSgop().set(hv12601Movhstcp6().movhstcp6().cProdSgop());
            bghl126a().detalhe().cFamiProd().set(hv12601Movhstcp6().movhstcp6().cFamiProd());
            bghl126a().detalhe().cProduto().set(hv12601Movhstcp6().movhstcp6().cProduto());
            bghl126a().detalhe().cCndzMovzCont().set(hv12601Movhstcp6().movhstcp6().cCndzMovzCont());
            bghl126a().detalhe().cGrupCont().set(hv12601Movhstcp6().movhstcp6().cGrupCont());
            bghl126a().detalhe().cTipoIttz().set(hv12601Movhstcp6().movhstcp6().cTipoIttz());
            bghl126a().detalhe().tCambio().set(hv12601Movhstcp6().movhstcp6().tCambio());
            bghl126a().detalhe().mSldoRetd().set(hv12601Movhstcp6().movhstcp6().mSldoRetd());
            bghl126a().detalhe().mSldoVcob().set(hv12601Movhstcp6().movhstcp6().mSldoVcob());
            bghl126a().detalhe().mCmrgLim().set(hv12601Movhstcp6().movhstcp6().mCmrgLim());
            bghl126a().detalhe().mCmrgUtid().set(hv12601Movhstcp6().movhstcp6().mCmrgUtid());
            bghl126a().detalhe().mDcboNgcdAtrd().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdAtrd());
            bghl126a().detalhe().mDcboNgcdUtid().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdUtid());
            bghl126a().detalhe().nJourBbn().set(hv12601Movhstcp6().movhstcp6().nJourBbn());
            bghl126a().detalhe().nsJourBbn().set(hv12601Movhstcp6().movhstcp6().nsJourBbn());
            bghl126a().detalhe().nsJourBbnDtlh().set(hv12601Movhstcp6().movhstcp6().nsJourBbnDtlh());
            bghl126a().detalhe().nmArqvOrig().set(hv12601Movhstcp6().movhstcp6().nmArqvOrig());
            bghl126a().detalhe().tsActzUlt().set(hv12601Movhstcp6().movhstcp6().tsActzUlt());
            bghl126a().detalhe().cUsidActzUlt().set(hv12601Movhstcp6().movhstcp6().cUsidActzUlt());
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
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs126a324() ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl126a().detalhe().cTipoCanlAces().set(hv12601Movhstcp6().movhstcp6().cTipoCanlAces());
            bghl126a().detalhe().cTerminal().set(hv12601Movhstcp6().movhstcp6().cTerminal());
            bghl126a().detalhe().cPaisIsoaOeOpx().set(hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx());
            bghl126a().detalhe().cMnemEgcOpex().set(hv12601Movhstcp6().movhstcp6().cMnemEgcOpex());
            bghl126a().detalhe().cOeEgcOpex().set(hv12601Movhstcp6().movhstcp6().cOeEgcOpex());
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
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs126a375() ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl126a().detalhe().cTransaccao().set(hv12601Movhstcp6().movhstcp6().cTransaccao());
            bghl126a().detalhe().aAplicacao().set(hv12601Movhstcp6().movhstcp6().aAplicacao());
            bghl126a().detalhe().cOpczMenu().set(hv12601Movhstcp6().movhstcp6().cOpczMenu());
            bghl126a().detalhe().cOpeBbn().set(hv12601Movhstcp6().movhstcp6().cOpeBbn());
            bghl126a().detalhe().cEvenOpel().set(hv12601Movhstcp6().movhstcp6().cEvenOpel());
            bghl126a().detalhe().cOperador().set(hv12601Movhstcp6().movhstcp6().cOperador());
            bghl126a().detalhe().cOpexAtrx().set(hv12601Movhstcp6().movhstcp6().cOpexAtrx());
            bghl126a().detalhe().cUserid().set(hv12601Movhstcp6().movhstcp6().cUserid());
            bghl126a().detalhe().tCambio().set(hv12601Movhstcp6().movhstcp6().tCambio());
            bghl126a().detalhe().nmArqvOrig().set(hv12601Movhstcp6().movhstcp6().nmArqvOrig());
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
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs126a439() ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl126a().detalhe().mSldoRetd().set(hv12601Movhstcp6().movhstcp6().mSldoRetd());
            bghl126a().detalhe().mSldoVcob().set(hv12601Movhstcp6().movhstcp6().mSldoVcob());
            bghl126a().detalhe().mCmrgLim().set(hv12601Movhstcp6().movhstcp6().mCmrgLim());
            bghl126a().detalhe().mCmrgUtid().set(hv12601Movhstcp6().movhstcp6().mCmrgUtid());
            bghl126a().detalhe().mDcboNgcdAtrd().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdAtrd());
            bghl126a().detalhe().mDcboNgcdUtid().set(hv12601Movhstcp6().movhstcp6().mDcboNgcdUtid());
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
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs126a493() ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl126a().detalhe().cProdSgop().set(hv12601Movhstcp6().movhstcp6().cProdSgop());
            bghl126a().detalhe().cFamiProd().set(hv12601Movhstcp6().movhstcp6().cFamiProd());
            bghl126a().detalhe().cProduto().set(hv12601Movhstcp6().movhstcp6().cProduto());
            bghl126a().detalhe().cCndzMovzCont().set(hv12601Movhstcp6().movhstcp6().cCndzMovzCont());
            bghl126a().detalhe().cGrupCont().set(hv12601Movhstcp6().movhstcp6().cGrupCont());
            bghl126a().detalhe().cTipoIttz().set(hv12601Movhstcp6().movhstcp6().cTipoIttz());
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
         * call to extracted method to access (SELECT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().selectMghs126a545() ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl126a().detalhe().cPaisIsoaOeOpx().set(hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx());
            bghl126a().detalhe().cMnemEgcOpex().set(hv12601Movhstcp6().movhstcp6().cMnemEgcOpex());
            bghl126a().detalhe().cOeEgcOpex().set(hv12601Movhstcp6().movhstcp6().cOeEgcOpex());
            bghl126a().detalhe().cUserid().set(hv12601Movhstcp6().movhstcp6().cUserid());
            bghl126a().detalhe().nJourBbn().set(hv12601Movhstcp6().movhstcp6().nJourBbn());
            bghl126a().detalhe().nsJourBbn().set(hv12601Movhstcp6().movhstcp6().nsJourBbn());
            bghl126a().detalhe().nsJourBbnDtlh().set(hv12601Movhstcp6().movhstcp6().nsJourBbnDtlh());
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
        bghl126a().cRetorno().set(progStatus);
        bghl126a().cSqlcode().set(getPersistenceCode());
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
