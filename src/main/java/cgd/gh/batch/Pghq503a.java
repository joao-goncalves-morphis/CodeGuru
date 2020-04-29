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
import cgd.hy.routines.Mhyj230a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CRIA PEDIDO NA TABELA TGH15 PARA A CONSTRUCAO
 * DO FICHEIRO PARA A DBI  -PEDIDO: GH00096-
 * --->   ESTE PROGRAMA E EXECUTADO A SEGUIR AO FINAL DO*
 * MES. TEM PERIODICIDADE MENSAL
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq503a extends CgdGhBaseBatch {
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
    protected IString dfheiblk ;
    
    @Data(size=2, value="23")
    protected IString wsConSubtrPrzData ;
    
    @Data(size=2, value="09")
    protected IString wsConUltDiaMes ;
    
    @Data(size=4, signed=true, value="4", compression=COMP3)
    protected IInt wsConTipoPrazMes ;
    
    @Data(size=8, value="MHYJ230A")
    protected IString wsRotDatas ;
    
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
     * @return instancia da classe local WsDataFim
     */
    @Data
    protected abstract WsDataFim wsDataFim() ;
    
    /**
     * @return instancia da classe local WsDataInicio
     */
    @Data
    protected abstract WsDataInicio wsDataInicio() ;
    
    /**
     * @return instancia da classe local WsData
     */
    @Data
    protected abstract WsData wsData() ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ503A");
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
            a13000ObtemDatasMesAnt() ;
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
    protected void a13000ObtemDatasMesAnt() {
        log(TraceLevel.Debug, "A13000-OBTEM-DATAS-MES-ANT");
        hrMhyj230a().bhyl230a().commarea().initialize() ;
        wSqlcode.initialize() ;
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(wsConSubtrPrzData);
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().iTipoExe().set("R");
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().datInput1().set(wTimestamp().wDataTimestamp());
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().prazo().cTipoPraz().set(wsConTipoPrazMes);
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().prazo().duTipoPraz().set(1);
        a14100AcederRotinaDatas() ;
        if (progOk.isTrue()) {
            a14200ObtemUltDiaMesAnt() ;
        }
        if (progOk.isTrue()) {
            wsDataFim().set(wsData());
            wsDataInicio().set(wsData());
            wsDataInicio().wDiaDdIni().set(1);
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
            tabelaImpressao().linha08().msgStatus().get(1, 21).set("PGHQ503A - MHYJ230A -") ;
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
    protected void a14200ObtemUltDiaMesAnt() {
        log(TraceLevel.Debug, "A14200-OBTEM-ULT-DIA-MES-ANT");
        hrMhyj230a().bhyl230a().commarea().initialize() ;
        wSqlcode.initialize() ;
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().cFunzMdloData().set(wsConUltDiaMes);
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().iTipoExe().set("R");
        hrMhyj230a().bhyl230a().commarea().dadosEntrada().datInput1().set(wsData());
        a14100AcederRotinaDatas() ;
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000FormatarPedido() ;
        if (progOk.isTrue()) {
            a32000CarregarPedido() ;
        }
        bghw0503().tabContDbi().elemDbi().incIndex() ;
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
            tabelaImpressaoMask().zimp().setIndex(5) ;
            tabelaImpressao().linha05().impFichEsc().set("TGH00015");
            tabelaImpressao().linha05().impRegEscrt().set(contRegEscrtTgh015);
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(9) ;
            tabelaImpressao().linha09().msgLivre().set("****** CARREGAMENTO DO PEDIDO DA DBI ******");
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha06().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha06().impReturnCode().set(returnCode);
            tabelaImpressao().linha07().impMens1().set("PGHQ503A - FIM ANORMAL ");
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
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set("GH00096");
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabCPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabCBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabCOeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabNsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabVChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabCTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabCMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabNsDeposito());
        hv01501Pedmovhst().pedmovhst().cParmPedHstMax().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabCOpeBbn());
        hv01501Pedmovhst().pedmovhst().cParmPedHstMin().set(bghw0503().tabContDbi().elemDbi().getCurrent().tabCOpeBbn());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(wsDataInicio());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(wsDataFim());
        hv01501Pedmovhst().pedmovhst().tsPedido().set(wsTsPedido);
        hv01501Pedmovhst().pedmovhst().zPedido().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("A");
        hv01501Pedmovhst().pedmovhst().cCanlTrmzInf().set("CD");
        hv01501Pedmovhst().pedmovhst().cEndcFtpDest().set("DBI01");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().zEliminacao().set("0001-01-01");
        hv01501Pedmovhst().pedmovhst().cUsidCrix().set("PGHQ503A");
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set("PGHQ503A");
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
        hv01801Pedinf().selectPghq503a543() ;
        if (hv01801Pedinf().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ503A - SELECT TGH18 -");
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
        hv01501Pedmovhst().insertPghq503a581() ;
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegEscrtTgh015.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha08().msgStatus().set("PGHQ503A - INSERT TGH15 -  ");
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
            bghw0503().tabContDbi().elemDbi().resetIndex() ;
            while (bghw0503().tabContDbi().elemDbi().index().isLessOrEqual(2) && progOk.isTrue()) {
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
    public interface WsData extends IDataStruct {
        
        @Data(size=4)
        IInt wsAno() ;
        
        @Data(size=2, lpadding=1)
        IInt wsMes() ;
        
        @Data(size=2, lpadding=1)
        IInt wsDia() ;
        
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
            
            @Data(size=8, value="PGHQ503A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ503A")
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
