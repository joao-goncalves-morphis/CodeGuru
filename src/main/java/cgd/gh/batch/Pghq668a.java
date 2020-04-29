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
import cgd.ht.structures.link.Bhtl034a ;
import cgd.ht.structures.work.Bhtw7000 ;
import cgd.gh.structures.work.Bghw0150 ;
import cgd.ht.routines.Mhtq034a ;
import cgd.zy.batch.Pzya710a ;


/**
 * 
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVOS    :-RECEBE FICHEIRO COM UNLOAD DA
 * TGH00010_CONTIPHST.
 * -FAZ INSERT NA MESMA TABELA AOS MOVIMENTOS
 * QUE ESTAVAM NA TABELA DE HISTÓRICO E AGORA
 * VÃO PARA TAPE, COM A INDICAÇÃO DO NOME DO
 * RECURSO NA TAPE.
 * ALTERACOES    :-N/A
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq668a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk910
     */
    @Handler(name="FWK910", record="regFwk910Pghq668a")
    @Data
    protected abstract Fwk910 fwk910() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq034a
     */
    @Data
    protected abstract Mhtq034a hrMhtq034a() ;
    
    /**
     * @return instancia da classe Pzya710a
     */
    @Data
    protected abstract Pzya710a hbPzya710a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtl034a
     */
    @Data
    protected abstract Bhtl034a bhtl034a() ;
    
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
     * @return instancia da classe local NomeRecursoTape
     */
    @Data
    protected abstract NomeRecursoTape nomeRecursoTape() ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * @return instancia da classe local WsRegFwk910
     */
    @Data
    protected abstract WsRegFwk910 wsRegFwk910() ;
    
    protected static final int CON_Q_COMMITS = 5000 ;
    
    protected static final String CON_DESCRICAO = "BALDEAMENTO - INSERT TGH00010_CONTIPHST" ;
    
    protected static final String CON_VGH00201 = "VGH00201" ;
    
    /**
     * CONTADORES
     */
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegLidosFwk910 ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contRegRearranque ;
    
    @Data(size=15, signed=true, value="0", compression=COMP3)
    protected ILong contContadorCommit ;
    
    @Data(size=15, value="0")
    protected ILong countInserts ;
    
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
     * ACESSO A ROTINA DE RECUPERACAO PARA O BATCH
     * MHTQ034A
     * 
     */
    protected void bhtp0034AcessoRecup() {
    }
    
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
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000ObtemJobname() {
        bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
    }
    
    /**
     * 
     * 
     */
    protected void bhtp7000ObtemJobid() {
        bhtw7000().parmarea().area8().set(bhtw7000().sysParm());
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
        wsVariaveis().initialize() ;
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
        wsVariaveis().wsZaBaldHoje().set(wTimestamp().wDataTimestamp().wAnoAa());
        wsVariaveis().wsZaBald1ano().set(subtract(wsVariaveis().wsZaBaldHoje(), 1));
        wsVariaveis().wsZaBald2anos().set(subtract(wsVariaveis().wsZaBaldHoje(), 2));
        wsVariaveis().wsZaBaldActivo().set(subtract(wsVariaveis().wsZaBaldHoje(), 3));
        wsVariaveis().wsZaBaldNormal().set(subtract(wsVariaveis().wsZaBaldHoje(), 9));
        log(TraceLevel.Trace, "WS-ZA-BALD-HOJE:   ", wsVariaveis().wsZaBaldHoje());
        log(TraceLevel.Trace, "WS-ZA-BALD-1ANO:   ", wsVariaveis().wsZaBald1ano());
        log(TraceLevel.Trace, "WS-ZA-BALD-2ANOS:  ", wsVariaveis().wsZaBald2anos());
        log(TraceLevel.Trace, "WS-ZA-BALD-ACTIVO: ", wsVariaveis().wsZaBaldActivo());
        log(TraceLevel.Trace, "WS-ZA-BALD-NORMAL: ", wsVariaveis().wsZaBaldNormal());
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
        wTimestamp().wTimerTimestamp().wDd().set(0);
        if (progOk.isTrue()) {
            a12000ObtemJobname() ;
        }
        bghw0300().wsNmPrograma().set(bhtw7000().parmarea().area8());
        if (progOk.isTrue()) {
            a10000AbrirFgh300() ;
        }
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AnalisaRearranque() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk910() ;
        }
        if (progOk.isTrue()) {
            while (contRegLidosFwk910.isLessOrEqual(contRegRearranque) && !fwk910().getStatusOk() && progOk.isTrue()) {
                a15000LerFwk910() ;
            }
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
    protected void a12000ObtemJobname() {
        log(TraceLevel.Debug, "A12000-OBTEM-JOBNAME");
        bhtw7000().jobname().setTrue() ;
        bhtp7000DadosSistema() ;
        if (!bhtw7000().indicadoresErro().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ668A - A12000-OBTEM-JOBNAME");
            wSqlcode.set("0");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            wsVariaveis().wsCRtnoEvenSwal().set(bhtw7000().indicadoresErro().cRtnoEvenSwal());
            tabelaImpressao().linha10().msgLivre().set(concat(" ", bhtw7000().indicadoresErro().cTipoErroBbn(), " ", bhtw7000().indicadoresErro().aAplErr(), " ", wsVariaveis().wsCRtnoEvenSwal(), " "));
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
    protected void a13000AnalisaRearranque() {
        log(TraceLevel.Debug, "A13000-ANALISA-REARRANQUE");
        bhtl034a().commarea().dadosOutput().initialize() ;
        bhtl034a().commarea().dadosInput().consulta().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(bghw0300().wsNmPrograma());
        bhtl034a().commarea().dadosInput().zProcessamento().set(wTimestamp().wDataTimestamp());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        log(TraceLevel.Debug, "BHTL034A-C-TIPO-ERRO-BBN: ", bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        log(TraceLevel.Debug, "BHTL034A-C-RTNO-EVEN-SWAL:", bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
        log(TraceLevel.Debug, "BHTL034A-DADOS-INP-OUT:   ", bhtl034a().commarea().dadosInpOut());
        log(TraceLevel.Debug, "BHTL034A-C-SQLCODE:       ", bhtl034a().commarea().dadosOutput().cSqlcode());
        log(TraceLevel.Debug, "BHTL034A-CHV-ACES:        ", bhtl034a().commarea().dadosOutput().chvAces());
        if (bhtl034a().commarea().dadosOutput().errosFuncao().isTrue()) {
            log(TraceLevel.Error, "***** SEM REARRANQUE *****");
            contRegLidosFwk910.set(0);
        } else if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            log(TraceLevel.Error, "***** MODO DE REARRANQUE *****");
            contRegRearranque.set(bhtl034a().commarea().dadosInpOut().xDescChavTab().get(1, 15));
            log(TraceLevel.Error, "BHTL034A-X-DESC-CHAV-TAB:", bhtl034a().commarea().dadosInpOut().xDescChavTab());
            log(TraceLevel.Error, "CONT-REG-REARRANQUE: ", contRegRearranque);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ668A - A13000-ANALISA-REARRANQUE");
            wSqlcode.set(bhtl034a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            wsVariaveis().wsCRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
            tabelaImpressao().linha10().msgLivre().set(concat(" ", bhtl034a().commarea().dadosOutput().cTipoErroBbn(), " ", bhtl034a().commarea().dadosOutput().aAplErr(), " ", wsVariaveis().wsCRtnoEvenSwal(), " "));
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk910() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK910");
        fwk910().open() ;
        if (!fwk910().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ668A - FWK910 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk910().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk910() {
        log(TraceLevel.Debug, "A15000-LER-FWK910");
        fwk910().read() ;
        if (fwk910().getStatusOk()) {
            contRegLidosFwk910.add(1);
            log(TraceLevel.Debug, "CONT-REG-LIDOS-FWK910: ", contRegLidosFwk910);
            log(TraceLevel.Debug, "CONT-REG-REARRANQUE:   ", contRegRearranque);
        }
        if (!fwk910().getStatusOk() && !fwk910().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ668A - FWK910 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk910().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        log(TraceLevel.Debug, "WS-NM-RECURSO: ", wsVariaveis().wsNmRecurso());
        log(TraceLevel.Debug, "SQLCODE: ", getPersistenceCode());
        log(TraceLevel.Debug, "-----------------------------------------");
        log(TraceLevel.Debug, "FWK910-NM-RECURSO: ", fwk910().regFwk910Pghq668a().fwk910NmRecurso());
        log(TraceLevel.Debug, "FWK910-ZA-INICIO:  ", fwk910().regFwk910Pghq668a().fwk910ZaInicio());
        log(TraceLevel.Debug, "FWK910-ZA-FIM:     ", fwk910().regFwk910Pghq668a().fwk910ZaFim());
        log(TraceLevel.Debug, "WS-NM-RECURSO:     ", wsVariaveis().wsNmRecurso());
        log(TraceLevel.Debug, "WS-ZA-BALD-NORMAL: ", wsVariaveis().wsZaBaldNormal());
        log(TraceLevel.Debug, "-----------------------------------------");
        if (fwk910().regFwk910Pghq668a().fwk910NmRecurso().isEqual(CON_VGH00201) && 
            fwk910().regFwk910Pghq668a().fwk910ZaInicio().isEqual(wsVariaveis().wsZaBaldActivo()) && 
            !fwk910().regFwk910Pghq668a().fwk910ZaFim().isEqual(wsVariaveis().wsZaBaldActivo())) {
            a32000TrataInsert() ;
        }
        log(TraceLevel.Debug, "CONT-CONTADOR-COMMIT: ", contContadorCommit);
        log(TraceLevel.Debug, "CON-Q-COMMITS:        ", CON_Q_COMMITS);
        if (progOk.isTrue()) {
            if (contContadorCommit.isGreaterOrEqual(CON_Q_COMMITS)) {
                a32000ExecutaCommit() ;
            }
        }
        if (progOk.isTrue()) {
            a15000LerFwk910() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000TrataInsert() {
        log(TraceLevel.Debug, "A32000-TRATA-INSERT");
        log(TraceLevel.Debug, "FWK910-C-PAIS-ISOA-CONT:", fwk910().regFwk910Pghq668a().fwk910CPaisIsoaCont());
        log(TraceLevel.Debug, "FWK910-C-BANC-CONT:     ", fwk910().regFwk910Pghq668a().fwk910CBancCont());
        log(TraceLevel.Debug, "FWK910-C-OE-EGC-CONT:   ", fwk910().regFwk910Pghq668a().fwk910COeEgcCont());
        log(TraceLevel.Debug, "FWK910-NS-RDCL-CONT:    ", fwk910().regFwk910Pghq668a().fwk910NsRdclCont());
        log(TraceLevel.Debug, "FWK910-V-CHKD-CONT:     ", fwk910().regFwk910Pghq668a().fwk910VChkdCont());
        log(TraceLevel.Debug, "FWK910-C-TIPO-CONT:     ", fwk910().regFwk910Pghq668a().fwk910CTipoCont());
        log(TraceLevel.Debug, "FWK910-C-MOED-ISO-SCTA: ", fwk910().regFwk910Pghq668a().fwk910CMoedIsoScta());
        log(TraceLevel.Debug, "FWK910-NS-DEPOSITO:     ", fwk910().regFwk910Pghq668a().fwk910NsDeposito());
        log(TraceLevel.Debug, "FWK910-NM-RECURSO:      ", fwk910().regFwk910Pghq668a().fwk910NmRecurso());
        log(TraceLevel.Debug, "FWK910-ZA-INICIO:       ", fwk910().regFwk910Pghq668a().fwk910ZaInicio());
        log(TraceLevel.Debug, "FWK910-ZA-FIM:          ", fwk910().regFwk910Pghq668a().fwk910ZaFim());
        wsRegFwk910().initialize() ;
        /**
         * MOVE REG-FWK910              TO VGH01001-CONTIPHST
         */
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(fwk910().regFwk910Pghq668a().fwk910CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(fwk910().regFwk910Pghq668a().fwk910CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(fwk910().regFwk910Pghq668a().fwk910COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(fwk910().regFwk910Pghq668a().fwk910NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(fwk910().regFwk910Pghq668a().fwk910VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(fwk910().regFwk910Pghq668a().fwk910CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(fwk910().regFwk910Pghq668a().fwk910CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(fwk910().regFwk910Pghq668a().fwk910NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set(wsVariaveis().wsNmRecurso());
        hv01001Contiphst().contiphst().cTipoInfHist().set(fwk910().regFwk910Pghq668a().fwk910CTipoInfHist());
        hv01001Contiphst().contiphst().zaInicio().set(wsVariaveis().wsZaBaldActivo());
        hv01001Contiphst().contiphst().zaFim().set(wsVariaveis().wsZaBaldActivo());
        hv01001Contiphst().contiphst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().insertPghq668a645() ;
        wSqlcode.set(hv01001Contiphst().getPersistenceCode());
        log(TraceLevel.Debug, "SQLCODE: ", hv01001Contiphst().getPersistenceCode());
        if (hv01001Contiphst().getPersistenceCode() == PersistenceCode.NORMAL) {
            contContadorCommit.add(1);
            countInserts.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ668A - INSERT 02 - ");
            wSqlcode.set(hv01001Contiphst().getPersistenceCode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            log(TraceLevel.Trace, "##############ERRO##############");
            log(TraceLevel.Trace, "C-PAIS-ISOA-CONT:", hv01001Contiphst().contiphst().cPaisIsoaCont());
            log(TraceLevel.Trace, "C-BANC-CONT.....:", hv01001Contiphst().contiphst().cBancCont());
            log(TraceLevel.Trace, "C-OE-EGC-CONT...:", hv01001Contiphst().contiphst().cOeEgcCont());
            log(TraceLevel.Trace, "NS-RDCL-CONT....:", hv01001Contiphst().contiphst().nsRdclCont());
            log(TraceLevel.Trace, "V-CHKD-CONT.....:", hv01001Contiphst().contiphst().vChkdCont());
            log(TraceLevel.Trace, "C-TIPO-CONT.....:", hv01001Contiphst().contiphst().cTipoCont());
            log(TraceLevel.Trace, "C-MOED-ISO-SCTA.:", hv01001Contiphst().contiphst().cMoedIsoScta());
            log(TraceLevel.Trace, "NS-DEPOSITO.....:", hv01001Contiphst().contiphst().nsDeposito());
            log(TraceLevel.Trace, "NM-RECURSO......:", hv01001Contiphst().contiphst().nmRecurso());
            log(TraceLevel.Trace, "C-TIPO-INF-HIST.:", hv01001Contiphst().contiphst().cTipoInfHist());
            log(TraceLevel.Trace, "ZA-INICIO.......:", hv01001Contiphst().contiphst().zaInicio());
            log(TraceLevel.Trace, "ZA-FIM..........:", hv01001Contiphst().contiphst().zaFim());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32000ExecutaCommit() {
        log(TraceLevel.Debug, "A32000-EXECUTA-COMMIT");
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().modificacao().setTrue() ;
        bhtl034a().commarea().dadosInput().zProcessamento().set(wTimestamp().wDataTimestamp());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(contRegLidosFwk910);
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtl034a().commarea().dadosInput().nmPrograma().set(bghw0300().wsNmPrograma());
        bhtp0034AcessoRecup() ;
        if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            contContadorCommit.set(0);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ668A - A32000-EXECUTA-COMMIT ");
            wSqlcode.set(bhtl034a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            wsVariaveis().wsCRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
            tabelaImpressao().linha10().msgLivre().set(concat(" ", bhtl034a().commarea().dadosOutput().cTipoErroBbn(), " ", bhtl034a().commarea().dadosOutput().aAplErr(), " ", wsVariaveis().wsCRtnoEvenSwal(), " "));
        }
    }
    
    /**
     * 
     * 
     */
    protected void a33000FechaRecuperacao() {
        log(TraceLevel.Debug, "A33000-FECHA-RECUPERACAO");
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().fimProcessoOk().setTrue() ;
        bhtl034a().commarea().dadosInput().zProcessamento().set(wTimestamp().wDataTimestamp());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(contRegLidosFwk910);
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtl034a().commarea().dadosInput().nmPrograma().set(bghw0300().wsNmPrograma());
        bhtp0034AcessoRecup() ;
        if (!bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ668A - A33000-FECHA-RECUPERACAO");
            wSqlcode.set(bhtl034a().commarea().dadosOutput().cSqlcode());
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
            wsVariaveis().wsCRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
            tabelaImpressao().linha10().msgLivre().set(concat(" ", bhtl034a().commarea().dadosOutput().cTipoErroBbn(), " ", bhtl034a().commarea().dadosOutput().aAplErr(), " ", wsVariaveis().wsCRtnoEvenSwal(), " "));
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
            tabelaImpressao().linha05().impFichRead().set("FWK910");
            tabelaImpressao().linha05().impRegLidosFwk910().set(contRegLidosFwk910);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            a33000FechaRecuperacao() ;
        } else {
            rollback() ;
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ668A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(8); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        log(TraceLevel.Trace, "#############TRATAMENTO##############");
        log(TraceLevel.Trace, "COUNT-INSERTS....:", countInserts);
        fgh300().close() ;
        fwk910().close() ;
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
            while (!fwk910().getStatusOk() && progOk.isTrue()) {
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
    public interface NomeRecursoTape extends IDataStruct {
        
        @Data(size=4, value="GHSA")
        IString wsGhsaTape() ;
        
        @Data(size=4, value="0")
        IInt wsAnoTape() ;
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=4, value="0")
        IInt wsZaBaldHoje() ;
        
        @Data(size=4, value="0")
        IInt wsZaBald1ano() ;
        
        @Data(size=4, value="0")
        IInt wsZaBald2anos() ;
        
        @Data(size=4, value="0")
        IInt wsZaBaldActivo() ;
        
        @Data(size=4, value="0")
        IInt wsZaBaldNormal() ;
        
        @Data(size=8, value=" ")
        IString wsNmRecurso() ;
        
        @Data(size=3, value="0")
        IInt wsCRtnoEvenSwal() ;
        
    }
    public interface WsRegFwk910 extends IDataStruct {
        
        @Data(size=3)
        IString wsFwk910CPaisIsoaCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsFwk910CBancCont() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsFwk910COeEgcCont() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt wsFwk910NsRdclCont() ;
        
        @Data(size=1, signed=true, compression=COMP3)
        IInt wsFwk910VChkdCont() ;
        
        @Data(size=3, signed=true, compression=COMP3)
        IInt wsFwk910CTipoCont() ;
        
        @Data(size=3)
        IString wsFwk910CMoedIsoScta() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsFwk910NsDeposito() ;
        
        @Data(size=8)
        IString wsFwk910NmRecurso() ;
        
        @Data(size=1)
        IString wsFwk910CTipoInfHist() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsFwk910ZaInicio() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt wsFwk910ZaFim() ;
        
        @Data(size=26)
        IString wsFwk910TsActzUlt() ;
        
        @Data(size=8)
        IString wsFwk910CUsidActzUlt() ;
        
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
            
            @Data(size=8, value="PGHQ668A")
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
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ668A")
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
            IFormattedString impRegLidosFwk910() ;
            
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
