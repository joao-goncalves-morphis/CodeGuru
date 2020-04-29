package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl002a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00002_MOVHST
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS002A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs002a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl002a
     */
    @Data
    public abstract Bghl002a bghl002a() ;
    
    
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
    
    
    @Data(size=2)
    protected IInt wsInd ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtCriterio ;
    @Data
    @Condition("1")
    protected ICondition haCritMontantes ;
    @Data
    @Condition("2")
    protected ICondition naoHaCritMontantes ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtCriterio02 ;
    @Data
    @Condition("Z")
    protected ICondition criterioData ;
    @Data
    @Condition("N")
    protected ICondition criterioMovimento ;
    
    
    /**
     * @return instancia da classe local WsVariaveisCrt
     */
    @Data
    protected abstract WsVariaveisCrt wsVariaveisCrt() ;
    
    @Data(size=1, value=" ")
    protected IString wsCrit1 ;
    
    @Data(size=1, value=" ")
    protected IString wsCrit2 ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMMovMin ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMMovMax ;
    
    @Data(size=26)
    protected IString wsTsInicio ;
    
    /**
     * @return instancia da classe local WTsInicio
     */
    @Data
    protected abstract WTsInicio wTsInicio() ;
    
    @Data(size=26)
    protected IString wsTsFim ;
    
    /**
     * @return instancia da classe local WTsFim
     */
    @Data
    protected abstract WTsFim wTsFim() ;
    
    @Data(size=26, value=" ")
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WsVgh00201
     */
    @Data
    protected abstract WsVgh00201 wsVgh00201() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        /**
         * *----------------------------------------------------------------*
         */
        log(TraceLevel.Trace, "MGHS002A - S1000-INICIAR");
        progOk.setTrue() ;
        naoHaCritMontantes.setTrue() ;
        bghl002a().cRetorno().initialize() ;
        bghl002a().cSqlcode().initialize() ;
        if (bghl002a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl002a().argumento().cBancCont().isEqual(0) || 
            bghl002a().argumento().cOeEgcCont().isEqual(0) || 
            bghl002a().argumento().nsRdclCont().isEqual(0) || 
            bghl002a().argumento().cMoedIsoScta().isEmpty() || 
            bghl002a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl002a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl002a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl002a().criterioConsulta().ascendente().isTrue() && !bghl002a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (bghl002a().criterioMontante().mMovMin().isEqual(0) && 
                    bghl002a().criterioMontante().mMovMax().isEqual(0)) {
                    naoHaCritMontantes.setTrue() ;
                } else {
                    haCritMontantes.setTrue() ;
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
        log(TraceLevel.Trace, "MGHS002A - S3000-PROCESSAR");
        a5100FormatarArea() ;
        if (bghl002a().criterioConsulta().ascendente().isTrue()) {
            if (naoHaCritMontantes.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMontante() ;
            }
        } else if (bghl002a().criterioConsulta().descendente().isTrue()) {
            if (naoHaCritMontantes.isTrue()) {
                a5400ListaDscData() ;
            } else {
                a5500ListaDscMontante() ;
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
        log(TraceLevel.Trace, "MGHS002A - A5100-FORMATAR-AREA");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(bghl002a().argumento().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(bghl002a().argumento().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(bghl002a().argumento().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(bghl002a().argumento().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(bghl002a().argumento().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(bghl002a().argumento().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(bghl002a().argumento().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(bghl002a().argumento().nsDeposito());
        hv00201Movhst().movhst().nsMovimento().set(bghl002a().argumento().nsMovimento());
        log(TraceLevel.Trace, "--VGH00201-C-PAIS-ISOA-CON: ", hv00201Movhst().movhst().cPaisIsoaCont());
        log(TraceLevel.Trace, "--VGH00201-C-BANC-CONT    : ", hv00201Movhst().movhst().cBancCont());
        log(TraceLevel.Trace, "--VGH00201-C-OE-EGC-CONT  : ", hv00201Movhst().movhst().cOeEgcCont());
        log(TraceLevel.Trace, "--VGH00201-NS-RDCL-CONT   : ", hv00201Movhst().movhst().nsRdclCont());
        log(TraceLevel.Trace, "--VGH00201-V-CHKD-CONT    : ", hv00201Movhst().movhst().vChkdCont());
        log(TraceLevel.Trace, "--VGH00201-C-TIPO-CONT    : ", hv00201Movhst().movhst().cTipoCont());
        log(TraceLevel.Trace, "--VGH00201-C-MOED-ISO-SCTA: ", hv00201Movhst().movhst().cMoedIsoScta());
        log(TraceLevel.Trace, "--VGH00201-NS-DEPOSITO    : ", hv00201Movhst().movhst().nsDeposito());
        log(TraceLevel.Trace, "--VGH00201-NS-MOVIMENTO   : ", hv00201Movhst().movhst().nsMovimento());
        if (bghl002a().criterioConsulta().descendente().isTrue()) {
            if (bghl002a().argumento().nsMovimento().isEqual(0)) {
                hv00201Movhst().movhst().nsMovimento().set(9);
            }
        }
        if (haCritMontantes.isTrue()) {
            wsMMovMin.set(bghl002a().criterioMontante().mMovMin());
            wsMMovMax.set(bghl002a().criterioMontante().mMovMax());
        }
        wsTsInicio.set(bghl002a().argumento().tsMovimento());
        wsTsFim.set(bghl002a().criterioSeleccao().tsMovMax());
        log(TraceLevel.Trace, "--WS-TS-INICIO: ", wsTsInicio);
        log(TraceLevel.Trace, "--WS-TS-FIM   : ", wsTsFim);
        if (bghl002a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl002a().criterioDbcr().debito().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conDebito());
        } else {
            wsCrit1.set(wsVariaveisCrt().conCredito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200ListaAscData() {
        /**
         * *----------------------------------------------------------------*
         */
        log(TraceLevel.Trace, "A5200-LISTA-ASC-DATA");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00201Movhst().openMghs002a535(wsTsInicio, wsTsFim, wsCrit1, wsCrit2) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv00201Movhst().fetchMghs002a547() ;
            log(TraceLevel.Error, "SQLCODE: ", hv00201Movhst().getPersistenceCode());
            if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh00201().wsCPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
                wsVgh00201().wsCBancCont().set(hv00201Movhst().movhst().cBancCont());
                wsVgh00201().wsCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
                wsVgh00201().wsNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
                wsVgh00201().wsVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
                wsVgh00201().wsCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
                wsVgh00201().wsCMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
                wsVgh00201().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
                wsVgh00201().wsTsMovimento().set(hv00201Movhst().movhst().tsMovimento());
                wsVgh00201().wsNsMovimento().set(hv00201Movhst().movhst().nsMovimento());
                wsVgh00201().wsZValMov().set(hv00201Movhst().movhst().zValMov());
                wsVgh00201().wsZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
                wsVgh00201().wsIDbcr().set(hv00201Movhst().movhst().iDbcr());
                wsVgh00201().wsMMovimento().set(hv00201Movhst().movhst().mMovimento());
                wsVgh00201().wsIEstorno().set(hv00201Movhst().movhst().iEstorno());
                wsVgh00201().wsCMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
                wsVgh00201().wsMSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
                wsVgh00201().wsMSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
                wsVgh00201().wsMMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
                wsVgh00201().wsXRefMov().set(hv00201Movhst().movhst().xRefMov());
                wsVgh00201().wsNDocOpps().set(hv00201Movhst().movhst().nDocOpps());
                wsVgh00201().wsTJuro().set(hv00201Movhst().movhst().tJuro());
                wsVgh00201().wsAAplOrig().set(hv00201Movhst().movhst().aAplOrig());
                wsVgh00201().wsIExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
                if (hv00201Movhst().movhst().aAplOrig().isEqual("DR")) {
                    wsVgh00201().wsIExisInfAdi().set("S");
                }
                wsVgh00201().wsXChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
                wsVgh00201().wsTsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
                wsVgh00201().wsCUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
                bghl002a().tabela().lista().get(wsInd).item().set(wsVgh00201());
                bghl002a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv00201Movhst().fetchMghs002a616() ;
                if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv00201Movhst().closeMghs002a633() ;
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300ListaAscMontante() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv00201Movhst().openMghs002a645(wsTsInicio, wsTsFim, wsMMovMin, wsMMovMax, wsCrit1, wsCrit2) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C3
             */
            hv00201Movhst().fetchMghs002a657() ;
            if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh00201().wsCPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
                wsVgh00201().wsCBancCont().set(hv00201Movhst().movhst().cBancCont());
                wsVgh00201().wsCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
                wsVgh00201().wsNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
                wsVgh00201().wsVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
                wsVgh00201().wsCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
                wsVgh00201().wsCMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
                wsVgh00201().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
                wsVgh00201().wsTsMovimento().set(hv00201Movhst().movhst().tsMovimento());
                wsVgh00201().wsNsMovimento().set(hv00201Movhst().movhst().nsMovimento());
                wsVgh00201().wsZValMov().set(hv00201Movhst().movhst().zValMov());
                wsVgh00201().wsZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
                wsVgh00201().wsIDbcr().set(hv00201Movhst().movhst().iDbcr());
                wsVgh00201().wsMMovimento().set(hv00201Movhst().movhst().mMovimento());
                wsVgh00201().wsIEstorno().set(hv00201Movhst().movhst().iEstorno());
                wsVgh00201().wsCMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
                wsVgh00201().wsMSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
                wsVgh00201().wsMSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
                wsVgh00201().wsMMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
                wsVgh00201().wsXRefMov().set(hv00201Movhst().movhst().xRefMov());
                wsVgh00201().wsNDocOpps().set(hv00201Movhst().movhst().nDocOpps());
                wsVgh00201().wsTJuro().set(hv00201Movhst().movhst().tJuro());
                wsVgh00201().wsAAplOrig().set(hv00201Movhst().movhst().aAplOrig());
                wsVgh00201().wsIExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
                wsVgh00201().wsXChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
                wsVgh00201().wsTsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
                wsVgh00201().wsCUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
                bghl002a().tabela().lista().get(wsInd).item().set(wsVgh00201());
                bghl002a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C3
                 */
                hv00201Movhst().fetchMghs002a720() ;
                if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C3
             */
            hv00201Movhst().closeMghs002a737() ;
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400ListaDscData() {
        /**
         * *----------------------------------------------------------------*
         */
        log(TraceLevel.Trace, "A5400-LISTA-DSC-DATA");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv00201Movhst().openMghs002a749(wsTsInicio, wsTsFim, wsCrit1, wsCrit2) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv00201Movhst().fetchMghs002a761() ;
            log(TraceLevel.Error, "SQLCODE: ", hv00201Movhst().getPersistenceCode());
            if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh00201().wsCPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
                wsVgh00201().wsCBancCont().set(hv00201Movhst().movhst().cBancCont());
                wsVgh00201().wsCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
                wsVgh00201().wsNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
                wsVgh00201().wsVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
                wsVgh00201().wsCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
                wsVgh00201().wsCMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
                wsVgh00201().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
                wsVgh00201().wsTsMovimento().set(hv00201Movhst().movhst().tsMovimento());
                wsVgh00201().wsNsMovimento().set(hv00201Movhst().movhst().nsMovimento());
                wsVgh00201().wsZValMov().set(hv00201Movhst().movhst().zValMov());
                wsVgh00201().wsZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
                wsVgh00201().wsIDbcr().set(hv00201Movhst().movhst().iDbcr());
                wsVgh00201().wsMMovimento().set(hv00201Movhst().movhst().mMovimento());
                wsVgh00201().wsIEstorno().set(hv00201Movhst().movhst().iEstorno());
                wsVgh00201().wsCMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
                wsVgh00201().wsMSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
                wsVgh00201().wsMSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
                wsVgh00201().wsMMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
                wsVgh00201().wsXRefMov().set(hv00201Movhst().movhst().xRefMov());
                wsVgh00201().wsNDocOpps().set(hv00201Movhst().movhst().nDocOpps());
                wsVgh00201().wsTJuro().set(hv00201Movhst().movhst().tJuro());
                wsVgh00201().wsAAplOrig().set(hv00201Movhst().movhst().aAplOrig());
                wsVgh00201().wsIExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
                wsVgh00201().wsXChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
                wsVgh00201().wsTsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
                wsVgh00201().wsCUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
                bghl002a().tabela().lista().get(wsInd).item().set(wsVgh00201());
                bghl002a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv00201Movhst().fetchMghs002a824() ;
                if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv00201Movhst().closeMghs002a841() ;
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500ListaDscMontante() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C4
         */
        hv00201Movhst().openMghs002a853(wsTsInicio, wsMMovMin, wsMMovMax, wsTsFim, wsCrit1, wsCrit2) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv00201Movhst().fetchMghs002a865() ;
            if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh00201().wsCPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
                wsVgh00201().wsCBancCont().set(hv00201Movhst().movhst().cBancCont());
                wsVgh00201().wsCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
                wsVgh00201().wsNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
                wsVgh00201().wsVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
                wsVgh00201().wsCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
                wsVgh00201().wsCMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
                wsVgh00201().wsNsDeposito().set(hv00201Movhst().movhst().nsDeposito());
                wsVgh00201().wsTsMovimento().set(hv00201Movhst().movhst().tsMovimento());
                wsVgh00201().wsNsMovimento().set(hv00201Movhst().movhst().nsMovimento());
                wsVgh00201().wsZValMov().set(hv00201Movhst().movhst().zValMov());
                wsVgh00201().wsZMovLocl().set(hv00201Movhst().movhst().zMovLocl());
                wsVgh00201().wsIDbcr().set(hv00201Movhst().movhst().iDbcr());
                wsVgh00201().wsMMovimento().set(hv00201Movhst().movhst().mMovimento());
                wsVgh00201().wsIEstorno().set(hv00201Movhst().movhst().iEstorno());
                wsVgh00201().wsCMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
                wsVgh00201().wsMSldoCbloApos().set(hv00201Movhst().movhst().mSldoCbloApos());
                wsVgh00201().wsMSldoDpnlApos().set(hv00201Movhst().movhst().mSldoDpnlApos());
                wsVgh00201().wsMMovMoeOrigMov().set(hv00201Movhst().movhst().mMovMoeOrigMov());
                wsVgh00201().wsXRefMov().set(hv00201Movhst().movhst().xRefMov());
                wsVgh00201().wsNDocOpps().set(hv00201Movhst().movhst().nDocOpps());
                wsVgh00201().wsTJuro().set(hv00201Movhst().movhst().tJuro());
                wsVgh00201().wsAAplOrig().set(hv00201Movhst().movhst().aAplOrig());
                wsVgh00201().wsIExisInfAdi().set(hv00201Movhst().movhst().iExisInfAdi());
                wsVgh00201().wsXChavAcsInfAdi().set(hv00201Movhst().movhst().xChavAcsInfAdi());
                wsVgh00201().wsTsActzUlt().set(hv00201Movhst().movhst().tsActzUlt());
                wsVgh00201().wsCUsidActzUlt().set(hv00201Movhst().movhst().cUsidActzUlt());
                bghl002a().tabela().lista().get(wsInd).item().set(wsVgh00201());
                bghl002a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv00201Movhst().fetchMghs002a928() ;
                if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv00201Movhst().closeMghs002a945() ;
            if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
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
        bghl002a().cRetorno().set(progStatus);
        bghl002a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVariaveisCrt extends IDataStruct {
        
        @Data(size=1, value="D")
        IString conDebito() ;
        
        @Data(size=1, value="C")
        IString conCredito() ;
        
        @Data(size=1, value="A")
        IString conDebCred() ;
        
    }
    
    public interface WTsInicio extends IDataStruct {
        
        @Data(size=10)
        IString wsDataInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
        IInt wsHoraInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsMinInicio() ;
        
        @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
        IInt wsSecInicio() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestInicio() ;
        
    }
    
    public interface WTsFim extends IDataStruct {
        
        @Data(size=10)
        IString wsDataFim() ;
        
        @Data(size=2, value="23", lpadding=1, lpaddingValue="-")
        IInt wsHoraFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsMinFim() ;
        
        @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
        IInt wsSecFim() ;
        
        @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
        IInt wsRestFim() ;
        
    }
    
    public interface WsVgh00201 extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3)
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDeposito() ;
        
        @Data(size=26)
        IString wsTsMovimento() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovimento() ;
        
        @Data(size=10)
        IString wsZValMov() ;
        
        @Data(size=10)
        IString wsZMovLocl() ;
        
        @Data(size=1)
        IString wsIDbcr() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovimento() ;
        
        @Data(size=1)
        IString wsIEstorno() ;
        
        @Data(size=3)
        IString wsCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoCbloApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMSldoDpnlApos() ;
        
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal wsMMovMoeOrigMov() ;
        
        @Data(size=21)
        IString wsXRefMov() ;
        
        @Data(size=10, signed=true, compression=COMP3)
        ILong wsNDocOpps() ;
        
        @Data(size=10, decimal=7, signed=true, compression=COMP3)
        IDecimal wsTJuro() ;
        
        @Data(size=2)
        IString wsAAplOrig() ;
        
        @Data(size=1)
        IString wsIExisInfAdi() ;
        
        @Data(size=40)
        IString wsXChavAcsInfAdi() ;
        
        @Data(size=26)
        IString wsTsActzUlt() ;
        
        @Data(size=8)
        IString wsCUsidActzUlt() ;
        
    }
}
