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
import cgd.gh.structures.work.Bghw0018 ;
import cgd.hy.structures.link.Bhyl230a ;


/**
 * 
 * PRC19 - FIM
 * ***    DECLARACAO DO CURSOR       ***
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    :-FORMATDOR DE PEDIDOS A PARTIR DO FWK015 UNLOAD*
 * DA TABELA TGH00015_PEDMOVHST
 * -DIVISAO DOS PEDIDOS POR TIPO DE HISTORICOS
 * -MANUTENCAO DA TABELA DE PEDIDOS
 * ALTERACOES    :-PASSA A TRATAR DE FORMA ESPECIAL OS PEDIDOS
 * EXISTENTES NO BOOK BGHW0018 (PROTOCOLOS)
 * -BALDEAMENTO DE HISTORICOS - PASSA A ESCREVER
 * FWK008 PARA O ANO 2008.
 * *----------------->BALDEAMENTO DE HISTORICOS - PASSA A ESCREVER
 * FWK009 PARA O ANO 2009.
 * - ALTERAÇÃO DO PROGRAMA PARA PASSAR A ESCREVER
 * UM UNICO FICHEIRO COM OS PEDIDOS POR RECURSO
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq200a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01001Contiphst
     */
    @Data
    protected abstract Vwsdghps01001Contiphst hv01001Contiphst() ;
    
    
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
     * @return instancia da classe Fwk015
     */
    @Handler(name="FWK015", record="regFwk015Pghq200a")
    @Data
    protected abstract Fwk015 fwk015() ;
    
    /**
     * @return instancia da classe Fgh015
     */
    @Handler(name="FGH015", record="regFgh015")
    @Data
    protected abstract Fgh015 fgh015() ;
    
    /**
     * @return instancia da classe Fwk115
     */
    @Handler(name="FWK115", record="regFwk115Pghq200a")
    @Data
    protected abstract Fwk115 fwk115() ;
    
    /**
     * @return instancia da classe Fwkb15
     */
    @Handler(name="FWKB15", record="regFwkb15")
    @Data
    protected abstract Fwkb15 fwkb15() ;
    
    /**
     * @return instancia da classe Fwk815
     */
    @Handler(name="FWK815", record="regFwk815Pghq200a")
    @Data
    protected abstract Fwk815 fwk815() ;
    
    /**
     * @return instancia da classe Fwk915
     */
    @Handler(name="FWK915", record="regFwk915Pghq200a")
    @Data
    protected abstract Fwk915 fwk915() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw0018
     */
    @Data
    protected abstract Bghw0018 bghw0018() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
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
    protected IString wsCrtlMais ;
    @Data
    @Condition("S")
    protected ICondition haMais ;
    @Data
    @Condition("N")
    protected ICondition naoHaMais ;
    
    
    @Data(size=1)
    protected IString wsProtocolo ;
    @Data
    @Condition("S")
    protected ICondition haProtocolo ;
    @Data
    @Condition("N")
    protected ICondition naoHaProtocolo ;
    
    
    @Data(format="+ZZZZZZZ9")
    protected IFormattedString wSqlcode ;
    
    @Data(size=2)
    protected IInt wsCProtocolo ;
    
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
    
    @Data(size=8, value=" ")
    protected IString wsNmRecurso ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    @Data(size=15, signed=true)
    protected ILong wsTsPedido ;
    
    /**
     * @return instancia da classe local WsTsPedidoMask
     */
    @Data
    @Mask
    protected abstract WsTsPedidoMask wsTsPedidoMask() ;
    
    /**
     * @return instancia da classe local WsDataInic
     */
    @Data
    protected abstract WsDataInic wsDataInic() ;
    
    /**
     * @return instancia da classe local WsDataFim
     */
    @Data
    protected abstract WsDataFim wsDataFim() ;
    
    /**
     * @return instancia da classe local WsNmRecursoVgh01001
     */
    @Data
    protected abstract WsNmRecursoVgh01001 wsNmRecursoVgh01001() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk015 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk115 ;
    
    /**
     * *GH1099--> INICIO
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwkb15 ;
    
    /**
     * 01  CONT-REG-ESCRT-FWK215      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK007      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK008      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK006      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK005      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK004      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK009      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK002      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK003      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK001      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK000      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK999      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK998      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK997      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK996      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK995      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK994      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK993      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK992      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK991      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK990      PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK200      PIC S9(15) COMP-3 VALUE +0.
     * *GH1099--> FIM
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk815 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk915 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFgh015 ;
    
    @Data(size=1, value="0")
    protected IInt wsTotDesd ;
    
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
        bghw0300().wsNmPrograma().set("PGHQ200A");
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
            a13000AbrirFicheiros() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk015() ;
        }
        if (progOk.isTrue()) {
            naoHaProtocolo.setTrue() ;
            a15000LerFwk015() ;
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
    protected void a13000AbrirFicheiros() {
        log(TraceLevel.Debug, "A13000-ABRIR-FICHEIROS");
        fwk115().open(CREATE ) ;
        if (!fwk115().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK115 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk115().getStatus());
        }
        /**
         * *GH1099--> INICIO
         */
        if (progOk.isTrue()) {
            fwkb15().open(CREATE ) ;
            if (!fwkb15().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWKB15 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwkb15().getStatus());
            }
        }
        /**
         * IF PROG-OK
         * OPEN OUTPUT FWK215
         * IF NOT FWK215-STATUS-OK
         * MOVE +16                 TO RETURN-CODE
         * PROG-STATUS
         * MOVE 'PGHQ200A - FWK215 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK215                 TO IMP-STATUS
         * END-IF
         * OPEN OUTPUT FWK008
         * IF NOT FWK008-STATUS-OK
         * MOVE 'PGHQ200A - FWK008 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK008                 TO IMP-STATUS
         * OPEN OUTPUT FWK007
         * IF NOT FWK007-STATUS-OK
         * MOVE 'PGHQ200A - FWK007 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK007                 TO IMP-STATUS
         * OPEN OUTPUT FWK006
         * IF NOT FWK006-STATUS-OK
         * MOVE 'PGHQ200A - FWK006 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK006                 TO IMP-STATUS
         * OPEN OUTPUT FWK005
         * IF NOT FWK005-STATUS-OK
         * MOVE 'PGHQ200A - FWK005 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK005                 TO IMP-STATUS
         * OPEN OUTPUT FWK004
         * IF NOT FWK004-STATUS-OK
         * MOVE 'PGHQ200A - FWK004 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK004                 TO IMP-STATUS
         * OPEN OUTPUT FWK009
         * IF NOT FWK009-STATUS-OK
         * MOVE 'PGHQ200A - FWK009 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK009                 TO IMP-STATUS
         * OPEN OUTPUT FWK002
         * IF NOT FWK002-STATUS-OK
         * MOVE 'PGHQ200A - FWK002 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK002                 TO IMP-STATUS
         * OPEN OUTPUT FWK003
         * IF NOT FWK003-STATUS-OK
         * MOVE 'PGHQ200A - FWK003 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK003                 TO IMP-STATUS
         * OPEN OUTPUT FWK001
         * IF NOT FWK001-STATUS-OK
         * MOVE 'PGHQ200A - FWK001 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK001                 TO IMP-STATUS
         * OPEN OUTPUT FWK000
         * IF NOT FWK000-STATUS-OK
         * MOVE 'PGHQ200A - FWK000 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK000                 TO IMP-STATUS
         * OPEN OUTPUT FWK999
         * IF NOT FWK999-STATUS-OK
         * MOVE 'PGHQ200A - FWK999 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK999                 TO IMP-STATUS
         * OPEN OUTPUT FWK998
         * IF NOT FWK998-STATUS-OK
         * MOVE 'PGHQ200A - FWK998 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK998                 TO IMP-STATUS
         * OPEN OUTPUT FWK997
         * IF NOT FWK997-STATUS-OK
         * MOVE 'PGHQ200A - FWK997 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK997                 TO IMP-STATUS
         * OPEN OUTPUT FWK996
         * IF NOT FWK996-STATUS-OK
         * MOVE 'PGHQ200A - FWK996 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK996                 TO IMP-STATUS
         * OPEN OUTPUT FWK995
         * IF NOT FWK995-STATUS-OK
         * MOVE 'PGHQ200A - FWK995 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK995                 TO IMP-STATUS
         * OPEN OUTPUT FWK994
         * IF NOT FWK994-STATUS-OK
         * MOVE 'PGHQ200A - FWK994 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK994                 TO IMP-STATUS
         * OPEN OUTPUT FWK993
         * IF NOT FWK993-STATUS-OK
         * MOVE 'PGHQ200A - FWK993 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK993                 TO IMP-STATUS
         * OPEN OUTPUT FWK992
         * IF NOT FWK992-STATUS-OK
         * MOVE 'PGHQ200A - FWK992 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK992                 TO IMP-STATUS
         * OPEN OUTPUT FWK991
         * IF NOT FWK991-STATUS-OK
         * MOVE 'PGHQ200A - FWK991 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK991                 TO IMP-STATUS
         * OPEN OUTPUT FWK990
         * IF NOT FWK990-STATUS-OK
         * MOVE 'PGHQ200A - FWK990 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK990                 TO IMP-STATUS
         * OPEN OUTPUT FWK200
         * IF NOT FWK200-STATUS-OK
         * MOVE 'PGHQ200A - FWK200 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK200                 TO IMP-STATUS
         * *GH1099--> FIM
         */
        if (progOk.isTrue()) {
            fwk815().open(CREATE ) ;
            if (!fwk815().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK815 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk815().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk915().open(CREATE ) ;
            if (!fwk915().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK915 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk915().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fgh015().open(CREATE ) ;
            if (!fgh015().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FGH015 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fgh015().getStatus());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk015() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK015");
        fwk015().open() ;
        if (!fwk015().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK015 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk015().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk015() {
        log(TraceLevel.Debug, "A15000-LER-FWK015");
        fwk015().read() ;
        if (fwk015().getStatusOk()) {
            contRegLidosFwk015.add(1);
            wsTotDesd.set(0);
        }
        if (!fwk015().getStatusOk() && !fwk015().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK015 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk015().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (fwk015().regFwk015Pghq200a().fwk015CEstPedHist().isEqual("A")) {
            if (fwk015().regFwk015Pghq200a().fwk015CPedInfOpps().isEqual("GH00105")) {
                a31000EscreverFwk915() ;
            } else if (fwk015().regFwk015Pghq200a().fwk015CPedInfOpps().isEqual("GH00106")) {
                a32000EscreverFwk815() ;
            } else {
                a33000TratarDatasPedidos() ;
            }
            if (progOk.isTrue()) {
                a34000EscreverFgh015() ;
            }
            if (progOk.isTrue()) {
                a34100VerificaProtocolo() ;
            }
        } else if (fwk015().regFwk015Pghq200a().fwk015CEstPedHist().isEqual("N") || 
            fwk015().regFwk015Pghq200a().fwk015CEstPedHist().isEqual("R")) {
            if (fgh015().regFgh015().fgh015ZEliminacao().isGreaterOrEqual(wTimestamp().wDataTimestamp())) {
                a34000EscreverFgh015() ;
            } else {
                a35000EscreverFwk115() ;
            }
        } else if (fwk015().regFwk015Pghq200a().fwk015CEstPedHist().isEqual("T")) {
            if (fgh015().regFgh015().fgh015ZEliminacao().isGreaterOrEqual(wTimestamp().wDataTimestamp())) {
                a34000EscreverFgh015() ;
            } else {
                a35000EscreverFwk115() ;
            }
        } else if (fwk015().regFwk015Pghq200a().fwk015CEstPedHist().isEqual("E")) {
            a34000EscreverFgh015() ;
        } else {
            a34000EscreverFgh015() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk015() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000EscreverFwk915() {
        log(TraceLevel.Debug, "A31000-ESCREVER-FWK915");
        fwk915().regFwk915Pghq200a().initialize() ;
        /**
         * PRC19 - INI
         * MOVE REG-FWK015          TO REG-FWK915
         */
        fwk915().regFwk915Pghq200a().fwk915CPaisIsoaCont().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaCont());
        fwk915().regFwk915Pghq200a().fwk915CBancCont().set(fwk015().regFwk015Pghq200a().fwk015CBancCont());
        fwk915().regFwk915Pghq200a().fwk915COeEgcCont().set(fwk015().regFwk015Pghq200a().fwk015COeEgcCont());
        fwk915().regFwk915Pghq200a().fwk915NsRdclCont().set(fwk015().regFwk015Pghq200a().fwk015NsRdclCont());
        fwk915().regFwk915Pghq200a().fwk915VChkdCont().set(fwk015().regFwk015Pghq200a().fwk015VChkdCont());
        fwk915().regFwk915Pghq200a().fwk915CTipoCont().set(fwk015().regFwk015Pghq200a().fwk015CTipoCont());
        fwk915().regFwk915Pghq200a().fwk915CMoedIsoScta().set(fwk015().regFwk015Pghq200a().fwk015CMoedIsoScta());
        fwk915().regFwk915Pghq200a().fwk915NsDeposito().set(fwk015().regFwk015Pghq200a().fwk015NsDeposito());
        fwk915().regFwk915Pghq200a().fwk915CPedInfOpps().set(fwk015().regFwk015Pghq200a().fwk015CPedInfOpps());
        fwk915().regFwk915Pghq200a().fwk915ZInicMov().set(fwk015().regFwk015Pghq200a().fwk015ZInicMov());
        fwk915().regFwk915Pghq200a().fwk915ZFimMov().set(fwk015().regFwk015Pghq200a().fwk015ZFimMov());
        fwk915().regFwk915Pghq200a().fwk915TsPedido().set(fwk015().regFwk015Pghq200a().fwk015TsPedido());
        fwk915().regFwk915Pghq200a().fwk915ZPedido().set(fwk015().regFwk015Pghq200a().fwk015ZPedido());
        fwk915().regFwk915Pghq200a().fwk915CEstPedHist().set(fwk015().regFwk015Pghq200a().fwk015CEstPedHist());
        fwk915().regFwk915Pghq200a().fwk915CTipoRpte().set(fwk015().regFwk015Pghq200a().fwk015CTipoRpte());
        fwk915().regFwk915Pghq200a().fwk915NmFichOutpRtno().set(fwk015().regFwk015Pghq200a().fwk015NmFichOutpRtno());
        fwk915().regFwk915Pghq200a().fwk915AAplDest().set(fwk015().regFwk015Pghq200a().fwk015AAplDest());
        fwk915().regFwk915Pghq200a().fwk915CFrmtInf().set(fwk015().regFwk015Pghq200a().fwk015CFrmtInf());
        fwk915().regFwk915Pghq200a().fwk915CCanlTrmzInf().set(fwk015().regFwk015Pghq200a().fwk015CCanlTrmzInf());
        fwk915().regFwk915Pghq200a().fwk915CEndcFtpDest().set(fwk015().regFwk015Pghq200a().fwk015CEndcFtpDest());
        fwk915().regFwk915Pghq200a().fwk915ZCluzPed().set(fwk015().regFwk015Pghq200a().fwk015ZCluzPed());
        fwk915().regFwk915Pghq200a().fwk915QDiaDpnzInf().set(fwk015().regFwk015Pghq200a().fwk015QDiaDpnzInf());
        fwk915().regFwk915Pghq200a().fwk915MParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMax());
        fwk915().regFwk915Pghq200a().fwk915MParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMin());
        fwk915().regFwk915Pghq200a().fwk915CParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMax());
        fwk915().regFwk915Pghq200a().fwk915CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwk915().regFwk915Pghq200a().fwk915CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwk915().regFwk915Pghq200a().fwk915XMtvoDvlzPed().set(fwk015().regFwk015Pghq200a().fwk015XMtvoDvlzPed());
        fwk915().regFwk915Pghq200a().fwk915ZEliminacao().set(fwk015().regFwk015Pghq200a().fwk015ZEliminacao());
        fwk915().regFwk915Pghq200a().fwk915CUsidCrix().set(fwk015().regFwk015Pghq200a().fwk015CUsidCrix());
        fwk915().regFwk915Pghq200a().fwk915CPaisIsoaOeOpx().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaOeOpx());
        fwk915().regFwk915Pghq200a().fwk915CMnemEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015CMnemEgcOpex());
        fwk915().regFwk915Pghq200a().fwk915COeEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015COeEgcOpex());
        fwk915().regFwk915Pghq200a().fwk915QDdbtPed().set(fwk015().regFwk015Pghq200a().fwk015QDdbtPed());
        fwk915().regFwk915Pghq200a().fwk915TsActzUlt().set(fwk015().regFwk015Pghq200a().fwk015TsActzUlt());
        fwk915().regFwk915Pghq200a().fwk915CUsidActzUlt().set(fwk015().regFwk015Pghq200a().fwk015CUsidActzUlt());
        fwk915().write(fwk915().regFwk915Pghq200a()) ;
        if (fwk915().getStatusOk()) {
            contRegEscrtFwk915.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK915 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk915().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000EscreverFwk815() {
        log(TraceLevel.Debug, "A32000-ESCREVER-FWK815");
        fwk815().regFwk815Pghq200a().initialize() ;
        /**
         * PRC19 - INI
         * MOVE REG-FWK015          TO REG-FWK815
         */
        fwk815().regFwk815Pghq200a().fwk815CPaisIsoaCont().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaCont());
        fwk815().regFwk815Pghq200a().fwk815CBancCont().set(fwk015().regFwk015Pghq200a().fwk015CBancCont());
        fwk815().regFwk815Pghq200a().fwk815COeEgcCont().set(fwk015().regFwk015Pghq200a().fwk015COeEgcCont());
        fwk815().regFwk815Pghq200a().fwk815NsRdclCont().set(fwk015().regFwk015Pghq200a().fwk015NsRdclCont());
        fwk815().regFwk815Pghq200a().fwk815VChkdCont().set(fwk015().regFwk015Pghq200a().fwk015VChkdCont());
        fwk815().regFwk815Pghq200a().fwk815CTipoCont().set(fwk015().regFwk015Pghq200a().fwk015CTipoCont());
        fwk815().regFwk815Pghq200a().fwk815CMoedIsoScta().set(fwk015().regFwk015Pghq200a().fwk015CMoedIsoScta());
        fwk815().regFwk815Pghq200a().fwk815NsDeposito().set(fwk015().regFwk015Pghq200a().fwk015NsDeposito());
        fwk815().regFwk815Pghq200a().fwk815CPedInfOpps().set(fwk015().regFwk015Pghq200a().fwk015CPedInfOpps());
        fwk815().regFwk815Pghq200a().fwk815ZInicMov().set(fwk015().regFwk015Pghq200a().fwk015ZInicMov());
        fwk815().regFwk815Pghq200a().fwk815ZFimMov().set(fwk015().regFwk015Pghq200a().fwk015ZFimMov());
        fwk815().regFwk815Pghq200a().fwk815TsPedido().set(fwk015().regFwk015Pghq200a().fwk015TsPedido());
        fwk815().regFwk815Pghq200a().fwk815ZPedido().set(fwk015().regFwk015Pghq200a().fwk015ZPedido());
        fwk815().regFwk815Pghq200a().fwk815CEstPedHist().set(fwk015().regFwk015Pghq200a().fwk015CEstPedHist());
        fwk815().regFwk815Pghq200a().fwk815CTipoRpte().set(fwk015().regFwk015Pghq200a().fwk015CTipoRpte());
        fwk815().regFwk815Pghq200a().fwk815NmFichOutpRtno().set(fwk015().regFwk015Pghq200a().fwk015NmFichOutpRtno());
        fwk815().regFwk815Pghq200a().fwk815AAplDest().set(fwk015().regFwk015Pghq200a().fwk015AAplDest());
        fwk815().regFwk815Pghq200a().fwk815CFrmtInf().set(fwk015().regFwk015Pghq200a().fwk015CFrmtInf());
        fwk815().regFwk815Pghq200a().fwk815CCanlTrmzInf().set(fwk015().regFwk015Pghq200a().fwk015CCanlTrmzInf());
        fwk815().regFwk815Pghq200a().fwk815CEndcFtpDest().set(fwk015().regFwk015Pghq200a().fwk015CEndcFtpDest());
        fwk815().regFwk815Pghq200a().fwk815ZCluzPed().set(fwk015().regFwk015Pghq200a().fwk015ZCluzPed());
        fwk815().regFwk815Pghq200a().fwk815QDiaDpnzInf().set(fwk015().regFwk015Pghq200a().fwk015QDiaDpnzInf());
        fwk815().regFwk815Pghq200a().fwk815MParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMax());
        fwk815().regFwk815Pghq200a().fwk815MParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMin());
        fwk815().regFwk815Pghq200a().fwk815CParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMax());
        fwk815().regFwk815Pghq200a().fwk815CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwk815().regFwk815Pghq200a().fwk815CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwk815().regFwk815Pghq200a().fwk815XMtvoDvlzPed().set(fwk015().regFwk015Pghq200a().fwk015XMtvoDvlzPed());
        fwk815().regFwk815Pghq200a().fwk815ZEliminacao().set(fwk015().regFwk015Pghq200a().fwk015ZEliminacao());
        fwk815().regFwk815Pghq200a().fwk815CUsidCrix().set(fwk015().regFwk015Pghq200a().fwk015CUsidCrix());
        fwk815().regFwk815Pghq200a().fwk815CPaisIsoaOeOpx().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaOeOpx());
        fwk815().regFwk815Pghq200a().fwk815CMnemEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015CMnemEgcOpex());
        fwk815().regFwk815Pghq200a().fwk815COeEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015COeEgcOpex());
        fwk815().regFwk815Pghq200a().fwk815QDdbtPed().set(fwk015().regFwk015Pghq200a().fwk015QDdbtPed());
        fwk815().regFwk815Pghq200a().fwk815TsActzUlt().set(fwk015().regFwk015Pghq200a().fwk015TsActzUlt());
        fwk815().regFwk815Pghq200a().fwk815CUsidActzUlt().set(fwk015().regFwk015Pghq200a().fwk015CUsidActzUlt());
        fwk815().write(fwk815().regFwk815Pghq200a()) ;
        if (fwk815().getStatusOk()) {
            contRegEscrtFwk815.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK815 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk815().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000TratarDatasPedidos() {
        log(TraceLevel.Debug, "A33000-TRATAR-DATAS-PEDIDOS");
        wSqlcode.initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        haMais.setTrue() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(fwk015().regFwk015Pghq200a().fwk015CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(fwk015().regFwk015Pghq200a().fwk015COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(fwk015().regFwk015Pghq200a().fwk015NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(fwk015().regFwk015Pghq200a().fwk015VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(fwk015().regFwk015Pghq200a().fwk015CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(fwk015().regFwk015Pghq200a().fwk015CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(fwk015().regFwk015Pghq200a().fwk015NsDeposito());
        hv01001Contiphst().contiphst().cTipoInfHist().set("P");
        a33100OpenCursorC1() ;
        if (progOk.isTrue()) {
            a33200FetchCursorC1() ;
        }
        if (progOk.isTrue()) {
            wsTotDesd.set(0);
            while (!naoHaMais.isTrue() && getPersistenceCode() == PersistenceCode.NORMAL) {
                a33300DesdobraPedido() ;
            }
        }
        if (progOk.isTrue()) {
            a33400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33100OpenCursorC1() {
        log(TraceLevel.Debug, "A33100-OPEN-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (OPEN) cursor C1
         */
        hv01001Contiphst().openPghq200a1727() ;
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - CURSOR C1   - OPEN - ");
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33200FetchCursorC1() {
        log(TraceLevel.Debug, "A33200-FETCH-CURSOR-C1");
        wSqlcode.initialize() ;
        /**
         * Migration Note:
         * call to extracted method to access (FETCH) cursor C1
         */
        hv01001Contiphst().fetchPghq200a1755() ;
        wSqlcode.set(hv01001Contiphst().getPersistenceCode());
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NOTFND) {
            naoHaMais.setTrue() ;
        }
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NOTFND && 
            hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FETCH C1- VGH01001 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "SQLCODE-", wSqlcode);
            a33400CloseCursorC1() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33300DesdobraPedido() {
        log(TraceLevel.Debug, "A33300-DESDOBRA-PEDIDO");
        wsDataInic().set(fwk015().regFwk015Pghq200a().fwk015ZInicMov());
        wsDataFim().set(fwk015().regFwk015Pghq200a().fwk015ZFimMov());
        /**
         * *GH1099--> INICIO
         * EVALUATE TRUE
         * WHEN VGH01001-NM-RECURSO  = 'VGH00201'
         * IF (W-ANO-INIC >= VGH01001-ZA-INICIO
         * AND
         * W-ANO-FIM <= VGH01001-ZA-FIM)
         * OR
         * W-ANO-FIM >= VGH01001-ZA-INICIO
         * ADD  1             TO WS-TOT-DESD
         * PERFORM A33410-ESCREVER-FWK215
         * END-IF
         * WHEN VGH01001-NM-RECURSO  = 'VGH02301'
         * IF (VGH01001-ZA-INICIO >= W-ANO-INIC
         * VGH01001-ZA-FIM <= W-ANO-FIM)
         * ADD 1                 TO WS-TOT-DESD
         * PERFORM A33427-ESCREVER-FWK007
         * WHEN VGH01001-NM-RECURSO  = 'VGH02401'
         * PERFORM A33426-ESCREVER-FWK006
         * WHEN VGH01001-NM-RECURSO  = 'VGH02501'
         * PERFORM A33425-ESCREVER-FWK005
         * WHEN VGH01001-NM-RECURSO  = 'VGH02601'
         * PERFORM A33424-ESCREVER-FWK004
         * WHEN VGH01001-NM-RECURSO  = 'VGH02701'
         * PERFORM A33429-ESCREVER-FWK009
         * WHEN VGH01001-NM-RECURSO  = 'VGH02801'
         * PERFORM A33428-ESCREVER-FWK008
         * WHEN VGH01001-NM-RECURSO  = 'GHSA2003'
         * PERFORM A33423-ESCREVER-FWK003
         * WHEN VGH01001-NM-RECURSO  = 'GHSA2002'
         * PERFORM A33422-ESCREVER-FWK002
         * WHEN VGH01001-NM-RECURSO  = 'GHSA2001'
         * PERFORM A33421-ESCREVER-FWK001
         * WHEN VGH01001-NM-RECURSO  = 'GHSA2000'
         * PERFORM A33420-ESCREVER-FWK000
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1999'
         * PERFORM A33499-ESCREVER-FWK999
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1998'
         * PERFORM A33498-ESCREVER-FWK998
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1997'
         * PERFORM A33497-ESCREVER-FWK997
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1996'
         * PERFORM A33496-ESCREVER-FWK996
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1995'
         * PERFORM A33495-ESCREVER-FWK995
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1994'
         * PERFORM A33494-ESCREVER-FWK994
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1993'
         * PERFORM A33493-ESCREVER-FWK993
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1992'
         * PERFORM A33492-ESCREVER-FWK992
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1991'
         * PERFORM A33491-ESCREVER-FWK991
         * WHEN VGH01001-NM-RECURSO  = 'GHSA1990'
         * PERFORM A33490-ESCREVER-FWK990
         * WHEN OTHER
         * IF (W-ANO-INIC <= VGH01001-ZA-FIM
         * W-ANO-FIM  >= VGH01001-ZA-INICIO)
         * VGH01001-ZA-FIM <= W-ANO-FIM
         * PERFORM A33420-ESCREVER-FWK200
         * END-EVALUATE
         */
        switch (hv01001Contiphst().contiphst().nmRecurso().get()) {
            case "VGH00201":
                if ((wsDataInic().wAnoInic().isGreaterOrEqual(hv01001Contiphst().contiphst().zaInicio()) && 
                    wsDataFim().wAnoFim().isLessOrEqual(hv01001Contiphst().contiphst().zaFim())) || 
                    wsDataFim().wAnoFim().isGreaterOrEqual(hv01001Contiphst().contiphst().zaInicio())) {
                    wsTotDesd.add(1);
                    wsNmRecurso.set(hv01001Contiphst().contiphst().nmRecurso());
                    a33419EscreverFwkb15() ;
                }
                break;
            case "GHSA9999":
                if (wsDataInic().wAnoInic().isLessOrEqual(hv01001Contiphst().contiphst().zaFim()) && 
                    wsDataFim().wAnoFim().isGreaterOrEqual(hv01001Contiphst().contiphst().zaInicio())) {
                    wsTotDesd.add(1);
                    wsNmRecurso.set(hv01001Contiphst().contiphst().nmRecurso());
                    a33419EscreverFwkb15() ;
                }
                break;
            default :
                if (hv01001Contiphst().contiphst().zaInicio().isGreaterOrEqual(wsDataInic().wAnoInic()) && 
                    hv01001Contiphst().contiphst().zaFim().isLessOrEqual(wsDataFim().wAnoFim())) {
                    wsTotDesd.add(1);
                    wsNmRecurso.set(hv01001Contiphst().contiphst().nmRecurso());
                    a33419EscreverFwkb15() ;
                }
                break;
        }
        /**
         * *GH1099--> FIM
         */
        if (progOk.isTrue()) {
            a33200FetchCursorC1() ;
        }
    }
    
    /**
     * 
     * *GH1099--> INICIO
     * 
     */
    protected void a33419EscreverFwkb15() {
        log(TraceLevel.Debug, "A33419-ESCREVER-FWKB15");
        log(TraceLevel.Trace, "WS-TOT-DESD:", wsTotDesd);
        fwkb15().regFwkb15().initialize() ;
        /**
         * PRC19 - INI
         * MOVE REG-FWK015          TO REG-FWKB15
         */
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CPaisIsoaCont().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaCont());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CBancCont().set(fwk015().regFwk015Pghq200a().fwk015CBancCont());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15COeEgcCont().set(fwk015().regFwk015Pghq200a().fwk015COeEgcCont());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15NsRdclCont().set(fwk015().regFwk015Pghq200a().fwk015NsRdclCont());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15VChkdCont().set(fwk015().regFwk015Pghq200a().fwk015VChkdCont());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CTipoCont().set(fwk015().regFwk015Pghq200a().fwk015CTipoCont());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CMoedIsoScta().set(fwk015().regFwk015Pghq200a().fwk015CMoedIsoScta());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15NsDeposito().set(fwk015().regFwk015Pghq200a().fwk015NsDeposito());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CPedInfOpps().set(fwk015().regFwk015Pghq200a().fwk015CPedInfOpps());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15ZInicMov().set(fwk015().regFwk015Pghq200a().fwk015ZInicMov());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15ZFimMov().set(fwk015().regFwk015Pghq200a().fwk015ZFimMov());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15TsPedido().set(fwk015().regFwk015Pghq200a().fwk015TsPedido());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15ZPedido().set(fwk015().regFwk015Pghq200a().fwk015ZPedido());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CEstPedHist().set(fwk015().regFwk015Pghq200a().fwk015CEstPedHist());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CTipoRpte().set(fwk015().regFwk015Pghq200a().fwk015CTipoRpte());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15NmFichOutpRtno().set(fwk015().regFwk015Pghq200a().fwk015NmFichOutpRtno());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15AAplDest().set(fwk015().regFwk015Pghq200a().fwk015AAplDest());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CFrmtInf().set(fwk015().regFwk015Pghq200a().fwk015CFrmtInf());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CCanlTrmzInf().set(fwk015().regFwk015Pghq200a().fwk015CCanlTrmzInf());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CEndcFtpDest().set(fwk015().regFwk015Pghq200a().fwk015CEndcFtpDest());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15ZCluzPed().set(fwk015().regFwk015Pghq200a().fwk015ZCluzPed());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15QDiaDpnzInf().set(fwk015().regFwk015Pghq200a().fwk015QDiaDpnzInf());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15MParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMax());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15MParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMin());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMax());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15XMtvoDvlzPed().set(fwk015().regFwk015Pghq200a().fwk015XMtvoDvlzPed());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15ZEliminacao().set(fwk015().regFwk015Pghq200a().fwk015ZEliminacao());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CUsidCrix().set(fwk015().regFwk015Pghq200a().fwk015CUsidCrix());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CPaisIsoaOeOpx().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaOeOpx());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CMnemEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015CMnemEgcOpex());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15COeEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015COeEgcOpex());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15QDdbtPed().set(fwk015().regFwk015Pghq200a().fwk015QDdbtPed());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15TsActzUlt().set(fwk015().regFwk015Pghq200a().fwk015TsActzUlt());
        fwkb15().regFwkb15().detalheFwkb15().fwkb15CUsidActzUlt().set(fwk015().regFwk015Pghq200a().fwk015CUsidActzUlt());
        /**
         * PRC19 - FIM
         */
        fwkb15().regFwkb15().fwkb15NmRecurso().set(wsNmRecurso);
        fwkb15().write(fwkb15().regFwkb15()) ;
        if (fwkb15().getStatusOk()) {
            contRegEscrtFwkb15.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWKB15 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwkb15().getStatus());
        }
    }
    
    /**
     * 
     * *A33410-ESCREVER-FWK215.
     * IF SW-DEBUG-ON
     * DISPLAY 'A33410-ESCREVER-FWK215'
     * END-IF
     * DISPLAY 'WS-TOT-DESD:' WS-TOT-DESD
     * INITIALIZE REG-FWK215
     * MOVE REG-FWK015       TO REG-FWK215
     * WRITE REG-FWK215
     * IF FWK215-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK215
     * ELSE
     * MOVE +16             TO RETURN-CODE
     * PROG-STATUS
     * MOVE 'PGHQ200A - FWK215 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK215     TO IMP-STATUS
     * *A33427-ESCREVER-FWK007.
     * DISPLAY 'A33427-ESCREVER-FWK007'
     * INITIALIZE REG-FWK007
     * MOVE REG-FWK015       TO REG-FWK007
     * WRITE REG-FWK007
     * IF FWK007-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK007
     * MOVE 'PGHQ200A - FWK007 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK007     TO IMP-STATUS
     * *A33428-ESCREVER-FWK008.
     * DISPLAY 'A33428-ESCREVER-FWK008'
     * INITIALIZE REG-FWK008
     * MOVE REG-FWK015       TO REG-FWK008
     * WRITE REG-FWK008
     * IF FWK008-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK008
     * MOVE 'PGHQ200A - FWK008 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK008     TO IMP-STATUS
     * *A33426-ESCREVER-FWK006.
     * DISPLAY 'A33426-ESCREVER-FWK006'
     * INITIALIZE REG-FWK006
     * MOVE REG-FWK015       TO REG-FWK006
     * WRITE REG-FWK006
     * IF FWK006-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK006
     * MOVE 'PGHQ200A - FWK006 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK006     TO IMP-STATUS
     * *A33425-ESCREVER-FWK005.
     * DISPLAY 'A33426-ESCREVER-FWK005'
     * INITIALIZE REG-FWK005
     * MOVE REG-FWK015       TO REG-FWK005
     * WRITE REG-FWK005
     * IF FWK005-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK005
     * MOVE 'PGHQ200A - FWK005 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK005     TO IMP-STATUS
     * *A33424-ESCREVER-FWK004.
     * DISPLAY 'A33426-ESCREVER-FWK004'
     * INITIALIZE REG-FWK004
     * MOVE REG-FWK015       TO REG-FWK004
     * WRITE REG-FWK004
     * IF FWK004-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK004
     * MOVE 'PGHQ200A - FWK004 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK004     TO IMP-STATUS
     * *A33429-ESCREVER-FWK009.
     * DISPLAY 'A33429-ESCREVER-FWK009'
     * INITIALIZE REG-FWK009
     * MOVE REG-FWK015       TO REG-FWK009
     * WRITE REG-FWK009
     * IF FWK009-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK009
     * MOVE 'PGHQ200A - FWK009 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK009     TO IMP-STATUS
     * *A33422-ESCREVER-FWK002.
     * DISPLAY 'A33422-ESCREVER-FWK002'
     * INITIALIZE REG-FWK002
     * MOVE REG-FWK015       TO REG-FWK002
     * WRITE REG-FWK002
     * IF FWK002-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK002
     * MOVE 'PGHQ200A - FWK002 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK002     TO IMP-STATUS
     * *A33423-ESCREVER-FWK003.
     * DISPLAY 'A33423-ESCREVER-FWK003'
     * INITIALIZE REG-FWK003
     * MOVE REG-FWK015       TO REG-FWK003
     * WRITE REG-FWK003
     * IF FWK003-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK003
     * MOVE 'PGHQ200A - FWK003 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK003     TO IMP-STATUS
     * *A33421-ESCREVER-FWK001.
     * DISPLAY 'A33421-ESCREVER-FWK001'
     * INITIALIZE REG-FWK001
     * MOVE REG-FWK015       TO REG-FWK001
     * WRITE REG-FWK001
     * IF FWK001-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK001
     * MOVE 'PGHQ200A - FWK001 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK001     TO IMP-STATUS
     * *A33420-ESCREVER-FWK000.
     * DISPLAY 'A33420-ESCREVER-FWK000'
     * INITIALIZE REG-FWK000
     * MOVE REG-FWK015       TO REG-FWK000
     * WRITE REG-FWK000
     * IF FWK000-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK000
     * MOVE 'PGHQ200A - FWK000 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK000     TO IMP-STATUS
     * *A33499-ESCREVER-FWK999.
     * DISPLAY 'A33499-ESCREVER-FWK999'
     * INITIALIZE REG-FWK999
     * MOVE REG-FWK015       TO REG-FWK999
     * WRITE REG-FWK999
     * IF FWK999-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK999
     * MOVE 'PGHQ200A - FWK999 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK999     TO IMP-STATUS
     * *A33498-ESCREVER-FWK998.
     * DISPLAY 'A33498-ESCREVER-FWK998'
     * INITIALIZE REG-FWK998
     * MOVE REG-FWK015       TO REG-FWK998
     * WRITE REG-FWK998
     * IF FWK998-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK998
     * MOVE 'PGHQ200A - FWK998 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK998     TO IMP-STATUS
     * *A33497-ESCREVER-FWK997.
     * DISPLAY 'A33497-ESCREVER-FWK997'
     * INITIALIZE REG-FWK997
     * MOVE REG-FWK015       TO REG-FWK997
     * WRITE REG-FWK997
     * IF FWK997-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK997
     * MOVE 'PGHQ200A - FWK997 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK997     TO IMP-STATUS
     * *A33496-ESCREVER-FWK996.
     * DISPLAY 'A33496-ESCREVER-FWK996'
     * INITIALIZE REG-FWK996
     * MOVE REG-FWK015       TO REG-FWK996
     * WRITE REG-FWK996
     * IF FWK996-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK996
     * MOVE 'PGHQ200A - FWK996 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK996     TO IMP-STATUS
     * *A33495-ESCREVER-FWK995.
     * DISPLAY 'A33496-ESCREVER-FWK995'
     * INITIALIZE REG-FWK995
     * MOVE REG-FWK015       TO REG-FWK995
     * WRITE REG-FWK995
     * IF FWK995-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK995
     * MOVE 'PGHQ200A - FWK995 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK995     TO IMP-STATUS
     * *A33494-ESCREVER-FWK994.
     * DISPLAY 'A33496-ESCREVER-FWK994'
     * INITIALIZE REG-FWK994
     * MOVE REG-FWK015       TO REG-FWK994
     * WRITE REG-FWK994
     * IF FWK994-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK994
     * MOVE 'PGHQ200A - FWK994 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK994     TO IMP-STATUS
     * *A33493-ESCREVER-FWK993.
     * DISPLAY 'A33496-ESCREVER-FWK993'
     * INITIALIZE REG-FWK993
     * MOVE REG-FWK015       TO REG-FWK993
     * WRITE REG-FWK993
     * IF FWK993-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK993
     * MOVE 'PGHQ200A - FWK993 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK993     TO IMP-STATUS
     * *A33492-ESCREVER-FWK992.
     * DISPLAY 'A33496-ESCREVER-FWK992'
     * INITIALIZE REG-FWK992
     * MOVE REG-FWK015       TO REG-FWK992
     * WRITE REG-FWK992
     * IF FWK992-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK992
     * MOVE 'PGHQ200A - FWK992 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK992     TO IMP-STATUS
     * *A33491-ESCREVER-FWK991.
     * DISPLAY 'A33496-ESCREVER-FWK991'
     * INITIALIZE REG-FWK991
     * MOVE REG-FWK015       TO REG-FWK991
     * WRITE REG-FWK991
     * IF FWK991-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK991
     * MOVE 'PGHQ200A - FWK991 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK991     TO IMP-STATUS
     * *A33490-ESCREVER-FWK990.
     * DISPLAY 'A33490-ESCREVER-FWK990'
     * INITIALIZE REG-FWK990
     * MOVE REG-FWK015       TO REG-FWK990
     * WRITE REG-FWK990
     * IF FWK990-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK990
     * MOVE 'PGHQ200A - FWK990 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK990     TO IMP-STATUS
     * *A33420-ESCREVER-FWK200.
     * DISPLAY 'A33420-ESCREVER-FWK200'
     * INITIALIZE REG-FWK200
     * MOVE REG-FWK015       TO REG-FWK200
     * WRITE REG-FWK200
     * IF FWK200-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK200
     * MOVE 'PGHQ200A - FWK200 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK200     TO IMP-STATUS
     * *GH1099--> FIM
     * 
     */
    protected void a33400CloseCursorC1() {
        log(TraceLevel.Debug, "A33400-CLOSE-CURSOR-C1");
        /**
         * Migration Note:
         * call to extracted method to access (CLOSE) cursor C1
         */
        hv01001Contiphst().closePghq200a2593() ;
        if (hv01001Contiphst().getPersistenceCode() != PersistenceCode.NORMAL) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - CURSOR C1 -CLOSE - ");
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreverFgh015() {
        log(TraceLevel.Debug, "A34000-ESCREVER-FGH015");
        fgh015().regFgh015().initialize() ;
        fgh015().setRecord(fwk015().getRecord()) ;
        if (haProtocolo.isTrue()) {
            if (wsCProtocolo.isEqual(11)) {
                fgh015().regFgh015().fgh015ZInicMov().set(wTimestamp().wDataTimestamp());
                fgh015().regFgh015().fgh015ZFimMov().set(wTimestamp().wDataTimestamp());
                fgh015().regFgh015().fgh015ZPedido().set(wTimestamp().wDataTimestamp());
                wsTsPedido.set(fwk015().regFwk015Pghq200a().fwk015TsPedido());
                wsTsPedidoMask().wAnoPed().set(wTimestamp().wDataTimestamp().wAnoAa());
                wsTsPedidoMask().wMesPed().set(wTimestamp().wDataTimestamp().wMesMm());
                wsTsPedidoMask().wDiaPed().set(wTimestamp().wDataTimestamp().wDiaDd());
                fgh015().regFgh015().fgh015TsPedido().set(wsTsPedido);
                fgh015().regFgh015().fgh015CUsidCrix().set(bghw0300().wsNmPrograma());
                fgh015().write(fgh015().regFgh015()) ;
                if (fgh015().getStatusOk()) {
                    contRegEscrtFgh015.add(1);
                    naoHaProtocolo.setTrue() ;
                } else {
                    setReturnCode(16) ;
                    progStatus.set(16);
                    tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FGH015 - WRITE -1- ");
                    tabelaImpressao().linha09().impStatus().set(fgh015().getStatus());
                }
            }
        } else {
            if (fwk015().regFwk015Pghq200a().fwk015CEstPedHist().isEqual("A")) {
                fgh015().regFgh015().fgh015CEstPedHist().set("E");
                if (wsTotDesd.isGreater(0)) {
                    fgh015().regFgh015().fgh015QDdbtPed().set(wsTotDesd);
                } else {
                    fgh015().regFgh015().fgh015ZCluzPed().set(wTimestamp().wDataTimestamp());
                }
            } else if (fwk015().regFwk015Pghq200a().fwk015CEstPedHist().isEqual("E")) {
                fgh015().regFgh015().fgh015CEstPedHist().set("R");
                fgh015().regFgh015().fgh015XMtvoDvlzPed().set("NAO HA MOVIMENTOS PARA O CRITERIO");
                fgh015().regFgh015().fgh015ZCluzPed().set(wTimestamp().wDataTimestamp());
                fgh015().regFgh015().fgh015ZEliminacao().set(wTimestamp().wDataTimestamp());
            }
            fgh015().regFgh015().fgh015TsActzUlt().set(wTimestamp());
            fgh015().regFgh015().fgh015CUsidActzUlt().set("PGHQ200A");
            fgh015().write(fgh015().regFgh015()) ;
            if (fgh015().getStatusOk()) {
                contRegEscrtFgh015.add(1);
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FGH015 - WRITE -2- ");
                tabelaImpressao().linha09().impStatus().set(fgh015().getStatus());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34100VerificaProtocolo() {
        log(TraceLevel.Debug, "A34100-VERIFICA-PROTOCOLO");
        bghw0018().tbPedProt().itemPedProt().resetIndex() ;
        while (bghw0018().tbPedProt().itemPedProt().index().isLessOrEqual(2)) {
            if (fwk015().regFwk015Pghq200a().fwk015CPedInfOpps().isEqual(bghw0018().tbPedProt().itemPedProt().getCurrent().tabCPedido())) {
                haProtocolo.setTrue() ;
                wsCProtocolo.set(bghw0018().tbPedProt().itemPedProt().getCurrent().tabCProtocolo());
                a34000EscreverFgh015() ;
                break;
            }
            bghw0018().tbPedProt().itemPedProt().incIndex() ;
        }
        if (bghw0018().tbPedProt().itemPedProt().atEnd()) {
            naoHaProtocolo.setTrue() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35000EscreverFwk115() {
        log(TraceLevel.Debug, "A35000-ESCREVER-FWK115");
        fwk115().regFwk115Pghq200a().initialize() ;
        /**
         * PRC19 - INI
         * MOVE REG-FWK015          TO REG-FWK115
         */
        fwk115().regFwk115Pghq200a().fwk115CPaisIsoaCont().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaCont());
        fwk115().regFwk115Pghq200a().fwk115CBancCont().set(fwk015().regFwk015Pghq200a().fwk015CBancCont());
        fwk115().regFwk115Pghq200a().fwk115COeEgcCont().set(fwk015().regFwk015Pghq200a().fwk015COeEgcCont());
        fwk115().regFwk115Pghq200a().fwk115NsRdclCont().set(fwk015().regFwk015Pghq200a().fwk015NsRdclCont());
        fwk115().regFwk115Pghq200a().fwk115VChkdCont().set(fwk015().regFwk015Pghq200a().fwk015VChkdCont());
        fwk115().regFwk115Pghq200a().fwk115CTipoCont().set(fwk015().regFwk015Pghq200a().fwk015CTipoCont());
        fwk115().regFwk115Pghq200a().fwk115CMoedIsoScta().set(fwk015().regFwk015Pghq200a().fwk015CMoedIsoScta());
        fwk115().regFwk115Pghq200a().fwk115NsDeposito().set(fwk015().regFwk015Pghq200a().fwk015NsDeposito());
        fwk115().regFwk115Pghq200a().fwk115CPedInfOpps().set(fwk015().regFwk015Pghq200a().fwk015CPedInfOpps());
        fwk115().regFwk115Pghq200a().fwk115ZInicMov().set(fwk015().regFwk015Pghq200a().fwk015ZInicMov());
        fwk115().regFwk115Pghq200a().fwk115ZFimMov().set(fwk015().regFwk015Pghq200a().fwk015ZFimMov());
        fwk115().regFwk115Pghq200a().fwk115TsPedido().set(fwk015().regFwk015Pghq200a().fwk015TsPedido());
        fwk115().regFwk115Pghq200a().fwk115ZPedido().set(fwk015().regFwk015Pghq200a().fwk015ZPedido());
        fwk115().regFwk115Pghq200a().fwk115CEstPedHist().set(fwk015().regFwk015Pghq200a().fwk015CEstPedHist());
        fwk115().regFwk115Pghq200a().fwk115CTipoRpte().set(fwk015().regFwk015Pghq200a().fwk015CTipoRpte());
        fwk115().regFwk115Pghq200a().fwk115NmFichOutpRtno().set(fwk015().regFwk015Pghq200a().fwk015NmFichOutpRtno());
        fwk115().regFwk115Pghq200a().fwk115AAplDest().set(fwk015().regFwk015Pghq200a().fwk015AAplDest());
        fwk115().regFwk115Pghq200a().fwk115CFrmtInf().set(fwk015().regFwk015Pghq200a().fwk015CFrmtInf());
        fwk115().regFwk115Pghq200a().fwk115CCanlTrmzInf().set(fwk015().regFwk015Pghq200a().fwk015CCanlTrmzInf());
        fwk115().regFwk115Pghq200a().fwk115CEndcFtpDest().set(fwk015().regFwk015Pghq200a().fwk015CEndcFtpDest());
        fwk115().regFwk115Pghq200a().fwk115ZCluzPed().set(fwk015().regFwk015Pghq200a().fwk015ZCluzPed());
        fwk115().regFwk115Pghq200a().fwk115QDiaDpnzInf().set(fwk015().regFwk015Pghq200a().fwk015QDiaDpnzInf());
        fwk115().regFwk115Pghq200a().fwk115MParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMax());
        fwk115().regFwk115Pghq200a().fwk115MParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015MParmPedHstMin());
        fwk115().regFwk115Pghq200a().fwk115CParmPedHstMax().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMax());
        fwk115().regFwk115Pghq200a().fwk115CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwk115().regFwk115Pghq200a().fwk115CParmPedHstMin().set(fwk015().regFwk015Pghq200a().fwk015CParmPedHstMin());
        fwk115().regFwk115Pghq200a().fwk115XMtvoDvlzPed().set(fwk015().regFwk015Pghq200a().fwk015XMtvoDvlzPed());
        fwk115().regFwk115Pghq200a().fwk115ZEliminacao().set(fwk015().regFwk015Pghq200a().fwk015ZEliminacao());
        fwk115().regFwk115Pghq200a().fwk115CUsidCrix().set(fwk015().regFwk015Pghq200a().fwk015CUsidCrix());
        fwk115().regFwk115Pghq200a().fwk115CPaisIsoaOeOpx().set(fwk015().regFwk015Pghq200a().fwk015CPaisIsoaOeOpx());
        fwk115().regFwk115Pghq200a().fwk115CMnemEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015CMnemEgcOpex());
        fwk115().regFwk115Pghq200a().fwk115COeEgcOpex().set(fwk015().regFwk015Pghq200a().fwk015COeEgcOpex());
        fwk115().regFwk115Pghq200a().fwk115QDdbtPed().set(fwk015().regFwk015Pghq200a().fwk015QDdbtPed());
        fwk115().regFwk115Pghq200a().fwk115TsActzUlt().set(fwk015().regFwk015Pghq200a().fwk015TsActzUlt());
        fwk115().regFwk115Pghq200a().fwk115CUsidActzUlt().set(fwk015().regFwk015Pghq200a().fwk015CUsidActzUlt());
        fwk115().write(fwk115().regFwk115Pghq200a()) ;
        if (fwk115().getStatusOk()) {
            contRegEscrtFwk115.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ200A - FWK115 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk115().getStatus());
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
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichRead().set("FWK015");
            tabelaImpressao().linha05().impRegLidosFwk015().set(contRegLidosFwk015);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FWK115");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk115);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            tabelaImpressao().linha06().impFichEsc().set("FGH015");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh015);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
            /**
             * *GH1099--> INICIO
             */
            if (contRegEscrtFwkb15.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWKB15");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwkb15);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            /**
             * IF CONT-REG-ESCRT-FWK215 > 0
             * MOVE 'FWK215'                TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK215   TO IMP-REG-ESCRT
             * SET Z TO 6
             * PERFORM A12000-ESCREVER-FGH300
             * END-IF
             * IF CONT-REG-ESCRT-FWK008 > 0
             * MOVE 'FWK008'               TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK008  TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK007 > 0
             * MOVE 'FWK007'               TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK007  TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK006 > 0
             * MOVE 'FWK006'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK006     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK005 > 0
             * MOVE 'FWK005'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK005     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK004 > 0
             * MOVE 'FWK004'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK004     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK009 > 0
             * MOVE 'FWK009'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK009     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK002 > 0
             * MOVE 'FWK002'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK002     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK003 > 0
             * MOVE 'FWK003'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK003     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK001 > 0
             * MOVE 'FWK001'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK001     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK000 > 0
             * MOVE 'FWK000'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK000     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK999 > 0
             * MOVE 'FWK999'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK999     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK998 > 0
             * MOVE 'FWK998'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK998     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK997 > 0
             * MOVE 'FWK997'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK997     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK996 > 0
             * MOVE 'FWK996'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK996     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK995 > 0
             * MOVE 'FWK995'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK995     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK994 > 0
             * MOVE 'FWK994'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK994     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK993 > 0
             * MOVE 'FWK993'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK993     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK992 > 0
             * MOVE 'FWK992'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK992     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK991 > 0
             * MOVE 'FWK991'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK991     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK990 > 0
             * MOVE 'FWK990'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK990     TO IMP-REG-ESCRT
             * IF CONT-REG-ESCRT-FWK200 > 0
             * MOVE 'FWK200'                  TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK200     TO IMP-REG-ESCRT
             * *GH1099--> FIM
             */
            if (contRegEscrtFwk815.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK815");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk815);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk915.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK915");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk915);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ200A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk015().close() ;
        fwk115().close() ;
        fwkb15().close() ;
        fwk815().close() ;
        fwk915().close() ;
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
            while (!fwk015().getStatusOk() && progOk.isTrue()) {
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
    public interface WsTsPedidoMask extends IDataMask {
        
        @Data(size=4)
        IInt wAnoPed() ;
        
        @Data(size=2)
        IInt wMesPed() ;
        
        @Data(size=2)
        IInt wDiaPed() ;
        
        @Data(size=2)
        IInt wHhPed() ;
        
        @Data(size=2)
        IInt wMmPed() ;
        
        @Data(size=2)
        IInt wSsPed() ;
        
        @Data(size=1)
        IInt wDdPed() ;
        
    }
    public interface WsDataInic extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoInic() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesInic() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaInic() ;
        
    }
    public interface WsDataFim extends IDataStruct {
        
        @Data(size=4)
        IInt wAnoFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wMesFim() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt wDiaFim() ;
        
    }
    public interface WsNmRecursoVgh01001 extends IDataStruct {
        
        @Data(size=4, value="GHSA")
        IString wsHist() ;
        
        @Data(size=4)
        IInt wsAno() ;
        
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
            
            @Data(size=8, value="PGHQ200A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ200A")
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
            IFormattedString impRegLidosFwk015() ;
            
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
