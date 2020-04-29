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
import cgd.gh.structures.link.Bghl500a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * CRITERIO DATAS
 * CRITERIO NS-MOVIMENTO
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00500_INFHST
 * DESCRICAO     : LISTA REGISTOS DA INFORMACAO PRINCIPAL
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS500A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs500a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl500a
     */
    @Data
    public abstract Bghl500a bghl500a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps50001Infhst
     */
    @Data
    protected abstract Vwsdghps50001Infhst hv50001Infhst() ;
    
    
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
     * @return instancia da classe local WsVgh50001
     */
    @Data
    protected abstract WsVgh50001 wsVgh50001() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl500a().cRetorno().initialize() ;
        bghl500a().cSqlcode().initialize() ;
        if (bghl500a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl500a().argumento().cBancCont().isEqual(0) || 
            bghl500a().argumento().cOeEgcCont().isEqual(0) || 
            bghl500a().argumento().nsRdclCont().isEqual(0) || 
            bghl500a().argumento().cMoedIsoScta().isEmpty() || 
            bghl500a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (bghl500a().criterioSeleccao().tsMovMax().isEmpty() && 
                bghl500a().criterioSeleccao().nsMovMax().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
            }
            if (progOk.isTrue()) {
                if (!bghl500a().criterioConsulta().ascendente().isTrue() && !bghl500a().criterioConsulta().descendente().isTrue()) {
                    progDadosInvalidos.setTrue() ;
                }
            }
            if (progOk.isTrue()) {
                if (!bghl500a().criterioSeleccao().tsMovMax().isEmpty()) {
                    criterioData.setTrue() ;
                    wsTsInicio.set(bghl500a().argumento().tsMovimento());
                    wsTsFim.set(bghl500a().criterioSeleccao().tsMovMax());
                } else {
                    criterioMovimento.setTrue() ;
                    wsNsMovMin.set(bghl500a().argumento().nsMovimento());
                    wsNsMovMax.set(bghl500a().criterioSeleccao().nsMovMax());
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
        if (bghl500a().criterioConsulta().ascendente().isTrue()) {
            if (criterioData.isTrue()) {
                a5200ListaAscData() ;
            } else {
                a5300ListaAscMov() ;
            }
        } else if (bghl500a().criterioConsulta().descendente().isTrue()) {
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
         */
        hv50001Infhst().infhst().initialize() ;
        hv50001Infhst().infhst().cPaisIsoaCont().set(bghl500a().argumento().cPaisIsoaCont());
        hv50001Infhst().infhst().cBancCont().set(bghl500a().argumento().cBancCont());
        hv50001Infhst().infhst().cOeEgcCont().set(bghl500a().argumento().cOeEgcCont());
        hv50001Infhst().infhst().nsRdclCont().set(bghl500a().argumento().nsRdclCont());
        hv50001Infhst().infhst().vChkdCont().set(bghl500a().argumento().vChkdCont());
        hv50001Infhst().infhst().cTipoCont().set(bghl500a().argumento().cTipoCont());
        hv50001Infhst().infhst().cMoedIsoScta().set(bghl500a().argumento().cMoedIsoScta());
        hv50001Infhst().infhst().nsDeposito().set(bghl500a().argumento().nsDeposito());
        if (criterioData.isTrue()) {
            wsTsInicio.set(bghl500a().argumento().tsMovimento());
            wsTsFim.set(bghl500a().criterioSeleccao().tsMovMax());
            hv50001Infhst().infhst().nsMovimento().set(bghl500a().argumento().nsMovimento());
        } else {
            wsNsMovMin.set(bghl500a().argumento().nsMovimento());
            wsNsMovMax.set(bghl500a().criterioSeleccao().nsMovMax());
        }
        if (bghl500a().criterioConsulta().descendente().isTrue()) {
            if (bghl500a().argumento().nsMovimento().isEqual(0)) {
                hv50001Infhst().infhst().nsMovimento().set(9);
            }
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
        hv50001Infhst().openMghs500a471(wsTsInicio, wsTsFim) ;
        if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv50001Infhst().fetchMghs500a483() ;
            if (hv50001Infhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv50001Infhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh50001().wsCPaisIsoaCont().set(hv50001Infhst().infhst().cPaisIsoaCont());
                wsVgh50001().wsCBancCont().set(hv50001Infhst().infhst().cBancCont());
                wsVgh50001().wsCOeEgcCont().set(hv50001Infhst().infhst().cOeEgcCont());
                wsVgh50001().wsNsRdclCont().set(hv50001Infhst().infhst().nsRdclCont());
                wsVgh50001().wsVChkdCont().set(hv50001Infhst().infhst().vChkdCont());
                wsVgh50001().wsCTipoCont().set(hv50001Infhst().infhst().cTipoCont());
                wsVgh50001().wsCMoedIsoScta().set(hv50001Infhst().infhst().cMoedIsoScta());
                wsVgh50001().wsNsDeposito().set(hv50001Infhst().infhst().nsDeposito());
                wsVgh50001().wsTsMovimento().set(hv50001Infhst().infhst().tsMovimento());
                wsVgh50001().wsNsMovimento().set(hv50001Infhst().infhst().nsMovimento());
                wsVgh50001().wsZValMov().set(hv50001Infhst().infhst().zValMov());
                wsVgh50001().wsZMovLocl().set(hv50001Infhst().infhst().zMovLocl());
                wsVgh50001().wsIDbcr().set(hv50001Infhst().infhst().iDbcr());
                wsVgh50001().wsMMovimento().set(hv50001Infhst().infhst().mMovimento());
                wsVgh50001().wsIEstorno().set(hv50001Infhst().infhst().iEstorno());
                wsVgh50001().wsCMoedIsoOriMov().set(hv50001Infhst().infhst().cMoedIsoOriMov());
                wsVgh50001().wsMSldoCbloApos().set(hv50001Infhst().infhst().mSldoCbloApos());
                wsVgh50001().wsMSldoDpnlApos().set(hv50001Infhst().infhst().mSldoDpnlApos());
                wsVgh50001().wsMMovMoeOrigMov().set(hv50001Infhst().infhst().mMovMoeOrigMov());
                wsVgh50001().wsXRefMov().set(hv50001Infhst().infhst().xRefMov());
                wsVgh50001().wsNDocOpps().set(hv50001Infhst().infhst().nDocOpps());
                wsVgh50001().wsTJuro().set(hv50001Infhst().infhst().tJuro());
                wsVgh50001().wsAAplOrig().set(hv50001Infhst().infhst().aAplOrig());
                wsVgh50001().wsIExisInfAdi().set(hv50001Infhst().infhst().iExisInfAdi());
                wsVgh50001().wsXChavAcsInfAdi().set(hv50001Infhst().infhst().xChavAcsInfAdi());
                wsVgh50001().wsTsActzUlt().set(hv50001Infhst().infhst().tsActzUlt());
                wsVgh50001().wsCUsidActzUlt().set(hv50001Infhst().infhst().cUsidActzUlt());
                bghl500a().tabela().lista().get(wsInd).item().set(wsVgh50001());
                bghl500a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv50001Infhst().fetchMghs500a572() ;
                if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv50001Infhst().closeMghs500a615() ;
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
         * call to extracted method to access (OPEN) cursor C3
         */
        hv50001Infhst().openMghs500a627(wsNsMovMin, wsNsMovMax) ;
        if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C3
             */
            hv50001Infhst().fetchMghs500a639() ;
            if (hv50001Infhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv50001Infhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh50001().wsCPaisIsoaCont().set(hv50001Infhst().infhst().cPaisIsoaCont());
                wsVgh50001().wsCBancCont().set(hv50001Infhst().infhst().cBancCont());
                wsVgh50001().wsCOeEgcCont().set(hv50001Infhst().infhst().cOeEgcCont());
                wsVgh50001().wsNsRdclCont().set(hv50001Infhst().infhst().nsRdclCont());
                wsVgh50001().wsVChkdCont().set(hv50001Infhst().infhst().vChkdCont());
                wsVgh50001().wsCTipoCont().set(hv50001Infhst().infhst().cTipoCont());
                wsVgh50001().wsCMoedIsoScta().set(hv50001Infhst().infhst().cMoedIsoScta());
                wsVgh50001().wsNsDeposito().set(hv50001Infhst().infhst().nsDeposito());
                wsVgh50001().wsTsMovimento().set(hv50001Infhst().infhst().tsMovimento());
                wsVgh50001().wsNsMovimento().set(hv50001Infhst().infhst().nsMovimento());
                wsVgh50001().wsZValMov().set(hv50001Infhst().infhst().zValMov());
                wsVgh50001().wsZMovLocl().set(hv50001Infhst().infhst().zMovLocl());
                wsVgh50001().wsIDbcr().set(hv50001Infhst().infhst().iDbcr());
                wsVgh50001().wsMMovimento().set(hv50001Infhst().infhst().mMovimento());
                wsVgh50001().wsIEstorno().set(hv50001Infhst().infhst().iEstorno());
                wsVgh50001().wsCMoedIsoOriMov().set(hv50001Infhst().infhst().cMoedIsoOriMov());
                wsVgh50001().wsMSldoCbloApos().set(hv50001Infhst().infhst().mSldoCbloApos());
                wsVgh50001().wsMSldoDpnlApos().set(hv50001Infhst().infhst().mSldoDpnlApos());
                wsVgh50001().wsMMovMoeOrigMov().set(hv50001Infhst().infhst().mMovMoeOrigMov());
                wsVgh50001().wsXRefMov().set(hv50001Infhst().infhst().xRefMov());
                wsVgh50001().wsNDocOpps().set(hv50001Infhst().infhst().nDocOpps());
                /**
                 * MOVE VGH50001-T-JURO       TO WS-T-JURO
                 */
                wsVgh50001().wsAAplOrig().set(hv50001Infhst().infhst().aAplOrig());
                wsVgh50001().wsIExisInfAdi().set(hv50001Infhst().infhst().iExisInfAdi());
                wsVgh50001().wsXChavAcsInfAdi().set(hv50001Infhst().infhst().xChavAcsInfAdi());
                wsVgh50001().wsTsActzUlt().set(hv50001Infhst().infhst().tsActzUlt());
                wsVgh50001().wsCUsidActzUlt().set(hv50001Infhst().infhst().cUsidActzUlt());
                bghl500a().tabela().lista().get(wsInd).item().set(wsVgh50001());
                bghl500a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C3
                 */
                hv50001Infhst().fetchMghs500a728() ;
                if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C3
             */
            hv50001Infhst().closeMghs500a771() ;
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv50001Infhst().openMghs500a783(wsTsInicio, wsTsFim) ;
        if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv50001Infhst().fetchMghs500a795() ;
            if (hv50001Infhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv50001Infhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh50001().wsCPaisIsoaCont().set(hv50001Infhst().infhst().cPaisIsoaCont());
                wsVgh50001().wsCBancCont().set(hv50001Infhst().infhst().cBancCont());
                wsVgh50001().wsCOeEgcCont().set(hv50001Infhst().infhst().cOeEgcCont());
                wsVgh50001().wsNsRdclCont().set(hv50001Infhst().infhst().nsRdclCont());
                wsVgh50001().wsVChkdCont().set(hv50001Infhst().infhst().vChkdCont());
                wsVgh50001().wsCTipoCont().set(hv50001Infhst().infhst().cTipoCont());
                wsVgh50001().wsCMoedIsoScta().set(hv50001Infhst().infhst().cMoedIsoScta());
                wsVgh50001().wsNsDeposito().set(hv50001Infhst().infhst().nsDeposito());
                wsVgh50001().wsTsMovimento().set(hv50001Infhst().infhst().tsMovimento());
                wsVgh50001().wsNsMovimento().set(hv50001Infhst().infhst().nsMovimento());
                wsVgh50001().wsZValMov().set(hv50001Infhst().infhst().zValMov());
                wsVgh50001().wsZMovLocl().set(hv50001Infhst().infhst().zMovLocl());
                wsVgh50001().wsIDbcr().set(hv50001Infhst().infhst().iDbcr());
                wsVgh50001().wsMMovimento().set(hv50001Infhst().infhst().mMovimento());
                wsVgh50001().wsIEstorno().set(hv50001Infhst().infhst().iEstorno());
                wsVgh50001().wsCMoedIsoOriMov().set(hv50001Infhst().infhst().cMoedIsoOriMov());
                wsVgh50001().wsMSldoCbloApos().set(hv50001Infhst().infhst().mSldoCbloApos());
                wsVgh50001().wsMSldoDpnlApos().set(hv50001Infhst().infhst().mSldoDpnlApos());
                wsVgh50001().wsMMovMoeOrigMov().set(hv50001Infhst().infhst().mMovMoeOrigMov());
                wsVgh50001().wsXRefMov().set(hv50001Infhst().infhst().xRefMov());
                wsVgh50001().wsNDocOpps().set(hv50001Infhst().infhst().nDocOpps());
                /**
                 * MOVE VGH50001-T-JURO       TO WS-T-JURO
                 */
                wsVgh50001().wsAAplOrig().set(hv50001Infhst().infhst().aAplOrig());
                wsVgh50001().wsIExisInfAdi().set(hv50001Infhst().infhst().iExisInfAdi());
                wsVgh50001().wsXChavAcsInfAdi().set(hv50001Infhst().infhst().xChavAcsInfAdi());
                wsVgh50001().wsTsActzUlt().set(hv50001Infhst().infhst().tsActzUlt());
                wsVgh50001().wsCUsidActzUlt().set(hv50001Infhst().infhst().cUsidActzUlt());
                bghl500a().tabela().lista().get(wsInd).item().set(wsVgh50001());
                bghl500a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv50001Infhst().fetchMghs500a884() ;
                if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv50001Infhst().closeMghs500a927() ;
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        hv50001Infhst().openMghs500a939(wsNsMovMax, wsNsMovMin) ;
        if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv50001Infhst().fetchMghs500a951() ;
            if (hv50001Infhst().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
            }
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv50001Infhst().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh50001().wsCPaisIsoaCont().set(hv50001Infhst().infhst().cPaisIsoaCont());
                wsVgh50001().wsCBancCont().set(hv50001Infhst().infhst().cBancCont());
                wsVgh50001().wsCOeEgcCont().set(hv50001Infhst().infhst().cOeEgcCont());
                wsVgh50001().wsNsRdclCont().set(hv50001Infhst().infhst().nsRdclCont());
                wsVgh50001().wsVChkdCont().set(hv50001Infhst().infhst().vChkdCont());
                wsVgh50001().wsCTipoCont().set(hv50001Infhst().infhst().cTipoCont());
                wsVgh50001().wsCMoedIsoScta().set(hv50001Infhst().infhst().cMoedIsoScta());
                wsVgh50001().wsNsDeposito().set(hv50001Infhst().infhst().nsDeposito());
                wsVgh50001().wsTsMovimento().set(hv50001Infhst().infhst().tsMovimento());
                wsVgh50001().wsNsMovimento().set(hv50001Infhst().infhst().nsMovimento());
                wsVgh50001().wsZValMov().set(hv50001Infhst().infhst().zValMov());
                wsVgh50001().wsZMovLocl().set(hv50001Infhst().infhst().zMovLocl());
                wsVgh50001().wsIDbcr().set(hv50001Infhst().infhst().iDbcr());
                wsVgh50001().wsMMovimento().set(hv50001Infhst().infhst().mMovimento());
                wsVgh50001().wsIEstorno().set(hv50001Infhst().infhst().iEstorno());
                wsVgh50001().wsCMoedIsoOriMov().set(hv50001Infhst().infhst().cMoedIsoOriMov());
                wsVgh50001().wsMSldoCbloApos().set(hv50001Infhst().infhst().mSldoCbloApos());
                wsVgh50001().wsMSldoDpnlApos().set(hv50001Infhst().infhst().mSldoDpnlApos());
                wsVgh50001().wsMMovMoeOrigMov().set(hv50001Infhst().infhst().mMovMoeOrigMov());
                wsVgh50001().wsXRefMov().set(hv50001Infhst().infhst().xRefMov());
                wsVgh50001().wsNDocOpps().set(hv50001Infhst().infhst().nDocOpps());
                /**
                 * MOVE VGH50001-T-JURO       TO WS-T-JURO
                 */
                wsVgh50001().wsAAplOrig().set(hv50001Infhst().infhst().aAplOrig());
                wsVgh50001().wsIExisInfAdi().set(hv50001Infhst().infhst().iExisInfAdi());
                wsVgh50001().wsXChavAcsInfAdi().set(hv50001Infhst().infhst().xChavAcsInfAdi());
                wsVgh50001().wsTsActzUlt().set(hv50001Infhst().infhst().tsActzUlt());
                wsVgh50001().wsCUsidActzUlt().set(hv50001Infhst().infhst().cUsidActzUlt());
                bghl500a().tabela().lista().get(wsInd).item().set(wsVgh50001());
                bghl500a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv50001Infhst().fetchMghs500a1040() ;
                if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv50001Infhst().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv50001Infhst().closeMghs500a1083() ;
            if (hv50001Infhst().getPersistenceCode() != PersistenceCode.NORMAL) {
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
        bghl500a().cRetorno().set(progStatus);
        bghl500a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh50001 extends IDataStruct {
        
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
