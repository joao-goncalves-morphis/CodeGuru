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
import cgd.gh.structures.work.Bghf0860 ;
import cgd.gh.structures.work.Bghw0503 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hg.structures.link.Bhgl030a ;
import cgd.hg.structures.link.Bhgl004a ;
import cgd.ho.structures.link.Bhol727a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj004a ;
import cgd.gh.routines.Mghk800a ;


/**
 * 
 * PRC19 - FIM
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CRIA MAPA DE MOVIMENTOS POR MONTANTE
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq207a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01601Oeatrdped
     */
    @Data
    protected abstract Vwsdghps01601Oeatrdped hv01601Oeatrdped() ;
    
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
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    
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
     * @return instancia da classe Fgh860
     */
    @Handler(name="FGH860", record="regFgh860230")
    @Data
    protected abstract Fgh860 fgh860() ;
    
    /**
     * @return instancia da classe Fwk915
     */
    @Handler(name="FWK915", record="regFwk915Pghq207a")
    @Data
    protected abstract Fwk915 fwk915() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    /**
     * @return instancia da classe Mhgj004a
     */
    @Data
    protected abstract Mhgj004a hrMhgj004a() ;
    
    /**
     * @return instancia da classe Mghk800a
     */
    @Data
    protected abstract Mghk800a hrMghk800a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghf0860
     */
    @Data
    protected abstract Bghf0860 bghf0860() ;
    
    /**
     * @return instancia da classe Bghw0503
     */
    @Data
    protected abstract Bghw0503 bghw0503() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhgl030a
     */
    @Data
    protected abstract Bhgl030a bhgl030a() ;
    
    /**
     * @return instancia da classe Bhgl004a
     */
    @Data
    protected abstract Bhgl004a bhgl004a() ;
    
    /**
     * @return instancia da classe Bhol727a
     */
    @Data
    protected abstract Bhol727a bhol727a() ;
    
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
    
    @Data(size=8, value="MGHK800A")
    protected IString wsMghk800a ;
    
    @Data(size=8, value="PGHQ207A")
    protected IString wsPghq207a ;
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    @Data(size=1, value=" ")
    protected IString wsIEstRcrs ;
    
    /**
     * @return instancia da classe local WsConta
     */
    @Data
    protected abstract WsConta wsConta() ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMParmPedHstMax ;
    
    @Data(size=17, decimal=2, signed=true, compression=COMP3)
    protected IDecimal wsMParmPedHstMin ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    @Data(size=8, value="0")
    protected ILong wsNIdRegCab ;
    
    @Data(size=8, value="0")
    protected ILong wsNIdRegCabc ;
    
    @Data(size=8, value="0")
    protected ILong wsNsRegFich ;
    
    @Data(size=8, value="0")
    protected ILong wsNsRegDtlhCabc ;
    
    @Data(size=9, value="0")
    protected ILong wsTotalSubcontas ;
    
    @Data(size=1, value="1")
    protected IInt con1n ;
    
    @Data(size=4, value="35")
    protected IInt con0035n ;
    
    @Data(size=6, value="MGH860")
    protected IString conMgh860 ;
    
    @Data(size=6, value="FWK915")
    protected IString conFwk915 ;
    
    @Data(size=2, value="R1")
    protected IString conR1 ;
    
    @Data(size=2, value="R2")
    protected IString conR2 ;
    
    @Data(size=2, value="R3")
    protected IString conR3 ;
    
    @Data(size=2, value="R4")
    protected IString conR4 ;
    
    @Data(size=3, value="910")
    protected IString con910 ;
    
    @Data(size=3, value="983")
    protected IString con983 ;
    
    @Data(size=3, value="POR")
    protected IString conPor ;
    
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
    protected IString wsTsMovFim ;
    
    @Data(size=26, value=" ")
    protected IString wsTsMovInicio ;
    
    @Data(size=30, value=" ")
    protected IString wsDPais ;
    
    @Data(size=30, value=" ")
    protected IString wsDBanco ;
    
    @Data(size=16, value=" ")
    protected IString wsDBalcao ;
    
    @Data(size=8, value="MHGJ004A")
    protected IString bhgl004aConMhgj004a ;
    
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
    protected ILong contRegLidosFwk915 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh860 ;
    
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
     * TABELA GERAIS - ACESSO A TABELAS GERAIS
     * 
     */
    protected void bhgp0030AcessoTabela() {
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACESSO AOS DADOS DO ORGAO DE ESTRUTURA
     * MHGJ004A
     * 
     */
    protected void bhgp0004RotDadosOe() {
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ207A");
        hrMghk800a().bghl800a().nmPrograma().set("MGHK800A");
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
        wsVariaveis().wsHoraMapaMask().wsHoraM().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().hhInicio());
        wsVariaveis().wsHoraMapaMask().wsMinutoM().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().mmInicio());
        wsVariaveis().wsHoraMapaMask().wsSegundoM().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().ssInicio());
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AbrirFgh860() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk915() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk915() ;
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
    protected void a13000AbrirFgh860() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH860");
        fgh860().open(CREATE ) ;
        if (!fgh860().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - FGH860 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh860().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk915() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK915");
        fwk915().open() ;
        if (!fwk915().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - FWK915 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk915().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk915() {
        log(TraceLevel.Debug, "A15000-LER-FWK915");
        fwk915().read() ;
        if (fwk915().getStatusOk()) {
            contRegLidosFwk915.add(1);
            /**
             * MOVE FGH015-Z-INIC-MOV TO WS-DATA-INICIO
             */
            wsTsInicio().wsDataInicio().set(fwk915().regFwk915Pghq207a().fwk915ZInicMov());
            wsTsMovInicio.set(wsTsInicio());
            /**
             * MOVE FGH015-Z-FIM-MOV  TO WS-DATA-FIM
             */
            wsTsFim().wsDataFim().set(fwk915().regFwk915Pghq207a().fwk915ZFimMov());
            wsTsMovFim.set(wsTsFim());
        }
        if (!fwk915().getStatusOk() && !fwk915().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - FWK915 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk915().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarMapa() ;
        if (progOk.isTrue()) {
            a32000ActPedido() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk915() ;
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
            tabelaImpressao().linha05().impFichRead().set(conFwk915);
            tabelaImpressao().linha05().impRegLidosFwk915().set(contRegLidosFwk915);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set(conMgh860);
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh860);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ207A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
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
    protected void a31000TratarMapa() {
        log(TraceLevel.Debug, "A31000-TRATAR-MAPA");
        a31100OpenCursorC1() ;
        a31200FetchCursorC1() ;
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue() && !progNaoExiste.isTrue()) {
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
        hv01601Oeatrdped().oeatrdped().initialize() ;
        /**
         * MOVE FGH015-TS-PEDIDO           TO VGH01601-TS-PEDIDO
         */
        hv01601Oeatrdped().oeatrdped().tsPedido().set(fwk915().regFwk915Pghq207a().fwk915TsPedido());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01601Oeatrdped().openPghq207a762() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
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
        hv01601Oeatrdped().fetchPghq207a791() ;
        if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - FETCH C1- VGH01601 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31300TratarMovimentos() {
        log(TraceLevel.Debug, "A31300-TRATAR-MOVIMENTOS");
        if (progOk.isTrue()) {
            a31500OpenCursorC3() ;
        }
        if (progOk.isTrue()) {
            a31600FetchCursorC3() ;
        }
        if (progOk.isTrue()) {
            a32100FormataHeader() ;
            if (progOk.isTrue()) {
                while (getPersistenceCode() == PersistenceCode.NORMAL && progOk.isTrue() && !progNaoExiste.isTrue()) {
                    a32200FormataDetalhe() ;
                }
            }
            if (progNaoExiste.isTrue()) {
                a32300FormataTotal() ;
            }
        }
        if (progNaoExiste.isTrue()) {
            progOk.setTrue() ;
        }
        if (progOk.isTrue()) {
            a31700CloseCursorC3() ;
        }
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31310AcederMovHstCmpl() {
        log(TraceLevel.Debug, "A31310-ACEDER-MOV-HST-CMPL");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().selectPghq207a867(hv00201Movhst().movhst()) ;
        wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - SELECT  - VGH10201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31320EscreverFgh860() {
        log(TraceLevel.Debug, "A31320-ESCREVER-FGH860");
        fgh860().write(fgh860().regFgh860230) ;
        if (fgh860().getStatusOk()) {
            contRegEscrtFgh860.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - FGH860 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh860().getStatus());
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
        hv01601Oeatrdped().closePghq207a943() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31500OpenCursorC3() {
        log(TraceLevel.Debug, "A31500-OPEN-CURSOR-C3");
        wSqlcode.initialize() ;
        hv00201Movhst().movhst().initialize() ;
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PAIS-ISOA-OE-OPX TO VGH00201-C-PAIS-ISOA-CONT
         * MOVE FGH015-C-BANC-CONT        TO VGH00201-C-BANC-CONT
         * MOVE FGH015-C-OE-EGC-OPEX      TO VGH00201-C-OE-EGC-CONT
         * MOVE FGH015-M-PARM-PED-HST-MAX TO WS-M-PARM-PED-HST-MAX
         * MOVE FGH015-M-PARM-PED-HST-MIN TO WS-M-PARM-PED-HST-MIN
         */
        hv00201Movhst().movhst().cPaisIsoaCont().set(fwk915().regFwk915Pghq207a().fwk915CPaisIsoaOeOpx());
        hv00201Movhst().movhst().cBancCont().set(fwk915().regFwk915Pghq207a().fwk915CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(fwk915().regFwk915Pghq207a().fwk915COeEgcOpex());
        wsMParmPedHstMax.set(fwk915().regFwk915Pghq207a().fwk915MParmPedHstMax());
        wsMParmPedHstMin.set(fwk915().regFwk915Pghq207a().fwk915MParmPedHstMin());
        log(TraceLevel.Debug, "VGH00201-C-PAIS-ISOA-CONT", hv00201Movhst().movhst().cPaisIsoaCont());
        log(TraceLevel.Debug, "VGH00201-C-BANC-CONT     ", hv00201Movhst().movhst().cBancCont());
        log(TraceLevel.Debug, "VGH00201-C-OE-EGC-CONT   ", hv00201Movhst().movhst().cOeEgcCont());
        log(TraceLevel.Debug, "WS-TS-MOV-FIM            ", wsTsMovFim);
        log(TraceLevel.Debug, "WS-TS-MOV-INICIO         ", wsTsMovInicio);
        log(TraceLevel.Debug, "WS-M-PARM-PED-HST-MAX    ", wsMParmPedHstMax);
        log(TraceLevel.Debug, "WS-M-PARM-PED-HST-MIN    ", wsMParmPedHstMin);
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C3
         */
        hv00201Movhst().openPghq207a995(wsTsMovFim, wsTsMovInicio, wsMParmPedHstMax, wsMParmPedHstMin) ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - CURSOR C3   - OPEN - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31600FetchCursorC3() {
        log(TraceLevel.Debug, "A31600-FETCH-CURSOR-C3");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C3
         */
        hv00201Movhst().fetchPghq207a1024() ;
        log(TraceLevel.Debug, "VGH00201-M-MOVIMENTO:", hv00201Movhst().movhst().mMovimento());
        wSqlcode.set(hv00201Movhst().getPersistenceCode());
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NOTFND) {
            progNaoExiste.setTrue() ;
            log(TraceLevel.Error, "VGH00201-C-OE-EGC-CONT-", hv00201Movhst().movhst().cOeEgcCont());
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - FETCH C3- VGH00201 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31700CloseCursorC3() {
        log(TraceLevel.Debug, "A31700-CLOSE-CURSOR-C3");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C3
         */
        hv00201Movhst().closePghq207a1080() ;
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ207A - CURSOR C3 -CLOSE - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31800BuscaDescricao() {
        /**
         * *----------------------------------------------------------------*
         */
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
            log(TraceLevel.Error, "MGH800A-C-RETORNO   -", hrMghk800a().bghl800a().cRetorno());
            log(TraceLevel.Error, "MGH800A-NM-PROGRAMA -", hrMghk800a().bghl800a().nmPrograma());
            log(TraceLevel.Error, "MGH800A-C-SQLCODE   -", hrMghk800a().bghl800a().cSqlcode());
            hrMghk800a().bghl800a().output().xRefMov().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ActPedido() {
        log(TraceLevel.Debug, "A32000-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        /**
         * PRC19 - INI
         * MOVE FGH015-C-PAIS-ISOA-CONT     TO VGH01501-C-PAIS-ISOA-CONT
         * MOVE FGH015-C-BANC-CONT          TO VGH01501-C-BANC-CONT
         * MOVE FGH015-C-OE-EGC-CONT        TO VGH01501-C-OE-EGC-CONT
         * MOVE FGH015-NS-RDCL-CONT         TO VGH01501-NS-RDCL-CONT
         * MOVE FGH015-V-CHKD-CONT          TO VGH01501-V-CHKD-CONT
         * MOVE FGH015-C-TIPO-CONT          TO VGH01501-C-TIPO-CONT
         * MOVE FGH015-C-MOED-ISO-SCTA      TO VGH01501-C-MOED-ISO-SCTA
         * MOVE FGH015-NS-DEPOSITO          TO VGH01501-NS-DEPOSITO
         * MOVE FGH015-C-PED-INF-OPPS       TO VGH01501-C-PED-INF-OPPS
         * MOVE FGH015-Z-INIC-MOV           TO VGH01501-Z-INIC-MOV
         * MOVE FGH015-Z-FIM-MOV            TO VGH01501-Z-FIM-MOV
         */
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk915().regFwk915Pghq207a().fwk915CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk915().regFwk915Pghq207a().fwk915CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk915().regFwk915Pghq207a().fwk915COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk915().regFwk915Pghq207a().fwk915NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk915().regFwk915Pghq207a().fwk915VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk915().regFwk915Pghq207a().fwk915CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk915().regFwk915Pghq207a().fwk915CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk915().regFwk915Pghq207a().fwk915NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk915().regFwk915Pghq207a().fwk915CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk915().regFwk915Pghq207a().fwk915ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk915().regFwk915Pghq207a().fwk915ZFimMov());
        /**
         * PRC19 - INI
         */
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq207a1172() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("- UPDATE VGH01501 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100FormataHeader() {
        log(TraceLevel.Debug, "A32100-FORMATA-HEADER");
        a32400TrataDescricoes() ;
        bghf0860().fgh860Registo().initialize() ;
        wsVariaveis().wsContadorFich().add(1);
        wsVariaveis().wsContadorHeader().add(1);
        wsVariaveis().wsContadorDestino().add(1);
        wsVariaveis().wsContadorDetalh().set(0);
        wsVariaveis().wsContadorTotais().set(0);
        wsTotalSubcontas.set(0);
        bghf0860().fgh860Registo().fgh860Header().fgh860CMapaR1().set(conMgh860);
        bghf0860().fgh860Registo().fgh860Header().fgh860CTipoRegR1().set(conR1);
        bghf0860().fgh860Registo().fgh860Header().fgh860ZMapaR1().set(wTimestamp().wDataTimestamp());
        bghf0860().fgh860Registo().fgh860Header().fgh860HMapaR1().set(wsVariaveis().wsHoraMapa());
        bghf0860().fgh860Registo().fgh860Header().fgh860CIdioIsoR1().set(conPor);
        bghf0860().fgh860Registo().fgh860Header().fgh860NsRegFichR1().set(wsVariaveis().wsContadorFich());
        bghf0860().fgh860Registo().fgh860Header().fgh860NIdRegDestR1().set(wsVariaveis().wsContadorDestino());
        bghf0860().fgh860Registo().fgh860Header().fgh860NIdRegCabcR1().set(wsVariaveis().wsContadorHeader());
        bghf0860().fgh860Registo().fgh860Header().fgh860CPaisIsoContR1().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
        bghf0860().fgh860Registo().fgh860Header().fgh860DPaisIsoContR1().set(wsDPais);
        bghf0860().fgh860Registo().fgh860Header().fgh860CBancContR1().set(con0035n);
        bghf0860().fgh860Registo().fgh860Header().fgh860DBancContR1().set(wsDBanco);
        bghf0860().fgh860Registo().fgh860Header().fgh860COeEgcContR1().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
        bghf0860().fgh860Registo().fgh860Header().fgh860DOeEgcContR1().set(wsDBalcao);
        /**
         * PRC19 - INI
         * MOVE FGH015-M-PARM-PED-HST-MIN  TO FGH860-M-INIC-PESQ-R1
         * MOVE FGH015-M-PARM-PED-HST-MAX  TO FGH860-M-FIM-PESQ-R1
         * IF FGH015-M-PARM-PED-HST-MIN LESS THAN ZEROS
         * MOVE '-'                     TO FGH860-SINAL-INIC-R1
         * END-IF
         * IF FGH015-M-PARM-PED-HST-MAX LESS THAN ZEROS
         * MOVE '-'                     TO FGH860-SINAL-FIM-R1
         * MOVE FGH015-Z-INIC-MOV          TO FGH860-Z-INIC-PESQ-R1
         * MOVE FGH015-Z-FIM-MOV           TO FGH860-Z-FIM-PESQ-R1
         */
        bghf0860().fgh860Registo().fgh860Header().fgh860MInicPesqR1().set(fwk915().regFwk915Pghq207a().fwk915MParmPedHstMin());
        bghf0860().fgh860Registo().fgh860Header().fgh860MFimPesqR1().set(fwk915().regFwk915Pghq207a().fwk915MParmPedHstMax());
        if (fwk915().regFwk915Pghq207a().fwk915MParmPedHstMin().isLess(0)) {
            bghf0860().fgh860Registo().fgh860Header().fgh860SinalInicR1().set("-");
        }
        if (fwk915().regFwk915Pghq207a().fwk915MParmPedHstMax().isLess(0)) {
            bghf0860().fgh860Registo().fgh860Header().fgh860SinalFimR1().set("-");
        }
        bghf0860().fgh860Registo().fgh860Header().fgh860ZInicPesqR1().set(fwk915().regFwk915Pghq207a().fwk915ZInicMov());
        bghf0860().fgh860Registo().fgh860Header().fgh860ZFimPesqR1().set(fwk915().regFwk915Pghq207a().fwk915ZFimMov());
        /**
         * PRC19 - FIM
         */
        fgh860().setRecord(" ") ;
        fgh860().setRecord(bghf0860().fgh860Registo()) ;
        a31320EscreverFgh860() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32200FormataDetalhe() {
        log(TraceLevel.Debug, "A32200-FORMATA-DETALHE");
        bghf0860().fgh860Registo().initialize() ;
        a31310AcederMovHstCmpl() ;
        if (progOk.isTrue()) {
            wsVariaveis().wsContadorFich().add(1);
            wsVariaveis().wsContadorDetalh().add(1);
            wsTotalSubcontas.add(1);
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860CMapaR2().set(conMgh860);
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860CTipoRegR2().set(conR2);
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860ZMapaR2().set(wTimestamp().wDataTimestamp());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860HMapaR2().set(wsVariaveis().wsHoraMapa());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860CIdioIsoR2().set(conPor);
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860NsRegFichR2().set(wsVariaveis().wsContadorFich());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860NIdRegDestR2().set(wsVariaveis().wsContadorDestino());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860NIdRegCabcR2().set(wsVariaveis().wsContadorHeader());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860NsRegDtlhCabR2().set(wsVariaveis().wsContadorDetalh());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh870SubcontaR2().fgh860CPaisContR2().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh870SubcontaR2().fgh860CBancR2().set(con0035n);
            wsConta().contaCOeEgcCont().set(hv00201Movhst().movhst().cOeEgcCont());
            wsConta().contaNsRdclCont().set(hv00201Movhst().movhst().nsRdclCont());
            wsConta().contaVChkdCont().set(hv00201Movhst().movhst().vChkdCont());
            wsConta().contaCTipoCont().set(hv00201Movhst().movhst().cTipoCont());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh870SubcontaR2().fgh860ContaR2().set(wsConta());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh870SubcontaR2().fgh860NsDepositoR2().set(hv00201Movhst().movhst().nsDeposito());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh870SubcontaR2().fgh860CMoedIsoSctaR2().set(hv00201Movhst().movhst().cMoedIsoScta());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860ZMovimentoR2().set(hv00201Movhst().movhst().tsMovimento().get(1, 10));
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860MMovimentoR2().set(hv00201Movhst().movhst().mMovimento());
            if ((hv00201Movhst().movhst().iDbcr().isEqual("D") && 
                hv00201Movhst().movhst().iEstorno().isEmpty()) || 
                (hv00201Movhst().movhst().iDbcr().isEqual("C") && 
                hv00201Movhst().movhst().iEstorno().isEqual("E"))) {
                bghf0860().fgh860Registo().fgh860Detalhe().fgh860SinalMovR2().set("-");
            }
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860IDbcrR2().set(hv00201Movhst().movhst().iDbcr());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860IEstornoR2().set(hv00201Movhst().movhst().iEstorno());
            if (!hv10201Movhstcpl().movhstcpl().cOperador().isEqual(0)) {
                bghf0860().fgh860Registo().fgh860Detalhe().fgh860COperadorR2().set(hv10201Movhstcpl().movhstcpl().cOperador());
            } else {
                bghf0860().fgh860Registo().fgh860Detalhe().fgh860COperadorR2().set(hv10201Movhstcpl().movhstcpl().cUserid());
            }
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860CTipoCanlAcesR2().set(hv10201Movhstcpl().movhstcpl().cTipoCanlAces());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860COeEgcOpexR2().set(hv10201Movhstcpl().movhstcpl().cOeEgcOpex());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860ZValorR2().set(hv00201Movhst().movhst().zValMov());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860MMovMoeOrigR2().set(hv00201Movhst().movhst().mMovMoeOrigMov());
            if ((hv00201Movhst().movhst().iDbcr().isEqual("D") && 
                hv00201Movhst().movhst().iEstorno().isEmpty()) || 
                (hv00201Movhst().movhst().iDbcr().isEqual("C") && 
                hv00201Movhst().movhst().iEstorno().isEqual("E"))) {
                bghf0860().fgh860Registo().fgh860Detalhe().fgh860SinalMovOrgR2().set("-");
            }
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860IDbcrOrgR2().set(hv00201Movhst().movhst().iDbcr());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860IEstornoOrgR2().set(hv00201Movhst().movhst().iEstorno());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860CMoedIsoOrgR2().set(hv00201Movhst().movhst().cMoedIsoOriMov());
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860NsMovimentoR2().set(hv00201Movhst().movhst().nsMovimento());
            if (hv00201Movhst().movhst().xRefMov().isEmpty() || 
                hv00201Movhst().movhst().xRefMov().isEqual(String.valueOf(LOW_VALUES))) {
                a31800BuscaDescricao() ;
                bghf0860().fgh860Registo().fgh860Detalhe().fgh860DDescR2().set(hrMghk800a().bghl800a().output().xRefMov());
            } else {
                bghf0860().fgh860Registo().fgh860Detalhe().fgh860DDescR2().set(hv00201Movhst().movhst().xRefMov());
            }
            bghf0860().fgh860Registo().fgh860Detalhe().fgh860NDocOppsR2().set(hv00201Movhst().movhst().nDocOpps());
            fgh860().setRecord(" ") ;
            fgh860().setRecord(bghf0860().fgh860Registo()) ;
            a31320EscreverFgh860() ;
        }
        if (progOk.isTrue()) {
            a31600FetchCursorC3() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32300FormataTotal() {
        log(TraceLevel.Debug, "A32300-FORMATA-TOTAL");
        bghf0860().fgh860Registo().initialize() ;
        wsVariaveis().wsContadorFich().add(1);
        wsVariaveis().wsContadorTotais().add(1);
        bghf0860().fgh860Registo().fgh860Totais().fgh860CMapaR3().set(conMgh860);
        bghf0860().fgh860Registo().fgh860Totais().fgh860CTipoRegR3().set(conR3);
        bghf0860().fgh860Registo().fgh860Totais().fgh860ZMapaR3().set(wTimestamp().wDataTimestamp());
        bghf0860().fgh860Registo().fgh860Totais().fgh860HMapaR3().set(wsVariaveis().wsHoraMapa());
        bghf0860().fgh860Registo().fgh860Totais().fgh860CIdioIsoR3().set(conPor);
        bghf0860().fgh860Registo().fgh860Totais().fgh860NsRegFichR3().set(wsVariaveis().wsContadorFich());
        bghf0860().fgh860Registo().fgh860Totais().fgh860NIdRegDestR3().set(wsVariaveis().wsContadorDestino());
        bghf0860().fgh860Registo().fgh860Totais().fgh860NIdRegCabcR3().set(wsVariaveis().wsContadorHeader());
        bghf0860().fgh860Registo().fgh860Totais().fgh860NIdRegTotR3().set(wsVariaveis().wsContadorTotais());
        bghf0860().fgh860Registo().fgh860Totais().fgh860TotalMovimentosR3().set(wsTotalSubcontas);
        fgh860().setRecord(" ") ;
        fgh860().setRecord(bghf0860().fgh860Registo()) ;
        a31320EscreverFgh860() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32400TrataDescricoes() {
        log(TraceLevel.Debug, "A32400-TRATA-DESCRICOES");
        wsDPais.set(" ");
        wsDBanco.set(" ");
        wsDBalcao.set(" ");
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set(con910);
        bhgl030a().commarea().dadosInput().cCodigo().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
        bhgl030a().commarea().dadosInput().cIdioIso().set(conPor);
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            wsDPais.set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            wsDPais.set(" ");
        }
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set(con983);
        bhgl030a().commarea().dadosInput().cCodigo().get(1, 3).set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest()) ;
        bhgl030a().commarea().dadosInput().cCodigo().get(4, 4).set(con0035n) ;
        bhgl030a().commarea().dadosInput().cIdioIso().set(conPor);
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            wsDBanco.set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            wsDBanco.set(" ");
        }
        bhgl004a().commarea().initialize() ;
        bhgl004a().commarea().dadosInput().cPaisIsoAlfn().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
        bhgl004a().commarea().dadosInput().cMnemEmpGcx().set(hv01601Oeatrdped().oeatrdped().cMnemEgcDest());
        bhgl004a().commarea().dadosInput().cOeEgc().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
        bhgp0004RotDadosOe() ;
        if (bhgl004a().commarea().dadosOutput().semErros().isTrue()) {
            wsDBalcao.set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
        } else {
            wsDBalcao.set(" ");
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
            while (!fwk915().getStatusOk() && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsConta extends IDataStruct {
        
        @Data(size=4)
        IInt contaCOeEgcCont() ;
        
        @Data(size=6)
        IInt contaNsRdclCont() ;
        
        @Data(size=1)
        IInt contaVChkdCont() ;
        
        @Data(size=2)
        IInt contaCTipoCont() ;
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * @return instancia da classe local WsBalcaoConta
         */
        @Data
        WsBalcaoConta wsBalcaoConta() ;
        
        /**
         * @return instancia da classe local WsBalcaoPedido
         */
        @Data
        WsBalcaoPedido wsBalcaoPedido() ;
        
        @Data(size=15, signed=true, value="0", compression=COMP3)
        ILong wsPedido() ;
        
        @Data(size=8, signed=true, value="0", compression=COMP3)
        ILong wsContadorFich() ;
        
        @Data(size=8, signed=true, value="0", compression=COMP3)
        ILong wsContadorDestino() ;
        
        @Data(size=8, signed=true, value="0", compression=COMP3)
        ILong wsContadorHeader() ;
        
        @Data(size=8, signed=true, value="0", compression=COMP3)
        ILong wsContadorDetalh() ;
        
        @Data(size=8, signed=true, value="0", compression=COMP3)
        ILong wsContadorTotais() ;
        
        @Data(size=6, signed=true, value="0")
        IInt wsHoraMapa() ;
        
        /**
         * @return instancia da classe local WsHoraMapaMask
         */
        @Data
        @Mask
        WsHoraMapaMask wsHoraMapaMask() ;
        
        
        public interface WsBalcaoConta extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaCont() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancCont() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcCont() ;
            
        }
        
        public interface WsBalcaoPedido extends IDataStruct {
            
            @Data(size=3, value=" ")
            IString wsCPaisIsoaPed() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCBancPed() ;
            
            @Data(size=4, signed=true, value="0", compression=COMP3)
            IInt wsCOeEgcPed() ;
            
        }
        
        public interface WsHoraMapaMask extends IDataMask {
            
            @Data(size=2)
            IInt wsHoraM() ;
            
            @Data(size=2)
            IInt wsMinutoM() ;
            
            @Data(size=2)
            IInt wsSegundoM() ;
            
        }
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
         * @return instancia da classe local Linha0602
         */
        @Data
        Linha0602 linha0602() ;
        
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
            
            @Data(size=8, value="PGHQ207A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ207A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosFwk915() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ESCRITOS  ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
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
        
        public interface Linha0602 extends IDataStruct {
            
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
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=9, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
