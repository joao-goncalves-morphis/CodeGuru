package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
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
 * migrated from program [MGHS801A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs801a extends CgdGhBaseRoutine {
    
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
     * @return instancia da classe Vwsdhops16101Cvdpobfal
     */
    @Data
    protected abstract Vwsdhops16101Cvdpobfal hv16101Cvdpobfal() ;
    
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
    
    
    @Data(size=3, value="0")
    protected IInt wCTipoConta ;
    @Data
    @Condition({ "30", "32" })
    protected ICondition cashCarry ;
    
    
    @Data(size=13)
    protected ILong wNConta ;
    
    /**
     * @return instancia da classe local WNContaMask
     */
    @Data
    @Mask
    protected abstract WNContaMask wNContaMask() ;
    
    /**
     * @return instancia da classe local Filler
     */
    @Data
    protected abstract Filler filler02() ;
    
    
    
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
            bghl801a().argumento().nsRdclCont().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
        }
        if (bghl801a().argumento().iDbcr().isEmpty() && 
            bghl801a().iDadosSubcontaN().isTrue()) {
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
        wCTipoConta.set(bghl801a().argumento().cTipoCont());
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
        hv00101Contas().selectMghs801a212() ;
        if (hv00101Contas().getPersistenceCode() == PersistenceCode.NOTFND) {
            if (cashCarry.isTrue()) {
                a5209AcederHo() ;
            } else {
                progNaoExiste.setTrue() ;
            }
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
    public void a5209AcederHo() {
        /**
         * *----------------------------------------------------------------*
         */
        wCTipoConta.set(0);
        hv16101Cvdpobfal().cvdpobfal().initialize() ;
        filler02().wCOeContaBb().set(bghl801a().argumento().cOeEgcCont());
        filler02().wNsRadicalBb().set(bghl801a().argumento().nsRdclCont());
        filler02().wCheckDigBb().set(bghl801a().argumento().vChkdCont());
        filler02().wTipoBb().set(bghl801a().argumento().cTipoCont());
        wNContaMask().wCOeConta().set(filler02().wCOeContaBb());
        wNContaMask().wNsRadical().set(filler02().wNsRadicalBb().get(2, 6));
        wNContaMask().wCheckDig().set(filler02().wCheckDigBb());
        wNContaMask().wTipo().set(filler02().wTipoBb().get(2, 2));
        hv16101Cvdpobfal().cvdpobfal().nConta().set(wNConta);
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO16101_CVDPOBFAL
         */
        hv16101Cvdpobfal().selectMghs801a281() ;
        switch (hv16101Cvdpobfal().getPersistenceCode()) {
            case NORMAL:
                bghl801a().argumento().cPaisIsoaCont().set(hv16101Cvdpobfal().cvdpobfal().cPaisIsoaCont());
                bghl801a().argumento().cBancCont().set(hv16101Cvdpobfal().cvdpobfal().cBancCont());
                bghl801a().argumento().cOeEgcCont().set(hv16101Cvdpobfal().cvdpobfal().cOeEgcCont());
                bghl801a().argumento().nsRdclCont().set(hv16101Cvdpobfal().cvdpobfal().nsRdclCont());
                bghl801a().argumento().vChkdCont().set(hv16101Cvdpobfal().cvdpobfal().vChkdCont());
                bghl801a().argumento().cTipoCont().set(hv16101Cvdpobfal().cvdpobfal().cTipoCont());
                a5100FormatarArea() ;
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
    public void a5300AcederDescEspecial() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO11901_DCVOESPL
         */
        hv11901Dcvoespl().selectMghs801a327() ;
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
        hv00201Subcontas().selectMghs801a361() ;
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
    
    public interface WNContaMask extends IDataMask {
        
        @Data(size=4)
        IInt wCOeConta() ;
        
        @Data(size=6)
        IInt wNsRadical() ;
        
        @Data(size=1)
        IInt wCheckDig() ;
        
        @Data(size=2)
        IInt wTipo() ;
        
    }
    
    public interface Filler extends IDataStruct {
        
        @Data(size=4)
        IInt wCOeContaBb() ;
        
        @Data(size=7)
        IInt wNsRadicalBb() ;
        
        @Data(size=1)
        IInt wCheckDigBb() ;
        
        @Data(size=3)
        IInt wTipoBb() ;
        
    }
}
