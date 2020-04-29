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
import cgd.gh.structures.work.Bghr1021 ;
import cgd.ho.structures.link.Bhol826a ;
import cgd.ho.routines.Mhoj826a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    : CARREGAMENTO DA TABELA:
 * -   TGH00102
 * -   TGH00128
 * -   TGH00123
 * -   TGH00124
 * -   TGH00125
 * -   TGH00126
 * -   TGH00127
 * PASSIVAS 2540 - 2018-03-13 - PREENCHER O NOVO CAMPO DA
 * TABELA TGH00102
 * 
 * @version 2.0
 * 
 */
public abstract class Pghqz06a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    /**
     * @return instancia da classe Vwsdghps12801Movhstcp8
     */
    @Data
    protected abstract Vwsdghps12801Movhstcp8 hv12801Movhstcp8() ;
    
    /**
     * @return instancia da classe Vwsdghps12301Movhstcp3
     */
    @Data
    protected abstract Vwsdghps12301Movhstcp3 hv12301Movhstcp3() ;
    
    /**
     * @return instancia da classe Vwsdghps12401Movhstcp4
     */
    @Data
    protected abstract Vwsdghps12401Movhstcp4 hv12401Movhstcp4() ;
    
    /**
     * @return instancia da classe Vwsdghps12501Movhstcp5
     */
    @Data
    protected abstract Vwsdghps12501Movhstcp5 hv12501Movhstcp5() ;
    
    /**
     * @return instancia da classe Vwsdghps12601Movhstcp6
     */
    @Data
    protected abstract Vwsdghps12601Movhstcp6 hv12601Movhstcp6() ;
    
    /**
     * @return instancia da classe Vwsdghps12701Movhstcp7
     */
    @Data
    protected abstract Vwsdghps12701Movhstcp7 hv12701Movhstcp7() ;
    
    
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
     * @return instancia da classe Fwk013
     */
    @Handler(name="FWK013", record="statusFwk013")
    @Data
    protected abstract Fwk013 fwk013() ;
    
    /**
     * @return instancia da classe Fwk014
     */
    @Handler(name="FWK014", record="statusFwk014")
    @Data
    protected abstract Fwk014 fwk014() ;
    
    /**
     * @return instancia da classe Fwk015
     */
    @Handler(name="FWK015", record="statusFwk015")
    @Data
    protected abstract Fwk015 fwk015() ;
    
    /**
     * @return instancia da classe Fwk016
     */
    @Handler(name="FWK016", record="statusFwk016")
    @Data
    protected abstract Fwk016 fwk016() ;
    
    /**
     * @return instancia da classe Fwk017
     */
    @Handler(name="FWK017", record="statusFwk017")
    @Data
    protected abstract Fwk017 fwk017() ;
    
    /**
     * @return instancia da classe Fwk018
     */
    @Handler(name="FWK018", record="statusFwk018")
    @Data
    protected abstract Fwk018 fwk018() ;
    
    /**
     * @return instancia da classe Fwk019
     */
    @Handler(name="FWK019", record="statusFwk019")
    @Data
    protected abstract Fwk019 fwk019() ;
    
    /**
     * @return instancia da classe Fwk900
     */
    @Handler(name="FWK900", record="fwk900RegPghqz06a")
    @Data
    protected abstract Fwk900 fwk900() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhoj826a
     */
    @Data
    protected abstract Mhoj826a hrMhoj826a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghr1021
     */
    @Data
    protected abstract Bghr1021 bghr1021() ;
    
    /**
     * @return instancia da classe Bhol826a
     */
    @Data
    protected abstract Bhol826a bhol826a() ;
    
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
    
    
    /**
     * PASSIVAS 2540 - 2018-03-12 - INI
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * PASSIVAS 2540 - 2018-03-12 - FIM
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
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk013 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk014 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk015 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk016 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk017 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk018 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk019 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegCommit ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh10201 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh12801 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh12301 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh12401 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh12501 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh12601 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegInsVgh12701 ;
    
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
     * COPY PROCEDURE ROTINA DE CLASSIFICACAO MOVIMENTOS EM CONTA DO
     * POR CATEGORIA
     * 
     */
    protected void bhop0826ClassMov() {
        hrMhoj826a().run() ;
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQZ06A");
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
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - OPEN - ");
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
            auxContRegLidos.set(fwk900().fwk900RegPghqz06a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
        if (fwk900().getStatusOk()) {
            auxContRegLidos.set(fwk900().fwk900RegPghqz06a().fwk900NCommit());
            fwk900().close() ;
        } else if (fwk900().getStatusOk()) {
            fwk900().close() ;
            a15100TratarOutputFwk900() ;
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - READ - ");
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
            fwk900().fwk900RegPghqz06a().initialize() ;
            fwk900().fwk900RegPghqz06a().fwk900NCommit().set(0);
            auxContRegLidos.set(0);
            fwk900().write(fwk900().fwk900RegPghqz06a()) ;
            if (fwk900().getStatusOk()) {
                fwk900().close() ;
            } else {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - WRITE- ");
                tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - OPEN- ");
            tabelaImpressao().linha09().impStatus().set(fwk900().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a16000AbrirFicheiros() {
        log(TraceLevel.Debug, "A16000-ABRIR-FICHEIROS");
        fwk013().open() ;
        if (!fwk013().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK013 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk013().getStatus());
        }
        fwk014().open() ;
        if (!fwk014().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK014 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk014().getStatus());
        }
        fwk015().open() ;
        if (!fwk015().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK015 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk015().getStatus());
        }
        fwk016().open() ;
        if (!fwk016().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK016 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk016().getStatus());
        }
        fwk017().open() ;
        if (!fwk017().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK017 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk017().getStatus());
        }
        fwk018().open() ;
        if (!fwk018().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK018 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk018().getStatus());
        }
        fwk019().open() ;
        if (!fwk019().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK019 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk019().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17008LerFwk013() {
        log(TraceLevel.Debug, "A17008-LER-FWK013");
        fwk013().read(bghr1021().rgh10201()) ;
        if (fwk013().getStatusOk()) {
            contRegLidosFwk013.add(1);
        }
        if (!fwk013().getStatusOk() && !fwk013().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK013 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk013().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17009LerFwk014() {
        log(TraceLevel.Debug, "A17008-LER-FWK014");
        fwk014().read(bghr1021().rgh10201()) ;
        if (fwk014().getStatusOk()) {
            contRegLidosFwk014.add(1);
        }
        if (!fwk014().getStatusOk() && !fwk014().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK014 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk014().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17010LerFwk015() {
        log(TraceLevel.Debug, "A17010-LER-FWK015");
        fwk015().read(bghr1021().rgh10201()) ;
        if (fwk015().getStatusOk()) {
            contRegLidosFwk015.add(1);
        }
        if (!fwk015().getStatusOk() && !fwk015().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK015 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk015().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17011LerFwk016() {
        log(TraceLevel.Debug, "A17011-LER-FWK016");
        fwk016().read(bghr1021().rgh10201()) ;
        if (fwk016().getStatusOk()) {
            contRegLidosFwk016.add(1);
        }
        if (!fwk016().getStatusOk() && !fwk016().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK016 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk016().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17012LerFwk017() {
        log(TraceLevel.Debug, "A17012-LER-FWK017");
        fwk017().read(bghr1021().rgh10201()) ;
        if (fwk017().getStatusOk()) {
            contRegLidosFwk017.add(1);
        }
        if (!fwk017().getStatusOk() && !fwk017().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK017 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk017().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17013LerFwk018() {
        log(TraceLevel.Debug, "A17013-LER-FWK018");
        fwk018().read(bghr1021().rgh10201()) ;
        if (fwk018().getStatusOk()) {
            contRegLidosFwk018.add(1);
        }
        if (!fwk018().getStatusOk() && !fwk018().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK018 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk018().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a17014LerFwk019() {
        log(TraceLevel.Debug, "A17014-LER-FWK019");
        fwk019().read(bghr1021().rgh10201()) ;
        if (fwk019().getStatusOk()) {
            contRegLidosFwk019.add(1);
        }
        if (!fwk019().getStatusOk() && !fwk019().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK019 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk019().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30008ProcessarFwk013() {
        log(TraceLevel.Debug, "S30008-PROCESSAR-FWK013");
        a30008EscreverHist102() ;
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17008LerFwk013() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30009ProcessarFwk014() {
        log(TraceLevel.Debug, "S30009-PROCESSAR-FWK014");
        a30009EscreverHist128() ;
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17009LerFwk014() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30010ProcessarFwk015() {
        log(TraceLevel.Debug, "S30010-PROCESSAR-FWK015");
        a30010EscreverHist123() ;
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17010LerFwk015() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30011ProcessarFwk016() {
        log(TraceLevel.Debug, "S30011-PROCESSAR-FWK016");
        a30011EscreverHist124() ;
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17011LerFwk016() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30012ProcessarFwk017() {
        log(TraceLevel.Debug, "S30012-PROCESSAR-FWK017");
        a30012EscreverHist125() ;
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17012LerFwk017() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30013ProcessarFwk018() {
        log(TraceLevel.Debug, "S30013-PROCESSAR-FWK018");
        a30013EscreverHist126() ;
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17013LerFwk018() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30014ProcessarFwk019() {
        log(TraceLevel.Debug, "S30014-PROCESSAR-FWK019");
        a30014EscreverHist127() ;
        if (progOk.isTrue()) {
            a33000ControlaCommit() ;
        }
        if (progOk.isTrue()) {
            a17014LerFwk019() ;
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
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(4); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk013.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK013");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk013);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk014.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK014");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk014);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk015.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK015");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk015);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk016.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK016");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk016);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk017.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK017");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk017);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk018.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK018");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk018);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegLidosFwk019.isGreater(0)) {
                tabelaImpressao().linha05().impFichRead().set("FWK019");
                tabelaImpressao().linha05().impRegLidos().set(contRegLidosFwk019);
                tabelaImpressaoMask().zimp().setIndex(5) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh10201.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH10201");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh10201);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh12801.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH12801");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh12801);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh12301.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH12301");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh12301);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh12401.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH12401");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh12401);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh12501.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH12501");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh12501);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh12601.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH12601");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh12601);
                tabelaImpressaoMask().zimp().setIndex(6) ;
                a12000EscreverFgh300() ;
            }
            if (contRegInsVgh12701.isGreater(0)) {
                tabelaImpressao().linha06().impFichEsc().set("VGH12701");
                tabelaImpressao().linha06().impRegEscrt().set(contRegInsVgh12701);
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
            tabelaImpressao().linha08().impMens1().set("PGHQZ06A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk013().close() ;
        fwk014().close() ;
        fwk015().close() ;
        fwk016().close() ;
        fwk017().close() ;
        fwk018().close() ;
        fwk019().close() ;
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
     * PASSIVAS 2540 - 2018-03-13 - INI
     * 
     */
    protected void a30001AcedeMhoj826a() {
        log(TraceLevel.Debug, "A30001-ACEDE-MHOJ826A");
        bhol826a().commarea().initialize() ;
        bhol826a().commarea().dadosInput().subconta().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        bhol826a().commarea().dadosInput().subconta().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        bhol826a().commarea().dadosInput().subconta().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        bhol826a().commarea().dadosInput().subconta().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        bhol826a().commarea().dadosInput().subconta().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        bhol826a().commarea().dadosInput().subconta().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        bhol826a().commarea().dadosInput().subconta().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        bhol826a().commarea().dadosInput().subconta().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        bhol826a().commarea().dadosInput().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        bhol826a().commarea().dadosInput().aAplOrig().set(bghr1021().rgh10201().fgh102AAplicacao());
        bhol826a().commarea().dadosInput().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        bhol826a().commarea().dadosInput().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        bhol826a().commarea().dadosInput().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        bhol826a().commarea().dadosInput().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        bhop0826ClassMov() ;
        if (!bhol826a().commarea().dadosErro().semErros().isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(bhol826a().commarea().dadosErro().cRtnoEvenSwal());
            /**
             * BHOL826A-C-RTNO-EVEN-SWAL ' '
             */
            tabelaImpressao().linha09().msgStatus().set(concat("PGHQ002A - ", bhol826a().cRotina(), " ", bhol826a().commarea().dadosErro().cTipoErroBbn(), " ", bhol826a().commarea().dadosErro().aAplErr(), " ", tabelaImpressao().linha07().impReturnCode(), " ", bhol826a().commarea().dadosErro().nmTabela()));
            tabelaImpressao().linha09().impStatus().set(bhol826a().commarea().dadosErro().cSqlcode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            log(TraceLevel.Debug, "BHOL826A-D-MOVIMENTO       : ", bhol826a().commarea().dadosOutput().dMovimento());
            log(TraceLevel.Debug, "BHOL826A-C-CATG-MOV        : ", bhol826a().commarea().dadosOutput().cCatgMov());
            log(TraceLevel.Debug, "BHOL826A-C-CATG-MOV-NVL1   : ", bhol826a().commarea().dadosOutput().cCatgMovNvl1());
            log(TraceLevel.Debug, "BHOL826A-I-CATG-NVL2       : ", bhol826a().commarea().dadosOutput().iCatgNvl2());
            log(TraceLevel.Debug, "BHOL826A-C-TIPO-ENT-NVL2   : ", bhol826a().commarea().dadosOutput().cTipoEntNvl2());
            log(TraceLevel.Debug, "BHOL826A-C-ATBT-ENT-NVL2   : ", bhol826a().commarea().dadosOutput().cAtbtEntNvl2());
            log(TraceLevel.Debug, "BHOL826A-V-POSZ-INI-ENT-NV2: ", bhol826a().commarea().dadosOutput().vPoszIniEntNv2());
            log(TraceLevel.Debug, "BHOL826A-Q-CTER-CMP-ENT-NV2: ", bhol826a().commarea().dadosOutput().qCterCmpEntNv2());
            log(TraceLevel.Debug, "BHOL826A-C-ID-CRDX-CBC-SEPA: ", bhol826a().commarea().dadosOutput().cIdCrdxCbcSepa());
        }
    }
    
    /**
     * 
     * PASSIVAS 2540 - 2018-03-13 - FIM
     * 
     */
    protected void a30008EscreverHist102() {
        log(TraceLevel.Debug, "A30008-ESCREVER-HIST-102");
        hv10201Movhstcpl().movhstcpl().initialize() ;
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(bghr1021().rgh10201().fgh102TsMovimento());
        hv10201Movhstcpl().movhstcpl().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        hv10201Movhstcpl().movhstcpl().cTransaccao().set(bghr1021().rgh10201().fgh102CTransaccao());
        hv10201Movhstcpl().movhstcpl().aAplicacao().set(bghr1021().rgh10201().fgh102AAplicacao());
        hv10201Movhstcpl().movhstcpl().cOpczMenu().set(bghr1021().rgh10201().fgh102COpczMenu());
        hv10201Movhstcpl().movhstcpl().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        hv10201Movhstcpl().movhstcpl().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        hv10201Movhstcpl().movhstcpl().cTerminal().set(bghr1021().rgh10201().fgh102CTerminal());
        hv10201Movhstcpl().movhstcpl().cOperador().set(bghr1021().rgh10201().fgh102COperador());
        hv10201Movhstcpl().movhstcpl().cOpexAtrx().set(bghr1021().rgh10201().fgh102COpexAtrx());
        hv10201Movhstcpl().movhstcpl().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        hv10201Movhstcpl().movhstcpl().cTipoCanlAces().set(bghr1021().rgh10201().fgh102CTipoCanlAces());
        hv10201Movhstcpl().movhstcpl().cPaisIsoaOeOpx().set(bghr1021().rgh10201().fgh102CPaisIsoaOeOpx());
        hv10201Movhstcpl().movhstcpl().cMnemEgcOpex().set(bghr1021().rgh10201().fgh102CMnemEgcOpex());
        hv10201Movhstcpl().movhstcpl().cOeEgcOpex().set(bghr1021().rgh10201().fgh102COeEgcOpex());
        hv10201Movhstcpl().movhstcpl().cProdSgop().set(bghr1021().rgh10201().fgh102CProdSgop());
        hv10201Movhstcpl().movhstcpl().cFamiProd().set(bghr1021().rgh10201().fgh102CFamiProd());
        hv10201Movhstcpl().movhstcpl().cProduto().set(bghr1021().rgh10201().fgh102CProduto());
        hv10201Movhstcpl().movhstcpl().cCndzMovzCont().set(bghr1021().rgh10201().fgh102CCndzMovzCont());
        hv10201Movhstcpl().movhstcpl().cGrupCont().set(bghr1021().rgh10201().fgh102CGrupCont());
        hv10201Movhstcpl().movhstcpl().cTipoIttz().set(bghr1021().rgh10201().fgh102CTipoIttz());
        hv10201Movhstcpl().movhstcpl().tCambio().set(bghr1021().rgh10201().fgh102TCambio());
        hv10201Movhstcpl().movhstcpl().mSldoRetd().set(bghr1021().rgh10201().fgh102MSldoRetd());
        hv10201Movhstcpl().movhstcpl().mSldoVcob().set(bghr1021().rgh10201().fgh102MSldoVcob());
        hv10201Movhstcpl().movhstcpl().mCmrgLim().set(bghr1021().rgh10201().fgh102MCmrgLim());
        hv10201Movhstcpl().movhstcpl().mCmrgUtid().set(bghr1021().rgh10201().fgh102MCmrgUtid());
        hv10201Movhstcpl().movhstcpl().mDcboNgcdAtrd().set(bghr1021().rgh10201().fgh102MDcboNgcdAtrd());
        hv10201Movhstcpl().movhstcpl().mDcboNgcdUtid().set(bghr1021().rgh10201().fgh102MDcboNgcdUtid());
        hv10201Movhstcpl().movhstcpl().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        hv10201Movhstcpl().movhstcpl().nsJourBbn().set(bghr1021().rgh10201().fgh102NsJourBbn());
        hv10201Movhstcpl().movhstcpl().nsJourBbnDtlh().set(bghr1021().rgh10201().fgh102NsJourBbnDtlh());
        hv10201Movhstcpl().movhstcpl().nmArqvOrig().set(bghr1021().rgh10201().fgh102NmArqvOrig());
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        hv10201Movhstcpl().movhstcpl().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        hv10201Movhstcpl().movhstcpl().tsActzUlt().set(bghr1021().rgh10201().fgh102TsActzUlt());
        hv10201Movhstcpl().movhstcpl().cUsidActzUlt().set(bghr1021().rgh10201().fgh102CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().insertPghqz06a1331() ;
        if (hv10201Movhstcpl().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh10201.add(1);
        }
        if (hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv10201Movhstcpl().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - VGH10201-INSERT - ");
            wSqlcode.set(hv10201Movhstcpl().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30009EscreverHist128() {
        log(TraceLevel.Debug, "A30009-ESCREVER-HIST-128");
        hv12801Movhstcp8().movhstcp8().initialize() ;
        hv12801Movhstcp8().movhstcp8().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        hv12801Movhstcp8().movhstcp8().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        hv12801Movhstcp8().movhstcp8().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        hv12801Movhstcp8().movhstcp8().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        hv12801Movhstcp8().movhstcp8().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        hv12801Movhstcp8().movhstcp8().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        hv12801Movhstcp8().movhstcp8().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        hv12801Movhstcp8().movhstcp8().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        hv12801Movhstcp8().movhstcp8().tsMovimento().set(bghr1021().rgh10201().fgh102TsMovimento());
        hv12801Movhstcp8().movhstcp8().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        hv12801Movhstcp8().movhstcp8().cTransaccao().set(bghr1021().rgh10201().fgh102CTransaccao());
        hv12801Movhstcp8().movhstcp8().aAplicacao().set(bghr1021().rgh10201().fgh102AAplicacao());
        hv12801Movhstcp8().movhstcp8().cOpczMenu().set(bghr1021().rgh10201().fgh102COpczMenu());
        hv12801Movhstcp8().movhstcp8().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        hv12801Movhstcp8().movhstcp8().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        hv12801Movhstcp8().movhstcp8().cTerminal().set(bghr1021().rgh10201().fgh102CTerminal());
        hv12801Movhstcp8().movhstcp8().cOperador().set(bghr1021().rgh10201().fgh102COperador());
        hv12801Movhstcp8().movhstcp8().cOpexAtrx().set(bghr1021().rgh10201().fgh102COpexAtrx());
        hv12801Movhstcp8().movhstcp8().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        hv12801Movhstcp8().movhstcp8().cTipoCanlAces().set(bghr1021().rgh10201().fgh102CTipoCanlAces());
        hv12801Movhstcp8().movhstcp8().cPaisIsoaOeOpx().set(bghr1021().rgh10201().fgh102CPaisIsoaOeOpx());
        hv12801Movhstcp8().movhstcp8().cMnemEgcOpex().set(bghr1021().rgh10201().fgh102CMnemEgcOpex());
        hv12801Movhstcp8().movhstcp8().cOeEgcOpex().set(bghr1021().rgh10201().fgh102COeEgcOpex());
        hv12801Movhstcp8().movhstcp8().cProdSgop().set(bghr1021().rgh10201().fgh102CProdSgop());
        hv12801Movhstcp8().movhstcp8().cFamiProd().set(bghr1021().rgh10201().fgh102CFamiProd());
        hv12801Movhstcp8().movhstcp8().cProduto().set(bghr1021().rgh10201().fgh102CProduto());
        hv12801Movhstcp8().movhstcp8().cCndzMovzCont().set(bghr1021().rgh10201().fgh102CCndzMovzCont());
        hv12801Movhstcp8().movhstcp8().cGrupCont().set(bghr1021().rgh10201().fgh102CGrupCont());
        hv12801Movhstcp8().movhstcp8().cTipoIttz().set(bghr1021().rgh10201().fgh102CTipoIttz());
        hv12801Movhstcp8().movhstcp8().tCambio().set(bghr1021().rgh10201().fgh102TCambio());
        hv12801Movhstcp8().movhstcp8().mSldoRetd().set(bghr1021().rgh10201().fgh102MSldoRetd());
        hv12801Movhstcp8().movhstcp8().mSldoVcob().set(bghr1021().rgh10201().fgh102MSldoVcob());
        hv12801Movhstcp8().movhstcp8().mCmrgLim().set(bghr1021().rgh10201().fgh102MCmrgLim());
        hv12801Movhstcp8().movhstcp8().mCmrgUtid().set(bghr1021().rgh10201().fgh102MCmrgUtid());
        hv12801Movhstcp8().movhstcp8().mDcboNgcdAtrd().set(bghr1021().rgh10201().fgh102MDcboNgcdAtrd());
        hv12801Movhstcp8().movhstcp8().mDcboNgcdUtid().set(bghr1021().rgh10201().fgh102MDcboNgcdUtid());
        hv12801Movhstcp8().movhstcp8().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        hv12801Movhstcp8().movhstcp8().nsJourBbn().set(bghr1021().rgh10201().fgh102NsJourBbn());
        hv12801Movhstcp8().movhstcp8().nsJourBbnDtlh().set(bghr1021().rgh10201().fgh102NsJourBbnDtlh());
        hv12801Movhstcp8().movhstcp8().nmArqvOrig().set(bghr1021().rgh10201().fgh102NmArqvOrig());
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        hv12801Movhstcp8().movhstcp8().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        hv12801Movhstcp8().movhstcp8().tsActzUlt().set(bghr1021().rgh10201().fgh102TsActzUlt());
        hv12801Movhstcp8().movhstcp8().cUsidActzUlt().set(bghr1021().rgh10201().fgh102CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH12801_MOVHSTCP8
         */
        hv12801Movhstcp8().insertPghqz06a1503() ;
        if (hv12801Movhstcp8().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh12801.add(1);
        }
        if (hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv12801Movhstcp8().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - VGH12801-INSERT - ");
            wSqlcode.set(hv12801Movhstcp8().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30010EscreverHist123() {
        log(TraceLevel.Debug, "A30010-ESCREVER-HIST-123");
        hv12301Movhstcp3().movhstcp3().initialize() ;
        hv12301Movhstcp3().movhstcp3().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        hv12301Movhstcp3().movhstcp3().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        hv12301Movhstcp3().movhstcp3().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        hv12301Movhstcp3().movhstcp3().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        hv12301Movhstcp3().movhstcp3().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        hv12301Movhstcp3().movhstcp3().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        hv12301Movhstcp3().movhstcp3().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        hv12301Movhstcp3().movhstcp3().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        hv12301Movhstcp3().movhstcp3().tsMovimento().set(bghr1021().rgh10201().fgh102TsMovimento());
        hv12301Movhstcp3().movhstcp3().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        hv12301Movhstcp3().movhstcp3().cTransaccao().set(bghr1021().rgh10201().fgh102CTransaccao());
        hv12301Movhstcp3().movhstcp3().aAplicacao().set(bghr1021().rgh10201().fgh102AAplicacao());
        hv12301Movhstcp3().movhstcp3().cOpczMenu().set(bghr1021().rgh10201().fgh102COpczMenu());
        hv12301Movhstcp3().movhstcp3().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        hv12301Movhstcp3().movhstcp3().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        hv12301Movhstcp3().movhstcp3().cTerminal().set(bghr1021().rgh10201().fgh102CTerminal());
        hv12301Movhstcp3().movhstcp3().cOperador().set(bghr1021().rgh10201().fgh102COperador());
        hv12301Movhstcp3().movhstcp3().cOpexAtrx().set(bghr1021().rgh10201().fgh102COpexAtrx());
        hv12301Movhstcp3().movhstcp3().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        hv12301Movhstcp3().movhstcp3().cTipoCanlAces().set(bghr1021().rgh10201().fgh102CTipoCanlAces());
        hv12301Movhstcp3().movhstcp3().cPaisIsoaOeOpx().set(bghr1021().rgh10201().fgh102CPaisIsoaOeOpx());
        hv12301Movhstcp3().movhstcp3().cMnemEgcOpex().set(bghr1021().rgh10201().fgh102CMnemEgcOpex());
        hv12301Movhstcp3().movhstcp3().cOeEgcOpex().set(bghr1021().rgh10201().fgh102COeEgcOpex());
        hv12301Movhstcp3().movhstcp3().cProdSgop().set(bghr1021().rgh10201().fgh102CProdSgop());
        hv12301Movhstcp3().movhstcp3().cFamiProd().set(bghr1021().rgh10201().fgh102CFamiProd());
        hv12301Movhstcp3().movhstcp3().cProduto().set(bghr1021().rgh10201().fgh102CProduto());
        hv12301Movhstcp3().movhstcp3().cCndzMovzCont().set(bghr1021().rgh10201().fgh102CCndzMovzCont());
        hv12301Movhstcp3().movhstcp3().cGrupCont().set(bghr1021().rgh10201().fgh102CGrupCont());
        hv12301Movhstcp3().movhstcp3().cTipoIttz().set(bghr1021().rgh10201().fgh102CTipoIttz());
        hv12301Movhstcp3().movhstcp3().tCambio().set(bghr1021().rgh10201().fgh102TCambio());
        hv12301Movhstcp3().movhstcp3().mSldoRetd().set(bghr1021().rgh10201().fgh102MSldoRetd());
        hv12301Movhstcp3().movhstcp3().mSldoVcob().set(bghr1021().rgh10201().fgh102MSldoVcob());
        hv12301Movhstcp3().movhstcp3().mCmrgLim().set(bghr1021().rgh10201().fgh102MCmrgLim());
        hv12301Movhstcp3().movhstcp3().mCmrgUtid().set(bghr1021().rgh10201().fgh102MCmrgUtid());
        hv12301Movhstcp3().movhstcp3().mDcboNgcdAtrd().set(bghr1021().rgh10201().fgh102MDcboNgcdAtrd());
        hv12301Movhstcp3().movhstcp3().mDcboNgcdUtid().set(bghr1021().rgh10201().fgh102MDcboNgcdUtid());
        hv12301Movhstcp3().movhstcp3().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        hv12301Movhstcp3().movhstcp3().nsJourBbn().set(bghr1021().rgh10201().fgh102NsJourBbn());
        hv12301Movhstcp3().movhstcp3().nsJourBbnDtlh().set(bghr1021().rgh10201().fgh102NsJourBbnDtlh());
        hv12301Movhstcp3().movhstcp3().nmArqvOrig().set(bghr1021().rgh10201().fgh102NmArqvOrig());
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        hv12301Movhstcp3().movhstcp3().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        hv12301Movhstcp3().movhstcp3().tsActzUlt().set(bghr1021().rgh10201().fgh102TsActzUlt());
        hv12301Movhstcp3().movhstcp3().cUsidActzUlt().set(bghr1021().rgh10201().fgh102CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH12301_MOVHSTCP3
         */
        hv12301Movhstcp3().insertPghqz06a1675() ;
        if (hv12301Movhstcp3().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh12301.add(1);
        }
        if (hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv12301Movhstcp3().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - VGH12301-INSERT - ");
            wSqlcode.set(hv12301Movhstcp3().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30011EscreverHist124() {
        log(TraceLevel.Debug, "A30011-ESCREVER-HIST-124");
        hv12401Movhstcp4().movhstcp4().initialize() ;
        hv12401Movhstcp4().movhstcp4().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        hv12401Movhstcp4().movhstcp4().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        hv12401Movhstcp4().movhstcp4().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        hv12401Movhstcp4().movhstcp4().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        hv12401Movhstcp4().movhstcp4().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        hv12401Movhstcp4().movhstcp4().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        hv12401Movhstcp4().movhstcp4().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        hv12401Movhstcp4().movhstcp4().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        hv12401Movhstcp4().movhstcp4().tsMovimento().set(bghr1021().rgh10201().fgh102TsMovimento());
        hv12401Movhstcp4().movhstcp4().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        hv12401Movhstcp4().movhstcp4().cTransaccao().set(bghr1021().rgh10201().fgh102CTransaccao());
        hv12401Movhstcp4().movhstcp4().aAplicacao().set(bghr1021().rgh10201().fgh102AAplicacao());
        hv12401Movhstcp4().movhstcp4().cOpczMenu().set(bghr1021().rgh10201().fgh102COpczMenu());
        hv12401Movhstcp4().movhstcp4().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        hv12401Movhstcp4().movhstcp4().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        hv12401Movhstcp4().movhstcp4().cTerminal().set(bghr1021().rgh10201().fgh102CTerminal());
        hv12401Movhstcp4().movhstcp4().cOperador().set(bghr1021().rgh10201().fgh102COperador());
        hv12401Movhstcp4().movhstcp4().cOpexAtrx().set(bghr1021().rgh10201().fgh102COpexAtrx());
        hv12401Movhstcp4().movhstcp4().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        hv12401Movhstcp4().movhstcp4().cTipoCanlAces().set(bghr1021().rgh10201().fgh102CTipoCanlAces());
        hv12401Movhstcp4().movhstcp4().cPaisIsoaOeOpx().set(bghr1021().rgh10201().fgh102CPaisIsoaOeOpx());
        hv12401Movhstcp4().movhstcp4().cMnemEgcOpex().set(bghr1021().rgh10201().fgh102CMnemEgcOpex());
        hv12401Movhstcp4().movhstcp4().cOeEgcOpex().set(bghr1021().rgh10201().fgh102COeEgcOpex());
        hv12401Movhstcp4().movhstcp4().cProdSgop().set(bghr1021().rgh10201().fgh102CProdSgop());
        hv12401Movhstcp4().movhstcp4().cFamiProd().set(bghr1021().rgh10201().fgh102CFamiProd());
        hv12401Movhstcp4().movhstcp4().cProduto().set(bghr1021().rgh10201().fgh102CProduto());
        hv12401Movhstcp4().movhstcp4().cCndzMovzCont().set(bghr1021().rgh10201().fgh102CCndzMovzCont());
        hv12401Movhstcp4().movhstcp4().cGrupCont().set(bghr1021().rgh10201().fgh102CGrupCont());
        hv12401Movhstcp4().movhstcp4().cTipoIttz().set(bghr1021().rgh10201().fgh102CTipoIttz());
        hv12401Movhstcp4().movhstcp4().tCambio().set(bghr1021().rgh10201().fgh102TCambio());
        hv12401Movhstcp4().movhstcp4().mSldoRetd().set(bghr1021().rgh10201().fgh102MSldoRetd());
        hv12401Movhstcp4().movhstcp4().mSldoVcob().set(bghr1021().rgh10201().fgh102MSldoVcob());
        hv12401Movhstcp4().movhstcp4().mCmrgLim().set(bghr1021().rgh10201().fgh102MCmrgLim());
        hv12401Movhstcp4().movhstcp4().mCmrgUtid().set(bghr1021().rgh10201().fgh102MCmrgUtid());
        hv12401Movhstcp4().movhstcp4().mDcboNgcdAtrd().set(bghr1021().rgh10201().fgh102MDcboNgcdAtrd());
        hv12401Movhstcp4().movhstcp4().mDcboNgcdUtid().set(bghr1021().rgh10201().fgh102MDcboNgcdUtid());
        hv12401Movhstcp4().movhstcp4().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        hv12401Movhstcp4().movhstcp4().nsJourBbn().set(bghr1021().rgh10201().fgh102NsJourBbn());
        hv12401Movhstcp4().movhstcp4().nsJourBbnDtlh().set(bghr1021().rgh10201().fgh102NsJourBbnDtlh());
        hv12401Movhstcp4().movhstcp4().nmArqvOrig().set(bghr1021().rgh10201().fgh102NmArqvOrig());
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        hv12401Movhstcp4().movhstcp4().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        hv12401Movhstcp4().movhstcp4().tsActzUlt().set(bghr1021().rgh10201().fgh102TsActzUlt());
        hv12401Movhstcp4().movhstcp4().cUsidActzUlt().set(bghr1021().rgh10201().fgh102CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH12401_MOVHSTCP4
         */
        hv12401Movhstcp4().insertPghqz06a1847() ;
        if (hv12401Movhstcp4().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh12401.add(1);
        }
        if (hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv12401Movhstcp4().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - VGH12401-INSERT - ");
            wSqlcode.set(hv12401Movhstcp4().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30012EscreverHist125() {
        log(TraceLevel.Debug, "A30012-ESCREVER-HIST-125");
        hv12501Movhstcp5().movhstcp5().initialize() ;
        hv12501Movhstcp5().movhstcp5().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        hv12501Movhstcp5().movhstcp5().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        hv12501Movhstcp5().movhstcp5().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        hv12501Movhstcp5().movhstcp5().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        hv12501Movhstcp5().movhstcp5().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        hv12501Movhstcp5().movhstcp5().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        hv12501Movhstcp5().movhstcp5().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        hv12501Movhstcp5().movhstcp5().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        hv12501Movhstcp5().movhstcp5().tsMovimento().set(bghr1021().rgh10201().fgh102TsMovimento());
        hv12501Movhstcp5().movhstcp5().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        hv12501Movhstcp5().movhstcp5().cTransaccao().set(bghr1021().rgh10201().fgh102CTransaccao());
        hv12501Movhstcp5().movhstcp5().aAplicacao().set(bghr1021().rgh10201().fgh102AAplicacao());
        hv12501Movhstcp5().movhstcp5().cOpczMenu().set(bghr1021().rgh10201().fgh102COpczMenu());
        hv12501Movhstcp5().movhstcp5().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        hv12501Movhstcp5().movhstcp5().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        hv12501Movhstcp5().movhstcp5().cTerminal().set(bghr1021().rgh10201().fgh102CTerminal());
        hv12501Movhstcp5().movhstcp5().cOperador().set(bghr1021().rgh10201().fgh102COperador());
        hv12501Movhstcp5().movhstcp5().cOpexAtrx().set(bghr1021().rgh10201().fgh102COpexAtrx());
        hv12501Movhstcp5().movhstcp5().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        hv12501Movhstcp5().movhstcp5().cTipoCanlAces().set(bghr1021().rgh10201().fgh102CTipoCanlAces());
        hv12501Movhstcp5().movhstcp5().cPaisIsoaOeOpx().set(bghr1021().rgh10201().fgh102CPaisIsoaOeOpx());
        hv12501Movhstcp5().movhstcp5().cMnemEgcOpex().set(bghr1021().rgh10201().fgh102CMnemEgcOpex());
        hv12501Movhstcp5().movhstcp5().cOeEgcOpex().set(bghr1021().rgh10201().fgh102COeEgcOpex());
        hv12501Movhstcp5().movhstcp5().cProdSgop().set(bghr1021().rgh10201().fgh102CProdSgop());
        hv12501Movhstcp5().movhstcp5().cFamiProd().set(bghr1021().rgh10201().fgh102CFamiProd());
        hv12501Movhstcp5().movhstcp5().cProduto().set(bghr1021().rgh10201().fgh102CProduto());
        hv12501Movhstcp5().movhstcp5().cCndzMovzCont().set(bghr1021().rgh10201().fgh102CCndzMovzCont());
        hv12501Movhstcp5().movhstcp5().cGrupCont().set(bghr1021().rgh10201().fgh102CGrupCont());
        hv12501Movhstcp5().movhstcp5().cTipoIttz().set(bghr1021().rgh10201().fgh102CTipoIttz());
        hv12501Movhstcp5().movhstcp5().tCambio().set(bghr1021().rgh10201().fgh102TCambio());
        hv12501Movhstcp5().movhstcp5().mSldoRetd().set(bghr1021().rgh10201().fgh102MSldoRetd());
        hv12501Movhstcp5().movhstcp5().mSldoVcob().set(bghr1021().rgh10201().fgh102MSldoVcob());
        hv12501Movhstcp5().movhstcp5().mCmrgLim().set(bghr1021().rgh10201().fgh102MCmrgLim());
        hv12501Movhstcp5().movhstcp5().mCmrgUtid().set(bghr1021().rgh10201().fgh102MCmrgUtid());
        hv12501Movhstcp5().movhstcp5().mDcboNgcdAtrd().set(bghr1021().rgh10201().fgh102MDcboNgcdAtrd());
        hv12501Movhstcp5().movhstcp5().mDcboNgcdUtid().set(bghr1021().rgh10201().fgh102MDcboNgcdUtid());
        hv12501Movhstcp5().movhstcp5().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        hv12501Movhstcp5().movhstcp5().nsJourBbn().set(bghr1021().rgh10201().fgh102NsJourBbn());
        hv12501Movhstcp5().movhstcp5().nsJourBbnDtlh().set(bghr1021().rgh10201().fgh102NsJourBbnDtlh());
        hv12501Movhstcp5().movhstcp5().nmArqvOrig().set(bghr1021().rgh10201().fgh102NmArqvOrig());
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        hv12501Movhstcp5().movhstcp5().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        hv12501Movhstcp5().movhstcp5().tsActzUlt().set(bghr1021().rgh10201().fgh102TsActzUlt());
        hv12501Movhstcp5().movhstcp5().cUsidActzUlt().set(bghr1021().rgh10201().fgh102CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH12501_MOVHSTCP5
         */
        hv12501Movhstcp5().insertPghqz06a2019() ;
        if (hv12501Movhstcp5().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh12501.add(1);
        }
        if (hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv12501Movhstcp5().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - VGH12501-INSERT - ");
            wSqlcode.set(hv12501Movhstcp5().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30013EscreverHist126() {
        log(TraceLevel.Debug, "A30013-ESCREVER-HIST-126");
        hv12601Movhstcp6().movhstcp6().initialize() ;
        hv12601Movhstcp6().movhstcp6().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        hv12601Movhstcp6().movhstcp6().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        hv12601Movhstcp6().movhstcp6().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        hv12601Movhstcp6().movhstcp6().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        hv12601Movhstcp6().movhstcp6().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        hv12601Movhstcp6().movhstcp6().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        hv12601Movhstcp6().movhstcp6().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        hv12601Movhstcp6().movhstcp6().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        hv12601Movhstcp6().movhstcp6().tsMovimento().set(bghr1021().rgh10201().fgh102TsMovimento());
        hv12601Movhstcp6().movhstcp6().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        hv12601Movhstcp6().movhstcp6().cTransaccao().set(bghr1021().rgh10201().fgh102CTransaccao());
        hv12601Movhstcp6().movhstcp6().aAplicacao().set(bghr1021().rgh10201().fgh102AAplicacao());
        hv12601Movhstcp6().movhstcp6().cOpczMenu().set(bghr1021().rgh10201().fgh102COpczMenu());
        hv12601Movhstcp6().movhstcp6().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        hv12601Movhstcp6().movhstcp6().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        hv12601Movhstcp6().movhstcp6().cTerminal().set(bghr1021().rgh10201().fgh102CTerminal());
        hv12601Movhstcp6().movhstcp6().cOperador().set(bghr1021().rgh10201().fgh102COperador());
        hv12601Movhstcp6().movhstcp6().cOpexAtrx().set(bghr1021().rgh10201().fgh102COpexAtrx());
        hv12601Movhstcp6().movhstcp6().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        hv12601Movhstcp6().movhstcp6().cTipoCanlAces().set(bghr1021().rgh10201().fgh102CTipoCanlAces());
        hv12601Movhstcp6().movhstcp6().cPaisIsoaOeOpx().set(bghr1021().rgh10201().fgh102CPaisIsoaOeOpx());
        hv12601Movhstcp6().movhstcp6().cMnemEgcOpex().set(bghr1021().rgh10201().fgh102CMnemEgcOpex());
        hv12601Movhstcp6().movhstcp6().cOeEgcOpex().set(bghr1021().rgh10201().fgh102COeEgcOpex());
        hv12601Movhstcp6().movhstcp6().cProdSgop().set(bghr1021().rgh10201().fgh102CProdSgop());
        hv12601Movhstcp6().movhstcp6().cFamiProd().set(bghr1021().rgh10201().fgh102CFamiProd());
        hv12601Movhstcp6().movhstcp6().cProduto().set(bghr1021().rgh10201().fgh102CProduto());
        hv12601Movhstcp6().movhstcp6().cCndzMovzCont().set(bghr1021().rgh10201().fgh102CCndzMovzCont());
        hv12601Movhstcp6().movhstcp6().cGrupCont().set(bghr1021().rgh10201().fgh102CGrupCont());
        hv12601Movhstcp6().movhstcp6().cTipoIttz().set(bghr1021().rgh10201().fgh102CTipoIttz());
        hv12601Movhstcp6().movhstcp6().tCambio().set(bghr1021().rgh10201().fgh102TCambio());
        hv12601Movhstcp6().movhstcp6().mSldoRetd().set(bghr1021().rgh10201().fgh102MSldoRetd());
        hv12601Movhstcp6().movhstcp6().mSldoVcob().set(bghr1021().rgh10201().fgh102MSldoVcob());
        hv12601Movhstcp6().movhstcp6().mCmrgLim().set(bghr1021().rgh10201().fgh102MCmrgLim());
        hv12601Movhstcp6().movhstcp6().mCmrgUtid().set(bghr1021().rgh10201().fgh102MCmrgUtid());
        hv12601Movhstcp6().movhstcp6().mDcboNgcdAtrd().set(bghr1021().rgh10201().fgh102MDcboNgcdAtrd());
        hv12601Movhstcp6().movhstcp6().mDcboNgcdUtid().set(bghr1021().rgh10201().fgh102MDcboNgcdUtid());
        hv12601Movhstcp6().movhstcp6().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        hv12601Movhstcp6().movhstcp6().nsJourBbn().set(bghr1021().rgh10201().fgh102NsJourBbn());
        hv12601Movhstcp6().movhstcp6().nsJourBbnDtlh().set(bghr1021().rgh10201().fgh102NsJourBbnDtlh());
        hv12601Movhstcp6().movhstcp6().nmArqvOrig().set(bghr1021().rgh10201().fgh102NmArqvOrig());
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        hv12601Movhstcp6().movhstcp6().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        hv12601Movhstcp6().movhstcp6().tsActzUlt().set(bghr1021().rgh10201().fgh102TsActzUlt());
        hv12601Movhstcp6().movhstcp6().cUsidActzUlt().set(bghr1021().rgh10201().fgh102CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH12601_MOVHSTCP6
         */
        hv12601Movhstcp6().insertPghqz06a2190() ;
        if (hv12601Movhstcp6().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh12601.add(1);
        }
        if (hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv12601Movhstcp6().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - VGH12601-INSERT - ");
            wSqlcode.set(hv12601Movhstcp6().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a30014EscreverHist127() {
        log(TraceLevel.Debug, "A30014-ESCREVER-HIST-127");
        hv12701Movhstcp7().movhstcp7().initialize() ;
        hv12701Movhstcp7().movhstcp7().cPaisIsoaCont().set(bghr1021().rgh10201().fgh102CPaisIsoaCont());
        hv12701Movhstcp7().movhstcp7().cBancCont().set(bghr1021().rgh10201().fgh102CBancCont());
        hv12701Movhstcp7().movhstcp7().cOeEgcCont().set(bghr1021().rgh10201().fgh102COeEgcCont());
        hv12701Movhstcp7().movhstcp7().nsRdclCont().set(bghr1021().rgh10201().fgh102NsRdclCont());
        hv12701Movhstcp7().movhstcp7().vChkdCont().set(bghr1021().rgh10201().fgh102VChkdCont());
        hv12701Movhstcp7().movhstcp7().cTipoCont().set(bghr1021().rgh10201().fgh102CTipoCont());
        hv12701Movhstcp7().movhstcp7().cMoedIsoScta().set(bghr1021().rgh10201().fgh102CMoedIsoScta());
        hv12701Movhstcp7().movhstcp7().nsDeposito().set(bghr1021().rgh10201().fgh102NsDeposito());
        hv12701Movhstcp7().movhstcp7().tsMovimento().set(bghr1021().rgh10201().fgh102TsMovimento());
        hv12701Movhstcp7().movhstcp7().nsMovimento().set(bghr1021().rgh10201().fgh102NsMovimento());
        hv12701Movhstcp7().movhstcp7().cTransaccao().set(bghr1021().rgh10201().fgh102CTransaccao());
        hv12701Movhstcp7().movhstcp7().aAplicacao().set(bghr1021().rgh10201().fgh102AAplicacao());
        hv12701Movhstcp7().movhstcp7().cOpczMenu().set(bghr1021().rgh10201().fgh102COpczMenu());
        hv12701Movhstcp7().movhstcp7().cOpeBbn().set(bghr1021().rgh10201().fgh102COpeBbn());
        hv12701Movhstcp7().movhstcp7().cEvenOpel().set(bghr1021().rgh10201().fgh102CEvenOpel());
        hv12701Movhstcp7().movhstcp7().cTerminal().set(bghr1021().rgh10201().fgh102CTerminal());
        hv12701Movhstcp7().movhstcp7().cOperador().set(bghr1021().rgh10201().fgh102COperador());
        hv12701Movhstcp7().movhstcp7().cOpexAtrx().set(bghr1021().rgh10201().fgh102COpexAtrx());
        hv12701Movhstcp7().movhstcp7().cUserid().set(bghr1021().rgh10201().fgh102CUserid());
        hv12701Movhstcp7().movhstcp7().cTipoCanlAces().set(bghr1021().rgh10201().fgh102CTipoCanlAces());
        hv12701Movhstcp7().movhstcp7().cPaisIsoaOeOpx().set(bghr1021().rgh10201().fgh102CPaisIsoaOeOpx());
        hv12701Movhstcp7().movhstcp7().cMnemEgcOpex().set(bghr1021().rgh10201().fgh102CMnemEgcOpex());
        hv12701Movhstcp7().movhstcp7().cOeEgcOpex().set(bghr1021().rgh10201().fgh102COeEgcOpex());
        hv12701Movhstcp7().movhstcp7().cProdSgop().set(bghr1021().rgh10201().fgh102CProdSgop());
        hv12701Movhstcp7().movhstcp7().cFamiProd().set(bghr1021().rgh10201().fgh102CFamiProd());
        hv12701Movhstcp7().movhstcp7().cProduto().set(bghr1021().rgh10201().fgh102CProduto());
        hv12701Movhstcp7().movhstcp7().cCndzMovzCont().set(bghr1021().rgh10201().fgh102CCndzMovzCont());
        hv12701Movhstcp7().movhstcp7().cGrupCont().set(bghr1021().rgh10201().fgh102CGrupCont());
        hv12701Movhstcp7().movhstcp7().cTipoIttz().set(bghr1021().rgh10201().fgh102CTipoIttz());
        hv12701Movhstcp7().movhstcp7().tCambio().set(bghr1021().rgh10201().fgh102TCambio());
        hv12701Movhstcp7().movhstcp7().mSldoRetd().set(bghr1021().rgh10201().fgh102MSldoRetd());
        hv12701Movhstcp7().movhstcp7().mSldoVcob().set(bghr1021().rgh10201().fgh102MSldoVcob());
        hv12701Movhstcp7().movhstcp7().mCmrgLim().set(bghr1021().rgh10201().fgh102MCmrgLim());
        hv12701Movhstcp7().movhstcp7().mCmrgUtid().set(bghr1021().rgh10201().fgh102MCmrgUtid());
        hv12701Movhstcp7().movhstcp7().mDcboNgcdAtrd().set(bghr1021().rgh10201().fgh102MDcboNgcdAtrd());
        hv12701Movhstcp7().movhstcp7().mDcboNgcdUtid().set(bghr1021().rgh10201().fgh102MDcboNgcdUtid());
        hv12701Movhstcp7().movhstcp7().nJourBbn().set(bghr1021().rgh10201().fgh102NJourBbn());
        hv12701Movhstcp7().movhstcp7().nsJourBbn().set(bghr1021().rgh10201().fgh102NsJourBbn());
        hv12701Movhstcp7().movhstcp7().nsJourBbnDtlh().set(bghr1021().rgh10201().fgh102NsJourBbnDtlh());
        hv12701Movhstcp7().movhstcp7().nmArqvOrig().set(bghr1021().rgh10201().fgh102NmArqvOrig());
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        hv12701Movhstcp7().movhstcp7().cCatgMov().set(bhol826a().commarea().dadosOutput().cCatgMov());
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        hv12701Movhstcp7().movhstcp7().tsActzUlt().set(bghr1021().rgh10201().fgh102TsActzUlt());
        hv12701Movhstcp7().movhstcp7().cUsidActzUlt().set(bghr1021().rgh10201().fgh102CUsidActzUlt());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH12701_MOVHSTCP7
         */
        hv12701Movhstcp7().insertPghqz06a2361() ;
        if (hv12701Movhstcp7().getPersistenceCode() == PersistenceCode.NORMAL) {
            contRegInsVgh12701.add(1);
        }
        if (hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.NORMAL && 
            hv12701Movhstcp7().getPersistenceCode() != PersistenceCode.DUPLICATED) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - VGH12701-INSERT - ");
            wSqlcode.set(hv12701Movhstcp7().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000ControlaCommit() {
        log(TraceLevel.Debug, "A33000-CONTROLA-COMMIT");
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
                tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - READ - ");
                tabelaImpressao().linha09().impStatus().set(wSqlcode);
            }
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
        if (progOk.isTrue()) {
            fwk900().fwk900RegPghqz06a().initialize() ;
            fwk900().fwk900RegPghqz06a().fwk900NCommit().set(add(fwk900().fwk900RegPghqz06a().fwk900NCommit(), contRegCommit));
            fwk900().rewrite(fwk900().fwk900RegPghqz06a()) ;
            if (!fwk900().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHQZ06A - FWK900 - REWRITE -");
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
        /**
         * PASSIVAS 2540 - 2018-03-13 - INI
         */
        if (progOk.isTrue()) {
            a30001AcedeMhoj826a() ;
        }
        /**
         * PASSIVAS 2540 - 2018-03-13 - FIM
         */
        if (progOk.isTrue()) {
            while (contRegLidosFwk013.isLessOrEqual(auxContRegLidos) && !fwk013().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17008LerFwk013() ;
            }
            if (!fwk013().getStatusOk()) {
                while (!fwk013().getStatusOk() && progOk.isTrue()) {
                    s30008ProcessarFwk013() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk014.isLessOrEqual(auxContRegLidos) && !fwk014().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17009LerFwk014() ;
            }
            if (!fwk014().getStatusOk()) {
                while (!fwk014().getStatusOk() && progOk.isTrue()) {
                    s30009ProcessarFwk014() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk015.isLessOrEqual(auxContRegLidos) && !fwk015().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17010LerFwk015() ;
            }
            if (!fwk015().getStatusOk()) {
                while (!fwk015().getStatusOk() && progOk.isTrue()) {
                    s30010ProcessarFwk015() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk016.isLessOrEqual(auxContRegLidos) && !fwk016().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17011LerFwk016() ;
            }
            if (!fwk016().getStatusOk()) {
                while (!fwk016().getStatusOk() && progOk.isTrue()) {
                    s30011ProcessarFwk016() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk017.isLessOrEqual(auxContRegLidos) && !fwk017().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17012LerFwk017() ;
            }
            if (!fwk017().getStatusOk()) {
                while (!fwk017().getStatusOk() && progOk.isTrue()) {
                    s30012ProcessarFwk017() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk018.isLessOrEqual(auxContRegLidos) && !fwk018().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17013LerFwk018() ;
            }
            if (!fwk018().getStatusOk()) {
                while (!fwk018().getStatusOk() && progOk.isTrue()) {
                    s30013ProcessarFwk018() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a15100TratarOutputFwk900() ;
            while (contRegLidosFwk019.isLessOrEqual(auxContRegLidos) && !fwk019().getStatusOk() && progStatus.isLessOrEqual(0)) {
                a17014LerFwk019() ;
            }
            if (!fwk019().getStatusOk()) {
                while (!fwk019().getStatusOk() && progOk.isTrue()) {
                    s30014ProcessarFwk019() ;
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
            
            @Data(size=8, value="PGHQZ06A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQZ06A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=32, value="NUMERO DE REGISTOS LIDOS EM")
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
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=53, lpaddingValue=" ", rpaddingValue=" ")
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
