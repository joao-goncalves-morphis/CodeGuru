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
import cgd.gh.structures.link.Bghl025a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00025_MOVHIST5
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * DOS MOVIMENTOS DE HA 5 ANOS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS025A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs025a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl025a
     */
    @Data
    public abstract Bghl025a bghl025a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02501Movhist5
     */
    @Data
    protected abstract Vwsdghps02501Movhist5 hv02501Movhist5() ;
    
    
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
     * @return instancia da classe local WsVgh02501
     */
    @Data
    protected abstract WsVgh02501 wsVgh02501() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl025a().cRetorno().initialize() ;
        bghl025a().cSqlcode().initialize() ;
        if (bghl025a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl025a().argumento().cBancCont().isEqual(0) || 
            bghl025a().argumento().cOeEgcCont().isEqual(0) || 
            bghl025a().argumento().nsRdclCont().isEqual(0) || 
            bghl025a().argumento().cMoedIsoScta().isEmpty() || 
            bghl025a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl025a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl025a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl025a().criterioConsulta().ascendente().isTrue() && !bghl025a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (!bghl025a().criterioSeleccao().tsMovMax().isEmpty()) {
                    criterioData.setTrue() ;
                    wsTsInicio.set(bghl025a().argumento().tsMovimento());
                    wsTsFim.set(bghl025a().criterioSeleccao().tsMovMax());
                } else {
                    criterioMovimento.setTrue() ;
                    wsNsMovMin.set(bghl025a().argumento().nsMovimento());
                    wsNsMovMax.set(bghl025a().criterioSeleccao().nsMovMax());
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
        if (bghl025a().criterioConsulta().ascendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMov() ;
            }
        } else if (bghl025a().criterioConsulta().descendente().isTrue()) {
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
        hv02501Movhist5().movhist5().initialize() ;
        hv02501Movhist5().movhist5().cPaisIsoaCont().set(bghl025a().argumento().cPaisIsoaCont());
        hv02501Movhist5().movhist5().cBancCont().set(bghl025a().argumento().cBancCont());
        hv02501Movhist5().movhist5().cOeEgcCont().set(bghl025a().argumento().cOeEgcCont());
        hv02501Movhist5().movhist5().nsRdclCont().set(bghl025a().argumento().nsRdclCont());
        hv02501Movhist5().movhist5().vChkdCont().set(bghl025a().argumento().vChkdCont());
        hv02501Movhist5().movhist5().cTipoCont().set(bghl025a().argumento().cTipoCont());
        hv02501Movhist5().movhist5().cMoedIsoScta().set(bghl025a().argumento().cMoedIsoScta());
        hv02501Movhist5().movhist5().nsDeposito().set(bghl025a().argumento().nsDeposito());
        hv02501Movhist5().movhist5().nsMovimento().set(bghl025a().argumento().nsMovimento());
        if (bghl025a().criterioConsulta().descendente().isTrue()) {
            if (bghl025a().argumento().nsMovimento().isEqual(0)) {
                hv02501Movhist5().movhist5().nsMovimento().set(9);
            }
        }
        if (criterioData.isTrue()) {
            wsTsInicio.set(bghl025a().argumento().tsMovimento());
            wsTsFim.set(bghl025a().criterioSeleccao().tsMovMax());
        } else {
            wsNsMovMin.set(bghl025a().argumento().nsMovimento());
            wsNsMovMax.set(bghl025a().criterioSeleccao().nsMovMax());
        }
        /**
         * PRC19 - INI
         * SE O MONTANTE MAXIMO DO MOVIMENTO FOR ZERO, FORÇA VALOR MAX
         */
        wsMMovMin.set(bghl025a().criterioMontante().mMovMin());
        if (bghl025a().criterioMontante().mMovMax().isEqual(0)) {
            wsMMovMax.set(999999999999999.99);
        } else {
            wsMMovMax.set(bghl025a().criterioMontante().mMovMax());
        }
        if (bghl025a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl025a().criterioDbcr().debito().isTrue()) {
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
        hv02501Movhist5().openMghs025a522(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02501Movhist5().fetchMghs025a534() ;
            if (hv02501Movhist5().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02501Movhist5().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02501().wsCPaisIsoaCont().set(hv02501Movhist5().movhist5().cPaisIsoaCont());
                wsVgh02501().wsCBancCont().set(hv02501Movhist5().movhist5().cBancCont());
                wsVgh02501().wsCOeEgcCont().set(hv02501Movhist5().movhist5().cOeEgcCont());
                wsVgh02501().wsNsRdclCont().set(hv02501Movhist5().movhist5().nsRdclCont());
                wsVgh02501().wsVChkdCont().set(hv02501Movhist5().movhist5().vChkdCont());
                wsVgh02501().wsCTipoCont().set(hv02501Movhist5().movhist5().cTipoCont());
                wsVgh02501().wsCMoedIsoScta().set(hv02501Movhist5().movhist5().cMoedIsoScta());
                wsVgh02501().wsNsDeposito().set(hv02501Movhist5().movhist5().nsDeposito());
                wsVgh02501().wsTsMovimento().set(hv02501Movhist5().movhist5().tsMovimento());
                wsVgh02501().wsNsMovimento().set(hv02501Movhist5().movhist5().nsMovimento());
                wsVgh02501().wsZValMov().set(hv02501Movhist5().movhist5().zValMov());
                wsVgh02501().wsZMovLocl().set(hv02501Movhist5().movhist5().zMovLocl());
                wsVgh02501().wsIDbcr().set(hv02501Movhist5().movhist5().iDbcr());
                wsVgh02501().wsMMovimento().set(hv02501Movhist5().movhist5().mMovimento());
                wsVgh02501().wsIEstorno().set(hv02501Movhist5().movhist5().iEstorno());
                wsVgh02501().wsCMoedIsoOriMov().set(hv02501Movhist5().movhist5().cMoedIsoOriMov());
                wsVgh02501().wsMSldoCbloApos().set(hv02501Movhist5().movhist5().mSldoCbloApos());
                wsVgh02501().wsMSldoDpnlApos().set(hv02501Movhist5().movhist5().mSldoDpnlApos());
                wsVgh02501().wsMMovMoeOrigMov().set(hv02501Movhist5().movhist5().mMovMoeOrigMov());
                wsVgh02501().wsXRefMov().set(hv02501Movhist5().movhist5().xRefMov());
                wsVgh02501().wsNDocOpps().set(hv02501Movhist5().movhist5().nDocOpps());
                wsVgh02501().wsTJuro().set(hv02501Movhist5().movhist5().tJuro());
                wsVgh02501().wsAAplOrig().set(hv02501Movhist5().movhist5().aAplOrig());
                wsVgh02501().wsIExisInfAdi().set(hv02501Movhist5().movhist5().iExisInfAdi());
                wsVgh02501().wsXChavAcsInfAdi().set(hv02501Movhist5().movhist5().xChavAcsInfAdi());
                wsVgh02501().wsTsActzUlt().set(hv02501Movhist5().movhist5().tsActzUlt());
                wsVgh02501().wsCUsidActzUlt().set(hv02501Movhist5().movhist5().cUsidActzUlt());
                bghl025a().tabela().lista().get(wsInd).item().set(wsVgh02501());
                bghl025a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02501Movhist5().fetchMghs025a597() ;
                if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02501Movhist5().closeMghs025a614() ;
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02501Movhist5().openMghs025a626(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02501Movhist5().fetchMghs025a638() ;
            if (hv02501Movhist5().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02501Movhist5().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02501().wsCPaisIsoaCont().set(hv02501Movhist5().movhist5().cPaisIsoaCont());
                wsVgh02501().wsCBancCont().set(hv02501Movhist5().movhist5().cBancCont());
                wsVgh02501().wsCOeEgcCont().set(hv02501Movhist5().movhist5().cOeEgcCont());
                wsVgh02501().wsNsRdclCont().set(hv02501Movhist5().movhist5().nsRdclCont());
                wsVgh02501().wsVChkdCont().set(hv02501Movhist5().movhist5().vChkdCont());
                wsVgh02501().wsCTipoCont().set(hv02501Movhist5().movhist5().cTipoCont());
                wsVgh02501().wsCMoedIsoScta().set(hv02501Movhist5().movhist5().cMoedIsoScta());
                wsVgh02501().wsNsDeposito().set(hv02501Movhist5().movhist5().nsDeposito());
                wsVgh02501().wsTsMovimento().set(hv02501Movhist5().movhist5().tsMovimento());
                wsVgh02501().wsNsMovimento().set(hv02501Movhist5().movhist5().nsMovimento());
                wsVgh02501().wsZValMov().set(hv02501Movhist5().movhist5().zValMov());
                wsVgh02501().wsZMovLocl().set(hv02501Movhist5().movhist5().zMovLocl());
                wsVgh02501().wsIDbcr().set(hv02501Movhist5().movhist5().iDbcr());
                wsVgh02501().wsMMovimento().set(hv02501Movhist5().movhist5().mMovimento());
                wsVgh02501().wsIEstorno().set(hv02501Movhist5().movhist5().iEstorno());
                wsVgh02501().wsCMoedIsoOriMov().set(hv02501Movhist5().movhist5().cMoedIsoOriMov());
                wsVgh02501().wsMSldoCbloApos().set(hv02501Movhist5().movhist5().mSldoCbloApos());
                wsVgh02501().wsMSldoDpnlApos().set(hv02501Movhist5().movhist5().mSldoDpnlApos());
                wsVgh02501().wsMMovMoeOrigMov().set(hv02501Movhist5().movhist5().mMovMoeOrigMov());
                wsVgh02501().wsXRefMov().set(hv02501Movhist5().movhist5().xRefMov());
                wsVgh02501().wsNDocOpps().set(hv02501Movhist5().movhist5().nDocOpps());
                wsVgh02501().wsTJuro().set(hv02501Movhist5().movhist5().tJuro());
                wsVgh02501().wsAAplOrig().set(hv02501Movhist5().movhist5().aAplOrig());
                wsVgh02501().wsIExisInfAdi().set(hv02501Movhist5().movhist5().iExisInfAdi());
                wsVgh02501().wsXChavAcsInfAdi().set(hv02501Movhist5().movhist5().xChavAcsInfAdi());
                wsVgh02501().wsTsActzUlt().set(hv02501Movhist5().movhist5().tsActzUlt());
                wsVgh02501().wsCUsidActzUlt().set(hv02501Movhist5().movhist5().cUsidActzUlt());
                bghl025a().tabela().lista().get(wsInd).item().set(wsVgh02501());
                bghl025a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02501Movhist5().fetchMghs025a701() ;
                if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02501Movhist5().closeMghs025a718() ;
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02501Movhist5().openMghs025a730(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02501Movhist5().fetchMghs025a742() ;
            if (hv02501Movhist5().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02501Movhist5().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02501().wsCPaisIsoaCont().set(hv02501Movhist5().movhist5().cPaisIsoaCont());
                wsVgh02501().wsCBancCont().set(hv02501Movhist5().movhist5().cBancCont());
                wsVgh02501().wsCOeEgcCont().set(hv02501Movhist5().movhist5().cOeEgcCont());
                wsVgh02501().wsNsRdclCont().set(hv02501Movhist5().movhist5().nsRdclCont());
                wsVgh02501().wsVChkdCont().set(hv02501Movhist5().movhist5().vChkdCont());
                wsVgh02501().wsCTipoCont().set(hv02501Movhist5().movhist5().cTipoCont());
                wsVgh02501().wsCMoedIsoScta().set(hv02501Movhist5().movhist5().cMoedIsoScta());
                wsVgh02501().wsNsDeposito().set(hv02501Movhist5().movhist5().nsDeposito());
                wsVgh02501().wsTsMovimento().set(hv02501Movhist5().movhist5().tsMovimento());
                wsVgh02501().wsNsMovimento().set(hv02501Movhist5().movhist5().nsMovimento());
                wsVgh02501().wsZValMov().set(hv02501Movhist5().movhist5().zValMov());
                wsVgh02501().wsZMovLocl().set(hv02501Movhist5().movhist5().zMovLocl());
                wsVgh02501().wsIDbcr().set(hv02501Movhist5().movhist5().iDbcr());
                wsVgh02501().wsMMovimento().set(hv02501Movhist5().movhist5().mMovimento());
                wsVgh02501().wsIEstorno().set(hv02501Movhist5().movhist5().iEstorno());
                wsVgh02501().wsCMoedIsoOriMov().set(hv02501Movhist5().movhist5().cMoedIsoOriMov());
                wsVgh02501().wsMSldoCbloApos().set(hv02501Movhist5().movhist5().mSldoCbloApos());
                wsVgh02501().wsMSldoDpnlApos().set(hv02501Movhist5().movhist5().mSldoDpnlApos());
                wsVgh02501().wsMMovMoeOrigMov().set(hv02501Movhist5().movhist5().mMovMoeOrigMov());
                wsVgh02501().wsXRefMov().set(hv02501Movhist5().movhist5().xRefMov());
                wsVgh02501().wsNDocOpps().set(hv02501Movhist5().movhist5().nDocOpps());
                wsVgh02501().wsTJuro().set(hv02501Movhist5().movhist5().tJuro());
                wsVgh02501().wsAAplOrig().set(hv02501Movhist5().movhist5().aAplOrig());
                wsVgh02501().wsIExisInfAdi().set(hv02501Movhist5().movhist5().iExisInfAdi());
                wsVgh02501().wsXChavAcsInfAdi().set(hv02501Movhist5().movhist5().xChavAcsInfAdi());
                wsVgh02501().wsTsActzUlt().set(hv02501Movhist5().movhist5().tsActzUlt());
                wsVgh02501().wsCUsidActzUlt().set(hv02501Movhist5().movhist5().cUsidActzUlt());
                bghl025a().tabela().lista().get(wsInd).item().set(wsVgh02501());
                bghl025a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02501Movhist5().fetchMghs025a805() ;
                if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02501Movhist5().closeMghs025a822() ;
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02501Movhist5().openMghs025a834(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsNsMovMax, wsNsMovMin) ;
        if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02501Movhist5().fetchMghs025a846() ;
            if (hv02501Movhist5().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02501Movhist5().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02501().wsCPaisIsoaCont().set(hv02501Movhist5().movhist5().cPaisIsoaCont());
                wsVgh02501().wsCBancCont().set(hv02501Movhist5().movhist5().cBancCont());
                wsVgh02501().wsCOeEgcCont().set(hv02501Movhist5().movhist5().cOeEgcCont());
                wsVgh02501().wsNsRdclCont().set(hv02501Movhist5().movhist5().nsRdclCont());
                wsVgh02501().wsVChkdCont().set(hv02501Movhist5().movhist5().vChkdCont());
                wsVgh02501().wsCTipoCont().set(hv02501Movhist5().movhist5().cTipoCont());
                wsVgh02501().wsCMoedIsoScta().set(hv02501Movhist5().movhist5().cMoedIsoScta());
                wsVgh02501().wsNsDeposito().set(hv02501Movhist5().movhist5().nsDeposito());
                wsVgh02501().wsTsMovimento().set(hv02501Movhist5().movhist5().tsMovimento());
                wsVgh02501().wsNsMovimento().set(hv02501Movhist5().movhist5().nsMovimento());
                wsVgh02501().wsZValMov().set(hv02501Movhist5().movhist5().zValMov());
                wsVgh02501().wsZMovLocl().set(hv02501Movhist5().movhist5().zMovLocl());
                wsVgh02501().wsIDbcr().set(hv02501Movhist5().movhist5().iDbcr());
                wsVgh02501().wsMMovimento().set(hv02501Movhist5().movhist5().mMovimento());
                wsVgh02501().wsIEstorno().set(hv02501Movhist5().movhist5().iEstorno());
                wsVgh02501().wsCMoedIsoOriMov().set(hv02501Movhist5().movhist5().cMoedIsoOriMov());
                wsVgh02501().wsMSldoCbloApos().set(hv02501Movhist5().movhist5().mSldoCbloApos());
                wsVgh02501().wsMSldoDpnlApos().set(hv02501Movhist5().movhist5().mSldoDpnlApos());
                wsVgh02501().wsMMovMoeOrigMov().set(hv02501Movhist5().movhist5().mMovMoeOrigMov());
                wsVgh02501().wsXRefMov().set(hv02501Movhist5().movhist5().xRefMov());
                wsVgh02501().wsNDocOpps().set(hv02501Movhist5().movhist5().nDocOpps());
                wsVgh02501().wsTJuro().set(hv02501Movhist5().movhist5().tJuro());
                wsVgh02501().wsAAplOrig().set(hv02501Movhist5().movhist5().aAplOrig());
                wsVgh02501().wsIExisInfAdi().set(hv02501Movhist5().movhist5().iExisInfAdi());
                wsVgh02501().wsXChavAcsInfAdi().set(hv02501Movhist5().movhist5().xChavAcsInfAdi());
                wsVgh02501().wsTsActzUlt().set(hv02501Movhist5().movhist5().tsActzUlt());
                wsVgh02501().wsCUsidActzUlt().set(hv02501Movhist5().movhist5().cUsidActzUlt());
                bghl025a().tabela().lista().get(wsInd).item().set(wsVgh02501());
                bghl025a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02501Movhist5().fetchMghs025a909() ;
                if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02501Movhist5().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02501Movhist5().closeMghs025a926() ;
            if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl025a().cRetorno().set(progStatus);
        bghl025a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh02501 extends IDataStruct {
        
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
