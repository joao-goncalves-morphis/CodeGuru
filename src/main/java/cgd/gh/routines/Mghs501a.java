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
import cgd.gh.structures.link.Bghl501a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00501_INFHSTCPL
 * DESCRICAO     : OBTEM DADOS DAS TABELAS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS501A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs501a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl501a
     */
    @Data
    public abstract Bghl501a bghl501a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps50101Infhstcpl
     */
    @Data
    protected abstract Vwsdghps50101Infhstcpl hv50101Infhstcpl() ;
    
    
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
        if (bghl501a().criterioConsulta().iCriterioCns().isEmpty()) {
            criterioOnde.setTrue() ;
        }
        bghl501a().cRetorno().initialize() ;
        bghl501a().cSqlcode().initialize() ;
        bghl501a().detalhe().initialize() ;
        if (bghl501a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl501a().argumento().cBancCont().isEqual(0) || 
            bghl501a().argumento().cOeEgcCont().isEqual(0) || 
            bghl501a().argumento().nsRdclCont().isEqual(0) || 
            bghl501a().argumento().cMoedIsoScta().isEmpty() || 
            bghl501a().argumento().tsMovimento().isEmpty() || 
            bghl501a().argumento().nsMovimento().isEqual(0) || 
            bghl501a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl501a().criterioConsulta().iCriterioCns());
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
        hv50101Infhstcpl().infhstcpl().initialize() ;
        hv50101Infhstcpl().infhstcpl().cPaisIsoaCont().set(bghl501a().argumento().cPaisIsoaCont());
        hv50101Infhstcpl().infhstcpl().cBancCont().set(bghl501a().argumento().cBancCont());
        hv50101Infhstcpl().infhstcpl().cOeEgcCont().set(bghl501a().argumento().cOeEgcCont());
        hv50101Infhstcpl().infhstcpl().nsRdclCont().set(bghl501a().argumento().nsRdclCont());
        hv50101Infhstcpl().infhstcpl().vChkdCont().set(bghl501a().argumento().vChkdCont());
        hv50101Infhstcpl().infhstcpl().cTipoCont().set(bghl501a().argumento().cTipoCont());
        hv50101Infhstcpl().infhstcpl().cMoedIsoScta().set(bghl501a().argumento().cMoedIsoScta());
        hv50101Infhstcpl().infhstcpl().nsDeposito().set(bghl501a().argumento().nsDeposito());
        hv50101Infhstcpl().infhstcpl().tsMovimento().set(bghl501a().argumento().tsMovimento());
        hv50101Infhstcpl().infhstcpl().nsMovimento().set(bghl501a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200CriterioCompleto() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH50101_INFHSTCPL
         */
        hv50101Infhstcpl().selectMghs501a189() ;
        if (hv50101Infhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl501a().detalhe().cTransaccao().set(hv50101Infhstcpl().infhstcpl().cTransaccao());
            bghl501a().detalhe().aAplicacao().set(hv50101Infhstcpl().infhstcpl().aAplicacao());
            bghl501a().detalhe().cOpczMenu().set(hv50101Infhstcpl().infhstcpl().cOpczMenu());
            bghl501a().detalhe().cOpeBbn().set(hv50101Infhstcpl().infhstcpl().cOpeBbn());
            bghl501a().detalhe().cEvenOpel().set(hv50101Infhstcpl().infhstcpl().cEvenOpel());
            bghl501a().detalhe().cTerminal().set(hv50101Infhstcpl().infhstcpl().cTerminal());
            bghl501a().detalhe().cOperador().set(hv50101Infhstcpl().infhstcpl().cOperador());
            bghl501a().detalhe().cOpexAtrx().set(hv50101Infhstcpl().infhstcpl().cOpexAtrx());
            bghl501a().detalhe().cUserid().set(hv50101Infhstcpl().infhstcpl().cUserid());
            bghl501a().detalhe().cTipoCanlAces().set(hv50101Infhstcpl().infhstcpl().cTipoCanlAces());
            bghl501a().detalhe().cPaisIsoaOeOpx().set(hv50101Infhstcpl().infhstcpl().cPaisIsoaOeOpx());
            bghl501a().detalhe().cMnemEgcOpex().set(hv50101Infhstcpl().infhstcpl().cMnemEgcOpex());
            bghl501a().detalhe().cOeEgcOpex().set(hv50101Infhstcpl().infhstcpl().cOeEgcOpex());
            bghl501a().detalhe().cProdSgop().set(hv50101Infhstcpl().infhstcpl().cProdSgop());
            bghl501a().detalhe().cFamiProd().set(hv50101Infhstcpl().infhstcpl().cFamiProd());
            bghl501a().detalhe().cProduto().set(hv50101Infhstcpl().infhstcpl().cProduto());
            bghl501a().detalhe().cCndzMovzCont().set(hv50101Infhstcpl().infhstcpl().cCndzMovzCont());
            bghl501a().detalhe().cGrupCont().set(hv50101Infhstcpl().infhstcpl().cGrupCont());
            bghl501a().detalhe().tCambio().set(hv50101Infhstcpl().infhstcpl().tCambio());
            bghl501a().detalhe().mSldoRetd().set(hv50101Infhstcpl().infhstcpl().mSldoRetd());
            bghl501a().detalhe().mSldoVcob().set(hv50101Infhstcpl().infhstcpl().mSldoVcob());
            bghl501a().detalhe().mCmrgLim().set(hv50101Infhstcpl().infhstcpl().mCmrgLim());
            bghl501a().detalhe().mCmrgUtid().set(hv50101Infhstcpl().infhstcpl().mCmrgUtid());
            bghl501a().detalhe().mDcboNgcdAtrd().set(hv50101Infhstcpl().infhstcpl().mDcboNgcdAtrd());
            bghl501a().detalhe().mDcboNgcdUtid().set(hv50101Infhstcpl().infhstcpl().mDcboNgcdUtid());
            bghl501a().detalhe().nJourBbn().set(hv50101Infhstcpl().infhstcpl().nJourBbn());
            bghl501a().detalhe().nsJourBbn().set(hv50101Infhstcpl().infhstcpl().nsJourBbn());
            bghl501a().detalhe().nsJourBbnDtlh().set(hv50101Infhstcpl().infhstcpl().nsJourBbnDtlh());
            bghl501a().detalhe().tsActzUlt().set(hv50101Infhstcpl().infhstcpl().tsActzUlt());
            bghl501a().detalhe().cUsidActzUlt().set(hv50101Infhstcpl().infhstcpl().cUsidActzUlt());
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
         * call to extracted method to access (SELECT) table VGH50101_INFHSTCPL
         */
        hv50101Infhstcpl().selectMghs501a321() ;
        if (hv50101Infhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl501a().detalhe().cTipoCanlAces().set(hv50101Infhstcpl().infhstcpl().cTipoCanlAces());
            bghl501a().detalhe().cTerminal().set(hv50101Infhstcpl().infhstcpl().cTerminal());
            bghl501a().detalhe().cPaisIsoaOeOpx().set(hv50101Infhstcpl().infhstcpl().cPaisIsoaOeOpx());
            bghl501a().detalhe().cMnemEgcOpex().set(hv50101Infhstcpl().infhstcpl().cMnemEgcOpex());
            bghl501a().detalhe().cOeEgcOpex().set(hv50101Infhstcpl().infhstcpl().cOeEgcOpex());
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
         * call to extracted method to access (SELECT) table VGH50101_INFHSTCPL
         */
        hv50101Infhstcpl().selectMghs501a372() ;
        if (hv50101Infhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl501a().detalhe().cTransaccao().set(hv50101Infhstcpl().infhstcpl().cTransaccao());
            bghl501a().detalhe().aAplicacao().set(hv50101Infhstcpl().infhstcpl().aAplicacao());
            bghl501a().detalhe().cOpczMenu().set(hv50101Infhstcpl().infhstcpl().cOpczMenu());
            bghl501a().detalhe().cOpeBbn().set(hv50101Infhstcpl().infhstcpl().cOpeBbn());
            bghl501a().detalhe().cEvenOpel().set(hv50101Infhstcpl().infhstcpl().cEvenOpel());
            bghl501a().detalhe().cOperador().set(hv50101Infhstcpl().infhstcpl().cOperador());
            bghl501a().detalhe().cOpexAtrx().set(hv50101Infhstcpl().infhstcpl().cOpexAtrx());
            bghl501a().detalhe().cUserid().set(hv50101Infhstcpl().infhstcpl().cUserid());
            bghl501a().detalhe().tCambio().set(hv50101Infhstcpl().infhstcpl().tCambio());
            bghl501a().detalhe().tsActzUlt().set(hv50101Infhstcpl().infhstcpl().tsActzUlt());
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
         * call to extracted method to access (SELECT) table VGH50101_INFHSTCPL
         */
        hv50101Infhstcpl().selectMghs501a436() ;
        if (hv50101Infhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl501a().detalhe().mSldoRetd().set(hv50101Infhstcpl().infhstcpl().mSldoRetd());
            bghl501a().detalhe().mSldoVcob().set(hv50101Infhstcpl().infhstcpl().mSldoVcob());
            bghl501a().detalhe().mCmrgLim().set(hv50101Infhstcpl().infhstcpl().mCmrgLim());
            bghl501a().detalhe().mCmrgUtid().set(hv50101Infhstcpl().infhstcpl().mCmrgUtid());
            bghl501a().detalhe().mDcboNgcdAtrd().set(hv50101Infhstcpl().infhstcpl().mDcboNgcdAtrd());
            bghl501a().detalhe().mDcboNgcdUtid().set(hv50101Infhstcpl().infhstcpl().mDcboNgcdUtid());
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
         * call to extracted method to access (SELECT) table VGH50101_INFHSTCPL
         */
        hv50101Infhstcpl().selectMghs501a490() ;
        if (hv50101Infhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl501a().detalhe().cProdSgop().set(hv50101Infhstcpl().infhstcpl().cProdSgop());
            bghl501a().detalhe().cFamiProd().set(hv50101Infhstcpl().infhstcpl().cFamiProd());
            bghl501a().detalhe().cProduto().set(hv50101Infhstcpl().infhstcpl().cProduto());
            bghl501a().detalhe().cCndzMovzCont().set(hv50101Infhstcpl().infhstcpl().cCndzMovzCont());
            bghl501a().detalhe().cGrupCont().set(hv50101Infhstcpl().infhstcpl().cGrupCont());
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
         * call to extracted method to access (SELECT) table VGH50101_INFHSTCPL
         */
        hv50101Infhstcpl().selectMghs501a540() ;
        if (hv50101Infhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv50101Infhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl501a().detalhe().cPaisIsoaOeOpx().set(hv50101Infhstcpl().infhstcpl().cPaisIsoaOeOpx());
            bghl501a().detalhe().cMnemEgcOpex().set(hv50101Infhstcpl().infhstcpl().cMnemEgcOpex());
            bghl501a().detalhe().cOeEgcOpex().set(hv50101Infhstcpl().infhstcpl().cOeEgcOpex());
            bghl501a().detalhe().cUserid().set(hv50101Infhstcpl().infhstcpl().cUserid());
            bghl501a().detalhe().nJourBbn().set(hv50101Infhstcpl().infhstcpl().nJourBbn());
            bghl501a().detalhe().nsJourBbn().set(hv50101Infhstcpl().infhstcpl().nsJourBbn());
            bghl501a().detalhe().nsJourBbnDtlh().set(hv50101Infhstcpl().infhstcpl().nsJourBbnDtlh());
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
        bghl501a().cRetorno().set(progStatus);
        bghl501a().cSqlcode().set(getPersistenceCode());
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
