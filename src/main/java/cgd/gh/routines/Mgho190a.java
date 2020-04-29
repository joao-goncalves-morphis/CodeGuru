package cgd.gh.routines;

import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.link.Bghl190a ;
import cgd.gh.routines.Mghs001a ;
import cgd.gh.online.Pgho090a ;
import cgd.ho.routines.Mhoj710a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : LISTA DETALHE DOS MOVIMENTOS DE UMA SUBCONTA
 * ----->  ESTE PROGRAMA DESTINA-SE AO CANAIS SIBS E ATS <---
 * 
 * migrated from program [MGHO190A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mgho190a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl190a
     */
    @Data
    public abstract Bghl190a bghl190a() ;
    
    
    /**
     * Handled Services
     */
    /**
     * @return instancia da classe Pgho090a
     */
    protected abstract Pgho090a hoPgho090a() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs001a
     */
    @Data
    protected abstract Mghs001a hrMghs001a() ;
    
    /**
     * @return instancia da classe Mhoj710a
     */
    @Data
    protected abstract Mhoj710a hrMhoj710a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    /**
     * ***     AREAS DE TRABALHO COMUM    ***
     */
    @Data(size=3, signed=true)
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
    @Condition("080")
    protected ICondition progNaoExisteConta ;
    @Data
    @Condition("091")
    protected ICondition progDataMinInv ;
    @Data
    @Condition("092")
    protected ICondition progDataMaxInv ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    @Data
    @Condition("211")
    protected ICondition progAcesso ;
    
    
    protected static final String WS_APL_HST = "GH" ;
    
    protected static final String WS_ERR_FUNC = "FU" ;
    
    protected static final String WS_ERRO = "A1" ;
    
    protected static final String WS_ERR_DB2 = "A2" ;
    
    @Data(size=2, value="0")
    protected IInt wsQItens ;
    
    @Data(size=9, signed=true, value="0", compression=COMP3)
    protected ILong wsCSqlcode ;
    
    @Data(size=8, value=" ")
    protected IString wsNmPrograma ;
    
    @Data(size=8, value="VGH00201")
    protected IString wsNmRecurso ;
    
    @Data(size=1, value=" ")
    protected IString wsCrtMais ;
    @Data
    @Condition("1")
    protected ICondition naoHaMais ;
    @Data
    @Condition("2")
    protected ICondition haMais ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtSair ;
    @Data
    @Condition("S")
    protected ICondition sair ;
    @Data
    @Condition("N")
    protected ICondition naoSair ;
    
    
    @Data(size=2, value="0")
    protected IInt wsLimite ;
    
    @Data(size=2, value="0")
    protected IInt wsMovFalta ;
    
    @Data(size=2, value="0")
    protected IInt wIndice ;
    
    @Data(size=2, value="0")
    protected IInt wIndAlo ;
    
    @Data(size=2, value="0")
    protected IInt wsQMov ;
    
    @Data(size=2, value="0")
    protected IInt wsTotEnvr ;
    
    @Data(size=1)
    protected IString wsCrtlMov ;
    @Data
    @Condition("1")
    protected ICondition haMov ;
    @Data
    @Condition("2")
    protected ICondition naoHaMov ;
    
    
    @Data(size=1)
    protected IString wsControlo ;
    @Data
    @Condition("A")
    protected ICondition primeiraVez ;
    @Data
    @Condition("B")
    protected ICondition segundaVez ;
    
    
    @Data(size=8, value="0")
    protected ILong dataCorrente ;
    
    /**
     * @return instancia da classe local DataCorrenteMask
     */
    @Data
    @Mask
    protected abstract DataCorrenteMask dataCorrenteMask() ;
    
    @Data(size=8, value="0")
    protected ILong dataNum ;
    
    /**
     * @return instancia da classe local WsTsMin
     */
    @Data
    protected abstract WsTsMin wsTsMin() ;
    
    /**
     * @return instancia da classe local WsTsMax
     */
    @Data
    protected abstract WsTsMax wsTsMax() ;
    
    /**
     * @return instancia da classe local WsTabelaMovimento
     */
    @Data
    protected abstract WsTabelaMovimento wsTabelaMovimento() ;
    
    
    
    /**
     * 
     * 
     */
    public void s10000Iniciar() {
        /**
         * *----------------------------------------------------------------*
         */
        hoPgho090a().msgIn().msg().initialize() ;
        hoPgho090a().msgOut().msg().initialize() ;
        wsTabelaMovimento().initialize() ;
        bghl190a().dadosOutput().initialize() ;
        progOk.setTrue() ;
    }
    
    /**
     * 
     * 
     */
    public void s30000Validar() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl190a().dadosInput().conta().cPaisIsoaCont().isEmpty() || 
            bghl190a().dadosInput().conta().cBancCont().isEqual(0) || 
            bghl190a().dadosInput().conta().cOeEgcCont().isEqual(0) || 
            bghl190a().dadosInput().conta().nsRdclCont().isEqual(0) || 
            bghl190a().dadosInput().conta().cMoedIsoScta().isEmpty() || 
            bghl190a().dadosInput().movimento().qMovRtno().isEqual(0) || 
            bghl190a().dadosInput().criterioConsulta().iCriterioCns().isEmpty() || 
            bghl190a().dadosInput().movimento().qMovRtno().isGreater(30)) {
            progDadosInvalidos.setTrue() ;
            bghl190a().dadosOutput().aAplErr().set(WS_APL_HST);
            bghl190a().dadosOutput().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            wsMovFalta.set(bghl190a().dadosInput().movimento().qMovRtno());
            haMais.setTrue() ;
            wIndice.set(1);
            wsQMov.set(1);
            wIndAlo.set(1);
            wsTotEnvr.set(0);
        }
    }
    
    /**
     * 
     * 
     */
    public void s50000Processar() {
        primeiraVez.setTrue() ;
        while (!naoHaMais.isTrue() && !wsMovFalta.isEqual(0) && progOk.isTrue()) {
            a51000ObtemMov() ;
        }
        if (progOk.isTrue()) {
            a52000DescarregaTabela() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a51000ObtemMov() {
        /**
         * *----------------------------------------------------------------*
         */
        hoPgho090a().msgIn().msg().ade().cPaisIsoaCont().set(bghl190a().dadosInput().conta().cPaisIsoaCont());
        hoPgho090a().msgIn().msg().ade().cBancCont().set(bghl190a().dadosInput().conta().cBancCont());
        hoPgho090a().msgIn().msg().ade().cOeEgcCont().set(bghl190a().dadosInput().conta().cOeEgcCont());
        hoPgho090a().msgIn().msg().ade().nsRdclCont().set(bghl190a().dadosInput().conta().nsRdclCont());
        hoPgho090a().msgIn().msg().ade().vChkdCont().set(bghl190a().dadosInput().conta().vChkdCont());
        hoPgho090a().msgIn().msg().ade().cTipoCont().set(bghl190a().dadosInput().conta().cTipoCont());
        hoPgho090a().msgIn().msg().ade().cMoedIsoScta().set(bghl190a().dadosInput().conta().cMoedIsoScta());
        hoPgho090a().msgIn().msg().ade().nsDeposito().set(bghl190a().dadosInput().conta().nsDeposito());
        hoPgho090a().msgIn().msg().ade().nsMovimento().set(bghl190a().dadosInput().keyContz().nsMovimento());
        hoPgho090a().msgIn().msg().ade().iConsulta().set(bghl190a().dadosInput().criterioConsulta().iCriterioCns());
        hoPgho090a().msgIn().msg().ade().semNmCli().setTrue() ;
        if (bghl190a().dadosInput().keyContz().tsMovimento().isEmpty()) {
            if (bghl190a().dadosInput().movimento().zFim().isEmpty() || 
                bghl190a().dadosInput().movimento().zFim().isEqual("0001-01-01")) {
                dataCorrente.set(getTime("yyyyMMdd"));
                wsTsMin().wDataTsMin().wAnoMin().set(dataCorrenteMask().anoCorrente());
                wsTsMin().wDataTsMin().wMesMin().set(dataCorrenteMask().mesCorrente());
                wsTsMin().wDataTsMin().wDiaMin().set(dataCorrenteMask().diaCorrente());
                bghl190a().dadosInput().movimento().zFim().set(wsTsMin().wDataTsMin());
            }
            wsTsMax().wDataTsMax().set(bghl190a().dadosInput().movimento().zFim());
        } else {
            wsTsMax().set(bghl190a().dadosInput().keyContz().tsMovimento());
        }
        if (bghl190a().dadosInput().movimento().zInicio().isEmpty() || 
            bghl190a().dadosInput().movimento().zInicio().isEqual("0001-01-01")) {
            a51100ObtemDataInicio() ;
        }
        wsTsMin().wDataTsMin().set(bghl190a().dadosInput().movimento().zInicio());
        if (hoPgho090a().msgIn().msg().ade().ascendente().isTrue()) {
            hoPgho090a().msgIn().msg().ade().tsMovimento().set(wsTsMin());
            hoPgho090a().msgIn().msg().ade().tsMovMax().set(wsTsMax());
        } else {
            hoPgho090a().msgIn().msg().ade().tsMovMax().set(wsTsMin());
            hoPgho090a().msgIn().msg().ade().tsMovimento().set(wsTsMax());
        }
        hoPgho090a().run() ;
        if (hoPgho090a().envOut.errosGraves().cRtnoEvenSwal().isEqual(97)) {
            if (primeiraVez.isTrue()) {
                progStatus.set(hoPgho090a().envOut.errosGraves().cRtnoEvenSwal());
            } else {
                naoHaMais.setTrue() ;
            }
        }
        if (!hoPgho090a().envOut.errosGraves().cRtnoEvenSwal().isEqual(97) && 
            !hoPgho090a().envOut.errosGraves().semErros().isTrue() && !hoPgho090a().envOut.errosGraves().fimConsulta().isTrue()) {
            progStatus.set(hoPgho090a().envOut.errosGraves().cRtnoEvenSwal());
        }
        if (!progOk.isTrue()) {
            bghl190a().dadosOutput().cTipoErroBbn().set(hoPgho090a().envOut.errosGraves().cTipoErroBbn());
            bghl190a().dadosOutput().aAplErr().set(hoPgho090a().envOut.errosGraves().aAplErr());
        }
        if (hoPgho090a().envOut.errosGraves().semErros().isTrue() || hoPgho090a().envOut.errosGraves().fimConsulta().isTrue()) {
            if (segundaVez.isTrue()) {
                wIndAlo.subtract(1);
            }
            for (hoPgho090a().msgOut().msg().ade().grMov().setIndex(1); hoPgho090a().msgOut().msg().ade().grMov().index().isLessOrEqual(12) && !naoHaMais.isTrue() && progStatus.isLessOrEqual(0); hoPgho090a().msgOut().msg().ade().grMov().incIndex()) {
                if (hoPgho090a().msgOut().msg().ade().grMov().getCurrent().zMovimento().isEmpty()) {
                    naoHaMais.setTrue() ;
                } else {
                    if (hoPgho090a().msgIn().msg().ade().ascendente().isTrue()) {
                        wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsZMovimento().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().zMovimento());
                        wsTsMin().wDataTsMin().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().zMovimento());
                        hoPgho090a().msgIn().msg().ade().tsMovimento().set(wsTsMin());
                        bghl190a().dadosInput().keyContz().tsMovimento().set(wsTsMin());
                    } else {
                        wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsZMovimento().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().zMovimento());
                        wsTsMax().wDataTsMax().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().zMovimento());
                        hoPgho090a().msgIn().msg().ade().tsMovimento().set(wsTsMax());
                        bghl190a().dadosInput().keyContz().tsMovimento().set(wsTsMax());
                    }
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsNsMovimento().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().nsMovimento());
                    hoPgho090a().msgIn().msg().ade().nsMovimento().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().nsMovimento());
                    bghl190a().dadosInput().keyContz().nsMovimento().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().nsMovimento());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsZValMov().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().zValMov());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsXRefMov().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().xRefMov());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsMMovimento().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().mMovimento());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsIDbcr().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().iDbcr());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsIEstorno().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().iEstorno());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsCMoedIsoOriMov().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().cMoedIsoOriMov());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsMSldoCbloApos().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().mSldoCbloApos());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsMSldoDpnlApos().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().mSldoDpnlApos());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsMMovMoeOrigMov().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().mMovMoeOrigMov());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsNDocOpps().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().nDocOpps());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsAAplOrig().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().aAplOrig());
                    wsTabelaMovimento().wsMovimentos().get(wIndAlo).wsTJuro().set(hoPgho090a().msgOut().msg().ade().grMov().getCurrent().tJuro());
                    wIndAlo.add(1);
                    wsTotEnvr.add(1);
                    wsQMov.add(1);
                    wsMovFalta.subtract(1);
                    log(TraceLevel.Error, "W-IND-ALO -", wIndAlo);
                }
            }
            segundaVez.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a51100ObtemDataInicio() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs001a().bghl001a().initialize() ;
        hrMghs001a().bghl001a().argumento().cPaisIsoaCont().set(bghl190a().dadosInput().conta().cPaisIsoaCont());
        hrMghs001a().bghl001a().argumento().cBancCont().set(bghl190a().dadosInput().conta().cBancCont());
        hrMghs001a().bghl001a().argumento().cOeEgcCont().set(bghl190a().dadosInput().conta().cOeEgcCont());
        hrMghs001a().bghl001a().argumento().nsRdclCont().set(bghl190a().dadosInput().conta().nsRdclCont());
        hrMghs001a().bghl001a().argumento().vChkdCont().set(bghl190a().dadosInput().conta().vChkdCont());
        hrMghs001a().bghl001a().argumento().cTipoCont().set(bghl190a().dadosInput().conta().cTipoCont());
        hrMghs001a().bghl001a().argumento().cMoedIsoScta().set(bghl190a().dadosInput().conta().cMoedIsoScta());
        hrMghs001a().bghl001a().argumento().nsDeposito().set(bghl190a().dadosInput().conta().nsDeposito());
        hrMghs001a().run() ;
        if (hrMghs001a().bghl001a().ok().isTrue()) {
            bghl190a().dadosInput().movimento().zInicio().set(hrMghs001a().bghl001a().detalhe().zAbraCont());
            if (hrMghs001a().bghl001a().detalhe().zAbraCont().isEqual("0001-01-01")) {
                bghl190a().dadosInput().movimento().zInicio().set("1980-01-01");
            }
        } else {
            bghl190a().dadosInput().movimento().zInicio().set("1980-01-01");
        }
    }
    
    /**
     * 
     * 
     */
    public void a52000DescarregaTabela() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl190a().dadosOutput().movimentos().resetIndex() ;
        wsTotEnvr.set(1);
        naoSair.setTrue() ;
        while (wsTotEnvr.isLessOrEqual(bghl190a().dadosInput().movimento().qMovRtno()) && wsTotEnvr.isLessOrEqual(30) && !sair.isTrue()) {
            if (wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsZMovimento().isEmpty() || 
                wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsZMovimento().isEqual(String.valueOf(LOW_VALUES))) {
                sair.setTrue() ;
            } else {
                bghl190a().dadosOutput().movimentos().getCurrent().zMovimento().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsZMovimento());
                bghl190a().dadosOutput().movimentos().getCurrent().nsMovimentoO().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsNsMovimento());
                bghl190a().dadosOutput().movimentos().getCurrent().zValMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsZValMov());
                bghl190a().dadosOutput().movimentos().getCurrent().xRefMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsXRefMov());
                bghl190a().dadosOutput().movimentos().getCurrent().iDbcr().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsIDbcr());
                bghl190a().dadosOutput().movimentos().getCurrent().mMovimento().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsMMovimento());
                if (bghl190a().dadosOutput().movimentos().getCurrent().iDbcr().isEqual("D")) {
                    bghl190a().dadosOutput().movimentos().getCurrent().mMovimento().set(multiply(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsMMovimento(), -1));
                }
                bghl190a().dadosOutput().movimentos().getCurrent().iEstorno().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsIEstorno());
                bghl190a().dadosOutput().movimentos().getCurrent().cMoedIsoOriMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsCMoedIsoOriMov());
                bghl190a().dadosOutput().movimentos().getCurrent().mSldoCbloApos().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsMSldoCbloApos());
                bghl190a().dadosOutput().movimentos().getCurrent().mSldoDpnlApos().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsMSldoDpnlApos());
                if (wsTotEnvr.isEqual(1)) {
                    a52100ObtemSaldos() ;
                }
                wsTabelaMovimento().wsMovimentos().get(bghl190a().dadosOutput().movimentos().index()).wsMMovMoeOrigMov().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsMMovMoeOrigMov());
                bghl190a().dadosOutput().movimentos().getCurrent().nDocOpps().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsNDocOpps());
                bghl190a().dadosOutput().movimentos().getCurrent().aAplOrig().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsAAplOrig());
                bghl190a().dadosOutput().movimentos().getCurrent().tJuro().set(wsTabelaMovimento().wsMovimentos().get(wsTotEnvr).wsTJuro());
                wsTotEnvr.add(1);
                bghl190a().dadosOutput().movimentos().incIndex() ;
                bghl190a().dadosOutput().qPndeEnvr().add(1);
                if (bghl190a().dadosOutput().qPndeEnvr().isEqual(bghl190a().dadosInput().movimento().qMovRtno())) {
                    sair.setTrue() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a52100ObtemSaldos() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhoj710a().bhol710a().commarea().initialize() ;
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().cPaisIsoaCont().set(bghl190a().dadosInput().conta().cPaisIsoaCont());
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().cBancCont().set(bghl190a().dadosInput().conta().cBancCont());
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().cOeEgcCont().set(bghl190a().dadosInput().conta().cOeEgcCont());
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().nsRdclCont().set(bghl190a().dadosInput().conta().nsRdclCont());
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().vChkdCont().set(bghl190a().dadosInput().conta().vChkdCont());
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().cTipoCont().set(bghl190a().dadosInput().conta().cTipoCont());
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().cMoedIsoScta().set(bghl190a().dadosInput().conta().cMoedIsoScta());
        hrMhoj710a().bhol710a().commarea().dadosInput().conta().nsDeposito().set(bghl190a().dadosInput().conta().nsDeposito());
        hrMhoj710a().bhol710a().commarea().dadosInput().consulta().setTrue() ;
        hrMhoj710a().bhol710a().commarea().dadosInput().iCnslDadCheqN().setTrue() ;
        hrMhoj710a().run() ;
        if (hrMhoj710a().bhol710a().commarea().dadosOutput().semErros().isTrue()) {
            bghl190a().dadosOutput().movimentos().getCurrent().mSldoCbloApos().set(hrMhoj710a().bhol710a().commarea().dadosOutput().innerStrct().mSldoCblo());
            bghl190a().dadosOutput().movimentos().getCurrent().mSldoDpnlApos().set(hrMhoj710a().bhol710a().commarea().dadosOutput().mSldoDpnlCnsl());
        } else {
            progStatus.set(hrMhoj710a().bhol710a().commarea().dadosOutput().cRtnoEvenSwal());
            bghl190a().dadosOutput().cTipoErroBbn().set(hrMhoj710a().bhol710a().commarea().dadosOutput().cTipoErroBbn());
            bghl190a().dadosOutput().aAplErr().set(hrMhoj710a().bhol710a().commarea().dadosOutput().aAplErr());
            bghl190a().dadosOutput().nmTabela().set(hrMhoj710a().bhol710a().commarea().dadosOutput().nmTabela());
            bghl190a().dadosOutput().cSqlcode().set(hrMhoj710a().bhol710a().commarea().dadosOutput().cSqlcode());
        }
    }
    
    /**
     * 
     * 
     */
    public void s70000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl190a().dadosOutput().cRtnoEvenSwal().set(progStatus);
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
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            s30000Validar() ;
        }
        if (progOk.isTrue()) {
            s50000Processar() ;
        }
        s70000Responder() ;
        exit() ;
    }
    
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=4)
        IInt anoCorrente() ;
        
        @Data(size=2)
        IInt mesCorrente() ;
        
        @Data(size=2)
        IInt diaCorrente() ;
        
    }
    
    public interface WsTsMin extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTsMin
         */
        @Data(rpadding=16, rpaddingValue="")
        WDataTsMin wDataTsMin() ;
        
        
        public interface WDataTsMin extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMin() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaMin() ;
            
        }
    }
    
    public interface WsTsMax extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTsMax
         */
        @Data(rpadding=16, rpaddingValue="")
        WDataTsMax wDataTsMax() ;
        
        
        public interface WDataTsMax extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoMax() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMax() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaMax() ;
            
        }
    }
    
    public interface WsTabelaMovimento extends IDataStruct {
        
        /**
         * @return instancia da classe local WsMovimentos
         */
        @Data(length=30)
        IArray<WsMovimentos> wsMovimentos() ;
        
        
        public interface WsMovimentos extends IDataStruct {
            
            
            @Data(size=10)
            IString wsZMovimento() ;
            
            @Data(size=15, signed=true, compression=COMP3)
            ILong wsNsMovimento() ;
            
            @Data(size=10)
            IString wsZValMov() ;
            
            @Data(size=21)
            IString wsXRefMov() ;
            
            @Data(size=17, decimal=2, signed=true, compression=COMP3)
            IDecimal wsMMovimento() ;
            
            @Data(size=1)
            IString wsIDbcr() ;
            
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
            
            @Data(size=10, signed=true, compression=COMP3)
            ILong wsNDocOpps() ;
            
            @Data(size=2)
            IString wsAAplOrig() ;
            
            @Data(size=5, decimal=3, signed=true, compression=COMP3)
            IDecimal wsTJuro() ;
            
        }
    }
}
