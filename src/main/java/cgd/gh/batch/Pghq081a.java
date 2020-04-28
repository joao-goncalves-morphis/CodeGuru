package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
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
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.gh.structures.work.Bghwz001 ;


/**
 * 
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CARREGAMENTO DA TABELA DE CONTAS DE HISTORICO
 * RECEBIDO DIARIAMENTE DOS HO'S
 * 1 INSERCAO OU ALTERACAO DOS REGISTOS NA TABELA:
 * - TGH00001_CONTHST
 * FICHEIROS     : FHO662
 * ESTE FICHEIRO E IDENTIFICADO COMO FGH200     .
 * ALTERACOES:
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq081a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00101Conthst
     */
    @Data
    protected abstract Vwsdghps00101Conthst hv00101Conthst() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    /**
     * @return instancia da classe Fgh200
     */
    @Handler(name="FGH200", record="rgh20001")
    @Data
    protected abstract Fgh200 fgh200() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghq081a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghwz001
     */
    @Data
    protected abstract Bghwz001 bghwz001() ;
    
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("1")
    protected ICondition progNok ;
    @Data
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("8")
    protected ICondition progJaExiste ;
    
    
    @Data(size=4, signed=true, value="0", compression=COMP3)
    protected IInt wsZaFim ;
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
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
    
    @Data(size=10)
    protected IString wsDataDia ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFgh200 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegActVgh00101 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong auxContRegLidos ;
    
    /**
     * TABELA DE IMPRESSAO DE FGH300
     * @return instancia da classe local TabelaImpressao
     */
    @Data
    protected abstract TabelaImpressao tabelaImpressao() ;
    
    /**
     * @return instancia da classe local TabelaImpressaoMask
     */
    @Data
    @Mask
    protected abstract TabelaImpressaoMask tabelaImpressaoMask() ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ081A");
        progOk.setTrue() ;
        bghw0300().wsVariaveisHora().horaInicio().set(getTime()) ;
        dataCorrente.set(getTime("yyyyMMdd"));
        dataNum.set(dataCorrente);
        wTimestamp().wDataTimestamp().wAnoAa().set(dataCorrenteMask().anoCorrente());
        wTimestamp().wDataTimestamp().wMesMm().set(dataCorrenteMask().mesCorrente());
        wTimestamp().wDataTimestamp().wDiaDd().set(dataCorrenteMask().diaCorrente());
        tabelaImpressao().linha02().impData().set(wTimestamp().wDataTimestamp());
        tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
        wTimestamp().wTimerTimestamp().wHh().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().hhInicio());
        wTimestamp().wTimerTimestamp().wMm().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().mmInicio());
        wTimestamp().wTimerTimestamp().wSs().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().ssInicio());
        wTimestamp().wTimerTimestamp().wDd().set(0);
        wsDataDia.set(wTimestamp().wDataTimestamp());
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk900() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk900() ;
        }
        if (progOk.isTrue()) {
            a16000AbrirFgh200() ;
        }
        if (progOk.isTrue()) {
            while (contRegLidosFgh200.isLessOrEqual(auxContRegLidos) && !fgh200().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17000LerFgh200() ;
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A12000-ABRIR-FGH300");
        fgh300().open(WRITE) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - OPEN - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000EscreverFgh300() {
        log(TraceLevel.Debug, "A12000-ESCREVER-FGH300");
        fgh300().write(fgh300().rgh03001121) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - WRITE - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk900() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK900");
        fwk900().open(WRITE) ;
        if (!fwk900().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk900() {
        log(TraceLevel.Debug, "A15000-LER-FWK900");
        fwk900().read() ;
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq081a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq081a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15100TratarOutputFwk900() {
        log(TraceLevel.Debug, "A15100-TRATAR-OUTPUT-FWK900");
        fwk900().open(CREATE ) ;
        if (fwk900().getStatusOk()) {
            fwk900().fwk900RegPghq081a().initialize() ;
            fwk900().fwk900RegPghq081a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghq081a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - OPEN- ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirFgh200() {
        log(TraceLevel.Debug, "A16000-ABRIR-FGH200");
        fgh200().open() ;
        if (!fgh200().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FGH200 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh200().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerFgh200() {
        log(TraceLevel.Debug, "A17000-LER-FGH200");
        fgh200().read() ;
        if (fgh200().getStatusOk()) {
            contRegLidosFgh200.add(1);
            tabelaImpressao().linha11().impOeEgcCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200COeEgcCont());
            tabelaImpressao().linha11().impNsRdclCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsRdclCont());
            tabelaImpressao().linha11().impChkdCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200VChkdCont());
            tabelaImpressao().linha11().impCTipoCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CTipoCont());
            tabelaImpressao().linha11().impNsDeposito().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsDeposito());
        }
        if (!fgh200().getStatusOk() && !fgh200().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FGH200 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fgh200().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a18000ValidaDatas() {
        log(TraceLevel.Debug, "A18000-VALIDA-DATAS");
        if (fgh200().rgh20001().fgh200AbrtScta().isTrue()) {
            if (fgh200().rgh20001().fgh200ZAbraScta().isEmpty() || 
                fgh200().rgh20001().fgh200ZAbraScta().isEqual("0001-01-01")) {
                progNok.setTrue() ;
                tabelaImpressao().linha11().impDataCont().set(fgh200().rgh20001().fgh200ZAbraScta());
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgLivre().set(tabelaImpressao().linha11());
            }
        } else if (fgh200().rgh20001().fgh200CcltScta().isTrue()) {
            if (fgh200().rgh20001().fgh200ZCcltScta().isEmpty()) {
                progNok.setTrue() ;
                tabelaImpressao().linha11().impDataCont().set(fgh200().rgh20001().fgh200ZCcltScta());
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgLivre().set(tabelaImpressao().linha11());
            }
        } else if (fgh200().rgh20001().fgh200ExprScta().isTrue()) {
            if (fgh200().rgh20001().fgh200ZExprScta().isEmpty()) {
                progNok.setTrue() ;
                tabelaImpressao().linha11().impDataCont().set(fgh200().rgh20001().fgh200ZExprScta());
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgLivre().set(tabelaImpressao().linha11());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a18000ValidaDatas() ;
        if (progOk.isTrue()) {
            if (fgh200().rgh20001().fgh200AbrtScta().isTrue()) {
                a31400InsRegTgh1() ;
            } else if (fgh200().rgh20001().fgh200CcltScta().isTrue() || fgh200().rgh20001().fgh200ExprScta().isTrue()) {
                a31000TratarTgh1Conthst() ;
            }
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17000LerFgh200() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        /**
         * *----------------------------------------------------------------*
         */
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichRead().set("FGH200");
            tabelaImpressao().linha05().impRegLidosFgh200().set(contRegLidosFgh200);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("VGH00101");
            tabelaImpressao().linha06().impRegEscrt().set(contRegActVgh00101);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            if (progOk.isTrue()) {
                commit() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ081A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fgh200().close() ;
    }
    
    /**
     * 
     * 
     */
    protected void a71000CalculaTempoExecucao() {
        /**
         * *----------------------------------------------------------------*
         */
        bghw0300().wsVariaveisHora().horaFim().set(getTime()) ;
        /**
         * BOOK QUE CONTEM A ROTINA DE CALCULO DO TEMPO DE EXECUCAO
         * DO PROGRAMA
         */
        bghp0300() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarTgh1Conthst() {
        log(TraceLevel.Debug, "A31000-TRATAR-TGH1-CONTHST");
        a31100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            if (fgh200().rgh20001().fgh200CcltScta().isTrue()) {
                a31300ActRegTgh1() ;
            } else if (fgh200().rgh20001().fgh200ExprScta().isTrue()) {
                a31350ActRegTgh1() ;
            }
        }
        if (progOk.isTrue()) {
            a31500CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100OpenCursorC1() {
        log(TraceLevel.Debug, "A31100-OPEN-CURSOR-C1");
        wSqlcode.initialize() ;
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cPaisIsoaCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200COeEgcCont());
        tabelaImpressao().linha11().impOeEgcCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200COeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsRdclCont());
        tabelaImpressao().linha11().impNsRdclCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200VChkdCont());
        tabelaImpressao().linha11().impChkdCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200VChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CTipoCont());
        tabelaImpressao().linha11().impCTipoCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(fgh200().rgh20001().fgh200NSubconta().fgh200CMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsDeposito());
        tabelaImpressao().linha11().impNsDeposito().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00101Conthst().openPghq081a705() ;
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31200FetchCursorC1() {
        log(TraceLevel.Debug, "A31200-FETCH-CURSOR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv00101Conthst().fetchPghq081a733() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FETCH C1- VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
            a31500CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300ActRegTgh1() {
        log(TraceLevel.Debug, "A31300-ACT-REG-TGH1");
        hv00101Conthst().conthst().zCcltCont().set(fgh200().rgh20001().fgh200ZCcltScta());
        if (fgh200().rgh20001().fgh200ZCcltScta().isEqual("0001-01-01")) {
            if (hv00101Conthst().conthst().iActivo().isEqual("N")) {
                hv00101Conthst().conthst().iActivo().set("S");
                hv00101Conthst().conthst().zRabtCont().set(wsDataDia);
            }
        } else {
            hv00101Conthst().conthst().iActivo().set("N");
        }
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00101_CONTHST
         */
        hv00101Conthst().updatePghq081a778() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegActVgh00101.add(1);
        } else {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - UPD C1 - VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31350ActRegTgh1() {
        log(TraceLevel.Debug, "A31350-ACT-REG-TGH1");
        hv00101Conthst().conthst().zCcltCont().set(fgh200().rgh20001().fgh200ZExprScta());
        if (fgh200().rgh20001().fgh200ZExprScta().isEqual("0001-01-01")) {
            if (hv00101Conthst().conthst().iActivo().isEqual("N")) {
                hv00101Conthst().conthst().iActivo().set("S");
                hv00101Conthst().conthst().zRabtContCcld().set(wsDataDia);
            }
        } else {
            hv00101Conthst().conthst().iActivo().set("N");
        }
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00101_CONTHST
         */
        hv00101Conthst().updatePghq081a823() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegActVgh00101.add(1);
        } else {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - UPD C1 - VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400InsRegTgh1() {
        log(TraceLevel.Debug, "A31400-INS-REG-TGH1");
        wSqlcode.initialize() ;
        hv00101Conthst().conthst().initialize() ;
        hv00101Conthst().conthst().cPaisIsoaCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200COeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200VChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(fgh200().rgh20001().fgh200NSubconta().fgh200CTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(fgh200().rgh20001().fgh200NSubconta().fgh200CMoedIsoScta());
        hv00101Conthst().conthst().cMoedIsoAntEur().set(fgh200().rgh20001().fgh200NSubconta().fgh200CMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(fgh200().rgh20001().fgh200NSubconta().fgh200NsDeposito());
        hv00101Conthst().conthst().iActivo().set("S");
        hv00101Conthst().conthst().zAbraCont().set(fgh200().rgh20001().fgh200ZAbraScta());
        hv00101Conthst().conthst().zCcltCont().set("0001-01-01");
        hv00101Conthst().conthst().zRabtCont().set("0001-01-01");
        hv00101Conthst().conthst().zRabtContCcld().set("0001-01-01");
        hv00101Conthst().conthst().zMovHistUlt().set("0001-01-01");
        hv00101Conthst().conthst().cUsidActzUlt().set("PGHQ081A");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00101_CONTHST
         */
        hv00101Conthst().insertPghq081a876() ;
        if (hv00101Conthst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegActVgh00101.add(1);
        } else {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - INSERT- VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "SQLCODE-", wSqlcode);
            a31500CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31500CloseCursorC1() {
        log(TraceLevel.Debug, "A31500-CLOSE-CURSOR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv00101Conthst().closePghq081a944() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - CLOSE C1-VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36000ControlaCommit() {
        log(TraceLevel.Debug, "A36000-CONTROLA-COMMIT");
        contRegCommit.add(1);
        if (contRegCommit.isEqual(1000)) {
            commit() ;
            a36100EscreverFwk900() ;
            if (progOk.isTrue()) {
                contRegCommit.set(0);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36100EscreverFwk900() {
        log(TraceLevel.Debug, "A36100-ESCREVER-FWK900");
        a14000AbrirFwk900() ;
        if (progOk.isTrue()) {
            fwk900().read() ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - READ - ");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghq081a().initialize() ;
            fwk900().fwk900RegPghq081a().fwk900NCommit().set(add(fwk900().fwk900RegPghq081a().fwk900NCommit(), contRegCommit));
            fwk900().rewrite(fwk900().fwk900RegPghq081a()) ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ081A - FWK900 - REWRITE -");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
        }
        if (progOk.isTrue()) {
            fwk900().close() ;
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!fgh200().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=4)
        IInt anoCorrente() ;
        
        @Data(size=2)
        IInt mesCorrente() ;
        
        @Data(size=2)
        IInt diaCorrente() ;
        
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
    
    /**
     * 
     * TABELA DE IMPRESSAO DE FGH300
     * 
     * @version 2.0
     * 
     */
    public interface TabelaImpressao extends IDataStruct {
        
        @Data(size=121, value=" ")
        IString linha01() ;
        
        /**
         * @return instancia da classe local Linha02
         */
        @Data
        Linha02 linha02() ;
        
        /**
         * @return instancia da classe local Linha03
         */
        @Data
        Linha03 linha03() ;
        
        /**
         * @return instancia da classe local Linha04
         */
        @Data
        Linha04 linha04() ;
        
        /**
         * @return instancia da classe local Linha05
         */
        @Data
        Linha05 linha05() ;
        
        /**
         * @return instancia da classe local Linha06
         */
        @Data
        Linha06 linha06() ;
        
        /**
         * @return instancia da classe local Linha07
         */
        @Data
        Linha07 linha07() ;
        
        /**
         * @return instancia da classe local Linha08
         */
        @Data
        Linha08 linha08() ;
        
        /**
         * @return instancia da classe local Linha09
         */
        @Data
        Linha09 linha09() ;
        
        /**
         * @return instancia da classe local Linha10
         */
        @Data
        Linha10 linha10() ;
        
        /**
         * @return instancia da classe local Linha11
         */
        @Data
        Linha11 linha11() ;
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ081A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="DATA:     ")
            IString filler004() ;
            
            @Data(size=10, rpadding=84, rpaddingValue="")
            IString impData() ;
            
        }
        
        public interface Linha03 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="HORA INICIO: ")
            IString filler002() ;
            
            @Data(size=8, decimal=2, value="0")
            IDecimal impHoraInicio() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="HORA FIM: ")
            IString filler004() ;
            
            @Data(size=8, decimal=2, value="0", rpadding=55, rpaddingValue="")
            IDecimal impHoraFim() ;
            
        }
        
        public interface Linha04 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ081A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosFgh200() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS ACTUALIZADOS")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
        
        public interface Linha11 extends IDataStruct {
            
            @Data(size=1, value=" ")
            IString filler001() ;
            
            @Data(size=25, value="FHO662 - DATA INCOERENTE:")
            IString filler002() ;
            
            @Data(size=10)
            IString impDataCont() ;
            
            @Data(size=1, value=" ")
            IString filler003() ;
            
            @Data(size=6, value="CONTA:")
            IString filler004() ;
            
            @Data(size=4)
            IString impOeEgcCont() ;
            
            @Data(size=7, lpadding=1, lpaddingValue=".")
            IString impNsRdclCont() ;
            
            @Data(size=1, lpadding=1, lpaddingValue=".")
            IString impChkdCont() ;
            
            @Data(size=3, lpadding=1, lpaddingValue=".")
            IString impCTipoCont() ;
            
            @Data(size=1, value=" ")
            IString filler005() ;
            
            @Data(size=9, value="DEPOSITO:")
            IString filler006() ;
            
            @Data(size=4, rpadding=30, rpaddingValue="")
            IString impNsDeposito() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=10, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
