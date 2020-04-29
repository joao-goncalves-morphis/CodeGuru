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
import cgd.gh.structures.work.Bghw0503 ;
import cgd.gh.routines.Mghk800a ;


/**
 * 
 * PRC19 - FIM
 * FGH505 - FICHEIRO DOS MOVIMENTOS DA CONTA DA DBI
 * ** TABELAS DB2
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS:   1.TRATA PEDIDO GH0095 A PARTIR DO FICHEIRO
 * FWK095 CRIADO NO PROGRAMA PGHC201A
 * 2.CRIA O FICHEIRO FGH505 PARA A DCR
 * POR CONNECT-DIRECT
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq505a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
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
     * @return instancia da classe Fwk095
     */
    @Handler(name="FWK095", record="regFwk095Pghq505a")
    @Data
    protected abstract Fwk095 fwk095() ;
    
    /**
     * @return instancia da classe Fgh505
     */
    @Handler(name="FGH505", record="regFgh505")
    @Data
    protected abstract Fgh505 fgh505() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0503
     */
    @Data
    protected abstract Bghw0503 bghw0503() ;
    
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
    
    
    @Data(size=1)
    protected IString swCrtlConta ;
    @Data
    @Condition("3")
    protected ICondition swContaIgual ;
    @Data
    @Condition("4")
    protected ICondition swContaDiferente ;
    
    
    @Data(size=1)
    protected IString swCrtlExiste ;
    @Data
    @Condition("6")
    protected ICondition swContaExiste ;
    @Data
    @Condition("4")
    protected ICondition swContaNaoExiste ;
    
    
    @Data(size=1)
    protected IString swCrtlVerContaHst ;
    @Data
    @Condition("5")
    protected ICondition verContaHst ;
    @Data
    @Condition("4")
    protected ICondition naoVerContaHst ;
    
    
    @Data(size=8, value="MGHK800A")
    protected IString wsDescritivos ;
    
    @Data(size=1)
    protected IString dfheiblk ;
    
    @Data(size=2, value="33")
    protected IString wsConSumDia ;
    
    @Data(size=4, signed=true, value="1", compression=COMP3)
    protected IInt wsConTipoPrazDias ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    @Data(size=8, value="MGHJ801A")
    protected IString wsMghj801a ;
    
    @Data(size=13)
    protected ILong wsNConta ;
    
    /**
     * @return instancia da classe local WsNContaMask
     */
    @Data
    @Mask
    protected abstract WsNContaMask wsNContaMask() ;
    
    /**
     * @return instancia da classe local Filler
     */
    @Data
    protected abstract Filler filler02() ;
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=2, signed=true, value="0")
    protected IInt wContador ;
    @Data
    @Condition("3")
    protected ICondition terceiraVez ;
    @Data
    @Condition("4")
    protected ICondition sair ;
    
    
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
    
    @Data(size=26)
    protected IString wsTsMovFim ;
    
    @Data(size=26)
    protected IString wsTsMovInicio ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * @return instancia da classe local WsTsInicio
     */
    @Data
    protected abstract WsTsInicio wsTsInicio() ;
    
    /**
     * @return instancia da classe local WsTsFim
     */
    @Data
    protected abstract WsTsFim wsTsFim() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk095 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh505 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ505A");
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
            a13000AbrirFgh505() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk095() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk095() ;
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
    protected void a13000AbrirFgh505() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH505");
        fgh505().open(CREATE ) ;
        if (!fgh505().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ505A - FGH505 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fgh505().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk095() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK095");
        fwk095().open() ;
        if (!fwk095().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ505A - FWK095 - OPEN - ");
            tabelaImpressao().linha08().impStatus().set(fwk095().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk095() {
        log(TraceLevel.Debug, "A15000-LER-FWK095");
        fwk095().read() ;
        if (fwk095().getStatusOk()) {
            contRegLidosFwk095.add(1);
        }
        if (!fwk095().getStatusOk() && !fwk095().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ200A - FWK095 - READ - ");
            tabelaImpressao().linha08().impStatus().set(fwk095().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarHistoricoMov() ;
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a32000ActPedido() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk095() ;
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
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            tabelaImpressao().linha06().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichEsc().set("FGH505");
            tabelaImpressao().linha05().impRegEscrt().set(contRegEscrtFgh505);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFgh505.isEqual(0)) {
                tabelaImpressao().linha07().impMens1().set("]]]] NAO HA MOVIMENTOS ]]]]");
                tabelaImpressaoMask().zimp().setIndex(7) ;
                a12000EscreverFgh300() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha06().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha06().impReturnCode().set(returnCode);
            tabelaImpressao().linha07().impMens1().set("PGHQ505A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fgh505().close() ;
        fwk095().close() ;
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
    protected void a31000TratarHistoricoMov() {
        log(TraceLevel.Debug, "A31000-TRATAR-HISTORICO-MOV");
        a31100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            while (!progNaoExiste.isTrue()) {
                a31300TratarMovimentos() ;
            }
        }
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31100OpenCursorC1() {
        log(TraceLevel.Debug, "A31100-OPEN-CURSOR-C1");
        wSqlcode.initialize() ;
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(fwk095().regFwk095Pghq505a().fwk095CPaisIsoaCont());
        hv00201Movhst().movhst().cPaisIsoaCont().set(fwk095().regFwk095Pghq505a().fwk095CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(fwk095().regFwk095Pghq505a().fwk095CBancCont());
        hv00201Movhst().movhst().cBancCont().set(fwk095().regFwk095Pghq505a().fwk095CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(fwk095().regFwk095Pghq505a().fwk095COeEgcCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fwk095().regFwk095Pghq505a().fwk095COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(fwk095().regFwk095Pghq505a().fwk095NsRdclCont());
        hv00201Movhst().movhst().nsRdclCont().set(fwk095().regFwk095Pghq505a().fwk095NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(fwk095().regFwk095Pghq505a().fwk095VChkdCont());
        hv00201Movhst().movhst().vChkdCont().set(fwk095().regFwk095Pghq505a().fwk095VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(fwk095().regFwk095Pghq505a().fwk095CTipoCont());
        hv00201Movhst().movhst().cTipoCont().set(fwk095().regFwk095Pghq505a().fwk095CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(fwk095().regFwk095Pghq505a().fwk095CMoedIsoScta());
        hv00201Movhst().movhst().cMoedIsoScta().set(fwk095().regFwk095Pghq505a().fwk095CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(fwk095().regFwk095Pghq505a().fwk095NsDeposito());
        hv00201Movhst().movhst().nsDeposito().set(fwk095().regFwk095Pghq505a().fwk095NsDeposito());
        hv10201Movhstcpl().movhstcpl().cOpeBbn().set(fwk095().regFwk095Pghq505a().fwk095CParmPedHstMin().get(1, 5));
        wsTsInicio().wsDataInicio().set(fwk095().regFwk095Pghq505a().fwk095ZInicMov());
        wsTsMovInicio.set(wsTsInicio());
        wsTsFim().wsDataFim().set(fwk095().regFwk095Pghq505a().fwk095ZFimMov());
        wsTsMovFim.set(wsTsFim());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv10201Movhstcpl().openPghq505a716(wsTsMovInicio, wsTsMovFim) ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ505A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
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
        hv10201Movhstcpl().fetchPghq505a745() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ505A - FETCH C1- VGH10201 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300TratarMovimentos() {
        log(TraceLevel.Debug, "A31300-TRATAR-MOVIMENTOS");
        a31310AcederMovHst() ;
        if (progOk.isTrue()) {
            if (hv00201Movhst().movhst().iDbcr().isEqual("C") && 
                hv00201Movhst().movhst().iEstorno().isEmpty()) {
                a31320EscreverFgh505() ;
            }
        }
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31310AcederMovHst() {
        log(TraceLevel.Debug, "A31310-ACEDER-MOV-HST-CMPL");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH00201_MOVHST
         */
        hv00201Movhst().selectPghq505a805(hv10201Movhstcpl().movhstcpl()) ;
        wSqlcode.set(hv00201Movhst().getPersistenceCode());
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ505A - SELECT  - VGH00201 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
            a31400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320EscreverFgh505() {
        log(TraceLevel.Debug, "A31320-ESCREVER-FGH505");
        fgh505().regFgh505().initialize() ;
        fgh505().regFgh505().fgh505CPaisIsoaCont().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaCont());
        fgh505().regFgh505().fgh505CBancCont().set(hv10201Movhstcpl().movhstcpl().cBancCont());
        filler02().wsCOeContaBb().set(hv10201Movhstcpl().movhstcpl().cOeEgcCont());
        filler02().wsNsRdclContaBb().set(hv10201Movhstcpl().movhstcpl().nsRdclCont());
        filler02().wsCDigContaBb().set(hv10201Movhstcpl().movhstcpl().vChkdCont());
        filler02().wsTipoContaBb().set(hv10201Movhstcpl().movhstcpl().cTipoCont());
        wsNContaMask().wsCOeConta().set(filler02().wsCOeContaBb());
        wsNContaMask().wsNsRdclConta().set(filler02().wsNsRdclContaBb().get(2, 6));
        wsNContaMask().wsCDigConta().set(filler02().wsCDigContaBb());
        wsNContaMask().wsTipoConta().set(filler02().wsTipoContaBb().get(2, 2));
        fgh505().regFgh505().fgh505NConta().set(wsNConta);
        fgh505().regFgh505().fgh505ZMovimento().set(hv10201Movhstcpl().movhstcpl().tsMovimento().get(1, 10));
        fgh505().regFgh505().fgh505ZValMov().set(hv00201Movhst().movhst().zValMov());
        fgh505().regFgh505().fgh505CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fgh505().regFgh505().fgh505MMovimento().set(hv00201Movhst().movhst().mMovimento());
        if (hv00201Movhst().movhst().iEstorno().isEmpty()) {
            if (hv00201Movhst().movhst().iDbcr().isEqual("D")) {
                fgh505().regFgh505().fgh505SinalMov().set("-");
            } else {
                fgh505().regFgh505().fgh505SinalMov().set("+");
            }
        } else if (hv00201Movhst().movhst().iDbcr().isEqual("C")) {
            fgh505().regFgh505().fgh505SinalMov().set("-");
        } else {
            fgh505().regFgh505().fgh505SinalMov().set("+");
        }
        fgh505().regFgh505().fgh505COeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
        fgh505().regFgh505().fgh505CMoedIsoOriMov().set(hv00201Movhst().movhst().cMoedIsoOriMov());
        fgh505().regFgh505().fgh505XRefMov().set(hv00201Movhst().movhst().xRefMov());
        if (fgh505().regFgh505().fgh505XRefMov().isEmpty() || 
            fgh505().regFgh505().fgh505XRefMov().isEqual(String.valueOf(LOW_VALUES))) {
            a31330ObtemDescricao() ;
            fgh505().regFgh505().fgh505XRefMov().set(hrMghk800a().bghl800a().output().xRefMov());
        }
        fgh505().write(fgh505().regFgh505()) ;
        if (fgh505().getStatusOk()) {
            contRegEscrtFgh505.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ505A - FGH505 - WRITE   - ");
            tabelaImpressao().linha08().impStatus().set(fgh505().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31330ObtemDescricao() {
        log(TraceLevel.Debug, "A31330-OBTEM-DESCRICAO");
        /**
         * COPY BGHP1801.
         */
        if (progOk.isTrue()) {
            hrMghk800a().bghl800a().initialize() ;
            hrMghk800a().bghl800a().input().cPaisIsoaCont().set(hv00201Movhst().movhst().cPaisIsoaCont());
            hrMghk800a().bghl800a().input().cBancCont().set(hv00201Movhst().movhst().cBancCont());
            hrMghk800a().bghl800a().input().cOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
            hrMghk800a().bghl800a().input().nsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
            hrMghk800a().bghl800a().input().vChkdCont().set(hv00201Movhst().movhst().vChkdCont());
            hrMghk800a().bghl800a().input().cTipoCont().set(hv00201Movhst().movhst().cTipoCont());
            hrMghk800a().bghl800a().input().nsDeposito().set(hv00201Movhst().movhst().nsDeposito());
            hrMghk800a().bghl800a().input().cMoedIsoScta().set(hv00201Movhst().movhst().cMoedIsoScta());
            hrMghk800a().bghl800a().input().iDbcr().set(hv00201Movhst().movhst().iDbcr());
            hrMghk800a().bghl800a().input().iEstorno().set(hv00201Movhst().movhst().iEstorno());
            hrMghk800a().bghl800a().input().zValMov().set(hv00201Movhst().movhst().zValMov());
            hrMghk800a().bghl800a().input().cPaisIsoaOeOpx().set(hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx());
            hrMghk800a().bghl800a().input().cMnemEgcOpex().set(hv10201Movhstcpl().movhstcpl().cMnemEgcOpex());
            hrMghk800a().bghl800a().input().cOeEgcOpex().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
            hrMghk800a().bghl800a().input().cOpeBbn().set(hv10201Movhstcpl().movhstcpl().cOpeBbn());
            hrMghk800a().run() ;
            if (!hrMghk800a().bghl800a().ok().isTrue()) {
                log(TraceLevel.Debug, "MGH800A-C-RETORNO-", hrMghk800a().bghl800a().cRetorno());
                log(TraceLevel.Debug, "MGH800A-NM-PROGRAMA-", hrMghk800a().bghl800a().nmPrograma());
                log(TraceLevel.Debug, "MGH800A-C-SQLCODE-", hrMghk800a().bghl800a().cSqlcode());
                hrMghk800a().bghl800a().output().xRefMov().set(" ");
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31400CloseCursorC1() {
        log(TraceLevel.Debug, "A31400-CLOSE-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv10201Movhstcpl().closePghq505a972() ;
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ505A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ActPedido() {
        log(TraceLevel.Debug, "A32000-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk095().regFwk095Pghq505a().fwk095CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk095().regFwk095Pghq505a().fwk095CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk095().regFwk095Pghq505a().fwk095COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk095().regFwk095Pghq505a().fwk095NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk095().regFwk095Pghq505a().fwk095VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk095().regFwk095Pghq505a().fwk095CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk095().regFwk095Pghq505a().fwk095CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk095().regFwk095Pghq505a().fwk095NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk095().regFwk095Pghq505a().fwk095CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk095().regFwk095Pghq505a().fwk095ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk095().regFwk095Pghq505a().fwk095ZFimMov());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq505a1015() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("- UPDATE VGH01501 - ");
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        /**
         * *-----------------------------------------------------------------
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!fwk095().getStatusOk() && progOk.isTrue()) {
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
        IInt wsCOeConta() ;
        
        @Data(size=6)
        IInt wsNsRdclConta() ;
        
        @Data(size=1)
        IInt wsCDigConta() ;
        
        @Data(size=2)
        IInt wsTipoConta() ;
        
    }
    public interface Filler extends IDataStruct {
        
        @Data(size=4)
        IInt wsCOeContaBb() ;
        
        @Data(size=7)
        IInt wsNsRdclContaBb() ;
        
        @Data(size=1)
        IInt wsCDigContaBb() ;
        
        @Data(size=3)
        IInt wsTipoContaBb() ;
        
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
    public interface WsTsInicio extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataInicio
         */
        @Data
        WsDataInicio wsDataInicio() ;
        
        /**
         * @return instancia da classe local WTimerInicio
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerInicio wTimerInicio() ;
        
        
        public interface WsDataInicio extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAaIni() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMmIni() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDdIni() ;
            
        }
        
        public interface WTimerInicio extends IDataStruct {
            
            @Data(size=2, value="0")
            IInt wHhIni() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wMmIni() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue=".")
            IInt wSsIni() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wDdIni() ;
            
        }
    }
    public interface WsTsFim extends IDataStruct {
        
        /**
         * @return instancia da classe local WsDataFim
         */
        @Data
        WsDataFim wsDataFim() ;
        
        /**
         * @return instancia da classe local WTimerFim
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerFim wTimerFim() ;
        
        
        public interface WsDataFim extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAaFim() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMmFim() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDdFim() ;
            
        }
        
        public interface WTimerFim extends IDataStruct {
            
            @Data(size=2, value="23")
            IInt wHhFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wMmFim() ;
            
            @Data(size=2, value="59", lpadding=1, lpaddingValue=".")
            IInt wSsFim() ;
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wDdFim() ;
            
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ505A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ505A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ESCRITOS  ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=9, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
