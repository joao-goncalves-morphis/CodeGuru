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
import cgd.gh.structures.link.Bghl027a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00027_MOVHIST7
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * DOS MOVIMENTOS DE HA 7 ANOS
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS027A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs027a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl027a
     */
    @Data
    public abstract Bghl027a bghl027a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    
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
     * @return instancia da classe local WsVgh02701
     */
    @Data
    protected abstract WsVgh02701 wsVgh02701() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl027a().cRetorno().initialize() ;
        bghl027a().cSqlcode().initialize() ;
        if (bghl027a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl027a().argumento().cBancCont().isEqual(0) || 
            bghl027a().argumento().cOeEgcCont().isEqual(0) || 
            bghl027a().argumento().nsRdclCont().isEqual(0) || 
            bghl027a().argumento().cMoedIsoScta().isEmpty() || 
            bghl027a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl027a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl027a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl027a().criterioConsulta().ascendente().isTrue() && !bghl027a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (!bghl027a().criterioSeleccao().tsMovMax().isEmpty()) {
                    criterioData.setTrue() ;
                    wsTsInicio.set(bghl027a().argumento().tsMovimento());
                    wsTsFim.set(bghl027a().criterioSeleccao().tsMovMax());
                } else {
                    criterioMovimento.setTrue() ;
                    wsNsMovMin.set(bghl027a().argumento().nsMovimento());
                    wsNsMovMax.set(bghl027a().criterioSeleccao().nsMovMax());
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
        if (bghl027a().criterioConsulta().ascendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMov() ;
            }
        } else if (bghl027a().criterioConsulta().descendente().isTrue()) {
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
        hv02701Movhist7().movhist7().initialize() ;
        hv02701Movhist7().movhist7().cPaisIsoaCont().set(bghl027a().argumento().cPaisIsoaCont());
        hv02701Movhist7().movhist7().cBancCont().set(bghl027a().argumento().cBancCont());
        hv02701Movhist7().movhist7().cOeEgcCont().set(bghl027a().argumento().cOeEgcCont());
        hv02701Movhist7().movhist7().nsRdclCont().set(bghl027a().argumento().nsRdclCont());
        hv02701Movhist7().movhist7().vChkdCont().set(bghl027a().argumento().vChkdCont());
        hv02701Movhist7().movhist7().cTipoCont().set(bghl027a().argumento().cTipoCont());
        hv02701Movhist7().movhist7().cMoedIsoScta().set(bghl027a().argumento().cMoedIsoScta());
        hv02701Movhist7().movhist7().nsDeposito().set(bghl027a().argumento().nsDeposito());
        hv02701Movhist7().movhist7().nsMovimento().set(bghl027a().argumento().nsMovimento());
        if (bghl027a().criterioConsulta().descendente().isTrue()) {
            if (bghl027a().argumento().nsMovimento().isEqual(0)) {
                hv02701Movhist7().movhist7().nsMovimento().set(9);
            }
        }
        if (criterioData.isTrue()) {
            wsTsInicio.set(bghl027a().argumento().tsMovimento());
            wsTsFim.set(bghl027a().criterioSeleccao().tsMovMax());
        } else {
            wsNsMovMin.set(bghl027a().argumento().nsMovimento());
            wsNsMovMax.set(bghl027a().criterioSeleccao().nsMovMax());
        }
        /**
         * PRC19 - INI
         * SE O MONTANTE MAXIMO DO MOVIMENTO FOR ZERO, FORÇA VALOR MAX
         */
        wsMMovMin.set(bghl027a().criterioMontante().mMovMin());
        if (bghl027a().criterioMontante().mMovMax().isEqual(0)) {
            wsMMovMax.set(999999999999999.99);
        } else {
            wsMMovMax.set(bghl027a().criterioMontante().mMovMax());
        }
        if (bghl027a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl027a().criterioDbcr().debito().isTrue()) {
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
        hv02701Movhist7().openMghs027a522(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02701Movhist7().fetchMghs027a534() ;
            if (hv02701Movhist7().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02701Movhist7().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02701().wsCPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
                wsVgh02701().wsCBancCont().set(hv02701Movhist7().movhist7().cBancCont());
                wsVgh02701().wsCOeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
                wsVgh02701().wsNsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
                wsVgh02701().wsVChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
                wsVgh02701().wsCTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
                wsVgh02701().wsCMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
                wsVgh02701().wsNsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
                wsVgh02701().wsTsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
                wsVgh02701().wsNsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
                wsVgh02701().wsZValMov().set(hv02701Movhist7().movhist7().zValMov());
                wsVgh02701().wsZMovLocl().set(hv02701Movhist7().movhist7().zMovLocl());
                wsVgh02701().wsIDbcr().set(hv02701Movhist7().movhist7().iDbcr());
                wsVgh02701().wsMMovimento().set(hv02701Movhist7().movhist7().mMovimento());
                wsVgh02701().wsIEstorno().set(hv02701Movhist7().movhist7().iEstorno());
                wsVgh02701().wsCMoedIsoOriMov().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
                wsVgh02701().wsMSldoCbloApos().set(hv02701Movhist7().movhist7().mSldoCbloApos());
                wsVgh02701().wsMSldoDpnlApos().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
                wsVgh02701().wsMMovMoeOrigMov().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
                wsVgh02701().wsXRefMov().set(hv02701Movhist7().movhist7().xRefMov());
                wsVgh02701().wsNDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
                wsVgh02701().wsTJuro().set(hv02701Movhist7().movhist7().tJuro());
                wsVgh02701().wsAAplOrig().set(hv02701Movhist7().movhist7().aAplOrig());
                wsVgh02701().wsIExisInfAdi().set(hv02701Movhist7().movhist7().iExisInfAdi());
                wsVgh02701().wsXChavAcsInfAdi().set(hv02701Movhist7().movhist7().xChavAcsInfAdi());
                wsVgh02701().wsTsActzUlt().set(hv02701Movhist7().movhist7().tsActzUlt());
                wsVgh02701().wsCUsidActzUlt().set(hv02701Movhist7().movhist7().cUsidActzUlt());
                bghl027a().tabela().lista().get(wsInd).item().set(wsVgh02701());
                bghl027a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02701Movhist7().fetchMghs027a597() ;
                if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02701Movhist7().closeMghs027a614() ;
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02701Movhist7().openMghs027a626(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02701Movhist7().fetchMghs027a638() ;
            if (hv02701Movhist7().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02701Movhist7().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02701().wsCPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
                wsVgh02701().wsCBancCont().set(hv02701Movhist7().movhist7().cBancCont());
                wsVgh02701().wsCOeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
                wsVgh02701().wsNsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
                wsVgh02701().wsVChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
                wsVgh02701().wsCTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
                wsVgh02701().wsCMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
                wsVgh02701().wsNsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
                wsVgh02701().wsTsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
                wsVgh02701().wsNsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
                wsVgh02701().wsZValMov().set(hv02701Movhist7().movhist7().zValMov());
                wsVgh02701().wsZMovLocl().set(hv02701Movhist7().movhist7().zMovLocl());
                wsVgh02701().wsIDbcr().set(hv02701Movhist7().movhist7().iDbcr());
                wsVgh02701().wsMMovimento().set(hv02701Movhist7().movhist7().mMovimento());
                wsVgh02701().wsIEstorno().set(hv02701Movhist7().movhist7().iEstorno());
                wsVgh02701().wsCMoedIsoOriMov().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
                wsVgh02701().wsMSldoCbloApos().set(hv02701Movhist7().movhist7().mSldoCbloApos());
                wsVgh02701().wsMSldoDpnlApos().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
                wsVgh02701().wsMMovMoeOrigMov().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
                wsVgh02701().wsXRefMov().set(hv02701Movhist7().movhist7().xRefMov());
                wsVgh02701().wsNDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
                wsVgh02701().wsTJuro().set(hv02701Movhist7().movhist7().tJuro());
                wsVgh02701().wsAAplOrig().set(hv02701Movhist7().movhist7().aAplOrig());
                wsVgh02701().wsIExisInfAdi().set(hv02701Movhist7().movhist7().iExisInfAdi());
                wsVgh02701().wsXChavAcsInfAdi().set(hv02701Movhist7().movhist7().xChavAcsInfAdi());
                wsVgh02701().wsTsActzUlt().set(hv02701Movhist7().movhist7().tsActzUlt());
                wsVgh02701().wsCUsidActzUlt().set(hv02701Movhist7().movhist7().cUsidActzUlt());
                bghl027a().tabela().lista().get(wsInd).item().set(wsVgh02701());
                bghl027a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02701Movhist7().fetchMghs027a701() ;
                if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02701Movhist7().closeMghs027a718() ;
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02701Movhist7().openMghs027a730(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsTsInicio, wsTsFim) ;
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02701Movhist7().fetchMghs027a742() ;
            if (hv02701Movhist7().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02701Movhist7().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02701().wsCPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
                wsVgh02701().wsCBancCont().set(hv02701Movhist7().movhist7().cBancCont());
                wsVgh02701().wsCOeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
                wsVgh02701().wsNsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
                wsVgh02701().wsVChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
                wsVgh02701().wsCTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
                wsVgh02701().wsCMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
                wsVgh02701().wsNsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
                wsVgh02701().wsTsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
                wsVgh02701().wsNsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
                wsVgh02701().wsZValMov().set(hv02701Movhist7().movhist7().zValMov());
                wsVgh02701().wsZMovLocl().set(hv02701Movhist7().movhist7().zMovLocl());
                wsVgh02701().wsIDbcr().set(hv02701Movhist7().movhist7().iDbcr());
                wsVgh02701().wsMMovimento().set(hv02701Movhist7().movhist7().mMovimento());
                wsVgh02701().wsIEstorno().set(hv02701Movhist7().movhist7().iEstorno());
                wsVgh02701().wsCMoedIsoOriMov().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
                wsVgh02701().wsMSldoCbloApos().set(hv02701Movhist7().movhist7().mSldoCbloApos());
                wsVgh02701().wsMSldoDpnlApos().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
                wsVgh02701().wsMMovMoeOrigMov().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
                wsVgh02701().wsXRefMov().set(hv02701Movhist7().movhist7().xRefMov());
                wsVgh02701().wsNDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
                wsVgh02701().wsTJuro().set(hv02701Movhist7().movhist7().tJuro());
                wsVgh02701().wsAAplOrig().set(hv02701Movhist7().movhist7().aAplOrig());
                wsVgh02701().wsIExisInfAdi().set(hv02701Movhist7().movhist7().iExisInfAdi());
                wsVgh02701().wsXChavAcsInfAdi().set(hv02701Movhist7().movhist7().xChavAcsInfAdi());
                wsVgh02701().wsTsActzUlt().set(hv02701Movhist7().movhist7().tsActzUlt());
                wsVgh02701().wsCUsidActzUlt().set(hv02701Movhist7().movhist7().cUsidActzUlt());
                bghl027a().tabela().lista().get(wsInd).item().set(wsVgh02701());
                bghl027a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02701Movhist7().fetchMghs027a805() ;
                if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02701Movhist7().closeMghs027a822() ;
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv02701Movhist7().openMghs027a834(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2, wsNsMovMax, wsNsMovMin) ;
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02701Movhist7().fetchMghs027a846() ;
            if (hv02701Movhist7().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02701Movhist7().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02701().wsCPaisIsoaCont().set(hv02701Movhist7().movhist7().cPaisIsoaCont());
                wsVgh02701().wsCBancCont().set(hv02701Movhist7().movhist7().cBancCont());
                wsVgh02701().wsCOeEgcCont().set(hv02701Movhist7().movhist7().cOeEgcCont());
                wsVgh02701().wsNsRdclCont().set(hv02701Movhist7().movhist7().nsRdclCont());
                wsVgh02701().wsVChkdCont().set(hv02701Movhist7().movhist7().vChkdCont());
                wsVgh02701().wsCTipoCont().set(hv02701Movhist7().movhist7().cTipoCont());
                wsVgh02701().wsCMoedIsoScta().set(hv02701Movhist7().movhist7().cMoedIsoScta());
                wsVgh02701().wsNsDeposito().set(hv02701Movhist7().movhist7().nsDeposito());
                wsVgh02701().wsTsMovimento().set(hv02701Movhist7().movhist7().tsMovimento());
                wsVgh02701().wsNsMovimento().set(hv02701Movhist7().movhist7().nsMovimento());
                wsVgh02701().wsZValMov().set(hv02701Movhist7().movhist7().zValMov());
                wsVgh02701().wsZMovLocl().set(hv02701Movhist7().movhist7().zMovLocl());
                wsVgh02701().wsIDbcr().set(hv02701Movhist7().movhist7().iDbcr());
                wsVgh02701().wsMMovimento().set(hv02701Movhist7().movhist7().mMovimento());
                wsVgh02701().wsIEstorno().set(hv02701Movhist7().movhist7().iEstorno());
                wsVgh02701().wsCMoedIsoOriMov().set(hv02701Movhist7().movhist7().cMoedIsoOriMov());
                wsVgh02701().wsMSldoCbloApos().set(hv02701Movhist7().movhist7().mSldoCbloApos());
                wsVgh02701().wsMSldoDpnlApos().set(hv02701Movhist7().movhist7().mSldoDpnlApos());
                wsVgh02701().wsMMovMoeOrigMov().set(hv02701Movhist7().movhist7().mMovMoeOrigMov());
                wsVgh02701().wsXRefMov().set(hv02701Movhist7().movhist7().xRefMov());
                wsVgh02701().wsNDocOpps().set(hv02701Movhist7().movhist7().nDocOpps());
                wsVgh02701().wsTJuro().set(hv02701Movhist7().movhist7().tJuro());
                wsVgh02701().wsAAplOrig().set(hv02701Movhist7().movhist7().aAplOrig());
                wsVgh02701().wsIExisInfAdi().set(hv02701Movhist7().movhist7().iExisInfAdi());
                wsVgh02701().wsXChavAcsInfAdi().set(hv02701Movhist7().movhist7().xChavAcsInfAdi());
                wsVgh02701().wsTsActzUlt().set(hv02701Movhist7().movhist7().tsActzUlt());
                wsVgh02701().wsCUsidActzUlt().set(hv02701Movhist7().movhist7().cUsidActzUlt());
                bghl027a().tabela().lista().get(wsInd).item().set(wsVgh02701());
                bghl027a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02701Movhist7().fetchMghs027a909() ;
                if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02701Movhist7().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02701Movhist7().closeMghs027a926() ;
            if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl027a().cRetorno().set(progStatus);
        bghl027a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh02701 extends IDataStruct {
        
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
