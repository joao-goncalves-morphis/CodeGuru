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


/**
 * 
 * ** AREA DB2/SQL - COMUNICATION AREA
 * ** TABELAS DB2
 * ** DECLARACAO DE CURSORES
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVO     : RECEBE OS FICHEIROS DE DETALHE DOS PEDIDOS
 * VERIFICA QUANTOS DESTINOS EXISTEM PARA CADA
 * UM E REPETE OS DADOS CONFORME O NUMERO DE
 * DESTINOS
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq680a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01601Oeatrdped
     */
    @Data
    protected abstract Vwsdghps01601Oeatrdped hv01601Oeatrdped() ;
    
    
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
     * @return instancia da classe Fwk680
     */
    @Handler(name="FWK680", record="regFwk600")
    @Data
    protected abstract Fwk680 fwk680() ;
    
    /**
     * @return instancia da classe Fwk681
     */
    @Handler(name="FWK681", record="regFwk690")
    @Data
    protected abstract Fwk681 fwk681() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * ***     AREAS DE TRABALHO COMUM    ***
     */
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    
    
    @Data(size=10, signed=true, value="0")
    protected ILong wSqlcode ;
    
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
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * @return instancia da classe local WTimerN
     */
    @Data
    protected abstract WTimerN wTimerN() ;
    
    /**
     * @return instancia da classe local WsChaveAnt
     */
    @Data
    protected abstract WsChaveAnt wsChaveAnt() ;
    
    /**
     * @return instancia da classe local WsChave
     */
    @Data
    protected abstract WsChave wsChave() ;
    
    /**
     * @return instancia da classe local WsArrayOe
     */
    @Data
    protected abstract WsArrayOe wsArrayOe() ;
    
    @Data(size=2)
    protected IInt wsInd ;
    
    @Data(size=15)
    protected ILong wsTsPedido ;
    
    /**
     * @return instancia da classe local WsContadores
     */
    @Data
    protected abstract WsContadores wsContadores() ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ680A");
        progStatus.set(0);
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
        wTimerN().wHhN().set(wTimestamp().wTimerTimestamp().wHh());
        wTimerN().wMmN().set(wTimestamp().wTimerTimestamp().wMm());
        wTimerN().wSsN().set(wTimestamp().wTimerTimestamp().wSs());
        wTimerN().wDdN().set(wTimestamp().wTimerTimestamp().wDd());
        wTimestamp().wTimerTimestamp().wDd().set(0);
        wsChaveAnt().initialize() ;
        wsChave().initialize() ;
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AbrirFwk681() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk680() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk680() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A10000-ABRIR-FGH300");
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
    protected void a13000AbrirFwk681() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWK681");
        fwk681().open(CREATE ) ;
        if (!fwk681().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ680A - FWK681 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk681().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk680() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK680");
        fwk680().open() ;
        if (!fwk680().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ680A - FWK680 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk680().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk680() {
        log(TraceLevel.Debug, "A15000-LER-FWK680");
        wsChaveAnt().set(0);
        fwk680().read() ;
        if (fwk680().getStatusOk()) {
            wsContadores().contRegLidosFwk680().add(1);
            fwk681().regFwk690().fwk690Pedido().fwk690TsPedido().set(fwk680().regFwk600().fwk600Pedido().fwk600TsPedido());
        }
        if (!fwk680().getStatusOk() && !fwk680().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK680 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk680().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarFwk681() ;
        if (progOk.isTrue()) {
            a15000LerFwk680() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarFwk681() {
        log(TraceLevel.Debug, "A31000-TRATAR-FWK681");
        if (!wsChave().isEqual(wsChaveAnt())) {
            hv01601Oeatrdped().oeatrdped().initialize() ;
            wsInd.set(0);
            hv01601Oeatrdped().oeatrdped().tsPedido().set(fwk680().regFwk600().fwk600Pedido().fwk600TsPedido());
            a31330AbrirC1() ;
            if (progOk.isTrue()) {
                a31350FetchC1() ;
            }
            if (getPersistenceCode() == PersistenceCode.NOTFND) {
                wSqlcode.set(getPersistenceCode());
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PED.INEXISTENTE VGH01601-");
                wsTsPedido.set(fwk680().regFwk600().fwk600Pedido().fwk600TsPedido());
                tabelaImpressao().linha09().msgStatus().get(26, 15).set(wsTsPedido) ;
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
            wsInd.add(1);
        } else {
            wsInd.set(0);
        }
        if (progOk.isTrue()) {
            while (getPersistenceCode() == PersistenceCode.NORMAL && wsInd.isLessOrEqual(10)) {
                a31360CarregaOe() ;
            }
        }
        if (wsInd.isGreater(10)) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("TABELA DE PEDIDO EXCEDIDA");
            wsTsPedido.set(fwk680().regFwk600().fwk600Pedido().fwk600TsPedido());
            tabelaImpressao().linha09().msgStatus().get(26, 15).set(wsTsPedido) ;
            tabelaImpressao().linha09().impStatus().set(wsInd);
        }
        if (progOk.isTrue()) {
            a31370CloseC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31360CarregaOe() {
        log(TraceLevel.Debug, "A31360-CARREGA-OE");
        fwk681().setRecord(fwk680().getRecord()) ;
        if (!wsChave().isEqual(wsChaveAnt())) {
            wsArrayOe().initialize() ;
            fwk681().regFwk690().fwk690Destino().fwk690CPaisIsoaDest().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
            wsArrayOe().array().get(wsInd).arrayCPaisIsoaDest().set(hv01601Oeatrdped().oeatrdped().cPaisIsoaDest());
            fwk681().regFwk690().fwk690Destino().fwk690CMnemEgcDest().set(hv01601Oeatrdped().oeatrdped().cMnemEgcDest());
            wsArrayOe().array().get(wsInd).arrayCMnemEgcDest().set(hv01601Oeatrdped().oeatrdped().cMnemEgcDest());
            fwk681().regFwk690().fwk690Destino().fwk690COeEgcDest().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
            wsArrayOe().array().get(wsInd).arrayCOeEgcDest().set(hv01601Oeatrdped().oeatrdped().cOeEgcDest());
        } else {
            wsInd.add(1);
            fwk681().regFwk690().fwk690Destino().fwk690CPaisIsoaDest().set(wsArrayOe().array().get(wsInd).arrayCPaisIsoaDest());
            fwk681().regFwk690().fwk690Destino().fwk690CMnemEgcDest().set(wsArrayOe().array().get(wsInd).arrayCMnemEgcDest());
            fwk681().regFwk690().fwk690Destino().fwk690COeEgcDest().set(wsArrayOe().array().get(wsInd).arrayCOeEgcDest());
        }
        s10000WriteFwk681() ;
        if (!wsChave().isEqual(wsChaveAnt())) {
            if (progOk.isTrue()) {
                a31350FetchC1() ;
                wsInd.add(1);
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s10000WriteFwk681() {
        log(TraceLevel.Debug, "S10000-WRITE-FWK681");
        fwk681().write(fwk681().regFwk690()) ;
        if (fwk681().getStatusOk()) {
            wsContadores().contRegEscrtFwk681().add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ680A - FWK681 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk681().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31330AbrirC1() {
        log(TraceLevel.Debug, "A31330-ABRIR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01601Oeatrdped().openPghq680a558() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ680A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31350FetchC1() {
        log(TraceLevel.Debug, "A31350-FETCH-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv01601Oeatrdped().fetchPghq680a584() ;
        if (hv01601Oeatrdped().getPersistenceCode() == PersistenceCode.NORMAL) {
            progOk.setTrue() ;
        }
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NOTFND) {
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ680A - FETCH C1- VGH01601 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31370CloseC1() {
        log(TraceLevel.Debug, "A31370-CLOSE-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv01601Oeatrdped().closePghq680a615() ;
        if (hv01601Oeatrdped().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ680A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv01601Oeatrdped().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void s70000Fim() {
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichRead().set("FWK680");
            tabelaImpressao().linha05().impRegLidosFwk680().set(wsContadores().contRegLidosFwk680());
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FWK681");
            tabelaImpressao().linha06().impRegEscrt().set(wsContadores().contRegEscrtFwk681());
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ680A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk680().close() ;
        fwk681().close() ;
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
    @Override
    protected void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         */
        s10000Iniciar() ;
        if (progOk.isTrue()) {
            while (!fwk680().getStatusOk() && progOk.isTrue()) {
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
    public interface WTimerN extends IDataStruct {
        
        @Data(size=2)
        IInt wHhN() ;
        
        @Data(size=2)
        IInt wMmN() ;
        
        @Data(size=2)
        IInt wSsN() ;
        
        @Data(size=6)
        IInt wDdN() ;
        
    }
    public interface WsChaveAnt extends IDataStruct {
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong antTsPedido() ;
        
    }
    public interface WsChave extends IDataStruct {
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong chaveTsPedido() ;
        
    }
    public interface WsArrayOe extends IDataStruct {
        
        /**
         * @return instancia da classe local Array
         */
        @Data(length=10)
        IArray<Array> array() ;
        
        
        public interface Array extends IDataStruct {
            
            @Data(size=3)
            IString arrayCPaisIsoaDest() ;
            
            @Data(size=3)
            IString arrayCMnemEgcDest() ;
            
            @Data(size=4, signed=true, compression=COMP3)
            IInt arrayCOeEgcDest() ;
            
        }
    }
    public interface WsContadores extends IDataStruct {
        
        @Data(size=9)
        ILong contRegLidosFwk680() ;
        
        @Data(size=9)
        ILong contRegEscrtFwk681() ;
        
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
            
            @Data(size=8, value="PGHQ680A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ680A")
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
            IFormattedString impRegLidosFwk680() ;
            
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
        
        @Data(length=10, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
