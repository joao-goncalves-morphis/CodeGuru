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
import cgd.gh.structures.link.Bghl801a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : THO00001_CONTAS
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHJ801A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj801a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl801a
     */
    @Data
    public abstract Bghl801a bghl801a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhops00101Contas
     */
    @Data
    protected abstract Vwsdhops00101Contas hv00101Contas() ;
    
    /**
     * @return instancia da classe Vwsdhops11901Dcvoespl
     */
    @Data
    protected abstract Vwsdhops11901Dcvoespl hv11901Dcvoespl() ;
    
    /**
     * @return instancia da classe Vwsdhops00201Subcontas
     */
    @Data
    protected abstract Vwsdhops00201Subcontas hv00201Subcontas() ;
    
    
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
        bghl801a().cRetorno().initialize() ;
        bghl801a().cSqlcode().initialize() ;
        if (bghl801a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl801a().argumento().cBancCont().isEqual(0) || 
            bghl801a().argumento().cOeEgcCont().isEqual(0) || 
            bghl801a().argumento().nsRdclCont().isEqual(0) || 
            bghl801a().argumento().iDbcr().isEmpty()) {
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
            a5200AcederConta() ;
        }
        if (progOk.isTrue()) {
            if (bghl801a().detalhe().iDcvoEsplS().isTrue()) {
                a5300AcederDescEspecial() ;
            }
        }
        if (progOk.isTrue()) {
            if (bghl801a().iDadosSubcontaS().isTrue()) {
                a5400AcederSubconta() ;
            }
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
        hv00101Contas().contas().initialize() ;
        hv00101Contas().contas().cPaisIsoaCont().set(bghl801a().argumento().cPaisIsoaCont());
        hv11901Dcvoespl().dcvoespl().cPaisIsoaCont().set(bghl801a().argumento().cPaisIsoaCont());
        hv00101Contas().contas().cBancCont().set(bghl801a().argumento().cBancCont());
        hv11901Dcvoespl().dcvoespl().cBancCont().set(bghl801a().argumento().cBancCont());
        hv00101Contas().contas().cOeEgcCont().set(bghl801a().argumento().cOeEgcCont());
        hv11901Dcvoespl().dcvoespl().cOeEgcCont().set(bghl801a().argumento().cOeEgcCont());
        hv00101Contas().contas().nsRdclCont().set(bghl801a().argumento().nsRdclCont());
        hv11901Dcvoespl().dcvoespl().nsRdclCont().set(bghl801a().argumento().nsRdclCont());
        hv00101Contas().contas().vChkdCont().set(bghl801a().argumento().vChkdCont());
        hv11901Dcvoespl().dcvoespl().vChkdCont().set(bghl801a().argumento().vChkdCont());
        hv00101Contas().contas().cTipoCont().set(bghl801a().argumento().cTipoCont());
        hv11901Dcvoespl().dcvoespl().cTipoCont().set(bghl801a().argumento().cTipoCont());
        hv11901Dcvoespl().dcvoespl().iDbcr().set(bghl801a().argumento().iDbcr());
        if (bghl801a().iDadosSubcontaS().isTrue()) {
            hv00201Subcontas().subcontas().initialize() ;
            hv00201Subcontas().subcontas().cPaisIsoaCont().set(bghl801a().argumento().cPaisIsoaCont());
            hv00201Subcontas().subcontas().cBancCont().set(bghl801a().argumento().cBancCont());
            hv00201Subcontas().subcontas().cOeEgcCont().set(bghl801a().argumento().cOeEgcCont());
            hv00201Subcontas().subcontas().nsRdclCont().set(bghl801a().argumento().nsRdclCont());
            hv00201Subcontas().subcontas().vChkdCont().set(bghl801a().argumento().vChkdCont());
            hv00201Subcontas().subcontas().cTipoCont().set(bghl801a().argumento().cTipoCont());
            hv00201Subcontas().subcontas().cMoedIsoScta().set(bghl801a().argumento().cMoedIsoScta());
            hv00201Subcontas().subcontas().nsDeposito().set(bghl801a().argumento().nsDeposito());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200AcederConta() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO00101_CONTAS
         */
        hv00101Contas().selectMghj801a187() ;
        if (hv00101Contas().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv00101Contas().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00101Contas().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl801a().detalhe().cFamiProd().set(hv00101Contas().contas().cFamiProd());
            bghl801a().detalhe().cCndzMovzCont().set(hv00101Contas().contas().cCndzMovzCont());
            bghl801a().detalhe().cSectIttlBpor().set(hv00101Contas().contas().cSectIttlBpor());
            bghl801a().detalhe().cTipoTrttCont().set(hv00101Contas().contas().cTipoTrttCont());
            bghl801a().detalhe().iTipoSpte().set(hv00101Contas().contas().iTipoSpte());
            bghl801a().detalhe().iDcvoEspl().set(hv00101Contas().contas().iDcvoEspl());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300AcederDescEspecial() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO11901_DCVOESPL
         */
        hv11901Dcvoespl().selectMghj801a238() ;
        if (hv11901Dcvoespl().getPersistenceCode() == PersistenceCode.NOTFND) {
            bghl801a().detalhe().iDcvoEsplN().setTrue() ;
        }
        if (hv11901Dcvoespl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv11901Dcvoespl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl801a().detalhe().cDcvoEspl().set(hv11901Dcvoespl().dcvoespl().cDcvoEspl());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400AcederSubconta() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO00201_SUBCONTAS
         */
        hv00201Subcontas().selectMghj801a272() ;
        switch (hv00201Subcontas().getPersistenceCode()) {
            case NORMAL:
                bghl801a().detalhe().cProduto().set(hv00201Subcontas().subcontas().cProduto());
                break;
            case NOTFND:
                progNaoExiste.setTrue() ;
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
        bghl801a().cRetorno().set(progStatus);
        bghl801a().cSqlcode().set(getPersistenceCode());
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
