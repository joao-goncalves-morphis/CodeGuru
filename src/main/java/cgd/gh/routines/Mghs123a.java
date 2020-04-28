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
import cgd.gh.structures.link.Bghl123a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00123_MOVHSTCP3
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS123A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs123a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl123a
     */
    @Data
    public abstract Bghl123a bghl123a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps12301Movhstcp3
     */
    @Data
    protected abstract Vwsdghps12301Movhstcp3 hv12301Movhstcp3() ;
    
    
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
        bghl123a().cRetorno().initialize() ;
        bghl123a().cSqlcode().initialize() ;
        if (bghl123a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl123a().argumento().cBancCont().isEqual(0) || 
            bghl123a().argumento().cOeEgcCont().isEqual(0) || 
            bghl123a().argumento().nsRdclCont().isEqual(0) || 
            bghl123a().argumento().cMoedIsoScta().isEmpty() || 
            bghl123a().argumento().tsMovimento().isEmpty() || 
            bghl123a().argumento().nsMovimento().isEqual(0) || 
            bghl123a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl123a().criterioConsulta().iCriterioCns());
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
        hv12301Movhstcp3().movhstcp3().initialize() ;
        hv12301Movhstcp3().movhstcp3().cPaisIsoaCont().set(bghl123a().argumento().cPaisIsoaCont());
        hv12301Movhstcp3().movhstcp3().cBancCont().set(bghl123a().argumento().cBancCont());
        hv12301Movhstcp3().movhstcp3().cOeEgcCont().set(bghl123a().argumento().cOeEgcCont());
        hv12301Movhstcp3().movhstcp3().nsRdclCont().set(bghl123a().argumento().nsRdclCont());
        hv12301Movhstcp3().movhstcp3().vChkdCont().set(bghl123a().argumento().vChkdCont());
        hv12301Movhstcp3().movhstcp3().cTipoCont().set(bghl123a().argumento().cTipoCont());
        hv12301Movhstcp3().movhstcp3().cMoedIsoScta().set(bghl123a().argumento().cMoedIsoScta());
        hv12301Movhstcp3().movhstcp3().nsDeposito().set(bghl123a().argumento().nsDeposito());
        hv12301Movhstcp3().movhstcp3().tsMovimento().set(bghl123a().argumento().tsMovimento());
        hv12301Movhstcp3().movhstcp3().nsMovimento().set(bghl123a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs123a186() ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl123a().detalhe().cTransaccao().set(hv12301Movhstcp3().movhstcp3().cTransaccao());
            bghl123a().detalhe().aAplicacao().set(hv12301Movhstcp3().movhstcp3().aAplicacao());
            bghl123a().detalhe().cOpczMenu().set(hv12301Movhstcp3().movhstcp3().cOpczMenu());
            bghl123a().detalhe().cOpeBbn().set(hv12301Movhstcp3().movhstcp3().cOpeBbn());
            bghl123a().detalhe().cEvenOpel().set(hv12301Movhstcp3().movhstcp3().cEvenOpel());
            bghl123a().detalhe().cTerminal().set(hv12301Movhstcp3().movhstcp3().cTerminal());
            bghl123a().detalhe().cOperador().set(hv12301Movhstcp3().movhstcp3().cOperador());
            bghl123a().detalhe().cOpexAtrx().set(hv12301Movhstcp3().movhstcp3().cOpexAtrx());
            bghl123a().detalhe().cUserid().set(hv12301Movhstcp3().movhstcp3().cUserid());
            bghl123a().detalhe().cTipoCanlAces().set(hv12301Movhstcp3().movhstcp3().cTipoCanlAces());
            bghl123a().detalhe().cPaisIsoaOeOpx().set(hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx());
            bghl123a().detalhe().cMnemEgcOpex().set(hv12301Movhstcp3().movhstcp3().cMnemEgcOpex());
            bghl123a().detalhe().cOeEgcOpex().set(hv12301Movhstcp3().movhstcp3().cOeEgcOpex());
            bghl123a().detalhe().cProdSgop().set(hv12301Movhstcp3().movhstcp3().cProdSgop());
            bghl123a().detalhe().cFamiProd().set(hv12301Movhstcp3().movhstcp3().cFamiProd());
            bghl123a().detalhe().cProduto().set(hv12301Movhstcp3().movhstcp3().cProduto());
            bghl123a().detalhe().cCndzMovzCont().set(hv12301Movhstcp3().movhstcp3().cCndzMovzCont());
            bghl123a().detalhe().cGrupCont().set(hv12301Movhstcp3().movhstcp3().cGrupCont());
            bghl123a().detalhe().cTipoIttz().set(hv12301Movhstcp3().movhstcp3().cTipoIttz());
            bghl123a().detalhe().tCambio().set(hv12301Movhstcp3().movhstcp3().tCambio());
            bghl123a().detalhe().mSldoRetd().set(hv12301Movhstcp3().movhstcp3().mSldoRetd());
            bghl123a().detalhe().mSldoVcob().set(hv12301Movhstcp3().movhstcp3().mSldoVcob());
            bghl123a().detalhe().mCmrgLim().set(hv12301Movhstcp3().movhstcp3().mCmrgLim());
            bghl123a().detalhe().mCmrgUtid().set(hv12301Movhstcp3().movhstcp3().mCmrgUtid());
            bghl123a().detalhe().mDcboNgcdAtrd().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdAtrd());
            bghl123a().detalhe().mDcboNgcdUtid().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdUtid());
            bghl123a().detalhe().nJourBbn().set(hv12301Movhstcp3().movhstcp3().nJourBbn());
            bghl123a().detalhe().nsJourBbn().set(hv12301Movhstcp3().movhstcp3().nsJourBbn());
            bghl123a().detalhe().nsJourBbnDtlh().set(hv12301Movhstcp3().movhstcp3().nsJourBbnDtlh());
            bghl123a().detalhe().nmArqvOrig().set(hv12301Movhstcp3().movhstcp3().nmArqvOrig());
            bghl123a().detalhe().tsActzUlt().set(hv12301Movhstcp3().movhstcp3().tsActzUlt());
            bghl123a().detalhe().cUsidActzUlt().set(hv12301Movhstcp3().movhstcp3().cUsidActzUlt());
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
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs123a324() ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl123a().detalhe().cTipoCanlAces().set(hv12301Movhstcp3().movhstcp3().cTipoCanlAces());
            bghl123a().detalhe().cTerminal().set(hv12301Movhstcp3().movhstcp3().cTerminal());
            bghl123a().detalhe().cPaisIsoaOeOpx().set(hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx());
            bghl123a().detalhe().cMnemEgcOpex().set(hv12301Movhstcp3().movhstcp3().cMnemEgcOpex());
            bghl123a().detalhe().cOeEgcOpex().set(hv12301Movhstcp3().movhstcp3().cOeEgcOpex());
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
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs123a375() ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl123a().detalhe().cTransaccao().set(hv12301Movhstcp3().movhstcp3().cTransaccao());
            bghl123a().detalhe().aAplicacao().set(hv12301Movhstcp3().movhstcp3().aAplicacao());
            bghl123a().detalhe().cOpczMenu().set(hv12301Movhstcp3().movhstcp3().cOpczMenu());
            bghl123a().detalhe().cOpeBbn().set(hv12301Movhstcp3().movhstcp3().cOpeBbn());
            bghl123a().detalhe().cEvenOpel().set(hv12301Movhstcp3().movhstcp3().cEvenOpel());
            bghl123a().detalhe().cOperador().set(hv12301Movhstcp3().movhstcp3().cOperador());
            bghl123a().detalhe().cOpexAtrx().set(hv12301Movhstcp3().movhstcp3().cOpexAtrx());
            bghl123a().detalhe().cUserid().set(hv12301Movhstcp3().movhstcp3().cUserid());
            bghl123a().detalhe().tCambio().set(hv12301Movhstcp3().movhstcp3().tCambio());
            bghl123a().detalhe().nmArqvOrig().set(hv12301Movhstcp3().movhstcp3().nmArqvOrig());
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
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs123a439() ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl123a().detalhe().mSldoRetd().set(hv12301Movhstcp3().movhstcp3().mSldoRetd());
            bghl123a().detalhe().mSldoVcob().set(hv12301Movhstcp3().movhstcp3().mSldoVcob());
            bghl123a().detalhe().mCmrgLim().set(hv12301Movhstcp3().movhstcp3().mCmrgLim());
            bghl123a().detalhe().mCmrgUtid().set(hv12301Movhstcp3().movhstcp3().mCmrgUtid());
            bghl123a().detalhe().mDcboNgcdAtrd().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdAtrd());
            bghl123a().detalhe().mDcboNgcdUtid().set(hv12301Movhstcp3().movhstcp3().mDcboNgcdUtid());
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
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs123a493() ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl123a().detalhe().cProdSgop().set(hv12301Movhstcp3().movhstcp3().cProdSgop());
            bghl123a().detalhe().cFamiProd().set(hv12301Movhstcp3().movhstcp3().cFamiProd());
            bghl123a().detalhe().cProduto().set(hv12301Movhstcp3().movhstcp3().cProduto());
            bghl123a().detalhe().cCndzMovzCont().set(hv12301Movhstcp3().movhstcp3().cCndzMovzCont());
            bghl123a().detalhe().cGrupCont().set(hv12301Movhstcp3().movhstcp3().cGrupCont());
            bghl123a().detalhe().cTipoIttz().set(hv12301Movhstcp3().movhstcp3().cTipoIttz());
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
         * call to extracted method to access (SELECT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().selectMghs123a545() ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl123a().detalhe().cPaisIsoaOeOpx().set(hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx());
            bghl123a().detalhe().cMnemEgcOpex().set(hv12301Movhstcp3().movhstcp3().cMnemEgcOpex());
            bghl123a().detalhe().cOeEgcOpex().set(hv12301Movhstcp3().movhstcp3().cOeEgcOpex());
            bghl123a().detalhe().cUserid().set(hv12301Movhstcp3().movhstcp3().cUserid());
            bghl123a().detalhe().nJourBbn().set(hv12301Movhstcp3().movhstcp3().nJourBbn());
            bghl123a().detalhe().nsJourBbn().set(hv12301Movhstcp3().movhstcp3().nsJourBbn());
            bghl123a().detalhe().nsJourBbnDtlh().set(hv12301Movhstcp3().movhstcp3().nsJourBbnDtlh());
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
        bghl123a().cRetorno().set(progStatus);
        bghl123a().cSqlcode().set(getPersistenceCode());
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
