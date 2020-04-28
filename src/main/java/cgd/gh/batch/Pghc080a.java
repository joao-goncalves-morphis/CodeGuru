package cgd.gh.batch;

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
import cgd.rt.structures.work.Brtr0032 ;
import cgd.gr.structures.link.Bgrl030a ;


/**
 * 
 * FGH300 - FICHEIRO DE CONTROLO DE EXECUCAO DO PROGRAMA
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * -------->   MIGRACAO DA APLICACAO HH   <------------
 * PROGRAMA      : PGHC080A
 * OBJECTIVOS    : SEPARA FICHEIRO FHH606 ENVIADO PELA APLICACAO
 * HH E SEPARA EM 13 FICHEIROS DE TRABALHO
 * FWK001 - DO BALCAO 1 A 100
 * FWK002 - DO BALCAO 101 A 200
 * FWK003 - DO BALCAO 201 A 300
 * FWK004 - DO BALCAO 301 A 400
 * FWK005 - DO BALCAO 401 A 500
 * FWK006 - DO BALCAO 501 A 600
 * FWK007 - DO BALCAO 601 A 700
 * FWK008 - DO BALCAO 701 A 800
 * FWK009 - DO BALCAO 801 A 900
 * FWK010 - DO BALCAO 901 A 1500
 * FWK011 - DO BALCAO 1501 A 2100
 * FWK012 - DO BALCAO 2101 A 2500
 * FWK013 - DO BALCAO 2501 A 9999
 * ALTERACAO     :
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc080a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk00102
     */
    @Handler(name="FWK001", record="fwk001Reg75")
    @Data
    protected abstract Fwk00102 fwk001() ;
    
    /**
     * @return instancia da classe Fwk00202
     */
    @Handler(name="FWK002", record="fwk002Reg75")
    @Data
    protected abstract Fwk00202 fwk002() ;
    
    /**
     * @return instancia da classe Fwk00302
     */
    @Handler(name="FWK003", record="fwk003Reg75")
    @Data
    protected abstract Fwk00302 fwk003() ;
    
    /**
     * @return instancia da classe Fwk00402
     */
    @Handler(name="FWK004", record="fwk004Reg75")
    @Data
    protected abstract Fwk00402 fwk004() ;
    
    /**
     * @return instancia da classe Fwk00502
     */
    @Handler(name="FWK005", record="fwk005Reg75")
    @Data
    protected abstract Fwk00502 fwk005() ;
    
    /**
     * @return instancia da classe Fwk00602
     */
    @Handler(name="FWK006", record="fwk006Reg75")
    @Data
    protected abstract Fwk00602 fwk006() ;
    
    /**
     * @return instancia da classe Fwk00702
     */
    @Handler(name="FWK007", record="fwk007Reg75")
    @Data
    protected abstract Fwk00702 fwk007() ;
    
    /**
     * @return instancia da classe Fwk00802
     */
    @Handler(name="FWK008", record="fwk008Reg75")
    @Data
    protected abstract Fwk00802 fwk008() ;
    
    /**
     * @return instancia da classe Fwk00902
     */
    @Handler(name="FWK009", record="fwk009Reg75")
    @Data
    protected abstract Fwk00902 fwk009() ;
    
    /**
     * @return instancia da classe Fwk01002
     */
    @Handler(name="FWK010", record="fwk010Reg75")
    @Data
    protected abstract Fwk01002 fwk010() ;
    
    /**
     * @return instancia da classe Fwk01102
     */
    @Handler(name="FWK011", record="fwk011Reg75")
    @Data
    protected abstract Fwk01102 fwk011() ;
    
    /**
     * @return instancia da classe Fwk01202
     */
    @Handler(name="FWK012", record="fwk012Reg75")
    @Data
    protected abstract Fwk01202 fwk012() ;
    
    /**
     * @return instancia da classe Fwk01302
     */
    @Handler(name="FWK013", record="fwk013Reg75")
    @Data
    protected abstract Fwk01302 fwk013() ;
    
    /**
     * @return instancia da classe Fgh202
     */
    @Handler(name="FGH202", record="rgh20201")
    @Data
    protected abstract Fgh202 fgh202() ;
    
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
     * @return instancia da classe Brtr0032
     */
    @Data
    protected abstract Brtr0032 brtr0032() ;
    
    /**
     * @return instancia da classe Bgrl030a
     */
    @Data
    protected abstract Bgrl030a bgrl030a() ;
    
    @Data(size=5, signed=true, compression=COMP3)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    
    
    @Data(size=1)
    protected IString swCrtlConta ;
    @Data
    @Condition("3")
    protected ICondition swContaIgual ;
    @Data
    @Condition("4")
    protected ICondition swContaDiferente ;
    
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFgh202 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk001 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk002 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk003 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk004 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk005 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk006 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk007 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk008 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk009 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk010 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk011 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk012 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk013 ;
    
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
    
    @Data(size=8, value="0")
    protected ILong wsDataAux ;
    
    /**
     * @return instancia da classe local WsZAux
     */
    @Data
    protected abstract WsZAux wsZAux() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
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
        bghw0300().wsNmPrograma().set("PGHC080A");
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
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        a15000AbrirFicheiros() ;
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A11000-ABRIR-FGH300");
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
    protected void a15000AbrirFicheiros() {
        log(TraceLevel.Debug, "A15000-ABRIR-FICHEIROS");
        fwk001().open(CREATE ) ;
        if (!fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK001 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fwk001().getStatus());
        }
        if (progOk.isTrue()) {
            fwk002().open(CREATE ) ;
            if (!fwk002().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK002 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk002().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk003().open(CREATE ) ;
            if (!fwk003().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK003 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk003().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk004().open(CREATE ) ;
            if (!fwk004().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK004 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk004().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk005().open(CREATE ) ;
            if (!fwk005().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK005 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk005().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk006().open(CREATE ) ;
            if (!fwk006().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK006 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk006().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk007().open(CREATE ) ;
            if (!fwk007().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK007 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk007().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk008().open(CREATE ) ;
            if (!fwk008().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK008 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk008().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk009().open(CREATE ) ;
            if (!fwk009().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK009 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk009().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk010().open(CREATE ) ;
            if (!fwk010().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK010 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk010().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk011().open(CREATE ) ;
            if (!fwk011().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK011 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk011().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk012().open(CREATE ) ;
            if (!fwk012().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK012 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk012().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk013().open(CREATE ) ;
            if (!fwk013().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK013 - OPEN - ");
                tabelaImpressao().linha10().impStatus().set(fwk013().getStatus());
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (progOk.isTrue()) {
            a31000OpenFgh202() ;
            if (progOk.isTrue()) {
                a32000LerFgh202() ;
            }
            if (progOk.isTrue()) {
                while (!fgh202().getStatusOk() && progOk.isTrue()) {
                    a33000TratarFgh202() ;
                }
                if (progOk.isTrue()) {
                    a48000FecharFicheiros() ;
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31000OpenFgh202() {
        log(TraceLevel.Debug, "A31000-OPEN-FGH202");
        fgh202().open() ;
        if (!fgh202().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FGH202 - OPEN - ");
            tabelaImpressao().linha10().impStatus().set(fgh202().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000LerFgh202() {
        log(TraceLevel.Debug, "A32000-LER-FGH202");
        fgh202().read() ;
        if (fgh202().getStatusOk()) {
            contRegLidosFgh202.add(1);
        }
        if (!fgh202().getStatusOk() && !fgh202().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FGH202 - READ - ");
            tabelaImpressao().linha10().impStatus().set(fgh202().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000TratarFgh202() {
        log(TraceLevel.Debug, "A33000-TRTAR-FGH202");
        if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(0) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(100)) {
            a34000EscreverFwk001() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(101) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(200)) {
            a35000EscreverFwk002() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(201) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(300)) {
            a36000EscreverFwk003() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(301) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(400)) {
            a37000EscreverFwk004() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(401) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(500)) {
            a38000EscreverFwk005() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(501) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(600)) {
            a39000EscreverFwk006() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(601) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(700)) {
            a40000EscreverFwk007() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(701) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(800)) {
            a41000EscreverFwk008() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(801) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(900)) {
            a42000EscreverFwk009() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(901) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(1500)) {
            a43000EscreverFwk010() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(1501) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(2100)) {
            a44000EscreverFwk011() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(2101) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(2500)) {
            a45000EscreverFwk012() ;
        } else if (fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isGreaterOrEqual(2501) && 
            fgh202().rgh20201().fgh202NSubconta().fgh202COeEgcCont().isLessOrEqual(9999)) {
            a46000EscreverFwk013() ;
        }
        if (progOk.isTrue()) {
            a32000LerFgh202() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreverFwk001() {
        log(TraceLevel.Debug, "A34000-ESCREVER-FWK001");
        fwk001().fwk001Reg75.initialize() ;
        fwk001().setRecord(fgh202().getRecord()) ;
        fwk001().write(fwk001().fwk001Reg75) ;
        if (fwk001().getStatusOk()) {
            contRegEscrtFwk001.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK001 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk001().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35000EscreverFwk002() {
        log(TraceLevel.Debug, "A35000-ESCREVER-FWK002");
        fwk002().fwk002Reg75.initialize() ;
        fwk002().setRecord(fgh202().getRecord()) ;
        fwk002().write(fwk002().fwk002Reg75) ;
        if (fwk002().getStatusOk()) {
            contRegEscrtFwk002.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK002 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk002().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36000EscreverFwk003() {
        log(TraceLevel.Debug, "A36000-ESCREVER-FWK003");
        fwk003().fwk003Reg75.initialize() ;
        fwk003().setRecord(fgh202().getRecord()) ;
        fwk003().write(fwk003().fwk003Reg75) ;
        if (fwk003().getStatusOk()) {
            contRegEscrtFwk003.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK003 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk003().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a37000EscreverFwk004() {
        log(TraceLevel.Debug, "A37000-ESCREVER-FWK004");
        fwk004().fwk004Reg75.initialize() ;
        fwk004().setRecord(fgh202().getRecord()) ;
        fwk004().write(fwk004().fwk004Reg75) ;
        if (fwk004().getStatusOk()) {
            contRegEscrtFwk004.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK004 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk004().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a38000EscreverFwk005() {
        log(TraceLevel.Debug, "A38000-ESCREVER-FWK005");
        fwk005().fwk005Reg75.initialize() ;
        fwk005().setRecord(fgh202().getRecord()) ;
        fwk005().write(fwk005().fwk005Reg75) ;
        if (fwk005().getStatusOk()) {
            contRegEscrtFwk005.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK005 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk005().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a39000EscreverFwk006() {
        log(TraceLevel.Debug, "A39000-ESCREVER-FWK006");
        fwk006().fwk006Reg75.initialize() ;
        fwk006().setRecord(fgh202().getRecord()) ;
        fwk006().write(fwk006().fwk006Reg75) ;
        if (fwk006().getStatusOk()) {
            contRegEscrtFwk006.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK006 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk006().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a40000EscreverFwk007() {
        log(TraceLevel.Debug, "A40000-ESCREVER-FWK007");
        fwk007().fwk007Reg75.initialize() ;
        fwk007().setRecord(fgh202().getRecord()) ;
        fwk007().write(fwk007().fwk007Reg75) ;
        if (fwk007().getStatusOk()) {
            contRegEscrtFwk007.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK007 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk007().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a41000EscreverFwk008() {
        log(TraceLevel.Debug, "A41000-ESCREVER-FWK008");
        fwk008().fwk008Reg75.initialize() ;
        fwk008().setRecord(fgh202().getRecord()) ;
        fwk008().write(fwk008().fwk008Reg75) ;
        if (fwk008().getStatusOk()) {
            contRegEscrtFwk008.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK008 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk008().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a42000EscreverFwk009() {
        log(TraceLevel.Debug, "A42000-ESCREVER-FWK009");
        fwk009().fwk009Reg75.initialize() ;
        fwk009().setRecord(fgh202().getRecord()) ;
        fwk009().write(fwk009().fwk009Reg75) ;
        if (fwk009().getStatusOk()) {
            contRegEscrtFwk009.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK009 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk009().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a43000EscreverFwk010() {
        log(TraceLevel.Debug, "A42000-ESCREVER-FWK010");
        fwk010().fwk010Reg75.initialize() ;
        fwk010().setRecord(fgh202().getRecord()) ;
        fwk010().write(fwk010().fwk010Reg75) ;
        if (fwk010().getStatusOk()) {
            contRegEscrtFwk010.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK010 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk010().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a44000EscreverFwk011() {
        log(TraceLevel.Debug, "A44000-ESCREVER-FWK011");
        fwk011().fwk011Reg75.initialize() ;
        fwk011().setRecord(fgh202().getRecord()) ;
        fwk011().write(fwk011().fwk011Reg75) ;
        if (fwk011().getStatusOk()) {
            contRegEscrtFwk011.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK011 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk011().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a45000EscreverFwk012() {
        log(TraceLevel.Debug, "A45000-ESCREVER-FWK012");
        fwk012().fwk012Reg75.initialize() ;
        fwk012().setRecord(fgh202().getRecord()) ;
        fwk012().write(fwk012().fwk012Reg75) ;
        if (fwk012().getStatusOk()) {
            contRegEscrtFwk012.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK012 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk012().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a46000EscreverFwk013() {
        log(TraceLevel.Debug, "A45000-ESCREVER-FWK013");
        fwk013().fwk013Reg75.initialize() ;
        fwk013().setRecord(fgh202().getRecord()) ;
        fwk013().write(fwk013().fwk013Reg75) ;
        if (fwk013().getStatusOk()) {
            contRegEscrtFwk013.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK013 - WRITE ");
            tabelaImpressao().linha10().impStatus().set(fwk013().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a48000FecharFicheiros() {
        log(TraceLevel.Debug, "A48000-FECHAR-FICHEIROS");
        fwk001().close() ;
        if (!fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK001 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk001().getStatus());
        }
        fwk002().close() ;
        if (!fwk002().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK002 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk002().getStatus());
        }
        fwk003().close() ;
        if (!fwk003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK003 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk003().getStatus());
        }
        fwk004().close() ;
        if (!fwk004().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK004 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk001().getStatus());
        }
        fwk005().close() ;
        if (!fwk005().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK005 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk005().getStatus());
        }
        fwk006().close() ;
        if (!fwk006().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK006 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk001().getStatus());
        }
        fwk007().close() ;
        if (!fwk007().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK007 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk007().getStatus());
        }
        fwk008().close() ;
        if (!fwk008().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK008 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk008().getStatus());
        }
        fwk009().close() ;
        if (!fwk009().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK009 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk009().getStatus());
        }
        fwk010().close() ;
        if (!fwk010().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK010 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk010().getStatus());
        }
        fwk012().close() ;
        if (!fwk012().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK012 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk012().getStatus());
        }
        fwk013().close() ;
        if (!fwk013().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FWK013 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fwk013().getStatus());
        }
        fgh202().close() ;
        if (!fgh202().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha10().msgStatus().set("PGHC080A - FGH202 - CLOSE - ");
            tabelaImpressao().linha10().impStatus().set(fgh202().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Fim() {
        log(TraceLevel.Debug, "S50000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha08().impReturnCode().set(0);
            a51000CalculaTempoExecucao() ;
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impRegLidosFgh202().set(contRegLidosFgh202);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk001);
            tabelaImpressao().linha06().impFichEsc().set("FWK001");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk002);
            tabelaImpressao().linha06().impFichEsc().set("FWK002");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk003);
            tabelaImpressao().linha06().impFichEsc().set("FWK003");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk004);
            tabelaImpressao().linha06().impFichEsc().set("FWK004");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk005);
            tabelaImpressao().linha06().impFichEsc().set("FWK005");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk006);
            tabelaImpressao().linha06().impFichEsc().set("FWK006");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk007);
            tabelaImpressao().linha06().impFichEsc().set("FWK007");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk008);
            tabelaImpressao().linha06().impFichEsc().set("FWK008");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk009);
            tabelaImpressao().linha06().impFichEsc().set("FWK009");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk010);
            tabelaImpressao().linha06().impFichEsc().set("FWK010");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk011);
            tabelaImpressao().linha06().impFichEsc().set("FWK011");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk012);
            tabelaImpressao().linha06().impFichEsc().set("FWK012");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk013);
            tabelaImpressao().linha06().impFichEsc().set("FWK013");
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha08().impReturnCode().set(returnCode);
            tabelaImpressao().linha09().impMens1().set("PGHC080A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(11); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
    }
    
    /**
     * 
     * 
     */
    protected void a51000CalculaTempoExecucao() {
        log(TraceLevel.Debug, "A51000-CALCULA-TEMPO-EXECUCAO");
        bghw0300().wsVariaveisHora().horaFim().set(getTime()) ;
        /**
         * BOOK QUE CONTEM A ROTINA DE CALCULO DO TEMPO DE EXECUCAO
         * DO PROGRAMA
         */
        bghp0300() ;
        tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
        tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
        tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
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
            s30000Processar() ;
        }
        s50000Fim() ;
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
    public interface WsZAux extends IDataStruct {
        
        @Data(size=4)
        IInt anoAux() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt mesAux() ;
        
        @Data(size=2, lpadding=1, lpaddingValue="-")
        IInt diaAux() ;
        
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
            
            @Data(size=6, value="0", lpadding=1, lpaddingValue=".")
            IInt wResto() ;
            
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
        
        /**
         * @return instancia da classe local Linha11
         */
        @Data
        Linha11 linha11() ;
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHC080A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC080A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FGH202")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
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
            
            @Data(size=32, value="NUMERO DE REGISTOS IGNORADOS   ")
            IString filler002() ;
            
            @Data(size=11, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegIgnor() ;
            
        }
        
        public interface Linha08 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(size=4, value=" ", lpadding=2, rpadding=58, lpaddingValue=" ", rpaddingValue=" ")
            IString impStatus() ;
            
        }
        
        public interface Linha11 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=11, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
