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
import cgd.gh.structures.link.Bghl007a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : VGH00701_INFPESMOV
 * DESCRICAO     : ROTINA DE ACESSO A TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS007A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs007a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl007a
     */
    @Data
    public abstract Bghl007a bghl007a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00701Infpesmov
     */
    @Data
    protected abstract Vwsdghps00701Infpesmov hv00701Infpesmov() ;
    
    
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
    @Condition("070")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("071")
    protected ICondition progJaExiste ;
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
        bghl007a().cRetorno().initialize() ;
        bghl007a().cSqlcode().initialize() ;
        if (bghl007a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl007a().argumento().cBancCont().isEqual(0) || 
            bghl007a().argumento().cOeEgcCont().isEqual(0) || 
            bghl007a().argumento().nsRdclCont().isEqual(0) || 
            bghl007a().argumento().cMoedIsoScta().isEmpty() || 
            bghl007a().argumento().tsMovimento().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (!bghl007a().argumentoAcesso().acessoValido().isTrue()) {
                progDadosInvalidos.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            if (bghl007a().argumentoAcesso().criar().isTrue() || bghl007a().argumentoAcesso().modificar().isTrue()) {
                if (bghl007a().detalhe().xInfPeslMov().isEmpty()) {
                    progDadosInvalidos.setTrue() ;
                }
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
        if (bghl007a().argumentoAcesso().consultar().isTrue()) {
            a3100Consulta() ;
        } else if (bghl007a().argumentoAcesso().criar().isTrue()) {
            a3200Insere() ;
        } else if (bghl007a().argumentoAcesso().modificar().isTrue()) {
            a3300Altera() ;
        } else if (bghl007a().argumentoAcesso().eliminar().isTrue()) {
            a3400Elimina() ;
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
        hv00701Infpesmov().infpesmov().initialize() ;
        hv00701Infpesmov().infpesmov().cPaisIsoaCont().set(bghl007a().argumento().cPaisIsoaCont());
        hv00701Infpesmov().infpesmov().cBancCont().set(bghl007a().argumento().cBancCont());
        hv00701Infpesmov().infpesmov().cOeEgcCont().set(bghl007a().argumento().cOeEgcCont());
        hv00701Infpesmov().infpesmov().nsRdclCont().set(bghl007a().argumento().nsRdclCont());
        hv00701Infpesmov().infpesmov().vChkdCont().set(bghl007a().argumento().vChkdCont());
        hv00701Infpesmov().infpesmov().cTipoCont().set(bghl007a().argumento().cTipoCont());
        hv00701Infpesmov().infpesmov().cMoedIsoScta().set(bghl007a().argumento().cMoedIsoScta());
        hv00701Infpesmov().infpesmov().nsDeposito().set(bghl007a().argumento().nsDeposito());
        hv00701Infpesmov().infpesmov().tsMovimento().set(bghl007a().argumento().tsMovimento());
        hv00701Infpesmov().infpesmov().nsMovimento().set(bghl007a().argumento().nsMovimento());
        if (bghl007a().argumentoAcesso().criar().isTrue() || bghl007a().argumentoAcesso().modificar().isTrue()) {
            hv00701Infpesmov().infpesmov().xInfPeslMov().set(bghl007a().detalhe().xInfPeslMov());
            hv00701Infpesmov().infpesmov().tsActzUlt().set(bghl007a().detalhe().tsActzUlt());
            hv00701Infpesmov().infpesmov().cUsidActzUlt().set(bghl007a().detalhe().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a3100Consulta() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00701_INFPESMOV
         */
        hv00701Infpesmov().selectMghs007a179() ;
        if (hv00701Infpesmov().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00701Infpesmov().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00701Infpesmov().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl007a().detalhe().xInfPeslMov().set(hv00701Infpesmov().infpesmov().xInfPeslMov());
            bghl007a().detalhe().tsActzUlt().set(hv00701Infpesmov().infpesmov().tsActzUlt());
            bghl007a().detalhe().cUsidActzUlt().set(hv00701Infpesmov().infpesmov().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a3200Insere() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00701_INFPESMOV
         */
        hv00701Infpesmov().insertMghs007a222() ;
        if (hv00701Infpesmov().getPersistenceCode() == PersistenceCode.DUPLICATED) {
            progNaoExiste.setTrue() ;
        }
        if (hv00701Infpesmov().getPersistenceCode() != PersistenceCode.DUPLICATED && 
            hv00701Infpesmov().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a3300Altera() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00701_INFPESMOV
         */
        hv00701Infpesmov().updateMghs007a271() ;
        if (hv00701Infpesmov().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00701Infpesmov().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00701Infpesmov().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a3400Elimina() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH00701_INFPESMOV
         */
        hv00701Infpesmov().deleteMghs007a303() ;
        if (hv00701Infpesmov().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00701Infpesmov().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00701Infpesmov().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl007a().cRetorno().set(progStatus);
        bghl007a().cSqlcode().set(getPersistenceCode());
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
