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
import cgd.gh.structures.link.Bghl201a ;


/**
 * 
 * CURSOR C1
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS DE ASSIVAS
 * DESCRICAO     :
 * O MODULO ACTUALIZA A INFORMACAO RECEBIDA DA APLICACAO
 * HO, NA TABELA VGH00101_CONTHST
 * 
 * migrated from program [MGHS201A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs201a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl201a
     */
    @Data
    public abstract Bghl201a bghl201a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00101Conthst
     */
    @Data
    protected abstract Vwsdghps00101Conthst hv00101Conthst() ;
    
    
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
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("090")
    protected ICondition progJaExiste ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    
    
    
    
    /**
     * 
     * 
     */
    public void s10000Validar() {
        progOk.setTrue() ;
        bghl201a().dadosOutput().grErroBbn().cTipoErroBbn().initialize() ;
        bghl201a().dadosOutput().grErroBbn().cRtnoSwal().initialize() ;
        bghl201a().dadosOutput().grErroBbn().nmTabela().initialize() ;
        bghl201a().dadosOutput().grErroBbn().cSqlcode().initialize() ;
        bghl201a().dadosOutput().grErroBbn().aAplErro().initialize() ;
        if (!bghl201a().dadosInput().cAccaoValido().isTrue()) {
            progDadosInvalidos.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void s30000Processar() {
        a31000AbrirCursorC1() ;
        if (progOk.isTrue()) {
            a32000FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            a33000ActTabela() ;
        } else if (progNaoExiste.isTrue()) {
            a34000InsTabela() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a31000AbrirCursorC1() {
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cPaisIsoaCont().set(bghl201a().dadosInput().argumentoConta().cPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(bghl201a().dadosInput().argumentoConta().cBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(bghl201a().dadosInput().argumentoConta().cOeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(bghl201a().dadosInput().argumentoConta().nsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(bghl201a().dadosInput().argumentoConta().vChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(bghl201a().dadosInput().argumentoConta().cTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(bghl201a().dadosInput().argumentoConta().cMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(bghl201a().dadosInput().argumentoConta().nsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00101Conthst().openMghs201a171() ;
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv00101Conthst().closeMghs201a180() ;
        }
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a32000FetchCursorC1() {
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv00101Conthst().fetchMghs201a191() ;
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv00101Conthst().closeMghs201a209() ;
        }
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a33000ActTabela() {
        hv00101Conthst().conthst().cUsidActzUlt().set("MGHS201A");
        if (bghl201a().dadosInput().abraScta().isTrue()) {
            hv00101Conthst().conthst().zAbraCont().set(bghl201a().dadosInput().argumentoData().zAbraScta());
            hv00101Conthst().conthst().zMovHistUlt().set(bghl201a().dadosInput().argumentoData().zAbraScta());
        }
        if (bghl201a().dadosInput().ccltScta().isTrue()) {
            hv00101Conthst().conthst().iActivo().set("N");
            hv00101Conthst().conthst().zCcltCont().set(bghl201a().dadosInput().argumentoData().zCcltScta());
            hv00101Conthst().conthst().zMovHistUlt().set(bghl201a().dadosInput().argumentoData().zCcltScta());
        }
        if (bghl201a().dadosInput().rabtScta().isTrue()) {
            if (bghl201a().dadosInput().argumentoData().zCcltScta().isEqual("0001-01-01")) {
                hv00101Conthst().conthst().zRabtCont().set(bghl201a().dadosInput().argumentoData().zRabtScta());
            } else {
                hv00101Conthst().conthst().zRabtContCcld().set(bghl201a().dadosInput().argumentoData().zRabtScta());
            }
            if (hv00101Conthst().conthst().iActivo().isEqual("N")) {
                hv00101Conthst().conthst().iActivo().set("S");
            }
        }
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00101_CONTHST
         */
        hv00101Conthst().updateMghs201a247() ;
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NORMAL) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv00101Conthst().closeMghs201a263() ;
            if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        } else {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a34000InsTabela() {
        progOk.setTrue() ;
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cUsidActzUlt().set("MGHS201A");
        hv00101Conthst().conthst().cPaisIsoaCont().set(bghl201a().dadosInput().argumentoConta().cPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(bghl201a().dadosInput().argumentoConta().cBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(bghl201a().dadosInput().argumentoConta().cOeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(bghl201a().dadosInput().argumentoConta().nsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(bghl201a().dadosInput().argumentoConta().vChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(bghl201a().dadosInput().argumentoConta().cTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(bghl201a().dadosInput().argumentoConta().cMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(bghl201a().dadosInput().argumentoConta().nsDeposito());
        if (bghl201a().dadosInput().abraScta().isTrue()) {
            hv00101Conthst().conthst().iActivo().set("A");
            hv00101Conthst().conthst().zAbraCont().set(bghl201a().dadosInput().argumentoData().zAbraScta());
            hv00101Conthst().conthst().zMovHistUlt().set(bghl201a().dadosInput().argumentoData().zAbraScta());
            hv00101Conthst().conthst().zCcltCont().set("0001-01-01");
            hv00101Conthst().conthst().zRabtCont().set("0001-01-01");
            hv00101Conthst().conthst().zRabtContCcld().set("0001-01-01");
        }
        if (bghl201a().dadosInput().ccltScta().isTrue()) {
            hv00101Conthst().conthst().iActivo().set("N");
            hv00101Conthst().conthst().zCcltCont().set(bghl201a().dadosInput().argumentoData().zCcltScta());
            hv00101Conthst().conthst().zMovHistUlt().set(bghl201a().dadosInput().argumentoData().zCcltScta());
            hv00101Conthst().conthst().zAbraCont().set("0001-01-01");
            hv00101Conthst().conthst().zRabtCont().set("0001-01-01");
            hv00101Conthst().conthst().zRabtContCcld().set("0001-01-01");
        }
        if (bghl201a().dadosInput().rabtScta().isTrue()) {
            hv00101Conthst().conthst().zAbraCont().set("0001-01-01");
            hv00101Conthst().conthst().zCcltCont().set("0001-01-01");
            hv00101Conthst().conthst().zRabtContCcld().set("0001-01-01");
            hv00101Conthst().conthst().iActivo().set("A");
            hv00101Conthst().conthst().zRabtCont().set(bghl201a().dadosInput().argumentoData().zRabtScta());
            hv00101Conthst().conthst().zRabtContCcld().set(bghl201a().dadosInput().argumentoData().zRabtScta());
        }
        hv00101Conthst().conthst().cUsidActzUlt().set("MGHS201A");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00101_CONTHST
         */
        hv00101Conthst().insertMghs201a322() ;
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void s50000Responder() {
        bghl201a().dadosOutput().grErroBbn().cRtnoSwal().set(progStatus);
        if (!progOk.isTrue()) {
            bghl201a().dadosOutput().grErroBbn().nmTabela().set("VGH00101");
            bghl201a().dadosOutput().grErroBbn().cSqlcode().set(getPersistenceCode());
            bghl201a().dadosOutput().grErroBbn().aAplErro().set("GH");
            bghl201a().dadosOutput().grErroBbn().abend().setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        s10000Validar() ;
        if (progOk.isTrue()) {
            s30000Processar() ;
        }
        s50000Responder() ;
        exit() ;
    }
}
