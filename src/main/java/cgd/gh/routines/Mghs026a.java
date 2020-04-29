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
import cgd.gh.structures.link.Bghl026a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00026_MOVHIST6
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * DOS MOVIMENTOS DE HA 6 ANOS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS026A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs026a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl026a
     */
    @Data
    public abstract Bghl026a bghl026a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02601Movhist6
     */
    @Data
    protected abstract Vwsdghps02601Movhist6 hv02601Movhist6() ;
    
    
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
     * @return instancia da classe local WsVgh02601
     */
    @Data
    protected abstract WsVgh02601 wsVgh02601() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl026a().cRetorno().initialize() ;
        bghl026a().cSqlcode().initialize() ;
        if (bghl026a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl026a().argumento().cBancCont().isEqual(0) || 
            bghl026a().argumento().cOeEgcCont().isEqual(0) || 
            bghl026a().argumento().nsRdclCont().isEqual(0) || 
            bghl026a().argumento().cMoedIsoScta().isEmpty() || 
            bghl026a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl026a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl026a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl026a().criterioConsulta().ascendente().isTrue() && !bghl026a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (!bghl026a().criterioSeleccao().tsMovMax().isEmpty()) {
                    criterioData.setTrue() ;
                    wsTsInicio.set(bghl026a().argumento().tsMovimento());
                    wsTsFim.set(bghl026a().criterioSeleccao().tsMovMax());
                } else {
                    criterioMovimento.setTrue() ;
                    wsNsMovMin.set(bghl026a().argumento().nsMovimento());
                    wsNsMovMax.set(bghl026a().criterioSeleccao().nsMovMax());
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
        if (bghl026a().criterioConsulta().ascendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMov() ;
            }
        } else if (bghl026a().criterioConsulta().descendente().isTrue()) {
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
        hv02601Movhist6().movhist6().initialize() ;
        hv02601Movhist6().movhist6().cPaisIsoaCont().set(bghl026a().argumento().cPaisIsoaCont());
        hv02601Movhist6().movhist6().cBancCont().set(bghl026a().argumento().cBancCont());
        hv02601Movhist6().movhist6().cOeEgcCont().set(bghl026a().argumento().cOeEgcCont());
        hv02601Movhist6().movhist6().nsRdclCont().set(bghl026a().argumento().nsRdclCont());
        hv02601Movhist6().movhist6().vChkdCont().set(bghl026a().argumento().vChkdCont());
        hv02601Movhist6().movhist6().cTipoCont().set(bghl026a().argumento().cTipoCont());
        hv02601Movhist6().movhist6().cMoedIsoScta().set(bghl026a().argumento().cMoedIsoScta());
        hv02601Movhist6().movhist6().nsDeposito().set(bghl026a().argumento().nsDeposito());
        hv02601Movhist6().movhist6().nsMovimento().set(bghl026a().argumento().nsMovimento());
        if (bghl026a().criterioConsulta().descendente().isTrue()) {
            if (bghl026a().argumento().nsMovimento().isEqual(0)) {
                hv02601Movhist6().movhist6().nsMovimento().set(9);
            }
        }
        if (criterioData.isTrue()) {
            wsTsInicio.set(bghl026a().argumento().tsMovimento());
            wsTsFim.set(bghl026a().criterioSeleccao().tsMovMax());
        } else {
            wsNsMovMin.set(bghl026a().argumento().nsMovimento());
            wsNsMovMax.set(bghl026a().criterioSeleccao().nsMovMax());
        }
        /**
         * PRC19 - INI
         * SE O MONTANTE MAXIMO DO MOVIMENTO FOR ZERO, FORÇA VALOR MAX
         */
        wsMMovMin.set(bghl026a().criterioMontante().mMovMin());
        if (bghl026a().criterioMontante().mMovMax().isEqual(0)) {
            wsMMovMax.set(999999999999999.99);
        } else {
            wsMMovMax.set(bghl026a().criterioMontante().mMovMax());
        }
        if (bghl026a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl026a().criterioDbcr().debito().isTrue()) {
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
        hv02601Movhist6().openMghs026a522(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02601Movhist6().fetchMghs026a534() ;
            if (hv02601Movhist6().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02601Movhist6().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02601().wsCPaisIsoaCont().set(hv02601Movhist6().movhist6().cPaisIsoaCont());
                wsVgh02601().wsCBancCont().set(hv02601Movhist6().movhist6().cBancCont());
                wsVgh02601().wsCOeEgcCont().set(hv02601Movhist6().movhist6().cOeEgcCont());
                wsVgh02601().wsNsRdclCont().set(hv02601Movhist6().movhist6().nsRdclCont());
                wsVgh02601().wsVChkdCont().set(hv02601Movhist6().movhist6().vChkdCont());
                wsVgh02601().wsCTipoCont().set(hv02601Movhist6().movhist6().cTipoCont());
                wsVgh02601().wsCMoedIsoScta().set(hv02601Movhist6().movhist6().cMoedIsoScta());
                wsVgh02601().wsNsDeposito().set(hv02601Movhist6().movhist6().nsDeposito());
                wsVgh02601().wsTsMovimento().set(hv02601Movhist6().movhist6().tsMovimento());
                wsVgh02601().wsNsMovimento().set(hv02601Movhist6().movhist6().nsMovimento());
                wsVgh02601().wsZValMov().set(hv02601Movhist6().movhist6().zValMov());
                wsVgh02601().wsZMovLocl().set(hv02601Movhist6().movhist6().zMovLocl());
                wsVgh02601().wsIDbcr().set(hv02601Movhist6().movhist6().iDbcr());
                wsVgh02601().wsMMovimento().set(hv02601Movhist6().movhist6().mMovimento());
                wsVgh02601().wsIEstorno().set(hv02601Movhist6().movhist6().iEstorno());
                wsVgh02601().wsCMoedIsoOriMov().set(hv02601Movhist6().movhist6().cMoedIsoOriMov());
                wsVgh02601().wsMSldoCbloApos().set(hv02601Movhist6().movhist6().mSldoCbloApos());
                wsVgh02601().wsMSldoDpnlApos().set(hv02601Movhist6().movhist6().mSldoDpnlApos());
                wsVgh02601().wsMMovMoeOrigMov().set(hv02601Movhist6().movhist6().mMovMoeOrigMov());
                wsVgh02601().wsXRefMov().set(hv02601Movhist6().movhist6().xRefMov());
                wsVgh02601().wsNDocOpps().set(hv02601Movhist6().movhist6().nDocOpps());
                wsVgh02601().wsTJuro().set(hv02601Movhist6().movhist6().tJuro());
                wsVgh02601().wsAAplOrig().set(hv02601Movhist6().movhist6().aAplOrig());
                wsVgh02601().wsIExisInfAdi().set(hv02601Movhist6().movhist6().iExisInfAdi());
                wsVgh02601().wsXChavAcsInfAdi().set(hv02601Movhist6().movhist6().xChavAcsInfAdi());
                wsVgh02601().wsTsActzUlt().set(hv02601Movhist6().movhist6().tsActzUlt());
                wsVgh02601().wsCUsidActzUlt().set(hv02601Movhist6().movhist6().cUsidActzUlt());
                bghl026a().tabela().lista().get(wsInd).item().set(wsVgh02601());
                bghl026a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02601Movhist6().fetchMghs026a597() ;
                if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02601Movhist6().closeMghs026a614() ;
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02601Movhist6().openMghs026a626(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02601Movhist6().fetchMghs026a638() ;
            if (hv02601Movhist6().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02601Movhist6().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02601().wsCPaisIsoaCont().set(hv02601Movhist6().movhist6().cPaisIsoaCont());
                wsVgh02601().wsCBancCont().set(hv02601Movhist6().movhist6().cBancCont());
                wsVgh02601().wsCOeEgcCont().set(hv02601Movhist6().movhist6().cOeEgcCont());
                wsVgh02601().wsNsRdclCont().set(hv02601Movhist6().movhist6().nsRdclCont());
                wsVgh02601().wsVChkdCont().set(hv02601Movhist6().movhist6().vChkdCont());
                wsVgh02601().wsCTipoCont().set(hv02601Movhist6().movhist6().cTipoCont());
                wsVgh02601().wsCMoedIsoScta().set(hv02601Movhist6().movhist6().cMoedIsoScta());
                wsVgh02601().wsNsDeposito().set(hv02601Movhist6().movhist6().nsDeposito());
                wsVgh02601().wsTsMovimento().set(hv02601Movhist6().movhist6().tsMovimento());
                wsVgh02601().wsNsMovimento().set(hv02601Movhist6().movhist6().nsMovimento());
                wsVgh02601().wsZValMov().set(hv02601Movhist6().movhist6().zValMov());
                wsVgh02601().wsZMovLocl().set(hv02601Movhist6().movhist6().zMovLocl());
                wsVgh02601().wsIDbcr().set(hv02601Movhist6().movhist6().iDbcr());
                wsVgh02601().wsMMovimento().set(hv02601Movhist6().movhist6().mMovimento());
                wsVgh02601().wsIEstorno().set(hv02601Movhist6().movhist6().iEstorno());
                wsVgh02601().wsCMoedIsoOriMov().set(hv02601Movhist6().movhist6().cMoedIsoOriMov());
                wsVgh02601().wsMSldoCbloApos().set(hv02601Movhist6().movhist6().mSldoCbloApos());
                wsVgh02601().wsMSldoDpnlApos().set(hv02601Movhist6().movhist6().mSldoDpnlApos());
                wsVgh02601().wsMMovMoeOrigMov().set(hv02601Movhist6().movhist6().mMovMoeOrigMov());
                wsVgh02601().wsXRefMov().set(hv02601Movhist6().movhist6().xRefMov());
                wsVgh02601().wsNDocOpps().set(hv02601Movhist6().movhist6().nDocOpps());
                wsVgh02601().wsTJuro().set(hv02601Movhist6().movhist6().tJuro());
                wsVgh02601().wsAAplOrig().set(hv02601Movhist6().movhist6().aAplOrig());
                wsVgh02601().wsIExisInfAdi().set(hv02601Movhist6().movhist6().iExisInfAdi());
                wsVgh02601().wsXChavAcsInfAdi().set(hv02601Movhist6().movhist6().xChavAcsInfAdi());
                wsVgh02601().wsTsActzUlt().set(hv02601Movhist6().movhist6().tsActzUlt());
                wsVgh02601().wsCUsidActzUlt().set(hv02601Movhist6().movhist6().cUsidActzUlt());
                bghl026a().tabela().lista().get(wsInd).item().set(wsVgh02601());
                bghl026a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02601Movhist6().fetchMghs026a701() ;
                if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02601Movhist6().closeMghs026a718() ;
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02601Movhist6().openMghs026a730(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02601Movhist6().fetchMghs026a742() ;
            if (hv02601Movhist6().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02601Movhist6().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02601().wsCPaisIsoaCont().set(hv02601Movhist6().movhist6().cPaisIsoaCont());
                wsVgh02601().wsCBancCont().set(hv02601Movhist6().movhist6().cBancCont());
                wsVgh02601().wsCOeEgcCont().set(hv02601Movhist6().movhist6().cOeEgcCont());
                wsVgh02601().wsNsRdclCont().set(hv02601Movhist6().movhist6().nsRdclCont());
                wsVgh02601().wsVChkdCont().set(hv02601Movhist6().movhist6().vChkdCont());
                wsVgh02601().wsCTipoCont().set(hv02601Movhist6().movhist6().cTipoCont());
                wsVgh02601().wsCMoedIsoScta().set(hv02601Movhist6().movhist6().cMoedIsoScta());
                wsVgh02601().wsNsDeposito().set(hv02601Movhist6().movhist6().nsDeposito());
                wsVgh02601().wsTsMovimento().set(hv02601Movhist6().movhist6().tsMovimento());
                wsVgh02601().wsNsMovimento().set(hv02601Movhist6().movhist6().nsMovimento());
                wsVgh02601().wsZValMov().set(hv02601Movhist6().movhist6().zValMov());
                wsVgh02601().wsZMovLocl().set(hv02601Movhist6().movhist6().zMovLocl());
                wsVgh02601().wsIDbcr().set(hv02601Movhist6().movhist6().iDbcr());
                wsVgh02601().wsMMovimento().set(hv02601Movhist6().movhist6().mMovimento());
                wsVgh02601().wsIEstorno().set(hv02601Movhist6().movhist6().iEstorno());
                wsVgh02601().wsCMoedIsoOriMov().set(hv02601Movhist6().movhist6().cMoedIsoOriMov());
                wsVgh02601().wsMSldoCbloApos().set(hv02601Movhist6().movhist6().mSldoCbloApos());
                wsVgh02601().wsMSldoDpnlApos().set(hv02601Movhist6().movhist6().mSldoDpnlApos());
                wsVgh02601().wsMMovMoeOrigMov().set(hv02601Movhist6().movhist6().mMovMoeOrigMov());
                wsVgh02601().wsXRefMov().set(hv02601Movhist6().movhist6().xRefMov());
                wsVgh02601().wsNDocOpps().set(hv02601Movhist6().movhist6().nDocOpps());
                wsVgh02601().wsTJuro().set(hv02601Movhist6().movhist6().tJuro());
                wsVgh02601().wsAAplOrig().set(hv02601Movhist6().movhist6().aAplOrig());
                wsVgh02601().wsIExisInfAdi().set(hv02601Movhist6().movhist6().iExisInfAdi());
                wsVgh02601().wsXChavAcsInfAdi().set(hv02601Movhist6().movhist6().xChavAcsInfAdi());
                wsVgh02601().wsTsActzUlt().set(hv02601Movhist6().movhist6().tsActzUlt());
                wsVgh02601().wsCUsidActzUlt().set(hv02601Movhist6().movhist6().cUsidActzUlt());
                bghl026a().tabela().lista().get(wsInd).item().set(wsVgh02601());
                bghl026a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02601Movhist6().fetchMghs026a805() ;
                if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02601Movhist6().closeMghs026a822() ;
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02601Movhist6().openMghs026a834(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsNsMovMax, wsNsMovMin) ;
        if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02601Movhist6().fetchMghs026a846() ;
            if (hv02601Movhist6().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02601Movhist6().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02601().wsCPaisIsoaCont().set(hv02601Movhist6().movhist6().cPaisIsoaCont());
                wsVgh02601().wsCBancCont().set(hv02601Movhist6().movhist6().cBancCont());
                wsVgh02601().wsCOeEgcCont().set(hv02601Movhist6().movhist6().cOeEgcCont());
                wsVgh02601().wsNsRdclCont().set(hv02601Movhist6().movhist6().nsRdclCont());
                wsVgh02601().wsVChkdCont().set(hv02601Movhist6().movhist6().vChkdCont());
                wsVgh02601().wsCTipoCont().set(hv02601Movhist6().movhist6().cTipoCont());
                wsVgh02601().wsCMoedIsoScta().set(hv02601Movhist6().movhist6().cMoedIsoScta());
                wsVgh02601().wsNsDeposito().set(hv02601Movhist6().movhist6().nsDeposito());
                wsVgh02601().wsTsMovimento().set(hv02601Movhist6().movhist6().tsMovimento());
                wsVgh02601().wsNsMovimento().set(hv02601Movhist6().movhist6().nsMovimento());
                wsVgh02601().wsZValMov().set(hv02601Movhist6().movhist6().zValMov());
                wsVgh02601().wsZMovLocl().set(hv02601Movhist6().movhist6().zMovLocl());
                wsVgh02601().wsIDbcr().set(hv02601Movhist6().movhist6().iDbcr());
                wsVgh02601().wsMMovimento().set(hv02601Movhist6().movhist6().mMovimento());
                wsVgh02601().wsIEstorno().set(hv02601Movhist6().movhist6().iEstorno());
                wsVgh02601().wsCMoedIsoOriMov().set(hv02601Movhist6().movhist6().cMoedIsoOriMov());
                wsVgh02601().wsMSldoCbloApos().set(hv02601Movhist6().movhist6().mSldoCbloApos());
                wsVgh02601().wsMSldoDpnlApos().set(hv02601Movhist6().movhist6().mSldoDpnlApos());
                wsVgh02601().wsMMovMoeOrigMov().set(hv02601Movhist6().movhist6().mMovMoeOrigMov());
                wsVgh02601().wsXRefMov().set(hv02601Movhist6().movhist6().xRefMov());
                wsVgh02601().wsNDocOpps().set(hv02601Movhist6().movhist6().nDocOpps());
                wsVgh02601().wsTJuro().set(hv02601Movhist6().movhist6().tJuro());
                wsVgh02601().wsAAplOrig().set(hv02601Movhist6().movhist6().aAplOrig());
                wsVgh02601().wsIExisInfAdi().set(hv02601Movhist6().movhist6().iExisInfAdi());
                wsVgh02601().wsXChavAcsInfAdi().set(hv02601Movhist6().movhist6().xChavAcsInfAdi());
                wsVgh02601().wsTsActzUlt().set(hv02601Movhist6().movhist6().tsActzUlt());
                wsVgh02601().wsCUsidActzUlt().set(hv02601Movhist6().movhist6().cUsidActzUlt());
                bghl026a().tabela().lista().get(wsInd).item().set(wsVgh02601());
                bghl026a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02601Movhist6().fetchMghs026a909() ;
                if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02601Movhist6().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02601Movhist6().closeMghs026a926() ;
            if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl026a().cRetorno().set(progStatus);
        bghl026a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh02601 extends IDataStruct {
        
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
