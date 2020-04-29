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
import cgd.gh.structures.work.Bghw0001 ;
import cgd.gh.structures.work.Bghw0002 ;
import cgd.gh.structures.work.Bghwj001 ;


/**
 * 
 * FGH300 - FICHEIRO DE CONTROLO DE EXECUCAO DO PROGRAMA
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : LE O FICHEIRO FGH024 -RECUPERACAO DA TGH24 DO
 * DIA                  PARA RECUPERACAO
 * ALTERACAO     :
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc924a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh024
     */
    @Handler(name="FGH024", record="rgh00201")
    @Data
    protected abstract Fgh024 fgh024() ;
    
    /**
     * @return instancia da classe Fwk199
     */
    @Handler(name="FWK199", record="fwk199Reg227")
    @Data
    protected abstract Fwk199 fwk199() ;
    
    /**
     * @return instancia da classe Fwk198
     */
    @Handler(name="FWK198", record="fwk198Reg227")
    @Data
    protected abstract Fwk198 fwk198() ;
    
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
     * @return instancia da classe Bghw0001
     */
    @Data
    protected abstract Bghw0001 bghw0001() ;
    
    /**
     * @return instancia da classe Bghw0002
     */
    @Data
    protected abstract Bghw0002 bghw0002() ;
    
    /**
     * @return instancia da classe Bghwj001
     */
    @Data
    protected abstract Bghwj001 bghwj001() ;
    
    @Data(size=5, signed=true, compression=COMP3)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidos ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt50 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2008 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2007 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2006 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2005 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2004 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2003 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2002 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2001 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt2000 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk199 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk198 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1997 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1996 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1995 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1994 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1993 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1992 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1991 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1990 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrt1989 ;
    
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
    
    @Data(size=10, value=" ")
    protected IString wsDataMov ;
    
    /**
     * @return instancia da classe local WsDataMovMask
     */
    @Data
    @Mask
    protected abstract WsDataMovMask wsDataMovMask() ;
    
    @Data(size=8, value="0")
    protected ILong wsDataAux ;
    
    /**
     * @return instancia da classe local WsZAux
     */
    @Data
    protected abstract WsZAux wsZAux() ;
    
    @Data(size=26, value=" ")
    protected IString wsTsActzUlt ;
    
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
        bghw0300().wsNmPrograma().set("PGHC924A");
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
        wsTsActzUlt.set(wTimestamp());
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AbrirFicheiros() ;
        }
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
    protected void a13000AbrirFicheiros() {
        log(TraceLevel.Debug, "A13000-ABRIR-FICHEIROS");
        if (progOk.isTrue()) {
            fwk199().open(CREATE ) ;
            if (!fwk199().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC924A - FWK199 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk199().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk198().open(CREATE ) ;
            if (!fwk198().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC924A - FWK198 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk198().getStatus());
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
            a31000OpenFgh024() ;
            if (progOk.isTrue()) {
                a32000LerFgh024() ;
            }
            if (progOk.isTrue()) {
                while (!fgh024().getStatusOk() && progOk.isTrue()) {
                    a33000TratarFgh024() ;
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
    protected void a31000OpenFgh024() {
        log(TraceLevel.Debug, "A31000-OPEN-FGH024");
        fgh024().open() ;
        if (!fgh024().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC924A - FGH024 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh024().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000LerFgh024() {
        log(TraceLevel.Debug, "A32000-LER-FGH024");
        fgh024().read() ;
        if (fgh024().getStatusOk()) {
            contRegLidos.add(1);
            wsDataMov.set(fgh024().rgh00201().fgh002TsMovimento().get(1, 10));
        }
        if (!fgh024().getStatusOk() && !fgh024().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC924A - FGH024 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fgh024().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000TratarFgh024() {
        log(TraceLevel.Debug, "A33000-TRATAR-FGH024");
        if (wsDataMovMask().wsAnoMov().isGreater(2007)) {
            contRegEscrt2008.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2007)) {
            contRegEscrt2007.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2006)) {
            contRegEscrt2006.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2005)) {
            contRegEscrt2005.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2004)) {
            contRegEscrt2004.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2003)) {
            contRegEscrt2003.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2002)) {
            contRegEscrt2002.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2001)) {
            contRegEscrt2001.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(2000)) {
            contRegEscrt2000.add(1);
        } else if (wsDataMovMask().wsAnoMov().isEqual(1999)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                a33990EscreverFwk199() ;
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1998)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                a33980EscreverFwk198() ;
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1997)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1997.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1996)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1996.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1995)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1995.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1994)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1994.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1993)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1993.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1992)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1992.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1991)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1991.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isEqual(1990)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1990.add(1);
            }
        } else if (wsDataMovMask().wsAnoMov().isLess(1990)) {
            if (fgh024().rgh00201().fgh002CTipoCont().isEqual(50) || 
                fgh024().rgh00201().fgh002CTipoCont().isEqual(5)) {
                contRegEscrt50.add(1);
            } else {
                contRegEscrt1989.add(1);
            }
        }
        if (progOk.isTrue()) {
            a32000LerFgh024() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33990EscreverFwk199() {
        log(TraceLevel.Debug, "A35100-ESCREVER-FWK199");
        fwk199().fwk199Reg227.initialize() ;
        fwk199().setRecord(fgh024().getRecord()) ;
        fwk199().write(fwk199().fwk199Reg227) ;
        if (fwk199().getStatusOk()) {
            contRegEscrtFwk199.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC924A - FWK199 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk199().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33980EscreverFwk198() {
        log(TraceLevel.Debug, "A35100-ESCREVER-FWK198");
        fwk198().fwk198Reg227.initialize() ;
        fwk198().setRecord(fgh024().getRecord()) ;
        fwk198().write(fwk198().fwk198Reg227) ;
        if (fwk198().getStatusOk()) {
            contRegEscrtFwk198.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC924A - FWK198 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk198().getStatus());
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
        fwk199().close() ;
        if (!fwk199().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC924A - FWK199 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk199().getStatus());
        }
        fwk198().close() ;
        if (!fwk198().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC924A - FWK198 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk198().getStatus());
        }
        fgh024().close() ;
        if (!fgh024().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC924A - FGH024 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fgh024().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s50000Fim() {
        log(TraceLevel.Debug, "S50000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a51000CalculaTempoExecucao() ;
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impRegLidosFgh024().set(contRegLidos);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt50);
            tabelaImpressao().linha06().impFichEsc().set("CT-50-50");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2008);
            tabelaImpressao().linha06().impFichEsc().set("A > 2007");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2007);
            tabelaImpressao().linha06().impFichEsc().set("A = 2007");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2006);
            tabelaImpressao().linha06().impFichEsc().set("A = 2006");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2005);
            tabelaImpressao().linha06().impFichEsc().set("A = 2005");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2004);
            tabelaImpressao().linha06().impFichEsc().set("A = 2004");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2003);
            tabelaImpressao().linha06().impFichEsc().set("A = 2003");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2002);
            tabelaImpressao().linha06().impFichEsc().set("A = 2002");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2001);
            tabelaImpressao().linha06().impFichEsc().set("A = 2001");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt2000);
            tabelaImpressao().linha06().impFichEsc().set("A = 2000");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk199);
            tabelaImpressao().linha06().impFichEsc().set("FWK199");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk198);
            tabelaImpressao().linha06().impFichEsc().set("FWK198");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1997);
            tabelaImpressao().linha06().impFichEsc().set("A = 1997");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1996);
            tabelaImpressao().linha06().impFichEsc().set("A = 1996");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1995);
            tabelaImpressao().linha06().impFichEsc().set("A = 1995");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1994);
            tabelaImpressao().linha06().impFichEsc().set("A = 1994");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1993);
            tabelaImpressao().linha06().impFichEsc().set("A = 1993");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1992);
            tabelaImpressao().linha06().impFichEsc().set("A = 1992");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1991);
            tabelaImpressao().linha06().impFichEsc().set("A = 1991");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1990);
            tabelaImpressao().linha06().impFichEsc().set("A = 1990");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrt1989);
            tabelaImpressao().linha06().impFichEsc().set("A = 1989");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC924A - FIM ANORMAL ");
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
    public interface WsDataMovMask extends IDataMask {
        
        @Data(size=4)
        IInt wsAnoMov() ;
        
        @Data(size=6)
        IString wsRetMov() ;
        
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
            
            @Data(size=8, value="PGHC924A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC924A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FGH024")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFgh024() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS ESCRITOS EM ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=3, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
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
            
            @Data(size=4, value=" ", lpadding=2, rpadding=58, lpaddingValue=" ", rpaddingValue=" ")
            IString impStatus() ;
            
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
