package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl206a ;
import cgd.hy.routines.Mhyj100a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : THO00020_MOVDIA1
 * THO00021_MOVDIA2
 * DESCRICAO     : ACESSO A TABELAS DE MOVIMENTOS HO
 * PROCESSO      : GH1174
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHJ206A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj206a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl206a
     */
    @Data
    public abstract Bghl206a bghl206a() ;
    
    
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
        /**
         * *----------------------------------------------------------------*
         */
        log(TraceLevel.Trace, "  S1000-INICIAR ");
        progOk.setTrue() ;
        bghl206a().commarea().cRetorno().initialize() ;
        bghl206a().commarea().cSqlcode().initialize() ;
        if (bghl206a().commarea().argumento().cPaisIsoaCont().isEmpty() || 
            bghl206a().commarea().argumento().cBancCont().isEqual(0) || 
            bghl206a().commarea().argumento().cOeEgcCont().isEqual(0) || 
            bghl206a().commarea().argumento().nsRdclCont().isEqual(0) || 
            bghl206a().commarea().argumento().cMoedIsoScta().isEmpty() || 
            bghl206a().commarea().argumento().nsMovimento().isEqual(0)) {
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
        log(TraceLevel.Trace, " S3000-PROCESSAR");
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
            bghl206a().commarea().aAplErr().set(hrMhyj100a().bhyl100a().commarea().dadosSaida().aAplErr());
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
        hv02001Movdia1().movdia1().cPaisIsoaCont().set(bghl206a().commarea().argumento().cPaisIsoaCont());
        hv02001Movdia1().movdia1().cBancCont().set(bghl206a().commarea().argumento().cBancCont());
        hv02001Movdia1().movdia1().cOeEgcCont().set(bghl206a().commarea().argumento().cOeEgcCont());
        hv02001Movdia1().movdia1().nsRdclCont().set(bghl206a().commarea().argumento().nsRdclCont());
        hv02001Movdia1().movdia1().vChkdCont().set(bghl206a().commarea().argumento().vChkdCont());
        hv02001Movdia1().movdia1().cTipoCont().set(bghl206a().commarea().argumento().cTipoCont());
        hv02001Movdia1().movdia1().cMoedIsoScta().set(bghl206a().commarea().argumento().cMoedIsoScta());
        hv02001Movdia1().movdia1().nsDeposito().set(bghl206a().commarea().argumento().nsDeposito());
        hv02001Movdia1().movdia1().nsMovimento().set(bghl206a().commarea().argumento().nsMovimento());
        log(TraceLevel.Trace, "MGH206A-C-PAIS-ISOA-CONT ", bghl206a().commarea().argumento().cPaisIsoaCont());
        log(TraceLevel.Trace, "MGH206A-C-BANC-CONT      ", bghl206a().commarea().argumento().cBancCont());
        log(TraceLevel.Trace, "MGH206A-C-OE-EGC-CONT    ", bghl206a().commarea().argumento().cOeEgcCont());
        log(TraceLevel.Trace, "MGH206A-NS-RDCL-CONT     ", bghl206a().commarea().argumento().nsRdclCont());
        log(TraceLevel.Trace, "MGH206A-V-CHKD-CONT      ", bghl206a().commarea().argumento().vChkdCont());
        log(TraceLevel.Trace, "MGH206A-C-TIPO-CONT      ", bghl206a().commarea().argumento().cTipoCont());
        log(TraceLevel.Trace, "MGH206A-C-MOED-ISO-SCTA  ", bghl206a().commarea().argumento().cMoedIsoScta());
        log(TraceLevel.Trace, "MGH206A-NS-DEPOSITO      ", bghl206a().commarea().argumento().nsDeposito());
        log(TraceLevel.Trace, "MGH206A-NS-MOVIMENTO     ", bghl206a().commarea().argumento().nsMovimento());
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
        hv02001Movdia1().selectMghj206a243() ;
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
        hv02101Movdia2().selectMghj206a334(hv02001Movdia1().movdia1()) ;
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
        bghl206a().commarea().detalhe().zContabilizacao().set(hv02001Movdia1().movdia1().zContabilizacao());
        bghl206a().commarea().detalhe().zMovimento().set(hv02001Movdia1().movdia1().zMovimento());
        bghl206a().commarea().detalhe().zValor().set(hv02001Movdia1().movdia1().zValor());
        bghl206a().commarea().detalhe().iDbcr().set(hv02001Movdia1().movdia1().iDbcr());
        bghl206a().commarea().detalhe().mMovimento().set(hv02001Movdia1().movdia1().mMovimento());
        bghl206a().commarea().detalhe().mSldoCblo().set(hv02001Movdia1().movdia1().mSldoCblo());
        bghl206a().commarea().detalhe().mSldoDpnl().set(hv02001Movdia1().movdia1().mSldoDpnl());
        bghl206a().commarea().detalhe().cMoedIsoOriMov().set(hv02001Movdia1().movdia1().cMoedIsoOriMov());
        bghl206a().commarea().detalhe().mMovMoeOrigMov().set(hv02001Movdia1().movdia1().mMovMoeOrigMov());
        bghl206a().commarea().detalhe().tCambio().set(hv02001Movdia1().movdia1().tCambio());
        bghl206a().commarea().detalhe().cOpeBbn().set(hv02001Movdia1().movdia1().cOpeBbn());
        bghl206a().commarea().detalhe().xRefMov().set(hv02001Movdia1().movdia1().xRefMov());
        bghl206a().commarea().detalhe().nCheque().set(hv02001Movdia1().movdia1().nCheque());
        bghl206a().commarea().detalhe().iEstorno().set(hv02001Movdia1().movdia1().iEstorno());
        bghl206a().commarea().detalhe().nsMovEtnd().set(hv02001Movdia1().movdia1().nsMovEtnd());
        bghl206a().commarea().detalhe().iTrnzEfcdOnln().set(hv02001Movdia1().movdia1().iTrnzEfcdOnln());
        bghl206a().commarea().detalhe().iTipoOrigTrnz().set(hv02001Movdia1().movdia1().iTipoOrigTrnz());
        bghl206a().commarea().detalhe().iExiAtzJourBbn().set(hv02001Movdia1().movdia1().iExiAtzJourBbn());
        bghl206a().commarea().detalhe().cTipoCanlAces().set(hv02001Movdia1().movdia1().cTipoCanlAces());
        bghl206a().commarea().detalhe().aAplicacao().set(hv02001Movdia1().movdia1().aAplicacao());
        bghl206a().commarea().detalhe().cOpczMenu().set(hv02001Movdia1().movdia1().cOpczMenu());
        bghl206a().commarea().detalhe().cFamiProd().set(hv02001Movdia1().movdia1().cFamiProd());
        bghl206a().commarea().detalhe().cProduto().set(hv02001Movdia1().movdia1().cProduto());
        bghl206a().commarea().detalhe().cSectIttlBpor().set(hv02001Movdia1().movdia1().cSectIttlBpor());
        bghl206a().commarea().detalhe().cPaisIsoaGerx().set(hv02001Movdia1().movdia1().cPaisIsoaGerx());
        bghl206a().commarea().detalhe().cBancGcxGerx().set(hv02001Movdia1().movdia1().cBancGcxGerx());
        bghl206a().commarea().detalhe().cOeEgcGerx().set(hv02001Movdia1().movdia1().cOeEgcGerx());
        bghl206a().commarea().detalhe().iMovActzVsld().set(hv02001Movdia1().movdia1().iMovActzVsld());
        bghl206a().commarea().detalhe().zProcessamento().set(hv02001Movdia1().movdia1().zProcessamento());
        bghl206a().commarea().detalhe().cMnemEgcOpex().set(hv02001Movdia1().movdia1().cMnemEgcOpex());
        bghl206a().commarea().detalhe().cPaisIsoaOeOpx().set(hv02001Movdia1().movdia1().cPaisIsoaOeOpx());
        bghl206a().commarea().detalhe().cOeEgcOpex().set(hv02001Movdia1().movdia1().cOeEgcOpex());
        bghl206a().commarea().detalhe().cUserid().set(hv02001Movdia1().movdia1().cUserid());
        bghl206a().commarea().detalhe().nJourBbn().set(hv02001Movdia1().movdia1().nJourBbn());
        bghl206a().commarea().detalhe().nsJourBbn().set(hv02001Movdia1().movdia1().nsJourBbn());
        bghl206a().commarea().detalhe().nsJourBbnDtlh().set(hv02001Movdia1().movdia1().nsJourBbnDtlh());
        bghl206a().commarea().detalhe().mSldoRetd().set(hv02001Movdia1().movdia1().mSldoRetd());
        bghl206a().commarea().detalhe().mSldoVcob().set(hv02001Movdia1().movdia1().mSldoVcob());
        bghl206a().commarea().detalhe().mSldoVcobUtid().set(hv02001Movdia1().movdia1().mSldoVcobUtid());
        bghl206a().commarea().detalhe().mDcboNgcdAtrd().set(hv02001Movdia1().movdia1().mDcboNgcdAtrd());
        bghl206a().commarea().detalhe().mDcboNgcdUtid().set(hv02001Movdia1().movdia1().mDcboNgcdUtid());
        bghl206a().commarea().detalhe().mCmrgLim().set(hv02001Movdia1().movdia1().mCmrgLim());
        bghl206a().commarea().detalhe().mCmrgUtid().set(hv02001Movdia1().movdia1().mCmrgUtid());
        bghl206a().commarea().detalhe().qDiaCalcJuro().set(hv02001Movdia1().movdia1().qDiaCalcJuro());
        bghl206a().commarea().detalhe().cTipoJuro().set(hv02001Movdia1().movdia1().cTipoJuro());
        bghl206a().commarea().detalhe().iTipoCalcJuro().set(hv02001Movdia1().movdia1().iTipoCalcJuro());
        bghl206a().commarea().detalhe().iPenalizacao().set(hv02001Movdia1().movdia1().iPenalizacao());
        bghl206a().commarea().detalhe().qRenovacao().set(hv02001Movdia1().movdia1().qRenovacao());
        bghl206a().commarea().detalhe().nsUtizCmrg().set(hv02001Movdia1().movdia1().nsUtizCmrg());
        bghl206a().commarea().detalhe().cEvenOpel().set(hv02001Movdia1().movdia1().cEvenOpel());
        bghl206a().commarea().detalhe().tsActzUlt().set(hv02001Movdia1().movdia1().tsActzUlt());
        bghl206a().commarea().detalhe().cUsidActzUlt().set(hv02001Movdia1().movdia1().cUsidActzUlt());
    }
    
    /**
     * 
     * 
     */
    public void s5000Responder() {
        /**
         * *----------------------------------------------------------------*
         */
        bghl206a().commarea().cRetorno().set(progStatus);
        bghl206a().commarea().cSqlcode().set(getPersistenceCode());
        if (bghl206a().commarea().aAplErr().isEmpty()) {
            bghl206a().commarea().aAplErr().set("GH");
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
        log(TraceLevel.Trace, "MGH206A-C-PAIS-ISOA-CONT ", bghl206a().commarea().argumento().cPaisIsoaCont());
        log(TraceLevel.Trace, "MGH206A-C-BANC-CONT      ", bghl206a().commarea().argumento().cBancCont());
        log(TraceLevel.Trace, "MGH206A-C-OE-EGC-CONT    ", bghl206a().commarea().argumento().cOeEgcCont());
        log(TraceLevel.Trace, "MGH206A-NS-RDCL-CONT     ", bghl206a().commarea().argumento().nsRdclCont());
        log(TraceLevel.Trace, "MGH206A-V-CHKD-CONT      ", bghl206a().commarea().argumento().vChkdCont());
        log(TraceLevel.Trace, "MGH206A-C-TIPO-CONT      ", bghl206a().commarea().argumento().cTipoCont());
        log(TraceLevel.Trace, "MGH206A-C-MOED-ISO-SCTA  ", bghl206a().commarea().argumento().cMoedIsoScta());
        log(TraceLevel.Trace, "MGH206A-NS-DEPOSITO      ", bghl206a().commarea().argumento().nsDeposito());
        log(TraceLevel.Trace, "MGH206A-NS-MOVIMENTO     ", bghl206a().commarea().argumento().nsMovimento());
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
