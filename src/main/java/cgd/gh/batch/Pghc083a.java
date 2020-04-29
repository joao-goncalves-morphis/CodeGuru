package cgd.gh.batch;

import static morphis.framework.commons.DateTimeHandling.* ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
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
import cgd.gh.structures.work.Bghw8701 ;
import cgd.gh.structures.work.Bghr0701 ;
import cgd.ht.structures.work.Bhtr0111 ;
import cgd.ht.structures.work.Bhtw1013 ;
import cgd.ht.structures.work.Bhtw0015 ;
import cgd.ht.structures.work.Bhtw0013 ;
import cgd.ht.common.constants.Bhtk0002 ;


/**
 * 
 * DEFINICAO DA CLAUSULA FD DO FICHEIRO DE OUTPUT FGH070
 * WORKING-STORAGE SECTION
 * 
 * @version 2.0
 * 
 */
public abstract class Pghc083a extends CgdGhBaseBatch {
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
     * @return instancia da classe Fwk702
     */
    @Handler(name="FWK702", record="statusFwk702")
    @Data
    protected abstract Fwk702 ficheiroFwk702() ;
    
    /**
     * @return instancia da classe Fgh070
     */
    @Handler(name="FGH070", record="regFgh070382")
    @Data
    protected abstract Fgh070 ficheiroFgh070() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bghw8701
     */
    @Data
    protected abstract Bghw8701 bghw8701() ;
    
    /**
     * @return instancia da classe Bghr0701
     */
    @Data
    protected abstract Bghr0701 bghr0701() ;
    
    /**
     * @return instancia da classe Bhtr0111
     */
    @Data
    protected abstract Bhtr0111 bhtr0111() ;
    
    /**
     * @return instancia da classe Bhtw1013
     */
    @Data
    protected abstract Bhtw1013 bhtw1013() ;
    
    /**
     * @return instancia da classe Bhtw0015
     */
    @Data
    protected abstract Bhtw0015 bhtw0015() ;
    
    /**
     * @return instancia da classe Bhtw0013
     */
    @Data
    protected abstract Bhtw0013 bhtw0013() ;
    
    /**
     * @return instancia da classe Bhtk0002
     */
    @Data
    protected abstract Bhtk0002 bhtk0002() ;
    
    /**
     * ----- FICHEIROS
     */
    protected static final String CON_OPEN_INPUT = "OI" ;
    
    protected static final String CON_OPEN_OUTPUT = "OO" ;
    
    protected static final String CON_READ = "RE" ;
    
    protected static final String CON_WRITE = "WR" ;
    
    protected static final String CON_CLOSE_FI = "CF" ;
    
    protected static final String CON_FWK702 = "FWK702" ;
    
    protected static final String CON_ERRO_FWK702 = "ERRO FIC. FWK702" ;
    
    protected static final String CON_FGH070 = "FGH070" ;
    
    protected static final String CON_ERRO_FGH070 = "ERRO FIC. FGH070" ;
    
    /**
     * ----- ROTINAS
     * ****              CONSTANTES NUMERICAS                    ****
     */
    protected static final double CON_EUR = 200.482 ;
    
    /**
     * ****              CONSTANTES ALFANUMERICAS                ****
     */
    protected static final String CON_PROGRAMA = "PGHC083A" ;
    
    /**
     * PREENCHER CONTEUDO DA VARIAVEL COM A DESCRICAO DA FUNCAO DO
     * PROGRAMA
     */
    protected static final String CON_DESCRICAO = "CONVERTE FWK701 PARA LAYOUT MOVIMENTOS SGOP" ;
    
    /**
     * @return instancia da classe local WsVariaveis
     */
    @Data
    protected abstract WsVariaveis wsVariaveis() ;
    
    /**
     * SWITCHES
     * @return instancia da classe local SwSwitches
     */
    @Data
    protected abstract SwSwitches swSwitches() ;
    
    
    
