package cgd.gh.routines;

import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.structures.link.Bghl205a ;
import cgd.gh.structures.work.Bghw0013 ;
import cgd.gh.structures.work.Bghw0014 ;
import cgd.gh.routines.Mghs112a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS
 * PROGRAMA      : INFORMA DADOS DO MOVIMENTO ATRAVES DO NUMERO
 * DE JOURN
 * ----->  ESTE PROGRAMA DESTINA-SE AO HERCULES          <---
 * 
 * migrated from program [MGHO205A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mgho205a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl205a
     */
    @Data
    public abstract Bghl205a bghl205a() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs112a
     */
    @Data
    protected abstract Mghs112a hrMghs112a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    /**
     * @return instancia da classe Bghw0013
     */
    @Data
    protected abstract Bghw0013 bghw0013() ;
    
    /**
     * @return instancia da classe Bghw0014
     */
    @Data
    protected abstract Bghw0014 bghw0014() ;
    
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
    @Condition("098")
    protected ICondition progNaoExisteAdic ;
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
    
    @Data(size=8, value="0")
    protected ILong dataCorrente ;
    
    @Data(size=8, value="0")
    protected ILong dataNum ;
    
    /**
     * @return instancia da classe local WsTsMin
     */
    @Data
    protected abstract WsTsMin wsTsMin() ;
    
    @Data(size=1, value=" ")
    protected IString waIExisInfAdi ;
    
    /**
     * @return instancia da classe local WsTsMax
     */
    @Data
    protected abstract WsTsMax wsTsMax() ;
    
    
    
    /**
     * 
     * 
     */
    public void s10000Iniciar() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl205a().dadosOutput().initialize() ;
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
        if (bghl205a().dadosInput().subconta().cPaisIsoaCont().isEmpty() || 
            bghl205a().dadosInput().subconta().cBancCont().isEqual(0) || 
            bghl205a().dadosInput().subconta().cOeEgcCont().isEqual(0) || 
            bghl205a().dadosInput().subconta().nsRdclCont().isEqual(0) || 
            bghl205a().dadosInput().subconta().cMoedIsoScta().isEmpty() || 
            bghl205a().dadosInput().zMovimento().isEmpty() || 
            bghl205a().dadosInput().aAplicacao().isEmpty() || 
            bghl205a().dadosInput().cMnemEgcOpex().isEmpty() || 
            bghl205a().dadosInput().cPaisIsoaOeOpx().isEmpty() || 
            bghl205a().dadosInput().cOeEgcOpex().isEqual(0) || 
            bghl205a().dadosInput().cUserid().isEmpty() || 
            bghl205a().dadosInput().nJourBbn().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
            bghl205a().dadosOutput().dadosErro().aAplErr().set(WS_APL_HST);
            bghl205a().dadosOutput().dadosErro().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            a31000ValidarAplicacao() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a31000ValidarAplicacao() {
        /**
         * *----------------------------------------------------------------*
         */
        bghw0013().tbAplDtArr().itemApl().resetIndex() ;
        while (bghw0013().tbAplDtArr().itemApl().index().isLessOrEqual(10)) {
            if (bghl205a().dadosInput().aAplicacao().isEqual(bghw0013().tbAplDtArr().itemApl().getCurrent().tabAAplic())) {
                waIExisInfAdi.set("S");
                break;
            }
            bghw0013().tbAplDtArr().itemApl().incIndex() ;
        }
        if (bghw0013().tbAplDtArr().itemApl().atEnd()) {
            waIExisInfAdi.set("N");
        }
        if (waIExisInfAdi.isEqual("S")) {
            bghw0014().tbAplTrnzProg().itemTrn().resetIndex() ;
            while (bghw0014().tbAplTrnzProg().itemTrn().index().isLessOrEqual(11)) {
                if (bghl205a().dadosInput().aAplicacao().isEqual(bghw0014().tbAplTrnzProg().itemTrn().getCurrent().tabAplicacao())) {
                    bghl205a().dadosOutput().dadosAdic().cTrnzAdic().set(bghw0014().tbAplTrnzProg().itemTrn().getCurrent().tabTrnzAdic());
                    bghl205a().dadosOutput().dadosAdic().nmPrgAdic().set(bghw0014().tbAplTrnzProg().itemTrn().getCurrent().tabNmPrgAdic());
                    break;
                }
                bghw0014().tbAplTrnzProg().itemTrn().incIndex() ;
            }
            if (bghw0014().tbAplTrnzProg().itemTrn().atEnd()) {
                progNaoExisteAdic.setTrue() ;
                bghl205a().dadosOutput().dadosErro().aAplErr().set(WS_APL_HST);
                bghl205a().dadosOutput().dadosErro().cTipoErroBbn().set(WS_ERR_FUNC);
            }
        } else {
            progNaoExisteAdic.setTrue() ;
            bghl205a().dadosOutput().dadosErro().aAplErr().set(WS_APL_HST);
            bghl205a().dadosOutput().dadosErro().cTipoErroBbn().set(WS_ERR_FUNC);
        }
    }
    
    /**
     * 
     * 
     */
    public void s50000Processar() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs112a().bghl112a().initialize() ;
        hrMghs112a().bghl112a().argumento().cPaisIsoaCont().set(bghl205a().dadosInput().subconta().cPaisIsoaCont());
        hrMghs112a().bghl112a().argumento().cBancCont().set(bghl205a().dadosInput().subconta().cBancCont());
        hrMghs112a().bghl112a().argumento().cOeEgcCont().set(bghl205a().dadosInput().subconta().cOeEgcCont());
        hrMghs112a().bghl112a().argumento().nsRdclCont().set(bghl205a().dadosInput().subconta().nsRdclCont());
        hrMghs112a().bghl112a().argumento().vChkdCont().set(bghl205a().dadosInput().subconta().vChkdCont());
        hrMghs112a().bghl112a().argumento().cTipoCont().set(bghl205a().dadosInput().subconta().cTipoCont());
        hrMghs112a().bghl112a().argumento().cMoedIsoScta().set(bghl205a().dadosInput().subconta().cMoedIsoScta());
        hrMghs112a().bghl112a().argumento().nsDeposito().set(bghl205a().dadosInput().subconta().nsDeposito());
        hrMghs112a().bghl112a().argumento().zMovimento().set(bghl205a().dadosInput().zMovimento());
        hrMghs112a().bghl112a().argumento().cMnemEgcOpex().set(bghl205a().dadosInput().cMnemEgcOpex());
        hrMghs112a().bghl112a().argumento().cPaisIsoaOeOpx().set(bghl205a().dadosInput().cPaisIsoaOeOpx());
        hrMghs112a().bghl112a().argumento().cOeEgcOpex().set(bghl205a().dadosInput().cOeEgcOpex());
        hrMghs112a().bghl112a().argumento().cUserid().set(bghl205a().dadosInput().cUserid());
        hrMghs112a().bghl112a().argumento().nJourBbn().set(bghl205a().dadosInput().nJourBbn());
        hrMghs112a().bghl112a().argumento().nsJourBbn().set(bghl205a().dadosInput().nsJourBbn());
        hrMghs112a().bghl112a().argumento().nsJourBbnDtlh().set(bghl205a().dadosInput().nsJourBbnDtlh());
        hrMghs112a().run() ;
        if (!hrMghs112a().bghl112a().ok().isTrue()) {
            progStatus.set(hrMghs112a().bghl112a().cRetorno());
            bghl205a().dadosOutput().dadosErro().aAplErr().set(WS_APL_HST);
            bghl205a().dadosOutput().dadosErro().cTipoErroBbn().set(WS_ERR_FUNC);
        }
        if (progOk.isTrue()) {
            bghl205a().dadosOutput().dadosMov().tsMovimento().set(hrMghs112a().bghl112a().detalhe().tsMovimento());
            bghl205a().dadosOutput().dadosMov().nsMovimento().set(hrMghs112a().bghl112a().detalhe().nsMovimento());
            bghl205a().dadosOutput().dadosMov().aAplOrig().set(hrMghs112a().bghl112a().detalhe().aAplOrig());
            bghl205a().dadosOutput().dadosMov().cTrnzIput().set("GHI0");
            bghl205a().dadosOutput().dadosMov().mMovimento().set(hrMghs112a().bghl112a().detalhe().mMovimento());
            bghl205a().dadosOutput().dadosMov().xRefMov().set(hrMghs112a().bghl112a().detalhe().xRefMov());
            bghl205a().dadosOutput().dadosMov().iDbcr().set(hrMghs112a().bghl112a().detalhe().iDbcr());
            bghl205a().dadosOutput().dadosMov().nDocOpps().set(hrMghs112a().bghl112a().detalhe().nDocOpps());
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
        bghl205a().dadosOutput().dadosErro().cRtnoEvenSwal().set(progStatus);
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
}
