package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
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
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl805a ;
import cgd.hy.routines.Mhyj100a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : THO00020_MOVDIA1
 * THO00021_MOVDIA2
 * DESCRICAO     : ACESSO A TABELAS DE MOVIMENTOS HO
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS805A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs805a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl805a
     */
    @Data
    public abstract Bghl805a bghl805a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdhops02001Movdia1
     */
    @Data
    protected abstract Vwsdhops02001Movdia1 hv02001Movdia1() ;
    
    /**
     * @return instancia da classe Vwsdhops02101Movdia2
     */
    @Data
    protected abstract Vwsdhops02101Movdia2 hv02101Movdia2() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyj100a
     */
    @Data
    protected abstract Mhyj100a hrMhyj100a() ;
    
    
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
    @Condition("049")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("328")
    protected ICondition progMovJaEstornado ;
    @Data
    @Condition("005")
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
    
    
    @Data(size=8, value="MHYJ100A")
    protected IString wsModMhyj100a ;
    
    @Data(size=1, value="1")
    protected IInt wsConTabMov1 ;
    
    @Data(size=1, value="2")
    protected IInt wsConTabMov2 ;
    
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
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl805a().cRetorno().initialize() ;
        bghl805a().cSqlcode().initialize() ;
        if (bghl805a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl805a().argumento().cBancCont().isEqual(0) || 
            bghl805a().argumento().cOeEgcCont().isEqual(0) || 
            bghl805a().argumento().nsRdclCont().isEqual(0) || 
            bghl805a().argumento().cMoedIsoScta().isEmpty() || 
            bghl805a().argumento().nsMovimento().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
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
        a5000ObterImgTabJour() ;
        if (progOk.isTrue()) {
            a5100FormatarArea() ;
        }
        if (hrMhyj100a().bhyl100a().commarea().dadosSaida().cImgGrupTab().isEqual(wsConTabMov1)) {
            a5200AcedeTho20() ;
        } else {
            a5300AcedeTho21() ;
        }
        if (progOk.isTrue()) {
            a5400PreencheOutput() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5000ObterImgTabJour() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhyj100a().bhyl100a().commarea().initialize() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().iOperacao().set("V");
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().aAplicacao().set("HY");
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().cGrupTabAtiv().set("TABARQ");
        hrMhyj100a().run() ;
        if (!hrMhyj100a().bhyl100a().commarea().dadosSaida().semErros().isTrue()) {
            progStatus.set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cRtnoEvenSwal());
            bghl805a().aAplErr().set(hrMhyj100a().bhyl100a().commarea().dadosSaida().aAplErr());
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
        hv02001Movdia1().movdia1().initialize() ;
        hv02001Movdia1().movdia1().cPaisIsoaCont().set(bghl805a().argumento().cPaisIsoaCont());
        hv02001Movdia1().movdia1().cBancCont().set(bghl805a().argumento().cBancCont());
        hv02001Movdia1().movdia1().cOeEgcCont().set(bghl805a().argumento().cOeEgcCont());
        hv02001Movdia1().movdia1().nsRdclCont().set(bghl805a().argumento().nsRdclCont());
        hv02001Movdia1().movdia1().vChkdCont().set(bghl805a().argumento().vChkdCont());
        hv02001Movdia1().movdia1().cTipoCont().set(bghl805a().argumento().cTipoCont());
        hv02001Movdia1().movdia1().cMoedIsoScta().set(bghl805a().argumento().cMoedIsoScta());
        hv02001Movdia1().movdia1().nsDeposito().set(bghl805a().argumento().nsDeposito());
        hv02001Movdia1().movdia1().nsMovimento().set(bghl805a().argumento().nsMovimento());
    }
    
    /**
     * 
     * 
     */
    public void a5200AcedeTho20() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02001_MOVDIA1
         */
        hv02001Movdia1().selectMghs805a222() ;
        if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300AcedeTho21() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02101_MOVDIA2
         */
        hv02101Movdia2().selectMghs805a313(hv02001Movdia1().movdia1()) ;
        if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5400PreencheOutput() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl805a().detalhe().zContabilizacao().set(hv02001Movdia1().movdia1().zContabilizacao());
        bghl805a().detalhe().zMovimento().set(hv02001Movdia1().movdia1().zMovimento());
        bghl805a().detalhe().zValor().set(hv02001Movdia1().movdia1().zValor());
        bghl805a().detalhe().iDbcr().set(hv02001Movdia1().movdia1().iDbcr());
        bghl805a().detalhe().mMovimento().set(hv02001Movdia1().movdia1().mMovimento());
        bghl805a().detalhe().mSldoCblo().set(hv02001Movdia1().movdia1().mSldoCblo());
        bghl805a().detalhe().mSldoDpnl().set(hv02001Movdia1().movdia1().mSldoDpnl());
        bghl805a().detalhe().cMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
        bghl805a().detalhe().mMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
        bghl805a().detalhe().tCambio().set(hv02001Movdia1().movdia1().tCambio());
        bghl805a().detalhe().cOpeBbn().set(hv02001Movdia1().movdia1().cOpeBbn());
        bghl805a().detalhe().xRefMov().set(hv02001Movdia1().movdia1().xRefMov());
        bghl805a().detalhe().nCheque().set(hv02001Movdia1().movdia1().nCheque());
        bghl805a().detalhe().iEstorno().set(hv02001Movdia1().movdia1().iEstorno());
        bghl805a().detalhe().nsMovEtnd().set(hv02001Movdia1().movdia1().nsMovEtnd());
        bghl805a().detalhe().iTrnzEfcdOnln().set(hv02001Movdia1().movdia1().iTrnzEfcdOnln());
        bghl805a().detalhe().iTipoOrigTrnz().set(hv02001Movdia1().movdia1().iTipoOrigTrnz());
        bghl805a().detalhe().iExiAtzJourBbn().set(hv02001Movdia1().movdia1().iExiAtzJourBbn());
        bghl805a().detalhe().cTipoCanlAces().set(hv02001Movdia1().movdia1().cTipoCanlAces());
        bghl805a().detalhe().aAplicacao().set(hv02001Movdia1().movdia1().aAplicacao());
        bghl805a().detalhe().cOpczMenu().set(hv02001Movdia1().movdia1().cOpczMenu());
        bghl805a().detalhe().cFamiProd().set(hv02001Movdia1().movdia1().cFamiProd());
        bghl805a().detalhe().cProduto().set(hv02001Movdia1().movdia1().cProduto());
        bghl805a().detalhe().cSectIttlBpor().set(hv02001Movdia1().movdia1().cSectIttlBpor());
        bghl805a().detalhe().cPaisIsoaGerx().set(hv02001Movdia1().movdia1().cPaisIsoaGerx());
        bghl805a().detalhe().cBancGcxGerx().set(hv02001Movdia1().movdia1().cBancGcxGerx());
        bghl805a().detalhe().cOeEgcGerx().set(hv02001Movdia1().movdia1().cOeEgcGerx());
        bghl805a().detalhe().iMovActzVsld().set(hv02001Movdia1().movdia1().iMovActzVsld());
        bghl805a().detalhe().zProcessamento().set(hv02001Movdia1().movdia1().zProcessamento());
        bghl805a().detalhe().cMnemEgcOpex().set(hv02001Movdia1().movdia1().cMnemEgcOpex());
        bghl805a().detalhe().cPaisIsoaOeOpx().set(hv02001Movdia1().movdia1().cPaisIsoaOeOpx());
        bghl805a().detalhe().cOeEgcOpex().set(hv02001Movdia1().movdia1().cOeEgcOpex());
        bghl805a().detalhe().cUserid().set(hv02001Movdia1().movdia1().cUserid());
        bghl805a().detalhe().nJourBbn().set(hv02001Movdia1().movdia1().nJourBbn());
        bghl805a().detalhe().nsJourBbn().set(hv02001Movdia1().movdia1().nsJourBbn());
        bghl805a().detalhe().nsJourBbnDtlh().set(hv02001Movdia1().movdia1().nsJourBbnDtlh());
        bghl805a().detalhe().mSldoRetd().set(hv02001Movdia1().movdia1().mSldoRetd());
        bghl805a().detalhe().mSldoVcob().set(hv02001Movdia1().movdia1().mSldoVcob());
        bghl805a().detalhe().mSldoVcobUtid().set(hv02001Movdia1().movdia1().mSldoVcobUtid());
        bghl805a().detalhe().mDcboNgcdAtrd().set(hv02001Movdia1().movdia1().mDcboNgcdAtrd());
        bghl805a().detalhe().mDcboNgcdUtid().set(hv02001Movdia1().movdia1().mDcboNgcdUtid());
        bghl805a().detalhe().mCmrgLim().set(hv02001Movdia1().movdia1().mCmrgLim());
        bghl805a().detalhe().mCmrgUtid().set(hv02001Movdia1().movdia1().mCmrgUtid());
        bghl805a().detalhe().qDiaCalcJuro().set(hv02001Movdia1().movdia1().qDiaCalcJuro());
        bghl805a().detalhe().cTipoJuro().set(hv02001Movdia1().movdia1().cTipoJuro());
        bghl805a().detalhe().iTipoCalcJuro().set(hv02001Movdia1().movdia1().iTipoCalcJuro());
        bghl805a().detalhe().iPenalizacao().set(hv02001Movdia1().movdia1().iPenalizacao());
        bghl805a().detalhe().qRenovacao().set(hv02001Movdia1().movdia1().qRenovacao());
        bghl805a().detalhe().nsUtizCmrg().set(hv02001Movdia1().movdia1().nsUtizCmrg());
        bghl805a().detalhe().cEvenOpel().set(hv02001Movdia1().movdia1().cEvenOpel());
        bghl805a().detalhe().tsActzUlt().set(hv02001Movdia1().movdia1().tsActzUlt());
        bghl805a().detalhe().cUsidActzUlt().set(hv02001Movdia1().movdia1().cUsidActzUlt());
    }
    
    /**
     * 
     * 
     */
    public void s5000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl805a().cRetorno().set(progStatus);
        bghl805a().cSqlcode().set(getPersistenceCode());
        if (bghl805a().aAplErr().isEmpty()) {
            bghl805a().aAplErr().set("GH");
        }
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
}
