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
import cgd.gh.structures.link.Bghl802a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : VHO12901_TXCADERN
 * DESCRICAO     : OBTEM TAXA DE JUROS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS802A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs802a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl802a
     */
    @Data
    public abstract Bghl802a bghl802a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhops12901Txcadern
     */
    @Data
    protected abstract Vwsdhops12901Txcadern hv12901Txcadern() ;
    
    
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
    @Condition("80")
    protected ICondition progNaoExiste ;
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
        bghl802a().cRetorno().initialize() ;
        bghl802a().cSqlcode().initialize() ;
        if (bghl802a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl802a().argumento().cBancCont().isEqual(0) || 
            bghl802a().argumento().cOeEgcCont().isEqual(0) || 
            bghl802a().argumento().nsRdclCont().isEqual(0) || 
            bghl802a().argumento().cMoedIsoScta().isEmpty() || 
            bghl802a().argumento().nsMovimento().isEqual(0)) {
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
            a5200ObterTaxa() ;
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
        hv12901Txcadern().txcadern().initialize() ;
        hv12901Txcadern().txcadern().cPaisIsoaCont().set(bghl802a().argumento().cPaisIsoaCont());
        hv12901Txcadern().txcadern().cBancCont().set(bghl802a().argumento().cBancCont());
        hv12901Txcadern().txcadern().cOeEgcCont().set(bghl802a().argumento().cOeEgcCont());
        hv12901Txcadern().txcadern().nsRdclCont().set(bghl802a().argumento().nsRdclCont());
        hv12901Txcadern().txcadern().vChkdCont().set(bghl802a().argumento().vChkdCont());
        hv12901Txcadern().txcadern().cTipoCont().set(bghl802a().argumento().cTipoCont());
        hv12901Txcadern().txcadern().cMoedIsoScta().set(bghl802a().argumento().cMoedIsoScta());
        hv12901Txcadern().txcadern().nsDeposito().set(bghl802a().argumento().nsDeposito());
        hv12901Txcadern().txcadern().nsMovimento().set(bghl802a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200ObterTaxa() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO12901_TXCADERN
         */
        hv12901Txcadern().selectMghs802a150() ;
        switch (hv12901Txcadern().getPersistenceCode()) {
            case NORMAL:
                bghl802a().detalhe().tJuro().set(hv12901Txcadern().txcadern().tJuro());
                break;
            case NOTFND:
                bghl802a().detalhe().tJuro().set(0);
                break;
            default :
                progDb2.setTrue() ;
                break;
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
        bghl802a().cRetorno().set(progStatus);
        bghl802a().cSqlcode().set(getPersistenceCode());
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