    /**
     * 
     * ARQUITECTURA
     * PROCEDURE: BHTP0013.
     * -CONTEM CODIGO NECESSARIO PARA GESTAO DE INFORMACAO A
     * ESCREVER NO FICH. DE ESTAT. BATCH.
     * 
     */
    protected void bhtp0013InicioEstat() {
        bhtw1013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhtw1013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxAno());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxMes());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zInicPrct().set(bhtw1013().dadosAuxiliares().dataAux2());
        bhtw0033().dadosGerais().nmPrograma().set(bhtw1013().dadosInput().nmPrograma());
        bhtw0033().dadosGerais().dFunlPrg().set(bhtw1013().dadosInput().dFunlPrg());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2H().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxH());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2M().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxM());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2S().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hInicPrct().set(bhtw1013().dadosAuxiliares().horaAux2());
        bhtw1013().dadosAuxiliares().qAces().set(1);
    }
    
    /**
     * 
     * BHTP0013-FORMATA-ACESSO
     * 
     */
    protected void bhtp0013FormataAcesso() {
        bhtw1013().dadosAuxiliares().tiAcesso().resetIndex() ;
        while (bhtw1013().dadosAuxiliares().tiAcesso().index().isLessOrEqual(99)) {
            if ((bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_FICHEIRO) && 
                bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmFicheiro()) && 
                bhtw1013().dadosInput().dadosFicheiro().cTipoOpeFich().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeFich()) && 
                bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCFsttCobl())) || 
                (bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_TABELA) && 
                bhtw1013().dadosInput().dadosTabela().nmTabela().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmTabela()) && 
                bhtw1013().dadosInput().dadosTabela().cTipoOpeObjDb2().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoOpeObjDb2()) && 
                bhtw1013().dadosInput().dadosTabela().cSqlcode().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCSqlcode())) || 
                (bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot()) && 
                bhtw1013().dadosInput().tabFichRot().isEqual(bhtw1013().BHTW1013_CON_ROTINA) && 
                bhtw1013().dadosInput().dadosRotinas().nmRotina().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiNmRotina()) && 
                bhtw1013().dadosInput().dadosRotinas().iOperacao().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiIOperacao()) && 
                bhtw1013().dadosInput().dadosRotinas().cTipoErroBbn().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCTipoErroBbn()) && 
                bhtw1013().dadosInput().dadosRotinas().cRtnoEvenSwal().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiCRtnoEvenSwal()) && 
                bhtw1013().dadosInput().dadosRotinas().aAplErr().isEqual(bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiAAplErr()))) {
                bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().add(bhtw1013().dadosAuxiliares().qAces());
                break;
            }
            if (bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiTabFichRot().isEmpty()) {
                break;
            }
            bhtw1013().dadosAuxiliares().tiAcesso().incIndex() ;
        }
    }
    
    /**
     * 
     * BHTP0013-CRIA-REGISTO
     * 
     */
    protected void bhtp0013CriaRegisto() {
        bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().initialize() ;
        bhtw1013().dadosAuxiliares().tiAcesso().getCurrent().tiQAces().set(bhtw1013().dadosAuxiliares().qAces());
    }
    
    /**
     * 
     * BHTP0013-FIM-ESTATISTICA
     * 
     */
    protected void bhtp0013FimEstatistica() {
        bhtw1013().dadosAuxiliares().dataAux().set(getDate()) ;
        bhtw1013().dadosAuxiliares().horaAux().set(getTime()) ;
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Sec().set("20");
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Ano().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxAno());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Mes().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxMes());
        bhtw1013().dadosAuxiliares().dataAux2().dataAux2Dia().set(bhtw1013().dadosAuxiliares().dataAux().dataAuxDia());
        bhtw0033().dadosGerais().zFimPrct().set(bhtw1013().dadosAuxiliares().dataAux2());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2H().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxH());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2M().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxM());
        bhtw1013().dadosAuxiliares().horaAux2().horaAux2S().set(bhtw1013().dadosAuxiliares().horaAux().horaAuxS());
        bhtw0033().dadosGerais().hFimPrct().set(bhtw1013().dadosAuxiliares().horaAux2());
        bhtw1013().dadosAuxiliares().tiAcesso().resetIndex() ;
    }
    
    /**
     * 
     * BHTP0013-DETALHE-ESTAT
     * 
     */
    protected void bhtp0013DetalheEstat() {
        bhtw1013().dadosAuxiliares().tiAcesso().incIndex() ;
    }
    
    /**
     * 
     * COPY DE FORMATACAO E OBTENCAO DE DATAS DE SISTEMA.
     * OBTEM A DATA DE SISTEMA COM SECULO E DISPONIBILIZA-A COM E SEM
     * FORMATACAO.
     * INSTRUCOES DE UTILIZACAO.
     * PERFORM BHTP0015-CURRENT-DATE
     * THRU BHTP0015-CURRENT-DATE-EXIT.
     * FINALMENTE, MOVER AS VARIAVEIS DE OUTPUT PARA A AREA QUE SE
     * PRETENDE. POR EXEMPLO A WS-DATA-INI.
     * MOVE BHTW0015-DATE-FRM         TO WS-DATA-INI.
     * (FORMATO DATE YYYY-MM-DD)
     * MOVE BHTW0015-TIME-FRM         TO WS-HORA-INI.
     * (FORMATO TIME HH:MM:SS)
     * OU
     * MOVE BHTW0015-TMST-FRM         TO WS-CURRENT-TIMESTAMP.
     * (FORMATO TIMESTAMP 26 YYYY-MM-DD-HH.MM.SS.SSSSSS)
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
     * 0000-MAINLINE
     * 
     */
    protected void m0000Mainline() {
        log(TraceLevel.Debug, "0000-MAINLINE");
        m1000InicioPrograma() ;
        while (!ficheiroFwk702().getStatusOk()) {
            m2000ProcessoPrograma() ;
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
        m1100Inicializacoes() ;
        bhtp0011ObtemDados() ;
        m1200AbreEstatistica() ;
        m8000DataHoraIni() ;
        m1400AbreFicheiros() ;
        m1500LeFwk702() ;
    }
    
    /**
     * 
     * 1100-INICIALIZACOES
     * 
     */
    protected void m1100Inicializacoes() {
        log(TraceLevel.Debug, "1100-INICIALIZACOES");
        wsVariaveis().initialize() ;
        bghw8701().registo().initialize() ;
        bghr0701().fgh070Registo().initialize() ;
    }
    
    /**
     * 
     * 1200-ABRE-ESTATISTICA
     * 
     */
    protected void m1200AbreEstatistica() {
        log(TraceLevel.Debug, "1200-ABRE-ESTATISTICA");
        bhtw1013().dadosInput().nmPrograma().set(CON_PROGRAMA);
        bhtw1013().dadosInput().dFunlPrg().set(CON_DESCRICAO);
        bhtp0013InicioEstat() ;
    }
    
    /**
     * 
     * 1400-ABRE-FICHEIROS
     * 
     */
    protected void m1400AbreFicheiros() {
        log(TraceLevel.Debug, "1400-ABRE-FICHEIROS");
        ficheiroFwk702().open() ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK702);
        bhtw1013().dadosInput().dadosFicheiro().swOpenIn().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk702().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFwk702().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_OPEN_INPUT);
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK702);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk702().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FWK702);
            m9100TrataErroFich() ;
        }
        ficheiroFgh070().open(CREATE ) ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH070);
        bhtw1013().dadosInput().dadosFicheiro().swOpenOut().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh070().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFgh070().getStatusOk()) {
            bhtw0030().dadosEntrada().cTipoOpeObjDb2().set(CON_OPEN_OUTPUT);
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH070);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh070().getStatus());
            bhtw0030().dadosEntrada().xSugRtnoSwal().set(CON_ERRO_FGH070);
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 1500-LE-FWK702
     * 
     */
    protected void m1500LeFwk702() {
        log(TraceLevel.Debug, "1500-LE-FWK702");
        bghw8701().registo().initialize() ;
        ficheiroFwk702().read(bghw8701().registo()) ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK702);
        bhtw1013().dadosInput().dadosFicheiro().swReadSeq().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk702().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFwk702().getStatusOk()) {
            if (!ficheiroFwk702().getStatusOk()) {
                bhtw0030().dadosEntrada().xSugRtnoSwal().set("1500-LE-FWK702");
                bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK702);
                bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk702().getStatus());
                m9100TrataErroFich() ;
            }
        }
    }
    
    /**
     * 
     * 2000-PROCESSO-PROGRAMA
     * 
     */
    protected void m2000ProcessoPrograma() {
        log(TraceLevel.Debug, "2000-PROCESSO-PROGRAMA");
        m2100FormataFgh070() ;
        m2200EscreveFgh070() ;
        m1500LeFwk702() ;
    }
    
    /**
     * 
     * 2100-FORMATA-FGH070
     * 
     */
    protected void m2100FormataFgh070() {
        log(TraceLevel.Debug, "2100-FORMATA-FGH070");
        bghr0701().fgh070Registo().initialize() ;
        bghr0701().fgh070Registo().fgh070CCcmz().set(bghw8701().registo().xInfPend().cCcmz());
        bghr0701().fgh070Registo().fgh070CCcmzApoi().set(0);
        bghr0701().fgh070Registo().fgh070CTerminal().set(bghw8701().registo().xInfPend().cTerminal());
        wsVariaveis().wsTimestampNumAux().set(bghw8701().registo().xInfPend().tsPndeX().tsPnde());
        wsVariaveis().wsTimestampNum().set(wsVariaveis().wsTimestampNumAux());
        wsVariaveis().wsTimestampAlf().wsAnoAlf().set(wsVariaveis().wsTimestampNum().wsAnoNum());
        wsVariaveis().wsTimestampAlf().wsMesAlf().set(wsVariaveis().wsTimestampNum().wsMesNum());
        wsVariaveis().wsTimestampAlf().wsDiaAlf().set(wsVariaveis().wsTimestampNum().wsDiaNum());
        wsVariaveis().wsTimestampAlf().wsHhAlf().set(wsVariaveis().wsTimestampNum().wsHhNum());
        wsVariaveis().wsTimestampAlf().wsMinAlf().set(wsVariaveis().wsTimestampNum().wsMinNum());
        wsVariaveis().wsTimestampAlf().wsSegAlf().set(wsVariaveis().wsTimestampNum().wsSegNum());
        wsVariaveis().wsTimestampNum().wsMilNum().set(0);
        wsVariaveis().wsTimestampAlf().wsMilAlf().set(wsVariaveis().wsTimestampNum().wsMilNum());
        bghr0701().fgh070Registo().fgh070TsTransaccao().set(wsVariaveis().wsTimestampAlf());
        bghr0701().fgh070Registo().fgh070AAplicacao().set("JF");
        bghr0701().fgh070Registo().fgh070CBanco().set(bghw8701().registo().conta().cBanco());
        bghr0701().fgh070Registo().fgh070CCcmzAtrx().set(0);
        /**
         * MOVE BGHW8701-C-MOED-ISO      TO FGH070-C-MOED-ISO.
         */
        bghr0701().fgh070Registo().fgh070CMoedIso().set("PTE");
        bghr0701().fgh070Registo().fgh070CMoedIsoMov().set(bghw8701().registo().xInfPend().cMoedIsoMov());
        bghr0701().fgh070Registo().fgh070CMtvoMov().set(0);
        bghr0701().fgh070Registo().fgh070COeGerx().set(0);
        bghr0701().fgh070Registo().fgh070COperador().set(0);
        bghr0701().fgh070Registo().fgh070COpexAtrx().set(0);
        bghr0701().fgh070Registo().fgh070CServPrsdCgd().set(0);
        bghr0701().fgh070Registo().fgh070CTaxaJcrx().set(0);
        bghr0701().fgh070Registo().fgh070CTaxaJdvx().set(0);
        bghr0701().fgh070Registo().fgh070CTaxaJmba().set(0);
        bghr0701().fgh070Registo().fgh070CTaxaNgcdJcrx().set(0);
        bghr0701().fgh070Registo().fgh070CTaxaNgcdJdvx().set(0);
        bghr0701().fgh070Registo().fgh070CTaxaNgcdMoba().set(0);
        bghr0701().fgh070Registo().fgh070CTransaccao().set(bghw8701().registo().xInfPend().cTransaccao());
        bghr0701().fgh070Registo().fgh070DMovOpps().set(bghw8701().registo().xInfPend().dPnde());
        bghr0701().fgh070Registo().fgh070DTransaccao().set(bghw8701().registo().xInfPend().dTransaccao());
        bghr0701().fgh070Registo().fgh070CClasTrnz().set(" ");
        bghr0701().fgh070Registo().fgh070IEstorno().set(bghw8701().registo().xInfPend().iEstorno());
        bghr0701().fgh070Registo().fgh070ILnctTot().set(" ");
        bghr0701().fgh070Registo().fgh070IMovEfcdOnln().set(" ");
        bghr0701().fgh070Registo().fgh070ITipoDocOpps().set(" ");
        bghr0701().fgh070Registo().fgh070ITipoSltx().set(" ");
        bghr0701().fgh070Registo().fgh070MComsMoba().set(0);
        bghr0701().fgh070Registo().fgh070MIs().set(0);
        bghr0701().fgh070Registo().fgh070MJcrx().set(0);
        bghr0701().fgh070Registo().fgh070MJdvx().set(0);
        bghr0701().fgh070Registo().fgh070MJcmg().set(0);
        bghr0701().fgh070Registo().fgh070MJmorSdvx().set(0);
        bghr0701().fgh070Registo().fgh070MImposto().set(0);
        bghr0701().fgh070Registo().fgh070MMovCtrv().set(bghw8701().registo().xInfPend().mMovCtrv());
        bghr0701().fgh070Registo().fgh070MMovDep().set(bghw8701().registo().xInfPend().mMovCtrv());
        /**
         * MOVE BGHW8701-M-PNDE          TO FGH070-M-MOV-DEP.
         */
        bghr0701().fgh070Registo().fgh070MMovMoba().set(0);
        bghr0701().fgh070Registo().fgh070MMovSldoDevx().set(0);
        bghr0701().fgh070Registo().fgh070MJmba().set(0);
        bghr0701().fgh070Registo().fgh070MSldoCbloCtrv().set(bghw8701().registo().xInfPend().mSldoCbloCtrv());
        bghr0701().fgh070Registo().fgh070MSldoCbloApos().set(bghw8701().registo().xInfPend().mSldoCbloCtrv());
        bghr0701().fgh070Registo().fgh070MSldoDpnlApos().set(bghw8701().registo().xInfPend().mSldoCbloCtrv());
        bghr0701().fgh070Registo().fgh070MJuroPago().set(0);
        /**
         * MOVE BGHW8701-M-SLDO-CBLO-APOS
         * TO FGH070-M-SLDO-CBLO-APOS.
         * MOVE BGHW8701-M-SLDO-DPNL-APOS
         * TO FGH070-M-SLDO-DPNL-APOS.
         */
        bghr0701().fgh070Registo().fgh070NsDeposito().set(bghw8701().registo().conta().nsDeposito());
        bghr0701().fgh070Registo().fgh070NConta().set(bghw8701().registo().conta().nConta());
        bghr0701().fgh070Registo().fgh070NDocOppsMov().set(bghw8701().registo().xInfPend().nDocOppsMov());
        bghr0701().fgh070Registo().fgh070NSessAtmCgd().set(0);
        bghr0701().fgh070Registo().fgh070NSessSibs().set(0);
        bghr0701().fgh070Registo().fgh070MPremio().set(0);
        bghr0701().fgh070Registo().fgh070MDespesa().set(0);
        bghr0701().fgh070Registo().fgh070MJuroCpst().set(0);
        bghr0701().fgh070Registo().fgh070TsMovAnt().set(" ");
        wsVariaveis().wsDataValorAux().set(bghw8701().registo().xInfPend().zValMov());
        wsVariaveis().wsDataValorAux2().set(wsVariaveis().wsDataValorAux());
        wsVariaveis().wsDataValor().wsAnoVal().set(wsVariaveis().wsDataValorAux2().wsAnoValAux2());
        wsVariaveis().wsDataValor().wsMesVal().set(wsVariaveis().wsDataValorAux2().wsMesValAux2());
        wsVariaveis().wsDataValor().wsDiaVal().set(wsVariaveis().wsDataValorAux2().wsDiaValAux2());
        bghr0701().fgh070Registo().fgh070ZValMov().set(wsVariaveis().wsDataValor());
        bghr0701().fgh070Registo().fgh070TsMovimento().set(wsVariaveis().wsTimestampAlf());
    }
    
    /**
     * 
     * 2200-ESCREVE-FGH070
     * 
     */
    protected void m2200EscreveFgh070() {
        log(TraceLevel.Debug, "2200-ESCREVE-FGH070");
        ficheiroFgh070().write(ficheiroFgh070().regFgh070382) ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH070);
        bhtw1013().dadosInput().dadosFicheiro().swWrite().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh070().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFgh070().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("2200-ESCREVE-FGH070");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH070);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh070().getStatus());
            m9100TrataErroFich() ;
        }
    }
    
    /**
     * 
     * 3000-FIM-PROGRAMA
     * 
     */
    protected void m3000FimPrograma() {
        log(TraceLevel.Debug, "3000-FIM-PROGRAMA");
        m3100FechaFicheiros() ;
        bhtp0013FimEstatistica() ;
    }
    
    /**
     * 
     * 3100-FECHA-FICHEIROS
     * 
     */
    protected void m3100FechaFicheiros() {
        log(TraceLevel.Debug, "3100-FECHA-FICHEIROS");
        ficheiroFwk702().close() ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FWK702);
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFwk702().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFwk702().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FWK702);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFwk702().getStatus());
            m9100TrataErroFich() ;
        }
        ficheiroFgh070().close() ;
        bhtw1013().dadosInput().ficheiro().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().swCloseFich().setTrue() ;
        bhtw1013().dadosInput().dadosFicheiro().nmFicheiro().set(CON_FGH070);
        bhtw1013().dadosInput().dadosFicheiro().cFsttCobl().set(ficheiroFgh070().getStatus());
        bhtp0013FormataAcesso() ;
        if (!ficheiroFgh070().getStatusOk()) {
            bhtw0030().dadosEntrada().xSugRtnoSwal().set("3100-FECHA-FICHEIROS");
            bhtw0030().dadosEntrada().nmFicheiro().set(CON_FGH070);
            bhtw0030().dadosEntrada().cFsttCobl().set(ficheiroFgh070().getStatus());
            bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
            m9100TrataErroFich() ;
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
     * 9100-TRATA-ERRO-FICH
     * ANTES DA CHAMADA A ESTE PARAGRAFO DEVEM SER FORMATADA AS SE-
     * GUINTES VARIAVEIS:
     * BHTW0030-C-TIPO-OPE-OBJ-DB2 :  CONFORME A OPERACAO EFECTUADA:
     * CON-OPEN-INPUT
     * CON-OPEN-OUTPUT
     * CON-OPEN-EXTEND
     * CON-READ
     * CON-WRITE
     * CON-CLOSE-FI
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
        bhtw0030().dadosEntrada().abendFicheiro().setTrue() ;
        bhtp0013FimEstatistica() ;
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
         * FECHAR OS FICHEIROS INPUT/OUTPUT DO PROGRAMA
         */
        ficheiroFwk702().close() ;
        ficheiroFgh070().close() ;
        bhtw0013().erro().setTrue() ;
        setReturnCode(bhtw0013().returnCode()) ;
        /**
         * FORMATACAO DE RETURN-CODE
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
    public interface WsVariaveis extends IDataStruct {
        
        /**
         * ****             TOTALIZADORES DE ACESSO                  ****
         * CRIAR AS VARIAVEIS PARA A TOTALIZACAO DE ACESSOS /
         * DEIXAR APENAS AQUELAS QUE TEM USO NO PROGRAMA
         */
        @Data(size=15, value="0")
        ILong wsTotOpenFwk702() ;
        
        @Data(size=15, value="0")
        ILong wsTotReadFwk702() ;
        
        @Data(size=15, value="0")
        ILong wsTotCloseFwk702() ;
        
        @Data(size=15, value="0")
        ILong wsTotOpenFgh070() ;
        
        @Data(size=15, value="0")
        ILong wsTotWriteFgh070() ;
        
        @Data(size=15, value="0")
        ILong wsTotCloseFgh070() ;
        
        /**
         * ****                  DATA E HORA                         ****
         */
        @Data(size=8, value=" ")
        IString wsHoraIni() ;
        
        @Data(size=8, value=" ")
        IString wsHoraFim() ;
        
        @Data(size=10, value=" ")
        IString wsDataIni() ;
        
        @Data(size=10, value=" ")
        IString wsDataFim() ;
        
        @Data(size=26, value=" ")
        IString wsTimestamp() ;
        
        /**
         * ****          VARIAVEIS DE UTILIZACAO GERAL               ****
         */
        @Data(size=14)
        ILong wsTimestampNumAux() ;
        
        @Data(size=8)
        ILong wsDataValorAux() ;
        
        /**
         * @return instancia da classe local WsTimestampNum
         */
        @Data
        WsTimestampNum wsTimestampNum() ;
        
        /**
         * @return instancia da classe local WsTimestampAlf
         */
        @Data
        WsTimestampAlf wsTimestampAlf() ;
        
        /**
         * @return instancia da classe local WsDataValorAux2
         */
        @Data
        WsDataValorAux2 wsDataValorAux2() ;
        
        /**
         * @return instancia da classe local WsDataValor
         */
        @Data
        WsDataValor wsDataValor() ;
        
        
        public interface WsTimestampNum extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsAnoNum() ;
            
            @Data(size=2, value="0")
            IInt wsMesNum() ;
            
            @Data(size=2, value="0")
            IInt wsDiaNum() ;
            
            @Data(size=2, value="0")
            IInt wsHhNum() ;
            
            @Data(size=2, value="0")
            IInt wsMinNum() ;
            
            @Data(size=2, value="0")
            IInt wsSegNum() ;
            
            @Data(size=6, value="0")
            IInt wsMilNum() ;
            
        }
        
        public interface WsTimestampAlf extends IDataStruct {
            
            @Data(size=4, value=" ")
            IString wsAnoAlf() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
            IString wsMesAlf() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
            IString wsDiaAlf() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
            IString wsHhAlf() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
            IString wsSegAlf() ;
            
            @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
            IString wsMinAlf() ;
            
            @Data(size=6, value=" ", lpadding=1, lpaddingValue=".")
            IString wsMilAlf() ;
            
        }
        
        public interface WsDataValorAux2 extends IDataStruct {
            
            @Data(size=4, value="0")
            IInt wsAnoValAux2() ;
            
            @Data(size=2, value="0")
            IInt wsMesValAux2() ;
            
            @Data(size=2, value="0")
            IInt wsDiaValAux2() ;
            
        }
        
        public interface WsDataValor extends IDataStruct {
            
            @Data(size=4, value="0")
            IString wsAnoVal() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IString wsMesVal() ;
            
            @Data(size=2, value="0", lpadding=1, lpaddingValue="-")
            IString wsDiaVal() ;
            
        }
    }
    
    /**
     * 
     * SWITCHES
     * 
     * @version 2.0
     * 
     */
    public interface SwSwitches extends IDataStruct {
        
        /**
         * ----- FICHEIROS
         */
        @Data(size=2, value="00")
        IString statusFhy003() ;
        @Data
        @Condition("00")
        ICondition swFhy003Ok() ;
        @Data
        @Condition("10")
        ICondition swFhy003Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFwk702() ;
        @Data
        @Condition("00")
        ICondition swFwk702Ok() ;
        @Data
        @Condition("10")
        ICondition swFwk702Fim() ;
        
        
        @Data(size=2, value="00")
        IString statusFgh070() ;
        @Data
        @Condition("00")
        ICondition swFgh070Ok() ;
        @Data
        @Condition("10")
        ICondition swFgh070Fim() ;
        
        
    }
    
}
