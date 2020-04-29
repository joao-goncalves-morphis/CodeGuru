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
import cgd.gh.structures.link.Bghl022a ;
import cgd.gh.routines.Mghk800a ;
import cgd.gh.routines.Mghj801a ;
import cgd.gh.routines.Mghs802a ;


/**
 * 
 * ***    DECLARACAO DE CURSORES     ***
 * ASCENDENTE COM MONTANTES DE CRITERIO - DIA
 * ASCENDENTE SEM MONTANTES DE CRITERIO  - DIA
 * DESCENDENTES COM MONTANTES - DIA
 * DESCENDENTES SEM MONTANTES  - DIA
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        :  TGH00022_MOVDIAANT
 * DESCRICAO     :  LISTA REGISTOS DO DIA ANTERIOR
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS022A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs022a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl022a
     */
    @Data
    public abstract Bghl022a bghl022a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps02201Movdiaant
     */
    @Data
    protected abstract Vwsdghps02201Movdiaant hv02201Movdiaant() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    /**
     * @return instancia da classe Mghj801a
     */
    @Data
    protected abstract Mghj801a hrMghj801a() ;
    
    /**
     * @return instancia da classe Mghs802a
     */
    @Data
    protected abstract Mghs802a hrMghs802a() ;
    
    
    /**
     * Member Variables(Working Storage)
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
    @Condition("005")
    protected ICondition progDb2 ;
    
    
    @Data(size=2)
    protected IString wsCTipoTrttCont ;
    @Data
    @Condition("01")
    protected ICondition wsTrttDepOrdem ;
    @Data
    @Condition("02")
    protected ICondition wsTrttPoupanca ;
    @Data
    @Condition("03")
    protected ICondition wsTrttDepPrazo ;
    @Data
    @Condition("09")
    protected ICondition wsTrttDepEstru ;
    @Data
    @Condition("12")
    protected ICondition wsTrttDepObrig ;
    @Data
    @Condition("19")
    protected ICondition wsTrttCtaMarg ;
    @Data
    @Condition("26")
    protected ICondition wsTrttCashCarry ;
    @Data
    @Condition("27")
    protected ICondition wsTrttCtaVostr ;
    @Data
    @Condition("28")
    protected ICondition wsTrttCtaNostr ;
    @Data
    @Condition("32")
    protected ICondition wsTrttCtaInter ;
    
    
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
    
    @Data(size=10, decimal=7, signed=true, value="0")
    protected IDecimal wTJuro ;
    
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
    
    
    @Data(size=2, value="GH")
    protected IString wsAplHst ;
    
    @Data(size=8, value="MHYJ100A")
    protected IString wsModMhyj100a ;
    
    @Data(size=1, value="1")
    protected IInt wsConTabMov1 ;
    
    @Data(size=1, value="2")
    protected IInt wsConTabMov2 ;
    
    /**
     * @return instancia da classe local WsVariaveisCrt
     */
    @Data
    protected abstract WsVariaveisCrt wsVariaveisCrt() ;
    
    @Data(size=8, value="MGHK800A")
    protected IString mgh800aCRotina ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString mghj801aCRotina ;
    
    @Data(size=1, value=" ")
    protected IString wsCrit1 ;
    
    @Data(size=1, value=" ")
    protected IString wsCrit2 ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMMovMin ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMMovMax ;
    
    /**
     * @return instancia da classe local WTsInicio
     */
    @Data
    protected abstract WTsInicio wTsInicio() ;
    
    /**
     * @return instancia da classe local WTsFim
     */
    @Data
    protected abstract WTsFim wTsFim() ;
    
    @Data(size=26, value=" ")
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WsVgh02201
     */
    @Data
    protected abstract WsVgh02201 wsVgh02201() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl022a().cRetorno().initialize() ;
        bghl022a().cSqlcode().initialize() ;
        if (bghl022a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl022a().argumento().cBancCont().isEqual(0) || 
            bghl022a().argumento().cOeEgcCont().isEqual(0) || 
            bghl022a().argumento().nsRdclCont().isEqual(0) || 
            bghl022a().argumento().cMoedIsoScta().isEmpty() || 
            bghl022a().criterioConsulta().iCriterioCns().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            bghl022a().aAplErr().set(wsAplHst);
        }
        if (progOk.isTrue()) {
            if (!bghl022a().criterioConsulta().ascendente().isTrue() && !bghl022a().criterioConsulta().descendente().isTrue()) {
                progDadosInvalidos.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
        if (progOk.isTrue()) {
            if (bghl022a().criterioMontante().mMovMax().isEqual(0) && 
                bghl022a().criterioMontante().mMovMin().isEqual(0)) {
                naoHaCritMontantes.setTrue() ;
            } else {
                haCritMontantes.setTrue() ;
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
        if (bghl022a().criterioConsulta().ascendente().isTrue()) {
            if (haCritMontantes.isTrue()) {
                a5200ListaAscMont() ;
            } else {
                a5300ListaAsc() ;
            }
        } else if (bghl022a().criterioConsulta().descendente().isTrue()) {
            if (haCritMontantes.isTrue()) {
                a5400ListaDscMont() ;
            } else {
                a5500ListaDsc() ;
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
        hv02201Movdiaant().movdiaant().initialize() ;
        hv02201Movdiaant().movdiaant().cPaisIsoaCont().set(bghl022a().argumento().cPaisIsoaCont());
        hv02201Movdiaant().movdiaant().cBancCont().set(bghl022a().argumento().cBancCont());
        hv02201Movdiaant().movdiaant().cOeEgcCont().set(bghl022a().argumento().cOeEgcCont());
        hv02201Movdiaant().movdiaant().nsRdclCont().set(bghl022a().argumento().nsRdclCont());
        hv02201Movdiaant().movdiaant().vChkdCont().set(bghl022a().argumento().vChkdCont());
        hv02201Movdiaant().movdiaant().cTipoCont().set(bghl022a().argumento().cTipoCont());
        hv02201Movdiaant().movdiaant().cMoedIsoScta().set(bghl022a().argumento().cMoedIsoScta());
        hv02201Movdiaant().movdiaant().nsDeposito().set(bghl022a().argumento().nsDeposito());
        hv02201Movdiaant().movdiaant().nsMovimento().set(bghl022a().argumento().nsMovimento());
        if (bghl022a().criterioConsulta().descendente().isTrue()) {
            if (bghl022a().argumento().nsMovimento().isEqual(0)) {
                hv02201Movdiaant().movdiaant().nsMovimento().set(9);
            }
        }
        if (haCritMontantes.isTrue()) {
            wsMMovMin.set(bghl022a().criterioMontante().mMovMin());
            wsMMovMax.set(bghl022a().criterioMontante().mMovMax());
        }
        if (bghl022a().criterioDbcr().ambos().isTrue()) {
            wsCrit1.set(wsVariaveisCrt().conDebito());
            wsCrit2.set(wsVariaveisCrt().conCredito());
        } else if (bghl022a().criterioDbcr().debito().isTrue()) {
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
    public void a5200ListaAscMont() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv02201Movdiaant().openMghs022a670(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2) ;
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            bghl022a().aAplErr().set(wsAplHst);
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C1
             */
            hv02201Movdiaant().fetchMghs022a683() ;
            if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
                bghl022a().aAplErr().set(wsAplHst);
                progNaoExisteMov.setTrue() ;
            }
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                bghl022a().aAplErr().set(wsAplHst);
                progDb2.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02201().wsCPaisIsoaCont().set(hv02201Movdiaant().movdiaant().cPaisIsoaCont());
                wsVgh02201().wsCBancCont().set(hv02201Movdiaant().movdiaant().cBancCont());
                wsVgh02201().wsCOeEgcCont().set(hv02201Movdiaant().movdiaant().cOeEgcCont());
                wsVgh02201().wsNsRdclCont().set(hv02201Movdiaant().movdiaant().nsRdclCont());
                wsVgh02201().wsVChkdCont().set(hv02201Movdiaant().movdiaant().vChkdCont());
                wsVgh02201().wsCTipoCont().set(hv02201Movdiaant().movdiaant().cTipoCont());
                wsVgh02201().wsCMoedIsoScta().set(hv02201Movdiaant().movdiaant().cMoedIsoScta());
                wsVgh02201().wsNsDeposito().set(hv02201Movdiaant().movdiaant().nsDeposito());
                wsVgh02201().wsZMovimento().set(hv02201Movdiaant().movdiaant().zMovimento());
                wsVgh02201().wsNsMovimento().set(hv02201Movdiaant().movdiaant().nsMovimento());
                wsVgh02201().wsZValMov().set(hv02201Movdiaant().movdiaant().zValor());
                wsVgh02201().wsIDbcr().set(hv02201Movdiaant().movdiaant().iDbcr());
                wsVgh02201().wsMMovimento().set(hv02201Movdiaant().movdiaant().mMovimento());
                wsVgh02201().wsIEstorno().set(hv02201Movdiaant().movdiaant().iEstorno());
                wsVgh02201().wsCMoedIsoOriMov().set(hv02201Movdiaant().movdiaant().cMoedIsoOriMov());
                wsVgh02201().wsMSldoCbloApos().set(hv02201Movdiaant().movdiaant().mSldoCblo());
                wsVgh02201().wsMSldoDpnlApos().set(subtract(wsVgh02201().wsMSldoCbloApos(), add(hv02201Movdiaant().movdiaant().mSldoRetd(), hv02201Movdiaant().movdiaant().mSldoVcob())));
                wsVgh02201().wsMMovMoeOrigMov().set(hv02201Movdiaant().movdiaant().mMovMoeOrigMov());
                wsVgh02201().wsXRefMov().set(hv02201Movdiaant().movdiaant().xRefMov());
                if (wsVgh02201().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wTJuro.set(0);
                    a9300ObtemTaxa() ;
                    if (wTJuro.isGreater(0)) {
                        wsVgh02201().wsTJuro().set(wTJuro);
                    }
                }
                wsVgh02201().wsNDocOpps().set(hv02201Movdiaant().movdiaant().nCheque());
                wsVgh02201().wsAAplOrig().set(hv02201Movdiaant().movdiaant().aAplicacao());
                wsVgh02201().wsIExisInfAdi().set("N");
                wsVgh02201().wsXChavAcsInfAdi().set(" ");
                wsVgh02201().wsTsActzUlt().set(hv02201Movdiaant().movdiaant().tsActzUlt());
                wsVgh02201().wsCUsidActzUlt().set(hv02201Movdiaant().movdiaant().cUsidActzUlt());
                bghl022a().tabela().lista().get(wsInd).item().set(wsVgh02201());
                bghl022a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C1
                 */
                hv02201Movdiaant().fetchMghs022a759() ;
                if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                    bghl022a().aAplErr().set(wsAplHst);
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C1
             */
            hv02201Movdiaant().closeMghs022a778() ;
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300ListaAsc() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C2
         */
        hv02201Movdiaant().openMghs022a791(wsCrit1, wsCrit2) ;
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl022a().aAplErr().set(wsAplHst);
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C2
             */
            hv02201Movdiaant().fetchMghs022a804() ;
            if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02201().wsCPaisIsoaCont().set(hv02201Movdiaant().movdiaant().cPaisIsoaCont());
                wsVgh02201().wsCBancCont().set(hv02201Movdiaant().movdiaant().cBancCont());
                wsVgh02201().wsCOeEgcCont().set(hv02201Movdiaant().movdiaant().cOeEgcCont());
                wsVgh02201().wsNsRdclCont().set(hv02201Movdiaant().movdiaant().nsRdclCont());
                wsVgh02201().wsVChkdCont().set(hv02201Movdiaant().movdiaant().vChkdCont());
                wsVgh02201().wsCTipoCont().set(hv02201Movdiaant().movdiaant().cTipoCont());
                wsVgh02201().wsCMoedIsoScta().set(hv02201Movdiaant().movdiaant().cMoedIsoScta());
                wsVgh02201().wsNsDeposito().set(hv02201Movdiaant().movdiaant().nsDeposito());
                wsVgh02201().wsZMovimento().set(hv02201Movdiaant().movdiaant().zMovimento());
                wsVgh02201().wsNsMovimento().set(hv02201Movdiaant().movdiaant().nsMovimento());
                wsVgh02201().wsZValMov().set(hv02201Movdiaant().movdiaant().zValor());
                wsVgh02201().wsIDbcr().set(hv02201Movdiaant().movdiaant().iDbcr());
                wsVgh02201().wsMMovimento().set(hv02201Movdiaant().movdiaant().mMovimento());
                wsVgh02201().wsIEstorno().set(hv02201Movdiaant().movdiaant().iEstorno());
                wsVgh02201().wsCMoedIsoOriMov().set(hv02201Movdiaant().movdiaant().cMoedIsoOriMov());
                wsVgh02201().wsMSldoCbloApos().set(hv02201Movdiaant().movdiaant().mSldoCblo());
                wsVgh02201().wsMSldoDpnlApos().set(subtract(wsVgh02201().wsMSldoCbloApos(), add(hv02201Movdiaant().movdiaant().mSldoRetd(), hv02201Movdiaant().movdiaant().mSldoVcob())));
                wsVgh02201().wsMMovMoeOrigMov().set(hv02201Movdiaant().movdiaant().mMovMoeOrigMov());
                wsVgh02201().wsXRefMov().set(hv02201Movdiaant().movdiaant().xRefMov());
                if (wsVgh02201().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wTJuro.set(0);
                    a9300ObtemTaxa() ;
                    if (wTJuro.isGreater(0)) {
                        wsVgh02201().wsTJuro().set(wTJuro);
                    }
                }
                wsVgh02201().wsNDocOpps().set(hv02201Movdiaant().movdiaant().nCheque());
                wsVgh02201().wsAAplOrig().set(hv02201Movdiaant().movdiaant().aAplicacao());
                wsVgh02201().wsIExisInfAdi().set("N");
                wsVgh02201().wsXChavAcsInfAdi().set(" ");
                wsVgh02201().wsTsActzUlt().set(hv02201Movdiaant().movdiaant().tsActzUlt());
                wsVgh02201().wsCUsidActzUlt().set(hv02201Movdiaant().movdiaant().cUsidActzUlt());
                bghl022a().tabela().lista().get(wsInd).item().set(wsVgh02201());
                bghl022a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C2
                 */
                hv02201Movdiaant().fetchMghs022a878() ;
                if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                    bghl022a().aAplErr().set(wsAplHst);
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C2
             */
            hv02201Movdiaant().closeMghs022a897() ;
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400ListaDscMont() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv02201Movdiaant().openMghs022a910(wsMMovMin, wsMMovMax, wsCrit1, wsCrit2) ;
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl022a().aAplErr().set(wsAplHst);
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C3
             */
            hv02201Movdiaant().fetchMghs022a923() ;
            if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02201().wsCPaisIsoaCont().set(hv02201Movdiaant().movdiaant().cPaisIsoaCont());
                wsVgh02201().wsCBancCont().set(hv02201Movdiaant().movdiaant().cBancCont());
                wsVgh02201().wsCOeEgcCont().set(hv02201Movdiaant().movdiaant().cOeEgcCont());
                wsVgh02201().wsNsRdclCont().set(hv02201Movdiaant().movdiaant().nsRdclCont());
                wsVgh02201().wsVChkdCont().set(hv02201Movdiaant().movdiaant().vChkdCont());
                wsVgh02201().wsCTipoCont().set(hv02201Movdiaant().movdiaant().cTipoCont());
                wsVgh02201().wsCMoedIsoScta().set(hv02201Movdiaant().movdiaant().cMoedIsoScta());
                wsVgh02201().wsNsDeposito().set(hv02201Movdiaant().movdiaant().nsDeposito());
                wsVgh02201().wsZMovimento().set(hv02201Movdiaant().movdiaant().zMovimento());
                wsVgh02201().wsNsMovimento().set(hv02201Movdiaant().movdiaant().nsMovimento());
                wsVgh02201().wsZValMov().set(hv02201Movdiaant().movdiaant().zValor());
                wsVgh02201().wsIDbcr().set(hv02201Movdiaant().movdiaant().iDbcr());
                wsVgh02201().wsMMovimento().set(hv02201Movdiaant().movdiaant().mMovimento());
                wsVgh02201().wsIEstorno().set(hv02201Movdiaant().movdiaant().iEstorno());
                wsVgh02201().wsCMoedIsoOriMov().set(hv02201Movdiaant().movdiaant().cMoedIsoOriMov());
                wsVgh02201().wsMSldoCbloApos().set(hv02201Movdiaant().movdiaant().mSldoCblo());
                wsVgh02201().wsMSldoDpnlApos().set(subtract(wsVgh02201().wsMSldoCbloApos(), add(hv02201Movdiaant().movdiaant().mSldoRetd(), hv02201Movdiaant().movdiaant().mSldoVcob())));
                wsVgh02201().wsMMovMoeOrigMov().set(hv02201Movdiaant().movdiaant().mMovMoeOrigMov());
                wsVgh02201().wsXRefMov().set(hv02201Movdiaant().movdiaant().xRefMov());
                if (wsVgh02201().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wTJuro.set(0);
                    a9300ObtemTaxa() ;
                    if (wTJuro.isGreater(0)) {
                        wsVgh02201().wsTJuro().set(wTJuro);
                    }
                }
                wsVgh02201().wsNDocOpps().set(hv02201Movdiaant().movdiaant().nCheque());
                wsVgh02201().wsAAplOrig().set(hv02201Movdiaant().movdiaant().aAplicacao());
                wsVgh02201().wsIExisInfAdi().set("N");
                wsVgh02201().wsXChavAcsInfAdi().set(" ");
                wsVgh02201().wsTsActzUlt().set(hv02201Movdiaant().movdiaant().tsActzUlt());
                wsVgh02201().wsCUsidActzUlt().set(hv02201Movdiaant().movdiaant().cUsidActzUlt());
                bghl022a().tabela().lista().get(wsInd).item().set(wsVgh02201());
                bghl022a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C3
                 */
                hv02201Movdiaant().fetchMghs022a997() ;
                if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                    bghl022a().aAplErr().set(wsAplHst);
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C3
             */
            hv02201Movdiaant().closeMghs022a1016() ;
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500ListaDsc() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C4
         */
        hv02201Movdiaant().openMghs022a1029(wsCrit1, wsCrit2) ;
        if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl022a().aAplErr().set(wsAplHst);
        }
        if (progOk.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (FETCH) cursor C4
             */
            hv02201Movdiaant().fetchMghs022a1042() ;
            if (hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
        if (progOk.isTrue()) {
            for (wsInd.set(1); hv02201Movdiaant().getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(13); wsInd.add(1)) {
                wsVgh02201().wsCPaisIsoaCont().set(hv02201Movdiaant().movdiaant().cPaisIsoaCont());
                wsVgh02201().wsCBancCont().set(hv02201Movdiaant().movdiaant().cBancCont());
                wsVgh02201().wsCOeEgcCont().set(hv02201Movdiaant().movdiaant().cOeEgcCont());
                wsVgh02201().wsNsRdclCont().set(hv02201Movdiaant().movdiaant().nsRdclCont());
                wsVgh02201().wsVChkdCont().set(hv02201Movdiaant().movdiaant().vChkdCont());
                wsVgh02201().wsCTipoCont().set(hv02201Movdiaant().movdiaant().cTipoCont());
                wsVgh02201().wsCMoedIsoScta().set(hv02201Movdiaant().movdiaant().cMoedIsoScta());
                wsVgh02201().wsNsDeposito().set(hv02201Movdiaant().movdiaant().nsDeposito());
                wsVgh02201().wsZMovimento().set(hv02201Movdiaant().movdiaant().zMovimento());
                wsVgh02201().wsNsMovimento().set(hv02201Movdiaant().movdiaant().nsMovimento());
                wsVgh02201().wsZValMov().set(hv02201Movdiaant().movdiaant().zValor());
                wsVgh02201().wsIDbcr().set(hv02201Movdiaant().movdiaant().iDbcr());
                wsVgh02201().wsMMovimento().set(hv02201Movdiaant().movdiaant().mMovimento());
                wsVgh02201().wsIEstorno().set(hv02201Movdiaant().movdiaant().iEstorno());
                wsVgh02201().wsCMoedIsoOriMov().set(hv02201Movdiaant().movdiaant().cMoedIsoOriMov());
                wsVgh02201().wsMSldoCbloApos().set(hv02201Movdiaant().movdiaant().mSldoCblo());
                wsVgh02201().wsMSldoDpnlApos().set(subtract(wsVgh02201().wsMSldoCbloApos(), add(hv02201Movdiaant().movdiaant().mSldoRetd(), hv02201Movdiaant().movdiaant().mSldoVcob())));
                wsVgh02201().wsMMovMoeOrigMov().set(hv02201Movdiaant().movdiaant().mMovMoeOrigMov());
                wsVgh02201().wsXRefMov().set(hv02201Movdiaant().movdiaant().xRefMov());
                if (wsVgh02201().wsXRefMov().isEmpty()) {
                    a9100ObtemDescritivo() ;
                } else {
                    a9200VerificaContaHo() ;
                }
                if (wsTrttPoupanca.isTrue() || wsTrttDepPrazo.isTrue()) {
                    wTJuro.set(0);
                    a9300ObtemTaxa() ;
                    if (wTJuro.isGreater(0)) {
                        wsVgh02201().wsTJuro().set(wTJuro);
                    }
                }
                wsVgh02201().wsNDocOpps().set(hv02201Movdiaant().movdiaant().nCheque());
                wsVgh02201().wsAAplOrig().set(hv02201Movdiaant().movdiaant().aAplicacao());
                wsVgh02201().wsIExisInfAdi().set("N");
                wsVgh02201().wsXChavAcsInfAdi().set(" ");
                wsVgh02201().wsTsActzUlt().set(hv02201Movdiaant().movdiaant().tsActzUlt());
                wsVgh02201().wsCUsidActzUlt().set(hv02201Movdiaant().movdiaant().cUsidActzUlt());
                bghl022a().tabela().lista().get(wsInd).item().set(wsVgh02201());
                bghl022a().qItens().set(wsInd);
                /**
                 * Migration Note:
                 * call to extracted method to access (FETCH) cursor C4
                 */
                hv02201Movdiaant().fetchMghs022a1116() ;
                if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL && 
                    hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NOTFND) {
                    progDb2.setTrue() ;
                    bghl022a().aAplErr().set(wsAplHst);
                }
            }
        }
        if (progOk.isTrue() || progNaoExisteMov.isTrue()) {
            /**
             * Migration Note:
             * call to extracted method to access (CLOSE) cursor C4
             */
            hv02201Movdiaant().closeMghs022a1135() ;
            if (hv02201Movdiaant().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                bghl022a().aAplErr().set(wsAplHst);
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a9100ObtemDescritivo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghk800a().bghl800a().initialize() ;
        hrMghk800a().bghl800a().input().cPaisIsoaCont().set(bghl022a().argumento().cPaisIsoaCont());
        hrMghk800a().bghl800a().input().cBancCont().set(bghl022a().argumento().cBancCont());
        hrMghk800a().bghl800a().input().cOeEgcCont().set(bghl022a().argumento().cOeEgcCont());
        hrMghk800a().bghl800a().input().nsRdclCont().set(bghl022a().argumento().nsRdclCont());
        hrMghk800a().bghl800a().input().vChkdCont().set(bghl022a().argumento().vChkdCont());
        hrMghk800a().bghl800a().input().cTipoCont().set(bghl022a().argumento().cTipoCont());
        hrMghk800a().bghl800a().input().cMoedIsoScta().set(bghl022a().argumento().cMoedIsoScta());
        hrMghk800a().bghl800a().input().nsDeposito().set(bghl022a().argumento().nsDeposito());
        hrMghk800a().bghl800a().input().iDbcr().set(hv02201Movdiaant().movdiaant().iDbcr());
        hrMghk800a().bghl800a().input().iEstorno().set(hv02201Movdiaant().movdiaant().iEstorno());
        hrMghk800a().bghl800a().input().zValMov().set(hv02201Movdiaant().movdiaant().zValor());
        hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hv02201Movdiaant().movdiaant().cPaisIsoaOeOpx());
        hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hv02201Movdiaant().movdiaant().cMnemEgcOpex());
        hrMghk800a().bghl800a().input().cOeEgcOpex().set(hv02201Movdiaant().movdiaant().cOeEgcOpex());
        hrMghk800a().bghl800a().input().cOpeBbn().set(hv02201Movdiaant().movdiaant().cOpeBbn());
        hrMghk800a().run() ;
        if (hrMghk800a().bghl800a().ok().isTrue()) {
            wsVgh02201().wsXRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
            wsCTipoTrttCont.set(hrMghk800a().bghl800a().output().cTipoTrttCont());
        } else {
            wsVgh02201().wsXRefMov().set(" ");
            wsCTipoTrttCont.set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    public void a9200VerificaContaHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghj801a().bghl801a().initialize() ;
        hrMghj801a().bghl801a().iDadosSubcontaN().setTrue() ;
        hrMghj801a().bghl801a().argumento().cPaisIsoaCont().set(bghl022a().argumento().cPaisIsoaCont());
        hrMghj801a().bghl801a().argumento().cBancCont().set(bghl022a().argumento().cBancCont());
        hrMghj801a().bghl801a().argumento().cOeEgcCont().set(bghl022a().argumento().cOeEgcCont());
        hrMghj801a().bghl801a().argumento().nsRdclCont().set(bghl022a().argumento().nsRdclCont());
        hrMghj801a().bghl801a().argumento().vChkdCont().set(bghl022a().argumento().vChkdCont());
        hrMghj801a().bghl801a().argumento().cTipoCont().set(bghl022a().argumento().cTipoCont());
        hrMghj801a().bghl801a().argumento().cMoedIsoScta().set(bghl022a().argumento().cMoedIsoScta());
        hrMghj801a().bghl801a().argumento().nsDeposito().set(bghl022a().argumento().nsDeposito());
        if (hv02201Movdiaant().movdiaant().iEstorno().isEqual("E")) {
            if (hv02201Movdiaant().movdiaant().iDbcr().isEqual("C")) {
                hrMghj801a().bghl801a().argumento().iDbcr().set("D");
            } else {
                hrMghj801a().bghl801a().argumento().iDbcr().set("C");
            }
        } else {
            hrMghj801a().bghl801a().argumento().iDbcr().set(hv02201Movdiaant().movdiaant().iDbcr());
        }
        hrMghj801a().run() ;
        if (hrMghj801a().bghl801a().ok().isTrue()) {
            wsCTipoTrttCont.set(hrMghj801a().bghl801a().detalhe().cTipoTrttCont());
        } else {
            wsCTipoTrttCont.set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    public void a9300ObtemTaxa() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs802a().bghl802a().initialize() ;
        hrMghs802a().bghl802a().argumento().cPaisIsoaCont().set(bghl022a().argumento().cPaisIsoaCont());
        hrMghs802a().bghl802a().argumento().cBancCont().set(bghl022a().argumento().cBancCont());
        hrMghs802a().bghl802a().argumento().cOeEgcCont().set(bghl022a().argumento().cOeEgcCont());
        hrMghs802a().bghl802a().argumento().nsRdclCont().set(bghl022a().argumento().nsRdclCont());
        hrMghs802a().bghl802a().argumento().vChkdCont().set(bghl022a().argumento().vChkdCont());
        hrMghs802a().bghl802a().argumento().cTipoCont().set(bghl022a().argumento().cTipoCont());
        hrMghs802a().bghl802a().argumento().cMoedIsoScta().set(bghl022a().argumento().cMoedIsoScta());
        hrMghs802a().bghl802a().argumento().nsDeposito().set(bghl022a().argumento().nsDeposito());
        hrMghs802a().bghl802a().argumento().nsMovimento().set(hv02201Movdiaant().movdiaant().nsMovimento());
        hrMghs802a().run() ;
        if (hrMghs802a().bghl802a().ok().isTrue()) {
            wsVgh02201().wsTJuro().set(hrMghs802a().bghl802a().detalhe().tJuro());
        } else {
            wsVgh02201().wsTJuro().set(0);
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
        bghl022a().cRetorno().set(progStatus);
        bghl022a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsVgh02201 extends IDataStruct {
        
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
        
        @Data(size=10)
        IString wsZMovimento() ;
        
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
