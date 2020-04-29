package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.annotations.Data ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl902a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00002_MOVHST
 * DESCRICAO     : OBTEM DADOS DAS TABELAS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS902A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs902a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl902a
     */
    @Data
    public abstract Bghl902a bghl902a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
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
    
    
    @Data(size=26, value=" ")
    protected IString wsTsMovimentoMin ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovimentoMax ;
    
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
        bghl902a().cRetorno().initialize() ;
        bghl902a().cSqlcode().initialize() ;
        if (bghl902a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl902a().argumento().cBancCont().isEqual(0) || 
            bghl902a().argumento().cOeEgcCont().isEqual(0) || 
            bghl902a().argumento().nsRdclCont().isEqual(0) || 
            bghl902a().argumento().cMoedIsoScta().isEmpty() || 
            bghl902a().argumento().tsMovimento().isEmpty() || 
            bghl902a().argumento().nsMovimento().isEqual(0) || 
            bghl902a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            wsCrtCriterio.set(bghl902a().criterioConsulta().iCriterioCns());
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
        a5200AcederTabela() ;
    }
    
    /**
     * 
     * 
     */
    public void a5100FormatarArea() {
        /**
         * *----------------------------------------------------------------*
         */
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(bghl902a().argumento().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(bghl902a().argumento().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(bghl902a().argumento().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(bghl902a().argumento().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(bghl902a().argumento().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(bghl902a().argumento().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(bghl902a().argumento().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(bghl902a().argumento().nsDeposito());
        wsTsMovimentoMin.get(1, 10).set(bghl902a().argumento().tsMovimento().get(1, 10)) ;
        wsTsMovimentoMax.get(1, 10).set(bghl902a().argumento().tsMovimento().get(1, 10)) ;
        wsTsMovimentoMin.get(11, 16).set("-00.00.00.000000") ;
        wsTsMovimentoMax.get(11, 16).set("-23.59.59.999999") ;
        hv00201Movhst().movhst().nsMovimento().set(bghl902a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200AcederTabela() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectMghs902a179(wsTsMovimentoMin, wsTsMovimentoMax) ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            /**
             * AND VGH00201-I-EXIS-INF-ADI NOT EQUAL SPACES
             */
            if (hv00201Movhst().movhst().iExisInfAdi().isEqual("S")) {
                bghl902a().detalhe().xChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
            } else {
                bghl902a().detalhe().xChavAcsInfAdi().set(" ");
            }
        } else {
            progDb2.setTrue() ;
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
        bghl902a().cRetorno().set(progStatus);
        bghl902a().cSqlcode().set(getPersistenceCode());
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
