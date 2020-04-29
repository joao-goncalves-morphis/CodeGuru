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
import cgd.gr.structures.link.Bgrl030a ;


/**
 * 
 * FGH300 - FICHEIRO DE CONTROLO DE EXECUCAO DO PROGRAMA
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * -------->   MIGRACAO DA APLICACAO HO   <------------
 * PROGRAMA      : PGHC502A
 * OBJECTIVOS    : SEPARA FICHEIRO FWK050 - SORT DE FHO452 E
 * FHO709 EM 14 FICHEIROS DE TRABALHO
 * FWK051 - DO BALCAO 1 A 100
 * FWK052 - DO BALCAO 101 A 200
 * FWK053 - DO BALCAO 201 A 300
 * FWK054 - DO BALCAO 301 A 400
 * FWK055 - DO BALCAO 401 A 500
 * FWK056 - DO BALCAO 501 A 600
 * FWK057 - DO BALCAO 601 A 700
 * FWK058 - DO BALCAO 701 A 800
 * FWK059 - DO BALCAO 801 A 900
 * FWK060 - DO BALCAO 901 A 1500
 * FWK061 - DO BALCAO 1501 A 2100
 * FWK062 - DO BALCAO 2101 A 2500
 * FWK063 - DO BALCAO 2501 A 9999
 * FWK064 - CONTAS OFFSHORE
 * ALTERACAO     :
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc502a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk05001
     */
    @Handler(name="FWK050", record="regFwk050")
    @Data
    protected abstract Fwk05001 fwk050() ;
    
    /**
     * @return instancia da classe Fwk05102
     */
    @Handler(name="FWK051", record="fwk051Reg160")
    @Data
    protected abstract Fwk05102 fwk051() ;
    
    /**
     * @return instancia da classe Fwk05202
     */
    @Handler(name="FWK052", record="fwk052Reg160")
    @Data
    protected abstract Fwk05202 fwk052() ;
    
    /**
     * @return instancia da classe Fwk05302
     */
    @Handler(name="FWK053", record="fwk053Reg160")
    @Data
    protected abstract Fwk05302 fwk053() ;
    
    /**
     * @return instancia da classe Fwk05402
     */
    @Handler(name="FWK054", record="fwk054Reg160")
    @Data
    protected abstract Fwk05402 fwk054() ;
    
    /**
     * @return instancia da classe Fwk05502
     */
    @Handler(name="FWK055", record="fwk055Reg160")
    @Data
    protected abstract Fwk05502 fwk055() ;
    
    /**
     * @return instancia da classe Fwk05602
     */
    @Handler(name="FWK056", record="fwk056Reg160")
    @Data
    protected abstract Fwk05602 fwk056() ;
    
    /**
     * @return instancia da classe Fwk05702
     */
    @Handler(name="FWK057", record="fwk057Reg160")
    @Data
    protected abstract Fwk05702 fwk057() ;
    
    /**
     * @return instancia da classe Fwk05802
     */
    @Handler(name="FWK058", record="fwk058Reg160")
    @Data
    protected abstract Fwk05802 fwk058() ;
    
    /**
     * @return instancia da classe Fwk05902
     */
    @Handler(name="FWK059", record="fwk059Reg160")
    @Data
    protected abstract Fwk05902 fwk059() ;
    
    /**
     * @return instancia da classe Fwk06002
     */
    @Handler(name="FWK060", record="fwk060Reg160")
    @Data
    protected abstract Fwk06002 fwk060() ;
    
    /**
     * @return instancia da classe Fwk06102
     */
    @Handler(name="FWK061", record="fwk061Reg160")
    @Data
    protected abstract Fwk06102 fwk061() ;
    
    /**
     * @return instancia da classe Fwk06202
     */
    @Handler(name="FWK062", record="fwk062Reg160")
    @Data
    protected abstract Fwk06202 fwk062() ;
    
    /**
     * @return instancia da classe Fwk06302
     */
    @Handler(name="FWK063", record="fwk063Reg160")
    @Data
    protected abstract Fwk06302 fwk063() ;
    
    /**
     * @return instancia da classe Fwk06402
     */
    @Handler(name="FWK064", record="fwk064Reg160")
    @Data
    protected abstract Fwk06402 fwk064() ;
    
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
     * @return instancia da classe local ChaveFwk050
     */
    @Data
    protected abstract ChaveFwk050 chaveFwk050() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk050 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk051 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk052 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk053 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk054 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk055 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk056 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk057 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk058 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk059 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk060 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk061 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk062 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk063 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk064 ;
    
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
        bghw0300().wsNmPrograma().set("PGHC502A");
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
        fwk051().open(CREATE ) ;
        if (!fwk051().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK051 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
        }
        if (progOk.isTrue()) {
            fwk052().open(CREATE ) ;
            if (!fwk052().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK052 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk052().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk053().open(CREATE ) ;
            if (!fwk053().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK053 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk053().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk054().open(CREATE ) ;
            if (!fwk054().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK054 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk054().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk055().open(CREATE ) ;
            if (!fwk055().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK055 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk055().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk056().open(CREATE ) ;
            if (!fwk056().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK056 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk056().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk057().open(CREATE ) ;
            if (!fwk057().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK057 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk057().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk058().open(CREATE ) ;
            if (!fwk058().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK058 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk058().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk059().open(CREATE ) ;
            if (!fwk059().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK059 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk059().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk060().open(CREATE ) ;
            if (!fwk060().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK060 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk060().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk061().open(CREATE ) ;
            if (!fwk061().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK061 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk061().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk062().open(CREATE ) ;
            if (!fwk062().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK062 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk062().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk063().open(CREATE ) ;
            if (!fwk063().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK063 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk063().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk064().open(CREATE ) ;
            if (!fwk064().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK064 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk064().getStatus());
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
            a31000OpenFwk050() ;
            if (progOk.isTrue()) {
                a32000LerFwk050() ;
            }
            if (progOk.isTrue()) {
                while (!fwk050().getStatusOk() && progOk.isTrue()) {
                    a33000TratarFwk050() ;
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
    protected void a31000OpenFwk050() {
        log(TraceLevel.Debug, "A31000-OPEN-FWK050");
        fwk050().open() ;
        if (!fwk050().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK050 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk050().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000LerFwk050() {
        log(TraceLevel.Debug, "A32000-LER-FWK050");
        fwk050().read() ;
        if (fwk050().getStatusOk()) {
            chaveFwk050().cPaisIsoaContFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050CPaisIsoaCont());
            chaveFwk050().cBancContFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050CBancCont());
            chaveFwk050().cOeEgcContFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont());
            chaveFwk050().nsRdclContFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050NsRdclCont());
            chaveFwk050().vChkdContFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050VChkdCont());
            chaveFwk050().cTipoContFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050CTipoCont());
            chaveFwk050().cMoedIsoSctaFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050CMoedIsoScta());
            chaveFwk050().nsDepositoFwk050().set(fwk050().regFwk050().fwk050Subconta().fwk050NsDeposito());
            contRegLidosFwk050.add(1);
        }
        if (!fwk050().getStatusOk() && !fwk050().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK050 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk050().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000TratarFwk050() {
        log(TraceLevel.Debug, "A33000-TRTAR-FWK050");
        if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050CPaisIsoaCont().isEqual("PT") && 
            fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050CBancCont().isEqual(35)) {
            if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(0) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(100)) {
                a34000EscreverFwk051() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(101) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(200)) {
                a35000EscreverFwk052() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(201) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(300)) {
                a36000EscreverFwk053() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(301) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(400)) {
                a37000EscreverFwk054() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(401) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(500)) {
                a38000EscreverFwk055() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(501) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(600)) {
                a39000EscreverFwk056() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(601) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(700)) {
                a40000EscreverFwk057() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(701) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(800)) {
                a41000EscreverFwk058() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(801) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(900)) {
                a42000EscreverFwk059() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(901) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(1500)) {
                a43000EscreverFwk060() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(1501) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(2100)) {
                a44000EscreverFwk061() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(2101) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(2500)) {
                a45000EscreverFwk062() ;
            } else if (fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isGreaterOrEqual(2501) && 
                fwk050().regFwk050().fwk050Subconta().fwk050Conta().fwk050COeEgcCont().isLessOrEqual(9999)) {
                a46000EscreverFwk063() ;
            }
        } else {
            a47000EscreverFwk064() ;
        }
        if (progOk.isTrue()) {
            a32000LerFwk050() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreverFwk051() {
        log(TraceLevel.Debug, "A34000-ESCREVER-FWK051");
        fwk051().fwk051Reg160.initialize() ;
        fwk051().setRecord(fwk050().getRecord()) ;
        fwk051().write(fwk051().fwk051Reg160) ;
        if (fwk051().getStatusOk()) {
            contRegEscrtFwk051.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK051 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35000EscreverFwk052() {
        log(TraceLevel.Debug, "A35000-ESCREVER-FWK052");
        fwk052().fwk052Reg160.initialize() ;
        fwk052().setRecord(fwk050().getRecord()) ;
        fwk052().write(fwk052().fwk052Reg160) ;
        if (fwk052().getStatusOk()) {
            contRegEscrtFwk052.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK052 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk052().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36000EscreverFwk053() {
        log(TraceLevel.Debug, "A36000-ESCREVER-FWK053");
        fwk053().fwk053Reg160.initialize() ;
        fwk053().setRecord(fwk050().getRecord()) ;
        fwk053().write(fwk053().fwk053Reg160) ;
        if (fwk053().getStatusOk()) {
            contRegEscrtFwk053.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK053 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk053().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a37000EscreverFwk054() {
        log(TraceLevel.Debug, "A37000-ESCREVER-FWK054");
        fwk054().fwk054Reg160.initialize() ;
        fwk054().setRecord(fwk050().getRecord()) ;
        fwk054().write(fwk054().fwk054Reg160) ;
        if (fwk054().getStatusOk()) {
            contRegEscrtFwk054.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK054 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk054().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a38000EscreverFwk055() {
        log(TraceLevel.Debug, "A38000-ESCREVER-FWK055");
        fwk055().fwk055Reg160.initialize() ;
        fwk055().setRecord(fwk050().getRecord()) ;
        fwk055().write(fwk055().fwk055Reg160) ;
        if (fwk055().getStatusOk()) {
            contRegEscrtFwk055.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK055 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk055().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a39000EscreverFwk056() {
        log(TraceLevel.Debug, "A39000-ESCREVER-FWK056");
        fwk056().fwk056Reg160.initialize() ;
        fwk056().setRecord(fwk050().getRecord()) ;
        fwk056().write(fwk056().fwk056Reg160) ;
        if (fwk056().getStatusOk()) {
            contRegEscrtFwk056.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK056 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk056().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a40000EscreverFwk057() {
        log(TraceLevel.Debug, "A40000-ESCREVER-FWK057");
        fwk057().fwk057Reg160.initialize() ;
        fwk057().setRecord(fwk050().getRecord()) ;
        fwk057().write(fwk057().fwk057Reg160) ;
        if (fwk057().getStatusOk()) {
            contRegEscrtFwk057.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK057 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk057().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a41000EscreverFwk058() {
        log(TraceLevel.Debug, "A41000-ESCREVER-FWK058");
        fwk058().fwk058Reg160.initialize() ;
        fwk058().setRecord(fwk050().getRecord()) ;
        fwk058().write(fwk058().fwk058Reg160) ;
        if (fwk058().getStatusOk()) {
            contRegEscrtFwk058.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK058 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk058().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a42000EscreverFwk059() {
        log(TraceLevel.Debug, "A42000-ESCREVER-FWK059");
        fwk059().fwk059Reg160.initialize() ;
        fwk059().setRecord(fwk050().getRecord()) ;
        fwk059().write(fwk059().fwk059Reg160) ;
        if (fwk059().getStatusOk()) {
            contRegEscrtFwk059.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK059 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk059().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a43000EscreverFwk060() {
        log(TraceLevel.Debug, "A42000-ESCREVER-FWK060");
        fwk060().fwk060Reg160.initialize() ;
        fwk060().setRecord(fwk050().getRecord()) ;
        fwk060().write(fwk060().fwk060Reg160) ;
        if (fwk060().getStatusOk()) {
            contRegEscrtFwk060.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK060 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk060().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a44000EscreverFwk061() {
        log(TraceLevel.Debug, "A44000-ESCREVER-FWK061");
        fwk061().fwk061Reg160.initialize() ;
        fwk061().setRecord(fwk050().getRecord()) ;
        fwk061().write(fwk061().fwk061Reg160) ;
        if (fwk061().getStatusOk()) {
            contRegEscrtFwk061.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK061 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk061().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a45000EscreverFwk062() {
        log(TraceLevel.Debug, "A45000-ESCREVER-FWK062");
        fwk062().fwk062Reg160.initialize() ;
        fwk062().setRecord(fwk050().getRecord()) ;
        fwk062().write(fwk062().fwk062Reg160) ;
        if (fwk062().getStatusOk()) {
            contRegEscrtFwk062.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK062 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk062().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a46000EscreverFwk063() {
        log(TraceLevel.Debug, "A45000-ESCREVER-FWK063");
        fwk063().fwk063Reg160.initialize() ;
        fwk063().setRecord(fwk050().getRecord()) ;
        fwk063().write(fwk063().fwk063Reg160) ;
        if (fwk063().getStatusOk()) {
            contRegEscrtFwk063.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK063 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk063().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a47000EscreverFwk064() {
        log(TraceLevel.Debug, "A47000-ESCREVER-FWK064");
        fwk064().fwk064Reg160.initialize() ;
        fwk064().setRecord(fwk050().getRecord()) ;
        fwk064().write(fwk064().fwk064Reg160) ;
        if (fwk064().getStatusOk()) {
            contRegEscrtFwk064.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK064 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk064().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a48000FecharFicheiros() {
        log(TraceLevel.Debug, "A48000-FECHAR-FICHEIROS");
        fwk051().close() ;
        if (!fwk051().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK051 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
        }
        fwk052().close() ;
        if (!fwk052().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK052 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk052().getStatus());
        }
        fwk053().close() ;
        if (!fwk053().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK053 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk053().getStatus());
        }
        fwk054().close() ;
        if (!fwk054().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK054 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
        }
        fwk055().close() ;
        if (!fwk055().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK055 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk055().getStatus());
        }
        fwk056().close() ;
        if (!fwk056().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK056 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
        }
        fwk057().close() ;
        if (!fwk057().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK057 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk057().getStatus());
        }
        fwk058().close() ;
        if (!fwk058().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK058 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk058().getStatus());
        }
        fwk059().close() ;
        if (!fwk059().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK059 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk059().getStatus());
        }
        fwk060().close() ;
        if (!fwk060().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK060 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk060().getStatus());
        }
        fwk062().close() ;
        if (!fwk062().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK062 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk062().getStatus());
        }
        fwk063().close() ;
        if (!fwk063().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK063 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk063().getStatus());
        }
        fwk064().close() ;
        if (!fwk064().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK064 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk064().getStatus());
        }
        fwk050().close() ;
        if (!fwk050().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC502A - FWK050 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk050().getStatus());
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
            tabelaImpressao().linha05().impRegLidosFwk050().set(contRegLidosFwk050);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk051);
            tabelaImpressao().linha06().impFichEsc().set("FWK051");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk052);
            tabelaImpressao().linha06().impFichEsc().set("FWK052");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk053);
            tabelaImpressao().linha06().impFichEsc().set("FWK053");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk054);
            tabelaImpressao().linha06().impFichEsc().set("FWK054");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk055);
            tabelaImpressao().linha06().impFichEsc().set("FWK055");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk056);
            tabelaImpressao().linha06().impFichEsc().set("FWK056");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk057);
            tabelaImpressao().linha06().impFichEsc().set("FWK057");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk058);
            tabelaImpressao().linha06().impFichEsc().set("FWK058");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk059);
            tabelaImpressao().linha06().impFichEsc().set("FWK059");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk060);
            tabelaImpressao().linha06().impFichEsc().set("FWK060");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk061);
            tabelaImpressao().linha06().impFichEsc().set("FWK061");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk062);
            tabelaImpressao().linha06().impFichEsc().set("FWK062");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk063);
            tabelaImpressao().linha06().impFichEsc().set("FWK063");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk064);
            tabelaImpressao().linha06().impFichEsc().set("FWK064");
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC502A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
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
    public interface ChaveFwk050 extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaContFwk050() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancContFwk050() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcContFwk050() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclContFwk050() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdContFwk050() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoContFwk050() ;
        
        @Data(size=3)
        IString cMoedIsoSctaFwk050() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDepositoFwk050() ;
        
    }
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
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHC502A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC502A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK050")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk050() ;
            
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
