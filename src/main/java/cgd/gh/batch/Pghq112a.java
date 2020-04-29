package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.work.Bhtw0015 ;
import cgd.ht.structures.work.Bhtw7000 ;
import cgd.ht.structures.link.Bhtl200a ;
import cgd.ht.structures.link.Bhtl034a ;
import cgd.hy.structures.link.Bhyl500a ;
import cgd.ho.common.constants.Bhok0002 ;
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.ht.routines.Mhtq200a ;
import cgd.ht.routines.Mhtq034a ;
import cgd.hy.routines.Mhyq500a ;
import cgd.zy.batch.Pzya710a ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE ESTATISTICA
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FHT011
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO FWK003
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq112a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fhy003
     */
    @Handler(name="FHY003")
    @Data
    protected abstract Fhy003 ficheiroFhy003() ;
    
    /**
     * @return instancia da classe Fht011
     */
    @Handler(name="FHT011")
    @Data
    protected abstract Fht011 ficheiroFht011() ;
    
    /**
     * @return instancia da classe Fwk00303
     */
    @Handler(name="FWK003", record="regFwk003")
    @Data
    protected abstract Fwk00303 fwk003() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhtq200a
     */
    @Data
    protected abstract Mhtq200a hrMhtq200a() ;
    
    /**
     * @return instancia da classe Mhtq034a
     */
    @Data
    protected abstract Mhtq034a hrMhtq034a() ;
    
    /**
     * @return instancia da classe Mhyq500a
     */
    @Data
    protected abstract Mhyq500a hrMhyq500a() ;
    
    /**
     * @return instancia da classe Pzya710a
     */
    @Data
    protected abstract Pzya710a hbPzya710a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtw0015
     */
    @Data
    protected abstract Bhtw0015 bhtw0015() ;
    
    /**
     * @return instancia da classe Bhtw7000
     */
    @Data
    protected abstract Bhtw7000 bhtw7000() ;
    
    /**
     * @return instancia da classe Bhtl200a
     */
    @Data
    protected abstract Bhtl200a bhtl200a() ;
    
    /**
     * @return instancia da classe Bhtl034a
     */
    @Data
    protected abstract Bhtl034a bhtl034a() ;
    
    /**
     * @return instancia da classe Bhyl500a
     */
    @Data
    protected abstract Bhyl500a bhyl500a() ;
    
    /**
     * @return instancia da classe Bhok0002
     */
    @Data
    protected abstract Bhok0002 bhok0002() ;
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    protected static final String CON_PROGRAMA = "PGHQ112A" ;
    
    protected static final String CON_VGH01001 = "VGH01001" ;
    
    protected static final String CON_DESCRICAO = "INSER/ELIM DE REGISTOS TGH010 A PARTIR DE FICH.  " ;
    
    protected static final String CON_FWK003 = "FWK003" ;
    
    protected static final String CON_CONSULTA = "C" ;
    
    protected static final String CON_I = "I" ;
    
    protected static final String CON_E = "E" ;
    
    protected static final String CON_P = "P" ;
    
    protected static final int CON_1N = 1 ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitch
     */
    @Data
    protected abstract SwSwitch swSwitch() ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
    /**
     * 
     * BHTP0010
     * ACESSO A ROTINA DE OBTENCAO DE DATAS POR APLICACAO
     * MHTQ200A
     * 
     */
    protected void bhtp0010CaplicDatas() {
    }
    
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
     * ACESSO A ROTINA DE ACTUALIZACAO DO NUMERO
     * DE COMMITS POR PROCESSO
     * MHYQ500A
     * 
     */
    protected void bhyp0500CommitsProc() {
        exit() ;
        /**
         * BHTP0031 - BATCH SEM DB2
         * ROLLBACK E FORMATACAO DE RETURN-CODE
         */
        rollback() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
    }
    
    /**
     * 
     * FINALMENTE, MOVER AS VARIAVEIS DE OUTPUT PARA A AREA QUE SE
     * PRETENDE. POR EXEMPLO A WS-DATA-INI.
     * MOVE BHTW0015-DATE-FRM         TO WS-DATA-INI.
     * (FORMATO DATE YYYY-MM-DD)
     * MOVE BHTW0015-TIME-FRM         TO WS-HORA-INI.
     * (FORMATO TIME HH:MM:SS)
     * OU
     * MOVE BHTW0015-TMST-FRM         TO WS-CURRENT-TIMESTAMP.
     * (FORMATO TIMESTAMP 26 YYYY-MM-DD-HH.MM.SS.SSSSSS)
     * COPY DE FORMATACAO E OBTENCAO DE DATAS DE SISTEMA.
     * OBTEM A DATA DE SISTEMA COM SECULO E DISPONIBILIZA-A COM E SEM
     * FORMATACAO.
     * INSTRUCOES DE UTILIZACAO.
     * PERFORM BHTP0015-CURRENT-DATE
     * THRU BHTP0015-CURRENT-DATE-EXIT.
     * 
     */
    protected void bhtp0015CurrentDate() {
        bhtw0015().area().current().set(getTimeAsLong());
        bhtw0015().area().currentFrm().dateFrm().dateYearFrm().set(bhtw0015().area().current().currentDate().dateYear());
        bhtw0015().area().currentFrm().tmstFrm().tmstYearFrm().set(bhtw0015().area().current().currentDate().dateYear());
        bhtw0015().area().currentFrm().dateFrm().dateMonthFrm().set(bhtw0015().area().current().currentDate().dateMonth());
        bhtw0015().area().currentFrm().tmstFrm().tmstMonthFrm().set(bhtw0015().area().current().currentDate().dateMonth());
        bhtw0015().area().currentFrm().dateFrm().dateDayFrm().set(bhtw0015().area().current().currentDate().dateDay());
        bhtw0015().area().currentFrm().tmstFrm().tmstDayFrm().set(bhtw0015().area().current().currentDate().dateDay());
        bhtw0015().area().currentFrm().timeFrm().timeHhFrm().set(bhtw0015().area().current().currentTime().timeHour());
        bhtw0015().area().currentFrm().tmstFrm().tmstHhFrm().set(bhtw0015().area().current().currentTime().timeHour());
        bhtw0015().area().currentFrm().timeFrm().timeMmFrm().set(bhtw0015().area().current().currentTime().timeMin());
        bhtw0015().area().currentFrm().tmstFrm().tmstMmFrm().set(bhtw0015().area().current().currentTime().timeMin());
        bhtw0015().area().currentFrm().timeFrm().timeSsFrm().set(bhtw0015().area().current().currentTime().timeSec());
        bhtw0015().area().currentFrm().tmstFrm().tmstSsFrm().set(bhtw0015().area().current().currentTime().timeSec());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs1Frm().set(bhtw0015().area().current().currentTmst().tmstSs1());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs2Frm().set(bhtw0015().area().current().currentTmst().tmstSs2());
        bhtw0015().area().currentFrm().tmstFrm().tmstSs3Frm().set(bhtw0015().area().current().currentTmst().tmstSs3());
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
     * MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "********** INICIO **********");
        log(TraceLevel.Debug, CON_PROGRAMA, " - ", CON_DESCRICAO);
        m1000InicioPrograma() ;
        while (!fwk003().getStatusOk()) {
            m2000ProcPrograma() ;
        }
        m3000FimPrograma() ;
    }
    
    /**
     * 
     * 1000-INICIO-PROGRAMA
     * 
     */
    protected void m1000InicioPrograma() {
        log(TraceLevel.Debug, "1000-INICIO-PROGRAMA");
        m1100IniciaVars() ;
        m1200TrataEstatIni() ;
        m1300ObtemData() ;
        m8000DataHoraIni() ;
        m1400OpenFicheiros() ;
        m8900ObtemJobname() ;
        m1500CommitsPorProc() ;
        m1600AnalisaRearranque() ;
        log(TraceLevel.Trace, "WS-NUM-REG-REARRAN003 : ", wsVariaveis().wsRearranque().wsNumRegRearran003());
        while (wsVariaveis().wsNumRegFwk003().isLess(wsVariaveis().wsRearranque().wsNumRegRearran003()) && !fwk003().getStatusOk()) {
            m1700ReadFwk003() ;
        }
        wsVariaveis().wsNumRegFwk003().set(1);
    }
    
    /**
     * 
     * 1100-INICIA-VARS
     * 
     */
    protected void m1100IniciaVars() {
        log(TraceLevel.Debug, "1100-INICIA-VARS");
        wsVariaveis().initialize() ;
        bhtl200a().commarea().initialize() ;
        bhtl034a().commarea().initialize() ;
        hv01001Contiphst().contiphst().initialize() ;
        bhtp0011ObtemDados() ;
    }
    
    /**
     * 
     * 1200-TRATA-ESTAT-INI
     * 
     */
    protected void m1200TrataEstatIni() {
        log(TraceLevel.Debug, "1200-TRATA-ESTAT-INI");
        bhow0013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhow0013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhop0013InicioEstat() ;
    }
    
    /**
     * 
     * 1300-OBTEM-DATA
     * 
     */
    protected void m1300ObtemData() {
        log(TraceLevel.Debug, "1300-OBTEM-DATA");
        bhtl200a().commarea().initialize() ;
        bhtl200a().commarea().dadosEntrada().cPaisIsoAlfn().set(bhtw0011().commarea().dadosSaida().cPaisIsoAlfn());
        bhtl200a().commarea().dadosEntrada().aAplicacao().set(bhok0002().BHOK0002_APLIC_MANUT_CONTAS);
        bhtp0010CaplicDatas() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotDatasAplic());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(CON_CONSULTA);
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl200a().commarea().dadosSaida().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl200a().commarea().dadosSaida().aAplErr());
        bhop0013FormataAcesso() ;
        if (bhtl200a().commarea().dadosSaida().semErros().isTrue()) {
            wsVariaveis().wsZProcessamento().set(bhtl200a().commarea().dadosSaida().zProcessamento());
        } else {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl200a().commarea().dadosSaida().cTipoErroBbn());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl200a().commarea().dadosSaida().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl200a().commarea().dadosSaida().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotDatasAplic());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl200a().commarea().dadosEntrada());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl200a().commarea().dadosSaida().nmTabela());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9000TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 1400-OPEN-FICHEIROS
     * 
     */
    protected void m1400OpenFicheiros() {
        log(TraceLevel.Debug, "1400-OPEN-FICHEIROS");
        fwk003().open() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (!fwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1400-OPEN-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(fwk003().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1500-COMMITS-POR-PROC
     * 
     */
    protected void m1500CommitsPorProc() {
        log(TraceLevel.Debug, "1500-COMMITS-POR-PROC");
        /**
         * MOVE CON-PROGRAMA             TO BHYL500A-NM-PRG-BTCH.
         */
        bhyl500a().commarea().dadosInput().nmPrgBtch().set(bhtw7000().parmarea().area8());
        bhyl500a().commarea().dadosInput().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhyl500a().commarea().dadosInput().hFimExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhyp0500CommitsProc() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhyk0002().alfanumeric().rotCommitsProc());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhyl500a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhyl500a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhyl500a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhyl500a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhyl500a().commarea().dadosOutput().campErro());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhyl500a().commarea().dadosInput());
            bhtw0030().dadosEntrada().cSqlcode().set(bhyl500a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhyk0002().alfanumeric().rotCommitsProc());
            bhtw0030().dadosEntrada().nmTabela().set(bhyl500a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().xCteuChavTab().set(bhyl500a().commarea().dadosOutput().chvAces());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhyl500a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 8900-OBTEM-JOBNAME
     * 
     */
    protected void m8900ObtemJobname() {
        log(TraceLevel.Debug, "8900-OBTEM-JOBNAME");
        bhtw7000().jobname().setTrue() ;
        bhtp7000DadosSistema() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtw7000().indicadoresErro().modOrigemErro());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(" ");
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtw7000().indicadoresErro().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtw7000().indicadoresErro().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtw7000().indicadoresErro().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtw7000().indicadoresErro().semErros().isTrue()) {
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtw7000().indicadoresErro().cTipoErroBbn());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(" ");
            bhtw0030().dadosEntrada().cSqlcode().set("0");
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtw7000().indicadoresErro().modOrigemErro());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtw7000().indicadoresErro().chAcesso());
            bhtw0030().dadosEntrada().nmTabela().set(" ");
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1600-ANALISA-REARRANQUE
     * 
     */
    protected void m1600AnalisaRearranque() {
        log(TraceLevel.Debug, "1600-ANALISA-REARRANQUE");
        bhtl034a().commarea().dadosOutput().initialize() ;
        bhtl034a().commarea().dadosInput().consulta().setTrue() ;
        /**
         * MOVE CON-PROGRAMA             TO BHTL034A-NM-PROGRAMA.
         */
        bhtl034a().commarea().dadosInput().nmPrograma().set(bhtw7000().parmarea().area8());
        bhtl034a().commarea().dadosInput().zProcessamento().set(bhtl200a().commarea().dadosSaida().zProcessamento());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotRecuperacao());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(bhtl034a().commarea().dadosInput().iAccao());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl034a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (bhtl034a().commarea().dadosOutput().errosFuncao().isTrue()) {
            wsVariaveis().wsRearranque().wsNumRegRearran003().set(CON_1N);
        } else if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            wsVariaveis().wsRearranque().set(bhtl034a().commarea().dadosInpOut().xDescChavTab());
            log(TraceLevel.Debug, " >CHAVE DO REARRANQUE ");
            log(TraceLevel.Debug, " WS-REARRANQUE : ", wsVariaveis().wsRearranque());
        } else {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhtl034a().commarea().dadosOutput().campErro());
            bhtw0030().dadosEntrada().xCteuChavTab().set(bhtl034a().commarea().dadosOutput().chvAces());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotRecuperacao());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl034a().commarea().dadosOutput().chvAces());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl034a().commarea().dadosOutput().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 1700-READ-FWK003
     * 
     */
    protected void m1700ReadFwk003() {
        log(TraceLevel.Debug, "1700-READ-FWK003");
        fwk003().regFwk003().initialize() ;
        fwk003().read() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fwk003().getStatus());
        bhop0013FormataAcesso() ;
        wsVariaveis().wsTotReadFwk003().add(CON_1N);
        if (fwk003().getStatusOk()) {
            wsVariaveis().wsNumRegFwk003().add(1);
        } else if (!fwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("1700-READ-FWK003");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(fwk003().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        if (fwk003().regFwk003().fwk003IAcao().isEqual(CON_I)) {
            m2100InsereTgh010() ;
        } else if (fwk003().regFwk003().fwk003IAcao().isEqual(CON_E)) {
            m2200EliminaTgh010() ;
        }
        if (wsVariaveis().wsNumRegFwk003().isGreaterOrEqual(bhyl500a().commarea().dadosOutput().qCommit())) {
            m2300ExecutaCommit() ;
        }
        m1700ReadFwk003() ;
    }
    
    /**
     * 
     * 2100-INSERE-TGH010
     * 
     */
    protected void m2100InsereTgh010() {
        log(TraceLevel.Debug, "2100-INSERE-TGH010");
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(fwk003().regFwk003().fwk003CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(fwk003().regFwk003().fwk003CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(fwk003().regFwk003().fwk003COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(fwk003().regFwk003().fwk003NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(fwk003().regFwk003().fwk003VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(fwk003().regFwk003().fwk003CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(fwk003().regFwk003().fwk003CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(fwk003().regFwk003().fwk003NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set(fwk003().regFwk003().fwk003NmRecurso());
        hv01001Contiphst().contiphst().cTipoInfHist().set(CON_P);
        hv01001Contiphst().contiphst().zaInicio().set(fwk003().regFwk003().fwk003ZaInicio());
        hv01001Contiphst().contiphst().zaFim().set(fwk003().regFwk003().fwk003ZaFim());
        hv01001Contiphst().contiphst().cUsidActzUlt().set(CON_PROGRAMA);
        /**
         * Migration Note:
         * call to extracted method to access (INSERT) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().insertPghq112a622() ;
        swSwitch().swSqlcodeVgh01001().set(hv01001Contiphst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swInsert().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH01001);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitch().swVgh01001Ok().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH01001);
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv01001Contiphst().contiphst());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO INSERT NA CTA TIPO HISTORIC");
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtk0002().indErros().abendDb2());
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2200-ELIMINA-TGH010
     * 
     */
    protected void m2200EliminaTgh010() {
        log(TraceLevel.Debug, "2200-ELIMINA-TGH010");
        hv01001Contiphst().contiphst().initialize() ;
        hv01001Contiphst().contiphst().cPaisIsoaCont().set(fwk003().regFwk003().fwk003CPaisIsoaCont());
        hv01001Contiphst().contiphst().cBancCont().set(fwk003().regFwk003().fwk003CBancCont());
        hv01001Contiphst().contiphst().cOeEgcCont().set(fwk003().regFwk003().fwk003COeEgcCont());
        hv01001Contiphst().contiphst().nsRdclCont().set(fwk003().regFwk003().fwk003NsRdclCont());
        hv01001Contiphst().contiphst().vChkdCont().set(fwk003().regFwk003().fwk003VChkdCont());
        hv01001Contiphst().contiphst().cTipoCont().set(fwk003().regFwk003().fwk003CTipoCont());
        hv01001Contiphst().contiphst().cMoedIsoScta().set(fwk003().regFwk003().fwk003CMoedIsoScta());
        hv01001Contiphst().contiphst().nsDeposito().set(fwk003().regFwk003().fwk003NsDeposito());
        hv01001Contiphst().contiphst().nmRecurso().set(fwk003().regFwk003().fwk003NmRecurso());
        hv01001Contiphst().contiphst().zaInicio().set(fwk003().regFwk003().fwk003ZaInicio());
        hv01001Contiphst().contiphst().zaFim().set(fwk003().regFwk003().fwk003ZaFim());
        /**
         * Migration Note:
         * call to extracted method to access (DELETE) table VGH01001_CONTIPHST
         */
        hv01001Contiphst().deletePghq112a706() ;
        swSwitch().swSqlcodeVgh01001().set(hv01001Contiphst().getPersistenceCode());
        bhow0013().dadosInput().tabela().setTrue() ;
        bhow0013().dadosInput().dadosTabela().swDelete().setTrue() ;
        bhow0013().dadosInput().dadosTabela().nmTabela().set(CON_VGH01001);
        bhow0013().dadosInput().dadosTabela().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
        bhop0013FormataAcesso() ;
        if (!swSwitch().swVgh01001Ok().isTrue() && !swSwitch().swVgh01001Notfnd().isTrue()) {
            bhtw0030().dadosEntrada().cSqlcode().set(hv01001Contiphst().getPersistenceCode());
            bhtw0030().dadosEntrada().nmTabela().set(CON_VGH01001);
            bhtw0030().dadosEntrada().xCteuChavTab().set(hv01001Contiphst().contiphst());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("ERRO NO DELETE NA CTA TIPO HISTORIC");
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtk0002().indErros().abendDb2());
            m9200TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2300-EXECUTA-COMMIT
     * 
     */
    protected void m2300ExecutaCommit() {
        log(TraceLevel.Debug, "*********2300-EXECUTA-COMMIT*********");
        bhtl034a().commarea().initialize() ;
        wsVariaveis().wsRearranque().wsNumRegRearran003().add(wsVariaveis().wsNumRegFwk003());
        wsVariaveis().wsNumRegFwk003().set(0);
        bhtl034a().commarea().dadosInput().modificacao().setTrue() ;
        /**
         * MOVE CON-PROGRAMA             TO BHTL034A-NM-PROGRAMA.
         */
        bhtl034a().commarea().dadosInput().nmPrograma().set(bhtw7000().parmarea().area8());
        bhtl034a().commarea().dadosInput().zProcessamento().set(bhtl200a().commarea().dadosSaida().zProcessamento());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsRearranque());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotRecuperacao());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(bhtl034a().commarea().dadosInput().iAccao());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl034a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            wsVariaveis().wsNumRegFwk003().set(0);
        } else {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhtl034a().commarea().dadosOutput().campErro());
            bhtw0030().dadosEntrada().xCteuChavTab().set(bhtl034a().commarea().dadosOutput().chvAces());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotRecuperacao());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl034a().commarea().dadosOutput().chvAces());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl034a().commarea().dadosOutput().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, "3000-FIM-PROGRAMA");
        m3200FechaRecuperacao() ;
        m3100FechaFicheiros() ;
        bhop0013FimEstatistica() ;
        log(TraceLevel.Debug, "****************************************");
        log(TraceLevel.Debug, "NUM REGS LIDOS DO FICHEIRO INPUT : ", wsVariaveis().wsNumRegFwk003());
    }
    
    /**
     * 
     * 3100-FECHA-FICHEIROS
     * 
     */
    protected void m3100FechaFicheiros() {
        log(TraceLevel.Debug, "3100-FECHA-FICHEIROS");
        fwk003().close() ;
        bhow0013().dadosInput().ficheiro().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhow0013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK003);
        bhow0013().dadosInput().dadosFicheiro().cFsttCobl().set(fwk003().getStatus());
        bhop0013FormataAcesso() ;
        if (!fwk003().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK003);
            bhtw0030().dadosEntrada().cFsttCobl().set(fwk003().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 3200-FECHA-RECUPERACAO
     * 
     */
    protected void m3200FechaRecuperacao() {
        log(TraceLevel.Debug, "3200-FECHA-RECUPERACAO");
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().fimProcessoOk().setTrue() ;
        /**
         * MOVE CON-PROGRAMA             TO BHTL034A-NM-PROGRAMA.
         */
        bhtl034a().commarea().dadosInput().nmPrograma().set(bhtw7000().parmarea().area8());
        bhtl034a().commarea().dadosInput().zProcessamento().set(bhtl200a().commarea().dadosSaida().zProcessamento());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsRearranque());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(CON_DESCRICAO);
        bhtp0034AcessoRecup() ;
        bhow0013().dadosInput().rotina().setTrue() ;
        bhow0013().dadosInput().dadosRotinas().nmRotina().set(bhtk0002().rotRecuperacao());
        bhow0013().dadosInput().dadosRotinas().iOperacao().set(bhtl034a().commarea().dadosInput().iAccao());
        bhow0013().dadosInput().dadosRotinas().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        bhow0013().dadosInput().dadosRotinas().cRtnoEvenSwal().set(bhtl034a().commarea().dadosOutput().cRtnoEvenSwal());
        bhow0013().dadosInput().dadosRotinas().aAplErr().set(bhtl034a().commarea().dadosOutput().aAplErr());
        bhop0013FormataAcesso() ;
        if (!bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(bhtl034a().commarea().dadosOutput().campErro());
            bhtw0030().dadosEntrada().xCteuChavTab().set(bhtl034a().commarea().dadosOutput().chvAces());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            bhtw0030().dadosEntrada().cSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0030().dadosEntrada().nmPrgChmd().set(bhtk0002().rotRecuperacao());
            bhtw0030().dadosEntrada().xCteuAlig().set(bhtl034a().commarea().dadosOutput().chvAces());
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhtl034a().commarea().dadosOutput().cTipoOpeObjDb2());
            bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            bhtw0030().dadosEntrada().abend().setTrue() ;
            m9900Abend() ;
        }
    }
    
    /**
     * 
     * 8000-DATA-HORA-INI
     * 
     */
    protected void m8000DataHoraIni() {
        log(TraceLevel.Debug, "8000-DATA-HORA-INI");
        bhtp0015CurrentDate() ;
        wsVariaveis().wsDataIni().set(bhtw0015().area().currentFrm().dateFrm());
        wsVariaveis().wsHoraIni().set(bhtw0015().area().currentFrm().timeFrm());
        wsVariaveis().wsTimestamp().set(bhtw0015().area().currentFrm().tmstFrm());
    }
    
    /**
     * 
     * 8100-DATA-HORA-FIM
     * 
     */
    protected void m8100DataHoraFim() {
        log(TraceLevel.Debug, "8100-DATA-HORA-FIM");
        bhtp0015CurrentDate() ;
        wsVariaveis().wsDataFim().set(bhtw0015().area().currentFrm().dateFrm());
        wsVariaveis().wsHoraFim().set(bhtw0015().area().currentFrm().timeFrm());
    }
    
    /**
     * 
     * 9000-TRATA-ERRO-ROTINA
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADAS AS SE-
     * GUINTES VARIAVEIS:
     * BHTW0030-C-SQLCODE: SQLCODE DEVOLVIDO PELA ROTINA
     * BHTW0030-NM-TABELA: NOME TABELA DEVOLVIDO PELA ROTINA
     * BHTW0030-NM-PRG-CHMD: NOME PROGRAMA CHAMADO (ROTINA)
     * BHTW0030-C-TIPO-ERR-PRG-CHMD: ERRO DEVOLVIDO PELA PROGRAMA
     * CHAMADO (ROTINA) -
     * C-TIPO-ERRO-BBN
     * BHTW0030-X-CTEU-ALIG: DADOS DE INPUT DA ROTINA
     * BHTW0030-X-SUG-RTNO-SWAL: OBSERVACOES A RESPEITO DO ERRO
     * OCORRIDO (PREENCHER COM O NOME
     * DO PARAGRAFO DO PROGRAMA ONDE A
     * FALHA TEVE ORIGEM)
     * 
     */
    protected void m9000TrataErroRotina() {
        log(TraceLevel.Debug, "9000-TRATA-ERRO-ROTINA");
        m8100DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abend().setTrue() ;
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosRotinas().iOperacao());
        bhop0013FimEstatistica() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9100-TRATA-ERRO-FICH
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADAS AS SE-
     * GUINTES VARIAVEIS:
     * BHTW0030-NM-FICHEIRO : NOME FICHEIRO
     * BHTW0030-C-FSTT-COBL: FILE STATUS
     * BHTW0030-X-SUG-RTNO-SWAL: DESCRICAO DO ERRO
     * 
     */
    protected void m9100TrataErroFich() {
        log(TraceLevel.Debug, "9100-TRATA-ERRO-FICH");
        m8100DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosFicheiro().cTipoOpeFich());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhop0013FimEstatistica() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9200-TRATA-ERRO-DB2
     * 
     */
    protected void m9200TrataErroDb2() {
        log(TraceLevel.Debug, "9200-TRATA-ERRO-DB2");
        m8100DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(bhow0013().dadosInput().dadosTabela().cTipoOpeObjDb2());
        bhtw0030().dadosEntrada().abendDb2().setTrue() ;
        bhop0013FimEstatistica() ;
        bhtp0030DisplayErro() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9900-ABEND
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Debug, "9900-ABEND");
        /**
         * PARTE VARIAVEL PARA FECHOS INCONDICIONAIS
         */
        fwk003().close() ;
        bhtw0030().dadosEntrada().nmPrograma().set(CON_PROGRAMA);
        bhtw0030().dadosEntrada().zInicExePrg().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hInicExePrg().set(bhow0013().dadosAuxiliares().horaAux2());
        bhop0013FimEstatistica() ;
        bhtw0030().dadosEntrada().zErro().set(bhow0013().dadosAuxiliares().dataAux2());
        bhtw0030().dadosEntrada().hErro().set(bhow0013().dadosAuxiliares().horaAux2());
        bhtp0030DisplayErro() ;
        rollback() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
        exit() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        m0000Mainline() ;
    }
    /**
     * Inner Classes
     */
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitch extends IDataStruct {
        
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Eof() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk003() ;
        @Data
        @Condition("00")
        ICondition swFwk003Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk003Eof() ;
        
        
        @Data(size=3, signed=true, value="0")
        IInt swSqlcodeVgh01001() ;
        @Data
        @Condition("0")
        ICondition swVgh01001Ok() ;
        @Data
        @Condition("100")
        ICondition swVgh01001Notfnd() ;
        
        
    }
    public interface WsVariaveis extends IDataStruct {
        
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=10, value=" ")
        IString wsZProcessamento() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        @Data(size=15)
        ILong wsNumRegFwk003() ;
        
        @Data(size=15)
        ILong wsTotReadFwk003() ;
        
        /**
         * @return instancia da classe local WsRearranque
         */
        @Data
        WsRearranque wsRearranque() ;
        
        
        public interface WsRearranque extends IDataStruct {
            
            @Data(size=15, rpadding=235)
            ILong wsNumRegRearran003() ;
            
        }
    }
    
}
