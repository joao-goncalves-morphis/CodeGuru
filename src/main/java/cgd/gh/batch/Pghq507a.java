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
import cgd.hy.routines.Mhyj230a ;
import cgd.hg.routines.Mhgj960a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    :CRIA PEDIDO GH00098 PARA A CRIACAO DO FICHEIRO
 * MENSAL DAS COBRANCAS DE TSU
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq507a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
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
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
    /**
     * @return instancia da classe Mhgj960a
     */
    @Data
    protected abstract Mhgj960a hrMhgj960a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    @Data
    @Condition("2")
    protected ICondition progDataInv ;
    @Data
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("8")
    protected ICondition progJaExiste ;
    
    
    @Data(size=1)
    protected IString swCrtlDgt ;
    @Data
    @Condition("1")
    protected ICondition dgt ;
    @Data
    @Condition("2")
    protected ICondition naoDgt ;
    
    
    @Data(size=1)
    protected IString dfheiblk ;
    
    @Data(size=2, value="23")
    protected IString wsConSubtrPrzData ;
    
    @Data(size=2, value="09")
    protected IString wsConUltDiaMes ;
    
    @Data(size=4, signed=true, value="4", compression=COMP3)
    protected IInt wsConTipoPrazMes ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
    /**
     * @return instancia da classe local WsSysin
     */
    @Data
    protected abstract WsSysin wsSysin() ;
    
    @Data(size=3, value="TSU")
    protected IString wsProtocoloTsu ;
    
    /**
     * @return instancia da classe local WsCProtoc
     */
    @Data
    protected abstract WsCProtoc wsCProtoc() ;
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(format="+ZZ9")
    protected IFormattedString wsCRtnoEvenSwal ;
    
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
    
    /**
     * @return instancia da classe local WsData
     */
    @Data
    protected abstract WsData wsData() ;
    
    /**
     * @return instancia da classe local WDataCrtl
     */
    @Data
    protected abstract WDataCrtl wDataCrtl() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * @return instancia da classe local WsDataInicio
     */
    @Data
    protected abstract WsDataInicio wsDataInicio() ;
    
    /**
     * @return instancia da classe local WsDataFim
     */
    @Data
    protected abstract WsDataFim wsDataFim() ;
    
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
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtTgh015 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ507A");
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
        wTsPedidoMask().wSsPedido().set(wTimestamp().wTimerTimestamp().wSs());
        wTsPedidoMask().wDdPedido().set(wTimestamp().wTimerTimestamp().wDd());
        wsTsPedido.set(wTsPedido);
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a14000ObtemUltDiaMes() ;
        }
        if (progOk.isTrue()) {
            a15000BuscaProtocolos() ;
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
    protected void a14000ObtemUltDiaMes() {
        log(TraceLevel.Debug, "OBTEM-ULT-DIA-MES");
        if (!wTimestamp().wDataTimestamp().wDiaDd().isEqual(1)) {
            progDataInv.setTrue() ;
        } else {
            wDataCrtl().set(wTimestamp().wDataTimestamp());
            wDataCrtl().wMesCrtl().set(subtract(wDataCrtl().wMesCrtl(), 1));
            if (wDataCrtl().wMesCrtl().isEqual(0)) {
                wDataCrtl().wMesCrtl().set(12);
                wDataCrtl().wAnoCrtl().set(subtract(wDataCrtl().wAnoCrtl(), 1));
            }
            hrMhyj230a().bhyl230a().commarea().initialize() ;
            wSqlcode.initialize() ;
            hrMhyj230a().bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(wsConUltDiaMes);
            hrMhyj230a().bhyl230a().commarea().dadosEntrada().iTipoExe().set("R");
            hrMhyj230a().bhyl230a().commarea().dadosEntrada().datInput1().set(wDataCrtl());
            a14100AcederRotinaDatas() ;
            if (progOk.isTrue()) {
                wsDataFim().set(wsData());
                wsDataInicio().set(wsData());
                wsDataInicio().wDiaDdIni().set(1);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14100AcederRotinaDatas() {
        log(TraceLevel.Debug, "A14100-ACEDER-ROTINA-DATAS");
        hrMhyj230a().run() ;
        if (hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().semErros().isTrue()) {
            wsData().set(hrMhyj230a().bhyl230a().commarea().dadosSaida().zOutput());
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().get(1, 21).set("PGHQ507A - MHYJ230A -") ;
            wSqlcode.set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cSqlcode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
            wsCRtnoEvenSwal.set(hrMhyj230a().bhyl230a().commarea().dadosSaida().estado().cRtnoEvenSwal());
            tabelaImpressao().linha08().msgStatus().get(22, 4).set(wsCRtnoEvenSwal) ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000BuscaProtocolos() {
        log(TraceLevel.Debug, "A15000-BUSCA-PROTOCOLOS");
        hrMhgj960a().bhgl960a().commarea().initialize() ;
        hrMhgj960a().bhgl960a().commarea().dadosInput().cProtContI().set(wsProtocoloTsu);
        hrMhgj960a().run() ;
        if (hrMhgj960a().bhgl960a().commarea().dadosOutput().semErros().isTrue()) {
            hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().resetIndex() ;
        } else if (!hrMhgj960a().bhgl960a().commarea().dadosOutput().dadosNotfnd().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().get(1, 21).set("PGHQ507A - MHGJ960A -") ;
            wSqlcode.set(hrMhgj960a().bhgl960a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
            wsCRtnoEvenSwal.set(hrMhgj960a().bhgl960a().commarea().dadosOutput().cRtnoEvenSwal());
            tabelaImpressao().linha08().msgStatus().get(22, 4).set(wsCRtnoEvenSwal) ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        naoDgt.setTrue() ;
        wsCProtoc().wsCProtocP().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cProtContP());
        wsCProtoc().wsCProtocS().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cProtContS());
        if (wsCProtoc().get(1, 4).isEqual("TSUC") || 
            wsCProtoc().get(1, 4).isEqual("TSUM") || 
            wsCProtoc().get(1, 4).isEqual("TSUA") || 
            wsCProtoc().get(1, 4).isEqual("TSUT")) {
            dgt.setTrue() ;
        }
        if (dgt.isTrue()) {
            a31000FormatarPedido() ;
            if (progOk.isTrue()) {
                if (progOk.isTrue()) {
                    a32000CarregarPedido() ;
                }
            }
        }
        hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().incIndex() ;
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
            tabelaImpressao().linha06().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressaoMask().zimp().setIndex(5) ;
            tabelaImpressao().linha05().impFichEsc().set("TGH00015");
            tabelaImpressao().linha05().impRegEscrt().set(contRegEscrtTgh015);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(9) ;
            tabelaImpressao().linha09().msgLivre().set("****** CARREGAMENTO DO PEDIDO DA TSU ******");
            a12000EscreverFgh300() ;
        } else if (progDataInv.isTrue()) {
            tabelaImpressaoMask().zimp().setIndex(9) ;
            tabelaImpressao().linha09().msgLivre().set("****** TSU - NAO E PRIMEIRO DIA MES  ******");
            a12000EscreverFgh300() ;
        } else {
            rollback() ;
            tabelaImpressao().linha06().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha06().impReturnCode().set(returnCode);
            tabelaImpressao().linha07().impMens1().set("PGHQ507A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(6); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
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
    protected void a31000FormatarPedido() {
        log(TraceLevel.Debug, "A31000-CARREGAR-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set("GH00098");
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cOeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().nsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().vChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().nsDeposito());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(wsDataInicio());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(wsDataFim());
        hv01501Pedmovhst().pedmovhst().tsPedido().set(wsTsPedido);
        hv01501Pedmovhst().pedmovhst().zPedido().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("A");
        hv01501Pedmovhst().pedmovhst().cCanlTrmzInf().set("CD");
        hv01501Pedmovhst().pedmovhst().cEndcFtpDest().set("DBI01");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().zEliminacao().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().cUsidCrix().set("PGHQ507A");
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set("PGHQ507A");
        hv01501Pedmovhst().pedmovhst().cPaisIsoaOeOpx().set("PT");
        hv01501Pedmovhst().pedmovhst().cMnemEgcOpex().set("CGD");
        hv01501Pedmovhst().pedmovhst().cOeEgcOpex().set(9999);
        hv01501Pedmovhst().pedmovhst().qDdbtPed().set(0);
        a31000ValidarPedido() ;
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
    protected void a31000ValidarPedido() {
        log(TraceLevel.Debug, "A31000-VALIDAR-PEDIDO");
        hv01801Pedinf().pedinf().initialize() ;
        hv01801Pedinf().pedinf().cPedInfOpps().set(hv01501Pedmovhst().pedmovhst().cPedInfOpps());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01801_PEDINF
         */
        hv01801Pedinf().selectPghq507a600() ;
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ507A - SELECT TGH18 -");
            wSqlcode.set(hv01801Pedinf().getPersistenceCode());
            tabelaImpressao().linha08().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000CarregarPedido() {
        log(TraceLevel.Debug, "A32000-CARREGAR-PEDIDO");
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().insertPghq507a638() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegEscrtTgh015.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ507A - INSERT TGH15 -  ");
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
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
         * *----------------------------------------------------------------*
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().getCurrent().cPaisIsoaCont().isEmpty() && hrMhgj960a().bhgl960a().commarea().dadosOutput().contaProt().index().isLessOrEqual(999) && progOk.isTrue()) {
                s30000Processar() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface WsSysin extends IDataStruct {
        
        @Data(size=10, value=" ")
        IString wsDataSysin() ;
        
    }
    public interface WsCProtoc extends IDataStruct {
        
        @Data(size=3)
        IString wsCProtocP() ;
        
        @Data(size=4)
        IString wsCProtocS() ;
        
    }
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=4)
        IInt anoCorrente() ;
        
        @Data(size=2)
        IInt mesCorrente() ;
        
        @Data(size=2)
        IInt diaCorrente() ;
        
    }
    public interface WsData extends IDataStruct {
        
        @Data(size=4)
        IInt wsAno() ;
        
        @Data(size=2, lpadding=1)
        IInt wsMes() ;
        
        @Data(size=2, lpadding=1)
        IInt wsDia() ;
        
    }
    public interface WDataCrtl extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoCrtl() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesCrtl() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaCrtl() ;
        
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
    public interface WsDataInicio extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoAaIni() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesMmIni() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaDdIni() ;
        
    }
    public interface WsDataFim extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoAaFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesMmFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaDdFim() ;
        
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
        
        @Data(size=2)
        IInt wSsPedido() ;
        
        @Data(size=1)
        IInt wDdPedido() ;
        
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
            
            @Data(size=8, value="PGHQ507A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ507A")
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
