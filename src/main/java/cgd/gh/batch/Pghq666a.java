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
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtw7000 ;
import cgd.gh.structures.work.Bghw0150 ;
import cgd.zy.batch.Pzya710a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    :-GERADOR DE DML PARA TODO O BATCH DE
 * BALDEAMENTO DAS TABELAS DE HISTORICO DE
 * PASSIVAS
 * :-VERSÃO DE PRODUÇÃO
 * LISTA         :-FWK001 - LGHS010  - SELECT TGH00010_CONTIPHST
 * OUTPUT    N/A :-FWK002 - N/A
 * :-FWK003 - LGHD027  - DELETE TGH00027_MOVHIST7
 * :-FWK004 - LGHD127  - DELETE TGH00127_MOVHSTCP7
 * :-FWK005 - LGHS002  - SELECT TGH00002_MOVHST
 * :-FWK006 - LGHS002  - SELECT TGH00002_MOVHST
 * N/A :-FWK007 - N/A
 * N/A :-FWK008 - N/A
 * :-FWK009 - LGHS027  - SELECT TGH00027_MOVHIST7
 * :-FWK010 - LGHS102  - SELECT TGH00102_MOVHSTCPL
 * :-FWK011 - LGHS102  - SELECT TGH00102_MOVHSTCPL
 * :-FWK012 - LGHS127  - SELECT TGH00127_MOVHSTCP7
 * :-FWK013 - JOB      -
 * :-FWK014 - JOB      -
 * :-FWK015 - JOB      -
 * :-FWK016 - JOB      -
 * :-FWK017 - JOB      -
 * :-FWK018 - JOB      -
 * :-FWK019 - JOB      -
 * :-FWK020 - JOB      -
 * ALTERACOES    :ACT0650 MIGRACAO IBM / BMC
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq666a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk00102
     */
    @Handler(name="FWK001", record="regFwk00180")
    @Data
    protected abstract Fwk00102 fwk001() ;
    
    /**
     * @return instancia da classe Fwk003
     */
    @Handler(name="FWK003", record="regFwk00380")
    @Data
    protected abstract Fwk003 fwk003() ;
    
    /**
     * @return instancia da classe Fwk03a
     */
    @Handler(name="FWK03A", record="regFwk03a80")
    @Data
    protected abstract Fwk03a fwk03a() ;
    
    /**
     * @return instancia da classe Fwk004
     */
    @Handler(name="FWK004", record="regFwk00480")
    @Data
    protected abstract Fwk004 fwk004() ;
    
    /**
     * @return instancia da classe Fwk04a
     */
    @Handler(name="FWK04A", record="regFwk04a80")
    @Data
    protected abstract Fwk04a fwk04a() ;
    
    /**
     * @return instancia da classe Fwk005
     */
    @Handler(name="FWK005", record="regFwk00580")
    @Data
    protected abstract Fwk005 fwk005() ;
    
    /**
     * @return instancia da classe Fwk006
     */
    @Handler(name="FWK006", record="regFwk00680")
    @Data
    protected abstract Fwk006 fwk006() ;
    
    /**
     * @return instancia da classe Fwk009
     */
    @Handler(name="FWK009", record="regFwk00980")
    @Data
    protected abstract Fwk009 fwk009() ;
    
    /**
     * @return instancia da classe Fwk010
     */
    @Handler(name="FWK010", record="regFwk01080")
    @Data
    protected abstract Fwk010 fwk010() ;
    
    /**
     * @return instancia da classe Fwk011
     */
    @Handler(name="FWK011", record="regFwk01180")
    @Data
    protected abstract Fwk011 fwk011() ;
    
    /**
     * @return instancia da classe Fwk012
     */
    @Handler(name="FWK012", record="regFwk01280")
    @Data
    protected abstract Fwk012 fwk012() ;
    
    /**
     * @return instancia da classe Fwk013
     */
    @Handler(name="FWK013", record="regFwk01380")
    @Data
    protected abstract Fwk013 fwk013() ;
    
    /**
     * @return instancia da classe Fwk014
     */
    @Handler(name="FWK014", record="regFwk01480")
    @Data
    protected abstract Fwk014 fwk014() ;
    
    /**
     * @return instancia da classe Fwk14a
     */
    @Handler(name="FWK14A", record="regFwk14a80")
    @Data
    protected abstract Fwk14a fwk14a() ;
    
    /**
     * @return instancia da classe Fwk015
     */
    @Handler(name="FWK015", record="regFwk01580")
    @Data
    protected abstract Fwk015 fwk015() ;
    
    /**
     * @return instancia da classe Fwk016
     */
    @Handler(name="FWK016", record="regFwk01680")
    @Data
    protected abstract Fwk016 fwk016() ;
    
    /**
     * @return instancia da classe Fwk017
     */
    @Handler(name="FWK017", record="regFwk01780")
    @Data
    protected abstract Fwk017 fwk017() ;
    
    /**
     * @return instancia da classe Fwk018
     */
    @Handler(name="FWK018", record="regFwk01880")
    @Data
    protected abstract Fwk018 fwk018() ;
    
    /**
     * @return instancia da classe Fwk019
     */
    @Handler(name="FWK019", record="regFwk01980")
    @Data
    protected abstract Fwk019 fwk019() ;
    
    /**
     * @return instancia da classe Fwk19a
     */
    @Handler(name="FWK19A", record="regFwk19a80")
    @Data
    protected abstract Fwk19a fwk19a() ;
    
    /**
     * @return instancia da classe Fwk020
     */
    @Handler(name="FWK020", record="regFwk02080")
    @Data
    protected abstract Fwk020 fwk020() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Pzya710a
     */
    @Data
    protected abstract Pzya710a hbPzya710a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtw7000
     */
    @Data
    protected abstract Bhtw7000 bhtw7000() ;
    
    /**
     * @return instancia da classe Bghw0150
     */
    @Data
    protected abstract Bghw0150 bghw0150() ;
    
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
    protected IString stOwndb ;
    @Data
    @Condition("D")
    protected ICondition desDgowndb ;
    @Data
    @Condition("I")
    protected ICondition tiIgowndb ;
    @Data
    @Condition("Q")
    protected ICondition cqQgowndb ;
    @Data
    @Condition("T")
    protected ICondition tTgowndb ;
    @Data
    @Condition("P")
    protected ICondition prPgowndb ;
    
    
    /**
     * COPY DE WORKING DE OBTENCAO DO NOME DO JOB
     */
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
     * @return instancia da classe local WTimestampDml
     */
    @Data
    protected abstract WTimestampDml wTimestampDml() ;
    
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
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk001 ;
    
    /**
     * 01  CONT-REG-ESCRT-FWK002       PIC S9(15) COMP-3 VALUE +0.
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk003 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk03a ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk004 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk04a ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk005 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk006 ;
    
    /**
     * 01  CONT-REG-ESCRT-FWK007       PIC S9(15) COMP-3 VALUE +0.
     * 01  CONT-REG-ESCRT-FWK008       PIC S9(15) COMP-3 VALUE +0.
     */
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
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk014 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk14a ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk015 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk016 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk017 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk018 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk019 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk19a ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk020 ;
    
    protected static final String CON_TIMER_MIN = "00.00.00.000000" ;
    
    protected static final String CON_TIMER_MAX = "23.59.59.999999" ;
    
    protected static final String CON_MESDIA_MIN = "01-01" ;
    
    protected static final String CON_MESDIA_MAX = "12-31" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    /**
     * ESTRUTURAS
     * @return instancia da classe local WsDml
     */
    @Data
    protected abstract WsDml wsDml() ;
    
    /**
     * *----------- PARA DML
     * @return instancia da classe local TabelaDb2BaldHstAct
     */
    @Data
    protected abstract TabelaDb2BaldHstAct tabelaDb2BaldHstAct() ;
    
    /**
     * @return instancia da classe local TbDb2BaldHstAct
     */
    @Data
    @Mask
    protected abstract TbDb2BaldHstAct tbDb2BaldHstAct() ;
    
    /**
     * @return instancia da classe local TabelaDb2BaldChstAct
     */
    @Data
    protected abstract TabelaDb2BaldChstAct tabelaDb2BaldChstAct() ;
    
    /**
     * @return instancia da classe local TbDb2BaldChstAct
     */
    @Data
    @Mask
    protected abstract TbDb2BaldChstAct tbDb2BaldChstAct() ;
    
    /**
     * *----------- PARA JOB
     * @return instancia da classe local SpaceDb2BaldHstAct
     */
    @Data
    protected abstract SpaceDb2BaldHstAct spaceDb2BaldHstAct() ;
    
    /**
     * @return instancia da classe local SpaceDb2BaldHstAct02
     */
    @Data
    @Mask
    protected abstract SpaceDb2BaldHstAct02 spaceDb2BaldHstAct02() ;
    
    /**
     * @return instancia da classe local SpaceDb2BaldHstCact
     */
    @Data
    protected abstract SpaceDb2BaldHstCact spaceDb2BaldHstCact() ;
    
    /**
     * @return instancia da classe local SpaceDb2BaldHstCact02
     */
    @Data
    @Mask
    protected abstract SpaceDb2BaldHstCact02 spaceDb2BaldHstCact02() ;
    
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
    protected void bhtp7000DadosSistema() {
        if (bhtw7000().sysname().isTrue()) {
            bhtp7000ObtemSysname() ;
        } else if (bhtw7000().jobname().isTrue()) {
            bhtp7000ObtemJobname() ;
        } else if (bhtw7000().jobid().isTrue()) {
            bhtp7000ObtemJobid() ;
        } else {
            bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
            bhtw7000().indicadoresErro().msgErrob().set("BHTW7000-SYS-PARM INVALIDO");
            log(TraceLevel.Trace, "BHTW7000-SYS-PARM.....= ", bhtw7000().sysParm());
            bhtp7000TrataErros() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000ObtemSysname() {
        bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
        hbPzya710a().run() ;
        if (returnCode == 0) {
            log(TraceLevel.Error, "NOME DO SISTEMA...=  ", bhtw7000().parmarea().area8());
        } else {
            bhtw7000().indicadoresErro().msgErrob().set("ERRO AO OBTER NOME DO SYS");
            bhtp7000TrataErros() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000ObtemJobname() {
        bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
        hbPzya710a().run() ;
        if (returnCode == 0) {
            log(TraceLevel.Error, "NOME DO JOB........= ", bhtw7000().parmarea().area8());
        } else {
            bhtw7000().indicadoresErro().msgErrob().set("ERRO AO OBTER NOME DO JOB");
            bhtp7000TrataErros() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000ObtemJobid() {
        bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
        hbPzya710a().run() ;
        if (returnCode == 0) {
            log(TraceLevel.Error, "ID DO JOB..........= ", bhtw7000().parmarea().area8());
        } else {
            bhtw7000().indicadoresErro().msgErrob().set("ERRO AO OBTER JOBID   ");
            bhtp7000TrataErros() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000TrataErros() {
        bhtw7000().indicadoresErro().modOrigemErro().set(bhtw7000().pgmname());
        bhtw7000().indicadoresErro().cRtnoEvenSwal().set(bhtk0001().erros().dadosInvalidos());
        bhtw7000().indicadoresErro().abend().setTrue() ;
        bhtw7000().indicadoresErro().aAplErr().set(bhtk0002().siglaArquit());
        bhtw7000().indicadoresErro().chAcesso().set(bhtw7000().parmarea());
        log(TraceLevel.Trace, "RETURN-CODE........= ", returnCode);
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ666A");
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
        wsVariaveis().wsZaBaldActivo().set(subtract(wTimestamp().wDataTimestamp().wAnoAa(), 3));
        wsVariaveis().wsZaBaldNormal().set(subtract(wTimestamp().wDataTimestamp().wAnoAa(), 9));
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
            a14000ObtemJobName() ;
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
    protected void a13000AbrirFicheiros() {
        log(TraceLevel.Debug, "A13000-ABRIR-FICHEIROS");
        fwk001().open(CREATE ) ;
        if (!fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK001 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
        /**
         * IF PROG-OK
         * OPEN OUTPUT FWK002
         * IF NOT FWK002-STATUS-OK
         * MOVE +16                 TO RETURN-CODE
         * PROG-STATUS
         * MOVE 'PGHQ666A - FWK002 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK002                 TO IMP-STATUS
         * END-IF
         */
        if (progOk.isTrue()) {
            fwk003().open(CREATE ) ;
            if (!fwk003().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK003 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk03a().open(CREATE ) ;
            if (!fwk03a().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK03A - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk03a().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk004().open(CREATE ) ;
            if (!fwk004().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK004 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk004().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk04a().open(CREATE ) ;
            if (!fwk04a().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK04A - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk04a().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk005().open(CREATE ) ;
            if (!fwk005().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK005 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk005().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk006().open(CREATE ) ;
            if (!fwk006().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK006 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk006().getStatus());
            }
        }
        /**
         * IF PROG-OK
         * OPEN OUTPUT FWK007
         * IF NOT FWK007-STATUS-OK
         * MOVE +16                 TO RETURN-CODE
         * PROG-STATUS
         * MOVE 'PGHQ666A - FWK007 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK007                 TO IMP-STATUS
         * END-IF
         * OPEN OUTPUT FWK008
         * IF NOT FWK008-STATUS-OK
         * MOVE 'PGHQ666A - FWK008 - OPEN - ' TO MSG-STATUS
         * MOVE STATUS-FWK008                 TO IMP-STATUS
         */
        if (progOk.isTrue()) {
            fwk009().open(CREATE ) ;
            if (!fwk009().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK009 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk009().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk010().open(CREATE ) ;
            if (!fwk010().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK010 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk010().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk011().open(CREATE ) ;
            if (!fwk011().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK011 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk011().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk012().open(CREATE ) ;
            if (!fwk012().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK012 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk012().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk013().open(CREATE ) ;
            if (!fwk013().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK013 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk013().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk014().open(CREATE ) ;
            if (!fwk014().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK014 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk014().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk14a().open(CREATE ) ;
            if (!fwk14a().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK14A - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk14a().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk015().open(CREATE ) ;
            if (!fwk015().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK015 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk015().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk016().open(CREATE ) ;
            if (!fwk016().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK016 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk016().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk017().open(CREATE ) ;
            if (!fwk017().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK017 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk017().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk018().open(CREATE ) ;
            if (!fwk018().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK018 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk018().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk019().open(CREATE ) ;
            if (!fwk019().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK019 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk019().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk19a().open(CREATE ) ;
            if (!fwk19a().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK019 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk19a().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk020().open(CREATE ) ;
            if (!fwk020().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK020 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk020().getStatus());
            }
        }
    }
    
    /**
     * 
     * *A14000-OBTEM-JOB-NAME.
     * 
     */
    protected void a14000ObtemJobName() {
        log(TraceLevel.Debug, "A14000-OBTEM-JOB-NAME");
        bhtw7000().jobname().setTrue() ;
        bhtp7000DadosSistema() ;
        if (bhtw7000().indicadoresErro().semErros().isTrue()) {
            wsVariaveis().wsJobname().set(bhtw7000().parmarea().area8());
            switch (wsVariaveis().wsJobname().get(1, 1).get()) {
                case "D":
                    desDgowndb.setTrue() ;
                    break;
                case "G":
                    tiIgowndb.setTrue() ;
                    break;
                case "T":
                    cqQgowndb.setTrue() ;
                    break;
                case "K":
                    tTgowndb.setTrue() ;
                    break;
                case "E":
                    prPgowndb.setTrue() ;
                    break;
                default :
                    break ;
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - A14000-OBTEM-JOB-NAME");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            wsVariaveis().wsCRtnoEvenSwal().set(bhtw7000().indicadoresErro().cRtnoEvenSwal());
            tabelaImpressao().linha10().msgLivre().set(concat(" ", bhtw7000().indicadoresErro().cTipoErroBbn(), " ", bhtw7000().indicadoresErro().aAplErr(), " ", wsVariaveis().wsCRtnoEvenSwal(), " "));
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        a30100TrataFwk001() ;
        /**
         * IF PROG-OK
         * PERFORM A30200-TRATA-FWK002
         * END-IF
         */
        if (progOk.isTrue()) {
            a30300TrataFwk03a() ;
            a30300TrataFwk003() ;
        }
        if (progOk.isTrue()) {
            a30400TrataFwk04a() ;
            a30400TrataFwk004() ;
        }
        if (progOk.isTrue()) {
            a30500TrataFwk005() ;
        }
        if (progOk.isTrue()) {
            a30600TrataFwk006() ;
        }
        /**
         * IF PROG-OK
         * PERFORM A30700-TRATA-FWK007
         * END-IF
         * PERFORM A30800-TRATA-FWK008
         */
        if (progOk.isTrue()) {
            a30900TrataFwk009() ;
        }
        if (progOk.isTrue()) {
            a31000TrataFwk010() ;
        }
        if (progOk.isTrue()) {
            a31100TrataFwk011() ;
        }
        if (progOk.isTrue()) {
            a31200TrataFwk012() ;
        }
        if (progOk.isTrue()) {
            a31300TrataFwk013() ;
        }
        if (progOk.isTrue()) {
            a31400TrataFwk14a() ;
            a31400TrataFwk014() ;
        }
        if (progOk.isTrue()) {
            a31500TrataFwk015() ;
        }
        if (progOk.isTrue()) {
            a31600TrataFwk016() ;
        }
        if (progOk.isTrue()) {
            a31700TrataFwk017() ;
        }
        if (progOk.isTrue()) {
            a31800TrataFwk018() ;
        }
        if (progOk.isTrue()) {
            a31900TrataFwk19a() ;
            a31900TrataFwk019() ;
        }
        if (progOk.isTrue()) {
            a32000TrataFwk020() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30100TrataFwk001() {
        log(TraceLevel.Debug, "A30100-TRATA-FWK001");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set("SELECT *");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set(concat("FROM ", stOwndb, "GOWNDB.TGH00010_CONTIPHST"));
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set(concat("WHERE (ZA_INICIO = ", wsVariaveis().wsZaBaldActivo(), ")"));
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set(concat("OR (ZA_INICIO = ", wsVariaveis().wsZaBaldNormal(), ")"));
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("ORDER BY C_PAIS_ISOA_CONT");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,C_BANC_CONT      ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,C_OE_EGC_CONT    ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,NS_RDCL_CONT     ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,V_CHKD_CONT      ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,C_TIPO_CONT      ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,C_MOED_ISO_SCTA  ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,NS_DEPOSITO      ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set("       ,ZA_INICIO        ");
        a30101EscreverFwk001() ;
        wsDml().wsDmlLinha().set(";");
        a30101EscreverFwk001() ;
    }
    
    /**
     * 
     * *A30200-TRATA-FWK002.
     * IF SW-DEBUG-ON
     * DISPLAY 'A30200-TRATA-FWK002'
     * END-IF
     * INITIALIZE WS-DML REPLACING ALPHANUMERIC BY SPACES
     * STRING "DELETE FROM PGOWNDB.TGH00010_CONTIPHST"
     * DELIMITED BY SIZE INTO WS-DML-LINHA
     * PERFORM A30202-ESCREVER-FWK002
     * SET I-HST-A                 TO 1
     * SEARCH ITEM-HST-A AT END
     * MOVE +16            TO RETURN-CODE
     * PROG-STATUS
     * MOVE ']]] RECURSO BALDEAMENTO INEXISTENTE ]]]'
     * TO MSG-STATUS
     * WHEN WS-ZA-BALD-ACTIVO = TAB-ZA-ANO-ACT(I-HST-A)
     * MOVE TAB-NM-RECURSO-ACT(I-HST-A)
     * TO WS-NM-RECURSO
     * END-SEARCH
     * STRING "WHERE (NM_RECURSO = '"WS-NM-RECURSO"')"
     * STRING "OR (NM_RECURSO = '"CON-VGH00201"')"
     * MOVE ";"
     * TO WS-DML-LINHA
     * 
     */
    protected void a30300TrataFwk003() {
        log(TraceLevel.Debug, "A30300-TRATA-FWK003");
        wsDml().initialize() ;
        bghw0150().tbBaldHstAct().itemHstA().resetIndex() ;
        while (bghw0150().tbBaldHstAct().itemHstA().index().isLessOrEqual(30)) {
            if (wsVariaveis().wsZaBaldActivo().isEqual(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabZaAnoAct())) {
                wsVariaveis().wsNmRecurso().set(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabNmRecursoAct());
                break;
            }
            bghw0150().tbBaldHstAct().itemHstA().incIndex() ;
        }
        if (bghw0150().tbBaldHstAct().itemHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE ]]]");
        }
        tbDb2BaldHstAct().itemDb2HstA().resetIndex() ;
        while (tbDb2BaldHstAct().itemDb2HstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(tbDb2BaldHstAct().itemDb2HstA().getCurrent().tabDb2ViewAct())) {
                wsVariaveis().wsDb2NmRecurso().set(tbDb2BaldHstAct().itemDb2HstA().getCurrent().tabDb2NmRecursoAct());
                break;
            }
            tbDb2BaldHstAct().itemDb2HstA().incIndex() ;
        }
        if (tbDb2BaldHstAct().itemDb2HstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 2 ]]]");
        }
        wsDml().initialize() ;
        /**
         * STRING "              LOAD"
         * DELIMITED BY SIZE INTO WS-DML-LINHA
         * PERFORM A30303-ESCREVER-FWK003
         * STRING "              PRELOAD PAUSE ANYDISCARDS RETCODE 11"
         * STRING "           RESUME YES"
         * STRING "              INDDN SYSREC"
         * STRING "              DISCARDS 1"
         * STRING "              ORDER YES"
         * STRING "              REDEFINE YES"
         * STRING "              COPY NO"
         * STRING "              COPYPEND NO"
         */
        wsDml().wsDmlLinha().set(concat("             ", stOwndb, "GOWNDB.", wsVariaveis().wsDb2NmRecurso()));
        a30303EscreverFwk003() ;
    }
    
    /**
     * 
     * 
     */
    protected void a30300TrataFwk03a() {
        log(TraceLevel.Debug, "A30300-TRATA-FWK03A");
        wsDml().initialize() ;
        bghw0150().tbBaldHstAct().itemHstA().resetIndex() ;
        while (bghw0150().tbBaldHstAct().itemHstA().index().isLessOrEqual(30)) {
            if (wsVariaveis().wsZaBaldActivo().isEqual(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabZaAnoAct())) {
                wsVariaveis().wsNmRecurso().set(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabNmRecursoAct());
                break;
            }
            bghw0150().tbBaldHstAct().itemHstA().incIndex() ;
        }
        if (bghw0150().tbBaldHstAct().itemHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE ]]]");
        }
        tbDb2BaldHstAct().itemDb2HstA().resetIndex() ;
        while (tbDb2BaldHstAct().itemDb2HstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(tbDb2BaldHstAct().itemDb2HstA().getCurrent().tabDb2ViewAct())) {
                wsVariaveis().wsDb2NmRecurso().set(tbDb2BaldHstAct().itemDb2HstA().getCurrent().tabDb2NmRecursoAct());
                break;
            }
            tbDb2BaldHstAct().itemDb2HstA().incIndex() ;
        }
        if (tbDb2BaldHstAct().itemDb2HstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 2 ]]]");
        }
        spaceDb2BaldHstAct02().itemSpcHstA().resetIndex() ;
        while (spaceDb2BaldHstAct02().itemSpcHstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2ViewAct())) {
                wsVariaveis().wsSpcNmRecurso().set(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2NmRecursoAct());
                break;
            }
            spaceDb2BaldHstAct02().itemSpcHstA().incIndex() ;
        }
        if (spaceDb2BaldHstAct02().itemSpcHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().wsDmlLinha().set(concat("             ", stOwndb, "GDGH020.", wsVariaveis().wsSpcNmRecurso()));
        a30303EscreverFwk03a() ;
    }
    
    /**
     * 
     * 
     */
    protected void a30400TrataFwk004() {
        log(TraceLevel.Debug, "A30400-TRATA-FWK004");
        wsDml().initialize() ;
        tbDb2BaldChstAct().itemDb2ChstA().resetIndex() ;
        while (tbDb2BaldChstAct().itemDb2ChstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(tbDb2BaldChstAct().itemDb2ChstA().getCurrent().tabDb2ViewCact())) {
                wsVariaveis().wsDb2NmRecursoC().set(tbDb2BaldChstAct().itemDb2ChstA().getCurrent().tabDb2NmRecursoCact());
                break;
            }
            tbDb2BaldChstAct().itemDb2ChstA().incIndex() ;
        }
        if (tbDb2BaldChstAct().itemDb2ChstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().initialize() ;
        /**
         * STRING "              LOAD"
         * DELIMITED BY SIZE INTO WS-DML-LINHA
         * PERFORM A30404-ESCREVER-FWK004
         * STRING "              PRELOAD PAUSE ANYDISCARDS RETCODE 11"
         * STRING "           RESUME YES"
         * STRING "              INDDN SYSREC"
         * STRING "              DISCARDS 1"
         * STRING "              ORDER YES"
         * STRING "              REDEFINE YES"
         * STRING "              COPY NO"
         * STRING "              COPYPEND NO"
         * STRING "              NOCOPYPEND"
         * STRING "              INTO TABLE "ST-OWNDB"GOWNDB."
         * WS-DB2-NM-RECURSO-C
         */
        wsDml().wsDmlLinha().set(concat("               ", stOwndb, "GOWNDB.", wsVariaveis().wsDb2NmRecursoC()));
        a30404EscreverFwk004() ;
    }
    
    /**
     * 
     * 
     */
    protected void a30400TrataFwk04a() {
        log(TraceLevel.Debug, "A30400-TRATA-FWK04A");
        wsDml().initialize() ;
        spaceDb2BaldHstAct02().itemSpcHstA().resetIndex() ;
        while (spaceDb2BaldHstAct02().itemSpcHstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2ViewAct())) {
                wsVariaveis().wsSpcNmRecurso().set(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2NmRecursoAct());
                break;
            }
            spaceDb2BaldHstAct02().itemSpcHstA().incIndex() ;
        }
        if (spaceDb2BaldHstAct02().itemSpcHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        spaceDb2BaldHstCact02().itemSpcChstA().resetIndex() ;
        while (spaceDb2BaldHstCact02().itemSpcChstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstCact02().itemSpcChstA().getCurrent().spaceDb2ViewCact())) {
                wsVariaveis().wsSpcNmRecursoC().set(spaceDb2BaldHstCact02().itemSpcChstA().getCurrent().spaceDb2NmRecursoCact());
                break;
            }
            spaceDb2BaldHstCact02().itemSpcChstA().incIndex() ;
        }
        if (spaceDb2BaldHstCact02().itemSpcChstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set(concat("               ", stOwndb, "GDGH120.", wsVariaveis().wsSpcNmRecursoC()));
        a30404EscreverFwk04a() ;
    }
    
    /**
     * 
     * 
     */
    protected void a30500TrataFwk005() {
        log(TraceLevel.Debug, "A30500-TRATA-FWK005");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set("SELECT *");
        a30505EscreverFwk005() ;
        wsDml().wsDmlLinha().set(concat("FROM ", stOwndb, "GOWNDB.TGH00002_MOVHST"));
        a30505EscreverFwk005() ;
        wsDml().wsDmlLinha().set(concat("WHERE TS_MOVIMENTO >= ", wsVariaveis().wsZaBaldActivo(), "-01-01-00.00.00.000000"));
        a30505EscreverFwk005() ;
        wsDml().wsDmlLinha().set(concat("  AND TS_MOVIMENTO <= ", wsVariaveis().wsZaBaldActivo(), "-12-31-23.59.59.999999"));
        a30505EscreverFwk005() ;
        wsDml().wsDmlLinha().set(";");
        a30505EscreverFwk005() ;
    }
    
    /**
     * 
     * 
     */
    protected void a30600TrataFwk006() {
        log(TraceLevel.Debug, "A30600-TRATA-FWK006");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set("SELECT *");
        a30606EscreverFwk006() ;
        wsDml().wsDmlLinha().set(concat("FROM ", stOwndb, "GOWNDB.TGH00002_MOVHST"));
        a30606EscreverFwk006() ;
        wsDml().wsDmlLinha().set(concat("WHERE TS_MOVIMENTO > ", wsVariaveis().wsZaBaldActivo(), "-12-31-23.59.59.999999"));
        a30606EscreverFwk006() ;
        wsDml().wsDmlLinha().set(";");
        a30606EscreverFwk006() ;
    }
    
    /**
     * 
     * *A30700-TRATA-FWK007.
     * IF SW-DEBUG-ON
     * DISPLAY 'A30700-TRATA-FWK007'
     * END-IF
     * INITIALIZE WS-DML REPLACING ALPHANUMERIC BY SPACES
     * MOVE 'SELECT *'
     * TO WS-DML-LINHA
     * PERFORM A30707-ESCREVER-FWK007
     * MOVE 'FROM PGOWNDB.TGH00010_CONTIPHST'
     * STRING "WHERE ZA_INICIO   = '"WS-ZA-BALD-ACTIVO"'"
     * DELIMITED BY SIZE INTO WS-DML-LINHA
     * MOVE ';'
     * *A30800-TRATA-FWK008.
     * DISPLAY 'A30800-TRATA-FWK008'
     * PERFORM A30808-ESCREVER-FWK008
     * STRING "WHERE NM_RECURSO  = '"WS-NM-RECURSO"'"
     * 
     */
    protected void a30900TrataFwk009() {
        log(TraceLevel.Debug, "A30900-TRATA-FWK009");
        wsDml().initialize() ;
        bghw0150().tbBaldHstAct().itemHstA().resetIndex() ;
        while (bghw0150().tbBaldHstAct().itemHstA().index().isLessOrEqual(30)) {
            if (wsVariaveis().wsZaBaldActivo().isEqual(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabZaAnoAct())) {
                wsVariaveis().wsNmRecurso().set(bghw0150().tbBaldHstAct().itemHstA().getCurrent().tabNmRecursoAct());
                break;
            }
            bghw0150().tbBaldHstAct().itemHstA().incIndex() ;
        }
        if (bghw0150().tbBaldHstAct().itemHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE ]]]");
        }
        tbDb2BaldHstAct().itemDb2HstA().resetIndex() ;
        while (tbDb2BaldHstAct().itemDb2HstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(tbDb2BaldHstAct().itemDb2HstA().getCurrent().tabDb2ViewAct())) {
                wsVariaveis().wsDb2NmRecurso().set(tbDb2BaldHstAct().itemDb2HstA().getCurrent().tabDb2NmRecursoAct());
                break;
            }
            tbDb2BaldHstAct().itemDb2HstA().incIndex() ;
        }
        if (tbDb2BaldHstAct().itemDb2HstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 2 ]]]");
        }
        wsDml().wsDmlLinha().set("SELECT *");
        a30909EscreverFwk009() ;
        wsDml().wsDmlLinha().set(concat("FROM ", stOwndb, "GOWNDB.", wsVariaveis().wsDb2NmRecurso()));
        a30909EscreverFwk009() ;
        wsDml().wsDmlLinha().set(";");
        a30909EscreverFwk009() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31000TrataFwk010() {
        log(TraceLevel.Debug, "A31000-TRATA-FWK010");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set("SELECT *");
        a31010EscreverFwk010() ;
        wsDml().wsDmlLinha().set(concat("FROM ", stOwndb, "GOWNDB.TGH00102_MOVHSTCPL"));
        a31010EscreverFwk010() ;
        wsDml().wsDmlLinha().set(concat("WHERE TS_MOVIMENTO >= ", wsVariaveis().wsZaBaldActivo(), "-01-01-00.00.00.000000"));
        a31010EscreverFwk010() ;
        wsDml().wsDmlLinha().set(concat("  AND TS_MOVIMENTO <= ", wsVariaveis().wsZaBaldActivo(), "-12-31-23.59.59.999999"));
        a31010EscreverFwk010() ;
        wsDml().wsDmlLinha().set(";");
        a31010EscreverFwk010() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31100TrataFwk011() {
        log(TraceLevel.Debug, "A31100-TRATA-FWK011");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set("SELECT *");
        a31111EscreverFwk011() ;
        wsDml().wsDmlLinha().set(concat("FROM ", stOwndb, "GOWNDB.TGH00102_MOVHSTCPL"));
        a31111EscreverFwk011() ;
        wsDml().wsDmlLinha().set(concat("WHERE TS_MOVIMENTO > ", wsVariaveis().wsZaBaldActivo(), "-12-31-23.59.59.999999"));
        a31111EscreverFwk011() ;
        wsDml().wsDmlLinha().set(";");
        a31111EscreverFwk011() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31200TrataFwk012() {
        log(TraceLevel.Debug, "A31200-TRATA-FWK012");
        wsDml().initialize() ;
        tbDb2BaldChstAct().itemDb2ChstA().resetIndex() ;
        while (tbDb2BaldChstAct().itemDb2ChstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(tbDb2BaldChstAct().itemDb2ChstA().getCurrent().tabDb2ViewCact())) {
                wsVariaveis().wsDb2NmRecursoC().set(tbDb2BaldChstAct().itemDb2ChstA().getCurrent().tabDb2NmRecursoCact());
                break;
            }
            tbDb2BaldChstAct().itemDb2ChstA().incIndex() ;
        }
        if (tbDb2BaldChstAct().itemDb2ChstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().wsDmlLinha().set("SELECT *");
        a31212EscreverFwk012() ;
        wsDml().wsDmlLinha().set(concat("FROM ", stOwndb, "GOWNDB.", wsVariaveis().wsDb2NmRecursoC()));
        a31212EscreverFwk012() ;
        wsDml().wsDmlLinha().set(";");
        a31212EscreverFwk012() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31300TrataFwk013() {
        log(TraceLevel.Debug, "A31300-TRATA-FWK013");
        wsDml().initialize() ;
        spaceDb2BaldHstAct02().itemSpcHstA().resetIndex() ;
        while (spaceDb2BaldHstAct02().itemSpcHstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2ViewAct())) {
                wsVariaveis().wsSpcNmRecurso().set(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2NmRecursoAct());
                break;
            }
            spaceDb2BaldHstAct02().itemSpcHstA().incIndex() ;
        }
        if (spaceDb2BaldHstAct02().itemSpcHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().wsDmlLinha().set(concat("-START DB(", stOwndb, "GDGH020) SPACE(", wsVariaveis().wsSpcNmRecurso(), ") ACCESS(UT)"));
        log(TraceLevel.Trace, "WS-DML-LINHA: ", wsDml().wsDmlLinha());
        a31313EscreverFwk013() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31400TrataFwk014() {
        log(TraceLevel.Debug, "A31400-TRATA-FWK014");
        wsDml().initialize() ;
        /**
         * STRING "              LOAD"
         * DELIMITED BY SIZE INTO WS-DML-LINHA
         * PERFORM A31414-ESCREVER-FWK014
         * STRING "              PRELOAD PAUSE ANYDISCARDS RETCODE 11"
         * STRING "              RESUME YES"
         * STRING "              INDDN SYSREC"
         * STRING "              DISCARDS 1"
         * STRING "              ORDER YES"
         * STRING "              REDEFINE YES"
         * STRING "              COPY NO"
         * STRING "              COPYPEND NO"
         * STRING "              INTO TABLE "ST-OWNDB"GOWNDB."
         * WS-DB2-NM-RECURSO
         */
        wsDml().wsDmlLinha().set(concat("              ", stOwndb, "GOWNDB.", wsVariaveis().wsDb2NmRecurso()));
        a31414EscreverFwk014() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31400TrataFwk14a() {
        log(TraceLevel.Debug, "A31400-TRATA-FWK14A");
        wsDml().initialize() ;
        spaceDb2BaldHstAct02().itemSpcHstA().resetIndex() ;
        while (spaceDb2BaldHstAct02().itemSpcHstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2ViewAct())) {
                wsVariaveis().wsSpcNmRecurso().set(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2NmRecursoAct());
                break;
            }
            spaceDb2BaldHstAct02().itemSpcHstA().incIndex() ;
        }
        if (spaceDb2BaldHstAct02().itemSpcHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().wsDmlLinha().set(concat("              ", stOwndb, "GDGH020.", wsVariaveis().wsSpcNmRecurso()));
        a31414EscreverFwk14a() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31500TrataFwk015() {
        log(TraceLevel.Debug, "A31500-TRATA-FWK015");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set(concat("              COPY  TABLESPACE ", stOwndb, "GDGH020.", wsVariaveis().wsSpcNmRecurso()));
        a31515EscreverFwk015() ;
        wsDml().wsDmlLinha().set("              COPYDDN (LOCALP)");
        a31515EscreverFwk015() ;
        wsDml().wsDmlLinha().set("              SHRLEVEL CHANGE");
        a31515EscreverFwk015() ;
        wsDml().wsDmlLinha().set("              FULL  YES");
        a31515EscreverFwk015() ;
        wsDml().wsDmlLinha().set("              GROUP YES");
        a31515EscreverFwk015() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31600TrataFwk016() {
        log(TraceLevel.Debug, "A31600-TRATA-FWK016");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set(concat("-START DB(", stOwndb, "GDGH020) SPACE(", wsVariaveis().wsSpcNmRecurso(), ") ACCESS(RW)"));
        a31616EscreverFwk016() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31700TrataFwk017() {
        log(TraceLevel.Debug, "A31700-TRATA-FWK017");
        wsDml().initialize() ;
        spaceDb2BaldHstCact02().itemSpcChstA().resetIndex() ;
        while (spaceDb2BaldHstCact02().itemSpcChstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstCact02().itemSpcChstA().getCurrent().spaceDb2ViewCact())) {
                wsVariaveis().wsSpcNmRecursoC().set(spaceDb2BaldHstCact02().itemSpcChstA().getCurrent().spaceDb2NmRecursoCact());
                break;
            }
            spaceDb2BaldHstCact02().itemSpcChstA().incIndex() ;
        }
        if (spaceDb2BaldHstCact02().itemSpcChstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().wsDmlLinha().set(concat("-START DB(", stOwndb, "GDGH120) SPACE(", wsVariaveis().wsSpcNmRecursoC(), ") ACCESS(UT)"));
        a31717EscreverFwk017() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31800TrataFwk018() {
        log(TraceLevel.Debug, "A31800-TRATA-FWK018");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set(concat("              COPY  TABLESPACE ", stOwndb, "GDGH120.", wsVariaveis().wsSpcNmRecursoC()));
        a31818EscreverFwk018() ;
        wsDml().wsDmlLinha().set("              COPYDDN (LOCALP)");
        a31818EscreverFwk018() ;
        wsDml().wsDmlLinha().set("              SHRLEVEL CHANGE");
        a31818EscreverFwk018() ;
        wsDml().wsDmlLinha().set("              FULL  YES");
        a31818EscreverFwk018() ;
        wsDml().wsDmlLinha().set("              GROUP YES");
        a31818EscreverFwk018() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31900TrataFwk019() {
        log(TraceLevel.Debug, "A31900-TRATA-FWK019");
        wsDml().initialize() ;
        /**
         * STRING "              LOAD"
         * DELIMITED BY SIZE INTO WS-DML-LINHA
         * PERFORM A31919-ESCREVER-FWK019
         * STRING "              PRELOAD PAUSE ANYDISCARDS RETCODE 11"
         * STRING "              RESUME YES"
         * STRING "              INDDN SYSREC"
         * STRING "              DISCARDS 1"
         * STRING "              ORDER YES"
         * STRING "              REDEFINE YES"
         * STRING "              COPY NO"
         * STRING "              COPYPEND NO"
         * STRING "              INTO TABLE "ST-OWNDB"GOWNDB."
         * WS-DB2-NM-RECURSO-C
         */
        wsDml().wsDmlLinha().set(concat("              ", stOwndb, "GOWNDB.", wsVariaveis().wsDb2NmRecursoC()));
        a31919EscreverFwk019() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31900TrataFwk19a() {
        log(TraceLevel.Debug, "A31900-TRATA-FWK19A");
        wsDml().initialize() ;
        spaceDb2BaldHstAct02().itemSpcHstA().resetIndex() ;
        while (spaceDb2BaldHstAct02().itemSpcHstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2ViewAct())) {
                wsVariaveis().wsSpcNmRecurso().set(spaceDb2BaldHstAct02().itemSpcHstA().getCurrent().spaceDb2NmRecursoAct());
                break;
            }
            spaceDb2BaldHstAct02().itemSpcHstA().incIndex() ;
        }
        if (spaceDb2BaldHstAct02().itemSpcHstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        spaceDb2BaldHstCact02().itemSpcChstA().resetIndex() ;
        while (spaceDb2BaldHstCact02().itemSpcChstA().index().isLessOrEqual(6)) {
            if (wsVariaveis().wsNmRecurso().isEqual(spaceDb2BaldHstCact02().itemSpcChstA().getCurrent().spaceDb2ViewCact())) {
                wsVariaveis().wsSpcNmRecursoC().set(spaceDb2BaldHstCact02().itemSpcChstA().getCurrent().spaceDb2NmRecursoCact());
                break;
            }
            spaceDb2BaldHstCact02().itemSpcChstA().incIndex() ;
        }
        if (spaceDb2BaldHstCact02().itemSpcChstA().atEnd()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("]]] RECURSO BALDEAMENTO INEXISTENTE 3 ]]]");
        }
        wsDml().wsDmlLinha().set(concat("              ", stOwndb, "GDGH120.", wsVariaveis().wsSpcNmRecursoC()));
        a31919EscreverFwk19a() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32000TrataFwk020() {
        log(TraceLevel.Debug, "A32000-TRATA-FWK020");
        wsDml().initialize() ;
        wsDml().wsDmlLinha().set(concat("-START DB(", stOwndb, "GDGH120) SPACE(", wsVariaveis().wsSpcNmRecursoC(), ") ACCESS(RW)"));
        a32020EscreverFwk020() ;
    }
    
    /**
     * 
     * 
     */
    protected void a30101EscreverFwk001() {
        log(TraceLevel.Debug, "A30101-ESCREVER-FWK001");
        fwk001().regFwk00180.initialize() ;
        fwk001().setRecord(wsDml()) ;
        fwk001().write(fwk001().regFwk00180) ;
        if (fwk001().getStatusOk()) {
            contRegEscrtFwk001.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK001 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
    }
    
    /**
     * 
     * *A30202-ESCREVER-FWK002.
     * IF SW-DEBUG-ON
     * DISPLAY 'A30202-ESCREVER-FWK002'
     * END-IF
     * INITIALIZE REG-FWK002
     * MOVE WS-DML             TO REG-FWK002
     * WRITE REG-FWK002
     * IF FWK002-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK002
     * INITIALIZE WS-DML REPLACING ALPHANUMERIC BY SPACES
     * ELSE
     * MOVE +16             TO RETURN-CODE
     * PROG-STATUS
     * MOVE 'PGHQ666A - FWK002 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK002   TO IMP-STATUS
     * 
     */
    protected void a30303EscreverFwk003() {
        log(TraceLevel.Debug, "A30303-ESCREVER-FWK003");
        fwk003().regFwk00380.initialize() ;
        fwk003().setRecord(wsDml()) ;
        fwk003().write(fwk003().regFwk00380) ;
        if (fwk003().getStatusOk()) {
            contRegEscrtFwk003.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK003 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30303EscreverFwk03a() {
        log(TraceLevel.Debug, "A30303-ESCREVER-FWK03A");
        fwk03a().regFwk03a80.initialize() ;
        fwk03a().setRecord(wsDml()) ;
        fwk03a().write(fwk03a().regFwk03a80) ;
        if (fwk03a().getStatusOk()) {
            contRegEscrtFwk03a.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK03A - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk03a().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30404EscreverFwk004() {
        log(TraceLevel.Debug, "A30404-ESCREVER-FWK004");
        fwk004().regFwk00480.initialize() ;
        fwk004().setRecord(wsDml()) ;
        fwk004().write(fwk004().regFwk00480) ;
        if (fwk004().getStatusOk()) {
            contRegEscrtFwk004.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK004 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk004().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30404EscreverFwk04a() {
        log(TraceLevel.Debug, "A30404-ESCREVER-FWK04A");
        fwk04a().regFwk04a80.initialize() ;
        fwk04a().setRecord(wsDml()) ;
        fwk04a().write(fwk04a().regFwk04a80) ;
        if (fwk04a().getStatusOk()) {
            contRegEscrtFwk04a.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK04A - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk04a().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30505EscreverFwk005() {
        log(TraceLevel.Debug, "A30505-ESCREVER-FWK005");
        fwk005().regFwk00580.initialize() ;
        fwk005().setRecord(wsDml()) ;
        fwk005().write(fwk005().regFwk00580) ;
        if (fwk005().getStatusOk()) {
            contRegEscrtFwk005.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK005 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk005().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30606EscreverFwk006() {
        log(TraceLevel.Debug, "A30606-ESCREVER-FWK006");
        fwk006().regFwk00680.initialize() ;
        fwk006().setRecord(wsDml()) ;
        fwk006().write(fwk006().regFwk00680) ;
        if (fwk006().getStatusOk()) {
            contRegEscrtFwk006.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK006 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk006().getStatus());
        }
    }
    
    /**
     * 
     * *A30707-ESCREVER-FWK007.
     * IF SW-DEBUG-ON
     * DISPLAY 'A30707-ESCREVER-FWK007'
     * END-IF
     * INITIALIZE REG-FWK007
     * MOVE WS-DML             TO REG-FWK007
     * WRITE REG-FWK007
     * IF FWK007-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK007
     * INITIALIZE WS-DML REPLACING ALPHANUMERIC BY SPACES
     * ELSE
     * MOVE +16             TO RETURN-CODE
     * PROG-STATUS
     * MOVE 'PGHQ666A - FWK007 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK007   TO IMP-STATUS
     * *A30808-ESCREVER-FWK008.
     * DISPLAY 'A30808-ESCREVER-FWK008'
     * INITIALIZE REG-FWK008
     * MOVE WS-DML             TO REG-FWK008
     * WRITE REG-FWK008
     * IF FWK008-STATUS-OK
     * ADD +1               TO CONT-REG-ESCRT-FWK008
     * MOVE 'PGHQ666A - FWK008 - WRITE   - ' TO MSG-STATUS
     * MOVE STATUS-FWK008   TO IMP-STATUS
     * 
     */
    protected void a30909EscreverFwk009() {
        log(TraceLevel.Debug, "A30909-ESCREVER-FWK009");
        fwk009().regFwk00980.initialize() ;
        fwk009().setRecord(wsDml()) ;
        fwk009().write(fwk009().regFwk00980) ;
        if (fwk009().getStatusOk()) {
            contRegEscrtFwk009.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK009-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk009().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31010EscreverFwk010() {
        log(TraceLevel.Debug, "A31010-ESCREVER-FWK010");
        fwk010().regFwk01080.initialize() ;
        fwk010().setRecord(wsDml()) ;
        fwk010().write(fwk010().regFwk01080) ;
        if (fwk010().getStatusOk()) {
            contRegEscrtFwk010.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK010-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk010().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31111EscreverFwk011() {
        log(TraceLevel.Debug, "A31111-ESCREVER-FWK011");
        fwk011().regFwk01180.initialize() ;
        fwk011().setRecord(wsDml()) ;
        fwk011().write(fwk011().regFwk01180) ;
        if (fwk011().getStatusOk()) {
            contRegEscrtFwk011.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK011-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk011().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31212EscreverFwk012() {
        log(TraceLevel.Debug, "A31212-ESCREVER-FWK012");
        fwk012().regFwk01280.initialize() ;
        fwk012().setRecord(wsDml()) ;
        fwk012().write(fwk012().regFwk01280) ;
        if (fwk012().getStatusOk()) {
            contRegEscrtFwk012.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK012-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk012().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31313EscreverFwk013() {
        log(TraceLevel.Debug, "A31313-ESCREVER-FWK013");
        fwk013().regFwk01380.initialize() ;
        fwk013().setRecord(wsDml()) ;
        fwk013().write(fwk013().regFwk01380) ;
        if (fwk013().getStatusOk()) {
            contRegEscrtFwk013.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK013-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk013().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31414EscreverFwk014() {
        log(TraceLevel.Debug, "A31414-ESCREVER-FWK014");
        fwk014().regFwk01480.initialize() ;
        fwk014().setRecord(wsDml()) ;
        fwk014().write(fwk014().regFwk01480) ;
        if (fwk014().getStatusOk()) {
            contRegEscrtFwk014.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK014-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk014().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31414EscreverFwk14a() {
        log(TraceLevel.Debug, "A31414-ESCREVER-FWK14A");
        fwk14a().regFwk14a80.initialize() ;
        fwk14a().setRecord(wsDml()) ;
        fwk14a().write(fwk14a().regFwk14a80) ;
        if (fwk14a().getStatusOk()) {
            contRegEscrtFwk14a.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK14A-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk14a().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31515EscreverFwk015() {
        log(TraceLevel.Debug, "A31515-ESCREVER-FWK015");
        fwk015().regFwk01580.initialize() ;
        fwk015().setRecord(wsDml()) ;
        fwk015().write(fwk015().regFwk01580) ;
        if (fwk015().getStatusOk()) {
            contRegEscrtFwk015.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK015-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk015().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31616EscreverFwk016() {
        log(TraceLevel.Debug, "A31616-ESCREVER-FWK016");
        fwk016().regFwk01680.initialize() ;
        fwk016().setRecord(wsDml()) ;
        fwk016().write(fwk016().regFwk01680) ;
        if (fwk016().getStatusOk()) {
            contRegEscrtFwk016.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK016-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk016().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31717EscreverFwk017() {
        log(TraceLevel.Debug, "A31717-ESCREVER-FWK017");
        fwk017().regFwk01780.initialize() ;
        fwk017().setRecord(wsDml()) ;
        fwk017().write(fwk017().regFwk01780) ;
        if (fwk017().getStatusOk()) {
            contRegEscrtFwk017.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK017-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk017().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31818EscreverFwk018() {
        log(TraceLevel.Debug, "A31818-ESCREVER-FWK018");
        fwk018().regFwk01880.initialize() ;
        fwk018().setRecord(wsDml()) ;
        fwk018().write(fwk018().regFwk01880) ;
        if (fwk018().getStatusOk()) {
            contRegEscrtFwk018.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK012-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk018().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31919EscreverFwk019() {
        log(TraceLevel.Debug, "A31919-ESCREVER-FWK019");
        fwk019().regFwk01980.initialize() ;
        fwk019().setRecord(wsDml()) ;
        fwk019().write(fwk019().regFwk01980) ;
        if (fwk019().getStatusOk()) {
            contRegEscrtFwk019.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK019-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk019().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31919EscreverFwk19a() {
        log(TraceLevel.Debug, "A31919-ESCREVER-FWK19A");
        fwk19a().regFwk19a80.initialize() ;
        fwk19a().setRecord(wsDml()) ;
        fwk19a().write(fwk19a().regFwk19a80) ;
        if (fwk19a().getStatusOk()) {
            contRegEscrtFwk19a.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK19A-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk19a().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32020EscreverFwk020() {
        log(TraceLevel.Debug, "A32020-ESCREVER-FWK020");
        fwk020().regFwk02080.initialize() ;
        fwk020().setRecord(wsDml()) ;
        fwk020().write(fwk020().regFwk02080) ;
        if (fwk020().getStatusOk()) {
            contRegEscrtFwk020.add(1);
            wsDml().initialize() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ666A - FWK020-- WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fwk020().getStatus());
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
            if (contRegEscrtFwk001.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK001");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk001);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            /**
             * IF CONT-REG-ESCRT-FWK002 > 0
             * MOVE 'FWK002'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK002      TO IMP-REG-ESCRT
             * SET Z TO 6
             * PERFORM A12000-ESCREVER-FGH300
             * END-IF
             */
            if (contRegEscrtFwk003.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK003");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk003);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk03a.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK03A");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk03a);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk004.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK004");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk004);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk04a.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK04A");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk04a);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk005.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK005");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk005);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk006.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK006");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk006);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            /**
             * IF CONT-REG-ESCRT-FWK007 > 0
             * MOVE 'FWK007'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK007      TO IMP-REG-ESCRT
             * SET Z TO 6
             * PERFORM A12000-ESCREVER-FGH300
             * END-IF
             * IF CONT-REG-ESCRT-FWK008 > 0
             * MOVE 'FWK008'                   TO IMP-FICH-ESC
             * MOVE CONT-REG-ESCRT-FWK008      TO IMP-REG-ESCRT
             */
            if (contRegEscrtFwk009.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK009");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk009);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk010.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK010");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk010);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk011.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK011");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk011);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk012.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK012");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk012);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk013.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK013");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk013);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk014.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK014");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk014);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk14a.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK14A");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk14a);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk015.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK015");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk015);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk016.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK016");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk016);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk017.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK017");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk017);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk018.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK018");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk018);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk019.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK019");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk019);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk19a.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK19A");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk19a);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegEscrtFwk020.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("FWK020");
                tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk020);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ666A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk001().close() ;
        fwk003().close() ;
        fwk03a().close() ;
        fwk004().close() ;
        fwk04a().close() ;
        fwk005().close() ;
        fwk006().close() ;
        fwk009().close() ;
        fwk010().close() ;
        fwk011().close() ;
        fwk012().close() ;
        fwk013().close() ;
        fwk014().close() ;
        fwk14a().close() ;
        fwk015().close() ;
        fwk016().close() ;
        fwk017().close() ;
        fwk018().close() ;
        fwk019().close() ;
        fwk19a().close() ;
        fwk020().close() ;
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
            s30000Processar() ;
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
    public interface WTimestampDml extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestampDml
         */
        @Data
        WDataTimestampDml wDataTimestampDml() ;
        
        @Data(size=15, value=" ", lpadding=1, lpaddingValue="-")
        IString wTimerTimestampDml() ;
        
        
        public interface WDataTimestampDml extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoDml() ;
            
            @Data(size=5, lpadding=1, lpaddingValue="-")
            IString wMesdiaDml() ;
            
        }
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
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=4, value="0")
        IInt wsZaBaldActivo() ;
        
        @Data(size=4, value="0")
        IInt wsZaBaldNormal() ;
        
        @Data(size=8, value=" ")
        IString wsNmRecurso() ;
        
        @Data(size=17, value=" ")
        IString wsDb2NmRecurso() ;
        
        @Data(size=18, value=" ")
        IString wsDb2NmRecursoC() ;
        
        @Data(size=8, value=" ")
        IString wsSpcNmRecurso() ;
        
        @Data(size=8, value=" ")
        IString wsSpcNmRecursoC() ;
        
        @Data(size=3, value="0")
        IInt wsCRtnoEvenSwal() ;
        
        @Data(size=8, value=" ")
        IString wsJobname() ;
        
    }
    
    /**
     * 
     * ESTRUTURAS
     * 
     * @version 2.0
     * 
     */
    public interface WsDml extends IDataStruct {
        
        @Data(size=72, value=" ")
        IString wsDmlLinha() ;
        
    }
    
    /**
     * 
     * *----------- PARA DML
     * 
     * @version 2.0
     * 
     */
    public interface TabelaDb2BaldHstAct extends IDataStruct {
        
        @Data(size=26, value="VGH02301-TGH00023_MOVHIST3")
        IString filler001() ;
        
        @Data(size=26, value="VGH02401-TGH00024_MOVHIST4")
        IString filler002() ;
        
        @Data(size=26, value="VGH02501-TGH00025_MOVHIST5")
        IString filler003() ;
        
        @Data(size=26, value="VGH02601-TGH00026_MOVHIST6")
        IString filler004() ;
        
        @Data(size=26, value="VGH02701-TGH00027_MOVHIST7")
        IString filler005() ;
        
        @Data(size=26, value="VGH02801-TGH00028_MOVHIST8")
        IString filler006() ;
        
    }
    public interface TbDb2BaldHstAct extends IDataMask {
        
        /**
         * @return instancia da classe local ItemDb2HstA
         */
        @Data(length=6)
        IArray<ItemDb2HstA> itemDb2HstA() ;
        
        
        public interface ItemDb2HstA extends IDataMask {
            
            
            @Data(size=8)
            IString tabDb2ViewAct() ;
            
            @Data(size=17, lpadding=1)
            IString tabDb2NmRecursoAct() ;
            
        }
    }
    public interface TabelaDb2BaldChstAct extends IDataStruct {
        
        @Data(size=27, value="VGH02301-TGH00123_MOVHSTCP3")
        IString filler001() ;
        
        @Data(size=27, value="VGH02401-TGH00124_MOVHSTCP4")
        IString filler002() ;
        
        @Data(size=27, value="VGH02501-TGH00125_MOVHSTCP5")
        IString filler003() ;
        
        @Data(size=27, value="VGH02601-TGH00126_MOVHSTCP6")
        IString filler004() ;
        
        @Data(size=27, value="VGH02701-TGH00127_MOVHSTCP7")
        IString filler005() ;
        
        @Data(size=27, value="VGH02801-TGH00128_MOVHSTCP8")
        IString filler006() ;
        
    }
    public interface TbDb2BaldChstAct extends IDataMask {
        
        /**
         * @return instancia da classe local ItemDb2ChstA
         */
        @Data(length=6)
        IArray<ItemDb2ChstA> itemDb2ChstA() ;
        
        
        public interface ItemDb2ChstA extends IDataMask {
            
            
            @Data(size=8)
            IString tabDb2ViewCact() ;
            
            @Data(size=18, lpadding=1)
            IString tabDb2NmRecursoCact() ;
            
        }
    }
    
    /**
     * 
     * *----------- PARA JOB
     * 
     * @version 2.0
     * 
     */
    public interface SpaceDb2BaldHstAct extends IDataStruct {
        
        @Data(size=17, value="VGH02301-SGH00023")
        IString filler001() ;
        
        @Data(size=17, value="VGH02401-SGH00024")
        IString filler002() ;
        
        @Data(size=17, value="VGH02501-SGH00025")
        IString filler003() ;
        
        @Data(size=17, value="VGH02601-SGH00026")
        IString filler004() ;
        
        @Data(size=17, value="VGH02701-SGH00027")
        IString filler005() ;
        
        @Data(size=17, value="VGH02801-SGH00028")
        IString filler006() ;
        
    }
    public interface SpaceDb2BaldHstAct02 extends IDataMask {
        
        /**
         * @return instancia da classe local ItemSpcHstA
         */
        @Data(length=6)
        IArray<ItemSpcHstA> itemSpcHstA() ;
        
        
        public interface ItemSpcHstA extends IDataMask {
            
            
            @Data(size=8)
            IString spaceDb2ViewAct() ;
            
            @Data(size=8, lpadding=1)
            IString spaceDb2NmRecursoAct() ;
            
        }
    }
    public interface SpaceDb2BaldHstCact extends IDataStruct {
        
        @Data(size=17, value="VGH02301-SGH00123")
        IString filler001() ;
        
        @Data(size=17, value="VGH02401-SGH00124")
        IString filler002() ;
        
        @Data(size=17, value="VGH02501-SGH00125")
        IString filler003() ;
        
        @Data(size=17, value="VGH02601-SGH00126")
        IString filler004() ;
        
        @Data(size=17, value="VGH02701-SGH00127")
        IString filler005() ;
        
        @Data(size=17, value="VGH02801-SGH00128")
        IString filler006() ;
        
    }
    public interface SpaceDb2BaldHstCact02 extends IDataMask {
        
        /**
         * @return instancia da classe local ItemSpcChstA
         */
        @Data(length=6)
        IArray<ItemSpcChstA> itemSpcChstA() ;
        
        
        public interface ItemSpcChstA extends IDataMask {
            
            
            @Data(size=8)
            IString spaceDb2ViewCact() ;
            
            @Data(size=8, lpadding=1)
            IString spaceDb2NmRecursoCact() ;
            
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
            
            @Data(size=8, value="PGHQ666A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ666A")
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
            IFormattedString impRegLidosFwk010() ;
            
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
