package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
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
import cgd.gh.structures.link.Bghl112a ;
import cgd.gh.routines.Mghs113a ;
import cgd.gh.routines.Mghs200a ;
import cgd.hy.routines.Mhyj100a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00102_MOVHSTCPL
 * DESCRICAO     : DEVOLVE NS-MOVIMENTO ATRAVES DA CHAVE DE JOURN*
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHS112A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghs112a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl112a
     */
    @Data
    public abstract Bghl112a bghl112a() ;
    
    
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
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghs113a
     */
    @Data
    protected abstract Mghs113a hrMghs113a() ;
    
    /**
     * @return instancia da classe Mghs200a
     */
    @Data
    protected abstract Mghs200a hrMghs200a() ;
    
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
    
    
    @Data(size=1)
    protected IString wsHaMov ;
    @Data
    @Condition("S")
    protected ICondition haMov ;
    @Data
    @Condition("N")
    protected ICondition naoHaMov ;
    
    
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
    
    @Data(size=8, value="MHYJ100A")
    protected IString bhyk0002RotActTabAct ;
    
    /**
     * @return instancia da classe local WsDataToday
     */
    @Data
    protected abstract WsDataToday wsDataToday() ;
    
    /**
     * @return instancia da classe local WsDataDia
     */
    @Data
    protected abstract WsDataDia wsDataDia() ;
    
    /**
     * @return instancia da classe local Bhok0002Tabelas
     */
    @Data
    protected abstract Bhok0002Tabelas bhok0002Tabelas() ;
    
    
    
    /**
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl112a().cRetorno().initialize() ;
        bghl112a().cSqlcode().initialize() ;
        if (bghl112a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl112a().argumento().cBancCont().isEqual(0) || 
            bghl112a().argumento().cOeEgcCont().isEqual(0) || 
            bghl112a().argumento().nsRdclCont().isEqual(0) || 
            bghl112a().argumento().cMoedIsoScta().isEmpty() || 
            bghl112a().argumento().zMovimento().isEmpty() || 
            bghl112a().argumento().nJourBbn().isEqual(0)) {
            progDadosInvalidos.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (progOk.isTrue()) {
                wsDataToday().set(getTimeAsLong());
                wsDataDia().wAnoData().set(wsDataToday().wsAnoToday());
                wsDataDia().wMesData().set(wsDataToday().wsMesToday());
                wsDataDia().wDiaData().set(wsDataToday().wsDiaToday());
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
        if (bghl112a().argumento().zMovimento().isEqual(wsDataDia())) {
            a3100ObtemDadosHo() ;
        } else {
            a3200FormatarArea() ;
            if (progOk.isTrue()) {
                a3300AcedeTabela() ;
            }
            if (progOk.isTrue()) {
                a3400ObtemInfMov() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a3100ObtemDadosHo() {
        /**
         * *----------------------------------------------------------------*
         */
        a3110ObtemTabMov() ;
        if (progOk.isTrue()) {
            a3120AcedeTabHo() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a3110ObtemTabMov() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhyj100a().bhyl100a().commarea().initialize() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().aAplicacao().set("HY");
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().cGrupTabAtiv().set("TABARQ");
        hrMhyj100a().run() ;
        if (!hrMhyj100a().bhyl100a().commarea().dadosSaida().semErros().isTrue()) {
            bghl112a().cSqlcode().set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cSqlcode());
            progStatus.set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 
     */
    public void a3120AcedeTabHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hv02001Movdia1().movdia1().initialize() ;
        hv02101Movdia2().movdia2().initialize() ;
        hv02001Movdia1().movdia1().cPaisIsoaCont().set(bghl112a().argumento().cPaisIsoaCont());
        hv02001Movdia1().movdia1().cBancCont().set(bghl112a().argumento().cBancCont());
        hv02001Movdia1().movdia1().cOeEgcCont().set(bghl112a().argumento().cOeEgcCont());
        hv02001Movdia1().movdia1().nsRdclCont().set(bghl112a().argumento().nsRdclCont());
        hv02001Movdia1().movdia1().vChkdCont().set(bghl112a().argumento().vChkdCont());
        hv02001Movdia1().movdia1().cTipoCont().set(bghl112a().argumento().cTipoCont());
        hv02001Movdia1().movdia1().cMoedIsoScta().set(bghl112a().argumento().cMoedIsoScta());
        hv02001Movdia1().movdia1().nsDeposito().set(bghl112a().argumento().nsDeposito());
        hv02001Movdia1().movdia1().zProcessamento().set(bghl112a().argumento().zMovimento());
        hv02001Movdia1().movdia1().cMnemEgcOpex().set(bghl112a().argumento().cMnemEgcOpex());
        hv02001Movdia1().movdia1().cPaisIsoaOeOpx().set(bghl112a().argumento().cPaisIsoaOeOpx());
        hv02001Movdia1().movdia1().cOeEgcOpex().set(bghl112a().argumento().cOeEgcOpex());
        hv02001Movdia1().movdia1().cUserid().set(bghl112a().argumento().cUserid());
        hv02001Movdia1().movdia1().nJourBbn().set(bghl112a().argumento().nJourBbn());
        hv02001Movdia1().movdia1().nsJourBbn().set(bghl112a().argumento().nsJourBbn());
        hv02001Movdia1().movdia1().nsJourBbnDtlh().set(bghl112a().argumento().nsJourBbnDtlh());
        if (hrMhyj100a().bhyl100a().commarea().dadosSaida().cImgGrupTab().isEqual(bhok0002Tabelas().bhok0002ConTabMov1())) {
            a3121AcedeTho20() ;
        } else {
            a3122AcedeTho21() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a3121AcedeTho20() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02001_MOVDIA1
         */
        hv02001Movdia1().selectMghs112a282() ;
        if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl112a().detalhe().nsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
            bghl112a().detalhe().mMovimento().set(hv02001Movdia1().movdia1().mMovimento());
            bghl112a().detalhe().iDbcr().set(hv02001Movdia1().movdia1().iDbcr());
            bghl112a().detalhe().xRefMov().set(hv02001Movdia1().movdia1().xRefMov());
            bghl112a().detalhe().nDocOpps().set(hv02001Movdia1().movdia1().nCheque());
            bghl112a().detalhe().aAplOrig().set(hv02001Movdia1().movdia1().aAplicacao());
        }
    }
    
    /**
     * 
     * 
     */
    public void a3122AcedeTho21() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02101_MOVDIA2
         */
        hv02101Movdia2().selectMghs112a341(hv02001Movdia1().movdia1()) ;
        if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl112a().detalhe().nsMovimento().set(hv02101Movdia2().movdia2().nsMovimento());
            bghl112a().detalhe().mMovimento().set(hv02101Movdia2().movdia2().mMovimento());
            bghl112a().detalhe().iDbcr().set(hv02101Movdia2().movdia2().iDbcr());
            bghl112a().detalhe().xRefMov().set(hv02101Movdia2().movdia2().xRefMov());
            bghl112a().detalhe().nDocOpps().set(hv02101Movdia2().movdia2().nCheque());
            bghl112a().detalhe().aAplOrig().set(hv02101Movdia2().movdia2().aAplicacao());
        }
    }
    
    /**
     * 
     * 
     */
    public void a3200FormatarArea() {
        /**
         * *----------------------------------------------------------------*
         */
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghl112a().argumento().cPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bghl112a().argumento().cBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghl112a().argumento().cOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghl112a().argumento().nsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghl112a().argumento().vChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghl112a().argumento().cTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghl112a().argumento().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghl112a().argumento().nsDeposito());
        wTsInicio().wsDataInicio().set(bghl112a().argumento().zMovimento());
        wTsFim().wsDataFim().set(bghl112a().argumento().zMovimento());
        wsTsInicio.set(wTsInicio());
        wsTsFim.set(wTsFim());
        hv10201Movhstcpl().movhstcpl().cMnemEgcOpex().set(bghl112a().argumento().cMnemEgcOpex());
        hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx().set(bghl112a().argumento().cPaisIsoaOeOpx());
        hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(bghl112a().argumento().cOeEgcOpex());
        hv10201Movhstcpl().movhstcpl().cUserid().set(bghl112a().argumento().cUserid());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(bghl112a().argumento().nJourBbn());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(bghl112a().argumento().nJourBbn());
        hv10201Movhstcpl().movhstcpl().nsJourBbn().set(bghl112a().argumento().nsJourBbn());
        hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh().set(bghl112a().argumento().nsJourBbnDtlh());
    }
    
    /**
     * 
     * 
     */
    public void a3300AcedeTabela() {
        naoHaMov.setTrue() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghs112a428(wsTsInicio, wsTsFim) ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                haMov.setTrue() ;
                break;
            case NOTFND:
                a3310AcederHstNormal() ;
                break;
            default :
                progDb2.setTrue() ;
                break;
        }
        if (progOk.isTrue()) {
            if (haMov.isTrue()) {
                bghl112a().detalhe().nsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
                bghl112a().detalhe().tsMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento());
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a3310AcederHstNormal() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs113a().bghl113a().initialize() ;
        hrMghs113a().bghl113a().argumento().cPaisIsoaCont().set(bghl112a().argumento().cPaisIsoaCont());
        hrMghs113a().bghl113a().argumento().cBancCont().set(bghl112a().argumento().cBancCont());
        hrMghs113a().bghl113a().argumento().cOeEgcCont().set(bghl112a().argumento().cOeEgcCont());
        hrMghs113a().bghl113a().argumento().nsRdclCont().set(bghl112a().argumento().nsRdclCont());
        hrMghs113a().bghl113a().argumento().vChkdCont().set(bghl112a().argumento().vChkdCont());
        hrMghs113a().bghl113a().argumento().cTipoCont().set(bghl112a().argumento().cTipoCont());
        hrMghs113a().bghl113a().argumento().cMoedIsoScta().set(bghl112a().argumento().cMoedIsoScta());
        hrMghs113a().bghl113a().argumento().nsDeposito().set(bghl112a().argumento().nsDeposito());
        hrMghs113a().bghl113a().argumento().zMovimento().set(bghl112a().argumento().zMovimento());
        hrMghs113a().bghl113a().argumento().cMnemEgcOpex().set(bghl112a().argumento().cMnemEgcOpex());
        hrMghs113a().bghl113a().argumento().cPaisIsoaOeOpx().set(bghl112a().argumento().cPaisIsoaOeOpx());
        hrMghs113a().bghl113a().argumento().cOeEgcOpex().set(bghl112a().argumento().cOeEgcOpex());
        hrMghs113a().bghl113a().argumento().cUserid().set(bghl112a().argumento().cUserid());
        hrMghs113a().bghl113a().argumento().nJourBbn().set(bghl112a().argumento().nJourBbn());
        hrMghs113a().bghl113a().argumento().nsJourBbn().set(bghl112a().argumento().nsJourBbn());
        hrMghs113a().bghl113a().argumento().nsJourBbnDtlh().set(bghl112a().argumento().nsJourBbnDtlh());
        hrMghs113a().run() ;
        if (hrMghs113a().bghl113a().ok().isTrue()) {
            bghl112a().detalhe().tsMovimento().set(hrMghs113a().bghl113a().detalhe().tsMovimento());
            bghl112a().detalhe().nsMovimento().set(hrMghs113a().bghl113a().detalhe().nsMovimento());
        } else {
            progStatus.set(hrMghs113a().bghl113a().cRetorno());
            hrMghs113a().setPersistenceCode(hrMghs113a().bghl113a().cSqlcode()) ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a3400ObtemInfMov() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMghs200a().bghl200a().initialize() ;
        hrMghs200a().bghl200a().argumento().cPaisIsoaCont().set(bghl112a().argumento().cPaisIsoaCont());
        hrMghs200a().bghl200a().argumento().cBancCont().set(bghl112a().argumento().cBancCont());
        hrMghs200a().bghl200a().argumento().cOeEgcCont().set(bghl112a().argumento().cOeEgcCont());
        hrMghs200a().bghl200a().argumento().nsRdclCont().set(bghl112a().argumento().nsRdclCont());
        hrMghs200a().bghl200a().argumento().vChkdCont().set(bghl112a().argumento().vChkdCont());
        hrMghs200a().bghl200a().argumento().cTipoCont().set(bghl112a().argumento().cTipoCont());
        hrMghs200a().bghl200a().argumento().cMoedIsoScta().set(bghl112a().argumento().cMoedIsoScta());
        hrMghs200a().bghl200a().argumento().nsDeposito().set(bghl112a().argumento().nsDeposito());
        hrMghs200a().bghl200a().argumento().tsMovimento().set(bghl112a().detalhe().tsMovimento());
        hrMghs200a().bghl200a().argumento().nsMovimento().set(bghl112a().detalhe().nsMovimento());
        hrMghs200a().run() ;
        if (hrMghs200a().bghl200a().ok().isTrue()) {
            bghl112a().detalhe().aAplOrig().set(hrMghs200a().bghl200a().detalhe().aAplOrig());
            bghl112a().detalhe().mMovimento().set(hrMghs200a().bghl200a().detalhe().mMovimento());
            bghl112a().detalhe().xRefMov().set(hrMghs200a().bghl200a().detalhe().xRefMov());
            bghl112a().detalhe().iDbcr().set(hrMghs200a().bghl200a().detalhe().iDbcr());
            bghl112a().detalhe().nDocOpps().set(hrMghs200a().bghl200a().detalhe().nDocOpps());
        } else {
            progStatus.set(hrMghs200a().bghl200a().cRetorno());
            hrMghs200a().setPersistenceCode(hrMghs200a().bghl200a().cSqlcode()) ;
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
        bghl112a().cRetorno().set(progStatus);
        bghl112a().cSqlcode().set(getPersistenceCode());
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
    
    public interface WsDataToday extends IDataStruct {
        
        @Data(size=4)
        IInt wsAnoToday() ;
        
        @Data(size=2)
        IInt wsMesToday() ;
        
        @Data(size=2)
        IInt wsDiaToday() ;
        
    }
    
    public interface WsDataDia extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesData() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaData() ;
        
    }
    
    public interface Bhok0002Tabelas extends IDataStruct {
        
        @Data(size=1, value="1")
        IInt bhok0002ConTabMov1() ;
        
        @Data(size=1, value="2")
        IInt bhok0002ConTabMov2() ;
        
    }
}
