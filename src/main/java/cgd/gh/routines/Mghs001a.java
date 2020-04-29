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
import cgd.gh.structures.link.Bghl001a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00001_CONTHST
 * DESCRICAO     : OBTEM DADOS DA TABELA
 * ALTERAÇÕES : 2010-11-25
 * QD NAO EXISTE CONTA NA TGH001 VAI VERIFICAR SE
 * EXISTE REGISTO DA CONTA NA TGH010. SE EXISTIR,
 * RECONSTROI AS DATA NA AREA DA MENSAGEM PARA SE
 * PERMITIR CRIAR PEDIDOS DE INFORMACAO
 * 
 * migrated from program [MGHS001A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs001a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl001a
     */
    @Data
    public abstract Bghl001a bghl001a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01001Contiphst
     */
    @Data
    protected abstract Vwsdghps01001Contiphst hv01001Contiphst() ;
    
    /**
     * @return instancia da classe Vwsdghps00101Conthst
     */
    @Data
    protected abstract Vwsdghps00101Conthst hv00101Conthst() ;
    
    /**
     * @return instancia da classe Vwsdhops16101Cvdpobfal
     */
    @Data
    protected abstract Vwsdhops16101Cvdpobfal hv16101Cvdpobfal() ;
    
    
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
    
    
    @Data(size=3, value="0")
    protected IInt wCTipoConta ;
    @Data
    @Condition({ "30", "32" })
    protected ICondition cashCarry ;
    
    
    @Data(size=3, value=" ")
    protected IString wsCMoeInic ;
    
    @Data(size=3, value=" ")
    protected IString wsCMoeFim ;
    
    /**
     * @return instancia da classe local WsZInicio
     */
    @Data
    protected abstract WsZInicio wsZInicio() ;
    
    /**
     * @return instancia da classe local WsZFim
     */
    @Data
    protected abstract WsZFim wsZFim() ;
    
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
        bghl001a().cRetorno().initialize() ;
        bghl001a().cSqlcode().initialize() ;
        if (bghl001a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl001a().argumento().cBancCont().isEqual(0) || 
            bghl001a().argumento().cOeEgcCont().isEqual(0) || 
            bghl001a().argumento().nsRdclCont().isEqual(0) || 
            bghl001a().argumento().cMoedIsoScta().isEmpty()) {
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
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cPaisIsoaCont().set(bghl001a().argumento().cPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(bghl001a().argumento().cBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(bghl001a().argumento().cOeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(bghl001a().argumento().nsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(bghl001a().argumento().vChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(bghl001a().argumento().cTipoCont());
        wCTipoConta.set(bghl001a().argumento().cTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(bghl001a().argumento().cMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(bghl001a().argumento().nsDeposito());
    }
    
    /**
     * 
     * 
     */
    public void a5200AcederTab() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00101_CONTHST
         */
        hv00101Conthst().selectMghs001a220() ;
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NOTFND) {
            if (cashCarry.isTrue()) {
                a5210AcederHo() ;
            } else {
                progNaoExisteConta.setTrue() ;
            }
        }
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl001a().detalhe().iActivo().set(hv00101Conthst().conthst().iActivo());
            bghl001a().detalhe().cMoedIsoAntEur().set(hv00101Conthst().conthst().cMoedIsoAntEur());
            bghl001a().detalhe().zAbraCont().set(hv00101Conthst().conthst().zAbraCont());
            bghl001a().detalhe().zCcltCont().set(hv00101Conthst().conthst().zCcltCont());
            bghl001a().detalhe().zRabtCont().set(hv00101Conthst().conthst().zRabtCont());
            bghl001a().detalhe().zRabtContCcld().set(hv00101Conthst().conthst().zRabtContCcld());
            bghl001a().detalhe().zMovHistUlt().set(hv00101Conthst().conthst().zMovHistUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5210AcederHo() {
        /**
         * *----------------------------------------------------------------*
         */
        wCTipoConta.set(0);
        hv16101Cvdpobfal().cvdpobfal().initialize() ;
        filler02().wCOeContaBb().set(bghl001a().argumento().cOeEgcCont());
        filler02().wNsRadicalBb().set(bghl001a().argumento().nsRdclCont());
        filler02().wCheckDigBb().set(bghl001a().argumento().vChkdCont());
        filler02().wTipoBb().set(bghl001a().argumento().cTipoCont());
        wNContaMask().wCOeConta().set(filler02().wCOeContaBb());
        wNContaMask().wNsRadical().set(filler02().wNsRadicalBb().get(2, 6));
        wNContaMask().wCheckDig().set(filler02().wCheckDigBb());
        wNContaMask().wTipo().set(filler02().wTipoBb().get(2, 2));
        hv16101Cvdpobfal().cvdpobfal().nConta().set(wNConta);
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO16101_CVDPOBFAL
         */
        hv16101Cvdpobfal().selectMghs001a293() ;
        switch (hv16101Cvdpobfal().getPersistenceCode()) {
            case NORMAL:
                hv00101Conthst().conthst().cPaisIsoaCont().set(hv16101Cvdpobfal().cvdpobfal().cPaisIsoaCont());
                hv00101Conthst().conthst().cBancCont().set(hv16101Cvdpobfal().cvdpobfal().cBancCont());
                hv00101Conthst().conthst().cOeEgcCont().set(hv16101Cvdpobfal().cvdpobfal().cOeEgcCont());
                hv00101Conthst().conthst().nsRdclCont().set(hv16101Cvdpobfal().cvdpobfal().nsRdclCont());
                hv00101Conthst().conthst().vChkdCont().set(hv16101Cvdpobfal().cvdpobfal().vChkdCont());
                hv00101Conthst().conthst().cTipoCont().set(hv16101Cvdpobfal().cvdpobfal().cTipoCont());
                hv00101Conthst().conthst().cMoedIsoScta().set(bghl001a().argumento().cMoedIsoScta());
                hv00101Conthst().conthst().nsDeposito().set(bghl001a().argumento().nsDeposito());
                a5200AcederTab() ;
                break;
            case NOTFND:
                progNaoExisteConta.setTrue() ;
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
        if (progNaoExisteConta.isTrue()) {
            progOk.setTrue() ;
            a5100VerTabTgh10() ;
        }
        bghl001a().cRetorno().set(progStatus);
        bghl001a().cSqlcode().set(getPersistenceCode());
    }
    
    /**
     * 
     * 
     */
    public void a5100VerTabTgh10() {
        /**
         * *----------------------------------------------------------------*
         */
        hv01001Contiphst().contiphst().initialize() ;
        wsZInicio().wsAnoInic().initialize() ;
        wsZFim().wsAnoFim().initialize() ;
        wsCMoeInic.initialize() ;
        wsCMoeFim.initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(bghl001a().argumento().cPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(bghl001a().argumento().cBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(bghl001a().argumento().cOeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(bghl001a().argumento().nsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(bghl001a().argumento().vChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(bghl001a().argumento().cTipoCont());
        hv01001Contiphst().contiphst().nsDeposito().set(bghl001a().argumento().nsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01001Contiphst().openMghs001a368() ;
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv01001Contiphst().fetchMghs001a380() ;
            if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteConta.setTrue() ;
            }
            if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            while (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL) {
                if (hv01001Contiphst().contiphst().zaInicio().isEqual(2001)) {
                    if (wsCMoeInic.isEmpty()) {
                        if (!bghl001a().argumento().cMoedIsoScta().isEqual(hv01001Contiphst().contiphst().cMoedIsoScta())) {
                            wsCMoeInic.set(hv01001Contiphst().contiphst().cMoedIsoScta());
                            wsCMoeFim.set("EUR");
                        } else {
                            wsCMoeInic.set(hv01001Contiphst().contiphst().cMoedIsoScta());
                            wsCMoeFim.set(hv01001Contiphst().contiphst().cMoedIsoScta());
                        }
                    } else {
                        wsCMoeFim.set(hv01001Contiphst().contiphst().cMoedIsoScta());
                    }
                } else if (wsCMoeInic.isEmpty()) {
                    wsCMoeInic.set(hv01001Contiphst().contiphst().cMoedIsoScta());
                    wsCMoeFim.set(hv01001Contiphst().contiphst().cMoedIsoScta());
                } else {
                    wsCMoeFim.set(hv01001Contiphst().contiphst().cMoedIsoScta());
                }
                if (wsZInicio().wsAnoInic().isEqual(0)) {
                    wsZInicio().wsAnoInic().set(hv01001Contiphst().contiphst().zaInicio());
                    wsZFim().wsAnoFim().set(hv01001Contiphst().contiphst().zaFim());
                } else {
                    wsZFim().wsAnoFim().set(hv01001Contiphst().contiphst().zaFim());
                }
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv01001Contiphst().fetchMghs001a432() ;
                if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv01001Contiphst().closeMghs001a452() ;
            if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            if (bghl001a().argumento().cMoedIsoScta().isEqual(wsCMoeFim) || 
                bghl001a().argumento().cMoedIsoScta().isEqual(wsCMoeInic)) {
                bghl001a().detalhe().iActivo().set("D");
                if (!bghl001a().argumento().cMoedIsoScta().isEqual(wsCMoeFim)) {
                    bghl001a().argumento().cMoedIsoScta().set(wsCMoeFim);
                }
                bghl001a().detalhe().cMoedIsoAntEur().set(wsCMoeInic);
                bghl001a().detalhe().zAbraCont().set(wsZInicio());
                bghl001a().detalhe().zRabtCont().set("0001-01-01");
                bghl001a().detalhe().zRabtContCcld().set("0001-01-01");
                bghl001a().detalhe().zMovHistUlt().set(wsZFim());
                bghl001a().detalhe().zCcltCont().set(wsZFim());
            } else {
                progNaoExisteConta.setTrue() ;
            }
        }
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
    
    public interface WsZInicio extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoInic() ;
        
        @Data(size=2, value="1", lpadding=1, lpaddingValue="-")
        IInt wsMesInic() ;
        
        @Data(size=2, value="1", lpadding=1, lpaddingValue="-")
        IInt wsDiaInic() ;
        
    }
    
    public interface WsZFim extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoFim() ;
        
        @Data(size=2, value="12", lpadding=1, lpaddingValue="-")
        IInt wsMesFim() ;
        
        @Data(size=2, value="31", lpadding=1, lpaddingValue="-")
        IInt wsDiaFim() ;
        
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
