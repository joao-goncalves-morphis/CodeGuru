package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl008a ;
import cgd.hy.routines.Mhyj100a ;


/**
 * 
 * APLICACAO     : GH- HISTORICO DE MOVIMENTOS
 * TABELA        : TGH00008_REFMCBL
 * DESCRICAO     : ACESSO A TABELA
 * ALTERAÇÕES :
 * 
 * migrated from program [MGHJ008A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj008a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl008a
     */
    @Data
    public abstract Bghl008a bghl008a() ;
    
    
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
     * @return instancia da classe Vwsdghps00801Refmcbl
     */
    @Data
    protected abstract Vwsdghps00801Refmcbl hv00801Refmcbl() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
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
    @Condition("097")
    protected ICondition progNaoExisteMov ;
    @Data
    @Condition("328")
    protected ICondition progMovJaExiste ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    
    
    @Data(size=1, value=" ")
    protected IString wsCrtlChave ;
    @Data
    @Condition("A")
    protected ICondition haChaveMov ;
    @Data
    @Condition("B")
    protected ICondition haChaveJornal ;
    @Data
    @Condition("C")
    protected ICondition haAmbos ;
    
    
    @Data(size=8, value="MHYJ100A")
    protected IString bhyk0002RotActTabAct ;
    
    /**
     * @return instancia da classe local Bhok0002Tabelas
     */
    @Data
    protected abstract Bhok0002Tabelas bhok0002Tabelas() ;
    
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
    
    
    @Data(size=10)
    protected IString wsDataMov ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
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
     * 
     * 
     */
    public void s1000Iniciar() {
        progOk.setTrue() ;
        bghl008a().cRtnoEvenSwal().initialize() ;
        bghl008a().cSqlcode().initialize() ;
        bghl008a().cTipoErro().initialize() ;
        bghl008a().nmTabela().initialize() ;
        wsCrtlChave.initialize() ;
        if (bghl008a().argumento().cPaisIsoaCont().isEmpty() || 
            bghl008a().argumento().cBancCont().isEqual(0) || 
            bghl008a().argumento().cOeEgcCont().isEqual(0) || 
            bghl008a().argumento().nsRdclCont().isEqual(0) || 
            bghl008a().argumento().cMoedIsoScta().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            wsErrosFuncao.setTrue() ;
        }
        if (progOk.isTrue()) {
            if (!bghl008a().leitura().isTrue()) {
                if (bghl008a().argumento().tsMovimento().isEmpty()) {
                    haChaveJornal.setTrue() ;
                } else if (!bghl008a().argumento().zMovimento().isEmpty() && 
                    !bghl008a().argumento().nJourBbn().isEqual(0)) {
                    haAmbos.setTrue() ;
                } else {
                    haChaveMov.setTrue() ;
                }
            }
        }
        if (progOk.isTrue()) {
            if (haChaveMov.isTrue() && 
                bghl008a().argumento().nsMovimento().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
                wsErrosFuncao.setTrue() ;
            }
        }
        if (haChaveJornal.isTrue() && 
            (bghl008a().argumento().zMovimento().isEmpty() || 
            bghl008a().argumento().cMnemEgcOpex().isEmpty() || 
            bghl008a().argumento().cPaisIsoaOeOpx().isEmpty() || 
            bghl008a().argumento().cOeEgcOpex().isEqual(0) || 
            bghl008a().argumento().cUserid().isEmpty() || 
            bghl008a().argumento().nJourBbn().isEqual(0))) {
            progDadosInvalidos.setTrue() ;
            wsErrosFuncao.setTrue() ;
        }
        if (haAmbos.isTrue() && 
            (bghl008a().argumento().zMovimento().isEmpty() || 
            bghl008a().argumento().cMnemEgcOpex().isEmpty() || 
            bghl008a().argumento().cPaisIsoaOeOpx().isEmpty() || 
            bghl008a().argumento().cOeEgcOpex().isEqual(0) || 
            bghl008a().argumento().cUserid().isEmpty() || 
            bghl008a().argumento().nJourBbn().isEqual(0) || 
            bghl008a().argumento().tsMovimento().isEmpty() || 
            bghl008a().argumento().nsMovimento().isEqual(0))) {
            progDadosInvalidos.setTrue() ;
            wsErrosFuncao.setTrue() ;
        }
        if (bghl008a().insercao().isTrue()) {
            if (bghl008a().detalhe().xRcnzMcblPrim().isEmpty() && 
                bghl008a().detalhe().xRcnzMcblSegn().isEmpty() && 
                bghl008a().detalhe().xRcnzMcblTerc().isEmpty() && 
                bghl008a().detalhe().cUsidActzUlt().isEmpty()) {
                progDadosInvalidos.setTrue() ;
                wsErrosFuncao.setTrue() ;
            }
        }
        if (progOk.isTrue()) {
            wsDataToday().set(getTimeAsLong());
            wsDataDia().wAnoData().set(wsDataToday().wsAnoToday());
            wsDataDia().wMesData().set(wsDataToday().wsMesToday());
            wsDataDia().wDiaData().set(wsDataToday().wsDiaToday());
        }
        if (progOk.isTrue()) {
            if (haChaveMov.isTrue()) {
                wsDataMov.set(bghl008a().argumento().tsMovimento().get(1, 10));
            } else {
                wsDataMov.set(bghl008a().argumento().zMovimento());
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
        if (!bghl008a().leitura().isTrue()) {
            if (!haAmbos.isTrue()) {
                if (wsDataMov.isEqual(wsDataDia())) {
                    a5000ObtemDadosHo() ;
                } else {
                    a5000ConsultaTgh102() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a5100FormatarArea() ;
        }
        if (progOk.isTrue()) {
            if (bghl008a().leitura().isTrue()) {
                a5200Leitura() ;
            } else if (bghl008a().actualizacao().isTrue()) {
                a5300Actualizacao() ;
            } else if (bghl008a().insercao().isTrue()) {
                a5410Insercao() ;
            } else if (bghl008a().eliminacao().isTrue()) {
                a5500Eliminacao() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5000ObtemDadosHo() {
        /**
         * *----------------------------------------------------------------*
         */
        a5001ObtemTabMov() ;
        if (progOk.isTrue()) {
            a5002AcedeTabHo() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5001ObtemTabMov() {
        /**
         * *----------------------------------------------------------------*
         */
        hrMhyj100a().bhyl100a().commarea().initialize() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().visualizacao().setTrue() ;
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().aAplicacao().set("HY");
        hrMhyj100a().bhyl100a().commarea().dadosEntrada().cGrupTabAtiv().set("TABARQ");
        hrMhyj100a().run() ;
        if (!hrMhyj100a().bhyl100a().commarea().dadosSaida().semErros().isTrue()) {
            bghl008a().cSqlcode().set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cSqlcode());
            progStatus.set(hrMhyj100a().bhyl100a().commarea().dadosSaida().cRtnoEvenSwal());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5002AcedeTabHo() {
        /**
         * *----------------------------------------------------------------*
         */
        hv02001Movdia1().movdia1().initialize() ;
        hv02101Movdia2().movdia2().initialize() ;
        hv02001Movdia1().movdia1().cPaisIsoaCont().set(bghl008a().argumento().cPaisIsoaCont());
        hv02001Movdia1().movdia1().cBancCont().set(bghl008a().argumento().cBancCont());
        hv02001Movdia1().movdia1().cOeEgcCont().set(bghl008a().argumento().cOeEgcCont());
        hv02001Movdia1().movdia1().nsRdclCont().set(bghl008a().argumento().nsRdclCont());
        hv02001Movdia1().movdia1().vChkdCont().set(bghl008a().argumento().vChkdCont());
        hv02001Movdia1().movdia1().cTipoCont().set(bghl008a().argumento().cTipoCont());
        hv02001Movdia1().movdia1().cMoedIsoScta().set(bghl008a().argumento().cMoedIsoScta());
        hv02001Movdia1().movdia1().nsDeposito().set(bghl008a().argumento().nsDeposito());
        if (haChaveMov.isTrue()) {
            hv02001Movdia1().movdia1().nsMovimento().set(bghl008a().argumento().nsMovimento());
            hv02001Movdia1().movdia1().zMovimento().set(bghl008a().argumento().tsMovimento().get(1, 10));
        } else {
            hv02001Movdia1().movdia1().zMovimento().set(bghl008a().argumento().zMovimento());
            hv02001Movdia1().movdia1().cMnemEgcOpex().set(bghl008a().argumento().cMnemEgcOpex());
            hv02001Movdia1().movdia1().cPaisIsoaOeOpx().set(bghl008a().argumento().cPaisIsoaOeOpx());
            hv02001Movdia1().movdia1().cOeEgcOpex().set(bghl008a().argumento().cOeEgcOpex());
            hv02001Movdia1().movdia1().cUserid().set(bghl008a().argumento().cUserid());
            hv02001Movdia1().movdia1().nJourBbn().set(bghl008a().argumento().nJourBbn());
            hv02001Movdia1().movdia1().nsJourBbn().set(bghl008a().argumento().nsJourBbn());
            hv02001Movdia1().movdia1().nsJourBbnDtlh().set(bghl008a().argumento().nsJourBbnDtlh());
        }
        if (hrMhyj100a().bhyl100a().commarea().dadosSaida().cImgGrupTab().isEqual(bhok0002Tabelas().bhok0002ConTabMov1())) {
            if (haChaveJornal.isTrue()) {
                a5003AcedeTho20Jornal() ;
            } else {
                a5004AcedeTho20Mov() ;
            }
        } else if (haChaveJornal.isTrue()) {
            a5005AcedeTho21Jornal() ;
        } else {
            a5006AcedeTho21Mov() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5003AcedeTho20Jornal() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02001_MOVDIA1
         */
        hv02001Movdia1().selectMghj008a392() ;
        if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl008a().argumento().nsMovimento().set(hv02001Movdia1().movdia1().nsMovimento());
            bghl008a().argumento().tsMovimento().get(1, 10).set(bghl008a().argumento().zMovimento()) ;
            bghl008a().argumento().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5004AcedeTho20Mov() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02001_MOVDIA1
         */
        hv02001Movdia1().selectMghj008a440() ;
        if (hv02001Movdia1().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02001Movdia1().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02001Movdia1().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl008a().argumento().zMovimento().set(hv02001Movdia1().movdia1().zMovimento());
            bghl008a().argumento().cMnemEgcOpex().set(hv02001Movdia1().movdia1().cMnemEgcOpex());
            bghl008a().argumento().cPaisIsoaOeOpx().set(hv02001Movdia1().movdia1().cPaisIsoaOeOpx());
            bghl008a().argumento().cOeEgcOpex().set(hv02001Movdia1().movdia1().cOeEgcOpex());
            bghl008a().argumento().cUserid().set(hv02001Movdia1().movdia1().cUserid());
            bghl008a().argumento().nJourBbn().set(hv02001Movdia1().movdia1().nJourBbn());
            bghl008a().argumento().nsJourBbn().set(hv02001Movdia1().movdia1().nsJourBbn());
            bghl008a().argumento().nsJourBbnDtlh().set(hv02001Movdia1().movdia1().nsJourBbnDtlh());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5005AcedeTho21Jornal() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02101_MOVDIA2
         */
        hv02101Movdia2().selectMghj008a499(hv02001Movdia1().movdia1()) ;
        if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl008a().argumento().nsMovimento().set(hv02101Movdia2().movdia2().nsMovimento());
            bghl008a().argumento().tsMovimento().get(1, 10).set(bghl008a().argumento().zMovimento()) ;
            bghl008a().argumento().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5006AcedeTho21Mov() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VHO02101_MOVDIA2
         */
        hv02101Movdia2().selectMghj008a546(hv02001Movdia1().movdia1()) ;
        if (hv02101Movdia2().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
        }
        if (hv02101Movdia2().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv02101Movdia2().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
        }
        if (progOk.isTrue()) {
            bghl008a().argumento().zMovimento().set(hv02101Movdia2().movdia2().zProcessamento());
            bghl008a().argumento().cMnemEgcOpex().set(hv02101Movdia2().movdia2().cMnemEgcOpex());
            bghl008a().argumento().cPaisIsoaOeOpx().set(hv02101Movdia2().movdia2().cPaisIsoaOeOpx());
            bghl008a().argumento().cOeEgcOpex().set(hv02101Movdia2().movdia2().cOeEgcOpex());
            bghl008a().argumento().cUserid().set(hv02101Movdia2().movdia2().cUserid());
            bghl008a().argumento().nJourBbn().set(hv02101Movdia2().movdia2().nJourBbn());
            bghl008a().argumento().nsJourBbn().set(hv02101Movdia2().movdia2().nsJourBbn());
            bghl008a().argumento().nsJourBbnDtlh().set(hv02101Movdia2().movdia2().nsJourBbnDtlh());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5000ConsultaTgh102() {
        /**
         * *----------------------------------------------------------------*
         */
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghl008a().argumento().cPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bghl008a().argumento().cBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghl008a().argumento().cOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghl008a().argumento().nsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghl008a().argumento().vChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghl008a().argumento().cTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghl008a().argumento().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghl008a().argumento().nsDeposito());
        if (haChaveMov.isTrue()) {
            hv10201Movhstcpl().movhstcpl().nsMovimento().set(bghl008a().argumento().nsMovimento());
            hv10201Movhstcpl().movhstcpl().tsMovimento().set(bghl008a().argumento().tsMovimento());
            bghl008a().argumento().zMovimento().set(bghl008a().argumento().tsMovimento().get(1, 10));
        } else {
            hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10).set(bghl008a().argumento().zMovimento()) ;
            hv10201Movhstcpl().movhstcpl().tsMovimento().get(11, 16).set("-00.00.00.000000") ;
            bghl008a().argumento().tsMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento());
            hv10201Movhstcpl().movhstcpl().cMnemEgcOpex().set(bghl008a().argumento().cMnemEgcOpex());
            hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx().set(bghl008a().argumento().cPaisIsoaOeOpx());
            hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(bghl008a().argumento().cOeEgcOpex());
            hv10201Movhstcpl().movhstcpl().cUserid().set(bghl008a().argumento().cUserid());
            hv10201Movhstcpl().movhstcpl().nJourBbn().set(bghl008a().argumento().nJourBbn());
            hv10201Movhstcpl().movhstcpl().nsJourBbn().set(bghl008a().argumento().nsJourBbn());
            hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh().set(bghl008a().argumento().nsJourBbnDtlh());
        }
        if (haChaveJornal.isTrue()) {
            a5001AcedeTgh102Jornal() ;
        } else {
            a5002AcedeTgh102Mov() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5001AcedeTgh102Jornal() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghj008a648() ;
        switch (hv10201Movhstcpl().getPersistenceCode()) {
            case NORMAL:
                bghl008a().argumento().tsMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento());
                bghl008a().argumento().nsMovimento().set(hv10201Movhstcpl().movhstcpl().nsMovimento());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
                wsErrosFuncao.setTrue() ;
                break;
            default :
                progDb2.setTrue() ;
                wsErrosFuncao.setTrue() ;
                bghl008a().cSqlcode().set(getPersistenceCode());
                break;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5002AcedeTgh102Mov() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghj008a692() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
            wsErrosFuncao.setTrue() ;
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            wsErrosFuncao.setTrue() ;
            bghl008a().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
        }
        if (progOk.isTrue()) {
            bghl008a().argumento().zMovimento().set(bghl008a().argumento().tsMovimento().get(1, 10));
            bghl008a().argumento().cMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
            bghl008a().argumento().cPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
            bghl008a().argumento().cOeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
            bghl008a().argumento().cUserid().set(hv10201Movhstcpl().movhstcpl().cUserid());
            bghl008a().argumento().nJourBbn().set(hv10201Movhstcpl().movhstcpl().nJourBbn());
            bghl008a().argumento().nsJourBbn().set(hv10201Movhstcpl().movhstcpl().nsJourBbn());
            bghl008a().argumento().nsJourBbnDtlh().set(hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh());
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
        hv00801Refmcbl().refmcbl().initialize() ;
        hv00801Refmcbl().refmcbl().cPaisIsoaCont().set(bghl008a().argumento().cPaisIsoaCont());
        hv00801Refmcbl().refmcbl().cBancCont().set(bghl008a().argumento().cBancCont());
        hv00801Refmcbl().refmcbl().cOeEgcCont().set(bghl008a().argumento().cOeEgcCont());
        hv00801Refmcbl().refmcbl().nsRdclCont().set(bghl008a().argumento().nsRdclCont());
        hv00801Refmcbl().refmcbl().vChkdCont().set(bghl008a().argumento().vChkdCont());
        hv00801Refmcbl().refmcbl().cTipoCont().set(bghl008a().argumento().cTipoCont());
        hv00801Refmcbl().refmcbl().cMoedIsoScta().set(bghl008a().argumento().cMoedIsoScta());
        hv00801Refmcbl().refmcbl().nsDeposito().set(bghl008a().argumento().nsDeposito());
        hv00801Refmcbl().refmcbl().tsMovimento().set(bghl008a().argumento().tsMovimento());
        hv00801Refmcbl().refmcbl().nsMovimento().set(bghl008a().argumento().nsMovimento());
        if (bghl008a().insercao().isTrue() || bghl008a().actualizacao().isTrue()) {
            if (!bghl008a().detalhe().xRcnzMcblPrim().isEmpty()) {
                hv00801Refmcbl().refmcbl().xRcnzMcblPrim().set(bghl008a().detalhe().xRcnzMcblPrim());
            }
            if (!bghl008a().detalhe().xRcnzMcblSegn().isEmpty()) {
                hv00801Refmcbl().refmcbl().xRcnzMcblSegn().set(bghl008a().detalhe().xRcnzMcblSegn());
            }
            if (!bghl008a().detalhe().xRcnzMcblTerc().isEmpty()) {
                hv00801Refmcbl().refmcbl().xRcnzMcblTerc().set(bghl008a().detalhe().xRcnzMcblTerc());
            }
        }
        if (bghl008a().insercao().isTrue()) {
            hv00801Refmcbl().refmcbl().zMovimento().set(bghl008a().argumento().zMovimento());
            hv00801Refmcbl().refmcbl().cMnemEgcOpex().set(bghl008a().argumento().cMnemEgcOpex());
            hv00801Refmcbl().refmcbl().cPaisIsoaOeOpx().set(bghl008a().argumento().cPaisIsoaOeOpx());
            hv00801Refmcbl().refmcbl().cOeEgcOpex().set(bghl008a().argumento().cOeEgcOpex());
            hv00801Refmcbl().refmcbl().cUserid().set(bghl008a().argumento().cUserid());
            hv00801Refmcbl().refmcbl().nJourBbn().set(bghl008a().argumento().nJourBbn());
            hv00801Refmcbl().refmcbl().nsJourBbn().set(bghl008a().argumento().nsJourBbn());
            hv00801Refmcbl().refmcbl().nsJourBbnDtlh().set(bghl008a().argumento().nsJourBbnDtlh());
            hv00801Refmcbl().refmcbl().cUsidActzUlt().set(bghl008a().detalhe().cUsidActzUlt());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5200Leitura() {
        /**
         * *----------------------------------------------------------------*
         */
        if (bghl008a().argumento().tsMovimento().isEmpty()) {
            /**
             * Migration Note:
             * call to extracted method to access (SELECT) table VGH00801_REFMCBL
             */
            hv00801Refmcbl().selectMghj008a801() ;
        } else {
            /**
             * Migration Note:
             * call to extracted method to access (SELECT) table VGH00801_REFMCBL
             */
            hv00801Refmcbl().selectMghj008a839() ;
        }
        switch (getPersistenceCode()) {
            case NORMAL:
                bghl008a().argumento().tsMovimento().set(hv00801Refmcbl().refmcbl().tsMovimento());
                bghl008a().detalhe().xRcnzMcblPrim().set(hv00801Refmcbl().refmcbl().xRcnzMcblPrim());
                bghl008a().detalhe().xRcnzMcblSegn().set(hv00801Refmcbl().refmcbl().xRcnzMcblSegn());
                bghl008a().detalhe().xRcnzMcblTerc().set(hv00801Refmcbl().refmcbl().xRcnzMcblTerc());
                bghl008a().detalhe().cUsidActzUlt().set(hv00801Refmcbl().refmcbl().cUsidActzUlt());
                break;
            case NOTFND:
                progNaoExisteMov.setTrue() ;
                wsErrosFuncao.setTrue() ;
                break;
            default :
                progDb2.setTrue() ;
                wsErrosFuncao.setTrue() ;
                bghl008a().cSqlcode().set(getPersistenceCode());
                break;
        }
    }
    
    /**
     * 
     * 
     */
    public void a5300Actualizacao() {
        /**
         * *----------------------------------------------------------------*
         */
        if (!hv00801Refmcbl().refmcbl().xRcnzMcblPrim().isEmpty()) {
            /**
             * Migration Note:
             * call to extracted method to access (UPDATE) table VGH00801_REFMCBL
             */
            hv00801Refmcbl().updateMghj008a906() ;
            if (hv00801Refmcbl().getPersistenceCode() == PersistenceCode.NOTFND) {
                progNaoExisteMov.setTrue() ;
                wsErrosFuncao.setTrue() ;
            }
            if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NOTFND && 
                hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL) {
                progDb2.setTrue() ;
                wsErrosFuncao.setTrue() ;
                bghl008a().cSqlcode().set(hv00801Refmcbl().getPersistenceCode());
            }
        }
        if (progOk.isTrue()) {
            if (!hv00801Refmcbl().refmcbl().xRcnzMcblSegn().isEmpty()) {
                /**
                 * Migration Note:
                 * call to extracted method to access (UPDATE) table VGH00801_REFMCBL
                 */
                hv00801Refmcbl().updateMghj008a938() ;
                if (hv00801Refmcbl().getPersistenceCode() == PersistenceCode.NOTFND) {
                    progNaoExisteMov.setTrue() ;
                    wsErrosFuncao.setTrue() ;
                }
                if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NOTFND && 
                    hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL) {
                    progDb2.setTrue() ;
                    wsErrosFuncao.setTrue() ;
                    bghl008a().cSqlcode().set(hv00801Refmcbl().getPersistenceCode());
                }
            }
        }
        if (progOk.isTrue()) {
            if (!hv00801Refmcbl().refmcbl().xRcnzMcblTerc().isEmpty()) {
                /**
                 * Migration Note:
                 * call to extracted method to access (UPDATE) table VGH00801_REFMCBL
                 */
                hv00801Refmcbl().updateMghj008a971() ;
                if (hv00801Refmcbl().getPersistenceCode() == PersistenceCode.NOTFND) {
                    progNaoExisteMov.setTrue() ;
                    wsErrosFuncao.setTrue() ;
                }
                if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NOTFND && 
                    hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL) {
                    progDb2.setTrue() ;
                    wsErrosFuncao.setTrue() ;
                    bghl008a().cSqlcode().set(hv00801Refmcbl().getPersistenceCode());
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a5410Insercao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00801_REFMCBL
         */
        hv00801Refmcbl().insertMghj008a1007() ;
        if (hv00801Refmcbl().getPersistenceCode() == PersistenceCode.DUPLICATED) {
            progMovJaExiste.setTrue() ;
            wsErrosFuncao.setTrue() ;
        }
        if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.DUPLICATED && 
            hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            wsAbendDb2.setTrue() ;
            bghl008a().cSqlcode().set(hv00801Refmcbl().getPersistenceCode());
        }
    }
    
    /**
     * 
     * 
     */
    public void a5500Eliminacao() {
        /**
         * *----------------------------------------------------------------*
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH00801_REFMCBL
         */
        hv00801Refmcbl().deleteMghj008a1079() ;
        if (hv00801Refmcbl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExisteMov.setTrue() ;
            wsErrosFuncao.setTrue() ;
        }
        if (hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00801Refmcbl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            wsAbendDb2.setTrue() ;
            bghl008a().cSqlcode().set(hv00801Refmcbl().getPersistenceCode());
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
        bghl008a().cRtnoEvenSwal().set(progStatus);
        bghl008a().cTipoErro().set(wCTipoErroBbn);
        bghl008a().cSqlcode().set(getPersistenceCode());
        bghl008a().nmTabela().set("VGH00801");
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
    
    public interface Bhok0002Tabelas extends IDataStruct {
        
        @Data(size=1, value="1")
        IInt bhok0002ConTabMov1() ;
        
        @Data(size=1, value="2")
        IInt bhok0002ConTabMov2() ;
        
    }
    
    public interface WTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestamp
         */
        @Data
        WDataTimestamp wDataTimestamp() ;
        
        /**
         * @return instancia da classe local WTimerTimestamp
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerTimestamp wTimerTimestamp() ;
        
        
        public interface WDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wHh() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wSs() ;
            
            @Data(size=6, lpadding=1, lpaddingValue=".")
            IInt wDd() ;
            
        }
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
}
