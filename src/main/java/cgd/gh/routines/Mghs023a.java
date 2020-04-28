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
import cgd.gh.structures.link.Bghl023a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00023_MOVHIST3
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * DOS MOVIMENTOS COM 3 ANOS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS023A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs023a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl023a
     */
    @Data
    public abstract Bghl023a bghl023a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02301Movhist3
     */
    @Data
    protected abstract Vwsdghps02301Movhist3 hv02301Movhist3() ;
    
    
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
     * @return instancia da classe local WsVgh02301
     */
    @Data
    protected abstract WsVgh02301 wsVgh02301() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl023a().cRetorno().initialize() ;
        bghl023a().cSqlcode().initialize() ;
        if (bghl023a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl023a().argumento().cBancCont().isEqual(0) || 
            bghl023a().argumento().cOeEgcCont().isEqual(0) || 
            bghl023a().argumento().nsRdclCont().isEqual(0) || 
            bghl023a().argumento().cMoedIsoScta().isEmpty() || 
            bghl023a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl023a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl023a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl023a().criterioConsulta().ascendente().isTrue() && !bghl023a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (!bghl023a().criterioSeleccao().tsMovMax().isEmpty()) {
                    criterioData.setTrue() ;
                    wsTsInicio.set(bghl023a().argumento().tsMovimento());
                    wsTsFim.set(bghl023a().criterioSeleccao().tsMovMax());
                } else {
                    criterioMovimento.setTrue() ;
                    wsNsMovMin.set(bghl023a().argumento().nsMovimento());
                    wsNsMovMax.set(bghl023a().criterioSeleccao().nsMovMax());
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
        if (bghl023a().criterioConsulta().ascendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMov() ;
            }
        } else if (bghl023a().criterioConsulta().descendente().isTrue()) {
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
        hv02301Movhist3().movhist3().initialize() ;
        hv02301Movhist3().movhist3().cPaisIsoaCont().set(bghl023a().argumento().cPaisIsoaCont());
        hv02301Movhist3().movhist3().cBancCont().set(bghl023a().argumento().cBancCont());
        hv02301Movhist3().movhist3().cOeEgcCont().set(bghl023a().argumento().cOeEgcCont());
        hv02301Movhist3().movhist3().nsRdclCont().set(bghl023a().argumento().nsRdclCont());
        hv02301Movhist3().movhist3().vChkdCont().set(bghl023a().argumento().vChkdCont());
        hv02301Movhist3().movhist3().cTipoCont().set(bghl023a().argumento().cTipoCont());
        hv02301Movhist3().movhist3().cMoedIsoScta().set(bghl023a().argumento().cMoedIsoScta());
        hv02301Movhist3().movhist3().nsDeposito().set(bghl023a().argumento().nsDeposito());
        hv02301Movhist3().movhist3().nsMovimento().set(bghl023a().argumento().nsMovimento());
        if (bghl023a().criterioConsulta().descendente().isTrue()) {
            if (bghl023a().argumento().nsMovimento().isEqual(0)) {
                hv02301Movhist3().movhist3().nsMovimento().set(9);
            }
        }
        if (criterioData.isTrue()) {
            wsTsInicio.set(bghl023a().argumento().tsMovimento());
            wsTsFim.set(bghl023a().criterioSeleccao().tsMovMax());
        } else {
            wsNsMovMin.set(bghl023a().argumento().nsMovimento());
            wsNsMovMax.set(bghl023a().criterioSeleccao().nsMovMax());
        }
        /**
         * PRC19 - INI
         * SE O MONTANTE MAXIMO DO MOVIMENTO FOR ZERO, FORÇA VALOR MAX
         */
        wsMMovMin.set(bghl023a().criterioMontante().mMovMin());
        if (bghl023a().criterioMontante().mMovMax().isEqual(0)) {
            wsMMovMax.set(999999999999999.99);
        } else {
            wsMMovMax.set(bghl023a().criterioMontante().mMovMax());
        }
        if (bghl023a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl023a().criterioDbcr().debito().isTrue()) {
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
        hv02301Movhist3().openMghs023a522(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02301Movhist3().fetchMghs023a534() ;
            if (hv02301Movhist3().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02301Movhist3().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02301().wsCPaisIsoaCont().set(hv02301Movhist3().movhist3().cPaisIsoaCont());
                wsVgh02301().wsCBancCont().set(hv02301Movhist3().movhist3().cBancCont());
                wsVgh02301().wsCOeEgcCont().set(hv02301Movhist3().movhist3().cOeEgcCont());
                wsVgh02301().wsNsRdclCont().set(hv02301Movhist3().movhist3().nsRdclCont());
                wsVgh02301().wsVChkdCont().set(hv02301Movhist3().movhist3().vChkdCont());
                wsVgh02301().wsCTipoCont().set(hv02301Movhist3().movhist3().cTipoCont());
                wsVgh02301().wsCMoedIsoScta().set(hv02301Movhist3().movhist3().cMoedIsoScta());
                wsVgh02301().wsNsDeposito().set(hv02301Movhist3().movhist3().nsDeposito());
                wsVgh02301().wsTsMovimento().set(hv02301Movhist3().movhist3().tsMovimento());
                wsVgh02301().wsNsMovimento().set(hv02301Movhist3().movhist3().nsMovimento());
                wsVgh02301().wsZValMov().set(hv02301Movhist3().movhist3().zValMov());
                wsVgh02301().wsZMovLocl().set(hv02301Movhist3().movhist3().zMovLocl());
                wsVgh02301().wsIDbcr().set(hv02301Movhist3().movhist3().iDbcr());
                wsVgh02301().wsMMovimento().set(hv02301Movhist3().movhist3().mMovimento());
                wsVgh02301().wsIEstorno().set(hv02301Movhist3().movhist3().iEstorno());
                wsVgh02301().wsCMoedIsoOriMov().set(hv02301Movhist3().movhist3().cMoedIsoOriMov());
                wsVgh02301().wsMSldoCbloApos().set(hv02301Movhist3().movhist3().mSldoCbloApos());
                wsVgh02301().wsMSldoDpnlApos().set(hv02301Movhist3().movhist3().mSldoDpnlApos());
                wsVgh02301().wsMMovMoeOrigMov().set(hv02301Movhist3().movhist3().mMovMoeOrigMov());
                wsVgh02301().wsXRefMov().set(hv02301Movhist3().movhist3().xRefMov());
                wsVgh02301().wsNDocOpps().set(hv02301Movhist3().movhist3().nDocOpps());
                wsVgh02301().wsTJuro().set(hv02301Movhist3().movhist3().tJuro());
                wsVgh02301().wsAAplOrig().set(hv02301Movhist3().movhist3().aAplOrig());
                wsVgh02301().wsIExisInfAdi().set(hv02301Movhist3().movhist3().iExisInfAdi());
                wsVgh02301().wsXChavAcsInfAdi().set(hv02301Movhist3().movhist3().xChavAcsInfAdi());
                wsVgh02301().wsTsActzUlt().set(hv02301Movhist3().movhist3().tsActzUlt());
                wsVgh02301().wsCUsidActzUlt().set(hv02301Movhist3().movhist3().cUsidActzUlt());
                bghl023a().tabela().lista().get(wsInd).item().set(wsVgh02301());
                bghl023a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02301Movhist3().fetchMghs023a597() ;
                if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02301Movhist3().closeMghs023a614() ;
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02301Movhist3().openMghs023a626(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02301Movhist3().fetchMghs023a638() ;
            if (hv02301Movhist3().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02301Movhist3().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02301().wsCPaisIsoaCont().set(hv02301Movhist3().movhist3().cPaisIsoaCont());
                wsVgh02301().wsCBancCont().set(hv02301Movhist3().movhist3().cBancCont());
                wsVgh02301().wsCOeEgcCont().set(hv02301Movhist3().movhist3().cOeEgcCont());
                wsVgh02301().wsNsRdclCont().set(hv02301Movhist3().movhist3().nsRdclCont());
                wsVgh02301().wsVChkdCont().set(hv02301Movhist3().movhist3().vChkdCont());
                wsVgh02301().wsCTipoCont().set(hv02301Movhist3().movhist3().cTipoCont());
                wsVgh02301().wsCMoedIsoScta().set(hv02301Movhist3().movhist3().cMoedIsoScta());
                wsVgh02301().wsNsDeposito().set(hv02301Movhist3().movhist3().nsDeposito());
                wsVgh02301().wsTsMovimento().set(hv02301Movhist3().movhist3().tsMovimento());
                wsVgh02301().wsNsMovimento().set(hv02301Movhist3().movhist3().nsMovimento());
                wsVgh02301().wsZValMov().set(hv02301Movhist3().movhist3().zValMov());
                wsVgh02301().wsZMovLocl().set(hv02301Movhist3().movhist3().zMovLocl());
                wsVgh02301().wsIDbcr().set(hv02301Movhist3().movhist3().iDbcr());
                wsVgh02301().wsMMovimento().set(hv02301Movhist3().movhist3().mMovimento());
                wsVgh02301().wsIEstorno().set(hv02301Movhist3().movhist3().iEstorno());
                wsVgh02301().wsCMoedIsoOriMov().set(hv02301Movhist3().movhist3().cMoedIsoOriMov());
                wsVgh02301().wsMSldoCbloApos().set(hv02301Movhist3().movhist3().mSldoCbloApos());
                wsVgh02301().wsMSldoDpnlApos().set(hv02301Movhist3().movhist3().mSldoDpnlApos());
                wsVgh02301().wsMMovMoeOrigMov().set(hv02301Movhist3().movhist3().mMovMoeOrigMov());
                wsVgh02301().wsXRefMov().set(hv02301Movhist3().movhist3().xRefMov());
                wsVgh02301().wsNDocOpps().set(hv02301Movhist3().movhist3().nDocOpps());
                wsVgh02301().wsTJuro().set(hv02301Movhist3().movhist3().tJuro());
                wsVgh02301().wsAAplOrig().set(hv02301Movhist3().movhist3().aAplOrig());
                wsVgh02301().wsIExisInfAdi().set(hv02301Movhist3().movhist3().iExisInfAdi());
                wsVgh02301().wsXChavAcsInfAdi().set(hv02301Movhist3().movhist3().xChavAcsInfAdi());
                wsVgh02301().wsTsActzUlt().set(hv02301Movhist3().movhist3().tsActzUlt());
                wsVgh02301().wsCUsidActzUlt().set(hv02301Movhist3().movhist3().cUsidActzUlt());
                bghl023a().tabela().lista().get(wsInd).item().set(wsVgh02301());
                bghl023a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02301Movhist3().fetchMghs023a701() ;
                if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02301Movhist3().closeMghs023a718() ;
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02301Movhist3().openMghs023a730(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02301Movhist3().fetchMghs023a742() ;
            if (hv02301Movhist3().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02301Movhist3().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02301().wsCPaisIsoaCont().set(hv02301Movhist3().movhist3().cPaisIsoaCont());
                wsVgh02301().wsCBancCont().set(hv02301Movhist3().movhist3().cBancCont());
                wsVgh02301().wsCOeEgcCont().set(hv02301Movhist3().movhist3().cOeEgcCont());
                wsVgh02301().wsNsRdclCont().set(hv02301Movhist3().movhist3().nsRdclCont());
                wsVgh02301().wsVChkdCont().set(hv02301Movhist3().movhist3().vChkdCont());
                wsVgh02301().wsCTipoCont().set(hv02301Movhist3().movhist3().cTipoCont());
                wsVgh02301().wsCMoedIsoScta().set(hv02301Movhist3().movhist3().cMoedIsoScta());
                wsVgh02301().wsNsDeposito().set(hv02301Movhist3().movhist3().nsDeposito());
                wsVgh02301().wsTsMovimento().set(hv02301Movhist3().movhist3().tsMovimento());
                wsVgh02301().wsNsMovimento().set(hv02301Movhist3().movhist3().nsMovimento());
                wsVgh02301().wsZValMov().set(hv02301Movhist3().movhist3().zValMov());
                wsVgh02301().wsZMovLocl().set(hv02301Movhist3().movhist3().zMovLocl());
                wsVgh02301().wsIDbcr().set(hv02301Movhist3().movhist3().iDbcr());
                wsVgh02301().wsMMovimento().set(hv02301Movhist3().movhist3().mMovimento());
                wsVgh02301().wsIEstorno().set(hv02301Movhist3().movhist3().iEstorno());
                wsVgh02301().wsCMoedIsoOriMov().set(hv02301Movhist3().movhist3().cMoedIsoOriMov());
                wsVgh02301().wsMSldoCbloApos().set(hv02301Movhist3().movhist3().mSldoCbloApos());
                wsVgh02301().wsMSldoDpnlApos().set(hv02301Movhist3().movhist3().mSldoDpnlApos());
                wsVgh02301().wsMMovMoeOrigMov().set(hv02301Movhist3().movhist3().mMovMoeOrigMov());
                wsVgh02301().wsXRefMov().set(hv02301Movhist3().movhist3().xRefMov());
                wsVgh02301().wsNDocOpps().set(hv02301Movhist3().movhist3().nDocOpps());
                wsVgh02301().wsTJuro().set(hv02301Movhist3().movhist3().tJuro());
                wsVgh02301().wsAAplOrig().set(hv02301Movhist3().movhist3().aAplOrig());
                wsVgh02301().wsIExisInfAdi().set(hv02301Movhist3().movhist3().iExisInfAdi());
                wsVgh02301().wsXChavAcsInfAdi().set(hv02301Movhist3().movhist3().xChavAcsInfAdi());
                wsVgh02301().wsTsActzUlt().set(hv02301Movhist3().movhist3().tsActzUlt());
                wsVgh02301().wsCUsidActzUlt().set(hv02301Movhist3().movhist3().cUsidActzUlt());
                bghl023a().tabela().lista().get(wsInd).item().set(wsVgh02301());
                bghl023a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02301Movhist3().fetchMghs023a805() ;
                if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02301Movhist3().closeMghs023a822() ;
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02301Movhist3().openMghs023a834(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsNsMovMax, wsNsMovMin) ;
        if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02301Movhist3().fetchMghs023a846() ;
            if (hv02301Movhist3().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02301Movhist3().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02301().wsCPaisIsoaCont().set(hv02301Movhist3().movhist3().cPaisIsoaCont());
                wsVgh02301().wsCBancCont().set(hv02301Movhist3().movhist3().cBancCont());
                wsVgh02301().wsCOeEgcCont().set(hv02301Movhist3().movhist3().cOeEgcCont());
                wsVgh02301().wsNsRdclCont().set(hv02301Movhist3().movhist3().nsRdclCont());
                wsVgh02301().wsVChkdCont().set(hv02301Movhist3().movhist3().vChkdCont());
                wsVgh02301().wsCTipoCont().set(hv02301Movhist3().movhist3().cTipoCont());
                wsVgh02301().wsCMoedIsoScta().set(hv02301Movhist3().movhist3().cMoedIsoScta());
                wsVgh02301().wsNsDeposito().set(hv02301Movhist3().movhist3().nsDeposito());
                wsVgh02301().wsTsMovimento().set(hv02301Movhist3().movhist3().tsMovimento());
                wsVgh02301().wsNsMovimento().set(hv02301Movhist3().movhist3().nsMovimento());
                wsVgh02301().wsZValMov().set(hv02301Movhist3().movhist3().zValMov());
                wsVgh02301().wsZMovLocl().set(hv02301Movhist3().movhist3().zMovLocl());
                wsVgh02301().wsIDbcr().set(hv02301Movhist3().movhist3().iDbcr());
                wsVgh02301().wsMMovimento().set(hv02301Movhist3().movhist3().mMovimento());
                wsVgh02301().wsIEstorno().set(hv02301Movhist3().movhist3().iEstorno());
                wsVgh02301().wsCMoedIsoOriMov().set(hv02301Movhist3().movhist3().cMoedIsoOriMov());
                wsVgh02301().wsMSldoCbloApos().set(hv02301Movhist3().movhist3().mSldoCbloApos());
                wsVgh02301().wsMSldoDpnlApos().set(hv02301Movhist3().movhist3().mSldoDpnlApos());
                wsVgh02301().wsMMovMoeOrigMov().set(hv02301Movhist3().movhist3().mMovMoeOrigMov());
                wsVgh02301().wsXRefMov().set(hv02301Movhist3().movhist3().xRefMov());
                wsVgh02301().wsNDocOpps().set(hv02301Movhist3().movhist3().nDocOpps());
                wsVgh02301().wsTJuro().set(hv02301Movhist3().movhist3().tJuro());
                wsVgh02301().wsAAplOrig().set(hv02301Movhist3().movhist3().aAplOrig());
                wsVgh02301().wsIExisInfAdi().set(hv02301Movhist3().movhist3().iExisInfAdi());
                wsVgh02301().wsXChavAcsInfAdi().set(hv02301Movhist3().movhist3().xChavAcsInfAdi());
                wsVgh02301().wsTsActzUlt().set(hv02301Movhist3().movhist3().tsActzUlt());
                wsVgh02301().wsCUsidActzUlt().set(hv02301Movhist3().movhist3().cUsidActzUlt());
                bghl023a().tabela().lista().get(wsInd).item().set(wsVgh02301());
                bghl023a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02301Movhist3().fetchMghs023a909() ;
                if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02301Movhist3().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02301Movhist3().closeMghs023a926() ;
            if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl023a().cRetorno().set(progStatus);
        bghl023a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh02301 extends IDataStruct {
        
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
