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
import cgd.gh.structures.work.Bghw0015 ;


/**
 * 
 * FGH300 - FICHEIRO DE CONTROLO DE EXECUCAO DO PROGRAMA
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * ----> TRATAMENTO DOS MOVIMENTOS DO DIA DO HO <------
 * PROGRAMA      : PGHC001A
 * OBJECTIVOS    : SEPARA FICHEIRO FWK923 RECEBIDO DOS HO
 * MOVIMENTOS DO DIA EM 14 FICHEIRO:
 * FWK001 - MO E (PT DO BALCAO 1 A 100)
 * FWK051
 * FWK002 - DO BALCAO 101 A 200
 * FWK052
 * FWK003 - DO BALCAO 201 A 300
 * FWK053
 * FWK004 - DO BALCAO 301 A 400
 * FWK054
 * FWK005 - DO BALCAO 401 A 500
 * FWK055
 * FWK006 - DO BALCAO 501 A 600
 * FWK056
 * FWK007 - DO BALCAO 601 A 700
 * FWK057
 * FWK008 - DO BALCAO 701 A 800
 * FWK058
 * FWK009 - DO BALCAO 801 A 900
 * FWK059
 * FWK010 - DO BALCAO 901 A 1500
 * FWK060
 * FWK011 - DO BALCAO 1501 A 2100
 * FWK061
 * FWK012 - DO BALCAO 2101 A 2500
 * FWK062
 * FWK013 - DO BALCAO 2501 A 9999
 * FWK063
 * FWK014 - CONTAS OFFSHORE
 * FWK064
 * - OS FICHEIROS FWK05* E 06* DESTINAM-SE A
 * ACTUALIZACAO DAS TABELA TGH00001_CONTHST E
 * TGH00010_CONTIPHST
 * - O FICHEIRO FWK070 DESTINA-SE A ACTUALIZAR A
 * ACTUALIZAR A TABELA TGH00009_INFAUXMOV
 * ALTERACAO     :
 * ACCENTURE      : GH1863 - INCLUSAO DE NOVOS CAMPOS E NOVO FICH
 * DE INPUT FWK600, REPRO DO FHO04C DE UNLOAD DA
 * TABELA THO00022_MOVDIAANT
 * ACCENTURE      : GH1957 - INCLUSAO DE INFORMACAO DO DEBUG
 * ATRAVES DE SYSIN (S - PARA DEBUG ON E N - PARA*
 * DEBUG OFF)
 * ACCENTURE      : GH1960 - RETIRADO A ATRIBUICAO DO DEBUG ATIVO
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc001a extends CgdGhBaseBatch {
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fwk600
     */
    @Handler(name="FWK600", record="regFwk600Pghc001a")
    @Data
    protected abstract Fwk600 ficheiroFwk600() ;
    
    /**
     * @return instancia da classe Fwk00101
     */
    @Handler(name="FWK001", record="fwk001Reg327")
    @Data
    protected abstract Fwk00101 fwk001() ;
    
    /**
     * @return instancia da classe Fwk00201
     */
    @Handler(name="FWK002", record="fwk002Reg327")
    @Data
    protected abstract Fwk00201 fwk002() ;
    
    /**
     * @return instancia da classe Fwk00301
     */
    @Handler(name="FWK003", record="fwk003Reg327")
    @Data
    protected abstract Fwk00301 fwk003() ;
    
    /**
     * @return instancia da classe Fwk00401
     */
    @Handler(name="FWK004", record="fwk004Reg327")
    @Data
    protected abstract Fwk00401 fwk004() ;
    
    /**
     * @return instancia da classe Fwk00501
     */
    @Handler(name="FWK005", record="fwk005Reg327")
    @Data
    protected abstract Fwk00501 fwk005() ;
    
    /**
     * @return instancia da classe Fwk00601
     */
    @Handler(name="FWK006", record="fwk006Reg327")
    @Data
    protected abstract Fwk00601 fwk006() ;
    
    /**
     * @return instancia da classe Fwk00701
     */
    @Handler(name="FWK007", record="fwk007Reg327")
    @Data
    protected abstract Fwk00701 fwk007() ;
    
    /**
     * @return instancia da classe Fwk00801
     */
    @Handler(name="FWK008", record="fwk008Reg327")
    @Data
    protected abstract Fwk00801 fwk008() ;
    
    /**
     * @return instancia da classe Fwk00901
     */
    @Handler(name="FWK009", record="fwk009Reg327")
    @Data
    protected abstract Fwk00901 fwk009() ;
    
    /**
     * @return instancia da classe Fwk01001
     */
    @Handler(name="FWK010", record="fwk010Reg327")
    @Data
    protected abstract Fwk01001 fwk010() ;
    
    /**
     * @return instancia da classe Fwk01101
     */
    @Handler(name="FWK011", record="fwk011Reg327")
    @Data
    protected abstract Fwk01101 fwk011() ;
    
    /**
     * @return instancia da classe Fwk01201
     */
    @Handler(name="FWK012", record="fwk012Reg327")
    @Data
    protected abstract Fwk01201 fwk012() ;
    
    /**
     * @return instancia da classe Fwk01301
     */
    @Handler(name="FWK013", record="fwk013Reg327")
    @Data
    protected abstract Fwk01301 fwk013() ;
    
    /**
     * @return instancia da classe Fwk014
     */
    @Handler(name="FWK014", record="fwk014Reg327")
    @Data
    protected abstract Fwk014 fwk014() ;
    
    /**
     * @return instancia da classe Fwk923
     */
    @Handler(name="FWK923", record="regFwk267")
    @Data
    protected abstract Fwk923 ficheiroFwk923() ;
    
    /**
     * @return instancia da classe Fwk05101
     */
    @Handler(name="FWK051", record="fwk051Reg32")
    @Data
    protected abstract Fwk05101 fwk051() ;
    
    /**
     * @return instancia da classe Fwk05201
     */
    @Handler(name="FWK052", record="fwk052Reg32")
    @Data
    protected abstract Fwk05201 fwk052() ;
    
    /**
     * @return instancia da classe Fwk05301
     */
    @Handler(name="FWK053", record="fwk053Reg32")
    @Data
    protected abstract Fwk05301 fwk053() ;
    
    /**
     * @return instancia da classe Fwk05401
     */
    @Handler(name="FWK054", record="fwk054Reg32")
    @Data
    protected abstract Fwk05401 fwk054() ;
    
    /**
     * @return instancia da classe Fwk05501
     */
    @Handler(name="FWK055", record="fwk055Reg32")
    @Data
    protected abstract Fwk05501 fwk055() ;
    
    /**
     * @return instancia da classe Fwk05601
     */
    @Handler(name="FWK056", record="fwk056Reg32")
    @Data
    protected abstract Fwk05601 fwk056() ;
    
    /**
     * @return instancia da classe Fwk05701
     */
    @Handler(name="FWK057", record="fwk057Reg32")
    @Data
    protected abstract Fwk05701 fwk057() ;
    
    /**
     * @return instancia da classe Fwk05801
     */
    @Handler(name="FWK058", record="fwk058Reg32")
    @Data
    protected abstract Fwk05801 fwk058() ;
    
    /**
     * @return instancia da classe Fwk05901
     */
    @Handler(name="FWK059", record="fwk059Reg32")
    @Data
    protected abstract Fwk05901 fwk059() ;
    
    /**
     * @return instancia da classe Fwk06001
     */
    @Handler(name="FWK060", record="fwk060Reg32")
    @Data
    protected abstract Fwk06001 fwk060() ;
    
    /**
     * @return instancia da classe Fwk06101
     */
    @Handler(name="FWK061", record="fwk061Reg32")
    @Data
    protected abstract Fwk06101 fwk061() ;
    
    /**
     * @return instancia da classe Fwk06201
     */
    @Handler(name="FWK062", record="fwk062Reg32")
    @Data
    protected abstract Fwk06201 fwk062() ;
    
    /**
     * @return instancia da classe Fwk06301
     */
    @Handler(name="FWK063", record="fwk063Reg32")
    @Data
    protected abstract Fwk06301 fwk063() ;
    
    /**
     * @return instancia da classe Fwk06401
     */
    @Handler(name="FWK064", record="fwk064Reg32")
    @Data
    protected abstract Fwk06401 fwk064() ;
    
    /**
     * @return instancia da classe Fwk070
     */
    @Handler(name="FWK070", record="fwk070RegPghc001a")
    @Data
    protected abstract Fwk070 fwk070() ;
    
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
    
    /**
     * @return instancia da classe Bghw0015
     */
    @Data
    protected abstract Bghw0015 bghw0015() ;
    
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
     * @return instancia da classe local ChaveBhow8267
     */
    @Data
    protected abstract ChaveBhow8267 chaveBhow8267() ;
    
    /**
     * @return instancia da classe local ChaveAnt
     */
    @Data
    protected abstract ChaveAnt chaveAnt() ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk923 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk600 ;
    
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
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk014 ;
    
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
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegEscrtFwk070 ;
    
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
     * GH1863 - INI
     * @return instancia da classe local WsChaveFwk923
     */
    @Data
    protected abstract WsChaveFwk923 wsChaveFwk923() ;
    
    /**
     * @return instancia da classe local WsChaveFwk600
     */
    @Data
    protected abstract WsChaveFwk600 wsChaveFwk600() ;
    
    
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHC001A");
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
        wsChaveFwk923().initialize() ;
        wsChaveFwk600().initialize() ;
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
        fwk001().open(CREATE ) ;
        if (!fwk001().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK001 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
        if (progOk.isTrue()) {
            fwk002().open(CREATE ) ;
            if (!fwk002().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK002 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk002().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk003().open(CREATE ) ;
            if (!fwk003().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK003 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk004().open(CREATE ) ;
            if (!fwk004().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK004 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk004().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk005().open(CREATE ) ;
            if (!fwk005().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK005 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk005().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk006().open(CREATE ) ;
            if (!fwk006().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK006 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk006().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk007().open(CREATE ) ;
            if (!fwk007().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK007 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk007().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk008().open(CREATE ) ;
            if (!fwk008().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK008 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk008().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk009().open(CREATE ) ;
            if (!fwk009().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK009 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk009().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk010().open(CREATE ) ;
            if (!fwk010().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK010 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk010().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk011().open(CREATE ) ;
            if (!fwk011().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK011 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk011().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk012().open(CREATE ) ;
            if (!fwk012().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK012 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk012().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk013().open(CREATE ) ;
            if (!fwk013().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK013 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk013().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk014().open(CREATE ) ;
            if (!fwk014().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK014 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk014().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk051().open(CREATE ) ;
            if (!fwk051().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK051 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk052().open(CREATE ) ;
            if (!fwk052().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK052 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk052().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk053().open(CREATE ) ;
            if (!fwk053().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK053 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk053().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk054().open(CREATE ) ;
            if (!fwk054().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK054 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk054().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk055().open(CREATE ) ;
            if (!fwk055().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK055 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk055().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk056().open(CREATE ) ;
            if (!fwk056().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK056 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk056().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk057().open(CREATE ) ;
            if (!fwk057().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK057 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk057().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk058().open(CREATE ) ;
            if (!fwk058().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK058 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk058().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk059().open(CREATE ) ;
            if (!fwk059().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK059 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk059().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk060().open(CREATE ) ;
            if (!fwk060().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK060 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk060().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk061().open(CREATE ) ;
            if (!fwk061().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK061 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk061().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk062().open(CREATE ) ;
            if (!fwk062().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK062 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk062().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk063().open(CREATE ) ;
            if (!fwk063().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK063 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk063().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk064().open(CREATE ) ;
            if (!fwk064().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK064 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk064().getStatus());
            }
        }
        if (progOk.isTrue()) {
            fwk070().open(CREATE ) ;
            if (!fwk070().getStatusOk()) {
                setReturnCode(16) ;
                progStatus.set(16);
                tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK070 - OPEN - ");
                tabelaImpressao().linha09().impStatus().set(fwk070().getStatus());
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
            a31000OpenFwk923() ;
            /**
             * GH1863 - INI
             */
            if (progOk.isTrue()) {
                a31100OpenFwk600() ;
            }
            /**
             * GH1863 - FIM
             */
            if (progOk.isTrue()) {
                a32000LerFwk923() ;
            }
            if (progOk.isTrue()) {
                while (!ficheiroFwk923().getStatusOk() && progOk.isTrue()) {
                    a33000TratarFwk923() ;
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
    protected void a31000OpenFwk923() {
        log(TraceLevel.Debug, "A31000-OPEN-FWK923");
        ficheiroFwk923().open() ;
        if (!ficheiroFwk923().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK923 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(ficheiroFwk923().getStatus());
        }
    }
    
    /**
     * 
     * GH1863 - INI
     * 
     */
    protected void a31100OpenFwk600() {
        log(TraceLevel.Debug, "A31100-OPEN-FWK600");
        ficheiroFwk600().open() ;
        if (!ficheiroFwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK600 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(ficheiroFwk600().getStatus());
        }
    }
    
    /**
     * 
     * GH1863 - FIM
     * 
     */
    protected void a32000LerFwk923() {
        log(TraceLevel.Debug, "A32000-LER-FWK923");
        ficheiroFwk923().read() ;
        if (ficheiroFwk923().getStatusOk()) {
            contRegLidosFwk923.add(1);
            chaveBhow8267().cPaisIsoaContBhow8267().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
            wsChaveFwk923().wsCPaisIsoaFwk923().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
            chaveBhow8267().cBancContBhow8267().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
            wsChaveFwk923().wsCBancContFwk923().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
            chaveBhow8267().cOeEgcContBhow8267().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
            wsChaveFwk923().wsCOeEgcContFwk923().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
            chaveBhow8267().nsRdclContBhow8267().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
            wsChaveFwk923().wsNsRdclContFwk923().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
            chaveBhow8267().vChkdContBhow8267().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
            wsChaveFwk923().wsVChkdContFwk923().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
            chaveBhow8267().cTipoContBhow8267().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
            wsChaveFwk923().wsCTipoContFwk923().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
            chaveBhow8267().cMoedIsoSctaBhow8267().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
            wsChaveFwk923().wsCMoedIsoFwk923().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
            chaveBhow8267().nsDepositoBhow8267().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
            wsChaveFwk923().wsNsDepositoFwk923().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
            wsChaveFwk923().wsNsMovimentoFwk923().set(ficheiroFwk923().regFwk267().nsMovimento());
            if (chaveBhow8267().isEqual(chaveAnt())) {
                swContaIgual.setTrue() ;
            } else {
                swContaDiferente.setTrue() ;
                chaveAnt().cPaisIsoaContAnt().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
                chaveAnt().cBancContAnt().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
                chaveAnt().cOeEgcContAnt().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
                chaveAnt().nsRdclContAnt().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
                chaveAnt().vChkdContAnt().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
                chaveAnt().cTipoContAnt().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
                chaveAnt().cMoedIsoSctaAnt().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
                chaveAnt().nsDepositoAnt().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
            }
        }
        if (!ficheiroFwk923().getStatusOk() && !ficheiroFwk923().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK001 - READ - ");
            tabelaImpressao().linha09().impStatus().set(ficheiroFwk923().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000TratarFwk923() {
        log(TraceLevel.Debug, "A33000-TRTAR-FWK923");
        log(TraceLevel.Debug, "CONTA INPUT: ", ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont(), ficheiroFwk923().regFwk267().subconta().cBancCont(), ficheiroFwk923().regFwk267().subconta().cOeEgcCont(), ficheiroFwk923().regFwk267().subconta().nsRdclCont(), ficheiroFwk923().regFwk267().subconta().vChkdCont(), ficheiroFwk923().regFwk267().subconta().cTipoCont(), ficheiroFwk923().regFwk267().subconta().cMoedIsoScta(), ficheiroFwk923().regFwk267().subconta().nsDeposito(), " / ", ficheiroFwk923().regFwk267().nsMovimento());
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isLess("PT") || 
            (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isLess(35)) || 
            (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(0) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(100))) {
            a34000EscreverFwk001() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a34100EscreverFwk051() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(101) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(200)) {
            a35000EscreverFwk002() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a35100EscreverFwk052() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(201) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(300)) {
            a36000EscreverFwk003() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a36100EscreverFwk053() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(301) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(400)) {
            a37000EscreverFwk004() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a37100EscreverFwk054() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(401) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(500)) {
            a38000EscreverFwk005() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a38100EscreverFwk055() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(501) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(600)) {
            a39000EscreverFwk006() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a39100EscreverFwk056() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(601) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(700)) {
            a40000EscreverFwk007() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a40100EscreverFwk057() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(701) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(800)) {
            a41000EscreverFwk008() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a41100EscreverFwk058() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(801) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(900)) {
            a42000EscreverFwk009() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a42100EscreverFwk059() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(901) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(1500)) {
            a43000EscreverFwk010() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a43100EscreverFwk060() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(1501) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(2100)) {
            a44000EscreverFwk011() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a44100EscreverFwk061() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(2101) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(2500)) {
            a45000EscreverFwk012() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a45100EscreverFwk062() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isEqual(35) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isGreaterOrEqual(2501) && 
            ficheiroFwk923().regFwk267().subconta().cOeEgcCont().isLessOrEqual(9999)) {
            a46000EscreverFwk013() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a46100EscreverFwk063() ;
                }
            }
        }
        if (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isGreater("PT") || 
            (ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont().isEqual("PT") && 
            ficheiroFwk923().regFwk267().subconta().cBancCont().isGreater(35))) {
            a47000EscreverFwk014() ;
            if (progOk.isTrue()) {
                if (swContaDiferente.isTrue()) {
                    a47100EscreverFwk064() ;
                }
            }
        }
        /**
         * IF BHOW8267-C-PAIS-ISOA-CONT = 'MO'
         * PERFORM A34000-ESCREVER-FWK001
         * IF PROG-OK
         * IF SW-CONTA-DIFERENTE
         * PERFORM A34100-ESCREVER-FWK051
         * END-IF
         * ELSE
         * IF BHOW8267-C-PAIS-ISOA-CONT = 'PT' AND
         * BHOW8267-C-BANC-CONT = 35
         * EVALUATE TRUE
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0000 AND
         * BHOW8267-C-OE-EGC-CONT <= 0100
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0101 AND
         * BHOW8267-C-OE-EGC-CONT <= 0200
         * PERFORM A35000-ESCREVER-FWK002
         * PERFORM A35100-ESCREVER-FWK052
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0201 AND
         * BHOW8267-C-OE-EGC-CONT <= 0300
         * PERFORM A36000-ESCREVER-FWK003
         * PERFORM A36100-ESCREVER-FWK053
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0301 AND
         * BHOW8267-C-OE-EGC-CONT <= 0400
         * PERFORM A37000-ESCREVER-FWK004
         * PERFORM A37100-ESCREVER-FWK054
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0401 AND
         * BHOW8267-C-OE-EGC-CONT <= 0500
         * PERFORM A38000-ESCREVER-FWK005
         * PERFORM A38100-ESCREVER-FWK055
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0501 AND
         * BHOW8267-C-OE-EGC-CONT <= 0600
         * PERFORM A39000-ESCREVER-FWK006
         * PERFORM A39100-ESCREVER-FWK056
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0601 AND
         * BHOW8267-C-OE-EGC-CONT <= 0700
         * PERFORM A40000-ESCREVER-FWK007
         * PERFORM A40100-ESCREVER-FWK057
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0701 AND
         * BHOW8267-C-OE-EGC-CONT <= 0800
         * PERFORM A41000-ESCREVER-FWK008
         * PERFORM A41100-ESCREVER-FWK058
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0801 AND
         * BHOW8267-C-OE-EGC-CONT <= 0900
         * PERFORM A42000-ESCREVER-FWK009
         * PERFORM A42100-ESCREVER-FWK059
         * WHEN BHOW8267-C-OE-EGC-CONT >= 0901 AND
         * BHOW8267-C-OE-EGC-CONT <= 1500
         * PERFORM A43000-ESCREVER-FWK010
         * PERFORM A43100-ESCREVER-FWK060
         * WHEN BHOW8267-C-OE-EGC-CONT >= 1501 AND
         * BHOW8267-C-OE-EGC-CONT <= 2100
         * PERFORM A44000-ESCREVER-FWK011
         * PERFORM A44100-ESCREVER-FWK061
         * WHEN BHOW8267-C-OE-EGC-CONT >= 2101 AND
         * BHOW8267-C-OE-EGC-CONT <= 2500
         * PERFORM A45000-ESCREVER-FWK012
         * PERFORM A45100-ESCREVER-FWK062
         * WHEN BHOW8267-C-OE-EGC-CONT >= 2501 AND
         * BHOW8267-C-OE-EGC-CONT <= 9999
         * PERFORM A46000-ESCREVER-FWK013
         * PERFORM A46100-ESCREVER-FWK063
         * END-EVALUATE
         * PERFORM A47000-ESCREVER-FWK014
         * PERFORM A47100-ESCREVER-FWK064
         */
        if (progOk.isTrue()) {
            if (!ficheiroFwk923().regFwk267().cTipoCanlAces().isEqual("BATC")) {
                if (ficheiroFwk923().regFwk267().iTrnzEfcdOnln().isEqual("2") || 
                    ficheiroFwk923().regFwk267().iExiAtzJourBbn().isEqual("S") || 
                    ficheiroFwk923().regFwk267().iPenalizacao().isEqual("N") || 
                    !ficheiroFwk923().regFwk267().iEstorno().isEmpty() || 
                    (!ficheiroFwk923().regFwk267().cPaisIsoaGerx().isEqual(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont()) && 
                    !ficheiroFwk923().regFwk267().cBancGcxGerx().isEqual(ficheiroFwk923().regFwk267().subconta().cBancCont()) && 
                    !ficheiroFwk923().regFwk267().cOeEgcGerx().isEqual(ficheiroFwk923().regFwk267().subconta().cOeEgcCont()))) {
                    log(TraceLevel.Debug, "ENTRA AQUI 1");
                    while (wsChaveFwk600().isLess(wsChaveFwk923()) && !ficheiroFwk600().getStatusOk()) {
                        a47210LerFwk600() ;
                    }
                    /**
                     * GH1863 - FIM
                     */
                    a47200EscreverFwk070() ;
                }
            }
        }
        if (progOk.isTrue()) {
            a32000LerFwk923() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34000EscreverFwk001() {
        log(TraceLevel.Debug, "A34000-ESCREVER-FWK001");
        fwk001().fwk001Reg327.initialize() ;
        fwk001().setRecord(ficheiroFwk923().getRecord()) ;
        fwk001().write(fwk001().fwk001Reg327) ;
        if (fwk001().getStatusOk()) {
            contRegEscrtFwk001.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK001 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
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
        fwk002().fwk002Reg327.initialize() ;
        fwk002().setRecord(ficheiroFwk923().getRecord()) ;
        fwk002().write(fwk002().fwk002Reg327) ;
        if (fwk002().getStatusOk()) {
            contRegEscrtFwk002.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK002 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk002().getStatus());
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
        fwk003().fwk003Reg327.initialize() ;
        fwk003().setRecord(ficheiroFwk923().getRecord()) ;
        fwk003().write(fwk003().fwk003Reg327) ;
        if (fwk003().getStatusOk()) {
            contRegEscrtFwk003.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK003 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
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
        fwk004().fwk004Reg327.initialize() ;
        fwk004().setRecord(ficheiroFwk923().getRecord()) ;
        fwk004().write(fwk004().fwk004Reg327) ;
        if (fwk004().getStatusOk()) {
            contRegEscrtFwk004.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK004 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk004().getStatus());
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
        fwk005().fwk005Reg327.initialize() ;
        fwk005().setRecord(ficheiroFwk923().getRecord()) ;
        fwk005().write(fwk005().fwk005Reg327) ;
        if (fwk005().getStatusOk()) {
            contRegEscrtFwk005.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK005 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk005().getStatus());
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
        fwk006().fwk006Reg327.initialize() ;
        fwk006().setRecord(ficheiroFwk923().getRecord()) ;
        fwk006().write(fwk006().fwk006Reg327) ;
        if (fwk006().getStatusOk()) {
            contRegEscrtFwk006.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK006 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk006().getStatus());
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
        fwk007().fwk007Reg327.initialize() ;
        fwk007().setRecord(ficheiroFwk923().getRecord()) ;
        fwk007().write(fwk007().fwk007Reg327) ;
        if (fwk007().getStatusOk()) {
            contRegEscrtFwk007.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK007 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk007().getStatus());
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
        fwk008().fwk008Reg327.initialize() ;
        fwk008().setRecord(ficheiroFwk923().getRecord()) ;
        fwk008().write(fwk008().fwk008Reg327) ;
        if (fwk008().getStatusOk()) {
            contRegEscrtFwk008.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK008 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk008().getStatus());
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
        fwk009().fwk009Reg327.initialize() ;
        fwk009().setRecord(ficheiroFwk923().getRecord()) ;
        fwk009().write(fwk009().fwk009Reg327) ;
        if (fwk009().getStatusOk()) {
            contRegEscrtFwk009.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK009 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk009().getStatus());
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
        fwk010().fwk010Reg327.initialize() ;
        fwk010().setRecord(ficheiroFwk923().getRecord()) ;
        fwk010().write(fwk010().fwk010Reg327) ;
        if (fwk010().getStatusOk()) {
            contRegEscrtFwk010.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK010 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk010().getStatus());
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
        fwk011().fwk011Reg327.initialize() ;
        fwk011().setRecord(ficheiroFwk923().getRecord()) ;
        fwk011().write(fwk011().fwk011Reg327) ;
        if (fwk011().getStatusOk()) {
            contRegEscrtFwk011.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK011 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk011().getStatus());
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
        fwk012().fwk012Reg327.initialize() ;
        fwk012().setRecord(ficheiroFwk923().getRecord()) ;
        fwk012().write(fwk012().fwk012Reg327) ;
        if (fwk012().getStatusOk()) {
            contRegEscrtFwk012.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK012 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk012().getStatus());
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
        fwk013().fwk013Reg327.initialize() ;
        fwk013().setRecord(ficheiroFwk923().getRecord()) ;
        fwk013().write(fwk013().fwk013Reg327) ;
        if (fwk013().getStatusOk()) {
            contRegEscrtFwk013.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK013 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk013().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a47000EscreverFwk014() {
        log(TraceLevel.Debug, "A47000-ESCREVER-FWK014");
        fwk014().fwk014Reg327.initialize() ;
        fwk014().setRecord(ficheiroFwk923().getRecord()) ;
        fwk014().write(fwk014().fwk014Reg327) ;
        if (fwk014().getStatusOk()) {
            contRegEscrtFwk014.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK014 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk014().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a34100EscreverFwk051() {
        log(TraceLevel.Debug, "A34100-ESCREVER-FWK051");
        fwk051().fwk051Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk051().setRecord(bghw0015().rwk01501()) ;
        fwk051().write(fwk051().fwk051Reg32) ;
        if (fwk051().getStatusOk()) {
            contRegEscrtFwk051.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK051 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a35100EscreverFwk052() {
        log(TraceLevel.Debug, "A35100-ESCREVER-FWK052");
        fwk052().fwk052Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk052().setRecord(bghw0015().rwk01501()) ;
        fwk052().write(fwk052().fwk052Reg32) ;
        if (fwk052().getStatusOk()) {
            contRegEscrtFwk052.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK052 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk052().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a36100EscreverFwk053() {
        log(TraceLevel.Debug, "A36100-ESCREVER-FWK053");
        fwk053().fwk053Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk053().setRecord(bghw0015().rwk01501()) ;
        fwk053().write(fwk053().fwk053Reg32) ;
        if (fwk053().getStatusOk()) {
            contRegEscrtFwk053.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK053 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk053().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a37100EscreverFwk054() {
        log(TraceLevel.Debug, "A37100-ESCREVER-FWK054");
        fwk054().fwk054Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk054().setRecord(bghw0015().rwk01501()) ;
        fwk054().write(fwk054().fwk054Reg32) ;
        if (fwk054().getStatusOk()) {
            contRegEscrtFwk054.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK054 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk054().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a38100EscreverFwk055() {
        log(TraceLevel.Debug, "A38100-ESCREVER-FWK055");
        fwk055().fwk055Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk055().setRecord(bghw0015().rwk01501()) ;
        fwk055().write(fwk055().fwk055Reg32) ;
        if (fwk055().getStatusOk()) {
            contRegEscrtFwk055.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK055 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk055().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a39100EscreverFwk056() {
        log(TraceLevel.Debug, "A39100-ESCREVER-FWK056");
        fwk056().fwk056Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk056().setRecord(bghw0015().rwk01501()) ;
        fwk056().write(fwk056().fwk056Reg32) ;
        if (fwk056().getStatusOk()) {
            contRegEscrtFwk056.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK056 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk056().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a40100EscreverFwk057() {
        log(TraceLevel.Debug, "A39100-ESCREVER-FWK057");
        fwk057().fwk057Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk057().setRecord(bghw0015().rwk01501()) ;
        fwk057().write(fwk057().fwk057Reg32) ;
        if (fwk057().getStatusOk()) {
            contRegEscrtFwk057.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK057 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk057().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a41100EscreverFwk058() {
        log(TraceLevel.Debug, "A40100-ESCREVER-FWK058");
        fwk058().fwk058Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk058().setRecord(bghw0015().rwk01501()) ;
        fwk058().write(fwk058().fwk058Reg32) ;
        if (fwk058().getStatusOk()) {
            contRegEscrtFwk058.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK058 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk058().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a42100EscreverFwk059() {
        log(TraceLevel.Debug, "A41100-ESCREVER-FWK059");
        fwk059().fwk059Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk059().setRecord(bghw0015().rwk01501()) ;
        fwk059().write(fwk059().fwk059Reg32) ;
        if (fwk059().getStatusOk()) {
            contRegEscrtFwk059.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK059 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk059().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a43100EscreverFwk060() {
        log(TraceLevel.Debug, "A42100-ESCREVER-FWK060");
        fwk060().fwk060Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk060().setRecord(bghw0015().rwk01501()) ;
        fwk060().write(fwk060().fwk060Reg32) ;
        if (fwk060().getStatusOk()) {
            contRegEscrtFwk060.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK060 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk060().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a44100EscreverFwk061() {
        log(TraceLevel.Debug, "A43100-ESCREVER-FWK061");
        fwk061().fwk061Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk061().setRecord(bghw0015().rwk01501()) ;
        fwk061().write(fwk061().fwk061Reg32) ;
        if (fwk061().getStatusOk()) {
            contRegEscrtFwk061.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK061 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk061().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a45100EscreverFwk062() {
        log(TraceLevel.Debug, "A44100-ESCREVER-FWK062");
        fwk062().fwk062Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk062().setRecord(bghw0015().rwk01501()) ;
        fwk062().write(fwk062().fwk062Reg32) ;
        if (fwk062().getStatusOk()) {
            contRegEscrtFwk062.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK062 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk062().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a46100EscreverFwk063() {
        log(TraceLevel.Debug, "A45100-ESCREVER-FWK063");
        fwk063().fwk063Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk063().setRecord(bghw0015().rwk01501()) ;
        fwk063().write(fwk063().fwk063Reg32) ;
        if (fwk063().getStatusOk()) {
            contRegEscrtFwk063.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK063 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk063().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a47100EscreverFwk064() {
        log(TraceLevel.Debug, "A46100-ESCREVER-FWK064");
        fwk064().fwk064Reg32.initialize() ;
        bghw0015().rwk01501().initialize() ;
        bghw0015().rwk01501().fwk015CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        bghw0015().rwk01501().fwk015CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        bghw0015().rwk01501().fwk015COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        bghw0015().rwk01501().fwk015NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        bghw0015().rwk01501().fwk015VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        bghw0015().rwk01501().fwk015CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        bghw0015().rwk01501().fwk015CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        bghw0015().rwk01501().fwk015NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        bghw0015().rwk01501().fwk015ZMovimento().set(ficheiroFwk923().regFwk267().zMovimento());
        fwk064().setRecord(bghw0015().rwk01501()) ;
        fwk064().write(fwk064().fwk064Reg32) ;
        if (fwk064().getStatusOk()) {
            contRegEscrtFwk064.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK064 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk064().getStatus());
            tabelaImpressaoMask().zimp().setIndex(9) ;
            a12000EscreverFgh300() ;
        }
    }
    
    /**
     * 
     * GH1863 - INI
     * 
     */
    protected void a47210LerFwk600() {
        log(TraceLevel.Debug, "A47210-LER-FWK600");
        ficheiroFwk600().read() ;
        if (ficheiroFwk600().getStatusOk()) {
            contRegLidosFwk600.add(1);
            wsChaveFwk600().wsCPaisIsoaFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600CPaisIsoaCont());
            wsChaveFwk600().wsCBancContFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600CBancCont());
            wsChaveFwk600().wsCOeEgcContFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600COeEgcCont());
            wsChaveFwk600().wsNsRdclContFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600NsRdclCont());
            wsChaveFwk600().wsVChkdContFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600VChkdCont());
            wsChaveFwk600().wsCTipoContFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600CTipoCont());
            wsChaveFwk600().wsCMoedIsoFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600CMoedIsoScta());
            wsChaveFwk600().wsNsDepositoFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600Conta().fwk600NsDeposito());
            wsChaveFwk600().wsNsMovimentoFwk600().set(ficheiroFwk600().regFwk600Pghc001a().fwk600NsMovimento());
        }
        if (!ficheiroFwk600().getStatusOk() && !ficheiroFwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK600 - READ - ");
            tabelaImpressao().linha09().impStatus().set(ficheiroFwk600().getStatus());
        }
    }
    
    /**
     * 
     * GH1863 - FIM
     * 
     */
    protected void a47200EscreverFwk070() {
        log(TraceLevel.Debug, "A47200-ESCREVER-FWK070");
        fwk070().fwk070RegPghc001a().initialize() ;
        fwk070().fwk070RegPghc001a().fwk070CPaisIsoaCont().set(ficheiroFwk923().regFwk267().subconta().cPaisIsoaCont());
        fwk070().fwk070RegPghc001a().fwk070CBancCont().set(ficheiroFwk923().regFwk267().subconta().cBancCont());
        fwk070().fwk070RegPghc001a().fwk070COeEgcCont().set(ficheiroFwk923().regFwk267().subconta().cOeEgcCont());
        fwk070().fwk070RegPghc001a().fwk070NsRdclCont().set(ficheiroFwk923().regFwk267().subconta().nsRdclCont());
        fwk070().fwk070RegPghc001a().fwk070VChkdCont().set(ficheiroFwk923().regFwk267().subconta().vChkdCont());
        fwk070().fwk070RegPghc001a().fwk070CTipoCont().set(ficheiroFwk923().regFwk267().subconta().cTipoCont());
        fwk070().fwk070RegPghc001a().fwk070CMoedIsoScta().set(ficheiroFwk923().regFwk267().subconta().cMoedIsoScta());
        fwk070().fwk070RegPghc001a().fwk070NsDeposito().set(ficheiroFwk923().regFwk267().subconta().nsDeposito());
        fwk070().fwk070RegPghc001a().fwk070NsMovimento().set(ficheiroFwk923().regFwk267().nsMovimento());
        wTimestamp().wDataTimestamp().set(ficheiroFwk923().regFwk267().zMovimento());
        wTimestamp().wTimerTimestamp().wHh().set(0);
        wTimestamp().wTimerTimestamp().wMm().set(0);
        wTimestamp().wTimerTimestamp().wSs().set(0);
        wTimestamp().wTimerTimestamp().wResto().set(0);
        fwk070().fwk070RegPghc001a().fwk070TsMovimento().set(wTimestamp());
        fwk070().fwk070RegPghc001a().fwk070ITrnzEfcdOnln().set(ficheiroFwk923().regFwk267().iTrnzEfcdOnln());
        fwk070().fwk070RegPghc001a().fwk070IExiAtzJourBbn().set(ficheiroFwk923().regFwk267().iExiAtzJourBbn());
        fwk070().fwk070RegPghc001a().fwk070IPenalizacao().set(ficheiroFwk923().regFwk267().iPenalizacao());
        fwk070().fwk070RegPghc001a().fwk070CPaisIsoaGerx().set(ficheiroFwk923().regFwk267().cPaisIsoaGerx());
        fwk070().fwk070RegPghc001a().fwk070CBancGcxGerx().set(ficheiroFwk923().regFwk267().cBancGcxGerx());
        fwk070().fwk070RegPghc001a().fwk070COeEgcGerx().set(ficheiroFwk923().regFwk267().cOeEgcGerx());
        fwk070().fwk070RegPghc001a().fwk070NAtrzCamb().set(0);
        fwk070().fwk070RegPghc001a().fwk070XRefMovOrig().set(ficheiroFwk923().regFwk267().xRefMov());
        fwk070().fwk070RegPghc001a().fwk070TsActzUlt().set(ficheiroFwk923().regFwk267().tsActzUlt());
        fwk070().fwk070RegPghc001a().fwk070CUsidActzUlt().set(ficheiroFwk923().regFwk267().cUsidActzUlt());
        /**
         * GH1863 - INI
         */
        fwk070().fwk070RegPghc001a().fwk070IEstorno().set(ficheiroFwk923().regFwk267().iEstorno());
        fwk070().fwk070RegPghc001a().fwk070NsMovEtnd().set(ficheiroFwk923().regFwk267().nsMovEtnd());
        if (wsChaveFwk600().isEqual(wsChaveFwk923())) {
            fwk070().fwk070RegPghc001a().fwk070MMovCtrvEuro().set(ficheiroFwk600().regFwk600Pghc001a().fwk600MMovimento());
            fwk070().fwk070RegPghc001a().fwk070TCambEuro().set(ficheiroFwk600().regFwk600Pghc001a().fwk600TCambio());
        } else {
            fwk070().fwk070RegPghc001a().fwk070MMovCtrvEuro().set(0);
            fwk070().fwk070RegPghc001a().fwk070TCambEuro().set(0);
        }
        fwk070().write(fwk070().fwk070RegPghc001a()) ;
        if (fwk070().getStatusOk()) {
            contRegEscrtFwk070.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK070 - WRITE ");
            tabelaImpressao().linha09().impStatus().set(fwk070().getStatus());
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
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK001 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
        fwk002().close() ;
        if (!fwk002().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK002 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk002().getStatus());
        }
        fwk003().close() ;
        if (!fwk003().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK003 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk003().getStatus());
        }
        fwk004().close() ;
        if (!fwk004().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK004 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
        fwk005().close() ;
        if (!fwk005().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK005 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk005().getStatus());
        }
        fwk006().close() ;
        if (!fwk006().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK006 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk001().getStatus());
        }
        fwk007().close() ;
        if (!fwk007().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK007 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk007().getStatus());
        }
        fwk008().close() ;
        if (!fwk008().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK008 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk008().getStatus());
        }
        fwk009().close() ;
        if (!fwk009().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK009 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk009().getStatus());
        }
        fwk010().close() ;
        if (!fwk010().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK010 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk010().getStatus());
        }
        fwk012().close() ;
        if (!fwk012().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK012 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk012().getStatus());
        }
        fwk013().close() ;
        if (!fwk013().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK013 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk013().getStatus());
        }
        fwk014().close() ;
        if (!fwk014().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK014 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk014().getStatus());
        }
        fwk051().close() ;
        if (!fwk051().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK051 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk051().getStatus());
        }
        fwk052().close() ;
        if (!fwk052().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK052 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk052().getStatus());
        }
        fwk053().close() ;
        if (!fwk053().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK053 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk053().getStatus());
        }
        fwk054().close() ;
        if (!fwk054().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK054 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk054().getStatus());
        }
        fwk055().close() ;
        if (!fwk055().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK055 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk055().getStatus());
        }
        fwk056().close() ;
        if (!fwk056().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK056 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk056().getStatus());
        }
        fwk057().close() ;
        if (!fwk057().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK057 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk057().getStatus());
        }
        fwk058().close() ;
        if (!fwk051().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK058 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk058().getStatus());
        }
        fwk059().close() ;
        if (!fwk059().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK059 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk059().getStatus());
        }
        fwk060().close() ;
        if (!fwk060().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK060 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk060().getStatus());
        }
        fwk061().close() ;
        if (!fwk061().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK061 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk061().getStatus());
        }
        fwk062().close() ;
        if (!fwk062().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK062 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk062().getStatus());
        }
        fwk063().close() ;
        if (!fwk063().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK063 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk063().getStatus());
        }
        fwk064().close() ;
        if (!fwk064().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK064 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk064().getStatus());
        }
        fwk070().close() ;
        if (!fwk070().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK070 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(fwk070().getStatus());
        }
        ficheiroFwk923().close() ;
        if (!ficheiroFwk923().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK923 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(ficheiroFwk923().getStatus());
        }
        ficheiroFwk600().close() ;
        if (!ficheiroFwk600().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC001A - FWK600 - CLOSE - ");
            tabelaImpressao().linha09().impStatus().set(ficheiroFwk600().getStatus());
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
            tabelaImpressao().linha05().impRegLidosFwk923().set(contRegLidosFwk923);
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
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk014);
            tabelaImpressao().linha06().impFichEsc().set("FWK014");
            a12000EscreverFgh300() ;
            tabelaImpressaoMask().zimp().setIndex(6) ;
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
            tabelaImpressaoMask().zimp().setIndex(6) ;
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFwk070);
            tabelaImpressao().linha06().impFichEsc().set("FWK070");
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha08().impMens1().set("PGHC001A - FIM ANORMAL ");
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
    public interface ChaveBhow8267 extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaContBhow8267() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancContBhow8267() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcContBhow8267() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclContBhow8267() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdContBhow8267() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoContBhow8267() ;
        
        @Data(size=3)
        IString cMoedIsoSctaBhow8267() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDepositoBhow8267() ;
        
    }
    public interface ChaveAnt extends IDataStruct {
        
        @Data(size=3)
        IString cPaisIsoaContAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancContAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcContAnt() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclContAnt() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdContAnt() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoContAnt() ;
        
        @Data(size=3)
        IString cMoedIsoSctaAnt() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDepositoAnt() ;
        
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
            
            @Data(size=8, value="PGHC001A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHC001A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=35, value="NUMERO DE REGISTOS LIDOS EM FWK923")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString filler003() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", rpadding=47, rpaddingValue="")
            IFormattedString impRegLidosFwk923() ;
            
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
    
    /**
     * 
     * GH1863 - INI
     * 
     * @version 2.0
     * 
     */
    public interface WsChaveFwk923 extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaFwk923() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancContFwk923() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcContFwk923() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclContFwk923() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdContFwk923() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoContFwk923() ;
        
        @Data(size=3)
        IString wsCMoedIsoFwk923() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDepositoFwk923() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovimentoFwk923() ;
        
    }
    public interface WsChaveFwk600 extends IDataStruct {
        
        @Data(size=3)
        IString wsCPaisIsoaFwk600() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCBancContFwk600() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsCOeEgcContFwk600() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsNsRdclContFwk600() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsVChkdContFwk600() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsCTipoContFwk600() ;
        
        @Data(size=3)
        IString wsCMoedIsoFwk600() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsNsDepositoFwk600() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong wsNsMovimentoFwk600() ;
        
    }
    
}
