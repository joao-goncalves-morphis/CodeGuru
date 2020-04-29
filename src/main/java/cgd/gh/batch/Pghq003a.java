package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
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
import cgd.hy.common.constants.Bhyk0002 ;
import cgd.hy.structures.link.Bhyl230a ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.structures.link.Bhtl034a ;
import cgd.hy.structures.link.Bhyl500a ;
import cgd.hy.routines.Mhyj230a ;
import cgd.ht.routines.Mhtq034a ;
import cgd.hy.routines.Mhyq500a ;


/**
 * 
 * COPY DE DADOS GERAIS DA APLICACAO
 * DEFINICAO FICHEIRO DE INPUT 1
 * WORKING STORAGE SECTION
 * D A T A   D I V I S I O N
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq003a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps00201Movhst
     */
    @Data
    protected abstract Vwsdghps00201Movhst hv00201Movhst() ;
    
    /**
     * @return instancia da classe Vwsdghps10201Movhstcpl
     */
    @Data
    protected abstract Vwsdghps10201Movhstcpl hv10201Movhstcpl() ;
    
    
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
     * @return instancia da classe Fwk049
     */
    @Handler(name="FWK049", record="regFwk049")
    @Data
    protected abstract Fwk049 ficheiroFwk049() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhyj230a
     */
    @Data
    protected abstract Mhyj230a hrMhyj230a() ;
    
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
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhyk0002
     */
    @Data
    protected abstract Bhyk0002 bhyk0002() ;
    
    /**
     * @return instancia da classe Bhyl230a
     */
    @Data
    protected abstract Bhyl230a bhyl230a() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
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
     * INICIO WORKING-STORAGE PGHQ003A
     */
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * COPY DE REARRANQUE
     * MENSAGENS
     * @return instancia da classe local MsgMensagens
     */
    @Data
    protected abstract MsgMensagens msgMensagens() ;
    
    /**
     * STATUS DAS TABELAS
     */
    @Data(size=3, signed=true, value="0")
    protected IInt swSqlcodeVgh00201 ;
    @Data
    @Condition("100")
    protected ICondition swVgh00201Notfnd ;
    @Data
    @Condition("0")
    protected ICondition swVgh00201Ok ;
    
    
    @Data(size=3, signed=true, value="0")
    protected IInt swSqlcodeVgh10201 ;
    @Data
    @Condition("100")
    protected ICondition swVgh10201Notfnd ;
    @Data
    @Condition("0")
    protected ICondition swVgh10201Ok ;
    
    
    /**
     * CONSTANTES
     * @return instancia da classe local WsConContantes
     */
    @Data
    protected abstract WsConContantes wsConContantes() ;
    
    /**
     * VARIAVEIS
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    
    
    /**
     * 
     * ROTINA DE CONVERSAO E CALCULO DE DATAS
     * 
     */
    protected void bhyp0200RotinaDatas() {
        hrMhyj230a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA DE RECUPERACAO PARA O BATCH
     * MHTQ034A
     * 
     */
    protected void bhtp0034AcessoRecup() {
        hrMhtq034a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACTUALIZACAO DO NUMERO
     * DE COMMITS POR PROCESSO
     * MHYQ500A
     * 
     */
    protected void bhyp0500CommitsProc() {
        hrMhyq500a().run() ;
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
     * PROCESSO
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (ficheiroFwk049().getStatusOk()) {
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
        m1010Inicializacoes() ;
        m1050AbreEstatisticas() ;
        m1300CommitsPorProc() ;
        m1400AnalisaRearranque() ;
        m1100OpenFwk049() ;
        log(TraceLevel.Trace, " WS-TOT-READ-FWK049 : ", wsVariaveis().wsTotReadFwk049());
        log(TraceLevel.Trace, " WS-NUM-REG-REARRAN001 : ", wsVariaveis().wsRearranque().wsNumRegRearran001());
        while (wsVariaveis().wsNumRegFwk049().isLessOrEqual(wsVariaveis().wsRearranque().wsNumRegRearran001()) && !ficheiroFwk049().getStatusOk()) {
            m1400ReadFwk049() ;
        }
    }
    
    /**
     * 
     * 1010-INICIALIZACOES
     * 
     */
    protected void m1010Inicializacoes() {
        wsVariaveis().initialize() ;
        bhyl500a().commarea().initialize() ;
    }
    
    /**
     * 
     * 1050-ABRE-ESTATISTICAS
     * 
     */
    protected void m1050AbreEstatisticas() {
        log(TraceLevel.Debug, "1050-ABRE-ESTATISTICAS");
        bhtp0033AbreEstat() ;
        wsVariaveis().wsDataIni().set( getDBDate() ) ;
        wsVariaveis().wsHoraIni().set( getDBTime() ) ;
        bhtw0033().dadosGerais().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtw0033().dadosGerais().dFunlPrg().set(wsConContantes().conDescricao());
        bhtw0033().dadosGerais().zInicPrct().set(wsVariaveis().wsDataIni());
        bhtw0033().dadosGerais().hInicPrct().set(wsVariaveis().wsHoraIni());
        bhtw0033().dadosGerais().zFimPrct().set(wsVariaveis().wsDataFim());
        bhtw0033().dadosGerais().hFimPrct().set(wsVariaveis().wsHoraFim());
        bhtw0033().dadosGerais().xCteuAlig().set(" ");
        bhtp0033WriteEstatCab() ;
        bhtw0030().dadosEntrada().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
    }
    
    /**
     * 
     * 1100-OPEN-FWK049
     * 
     */
    protected void m1100OpenFwk049() {
        log(TraceLevel.Debug, "1100-OPEN-FWK049");
        ficheiroFwk049().open() ;
        log(TraceLevel.Debug, "OI STATUS-FWK049:  ", ficheiroFwk049().getStatus());
        if (!ficheiroFwk049().getStatusOk()) {
            log(TraceLevel.Error, "ERRO DA ABERTURA DE FWK049");
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk049());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conOpen());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk049().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotOpenFwk049().add(1);
        }
    }
    
    /**
     * 
     * 1300-COMMITS-POR-PROCESSO
     * 
     */
    protected void m1300CommitsPorProc() {
        log(TraceLevel.Debug, "1300-COMMITS-POR-PROC");
        bhyl500a().commarea().dadosInput().nmPrgBtch().set(wsConContantes().conNomePrograma());
        bhyl500a().commarea().dadosInput().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhyl500a().commarea().dadosInput().hFimExePrg().set(wsVariaveis().wsHoraIni());
        bhyp0500CommitsProc() ;
        if (bhyl500a().commarea().dadosOutput().semErros().isTrue()) {
            bhyl500a().commarea().dadosOutput().qCommit().set(wsConContantes().conQCommitsReal());
        } else {
            bhtw0033().dadosRotina().nmRtnaAces().set(wsConContantes().conMhtq500a());
            wsVariaveis().wsNmTabela().set(bhyl500a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhyl500a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhyl500a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhyl500a().commarea().dadosInput());
            m9100TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 1400-ANALISA-REARRANQUE
     * 
     */
    protected void m1400AnalisaRearranque() {
        log(TraceLevel.Debug, "1400-ANALISA-REARRANQUE");
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().consulta().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtl034a().commarea().dadosInput().zProcessamento().set(wsVariaveis().wsDataIni());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(wsConContantes().conDescricao());
        bhtp0034AcessoRecup() ;
        log(TraceLevel.Trace, "BHTL034A-C-TIPO-ERRO-BBN : ", bhtl034a().commarea().dadosOutput().cTipoErroBbn());
        if (bhtl034a().commarea().dadosOutput().errosFuncao().isTrue()) {
            log(TraceLevel.Error, "ERROS-FUNCAO");
            wsVariaveis().wsRearranque().initialize() ;
        } else if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            log(TraceLevel.Error, "SEM-ERROS");
            wsVariaveis().wsRearranque().set(bhtl034a().commarea().dadosInpOut().xDescChavTab());
        } else {
            log(TraceLevel.Error, "ERROS");
            bhtw0033().dadosRotina().nmRtnaAces().set(wsConContantes().conMhtq034a());
            wsVariaveis().wsNmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhtl034a().commarea().dadosInput());
            m9100TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 1400-READ-FWK049
     * 
     */
    protected void m1400ReadFwk049() {
        log(TraceLevel.Debug, "1500-PRIM-READ-FWK049");
        ficheiroFwk049().read() ;
        log(TraceLevel.Debug, "READ STATUS-FWK049:  ", ficheiroFwk049().getStatus());
        if (ficheiroFwk049().getStatusOk()) {
            log(TraceLevel.Error, " LEU SEM ERROS");
            wsVariaveis().wsTotReadFwk049().add(1);
            wsVariaveis().wsNumRegFwk049().add(1);
        } else if (!ficheiroFwk049().getStatusOk()) {
            log(TraceLevel.Error, "LEU COM ERROS");
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk049());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conRead());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk049().getStatus());
            m9300TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 2000-PROC-PROGRAMA
     * 
     */
    protected void m2000ProcPrograma() {
        log(TraceLevel.Debug, "2000-PROC-PROGRAMA");
        m2100TrataThg002() ;
        m2200TrataThg102() ;
        log(TraceLevel.Trace, "BHYL500A-Q-COMMIT : ", bhyl500a().commarea().dadosOutput().qCommit());
        log(TraceLevel.Trace, "WS-NUM-REG-FWK049 : ", wsVariaveis().wsNumRegFwk049());
        if (wsVariaveis().wsNumRegFwk049().isGreaterOrEqual(bhyl500a().commarea().dadosOutput().qCommit())) {
            m2800ExecutaCommit() ;
        }
        m1400ReadFwk049() ;
    }
    
    /**
     * 
     * 2100-TRATA-THG002
     * 
     */
    protected void m2100TrataThg002() {
        log(TraceLevel.Debug, "2100-TRATA-THG002");
        hv00201Movhst().movhst().cPaisIsoaCont().set(ficheiroFwk049().regFwk049().cPaisIsoaCont());
        hv00201Movhst().movhst().cBancCont().set(ficheiroFwk049().regFwk049().cBancCont());
        hv00201Movhst().movhst().cOeEgcCont().set(ficheiroFwk049().regFwk049().cOeEgcCont());
        hv00201Movhst().movhst().nsRdclCont().set(ficheiroFwk049().regFwk049().nsRdclCont());
        hv00201Movhst().movhst().vChkdCont().set(ficheiroFwk049().regFwk049().vChkdCont());
        hv00201Movhst().movhst().cTipoCont().set(ficheiroFwk049().regFwk049().cTipoCont());
        hv00201Movhst().movhst().cMoedIsoScta().set(ficheiroFwk049().regFwk049().cMoedIsoScta());
        hv00201Movhst().movhst().nsDeposito().set(ficheiroFwk049().regFwk049().nsDeposito());
        hv00201Movhst().movhst().tsMovimento().set(ficheiroFwk049().regFwk049().tsMovimento());
        hv00201Movhst().movhst().nsMovimento().set(ficheiroFwk049().regFwk049().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH00201_MOVHST
         */
        hv00201Movhst().updatePghq003a531(wsConContantes().conTsAlterar()) ;
        swSqlcodeVgh00201.set(hv00201Movhst().getPersistenceCode());
        wsVariaveis().wsTotVgh00201Upd().add(1);
        if (!swVgh00201Ok.isTrue()) {
            wsVariaveis().wsErroDb2().set(wsConContantes().conUpdate());
            wsVariaveis().wsNomeTabela().set(wsConContantes().conVgh00201());
            wsVariaveis().wsChAcesso().set(concat(wsVariaveis().wsCampo1(), wsVariaveis().wsCampo2()));
            bhtw0033().dadosDb2().nmTabela().set(wsConContantes().conVgh00201());
            bhtw0033().dadosDb2().cTipoOpeObjDb2().set(wsConContantes().conUpdate());
            bhtw0033().dadosDb2().cSqlcode().set(swSqlcodeVgh00201);
            bhtw0033().dadosDb2().qAcesTab().set(wsVariaveis().wsTotVgh00201Upd());
            m9400TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2200-TRATA-THG102
     * 
     */
    protected void m2200TrataThg102() {
        log(TraceLevel.Debug, "2200-TRATA-THG102");
        hv10201Movhstcpl().movhstcpl().cPaisIsoaCont().set(ficheiroFwk049().regFwk049().cPaisIsoaCont());
        hv10201Movhstcpl().movhstcpl().cBancCont().set(ficheiroFwk049().regFwk049().cBancCont());
        hv10201Movhstcpl().movhstcpl().cOeEgcCont().set(ficheiroFwk049().regFwk049().cOeEgcCont());
        hv10201Movhstcpl().movhstcpl().nsRdclCont().set(ficheiroFwk049().regFwk049().nsRdclCont());
        hv10201Movhstcpl().movhstcpl().vChkdCont().set(ficheiroFwk049().regFwk049().vChkdCont());
        hv10201Movhstcpl().movhstcpl().cTipoCont().set(ficheiroFwk049().regFwk049().cTipoCont());
        hv10201Movhstcpl().movhstcpl().cMoedIsoScta().set(ficheiroFwk049().regFwk049().cMoedIsoScta());
        hv10201Movhstcpl().movhstcpl().nsDeposito().set(ficheiroFwk049().regFwk049().nsDeposito());
        hv10201Movhstcpl().movhstcpl().tsMovimento().set(ficheiroFwk049().regFwk049().tsMovimento());
        hv10201Movhstcpl().movhstcpl().nsMovimento().set(ficheiroFwk049().regFwk049().nsMovimento());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH10201_MOVHSTCPL
         */
        hv10201Movhstcpl().updatePghq003a589(wsConContantes().conTsAlterar()) ;
        swSqlcodeVgh10201.set(hv10201Movhstcpl().getPersistenceCode());
        wsVariaveis().wsTotVgh10201Upd().add(1);
        if (!swVgh10201Ok.isTrue()) {
            wsVariaveis().wsErroDb2().set(wsConContantes().conUpdate());
            wsVariaveis().wsNomeTabela().set(wsConContantes().conVgh10201());
            wsVariaveis().wsChAcesso().set(concat(wsVariaveis().wsCampo1(), wsVariaveis().wsCampo2()));
            bhtw0033().dadosDb2().nmTabela().set(wsConContantes().conVgh10201());
            bhtw0033().dadosDb2().cTipoOpeObjDb2().set(wsConContantes().conUpdate());
            bhtw0033().dadosDb2().cSqlcode().set(swSqlcodeVgh10201);
            bhtw0033().dadosDb2().qAcesTab().set(wsVariaveis().wsTotVgh10201Upd());
            m9400TrataErroDb2() ;
        }
    }
    
    /**
     * 
     * 2800-EXECUTA-COMMIT
     * 
     */
    protected void m2800ExecutaCommit() {
        log(TraceLevel.Debug, "2800-EXECUTA-COMMIT");
        bhtl034a().commarea().initialize() ;
        wsVariaveis().wsRearranque().wsNumRegRearran001().add(wsVariaveis().wsNumRegFwk049());
        bhtl034a().commarea().dadosInput().modificacao().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtl034a().commarea().dadosInput().zProcessamento().set(wsVariaveis().wsDataIni());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsRearranque());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(wsConContantes().conDescricao());
        bhtp0034AcessoRecup() ;
        if (bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            wsVariaveis().wsNumRegFwk049().set(0);
        } else {
            bhtw0033().dadosRotina().nmRtnaAces().set(wsConContantes().conMhtq034a());
            wsVariaveis().wsNmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhtl034a().commarea().dadosInput());
            m9100TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, "3000-FIM-PROGRAMA");
        m3100CloseFwk049() ;
        m3300FechaRecuperacao() ;
        commit() ;
    }
    
    /**
     * 
     * 3100-CLOSE-FWK049
     * 
     */
    protected void m3100CloseFwk049() {
        log(TraceLevel.Debug, "3100-CLOSE-FWK049");
        ficheiroFwk049().close() ;
        if (!ficheiroFwk049().getStatusOk()) {
            wsVariaveis().wsNomeFicheiro().set(wsConContantes().conFwk049());
            wsVariaveis().wsAccaoFicheiro().set(wsConContantes().conClose());
            wsVariaveis().wsStatusFicheiro().set(ficheiroFwk049().getStatus());
            m9300TrataErroFich() ;
        } else {
            wsVariaveis().wsTotCloseFwk049().add(1);
        }
    }
    
    /**
     * 
     * 3300-FECHA-RECUPERACAO
     * 
     */
    protected void m3300FechaRecuperacao() {
        log(TraceLevel.Debug, "3300-FECHA-RECUPERACAO");
        bhtl034a().commarea().initialize() ;
        bhtl034a().commarea().dadosInput().fimProcessoOk().setTrue() ;
        bhtl034a().commarea().dadosInput().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtl034a().commarea().dadosInput().zProcessamento().set(wsVariaveis().wsDataIni());
        bhtl034a().commarea().dadosInpOut().xDescChavTab().set(wsVariaveis().wsRearranque());
        bhtl034a().commarea().dadosInput().xCteuChavTab().set(wsConContantes().conDescricao());
        bhtp0034AcessoRecup() ;
        if (!bhtl034a().commarea().dadosOutput().semErros().isTrue()) {
            bhtw0033().dadosRotina().nmRtnaAces().set(wsConContantes().conMhtq034a());
            wsVariaveis().wsNmTabela().set(bhtl034a().commarea().dadosOutput().nmTabela());
            wsVariaveis().wsCSqlcode().set(bhtl034a().commarea().dadosOutput().cSqlcode());
            bhtw0033().dadosRotina().cTipoErroBbn().set(bhtl034a().commarea().dadosOutput().cTipoErroBbn());
            wsVariaveis().wsDadosEntrada().set(bhtl034a().commarea().dadosInput());
            m9100TrataErroRotina() ;
        }
    }
    
    /**
     * 
     * 3300-ESCREVE-ESTAT
     * 
     */
    protected void m3300EscreveEstat() {
        log(TraceLevel.Debug, "3300-ESCREVE-ESTAT");
        m9500DataHoraFim() ;
        bhtw0033().dadosGerais().zFimPrct().set(wsVariaveis().wsDataFim());
        bhtw0033().dadosGerais().hFimPrct().set(wsVariaveis().wsHoraFim());
        /**
         * ACESSOS DB2
         */
        bhtp0033WriteEstat() ;
        /**
         * ACESSOS A ROTINAS
         */
        bhtp0033WriteEstatR() ;
        /**
         * ESTATITISTICAS DE EXECUCAO DO FICHEIRO DE INPUT 1
         */
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conOpen());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk049());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk049().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotOpenFwk049());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conRead());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk049());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk049().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotReadFwk049());
        bhtp0033WriteEstatF() ;
        bhtw0033().dadosFicheiros().cTipoOpeFich().set(wsConContantes().conClose());
        bhtw0033().dadosFicheiros().nmFicheiro().set(wsConContantes().conFwk049());
        bhtw0033().dadosFicheiros().cFsttCobl().set(ficheiroFwk049().getStatus());
        bhtw0033().dadosFicheiros().qAcesFich().set(wsVariaveis().wsTotCloseFwk049());
        bhtp0033WriteEstatF() ;
        bhtp0033FechaEstat() ;
    }
    
    /**
     * 
     * 9100-TRATA-ERRO-ROTINA
     * 
     */
    protected void m9100TrataErroRotina() {
        log(TraceLevel.Debug, "9100-TRATA-ERRO-ROTINA");
        m9500DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abend().setTrue() ;
        bhtw0030().dadosEntrada().cSqlcode().set(wsVariaveis().wsCSqlcode());
        bhtw0030().dadosEntrada().nmTabela().set(wsVariaveis().wsNomeTabela());
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(wsConContantes().conRotina());
        bhtw0030().dadosEntrada().nmPrgChmd().set(wsVariaveis().wsNomeRotina());
        bhtw0030().dadosEntrada().cTipoErrPrgChmd().set(wsVariaveis().wsCTipoErroBbn());
        bhtw0030().dadosEntrada().xCteuAlig().set(wsVariaveis().wsDadosEntrada());
        bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsConContantes().conObs());
        bhtp0030DisplayErro() ;
        m3300EscreveEstat() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9300-TRATA-ERRO-FICH
     * 
     */
    protected void m9300TrataErroFich() {
        log(TraceLevel.Debug, "9300-TRATA-ERRO-FICH");
        m9500DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhtw0030().dadosEntrada().nmFicheiro().set(wsVariaveis().wsNomeFicheiro());
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(wsVariaveis().wsAccaoFicheiro());
        bhtw0030().dadosEntrada().cTipoErroBbn().set(wsConContantes().conErroFicheiro());
        bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsConContantes().conObs());
        bhtw0030().dadosEntrada().cFsttCobl().set(wsVariaveis().wsStatusFicheiro());
        bhtp0030DisplayErro() ;
        m3300EscreveEstat() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9400-TRATA-ERRO-DB2
     * 
     */
    protected void m9400TrataErroDb2() {
        log(TraceLevel.Debug, "9400-TRATA-ERRO-DB2");
        m9500DataHoraFim() ;
        bhtw0030().dadosEntrada().nmPrograma().set(wsConContantes().conNomePrograma());
        bhtw0030().dadosEntrada().zInicExePrg().set(wsVariaveis().wsDataIni());
        bhtw0030().dadosEntrada().zErro().set(wsVariaveis().wsDataFim());
        bhtw0030().dadosEntrada().hInicExePrg().set(wsVariaveis().wsHoraIni());
        bhtw0030().dadosEntrada().hErro().set(wsVariaveis().wsHoraFim());
        bhtw0030().dadosEntrada().abendDb2().setTrue() ;
        bhtw0030().dadosEntrada().cSqlcode().set(wsVariaveis().wsCSqlcode());
        bhtw0030().dadosEntrada().nmTabela().set(wsVariaveis().wsNomeTabela());
        bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(wsVariaveis().wsErroDb2());
        bhtw0030().dadosEntrada().xCteuChavTab().set(wsVariaveis().wsChAcesso());
        bhtw0030().dadosEntrada().xSugRtnoSwal().set(wsConContantes().conObs());
        bhtp0030DisplayErro() ;
        m3300EscreveEstat() ;
        m9900Abend() ;
    }
    
    /**
     * 
     * 9500-DATA-HORA-FIM
     * 
     */
    protected void m9500DataHoraFim() {
        log(TraceLevel.Debug, "9500-DATA-HORA-FIM");
        wsVariaveis().wsDataFim().set( getDBDate() ) ;
        wsVariaveis().wsHoraFim().set( getDBTime() ) ;
    }
    
    /**
     * 
     * 
     */
    protected void m9900Abend() {
        log(TraceLevel.Trace, "9900-ABEND");
        ficheiroFwk049().close() ;
        setReturnCode(wsConContantes().conAbendGrave()) ;
        /**
         * BHTP0031 - BATCH SEM DB2
         * ROLLBACK E FORMATACAO DE RETURN-CODE
         */
        rollback() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
        /**
         * 9900-ABEND
         */
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
     * COPY DE REARRANQUE
     * MENSAGENS
     * 
     * @version 2.0
     * 
     */
    public interface MsgMensagens extends IDataStruct {
        
        @Data(size=50, value="FICHEIRO FWK049 VAZIO        - FILE STATUS       ")
        IString msgVazioFwk049() ;
        
    }
    
    /**
     * 
     * CONSTANTES
     * 
     * @version 2.0
     * 
     */
    public interface WsConContantes extends IDataStruct {
        
        @Data(size=2, value="16")
        IInt conAbendGrave() ;
        
        @Data(size=8, value="PGHQ003A")
        IString conNomePrograma() ;
        
        @Data(size=8, value="VGH00201")
        IString conVgh00201() ;
        
        @Data(size=8, value="VGH10201")
        IString conVgh10201() ;
        
        @Data(size=2, value="GH")
        IString conAplica() ;
        
        @Data(size=26, value="2011-04-23-00.00.00.000000")
        IString conTsAlterar() ;
        
        @Data(size=5, signed=true, value="5000", compression=COMP3)
        IInt conQCommitsReal() ;
        
        @Data(size=20, value="REGISTO INEXISTENTE ")
        IString conRegNaoExiste() ;
        
        @Data(size=20, value="ACTZ TGH002 E TGH102")
        IString conDescricao() ;
        
        @Data(size=8, value="MHTQ200A")
        IString conMhtq200a() ;
        
        @Data(size=8, value="MHTQ500A")
        IString conMhtq500a() ;
        
        @Data(size=8, value="MHTQ034A")
        IString conMhtq034a() ;
        
        @Data(size=6, value="FHY003")
        IString conFhy003() ;
        
        @Data(size=2, value="OP")
        IString conOpen() ;
        
        @Data(size=2, value="FE")
        IString conFetch() ;
        
        @Data(size=2, value="CL")
        IString conClose() ;
        
        @Data(size=2, value="SE")
        IString conSelect() ;
        
        @Data(size=2, value="IN")
        IString conInsert() ;
        
        @Data(size=2, value="UP")
        IString conUpdate() ;
        
        @Data(size=2, value="DL")
        IString conDelete() ;
        
        @Data(size=2, value="RO")
        IString conRotina() ;
        
        @Data(size=6, value="FHY003")
        IString conFhy00302() ;
        
        @Data(size=2, value="WR")
        IString conWrite() ;
        
        @Data(size=2, value="RS")
        IString conRead() ;
        
        @Data(size=20, value="                    ")
        IString conObs() ;
        
        @Data(size=8, value="FWK049")
        IString conFwk049() ;
        
        @Data(size=2, value="FI")
        IString conErroFicheiro() ;
        
    }
    
    /**
     * 
     * VARIAVEIS
     * 
     * @version 2.0
     * 
     */
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * VARIAVEIS DE CONTROLO DE DATAS
         */
        @Data(size=10, value=" ")
        IString wsDataInicio() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        /**
         * VARIAVEIS DE CONTROLO DE ACESSOS A TABELAS
         */
        @Data(size=1, value=" ")
        IString wsChave() ;
        
        @Data(size=6, value="0")
        IInt wsTotVgh00201Upd() ;
        
        @Data(size=6, value="0")
        IInt wsTotVgh10201Upd() ;
        
        @Data(size=8, value=" ")
        IString wsNomeTabela() ;
        
        @Data(size=8, value=" ")
        IString wsNomeRotina() ;
        
        /**
         * VARIAVEIS DE CONTROLO DE ERROS
         */
        @Data(size=2, value=" ")
        IString wsErroDb2() ;
        
        @Data(size=8, value=" ")
        IString wsNmTabela() ;
        
        @Data(size=8, value=" ")
        IString wsNmFicheiro() ;
        
        @Data(size=8, value=" ")
        IString wsNmRotina() ;
        
        @Data(size=6, value="0")
        IInt wsAcessos() ;
        
        @Data(size=10, value=" ")
        IString wsDataAnalisar() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        @Data(size=3, signed=true, value="0")
        IInt wsCSqlcode() ;
        
        @Data(size=2, value=" ")
        IString wsCTipoErroBbn() ;
        
        @Data(size=100, value=" ")
        IString wsDadosEntrada() ;
        
        @Data(size=50, value=" ")
        IString wsChAcesso() ;
        
        @Data(size=16, value=" ")
        IString wsObs() ;
        
        @Data(size=40, value=" ")
        IString wsObserv() ;
        
        /**
         * VARIAVEIS DE CONTROLO DE ACESSOS A ROTINAS
         */
        @Data(size=6, value="0")
        IInt wsQAcesRtnaMhtq200a() ;
        
        @Data(size=20, value=" ")
        IString wsChAcessoVgh00201() ;
        
        @Data(size=20, value=" ")
        IString wsChAcessoVgh10201() ;
        
        /**
         * CONTADORES DE ESTATITISTICAS (FICHEIRO DE INPUT 1)
         */
        @Data(size=10, value="0")
        ILong wsTotOpenFwk049() ;
        
        @Data(size=10, value="0")
        ILong wsTotReadFwk049() ;
        
        @Data(size=10, value="0")
        ILong wsTotCloseFwk049() ;
        
        @Data(size=10, value="0")
        ILong wsNumRegFwk049() ;
        
        /**
         * MANIPULACAO DE FICHEIROS
         */
        @Data(size=8, value=" ")
        IString wsNomeFicheiro() ;
        
        @Data(size=2, value=" ")
        IString wsAccaoFicheiro() ;
        
        @Data(size=2, value=" ")
        IString wsStatusFicheiro() ;
        
        /**
         * SUBSTITUIR COM OS CAMPOS CHAVE DA TABELA
         */
        @Data(size=18, value=" ")
        IString wsCampo1() ;
        
        @Data(size=18, value=" ")
        IString wsCampo2() ;
        
        /**
         * @return instancia da classe local WsRearranque
         */
        @Data
        WsRearranque wsRearranque() ;
        
        
        public interface WsRearranque extends IDataStruct {
            
            @Data(size=15, value="0", rpadding=235)
            ILong wsNumRegRearran001() ;
            
        }
    }
    
}
