package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
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


/**
 * 
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CRIA PEDIDO NA TABELA TGH15 PARA A CONSTRUCAO
 * DO FICHEIRO
 * ----->   ESTE PROGRAMA E EXECUTADO SEMPRE QUE EXISTIR O*
 * FICHEIRO FGH926 RECEBIDO POR C.DIRECT
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq520a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00101Conthst
     */
    @Data
    protected abstract Vwsdghps00101Conthst hv00101Conthst() ;
    
    /**
     * @return instancia da classe Vwsdghps01801Pedinf
     */
    @Data
    protected abstract Vwsdghps01801Pedinf hv01801Pedinf() ;
    
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    /**
     * @return instancia da classe Vwsdghps01601Oeatrdped
     */
    @Data
    protected abstract Vwsdghps01601Oeatrdped hv01601Oeatrdped() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh926
     */
    @Handler(name="FGH926", record="rgh92601")
    @Data
    protected abstract Fgh926 fgh926() ;
    
    
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
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=2)
    protected IString statusFgh300 ;
    @Data
    @Condition("00")
    protected ICondition fgh300StatusOk ;
    @Data
    @Condition("10")
    protected ICondition fgh300StatusEof ;
    
    
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
    protected IString wsZInicMov ;
    
    @Data(size=10)
    protected IString wsZFimMov ;
    
    /**
     * @return instancia da classe local WsDataFim
     */
    @Data
    protected abstract WsDataFim wsDataFim() ;
    
    /**
     * @return instancia da classe local WsDataInicio
     */
    @Data
    protected abstract WsDataInicio wsDataInicio() ;
    
    @Data(size=26)
    protected IString wsTimestamp ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=15, signed=true, compression=COMP3)
    protected ILong wsTsPedido ;
    
    @Data(size=15)
    protected ILong wTsPedido ;
    
    /**
     * @return instancia da classe local WTsPedidoMask
     */
    @Data
    @Mask
    protected abstract WTsPedidoMask wTsPedidoMask() ;
    
    /**
     * 03 W-DD-PEDIDO            PIC 9(01).
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFgh926 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtTgh015 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtTgh016 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ520A");
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
        wTsPedidoMask().wAnoPedido().set(wTimestamp().wDataTimestamp().wAnoAa());
        wTsPedidoMask().wMesPedido().set(wTimestamp().wDataTimestamp().wMesMm());
        wTsPedidoMask().wDiaPedido().set(wTimestamp().wDataTimestamp().wDiaDd());
        wTsPedidoMask().wHhPedido().set(wTimestamp().wTimerTimestamp().wHh());
        wTsPedidoMask().wMmPedido().set(wTimestamp().wTimerTimestamp().wMm());
        wTsPedidoMask().wSsPedido().set(1);
        /**
         * MOVE W-DD               TO W-DD-PEDIDO
         */
        wsTsPedido.set(wTsPedido);
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000ObtemDatasAnoAnt() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFgh926() ;
        }
        if (progOk.isTrue()) {
            a15000LerFgh926() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000EscreverFgh300() {
        log(TraceLevel.Debug, "A12000-ESCREVER-FGH300");
        log(TraceLevel.Trace, tabelaImpressaoMask().zimp().getCurrent());
    }
    
    /**
     * 
     * 
     */
    protected void a13000ObtemDatasAnoAnt() {
        log(TraceLevel.Debug, "A13000-OBTEM-DATAS-MES-ANT");
        wsDataFim().wAnoAaFim().set(subtract(wTimestamp().wDataTimestamp().wAnoAa(), 1));
        wsDataFim().wMesMmFim().set(12);
        wsDataFim().wDiaDdFim().set(31);
        wsDataInicio().wAnoAaIni().set(wsDataFim().wAnoAaFim());
        wsDataInicio().wMesMmIni().set(1);
        wsDataInicio().wDiaDdIni().set(1);
        wsZInicMov.set(wsDataInicio());
        /**
         * MOVE WS-DATA-FIM             TO WS-Z-FIM-MOV
         */
        wsZFimMov.set(wTimestamp().wDataTimestamp());
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFgh926() {
        log(TraceLevel.Debug, "A14000-ABRIR-FGH926 ");
        fgh926().open() ;
        if (!fgh926().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ520A - FGH926 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh926().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFgh926() {
        log(TraceLevel.Debug, "A15000-LER-FGH926");
        fgh926().read() ;
        if (fgh926().getStatusOk()) {
            contRegLidosFgh926.add(1);
        }
        if (!fgh926().getStatusOk() && !fgh926().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ520A - FGH926 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fgh926().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000ObterScta() ;
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL) {
                a32000CarregarPedido() ;
            }
        }
        if (progOk.isTrue()) {
            a33000CloseCursorC1() ;
        }
        if (progOk.isTrue()) {
            a15000LerFgh926() ;
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
            tabelaImpressaoMask().zimp().setIndex(5) ;
            tabelaImpressao().linha05().impFichRead().set("FGH926");
            tabelaImpressao().linha05().impRegRead().set(contRegLidosFgh926);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impFichEsc().set("TGH00015");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtTgh015);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(10) ;
            tabelaImpressao().linha10().msgLivre().set("****** CARREGAMENTO DO PEDIDO DA DCR ******");
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressaoMask().zimp().setIndex(7) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQ520A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh926().close() ;
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
    protected void a31000ObterScta() {
        log(TraceLevel.Debug, "A31000-OBTER-SCTA");
        a31100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
        if (getPersistenceCode() != PersistenceCode.NORMAL) {
            log(TraceLevel.Error, "CONTA NAO ENCONTRADA:", "/", fgh926().rgh92601().fgh926CPaisIsoaCont(), "/", fgh926().rgh92601().fgh926CBancCont(), "/", fgh926().rgh92601().fgh926COeEgcCont(), "/", fgh926().rgh92601().fgh926NsRdclCont(), "/", fgh926().rgh92601().fgh926VChkdCont(), "/", fgh926().rgh92601().fgh926CTipoCont(), "/", fgh926().rgh92601().fgh926CMoedIsoScta(), "/", fgh926().rgh92601().fgh926NsDeposito(), "/", fgh926().rgh92601().fgh926CPedInfOpps(), "/", fgh926().rgh92601().fgh926ZInicMov(), "/", fgh926().rgh92601().fgh926ZFimMov(), "/", fgh926().rgh92601().fgh926COeEgcDest());
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
        hv00101Conthst().conthst().cPaisIsoaCont().set(fgh926().rgh92601().fgh926CPaisIsoaCont());
        hv00101Conthst().conthst().cBancCont().set(fgh926().rgh92601().fgh926CBancCont());
        hv00101Conthst().conthst().cOeEgcCont().set(fgh926().rgh92601().fgh926COeEgcCont());
        hv00101Conthst().conthst().nsRdclCont().set(fgh926().rgh92601().fgh926NsRdclCont());
        hv00101Conthst().conthst().vChkdCont().set(fgh926().rgh92601().fgh926VChkdCont());
        hv00101Conthst().conthst().cTipoCont().set(fgh926().rgh92601().fgh926CTipoCont());
        hv00101Conthst().conthst().cMoedIsoScta().set(fgh926().rgh92601().fgh926CMoedIsoScta());
        hv00101Conthst().conthst().nsDeposito().set(fgh926().rgh92601().fgh926NsDeposito());
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv00101Conthst().openPghq520a539() ;
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ520A - CURSOR C1   - OPEN - ");
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
        hv00101Conthst().fetchPghq520a568() ;
        wSqlcode.set(hv00101Conthst().getPersistenceCode());
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv00101Conthst().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ502A - FETCH C1- VGH00101 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
            a33000CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000CarregarPedido() {
        log(TraceLevel.Debug, "A32000-CARREGAR-PEDIDO");
        if (progOk.isTrue()) {
            a32100FormatarPedido() ;
        }
        if (progOk.isTrue()) {
            a32200InsTabelaPedidos() ;
        }
        if (progOk.isTrue()) {
            a31200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100FormatarPedido() {
        log(TraceLevel.Debug, "A32100-FORMATAR-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fgh926().rgh92601().fgh926CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(hv00101Conthst().conthst().cPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(hv00101Conthst().conthst().cBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(hv00101Conthst().conthst().cOeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(hv00101Conthst().conthst().nsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(hv00101Conthst().conthst().vChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(hv00101Conthst().conthst().cTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(hv00101Conthst().conthst().cMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(hv00101Conthst().conthst().nsDeposito());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fgh926().rgh92601().fgh926ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fgh926().rgh92601().fgh926ZFimMov());
        wTsPedidoMask().wSsPedido().add(1);
        wsTsPedido.set(wTsPedido);
        if (wTsPedidoMask().wSsPedido().isEqual(999)) {
            wsTimestamp.set( getDBTimestamp() ) ;
            wTimestamp().set(wsTimestamp);
            wTsPedidoMask().wAnoPedido().set(wTimestamp().wDataTimestamp().wAnoAa());
            wTsPedidoMask().wMesPedido().set(wTimestamp().wDataTimestamp().wMesMm());
            wTsPedidoMask().wDiaPedido().set(wTimestamp().wDataTimestamp().wDiaDd());
            wTsPedidoMask().wHhPedido().set(wTimestamp().wTimerTimestamp().wHh());
            wTsPedidoMask().wMmPedido().set(wTimestamp().wTimerTimestamp().wMm());
            wTsPedidoMask().wSsPedido().set(1);
            /**
             * MOVE W-DD(6:1)          TO W-DD-PEDIDO
             */
            wsTsPedido.set(wTsPedido);
        }
        hv01501Pedmovhst().pedmovhst().tsPedido().set(wsTsPedido);
        hv01501Pedmovhst().pedmovhst().zPedido().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("A");
        hv01501Pedmovhst().pedmovhst().cCanlTrmzInf().set("TD");
        hv01501Pedmovhst().pedmovhst().cEndcFtpDest().set(" ");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().zEliminacao().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().cUsidCrix().set("PGHQ520A");
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set("PGHQ520A");
        hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx().set("PT");
        hv01501Pedmovhst().pedmovhst().cMnemEgcOpex().set("CGD");
        hv01501Pedmovhst().pedmovhst().cOeEgcOpex().set(fgh926().rgh92601().fgh926COeEgcDest());
        hv01501Pedmovhst().pedmovhst().qDdbtPed().set(0);
        a32110ValidarPedido() ;
        if (progOk.isTrue()) {
            hv01501Pedmovhst().pedmovhst().cFrmtInf().set(hv01801Pedinf().pedinf().cFrmtInf());
            hv01501Pedmovhst().pedmovhst().cTipoRpte().set(hv01801Pedinf().pedinf().cTipoRpte());
            hv01501Pedmovhst().pedmovhst().nmFichOutpRtno().set(hv01801Pedinf().pedinf().nmFichOutpRtno());
            hv01501Pedmovhst().pedmovhst().qDiaDpnzInf().set(hv01801Pedinf().pedinf().qDiaDpnzInf());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32110ValidarPedido() {
        log(TraceLevel.Debug, "A32110-VALIDAR-PEDIDO");
        hv01801Pedinf().pedinf().initialize() ;
        hv01801Pedinf().pedinf().cPedInfOpps().set(hv01501Pedmovhst().pedmovhst().cPedInfOpps());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01801_PEDINF
         */
        hv01801Pedinf().selectPghq520a699() ;
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ520A - SELECT TGH18 -");
            wSqlcode.set(hv01801Pedinf().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32200InsTabelaPedidos() {
        log(TraceLevel.Debug, "A32200-INS-TABELA-PEDIDOS");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().insertPghq520a737() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegEscrtTgh015.add(1);
            a32300InsTgh00016() ;
        }
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            log(TraceLevel.Debug, "VGH01501-C-PAIS-ISOA-CONT:", hv01501Pedmovhst().pedmovhst().cPaisIsoaCont());
            log(TraceLevel.Debug, "VGH01501-C-BANC-CONT     :", hv01501Pedmovhst().pedmovhst().cBancCont());
            log(TraceLevel.Debug, "VGH01501-C-OE-EGC-CONT   :", hv01501Pedmovhst().pedmovhst().cOeEgcCont());
            log(TraceLevel.Debug, "VGH01501-NS-RDCL-CONT    :", hv01501Pedmovhst().pedmovhst().nsRdclCont());
            log(TraceLevel.Debug, "VGH01501-V-CHKD-CONT     :", hv01501Pedmovhst().pedmovhst().vChkdCont());
            log(TraceLevel.Debug, "VGH01501-C-TIPO-CONT     :", hv01501Pedmovhst().pedmovhst().cTipoCont());
            log(TraceLevel.Debug, "VGH01501-C-MOED-ISO-SCTA :", hv01501Pedmovhst().pedmovhst().cMoedIsoScta());
            log(TraceLevel.Debug, "VGH01501-NS-DEPOSITO     :", hv01501Pedmovhst().pedmovhst().nsDeposito());
            log(TraceLevel.Debug, "VGH01501-C-PED-INF-OPPS  :", hv01501Pedmovhst().pedmovhst().cPedInfOpps());
            log(TraceLevel.Debug, "VGH01501-Z-INIC-MOV      :", hv01501Pedmovhst().pedmovhst().zInicMov());
            log(TraceLevel.Debug, "VGH01501-Z-FIM-MOV       :", hv01501Pedmovhst().pedmovhst().zFimMov());
            log(TraceLevel.Debug, "VGH01501-TS-PEDIDO       :", hv01501Pedmovhst().pedmovhst().tsPedido());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ520A - INSERT TGH15 -  ");
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32300InsTgh00016() {
        log(TraceLevel.Debug, "A32300-INS-TGH00016");
        log(TraceLevel.Debug, "WS-TS-PEDIDO:", wsTsPedido);
        hv01601Oeatrdped().oeatrdped().initialize() ;
        hv01601Oeatrdped().oeatrdped().tsPedido().set(wsTsPedido);
        hv01601Oeatrdped().oeatrdped().cPaisIsoaDest().set("PT");
        hv01601Oeatrdped().oeatrdped().cMnemEgcDest().set("CGD");
        hv01601Oeatrdped().oeatrdped().cOeEgcDest().set(fgh926().rgh92601().fgh926COeEgcDest());
        hv01601Oeatrdped().oeatrdped().cUsidActzUlt().set("PGHQ520A");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01601_OEATRDPED
         */
        hv01601Oeatrdped().insertPghq520a867() ;
        if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegEscrtTgh016.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ520A - INSERT TGH16 -  ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000CloseCursorC1() {
        log(TraceLevel.Debug, "A33000-CLOSE-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv00101Conthst().closePghq520a909() ;
        if (hv00101Conthst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ520A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv00101Conthst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
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
            while (!fgh926().getStatusOk() && progOk.isTrue()) {
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
    public interface WsDataFim extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoAaFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesMmFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaDdFim() ;
        
    }
    public interface WsDataInicio extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoAaIni() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesMmIni() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaDdIni() ;
        
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
        @Data(lpadding=1, lpaddingValue=" ")
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
    public interface WTsPedidoMask extends IDataMask {
        
        @Data(size=4)
        IInt wAnoPedido() ;
        
        @Data(size=2)
        IInt wMesPedido() ;
        
        @Data(size=2)
        IInt wDiaPedido() ;
        
        @Data(size=2)
        IInt wHhPedido() ;
        
        @Data(size=2)
        IInt wMmPedido() ;
        
        @Data(size=3)
        IInt wSsPedido() ;
        
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
            
            @Data(size=8, value="PGHQ520A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ520A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS     ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegRead() ;
            
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
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=10, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
