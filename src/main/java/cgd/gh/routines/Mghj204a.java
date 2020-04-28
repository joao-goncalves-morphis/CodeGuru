package cgd.gh.routines;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseRoutine ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.database.* ;
import cgd.gh.structures.link.Bghl204a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS DE ASSIVAS
 * DESCRICAO     :
 * -  PESQUISA TIPO 1
 * DEVOLVE N-DOC-OPPS
 * -  PESQUISA TIPO 2
 * DEVOLVE CHAVE DO JOURNAL
 * GH852 - GBABAS - INCLUSAO DE OUTRAS APLICACOES QUE MOVIMENTAM
 * EM NA'S
 * 
 * migrated from program [MGHJ204A]
 * 
 * @version 2.0
 * 
 */
public abstract class Mghj204a extends CgdGhBaseRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bghl204a
     */
    @Data
    public abstract Bghl204a bghl204a() ;
    
    
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
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
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("093")
    protected ICondition progJaExiste ;
    @Data
    @Condition("094")
    protected ICondition progEstadoInv ;
    @Data
    @Condition("095")
    protected ICondition progPedidoInvalido ;
    @Data
    @Condition("096")
    protected ICondition progPedidoConcluido ;
    @Data
    @Condition("216")
    protected ICondition progDb2 ;
    
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=26)
    protected IString wsTimestampMin ;
    
    @Data(size=26)
    protected IString wsTimestampMax ;
    
    
    
    /**
     * 
     * 
     */
    public void s10000Iniciar() {
        progOk.setTrue() ;
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghl204a().commarea().areaErro().cSqlcode().initialize() ;
        bghl204a().commarea().areaErro().cRtnoEvenSwal().initialize() ;
        bghl204a().commarea().areaErro().aAplErr().initialize() ;
        bghl204a().commarea().areaErro().msgErrob().initialize() ;
        bghl204a().commarea().areaErro().nmTabela().initialize() ;
        bghl204a().commarea().areaErro().modOrigemErro().initialize() ;
        bghl204a().commarea().areaErro().chAcesso().initialize() ;
        bghl204a().commarea().areaErro().cTipoErroBbn().initialize() ;
        bghl204a().commarea().dadosOutput().nChequeO().initialize() ;
        bghl204a().commarea().dadosOutput().zProcessamentoO().initialize() ;
        bghl204a().commarea().dadosOutput().cMnemEgcOpexO().initialize() ;
        bghl204a().commarea().dadosOutput().cPaisIsoaOeOpxO().initialize() ;
        bghl204a().commarea().dadosOutput().cOeEgcOpexO().initialize() ;
        bghl204a().commarea().dadosOutput().cUseridO().initialize() ;
        bghl204a().commarea().dadosOutput().nJourBbnO().initialize() ;
        bghl204a().commarea().dadosOutput().nsJourBbnO().initialize() ;
        bghl204a().commarea().dadosOutput().nsJourBbnDtlhO().initialize() ;
        if (!bghl204a().commarea().dadosInput().pesquisaI().isEqual("P1") && 
            !bghl204a().commarea().dadosInput().pesquisaI().isEqual("P2")) {
            progDadosInvalidos.setTrue() ;
            bghl204a().commarea().areaErro().erroFuncao().setTrue() ;
            bghl204a().commarea().areaErro().msgErrob().set("TIPO DE PESQUISA INVALIDO");
        }
        if (bghl204a().commarea().dadosInput().cPaisIsoaContI().isEmpty() || 
            bghl204a().commarea().dadosInput().cBancContI().isEqual(0) || 
            bghl204a().commarea().dadosInput().cOeEgcContI().isEqual(0) || 
            bghl204a().commarea().dadosInput().nsRdclContI().isEqual(0) || 
            bghl204a().commarea().dadosInput().cMoedIsoSctaI().isEmpty()) {
            progDadosInvalidos.setTrue() ;
            bghl204a().commarea().areaErro().erroFuncao().setTrue() ;
            bghl204a().commarea().areaErro().msgErrob().set("DADOS OBRIGATORIOS INVÁLIDOS");
        }
        if (progOk.isTrue()) {
            if (bghl204a().commarea().dadosInput().pesquisaP1I().isTrue()) {
                if (bghl204a().commarea().dadosInput().cMnemEgcOpexI().isEmpty() || 
                    bghl204a().commarea().dadosInput().cPaisIsoaOeOpxI().isEmpty() || 
                    bghl204a().commarea().dadosInput().cOeEgcOpexI().isEqual(0) || 
                    bghl204a().commarea().dadosInput().cUseridI().isEmpty() || 
                    bghl204a().commarea().dadosInput().nJourBbnI().isEqual(0) || 
                    bghl204a().commarea().dadosInput().zProcessamentoI().isEmpty()) {
                    progDadosInvalidos.setTrue() ;
                    bghl204a().commarea().areaErro().erroFuncao().setTrue() ;
                    bghl204a().commarea().areaErro().msgErrob().set("DADOS FACULTATIVOS INVÁLIDOS");
                }
            } else if (bghl204a().commarea().dadosInput().nChequeI().isEqual(0)) {
                progDadosInvalidos.setTrue() ;
                bghl204a().commarea().areaErro().erroFuncao().setTrue() ;
                bghl204a().commarea().areaErro().msgErrob().set("DADOS FACULTATIVOS INVÁLIDOS");
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (progOk.isTrue()) {
            if (bghl204a().commarea().dadosInput().pesquisaP1I().isTrue()) {
                a31000PesquisaP1() ;
            } else if (bghl204a().commarea().dadosInput().pesquisaP2I().isTrue()) {
                a32000PesquisaP2() ;
            } else {
                progDadosInvalidos.setTrue() ;
                bghl204a().commarea().areaErro().erroFuncao().setTrue() ;
                bghl204a().commarea().areaErro().msgErrob().set("TIPO DE PESQUISA INVÁLIDO");
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void a31000PesquisaP1() {
        log(TraceLevel.Debug, "A31000-PESQUISA-P1");
        if (bghl204a().commarea().dadosInput().nsJourBbnI().isGreater(0) && 
            bghl204a().commarea().dadosInput().nsJourBbnDtlhI().isGreater(0)) {
            hv10201Movhstcpl().movhstcpl().nsJourBbn().set(bghl204a().commarea().dadosInput().nsJourBbnI());
            hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh().set(bghl204a().commarea().dadosInput().nsJourBbnDtlhI());
            a31300Select102() ;
        } else {
            if (bghl204a().commarea().dadosInput().nsJourBbnI().isGreater(0)) {
                hv10201Movhstcpl().movhstcpl().nsJourBbn().set(bghl204a().commarea().dadosInput().nsJourBbnI());
            } else {
                hv10201Movhstcpl().movhstcpl().nsJourBbn().set(0);
            }
            hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh().set(0);
            a31301Select102Sdtl() ;
        }
        if (progOk.isTrue()) {
            a31600Select002() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a31300Select102() {
        log(TraceLevel.Debug, "A31300-SELECT-102");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghl204a().commarea().dadosInput().cPaisIsoaContI());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bghl204a().commarea().dadosInput().cBancContI());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghl204a().commarea().dadosInput().cOeEgcContI());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghl204a().commarea().dadosInput().nsRdclContI());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghl204a().commarea().dadosInput().vChkdContI());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghl204a().commarea().dadosInput().cTipoContI());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghl204a().commarea().dadosInput().cMoedIsoSctaI());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghl204a().commarea().dadosInput().nsDepositoI());
        wTimestamp().wDataTimestamp().set(bghl204a().commarea().dadosInput().zProcessamentoI());
        wTimestamp().wTimerTimestamp().wHh().set(0);
        wTimestamp().wTimerTimestamp().wMm().set(0);
        wTimestamp().wTimerTimestamp().wSs().set(0);
        wTimestamp().wTimerTimestamp().wDd().set(0);
        wsTimestampMin.set(wTimestamp());
        wTimestamp().wTimerTimestamp().wHh().set(23);
        wTimestamp().wTimerTimestamp().wMm().set(59);
        wTimestamp().wTimerTimestamp().wSs().set(59);
        wTimestamp().wTimerTimestamp().wDd().set(999999);
        wsTimestampMax.set(wTimestamp());
        hv10201Movhstcpl().movhstcpl().cMnemEgcOpex().set(bghl204a().commarea().dadosInput().cMnemEgcOpexI());
        hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx().set(bghl204a().commarea().dadosInput().cPaisIsoaOeOpxI());
        hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(bghl204a().commarea().dadosInput().cOeEgcOpexI());
        hv10201Movhstcpl().movhstcpl().cUserid().set(bghl204a().commarea().dadosInput().cUseridI());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(bghl204a().commarea().dadosInput().nJourBbnI());
        hv10201Movhstcpl().movhstcpl().nsJourBbn().set(bghl204a().commarea().dadosInput().nsJourBbnI());
        hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh().set(bghl204a().commarea().dadosInput().nsJourBbnDtlhI());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghj204a301(wsTimestampMin, wsTimestampMax) ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("NOT FOUND");
            bghl204a().commarea().areaErro().nmTabela().set("VGH10201");
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("ERRO SELECT");
            bghl204a().commarea().areaErro().nmTabela().set("VGH10201");
        }
    }
    
    /**
     * 
     * 
     */
    public void a31301Select102Sdtl() {
        log(TraceLevel.Debug, "A31301-SELECT-102-SDTL");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghl204a().commarea().dadosInput().cPaisIsoaContI());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bghl204a().commarea().dadosInput().cBancContI());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghl204a().commarea().dadosInput().cOeEgcContI());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghl204a().commarea().dadosInput().nsRdclContI());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghl204a().commarea().dadosInput().vChkdContI());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghl204a().commarea().dadosInput().cTipoContI());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghl204a().commarea().dadosInput().cMoedIsoSctaI());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghl204a().commarea().dadosInput().nsDepositoI());
        wTimestamp().wDataTimestamp().set(bghl204a().commarea().dadosInput().zProcessamentoI());
        wTimestamp().wTimerTimestamp().wHh().set(0);
        wTimestamp().wTimerTimestamp().wMm().set(0);
        wTimestamp().wTimerTimestamp().wSs().set(0);
        wTimestamp().wTimerTimestamp().wDd().set(0);
        wsTimestampMin.set(wTimestamp());
        wTimestamp().wTimerTimestamp().wHh().set(23);
        wTimestamp().wTimerTimestamp().wMm().set(59);
        wTimestamp().wTimerTimestamp().wSs().set(59);
        wTimestamp().wTimerTimestamp().wDd().set(999999);
        wsTimestampMax.set(wTimestamp());
        hv10201Movhstcpl().movhstcpl().cMnemEgcOpex().set(bghl204a().commarea().dadosInput().cMnemEgcOpexI());
        hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx().set(bghl204a().commarea().dadosInput().cPaisIsoaOeOpxI());
        hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(bghl204a().commarea().dadosInput().cOeEgcOpexI());
        hv10201Movhstcpl().movhstcpl().cUserid().set(bghl204a().commarea().dadosInput().cUseridI());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(bghl204a().commarea().dadosInput().nJourBbnI());
        hv10201Movhstcpl().movhstcpl().nsJourBbn().set(bghl204a().commarea().dadosInput().nsJourBbnI());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghj204a389(wsTimestampMin, wsTimestampMax) ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("NOT FOUND");
            bghl204a().commarea().areaErro().nmTabela().set("VGH10201");
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("ERRO SELECT2");
            bghl204a().commarea().areaErro().nmTabela().set("VGH10201");
        }
    }
    
    /**
     * 
     * 
     */
    public void a31600Select002() {
        log(TraceLevel.Debug, "A31600-SELECT-002");
        hv00201Movhst().movhst().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectMghj204a446(hv10201Movhstcpl().movhstcpl(), bghl204a().commarea().dadosOutput()) ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("NOT FOUND");
            bghl204a().commarea().areaErro().nmTabela().set("VGH00201");
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("ERRO SELECT");
            bghl204a().commarea().areaErro().nmTabela().set("VGH00201");
        }
    }
    
    /**
     * 
     * 
     */
    public void a32000PesquisaP2() {
        log(TraceLevel.Debug, "A32000-PESQUISA-P2");
        a21300Select002() ;
        if (progOk.isTrue()) {
            a32600Select102() ;
        }
    }
    
    /**
     * 
     * 
     */
    public void a21300Select002() {
        log(TraceLevel.Debug, "A21300-SELECT-002");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(bghl204a().commarea().dadosInput().cPaisIsoaContI());
        hv00201Movhst().movhst().cBancCont().set(bghl204a().commarea().dadosInput().cBancContI());
        hv00201Movhst().movhst().cOeEgcCont().set(bghl204a().commarea().dadosInput().cOeEgcContI());
        hv00201Movhst().movhst().nsRdclCont().set(bghl204a().commarea().dadosInput().nsRdclContI());
        hv00201Movhst().movhst().vChkdCont().set(bghl204a().commarea().dadosInput().vChkdContI());
        hv00201Movhst().movhst().cTipoCont().set(bghl204a().commarea().dadosInput().cTipoContI());
        hv00201Movhst().movhst().cMoedIsoScta().set(bghl204a().commarea().dadosInput().cMoedIsoSctaI());
        hv00201Movhst().movhst().nsDeposito().set(bghl204a().commarea().dadosInput().nsDepositoI());
        hv00201Movhst().movhst().nDocOpps().set(bghl204a().commarea().dadosInput().nChequeI());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectMghj204a525() ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("NOT FOUND");
            bghl204a().commarea().areaErro().nmTabela().set("VGH00201");
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv00201Movhst().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("ERRO SELECT");
            bghl204a().commarea().areaErro().nmTabela().set("VGH00201");
        }
    }
    
    /**
     * 
     * 
     */
    public void a32600Select102() {
        log(TraceLevel.Debug, "A32600-SELECT-102");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectMghj204a574(hv00201Movhst().movhst(), bghl204a().commarea().dadosOutput()) ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("NOT FOUND");
            bghl204a().commarea().areaErro().nmTabela().set("VGH10201");
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            progDb2.setTrue() ;
            bghl204a().commarea().areaErro().abendDb2().setTrue() ;
            bghl204a().commarea().areaErro().cSqlcode().set(hv10201Movhstcpl().getPersistenceCode());
            bghl204a().commarea().areaErro().msgErrob().set("ERRO SELECT");
            bghl204a().commarea().areaErro().nmTabela().set("VGH10201");
        }
    }
    
    /**
     * 
     * 
     */
    public void s50000Responder() {
        log(TraceLevel.Debug, "S50000-RESPONDER");
        if (!progOk.isTrue()) {
            bghl204a().commarea().areaErro().cRtnoEvenSwal().set(progStatus);
            bghl204a().commarea().areaErro().aAplErr().set("GH");
            bghl204a().commarea().areaErro().modOrigemErro().set(bghl204a().conMghj204a());
            bghl204a().commarea().areaErro().chAcesso().set(bghl204a().commarea().dadosInput());
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    public void mainProcedure() {
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            s30000Processar() ;
        }
        s50000Responder() ;
        exit() ;
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
}
