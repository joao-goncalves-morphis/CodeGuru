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
import cgd.gh.structures.link.Bghl124a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00124_MOVHSTCP4
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS124A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs124a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl124a
     */
    @Data
    public abstract Bghl124a bghl124a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps12401Movhstcp4
     */
    @Data
    protected abstract Vwsdghps12401Movhstcp4 hv12401Movhstcp4() ;
    
    
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
        bghl124a().cRetorno().initialize() ;
        bghl124a().cSqlcode().initialize() ;
        if (bghl124a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl124a().argumento().cBancCont().isEqual(0) || 
            bghl124a().argumento().cOeEgcCont().isEqual(0) || 
            bghl124a().argumento().nsRdclCont().isEqual(0) || 
            bghl124a().argumento().cMoedIsoScta().isEmpty() || 
            bghl124a().argumento().tsMovimento().isEmpty() || 
            bghl124a().argumento().nsMovimento().isEqual(0) || 
            bghl124a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl124a().criterioConsulta().iCriterioCns());
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
        hv12401Movhstcp4().movhstcp4().initialize() ;
        hv12401Movhstcp4().movhstcp4().cPaisIsoaCont().set(bghl124a().argumento().cPaisIsoaCont());
        hv12401Movhstcp4().movhstcp4().cBancCont().set(bghl124a().argumento().cBancCont());
        hv12401Movhstcp4().movhstcp4().cOeEgcCont().set(bghl124a().argumento().cOeEgcCont());
        hv12401Movhstcp4().movhstcp4().nsRdclCont().set(bghl124a().argumento().nsRdclCont());
        hv12401Movhstcp4().movhstcp4().vChkdCont().set(bghl124a().argumento().vChkdCont());
        hv12401Movhstcp4().movhstcp4().cTipoCont().set(bghl124a().argumento().cTipoCont());
        hv12401Movhstcp4().movhstcp4().cMoedIsoScta().set(bghl124a().argumento().cMoedIsoScta());
        hv12401Movhstcp4().movhstcp4().nsDeposito().set(bghl124a().argumento().nsDeposito());
        hv12401Movhstcp4().movhstcp4().tsMovimento().set(bghl124a().argumento().tsMovimento());
        hv12401Movhstcp4().movhstcp4().nsMovimento().set(bghl124a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs124a186() ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl124a().detalhe().cTransaccao().set(hv12401Movhstcp4().movhstcp4().cTransaccao());
            bghl124a().detalhe().aAplicacao().set(hv12401Movhstcp4().movhstcp4().aAplicacao());
            bghl124a().detalhe().cOpczMenu().set(hv12401Movhstcp4().movhstcp4().cOpczMenu());
            bghl124a().detalhe().cOpeBbn().set(hv12401Movhstcp4().movhstcp4().cOpeBbn());
            bghl124a().detalhe().cEvenOpel().set(hv12401Movhstcp4().movhstcp4().cEvenOpel());
            bghl124a().detalhe().cTerminal().set(hv12401Movhstcp4().movhstcp4().cTerminal());
            bghl124a().detalhe().cOperador().set(hv12401Movhstcp4().movhstcp4().cOperador());
            bghl124a().detalhe().cOpexAtrx().set(hv12401Movhstcp4().movhstcp4().cOpexAtrx());
            bghl124a().detalhe().cUserid().set(hv12401Movhstcp4().movhstcp4().cUserid());
            bghl124a().detalhe().cTipoCanlAces().set(hv12401Movhstcp4().movhstcp4().cTipoCanlAces());
            bghl124a().detalhe().cPaisIsoaOeOpx().set(hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx());
            bghl124a().detalhe().cMnemEgcOpex().set(hv12401Movhstcp4().movhstcp4().cMnemEgcOpex());
            bghl124a().detalhe().cOeEgcOpex().set(hv12401Movhstcp4().movhstcp4().cOeEgcOpex());
            bghl124a().detalhe().cProdSgop().set(hv12401Movhstcp4().movhstcp4().cProdSgop());
            bghl124a().detalhe().cFamiProd().set(hv12401Movhstcp4().movhstcp4().cFamiProd());
            bghl124a().detalhe().cProduto().set(hv12401Movhstcp4().movhstcp4().cProduto());
            bghl124a().detalhe().cCndzMovzCont().set(hv12401Movhstcp4().movhstcp4().cCndzMovzCont());
            bghl124a().detalhe().cGrupCont().set(hv12401Movhstcp4().movhstcp4().cGrupCont());
            bghl124a().detalhe().cTipoIttz().set(hv12401Movhstcp4().movhstcp4().cTipoIttz());
            bghl124a().detalhe().tCambio().set(hv12401Movhstcp4().movhstcp4().tCambio());
            bghl124a().detalhe().mSldoRetd().set(hv12401Movhstcp4().movhstcp4().mSldoRetd());
            bghl124a().detalhe().mSldoVcob().set(hv12401Movhstcp4().movhstcp4().mSldoVcob());
            bghl124a().detalhe().mCmrgLim().set(hv12401Movhstcp4().movhstcp4().mCmrgLim());
            bghl124a().detalhe().mCmrgUtid().set(hv12401Movhstcp4().movhstcp4().mCmrgUtid());
            bghl124a().detalhe().mDcboNgcdAtrd().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdAtrd());
            bghl124a().detalhe().mDcboNgcdUtid().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdUtid());
            bghl124a().detalhe().nJourBbn().set(hv12401Movhstcp4().movhstcp4().nJourBbn());
            bghl124a().detalhe().nsJourBbn().set(hv12401Movhstcp4().movhstcp4().nsJourBbn());
            bghl124a().detalhe().nsJourBbnDtlh().set(hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh());
            bghl124a().detalhe().nmArqvOrig().set(hv12401Movhstcp4().movhstcp4().nmArqvOrig());
            bghl124a().detalhe().tsActzUlt().set(hv12401Movhstcp4().movhstcp4().tsActzUlt());
            bghl124a().detalhe().cUsidActzUlt().set(hv12401Movhstcp4().movhstcp4().cUsidActzUlt());
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
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs124a324() ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl124a().detalhe().cTipoCanlAces().set(hv12401Movhstcp4().movhstcp4().cTipoCanlAces());
            bghl124a().detalhe().cTerminal().set(hv12401Movhstcp4().movhstcp4().cTerminal());
            bghl124a().detalhe().cPaisIsoaOeOpx().set(hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx());
            bghl124a().detalhe().cMnemEgcOpex().set(hv12401Movhstcp4().movhstcp4().cMnemEgcOpex());
            bghl124a().detalhe().cOeEgcOpex().set(hv12401Movhstcp4().movhstcp4().cOeEgcOpex());
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
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs124a375() ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl124a().detalhe().cTransaccao().set(hv12401Movhstcp4().movhstcp4().cTransaccao());
            bghl124a().detalhe().aAplicacao().set(hv12401Movhstcp4().movhstcp4().aAplicacao());
            bghl124a().detalhe().cOpczMenu().set(hv12401Movhstcp4().movhstcp4().cOpczMenu());
            bghl124a().detalhe().cOpeBbn().set(hv12401Movhstcp4().movhstcp4().cOpeBbn());
            bghl124a().detalhe().cEvenOpel().set(hv12401Movhstcp4().movhstcp4().cEvenOpel());
            bghl124a().detalhe().cOperador().set(hv12401Movhstcp4().movhstcp4().cOperador());
            bghl124a().detalhe().cOpexAtrx().set(hv12401Movhstcp4().movhstcp4().cOpexAtrx());
            bghl124a().detalhe().cUserid().set(hv12401Movhstcp4().movhstcp4().cUserid());
            bghl124a().detalhe().tCambio().set(hv12401Movhstcp4().movhstcp4().tCambio());
            bghl124a().detalhe().nmArqvOrig().set(hv12401Movhstcp4().movhstcp4().nmArqvOrig());
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
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs124a439() ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl124a().detalhe().mSldoRetd().set(hv12401Movhstcp4().movhstcp4().mSldoRetd());
            bghl124a().detalhe().mSldoVcob().set(hv12401Movhstcp4().movhstcp4().mSldoVcob());
            bghl124a().detalhe().mCmrgLim().set(hv12401Movhstcp4().movhstcp4().mCmrgLim());
            bghl124a().detalhe().mCmrgUtid().set(hv12401Movhstcp4().movhstcp4().mCmrgUtid());
            bghl124a().detalhe().mDcboNgcdAtrd().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdAtrd());
            bghl124a().detalhe().mDcboNgcdUtid().set(hv12401Movhstcp4().movhstcp4().mDcboNgcdUtid());
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
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs124a493() ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl124a().detalhe().cProdSgop().set(hv12401Movhstcp4().movhstcp4().cProdSgop());
            bghl124a().detalhe().cFamiProd().set(hv12401Movhstcp4().movhstcp4().cFamiProd());
            bghl124a().detalhe().cProduto().set(hv12401Movhstcp4().movhstcp4().cProduto());
            bghl124a().detalhe().cCndzMovzCont().set(hv12401Movhstcp4().movhstcp4().cCndzMovzCont());
            bghl124a().detalhe().cGrupCont().set(hv12401Movhstcp4().movhstcp4().cGrupCont());
            bghl124a().detalhe().cTipoIttz().set(hv12401Movhstcp4().movhstcp4().cTipoIttz());
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
         * call to extracted method to access (SELECT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().selectMghs124a545() ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl124a().detalhe().cPaisIsoaOeOpx().set(hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx());
            bghl124a().detalhe().cMnemEgcOpex().set(hv12401Movhstcp4().movhstcp4().cMnemEgcOpex());
            bghl124a().detalhe().cOeEgcOpex().set(hv12401Movhstcp4().movhstcp4().cOeEgcOpex());
            bghl124a().detalhe().cUserid().set(hv12401Movhstcp4().movhstcp4().cUserid());
            bghl124a().detalhe().nJourBbn().set(hv12401Movhstcp4().movhstcp4().nJourBbn());
            bghl124a().detalhe().nsJourBbn().set(hv12401Movhstcp4().movhstcp4().nsJourBbn());
            bghl124a().detalhe().nsJourBbnDtlh().set(hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh());
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
        bghl124a().cRetorno().set(progStatus);
        bghl124a().cSqlcode().set(getPersistenceCode());
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
