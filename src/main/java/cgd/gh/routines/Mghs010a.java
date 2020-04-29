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
import cgd.gh.structures.link.Bghl010a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00010_CONTIPHST
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS010A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs010a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl010a
     */
    @Data
    public abstract Bghl010a bghl010a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01001Contiphst
     */
    @Data
    protected abstract Vwsdghps01001Contiphst hv01001Contiphst() ;
    
    
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
    @Condition("098")
    protected ICondition progNaoExisteConta ;
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
    
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl010a().cRetorno().initialize() ;
        bghl010a().cSqlcode().initialize() ;
        if (bghl010a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl010a().argumento().cBancCont().isEqual(0) || 
            bghl010a().argumento().cOeEgcCont().isEqual(0) || 
            bghl010a().argumento().nsRdclCont().isEqual(0) || 
            bghl010a().argumento().cMoedIsoScta().isEmpty() || 
            bghl010a().argumento().nmRecurso().isEmpty()) {
            progDadosInvalidos.setTrue() ;
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
        if (progOk.isTrue()) {
            a5200AcederTab() ;
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
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(bghl010a().argumento().cPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(bghl010a().argumento().cBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(bghl010a().argumento().cOeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(bghl010a().argumento().nsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(bghl010a().argumento().vChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(bghl010a().argumento().cTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(bghl010a().argumento().cMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(bghl010a().argumento().nsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set(bghl010a().argumento().nmRecurso());
    }
    
    /**
     * 
     * 
     */
    public void a5200AcederTab() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().selectMghs010a152() ;
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteConta.setTrue() ;
        }
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl010a().detalhe().cTipoInfHist().set(hv01001Contiphst().contiphst().cTipoInfHist());
            bghl010a().detalhe().zaInicio().set(hv01001Contiphst().contiphst().zaInicio());
            bghl010a().detalhe().zaFim().set(hv01001Contiphst().contiphst().zaFim());
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
        bghl010a().cRetorno().set(progStatus);
        bghl010a().cSqlcode().set(getPersistenceCode());
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
