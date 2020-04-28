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
import cgd.gh.structures.link.Bghl128a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00128_MOVHSTCP8
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS128A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs128a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl128a
     */
    @Data
    public abstract Bghl128a bghl128a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps12801Movhstcp8
     */
    @Data
    protected abstract Vwsdghps12801Movhstcp8 hv12801Movhstcp8() ;
    
    
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
        bghl128a().cRetorno().initialize() ;
        bghl128a().cSqlcode().initialize() ;
        if (bghl128a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl128a().argumento().cBancCont().isEqual(0) || 
            bghl128a().argumento().cOeEgcCont().isEqual(0) || 
            bghl128a().argumento().nsRdclCont().isEqual(0) || 
            bghl128a().argumento().cMoedIsoScta().isEmpty() || 
            bghl128a().argumento().tsMovimento().isEmpty() || 
            bghl128a().argumento().nsMovimento().isEqual(0) || 
            bghl128a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl128a().criterioConsulta().iCriterioCns());
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
        hv12801Movhstcp8().movhstcp8().initialize() ;
        hv12801Movhstcp8().movhstcp8().cPaisIsoaCont().set(bghl128a().argumento().cPaisIsoaCont());
        hv12801Movhstcp8().movhstcp8().cBancCont().set(bghl128a().argumento().cBancCont());
        hv12801Movhstcp8().movhstcp8().cOeEgcCont().set(bghl128a().argumento().cOeEgcCont());
        hv12801Movhstcp8().movhstcp8().nsRdclCont().set(bghl128a().argumento().nsRdclCont());
        hv12801Movhstcp8().movhstcp8().vChkdCont().set(bghl128a().argumento().vChkdCont());
        hv12801Movhstcp8().movhstcp8().cTipoCont().set(bghl128a().argumento().cTipoCont());
        hv12801Movhstcp8().movhstcp8().cMoedIsoScta().set(bghl128a().argumento().cMoedIsoScta());
        hv12801Movhstcp8().movhstcp8().nsDeposito().set(bghl128a().argumento().nsDeposito());
        hv12801Movhstcp8().movhstcp8().tsMovimento().set(bghl128a().argumento().tsMovimento());
        hv12801Movhstcp8().movhstcp8().nsMovimento().set(bghl128a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs128a186() ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl128a().detalhe().cTransaccao().set(hv12801Movhstcp8().movhstcp8().cTransaccao());
            bghl128a().detalhe().aAplicacao().set(hv12801Movhstcp8().movhstcp8().aAplicacao());
            bghl128a().detalhe().cOpczMenu().set(hv12801Movhstcp8().movhstcp8().cOpczMenu());
            bghl128a().detalhe().cOpeBbn().set(hv12801Movhstcp8().movhstcp8().cOpeBbn());
            bghl128a().detalhe().cEvenOpel().set(hv12801Movhstcp8().movhstcp8().cEvenOpel());
            bghl128a().detalhe().cTerminal().set(hv12801Movhstcp8().movhstcp8().cTerminal());
            bghl128a().detalhe().cOperador().set(hv12801Movhstcp8().movhstcp8().cOperador());
            bghl128a().detalhe().cOpexAtrx().set(hv12801Movhstcp8().movhstcp8().cOpexAtrx());
            bghl128a().detalhe().cUserid().set(hv12801Movhstcp8().movhstcp8().cUserid());
            bghl128a().detalhe().cTipoCanlAces().set(hv12801Movhstcp8().movhstcp8().cTipoCanlAces());
            bghl128a().detalhe().cPaisIsoaOeOpx().set(hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx());
            bghl128a().detalhe().cMnemEgcOpex().set(hv12801Movhstcp8().movhstcp8().cMnemEgcOpex());
            bghl128a().detalhe().cOeEgcOpex().set(hv12801Movhstcp8().movhstcp8().cOeEgcOpex());
            bghl128a().detalhe().cProdSgop().set(hv12801Movhstcp8().movhstcp8().cProdSgop());
            bghl128a().detalhe().cFamiProd().set(hv12801Movhstcp8().movhstcp8().cFamiProd());
            bghl128a().detalhe().cProduto().set(hv12801Movhstcp8().movhstcp8().cProduto());
            bghl128a().detalhe().cCndzMovzCont().set(hv12801Movhstcp8().movhstcp8().cCndzMovzCont());
            bghl128a().detalhe().cGrupCont().set(hv12801Movhstcp8().movhstcp8().cGrupCont());
            bghl128a().detalhe().cTipoIttz().set(hv12801Movhstcp8().movhstcp8().cTipoIttz());
            bghl128a().detalhe().tCambio().set(hv12801Movhstcp8().movhstcp8().tCambio());
            bghl128a().detalhe().mSldoRetd().set(hv12801Movhstcp8().movhstcp8().mSldoRetd());
            bghl128a().detalhe().mSldoVcob().set(hv12801Movhstcp8().movhstcp8().mSldoVcob());
            bghl128a().detalhe().mCmrgLim().set(hv12801Movhstcp8().movhstcp8().mCmrgLim());
            bghl128a().detalhe().mCmrgUtid().set(hv12801Movhstcp8().movhstcp8().mCmrgUtid());
            bghl128a().detalhe().mDcboNgcdAtrd().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdAtrd());
            bghl128a().detalhe().mDcboNgcdUtid().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdUtid());
            bghl128a().detalhe().nJourBbn().set(hv12801Movhstcp8().movhstcp8().nJourBbn());
            bghl128a().detalhe().nsJourBbn().set(hv12801Movhstcp8().movhstcp8().nsJourBbn());
            bghl128a().detalhe().nsJourBbnDtlh().set(hv12801Movhstcp8().movhstcp8().nsJourBbnDtlh());
            bghl128a().detalhe().nmArqvOrig().set(hv12801Movhstcp8().movhstcp8().nmArqvOrig());
            bghl128a().detalhe().tsActzUlt().set(hv12801Movhstcp8().movhstcp8().tsActzUlt());
            bghl128a().detalhe().cUsidActzUlt().set(hv12801Movhstcp8().movhstcp8().cUsidActzUlt());
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
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs128a324() ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl128a().detalhe().cTipoCanlAces().set(hv12801Movhstcp8().movhstcp8().cTipoCanlAces());
            bghl128a().detalhe().cTerminal().set(hv12801Movhstcp8().movhstcp8().cTerminal());
            bghl128a().detalhe().cPaisIsoaOeOpx().set(hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx());
            bghl128a().detalhe().cMnemEgcOpex().set(hv12801Movhstcp8().movhstcp8().cMnemEgcOpex());
            bghl128a().detalhe().cOeEgcOpex().set(hv12801Movhstcp8().movhstcp8().cOeEgcOpex());
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
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs128a375() ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl128a().detalhe().cTransaccao().set(hv12801Movhstcp8().movhstcp8().cTransaccao());
            bghl128a().detalhe().aAplicacao().set(hv12801Movhstcp8().movhstcp8().aAplicacao());
            bghl128a().detalhe().cOpczMenu().set(hv12801Movhstcp8().movhstcp8().cOpczMenu());
            bghl128a().detalhe().cOpeBbn().set(hv12801Movhstcp8().movhstcp8().cOpeBbn());
            bghl128a().detalhe().cEvenOpel().set(hv12801Movhstcp8().movhstcp8().cEvenOpel());
            bghl128a().detalhe().cOperador().set(hv12801Movhstcp8().movhstcp8().cOperador());
            bghl128a().detalhe().cOpexAtrx().set(hv12801Movhstcp8().movhstcp8().cOpexAtrx());
            bghl128a().detalhe().cUserid().set(hv12801Movhstcp8().movhstcp8().cUserid());
            bghl128a().detalhe().tCambio().set(hv12801Movhstcp8().movhstcp8().tCambio());
            bghl128a().detalhe().nmArqvOrig().set(hv12801Movhstcp8().movhstcp8().nmArqvOrig());
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
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs128a439() ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl128a().detalhe().mSldoRetd().set(hv12801Movhstcp8().movhstcp8().mSldoRetd());
            bghl128a().detalhe().mSldoVcob().set(hv12801Movhstcp8().movhstcp8().mSldoVcob());
            bghl128a().detalhe().mCmrgLim().set(hv12801Movhstcp8().movhstcp8().mCmrgLim());
            bghl128a().detalhe().mCmrgUtid().set(hv12801Movhstcp8().movhstcp8().mCmrgUtid());
            bghl128a().detalhe().mDcboNgcdAtrd().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdAtrd());
            bghl128a().detalhe().mDcboNgcdUtid().set(hv12801Movhstcp8().movhstcp8().mDcboNgcdUtid());
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
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs128a493() ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl128a().detalhe().cProdSgop().set(hv12801Movhstcp8().movhstcp8().cProdSgop());
            bghl128a().detalhe().cFamiProd().set(hv12801Movhstcp8().movhstcp8().cFamiProd());
            bghl128a().detalhe().cProduto().set(hv12801Movhstcp8().movhstcp8().cProduto());
            bghl128a().detalhe().cCndzMovzCont().set(hv12801Movhstcp8().movhstcp8().cCndzMovzCont());
            bghl128a().detalhe().cGrupCont().set(hv12801Movhstcp8().movhstcp8().cGrupCont());
            bghl128a().detalhe().cTipoIttz().set(hv12801Movhstcp8().movhstcp8().cTipoIttz());
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
         * call to extracted method to access (SELECT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().selectMghs128a545() ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl128a().detalhe().cPaisIsoaOeOpx().set(hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx());
            bghl128a().detalhe().cMnemEgcOpex().set(hv12801Movhstcp8().movhstcp8().cMnemEgcOpex());
            bghl128a().detalhe().cOeEgcOpex().set(hv12801Movhstcp8().movhstcp8().cOeEgcOpex());
            bghl128a().detalhe().cUserid().set(hv12801Movhstcp8().movhstcp8().cUserid());
            bghl128a().detalhe().nJourBbn().set(hv12801Movhstcp8().movhstcp8().nJourBbn());
            bghl128a().detalhe().nsJourBbn().set(hv12801Movhstcp8().movhstcp8().nsJourBbn());
            bghl128a().detalhe().nsJourBbnDtlh().set(hv12801Movhstcp8().movhstcp8().nsJourBbnDtlh());
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
        bghl128a().cRetorno().set(progStatus);
        bghl128a().cSqlcode().set(getPersistenceCode());
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
