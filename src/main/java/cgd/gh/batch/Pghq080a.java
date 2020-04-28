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
import cgd.gh.structures.work.Bghw0500 ;


/**
 * 
 * FGH202 - FICHEIRO RECEBIDO DA APLICACAO HH(FHH606)
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CARREGAMENTO DA TABELA:
 * - VGH00201_MOVHST
 * - I_EXIS_INF_ADI       = 'S'
 * - X_CHAV_ACS_INF_ADI   = N.IMAGEM CHEQUE
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq080a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    
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
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghq080a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    /**
     * @return instancia da classe Fwk950
     */
    @Handler(name="FWK950", record="fwk950Reg75")
    @Data
    protected abstract Fwk950 fwk950() ;
    
    /**
     * @return instancia da classe Fwk00103
     */
    @Handler(name="INPUT1", record="rgh20201")
    @Data
    protected abstract Fwk00103 fgh202() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0500
     */
    @Data
    protected abstract Bghw0500 bghw0500() ;
    
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("8")
    protected ICondition progJaExiste ;
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=15, value="0")
    protected ILong wsNConta ;
    
    /**
     * @return instancia da classe local WsNContaMask
     */
    @Data
    @Mask
    protected abstract WsNContaMask wsNContaMask() ;
    
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
    
    @Data(size=26, value=" ")
    protected IString wsTsMovimentoMin ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovimentoMax ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFgh202 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh00201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegSemReferen ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegNotFound ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ080A");
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
            a16000AbrirFgh202() ;
        }
        if (progOk.isTrue()) {
            while (contRegLidosFgh202.isLessOrEqual(auxContRegLidos) && !fgh202().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17000LerFgh202() ;
            }
        }
        if (progOk.isTrue()) {
            a18000AbrirFwk950() ;
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
    protected void a18000AbrirFwk950() {
        log(TraceLevel.Debug, "A18000-ABRIR-FWK950");
        fwk950().open(WRITE) ;
        if (!fwk950().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK950 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk950().getStatus());
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
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - OPEN - ");
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
            auxContRegLidos.set(fwk900().fwk900RegPghq080a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghq080a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - READ - ");
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
            fwk900().fwk900RegPghq080a().initialize() ;
            fwk900().fwk900RegPghq080a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghq080a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - OPEN- ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirFgh202() {
        log(TraceLevel.Debug, "A16000-ABRIR-FGH202");
        fgh202().open() ;
        if (!fgh202().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FGH202 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh202().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17000LerFgh202() {
        log(TraceLevel.Debug, "A17000-LER-FGH202");
        fgh202().read() ;
        if (fgh202().getStatusOk()) {
            contRegLidosFgh202.add(1);
            wsNContaMask().wsCOeCont().set(fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont());
        }
        if (!fgh202().getStatusOk() && !fgh202().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FGH202 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fgh202().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (fgh202().rgh20201().fgh202NRefCheqArqv().isGreater(0)) {
            a30000UpdateTabelaVgh00201() ;
        } else {
            contRegSemReferen.add(1);
        }
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17000LerFgh202() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            if (contRegNotFound.isGreater(0)) {
                tabelaImpressao().linha07().impReturnCode().set(2);
                setReturnCode(2) ;
                progStatus.set(2);
            }
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            if (wsNContaMask().wsCOeCont().isGreaterOrEqual(0) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(100)) {
                tabelaImpressao().linha05().impFichRead().set("FWK001");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(101) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(200)) {
                tabelaImpressao().linha05().impFichRead().set("FWK002");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(201) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(300)) {
                tabelaImpressao().linha05().impFichRead().set("FWK003");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(301) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(400)) {
                tabelaImpressao().linha05().impFichRead().set("FWK004");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(401) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(500)) {
                tabelaImpressao().linha05().impFichRead().set("FWK005");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(501) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(600)) {
                tabelaImpressao().linha05().impFichRead().set("FWK006");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(601) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(700)) {
                tabelaImpressao().linha05().impFichRead().set("FWK007");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(701) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(800)) {
                tabelaImpressao().linha05().impFichRead().set("FWK008");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(801) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(900)) {
                tabelaImpressao().linha05().impFichRead().set("FWK009");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(901) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(1500)) {
                tabelaImpressao().linha05().impFichRead().set("FWK010");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(1501) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(2100)) {
                tabelaImpressao().linha05().impFichRead().set("FWK011");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(2101) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(2500)) {
                tabelaImpressao().linha05().impFichRead().set("FWK012");
            } else if (wsNContaMask().wsCOeCont().isGreaterOrEqual(2501) && 
                wsNContaMask().wsCOeCont().isLessOrEqual(9999)) {
                tabelaImpressao().linha05().impFichRead().set("FWK013");
            }
            tabelaImpressao().linha05().impRegLidosFgh202().set(contRegLidosFgh202);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("VGH201");
            tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh00201);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("S/REF.");
            tabelaImpressao().linha06().impRegEscrt().set(contRegSemReferen);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("NTFND");
            tabelaImpressao().linha06().impRegEscrt().set(contRegNotFound);
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
            tabelaImpressao().linha08().impMens1().set("PGHQ080A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fgh202().close() ;
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
    protected void a30000UpdateTabelaVgh00201() {
        log(TraceLevel.Debug, "A30000-UPDATE-TABELA-VGH00201");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(fgh202().rgh20201().fgh202NSubconta().fgh202CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(fgh202().rgh20201().fgh202NSubconta().fgh202CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(fgh202().rgh20201().fgh202NSubconta().fgh202NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(fgh202().rgh20201().fgh202NSubconta().fgh202VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(fgh202().rgh20201().fgh202NSubconta().fgh202CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(fgh202().rgh20201().fgh202NSubconta().fgh202CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(fgh202().rgh20201().fgh202NSubconta().fgh202NsDeposito());
        hv00201Movhst().movhst().nDocOpps().set(fgh202().rgh20201().fgh202NCheque());
        wTimestamp().wDataTimestamp().set(fgh202().rgh20201().fgh202ZPagCheq());
        wTimestamp().wTimerTimestamp().wHh().set(0);
        wTimestamp().wTimerTimestamp().wMm().set(0);
        wTimestamp().wTimerTimestamp().wSs().set(0);
        wTimestamp().wTimerTimestamp().wDd().set(0);
        hv00201Movhst().movhst().tsMovimento().set(wTimestamp());
        wsTsMovimentoMin.set(hv00201Movhst().movhst().tsMovimento());
        wsTsMovimentoMax.set(hv00201Movhst().movhst().tsMovimento());
        wsTsMovimentoMax.get(12, 15).set("23.59.59.999999") ;
        wsTsMovimentoMin.get(12, 15).set("00.00.00.000000") ;
        hv00201Movhst().movhst().iExisInfAdi().set("S");
        bghw0500().wXChavAcsInfAdiMask().wNRefCheqArqv().set(fgh202().rgh20201().fgh202NRefCheqArqv());
        bghw0500().wXChavAcsInfAdiMask().wCPaisIsaTmxChq().set(fgh202().rgh20201().fgh202CPaisIsaTmxChq());
        bghw0500().wXChavAcsInfAdiMask().wCBancTomador().set(fgh202().rgh20201().fgh202CBancTomador());
        bghw0500().wXChavAcsInfAdiMask().wCOeEgcTomxCheq().set(fgh202().rgh20201().fgh202COeEgcTomxCheq());
        hv00201Movhst().movhst().xChavAcsInfAdi().set(bghw0500().wXChavAcsInfAdi());
        hv00201Movhst().movhst().cUsidActzUlt().set("PGHQ080A");
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq080a692(wsTsMovimentoMin, wsTsMovimentoMax) ;
        switch (hv00201Movhst().getPersistenceCode()) {
            case NORMAL:
                contRegInsVgh00201.add(1);
                break;
            case NOTFND:
                a30100Erros() ;
                break;
            default :
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ080A - VGH00201-UPDATE - ");
                wSqlcode.set(getPersistenceCode());
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
                break;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30100Erros() {
        log(TraceLevel.Debug, "A30100-ERROS");
        fwk950().setRecord(fgh202().getRecord()) ;
        fwk950().write(fwk950().fwk950Reg75) ;
        if (!fwk950().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK950 - INSERT - ");
            tabelaImpressao().linha09().impStatus().set(fwk950().getStatus());
        } else {
            contRegNotFound.add(1);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000ControlaCommit() {
        log(TraceLevel.Debug, "A33000-CONTROLA-COMMIT");
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
                tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - READ - ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghq080a().initialize() ;
            fwk900().fwk900RegPghq080a().fwk900NCommit().set(contRegCommit);
            fwk900().rewrite(fwk900().fwk900RegPghq080a()) ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ080A - FWK900 - REWRITE -");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
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
            while (!fgh202().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsNContaMask extends IDataMask {
        
        @Data(size=4)
        IInt wsCOeCont() ;
        
        @Data(size=7)
        IInt wsNsRdclCont() ;
        
        @Data(size=1)
        IInt wsVChkdCont() ;
        
        @Data(size=3)
        IInt wsCTipoCont() ;
        
    }
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ080A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ080A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS LIDOS EM")
            IString filler002() ;
            
            @Data(size=6, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosFgh202() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS ESCRITOS EM ")
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
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=53, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=10, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
