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
import cgd.gh.structures.link.Bghl003a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00003_GATCNSMOV
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ESTADO H:
 * SIGNIFICA QUE OS MOVIMENTOS DO DIA D-1
 * ESTAO NOS HO'S
 * ESTADO A:
 * ESTAO NA TABELA TGH0022
 * ESTADO I:
 * ESTAO JA EM HISTORICO
 * 
 * migrated from program [MGHS003A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs003a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl003a
     */
    @Data
    public abstract Bghl003a bghl003a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00301Gatcnsmov
     */
    @Data
    protected abstract Vwsdghps00301Gatcnsmov hv00301Gatcnsmov() ;
    
    
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
    protected ICondition progNaoExiste ;
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
    
    
    @Data(size=8)
    protected IString wsNmRecurso ;
    
    @Data(size=26)
    protected IString wsTimestamp ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl003a().cRetorno().initialize() ;
        bghl003a().cSqlcode().initialize() ;
        wsNmRecurso.set(bghl003a().argumento().nmRecurso());
        wsTimestamp.set( getDBTimestamp() ) ;
    }
    
    /**
     * 
     * 
     */
    public void s3000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        hv00301Gatcnsmov().gatcnsmov().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00301_GATCNSMOV
         */
        hv00301Gatcnsmov().selectMghs003a126(wsNmRecurso) ;
        if (hv00301Gatcnsmov().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00301Gatcnsmov().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00301Gatcnsmov().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl003a().detalhe().iEstRcrs().set(hv00301Gatcnsmov().gatcnsmov().iEstRcrs());
            bghl003a().argumento().nmRecurso().set(wsNmRecurso);
            bghl003a().zHoje().set(wsTimestamp.get(1, 10));
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
        bghl003a().cRetorno().set(progStatus);
        bghl003a().cSqlcode().set(getPersistenceCode());
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
