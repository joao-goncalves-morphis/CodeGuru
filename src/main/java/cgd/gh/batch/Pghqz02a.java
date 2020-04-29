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
import cgd.gh.structures.work.Bghr0021 ;
import cgd.gh.structures.work.Bghwz001 ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CARREGAMENTO DAS TABELAS:
 * - TGH00002
 * - TGH00028
 * - TGH00023
 * - TGH00024
 * - TGH00025
 * - TGH00026
 * - TGH00027
 * FICHEIROS     : FWK001, FWK002, FWK003, FWK004, FWK005,
 * FWK006, FWK007
 * 
 * @version 2.0
 * 
 */
public abstract class Pghqz02a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps02801Movhist8
     */
    @Data
    protected abstract Vwsdghps02801Movhist8 hv02801Movhist8() ;
    
    /**
     * @return instancia da classe Vwsdghps02301Movhist3
     */
    @Data
    protected abstract Vwsdghps02301Movhist3 hv02301Movhist3() ;
    
    /**
     * @return instancia da classe Vwsdghps02401Movhist4
     */
    @Data
    protected abstract Vwsdghps02401Movhist4 hv02401Movhist4() ;
    
    /**
     * @return instancia da classe Vwsdghps02501Movhist5
     */
    @Data
    protected abstract Vwsdghps02501Movhist5 hv02501Movhist5() ;
    
    /**
     * @return instancia da classe Vwsdghps02601Movhist6
     */
    @Data
    protected abstract Vwsdghps02601Movhist6 hv02601Movhist6() ;
    
    /**
     * @return instancia da classe Vwsdghps02701Movhist7
     */
    @Data
    protected abstract Vwsdghps02701Movhist7 hv02701Movhist7() ;
    
    
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
     * @return instancia da classe Fwk00103
     */
    @Handler(name="FWK001", record="statusFwk001")
    @Data
    protected abstract Fwk00103 fwk001() ;
    
    /**
     * @return instancia da classe Fwk00202
     */
    @Handler(name="FWK002", record="statusFwk002")
    @Data
    protected abstract Fwk00202 fwk002() ;
    
    /**
     * @return instancia da classe Fwk00302
     */
    @Handler(name="FWK003", record="statusFwk003")
    @Data
    protected abstract Fwk00302 fwk003() ;
    
    /**
     * @return instancia da classe Fwk004
     */
    @Handler(name="FWK004", record="statusFwk004")
    @Data
    protected abstract Fwk004 fwk004() ;
    
    /**
     * @return instancia da classe Fwk005
     */
    @Handler(name="FWK005", record="statusFwk005")
    @Data
    protected abstract Fwk005 fwk005() ;
    
    /**
     * @return instancia da classe Fwk006
     */
    @Handler(name="FWK006", record="statusFwk006")
    @Data
    protected abstract Fwk006 fwk006() ;
    
    /**
     * @return instancia da classe Fwk007
     */
    @Handler(name="FWK007", record="statusFwk007")
    @Data
    protected abstract Fwk007 fwk007() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghqz02a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghr0021
     */
    @Data
    protected abstract Bghr0021 bghr0021() ;
    
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
    @Condition("7")
    protected ICondition progNaoExiste ;
    @Data
    @Condition("8")
    protected ICondition progJaExiste ;
    
    
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
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk001 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk002 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk003 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk004 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk005 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk006 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk007 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh00201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh02801 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh02301 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh02401 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh02501 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh02601 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh02701 ;
    
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
        bghw0300().wsNmPrograma().set("PGHQZ02A");
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
        auxContRegLidos.set(0);
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
            a16000AbrirFicheiros() ;
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
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - OPEN - ");
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
            auxContRegLidos.set(fwk900().fwk900RegPghqz02a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghqz02a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - READ - ");
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
            fwk900().fwk900RegPghqz02a().initialize() ;
            fwk900().fwk900RegPghqz02a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghqz02a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - OPEN- ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirFicheiros() {
        log(TraceLevel.Debug, "A16000-ABRIR-FICHEIROS");
        fwk001().open() ;
        if (!fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK001 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
        fwk002().open() ;
        if (!fwk002().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK002 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk002().getStatus());
        }
        fwk003().open() ;
        if (!fwk003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK003 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
        }
        fwk004().open() ;
        if (!fwk004().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK004 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk004().getStatus());
        }
        fwk005().open() ;
        if (!fwk005().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK005 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk005().getStatus());
        }
        fwk006().open() ;
        if (!fwk006().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK006 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk006().getStatus());
        }
        fwk007().open() ;
        if (!fwk007().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK007 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk007().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17001LerFwk001() {
        log(TraceLevel.Debug, "A17001-LER-FWK001");
        fwk001().read(bghr0021().rgh00201()) ;
        if (fwk001().getStatusOk()) {
            contRegLidosFwk001.add(1);
        }
        if (!fwk001().getStatusOk() && !fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK001 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17002LerFwk002() {
        log(TraceLevel.Debug, "A17002-LER-FWK002");
        fwk002().read(bghr0021().rgh00201()) ;
        if (fwk002().getStatusOk()) {
            contRegLidosFwk002.add(1);
        }
        if (!fwk002().getStatusOk() && !fwk002().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK002 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk002().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17003LerFwk003() {
        log(TraceLevel.Debug, "A17003-LER-FWK003");
        fwk003().read(bghr0021().rgh00201()) ;
        if (fwk003().getStatusOk()) {
            contRegLidosFwk003.add(1);
        }
        if (!fwk003().getStatusOk() && !fwk003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK003 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17004LerFwk004() {
        log(TraceLevel.Debug, "A17004-LER-FWK004");
        fwk004().read(bghr0021().rgh00201()) ;
        if (fwk004().getStatusOk()) {
            contRegLidosFwk004.add(1);
        }
        if (!fwk004().getStatusOk() && !fwk004().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK004 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk004().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17005LerFwk005() {
        log(TraceLevel.Debug, "A17005-LER-FWK005");
        fwk005().read(bghr0021().rgh00201()) ;
        if (fwk005().getStatusOk()) {
            contRegLidosFwk005.add(1);
        }
        if (!fwk005().getStatusOk() && !fwk005().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK005 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk005().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17006LerFwk006() {
        log(TraceLevel.Debug, "A17006-LER-FWK006");
        fwk006().read(bghr0021().rgh00201()) ;
        if (fwk006().getStatusOk()) {
            contRegLidosFwk006.add(1);
        }
        if (!fwk006().getStatusOk() && !fwk006().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK006 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk006().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17007LerFwk007() {
        log(TraceLevel.Debug, "A17001-LER-FWK007");
        fwk007().read(bghr0021().rgh00201()) ;
        if (fwk007().getStatusOk()) {
            contRegLidosFwk007.add(1);
        }
        if (!fwk007().getStatusOk() && !fwk007().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK007 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk007().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30001ProcessarFwk001() {
        log(TraceLevel.Debug, "S30001-PROCESSAR-FWK001");
        if (progOk.isTrue()) {
            a30001EscreverHist002() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17001LerFwk001() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30002ProcessarFwk002() {
        log(TraceLevel.Debug, "S30002-PROCESSAR-FWK002");
        if (progOk.isTrue()) {
            a30002EscreverHist028() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17002LerFwk002() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30003ProcessarFwk003() {
        log(TraceLevel.Debug, "S30003-PROCESSAR-FWK003");
        if (progOk.isTrue()) {
            a30003EscreverHist023() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17003LerFwk003() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30004ProcessarFwk004() {
        log(TraceLevel.Debug, "S30004-PROCESSAR-FWK004");
        if (progOk.isTrue()) {
            a30004EscreverHist024() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17004LerFwk004() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30005ProcessarFwk005() {
        log(TraceLevel.Debug, "S30005-PROCESSAR-FWK005");
        if (progOk.isTrue()) {
            a30005EscreverHist025() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17005LerFwk005() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30006ProcessarFwk006() {
        log(TraceLevel.Debug, "S30006-PROCESSAR-FWK006");
        if (progOk.isTrue()) {
            a30006EscreverHist026() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17006LerFwk006() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30007ProcessarFwk007() {
        log(TraceLevel.Debug, "S30007-PROCESSAR-FWK007");
        if (progOk.isTrue()) {
            a30007EscreverHist027() ;
        }
        if (progOk.isTrue()) {
            a36000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17007LerFwk007() ;
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
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk001.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK001");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk001);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk002.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK002");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk002);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk003.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK003");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk003);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk004.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK004");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk004);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk005.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK005");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk005);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk006.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK006");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk006);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk007.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK007");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk007);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh00201.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH00201");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh00201);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh02801.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH02801");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh02801);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh02301.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH02301");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh02301);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh02401.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH02401");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh02401);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh02501.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH02501");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh02501);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh02601.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH02601");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh02601);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh02701.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH02701");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh02701);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (progOk.isTrue()) {
                commit() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHQZ02A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk001().close() ;
        fwk002().close() ;
        fwk003().close() ;
        fwk004().close() ;
        fwk005().close() ;
        fwk006().close() ;
        fwk007().close() ;
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
    protected void a30001EscreverHist002() {
        log(TraceLevel.Debug, "A30001-ESCREVER-HIST-002");
        hv00201Movhst().movhst().initialize() ;
        hv00201Movhst().movhst().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(bghr0021().rgh00201().fgh002NsMovimento());
        hv00201Movhst().movhst().zValMov().set(bghr0021().rgh00201().fgh002ZValMov());
        hv00201Movhst().movhst().zMovLocl().set(bghr0021().rgh00201().fgh002ZMovLocl());
        hv00201Movhst().movhst().iDbcr().set(bghr0021().rgh00201().fgh002IDbcr());
        hv00201Movhst().movhst().mMovimento().set(bghr0021().rgh00201().fgh002MMovimento());
        hv00201Movhst().movhst().iEstorno().set(bghr0021().rgh00201().fgh002IEstorno());
        hv00201Movhst().movhst().cMoedIsoOriMov().set(bghr0021().rgh00201().fgh002CMoedIsoOriMov());
        hv00201Movhst().movhst().mSldoCbloApos().set(bghr0021().rgh00201().fgh002MSldoCbloApos());
        hv00201Movhst().movhst().mSldoDpnlApos().set(bghr0021().rgh00201().fgh002MSldoDpnlApos());
        hv00201Movhst().movhst().mMovMoeOrigMov().set(bghr0021().rgh00201().fgh002MMovMoeOrigMov());
        hv00201Movhst().movhst().xRefMov().set(bghr0021().rgh00201().fgh002XRefMov());
        hv00201Movhst().movhst().nDocOpps().set(bghr0021().rgh00201().fgh002NDocOpps());
        hv00201Movhst().movhst().aAplOrig().set(bghr0021().rgh00201().fgh002AAplOrig());
        hv00201Movhst().movhst().iExisInfAdi().set(bghr0021().rgh00201().fgh002IExisInfAdi());
        hv00201Movhst().movhst().xChavAcsInfAdi().set(bghr0021().rgh00201().fgh002XChavAcsInfAdi());
        hv00201Movhst().movhst().tsActzUlt().set(bghr0021().rgh00201().fgh002TsActzUlt());
        hv00201Movhst().movhst().cUsidActzUlt().set(bghr0021().rgh00201().fgh002CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH00201_MOVHST
         */
        hv00201Movhst().insertPghqz02a1248() ;
        if (hv00201Movhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh00201.add(1);
        }
        if (hv00201Movhst().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv00201Movhst().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - VGH00201 - INSERT  - ");
            wSqlcode.set(hv00201Movhst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30002EscreverHist028() {
        log(TraceLevel.Debug, "A30002-ESCREVER-HIST-028");
        hv02801Movhist8().movhist8().initialize() ;
        hv02801Movhist8().movhist8().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv02801Movhist8().movhist8().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv02801Movhist8().movhist8().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv02801Movhist8().movhist8().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv02801Movhist8().movhist8().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv02801Movhist8().movhist8().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv02801Movhist8().movhist8().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv02801Movhist8().movhist8().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv02801Movhist8().movhist8().tsMovimento().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv02801Movhist8().movhist8().nsMovimento().set(bghr0021().rgh00201().fgh002NsMovimento());
        hv02801Movhist8().movhist8().zValMov().set(bghr0021().rgh00201().fgh002ZValMov());
        hv02801Movhist8().movhist8().zMovLocl().set(bghr0021().rgh00201().fgh002ZMovLocl());
        hv02801Movhist8().movhist8().iDbcr().set(bghr0021().rgh00201().fgh002IDbcr());
        hv02801Movhist8().movhist8().mMovimento().set(bghr0021().rgh00201().fgh002MMovimento());
        hv02801Movhist8().movhist8().iEstorno().set(bghr0021().rgh00201().fgh002IEstorno());
        hv02801Movhist8().movhist8().cMoedIsoOriMov().set(bghr0021().rgh00201().fgh002CMoedIsoOriMov());
        hv02801Movhist8().movhist8().mSldoCbloApos().set(bghr0021().rgh00201().fgh002MSldoCbloApos());
        hv02801Movhist8().movhist8().mSldoDpnlApos().set(bghr0021().rgh00201().fgh002MSldoDpnlApos());
        hv02801Movhist8().movhist8().mMovMoeOrigMov().set(bghr0021().rgh00201().fgh002MMovMoeOrigMov());
        hv02801Movhist8().movhist8().xRefMov().set(bghr0021().rgh00201().fgh002XRefMov());
        hv02801Movhist8().movhist8().nDocOpps().set(bghr0021().rgh00201().fgh002NDocOpps());
        hv02801Movhist8().movhist8().aAplOrig().set(bghr0021().rgh00201().fgh002AAplOrig());
        hv02801Movhist8().movhist8().iExisInfAdi().set(bghr0021().rgh00201().fgh002IExisInfAdi());
        hv02801Movhist8().movhist8().xChavAcsInfAdi().set(bghr0021().rgh00201().fgh002XChavAcsInfAdi());
        hv02801Movhist8().movhist8().tsActzUlt().set(bghr0021().rgh00201().fgh002TsActzUlt());
        hv02801Movhist8().movhist8().cUsidActzUlt().set(bghr0021().rgh00201().fgh002CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH02801_MOVHIST8
         */
        hv02801Movhist8().insertPghqz02a1365() ;
        if (hv02801Movhist8().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh02801.add(1);
        }
        if (hv02801Movhist8().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv02801Movhist8().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - VGH02801 - INSERT  - ");
            wSqlcode.set(hv02801Movhist8().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30003EscreverHist023() {
        log(TraceLevel.Debug, "A30003-ESCREVER-HIST-023");
        hv02301Movhist3().movhist3().initialize() ;
        hv02301Movhist3().movhist3().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv02301Movhist3().movhist3().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv02301Movhist3().movhist3().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv02301Movhist3().movhist3().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv02301Movhist3().movhist3().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv02301Movhist3().movhist3().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv02301Movhist3().movhist3().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv02301Movhist3().movhist3().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv02301Movhist3().movhist3().tsMovimento().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv02301Movhist3().movhist3().nsMovimento().set(bghr0021().rgh00201().fgh002NsMovimento());
        hv02301Movhist3().movhist3().zValMov().set(bghr0021().rgh00201().fgh002ZValMov());
        hv02301Movhist3().movhist3().zMovLocl().set(bghr0021().rgh00201().fgh002ZMovLocl());
        hv02301Movhist3().movhist3().iDbcr().set(bghr0021().rgh00201().fgh002IDbcr());
        hv02301Movhist3().movhist3().mMovimento().set(bghr0021().rgh00201().fgh002MMovimento());
        hv02301Movhist3().movhist3().iEstorno().set(bghr0021().rgh00201().fgh002IEstorno());
        hv02301Movhist3().movhist3().cMoedIsoOriMov().set(bghr0021().rgh00201().fgh002CMoedIsoOriMov());
        hv02301Movhist3().movhist3().mSldoCbloApos().set(bghr0021().rgh00201().fgh002MSldoCbloApos());
        hv02301Movhist3().movhist3().mSldoDpnlApos().set(bghr0021().rgh00201().fgh002MSldoDpnlApos());
        hv02301Movhist3().movhist3().mMovMoeOrigMov().set(bghr0021().rgh00201().fgh002MMovMoeOrigMov());
        hv02301Movhist3().movhist3().xRefMov().set(bghr0021().rgh00201().fgh002XRefMov());
        hv02301Movhist3().movhist3().nDocOpps().set(bghr0021().rgh00201().fgh002NDocOpps());
        hv02301Movhist3().movhist3().aAplOrig().set(bghr0021().rgh00201().fgh002AAplOrig());
        hv02301Movhist3().movhist3().iExisInfAdi().set(bghr0021().rgh00201().fgh002IExisInfAdi());
        hv02301Movhist3().movhist3().xChavAcsInfAdi().set(bghr0021().rgh00201().fgh002XChavAcsInfAdi());
        hv02301Movhist3().movhist3().tsActzUlt().set(bghr0021().rgh00201().fgh002TsActzUlt());
        hv02301Movhist3().movhist3().cUsidActzUlt().set(bghr0021().rgh00201().fgh002CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH02301_MOVHIST3
         */
        hv02301Movhist3().insertPghqz02a1482() ;
        if (hv02301Movhist3().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh02301.add(1);
        }
        if (hv02301Movhist3().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv02301Movhist3().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - VGH02301 - INSERT  - ");
            wSqlcode.set(hv02301Movhist3().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30004EscreverHist024() {
        log(TraceLevel.Debug, "A30004-ESCREVER-HIST-024");
        hv02401Movhist4().movhist4().initialize() ;
        hv02401Movhist4().movhist4().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv02401Movhist4().movhist4().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv02401Movhist4().movhist4().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv02401Movhist4().movhist4().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv02401Movhist4().movhist4().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv02401Movhist4().movhist4().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv02401Movhist4().movhist4().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv02401Movhist4().movhist4().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv02401Movhist4().movhist4().tsMovimento().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv02401Movhist4().movhist4().nsMovimento().set(bghr0021().rgh00201().fgh002NsMovimento());
        hv02401Movhist4().movhist4().zValMov().set(bghr0021().rgh00201().fgh002ZValMov());
        hv02401Movhist4().movhist4().zMovLocl().set(bghr0021().rgh00201().fgh002ZMovLocl());
        hv02401Movhist4().movhist4().iDbcr().set(bghr0021().rgh00201().fgh002IDbcr());
        hv02401Movhist4().movhist4().mMovimento().set(bghr0021().rgh00201().fgh002MMovimento());
        hv02401Movhist4().movhist4().iEstorno().set(bghr0021().rgh00201().fgh002IEstorno());
        hv02401Movhist4().movhist4().cMoedIsoOriMov().set(bghr0021().rgh00201().fgh002CMoedIsoOriMov());
        hv02401Movhist4().movhist4().mSldoCbloApos().set(bghr0021().rgh00201().fgh002MSldoCbloApos());
        hv02401Movhist4().movhist4().mSldoDpnlApos().set(bghr0021().rgh00201().fgh002MSldoDpnlApos());
        hv02401Movhist4().movhist4().mMovMoeOrigMov().set(bghr0021().rgh00201().fgh002MMovMoeOrigMov());
        hv02401Movhist4().movhist4().xRefMov().set(bghr0021().rgh00201().fgh002XRefMov());
        hv02401Movhist4().movhist4().nDocOpps().set(bghr0021().rgh00201().fgh002NDocOpps());
        hv02401Movhist4().movhist4().aAplOrig().set(bghr0021().rgh00201().fgh002AAplOrig());
        hv02401Movhist4().movhist4().iExisInfAdi().set(bghr0021().rgh00201().fgh002IExisInfAdi());
        hv02401Movhist4().movhist4().xChavAcsInfAdi().set(bghr0021().rgh00201().fgh002XChavAcsInfAdi());
        hv02401Movhist4().movhist4().tsActzUlt().set(bghr0021().rgh00201().fgh002TsActzUlt());
        hv02401Movhist4().movhist4().cUsidActzUlt().set(bghr0021().rgh00201().fgh002CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH02401_MOVHIST4
         */
        hv02401Movhist4().insertPghqz02a1599() ;
        if (hv02401Movhist4().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh02401.add(1);
        }
        if (hv02401Movhist4().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv02401Movhist4().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - VGH02401 - INSERT  - ");
            wSqlcode.set(hv02401Movhist4().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30005EscreverHist025() {
        log(TraceLevel.Debug, "A30005-ESCREVER-HIST-025");
        hv02501Movhist5().movhist5().initialize() ;
        hv02501Movhist5().movhist5().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv02501Movhist5().movhist5().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv02501Movhist5().movhist5().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv02501Movhist5().movhist5().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv02501Movhist5().movhist5().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv02501Movhist5().movhist5().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv02501Movhist5().movhist5().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv02501Movhist5().movhist5().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv02501Movhist5().movhist5().tsMovimento().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv02501Movhist5().movhist5().nsMovimento().set(bghr0021().rgh00201().fgh002NsMovimento());
        hv02501Movhist5().movhist5().zValMov().set(bghr0021().rgh00201().fgh002ZValMov());
        hv02501Movhist5().movhist5().zMovLocl().set(bghr0021().rgh00201().fgh002ZMovLocl());
        hv02501Movhist5().movhist5().iDbcr().set(bghr0021().rgh00201().fgh002IDbcr());
        hv02501Movhist5().movhist5().mMovimento().set(bghr0021().rgh00201().fgh002MMovimento());
        hv02501Movhist5().movhist5().iEstorno().set(bghr0021().rgh00201().fgh002IEstorno());
        hv02501Movhist5().movhist5().cMoedIsoOriMov().set(bghr0021().rgh00201().fgh002CMoedIsoOriMov());
        hv02501Movhist5().movhist5().mSldoCbloApos().set(bghr0021().rgh00201().fgh002MSldoCbloApos());
        hv02501Movhist5().movhist5().mSldoDpnlApos().set(bghr0021().rgh00201().fgh002MSldoDpnlApos());
        hv02501Movhist5().movhist5().mMovMoeOrigMov().set(bghr0021().rgh00201().fgh002MMovMoeOrigMov());
        hv02501Movhist5().movhist5().xRefMov().set(bghr0021().rgh00201().fgh002XRefMov());
        hv02501Movhist5().movhist5().nDocOpps().set(bghr0021().rgh00201().fgh002NDocOpps());
        hv02501Movhist5().movhist5().aAplOrig().set(bghr0021().rgh00201().fgh002AAplOrig());
        hv02501Movhist5().movhist5().iExisInfAdi().set(bghr0021().rgh00201().fgh002IExisInfAdi());
        hv02501Movhist5().movhist5().xChavAcsInfAdi().set(bghr0021().rgh00201().fgh002XChavAcsInfAdi());
        hv02501Movhist5().movhist5().tsActzUlt().set(bghr0021().rgh00201().fgh002TsActzUlt());
        hv02501Movhist5().movhist5().cUsidActzUlt().set(bghr0021().rgh00201().fgh002CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH02501_MOVHIST5
         */
        hv02501Movhist5().insertPghqz02a1716() ;
        if (hv02501Movhist5().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh02501.add(1);
        }
        if (hv02501Movhist5().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv02501Movhist5().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - VGH02501 - INSERT  - ");
            wSqlcode.set(hv02501Movhist5().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30006EscreverHist026() {
        log(TraceLevel.Debug, "A30006-ESCREVER-HIST-026");
        hv02601Movhist6().movhist6().initialize() ;
        hv02601Movhist6().movhist6().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv02601Movhist6().movhist6().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv02601Movhist6().movhist6().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv02601Movhist6().movhist6().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv02601Movhist6().movhist6().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv02601Movhist6().movhist6().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv02601Movhist6().movhist6().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv02601Movhist6().movhist6().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv02601Movhist6().movhist6().tsMovimento().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv02601Movhist6().movhist6().nsMovimento().set(bghr0021().rgh00201().fgh002NsMovimento());
        hv02601Movhist6().movhist6().zValMov().set(bghr0021().rgh00201().fgh002ZValMov());
        hv02601Movhist6().movhist6().zMovLocl().set(bghr0021().rgh00201().fgh002ZMovLocl());
        hv02601Movhist6().movhist6().iDbcr().set(bghr0021().rgh00201().fgh002IDbcr());
        hv02601Movhist6().movhist6().mMovimento().set(bghr0021().rgh00201().fgh002MMovimento());
        hv02601Movhist6().movhist6().iEstorno().set(bghr0021().rgh00201().fgh002IEstorno());
        hv02601Movhist6().movhist6().cMoedIsoOriMov().set(bghr0021().rgh00201().fgh002CMoedIsoOriMov());
        hv02601Movhist6().movhist6().mSldoCbloApos().set(bghr0021().rgh00201().fgh002MSldoCbloApos());
        hv02601Movhist6().movhist6().mSldoDpnlApos().set(bghr0021().rgh00201().fgh002MSldoDpnlApos());
        hv02601Movhist6().movhist6().mMovMoeOrigMov().set(bghr0021().rgh00201().fgh002MMovMoeOrigMov());
        hv02601Movhist6().movhist6().xRefMov().set(bghr0021().rgh00201().fgh002XRefMov());
        hv02601Movhist6().movhist6().nDocOpps().set(bghr0021().rgh00201().fgh002NDocOpps());
        hv02601Movhist6().movhist6().aAplOrig().set(bghr0021().rgh00201().fgh002AAplOrig());
        hv02601Movhist6().movhist6().iExisInfAdi().set(bghr0021().rgh00201().fgh002IExisInfAdi());
        hv02601Movhist6().movhist6().xChavAcsInfAdi().set(bghr0021().rgh00201().fgh002XChavAcsInfAdi());
        hv02601Movhist6().movhist6().tsActzUlt().set(bghr0021().rgh00201().fgh002TsActzUlt());
        hv02601Movhist6().movhist6().cUsidActzUlt().set(bghr0021().rgh00201().fgh002CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH02601_MOVHIST6
         */
        hv02601Movhist6().insertPghqz02a1833() ;
        if (hv02601Movhist6().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh02601.add(1);
        }
        if (hv02601Movhist6().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv02601Movhist6().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - VGH02601 - INSERT  - ");
            wSqlcode.set(hv02601Movhist6().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "W-SQLCODE -", wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30007EscreverHist027() {
        log(TraceLevel.Debug, "A30007-ESCREVER-HIST-027");
        hv02701Movhist7().movhist7().initialize() ;
        hv02701Movhist7().movhist7().cPaisIsoaCont().set(bghr0021().rgh00201().fgh002CPaisIsoaCont());
        hv02701Movhist7().movhist7().cBancCont().set(bghr0021().rgh00201().fgh002CBancCont());
        hv02701Movhist7().movhist7().cOeEgcCont().set(bghr0021().rgh00201().fgh002COeEgcCont());
        hv02701Movhist7().movhist7().nsRdclCont().set(bghr0021().rgh00201().fgh002NsRdclCont());
        hv02701Movhist7().movhist7().vChkdCont().set(bghr0021().rgh00201().fgh002VChkdCont());
        hv02701Movhist7().movhist7().cTipoCont().set(bghr0021().rgh00201().fgh002CTipoCont());
        hv02701Movhist7().movhist7().cMoedIsoScta().set(bghr0021().rgh00201().fgh002CMoedIsoScta());
        hv02701Movhist7().movhist7().nsDeposito().set(bghr0021().rgh00201().fgh002NsDeposito());
        hv02701Movhist7().movhist7().tsMovimento().set(bghr0021().rgh00201().fgh002TsMovimento());
        hv02701Movhist7().movhist7().nsMovimento().set(bghr0021().rgh00201().fgh002NsMovimento());
        hv02701Movhist7().movhist7().zValMov().set(bghr0021().rgh00201().fgh002ZValMov());
        hv02701Movhist7().movhist7().zMovLocl().set(bghr0021().rgh00201().fgh002ZMovLocl());
        hv02701Movhist7().movhist7().iDbcr().set(bghr0021().rgh00201().fgh002IDbcr());
        hv02701Movhist7().movhist7().mMovimento().set(bghr0021().rgh00201().fgh002MMovimento());
        hv02701Movhist7().movhist7().iEstorno().set(bghr0021().rgh00201().fgh002IEstorno());
        hv02701Movhist7().movhist7().cMoedIsoOriMov().set(bghr0021().rgh00201().fgh002CMoedIsoOriMov());
        hv02701Movhist7().movhist7().mSldoCbloApos().set(bghr0021().rgh00201().fgh002MSldoCbloApos());
        hv02701Movhist7().movhist7().mSldoDpnlApos().set(bghr0021().rgh00201().fgh002MSldoDpnlApos());
        hv02701Movhist7().movhist7().mMovMoeOrigMov().set(bghr0021().rgh00201().fgh002MMovMoeOrigMov());
        hv02701Movhist7().movhist7().xRefMov().set(bghr0021().rgh00201().fgh002XRefMov());
        hv02701Movhist7().movhist7().nDocOpps().set(bghr0021().rgh00201().fgh002NDocOpps());
        hv02701Movhist7().movhist7().aAplOrig().set(bghr0021().rgh00201().fgh002AAplOrig());
        hv02701Movhist7().movhist7().iExisInfAdi().set(bghr0021().rgh00201().fgh002IExisInfAdi());
        hv02701Movhist7().movhist7().xChavAcsInfAdi().set(bghr0021().rgh00201().fgh002XChavAcsInfAdi());
        hv02701Movhist7().movhist7().tsActzUlt().set(bghr0021().rgh00201().fgh002TsActzUlt());
        hv02701Movhist7().movhist7().cUsidActzUlt().set(bghr0021().rgh00201().fgh002CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH02701_MOVHIST7
         */
        hv02701Movhist7().insertPghqz02a1951() ;
        if (hv02701Movhist7().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh02701.add(1);
        }
        if (hv02701Movhist7().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv02701Movhist7().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - VGH02701 - INSERT  - ");
            wSqlcode.set(hv02701Movhist7().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Error, "W-SQLCODE -", wSqlcode);
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
                tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - READ - ");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghqz02a().fwk900NCommit().set(add(fwk900().fwk900RegPghqz02a().fwk900NCommit(), contRegCommit));
            fwk900().rewrite(fwk900().fwk900RegPghqz02a()) ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQZ02A - FWK900 - REWRITE -");
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
            while (contRegLidosFwk001.isLessOrEqual(auxContRegLidos) && !fwk001().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17001LerFwk001() ;
            }
            if (!fwk001().getStatusOk()) {
                while (!fwk001().getStatusOk() && progOk.isTrue()) {
                    s30001ProcessarFwk001() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk002.isLessOrEqual(auxContRegLidos) && !fwk002().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17002LerFwk002() ;
            }
            if (!fwk002().getStatusOk()) {
                while (!fwk002().getStatusOk() && progOk.isTrue()) {
                    s30002ProcessarFwk002() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk003.isLessOrEqual(auxContRegLidos) && !fwk003().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17003LerFwk003() ;
            }
            if (!fwk003().getStatusOk()) {
                while (!fwk003().getStatusOk() && progOk.isTrue()) {
                    s30003ProcessarFwk003() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk004.isLessOrEqual(auxContRegLidos) && !fwk004().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17004LerFwk004() ;
            }
            if (!fwk004().getStatusOk()) {
                while (!fwk004().getStatusOk() && progOk.isTrue()) {
                    s30004ProcessarFwk004() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk005.isLessOrEqual(auxContRegLidos) && !fwk005().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17005LerFwk005() ;
            }
            if (!fwk005().getStatusOk()) {
                while (!fwk005().getStatusOk() && progOk.isTrue()) {
                    s30005ProcessarFwk005() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk006.isLessOrEqual(auxContRegLidos) && !fwk006().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17006LerFwk006() ;
            }
            if (!fwk006().getStatusOk()) {
                while (!fwk006().getStatusOk() && progOk.isTrue()) {
                    s30006ProcessarFwk006() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk007.isLessOrEqual(auxContRegLidos) && !fwk007().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17007LerFwk007() ;
            }
            if (!fwk007().getStatusOk()) {
                while (!fwk007().getStatusOk() && progOk.isTrue()) {
                    s30007ProcessarFwk007() ;
                }
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQZ02A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQZ02A")
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
            IFormattedString impRegLidos() ;
            
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
