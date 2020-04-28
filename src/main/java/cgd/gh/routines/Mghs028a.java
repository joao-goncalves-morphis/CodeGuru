package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl028a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00028_MOVHIST8
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * DOS MOVIMENTOS DE HA 8 ANOS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS028A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs028a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl028a
     */
    @Data
    public abstract Bghl028a bghl028a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02801Movhist8
     */
    @Data
    protected abstract Vwsdghps02801Movhist8 hv02801Movhist8() ;
    
    
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
    @Condition("Z")
    protected ICondition criterioData ;
    @Data
    @Condition("N")
    protected ICondition criterioMovimento ;
    
    
    /**
     * PRC19 - INI
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
    
    /**
     * PRC19 - FIM
     */
    @Data(size=15, signed=true, compression=COMP3)
    protected ILong wsNsMovMin ;
    
    @Data(size=15, signed=true, compression=COMP3)
    protected ILong wsNsMovMax ;
    
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
     * @return instancia da classe local WsVgh02801
     */
    @Data
    protected abstract WsVgh02801 wsVgh02801() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl028a().cRetorno().initialize() ;
        bghl028a().cSqlcode().initialize() ;
        if (bghl028a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl028a().argumento().cBancCont().isEqual(0) || 
            bghl028a().argumento().cOeEgcCont().isEqual(0) || 
            bghl028a().argumento().nsRdclCont().isEqual(0) || 
            bghl028a().argumento().cMoedIsoScta().isEmpty() || 
            bghl028a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl028a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl028a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl028a().criterioConsulta().ascendente().isTrue() && !bghl028a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (!bghl028a().criterioSeleccao().tsMovMax().isEmpty()) {
                    criterioData.setTrue() ;
                    wsTsInicio.set(bghl028a().argumento().tsMovimento());
                    wsTsFim.set(bghl028a().criterioSeleccao().tsMovMax());
                } else {
                    criterioMovimento.setTrue() ;
                    wsNsMovMin.set(bghl028a().argumento().nsMovimento());
                    wsNsMovMax.set(bghl028a().criterioSeleccao().nsMovMax());
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
        if (bghl028a().criterioConsulta().ascendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMov() ;
            }
        } else if (bghl028a().criterioConsulta().descendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5400ListaDscData() ;
            } else {
                a5500ListaDscMov() ;
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
         * PRC19 - FIM
         */
        hv02801Movhist8().movhist8().initialize() ;
        hv02801Movhist8().movhist8().cPaisIsoaCont().set(bghl028a().argumento().cPaisIsoaCont());
        hv02801Movhist8().movhist8().cBancCont().set(bghl028a().argumento().cBancCont());
        hv02801Movhist8().movhist8().cOeEgcCont().set(bghl028a().argumento().cOeEgcCont());
        hv02801Movhist8().movhist8().nsRdclCont().set(bghl028a().argumento().nsRdclCont());
        hv02801Movhist8().movhist8().vChkdCont().set(bghl028a().argumento().vChkdCont());
        hv02801Movhist8().movhist8().cTipoCont().set(bghl028a().argumento().cTipoCont());
        hv02801Movhist8().movhist8().cMoedIsoScta().set(bghl028a().argumento().cMoedIsoScta());
        hv02801Movhist8().movhist8().nsDeposito().set(bghl028a().argumento().nsDeposito());
        hv02801Movhist8().movhist8().nsMovimento().set(bghl028a().argumento().nsMovimento());
        if (bghl028a().criterioConsulta().descendente().isTrue()) {
            if (bghl028a().argumento().nsMovimento().isEqual(0)) {
                hv02801Movhist8().movhist8().nsMovimento().set(9);
            }
        }
        if (criterioData.isTrue()) {
            wsTsInicio.set(bghl028a().argumento().tsMovimento());
            wsTsFim.set(bghl028a().criterioSeleccao().tsMovMax());
        } else {
            wsNsMovMin.set(bghl028a().argumento().nsMovimento());
            wsNsMovMax.set(bghl028a().criterioSeleccao().nsMovMax());
        }
        /**
         * PRC19 - INI
         * SE O MONTANTE MAXIMO DO MOVIMENTO FOR ZERO, FORÇA VALOR MAX
         */
        wsMMovMin.set(bghl028a().criterioMontante().mMovMin());
        if (bghl028a().criterioMontante().mMovMax().isEqual(0)) {
            wsMMovMax.set(999999999999999.99);
        } else {
            wsMMovMax.set(bghl028a().criterioMontante().mMovMax());
        }
        if (bghl028a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl028a().criterioDbcr().debito().isTrue()) {
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
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv02801Movhist8().openMghs028a522(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02801Movhist8().fetchMghs028a534() ;
            if (hv02801Movhist8().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02801Movhist8().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02801().wsCPaisIsoaCont().set(hv02801Movhist8().movhist8().cPaisIsoaCont());
                wsVgh02801().wsCBancCont().set(hv02801Movhist8().movhist8().cBancCont());
                wsVgh02801().wsCOeEgcCont().set(hv02801Movhist8().movhist8().cOeEgcCont());
                wsVgh02801().wsNsRdclCont().set(hv02801Movhist8().movhist8().nsRdclCont());
                wsVgh02801().wsVChkdCont().set(hv02801Movhist8().movhist8().vChkdCont());
                wsVgh02801().wsCTipoCont().set(hv02801Movhist8().movhist8().cTipoCont());
                wsVgh02801().wsCMoedIsoScta().set(hv02801Movhist8().movhist8().cMoedIsoScta());
                wsVgh02801().wsNsDeposito().set(hv02801Movhist8().movhist8().nsDeposito());
                wsVgh02801().wsTsMovimento().set(hv02801Movhist8().movhist8().tsMovimento());
                wsVgh02801().wsNsMovimento().set(hv02801Movhist8().movhist8().nsMovimento());
                wsVgh02801().wsZValMov().set(hv02801Movhist8().movhist8().zValMov());
                wsVgh02801().wsZMovLocl().set(hv02801Movhist8().movhist8().zMovLocl());
                wsVgh02801().wsIDbcr().set(hv02801Movhist8().movhist8().iDbcr());
                wsVgh02801().wsMMovimento().set(hv02801Movhist8().movhist8().mMovimento());
                wsVgh02801().wsIEstorno().set(hv02801Movhist8().movhist8().iEstorno());
                wsVgh02801().wsCMoedIsoOriMov().set(hv02801Movhist8().movhist8().cMoedIsoOriMov());
                wsVgh02801().wsMSldoCbloApos().set(hv02801Movhist8().movhist8().mSldoCbloApos());
                wsVgh02801().wsMSldoDpnlApos().set(hv02801Movhist8().movhist8().mSldoDpnlApos());
                wsVgh02801().wsMMovMoeOrigMov().set(hv02801Movhist8().movhist8().mMovMoeOrigMov());
                wsVgh02801().wsXRefMov().set(hv02801Movhist8().movhist8().xRefMov());
                wsVgh02801().wsNDocOpps().set(hv02801Movhist8().movhist8().nDocOpps());
                wsVgh02801().wsTJuro().set(hv02801Movhist8().movhist8().tJuro());
                wsVgh02801().wsAAplOrig().set(hv02801Movhist8().movhist8().aAplOrig());
                wsVgh02801().wsIExisInfAdi().set(hv02801Movhist8().movhist8().iExisInfAdi());
                wsVgh02801().wsXChavAcsInfAdi().set(hv02801Movhist8().movhist8().xChavAcsInfAdi());
                wsVgh02801().wsTsActzUlt().set(hv02801Movhist8().movhist8().tsActzUlt());
                wsVgh02801().wsCUsidActzUlt().set(hv02801Movhist8().movhist8().cUsidActzUlt());
                bghl028a().tabela().lista().get(wsInd).item().set(wsVgh02801());
                bghl028a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02801Movhist8().fetchMghs028a597() ;
                if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02801Movhist8().closeMghs028a614() ;
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300ListaAscMov() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv02801Movhist8().openMghs028a626(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02801Movhist8().fetchMghs028a638() ;
            if (hv02801Movhist8().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02801Movhist8().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02801().wsCPaisIsoaCont().set(hv02801Movhist8().movhist8().cPaisIsoaCont());
                wsVgh02801().wsCBancCont().set(hv02801Movhist8().movhist8().cBancCont());
                wsVgh02801().wsCOeEgcCont().set(hv02801Movhist8().movhist8().cOeEgcCont());
                wsVgh02801().wsNsRdclCont().set(hv02801Movhist8().movhist8().nsRdclCont());
                wsVgh02801().wsVChkdCont().set(hv02801Movhist8().movhist8().vChkdCont());
                wsVgh02801().wsCTipoCont().set(hv02801Movhist8().movhist8().cTipoCont());
                wsVgh02801().wsCMoedIsoScta().set(hv02801Movhist8().movhist8().cMoedIsoScta());
                wsVgh02801().wsNsDeposito().set(hv02801Movhist8().movhist8().nsDeposito());
                wsVgh02801().wsTsMovimento().set(hv02801Movhist8().movhist8().tsMovimento());
                wsVgh02801().wsNsMovimento().set(hv02801Movhist8().movhist8().nsMovimento());
                wsVgh02801().wsZValMov().set(hv02801Movhist8().movhist8().zValMov());
                wsVgh02801().wsZMovLocl().set(hv02801Movhist8().movhist8().zMovLocl());
                wsVgh02801().wsIDbcr().set(hv02801Movhist8().movhist8().iDbcr());
                wsVgh02801().wsMMovimento().set(hv02801Movhist8().movhist8().mMovimento());
                wsVgh02801().wsIEstorno().set(hv02801Movhist8().movhist8().iEstorno());
                wsVgh02801().wsCMoedIsoOriMov().set(hv02801Movhist8().movhist8().cMoedIsoOriMov());
                wsVgh02801().wsMSldoCbloApos().set(hv02801Movhist8().movhist8().mSldoCbloApos());
                wsVgh02801().wsMSldoDpnlApos().set(hv02801Movhist8().movhist8().mSldoDpnlApos());
                wsVgh02801().wsMMovMoeOrigMov().set(hv02801Movhist8().movhist8().mMovMoeOrigMov());
                wsVgh02801().wsXRefMov().set(hv02801Movhist8().movhist8().xRefMov());
                wsVgh02801().wsNDocOpps().set(hv02801Movhist8().movhist8().nDocOpps());
                wsVgh02801().wsTJuro().set(hv02801Movhist8().movhist8().tJuro());
                wsVgh02801().wsAAplOrig().set(hv02801Movhist8().movhist8().aAplOrig());
                wsVgh02801().wsIExisInfAdi().set(hv02801Movhist8().movhist8().iExisInfAdi());
                wsVgh02801().wsXChavAcsInfAdi().set(hv02801Movhist8().movhist8().xChavAcsInfAdi());
                wsVgh02801().wsTsActzUlt().set(hv02801Movhist8().movhist8().tsActzUlt());
                wsVgh02801().wsCUsidActzUlt().set(hv02801Movhist8().movhist8().cUsidActzUlt());
                bghl028a().tabela().lista().get(wsInd).item().set(wsVgh02801());
                bghl028a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02801Movhist8().fetchMghs028a701() ;
                if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02801Movhist8().closeMghs028a718() ;
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
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
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv02801Movhist8().openMghs028a730(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02801Movhist8().fetchMghs028a742() ;
            if (hv02801Movhist8().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02801Movhist8().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02801().wsCPaisIsoaCont().set(hv02801Movhist8().movhist8().cPaisIsoaCont());
                wsVgh02801().wsCBancCont().set(hv02801Movhist8().movhist8().cBancCont());
                wsVgh02801().wsCOeEgcCont().set(hv02801Movhist8().movhist8().cOeEgcCont());
                wsVgh02801().wsNsRdclCont().set(hv02801Movhist8().movhist8().nsRdclCont());
                wsVgh02801().wsVChkdCont().set(hv02801Movhist8().movhist8().vChkdCont());
                wsVgh02801().wsCTipoCont().set(hv02801Movhist8().movhist8().cTipoCont());
                wsVgh02801().wsCMoedIsoScta().set(hv02801Movhist8().movhist8().cMoedIsoScta());
                wsVgh02801().wsNsDeposito().set(hv02801Movhist8().movhist8().nsDeposito());
                wsVgh02801().wsTsMovimento().set(hv02801Movhist8().movhist8().tsMovimento());
                wsVgh02801().wsNsMovimento().set(hv02801Movhist8().movhist8().nsMovimento());
                wsVgh02801().wsZValMov().set(hv02801Movhist8().movhist8().zValMov());
                wsVgh02801().wsZMovLocl().set(hv02801Movhist8().movhist8().zMovLocl());
                wsVgh02801().wsIDbcr().set(hv02801Movhist8().movhist8().iDbcr());
                wsVgh02801().wsMMovimento().set(hv02801Movhist8().movhist8().mMovimento());
                wsVgh02801().wsIEstorno().set(hv02801Movhist8().movhist8().iEstorno());
                wsVgh02801().wsCMoedIsoOriMov().set(hv02801Movhist8().movhist8().cMoedIsoOriMov());
                wsVgh02801().wsMSldoCbloApos().set(hv02801Movhist8().movhist8().mSldoCbloApos());
                wsVgh02801().wsMSldoDpnlApos().set(hv02801Movhist8().movhist8().mSldoDpnlApos());
                wsVgh02801().wsMMovMoeOrigMov().set(hv02801Movhist8().movhist8().mMovMoeOrigMov());
                wsVgh02801().wsXRefMov().set(hv02801Movhist8().movhist8().xRefMov());
                wsVgh02801().wsNDocOpps().set(hv02801Movhist8().movhist8().nDocOpps());
                wsVgh02801().wsTJuro().set(hv02801Movhist8().movhist8().tJuro());
                wsVgh02801().wsAAplOrig().set(hv02801Movhist8().movhist8().aAplOrig());
                wsVgh02801().wsIExisInfAdi().set(hv02801Movhist8().movhist8().iExisInfAdi());
                wsVgh02801().wsXChavAcsInfAdi().set(hv02801Movhist8().movhist8().xChavAcsInfAdi());
                wsVgh02801().wsTsActzUlt().set(hv02801Movhist8().movhist8().tsActzUlt());
                wsVgh02801().wsCUsidActzUlt().set(hv02801Movhist8().movhist8().cUsidActzUlt());
                bghl028a().tabela().lista().get(wsInd).item().set(wsVgh02801());
                bghl028a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02801Movhist8().fetchMghs028a805() ;
                if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02801Movhist8().closeMghs028a822() ;
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500ListaDscMov() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C4
         */
        hv02801Movhist8().openMghs028a834(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsNsMovMax, wsNsMovMin) ;
        if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02801Movhist8().fetchMghs028a846() ;
            if (hv02801Movhist8().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02801Movhist8().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02801().wsCPaisIsoaCont().set(hv02801Movhist8().movhist8().cPaisIsoaCont());
                wsVgh02801().wsCBancCont().set(hv02801Movhist8().movhist8().cBancCont());
                wsVgh02801().wsCOeEgcCont().set(hv02801Movhist8().movhist8().cOeEgcCont());
                wsVgh02801().wsNsRdclCont().set(hv02801Movhist8().movhist8().nsRdclCont());
                wsVgh02801().wsVChkdCont().set(hv02801Movhist8().movhist8().vChkdCont());
                wsVgh02801().wsCTipoCont().set(hv02801Movhist8().movhist8().cTipoCont());
                wsVgh02801().wsCMoedIsoScta().set(hv02801Movhist8().movhist8().cMoedIsoScta());
                wsVgh02801().wsNsDeposito().set(hv02801Movhist8().movhist8().nsDeposito());
                wsVgh02801().wsTsMovimento().set(hv02801Movhist8().movhist8().tsMovimento());
                wsVgh02801().wsNsMovimento().set(hv02801Movhist8().movhist8().nsMovimento());
                wsVgh02801().wsZValMov().set(hv02801Movhist8().movhist8().zValMov());
                wsVgh02801().wsZMovLocl().set(hv02801Movhist8().movhist8().zMovLocl());
                wsVgh02801().wsIDbcr().set(hv02801Movhist8().movhist8().iDbcr());
                wsVgh02801().wsMMovimento().set(hv02801Movhist8().movhist8().mMovimento());
                wsVgh02801().wsIEstorno().set(hv02801Movhist8().movhist8().iEstorno());
                wsVgh02801().wsCMoedIsoOriMov().set(hv02801Movhist8().movhist8().cMoedIsoOriMov());
                wsVgh02801().wsMSldoCbloApos().set(hv02801Movhist8().movhist8().mSldoCbloApos());
                wsVgh02801().wsMSldoDpnlApos().set(hv02801Movhist8().movhist8().mSldoDpnlApos());
                wsVgh02801().wsMMovMoeOrigMov().set(hv02801Movhist8().movhist8().mMovMoeOrigMov());
                wsVgh02801().wsXRefMov().set(hv02801Movhist8().movhist8().xRefMov());
                wsVgh02801().wsNDocOpps().set(hv02801Movhist8().movhist8().nDocOpps());
                wsVgh02801().wsTJuro().set(hv02801Movhist8().movhist8().tJuro());
                wsVgh02801().wsAAplOrig().set(hv02801Movhist8().movhist8().aAplOrig());
                wsVgh02801().wsIExisInfAdi().set(hv02801Movhist8().movhist8().iExisInfAdi());
                wsVgh02801().wsXChavAcsInfAdi().set(hv02801Movhist8().movhist8().xChavAcsInfAdi());
                wsVgh02801().wsTsActzUlt().set(hv02801Movhist8().movhist8().tsActzUlt());
                wsVgh02801().wsCUsidActzUlt().set(hv02801Movhist8().movhist8().cUsidActzUlt());
                bghl028a().tabela().lista().get(wsInd).item().set(wsVgh02801());
                bghl028a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02801Movhist8().fetchMghs028a909() ;
                if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02801Movhist8().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02801Movhist8().closeMghs028a926() ;
            if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl028a().cRetorno().set(progStatus);
        bghl028a().cSqlcode().set(getPersistenceCode());
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
    
    
    /**
     * 
     * PRC19 - INI
     * 
     * @version 2.0
     * 
     */
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
    
    public interface WsVgh02801 extends IDataStruct {
        
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
