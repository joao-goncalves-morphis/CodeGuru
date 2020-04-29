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
import cgd.gh.structures.link.Bghl024a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00024_MOVHIST4
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * DOS MOVIMENTOS DE HA 4 ANOS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS024A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs024a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl024a
     */
    @Data
    public abstract Bghl024a bghl024a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02401Movhist4
     */
    @Data
    protected abstract Vwsdghps02401Movhist4 hv02401Movhist4() ;
    
    
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
     * @return instancia da classe local WsVgh02401
     */
    @Data
    protected abstract WsVgh02401 wsVgh02401() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl024a().cRetorno().initialize() ;
        bghl024a().cSqlcode().initialize() ;
        if (bghl024a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl024a().argumento().cBancCont().isEqual(0) || 
            bghl024a().argumento().cOeEgcCont().isEqual(0) || 
            bghl024a().argumento().nsRdclCont().isEqual(0) || 
            bghl024a().argumento().cMoedIsoScta().isEmpty() || 
            bghl024a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl024a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl024a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl024a().criterioConsulta().ascendente().isTrue() && !bghl024a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (!bghl024a().criterioSeleccao().tsMovMax().isEmpty()) {
                    criterioData.setTrue() ;
                    wsTsInicio.set(bghl024a().argumento().tsMovimento());
                    wsTsFim.set(bghl024a().criterioSeleccao().tsMovMax());
                } else {
                    criterioMovimento.setTrue() ;
                    wsNsMovMin.set(bghl024a().argumento().nsMovimento());
                    wsNsMovMax.set(bghl024a().criterioSeleccao().nsMovMax());
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
        if (bghl024a().criterioConsulta().ascendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMov() ;
            }
        } else if (bghl024a().criterioConsulta().descendente().isTrue()) {
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
        hv02401Movhist4().movhist4().initialize() ;
        hv02401Movhist4().movhist4().cPaisIsoaCont().set(bghl024a().argumento().cPaisIsoaCont());
        hv02401Movhist4().movhist4().cBancCont().set(bghl024a().argumento().cBancCont());
        hv02401Movhist4().movhist4().cOeEgcCont().set(bghl024a().argumento().cOeEgcCont());
        hv02401Movhist4().movhist4().nsRdclCont().set(bghl024a().argumento().nsRdclCont());
        hv02401Movhist4().movhist4().vChkdCont().set(bghl024a().argumento().vChkdCont());
        hv02401Movhist4().movhist4().cTipoCont().set(bghl024a().argumento().cTipoCont());
        hv02401Movhist4().movhist4().cMoedIsoScta().set(bghl024a().argumento().cMoedIsoScta());
        hv02401Movhist4().movhist4().nsDeposito().set(bghl024a().argumento().nsDeposito());
        hv02401Movhist4().movhist4().nsMovimento().set(bghl024a().argumento().nsMovimento());
        if (bghl024a().criterioConsulta().descendente().isTrue()) {
            if (bghl024a().argumento().nsMovimento().isEqual(0)) {
                hv02401Movhist4().movhist4().nsMovimento().set(9);
            }
        }
        if (criterioData.isTrue()) {
            wsTsInicio.set(bghl024a().argumento().tsMovimento());
            wsTsFim.set(bghl024a().criterioSeleccao().tsMovMax());
        } else {
            wsNsMovMin.set(bghl024a().argumento().nsMovimento());
            wsNsMovMax.set(bghl024a().criterioSeleccao().nsMovMax());
        }
        /**
         * PRC19 - INI
         * SE O MONTANTE MAXIMO DO MOVIMENTO FOR ZERO, FORÇA VALOR MAX
         */
        wsMMovMin.set(bghl024a().criterioMontante().mMovMin());
        if (bghl024a().criterioMontante().mMovMax().isEqual(0)) {
            wsMMovMax.set(999999999999999.99);
        } else {
            wsMMovMax.set(bghl024a().criterioMontante().mMovMax());
        }
        if (bghl024a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl024a().criterioDbcr().debito().isTrue()) {
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
        hv02401Movhist4().openMghs024a529(wsTsFim, wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio) ;
        if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02401Movhist4().fetchMghs024a541() ;
            if (hv02401Movhist4().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02401Movhist4().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02401().wsCPaisIsoaCont().set(hv02401Movhist4().movhist4().cPaisIsoaCont());
                wsVgh02401().wsCBancCont().set(hv02401Movhist4().movhist4().cBancCont());
                wsVgh02401().wsCOeEgcCont().set(hv02401Movhist4().movhist4().cOeEgcCont());
                wsVgh02401().wsNsRdclCont().set(hv02401Movhist4().movhist4().nsRdclCont());
                wsVgh02401().wsVChkdCont().set(hv02401Movhist4().movhist4().vChkdCont());
                wsVgh02401().wsCTipoCont().set(hv02401Movhist4().movhist4().cTipoCont());
                wsVgh02401().wsCMoedIsoScta().set(hv02401Movhist4().movhist4().cMoedIsoScta());
                wsVgh02401().wsNsDeposito().set(hv02401Movhist4().movhist4().nsDeposito());
                wsVgh02401().wsTsMovimento().set(hv02401Movhist4().movhist4().tsMovimento());
                wsVgh02401().wsNsMovimento().set(hv02401Movhist4().movhist4().nsMovimento());
                wsVgh02401().wsZValMov().set(hv02401Movhist4().movhist4().zValMov());
                wsVgh02401().wsZMovLocl().set(hv02401Movhist4().movhist4().zMovLocl());
                wsVgh02401().wsIDbcr().set(hv02401Movhist4().movhist4().iDbcr());
                wsVgh02401().wsMMovimento().set(hv02401Movhist4().movhist4().mMovimento());
                wsVgh02401().wsIEstorno().set(hv02401Movhist4().movhist4().iEstorno());
                wsVgh02401().wsCMoedIsoOriMov().set(hv02401Movhist4().movhist4().cMoedIsoOriMov());
                wsVgh02401().wsMSldoCbloApos().set(hv02401Movhist4().movhist4().mSldoCbloApos());
                wsVgh02401().wsMSldoDpnlApos().set(hv02401Movhist4().movhist4().mSldoDpnlApos());
                wsVgh02401().wsMMovMoeOrigMov().set(hv02401Movhist4().movhist4().mMovMoeOrigMov());
                wsVgh02401().wsXRefMov().set(hv02401Movhist4().movhist4().xRefMov());
                wsVgh02401().wsNDocOpps().set(hv02401Movhist4().movhist4().nDocOpps());
                wsVgh02401().wsTJuro().set(hv02401Movhist4().movhist4().tJuro());
                wsVgh02401().wsAAplOrig().set(hv02401Movhist4().movhist4().aAplOrig());
                wsVgh02401().wsIExisInfAdi().set(hv02401Movhist4().movhist4().iExisInfAdi());
                wsVgh02401().wsXChavAcsInfAdi().set(hv02401Movhist4().movhist4().xChavAcsInfAdi());
                wsVgh02401().wsTsActzUlt().set(hv02401Movhist4().movhist4().tsActzUlt());
                wsVgh02401().wsCUsidActzUlt().set(hv02401Movhist4().movhist4().cUsidActzUlt());
                bghl024a().tabela().lista().get(wsInd).item().set(wsVgh02401());
                bghl024a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02401Movhist4().fetchMghs024a604() ;
                if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02401Movhist4().closeMghs024a621() ;
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02401Movhist4().openMghs024a633(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsFim, wsTsInicio) ;
        if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02401Movhist4().fetchMghs024a645() ;
            if (hv02401Movhist4().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02401Movhist4().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02401().wsCPaisIsoaCont().set(hv02401Movhist4().movhist4().cPaisIsoaCont());
                wsVgh02401().wsCBancCont().set(hv02401Movhist4().movhist4().cBancCont());
                wsVgh02401().wsCOeEgcCont().set(hv02401Movhist4().movhist4().cOeEgcCont());
                wsVgh02401().wsNsRdclCont().set(hv02401Movhist4().movhist4().nsRdclCont());
                wsVgh02401().wsVChkdCont().set(hv02401Movhist4().movhist4().vChkdCont());
                wsVgh02401().wsCTipoCont().set(hv02401Movhist4().movhist4().cTipoCont());
                wsVgh02401().wsCMoedIsoScta().set(hv02401Movhist4().movhist4().cMoedIsoScta());
                wsVgh02401().wsNsDeposito().set(hv02401Movhist4().movhist4().nsDeposito());
                wsVgh02401().wsTsMovimento().set(hv02401Movhist4().movhist4().tsMovimento());
                wsVgh02401().wsNsMovimento().set(hv02401Movhist4().movhist4().nsMovimento());
                wsVgh02401().wsZValMov().set(hv02401Movhist4().movhist4().zValMov());
                wsVgh02401().wsZMovLocl().set(hv02401Movhist4().movhist4().zMovLocl());
                wsVgh02401().wsIDbcr().set(hv02401Movhist4().movhist4().iDbcr());
                wsVgh02401().wsMMovimento().set(hv02401Movhist4().movhist4().mMovimento());
                wsVgh02401().wsIEstorno().set(hv02401Movhist4().movhist4().iEstorno());
                wsVgh02401().wsCMoedIsoOriMov().set(hv02401Movhist4().movhist4().cMoedIsoOriMov());
                wsVgh02401().wsMSldoCbloApos().set(hv02401Movhist4().movhist4().mSldoCbloApos());
                wsVgh02401().wsMSldoDpnlApos().set(hv02401Movhist4().movhist4().mSldoDpnlApos());
                wsVgh02401().wsMMovMoeOrigMov().set(hv02401Movhist4().movhist4().mMovMoeOrigMov());
                wsVgh02401().wsXRefMov().set(hv02401Movhist4().movhist4().xRefMov());
                wsVgh02401().wsNDocOpps().set(hv02401Movhist4().movhist4().nDocOpps());
                wsVgh02401().wsTJuro().set(hv02401Movhist4().movhist4().tJuro());
                wsVgh02401().wsAAplOrig().set(hv02401Movhist4().movhist4().aAplOrig());
                wsVgh02401().wsIExisInfAdi().set(hv02401Movhist4().movhist4().iExisInfAdi());
                wsVgh02401().wsXChavAcsInfAdi().set(hv02401Movhist4().movhist4().xChavAcsInfAdi());
                wsVgh02401().wsTsActzUlt().set(hv02401Movhist4().movhist4().tsActzUlt());
                wsVgh02401().wsCUsidActzUlt().set(hv02401Movhist4().movhist4().cUsidActzUlt());
                bghl024a().tabela().lista().get(wsInd).item().set(wsVgh02401());
                bghl024a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02401Movhist4().fetchMghs024a708() ;
                if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02401Movhist4().closeMghs024a725() ;
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02401Movhist4().openMghs024a737(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsFim, wsTsInicio) ;
        if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02401Movhist4().fetchMghs024a749() ;
            if (hv02401Movhist4().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02401Movhist4().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02401().wsCPaisIsoaCont().set(hv02401Movhist4().movhist4().cPaisIsoaCont());
                wsVgh02401().wsCBancCont().set(hv02401Movhist4().movhist4().cBancCont());
                wsVgh02401().wsCOeEgcCont().set(hv02401Movhist4().movhist4().cOeEgcCont());
                wsVgh02401().wsNsRdclCont().set(hv02401Movhist4().movhist4().nsRdclCont());
                wsVgh02401().wsVChkdCont().set(hv02401Movhist4().movhist4().vChkdCont());
                wsVgh02401().wsCTipoCont().set(hv02401Movhist4().movhist4().cTipoCont());
                wsVgh02401().wsCMoedIsoScta().set(hv02401Movhist4().movhist4().cMoedIsoScta());
                wsVgh02401().wsNsDeposito().set(hv02401Movhist4().movhist4().nsDeposito());
                wsVgh02401().wsTsMovimento().set(hv02401Movhist4().movhist4().tsMovimento());
                wsVgh02401().wsNsMovimento().set(hv02401Movhist4().movhist4().nsMovimento());
                wsVgh02401().wsZValMov().set(hv02401Movhist4().movhist4().zValMov());
                wsVgh02401().wsZMovLocl().set(hv02401Movhist4().movhist4().zMovLocl());
                wsVgh02401().wsIDbcr().set(hv02401Movhist4().movhist4().iDbcr());
                wsVgh02401().wsMMovimento().set(hv02401Movhist4().movhist4().mMovimento());
                wsVgh02401().wsIEstorno().set(hv02401Movhist4().movhist4().iEstorno());
                wsVgh02401().wsCMoedIsoOriMov().set(hv02401Movhist4().movhist4().cMoedIsoOriMov());
                wsVgh02401().wsMSldoCbloApos().set(hv02401Movhist4().movhist4().mSldoCbloApos());
                wsVgh02401().wsMSldoDpnlApos().set(hv02401Movhist4().movhist4().mSldoDpnlApos());
                wsVgh02401().wsMMovMoeOrigMov().set(hv02401Movhist4().movhist4().mMovMoeOrigMov());
                wsVgh02401().wsXRefMov().set(hv02401Movhist4().movhist4().xRefMov());
                wsVgh02401().wsNDocOpps().set(hv02401Movhist4().movhist4().nDocOpps());
                wsVgh02401().wsTJuro().set(hv02401Movhist4().movhist4().tJuro());
                wsVgh02401().wsAAplOrig().set(hv02401Movhist4().movhist4().aAplOrig());
                wsVgh02401().wsIExisInfAdi().set(hv02401Movhist4().movhist4().iExisInfAdi());
                wsVgh02401().wsXChavAcsInfAdi().set(hv02401Movhist4().movhist4().xChavAcsInfAdi());
                wsVgh02401().wsTsActzUlt().set(hv02401Movhist4().movhist4().tsActzUlt());
                wsVgh02401().wsCUsidActzUlt().set(hv02401Movhist4().movhist4().cUsidActzUlt());
                bghl024a().tabela().lista().get(wsInd).item().set(wsVgh02401());
                bghl024a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02401Movhist4().fetchMghs024a812() ;
                if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02401Movhist4().closeMghs024a829() ;
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02401Movhist4().openMghs024a841(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsNsMovMax, wsNsMovMin) ;
        if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02401Movhist4().fetchMghs024a853() ;
            if (hv02401Movhist4().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02401Movhist4().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02401().wsCPaisIsoaCont().set(hv02401Movhist4().movhist4().cPaisIsoaCont());
                wsVgh02401().wsCBancCont().set(hv02401Movhist4().movhist4().cBancCont());
                wsVgh02401().wsCOeEgcCont().set(hv02401Movhist4().movhist4().cOeEgcCont());
                wsVgh02401().wsNsRdclCont().set(hv02401Movhist4().movhist4().nsRdclCont());
                wsVgh02401().wsVChkdCont().set(hv02401Movhist4().movhist4().vChkdCont());
                wsVgh02401().wsCTipoCont().set(hv02401Movhist4().movhist4().cTipoCont());
                wsVgh02401().wsCMoedIsoScta().set(hv02401Movhist4().movhist4().cMoedIsoScta());
                wsVgh02401().wsNsDeposito().set(hv02401Movhist4().movhist4().nsDeposito());
                wsVgh02401().wsTsMovimento().set(hv02401Movhist4().movhist4().tsMovimento());
                wsVgh02401().wsNsMovimento().set(hv02401Movhist4().movhist4().nsMovimento());
                wsVgh02401().wsZValMov().set(hv02401Movhist4().movhist4().zValMov());
                wsVgh02401().wsZMovLocl().set(hv02401Movhist4().movhist4().zMovLocl());
                wsVgh02401().wsIDbcr().set(hv02401Movhist4().movhist4().iDbcr());
                wsVgh02401().wsMMovimento().set(hv02401Movhist4().movhist4().mMovimento());
                wsVgh02401().wsIEstorno().set(hv02401Movhist4().movhist4().iEstorno());
                wsVgh02401().wsCMoedIsoOriMov().set(hv02401Movhist4().movhist4().cMoedIsoOriMov());
                wsVgh02401().wsMSldoCbloApos().set(hv02401Movhist4().movhist4().mSldoCbloApos());
                wsVgh02401().wsMSldoDpnlApos().set(hv02401Movhist4().movhist4().mSldoDpnlApos());
                wsVgh02401().wsMMovMoeOrigMov().set(hv02401Movhist4().movhist4().mMovMoeOrigMov());
                wsVgh02401().wsXRefMov().set(hv02401Movhist4().movhist4().xRefMov());
                wsVgh02401().wsNDocOpps().set(hv02401Movhist4().movhist4().nDocOpps());
                wsVgh02401().wsTJuro().set(hv02401Movhist4().movhist4().tJuro());
                wsVgh02401().wsAAplOrig().set(hv02401Movhist4().movhist4().aAplOrig());
                wsVgh02401().wsIExisInfAdi().set(hv02401Movhist4().movhist4().iExisInfAdi());
                wsVgh02401().wsXChavAcsInfAdi().set(hv02401Movhist4().movhist4().xChavAcsInfAdi());
                wsVgh02401().wsTsActzUlt().set(hv02401Movhist4().movhist4().tsActzUlt());
                wsVgh02401().wsCUsidActzUlt().set(hv02401Movhist4().movhist4().cUsidActzUlt());
                bghl024a().tabela().lista().get(wsInd).item().set(wsVgh02401());
                bghl024a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02401Movhist4().fetchMghs024a916() ;
                if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02401Movhist4().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02401Movhist4().closeMghs024a933() ;
            if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl024a().cRetorno().set(progStatus);
        bghl024a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh02401 extends IDataStruct {
        
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
