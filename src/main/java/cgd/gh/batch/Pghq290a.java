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
 * *GH1108--> FIM
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVO     : TRATAMENTO DO PEDIDO GH00001
 * . INFORMACAO DO ENDERECO FILE-TRANSFER NA PARM
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq290a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwkb16
     */
    @Handler(name="FWKB16", record="regFwkb16")
    @Data
    protected abstract Fwkb16 fwkb16() ;
    
    /**
     * @return instancia da classe Fwk290
     */
    @Handler(name="FWK290", record="regFwk290")
    @Data
    protected abstract Fwk290 fwk290() ;
    
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    
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
     * *GH1108--> INICIO
     * *01  CONT-REG-ESCRT-FGH500       PIC S9(7)   COMP-3   VALUE +0.
     * *01  CONT-REG-ESCRT-FGH508       PIC S9(7)   COMP-3   VALUE +0.
     * *01  CONT-REG-ESCRT-FGH509       PIC S9(7)   COMP-3   VALUE +0.
     * *01  CONT-REG-ESCRT-FGH510       PIC S9(7)   COMP-3   VALUE +0.
     * *01  CONT-REG-ESCRT-FGH511       PIC S9(7)   COMP-3   VALUE +0.
     */
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFwkb16 ;
    
    /**
     * *GH1108--> FIM
     */
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk290 ;
    
    /**
     * @return instancia da classe local WsRegisto
     */
    @Data
    protected abstract WsRegisto wsRegisto() ;
    
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
     * *GH1108--> INICIO
     * *S00000-TRATAR-PARM.
     * SET PROG-OK                  TO TRUE
     * PERFORM A00001-ABRIR-FGH040
     * IF PROG-OK
     * PERFORM A00002-LER-FGH040
     * END-IF
     * *A00001-ABRIR-FGH040.
     * SET SW-DEBUG-ON TO TRUE
     * SET SW-»EBUG-OFF TO TRUE
     * IF SW-DEBUG-ON
     * DISPLAY 'A00001-ABRIR-FGH040'
     * OPEN INPUT FGH040
     * IF NOT FGH040-STATUS-OK
     * MOVE +16                 TO RETURN-CODE
     * PROG-STATUS
     * MOVE 'PGHQ290A - FGH040 - OPEN - ' TO MSG-STATUS
     * MOVE STATUS-FGH040                 TO IMP-STATUS
     * *A00002-LER-FGH040.
     * SET SW-DEBUG-OFF TO TRUE
     * DISPLAY 'A00002-LER-FGH040'
     * READ FGH040 INTO WS-FICHEIRO-FGH040
     * EVALUATE TRUE
     * WHEN FGH040-STATUS-OK
     * PERFORM A00003-VALIDAR-PARM
     * WHEN OTHER
     * MOVE +16                TO RETURN-CODE
     * MOVE 'PGHQ290A - FGH040 - READ - ' TO MSG-STATUS
     * END-EVALUATE
     * *A00003-VALIDAR-PARM.
     * DISPLAY 'A00003-VALIDAR-PARM'
     * IF WS-NM-FICHEIRO-1  = SPACES
     * OR
     * WS-C-ENDC-FTP-DEST-1 = SPACES
     * WS-NM-FICHEIRO-2 = SPACES
     * WS-C-ENDC-FTP-DEST-2 = SPACES
     * WS-NM-FICHEIRO-3 = SPACES
     * WS-C-ENDC-FTP-DEST-3 = SPACES
     * WS-NM-FICHEIRO-4 = SPACES
     * WS-C-ENDC-FTP-DEST-4 = SPACES
     * WS-NM-FICHEIRO-5 = SPACES
     * WS-C-ENDC-FTP-DEST-5 = SPACES
     * MOVE +16                            TO RETURN-CODE
     * DISPLAY 'PARM INVALIDO'
     * UPON SYSOUT
     * *GH1108--> FIM
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ290A");
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
        wsChaveAnt().initialize() ;
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        /**
         * *GH1108--> INICIO
         * IF PROG-OK
         * PERFORM A13000-ABRIR-FGH500
         * END-IF
         * PERFORM A13100-ABRIR-FGH508
         * PERFORM A13200-ABRIR-FGH509
         * PERFORM A13300-ABRIR-FGH510
         * PERFORM A13400-ABRIR-FGH511
         */
        if (progOk.isTrue()) {
            a13000AbrirFwkb16() ;
        }
        /**
         * *GH1108--> FIM
         */
        if (progOk.isTrue()) {
            a14000AbrirFwk290() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk290() ;
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
     * *GH1108--> INICIO
     * *A13000-ABRIR-FGH500.
     * IF SW-DEBUG-ON
     * DISPLAY 'A13000-ABRIR-FGH500'
     * END-IF
     * OPEN OUTPUT FGH500
     * IF NOT FGH500-STATUS-OK
     * MOVE +16                 TO RETURN-CODE
     * PROG-STATUS
     * MOVE 'PGHQ290A - FGH500 - OPEN - ' TO MSG-STATUS
     * MOVE STATUS-FGH500                 TO IMP-STATUS
     * *A13100-ABRIR-FGH508.
     * DISPLAY 'A13100-ABRIR-FGH508'
     * OPEN OUTPUT FGH508
     * IF NOT FGH508-STATUS-OK
     * MOVE 'PGHQ290A - FGH508 - OPEN - ' TO MSG-STATUS
     * MOVE STATUS-FGH508                 TO IMP-STATUS
     * *A13200-ABRIR-FGH509.
     * DISPLAY 'A13100-ABRIR-FGH509'
     * OPEN OUTPUT FGH509
     * IF NOT FGH509-STATUS-OK
     * MOVE 'PGHQ290A - FGH509 - OPEN - ' TO MSG-STATUS
     * MOVE STATUS-FGH509                 TO IMP-STATUS
     * *A13300-ABRIR-FGH510.
     * DISPLAY 'A13300-ABRIR-FGH510'
     * OPEN OUTPUT FGH510
     * IF NOT FGH510-STATUS-OK
     * MOVE 'PGHQ290A - FGH510 - OPEN - ' TO MSG-STATUS
     * MOVE STATUS-FGH510                 TO IMP-STATUS
     * *A13400-ABRIR-FGH511.
     * DISPLAY 'A13300-ABRIR-FGH511'
     * OPEN OUTPUT FGH511
     * IF NOT FGH511-STATUS-OK
     * MOVE 'PGHQ290A - FGH511 - OPEN - ' TO MSG-STATUS
     * MOVE STATUS-FGH511                 TO IMP-STATUS
     * 
     */
    protected void a13000AbrirFwkb16() {
        log(TraceLevel.Debug, "A13000-ABRIR-FWKB16");
        fwkb16().open(CREATE ) ;
        if (!fwkb16().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ290A - FWKB16 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwkb16().getStatus());
        }
    }
    
    /**
     * 
     * *GH1108--> FIM
     * 
     */
    protected void a14000AbrirFwk290() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK290");
        fwk290().open() ;
        if (!fwk290().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ290A - FWK290 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk290().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk290() {
        log(TraceLevel.Debug, "A15000-LER-FWK290");
        fwk290().read() ;
        if (fwk290().getStatusOk()) {
            contRegLidosFwk290.add(1);
            wsChave().wsCPaisIsoaCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CPaisIsoaCont());
            wsChave().wsCBancCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CBancCont());
            wsChave().wsCOeEgcCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290COeEgcCont());
            wsChave().wsNsRdclCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsRdclCont());
            wsChave().wsVChkdCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290VChkdCont());
            wsChave().wsCTipoCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CTipoCont());
            wsChave().wsCMoedIsoScta().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CMoedIsoScta());
            wsChave().wsNsDeposito().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsDeposito());
            wsChave().wsCPedInfOpps().set(fwk290().regFwk290().fwk290Pedido().fwk290CPedInfOpps());
            wsChave().wsZInicMov().set(fwk290().regFwk290().fwk290Pedido().fwk290ZInicMov());
            wsChave().wsZFimMov().set(fwk290().regFwk290().fwk290Pedido().fwk290ZFimMov());
        }
        if (!fwk290().getStatusOk() && !fwk290().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ290A - FWK290 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk290().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a31000TratarRegisto() ;
        /**
         * *GH1108--> INICIO
         * EVALUATE TRUE
         * WHEN FWK290-C-ENDC-FTP-DEST(1:10) = WS-C-ENDC-FTP-DEST-1
         * PERFORM A31000-TRATAR-FGH500
         * WHEN FWK290-C-ENDC-FTP-DEST(1:10) = WS-C-ENDC-FTP-DEST-2
         * PERFORM A32000-TRATAR-FGH508
         * WHEN FWK290-C-ENDC-FTP-DEST(1:10) = WS-C-ENDC-FTP-DEST-3
         * PERFORM A33000-TRATAR-FGH509
         * WHEN FWK290-C-ENDC-FTP-DEST(1:10) = WS-C-ENDC-FTP-DEST-4
         * PERFORM A34000-TRATAR-FGH510
         * WHEN FWK290-C-ENDC-FTP-DEST(1:10) = WS-C-ENDC-FTP-DEST-5
         * PERFORM A35000-TRATAR-FGH511
         * WHEN OTHER
         * ACT0520 - 2010-12-30 - I - CANCELAMENTO EGH022DB
         * MOVE +16             TO RETURN-CODE
         * PROG-STATUS
         * MOVE 'PGHQ290A - NAO EXISTE INF VALIDA NA PARM'
         * TO MSG-STATUS
         * CONTINUE
         * ACT0520 - 2010-12-30 - F
         * END-EVALUATE
         */
        a32000EscreverFwkb16() ;
        /**
         * *GH1108--> FIM
         */
        if (progOk.isTrue()) {
            a15000LerFwk290() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000TratarRegisto() {
        log(TraceLevel.Debug, "A31000-TRATAR-REGISTO");
        wsRegisto().initialize() ;
        wsRegisto().waCPaisIsoaCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CPaisIsoaCont());
        wsRegisto().waCBancCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CBancCont());
        wsRegisto().waCOeEgcCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290COeEgcCont());
        wsRegisto().waNsRdclCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsRdclCont());
        wsRegisto().waVChkdCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290VChkdCont());
        wsRegisto().waCTipoCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CTipoCont());
        wsRegisto().waCMoedIsoScta().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CMoedIsoScta());
        wsRegisto().waNsDeposito().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsDeposito());
        wsRegisto().waTsMovimento().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290TsMovimento());
        wsRegisto().waNsMovimento().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsMovimento());
        wsRegisto().waZValMov().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290ZValMov());
        wsRegisto().waZMovLocl().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290ZMovLocl());
        wsRegisto().waIDbcr().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290IDbcr());
        wsRegisto().waMMovimento().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MMovimento());
        wsRegisto().waMMovMoeOrigMov().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MMovMoeOrigMov());
        wsRegisto().waSMovimento().set("+");
        wsRegisto().waSMovMoeOrigMov().set("+");
        if (wsRegisto().waIEstorno().isEmpty()) {
            if (wsRegisto().waIDbcr().isEqual("D")) {
                wsRegisto().waSMovimento().set("-");
                wsRegisto().waSMovMoeOrigMov().set("-");
            }
        } else if (wsRegisto().waIDbcr().isEqual("C")) {
            wsRegisto().waSMovimento().set("-");
            wsRegisto().waSMovMoeOrigMov().set("-");
        }
        wsRegisto().waIEstorno().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290IEstorno());
        wsRegisto().waCMoedIsoOriMov().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CMoedIsoOriMov());
        wsRegisto().waMSldoCbloApos().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MSldoCbloApos());
        wsRegisto().waSSldoCbloApos().set("+");
        if (wsRegisto().waMSldoCbloApos().isLess(0)) {
            wsRegisto().waSSldoCbloApos().set("-");
        }
        wsRegisto().waMSldoDpnlApos().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290MSldoDpnlApos());
        wsRegisto().waSSldoDpnlApos().set("+");
        if (wsRegisto().waSSldoDpnlApos().isZeros()) {
            wsRegisto().waSSldoDpnlApos().set("-");
        }
        wsRegisto().waXRefMov().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290XRefMov());
        wsRegisto().waNDocOpps().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NDocOpps());
        wsRegisto().waTJuro().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290TJuro());
        wsRegisto().waAAplOrig().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290AAplOrig());
        wsRegisto().waTsActzUlt().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290TsActzUlt());
        wsRegisto().waCUsidActzUlt().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CUsidActzUlt());
    }
    
    /**
     * 
     * *GH1108--> INICIO
     * *A31000-TRATAR-FGH500.
     * IF SW-DEBUG-ON
     * DISPLAY 'A31000-TRATAR-FGH500'
     * END-IF
     * INITIALIZE REG-FGH500
     * MOVE WS-REGISTO             TO REG-FGH500
     * WRITE REG-FGH500
     * IF FGH500-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FGH500
     * ELSE
     * MOVE +16             TO RETURN-CODE
     * PROG-STATUS
     * MOVE 'PGHQ290A - FGH500 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FGH500     TO IMP-STATUS
     * IF PROG-OK
     * IF WS-CHAVE-ANT NOT = WS-CHAVE
     * PERFORM A31200-ACT-PEDIDO
     * *A32000-TRATAR-FGH508.
     * DISPLAY 'A32000-TRATAR-FGH508'
     * INITIALIZE REG-FGH508
     * MOVE WS-REGISTO             TO REG-FGH508
     * WRITE REG-FGH508
     * IF FGH508-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FGH508
     * MOVE 'PGHQ290A - FGH508 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FGH508     TO IMP-STATUS
     * *A33000-TRATAR-FGH509.
     * DISPLAY 'A33000-TRATAR-FGH509'
     * INITIALIZE REG-FGH509
     * MOVE WS-REGISTO             TO REG-FGH509
     * WRITE REG-FGH509
     * IF FGH509-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FGH509
     * MOVE 'PGHQ290A - FGH509 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FGH509     TO IMP-STATUS
     * *A34000-TRATAR-FGH510.
     * DISPLAY 'A34000-TRATAR-FGH510'
     * INITIALIZE REG-FGH510
     * MOVE WS-REGISTO             TO REG-FGH510
     * WRITE REG-FGH510
     * IF FGH510-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FGH510
     * MOVE 'PGHQ290A - FGH510 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FGH510     TO IMP-STATUS
     * *A35000-TRATAR-FGH511.
     * DISPLAY 'A35000-TRATAR-FGH511'
     * INITIALIZE REG-FGH511
     * MOVE WS-REGISTO             TO REG-FGH511
     * WRITE REG-FGH511
     * IF FGH511-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FGH511
     * MOVE 'PGHQ290A - FGH511 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FGH511     TO IMP-STATUS
     * 
     */
    protected void a32000EscreverFwkb16() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FWKB16");
        fwkb16().regFwkb16().initialize() ;
        fwkb16().setRecord(wsRegisto()) ;
        fwkb16().write(fwkb16().regFwkb16()) ;
        if (fwkb16().getStatusOk()) {
            contRegEscrtFwkb16.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ290A - FWKB16 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwkb16().getStatus());
        }
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                a31200ActPedido() ;
            }
        }
    }
    
    /**
     * 
     * *GH1108--> FIM
     * 
     */
    protected void a31200ActPedido() {
        log(TraceLevel.Debug, "A31200-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().initialize() ;
        hv01501Pedmovhst().pedmovhst().cPaisIsoaCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CPaisIsoaCont());
        hv01501Pedmovhst().pedmovhst().cBancCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CBancCont());
        hv01501Pedmovhst().pedmovhst().cOeEgcCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290COeEgcCont());
        hv01501Pedmovhst().pedmovhst().nsRdclCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsRdclCont());
        hv01501Pedmovhst().pedmovhst().vChkdCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290VChkdCont());
        hv01501Pedmovhst().pedmovhst().cTipoCont().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CTipoCont());
        hv01501Pedmovhst().pedmovhst().cMoedIsoScta().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290CMoedIsoScta());
        hv01501Pedmovhst().pedmovhst().nsDeposito().set(fwk290().regFwk290().fwk290FicheiroFgh500().fwk290NsDeposito());
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk290().regFwk290().fwk290Pedido().fwk290CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk290().regFwk290().fwk290Pedido().fwk290ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk290().regFwk290().fwk290Pedido().fwk290ZFimMov());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq290a1034() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            wsChaveAnt().set(wsChave());
        } else {
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
    protected void s70000Fim() {
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichRead().set("FWK290");
            tabelaImpressao().linha05().impRegLidosFwk290().set(contRegLidosFwk290);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            /**
             * MOVE 'FGH500'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FGH500      TO IMP-REG-ESCRT
             * SET Z TO 6
             * PERFORM A12000-ESCREVER-FGH300
             * MOVE 'FGH508'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FGH508      TO IMP-REG-ESCRT
             * MOVE 'FGH509'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FGH509      TO IMP-REG-ESCRT
             * MOVE 'FGH510'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FGH510      TO IMP-REG-ESCRT
             * MOVE 'FGH511'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FGH511      TO IMP-REG-ESCRT
             */
            tabelaImpressao().linha06().impFichEsc().set("FWKB16");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwkb16);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            /**
             * *GH1108--> FIM
             */
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ290A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk290().close() ;
        fwkb16().close() ;
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
        progOk.setTrue() ;
        if (progOk.isTrue()) {
            s10000Iniciar() ;
        }
        if (progOk.isTrue()) {
            while (!fwk290().getStatusOk() && progOk.isTrue()) {
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
    public interface WsChaveAnt extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaContAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancContAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcContAnt() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclContAnt() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdContAnt() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoContAnt() ;
        
        @Data(size=3)
        IString wsCMoedIsoSctaAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDepositoAnt() ;
        
        @Data(size=7)
        IString wsCPedInfOppsAnt() ;
        
        @Data(size=10)
        IString wsZInicMovAnt() ;
        
        @Data(size=10)
        IString wsZFimMovAnt() ;
        
    }
    public interface WsChave extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoCont() ;
        
        @Data(size=3)
        IString wsCMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDeposito() ;
        
        @Data(size=7)
        IString wsCPedInfOpps() ;
        
        @Data(size=10)
        IString wsZInicMov() ;
        
        @Data(size=10)
        IString wsZFimMov() ;
        
    }
    public interface WsRegisto extends IDataStruct {
        
        @Data(size=3)
        IString waCPaisIsoaCont() ;
        
        @Data(size=4)
        IInt waCBancCont() ;
        
        @Data(size=4)
        IInt waCOeEgcCont() ;
        
        @Data(size=7)
        IInt waNsRdclCont() ;
        
        @Data(size=1)
        IInt waVChkdCont() ;
        
        @Data(size=3)
        IInt waCTipoCont() ;
        
        @Data(size=3)
        IString waCMoedIsoScta() ;
        
        @Data(size=4)
        IInt waNsDeposito() ;
        
        @Data(size=26)
        IString waTsMovimento() ;
        
        @Data(size=15)
        ILong waNsMovimento() ;
        
        @Data(size=10)
        IString waZValMov() ;
        
        @Data(size=10)
        IString waZMovLocl() ;
        
        @Data(size=1)
        IString waIDbcr() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMMovimento() ;
        
        @Data(size=1)
        IString waSMovimento() ;
        
        @Data(size=1)
        IString waIEstorno() ;
        
        @Data(size=3)
        IString waCMoedIsoOriMov() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMSldoCbloApos() ;
        
        @Data(size=1)
        IString waSSldoCbloApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMSldoDpnlApos() ;
        
        @Data(size=1)
        IString waSSldoDpnlApos() ;
        
        @Data(size=17, decimal=2)
        IDecimal waMMovMoeOrigMov() ;
        
        @Data(size=1)
        IString waSMovMoeOrigMov() ;
        
        @Data(size=21)
        IString waXRefMov() ;
        
        @Data(size=10)
        ILong waNDocOpps() ;
        
        @Data(size=10, decimal=7)
        IDecimal waTJuro() ;
        
        @Data(size=2)
        IString waAAplOrig() ;
        
        @Data(size=26)
        IString waTsActzUlt() ;
        
        @Data(size=8)
        IString waCUsidActzUlt() ;
        
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
            
            @Data(size=8, value="PGHQ290A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ290A")
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
            IFormattedString impRegLidosFwk290() ;
            
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
